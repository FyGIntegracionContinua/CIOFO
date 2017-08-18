package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

public class ObtenerDatosSolicitudPeticion extends ObjetoValor {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 2481624307041105116L;

	/**
	 * solicitud
	 */
	private String solicitud;

	/** The usuario. */
	private String usuario;
	/**
	 * variable que se utilizara para madar a buzon o no.
	 */
	private String entrarBuzon;
	/**
	 * para saber si se debe generar una excepción de documental
	 */
	private boolean enviarDocumental;
	/**
	 * Variable para enviar la justificación de la excepción documental
	 */
	private String justificacionExcepcionDocumental;

	/**
	 * @return the solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}
	/**
	 * @param solicitud the solicitud to set
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	/**
	 * Gets the usuario.
	 *
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Sets the usuario.
	 *
	 * @param usuario the new usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the entrarBuzon
	 */
	public String getEntrarBuzon() {
		return entrarBuzon;
	}
	/**
	 * @param entrarBuzon the entrarBuzon to set
	 */
	public void setEntrarBuzon(String entrarBuzon) {
		this.entrarBuzon = entrarBuzon;
	}
	/**
	 * @return the enviarDocumental
	 */
	public boolean isEnviarDocumental() {
		return enviarDocumental;
	}
	/**
	 * @param enviarDocumental the enviarDocumental to set
	 */
	public void setEnviarDocumental(boolean enviarDocumental) {
		this.enviarDocumental = enviarDocumental;
	}
	/**
	 * @return the justificacionExcepcionDocumental
	 */
	public String getJustificacionExcepcionDocumental() {
		return justificacionExcepcionDocumental;
	}
	/**
	 * @param justificacionExcepcionDocumental the justificacionExcepcionDocumental to set
	 */
	public void setJustificacionExcepcionDocumental(
			String justificacionExcepcionDocumental) {
		this.justificacionExcepcionDocumental = justificacionExcepcionDocumental;
	}

}
