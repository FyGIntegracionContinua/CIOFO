package utilitario.mensajes.operacion.pagos;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AplicarPagoServicioRespuesta.
 */
public class AplicarPagoServicioRespuesta  extends 	ObjetoValor {

	/**
	 * long serialVersionUID
	 */
	private static final long serialVersionUID = 2420262939276287930L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The id transaccion. */
	private Integer idTransaccion;

	/**
	 * Instancia una nueva aplicar pago servicio respuesta.
	 */
	public AplicarPagoServicioRespuesta() {
		this.setHeader(new EncabezadoRespuesta());
	}
	/**
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}
	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}
	/**
	 * @return the idTransaccion
	 */
	public Integer getIdTransaccion() {
		return idTransaccion;
	}
	/**
	 * @param idTransaccion the idTransaccion to set
	 */
	public void setIdTransaccion(Integer idTransaccion) {
		this.idTransaccion = idTransaccion;
	}


}
