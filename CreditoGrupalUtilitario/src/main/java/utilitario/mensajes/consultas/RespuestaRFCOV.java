package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class SolicitudesRespuesta.
 */
public class RespuestaRFCOV extends ObjetoValor {

	/**
	 * Instantiates a new respuesta rfcov.
	 */
	public RespuestaRFCOV() {
	}
	/** Se genero nuevo serial. */
	private static final long serialVersionUID = 4771230139176220692L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The id. */
	private String rfc;

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}


	/**
	 * Gets the rfc.
	 *
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * Sets the rfc.
	 *
	 * @param rfc the new rfc
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

}
