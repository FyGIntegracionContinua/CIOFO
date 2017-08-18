package tarea.operacion;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import mx.com.findep.depositosgarantia.ws.DepositosGarantiaPeticion;
import mx.com.findep.depositosgarantia.ws.DepositosGarantiaWS_ServiceLocator;

import org.apache.ibatis.session.SqlSession;
import org.osoa.sca.annotations.Reference;

import tarea.comun.ComunTarea;
import tarea.comun.ReadProperties;
import tarea.consultas.Consultas;
import utilitario.comun.Constantes;
import utilitario.comun.ConstantesPagos;
import utilitario.comun.Validaciones;
import utilitario.log.LogHandler;
import utilitario.mensajes.administracion.contrato.TraspasoContratoOV;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.FechaContableOV;
import utilitario.mensajes.comun.ResultadoOV;
import utilitario.mensajes.condonaciones.comun.CreditoSaldo;
import utilitario.mensajes.convenio.ConvenioOV;
import utilitario.mensajes.convenio.DatosConvenioPeticion;
import utilitario.mensajes.convenio.DatosConvenioRespuesta;
import utilitario.mensajes.convenio.PagosConvenioOV;
import utilitario.mensajes.operacion.ActaRecaudacionClienteOV;
import utilitario.mensajes.operacion.ActaRecaudacionOV;
import utilitario.mensajes.operacion.ActaRecaudacionParcialidadOV;
import utilitario.mensajes.operacion.ActaRecaudacionPeticion;
import utilitario.mensajes.operacion.ActaRecaudacionRespuesta;
import utilitario.mensajes.operacion.ContratoPagosLineaOV;
import utilitario.mensajes.operacion.TraspasoPagos;
import utilitario.mensajes.operacion.TraspasoPagosPeticion;
import utilitario.mensajes.operacion.TraspasoPagosRespuesta;
import utilitario.mensajes.operacion.pagos.AlmacenarArchivoOxxoPeticion;
import utilitario.mensajes.operacion.pagos.AlmacenarArchivoOxxoRespuesta;
import utilitario.mensajes.operacion.pagos.AplicarPagoConexiaPeticion;
import utilitario.mensajes.operacion.pagos.AplicarPagoLineaPeticion;
import utilitario.mensajes.operacion.pagos.AplicarPagoPeticion;
import utilitario.mensajes.operacion.pagos.AplicarPagoRespuesta;
import utilitario.mensajes.operacion.pagos.AplicarPagoServicioRespuesta;
import utilitario.mensajes.operacion.pagos.CalculaParcialidadOV;
import utilitario.mensajes.operacion.pagos.CancelaPagoConexiaValidaOV;
import utilitario.mensajes.operacion.pagos.CancelarMovimientosPeticion;
import utilitario.mensajes.operacion.pagos.CancelarMovimientosRespuesta;
import utilitario.mensajes.operacion.pagos.CancelarPagoConexiaPeticion;
import utilitario.mensajes.operacion.pagos.CancelarPagoConexiaRespuesta;
import utilitario.mensajes.operacion.pagos.ConsultarPagosLineaRespuesta;
import utilitario.mensajes.operacion.pagos.ConsultarPagosPeticion;
import utilitario.mensajes.operacion.pagos.ConsultarPagosRespuesta;
import utilitario.mensajes.operacion.pagos.DetalleTransaccionOV;
import utilitario.mensajes.operacion.pagos.PagoDTO;
import utilitario.mensajes.operacion.pagos.PagoGrupal;
import utilitario.mensajes.operacion.pagos.PagoGrupalResponse;
import utilitario.mensajes.operacion.pagos.PagoLineaDTO;
import utilitario.mensajes.operacion.pagos.PagoServicioPeticion;
import utilitario.mensajes.operacion.pagos.RegistroOxxoArchivo;
import utilitario.mensajes.operacion.pagos.RespuestaConciliarPagos;
import utilitario.mensajes.operacion.pagos.ReversarPagoOxxoPeticion;
import utilitario.mensajes.operacion.pagos.ReversarPagoOxxoRespuesta;
import utilitario.mensajes.operacion.pagos.TraspasarPagoOV;
import utilitario.mensajes.operacion.pagos.TraspasarPagoPeticion;
import utilitario.mensajes.operacion.pagos.TraspasarPagoRespuesta;
import utilitario.mensajes.operacion.pagos.oxxo.CatalogoDeEstados;
import utilitario.mensajes.operacion.pagos.oxxo.PeticionEnLineaOxxo;
import utilitario.mensajes.operacion.pagos.oxxo.RespuestaReverseEnLineaOxxo;
import utilitario.mensajes.originacion.consulta.ParGeneralOV;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import datamapper.DataMapper;
import entidad.conexiones.FabricaConexiones;

/**
 * @author out_oarias
 *
 */
public class PagosCreditoImpl implements PagosCredito {
	private String ESTATUS_NO_IDENTIFICADO = "NO_IDENTIFICADO";
	private String ESTATUS_APLICADO = "APLICADO";
	private String ESTATUS_ERROR = "ERROR_INTERNO";
	SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");	
	private ComunTarea comun;
	private Consultas consultas;
	String guid = null;

	public PagosCreditoImpl(@Reference(name = "comun") ComunTarea comun,
			@Reference(name = "consultas") Consultas consultas) {

		this.comun = comun;
		this.consultas = consultas;
		this.consultas.toString();
	}

	public PagoGrupalResponse aplicarPagoGrupal(String uid, PagoGrupal pagoGrupalObject) {

		if (pagoGrupalObject.getMedioPago().trim().length() == 2) {
			pagoGrupalObject.setMedioPago( DataMapper.mapMedioPago.get(pagoGrupalObject.getMedioPago().trim()) );
		}

		//RECU-162 Logica para recibir pagos oxxo en linea y batch
		/*
		if (pagoGrupalObject.getMedioPago().trim().equals(MEDIO_PAGO_OXXO)) {
			if (pagoGrupalObject.getNumeroContrato() == null ) {
				pagoGrupalObject.setNumeroContrato("");
			}
			if (pagoGrupalObject.getNumeroContrato().startsWith(PREFIJO_OXXO)) {
				pagoGrupalObject.setNumeroContrato(pagoGrupalObject.getNumeroContrato().substring(2, 12));
			}
			if (pagoGrupalObject.getNumeroContrato().startsWith("00")) {
				pagoGrupalObject.setNumeroContrato(pagoGrupalObject.getNumeroContrato().substring(2, 10));
			} else {
				pagoGrupalObject.setNumeroContrato("LD" + pagoGrupalObject.getNumeroContrato());
			}
			LogHandler.info(uid, this.getClass(), "NumeroContrato: " + pagoGrupalObject.getNumeroContrato());
		}
		*/
		//Fin RECU-162

		pagoGrupalObject.setCodigo( ConstantesPagos.PAGO_REFERENCIADO.getValue() );
		pagoGrupalObject.setReferencia("");
		return aplicarPagoGrupal(uid, null, null, pagoGrupalObject);
	}

/**
 * @param uid identificador unico de la transaccion
 * @param sesionTx sesion transaccion si es que se ya se trae una sesion
 * @param idTransaccion id de la transaccion si ya se trae alguna
 * @param pagoGrupalObject los datos para aplicar el pago.
 * @return PagoGrupalResponse resultado de la aplicacion del pago
 */
	public PagoGrupalResponse aplicarPagoGrupal(String uid, SqlSession sesionTx,
			Integer idTransaccion, PagoGrupal pagoGrupalObject) {
		PagoGrupalResponse resp = new PagoGrupalResponse();
		String numeroContrato = null;
		String descripcionPago = "";
		Date fechaValor = null;
		boolean sesionExterna = false;

		resp.setFechaValor(pagoGrupalObject.getFechaValor());
		resp.setIdPago(pagoGrupalObject.getIdPago());
		resp.setMedioPago(pagoGrupalObject.getMedioPago());
		resp.setMonto(pagoGrupalObject.getMonto());
		resp.setNumeroContrato(pagoGrupalObject.getNumeroContrato());
		resp.setPromesaLiquidacion(false);

		//Se formatea la referencia para colocar el medio de pago

		if ( pagoGrupalObject.getReferencia() == null ||  pagoGrupalObject.getReferencia().trim().isEmpty() ) {
			final DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
			pagoGrupalObject.setReferencia( "Pago Referenciado " + pagoGrupalObject.getMedioPago().replace("_", "") + " "
					+ decimalFormat.format( pagoGrupalObject.getMonto() ) );
		}

		//se verifica la existencia del contrato, si es de finsol (LD..) se busca el contrato correspondiente en CREDPROD
		numeroContrato = comun.obtenerNumeroContrato(uid, pagoGrupalObject.getNumeroContrato());
		//LogHandler.debug("--numero contrato recuperado"+numeroContrato);
		// validaciones
		if (numeroContrato == null) {
			LogHandler.debug(uid,  getClass(), " ERROR: Contrato Inexistente: " + pagoGrupalObject.getNumeroContrato());
			resp.setHeader(generarHeader(uid, false, "Contrato Inexistente"));
			resp.setEstatus(ESTATUS_NO_IDENTIFICADO);
			return resp;
		}

		if (pagoGrupalObject.getMonto() < 0) {
			LogHandler.debug(uid, this.getClass(), " ERROR: Monto incorrecto: " + pagoGrupalObject.getNumeroContrato());
			resp.setHeader(generarHeader(uid, false, "Monto incorrecto"));
			resp.setEstatus(ESTATUS_ERROR);
			return resp;
		}

		FechaContableOV datosFechaContable = comun.obtenerFechaContable(uid);

		LogHandler.info(uid, getClass(), "Fecha contable=" + datosFechaContable.getFecha());
		LogHandler.info(uid, getClass(), "Fecha valor=" + (pagoGrupalObject.getFechaValor() != null
				? pagoGrupalObject.getFechaValor() : "null"));

		if ( datosFechaContable.isEstatusCierre()) {
			LogHandler.debug(uid, this.getClass(), " ERROR: Cierre en proceso: " + pagoGrupalObject.getNumeroContrato());
			resp.setHeader(generarHeader(uid, false, "Cierre en proceso"));
			resp.setEstatus(ESTATUS_ERROR);
			return resp;
		}

		if (pagoGrupalObject.getFechaValor() != null) {

			fechaValor = pagoGrupalObject.getFechaValor();
			//ORIG-360 Cierre de creditos de OXXO
			 Calendar cal = Calendar.getInstance();
		     cal.setTime(pagoGrupalObject.getFechaValor());
		     cal.set(Calendar.HOUR_OF_DAY, 0);
		     cal.set(Calendar.MINUTE, 0);
		     cal.set(Calendar.SECOND, 0);
		     cal.set(Calendar.MILLISECOND, 0);
		     fechaValor = cal.getTime();
		} else {
			Date fechaCont = datosFechaContable.getFecha();
			Calendar cal = new GregorianCalendar();
			cal.setTimeInMillis(fechaCont.getTime());
			fechaValor = cal.getTime();
		}

		//Validacion tipoPago por defaul NORM
		if (pagoGrupalObject.getTipoPago() == null || pagoGrupalObject.getTipoPago().trim().equals("")) {
			pagoGrupalObject.setTipoPago("NORM");
		}
		LogHandler.info(uid, getClass(), "Tipo Pago=" + pagoGrupalObject.getTipoPago());

		try {

			boolean promesaPagoLiquidacion = false;
			boolean cambioTraspaso = false;
			String contratoOrigen = "";
			HashMap<String, Object> paramsPromesaLiq = new HashMap<String, Object>();
			SqlSession sesionNTx = FabricaConexiones.obtenerSesionNTx();

			//ORIG-436 Traspaso de Pago
			TraspasoContratoOV datosTraspaso
				= (TraspasoContratoOV) sesionNTx.selectOne("consultarTraspasoContratoActual", numeroContrato);
			if (datosTraspaso != null ) {
				LogHandler.info(uid, getClass(), "El contrato enviado esta liquidao y existe un contrato actual dispuesto ="
						+ datosTraspaso.getContratoActual());
				LogHandler.info(uid, getClass(), "CAMBIO CONTRATO!!!");
				contratoOrigen = numeroContrato;
				numeroContrato = datosTraspaso.getContratoActual();
				pagoGrupalObject.setNumeroContrato(numeroContrato);
				cambioTraspaso = true;
			}

			//Verificamos si genero ficha de promesa de liquidacion -> ABO
			try {

				paramsPromesaLiq.put("contrato", numeroContrato);
				paramsPromesaLiq.put("fechaPago", fechaValor);

				LogHandler.trace(uid, getClass(), "==> aplicarPagoGrupal - promesaLiquidacion");
				Integer impresionFicha = (Integer) sesionNTx.selectOne("promesaLiquidacion", paramsPromesaLiq);
				LogHandler.info(uid, getClass(), "impresionFicha=" + impresionFicha);
				if ( impresionFicha.intValue() > 0) {
					//Verificar que el monto no sea parecido a la parcialidad
					LogHandler.info(uid, getClass(), "Existe promesa de liquidacion, generaron ficha especial.");

					//ORIG-289 Se elimina la validacion de los 100
					/*
					LogHandler.trace(uid, getClass(), "==> aplicarPagoGrupal - obtieneMontoPagoContrato");
					Double montoParcialidad = (Double) sesionNTx.selectOne("obtieneMontoPagoContrato", paramsPromesaLiq);
					Double desviacion = 0d;
					try {
						desviacion = Double.parseDouble( comun.obtenerParGeneral(uid, "MONPAGOPAR"));
					} catch (Exception ex) {
						desviacion = 100.00;
					}
					double montoMinimoParcialidad = montoParcialidad.doubleValue() - desviacion.doubleValue();
					double montoMaximoParcialidad = montoParcialidad.doubleValue() + desviacion.doubleValue();
					LogHandler.info(uid, getClass(), "montoMinimoParcialidad=" + montoMinimoParcialidad);
					LogHandler.info(uid, getClass(), "montoMaximoParcialidad=" + montoMaximoParcialidad);

					if ( pagoGrupalObject.getMonto() >= montoMinimoParcialidad
						&& pagoGrupalObject.getMonto() <= montoMaximoParcialidad ) {
						LogHandler.info(uid, getClass(), "Cambio a NORM!!!");
						pagoGrupalObject.setTipoPago("NORM");
					} else {
						pagoGrupalObject.setTipoPago("ABO");
						promesaPagoLiquidacion = true;
						resp.setPromesaLiquidacion(promesaPagoLiquidacion);
					}
					*/
					//ORIG-289
					LogHandler.info(uid, getClass(), "Cambio a promesaPagoLiquidacion!!!");
					pagoGrupalObject.setTipoPago("ABO");
					promesaPagoLiquidacion = true;
					resp.setPromesaLiquidacion(promesaPagoLiquidacion);
				}
				FabricaConexiones.close(sesionNTx);

			} catch (Exception exBuscaPromesaLiquidacion) {
				throw new Exception(exBuscaPromesaLiquidacion.getMessage());
			}
			LogHandler.info(uid, getClass(), "Tipo Pago=" + pagoGrupalObject.getTipoPago());

			//Se abre la seccion transaccional
			//Se define si es externa e interna
			if (sesionTx == null) {
				LogHandler.info(uid, getClass(), "Usando session local.");
				sesionTx = FabricaConexiones.obtenerSesionTx();
			} else {
				LogHandler.info(uid, getClass(), "Usando session externa.");
				//sesionTx = sesionTxx;
				sesionExterna = true;
			}


			//***Validacion idTransaccion RECU-129 duplicidad de pagos
			if ( pagoGrupalObject.getIdTransaccionValida() != null
					&& !pagoGrupalObject.getIdTransaccionValida().trim().isEmpty() ) {
				HashMap<String, Object> parametrosAuditoria = new HashMap<String, Object>();
				parametrosAuditoria.put("contrato", numeroContrato);
				parametrosAuditoria.put("idTransaccion", pagoGrupalObject.getIdTransaccionValida());

				Integer existe =
						(Integer) sesionTx.selectOne("consultaPagoContratoAuditoria", parametrosAuditoria);

				if (existe > 0) {
					throw new Exception( "No es posible registrar el pago, identificador duplicado");
				}

			}

			//Se recuperan los datos del contrato
			//Datos del contrato
			final HashMap<String, Object> datosCredito
				= comun.obtenerDatosGeneralesContratoSimple(uid, numeroContrato, sesionTx);

			if (datosCredito == null) {
				throw new java.lang.Exception("No se pudo obtener los datos del contrato al aplicar el pago");
			}

			//Se valida el status del contrato
			if ( datosCredito.get( "status" ) == null
				|| !datosCredito.get( "status" ).toString().trim().equals( "D" )
				&& !datosCredito.get( "status" ).toString().trim().equals( "P" ) ) {
				throw new java.lang.Exception( ReadProperties.mensajes.getProp( "ciof.error.statuscontratoincorrecto" ) );
			}

			Integer sucursal = 0;

			if (pagoGrupalObject.getSucursal() != null && pagoGrupalObject.getSucursal() > 0) {
				sucursal = pagoGrupalObject.getSucursal();
				LogHandler.info(uid, getClass(), " sucursal enviada=" + sucursal);
			} else {
				LogHandler.trace(uid, getClass(), "==> aplicarPagoGrupal - obtenerSucursalContrato");
				sucursal = (Integer) sesionTx.selectOne("obtenerSucursalContrato", numeroContrato);
				LogHandler.info(uid, getClass(), " sucursal recuperada=" + sucursal);
			}

			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("contrato", numeroContrato);
			params.put("fechaActual", fechaValor);

			LogHandler.debug(uid, getClass(), " fechaActual: " + fechaValor );
			LogHandler.debug(uid, getClass(), " numeroContrato: " + numeroContrato);
			//obtener saldo a la fecha valor
			LogHandler.trace(uid, getClass(), "==> aplicarPagoGrupal - obtenerSaldoFv");
			CreditoSaldo creditoSaldo  = (CreditoSaldo) sesionTx.selectOne("obtenerSaldoFv", params);

			if (sucursal == null || creditoSaldo == null) {
				throw new Exception(" ERROR: Error al recuperar los datos del credito: " + pagoGrupalObject.getNumeroContrato());
			}

			LogHandler.info(uid, getClass(), "creditoSaldo=" + creditoSaldo);
			LogHandler.info(uid, getClass(), "saldo corriente=" + creditoSaldo.getMontoCorriente());
			LogHandler.info(uid, getClass(), "saldo liquidar=" + creditoSaldo.getSaldoLiquidar());
			LogHandler.info(uid, getClass(), "saldo atrasado=" + creditoSaldo.getMontoPagoAtrasado());

			if (idTransaccion == null) {
				idTransaccion = registraOperacionInventarioCaja(uid, sesionTx, numeroContrato, pagoGrupalObject.getMonto(),
					sucursal, mapearMedioPago(pagoGrupalObject.getMedioPago()), datosFechaContable.getFecha(), 0,
					ConstantesPagos.PAGO_REFERENCIADO.getValue(), "", pagoGrupalObject.getIdTransaccionValida());
			}

			resp.setIdTransaccion(idTransaccion);
			LogHandler.debug(uid, this.getClass(), "pagoGrupalObject: " + pagoGrupalObject );
			LogHandler.debug(uid, this.getClass(), "  creditoSaldo: " + creditoSaldo );

			descripcionPago = pagoGrupalObject.getReferencia();
			if (descripcionPago != null && descripcionPago.equals("")) {
				descripcionPago = obtenerDescripcion(mapearMedioPago(pagoGrupalObject.getMedioPago()));
			}
			// Obtener el monto a pagar para pago normal
			Double montoPago = pagoGrupalObject.getMonto();
			BigDecimal montoLiquidar = new BigDecimal( creditoSaldo.getSaldoLiquidar().toString() );
			//Este monto incluye lo atrasado
			final java.lang.Double montoCorriente = montoPago >= creditoSaldo.getMontoPagoAtrasado()
					? creditoSaldo.getMontoPagoAtrasado() : montoPago;

			//Nueva logica
			/* Paso 1. monto corriente ( incluye atrasado) */
			if ( montoCorriente.doubleValue() > 0.0 ) {
				// Se aplica el pago para el monto atrasado
				aplicarPago(uid, sesionTx, idTransaccion, numeroContrato, montoCorriente, sucursal , fechaValor,
						descripcionPago, mapearMedioPago(pagoGrupalObject.getMedioPago()),
						pagoGrupalObject.getCodigo(), pagoGrupalObject.getUsuario());

				//Se actualiza el monto a liquidar
				montoLiquidar = montoLiquidar.subtract( new BigDecimal( montoCorriente.toString() ) );

				//Se actualiza el monto restante por aplicar
				montoPago -= montoCorriente;

				LogHandler.info(uid, getClass(), "Trato de ponerlo al corriente.");
			}

			boolean liquidaContrato = false;
			/* Paso 2. se intenta liquidar */
			if ( montoPago.doubleValue() > 0.0 && montoPago.doubleValue() + 23 >= montoLiquidar.doubleValue()
					&& montoLiquidar.doubleValue() > 0.0 ) {
				LogHandler.info(uid, getClass(), "El contrato se puede liquidar. SL("
					+ montoLiquidar + "), MP(" + montoPago + ")");

				//Se calcula el monto para liquidar
				final java.lang.Double montoAbono = montoPago > montoLiquidar.doubleValue()
						? montoLiquidar.doubleValue() : montoPago;

				//Se aplica el abono a capital, el cual liquida el contrato
				aplicarAbono(sesionTx, idTransaccion, numeroContrato, montoAbono, sucursal, montoLiquidar.doubleValue(),
							fechaValor, descripcionPago, mapearMedioPago(pagoGrupalObject.getMedioPago()), uid,
							pagoGrupalObject.getCodigo(), pagoGrupalObject.getUsuario());

				//Se actualiza el monto pago
				montoPago -= montoAbono;
				liquidaContrato = true;
			}

			if ( (montoLiquidar.doubleValue() == 0.0 || liquidaContrato) && promesaPagoLiquidacion)  {
				pagoGrupalObject.setTipoPago("NORM");
			}

			/* Paso 3. Se aplican los pagos normales o bien las bonificaciones normales */
			if ( montoPago.doubleValue() > 0.0 ) {
				LogHandler.info(uid, getClass(), "Se puede aplicar un pago mas por : " + montoPago);
				//Si es un pago normal aplica como pagos
				if ( pagoGrupalObject.getTipoPago().trim().equals("NORM") )	{
					aplicarPago(uid, sesionTx, idTransaccion, numeroContrato, montoPago, sucursal , fechaValor,
							descripcionPago + " ", mapearMedioPago(pagoGrupalObject.getMedioPago()),
							pagoGrupalObject.getCodigo(), pagoGrupalObject.getUsuario());
				}
				else
					{
						if ( pagoGrupalObject.getTipoPago().trim().equals("ABO") && montoLiquidar.doubleValue() > 0.0
								&& !liquidaContrato) {
							//Si se mando de tipo abonos, va directo a capital, solo si tiene un saldo a liquidar
							aplicarAbono(sesionTx, idTransaccion, numeroContrato, montoPago, sucursal,
									montoLiquidar.doubleValue(), fechaValor, descripcionPago,
									mapearMedioPago(pagoGrupalObject.getMedioPago()), uid,
									pagoGrupalObject.getCodigo(), pagoGrupalObject.getUsuario());
						}
						else if (pagoGrupalObject.getTipoPago().trim().equals("ABO") && montoLiquidar.doubleValue() > 0.0
									&& liquidaContrato) {
							aplicarPago(uid, sesionTx, idTransaccion, numeroContrato, montoPago, sucursal , fechaValor,
									descripcionPago + " ",	mapearMedioPago(pagoGrupalObject.getMedioPago()),
									pagoGrupalObject.getCodigo(), pagoGrupalObject.getUsuario());
						}
						else
						{
							//Puede haberse mandado un pago pero con caracteristicas incorrectas
							throw new Exception( ReadProperties.mensajes.getProp( "operacion.pagos.errordatospago" ) );
						}
					}
				}

			if (promesaPagoLiquidacion) {
				paramsPromesaLiq.put("contrato", numeroContrato);
				paramsPromesaLiq.put("fechaPago", fechaValor);
				paramsPromesaLiq.put("importe", pagoGrupalObject.getMonto());

				LogHandler.trace(uid, getClass(), "==> aplicarPagoGrupal - actualizaPromesaLiquidacion");
				sesionTx.selectOne("actualizaPromesaLiquidacion", paramsPromesaLiq);
			}

			if (cambioTraspaso) {
				Date fechaCont = datosFechaContable.getFecha();
				Calendar cal = new GregorianCalendar();
				cal.setTimeInMillis(fechaCont.getTime());
				Date fechaContable = cal.getTime();
				HashMap<String, Object> pagoTraspaso = new HashMap<String, Object>();
				pagoTraspaso.put("contrato_origen", contratoOrigen);
				pagoTraspaso.put("contrato_destino", numeroContrato);
				pagoTraspaso.put("fecha_contable", fechaContable);
				pagoTraspaso.put("fecha_valor", fechaValor);
				pagoTraspaso.put("id_trx_caja", idTransaccion);
				pagoTraspaso.put("codigo_servicio", mapearMedioPago(pagoGrupalObject.getMedioPago()));
				pagoTraspaso.put("monto", pagoGrupalObject.getMonto());

				for ( String string : pagoTraspaso.keySet() ) {
					LogHandler.info(uid, getClass(), string + " -- " + pagoTraspaso.get( string ) );
				}

				LogHandler.trace(uid, getClass(), "==> aplicarPagoGrupal - actualizaPromesaLiquidacion");
				sesionTx.selectOne("insertarPagoTraspaso", pagoTraspaso);
			}

			//Se persisten los movimientos
			if (!sesionExterna) {
				LogHandler.info(uid, getClass(), "Aplica una session interna.");
				sesionTx.commit(true);
			}

			LogHandler.info(uid, this.getClass(), "* Pago procesado contratoEnviado=" + pagoGrupalObject.getNumeroContrato()
					+ " contrato Fisa= " + numeroContrato + " fechaContable=" + datosFechaContable.getFecha()
					+ " fechaValor=" + formatter.format(fechaValor) + " monto=" + pagoGrupalObject.getMonto());

		} catch (Exception e) {
			if (!sesionExterna ) {
				FabricaConexiones.rollBack( sesionTx );
			}
			e.printStackTrace();

			LogHandler.error(uid, this.getClass(), " ERROR: Error al aplicar el pago ROLLBACK: "
					+ pagoGrupalObject.getIdPago() + " - " + e.getMessage(), e );
			resp.setHeader(generarHeader(uid, false, e.getMessage()));
			resp.setEstatus(ESTATUS_ERROR);
			return resp;
		} finally {
			if (!sesionExterna) {
				FabricaConexiones.close(sesionTx);
				}
		}

		resp.setHeader(generarHeader(uid, true, "Pago realizado correctamente"));
		resp.setEstatus(ESTATUS_APLICADO);
		return resp;
	}

	private String obtenerDescripcion(String mapearMedioPago) {

		return "Pago Referenciado";
	}

	private String mapearMedioPago(String medioPago) {
		//MHM 2012-08-01 Agregar Codigo Servicio
		return DataMapper.mapMedioPago.get(medioPago);
		//return "FSOL";
	}

	private Integer registraOperacionInventarioCaja(String uid, SqlSession sesion, String numeroContrato, Double monto, Integer sucursal, 
			 String medioPago, Date fechaContable, Integer idTransaccion, String codigo, String usuario , String idTransaccionNuevo)
	throws Exception {

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("sucursal", sucursal);
		map.put("fechaContable", fechaContable);
		//map.put("fechaActual", new Date());

		ResultadoOV resAperturaCaja = comun.aperturaCaja(uid, sucursal, fechaContable);

		if ( "-1".equals(resAperturaCaja.getCodigoRetorno())) {
			throw new Exception("Error al abrir Caja");
		}

		//SE OBTIENE ID DE TRANSACCION DE LA CAJA
		//Integer idTransaccion =aperturaCaja(Integer)sesion.selectOne("obtenerIdTransaccion", map);
		if (idTransaccion == null || idTransaccion == 0)
			{
			idTransaccion = comun.obtenerIdTransaccion(uid, sucursal, fechaContable);
			}

		if ( idTransaccion == null) {
			throw new Exception("Error al obtener Id Transaccion");
		}

		//REGISTRAR MOVIMIENTO EN INVENTARIO
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("sucursal", sucursal );
		params.put("fechaContable", formatter.format(fechaContable));
		params.put("monto", monto);
		LogHandler.trace(uid, getClass(), "==> registraOperacionInventarioCaja - registraCajaInventario ");
		sesion.selectOne("registraCajaInventario", params);

		params.put("codigo", codigo ); //*CANP*/
		params.put("contrato", numeroContrato);
		params.put("idTrxCaja", idTransaccion);
		params.put("fechaActual", formatter.format(fechaContable)); //Se indica que debe ser FECHA CONTABLE
		params.put("medioRecepcion", ConstantesPagos.PAGO_OFICINA_CENTRAL.getValue());
		params.put("usuario", usuario != null && !usuario.trim().equals( "" )
				? usuario : ConstantesPagos.USUARIO_PAGO.getValue());
		params.put("clave", mapearClaveCliente(medioPago));
		params.put("clave_produccion", medioPago);
		params.put("referencia1", " ");
		params.put("referencia2", " ");
		params.put("referencia3", idTransaccionNuevo != null ? idTransaccionNuevo : " ");
		LogHandler.trace(uid, getClass(), "==> registraOperacionInventarioCaja - registraOperacionCaja");
		sesion.selectOne("registraOperacionCaja", params);

		return idTransaccion;
	}

	private int mapearClaveCliente(String medioPago) {
		//MHM 2012-08-01 Agregar Codigo Servicio
		return Integer.valueOf( DataMapper.mapMedioPago.get(medioPago) );
		//return 0;
	}

	private void aplicarPago(String uid, SqlSession sesion, Integer idTransaccion, String numeroContrato, Double monto, Integer sucursal, Date fechaValor,
			String descripcionPago, String medioPago, String codigo, String usuario) 
	throws Exception {

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("sucursal", sucursal );
		params.put("monto", monto);
		params.put("contrato", numeroContrato);
		params.put("idTrxCaja", idTransaccion);
		params.put("fechaValor", formatter.format(fechaValor));
		params.put("medioRecepcion", ConstantesPagos.PAGO_OFICINA_CENTRAL.getValue());
		params.put("usuario", usuario == null || usuario.trim().equals("") ? ConstantesPagos.USUARIO_PAGO.getValue() : usuario );
		params.put("codigo", codigo);
		params.put("codigoServicio", medioPago == null ? "" : medioPago );
		params.put("descripcionPago", descripcionPago);
		CalculaParcialidadOV result = null;
		LogHandler.trace(uid, getClass(), "==> aplicarPago - calculaParcialidad");
		result = (CalculaParcialidadOV) sesion.selectOne("calculaParcialidad", params);

		if (result == null) {
			throw new Exception("Error al aplicar el pago");
		}
	}

	@SuppressWarnings("unchecked")
	private void aplicarAbono(SqlSession sesion, Integer idTransaccion, String numeroContrato, Double monto, 
			Integer sucursal,  Double montoLiquida,Date fechaValor, String descripcionPago, String medioPago, 
			String uid, String codigo, String usuario) throws Exception {

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("sucursal", sucursal );
		params.put("monto", monto);
		params.put("contrato", numeroContrato);
		params.put("idTrxCaja", idTransaccion);
		params.put("usuario", usuario == null || usuario.trim().equals("") ? ConstantesPagos.USUARIO_PAGO.getValue() : usuario);
		params.put("codigo", codigo);
		params.put("montoLiquida", montoLiquida);
		params.put("fechaValor", formatter.format(fechaValor));
		params.put("codigoServicio", medioPago == null ? "" : medioPago );
		params.put("descripcionPago", descripcionPago);

		for (String string : params.keySet() )
		{
			LogHandler.info(uid, getClass(), string + " -- " + params.get( string ) );
		}
		LogHandler.trace(uid, getClass(), "==> aplicarPago - anticipaAbonoFijo");
		HashMap<String, Object> result = (HashMap<String, Object>) sesion.selectOne("anticipaAbonoFijo", params);

		if (result == null) {
			throw new Exception("Error al aplicar el pago (abono)");
		}
		//LogHandler.debug("aplica abono result="+result);
	}

	private EncabezadoRespuesta generarHeader(String uid, boolean estatus, String mensaje) {
		EncabezadoRespuesta header = new EncabezadoRespuesta();
		header.setCodigo("");
		header.setMensaje(mensaje);
		header.setUID(uid);
		header.setEstatus(estatus);
		return header;
	}

	/*
	 * (non-Javadoc)
	 * @see tarea.operacion.PagosCredito#cancelarPagos(java.lang.String, org.apache.ibatis.session.SqlSession, java.util.HashMap, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.util.Date)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean cancelarPagos(String uid, SqlSession sesionTX, HashMap inicioPagos, String numeroContrato,
			String usuario, Integer idTransaccion, Integer sucursal, Date fechaContable)
		throws Exception
	{
		HashMap params = new HashMap();

		params.put("contrato", numeroContrato);
		params.put("pagoInicial", inicioPagos.get("numero_pago"));
		params.put("fechaInicial", inicioPagos.get("fecha_inicial").toString());
		params.put("fechaSistema", comun.obtenerFechaActual( uid ));
		params.put("operador", usuario != null ? usuario : "" );
		params.put("idTransaccion", idTransaccion);
		params.put("sucursal", sucursal);
		params.put("fechaContable", formatter.format(fechaContable));

		try {
			LogHandler.trace(uid, getClass(), "==> cancelarPagos - cancelarPagos ");
			String mensaje = (String) sesionTX.selectOne("cancelarPagos", params);

			if (mensaje.startsWith("Error")) {
				throw new Exception(mensaje);
			}
		} catch (Exception e) {
			//e.printStackTrace();
			LogHandler.error(uid, getClass(), e.getMessage(), e);
			throw new Exception(e.getMessage());
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see tarea.operacion.PagosCredito#cancelarPagos(java.lang.String, org.apache.ibatis.session.SqlSession, java.util.HashMap, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.util.Date)
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public boolean cancelarPagosAjusteCheque(String uid, SqlSession sesionTX, HashMap inicioPagos, String numeroContrato,
			String usuario, Integer idTransaccion, Integer sucursal, Date fechaContable)
		throws Exception
		{
		boolean exitoso = false;
		HashMap params = new HashMap();
		params.put("contrato", numeroContrato);
		params.put("pagoInicial", inicioPagos.get("numero_pago"));
		/*Se cambio la fecha, para poder mandar el dato con hr, y cancelar a partir de ese momento y no del dia*/
		params.put("fechaInicial", inicioPagos.get("fecha_inicial").toString());
		params.put("fechaSistema", comun.obtenerFechaActual( uid ));
		params.put("operador", usuario != null ? usuario : "" );
		params.put("idTransaccion", idTransaccion);
		params.put("sucursal", sucursal);
		params.put("fechaContable", formatter.format(fechaContable));

		try {
			LogHandler.trace(uid, getClass(), "==> cancelarPagos - cancelarPagos ");
			String mensaje = (String) sesionTX.selectOne("cancelarPagos", params);

			if (mensaje.startsWith("Error")) {
				throw new Exception(mensaje);
			}
			exitoso = true;
		} catch (Exception e) {
			//e.printStackTrace();
			LogHandler.error(uid, getClass(), e.getMessage(), e);
			throw new Exception(e.getMessage());
		}
		return exitoso;
		}

	public CancelarMovimientosRespuesta cancelarMovimientos(CancelarMovimientosPeticion peticion, String uid) 
		{
		//Objeto de respuesta
		final 	CancelarMovimientosRespuesta
				cancelarMovimientosRespuesta = cancelarMovimientos( peticion, null, null, uid );
		//Se responde
		return cancelarMovimientosRespuesta;
		}


	public CancelarMovimientosRespuesta cancelarMovimientos(CancelarMovimientosPeticion peticion, Integer idTransaccion, SqlSession sessionTx,  String uid) 
		{
		//Objeto de respuesta
		final 	CancelarMovimientosRespuesta
				cancelarMovimientosRespuesta = new CancelarMovimientosRespuesta();

		//Objeto para manejo de la session mybatis
		SqlSession sessionNTx = null;

		//Saber si la sesion transaccional la mandan o no
		final java.lang.Boolean traeSesion = sessionTx == null ? false : true;

		//Detalles de los pagos cancelados y aquellos que se aplicaran nuevamente
		List<HashMap<String, Object>> detallePagos		    = null;
		List<HashMap<String, Object>> detallePagosAplicables = new ArrayList<HashMap<String, Object>>();

		//Se recupera el nuemero de contrato de credprod
		peticion.setContrato( comun.obtenerNumeroContrato(uid, peticion.getContrato()) );

		//Datos del contrato
		final HashMap<String, Object>
						datosContrato = comun.obtenerDatosGeneralesContratoSimple(uid, peticion.getContrato());

		try {
			//Se valida contrato
			if (datosContrato == null || datosContrato.size() == 0 )
				{
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.contratoinvalido" ) );
				}

			//Se valida el status del contrato
			if (!datosContrato.get( "status" ).toString().equals( "D" ) && !datosContrato.get("status").toString().equals( "P" ))
				{
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.statuscontratoincorrecto" ) );
				}

			//Se valida que los datos sean correctos
			if (peticion.getTransacciones() == null || peticion.getTransacciones().size() == 0)
				{
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.datos.incompletos" ) );
				}

			//Obtener movimiento mas antiguo a cancelar
			DetalleTransaccionOV transaccionAntigua = peticion.getTransacciones().get( 0 );
			for (DetalleTransaccionOV detalleTransaccionOV : peticion.getTransacciones())
				{
				if (detalleTransaccionOV.getFechaContable().before( transaccionAntigua.getFechaContable()))
					{
					transaccionAntigua = detalleTransaccionOV;
					}
				}

			//Se recupera la fecha contable
			final FechaContableOV fechaContableOV = comun.obtenerFechaContable( uid );

			/**
			 * Obtenemos los pagos posteriores
			 */
			//Se abre la conexion
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			final SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSS");
			final HashMap<String, Object>
								params = new HashMap<String, Object>();
								params.put("contrato"	  , peticion.getContrato() );
								params.put("fecha"		  ,	simpleDateFormat.format( transaccionAntigua.getFechaContable() ) );
								params.put("fechaContable", "S" );

			LogHandler.trace(uid, getClass(), "==> cancelarMovimientos - obtenerInicioPagosPosterioresFecha");
			final HashMap<String, Object> inicioPagos
				= (HashMap<String, Object>) sessionNTx.selectOne("obtenerInicioPagosPosterioresFecha", params);

			//si existen pagos, obtener los datos de dichos pagos
			params.put("fecha", simpleDateFormat.format( (java.util.Date) inicioPagos.get( "fecha_inicial" ) ) );
			if (inicioPagos != null && inicioPagos.size() > 0)
				{
				LogHandler.trace(uid, this.getClass(), "==> cancelarMovimientos - obtenerDetallePagosPosterioresAjusteCheque");
				detallePagos = (List<HashMap<String, Object>>) sessionNTx.selectList(
							"obtenerDetallePagosPosterioresAjusteCheque", params);

				//Se obtiene el monto de los pagos
				java.lang.Double monto = 0D;
				for (HashMap<String, Object> pago : detallePagos ) {
					monto += Double.valueOf( pago.get( "monto_pago" ).toString().trim() );

					//se crea la lista con los pagos a aplicar
					java.lang.Boolean pagoValido = true;
					//iterando las transacciones
					for ( DetalleTransaccionOV detalleTransaccionOV : peticion.getTransacciones() ) {
						if ( detalleTransaccionOV.getIdTransaccion().intValue()
								== Integer.valueOf( pago.get( "idTrans" ).toString().trim() ) )
							{
							pagoValido = false;
							break;
							}
						}
					if ( pagoValido ) { detallePagosAplicables.add( pago ); }
					}

				//Quitamos condonaciones por pagos CONEXIA
				//Obtener los id transaccion de los tipos BONI
				List<Integer> idTranBONIPosiblesEliminar = new ArrayList<Integer>();
				for ( HashMap<String, Object> pagos : detallePagosAplicables ) {
					if (pagos.get("tipo_operacion").toString().trim().equals("BONI")) {
						LogHandler.info(uid, getClass(), "==> cancelarMovimientos - existen bonificaciones extras");
						idTranBONIPosiblesEliminar.add(Integer.valueOf(pagos.get("idTrans").toString()));
					}
				}

				List<Integer> idTranBONIEliminar = new ArrayList<Integer>();
				if (idTranBONIPosiblesEliminar.size() > 0) {
					for (Integer idTranPosible : idTranBONIPosiblesEliminar ) {
						for (HashMap<String, Object> pagos : detallePagosAplicables ) {

							if (pagos.get("tipo_operacion").toString().trim().equals("PAGO")
									   && pagos.get("codigoServicio").toString().trim().equals("SOLI")
									   &&   ( Integer.valueOf(pagos.get("idTrans").toString()).intValue()
											   == idTranPosible.intValue()) ) {

								LogHandler.info(uid, getClass(),
										"==> cancelarMovimientos - La condonacion pertenece a un pago de conexia= "
										+ idTranPosible);
								idTranBONIEliminar.add(idTranPosible);
							}
						}
					}
				}

				if (idTranBONIEliminar.size() > 0 ) {
					for (Iterator<HashMap<String, Object>> iterator = detallePagosAplicables.iterator(); iterator
							.hasNext();) {
						HashMap<String, Object> pago = (HashMap<String, Object>) iterator.next();
						boolean quitar = false;
						if (pago.get("tipo_operacion").toString().trim().equals("BONI")) {
							for (Integer idTran : idTranBONIEliminar) {
								if (Integer.valueOf(pago.get("idTrans").toString()).intValue() == idTran.intValue()) {
									LogHandler.info(uid, getClass(), "==> cancelarMovimientos - Eliminacion de la lista"
											+ idTranBONIEliminar);
									quitar = true;
								}
							}
						}
						if (quitar) {
							iterator.remove();
						}
					}
				}

				//Mapear el medio de pago
				for (HashMap<String, Object> pagos : detallePagosAplicables ) {
					boolean codigoServicio = false;
							if (pagos.get("codigoServicio").toString().equals("SOLI")) {

								pagos.put("codigoServicio", pagos.get("codigoServicio").toString() + "_");
								LogHandler.info(uid, getClass(), "==> cancelarMovimientos - codigoServicio CAMBIO= "
										+  pagos.get("codigoServicio").toString());
							} else 	if (	pagos.get("codigoServicio").toString().equals("GBMX")
									|| pagos.get("codigoServicio").toString().equals("GBCM")
									|| pagos.get("codigoServicio").toString().equals("GHSB")
									|| pagos.get("codigoServicio").toString().equals("DIES")) {

								pagos.put("codigoServicio", pagos.get("codigoServicio").toString() + "_");
								LogHandler.info(uid, getClass(), "==> cancelarMovimientos - codigoServicio CAMBIO= "
										+  pagos.get("codigoServicio").toString());
								codigoServicio = true;
							}

							if ( !codigoServicio ) {
								pagos.put( "codigoServicio", mapearMedioPago( pagos.get("codigoServicio").toString() ) );
							}
							LogHandler.info(uid, getClass(), "==> cancelarMovimientos - codigoServicio = "
									+  pagos.get("codigoServicio").toString());
					}

				//Comienza secci�n transaccional
					{
					if ( !traeSesion ) {
						sessionTx = FabricaConexiones.obtenerSesionTx();
					}

					//Se obtiene el id de transaccion para la cancelacion, en caso de ser necesario
					if ( idTransaccion == null || idTransaccion == 0 ) {
						idTransaccion =	registraOperacionInventarioCaja(uid, sessionTx, peticion.getContrato(), monto,
									Integer.valueOf( datosContrato.get( "sucursal" ).toString() ), "TRPG",
									fechaContableOV.getFecha(),	idTransaccion, peticion.getTipoMovimiento(),
									peticion.getUsuario() , null);
					}

					//se cancelan los movimientos
					if (!cancelarPagos(uid, sessionTx, inicioPagos, peticion.getContrato(), peticion.getUsuario(), idTransaccion,
						(Integer) datosContrato.get("sucursal"), fechaContableOV.getFecha()))
						{
						throw new Exception(ReadProperties.mensajes.getProp("ciof.error.cancelarpagos"));
						}

					//Se realiza un commit para efectuar la cancelacion
					//sessionTx.commit( true );
					//si se cancelaron pagos, se vuelven a aplicar
					/**
					 * Se debe aplicar cada pago con mismo codigo de servicio y por cada pago generar un idtrx
					 */
					if ( inicioPagos != null && inicioPagos.size() > 0 ) {
						aplicarPagos( uid, sessionTx, detallePagosAplicables, peticion.getContrato(), fechaContableOV.getFecha(),
								Integer.valueOf( datosContrato.get( "sucursal" ).toString() ), peticion.getUsuario() );
					}

					//Se aplican los cambios solo de ser necesario
					if ( !traeSesion ) {
						sessionTx.commit( true );
						LogHandler.info(uid, getClass(), "cancelarMovimientos - commit realizado.");
					}
				  } //Fin secci�n transaccional
				}
			}
		catch ( java.lang.Exception exception )
			{
			//Se aplica el rollback solo de ser necesario
			if ( !traeSesion && sessionTx != null ) {
				sessionTx.rollback();
				LogHandler.debug(uid, getClass(), "... ROLLBACK - realizado");
			}

			cancelarMovimientosRespuesta.getHeaderRespuesta().setEstatus( false );
			cancelarMovimientosRespuesta.getHeaderRespuesta().setUID( uid );
			cancelarMovimientosRespuesta.getHeaderRespuesta().setMensaje( exception.getMessage() );
			LogHandler.error(uid, getClass(), "Error al cancelarMovimientos el pago : " + peticion.getContrato() + " - " + exception.getMessage(),exception );
			}
		finally
			{
			if ( !traeSesion )
				{
				FabricaConexiones.close( sessionTx );
				}
			FabricaConexiones.close( sessionNTx );
			}

		return cancelarMovimientosRespuesta;
		}
	public TraspasarPagoRespuesta traspasarPago(TraspasarPagoPeticion peticion,	String uid) 
		{
		//Objeto de respuesta
		final 	TraspasarPagoRespuesta
				traspasarPagoRespuesta = new TraspasarPagoRespuesta();

		//Datos de los contratos destino
		final java.util.List<java.util.HashMap<String, Object>>
										datosContratosDestino = new java.util.ArrayList<HashMap<String, Object>>();

		//Objeto para manejo de la session mybatis
		SqlSession sessionTx  = null;

		try {
			//Se transforma en contrato credprod, el contrato origen
			peticion.setContrato( comun.obtenerNumeroContrato( uid, peticion.getContrato() ) );

			//Se recuperan los datos de los contratos destino
			for ( TraspasarPagoOV traspasarPagoOV : peticion.getPagos() )
				{
				//Se transforma en contrato credprod, el contrato destino
				traspasarPagoOV.setContratoDestino( comun.obtenerNumeroContrato( uid, traspasarPagoOV.getContratoDestino() ) );

				final HashMap<String,Object> datosContrato = comun.obtenerDatosGeneralesContrato(uid, traspasarPagoOV.getContratoDestino() );

				if( datosContrato.get( "status" ).toString().equals( "D" ) || datosContrato.get( "status" ).toString().equals( "P" ) )
					{
					datosContratosDestino.add( datosContrato );
					}
				else
					{
					//Si alguno de los contratos destino no esta en el status adecuado se arroja un error
					throw new Exception( ReadProperties.mensajes.getProp( "operacion.transferirpago.contratosinvalidos" ) );
					}
				}
			//Datos del contrato origen
			final HashMap<String, Object> datosContrato = comun.obtenerDatosGeneralesContrato( uid, peticion.getContrato() );

			//fecha contable
			final FechaContableOV fechaContableOV = comun.obtenerFechaContable( uid );

			//Se obtiene el total del monto a aplicar
			java.lang.Double montoTotal = 0D;
			for ( TraspasarPagoOV traspasarPagoOV : peticion.getPagos() ) {
				montoTotal += traspasarPagoOV.getMontoPago();
			}

			//monto cancelar
			java.lang.Double montoCancelar = 0D;
			for ( DetalleTransaccionOV detalleTransaccionOV : peticion.getTransacciones() ) {
				montoCancelar += detalleTransaccionOV.getMontoCancelacion();
			}

			//Se comparan los montos.
			if ( montoTotal.doubleValue() != montoCancelar.doubleValue() ) {
				throw new Exception( ReadProperties.mensajes.getProp( "operacion.transferirpago.montoincorrectos" ) );
			}

			//Inicia secci�n transaccional
				{	
				//Se abre la session transaccional
				sessionTx = FabricaConexiones.obtenerSesionTx();
				
				//Se registra en auditoria cajas, por el monto total de los pagos a transferir
				final Integer idTransaccion = registraOperacionInventarioCaja(uid, sessionTx, peticion.getContrato(), montoTotal, Integer.valueOf( datosContrato.get( "sucursal" ).toString().trim() ),
												"TRPG", fechaContableOV.getFecha(), 0, "TRPG", peticion.getUsuario(), null);
				
				//Se cancelan los pagos
				CancelarMovimientosRespuesta cancelarMovimientosRespuesta = new CancelarMovimientosRespuesta();
											 cancelarMovimientosRespuesta.getHeaderRespuesta().setEstatus( false );
				
				final CancelarMovimientosPeticion 
								peticionCancelacion = new CancelarMovimientosPeticion();
								peticionCancelacion.setContrato		 ( peticion.getContrato() );
								peticionCancelacion.setTransacciones ( peticion.getTransacciones() );
								peticionCancelacion.setUsuario		 ( peticion.getUsuario() );

				cancelarMovimientosRespuesta = cancelarMovimientos( peticionCancelacion, idTransaccion, sessionTx, uid );

				if( !cancelarMovimientosRespuesta.getHeaderRespuesta().isEstatus() )
					{
					throw new Exception( cancelarMovimientosRespuesta.getHeaderRespuesta().getMensaje() );
					}

				//Se aplican los pagos
				PagoGrupalResponse pagoGrupalResponse = new PagoGrupalResponse();
								   pagoGrupalResponse.getHeader().setEstatus( false );

				for( TraspasarPagoOV traspasarPagoOV : peticion.getPagos() )
					{
					final PagoGrupal
							pagoGrupal = new PagoGrupal();
							pagoGrupal.setFechaValor( traspasarPagoOV.getFechaValorPago() );
							pagoGrupal.setCodigo( "PREF" );
							pagoGrupal.setMedioPago( traspasarPagoOV.getCodigoServicio() );
							pagoGrupal.setIdPago( 0 );
							pagoGrupal.setMonto( traspasarPagoOV.getMontoPago() );
							pagoGrupal.setNumeroContrato( traspasarPagoOV.getContratoDestino() );
							pagoGrupal.setTipoPago( traspasarPagoOV.getTipoAplicar() );
							pagoGrupal.setUsuario( peticion.getUsuario() );
							pagoGrupal.setReferencia( "Trasp pago: " + peticion.getContrato() + " " + traspasarPagoOV.getCodigoServicio().replace("_", "") + " " + traspasarPagoOV.getMontoPago() );

					pagoGrupalResponse = aplicarPagoGrupal(uid, sessionTx, idTransaccion, pagoGrupal);

					//Si algun pago tuvo error se hace el rollback
					if( !pagoGrupalResponse.getHeader().isEstatus() )
						{
						throw new Exception( pagoGrupalResponse.getHeader().getMensaje() );
						}
					}

				//Se ejecuta el commit
				sessionTx.commit( true );
				}
			}
		catch( java.lang.Exception exception )
			{
			//Se aplica el rollback
			if( sessionTx != null ) { sessionTx.rollback(); }

			traspasarPagoRespuesta.getHeaderRespuesta().setEstatus( false );
			traspasarPagoRespuesta.getHeaderRespuesta().setUID	( uid );
			traspasarPagoRespuesta.getHeaderRespuesta().setMensaje( exception.getMessage() );
			LogHandler.error(uid, getClass(), "Error al traspasar pagos : " + peticion.getContrato() + " - " + exception.getMessage(), exception );
			}
		finally
			{
			FabricaConexiones.close( sessionTx );
			}
		return traspasarPagoRespuesta;
		}

/**
 * @param uid identificador unico de la transaccion
 * @param peticion contiene los datos para aplicar el pago Grupal
 * @return AplicarPagoRespuesta el resultado de aplicar el pago.
 */
	public AplicarPagoRespuesta aplicarPagoGrupalOperaciones(AplicarPagoPeticion peticion, SqlSession sesionTx, String uid) {

			final AplicarPagoRespuesta aplicarPagoRespuesta = new AplicarPagoRespuesta();

			try
			{
			//Validacion de usuario
			if ( peticion.getUsuario() == null ||  peticion.getUsuario().trim().length() == 0) {
				LogHandler.debug(uid, this.getClass(), " ERROR: Usuario Incorrecto: " + peticion.getUsuario());
				aplicarPagoRespuesta.setHeader(generarHeader(uid, false, "Usuario Incorrecto"));
				return aplicarPagoRespuesta;
			}

			//Validacion de tipo aplicacion

			if (!( peticion.getTipoAplicacion().trim().equals("ABO") || peticion.getTipoAplicacion().trim().equals("NORM")) ) {
				LogHandler.debug(uid, this.getClass(), " ERROR: Tipo Aplicacion Incorrecto: " + peticion.getTipoAplicacion());
				aplicarPagoRespuesta.setHeader(generarHeader(uid, false, "Tipo Aplicacion  Incorrecto"));
				return aplicarPagoRespuesta;
			}

			//Validacion de medio de pago
			if ( peticion.getMedioPago().length() != 4 ) {
				LogHandler.debug(uid, this.getClass(), " ERROR: Medio de Pago Incorrecto: " + peticion.getMedioPago());
				aplicarPagoRespuesta.setHeader(generarHeader(uid, false, "Medio de Pago Incorrecto"));
				return aplicarPagoRespuesta;
			}

			if (peticion.isBanderaMedioClaveCliente()) {
				peticion.setMedioPago(peticion.getMedioPago() + "_");
			}

			final PagoGrupal pago = new PagoGrupal();
			pago.setMonto(peticion.getMonto());
			pago.setNumeroContrato(peticion.getNumeroContrato());
			pago.setFechaValor(peticion.getFechaValor());
			pago.setMedioPago(peticion.getMedioPago());
			pago.setReferencia(peticion.getReferencia());
			pago.setTipoPago(peticion.getTipoAplicacion());
			pago.setUsuario(peticion.getUsuario());
			pago.setCodigo(ConstantesPagos.PAGO_REFERENCIADO.getValue());

			//Inserta el numero de folio para OXXO
			if (peticion.getIdTransaccion() != null) {
				pago.setIdTransaccionValida(peticion.getIdTransaccion());
			}

			PagoGrupalResponse pagoResponse = new PagoGrupalResponse();
			pagoResponse = aplicarPagoGrupal(uid, sesionTx, null, pago);
			LogHandler.debug(uid, this.getClass(), "pagoResponse=" + pagoResponse);
			if ( !pagoResponse.getHeader().isEstatus()) {
				throw new Exception(pagoResponse.getHeader().getMensaje());
			}
			else {
				aplicarPagoRespuesta.setHeader(pagoResponse.getHeader());
				aplicarPagoRespuesta.setIdTransaccion(pagoResponse.getIdTransaccion());
				aplicarPagoRespuesta.setPromesaLiquidacion(pagoResponse.isPromesaLiquidacion());
			}

			}
			catch (Exception e) {
				LogHandler.error(uid, this.getClass(), " ERROR: Error al aplicar el pago "
						+ peticion.getNumeroContrato() + " - " + e.getMessage(), e );
				aplicarPagoRespuesta.setHeader(generarHeader(uid, false, e.getMessage()));
				return aplicarPagoRespuesta;
			}

			aplicarPagoRespuesta.setHeader(generarHeader(uid, true, "Pago realizado correctamente"));
			return aplicarPagoRespuesta;

		}


	public ActaRecaudacionRespuesta capturaActaRecaudacion(ActaRecaudacionPeticion peticion, String uid) {
		final ActaRecaudacionRespuesta respuesta = new ActaRecaudacionRespuesta();
		ActaRecaudacionOV acta = null;
		SqlSession sesion = null;

		try {
			sesion = FabricaConexiones.obtenerSesionTx();

			if (peticion.getActaRecaudacion() == null) {
				throw new Exception(ReadProperties.mensajes.getProp("operacion.actas.recaudacion.sin.parametros")
						+ "ActaRecaudacion=" + peticion.getActaRecaudacion());
			}

			/** Validamos que exista el Acta de Recaudaci�n. */
			acta = peticion.getActaRecaudacion();
			if ((acta.getContrato() == null || acta.getContrato().isEmpty()) &&
					(acta.getContratoLD() == null || acta.getContratoLD().isEmpty())) {
				throw new Exception(ReadProperties.mensajes.getProp("operacion.actas.recaudacion.sin.parametros")
						+ "ActaRecaudacion.contrato=" + acta.getContrato() + " y/o ActaRecaudacion.contratoLD="
						+ acta.getContrato());
			}

			if (acta.getContratoLD() != null) {
				/** Obtenemos el Contrato a partir del LD.*/
				acta.setContrato(comun.obtenerNumeroContrato(uid, acta.getContratoLD()));
			}

			if (acta.getContrato() == null || acta.getContrato().isEmpty()) {
				throw new Exception(ReadProperties.mensajes.getProp("operacion.actas.recaudacion.sin.parametros")
						+ "ActaRecaudacion.contrato=" + acta.getContrato());
			}

			/** Recorremos cada Parcialidad. */
			if (acta.getParcialidades() != null && !acta.getParcialidades().isEmpty()) {
				LogHandler.trace(uid, getClass(), "Parcialidades=" + acta.getParcialidades());

				Iterator<ActaRecaudacionParcialidadOV> parcialidades = acta.getParcialidades().iterator();
				while (parcialidades.hasNext()) {
					ActaRecaudacionParcialidadOV parcialidad = parcialidades.next();
					if (parcialidad.getNoPago() == null) {
						throw new Exception(ReadProperties.mensajes.getProp("operacion.actas.recaudacion.sin.parametros")
								+ "Parcialidad.noPago=" + parcialidad.getNoPago());
					}

					/** Recorremos cada Cliente. */
					if (parcialidad.getClientes() != null && !parcialidad.getClientes().isEmpty()) {
						LogHandler.trace(uid, getClass(), "Clientes=" + parcialidad.getClientes());

						Iterator<ActaRecaudacionClienteOV> clientes = parcialidad.getClientes().iterator();
						while (clientes.hasNext()) {
							ActaRecaudacionClienteOV cliente = clientes.next();
							final HashMap<String, Object> parametros = new HashMap<String, Object>();
							parametros.put("contrato", acta.getContrato());
							parametros.put("noPago", parcialidad.getNoPago());
							if (cliente.getIntegrante() != null && !cliente.getIntegrante().isEmpty()) {
								parametros.put("integrante", cliente.getIntegrante());
							} else {
								throw new Exception(ReadProperties.mensajes.getProp("operacion.actas.recaudacion.sin.parametros")
										+ "Cliente.integrante=" + cliente.getIntegrante());
							}

							LogHandler.trace(uid, getClass(), " ==> capturaActaRecaudacion - generaActarecaudacion");
							ActaRecaudacionOV actaRecaudacionOV
								= (ActaRecaudacionOV) sesion.selectOne("generaActarecaudacion", parametros);

							/** Terminamos de llenar los par&aacute;metros. */
							if (acta.getSucursal() != null) {
								parametros.put("sucursal", acta.getSucursal());
							}
							if (acta.getUsuarioImprime() != null && !acta.getUsuarioImprime().isEmpty()) {
								parametros.put("usuarioImprime", acta.getUsuarioImprime());
							}
							if (acta.getNumImprime() != null) {
								parametros.put("numImprime", acta.getNumImprime());
							}
							if (acta.getFechaImprime() != null && !acta.getFechaImprime().toString().isEmpty()) {
								parametros.put("fechaImprime", acta.getFechaImprime());
							}
							if (parcialidad.getFechaPactadaPago() != null
									&& !parcialidad.getFechaPactadaPago().toString().isEmpty()) {
								parametros.put("fechaPactadaPago", parcialidad.getFechaPactadaPago());
							}
							if (parcialidad.getPersonaRecauda() != null && !parcialidad.getPersonaRecauda().isEmpty()) {
								parametros.put("personaRecauda", parcialidad.getPersonaRecauda());
							}
							if (parcialidad.getObservaciones() != null && !parcialidad.getObservaciones().isEmpty()) {
								parametros.put("observaciones", parcialidad.getObservaciones());
							}
							if (parcialidad.getFechaCaptura() != null && !parcialidad.getFechaCaptura().toString().isEmpty()) {
								parametros.put("fechaCaptura", parcialidad.getFechaCaptura());
							}
							if (parcialidad.getUsuarioCaptura() != null && !parcialidad.getUsuarioCaptura().isEmpty()) {
								parametros.put("usuarioCaptura", parcialidad.getUsuarioCaptura());
							}
							if (parcialidad.getNumeroActualizacion() != null) {
								parametros.put("numeroActualizacion", parcialidad.getNumeroActualizacion());
							}
							if (cliente.getMontoPago() != null) {
								parametros.put("montoPago", cliente.getMontoPago());
							}
							if (cliente.getMontoRecibido() != null) {
								parametros.put("montoRecibido", cliente.getMontoRecibido());
							}
							if (cliente.getMontoSolidario() != null) {
								parametros.put("montoSolidario", cliente.getMontoSolidario());
							}
							if (cliente.getAsistenciaIntegrante() != null && !cliente.getAsistenciaIntegrante().isEmpty()) {
								parametros.put("asistenciaIntegrante", cliente.getAsistenciaIntegrante());
							}

							if (actaRecaudacionOV != null) {
								/** En caso de que exista, actualizamos la Parcialidad. */
								LogHandler.trace(uid, getClass(), "==> capturaActaRecaudacion - actualizarParcialidad");
								sesion.update("actualizarParcialidad", parametros);
							} else {
								/** Sino existe, agregamos la Parcialidad. */
								LogHandler.trace(uid, getClass(), "==> capturaActaRecaudacion - agregarParcialidad");
								sesion.insert("agregarParcialidad", parametros);
							}

							//Se actualiza el campo de Ahorro en caso de ser necesario
							if( peticion.getActaRecaudacion().getParcialidades().get( 0 ).getClientes().get( 0 ).getSaldoAhorro() != null &&
								peticion.getActaRecaudacion().getParcialidades().get( 0 ).getClientes().get( 0 ).getSaldoAhorro() != 0 )
								{
								for( ActaRecaudacionParcialidadOV actaRecaudacionParcialidadOV : peticion.getActaRecaudacion().getParcialidades() )
									{
									for ( ActaRecaudacionClienteOV actaRecaudacionClienteOV : actaRecaudacionParcialidadOV.getClientes() )
										{
										final java.util.HashMap<String, Object>
													parametrosActualizaAhorro = new HashMap<String, Object>();
													parametrosActualizaAhorro.put( "contrato" , peticion.getActaRecaudacion().getContrato() );
													parametrosActualizaAhorro.put( "integrante", actaRecaudacionClienteOV.getIntegrante() );
													parametrosActualizaAhorro.put( "saldoAhorro" , actaRecaudacionClienteOV.getSaldoAhorro() );
										LogHandler.trace( uid, getClass(), "==> capturaActaRecaudacion - actualizaSaldoAhorro" );
										sesion.update( "actualizaSaldoAhorro", parametrosActualizaAhorro );
										}
									}
								}
						}
					} else {
						throw new Exception(ReadProperties.mensajes.getProp("operacion.actas.recaudacion.sin.parametros")
								+ "Clientes=" + parcialidad.getClientes());
					}
				}
			} else {
				throw new Exception(ReadProperties.mensajes.getProp("operacion.actas.recaudacion.sin.parametros")
						+ "Parcialidades=" + acta.getParcialidades());
			}

			sesion.commit();
			respuesta.setHeader(generarHeader(uid, true, "Captura de Acta de Recaudaci�n Correcta"));
		} catch (Exception e) {
			LogHandler.error(uid, getClass(), e.getMessage(), e);
			if (sesion != null) {
				sesion.rollback();
			}
			respuesta.setHeader(generarHeader(uid, false, e.getMessage()));
		} finally {
			FabricaConexiones.close(sesion);
		}

		return respuesta;
	}

	//Fuciones privadas  --------------------------------------------------------------------------------------------
	@SuppressWarnings("unchecked")
	private void aplicarPagos( String uid, SqlSession sessionTx, List<HashMap<String,Object>> detallePagos, 
							   String numeroContrato, java.util.Date fachaContable, Integer sucursal, String usuario) throws Exception 
		{
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "dd-MM-yyyy" );

		//BUG ibatis, puede ser con la configuracion localCacheScope=STATEMENT
		int contador = 0;

		for ( HashMap<String, Object> detallePago : detallePagos ) {
			final Integer
				  idTransaccion = comun.obtenerIdTransaccion( uid, sucursal, fachaContable );

			final PagoGrupal
						pago = new PagoGrupal();
						pago.setMonto(((BigDecimal) detallePago.get("monto_pago")).doubleValue());
						pago.setNumeroContrato(numeroContrato);

			java.util.Date fechaValor = null;
			try {
				fechaValor =  simpleDateFormat.parse( detallePago.get("fecha_valor").toString() );

				pago.setFechaValor( fechaValor );
				pago.setMedioPago ( detallePago.get("tipo_operacion").toString().equals("BONI") ? "" : detallePago.get("codigoServicio").toString() ); //ConstantesPagos.MEDIO_RECEPCION_FSOL.getValue() );

				if (detallePago.get("tipo_operacion").toString().equals("BONI")) {
					pago.setCodigo(ConstantesPagos.PAGO_BONIFICACION.getValue());
				}
				else {
					pago.setCodigo(ConstantesPagos.PAGO_REFERENCIADO.getValue());
				}

				pago.setReferencia(detallePago.get("referencia").toString());
				pago.setUsuario( usuario );

				/*
				 * Verificar si es CONEXIA bonificar los moratorios
				 */

				if (pago.getMedioPago().trim().equals("CXIA")) {

					//Se realiza la condonacion de los moratorios
					LogHandler.info(uid, getClass(), "CXIA Calculo monto condonar moratorios");
					Double montoCondonarMoratorios = 0d;
					Double montoPagoSinMoratorios = 0d;
					//BUG ibatis no arroja la llamada si detecta que es la misma llamada
					LogHandler.trace(uid, getClass(), " ==> aplicarPagos - obtenerVencido");
					String espacios = "";
					for (int i = 0; i < contador; i++) {
						espacios = espacios + " ";
					}

					LogHandler.info(uid, getClass(), "ESPACIOS[" + espacios + "]");

					List<HashMap<String,Object>> detallePagosVencidos
						= (List<HashMap<String,Object>>) sessionTx.selectList("obtenerVencido", numeroContrato + espacios );

					if (detallePagosVencidos != null ) {
						for (HashMap<String, Object> pagoVencido : detallePagosVencidos ) {
							Double capital = 0d;
							Double interes = 0d;
							capital = Double.parseDouble( pagoVencido.get("p_capital").toString() );
							interes = Double.parseDouble( pagoVencido.get("p_interes").toString() );
							montoPagoSinMoratorios += capital +  interes;

							if ( montoPagoSinMoratorios >  pago.getMonto() ) {
								montoCondonarMoratorios += Double.parseDouble( pagoVencido.get("p_moratorio").toString() );
								break;
							}
							else {
								montoCondonarMoratorios += Double.parseDouble( pagoVencido.get("p_moratorio").toString() );
							}
							LogHandler.info(uid, getClass(), "montoCondonarMoratorios=" + montoCondonarMoratorios);
						}

						contador++;

					} else {
						throw new Exception("No es posible obtener los pagos vencidos del credito actual.");
					}

					LogHandler.info(uid, getClass(), "montoCondonarMoratorios=" + montoCondonarMoratorios);

					//montoCondonarMoratorios = 0.00;

					if (montoCondonarMoratorios > 0) {
						HashMap<String, Object> resultadoCondonacion;
						HashMap<String, Object> parametroscondonacion = new HashMap<String, Object>( );
						parametroscondonacion.put("contrato", numeroContrato );
						parametroscondonacion.put("montoCondonar", montoCondonarMoratorios);
						parametroscondonacion.put("tipo", "BOLI");
						parametroscondonacion.put("idTrxCaja", idTransaccion);
						parametroscondonacion.put( "sucursal", sucursal );
						parametroscondonacion.put( "descripcion", "" );

						LogHandler.trace(uid, getClass(), " ==> aplicarPagos - bonificaMora");
						resultadoCondonacion
							= (HashMap<String, Object>) sessionTx.selectOne( "bonificaMora", parametroscondonacion );

						if ( !(resultadoCondonacion != null
								&& Integer.parseInt(resultadoCondonacion.get("resultado").toString()) == 0 )) {

							throw new Exception("Error en la aplicacion de la condonacion de moratorios.");
						}
					}

				}
				final PagoGrupalResponse pagoGrupalResponse = aplicarPagoGrupal(uid, sessionTx, idTransaccion, pago);

				   if ( !pagoGrupalResponse.getHeader().isEstatus() ) {
					throw new Exception( pagoGrupalResponse.getHeader().getMensaje() );
				   }
				}
			catch ( java.lang.Exception exception )	{
				FabricaConexiones.rollBack( sessionTx );
				LogHandler.error(uid, getClass(), "Fallo aplicacion de pago.", exception );
				LogHandler.debug(uid, getClass(), "... ROLLBACK - realizado");
				throw new Exception( exception.getMessage() );
				}
			}
		}

	@SuppressWarnings("unchecked")
	public AplicarPagoRespuesta aplicarPagoGrupalConexia(AplicarPagoConexiaPeticion peticion, String uid) {

		AplicarPagoRespuesta aplicarPagoRespuesta = new AplicarPagoRespuesta();
		aplicarPagoRespuesta.setHeader(new EncabezadoRespuesta());
		aplicarPagoRespuesta.getHeader().setEstatus(true);
		aplicarPagoRespuesta.getHeader().setUID(uid);

		SqlSession sesion = null;
		SqlSession sesionNTx = null;

		try {

			if (peticion.getNumeroContrato() == null || peticion.getNumeroContrato().isEmpty()) {
				throw new Exception("Numero de contrato no valido, es obligatorio.");
			}

			if (peticion.getNumeroIntegrante() == null || peticion.getNumeroIntegrante().isEmpty()) {
				throw new Exception("Numero de cliente no valido, es obligatorio.");
			}

			if (peticion.getMedioPago() == null || peticion.getMedioPago().isEmpty()) {
				throw new Exception("Medio de pago no valido, es obligatorio.");
			}

			if (peticion.getMonto() == null || peticion.getMonto() <= 0 ) {
				throw new Exception("Monto de la peticion no valido.");
			}

			//Se obtiene numero de contrato credprod
			peticion.setNumeroContrato(comun.obtenerNumeroContrato(uid, peticion.getNumeroContrato()));

			if (peticion.getNumeroContrato() == null || peticion.getNumeroContrato().isEmpty()) {
				throw new Exception("Numero de contrato no valido.");
			}

			//Se valida el contrato
			final HashMap<String, Object>
							datosContrato = comun.obtenerDatosGeneralesContrato(uid, peticion.getNumeroContrato() );

			//Se valida contrato
			if ( datosContrato == null || datosContrato.size() == 0 ) {
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.contratoinvalido" ) );
			}

			//Se valida el status del contrato
			if ( !datosContrato.get( "status" ).toString().equals( "D" )  ) {
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.statuscontratoincorrecto" ) );
			}

			//fecha contable
			final FechaContableOV fechaContableOV = comun.obtenerFechaContable( uid );

			//Sesion No Transaccional
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			final java.util.HashMap<String , Object>  parametros = new java.util.HashMap<String , Object>();

			//Se valida que el integrante pertenezca al contrato
			parametros.put("contrato", peticion.getNumeroContrato());
			parametros.put("integrante", peticion.getNumeroIntegrante());
			LogHandler.trace(uid, getClass(), "==> aplicarPagoGrupalConexia - validaIntegranteContrato" );
			final HashMap<String, Object> integranteGrupo
				= (HashMap<String, Object>) sesionNTx.selectOne("validaIntegranteContrato", parametros);
 
			if (integranteGrupo == null || integranteGrupo.size() < 1) {
				throw new Exception( "El integrante no pertence al contrato." );
			}

			//Se valida que el integrante tenga un convenio contrato
			parametros.clear();
			parametros.put("contrato", peticion.getNumeroContrato());
			parametros.put("integrante", peticion.getNumeroIntegrante());
			parametros.put("status", "D" );
			LogHandler.trace(uid, getClass(), "==> aplicarPagoGrupalConexia - obtieneDatosConvenio" );
			final HashMap<String, Object> datosConvenio
				= (HashMap<String, Object>) sesionNTx.selectOne("obtieneDatosConvenio", parametros);
			if (datosConvenio == null || datosConvenio.size() < 1) {
				throw new Exception( "El integrante no tiene un convenio activo." );
			}

			parametros.clear();
			parametros.put("contrato", peticion.getNumeroContrato());
			parametros.put("fechaActual", ( new SimpleDateFormat( "yyyy-MM-dd" ) ).format(fechaContableOV.getFecha( ) ) );

			//Se obtiene el saldo  del credito
			/*LogHandler.trace(uid, getClass(), "==> aplicarPagoGrupalConexia - obtenerSaldoFv" );
			final CreditoSaldo saldoFV = (CreditoSaldo)sesionNTx.selectOne("obtenerSaldoFv", parametros);
			LogHandler.debug(uid, getClass(), "Dias de atraso : " + saldoFV.getDiasAtraso() );
			if( saldoFV.getDiasAtraso() < 89 ) {
				throw new Exception( "El contrato no cumple con los dias de atraso." );
			}*/
			//Se obtiene el ID de transaccion, util para mantener un control del proceso
			Integer idTransaccion = comun.obtenerIdTransaccion(uid, Integer.valueOf(datosContrato.get("sucursal").toString()),
									fechaContableOV.getFecha( ));

			//Sesion Transaccional
			sesion = FabricaConexiones.obtenerSesionTx();

			peticion.setMedioPago("CXIA");

			//Se registra en auditoria cajas, por el monto total de los pagos a transferir
			idTransaccion = registraOperacionInventarioCaja(uid, sesion, peticion.getNumeroContrato(), peticion.getMonto(), Integer.valueOf( datosContrato.get( "sucursal" ).toString().trim() ),
				   mapearMedioPago(peticion.getMedioPago()), fechaContableOV.getFecha(), idTransaccion, ConstantesPagos.PAGO_REFERENCIADO.getValue(), peticion.getUsuario(), null);								
			//Se realiza la condonacion de los moratorios 
			LogHandler.debug(uid, getClass(), "Calculo monto condonar moratorios");
			Double montoCondonarMoratorios = 0d;
			Double montoPagoSinMoratorios = 0d;
			List<HashMap<String, Object>> detallePagosVencidos
				= (List<HashMap<String, Object>>) sesionNTx.selectList("obtenerVencido", peticion.getNumeroContrato() );
			if (detallePagosVencidos != null ) {
				for (HashMap<String, Object> pagoVencido : detallePagosVencidos ) {
					Double capital = 0d;
					Double interes = 0d;
					capital = Double.parseDouble( pagoVencido.get("p_capital").toString() );
					interes = Double.parseDouble( pagoVencido.get("p_interes").toString() );
					montoPagoSinMoratorios += capital +  interes;

					if ( montoPagoSinMoratorios >  peticion.getMonto() ) {
						montoCondonarMoratorios += Double.parseDouble( pagoVencido.get("p_moratorio").toString() );
						break;
					}
					else {
						montoCondonarMoratorios += Double.parseDouble( pagoVencido.get("p_moratorio").toString() );
					}
					LogHandler.debug(uid, getClass(), "montoCondonarMoratorios=" + montoCondonarMoratorios);
				}
			} else {
				throw new Exception("No es posible obtener los pagos vencidos del credito actual.");
			}

			LogHandler.debug(uid, getClass(), "montoCondonarMoratorios=" + montoCondonarMoratorios);

			//montoCondonarMoratorios = 0.00;

			if (montoCondonarMoratorios > 0) {
				HashMap<String, Object> resultadoCondonacion;
				HashMap<String, Object> parametroscondonacion = new HashMap<String, Object>( );
				parametroscondonacion.put("contrato", peticion.getNumeroContrato() );
				parametroscondonacion.put("montoCondonar", montoCondonarMoratorios);
				parametroscondonacion.put("tipo", "BOLI");
				parametroscondonacion.put("idTrxCaja", idTransaccion);
				parametroscondonacion.put( "sucursal", Integer.valueOf(datosContrato.get("sucursal").toString())  );
				parametroscondonacion.put( "descripcion", "" );

				resultadoCondonacion = (HashMap<String, Object>) sesion.selectOne( "bonificaMora", parametroscondonacion );

				if ( !(resultadoCondonacion != null && Integer.parseInt(resultadoCondonacion.get("resultado").toString()) == 0 )) {

					throw new Exception("Error en la aplicacion de la condonacion de moratorios.");
				}
			}
			//Se aplica el pago a la cartera
			final PagoGrupal pago = new PagoGrupal();
			pago.setMonto(peticion.getMonto());
			pago.setNumeroContrato(peticion.getNumeroContrato());
			pago.setFechaValor( null );
			pago.setMedioPago(peticion.getMedioPago());
			pago.setReferencia( peticion.getNumeroIntegrante());
			pago.setTipoPago("NORM");
			pago.setUsuario(peticion.getUsuario());
			pago.setCodigo(ConstantesPagos.PAGO_REFERENCIADO.getValue());
			pago.setSucursal(Integer.valueOf(datosContrato.get("sucursal").toString()) );
			PagoGrupalResponse pagoResponse = new PagoGrupalResponse();
			pagoResponse = aplicarPagoGrupal(uid, sesion, idTransaccion, pago);

			if ( !pagoResponse.getHeader().isEstatus()) {
				throw new Exception(pagoResponse.getHeader().getMensaje());
			}
			aplicarPagoRespuesta.setHeader(pagoResponse.getHeader());
			aplicarPagoRespuesta.setIdTransaccion(pagoResponse.getIdTransaccion());
			aplicarPagoConvenio(uid, sesion, peticion, datosConvenio);
			LogHandler.debug(uid, getClass(), "COMMIT!!!! ");
			sesion.commit(true);
		}
		catch (Exception ex) {
			FabricaConexiones.rollBack( sesion );
			aplicarPagoRespuesta.getHeader().setEstatus(false);
			aplicarPagoRespuesta.getHeader().setUID(uid);
			aplicarPagoRespuesta.getHeader().setMensaje(ex.getMessage());
			LogHandler.error(uid, getClass(), "Error en aplicarPagoGrupalConexia().", ex);
		}
		finally {
			FabricaConexiones.close(sesion);
			FabricaConexiones.close(sesionNTx);
		}
		return aplicarPagoRespuesta;

	}

	@SuppressWarnings("unchecked")
	private void aplicarPagoConvenio( String uid, SqlSession sesion, AplicarPagoConexiaPeticion peticion, HashMap<String,Object> datosConvenio) throws Exception {
		
		final java.util.HashMap<String , Object>  parametros = new java.util.HashMap<String , Object>();
		Integer numeroConvenio = Integer.parseInt( datosConvenio.get("numero_convenio").toString() );
		parametros.put( "numero_convenio", numeroConvenio); 
		LogHandler.trace(uid, getClass(), "==> aplicarPagoConvenio - obtieneDatosPagosConvenio" );
		final List<HashMap<String,Object>> datosPagosConvenio = (List<HashMap<String,Object>>) sesion.selectList("obtieneDatosPagosConvenio", parametros);
						
		Double montoPagoPeticion = peticion.getMonto();
		for( HashMap<String,Object> pago  : datosPagosConvenio) {						
		
			if(pago.get("status").toString().equals("D") && montoPagoPeticion > 0) {
				
				double saldoPago = Double.parseDouble(pago.get("monto_pago").toString()) -  Double.parseDouble(pago.get("monto_pagado").toString());
				double montoPago = 0.0;
				if(montoPagoPeticion <= saldoPago ) {
					montoPago = montoPagoPeticion;
				}
				else {
					montoPago = saldoPago;
				}
												
				//Actualiza pago convenio				
				final java.util.HashMap<String , Object>  parametrosPago = new java.util.HashMap<String , Object>();				
				parametrosPago.put("numero_convenio", numeroConvenio  );
				parametrosPago.put("numero_pago", Integer.parseInt(pago.get("numero_pago").toString()) );						
				parametrosPago.put("monto_pagado", montoPago);
				parametrosPago.put("usuario_pago", peticion.getUsuario());
												
				if(saldoPago == montoPago) {
					parametrosPago.put("status", "P");					
				}
				else {
					parametrosPago.put("status", null);
				}
				
				LogHandler.trace(uid, getClass(), "==> guardarDatosConvenio - actualizarPagoConvenioPago" );
				sesion.update("actualizarPagoConvenioPago", parametrosPago);
				
				montoPagoPeticion = montoPagoPeticion - montoPago;
				
			}
		}
			
		//Sobro monto pago, es necesario reflejarlo en el ultimo pago.
		if(montoPagoPeticion > 0) {
			
			HashMap<String,Object> pago = datosPagosConvenio.get(datosPagosConvenio.size() -1);
			
			//Actualiza el ultimo pago		
			final java.util.HashMap<String , Object>  parametrosPago = new java.util.HashMap<String , Object>();				
			parametrosPago.put("numero_convenio", numeroConvenio  );
			parametrosPago.put("numero_pago", Integer.parseInt(pago.get("numero_pago").toString()) );						
			parametrosPago.put("monto_pagado", montoPagoPeticion);
			parametrosPago.put("usuario_pago", peticion.getUsuario());
														
			LogHandler.trace(uid, getClass(), "==> guardarDatosConvenio - actualizarPagoConvenioPago" );
			sesion.update("actualizarPagoConvenioPago", parametrosPago);
			
		}
		
		//Verifica si ya liquido 
		
		parametros.put( "status", "D"); 
		LogHandler.trace(uid, getClass(), "==> aplicarPagoConvenio - obtieneNumeroPagosConvenio" );
		final int pagosPendientes = (Integer) sesion.selectOne("obtieneNumeroPagosConvenio", parametros);
		//Liquido el convenio		
		if(pagosPendientes == 0) {
			//Actualizar status convenio
			parametros.put( "status", "P");
			LogHandler.trace(uid, getClass(), "==> aplicarPagoConvenio - actualizarConvenio" );
			sesion.update("actualizarConvenio", parametros);
			
			//Actualizar status integrante_grupo
			final java.util.HashMap<String , Object>  parametrosIntegrante = new java.util.HashMap<String , Object>();								
			parametrosIntegrante.put("contrato", peticion.getNumeroContrato());
			parametrosIntegrante.put("integrante", peticion.getNumeroIntegrante());
			parametrosIntegrante.put("status", "P" );				
			sesion.update("actualizarStatusIntegrante", parametrosIntegrante);	
			
			//Actualizar Porcentaje de Participacion del credito anterior
			LogHandler.debug(uid, getClass(),"Actualizando porcentaje integrantes credito anterior");
			if(!comun.actualizarPorcentajeParticipacionIntegrante(uid, sesion, peticion.getNumeroContrato())) {
				throw new Exception( "Existio un error en la actualizacion del porcentaje de los integrantes del credito anterior." );
			}
			
		}		
		
		
	}
	
	@SuppressWarnings("unchecked")
	public DatosConvenioRespuesta buscarDatosConvenio( DatosConvenioPeticion peticion, String uid ) {
		DatosConvenioRespuesta datosConvenioRespuesta = new DatosConvenioRespuesta();
		datosConvenioRespuesta.setHeader(new EncabezadoRespuesta());
		datosConvenioRespuesta.getHeader().setEstatus(true);
		datosConvenioRespuesta.getHeader().setUID(uid);
				
		SqlSession sesionNTx = null;
		
		try
		{
			
			if (peticion == null || peticion.getNumeroContrato() == null || peticion.getNumeroContrato().isEmpty()) {
				throw new Exception("Numero de contrato no valido, es obligatorio.");
			} 
			
			if (peticion.getNumeroPersona() == null || peticion.getNumeroPersona().isEmpty()) {
				throw new Exception("Numero de cliente no valido, es obligatorio.");
			} 
			
			//Se obtiene numero de contrato credprod			
			peticion.setNumeroContrato(comun.obtenerNumeroContrato(uid, peticion.getNumeroContrato()));
			
			if (peticion == null || peticion.getNumeroContrato() == null || peticion.getNumeroContrato().isEmpty()) {
				throw new Exception("Numero de contrato no valido, es obligatorio.");
			} 
			
			//Se valida el contrato
			final HashMap<String, Object> 
							datosContrato = comun.obtenerDatosGeneralesContrato(uid, peticion.getNumeroContrato() );
						
			//Se valida contrato
			if( datosContrato == null || datosContrato.size() == 0 )
			{
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.contratoinvalido" ) );
			}

			//Se valida el status del contrato
			if (!datosContrato.get( "status" ).toString().equals( "D" ))
			{
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.statuscontratoincorrecto" ) );
			}

			//Sesion No Transaccional
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			final java.util.HashMap<String , Object>  parametros = new java.util.HashMap<String , Object>();

			//Se valida que el integrante pertenezca al contrato
			parametros.put("contrato", peticion.getNumeroContrato());
			parametros.put("integrante", peticion.getNumeroPersona());
			parametros.put("status", null);
			LogHandler.trace(uid, getClass(), "==> buscarDatosConvenio - validaIntegranteContrato" );
			final HashMap<String,Object> integranteGrupo = (HashMap<String,Object>) sesionNTx.selectOne("validaIntegranteContrato", parametros);

			if(integranteGrupo == null || integranteGrupo.size() < 1) {
				throw new Exception( "Contrato y n�mero de persona no existen o no se correlacionan." );
			}

			datosConvenioRespuesta.setConvenio(new ConvenioOV());
			datosConvenioRespuesta.getConvenio().setNumeroContrato(peticion.getNumeroContrato());
			datosConvenioRespuesta.getConvenio().setNumeroPersona(peticion.getNumeroPersona());

			//Se verifica si existe algun convenio para el contrato-integrante

			LogHandler.trace(uid, getClass(), "==> buscarDatosConvenio - obtieneDatosConvenio" );
			final HashMap<String,Object> datosConvenio = (HashMap<String,Object>) sesionNTx.selectOne("obtieneDatosConvenio", parametros);
			if(datosConvenio == null || datosConvenio.size() < 1) {

				//Se obtiene datos credito
				//fecha contable
				final FechaContableOV fechaContableOV = comun.obtenerFechaContable( uid );	
				parametros.put("fechaActual", ( new SimpleDateFormat( "yyyy-MM-dd" ) ).format(fechaContableOV.getFecha( ) ) );

				LogHandler.trace(uid, getClass(), "==> buscarDatosConvenio - obtenerSaldoFv" );
				final CreditoSaldo saldoFV = (CreditoSaldo)sesionNTx.selectOne("obtenerSaldoFv", parametros);

				LogHandler.debug(uid, getClass(), "Dias de atraso contrato: " + saldoFV.getDiasAtraso() );
				HashMap<String, Object> params = new HashMap<String, Object>();
				params.put("sucursal", 0);
				params.put("codigo", "CVDM" );
				params.put("fecha", new Date());
				LogHandler.trace(uid, getClass(), "==> ajustarTasaPlazo - verValorHistorico " );
				Integer diasAtraso = (Integer) sesionNTx.selectOne("verValorHistorico", params);
				LogHandler.debug(uid, getClass(), "Dias de atraso verValorHistorico: " + diasAtraso );

				if ( saldoFV.getDiasAtraso() < diasAtraso ) {
					throw new Exception( "El contrato no cumple con los dias de atraso." );
				}

				//Cliente no tiene convenio vigente
				//Se obtienen los datos generales
				LogHandler.trace(uid, getClass(), "==> buscarDatosConvenio - obtieneDatosContratoConvenio" );
				final HashMap<String,Object> datosContratoConvenio = (HashMap<String,Object>) sesionNTx.selectOne("obtieneDatosContratoConvenio", parametros);
								
				datosConvenioRespuesta.getConvenio().setNombrePersona( datosContratoConvenio.get("nombre_cliente") == null ? "" : datosContratoConvenio.get("nombre_cliente").toString() );
				datosConvenioRespuesta.getConvenio().setNombreGrupo( datosContratoConvenio.get("nombre_grupo") == null ? "" : datosContratoConvenio.get("nombre_grupo").toString() );
				datosConvenioRespuesta.getConvenio().setMontoSolicitado(datosContratoConvenio.get("monto_otorgado") == null ? 0.0 : Double.parseDouble(datosContratoConvenio.get("monto_otorgado").toString()) );
				datosConvenioRespuesta.getConvenio().setSaldoCapital(datosContratoConvenio.get("saldo_capital_ind") == null ? 0.0 : Double.parseDouble(datosContratoConvenio.get("saldo_capital_ind").toString()));
				datosConvenioRespuesta.getConvenio().setSaldoInteres(datosContratoConvenio.get("saldo_interes_ind") == null ? 0.0 : Double.parseDouble(datosContratoConvenio.get("saldo_interes_ind").toString()));
				datosConvenioRespuesta.getConvenio().setSaldoMoratorios(datosContratoConvenio.get("saldo_moratorios_ind") == null ? 0.0 : Double.parseDouble(datosContratoConvenio.get("saldo_moratorios_ind").toString()));
				datosConvenioRespuesta.getHeader().setMensaje("El integrante no tiene convenio.");		
				
			}
			else {
				//Cliente tiene convenio vigente
				//Se obtienen los datos generales
				LogHandler.trace(uid, getClass(), "==> buscarDatosConvenio - obtieneDatosContratoConvenio" );
				final HashMap<String,Object> datosContratoConvenio = (HashMap<String,Object>) sesionNTx.selectOne("obtieneDatosContratoConvenio", parametros);
				
				datosConvenioRespuesta.getConvenio().setNombrePersona( datosContratoConvenio.get("nombre_cliente") == null ? "" : datosContratoConvenio.get("nombre_cliente").toString() );
				datosConvenioRespuesta.getConvenio().setNombreGrupo( datosContratoConvenio.get("nombre_grupo") == null ? "" : datosContratoConvenio.get("nombre_grupo").toString() );
				datosConvenioRespuesta.getConvenio().setMontoSolicitado(datosContratoConvenio.get("monto_otorgado") == null ? 0.0 : Double.parseDouble(datosContratoConvenio.get("monto_otorgado").toString()) );
				datosConvenioRespuesta.getConvenio().setSaldoCapital(datosContratoConvenio.get("saldo_capital_ind") == null ? 0.0 : Double.parseDouble(datosContratoConvenio.get("saldo_capital_ind").toString()));
				datosConvenioRespuesta.getConvenio().setSaldoInteres(datosContratoConvenio.get("saldo_interes_ind") == null ? 0.0 : Double.parseDouble(datosContratoConvenio.get("saldo_interes_ind").toString()));
				datosConvenioRespuesta.getConvenio().setSaldoMoratorios(datosContratoConvenio.get("saldo_moratorios_ind") == null ? 0.0 : Double.parseDouble(datosContratoConvenio.get("saldo_moratorios_ind").toString()));
				
				datosConvenioRespuesta.getConvenio().setNumeroConvenio( Integer.parseInt(datosConvenio.get("numero_convenio").toString()));
				datosConvenioRespuesta.getConvenio().setStatus( datosConvenio.get("status").toString());
				datosConvenioRespuesta.getConvenio().setMontoPagoConvenio( Double.parseDouble(datosConvenio.get("monto_pago_convenio").toString()));
				datosConvenioRespuesta.getConvenio().setMontoBonificaConvenio( Double.parseDouble(datosConvenio.get("monto_bonifica_convenio").toString()));
				datosConvenioRespuesta.getConvenio().setMontoTotalConvenio( Double.parseDouble(datosConvenio.get("monto_total_convenio").toString()));				
				datosConvenioRespuesta.getConvenio().setPlazoConvenio(  Integer.parseInt(datosConvenio.get("plazo_convenio").toString()));
				datosConvenioRespuesta.getConvenio().setFrecuenciaConvenio( datosConvenio.get("frecuencia").toString());
				datosConvenioRespuesta.getConvenio().setFechaInicioConvenio( (Date)datosConvenio.get("fecha_inicio") );
				datosConvenioRespuesta.getConvenio().setFechaFinConvenio( (Date)datosConvenio.get("fecha_fin") );
				datosConvenioRespuesta.getConvenio().setUsuarioCaptura(datosConvenio.get("usuario_captura").toString());
				datosConvenioRespuesta.getConvenio().setNumeroGestor(datosConvenio.get("gestor").toString());
				
				List<PagosConvenioOV> pagosConvenio = new ArrayList<PagosConvenioOV>();
				
				//Se obtienen los pagos del convenio 
				
				parametros.put( "numero_convenio",  datosConvenioRespuesta.getConvenio().getNumeroConvenio() ); 
				LogHandler.trace(uid, getClass(), "==> buscarDatosConvenio - obtieneDatosPagosConvenio" );
				final List<HashMap<String,Object>> datosPagosConvenio = (List<HashMap<String,Object>>) sesionNTx.selectList("obtieneDatosPagosConvenio", parametros);
								
				for( HashMap<String,Object> pago  : datosPagosConvenio) {
					PagosConvenioOV pagoConvenio = new PagosConvenioOV();
					pagoConvenio.setNumeroPago( Integer.parseInt(pago.get("numero_pago").toString()) );
					pagoConvenio.setStatus( pago.get("status").toString() );
					pagoConvenio.setMontoPago( Double.parseDouble( pago.get("monto_pago").toString() ) );
					pagoConvenio.setMontoPagado( Double.parseDouble( pago.get("monto_pagado").toString() ));
					pagoConvenio.setMontoBonifica( Double.parseDouble( pago.get("monto_bonifica").toString() ));
					pagoConvenio.setFechaPactadaPago( (Date)pago.get("fecha_pactada_pago") );
					pagoConvenio.setFechaPago( (Date)pago.get("fecha_pago") );
					pagoConvenio.setUsuarioPago( pago.get("usuario_pago").toString().trim() );
					pagoConvenio.setObservaciones(  pago.get("observaciones").toString().trim() );							
					pagosConvenio.add(pagoConvenio);
				}
				
				datosConvenioRespuesta.getConvenio().setPagosConvenio(pagosConvenio);				
				datosConvenioRespuesta.getHeader().setMensaje("El integrante tiene convenio vigente.");
			}
			
		}
		catch(Exception ex) {
			datosConvenioRespuesta.getHeader().setEstatus(false);
			datosConvenioRespuesta.getHeader().setUID(uid);
			datosConvenioRespuesta.getHeader().setMensaje(ex.getMessage());
			LogHandler.error(uid, getClass(), "Error en buscarDatosConvenio(). ", ex);			
		}
		finally {
			FabricaConexiones.close(sesionNTx);
		}
		
		return datosConvenioRespuesta;	
	}
	
	@SuppressWarnings("unchecked")
	public DatosConvenioRespuesta guardarDatosConvenio( ConvenioOV peticion, String uid ) {
		DatosConvenioRespuesta datosConvenioRespuesta = new DatosConvenioRespuesta();
		datosConvenioRespuesta.setHeader(new EncabezadoRespuesta());
		datosConvenioRespuesta.getHeader().setEstatus(true);
		datosConvenioRespuesta.getHeader().setUID(uid);
		
		SqlSession sesionNTx = null;
		SqlSession sesion = null;
		
		try
		{
			if (peticion == null || peticion.getNumeroContrato() == null || peticion.getNumeroContrato().isEmpty()) {
				throw new Exception("Numero de contrato no valido, es obligatorio.");
			} 
			
			if (peticion.getNumeroPersona() == null || peticion.getNumeroPersona().isEmpty()) {
				throw new Exception("Numero de cliente no valido, es obligatorio.");
			} 
			
			if (peticion.getFechaInicioConvenio() == null ) {
				throw new Exception("Las fechas de inicio del convenio, es obligatoria.");
			}
			
			if (peticion.getNumeroGestor() == null || peticion.getNumeroGestor().isEmpty() || peticion.getNumeroGestor().trim().length() != 9 ) {
				throw new Exception("El numero de gestor es necesario o incorrecto.");
			}			
			
			if (peticion.getPlazoConvenio() == null || peticion.getPlazoConvenio() <= 0 ) {
				throw new Exception("El plazo del convenio es necesario.");
			}
			
			if (peticion.getFrecuenciaConvenio() == null || peticion.getFrecuenciaConvenio().isEmpty() ) {
				throw new Exception("La frecuencia del convenio es necesaria.");
			}
			
			if ( !(peticion.getFrecuenciaConvenio().equals("S") || peticion.getFrecuenciaConvenio().equals("C") || peticion.getFrecuenciaConvenio().equals("M") ) ) {
				throw new Exception("La frecuencia del convenio no existe.");
			}
			
			if (peticion.getMontoPagoConvenio() == null ||  peticion.getMontoPagoConvenio() <= 0) {
				throw new Exception("El monto del pago del convenio es necesario.");
			}
			
			if (peticion.getMontoTotalConvenio() == null ||  peticion.getMontoTotalConvenio() <= 0) {
				throw new Exception("El monto total del convenio es necesario.");
			}
						
			if (peticion.getUsuarioCaptura() == null || peticion.getUsuarioCaptura().isEmpty()) {
				throw new Exception("El usuario de captura del convenio es necesario.");
			}
			
			
			//Se obtiene numero de contrato credprod			
			peticion.setNumeroContrato(comun.obtenerNumeroContrato(uid, peticion.getNumeroContrato()));
			
			if (peticion == null || peticion.getNumeroContrato() == null || peticion.getNumeroContrato().isEmpty()) {
				throw new Exception("Numero de contrato no valido, es obligatorio.");
			} 
			
			//Se valida el contrato
			final HashMap<String, Object> 
							datosContrato = comun.obtenerDatosGeneralesContrato(uid, peticion.getNumeroContrato() );
						
			//Se valida contrato
			if( datosContrato == null || datosContrato.size() == 0 )
			{
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.contratoinvalido" ) );
			}
				
			//Se valida el status del contrato
			if( !datosContrato.get( "status" ).toString().equals( "D" )  )
			{
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.statuscontratoincorrecto" ) );
			}
									
			
			//Sesion No Transaccional			
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			
			final java.util.HashMap<String , Object>  parametros = new java.util.HashMap<String , Object>();
			
			//Se valida que el integrante pertenezca al contrato	
			parametros.put("contrato", peticion.getNumeroContrato());
			parametros.put("integrante", peticion.getNumeroPersona());
			
			LogHandler.trace(uid, getClass(), "==> guardarDatosConvenio - validaIntegranteContrato" );
			final HashMap<String,Object> integranteGrupo = (HashMap<String,Object>) sesionNTx.selectOne("validaIntegranteContrato", parametros);
			
			if(integranteGrupo == null || integranteGrupo.size() < 1) {
				throw new Exception( "Contrato y n�mero de persona no existen o no se correlacionan." );
			}
			
			//fecha contable
			final FechaContableOV fechaContableOV = comun.obtenerFechaContable( uid );			

			if( peticion.getFechaInicioConvenio().before( fechaContableOV.getFecha()  ) ) {
				throw new Exception( "La fecha inicio del convenio no puede ser menor a la fecha del sistema." );
			}
			
			
			peticion.setMontoBonificaConvenio(peticion.getMontoTotalConvenio() -  peticion.getMontoPagoConvenio() );
			
			
			//Frecuencias pago
			Map<String,Integer> mapFrecuencia = new HashMap<String,Integer>();
			mapFrecuencia.put("S", 7 );
			mapFrecuencia.put("C", 14 );
			mapFrecuencia.put("M", 30 );
			
			//Sesion Transaccional			
			sesion = FabricaConexiones.obtenerSesionTx();	
			
			datosConvenioRespuesta.setConvenio(peticion);
			
			List<PagosConvenioOV> pagosConvenio = new ArrayList<PagosConvenioOV>();
			
			if(peticion.getNumeroConvenio() == null || peticion.getNumeroConvenio() == 0) {
				//Significa que es un nuevo convenio para almacenar
				//Se verifica si existe algun convenio para el contato-integrante
				parametros.put("status", "D" );
				LogHandler.trace(uid, getClass(), "==> guardarDatosConvenio - obtieneDatosConvenio" );
				final HashMap<String,Object> datosConvenio = (HashMap<String,Object>) sesionNTx.selectOne("obtieneDatosConvenio", parametros);
				
				if(datosConvenio != null && datosConvenio.size() >= 1) {
					throw new Exception( "El integrante tiene un convenio vigente, favor de enviar el numero de convenio.");					
				}
				
				//Almacenar convenio		
				Date fechaPago =  peticion.getFechaInicioConvenio();
				for(int i = 1; i <= peticion.getPlazoConvenio() ; i++ ) {
				
					peticion.setFechaFinConvenio(fechaPago);
					Calendar cal = Calendar.getInstance();
					cal.setTime(fechaPago);
					cal.add(Calendar.DAY_OF_YEAR, mapFrecuencia.get(peticion.getFrecuenciaConvenio())); 
					fechaPago = cal.getTime(); 					
				}
				
					
				parametros.put("monto_pago_convenio", peticion.getMontoPagoConvenio() );
				parametros.put("monto_bonifica_convenio", peticion.getMontoBonificaConvenio() );
				parametros.put("monto_total_convenio", peticion.getMontoTotalConvenio() );
				parametros.put("porcentaje_bonifica", peticion.getMontoBonificaConvenio() / peticion.getMontoTotalConvenio() );
				parametros.put("plazo_convenio", peticion.getPlazoConvenio() );
				parametros.put("frecuencia", peticion.getFrecuenciaConvenio() );
				parametros.put("fecha_inicio", peticion.getFechaInicioConvenio() );
				parametros.put("fecha_fin", peticion.getFechaFinConvenio() );				
				parametros.put("usuario_captura", peticion.getUsuarioCaptura() );
				parametros.put("gestor", peticion.getNumeroGestor() );
					
				LogHandler.trace(uid, getClass(), "==> guardarDatosConvenio - insertaConvenio" );								
				sesion.insert("insertaConvenio",parametros);
				
				LogHandler.trace(uid, getClass(), "==> guardarDatosConvenio - obtieneDatosConvenio" );								
				final HashMap<String,Object> datosConvenioNuevo = (HashMap<String,Object>)  sesion.selectOne("obtieneDatosConvenio", parametros);
				
				//Almacena pagos					
				datosConvenioRespuesta.getConvenio().setNumeroConvenio(Integer.valueOf( datosConvenioNuevo.get("numero_convenio").toString()));
				
				fechaPago =  peticion.getFechaInicioConvenio();
				Double montoPago = peticion.getMontoPagoConvenio() / peticion.getPlazoConvenio();
				
				for(int i = 1; i <= peticion.getPlazoConvenio() ; i++ ) {
														
					final java.util.HashMap<String , Object>  parametrosPago = new java.util.HashMap<String , Object>();
					
					parametrosPago.put("numero_convenio", Integer.valueOf( datosConvenioNuevo.get("numero_convenio").toString()) );
					parametrosPago.put("numero_pago", i );
					parametrosPago.put("status", "D" );
					parametrosPago.put("monto_pago", montoPago );
					parametrosPago.put("monto_pagado", 0 );
					parametrosPago.put("monto_bonifica", 0 );
					parametrosPago.put("fecha_pactada_pago", fechaPago );					
					parametrosPago.put("usuario_pago", "" );
					parametrosPago.put("observaciones", "" );
					
					PagosConvenioOV pagoConvenio = new PagosConvenioOV();
					pagoConvenio.setNumeroPago(i);
					pagoConvenio.setStatus( "D");
					pagoConvenio.setMontoPago(montoPago);
					pagoConvenio.setMontoPagado(0.0);
					pagoConvenio.setMontoBonifica(0.0);
					pagoConvenio.setFechaPactadaPago(fechaPago);
					pagoConvenio.setUsuarioPago("");
					pagoConvenio.setObservaciones("");					
							
					pagosConvenio.add(pagoConvenio);
					
					Calendar cal = Calendar.getInstance();
					cal.setTime(fechaPago);
					cal.add(Calendar.DAY_OF_YEAR, mapFrecuencia.get(peticion.getFrecuenciaConvenio())); 
					fechaPago = cal.getTime(); 					
					
					LogHandler.trace(uid, getClass(), "==> guardarDatosConvenio - insertaPagoConvenio" );								
					sesion.insert("insertaPagoConvenio",parametrosPago);
										
					
				}
				
				final java.util.HashMap<String , Object>  parametrosIntegrante = new java.util.HashMap<String , Object>();								
				parametrosIntegrante.put("contrato", peticion.getNumeroContrato());
				parametrosIntegrante.put("integrante", peticion.getNumeroPersona());
				parametrosIntegrante.put("status", "C" );				
				sesion.update("actualizarStatusIntegrante", parametrosIntegrante);
				
				datosConvenioRespuesta.getConvenio().setPagosConvenio(pagosConvenio);
			}
			else
			{
								
				LogHandler.debug(uid, getClass(), "==> actualizacioDatos" );
				
				parametros.put("status", "D" );
				parametros.put("numero_convenio", peticion.getNumeroConvenio() );				
				LogHandler.trace(uid, getClass(), "==> guardarDatosConvenio - obtieneDatosConvenio" );
				final HashMap<String,Object> datosConvenio = (HashMap<String,Object>) sesionNTx.selectOne("obtieneDatosConvenio", parametros);
			
				if(datosConvenio != null && datosConvenio.size() >= 1) {
					
					
					
					pagosConvenio = datosConvenioRespuesta.getConvenio().getPagosConvenio();
					
					Double sumaPagosConvenio = 0.0;
					for(int i = 0; i < pagosConvenio.size(); i++ ) {
						sumaPagosConvenio += pagosConvenio.get(i).getMontoPago();
					}
					
					LogHandler.debug(uid, getClass(), "COMPARACION DE MONTOS =" + sumaPagosConvenio + "-" +  Double.parseDouble(datosConvenio.get("monto_pago_convenio").toString()) );
					
					if( sumaPagosConvenio.doubleValue() != Double.parseDouble(datosConvenio.get("monto_pago_convenio").toString())  ) {
						throw new Exception( "La suma de los pagos es diferente al monto pago del convenio." );
					}
						
					
					for(int i = 0; i < pagosConvenio.size(); i++ ) {
						//Actualizar montos pago convenio
					
						final java.util.HashMap<String , Object>  parametrosPago = new java.util.HashMap<String , Object>();
						
						parametrosPago.put("numero_convenio", peticion.getNumeroConvenio()  );
						parametrosPago.put("numero_pago", pagosConvenio.get(i).getNumeroPago() );						
						parametrosPago.put("monto_pago", pagosConvenio.get(i).getMontoPago());
						parametrosPago.put("status_s", "D");
						
						LogHandler.trace(uid, getClass(), "==> guardarDatosConvenio - actualizarPagoConvenio" );
						sesion.update("actualizarPagoConvenio", parametrosPago);
					}
									 
										
				} else {
					throw new Exception( "No existe un convenio activo con el numero de convenio de la peticion.");
				}
								
			}
						
			LogHandler.debug(uid, getClass(), "==> guardarDatosConvenio - COMMIT!!!" );
			sesion.commit(true);
		}
		catch(Exception ex) {
			FabricaConexiones.rollBack( sesion );			
			datosConvenioRespuesta.getHeader().setEstatus(false);
			datosConvenioRespuesta.getHeader().setUID(uid);
			datosConvenioRespuesta.getHeader().setMensaje(ex.getMessage());
			LogHandler.error(uid, getClass(), "Error en guardarDatosConvenio(). ", ex);			
		}
		finally {
			FabricaConexiones.close(sesionNTx);
			FabricaConexiones.close(sesion);			
		}

		return datosConvenioRespuesta;	
	}


	/**
	 * @param uid identificador de la transaccion
	 * @param peticion datos del pago de servicio
	 * @return respuesta
	 */
	public AplicarPagoServicioRespuesta aplicarPagoServicio(PagoServicioPeticion peticion, String uid ) {
		AplicarPagoServicioRespuesta respuesta = new AplicarPagoServicioRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);

		String claveServicio = "PGSV";
		SqlSession sesionTx = null;
		try {

		if (peticion.getClaveCliente() == null || peticion.getClaveCliente() == 0) {
			throw new Exception("Es necesario la clave de cliente en la peticion.");
		}

		if (peticion.getClaveProducto() == null || peticion.getClaveProducto().trim().isEmpty()) {
			throw new Exception("Es necesario la clave de producto en la peticion.");
		}

		if (peticion.getMonto() == null || peticion.getMonto() == 0.0) {
			throw new Exception("Es necesario el monto para el registro del pago de servicio.");
		}

		if (peticion.getUsuario() == null || peticion.getUsuario().trim().isEmpty()) {
			throw new Exception("Es necesario el usuario para el registro del pago de servicio.");
		}

		peticion.setCodigo(claveServicio);


		FechaContableOV datosFechaContable = comun.obtenerFechaContable(uid);
		LogHandler.info(uid, getClass(), "Fecha contable=" + datosFechaContable.getFecha());

		if ( datosFechaContable.isEstatusCierre()) {
			throw new Exception( "ERROR: Cierre en proceso: " );
		}

		sesionTx = FabricaConexiones.obtenerSesionTx();

		peticion.setSucursal(peticion.getSucursal() != null ? peticion.getSucursal() : 0 );

		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("sucursal", peticion.getSucursal());
		map.put("fechaContable", datosFechaContable.getFecha());

		LogHandler.info(uid, getClass(), "Apertura de caja");

		ResultadoOV resAperturaCaja = comun.aperturaCaja(uid, peticion.getSucursal(), datosFechaContable.getFecha());

		if ( "-1".equals(resAperturaCaja.getCodigoRetorno())) {
			throw new Exception("Error al abrir Caja");
		}

		//SE OBTIENE ID DE TRANSACCION DE LA CAJA
		LogHandler.info(uid, getClass(), "Obtiene idTransaccion");
		Integer idTransaccion = comun.obtenerIdTransaccion(uid, peticion.getSucursal(), datosFechaContable.getFecha());

		if (idTransaccion == null) {
			throw new Exception("Error al obtener Id Transaccion");
		}

		//REGISTRAR MOVIMIENTO EN INVENTARIO
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("sucursal", peticion.getSucursal() );
		params.put("fechaContable", formatter.format(datosFechaContable.getFecha()));
		params.put("monto", peticion.getMonto());
		LogHandler.trace(uid, getClass(), "==> aplicarPagoServicio - registraCajaInventario ");
		sesionTx.selectOne("registraCajaInventario", params);

		String contrato = "00000000";
		if ( peticion.getReferencia1() != null ) {
			//Se obtiene numero de contrato credprod
			contrato  = comun.obtenerNumeroContrato(uid, peticion.getReferencia1().trim());
		}

		//***Validacion idTransaccion RECU-129 duplicidad de pagos
		if ( peticion.getIdTransaccion() != null && !peticion.getIdTransaccion().trim().isEmpty() ) {
			HashMap<String, Object> parametrosAuditoria = new HashMap<String, Object>();
			parametrosAuditoria.put("contrato", contrato);
			parametrosAuditoria.put("idTransaccion", peticion.getIdTransaccion());

			Integer existe =
				(Integer) sesionTx.selectOne("consultaPagoContratoAuditoria", parametrosAuditoria);

			if (existe > 0) {
				throw new Exception( "No es posible registrar el pago, identificador duplicado");
			}

			peticion.setReferencia3(peticion.getIdTransaccion());

		}

	//Se agrega fechaValor para registrar en sp
//		SimpleDateFormat formatoS = new SimpleDateFormat("dd-MM-yyyy");
		if ( peticion.getFechaValor() != null && !peticion.getFechaValor().trim().isEmpty()) {
			Date fechaValor = formatter.parse(peticion.getFechaValor());
			params.put("fechaValor", fechaValor);
		} else {
			params.put("fechaValor", formatter.format(datosFechaContable.getFecha()));
		}

		if ( contrato == null || contrato.trim().isEmpty() ) {
			contrato = "00000000";
		}

		params.put("codigo", peticion.getCodigo() );
		params.put("contrato", contrato);
		params.put("idTrxCaja", idTransaccion);
		params.put("fechaActual", formatter.format(datosFechaContable.getFecha()));
		params.put("medioRecepcion", ConstantesPagos.PAGO_OFICINA_CENTRAL.getValue());
		params.put("usuario", peticion.getUsuario() != null && !peticion.getUsuario().trim().isEmpty()
				? peticion.getUsuario() : ConstantesPagos.USUARIO_PAGO.getValue());
		params.put("clave", peticion.getClaveCliente() );
		params.put("clave_produccion", peticion.getClaveProducto() );
		params.put("referencia1", peticion.getReferencia1() != null ? peticion.getReferencia1() : "");
		params.put("referencia2", peticion.getReferencia2() != null ? peticion.getReferencia2() : "");
		params.put("referencia3", peticion.getReferencia3() != null ? peticion.getReferencia3() : "");
		params.put("referencia4", peticion.getReferencia4() != null ? peticion.getReferencia4() : "");
		params.put("referencia5", peticion.getReferencia5() != null ? peticion.getReferencia5() : "");

		params.put("comision", peticion.getComision() != null ? peticion.getComision() : 0.0);
		params.put("ivaComision", peticion.getIvaComision() != null ? peticion.getIvaComision() : 0.0);

		LogHandler.trace(uid, getClass(), "==> aplicarPagoServicio - registraOperacionCajaServicio");
		sesionTx.selectOne("registraOperacionCajaServicio", params);

		respuesta.setIdTransaccion(idTransaccion);

		sesionTx.commit(true);

		}
		catch (Exception ex) {
			FabricaConexiones.rollBack( sesionTx );
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(ex.getMessage());
			LogHandler.error(uid, getClass(), "Error en aplicarPagoServicio(). ", ex);
		}
		finally {

			FabricaConexiones.close(sesionTx);
		}
		return respuesta;
	}

	@SuppressWarnings("unchecked")
	public AplicarPagoRespuesta validacionPagoConvenio(AplicarPagoConexiaPeticion peticion, String uid) {

		AplicarPagoRespuesta aplicarPagoRespuesta = new AplicarPagoRespuesta();
		aplicarPagoRespuesta.setHeader(new EncabezadoRespuesta());
		aplicarPagoRespuesta.getHeader().setEstatus(true);
		aplicarPagoRespuesta.getHeader().setUID(uid);

		SqlSession sesionNTx = null;

		try {

			if (peticion.getNumeroContrato() == null || peticion.getNumeroContrato().isEmpty()) {
				throw new Exception("Numero de contrato no valido, es obligatorio.");
			}
			if (peticion.getNumeroIntegrante() == null || peticion.getNumeroIntegrante().isEmpty()) {
				throw new Exception("Numero de cliente no valido, es obligatorio.");
			}
			if (peticion.getMedioPago() == null || peticion.getMedioPago().isEmpty()) {
				throw new Exception("Medio de pago no valido, es obligatorio.");
			}
			if (peticion.getMonto() == null || peticion.getMonto() <= 0 ) {
				throw new Exception("Monto de la peticion no valido.");
			}
			//Se obtiene numero de contrato credprod
			peticion.setNumeroContrato(comun.obtenerNumeroContrato(uid, peticion.getNumeroContrato()));

			if (peticion.getNumeroContrato() == null || peticion.getNumeroContrato().isEmpty()) {
				throw new Exception("Numero de contrato no valido.");
			}

			//Se valida el contrato
			final HashMap<String, Object>
							datosContrato = comun.obtenerDatosGeneralesContrato(uid, peticion.getNumeroContrato() );

			//Se valida contrato
			if ( datosContrato == null || datosContrato.size() == 0 ) {
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.contratoinvalido" ) );
			}

			//Se valida el status del contrato
			if ( !datosContrato.get( "status" ).toString().equals( "D" )  ) {
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.statuscontratoincorrecto" ) );
			}

			//fecha contable
			//final FechaContableOV fechaContableOV = comun.obtenerFechaContable( uid );

			//Sesion No Transaccional
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			final java.util.HashMap<String , Object>  parametros = new java.util.HashMap<String , Object>();

			//Se valida que el integrante pertenezca al contrato
			parametros.put("contrato", peticion.getNumeroContrato());
			parametros.put("integrante", peticion.getNumeroIntegrante());
			LogHandler.trace(uid, getClass(), "==> aplicarPagoGrupalConexia - validaIntegranteContrato" );
			final HashMap<String, Object> integranteGrupo
				= (HashMap<String, Object>) sesionNTx.selectOne("validaIntegranteContrato", parametros);

			if (integranteGrupo == null || integranteGrupo.size() < 1) {
				throw new Exception( "El integrante no pertence al contrato." );
			}

			//Se valida que el integrante tenga un convenio contrato
			parametros.clear();
			parametros.put("contrato", peticion.getNumeroContrato());
			parametros.put("integrante", peticion.getNumeroIntegrante());
			parametros.put("status", "D" );
			LogHandler.trace(uid, getClass(), "==> aplicarPagoGrupalConexia - obtieneDatosConvenio" );

			final HashMap<String, Object> datosConvenio
				= (HashMap<String, Object>) sesionNTx.selectOne("obtieneDatosConvenio", parametros);

			if (datosConvenio == null || datosConvenio.size() < 1) {
				throw new Exception( "El integrante no tiene un convenio activo." );
			}

		}
		catch (Exception ex) {
			aplicarPagoRespuesta.getHeader().setEstatus(false);
			aplicarPagoRespuesta.getHeader().setUID(uid);
			aplicarPagoRespuesta.getHeader().setMensaje(ex.getMessage());
			LogHandler.error(uid, getClass(), "Error en aplicarPagoGrupalConexia().", ex);
		}
		finally {
			FabricaConexiones.close(sesionNTx);
		}
		return aplicarPagoRespuesta;

	}

	@SuppressWarnings("unchecked")
	public CancelarPagoConexiaRespuesta validacionCancelacionPagoConvenio(CancelarPagoConexiaPeticion peticion, String uid) {

		CancelarPagoConexiaRespuesta cancelarPagoConexiaRespuesta = new  CancelarPagoConexiaRespuesta();
        cancelarPagoConexiaRespuesta.setHeader(new EncabezadoRespuesta());
        cancelarPagoConexiaRespuesta.getHeader().setUID(uid);
        cancelarPagoConexiaRespuesta.getHeader().setEstatus(true);
        SqlSession sesionNTx = null;
        String validaStr = "";
        List<CancelaPagoConexiaValidaOV> movimientos = null;
        try {
            String[] datosRequeridos = {"numeroContrato", "numeroIntegrante",
                                        "fechaValor", "monto"};
            validaStr = Validaciones.datosRequeridos(peticion, datosRequeridos);
            if (!validaStr.equalsIgnoreCase("")) {
                throw new Exception(ReadProperties.mensajes.getProp("ciof.error.datos.requeridos") + " " + validaStr );
            }
            // Se abre la sesion No transaccional sybase
            sesionNTx = FabricaConexiones.obtenerSesionNTx();
            LogHandler.trace(uid, getClass(), "validacionCancelacionPagoConvenio: - consultaPrGetFecha");
            LogHandler.info(uid, getClass(), "validacionCancelacionPagoConvenio: - consultaPrGetFecha");
            Date fechaContable = (Date) sesionNTx.selectOne("consultaPrGetFecha");
            if (fechaContable == null) {
                throw new Exception(ReadProperties.mensajes.getProp("solicitudes.consulta.sin.resultados"));
            }

            //Se obtiene numero de contrato credprod
			peticion.setNumeroContrato(comun.obtenerNumeroContrato(uid, peticion.getNumeroContrato()));

            LogHandler.info(uid, getClass(), "validacionCancelacionPagoConvenio: - fechaContable: " + fechaContable);
            final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("numeroContrato", peticion.getNumeroContrato());
            parametros.put("fechaContable", fechaContable);
            parametros.put("fechaValor", peticion.getFechaValor());
            parametros.put("numeroIntegrante", peticion.getNumeroIntegrante());
            LogHandler.trace(uid, getClass(), "validacionCancelacionPagoConvenio: - consultaValidacionCancelacionPagoConvenio");
            LogHandler.info(uid, getClass(), "validacionCancelacionPagoConvenio: - consultaValidacionCancelacionPagoConvenio");
            movimientos = (List<CancelaPagoConexiaValidaOV>) sesionNTx.selectList(
                            "consultaValidacionCancelacionPagoConvenio", parametros);
            if (movimientos.isEmpty()) {
                throw new Exception(ReadProperties.mensajes.getProp("solicitudes.consulta.sin.resultados"));
            }
            LogHandler.info(uid, getClass(), "validacionCancelacionPagoConvenio: - peticion.getMonto(): " + peticion.getMonto());
            for (CancelaPagoConexiaValidaOV movimiento:movimientos) {
                if (movimiento.getMonto().equals(peticion.getMonto())) {
                    LogHandler.info(uid, getClass(),
                            "validacionCancelacionPagoConvenio: - movimiento.getMonto() == peticion.getMonto()");
                    cancelarPagoConexiaRespuesta.setIdTransaccion(movimiento.getIdTransaccion());
                    break;
                }
            }
            if (cancelarPagoConexiaRespuesta.getIdTransaccion() == null) {
                LogHandler.info(uid, getClass(), "validacionCancelacionPagoConvenio: - getIdTransaccion is null");
                cancelarPagoConexiaRespuesta.getHeader().setEstatus(false);
            }
        }
        catch (Exception ex) {
            LogHandler.error(uid, getClass(), "validacionCancelacionPagoConvenio: " + ex.getMessage(), ex);
            cancelarPagoConexiaRespuesta.getHeader().setEstatus(false);
            cancelarPagoConexiaRespuesta.getHeader().setMensaje(ReadProperties.mensajes.getProp("ciof.error.consulta"));
            cancelarPagoConexiaRespuesta.getHeader().setCodigo(ex.getMessage());
        }
        finally {
            FabricaConexiones.close(sesionNTx);
        }
        return cancelarPagoConexiaRespuesta;

	}


	 public CancelarPagoConexiaRespuesta cancelarPagoConexiaTarea(CancelarPagoConexiaPeticion peticion, String uid) {
	        CancelarPagoConexiaRespuesta cancelarPagoConexiaRespuesta = new  CancelarPagoConexiaRespuesta();
	        cancelarPagoConexiaRespuesta.setHeader(new EncabezadoRespuesta());
	        cancelarPagoConexiaRespuesta.getHeader().setUID(uid);
	        cancelarPagoConexiaRespuesta.getHeader().setEstatus(true);
	        SqlSession sesionNTx = null;
	        SqlSession sesionTx = null;
	        String validaStr = "";
	        try {
	            String[] datosRequeridos = {"numeroContrato", "numeroIntegrante",
	                                        "fechaValor", "monto", "usuario"};
	            validaStr = Validaciones.datosRequeridos(peticion, datosRequeridos);
	            if (!validaStr.equalsIgnoreCase("")) {
	                throw new Exception(ReadProperties.mensajes.getProp("ciof.error.datos.requeridos") + " " + validaStr );
	            }
	            // Se abre la sesion transaccional sybase
	            sesionTx = FabricaConexiones.obtenerSesionTx();
	            // Se abre la sesion No transaccional sybase
	            sesionNTx = FabricaConexiones.obtenerSesionNTx();
	            LogHandler.trace(uid, getClass(), " :.: cancelarPagoConexiaTarea: - consultaPrGetFecha");
	            LogHandler.info(uid, getClass(), " :.: cancelarPagoConexiaTarea: - consultaPrGetFecha");
	            Date fechaContable = (Date) sesionNTx.selectOne("consultaPrGetFecha");
	            if (fechaContable == null) {
	                throw new Exception(ReadProperties.mensajes.getProp("solicitudes.consulta.sin.resultados"));
	            }
	            LogHandler.info(uid, getClass(), " :.: cancelarPagoConexiaTarea: - fechaContable: " + fechaContable);

	            //Se obtiene numero de contrato credprod
				peticion.setNumeroContrato(comun.obtenerNumeroContrato(uid, peticion.getNumeroContrato()));

	            // cancelarMovimientos
	            LogHandler.info(uid, getClass(), " :.: cancelarPagoConexiaTarea: - validacionCancelacionPagoConvenio()");
	            CancelarPagoConexiaRespuesta cancelarPagoConexiaRespuestaValidacion
	            	= validacionCancelacionPagoConvenio(peticion, uid);
	            if (cancelarPagoConexiaRespuestaValidacion.getIdTransaccion() == null) {
	                throw new Exception(ReadProperties.mensajes.getProp("solicitudes.consulta.sin.resultados"));
	            }
	            LogHandler.info(uid, getClass(), " :.: cancelarPagoConexiaTarea: - id Transaccion: "
	            		+ cancelarPagoConexiaRespuestaValidacion.getIdTransaccion());

	            List<DetalleTransaccionOV> detalleTransaccionOVList = new ArrayList<DetalleTransaccionOV>();
	            DetalleTransaccionOV detalleTransaccionOV = new DetalleTransaccionOV();
	            detalleTransaccionOV.setIdTransaccion(cancelarPagoConexiaRespuestaValidacion.getIdTransaccion());
	            detalleTransaccionOV.setFechaContable(fechaContable);
	            detalleTransaccionOV.setMontoCancelacion(peticion.getMonto());
	            detalleTransaccionOVList.add(detalleTransaccionOV);

	            CancelarMovimientosPeticion cancelarMovimientosPeticion = new CancelarMovimientosPeticion();
	            cancelarMovimientosPeticion.setContrato(peticion.getNumeroContrato());
	            cancelarMovimientosPeticion.setUsuario(peticion.getUsuario());
	            cancelarMovimientosPeticion.setTipoMovimiento("PAGO");
	            cancelarMovimientosPeticion.setTransacciones(detalleTransaccionOVList);
	            LogHandler.info(uid, getClass(), " :.: cancelarPagoConexiaTarea: - cancelarMovimientos()");
	            final 	CancelarMovimientosRespuesta
	                    cancelarMovimientosRespuesta = cancelarMovimientos( cancelarMovimientosPeticion, null, sesionTx, uid );

	            if (!cancelarMovimientosRespuesta.getHeaderRespuesta().isEstatus()) {
	                throw new Exception(cancelarMovimientosRespuesta.getHeaderRespuesta().getCodigo());
	            }

	            // integrante_grupo Status a "C".
	            final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
	            parametros.put("status", "C");
	            parametros.put("contrato", peticion.getNumeroContrato());
	            parametros.put("integrante", peticion.getNumeroIntegrante());
	            LogHandler.trace(uid, getClass(), " :.: cancelarPagoConexiaTarea: - actualizarStatusIntegrante");
	            LogHandler.info(uid, getClass(), " :.: cancelarPagoConexiaTarea: - actualizarStatusIntegrante");
	            int rows = sesionTx.update("actualizarStatusIntegrante", parametros);
	            if (rows == 0) {
	                throw new Exception(ReadProperties.mensajes.getProp("ciof.error.actualizacion"));
	            }
	            //Actualizar porcentaje de participacion
	            //MIMH 20140826
	            if (!comun.actualizarPorcentajeParticipacionIntegrante(uid, sesionTx,
	            		 comun.obtenerNumeroContrato(uid, peticion.getNumeroContrato()))) {
					throw new Exception( "Existio un error en la actualizacion del porcentaje de los integrantes del credito." );
				}
	            // Obtener convenio.
	            parametros.clear();
	            parametros.put("contrato", peticion.getNumeroContrato());
	            parametros.put("integrante", peticion.getNumeroIntegrante());
	            LogHandler.trace(uid, getClass(), " :.: cancelarPagoConexiaTarea - obtieneDatosConvenio" );
	            LogHandler.info(uid, getClass(), " :.: cancelarPagoConexiaTarea: - obtieneDatosConvenio");
	            @SuppressWarnings("unchecked")
				final HashMap<String, Object> datosConvenio =
	                    (HashMap<String, Object>) sesionNTx.selectOne("obtieneDatosConvenio", parametros);
	            if (datosConvenio == null || datosConvenio.size() < 1) {
	                throw new Exception(ReadProperties.mensajes.getProp("solicitudes.consulta.sin.resultados"));
	            }
	            LogHandler.info(uid, getClass(),
	                    " :.: cancelarPagoConexiaTarea: - numero_convenio: " + datosConvenio.get("numero_convenio"));
	            //  convenio_integrante Status a "D".
	            parametros.clear();
	            parametros.put("status", "D");
	            parametros.put("numero_convenio", datosConvenio.get("numero_convenio"));
	            LogHandler.trace(uid, getClass(), " :.: cancelarPagoConexiaTarea: - actualizarConvenio");
	            LogHandler.info(uid, getClass(), " :.: cancelarPagoConexiaTarea: - actualizarConvenio");
	            rows = sesionTx.update("actualizarConvenio", parametros);
	            if (rows == 0) {
	                throw new Exception(ReadProperties.mensajes.getProp("ciof.error.actualizacion"));
	            }
	            //
	            Calendar fechaInicio = Calendar.getInstance();
	            fechaInicio.set(1900, 0, 1, 0, 0, 0);
	            //obtieneDatosPagosConvenio
	            parametros.clear();
	            parametros.put("numero_convenio", datosConvenio.get("numero_convenio"));
	            LogHandler.trace(uid, getClass(), " :.: cancelarPagoConexiaTarea - obtieneDatosPagosConvenio" );
	            LogHandler.info(uid, getClass(), " :.: cancelarPagoConexiaTarea: - obtieneDatosPagosConvenio");
	            @SuppressWarnings("unchecked")
				final List<HashMap<String, Object>> datosPagosConvenio = (List<HashMap<String, Object>>)
	                    sesionNTx.selectList("obtieneDatosPagosConvenio", parametros);
	            Double montoPagoPeticion = peticion.getMonto();
	            //List<HashMap<String, Object>> datosPagosConvenioReverse = Collections.reverse(datosPagosConvenio);
	            int sizeList = datosPagosConvenio.size();
	            LogHandler.info(uid, getClass(), " :.: cancelarPagoConexiaTarea: - datosPagosConvenio.size(): " + sizeList);
	            for ( int i = sizeList - 1; i >= 0; i--) {
	                HashMap<String, Object> pago = datosPagosConvenio.get(i);
	                if (montoPagoPeticion > 0) {
	                    LogHandler.info(uid, getClass(),
	                            " :.: cancelarPagoConexiaTarea: - numero_pago: " + pago.get("numero_pago").toString());
	                    LogHandler.info(uid, getClass(),
	                            " :.: cancelarPagoConexiaTarea: - monto_pagado: " + pago.get("monto_pagado").toString());
	                    Double montoPagado = Double.parseDouble(pago.get("monto_pagado").toString());
	                    double montoPago = 0.0;
	                    if (montoPagoPeticion >= montoPagado ) {
	                        montoPago = 0.0;
	                        montoPagoPeticion = montoPagoPeticion - montoPagado;
	                    }
	                    else {
	                        montoPago = montoPagado - montoPagoPeticion;
	                        montoPagoPeticion = 0.0;
	                    }
	                    //Actualiza pago convenio
	                    final java.util.HashMap<String , Object>  parametrosPago = new java.util.HashMap<String , Object>();
	                    parametrosPago.put("numero_convenio", datosConvenio.get("numero_convenio")  );
	                    parametrosPago.put("numero_pago", Integer.parseInt(pago.get("numero_pago").toString()));
	                    parametrosPago.put("monto_pagado", montoPago);
	                    parametrosPago.put("usuario_pago", peticion.getUsuario());
	                    parametrosPago.put("fecha_pago", new Date());
	                    parametrosPago.put("status", "D");
	                    if (montoPago == 0.0) {
	                        parametrosPago.put("usuario_pago", "");
	                        parametrosPago.put("fecha_pago", fechaInicio.getTime());
	                    }
	                    LogHandler.info(uid, getClass(),
	                            " :.: cancelarPagoConexiaTarea: - monto_pagadoUpdate: " + montoPago);
	                    LogHandler.info(uid, getClass(),
	                            " :.: cancelarPagoConexiaTarea: - montoPagoPeticion: " + montoPagoPeticion);

	                    LogHandler.trace(uid, getClass(), " :.: cancelarPagoConexiaTarea - actualizarPagoConvenioPagoConexia" );
	                    LogHandler.info(uid, getClass(), " :.: cancelarPagoConexiaTarea: - actualizarPagoConvenioPagoConexia");
	                    rows = sesionTx.update("actualizarPagoConvenioPagoConexia", parametrosPago);
	                    if (rows == 0) {
	                        throw new Exception(ReadProperties.mensajes.getProp("ciof.error.actualizacion"));
	                    }

	                }
	            }
	            sesionTx.commit();
	        }
	        catch (Exception ex) {
	            FabricaConexiones.rollBack(sesionTx);
	            LogHandler.error(uid, getClass(), " :.: cancelarPagoConexiaTarea: " + ex.getMessage(), ex);
	            cancelarPagoConexiaRespuesta.getHeader().setEstatus(false);
	            cancelarPagoConexiaRespuesta.getHeader().setMensaje(ReadProperties.mensajes.getProp("ciof.error.consulta"));
	            cancelarPagoConexiaRespuesta.getHeader().setCodigo(ex.getMessage());
	        }
	        finally {
	            FabricaConexiones.close(sesionNTx);
	            FabricaConexiones.close(sesionTx);
	        }
	        return cancelarPagoConexiaRespuesta;
	    }


	    /**
		 * @param peticion :
		 * @param uid identificador de la transaccion
		 * @return AplicarPagoRespuesta
		 */
		@SuppressWarnings("unchecked")
		public AplicarPagoRespuesta aplicarGarantiaLiquidacion(PagoGrupal peticion, String uid) {

			LogHandler.info(uid, getClass(), "aplicarGarantiaLiquidacion - Datos de entrada : " + peticion);

			AplicarPagoRespuesta respuesta = new AplicarPagoRespuesta();
			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setEstatus(true);
			respuesta.getHeader().setUID(uid);
			SqlSession sesionNTx = null;
			SqlSession sesionTx = null;
			Date fechaValor = null;

			//Validar si existe el contrato
			String numeroContrato = comun.obtenerNumeroContrato(uid, peticion.getNumeroContrato());
			// validaciones
			if (numeroContrato == null) {
				LogHandler.debug(uid,  getClass(), " ERROR: Contrato Inexistente: " + peticion.getNumeroContrato());
				respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensaje("Contrato Inexistente");
			}
			peticion.setNumeroContrato(numeroContrato);

			//validar si existe bandera de aplicacion de garantia para liquidacion y ademas es de garantia
			try {
				sesionNTx = FabricaConexiones.obtenerSesionNTx();

				HashMap<String, Object> params = new HashMap<String, Object>();

				params.put("contrato", numeroContrato);

				LogHandler.trace(uid, getClass(), "==> aplicarGarantiaLiquidacion - contratoGarantiaOpcionLiquidacion");
				Integer existe = (Integer) sesionNTx.selectOne("contratoGarantiaOpcionLiquidacion", params);
				LogHandler.info(uid, getClass(), "Es de garantia, tiene saldo y la opcion de aplicar para liquidacion=" + existe);
				if ( existe.intValue() > 0)  {

					sesionTx = FabricaConexiones.obtenerSesionTx();
					FechaContableOV datosFechaContable = comun.obtenerFechaContable(uid);

					Date fechaCont = datosFechaContable.getFecha();
								Calendar cal = new GregorianCalendar();
								cal.setTimeInMillis(fechaCont.getTime());
					fechaValor = cal.getTime();

					params.clear();
					params.put("contrato", numeroContrato);
					params.put("fechaActual", fechaValor);

					LogHandler.debug(uid, getClass(), " fechaActual: " + fechaValor );
					LogHandler.debug(uid, getClass(), " numeroContrato: " + numeroContrato);
					//obtener saldo a la fecha valor
					LogHandler.trace(uid, getClass(), "==> aplicarGarantiaLiquidacion - obtenerSaldoFv");
					CreditoSaldo creditoSaldo  = (CreditoSaldo) sesionTx.selectOne("obtenerSaldoFv", params);

					LogHandler.trace(uid, getClass(), "==> aplicarGarantiaLiquidacion - obtenerSaldoGarantia");
					HashMap<String, Object> datosGarantia
						= (HashMap<String, Object>) sesionNTx.selectOne("obtenerSaldoGarantia", params);
					String medioPago = datosGarantia.get("medio_pago").toString();
					Double saldoGarantia = Double.parseDouble(datosGarantia.get("saldo_garantia").toString());
					LogHandler.info(uid, getClass(), "Saldo Garantia=" + saldoGarantia);
					LogHandler.info(uid, getClass(), "Medio Pago=" + medioPago);

					if (creditoSaldo.getSaldoLiquidar() == null) {
						creditoSaldo.setSaldoLiquidar(0d);
					}
					double importeAplicarGarantia = 0;
					if ( saldoGarantia.doubleValue() > creditoSaldo.getSaldoLiquidar().doubleValue() ) {
						importeAplicarGarantia = creditoSaldo.getSaldoLiquidar().doubleValue();
					} else {
						importeAplicarGarantia = saldoGarantia.doubleValue();
					}

					peticion.setMonto(importeAplicarGarantia);
					peticion.setTipoPago("ABO");
					peticion.setMedioPago(medioPago  + "_");
					peticion.setReferencia("");

					PagoGrupalResponse respuestaAplicarPago = aplicarPagoGrupal(uid, sesionTx, null, peticion);
					if ( respuestaAplicarPago.getHeader().isEstatus()) {

						//Incluir Pago
						ConcurrentHashMap<String, Object> paramsMovimientos = new ConcurrentHashMap<String, Object>();
			    		paramsMovimientos.put("contrato", numeroContrato);
			    		paramsMovimientos.put("fechaContable", fechaValor);
			    		paramsMovimientos.put("fechaValor", fechaValor);
			    		paramsMovimientos.put("importe", importeAplicarGarantia);
			    		paramsMovimientos.put("codigo", "DGAA");
			    		paramsMovimientos.put("usuario", Constantes.USUARIO_SISTEMA);
			    		paramsMovimientos.put("noIntegrante", "");
			    		paramsMovimientos.put("folioCheque", 0);
			    		paramsMovimientos.put("montoCapital", "0");
			    		paramsMovimientos.put("montoInteres", "0");
			    		paramsMovimientos.put("montoRecargos", "0");
			    		paramsMovimientos.put("contratoTransaccion", "");
			    		paramsMovimientos.put("fechaBaja", "");
			    		paramsMovimientos.put("usuarioBaja", "");
			    		paramsMovimientos.put("fechaBaja", "");
			    		paramsMovimientos.put("usuarioBaja", "");

			    		LogHandler.trace(uid, getClass(), "==> aplicarGarantiaLiquidacion - insertContratoMovimientosGarantia");
			    		sesionTx.insert("insertContratoMovimientosGarantia", paramsMovimientos);

						//Descontar saldo garantia
			    		ConcurrentHashMap<String, Object> paramsActDepGar = new ConcurrentHashMap<String, Object>();
				    	paramsActDepGar.put("contrato", numeroContrato);
				    	paramsActDepGar.put("montoAplicar", importeAplicarGarantia);
				    	LogHandler.trace(uid, getClass(),
				    			"==> aplicarGarantiaLiquidacion - actualizaSaldoGarantiaDepositoGarantia");
				    	sesionTx.update("actualizaSaldoGarantiaDepositoGarantia", paramsActDepGar);

					} else {
						throw new Exception(respuestaAplicarPago.getHeader().getMensaje());
					}

					//COMMIT
					sesionTx.commit(true);
				}
			}
			catch (Exception ex) {
				FabricaConexiones.rollBack( sesionTx );
				LogHandler.error(uid, this.getClass(), " ERROR: Error al aplicar el pago ROLLBACK: " + ex.getMessage(), ex );
				respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensaje(ex.getMessage());
			}
			finally {
				FabricaConexiones.close(sesionNTx);
			}
			LogHandler.info(uid, getClass(), "aplicarGarantiaLiquidacion - Datos de salida : " + respuesta);
			return respuesta;
		}

		/**
		 * Esta operaci&oacute;n permite cancelar el pago realizado por problemas dentro de la plataforma de
		 * pago de servicios en l&iacute;nea.
		 * Esta operaci&oacute;n es s&oacute;lo por sistema ante fallas en el protocolo de comunicaci&oacute;n
		 * @param peticion datos del pago.
		 * @param uid identificador &uacute;nico de transacci&oacute;n.
		 * @return RespuestaReverseEnLineaOxxo respuesta.
		 */
		public RespuestaReverseEnLineaOxxo cancelarPagoEnLineaOxxoTarea(String uid, PeticionEnLineaOxxo peticion) {

			RespuestaReverseEnLineaOxxo respuesta = new RespuestaReverseEnLineaOxxo();
			LogHandler.info(uid, getClass(), "cancelarPagoEnLineaOxxoTarea - Datos de entrada : " +  peticion);

			SqlSession sesionNTx = null;
	        SqlSession sesionTx = null;
	        String validaStr = "";

			List<CancelaPagoConexiaValidaOV> movimientos = null;
			HashMap<String, Object> obtieneReferencia = null;
			try {

				//Se valida que el numero de referencia_3 de auditoria caja exista en la bas de datos
	            //antes de realizar la reversa
	            LogHandler.info(uid, getClass(), "cancelarPagoEnLineaOxxoTarea - obtieneReferencia de auditoria_caja ");
	            final java.util.HashMap<String, Object> paramReferencia = new HashMap<String, Object>();

	            // Se abre la sesion transaccional sybase
	            sesionTx = FabricaConexiones.obtenerSesionTx();

	            // Se abre la sesion No transaccional sybase
	            sesionNTx = FabricaConexiones.obtenerSesionNTx();

	            paramReferencia.put("referencia", peticion.getFolio().toString());
	            //paramReferencia.put("autorizacion", peticion.getAuth());
	            obtieneReferencia = (HashMap<String, Object>) sesionNTx.selectOne("obtieneReferencia", paramReferencia);

	            if (obtieneReferencia == null || obtieneReferencia.size() < 1) {
	            	respuesta.setCode(CatalogoDeEstados.CODIGO_07.getCodigo());
	            	respuesta.setErrorDesc(CatalogoDeEstados.CODIGO_07.getTitulo());
	            	respuesta.setMessageTicket(CatalogoDeEstados.CODIGO_07.getTitulo());
					throw new Exception( "No existe la referencia del contrato." );
				}

				String[] datosRequeridos = {obtieneReferencia.get("contrato").toString(),
						obtieneReferencia.get("fecha_contable").toString(),
						obtieneReferencia.get("monto").toString(), obtieneReferencia.get("clave_prod").toString()};
	            validaStr = Validaciones.datosRequeridos(peticion, datosRequeridos);

	            if (!validaStr.equalsIgnoreCase("")) {
	            	respuesta.setCode(CatalogoDeEstados.CODIGO_04.getCodigo());
	            	respuesta.setErrorDesc(CatalogoDeEstados.CODIGO_04.getTitulo());
	            	respuesta.setMessageTicket(CatalogoDeEstados.CODIGO_04.getTitulo());
	                throw new Exception(ReadProperties.mensajes.getProp("ciof.error.datos.requeridos") + " " + validaStr );
	            }


	            LogHandler.trace(uid, getClass(), " :.: cancelarPagoEnLineaOxxoTarea: - consultaPrGetFecha");

	            Date fechaContable = (Date) sesionNTx.selectOne("consultaPrGetFecha");
	            if (fechaContable == null) {
	            	respuesta.setCode(CatalogoDeEstados.CODIGO_05.getCodigo());
	            	respuesta.setErrorDesc(CatalogoDeEstados.CODIGO_05.getTitulo());
	            	respuesta.setMessageTicket(CatalogoDeEstados.CODIGO_05.getTitulo());
	                throw new Exception("No fue posible recuperar la fecha contable");
	            }

				//Validar si existe el contrato
				String numeroContrato = comun.obtenerNumeroContrato(uid, obtieneReferencia.get("contrato").toString());

				//Validaciones
				if (numeroContrato == null) {
					LogHandler.debug(uid, getClass(), "ERROR: Contrato Inexistente: " +
							obtieneReferencia.get("contrato").toString());
					respuesta.setCode(CatalogoDeEstados.CODIGO_02.getCodigo());
					respuesta.setErrorDesc(CatalogoDeEstados.CODIGO_02.getTitulo());
					respuesta.setMessageTicket(CatalogoDeEstados.CODIGO_02.getTitulo());
					throw new Exception("Contrato no válido, favor de verificar");
				}

				peticion.setAccount(numeroContrato);

				//Validar que exista el pago
				LogHandler.info(uid, getClass(), "cancelarPagoEnLineaOxxoTarea - fechaContable: " + fechaContable);
				final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();

				parametros.put("numeroContrato", numeroContrato);
				parametros.put("fechaContable", obtieneReferencia.get("fecha_contable").toString());
				parametros.put("medioPago", obtieneReferencia.get("clave_prod").toString());

				LogHandler.trace(uid, getClass(), "cancelarPagoEnLineaOxxoTarea: - consultaValidacionCancelacionPagoGarantia");
				movimientos = (List<CancelaPagoConexiaValidaOV>) sesionNTx.selectList(
						"consultaValidacionCancelacionPagoGarantia", parametros);

	            if (movimientos.isEmpty()) {
	            	respuesta.setCode(CatalogoDeEstados.CODIGO_07.getCodigo());
					respuesta.setErrorDesc(CatalogoDeEstados.CODIGO_07.getTitulo());
					respuesta.setMessageTicket(CatalogoDeEstados.CODIGO_07.getTitulo());
	                throw new Exception("La reversa ya fue aplicada para este folio");
	            }

	            for (CancelaPagoConexiaValidaOV movimiento:movimientos) {
	                if (movimiento.getMonto().equals(Double.parseDouble(obtieneReferencia.get("monto").toString()))) {
	                    LogHandler.info(uid, getClass(),
	                            "cancelarPagoEnLineaOxxoTarea: - movimiento.getMonto() == obtieneReferencia.get(monto) "
	                            + obtieneReferencia.get("monto").toString());
	                    respuesta.setIdReverse(Long.parseLong(movimiento.getIdTransaccion().toString()));
	                    break;
	                }
	            }

	            //cancelarMovimientos
	            if (respuesta.getIdReverse() == null) {
	            	respuesta.setCode(CatalogoDeEstados.CODIGO_02.getCodigo());
					respuesta.setErrorDesc(CatalogoDeEstados.CODIGO_02.getTitulo());
					respuesta.setMessageTicket(CatalogoDeEstados.CODIGO_02.getTitulo());
					throw new Exception("No existe el pago de OXXO con las caracteristicas enviadas [monto]");
	            }
	            LogHandler.info(uid, getClass(), "cancelarPagoEnLineaOxxoTarea: - id Transaccion: "
	            		+ respuesta.getIdReverse());

	            List<DetalleTransaccionOV> detalleTransaccionOVList = new ArrayList<DetalleTransaccionOV>();
	            DetalleTransaccionOV detalleTransaccionOV = new DetalleTransaccionOV();
	            detalleTransaccionOV.setIdTransaccion(Integer.parseInt(respuesta.getIdReverse().toString()));

	            SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
	    		Date fecha = null;
	    		try {
	    			fecha = formateador.parse(obtieneReferencia.get("fecha_contable").toString());
	    			//LOGGER.info("fecha: " + fecha);
	    		} catch (ParseException ex) {

	    			ex.printStackTrace();
	    		}

	            detalleTransaccionOV.setFechaContable(fecha);

	            detalleTransaccionOV.setMontoCancelacion(Double.parseDouble(obtieneReferencia.get("monto").toString()));
	            detalleTransaccionOVList.add(detalleTransaccionOV);

	            CancelarMovimientosPeticion cancelarMovimientosPeticion = new CancelarMovimientosPeticion();
	            cancelarMovimientosPeticion.setContrato(obtieneReferencia.get("contrato").toString());
	            cancelarMovimientosPeticion.setUsuario("000000043");
	            cancelarMovimientosPeticion.setTipoMovimiento("PAGO");
	            cancelarMovimientosPeticion.setTransacciones(detalleTransaccionOVList);
	            LogHandler.info(uid, getClass(), "cancelarPagoEnLineaOxxoTarea: - cancelarMovimientos()");

	            final CancelarMovimientosRespuesta
                cancelarMovimientosRespuesta = cancelarMovimientos( cancelarMovimientosPeticion, null, sesionTx, uid );

		        if (!cancelarMovimientosRespuesta.getHeaderRespuesta().isEstatus()) {
		        	respuesta.setCode(CatalogoDeEstados.CODIGO_02.getCodigo());
					respuesta.setErrorDesc(CatalogoDeEstados.CODIGO_02.getTitulo());
					respuesta.setMessageTicket(cancelarMovimientosRespuesta.getHeaderRespuesta().getMensaje());
		            throw new Exception(cancelarMovimientosRespuesta.getHeaderRespuesta().getCodigo());
		        }
		        else {
			        respuesta.setAccount(numeroContrato);
			        respuesta.setAmount(obtieneReferencia.get("monto").toString());
			        respuesta.setAuth((long) respuesta.getIdReverse().intValue());
			        respuesta.setCode(CatalogoDeEstados.CODIGO_00.getCodigo());
			        respuesta.setErrorDesc(CatalogoDeEstados.CODIGO_00.getTitulo());
			        respuesta.setMessageTicket(CatalogoDeEstados.CODIGO_00.getTitulo());
		        }

		        sesionTx.commit();
			}
			catch (Exception ex) {
				FabricaConexiones.rollBack(sesionTx);
				LogHandler.error(uid, this.getClass(), " ERROR: Error al aplicar el cancelar pago en linea Oxxo ROLLBACK: "
						+ ex.getMessage(), ex );

				if (respuesta.getCode() == null || respuesta.getErrorDesc() == null || respuesta.getMessageTicket() == null) {
					respuesta.setCode(CatalogoDeEstados.CODIGO_13.getCodigo());
					respuesta.setErrorDesc(CatalogoDeEstados.CODIGO_13.getTitulo());
					respuesta.setMessageTicket(CatalogoDeEstados.CODIGO_13.getTitulo());
				}
			}
			finally {
	            FabricaConexiones.close(sesionNTx);
	            FabricaConexiones.close(sesionTx);
	        }
			return respuesta;
		}

		/**
		 * Esta operaci&oacute;n permite cancelar el pago realizado por problemas dentro de la plataforma de
		 * pago de servicios en l&iacute;nea.
		 * Esta operaci&oacute;n es s&oacute;lo por sistema ante fallas en el protocolo de comunicaci&oacute;n
		 * @param peticion datos del pago.
		 * @param uid identificador &uacute;nico de transacci&oacute;n.
		 * @return RespuestaReverseEnLineaOxxo respuesta.
		 */
		@SuppressWarnings("unchecked")
		public CancelarPagoConexiaRespuesta cancelarPagoEnLineaTarea(String uid, CancelarPagoConexiaPeticion peticion, SqlSession sesion) {
			CancelarPagoConexiaRespuesta cancelarPagoLineaEnOxxo = new CancelarPagoConexiaRespuesta();

			LogHandler.info(uid, getClass(), "cancelarPagoEnLineaTarea - Datos de entrada : " +  peticion);

			SqlSession sesionNTx = null;
	        SqlSession sesionTx = null;
	        String validaStr = "";
			List<CancelaPagoConexiaValidaOV> movimientos = null;
			try {

				String[] datosRequeridos = {"numeroContrato", "fechaValor", "monto", "usuario", "medioPago"};
				LogHandler.info(uid, getClass(), "cancelarPagoEnLineaTarea - datosRequeridos : " +  datosRequeridos);
	            validaStr = Validaciones.datosRequeridos(peticion, datosRequeridos);
	            if (!validaStr.equalsIgnoreCase("")) {
	                throw new Exception(ReadProperties.mensajes.getProp("ciof.error.datos.requeridos") + " " + validaStr );
	            }

	            if (sesion == null) {
	            	//Se abre la sesion transaccional sybase
	            	sesionTx = FabricaConexiones.obtenerSesionTx();
	            } else {
	            	sesionTx = sesion;
	            }

	            //Se abre la sesion No transaccional sybase
	            sesionNTx = FabricaConexiones.obtenerSesionNTx();

	            LogHandler.trace(uid, getClass(), " :.: cancelarPagoEnLineaTarea: - consultaPrGetFecha");
	            Date fechaContable = (Date) sesionNTx.selectOne("consultaPrGetFecha");
	            if (fechaContable == null) {
	            	throw new Exception("No fue posible recuperar la fecha contable");
	            }

	            //Se obtiene numero de contrato credprod
				peticion.setNumeroContrato(comun.obtenerNumeroContrato(uid, peticion.getNumeroContrato()));

				//Validar que exista el pago
				LogHandler.info(uid, getClass(), "cancelarPagoEnLineaTarea - fechaContable: " + fechaContable);
				final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();

				parametros.put("numeroContrato", peticion.getNumeroContrato());
				parametros.put("fechaContable", peticion.getFechaValor());
				parametros.put("medioPago", peticion.getMedioPago());

				LogHandler.trace(uid, getClass(), "cancelarPagoEnLineaTarea: - consultaValidacionCancelacionPagoGarantia");
				movimientos = (List<CancelaPagoConexiaValidaOV>) sesionNTx.selectList(
						"consultaValidacionCancelacionPagoGarantia", parametros);

				if (movimientos.isEmpty()) {
					 throw new Exception("No existe el pago de Linea con las caracteristicas enviadas"
	                			+ "[fecha contable, contrato, codigo servicio]");
				}
				LogHandler.info(uid, getClass(), "cancelarPagoEnLineaTarea: - peticion.getMonto(): " + peticion.getMonto());

				for (CancelaPagoConexiaValidaOV movimiento:movimientos) {
	                if (movimiento.getMonto().equals(peticion.getMonto())) {
	                    LogHandler.info(uid, getClass(),
	                            "cancelarPagoEnLineaTarea: - movimiento.getMonto() == peticion.getMonto()");
	                    cancelarPagoLineaEnOxxo.setIdTransaccion(movimiento.getIdTransaccion());
	                    break;
	                }
	            }

				List<DetalleTransaccionOV> detalleTransaccionOVList = new ArrayList<DetalleTransaccionOV>();
		        DetalleTransaccionOV detalleTransaccionOV = new DetalleTransaccionOV();
	            detalleTransaccionOV.setIdTransaccion(cancelarPagoLineaEnOxxo.getIdTransaccion());
	            detalleTransaccionOV.setFechaContable(peticion.getFechaValor());
	            detalleTransaccionOV.setMontoCancelacion(peticion.getMonto());
	            detalleTransaccionOVList.add(detalleTransaccionOV);

	            CancelarMovimientosPeticion cancelarMovimientosPeticion = new CancelarMovimientosPeticion();
	            cancelarMovimientosPeticion.setContrato(peticion.getNumeroContrato());
	            cancelarMovimientosPeticion.setUsuario(peticion.getUsuario());
	            cancelarMovimientosPeticion.setTipoMovimiento("PAGO");
	            cancelarMovimientosPeticion.setTransacciones(detalleTransaccionOVList);
	            LogHandler.info(uid, getClass(), " :.: cancelarPagoEnLineaTarea: - cancelarMovimientos()");
	            final 	CancelarMovimientosRespuesta
	                    cancelarMovimientosRespuesta = cancelarMovimientos( cancelarMovimientosPeticion, null, sesionTx, uid );

	            if (!cancelarMovimientosRespuesta.getHeaderRespuesta().isEstatus()) {
	                throw new Exception(cancelarMovimientosRespuesta.getHeaderRespuesta().getCodigo());
	            }

	            if (sesion == null) {
	            	sesionTx.commit();
	            }

	            cancelarPagoLineaEnOxxo.setHeader(generarHeader(uid, true, "Cancelacion realizada correctamente"));
			}
			catch (Exception ex) {
				if (sesion == null) {
					FabricaConexiones.rollBack(sesionTx);
				}
				LogHandler.error(uid, this.getClass(), " ERROR: Error al aplicar el cancelar pago en linea ROLLBACK: "
						+ ex.getMessage(), ex );
				cancelarPagoLineaEnOxxo.setHeader(generarHeader(uid, false, ex.getMessage()));
			}
			finally {
	            FabricaConexiones.close(sesionNTx);
	            if (sesion == null) {
	            	FabricaConexiones.close(sesionTx);
	            }
	        }
			return cancelarPagoLineaEnOxxo;
		}

		/**
		 * Cancelar un pago proveniente de una garantia
		 * @param peticion Datos del pago para realizar la cancelacion
		 * @param uid identificador unico de la transaccion
		 * @return resultado de la cancelacion del pago
		 */
		@SuppressWarnings("unchecked")
		public CancelarPagoConexiaRespuesta cancelarPagoGarantiaTarea(CancelarPagoConexiaPeticion peticion, String uid) {
	        CancelarPagoConexiaRespuesta cancelarPagoConexiaRespuesta = new  CancelarPagoConexiaRespuesta();
	        cancelarPagoConexiaRespuesta.setHeader(new EncabezadoRespuesta());
	        cancelarPagoConexiaRespuesta.getHeader().setUID(uid);
	        cancelarPagoConexiaRespuesta.getHeader().setEstatus(true);
	        SqlSession sesionNTx = null;
	        SqlSession sesionTx = null;
	        String validaStr = "";
	        List<CancelaPagoConexiaValidaOV> movimientos = null;
	        try {
	            String[] datosRequeridos = {"numeroContrato", "fechaValor", "monto", "usuario", "medioPago"};
	            validaStr = Validaciones.datosRequeridos(peticion, datosRequeridos);
	            if (!validaStr.equalsIgnoreCase("")) {
	                throw new Exception(ReadProperties.mensajes.getProp("ciof.error.datos.requeridos") + " " + validaStr );
	            }
	            // Se abre la sesion transaccional sybase
	            sesionTx = FabricaConexiones.obtenerSesionTx();
	            // Se abre la sesion No transaccional sybase
	            sesionNTx = FabricaConexiones.obtenerSesionNTx();
	            LogHandler.trace(uid, getClass(), " :.: cancelarPagoGarantiaTarea: - consultaPrGetFecha");
	            Date fechaContable = (Date) sesionNTx.selectOne("consultaPrGetFecha");
	            if (fechaContable == null) {
	                throw new Exception("No fue posible recuperar la fecha contable");
	            }
	            LogHandler.info(uid, getClass(), " :.: cancelarPagoGarantiaTarea: - fechaContable: " + fechaContable);

	            //Se obtiene numero de contrato credprod
				peticion.setNumeroContrato(comun.obtenerNumeroContrato(uid, peticion.getNumeroContrato()));

	            //Validar que exista el pago
				LogHandler.info(uid, getClass(), "cancelarPagoGarantiaTarea: - fechaContable: " + fechaContable);
	            final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
	            parametros.put("numeroContrato", peticion.getNumeroContrato());
	            parametros.put("fechaContable", peticion.getFechaValor());
	            parametros.put("medioPago", peticion.getMedioPago());
	            LogHandler.trace(uid, getClass(), "cancelarPagoGarantiaTarea: - consultaValidacionCancelacionPagoGarantia");
	            movimientos = (List<CancelaPagoConexiaValidaOV>) sesionNTx.selectList(
	                            "consultaValidacionCancelacionPagoGarantia", parametros);
	            if (movimientos.isEmpty()) {
	                throw new Exception("No existe el pago de garantia con las caracteristicas enviadas"
	                			+ "[fecha contable, contrato, codigo servico]");
	            }
	            LogHandler.info(uid, getClass(), "cancelarPagoGarantiaTarea: - peticion.getMonto(): " + peticion.getMonto());
	            for (CancelaPagoConexiaValidaOV movimiento:movimientos) {
	                if (movimiento.getMonto().equals(peticion.getMonto())) {
	                    LogHandler.info(uid, getClass(),
	                            "cancelarPagoGarantiaTarea: - movimiento.getMonto() == peticion.getMonto()");
	                    cancelarPagoConexiaRespuesta.setIdTransaccion(movimiento.getIdTransaccion());
	                    break;
	                }
	            }

				// cancelarMovimientos
	            if (cancelarPagoConexiaRespuesta.getIdTransaccion() == null) {
	                throw new Exception("No existe el pago de garantia con las caracteristicas enviadas [monto]");
	            }
	            LogHandler.info(uid, getClass(), " :.: cancelarPagoGarantiaTarea: - id Transaccion: "
	            		+ cancelarPagoConexiaRespuesta.getIdTransaccion());

	            List<DetalleTransaccionOV> detalleTransaccionOVList = new ArrayList<DetalleTransaccionOV>();
	            DetalleTransaccionOV detalleTransaccionOV = new DetalleTransaccionOV();
	            detalleTransaccionOV.setIdTransaccion(cancelarPagoConexiaRespuesta.getIdTransaccion());
	            detalleTransaccionOV.setFechaContable(peticion.getFechaValor());
	            detalleTransaccionOV.setMontoCancelacion(peticion.getMonto());
	            detalleTransaccionOVList.add(detalleTransaccionOV);

	            CancelarMovimientosPeticion cancelarMovimientosPeticion = new CancelarMovimientosPeticion();
	            cancelarMovimientosPeticion.setContrato(peticion.getNumeroContrato());
	            cancelarMovimientosPeticion.setUsuario(peticion.getUsuario());
	            cancelarMovimientosPeticion.setTipoMovimiento("PAGO");
	            cancelarMovimientosPeticion.setTransacciones(detalleTransaccionOVList);
	            LogHandler.info(uid, getClass(), " :.: cancelarPagoGarantiaTarea: - cancelarMovimientos()");
	            final 	CancelarMovimientosRespuesta
	                    cancelarMovimientosRespuesta = cancelarMovimientos( cancelarMovimientosPeticion, null, sesionTx, uid );

	            if (!cancelarMovimientosRespuesta.getHeaderRespuesta().isEstatus()) {
	                throw new Exception(cancelarMovimientosRespuesta.getHeaderRespuesta().getCodigo());
	            }

	            sesionTx.commit();
	        }
	        catch (Exception ex) {
	            FabricaConexiones.rollBack(sesionTx);
	            LogHandler.error(uid, getClass(), " :.: cancelarPagoGarantiaTarea: " + ex.getMessage(), ex);
	            cancelarPagoConexiaRespuesta.getHeader().setEstatus(false);
	            cancelarPagoConexiaRespuesta.getHeader().setMensaje(ex.getMessage());

	        }
	        finally {
	            FabricaConexiones.close(sesionNTx);
	            FabricaConexiones.close(sesionTx);
	        }
	        return cancelarPagoConexiaRespuesta;
	    }

		/**
		 * Metodo para consultar el universo de pagos no conciliados
		 * @param uid Identificador unico de la transaccion
		 * @param peticion filtros de la busqueda
	 	 * @return el universo de pagos
		 */
		@SuppressWarnings("unchecked")
		public ConsultarPagosRespuesta consultarPagosNoConciliados(String uid, ConsultarPagosPeticion peticion) {
			ConsultarPagosRespuesta respuesta = new ConsultarPagosRespuesta();
			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setEstatus(true);
	        SqlSession sesionNTx = null;
	        String validaStr = "";
	        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
	        Date fechaInicioUniverso;

	        try {
	            String[] datosRequeridos = {"medioPago", "fechaInicial", "fechaFinal"};
	            validaStr = Validaciones.datosRequeridos(peticion, datosRequeridos);
	            if (!validaStr.equalsIgnoreCase("")) {
	                throw new Exception(ReadProperties.mensajes.getProp("ciof.error.datos.requeridos") + " " + validaStr );
	            }

	            LogHandler.trace(uid, getClass(), "consultarPagosNoConciliados: - obtenerParGeneral");
	     		ParGeneralOV fechaUniverso = comun.obtenerParGeneralOV(uid, "mx.com.finsol.pagos.conciliacion.fecha.universo");

	            LogHandler.trace(uid, getClass(), "consultarPagosNoConciliados: - obtenerParGeneral");
	     		ParGeneralOV procesos = comun.obtenerParGeneralOV(uid,
	     				"mx.com.finsol.pagos.conciliacion.mediopago." + peticion.getMedioPago());

	     		fechaInicioUniverso = formateador.parse(fechaUniverso.getCgValor().trim());

	            // Se abre la sesion No transaccional sybase
	            sesionNTx = FabricaConexiones.obtenerSesionNTx();

	            List<String> listaProcesos = Arrays.asList(procesos.getCgValor().split(";"));

	            if (peticion.getReferencia() != null) {
	            	if (peticion.getReferencia().trim().isEmpty()) {
	            		peticion.setReferencia(null);
	            	}
	            }

	            final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
	            parametros.put("procesos", listaProcesos);
	            parametros.put("fechaUniverso", fechaInicioUniverso);
	            parametros.put("referencia", peticion.getReferencia());
	            parametros.put("fechaInicial", formateador.parse(peticion.getFechaInicial()));
	            parametros.put("fechaFinal", formateador.parse(peticion.getFechaFinal()));

	            LogHandler.trace(uid, getClass(), "consultarPagosNoConciliados: - consultaUniverso");

	            List<PagoDTO> pagos = (List<PagoDTO>) sesionNTx.selectList(
	                            "consultarPagosNoConciliados", parametros);
	            if (pagos.isEmpty()) {
	                throw new Exception("No existen pagos por conciliar con las caracteristicas enviadas");
	            }

	            respuesta.setPagos(pagos);

	        }
	        catch (Exception ex) {
	            LogHandler.error(uid, getClass(), " :.: cancelarPagoGarantiaTarea: " + ex.getMessage(), ex);
	            respuesta.getHeader().setEstatus(false);
	            respuesta.getHeader().setMensaje(ex.getMessage());
	        }
	        finally {
	            FabricaConexiones.close(sesionNTx);
	        }
	        return respuesta;
	    }

		/**
		 * Metodo para aplicar los pagos no conciliados
		 * @param uid Identificador unico de la transaccion
		 * @param pagos lista de pagos por conciliar
		 * @return resultado
		 */
		@SuppressWarnings("unchecked")
		public RespuestaConciliarPagos aplicarPagosNoConciliados(String uid, List<PagoDTO> pagos) {
			RespuestaConciliarPagos respuesta = new RespuestaConciliarPagos();
			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setEstatus(true);
			SqlSession sesionNTx = null;
			SqlSession sesionTx = null;
			ParGeneralOV productosGarantia = null;
			SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat formateadorGarantia = new SimpleDateFormat("dd/MM/yyyy");
			LogHandler.trace(uid, getClass(), "consultarPagosNoConciliados: - obtenerParGeneral");
     		try {

				productosGarantia
					= comun.obtenerParGeneralOV(uid, "mx.com.independencia.depositos.garantia.tipo.producto");
				List<String> listaProductos = Arrays.asList(productosGarantia.getCgValor().split(";"));

			for (PagoDTO pago : pagos) {
				try {
					 pago.setEstatus(true);
					 pago.setMensaje("Pago Aplicado Correctamente.");

					 if (pago.getIdRegistro() == null || pago.getIdRegistro().trim().isEmpty()) {
						 throw new Exception("El id Registro es obligatorio.");
					 }
					 if (pago.getMedioPago() == null || pago.getMedioPago().trim().isEmpty()) {
						 throw new Exception("El medio de pago es obligatorio.");
					 }
					 if (pago.getContratoAplicar() == null || pago.getContratoAplicar().trim().isEmpty()) {
						 throw new Exception("El contrato aplicar es obligatorio.");
					 }
					 if (pago.getMonto() <= 0) {
						 throw new Exception("El importe aplicar es obligatorio.");
					 }
					 if (pago.getCuentaAplicar() == null || pago.getCuentaAplicar().trim().isEmpty()) {
						 throw new Exception("El contrato aplicar es obligatorio.");
					 }
					 if (pago.getUsuario() == null || pago.getUsuario().trim().isEmpty()) {
						 throw new Exception("El usuario de la operacion es obligatorio.");
					 }
					 if (pago.getFechaProceso() == null || pago.getFechaProceso().trim().isEmpty()) {
						 throw new Exception("El fecha de la operacion es obligatorio.");
					 }
					 String contrato = comun.obtenerNumeroContrato(uid, pago.getContratoAplicar());

					 if (contrato == null || contrato.trim().isEmpty()) {
						 throw new Exception(
							"El Número de contrato ingresado para aplicar el pago a la referencia [No_Referencia] no existe.");
					 }

					 if (!(pago.getCuentaAplicar().equals("PAGO") || pago.getCuentaAplicar().equals("GARANTIA"))) {
						 throw new Exception("La cuenta aplicar es incorrecta PAGO ó GARANTIA.");
					 }

					 if (!(pago.getMedioPago().trim().equals("BANCOMER")
							 || pago.getMedioPago().trim().equals("HSBC")
							 || pago.getMedioPago().trim().equals("BANAMEX")
						)) {
						 throw new Exception("El medio de pago es incorrecta BANCOMER, HSBC ó BANAMEX.");
					 }

					 // Se abre la sesion No transaccional sybase
			         sesionNTx = FabricaConexiones.obtenerSesionNTx();
			         final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			         parametros.put("contrato", contrato);
			         HashMap<String, String> datosContrato = (HashMap<String, String>) sesionNTx.selectOne(
	                            "consultaDatosContratoConciliar", parametros);

			         if (datosContrato.get("status").equals("P")
			        		 ||	 datosContrato.get("status").equals("X")) {
			        	 throw new Exception("El número de contrato ingresado tiene estatus Cancelado o Liquidado, "
			        			 + "no es posible conciliar el pago");
			         }

			         //Validamos el estatus del pago a conciliar
			         parametros.put("idRegistro", pago.getIdRegistro());
			         int noRegistros = (Integer) sesionNTx.selectOne("consultaPagoConciliado", parametros);
			         if (noRegistros == 0) {
			        	 throw new Exception("El pago ya no existe para conciliar");
			         }

			         sesionTx = FabricaConexiones.obtenerSesionTx();

			         if (pago.getCuentaAplicar().trim().equals("PAGO")) {
			        	 String medioPago = "";
			        	 if ( pago.getMedioPago().trim().equals("BANCOMER") ) {
			        		 medioPago = "BCOM";
			        	 } else if ( pago.getMedioPago().trim().equals("HSBC") ) {
			        		 medioPago = "HSBC";
			        	 } else if ( pago.getMedioPago().trim().equals("BANAMEX") ) {
			        		 medioPago = "BMEX";
			        	 }

			        	LogHandler.info(uid, getClass(), "consultarPagosNoConciliados: - medioPago= " + medioPago);
						final PagoGrupal pagoGrupal = new PagoGrupal();
						pagoGrupal.setMonto(pago.getMonto());
						pagoGrupal.setNumeroContrato(contrato);
						pagoGrupal.setFechaValor(formateador.parse(pago.getFechaProceso()));
						pagoGrupal.setMedioPago(medioPago);
						pagoGrupal.setReferencia("");
						pagoGrupal.setTipoPago("NORM");
						pagoGrupal.setUsuario(pago.getUsuario());
						pagoGrupal.setCodigo(ConstantesPagos.PAGO_REFERENCIADO.getValue());

						PagoGrupalResponse pagoResponse = new PagoGrupalResponse();
						pagoResponse = aplicarPagoGrupal(uid, sesionTx, null, pagoGrupal);

						if ( !pagoResponse.getHeader().isEstatus()) {
							throw new Exception(pagoResponse.getHeader().getMensaje());
						}

			         } else if (pago.getCuentaAplicar().equals("GARANTIA")) {
			        	 boolean esGarantia = false;
			        	 for ( String producto : listaProductos) {
			        		 if (datosContrato.get("producto").trim().equals(producto)) {
			        			 esGarantia = true;
			        		 }
			        	 }
			        	 if (!esGarantia) {
			        		 throw new Exception("El pago no pudo ser aplicado, el contrato no es del producto garantia.");
			        	 }

			        	 String medioPago = "";
			        	 if ( pago.getMedioPago().trim().equals("BANCOMER") ) {
			        		 medioPago = "GBCM_";
			        	 } else if ( pago.getMedioPago().trim().equals("HSBC") ) {
			        		 medioPago = "GHSB_";
			        	 } else if ( pago.getMedioPago().trim().equals("BANAMEX") ) {
			        		 medioPago = "GBMX_";
			        	 }

			        	ParGeneralOV urlDepgar = comun.obtenerParGeneralOV(uid, "DEPGAR_WS");
			     		LogHandler.debug( uid, getClass(), "valor de DEPGAR_WS: " + urlDepgar.getCgValor() );
			     		if (urlDepgar == null || urlDepgar.getCgValor().trim().isEmpty()) {
			     			throw new Exception("No fue posible obtener la URL del servicio depositos garantia.");
			     		}
			     		DepositosGarantiaWS_ServiceLocator ws = new DepositosGarantiaWS_ServiceLocator();
			     		ws.setDepositosGarantiaWSPortEndpointAddress(urlDepgar.getCgValor().trim());

			        	 DepositosGarantiaPeticion peticionGarantia = new DepositosGarantiaPeticion();
			        	 peticionGarantia.setContrato(contrato);
			        	 peticionGarantia.setImporte(pago.getMonto());
			        	 peticionGarantia.setUsuario(pago.getUsuario());
			        	 peticionGarantia.setMedioPago(medioPago);
			        	 String fechaGarantia = formateadorGarantia.format(formateador.parse(pago.getFechaProceso()));
			        	 peticionGarantia.setFecha(fechaGarantia);

			        	 String respuestaGarantia = ws.getDepositosGarantiaWSPort().registrarDepositosGarantia(
			        			 peticionGarantia);
			        	 LogHandler.info(uid, getClass(), "consultarPagosNoConciliados: - respuestaGarantia= "
			        			 + respuestaGarantia);
			        	 if ( respuestaGarantia == null || respuestaGarantia.trim().isEmpty()) {
			        		 throw new Exception("No fue posible generar el deposito de garantia.");
			        	 }
			        	 if ( respuestaGarantia.contains("false"))  {
			        		 throw new Exception("Hubo un error en aplicar el deposito de garantia.");
			        	 }
			         }

			         //Actualizar pagos_externos
			         final java.util.HashMap<String, Object> parametrosUpdate = new HashMap<String, Object>();
			         parametrosUpdate.put("idRegistro", pago.getIdRegistro());
			         parametrosUpdate.put("status", "A");
			         parametrosUpdate.put("observaciones", "APLICACION CONCILIACION" + " | " + pago.getUsuario()
			        		 + " | " + contrato + " | " + pago.getCuentaAplicar());

			         int actualizados = sesionTx.update("actualizarPagoConciliar", parametrosUpdate);

			         if ( actualizados == 0) {
			        	 throw new Exception("No fue posible marcar como conciliado el pago");
			         }

			         sesionTx.commit();
				}
				catch (Exception ex) {
		            LogHandler.error(uid, getClass(), " :.: aplicarPagosNoConciliados: " + ex.getMessage(), ex);
		            FabricaConexiones.rollBack(sesionTx);
		            pago.setEstatus(false);
		            pago.setMensaje(ex.getMessage());
		        }
				finally {
						FabricaConexiones.close(sesionTx);
			            FabricaConexiones.close(sesionNTx);
			    }
			}

			respuesta.setPagos(pagos);
     		} catch (Exception e) {
     			LogHandler.error(uid, getClass(), " :.: aplicarPagosNoConciliados: " + e.getMessage(), e);
	            respuesta.getHeader().setEstatus(false);
	            respuesta.getHeader().setMensaje(e.getMessage());
			}

			return respuesta;
		}

	@SuppressWarnings("unchecked")
	public ConsultarPagosLineaRespuesta consultarPagosLineaDuplicados(String uid, ConsultarPagosPeticion peticion) {
		ConsultarPagosLineaRespuesta respuesta = new ConsultarPagosLineaRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		try {
			if ( peticion.getFechaInicial() == null || peticion.getFechaInicial().trim().isEmpty()) {
				throw new Exception("La fecha inicial es obligatoria en la petición");
			}
			ParGeneralOV dias = comun.obtenerParGeneralOV(uid, "mx.com.finsol.oxxo.dias.buscar");
     		LogHandler.debug( uid, getClass(), "valor de DIAS: " + dias.getCgValor() );
     		if (dias == null || dias.getCgValor().trim().isEmpty()) {
     			throw new Exception("No fue posible obtener la URL del servicio REST.");
     		}
     		LogHandler.trace(uid, getClass(), "consultarPlanillaAprobacionTarea: - obtenerParGeneral");
			ParGeneralOV urlEdoCuenta = comun.obtenerParGeneralOV(uid, "BURO_UEDOC");
			Date fechaInicial = new Date();
			fechaInicial = format.parse(peticion.getFechaInicial());
			sesionNTx = FabricaConexiones.obtenerSesionBatch();
	        final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
	        parametros.put("fechaInicial", fechaInicial);
	        parametros.put("dias", Integer.parseInt(dias.getCgValor()));
	        List<PagoLineaDTO> pagos = new ArrayList<PagoLineaDTO>();
	        pagos = (List<PagoLineaDTO>) sesionNTx.selectList("consultaPagosLineaDuplicados", parametros);
	        for ( PagoLineaDTO pago : pagos) {
	        	pago.setEstadoCuenta(urlEdoCuenta.getCgValor() + pago.getContrato());
	        }
	        respuesta.setPagos(pagos);
		} catch (Exception e) {
 			LogHandler.error(uid, getClass(), " :.: consultarPagosLineaDuplicados: " + e.getMessage(), e);
            respuesta.getHeader().setEstatus(false);
            respuesta.getHeader().setMensaje(e.getMessage());
		}
		finally {
            FabricaConexiones.close(sesionNTx);
        }
		return respuesta;
	}

	public ReversarPagoOxxoRespuesta reversarPagoOxxo(String uid, ReversarPagoOxxoPeticion peticion) {
		ReversarPagoOxxoRespuesta respuesta = new ReversarPagoOxxoRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionTx = null;
		try {

			if (peticion.getFolio() == null || peticion.getFolio().trim().isEmpty()) {
				throw new Exception("El folio es obligatorio en la petición.");
			}
			if (peticion.getContrato() == null || peticion.getContrato().trim().isEmpty()) {
				throw new Exception("El contrato es obligatorio en la petición.");
			}
			if (peticion.getUsuario() == null || peticion.getUsuario().trim().isEmpty()) {
				throw new Exception("El usuario es obligatorio en la petición.");
			}
			if (peticion.getMonto() <= 0) {
				throw new Exception("El monto es obligatorio en la petición.");
			}

			ParGeneralOV url = comun.obtenerParGeneralOV(uid, "mx.com.finsol.oxxo.reversa.rest");
     		LogHandler.debug( uid, getClass(), "valor de REST: " + url.getCgValor() );
     		if (url == null || url.getCgValor().trim().isEmpty()) {
     			throw new Exception("No fue posible obtener la URL del servicio REST.");
     		}
			Client client = Client.create();
			WebResource webResource = client.resource(url.getCgValor());
			String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
					+ "<OLS version=\"1.0\"> "
					+ "<auth></auth>"
					+ "<token>OXXO_PROPAGOS10</token> "
		 		    + "<folio>" + peticion.getFolio() + "</folio> "
					+ "</OLS>";
			InputStream input = new ByteArrayInputStream(xml.getBytes());
			ClientResponse response = webResource.post(ClientResponse.class, input);
			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			sesionTx = FabricaConexiones.obtenerSesionTx();
			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("contrato", peticion.getContrato());
	        parametros.put("folio", peticion.getFolio());
	        parametros.put("monto", peticion.getMonto());
	        parametros.put("usuario_ejecuta", peticion.getUsuario());
			int insertados = sesionTx.update("insertarPagoLineaEliminado", parametros);
			if ( insertados == 0) {
	        	 throw new Exception("No fue posible ibnsertar el pago eliminado.");
	         }
			sesionTx.commit();
		} catch (Exception e) {
			FabricaConexiones.rollBack(sesionTx);
 			LogHandler.error(uid, getClass(), " :.: consultarPagosLineaDuplicados: " + e.getMessage(), e);
            respuesta.getHeader().setEstatus(false);
            respuesta.getHeader().setMensaje(e.getMessage());
		}
		finally {
            FabricaConexiones.close(sesionTx);
        }

		return respuesta;
	}

	public AlmacenarArchivoOxxoRespuesta almacenarArchivoOxxo(String uid, AlmacenarArchivoOxxoPeticion peticion) {
		AlmacenarArchivoOxxoRespuesta respuesta = new AlmacenarArchivoOxxoRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionTx = null;
		SqlSession sesionNTx = null;
		try {

			if (peticion.getArchivo() == null || peticion.getArchivo().trim().isEmpty()) {
				throw new Exception("El archivo es obligatorio en la petición.");
			}
			peticion.setArchivo(peticion.getArchivo().trim());
			if (peticion.getUsuario() == null || peticion.getUsuario().trim().isEmpty()) {
				throw new Exception("El usuario es obligatorio en la petición.");
			}
			peticion.setUsuario(peticion.getUsuario().trim());
			if (peticion.getRegistros().size() == 0) {
				throw new Exception("La lista de registros debe tener al menos un registro.");
			}
			int i = 0;
			for ( RegistroOxxoArchivo registro : peticion.getRegistros()) {
				i++;
				String mensaje = "Registro [" + i + "]: ";
				if (registro.getFechaOperacion() == null || registro.getFechaOperacion().trim().isEmpty()) {
					throw new Exception(mensaje + "Fecha Operacion Obligatoria.");
				} else {
					registro.setFechaOperacion(registro.getFechaOperacion().trim());
				}
				if (registro.getMonto() <= 0) {
					throw new Exception(mensaje + "Monto Obligatoria.");
				}
				if (registro.getCiudad() == null) {
					registro.setCiudad("");
				} else {
					registro.setCiudad(registro.getCiudad().trim());
				}
				if (registro.getSucursalOxxo() == null) {
					registro.setSucursalOxxo("");
				} else {
					registro.setSucursalOxxo(registro.getSucursalOxxo().trim());
				}
				if (registro.getReferencia() == null) {
					registro.setReferencia("");
				} else {
					registro.setReferencia(registro.getReferencia().trim());
				}
				if (registro.getHora() == null) {
					registro.setHora("");
				} else {
					registro.setHora(registro.getHora().trim());
				}
				if (registro.getReferencia().length() >= Constantes.DIEZ ) {
					registro.setContrato(comun.obtenerNumeroContrato(uid,
						"LD" + registro.getReferencia().substring(0, Constantes.DIEZ)));
					if (registro.getContrato() == null) {
						registro.setContrato("");
					}
				} else {
					registro.setContrato("");
				}

			}
			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("archivo", peticion.getArchivo());
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			//Validar que no exista el archivo
			int existe = (Integer) sesionNTx.selectOne("validarArchivoOxxo", parametros);

			if (existe != 0) {
				throw new Exception("El archivo que se intenta cargar ya existe ["
							+  peticion.getArchivo() + "]");
			}
			sesionTx = FabricaConexiones.obtenerSesionTx();
			parametros.put("usuario", peticion.getUsuario());
			sesionTx.selectOne("insertarArchivoOxxo", parametros);
			int id = (Integer) sesionTx.selectOne("consultaIdTablaArchivoOxxo", parametros);

			LogHandler.info(uid, getClass(), "id archivo:" + id);
			for ( RegistroOxxoArchivo registro : peticion.getRegistros()) {
				parametros.put("idArchivo", id);
				parametros.put("ciudad", registro.getCiudad());
				parametros.put("sucursal_oxxo", registro.getSucursalOxxo());
				parametros.put("referencia", registro.getReferencia());
				parametros.put("fecha_operacion", registro.getFechaOperacion());
				parametros.put("hora", registro.getHora());
				parametros.put("monto", registro.getMonto());
				parametros.put("contrato", registro.getContrato());
				sesionTx.selectOne("insertarRegistroArchivoOxxo", parametros);
			}
			sesionTx.commit();
		} catch (Exception e) {
			FabricaConexiones.rollBack(sesionTx);
				LogHandler.error(uid, getClass(), " :.: almacenarArchivoOxxo: " + e.getMessage(), e);
	        respuesta.getHeader().setEstatus(false);
	        respuesta.getHeader().setMensaje(e.getMessage());
		}
		finally {
	        FabricaConexiones.close(sesionTx);
	        FabricaConexiones.close(sesionNTx);
	    }
		return respuesta;
	}
	@SuppressWarnings("unchecked")
	public ConsultarPagosLineaRespuesta consultarPagosLineaNoEncontrados(String uid, ConsultarPagosPeticion peticion) {
		ConsultarPagosLineaRespuesta respuesta = new ConsultarPagosLineaRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		try {
			if ( peticion.getFechaInicial() == null || peticion.getFechaInicial().trim().isEmpty()) {
				throw new Exception("La fecha inicial es obligatoria en la petición");
			}
			ParGeneralOV dias = comun.obtenerParGeneralOV(uid, "mx.com.finsol.oxxo.dias.buscar");
     		LogHandler.debug( uid, getClass(), "valor de DIAS: " + dias.getCgValor() );
     		if (dias == null || dias.getCgValor().trim().isEmpty()) {
     			throw new Exception("No fue posible obtener la URL del servicio REST.");
     		}
     		LogHandler.trace(uid, getClass(), "consultarPlanillaAprobacionTarea: - obtenerParGeneral");
			ParGeneralOV urlEdoCuenta = comun.obtenerParGeneralOV(uid, "BURO_UEDOC");
			Date fechaInicial = new Date();
			fechaInicial = format.parse(peticion.getFechaInicial());
			sesionNTx = FabricaConexiones.obtenerSesionBatch();
	        final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
	        parametros.put("fechaInicial", fechaInicial);
	        parametros.put("dias", Integer.parseInt(dias.getCgValor()));
	        List<PagoLineaDTO> pagos = new ArrayList<PagoLineaDTO>();
	        pagos = (List<PagoLineaDTO>) sesionNTx.selectList("consultarPagosLineaNoEncontrados", parametros);
	        for ( PagoLineaDTO pago : pagos) {
	        	pago.setEstadoCuenta(urlEdoCuenta.getCgValor() + pago.getContrato());
	        }
	        respuesta.setPagos(pagos);
		} catch (Exception e) {
 			LogHandler.error(uid, getClass(), " :.: consultarPagosLineaNoEncontrados: " + e.getMessage(), e);
            respuesta.getHeader().setEstatus(false);
            respuesta.getHeader().setMensaje(e.getMessage());
		}
		finally {
            FabricaConexiones.close(sesionNTx);
        }
		return respuesta;
	}

	/**
	 * Metodo que se utiliza para consultar el traspaso de Pagos
	 *
	 * @param uid Identificador Unico
	 * @param peticion TraspasoPagosPeticion
	 * @return TraspasoPagosRespuesta
	 */
	@SuppressWarnings("unchecked")
	public TraspasoPagosRespuesta consultarTraspasoPagosTarea(String uid, TraspasoPagosPeticion peticion) {
		TraspasoPagosRespuesta respuesta = new TraspasoPagosRespuesta();

		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfinal = new SimpleDateFormat("yyyyMMdd");

		try {
			if ( peticion.getFechaInicio() == null || peticion.getFechaInicio().trim().isEmpty()) {
				throw new Exception("La fecha Inicial es obligatoria en la petición");
			}

			if ( peticion.getFechaFin() == null || peticion.getFechaFin().trim().isEmpty()) {
				throw new Exception("La fecha Final es obligatoria en la petición");
			}

			String fechaInicial = null;
			fechaInicial = sdfinal.format(sdf.parse(peticion.getFechaInicio()));
			String fechaFinal = null;
			fechaFinal = sdfinal.format(sdf.parse(peticion.getFechaFin()));

			sesionNTx = FabricaConexiones.obtenerSesionNTx();

	        final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
	        parametros.put("fechaInicio", fechaInicial);
	        parametros.put("fechaFin",  fechaFinal);

	        if (peticion.getSucursal() != null) {
	        	parametros.put("sucursal", Integer.parseInt(peticion.getSucursal()));
	        }

	        if ( peticion.getFechaPago() != null) {
	        	parametros.put("fechaPago",  peticion.getFechaPago());
	        }

	        if ( peticion.getFechaAplicacion() != null) {
	        	parametros.put("fechaAplicacion",  peticion.getFechaAplicacion());
	        }

	        List<TraspasoPagos> pagos = new ArrayList<TraspasoPagos>();
	        pagos = (List<TraspasoPagos>) sesionNTx.selectList("consultaTraspasosPagos", parametros);

	        if (pagos != null) {
	        	if (pagos.size() == 0) {
	        		respuesta.getHeader().setUID(uid);
	        		respuesta.getHeader().setEstatus(false);
	        		respuesta.getHeader().setMensaje("No se encontraron pagos");
	        	}
	        }

	        respuesta.setPagos(pagos);
		} catch (Exception e) {
 			LogHandler.error(uid, getClass(), " :.: consultarTraspasoPagosTarea: " + e.getMessage(), e);
            respuesta.getHeader().setEstatus(false);
            respuesta.getHeader().setMensaje(e.getMessage());
		}
		finally {
            FabricaConexiones.close(sesionNTx);
        }
		return respuesta;
	}

	/**
	 * Metodo que se utiliza para las transacciones del componente de pagos en linea nube
	 *
	 * @param uid Identificador Unico
	 * @param peticion transaccion de pagos en linea
	 * @return AplicarPagoRespuesta
	 */
	public AplicarPagoRespuesta aplicarTransaccionPagoEnLinea(String uid, AplicarPagoLineaPeticion peticion) {
		AplicarPagoRespuesta respuesta = new AplicarPagoRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionTx = null;
		FechaContableOV fechaContable = null;
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
		try {
			sesionTx = FabricaConexiones.obtenerSesionTx();
			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();

			if (peticion.getTipoOperacion() == null || peticion.getTipoOperacion().trim().isEmpty()) {
				throw new Exception("El tipo de operacion es obligatorio.");
			}
			if (peticion.getFolio() == 0) {
				throw new Exception("El folio es obligatorio.");
			}
			if (peticion.getContrato() == null || peticion.getContrato().trim().isEmpty()) {
				throw new Exception("El contrato es obligatorio.");
			}
			if (peticion.getClaveCliente() == 0 ) {
				throw new Exception("La clave de cliente es obligatoria.");
			}
			if (peticion.getPeticion() == null || peticion.getPeticion().trim().isEmpty()) {
				throw new Exception("La peticion es obligatoria.");
			}
			if (peticion.getRespuesta() == null || peticion.getRespuesta().trim().isEmpty()) {
				throw new Exception("La respuesta es obligatoria.");
			}
			if (peticion.getFechaPeticion() == null) {
				throw new Exception("La fecha de peticion es obligatoria.");
			}
			if (peticion.getFechaRespuesta() == null) {
				throw new Exception("La fecha de respuesta es obligatoria.");
			}
			if (peticion.getHoraPeticion() == null) {
				throw new Exception("La hora de peticion es obligatoria.");
			}
			if (peticion.getHoraRespuesta() == null) {
				throw new Exception("La hora de respuesta es obligatoria.");
			}

			parametros.put("id_transaccion", peticion.getIdTransaccion());
			parametros.put("folio", peticion.getFolio());
			parametros.put("contrato", peticion.getContrato());
			parametros.put("clave_cte", peticion.getClaveCliente());
			parametros.put("peticion", peticion.getPeticion());
			parametros.put("respuesta", peticion.getRespuesta());
			parametros.put("fecha_peticion", peticion.getFechaPeticion());
			parametros.put("fecha_respuesta", peticion.getFechaRespuesta());
			parametros.put("hora_peticion", peticion.getHoraPeticion());
			parametros.put("hora_respuesta", peticion.getHoraRespuesta());
			parametros.put("num_intento", peticion.getNoIntento());
			parametros.put("tipo_operacion", peticion.getTipoOperacion());

			//Consulta
			if (peticion.getTipoOperacion().trim().equals("PLCO")) {
				int registros = sesionTx.insert("registraBitacoraPagosEnLinea", parametros);
				if (registros == 0) {
					throw new Exception("No fue posible registrar la consulta.");
				}
			} else if (peticion.getTipoOperacion().trim().equals("PLPA")) {
				if (peticion.getIdAutorizacion() == 0) {
					throw new Exception("Es necesario el id autorizacion para el pago.");
				}
				if (peticion.getMonto() <= 0) {
					throw new Exception("Es necesario monto para aplicar el pago.");
				}
				String contrato = comun.obtenerNumeroContrato(uid, peticion.getContrato());
				if (contrato == null || contrato.trim().isEmpty()) {
					throw new Exception("El numero de contrato es invalido.");
				}

				//aplicar Pago
				AplicarPagoPeticion peticionPago = new AplicarPagoPeticion();
				peticionPago.setBanderaMedioClaveCliente(true);
				peticionPago.setFechaValor(peticion.getFechaPeticion());
				peticionPago.setIdTransaccion(peticion.getFolio() + "");
				peticionPago.setMedioPago("POXO");
				peticionPago.setMonto(peticion.getMonto());
				peticionPago.setNumeroContrato(contrato);
				peticionPago.setReferencia(null);
	            peticionPago.setTipoAplicacion("NORM");
	            peticionPago.setUsuario("000000043");
				AplicarPagoRespuesta respuestaPago = aplicarPagoGrupalOperaciones(peticionPago, sesionTx, uid);
				if (!respuestaPago.getHeader().isEstatus()) {
					throw new Exception(respuestaPago.getHeader().getMensaje());
				}

				//insert tabla
				parametros.put("id_autorizacion", peticion.getIdAutorizacion());
				parametros.put("fecha_aplicacion", new Date());
				parametros.put("hora_aplicacion", new Date());
				parametros.put("usuario_ejecuta", "000000043");
				parametros.put("estatus", "APLI");
				int registros = sesionTx.insert("registraBitacoraPagosEnLinea", parametros);
				if (registros == 0) {
					throw new Exception("No fue posible registrar la consulta.");
				}
				//Conexion Postgres
				SqlSession sessionPostNTx = FabricaConexiones.obtenerSesionPostgresNTx();
				SqlSession sessionPostTx = FabricaConexiones.obtenerSesionPostgresTx();
				//Actualizar informacion postgres
				fechaContable = comun.obtenerFechaContable(uid);
				java.util.HashMap<String , Object> params = new java.util.HashMap<String, Object>();
				params.put("fechaActual", formatter.format(fechaContable.getFecha().getTime()));
				params.put( "contrato"   , contrato );
				final CreditoSaldo creditoSaldo = (CreditoSaldo) sesionTx.selectOne( "obtenerSaldoFv", params );
				ContratoPagosLineaOV registro = new ContratoPagosLineaOV();
				registro.setContrato(contrato);
				registro.setMontoCorriente(creditoSaldo.getMontoCorriente());
				registro.setMontoTotal(creditoSaldo.getSaldoLiquidar());
				registro.setCapitalInsoluto(creditoSaldo.getInsoluto());
				registro.setSaldoLiquidar(creditoSaldo.getSaldoLiquidar());
				registro.setMontoPagoAtrasado(creditoSaldo.getMontoPagoAtrasado());
				registro.setFechaProxPago(formatoFecha.parse(creditoSaldo.getFechaProximoPago()));
				registro.setParcialidad(creditoSaldo.getMontoPago() == null ? 0.0 : creditoSaldo.getMontoPago());
				registro.setEstatus(creditoSaldo.getEstatus());
				registro.setNoPago(creditoSaldo.getNumPagoActual() == null
						? 0 : Integer.parseInt(creditoSaldo.getNumPagoActual()));
				registro.setNoPagos(creditoSaldo.getPlazo() == null ? 0 : Integer.parseInt(creditoSaldo.getPlazo()));

				int existe = (Integer) sessionPostNTx.selectOne("existeContratoPostgres", registro.getContrato());
				if (existe == 0) {
					sessionPostTx.insert("insertaContratoPostgres", registro);
				} else {
					sessionPostTx.update("actualizaContratoPostgres", registro);
				}

				sessionPostTx.commit();
				FabricaConexiones.close(sessionPostNTx);
	            FabricaConexiones.close(sessionPostTx);

				//ORIG-360 Cierre de Creditos con Pagos OXXO en Linea
				if ( respuestaPago.isPromesaLiquidacion()) {
					//Se limpia el id transaccion valido papa evitar la validacion del pago duplicado.
					PagoGrupal pagoGrupalObject = new PagoGrupal();
					pagoGrupalObject.setNumeroContrato(contrato);
					pagoGrupalObject.setIdTransaccionValida("");
					pagoGrupalObject.setMonto(peticion.getMonto());
					pagoGrupalObject.setUsuario(peticion.getUsuario());
					final 	AplicarPagoRespuesta
								aplicarGarantiaRespuesta =  aplicarGarantiaLiquidacion(pagoGrupalObject, uid);
					LogHandler.info(uid, getClass(), "aplicarPagoGrupal - Datos de salida (aplicarGarantiaRespuesta): "
								+ aplicarGarantiaRespuesta);
				}

			} else if (peticion.getTipoOperacion().trim().equals("PLRE")) {
				if (peticion.getIdAutorizacion() == 0) {
					throw new Exception("Es necesario el id autorizacion para el pago.");
				}
				if (peticion.getMonto() <= 0) {
					throw new Exception("Es necesario monto para aplicar el pago.");
				}
				String contrato = comun.obtenerNumeroContrato(uid, peticion.getContrato());
				if (contrato == null || contrato.trim().isEmpty()) {
					throw new Exception("El numero de contrato es invalido.");
				}

				Calendar cal = Calendar.getInstance();
				cal.setTime(peticion.getFechaPeticion());
				cal.set(Calendar.HOUR_OF_DAY, 0);
				cal.set(Calendar.MINUTE, 0);
				cal.set(Calendar.SECOND, 0);
				cal.set(Calendar.MILLISECOND, 0);
				peticion.setFechaPeticion(cal.getTime());

				CancelarPagoConexiaPeticion peticionReversa = new CancelarPagoConexiaPeticion();
				peticionReversa.setNumeroContrato(contrato);
				peticionReversa.setMonto(peticion.getMonto());
				peticionReversa.setFechaValor(peticion.getFechaPeticion());
				peticionReversa.setUsuario("000000043");
				peticionReversa.setMedioPago("POXO");

				CancelarPagoConexiaRespuesta respuestaReversa = cancelarPagoEnLineaTarea(uid, peticionReversa, sesionTx);
				if (!respuestaReversa.getHeader().isEstatus()) {
					throw new Exception(respuestaReversa.getHeader().getMensaje());
				}
				parametros.put("id_autorizacion", peticion.getIdAutorizacion());
				parametros.put("fecha_aplicacion", new Date());
				parametros.put("hora_aplicacion", new Date());
				parametros.put("usuario_ejecuta", "000000043");
				parametros.put("estatus", "APLI");
				//insert tabla
				int registros = sesionTx.insert("registraBitacoraPagosEnLinea", parametros);
				if (registros == 0) {
					throw new Exception("No fue posible registrar la consulta.");
				}
				//Conexion Postgres
				SqlSession sessionPostNTx = FabricaConexiones.obtenerSesionPostgresNTx();
				SqlSession sessionPostTx = FabricaConexiones.obtenerSesionPostgresTx();
				//Actualizar informacion postgres
				fechaContable = comun.obtenerFechaContable(uid);
				java.util.HashMap<String , Object> params = new java.util.HashMap<String, Object>();
				params.put("fechaActual", formatter.format(fechaContable.getFecha().getTime()));
				params.put( "contrato"   , contrato );
				final CreditoSaldo creditoSaldo = (CreditoSaldo) sesionTx.selectOne( "obtenerSaldoFv", params );
				ContratoPagosLineaOV registro = new ContratoPagosLineaOV();
				registro.setContrato(contrato);
				registro.setMontoCorriente(creditoSaldo.getMontoCorriente());
				registro.setMontoTotal(creditoSaldo.getSaldoLiquidar());
				registro.setCapitalInsoluto(creditoSaldo.getInsoluto());
				registro.setSaldoLiquidar(creditoSaldo.getSaldoLiquidar());
				registro.setMontoPagoAtrasado(creditoSaldo.getMontoPagoAtrasado());
				registro.setFechaProxPago(formatoFecha.parse(creditoSaldo.getFechaProximoPago()));
				registro.setParcialidad(creditoSaldo.getMontoPago() == null ? 0.0 : creditoSaldo.getMontoPago());
				registro.setEstatus(creditoSaldo.getEstatus());
				registro.setNoPago(creditoSaldo.getNumPagoActual() == null
						? 0 : Integer.parseInt(creditoSaldo.getNumPagoActual()));
				registro.setNoPagos(creditoSaldo.getPlazo() == null ? 0 : Integer.parseInt(creditoSaldo.getPlazo()));

				int existe = (Integer) sessionPostNTx.selectOne("existeContratoPostgres", registro.getContrato());
				if (existe == 0) {
					sessionPostTx.insert("insertaContratoPostgres", registro);
				} else {
					sessionPostTx.update("actualizaContratoPostgres", registro);
				}

				sessionPostTx.commit();
				FabricaConexiones.close(sessionPostNTx);
	            FabricaConexiones.close(sessionPostTx);
			} else {
				throw new Exception("El tipo de operacion no es correcta.");
			}
			//COMMIT Sesion Sybase
			sesionTx.commit();
		} catch (Exception e) {
			FabricaConexiones.rollBack(sesionTx);
 			LogHandler.error(uid, getClass(), " :.: aplicarTransaccionPagoEnLinea: " + e.getMessage(), e);
            respuesta.getHeader().setEstatus(false);
            respuesta.getHeader().setMensaje(e.getMessage());
		}
		finally {
            FabricaConexiones.close(sesionTx);
        }
		return respuesta;
	}
}

