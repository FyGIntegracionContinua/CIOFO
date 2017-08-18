/**
 *
 */
package utilitario.mensajes.persona;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultarPersonaRespuesta.
 *
 * @author rguadarrama
 */
public 	class 	ValidaPersonaRelacionesOV extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id referencia. */
	private String		nombre;

	/** The count id referencia. */
	private String		apellidoPaterno;

	/** The codigo relacion. */
	private String		codigoRelacion;

	/**
	 * Instantiates a new id referencias ov.
	 */
	public ValidaPersonaRelacionesOV() { }

	/**
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Gets the apellido paterno.
	 *
	 * @return the apellido paterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * Sets the apellido paterno.
	 *
	 * @param apellidoPaterno the new apellido paterno
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * Gets the codigo relacion.
	 *
	 * @return the codigo relacion
	 */
	public String getCodigoRelacion() {
		return codigoRelacion;
	}

	/**
	 * Sets the codigo relacion.
	 *
	 * @param codigoRelacion the new codigo relacion
	 */
	public void setCodigoRelacion(String codigoRelacion) {
		this.codigoRelacion = codigoRelacion;
	}


}
