package utilitario.mensajes.convenio;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class PagosConvenioOV.
 */
public class PagosConvenioOV extends ObjetoValor {

	/**
	 * PagosConvenioOV.
	 */
	public PagosConvenioOV() {

	}

	/** serialVersionUID long. */
	private static final long serialVersionUID = -942728061459228139L;

	/** numeroPago Integer. */
	private Integer 		numeroPago;

	/** status String. */
	private String 			status;

	/** montoPago Double. */
	private Double			montoPago;

	/** montoPagado Double. */
	private Double			montoPagado;

	/** montoBonifica Double. */
	private Double			montoBonifica;
	/**
	 * fechaPactadaPago java.util.Date
	 */
	private java.util.Date	fechaPactadaPago;
	/**
	 * fechaPago java.util.Date
	 */
	private java.util.Date	fechaPago;

	/** usuarioPago String. */
	private String 			usuarioPago;

	/** observaciones String. */
	private String			observaciones;

	/**
	 * Obtiene numero pago.
	 *
	 * @return the numeroPago
	 */
	public Integer getNumeroPago() {
		return numeroPago;
	}

	/**
	 * Establece numero pago.
	 *
	 * @param numeroPago the numeroPago to set
	 */
	public void setNumeroPago(Integer numeroPago) {
		this.numeroPago = numeroPago;
	}

	/**
	 * Obtiene status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Establece status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Obtiene monto pago.
	 *
	 * @return the montoPago
	 */
	public Double getMontoPago() {
		return montoPago;
	}

	/**
	 * Establece monto pago.
	 *
	 * @param montoPago the montoPago to set
	 */
	public void setMontoPago(Double montoPago) {
		this.montoPago = montoPago;
	}

	/**
	 * Obtiene monto pagado.
	 *
	 * @return the montoPagado
	 */
	public Double getMontoPagado() {
		return montoPagado;
	}

	/**
	 * Establece monto pagado.
	 *
	 * @param montoPagado the montoPagado to set
	 */
	public void setMontoPagado(Double montoPagado) {
		this.montoPagado = montoPagado;
	}

	/**
	 * Obtiene monto bonifica.
	 *
	 * @return the montoBonifica
	 */
	public Double getMontoBonifica() {
		return montoBonifica;
	}

	/**
	 * Establece monto bonifica.
	 *
	 * @param montoBonifica the montoBonifica to set
	 */
	public void setMontoBonifica(Double montoBonifica) {
		this.montoBonifica = montoBonifica;
	}

	/**
	 * Obtiene fecha pactada pago.
	 *
	 * @return the fechaPactadaPago
	 */
	public java.util.Date getFechaPactadaPago() {
		return fechaPactadaPago;
	}

	/**
	 * Establece fecha pactada pago.
	 *
	 * @param fechaPactadaPago the fechaPactadaPago to set
	 */
	public void setFechaPactadaPago(java.util.Date fechaPactadaPago) {
		this.fechaPactadaPago = fechaPactadaPago;
	}

	/**
	 * Obtiene fecha pago.
	 *
	 * @return the fechaPago
	 */
	public java.util.Date getFechaPago() {
		return fechaPago;
	}

	/**
	 * Establece fecha pago.
	 *
	 * @param fechaPago the fechaPago to set
	 */
	public void setFechaPago(java.util.Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	/**
	 * Obtiene usuario pago.
	 *
	 * @return the usuarioPago
	 */
	public String getUsuarioPago() {
		return usuarioPago;
	}

	/**
	 * Establece usuario pago.
	 *
	 * @param usuarioPago the usuarioPago to set
	 */
	public void setUsuarioPago(String usuarioPago) {
		this.usuarioPago = usuarioPago;
	}

	/**
	 * Obtiene observaciones.
	 *
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * Establece observaciones.
	 *
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

}
