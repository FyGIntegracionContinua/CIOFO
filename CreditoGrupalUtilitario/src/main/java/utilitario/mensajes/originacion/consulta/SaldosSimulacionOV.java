package utilitario.mensajes.originacion.consulta;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SimulacionReestructuraOV.
 *
 * @author rguadarramac
 *
 */
public class SaldosSimulacionOV extends ObjetoValor {

	/**
	 * Instantiates a new saldos simulacion ov.
	 */
	public SaldosSimulacionOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5786851668589243169L;

	/** The moratorio. */
	private Double moratorio;

	/** The iva moratorio. */
	private Double ivaMoratorio;

	/** The interes vencido. */
	private Double interesVencido;

	/** The iva interes vencido. */
	private Double ivaInteresVencido;

	/**
	 * Gets the moratorio.
	 *
	 * @return the moratorio
	 */
	public Double getMoratorio() {
		return moratorio;
	}

	/**
	 * Sets the moratorio.
	 *
	 * @param moratorio the new moratorio
	 */
	public void setMoratorio(Double moratorio) {
		this.moratorio = moratorio;
	}

	/**
	 * Gets the iva moratorio.
	 *
	 * @return the iva moratorio
	 */
	public Double getIvaMoratorio() {
		return ivaMoratorio;
	}

	/**
	 * Sets the iva moratorio.
	 *
	 * @param ivaMoratorio the new iva moratorio
	 */
	public void setIvaMoratorio(Double ivaMoratorio) {
		this.ivaMoratorio = ivaMoratorio;
	}

	/**
	 * Gets the interes vencido.
	 *
	 * @return the interes vencido
	 */
	public Double getInteresVencido() {
		return interesVencido;
	}

	/**
	 * Sets the interes vencido.
	 *
	 * @param interesVencido the new interes vencido
	 */
	public void setInteresVencido(Double interesVencido) {
		this.interesVencido = interesVencido;
	}

	/**
	 * Gets the iva interes vencido.
	 *
	 * @return the iva interes vencido
	 */
	public Double getIvaInteresVencido() {
		return ivaInteresVencido;
	}

	/**
	 * Sets the iva interes vencido.
	 *
	 * @param ivaInteresVencido the new iva interes vencido
	 */
	public void setIvaInteresVencido(Double ivaInteresVencido) {
		this.ivaInteresVencido = ivaInteresVencido;
	}
}
