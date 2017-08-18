package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class PeticionRFCOV.
 *
 * @author mi.mejorada
 */
public class PeticionRFCOV extends ObjetoValor {

	/**
	 * SucursalOV.
	 */
	public PeticionRFCOV() {

	}

	/** serialVersionUID long. */
	private static final long serialVersionUID = 4624718408909104962L;

	/** The nombre. */
	private String nombre;

	/** The ap paterno. */
	private String apPaterno;

	/** The ap materno. */
	private String apMaterno;

	/** The fecha nacimiento. */
	private String fechaNacimiento;

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
	 * Gets the ap paterno.
	 *
	 * @return the ap paterno
	 */
	public String getApPaterno() {
		return apPaterno;
	}

	/**
	 * Sets the ap paterno.
	 *
	 * @param apPaterno the new ap paterno
	 */
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	/**
	 * Gets the ap materno.
	 *
	 * @return the ap materno
	 */
	public String getApMaterno() {
		return apMaterno;
	}

	/**
	 * Sets the ap materno.
	 *
	 * @param apMaterno the new ap materno
	 */
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}

	/**
	 * Gets the fecha nacimiento.
	 *
	 * @return the fecha nacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Sets the fecha nacimiento.
	 *
	 * @param fechaNacimiento the new fecha nacimiento
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
