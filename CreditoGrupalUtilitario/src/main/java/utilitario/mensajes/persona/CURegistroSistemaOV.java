package utilitario.mensajes.persona;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class CURegistroSistemaOV.
 *
 * @author out_mreyes@independencia.com.mx
 */
public 	class 	CURegistroSistemaOV extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2008481937836129991L;

	// Atributos  -----------------------------------------------------------------------
	/** The customer id. */
	private java.lang.String			customerID;

	/** The cdgem. */
	private java.lang.String			cdgem;

	/** The codigo. */
	private java.lang.String			codigo;

	/** The fecha registro. */
	private java.lang.String			fechaRegistro;

	/** The customer valid. */
	private java.lang.String			customerValid;

	// Constructor  ---------------------------------------------------------------------
	/**
	 * Instancia una nueva CU registro sistema ov.
	 */
	public CURegistroSistemaOV() {

		}

	// M&eacute;todos de acceso  ---------------------------------------------------------------
	/**
	 * Obtiene customer id.
	 *
	 * @return the customerID
	 */
	public java.lang.String getCustomerID() {
		return customerID;
	}

	/**
	 * Establece customer id.
	 *
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(java.lang.String customerID) {
		this.customerID = customerID;
	}

	/**
	 * Obtiene cdgem.
	 *
	 * @return the cdgem
	 */
	public java.lang.String getCdgem() {
		return cdgem;
	}

	/**
	 * Establece cdgem.
	 *
	 * @param cdgem the cdgem to set
	 */
	public void setCdgem(java.lang.String cdgem) {
		this.cdgem = cdgem;
	}

	/**
	 * Obtiene codigo.
	 *
	 * @return the codigo
	 */
	public java.lang.String getCodigo() {
		return codigo;
	}

	/**
	 * Establece codigo.
	 *
	 * @param codigo the codigo to set
	 */
	public void setCodigo(java.lang.String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtiene fecha registro.
	 *
	 * @return the fechaRegistro
	 */
	public java.lang.String getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * Establece fecha registro.
	 *
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(java.lang.String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * Obtiene customer valid.
	 *
	 * @return the customerValid
	 */
	public java.lang.String getCustomerValid() {
		return customerValid;
	}

	/**
	 * Establece customer valid.
	 *
	 * @param customerValid the customerValid to set
	 */
	public void setCustomerValid(java.lang.String customerValid) {
		this.customerValid = customerValid;
	}

}
