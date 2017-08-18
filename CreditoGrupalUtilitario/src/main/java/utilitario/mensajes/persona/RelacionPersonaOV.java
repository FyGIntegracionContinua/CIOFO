package utilitario.mensajes.persona;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class RelacionPersonaOV.
 *
 * @author out_mreyes@independencia.com.mx
 */
public 	class 	RelacionPersonaOV extends ObjetoValor {

	/** UID para la serializacion. */
	private static final long serialVersionUID = -7897359978892430234L;

	// Atributos privados ---------------------------------------------------------------
	/** The numero persona. */
	private java.lang.String 			numeroPersona; //Se utiliza como llave principal

	/** The tipo relacion. */
	private java.lang.String 			tipoRelacion;

	/** The id relacion. */
	private java.lang.Integer 			idRelacion;

	/** The nombre. */
	private java.lang.String			nombre;

	/** The apellido paterno. */
	private java.lang.String 			apellidoPaterno;

	/** The apellido materno. */
	private java.lang.String 			apellidoMaterno;

	/** The clave parentesco. */
	private java.lang.String			claveParentesco;

	/** The domicilio relacion. */
	private DomicilioOV					domicilioRelacion;

	/** The telefonos relacion. */
	private java.util.List<TelefonoOV>	telefonosRelacion;

	// Constructor  ---------------------------------------------------------------------
	/**
	 * Instancia una nueva relacion persona ov.
	 */
	public RelacionPersonaOV() {

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
	 * Obtiene tipo relacion.
	 *
	 * @return the tipoRelacion
	 */
	public java.lang.String getTipoRelacion() {
		return tipoRelacion;
	}

	/**
	 * Establece tipo relacion.
	 *
	 * @param tipoRelacion the tipoRelacion to set
	 */
	public void setTipoRelacion(java.lang.String tipoRelacion) {
		this.tipoRelacion = tipoRelacion;
	}

	/**
	 * Obtiene id relacion.
	 *
	 * @return the idRelacion
	 */
	public java.lang.Integer getIdRelacion() {
		return idRelacion;
	}

	/**
	 * Establece id relacion.
	 *
	 * @param idRelacion the idRelacion to set
	 */
	public void setIdRelacion(java.lang.Integer idRelacion) {
		this.idRelacion = idRelacion;
	}

	/**
	 * Obtiene nombre.
	 *
	 * @return the nombre
	 */
	public java.lang.String getNombre() {
		return nombre;
	}

	/**
	 * Establece nombre.
	 *
	 * @param nombre the nombre to set
	 */
	public void setNombre(java.lang.String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene apellido paterno.
	 *
	 * @return the apellidoPaterno
	 */
	public java.lang.String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * Establece apellido paterno.
	 *
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(java.lang.String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * Obtiene apellido materno.
	 *
	 * @return the apellidoMaterno
	 */
	public java.lang.String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * Establece apellido materno.
	 *
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(java.lang.String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * Obtiene clave parentesco.
	 *
	 * @return the claveParentesco
	 */
	public java.lang.String getClaveParentesco() {
		return claveParentesco;
	}

	/**
	 * Establece clave parentesco.
	 *
	 * @param claveParentesco the claveParentesco to set
	 */
	public void setClaveParentesco(java.lang.String claveParentesco) {
		this.claveParentesco = claveParentesco;
	}

	/**
	 * Obtiene domicilio relacion.
	 *
	 * @return the domicilioRelacion
	 */
	public DomicilioOV getDomicilioRelacion() {
		return domicilioRelacion;
	}

	/**
	 * Establece domicilio relacion.
	 *
	 * @param domicilioRelacion the domicilioRelacion to set
	 */
	public void setDomicilioRelacion(DomicilioOV domicilioRelacion) {
		this.domicilioRelacion = domicilioRelacion;
	}

	/**
	 * Obtiene telefonos relacion.
	 *
	 * @return the telefonosRelacion
	 */
	public java.util.List<TelefonoOV> getTelefonosRelacion() {
		return telefonosRelacion;
	}

	/**
	 * Establece telefonos relacion.
	 *
	 * @param telefonosRelacion the telefonosRelacion to set
	 */
	public void setTelefonosRelacion(java.util.List<TelefonoOV> telefonosRelacion) {
		this.telefonosRelacion = telefonosRelacion;
	}

	// M&eacute;todos para acceso  -------------------------------------------------------------
	/**
	 * @return the persona
	 */


}
