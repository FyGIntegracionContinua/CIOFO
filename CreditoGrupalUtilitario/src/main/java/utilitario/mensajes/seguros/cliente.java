package utilitario.mensajes.seguros;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class BeneficiarioOV.
 *
 * @author rguadarramac
 */
public class cliente extends ObjetoValor {

	/**
	 * Instancia una nueva beneficiario ov.
	 */
	public cliente() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 534839698349227187L;

	/** The inicio vigencia. */
	private String inicioVigencia;

	/** The numero persona. */
	private String numeroPersona;

	/** The plazo seguro. */
	private Integer plazoSeguro;

	/** The seguro vida. */
	private String seguroVida;

	/** The plazo credito. */
	private Integer plazoCredito;

	/** The seguro enfermedad. */
	private String seguroEnfermedad;

	/** The costo seguro vida. */
	private Double costoSeguroVida;

	/** The costo seguro enfermedad. */
	private Double costoSeguroEnfermedad;

	/**
	 * Gets the inicio vigencia.
	 *
	 * @return the inicio vigencia
	 */
	public String getInicioVigencia() {
		return inicioVigencia;
	}

	/**
	 * Sets the inicio vigencia.
	 *
	 * @param inicioVigencia the new inicio vigencia
	 */
	public void setInicioVigencia(String inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	/**
	 * Gets the numero persona.
	 *
	 * @return the numero persona
	 */
	public String getNumeroPersona() {
		return numeroPersona;
	}

	/**
	 * Sets the numero persona.
	 *
	 * @param numeroPersona the new numero persona
	 */
	public void setNumeroPersona(String numeroPersona) {
		this.numeroPersona = numeroPersona;
	}

	/**
	 * Gets the plazo seguro.
	 *
	 * @return the plazo seguro
	 */
	public Integer getPlazoSeguro() {
		return plazoSeguro;
	}

	/**
	 * Sets the plazo seguro.
	 *
	 * @param plazoSeguro the new plazo seguro
	 */
	public void setPlazoSeguro(Integer plazoSeguro) {
		this.plazoSeguro = plazoSeguro;
	}

	/**
	 * Gets the seguro vida.
	 *
	 * @return the seguro vida
	 */
	public String getSeguroVida() {
		return seguroVida;
	}

	/**
	 * Sets the seguro vida.
	 *
	 * @param seguroVida the new seguro vida
	 */
	public void setSeguroVida(String seguroVida) {
		this.seguroVida = seguroVida;
	}

	/**
	 * Gets the plazo credito.
	 *
	 * @return the plazo credito
	 */
	public Integer getPlazoCredito() {
		return plazoCredito;
	}

	/**
	 * Sets the plazo credito.
	 *
	 * @param plazoCredito the new plazo credito
	 */
	public void setPlazoCredito(Integer plazoCredito) {
		this.plazoCredito = plazoCredito;
	}

	/**
	 * Gets the seguro enfermedad.
	 *
	 * @return the seguro enfermedad
	 */
	public String getSeguroEnfermedad() {
		return seguroEnfermedad;
	}

	/**
	 * Sets the seguro enfermedad.
	 *
	 * @param seguroEnfermedad the new seguro enfermedad
	 */
	public void setSeguroEnfermedad(String seguroEnfermedad) {
		this.seguroEnfermedad = seguroEnfermedad;
	}

	/**
	 * Gets the costo seguro vida.
	 *
	 * @return the costo seguro vida
	 */
	public Double getCostoSeguroVida() {
		return costoSeguroVida;
	}

	/**
	 * Sets the costo seguro vida.
	 *
	 * @param costoSeguroVida the new costo seguro vida
	 */
	public void setCostoSeguroVida(Double costoSeguroVida) {
		this.costoSeguroVida = costoSeguroVida;
	}

	/**
	 * Gets the costo seguro enfermedad.
	 *
	 * @return the costo seguro enfermedad
	 */
	public Double getCostoSeguroEnfermedad() {
		return costoSeguroEnfermedad;
	}

	/**
	 * Sets the costo seguro enfermedad.
	 *
	 * @param costoSeguroEnfermedad the new costo seguro enfermedad
	 */
	public void setCostoSeguroEnfermedad(Double costoSeguroEnfermedad) {
		this.costoSeguroEnfermedad = costoSeguroEnfermedad;
	}

}
