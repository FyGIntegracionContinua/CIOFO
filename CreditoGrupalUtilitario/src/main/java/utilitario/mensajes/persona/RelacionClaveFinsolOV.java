package utilitario.mensajes.persona;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class RelacionClaveFinsolOV.
 *
 * @author out_mreyes@independencia.com.mx
 */
public 	class 	RelacionClaveFinsolOV extends ObjetoValor {

	/** UID para serializacion. */
	private static final long serialVersionUID = 2417618114020334440L;

	// Atributos  -----------------------------------------------------------------------
	/** The numero persona. */
	private java.lang.String			numeroPersona;

	/** The clave finsol. */
	private java.lang.String			claveFinsol;

	/** The clave cu. */
	private java.lang.String			claveCU;

	// Constructor  ---------------------------------------------------------------------
	/**
	 * Instancia una nueva relacion clave finsol ov.
	 */
	public RelacionClaveFinsolOV() {

		}

	// M&eacute;todos de acceso  ---------------------------------------------------------------



	/**
	 * Obtiene clave finsol.
	 *
	 * @return the claveFinsol
	 */
	public java.lang.String getClaveFinsol() {
		return claveFinsol;
	}

	/**
	 * Obtiene numero persona.
	 *
	 * @return the numeroPersona
	 */
	public java.lang.String getNumeroPersona() {
		return numeroPersona;
	}

	/**
	 * Establece numero persona.
	 *
	 * @param numeroPersona the numeroPersona to set
	 */
	public void setNumeroPersona(java.lang.String numeroPersona) {
		this.numeroPersona = numeroPersona;
	}

	/**
	 * Establece clave finsol.
	 *
	 * @param claveFinsol the claveFinsol to set
	 */
	public void setClaveFinsol(java.lang.String claveFinsol) {
		this.claveFinsol = claveFinsol;
	}

	/**
	 * Obtiene clave cu.
	 *
	 * @return the claveCU
	 */
	public java.lang.String getClaveCU() {
		return claveCU;
	}

	/**
	 * Establece clave cu.
	 *
	 * @param claveCU the claveCU to set
	 */
	public void setClaveCU(java.lang.String claveCU) {
		this.claveCU = claveCU;
	}

}
