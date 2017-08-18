package utilitario.mensajes.operacion.pagos;

import utilitario.mensajes.comun.ObjetoValor;

public class ConsultarPagosPeticion extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3676779019886579495L;

	/** medioPago */
	private String medioPago;
	/** referencia */
	private String referencia;
	/** fechaInicial */
	private String fechaInicial;
	/** fechaFinal */
	private String fechaFinal;
	/**
	 * @return the medioPago
	 */
	public String getMedioPago() {
		return medioPago;
	}
	/**
	 * @param medioPago the medioPago to set
	 */
	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}
	/**
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}
	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	/**
	 * @return the fechaInicial
	 */
	public String getFechaInicial() {
		return fechaInicial;
	}
	/**
	 * @param fechaInicial the fechaInicial to set
	 */
	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	/**
	 * @return the fechaFinal
	 */
	public String getFechaFinal() {
		return fechaFinal;
	}
	/**
	 * @param fechaFinal the fechaFinal to set
	 */
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

}
