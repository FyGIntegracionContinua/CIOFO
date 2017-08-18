package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

public class SolicitudSACGIntegranteCurp extends ObjetoValor {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -2443977311739503208L;

	/** The persona. */
	private String persona;

	/** The nombre completo. */
	private String nombreCompleto;

	/**
	 * @return the persona
	 */
	public String getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(String persona) {
		this.persona = persona;
	}

	/**
	 * @return the nombreCompleto
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	/**
	 * @param nombreCompleto the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

}
