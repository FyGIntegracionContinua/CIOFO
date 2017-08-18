package utilitario.mensajes.burocredito;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author mi.mejorada
 *
 */
public class IntegranteSolicitud  extends ObjetoValor {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 4826603787852594420L;

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
