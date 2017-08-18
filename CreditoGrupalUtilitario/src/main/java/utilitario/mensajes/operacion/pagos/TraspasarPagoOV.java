package utilitario.mensajes.operacion.pagos;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class TraspasarPagoOV.
 */
public 	class 	TraspasarPagoOV
		extends ObjetoValor	{

	/** Identificador para serializacion. */
	private static final long serialVersionUID = 2315670351720432487L;

	//Atributos privados  ----------------------------------------------------------------------------
	/** The contrato destino. */
	private java.lang.String 						contratoDestino;

	/** The fecha valor pago. */
	private java.util.Date 							fechaValorPago;

	/** The monto pago. */
	private java.lang.Double 						montoPago;

	/** The tipo aplicar. */
	private java.lang.String 						tipoAplicar;

	/** The codigo servicio. */
	private java.lang.String						codigoServicio;

	//Constructores  ---------------------------------------------------------------------------------
	/**
	 * Instancia una nueva traspasar pago ov.
	 */
	public TraspasarPagoOV() {
		}

	//Get and Set  -----------------------------------------------------------------------------------
	/**
	 * Obtiene contrato destino.
	 *
	 * @return the contratoDestino
	 */
	public java.lang.String getContratoDestino() {
		return contratoDestino;
	}

	/**
	 * Establece contrato destino.
	 *
	 * @param contratoDestino the contratoDestino to set
	 */
	public void setContratoDestino(java.lang.String contratoDestino) {
		this.contratoDestino = contratoDestino;
	}

	/**
	 * Obtiene fecha valor pago.
	 *
	 * @return the fechaValorPago
	 */
	public java.util.Date getFechaValorPago() {
		return fechaValorPago;
	}

	/**
	 * Establece fecha valor pago.
	 *
	 * @param fechaValorPago the fechaValorPago to set
	 */
	public void setFechaValorPago(java.util.Date fechaValorPago) {
		this.fechaValorPago = fechaValorPago;
	}

	/**
	 * Obtiene monto pago.
	 *
	 * @return the montoPago
	 */
	public java.lang.Double getMontoPago() {
		return montoPago;
	}

	/**
	 * Establece monto pago.
	 *
	 * @param montoPago the montoPago to set
	 */
	public void setMontoPago(java.lang.Double montoPago) {
		this.montoPago = montoPago;
	}

	/**
	 * Obtiene tipo aplicar.
	 *
	 * @return the tipoAplicar
	 */
	public java.lang.String getTipoAplicar() {
		return tipoAplicar;
	}

	/**
	 * Establece tipo aplicar.
	 *
	 * @param tipoAplicar the tipoAplicar to set
	 */
	public void setTipoAplicar(java.lang.String tipoAplicar) {
		this.tipoAplicar = tipoAplicar;
	}

	/**
	 * Obtiene codigo servicio.
	 *
	 * @return the codigoServicio
	 */
	public java.lang.String getCodigoServicio() {
		return codigoServicio;
	}

	/**
	 * Establece codigo servicio.
	 *
	 * @param codigoServicio the codigoServicio to set
	 */
	public void setCodigoServicio(java.lang.String codigoServicio) {
		this.codigoServicio = codigoServicio;
	}

}
