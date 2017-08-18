package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaCreditoPeticion.
 */
public 	class 	ConsultaCreditoPeticion
		extends	ObjetoValor	{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 858187095999528029L;

	/** The sucursal. */
	private java.lang.Integer 	sucursal;

	/** The contrato. */
	private java.lang.String 	contrato;

	/** The usuario. */
	private java.lang.String 	usuario;

	/** The fecha desembolso. */
	private String fechaDesembolso;

	/**
	 * Instancia una nueva consulta credito peticion.
	 */
	public ConsultaCreditoPeticion() {
		}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal a sucursal
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene sucursal.
	 *
	 * @return sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Establece contrato.
	 *
	 * @param contrato a contrato
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * Obtiene contrato.
	 *
	 * @return contrato
	 */
	public String getContrato() {
		return contrato;
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
	 * @return the fechaDesembolso
	 */
	public String getFechaDesembolso() {
		return fechaDesembolso;
	}

	/**
	 * @param fechaDesembolso the fechaDesembolso to set
	 */
	public void setFechaDesembolso(String fechaDesembolso) {
		this.fechaDesembolso = fechaDesembolso;
	}

}
