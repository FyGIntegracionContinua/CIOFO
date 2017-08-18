package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author out_oarias
 *
 */
public 	class 	MovimientoOV extends ObjetoValor {

	/**
	 * MovimientoOV
	 */
	public MovimientoOV() {

	}
	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = 3926766629060850005L;

	/**
	 * idTransaccion java.lang.String
	 */
	private java.lang.String	idTransaccion;
	/**
	 * fechaContable java.util.Date
	 */
	private java.util.Date		fechaContable;
	/**
	 * fechaValor java.util.Date
	 */
	private java.util.Date		fechaValor;
	/**
	 * monto java.lang.Double
	 */
	private java.lang.Double	monto;
	/**
	 * medioPago java.lang.String
	 */
	private java.lang.String	medioPago;

	//Get and Set  --------------------------------------------------------------------------------
	/**
	 * @return the idTransaccion
	 */
	public java.lang.String getIdTransaccion() {
		return idTransaccion;
	}

	/**
	 * @param idTransaccion the idTransaccion to set
	 */
	public void setIdTransaccion(java.lang.String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	/**
	 * @return the fechaContable
	 */
	public java.util.Date getFechaContable() {
		return fechaContable;
	}

	/**
	 * @param fechaContable the fechaContable to set
	 */
	public void setFechaContable(java.util.Date fechaContable) {
		this.fechaContable = fechaContable;
	}

	/**
	 * @return the fechaValor
	 */
	public java.util.Date getFechaValor() {
		return fechaValor;
	}

	/**
	 * @param fechaValor the fechaValor to set
	 */
	public void setFechaValor(java.util.Date fechaValor) {
		this.fechaValor = fechaValor;
	}

	/**
	 * @return the monto
	 */
	public java.lang.Double getMonto() {
		return monto;
	}

	/**
	 * @param monto the monto to set
	 */
	public void setMonto(java.lang.Double monto) {
		this.monto = monto;
	}

	/**
	 * @return the medioPago
	 */
	public java.lang.String getMedioPago() {
		return medioPago;
	}

	/**
	 * @param medioPago the medioPago to set
	 */
	public void setMedioPago(java.lang.String medioPago) {
		this.medioPago = medioPago;
	}

}
