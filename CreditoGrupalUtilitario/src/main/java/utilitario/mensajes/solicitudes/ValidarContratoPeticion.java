package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

public class ValidarContratoPeticion extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3437490523984148135L;
	/** The contrato. */
	private String contrato;

	/**
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

}
