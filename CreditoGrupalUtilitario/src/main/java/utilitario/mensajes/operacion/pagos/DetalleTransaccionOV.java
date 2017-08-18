/**
 *
 */
package utilitario.mensajes.operacion.pagos;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class DetalleTransaccionOV.
 *
 * @author out_mreyes
 */
public 	class 	DetalleTransaccionOV extends ObjetoValor {

	/**
	 * Instancia una nueva detalle transaccion ov.
	 */
	public DetalleTransaccionOV() { }
	/** Id para serializacion. */
	private static final long serialVersionUID = 4309736346561809936L;

	//Atributos privados  ---------------------------------------------------------------------------
	/** The id transaccion. */
	private java.lang.Integer		idTransaccion;

	/** The fecha contable. */
	private java.util.Date			fechaContable;

	/** The monto cancelacion. */
	private java.lang.Double		montoCancelacion;

	//Get and Set  ----------------------------------------------------------------------------------
	/**
	 * Obtiene id transaccion.
	 *
	 * @return the idTransaccion
	 */
	public java.lang.Integer getIdTransaccion() {
		return idTransaccion;
	}

	/**
	 * Establece id transaccion.
	 *
	 * @param idTransaccion the idTransaccion to set
	 */
	public void setIdTransaccion(java.lang.Integer idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	/**
	 * Obtiene fecha contable.
	 *
	 * @return the fechaContable
	 */
	public java.util.Date getFechaContable() {
		return fechaContable;
	}

	/**
	 * Establece fecha contable.
	 *
	 * @param fechaContable the fechaContable to set
	 */
	public void setFechaContable(java.util.Date fechaContable) {
		this.fechaContable = fechaContable;
	}

	/**
	 * Obtiene monto cancelacion.
	 *
	 * @return the montoCancelacion
	 */
	public java.lang.Double getMontoCancelacion() {
		return montoCancelacion;
	}

	/**
	 * Establece monto cancelacion.
	 *
	 * @param montoCancelacion the montoCancelacion to set
	 */
	public void setMontoCancelacion(java.lang.Double montoCancelacion) {
		this.montoCancelacion = montoCancelacion;
	}

}
