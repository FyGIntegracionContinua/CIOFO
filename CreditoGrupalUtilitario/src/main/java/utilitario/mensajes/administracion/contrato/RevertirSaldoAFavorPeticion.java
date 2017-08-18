package utilitario.mensajes.administracion.contrato;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class RevertirSaldoAFavorPeticion.
 *
 * @author out_mreyes
 */
public	class 	RevertirSaldoAFavorPeticion
		extends ObjetoValor {

	/**
	 * Instancia una nueva revertir saldo a favor peticion.
	 */
	public RevertirSaldoAFavorPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3865081461038783371L;

	// Atributos de la clase  ---------------------------------------------------------------
	/** The id transaccion. */
	private java.lang.Integer	idTransaccion;

	/** The fecha. */
	private java.util.Date		fecha;

	/** The contrato. */
	private java.lang.String	contrato;

	/** The operador. */
	private java.lang.String	operador;

	/** The monto. */
	private java.lang.Double	monto;

	// Metodos  -----------------------------------------------------------------------------
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
	 * Obtiene contrato.
	 *
	 * @return the contrato
	 */
	public java.lang.String getContrato() {
		return contrato;
	}

	/**
	 * Establece contrato.
	 *
	 * @param contrato the contrato to set
	 */
	public void setContrato(java.lang.String contrato) {
		this.contrato = contrato;
	}

	/**
	 * Obtiene operador.
	 *
	 * @return the operador
	 */
	public java.lang.String getOperador() {
		return operador;
	}

	/**
	 * Establece operador.
	 *
	 * @param operador the operador to set
	 */
	public void setOperador(java.lang.String operador) {
		this.operador = operador;
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
