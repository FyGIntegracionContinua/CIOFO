package utilitario.mensajes.condonaciones.comun;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class CondonacionOV.
 */
public class CondonacionOV extends ObjetoValor {

	/**
	 * Instancia una nueva condonacion ov.
	 */
	public CondonacionOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6545937432803098053L;

	/** The credito. */
	private java.lang.String  credito;

    /** The importe. */
    private java.lang.String importe;

    /** The motivo. */
    private java.lang.String motivo;

    /** The sucursal. */
    private Integer sucursal;

    /** The usuario. */
    private String usuario;

    /**
     * Obtiene credito.
     *
     * @return the credito
     */
	public java.lang.String getCredito() {
		return credito;
	}

	/**
	 * Establece credito.
	 *
	 * @param credito the credito to set
	 */
	public void setCredito(java.lang.String credito) {
		this.credito = credito;
	}

	/**
	 * Obtiene importe.
	 *
	 * @return the importe
	 */
	public java.lang.String getImporte() {
		return importe;
	}

	/**
	 * Establece importe.
	 *
	 * @param importe the importe to set
	 */
	public void setImporte(java.lang.String importe) {
		this.importe = importe;
	}

	  /**
  	 * Obtiene motivo.
  	 *
  	 * @return the motivo
  	 */
	public java.lang.String getMotivo() {
		return motivo;
	}

	/**
	 * Establece motivo.
	 *
	 * @param motivo the motivo to set
	 */
	public void setMotivo(java.lang.String motivo) {
		this.motivo = motivo;
	}

	/**
	 * Gets the sucursal.
	 *
	 * @return the sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Sets the sucursal.
	 *
	 * @param sucursal the new sucursal
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
