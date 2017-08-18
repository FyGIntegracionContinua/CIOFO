package utilitario.mensajes.chequescreditogrupal;

import utilitario.mensajes.comun.ObjetoValor;

public class ChequeOV extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2335870655438876529L;

	/**	numeroCheque */
	private Integer numeroCheque;
	/**	folioCheque */
	private Integer folioCheque;
	/**	montoCheque */
	private double montoCheque;
	/**
	 * @return the numeroCheque
	 */
	public Integer getNumeroCheque() {
		return numeroCheque;
	}
	/**
	 * @param numeroCheque the numeroCheque to set
	 */
	public void setNumeroCheque(Integer numeroCheque) {
		this.numeroCheque = numeroCheque;
	}
	/**
	 * @return the folioCheque
	 */
	public Integer getFolioCheque() {
		return folioCheque;
	}
	/**
	 * @param folioCheque the folioCheque to set
	 */
	public void setFolioCheque(Integer folioCheque) {
		this.folioCheque = folioCheque;
	}
	/**
	 * @return the montoCheque
	 */
	public double getMontoCheque() {
		return montoCheque;
	}
	/**
	 * @param montoCheque the montoCheque to set
	 */
	public void setMontoCheque(double montoCheque) {
		this.montoCheque = montoCheque;
	}

}
