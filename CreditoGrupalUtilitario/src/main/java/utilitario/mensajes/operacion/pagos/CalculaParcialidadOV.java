/**
 *
 */
package utilitario.mensajes.operacion.pagos;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class CalculaParcialidadOV.
 *
 * @author out_oarias
 */
public class CalculaParcialidadOV extends ObjetoValor {

	/**
	 * Instancia una nueva calcula parcialidad ov.
	 */
	public CalculaParcialidadOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5083290457952214761L;

	/** The gran total. */
	private Double granTotal;

	/** The total cobranza. */
	private Double totalCobranza;

	/** The total moratorios. */
	private Double totalMoratorios;

	/** The total intereses. */
	private Double totalIntereses;

	/** The total abono. */
	private Double totalAbono;

	/**
	 * Obtiene gran total.
	 *
	 * @return gran total
	 */
	public Double getGranTotal() {
		return granTotal;
	}

	/**
	 * Establece gran total.
	 *
	 * @param granTotal a gran total
	 */
	public void setGranTotal(Double granTotal) {
		this.granTotal = granTotal;
	}

	/**
	 * Obtiene total cobranza.
	 *
	 * @return total cobranza
	 */
	public Double getTotalCobranza() {
		return totalCobranza;
	}

	/**
	 * Establece total cobranza.
	 *
	 * @param totalCobranza a total cobranza
	 */
	public void setTotalCobranza(Double totalCobranza) {
		this.totalCobranza = totalCobranza;
	}

	/**
	 * Obtiene total moratorios.
	 *
	 * @return total moratorios
	 */
	public Double getTotalMoratorios() {
		return totalMoratorios;
	}

	/**
	 * Establece total moratorios.
	 *
	 * @param totalMoratorios a total moratorios
	 */
	public void setTotalMoratorios(Double totalMoratorios) {
		this.totalMoratorios = totalMoratorios;
	}

	/**
	 * Obtiene total intereses.
	 *
	 * @return total intereses
	 */
	public Double getTotalIntereses() {
		return totalIntereses;
	}

	/**
	 * Establece total intereses.
	 *
	 * @param totalIntereses a total intereses
	 */
	public void setTotalIntereses(Double totalIntereses) {
		this.totalIntereses = totalIntereses;
	}

	/**
	 * Obtiene total abono.
	 *
	 * @return total abono
	 */
	public Double getTotalAbono() {
		return totalAbono;
	}

	/**
	 * Establece total abono.
	 *
	 * @param totalAbono a total abono
	 */
	public void setTotalAbono(Double totalAbono) {
		this.totalAbono = totalAbono;
	}

}
