package utilitario.mensajes.originacion.consulta;

import utilitario.mensajes.comun.ObjetoValor;

public class TraspasoGarantiaOV extends ObjetoValor {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 2481624307041105116L;


	/** The contrato. */
	private String contrato;

	/** The pct participacion total. */
	private Double pctParticipacionTotal;


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

	/**
	 * @return the pctParticipacionTotal
	 */
	public Double getPctParticipacionTotal() {
		return pctParticipacionTotal;
	}

	/**
	 * @param pctParticipacionTotal the pctParticipacionTotal to set
	 */
	public void setPctParticipacionTotal(Double pctParticipacionTotal) {
		this.pctParticipacionTotal = pctParticipacionTotal;
	}


}
