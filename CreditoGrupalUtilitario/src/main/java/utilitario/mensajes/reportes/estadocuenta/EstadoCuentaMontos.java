/**
 *
 */
package utilitario.mensajes.reportes.estadocuenta;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author out_mreyes
 *
 */
public 	class 	EstadoCuentaMontos extends ObjetoValor {

	/**
	 * EstadoCuentaMontos
	 */
	public EstadoCuentaMontos() {

	}
	/**
	 *
	 */
	private static final long serialVersionUID = 400630443422309851L;

	/**
	 * java.lang.Double impuestoRetenido
	 */
	private java.lang.Double  	impuestoRetenido;
	/**
	 * java.lang.Double totalAPagar
	 */
	private java.lang.Double	totalAPagar;
	/**
	 * java.lang.Integer chequeDevuelto
	 */
	private java.lang.Integer   chequeDevuelto;
	/**
	 * java.lang.Double ajusteInteres
	 */
	private java.lang.Double	ajusteInteres;
	/**
	 * java.lang.Double interesOrdinario
	 */
	private java.lang.Double	interesOrdinario;
	/**
	 * java.lang.Double nuevoInteresOrdinario
	 */
	private java.lang.Double 	nuevoInteresOrdinario;

	/**
	 * java.lang.Double nuevoInteresOrdinario
	 */
	private java.lang.Double 	depositoMontoGarantia;

	/**
	 * @return the impuestoRetenido
	 */
	public java.lang.Double getImpuestoRetenido() {
		return impuestoRetenido;
	}

	/**
	 * @param impuestoRetenido the impuestoRetenido to set
	 */
	public void setImpuestoRetenido(java.lang.Double impuestoRetenido) {
		this.impuestoRetenido = impuestoRetenido;
	}

	/**
	 * @return the totalAPagar
	 */
	public java.lang.Double getTotalAPagar() {
		return totalAPagar;
	}

	/**
	 * @param totalAPagar the totalAPagar to set
	 */
	public void setTotalAPagar(java.lang.Double totalAPagar) {
		this.totalAPagar = totalAPagar;
	}

	/**
	 * @return the chequeDevuelto
	 */
	public java.lang.Integer getChequeDevuelto() {
		return chequeDevuelto;
	}

	/**
	 * @param chequeDevuelto the chequeDevuelto to set
	 */
	public void setChequeDevuelto(java.lang.Integer chequeDevuelto) {
		this.chequeDevuelto = chequeDevuelto;
	}

	/**
	 * @return the ajusteInteres
	 */
	public java.lang.Double getAjusteInteres() {
		return ajusteInteres;
	}

	/**
	 * @param ajusteInteres the ajusteInteres to set
	 */
	public void setAjusteInteres(java.lang.Double ajusteInteres) {
		this.ajusteInteres = ajusteInteres;
	}

	/**
	 * @return the interesOrdinario
	 */
	public java.lang.Double getInteresOrdinario() {
		return interesOrdinario;
	}

	/**
	 * @param interesOrdinario the interesOrdinario to set
	 */
	public void setInteresOrdinario(java.lang.Double interesOrdinario) {
		this.interesOrdinario = interesOrdinario;
	}

	/**
	 * @return the nuevoInteresOrdinario
	 */
	public java.lang.Double getNuevoInteresOrdinario() {
		return nuevoInteresOrdinario;
	}

	/**
	 * @param nuevoInteresOrdinario the nuevoInteresOrdinario to set
	 */
	public void setNuevoInteresOrdinario(java.lang.Double nuevoInteresOrdinario) {
		this.nuevoInteresOrdinario = nuevoInteresOrdinario;
	}

	/**
	 * @return the depositoMontoGarantia
	 */
	public java.lang.Double getDepositoMontoGarantia() {
		return depositoMontoGarantia;
	}

	/**
	 * @param depositoMontoGarantia the depositoMontoGarantia to set
	 */
	public void setDepositoMontoGarantia(java.lang.Double depositoMontoGarantia) {
		this.depositoMontoGarantia = depositoMontoGarantia;
	}

}
