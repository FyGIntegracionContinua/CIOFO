/**
 * Informacion de los creditos Comunal y Solidario (por integrante)
 */
package utilitario.mensajes.impresiondocs.comun;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author hsamano
 *
 */
public class CreditoGrupalCSOV extends ObjetoValor {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 5206535456596499288L;
	/**
	 * Nombre completo del acreditado
	 */
	private String nombreAcreditado;
	/**
	 * Monto del credito en pesos otorgado al acreditado
	 */
	private double montoCreditoOtorgado;
	/**
	 * Indica si el acreditado cuenta con Seguro de Vida (SI/NO)
	 */
	private String seguroVida;
	/**
	 * Indica si el acreditado cuenta con Seguro de Enfermedades (SI/NO)
	 */
	private String seguroEnfermedad;
	/**
	 * Monto del Seguro de vida del acreditado
	 */
	private double montoSeguroVida;
	/**
	 * Monto del Seguro de enfermedades del acreditado
	 */
	private double montoSeguroEnfermedad;
	/**
	 * Plazo del Seguro de vida en semanas
	 */
	private String plazoSeguroVida;
	/**
	 * Plazo del Seguro de enfermedades en semanas
	 */
	private String plazoSeguroEnfermedad;
	/**
	 * @return the nombreAcreditado
	 */
	public String getNombreAcreditado() {
		return nombreAcreditado;
	}
	/**
	 * @param nombreAcreditado the nombreAcreditado to set
	 */
	public void setNombreAcreditado(String nombreAcreditado) {
		this.nombreAcreditado = nombreAcreditado;
	}
	/**
	 * @return the montoCreditoOtorgado
	 */
	public double getMontoCreditoOtorgado() {
		return montoCreditoOtorgado;
	}
	/**
	 * @param montoCreditoOtorgado the montoCreditoOtorgado to set
	 */
	public void setMontoCreditoOtorgado(double montoCreditoOtorgado) {
		this.montoCreditoOtorgado = montoCreditoOtorgado;
	}
	/**
	 * @return the seguroVida
	 */
	public String getSeguroVida() {
		return seguroVida;
	}
	/**
	 * @param seguroVida the seguroVida to set
	 */
	public void setSeguroVida(String seguroVida) {
		this.seguroVida = seguroVida;
	}
	/**
	 * @return the seguroEnfermedad
	 */
	public String getSeguroEnfermedad() {
		return seguroEnfermedad;
	}
	/**
	 * @param seguroEnfermedad the seguroEnfermedad to set
	 */
	public void setSeguroEnfermedad(String seguroEnfermedad) {
		this.seguroEnfermedad = seguroEnfermedad;
	}
	/**
	 * @return the montoSeguroVida
	 */
	public double getMontoSeguroVida() {
		return montoSeguroVida;
	}
	/**
	 * @param montoSeguroVida the montoSeguroVida to set
	 */
	public void setMontoSeguroVida(double montoSeguroVida) {
		this.montoSeguroVida = montoSeguroVida;
	}
	/**
	 * @return the montoSeguroEnfermedad
	 */
	public double getMontoSeguroEnfermedad() {
		return montoSeguroEnfermedad;
	}
	/**
	 * @param montoSeguroEnfermedad the montoSeguroEnfermedad to set
	 */
	public void setMontoSeguroEnfermedad(double montoSeguroEnfermedad) {
		this.montoSeguroEnfermedad = montoSeguroEnfermedad;
	}
	/**
	 * @return the plazoSeguroEnfermedad
	 */
	public String getPlazoSeguroEnfermedad() {
		return plazoSeguroEnfermedad;
	}
	/**
	 * @param plazoSeguroEnfermedad the plazoSeguroEnfermedad to set
	 */
	public void setPlazoSeguroEnfermedad(String plazoSeguroEnfermedad) {
		this.plazoSeguroEnfermedad = plazoSeguroEnfermedad;
	}
	/**
	 * @return the plazoSeguroVida
	 */
	public String getPlazoSeguroVida() {
		return plazoSeguroVida;
	}
	/**
	 * @param plazoSeguroVida the plazoSeguroVida to set
	 */
	public void setPlazoSeguroVida(String plazoSeguroVida) {
		this.plazoSeguroVida = plazoSeguroVida;
	}
}
