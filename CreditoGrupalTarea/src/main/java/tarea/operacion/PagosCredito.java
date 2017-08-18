/**
 *
 */
package tarea.operacion;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import utilitario.mensajes.convenio.ConvenioOV;
import utilitario.mensajes.convenio.DatosConvenioPeticion;
import utilitario.mensajes.convenio.DatosConvenioRespuesta;
import utilitario.mensajes.operacion.ActaRecaudacionPeticion;
import utilitario.mensajes.operacion.ActaRecaudacionRespuesta;
import utilitario.mensajes.operacion.TraspasoPagosPeticion;
import utilitario.mensajes.operacion.TraspasoPagosRespuesta;
import utilitario.mensajes.operacion.pagos.AlmacenarArchivoOxxoPeticion;
import utilitario.mensajes.operacion.pagos.AlmacenarArchivoOxxoRespuesta;
import utilitario.mensajes.operacion.pagos.AplicarPagoConexiaPeticion;
import utilitario.mensajes.operacion.pagos.AplicarPagoLineaPeticion;
import utilitario.mensajes.operacion.pagos.AplicarPagoPeticion;
import utilitario.mensajes.operacion.pagos.AplicarPagoRespuesta;
import utilitario.mensajes.operacion.pagos.AplicarPagoServicioRespuesta;
import utilitario.mensajes.operacion.pagos.CancelarMovimientosPeticion;
import utilitario.mensajes.operacion.pagos.CancelarMovimientosRespuesta;
import utilitario.mensajes.operacion.pagos.CancelarPagoConexiaPeticion;
import utilitario.mensajes.operacion.pagos.CancelarPagoConexiaRespuesta;
import utilitario.mensajes.operacion.pagos.ConsultarPagosLineaRespuesta;
import utilitario.mensajes.operacion.pagos.ConsultarPagosPeticion;
import utilitario.mensajes.operacion.pagos.ConsultarPagosRespuesta;
import utilitario.mensajes.operacion.pagos.PagoDTO;
import utilitario.mensajes.operacion.pagos.PagoGrupal;
import utilitario.mensajes.operacion.pagos.PagoGrupalResponse;
import utilitario.mensajes.operacion.pagos.PagoServicioPeticion;
import utilitario.mensajes.operacion.pagos.RespuestaConciliarPagos;
import utilitario.mensajes.operacion.pagos.ReversarPagoOxxoPeticion;
import utilitario.mensajes.operacion.pagos.ReversarPagoOxxoRespuesta;
import utilitario.mensajes.operacion.pagos.TraspasarPagoPeticion;
import utilitario.mensajes.operacion.pagos.TraspasarPagoRespuesta;
import utilitario.mensajes.operacion.pagos.oxxo.PeticionEnLineaOxxo;
import utilitario.mensajes.operacion.pagos.oxxo.RespuestaReverseEnLineaOxxo;

/**
 * @author oarias
 * @version 4.2
 */
public interface PagosCredito {

	/** String PREFIJO_OXXO. */
	public static final String PREFIJO_OXXO = "24";
	/** String MEDIO_PAGO_OXXO. */
	public static final String MEDIO_PAGO_OXXO = "OXXO";

	/**
	 * Aplica un pago grupal, recibe una Sesion de Ibatis, en caso de requerir invocarse
	 * dentro de una transaccion
	 * @param pagoGrupalObject datos correspondientes al pago referenciado grupal
	 * @param uid .
	 * @param sesion .
	 * @param idTransaccion .
	 * @return resultado de la operacion
	 */
	public PagoGrupalResponse aplicarPagoGrupal(String uid, SqlSession sesion,
			Integer idTransaccion, PagoGrupal pagoGrupalObject);

	/**
	 * Aplica un pago grupal
	 * @param pagoGrupalObject datos correspondientes al pago referenciado grupal
	 * @param uid .
	 * @return resultado de la operacion
	 */
	public PagoGrupalResponse aplicarPagoGrupal(String uid, PagoGrupal pagoGrupalObject);

	/**
	 * Cancelar un pago
	 * @param  sesionTX .
	 * @param  inicioPagos .
	 * @param  numeroContrato .
	 * @param  usuario .
	 * @param  idTransaccion .
	 * @param  sucursal .
	 * @param  fechaContable .
	 * @param uid .
	 * @return resultado de la operacion
	 */
	@SuppressWarnings("rawtypes")
	public boolean cancelarPagos(String uid, SqlSession sesionTX, HashMap inicioPagos, String numeroContrato,
			String usuario, Integer idTransaccion, Integer sucursal, Date fechaContable)
		throws Exception;

	/**
	 * Cancela los pagos para el ajuste por cheque devuleto, la unica diferencia, es que,
	 * cancela a partir de cierta hr y no solo cierta fecha
	 * @param uid .
	 * @param sesionTX .
	 * @param inicioPagos .
	 * @param numeroContrato .
	 * @param usuario .
	 * @param idTransaccion .
	 * @param sucursal .
	 * @param fechaContable .
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public boolean cancelarPagosAjusteCheque(String uid, SqlSession sesionTX, HashMap inicioPagos, String numeroContrato,
			String usuario, Integer idTransaccion, Integer sucursal, Date fechaContable)
		throws Exception;

	/**
	 * M�todo para realizar la cancelacion de uno o mas movimientos en un
	 * contrato especifico
	 * @param uid .
	 * @param peticion .
	 * @return cancelarMovimientosRespuesta .
	 */
	public CancelarMovimientosRespuesta cancelarMovimientos(CancelarMovimientosPeticion peticion, java.lang.String uid);

	/**
	 * M�todo para realizar la cancelacion de uno o mas movimientos en un
	 * contrato especifico, para uso interno de CIOF
	 * @param peticion .
	 * @param idTransaccion .
	 * @param sessionTx .
	 * @param uid .
	 * @return cancelarMovimientosRespuesta .
	 */
	public CancelarMovimientosRespuesta cancelarMovimientos(CancelarMovimientosPeticion peticion,
			java.lang.Integer idTransaccion, SqlSession sessionTx, java.lang.String uid);

	/**
	 * M�todo para realizar la cancelaci�n de cieroto pago y aplicarlo a otro contrato
	 * @param peticion .
	 * @param uid .
	 * @return traspasarPagoRespuesta .
	 */
	public TraspasarPagoRespuesta traspasarPago(TraspasarPagoPeticion peticion, java.lang.String uid);

	/**
	 * M�todo para aplicar un pago, esta funcion se usa fuera de la importacion de pagos
	 * @param peticion .
	 *  @param  uid .
	 * @return aplicarPagoRespuesta .
	 */
	public AplicarPagoRespuesta aplicarPagoGrupalOperaciones(AplicarPagoPeticion peticion, SqlSession sesionTx, java.lang.String uid);

	/**
	 * M�todo que realiza la captura de un Acta de Recaudaci&oacute;n ya sea de tipo Objeto Valor o XML.
	 * @author ISC Omar CC (ocruzc)
	 * @param peticion {@link ActaRecaudacionPeticion} solicitud de captura.
	 * @param uid {@link String} identificador de transacciones.
	 * @return {@link ActaRecaudacionRespuesta} respuesta a Captura.
	 */
	public ActaRecaudacionRespuesta capturaActaRecaudacion(ActaRecaudacionPeticion peticion, String uid);

	public AplicarPagoRespuesta aplicarPagoGrupalConexia(AplicarPagoConexiaPeticion peticion, String uid);

	public DatosConvenioRespuesta buscarDatosConvenio( DatosConvenioPeticion peticion, String uid );

	public DatosConvenioRespuesta guardarDatosConvenio( ConvenioOV peticion, String uid );

	public AplicarPagoServicioRespuesta aplicarPagoServicio(PagoServicioPeticion peticion, String uid );

	public AplicarPagoRespuesta validacionPagoConvenio(AplicarPagoConexiaPeticion peticion, String uid);

	/**
	 * @param peticion CancelarPagoConexiaPeticion
	 * @param uid String
	 * @return CancelarPagoConexiaRespuesta
	 */
	public CancelarPagoConexiaRespuesta validacionCancelacionPagoConvenio(CancelarPagoConexiaPeticion peticion, String uid);

    /**
     * Cancela Pago
     * @param peticion CancelarPagoConexiaPeticion
     * @param uid String
     * @return CancelarPagoConexiaRespuesta
     */
    public CancelarPagoConexiaRespuesta cancelarPagoConexiaTarea(CancelarPagoConexiaPeticion peticion, String uid);

    /**
		 * @param peticion :
		 * @param uid identificador de la transaccion
		 * @return AplicarPagoRespuesta
		 */
	public AplicarPagoRespuesta aplicarGarantiaLiquidacion(PagoGrupal peticion, String uid);

	/**
	 * Esta operaci&oacute;n permite cancelar el pago realizado por problemas dentro de la plataforma de
	 * pago de servicios en l&iacute;nea.
	 * Esta operaci&oacute;n es s&oacute;lo por sistema ante fallas en el protocolo de comunicaci&oacute;n
	 * @param peticion datos del pago.
	 * @param uid identificador &uacute;nico de transacci&oacute;n.
	 * @return RespuestaReverseEnLineaOxxo respuesta.
	 */
	public RespuestaReverseEnLineaOxxo cancelarPagoEnLineaOxxoTarea(String uid, PeticionEnLineaOxxo peticion);

	/**
	 * Esta operaci&oacute;n permite cancelar el pago realizado por problemas dentro de la plataforma de
	 * pago de servicios en l&iacute;nea.
	 * Esta operaci&oacute;n es s&oacute;lo por sistema ante fallas en el protocolo de comunicaci&oacute;n
	 * @param peticion datos del pago.
	 * @param uid identificador &uacute;nico de transacci&oacute;n.
	 * @return RespuestaReverseEnLineaOxxo respuesta.
	 */
	public CancelarPagoConexiaRespuesta cancelarPagoEnLineaTarea(String uid, CancelarPagoConexiaPeticion peticion, SqlSession sesion);

	/**
	 * Cancelar un pago proveniente de una garantia
	 * @param peticion Datos del pago para realizar la cancelacion
	 * @param uid identificador unico de la transaccion
	 * @return resultado de la cancelacion del pago
	 */
	public CancelarPagoConexiaRespuesta cancelarPagoGarantiaTarea(CancelarPagoConexiaPeticion peticion, String uid);
	/**
	 * Metodo para consultar el universo de pagos no conciliados
	 * @param uid Identificador unico de la transaccion
	 * @param peticion filtros de la busqueda
 	 * @return el universo de pagos
	 */
	public ConsultarPagosRespuesta consultarPagosNoConciliados(String uid, ConsultarPagosPeticion peticion);
	/**
	 * Metodo para aplicar los pagos no conciliados
	 * @param uid Identificador unico de la transaccion
	 * @param pagos lista de pagos por conciliar
	 * @return resultado
	 */
	public RespuestaConciliarPagos aplicarPagosNoConciliados(String uid, List<PagoDTO> pagos);

	public ConsultarPagosLineaRespuesta consultarPagosLineaDuplicados(String uid, ConsultarPagosPeticion peticion);
	public ReversarPagoOxxoRespuesta reversarPagoOxxo(String uid, ReversarPagoOxxoPeticion peticion);
	public AlmacenarArchivoOxxoRespuesta almacenarArchivoOxxo(String uid, AlmacenarArchivoOxxoPeticion peticion);
	public ConsultarPagosLineaRespuesta consultarPagosLineaNoEncontrados(String uid, ConsultarPagosPeticion peticion);

	/**
	 * Metodo que se utiliza para consultar el traspaso de Pagos
	 *
	 * @param uid Identificador Unico
	 * @param peticion TraspasoPagosPeticion
	 * @return TraspasoPagosRespuesta
	 */
	public TraspasoPagosRespuesta consultarTraspasoPagosTarea(String uid, TraspasoPagosPeticion peticion);

	/**
	 * Metodo que se utiliza para las transacciones del componente de pagos en linea nube
	 *
	 * @param uid Identificador Unico
	 * @param peticion transaccion de pagos en linea
	 * @return AplicarPagoRespuesta
	 */
	public AplicarPagoRespuesta aplicarTransaccionPagoEnLinea(String uid, AplicarPagoLineaPeticion peticion);
}
