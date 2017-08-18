/**
 *
 */
package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultarPersonaRespuesta.
 *
 * @author rguadarrama
 */
public 	class 	ValidarSolicitudPeticion extends ObjetoValor {

	/**
	 * Instantiates a new validar solicitud peticion.
	 */
	public ValidarSolicitudPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5677000937229085332L;


	/** The numero solicitud. */
	private String numeroSolicitud;


	/**
	 * Gets the numero solicitud.
	 *
	 * @return the numero solicitud
	 */
	public String getNumeroSolicitud() {
		return numeroSolicitud;
	}


	/**
	 * Sets the numero solicitud.
	 *
	 * @param numeroSolicitud the new numero solicitud
	 */
	public void setNumeroSolicitud(String numeroSolicitud) {
		this.numeroSolicitud = numeroSolicitud;
	}

}
