package tarea.consultas;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import org.apache.ibatis.session.SqlSession;
import org.osoa.sca.annotations.Reference;

import datamapper.DataMapper;
import entidad.asesores.data.AsesorData;
import entidad.conexiones.FabricaConexiones;
import tarea.comun.ComunTarea;
import tarea.comun.ReadProperties;
import tarea.operacion.PagosCredito;
import tarea.solicitudes.FuncionesComunes;
import utilitario.buzon.AsignaTareaPropietarioPeticion;
import utilitario.buzon.AsignaTareaPropietarioRespuesta;
import utilitario.buzon.BuzonOV;
import utilitario.buzon.ConsultaBuzonPeticion;
import utilitario.buzon.TareaOV;
import utilitario.comun.Constantes;
import utilitario.comun.ConstantesPagos;
import utilitario.comun.Funciones;
import utilitario.comun.Numero2Letra;
import utilitario.comun.ReferenciasBancarias;
import utilitario.comun.Validaciones;
import utilitario.comun.asesores.AsesorOV;
import utilitario.log.LogHandler;
import utilitario.mensajes.administracion.contrato.ConcentradoActasRecaudacionPeticion;
import utilitario.mensajes.administracion.contrato.ConcentradoActasRecaudacionRespuesta;
import utilitario.mensajes.administracion.contrato.ResumenRecaudacionOV;
import utilitario.mensajes.comun.AmortizacionOV;
import utilitario.mensajes.comun.CatalogosOV;
import utilitario.mensajes.comun.ConsultaCatalogoRespuestaCIOF;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.FechaContableOV;
import utilitario.mensajes.condonaciones.ConsultaDatosPeticion;
import utilitario.mensajes.condonaciones.ConsultaDatosRespuesta;
import utilitario.mensajes.condonaciones.comun.CreditoSaldo;
import utilitario.mensajes.condonaciones.comun.SaldoVencidoResult;
import utilitario.mensajes.consultas.AnalistasCEC;
import utilitario.mensajes.consultas.AsentamientoOV;
import utilitario.mensajes.consultas.AsignacionDetalleOV;
import utilitario.mensajes.consultas.AsignacionDetalleRespuesta;
import utilitario.mensajes.consultas.AsignacionOV;
import utilitario.mensajes.consultas.AsignacionSucursalRespuesta;
import utilitario.mensajes.consultas.AsistenciaOV;
import utilitario.mensajes.consultas.AutorizaReasignacionRespuesta;
import utilitario.mensajes.consultas.ClienteHistoricoRespuesta;
import utilitario.mensajes.consultas.ClientesHistorico;
import utilitario.mensajes.consultas.ConsolidadoCreditosAsignadosOV;
import utilitario.mensajes.consultas.ConsolidadoCreditosAsignadosPeticion;
import utilitario.mensajes.consultas.ConsolidadoCreditosAsignadosRespuesta;
import utilitario.mensajes.consultas.ConsultaAnalista;
import utilitario.mensajes.consultas.ConsultaAsentamientoRespuesta;
import utilitario.mensajes.consultas.ConsultaCATPeticion;
import utilitario.mensajes.consultas.ConsultaCATRespuesta;
import utilitario.mensajes.consultas.ConsultaCreditoPeticion;
import utilitario.mensajes.consultas.ConsultaCreditosSinAsignarRespuesta;
import utilitario.mensajes.consultas.ConsultaDatosClientePeticion;
import utilitario.mensajes.consultas.ConsultaDatosClienteRespuesta;
import utilitario.mensajes.consultas.ConsultaDatosImagenesMonitorPeticion;
import utilitario.mensajes.consultas.ConsultaDatosImagenesMonitorRespuesta;
import utilitario.mensajes.consultas.ConsultaDatosPromediosMonitorPeticion;
import utilitario.mensajes.consultas.ConsultaDatosPromediosMonitorRespuesta;
import utilitario.mensajes.consultas.ConsultaOportunidadPeticion;
import utilitario.mensajes.consultas.ConsultaOportunidadRespuesta;
import utilitario.mensajes.consultas.ConsultaReferenciaBancariasOV;
import utilitario.mensajes.consultas.ConsultaReferenciasPagoPeticion;
import utilitario.mensajes.consultas.ConsultaReferenciasPagoRespuesta;
import utilitario.mensajes.consultas.ConsultaSISEFINPeticion;
import utilitario.mensajes.consultas.ConsultaSISEFINRespuesta;
import utilitario.mensajes.consultas.ConsultaSISEFINVO;
import utilitario.mensajes.consultas.ConsultaSaldosAFavorAjustadosPeticion;
import utilitario.mensajes.consultas.ConsultaSaldosAFavorAjustadosRespuesta;
import utilitario.mensajes.consultas.ConsultaSaldosAFavorCreditosVigentesPeticion;
import utilitario.mensajes.consultas.ConsultaSaldosAFavorCreditosVigentesRespuesta;
import utilitario.mensajes.consultas.ConsultaSaldosAFavorPeticion;
import utilitario.mensajes.consultas.ConsultaSaldosAFavorRespuesta;
import utilitario.mensajes.consultas.ConsultarCreditosAsignadosPeticion;
import utilitario.mensajes.consultas.ConsultarCreditosAsignadosRespuesta;
import utilitario.mensajes.consultas.ConsultarMovimientosPeticion;
import utilitario.mensajes.consultas.ConsultarMovimientosRespuesta;
import utilitario.mensajes.consultas.ConsultarReasignacionesContratoPeticion;
import utilitario.mensajes.consultas.ConsultarReasignacionesContratoRespuesta;
import utilitario.mensajes.consultas.ConsultarReasignacionesMultiplesRespuesta;
import utilitario.mensajes.consultas.ConsultarReasignacionesPeticion;
import utilitario.mensajes.consultas.ConsultarReasignacionesRespuesta;
import utilitario.mensajes.consultas.ConsultarSolicitudesRespuesta;
import utilitario.mensajes.consultas.CreditosAsignadosOV;
import utilitario.mensajes.consultas.CreditosSinAsignar;
import utilitario.mensajes.consultas.DatosClienteOV;
import utilitario.mensajes.consultas.DatosClienteRespuesta;
import utilitario.mensajes.consultas.DatosCreditoIntegrantesRespuesta;
import utilitario.mensajes.consultas.DatosCreditoOV;
import utilitario.mensajes.consultas.DatosCreditoRespuesta;
import utilitario.mensajes.consultas.DatosImagenesMonitorOV;
import utilitario.mensajes.consultas.DatosIntegranteResumenOV;
import utilitario.mensajes.consultas.DatosPromediosMonitorOV;
import utilitario.mensajes.consultas.DesembolsoOpenContractRespuesta;
import utilitario.mensajes.consultas.DetalleAsistencia;
import utilitario.mensajes.consultas.DetallesAgendaOV;
import utilitario.mensajes.consultas.GeneraActaRecaudacionRespuesta;
import utilitario.mensajes.consultas.GrupoHistoricoRespuesta;
import utilitario.mensajes.consultas.MovimientoOV;
import utilitario.mensajes.consultas.ObtenerReferenciasPagoPeticion;
import utilitario.mensajes.consultas.ObtenerReferenciasPagoRespuesta;
import utilitario.mensajes.consultas.PeticionRFCOV;
import utilitario.mensajes.consultas.ReasignacionContratoOV;
import utilitario.mensajes.consultas.ReasignacionMultipleOV;
import utilitario.mensajes.consultas.ReasignacionOV;
import utilitario.mensajes.consultas.Referencias;
import utilitario.mensajes.consultas.ReferenciasBancariasOV;
import utilitario.mensajes.consultas.ReferenciasPeticion;
import utilitario.mensajes.consultas.ReferenciasRespuestaPaybin;
import utilitario.mensajes.consultas.ReporteAsistencias;
import utilitario.mensajes.consultas.ReporteDatosCliente;
import utilitario.mensajes.consultas.ReporteDatosClientePeticion;
import utilitario.mensajes.consultas.ReporteReasignacionesPeticion;
import utilitario.mensajes.consultas.RespuestaRFCOV;
import utilitario.mensajes.consultas.SaldoAFavorCreditoVigenteVO;
import utilitario.mensajes.consultas.SaldoAFavorVO;
import utilitario.mensajes.consultas.SolicitudReasignacionOV;
import utilitario.mensajes.consultas.TipoProductosOV;
import utilitario.mensajes.consultas.ValidarRelacionPersonaContratoPeticion;
import utilitario.mensajes.consultas.ValidarRelacionPersonaContratoRespuesta;
import utilitario.mensajes.consultas.VerificaAsignacionRespuesta;
import utilitario.mensajes.operacion.ActaRecaudacionClienteOV;
import utilitario.mensajes.operacion.ActaRecaudacionOV;
import utilitario.mensajes.operacion.ActaRecaudacionParcialidadOV;
import utilitario.mensajes.operacion.ActaRecaudacionPeticion;
import utilitario.mensajes.operacion.ActaRecaudacionRespuesta;
import utilitario.mensajes.operacion.RegistrOperacionesPeticion;
import utilitario.mensajes.operacion.RegistrOperacionesRespuesta;
import utilitario.mensajes.operacion.pagos.oxxo.CatalogoDeEstados;
import utilitario.mensajes.operacion.pagos.oxxo.Concept;
import utilitario.mensajes.operacion.pagos.oxxo.PeticionEnLineaOxxo;
import utilitario.mensajes.operacion.pagos.oxxo.RespuestaConsultaEnLineaOxxo;
import utilitario.mensajes.originacion.consulta.ConsultaDiaHabilPeticion;
import utilitario.mensajes.originacion.consulta.ConsultaDiaHabilRespuesta;
import utilitario.mensajes.originacion.consulta.ConsultaDiasInhabilesPeticion;
import utilitario.mensajes.originacion.consulta.ObtenerDiasInhabilesRespuesta;
import utilitario.mensajes.originacion.consulta.ParGeneralOV;
import utilitario.mensajes.originacion.contrato.ContratoOV;
import utilitario.mensajes.reportes.cierre.DesembolsoOpenContractOV;
import utilitario.mensajes.reportes.cierre.ReporteDesembolsoPeticion;
import utilitario.mensajes.solicitudes.ExcepcionGarantiaPeticion;

/**
 * @author oarias
 *
 */
public class ConsultasImpl implements Consultas {

	/**
	 * Fabric SCA
	 */
	private ComunTarea comun;
	/**
	 * Fabric SCA
	 */
	private PagosCredito pagos;


	/**
	 * formatter para fechas
	 */
	private SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

	/**
	 * @param comun :
	 * @param pagos :
	 */
	public ConsultasImpl(@Reference(name = "comun") ComunTarea comun,
						 @Reference(name = "pagos") PagosCredito pagos) {
		this.comun = comun;
		this.pagos = pagos;
		}

	/**
	 * Variable para agendas
	 */
	public boolean isThere;

	/**
	 * Obtiene los datos Generales del credito
	 * @param peticion :
	 * @param uid String
	 * @return datos generales del credito
	 */
	public DatosCreditoRespuesta obtenerDatosCredito(String uid, ConsultaCreditoPeticion peticion) {
		final DatosCreditoRespuesta respuesta = new DatosCreditoRespuesta();
		SqlSession sesion = null;

		try {
			sesion = FabricaConexiones.obtenerSesionNTx();

			if (peticion.getContrato() == null  ) {
				throw new Exception(ReadProperties.mensajes.getProp("ciof.contratoinvalido"));
				}
			//se busca el contrato en la tabla de relacion
			peticion.setContrato(comun.obtenerNumeroContrato(uid, peticion.getContrato()));
			if (peticion.getContrato() == null)	{
				throw new Exception(ReadProperties.mensajes.getProp("ciof.contratoinvalido"));
				}

			//Se realiza la validacion para la relacion de sucursal-contrato
			final java.util.HashMap<String, Object>
									parametros = new java.util.HashMap<String, Object>();
									parametros.put("contrato" , peticion.getContrato() );

			if ( peticion.getContrato() != null && peticion.getSucursal() != null
				&& peticion.getSucursal() != 0 && peticion.getSucursal() != 120 ) {
				parametros.put( "sucursal", peticion.getSucursal() );
				if ( !comun.comprobarContratoSucursal( uid, parametros ) ) {
					throw new Exception( ReadProperties.mensajes.getProp(
							"reportes.obtenerestadocuenta.errorcontratosucursal" ) );
					}
				}

			LogHandler.trace(uid, this.getClass(), "==> obtenerDatosCredito - obtenerDatosContrato " );
			//********Agregar consulta para obtener los diferentes montos de seguro.
			DatosCreditoOV datosCredito = (DatosCreditoOV) sesion.selectOne("obtenerDatosContrato", parametros);

			if (datosCredito == null) {
				throw new Exception(ReadProperties.mensajes.getProp("ciof.contratoinvalido"));
				}
			//Se recuperan los asesores de Oracle
			final AsesorOV asesorOV = AsesorData.obtenAsesor(uid, datosCredito.getAsesor().toString() );
			if ( asesorOV != null) {
				datosCredito.setNombreAsesor( asesorOV.getNombreCompleto() );
				}

			//La tasa para credito grupal es anual con IVA
			// En credprod la tasa es mensual sin IVA
			if (datosCredito.getTasa() != null && datosCredito.getNumeroSucursal() != null)
				{
				final FechaContableOV fechaContable = comun.obtenerFechaContable( uid );
				final HashMap<Object, Object>
								params = new HashMap<Object, Object>();
								params.put("sucursal", datosCredito.getNumeroSucursal());
								params.put("codigo", "IVIN");
								params.put("fecha", formatter.format(fechaContable.getFecha()));

				LogHandler.trace(uid, getClass(), "==> obtenerDatosCredito - verValorHistorico ");
				final java.lang.Integer iva = (Integer) sesion.selectOne("verValorHistorico", params);
				if ( iva != null ) {
					Double tasa = datosCredito.getTasa() * ( 1 + (iva.doubleValue() / 100) ) * 12;
					tasa = Math.rint(tasa * 100) / 100;
					datosCredito.setTasa(tasa);
					}
				else {
					LogHandler.warn(uid, getClass(), ReadProperties.mensajes.getProp(
							"administracion.ajustartasaplazo.errorivasucural"));
					datosCredito.setTasa(null);
					}
				}

			//Dias de mora
			if ( datosCredito.getFechaProxPago() != null )
				{
				//Fecha contable
				final java.util.Calendar
								fechaContableCalendar = java.util.Calendar.getInstance();
								fechaContableCalendar.setTime( comun.obtenerFechaContable(uid).getFecha() );

				//Fecha del proximo pago
				final java.util.Calendar
								fechaProxPagoCalendar = java.util.Calendar.getInstance();
								fechaProxPagoCalendar.setTime( datosCredito.getFechaProxPago() );

				// Se valida que exista mora, existe si la fecha contable
				// es mayor que la fecha del proximo pago
				if ( fechaProxPagoCalendar.before( fechaContableCalendar ) && datosCredito.getStatus().trim().equals( "D" ))
					{
					//Se calculan los dias
					final java.lang.Long diasMora = fechaContableCalendar.getTimeInMillis()
													- fechaProxPagoCalendar.getTimeInMillis();

					datosCredito.setDiasMora( diasMora / (1000 * 3600 * 24 ));
					}
				else
					{
					datosCredito.setDiasMora( 0L );
					}
				}

			SimpleDateFormat formatFecha = new SimpleDateFormat("yyyyMMdd");
			respuesta.setFechaContable(formatFecha.format(comun.obtenerFechaContable(uid).getFecha()));

			//Obtener los saldos
			final utilitario.mensajes.condonaciones.comun.CreditoSaldo creditoSaldo
							= consultaSaldoCredito( uid, peticion.getContrato(), comun.obtenerFechaContable(uid).getFecha() );

			datosCredito.setMontoPagoAtrasado( creditoSaldo.getMontoPagoAtrasado() != null
											? creditoSaldo.getMontoPagoAtrasado() : 0.0 );
			datosCredito.setMontoCorriente( creditoSaldo.getMontoCorriente() != null
											? creditoSaldo.getMontoCorriente() 	: 0.0 );
			datosCredito.setSaldoLiquidar( creditoSaldo.getSaldoLiquidar() 	!= null
											? creditoSaldo.getSaldoLiquidar() : 0.0 );

			datosCredito.setDiasMora( creditoSaldo.getDiasAtraso() != null
											? Long.parseLong( creditoSaldo.getDiasAtraso().toString() ) : 0);

			//dias reunion nulos
			if ( datosCredito.getDiaReunion() == null )
				{	datosCredito.setDiaReunion( "" );	}

			//Dia pago---
			final 	Calendar
					calendar = Calendar.getInstance();
					calendar.setTime( datosCredito.getFechaAncla() );

			datosCredito.setDiaPago( calendar.get( Calendar.DAY_OF_WEEK ) - 1 );

			//Para el monto Garantia con letra
			if (datosCredito.getSaldoGarantia() != null) {
				datosCredito.setSaldoGarLet(getMontoLetras(datosCredito.getSaldoGarantia()));
			}

			//Se asigna el resultado
			respuesta.setDatosCredito( datosCredito );
		} catch (java.lang.Exception exception )
			{
			LogHandler.error(uid, getClass(), exception.getMessage(), exception);
			FabricaConexiones.rollBack( sesion );
			respuesta.getHeader().setMensaje( exception.getMessage() );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setUID( uid );
			}
		finally
			{
			FabricaConexiones.close( sesion );
			}
		return respuesta;
		}


	/*
	 * (non-Javadoc)
	 * @see tarea.consultas.Consultas#obtenerDatosCreditoIntegrantes(java.lang.String,
	 * utilitario.mensajes.consultas.ConsultaCreditoPeticion)
	 */
	@SuppressWarnings("unchecked")
	public DatosCreditoIntegrantesRespuesta obtenerDatosCreditoIntegrantes(	String uid, ConsultaCreditoPeticion peticion) {
		DatosCreditoIntegrantesRespuesta respuesta = new DatosCreditoIntegrantesRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		DatosCreditoOV datosCredito = null;
		SqlSession sesion = null;

		try {
			if (peticion.getContrato() == null)
				{
				throw new Exception(ReadProperties.mensajes.getProp("ciof.contratoinvalido"));
				}

			peticion.setContrato(comun.obtenerNumeroContrato(uid, peticion.getContrato()));

			if (peticion.getContrato() == null)
				{
				throw new Exception(ReadProperties.mensajes.getProp("ciof.contratoinvalido"));
				}

			//Se realiza la validacion para la relacion de sucursal-contrato
			final java.util.HashMap<String, Object>
									parametros = new java.util.HashMap<String, Object>();
									parametros.put("contrato" , peticion.getContrato() );
									parametros.put( "sucursal", peticion.getSucursal() 	 );

			//si se manda cierta sucursal, se comprueba q deba ser validada o se checa si esta excenta
			if (peticion.getContrato() != null && peticion.getSucursal() != null && peticion.getSucursal() != 0
					&& peticion.getSucursal() != 120 ) {
				if ( !comun.comprobarContratoSucursal( uid, parametros ) ) {
					throw new Exception( ReadProperties.mensajes.getProp("reportes.obtenerestadocuenta.errorcontratosucursal"));
				}
			}

			//Se recuperan los datos del contrato
			final DatosCreditoRespuesta consutaCredito = obtenerDatosCredito(uid, peticion);
			if (consutaCredito != null && consutaCredito.getHeader().isEstatus() && consutaCredito.getDatosCredito() != null)
				{
				 datosCredito = consutaCredito.getDatosCredito();
				 respuesta.setDatosCredito(datosCredito);
				}
			else
			 	{
				 throw new Exception(ReadProperties.mensajes.getProp("consultas.consultasaldocredito.errorregistrosvacios"));
			 	}

			sesion = FabricaConexiones.obtenerSesionNTx();

			//Se hace la validación del ambiente de trabajo para p_independencia
			String dbEntorno = sesion.getConfiguration().getVariables().getProperty("db.entorno");
			LogHandler.info(uid, getClass(), "obtenerDatosCreditoIntegrantes:	dbEntorno: " + dbEntorno);
			final HashMap<Object, Object> paramObtenerDatosInte = new HashMap<Object, Object>();
			paramObtenerDatosInte.put("dbEntorno", dbEntorno);
			paramObtenerDatosInte.put("contrato", peticion.getContrato());

			LogHandler.trace(uid, getClass(), "==> obtenerDatosCreditoIntegrantes - obtenerDatosIntegrante");
			List<DatosIntegranteResumenOV> integrantes
				= (List<DatosIntegranteResumenOV>) sesion.selectList("obtenerDatosIntegrante", paramObtenerDatosInte);
			respuesta.setIntegrantes(integrantes.toArray(new DatosIntegranteResumenOV[integrantes.size()]));

			//Reestructuras
			final HashMap<Object, Object> params = new HashMap<Object, Object>();
			params.put("contrato", peticion.getContrato() );
			params.put("fechaActual", formatter.format(comun.obtenerFechaContable(uid).getFecha()) );
			LogHandler.trace(uid, this.getClass(), "==> obtenerDatosCreditoIntegrantes - obtenerSaldoV");
			final HashMap<Object, Object> result = (HashMap<Object, Object>) sesion.selectOne("obtenerSaldoV", params);

			LogHandler.debug(uid, getClass(), "obtenerDatosCreditoIntegrantes interes= "
					+ ((BigDecimal) result.get("Interes Vencido")) + ((BigDecimal) result.get("Iva Interes Vencido")) );
			LogHandler.debug(uid, getClass(), "obtenerDatosCreditoIntegrantes capital vencido= "
					+ ((BigDecimal) result.get("Capital Vencido")));
			LogHandler.debug(uid, getClass(), "obtenerDatosCreditoIntegrantes capital= "
					+ ((BigDecimal) result.get("Capital Insoluto")));
			LogHandler.debug(uid, getClass(), "obtenerDatosCreditoIntegrantes Moratorio= "
					+ ((BigDecimal) result.get("Moratorio")) + ((BigDecimal) result.get("Iva Moratorio")));

			//Double capitalVencido = result.get("Capital Vencido") != null ?
			//Double.valueOf( result.get("Capital Vencido").toString()) : 0.0 ;
			Double capitalInsoluto = result.get("Capital Insoluto") != null
					? Double.valueOf( result.get("Capital Insoluto").toString()) : 0.0;
			//Double interesVencido = result.get("Interes Vencido") != null ?
					//Double.valueOf( result.get("Interes Vencido").toString() )
					//+ Double.valueOf( result.get("Iva Interes Vencido").toString()) : 0.0;
			Double MontoLiquidar = result.get("Saldo para Liquidar") != null
					? Double.valueOf( result.get("Saldo para Liquidar").toString()) : 0.0;
			Double moratorios = result.get("Moratorio") != null ?
					Double.valueOf( result.get("Moratorio").toString() )
					+ Double.valueOf( result.get("Iva Moratorio").toString() ) : 0.0;
			Double interesSaldo =  MontoLiquidar - capitalInsoluto - moratorios;
			//Asignar los saldos a los integrantes
			for ( DatosIntegranteResumenOV datosIntegranteResumenOV : respuesta.getIntegrantes() )
				{
				if ( datosIntegranteResumenOV.getMonto() != null && respuesta.getDatosCredito().getMontoCredito() != null )
					{
					//final java.lang.Double percent = datosIntegranteResumenOV.getMonto()
					// / respuesta.getDatosCredito().getMontoCredito();
					//MIMH 2013-11-21 OPERFIN-138 Tomar el porcentaje de la tabla integrante_grupo
					final java.lang.Double percent =	datosIntegranteResumenOV.getPorcentajeParticipacion() / 100.00;
					datosIntegranteResumenOV.setMontoPagoAtrasado( Funciones.redondeo(
							respuesta.getDatosCredito().getMontoPagoAtrasado() != null
							? percent * respuesta.getDatosCredito().getMontoPagoAtrasado() : 0.0 ) );
					datosIntegranteResumenOV.setMontoCorriente( Funciones.redondeo(
							respuesta.getDatosCredito().getMontoCorriente() != null
							? percent * respuesta.getDatosCredito().getMontoCorriente() 	: 0.0) );
					datosIntegranteResumenOV.setSaldoLiquidar( Funciones.redondeo(
							respuesta.getDatosCredito().getSaldoLiquidar() != null
							? percent * respuesta.getDatosCredito().getSaldoLiquidar() : 0.0 ) );

					//Reestructuras
					datosIntegranteResumenOV.setSaldoCapital(Funciones.redondeo(capitalInsoluto != null
							? percent * capitalInsoluto : 0.0 ) );
					datosIntegranteResumenOV.setSaldoInteres(Funciones.redondeo(interesSaldo != null
							? percent * interesSaldo : 0.0 ) );
					datosIntegranteResumenOV.setSaldoMoratorios(Funciones.redondeo(moratorios != null
							? percent * moratorios : 0.0 ) );

					//Se agregan saldoGarantia, MontoCheque y medioPago AOC Depositos Garantia Fase 3
					datosIntegranteResumenOV.setSaldoGarantia( Funciones.redondeo( datosIntegranteResumenOV.getSaldoGarantia()
							!= null ? datosIntegranteResumenOV.getSaldoGarantia() : 0.0));
					datosIntegranteResumenOV.setMontoCheque( Funciones.redondeo( datosIntegranteResumenOV.getMontoCheque()
							!= null ? datosIntegranteResumenOV.getMontoCheque() : 0.0));
					datosIntegranteResumenOV.setMedioPago( datosIntegranteResumenOV.getMedioPago()
							!= null ?  datosIntegranteResumenOV.getMedioPago() : "");
					datosIntegranteResumenOV.setMontoLiq( Funciones.redondeo( datosIntegranteResumenOV.getMontoLiq()
							!= null ? datosIntegranteResumenOV.getMontoLiq() : 0.0));
					datosIntegranteResumenOV.setMonto( Funciones.redondeo( datosIntegranteResumenOV.getMonto()
							!= null ? datosIntegranteResumenOV.getMonto() : 0.0));

					//se comprueba si el cliente tiene una renovacion financiada
					datosIntegranteResumenOV.setFinanciada( datosIntegranteResumenOV.getMontoLiq()
							!= null && datosIntegranteResumenOV.getMontoLiq() > 0 ? "S" : "N" );

					//Se identifica si el integrante tiene un cheque devuelto
					if ( datosIntegranteResumenOV.getFinanciada().equals( "S" ) )
						{
						//Objeto para almacenar parametros
						parametros.clear();
						parametros.put( "contrato"  , peticion.getContrato());
						parametros.put( "integrante", datosIntegranteResumenOV.getCliente() );

						LogHandler.trace(uid, getClass(), "==> obtenerDatosCreditoIntegrantes - validacionChequeDevuelto" );
						final java.util.Date fechaDev = (Date) sesion.selectOne( "validacionChequeDevuelto", parametros );
						if ( fechaDev != null )
							{
							datosIntegranteResumenOV.setFinanciada( "C" );
							}
						}
					}
				}
		} catch ( java.lang.Exception exception )
			{
			LogHandler.error(uid, getClass(), exception.getMessage(), exception );
			respuesta.getHeader().setMensaje( exception.getMessage() );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setUID(uid);
			return respuesta;
			}
		finally
			{
			FabricaConexiones.close( sesion );
			}

		return respuesta;
	}

	/*
	 * (non-Javadoc)
	 * @see tarea.consultas.Consultas#consultarDatosSaldoVencido(java.lang.String,
	 * utilitario.mensajes.condonaciones.ConsultaDatosPeticion)
	 */
	@SuppressWarnings("unchecked")

	public ConsultaDatosRespuesta consultarDatosSaldoVencido(String uid, ConsultaDatosPeticion peticion)
		{
		final ConsultaDatosRespuesta respuesta = new ConsultaDatosRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		SqlSession sesion = null;
		try {
			sesion = FabricaConexiones.obtenerSesionNTx();
			String numeroContrato = comun.obtenerNumeroContrato(uid, peticion.getLd());
			if (numeroContrato == null )
				{
				throw new Exception(ReadProperties.mensajes.getProp("ciof.error.consultas.registrosvacios"));
				}

			//Validaci�n del estado del contrato
			if ( !comun.obtenerEstatusCredito(uid, numeroContrato).trim().toUpperCase().equals( "D" ) )
				{
				throw new Exception(ReadProperties.mensajes.getProp("ciof.error.statuscontrato"));
				}

			final HashMap<Object, Object> params = new HashMap<Object, Object>();
			LogHandler.debug(uid, getClass(), "==> Contrato" + numeroContrato);
			LogHandler.debug(uid, getClass(), "==> fecha contable="
			+ formatter.format(comun.obtenerFechaContable(numeroContrato).getFecha()));
			params.put("contrato", numeroContrato );
			params.put("fechaActual", formatter.format(comun.obtenerFechaContable(uid).getFecha()) );

			LogHandler.trace(uid, this.getClass(), "==> consultarDatosSaldoVencido - obtenerSaldoV");
			final HashMap<Object, Object> result = (HashMap<Object, Object>) sesion.selectOne("obtenerSaldoV", params);

			LogHandler.debug(uid, getClass(), "interes= "
					+ ((BigDecimal) result.get("Interes Vencido"))
					+ ((BigDecimal) result.get("Iva Interes Vencido")) );
			LogHandler.debug(uid, getClass(), "capital= "
					+ ((BigDecimal) result.get("Capital Vencido")));
			LogHandler.debug(uid, getClass(), "Moratorio= "
					+ ((BigDecimal) result.get("Moratorio")) + ((BigDecimal) result.get("Iva Moratorio")));

			SaldoVencidoResult saldoCredito = new SaldoVencidoResult();
			saldoCredito.setCapital((BigDecimal) result.get("Capital Vencido"));
			saldoCredito.setInteres( new BigDecimal( Double.valueOf( result.get("Interes Vencido").toString() )
					+ Double.valueOf( result.get("Iva Interes Vencido").toString() ) ) ); // Iva Interes Vencido
			saldoCredito.setMoratorio( new BigDecimal(Double.valueOf(result.get("Moratorio").toString() )
					+ Double.valueOf( result.get("Iva Moratorio").toString() ) ) ); // // Iva Moratorio

			if (saldoCredito == null || (saldoCredito.getCapital().doubleValue() == 0
					&& saldoCredito.getMoratorio().doubleValue() == 0 && saldoCredito.getInteres().doubleValue() == 0))
				{
				throw new Exception(ReadProperties.mensajes.getProp(
						"consultas.consultadatossaldovencido.errorconsultacreditonomora"));
				}
			respuesta.setCapitalPD(saldoCredito.getCapital() + "");
			respuesta.setResultado("1");
			respuesta.setInteresPD(saldoCredito.getInteres()  + "");
			respuesta.setRecargos(saldoCredito.getMoratorio() + "");
			respuesta.getHeader().setEstatus(true);
		} catch (Exception e) {
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setEstatus( false );
			respuesta.setResultado( "0" );
			respuesta.setMensaje( "Error ocurrido : " +  e.getMessage()  );
			respuesta.getHeader().setMensaje(ReadProperties.mensajes.getProp(
					"consultas.consultadatossaldovencido.errorrespuesta" + e.getMessage()));
			LogHandler.error(uid, getClass(), "Error ocurrido : " + e.getMessage(), e);
		} finally {
			FabricaConexiones.close(sesion);
		}
		return respuesta;
	}

	public CreditoSaldo consultaSaldoCredito(String uid, String numerocontrato, Date fechaValor) {
		SqlSession sesion = null;
		CreditoSaldo datosSaldo = null;

		try {
			sesion = FabricaConexiones.obtenerSesionNTx();

			//parametros
			final HashMap<Object, Object>
							params = new HashMap<Object, Object>();
							params.put("contrato", numerocontrato );
							params.put("fechaActual", formatter.format(fechaValor));

			LogHandler.trace( uid, getClass(), "==> consultaSaldoCredito - obtenerSaldoFv" );
			datosSaldo = (CreditoSaldo) sesion.selectOne("obtenerSaldoFv", params);
			if ( datosSaldo == null )
				{
				throw new Exception(ReadProperties.mensajes.getProp("consultas.consultasaldocredito.errorregistrosvacios"));
				}
			}
		catch ( java.lang.Exception exception )
			{
			LogHandler.error(uid, getClass(), exception.getMessage(), exception);
			}
		finally
			{
			FabricaConexiones.close( sesion );
			}

		return datosSaldo;
	}

	/**
	 * Envuelve la llamada al stored procedure consulta_saldo_fv
	 * @param uid tipo string
	 * @param numeroContrato tipo string
	 * @param fechaValor tipo date
	 * @param sesionExterna tipo SqlSession
	 * @return saldo del credito
	 */
	public CreditoSaldo consultaSaldoCredito(String uid, String numerocontrato, Date fechaValor, SqlSession sesionExterna) {
		SqlSession sesion = null;
		CreditoSaldo datosSaldo = null;

		try {
			if (sesionExterna == null ) {
			sesion = FabricaConexiones.obtenerSesionNTx();
			} else {
				sesion = sesionExterna;
			}
			//parametros
			final HashMap<Object, Object>
							params = new HashMap<Object, Object>();
							params.put("contrato", numerocontrato );
							params.put("fechaActual", formatter.format(fechaValor));

			LogHandler.trace( uid, getClass(), "==> consultaSaldoCredito - obtenerSaldoFv" );
			datosSaldo = (CreditoSaldo) sesion.selectOne("obtenerSaldoFv", params);
				if (datosSaldo == null) {
					throw new Exception(ReadProperties.mensajes.getProp("consultas.consultasaldocredito.errorregistrosvacios"));
				}
			}
			catch ( java.lang.Exception exception ) {
				LogHandler.error(uid, getClass(), exception.getMessage(), exception);
			}
			finally {
				if (sesionExterna == null) {
					FabricaConexiones.close( sesion );
				}
			}

		return datosSaldo;

	}

	/*
	 * (non-Javadoc)
	 * @see tarea.consultas.Consultas#consultaDatosCliente(
	 * utilitario.mensajes.consultas.ConsultaDatosClientePeticion, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public ConsultaDatosClienteRespuesta consultaDatosCliente(ConsultaDatosClientePeticion peticion, String uid) {
		final ConsultaDatosClienteRespuesta respuesta = new ConsultaDatosClienteRespuesta();
		final DatosClienteOV datosCliente = new DatosClienteOV();
		SqlSession sesion = null;
		try	{
			if (peticion.getClavePersona() == null || peticion.getClavePersona().trim().isEmpty()) {
				throw new Exception( "Es necesario la clave de persona para la busqueda.");
			}
			sesion = FabricaConexiones.obtenerSesionNTx();
			final String clienteFinsol = comun.obtenerPersonaCliente(uid, peticion.getClavePersona());

			if (clienteFinsol == null || clienteFinsol.trim().isEmpty())
			{
				throw new Exception( ReadProperties.mensajes.getProp("ciof.clienteinvalido"));
			}

			LogHandler.trace(uid, getClass(), "==> consultaDatosCliente - obtenerContratoClientePorPersona");
			final java.lang.String ultimoContrato = (String) sesion.selectOne("obtenerContratoClientePorPersona", clienteFinsol);

			DatosClienteOV resultCliente = null;

			Date fechaContable = null;

			if ( ultimoContrato == null || ultimoContrato.trim().equals( "" ) ) {
				LogHandler.trace(uid, getClass(), "==> consultaDatosCliente - obtenerDatosPersona");
				resultCliente = (DatosClienteOV) sesion.selectOne("obtenerDatosPersona", clienteFinsol);
				if ( resultCliente == null )	{
					throw new Exception(ReadProperties.mensajes.getProp("ciof.clienteinvalido") );
				}
				datosCliente.setCodigoGrupo( "" );
				datosCliente.setNombreGrupo( "" );
				datosCliente.setFechaMora( 0 );
				datosCliente.setMontoOtorgado( 0d );
				datosCliente.setPersona( resultCliente.getPersona() );
				datosCliente.setCicloCliente(0);
				datosCliente.setEdad(comun.calcularEdad(resultCliente.getFechaNacimiento()));
				datosCliente.setExperiencia(resultCliente.getExperiencia());
				datosCliente.setEstatusRenovacionCliente("");
			}
			else {
				//Datos para el grupo
				LogHandler.trace(uid, getClass(), "==> consultaDatosCliente - obtenerDatosGrupo");
				final java.util.HashMap<String, Object> datosGrupo
					= (HashMap<String, Object>) sesion.selectOne("obtenerDatosGrupo", ultimoContrato);
				final java.util.HashMap<String, String>
								parametrosDatosCliente = new HashMap<String, String>();
								parametrosDatosCliente.put( "persona" , clienteFinsol);
								parametrosDatosCliente.put( "contrato" , ultimoContrato);

				LogHandler.trace(uid, getClass(), "==> consultaDatosCliente - obtenerDatosCliente");
				resultCliente = (DatosClienteOV) sesion.selectOne("obtenerDatosCliente", parametrosDatosCliente);

				datosCliente.setCodigoGrupo((String) datosGrupo.get("CodigoGrupo"));
				datosCliente.setNombreGrupo((String) datosGrupo.get("NombreGrupo"));

				if ( resultCliente != null )
					{
					String estatus = resultCliente.getEstatus();

					if ( estatus != null && estatus.equals("P") )
						{
						datosCliente.setFechaMora(0);
						}
					else
						{
						datosCliente.setMora(resultCliente.getFechaProximoPago().before(Calendar.getInstance().getTime() )
								? getDiasTranscurridos(resultCliente.getFechaProximoPago(), uid) : 0);
						datosCliente.setFechaLiquidacion(null);
						}
					datosCliente.setPersona( resultCliente.getPersona() );
					}

				fechaContable = comun.obtenerFechaContable( uid ).getFecha();

				//Se coloca el saldo del cliente al dia
				final java.text.SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyyMMdd" );
				final java.util.HashMap<String, Object>
										paramsSaldos = new HashMap<String, Object>();
										paramsSaldos.put( "contrato"   , ultimoContrato );
										paramsSaldos.put( "fechaActual", simpleDateFormat.format(fechaContable) );
										paramsSaldos.put( "persona"	   , datosCliente.getPersona());

				//Se recupera el saldo a liquidar del contrato
				LogHandler.trace(uid, getClass(), "==> consultaDatosCliente - obtenerSaldoFv");
				final CreditoSaldo creditoSaldo = (CreditoSaldo) sesion.selectOne( "obtenerSaldoFv", paramsSaldos );
				//Se recupera el monto prestado al grupo
				final java.lang.String monto = comun.obtenerDatosGeneralesContrato(uid, ultimoContrato).get("monto").toString();
				//Se recupera el monto otorgado a la persona

				if (paramsSaldos.get("persona") == null) {
					throw new Exception( ReadProperties.mensajes.getProp("ciof.clienteinvalido"));
				}

				LogHandler.trace(uid, getClass(), "==> consultaDatosCliente - obtenerDatosultimocontrato");
				final HashMap<String, Object> datosCreditoCliente
					= (HashMap<String, Object>) sesion.selectOne( "obtenerDatosultimocontrato", paramsSaldos );
				//Se asigna en base al porcentaje de participacion el saldo a liquidar del integrante y se formatea
			    final java.lang.Double saldoAux = Double.valueOf( datosCreditoCliente.get("montoOtorgado").toString() )
			    			/ Double.valueOf( monto ) * creditoSaldo.getSaldoLiquidar();
			    datosCliente.setSaldo( "" + Double.valueOf( ( new DecimalFormat( "#.00" ) ).format( saldoAux ) ) );
				}

			if ( resultCliente == null )	{
				throw new Exception(ReadProperties.mensajes.getProp("ciof.clienteinvalido") );
				}
			else {
				datosCliente.setNombreCompleto(resultCliente.getNombreCompleto());
				datosCliente.setFechaNacimiento(resultCliente.getFechaNacimiento());
				datosCliente.setEdad(comun.calcularEdad(resultCliente.getFechaNacimiento()));
				datosCliente.setRfc(resultCliente.getRfc());
				datosCliente.setCurp(resultCliente.getCurp());
				datosCliente.setFechaVencimiento(resultCliente.getFechaVencimiento() );
				datosCliente.setMontoOtorgado(resultCliente.getMontoOtorgado() == null ? 0.0 : resultCliente.getMontoOtorgado());
				datosCliente.setEstatus(resultCliente.getEstatus() == null ? "" : resultCliente.getEstatus());
				datosCliente.setCicloCliente(resultCliente.getCicloCliente());
				datosCliente.setFechaLiquidacion(resultCliente.getFechaLiquidacion());
				datosCliente.setCalle(resultCliente.getCalle());
				datosCliente.setColonia(resultCliente.getColonia());
				datosCliente.setLocalidad(resultCliente.getLocalidad());
				datosCliente.setCp(resultCliente.getCp());
				datosCliente.setEstado(resultCliente.getEstado());
				datosCliente.setMunicipio(resultCliente.getMunicipio());
				datosCliente.setPais(resultCliente.getPais());
				datosCliente.setActividademp(resultCliente.getActividademp());
				datosCliente.setFechaProximoPago(resultCliente.getFechaProximoPago());
				datosCliente.setExperiencia(resultCliente.getExperiencia());
				//Vigente o NO Vigente

				int numeroDiasVigente = Integer.parseInt(comun.obtenerParGeneral(uid, "NDIACLIVIG"));
				if (resultCliente.getFechaLiquidacion() == null) {
					datosCliente.setEstatusRenovacionCliente("");
				} else {
					Calendar fechaVigente = Calendar.getInstance();
					fechaVigente.setTime(resultCliente.getFechaLiquidacion());
					fechaVigente.add(Calendar.DATE, numeroDiasVigente); // Adding days
					Calendar fechaContableCalendar = Calendar.getInstance();
					fechaContableCalendar.setTime(fechaContable);
					SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

					LogHandler.info(uid, getClass(), "==> consultaDatosCliente - fechaVigente: "
							+ df.format(fechaVigente.getTime())
							+ " numeroDiasVigente: " + numeroDiasVigente
							+ " fechaContableCalendar: " + df.format(fechaContableCalendar.getTime()));
					if ( fechaVigente.after(fechaContableCalendar) ) {
						datosCliente.setEstatusRenovacionCliente("Vigente");
					} else {
						datosCliente.setEstatusRenovacionCliente("No Vigente");
					}
				}
			}
			//Se obtiene el ultimo LD
			java.lang.String ultimoLD = null;
			if ( datosCliente.getCicloCliente() > 0 ) {
				LogHandler.trace(uid, getClass(), "==> consultaDatosCliente - obtenerUltimoLD");
				ultimoLD = (String) sesion.selectOne( "obtenerUltimoLD", clienteFinsol );
			}

			datosCliente.setUltimoLD( ultimoLD  != null ? ultimoLD : "" );
		}
		catch ( java.lang.Exception exception )
			{
			respuesta.getHeader().setUID( uid );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setMensaje( exception.getMessage());
			LogHandler.error(uid, getClass(), exception.getMessage(), exception );
			}
		finally
			{
			FabricaConexiones.close( sesion );
			}

		//Se asignan los datos al objeto respuesta
		respuesta.setDatos(datosCliente);
		return respuesta;
	}


	/*
	 * (non-Javadoc)
	 * @see tarea.consultas.Consultas#consultaClientes(
	 * utilitario.mensajes.consultas.ReporteDatosClientePeticion, java.lang.String)
	 */
	@SuppressWarnings("unchecked")

	public DatosClienteRespuesta consultaClientes(ReporteDatosClientePeticion peticion, String uid)	{
		DatosClienteRespuesta result = new DatosClienteRespuesta();
		SqlSession sesionNTx = null;
		SqlSession sesionBatch = null;
		result.setHeader(new EncabezadoRespuesta());
		LogHandler.info(uid, getClass(), "Datos de entrada : peticion = " + peticion);
		try	{
			//Se abren las conexiones
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			sesionBatch = FabricaConexiones.obtenerSesionBatch();

			//Se validan nulos en los filtros de entrada
			if ( peticion.getNombre() == null || peticion.getNombre().trim().equals( "" ) )
				{
				peticion.setNombre( null );
				}

			if ( peticion.getApellidoMat() == null || peticion.getApellidoMat().trim().equals( "" ) )
				{
				peticion.setApellidoMat( null );
				}

			if ( peticion.getApellidoPat() == null || peticion.getApellidoPat().trim().equals( "" ) )
				{
				peticion.setApellidoPat( null );
				}

			if ( peticion.getNombreGrupo() == null || peticion.getNombreGrupo().trim().equals( "" ) )
				{
				peticion.setNombreGrupo( null );
				}

			StringBuffer mascaraNombre = new StringBuffer( peticion.getNombre() == null
					|| peticion.getNombre().trim().equals( "" ) ? "0" : "1");


			mascaraNombre.append( peticion.getApellidoMat() == null
					|| peticion.getApellidoMat().trim().equals( "" ) ? "0" : "1");

			mascaraNombre.append( peticion.getApellidoPat() == null
					|| peticion.getApellidoPat().trim().equals( "" ) ? "0" : "1");


			if ( peticion.getSucursal() == null || peticion.getSucursal() == 0 || peticion.getSucursal() == 120 )
				{
				peticion.setSucursal( null );
				}

			StringBuffer mascaraExtra = new StringBuffer( peticion.getSucursal() == null 
					|| peticion.getSucursal() <= 0 ? "0" : "1");


			mascaraExtra.append( peticion.getNombreGrupo() == null 
					|| peticion.getNombreGrupo().trim().equals( "" ) ? "0" : "1");

			if ( mascaraNombre.toString().equals("000") )
				{
				mascaraNombre = null;
				}
			if ( !mascaraExtra.toString().startsWith( "1" ) && !mascaraExtra.toString().endsWith( "1" ))
				{
				mascaraExtra = null;
				}
			if ( mascaraExtra != null || mascaraNombre != null)
				{
				final java.util.Map<String, Object> filtroscliente = new HashMap<String, Object>();
				filtroscliente.put( "nombre"		   	, peticion.getNombre() != null
						? peticion.getNombre() + "%" : peticion.getNombre() );
				filtroscliente.put( "apellidoPaterno"	, peticion.getApellidoPat() != null
						? peticion.getApellidoPat() + "%" : peticion.getApellidoPat() );
				filtroscliente.put( "apellidoMaterno" 	, peticion.getApellidoMat() != null
						? peticion.getApellidoMat() + "%" : peticion.getApellidoMat() );
				filtroscliente.put( "nombreGrupo"		, peticion.getNombreGrupo() != null
						? peticion.getNombreGrupo() + "%" : peticion.getNombreGrupo() );
				filtroscliente.put( "sucursal" 			, peticion.getSucursal()	 	);
				filtroscliente.put( "sucursalS" 		, peticion.getSucursal() != null
						? peticion.getSucursal().toString() : null);
				filtroscliente.put( "mascaraNombre"     , mascaraNombre != null ? mascaraNombre.toString() : null 	);
				filtroscliente.put( "mascaraExtra"      , mascaraExtra != null ? mascaraExtra.toString() : null   	);

				LogHandler.trace(uid, getClass(), "==> datosClienteRespuesta - obtenerReporteCierreDatosCliente");
				final List<ReporteDatosCliente>  listaDatosCliente  = (List<ReporteDatosCliente>)
						sesionBatch.selectList( "obtenerReporteCierreDatosCliente", filtroscliente );
				if ( listaDatosCliente == null )
					{
						throw new Exception(ReadProperties.mensajes.getProp("consultas.consultaclientes.errorconsultavacia") );
					}
				if ( listaDatosCliente.size() <= 0 )
					{
						throw new Exception( ReadProperties.mensajes.getProp("consultas.consultaclientes.errorconsultavacia") );
					}
				for (ReporteDatosCliente reporteDatosCliente : listaDatosCliente)
					{

					//Se obtiene el ultimo LD
					/*LogHandler.trace(uid, getClass(), "==> datosClienteRespuesta - obtenerDatosUltimoLD");
					HashMap<String,Object> resultContrato = (HashMap<String,Object>)sesionNTx.selectOne( "obtenerDatosUltimoLD",reporteDatosCliente.getCliente() );

					if(resultContrato == null) { continue; }
					reporteDatosCliente.setUltimoLD(  resultContrato.get("contrato_LD").toString() == null ||  resultContrato.get("contrato_LD").toString().equals("") ? "" :  resultContrato.get("contrato_LD").toString() );
					if( reporteDatosCliente.getUltimoLD() == null || reporteDatosCliente.getUltimoLD().trim().equals( "" ) )
					{
					continue;
					}

					reporteDatosCliente.setUltimoLD( resultContrato.get("contrato_LD").toString());
					*/
					reporteDatosCliente.setReferenciabanamex(Funciones.obtenerCadenaBanamex(reporteDatosCliente.getUltimoLD()));
					reporteDatosCliente.setReferenciabancomer(Funciones.obtenerCadenaBancomer(reporteDatosCliente.getUltimoLD()));

					/*
					reporteDatosCliente.setSucursal	(resultContrato.get("sucursal").toString());
					reporteDatosCliente.setMontoOtorgado(Double.parseDouble( resultContrato.get("montoOtorgado").toString() == null ? "0.0" : resultContrato.get("montoOtorgado").toString() ));
					reporteDatosCliente.setEstatus(resultContrato.get("estatus").toString());

					reporteDatosCliente.setCodigoGrupo	( resultContrato != null && resultContrato.get("CodigoGrupo") != null ? resultContrato.get("CodigoGrupo").toString() : "" );
					reporteDatosCliente.setNombreGrupo	( resultContrato != null && resultContrato.get("NombreGrupo") != null ? resultContrato.get("NombreGrupo").toString() : "" );
				    */
					if (reporteDatosCliente.getTipoIdentificacion() != null
								&& !reporteDatosCliente.getTipoIdentificacion().equals("CIFE"))
							{
							reporteDatosCliente.setNumeroIdentificacion(null);
							}


					/*
					 * final java.lang.String telefono = (String) sesionNTx.selectOne( "obtenerTelefonoKitImpresion", reporteDatosCliente.getCliente());
					reporteDatosCliente.setTelefono( telefono );
					*/

					/*
					//Se obtiene el ultimo LD

					LogHandler.trace(uid, getClass(), "==> datosClienteRespuesta - obtenerUltimoLD");
					final String ultimoLD = (String)sesionNTx.selectOne( "obtenerUltimoLD",reporteDatosCliente.getCliente() );

					reporteDatosCliente.setUltimoLD( ultimoLD == null || ultimoLD.equals("")? reporteDatosCliente.getContratoLD() : ultimoLD.toString() );

					if( reporteDatosCliente.getUltimoLD() == null || reporteDatosCliente.getUltimoLD().trim().equals( "" ) )
						{
						continue;
						}
					
					reporteDatosCliente.setReferenciabanamex(Funciones.obtenerCadenaBanamex(reporteDatosCliente.getUltimoLD()));
					reporteDatosCliente.setReferenciabancomer(Funciones.obtenerCadenaBancomer(reporteDatosCliente.getUltimoLD()));
					//Se obtiene para unca consulta superior
					LogHandler.trace(uid, getClass(), "==> datosClienteRespuesta - dsObtenerUltimoLD");
					String contratoult = (String) sesionNTx.selectOne("dsObtenerUltimoLD",reporteDatosCliente.getUltimoLD());

				    if (contratoult == null || contratoult.trim().equals("")){
				    reporteDatosCliente.setUltimoLD(ultimoLD.toString());			}

					final java.util.HashMap<String,String>
									parametrosDatosContrato= new HashMap<String, String>();
									parametrosDatosContrato.put( "persona" , reporteDatosCliente.getCliente());
									parametrosDatosContrato.put( "contrato" , contratoult );//ultimoLD.get( "contrato" ).toString());

					LogHandler.trace(uid, getClass(), "==> datosClienteRespuesta - obtenerDatosultimocontrato");
					HashMap<String,Object> resultContrato = (HashMap<String,Object>)sesionNTx.selectOne("obtenerDatosultimocontrato", parametrosDatosContrato);
					reporteDatosCliente.setSucursal	(resultContrato.get("sucursal").toString());
					reporteDatosCliente.setMontoOtorgado(Double.parseDouble( resultContrato.get("montoOtorgado").toString() == null ? "0.0" : resultContrato.get("montoOtorgado").toString() ));
					reporteDatosCliente.setEstatus(resultContrato.get("estatus").toString());

					reporteDatosCliente.setCodigoGrupo	( resultContrato != null && resultContrato.get("CodigoGrupo") != null ? resultContrato.get("CodigoGrupo").toString() : "" );
					reporteDatosCliente.setNombreGrupo	( resultContrato != null && resultContrato.get("NombreGrupo") != null ? resultContrato.get("NombreGrupo").toString() : "" );

					if (reporteDatosCliente.getTipoIdentificacion() != null && !reporteDatosCliente.getTipoIdentificacion().equals("CIFE"))
							{
							reporteDatosCliente.setNumeroIdentificacion(null);
							}

						*/
					}

				result.setReporteDatosCliente( listaDatosCliente );
				}
			else
				{
					throw new Exception(ReadProperties.mensajes.getProp("consultas.consultaclientes.errorfiltros"));

				}
			}
		catch (Exception e)
			{
			LogHandler.error(uid, getClass(), e.getMessage(), e);
			result.getHeader().setUID(uid);
			result.getHeader().setEstatus( false );
			result.getHeader().setMensaje( e.getMessage());
			}
		finally
			{
			FabricaConexiones.close( sesionNTx );
			FabricaConexiones.close( sesionBatch);
			}
		return result;
		}

	/*
	 * (non-Javadoc)
	 * @see tarea.consultas.Consultas#consultaDesembolso(utilitario.mensajes.reportes.cierre.ReporteDesembolsoPeticion, java.lang.String)
	 */
	@SuppressWarnings("unchecked")

	public DesembolsoOpenContractRespuesta consultaDesembolso(ReporteDesembolsoPeticion peticion, String uid)
		{
		final DesembolsoOpenContractRespuesta result = new DesembolsoOpenContractRespuesta();

		SqlSession sesionBatch = null;
		SqlSession sesionNTx = null;

		result.setHeader(new EncabezadoRespuesta());
		LogHandler.debug(uid, getClass(), "Valores de entrada : " + peticion);

		//Formatear fechas
		final java.text.SimpleDateFormat simpleDateFormat = new  SimpleDateFormat("yyyyMMdd");

		//Separando los datos del filtro
		final java.util.Map<String, Object> filtros = new HashMap<String, Object>();

		//Validacion de nulos
		if ( peticion.getContrato() == null || peticion.getContrato().trim().equals( "" ) )
			{
			peticion.setContrato( null );
			}
		if ( peticion.getNombreGrupo() == null || peticion.getNombreGrupo().trim().equals( "" ) )
			{
			peticion.setNombreGrupo( null );
			}
		if ( peticion.getAsesor() == null || peticion.getAsesor().trim().equals( "" ) )
			{
			peticion.setAsesor( null );
			}
		if ( peticion.getSucursal() == null || peticion.getSucursal() == 0 || peticion.getSucursal() == 120 )
			{
			peticion.setSucursal( null );
			}

		//La fecha que puede ser opcional
		final java.util.Date fechaOpcion = peticion.getFecha() != null ?
										   peticion.getFecha() : comun.obtenerFechaContable(uid).getFecha();
		//Carga de parametros
		filtros.put( "fechaCierre"			 , simpleDateFormat.format( fechaOpcion ) );
		filtros.put( "fechaDisposicionInicio", peticion.getFechaInicialInicio() );
		filtros.put( "fechaDisposicionFinal" , peticion.getFechaInicialFinal()  );
		filtros.put( "fechaLiquidacionInicio", peticion.getFechaTerminoInicio() );
		filtros.put( "fechaLiquidacionFinal" , peticion.getFechaTerminoFinal()	 );
		filtros.put( "contrato" 			 , peticion.getContrato()		 	 );
		filtros.put( "nombreGrupo"			 , peticion.getNombreGrupo() 		 );
		filtros.put( "sucursal" 			 , peticion.getSucursal() 			 );
		filtros.put( "asesor" 				 , peticion.getAsesor() 			 );

		try	{
			sesionBatch = FabricaConexiones.obtenerSesionBatch();
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if (peticion.getContrato() != null && peticion.getContrato().trim().startsWith("LD"))
				{
				peticion.setContrato(comun.obtenerNumeroContrato(uid, peticion.getContrato()));
				filtros.put( "contrato" 			 , peticion.getContrato()		 	 );
				}

			//Numero de registros a procesar
			LogHandler.trace(uid, getClass(), "==> consultaDesembolso - obtenerTotalRegistrosReporteCierreOpenContract");
			final java.lang.Integer total =
					(Integer) sesionBatch.selectOne( "obtenerTotalRegistrosReporteCierreOpenContract" , filtros );

			//Errores al obtener el total de registros
			if ( total == null )
				{
				throw new Exception(ReadProperties.mensajes.getProp("consultas.consultadesembolso.errorconsulta"));
				}
			else
				{
				if (total == 0)
					{
					throw new Exception(ReadProperties.mensajes.getProp("ciof.error.consultas.registrosvacios"));
					}
				result.setNumeroResultados( total );

				//Se ejecuta la consulta principal
				LogHandler.trace(uid, getClass(), "==> consultaDesembolso - obtenerReporteCierreDesembolsoOpenContract");
				final java.util.List<DesembolsoOpenContractOV>
						 		   listaDesembolsoOpenContract = (List<DesembolsoOpenContractOV>)
						 		   sesionBatch.selectList("obtenerReporteCierreDesembolsoOpenContract", filtros );

				if ( listaDesembolsoOpenContract == null )
					{	throw new Exception(ReadProperties.mensajes.getProp("consultas.consultadesembolso.errorconsulta") ); 	}

				//Calculo de la tasa
				for ( DesembolsoOpenContractOV desembolsoOpenContractOV : listaDesembolsoOpenContract )
					{
					//Tasa no nula
					if ( desembolsoOpenContractOV.getTasa() == null 	)
						{
						desembolsoOpenContractOV.setTasa( 0.0 );
						}
					//Iva no nulo
					if ( desembolsoOpenContractOV.getIva() == null 	)
						{
						desembolsoOpenContractOV.setIva( 0.0 );
						}

					//Calculo de la tasa anualizada
					desembolsoOpenContractOV.setTasa( desembolsoOpenContractOV.getTasa()
							* ( 1 + desembolsoOpenContractOV.getIva() / 100) );
					desembolsoOpenContractOV.setTasa( desembolsoOpenContractOV.getTasa() * 12 );

					final java.text.NumberFormat numberFormat  = new DecimalFormat(",###.00");
					desembolsoOpenContractOV.setTasa(
							Double.valueOf( numberFormat.format( desembolsoOpenContractOV.getTasa() ) ) );

					//Se coloca el nombre del asesor
					if ( desembolsoOpenContractOV.getAsesor() != null )
						{
						final AsesorOV asesorOV = AsesorData.obtenAsesor(uid, desembolsoOpenContractOV.getAsesor().trim() );
						if ( asesorOV != null)
							{
							desembolsoOpenContractOV.setNombreAsesor( asesorOV.getNombreCompleto() );
							}
						}

					desembolsoOpenContractOV.setMontoReal(
							desembolsoOpenContractOV.getMontoPrestamo() - desembolsoOpenContractOV.getMontoDevuelto() );

					}

				result.setReporteOpenContract( listaDesembolsoOpenContract );
				}
			}
		catch ( java.lang.Exception exception )
			{
			result.getHeader().setEstatus(false);
			result.getHeader().setUID(uid);
			result.getHeader().setMensaje(exception.getMessage());
			LogHandler.error(uid, getClass(), "Error ocurrido : " + exception.getMessage(), exception);
			}
		finally
			{
			FabricaConexiones.close( sesionBatch );
			FabricaConexiones.close( sesionNTx   );
			}

		return result;
		}

	//Funciones privadas  ----------------------------------------------------------------------------------

	private int getDiasTranscurridos(Date fechaDisposicion,String uid) {
		try {
			LogHandler.debug(uid, this.getClass(), "Calculando los dias");
			Date actual = new Date();
			GregorianCalendar date1 = new GregorianCalendar();
			GregorianCalendar date2 = new GregorianCalendar();
			date1.setTime(fechaDisposicion);
			date2.setTime(actual);
			GregorianCalendar dateTemp = null;
			int diff = (date2.get(Calendar.YEAR)) - (date1.get(Calendar.YEAR));
			dateTemp = (GregorianCalendar) date1.clone();

			int sum = 0;
			for (int i =0; i < diff; i++)
				{
				sum += dateTemp.isLeapYear(dateTemp.get(Calendar.YEAR)) ? 366 : 365;
				dateTemp.add(Calendar.YEAR, 1);
				}
			int numeroCorrectoDias = sum + ((date2.get(Calendar.DAY_OF_YEAR) - (date1.get(Calendar.DAY_OF_YEAR))));
			return numeroCorrectoDias;
		} catch(Exception e) {
			LogHandler.error(uid, this.getClass(), "Error al Recuperar los datos del Contrato: " + e.getMessage(), e);
			return 0;
		}
	}

	public ConsultaOportunidadRespuesta consultaContratoOportunidad(ConsultaOportunidadPeticion peticion, String uid) {
		ConsultaOportunidadRespuesta resp = new ConsultaOportunidadRespuesta();
		resp.setHeader( new EncabezadoRespuesta() );
		SqlSession sesion = null;

		try {
			sesion = FabricaConexiones.obtenerSesionNTx();

			LogHandler.trace( uid, getClass(), "==> consultaSaldoCredito - consultaCreditoOportunidad" );
			String categoriaCredito = (String) sesion.selectOne("consultaCreditoOportunidad", peticion.getNumeroContrato());
			if (  categoriaCredito != null )
				{
				if (categoriaCredito.startsWith("OPO"))
					{
					resp.setIsOportunidad(true);
					}
				else
					{
					resp.setIsOportunidad(false);
					}
				}
			else
				{
				throw new Exception(ReadProperties.mensajes.getProp("ciof.contratoinvalido"));
				}
			}
		catch (Exception e)
			{
			resp.setIsOportunidad(false);
			resp.getHeader().setMensaje(e.getMessage());
			resp.getHeader().setUID(uid);
			LogHandler.error(uid, getClass(), "Error ocurrido : " + e.getMessage(), e);
			}
		finally
			{
			FabricaConexiones.close( sesion );
			}
		return resp;
	}

	@SuppressWarnings("unchecked")
	public ClienteHistoricoRespuesta consultaHistorialCliente(ConsultaDatosClientePeticion peticion, String uid) {
		   ClienteHistoricoRespuesta respuesta = new ClienteHistoricoRespuesta();
		respuesta.setHeader( new EncabezadoRespuesta() );
		SqlSession sesionNTx = null;

		try
			{
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.debug(uid, getClass(), "==> consultaDatosGrupo - obtenerDatosGrupoHistorico");
			final List<ClientesHistorico> datosGrupoResList =
					(List<ClientesHistorico>) sesionNTx.selectList( "obtenerDatosGrupoHistorico", peticion.getClavePersona());
			if ( datosGrupoResList == null )
				{
				throw new Exception(ReadProperties.mensajes.getProp("consultas.consultasaldocredito.errorregistrosvacios") ); }

			if ( datosGrupoResList.size() == 0 )
				{
				throw new Exception( ReadProperties.mensajes.getProp("consultas.consultasaldocredito.errorregistrosvacios") );
				}

			respuesta.setDatosHistoricos(datosGrupoResList);
			}
		catch (Exception e)
			{
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(e.getMessage());
			respuesta.getHeader().setEstatus(false);
			LogHandler.error(uid, getClass(), "Error ocurrido : " + e.getMessage(),e);
			}
		finally
			{
			FabricaConexiones.close( sesionNTx );
			}
		return respuesta;
	}


	public GrupoHistoricoRespuesta consultaHistorialGrupo(ConsultaDatosClientePeticion peticion, String uid)
	{
		GrupoHistoricoRespuesta respuesta = new GrupoHistoricoRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		SqlSession sesionNTx = null;

		try
			{
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(), "==> consultaDatosGrupo - ultimoLDGrupo");
			String GrupoLD = (String) sesionNTx.selectOne("ultimoLDGrupo", peticion.getClavePersona());
			respuesta.setUltimoLD(GrupoLD);
			}
		catch (Exception ex)
			{
			respuesta.getHeader().setMensaje(ex.getMessage());
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setUID(uid);
			LogHandler.error(uid, getClass(), "Error ocurrido : " + ex.getMessage(),ex);
			}
		finally
			{
			FabricaConexiones.close( sesionNTx );
			}

		return respuesta;
	}

	/*
	 * (non-Javadoc)
	 * @see tarea.consultas.Consultas#consultaSISEFIN(utilitario.mensajes.consultas.ConsultaSISEFINPeticion, java.lang.String)
	 */
	@SuppressWarnings("unchecked")

	public ConsultaSISEFINRespuesta consultaSISEFIN(ConsultaSISEFINPeticion peticion,String uid)
		{
		//Se crea el objecto de respuesta
		final 	ConsultaSISEFINRespuesta
				consultaSISEFINRespuesta = new ConsultaSISEFINRespuesta();
				consultaSISEFINRespuesta.setHeader( new EncabezadoRespuesta() );

		SqlSession sesionBatch = null;

		try {
			//apertura de las sesiones
			sesionBatch = FabricaConexiones.obtenerSesionBatch();

			//Parametros para la consulta
			final HashMap<String,Object>
									params = new HashMap<String, Object>();
									params.put( "sucursal" 		 , peticion.getSucursal() 		 );
									params.put( "nombre"   		 , peticion.getNombre() 		 );
									params.put( "apellidoPaterno", peticion.getApellidoPaterno() );
									params.put( "apellidoMaterno", peticion.getApellidoMaterno() );
									params.put( "codigoPersona"	 , peticion.getCodigo() 		 );
									params.put( "contratoLD"	 , peticion.getContratoLD() 	 );
									params.put( "claveGrupo"	 , peticion.getGrupo() 			 );
									params.put( "fechaInicio"	 , peticion.getFechaInicio()     );
									params.put( "fechaFin"		 , peticion.getFechaFin() 		 );

			LogHandler.trace(uid, getClass(), "==> consultaSISEFIN - consultarDatosSISEFIN");
			List<ConsultaSISEFINVO>
						resultado = ( List<ConsultaSISEFINVO> ) sesionBatch.selectList("consultarDatosSISEFIN", params);

			if( resultado == null || resultado.isEmpty() )
				{
				throw new java.lang.Exception( ReadProperties.mensajes.getProp( "ciof.error.consultas.registrosvacios" ) );
				}

			final java.util.HashMap< Object, ConsultaSISEFINVO> mapUnique = new HashMap<Object, ConsultaSISEFINVO>();

			//Quita duplicados
			for ( ConsultaSISEFINVO consultaSISEFINVO : resultado )
				{
				mapUnique.put( consultaSISEFINVO.getCodigoCliente() , consultaSISEFINVO );
				}

			//Despues de limpiar los resultados se guardan en el objeto respuesta
			resultado = new ArrayList<ConsultaSISEFINVO>( mapUnique.values() );

			consultaSISEFINRespuesta.setResultado( resultado );
			}
		catch ( java.lang.Exception exception )
			{
			consultaSISEFINRespuesta.getHeader().setMensaje(exception.getMessage());
			consultaSISEFINRespuesta.getHeader().setEstatus(false);
			consultaSISEFINRespuesta.getHeader().setUID(uid);
			consultaSISEFINRespuesta.setResultado(new ArrayList<ConsultaSISEFINVO>());
			LogHandler.error(uid, getClass(), "Error ocurrido en la consulta : " + exception.getMessage(), exception);
			}
		finally
			{
			FabricaConexiones.close( sesionBatch );
			}
		return consultaSISEFINRespuesta;
		}

	/*
	 * (non-Javadoc)
	 * @see tarea.consultas.Consultas#consultaSaldosAFavor(
	 * utilitario.mensajes.consultas.ConsultaSaldosAFavorPeticion, java.lang.String)
	 */
	@SuppressWarnings("unchecked")

	public ConsultaSaldosAFavorRespuesta consultaSaldosAFavor(ConsultaSaldosAFavorPeticion peticion, String uid)
		{
		//Se crea el objecto de respuesta
		final 	ConsultaSaldosAFavorRespuesta
				consultaSaldosAFavorRespuesta = new ConsultaSaldosAFavorRespuesta();
				consultaSaldosAFavorRespuesta.setEncabezadoRespuesta( new EncabezadoRespuesta() );

	    SqlSession sesionNTx = null;

		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if ( peticion.getContrato() != null) {
				peticion.setContrato(comun.obtenerNumeroContrato(uid, peticion.getContrato()));
			}
			//Parametros para la consulta
			final java.util.HashMap<String,Object>
										param = new HashMap<String, Object>();
										param.put( "contrato" , peticion.getContrato());
										param.put( "sucursal" , peticion.getSucursal() == null
												|| peticion.getSucursal() == 0
												|| peticion.getSucursal() == 120 ? null : peticion.getSucursal() );

			LogHandler.trace(uid, getClass(), "==> consultaSaldosAFavor - obtenerSaldoFavor");
			final List<SaldoAFavorVO>
								resultado = ( List<SaldoAFavorVO> ) sesionNTx.selectList( "obtenerSaldoFavor", param);
			if ( resultado == null || resultado.size() == 0)
				{	throw new Exception( "No hay datos a mostrar." );			}

			consultaSaldosAFavorRespuesta.setListaSaldos( resultado );
			}
		catch ( java.lang.Exception exception )
			{
			consultaSaldosAFavorRespuesta.getEncabezadoRespuesta().setMensaje(exception.getMessage());
			consultaSaldosAFavorRespuesta.getEncabezadoRespuesta().setEstatus(false);
			consultaSaldosAFavorRespuesta.getEncabezadoRespuesta().setUID(uid);
			consultaSaldosAFavorRespuesta.setListaSaldos(new ArrayList<SaldoAFavorVO>());
			LogHandler.error(uid, getClass(), "Error ocurrido en la consulta : " + exception.getMessage(), exception);
			}
		finally
			{
			FabricaConexiones.close( sesionNTx );
			}
		return consultaSaldosAFavorRespuesta;
		}

	/*
	 * (non-Javadoc)
	 * @see tarea.consultas.Consultas#verificarDiaHabil(utilitario.mensajes.consultas.ConsultaCreditoPeticion)
	 */

	public ConsultaDiaHabilRespuesta verificarDiaHabil(ConsultaDiaHabilPeticion peticion, String uid) 
		{
		SqlSession 					sesionNTx			= null ;
		Map<String, Object>			params		 		= new HashMap<String, Object>( );
		Integer						respuesta			= null;
		ConsultaDiaHabilRespuesta regreso				= new ConsultaDiaHabilRespuesta();

		params.put( "fecha"	  , peticion.getBody().getFecha() );
		params.put( "sucursal", peticion.getBody().getSucursal() );
		params.put( "codigo"  , "CDES" );

		try	{
			sesionNTx 		= FabricaConexiones.obtenerSesionNTx( );

			LogHandler.trace(uid, getClass(), "==> verificarDiaHabil - verificaDiaNoHabDom");
			respuesta 	= (Integer) sesionNTx.selectOne( "verificaDiaNoHabDom", params );

			regreso.setIdentificador( "" + respuesta );
			regreso.getHeader().setEstatus( true );
			}
		catch ( java.lang.Exception exception )
			{
			regreso.getHeader().setMensaje( exception.getMessage() );
			regreso.getHeader().setEstatus( false );
			regreso.getHeader().setUID(uid);
			regreso.setIdentificador( "0" );
			LogHandler.error( uid, this.getClass(), "Ocurrio error al validarFechaInicioContrato: "
			+ exception.getMessage(), exception);
			}
		finally
			{
			FabricaConexiones.close( sesionNTx );
			}
		return regreso;
		}

	/*
	 * (non-Javadoc)
	 * @see tarea.consultas.Consultas#obtenerDiasInhabiles(
	 * utilitario.mensajes.originacion.consulta.ConsultaDiasInhabilesPeticion, java.lang.String)
	 */
	@SuppressWarnings("unchecked")

	public ObtenerDiasInhabilesRespuesta obtenerDiasInhabiles(ConsultaDiasInhabilesPeticion peticion, String uid)
		{
		SqlSession 						sesionNTx		= null ;
		HashMap<String, Object>			params		 	= new HashMap<String, Object>( );
		ObtenerDiasInhabilesRespuesta 	regreso			= new ObtenerDiasInhabilesRespuesta();

		//Formato de la fecha
		final java.text.SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
		try	{
			//Se validan los datos de entrada
			if ( peticion == null || peticion.getBody() == null
					|| peticion.getBody().getYear() == null
					|| peticion.getBody().getSucursal() == null
					|| peticion.getBody().getYear() < 2000 )
				{
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.datos.incompletos" ) );
				}

			//Se arma la conexion a la base de datos
			sesionNTx 		= FabricaConexiones.obtenerSesionNTx( );

			//Se bajan los parametros
			final 	Calendar
					calendarIni = Calendar.getInstance();
					calendarIni.set( Calendar.DAY_OF_MONTH , 1 );
					calendarIni.set( Calendar.MONTH 	   , 0 );
					calendarIni.set( Calendar.YEAR 		   , peticion.getBody().getYear() );

			final 	Calendar
					calendarFin = Calendar.getInstance();
					calendarFin.set( Calendar.DAY_OF_MONTH , 31 );
					calendarFin.set( Calendar.MONTH 	   , 11 );
					calendarFin.set( Calendar.YEAR 		   , peticion.getBody().getYear() );

			params.put( "fechaInicio", simpleDateFormat.format( calendarIni.getTime() ) );
			params.put( "fechaFin"   , simpleDateFormat.format( calendarFin.getTime() ));
			params.put( "sucursal"	 , peticion.getBody().getSucursal() );

			//Se ejecuta la consulta
			LogHandler.trace(uid, getClass(), "==> obtenerDiasInhabiles - obtenerDiasNoHabiles");
			regreso.setDiasHabiles( (List<Date>) sesionNTx.selectList("obtenerDiasNoHabiles", params ));
			}
		catch ( java.lang.Exception exception )
			{
			regreso.getHeader().setMensaje( exception.getMessage() );
			regreso.getHeader().setEstatus( false );
			regreso.getHeader().setUID(uid);
			LogHandler.error( uid, this.getClass(), "Ocurrio error al obtenerDiasInhabiles: "
			+ exception.getMessage(), exception);
			}
		finally
			{
			FabricaConexiones.close( sesionNTx );
			}
		return regreso;
		}

	/*
	 * (non-Javadoc)
	 * @see tarea.consultas.Consultas#consultarCAT(utilitario.mensajes.consultas.ConsultaCATPeticion, java.lang.String)
	 */

	public ConsultaCATRespuesta consultarCAT(ConsultaCATPeticion peticion, String uid) 
		{
		LogHandler.info(uid, getClass(), "Entrando en consultarCAT");
		final ConsultaCATRespuesta consultaCATRespuesta = new ConsultaCATRespuesta();
		final java.text.DecimalFormat decimalFormat = new java.text.DecimalFormat( "0.00" );

        java.lang.Double 	TIR = 0D;
        java.lang.Double 	is = .00;
        java.lang.Double 	res = 0.0;
        java.lang.Double 	inc = 0.0;
        java.lang.Integer 	contador = 0;

        //Inicia el ciclo
        do 	{
            TIR = 0D;

            for ( Integer i = 0; i < peticion.getPagos().size(); i++ )
            	{
                TIR =  TIR + peticion.getPagos().get( i ) / ( Math.pow( (1 + is),
                		((i + 1) / Double.valueOf( "" + peticion.getPeriodo() ) ) ) );
                }

            res = peticion.getMontoCredito() * -1 + TIR;

            if (res > 10000) { inc = .001;   			}

            if (res >= 1000 && res <=10000) { inc = .001; }

            if (res < 1000) { inc = .0001;               }

            if (res < 100) { inc = .00001;			    }

            if (res < 10) { inc = .000001; 				}

            if (res < 1) { inc = .0000001; 				}

            if (res < .01) { inc = .000000001; 			}

            if (res < .0001) { inc = .0000000001; 		}

            is += inc;
            contador ++;
        	}
        while((res > .000001 || res <-.000001) && is < 15.0 && res >= 0);

        is *= 100;
        consultaCATRespuesta.setCAT( Double.valueOf( decimalFormat.format( is ) ) );

        LogHandler.info(uid, getClass(), "Ciclos ejecutados : " + contador );

        return consultaCATRespuesta;
		}

	/*
	 * (non-Javadoc)
	 * @see tarea.consultas.Consultas#consultarMovimientos(
	 * utilitario.mensajes.consultas.ConsultarMovimientosPeticion, java.lang.String)
	 */
	@SuppressWarnings("unchecked")

	public ConsultarMovimientosRespuesta consultarMovimientos(ConsultarMovimientosPeticion peticion, String uid)
		{
		org.apache.ibatis.session.SqlSession sesionNTx	= null;
		final ConsultarMovimientosRespuesta respuesta	= new ConsultarMovimientosRespuesta();
		try	{
			//Seccion para la validaciones
			if ( peticion.getContrato() == null || peticion.getTipoMoviemiento() == null )
				{
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.datos.incompletos" ) );
				}

			//Se cambia el numero de contrato a credprod
			peticion.setContrato( comun.obtenerNumeroContrato( uid, peticion.getContrato() ) );

			//Se abre la conexion a la base
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			//parametros de la consulta
			final java.util.HashMap<String,String>
										parametros = new HashMap<String, String>();
										parametros.put( "contrato", peticion.getContrato() );
										parametros.put( "tipoOperacion", peticion.getTipoMoviemiento() );

			LogHandler.trace(uid, getClass(), "==> consultarMovimientos - consultarMovimientos" );
			final java.util.ArrayList<MovimientoOV>
									movimientosList = ( ArrayList<MovimientoOV> )
									sesionNTx.selectList( "consultarMovimientos", parametros );

			//Se valida que la consulta arroje algun resultado
			if ( movimientosList == null || movimientosList.isEmpty() )
				{
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.consultas.registrosvacios" ) );
				}

			//Asignacion de los resultados a la respuesta
			respuesta.setMovimientos( movimientosList );
			}
		catch ( java.lang.Exception exception )
			{
			respuesta.getHeader().setMensaje( exception.getMessage() );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setUID	( uid );
			LogHandler.error( uid, this.getClass(), "Ocurrio error al consultarMovimientos: "
			+ exception.getMessage(), exception );
			}
		finally {
			FabricaConexiones.close(sesionNTx);
		}

		return respuesta;
		}

	/*
	 * (non-Javadoc)
	 * @see tarea.consultas.Consultas#consultarCreditosAsignados(
	 * utilitario.mensajes.consultas.ConsultarCreditosAsignadosPeticion, java.lang.String)
	 */
	@SuppressWarnings("unchecked")

	public ConsultarCreditosAsignadosRespuesta consultarCreditosAsignados(
			ConsultarCreditosAsignadosPeticion peticion, String uid) {
		ConsultarCreditosAsignadosRespuesta respuesta = new ConsultarCreditosAsignadosRespuesta();
		EncabezadoRespuesta header = new EncabezadoRespuesta();
		SqlSession sesion = null;

		try {
			sesion = FabricaConexiones.obtenerSesionNTx();

			final HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("asesor", peticion.getAsesor() == null
					|| peticion.getAsesor().trim().equals( "" ) ? null : peticion.getAsesor() );
			parametros.put("sucursal", peticion.getSucursal());

			LogHandler.trace(uid, getClass(), " ==> consultarCreditosAsignados");
			final List<CreditosAsignadosOV> listaCreditos =
					(List<CreditosAsignadosOV>) sesion.selectList("consultarCreditosAsignados", parametros);

			if (!listaCreditos.isEmpty()) {
				respuesta.setCreditosAsignados(listaCreditos);
			} else {
				throw new Exception(ReadProperties.mensajes.getProp("ciof.error.consultas.registrosvacios"));
			}

			header.setCodigo("");
			header.setMensaje("");
			header.setEstatus(true);
			header.setUID(uid);
			respuesta.setHeader(header);

			return respuesta;
		} catch (Exception e) {
			LogHandler.error(uid, getClass(), e.getMessage(), e);
			if (sesion != null) {
				sesion.rollback();
			}
			header.setMensaje(e.getMessage());
			header.setEstatus(false);
			header.setUID(uid);
			respuesta.setHeader(header);
			return respuesta;
		} finally {
			FabricaConexiones.close(sesion);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see tarea.consultas.Consultas#consultarReasignaciones(
	 * utilitario.mensajes.consultas.ConsultarReasignacionesPeticion, java.lang.String)
	 */
	@SuppressWarnings("unchecked")

	public ConsultarReasignacionesRespuesta consultarReasignaciones(ConsultarReasignacionesPeticion peticion, String uid) 
		{
		org.apache.ibatis.session.SqlSession sesionNTx	= null;
		final ConsultarReasignacionesRespuesta respuesta	= new ConsultarReasignacionesRespuesta();
		try	{
			//Seccion para la validaciones
			if ( peticion.getAsesor() == null && peticion.getSucursal() == null &&
				 ( peticion.getFechaFin() == null || peticion.getFechaInicio() == null ) )
				{
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.datos.incompletos" ) );
				}

			//Se abre la conexion a la base
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			final java.text.SimpleDateFormat simpleDateFormatFechaInicio = new SimpleDateFormat( "yyyy-MM-dd 00:00:01.000" );
			final java.text.SimpleDateFormat simpleDateFormatFechaFinal	 = new SimpleDateFormat( "yyyy-MM-dd 23:59:59.999" );

			final java.util.HashMap<String, Object>
					parametrosConsulta = new HashMap<String, Object>();
					parametrosConsulta.put( "sucursal" , peticion.getSucursal() != null
							&& peticion.getSucursal().intValue() != 0 ? peticion.getSucursal() : null );
					parametrosConsulta.put( "asesor" , peticion.getAsesor() != null
							&& !peticion.getAsesor().trim().equals( "" ) ? peticion.getAsesor() : null );
					parametrosConsulta.put( "fechaInicio" , peticion.getFechaInicio() != null
							? simpleDateFormatFechaInicio.format( peticion.getFechaInicio() ) : null );
					parametrosConsulta.put( "fechaFin" , peticion.getFechaFin() != null
							? simpleDateFormatFechaFinal.format( peticion.getFechaFin() ) : null );
					parametrosConsulta.put( "zona" , peticion.getZona() != null
							&&  peticion.getZona().intValue() != -1 ?  peticion.getZona() : null );

			LogHandler.trace(uid, getClass(), "==> consultarMovimientos - consultarReasignaciones" );
			final java.util.ArrayList<ReasignacionOV>
									reasignaciones = (ArrayList<ReasignacionOV>)
									sesionNTx.selectList( "consultarReasignaciones", parametrosConsulta );

			//Se valida que la consulta arroje algun resultado
			if ( reasignaciones == null || reasignaciones.isEmpty() )
				{
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.consultas.registrosvacios" ) );
				}

			//Se coloca el nombre de los asesores
			for ( ReasignacionOV reasignacionOV : reasignaciones )
				{
				reasignacionOV.setNombreAsesorOriginal(AsesorData.obtenAsesor(
						uid, reasignacionOV.getNombreAsesorOriginal() ).getNombreCompleto() );
				reasignacionOV.setNombreAsesorReasignado(AsesorData.obtenAsesor(
						uid, reasignacionOV.getNombreAsesorReasignado() ).getNombreCompleto() );
				}

			respuesta.setResultado( reasignaciones );
			}
		catch ( java.lang.Exception exception )
			{
			respuesta.getHeader().setMensaje( exception.getMessage() );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setUID( uid );
			LogHandler.error( uid, this.getClass(), "Ocurrio error al consultarReasignaciones: "
			+ exception.getMessage(), exception );
			}
		finally {
			FabricaConexiones.close(sesionNTx);
		}

		return respuesta;
		}

	/*
	 * (non-Javadoc)
	 * @see tarea.consultas.Consultas#consultarReasignacionesContrato(
	 * utilitario.mensajes.consultas.ConsultarReasignacionesPeticion, java.lang.String)
	 */
	@SuppressWarnings("unchecked")

	public ConsultarReasignacionesContratoRespuesta
	consultarReasignacionesContrato(ConsultarReasignacionesContratoPeticion peticion, String uid)
		{
		org.apache.ibatis.session.SqlSession sesionNTx			 = null;
		final ConsultarReasignacionesContratoRespuesta respuesta = new ConsultarReasignacionesContratoRespuesta();
		try	{
			//Seccion para la validaciones
			if ( peticion.getContrato() == null )
				{
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.datos.incompletos" ) );
				}

			//Se cambia el numero de contrato a credprod
			peticion.setContrato( comun.obtenerNumeroContrato( uid, peticion.getContrato() ) );

			//Se abre la conexion a la base
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			//Parametros para la consulta
			final java.util.HashMap<String, Object>
								parametrosConsulta = new HashMap<String, Object>();
								parametrosConsulta.put( "contrato" , peticion.getContrato() );

			LogHandler.trace(uid, getClass(), "==> consultarReasignacionesContrato - consultarReasignacionesContrato" );
			final java.util.ArrayList<ReasignacionContratoOV>
									reasignaciones = ( ArrayList<ReasignacionContratoOV> )
									sesionNTx.selectList( "consultarReasignacionesContrato", parametrosConsulta );

			//Se valida que la consulta arroje algun resultado
			if ( reasignaciones == null || reasignaciones.isEmpty() )
				{
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.consultas.registrosvacios" ) );
				}

			//Se coloca el nombre de asesores
			for ( ReasignacionContratoOV reasignacionContratoOV : reasignaciones )
				{
				reasignacionContratoOV.setNombreAsesorOriginal(AsesorData.obtenAsesor(
						uid, reasignacionContratoOV.getNombreAsesorOriginal()).getNombreCompleto() );
				reasignacionContratoOV.setNombreAsesorReasignado(AsesorData.obtenAsesor(
						uid, reasignacionContratoOV.getNombreAsesorReasignado()).getNombreCompleto() );
				//reasignacionContratoOV.setDiasMoraReasignacion(  )
				}

			//Se asigna el resultado de la consulta a la respuesta
			respuesta.setResultado( reasignaciones );
			}
		catch ( java.lang.Exception exception )
			{
			respuesta.getHeader().setMensaje( exception.getMessage() );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setUID( uid );
			LogHandler.error( uid, this.getClass(), "Ocurrio error al consultarReasignacionesContrato: " 
			+ exception.getMessage(), exception );
			}
		finally {
			FabricaConexiones.close(sesionNTx);
		}

		return respuesta;
		}

	/*
	 * (non-Javadoc)
	 * @see tarea.consultas.Consultas#consolidadoCreditosAsignados(
	 * utilitario.mensajes.consultas.ConsolidadoCreditosAsignadosPeticion, java.lang.String)
	 */

	public ConsolidadoCreditosAsignadosRespuesta consolidadoCreditosAsignados(
			ConsolidadoCreditosAsignadosPeticion peticion, String uid) {
		ConsolidadoCreditosAsignadosRespuesta respuesta = new ConsolidadoCreditosAsignadosRespuesta();
		EncabezadoRespuesta header = new EncabezadoRespuesta();
		SqlSession sesion = null;

		try {
			sesion = FabricaConexiones.obtenerSesionNTx();

			final HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("asesor", peticion.getAsesor());
			parametros.put("sucursal", peticion.getSucursal());

			LogHandler.trace(uid, getClass(), " ==> consolidadoCreditosAsignados");
			ConsolidadoCreditosAsignadosOV consolidado =
					(ConsolidadoCreditosAsignadosOV) sesion.selectOne("consolidadoCreditosAsignados", parametros);

			if (consolidado != null) {
				consolidado.setClientes((Integer) sesion.selectOne("consolidadoCreditosAsignadosClientes", parametros));
				respuesta.setConsolidadoCreditosAsignados(consolidado);
			} else {
				throw new Exception(ReadProperties.mensajes.getProp("ciof.error.consultas.registrosvacios"));
			}

			header.setCodigo("");
			header.setMensaje("");
			header.setEstatus(true);
			header.setUID(uid);
			respuesta.setHeader(header);

			return respuesta;
		} catch (Exception e) {
			LogHandler.error(uid, getClass(), e.getMessage(), e);
			if (sesion != null) {
				sesion.rollback();
			}
			header.setMensaje(e.getMessage());
			header.setEstatus(false);
			header.setUID(uid);
			respuesta.setHeader(header);
			return respuesta;
		} finally {
			FabricaConexiones.close(sesion);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see tarea.consultas.Consultas#generaActasRecaudacion(
	 * utilitario.mensajes.consultas.ConsultaCreditoPeticion, java.lang.String)
	 */
	@SuppressWarnings("unchecked")

	public GeneraActaRecaudacionRespuesta generaActasRecaudacion(ConsultaCreditoPeticion peticion, String uid)
		{
		org.apache.ibatis.session.SqlSession sesionNTx = null;
		org.apache.ibatis.session.SqlSession sesionTx = null;
		final GeneraActaRecaudacionRespuesta
								respuesta = new GeneraActaRecaudacionRespuesta();
								respuesta.getHeader().setUID( uid );	//UID
		try	{
			//Seccion para la validaciones
			if ( peticion.getContrato() == null || peticion.getUsuario() == null ) {
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.datos.incompletos" ) );
				}

			//Se cambia el numero de contrato a credprod
			peticion.setContrato( comun.obtenerNumeroContrato( uid, peticion.getContrato() ) );

			if ( peticion.getContrato() == null ) {
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.contratoinvalido" ) );
				}

			//Se abre la conexion a la base
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			//Comprobar si existen parcialidades cargadas
			LogHandler.trace(uid, getClass(), "==> generaActasRecaudacion - existenParcialidades");
			java.lang.Integer existeActa = (Integer) sesionNTx.selectOne( "existenParcialidades", peticion.getContrato() );

			//Si no hay registros, se crea el registro de la primer parcialidad
			if ( existeActa == null || existeActa == 0 )
				{
				//Se recuperan los datos del contrato
				final HashMap<String, Object> datosCredito = comun.obtenerDatosGeneralesContrato(uid, peticion.getContrato() );

				//Tesorero y Presidente
				LogHandler.trace(uid, getClass(), "==> generaActasRecaudacion - obtenerPresidenteTesorero");
				final HashMap<String, Object> datosTestPres =
						(HashMap<String, Object>) sesionNTx.selectOne( "obtenerPresidenteTesorero" , peticion.getContrato() );

				final ActaRecaudacionPeticion actaRecaudacionPeticion = new ActaRecaudacionPeticion();

				//Objeto para dar de alta el acta ... Cabecera
				final ActaRecaudacionOV
						actaRecaudacionOV = new ActaRecaudacionOV();
						actaRecaudacionOV.setContrato( peticion.getContrato() );
						LogHandler.trace(uid, getClass(), "==> generaActasRecaudacion - obtenerContratoLD");
						actaRecaudacionOV.setContratoLD(
								sesionNTx.selectOne("obtenerContratoLD", peticion.getContrato() ).toString() );
						actaRecaudacionOV.setFechaImprime( comun.obtenerFechaActual( uid ) );
						actaRecaudacionOV.setNumImprime( 1 );
						actaRecaudacionOV.setSucursal( Integer.valueOf( datosCredito.get( "sucursal" ).toString() ) );
						actaRecaudacionOV.setUsuarioImprime( peticion.getUsuario() );
						actaRecaudacionOV.setPresidenteNombre(
								datosTestPres != null && datosTestPres.get( "nombrePresidente" ) != null
								? (String) datosTestPres.get( "nombrePresidente" ) : "" );
						actaRecaudacionOV.setPresidenteDireccion(
								datosTestPres != null && datosTestPres.get( "direccionPresidente" ) != null
								? (String) datosTestPres.get( "direccionPresidente" ) : "" );
						actaRecaudacionOV.setTesoreroNombre(
								datosTestPres != null && datosTestPres.get( "nombreTesorero" )  != null
								? (String) datosTestPres.get( "nombreTesorero" ) : "" );
						actaRecaudacionOV.setTesoreroDireccion(
								datosTestPres != null && datosTestPres.get( "direccionTesorero" ) != null
								? (String) datosTestPres.get( "direccionTesorero" ) : "" );

				//La parcialidad
				final List<ActaRecaudacionParcialidadOV> parcialidades = new ArrayList<ActaRecaudacionParcialidadOV>();
				final ActaRecaudacionParcialidadOV
						actaRecaudacionParcialidadOV = new ActaRecaudacionParcialidadOV();
						actaRecaudacionParcialidadOV.setFechaCaptura( comun.obtenerFechaActual( uid ) );
						actaRecaudacionParcialidadOV.setNoPago( 1 );
						actaRecaudacionParcialidadOV.setFechaUltAct( comun.obtenerFechaActual( uid ) );
						actaRecaudacionParcialidadOV.setNumeroActualizacion( 1 );
						actaRecaudacionParcialidadOV.setUsuarioCaptura( peticion.getUsuario() );

				//Clientes
				final List<ActaRecaudacionClienteOV> clientes = new ArrayList<ActaRecaudacionClienteOV>();
				final ConsultaCreditoPeticion
						consultaCreditoPeticion = new ConsultaCreditoPeticion();
						consultaCreditoPeticion.setContrato( peticion.getContrato() );
						consultaCreditoPeticion.setSucursal( Integer.valueOf( datosCredito.get( "sucursal" ).toString() ) );
						consultaCreditoPeticion.setUsuario( peticion.getUsuario() );
				final DatosCreditoIntegrantesRespuesta
						datosCreditoIntegrantesRespuesta = obtenerDatosCreditoIntegrantes(uid, consultaCreditoPeticion);

				for ( DatosIntegranteResumenOV datosIntegranteResumenOV : datosCreditoIntegrantesRespuesta.getIntegrantes() )
					{
					final ActaRecaudacionClienteOV
							actaRecaudacionClienteOV = new ActaRecaudacionClienteOV();
							actaRecaudacionClienteOV.setApellidoMaterno( datosIntegranteResumenOV.getMaterno() );
							actaRecaudacionClienteOV.setApellidoPaterno( datosIntegranteResumenOV.getPaterno() );
							actaRecaudacionClienteOV.setIntegrante( datosIntegranteResumenOV.getCliente() );
							actaRecaudacionClienteOV.setNombre( datosIntegranteResumenOV.getNombre() );

					//Se agregan a la lista
					clientes.add( actaRecaudacionClienteOV );
					}

				//Se agregan los clientes a la parcialidad
				actaRecaudacionParcialidadOV.setClientes( clientes );

				//Se agrega la parcialidad a la lista
				parcialidades.add( actaRecaudacionParcialidadOV );

				//Se agregan las parcialidad al objeto de acta
				actaRecaudacionOV.setParcialidades( parcialidades );

				//Se agrega el objeto a la peticion
				actaRecaudacionPeticion.setActaRecaudacion( actaRecaudacionOV );

				final ActaRecaudacionRespuesta
						actaRecaudacionRespuesta = pagos.capturaActaRecaudacion( actaRecaudacionPeticion, uid );

				if ( !actaRecaudacionRespuesta.getHeader().isEstatus() )
					{
					throw new Exception( ReadProperties.mensajes.getProp( "operacion.actas.erroralgeneraracta" ) );
					}

				//Actualizacion numero de impresiones
				existeActa = 0;
				}

			//Parametros de entrada
			final java.util.HashMap<String, Object>
									parametrosActas = new HashMap<String, Object>();
									parametrosActas.put( "contrato" , peticion.getContrato() );

			LogHandler.trace(uid, getClass(), "==> consultarReasignacionesContrato - generaActarecaudacion" );
			final java.util.List<ActaRecaudacionOV>
					actaRecaudacion = (List<ActaRecaudacionOV>) sesionNTx.selectList( "generaActarecaudacion", parametrosActas );

			//Se valida que la consulta arroje algun resultado
			if ( actaRecaudacion == null || actaRecaudacion.isEmpty() )
				{
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.consultas.registrosvacios" ) );
				}
			//Se recupera el primer elemento de la lista, solo como referencia para poder llenar las demas parcialidades
			final ActaRecaudacionOV actaRecaudacionOV = actaRecaudacion.get( 0 );

			//Se asigna el primer elemento
			respuesta.setActaRecaudacion( actaRecaudacionOV );

			for ( ActaRecaudacionParcialidadOV actaRecaudacionParcialidadOV : respuesta.getActaRecaudacion().getParcialidades() )
				{
				if ( actaRecaudacionParcialidadOV.getNoPago() == 1 )
					{
					for ( ActaRecaudacionClienteOV actaRecaudacionClienteOV : actaRecaudacionParcialidadOV.getClientes() )
						{
						//Objeto para formatear a 2 decimales
						final java.text.DecimalFormat decimalFormat = new DecimalFormat( "#.00" );

						final java.util.HashMap<String , Object>
										parametros = new java.util.HashMap<String , Object>();
										parametros.put("contrato", peticion.getContrato());
										parametros.put("fechaActual",
												(new SimpleDateFormat( "yyyy-MM-dd" ) )
												.format(comun.obtenerFechaContable( uid ).getFecha( ) ) );

						//Se obtiene el saldo a favor del credito
						LogHandler.trace(uid, getClass(), "==> consultarReasignacionesContrato - obtenerSaldoFv" );
						final CreditoSaldo saldoFV = (CreditoSaldo) sesionNTx.selectOne("obtenerSaldoFv", parametros);

						//Se calcula el saldo total sistema
						actaRecaudacionClienteOV.setSaldoTotalSistema(Double.valueOf(
								decimalFormat.format(saldoFV.getSaldoLiquidar().doubleValue() *
										actaRecaudacionClienteOV.getSaldoTotalSistema().doubleValue() / 100.0 ) ) );
						}
					break;
					}
				}

			//Actualizacion de los cambios en las actas
			if ( existeActa.intValue() != 0 ) {
				sesionTx = FabricaConexiones.obtenerSesionTx();

				//Parametros para la actualizacion de las actas
				final HashMap<String, Object>
						parametrosActualizarActa = new HashMap<String, Object>();
						parametrosActualizarActa.put( "contrato" , peticion.getContrato() );
						parametrosActualizarActa.put( "usuarioImprime" , peticion.getUsuario() );
						parametrosActualizarActa.put( "numeroActualizacion" , peticion.getUsuario() );

				LogHandler.trace(uid, getClass(), "==> generaActasRecaudacion - actualizarParcialidad");
				sesionTx.update( "actualizarParcialidad", parametrosActualizarActa );

				sesionTx.commit( true );
				}
			}
		catch ( java.lang.Exception exception ) {
			FabricaConexiones.rollBack( sesionTx );
			respuesta.getHeader().setMensaje( exception.getMessage() );
			respuesta.getHeader().setEstatus( false );
			LogHandler.error( uid, this.getClass(), "Ocurrio error al generaActarecaudacion: "
			+ exception.getMessage(), exception );
			}
		finally {
			FabricaConexiones.close(sesionNTx);
			FabricaConexiones.close(sesionTx);
		}

		return respuesta;
		}

	@SuppressWarnings("unchecked")

	public ConcentradoActasRecaudacionRespuesta concentradoActasRecaudacion(
			ConcentradoActasRecaudacionPeticion peticion, String uid) {

			ConcentradoActasRecaudacionRespuesta concentradoActasRecaudacionRespuesta =
				new ConcentradoActasRecaudacionRespuesta();
			SqlSession session = null;
			concentradoActasRecaudacionRespuesta.setHeader(new EncabezadoRespuesta());
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

			try {
				session = FabricaConexiones.obtenerSesionNTx();
				if (peticion == null || peticion.getContrato().isEmpty() || peticion.getContrato().equals("0"))
				{
					throw new Exception(ReadProperties.mensajes.getProp("ciof.error.datos.incompletos"));
				}

				//Se convierten los contratos LD a credprod
				peticion.setContrato (comun.obtenerNumeroContrato(uid, peticion.getContrato() ) );
				if (peticion.getContrato() == null)
				{
					throw new Exception(ReadProperties.mensajes.getProp("ciof.contratoinvalido"));
				}

				//Se obtiene el Saldo Total del Sistema, el pago pactado y el saldo total del acta
				java.util.HashMap<String , Object> params = new java.util.HashMap<String , Object>();
				params.put("contrato", peticion.getContrato());
				params.put("fechaActual", simpleDateFormat.format(comun.obtenerFechaContable(uid).getFecha()));

				//Se obtiene el saldo a favor del credito
				final CreditoSaldo saldoFV = (CreditoSaldo)session.selectOne("obtenerSaldoFv", params);
				Double saldo_fv = (Double) saldoFV.getSaldoLiquidar();

				params.clear();
				params.put("contrato", peticion.getContrato());
				params.put("saldo_fv", saldo_fv);

				//Se obtiene el concentrado de actas de recaudacion
				List<ResumenRecaudacionOV> resumen = (List<ResumenRecaudacionOV>)
											session.selectList("obtenResumenActasRecaudacion", params);

				//redondeo de los campos
				concentradoActasRecaudacionRespuesta.setResumen(resumen);
				concentradoActasRecaudacionRespuesta.getHeader().setUID(uid);

			} catch (Exception ex)
			{
				concentradoActasRecaudacionRespuesta.getHeader().setMensaje(ex.getMessage());
				concentradoActasRecaudacionRespuesta.getHeader().setEstatus(false);
				concentradoActasRecaudacionRespuesta.getHeader().setUID(uid);
				LogHandler.error(uid, getClass(), "Error ocurrido en la operacion : "
				+ ex.getMessage(),ex);
			}
			finally {
				FabricaConexiones.close(session);
			}

		return concentradoActasRecaudacionRespuesta;
	}

	/*
	 * (non-Javadoc)
	 * @see tarea.consultas.Consultas#consultarReasignacionesMultiples(
	 * utilitario.mensajes.consultas.ReporteReasignacionesPeticion, java.lang.String)
	 */
	@SuppressWarnings("unchecked")

	public ConsultarReasignacionesMultiplesRespuesta
	consultarReasignacionesMultiples(ReporteReasignacionesPeticion peticion, String uid)
		{
		org.apache.ibatis.session.SqlSession sesionNTx			  = null;
		final ConsultarReasignacionesMultiplesRespuesta respuesta = new ConsultarReasignacionesMultiplesRespuesta();
		try	{
			//Seccion para la validaciones
			if ( peticion.getSucursal() == null && peticion.getZona() == null )
				{
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.datos.incompletos" ) );
				}

			//Se abre la conexion a la base
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			//Parametros para la consulta
			final java.util.HashMap<String, Object>
								parametrosConsulta = new HashMap<String, Object>();
								parametrosConsulta.put( "sucursal" , peticion.getSucursal() == null
										|| peticion.getSucursal().intValue() == 0 ? null : peticion.getSucursal() );
								parametrosConsulta.put( "zona" , peticion.getZona() == null
										|| peticion.getZona().intValue() == -1 ? null : peticion.getZona() );

			LogHandler.trace(uid, getClass(), "==> consultarReasignacionesMultiples - consultarReasignacionesMultiples" );
			final java.util.ArrayList<ReasignacionMultipleOV>
									reasignaciones = (ArrayList<ReasignacionMultipleOV>)
									sesionNTx.selectList( "consultarReasignacionesMultiples", parametrosConsulta );

			//Se valida que la consulta arroje algun resultado
			if ( reasignaciones == null || reasignaciones.isEmpty() )
				{
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.consultas.registrosvacios" ) );
				}

			//Se asigna el resultado de la consulta a la respuesta
			respuesta.setResultado( reasignaciones );
			}
		catch ( java.lang.Exception exception )
			{
			respuesta.getHeader().setMensaje( exception.getMessage() );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setUID( uid );
			LogHandler.error( uid, this.getClass(), "Ocurrio error al consultarReasignacionesMultiples: "
			+ exception.getMessage(), exception );
			}
		finally {
			FabricaConexiones.close(sesionNTx);
		}

		return respuesta;
		}

	/*
	 * (non-Javadoc)
	 * @see tarea.consultas.Consultas#consultarSolicitudesReasignacion
	 * (utilitario.mensajes.consultas.ReporteReasignacionesPeticion, java.lang.String)
	 */
	@SuppressWarnings("unchecked")

	public ConsultarSolicitudesRespuesta consultarSolicitudesReasignacion(ReporteReasignacionesPeticion peticion, String uid)
		{
		org.apache.ibatis.session.SqlSession sesionNTx			  = null;
		final ConsultarSolicitudesRespuesta respuesta = new ConsultarSolicitudesRespuesta();
		try	{
			//Seccion para la validaciones
			if ( peticion.getSucursal() == null && peticion.getZona() == null )
				{
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.datos.incompletos" ) );
				}

			//Se abre la conexion a la base
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			//Parametros para la consulta
			final java.util.HashMap<String, Object>
								parametrosConsulta = new HashMap<String, Object>();
								parametrosConsulta.put( "sucursal" , peticion.getSucursal() == null
										|| peticion.getSucursal().intValue() == 0 ? null : peticion.getSucursal() );
								parametrosConsulta.put( "zona" , peticion.getZona() == null
										|| peticion.getZona().intValue() == -1 ? null : peticion.getZona() );

			LogHandler.trace(uid, getClass(),
					"==> consultarSolicitudesReasignacion - consultarSolicitudesPendientesReasignacion" );
			final java.util.ArrayList<SolicitudReasignacionOV>
									solicitudesPendientes = (ArrayList<SolicitudReasignacionOV>)
									sesionNTx.selectList( "consultarSolicitudesPendientesReasignacion", parametrosConsulta );

			//Se valida que la consulta arroje algun resultado
			if ( solicitudesPendientes == null || solicitudesPendientes.isEmpty() )
				{
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.consultas.registrosvacios" ) );
				}

			//Se recupera la fecha actual
			final java.util.Calendar
					calendarioFechaActual = Calendar.getInstance();
					calendarioFechaActual.setTime( comun.obtenerFechaActual( uid ) );

			//Se calcula el tiempo de cada solicitud
			for ( SolicitudReasignacionOV solicitudReasignacionOV : solicitudesPendientes )
				{
				final java.util.Calendar
						calendarioFechaEnvio = Calendar.getInstance();
						calendarioFechaEnvio.setTime( solicitudReasignacionOV.getFechaEnvio() );

				final java.lang.Long
						minutosTotales = diferenciaMinutos(calendarioFechaEnvio , calendarioFechaActual);

				solicitudReasignacionOV.setTiempoTranscurrido( "" + ( minutosTotales / 60 ) + " : " + ( minutosTotales % 60 ) );
				}

			//Se asigna el resultado de la consulta a la respuesta
			respuesta.setResultado( solicitudesPendientes );
			}
		catch ( java.lang.Exception exception )
			{
			respuesta.getHeader().setMensaje( exception.getMessage() );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setUID( uid );
			LogHandler.error( uid, this.getClass(),
					"Ocurrio error al consultarSolicitudesReasignacion: " + exception.getMessage(), exception );
			}
		finally {
			FabricaConexiones.close(sesionNTx);

		}

		return respuesta;
		}

	/*
	 * (non-Javadoc)
	 * @see tarea.consultas.Consultas#consultaCreditosSinAsignar
	 * (utilitario.mensajes.consultas.ReporteReasignacionesPeticion, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public ConsultaCreditosSinAsignarRespuesta consultaCreditosSinAsignar(
			ReporteReasignacionesPeticion peticion, String uid) {
		ConsultaCreditosSinAsignarRespuesta consultaCreditosSinAsignarRespuesta =
					new ConsultaCreditosSinAsignarRespuesta();
		consultaCreditosSinAsignarRespuesta.setHeader(new EncabezadoRespuesta());
		SqlSession sesion = null;

		try
		{
			//Se obtiene la conexion a la base de datos
			sesion = FabricaConexiones.obtenerSesionNTx();
			if (peticion == null)
			{
				throw new Exception(ReadProperties.mensajes.getProp("ciof.error.datos.incompletos"));
			}

			//Parametros de la consulta
			java.util.HashMap<String , Object> params = new java.util.HashMap<String , Object>();
			params.put("sucursal", peticion.getSucursal() != null ? peticion.getSucursal() : 0);
			params.put("zona", peticion.getZona() != null ?  peticion.getZona() : -1);

			LogHandler.trace(uid, getClass(), "==> creditosSinAsignar - creditosSinAsignar ");
			List<CreditosSinAsignar> respuesta = (List<CreditosSinAsignar>)
					sesion.selectList("creditosSinAsignar", params);

			//Se acopla la informacion de acuerdo al reporte
			for (CreditosSinAsignar creditosSinAsignar : respuesta)
			{
				if (creditosSinAsignar.getFecha() == null)
				{
					creditosSinAsignar.setFecha(creditosSinAsignar.getFechaDisposicion());
				}

				//Se calculan los numeros de dias que ha estado el credito sin asignar
				final Calendar fechaAutorizacion = Calendar.getInstance();
				fechaAutorizacion.setTime(creditosSinAsignar.getFecha());
				creditosSinAsignar.setNumDias(diferenciaDias(fechaAutorizacion, Calendar.getInstance()));

				//Se anulan las fechas ya que el reporte no las solicita.
				creditosSinAsignar.setFechaDisposicion(null);
			}
			consultaCreditosSinAsignarRespuesta.setCreditos(respuesta);
		}
		catch (Exception ex)
		{
			consultaCreditosSinAsignarRespuesta.getHeader().setMensaje(ex.getMessage());
			consultaCreditosSinAsignarRespuesta.getHeader().setEstatus(false);
			consultaCreditosSinAsignarRespuesta.getHeader().setUID(uid);
			LogHandler.error(uid, getClass(), "Error ocurrido en la operacion : " + ex.getMessage(), ex);
		}
		finally {
			FabricaConexiones.close(sesion);

		}

		return consultaCreditosSinAsignarRespuesta;
	}

	/*
	 * (non-Javadoc)
	 * @see tarea.consultas.Consultas#consultaSaldosAFavorCreditosVigentes
	 * (utilitario.mensajes.consultas.ConsultaSaldosAFavorCreditosVigentesPeticion, java.lang.String)
	 */
	@SuppressWarnings("unchecked")

	public ConsultaSaldosAFavorCreditosVigentesRespuesta
	consultaSaldosAFavorCreditosVigentes(ConsultaSaldosAFavorCreditosVigentesPeticion peticion, String uid)
		{
		org.apache.ibatis.session.SqlSession sesionBatch		  	  = null;
		final ConsultaSaldosAFavorCreditosVigentesRespuesta respuesta = new ConsultaSaldosAFavorCreditosVigentesRespuesta();
		try	{
			//Seccion para la validaciones
			//por ahora no hay parametros de entrada

			if (peticion == null) {
				throw new Exception(ReadProperties.mensajes.getProp("ciof.error.datos.incompletos"));
			}

			//Se abre la conexion a la base
			sesionBatch = FabricaConexiones.obtenerSesionBatch();

			//Parametros de la consulta
			java.util.HashMap<String , Object> params = new java.util.HashMap<String , Object>();
			params.put("sucursal", peticion.getSucursal() != null ? peticion.getSucursal() : 0);

			LogHandler.trace(uid, getClass(), "==> consultaSaldosAFavorCreditosVigentes - consultarCreditosSaldoAFavor" );
			final java.util.ArrayList<SaldoAFavorCreditoVigenteVO>
									creditosSaldoAFavor = (ArrayList<SaldoAFavorCreditoVigenteVO>)
									sesionBatch.selectList( "consultarCreditosSaldoAFavor" , params );

			//Se valida que la consulta arroje algun resultado
			if ( creditosSaldoAFavor == null || creditosSaldoAFavor.isEmpty() )
				{
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.consultas.registrosvacios" ) );
				}

			java.util.ArrayList<SaldoAFavorCreditoVigenteVO> creditosSaldoAFavorValidos = creditosSaldoAFavor;

			/*
			//Lista de resultados validos
			java.util.ArrayList<SaldoAFavorCreditoVigenteVO> 
								creditosSaldoAFavorValidos = new ArrayList<SaldoAFavorCreditoVigenteVO>();

			for( SaldoAFavorCreditoVigenteVO saldoAFavorCreditoVigenteVO : creditosSaldoAFavor )
				{
				if( saldoAFavorCreditoVigenteVO.getContratoVigente() != null && !saldoAFavorCreditoVigenteVO.getContratoVigente().trim().equals( "" ) )
					{
					LogHandler.trace(uid, getClass(), "==> consultaSaldosAFavorCreditosVigentes - obtenDatosPagoSaldoAFavor" );
					final java.util.HashMap<String,Object>
											datosPagoSaldoAFavor = ( HashMap<String,Object> ) sesionBatch.selectOne( "obtenDatosPagoSaldoAFavor", saldoAFavorCreditoVigenteVO.getContrato() );

					//Si no encuentra movimientos se continua al siguiente registro
					if( datosPagoSaldoAFavor == null )
						{
						continue;
						}

					//Se asignan los valores de fecha y medio de pago
					saldoAFavorCreditoVigenteVO.setFechaAplicacion( (new SimpleDateFormat( "yyyy-MM-dd" ) ).parse( datosPagoSaldoAFavor.get( "fechaAplicacion" ).toString() ) );
					saldoAFavorCreditoVigenteVO.setMedioPago( datosPagoSaldoAFavor.get( "medioPago" ).toString() );

					//Vamos contra contratos vigentes
					LogHandler.trace(uid, getClass(), "==> consultaSaldosAFavorCreditosVigentes - obtenDatosContratoVigente" );
					final java.util.HashMap<String, Object>
									datosContratoVigente = ( HashMap<String, Object> )sesionBatch.selectOne( "obtenDatosContratoVigente", saldoAFavorCreditoVigenteVO.getContratoVigente() );

					if( datosContratoVigente.get( "contratoLD" ) == null )
						{ throw new Exception( ReadProperties.mensajes.getProp( "consultas.saldosafavorcreditosvigentes.errorcontratovigenteinvalido" + saldoAFavorCreditoVigenteVO.getContratoVigente() )); }

					saldoAFavorCreditoVigenteVO.setContratoVigente( datosContratoVigente.get( "contratoLD" ).toString() );
					saldoAFavorCreditoVigenteVO.setTipoCreditoVigente( datosContratoVigente.get( "tipoCredito" ).toString() );
					saldoAFavorCreditoVigenteVO.setNombreGrupoVigente( datosContratoVigente.get( "nombreGrupo" ).toString() );
					saldoAFavorCreditoVigenteVO.setSucursalVigente( datosContratoVigente.get( "sucursalNombre" ).toString() );
					saldoAFavorCreditoVigenteVO.setFechaProximoPagoVigente( datosContratoVigente.get( "proximoPago" ).toString() );
					saldoAFavorCreditoVigenteVO.setParcialidadVigente( Double.valueOf( datosContratoVigente.get( "parcialidad" ).toString() ) );

					creditosSaldoAFavorValidos.add( saldoAFavorCreditoVigenteVO );
					}
				}
			*/

			//Se asignan los resultados
			respuesta.setCreditos( creditosSaldoAFavorValidos );
			}
		catch ( java.lang.Exception exception )
			{
			respuesta.getHeader().setMensaje( exception.getMessage() );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setUID( uid );
			LogHandler.error( uid, this.getClass(),
					"Ocurrio error al consultarSolicitudesReasignacion: " + exception.getMessage(), exception );
			}
		finally
			{
			FabricaConexiones.close( sesionBatch );
			}

		return respuesta;
		}

	//Funcion para restar fechas
	private java.lang.Integer diferenciaDias(final java.util.Calendar startDate, final java.util.Calendar endDate)
	{
		final java.lang.Integer MILLIS_IN_DAY = 1000 * 60 * 60 * 24;
		final java.lang.Long 	endInstant    = endDate.getTimeInMillis();
		java.lang.Integer presumedDays  = ( int )( ( endInstant - startDate.getTimeInMillis() ) / MILLIS_IN_DAY );
		final java.util.Calendar
				cursor = (Calendar) startDate.clone();
				cursor.add(Calendar.DAY_OF_YEAR, presumedDays);

		final java.lang.Long beginInstant = cursor.getTimeInMillis();

		presumedDays += beginInstant < endInstant ? 1 : beginInstant > endInstant ? -1 : 0;

		return presumedDays;
	}

	//Funcion para restar fechas y obtener su diferencia en minutos
	private java.lang.Long diferenciaMinutos(final java.util.Calendar startDate, final java.util.Calendar endDate)
		{
		final java.lang.Integer MILLIS_IN_HOUR = 1000 * 60;
		final java.lang.Long 	endInstant     = endDate.getTimeInMillis();
		java.lang.Long presumedMinutes      = ( long )( ( endInstant - startDate.getTimeInMillis() ) / MILLIS_IN_HOUR );
		final java.util.Calendar
				cursor = (Calendar) startDate.clone();
				cursor.add(Calendar.MINUTE, presumedMinutes.intValue() );

		final java.lang.Long beginInstant = cursor.getTimeInMillis();

		presumedMinutes += beginInstant < endInstant ? 1 : beginInstant > endInstant ? -1 : 0;

		return presumedMinutes;
		}


	@SuppressWarnings("unchecked")

	public ConsultaSaldosAFavorAjustadosRespuesta
	consultaSaldosAFavorAjustados(ConsultaSaldosAFavorAjustadosPeticion peticion, String uid) {
		org.apache.ibatis.session.SqlSession sesionBatch		  	  = null;
		final ConsultaSaldosAFavorAjustadosRespuesta respuesta = new ConsultaSaldosAFavorAjustadosRespuesta();
		try	{
			//Seccion para la validaciones
			//por ahora no hay parametros de entrada

			if (peticion == null) {
				throw new Exception(ReadProperties.mensajes.getProp("ciof.error.datos.incompletos"));
			}

			//Se abre la conexion a la base
			sesionBatch = FabricaConexiones.obtenerSesionNTx();

			if (peticion.getSucursal() == null || peticion.getSucursal() == 0 || peticion.getSucursal() == 120)
			{
			peticion.setSucursal( 0 );
			}

			//Parametros de la consulta
			java.util.HashMap<String , Object> params = new java.util.HashMap<String , Object>();
			params.put("sucursal", peticion.getSucursal() != null ? peticion.getSucursal() : 0);
			params.put("fechaInicio", peticion.getFechaInicio());
			params.put("fechaFin", peticion.getFechaFin());


			LogHandler.trace(uid, getClass(), "==> consultaSaldosAFavorAjustados - consultaSaldosAFavorAjustados" );
			final java.util.ArrayList<SaldoAFavorCreditoVigenteVO>
									creditosSaldoAFavor = (ArrayList<SaldoAFavorCreditoVigenteVO>)
									sesionBatch.selectList( "consultarCreditosSaldoAFavorAjustados" , params );

			//Se valida que la consulta arroje algun resultado
			if ( creditosSaldoAFavor == null || creditosSaldoAFavor.isEmpty() ) {
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.consultas.registrosvacios" ) );
				}

			java.util.ArrayList<SaldoAFavorCreditoVigenteVO> creditosSaldoAFavorValidos = creditosSaldoAFavor;

			//Se asignan los resultados
			respuesta.setCreditos( creditosSaldoAFavorValidos );
			}
		catch ( java.lang.Exception exception ) {
			respuesta.getHeader().setMensaje( exception.getMessage() );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setUID( uid );
			LogHandler.error( uid, this.getClass(),
					"Ocurrio error al consultarSolicitudesReasignacion: " + exception.getMessage(), exception );
			}
		finally
			{
			FabricaConexiones.close( sesionBatch );
			}

		return respuesta;
		}


	/**
	 * @param uid identificador unico
	 * @param peticion contrato
	 * @return ConsultaReferenciasPagoRespuesta
	 */
	public ConsultaReferenciasPagoRespuesta consultaReferenciasPago(ConsultaReferenciasPagoPeticion peticion, String uid) {
		ConsultaReferenciasPagoRespuesta respuesta = new ConsultaReferenciasPagoRespuesta();
		ReferenciasRespuestaPaybin respuestaReferencia = new ReferenciasRespuestaPaybin();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);
		org.apache.ibatis.session.SqlSession sesionBatch = null;
		List<ReferenciasBancariasOV> listaReferencias = null;
		try	{

			//Se abre la conexion a la base
			sesionBatch = FabricaConexiones.obtenerSesionNTx();
			String referenciaPayBin = "";
			String contratoPayBin = "";
			ReferenciasPeticion referenciaPeti = new ReferenciasPeticion();

			if (peticion == null) {
				throw new Exception(ReadProperties.mensajes.getProp("ciof.error.datos.incompletos"));
			}

			if (peticion.getListaContratos() != null && peticion.getListaContratos().size() > 0) {

				listaReferencias = new ArrayList<ReferenciasBancariasOV>();

				for (Iterator<ConsultaReferenciaBancariasOV> iterator =
						peticion.getListaContratos().iterator(); iterator.hasNext();) {

					ConsultaReferenciaBancariasOV referencia = (ConsultaReferenciaBancariasOV) iterator.next();

					String datoContrato = (String) sesionBatch.selectOne("obtenerRelacionContrato",
							referencia.getNoContrato());

					if ( datoContrato == null || datoContrato.trim().equals(""))
					{
						LogHandler.info(uid, getClass(), "==> No existe contrato");
					} else {

					final String cadenaBancomer = Funciones.obtenerCadenaBancomer(referencia.getNoContrato()) + "";
					String cadenaBanamex =  "";
					String cadenaHSBC 	 =  "";
					if (referencia.getNoContrato().trim().substring(7, 8).equals("2")) {
						cadenaBanamex = Funciones.obtenerCadenaBanamexDepositoGarantia(referencia.getNoContrato()) + "";
						//Conevenio HSBC para garantias 7582
						cadenaHSBC = "7582"	+ referencia.getNoContrato().substring(2) + "002012319999999";
					}
					else {
						cadenaBanamex = Funciones.obtenerCadenaBanamex(referencia.getNoContrato()) + "";
						cadenaHSBC = "8003"	+ referencia.getNoContrato().substring(2) + "002012319999999";
					}
					//Se agregan los ceros a la izquierda del numero de contrato HSA
//OXXO					LogHandler.trace(uid, getClass(), "Entrada-getNumContrato " + peticion.getNumContrato());
//OXXO					for (int i = peticion.getNumContrato().length(); i < 10; i++) {
//OXXO						peticion.setNumContrato("0" + peticion.getNumContrato());
//OXXO					}
//OXXO					LogHandler.trace(uid, getClass(), "Salida-getNumContrato " + peticion.getNumContrato());

//OXXO					String cadenaOXXO = "24"	+ peticion.getNumContrato() + "311215" + "00999999" + "000";
					String cadenaOXXO = "24"	+ referencia.getNoContrato().substring(2) + "311215" + "00999999" + "000";

					contratoPayBin = peticion.getNumContrato();
					//Se agregan los ceros a la izquierda del numero de contrato AOC
					LogHandler.trace(uid, getClass(), "Entrada-getNumContrato " + peticion.getNumContrato());
					for (int i = peticion.getNumContrato().length(); i < 12; i++) {
						peticion.setNumContrato("0" + peticion.getNumContrato());
					}

					String cadenaDiestel = ConstantesPagos.EMPRESA.getValue() + ConstantesPagos.PRODUCTO.getValue()
						+ "0000" + peticion.getNumContrato();

					LogHandler.debug(uid, this.getClass(), cadenaHSBC);

					//Parametros de la consulta
					java.util.HashMap<String, Object> params = new java.util.HashMap<String, Object>();
					params.put("referencia", cadenaHSBC);

					LogHandler.trace(uid, getClass(), "==> consultaReferenciasPago - algoritmo21" );
					final String digitoVerificador = (String) sesionBatch.selectOne( "algoritmo21", params );

					params.clear();
					params.put("referencia", cadenaOXXO);
					LogHandler.trace(uid, getClass(), "==> consultaReferenciasPago - algoritmo21" );
					final String digitoVerificadorPL = (String) sesionBatch.selectOne( "algoritmo21", params );

					params.clear();
					params.put("referencia", cadenaDiestel);
					LogHandler.trace(uid, getClass(), "==> consultaReferenciasPago - algoritmo21" );
					final String digitoVerificadorDIESTEL = (String) sesionBatch.selectOne( "algoritmo21", params );

					cadenaHSBC += digitoVerificador;
					cadenaOXXO += digitoVerificadorPL;
					cadenaDiestel += digitoVerificadorDIESTEL;

					ReferenciasBancariasOV referenciaOV = new ReferenciasBancariasOV();
					referenciaOV.setContrato(referencia.getNoContrato());
					// buscar grupo
					//referenciaOV.setGrupo(grupo);
					referenciaOV.setReferenciaBanamex(cadenaBanamex);
					referenciaOV.setReferenciaBancomer(cadenaBancomer);
					referenciaOV.setReferenciaFISA(cadenaBanamex);
					referenciaOV.setReferenciaHSBC(cadenaHSBC);
					referenciaOV.setReferenciaOXXO(cadenaOXXO);
					referenciaOV.setReferenciaDIESTEL(cadenaDiestel);

					referenciaPeti.setContrato(contratoPayBin);
					referenciaPeti.setReferencia(cadenaDiestel);
					referenciaPeti.setCliente("28");
					referenciaPeti.setProducto(peticion.getProducto());
					referenciaPeti.setMonto(peticion.getMontoPago());
					respuestaReferencia =  obtenerCadenaPaybin(uid, referenciaPeti);

					if (!respuestaReferencia.getHeader().isEstatus()) {
						if (respuestaReferencia.getReferencia().contains("~")) {
							String[] error = referenciaPayBin.split("~");
							throw new Exception(error[1]);
						}
					}

					referenciaOV.setReferenciaPayBin(referenciaPayBin);
					listaReferencias.add(referenciaOV);

				}
			}

				respuesta.setListaReferencias(listaReferencias);

			} else {

			if (peticion.getContrato() == null || peticion.getContrato().trim().equals(""))	{
				throw new Exception(ReadProperties.mensajes.getProp("ciof.error.datos.incompletos"));
			}
			if ( !peticion.getContrato().contains("LD") ) {
				//Cambio a LD
				peticion.setContrato(comun.obtenerNumeroContratoLD(uid, peticion.getContrato()));
			} else if (peticion.getContrato().contains("LD")) {
				peticion.setNumContrato(comun.obtenerNumeroContrato(uid, peticion.getContrato()));
			} else {
				peticion.setNumContrato(peticion.getContrato());
			}

			final String cadenaBancomer = Funciones.obtenerCadenaBancomer(peticion.getContrato()) + "";
			String cadenaBanamex =  "";
			String cadenaHSBC 	 =  "";

			if (peticion.getContrato().trim().substring(7, 8).equals("2")) {
				cadenaBanamex = Funciones.obtenerCadenaBanamexDepositoGarantia(peticion.getContrato()) + "";
				//Conevenio HSBC para garantias 7582
				cadenaHSBC = "7582"	+ peticion.getContrato().substring(2) + "002012319999999";
			}
			else {
				cadenaBanamex = Funciones.obtenerCadenaBanamex(peticion.getContrato()) + "";
				cadenaHSBC = "8003"	+ peticion.getContrato().substring(2) + "002012319999999";
			}

//OXXO			for (int i = peticion.getNumContrato().length(); i < 10; i++) {
//OXXO				peticion.setNumContrato("0" + peticion.getNumContrato());
//OXXO			}
//OXXO			LogHandler.trace(uid, getClass(), "Salida-getNumContrato " + peticion.getNumContrato());
//OXXO			String cadenaOXXO = "24"	+ peticion.getNumContrato() + "311215" + "00999999" + "000";
			String cadenaOXXO = "24"	+ peticion.getContrato().substring(2) + "311215" + "00999999" + "000";

			contratoPayBin = peticion.getNumContrato();
			//Se agregan los ceros a la izquierda del numero de contrato AOC
			LogHandler.trace(uid, getClass(), "Entrada-getNumContrato " + peticion.getNumContrato());
			for (int i = peticion.getNumContrato().length(); i < 12; i++) {
				peticion.setNumContrato("0" + peticion.getNumContrato());
			}

			String cadenaDiestel = ConstantesPagos.EMPRESA.getValue() + ConstantesPagos.PRODUCTO.getValue()
				+ "0000" + peticion.getNumContrato();

			LogHandler.debug(uid, this.getClass(), cadenaHSBC);

			//Parametros de la consulta
			java.util.HashMap<String, Object> params = new java.util.HashMap<String, Object>();
			params.put("referencia", cadenaHSBC);

			LogHandler.trace(uid, getClass(), "==> consultaReferenciasPago - algoritmo21" );
			final String digitoVerificador = (String) sesionBatch.selectOne( "algoritmo21", params );

			params.clear();
			params.put("referencia", cadenaOXXO);
			LogHandler.trace(uid, getClass(), "==> consultaReferenciasPago - algoritmo21" );
			final String digitoVerificadorOXXO = (String) sesionBatch.selectOne( "algoritmo21", params );

			params.clear();
			params.put("referencia", cadenaDiestel);
			LogHandler.trace(uid, getClass(), "==> consultaReferenciasPago - algoritmo21" );
			final String digitoVerificadorDIESTEL = (String) sesionBatch.selectOne( "algoritmo21", params );

			cadenaHSBC += digitoVerificador;
			cadenaOXXO += digitoVerificadorOXXO;
			cadenaDiestel += digitoVerificadorDIESTEL;

			referenciaPeti.setContrato(contratoPayBin);
			referenciaPeti.setReferencia(cadenaDiestel);
			referenciaPeti.setProducto(peticion.getProducto());
			referenciaPeti.setMonto(peticion.getMontoPago());
			respuestaReferencia =  obtenerCadenaPaybin(uid, referenciaPeti);

			if (!respuestaReferencia.getHeader().isEstatus()) {
				if (respuestaReferencia.getReferencia() != null) {
					if (respuestaReferencia.getReferencia().contains("~")) {
						String[] error = referenciaPayBin.split("~");
						throw new Exception(error[1]);
					}
				} else {
					throw new Exception(respuestaReferencia.getHeader().getMensaje());
				}
			} else {
				referenciaPayBin = respuestaReferencia.getReferencia();
			}


			respuesta.setReferenciaBanamex(cadenaBanamex);
			respuesta.setReferenciaBancomer(cadenaBancomer);
			respuesta.setReferenciaFISA(cadenaBanamex);
			respuesta.setReferenciaHSBC(cadenaHSBC);
			respuesta.setReferenciaOXXO(cadenaOXXO);
			respuesta.setreferenciaDIESTEL(cadenaDiestel);
			respuesta.setReferenciaPayBin(referenciaPayBin);
			}

		}
		catch ( java.lang.Exception exception ) {
			respuesta.getHeader().setMensaje( exception.getMessage() );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setUID( uid );
			respuesta.getHeader().setMensaje(exception.getMessage());
			LogHandler.error( uid, this.getClass(), "Ocurrio error al consultaReferenciasPago: "
					+ exception.getMessage(), exception );
		}
		finally {
			FabricaConexiones.close(sesionBatch);
		}

		return respuesta;
	}


	/**
	 * Obtener cadena PayBin.
	 *
	 * @param uid the Identificador unico
	 * @param peticion The ReferenciasPeticion
	 * @return ReferenciasRespuestaPaybin the string
	 */
	public ReferenciasRespuestaPaybin obtenerCadenaPaybin(String uid, ReferenciasPeticion peticion) {
		ReferenciasRespuestaPaybin respuesta = new ReferenciasRespuestaPaybin();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);

		SqlSession sesionTx = null;
		SqlSession sesionNTx = null;
		int insertaReferenciaPaybin = 0;
		int insertaReferenciaDiestel = 0;
		String errorXML = "";
		String respuestaXML = "";
		try {

			LogHandler.info(uid, getClass(), " - obtenerCadenaPaybin - Entró");

			//Se agrega bandera para el web service de Paybin
			ParGeneralOV banderaPayBin = comun.obtenerParGeneralOV(uid, "BANDERA_PAYBIN");
			if (banderaPayBin == null || banderaPayBin.getCgValor().trim().isEmpty()) {
				throw new Exception("No se pudo recuperar la jdni BANDERA_PAYBIN.");
			}

			LogHandler.info(uid, getClass(), " - banderaPayBin - " + banderaPayBin.getCgValor());
			if (banderaPayBin.getCgValor().equals("true")) {

				//Se abre la conexion hacia la base de datos
				sesionNTx = FabricaConexiones.obtenerSesionNTx();
				sesionTx  = FabricaConexiones.obtenerSesionTx();

				ParGeneralOV servidor = comun.obtenerParGeneralOV(uid, "SERVIDOR_PAYBIN");

				if (servidor == null || servidor.getCgValor().trim().isEmpty()) {
					throw new Exception("No se pudo recuperar la jdni SERVIDOR_PAYBIN.");
				}

				ParGeneralOV puerto = comun.obtenerParGeneralOV(uid, "PUERTO_PAYBIN");

				if (puerto == null || puerto.getCgValor().trim().isEmpty()) {
					throw new Exception("No se pudo recuperar la jdni PUERTO_PAYBIN.");
				}

				ParGeneralOV urlPayBin = comun.obtenerParGeneralOV(uid, "URL_PAYBIN");

				if (urlPayBin == null || urlPayBin.getCgValor().trim().isEmpty()) {
					throw new Exception("No se pudo recuperar la jdni URL_PAYBIN.");
				}

				ParGeneralOV usuarioPayBin = comun.obtenerParGeneralOV(uid, "USUARIO_PAYBIN");

				if (usuarioPayBin == null || usuarioPayBin.getCgValor().trim().isEmpty()) {
					throw new Exception("No se pudo recuperar la jdni USUARIO_PAYBIN.");
				}

				ParGeneralOV passwordPayBin = comun.obtenerParGeneralOV(uid, "PASSWORD_PAYBIN");

				if (passwordPayBin == null || passwordPayBin.getCgValor().trim().isEmpty()) {
					throw new Exception("No se pudo recuperar la jdni PASSWORD_PAYBIN.");
				}

				ParGeneralOV banderaProxyPayBin = comun.obtenerParGeneralOV(uid, "BANDERA_PROXY_PAYBIN");

				if (banderaProxyPayBin == null || banderaProxyPayBin.getCgValor().trim().isEmpty()) {
					throw new Exception("No se pudo recuperar la jdni BANDERA_PROXY_PAYBIN.");
				}

				ParGeneralOV productoPayBin = comun.obtenerParGeneralOV(uid, "PRODUCTO_PAYBIN");

				if (productoPayBin == null || productoPayBin.getCgValor().trim().isEmpty()) {
					throw new Exception("No se pudo recuperar la jdni PRODUCTO_PAYBIN.");
				}

				final java.util.HashMap<String, Object> param = new HashMap<String, Object>();
				param.put( "referencia", peticion.getReferencia());

				if (peticion.getContrato() != null) {
					param.put("contrato", peticion.getContrato());
				}

				if (peticion.getPersona() != null) {
					param.put("persona", peticion.getPersona());
				}

				List<Referencias> listaReferencias = (List<Referencias>) sesionNTx.selectList("obtenerReferencias", param);

				if (listaReferencias.size() == 0) {

					String xml = "<?xml version=\"1.0\" encoding=\"utf-16\" ?>"
						+ " <soapenv:Envelope xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\""
						+ " xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""
						+ " xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\">"
						+ " <soapenv:Header />"
						+ " <soapenv:Body>"
						+ " <Alta xmlns=\"http://tempuri.org\">"
						+ 	" <ProductId xmlns=\"\">" + productoPayBin.getCgValor() + "</ProductId>"
						+ 	" <Reference xmlns=\"\">" + peticion.getReferencia() + "</Reference>"
						+ 	" <Reference2 xmlns=\"\" ></Reference2>"
						+ 	" <DV xmlns=\"\" ></DV>"
						+ 	" <Amount xmlns=\"\">" + peticion.getMonto() + "</Amount>"
				        + 	" <ExpirationDate xmlns=\"\" ></ExpirationDate>"
						+ 	" <ReferenceType xmlns=\"\">1</ReferenceType>"
						+ 	" <User xmlns=\"\">" + usuarioPayBin.getCgValor() + "</User>"
				        + 	" <Password xmlns=\"\">" + passwordPayBin.getCgValor() + "</Password>"
						+ 	" <Action xmlns=\"\">1</Action>"
						+ " </Alta>"
				        + " </soapenv:Body>"
				        + " </soapenv:Envelope>";

			        LogHandler.info(uid, getClass(), " - Peticion ===> " + xml);

			        if (banderaProxyPayBin.getCgValor().equals("true")) {
			        	LogHandler.info(uid, getClass(), " - entró a banderaProxyPayBin");
				        System.setProperty("http.proxyHost", servidor.getCgValor());
				        System.setProperty("http.proxyPort", puerto.getCgValor());
				        System.setProperty("https.proxyHost", servidor.getCgValor());
				        System.setProperty("https.proxyPort", puerto.getCgValor());
			        }

			        URL url = new URL(urlPayBin.getCgValor());
			        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			        conn.setRequestMethod("POST");
			        conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			        conn.setRequestProperty("Accept", "text/xml");
			        conn.setDoOutput(true);
			        conn.connect();

			        OutputStream out = conn.getOutputStream();
			        out.write(xml.getBytes()); // here i sent the parameter
			        out.flush();
			        out.close();

			        int httpResult = conn.getResponseCode();
			        LogHandler.info(uid, getClass(), "httpResult " + httpResult);
			        StringBuilder sb = new StringBuilder();

			        if (httpResult == HttpURLConnection.HTTP_OK) {
			            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
			            String line = null;

			            while ((line = br.readLine()) != null) {
			                sb.append(line + "\n");
			            }

			            br.close();
			            respuestaXML = sb.toString().replace(":", "");
			            LogHandler.info(uid, getClass(), " - obtenerCadenaPaybin - RESPUESTA ===> " + respuestaXML);

			            errorXML = obtenerValorTag(respuestaXML, "<CodigoRespuesta>", "</CodigoRespuesta>");
			            LogHandler.info(uid, getClass(), " - errorXML ===> " + errorXML);
			            if (errorXML.equals("0")) {
			            	String referenciaPaybin = obtenerValorTag(respuestaXML, "<PayBinRef>", "</PayBinRef>");
			            	String referenciaDiestel = obtenerValorTag(respuestaXML, "<Reference>", "</Reference>");

			            	final java.util.HashMap<String, Object> paramPaybin = new HashMap<String, Object>();
			            	paramPaybin.put("contrato", peticion.getContrato() != null
									? peticion.getContrato() : "");
			            	paramPaybin.put("persona",  peticion.getPersona() != null
				            		 ? peticion.getPersona() : "");
			            	paramPaybin.put("referencia", referenciaPaybin);
			            	paramPaybin.put("tipo_producto", peticion.getProducto());
			            	paramPaybin.put("clave_cte", Integer.parseInt("28"));

				            insertaReferenciaPaybin = sesionTx.insert("insertaReferencia", paramPaybin);

							LogHandler.info(uid, this.getClass(), "INSERTAR PAYBIN filas afectadas"
									+  "[ " + insertaReferenciaPaybin + " ]");
							if (insertaReferenciaPaybin == 0) {
								throw new Exception("No se obtuvieron resultados para la inserción de referencias Paybin");
							}

							final java.util.HashMap<String, Object> paramDiestel = new HashMap<String, Object>();
							paramDiestel.put("contrato", peticion.getContrato() != null
									? peticion.getContrato() : "");
							paramDiestel.put("persona",  peticion.getPersona() != null
				            		 ? peticion.getPersona() : "");
							paramDiestel.put("referencia", referenciaDiestel);
							paramDiestel.put("tipo_producto", peticion.getProducto());
							paramDiestel.put("clave_cte", Integer.parseInt("26"));

				            insertaReferenciaDiestel = sesionTx.insert("insertaReferencia", paramDiestel);

							LogHandler.info(uid, this.getClass(), "INSERTAR DIESTEL filas afectadas"
									+  "[ " + insertaReferenciaDiestel + " ]");
							if (insertaReferenciaDiestel == 0) {
								throw new Exception("No se obtuvieron resultados para la inserción de referencia Diestel");
							}
							respuesta.setReferencia(referenciaPaybin);
							sesionTx.commit(true);
			            } else {			            	String descripcionXML
			            		= obtenerValorTag(respuestaXML, "<DescripcionRespuesta>", "</DescripcionRespuesta>");
			            	LogHandler.info(uid, getClass(), " -descripcionXMLL ===> " + descripcionXML);
			            	throw new Exception(errorXML + "~" + descripcionXML);
			            }
			        } else {
			        	LogHandler.info(uid, getClass(), " - obtenerCadenaPaybin - else ===> " + conn.getResponseMessage());
			        	throw new Exception(conn.getResponseMessage());
			        }
				} else {

					if (listaReferencias.size() > 0) {

						final java.util.HashMap<String, Object> paramPayBin = new HashMap<String, Object>();
						if (peticion.getContrato() != null) {
							paramPayBin.put("contrato", peticion.getContrato());
						}

						if (peticion.getPersona() != null) {
							paramPayBin.put("persona", peticion.getPersona());
						}

						List<Referencias> listaReferenciasPaybin
							= (List<Referencias>) sesionNTx.selectList("obtenerReferenciasPaybin", paramPayBin);

						if (listaReferenciasPaybin.size() > 0 ) {
							for ( int i = 0; i < listaReferencias.size(); i++) {
								respuesta.setReferencia(listaReferenciasPaybin.get(i).getReferencia());
							}
						}
					}
				}
			} else {
				respuesta.setReferencia(null);
			}

		} catch (Exception ex) {
			FabricaConexiones.rollBack(sesionTx);
			respuesta.getHeader().setMensaje( ex.getMessage() );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setUID( uid );
			LogHandler.error(uid, getClass(), "obtenerCadenaPaybin - ERROR >>> " + ex.getMessage(), ex);
		}
		finally {
			FabricaConexiones.close(sesionNTx);
			FabricaConexiones.close(sesionTx);
		}
		return respuesta;
	}
	/**
	 * obtiene el valor del tag
	 *
	 * @param peticion
	 *            recibe como parametro un varargs donde la posicion 0 =
	 *            peticion posicion 1 = tagInicial posicion 2 = tagFinal
	 * @return string el valor del tag
	 */
	public String obtenerValorTag(String... peticion) {
		String valor = peticion[0];
		if (valor.contains(peticion[1])) {
			valor = valor
					.substring(valor.indexOf(peticion[1]),
							valor.indexOf(peticion[2]))
					.replace(peticion[1], "");
		} else {
			valor = "";
		}
		return valor;
	}

	/**
	 * @param uid :
	 * @param peticion :
	 * @return consultaAsentamientos :
	 */
	@SuppressWarnings("unchecked")
	public ConsultaAsentamientoRespuesta consultaAsentamientos( String uid, AsentamientoOV peticion) {
		ConsultaAsentamientoRespuesta respuesta = new ConsultaAsentamientoRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);
		SqlSession sesion = null;

		try {

			if (peticion == null || peticion.getCp() == null ||  peticion.getCp().trim().equals("") ) {
				throw new Exception(ReadProperties.mensajes.getProp("asentamientos.error.peticion.cp"));
			}
			//Se abre la conexion a la base
			sesion = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(), "==> consultaAsentamientos - consultaAsentamientos" );
			java.util.HashMap<String , Object> parametros = new java.util.HashMap<String , Object>();
			parametros.put("cp", peticion.getCp().trim());

			final java.util.ArrayList<AsentamientoOV> asentamientos =
					(ArrayList<AsentamientoOV>) sesion.selectList("consultaAsentamientos", parametros);
			respuesta.setAsentamientos(asentamientos);
		}
		catch ( java.lang.Exception exception ) {
			respuesta.getHeader().setMensaje( exception.getMessage() );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setUID( uid );
			respuesta.getHeader().setMensaje(exception.getMessage());
			LogHandler.error( uid, this.getClass(),
				"Ocurrio error al consultaEstadosAsentamientos: " + exception.getMessage(), exception );
		}
		finally {
			FabricaConexiones.close(sesion);

		}
		return respuesta;
	}



	//AGENDAS

		@SuppressWarnings({ "unchecked" })

		public AsignacionSucursalRespuesta asignacionConsolidadoSucursal(String uid, AsignacionOV peticion) {
			AsignacionSucursalRespuesta respuesta = new AsignacionSucursalRespuesta();
			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setEstatus(true);
			respuesta.getHeader().setUID(uid);
			SqlSession sesion = null;

			try {
				if ( peticion == null || peticion.getNumeroSucursal() == null) {
					throw new Exception(ReadProperties.mensajes.getProp(SUCURSAL_INVALIDA));
				}

				final java.text.SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
				//Se abre la conexion a la base
				sesion = FabricaConexiones.obtenerSesionNTx();

				String fechaCont = simpleDateFormat.format( comun.obtenerFechaContable( uid ).getFecha() );

				List<AsignacionOV> asignacionesHorario = new ArrayList<AsignacionOV>();
				List<AsignacionOV> asignacionesFueraHorario = new ArrayList<AsignacionOV>();
				List<AsignacionOV> asignaciones = new ArrayList<AsignacionOV>();
				List<AsignacionOV> asignacionesSolicitudes = new ArrayList<AsignacionOV>();

				final java.util.HashMap<String, Object> parametrosAsignaciones = new HashMap<String, Object>();
				parametrosAsignaciones.put( "numeroSucursal",  peticion.getNumeroSucursal() );
				parametrosAsignaciones.put( "fechaContable",	fechaCont);

				LogHandler.info(uid, getClass(), "==> asignacionConsolidadoSucursal - obtenerAsignacionSucursales");
				LogHandler.trace(uid, getClass(), "==> asignacionConsolidadoSucursal - obtenerAsignacionSucursales");
				asignaciones = sesion.selectList("obtenerAsignacionSucursales", parametrosAsignaciones);

				//String sucursal = peticion.getNumeroSucursal().toString().replaceFirst("12", "");
				final java.util.HashMap<String, Object> parametrosSolicitudes = new HashMap<String, Object>();
				//parametrosSolicitudes.put( "numeroSucursal"	,  Integer.parseInt(sucursal));
				parametrosSolicitudes.put( "numeroSucursal",  peticion.getNumeroSucursal());
				parametrosSolicitudes.put( "fechaContable",  fechaCont);

				LogHandler.info(uid, getClass(), "parametros: " + peticion.getNumeroSucursal() + "," + fechaCont);
				LogHandler.info(uid, getClass(), "asignacionConsolidadoSucursal - obtenerAsignacionSolicitudes");
				LogHandler.trace(uid, getClass(), "asignacionConsolidadoSucursal - obtenerAsignacionSolicitudes");

				asignacionesSolicitudes = sesion.selectList("obtenerAsignacionSolicitudes", parametrosSolicitudes);


				for (int i = 0; i < asignacionesSolicitudes.size(); i++) {
					isThere = false;
					for (int j = 0; j < asignaciones.size(); j++) {
							//LogHandler.info(uid, getClass(), "DIA REUNION: "
							//+ asignacionesSolicitudes.get(i).getDiaReunion() + "," + asignaciones.get(j).getDiaReunion());
							//LogHandler.info(uid, getClass(), "HORA REUNION: " + asignacionesSolicitudes.get(i).getHoraReunion()
							//+ "," + asignaciones.get(j).getHoraReunion());
							if (asignacionesSolicitudes.get(i).getDiaReunion().equals(asignaciones.get(j).getDiaReunion())
							&& (asignacionesSolicitudes.get(i).getHoraReunion().equals(asignaciones.get(j).getHoraReunion()))) {
											LogHandler.info(uid, getClass(), "entro a if");
											asignaciones.get(j).setNumContratos(asignaciones.get(j).getNumContratos() +
													asignacionesSolicitudes.get(i).getNumContratos()
													);
											isThere = true;
										}
									}
							//LogHandler.info(uid, getClass(), "isThere:" + isThere);
							if (!isThere) {
									LogHandler.info(uid, getClass(), "entro a agregar");
									AsignacionOV miasignacion = new AsignacionOV();
									miasignacion.setDiaReunion(asignacionesSolicitudes.get(i).getDiaReunion());
									miasignacion.setHoraReunion(asignacionesSolicitudes.get(i).getHoraReunion());
									miasignacion.setNumContratos(asignacionesSolicitudes.get(i).getNumContratos());
									asignaciones.add(miasignacion);
							}

				}


			      final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			      parametros.put( "tipoCodigo"		 , "HDAF" );
				  parametros.put( "status"		 	 , "A");
				  LogHandler.trace(uid, getClass(),
						  "==> asignacionConsolidadoSucursal - consultaCatalogosVerificacionTelefonica" );

				  final java.util.ArrayList<HashMap<String, Object>>
				  horariosDisponibles	= (java.util.ArrayList<HashMap<String, Object>>)
				  sesion.selectList( "consultaCatalogosVerificacionTelefonica", parametros );

				  if (horariosDisponibles.size() == 0) {
						throw new Exception("No fue posible cargar el cadalogo de los horarios de las agendas.");
				  }

				  Map<String, String> mapCodigos	= new HashMap<String, String>();
				  for ( HashMap<String, Object> codigo : horariosDisponibles ) {
					  mapCodigos.put( codigo.get( "DESCRIPCION").toString().trim()
							  , codigo.get( "CODIGO").toString().trim() );
				  }


				  for (AsignacionOV asignacion : asignaciones) {
					  //LogHandler.debug(uid, getClass(), "***" + asignacion.getHoraReunion() + "***");
					if (mapCodigos.get(asignacion.getHoraReunion().trim())
							!= null && asignacion.getDiaReunion() > 0 ) {
						  asignacionesHorario.add(asignacion);
					} else {
						  asignacionesFueraHorario.add(asignacion);
					}
				  }

				respuesta.setAsignaciones(asignacionesHorario);
				respuesta.setAsignacionesFueraHorario(asignacionesFueraHorario);
				respuesta.setAsignacionesSolicitud(asignacionesSolicitudes);

			} catch (java.lang.Exception exception)	{
				respuesta.getHeader().setEstatus( false );
				respuesta.getHeader().setUID(uid);
				respuesta.getHeader().setMensaje(exception.getMessage());
				LogHandler.error( uid, this.getClass(), "Ocurrio error al consultar  : "
					+ exception.getMessage(), exception );
			}
			finally {
				FabricaConexiones.close(sesion);

			}
			return respuesta;
		}




		@SuppressWarnings("unchecked")
		public AsignacionDetalleRespuesta asignacionDetalleSucursalTarea(String uid, AsignacionDetalleOV peticion) {

			AsignacionDetalleRespuesta respuesta = new AsignacionDetalleRespuesta();
			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setEstatus(true);
			respuesta.getHeader().setUID(uid);
			SqlSession sesion = null;
//			SqlSession sesionNTx = null;

			final java.text.SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
			try {
				if ( peticion == null || peticion.getNumeroSucursal() == null
						|| peticion.getDiaReunion() == null || peticion.getHoraReunionInicio() == null) {
						throw new Exception(ReadProperties.mensajes.getProp("NO SE HAN ENCONTRADO DATOS PARA ESTA CONSULTA"));
					}
				//Se abre la conexion a la base
				LogHandler.info(uid, getClass(), "==> asignacionDetalleSucursalTarea - intentando abrir Conexion Sybase");
				sesion = FabricaConexiones.obtenerSesionNTx();

				Date fechaContable = comun.obtenerFechaContable( uid ).getFecha();

				List<AsignacionDetalleOV> asignacionesDetalleOracle = new ArrayList<AsignacionDetalleOV>();
				List<AsignacionDetalleOV> asignaciones = new ArrayList<AsignacionDetalleOV>();
				final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			      parametros.put( "numeroSucursal"	 , peticion.getNumeroSucursal() );
				  parametros.put( "diaReunion"		 , peticion.getDiaReunion());
				  parametros.put( "horaReunion"		 , peticion.getHoraReunionInicio());
				  parametros.put( "fechaContable"	 , simpleDateFormat.format(fechaContable));
				  parametros.put( "fechaVariable"	 , simpleDateFormat.format(fechaContable));

				LogHandler.trace(uid, getClass(), "==> asignacionDetalleSucursalTarea - obtenerAsignacionDetalle");
				asignaciones = (List<AsignacionDetalleOV>) sesion.selectList("obtenerAsignacionDetalle", parametros);

//				String sucursal = peticion.getNumeroSucursal().toString().replaceFirst("12", "").trim();
				final java.util.HashMap<String, Object> parametrosOracle = new HashMap<String, Object>();
				parametrosOracle.put( "numeroSucursal"		, peticion.getNumeroSucursal() );
				parametrosOracle.put( "diaReunion"		 	, peticion.getDiaReunion() );
				parametrosOracle.put( "horaReunion"		 	, peticion.getHoraReunionInicio());
				parametrosOracle.put( "fechaContable"	 	, simpleDateFormat.format(fechaContable));
				LogHandler.info(uid, getClass(), "==> asignacionDetalleSucursalTarea - parametrosOracle " );

				LogHandler.info(uid, getClass(), "numeroSucursal"  + parametrosOracle.get( "numeroSucursal"));
				LogHandler.info(uid, getClass(), "diaReunion"  + parametrosOracle.get( "diaReunion"));
				LogHandler.info(uid, getClass(), "horaReunion"  + parametrosOracle.get( "horaReunion"));
				LogHandler.info(uid, getClass(), "fechaContable"  + simpleDateFormat.format(fechaContable));

				LogHandler.trace(uid, getClass(), "==> asignacionDetalleSucursalTarea - obtenerAsignacionDetalleSolicitudes");
				asignacionesDetalleOracle = (List<AsignacionDetalleOV>)
						sesion.selectList("obtenerAsignacionDetalleSolicitudes", parametrosOracle);


				LogHandler.info(uid, getClass(), "Paso#######################");

				List<AsignacionDetalleOV> asignacionesSolicitud = new ArrayList<AsignacionDetalleOV>();
				for (int i = 0; i < asignacionesDetalleOracle.size(); i++) {
					AsignacionDetalleOV asignacionNueva =  asignacionesDetalleOracle.get(i);
					AsignacionDetalleOV asignacionNuevaSolicitud = new AsignacionDetalleOV();

					asignacionNuevaSolicitud = asignacionNueva;

					final AsesorOV asesorOV = AsesorData.obtenAsesor(uid, asignacionNueva.getNumeroAsesor().trim());
					LogHandler.info(uid, getClass(), "########" + asesorOV.toString());
					asignacionNueva.setNombreAsesor(asesorOV.getNombreCompleto());
					asignacionNueva.setNumeroAsesor(asesorOV.getPersona());

					asignacionNuevaSolicitud.setNombreAsesor(asesorOV.getNombreCompleto());
					asignacionNuevaSolicitud.setNumeroAsesor(asesorOV.getPersona());

					asignaciones.add(asignacionNueva);
					//asignacionesSolicitud.add(asignacionNuevaSolicitud);
				}

				respuesta.setAsignacionesDetalle(asignaciones);
				respuesta.setAsignacionesDetalleOracle(asignacionesSolicitud);

			} catch (java.lang.Exception exception) {
				respuesta.getHeader().setEstatus( false );
				respuesta.getHeader().setUID(uid);
				respuesta.getHeader().setMensaje(exception.getMessage());
				LogHandler.error( uid, this.getClass(), "Ocurrio error al consultar : "
						+ exception.getMessage(), exception );
			} finally {
				FabricaConexiones.close(sesion);

			}
			return respuesta;
		}




		@SuppressWarnings("unchecked")
		public AsignacionDetalleRespuesta asignacionDetalleAsesorTarea(String uid, AsignacionDetalleOV peticion) {

			AsignacionDetalleRespuesta respuesta = new AsignacionDetalleRespuesta();
			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setEstatus(true);
			respuesta.getHeader().setUID(uid);
			SqlSession sesion = null;

			try {
				if ( peticion == null || peticion.getNumeroSucursal() == null || peticion.getNumeroAsesor() == null ) {
					throw new Exception(ReadProperties.mensajes.getProp("NO SE HAN ENCONTRADO DATOS PARA ESTA CONSULTA"));
				}

				//Se abre la conexion a la base
				sesion = FabricaConexiones.obtenerSesionNTx();

				if ( peticion.getNumeroSucursal() == 0 ) {
					peticion.setNumeroSucursal(null);
				}

				//declaro mis listas para el universo de asignaciones
				List<AsignacionDetalleOV> asignaciones = new ArrayList<AsignacionDetalleOV>();
				List<AsignacionDetalleOV> asignacionesAsesorOracle = new ArrayList<AsignacionDetalleOV>();


				//Declaro Fecha contable y fecha variabla
				final java.util.Calendar
								fechaContableCalendar = java.util.Calendar.getInstance();
								fechaContableCalendar.setTime(comun.obtenerFechaContable(uid).getFecha());

				//java.util.Calendar fechaContableVariable = fechaContableCalendar; MO
			    java.util.Calendar
								fechaContableVariable = java.util.Calendar.getInstance();
			    				fechaContableVariable.setTime(comun.obtenerFechaContable(uid).getFecha());

				//Verifico si me entregan numeroSemana
				if (peticion.getNumeroSemana() == null)	{
					peticion.setNumeroSemana(0);
				}


				//Para obtener los datos de la segunda semana.
				if ( peticion.getNumeroSemana() > 0 ) {
					int semanas = peticion.getNumeroSemana();
					int dias = semanas * 7;
					fechaContableVariable.add(Calendar.DATE, dias);
				}

				//Se obtienen las reuniones de creditos en sybase
				final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			    parametros.put( "numeroSucursal", peticion.getNumeroSucursal() );
			    parametros.put( "fechaContable", fechaContableCalendar.getTime());
			    parametros.put( "fechaVariable", fechaContableVariable.getTime());
				parametros.put( "vendedor", peticion.getNumeroAsesor());
				LogHandler.info(uid, getClass(), "==> asignacionDetalleAsesorTarea - parametros :"
					  + peticion.getNumeroSucursal() + "," + peticion.getNumeroAsesor() + "," );

				LogHandler.trace(uid, getClass(), "==> asignacionDetalleAsesorTarea - obtenerAsignacionDetalle");
				asignaciones = sesion.selectList("obtenerAsignacionDetalle", parametros);

				//Comentarios por cambio MO
				//Se obtiene el dao a partir del numero de persona
//				LogHandler.trace(uid, getClass(), "==> asignacionDetalleAsesorTarea : obtenDAOApartirPersona");
//				AsignacionDetalleOV personasDao = (AsignacionDetalleOV) sesion.selectOne("obtenDAOApartirPersona", parametros);
//
//				if (personasDao == null) {
//					throw new Exception(ReadProperties.mensajes.getProp("asignacion.detalle.asesor.dao.inexistente"));
//				}

				//Se obtienen las solicitudes de Oracle
				final java.util.HashMap<String, Object> parametrosOracle = new HashMap<String, Object>();
//				String sucursal = peticion.getNumeroSucursal().toString().replaceFirst("12", "").trim();
				parametrosOracle.put( "numeroSucursal"  , peticion.getNumeroSucursal());
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
				String formatted = format1.format(fechaContableVariable.getTime());
				parametrosOracle.put( "fechaContable"	 , formatted);
				parametrosOracle.put( "numeroAsesor" , peticion.getNumeroAsesor());
				LogHandler.trace(uid, getClass(), "==> asignacionDetalleAsesorTarea - obtenerAsignacionDetalleSolicitudes");
				asignacionesAsesorOracle = sesion.selectList("obtenerAsignacionDetalleSolicitudes", parametrosOracle);

				for (int i = 0; i < asignacionesAsesorOracle.size(); i++) {
					AsignacionDetalleOV asignacionNueva =  asignacionesAsesorOracle.get(i);

					if (asignaciones.size() > 0 ) {
						asignacionNueva.setNombreAsesor(asignaciones.get(0).getNombreAsesor());
					}
					else {
						asignacionNueva.setNombreAsesor("");
					}

					asignaciones.add(asignacionNueva);
				}

				//Parte para agregar las solicitudes pendientes de autorizacion
				List<AsignacionDetalleOV> tareasContratoReasignacion = new ArrayList<AsignacionDetalleOV>();
				final java.util.HashMap<String, Object> parametrosContratoTareasReas = new HashMap<String, Object>();
				parametrosContratoTareasReas.put( "asesor", peticion.getNumeroAsesor());
				parametrosContratoTareasReas.put( "fechaContable", fechaContableCalendar.getTime());
				LogHandler.trace(uid, getClass(), "==> asignacionDetalleAsesorTarea - obtenerTareasReasignacionContrato");
				tareasContratoReasignacion =
					sesion.selectList("obtenerTareasReasignacionContrato", parametrosContratoTareasReas);

				if (tareasContratoReasignacion.size() > 0) {
					for (int i = 0; i < tareasContratoReasignacion.size(); i++) {
						AsignacionDetalleOV asignacionNueva =  tareasContratoReasignacion.get(i);
						asignaciones.add(asignacionNueva);
					}
				}

				//En esta parte se agregan los detalles de la Agenda de asignaciones
				List<DetallesAgendaOV> totalDetalles = new ArrayList<DetallesAgendaOV>();

				int count0 = 1;
				int diaReunion0 = 0;
				int totalGrupo0 = 0;
				Double totalParcialidadDia0 = 0.0;

				int count1 = 1;
				int diaReunion1 = 0;
				int totalGrupo1 = 0;
				Double totalParcialidadDia1 = 0.0;

				int count2 = 1;
				int diaReunion2 = 0;
				int totalGrupo2 = 0;
				Double totalParcialidadDia2 = 0.0;

				int count3 = 1;
				int diaReunion3 = 0;
				int totalGrupo3 = 0;
				Double totalParcialidadDia3 = 0.0;

				int count4 = 1;
				int diaReunion4 = 0;
				int totalGrupo4 = 0;
				Double totalParcialidadDia4 = 0.0;

				int count5 = 1;
				int diaReunion5 = 0;
				int totalGrupo5 = 0;
				Double totalParcialidadDia5 = 0.0;

				for (int i = 0; i < asignaciones.size(); i++) {
					if (asignaciones.get(i).getDiaReunion().equals(0)) {
						diaReunion0 = asignaciones.get(i).getDiaReunion();
						totalGrupo0 = count0;
						count0++;
						totalParcialidadDia0 = totalParcialidadDia0 + (asignaciones.get(i).getParcialidad()
								!= null ? asignaciones.get(i).getParcialidad() : 0);
					}
					if (asignaciones.get(i).getDiaReunion().equals(1)) {
						diaReunion1 = asignaciones.get(i).getDiaReunion();
						totalGrupo1 = count1;
						count1++;
						totalParcialidadDia1 = totalParcialidadDia1 + (asignaciones.get(i).getParcialidad()
								!= null ? asignaciones.get(i).getParcialidad() : 0);
					}
					if (asignaciones.get(i).getDiaReunion().equals(2)) {
						diaReunion2 = asignaciones.get(i).getDiaReunion();
						totalGrupo2 = count2;
						count2++;
						totalParcialidadDia2 = totalParcialidadDia2 + (asignaciones.get(i).getParcialidad()
								!= null ? asignaciones.get(i).getParcialidad() : 0);
					}
					if (asignaciones.get(i).getDiaReunion().equals(3)) {
						diaReunion3 = asignaciones.get(i).getDiaReunion();
						totalGrupo3 = count3;
						count3++;
						totalParcialidadDia3 = totalParcialidadDia3 + (asignaciones.get(i).getParcialidad()
								!= null ? asignaciones.get(i).getParcialidad() : 0);
					}
					if (asignaciones.get(i).getDiaReunion().equals(4)) {
						diaReunion4 = asignaciones.get(i).getDiaReunion();
						totalGrupo4 = count4;
						count4++;
						totalParcialidadDia4 = totalParcialidadDia4 + (asignaciones.get(i).getParcialidad()
								!= null ? asignaciones.get(i).getParcialidad() : 0);
					}
					if (asignaciones.get(i).getDiaReunion().equals(5)) {
						diaReunion5 = asignaciones.get(i).getDiaReunion();
						totalGrupo5 = count5;
						count5++;
						totalParcialidadDia5 = totalParcialidadDia5 + (asignaciones.get(i).getParcialidad()
								!= null ? asignaciones.get(i).getParcialidad() : 0);
					}
				}

				DetallesAgendaOV nuevoDetalle = new DetallesAgendaOV();
				nuevoDetalle.setDiaReunion(diaReunion0);
				nuevoDetalle.setTotalGrupoDia(totalGrupo0);
				nuevoDetalle.setTotalParcialidadDia(totalParcialidadDia0);
				totalDetalles.add(nuevoDetalle);

				DetallesAgendaOV nuevoDetalle1 = new DetallesAgendaOV();
				nuevoDetalle1.setDiaReunion(diaReunion1);
				nuevoDetalle1.setTotalGrupoDia(totalGrupo1);
				nuevoDetalle1.setTotalParcialidadDia(totalParcialidadDia1);
				totalDetalles.add(nuevoDetalle1);

				DetallesAgendaOV nuevoDetalle2 = new DetallesAgendaOV();
				nuevoDetalle2.setDiaReunion(diaReunion2);
				nuevoDetalle2.setTotalGrupoDia(totalGrupo2);
				nuevoDetalle2.setTotalParcialidadDia(totalParcialidadDia2);
				totalDetalles.add(nuevoDetalle2);

				DetallesAgendaOV nuevoDetalle3 = new DetallesAgendaOV();
				nuevoDetalle3.setDiaReunion(diaReunion3);
				nuevoDetalle3.setTotalGrupoDia(totalGrupo3);
				nuevoDetalle3.setTotalParcialidadDia(totalParcialidadDia3);
				totalDetalles.add(nuevoDetalle3);

				DetallesAgendaOV nuevoDetalle4 = new DetallesAgendaOV();
				nuevoDetalle4.setDiaReunion(diaReunion4);
				nuevoDetalle4.setTotalGrupoDia(totalGrupo4);
				nuevoDetalle4.setTotalParcialidadDia(totalParcialidadDia4);
				totalDetalles.add(nuevoDetalle4);

				DetallesAgendaOV nuevoDetalle5 = new DetallesAgendaOV();
				nuevoDetalle5.setDiaReunion(diaReunion5);
				nuevoDetalle5.setTotalGrupoDia(totalGrupo5);
				nuevoDetalle5.setTotalParcialidadDia(totalParcialidadDia5);
				totalDetalles.add(nuevoDetalle5);


				//Se evalua la parte para retirar del universo los creditos catorcenales que no corresponden a la semana

				if (peticion.getNumeroSemana().equals(1)) {
					SimpleDateFormat sFormat = new SimpleDateFormat( "yyyy-MM-dd" );
					int semanaContableVC = 0;

					if (peticion.getNumeroSemana().equals(1)) {
						fechaContableVariable.getTime();
						LogHandler.info(uid, getClass(),
							"==> asignacionDetalleAsesorTarea - fechaContableVariable: "
								+ fechaContableVariable.getTime());
						semanaContableVC = fechaContableVariable.get(Calendar.WEEK_OF_YEAR);
						LogHandler.info(uid, getClass(),
						"==> asignacionDetalleAsesorTarea - semanaContableVC: " + semanaContableVC);

					} else {
						fechaContableCalendar.getTime();
						LogHandler.info(uid, getClass(),
							"==> asignacionDetalleAsesorTarea - fechaContableCalendar: "
								+ fechaContableCalendar.getTime());
						semanaContableVC = fechaContableCalendar.get(Calendar.WEEK_OF_YEAR);
						LogHandler.info(uid, getClass(),
						"==> asignacionDetalleAsesorTarea - semanaContableVC: " + semanaContableVC);
					}


					for (int j = 0; j < asignaciones.size(); j++) {
						if (asignaciones.get(j).getFrecuencia().equals("C")) {

		    	  			Date fSemana2 = new Date(sFormat.parse(asignaciones.get(j).getFechaInicio()).getTime());
		    	  			Calendar fechaSemana2 = Calendar.getInstance();
		    	  			fechaSemana2.setTime(fSemana2);
		    	  			int semanaDelAno2 = fechaSemana2.get(Calendar.WEEK_OF_YEAR);
		    	  			LogHandler.info(uid, getClass(),
		    					"==> asignacionDetalleAsesorTarea - semanaContableVC: " + semanaDelAno2);

		    	  			if ( esImpar(semanaContableVC) & !esImpar(semanaDelAno2)) {

		    	  				LogHandler.info(uid, getClass(),
		    	    			"==> asignacionDetalleAsesorTarea - Esta asignacion se elimina del universo"
		    	    			+ asignaciones.get(j).getContrato());
		    	    				asignaciones.remove(j);
		    				} else {
		    					LogHandler.info(uid, getClass(),
		    					"==> asignacionDetalleAsesorTarea - Esta asignacion permanece en el universo");

		    				}

		    	  			if ( !esImpar(semanaContableVC) & esImpar(semanaDelAno2)) {
		    	  				LogHandler.info(uid, getClass(),
		    	    			"==> asignacionDetalleAsesorTarea - Esta asignacion se elimina del universo"
		    	    			+ asignaciones.get(j).getContrato());
		    	    				asignaciones.remove(j);

		    				} else {
		    					LogHandler.info(uid, getClass(),
		    					"==> asignacionDetalleAsesorTarea - Esta asignacion permanece en el universo");

		    				}

						}
					}
				} //Fin evalua.



				respuesta.setDetallesAgenda(totalDetalles);


				respuesta.setAsignacionesDetalle(asignaciones);

			} catch ( java.lang.Exception exception ) {
				respuesta.getHeader().setEstatus( false );
				respuesta.getHeader().setUID( uid );
				respuesta.getHeader().setMensaje(exception.getMessage());
				LogHandler.error( uid, this.getClass(), "Ocurrio error al consultar : "
				+ exception.getMessage(), exception );
			}
			finally {
				FabricaConexiones.close(sesion);
			}
			return respuesta;
		}



		/**
		 * @param uid String
		 * @param peticion tipo AsignacionDetalleOV
		 * @return respuesta
		 */
		public VerificaAsignacionRespuesta validaAsignacionTarea(String uid, AsignacionDetalleOV peticion) {

			VerificaAsignacionRespuesta respuesta = new VerificaAsignacionRespuesta();
			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setEstatus(true);
			respuesta.getHeader().setUID(uid);
			respuesta.setValidaProducto(true);
			SqlSession sesion = null;
			String claveAsesorDummy = "000999998";

			try {

				if ( peticion == null || peticion.getNumeroSucursal() == null
					|| peticion.getNumeroAsesor() == null || peticion.getDiaReunion() == null
					|| peticion.getHoraReunionInicio() == null || peticion.getHoraReunionFin() == null) {
					//respuesta.getHeader().setCodigo("CONTROLADA");
					throw new Exception("ALGUNO DE LOS DATOS DE LA PETICION ES NULA");
				}

				LogHandler.info(uid, getClass(), "validaAsignacionTarea PETICION " + peticion);
				//Validar los horarios
				try {
					validaHorario(uid, peticion.getHoraReunionInicio(), peticion.getHoraReunionFin());
				}
				catch (Exception exValidaHorario) {
					respuesta.getHeader().setMensaje(exValidaHorario.getMessage());
		  	    	respuesta.getHeader().setEstatus( false );
		  	    	throw new Exception(respuesta.getHeader().getMensaje());
				}

				//Se abre la conexion a la base
				sesion = FabricaConexiones.obtenerSesionNTx();

				List<AsignacionDetalleOV> asignacionesInHoras = new ArrayList<AsignacionDetalleOV>();

				//Se verifica si viene o no viene el identificador del contrato osea que se intenta validar una solicitud
				if (peticion.getContrato() == null) {

					//Validacion para el asesor dummy
					LogHandler.info(uid, getClass(), "Se valida si es un asesor dummy: " + peticion.getNumeroAsesor()
							+ "-" + claveAsesorDummy );
					if (peticion.getNumeroAsesor().trim().equals(claveAsesorDummy) ) {
						LogHandler.info(uid, getClass(), "Es un asesor dummy.");
						respuesta.getHeader().setEstatus(true);
						respuesta.setValidaProducto(true);
						respuesta.getHeader().setMensaje("Es correcta la asignacion al asesor dummy.");
						return respuesta;
					}

					//Se obtiene el universo de asignaciones del metodo asignacionDetalleAsesorTarea
					AsignacionDetalleRespuesta respuestaAsignacion = asignacionDetalleAsesorTarea(uid, peticion);

					LogHandler.info(uid, getClass(),
					"==> verificaAsignacionTarea - obteniendo Universo Asignaciones de Sucursal por Asesor: " + respuestaAsignacion);
					asignacionesInHoras = respuestaAsignacion.getAsignacionesDetalle();

					if (!respuestaAsignacion.getHeader().isEstatus()) {
						throw new Exception( respuestaAsignacion.getHeader().getMensaje() );
					}
				} else  {
					//Else peticion.getContrato != null la peticion trae un contrato
					//Para verificar si hay cambio de dia o asesor
					final java.util.HashMap<String, Object> parametrosDiaAsesor = new HashMap<String, Object>();
					parametrosDiaAsesor.put( "contrato", peticion.getContrato());
					LogHandler.trace(uid, getClass(), "==> verificaAsignacionTarea : consultaTareaBuzon");
					AsignacionDetalleOV resDiaAsesor =
						(AsignacionDetalleOV) sesion.selectOne("buscaDiaAsesor", parametrosDiaAsesor);

					if (resDiaAsesor == null) {
						throw new Exception(ReadProperties.mensajes.getProp("asignacion.valida.diasAsesor.existente"));
					}


					//Se agrega logica para saber si cambia asesor o diaReunion
					if (!resDiaAsesor.getDiaReunion().equals(peticion.getDiaReunion())
							|| !resDiaAsesor.getNumeroAsesor().equals(peticion.getNumeroAsesor())) {
						respuesta.setCambioDiaAsesor(true);
						LogHandler.info(uid, getClass(),
						"==> verificaAsignacionTarea - Esta asignacion se almacena en tablas");
					  if (!resDiaAsesor.getNumeroAsesor().equals(peticion.getNumeroAsesor())) {
						if (peticion.getMotivoReasignacion().equals("-1")) {
							throw new Exception("SE NECESITA ELEGIR UN MOTIVO DE REASIGNACION");
						}
					  }

					} else {
						respuesta.setCambioDiaAsesor(false);
						LogHandler.info(uid, getClass(),
							"==> verificaAsignacionTarea - Esta asignacion se modifica");
					}

					//Se hace la validacion para el asesor dummy
					LogHandler.info(uid, getClass(), "Se valida si es un asesor dummy: " + peticion.getNumeroAsesor()
							+ "-" + claveAsesorDummy );
					if (peticion.getNumeroAsesor().trim().equals(claveAsesorDummy) ) {
						LogHandler.info(uid, getClass(), "Es un asesor dummy.");
						respuesta.getHeader().setEstatus(true);
						respuesta.setValidaProducto(true);
						respuesta.getHeader().setMensaje("Es correcta la asignacion al asesor dummy.");
						return respuesta;
					}

					//Se obtiene el universo de asignaciones del metodo asignacionDetalleAsesorTarea
					AsignacionDetalleRespuesta respuestaAsignacion = asignacionDetalleAsesorTarea(uid, peticion);

					if (!respuestaAsignacion.getHeader().isEstatus()) {
						throw new Exception( respuestaAsignacion.getHeader().getMensaje() );
					}


					//Se obtiene el universo de asignaciones del metodo asignacionDetalleAsesorTarea
					LogHandler.info(uid, getClass(),
					"==> verificaAsignacionTarea - obteniendo Universo Asignaciones de Sucursal por Asesor: ");
					asignacionesInHoras = respuestaAsignacion.getAsignacionesDetalle();
			}
			//Fin NO Solicitudes


				List<AsignacionDetalleOV> asignacionesDia = new ArrayList<AsignacionDetalleOV>();

			//Obtengo los contratos en el dia
				for (int i = 0; i < asignacionesInHoras.size(); i++) {
					if (asignacionesInHoras.get(i).getDiaReunion().equals(peticion.getDiaReunion())) {
						AsignacionDetalleOV asignacionNueva =  asignacionesInHoras.get(i);
						asignacionesDia.add(asignacionNueva);
					}
				}

			//Validacion Renovaciones vs Agenda
			if (peticion.getCliente() == null || peticion.getCliente().isEmpty()) {
					peticion.setCliente(null);
			}

			if (peticion.getCliente() != null) {

					//En esta seccion me traigo a la persona en cualquier forma
					LogHandler.trace(uid, getClass(), "==> verificaAsignacionTarea - obtenerPersonaSolicitud");
					LogHandler.info(uid, getClass(), "==> verificaAsignacionTarea - obtenerPersonaSolicitud");

					String cliente = (String) sesion.selectOne("obtenerPersonaSolicitud", peticion.getCliente());
					if (cliente == null) {
						throw new Exception("LA CONSULTA NO ARROJO RESULTADOS PARA LA PERSONA " + peticion.getCliente());
					}

					//si existe realiza el remove para el contrato vs la asignacion del cliente

					for (int i = 0; i < asignacionesDia.size(); i++) {
						//Me traigo los contratos para comparar con las asignaciones
						LogHandler.trace(uid, getClass(), "==> verificaAsignacionTarea : obtenerClienteDeContrato");
						LogHandler.info(uid, getClass(), "==> verificaAsignacionTarea : obtenerClienteDeContrato");

						final java.util.HashMap<String, Object> parametrosCliente = new HashMap<String, Object>();
						parametrosCliente.put( "contrato", asignacionesDia.get(i).getContrato());

						String resCliente = (String) sesion.selectOne("obtenerClienteDeContrato", parametrosCliente);

						if (resCliente == null) {
							resCliente = "";
						}

						LogHandler.info(uid, getClass(), "==> verificaAsignacionTarea cliente: " + cliente
								+ "resCliente" + resCliente);

						if (resCliente.equals(cliente)) {
							asignacionesDia.remove(i);
						}

					}
				}

	        	//Si existe la misma asignacion en el array se elimina, si la asignacion tiene contrato
	        	if (peticion.getContrato() != null) {
	        	for (int i = 0; i < asignacionesDia.size(); i++) {
					if (peticion.getContrato().equals(asignacionesDia.get(i).getContrato())) {
						asignacionesDia.remove(i);
					}
				  }
	        	}

	        	//Si existe la misma solicitud
	        	if (peticion.getIdSolicitud() != null) {
	        	for (int i = 0; i < asignacionesDia.size(); i++) {
					if (peticion.getIdSolicitud().equals(asignacionesDia.get(i).getContrato())) {
						LogHandler.info(uid, getClass(), "ELIMINA MISMA SOLICITU " + peticion.getIdSolicitud());
						asignacionesDia.remove(i);
					}
				  }
	        	}


	        	int numContratos = 0;
	        	//Existen asignaciones para el asesor en ese dia
	        	if (asignacionesDia.size() > 0) {


					SimpleDateFormat df = new SimpleDateFormat("HH:mm", new Locale("es", "ES"));


	        		Date hora = new Date(df.parse(peticion.getHoraReunionInicio()).getTime());
		        	Date horaFin = new Date(df.parse(peticion.getHoraReunionFin()).getTime());

	        	    respuesta.getHeader().setMensaje("Es posible hacer la Asignacion cumple v1 y v2");

		        	//Si es posible hacer la asignacion barre las asignaciones del dia
		        	 for (int i = 0; i < asignacionesDia.size(); i++) {

		        	    	Date ini = new Date(df.parse(asignacionesDia.get(i).getHoraReunionInicio()).getTime());
		        	    	Calendar inicio = Calendar.getInstance();
		        	    	inicio.setTime(ini);
		        	    	inicio.add(Calendar.MINUTE, 1);
		        	    	Date fn = new Date(df.parse(asignacionesDia.get(i).getHoraReunionFin()).getTime());
		        	    	Calendar fin = Calendar.getInstance();
		        	    	fin.setTime(fn);
		        	    	fin.add(Calendar.MINUTE, -1);

		        	    	Calendar horaInicioExacta = Calendar.getInstance();
		        	    	horaInicioExacta.setTime(hora);
		        	    	horaInicioExacta.add(Calendar.MINUTE, 1);

		        	    	Calendar horaFinExacta = Calendar.getInstance();
		        	    	horaFinExacta.setTime(horaFin);
		        	    	horaFinExacta.add(Calendar.MINUTE, -1);

		        	    //Empalme total de horario
		        	   if (horaInicioExacta.getTime().equals(inicio.getTime())
		        			   & horaFinExacta.getTime().equals(fin.getTime())) {
		        		  LogHandler.info(uid, getClass(),
		        			"Este es un empalme total con la asignacion: " + asignacionesDia.get(i).getContrato());
		        		  numContratos = numContratos + 1;

		        			  VerificaAsignacionRespuesta respuestaValida =
		        				  validaProductoFrecuencia(uid, peticion, asignacionesDia.get(i));

		        			  respuesta.setValidaProducto(respuestaValida.getValidaProducto());
		        			  respuesta.getHeader().setEstatus(respuestaValida.getHeader().isEstatus());
		        			  respuesta.getHeader().setCodigo(respuestaValida.getHeader().getCodigo() != null
		        					  ? respuestaValida.getHeader().getCodigo() : "");
		        			  respuesta.setMensajeValidaProducto(respuestaValida.getMensajeValidaProducto());


		        	   } else {

		        	    if (hora.before(inicio.getTime()) & horaFin.before(inicio.getTime())) {
		        	    	LogHandler.info(uid, getClass(), "La asignacion esta antes de la asignacion: "
		        	    			+ asignacionesDia.get(i).getContrato());
		        	    	respuesta.getHeader().setMensaje("Es posible hacer la Asignacion v b,b");

		        	    }

		        	    if (hora.after(fin.getTime()) & horaFin.after(fin.getTime())) {
		        	    	LogHandler.info(uid, getClass(), "La asignacion esta despues de la asignacion: "
		        	    			+ asignacionesDia.get(i).getContrato());
		        	    	respuesta.getHeader().setMensaje("Es posible hacer la Asignacion v a,a");


		        	    }

		        	    //Empalme superior de horario
		        	    if (horaFin.after(inicio.getTime()) & horaFin.before(fin.getTime())) {
		        	    	LogHandler.info(uid, getClass(),
		        	    	  	"Este es un empalme parcial con la asignacion A: "
		        	    			+ asignacionesDia.get(i).getContrato());
		        	    	respuesta.getHeader().setEstatus( false );
		        	    	numContratos = numContratos + 1;

		        	    		VerificaAsignacionRespuesta respuestaValida =
		        	    			validaProductoFrecuencia(uid, peticion, asignacionesDia.get(i));

			        			  respuesta.setValidaProducto(respuestaValida.getValidaProducto());
			        			  respuesta.getHeader().setEstatus(respuestaValida.getHeader().isEstatus());
			        			  respuesta.getHeader().setCodigo(respuestaValida.getHeader().getCodigo() != null
			        					  ? respuestaValida.getHeader().getCodigo() : "");
			        			  respuesta.setMensajeValidaProducto(respuestaValida.getMensajeValidaProducto());

		        	    }

		        	    //Empalme inferior de horario
		        	    if (hora.after(inicio.getTime()) & hora.before(fin.getTime())) {
		        	    	LogHandler.info(uid, getClass(),
		        	    	  		"Este es un empalme parcial con la asignacion B: "
		        	    				+ asignacionesDia.get(i).getContrato());
		        	    	respuesta.getHeader().setEstatus( false );
		        	    	numContratos = numContratos + 1;

		        			  VerificaAsignacionRespuesta respuestaValida =
		        				  validaProductoFrecuencia(uid, peticion, asignacionesDia.get(i));

		        			  respuesta.setValidaProducto(respuestaValida.getValidaProducto());
		        			  respuesta.getHeader().setEstatus(respuestaValida.getHeader().isEstatus());
		        			  respuesta.getHeader().setCodigo(respuestaValida.getHeader().getCodigo() != null
		        					  ? respuestaValida.getHeader().getCodigo() : "");
		        			  respuesta.setMensajeValidaProducto(respuestaValida.getMensajeValidaProducto());
		        	    }

		        	    //Este es un empalme que cubre una asignacion
		        	    if (hora.before(inicio.getTime()) & horaFin.after(fin.getTime())) {
		        	    	LogHandler.info(uid, getClass(),
		        	    	  		"Este es un empalme parcial con la asignacion C: "
		        	    				+ asignacionesDia.get(i).getContrato());
		        	    	respuesta.getHeader().setEstatus( false );
		        	    	numContratos = numContratos + 1;

		        			  VerificaAsignacionRespuesta respuestaValida =
		        				  validaProductoFrecuencia(uid, peticion, asignacionesDia.get(i));

		        			  respuesta.setValidaProducto(respuestaValida.getValidaProducto());
		        			  respuesta.getHeader().setEstatus(respuestaValida.getHeader().isEstatus());
		        			  respuesta.getHeader().setCodigo(respuestaValida.getHeader().getCodigo() != null
		        					  ? respuestaValida.getHeader().getCodigo() : "");
		        			  respuesta.getHeader().setMensaje(respuestaValida.getHeader().getMensaje());
		        			  respuesta.setMensajeValidaProducto(respuestaValida.getMensajeValidaProducto());
		        	    }

		        	  } //fin else

		        	} //fin for

	        } //fin if existen horarios


	        //Se verifica que el numero de traslapes sea menor a 2
	        LogHandler.info(uid, getClass(),
		    	"numContratos: " + numContratos);

	        if (numContratos >= 2) {
	        	respuesta.setNumeroTraslapes(numContratos);
	        	respuesta.getHeader().setMensaje(
				"Existen mas de dos horarios empalmados por lo que no es posible hacer la asignacion correspondiente.");
	        	respuesta.getHeader().setCodigo("CONTROLADA");
	        	respuesta.getHeader().setEstatus( false );

	        } else {
	        	respuesta.setNumeroTraslapes(numContratos);
	        	respuesta.getHeader().setMensaje(
				"La asignacion depende del tipo de producto permitido.\n" + respuesta.getMensajeValidaProducto() != null
					? respuesta.getMensajeValidaProducto() : "");
	        	respuesta.getHeader().setEstatus( respuesta.getValidaProducto());
	        }


			respuesta.setAsignacionesDetalle(asignacionesDia);

			} catch (java.lang.Exception exception)	{

				respuesta.getHeader().setUID( uid );
				respuesta.getHeader().setMensaje(exception.getMessage());
				respuesta.getHeader().setEstatus(false);
				LogHandler.error( uid, this.getClass(), "Ocurrio error al validar : "
						+ exception.getMessage(), exception );
			}
			finally {
				FabricaConexiones.close(sesion);

			}
			return respuesta;
		}


		public boolean validaHorario(String uid, String hora1, String hora2) throws Exception {

	        String[] numerosComoArray1 = hora1.split(":");
	        String[] numerosComoArray2 = hora2.split(":");	        

	        int hh = Integer.parseInt(numerosComoArray2[0]) - Integer.parseInt(numerosComoArray1[0]);
			int mm = Integer.parseInt(numerosComoArray2[1]) - Integer.parseInt(numerosComoArray1[1]);

			//Se obtiene la hora de entrada y la hora de salida
	    	String horaMinima = DataMapper.horaMinima;
	    	String horaMaxima = DataMapper.horaMaxima;

	    	SimpleDateFormat df = new SimpleDateFormat("HH:mm", new Locale("es", "ES"));

		      Date hora = new Date(df.parse(hora1).getTime());
		      LogHandler.info(uid, getClass(), "Hora: " + hora);
		      Date horaFin = new Date(df.parse(hora2).getTime());		      
		      Date horaMin = new Date(df.parse(horaMinima).getTime());
		      LogHandler.info(uid, getClass(), "Hora Minima:" + horaMin);
		      Date horaMax = new Date(df.parse(horaMaxima).getTime());
		      LogHandler.info(uid, getClass(), "Hora Maxima:" + horaMax);


		      if (hora.after(horaMin) & hora.before(horaMax)) {
		    	  if (((hh * 60) + mm) <= 60 ) {
		    		 //respuesta.getHeader().setMensaje("Es posible hacer la Asignacion");

		    	  } else {
		    		  throw new Exception("No es posible hacer la Asignacion porque la asignacion es mayor a 60 min.");
		    	  }
		     } else {
		      		throw new Exception("La hora NO esta dentro del rango de horario de trabajo.");
		     }

			return true;
		}


	/**
	 * @param uid tipo String
	 * @param peticionOriginal tipo AsignacionDetalleOV
	 * @param unaAsignacion tipo AsignacionDetalleOV
	 * @return respuesta
	 */
	public VerificaAsignacionRespuesta validaProductoFrecuencia(String uid,
			AsignacionDetalleOV peticionOriginal, AsignacionDetalleOV unaAsignacion) {
		AsignacionDetalleOV peticionValidaProducto = peticionOriginal;
		AsignacionDetalleOV asignacion = unaAsignacion;
		VerificaAsignacionRespuesta respuesta = new VerificaAsignacionRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);
		SqlSession sesion = null;

		try {
			//Se abre la conexion a la base
			sesion = FabricaConexiones.obtenerSesionNTx();

			LogHandler.info(uid, getClass(), "###########" + peticionOriginal);

			if (peticionValidaProducto.getProducto() == null || peticionValidaProducto.getProducto().isEmpty()) {
				respuesta.setMensajeValidaProducto("LA PETICION NO CONTIENE EL TIPO DE PRODUCTO PARA LA VALIDACION");
			}

			if (peticionValidaProducto.getContrato() != null) {
			//Verifica si ya tiene propietario la tarea
			final java.util.HashMap<String, Object> parametrosValidacionCreditos = new HashMap<String, Object>();
			parametrosValidacionCreditos.put( "contrato", peticionValidaProducto.getContrato());
			LogHandler.info(uid, getClass(), "==> ValidaProducto : obtenerTipoProductosCredito");
			TipoProductosOV tipoProductos = (TipoProductosOV)
				sesion.selectOne("obtenerTipoProductosCredito", parametrosValidacionCreditos);

				if (tipoProductos == null) {
					throw new Exception(ReadProperties.mensajes.getProp("asignacion.buzon.idtarea.incorrecto"));
				}
				peticionValidaProducto.setContrato(tipoProductos.getContrato());
				peticionValidaProducto.setProducto(tipoProductos.getProducto());
				peticionValidaProducto.setFrecuencia(tipoProductos.getFrecuencia());
				peticionValidaProducto.setFechaInicio(tipoProductos.getFechaInicio());

			} else {

			if (peticionValidaProducto.getProducto() != null) {
				peticionValidaProducto.setContrato("Solicitud");
				peticionValidaProducto.setProducto(DataMapper.mapProductos.get(peticionValidaProducto.getProducto()));
				LogHandler.info(uid, getClass(), "Tipo Producto Solicitud: " + peticionValidaProducto.getProducto());
			   	}
			if (peticionValidaProducto.getProducto() == null) {
				peticionValidaProducto.setContrato("Solicitud");
				peticionValidaProducto.setProducto(peticionValidaProducto.getProducto());
				LogHandler.info(uid, getClass(), "Tipo Producto Solicitud: " + peticionValidaProducto.getProducto());
			   	}

			}

			if (peticionValidaProducto.getProducto() == null) {
				throw new Exception("No fue posible mapear el Producto para la validacion.");
			}

			LogHandler.info(uid, getClass(), "###########" +
	    	  		"peticionValidaProducto:" + peticionValidaProducto.getProducto()
	    	  		+ "asignacion:" + asignacion.getProducto());

				//Se evalua se los productos son comunales
				if (DataMapper.mapCategoriaProductos.get(peticionValidaProducto.getProducto()).equals("COMUNAL")
						& DataMapper.mapCategoriaProductos.get(asignacion.getProducto()).equals("COMUNAL")) {

	    	  		LogHandler.info(uid, getClass(),
	    	  		"No es posible hacer la Asignacion porque los contratos son comunales: "
	    	  			+ peticionValidaProducto.getContrato() + "-" + asignacion.getContrato());
	    	    	respuesta.setMensajeValidaProducto(
	    	  		"No es posible hacer la Asignacion porque los contratos son comunales: "
	    	    		+ peticionValidaProducto.getContrato() + "-" + asignacion.getContrato());
	    	    	respuesta.getHeader().setCodigo("CONTROLADA");
	    	    	respuesta.setValidaProducto(false);
	    	  		respuesta.getHeader().setEstatus(false);

	    	  		LogHandler.info(uid, getClass(),
	    	    	  		"Frecuencia1:" + peticionValidaProducto.getFrecuencia()
	    	    	  		+ "Frecuencia2:" + asignacion.getFrecuencia());

	    	  		//Se evalue si los productos son de frecuencia catorcenal
					if (peticionValidaProducto.getFrecuencia().equals("C") & asignacion.getFrecuencia().equals("C")) {
						//Se hace la validacion de semanas
	    	  			SimpleDateFormat sFormat = new SimpleDateFormat( "yyyy-MM-dd" );

	    	  			respuesta.getHeader().setMensaje("GCC1-GCC1 se hara validacion entre semanas: "
	        	    			+ peticionValidaProducto.getContrato() + "-" + asignacion.getContrato() );

	    	  			Date fSemana1 = new Date(sFormat.parse(peticionValidaProducto.getFechaInicio()).getTime());
	    	  			Calendar fechaSemana1 = Calendar.getInstance();
	    	  			fechaSemana1.setTime(fSemana1);
	    	  			int semanaDelAno1 = fechaSemana1.get(Calendar.WEEK_OF_YEAR);

	    	  			Date fSemana2 = new Date(sFormat.parse(asignacion.getFechaInicio()).getTime());
	    	  			Calendar fechaSemana2 = Calendar.getInstance();
	    	  			fechaSemana2.setTime(fSemana2);
	    	  			int semanaDelAno2 = fechaSemana2.get(Calendar.WEEK_OF_YEAR);

	    	  			if ( esImpar(semanaDelAno1) && !esImpar(semanaDelAno2)) {
							respuesta.setMensajeValidaProducto("Es posible hacer la Asignacion: "
								+ peticionValidaProducto.getContrato() + "-" + asignacion.getContrato() );
							respuesta.getHeader().setCodigo("");
							respuesta.setValidaProducto(true);
	    					respuesta.getHeader().setEstatus(true);

	    				} else {
	    					if (!esImpar(semanaDelAno1) && esImpar(semanaDelAno2)) {
	    						respuesta.setMensajeValidaProducto("Es posible hacer la Asignacion: "
	    							+ peticionValidaProducto.getContrato() + "-" + asignacion.getContrato() );
	    						respuesta.getHeader().setCodigo("");
	    						respuesta.setValidaProducto(true);
	    						respuesta.getHeader().setEstatus(true);

	    					} else {

	    						respuesta.setMensajeValidaProducto(
	    						"No es posible hacer la Asignacion porque es una semana impar: "
	    						+ peticionValidaProducto.getContrato() + "-" + asignacion.getContrato() );
	    						respuesta.getHeader().setCodigo("CONTROLADA");
	    						respuesta.setValidaProducto(false);
	    						respuesta.getHeader().setEstatus(false);

	    					}
	    				}
					}
				  }
				//Si los productos son solidarios
				if (DataMapper.mapCategoriaProductos.get(peticionValidaProducto.getProducto()).equals("SOLIDARIO")
						& DataMapper.mapCategoriaProductos.get(asignacion.getProducto()).equals("SOLIDARIO")) {
		    	  		LogHandler.info(uid, getClass(),
		    	  				"Es posible hacer la Asignacion ya que son productos SOLIDARIOS: "
		    	  					+ peticionValidaProducto.getContrato() + "," + asignacion.getContrato());
						respuesta.getHeader().setMensaje(
								"Es posible hacer la Asignacion ya que son productos SOLIDARIOS");
						respuesta.setMensajeValidaProducto(
								"Es posible hacer la Asignacion ya que son productos SOLIDARIOS");
		    	  		respuesta.setValidaProducto(true);
					}
				//Si los productos estan combinados
				if (DataMapper.mapCategoriaProductos.get(peticionValidaProducto.getProducto()).equals("COMUNAL")
					& DataMapper.mapCategoriaProductos.get(asignacion.getProducto()).equals("SOLIDARIO")
					| DataMapper.mapCategoriaProductos.get(peticionValidaProducto.getProducto()).equals("SOLIDARIO")
					& DataMapper.mapCategoriaProductos.get(asignacion.getProducto()).equals("COMUNAL")) {
						LogHandler.info(uid, getClass(),
							"Es posible hacer la Asignacion ya que es una combinacion de productos:"
								+ peticionValidaProducto.getContrato() + "," + asignacion.getContrato());
						respuesta.getHeader().setMensaje(
								"Es posible hacer la Asignacion ya que es una combinacion de productos");
						respuesta.setMensajeValidaProducto(
								"Es posible hacer la Asignacion ya que es una combinacion de productos");
		    	  		respuesta.setValidaProducto(true);
					}


//		Aqui compruebo que me traiga lo que quiero.
//				if(DataMapper.mapCategoriaProductos.get(tipoProductos.getProducto()).equals("COMUNAL")){
//					LogHandler.info(uid, getClass(),
//			    	  		"DataMapper: "
//			    	  			+ DataMapper.mapCategoriaProductos.get(tipoProductos.getProducto()));
//				}

			} catch (java.lang.Exception exception)	{

				respuesta.getHeader().setUID( uid );
				respuesta.getHeader().setMensaje(exception.getMessage());
				respuesta.getHeader().setEstatus( false );
				LogHandler.error( uid, this.getClass(), "Ocurrio error en validaProductoFrecuencia : "
						+ exception.getMessage(), exception );

			}
			finally {
				FabricaConexiones.close(sesion);

			}
		return respuesta;
	}

		/**
		 * @param iNumero tipo int
		 * @return boolean
		 */
		public boolean esImpar(int iNumero) {
			  if (iNumero % 2 != 0) {
			    return true;
			  }
			  else {
			    return false;
			  }
		}

		@SuppressWarnings("unchecked")

		public VerificaAsignacionRespuesta modificaAsignacionTarea(String uid, AsignacionDetalleOV peticion) {

			VerificaAsignacionRespuesta respuesta = validaAsignacionTarea(uid, peticion);

			SqlSession sesion = null;
			SqlSession sesionTx = null;

			if (respuesta.getHeader().isEstatus()) {

			try {
				if ( peticion == null || peticion.getNumeroSucursal() == null
					|| peticion.getNumeroAsesor() == null || peticion.getContrato() == null
					|| peticion.getDiaReunion() == null || peticion.getHoraReunionInicio() == null
					|| peticion.getHoraReunionFin() == null || peticion.getTipoTarea() == null
					|| peticion.getNumeroUsuarioAlta() == null || peticion.getPerfil() == null
					|| peticion.getMotivoReasignacion() == null) {
						throw new Exception("PETICION VACIA O DATOS INCOMPLETOS");
					}

					//Se abre la conexion a la base TX
					sesionTx = FabricaConexiones.obtenerSesionTx();

					if (!respuesta.getCambioDiaAsesor()) {

						final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
						parametros.put( "contrato", peticion.getContrato());
						parametros.put( "horaReunionInicio", peticion.getHoraReunionInicio() );
						parametros.put( "horaReunionFin", peticion.getHoraReunionFin());

						LogHandler.info(uid, getClass(), "==> actualizaAsignacionTarea - parametros " );
					    //se actualiza contrato_grupo en HoraI y HoraF
					  	LogHandler.trace(uid, getClass(), "==> actualizaAsignacionTarea - actualizarAsignacionAsesores");
						sesionTx.update("actualizarAsignacionAsesores", parametros);
						sesionTx.commit( true );

						respuesta.getHeader().setMensaje("Se ha actualizado la asignacion directamente en el Horario.");

					}

					if (respuesta.getCambioDiaAsesor()) {

						//Se abre la conexion a la base Ntx
						sesion = FabricaConexiones.obtenerSesionNTx();

						final java.util.HashMap<String, Object> parametrosAsignacionExiste = new HashMap<String, Object>();
						//parametrosAsignacionExiste.put( "asesor", peticion.getNumeroAsesor());
						parametrosAsignacionExiste.put( "contrato", peticion.getContrato());

						List<AsignacionDetalleOV> resAsignacionExiste = new ArrayList<AsignacionDetalleOV>();
						resAsignacionExiste = sesion.selectList("validaAsignacionExiste", parametrosAsignacionExiste);

						if (resAsignacionExiste.size() > 0) {
							throw new Exception(ReadProperties.mensajes.getProp("asignacion.modifica.existente"));
						}

						final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
						parametros.put( "contrato", peticion.getContrato());

						LogHandler.trace(uid, getClass(), "==> modificaAsignacionTarea : buscaDiaAsesor");
						AsignacionDetalleOV resDiasHorasAsesor
							= (AsignacionDetalleOV) sesion.selectOne("buscaDiaAsesor", parametros);

						if (resDiasHorasAsesor == null) {
							throw new Exception(ReadProperties.mensajes.getProp("asignacion.modifica.resdiahoras"));
						}

						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
						Calendar cal = Calendar.getInstance();

						//Se obtiene el usuario que atiende las tareas de reasignacion de cartera
						LogHandler.trace(uid, getClass(), "consultarSolicitudCreditoTarea: - obtenerParGeneral");
						ParGeneralOV usuarioDefault = comun.obtenerParGeneralOV(uid, "BUZTA_TREC");
								//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "BUZTA_TREC");

						if (usuarioDefault == null || usuarioDefault.getCgValor().trim().isEmpty() ) {
							throw new Exception(ReadProperties.mensajes.getProp(
									"asignacion.modifica.usuario.default"));
						}

						final java.util.HashMap<String, Object> parametrosBuzonTareas = new HashMap<String, Object>();
						parametrosBuzonTareas.put( "tipoTarea", peticion.getTipoTarea());
						parametrosBuzonTareas.put( "sucursal", peticion.getNumeroSucursal());
						parametrosBuzonTareas.put( "descripcion", resDiasHorasAsesor.getContratoLD());
						parametrosBuzonTareas.put( "fechaAlta", new Date());
						parametrosBuzonTareas.put( "usuarioAlta", peticion.getNumeroUsuarioAlta());
						parametrosBuzonTareas.put( "fechaUltMod", new Date());
						parametrosBuzonTareas.put( "perfil", peticion.getPerfil());
						parametrosBuzonTareas.put( "status", "P");
						parametrosBuzonTareas.put( "usuario_propietario", usuarioDefault.getCgValor().trim());
						LogHandler.trace(uid, getClass(), "==> actualizaAsignacionTarea - insertaBuzonTareas");
						Integer numeroRegistros = sesionTx.insert("insertaBuzonTareas", parametrosBuzonTareas);

						LogHandler.info(uid, getClass(), "" + numeroRegistros);
						//LogHandler.info(uid, getClass(),"" + parametrosBuzonTareas.get("idTarea").toString());

						final java.util.HashMap<String, Object> parametrosTareasReasignacion = new HashMap<String, Object>();
						parametrosTareasReasignacion.put( "idTarea", parametrosBuzonTareas.get("idTarea"));
						parametrosTareasReasignacion.put( "motivoReasignacion", peticion.getMotivoReasignacion());
						parametrosTareasReasignacion.put( "contrato", peticion.getContrato());
						parametrosTareasReasignacion.put( "diaReunion", resDiasHorasAsesor.getDiaReunion());
						parametrosTareasReasignacion.put( "horaReunionInicio", resDiasHorasAsesor.getHoraReunionInicio());
						parametrosTareasReasignacion.put( "horaReunionFin", resDiasHorasAsesor.getHoraReunionFin());
						parametrosTareasReasignacion.put( "numeroAsesor", resDiasHorasAsesor.getNumeroAsesor());
						parametrosTareasReasignacion.put( "diaReunionNuevo", peticion.getDiaReunion());
						parametrosTareasReasignacion.put( "horaReunionInicioNuevo", peticion.getHoraReunionInicio());
						parametrosTareasReasignacion.put( "horaReunionFinNuevo", peticion.getHoraReunionFin());
						parametrosTareasReasignacion.put( "numeroAsesorNuevo", peticion.getNumeroAsesor());

						LogHandler.trace(uid, getClass(), "==> actualizaAsignacionTarea - insertaTareasReasignacion");
						sesionTx.insert("insertaTareasReasignacion", parametrosTareasReasignacion);
						sesionTx.commit( true );

						respuesta.getHeader().setMensaje("Se ha insertado la asignacion en las 2 tablas correspondientes.");

				}

			} catch ( java.lang.Exception exception )	{
				FabricaConexiones.rollBack(sesionTx);
				respuesta.getHeader().setUID(uid);
				respuesta.getHeader().setMensaje(exception.getMessage());
				respuesta.getHeader().setEstatus( false );
				LogHandler.error( uid, this.getClass(), "Error al actualizar una asignacion : "
						+ exception.getMessage(), exception );
			}
			finally {
				FabricaConexiones.close(sesion);
				FabricaConexiones.close(sesionTx);

			}


			} //fin horario
		  return respuesta;
		}


		/**
		 * @param uid String
		 * @param peticion ConsultaBuzonPeticion
		 * @return BuzonOV
		 */
		@SuppressWarnings("unchecked")
		public BuzonOV consultaBuzonTareas(String uid, ConsultaBuzonPeticion peticion) {
			BuzonOV respuesta = new BuzonOV();
			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setEstatus(true);
			respuesta.getHeader().setUID(uid);
			SqlSession sesion = null;
			String correoRegional = null;
			String correoDivisional = null;
			try {
				//Se abre la conexion a la base Ntx
				sesion = FabricaConexiones.obtenerSesionNTx();

				if (peticion == null) {
					throw new Exception(ReadProperties.mensajes.getProp("asignacion.buzon.peticion.incorrecta"));
				}

				if (peticion.getSucursal() == null || peticion.getSucursal() == 120 || peticion.getSucursal() == 12000 ) {
					peticion.setSucursal(0);
				}

				//----inicia: REQ:484 aprobacion electronica
				ParGeneralOV correoSubComercial =  comun.obtenerParGeneralOV(uid, "CORREO_SUB_COMERCIAL");
				if (correoSubComercial == null || correoSubComercial.getCgValor() == null) {
					throw new Exception("No fue posible recueperar la jdni: CORREO_SUB_COMERCIAL");
			    }
				LogHandler.info(uid, getClass(), "==>CORREO_SUB_COMERCIAL: " + correoSubComercial.getCgValor());
				//----termina: REQ:484 aprobacion electronica


				ParGeneralOV correoGerenteRegional =  comun.obtenerParGeneralOV(uid, "CORREO_GERENTE_REGIONAL");
				if (correoGerenteRegional == null || correoGerenteRegional.getCgValor() == null) {
					throw new Exception("No fue posible recueperar la jdni: CORREO_GERENTE_REGIONAL");
			    }
				LogHandler.info(uid, getClass(), "==>CORREO_GERENTE_REGIONAL: " + correoGerenteRegional.getCgValor());

				List<TareaOV> buzon = new ArrayList<TareaOV>();
				List<TareaOV> buzonEx = new ArrayList<TareaOV>();

				if ( peticion.getUsuarioPropietario() != null ) {
					if ( peticion.getUsuarioPropietario().trim().isEmpty()) {
						peticion.setUsuarioPropietario(null);
					}
				}
				final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
				parametros.put("perfil", peticion.getPerfil());
				parametros.put("sucursal", peticion.getSucursal());
				parametros.put("tipo_tarea", peticion.getTipoTarea());

				parametros.put("status", peticion.getStatus());
				parametros.put("usuario_propietario", peticion.getUsuarioPropietario());
				LogHandler.trace(uid, getClass(), "==> consultaBuzonTareas : obtenerBuzonTareas");
				buzon = (List<TareaOV>) sesion.selectList("obtenerBuzonTareas", parametros);

				// se agregan los tipos de tarea TOEG
				if ( peticion.getPerfil().equals("PSUC")) {
					parametros.put("tipoTarea", peticion.getTipoTareaEx());
					buzonEx = (List<TareaOV>) sesion.selectList("obtenerBuzonTareasExPorTipoTarea", parametros);
					buzon.addAll(buzonEx);
				}

				if (buzon.size() == 0) {
					throw new Exception("No existen tareas en el buzon.");
				}

				//limpieza de datos
				for (int i = 0; i < buzon.size(); i++) {
				//----inicia: REQ:484 aprobacion electronica
					    // correo subdirector comercial
					if (buzon.get(i).getSucursal() != null) {
					   correoRegional = (String) sesion.selectOne("obtenerCorreoRegional", buzon.get(i).getSucursal());
					   correoDivisional = (String) sesion.selectOne("obtenerCorreoDivisional", buzon.get(i).getSucursal());
					}
					LogHandler.info(uid, getClass(), "==> Sucursal: " + buzon.get(i).getSucursal()
							+ "correoRegional: " + correoRegional + "\tcorreoDivisional: " + correoDivisional);
					if (correoSubComercial.getCgValor().trim().isEmpty()) {
						buzon.get(i).setOtroCorreo("Sin Correo Electrónico");
					} else {
						buzon.get(i).setOtroCorreo(correoSubComercial.getCgValor().trim());
					}
					    // correo regional
					if (correoRegional == null || correoRegional.trim().isEmpty()) {
						buzon.get(i).setCorreoRegional(correoGerenteRegional.getCgValor());
						//buzon.get(i).setCorreoRegional("Sin Correo Electrónico");
					} else {
						buzon.get(i).setCorreoRegional(correoRegional.trim());
					}
					   //correo divisional
					if (correoDivisional == null || correoDivisional.trim().isEmpty()) {
						buzon.get(i).setCorreoDivisional(correoSubComercial.getCgValor());
						//buzon.get(i).setCorreoDivisional("Sin Correo Electrónico");
					} else {
						buzon.get(i).setCorreoDivisional(correoDivisional.trim());
					}
				//----termina: REQ:484 aprobacion electronica
					buzon.get(i).setFechaAsignacion( buzon.get(i).getFechaAsignacion() == null
							  ? " " : buzon.get(i).getFechaAsignacion());
					buzon.get(i).setFechaTermino( buzon.get(i).getFechaTermino() == null
							  ? " " : buzon.get(i).getFechaTermino());
					buzon.get(i).setNombreRegion( buzon.get(i).getNombreRegion() == null
							 ? " " : buzon.get(i).getNombreRegion().trim() );
					buzon.get(i).setNombreSucursal( buzon.get(i).getNombreSucursal() == null
							 ? " " : buzon.get(i).getNombreSucursal().trim() );
					buzon.get(i).setEstatusSolicitud(buzon.get(i).getEstatusSolicitud() == null
							 ? " " : buzon.get(i).getEstatusSolicitud());
					buzon.get(i).setEstatus( buzon.get(i).getEstatus() == null
							 ? " " : buzon.get(i).getEstatus());
					buzon.get(i).setDescripcion( buzon.get(i).getDescripcion() == null
							 ? " " : buzon.get(i).getDescripcion());
					buzon.get(i).setCodigoResolucion( buzon.get(i).getCodigoResolucion() == null
							 ? " " : buzon.get(i).getCodigoResolucion());
					buzon.get(i).setCiclo( buzon.get(i).getCiclo() == null
							 ? 0 : buzon.get(i).getCiclo());
					buzon.get(i).setCategoria( buzon.get(i).getCategoria() == null
							 ? " " : buzon.get(i).getCategoria());
					buzon.get(i).setExpress( buzon.get(i).getExpress() == null
							 ? " " : buzon.get(i).getExpress());
					buzon.get(i).setCampana( buzon.get(i).getCampana() == null
							 ? " " : buzon.get(i).getCampana());
					buzon.get(i).setNombreGrupo( buzon.get(i).getNombreGrupo() == null
							 ? " " : buzon.get(i).getNombreGrupo());
					if (buzon.get(i).getCodigoCampana() == null || buzon.get(i).getCodigoCampana().trim().isEmpty()
							|| buzon.get(i).getCodigoCampana().equals(Constantes.SIN_CAMPANA)) {
						buzon.get(i).setCodigoCampana("-");
					} else {
						if (buzon.get(i).getCodigoCampana().contains("CE0")) {
							buzon.get(i).setCodigoCampana(buzon.get(i).getCodigoCampana().replace("CE0", ""));
						}
					}

					// Se recorre cada objeto del buzon
					// si es firma electronica hay que validar
					// si ya fueron firmados por los Regionales, Divisionales o Subdirector
					// de acuerdo a los motivos del CEC
					if (buzon.get(i).isEsFirmaElectronica()) {
						LogHandler.info(uid, getClass(), "Es una tarea de Firma Electronica");
						//consultar los motivos del CEC de la tarea
						List<ExcepcionGarantiaPeticion> motivocCECFE = (List<ExcepcionGarantiaPeticion>)
								sesion.selectList("listaMotivosCECFE", buzon.get(i).getIdTareaFirmaElec());
						if (motivocCECFE.size() == 0) {
							throw new Exception("No existen motivos para la tarea.");
						} else {
							//Validar si algun motivo esta dentro de los motivos de escalamiento
							//si al menos hay uno se deveran validar todas las resoluciones
							//en caso contrario solo la resolucion del regional
							boolean validaTodo = false;
							ParGeneralOV parGeneral = comun.obtenerParGeneralOV(uid, "MOTIVOS_DIVISIONAL");
							if (parGeneral == null) {
								throw new Exception("No existe la JNDI MOTIVOS_DIVISIONAL.");
							}
							final String[] motivosEscalamiento = parGeneral.getCgValor().split(",");
							for (int j = 0; j < motivocCECFE.size(); j++) {
								for (int k = 0; k < motivosEscalamiento.length; k++) {
									if (motivosEscalamiento[k].equals(motivocCECFE.get(j).getJustificacion())) {
										validaTodo = true;
									}
								}
							}

							if (validaTodo) {
								//Valida todas las resoluciones
								if (buzon.get(i).getResolucionRegional().equals("ENVI")
										&& (buzon.get(i).getResolucionDivisional().equals("ENVI")
										&& buzon.get(i).getResolucionSubdirector().equals("ENVI"))) {
									LogHandler.info(uid, getClass(), "ENTRO 1");
									buzon.get(i).setResolucionFIE("yellow");
								} else if (buzon.get(i).getResolucionRegional().equals("APRO")
										&& (buzon.get(i).getResolucionDivisional().equals("ENVI")
										&& buzon.get(i).getResolucionSubdirector().equals("ENVI"))) {
									LogHandler.info(uid, getClass(), "ENTRO 2");
									buzon.get(i).setResolucionFIE("yellow");
								} else if (buzon.get(i).getResolucionRegional().equals("APRO")
										&& (buzon.get(i).getResolucionDivisional().equals("ENVI")
										&& buzon.get(i).getResolucionSubdirector().equals("RECH"))) {
									LogHandler.info(uid, getClass(), "ENTRO 3");
									buzon.get(i).setResolucionFIE("red");
								} else if (buzon.get(i).getResolucionRegional().equals("APRO")
										&& (buzon.get(i).getResolucionDivisional().equals("RECH")
										&& buzon.get(i).getResolucionSubdirector().equals("RECH"))) {
									LogHandler.info(uid, getClass(), "ENTRO 4");
									buzon.get(i).setResolucionFIE("red");
								} else if (buzon.get(i).getResolucionRegional().equals("APRO")
										&& (buzon.get(i).getResolucionDivisional().equals("RECH")
										&& buzon.get(i).getResolucionSubdirector().equals("ENVI"))) {
									LogHandler.info(uid, getClass(), "ENTRO 5");
									buzon.get(i).setResolucionFIE("red");
								} else if (buzon.get(i).getResolucionRegional().equals("APRO")
										&& (buzon.get(i).getResolucionDivisional().equals("ENVI")
										&& buzon.get(i).getResolucionSubdirector().equals("APRO"))) {
									LogHandler.info(uid, getClass(), "ENTRO 6");
									buzon.get(i).setResolucionFIE("green");
								} else if (buzon.get(i).getResolucionRegional().equals("APRO")
										&& (buzon.get(i).getResolucionDivisional().equals("APRO")
										&& buzon.get(i).getResolucionSubdirector().equals("ENVI"))) {
									LogHandler.info(uid, getClass(), "ENTRO 7");
									buzon.get(i).setResolucionFIE("green");
								} else if (buzon.get(i).getResolucionRegional().equals("APRO")
										&& (buzon.get(i).getResolucionDivisional().equals("APRO")
										&& buzon.get(i).getResolucionSubdirector().equals("APRO"))) {
									LogHandler.info(uid, getClass(), "ENTRO 8");
									buzon.get(i).setResolucionFIE("green");
								} else if (buzon.get(i).getResolucionRegional().equals("RECH")) {
									LogHandler.info(uid, getClass(), "ENTRO 9");
									buzon.get(i).setResolucionFIE("red");
								}
							} else {
								//Valida solo la resolucion del Regional
								if (buzon.get(i).getResolucionRegional().equals("ENVI")) {
									buzon.get(i).setResolucionFIE("yellow");
								} else if (buzon.get(i).getResolucionRegional().equals("RECH")) {
									buzon.get(i).setResolucionFIE("red");
								} else if (buzon.get(i).getResolucionRegional().equals("APRO")) {
									buzon.get(i).setResolucionFIE("green");
								}
							}
						}
					}
				}

				List<Integer> listaId = new ArrayList<Integer>();

				for (int i = 0; i < buzon.size(); i++) {
					//Quitamos tareas del buzon que tiene la sucursal
					//LogHandler.info(uid, getClass(), "==> ***************" + buzon.get(i).getEstatus().trim());
					if (peticion.getPerfil().trim().equals("PCEC")
						&& buzon.get(i).getEstatus().trim().equals("OBSERVACIONES_CEC")) {
						listaId.add(buzon.get(i).getIdTarea());
						//buzon.remove(i);
					}
				}

				List<TareaOV> buzon2 = new ArrayList<TareaOV>();
				for (TareaOV tarea : buzon) {
					boolean quitar = false;
					for ( Integer inte : listaId) {
						if ( tarea.getIdTarea().intValue() == inte.intValue() ) {
							quitar = true;
							//LogHandler.info(uid, getClass(), "==> ******QUITAR*********" + tarea.getIdTarea().intValue());
						}
					}

					if (!quitar) {
						buzon2.add(tarea);
					}
				}


				//LogHandler.info(uid, getClass(), "==> ***************" + buzon2.size());
				//Tipificacion productos
				for (int i = 0; i < buzon2.size(); i++) {
					if (buzon2.get(i).getTipoTarea().trim().equals("TECR")) {
						buzon2.get(i).setTipificacionProducto(
								FuncionesComunes.tipificacionProductos(
										buzon2.get(i).getCodigoProducto() == null ? "" : buzon2.get(i).getCodigoProducto(),
												buzon2.get(i).getCategoria().trim().equals("FIN") ? true : false,
														buzon2.get(i).getExpress().trim().equals("S") ? true : false
								));
					} else {
						buzon2.get(i).setTipificacionProducto("");
					}
				}

				respuesta.setBuzon(buzon2);

			} catch ( java.lang.Exception exception ) {
				respuesta.getHeader().setUID(uid);
				respuesta.getHeader().setMensaje(exception.getMessage());
				respuesta.getHeader().setEstatus( false );
				LogHandler.error( uid, this.getClass(), "Error en consultaBuzonTareas : "
						+ exception.getMessage(), exception );
			}
			finally {
				FabricaConexiones.close(sesion);

			}
			return respuesta;
		}



		/**
		 * @param uid :
		 * @param peticion :
		 * @return asignaTareaPropietario :
		 */
		public AsignaTareaPropietarioRespuesta
		asignaTareaPropietario(String uid, AsignaTareaPropietarioPeticion peticion) {
			AsignaTareaPropietarioRespuesta respuesta = new AsignaTareaPropietarioRespuesta();
			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setEstatus(true);
			respuesta.getHeader().setUID(uid);
			SqlSession sesion = null;
			SqlSession sesionTx = null;
			try {
				//Se abre la conexion a la base Ntx
				sesion = FabricaConexiones.obtenerSesionNTx();

				//Verifica si ya tiene propietario la tarea
				final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
				parametros.put("id_tarea", peticion.getIdTarea());
				LogHandler.trace(uid, getClass(), "==> asignaTareaPropietario : consultaTareaBuzon");
				TareaOV tarea = (TareaOV) sesion.selectOne("consultaTareaBuzon", parametros);

				if (tarea == null) {
					throw new Exception(ReadProperties.mensajes.getProp("asignacion.buzon.idtarea.incorrecto"));
				}


				LogHandler.info(uid, getClass(), "***" + tarea.getPropietario() + "***");

				if (tarea.getPropietario() == null || tarea.getPropietario().trim().isEmpty()) {

					if (peticion.getPropietario() == null || peticion.getPropietario().isEmpty()) {
						throw new Exception(ReadProperties.mensajes.getProp(
								"asignacion.buzon.propietario.incorrecto"));
					}
					parametros.put("usuario_propietario", peticion.getPropietario());

					sesionTx = FabricaConexiones.obtenerSesionTx();
					LogHandler.trace(uid, getClass(), "==> actualizarTarea : consultaTareaBuzon");
					sesionTx.update("actualizarTarea", parametros);
					sesionTx.commit(true);
				}
				else {
					throw new Exception(ReadProperties.mensajes.getProp("asignacion.buzon.propietario.ocupada"));
				}

			} catch ( java.lang.Exception exception ) {
				FabricaConexiones.rollBack(sesionTx);
				respuesta.getHeader().setUID(uid);
				respuesta.getHeader().setMensaje(exception.getMessage());
				respuesta.getHeader().setEstatus( false );
				LogHandler.error( uid, this.getClass(), "Error en asignaTareaPropietario : "
						+ exception.getMessage(), exception );
			}
			finally {
				FabricaConexiones.close(sesion);
				FabricaConexiones.close(sesionTx);
			}
			return respuesta;
		}


		public AutorizaReasignacionRespuesta autorizaReasignacionTarea(String uid,
				AsignacionDetalleOV peticion) {
			AutorizaReasignacionRespuesta respuesta = new AutorizaReasignacionRespuesta();
			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setEstatus(true);
			respuesta.getHeader().setUID(uid);
			SqlSession sesion = null;
			SqlSession sesionTx = null;
			try {
				if (peticion == null || peticion.getIdTarea() == null || peticion.getIdTarea().toString().isEmpty()) {
					throw new Exception("La peticion esta vacia o algun dato es null.");
				}
				//Se abre la conexion a la base Ntx
				sesion = FabricaConexiones.obtenerSesionNTx();

				List<AsignacionDetalleOV> autorizaciones = new ArrayList<AsignacionDetalleOV>();

				final java.util.HashMap<String, Object> parametrosValida = new HashMap<String, Object>();
				parametrosValida.put( "idTarea", peticion.getIdTarea());


				LogHandler.trace(uid, getClass(), "==> autorizaReasignacionTarea - validaAsignacionExiste");
				AsignacionDetalleOV tareasReasignacion =
						(AsignacionDetalleOV) sesion.selectOne("obtenerAsignacionDetalleContrato", parametrosValida);

				if (tareasReasignacion == null) {
					throw new Exception(ReadProperties.mensajes.getProp("asignacion.autoriza.idtarea.inexistente"));
				}

				autorizaciones.add(tareasReasignacion);

				respuesta.setAutorizacionesPendientes(autorizaciones);

				//En el mismo metodo nos valida si es un Rechazo o una Autorizacion
				if (peticion.getStatus() != null) {
					if (peticion.getStatus().equals("R")) {
						sesionTx = FabricaConexiones.obtenerSesionTx();

						final java.util.HashMap<String, Object> parametrosBuzon = new HashMap<String, Object>();
						parametrosBuzon.put( "idTarea", peticion.getIdTarea());
						parametrosBuzon.put( "status", peticion.getStatus());

						  LogHandler.trace(uid, getClass(), "==> autorizaReasignacionTarea - parametros " );


						//se actualiza buzon_tareas en status
						  	LogHandler.trace(uid, getClass(),
							"==> autorizaReasignacionTarea - Query: actualizarStatusBuzon");
						  	sesionTx.update("actualizarStatusBuzon", parametrosBuzon);
							sesionTx.commit( true );

							respuesta.getHeader().setMensaje("Se ha rechazado la tarea.");
					}
					if (peticion.getStatus().equals("A")) {

						sesionTx = FabricaConexiones.obtenerSesionTx();

						final java.util.HashMap<String, Object> parametrosAutor = new HashMap<String, Object>();
						parametrosAutor.put( "asesor", autorizaciones.get(0).getNumeroAsesorNuevo());
						parametrosAutor.put( "diaReunion", autorizaciones.get(0).getDiaReunionNuevo());
						parametrosAutor.put( "horaReunionInicio", autorizaciones.get(0).getHoraReunionInicioNuevo());
						parametrosAutor.put( "horaReunionFin", autorizaciones.get(0).getHoraReunionFinNuevo());
						parametrosAutor.put( "contrato", autorizaciones.get(0).getContrato());

						LogHandler.trace(uid, getClass(), "==> autorizaReasignacionTarea - parametros: "
								+ autorizaciones.get(0).getNumeroAsesorNuevo()
								+ autorizaciones.get(0).getDiaReunionNuevo()
								+ autorizaciones.get(0).getHoraReunionInicioNuevo()
								+ autorizaciones.get(0).getHoraReunionFinNuevo()
						);

						//se actualiza buzon_tareas en status
						LogHandler.trace(uid, getClass(),
								"==> autorizaReasignacionTarea - Query: actualizarAutorizacionAceptada");

						sesionTx.update("actualizarAutorizacionAceptada", parametrosAutor);


						//Se actualiza el vendedor en contratos
						final java.util.HashMap<String, Object>
									parametrosActualizaVendedor = new HashMap<String, Object>();
									parametrosActualizaVendedor.put( "contrato" , autorizaciones.get(0).getContrato() );
									parametrosActualizaVendedor.put( "vendedor" , autorizaciones.get(0).getNumeroAsesorNuevo() );

						LogHandler.trace(uid, getClass(), "==> reasignarCartera - actualizarVendedor" );
						sesionTx.update( "actualizarVendedor", parametrosActualizaVendedor );

						final java.util.HashMap<String, Object> parametrosBuzon = new HashMap<String, Object>();
						parametrosBuzon.put( "idTarea", peticion.getIdTarea());
						parametrosBuzon.put( "status", peticion.getStatus());

						LogHandler.trace(uid, getClass(), "==> autorizaReasignacionTarea - parametros " );


							//se actualiza buzon_tareas en status
							  	LogHandler.trace(uid, getClass(),
								"==> autorizaReasignacionTarea - Query: actualizarStatusBuzon");
							  	sesionTx.update("actualizarStatusBuzon", parametrosBuzon);

						  	sesionTx.commit( true );


							respuesta.getHeader().setMensaje("Se ha autorizado la tarea.");
					}
				}

			} catch ( java.lang.Exception exception ) {
				FabricaConexiones.rollBack(sesionTx);
				respuesta.getHeader().setUID(uid);
				respuesta.getHeader().setMensaje(exception.getMessage());
				respuesta.getHeader().setEstatus( false );
				LogHandler.error( uid, this.getClass(), "Error en autorizaReasignacionTarea : "
						+ exception.getMessage(), exception );
			}
			finally {
				FabricaConexiones.close(sesion);
				FabricaConexiones.close(sesionTx);
			}
			return respuesta;
		}

		@SuppressWarnings("unchecked")
		public DatosCreditoIntegrantesRespuesta
		obtenerDatosCreditoIntegrantesCompleto(	String uid, ConsultaCreditoPeticion peticion) {
			DatosCreditoIntegrantesRespuesta respuesta = new DatosCreditoIntegrantesRespuesta();
			respuesta.setHeader(new EncabezadoRespuesta());
			DatosCreditoOV datosCredito = null;
			SqlSession sesion = null;

			try {
				if (peticion.getContrato() == null)
					{
					throw new Exception(ReadProperties.mensajes.getProp("ciof.contratoinvalido"));
					}

				peticion.setContrato(comun.obtenerNumeroContrato(uid, peticion.getContrato()));

				if (peticion.getContrato() == null  )
					{
					throw new Exception(ReadProperties.mensajes.getProp("ciof.contratoinvalido"));
					}

				//Se realiza la validacion para la relacion de sucursal-contrato
				final java.util.HashMap<String, Object>
										parametros = new java.util.HashMap<String, Object>();
										parametros.put("contrato" , peticion.getContrato() );
										parametros.put( "sucursal", peticion.getSucursal() 	 );

				//si se manda cierta sucursal, se comprueba q deba ser validada o se checa si esta excenta
				if (peticion.getContrato() != null && peticion.getSucursal() !=null
						&& peticion.getSucursal() != 0 && peticion.getSucursal() != 120 )
					{
					if ( !comun.comprobarContratoSucursal( uid, parametros ) )
						{
							throw new Exception(
									ReadProperties.mensajes.getProp( "reportes.obtenerestadocuenta.errorcontratosucursal" ));
						}
					}

				//Se recuperan los datos del contrato
				final DatosCreditoRespuesta consutaCredito = obtenerDatosCredito(uid, peticion);
				if (consutaCredito != null && consutaCredito.getHeader().isEstatus() && consutaCredito.getDatosCredito() != null)
					{
					 datosCredito = consutaCredito.getDatosCredito();
					 respuesta.setDatosCredito(datosCredito);
					}
				else
				 	{
					 throw new Exception(ReadProperties.mensajes.getProp("consultas.consultasaldocredito.errorregistrosvacios"));
				 	}

				sesion = FabricaConexiones.obtenerSesionNTx();

				LogHandler.trace(uid, getClass(), "==> obtenerDatosCreditoIntegrantes - obtenerDatosIntegrante");
				List<DatosIntegranteResumenOV> integrantes = (List<DatosIntegranteResumenOV>)
						sesion.selectList("obtenerDatosIntegranteCompleto", peticion.getContrato());
				respuesta.setIntegrantes(integrantes.toArray(new DatosIntegranteResumenOV[integrantes.size()]));

				//Reestructuras
				final HashMap<Object, Object> params = new HashMap<Object, Object>();
				params.put("contrato", peticion.getContrato() );
				params.put("fechaActual", formatter.format(comun.obtenerFechaContable(uid).getFecha()) );
				LogHandler.trace(uid, this.getClass(), "==> obtenerDatosCreditoIntegrantes - obtenerSaldoV");
				final HashMap<Object, Object> result = (HashMap<Object, Object>) sesion.selectOne("obtenerSaldoV", params);

				LogHandler.debug(uid, getClass(), "obtenerDatosCreditoIntegrantes interes= "
				+ ((BigDecimal) result.get("Interes Vencido")) + ((BigDecimal) result.get("Iva Interes Vencido")) );
				LogHandler.debug(uid, getClass(), "obtenerDatosCreditoIntegrantes capital vencido= "
				+ ((BigDecimal) result.get("Capital Vencido")));
				LogHandler.debug(uid, getClass(), "obtenerDatosCreditoIntegrantes capital= "
				+ ((BigDecimal) result.get("Capital Insoluto")));
				LogHandler.debug(uid, getClass(), "obtenerDatosCreditoIntegrantes Moratorio= "
				+ ((BigDecimal) result.get("Moratorio")) + ((BigDecimal) result.get("Iva Moratorio")));

				//Double capitalVencido = result.get("Capital Vencido") != null ? Double.valueOf( result.get("Capital Vencido").toString()) : 0.0 ;
				Double capitalInsoluto = result.get("Capital Insoluto")
						!= null ? Double.valueOf( result.get("Capital Insoluto").toString()) : 0.0;
				//Double interesVencido = result.get("Interes Vencido") != null ?  Double.valueOf( result.get("Interes Vencido").toString() ) + Double.valueOf( result.get("Iva Interes Vencido").toString()) : 0.0;
				Double MontoLiquidar = result.get("Saldo para Liquidar")
						!= null ? Double.valueOf( result.get("Saldo para Liquidar").toString()) : 0.0;
				Double moratorios = result.get("Moratorio") != null ?
						Double.valueOf( result.get("Moratorio").toString() )
						+ Double.valueOf( result.get("Iva Moratorio").toString() ) : 0.0;
				Double interesSaldo =  MontoLiquidar - capitalInsoluto - moratorios;
				//Asignar los saldos a los integrantes
				for ( DatosIntegranteResumenOV datosIntegranteResumenOV : respuesta.getIntegrantes() )
					{
					if (datosIntegranteResumenOV.getMonto() != null && respuesta.getDatosCredito().getMontoCredito() != null)
						{
						//final java.lang.Double percent = datosIntegranteResumenOV.getMonto() / respuesta.getDatosCredito().getMontoCredito();
						//MIMH 2013-11-21 OPERFIN-138 Tomar el porcentaje de la tabla integrante_grupo
						final java.lang.Double percent =	datosIntegranteResumenOV.getPorcentajeParticipacion() / 100.00;
						datosIntegranteResumenOV.setMontoPagoAtrasado(
								Funciones.redondeo(respuesta.getDatosCredito().getMontoPagoAtrasado()
										!= null ? percent * respuesta.getDatosCredito().getMontoPagoAtrasado() : 0.0 ) );
						datosIntegranteResumenOV.setMontoCorriente(
								Funciones.redondeo(respuesta.getDatosCredito().getMontoCorriente()
										!= null ? percent * respuesta.getDatosCredito().getMontoCorriente() 	: 0.0) );
						datosIntegranteResumenOV.setSaldoLiquidar(
								Funciones.redondeo(respuesta.getDatosCredito().getSaldoLiquidar()
										!= null ? percent * respuesta.getDatosCredito().getSaldoLiquidar() : 0.0 ) );

						//Reestructuras
						datosIntegranteResumenOV.setSaldoCapital(Funciones.redondeo(capitalInsoluto
								!= null ? percent * capitalInsoluto : 0.0 ) );
						datosIntegranteResumenOV.setSaldoInteres(Funciones.redondeo(interesSaldo
								!= null ? percent * interesSaldo : 0.0 ) );
						datosIntegranteResumenOV.setSaldoMoratorios(Funciones.redondeo(moratorios
								!= null ? percent * moratorios : 0.0 ) );



						//se comprueba si el cliente tiene una renovacion financiada
						datosIntegranteResumenOV.setFinanciada( datosIntegranteResumenOV.getMontoLiq()
								!= null && datosIntegranteResumenOV.getMontoLiq() > 0 ? "S" : "N" );

						//Se identifica si el integrante tiene un cheque devuelto
						if ( datosIntegranteResumenOV.getFinanciada().equals( "S" ) )
							{
							//Objeto para almacenar parametros
							parametros.clear();
							parametros.put( "contrato"  , peticion.getContrato());
							parametros.put( "integrante", datosIntegranteResumenOV.getCliente() );

							LogHandler.trace(uid, getClass(), "==> obtenerDatosCreditoIntegrantes - validacionChequeDevuelto" );
							final java.util.Date fechaDev = (Date) sesion.selectOne( "validacionChequeDevuelto", parametros );
							if ( fechaDev != null )
								{
								datosIntegranteResumenOV.setFinanciada( "C" );
								}
							}
						}
					}
			} catch ( java.lang.Exception exception )
				{
				LogHandler.error(uid, getClass(), exception.getMessage(), exception );
				respuesta.getHeader().setMensaje( exception.getMessage() );
				respuesta.getHeader().setEstatus( false );
				respuesta.getHeader().setUID(uid);
				return respuesta;
				}
			finally
				{
				FabricaConexiones.close( sesion );
				}

			return respuesta;
		}


		public String consultaBuzonTareaPerfilTarea(String uid, String peticion) {

			SqlSession sesion = null;

			try	{

				sesion = FabricaConexiones.obtenerSesionNTx();

				if (peticion == null) {
					throw new Exception(ReadProperties.mensajes.getProp("consulta.buzon.tarea.perfil.peticion"));
				}

				//Se obtiene la consulta a dbo.sucursales_tipificaciones
				LogHandler.info(uid, getClass(), "==> consultaBuzonTareaPerfilTarea - obtenerBuzonTareaPerfil");
				LogHandler.trace(uid, getClass(), "==> consultaBuzonTareaPerfilTarea - obtenerBuzonTareaPerfil");
				String resConsulta = (String) sesion.selectOne("obtenerBuzonTareaPerfil", peticion );

				if (resConsulta == null) {
					throw new Exception(ReadProperties.mensajes.getProp("consulta.buzon.tarea.sinresultados"));
				}

				return resConsulta;

			} catch (java.lang.Exception exception ) {
					LogHandler.error( uid, this.getClass(), exception.getMessage(), exception);
					return null;
			}
			finally {
					FabricaConexiones.close(sesion);
			}
		}


		public EncabezadoRespuesta terminarBuzonTarea(String uid, SqlSession  sesion, TareaOV peticion) {
			EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
			respuesta.setUID(uid);
			respuesta.setEstatus(true);

			SqlSession sesionTx = null;
			boolean sesionExterna = false;

			try	{

				if (sesion == null) {
					sesionTx = FabricaConexiones.obtenerSesionTx();
				} else {
					sesionTx = sesion;
					sesionExterna = true;
				}

				if (peticion.getIdTarea() == null || peticion.getIdTarea() <= 0) {
					throw new Exception("Es necesario el id para terminar la Tarea.");
				}

				final HashMap<Object, Object> params = new HashMap<Object, Object>();
				params.put("idTarea", peticion.getIdTarea() );
				params.put("status", peticion.getStatus() != null ? peticion.getStatus() : "A" );

				LogHandler.trace(uid, getClass(), "==> terminarBuzonTarea : terminarBuzonTarea");
				Integer actualizados = sesionTx.update("terminarBuzonTarea", params);

				if ( actualizados == 0)
					throw new Exception("No se pudo dar por terminada la Tarea.");

				if (!sesionExterna)
					sesionTx.commit(true);

				respuesta.setMensaje("Se ha actualizado la tarea");

			}
			catch (java.lang.Exception exception ) {
					LogHandler.error( uid, this.getClass(), exception.getMessage(), exception);
					respuesta.setEstatus(false);
					respuesta.setMensaje( exception.getMessage() );

					if(!sesionExterna)
						FabricaConexiones.rollBack(sesionTx);
			}
			finally {
					if(!sesionExterna)
						FabricaConexiones.close(sesionTx);
			}
			return respuesta;
		}


		public RespuestaRFCOV generaRFCTarea(String uid, PeticionRFCOV peticion) {
			RespuestaRFCOV respuesta = new RespuestaRFCOV();
			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setEstatus(true);

			SqlSession sesionNTx = null;

			try	{
				
					sesionNTx = FabricaConexiones.obtenerSesionNTx();

				if (peticion.getNombre() == null || peticion.getApPaterno() == null
						|| peticion.getApMaterno() == null || peticion.getFechaNacimiento() == null) {
					throw new Exception("Los datos de la peticion son incorrectos por favor verifique");
				}

				String dbEntorno = sesionNTx.getConfiguration().getVariables().getProperty("db.entorno");
				LogHandler.info(uid, getClass(), "generaRFCTarea:	dbEntorno: " + dbEntorno);

				final HashMap<Object, Object> parametros = new HashMap<Object, Object>();
				parametros.put("dbEntorno", dbEntorno);
				parametros.put("nombre", peticion.getNombre().trim() );
				parametros.put("apPaterno", peticion.getApPaterno().trim());
				parametros.put("apMaterno", peticion.getApMaterno().trim());
				parametros.put("fechaNacimiento", peticion.getFechaNacimiento());

				LogHandler.trace(uid, getClass(), "==> generaRFCTarea : generaRFC");
				LogHandler.info(uid, getClass(), "==> generaRFCTarea : generaRFC");
				@SuppressWarnings("unchecked")
				final HashMap<Object, Object> resRFC = (HashMap<Object, Object>)
						sesionNTx.selectOne("generaRFC", parametros);

				if (resRFC == null)
					throw new Exception("No se pudo generar RFC");

				respuesta.setRfc(resRFC.get("RFC").toString().trim());

				respuesta.getHeader().setMensaje("Se ha generado correctamente el RFC");

			}
			catch (java.lang.Exception exception ) {
					LogHandler.error( uid, this.getClass(), exception.getMessage(), exception);
					respuesta.getHeader().setEstatus(false);
					respuesta.getHeader().setMensaje( exception.getMessage());
			}
			finally {
						FabricaConexiones.close(sesionNTx);
			}
			return respuesta;
		}


		public ObtenerReferenciasPagoRespuesta obtenerReferenciasPagoSeguros(ObtenerReferenciasPagoPeticion peticion, String uid) {
			ObtenerReferenciasPagoRespuesta respuesta = new ObtenerReferenciasPagoRespuesta();
			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setEstatus(true);
			respuesta.getHeader().setUID(uid);
			SqlSession sesion = null;
				try	{
					sesion = FabricaConexiones.obtenerSesionNTx();
					if (peticion == null) {
						throw new Exception(ReadProperties.mensajes.getProp("ciof.error.datos.incompletos"));
					}

					if (peticion.getNumPersona() == null || peticion.getNumPersona().trim().equals("")
						|| peticion.getNumSucursal() == null || peticion.getNumSucursal().trim().equals("")
						|| peticion.getMonto() == null)	{
						throw new Exception(ReadProperties.mensajes.getProp("ciof.error.datos.incompletos"));
					}

					if (peticion.getNumPersona().length() != 9) {
						throw new Exception("ESTE NO ES NUMERO DE PERSONA DE 9 DIGITOS");
					}

				    //se realizo cambio para 20.2
					if (peticion.getNumSucursal().length() == 5) {
						if (peticion.getNumSucursal().startsWith("12")) {
							String numSuc2 = peticion.getNumSucursal().replaceFirst("12", "");
							peticion.setNumSucursal(numSuc2);
						}
					}
					if (peticion.getNumSucursal().length() != 3) {
						throw new Exception("ESTE NO ES NUMERO DE SUCURSAL DE 3 DIGITOS");
					}


					String cadenaBanamex = ReferenciasBancarias.obtenerReferenciaBanamex(peticion);
					String cadenaBancomer = ReferenciasBancarias.obtenerReferenciaBancomer(peticion);
					String cadenaFISA = ReferenciasBancarias.obtenerReferenciaFisa(peticion);
					String cadenaDiestelVida = ReferenciasBancarias.obtenerReferenciaFisaSegurosVidaDiestel(peticion);
					String cadenaDiestelEnfermedad = ReferenciasBancarias.obtenerReferenciaFisaSegurosEnfermedadDiestel(peticion);

					//SE AGREGA CODIGO PARA REFERENCIA Bancomer
					java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();
					String verificaCadenaBancomer = ReferenciasBancarias.verificaCadenaPonderadorAlfabetico(cadenaBancomer);

					if (verificaCadenaBancomer != null) {
						parametros.put("referencia", verificaCadenaBancomer);
						LogHandler.trace(uid, getClass(), "==> consultaReferenciasPago - algoritmo21");
						final String digitoVerificador = (String) sesion.selectOne("algoritmo21", parametros);
						cadenaBancomer = cadenaBancomer + digitoVerificador;
					}
					//SE AGREGA CODIGO PARA REFERENCIA HSBC
					java.util.HashMap<String, Object> params = new java.util.HashMap<String, Object>();
					String cadenaHSBC = ReferenciasBancarias.obtenerCadenaHsbc(peticion);
					cadenaHSBC = ReferenciasBancarias.verificaCadenaPonderadorAlfabetico(cadenaHSBC);

					if (cadenaHSBC != null) {
						//Parametros de la consulta
						params.put("referencia", cadenaHSBC);
						LogHandler.trace(uid, getClass(), "==> consultaReferenciasPago - algoritmo21");
						final String digitoVerificador = (String) sesion.selectOne("algoritmo21", params);
						cadenaHSBC = cadenaHSBC + digitoVerificador;
					}

					if (cadenaDiestelVida != null) {
						//Parametros de la consulta
						params.clear();
						params.put("referencia", cadenaDiestelVida);
						LogHandler.trace(uid, getClass(), "==> consultaReferenciasPago Diestel Vida- algoritmo21");
						final String digitoVerificadorDiestelVida = (String) sesion.selectOne("algoritmo21", params);
						cadenaDiestelVida = cadenaDiestelVida + digitoVerificadorDiestelVida;
					}

					ReferenciasBancariasOV refereciasSeguroVida = new  ReferenciasBancariasOV();
					refereciasSeguroVida.setReferenciaBancomer(cadenaBancomer);
					refereciasSeguroVida.setReferenciaFISA(cadenaFISA);
					refereciasSeguroVida.setReferenciaBanamex(cadenaBanamex);
					refereciasSeguroVida.setReferenciaHSBC(cadenaHSBC);
					refereciasSeguroVida.setReferenciaDIESTEL(cadenaDiestelVida);
					respuesta.setSeguroVida(refereciasSeguroVida);

					//Se agrega referencia SeguroEnfermedad
					String cadenaBanamexSE = ReferenciasBancarias.obtenerReferenciaBanamexSegurosEnfermedad(peticion);
					String cadenaBancomerSE = ReferenciasBancarias.obtenerReferenciaBancomerSegurosEnfermedad(peticion);

					//SE AGREGA CODIGO PARA REFERENCIA Bancomer
					parametros.clear();
					String verificaCadenaBancomerSE = ReferenciasBancarias.verificaCadenaPonderadorAlfabetico(cadenaBancomerSE);
					if (verificaCadenaBancomerSE != null) {
						parametros.put("referencia", verificaCadenaBancomerSE);
						LogHandler.trace(uid, getClass(), "==> consultaReferenciasPago - algoritmo21");
						final String digitoVerificador = (String) sesion.selectOne("algoritmo21", parametros);
						cadenaBancomerSE = cadenaBancomerSE + digitoVerificador;
					}

					String cadenaFISASE = ReferenciasBancarias.obtenerReferenciaFisaSegurosEnfermedad(peticion);


					String cadenaHSBCSE = ReferenciasBancarias.obtenerCadenaHsbcSegurosEnfermedad(peticion);
					cadenaHSBCSE = ReferenciasBancarias.verificaCadenaPonderadorAlfabetico(cadenaHSBCSE);
					parametros.clear();
					if (cadenaHSBCSE != null) {
						//Parametros de la consulta
						parametros.put("referencia", cadenaHSBCSE);
						LogHandler.trace(uid, getClass(), "==> consultaReferenciasPago - algoritmo21");
						final String digitoVerificador = (String) sesion.selectOne("algoritmo21", parametros);
						cadenaHSBCSE = cadenaHSBCSE + digitoVerificador;
					}

					if (cadenaDiestelEnfermedad != null) {
						//Parametros de la consulta
						params.clear();
						params.put("referencia", cadenaDiestelEnfermedad);
						LogHandler.trace(uid, getClass(), "==> consultaReferenciasPago Diestel Enfermedad- algoritmo21");
						final String digitoVerificadorDiestelEnfermedad = (String) sesion.selectOne("algoritmo21", params);
						cadenaDiestelEnfermedad = cadenaDiestelEnfermedad + digitoVerificadorDiestelEnfermedad;
					}

					ReferenciasBancariasOV refereciasSeguroEnfermedad = new  ReferenciasBancariasOV();
					refereciasSeguroEnfermedad.setReferenciaBanamex(cadenaBanamexSE);
					refereciasSeguroEnfermedad.setReferenciaBancomer(cadenaBancomerSE);
					refereciasSeguroEnfermedad.setReferenciaFISA(cadenaFISASE);
					refereciasSeguroEnfermedad.setReferenciaHSBC(cadenaHSBCSE);
					refereciasSeguroEnfermedad.setReferenciaDIESTEL(cadenaDiestelEnfermedad);
					respuesta.setSeguroEnfermedad(refereciasSeguroEnfermedad);
				}
				catch (Exception exception)	{
				respuesta.getHeader().setMensaje(exception.getMessage());
				respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setUID(uid);
				respuesta.getHeader().setMensaje(exception.getMessage());
				LogHandler.error(uid, this.getClass(),
						"Ocurrio error al obtenerReferenciasPagoSeguros: " + exception.getMessage(), exception );
				}
				finally {
					FabricaConexiones.close(sesion);

				}

				return respuesta;
			}


		@SuppressWarnings("unchecked")
		public ConsultaDatosImagenesMonitorRespuesta consultaDatosImagenesMonitorTarea(
				String uid, ConsultaDatosImagenesMonitorPeticion consultaDatosImagenesMonitorPeticion) {

			ConsultaDatosImagenesMonitorRespuesta consultaDatosImagenesMonitorRespuesta =
					new  ConsultaDatosImagenesMonitorRespuesta();
			consultaDatosImagenesMonitorRespuesta.setHeader(new EncabezadoRespuesta());
			consultaDatosImagenesMonitorRespuesta.getHeader().setUID(uid);
			consultaDatosImagenesMonitorRespuesta.getHeader().setEstatus(true);

			SqlSession sesionNTx = null;

			List<DatosImagenesMonitorOV> imagenes = null;
			try	{

				// Se abre la sesion No transaccional sybase

				sesionNTx = FabricaConexiones.obtenerSesionNTx();
				LogHandler.trace(uid, getClass(), "consultaDatosImagenesMonitorTarea: - obtenerDatosImagenesMonitor");
				LogHandler.info(uid, getClass(), "consultaDatosImagenesMonitorTarea: - obtenerDatosImagenesMonitor");
				String dbEntorno = sesionNTx.getConfiguration().getVariables().getProperty("db.entorno");

				LogHandler.trace(uid, getClass(), "consultaDatosImagenesMonitorTarea: - obtenerParGeneral");
				ParGeneralOV horasMaximo = comun.obtenerParGeneralOV(uid, "MOIM_HORAS"); 
						//(ParGeneralOV) sesionNTx.selectOne("obtenerParGeneral", "MOIM_HORAS");

				if (horasMaximo == null || horasMaximo.getCgValor().trim().isEmpty() ) {
					throw new Exception("No se pudo obtener el valor de horas maxima.");
				}

				String horasMax = horasMaximo.getCgValor().trim();
				LogHandler.info(uid, getClass(), "consultaDatosImagenesMonitorTarea:	dbEntorno: " + dbEntorno);

				final HashMap<Object, Object> parametros = new HashMap<Object, Object>();
				parametros.put("dbEntorno", dbEntorno);
				parametros.put("horasMax", horasMax);

				imagenes = (List<DatosImagenesMonitorOV>) sesionNTx.selectList(
						"obtenerDatosImagenesMonitor", parametros);
				if (imagenes.isEmpty()) {
					throw new Exception(ReadProperties.mensajes.getProp("solicitudes.consulta.sin.resultados"));
				}
				consultaDatosImagenesMonitorRespuesta.setDatosImagenes(imagenes);

			} catch (java.lang.Exception exception) {
				consultaDatosImagenesMonitorRespuesta.getHeader().setMensaje(exception.getMessage());
				consultaDatosImagenesMonitorRespuesta.getHeader().setEstatus(false);
				consultaDatosImagenesMonitorRespuesta.getHeader().setUID(uid);
				consultaDatosImagenesMonitorRespuesta.getHeader().setMensaje(exception.getMessage());
				LogHandler.error(uid, this.getClass(),
						"Ocurrio error al obtenerDatosImagenesMonitor: " + exception.getMessage(), exception );
			}
			finally {
					FabricaConexiones.close(sesionNTx);
			}

			return consultaDatosImagenesMonitorRespuesta;
		}


		@SuppressWarnings("unchecked")
		public ConsultaDatosPromediosMonitorRespuesta consultaDatosPromediosMonitorTarea(
				String uid, ConsultaDatosPromediosMonitorPeticion consultaDatosPromediosMonitorPeticion) {

			ConsultaDatosPromediosMonitorRespuesta consultaDatosPromediosMonitorRespuesta =
					new  ConsultaDatosPromediosMonitorRespuesta();
			consultaDatosPromediosMonitorRespuesta.setHeader(new EncabezadoRespuesta());
			consultaDatosPromediosMonitorRespuesta.getHeader().setUID(uid);
			consultaDatosPromediosMonitorRespuesta.getHeader().setEstatus(true);

			SqlSession sesionNTx = null;

			List<DatosPromediosMonitorOV> promedios = null;
			try	{

				// Se abre la sesion No transaccional sybase
				sesionNTx = FabricaConexiones.obtenerSesionNTx();
				LogHandler.trace(uid, getClass(), "consultaDatosImagenesMonitorTarea: - obtenerDatosImagenesMonitor");
				LogHandler.info(uid, getClass(), "consultaDatosImagenesMonitorTarea: - obtenerDatosImagenesMonitor");
				String dbEntorno = sesionNTx.getConfiguration().getVariables().getProperty("db.entorno");
				LogHandler.info(uid, getClass(), "consultaDatosImagenesMonitorTarea:	dbEntorno: " + dbEntorno);

				LogHandler.trace(uid, getClass(), "consultaDatosImagenesMonitorTarea: - obtenerParGeneral");
				/*
				ParGeneralOV horasMaximo = comun.obtenerParGeneralOV(uid, "MOIM_HORAS");
						//(ParGeneralOV) sesionNTx.selectOne("obtenerParGeneral", "MOIM_HORAS");

				if (horasMaximo == null || horasMaximo.getCgValor().trim().isEmpty() ) {
					throw new Exception("No se pudo obtener el valor de horas maxima.");
				}

				String horasMax = horasMaximo.getCgValor().trim();
				final HashMap<Object, Object> parametros = new HashMap<Object, Object>();
				parametros.put("dbEntorno", dbEntorno);
				parametros.put("horasMax", horasMax);
				promedios = (List<DatosPromediosMonitorOV>) sesionNTx.selectList(
						"obtenerPromediosMonitorImagenes", parametros);
				if (promedios.isEmpty()) {
					throw new Exception(ReadProperties.mensajes.getProp("solicitudes.consulta.sin.resultados"));
				}
				*/
				promedios = new ArrayList<DatosPromediosMonitorOV>();
				DatosPromediosMonitorOV promedio = new DatosPromediosMonitorOV();
				promedio.setNumArchEnvDiario(" ");
				promedio.setNumArchEnvHist(" ");
				promedio.setNumArchEnvMes(" ");
				promedio.setNumArchError(" ");
				promedio.setPromedioDiario(" ");
				promedio.setPromedioMes(" ");
				promedio.setPromedioSemestral(" ");
				promedios.add(promedio);
				consultaDatosPromediosMonitorRespuesta.setDatosPromediosMonitor(promedios);

			} catch (java.lang.Exception exception ) {
				consultaDatosPromediosMonitorRespuesta.getHeader().setMensaje(exception.getMessage());
				consultaDatosPromediosMonitorRespuesta.getHeader().setEstatus(false);
				consultaDatosPromediosMonitorRespuesta.getHeader().setUID(uid);
				consultaDatosPromediosMonitorRespuesta.getHeader().setMensaje(exception.getMessage());
				LogHandler.error(uid, this.getClass(),
						"Ocurrio error al obtenerPromediosMonitorImagenes: " + exception.getMessage(), exception );
			}
			finally {
					FabricaConexiones.close(sesionNTx);
			}

			return consultaDatosPromediosMonitorRespuesta;
		}


		public ValidarRelacionPersonaContratoRespuesta validaRelacionPersonaContratoTarea(
				String uid,
				ValidarRelacionPersonaContratoPeticion peticion) {

			ValidarRelacionPersonaContratoRespuesta validarRelacionPersonaContratoRespuesta =
					new  ValidarRelacionPersonaContratoRespuesta();
			validarRelacionPersonaContratoRespuesta.setHeader(new EncabezadoRespuesta());
			validarRelacionPersonaContratoRespuesta.getHeader().setUID(uid);
			validarRelacionPersonaContratoRespuesta.getHeader().setEstatus(true);

			SqlSession sesionNTx = null;

			try	{

				// Se abre la sesion No transaccional sybase

				sesionNTx = FabricaConexiones.obtenerSesionNTx();
				LogHandler.trace(uid, getClass(), "validarRelacionPersonaContratoTarea: - validarRelacionPersonaContrato");
				LogHandler.info(uid, getClass(), "cvalidarRelacionPersonaContratoTarea: - validarRelacionPersonaContrato");

				final HashMap<Object, Object> parametros = new HashMap<Object, Object>();
				parametros.put("persona", peticion.getPersona());
				parametros.put("contrato", comun.obtenerNumeroContrato(uid, peticion.getContrato()));

				final Integer resultado = (Integer) sesionNTx.selectOne("validarRelacionPersonaContrato", parametros);

				if (resultado > 0) {
					validarRelacionPersonaContratoRespuesta.getHeader().setEstatus(true);
					validarRelacionPersonaContratoRespuesta.getHeader().setUID(uid);
					validarRelacionPersonaContratoRespuesta.getHeader().setMensaje("Existe");
				} else {
					validarRelacionPersonaContratoRespuesta.getHeader().setEstatus(false);
					validarRelacionPersonaContratoRespuesta.getHeader().setUID("0");
					validarRelacionPersonaContratoRespuesta.getHeader().setMensaje(" ");
				}

			} catch (java.lang.Exception exception) {
				validarRelacionPersonaContratoRespuesta.getHeader().setMensaje(exception.getMessage());
				validarRelacionPersonaContratoRespuesta.getHeader().setEstatus(false);
				validarRelacionPersonaContratoRespuesta.getHeader().setUID(uid);
				validarRelacionPersonaContratoRespuesta.getHeader().setMensaje(exception.getMessage());
				LogHandler.error(uid, this.getClass(),
						"Ocurrio error al validarRelacionPersonaContrato: " + exception.getMessage(), exception );
			}
			finally {
					FabricaConexiones.close(sesionNTx);
			}

			return validarRelacionPersonaContratoRespuesta;
		}

		/**
		 * Regresa el valor del importe en letra
		 * @param importe String
		 * @return String
		 */
		public String getMontoLetras(String importe) {
			//Para el formato de los decimales extras necesitamos 2 ceros
			final java.text.DecimalFormat
							decimalFormat = new DecimalFormat("00");
			final Numero2Letra numLetra = new Numero2Letra();
			return numLetra.Convertir(importe.split("[.]")[0], true)
					+ "PESOS "
					+ decimalFormat.format( Double.parseDouble( importe.split("[.]")[1] ) )
					+ "/100 MN";
		}


		/**
		 * Obtener saldos financiados integrantes tarea, se clona metodo de
		 * consulta para obtener saldos al momento de cambio de fecha desembolso.
		 *
		 * @param uid the uid
		 * @param peticion the peticion
		 * @return the datos credito integrantes respuesta
		 */
		@SuppressWarnings("unchecked")
		public DatosCreditoIntegrantesRespuesta obtenerSaldosFinanciadosIntegrantesTarea(String uid,
						ConsultaCreditoPeticion peticion) {
			DatosCreditoIntegrantesRespuesta respuesta = new DatosCreditoIntegrantesRespuesta();
			respuesta.setHeader(new EncabezadoRespuesta());

			DatosCreditoOV datosCredito = null;
			SqlSession sesion = null;

			try {
				if (peticion.getContrato() == null)
					{
					throw new Exception(ReadProperties.mensajes.getProp("ciof.contratoinvalido"));
					}

				peticion.setContrato(comun.obtenerNumeroContrato(uid, peticion.getContrato()));

				if (peticion.getContrato() == null)
					{
					throw new Exception(ReadProperties.mensajes.getProp("ciof.contratoinvalido"));
					}

				if (peticion.getFechaDesembolso() == null || peticion.getFechaDesembolso().trim().equals("")) {
					throw new Exception("La peticion no contiene la fecha de desembolso");
				}

				//Se realiza la validacion para la relacion de sucursal-contrato
				final java.util.HashMap<String, Object>
										parametros = new java.util.HashMap<String, Object>();
										parametros.put("contrato" , peticion.getContrato() );
										parametros.put( "sucursal", peticion.getSucursal() 	 );

				//si se manda cierta sucursal, se comprueba q deba ser validada o se checa si esta excenta
				if (peticion.getContrato() != null && peticion.getSucursal() != null && peticion.getSucursal() != 0
						&& peticion.getSucursal() != 120 ) {
					if ( !comun.comprobarContratoSucursal( uid, parametros ) ) {
						throw new Exception( ReadProperties.mensajes.getProp(
								"reportes.obtenerestadocuenta.errorcontratosucursal"));
					}
				}

				//Se recuperan los datos del contrato
				final DatosCreditoRespuesta consutaCredito = obtenerDatosCredito(uid, peticion);
				if (consutaCredito != null && consutaCredito.getHeader().isEstatus() && consutaCredito.getDatosCredito() != null)
					{
					 datosCredito = consutaCredito.getDatosCredito();
					 respuesta.setDatosCredito(datosCredito);
					}
				else
				 	{
					 throw new Exception(ReadProperties.mensajes.getProp("consultas.consultasaldocredito.errorregistrosvacios"));
				 	}

				sesion = FabricaConexiones.obtenerSesionNTx();

				//Se hace la validación del ambiente de trabajo para p_independencia
				String dbEntorno = sesion.getConfiguration().getVariables().getProperty("db.entorno");
				LogHandler.info(uid, getClass(), "obtenerDatosCreditoIntegrantes:	dbEntorno: " + dbEntorno);
				final HashMap<Object, Object> paramObtenerDatosInte = new HashMap<Object, Object>();
				paramObtenerDatosInte.put("dbEntorno", dbEntorno);
				paramObtenerDatosInte.put("contrato", peticion.getContrato());

				LogHandler.trace(uid, getClass(), "==> obtenerDatosCreditoIntegrantes - obtenerDatosIntegrante");
				List<DatosIntegranteResumenOV> integrantes
					= (List<DatosIntegranteResumenOV>) sesion.selectList("obtenerDatosIntegrante", paramObtenerDatosInte);
				respuesta.setIntegrantes(integrantes.toArray(new DatosIntegranteResumenOV[integrantes.size()]));

				SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
				Date fechaDesembolso = sdf1.parse(peticion.getFechaDesembolso());

				//Reestructuras
				final HashMap<Object, Object> params = new HashMap<Object, Object>();
				params.put("contrato", peticion.getContrato() );

				LogHandler.info(uid, getClass(), "obtenerDatosCreditoIntegrantes fecha Desembolso= "
						+ formatter.format(fechaDesembolso));

				params.put("fechaActual", formatter.format(fechaDesembolso) );
				LogHandler.trace(uid, this.getClass(), "==> obtenerDatosCreditoIntegrantes - obtenerSaldoV");
				final HashMap<Object, Object> result = (HashMap<Object, Object>) sesion.selectOne("obtenerSaldoV", params);

				LogHandler.info(uid, getClass(), "obtenerDatosCreditoIntegrantes Saldo para Liquidar= "
						+ ((BigDecimal) result.get("Saldo para Liquidar")));

				LogHandler.debug(uid, getClass(), "obtenerDatosCreditoIntegrantes interes= "
						+ ((BigDecimal) result.get("Interes Vencido")) + ((BigDecimal) result.get("Iva Interes Vencido")) );
				LogHandler.debug(uid, getClass(), "obtenerDatosCreditoIntegrantes capital vencido= "
						+ ((BigDecimal) result.get("Capital Vencido")));
				LogHandler.debug(uid, getClass(), "obtenerDatosCreditoIntegrantes capital= "
						+ ((BigDecimal) result.get("Capital Insoluto")));
				LogHandler.debug(uid, getClass(), "obtenerDatosCreditoIntegrantes Moratorio= "
						+ ((BigDecimal) result.get("Moratorio")) + ((BigDecimal) result.get("Iva Moratorio")));

				//Double capitalVencido = result.get("Capital Vencido") != null
					//? Double.valueOf( result.get("Capital Vencido").toString()) : 0.0 ;
				Double capitalInsoluto = result.get("Capital Insoluto") != null
						? Double.valueOf( result.get("Capital Insoluto").toString()) : 0.0;
				//Double interesVencido = result.get("Interes Vencido") != null
						//? Double.valueOf( result.get("Interes Vencido").toString() )
						//+ Double.valueOf( result.get("Iva Interes Vencido").toString()) : 0.0;
				Double montoLiquidar = result.get("Saldo para Liquidar") != null
						? Double.valueOf( result.get("Saldo para Liquidar").toString()) : 0.0;
				Double moratorios = result.get("Moratorio") != null ?  Double.valueOf( result.get("Moratorio").toString() )
						+ Double.valueOf( result.get("Iva Moratorio").toString() ) : 0.0;
				Double interesSaldo =  montoLiquidar - capitalInsoluto - moratorios;
				//Asignar los saldos a los integrantes

				LogHandler.info(uid, getClass(), "obtenerDatosCreditoIntegrantes Saldo para Liquidar= "
						+ respuesta.getDatosCredito().getSaldoLiquidar());

				BigDecimal saldoLiquidar = (BigDecimal) result.get("Saldo para Liquidar");

				respuesta.getDatosCredito().setSaldoLiquidar(saldoLiquidar.doubleValue());

				for ( DatosIntegranteResumenOV datosIntegranteResumenOV : respuesta.getIntegrantes() ) {

					if ( datosIntegranteResumenOV.getMonto() != null && respuesta.getDatosCredito().getMontoCredito() != null ) {

						//final java.lang.Double percent = datosIntegranteResumenOV.getMonto() /
						//respuesta.getDatosCredito().getMontoCredito();
						//MIMH 2013-11-21 OPERFIN-138 Tomar el porcentaje de la tabla integrante_grupo
						final java.lang.Double percent =	datosIntegranteResumenOV.getPorcentajeParticipacion() / 100.00;
						datosIntegranteResumenOV.setMontoPagoAtrasado(Funciones.redondeo(
								respuesta.getDatosCredito().getMontoPagoAtrasado()
								!= null ? percent * respuesta.getDatosCredito().getMontoPagoAtrasado() : 0.0 ) );
						datosIntegranteResumenOV.setMontoCorriente(Funciones.redondeo(
								respuesta.getDatosCredito().getMontoCorriente()
								!= null ? percent * respuesta.getDatosCredito().getMontoCorriente() 	: 0.0) );
						datosIntegranteResumenOV.setSaldoLiquidar(Funciones.redondeo(
								respuesta.getDatosCredito().getSaldoLiquidar()
								!= null ? percent * respuesta.getDatosCredito().getSaldoLiquidar() : 0.0 ) );

						//Reestructuras
						datosIntegranteResumenOV.setSaldoCapital(Funciones.redondeo(capitalInsoluto != null
								? percent * capitalInsoluto : 0.0 ) );
						datosIntegranteResumenOV.setSaldoInteres(Funciones.redondeo(interesSaldo != null
								? percent * interesSaldo : 0.0 ) );
						datosIntegranteResumenOV.setSaldoMoratorios(Funciones.redondeo(moratorios != null
								? percent * moratorios : 0.0 ) );

						//se comprueba si el cliente tiene una renovacion financiada
						datosIntegranteResumenOV.setFinanciada( datosIntegranteResumenOV.getMontoLiq()
								!= null && datosIntegranteResumenOV.getMontoLiq() > 0 ? "S" : "N" );

						//Se identifica si el integrante tiene un cheque devuelto
						if ( datosIntegranteResumenOV.getFinanciada().equals( "S" ) )
							{
							//Objeto para almacenar parametros
							parametros.clear();
							parametros.put( "contrato"  , peticion.getContrato());
							parametros.put( "integrante", datosIntegranteResumenOV.getCliente() );

							LogHandler.trace(uid, getClass(), "==> obtenerDatosCreditoIntegrantes - validacionChequeDevuelto" );
							final java.util.Date fechaDev = (Date) sesion.selectOne( "validacionChequeDevuelto", parametros );
							if ( fechaDev != null )
								{
								datosIntegranteResumenOV.setFinanciada( "C" );
								}
							}
						}
					}


			} catch ( java.lang.Exception exception )
				{
				LogHandler.error(uid, getClass(), exception.getMessage(), exception );
				respuesta.getHeader().setMensaje( exception.getMessage() );
				respuesta.getHeader().setEstatus( false );
				respuesta.getHeader().setUID(uid);
				return respuesta;
				}
			finally
				{
				FabricaConexiones.close( sesion );
				}

			return respuesta;
		}

		public ConsultaCATRespuesta calcularCATContrato(String uid, String contrato ) {

			LogHandler.info(uid, getClass(), "==> calcularCATContrato - " + contrato );
			ContratoOV contratoOV = new ContratoOV();
			SqlSession sesion = null;
			ConsultaCATRespuesta respuesta = null;


			final List<Double>
					pagosPeriodo = new ArrayList<Double>();

			Double ivaD = 16.0;

			try {

				sesion = FabricaConexiones.obtenerSesionNTx();

				@SuppressWarnings("unchecked")
				final List<AmortizacionOV>
						pagosAmortizacion = (List<AmortizacionOV>) sesion.selectList("obtenerAmortizacionGrupal", contrato );


				for ( AmortizacionOV amortizacionOV : pagosAmortizacion )
					{
					final java.lang.Double  montoSinIva = amortizacionOV.getAbonoCapital() + ( amortizacionOV.getInteresPeriodo() / ( 1.0 + ivaD / 100.0 )) ;
					pagosPeriodo.add( montoSinIva );
					}

				contratoOV = (ContratoOV) sesion.selectOne("obtenerDatosContratoCAT", contrato );

				final ConsultaCATPeticion consultaCATPeticion = new ConsultaCATPeticion();
				consultaCATPeticion.setMontoCredito( contratoOV.getMonto_otorgado( ) );
				consultaCATPeticion.setPagos( pagosPeriodo );
				consultaCATPeticion.setPeriodo( contratoOV.getFrecuencia( ).trim().startsWith( "S" ) ? 52 :
					contratoOV.getFrecuencia( ).trim().startsWith( "C" ) ? 26 : 12 );
				consultaCATPeticion.setPlazo( pagosPeriodo.size() );

				LogHandler.info(uid, getClass(), "Objeto que se envia a calcular el CAT : " + consultaCATPeticion );

				 respuesta = consultarCAT( consultaCATPeticion, uid );
				}
				catch ( java.lang.Exception exception )
				{
				LogHandler.error( uid, getClass(),
						ReadProperties.mensajes.getProp( "originacion.registrarcredito.errorcat" ) + contrato, exception );
				}
			    finally {
			    	FabricaConexiones.close(sesion);
			    }
			return respuesta;
		}

		/**
		 * Esta operaci&oacute;n permite obtener la informaci&oacute;n del cliente
		 * a trav&eacute;s del ID que lo identifica que en este caso es el contrato.
		 * @param uid identificador &uacute;nico de transacci&oacute;n.
		 * @param peticion datos de la consulta
		 * @return RespuestaConsultaEnLineaOxxo respuesta de la consulta.
		 */
		public RespuestaConsultaEnLineaOxxo consultaEnLineaOxxoTarea(String uid, PeticionEnLineaOxxo peticion) {

			RespuestaConsultaEnLineaOxxo respuesta = new RespuestaConsultaEnLineaOxxo();
			LogHandler.info(uid, getClass(), "consultaEnLineaOxxoTarea - Datos de entrada :" + peticion);

			SqlSession sesionNTx = null;
	        SqlSession sesionTx = null;
	        Date fechaValor = null;

	        try {
	        	// Se abre la sesion transaccional sybase
	        	sesionTx = FabricaConexiones.obtenerSesionTx();

	        	//Validar si existe el contrato
				String numeroContrato = comun.obtenerNumeroContrato(uid, peticion.getAccount());

				//Validaciones
				if (numeroContrato == null || numeroContrato.isEmpty()) {
					LogHandler.debug(uid, getClass(), "ERROR: Contrato Inexistente: " + peticion.getAccount());
					respuesta.setCode(CatalogoDeEstados.CODIGO_02.getCodigo());
					respuesta.setMessage(CatalogoDeEstados.CODIGO_02.getTitulo());
					throw new Exception(CatalogoDeEstados.CODIGO_02.getTitulo());
				}

				FechaContableOV datosFechaContable = comun.obtenerFechaContable(uid);

				Date fechaCont = datosFechaContable.getFecha();
							Calendar cal = new GregorianCalendar();
							cal.setTimeInMillis(fechaCont.getTime());
				fechaValor = cal.getTime();

	        	HashMap<String, Object> params = new HashMap<String, Object>();
	        	params.put("contrato", numeroContrato);
				params.put("fechaActual", fechaValor);

				LogHandler.debug(uid, getClass(), " fechaActual: " + fechaValor );
				LogHandler.debug(uid, getClass(), " numeroContrato: " + numeroContrato);

				//obtener saldo a la fecha valor
				LogHandler.trace(uid, getClass(), "==> aplicarGarantiaLiquidacion - obtenerSaldoFv");
				CreditoSaldo creditoSaldo  = (CreditoSaldo) sesionTx.selectOne("obtenerSaldoFv", params);

				List<Concept> detalleConsultaOVList = new ArrayList<Concept>();
				Concept conceptoParcialidad = new Concept();
				Concept conceptoSaldoLiquidar = new Concept();
				Concept conceptoFechaCorte = new Concept();

				if (creditoSaldo.getMontoCorriente() == 0 && creditoSaldo.getInsoluto() < 0
						&&  creditoSaldo.getEstatus().equals("P")) {
					Concept conceptoSubtotal = new Concept();
					conceptoSubtotal.setDescription("total");
					conceptoSubtotal.setAmount("0.00");
					conceptoSubtotal.setOperation("+");

					conceptoSaldoLiquidar.setDescription("monto total a pagar");
					conceptoSaldoLiquidar.setAmount("0.00");
					conceptoSaldoLiquidar.setOperation("+");
					detalleConsultaOVList.add(conceptoSaldoLiquidar);

					respuesta.setCode(CatalogoDeEstados.CODIGO_10.getCodigo());
					respuesta.setMessage(CatalogoDeEstados.CODIGO_10.getTitulo());
					detalleConsultaOVList.add(conceptoSubtotal);

					Concept conceptoSaldoFavor = new Concept();
					conceptoSaldoFavor.setDescription("saldo a favor");
					conceptoSaldoFavor.setAmount(creditoSaldo.getInsoluto().toString());
					conceptoSaldoFavor.setOperation("-");
					detalleConsultaOVList.add(conceptoSaldoFavor);

					conceptoParcialidad.setDescription("numero de parcialidades de pago: "
							+ creditoSaldo.getPlazo());
					conceptoParcialidad.setAmount(creditoSaldo.getNumPagoActual());
					conceptoParcialidad.setOperation("t");
					detalleConsultaOVList.add(conceptoParcialidad);

					conceptoFechaCorte.setDescription("fecha limite de pago: ");
					conceptoFechaCorte.setAmount("000");
					conceptoFechaCorte.setOperation("max");
					detalleConsultaOVList.add(conceptoFechaCorte);
				}
				else if (creditoSaldo.getMontoCorriente() == 0) {
					Concept conceptoTotal = new Concept();
					conceptoTotal.setDescription("total");
					conceptoTotal.setAmount("0.00");
					conceptoTotal.setOperation("+");
					detalleConsultaOVList.add(conceptoTotal);

					conceptoSaldoLiquidar.setDescription("monto total a pagar");
					conceptoSaldoLiquidar.setAmount("0.00");
					conceptoSaldoLiquidar.setOperation("+");
					detalleConsultaOVList.add(conceptoSaldoLiquidar);

					LogHandler.debug(uid, getClass(), "ERROR: Codigo de error 10: " + peticion.getAccount());
					respuesta.setCode(CatalogoDeEstados.CODIGO_10.getCodigo());
					respuesta.setMessage(CatalogoDeEstados.CODIGO_10.getTitulo());

					conceptoParcialidad.setDescription("numero de parcialidades de pago: "
							+ creditoSaldo.getPlazo());
					conceptoParcialidad.setAmount(creditoSaldo.getNumPagoActual());
					conceptoParcialidad.setOperation("t");
					detalleConsultaOVList.add(conceptoParcialidad);

					conceptoFechaCorte.setDescription("fecha limite de pago: ");
					conceptoFechaCorte.setAmount("000");
					conceptoFechaCorte.setOperation("max");
					detalleConsultaOVList.add(conceptoFechaCorte);
				}
				else if (creditoSaldo.getMontoPagoAtrasado() > 0) {
					Concept conceptoTotal = new Concept();
					conceptoTotal.setDescription("total");
					conceptoTotal.setAmount(creditoSaldo.getMontoCorriente().toString());
					conceptoTotal.setOperation("+");
					detalleConsultaOVList.add(conceptoTotal);

					conceptoSaldoLiquidar.setDescription("monto total a pagar");
					conceptoSaldoLiquidar.setAmount(creditoSaldo.getSaldoLiquidar().toString());
					conceptoSaldoLiquidar.setOperation("+");
					detalleConsultaOVList.add(conceptoSaldoLiquidar);

					LogHandler.debug(uid, getClass(), "ERROR: Codigo de error 00: " + peticion.getAccount());
					respuesta.setCode(CatalogoDeEstados.CODIGO_00.getCodigo());
					respuesta.setMessage(CatalogoDeEstados.CODIGO_00.getTitulo());

					conceptoParcialidad.setDescription("numero de parcialidades de pago: "
							+ creditoSaldo.getPlazo());
					conceptoParcialidad.setAmount(creditoSaldo.getNumPagoActual());
					conceptoParcialidad.setOperation("t");
					detalleConsultaOVList.add(conceptoParcialidad);

					conceptoFechaCorte.setDescription("fecha limite de pago: " + creditoSaldo.getFechaProximoPago());
					conceptoFechaCorte.setAmount("000");
					conceptoFechaCorte.setOperation("max");
					detalleConsultaOVList.add(conceptoFechaCorte);
				}
				else if (creditoSaldo.getMontoCorriente() != 0 && creditoSaldo.getInsoluto() > 0 ) {
					Concept conceptoSubtotals = new Concept();
					conceptoSubtotals.setDescription("total");
					conceptoSubtotals.setAmount(creditoSaldo.getMontoCorriente().toString());
					conceptoSubtotals.setOperation("+");
					respuesta.setCode(CatalogoDeEstados.CODIGO_00.getCodigo());
					respuesta.setMessage(CatalogoDeEstados.CODIGO_00.getTitulo());
					detalleConsultaOVList.add(conceptoSubtotals);

					conceptoSaldoLiquidar.setDescription("monto total a pagar");
					conceptoSaldoLiquidar.setAmount(creditoSaldo.getSaldoLiquidar().toString());
					conceptoSaldoLiquidar.setOperation("+");
					detalleConsultaOVList.add(conceptoSaldoLiquidar);

					conceptoParcialidad.setDescription("numero de parcialidades de pago: "
							+ creditoSaldo.getPlazo());
					conceptoParcialidad.setAmount(creditoSaldo.getNumPagoActual());
					conceptoParcialidad.setOperation("t");
					detalleConsultaOVList.add(conceptoParcialidad);

					conceptoFechaCorte.setDescription("fecha limite de pago: " + creditoSaldo.getFechaProximoPago());
					conceptoFechaCorte.setAmount("000");
					conceptoFechaCorte.setOperation("max");
					detalleConsultaOVList.add(conceptoFechaCorte);
				}
				else {
					Concept conceptoSaldoFavor = new Concept();
					conceptoSaldoFavor.setDescription("saldo a favor");
					conceptoSaldoFavor.setAmount(creditoSaldo.getMontoCorriente().toString());
					conceptoSaldoFavor.setOperation("-");
					detalleConsultaOVList.add(conceptoSaldoFavor);
					LogHandler.debug(uid, getClass(), "ERROR: Codigo de error 0: " + peticion.getAccount());
					respuesta.setCode(CatalogoDeEstados.CODIGO_00.getCodigo());
					respuesta.setMessage(CatalogoDeEstados.CODIGO_00.getTitulo());

					conceptoSaldoLiquidar.setDescription("monto total a pagar");
					conceptoSaldoLiquidar.setAmount(creditoSaldo.getSaldoLiquidar().toString());
					conceptoSaldoLiquidar.setOperation("+");
					detalleConsultaOVList.add(conceptoSaldoLiquidar);

					conceptoParcialidad.setDescription("numero de parcialidades de pago: "
							+ creditoSaldo.getPlazo());
					conceptoParcialidad.setAmount(creditoSaldo.getNumPagoActual());
					conceptoParcialidad.setOperation("t");
					detalleConsultaOVList.add(conceptoParcialidad);

					conceptoFechaCorte.setDescription("fecha limite de pago: " + creditoSaldo.getFechaProximoPago());
					conceptoFechaCorte.setAmount("000");
					conceptoFechaCorte.setOperation("max");
					detalleConsultaOVList.add(conceptoFechaCorte);
				}

				String nombre = creditoSaldo.getNombre();
				nombre = Normalizer.normalize(nombre, Normalizer.Form.NFD);
				nombre = nombre.replaceAll("[^\\p{ASCII}]", "");
				nombre = nombre.replace("Ñ", "N");
				nombre = nombre.replace("ñ", "n");

				respuesta.setAccount(numeroContrato);
				respuesta.setName(nombre);
				respuesta.setPartial("P");
				respuesta.setConcepts(detalleConsultaOVList);
	        }
	        catch ( java.lang.Exception ex) {
	        	FabricaConexiones.rollBack(sesionTx);
				LogHandler.error(uid, this.getClass(), " ERROR: Error al momento de consulta la información ROLLBACK: "
						+ ex.getMessage(), ex );

				if (respuesta.getCode() == null || respuesta.getMessage() == null) {
					respuesta.setCode(CatalogoDeEstados.CODIGO_12.getCodigo());
					respuesta.setMessage(CatalogoDeEstados.CODIGO_12.getTitulo());
				}
	        }
	        finally {
	            FabricaConexiones.close(sesionNTx);
	            FabricaConexiones.close(sesionTx);
	        }

			return respuesta;
		}

		/**
		 * @param uid String
		 * @param peticion ConsultaBuzonPeticion
		 * @return BuzonOV
		 */
		@SuppressWarnings("unchecked")
		public BuzonOV consultaBuzonAnalistaDocumental(String uid, ConsultaBuzonPeticion peticion) {
			BuzonOV respuesta = new BuzonOV();
			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setEstatus(true);
			respuesta.getHeader().setUID(uid);
			SqlSession sesion = null;
			try {
				//Se abre la conexion a la base Ntx
				sesion = FabricaConexiones.obtenerSesionNTx();

				if (peticion == null) {
					throw new Exception(ReadProperties.mensajes.getProp("asignacion.buzon.peticion.incorrecta"));
				}

				if (peticion.getSucursal() == null || peticion.getSucursal() == 120 || peticion.getSucursal() == 12000 ) {
					peticion.setSucursal(0);
				}
				List<TareaOV> buzon = new ArrayList<TareaOV>();

				if ( peticion.getUsuarioPropietario() != null ) {
					if ( peticion.getUsuarioPropietario().trim().isEmpty()) {
						peticion.setUsuarioPropietario(null);
					}
				}
				final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
				parametros.put("perfil", peticion.getPerfil());
				parametros.put("sucursal", peticion.getSucursal());
				parametros.put("tipo_tarea", peticion.getTipoTarea());

				parametros.put("status", peticion.getStatus());
				parametros.put("usuario_propietario", peticion.getUsuarioPropietario());
				LogHandler.trace(uid, getClass(), "==> consultaBuzonAnalistaDocumental : obtenerBuzonTareasAnalistaDocumental");
				buzon = (List<TareaOV>) sesion.selectList("obtenerBuzonTareasAnalistaDocumental", parametros);


				if (buzon.size() == 0) {
					throw new Exception("No existen tareas en el buzon.");
				}

				//limpieza de datos
				for (int i = 0; i < buzon.size(); i++) {
					buzon.get(i).setFechaAsignacion( buzon.get(i).getFechaAsignacion() == null
							  ? " " : buzon.get(i).getFechaAsignacion());
					buzon.get(i).setFechaTermino( buzon.get(i).getFechaTermino() == null
							  ? " " : buzon.get(i).getFechaTermino());
					buzon.get(i).setNombreRegion( buzon.get(i).getNombreRegion() == null
							 ? " " : buzon.get(i).getNombreRegion().trim() );
					buzon.get(i).setNombreSucursal( buzon.get(i).getNombreSucursal() == null
							 ? " " : buzon.get(i).getNombreSucursal().trim() );
					buzon.get(i).setEstatusSolicitud(buzon.get(i).getEstatusSolicitud() == null
							 ? " " : buzon.get(i).getEstatusSolicitud());
					buzon.get(i).setEstatus( buzon.get(i).getEstatus() == null
							 ? " " : buzon.get(i).getEstatus());
					buzon.get(i).setDescripcion( buzon.get(i).getDescripcion() == null
							 ? " " : buzon.get(i).getDescripcion());
					buzon.get(i).setCodigoResolucion( buzon.get(i).getCodigoResolucion() == null
							 ? " " : buzon.get(i).getCodigoResolucion());
					buzon.get(i).setCiclo( buzon.get(i).getCiclo() == null
							 ? 0 : buzon.get(i).getCiclo());
					buzon.get(i).setCategoria( buzon.get(i).getCategoria() == null
							 ? " " : buzon.get(i).getCategoria());
					buzon.get(i).setExpress( buzon.get(i).getExpress() == null
							 ? " " : buzon.get(i).getExpress());
					buzon.get(i).setCampana( buzon.get(i).getCampana() == null
							 ? " " : buzon.get(i).getCampana());
					buzon.get(i).setNombreGrupo( buzon.get(i).getNombreGrupo() == null
							 ? " " : buzon.get(i).getNombreGrupo());

				}


				List<Integer> listaId = new ArrayList<Integer>();

				for (int i = 0; i < buzon.size(); i++) {
					//Quitamos tareas del buzon que tiene la sucursal
					//LogHandler.info(uid, getClass(), "==> ***************" + buzon.get(i).getEstatus().trim());
					if (peticion.getPerfil().trim().equals("PDOC")
						&& buzon.get(i).getEstatus().trim().equals("OBSERVACIONES_CEC")) {
						listaId.add(buzon.get(i).getIdTarea());
						//buzon.remove(i);
					}
				}

				List<TareaOV> buzon2 = new ArrayList<TareaOV>();
				for (TareaOV tarea : buzon) {
					boolean quitar = false;
					for ( Integer inte : listaId) {
						if ( tarea.getIdTarea().intValue() == inte.intValue() ) {
							quitar = true;
							//LogHandler.info(uid, getClass(), "==> ******QUITAR*********" + tarea.getIdTarea().intValue());
						}
					}

					if (!quitar) {
						buzon2.add(tarea);
					}
				}


				//LogHandler.info(uid, getClass(), "==> ***************" + buzon2.size());
				//Tipificacion productos
				for (int i = 0; i < buzon2.size(); i++) {
					if (buzon2.get(i).getTipoTarea().trim().equals("TRED")) {
						buzon2.get(i).setTipificacionProducto(
								FuncionesComunes.tipificacionProductos(
										buzon2.get(i).getCodigoProducto() == null ? "" : buzon2.get(i).getCodigoProducto(),
												buzon2.get(i).getCategoria().trim().equals("FIN") ? true : false,
														buzon2.get(i).getExpress().trim().equals("S") ? true : false
								));
					} else {
						buzon2.get(i).setTipificacionProducto("");
					}
				}

				respuesta.setBuzon(buzon2);

			} catch ( java.lang.Exception exception ) {
				respuesta.getHeader().setUID(uid);
				respuesta.getHeader().setMensaje(exception.getMessage());
				respuesta.getHeader().setEstatus( false );
				LogHandler.error( uid, this.getClass(), "Error en consultaBuzonAnalistaDocumental : "
						+ exception.getMessage(), exception );
			}
			finally {
				FabricaConexiones.close(sesion);

			}
			return respuesta;
		}

		public ConsultaCatalogoRespuestaCIOF consultaCatalogoAnalistas(
				String uid, String peticion) {
			LogHandler.info( uid, this.getClass(), "consultaCatalogo: entrando al metodo consultaCatalogoAnalistas");
			ConsultaCatalogoRespuestaCIOF respuesta = new ConsultaCatalogoRespuestaCIOF();
			respuesta.setHeader(new EncabezadoRespuesta());
			SqlSession sesionNTx = null;
			List<CatalogosOV> regionesList = null;
			HashMap<String, Object> params = null;

			try {
				sesionNTx = FabricaConexiones.obtenerSesionNTx();
				params = new HashMap<String, Object>();
	        	params.put("codigo", peticion);
				//params.put("perfil", perfil);
				regionesList = (List<CatalogosOV>) sesionNTx.selectList("obtenCatalogoAnalistas", params);
				if (regionesList == null || regionesList.size() <= 0) {
					throw new Exception("Lista de Regiones null o vacia.");
				}
				respuesta.setCatalogo(regionesList);
				respuesta.getHeader().setEstatus(true);
				respuesta.getHeader().setMensaje("Respuesta Exitosa");

			} catch (Exception ex )	{
				respuesta.getHeader().setMensaje("Ocurrio un error al obtener el catalogo de Analistas " + ex.getMessage() );
				respuesta.getHeader().setEstatus( false );
				respuesta.getHeader().setUID(uid);
				LogHandler.error( uid, this.getClass(),
						"Ocurrio un error al obtener el catalogo de Analistas " + ex.getMessage(), ex);
			}
			finally {
				FabricaConexiones.close(sesionNTx);
			}
			return respuesta;
		}

		/**
		 * Metodo que permite obtener la consulta del reporte de Asistencia para el CEC
		 *
		 * @param uid Identificador Unico de Transaccion
		 * @param fechaPeticion fecha de la peticion de la consulta
		 * @return ReporteAsistencias respuesta de la consulta.
		 */
		public ReporteAsistencias consultaReporteAsistenciaTarea(String uid, String fechaPeticion) {

			ReporteAsistencias respuesta = new ReporteAsistencias();
			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setEstatus(true);

			LogHandler.info(uid, getClass(), "consultaReporteAsistenciaTarea -" );
			SqlSession sessionNTx = null;

	        try {
	        	//Se abre la conexion hacia la base de datos
				sessionNTx  = FabricaConexiones.obtenerSesionNTx();

				final List<AnalistasCEC> personas =
						(List<AnalistasCEC>) sessionNTx.selectList("consultaReporteAsistencia", fechaPeticion);

	        	if (personas.size() == 0) {
					throw new Exception("No se obtuvieron resultado de los analistas del CEC");
				} else {

					//Se convierte la cadena fechaPeticion a tipo de dato date
					SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
			        Date fechaDate = null;
			        try {
			            fechaDate = formato.parse(fechaPeticion);
			        } catch (Exception ex) {
			        	throw new Exception("Surgio un error al momento de transformar la fecha");
			        }

			        TimeZone zona = TimeZone.getTimeZone("America/Mexico_City");
			        Calendar calendar = Calendar.getInstance();
			        calendar.setTimeZone(zona);
			        calendar.setTime(fechaDate);

			        //Fecha peticion desglosada:
			        int anio = calendar.get(Calendar.YEAR);
			        int mes = calendar.get(Calendar.MONTH) + 1;
			        int totalDias = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

			        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			        Calendar fecha = Calendar.getInstance();
			        final int mesNumero = 10;
			        String fechaCadena = "";
			        if (mes < mesNumero) {
			        	fechaCadena = "01-0" + mes + "-" + anio;
			        } else {
			        	fechaCadena = "01-" + mes + "-" + anio;
			        }

			        fecha.setTime(sdf.parse(fechaCadena));
			        String diaSemanaInicio = "";
			        int diaInicio = fecha.get(Calendar.DAY_OF_WEEK);
			        List<DetalleAsistencia> arregloAnalista = null;
			        arregloAnalista = obtieneDias(uid, diaInicio, totalDias);

			        List<AsistenciaOV> asistenciaTotal = new ArrayList<AsistenciaOV>();

			        if (arregloAnalista.size() > 0) {
				        AsistenciaOV personasFinal = null;
				        if ( personas.size() > 0) {
				        	personasFinal = new AsistenciaOV();
				        	personasFinal.setPersona(personas.get(0).getPersona());
				        	personasFinal.setNombre(personas.get(0).getNombre());
				    		personasFinal.setApellidoPaterno(personas.get(0).getApellidoPaterno());
				    		personasFinal.setApellidoMaterno(personas.get(0).getApellidoMaterno());
				    		personasFinal.setDetalle(arregloAnalista);
				        }

				        for (int i = 0; i < personas.size(); i++) {

				        	if (personasFinal.getPersona().equals(personas.get(i).getPersona())) {

				        		for (int j = 1; j < personasFinal.getDetalle().size(); j++) {

					    			if (personasFinal.getDetalle().get(j).getDia()
					    					== Integer.parseInt(personas.get(i).getDiaMes())) {
					    				personasFinal.getDetalle().get(j).setValor(1);
					    				personasFinal.getDetalle().get(j).setTipoAsistencia("A");
					    			}
					    		}
				        	} else {
				        		asistenciaTotal.add(personasFinal);
				        		List<DetalleAsistencia> arregloAnalistaItera = null;
						        arregloAnalistaItera = obtieneDias(uid, diaInicio, totalDias);

				        		personasFinal = new AsistenciaOV();
					        	personasFinal.setPersona(personas.get(i).getPersona());
					        	personasFinal.setNombre(personas.get(i).getNombre());
					    		personasFinal.setApellidoPaterno(personas.get(i).getApellidoPaterno());
					    		personasFinal.setApellidoMaterno(personas.get(i).getApellidoMaterno());
					    		personasFinal.setDetalle(arregloAnalistaItera);

					    		for (int k = 0; k < personasFinal.getDetalle().size(); k++) {
					    			if (personasFinal.getDetalle().get(k).getDia()
					    					== Integer.parseInt(personas.get(i).getDiaMes())) {
					    				personasFinal.getDetalle().get(k).setValor(1);
					    				personasFinal.getDetalle().get(k).setTipoAsistencia("A");
					    			}
					    		}
				        	}
				        }
				        asistenciaTotal.add(personasFinal);
			        }

			        for (int i = 0; i < asistenciaTotal.size(); i++) {

			        	for (int j = 0; j < asistenciaTotal.get(i).getDetalle().size(); j++) {
			        		if (asistenciaTotal.get(i).getDetalle().get(j).getTipoAsistencia() == null) {
			        			asistenciaTotal.get(i).getDetalle().get(j).setTipo(0);
			        			asistenciaTotal.get(i).getDetalle().get(j).setTipoAsistencia("Ausencia");
			        		}
			        	}
			        }


			        final List<AnalistasCEC> personasEstatusAsistencia =
							(List<AnalistasCEC>) sessionNTx.selectList("consultaReporteAsistenciaEstatus", fechaPeticion);

		        	if (personasEstatusAsistencia.size() == 0) {
						throw new Exception("No se obtuvieron resultado del Estatus de los analistas del CEC");
					}

		        	String diaMes = "";
		        	String codigo = "";
		        	String descripcion = "";

		        	for (int i = 0; i < asistenciaTotal.size(); i++) {
		        		for (int j = 0; j < personasEstatusAsistencia.size(); j++) {
		        			if (asistenciaTotal.get(i).getPersona().equals(personasEstatusAsistencia.get(j).getPersona())) {
		        				diaMes = personasEstatusAsistencia.get(j).getDiaMes();
		        				codigo = personasEstatusAsistencia.get(j).getCodigo();
		        				descripcion = personasEstatusAsistencia.get(j).getDescripcion();

		        				for (int k = 0; k < asistenciaTotal.get(i).getDetalle().size(); k++) {
			        				if (Integer.parseInt(diaMes) == asistenciaTotal.get(i).getDetalle().get(k).getDia()) {
			        					asistenciaTotal.get(i).getDetalle().get(k).setTipoAsistencia(descripcion);
			        				}
		        				}
		        			}
		        		}
		        	}

			        final List<AnalistasCEC> personasContingencia =
							(List<AnalistasCEC>) sessionNTx.selectList("consultaReporteAsistenciaContingencia", fechaPeticion);

		        	if (personasContingencia.size() > 0) {
		        		for (int i = 0; i < personasContingencia.size(); i++) {
		        			for (int j = 0; j < asistenciaTotal.size(); j++) {

		        				diaMes = personasContingencia.get(i).getDiaMes();

		        				for (int k = 0; k < asistenciaTotal.get(i).getDetalle().size(); k++) {
			        				if (Integer.parseInt(diaMes) == asistenciaTotal.get(i).getDetalle().get(k).getDia()) {
			        					asistenciaTotal.get(j).getDetalle().get(k).setTipoAsistencia("Contingencia");
			        				}
		        				}

			        		}
			        	}
		        	}


			        int contadorAsistencia = 0;
			        int contadorRetardo = 0;
			        int contadorFaltas = 0;
			        int contadorFeriado = 0;
			        int contadorVacaciones = 0;
			        int contadorPermiso = 0;
			        int contadorContingencia = 0;
			        int contadorDescanso = 0;
			        int contadorOtrasActividades = 0;
			        for (int i = 0; i < asistenciaTotal.size(); i++) {

			        	for (int j = 0; j < asistenciaTotal.get(i).getDetalle().size(); j++) {
			        		if (asistenciaTotal.get(i).getDetalle().get(j).getTipoAsistencia() != null) {
				        		if (asistenciaTotal.get(i).getDetalle().get(j).getTipoAsistencia().equals("Activo")) {
				        			asistenciaTotal.get(i).getDetalle().get(j).setTipoAsistencia("A");
				        			contadorAsistencia++;
				        		} else if (asistenciaTotal.get(i).getDetalle().get(j).getTipoAsistencia().equals("Retardo")) {
				        			asistenciaTotal.get(i).getDetalle().get(j).setTipoAsistencia("R");
				        			contadorRetardo++;
				        		} else if (asistenciaTotal.get(i).getDetalle().get(j).getTipoAsistencia().equals("Ausencia")) {
				        			asistenciaTotal.get(i).getDetalle().get(j).setTipoAsistencia("F");
				        			contadorFaltas++;
				        		} else if (asistenciaTotal.get(i).getDetalle().get(j).getTipoAsistencia().equals("Feriado")) {
				        			asistenciaTotal.get(i).getDetalle().get(j).setTipoAsistencia("FE");
				        			contadorFeriado++;
				        		} else if (asistenciaTotal.get(i).getDetalle().get(j).getTipoAsistencia().equals("Vacaciones")) {
				        			asistenciaTotal.get(i).getDetalle().get(j).setTipoAsistencia("V");
				        			contadorVacaciones++;
				        		} else if (asistenciaTotal.get(i).getDetalle().get(j).getTipoAsistencia().equals("Permiso")) {
				        			asistenciaTotal.get(i).getDetalle().get(j).setTipoAsistencia("P");
				        			contadorPermiso++;
				        		} else if (asistenciaTotal.get(i).getDetalle().get(j).getTipoAsistencia()
				        				.equals("Contingencia")) {
				        			asistenciaTotal.get(i).getDetalle().get(j).setTipoAsistencia("C");
				        			contadorContingencia++;
				        		} else if (asistenciaTotal.get(i).getDetalle().get(j).getTipoAsistencia().equals("Descanso")) {
				        			asistenciaTotal.get(i).getDetalle().get(j).setTipoAsistencia("D");
				        			contadorDescanso++;
				        		} else if (asistenciaTotal.get(i).getDetalle().get(j).getTipoAsistencia()
				        				.equals("Otras Actividades")) {
				        			asistenciaTotal.get(i).getDetalle().get(j).setTipoAsistencia("OA");
				        			contadorOtrasActividades++;
				        		}
			        		}
			        	}

			        	asistenciaTotal.get(i).setAsistenciaTotal(String.valueOf(contadorAsistencia));
			        	asistenciaTotal.get(i).setRetardoTotal(String.valueOf(contadorRetardo));
			        	asistenciaTotal.get(i).setFaltaTotal(String.valueOf(contadorFaltas));
			        	asistenciaTotal.get(i).setFeriadoTotal(String.valueOf(contadorFeriado));
			        	asistenciaTotal.get(i).setVacacionesTotal(String.valueOf(contadorVacaciones));
			        	asistenciaTotal.get(i).setPermisoTotal(String.valueOf(contadorPermiso));
			        	asistenciaTotal.get(i).setContingenciaTotal(String.valueOf(contadorContingencia));
			        	asistenciaTotal.get(i).setDescansoTotal(String.valueOf(contadorDescanso));
			        	asistenciaTotal.get(i).setOtrasActividadesTotal(String.valueOf(contadorOtrasActividades));
			        	contadorAsistencia = 0;
				        contadorRetardo = 0;
				        contadorFaltas = 0;
				        contadorFeriado = 0;
				        contadorVacaciones = 0;
				        contadorPermiso = 0;
				        contadorContingencia = 0;
				        contadorDescanso = 0;
				        contadorOtrasActividades = 0;

			        }

			        respuesta.setAsistenciaOV(asistenciaTotal);
			        LogHandler.info(uid, getClass(), "ReporteAsistencias: -> ");
					sessionNTx.commit(true);
					respuesta.getHeader().setMensaje("Consulta Satisfactoria");
				}
	        } catch (Exception ex) {
	        	FabricaConexiones.rollBack(sessionNTx);

	        	respuesta.getHeader().setMensaje(ex.getMessage());
				respuesta.getHeader().setUID(uid);
				respuesta.getHeader().setEstatus(false);

				LogHandler.error(uid, this.getClass(), " ERROR: Error al momento de consulta la información ROLLBACK: "
						+ ex.getMessage(), ex );
	        }
	        finally {
	            FabricaConexiones.close(sessionNTx);
	        }

			return respuesta;
		}

		/**
		 * Metodo que se utiliza para obtener una lista con los numeros de dia de cada mes
		 * @param uid Identificador Unico
		 * @param dia Con el que inicia
		 * @param totalDias Numero total de dias del mes
		 * @return DetalleAsistencia REspuesta
		 */
		private List<DetalleAsistencia> obtieneDias(String uid, int dia, int totalDias) {
			final int diaSemana = 7;
	        final int diaUno = 1;
	        final int diaDos = 2;
	        final int diaTres = 3;
	        final int diaCuatro = 4;
	        final int diaCinco = 5;
	        final int diaSeis = 6;
	        final int diaSiete = 7;
			try {
				int contadorDias = dia - 1;
		        List<DetalleAsistencia> arregloAnalista = new ArrayList<DetalleAsistencia>();

		        //Se obtiene el numero de dia y dia de la semana
		        for (int j = 1; j <= totalDias; j++) {
		        	DetalleAsistencia analistaFinal = new DetalleAsistencia();

		        	if (contadorDias == diaSemana) {
		        		contadorDias = 1;
		        		analistaFinal.setDia(j);
		        	} else {
		        		contadorDias++;
		        		analistaFinal.setDia(j);
		        	}

		        	switch (contadorDias) {
					case diaUno:
						analistaFinal.setDiaLetra("DOM");
						break;
					case diaDos:
						analistaFinal.setDiaLetra("LUN");
						break;
					case diaTres:
						analistaFinal.setDiaLetra("MAR");
						break;
					case diaCuatro:
						analistaFinal.setDiaLetra("MIE");
						break;
					case diaCinco:
						analistaFinal.setDiaLetra("JUE");
						break;
					case diaSeis:
						analistaFinal.setDiaLetra("VIE");
						break;
					case diaSiete:
						analistaFinal.setDiaLetra("SAB");
						break;

					default:
						break;
					}
		        	arregloAnalista.add(analistaFinal);
		        }
		        return arregloAnalista;

			} catch (Exception ex) {
				LogHandler.error(uid, this.getClass(), " ERROR: Error al momento de realizar la lista de dias: "
						+ ex.getMessage(), ex );
				return null;
			}
		}


		/**
		 * Metodo donde se registra la operacion  de inicio y fin de seciones
		 * @param uid id unico de transaccion
		 * @param peticion peticion
		 * @return RegistrOperacionesRespuesta respuesta
		 */
		public RegistrOperacionesRespuesta registrarOperacion(String uid, RegistrOperacionesPeticion peticion) {
			LogHandler.info(uid, getClass(), "-------inicia el metodo registrarOperacion " );
			RegistrOperacionesRespuesta respuesta = new RegistrOperacionesRespuesta();
			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setEstatus(true);

			SqlSession sessionNTx = null;
			SqlSession sessionTx = null;

			try {
				sessionNTx = FabricaConexiones.obtenerSesionNTx();
				sessionTx = FabricaConexiones.obtenerSesionTx();

				if (peticion == null || peticion.getNumeroPersona() == null || peticion.getNumeroPersona().trim().isEmpty()
						|| peticion.getTipOperacion() == null || peticion.getTipOperacion().trim().isEmpty() ) {
					throw new Exception("DATOS INCORRECTOS: Es necesario contar con el"
							+ " número de persona y el tipo de operación a realizar.");
				}
				LogHandler.info(uid, getClass(), "registrarOperacion: Número persona: " +  peticion.getNumeroPersona()
				+ " tipo Operación: " + peticion.getTipOperacion());

				ParGeneralOV tareas = comun.obtenerParGeneralOV(uid, "MODULOCEC_TAREAS");
				if (tareas == null || tareas.getCgValor().trim().isEmpty()) {
					throw new Exception("No se pudo recuperar la jdni MODULOCEC_TAREAS.");
				}

				List<String> listTiposTareas = Validaciones.obtenerListaCodigos(uid, tareas.getCgValor().trim());

				LogHandler.info(uid, getClass(), "registrarOperacion: valor de la jdni MODULOCEC_TAREAS " +  listTiposTareas);

				//checar si hay registro para el dia de hoy
				AnalistasCEC analistaRegistroHoy = (AnalistasCEC) sessionNTx.selectOne("existeRegistroEntradaHoy",
						peticion.getNumeroPersona().trim());

				//si la operacion es registro de entrada lo identificamos como un inicia
				if (peticion.getTipOperacion().equals("inicia") && analistaRegistroHoy == null) {
					Integer registroEntrada = sessionTx.insert("insertaRegistroEntrada", peticion.getNumeroPersona().trim());
					if (registroEntrada == 1) {
						respuesta.getHeader().setMensaje("Inicio de labores registrado con éxito.");
					}
				} else if (peticion.getTipOperacion().equals("inicia") && analistaRegistroHoy != null) {
					respuesta.getHeader().setMensaje("Ya se cuenta con un registro de inicio de labores,"
							+ " para el dia de hoy.");
			//este caso es para finalizar labores el dia de hoy
				} else if (peticion.getTipOperacion().equals("termina") && analistaRegistroHoy == null) {
					respuesta.getHeader().setEstatus(false);
					respuesta.getHeader().setMensaje("No se cuenta con registro de inicio de labores.");
				} else if (peticion.getTipOperacion().equals("termina") && analistaRegistroHoy != null) {
					HashMap<String, Object> parametros = new HashMap<String, Object>();
					parametros.put("numeroPersona" , peticion.getNumeroPersona());
					parametros.put("listaTareas" , listTiposTareas);
					LogHandler.info(uid, getClass(), "registrarOperacion: parametros para finalizar sesión: " +  parametros);

					Integer solicitudObservacion = (Integer) sessionNTx.selectOne("obtenerSolicitudesConObservacion",
							parametros);

					if (solicitudObservacion == 0) {
						Integer finLabores = 0;
						AnalistasCEC analistaRegistroSalidaHoy = (AnalistasCEC) sessionNTx.selectOne("existeRegistroSalidaHoy",
								peticion.getNumeroPersona().trim());

						if (analistaRegistroSalidaHoy == null) {
						    finLabores = sessionTx.update( "actulizarRegistroSalida",  peticion.getNumeroPersona());
						} else {
							respuesta.getHeader().setMensaje("Ya se registro termino de labores para el dia de hoy.");
						}
						if (finLabores == 1) {
							respuesta.getHeader().setMensaje("Termino de labores registrado con éxito.");
						}
					} else {
						respuesta.getHeader().setEstatus(false);
						respuesta.getHeader().setMensaje("No puede finalizar sesión,  existen"
								+ " solicitudes con \"Observaciones\" sin revisar.");
					}
				} else {
					respuesta.getHeader().setEstatus(false);
					respuesta.getHeader().setMensaje("operacion inexistente.");
				}
				sessionTx.commit(true);
			} catch (Exception ex) {
	        	FabricaConexiones.rollBack(sessionTx);

	        	respuesta.getHeader().setMensaje(ex.getMessage());
				respuesta.getHeader().setUID(uid);
				respuesta.getHeader().setEstatus(false);

				LogHandler.error(uid, this.getClass(), " ERROR: Error al momento de registrarOperacion ROLLBACK: "
						+ ex.getMessage(), ex );
	        }
	        finally {
	            FabricaConexiones.close(sessionTx);
	            FabricaConexiones.close(sessionNTx);
	        }
			LogHandler.info(uid, getClass(), "-------termina el metodo registrarOperacion " );
			return respuesta;
		}
		
		/**
		 * Metodo de consutla de analista de sucursal
		 * @param uid : id unico de transaccion 
		 * @param sucursal : numero de la sucursal
		 * @return List<ConsultaAnalista> : lista de los analistas de esa sucursal.
		 */
		@SuppressWarnings("unchecked")
		public List<ConsultaAnalista> consultaAnalistasPorSucursal( String uid, Integer sucursal) {
			LogHandler.info(uid, getClass(), "==> consultaAnalistasPorSucursal: " + sucursal);
			List<ConsultaAnalista> respuesta = null;
			List<ConsultaAnalista> listaAnalistas = null;
			List<ConsultaAnalista> listaAsesores = null;
			List<String> listaPuestos = null;
			String correoAnalistaPorSucursal = null;
			SqlSession sesionNTx = null;

			try {

				if (sucursal == null || sucursal <= 0 ) {
					throw new Exception("Falta la sucursal en la peticion");
				}
				//Se abre la conexion a la base
				sesionNTx = FabricaConexiones.obtenerSesionNTx();
				String dbEntorno = sesionNTx.getConfiguration().getVariables().getProperty("db.entorno");
				listaPuestos = comun.obtenerListaDeParametros(uid, "caravanas.analista.puestos");
				HashMap<String, Object> parametros = new HashMap<String, Object>();
				parametros.put("dbEntorno" , dbEntorno);
				parametros.put("listaPuestos", listaPuestos);
				parametros.put("sucursal", sucursal);
				LogHandler.info(uid, getClass(), "==> consultaAnalistasPorSucursal parametros: " + parametros);
				
				listaAnalistas = (List<ConsultaAnalista>) sesionNTx.selectList("consultaAnalistaPorSucursal", parametros);
				listaAsesores = (List<ConsultaAnalista>) sesionNTx.selectList("consultaAsesorPorSucursal", parametros);
				
				//se obtiene el analista asociado a cada sucursal con el perfil 000000878
				if (listaAnalistas != null && listaAnalistas.size() > 0) {
					for (ConsultaAnalista analista : listaAnalistas) {
						if (analista != null && analista.getClavePuesto().equals("000000878") && analista.getCorreo() != null) {
							correoAnalistaPorSucursal = analista.getCorreo().trim();
						}
					}
				}
				
				//hay que recorrer la lista de asesores para agregarles el correo del analista asociado a la sucursal
				if (listaAsesores != null && listaAsesores.size() > 0 ) {
					for (ConsultaAnalista asesor : listaAsesores) {
						 asesor.setCorreo(correoAnalistaPorSucursal);
					}
				}
				
				// hay que agregarle a la respuesta tanto los analistas como asesores
				respuesta = new ArrayList<ConsultaAnalista>();
				respuesta.addAll(listaAnalistas);
				respuesta.addAll(listaAsesores);
					
                LogHandler.info(uid, getClass(), "==> consultaAnalistasPorSucursal: " + respuesta);
              
			}
			catch ( java.lang.Exception exception ) {
				LogHandler.error( uid, this.getClass(),
					"Ocurrio error al consultaAnalistasPorSucursal: " + exception.getMessage(), exception );
			}
			finally {
				FabricaConexiones.close(sesionNTx);

			}
			return respuesta;
		}

}
