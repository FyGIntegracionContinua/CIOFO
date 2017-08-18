package utilitario.mensajes.impresiondocs.comun;

import utilitario.mensajes.comun.ObjetoValor;

public class PreSolicitudPeticion  extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2508549288105878575L;

	/** contrato String	 */
	private String contratoAnterior;
	
	private String contratoNuevo;
	
	private String solicitud;

	/**
	 * @return the contratoAnterior
	 */
	public String getContratoAnterior() {
		return contratoAnterior;
	}

	/**
	 * @param contratoAnterior the contratoAnterior to set
	 */
	public void setContratoAnterior(String contratoAnterior) {
		this.contratoAnterior = contratoAnterior;
	}

	/**
	 * @return the contratoNuevo
	 */
	public String getContratoNuevo() {
		return contratoNuevo;
	}

	/**
	 * @param contratoNuevo the contratoNuevo to set
	 */
	public void setContratoNuevo(String contratoNuevo) {
		this.contratoNuevo = contratoNuevo;
	}

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

	

}
