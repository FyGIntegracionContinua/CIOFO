package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

public class ConsultaReferenciaBancariasOV extends 	ObjetoValor {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -8011901738065109799L;
	/** The contrato. */
	private String  noContrato;
	/**
	 * @return the contrato
	 */
	public String getNoContrato() {
		return noContrato;
	}
	/**
	 * @param noContrato the contrato to set
	 */
	public void setNoContrato(String noContrato) {
		this.noContrato = noContrato;
	}

}
