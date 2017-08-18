package utilitario.mensajes.operacion.pagos;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class TraspasarPagoPeticion.
 */
public 	class 	TraspasarPagoPeticion extends ObjetoValor {

	/** Identificador para serializacion. */
	private static final long serialVersionUID = 2315670351720432487L;

	//Atributos privados  ----------------------------------------------------------------------------
	/** The contrato. */
	private java.lang.String 						contrato;

	/** The usuario. */
	private java.lang.String 						usuario;

	/** The transacciones. */
	private java.util.List<DetalleTransaccionOV>	transacciones;

	/** The pagos. */
	private java.util.List<TraspasarPagoOV> 		pagos;

	//Constructores  ---------------------------------------------------------------------------------
	/**
	 * Instancia una nueva traspasar pago peticion.
	 */
	public TraspasarPagoPeticion() {
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
	 * Obtiene pagos.
	 *
	 * @return the pagos
	 */
	public java.util.List<TraspasarPagoOV> getPagos() {
		return pagos;
	}

	/**
	 * Establece pagos.
	 *
	 * @param pagos the pagos to set
	 */
	public void setPagos(java.util.List<TraspasarPagoOV> pagos) {
		this.pagos = pagos;
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
