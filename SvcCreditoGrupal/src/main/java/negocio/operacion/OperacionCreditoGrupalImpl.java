package negocio.operacion;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.xml.ws.Holder;

import org.oasisopen.sca.annotation.Reference;

import tarea.operacion.PagosCredito;
import transformador.Transformador;
import utilitario.comun.GUIDGenerator;
import utilitario.log.LogHandler;
import utilitario.mensajes.convenio.ConvenioOV;
import utilitario.mensajes.convenio.DatosConvenioPeticion;
import utilitario.mensajes.convenio.DatosConvenioRespuesta;
import utilitario.mensajes.operacion.ActaRecaudacionClienteOV;
import utilitario.mensajes.operacion.ActaRecaudacionOV;
import utilitario.mensajes.operacion.ActaRecaudacionParcialidadOV;
import utilitario.mensajes.operacion.ActaRecaudacionPeticion;
import utilitario.mensajes.operacion.ActaRecaudacionRespuesta;
import utilitario.mensajes.operacion.TraspasoPagosPeticion;
import utilitario.mensajes.operacion.TraspasoPagosRespuesta;
import utilitario.mensajes.operacion.pagos.ActivaTarjetaResponseReturn;
import utilitario.mensajes.operacion.pagos.AlmacenarArchivoOxxoPeticion;
import utilitario.mensajes.operacion.pagos.AlmacenarArchivoOxxoRespuesta;
import utilitario.mensajes.operacion.pagos.AplicarPagoConexiaPeticion;
import utilitario.mensajes.operacion.pagos.AplicarPagoForaneoResponse.AplicarPagoForaneoResult;
import utilitario.mensajes.operacion.pagos.AplicarPagoLineaPeticion;
import utilitario.mensajes.operacion.pagos.AplicarPagoPeticion;
import utilitario.mensajes.operacion.pagos.AplicarPagoRespuesta;
import utilitario.mensajes.operacion.pagos.AplicarPagoServicioRespuesta;
import utilitario.mensajes.operacion.pagos.AplicarVentaCarteraMasivaResponse.AplicarVentaCarteraMasivaResult;
import utilitario.mensajes.operacion.pagos.BasicResponse;
import utilitario.mensajes.operacion.pagos.BloqueaTarjetaResponseReturn;
import utilitario.mensajes.operacion.pagos.CancelarMovimientosPeticion;
import utilitario.mensajes.operacion.pagos.CancelarMovimientosRespuesta;
import utilitario.mensajes.operacion.pagos.CancelarPagoConexiaPeticion;
import utilitario.mensajes.operacion.pagos.CancelarPagoConexiaRespuesta;
import utilitario.mensajes.operacion.pagos.ConsultaContratoDeTarjetaResponse.ConsultaContratoDeTarjetaResult;
import utilitario.mensajes.operacion.pagos.ConsultaContratosRecoleccionResponse.ConsultaContratosRecoleccionResult;
import utilitario.mensajes.operacion.pagos.ConsultaOpcionesServiciosClienteResponse.ConsultaOpcionesServiciosClienteResult;
import utilitario.mensajes.operacion.pagos.ConsultaServiciosClienteResponse.ConsultaServiciosClienteResult;
import utilitario.mensajes.operacion.pagos.ConsultarPagosLineaRespuesta;
import utilitario.mensajes.operacion.pagos.ConsultarPagosPeticion;
import utilitario.mensajes.operacion.pagos.ConsultarPagosRespuesta;
import utilitario.mensajes.operacion.pagos.EntContrato;
import utilitario.mensajes.operacion.pagos.EntCupon;
import utilitario.mensajes.operacion.pagos.PagoDTO;
import utilitario.mensajes.operacion.pagos.PagoGrupal;
import utilitario.mensajes.operacion.pagos.PagoGrupalResponse;
import utilitario.mensajes.operacion.pagos.PagoServicioPeticion;
import utilitario.mensajes.operacion.pagos.PagoServiciosResponse.PagoServiciosResult;
import utilitario.mensajes.operacion.pagos.RespuestaConciliarPagos;
import utilitario.mensajes.operacion.pagos.Resultado;
import utilitario.mensajes.operacion.pagos.ReversarPagoOxxoPeticion;
import utilitario.mensajes.operacion.pagos.ReversarPagoOxxoRespuesta;
import utilitario.mensajes.operacion.pagos.TraspasarPagoPeticion;
import utilitario.mensajes.operacion.pagos.TraspasarPagoRespuesta;
import utilitario.mensajes.operacion.pagos.oxxo.PeticionEnLineaOxxo;
import utilitario.mensajes.operacion.pagos.oxxo.RespuestaReverseEnLineaOxxo;

public 	class OperacionCreditoGrupalImpl
		implements OperacionCreditoGrupal {
	/**
	 * SCA Component Fabric
	 */
	PagosCredito pagos;
	/**
	 * SCA Component Fabric
	 */
	private Transformador transformador;

	/**
	 * @param pagos :
	 * @param transformador :
	 * SCA Component Fabric constructor
	 */
	public OperacionCreditoGrupalImpl(@Reference(name = "pagos") PagosCredito pagos,
			@Reference(name = "transformador") Transformador transformador) {
		this.pagos = pagos;
		this.transformador = transformador;
	}

	/**
	 * @param contrato :
	 * @param montoRecibido :
	 * @param caja :
	 * @param operador :
	 * @param tipoOperacion :
	 * @param numeroCuenta :
	 * @param numeroReferencia :
	 * @param numeroOperacion :
	 * @param sucursalOrigen :
	 * @param ubicacion :
	 * @param fechaValor :
	 * @param medioPago :
	 * @param codigoServicio :
	 * @param referenciaTC :
	 * @return Resultado
	 */
	public Resultado aplicarPago(String contrato, BigDecimal montoRecibido,
			int caja, String operador, String tipoOperacion,
			String numeroCuenta, String numeroReferencia,
			BigDecimal numeroOperacion, int sucursalOrigen, int ubicacion,
			Date fechaValor, String medioPago,
			String codigoServicio, String referenciaTC) {
		return null;
	}


	/**
	 * @param cadenaXML :
	 * @return String
	 */
	public String aplicarPagoMasivo(String cadenaXML) {
		return null;
	}

	/**
	 * @param cadenaXML :
	 * @return String
	 */
	public String aplicarCargoMasivo(String cadenaXML) {
		return null;
	}

	/**
	 * @param contrato :
	 * @param numeroTransaccion :
	 * @param tipoOperacion :
	 * @param operador :
	 * @param sucursalOrigen :
	 * @param caja :
	 * @return String
	 */
	public Resultado cancelarPago(String contrato,
			BigDecimal numeroTransaccion, String tipoOperacion,
			String operador, int sucursalOrigen, int caja) {
		return null;
	}

	/**
	 * @param contrato :
	 * @return EntContrato
	 */
	public EntContrato consultarInformacionContrato(String contrato) {
		return null;
	}


	public void aplicarPagoForaneo(BigDecimal idtrxcaja, String contrato,
			BigDecimal montoAPagar, BigDecimal montoRecibido,
			BigDecimal montoCupones, BigDecimal montoCambio, String formaPago,
			String tipoDePago, boolean esReportarCNBV, String operacionCupones,
			String cuentaBancaria, String referenciaBancaria,
			int operacionBancaria, int pagosAdelantados, String medioRecepcion,
			int sucursalOrigen, int caja, String operador,
			Holder<EntCupon> cuponAImprimir, Holder<Double> montoComision,
			Holder<Double> montoDisponibleComision,
			Holder<String> fechaProximoPago, Holder<Boolean> esImprimirCupon,
			Holder<Double> capitalPago, Holder<Double> interesesPago,
			Holder<Double> moratoriosPago, Holder<Double> cobranzaPagos,
			Holder<Double> saldoPagos, Holder<Boolean> esRecalculoSaldo,
			Holder<Double> saldoActualPago, Holder<Boolean> esImprimirAbono,
			Holder<AplicarPagoForaneoResult> aplicarPagoForaneoResult) {

	}


	/**
	 * @param cadenaXML :
	 * @return AplicarVentaCarteraMasivaResult
	 */
	public AplicarVentaCarteraMasivaResult aplicarVentaCarteraMasiva(
			String cadenaXML) {
		return null;
	}

	/**
	 * @param contrato :
	 * @param operador :
	 * @return Resultado
	 */
	public Resultado cancelarVentaCartera(String contrato, String operador) {
		return null;
	}


	public PagoServiciosResult pagoServicios(String contrato, String formaPago,
			BigDecimal montoServicio, BigDecimal montoIvaServicio,
			int claveCliente, String claveServicio, BigDecimal montoComision,
			BigDecimal montoIvaComision, String lineaCaptura,
			String referencia1, String referencia2, String referencia3,
			String referencia4, String referencia5, String medioRecepcion,
			String operador, BigDecimal idOperacion, BigDecimal idCorte,
			int caja, int sucursal) {
		return null;
	}

	/**
	 * @param claveCliente :
	 * @param medioRecepcion :
	 * @param operador :
	 * @return ConsultaServiciosClienteResult
	 */
	public ConsultaServiciosClienteResult consultaServiciosCliente(
			int claveCliente, String medioRecepcion, String operador) {
		return null;
	}

	/**
	 * @param claveCliente :
	 * @param claveServicio :
	 * @param medioRecepcion :
	 * @param operador :
	 * @return ConsultaOpcionesServiciosClienteResult
	 */
	public ConsultaOpcionesServiciosClienteResult consultaOpcionesServiciosCliente(
			int claveCliente, String claveServicio, String medioRecepcion,
			String operador) {
		return null;
	}


	/**
	 * @param folioTransaccion :
	 * @param certificacion :
	 * @param medioRecepcion :
	 * @param operador :
	 * @param autoriza :
	 * @param caja :
	 * @param sucursalOrigen :
	 * @return Resultado
	 */
	public Resultado cancelaPagoServicios(String folioTransaccion,
			String certificacion, String medioRecepcion, String operador,
			String autoriza, int caja, int sucursalOrigen) {
		return null;
	}

	/**
	 * @return Sting
	 */
	public String consolidarSorteoFISA() {
		return null;
	}

	/**
	 * @param fechaConsulta :
	 * @param sucursal :
	 * @return ConsultaContratosRecoleccionResult
	 */
	public ConsultaContratosRecoleccionResult consultaContratosRecoleccion(
			Date fechaConsulta, int sucursal) {
		return null;
	}

	/**
	 * @param contrato :
	 * @param prefijo :
	 * @param cliente :
	 * @param ip :
	 * @param sucursalOrigen :
	 * @param usuario :
	 * @return Resultado
	 */
	public String consultaPagosTalonario(String contrato, String prefijo,
			int cliente, String ip, int sucursalOrigen, String usuario) {
		return null;
	}

	/**
	 * @param contrato :
	 * @param sucursalOrigen :
	 * @return String
	 */
	public String consultaClienteTalonario(String contrato, int sucursalOrigen) {
		return null;
	}

	/**
	 * @param contrato :
	 * @param sucursalCartera :
	 * @return String
	 */
	public String consultaSaldosContrato(String contrato, int sucursalCartera) {
		return null;
	}

	/**
	 * @param numeroTarjeta :
	 * @return ConsultaContratoDeTarjetaResult
	 */
	public ConsultaContratoDeTarjetaResult consultaContratoDeTarjeta(
			String numeroTarjeta) {
		return null;
	}

	/**
	 * @param contrato :
	 * @param numeroTransaccion :
	 * @param tipoOperacion :
	 * @param operador :
	 * @param sucursalOrigen :
	 * @param caja :
	 * @return Resultado
	 */
	public Resultado cancelarPagoReferenciado(String contrato,
			BigDecimal numeroTransaccion, String tipoOperacion,
			String operador, int sucursalOrigen, int caja) {
		return null;
	}

	/**
	 * @param referencia :
	 * @param sucursal :
	 * @param fechaContable :
	 * @return String
	 */
	public String consultaPagoServicios(String referencia, int sucursal,
			Date fechaContable) {
		return null;
	}

	/**
	 * @param numeroNIP :
	 * @param numeroTarjeta :
	 * @return BasicResponse
	 */
	public BasicResponse validarNIP(String numeroTarjeta, String numeroNIP) {
		return null;
	}

	/**
	 * @param numeroNIPActual :
	 * @param numeroTarjeta :
	 * @param numeroNIPNuevo :
	 * @return BasicResponse
	 */
	public BasicResponse cambiarNIP(String numeroTarjeta,
			String numeroNIPActual, String numeroNIPNuevo) {
		return null;
	}

	/**
	 * @param cadenaXML :
	 * @return String
	 */
	public String aplicarTransferenciaMasiva(String cadenaXML) {
		return null;
	}

	/**
	 * @param numeroTarjeta :
	 * @param numeroNIP :
	 * @return BasicResponse
	 */
	public BasicResponse asignarNIP(String numeroTarjeta, String numeroNIP) {
		return null;
	}

	/**
	 * @param numeroTarjeta :
	 * @return ActivaTarjetaResponseReturn
	 */
	public ActivaTarjetaResponseReturn activarTarjeta(String numeroTarjeta) {
		return null;
	}

	/**
	 * @return Resultado
	 */
	public Resultado aplicarPagosTarjetaErroneos() {
		return null;
	}

	/**
	 * @param numeroTarjeta :
	 * @return BloqueaTarjetaResponseReturn
	 */
	public BloqueaTarjetaResponseReturn bloquearTarjeta(String numeroTarjeta) {
		return null;
	}


	/**
	 * @param pagoGrupalObject :
	 * @return PagoGrupalResponse
	 */
	public PagoGrupalResponse aplicarPagoGrupal(PagoGrupal pagoGrupalObject) {
		String uid = GUIDGenerator.generateGUID(pagoGrupalObject);
		LogHandler.info(uid, getClass(), "aplicarPagoGrupal - Datos de entrada : " + pagoGrupalObject);

		//Salida
		final PagoGrupalResponse pagoGrupalResponse = pagos.aplicarPagoGrupal(uid, pagoGrupalObject);
		LogHandler.info(uid, getClass(), "aplicarPagoGrupal - Datos de salida : " + pagoGrupalResponse);

		if ( pagoGrupalResponse.isPromesaLiquidacion() ) {
			//Se limpia el id transaccion valido para evitar la validacion del pago duplicado.
			pagoGrupalObject.setIdTransaccionValida("");
			final 	AplicarPagoRespuesta
						aplicarGarantiaRespuesta =  pagos.aplicarGarantiaLiquidacion(pagoGrupalObject, uid);
			LogHandler.info(uid, getClass(), "aplicarPagoGrupal - Datos de salida (aplicarGarantiaRespuesta): "
						+ aplicarGarantiaRespuesta);
		}

		return pagoGrupalResponse;
	}

	/**
	 * @param peticion :
	 * @return CancelarMovimientosRespuesta
	 */
	public CancelarMovimientosRespuesta cancelarMovimientos(CancelarMovimientosPeticion peticion)
		{
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "cancelarMovimientos - Datos de entrada : " + peticion);

		//Salida
		final 	CancelarMovimientosRespuesta
				cancelarMovimientosRespuesta = pagos.cancelarMovimientos(peticion, uid);
		LogHandler.info(uid, getClass(), "cancelarMovimientos - Datos de salida : " + cancelarMovimientosRespuesta);
		return cancelarMovimientosRespuesta;
		}

	/**
	 * @param peticion :
	 * @return TraspasarPagoRespuesta
	 */
	public TraspasarPagoRespuesta traspasarPago(TraspasarPagoPeticion peticion) {
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "traspasarPago - Datos de entrada : " + peticion);

		//Salida
		final 	TraspasarPagoRespuesta
				traspasarPagoRespuesta = pagos.traspasarPago(peticion, uid);
		LogHandler.info(uid, getClass(), "traspasarPago - Datos de salida : " + traspasarPagoRespuesta);
		return traspasarPagoRespuesta;
		}

	/**
	 * Este m&eacute;todo se va a ocupar para pagos en linea.
	 * Esta operaci&oacute;n permite realizar el pago parcial o total del cliente,
	 * los pagos parciales se realizarán si el proveedor los acepta, esto aplica
	 * para OXXO.
	 * @param peticion :
	 * @return AplicarPagoRespuesta
	 */
	public AplicarPagoRespuesta aplicarPagoGrupalOperaciones(AplicarPagoPeticion peticion) {
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "aplicarPagoGrupalOperaciones - Datos de entrada : " + peticion);

		//Salida
		final 	AplicarPagoRespuesta
				aplicarPagoRespuesta = pagos.aplicarPagoGrupalOperaciones(peticion, null, uid);
		LogHandler.info(uid, getClass(), "aplicarPagoGrupalOperaciones - Datos de salida : " + aplicarPagoRespuesta);

		//ORIG-360 Cierre de Creditos con Pagos OXXO en Linea
		if ( aplicarPagoRespuesta.isPromesaLiquidacion()) {
			//Se limpia el id transaccion valido papa evitar la validacion del pago duplicado.
			PagoGrupal pagoGrupalObject = new PagoGrupal();
			pagoGrupalObject.setNumeroContrato(peticion.getNumeroContrato());
			pagoGrupalObject.setIdTransaccionValida("");
			pagoGrupalObject.setMonto(peticion.getMonto());
			pagoGrupalObject.setUsuario(peticion.getUsuario());
			final 	AplicarPagoRespuesta
						aplicarGarantiaRespuesta =  pagos.aplicarGarantiaLiquidacion(pagoGrupalObject, uid);
			LogHandler.info(uid, getClass(), "aplicarPagoGrupal - Datos de salida (aplicarGarantiaRespuesta): "
						+ aplicarGarantiaRespuesta);
		}
		return aplicarPagoRespuesta;
	}

	/**
	 *  @param peticion :
	 *  @return ActaRecaudacionRespuesta
	 */
	public ActaRecaudacionRespuesta capturaActaRecaudacion(ActaRecaudacionPeticion peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "capturaActaRecaudacion - Datos de entrada : " + peticion);

		// Salida
		final ActaRecaudacionRespuesta actaRecaudacionRespuesta = pagos.capturaActaRecaudacion(peticion, uid);
		LogHandler.info(uid, getClass(), "capturaActaRecaudacion - Datos de salida : " + actaRecaudacionRespuesta);
		return actaRecaudacionRespuesta;
	}

	/**
	 * @param peticion :
	 * @return String
	 */
	public String capturaActaRecaudacionXML(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "capturaActaRecaudacionXML - Datos de entradaXML : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ActaRecaudacionPeticion.class,
								   ActaRecaudacionOV.class,
                				   ActaRecaudacionParcialidadOV.class,
                				   ActaRecaudacionClienteOV.class,
                				   ActaRecaudacionRespuesta.class};

		ActaRecaudacionPeticion actaRecaudacionPeticion =
					(ActaRecaudacionPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "capturaActaRecaudacionXML - Datos de entrada : " + actaRecaudacionPeticion);

		// Salida
		final ActaRecaudacionRespuesta actaRecaudacionRespuesta = pagos.capturaActaRecaudacion(actaRecaudacionPeticion, uid);
		LogHandler.info(uid, getClass(), "capturaActaRecaudacionXML - Datos de salida : " + actaRecaudacionRespuesta);

		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, actaRecaudacionRespuesta, clases);
		LogHandler.info(uid, getClass(), "capturaActaRecaudacionXML - Datos de salida XML : " + respuestaXML);

		return respuestaXML;
	}


	/**
	 * @param peticion :
	 * @return AplicarPagoRespuesta
	 */
	public AplicarPagoRespuesta aplicarPagoConexia(AplicarPagoConexiaPeticion peticion) {

		final java.lang.String uid = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "aplicarPagoConexia - Datos de entrada : " + peticion);

		//Salida
		final 	AplicarPagoRespuesta
				aplicarPagoRespuesta =  pagos.aplicarPagoGrupalConexia(peticion, uid);
		LogHandler.info(uid, getClass(), "aplicarPagoConexia - Datos de salida : " + aplicarPagoRespuesta);
		return aplicarPagoRespuesta;
	}

	/**
	 * @param peticion :
	 * @return DatosConvenioRespuesta
	 */
	public DatosConvenioRespuesta buscarDatosConvenio(DatosConvenioPeticion peticion) {

		final java.lang.String uid = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "buscarDatosConvenio - Datos de entrada : " + peticion);

		//Salida
		final 	DatosConvenioRespuesta
				datosConvenioRespuesta = pagos.buscarDatosConvenio(peticion, uid);
		LogHandler.info(uid, getClass(), "buscarDatosConvenio - Datos de salida : " + datosConvenioRespuesta);
		return datosConvenioRespuesta;

	}

	/**
	 * @param peticion :
	 * @return DatosConvenioRespuesta
	 */
	public DatosConvenioRespuesta guardarDatosConvenio(ConvenioOV peticion) {
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "guardarDatosConvenio - Datos de entrada : " + peticion);

		//Salida
		final 	DatosConvenioRespuesta
				datosConvenioRespuesta = pagos.guardarDatosConvenio(peticion, uid);
		LogHandler.info(uid, getClass(), "guardarDatosConvenio - Datos de salida : " + datosConvenioRespuesta);
		return datosConvenioRespuesta;

	}

	/**
	 * @param peticion :
	 * @return AplicarPagoRespuesta
	 */
	public CancelarPagoConexiaRespuesta cancelarPagoConexia(CancelarPagoConexiaPeticion peticion) {

		final java.lang.String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "cancelarPagoConexia - Datos de entrada : " + peticion);
        //Salida
        final 	CancelarPagoConexiaRespuesta
                cancelarPagoConexiaRespuesta =  pagos.cancelarPagoConexiaTarea(peticion, uid);
        LogHandler.info(uid, getClass(), "cancelarPagoConexia - Datos de salida : " + cancelarPagoConexiaRespuesta);
        return cancelarPagoConexiaRespuesta;
	}

	/**
	 * @param peticion :
	 * @return AplicarPagoServicioRespuesta
	 */
	public AplicarPagoServicioRespuesta aplicarPagoServicio(PagoServicioPeticion peticion) {

		final java.lang.String uid = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "aplicarPagoServicio - Datos de entrada : " + peticion);

		//Salida
		final 	AplicarPagoServicioRespuesta
				respuesta =  pagos.aplicarPagoServicio(peticion, uid);
		LogHandler.info(uid, getClass(), "aplicarPagoServicio - Datos de salida : " + respuesta);
		return respuesta;
	}

	/**
	 * @param peticion :
	 * @return AplicarPagoRespuesta
	 */
	public AplicarPagoRespuesta validacionPagoConvenio(AplicarPagoConexiaPeticion peticion) {

		final java.lang.String uid = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "validacionPagoConvenio - Datos de entrada : " + peticion);

		//Salida
		final 	AplicarPagoRespuesta
				aplicarPagoRespuesta =  pagos.validacionPagoConvenio(peticion, uid);
		LogHandler.info(uid, getClass(), "validacionPagoConvenio - Datos de salida : " + aplicarPagoRespuesta);
		return aplicarPagoRespuesta;
	}

	/**
	 * @param peticion :
	 * @return AplicarPagoRespuesta
	 */
	public CancelarPagoConexiaRespuesta validacionCancelacionPagoConvenio(CancelarPagoConexiaPeticion peticion) {

		final java.lang.String uid = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "validacionCancelacionPagoConvenio - Datos de entrada : " + peticion);

		//Salida
		final 	CancelarPagoConexiaRespuesta
		cancelarPagoConexiaRespuesta =  pagos.validacionCancelacionPagoConvenio(peticion, uid);
		LogHandler.info(uid, getClass(), "validacionCancelacionPagoConvenio - Datos de salida : " + cancelarPagoConexiaRespuesta);
		return cancelarPagoConexiaRespuesta;
	}

	/**
	 * @param peticion :
	 * @return AplicarPagoRespuesta
	 */
	public AplicarPagoRespuesta aplicarGarantiaLiquidacion(PagoGrupal peticion) {

		final java.lang.String uid = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "aplicarGarantiaLiquidacion - Datos de entrada : " + peticion);

		//Salida
		final 	AplicarPagoRespuesta
			aplicarGarantiaRespuesta =  pagos.aplicarGarantiaLiquidacion(peticion, uid);
		LogHandler.info(uid, getClass(), "aplicarGarantiaLiquidacion - Datos de salida : " + aplicarGarantiaRespuesta);
		return aplicarGarantiaRespuesta;

	}

	/**
	 * Esta operaci&oacute;n permite cancelar el pago realizado por problemas dentro de la plataforma de
	 * pago de servicios en l&iacute;nea.
	 * Esta operaci&oacute;n es s&oacute;lo por sistema ante fallas en el protocolo de comunicaci&oacute;n
	 * @param peticion datos del pago.
	 * @param uid identificador &uacute;nico de transacci&oacute;n.
	 * @return RespuestaReverseEnLineaOxxo respuesta.
	 */
	public RespuestaReverseEnLineaOxxo cancelarPagoEnLineaOxxo(String uid, PeticionEnLineaOxxo peticion) {

		LogHandler.info(uid, getClass(), "cancelarPagoEnLineaOxxo - Datos de entrada: " + peticion);

		//Salida
		final RespuestaReverseEnLineaOxxo
			respuestaReverseEnLineaOxxo = pagos.cancelarPagoEnLineaOxxoTarea(uid, peticion);
		LogHandler.info(uid, getClass(), "cancelarPagoEnLineaOxxo - Datos de Salida : "  + respuestaReverseEnLineaOxxo);
		return respuestaReverseEnLineaOxxo;

	}

	/**
	 * Esta operaci&oacute;n permite cancelar el pago realizado por problemas dentro de la plataforma de
	 * pago de servicios en l&iacute;nea.
	 * Esta operaci&oacute;n es s&oacute;lo por sistema ante fallas en el protocolo de comunicaci&oacute;n
	 * @param peticion datos del pago.
	 * @param uid identificador &uacute;nico de transacci&oacute;n.
	 * @return RespuestaReverseEnLineaOxxo respuesta.
	 */
	public CancelarPagoConexiaRespuesta cancelarPagoEnLinea(String uid, CancelarPagoConexiaPeticion peticion) {

		LogHandler.info(uid, getClass(), "cancelarPagoEnLineaOxxo - Datos de entrada: " + peticion);

		//Salida
		final CancelarPagoConexiaRespuesta
			  cancelarPagoConexiaRespuesta = pagos.cancelarPagoEnLineaTarea(uid, peticion, null);
		LogHandler.info(uid, getClass(), "cancelarPagoEnLineaTarea - Datos de Salida : "  + cancelarPagoConexiaRespuesta);
		return cancelarPagoConexiaRespuesta;

	}

	/**
	 * @param peticion :
	 * @return AplicarPagoRespuesta
	 */
	public CancelarPagoConexiaRespuesta cancelarPagoGarantia(CancelarPagoConexiaPeticion peticion) {

		final java.lang.String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "cancelarPagoGarantia - Datos de entrada : " + peticion);
        //Salida
        final 	CancelarPagoConexiaRespuesta
                cancelarPagoConexiaRespuesta =  pagos.cancelarPagoGarantiaTarea(peticion, uid);
        LogHandler.info(uid, getClass(), "cancelarPagoGarantia - Datos de salida : " + cancelarPagoConexiaRespuesta);
        return cancelarPagoConexiaRespuesta;
	}

	/**
	 * Metodo para consultar el universo de pagos no conciliados
	 * @param peticion filtros de la busqueda
	 * @return el universo de pagos
	 */
	public ConsultarPagosRespuesta consultarPagosNoConciliados(ConsultarPagosPeticion peticion) {
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "consultarPagosNoConciliados - Datos de entrada : " + peticion);
        //Salida
        final 	ConsultarPagosRespuesta
                respuesta =  pagos.consultarPagosNoConciliados(uid, peticion);
        LogHandler.info(uid, getClass(), "consultarPagosNoConciliados - Datos de salida : " + respuesta);
        return respuesta;
	}

	/**
	 * Metodo para consultar el universo de pagos no conciliados
	 * @param peticion filtros de la busqueda
	 * @return el universo de pagos
	 */
	public RespuestaConciliarPagos aplicarPagosNoConciliados(List<PagoDTO> peticion) {
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "consultarPagosNoConciliados - Datos de entrada : " + peticion);
        //Salida
        final 	RespuestaConciliarPagos
                respuesta =  pagos.aplicarPagosNoConciliados(uid, peticion);
        LogHandler.info(uid, getClass(), "consultarPagosNoConciliados - Datos de salida : " + respuesta);
        return respuesta;
	}

	public ConsultarPagosLineaRespuesta consultarPagosLineaDuplicados(ConsultarPagosPeticion peticion) {
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "consultarPagosLineaDuplicados - Datos de entrada : " + peticion);
        //Salida
        final 	ConsultarPagosLineaRespuesta
                respuesta =  pagos.consultarPagosLineaDuplicados(uid, peticion);
        LogHandler.info(uid, getClass(), "consultarPagosLineaDuplicados - Datos de salida : " + respuesta);
        return respuesta;
	}

	public ReversarPagoOxxoRespuesta reversarPagoOxxo(ReversarPagoOxxoPeticion peticion) {
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "reversarPagoOxxo - Datos de entrada : " + peticion);
        //Salida
        final 	ReversarPagoOxxoRespuesta
                respuesta =  pagos.reversarPagoOxxo(uid, peticion);
        LogHandler.info(uid, getClass(), "reversarPagoOxxo - Datos de salida : " + respuesta);
        return respuesta;
	}

	public AlmacenarArchivoOxxoRespuesta almacenarArchivoOxxo(AlmacenarArchivoOxxoPeticion peticion) {
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "almacenarArchivoOxxo - Datos de entrada : " + peticion);
        //Salida
        final 	AlmacenarArchivoOxxoRespuesta
                respuesta =  pagos.almacenarArchivoOxxo(uid, peticion);
        LogHandler.info(uid, getClass(), "almacenarArchivoOxxo - Datos de salida : " + respuesta);
        return respuesta;
	}
	public ConsultarPagosLineaRespuesta consultarPagosLineaNoEncontrados(ConsultarPagosPeticion peticion) {
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "consultarPagosLineaNoEncontrados - Datos de entrada : " + peticion);
        //Salida
        final 	ConsultarPagosLineaRespuesta
                respuesta =  pagos.consultarPagosLineaNoEncontrados(uid, peticion);
        LogHandler.info(uid, getClass(), "consultarPagosLineaNoEncontrados - Datos de salida : " + respuesta);
        return respuesta;
	}

	/**
	 * Metodo que se utiliza para consultar el traspaso de Pagos
	 *
	 * @param uid Identificador Unico
	 * @param peticion TraspasoPagosPeticion
	 * @return TraspasoPagosRespuesta
	 */
	public TraspasoPagosRespuesta consultarTraspasoPagos(String uid, TraspasoPagosPeticion peticion) {
		LogHandler.info(uid, getClass(), "consultarTraspasoPagos - Datos de entrada : " + peticion);
        //Salida
        final 	TraspasoPagosRespuesta
                respuesta =  pagos.consultarTraspasoPagosTarea(uid, peticion);
        LogHandler.info(uid, getClass(), "consultarTraspasoPagos - Datos de salida : " + respuesta);
        return respuesta;
	}

	/**
	 * Este m&eacute;todo se va a ocupar para aplicar los pagos en linea de la nube.
	 * Esta operaci&oacute;n permite realizar el pago parcial o total del cliente,
	 * los pagos parciales se realizarán si el proveedor los acepta, esto aplica
	 * para OXXO.
	 * @param peticion :
	 * @return AplicarPagoRespuesta
	 */
	public AplicarPagoRespuesta aplicarTransaccionPagoEnLinea(AplicarPagoLineaPeticion peticion) {
		final java.lang.String uid = peticion.getIdTransaccion();
		LogHandler.info(uid, getClass(), "aplicarTransaccionPagoEnLinea - Datos de entrada : " + peticion);
		//Salida
		final 	AplicarPagoRespuesta
				aplicarPagoRespuesta = pagos.aplicarTransaccionPagoEnLinea(uid, peticion);
		LogHandler.info(uid, getClass(), "aplicarTransaccionPagoEnLinea - Datos de salida : " + aplicarPagoRespuesta);
		return aplicarPagoRespuesta;
	}
}
