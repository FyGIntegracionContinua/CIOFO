package utilitario.mensajes.administracion.contrato;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AjusteChequeDevueltoPeticion.
 *
 * @author out_mreyes
 */
public 	class 	AjusteChequeDevueltoPeticion
		extends ObjetoValor {

	/**
	 * Instancia una nueva ajuste cheque devuelto peticion.
	 */
	public AjusteChequeDevueltoPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5212148649718169355L;

	/** The numero contrato. */
	private java.lang.String 		numeroContrato;

	/** The cliente. */
	private java.lang.String 		cliente;

	/** The usuario. */
	private java.lang.String 		usuario;

	/** The fecha devolucion. */
	private java.util.Date 			fechaDevolucion;

	/** The tipo devolucion. */
	private java.lang.String 		tipoDevolucion;

	/** The tipo sucursal. */
	private int 					sucursal;

	/** The aplicar Garantia */
	private java.lang.Boolean		aplicarGarantia;

	/** The saldo Garantia */
	private java.lang.Double		saldoGarantia;

	/** The medioPago */
	private java.lang.String		medioPago;

	/** The usuario. */
	private java.lang.String 		folioCheque;

	/**
	 * Obtiene numero contrato.
	 *
	 * @return the numeroContrato
	 */
	public java.lang.String getNumeroContrato() {
		return numeroContrato;
	}

	/**
	 * Establece numero contrato.
	 *
	 * @param numeroContrato the numeroContrato to set
	 */
	public void setNumeroContrato(java.lang.String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	/**
	 * Obtiene cliente.
	 *
	 * @return the cliente
	 */
	public java.lang.String getCliente() {
		return cliente;
	}

	/**
	 * Establece cliente.
	 *
	 * @param cliente the cliente to set
	 */
	public void setCliente(java.lang.String cliente) {
		this.cliente = cliente;
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
	 * Obtiene fecha devolucion.
	 *
	 * @return the fechaDevolucion
	 */
	public java.util.Date getFechaDevolucion() {
		return fechaDevolucion;
	}

	/**
	 * Establece fecha devolucion.
	 *
	 * @param fechaDevolucion the fechaDevolucion to set
	 */
	public void setFechaDevolucion(java.util.Date fechaDevolucion) {
		this.fechaDevolucion = fechaDevolucion;
	}

	/**
	 * Obtiene tipo devolucion.
	 *
	 * @return the tipoDevolucion
	 */
	public java.lang.String getTipoDevolucion() {
		return tipoDevolucion;
	}

	/**
	 * Establece tipo devolucion.
	 *
	 * @param tipoDevolucion the tipoDevolucion to set
	 */
	public void setTipoDevolucion(java.lang.String tipoDevolucion) {
		this.tipoDevolucion = tipoDevolucion;
	}

	/**
	 * @return the sucursal
	 */
	public int getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}
	/**
	 * @return the aplicarGarantia
	 */
	public java.lang.Boolean getAplicarGarantia() {
		return aplicarGarantia;
	}
	/**
	 * @param aplicarGarantia the aplicarGarantia to set
	 */
	public void setAplicarGarantia(java.lang.Boolean aplicarGarantia) {
		this.aplicarGarantia = aplicarGarantia;
	}
	/**
	 * @return the saldoGarantia
	 */
	public java.lang.Double getSaldoGarantia() {
		return saldoGarantia;
	}
	/**
	 * @param saldoGarantia saldoGarantia the to set
	 */
	public void setSaldoGarantia(java.lang.Double saldoGarantia) {
		this.saldoGarantia = saldoGarantia;
	}
	/**
	 * @return the medio Pago
	 */
	public java.lang.String getMedioPago() {
		return medioPago;
	}
	/**
	 * @param medioPago the to set
	 */
	public void setMedioPago(java.lang.String medioPago) {
		this.medioPago = medioPago;
	}
	/**
	 * @return the folioCheque
	 */
	public java.lang.String getFolioCheque() {
		return folioCheque;
	}
	/**
	 * @param folioCheque the folioCheque to set
	 */
	public void setFolioCheque(java.lang.String folioCheque) {
		this.folioCheque = folioCheque;
	}
}
