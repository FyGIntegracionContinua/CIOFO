package tarea.administracion;


import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mx.com.findep.crediseguros.webservice.finsol.AnulacionServiceLocator;

import org.apache.ibatis.session.SqlSession;
import org.example.www.ChequesOperacionWS.ChequesOperacionWS_ServiceLocator;
import org.example.www.ChequesOperacionWS.FoliosDTO;
import org.example.www.ChequesOperacionWS.ResultadoCancelaDTO;
import org.osoa.sca.annotations.Reference;

import tarea.comun.ComunTarea;
import tarea.comun.ReadProperties;
import tarea.consultas.Consultas;
import tarea.operacion.PagosCredito;
import tarea.originacion.OriginacionConsultas;
import utilitario.comun.Constantes;
import utilitario.comun.ConstantesPagos;
import utilitario.log.LogHandler;
import utilitario.mensajes.administracion.contrato.ActualizarSolicitudReasignarCarteraPeticion;
import utilitario.mensajes.administracion.contrato.ActualizarSolicitudReasignarCarteraRespuesta;
import utilitario.mensajes.administracion.contrato.AdministracionAnalistasPeticion;
import utilitario.mensajes.administracion.contrato.AdministracionAnalistasRespuesta;
import utilitario.mensajes.administracion.contrato.AjustarPersonaDomicilioPeticion;
import utilitario.mensajes.administracion.contrato.AjusteChequeDevueltoPeticion;
import utilitario.mensajes.administracion.contrato.AjusteChequeDevueltoRespuesta;
import utilitario.mensajes.administracion.contrato.AjusteDiaPagoPeticion;
import utilitario.mensajes.administracion.contrato.AjusteDiaReunionPeticion;
import utilitario.mensajes.administracion.contrato.AjusteDiaReunionRespuesta;
import utilitario.mensajes.administracion.contrato.AjustePlazoPeticion;
import utilitario.mensajes.administracion.contrato.AjustePorcentajeGarantiaPeticion;
import utilitario.mensajes.administracion.contrato.AjustePorcentajeGarantiaRespuesta;
import utilitario.mensajes.administracion.contrato.AjusteRespuesta;
import utilitario.mensajes.administracion.contrato.AjusteSaldoAFavorMasivoRespuesta;
import utilitario.mensajes.administracion.contrato.AjusteSaldoAFavorPeticion;
import utilitario.mensajes.administracion.contrato.AjusteSaldoAFavorRespuesta;
import utilitario.mensajes.administracion.contrato.AjusteTasaPeticion;
import utilitario.mensajes.administracion.contrato.EliminarSaldoAFavorOV;
import utilitario.mensajes.administracion.contrato.EliminarSaldoAFavorPeticion;
import utilitario.mensajes.administracion.contrato.EliminarSaldoAFavorRespuesta;
import utilitario.mensajes.administracion.contrato.PorcentajeGarantia;
import utilitario.mensajes.administracion.contrato.ReasignarCarteraOV;
import utilitario.mensajes.administracion.contrato.ReasignarCarteraPeticion;
import utilitario.mensajes.administracion.contrato.ReasignarCarteraReporteOV;
import utilitario.mensajes.administracion.contrato.ReasignarCarteraRespuesta;
import utilitario.mensajes.administracion.contrato.RegistrarSolicitudReasignarCarteraPeticion;
import utilitario.mensajes.administracion.contrato.RegistrarSolicitudReasignarCarteraRespuesta;
import utilitario.mensajes.administracion.contrato.RevertirSaldoAFavorPeticion;
import utilitario.mensajes.administracion.contrato.RevertirSaldoAFavorRespuesta;
import utilitario.mensajes.administracion.contrato.TransferirSaldoAFavorOV;
import utilitario.mensajes.administracion.contrato.TransferirSaldosAFavorCreditosVigentesRespuesta;
import utilitario.mensajes.administracion.contrato.TrasferirSaldosAFavorCreditosVigentesPeticion;
import utilitario.mensajes.comun.AmortizacionOV;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.FechaContableOV;
import utilitario.mensajes.comun.InteresOV;
import utilitario.mensajes.comun.ResultadoOV;
import utilitario.mensajes.consultas.AsesoresOV;
import utilitario.mensajes.consultas.ConsultaCATPeticion;
import utilitario.mensajes.consultas.ConsultaCATRespuesta;
import utilitario.mensajes.consultas.ConsultaCreditoPeticion;
import utilitario.mensajes.consultas.DatosCreditoIntegrantesRespuesta;
import utilitario.mensajes.consultas.DatosIntegranteResumenOV;
import utilitario.mensajes.consultas.RespuestaSucursalOV;
import utilitario.mensajes.consultas.SucursalOV;
import utilitario.mensajes.grupos.gps.ContratoDTO;
import utilitario.mensajes.grupos.gps.GruposGPSPeticion;
import utilitario.mensajes.grupos.gps.GruposGPSRespuesta;
import utilitario.mensajes.operacion.administracion.SucursalPeticion;
import utilitario.mensajes.operacion.pagos.PagoGrupal;
import utilitario.mensajes.operacion.pagos.PagoGrupalResponse;
import utilitario.mensajes.originacion.cancelacion.CancelacionContratoOV;
import utilitario.mensajes.originacion.cancelacion.CancelacionContratoRespuesta;
import utilitario.mensajes.originacion.cancelacion.FoliosChequesSIC;
import utilitario.mensajes.originacion.cliente.ClienteRespuesta;
import utilitario.mensajes.originacion.cliente.RegistrarTelefonoPeticion;
import utilitario.mensajes.originacion.consulta.ConsultaDiaHabilOV;
import utilitario.mensajes.originacion.consulta.ConsultaDiaHabilPeticion;
import utilitario.mensajes.originacion.consulta.ConsultaDiaHabilRespuesta;
import utilitario.mensajes.originacion.consulta.ConsultaFechaOV;
import utilitario.mensajes.originacion.consulta.ConsultaRespuesta;
import utilitario.mensajes.originacion.consulta.ParGeneralOV;
import datamapper.DataMapper;
import entidad.conexiones.FabricaConexiones;

public class AdministracionCreditoImpl implements AdministracionCredito {

	/**
	 * OPER_REGISTRA_CAJA_INVENTARIO String
	 */
	private static final String  OPER_REGISTRA_CAJA_INVENTARIO			= "registraCajaInventario";
	/**
	 * OPER_REGISTRA_OPERACION_CAJA String
	 */
	private static final String  OPER_REGISTRA_OPERACION_CAJA			= "registraOperacionCaja";
	/**
	 * OPER_CANCELA_DISPOSICION String
	 */
	private static final String  OPER_CANCELA_DISPOSICION				= "cancelaDisposicion";
	/**
	 * OPER_DECREMENTA_CICLO_GRUPO String
	 */
	private static final String  OPER_DECREMENTA_CICLO_GRUPO			= "decrementarCicloGrupo";
	/**
	 * OPER_DECREMENTA_CICLO_INTEGRANTE String
	 */
	private static final String  OPER_DECREMENTA_CICLO_INTEGRANTE		= "decrementarCicloIntegrante";

	/**
	 * SUCURSAL String
	 */
	private static final String	 SUCURSAL								= "sucursal";
	/**
	 * MONTO String
	 */
	private static final String  MONTO									= "monto";
	/**
	 * PRODUCTO String
	 */
	private static final String  PRODUCTO								= "producto";
	/**
	 * CODIGO String
	 */
	private static final String	 CODIGO									= "codigo";
	/**
	 * CONTRATO String
	 */
	private static final String  CONTRATO								= "contrato";
	/**
	 * IDX_TRX_CAJA String
	 */
	private static final String	 IDX_TRX_CAJA							= "idx_trx_caja";
	/**
	 * OPERADOR String
	 */
	private static final String  OPERADOR								= "operador";

	/**
	 * CODIGO_PAGO_CANCELACION_RENO String
	 */
	private static final String  CODIGO_PAGO_CANCELACION_RENO			= "CADO";
	/**
	 * CODIGO_PAGO_CANCELACION_DISP String
	 */
	private static final String  CODIGO_PAGO_CANCELACION_DISP			= "CADI";
	//private static final String  CODIGO_CREDITO_PAGO					= "PREF";
	//private static final String  CODIGO_CANCELACION_PAGO				= "CANP";
	/**
	 * FECHA_CONTABLE String
	 */
	private static final String  FECHA_CONTABLE 						= "fechaContable";
	/**
	 * IDXTRXCAJA String
	 */
	private static final String	 IDXTRXCAJA								= "idTrxCaja";
	/**
	 * formatter SimpleDateFormat
	 */
	private static final SimpleDateFormat FORMATTER 					= new SimpleDateFormat("yyyyMMdd");
	//private static final String FECHA_PRIM_VENC							= "fecha_prim_venc";
	/**
	 * FECHA_ACTUAL String
	 */
	private static final String	FECHA_ACTUAL							= "fechaActual";
	/**
	 * USUARIO String
	 */
	private static final String USUARIO  								= "usuario";
	/**
	 * MEDIO_RECEPCION String
	 */
	private static final String MEDIO_RECEPCION							= "medioRecepcion";
	/**
	 * CLAVE String
	 */
	private static final String CLAVE									= "clave";
	/**
	 * CLAVE_PRODUCCION String
	 */
	private static final String CLAVE_PRODUCCION 						= "clave_produccion";
	/**
	 * REFERENCIA1 String
	 */
	private static final String REFERENCIA1								= "referencia1";
	/**
	 * REFERENCIA2 String
	 */
	private static final String REFERENCIA2								= "referencia2";
	/**
	 * FECHA_CANCELACION String
	 */
	private static final String FECHA_CANCELACION						= "fecha_cancelacion";
	/**
	 * DISPOSICION String
	 */
	private static final String DISPOSICION								= "disposicion";
	/**
	 * PREF_OPORTUNIDAD String
	 */
	private static final String PREF_OPORTUNIDAD						= "OPO";
	/**
	 * MENSAJE_TIMEOUT String
	 */
	private static final String	MENSAJE_TIMEOUT							= "FSERROR_TIMEOUT, CREDITO NO ";
  	/**
  	 * MENSAJE_ERROR String
  	 */
  	private static final String	MENSAJE_ERROR							= "CREDITO NO ";
	/**
	 * CODIGO_TASA String
	 */
	private static final String CODIGO_TASA 							= "CTAS";
	/**
	 * CODIGO_PLAZO String
	 */
	private static final String CODIGO_PLAZO 							= "CPLZ";
	/**
	 * CODIGO_DIA String
	 */
	private static final String CODIGO_DIA 								= "CDDP";
	/**
	 * CODIGO_AJUSTE_CONTRATO String
	 */
	private static final String CODIGO_AJUSTE_CONTRATO 					= "ACON";
	/**
	 * CODIGO_CHEQUE_DEV String
	 */
	private static final String CODIGO_CHEQUE_DEV 						= "DEVC";
	/**
	 * REF_CAMBIO_TASA String
	 */
	private static final String REF_CAMBIO_TASA 						= "CAMBIO TASA";
	/**
	 * REF_CAMBIO_PLAZO String
	 */
	private static final String REF_CAMBIO_PLAZO 						= "CAMBIO PLAZO";
	/**
	 * REF_CAMBIO_DIA_PAGO String
	 */
	private static final String REF_CAMBIO_DIA_PAGO						= "CAMBIO DIA PAGO";
	/**
	 * REF_CHEQUE_DEV String
	 */
	private static final String REF_CHEQUE_DEV 							= "CHEQUE DEVUELTO";
	/**
	 * CODIGO_IVA String
	 */
	private static final String CODIGO_IVA 								= "IVIN";
	/**
	 * CODIGO_SEGURO_DEV String
	 */
	private static final String CODIGO_SEGURO_DEV 						= "CEGX";
	/**
	 * REF_SEGURO_DEV String
	 */
	private static final String REF_SEGURO_DEV 							= "SEGURO VIDA DEVUELTO";
	/**
	 * REF_SEGURO_DEV_ENFERMEDAD String
	 */
	private static final String REF_SEGURO_DEV_ENFERMEDAD 				= "SEGURO ENF. GRAVES DEVUELTO";
	/**
	 * CODIGO_ERROR_SP int
	 */
	private static final int CODIGO_ERROR_SP 							= -2;
	/**
	 * Codigo de tipo de Movimiento para la
	 * modificacion de porcentaje de Garantia
	 */
	private static final String MOV_GARANTIA							= "CPGR";
	/**
	 * Porcentaje para dividir la garantia
	 */
	private static final int PORCENT_GARANTIA							= 100;

	/**
	 *  Codigo para aplicar la garantia
	 */
	private static final String CODIGO_APLICA_GARANTIA					= "DGAC";
	/**
	 * comun ComunTarea
	 */
	private ComunTarea comun;
	/**
	 * pagos PagosCredito
	 */
	private PagosCredito pagos;
	/**
	 * originacionConsultas OriginacionConsultas
	 */
	private OriginacionConsultas originacionConsultas;
	/**
	 * consultas Consultas
	 */
	private Consultas consultas;

	/**
	 * @param comun :
	 * @param pagos :
	 * @param originacionConsultas :
	 * @param consultas Constructor :
	 */
	public AdministracionCreditoImpl( @Reference(name = "comun") ComunTarea comun,
			@Reference(name = "pagos") PagosCredito pagos,
			@Reference(name = "originacionConsultas") OriginacionConsultas originacionConsultas,
			@Reference(name = "consultas") Consultas consultas) {
		this.comun = comun;
		this.pagos = pagos;
		this.originacionConsultas = originacionConsultas;
		this.consultas = consultas;
	}


	/**
	 * @param uid identificador unico
	 * @param peticion ajuste de peticion de tasa
	 * @return respuesta del resultado del ajuste
	 */
	public AjusteRespuesta ajustarTasa(String uid, AjusteTasaPeticion peticion) {
		AjusteRespuesta resp = new AjusteRespuesta();

		if (peticion.getContrato() == null  || peticion.getTasa() == null) {
			resp.setHeader(generarHeader(uid, false, ReadProperties.mensajes.getProp("ciof.error.datos.incompletos")));
			return resp;
		}
		return ajustarTasaPlazo(uid, peticion.getContrato(), "TASA", peticion.getTasa(), null, peticion.getUsuario());
	}

	/**
	 * @param uid identificador unico
	 * @param peticion ajuste de peticion de tasa
	 * @return respuesta del resultado del ajuste
	 */
	public AjusteRespuesta ajustarPlazo(String uid, AjustePlazoPeticion peticion) {
		AjusteRespuesta resp = new AjusteRespuesta();

		if (peticion.getContrato() == null  || peticion.getNumeroPagos() == null) {
			resp.setHeader(generarHeader(uid, false, ReadProperties.mensajes.getProp("ciof.error.datos.incompletos")));
			return resp;
		}

		return ajustarTasaPlazo(uid, peticion.getContrato(), "PLAZO", null, peticion.getNumeroPagos(), peticion.getUsuario());
	}

	/**
	 * @param uid identificador unico
	 * @param peticion ajuste de peticion de tasa
	 * @return respuesta del resultado del ajuste
	 */
	public AjusteRespuesta ajustarDiaPago(String uid, AjusteDiaPagoPeticion peticion) {
		AjusteRespuesta resp = new AjusteRespuesta();

		if (peticion.getContrato() == null  || peticion.getFechaAnclaPago() == null) {
			resp.setHeader(generarHeader(uid, false, ReadProperties.mensajes.getProp("ciof.error.datos.incompletos")));
			return resp;
		}

		return ajustarDiaPago(uid, peticion.getContrato(), "DIA", peticion.getFechaAnclaPago()
				, peticion.getOperador(), peticion.getUsuario());
	}

	/**
	 * @param uid :
	 * @param contrato :
	 * @param criterio :
	 * @param nuevaTasa :
	 * @param nuevoNumPagos :
	 * @param usuario :
	 * @return AjusteRespuesta
	 */
	@SuppressWarnings("unchecked")
	private AjusteRespuesta ajustarTasaPlazo(
			String uid, String contrato, String criterio , Double nuevaTasa, Integer nuevoNumPagos, String usuario)
		{
		AjusteRespuesta resp = new AjusteRespuesta();
		SqlSession 	sesionNTX	= null;
		SqlSession 	sesionTX	= null;
		FechaContableOV fechaContable = null;
		HashMap<String, Object> datosContrato;
		HashMap<String, Object> params = new HashMap<String, Object>();
		Integer iva = null;
		ConsultaRespuesta consultaRespuesta = null;

		contrato = comun.obtenerNumeroContrato(null, contrato);

		if (contrato == null) {
			LogHandler.error(uid, getClass(), ReadProperties.mensajes.getProp("ciof.contratoinvalido"),
					new Exception( ReadProperties.mensajes.getProp("ciof.contratoinvalido") ));
			resp.setHeader(generarHeader(uid, false, ReadProperties.mensajes.getProp("ciof.contratoinvalido")));
			return resp;
			}

		try {
			//obtener fecha contable
			 fechaContable = (FechaContableOV) comun.obtenerFechaContable(uid);

			 // Validar que se pueda realizar la operaci�n
			if ( fechaContable.isEstatusCierre()) {
				LogHandler.debug(uid, this.getClass(), ReadProperties.mensajes.getProp("ciof.error.ejecucioncierre"));
				resp.setHeader(generarHeader(uid, false, ReadProperties.mensajes.getProp("ciof.error.ejecucioncierre")));
				return resp;
			}

			sesionNTX = FabricaConexiones.obtenerSesionNTx();
			// 	Obtener info del contrato
			// los datos que se obtienen son: fecha_prim_venc, sucursal, monto, tasa,
			// no_pagos, frecuencia_pago, monto_pago, propietario

			datosContrato = (HashMap<String, Object>) comun.obtenerDatosGeneralesContrato(uid, contrato);

			if (datosContrato == null) {
				throw new Exception( ReadProperties.mensajes.getProp("ciof.contratoinvalido") );
				}

			if ( !datosContrato.get( "status" ).toString().trim().equals( "N" )
				&& !datosContrato.get( "status" ).toString().trim().equals( "D" ) ) {
				throw new Exception( ReadProperties.mensajes.getProp("ciof.error.statuscontrato" ));
				}

			//Se valida la fecha ( se pidio que este candado se eliminara )
			/*if(fechaContable.getFecha().after( (Date)datosContrato.get("fecha_prim_venc")))
				{
				throw new Exception( ReadProperties.mensajes.getProp("ciof.error.primerpago"));
				}*/

			//ir por monto de iva
			if (criterio.equals("TASA")) {
				params.put("sucursal", datosContrato.get("sucursal"));
				params.put("codigo", CODIGO_IVA);
				params.put("fecha", new Date());

				LogHandler.trace(uid, getClass(), "==> ajustarTasaPlazo - verValorHistorico " );
				iva = (Integer) sesionNTX.selectOne("verValorHistorico", params);

				if ( iva == null) {
					throw new Exception( ReadProperties.mensajes.getProp(
							"administracion.ajustartasaplazo.errorivasucural") );
				}
				nuevaTasa = ( nuevaTasa / (1 + (iva.doubleValue() / Constantes.CENTENA))) / Constantes.MESES_ANIO;
			}

		//Para dar formato a la tasa
		final DecimalFormat decimalFormat = new DecimalFormat( "0.######");

		//calcular nuevo monto parcialidad
		if (criterio.equals("TASA")) {
			String tasaAux = decimalFormat.format(nuevaTasa);
			datosContrato.put("tasa", Double.parseDouble( tasaAux.replace( ",", ".") ));
		} else {
			//Objeto para almacenar los parametros para calcular la fecha fin
			final SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );

			final 	Calendar
					calendarDiaPago = Calendar.getInstance();
					calendarDiaPago.setTime( simpleDateFormat.parse( datosContrato.get( "fecha_ancla_pago").toString() ) );

			final ConsultaFechaOV
					consultaFechaOV = new ConsultaFechaOV();
					consultaFechaOV.setFecha( simpleDateFormat.parse( datosContrato.get( "fecha_disposicion").toString() ) );
					consultaFechaOV.setPerido( datosContrato.get( "frecuencia_pago" ).toString() );
					consultaFechaOV.setPlazo( nuevoNumPagos );
					consultaFechaOV.setSucursal( (Integer) datosContrato.get( "sucursal" ) );
					consultaFechaOV.setDiaPago( calendarDiaPago.get( Calendar.DAY_OF_WEEK ) - 1 );

			datosContrato.put("no_pagos", nuevoNumPagos);
			consultaRespuesta = originacionConsultas.calcularFechaFinContrato(uid, consultaFechaOV);
			datosContrato.put("fecha_esp_liq", consultaRespuesta.getFechaFin());
		}
		datosContrato.put("contrato", contrato);

		//Obtener el - codigo - para tipo de c�lculo
		LogHandler.trace(uid, getClass(), " ==> ajustarTasaPlazo -  obtenerTipoCalculoInteres");
		final java.util.HashMap<String, Object>	mapaCodigoCalculo =
				(HashMap<String, Object>) sesionNTX.selectOne("obtenerTipoCalculoInteres", datosContrato );

		//Obtener el - valor - para tipo de c�lculo
//		datosContrato.put( "tipoCalculoInteres", mapaCodigoCalculo.get( "valor" ).toString() );
//		datosContrato.put( "sucursal"  		   , Integer.valueOf( datosContrato.get( "sucursal" ).toString() ) );
//		datosContrato.put( "fechaContrato"	   , datosContrato.get( "fecha_contrato" ).toString() );
//
//		LogHandler.trace(uid, getClass(), " ==> ajustarTasaPlazo -  obtenerValorTipoCalculoInteres");
//		final java.lang.String
//			  valorTipoCalculo = ( java.lang.String )sesionNTX.selectOne( "obtenerValorTipoCalculoInteres", datosContrato );
//
		//Campos para el calculo de intereses
		datosContrato.put( "tipoCalculo"  , mapaCodigoCalculo.get( "valor" ).toString() );
		datosContrato.put( "fechaInicial" , datosContrato.get( "fecha_disposicion" ).toString() );
		datosContrato.put( "fechaFinal"   , datosContrato.get( "fecha_esp_liq" ).toString() );
		datosContrato.put( "producto"     , datosContrato.get( "producto" ).toString() );

		LogHandler.trace(uid, getClass(), " ==> ajustarTasaPlazo -  calculaMontoPago");
		resp.setNuevoMonto((Double) sesionNTX.selectOne("calculaMontoPago", datosContrato));
		FabricaConexiones.close( sesionNTX );

		sesionTX = FabricaConexiones.obtenerSesionTx();
		datosContrato.put("monto_pago", resp.getNuevoMonto());
		datosContrato.put("fecha", FORMATTER.format(fechaContable.getFecha().getTime()));

		//inicia transaccion
		//Se agrega la fecha_prox_liq
		final SimpleDateFormat
			  simpleDateFormat = new SimpleDateFormat( "yyyyMMdd" );

		datosContrato.put( "fecha_esp_liq", simpleDateFormat.format( datosContrato.get( "fecha_esp_liq" ) ));

		params = new HashMap<String, Object>();
		params.put("usuario", usuario);
		params.put("contrato", contrato);
		params.put("tipoMovimiento", criterio.equals("TASA") ? CODIGO_TASA : CODIGO_PLAZO);
		LogHandler.trace(uid, getClass(), "==> ajustarTasaPlazo - insertaContratosMovimientosAjuste");
		sesionTX.insert("insertaContratosMovimientosAjuste", params);

		//se actualiza contrato
		LogHandler.trace(uid, getClass(), "==> ajustarTasaPlazo - actualizaContratoAjuste");
		sesionTX.update("actualizaContratoAjuste", datosContrato);

		//registrar movimiento de cambio de tasa / plazo
		insertaMovimiento(uid, sesionTX, contrato, (Integer) datosContrato.get("sucursal"), CODIGO_AJUSTE_CONTRATO,
				criterio.equals("TASA") ?  REF_CAMBIO_TASA : REF_CAMBIO_PLAZO, usuario, null, null, null,
				(String) datosContrato.get("propietario"), fechaContable.getFecha(), fechaContable.getFecha(), "" );

		/**
		 * Se recalcula el interes total e iva del interes total
		 * tambien los porcentajes de participacion del resto de
		 * integrantes del grupo y se actualiza
		 */
		//Obtenemos los intereses
		InteresOV interesOV = new InteresOV();
				  interesOV.setProducto( datosContrato.get( "producto" ).toString() );
				  interesOV.setFechaInicio(
						  (new SimpleDateFormat( "yyyy-MM-dd" ) ).parse( datosContrato.get( "fecha_disposicion" ).toString() ) );
				  interesOV.setFechaFinal(
						  (new SimpleDateFormat( "yyyyMMdd" ) ).parse( datosContrato.get( "fecha_esp_liq" ).toString() ) );
				  interesOV.setFrecuenciaPago( datosContrato.get( "frecuencia_pago" ).toString() );
				  interesOV.setMontoCredito( Double.valueOf( datosContrato.get( "monto" ).toString() ) );
				  interesOV.setNoPagos( (Integer) datosContrato.get( "no_pagos" ) );
				  interesOV.setSucursal( (Integer) datosContrato.get( "sucursal" ) );
				  interesOV.setTasa( Double.valueOf( datosContrato.get( "tasa" ).toString() ) );

		interesOV = comun.calcularInteresTotal(uid, interesOV);

		final java.util.HashMap<String, Object>
					parametrosActualizaInteres = new HashMap<String, Object>();
					parametrosActualizaInteres.put( "contrato" 		 , contrato );
					parametrosActualizaInteres.put( "interesTotal" 	 , interesOV.getInteresTotal() );
					parametrosActualizaInteres.put( "ivaInteresTotal", interesOV.getIvaInteresTotal() );

		LogHandler.trace(uid, getClass(), "==> ajustarTasaPlazo - actualizarInteresIvaContratos ");
		sesionTX.update( "actualizarInteresIvaContratos", parametrosActualizaInteres );
		/**
		 * Finaliza actualizacion de intereses y porcentaje de participacion
		 */

		sesionTX.commit(true);

		/**
		 * se ajustara el CAT
		 */
		// se calcula y se guarda el CAT del contrato

			sesionNTX = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(), "==> ajustarTasaPlazo - obtenerAmortizacionGrupal" );
			final List<AmortizacionOV>
					pagosAmortizacion = (List<AmortizacionOV>) sesionNTX.selectList("obtenerAmortizacionGrupal", contrato );

			final List<Double>
					pagosPeriodo = new ArrayList<Double>();

			//se recupera el iva
			final java.util.HashMap<String, Object> paramsIVA = new HashMap<String, Object>();
			paramsIVA.put("sucursal", datosContrato.get("sucursal"));
			paramsIVA.put("codigo", CODIGO_IVA);
			paramsIVA.put("fecha", new Date());

			LogHandler.trace(uid, getClass(), "==> recuperaMontosExtras - verValorHistorico " );
			final Integer ivaI = (Integer) sesionNTX.selectOne("verValorHistorico", paramsIVA);

			//Se obtiene la parte sin iva
			final Double ivaD = Double.parseDouble( ivaI.toString() );

			for ( AmortizacionOV amortizacionOV : pagosAmortizacion ) {
				final java.lang.Double  montoSinIva
				  = amortizacionOV.getAbonoCapital() + ( amortizacionOV.getInteresPeriodo()
						  / ( 1.0 + ivaD / Constantes.CENTENA_DOUBLE ));
				pagosPeriodo.add( montoSinIva );
				}

			final ConsultaCATPeticion consultaCATPeticion = new ConsultaCATPeticion();
			consultaCATPeticion.setMontoCredito( Double.valueOf( "" + datosContrato.get( "monto" ) ) );
			consultaCATPeticion.setPagos( pagosPeriodo );
			consultaCATPeticion.setPeriodo( datosContrato.get( "frecuencia_pago" ).toString().trim().equals( "S" )
											? Constantes.SEMANAS_ANIO
													: datosContrato.get( "frecuencia_pago" ).toString().trim().equals( "C" )
											? Constantes.CATORCENAS_ANIO : Constantes.MESES_ANIO);
			consultaCATPeticion.setPlazo( pagosPeriodo.size() );


			LogHandler.info(uid, getClass(), "Objeto que se envia a calcular el CAT : " + consultaCATPeticion );
			final ConsultaCATRespuesta
					consultaCATRespuesta = consultas.consultarCAT( consultaCATPeticion, uid );

			try {
				final java.util.HashMap<String, Object>
						paramsCondicionesContrato = new HashMap<String, Object>();
						paramsCondicionesContrato.put( "producto", datosContrato.get( "producto" ).toString() );
						paramsCondicionesContrato.put( "contrato", contrato );
						paramsCondicionesContrato.put( "valor"	 , consultaCATRespuesta.getCAT().toString() );

				final java.lang.Integer
						countCAT = (java.lang.Integer) sesionNTX.selectOne( "consultarCAT", contrato );

				if ( countCAT > 0 ) {
					LogHandler.trace(uid, getClass(), "==> ajustarTasaPlazo - actualizarCAT");
					sesionNTX.insert( "actualizarCAT", paramsCondicionesContrato );
					}
				else {
					LogHandler.trace(uid, getClass(), "==> ajustarTasaPlazo - insertarCondicionesContratoCAT");
					sesionNTX.insert( "insertarCondicionesContratoCAT", paramsCondicionesContrato );
					}
				}
			catch ( java.lang.Exception exception ) {
				LogHandler.error( uid, getClass(), ReadProperties.mensajes.getProp(
												"originacion.registrarcredito.errorcat" ) + contrato, exception );
				}


			resp.setHeader(generarHeader(uid, true,
					"El cambio de " + (criterio.equals("TASA") ? "tasa " : "plazo ") + " realizado correctamente"));
			}
		catch (Exception e) {
			//e.printStackTrace();
			LogHandler.error( uid, this.getClass(), "Error en AjustarTasaPlazo : " + e.getMessage(), e);
			FabricaConexiones.rollBack( sesionTX );
			resp.setHeader(generarHeader(uid, false, e.getMessage() ));
			resp.setNuevoMonto(null);
			}
		finally {
			FabricaConexiones.close( sesionNTX );
			FabricaConexiones.close( sesionTX );
			}

		return resp;
	}

	/**
	 * @param uid identificar unico de la transaccion
	 * @param contrato :
	 * @param criterio :
	 * @param fechaAnclaPago :
	 * @param operador :
	 * @param usuario :
	 * @return AjusteRespuesta
	 */
	@SuppressWarnings("unchecked")
	private AjusteRespuesta ajustarDiaPago(String uid, String contrato, String criterio, String fechaAnclaPago,
			String operador, String usuario) {

		AjusteRespuesta resp = new AjusteRespuesta();
		SqlSession 	sesionNTX	= null;
		SqlSession 	sesionTX	= null;
		FechaContableOV fechaContable = null;
		HashMap<String, Object> datosContrato;
		HashMap<String, Object> params = new HashMap<String, Object>();
		ConsultaRespuesta consultaRespuesta = null;

		contrato = comun.obtenerNumeroContrato(null, contrato);

		if (contrato == null) {
			LogHandler.error(uid, getClass(), ReadProperties.mensajes.getProp("ciof.contratoinvalido"),
					new Exception( ReadProperties.mensajes.getProp("ciof.contratoinvalido") ));
			resp.setHeader(generarHeader(uid, false, ReadProperties.mensajes.getProp("ciof.contratoinvalido")));
			return resp;
		}

		try {

			//obtener fecha contable
			 fechaContable = (FechaContableOV) comun.obtenerFechaContable(uid);
			 LogHandler.debug(uid, this.getClass(), "fecha contable: " + fechaContable);

			 // Validar que se pueda realizar la operaci�n
			if ( fechaContable.isEstatusCierre()) {
				LogHandler.debug(uid, this.getClass(), ReadProperties.mensajes.getProp("ciof.error.ejecucioncierre"));
				resp.setHeader(generarHeader(uid, false, ReadProperties.mensajes.getProp("ciof.error.ejecucioncierre")));
				return resp;
				}

			sesionNTX = FabricaConexiones.obtenerSesionNTx();
			// 	Obtener info del contrato
			// los datos que se obtienen son: fecha_prim_venc, sucursal, monto, tasa,
			// no_pagos, frecuencia_pago, monto_pago, propietario

			datosContrato = (HashMap<String, Object>) comun.obtenerDatosGeneralesContrato(uid, contrato);

			if (datosContrato == null) {
				throw new Exception( ReadProperties.mensajes.getProp("ciof.contratoinvalido") );
				}

			if ( !datosContrato.get( "status" ).toString().trim().equals( "N" )
				&& !datosContrato.get( "status" ).toString().trim().equals( "D" ) ) {
				throw new Exception( ReadProperties.mensajes.getProp("ciof.error.statuscontrato" ));
				}

			//Se valida la fecha ( se pidio que este candado se eliminara )
			if (fechaContable.getFecha().after( (Date) datosContrato.get("fecha_prim_venc"))) {
				throw new Exception( ReadProperties.mensajes.getProp("ciof.error.primerpago"));
			}

			//Objeto para almacenar los parametros para calcular la fecha fin
			final SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );

			/** se elimina
					calendarDiaPago.setTime( simpleDateFormat.parse( datosContrato.get( "fecha_ancla_pago").toString() ) );
			*/

			final 	Calendar calendarDiaPago = Calendar.getInstance();
					calendarDiaPago.setTime( simpleDateFormat.parse(fechaAnclaPago.toString()));

			final ConsultaFechaOV
					consultaFechaOV = new ConsultaFechaOV();
					consultaFechaOV.setFecha( simpleDateFormat.parse( datosContrato.get( "fecha_disposicion").toString() ) );
					consultaFechaOV.setPerido( datosContrato.get( "frecuencia_pago" ).toString() );
					consultaFechaOV.setPlazo( (Integer) datosContrato.get("no_pagos") );
					consultaFechaOV.setSucursal( (Integer) datosContrato.get( "sucursal" ) );
					consultaFechaOV.setDiaPago( calendarDiaPago.get( Calendar.DAY_OF_WEEK ) - 1 );

			datosContrato.put("no_pagos", (Integer) datosContrato.get("no_pagos"));

			final 	Calendar calendarProximoPago = Calendar.getInstance();
			calendarProximoPago.setTime(simpleDateFormat.parse(fechaAnclaPago.toString()));
			calendarProximoPago.add(Calendar.DATE, consultaFechaOV.getPerido().equals("S") ? Constantes.DIAS_SEMANA
																			: Constantes.DIAS_CATORCENA);

			ConsultaDiaHabilPeticion peticionDiaHabil = new ConsultaDiaHabilPeticion();
			ConsultaDiaHabilRespuesta respuestaDiaInhabil = new ConsultaDiaHabilRespuesta();
			ConsultaDiaHabilOV ov = new ConsultaDiaHabilOV();

			ov.setFecha(calendarProximoPago.getTime());
			ov.setSucursal(0);
			peticionDiaHabil.setBody(ov);

			boolean continua = true;
			Calendar calendarProximoVencimiento = Calendar.getInstance();
			calendarProximoVencimiento.setTime(calendarProximoPago.getTime());

			while (continua) {
				respuestaDiaInhabil = consultas.verificarDiaHabil(peticionDiaHabil, uid);

				if (respuestaDiaInhabil.getIdentificador().equals("1")) {

					calendarProximoVencimiento.add(Calendar.DATE, 1);
					ov.setFecha(calendarProximoVencimiento.getTime());
					ov.setSucursal(0);
					peticionDiaHabil.setBody(ov);
					continua = true;
				} else {
					continua = false;
				}
			}
			//

			consultaRespuesta = originacionConsultas.calcularFechaFinContrato(uid, consultaFechaOV);
			datosContrato.put("fecha_esp_liq", consultaRespuesta.getFechaFin());

			datosContrato.put("contrato", contrato);


			//verificar
			//Obtener el - codigo - para tipo de c�lculo
			LogHandler.trace(uid, getClass(), " ==> ajustarDiaPago -  obtenerTipoCalculoInteres");

			final java.util.HashMap<String, Object>	mapaCodigoCalculo =
				(HashMap<String, Object>) sesionNTX.selectOne("obtenerTipoCalculoInteres", datosContrato );

			//Campos para el calculo de intereses
			datosContrato.put( "tipoCalculo"  , mapaCodigoCalculo.get( "valor" ).toString() );
			datosContrato.put( "fechaInicial" , datosContrato.get( "fecha_disposicion" ).toString() );
			datosContrato.put( "fechaFinal"   , datosContrato.get( "fecha_esp_liq" ).toString() );
			datosContrato.put( "producto"     , datosContrato.get( "producto" ).toString() );

			LogHandler.trace(uid, getClass(), " ==> ajustarDiaPago -  calculaMontoPago");
			resp.setNuevoMonto((Double) sesionNTX.selectOne("calculaMontoPago", datosContrato));
			FabricaConexiones.close( sesionNTX );

			sesionTX = FabricaConexiones.obtenerSesionTx();
			datosContrato.put("monto_pago", resp.getNuevoMonto());
			datosContrato.put("fecha", FORMATTER.format(fechaContable.getFecha().getTime()));

			//inicia transaccion
			//Se agrega la fecha_prox_liq
			final SimpleDateFormat sdf = new SimpleDateFormat( "yyyyMMdd" );
			datosContrato.put( "fecha_esp_liq", sdf.format( datosContrato.get( "fecha_esp_liq" ) ));

			params = new HashMap<String, Object>();
			params.put("usuario", usuario);
			params.put("contrato", contrato);
			params.put("tipoMovimiento", CODIGO_DIA);

			LogHandler.trace(uid, getClass(), "==> ajustarDiaPago - insertaContratosMovimientosAjuste");
			sesionTX.insert("insertaContratosMovimientosAjuste", params);

			Calendar calendarFechaAncla = Calendar.getInstance();
			calendarFechaAncla.setTime(simpleDateFormat.parse(fechaAnclaPago.toString()));

			final HashMap<Object, Object>
							paramsFecPago = new HashMap<Object, Object>();
							paramsFecPago.put("p_header", "" );
							paramsFecPago.put("p_contrato", contrato );
							paramsFecPago.put("p_f_ancla_pago", FORMATTER.format(calendarFechaAncla.getTime()));
							paramsFecPago.put("p_f_prox_pago", FORMATTER.format(calendarProximoPago.getTime()));
							paramsFecPago.put("p_f_prox_venc", FORMATTER.format(calendarProximoVencimiento.getTime()) );
							paramsFecPago.put("p_operador", operador );
							paramsFecPago.put("p_fecha_contable", FORMATTER.format(fechaContable.getFecha().getTime()));

			LogHandler.trace(uid, getClass(), "==> ajustarDiaPago - actualizaPrimerVencimiento");
			//se actualiza primer vencimiento
			sesionTX.update("actualizaPrimerVencimiento", paramsFecPago);

			// se cambian las fechas p_f_ancla_pago, p_f_prox_pago, p_f_prox_venc
			try {
				LogHandler.trace(uid, getClass(), "==> modFechaPago - modFechaPago ");
				Integer codigo = (Integer) sesionTX.selectOne("modFechaPago", paramsFecPago);
				LogHandler.trace(uid, getClass(), "==> codigo::  " + codigo);
			} catch (Exception e) {
				LogHandler.error(uid, getClass(), e.getMessage(), e);
				throw new Exception(e.getMessage());
			}

			//se actualiza contrato
			LogHandler.trace(uid, getClass(), "==> ajustarDiaPago - actualizaContratoAjuste");
			sesionTX.update("actualizaContratoAjuste", datosContrato);

			//registrar movimiento de cambio de dia de pago.
			insertaMovimiento(uid, sesionTX, contrato, (Integer) datosContrato.get("sucursal"), CODIGO_AJUSTE_CONTRATO,
				REF_CAMBIO_DIA_PAGO, usuario, null, null, null,
				(String) datosContrato.get("propietario"), fechaContable.getFecha(), fechaContable.getFecha(), "" );

			/**
			 * Se recalcula el interes total e iva del interes total
			 * tambien los porcentajes de participacion del resto de
			 * integrantes del grupo y se actualiza
			 */
			//Obtenemos los intereses

			InteresOV interesOV = new InteresOV();
				  interesOV.setProducto( datosContrato.get( "producto" ).toString() );
				  interesOV.setFechaInicio(
						  (new SimpleDateFormat( "yyyy-MM-dd" ) ).parse( datosContrato.get( "fecha_disposicion" ).toString() ) );
				  interesOV.setFechaFinal(
						  (new SimpleDateFormat( "yyyyMMdd" ) ).parse( datosContrato.get( "fecha_esp_liq" ).toString() ) );
				  interesOV.setFrecuenciaPago( datosContrato.get( "frecuencia_pago" ).toString() );
				  interesOV.setMontoCredito( Double.valueOf( datosContrato.get( "monto" ).toString() ) );
				  interesOV.setNoPagos( (Integer) datosContrato.get( "no_pagos" ) );
				  interesOV.setSucursal( (Integer) datosContrato.get( "sucursal" ) );
				  interesOV.setTasa( Double.valueOf( datosContrato.get( "tasa" ).toString() ) );

				  interesOV = comun.calcularInteresTotal(uid, interesOV);

			final java.util.HashMap<String, Object>
						parametrosActualizaInteres = new HashMap<String, Object>();
						parametrosActualizaInteres.put( "contrato" 		 , contrato );
						parametrosActualizaInteres.put( "interesTotal" 	 , interesOV.getInteresTotal() );
						parametrosActualizaInteres.put( "ivaInteresTotal", interesOV.getIvaInteresTotal() );

			LogHandler.trace(uid, getClass(), "==> ajustarDiaPago - actualizarInteresIvaContratos ");
			sesionTX.update( "actualizarInteresIvaContratos", parametrosActualizaInteres );

			/**
			 * Finaliza actualizacion de intereses y porcentaje de participacion
			 */
			sesionTX.commit(true);

			/**
			 * se ajustara el CAT
			 */
			// se calcula y se guarda el CAT del contrato

			sesionNTX = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(), "==> ajustarDiaPago - obtenerAmortizacionGrupal" );
			final List<AmortizacionOV>
					pagosAmortizacion = (List<AmortizacionOV>) sesionNTX.selectList("obtenerAmortizacionGrupal", contrato );

			final List<Double>
					pagosPeriodo = new ArrayList<Double>();

			//se recupera el iva
			final java.util.HashMap<String, Object> paramsIVA = new HashMap<String, Object>();
			paramsIVA.put("sucursal", datosContrato.get("sucursal"));
			paramsIVA.put("codigo", CODIGO_IVA);
			paramsIVA.put("fecha", new Date());

			LogHandler.trace(uid, getClass(), "==> recuperaMontosExtras - verValorHistorico " );
			final Integer ivaI = (Integer) sesionNTX.selectOne("verValorHistorico", paramsIVA);

			//Se obtiene la parte sin iva
			final Double ivaD = Double.parseDouble( ivaI.toString() );

			for ( AmortizacionOV amortizacionOV : pagosAmortizacion ) {
				final java.lang.Double  montoSinIva
				  = amortizacionOV.getAbonoCapital() + ( amortizacionOV.getInteresPeriodo()
						  / ( 1.0 + ivaD / Constantes.CENTENA_DOUBLE ));
				pagosPeriodo.add( montoSinIva );
				}

			final ConsultaCATPeticion consultaCATPeticion = new ConsultaCATPeticion();
			consultaCATPeticion.setMontoCredito( Double.valueOf( "" + datosContrato.get( "monto" ) ) );
			consultaCATPeticion.setPagos( pagosPeriodo );
			consultaCATPeticion.setPeriodo( datosContrato.get( "frecuencia_pago" ).toString().trim().equals( "S" )
											? Constantes.SEMANAS_ANIO
													: datosContrato.get( "frecuencia_pago" ).toString().trim().equals( "C" )
											? Constantes.CATORCENAS_ANIO : Constantes.MESES_ANIO );
			consultaCATPeticion.setPlazo( pagosPeriodo.size() );


			LogHandler.info(uid, getClass(), "Objeto que se envia a calcular el CAT : " + consultaCATPeticion );
			final ConsultaCATRespuesta
					consultaCATRespuesta = consultas.consultarCAT( consultaCATPeticion, uid );

			try {
				final java.util.HashMap<String, Object>
						paramsCondicionesContrato = new HashMap<String, Object>();
						paramsCondicionesContrato.put( "producto", datosContrato.get( "producto" ).toString() );
						paramsCondicionesContrato.put( "contrato", contrato );
						paramsCondicionesContrato.put( "valor"	 , consultaCATRespuesta.getCAT().toString() );

				final java.lang.Integer
						countCAT = (java.lang.Integer) sesionNTX.selectOne( "consultarCAT", contrato );

				if ( countCAT > 0 ) {
					LogHandler.trace(uid, getClass(), "==> ajustarDiaPago - actualizarCAT");
					sesionNTX.insert( "actualizarCAT", paramsCondicionesContrato );
					}
				else {
					LogHandler.trace(uid, getClass(), "==> ajustarDiaPago - insertarCondicionesContratoCAT");
					sesionNTX.insert( "insertarCondicionesContratoCAT", paramsCondicionesContrato );
					}
				}
			catch ( java.lang.Exception exception ) {
				LogHandler.error( uid, getClass(), ReadProperties.mensajes.getProp(
												"originacion.registrarcredito.errorcat" ) + contrato, exception );
				}

			resp.setHeader(generarHeader(uid, true,
					"El cambio de D�a de pago realizado correctamente"));
			}
		catch (Exception e) {
			//e.printStackTrace();
			LogHandler.error( uid, this.getClass(), "Error en AjustarDiaPago : " + e.getMessage(), e);
			FabricaConexiones.rollBack( sesionTX );
			resp.setHeader(generarHeader(uid, false, e.getMessage() ));
			resp.setNuevoMonto(null);
			}
		finally {
			FabricaConexiones.close( sesionNTX );
			FabricaConexiones.close( sesionTX );
			}
		return resp;
	}

	/**
	 * @param uid :
	 * @param estatus :
	 * @param mensaje :
	 * @return EncabezadoRespuesta
	 */
	private EncabezadoRespuesta generarHeader(String uid, boolean estatus, String mensaje) {
		EncabezadoRespuesta header = new EncabezadoRespuesta();
		header.setCodigo("");
		header.setMensaje(mensaje);
		header.setUID(uid);
		header.setEstatus(estatus);

		return header;
	}


	/**
	 * @param uid :
	 * @param sesionTX :
	 * @param contrato :
	 * @param sucursal :
	 * @param codigo :
	 * @param referencia :
	 * @param operador :
	 * @param montoCapital :
	 * @param montoConcepto :
	 * @param idTransaccion :
	 * @param propietario :
	 * @param fechaContable :
	 * @param fechaValor void
	 * @param codigoServicio void
	 */
	private void insertaMovimiento(String uid, SqlSession sesionTX, String contrato, Integer sucursal, String codigo,
			String referencia, String operador, Double montoCapital, Double montoConcepto, Integer idTransaccion,
			String propietario, Date fechaContable, Date fechaValor, String codigoServicio) {

		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("contrato", contrato);
		params.put("fechaHora", comun.obtenerFechaActual( uid ));
		params.put("sucursal", sucursal);
		params.put("codigo", codigo);
		params.put("montoCapital", montoCapital == null ? 0.0 : montoCapital);
		params.put("montoConcepto", montoConcepto == null ? 0.0 : montoConcepto);
		params.put("ivaConcepto", 0);
		params.put("referencia", referencia);
		params.put("numSuceso", 0);
		params.put("propietario", propietario == null ? "" : propietario);
		params.put("reportaCobranza", "N");
		params.put("codigoServicio", codigoServicio == null ? "" : codigoServicio);
		params.put("fechaEsperada", FORMATTER.format(fechaContable.getTime()));
		params.put("fechaContable", FORMATTER.format(fechaContable.getTime()));
		params.put("fechaInicial", FORMATTER.format(fechaContable.getTime()));
		params.put("fechaFinal", FORMATTER.format(fechaContable.getTime()));
		params.put("idTrxCaja", idTransaccion == null ? new BigDecimal(0) : idTransaccion);
		params.put("sucursalCartera", sucursal);
		params.put("fechaValor", FORMATTER.format(fechaValor.getTime()));
		params.put("usuario", operador);

		LogHandler.trace(uid, this.getClass(), "==> insertaMovimiento - insertMovimientos");
		sesionTX.insert("insertMovimientos", params);

	}
	/**
	 * @param uid :
	 * @param sesionTX :
	 * @param contrato :
	 * @param codigo :
	 * @param fechaContable :
	 * @param fechaValor :
	 * @param saldoGarantia :
	 * @param montoCapital :
	 * @param montoInteres :
	 * @param montoRecargos :
	 * @param usuario :
	 * @param noIntegrante :
	 */
	private void insertaMovimientoDepositoGarantia(String uid, SqlSession sesionTX, String contrato, String codigo,
			Date fechaContable, Date fechaValor, Double saldoGarantia, Double montoCapital, Double montoInteres,
			Double montoRecargos, String usuario, String noIntegrante) {

		HashMap<String, Object> paramsMovimientos = new HashMap<String, Object>();
		paramsMovimientos.put("contrato", contrato);
		paramsMovimientos.put("codigo", codigo);
		paramsMovimientos.put("fechaContable", FORMATTER.format(fechaContable.getTime()));
		paramsMovimientos.put("fechaValor", FORMATTER.format(fechaContable.getTime()));
		paramsMovimientos.put("importe", saldoGarantia);
		paramsMovimientos.put("montoCapital", montoCapital == null ? 0.0 : montoCapital);
		paramsMovimientos.put("montoInteres", montoInteres == null ? 0.0 : montoInteres);
		paramsMovimientos.put("montoRecargos", montoRecargos == null ? 0.0 : montoRecargos);
		paramsMovimientos.put("usuario", usuario);
		paramsMovimientos.put("noIntegrante", noIntegrante);
		paramsMovimientos.put("folioCheque", 0);
		paramsMovimientos.put("contratoTransaccion", "");
		paramsMovimientos.put("fechaBaja", "");
		paramsMovimientos.put("usuarioBaja", "");

		for ( String string : paramsMovimientos.keySet() ) {
			LogHandler.info(uid, getClass(), string + " -- " + paramsMovimientos.get( string ) );
		}

		//Se inserta el tipo de movimiento en contrato_movimientos_dg
		LogHandler.trace(uid, getClass(), "==> insertaMovimientoDepositoGarantia - insertContratoMovimientosGarantia");
		sesionTX.insert("insertContratoMovimientosGarantia", paramsMovimientos);

	}

	/**
	 * @param uid :
	 * @param peticion peticion para el ajuste del cheque devuelto.
	 * @return AjusteChequeDevueltoRespuesta respuesta de la operacion.
	 */
	@SuppressWarnings({ "unchecked" }) //TODO ajustarPorChequeDevuelto
	public AjusteChequeDevueltoRespuesta  ajustarPorChequeDevuelto(String uid, AjusteChequeDevueltoPeticion peticion) {
		AjusteChequeDevueltoRespuesta resp = new AjusteChequeDevueltoRespuesta();
		FechaContableOV fechaContable = comun.obtenerFechaContable( uid );

		SqlSession sesionTX 						= null;
		SqlSession sesionNTX						= null;
		Integer idTransaccion 						= null;
		Double nuevoMontoPago 						= null;
		Double nuevoMontoContrato					= null;
		HashMap<String, Object> datosContrato 		= null;
		String seguroVida							= null;
		String seguroEnfermedad						= null;

		HashMap<String, Object> params = new HashMap<String, Object>();
		HashMap<String, Object> paramsActDepGar = new HashMap<String, Object>();

		//Validamos la peticion
		if (peticion.getNumeroContrato() == null  || peticion.getCliente() == null || peticion.getUsuario() == null
			|| peticion.getFechaDevolucion() == null || peticion.getTipoDevolucion() == null) {
			LogHandler.error(uid, getClass(), ReadProperties.mensajes.getProp(
				"ciof.error.datos.incompletos"), new Exception(ReadProperties.mensajes.getProp("ciof.error.datos.incompletos")));
			resp.setHeader(generarHeader(uid, false, "Datos peticion incompletos"));
			return resp;
			}

		//Validacion de usuario
		if (peticion.getUsuario().trim().isEmpty()) {
			LogHandler.error(uid, getClass(), ReadProperties.mensajes.getProp(
				"ciof.error.datos.incompletos"), new Exception(ReadProperties.mensajes.getProp("ciof.error.datos.incompletos")));
				resp.setHeader(generarHeader(uid, false, "Datos peticion incompletos, falta usuario."));
				return resp;
		}

		//Se obtiene la equivalencia del contrato en caso de que sea LD
		if ( peticion.getNumeroContrato().trim().toUpperCase().startsWith( "LD" ) ) {
			SqlSession sqlSessionNTx = null;
			try {
				sqlSessionNTx = FabricaConexiones.obtenerSesionNTx();

				//El busca el equivalente del LD para credprod
				LogHandler.trace(uid, getClass(), "==> ajustarPorChequeDevuelto - obtenerRelacionContrato");
				peticion.setNumeroContrato( (String) sqlSessionNTx.selectOne(
											"obtenerRelacionContrato", peticion.getNumeroContrato() ) );

				if ( peticion.getNumeroContrato() == null || peticion.getNumeroContrato().trim().equals( "" ))
					{	throw new Exception( ReadProperties.mensajes.getProp("ciof.noexisterelacion") );					}
				}

			catch ( java.lang.Exception exception ) {
				//Se cierra la conexion
				FabricaConexiones.close( sqlSessionNTx );
				LogHandler.error(uid, getClass(), exception.getMessage(), exception );
				resp.setHeader(generarHeader(uid, false, exception.getMessage() ));
				return resp;
				}
			finally {
				FabricaConexiones.close( sqlSessionNTx );
				}
			}

		try {

			//Se valida el codigo de seguro de vida AOC
			seguroVida = comun.obtenerParGeneral(uid, "SEGURO_VIDA");
			LogHandler.trace(uid, this.getClass(), "==> ajustarPorChequeDevuelto - seguroVida: " + seguroVida);

			if (seguroVida == null || seguroVida.trim().isEmpty()) {
				throw new Exception("No fue posible obtener el valor del codigo para el tipo de seguro de Vida.");
			}
			//Se valida el codigo de seguro de Enfermedad AOC
			seguroEnfermedad = comun.obtenerParGeneral(uid, "SEGURO_ENFERMEDAD");
			LogHandler.trace(uid, this.getClass(), "==> ajustarPorChequeDevuelto - seguroEnfermedad: "
					+ seguroEnfermedad);

			if (seguroEnfermedad == null || seguroEnfermedad.trim().isEmpty()) {
				throw new Exception("No fue posible obtener el valor del codigo para el seguro de Enfermedad.");
			}

			// Validar que se pueda realizar la operaci�n ( que no se esta ejecutando el cierre )
			if ( fechaContable.isEstatusCierre()) {
				throw new Exception( ReadProperties.mensajes.getProp("ciof.error.ejecucioncierre"));
			}

			datosContrato = comun.obtenerDatosGeneralesContrato(uid, peticion.getNumeroContrato());

			if (datosContrato == null || datosContrato.get("sucursal") == null) {
				throw new Exception(ReadProperties.mensajes.getProp(
						"administracion.ajustarporchequedevuelto.errordatoscontrato"));
			}

			if ( !datosContrato.get( "status" ).toString().trim().equals( "N" )
				&& !datosContrato.get( "status" ).toString().trim().equals( "D" ) ) {
				throw new Exception(ReadProperties.mensajes.getProp(
						"administracion.ajustarporchequedevuelto.errorstatuscontrato"));
			}

			//Se abre la conexion no transaccional
			sesionNTX = FabricaConexiones.obtenerSesionNTx();

			//Validamos que la sucursal no pueda realizar devoluciones de financiadas
			if ( peticion.getSucursal() > 0) {
				if ( Double.parseDouble(datosContrato.get("monto_liq_ctrant").toString()) > 0.0 ) {
					throw new Exception("No se puede realizar la devolucion, el contrato es renovacion financiada.");
				}

				params.put("contrato", peticion.getNumeroContrato());
				LogHandler.trace(uid, getClass(), "==> ajustarPorChequeDevuelto - obtenerNumeroPagosContrato");
				Integer numeroPagos = (Integer) sesionNTX.selectOne("obtenerNumeroPagosContrato", params);

				if (numeroPagos > 0 ) {
					throw new Exception("Cliente con pago, solicitar al area de operaciones la devolucion del cheque.");
				}

			}

			//Obtencion del cliente si es t24
			final java.lang.String clienteAux = comun.obtenerPersonaCliente(uid, peticion.getCliente());
			if ( clienteAux != null ) {
				peticion.setCliente( clienteAux );
			}

			//Validamos que no tenga ya un movimiento de cheque devuelto
			params.put("contrato", peticion.getNumeroContrato());
			params.put("integrante", clienteAux);
			LogHandler.trace(uid, getClass(), "==> ajustarPorChequeDevuelto - validacionChequeDevuelto");
			final Date validacion = (Date) sesionNTX.selectOne("validacionChequeDevuelto", params);

			if ( validacion != null ) {
				throw new Exception(ReadProperties.mensajes.getProp(
						"administracion.ajustarporchequedevuelto.errordevoluciontotal"));
			}

			//Obtener datos integrante
			params.put("contrato", peticion.getNumeroContrato());
			params.put("cliente", peticion.getCliente());
			LogHandler.trace(uid, this.getClass(), "==> ajustarPorChequeDevuelto - obtenerMontoIntegrante");

			HashMap<String, Object> datosIntegrante
			 	= (HashMap<String, Object>) sesionNTX.selectOne("obtenerMontoIntegrante", params);

			//Calcular nuevo monto de pago
			if ( datosIntegrante.get("monto_otorgado") == null) {
				throw new Exception(ReadProperties.mensajes.getProp(
						"administracion.ajustarporchequedevuelto.errordatosintegrante"));
			}

			Double montoFinanciado = datosIntegrante.get("monto_liq_ctrant") == null
					? 0.0 : ((BigDecimal) datosIntegrante.get("monto_liq_ctrant")).doubleValue();

			String estatusIntegrante = (String) datosIntegrante.get("status");

			//Se calcula el monto a partir del tipo de cheque devuelto
			//los tipod son :
			//  DTOT - Devoluci�n Total
			//	DCHQ - Devoluci�n de cheque
			//	DFIN - Devoluci�n financiado

			final Double montoIntegrante = 	peticion.getTipoDevolucion().equals("DFIN")  ? montoFinanciado
					: peticion.getTipoDevolucion().equals("DTOT")
						? ((BigDecimal) datosIntegrante.get("monto_otorgado")).doubleValue()
								: (((BigDecimal) datosIntegrante.get("monto_otorgado")).doubleValue() - montoFinanciado);

			if ( montoIntegrante == null ) {
				throw new Exception(ReadProperties.mensajes.getProp(
						"administracion.ajustarporchequedevuelto.errortipodevolucion"));
			}

			final Double montoCheque = ((BigDecimal) datosIntegrante.get("monto_otorgado")).doubleValue() - montoFinanciado;


			//Se consulta el estatus del integrante, si el estatus es I, el integrante ya es Inactivo,
			//por lo que ya no se procede a realizar el ajuste al contrato
			if ("I".equalsIgnoreCase(estatusIntegrante) ) {
				throw new Exception(ReadProperties.mensajes.getProp(
						"administracion.ajustarporchequedevuelto.errorstatusintegrante"));
			}

			//Se obtiene el monto de seguro de vida AOC
			final Double montoSeguroIntegranteVida = datosIntegrante.get("monto_seguro_vida") == null
					? 0.0 : ((BigDecimal) datosIntegrante.get("monto_seguro_vida")).doubleValue();
			LogHandler.trace(uid, this.getClass(),
					"==> ajustarPorChequeDevuelto - monto seguro integrante vida:" + montoSeguroIntegranteVida);

			//Se obtiene el monto de seguro de enfermedad AOC
			final Double montoSeguroIntegranteEnfermedad = datosIntegrante.get("monto_seguro_enfermedad") == null
					? 0.0 : ((BigDecimal) datosIntegrante.get("monto_seguro_enfermedad")).doubleValue();
			LogHandler.trace(uid, this.getClass(),
					"==> ajustarPorChequeDevuelto - monto seguro integrante enfermedad:" + montoSeguroIntegranteEnfermedad);

			//MIMH 2013-11-12 COMERFIN-41 Seguros
			final Double montoSeguroIntegrante = datosIntegrante.get("monto_seguro") == null
					? 0.0 : ((BigDecimal) datosIntegrante.get("monto_seguro")).doubleValue();
			LogHandler.trace(uid, this.getClass(),
					"==> ajustarPorChequeDevuelto - monto seguro integrante:" + montoSeguroIntegrante);


			// Obtiener id de transaccion
			idTransaccion = comun.obtenerIdTransaccion(uid, (Integer) datosContrato.get("sucursal"), fechaContable.getFecha());
			LogHandler.info(uid, getClass(), " idTransaccion=" + idTransaccion);

			//Verifica si el contrato se cancela por que solo queda un cliente activo
			//cancelarContrato
			params.put("contrato", peticion.getNumeroContrato());
			LogHandler.trace(uid, getClass(), "==> ajustarPorChequeDevuelto - verificarClientesActivos");
			Integer integrantesActivos = (Integer) sesionNTX.selectOne("verificarClientesActivos", params);

			if (integrantesActivos.intValue() == 1 ) {

				//Verificamos si tiene seguro que cancelar
				//MIMH 2014-12-16 ORIG-134
				//insertar el movimiento de cancelacion de seguro
				SqlSession sesionTXTemp = FabricaConexiones.obtenerSesionTx();

				if ( montoSeguroIntegrante > 0) {
					//Realizar la anulacion del seguro en crediseguros

					String peticionSeguros = "<clientes>";
					peticionSeguros += "<cliente>";
					peticionSeguros += "<numeroPersona>" + peticion.getCliente() + "</numeroPersona>";
					peticionSeguros += "<contrato>" + peticion.getNumeroContrato() + "</contrato>";
					peticionSeguros += "</cliente>";
					peticionSeguros += "</clientes>";
					LogHandler.info(uid, getClass(), "==> ajustarPorChequeDevuelto - peticionSeguros=" + peticionSeguros);

					LogHandler.trace(uid, getClass(), "validacionIDSolicitudBuro: - obtenerParGeneral");
					ParGeneralOV urlWSSeguros = comun.obtenerParGeneralOV(uid, "WS_SEG_ANU");
							//(ParGeneralOV) sesionNTX.selectOne("obtenerParGeneral", "WS_SEG_ANU");
					if (urlWSSeguros == null || urlWSSeguros.getCgValor().trim().isEmpty()) {
							throw new Exception("No fue posible obtener la URL del servicio de seguros, anulacion.");
					}

					try {
						AnulacionServiceLocator servicioSeguros = new AnulacionServiceLocator();
						servicioSeguros.setAnulacionPortEndpointAddress(urlWSSeguros.getCgValor().trim());
						String respuestaSeguros = servicioSeguros.getAnulacionPort().anularAfiliaciones(peticionSeguros);
						LogHandler.info(uid, getClass(), "==> ajustarPorChequeDevuelto - respuestaSeguros=" + respuestaSeguros);

						if (respuestaSeguros.contains("false")) {
							//Ocurrio un error en la anulacion del seguro
							String tag = "mensajeError";
							String value = "";
							String tagBuscar = "<" + tag + ">";
							String tagFinBuscar = "</" + tag + ">";
							value = respuestaSeguros.substring(respuestaSeguros.indexOf(tagBuscar)
									+ tagBuscar.length(), respuestaSeguros.indexOf(tagFinBuscar));
							throw new Exception(value);
						}
					}
					catch (Exception ex) {
						LogHandler.error(uid, getClass(), ex.getMessage(), ex);
						throw new Exception("Error en Servicio Seguros: " + ex.getMessage() );
					}

					//insertar el movimiento de cancelacion de seguro
					if ( datosIntegrante.get("seguroVida").equals("S")) {
					insertaMovimiento(uid, sesionTXTemp, peticion.getNumeroContrato(),
							(Integer) datosContrato.get("sucursal"), CODIGO_SEGURO_DEV,
							REF_SEGURO_DEV + " " + peticion.getCliente(), peticion.getUsuario(),
							montoSeguroIntegranteVida * -1, montoSeguroIntegranteVida * -1, idTransaccion,
							(String) datosContrato.get("propietario"),
							fechaContable.getFecha(), peticion.getFechaDevolucion(), seguroVida);

					}
					if (datosIntegrante.get("seguroEnfermedad").equals("S")) {
						insertaMovimiento(uid, sesionTXTemp, peticion.getNumeroContrato(),
								(Integer) datosContrato.get("sucursal"), CODIGO_SEGURO_DEV,
								REF_SEGURO_DEV_ENFERMEDAD + " " + peticion.getCliente(), peticion.getUsuario(),
								montoSeguroIntegranteEnfermedad * -1, montoSeguroIntegranteEnfermedad * -1, idTransaccion,
								(String) datosContrato.get("propietario"),
								fechaContable.getFecha(), peticion.getFechaDevolucion(), seguroEnfermedad);
					}
				}

				params.put("contrato", peticion.getNumeroContrato());
				params.put("tipoMovimiento", "CSEG");
				LogHandler.trace(uid, this.getClass(), "==> ajustarPorChequeDevuelto - actualizaCargoSeguroDevolucion");
				sesionTXTemp.update("actualizaCargoSeguroDevolucion", params);
				sesionTXTemp.commit(true);
				FabricaConexiones.close( sesionTXTemp  );

				CancelacionContratoOV peticionCancelacion = new CancelacionContratoOV();
				peticionCancelacion.setContratoLD(peticion.getNumeroContrato());
				peticionCancelacion.setOperador(peticion.getUsuario());
				CancelacionContratoRespuesta respuestaCancelacion
					= cancelarContrato(peticionCancelacion, uid, null);

				if ( !respuestaCancelacion.getHeader().isEstatus() ) {
					throw new Exception(respuestaCancelacion.getHeader().getMensaje());
				} else {
					resp.setHeader(generarHeader(uid, true, "Cancelacion del contrato correcta"));
					return resp;
				}
			}

			//se le resta el monto del cheque devuelto(monto otorgado al integrante) al monto total del contrato
			//MIMH 2013-11-12 COMERFIN-41 Seguros - resta el monto seguro del cliente

			nuevoMontoContrato = ((BigDecimal) datosContrato.get("monto")).doubleValue()
												- montoIntegrante - montoSeguroIntegrante;
			datosContrato.put("monto", nuevoMontoContrato);

			//Obtener el - codigo - para tipo de c�lculo
			LogHandler.trace(uid, this.getClass(), "==> ajustarPorChequeDevuelto - obtenerTipoCalculoInteres");
			final java.util.HashMap<String, Object>
										mapaCodigoCalculo = (HashMap<String, Object>) sesionNTX.selectOne(
														"obtenerTipoCalculoInteres", datosContrato );

			//Campos para el calculo de intereses
			datosContrato.put( "tipoCalculo"  , mapaCodigoCalculo.get( "valor" ).toString() );
			datosContrato.put( "fechaInicial" , datosContrato.get( "fecha_disposicion" ).toString() );
			datosContrato.put( "fechaFinal"   , datosContrato.get( "fecha_esp_liq" ).toString() );
			datosContrato.put( "producto"     , datosContrato.get( "producto" ).toString() );

			//se calcula el nuevo monto de pago del contrato
			LogHandler.trace(uid, this.getClass(), "==> ajustarPorChequeDevuelto - calculaMontoPago");
			nuevoMontoPago = (Double) sesionNTX.selectOne("calculaMontoPago", datosContrato);

			//Se abre la sesion transaccional
			sesionTX = FabricaConexiones.obtenerSesionTx();

			//Se valida que se haya seleccionado la opcion de aplicar Garantia AOC
			if (peticion.getAplicarGarantia()) {
				//Se valida que el monto garantia no sea mayor al saldo garantia del crédtio
				if (peticion.getSaldoGarantia() > Double.parseDouble(datosContrato.get("saldoGarantiaContrato").toString())) {
					throw new Exception("No se puede aplicar la garantía, el saldo es insuficiente");
				}
				else {
					//Se obtienen los parametros que se van a enviar
					//Se inserta el tipo de movimiento en contrato_movimientos_dg
					insertaMovimientoDepositoGarantia(uid, sesionTX, peticion.getNumeroContrato(), CODIGO_APLICA_GARANTIA,
							fechaContable.getFecha(), fechaContable.getFecha(), peticion.getSaldoGarantia(), 0.0, 0.0,
							0.0, peticion.getUsuario(), peticion.getCliente());

		    		//Se hace un update a contrato_deposito_garantia
			    	paramsActDepGar.put("contrato", peticion.getNumeroContrato());
			    	paramsActDepGar.put("montoAplicar", peticion.getSaldoGarantia());
			    	LogHandler.trace(uid, getClass(),
			    			"==> aplicarGarantiaLiquidacion - actualizaSaldoGarantiaDepositoGarantia");
			    	sesionTX.update("actualizaSaldoGarantiaDepositoGarantia", paramsActDepGar);

			    	//Pago
                    final PagoGrupal pago = new PagoGrupal();
                    PagoGrupalResponse pagoResponse = new PagoGrupalResponse();

                    pago.setMonto(peticion.getSaldoGarantia());
                    pago.setNumeroContrato(peticion.getNumeroContrato());
                    pago.setMedioPago(peticion.getMedioPago() + "_");
                    pago.setReferencia("");
                    pago.setTipoPago(ConstantesPagos.TIPO_PAGO_NORMAL.getValue());
                    pago.setUsuario(peticion.getUsuario());
                    pago.setCodigo(ConstantesPagos.PAGO_REFERENCIADO.getValue());
                    pago.setIdTransaccionValida(null);
                    LogHandler.info(uid, getClass(), "medio Pago: Pago " + pago.getMedioPago());
                    pagoResponse = pagos.aplicarPagoGrupal(uid, sesionTX, idTransaccion, pago );

                    if ( !pagoResponse.getHeader().isEstatus()) {
        				throw new Exception(pagoResponse.getHeader().getMensaje());
        			}

                    //Se actualiza el estatus del integrante
                    params.clear();
        			params.put("contrato", peticion.getNumeroContrato());
        			params.put("cliente", peticion.getCliente());
                    params.put("estatus", "I");
        			params.put("fecha", FORMATTER.format(fechaContable.getFecha()));
                    LogHandler.trace(uid, getClass(), "==> ajustarPorChequeDevuelto - actualizaEstatusIntegrante ");
    				sesionTX.update("actualizaEstatusIntegrante", params);
				}
			}
			//Historico de Contrato
			params.clear();
			params.put("usuario", peticion.getUsuario());
			params.put("contrato", peticion.getNumeroContrato());
			params.put("tipoMovimiento", CODIGO_CHEQUE_DEV);
			LogHandler.trace(uid, this.getClass(), "==> ajustarPorChequeDevuelto - insertaContratosMovimientosAjuste");
			sesionTX.insert("insertaContratosMovimientosAjuste", params);

			//Se actualiza el contrato (monto, capital_insoluto, fecha_ult_mov, monto_pago)
			params.clear();
			params.put("contrato", peticion.getNumeroContrato());
			params.put("monto", nuevoMontoContrato);
			params.put("montoIntegrante", montoIntegrante);
			params.put("fecha", FORMATTER.format(fechaContable.getFecha()));
			params.put("montoPago", nuevoMontoPago);
			//MIMH 2013-11-12 COMERFIN-41 Seguros
			//Se agrega el monto seguro del integrante
			params.put("montoSeguroIntegrante", montoSeguroIntegrante);

			LogHandler.trace(uid, getClass(), "==> ajustarPorChequeDevuelto - actualizaContratoAjusteChequeDev");
			sesionTX.update("actualizaContratoAjusteChequeDev", params);

			//Se actualizan las tablas integrante_grupo y contrato_grupo
			params.clear();
			params.put("contrato", peticion.getNumeroContrato());
			params.put("cliente", peticion.getCliente());
			params.put("montoIntegrante", montoIntegrante);

			LogHandler.trace(uid, getClass(), "==> ajustarPorChequeDevuelto - actualizaContratoGrupoChequeDev");
			sesionTX.update("actualizaContratoGrupoChequeDev", params);

			params.put("estatus", "I");
			params.put("fecha", FORMATTER.format(fechaContable.getFecha()));

			//Actualizar el estatus del integrante para los casos:
			//DTOT - Devoluci�n Total, DFIN - Devoluci�n financiado y cuando no tienen monto financiado

			if 	( montoFinanciado == 0 || montoFinanciado  == null
					|| peticion.getTipoDevolucion().equals("DFIN")
					|| peticion.getTipoDevolucion().equals("DTOT")) {
				LogHandler.trace(uid, getClass(), "==> ajustarPorChequeDevuelto - actualizaEstatusIntegrante ");
				sesionTX.update("actualizaEstatusIntegrante", params);
			}

			if (!peticion.getTipoDevolucion().equals("DFIN")) {
				//insertar el movimiento de cancelacion de ajuste por devolucion de cheque
				insertaMovimiento(uid, sesionTX, peticion.getNumeroContrato(),
						(Integer) datosContrato.get("sucursal"), CODIGO_CHEQUE_DEV,
						REF_CHEQUE_DEV + " " + peticion.getCliente(), peticion.getUsuario(),
						montoCheque * -1, montoCheque * -1, idTransaccion,
						(String) datosContrato.get("propietario"),
						fechaContable.getFecha(), peticion.getFechaDevolucion(), "");

				//MIMH 2013-11-12 COMERFIN-41 Seguros
				//insertar el movimiento de cancelacion de seguro
				if ( montoSeguroIntegrante > 0) {
					if ( datosIntegrante.get("seguroVida").equals("S")) {
					insertaMovimiento(uid, sesionTX, peticion.getNumeroContrato(),
							(Integer) datosContrato.get("sucursal"), CODIGO_SEGURO_DEV,
							REF_SEGURO_DEV + " " + peticion.getCliente(), peticion.getUsuario(),
							montoSeguroIntegranteVida * -1, montoSeguroIntegranteVida * -1, idTransaccion,
							(String) datosContrato.get("propietario"),
							fechaContable.getFecha(), peticion.getFechaDevolucion(), seguroVida);

					}
					if (datosIntegrante.get("seguroEnfermedad").equals("S")) {
						insertaMovimiento(uid, sesionTX, peticion.getNumeroContrato(),
								(Integer) datosContrato.get("sucursal"), CODIGO_SEGURO_DEV,
								REF_SEGURO_DEV_ENFERMEDAD + " " + peticion.getCliente(), peticion.getUsuario(),
								montoSeguroIntegranteEnfermedad * -1, montoSeguroIntegranteEnfermedad * -1, idTransaccion,
								(String) datosContrato.get("propietario"),
								fechaContable.getFecha(), peticion.getFechaDevolucion(), seguroEnfermedad);
					}
				}

				//si NO es contrato OPORTUNIDAD decrementar el ciclo del integrante
				String categoria  = comun.obtenerCategoria(uid, (String) datosContrato.get("producto") );
				LogHandler.debug(uid, this.getClass(), "categoria: " +  categoria );

				//Verificamos si es un producto de oportunidad
				if ( !categoria.equals( PREF_OPORTUNIDAD ) ) {
					LogHandler.trace(uid, getClass(), "==> ajustarPorChequeDevuelto - actualizaCicloIntegrante ");
					sesionTX.update("actualizaCicloIntegrante", params);
					}
			}

				//Actualizar el capital insoluto de los integrantes que siguen activos
				LogHandler.trace(uid, getClass(), "==> ajustarPorChequeDevuelto - actualizaCapitalInsolutoIntegrante ");
				sesionTX.update("actualizaCapitalInsolutoIntegrante", params);


				/**
				 * Se recalcula el interes total e iva del interes total
				 * tambien los porcentajes de participacion del resto de
				 * integrantes del grupo y se actualiza
				 */
				//Obtenemos los intereses
				InteresOV interesOV = new InteresOV();
						  interesOV.setProducto( datosContrato.get( "producto" ).toString() );
						  interesOV.setFechaInicio( (new SimpleDateFormat( "yyyy-MM-dd" ) ).parse(
								  datosContrato.get( "fecha_disposicion" ).toString() ) );
						  interesOV.setFechaFinal( (new SimpleDateFormat( "yyyy-MM-dd" ) ).parse(
								  datosContrato.get( "fecha_esp_liq" ).toString() ) );
						  interesOV.setFrecuenciaPago( datosContrato.get( "frecuencia_pago" ).toString() );
						  interesOV.setMontoCredito( Double.valueOf( datosContrato.get( "monto" ).toString() ) );
						  interesOV.setNoPagos( (Integer) datosContrato.get( "no_pagos" ) );
						  interesOV.setSucursal( (Integer) datosContrato.get( "sucursal" ) );
						  interesOV.setTasa( Double.valueOf( datosContrato.get( "tasa" ).toString() ) );

				interesOV = comun.calcularInteresTotal(uid, interesOV);

				final java.util.HashMap<String, Object>
							parametrosActualizaInteres = new HashMap<String, Object>();
							parametrosActualizaInteres.put( "contrato" 		 , peticion.getNumeroContrato() );
							parametrosActualizaInteres.put( "interesTotal" 	 , interesOV.getInteresTotal() );
							parametrosActualizaInteres.put( "ivaInteresTotal", interesOV.getIvaInteresTotal() );

				LogHandler.trace(uid, getClass(), "==> ajustarPorChequeDevuelto - actualizarInteresIvaContratos ");
				sesionTX.update( "actualizarInteresIvaContratos", parametrosActualizaInteres );

				//Actualizar porcentaje participacion
				comun.actualizarPorcentajeParticipacionIntegrante(uid, sesionTX, peticion.getNumeroContrato() );

				/**
				 * Finaliza actualizacion de intereses y porcentaje de participacion
				 */

				//MIMH 2014-12-16 ORIG-134
				//insertar el movimiento de cancelacion de seguro
				if ( montoSeguroIntegrante > 0) {
					//Realizar la anulacion del seguro en crediseguros

					String peticionSeguros = "<clientes>";
					peticionSeguros += "<cliente>";
					peticionSeguros += "<numeroPersona>" + peticion.getCliente() + "</numeroPersona>";
					peticionSeguros += "<contrato>" + peticion.getNumeroContrato() + "</contrato>";
					peticionSeguros += "</cliente>";
					peticionSeguros += "</clientes>";
					LogHandler.info(uid, getClass(), "==> ajustarPorChequeDevuelto - peticionSeguros=" + peticionSeguros);

					LogHandler.trace(uid, getClass(), "validacionIDSolicitudBuro: - obtenerParGeneral");
					ParGeneralOV urlWSSeguros = comun.obtenerParGeneralOV(uid, "WS_SEG_ANU");
							//(ParGeneralOV) sesionNTX.selectOne("obtenerParGeneral", "WS_SEG_ANU");
					if (urlWSSeguros == null || urlWSSeguros.getCgValor().trim().isEmpty()) {
							throw new Exception("No fue posible obtener la URL del servicio de seguros, anulacion.");
					}

					try {
						AnulacionServiceLocator servicioSeguros = new AnulacionServiceLocator();
						servicioSeguros.setAnulacionPortEndpointAddress(urlWSSeguros.getCgValor().trim());
						String respuestaSeguros = servicioSeguros.getAnulacionPort().anularAfiliaciones(peticionSeguros);
						LogHandler.info(uid, getClass(), "==> ajustarPorChequeDevuelto - respuestaSeguros=" + respuestaSeguros);

						if (respuestaSeguros.contains("false")) {
							//Ocurrio un error en la anulacion del seguro
							String tag = "mensajeError";
							String value = "";
							String tagBuscar = "<" + tag + ">";
							String tagFinBuscar = "</" + tag + ">";
							value = respuestaSeguros.substring(respuestaSeguros.indexOf(tagBuscar)
									+ tagBuscar.length(), respuestaSeguros.indexOf(tagFinBuscar));
							throw new Exception(value);
						}
					}
					catch (Exception ex) {
						LogHandler.error(uid, getClass(), ex.getMessage(), ex);
						throw new Exception("Error en Servicio Seguros: " + ex.getMessage() );
					}

				}

				sesionTX.commit(true);

				resp.setHeader(generarHeader(uid, true, ReadProperties.mensajes.getProp("ciof.proceso.correcto")));
			}
		catch (Exception e) {
			//e.printStackTrace();
			LogHandler.info(uid, getClass(), "==> ajustarPorChequeDevuelto - ROLLBACK!!!");
			FabricaConexiones.rollBack(sesionTX);
			LogHandler.error(uid, getClass(), e.getMessage(), e);
			resp.setHeader(generarHeader(uid, false, e.getMessage()));
		} finally {
			FabricaConexiones.close(sesionNTX);
			FabricaConexiones.close(sesionTX);
		}

		// STAF-195
		if (resp.getHeader().isEstatus()) {
			DatosCreditoIntegrantesRespuesta datosIntegrantes = new DatosCreditoIntegrantesRespuesta();
  			List<FoliosChequesSIC> foliosRespuestaWS = null;
  			DatosIntegranteResumenOV[] integrante = new DatosIntegranteResumenOV[1];
  			try {
  				if (!"0".equals(peticion.getFolioCheque())){
  					integrante[0] = new DatosIntegranteResumenOV();
  		  			integrante[0].setFolioCheque(peticion.getFolioCheque()); 

  		  			datosIntegrantes.setIntegrantes(integrante);
  				
  					foliosRespuestaWS = this.cancelaChequesSIC(uid, Arrays.asList(datosIntegrantes.getIntegrantes()), peticion.getUsuario());
  					if(foliosRespuestaWS != null && foliosRespuestaWS.size() > 0) {
  						foliosRespuestaWS.get(0).setCancelacionCheque(true);
  					}
  					resp.setResultadoSIC(foliosRespuestaWS);
  				} else {
  					FoliosChequesSIC respuestaSinSIC = new FoliosChequesSIC();
  					foliosRespuestaWS = new ArrayList<FoliosChequesSIC>();
  					respuestaSinSIC.setCancelacionCheque(true);
  					respuestaSinSIC.setComentario("Exito");
  					respuestaSinSIC.setFolioCheque(Long.parseLong(peticion.getFolioCheque()));
  					respuestaSinSIC.setNombre("_");
  					respuestaSinSIC.setPersona(peticion.getCliente());
  					foliosRespuestaWS.add(respuestaSinSIC);
  					resp.setResultadoSIC(foliosRespuestaWS);
  				}
  				
			} catch (Exception e) {
				LogHandler.error(uid, this.getClass(), "ajustarPorChequeDevuelto > Hubo un problema con el WS ChequesSIC: " + e.getCause(), e);
				List<FoliosChequesSIC> foliosRespuestaError = new ArrayList<FoliosChequesSIC>();

				//for (int i = 0; i < datosIntegrantes.getIntegrantes().length; i++) {
					FoliosChequesSIC respError = new FoliosChequesSIC();
					//if ((foliosRespuestaWS.get(0).getFolioCheque()+"").equalsIgnoreCase(datosIntegrantes.getIntegrantes()[0].getFolioCheque()) && foliosRespuestaWS.get(0).getValor()!=1) {
						respError.setComentario("[SIC] Error " + e.getMessage());
						respError.setFolioCheque(Long.parseLong(peticion.getFolioCheque()));
						respError.setCancelacionCheque(true);
						respError.setMontoCheque("0");
						respError.setNombre("_");
						respError.setPersona(peticion.getCliente());
						foliosRespuestaError.add(respError);
					//}
				//}
				resp.setResultadoSIC(foliosRespuestaError);
			}
		}

		return resp;
	}

	/**
	 * @param peticion peticion para la cancelacion del contrato
	 * @param uid identificador de la transaccion
	 * @param sesionExterna sesion a la BD para manejar una transaccional
	 * @return CancelacionContratoRespuesta resultado de la cancelacion.
	 */
	@SuppressWarnings("unchecked") //TODO cancelarContrato
	public CancelacionContratoRespuesta cancelarContrato(CancelacionContratoOV peticion, String uid , SqlSession sesionExterna) {
		String msg = "CANCELADO [";
  		CancelacionContratoRespuesta respuesta 	= new CancelacionContratoRespuesta( );
		SqlSession		sesionTx				= null;
		SqlSession      sesionNTx				= null;

		DatosCreditoIntegrantesRespuesta respuestaDI = new DatosCreditoIntegrantesRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);

		ResultadoOV		resultado				= null;
		HashMap<String, Object> params 			= new HashMap<String, Object>( );
		respuesta.setHeader( new EncabezadoRespuesta( ) );
		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
  		try {

  			String identificador = comun.obtenerNumeroContrato(uid, peticion.getContratoLD());
  			LogHandler.debug(uid, this.getClass(), "identificador :" + identificador);
			if ( identificador == null ) {
				throw new Exception( ReadProperties.mensajes.getProp("ciof.noexisterelacion"));
			}

			Map<String, Object> datosTasa = comun.obtenerDatosGeneralesContrato(uid, identificador );
			if ( datosTasa == null || datosTasa.isEmpty() ) {
				LogHandler.info(null, this.getClass(), ReadProperties.mensajes.getProp(
						"administracion.cancelarcontrato.errortasa"));
				throw new Exception( ReadProperties.mensajes.getProp("administracion.cancelarcontrato.errortasa") );
			}

			if ( !datosTasa.get( "status" ).toString().trim().equals( "N" )
					&& !datosTasa.get( "status" ).toString().trim().equals( "D" ) ) {
				LogHandler.info(null, this.getClass(), ReadProperties.mensajes.getProp("ciof.error.statuscontrato"));
				throw new Exception(  ReadProperties.mensajes.getProp("ciof.error.statuscontrato") );
				}

			LogHandler.debug(null, this.getClass(), "datosTasa :" + datosTasa);
			//Date fechaPrimVenc = ( Date )datosTasa.get(FECHA_PRIM_VENC);
			Integer sucursal = (Integer) datosTasa.get(SUCURSAL);
			Double monto = Double.valueOf( datosTasa.get(MONTO).toString() );
			String producto  = (String) datosTasa.get(PRODUCTO);

  			FechaContableOV fechaContableOV = (FechaContableOV) comun.obtenerFechaContablePorSucursal( uid, sucursal);
  			LogHandler.debug(uid, this.getClass(), "fechaContableOV :" + fechaContableOV);
			if ( fechaContableOV == null ) {
				LogHandler.info(uid, this.getClass(), ReadProperties.mensajes.getProp("ciof.errorfechacontable"));
				throw new Exception(  ReadProperties.mensajes.getProp("ciof.errorfechacontable") );
			}

			if ( fechaContableOV.isEstatusCierre()  ) {
				LogHandler.info(uid, this.getClass(), ReadProperties.mensajes.getProp("ciof.error.ejecucioncierre"));
				throw new Exception( ReadProperties.mensajes.getProp("ciof.error.ejecucioncierre") );
			}

			Date fechaContable =  fechaContableOV.getFecha();

			LogHandler.debug(uid, this.getClass(), "Tratando de abrir la caja... ");
			ResultadoOV aperturaCaja = comun.aperturaCaja(uid, sucursal, fechaContable );
			if ( aperturaCaja.getCodigoRetorno() < 0 ) {
				LogHandler.debug(uid, this.getClass(), ReadProperties.mensajes.getProp("ciof.error.cajavirtual"));
				throw new Exception( ReadProperties.mensajes.getProp("ciof.error.cajavirtual") );
			}

			LogHandler.debug(uid, this.getClass(), "aperturaCaja: " + aperturaCaja );

			Integer idTrx = comun.obtenerIdTransaccion(uid, sucursal, fechaContable );

			if ( sesionExterna == null) {
				sesionTx = FabricaConexiones.obtenerSesionTx( );
			} else {
				sesionTx = sesionExterna;
			}

			sesionNTx = FabricaConexiones.obtenerSesionNTx( );

			//Se verifica el pago del cliente AOC
			LogHandler.trace(uid, getClass(), "==> cancelarContrato - " + "Se verifica el pago del cliente");
			HashMap<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("contrato", identificador);
			LogHandler.trace(uid, getClass(), "==> cancelarContrato - obtenerNumeroPagosContratoTx");
			Integer numeroPagos = (Integer) sesionTx.selectOne("obtenerNumeroPagosContratoTx", parameters);

			if (numeroPagos > 0 ) {
			throw new Exception("Contrato con pago, no es posible realizar la cancelación del contrato.");
			}

			//Cancelamos la disposicion
	 		params.put(CONTRATO, identificador );
	 		params.put(FECHA_CANCELACION, comun.obtenerFechaActual(uid) );
	 		params.put(OPERADOR, peticion.getOperador() == null ? " " : peticion.getOperador() );
	 		params.put(SUCURSAL, sucursal );
	 		params.put(DISPOSICION, monto );
	 		params.put(IDX_TRX_CAJA, idTrx  );
	 		params.put(FECHA_CONTABLE, FORMATTER.format( fechaContable ) );
	 		params.put("solicitud", datosTasa.get( "solicitud" ).toString());

	 		LogHandler.debug(uid, this.getClass(), CONTRATO + "  " + identificador );
	 		LogHandler.debug(uid, this.getClass(), FECHA_CANCELACION + "  " + new Date() );
	 		LogHandler.debug(uid, this.getClass(), OPERADOR + "  "
	 					+ (peticion.getOperador() == null ? " " : peticion.getOperador()));
	 		LogHandler.debug(uid, this.getClass(), SUCURSAL  + "  " + sucursal );
	 		LogHandler.debug(uid, this.getClass(), DISPOSICION + "  " + monto );
	 		LogHandler.debug(uid, this.getClass(), IDX_TRX_CAJA + "  " + idTrx  );
	 		LogHandler.debug(uid, this.getClass(), FECHA_CONTABLE + "  " + FORMATTER.format( fechaContable ) );

	 		LogHandler.trace(uid, getClass(), "==> cancelarContrato - " + OPER_CANCELA_DISPOSICION);

	 		if (datosTasa.get("status").toString().trim().equals("N")) {
	 			LogHandler.trace(uid, getClass(), "==> cancelarContrato - eliminarContrato" );
	 			resultado = (ResultadoOV) sesionTx.selectOne("eliminarContrato", params);
	 		}
	 		else {
	 			resultado = (ResultadoOV) sesionTx.selectOne( OPER_CANCELA_DISPOSICION, params );
	 		}

	 		params.clear();

	 		if ( resultado != null && resultado.getCodigoRetorno() < 0 ) {
				LogHandler.debug(uid, this.getClass(), ReadProperties.mensajes.getProp(
						"originacion.registrar.errordisposicion"));
				throw new Exception( resultado.getMensaje() != null && !resultado.getMensaje().trim().equals( "" )
						? resultado.getMensaje() : ReadProperties.mensajes.getProp(
								"originacion.registrar.errordisposicion") );
	 		}
	 		else {
	 			if (!datosTasa.get( "status" ).toString().trim().equals( "N" )) {
	 				if ( monto > 0) {
		 			params.put(SUCURSAL, sucursal );
					params.put(FECHA_CONTABLE, FORMATTER.format(fechaContable));
					params.put(MONTO, monto * -1);
					LogHandler.trace(uid, getClass(), "==> cancelarContrato - " + "registraCajaInventario");
					sesionTx.selectOne("registraCajaInventario", params);
					params.clear();
					LogHandler.debug(uid, this.getClass(), "registraCajaInventario: DONE");

					params.put(CODIGO, CODIGO_PAGO_CANCELACION_DISP );
					params.put(CONTRATO, identificador);
					params.put(SUCURSAL, sucursal );
					params.put(USUARIO, ConstantesPagos.USUARIO_PAGO.getValue());
					params.put(FECHA_CONTABLE, FORMATTER.format(fechaContable));
					params.put(MONTO, monto * -1);
					params.put(IDXTRXCAJA, idTrx);
					params.put(FECHA_ACTUAL, FORMATTER.format( fechaContable ) );
					params.put(MEDIO_RECEPCION, ConstantesPagos.MEDIO_RECEPCION_FSOL.getValue());
			 		params.put(CLAVE, 0);
			 		params.put(CLAVE_PRODUCCION, "");
			 		params.put(REFERENCIA1, " ");
			 		params.put(REFERENCIA2, " ");
			 		params.put("referencia3", " ");
			 		LogHandler.trace(uid, getClass(), "==> cancelarContrato - " + OPER_REGISTRA_OPERACION_CAJA);
			 		resultado = (ResultadoOV) sesionTx.selectOne( OPER_REGISTRA_OPERACION_CAJA, params );
			 		params.clear();
	 				}
			 		if ( resultado != null && resultado.getCodigoRetorno() < 0 ) {
							LogHandler.info(uid, this.getClass(), ReadProperties.mensajes.getProp(
									"ciof.error.cajavirtualregistro"));
							throw new Exception( ReadProperties.mensajes.getProp(
									"ciof.error.cajavirtualregistro") );
			 			}
		 			LogHandler.debug(uid, this.getClass(), "OPER_CANCELA_DISPOSICION: DONE " + resultado );
		 			}
	 		}


	 		//Verificar la categoria del producto
			String categoria  = comun.obtenerCategoria(uid, producto );
			LogHandler.debug(uid, this.getClass(), "categoria: " +  categoria );

			//Verificamos si es un producto de oportunidad
			if ( !categoria.equals( PREF_OPORTUNIDAD ) ) {
				LogHandler.debug(uid, this.getClass(), "NO ES CATEGORIA OPORTUNIDAD SE DECREMENTA CICLO: ");
				//Decrementar ciclo de integrantes...
				LogHandler.trace(uid, getClass(), "==> cancelarContrato - " + OPER_DECREMENTA_CICLO_INTEGRANTE);
		 		sesionTx.update(OPER_DECREMENTA_CICLO_INTEGRANTE, identificador);
		 		LogHandler.debug(uid, this.getClass(), "OPER_DECREMENTA_CICLO_INTEGRANTE: DONE ");
		 		//Decrementar el ciclo del grupo
		 		LogHandler.trace(uid, getClass(), "==> cancelarContrato - " + OPER_DECREMENTA_CICLO_GRUPO);
		 		sesionTx.update(OPER_DECREMENTA_CICLO_GRUPO, identificador );
		 		LogHandler.debug(uid, this.getClass(), "OPER_DECREMENTA_CICLO_GRUPO: DONE ");

		 		//Se comprueba si es una renovacion financiada y se obtiene el ultimo contrato
		 		final Object contratoAnterior = sesionNTx.selectOne( "buscarContratoAnterior", identificador );

		 		if (contratoAnterior != null && !contratoAnterior.equals("") ) {
		 			if (datosTasa.get( "status" ).equals( "D" )) {
			 			//Se recupera la fecha movimiento a partir del contrato
			 			final java.util.Date fechaMovimiento
			 				= (Date) sesionTx.selectOne( "obtenerFechaMovimiento", identificador.toString() );

			 			//Pagos Posteriores al pago por documento
			 			final java.util.HashMap<String, Object>
			 				  			   paramPagosDesertores = new HashMap<String, Object>();
			 							   paramPagosDesertores.put( "contratoAnterior", contratoAnterior.toString());
			 							   paramPagosDesertores.put( "fechaMovimiento" , fechaMovimiento            );

	 		 			LogHandler.trace(uid, getClass(), "==> cancelarContrato - obtenerPagosDesertores" );

	 		 			final List<HashMap<String, Object>>	pagosDesertores
	 		 				= (List<HashMap<String, Object>>) sesionTx.selectList(
	 		 						"obtenerPagosDesertores", paramPagosDesertores);

			 			if ( pagosDesertores != null && !pagosDesertores.isEmpty()) {
		 					Double montoDes = 0.0;
		 					//se determinan los saldos anteriores
		 					for ( HashMap<String, Object> montos : pagosDesertores ) {
		 						montoDes += Double.parseDouble(montos.get("montoCapital").toString());
		 						}
			 				}

			 			//Monto de los pagos y su fecha valor
		 				//Cancelamos el monto total pado
			 			final java.util.HashMap<String, Object>
							paramMontoCancelar = new HashMap<String, Object>();
							paramMontoCancelar.put( "contrato", contratoAnterior.toString() );
							paramMontoCancelar.put( "fechaMovimiento" , simpleDateFormat.format(fechaMovimiento   ) );

						//Se obtiene el monto de los vales contrato anterior
						LogHandler.trace(uid, getClass(), "==> cancelarContrato - obtenerMontoCancelar" );
						final java.lang.Double
										montoCancelar = (Double) sesionTx.selectOne( "obtenerMontoCancelar", paramMontoCancelar );

			 			//Registrar cajas
			 			//Registramos movimiento Inventario
						if ( montoCancelar > 0 ) {
							params.clear();
							params.put(SUCURSAL, sucursal );
							params.put(FECHA_CONTABLE, FORMATTER.format(fechaContable));
							params.put(MONTO, montoCancelar * -1);
							LogHandler.trace(uid, getClass(), "==> cancelarContrato - " + OPER_REGISTRA_CAJA_INVENTARIO);
							sesionTx.selectOne(OPER_REGISTRA_CAJA_INVENTARIO, params);

							params.clear();
							params.put(CODIGO, CODIGO_PAGO_CANCELACION_RENO );
							params.put(CONTRATO, contratoAnterior.toString());
							params.put(SUCURSAL, sucursal );
							params.put(USUARIO, ConstantesPagos.USUARIO_PAGO.getValue());
							params.put(FECHA_CONTABLE, FORMATTER.format(fechaContable));
							params.put(MONTO, montoCancelar * -1);
							params.put(IDXTRXCAJA, idTrx);
							params.put(FECHA_ACTUAL, FORMATTER.format( fechaContable ) );
							params.put(MEDIO_RECEPCION, ConstantesPagos.MEDIO_RECEPCION_FSOL.getValue());
							params.put(CLAVE, 0);
							params.put(CLAVE_PRODUCCION, "");
							params.put(REFERENCIA1, " ");
							params.put(REFERENCIA2, " ");
							params.put("referencia3", " ");
							LogHandler.trace(uid, getClass(), "==> cancelarContrato - " + OPER_REGISTRA_OPERACION_CAJA);
							resultado = (ResultadoOV) sesionTx.selectOne( OPER_REGISTRA_OPERACION_CAJA, params );
							params.clear();

							if ( resultado != null && resultado.getCodigoRetorno() < 0 ) {
								LogHandler.info(uid, this.getClass(), ReadProperties.mensajes.getProp(
										"ciof.error.cajavirtualregistro"));
								throw new Exception( ReadProperties.mensajes.getProp(
										"ciof.error.cajavirtualregistro"));
								}
						}

						 //Cancela pagos desertores
			 			params.put("contrato", contratoAnterior);
						params.put("fecha", simpleDateFormat.format(fechaMovimiento ));
						params.put( "fechaHora" , "S");

			 			LogHandler.trace(uid, this.getClass(), "==> cancelarContrato - obtenerInicioPagosPosterioresFecha");
						final HashMap<String, Object>  inicioPagos = (HashMap<String, Object>)
								sesionNTx.selectOne("obtenerInicioPagosPosterioresFecha", params);

						//Evitemos que el operador este nulo
						peticion.setOperador( peticion.getOperador() == null ? "" : peticion.getOperador() );
			 			if (!pagos.cancelarPagos(uid, sesionTx, inicioPagos, contratoAnterior.toString(), peticion.getOperador(),
			 					idTrx, sucursal, fechaContable )) {
			 				throw new Exception(ReadProperties.mensajes.getProp("ciof.error.cancelarpagos"));
			 				}

			 			/*pagos posteriores por documentos*/
						for ( HashMap<String, Object> montos : pagosDesertores ) {
							final 	PagoGrupal
									pagoGrupal = new PagoGrupal();
									pagoGrupal.setIdPago( 0 );
									pagoGrupal.setCodigo( "PREF" );
									pagoGrupal.setFechaValor( simpleDateFormat.parse(montos.get("fechaValor").toString()));
									pagoGrupal.setMedioPago( "" );
									pagoGrupal.setMonto( Double.parseDouble( montos.get( "montoCapital" ).toString() ) );
									pagoGrupal.setNumeroContrato( contratoAnterior.toString() );
									pagoGrupal.setReferencia( "" );
							pagos.aplicarPagoGrupal(uid, sesionTx, idTrx, pagoGrupal);

			 				}

						}
		 			//Se actualiza el folio notas
		 			final java.util.HashMap<String, Object>
		 									paramFolioNotas = new HashMap<String, Object>();
		 									paramFolioNotas.put("contratoVigente", contratoAnterior);
		 									paramFolioNotas.put("contratoNuevo"	 , identificador);
		 									paramFolioNotas.put("status"		 , "I");
		 			LogHandler.trace(uid, this.getClass(), "==> cancelarContrato - actualizarFolioNotas");
		 			sesionTx.update( "actualizarFolioNotas", paramFolioNotas);
		 			}
			}

			//AOC se pasa fragmento de codigo del metodo: procEliminacionCreditoTarea
			if ( !datosTasa.get( "status" ).toString().trim().equals( "N" )) {
				int registrosAfectados = 0;
				LogHandler.trace(uid, getClass(), "cancelarContrato: - actualizaProcEliminacionCredito");
				LogHandler.info(uid, getClass(), "cancelarContrato: - actualizaProcEliminacionCredito");
				registrosAfectados = sesionTx.update("actualizaProcEliminacionCredito", identificador);
				LogHandler.info(uid, getClass(), "cancelarContrato: - registrosAfectados: " + registrosAfectados);
				if (registrosAfectados == 0) {
					throw new Exception(Constantes.ERROR_ACTUALIZACION);
				}
			}

			final HashMap<Object, Object> paramObtenerDatosInte = new HashMap<Object, Object>();
			paramObtenerDatosInte.put("contrato", identificador);

			//Se manda a obtiene la informacion de los integrantes
			LogHandler.trace(uid, getClass(), "==> cancelarContrato - obtenerIntegranteConSeguro");
			List<DatosIntegranteResumenOV> integrantes
				= (List<DatosIntegranteResumenOV>) sesionTx.selectList("obtenerIntegranteConSeguro", paramObtenerDatosInte);
			respuestaDI.setIntegrantes(integrantes.toArray(new DatosIntegranteResumenOV[integrantes.size()]));

			Boolean cancelarSeguro = false;
			String peticionSeguros = "";

			//Se valida la respuesta
			if (integrantes.size() > 0 ) {

				peticionSeguros = "<clientes>";
				//Se recorre todos los integrantes
				for ( DatosIntegranteResumenOV datosIntegranteResumenOV : respuestaDI.getIntegrantes() ) {

					//Se valida que el integrante traiga un seguro de vida o enfermedad
					if ( datosIntegranteResumenOV.getSeguro().equals("S")
							|| datosIntegranteResumenOV.getSeguroEnfermedad().equals("S")) {
						//Realizar la anulacion del seguro en crediseguros
						peticionSeguros += "<cliente>";
						peticionSeguros += "<numeroPersona>" + datosIntegranteResumenOV.getCliente() + "</numeroPersona>";
						peticionSeguros += "<contrato>" + identificador + "</contrato>";
						peticionSeguros += "</cliente>";

						LogHandler.info(uid, getClass(), "==> cancelarContrato - numero de persona ="
								+ datosIntegranteResumenOV.getCliente());

						LogHandler.info(uid, getClass(), "==> cancelarContrato - Monto seguro de vida ="
								+ datosIntegranteResumenOV.getSeguro());

						LogHandler.info(uid, getClass(), "==> cancelarContrato - Monto seguro de enfermedad ="
								+ datosIntegranteResumenOV.getSeguroEnfermedad());

						cancelarSeguro = true;
						LogHandler.info(uid, getClass(), "==> cancelarContrato - Bandera cancelarSeguro =" + cancelarSeguro);
					}
				}
				peticionSeguros += "</clientes>";
			} else {
				throw new Exception("No se encontraron integrantes para el contrato ");
			}

			if (cancelarSeguro) {

				LogHandler.info(uid, getClass(), "==> cancelarContrato - peticionSeguros=" + peticionSeguros);
				LogHandler.trace(uid, getClass(), "cancelarContrato: - obtenerParGeneral");
				ParGeneralOV urlWSSeguros = comun.obtenerParGeneralOV(uid, "WS_SEG_ANU");
				if (urlWSSeguros == null || urlWSSeguros.getCgValor().trim().isEmpty()) {
						throw new Exception("No fue posible obtener la URL del servicio de seguros, anulacion.");
				}

				try {
					//Se hace el llamado al metodo de anulacion de seguros
					AnulacionServiceLocator servicioSeguros = new AnulacionServiceLocator();
					servicioSeguros.setAnulacionPortEndpointAddress(urlWSSeguros.getCgValor().trim());
					String respuestaSeguros = servicioSeguros.getAnulacionPort().anularAfiliaciones(peticionSeguros);
					LogHandler.info(uid, getClass(), "==> cancelarContrato - respuestaSeguros="
							+ respuestaSeguros);

					//Ocurrio un error en la anulacion del seguro
					if (respuestaSeguros.contains("false")) {
						String tag = "mensajeError";
						String value = "";
						String tagBuscar = "<" + tag + ">";
						String tagFinBuscar = "</" + tag + ">";
						value = respuestaSeguros.substring(respuestaSeguros.indexOf(tagBuscar)
								+ tagBuscar.length(), respuestaSeguros.indexOf(tagFinBuscar));
						throw new Exception(value);
					}
				}
				catch (Exception ex) {
					LogHandler.error(uid, getClass(), ex.getMessage(), ex);
					throw new Exception("Error en Servicio Seguros: " + ex.getMessage() );
				}
			}

			if ( sesionExterna == null) {
				sesionTx.commit( true );
			}
	 		respuesta.getHeader().setEstatus( true );
	 		respuesta.getHeader().setMensaje(ReadProperties.mensajes.getProp("ciof.proceso.correcto"));
  		}
		catch ( Exception e) {
			if ( sesionExterna == null) {
				FabricaConexiones.rollBack( sesionTx );
			}
			LogHandler.debug(uid, this.getClass(), ReadProperties.mensajes.getProp(
					"ciof.proceso.rollback"));
			respuesta.getHeader().setMensaje( MENSAJE_ERROR + msg + e.getMessage() + "].");
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setCodigo( null );
			LogHandler.error(uid, this.getClass(), " Exception: " + e.getCause(), e);
			}
		finally {
			FabricaConexiones.close( sesionTx );
			FabricaConexiones.close( sesionNTx );
			respuesta.getHeader( ).setCorrelationId(uid);
		}
  		
  	// STAF-195 HSA // TODO VALIDAR
  		if (respuesta.getHeader().isEstatus()) {
  			DatosCreditoIntegrantesRespuesta datosIntegrantes = null;
  			List<FoliosChequesSIC> foliosRespuestaWS = null;
  			
  			ConsultaCreditoPeticion peticionIntegrantes = new ConsultaCreditoPeticion();
  			peticionIntegrantes.setContrato(peticion.getContratoLD());
  			datosIntegrantes = consultas.obtenerDatosCreditoIntegrantes(uid, peticionIntegrantes);
  			
  			if (datosIntegrantes != null && datosIntegrantes.getIntegrantes().length > 0) {
  				foliosRespuestaWS = new ArrayList<FoliosChequesSIC>();
  				for (int i = 0; i < datosIntegrantes.getIntegrantes().length; i++) {
  					List<FoliosChequesSIC> arrayTemp = new ArrayList<FoliosChequesSIC>();
					try {
						if("0".equals(datosIntegrantes.getIntegrantes()[i].getFolioCheque())){
							FoliosChequesSIC respuestaSinSIC = new FoliosChequesSIC();
		  					foliosRespuestaWS = new ArrayList<FoliosChequesSIC>();
		  					respuestaSinSIC.setCancelacionCheque(true);
		  					respuestaSinSIC.setComentario("Exito");
		  					respuestaSinSIC.setFolioCheque(Long.parseLong(datosIntegrantes.getIntegrantes()[i].getFolioCheque()));
		  					respuestaSinSIC.setNombre("_");
		  					respuestaSinSIC.setPersona(datosIntegrantes.getIntegrantes()[i].getCliente());
		  					foliosRespuestaWS.add(respuestaSinSIC);
						} else {
							arrayTemp = this.cancelaChequesSIC(uid, Arrays.asList(datosIntegrantes.getIntegrantes()[i]), peticion.getOperador());
							LogHandler.debug(uid, this.getClass(), "Respuesta SIC [" + datosIntegrantes.getIntegrantes()[i] + "] " + arrayTemp);
							if(arrayTemp != null) {
								arrayTemp.get(0).setCancelacionCheque(true);
								foliosRespuestaWS.add(arrayTemp.get(0));
							} else {
								FoliosChequesSIC respuestaNullSIC = new FoliosChequesSIC();
								respuestaNullSIC.setFolioCheque(Long.parseLong(datosIntegrantes.getIntegrantes()[i].getFolioCheque()));
								respuestaNullSIC.setNombre("_");
								respuestaNullSIC.setPersona(datosIntegrantes.getIntegrantes()[i].getCliente());
								respuestaNullSIC.setCancelacionCheque(true);
								foliosRespuestaWS.add(respuestaNullSIC);
							}
						}
						
					} catch (Exception e) {
						LogHandler.error(uid, this.getClass(), " Hubo un problema con el WS ChequesSIC: " + e.getCause(), e);
						List<FoliosChequesSIC> foliosRespuestaError = new ArrayList<FoliosChequesSIC>();
						LogHandler.debug(uid, this.getClass(), "Datos Integrante SIC[E] [" + datosIntegrantes.getIntegrantes()[i] + "] ");
						FoliosChequesSIC respError = new FoliosChequesSIC();
						respError.setComentario("[SIC] Error " + e.getMessage());
						respError.setFolioCheque(Long.parseLong(datosIntegrantes.getIntegrantes()[i].getFolioCheque()));
						respError.setCancelacionCheque(true);
						respError.setMontoCheque("0");
						respError.setNombre("_");
						respError.setPersona(datosIntegrantes.getIntegrantes()[i].getCliente());
						foliosRespuestaError.add(respError);
					}
  				}
  				respuesta.setResultadoSIC(foliosRespuestaWS);
  			}
  			
  		}
		return respuesta;
	}


	/**
	 * @param peticion de ajuste de saldo a favor
	 * @param uid identificador unico de la transaccion
	 * @return AjusteSaldoAFavorRespuesta resultado del ajuste de saldo a favor
	 */
	@SuppressWarnings("unchecked")
	public AjusteSaldoAFavorRespuesta transferirSaldoAFavor(AjusteSaldoAFavorPeticion peticion, String uid)
		{
		//Se crea el objecto de respuesta
		final 	AjusteSaldoAFavorRespuesta
				ajusteSaldoAFavorRespuesta = new AjusteSaldoAFavorRespuesta();
				ajusteSaldoAFavorRespuesta.setEncabezadoRespuesta( new EncabezadoRespuesta() );

		final String contratoLD = peticion.getContratoOrigen();
		final String contratoLDDestino = peticion.getContratoDestino();

		//Objeto para la conexion a BD, para consultas y validaciones
	    SqlSession sessionNTx = null;

	    //Objeto para la conexion a BD, para operaciones transaccionales
	    SqlSession sessionTx = null;

		try {
			//Validacion de contrato valido
			if ( peticion == null || peticion.getContratoOrigen() == null || peticion.getContratoDestino() == null ) {
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.datos.incompletos" ) );
		    	}

			//Se abre la conexion de bd
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			//Se convierten los contratos LD a credprod
			peticion.setContratoOrigen( comun.obtenerNumeroContrato(uid, peticion.getContratoOrigen() ) );
			peticion.setContratoDestino( comun.obtenerNumeroContrato(uid, peticion.getContratoDestino() ) );

			//Validacion de contrato valido
			if ( peticion.getContratoOrigen() == null || peticion.getContratoDestino() == null ) {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.transferirsaldoafavor.error.contratosinvalidos" ) );
		    	}

			//Se verifica el contrato origen
			LogHandler.trace(uid, this.getClass(), "==> transferirSaldoAFavor - verificarContratoOrigen");
			final java.util.HashMap<String, Object>	resultOrigen =
					(HashMap<String, Object>) sessionNTx.selectOne( "verificarContratoOrigen" , peticion.getContratoOrigen() );

			if ( resultOrigen == null ) {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.transferirsaldoafavor.error.contratoorigen" ) );
			}
			java.math.BigDecimal 	contratoOrigen = (BigDecimal) resultOrigen.get( "capital" );
			final java.lang.Integer sucursalOrigen = (Integer) resultOrigen.get( "sucursal" );


			//Se recupera el valor de MSAF
			final HashMap<String, Object> paramsVarHist = new HashMap<String, Object>();
			paramsVarHist.put("sucursal", sucursalOrigen );
			paramsVarHist.put("codigo"	, "MSAF" );
			paramsVarHist.put("fecha"	, new Date() );

			LogHandler.trace(uid, getClass(), "==> transferirSaldoAFavor - verValorHistorico " );
			final java.lang.Double msaf = Double.valueOf( sessionNTx.selectOne("verValorHistorico", paramsVarHist) + "" );

			if ( contratoOrigen == null || contratoOrigen.doubleValue() >= 0  || contratoOrigen.doubleValue() * -1.0 < msaf ) {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.transferirsaldoafavor.error.contratoorigen.msaf" ) );
			}

			//Se validan los montos a transferir
			if (peticion.getMontoTransferir() == null || peticion.getMontoTransferir() == 0) {
				throw new Exception(ReadProperties.mensajes.getProp(
						"administracion.transferirsaldoafavor.error.montotransferirinvalido"));
			}

			LogHandler.info(uid, getClass(), "Monto a transferir ( peticion ) : " + peticion.getMontoTransferir() );
			LogHandler.info(uid, getClass(), "Monto a transferir ( bd ) : " + contratoOrigen.doubleValue() );

			if (Math.abs( peticion.getMontoTransferir()) > Math.abs(contratoOrigen.doubleValue())) {
				throw new Exception(ReadProperties.mensajes.getProp(
						"administracion.transferirsaldoafavor.error.montotransferir"));
			}

			//Se asigna el monto que se va a transferir en la operacion
			contratoOrigen = new BigDecimal(peticion.getMontoTransferir() * -1 );

			//Se verifica el contrato destino
			LogHandler.trace(uid, this.getClass(), "==> transferirSaldoAFavor - verificarContratoDestino");
			final java.util.HashMap<String, Object> resultDestino =
					(HashMap<String, Object>) sessionNTx.selectOne( "verificarContratoDestino" , peticion.getContratoDestino() );
			if ( resultDestino == null  ) {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.transferirsaldoafavor.error.contratodestino" ) );
			}

			//Se recupera el codigo_servicio del ultimo pago de saldo a favor del contrato origen
			LogHandler.trace(uid, getClass(), "==> transferirSaldoAFavor - obtenerCodigoServicioSaldoFavor");
			final java.lang.String codigoServicio = (String)
					sessionNTx.selectOne( "obtenerCodigoServicioSaldoFavor" , peticion.getContratoOrigen() );

			if ( codigoServicio == null || codigoServicio.trim().equals( "" ) ) {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.transferirsaldoafavor.errormovimientosorigen" ) );
			}

			//Fecha contable
			java.util.Date fechaContable = comun.obtenerFechaContable( uid ).getFecha();

			//Id Transaccion Total
			final Integer idTransaccion = comun.obtenerIdTransaccion(uid, sucursalOrigen, fechaContable ); /*Poner la sucursal*/

			//Se abre la caja para la sucursal del credito origen
			final ResultadoOV aperturaCajaOrigen = comun.aperturaCaja(uid, sucursalOrigen, fechaContable );
			if ( aperturaCajaOrigen.getCodigoRetorno() < 0 ) {
				throw new Exception( ReadProperties.mensajes.getProp("ciof.error.cajavirtual") );
			}

			//Se abre la conexion transaccional
				sessionTx = FabricaConexiones.obtenerSesionTx();

				final HashMap<String, Object>
				paramsCaja = new HashMap<String, Object>();
				paramsCaja.put(SUCURSAL		 , sucursalOrigen );
				paramsCaja.put(FECHA_CONTABLE, FORMATTER.format( fechaContable ) );
				paramsCaja.put(MONTO		 , contratoOrigen.doubleValue() );

				LogHandler.trace(uid, getClass(), "==> transferirSaldoAFavor - registraCajaInventario");
				sessionTx.selectOne( "registraCajaInventario", paramsCaja );

				final HashMap<String, Object>
				paramsInventario = new HashMap<String, Object>();
				paramsInventario.put( "codigo"		 	, "DEVS" );
				paramsInventario.put( "contrato"		, peticion.getContratoOrigen() );
				paramsInventario.put( "sucursal"	 	, sucursalOrigen );
				paramsInventario.put( "usuario"			, ConstantesPagos.USUARIO_PAGO.getValue() );
				paramsInventario.put( "fechaContable"	, FORMATTER.format( fechaContable ) );
				paramsInventario.put( "monto"			, contratoOrigen.doubleValue() );
				paramsInventario.put( "idTrxCaja"		, idTransaccion );
				paramsInventario.put( "fechaActual"		, FORMATTER.format( fechaContable ) );
				paramsInventario.put( "medioRecepcion"	, ConstantesPagos.MEDIO_RECEPCION_FSOL.getValue() );

				paramsInventario.put( "clave"			,
						Integer.valueOf( DataMapper.mapMedioPago.get( DataMapper.mapMedioPago.get("DEVS") ) ) );
				paramsInventario.put( "clave_produccion", DataMapper.mapMedioPago.get("DEVS") );

				/*paramsInventario.put( "clave"			, 0 );
				paramsInventario.put( "clave_produccion", "" );*/

				paramsInventario.put( "referencia1"		, ConstantesPagos.BONIFICACION_REFERENCIA1.getValue() );
				paramsInventario.put( "referencia2"		, ConstantesPagos.BONIFICACION_REFERENCIA2.getValue() );
				paramsInventario.put( "referencia3"		, "");

				LogHandler.trace(uid, this.getClass(), "==> transferirSaldoAFavor - registraOperacionCaja");
				sessionTx.selectOne( "registraOperacionCaja", paramsInventario );

				Date fechaHoraMovimientoDevs = Calendar.getInstance().getTime();
				final HashMap<String, Object>
				paramsSaldoFavor = new HashMap<String, Object>();
				paramsSaldoFavor.put( "contrato"	 , peticion.getContratoOrigen() );
				paramsSaldoFavor.put( "fechaHora"	 , fechaHoraMovimientoDevs );
				paramsSaldoFavor.put( "operador"	 , "123546789" );
				paramsSaldoFavor.put( "idTrxCaja" 	 , idTransaccion );
				paramsSaldoFavor.put( "sucursal" 	 , sucursalOrigen );
				paramsSaldoFavor.put( "fechaContable", FORMATTER.format(fechaContable) );
				paramsSaldoFavor.put( "saldoFavor"	 , contratoOrigen.doubleValue() * -1.0 );

				LogHandler.trace(uid, getClass(), "==> transferirSaldoFavor - saldoFavorContratoOrigen" );
				final java.util.HashMap<String, Object> resultsaldoFavor =
						(HashMap<String, Object>) sessionTx.selectOne( "saldoFavorContratoOrigen", paramsSaldoFavor );

				if ( resultsaldoFavor.get( "codigo" ).toString().equals( "-1" ) ) {
					throw new Exception( resultsaldoFavor.get( "mensaje" ).toString() );
				}

				//Referencia contrato origen DEVOLUCION SALDO A FAVOR => TRASPASO AL LDXXX
				final HashMap<String, Object> paramsSaldoFavorDescripcion = new HashMap<String, Object>();
				paramsSaldoFavorDescripcion.put( "contrato"	 , peticion.getContratoOrigen() );
				paramsSaldoFavorDescripcion.put( "fechaHora" , fechaHoraMovimientoDevs );
				paramsSaldoFavorDescripcion.put( "descripcion" , "TRASPASO AL " + contratoLDDestino );

				LogHandler.trace(uid, getClass(), "==> transferirSaldoFavor - updateReferenciaDEVS" );
				sessionTx.update( "updateReferenciaDEVS", paramsSaldoFavorDescripcion );

				//Pago Contrato Destino
				PagoGrupalResponse pagoDestinoRespuesta = new PagoGrupalResponse();

				final PagoGrupal pagoDestinoPeticion = new PagoGrupal();
				pagoDestinoPeticion.setMonto( contratoOrigen.doubleValue() * -1 );
				pagoDestinoPeticion.setNumeroContrato( peticion.getContratoDestino() );
				final SimpleDateFormat formatSimple = new SimpleDateFormat("yyyy-MM-dd");
				fechaContable = formatSimple.parse( fechaContable.toString());
				LogHandler.trace(uid, getClass(), "==> transferirSaldoFavor - obtenFechaValorContratoOrigen" );
				pagoDestinoPeticion.setFechaValor(
						(java.util.Date) sessionTx.selectOne("obtenFechaValorContratoOrigen", peticion.getContratoOrigen()) );
				pagoDestinoPeticion.setMedioPago( DataMapper.mapMedioPago.get( codigoServicio ) );
				//codigo_servicio del contrato con saldo a favor
				//final DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
				pagoDestinoPeticion.setReferencia( "TRASPASO DEL " + contratoLD );
				pagoDestinoPeticion.setTipoPago( ConstantesPagos.TIPO_PAGO_NORMAL.getValue() );
				pagoDestinoPeticion.setUsuario( ConstantesPagos.USUARIO_PAGO.getValue() );
				pagoDestinoPeticion.setCodigo( "TRPG" ); //ConstantesPagos.PAGO_REFERENCIADO.getValue() );
				pagoDestinoPeticion.setSucursal(sucursalOrigen);

				LogHandler.debug(uid, getClass(), pagoDestinoPeticion.getFechaValor()  + "");

				pagoDestinoRespuesta = pagos.aplicarPagoGrupal(uid, null, idTransaccion, pagoDestinoPeticion);

				if ( !pagoDestinoRespuesta.getHeader().isEstatus()) {
					throw new Exception(pagoDestinoRespuesta.getHeader().getMensaje());
				}

				//Se realiza el commit
				LogHandler.info(uid, getClass(), "Se realiza el comit para el contrato : " + peticion.getContratoOrigen() );
				sessionTx.commit();

			ajusteSaldoAFavorRespuesta.getEncabezadoRespuesta().setUID(uid);
			ajusteSaldoAFavorRespuesta.getEncabezadoRespuesta().setMensaje(null);
			ajusteSaldoAFavorRespuesta.setIdTransaccion(idTransaccion);

			}
		catch ( java.lang.Exception exception ) {
			FabricaConexiones.rollBack( sessionTx );
			ajusteSaldoAFavorRespuesta.getEncabezadoRespuesta().setMensaje(exception.getMessage());
			ajusteSaldoAFavorRespuesta.getEncabezadoRespuesta().setEstatus(false);
			ajusteSaldoAFavorRespuesta.getEncabezadoRespuesta().setUID(uid);
			LogHandler.error(uid, getClass(), "Error ocurrido en la consulta : " + exception.getMessage(), exception);
			}
		finally {
			FabricaConexiones.close( sessionNTx );
			FabricaConexiones.close( sessionTx  );
			}

		//Se regresa el objeto respuesta
		return ajusteSaldoAFavorRespuesta;
		}



	/**
	 * @param peticion de eliminacion de saldo a favor
	 * @param uid identificador unico de la transaccion
	 * @return AjusteSaldoAFavorRespuesta resultado del eliminacion de saldo a favor
	 */
	@SuppressWarnings("unchecked")
	public EliminarSaldoAFavorRespuesta eliminarSaldoAFavor( EliminarSaldoAFavorPeticion peticion, String uid ) {
		//Se crea el objecto de respuesta
		final 	EliminarSaldoAFavorRespuesta
				eliminarSaldoAFavorRespuesta = new EliminarSaldoAFavorRespuesta();
				eliminarSaldoAFavorRespuesta.setEncabezadoRespuesta( new EncabezadoRespuesta() );

		//Objeto para la conexion a BD, para consultas y validaciones
	    SqlSession sessionNTx = null;

	    //Objeto para la conexion a BD, para operaciones transaccionales
	    SqlSession sessionTx = null;

		try {
			//Validacion de contrato valido
			if ( peticion == null || peticion.getContrato() == null ) {
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.datos.incompletos" ) );
		    	}

			//Se abre la conexion de bd
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			//Se convierten los contratos LD a credprod
			peticion.setContrato( comun.obtenerNumeroContrato(uid, peticion.getContrato() ) );

			//Validacion de contrato valido
			if ( peticion.getContrato() == null ) {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.transferirsaldoafavor.error.contratosinvalidos" ) );
		    }

			//Se verifica el contrato
			LogHandler.trace(uid, this.getClass(), "==> eliminarSaldoAFavor - verificarContratoOrigen");
			final java.util.HashMap<String, Object>	resultContratoValido = (HashMap<String, Object>)
					sessionNTx.selectOne( "verificarContratoOrigen" , peticion.getContrato() );

			if ( resultContratoValido == null ) {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.transferirsaldoafavor.error.contratoorigen" ) );
			}

			final java.math.BigDecimal 	saldoFavor = (BigDecimal) resultContratoValido.get( "capital" );
			final java.lang.Integer 	sucursal   = (Integer) resultContratoValido.get( "sucursal" );

			//Se recupera el valor de MSAF
			/*final HashMap<String, Object> paramsVarHist = new HashMap<String, Object>();
			paramsVarHist.put("sucursal", sucursal );
			paramsVarHist.put("codigo"	, "MSCF" );
			paramsVarHist.put("fecha"	, new Date() );

			LogHandler.trace(uid, getClass(), "==> eliminarSaldoAFavor - verValorHistorico " );
			final java.lang.Double mscf = Double.valueOf( sessionNTx.selectOne("verValorHistorico", paramsVarHist) + "");

			if( saldoFavor == null || saldoFavor.doubleValue() >= 0  || saldoFavor.doubleValue() * -1.0 < mscf )
				{
				throw new Exception( ReadProperties.mensajes.getProp(
				"administracion.transferirsaldoafavor.error.contratoorigen" ) );
				}*/

			//Fecha contable
			final java.util.Date fechaContable = comun.obtenerFechaContable( uid ).getFecha();

			//Id Transaccion
			final Integer idTransaccion = comun.obtenerIdTransaccion(uid, sucursal, fechaContable );

			//Fecha hora
			final java.util.Date fechaHora = Calendar.getInstance().getTime();

			//Devolucion del saldo a favor del contrato origen
			final HashMap<String, Object>
						paramsCaja = new HashMap<String, Object>();
						paramsCaja.put(SUCURSAL		 , sucursal );
						paramsCaja.put(FECHA_CONTABLE, FORMATTER.format( fechaContable ) );
						paramsCaja.put(MONTO		 , saldoFavor.doubleValue() );

			final HashMap<String, Object>
						paramsInventario = new HashMap<String, Object>();
						paramsInventario.put( "sucursal"	 	, sucursal );
						paramsInventario.put( "contrato"		, peticion.getContrato() );
						paramsInventario.put( "fechaContable"	, FORMATTER.format( fechaContable ) );
						paramsInventario.put( "codigo"		 	, "DEVS" ); //"DVSX"
						paramsInventario.put( "medioRecepcion"	, ConstantesPagos.MEDIO_RECEPCION_FSOL.getValue() );
						paramsInventario.put( "fechaActual"		, FORMATTER.format( fechaContable ) );
						paramsInventario.put( "fechaValor"		, FORMATTER.format( fechaContable ) );
						paramsInventario.put( "idTrxCaja"		, idTransaccion );
						paramsInventario.put( "monto"			, saldoFavor.doubleValue() * -1 );
						paramsInventario.put( "usuario"			, ConstantesPagos.USUARIO_PAGO.getValue() );
						paramsInventario.put( "clave"			, 0 );
						paramsInventario.put( "clave_produccion", "" );
						paramsInventario.put( "referencia1"		, ConstantesPagos.BONIFICACION_REFERENCIA1.getValue() );
						paramsInventario.put( "referencia2"		, ConstantesPagos.BONIFICACION_REFERENCIA2.getValue() );
						paramsInventario.put( "referencia3"		, "");
						paramsInventario.put( "codigoServicio"	, " "	);
						paramsInventario.put( "descripcionPago"	, "SaldoAFavor"	);

			final HashMap<String, Object>
						paramsSaldoFavor = new HashMap<String, Object>();
						paramsSaldoFavor.put( "contrato"	 , peticion.getContrato() );
						paramsSaldoFavor.put( "fechaHora"	 , fechaHora );
						paramsSaldoFavor.put( "operador"	 , "000000043" );
						paramsSaldoFavor.put( "idTrxCaja" 	 , idTransaccion );
						paramsSaldoFavor.put( "sucursal" 	 , sucursal );
						paramsSaldoFavor.put( "fechaContable", FORMATTER.format(fechaContable) );
						paramsSaldoFavor.put( "saldoFavor"	 , saldoFavor.doubleValue() * -1.0 );

			//Se abre la caja para la sucursal del credito
			final ResultadoOV aperturaCajaOrigen = comun.aperturaCaja(uid, sucursal, fechaContable );
			if ( aperturaCajaOrigen.getCodigoRetorno() < 0 ) {
				throw new Exception( ReadProperties.mensajes.getProp("ciof.error.cajavirtual") );
			}

			//Seccion transaccional
				//Se abre la conexion transaccional
				sessionTx = FabricaConexiones.obtenerSesionTx();

				LogHandler.trace(uid, getClass(), "==> eliminarSaldoAFavor - registraCajaInventario");
				sessionTx.selectOne( "registraCajaInventario", paramsCaja );

				LogHandler.trace(uid, this.getClass(), "==> eliminarSaldoAFavor - registraOperacionCaja");
				sessionTx.selectOne( "registraOperacionCaja", paramsInventario );

				LogHandler.trace(uid, this.getClass(), "==> eliminarSaldoAFavor - calculaParcialidad");
				sessionTx.selectOne( "calculaParcialidad", paramsInventario );

				//Ejecucion de stores de saldo a favor
				LogHandler.trace(uid, getClass(), "==> eliminarSaldoAFavor - saldoFavorContratoOrigen" );
				final java.util.HashMap<String, Object>	resultsaldoFavor =
						(HashMap<String, Object>) sessionTx.selectOne( "saldoFavorContratoOrigen", paramsSaldoFavor );

				if ( resultsaldoFavor.get( "codigo" ).toString().equals( "-1" ) ) {
					throw new Exception( resultsaldoFavor.get( "mensaje" ).toString() );
					}

				//Se realiza el commit
				sessionTx.commit();

				//Datos para regresar
				final 	EliminarSaldoAFavorOV
						eliminarSaldoAFavorOV = new EliminarSaldoAFavorOV();
						eliminarSaldoAFavorOV.setFecha( fechaContable );
						eliminarSaldoAFavorOV.setIdTransaccion( idTransaccion );
						eliminarSaldoAFavorOV.setMonto( saldoFavor.doubleValue() * -1 );
				eliminarSaldoAFavorRespuesta.setEliminarSaldoAFavorOV( eliminarSaldoAFavorOV );
			}
		catch ( java.lang.Exception exception ) {
			FabricaConexiones.rollBack( sessionTx );
			eliminarSaldoAFavorRespuesta.getEncabezadoRespuesta().setMensaje(exception.getMessage());
			eliminarSaldoAFavorRespuesta.getEncabezadoRespuesta().setEstatus(false);
			eliminarSaldoAFavorRespuesta.getEncabezadoRespuesta().setUID(uid);
			LogHandler.error(uid, getClass(), "Error ocurrido en la operacion : " + exception.getMessage(), exception);
			}
		finally {
			FabricaConexiones.close( sessionNTx );
			FabricaConexiones.close( sessionTx  );
			}

		//Se regresa el objeto respuesta
		return eliminarSaldoAFavorRespuesta;
		}

	/**
	 * @param peticion de revertir de saldo a favor
	 * @param uid identificador unico de la transaccion
	 * @return RevertirSaldoAFavorRespuesta resultado del revertir de saldo a favor
	 */
	@SuppressWarnings("unchecked")
	public RevertirSaldoAFavorRespuesta revertirSaldoAFavor(RevertirSaldoAFavorPeticion peticion, String uid)
		{
		//Se crea el objecto de respuesta
		final 	RevertirSaldoAFavorRespuesta
				revertirSaldoAFavorRespuesta = new RevertirSaldoAFavorRespuesta();
				revertirSaldoAFavorRespuesta.setEncabezadoRespuesta( new EncabezadoRespuesta() );

		//Objeto para la conexion a BD, para consultas y validaciones
	    SqlSession sessionNTx = null;

	    //Objeto para la conexion a BD, para operaciones transaccionales
	    SqlSession sessionTx = null;

		try {
			//Validacion de contrato valido
			if ( peticion == null || peticion.getContrato() == null ) {
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.datos.incompletos" ) );
		    	}

			//Se abre la conexion de bd
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			//Se convierten los contratos LD a credprod
			peticion.setContrato( comun.obtenerNumeroContrato(uid, peticion.getContrato() ) );

			//Validacion de contrato valido
			if ( peticion.getContrato() == null ) {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.transferirsaldoafavor.error.contratosinvalidos" ) );
		    	}

			//Se recuperan los datos del contrato
			final HashMap<String, Object> datosCredito = comun.obtenerDatosGeneralesContrato(uid, peticion.getContrato());

			//Sucursal del contrato
			final java.lang.Integer sucursal = Integer.parseInt( "" + datosCredito.get( "sucursal" ) );

			//Fecha contable
			final java.util.Date fechaContable = comun.obtenerFechaContable( uid ).getFecha();

			//Devolucion del saldo a favor del contrato origen
			final HashMap<String, Object>
						paramsCaja = new HashMap<String, Object>();
						paramsCaja.put(SUCURSAL		 , sucursal );
						paramsCaja.put(FECHA_CONTABLE, FORMATTER.format( fechaContable ) );
						paramsCaja.put(MONTO		 , peticion.getMonto() * -1 );

			final HashMap<String, Object>
						paramsInventario = new HashMap<String, Object>();
						paramsInventario.put( "sucursal"	 	, sucursal );
						paramsInventario.put( "contrato"		, peticion.getContrato() );
						paramsInventario.put( "fechaContable"	, FORMATTER.format( fechaContable ) );
						paramsInventario.put( "codigo"		 	, "DVSX" ); //"DVSX"
						paramsInventario.put( "medioRecepcion"	, ConstantesPagos.MEDIO_RECEPCION_FSOL.getValue() );
						paramsInventario.put( "fechaActual"		, FORMATTER.format( fechaContable ) );
						paramsInventario.put( "fechaValor"		, FORMATTER.format( fechaContable ) );
						paramsInventario.put( "idTrxCaja"		, peticion.getIdTransaccion() );
						paramsInventario.put( "monto"			, peticion.getMonto() * -1 );
						paramsInventario.put( "usuario"			, peticion.getOperador() );
						paramsInventario.put( "clave"			, 0 );
						paramsInventario.put( "clave_produccion", "" );
						paramsInventario.put( "referencia1"		, ConstantesPagos.BONIFICACION_REFERENCIA1.getValue() );
						paramsInventario.put( "referencia2"		, ConstantesPagos.BONIFICACION_REFERENCIA2.getValue() );
						paramsInventario.put( "referencia3"		, "");
						paramsInventario.put( "codigoServicio"	, " "	);
						paramsInventario.put( "descripcionPago"	, "SaldoAFavor"	);

			final HashMap<String, Object>
						paramsSaldoFavor = new HashMap<String, Object>();
						paramsSaldoFavor.put( "contrato"	 , peticion.getContrato() );
						paramsSaldoFavor.put( "fechaHora"	 , Calendar.getInstance().getTime() );
						paramsSaldoFavor.put( "operador"	 , peticion.getOperador() );
						paramsSaldoFavor.put( "caja" 	 	 , 0 );
						paramsSaldoFavor.put( "idTrxCaja" 	 , peticion.getIdTransaccion() );
						paramsSaldoFavor.put( "sucursal" 	 , sucursal );
						paramsSaldoFavor.put( "fechaContable", FORMATTER.format( peticion.getFecha() ) );
						paramsSaldoFavor.put( "monto"	 	 , peticion.getMonto() );

			//Se abre la caja para la sucursal del credito
			final ResultadoOV aperturaCajaOrigen = comun.aperturaCaja(uid, sucursal, fechaContable );
			if ( aperturaCajaOrigen.getCodigoRetorno() < 0 ) {
				throw new Exception( ReadProperties.mensajes.getProp("ciof.error.cajavirtual") );
				}

				//Se abre la conexion transaccional
				sessionTx = FabricaConexiones.obtenerSesionTx();

				LogHandler.trace(uid, getClass(), "==> revertirSaldoAFavor - registraCajaInventario");
				sessionTx.selectOne( "registraCajaInventario", paramsCaja );

				LogHandler.trace(uid, this.getClass(), "==> revertirSaldoAFavor - registraOperacionCaja");
				sessionTx.selectOne( "registraOperacionCaja", paramsInventario );

				//Ejecucion de stores de saldo a favor
				LogHandler.trace(uid, getClass(), "==> revertirSaldoAFavor - saldoFavorContratoOrigen" );
				final java.util.HashMap<String, Object> resultsaldoFavor = (HashMap<String, Object>)
						sessionTx.selectOne( "cancelaSaldoAFavor", paramsSaldoFavor );

				if ( resultsaldoFavor.get( "codigo" ).toString().equals( "-1" ) ) {
					throw new Exception( resultsaldoFavor.get( "mensaje" ).toString() );
					}

				//Se realiza el commit
				sessionTx.commit();
			}
		catch ( java.lang.Exception exception ) {
			FabricaConexiones.rollBack( sessionTx );
			revertirSaldoAFavorRespuesta.getEncabezadoRespuesta().setMensaje(exception.getMessage());
			revertirSaldoAFavorRespuesta.getEncabezadoRespuesta().setEstatus(false);
			revertirSaldoAFavorRespuesta.getEncabezadoRespuesta().setUID(uid);
			LogHandler.error(uid, getClass(), "Error ocurrido en la operacion : " + exception.getMessage(), exception);
			}
		finally {
			FabricaConexiones.close( sessionNTx );
			FabricaConexiones.close( sessionTx  );
			}

		//Se regresa el objeto respuesta
		return revertirSaldoAFavorRespuesta;
		}


	/**
	 * @param peticion de reasignacion de cartera
	 * @param uid identificador unico de la transaccion
	 * @return ReasignarCarteraRespuesta resultado de reasignacion de cartera
	 */
	@SuppressWarnings("unchecked")
	public ReasignarCarteraRespuesta reasignarCartera(ReasignarCarteraPeticion peticion, String uid)
		{
		//Se crea el objecto de respuesta
		final 	ReasignarCarteraRespuesta
				reasignarCarteraRespuesta = new ReasignarCarteraRespuesta();

		//Objeto para la conexion a BD, para consultas y validaciones
	    SqlSession sessionTx = null;

	    SqlSession sessionNTx = null;

	    try {
			//Validacion de contrato valido
			if ( peticion == null || peticion.getCveRedOperativaNvo() == null
				|| peticion.getUsuario() == null || peticion.getContratos() == null
				|| peticion.getContratos().size() == 0 || peticion.getFolioSolicitud() == null ) {
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.datos.incompletos" ) );
		    	}

			//Fecha comun de resolucion
			final java.lang.String	fechaResolucion
			 = (new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSS" )).format( comun.obtenerFechaActual( uid ) );

			//Se procesa cada reasignacion
			for ( ReasignarCarteraOV reasignarCarteraOV : peticion.getContratos() ) {
				//Objeto para detalle de procesa de cada reasignacion
				final ReasignarCarteraReporteOV
						reasignarCarteraReporteOV = new ReasignarCarteraReporteOV();
						reasignarCarteraReporteOV.setContrato( reasignarCarteraOV.getContrato() );
						reasignarCarteraReporteOV.setMotivoReasignacion( reasignarCarteraOV.getMotivoReasignacion() );

				//Se obtiene la clave credprod del contrato
				reasignarCarteraOV.setContrato( comun.obtenerNumeroContrato(uid, reasignarCarteraOV.getContrato()) );

				final java.util.HashMap<String, String>
										paramsReasignacion = new HashMap<String, String>();
										paramsReasignacion.put( "cveRedOperativa", peticion.getCveRedOperativaNvo() );
										paramsReasignacion.put( "usuario" 		 , peticion.getUsuario() );
										paramsReasignacion.put( "contrato" 		 , reasignarCarteraOV.getContrato() );
										paramsReasignacion.put( "motivo" 		 , reasignarCarteraOV.getMotivoReasignacion() );

				//Se procesa cada reasignacion
				try	{
					final HashMap<String, Object> datosCredito
					    = comun.obtenerDatosGeneralesContrato( uid, reasignarCarteraOV.getContrato() );

					if ( peticion.getCveRedOperativaNvo().trim().equals( datosCredito.get( "vendedor" ).toString().trim() ) ) {
						     throw new Exception( ReadProperties.mensajes.getProp(
						    		 "administracion.reasignarcartera.error.mismoasesor" ) );
						}

					//Se abre la conexion de bd
					sessionTx = FabricaConexiones.obtenerSesionTx();
					sessionNTx = FabricaConexiones.obtenerSesionNTx();

					final java.text.SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );

					final HashMap<String, Object>
								parametrosSaldos = new HashMap<String, Object>();
								parametrosSaldos.put( "contrato" , reasignarCarteraOV.getContrato() );
								parametrosSaldos.put( "fechaActual", simpleDateFormat.format(
												comun.obtenerFechaContable( uid ).getFecha() ) );

					LogHandler.trace(uid, getClass(), "==> reasignarCartera - obtenerSaldoV" );
					final HashMap<String, Object> saldos = (HashMap<String, Object>)
							sessionNTx.selectOne( "obtenerSaldoV", parametrosSaldos);

					//Obtener numero de reasignaciones del contrato
					LogHandler.trace(uid, getClass(), "==> reasignarCartera - cuentaReasignaciones" );
					final java.lang.Integer reasignaciones = (Integer)
							sessionNTx.selectOne( "cuentaReasignaciones", reasignarCarteraOV.getContrato() );
					final ConsultaCreditoPeticion
								consultaCreditoPeticion = new ConsultaCreditoPeticion();
								consultaCreditoPeticion.setContrato( reasignarCarteraOV.getContrato() );
								consultaCreditoPeticion.setSucursal( null );

					//Se recupera la fecha de la solicitud
					parametrosSaldos.put( "folioSolicitud", peticion.getFolioSolicitud() );
					LogHandler.trace(uid, getClass(), "==> reasignarCartera - obtenerDatosSolicitudReasignacion" );
					final HashMap<String, Object>datosSolicitud = (HashMap<String, Object>)
							sessionNTx.selectOne( "obtenerDatosSolicitudReasignacion", parametrosSaldos);

					//Registrar reasignacion
					final java.util.HashMap<String, Object>
								parametrosRegistraReasignacion = new HashMap<String, Object>();
								parametrosRegistraReasignacion.put( "contrato" 		   , reasignarCarteraOV.getContrato() );
								parametrosRegistraReasignacion.put( "folioReasignacion", reasignaciones.intValue() + 1 );
								parametrosRegistraReasignacion.put( "folioSolicitud"   , peticion.getFolioSolicitud() );
								parametrosRegistraReasignacion.put( "fechaSolicitud"   ,
										( new SimpleDateFormat( "yyyy-MM-dd" ) ).format(
												datosSolicitud.get( "fechaSolicitud" ) ) );
								parametrosRegistraReasignacion.put( "usuarioSolicitud" , peticion.getUsuario() );
								parametrosRegistraReasignacion.put( "cveRedAnterior"   ,
										datosCredito.get( "vendedor" ).toString()  );
								parametrosRegistraReasignacion.put( "tipoReasigna"	   , "ASES" );
								parametrosRegistraReasignacion.put( "fechaReasigna"	   , fechaResolucion );
								parametrosRegistraReasignacion.put( "usuario"		   , peticion.getUsuario() );
								parametrosRegistraReasignacion.put( "tipoCambio"	   , "CAMB"  );
								parametrosRegistraReasignacion.put( "motivoReasigna"   ,
										reasignarCarteraOV.getMotivoReasignacion()  );
								parametrosRegistraReasignacion.put( "cveRedAnterior"   ,
										datosCredito.get( "vendedor" ).toString()  );
								parametrosRegistraReasignacion.put( "cveRedNueva"	   , peticion.getCveRedOperativaNvo() );
								parametrosRegistraReasignacion.put( "sucursalAnterior" ,
										Integer.valueOf( datosCredito.get( "sucursal" ).toString() ) );
								parametrosRegistraReasignacion.put( "sucursalNueva"	   , peticion.getSucursalNueva() );
								parametrosRegistraReasignacion.put( "diasVencidos"	   ,
										consultas.obtenerDatosCredito( uid,
																consultaCreditoPeticion ).getDatosCredito().getDiasMora() );
								parametrosRegistraReasignacion.put( "saldoCapital"	   ,
										Double.valueOf( datosCredito.get( "saldo_capital" ).toString() ) );
								parametrosRegistraReasignacion.put( "saldoTotal"	   ,
										Double.valueOf( saldos.get( "Saldo total" ).toString() ) );
								parametrosRegistraReasignacion.put( "ivaSaldoTotal"	   ,
										Double.valueOf( saldos.get( "Iva Saldo Total" ).toString() ) );
								parametrosRegistraReasignacion.put( "saldoVencido"	   ,
										Double.valueOf( saldos.get( "Interes Vencido" ).toString() )
										+ Double.valueOf( saldos.get( "Capital Vencido" ).toString() )
										+ Double.valueOf( saldos.get( "Moratorio" ).toString() ));
								// Es in iva, capital vencido, interes vencido, moratorio
								parametrosRegistraReasignacion.put( "ivaSaldoVencido"  ,
										Double.valueOf( saldos.get( "Iva Interes Vencido" ).toString() )
										+ Double.valueOf( saldos.get( "Iva Moratorio" ).toString() ));
								// iva_interes_vencido y iva_moratorio

					LogHandler.trace(uid, getClass(), "==> reasignarCartera - insertarRegistroReasignacion" );
					sessionTx.insert( "insertarRegistroReasignacion", parametrosRegistraReasignacion );


					//Se actualiza el vendedor en contratos
					final java.util.HashMap<String, Object>
								parametrosActualizaVendedor = new HashMap<String, Object>();
								parametrosActualizaVendedor.put( "contrato" , reasignarCarteraOV.getContrato() );
								parametrosActualizaVendedor.put( "vendedor" , peticion.getCveRedOperativaNvo() );

					LogHandler.trace(uid, getClass(), "==> reasignarCartera - actualizarVendedor" );
					sessionTx.update( "actualizarVendedor", parametrosActualizaVendedor );

					//Se actualiza el vendedor en contratos
					final java.util.HashMap<String, Object>
								parametrosActualizaAsesor = new HashMap<String, Object>();
								parametrosActualizaAsesor.put( "contrato" , reasignarCarteraOV.getContrato() );
								parametrosActualizaAsesor.put( "asesor" , peticion.getCveRedOperativaNvo() );

					LogHandler.trace(uid, getClass(), "==> reasignarCartera - actualizarAsesorContrato" );
					sessionTx.update( "actualizarAsesorContrato", parametrosActualizaAsesor );

					//Se verifica si hubo cambio de sucursal
					if ( Integer.valueOf( datosCredito.get( "sucursal" ).toString() ).intValue()
							!= peticion.getSucursalNueva().intValue() ) {
						final java.util.HashMap<String, Object>
								parametrosCambioSucursal = new HashMap<String, Object>();
								parametrosCambioSucursal.put( "contrato" , reasignarCarteraOV.getContrato() );
								parametrosCambioSucursal.put( "sucursalNueva" , peticion.getSucursalNueva() );

						LogHandler.trace(uid, getClass(), "==> reasignarCartera - reasignarSucursal" );
						final java.util.HashMap<String, Object>	resultadoReasignaSucursal
						  = (HashMap<String, Object>) sessionTx.selectOne( "reasignarSucursal",  parametrosCambioSucursal );

						//Se valida el estatus de la operaci�n
						if ( resultadoReasignaSucursal == null || resultadoReasignaSucursal.get( "resultado" ) == null
								|| !resultadoReasignaSucursal.get( "resultado" ).toString().trim().equals( "0" ) ) {
							throw new Exception( resultadoReasignaSucursal.get( "mensaje" ).toString() );
							}
						}

					//Actualizacion de la solicitud
					final ActualizarSolicitudReasignarCarteraPeticion	actualizarSolicitudReasignarCarteraPeticion
					= new ActualizarSolicitudReasignarCarteraPeticion();
					actualizarSolicitudReasignarCarteraPeticion.setFolioSolicitud( peticion.getFolioSolicitud() );
					actualizarSolicitudReasignarCarteraPeticion.setFechaReenvio( null );
					actualizarSolicitudReasignarCarteraPeticion.setFechaResolucion(
							( new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss.SSS" ) ).parse( fechaResolucion ) );
					actualizarSolicitudReasignarCarteraPeticion.setNumeroPersonaSolicitud( peticion.getUsuario() );
					actualizarSolicitudReasignarCarteraPeticion.setObservaciones( "Se registro la reasignacion." );
					actualizarSolicitudReasignarCarteraPeticion.setStatus( "A" );
					actualizarSolicitudReasignarCarteraPeticion.setSucursal( peticion.getSucursalNueva() );

					LogHandler.trace( uid, getClass(), "==> reasignarCartera - actualizarSolicitudReasignarCartera" );
					sessionTx.update( "actualizarSolicitudReasignarCartera", actualizarSolicitudReasignarCarteraPeticion );

					//Se realiza el commit
					sessionTx.commit( true );

					//Se indica que se reasign� exitosamente
					reasignarCarteraReporteOV.setStatus( "Reasignacion exitosa." );
					reasignarCarteraReporteOV.setCodigo( 0 );
					}
				catch ( java.lang.Exception exception ) {
					if ( sessionTx != null )	{
						FabricaConexiones.rollBack( sessionTx );
					}
					reasignarCarteraReporteOV.setCodigo( -1 );
					reasignarCarteraReporteOV.setStatus( exception.getMessage() );
					reasignarCarteraRespuesta.getHeader().setEstatus( false );
					reasignarCarteraRespuesta.getHeader().setMensaje( exception.getMessage() );
					reasignarCarteraRespuesta.getHeader().setUID( uid );
					LogHandler.error(uid, getClass(), "Error ocurrido en la operacion : " + exception.getMessage(), exception);
					}

				reasignarCarteraRespuesta.getReporteReasignados().add( reasignarCarteraReporteOV );
				}
			}
		catch ( java.lang.Exception exception ) {
			reasignarCarteraRespuesta.getHeader().setMensaje(exception.getMessage());
			reasignarCarteraRespuesta.getHeader().setEstatus(false);
			reasignarCarteraRespuesta.getHeader().setUID(uid);
			LogHandler.error(uid, getClass(), "Error ocurrido en la operacion : " + exception.getMessage(), exception);
			}
		finally {
			FabricaConexiones.close( sessionTx );
			FabricaConexiones.close( sessionNTx );
			}

		//Se regresa el objeto respuesta
		return reasignarCarteraRespuesta;
		}

	/**
	 * @param peticion de ajuste de dia de reunion
	 * @param uid identificador unico de la transaccion
	 * @return AjusteDiaReunionRespuesta resultado de ajuste de dia de reunion
	 */
	public AjusteDiaReunionRespuesta ajustarDiaReunion(
			AjusteDiaReunionPeticion peticion, String uid) {

		AjusteDiaReunionRespuesta ajusteDiaReunionRespuesta = new AjusteDiaReunionRespuesta();
		SqlSession session = null;
		ajusteDiaReunionRespuesta.setHeader(new EncabezadoRespuesta());

		try {

			session = FabricaConexiones.obtenerSesionTx();
			if (peticion == null || peticion.getContrato().equals("")
					||	peticion.getContrato().isEmpty()
					|| ( peticion.getDiaReunion() == null && peticion.getHoraReunion() == null ) ) {
				throw new Exception( ReadProperties.mensajes.getProp("ciof.error.datos.incompletos") );
				}

			//Validacion del dia de reunion.
			if ( peticion.getDiaReunion() > Constantes.DIAS_SEMANA || peticion.getDiaReunion() < 1 ) {
				throw new Exception(ReadProperties.mensajes.getProp("ciof.error.fechaReunion"));
			}

			//Se convierten los contratos LD a credprod
			peticion.setContrato( comun.obtenerNumeroContrato(uid, peticion.getContrato() ) );

			//Validacion de contrato valido
			if ( peticion.getContrato() == null ) {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.transferirsaldoafavor.error.contratosinvalidos" ) );
		    }

			java.util.HashMap<String , Object> params = new java.util.HashMap<String , Object>();
			params.put("contrato", peticion.getContrato());
			params.put("diaReunion", peticion.getDiaReunion());
			params.put("horaReunion", peticion.getHoraReunion());

			LogHandler.trace(uid, getClass(), "==> ajustarDiaReunion - ajusteDiaReunion");
			session.update("ajusteDiaReunion", params);

			LogHandler.trace(uid, getClass(), "===>El cambio de dia de reunion ha sido exitoso");

			session.commit();
		} catch (Exception exception) {
			FabricaConexiones.rollBack( session );
			ajusteDiaReunionRespuesta.getHeader().setMensaje(exception.getMessage());
			ajusteDiaReunionRespuesta.getHeader().setEstatus(false);
			ajusteDiaReunionRespuesta.getHeader().setUID(uid);
			LogHandler.error(uid, getClass(), "Error ocurrido en la operacion : " + exception.getMessage(), exception);
		}
		finally {
			FabricaConexiones.close( session );
		}
		return ajusteDiaReunionRespuesta;
	}

	/**
	 * @param peticion de registro solicitud de reasignacion de cartera
	 * @param uid identificador unico de la transaccion
	 * @return RegistrarSolicitudReasignarCarteraRespuesta resultado de registro solicitud de reasignacion de cartera
	 */
	public RegistrarSolicitudReasignarCarteraRespuesta registrarSolicitudReasignarCartera(
			RegistrarSolicitudReasignarCarteraPeticion peticion, String uid) {
		//Se crea el objecto de respuesta
		final 	RegistrarSolicitudReasignarCarteraRespuesta
				registrarSolicitudReasignarCarteraRespuesta = new RegistrarSolicitudReasignarCarteraRespuesta();

		//Objeto para la conexion a BD, para consultas y validaciones
	    SqlSession sessionTx = null;

	    SqlSession sessionNTx = null;

	    try {
			//Validacion de contrato valido
			if ( peticion == null || peticion.getFechaEnvio() == null || peticion.getFolioSolicitud() == null
					||	peticion.getFolioSolicitud() == 0 || peticion.getFechaSolicitud() == null
					||	peticion.getNumeroPersonaSolicitud() == null ||	peticion.getSucursal() == 0 )
		    	{
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.datos.incompletos" ) );
		    	}

			//Se recupera una sesion no transaccional
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			//Se obtiene la clave credprod del contrato
			LogHandler.trace(uid, getClass(), "==> registrarSolicitudReasignarCartera - existeFolioSolucitudReasignacion");
			final java.lang.Integer	folioExiste = (Integer)
					sessionNTx.selectOne( "existeFolioSolucitudReasignacion" , peticion.getFolioSolicitud() );

			//Si el folio existe solo procedemos a actualizar
			if ( folioExiste == null || folioExiste.intValue() > 0 ) {
				//Se crea la peticion para la actualizacion
				final 	ActualizarSolicitudReasignarCarteraPeticion
						actualizarSolicitudReasignarCarteraPeticion = new ActualizarSolicitudReasignarCarteraPeticion();
						actualizarSolicitudReasignarCarteraPeticion.setFolioSolicitud( peticion.getFolioSolicitud() );
						actualizarSolicitudReasignarCarteraPeticion.setNumeroPersonaSolicitud( "" );
						actualizarSolicitudReasignarCarteraPeticion.setFechaResolucion( null );
						actualizarSolicitudReasignarCarteraPeticion.setStatus( "E" );
						actualizarSolicitudReasignarCarteraPeticion.setFechaReenvio( peticion.getFechaEnvio() );
						actualizarSolicitudReasignarCarteraPeticion.setObservaciones( peticion.getObservaciones() );

				//El folio existe por lo tanto solo se actualiza
				registrarSolicitudReasignarCarteraRespuesta.setHeader(
						actualizarSolicitudReasignarCartera(actualizarSolicitudReasignarCarteraPeticion, uid).getHeader() );
				}
			else {
				//transaccion
				sessionTx = FabricaConexiones.obtenerSesionTx();

				LogHandler.trace(uid, getClass(), "==> registrarSolicitudReasignarCartera - registrarSolicitudReasignarCartera");
				sessionTx.insert( "registrarSolicitudReasignarCartera", peticion );

				//Aplicaci�n del commit
				sessionTx.commit( true );
				}
			}
		catch ( java.lang.Exception exception ) {
			//Aplicamos el rollback
			FabricaConexiones.rollBack( sessionTx );

			registrarSolicitudReasignarCarteraRespuesta.getHeader().setMensaje(exception.getMessage());
			registrarSolicitudReasignarCarteraRespuesta.getHeader().setEstatus(false);
			registrarSolicitudReasignarCarteraRespuesta.getHeader().setUID(uid);
			LogHandler.error(uid, getClass(), "Error ocurrido en la operacion : " + exception.getMessage(), exception);
			}
		finally {
			FabricaConexiones.close( sessionTx );
			FabricaConexiones.close( sessionNTx );
			}

		//Se regresa el objeto respuesta
		return registrarSolicitudReasignarCarteraRespuesta;
		}


	/**
	 * @param peticion de actualizacion solicitud de reasignacion de cartera
	 * @param uid identificador unico de la transaccion
	 * @return ActualizarSolicitudReasignarCarteraRespuesta resultado de actualizacion solicitud de reasignacion de cartera
	 */
	public ActualizarSolicitudReasignarCarteraRespuesta actualizarSolicitudReasignarCartera(
			ActualizarSolicitudReasignarCarteraPeticion peticion, String uid) {
		//Se crea el objecto de respuesta
		final 	ActualizarSolicitudReasignarCarteraRespuesta
				actualizarSolicitudReasignarCarteraRespuesta = new ActualizarSolicitudReasignarCarteraRespuesta();

		//Objeto para la conexion a BD, para consultas y validaciones
	    SqlSession sessionTx = null;

	    SqlSession sessionNTx = null;

	    try {
			//Validacion de contrato valido
			if ( peticion == null || peticion.getFolioSolicitud() == null
				||	peticion.getNumeroPersonaSolicitud() == null || peticion.getFechaReenvio() == null
				&& peticion.getStatus().equals( "R" )) {
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.datos.incompletos" ) );
		    	}

			//Se recupera una sesion no transaccional
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			//Se obtiene la clave credprod del contrato
			LogHandler.trace(uid, getClass(), "==> registrarSolicitudReasignarCartera - existeFolioSolucitudReasignacion");
			final java.lang.Integer	folioExiste = (Integer)
					sessionNTx.selectOne( "existeFolioSolucitudReasignacion" , peticion.getFolioSolicitud() );

			//Si el folio existe solo procedemos a actualizar
			if ( folioExiste == null || folioExiste.intValue() > 0 ) {
				//Se colocan las fechas de acuerdo al status
				peticion.setFechaReenvio( peticion.getStatus().equals( "R" ) ? peticion.getFechaReenvio() : null );
				//peticion.setFechaResolucion( peticion.getFechaResolucion( ) : null );

				//El folio existe por lo tanto solo se actualiza
				sessionTx = FabricaConexiones.obtenerSesionTx();

				LogHandler.trace(uid, getClass(), "==> registrarSolicitudReasignarCartera - actualizarSolicitudReasignarCartera");
				sessionTx.update( "actualizarSolicitudReasignarCartera", peticion );

				//Aplicaci�n del commit
				sessionTx.commit( true );
				}
			else {
				//Objeto para el m�todo de registrar
				final RegistrarSolicitudReasignarCarteraPeticion
							registrarSolicitudReasignarCarteraPeticion = new RegistrarSolicitudReasignarCarteraPeticion();
							registrarSolicitudReasignarCarteraPeticion.setFechaEnvio( peticion.getFechaReenvio() );
							registrarSolicitudReasignarCarteraPeticion.setFechaSolicitud( comun.obtenerFechaActual( uid ) );
							registrarSolicitudReasignarCarteraPeticion.setFolioSolicitud( peticion.getFolioSolicitud() );
							registrarSolicitudReasignarCarteraPeticion.setNumeroPersonaSolicitud(
									peticion.getNumeroPersonaSolicitud() );
							registrarSolicitudReasignarCarteraPeticion.setObservaciones( peticion.getObservaciones() );
							registrarSolicitudReasignarCarteraPeticion.setSucursal( peticion.getSucursal() );

				//Se registra
				actualizarSolicitudReasignarCarteraRespuesta.setHeader(
						registrarSolicitudReasignarCartera(registrarSolicitudReasignarCarteraPeticion, uid).getHeader() );
				}
			}
		catch ( java.lang.Exception exception ) {
			//Aplicamos el rollback
			FabricaConexiones.rollBack( sessionTx );

			actualizarSolicitudReasignarCarteraRespuesta.getHeader().setMensaje(exception.getMessage());
			actualizarSolicitudReasignarCarteraRespuesta.getHeader().setEstatus(false);
			actualizarSolicitudReasignarCarteraRespuesta.getHeader().setUID(uid);
			LogHandler.error(uid, getClass(), "Error ocurrido en la operacion : " + exception.getMessage(), exception);
			}
		finally {
			FabricaConexiones.close( sessionTx );
			FabricaConexiones.close( sessionNTx );
			}

		//Se regresa el objeto respuesta
		return actualizarSolicitudReasignarCarteraRespuesta;
		}

	/**
	 * @param peticion de tranferir saldo a favor
	 * @param uid identificador unico de la transaccion
	 * @return TransferirSaldosAFavorCreditosVigentesRespuesta resultado de tranferir saldo a favor
	 */
	public TransferirSaldosAFavorCreditosVigentesRespuesta trasferirSaldosAFavorCreditosVigentes(
			TrasferirSaldosAFavorCreditosVigentesPeticion peticion, String uid)	{
		//Objeto para la respuesta
		final TransferirSaldosAFavorCreditosVigentesRespuesta
					transferirSaldosAFavorCreditosVigentesRespuesta = new TransferirSaldosAFavorCreditosVigentesRespuesta();

		//Se itera cada operaci�n
		for ( TransferirSaldoAFavorOV transferirSaldoAFavorOV : peticion.getContratosTransferir() ) {
			//Se arma la peticion
			final AjusteSaldoAFavorPeticion
						saldoAFavorPeticion = new AjusteSaldoAFavorPeticion();
						saldoAFavorPeticion.setContratoOrigen( transferirSaldoAFavorOV.getContratoOrigen() );
						saldoAFavorPeticion.setContratoDestino( transferirSaldoAFavorOV.getContratoDestino() );
						saldoAFavorPeticion.setMontoTransferir( transferirSaldoAFavorOV.getMontoTransferir() );

			final AjusteSaldoAFavorRespuesta
						ajusteSaldoAFavorRespuesta = transferirSaldoAFavor(saldoAFavorPeticion, uid);

			LogHandler.info(uid, getClass(), "Respuesta de la operacion : " + ajusteSaldoAFavorRespuesta );

			final AjusteSaldoAFavorMasivoRespuesta
						ajusteSaldoAFavorMasivoRespuesta = new AjusteSaldoAFavorMasivoRespuesta();
						ajusteSaldoAFavorMasivoRespuesta.setContratoDestino( transferirSaldoAFavorOV.getContratoDestino() );
						ajusteSaldoAFavorMasivoRespuesta.setContratoOrigen( transferirSaldoAFavorOV.getContratoOrigen() );
						ajusteSaldoAFavorMasivoRespuesta.setIdTransaccion( ajusteSaldoAFavorRespuesta.getIdTransaccion() );

						//Encabezado
						ajusteSaldoAFavorMasivoRespuesta.setEncabezadoRespuesta(
								ajusteSaldoAFavorRespuesta.getEncabezadoRespuesta() );

			//se agrega a la lista de resultados
			transferirSaldosAFavorCreditosVigentesRespuesta.getReporteSaldosAFavor().add( ajusteSaldoAFavorMasivoRespuesta );
			}

		//Se retorna el resultado
		return transferirSaldosAFavorCreditosVigentesRespuesta;
		}


	/**
	 * @param peticion de registro telefono
	 * @param uid identificador unico de la transaccion
	 * @return ClienteRespuesta resultado del registro del telefono
	 */
	public ClienteRespuesta registrarTelefono(RegistrarTelefonoPeticion peticion, String uid) {
		//Se crea el objecto de respuesta
		final 	ClienteRespuesta
				clienteRespuesta = new ClienteRespuesta();
				clienteRespuesta.getHeader().setUID(uid);

		//Objeto para la conexion a BD, para operaciones transaccionales
	    SqlSession sessionTx = null;

		try {
			//Validacion de datos de entrada validos
			if ( peticion == null
				|| peticion.getIntegrante() == null || peticion.getTelefono() == null
				|| peticion.getIntegrante().equals( "" ) || peticion.getTelefono().equals( "" ) )
		    	{
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.datos.incompletos" ) );
		    	}

			//Par�metros para dar de alta el telefono
			final HashMap<String, Object>
				parametros = new HashMap<String, Object>();
				parametros.put( "usuario"	 	 , peticion.getUsuario() != null
												   && !peticion.getUsuario().trim().equals( "" )
												   ?   peticion.getUsuario() : "000000043" );
				parametros.put( "integrante"	 , peticion.getIntegrante() );
				parametros.put( "tipo"			 , peticion.getTipoTelefono() );
				parametros.put( "lada"			 , "" );
				parametros.put( "telefono"		 , peticion.getTelefono() );
				parametros.put( "relacion"		 , peticion.getRelacion() 		!= null ? peticion.getRelacion() 		: "" );
				parametros.put( "nombre"		 , peticion.getNombre()   		!= null ? peticion.getNombre()   		: "" );
				parametros.put( "apellidoPaterno", peticion.getApellidoPaterno() != null ? peticion.getApellidoPaterno() : "" );
				parametros.put( "apellidoMaterno", peticion.getApellidoMaterno() != null ? peticion.getApellidoMaterno() : "" );
				parametros.put( "fechaAlta"		 , new Date() );
				parametros.put( "origen"		 , "ASIC" );

				parametros.put( "idRelacion"     , 0  );
				parametros.put( "tipo_plan"      , "" );

			//Seccion transaccional
				//Se abre la conexion transaccional
				sessionTx = FabricaConexiones.obtenerSesionTx();

				LogHandler.trace(uid, getClass(), "==> registrarTelefono - registrarTelefonoIntegrante");
				final ResultadoOV resultado = (ResultadoOV) sessionTx.selectOne( "registrarTelefonoIntegrante", parametros );

				LogHandler.debug(uid, getClass(), resultado.toString());
				if ( Integer.valueOf(resultado.getCodigo()).intValue() == -1 ) {
					FabricaConexiones.rollBack( sessionTx );
					throw new Exception( resultado.getMensaje() );
				} else if (Integer.valueOf(resultado.getCodigo()).intValue() == CODIGO_ERROR_SP ) {
					sessionTx.commit();
					throw new Exception( resultado.getMensaje() );
				} else {
					sessionTx.commit();
				}
			}
		catch ( java.lang.Exception exception ) {
			clienteRespuesta.getHeader().setMensaje(exception.getMessage());
			clienteRespuesta.getHeader().setEstatus(false);
			LogHandler.error(uid, getClass(), "Error ocurrido en la operacion : " + exception.getMessage(), exception);
			}
		finally {
			FabricaConexiones.close( sessionTx  );
			}

		//Se regresa el objeto respuesta
		return clienteRespuesta;
		}

	/**
	 * @param peticion de ajuste domicilio persona
	 * @param uid identificador unico de la transaccion
	 * @return AjusteRespuesta resultado ajuste domicilio persona
	 */
	public AjusteRespuesta ajustarPersonaDomicilio(String uid, AjustarPersonaDomicilioPeticion peticion) {
		AjusteRespuesta resp = new AjusteRespuesta();

		if (peticion.getContrato() == null  || peticion.getNumeroPersona() == null
				|| peticion.getNumeroPersona().trim().isEmpty()) {
			resp.setHeader(generarHeader(uid, false, ReadProperties.mensajes.getProp("ciof.error.datos.incompletos")));
			return resp;
		}

		SqlSession 	sesionTX	= null;
		FechaContableOV fechaContable = null;
		HashMap<String, Object> datosContrato;
		HashMap<String, Object> params = new HashMap<String, Object>();

		peticion.setContrato(comun.obtenerNumeroContrato( uid, peticion.getContrato()));

		if (peticion.getContrato() == null  ) {
			LogHandler.error(uid, getClass(), ReadProperties.mensajes.getProp("ciof.contratoinvalido"),
							new Exception( ReadProperties.mensajes.getProp("ciof.contratoinvalido") ));
			resp.setHeader(generarHeader(uid, false, ReadProperties.mensajes.getProp("ciof.contratoinvalido")));
			return resp;
		}

		try {
			//obtener fecha contable
			 fechaContable = (FechaContableOV) comun.obtenerFechaContable(uid);

			 // Validar que se pueda realizar la operaci�n
			if ( fechaContable.isEstatusCierre()) {
				LogHandler.debug(uid, this.getClass(), ReadProperties.mensajes.getProp("ciof.error.ejecucioncierre"));
				resp.setHeader(generarHeader(uid, false, ReadProperties.mensajes.getProp("ciof.error.ejecucioncierre")));
				return resp;
			}

			// 	Obtener info del contrato
			// los datos que se obtienen son: fecha_prim_venc, sucursal, monto, tasa,
			// no_pagos, frecuencia_pago, monto_pago, propietario

			datosContrato = (HashMap<String, Object>) comun.obtenerDatosGeneralesContrato(uid, peticion.getContrato());

			if (datosContrato == null) {
				throw new Exception( ReadProperties.mensajes.getProp("ciof.contratoinvalido") );
			}

			if (!datosContrato.get( "status" ).toString().trim().equals( "N" )
				&& !datosContrato.get( "status" ).toString().trim().equals( "D" ) ) {
				throw new Exception( ReadProperties.mensajes.getProp("ciof.error.statuscontrato" ));
			}

			sesionTX = FabricaConexiones.obtenerSesionTx();
			peticion.setNumeroPersona( comun.obtenerPersonaCliente(uid, peticion.getNumeroPersona()) );

			params = new HashMap<String, Object>();
			params.put("contrato", peticion.getContrato());
			params.put("persona_dom_reunion", peticion.getNumeroPersona() );
			sesionTX.update("actualizaContratoGrupoAjuste", params);

			sesionTX.commit(true);
			resp.setHeader(generarHeader(uid, true, "El cambio de persona domicilio quedo realizado correctamente"));

		}
		catch (Exception e) {
			LogHandler.error( uid, this.getClass(), "Error en ajustarPersonaDomicilio : " + e.getMessage(), e);
			FabricaConexiones.rollBack( sesionTX );
			resp.setHeader(generarHeader(uid, false, e.getMessage() ));
			resp.setNuevoMonto(null);
			}
		finally {
			FabricaConexiones.close( sesionTX );
			}
		return resp;
	}


	/**
	 * @param peticion de eliminacion del saldo a favor
	 * @param uid identificador unico de la transaccion
	 * @return EliminarSaldoAFavorRespuesta resultado de eliminacion del saldo a favor
	 */
	@SuppressWarnings("unchecked")
	public EliminarSaldoAFavorRespuesta eliminarSaldoAFavorRING( EliminarSaldoAFavorPeticion peticion, String uid )
	{
		//Se crea el objecto de respuesta
		final 	EliminarSaldoAFavorRespuesta
				eliminarSaldoAFavorRespuesta = new EliminarSaldoAFavorRespuesta();
				eliminarSaldoAFavorRespuesta.setEncabezadoRespuesta( new EncabezadoRespuesta() );

		//Objeto para la conexion a BD, para consultas y validaciones
	    SqlSession sessionNTx = null;

	    //Objeto para la conexion a BD, para operaciones transaccionales
	    SqlSession sessionTx = null;

	    FechaContableOV fechaContable = null;

		try {
			//Validacion de contrato valido
			if ( peticion == null || peticion.getContrato() == null ) {
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.datos.incompletos" ) );
		    	}

			//Se abre la conexion de bd
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			//Se convierten los contratos LD a credprod
			peticion.setContrato( comun.obtenerNumeroContrato(uid, peticion.getContrato() ) );

			//Validacion de contrato valido
			if ( peticion.getContrato() == null ) {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.transferirsaldoafavor.error.contratosinvalidos" ) );
		    	}


			fechaContable = comun.obtenerFechaContable(uid);

			//Se verifica el contrato
			LogHandler.trace(uid, this.getClass(), "==> eliminarSaldoAFavor - verificarContratoOrigen");
			final java.util.HashMap<String, Object>	resultContratoValido = (HashMap<String, Object>)
					sessionNTx.selectOne( "verificarContratoOrigen" , peticion.getContrato() );

			if ( resultContratoValido == null ) {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.transferirsaldoafavor.error.contratoorigen" ) );
			}


			sessionTx = FabricaConexiones.obtenerSesionTx();


			java.math.BigDecimal 	saldoFavor = (BigDecimal) resultContratoValido.get( "capital" );
			final java.lang.Integer 	sucursal   = (Integer) resultContratoValido.get( "sucursal" );

			saldoFavor = saldoFavor.abs();

			HashMap<String, Object> paramsInsert = new HashMap<String, Object>();
			paramsInsert.put("contrato", peticion.getContrato() );
			paramsInsert.put("sucursal", sucursal );
			paramsInsert.put("monto", saldoFavor );
			paramsInsert.put("no_ult_pago", resultContratoValido.get("no_ult_pago"));
			paramsInsert.put("fechaContable", new SimpleDateFormat("yyyy-MM-dd").format( fechaContable.getFecha() ) );

			LogHandler.trace(uid, getClass(), "==> ajusteSaldosAFavor - insertMovimientoRING" );
			int resultInsert = sessionTx.insert("insertMovimientoRING", paramsInsert);

			if (resultInsert < 1) {
				throw new Exception("No se pudo realizar el insert del movimiento RING.");
			}

			int resultUpdate = sessionTx.update( "actualizarMontoCapital", paramsInsert);

			if (resultUpdate < 1) {
				throw new Exception("No se pudo realizar el update del movimiento RING.");
			}

			sessionTx.commit();


				//Datos para regresar
				final 	EliminarSaldoAFavorOV
						eliminarSaldoAFavorOV = new EliminarSaldoAFavorOV();
						eliminarSaldoAFavorOV.setMonto( saldoFavor.doubleValue());
				eliminarSaldoAFavorRespuesta.setEliminarSaldoAFavorOV( eliminarSaldoAFavorOV );

			}
		catch ( java.lang.Exception exception )	{
			FabricaConexiones.rollBack( sessionTx );
			eliminarSaldoAFavorRespuesta.getEncabezadoRespuesta().setMensaje(exception.getMessage());
			eliminarSaldoAFavorRespuesta.getEncabezadoRespuesta().setEstatus(false);
			eliminarSaldoAFavorRespuesta.getEncabezadoRespuesta().setUID(uid);
			LogHandler.error(uid, getClass(), "Error ocurrido en la operacion : " + exception.getMessage(), exception);
			}
		finally	{
			FabricaConexiones.close( sessionNTx );
			FabricaConexiones.close( sessionTx  );
			}

		//Se regresa el objeto respuesta
		return eliminarSaldoAFavorRespuesta;
	}

	/**
	 * @param uid : uid identificador unico
	 * @param peticion : AjustePorcentajeGarantiaPeticion peticion
	 * @return AjustePorcentajeGarantiaRespuesta : resultado
	 */
	@SuppressWarnings("unchecked")
	public AjustePorcentajeGarantiaRespuesta modificarGarantia(String uid, AjustePorcentajeGarantiaPeticion peticion) {

		//Se inicializan las variables
		FechaContableOV fechaContable = null;
		String contrato = null;
		Double montoAhorro = 0.0;
		HashMap<String, Object> datosContrato;
		HashMap<String, Object> insertaContratosMovimientosAjuste = new HashMap<String, Object>();
		HashMap<String, Object> consultarPorcentajeGarantia =  new HashMap<String, Object>();
		HashMap<String, Object> datosActualizaMonto = new HashMap<String, Object>();
		HashMap<String, Object> actualizaCondicionesContratos = new HashMap<String, Object>();
		HashMap<String, Object> obtieneContratosMovimientos  = new HashMap<String, Object>();

		//Se crea el objecto de respuesta
		final AjustePorcentajeGarantiaRespuesta
		resp = new AjustePorcentajeGarantiaRespuesta();
		resp.setHeader(new EncabezadoRespuesta() );

		//Se obtiene el numero de contrato
	    contrato = comun.obtenerNumeroContrato(null, peticion.getContrato());
	    //Objeto para la conexion a BD, para consultas y validaciones
	    SqlSession sessionNTx = null;

	    //Objeto para la conexion a BD, para operaciones transaccionales
	    SqlSession sessionTx = null;

	    //Validacion de contrato valido
	    if (contrato == null) {
			LogHandler.debug(uid, this.getClass(), ReadProperties.mensajes.getProp("ciof.contratoinvalido"));
			resp.setHeader(generarHeader(uid, false, ReadProperties.mensajes.getProp("ciof.contratoinvalido")));
			return resp;
		}

		try {
			//Obtiene fecha contable
			fechaContable = (FechaContableOV) comun.obtenerFechaContable(uid);

			// Validar que se pueda realizar la operacion
			if ( fechaContable.isEstatusCierre()) {
				LogHandler.debug(uid, this.getClass(), ReadProperties.mensajes.getProp("ciof.error.ejecucioncierre"));
				resp.setHeader(generarHeader(uid, false, ReadProperties.mensajes.getProp("ciof.error.ejecucioncierre")));
				return resp;
			}

		    //Se abre la conexion de bd
		    sessionNTx = FabricaConexiones.obtenerSesionNTx();

		    //Se abre la conexion de bd
		    sessionTx = FabricaConexiones.obtenerSesionTx();

			//Se obtienen datos del contrato
			datosContrato = (HashMap<String, Object>) comun.obtenerDatosGeneralesContrato(uid, contrato);

			//Validacion de contrato valido
			if (datosContrato == null) {
				throw new Exception( ReadProperties.mensajes.getProp("ciof.contratoinvalido") );
				}

			//Se valida el estatus del contrato Nuevo y Dispuesto
			if ( !datosContrato.get( "status" ).toString().trim().equals( "N" )
				&& !datosContrato.get( "status" ).toString().trim().equals( "D" ) ) {
				throw new Exception( ReadProperties.mensajes.getProp("ciof.error.statuscontrato" ));
				}

			//Se verifica el contrato
			consultarPorcentajeGarantia.put("contrato", contrato);
			PorcentajeGarantia resSolicitud =
					(PorcentajeGarantia) sessionNTx.selectOne("consultarPorcentajeGarantia", consultarPorcentajeGarantia);
			LogHandler.trace(uid, getClass(), "==> modificarGarantia - consultarPorcentajeGarantia");

			//Se valida que el contrato sea de Garantia
			if (resSolicitud == null) {
				throw new Exception("No existe informacion para el contrato ó no tiene garantía el contrato.");
			}
			else {
				//Se valida que no se pueda disminuir la Garantia
				if (peticion.getPorcentajeGarantia() < resSolicitud.getValor()) {
					throw new Exception("No se puede disminuir la garantia");
				}

				//Se valida que no sea la misma Garantia
				if (peticion.getPorcentajeGarantia() == resSolicitud.getValor()) {
					throw new Exception("No puede ser la misma garantia");
				}

				//Se valida la fecha del primer pago
				if (fechaContable.getFecha().after( (Date) datosContrato.get("fecha_prim_venc"))) {
					throw new Exception( ReadProperties.mensajes.getProp("ciof.error.primerpago"));
				}

				//Se valida que no exista movimientos CPGR en la tabla contratos_movimientos
				obtieneContratosMovimientos.put("contrato", contrato);
				final java.lang.Integer existe =
					(java.lang.Integer) sessionNTx.selectOne("obtieneContratoMovimientos", obtieneContratosMovimientos);
				LogHandler.trace(uid, getClass(), "==> modificarGarantia - obtieneContratosMovimientos");

				//Se valida que exista un movimiento en contratos_movimientos
				if ( existe > 0 ) {
					throw new Exception("Ya existe un cambio a la garantia");
				}
				else {
					//Se actualiza el monto_ahorro en la tabla de Contratos
					montoAhorro =  peticion.getPorcentajeGarantia().doubleValue() / PORCENT_GARANTIA;
					datosActualizaMonto.put("contrato", contrato);
					datosActualizaMonto.put("porcentajeGarantia", montoAhorro);
					sessionTx.update("actualizaMontoAhorro", datosActualizaMonto);
					LogHandler.trace(uid, getClass(), "==> modificarGarantia - datosActualizaMonto");

					//Actualizar porcentaje participacion
					if (!comun.actualizarPorcentajeParticipacionIntegrante(uid, sessionTx, contrato)) {
						throw new Exception( "Existio un error en la actualizacion del porcentaje"
								+ "de los integrantes del credito." );
						}
					else {
						//Inserta en contratos_movimientos
						insertaContratosMovimientosAjuste = new HashMap<String, Object>();
						insertaContratosMovimientosAjuste.put("usuario", peticion.getUsuario());
						insertaContratosMovimientosAjuste.put("contrato", contrato);
						insertaContratosMovimientosAjuste.put("tipoMovimiento", MOV_GARANTIA);
						sessionTx.insert("insertaContratosMovimientosAjuste", insertaContratosMovimientosAjuste);
						LogHandler.trace(uid, getClass(), "==> modificarGarantia - insertaContratosMovimientosAjuste");

						//actualiza en condiciones_contratos
						actualizaCondicionesContratos.put("porcentajeGarantia",
								Integer.toString(peticion.getPorcentajeGarantia()));
						actualizaCondicionesContratos.put("contrato", contrato);
						sessionTx.update("actualizaCondicionesContratos", actualizaCondicionesContratos);
						LogHandler.trace(uid, getClass(), "==> modificarGarantia - actualizaCondicionesContratos");

						//Se realiza el commit de la transaccion
						sessionTx.commit();
					}
				}
			}
		}
		catch ( java.lang.Exception exception )	{
			FabricaConexiones.rollBack( sessionTx );
			resp.getHeader().setMensaje(exception.getMessage());
			resp.getHeader().setEstatus(false);
			resp.getHeader().setUID(uid);
			LogHandler.error(uid, getClass(), "Error ocurrido en la operacion : " + exception.getMessage(), exception);
		}
		finally	{
			FabricaConexiones.close( sessionNTx );
			FabricaConexiones.close( sessionTx  );
			}

			//Se regresa el objeto respuesta
			return resp;
	}

	//TODO llamado al WS del SIC para su cancelacion STAF-195
	public List<FoliosChequesSIC> cancelaChequesSIC (String uid, List<DatosIntegranteResumenOV> folios, String usuario) throws Exception {

		if (folios == null) {
			throw new Exception("Es necesario los folios para cancelar cheques.");
		}
		if (usuario == null || usuario.isEmpty()) {
			throw new Exception("Es necesario el usuario para cancelar cheques.");
		}
		
		List<FoliosChequesSIC> retorno = null;

		//List<FoliosDTO> foliosEntrada = new ArrayList<FoliosDTO>();
		ResultadoCancelaDTO[] foliosRespuesta = new ResultadoCancelaDTO[folios.size()]; 
		//Se cambia a folios para mandar al WS
		/*for (int i = 0; i < folios.size(); i++) {
			FoliosDTO folioTmp = new FoliosDTO();
			folioTmp.setFolioCheque(Long.parseLong(folios.get(i).getFolioCheque()));
			foliosEntrada.add(folioTmp);
		}*/

		//Se obtiene la variable JNDI para el WS de SIC CHEQUES
		ParGeneralOV urlWSSIC = comun.obtenerParGeneralOV(uid, "WS_SIC_CHEQUES");
		if (urlWSSIC == null || urlWSSIC.getCgValor().trim().isEmpty()) {
			throw new Exception("No fue posible obtener la URL del servicio del SIC, Cancelacion de cheques.");
		}

		try {
			ChequesOperacionWS_ServiceLocator servicioCheques = new ChequesOperacionWS_ServiceLocator();
			servicioCheques.setChequesOperacionWSSOAPEndpointAddress(urlWSSIC.getCgValor().trim());
			for (int i = 0; i < foliosRespuesta.length; i++) {
				FoliosDTO[] folioPeticion = new FoliosDTO[1];
				folioPeticion[0] = new FoliosDTO();
				folioPeticion[0].setFolioCheque(Long.parseLong(folios.get(i).getFolioCheque()));
				foliosRespuesta[i] = servicioCheques.getChequesOperacionWSSOAP().cancelarCheque(folioPeticion, usuario);
			}
			//ResultadoCancelaDTO a = servicioCheques.getChequesOperacionWSSOAP().cancelarCheque((FoliosDTO[]) foliosEntrada.toArray(), usuario);
		} catch (Exception e) {
			LogHandler.error(uid, getClass(), "Ocurrio un error en cancelaChequesSIC.. ", e);
			throw new Exception("Ocurrio un error en cancelaChequesSIC..");
		}
		
		retorno = new ArrayList<FoliosChequesSIC>();

		if (foliosRespuesta != null) {
			for (int i = 0; i < foliosRespuesta.length; i++) {
				FoliosChequesSIC temp = new FoliosChequesSIC();
				temp.setValor(foliosRespuesta[i].getValor());
				temp.setComentario(foliosRespuesta[i].getComentario());
				temp.setFolioCheque(foliosRespuesta[i].getFolioCheque());
				retorno.add(temp);
			}
		}
		
		//TODO ResultadoCancelaDTO
		return retorno;
	}

	/**
	 * Metodo para guardar los datos del Analista
	 * @param uid the uid
	 * @param peticion AdministracionAnalistasPeticion
	 * @return AdministracionAnalistasRespuesta clase de respuesta
	 */
	public AdministracionAnalistasRespuesta guardarAnalista(String uid,
			AdministracionAnalistasPeticion peticion) {
		AdministracionAnalistasRespuesta resp = null;
		SqlSession sessionTx = null;
		Integer filasPool = 0;
		Integer filasAnalistasEstatusBorrar = 0;
		Integer filasAnalistaSucursalBorrar = 0;
		Integer filasAnalistaTipoSucursalBorrar = 0;
		Integer filasAnalistaProductoBorrar = 0;
		Integer filasAnalistaTipoRestriccionBorrar = 0;
		Integer filasAnalistaCampaniaBorrar = 0;
		Integer filasAnalistasEstatusInsertar = 0;
		Integer filasAnalistaSucursalInsertar = 0;
		Integer filasAnalistaTipoSucursalInsertar = 0;
		Integer filasAnalistaProductoInsertar = 0;
		Integer filasAnalistaTipoRestriccionInsertar = 0;
		Integer filasAnalistaCampaniaInsertar = 0;
		
		try {
			LogHandler.info(uid, getClass(), "guardarAnalista: -> ");
			resp = new AdministracionAnalistasRespuesta();
			resp.setHeader(new EncabezadoRespuesta());
			resp.getHeader().setUID(uid);
			resp.getHeader().setEstatus(true);
			
			sessionTx  = FabricaConexiones.obtenerSesionTx();

			filasPool = sessionTx.update("actualizarPoolPersonasFinsol", peticion);
			LogHandler.info(uid, this.getClass(), "actualizarPoolPersonasFinsol filas afectadas  [ " + filasPool + " ]");
			
			filasAnalistasEstatusBorrar = sessionTx.delete("borrarAnalistaEstatusAsistencia", peticion);
			LogHandler.info(uid, this.getClass(), "borrarAnalistaEstatusAsistencia filas afectadas  [ " + filasAnalistasEstatusBorrar + " ]");
						
			filasAnalistaSucursalBorrar = sessionTx.delete("borrarAnalistaSucursal", peticion);
			LogHandler.info(uid, this.getClass(), "borrarAnalistaSucursal filas afectadas  [ " + filasAnalistaSucursalBorrar + " ]");
						
			filasAnalistaTipoSucursalBorrar = sessionTx.delete("borrarAnalistaTipoSucursal", peticion);
			LogHandler.info(uid, this.getClass(), "borrarAnalistaTipoSucursal filas afectadas  [ " + filasAnalistaTipoSucursalBorrar + " ]");
						
			filasAnalistaProductoBorrar = sessionTx.delete("borrarAnalistaProducto", peticion);
			LogHandler.info(uid, this.getClass(), "borrarAnalistaProducto filas afectadas  [ " + filasAnalistaProductoBorrar + " ]");
			
			filasAnalistaTipoRestriccionBorrar = sessionTx.delete("borrarAnalistaTipoRestriccion", peticion);
			LogHandler.info(uid, this.getClass(), "borrarAnalistaTipoRestriccion filas afectadas  [ " + filasAnalistaTipoRestriccionBorrar + " ]");
						
			filasAnalistaCampaniaBorrar = sessionTx.delete("borrarAnalistaCampania", peticion);
			LogHandler.info(uid, this.getClass(), "borrarAnalistaCampania filas afectadas  [ " + filasAnalistaCampaniaBorrar + " ]");
			
			if (peticion.getDfFechaVacacionesInicio() != null && peticion.getDfFechaVacacionesFin() != null ) {
				if (!peticion.getDfFechaVacacionesInicio().equals("") && !peticion.getDfFechaVacacionesFin().equals("") ){
					filasAnalistasEstatusInsertar = sessionTx.insert("registrarAnalistaEstatusAsistencia", peticion);
				}
				LogHandler.info(uid, this.getClass(), "registrarAnalistaEstatusAsistencia filas afectadas  [ " + filasAnalistasEstatusInsertar + " ]");
			}
			
						
			////////////////////////////////////////////////////// SUCURSALES ////////////////////////////////////////////////////////////////
			if (peticion.getCmbSucursales() != null ) {
				if (!peticion.getCmbSucursales().equals("") && peticion.getCmbSucursales().size() > 0) {
					for (Integer sucursales : peticion.getCmbSucursales()) {
						peticion.setSucursal(sucursales);
						filasAnalistaSucursalInsertar = sessionTx.insert("registrarAnalistaSucursal", peticion)
								+ filasAnalistaSucursalInsertar;
					}
				}
				LogHandler.info(uid, this.getClass(), "registrarAnalistaSucursal filas afectadas  [ " + filasAnalistaSucursalInsertar + " ]");
			}
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			////////////////////////////////////////////////////// TIPO SUCURSAL /////////////////////////////////////////////////////////////
			if (peticion.getCmbTipoSucursal() != null ) {
				if (!peticion.getCmbTipoSucursal().equals("") && peticion.getCmbTipoSucursal().size() > 0) {
					for (String tipoSucursales : peticion.getCmbTipoSucursal()) {
						peticion.setTipoSucursal(tipoSucursales);
						filasAnalistaTipoSucursalInsertar = sessionTx.insert("registrarAnalistaTipoSucursal", peticion)
								+ filasAnalistaTipoSucursalInsertar;
					}
				}
				LogHandler.info(uid, this.getClass(), "registrarAnalistaTipoSucursal filas afectadas  [ " + filasAnalistaTipoSucursalInsertar + " ]");
			}
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			////////////////////////////////////////////////////// PRODUCTO /////////////////////////////////////////////////////////////
			if (peticion.getCmdProducto() != null ) {
				if (!peticion.getCmdProducto().equals("") && peticion.getCmdProducto().size() > 0) {
					for (String producto : peticion.getCmdProducto()) {
						peticion.setProducto(producto);
						filasAnalistaProductoInsertar = sessionTx.insert("registrarAnalistaProducto", peticion)
								+ filasAnalistaProductoInsertar;
					}
				}
				LogHandler.info(uid, this.getClass(), "registrarAnalistaProducto filas afectadas  [ " + filasAnalistaProductoInsertar + " ]");
			}
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			////////////////////////////////////////////////////// TIPO RESTRICCION /////////////////////////////////////////////////////////////
			if (peticion.getCmbNivelRestriccion() != null ) {
				if (!peticion.getCmbNivelRestriccion().equals("") && peticion.getCmbNivelRestriccion().size() > 0) {
					for (String restriccion : peticion.getCmbNivelRestriccion()) {
						peticion.setNivelRestriccion(restriccion);
						filasAnalistaTipoRestriccionInsertar = sessionTx.insert("registrarAnalistaTipoRestriccion", peticion)
								+ filasAnalistaTipoRestriccionInsertar;
					}
				}
				LogHandler.info(uid, this.getClass(), "registrarAnalistaTipoRestriccion filas afectadas  [ " + filasAnalistaTipoRestriccionInsertar + " ]");
			}
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
			
			//////////////////////////////////////////////////////  CAMPANIA  /////////////////////////////////////////////////////////////
			if (peticion.getCmbCampanas() != null ) {
				if (!peticion.getCmbCampanas().equals("") && peticion.getCmbCampanas().size() > 0) {
					for (String campanas : peticion.getCmbCampanas()) {
						peticion.setCampana(campanas);
						filasAnalistaCampaniaInsertar = sessionTx.insert("registrarAnalistaCampania", peticion)
								+ filasAnalistaCampaniaInsertar;
					}
				}
				LogHandler.info(uid, this.getClass(), "registrarAnalistaCampania filas afectadas  [ " + filasAnalistaCampaniaInsertar + " ]");
			}
			//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

			LogHandler.info(uid, getClass(), "guardarAnalista: -> ");
			sessionTx.commit(true);
			resp.getHeader().setMensaje("Información guardada correctamente");
		}
		catch ( java.lang.Exception exception )	{
			FabricaConexiones.rollBack( sessionTx );
			resp.getHeader().setMensaje(exception.getMessage());
			resp.getHeader().setEstatus(false);
			resp.getHeader().setUID(uid);
			LogHandler.error(uid, getClass(), "Error ocurrido en la operación de guardado: "
					+ exception.getMessage(), exception);
		}
		finally	{
			FabricaConexiones.close( sessionTx );
			}
		return resp;
	}

	/**
	 * Metodo para consultar los datos del Analista
	 * @param uid the uid
	 * @param peticion AdministracionAnalistasPeticion
	 * @return AdministracionAnalistasRespuesta clase de respuesta
	 */
	@SuppressWarnings("unchecked")
	public AdministracionAnalistasRespuesta buscarAnalista(String uid,
			AdministracionAnalistasPeticion peticion) {
		AdministracionAnalistasPeticion datosRepuesta = null;
		AdministracionAnalistasPeticion datosRepuestaVacaciones = null;
		AdministracionAnalistasRespuesta resp = null;
		SqlSession sessionNTx = null;
		List<Integer> listaSucursales = null;
		List<String> listasTipoSucursal = null;
		List<String> listaProducto = null;
		List<String> listaRestriccion = null;
		List<String> listaCampania = null;

		try {
			
			LogHandler.info(uid, getClass(), "buscarAnalista --> ");
			datosRepuesta = new AdministracionAnalistasPeticion();
			datosRepuestaVacaciones = new AdministracionAnalistasPeticion();
			resp = new AdministracionAnalistasRespuesta();
			resp.setHeader(new EncabezadoRespuesta());
			resp.getHeader().setUID(uid);
			resp.getHeader().setEstatus(true);

			sessionNTx  = FabricaConexiones.obtenerSesionNTx();

			datosRepuesta = (AdministracionAnalistasPeticion) sessionNTx.selectOne("consultarPoolPersonasFinsol", peticion);
			sessionNTx.commit(true);
			
			datosRepuestaVacaciones = (AdministracionAnalistasPeticion) sessionNTx.selectOne("consultarAnalistaEstatusAsistencia", peticion);
			sessionNTx.commit(true);

			if ( datosRepuestaVacaciones == null ) {
				LogHandler.info(uid, this.getClass(), "Sin consulta de vacaciones.");
			} else {
				
				if ( datosRepuestaVacaciones.getDfFechaVacacionesInicio() == null ) {
					LogHandler.info(uid, this.getClass(), "sin getDfFechaVacacionesInicio");
				} else {
					datosRepuesta.setDfFechaVacacionesInicio(datosRepuestaVacaciones.getDfFechaVacacionesInicio());
				}
				if ( datosRepuestaVacaciones.getDfFechaVacacionesFin() == null ){
					LogHandler.info(uid, this.getClass(), "sin getDfFechaVacacionesFin");
				} else {
					datosRepuesta.setDfFechaVacacionesFin(datosRepuestaVacaciones.getDfFechaVacacionesFin());
				}
			}

			listaSucursales = (java.util.ArrayList<Integer>) sessionNTx.selectList("consultarAnalistaSucursal", peticion);
			sessionNTx.commit(true);
			
			if (listaSucursales == null || listaSucursales.size() == 0) {
				LogHandler.info(uid, this.getClass(), "sin listaSucursales");
			} else {
				LogHandler.info(uid, this.getClass(), "listaSucursales tamaño: " + listaSucursales.size());
				datosRepuesta.setCmbSucursales(listaSucursales);
			}

			listasTipoSucursal = (java.util.ArrayList<String>) sessionNTx.selectList("consultarAnalistaTipoSucursal", peticion);
			sessionNTx.commit(true);
			
			if (listasTipoSucursal == null || listasTipoSucursal.size() == 0) {
				LogHandler.info(uid, this.getClass(), "sin listasTipoSucursal");
			} else {
				LogHandler.info(uid, this.getClass(), "listaTipoSucursal tamaño: " + listasTipoSucursal.size());
				datosRepuesta.setCmbTipoSucursal(listasTipoSucursal);
			}
			
			listaProducto = (java.util.ArrayList<String>) sessionNTx.selectList("consultarAnalistaproducto", peticion);
			sessionNTx.commit(true);
			
			if (listaProducto == null || listaProducto.size() == 0) {
				LogHandler.info(uid, this.getClass(), "sin listaProducto");
			} else {
				LogHandler.info(uid, this.getClass(), "listaProducto tamaño: " + listaProducto.size());
				datosRepuesta.setCmdProducto(listaProducto);
			}
			
			listaRestriccion = (java.util.ArrayList<String>) sessionNTx.selectList("comsultarAnalistaTipoRestriccion", peticion);
			sessionNTx.commit(true);
			
			if (listaRestriccion == null || listaRestriccion.size() == 0) {
				LogHandler.info(uid, this.getClass(), "sin listaRestriccion");
			} else {
				LogHandler.info(uid, this.getClass(), "listaRestriccion tamaño: " + listaRestriccion.size());
				datosRepuesta.setCmbNivelRestriccion(listaRestriccion);
			}
			
			listaCampania = (java.util.ArrayList<String>) sessionNTx.selectList("consultarAnalistaCampania", peticion);
			sessionNTx.commit(true);
			
			if (listaCampania == null || listaCampania.size() == 0) {
				LogHandler.info(uid, this.getClass(), "sin listaCampania");
			} else {
				LogHandler.info(uid, this.getClass(), "listaCampania tamaño: " + listaCampania.size());
				datosRepuesta.setCmbCampanas(listaCampania);
			}
	
			resp.setConsulta(datosRepuesta);
			resp.getHeader().setMensaje("Datos encontrados correctamente.");
		}
		catch ( java.lang.Exception exception )	{
			resp.getHeader().setMensaje(exception.getMessage());
			resp.getHeader().setEstatus(false);
			resp.getHeader().setUID(uid);
			LogHandler.error(uid, getClass(), "Error ocurrido en la operacion buscarAnalista: "
					+ exception.getMessage(), exception);
		}
		finally	{
			FabricaConexiones.close( sessionNTx );
			}
		return resp;
	}

	/**
	 * Metodo para guardar la contingencia
	 * @param uid the uid
	 * @param peticion AdministracionAnalistasPeticion
	 * @return AdministracionAnalistasRespuesta clase de respuesta
	 */
	public AdministracionAnalistasRespuesta guardarContingenciaAnalistas(
			String uid, AdministracionAnalistasPeticion peticion) {
		AdministracionAnalistasRespuesta resp = null;
		SqlSession sessionTx = null;
		Integer filasContingencia = 0;
	
		try {
			LogHandler.info(uid, getClass(), "guardarContingenciaAnalistas: -> ");
			resp = new AdministracionAnalistasRespuesta();
			resp.setHeader(new EncabezadoRespuesta());
			resp.getHeader().setUID(uid);
			resp.getHeader().setEstatus(true);
			
			sessionTx  = FabricaConexiones.obtenerSesionTx();
			
			filasContingencia = sessionTx.insert("registrarContingenciaAnalista", peticion);
			sessionTx.commit(true);
			LogHandler.info(uid, this.getClass(), "registrarContingenciaAnalista filas afectadas  [ " + filasContingencia + " ]");
			LogHandler.info(uid, getClass(), "guardarContingenciaAnalistas: -> ");
			resp.getHeader().setMensaje("Información guardada correctamente");
		}
		catch ( java.lang.Exception exception )	{
			FabricaConexiones.rollBack( sessionTx );
			resp.getHeader().setMensaje(exception.getMessage());
			resp.getHeader().setEstatus(false);
			resp.getHeader().setUID(uid);
			LogHandler.error(uid, getClass(), "Error ocurrido en la operación de guardarContingenciaAnalistas: "
					+ exception.getMessage(), exception);
		}
		finally	{
			FabricaConexiones.close( sessionTx );
			}
		return resp;
	}

	/**
	 * Metodo que se utiliza para obtener informacion de las sucursales
	 *
	 * @param uid the uid
	 * @param peticion datos de peticion de cambio de porcentaje de Garantia
	 * @return AjusteRespuesta: resultado del ajuste al porcentaje de Garantia
	 */
	@SuppressWarnings("unchecked")
	public RespuestaSucursalOV obtieneInfoSucursalTarea(String uid, SucursalPeticion peticion) {

		RespuestaSucursalOV resp = new RespuestaSucursalOV();
		resp.setHeader(new EncabezadoRespuesta());
		resp.getHeader().setUID(uid);
		resp.getHeader().setEstatus(true);

		//Objeto para la conexion a BD, para consultas y validaciones
		SqlSession sessionNTx = null;
		String sucursal = "";
		java.util.ArrayList<SucursalOV> sucursales = new ArrayList<SucursalOV>();
		java.util.ArrayList<AsesoresOV> asesores = new ArrayList<AsesoresOV>();

		try {

			//Se abre la conexion hacia la base de datos
			sessionNTx  = FabricaConexiones.obtenerSesionNTx();

			if (peticion == null || peticion.getSucursal() == null) {
				throw new Exception("Numero de sucursal no valido");
			}

			sucursal = peticion.getSucursal().toString();

			final java.util.HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("sucursal", peticion.getSucursal());
			LogHandler.info(uid, getClass(), "sucursal --> " + sucursal);

			sucursales =  (java.util.ArrayList<SucursalOV>) sessionNTx.selectList("obtieneConsultaInfoSucursal", param);

			if (sucursales.size() == 0) {
				throw new Exception("No se obtuvieron resultado de sucursales");
			} else {
				resp.setSucursalOV(sucursales);
			}

			final java.util.HashMap<String, Object> parame = new HashMap<String, Object>();
			parame.put("sucursal", peticion.getSucursal());
			LogHandler.info(uid, getClass(), "sucursal --> " + sucursal);

			asesores = (java.util.ArrayList<AsesoresOV>) sessionNTx.selectList("obtieneAsesoresSucursal", param);

			if (asesores.size() == 0) {
				throw new Exception("No se obtuvieron asesores para la sucursal");
			} else {
				resp.setAsesoresOV(asesores);
			}

			LogHandler.info(uid, getClass(), "obtieneInfoSucursalTarea: -> ");
			resp.getHeader().setMensaje("Sucursales encontradas");
		}
		catch ( java.lang.Exception exception )	{
			FabricaConexiones.rollBack( sessionNTx );
			resp.getHeader().setMensaje(exception.getMessage());
			resp.getHeader().setEstatus(false);
			resp.getHeader().setUID(uid);
			LogHandler.error(uid, getClass(), "Error ocurrido en la operacion obtieneInfoSucursalTarea: "
					+ exception.getMessage(), exception);
		}
		finally	{
			FabricaConexiones.close( sessionNTx );
			}

		//Se regresa el objeto respuesta
		return resp;
	}


	/**
	 * Metodo que se utiliza para actualizar la informacion de la sucursal
	 *
	 * @param uid the uid
	 * @param peticion RespuestaSucursalOV
	 * @return respuestaXML clase de respuesta
	 */
	@SuppressWarnings("unchecked")
	public RespuestaSucursalOV actualizaInfoSucursalTarea(String uid, RespuestaSucursalOV peticion) {
		RespuestaSucursalOV resp = new RespuestaSucursalOV();
		resp.setHeader(new EncabezadoRespuesta());
		resp.getHeader().setUID(uid);
		resp.getHeader().setEstatus(true);

		//Objeto para la conexion a BD, para consultas y validaciones
		SqlSession sessionTx = null;
		String sucursal = "";
		java.util.ArrayList<SucursalOV> sucursales = new ArrayList<SucursalOV>();
		java.util.ArrayList<AsesoresOV> asesores = new ArrayList<AsesoresOV>();

		try {

			//Se abre la conexion hacia la base de datos
			sessionTx  = FabricaConexiones.obtenerSesionTx();


			final java.util.HashMap<String, Object> param = new HashMap<String, Object>();
			if (peticion.getSucursalOV().size() > 0) {
				for ( int i = 0; i < peticion.getSucursalOV().size(); i++) {

					param.put("sucursal", peticion.getSucursalOV().get(i).getSucursal());

					if (peticion.getSucursalOV().get(i).getUsuario_modificacion() != null) {
						param.put("usuario_modificacion", peticion.getSucursalOV().get(i).getUsuario_modificacion());
					}

					if (peticion.getSucursalOV().get(i).getCuposCampana() > -1 ) {
						param.put("cuposCampana", peticion.getSucursalOV().get(i).getCuposCampana());
					}

					if (peticion.getSucursalOV().get(i).getMontoMesCampana() != null) {
						param.put("montoMesCampana", Double.valueOf(peticion.getSucursalOV().get(i).getMontoMesCampana().replace(",", "")));
					}

					if (peticion.getSucursalOV().get(i).getSuspensionGrupoNuevo() != null) {
						param.put("suspensionGrupoNuevo", peticion.getSucursalOV().get(i).getSuspensionGrupoNuevo());
					}

					if (peticion.getSucursalOV().get(i).getNivelRestriccion() != null) {
						param.put("valor_tipificacion", peticion.getSucursalOV().get(i).getNivelRestriccion());
					}

					if (peticion.getSucursalOV().get(i).getPlazoRestriccionSemanal() > -1) {
						param.put("restriccionColocacion", peticion.getSucursalOV().get(i).getPlazoRestriccionSemanal());
					}

					if (peticion.getSucursalOV().get(i).getRestriccionPlazoCatorcenal() != null) {
						param.put("restriccionPlazoCatorcenal", peticion.getSucursalOV().get(i).getRestriccionPlazoCatorcenal());
					}

					if (peticion.getSucursalOV().get(i).getAplicaCampana3() != null) {
						param.put("aplicaCampana3", peticion.getSucursalOV().get(i).getAplicaCampana3());
					}

					if (peticion.getSucursalOV().get(i).getEstatus() != null) {
						param.put("estatus", peticion.getSucursalOV().get(i).getEstatus());
					}
				}
			}

			Integer filas = sessionTx.update("actualizaSucursales", param);
			LogHandler.info(uid, this.getClass(), "ACTUALIZAR filas afectadas  [ " + filas + " ]");

			if (filas == 0) {
				throw new Exception("SE HA PRODUCIDO UN ERROR DURANTE LA ACTUALIZACION");
			}

			for ( int i = 0; i < peticion.getSucursalOV().size(); i++) {

				if (peticion.getSucursalOV().get(i).getTipoSucursal() != null) {
					param.put("valor_tipificacion", peticion.getSucursalOV().get(i).getTipoSucursal());
				}

				if (peticion.getSucursalOV().get(i).getTipificacion() != null) {
					param.put("tipificacion", peticion.getSucursalOV().get(i).getTipificacion());
				}

				Integer filasTipificacion = sessionTx.update("actualizaSucursalesTipificacion", param);
				LogHandler.info(uid, this.getClass(), "ACTUALIZAR filas afectadas de sucursalesTipificacion [ "
						+ filasTipificacion + " ]");

				if (filasTipificacion == 0) {
					throw new Exception("SE HA PRODUCIDO UN ERROR DURANTE LA ACTUALIZACION DE TIPIFICACION DE SUCURSALES");
				}
			}
			java.util.HashMap<String, Object> solicitudParametros =  new java.util.HashMap<String, Object>();
			asesores = peticion.getAsesoresOV();

			if (asesores != null) {
				final java.util.HashMap<String, Object> params = new HashMap<String, Object>();
				if (peticion.getAsesoresOV().size() > 0) {
	
					for ( int i = 0; i < peticion.getAsesoresOV().size(); i++) {
						params.put("persona", peticion.getAsesoresOV().get(i).getPersona());
						params.put("participaCampana3", peticion.getAsesoresOV().get(i).getParticipaCampana3());
						params.put("sucursal", Integer.parseInt(peticion.getAsesoresOV().get(i).getSucursal()));
	
						Integer filasAsesores = sessionTx.update("actualizaAsesores", params);
						LogHandler.info(uid, this.getClass(), "ACTUALIZAR filas afectadas de asesores [ "
								+ filasAsesores + " ]");
	
						if (filasAsesores == 0) {
							throw new Exception("SE HA PRODUCIDO UN ERROR DURANTE LA ACTUALIZACION DEL ASESOR: "
									+ peticion.getAsesoresOV().get(i).getPersona());
						}
	
					}
				}
			}

			LogHandler.info(uid, getClass(), "obtieneInfoSucursalTarea: -> ");
			sessionTx.commit(true);

			resp.getHeader().setMensaje("Sucursales encontradas");
		}
		catch ( java.lang.Exception exception )	{
			FabricaConexiones.rollBack( sessionTx );
			resp.getHeader().setMensaje(exception.getMessage());
			resp.getHeader().setEstatus(false);
			resp.getHeader().setUID(uid);
			LogHandler.error(uid, getClass(), "Error ocurrido en la operacion actualizaInfoSucursalTarea: "
					+ exception.getMessage(), exception);
		}
		finally	{
			FabricaConexiones.close( sessionTx );
			}

		//Se regresa el objeto respuesta
		return resp;
	}


	/**
	 * Metodo para consultar los contratos actuales de la sucursal con coordenadas
	 * @param uid the uid
	 * @param peticion sucursal y usuario
	 * @return lista de contratos
	 */
	@SuppressWarnings("unchecked")
	public GruposGPSRespuesta consultaContratosCoordenadas(String uid, GruposGPSPeticion peticion) {
		GruposGPSRespuesta respuesta = new GruposGPSRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		//Objeto para la conexion a BD, para consultas y validaciones
		SqlSession sessionNTx = null;
		try {

			if ( peticion.getSucursal() <= 0) {
				throw new Exception("La sucursal es necesaria en la peticion.");
			}
			//Se abre la conexion hacia la base de datos
			sessionNTx  = FabricaConexiones.obtenerSesionNTx();
			java.util.ArrayList<ContratoDTO> contratos = new ArrayList<ContratoDTO>();
			final java.util.HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("sucursal", peticion.getSucursal());
			contratos = (java.util.ArrayList<ContratoDTO>) sessionNTx.selectList("consultaContratosCoordenadas", params);

			if (contratos.size() == 0) {
				throw new Exception("La sucursal es necesaria en la peticion.");
			}
			respuesta.setContratos(contratos);

		}
		catch ( java.lang.Exception exception )	{
			respuesta.getHeader().setMensaje(exception.getMessage());
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setUID(uid);
			LogHandler.error(uid, getClass(), "Error ocurrido en la operacion consultaContratosCoordenadas: "
					+ exception.getMessage(), exception);
		}
		finally	{
			FabricaConexiones.close( sessionNTx );
		}

		return respuesta;
	}

	/**
	 * Metodo para actualizar las coordenadas de un contratos
	 * @param uid the uid
	 * @param peticion contrato y coordenadas
	 * @return resultado actualizacionk
	 */
	public GruposGPSRespuesta actualizarContratoCoordenadas(String uid, GruposGPSPeticion peticion) {
		GruposGPSRespuesta respuesta = new GruposGPSRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		//Objeto para la conexion a BD, para consultas y validaciones
		SqlSession sessionTx = null;
		try {

			if ( peticion.getGrupo() == null || peticion.getGrupo().isEmpty()) {
				throw new Exception("El numero de grupo es necesario en la peticion.");
			}
			if  (peticion.getLatitud() == 0 ) {
				throw new Exception("El dato latitud es necesario en la peticion.");
			}
			if  (peticion.getLongitud() == 0 ) {
				throw new Exception("El dato longitud es necesario en la peticion.");
			}
			if ( peticion.getUsuario() == null || peticion.getUsuario().isEmpty()) {
				throw new Exception("El usuario es necesario en la peticion.");
			}
			//Se abre la conexion hacia la base de datos
			sessionTx  = FabricaConexiones.obtenerSesionTx();
			final java.util.HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("grupo", peticion.getGrupo());
			params.put("latitud", peticion.getLatitud());
			params.put("longitud", peticion.getLongitud());
			params.put("usuario", peticion.getUsuario());

			int registros = sessionTx.update("actualizarContratoCoordenadas", params);

			if (registros == 0) {
				throw new Exception("Existio un error en la actualizacion de las coordenadas.");
			}

			sessionTx.commit();
		}
		catch ( java.lang.Exception exception )	{
			FabricaConexiones.rollBack( sessionTx );
			respuesta.getHeader().setMensaje(exception.getMessage());
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setUID(uid);
			LogHandler.error(uid, getClass(), "Error ocurrido en la operacion actualizarContratoCoordenadas: "
					+ exception.getMessage(), exception);
		}
		finally	{
			FabricaConexiones.close( sessionTx );
		}
		return respuesta;
	}
}
