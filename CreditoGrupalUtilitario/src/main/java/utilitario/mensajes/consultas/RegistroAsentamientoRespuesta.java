package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class RegistroAsentamientoRespuesta.
 *
 * @author mimejorada
 */
public class RegistroAsentamientoRespuesta  extends ObjetoValor {


	/**
	 * RegistroAsentamientoRespuesta.
	 */
	public RegistroAsentamientoRespuesta() {

	}

	/** serialVersionUID long. */
	private static final long serialVersionUID = 8287012908416157527L;

	/** header EncabezadoRespuesta. */
	private EncabezadoRespuesta 	header;

	/**
	 * Obtiene header.
	 *
	 * @return .
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header .
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

}
