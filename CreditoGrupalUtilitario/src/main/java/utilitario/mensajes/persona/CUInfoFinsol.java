/**
 *
 */
package utilitario.mensajes.persona;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class CUInfoFinsol.
 *
 * @author out_mreyes@independencia.com.mx
 */
public 	class 	CUInfoFinsol extends ObjetoValor {

	/** UID para la serializacion. */
	private static final long serialVersionUID = -7763106382949344738L;

	// Atributos  -----------------------------------------------------------------------
	/** The info finsol id. */
	private java.lang.Long				infoFinsolID;

	/** The customer id. */
	private java.lang.String			customerID;

	/** The nombre asesor. */
	private java.lang.String			nombreAsesor;

	/** The nombre grupo. */
	private java.lang.String			nombreGrupo;

	/** The branch code. */
	private java.lang.String			branchCode;

	/** The flag reg. */
	private java.lang.String			flagReg;

	/** The date insercion. */
	private java.util.Date				dateInsercion;

	/** The dao asesor. */
	private java.lang.String			daoAsesor;

	// Constructor  ---------------------------------------------------------------------
	/**
	 * Instancia una nueva CU info finsol.
	 */
	public CUInfoFinsol() {

		}

	// M&eacute;todo para acccesar  ------------------------------------------------------------
	/**
	 * Obtiene info finsol id.
	 *
	 * @return the infoFinsolID
	 */
	public java.lang.Long getInfoFinsolID() {
		return infoFinsolID;
	}

	/**
	 * Establece info finsol id.
	 *
	 * @param infoFinsolID the infoFinsolID to set
	 */
	public void setInfoFinsolID(java.lang.Long infoFinsolID) {
		this.infoFinsolID = infoFinsolID;
	}

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
	 * Obtiene nombre asesor.
	 *
	 * @return the nombreAsesor
	 */
	public java.lang.String getNombreAsesor() {
		return nombreAsesor;
	}

	/**
	 * Establece nombre asesor.
	 *
	 * @param nombreAsesor the nombreAsesor to set
	 */
	public void setNombreAsesor(java.lang.String nombreAsesor) {
		this.nombreAsesor = nombreAsesor;
	}

	/**
	 * Obtiene nombre grupo.
	 *
	 * @return the nombreGrupo
	 */
	public java.lang.String getNombreGrupo() {
		return nombreGrupo;
	}

	/**
	 * Establece nombre grupo.
	 *
	 * @param nombreGrupo the nombreGrupo to set
	 */
	public void setNombreGrupo(java.lang.String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	/**
	 * Obtiene branch code.
	 *
	 * @return the branchCode
	 */
	public java.lang.String getBranchCode() {
		return branchCode;
	}

	/**
	 * Establece branch code.
	 *
	 * @param branchCode the branchCode to set
	 */
	public void setBranchCode(java.lang.String branchCode) {
		this.branchCode = branchCode;
	}

	/**
	 * Obtiene flag reg.
	 *
	 * @return the flagReg
	 */
	public java.lang.String getFlagReg() {
		return flagReg;
	}

	/**
	 * Establece flag reg.
	 *
	 * @param flagReg the flagReg to set
	 */
	public void setFlagReg(java.lang.String flagReg) {
		this.flagReg = flagReg;
	}

	/**
	 * Obtiene date insercion.
	 *
	 * @return the dateInsercion
	 */
	public java.util.Date getDateInsercion() {
		return dateInsercion;
	}

	/**
	 * Establece date insercion.
	 *
	 * @param dateInsercion the dateInsercion to set
	 */
	public void setDateInsercion(java.util.Date dateInsercion) {
		this.dateInsercion = dateInsercion;
	}

	/**
	 * Obtiene dao asesor.
	 *
	 * @return the daoAsesor
	 */
	public java.lang.String getDaoAsesor() {
		return daoAsesor;
	}

	/**
	 * Establece dao asesor.
	 *
	 * @param daoAsesor the daoAsesor to set
	 */
	public void setDaoAsesor(java.lang.String daoAsesor) {
		this.daoAsesor = daoAsesor;
	}

}
