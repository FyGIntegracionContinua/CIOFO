/**
 * utilitario.mensajes.operacion.ActaRecaudacionRespuesta.java
 */
package utilitario.mensajes.operacion;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ISC Omar Cruz Carrillo (ocruzc) 24/09/2012
 * @version 1.0
 */
public class ActaRecaudacionRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva acta recaudacion respuesta.
	 */
	public ActaRecaudacionRespuesta() {
	}
	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -359927179872953514L;

	/** Encabezado de Respuesta. */
	private EncabezadoRespuesta	header;

	/**
	 * M&eacute;todo que regresa el valor del miembro dato header.
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato header.
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}
}
