/**
 *
 */
package utilitario.mensajes.persona;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class DireccionElectronicaOV.
 *
 * @author out_mreyes@independencia.com.mx
 */
public 	class 	DireccionElectronicaOV extends ObjetoValor {

	/** UID para la serializacion. */
	private static final long serialVersionUID = -3091916008764485305L;

	// Atributos  -----------------------------------------------------------------------
	/** The numero persona. */
	private java.lang.String			numeroPersona;

	/** The tipo direccion electronica. */
	private java.lang.String			tipoDireccionElectronica;

	/** The direccion electronica. */
	private java.lang.String			direccionElectronica;

	/** The status. */
	private java.lang.String			status;

	// Constructor  ---------------------------------------------------------------------
	/**
	 * Instancia una nueva direccion electronica ov.
	 */
	public DireccionElectronicaOV()	{

		}

	// M&eacute;todos de acceso  ---------------------------------------------------------------


	/**
	 * Obtiene tipo direccion electronica.
	 *
	 * @return the tipoDireccionElectronica
	 */
	public java.lang.String getTipoDireccionElectronica() {
		return tipoDireccionElectronica;
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
	 * Establece tipo direccion electronica.
	 *
	 * @param tipoDireccionElectronica the tipoDireccionElectronica to set
	 */
	public void setTipoDireccionElectronica(
			java.lang.String tipoDireccionElectronica) {
		this.tipoDireccionElectronica = tipoDireccionElectronica;
	}

	/**
	 * Obtiene direccion electronica.
	 *
	 * @return the direccionElectronica
	 */
	public java.lang.String getDireccionElectronica() {
		return direccionElectronica;
	}

	/**
	 * Establece direccion electronica.
	 *
	 * @param direccionElectronica the direccionElectronica to set
	 */
	public void setDireccionElectronica(java.lang.String direccionElectronica) {
		this.direccionElectronica = direccionElectronica;
	}

	/**
	 * Obtiene status.
	 *
	 * @return the status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Establece status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

}
