package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SolicitudIDRespuesta.
 */
public class SolicitudIDRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva solicitud id respuesta.
	 */
	public SolicitudIDRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3790260896755589818L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The id. */
	private String ID;

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
	 * Obtiene id.
	 *
	 * @return id
	 */
	public String getID() {
		return ID;
	}

	/**
	 * Establece id.
	 *
	 * @param iD a id
	 */
	public void setID(String iD) {
		ID = iD.trim();
	}

}
