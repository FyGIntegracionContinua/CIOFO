/**
 *
 */
package utilitario.mensajes.persona;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ValidaExistePersonaPeticion.
 *
 * @author rguadarrama
 */
public 	class 	ValidaExistePersonaPeticion extends ObjetoValor {

	/** UID para serializacion. */
	private static final long serialVersionUID = -812466050146968674L;

	/** The numero persona. */
	private String nombre;

	/** The apellido paterno. */
	private String apellidoPaterno;

	/** The apellido materno. */
	private String apellidoMaterno;

	/** The fecha nacimiento. */
	private String fechaNacimiento;

	/**
	 * ConsultarPersonaPeticion.
	 */
	public ValidaExistePersonaPeticion() {

	}

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
	 * Gets the apellido materno.
	 *
	 * @return the apellido materno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * Sets the apellido materno.
	 *
	 * @param apellidoMaterno the new apellido materno
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


}
