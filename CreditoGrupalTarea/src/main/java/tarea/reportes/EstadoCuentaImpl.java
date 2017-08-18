package tarea.reportes;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import mx.com.findep.depositosgarantia.ws.DepositosGarantiaWS_ServiceLocator;
import mx.com.findep.depositosgarantia.ws.MovimientosGarantiaPeticion;

import org.apache.ibatis.session.SqlSession;
import org.osoa.sca.annotations.Reference;
import org.osoa.sca.annotations.Scope;

import tarea.comun.ComunTarea;
import tarea.comun.ReadProperties;
import transformador.Transformador;
import utilitario.comun.asesores.AsesorOV;
import utilitario.log.LogHandler;
import utilitario.mensajes.comun.AmortizacionActualOV;
import utilitario.mensajes.comun.AmortizacionOV;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.impresiondocs.comun.MiembroGrupoVO;
import utilitario.mensajes.originacion.consulta.ParGeneralOV;
import utilitario.mensajes.reportes.comun.CreditoGrupalOV;
import utilitario.mensajes.reportes.comun.CreditoOV;
import utilitario.mensajes.reportes.comun.DepositosGarantiaRespuestaOV;
import utilitario.mensajes.reportes.comun.DepositosGarantiaOV;
import utilitario.mensajes.reportes.comun.MovimientoDetalleDepgar;
import utilitario.mensajes.reportes.comun.MovimientoGarantiaOV;
import utilitario.mensajes.reportes.comun.ObtenerEstadoCuenta;
import utilitario.mensajes.reportes.comun.PagoOV;
import utilitario.mensajes.reportes.comun.ResumenSaldoOV;
import utilitario.mensajes.reportes.comun.StatusDepGar;
import utilitario.mensajes.reportes.estadocuenta.EstadoCuentaMontos;
import utilitario.mensajes.reportes.estadocuenta.EstadoCuentaPeticion;
import utilitario.mensajes.reportes.estadocuenta.EstadoCuentaRespuesta;
import entidad.asesores.data.AsesorData;
import entidad.conexiones.FabricaConexiones;


@Scope("COMPOSITE")
public class EstadoCuentaImpl implements EstadoCuenta {

	/**
	 * SCA
	 */
	private ComunTarea comun;
	/**
	 * Variable transformador
	 */
	private Transformador transformador;

	/**
	 * @param comun JCA
	 * @param transformador JCA
	 */
	public EstadoCuentaImpl(  @Reference( name = "comun" ) ComunTarea comun,
							  @Reference(name = "transformador") Transformador transformador) {
		this.comun = comun;
		this.transformador = transformador;
	}

	/**
	 * Recibe una peticion del estado de cuenta.
	 * @param cuenta EstadoCuentaPeticion
	 * @param uid identificador del log
	 * @return EstadoCuentaRespuesta
	 */
	public EstadoCuentaRespuesta obtenerEstadoCuenta(String uid, EstadoCuentaPeticion cuenta) {
		LogHandler.debug( uid, getClass(), "Entro a obtenerEstadoCuenta ==> EstadoCuenta");
		String numeroCuenta = cuenta.getNumeroCuenta();
		LogHandler.debug( uid, getClass(), "OBTENGO NUMERO DE CUENTA: " + numeroCuenta);
		//instancia para enviar la respuesta final
		EstadoCuentaRespuesta respuesta = new EstadoCuentaRespuesta();
		respuesta.setEncabezado(new EncabezadoRespuesta());
		respuesta.getEncabezado().setUID(uid);
		try {
			if ((cuenta.getNumeroCuenta() == null || cuenta.getNumeroCuenta().isEmpty())
					&& (cuenta.getSolicitud() == null || cuenta.getSolicitud().isEmpty())) {
				throw new Exception( ReadProperties.mensajes.getProp( "reportes.obtenerestadocuenta.errorcontratosucursal" ) );
			}

			if (cuenta.getSolicitud() == null) {
				cuenta.setSolicitud("");
			}

			//Se realiza la validacion para la relacion de sucursal-contrato
			if (cuenta.getNumeroCuenta() != null && cuenta.getSucursal() != null && cuenta.getSucursal() != 0
					&& cuenta.getSucursal() != 120 ) {
				final java.util.HashMap<String, Object>
								parametros = new java.util.HashMap<String, Object>();
								parametros.put("contrato", cuenta.getNumeroCuenta());
								parametros.put("sucursal", cuenta.getSucursal());

				if ( !comun.comprobarContratoSucursal( uid, parametros ) ) {
						throw new Exception( ReadProperties.mensajes.getProp(
								"reportes.obtenerestadocuenta.errorcontratosucursal" ) );
					}
				}

			//Si trae numero de solicitud se obtiene su numero de contrato y se la asigna a la variable "numeroCuenta"
			if (!cuenta.getSolicitud().isEmpty()) {

				numeroCuenta = comun.obtenerContratoPorSolicitud(uid, cuenta.getSolicitud());

				if ( numeroCuenta == null || numeroCuenta.trim().equals( "" )) {
					throw new Exception("No se encontro el contrato con la solicitud buscada ");
				}
			}

			CreditoOV credito = obtenerCredito(uid, numeroCuenta);
			LogHandler.debug( uid, getClass(), "informacion del credito --> " + credito);
			if (credito == null ) {
				throw new Exception( ReadProperties.mensajes.getProp( "reportes.obtenerestadocuenta.errorcontratosucursal" ) );
			}

			//Dia de pago
			final HashMap<String, Object>
					datosCredito = comun.obtenerDatosGeneralesContrato(uid, comun.obtenerNumeroContrato( uid, numeroCuenta ) );
			LogHandler.debug( uid, getClass(), "informacion del datosCredito --> " + datosCredito);
			final 	Calendar calendar = Calendar.getInstance();
			try {
				calendar.setTime( ( new SimpleDateFormat( "yyyy-MM-dd" )).parse(
									datosCredito.get( "fecha_ancla_pago" ).toString() ) );
				credito.setDiaPago( calendar.get( Calendar.DAY_OF_WEEK ) - 1 );
				}
			catch ( Exception exception ) {
				credito.setDiaPago( 0 );
				}

			if (credito != null && !credito.getCodigo().equals( -1 ))  {
					respuesta.setDatosCredito(credito);
			}
			else {
				throw new Exception( credito.getMensaje() );
			}

			CreditoGrupalOV grupo = creditoGrupo(uid, numeroCuenta);
			if (grupo == null) {
				throw new Exception(ReadProperties.mensajes.getProp("reportes.obtenerestadocuenta.errorgrupoinexistente"));
			}
			LogHandler.debug( uid, getClass(), "informacion del grupo --> " + grupo);
			List<MiembroGrupoVO> integrantes = integrantesGrupo(uid, numeroCuenta); //consultaDatosIntegrantes
			if (integrantes != null && !integrantes.isEmpty()) {
					grupo.setIntegrantes(integrantes.toArray(new MiembroGrupoVO[integrantes.size()]));
			}
			else {
				respuesta.getEncabezado().setMensaje("No existieron integrantes");
			}

			AsesorOV asesor = (AsesorOV) AsesorData.obtenAsesor( uid, grupo.getAsesor().trim() );
			grupo.setNombreAsesor( asesor != null ? asesor.getNombreCompleto() : " ASESOR NO ENCONTRADO " );

			if (grupo != null) {
				respuesta.setGrupo(grupo);
			}
			List<PagoOV> pagos = obtenerPagos(uid, numeroCuenta, cuenta.getMuestraCancelaciones()); //obtenerDetalleEstadoDeCuenta
			if (pagos != null && !pagos.isEmpty()) {
				respuesta.setMovimientos(pagos.toArray(new PagoOV[pagos.size()]));
			}
			List<PagoOV> vencidos = obtenerVencidoEstadoCuenta(uid, numeroCuenta);
			if (vencidos != null && !vencidos.isEmpty()) {
				respuesta.setPagosVencidos(vencidos.toArray(new PagoOV[vencidos.size()]));
			}
			String domFis = obtenerUnidadEspecializada(uid, credito.getSucursal().toString());
			LogHandler.debug( uid, getClass(), "Domicilio Fiscal = " + domFis);
			if (domFis != null) {
				respuesta.setDomicilioFiscal(domFis);
			}
			List<AmortizacionOV> amortizacion = amortizacionGrupo(uid, numeroCuenta);
			if (amortizacion != null && !amortizacion.isEmpty()) {
				//respuesta.setTablaAmortizacion(amortizacion.toArray(new AmortizacionOV[amortizacion.size()]));
				LogHandler.debug( uid, getClass(), "<<<== Amortizacion anterior ==>>> \n" + amortizacion);
			}
			List<AmortizacionActualOV> amortizacionActual = amortizacionGrupoActual(uid, numeroCuenta);
			if (amortizacionActual != null && !amortizacionActual.isEmpty()) {
				respuesta.setTablaAmortizacion(amortizacionActual.toArray(new AmortizacionActualOV[amortizacionActual.size()]));
			}
			//Se recuperan los montos faltantes
			final EstadoCuentaMontos estadoCuentaMontos = recuperaMontosExtras(uid, numeroCuenta, credito);
			if (amortizacion != null && !amortizacion.isEmpty()) {
				respuesta.setMontosExtras( estadoCuentaMontos );
			}
			ResumenSaldoOV resumen = obtenerFinalEstadoCuenta(uid, numeroCuenta);
			if (resumen != null) {
				respuesta.setResumenSaldo(resumen);
				respuesta.getResumenSaldo().setMontoInteres(respuesta.getResumenSaldo().getIvaInteres()
						+ respuesta.getResumenSaldo().getInteres());
				respuesta.getResumenSaldo().setTotalDescGarantia(respuesta.getResumenSaldo().getTotal()
						- respuesta.getMontosExtras().getDepositoMontoGarantia());
			}
			// Se obtiene el detalle de movimientos del WS depositos en Garantia
			DepositosGarantiaRespuestaOV depositosGarantia = consultaDepositosGarantiaDetalle(uid, numeroCuenta);
			if (depositosGarantia != null && depositosGarantia.getStatus().isValor()) {
				LogHandler.debug( uid, getClass(), "Seteo de valores movimientos depositos en garantia ==> "
						+ depositosGarantia.getMovimientoGarantia().getMovimientos());
				DepositosGarantiaOV[] movimientosDepgar = new DepositosGarantiaOV[
				                       depositosGarantia.getMovimientoGarantia().getMovimientos().toArray().length];
				for (int i = 0; i < movimientosDepgar.length; i++) {
					DepositosGarantiaOV objetoTemporal = new DepositosGarantiaOV();
					objetoTemporal.setFecha(
							depositosGarantia.getMovimientoGarantia().getMovimientos().get(i).getFechaValor());
					objetoTemporal.setDescripcionCodigo(
							depositosGarantia.getMovimientoGarantia().getMovimientos().get(i).getDescripcionCodigo());
					objetoTemporal.setImporte(
							depositosGarantia.getMovimientoGarantia().getMovimientos().get(i).getImporte());
					objetoTemporal.setSaldo(
							depositosGarantia.getMovimientoGarantia().getMovimientos().get(i).getSaldoGarantia());
					movimientosDepgar[i] = objetoTemporal;
				}
				LogHandler.debug( uid, getClass(), "movimientos depositos garantia  ==> " + movimientosDepgar);
				respuesta.setDepositosGarantia(movimientosDepgar);
			} else {
				//throw new Exception("No se pudo obtener los movimientos deposito en garantia, "
				//					+ depositosGarantia.getStatus().getMensaje());
				if (depositosGarantia != null) {
					LogHandler.debug(uid, getClass(), "Respuesta depositosGarantia: "
							+ depositosGarantia.getStatus().getMensaje());
				} else {
					LogHandler.debug(uid, getClass(), "Respuesta depositosGarantia:  respuesta (null)");
				}
				respuesta.setDepositosGarantia(null);
			}

			//Seteo valores del nuevo Estado de cuenta

			//Informacion del Grupo
			if (grupo != null) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				if (respuesta.getDatosCredito().getFechaContrato() != null
						&& respuesta.getDatosCredito().getFechaHoy() != null) {
					respuesta.getGrupo().setPeriodo(sdf.format(respuesta.getDatosCredito().getFechaContrato())
							+ " - " + sdf.format(respuesta.getDatosCredito().getFechaHoy()));
				} else {
					respuesta.getGrupo().setPeriodo("-");
				}
				if (respuesta.getGrupo().getIntegrantes() != null) {
					respuesta.getGrupo().setNoIntegrantes(respuesta.getGrupo().getIntegrantes().length);
					String tempIntegrantes = "";
					for (int i = 0; i < respuesta.getGrupo().getIntegrantes().length; i++) {
						tempIntegrantes += respuesta.getGrupo().getIntegrantes()[i].getNombrec() + ", ";
					}
					if (tempIntegrantes.length() > 1) {
						tempIntegrantes = tempIntegrantes.substring(0, tempIntegrantes.length() - 2) + ".";
					}
					respuesta.getGrupo().setNombresIntegrantes(tempIntegrantes);
				} else {
					LogHandler.debug(uid, getClass(), "Respuesta depositosGarantia:  el contrato no contiene integrantes.");
					respuesta.getGrupo().setNoIntegrantes(0);
				}
			}
			//Informacion del contrato
			if (credito != null && !credito.getCodigo().equals( -1 ))  {
				respuesta.getDatosCredito().setComision(respuesta.getResumenSaldo().getComiciones());
				respuesta.getDatosCredito().setTasaOrdinariaMensual(
						Math.round((respuesta.getDatosCredito().getTasa() / 12) * 100.0) / 100.0);
				respuesta.getDatosCredito().setInteresOrdinario(respuesta.getMontosExtras().getInteresOrdinario());
				respuesta.getDatosCredito().setNumeroDevoluciones(respuesta.getMontosExtras().getChequeDevuelto());
				respuesta.getDatosCredito().setNuevoInteresOrdinario(respuesta.getMontosExtras().getNuevoInteresOrdinario());
				respuesta.getDatosCredito().setNuevoTotalPagar(respuesta.getMontosExtras().getNuevoInteresOrdinario()
						+ respuesta.getDatosCredito().getMontoReal());
				respuesta.getDatosCredito().setDepositoGarantia(respuesta.getMontosExtras().getDepositoMontoGarantia());
				respuesta.getDatosCredito().setTotalPagar(respuesta.getMontosExtras().getTotalAPagar());
				respuesta.getDatosCredito().setAjusteInteres(respuesta.getMontosExtras().getAjusteInteres());
			}

			//Numero de integrantes 0, cuando esta cancelado.
			if ( respuesta.getDatosCredito().getEstado().trim().equals("Cancelado")) {
				respuesta.getGrupo().setIntegrantes(null);
			}
		} catch (Exception e) {
			//e.printStackTrace();
			LogHandler.error(uid, getClass(), "Ocurrio un error en el metodo obtenerEstadoCuenta: " + e.getMessage(), e);
			respuesta = new EstadoCuentaRespuesta();
			respuesta.setEncabezado(new EncabezadoRespuesta());
			respuesta.getEncabezado().setUID(uid);
			respuesta.getEncabezado().setEstatus(false);
			respuesta.getEncabezado().setMensaje(e.getMessage());
		}
		return respuesta;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<PagoOV> obtenerPagos( String uid, String numeroCuenta, String muestraCancelaciones) {
		List movimientos = null;
		try {
			movimientos = comun.storeEstadoCuentaDetalle(uid, numeroCuenta, muestraCancelaciones,
														ObtenerEstadoCuenta.DETALLE/*obtenerDetalleEstadoDeCuenta*/);
		} catch (Exception e ) {
			LogHandler.error(uid, getClass(), "Existio un error dentro de obtenerPagos", e);
		}
		return (movimientos != null	&& movimientos.get(0) instanceof PagoOV) ? movimientos : null;
	}

	@SuppressWarnings({ "rawtypes" })
	public CreditoOV obtenerCredito(String uid, String numeroCuenta) {
		List movimientos = null;
		try {
			movimientos = comun.storeEstadoCuenta(uid, numeroCuenta, ObtenerEstadoCuenta.DATOS/*obtenerDatosEstadoDeCuenta*/);
		} catch ( Exception e ) {
			LogHandler.error(uid, getClass(), "Existio un error dentro de obtenerPagos", e);
		}
		return (CreditoOV) ((movimientos != null	&& movimientos.get(0) instanceof CreditoOV) ? movimientos.get(0) : null);
	}

	@SuppressWarnings({ "rawtypes" })
	public ResumenSaldoOV obtenerFinalEstadoCuenta(String uid, String numeroCuenta) {
		List movimientos = null;
		try {
			movimientos =  comun.storeEstadoCuenta(uid, numeroCuenta, ObtenerEstadoCuenta.FINAL/*obtenerFinalEstadoDeCuenta*/);
		} catch ( Exception e ) {
			LogHandler.error(uid, getClass(), "Existio un error dentro de obtenerPagos", e);
		}
		return (ResumenSaldoOV) ((movimientos != null	&& movimientos.get(0) instanceof ResumenSaldoOV)
									? movimientos.get(0) : null);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<PagoOV> obtenerVencidoEstadoCuenta(String uid, String numeroCuenta) {
		List movimientos = null;
		try {
			movimientos = comun.storeEstadoCuenta(uid, numeroCuenta,
												ObtenerEstadoCuenta.VENCIDOS/*obtenerVencidoEstadoDeCuenta*/);
		} catch ( Exception e ) {
			LogHandler.error(uid, getClass(), "Existio un error dentro de obtenerVencidoEstadoCuenta", e);
		}
		return (movimientos != null && movimientos.get(0) instanceof PagoOV) ? movimientos : null;
	}

	@SuppressWarnings({ "rawtypes" })
	private String obtenerUnidadEspecializada(String uid, String sucursal) {
		List direccion = null;
		try {
		  direccion = comun.storeEstadoCuenta(uid, sucursal,
				  							ObtenerEstadoCuenta.UNIDAD_ESPECIALIZADA/*obtenerUnidadEspecializada*/);
		} catch ( Exception e ) {
			LogHandler.error(uid, getClass(), "Existio un error dentro de obtenerUnidadEspecializada", e);
		}
		return (direccion != null && direccion.get(0) instanceof String) ? (String) direccion.get(0) : null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<AmortizacionOV> amortizacionGrupo(String uid, String cuenta) {
		List pagos = null;
		try {
		  pagos = comun.storeEstadoCuenta(uid, cuenta, ObtenerEstadoCuenta.AMORTIZACION_GRUPAL/*obtenerAmortizacionGrupal*/);
		} catch ( Exception e ) {
			LogHandler.error(uid, getClass(), "Existio un error dentro de obtenerUnidadEspecializada", e);
		}
		return (pagos != null	&& !pagos.isEmpty() && pagos.get(0) instanceof AmortizacionOV) ? pagos : null;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<AmortizacionActualOV> amortizacionGrupoActual(String uid, String cuenta) throws Exception {
		List pagos = null;
		try {
		  pagos = comun.storeEstadoCuentaEx(uid, cuenta,
				  ObtenerEstadoCuenta.AMORTIZACION_GRUPAL_ACTUAL/*obtenerAmortizacionGrupalActual*/);
		} catch ( Exception e ) {
			LogHandler.error(uid, getClass(), "Existio un error dentro de obtenerUnidadEspecializada", e);
			throw new Exception("No fue posible obtener stEstadoCuenta debido a :  " + e.getMessage());
		}
		return (pagos != null	&& !pagos.isEmpty() && pagos.get(0) instanceof AmortizacionActualOV) ? pagos : null;
	}

	@SuppressWarnings("rawtypes")
	public CreditoGrupalOV creditoGrupo(String uid, String cuenta) {
		LogHandler.debug( uid, getClass(), "139 EstadoCuentaImpl: " + cuenta );
		List pagos = null;
		try {
		  pagos = comun.storeEstadoCuenta(uid, cuenta, ObtenerEstadoCuenta.GRUPO/*obtenerGrupoEstadoDeCuenta*/);
		  LogHandler.debug( uid, getClass(), "141 EstadoCuentaImpl pagos: " + pagos );
		} catch ( Exception e ) {
			LogHandler.error(uid, getClass(), "Existio un error dentro de obtenerUnidadEspecializada", e);
		}
		return (pagos != null	&& !pagos.isEmpty() && pagos.get(0) instanceof CreditoGrupalOV)
				? (CreditoGrupalOV) pagos.get(0) : null;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<MiembroGrupoVO> integrantesGrupo(String uid, String cuenta) {
		List integrante = null;
		try {
			integrante = comun.storeEstadoCuenta(uid, cuenta, ObtenerEstadoCuenta.INTEGRANTES/*consulaDatosIntegrantes*/);
		} catch ( Exception e ) {
			LogHandler.error(uid, getClass(), "Existio un error dentro de obtenerUnidadEspecializada", e);
		}
		return (integrante != null	&& !integrante.isEmpty() && integrante.get(0) instanceof MiembroGrupoVO) ? integrante : null;
	}

	/**
	 * Consulta WS depositos garantia
	 * @param uid identificador
	 * @param contrato .
	 * @return DepositosGarantiaRespuestaOV
	 * @throws Exception
	 */
	public DepositosGarantiaRespuestaOV consultaDepositosGarantiaDetalle(String uid, String contrato) throws Exception {
		//Obtenemos url del servicio de par_general
		LogHandler.trace(uid, getClass(), "depositosGarantiaDetalle: - obtenerParGeneral");
		ParGeneralOV urlDepgar = comun.obtenerParGeneralOV(uid, "DEPGAR_WS");
		LogHandler.debug( uid, getClass(), "valor de DEPGAR_WS: " + urlDepgar.getCgValor() );
		if (urlDepgar == null || urlDepgar.getCgValor().trim().isEmpty()) {
			throw new Exception("No fue posible obtener la URL del servicio depositos garantia.");
		}
		DepositosGarantiaWS_ServiceLocator ws = new DepositosGarantiaWS_ServiceLocator();
		ws.setDepositosGarantiaWSPortEndpointAddress(urlDepgar.getCgValor().trim());
//		ws.setDepositosGarantiaWSPortEndpointAddress("http://10.1.50.134:7001/"
//		+ "DepositosGarantia/DepositosGarantiaWS?wsdl"); //TEMPORAL
		MovimientosGarantiaPeticion peticionWSdepgar = new MovimientosGarantiaPeticion();
		peticionWSdepgar.setContrato(contrato);
		LogHandler.debug( uid, getClass(), "peticion WS peticionWSdepgar: " + peticionWSdepgar );
		String respuesta =  ws.getDepositosGarantiaWSPort().obtenerMovimientosGarantiaPorContrato(peticionWSdepgar);
		LogHandler.debug( uid, getClass(), "respuesta WS obtenerMovimientosGarantiaPorContrato: " + peticionWSdepgar );
		if (respuesta == null || respuesta.trim().isEmpty()) {
			throw new Exception("No fue posible obtener los movimientos de depositos en garantia");
		}
		respuesta = respuesta.replace("respuesta", "DepositosGarantiaRespuestaOV");
		respuesta = respuesta.replace("movimiento>", "MovimientoDetalleDepgar>");
		//Parametros de entrada
		final Class<?>[] clases = {DepositosGarantiaRespuestaOV.class,
								   StatusDepGar.class,
								   MovimientoGarantiaOV.class,
								   MovimientoDetalleDepgar.class
								   };

		DepositosGarantiaRespuestaOV respuestaDepgar = new DepositosGarantiaRespuestaOV();
		respuestaDepgar = (DepositosGarantiaRespuestaOV) transformador.transformaXMLAObjeto(uid, respuesta, clases);
		LogHandler.debug( uid, getClass(), "respuesta WS Objeto: " + respuestaDepgar );
		return respuestaDepgar;
	}

	/**
	 * Funcion privada, que sirve para obtener los campos extras en el estado de cuenta
	 * @param uid uid
	 * @param contrato contrato
	 * @param creditoOV creditoOV
	 * @return EstadoCuentaMontos
	 */
	@SuppressWarnings("unchecked")
	public EstadoCuentaMontos recuperaMontosExtras(String uid, String contrato, CreditoOV creditoOV)
		{
		//Conexion a traves de mybatis
		SqlSession sessionNTx = null;

		//Objeto que regresa los datos obtenidos
		EstadoCuentaMontos respuesta = new EstadoCuentaMontos();

		try	{
			//Se obtiene la conexion
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			//Variable para guardar el ajuste de interes
			java.lang.Double ajusteInteres = 0D;

			if ( contrato.contains( "LD" ) ) {
				contrato = comun.obtenerNumeroContrato(uid, contrato); //regresa num contrato
				LogHandler.debug(uid, this.getClass(), "contiene LD, numeroCuenta = " + contrato);
			}

			//Se calcula el interes total del contrato actual
			final HashMap<String, Object> datosCredito = comun.obtenerDatosGeneralesContrato(uid, contrato);
			Double interescontrato = datosCredito.get( "interes_total" ) == null
								  || datosCredito.get( "iva_interes_total" ) == null
								  ? 0D
								  :	 Double.valueOf( datosCredito.get( "interes_total" ).toString().trim() )
								  	+ Double.valueOf( datosCredito.get( "iva_interes_total" ).toString().trim() );

			//se recupera el iva
			final java.util.HashMap<String, Object> params = new HashMap<String, Object>();
			params.put( "sucursal" , creditoOV.getSucursal());
			params.put( "codigo"   , "IVIN");
			params.put( "fecha"	   , creditoOV.getFechaContrato());

			LogHandler.trace(uid, getClass(), "==> recuperaMontosExtras - verValorHistorico " );
			final Integer iva = (Integer) sessionNTx.selectOne("verValorHistorico", params);

			//Se obtiene la parte sin iva
			final Double ivaD = Double.parseDouble( iva.toString() );

			//Numero de cheques devueltos
			LogHandler.trace(uid, getClass(), "==> recuperaMontosExtras - obtenerChequesDevueltos " );
			final java.lang.Integer chequesDev = (Integer) sessionNTx.selectOne("obtenerChequesDevueltos", contrato);

			//Si hay cheques devueltos, calculamos el estado anterior del contrato
			if ( chequesDev > 0 ) {
				//Se recupera el estado anterior del contrato
				java.lang.Double tasaGenerada
					= Double.parseDouble( creditoOV.getTasa().toString() ) / 100.0 / 12.0 / 30.0;//tasa diaria

				//Definici�n tipo de calculo para intereses
				//Obtener el - codigo - para tipo de c�lculo
				params.put( "contrato" , contrato );

				LogHandler.trace(uid, this.getClass(), "==> calcularIntereses - obtenerTipoCalculoInteres");
		    	final java.util.HashMap<String, Object>
					mapaCodigoCalculo = (HashMap<String, Object>) sessionNTx.selectOne( "obtenerTipoCalculoInteres", params );

		    	//Obtener el - valor - para tipo de c�lculo
				params.put( "tipoCalculoInteres", mapaCodigoCalculo.get( "valor" ).toString() );
				params.put( "sucursal"  		, creditoOV.getSucursal() );
				params.put( "fechaContrato"	    , creditoOV.getFechaContrato() );

				LogHandler.trace(uid, this.getClass(), "==> calcularIntereses - obtenerValorTipoCalculoInteres");
				final java.lang.String
					  valorTipoCalculo = (java.lang.String) sessionNTx.selectOne( "obtenerValorTipoCalculoInteres", params );

				//Dias del plazo
				java.lang.Integer diasTotales = 0;

				//Si el tipo es PERIODOS_COMPLETOS se procede como siempre de lo contrario se cambian el calculo de los dias
		    	if ( !valorTipoCalculo.trim().equals( "DIAS_TRANSCURRIDOS" ) ) {
					switch ( creditoOV.getFrecuenciaPago().toUpperCase().charAt(0) ) {
						case 'M':
							tasaGenerada *= 30.0;
							break;
						case 'S':
							tasaGenerada *= 7.0;
							break;
						case 'C':
							tasaGenerada *= 14.0;
							break;
						default:
							tasaGenerada *= 7.0;
						}
					}
		    	else {
		    		//Diferencia de dias de contrato
		    		final HashMap<String, Object> datosContrato = comun.obtenerDatosGeneralesContrato(uid, contrato);
		    		try {
		    			final java.text.SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );

		    			final Calendar calendarInicio = Calendar.getInstance();
  					    calendarInicio.setTime( simpleDateFormat.parse( datosContrato.get( "fecha_disposicion" ).toString() ) );
						final Calendar calendarFin = Calendar.getInstance();
		    	    	calendarFin.setTime( simpleDateFormat.parse( datosContrato.get( "fecha_esp_liq" ).toString() ) );
		    	    	diasTotales = diferenciaDias(calendarInicio, calendarFin );
		    	     }
		    		catch (ParseException e) {
		    			diasTotales =  0;
					}
		    	}

		    	//Se calcula interes
				ajusteInteres = creditoOV.getMontoTotal() * tasaGenerada
								* ( diasTotales != 0 ? diasTotales : creditoOV.getNumeroPagos() );

				//Del calculado se resta el actual
				ajusteInteres = ajusteInteres - interescontrato;

				}

			//Interes retenido
			final Double interesSinIva =  interescontrato + ajusteInteres
							- ( ( interescontrato + ajusteInteres ) / ( 1.0 + (ivaD / 100.0) ) );

			//Formato de valores
			final DecimalFormat 	decimalFormat 	 = new DecimalFormat( "#.00" );
			final java.lang.Double	interesOrdinario =  interescontrato + ajusteInteres;

			//Recuperar mondo Deposito Garantia
			LogHandler.trace(uid, this.getClass(), "==> calcularIntereses - obtenerDepositoGarantia");
			params.put("contrato", contrato);
	    	java.lang.Double depositoMontoGarantia
	    		= (java.lang.Double) sessionNTx.selectOne( "obtenerDepositoGarantia", params );
	    	if (depositoMontoGarantia == null) {
	    		depositoMontoGarantia = 0.0;
	    	}
	    	respuesta.setDepositoMontoGarantia(depositoMontoGarantia);

			//objeto para generar la salida del metodo, se asignan los calculos
			respuesta.setChequeDevuelto( chequesDev	   );
			respuesta.setImpuestoRetenido( Double.parseDouble( decimalFormat.format( interesSinIva ) ) );
			respuesta.setAjusteInteres( Double.parseDouble( decimalFormat.format( ajusteInteres ) ) );
			respuesta.setInteresOrdinario(  Double.parseDouble( decimalFormat.format( interesOrdinario )));
			respuesta.setTotalAPagar( Double.parseDouble( decimalFormat.format( respuesta.getInteresOrdinario()
												+ creditoOV.getMontoTotal() ) ) );
			respuesta.setNuevoInteresOrdinario( Double.parseDouble( decimalFormat.format( interescontrato ) ) );
			}
		catch ( java.lang.Exception exception ) {
			LogHandler.error(uid, getClass(), "Ocurrion un error : " + exception.getMessage(), exception);
		}
		finally {
			FabricaConexiones.close( sessionNTx );
		}

		return respuesta;
		}


	//Funciones privadas  ------------------------------------------------------------------------------
	/**
	 * @param startDate fecha Inicio
	 * @param endDate fecha Fin
	 * @return Diferencia en dias
	 */
	private java.lang.Integer diferenciaDias(final java.util.Calendar startDate, final java.util.Calendar endDate) {
		final java.lang.Integer millis_in_day = 1000 * 60 * 60 * 24;
		final java.lang.Long 	endInstant    = endDate.getTimeInMillis();
		java.lang.Integer presumedDays  = (int) (( endInstant - startDate.getTimeInMillis() ) / millis_in_day );
		final java.util.Calendar
				cursor = (Calendar) startDate.clone();
				cursor.add(Calendar.DAY_OF_YEAR, presumedDays);

		final java.lang.Long beginInstant = cursor.getTimeInMillis();

		presumedDays += beginInstant < endInstant ? 1 : beginInstant > endInstant ? -1 : 0;

		return presumedDays;
		}
}
