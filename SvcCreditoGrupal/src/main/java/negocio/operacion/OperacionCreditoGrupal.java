
package negocio.operacion;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Holder;

import utilitario.mensajes.convenio.ConvenioOV;
import utilitario.mensajes.convenio.DatosConvenioPeticion;
import utilitario.mensajes.convenio.DatosConvenioRespuesta;
import utilitario.mensajes.operacion.ActaRecaudacionPeticion;
import utilitario.mensajes.operacion.ActaRecaudacionRespuesta;
import utilitario.mensajes.operacion.TraspasoPagosPeticion;
import utilitario.mensajes.operacion.TraspasoPagosRespuesta;
import utilitario.mensajes.operacion.pagos.ActivaTarjetaResponseReturn;
import utilitario.mensajes.operacion.pagos.AlmacenarArchivoOxxoPeticion;
import utilitario.mensajes.operacion.pagos.AlmacenarArchivoOxxoRespuesta;
import utilitario.mensajes.operacion.pagos.AplicarPagoConexiaPeticion;
import utilitario.mensajes.operacion.pagos.AplicarPagoLineaPeticion;
import utilitario.mensajes.operacion.pagos.AplicarPagoPeticion;
import utilitario.mensajes.operacion.pagos.AplicarPagoRespuesta;
import utilitario.mensajes.operacion.pagos.AplicarPagoServicioRespuesta;
import utilitario.mensajes.operacion.pagos.BasicResponse;
import utilitario.mensajes.operacion.pagos.BloqueaTarjetaResponseReturn;
import utilitario.mensajes.operacion.pagos.CancelarMovimientosPeticion;
import utilitario.mensajes.operacion.pagos.CancelarMovimientosRespuesta;
import utilitario.mensajes.operacion.pagos.CancelarPagoConexiaPeticion;
import utilitario.mensajes.operacion.pagos.CancelarPagoConexiaRespuesta;
import utilitario.mensajes.operacion.pagos.ConsultarPagosLineaRespuesta;
import utilitario.mensajes.operacion.pagos.ConsultarPagosPeticion;
import utilitario.mensajes.operacion.pagos.ConsultarPagosRespuesta;
import utilitario.mensajes.operacion.pagos.EntContrato;
import utilitario.mensajes.operacion.pagos.EntCupon;
import utilitario.mensajes.operacion.pagos.PagoDTO;
import utilitario.mensajes.operacion.pagos.PagoGrupal;
import utilitario.mensajes.operacion.pagos.PagoGrupalResponse;
import utilitario.mensajes.operacion.pagos.PagoServicioPeticion;
import utilitario.mensajes.operacion.pagos.RespuestaConciliarPagos;
import utilitario.mensajes.operacion.pagos.Resultado;
import utilitario.mensajes.operacion.pagos.ReversarPagoOxxoPeticion;
import utilitario.mensajes.operacion.pagos.ReversarPagoOxxoRespuesta;
import utilitario.mensajes.operacion.pagos.TraspasarPagoPeticion;
import utilitario.mensajes.operacion.pagos.TraspasarPagoRespuesta;
import utilitario.mensajes.operacion.pagos.oxxo.PeticionEnLineaOxxo;
import utilitario.mensajes.operacion.pagos.oxxo.RespuestaReverseEnLineaOxxo;

/**
 * @version 1.0.0
 * @author mi.mejorada
 *
 */
@WebService(name = "WSOperacionesCajaSoap", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0")
public interface OperacionCreditoGrupal {


    /**
     *
     * @param referenciaTC :
     * @param codigoServicio :
     * @param numeroOperacion :
     * @param numeroCuenta :
     * @param sucursalOrigen :
     * @param operador :
     * @param fechaValor :
     * @param caja :
     * @param contrato :
     * @param montoRecibido :
     * @param numeroReferencia :
     * @param tipoOperacion :
     * @param medioPago :
     * @param ubicacion :
     * @return
     *     returns utilitario.mensajes.operacion.pagos.Resultado
     */
    public Resultado aplicarPago(
        @WebParam(name = "contrato", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPago")
        String contrato,
        @WebParam(name = "montoRecibido", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPago")
        BigDecimal montoRecibido,
        @WebParam(name = "caja", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPago")
        int caja,
        @WebParam(name = "operador", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPago")
        String operador,
        @WebParam(name = "tipoOperacion", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPago")
        String tipoOperacion,
        @WebParam(name = "numeroCuenta", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPago")
        String numeroCuenta,
        @WebParam(name = "numeroReferencia", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPago")
        String numeroReferencia,
        @WebParam(name = "numeroOperacion", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPago")
        BigDecimal numeroOperacion,
        @WebParam(name = "sucursalOrigen", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPago")
        int sucursalOrigen,
        @WebParam(name = "ubicacion", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPago")
        int ubicacion,
        @WebParam(name = "fechaValor", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPago")
        Date fechaValor,
        @WebParam(name = "medioPago", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPago")
        String medioPago,
        @WebParam(name = "codigoServicio", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPago")
        String codigoServicio,
        @WebParam(name = "referenciaTC", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPago")
        String referenciaTC);

    /**
     *
     * @param cadenaXML :
     * @return
     *     returns java.lang.String
     */
    public String aplicarPagoMasivo(
        @WebParam(name = "cadenaXML", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoMasivo")
        String cadenaXML);

    /**
     *
     * @param cadenaXML :
     * @return
     *     returns java.lang.String
     */
    public String aplicarCargoMasivo(
        @WebParam(name = "cadenaXML", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarCargoMasivo")
        String cadenaXML);

    /**
     *
     * @param numeroTransaccion :
     * @param sucursalOrigen :
     * @param tipoOperacion :
     * @param operador :
     * @param caja :
     * @param contrato :
     * @return
     *     returns utilitario.mensajes.operacion.pagos.Resultado
     */
    public Resultado cancelarPago(
        @WebParam(name = "contrato", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cancelarPago")
        String contrato,
        @WebParam(name = "numeroTransaccion",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cancelarPago")
        BigDecimal numeroTransaccion,
        @WebParam(name = "tipoOperacion", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cancelarPago")
        String tipoOperacion,
        @WebParam(name = "operador", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cancelarPago")
        String operador,
        @WebParam(name = "sucursalOrigen", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cancelarPago")
        int sucursalOrigen,
        @WebParam(name = "caja", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cancelarPago")
        int caja);

    /**
     *
     * @param contrato :
     * @return
     *     returns utilitario.mensajes.operacion.pagos.EntContrato
     */
    public EntContrato consultarInformacionContrato(
        @WebParam(name = "contrato",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultarInformacionContrato")
        String contrato);

    /**
     *
     * @param moratoriosPago :
     * @param esImprimirAbono :
     * @param operacionCupones :
     * @param caja :
     * @param montoCupones :
     * @param contrato :
     * @param capitalPago :
     * @param cuentaBancaria :
     * @param saldoActualPago :
     * @param montoRecibido :
     * @param saldoPagos :
     * @param tipoDePago :
     * @param fechaProximoPago :
     * @param cobranzaPagos :
     * @param montoDisponibleComision :
     * @param esReportarCNBV :
     * @param montoCambio :
     * @param idtrxcaja :
     * @param medioRecepcion :
     * @param interesesPago :
     * @param formaPago :
     * @param esImprimirCupon :
     * @param sucursalOrigen :
     * @param operador :
     * @param aplicarPagoForaneoResult :
     * @param pagosAdelantados :
     * @param referenciaBancaria :
     * @param cuponAImprimir :
     * @param operacionBancaria :
     * @param montoAPagar :
     * @param esRecalculoSaldo :
     * @param montoComision :
     */
    public void aplicarPagoForaneo(
        @WebParam(name = "idtrxcaja", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo")
        BigDecimal idtrxcaja,
        @WebParam(name = "contrato", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo")
        String contrato,
        @WebParam(name = "montoAPagar",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo")
        BigDecimal montoAPagar,
        @WebParam(name = "montoRecibido",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo")
        BigDecimal montoRecibido,
        @WebParam(name = "montoCupones",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo")
        BigDecimal montoCupones,
        @WebParam(name = "montoCambio",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo")
        BigDecimal montoCambio,
        @WebParam(name = "formaPago", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo")
        String formaPago,
        @WebParam(name = "tipoDePago", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo")
        String tipoDePago,
        @WebParam(name = "esReportarCNBV",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo")
        boolean esReportarCNBV,
        @WebParam(name = "operacionCupones",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo")
        String operacionCupones,
        @WebParam(name = "cuentaBancaria",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo")
        String cuentaBancaria,
        @WebParam(name = "referenciaBancaria",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo")
        String referenciaBancaria,
        @WebParam(name = "operacionBancaria",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo")
        int operacionBancaria,
        @WebParam(name = "pagosAdelantados",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo")
        int pagosAdelantados,
        @WebParam(name = "medioRecepcion",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo")
        String medioRecepcion,
        @WebParam(name = "sucursalOrigen",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo")
        int sucursalOrigen,
        @WebParam(name = "caja", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo")
        int caja,
        @WebParam(name = "operador", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo")
        String operador,
        @WebParam(name = "cuponAImprimir",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo", mode = WebParam.Mode.INOUT)
        Holder<EntCupon> cuponAImprimir,
        @WebParam(name = "montoComision",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo", mode = WebParam.Mode.INOUT)
        Holder<Double> montoComision,
        @WebParam(name = "montoDisponibleComision",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo", mode = WebParam.Mode.INOUT)
        Holder<Double> montoDisponibleComision,
        @WebParam(name = "fechaProximoPago",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo", mode = WebParam.Mode.INOUT)
        Holder<String> fechaProximoPago,
        @WebParam(name = "esImprimirCupon",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo", mode = WebParam.Mode.INOUT)
        Holder<Boolean> esImprimirCupon,
        @WebParam(name = "capitalPago",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo", mode = WebParam.Mode.INOUT)
        Holder<Double> capitalPago,
        @WebParam(name = "interesesPago",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo", mode = WebParam.Mode.INOUT)
        Holder<Double> interesesPago,
        @WebParam(name = "moratoriosPago",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo", mode = WebParam.Mode.INOUT)
        Holder<Double> moratoriosPago,
        @WebParam(name = "cobranzaPagos",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo", mode = WebParam.Mode.INOUT)
        Holder<Double> cobranzaPagos,
        @WebParam(name = "saldoPagos",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo", mode = WebParam.Mode.INOUT)
        Holder<Double> saldoPagos,
        @WebParam(name = "esRecalculoSaldo",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo", mode = WebParam.Mode.INOUT)
        Holder<Boolean> esRecalculoSaldo,
        @WebParam(name = "saldoActualPago",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo", mode = WebParam.Mode.INOUT)
        Holder<Double> saldoActualPago,
        @WebParam(name = "esImprimirAbono",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo", mode = WebParam.Mode.INOUT)
        Holder<Boolean> esImprimirAbono,
        @WebParam(name = "AplicarPagoForaneoResult",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarPagoForaneo", mode = WebParam.Mode.OUT)
        Holder<utilitario.mensajes.operacion.pagos.AplicarPagoForaneoResponse.AplicarPagoForaneoResult> aplicarPagoForaneoResult);

    /**
     *
     * @param cadenaXML :
     * @return
     *     returns utilitario.mensajes.operacion.pagos.AplicarVentaCarteraMasivaResponse.AplicarVentaCarteraMasivaResult
     */
    public utilitario.mensajes.operacion.pagos.AplicarVentaCarteraMasivaResponse.AplicarVentaCarteraMasivaResult
    	aplicarVentaCarteraMasiva(
        @WebParam(name = "cadenaXML",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarVentaCarteraMasiva")
        String cadenaXML);

    /**
     *
     * @param operador :
     * @param contrato :
     * @return
     *     returns utilitario.mensajes.operacion.pagos.Resultado
     */
    public Resultado cancelarVentaCartera(
        @WebParam(name = "contrato", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cancelarVentaCartera")
        String contrato,
        @WebParam(name = "operador", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cancelarVentaCartera")
        String operador);

    /**
     *
     * @param sucursal :
     * @param montoIvaComision :
     * @param medioRecepcion :
     * @param formaPago :
     * @param idCorte :
     * @param claveServicio :
     * @param operador :
     * @param referencia3 :
     * @param idOperacion :
     * @param referencia2 :
     * @param caja :
     * @param referencia5 :
     * @param contrato :
     * @param referencia4 :
     * @param montoIvaServicio :
     * @param lineaCaptura :
     * @param montoServicio :
     * @param referencia1 :
     * @param claveCliente :
     * @param montoComision :
     * @return
     *     returns utilitario.mensajes.operacion.pagos.PagoServiciosResponse.PagoServiciosResult
     */
    public utilitario.mensajes.operacion.pagos.PagoServiciosResponse.PagoServiciosResult pagoServicios(
        @WebParam(name = "contrato", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/pagoServicios")
        String contrato,
        @WebParam(name = "formaPago", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/pagoServicios")
        String formaPago,
        @WebParam(name = "montoServicio", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/pagoServicios")
        BigDecimal montoServicio,
        @WebParam(name = "montoIvaServicio",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/pagoServicios")
        BigDecimal montoIvaServicio,
        @WebParam(name = "claveCliente", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/pagoServicios")
        int claveCliente,
        @WebParam(name = "claveServicio", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/pagoServicios")
        String claveServicio,
        @WebParam(name = "montoComision", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/pagoServicios")
        BigDecimal montoComision,
        @WebParam(name = "montoIvaComision",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/pagoServicios")
        BigDecimal montoIvaComision,
        @WebParam(name = "lineaCaptura", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/pagoServicios")
        String lineaCaptura,
        @WebParam(name = "referencia1", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/pagoServicios")
        String referencia1,
        @WebParam(name = "referencia2", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/pagoServicios")
        String referencia2,
        @WebParam(name = "referencia3", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/pagoServicios")
        String referencia3,
        @WebParam(name = "referencia4", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/pagoServicios")
        String referencia4,
        @WebParam(name = "referencia5", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/pagoServicios")
        String referencia5,
        @WebParam(name = "medioRecepcion", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/pagoServicios")
        String medioRecepcion,
        @WebParam(name = "operador", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/pagoServicios")
        String operador,
        @WebParam(name = "idOperacion", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/pagoServicios")
        BigDecimal idOperacion,
        @WebParam(name = "idCorte", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/pagoServicios")
        BigDecimal idCorte,
        @WebParam(name = "caja", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/pagoServicios")
        int caja,
        @WebParam(name = "sucursal", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/pagoServicios")
        int sucursal);

    /**
     *
     * @param medioRecepcion :
     * @param operador :
     * @param claveCliente :
     * @return
     *     returns utilitario.mensajes.operacion.pagos.ConsultaServiciosClienteResponse.ConsultaServiciosClienteResult
     */
    public utilitario.mensajes.operacion.pagos.ConsultaServiciosClienteResponse.ConsultaServiciosClienteResult
    consultaServiciosCliente(
        @WebParam(name = "claveCliente",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultaServiciosCliente")
        int claveCliente,
        @WebParam(name = "medioRecepcion",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultaServiciosCliente")
        String medioRecepcion,
        @WebParam(name = "operador",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultaServiciosCliente")
        String operador);

    /**
     *
     * @param medioRecepcion :
     * @param claveServicio :
     * @param operador :
     * @param claveCliente :
     * @return
     *     returns ConsultaOpcionesServiciosClienteResult
     */
    public utilitario.mensajes.operacion.pagos.ConsultaOpcionesServiciosClienteResponse.ConsultaOpcionesServiciosClienteResult
    consultaOpcionesServiciosCliente(
        @WebParam(name = "claveCliente",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultaOpcionesServiciosCliente")
        int claveCliente,
        @WebParam(name = "claveServicio",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultaOpcionesServiciosCliente")
        String claveServicio,
        @WebParam(name = "medioRecepcion",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultaOpcionesServiciosCliente")
        String medioRecepcion,
        @WebParam(name = "operador",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultaOpcionesServiciosCliente")
        String operador);

    /**
     *
     * @param medioRecepcion :
     * @param folioTransaccion :
     * @param certificacion :
     * @param sucursalOrigen :
     * @param operador :
     * @param autoriza :
     * @param caja :
     * @return
     *     returns utilitario.mensajes.operacion.pagos.Resultado
     */
    public Resultado cancelaPagoServicios(
        @WebParam(name = "folioTransaccion",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cancelaPagoServicios")
        String folioTransaccion,
        @WebParam(name = "certificacion",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cancelaPagoServicios")
        String certificacion,
        @WebParam(name = "medioRecepcion",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cancelaPagoServicios")
        String medioRecepcion,
        @WebParam(name = "operador", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cancelaPagoServicios")
        String operador,
        @WebParam(name = "autoriza", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cancelaPagoServicios")
        String autoriza,
        @WebParam(name = "caja", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cancelaPagoServicios")
        int caja,
        @WebParam(name = "sucursalOrigen",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cancelaPagoServicios")
        int sucursalOrigen);

    /**
     *
     * @return
     *     returns java.lang.String
     */
    public String consolidarSorteoFISA();

    /**
     *
     * @param sucursal :
     * @param fechaConsulta :
     * @return
     *     returns utilitario.mensajes.operacion.pagos.ConsultaContratosRecoleccionResponse.ConsultaContratosRecoleccionResult
     */
    public utilitario.mensajes.operacion.pagos.ConsultaContratosRecoleccionResponse.ConsultaContratosRecoleccionResult
    consultaContratosRecoleccion(
        @WebParam(name = "fechaConsulta",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultaContratosRecoleccion")
        Date fechaConsulta,
        @WebParam(name = "sucursal",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultaContratosRecoleccion")
        int sucursal);

    /**
     *
     * @param usuario :
     * @param cliente :
     * @param sucursalOrigen :
     * @param prefijo :
     * @param ip :
     * @param contrato :
     * @return
     *     returns java.lang.String
     */
    public String consultaPagosTalonario(
        @WebParam(name = "contrato",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultaPagosTalonario")
        String contrato,
        @WebParam(name = "prefijo",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultaPagosTalonario")
        String prefijo,
        @WebParam(name = "cliente",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultaPagosTalonario")
        int cliente,
        @WebParam(name = "ip", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultaPagosTalonario")
        String ip,
        @WebParam(name = "sucursalOrigen",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultaPagosTalonario")
        int sucursalOrigen,
        @WebParam(name = "usuario",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultaPagosTalonario")
        String usuario);

    /**
     *
     * @param sucursalOrigen :
     * @param contrato :
     * @return
     *     returns java.lang.String
     */
    public String consultaClienteTalonario(
        @WebParam(name = "contrato",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultaClienteTalonario")
        String contrato,
        @WebParam(name = "sucursalOrigen",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultaClienteTalonario")
        int sucursalOrigen);

    /**
     *
     * @param sucursalCartera :
     * @param contrato :
     * @return
     *     returns java.lang.String
     */
    public String consultaSaldosContrato(
        @WebParam(name = "contrato",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultaSaldosContrato")
        String contrato,
        @WebParam(name = "sucursalCartera",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultaSaldosContrato")
        int sucursalCartera);

    /**
     *
     * @param numeroTarjeta :
     * @return
     *     returns utilitario.mensajes.operacion.pagos.ConsultaContratoDeTarjetaResponse.ConsultaContratoDeTarjetaResult
     */
    public utilitario.mensajes.operacion.pagos.ConsultaContratoDeTarjetaResponse.ConsultaContratoDeTarjetaResult
    consultaContratoDeTarjeta(
        @WebParam(name = "numeroTarjeta",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultaContratoDeTarjeta")
        String numeroTarjeta);

    /**
     *
     * @param numeroTransaccion :
     * @param sucursalOrigen :
     * @param tipoOperacion :
     * @param operador :
     * @param caja :
     * @param contrato :
     * @return
     *     returns utilitario.mensajes.operacion.pagos.Resultado
     */
    public Resultado cancelarPagoReferenciado(
        @WebParam(name = "contrato",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cancelarPagoReferenciado")
        String contrato,
        @WebParam(name = "numeroTransaccion",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cancelarPagoReferenciado")
        BigDecimal numeroTransaccion,
        @WebParam(name = "tipoOperacion",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cancelarPagoReferenciado")
        String tipoOperacion,
        @WebParam(name = "operador",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cancelarPagoReferenciado")
        String operador,
        @WebParam(name = "sucursalOrigen",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cancelarPagoReferenciado")
        int sucursalOrigen,
        @WebParam(name = "caja", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cancelarPagoReferenciado")
        int caja);

    /**
     *
     * @param sucursal :
     * @param fechaContable :
     * @param referencia :
     * @return
     *     returns java.lang.String
     */
    public String consultaPagoServicios(
        @WebParam(name = "referencia",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultaPagoServicios")
        String referencia,
        @WebParam(name = "sucursal",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultaPagoServicios")
        int sucursal,
        @WebParam(name = "fechaContable",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/consultaPagoServicios")
        Date fechaContable);

    /**
     *
     * @param numeroNIP :
     * @param numeroTarjeta :
     * @return
     *     returns utilitario.mensajes.operacion.pagos.BasicResponse
     */
    public BasicResponse validarNIP(
        @WebParam(name = "numeroTarjeta", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/validarNIP")
        String numeroTarjeta,
        @WebParam(name = "numeroNIP", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/validarNIP")
        String numeroNIP);

    /**
     *
     * @param numeroNIPActual :
     * @param numeroTarjeta :
     * @param numeroNIPNuevo :
     * @return
     *     returns utilitario.mensajes.operacion.pagos.BasicResponse
     */
    public BasicResponse cambiarNIP(
        @WebParam(name = "numeroTarjeta", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cambiarNIP")
        String numeroTarjeta,
        @WebParam(name = "numeroNIPActual", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cambiarNIP")
        String numeroNIPActual,
        @WebParam(name = "numeroNIPNuevo", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cambiarNIP")
        String numeroNIPNuevo);

    /**
     *
     * @param cadenaXML :
     * @return
     *     returns java.lang.String
     */
   public String aplicarTransferenciaMasiva(
        @WebParam(name = "cadenaXML",
        targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/aplicarTransferenciaMasiva")
        String cadenaXML);

    /**
     *
     * @param numeroNIP :
     * @param numeroTarjeta :
     * @return
     *     returns utilitario.mensajes.operacion.pagos.BasicResponse
     */
    public BasicResponse asignarNIP(
        @WebParam(name = "numeroTarjeta", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/asignarNIP")
        String numeroTarjeta,
        @WebParam(name = "numeroNIP", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/asignarNIP")
        String numeroNIP);

    /**
     *
     * @param numeroTarjeta :
     * @return
     *     returns utilitario.mensajes.operacion.pagos.ActivaTarjetaResponseReturn
     */
   public ActivaTarjetaResponseReturn activarTarjeta(
        @WebParam(name = "numeroTarjeta", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/activarTarjeta")
        String numeroTarjeta);

    /**
     *
     * @return
     *     returns utilitario.mensajes.operacion.pagos.Resultado
     */
    public Resultado aplicarPagosTarjetaErroneos();

    /**
     *
     * @param numeroTarjeta :
     * @return
     *     returns utilitario.mensajes.operacion.pagos.BloqueaTarjetaResponseReturn
     */
     public BloqueaTarjetaResponseReturn bloquearTarjeta(
        @WebParam(name = "numeroTarjeta", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/bloquearTarjeta")
        String numeroTarjeta);

    /**
     * Aplica un pago Grupal
     * @param pagoGrupalObject contiene los datos necesarios para realizar el pago
     * @return
     *     returns utilitario.mensajes.operacion.pagos.PagoGrupalResponse resutlado de la operacion
     */
    public PagoGrupalResponse aplicarPagoGrupal(
        @WebParam(name = "PagoGrupalObject", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/")
        PagoGrupal pagoGrupalObject);

    /**
	 * Metodo para realizar la cancelacion de uno o mas movimientos en un
	 * contrato especifico
	 * @param peticion :
	 * @return CancelarMovimientosRespuesta
	 */
	public CancelarMovimientosRespuesta cancelarMovimientos(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/cancelarMovimientos")
			CancelarMovimientosPeticion peticion);

	/**
	 * Metodo para realizar la cancelacion de cieroto pago y aplicarlo a otro contrato
	 * @param peticion :
	 * @return TraspasarPagoRespuesta
	 */
	public TraspasarPagoRespuesta traspasarPago(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/traspasarPago")
			TraspasarPagoPeticion peticion);

	/**
	 * Metodo para aplicar un pago, esta funcion se usa fuera de la importacion de pagos
	 * @param peticion :
	 * @return AplicarPagoRespuesta
	 */
	public AplicarPagoRespuesta aplicarPagoGrupalOperaciones(
	        @WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/")
	        AplicarPagoPeticion peticion);

	/**
	 * Metodo que realiza la captura de un Acta de Recaudaci&oacute;n ya sea de tipo Objeto Valor o XML.
	 * @author ISC Omar CC (ocruzc)
	 * @param peticion {@link ActaRecaudacionPeticion} solicitud de captura.
	 * @return {@link ActaRecaudacionRespuesta} respuesta a Captura.
	 */
	public ActaRecaudacionRespuesta capturaActaRecaudacion(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/capturaActaRecaudacion")
			ActaRecaudacionPeticion peticion);

	/**
	 * Metodo que realiza la captura de un Acta de Recaudaci&oacute;n ya sea de tipo Objeto Valor o XML.
	 * @author ISC Omar CC (ocruzc)
	 * @param peticion {@link ActaRecaudacionPeticion} solicitud de captura.
	 * @return {@link String} respuesta a Captura.
	 */
	public String capturaActaRecaudacionXML(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/OperacionCreditoGrupal/V1.0/capturaActaRecaudacionXML")
			java.lang.String peticion);

	/**
	 * @param peticion :
	 * @return AplicarPagoRespuesta
	 */
	public AplicarPagoRespuesta aplicarPagoConexia(AplicarPagoConexiaPeticion peticion);

	/**
	 * @param peticion :
	 * @return DatosConvenioRespuesta
	 */
	public DatosConvenioRespuesta buscarDatosConvenio(DatosConvenioPeticion peticion);

	/**
	 * @param peticion :
	 * @return DatosConvenioRespuesta
	 */
	public DatosConvenioRespuesta guardarDatosConvenio(ConvenioOV peticion);


	/**
	 * @param peticion :
	 * @return CancelarPagoConexiaRespuesta
	 */
	public CancelarPagoConexiaRespuesta cancelarPagoConexia(CancelarPagoConexiaPeticion peticion);

	/**
	 * @param peticion :
	 * @return AplicarPagoServicioRespuesta
	 */
	public AplicarPagoServicioRespuesta aplicarPagoServicio(PagoServicioPeticion peticion);

	/**
	 * @param peticion :
	 * @return AplicarPagoRespuesta
	 */
	public AplicarPagoRespuesta validacionPagoConvenio(AplicarPagoConexiaPeticion peticion);

	/**
	 * @param peticion :
	 * @return CancelarPagoConexiaRespuesta
	 */
	public CancelarPagoConexiaRespuesta validacionCancelacionPagoConvenio(CancelarPagoConexiaPeticion peticion);

	/**
	 * @param peticion :
	 * @return AplicarPagoRespuesta
	 */
	public AplicarPagoRespuesta aplicarGarantiaLiquidacion(PagoGrupal peticion);

	/**
	 * Esta operaci&oacute;n permite cancelar el pago realizado por problemas dentro de la plataforma de
	 * pago de servicios en l&iacute;nea.
	 * Esta operaci&oacute;n es s&oacute;lo por sistema ante fallas en el protocolo de comunicaci&oacute;n
	 * @param peticion datos del pago.
	 * @param uid identificador &uacute;nico de transacci&oacute;n.
	 * @return RespuestaReverseEnLineaOxxo respuesta.
	 */
	public RespuestaReverseEnLineaOxxo cancelarPagoEnLineaOxxo(String uid, PeticionEnLineaOxxo peticion);

	/**
	 * Esta operaci&oacute;n permite cancelar el pago realizado por problemas dentro de la plataforma de
	 * pago de servicios en l&iacute;nea.
	 * Esta operaci&oacute;n es s&oacute;lo por sistema ante fallas en el protocolo de comunicaci&oacute;n
	 * @param peticion datos del pago.
	 * @param uid identificador &uacute;nico de transacci&oacute;n.
	 * @return RespuestaReverseEnLineaOxxo respuesta.
	 */
	public CancelarPagoConexiaRespuesta cancelarPagoEnLinea(String uid, CancelarPagoConexiaPeticion peticion);

	/**
	 * @param peticion :
	 * @return AplicarPagoRespuesta
	 */
	public CancelarPagoConexiaRespuesta cancelarPagoGarantia(CancelarPagoConexiaPeticion peticion);

	/**
	 * Metodo para consultar el universo de pagos no conciliados
	 * @param peticion filtros de la busqueda
	 * @return el universo de pagos
	 */
	public ConsultarPagosRespuesta consultarPagosNoConciliados(ConsultarPagosPeticion peticion);
	/**
	 * Metodo para consultar el universo de pagos no conciliados
	 * @param pagos filtros de la busqueda
	 * @return el universo de pagos
	 */
	public RespuestaConciliarPagos aplicarPagosNoConciliados(List<PagoDTO> pagos);

	public ConsultarPagosLineaRespuesta consultarPagosLineaDuplicados(ConsultarPagosPeticion peticion);
	public ReversarPagoOxxoRespuesta reversarPagoOxxo(ReversarPagoOxxoPeticion peticion);
	public AlmacenarArchivoOxxoRespuesta almacenarArchivoOxxo(AlmacenarArchivoOxxoPeticion peticion);
	public ConsultarPagosLineaRespuesta consultarPagosLineaNoEncontrados(ConsultarPagosPeticion peticion);

	/**
	 * Metodo que se utiliza para consultar el traspaso de Pagos
	 *
	 * @param uid Identificador Unico
	 * @param peticion TraspasoPagosPeticion
	 * @return TraspasoPagosRespuesta
	 */
	public TraspasoPagosRespuesta consultarTraspasoPagos(String uid, TraspasoPagosPeticion peticion);
	/**
	 * Este m&eacute;todo se va a ocupar para aplicar los pagos en linea de la nube.
	 * Esta operaci&oacute;n permite realizar el pago parcial o total del cliente,
	 * los pagos parciales se realizarán si el proveedor los acepta, esto aplica
	 * para OXXO.
	 * @param peticion :
	 * @return AplicarPagoRespuesta
	 */
	public AplicarPagoRespuesta aplicarTransaccionPagoEnLinea(AplicarPagoLineaPeticion peticion);
}
