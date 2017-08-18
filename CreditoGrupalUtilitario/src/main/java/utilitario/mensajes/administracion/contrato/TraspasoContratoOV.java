package utilitario.mensajes.administracion.contrato;

import utilitario.mensajes.comun.ObjetoValor;

public class TraspasoContratoOV extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -182355626200455593L;
	/**
	 * contratoActual
	 */
	private String contratoActual;
	/**
	 * @return the contratoActual
	 */
	public String getContratoActual() {
		return contratoActual;
	}
	/**
	 * @param contratoActual the contratoActual to set
	 */
	public void setContratoActual(String contratoActual) {
		this.contratoActual = contratoActual;
	}
}
