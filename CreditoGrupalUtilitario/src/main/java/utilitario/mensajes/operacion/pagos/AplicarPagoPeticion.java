
package utilitario.mensajes.operacion.pagos;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class AplicarPagoPeticion.
 */
public 	class 	AplicarPagoPeticion extends ObjetoValor {

	/**
	 * AplicarPagoPeticion
	 */
	public AplicarPagoPeticion() {
		super();
	}

	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = -3126017919101332051L;

	//Atributos privados  --------------------------------------------------------------------
    /**
     * numeroContrato java.lang.String
     */
    private java.lang.String 	numeroContrato;
    /**
     * usuario java.lang.String
     */
    private java.lang.String 	usuario;
    /**
     * fechaValor java.util.Date
     */
    private java.util.Date 		fechaValor;
    /**
     * monto java.lang.Double
     */
    private java.lang.Double	monto;
    /**
     * medioPago java.lang.String
     */
    private java.lang.String 	medioPago;
    /**
     * tipoAplicacion java.lang.String
     */
    private java.lang.String	tipoAplicacion;

    /**
     * tipoAplicacion banderaMedioClaveCliente
     */
    private boolean banderaMedioClaveCliente;

    /**
     * tipoAplicacion java.lang.String
     */
    private java.lang.String	referencia;

    /**
     * IdTransaccion para OXXO
     */
    private java.lang.String	idTransaccion;

	/**
	 * @return the numeroContrato
	 */
	public java.lang.String getNumeroContrato() {
		return numeroContrato;
	}

	/**
	 * @param numeroContrato the numeroContrato to set
	 */
	public void setNumeroContrato(java.lang.String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	/**
	 * @return the usuario
	 */
	public java.lang.String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(java.lang.String usuario) {
		this.usuario = usuario;
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

	/**
	 * @return the tipoAplicacion
	 */
	public java.lang.String getTipoAplicacion() {
		return tipoAplicacion;
	}

	/**
	 * @param tipoAplicacion the tipoAplicacion to set
	 */
	public void setTipoAplicacion(java.lang.String tipoAplicacion) {
		this.tipoAplicacion = tipoAplicacion;
	}

	/**
	 * @return the banderaMedioClaveCliente
	 */
	public boolean isBanderaMedioClaveCliente() {
		return banderaMedioClaveCliente;
	}

	/**
	 * @param banderaMedioClaveCliente the banderaMedioClaveCliente to set
	 */
	public void setBanderaMedioClaveCliente(boolean banderaMedioClaveCliente) {
		this.banderaMedioClaveCliente = banderaMedioClaveCliente;
	}

	/**
	 * @return the referencia
	 */
	public java.lang.String getReferencia() {
		return referencia;
	}

	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(java.lang.String referencia) {
		this.referencia = referencia;
	}

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


}
