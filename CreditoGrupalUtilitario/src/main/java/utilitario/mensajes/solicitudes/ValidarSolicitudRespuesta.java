/**
 *
 */
package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultarPersonaRespuesta.
 *
 * @author rguadarrama
 */
public 	class 	ValidarSolicitudRespuesta extends ObjetoValor {


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5677000937229085332L;

	/** The header. */
	private EncabezadoRespuesta			header;

	/** The persona. */
	private ValidaSolicitudOV        solicitud;


	/**
	 * Instancia una nueva consultar persona respuesta.
	 */
	public ValidarSolicitudRespuesta() {
		header = new EncabezadoRespuesta();
		}

	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Gets the solicitud.
	 *
	 * @return the solicitud
	 */
	public ValidaSolicitudOV getSolicitud() {
		return solicitud;
	}

	/**
	 * Sets the solicitud.
	 *
	 * @param solicitud the new solicitud
	 */
	public void setSolicitud(ValidaSolicitudOV solicitud) {
		this.solicitud = solicitud;
	}


}
