package utilitario.mensajes.operacion.pagos;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AplicarPagoConexiaPeticion.
 */
public class AplicarPagoConexiaPeticion extends ObjetoValor {

	/**
	 * AplicarPagoConexiaPeticion
	 */
	public AplicarPagoConexiaPeticion() {
		super();
	}
	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = 787155599882821438L;
	/**
	 * numeroContrato java.lang.String
	 */
	private java.lang.String 	numeroContrato;
	/**
	 * numeroIntegrante java.lang.String
	 */
	private java.lang.String 	numeroIntegrante;
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
	 * @return the numeroIntegrante
	 */
	public java.lang.String getNumeroIntegrante() {
		return numeroIntegrante;
	}
	/**
	 * @param numeroIntegrante the numeroIntegrante to set
	 */
	public void setNumeroIntegrante(java.lang.String numeroIntegrante) {
		this.numeroIntegrante = numeroIntegrante;
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

}
