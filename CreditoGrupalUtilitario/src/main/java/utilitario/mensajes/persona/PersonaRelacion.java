package utilitario.mensajes.persona;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class PersonaRelacion.
 */
public class PersonaRelacion extends ObjetoValor {

	/**
	 * Instancia una nueva persona relacion.
	 */
	public PersonaRelacion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7484914031642971776L;

	/** The id relacion. */
	private Long idRelacion;

	/** The persona. */
	private String persona;

	/** The nombre. */
	private String nombre;

	/** The apellido paterno. */
	private String apellidoPaterno;

	/** The apellido materno. */
	private String apellidoMaterno;

	/** The codigo relacion. */
	private String codigoRelacion;

	/**
	 * Obtiene id relacion.
	 *
	 * @return the idRelacion
	 */
	public Long getIdRelacion() {
		return idRelacion;
	}

	/**
	 * Establece id relacion.
	 *
	 * @param idRelacion the idRelacion to set
	 */
	public void setIdRelacion(Long idRelacion) {
		this.idRelacion = idRelacion;
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
	 * Obtiene nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece nombre.
	 *
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	 * Obtiene codigo relacion.
	 *
	 * @return the codigoRelacion
	 */
	public String getCodigoRelacion() {
		return codigoRelacion;
	}

	/**
	 * Establece codigo relacion.
	 *
	 * @param codigoRelacion the codigoRelacion to set
	 */
	public void setCodigoRelacion(String codigoRelacion) {
		this.codigoRelacion = codigoRelacion;
	}

}
