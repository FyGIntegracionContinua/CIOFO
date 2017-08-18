package utilitario.mensajes.originacion.consulta;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SimulacionReestructuraOV.
 *
 * @author rguadarramac
 *
 */
public class ParGeneralOV extends ObjetoValor {

	/**
	 * Instantiates a new par general ov.
	 */
	public ParGeneralOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5786851668589243169L;

	/** The cc parametro. */
	private String ccParametro;

	/** The sc tipo dato. */
	private Integer scTipoDato;

	/** The cd parametro. */
	private String cdParametro;

	/** The cg valor. */
	private String cgValor;

	/**
	 * Gets the cc parametro.
	 *
	 * @return the cc parametro
	 */
	public String getCcParametro() {
		return ccParametro;
	}

	/**
	 * Sets the cc parametro.
	 *
	 * @param ccParametro the new cc parametro
	 */
	public void setCcParametro(String ccParametro) {
		this.ccParametro = ccParametro;
	}

	/**
	 * Gets the sc tipo dato.
	 *
	 * @return the sc tipo dato
	 */
	public Integer getScTipoDato() {
		return scTipoDato;
	}

	/**
	 * Sets the sc tipo dato.
	 *
	 * @param scTipoDato the new sc tipo dato
	 */
	public void setScTipoDato(Integer scTipoDato) {
		this.scTipoDato = scTipoDato;
	}

	/**
	 * Gets the cd parametro.
	 *
	 * @return the cd parametro
	 */
	public String getCdParametro() {
		return cdParametro;
	}

	/**
	 * Sets the cd parametro.
	 *
	 * @param cdParametro the new cd parametro
	 */
	public void setCdParametro(String cdParametro) {
		this.cdParametro = cdParametro;
	}

	/**
	 * Gets the cg valor.
	 *
	 * @return the cg valor
	 */
	public String getCgValor() {
		return cgValor;
	}

	/**
	 * Sets the cg valor.
	 *
	 * @param cgValor the new cg valor
	 */
	public void setCgValor(String cgValor) {
		this.cgValor = cgValor;
	}


}
