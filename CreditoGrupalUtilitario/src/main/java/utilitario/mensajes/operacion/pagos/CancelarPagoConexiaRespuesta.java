package utilitario.mensajes.operacion.pagos;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author mi.mejorada
 *
 */

/**
 * @author mi.mejorada
 *
 */
public class CancelarPagoConexiaRespuesta extends ObjetoValor {

	/**
	 * CancelarPagoConexiaRespuesta
	 */
	public CancelarPagoConexiaRespuesta() {
		super();
	}

	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = -7879107591160759103L;
	/**
	 * header EncabezadoRespuesta
	 */
	private EncabezadoRespuesta header;
	/**
	 * idTransaccion Integer
	 */
	private Integer idTransaccion;

	/**
	 * @return .
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * @param header .
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}
	/**
	 * @return .
	 */
	public Integer getIdTransaccion() {
		return idTransaccion;
	}
	/**
	 * @param idTransaccion .
	 */
	public void setIdTransaccion(Integer idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
}
