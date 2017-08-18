package utilitario.comun.asesores;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AsesorOV.
 *
 * @author mimejorada
 *
 */
public class AsesorOV extends ObjetoValor {

	/**
	 * Instancia una nueva asesor ov.
	 */
	public AsesorOV() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The nombre. */
	private String nombre;

	/** The apellido paterno. */
	private String apellidoPaterno;

	/** The apellido materno. */
	private String apellidoMaterno;

	/** The rfc. */
	private String rfc;

	/** The daot24. */
	private String daot24;

	/** The persona. */
	private String persona;

	/** The sucursal. */
	private String sucursal;

	/**
	 * Obtiene daot24.
	 *
	 * @return the daot24
	 */
	public String getDaot24() {
		return daot24;
	}

	/**
	 * Establece daot24.
	 *
	 * @param daot24 the daot24 to set
	 */
	public void setDaot24(String daot24) {
		this.daot24 = daot24;
	}

	/**
	 * Establece nombre.
	 *
	 * @param nombre a nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene nombre.
	 *
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtiene apellido paterno.
	 *
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * Establece apellido paterno.
	 *
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * Obtiene apellido materno.
	 *
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * Establece apellido materno.
	 *
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * Obtiene rfc.
	 *
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * Establece rfc.
	 *
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	/**
	 * Obtiene sucursal.
	 *
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene persona.
	 *
	 * @return the persona
	 */
	public String getPersona() {
		return persona;
	}

	/**
	 * Establece persona.
	 *
	 * @param persona the persona to set
	 */
	public void setPersona(String persona) {
		this.persona = persona;
	}

	/**
	 * Obtiene nombre completo.
	 *
	 * @return nombre completo
	 */
	public String getNombreCompleto() {
		return
		( this.getNombre() != null ? this.getNombre() + " " : ""  )
		+ ( this.getApellidoPaterno() != null ? this.getApellidoPaterno() + " " : ""  )
		+ ( this.getApellidoMaterno() != null ? this.getApellidoMaterno() + " " : ""  );
	}

}
