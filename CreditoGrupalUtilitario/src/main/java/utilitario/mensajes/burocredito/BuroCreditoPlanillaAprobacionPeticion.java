package utilitario.mensajes.burocredito;

import utilitario.mensajes.comun.ObjetoValor;

public class BuroCreditoPlanillaAprobacionPeticion extends ObjetoValor {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 5148594001100771979L;
	/**
	 * persona
	 */
	private String persona;

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

}
