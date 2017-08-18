package utilitario.mensajes.operacion.pagos;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class CancelarMovimientosPeticion.
 */
public 	class 	CancelarMovimientosPeticion
		extends ObjetoValor	{

	/** Identificador para serializacion. */
	private static final long serialVersionUID = 2315670351720432487L;

	//Atributos privados  ----------------------------------------------------------------------------
	/** The contrato. */
	private java.lang.String 						contrato;

	/** The tipo movimiento. */
	private java.lang.String 						tipoMovimiento;

	/** The usuario. */
	private java.lang.String 						usuario;

	/** The transacciones. */
	private java.util.List<DetalleTransaccionOV> 	transacciones;

	//Constructores  ---------------------------------------------------------------------------------
	/**
	 * Instancia una nueva cancelar movimientos peticion.
	 */
	public CancelarMovimientosPeticion() {

		}

	//Get and Set  -----------------------------------------------------------------------------------
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
	 * Obtiene tipo movimiento.
	 *
	 * @return the tipoMovimiento
	 */
	public java.lang.String getTipoMovimiento() {
		return tipoMovimiento;
	}

	/**
	 * Establece tipo movimiento.
	 *
	 * @param tipoMovimiento the tipoMovimiento to set
	 */
	public void setTipoMovimiento(java.lang.String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	/**
	 * Obtiene usuario.
	 *
	 * @return the usuario
	 */
	public java.lang.String getUsuario() {
		return usuario;
	}

	/**
	 * Establece usuario.
	 *
	 * @param usuario the usuario to set
	 */
	public void setUsuario(java.lang.String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Obtiene transacciones.
	 *
	 * @return the transacciones
	 */
	public java.util.List<DetalleTransaccionOV> getTransacciones() {
		return transacciones;
	}

	/**
	 * Establece transacciones.
	 *
	 * @param transacciones the transacciones to set
	 */
	public void setTransacciones(java.util.List<DetalleTransaccionOV> transacciones) {
		this.transacciones = transacciones;
	}

}
