package utilitario.mensajes.administracion.contrato;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class EliminarSaldoAFavorOV.
 *
 * @author out_mreyes
 */
public 	class 	EliminarSaldoAFavorOV
		extends ObjetoValor {

	/**
	 * Instancia una nueva eliminar saldo a favor ov.
	 */
	public EliminarSaldoAFavorOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6402648842054879796L;

	// Atributos de la clase  ----------------------------------------------------------------
	/** The id transaccion. */
	private java.lang.Integer	idTransaccion;

	/** The fecha. */
	private java.util.Date		fecha;

	/** The monto. */
	private java.lang.Double	monto;


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
	 * Obtiene fecha.
	 *
	 * @return the fecha
	 */
	public java.util.Date getFecha() {
		return fecha;
	}

	/**
	 * Establece fecha.
	 *
	 * @param fecha the fecha to set
	 */
	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Obtiene monto.
	 *
	 * @return the monto
	 */
	public java.lang.Double getMonto() {
		return monto;
	}

	/**
	 * Establece monto.
	 *
	 * @param monto the monto to set
	 */
	public void setMonto(java.lang.Double monto) {
		this.monto = monto;
	}

}
