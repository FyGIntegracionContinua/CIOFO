package utilitario.mensajes.condonaciones.comun;

import java.math.BigDecimal;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SaldoVencidoResult.
 */
public class SaldoVencidoResult extends ObjetoValor {


	/**
	 * Instancia una nueva saldo vencido result.
	 */
	public SaldoVencidoResult() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5255780620974791403L;

	/** The capital. */
	private BigDecimal capital;

	/** The interes. */
	private BigDecimal interes;

	/** The moratorio. */
	private BigDecimal moratorio;

	/**
	 * Obtiene capital.
	 *
	 * @return the capital
	 */
	public BigDecimal getCapital() {
		return capital;
	}

	/**
	 * Establece capital.
	 *
	 * @param capital the capital to set
	 */
	public void setCapital(BigDecimal capital) {
		this.capital = capital == null ? new BigDecimal(0) : capital;
	}

	/**
	 * Obtiene interes.
	 *
	 * @return the interes
	 */
	public BigDecimal getInteres() {
		return interes;
	}

	/**
	 * Establece interes.
	 *
	 * @param interes the interes to set
	 */
	public void setInteres(BigDecimal interes) {
		this.interes = interes == null ? new BigDecimal(0) : interes;
	}

	/**
	 * Obtiene moratorio.
	 *
	 * @return the moratorio
	 */
	public BigDecimal getMoratorio() {
		return moratorio;
	}

	/**
	 * Establece moratorio.
	 *
	 * @param moratorio the moratorio to set
	 */
	public void setMoratorio(BigDecimal moratorio) {
		this.moratorio = moratorio == null ? new BigDecimal(0) : moratorio;
	}
}
