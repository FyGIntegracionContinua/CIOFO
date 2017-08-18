/**
 *
 */
package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ca.ocampo
 *
 */
public class AsesoresOV extends ObjetoValor {

	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = -4422083567959828505L;

	/**
	 * AsesoresOV
	 */
	public AsesoresOV() {

	}

	/** numero de persona. */
	private String persona;

	/** sucursal. */
	private String sucursal;

	/** nombre de persona. */
	private String nombre;

	/** apellidoPaterno de persona. */
	private String apellidoPaterno;

	/** apellidoMaterno de persona. */
	private String apellidoMaterno;

	/** participaCampana3 de persona. */
	private String participaCampana3;

	/**
	 * @return the persona
	 */
	public String getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(String persona) {
		this.persona = persona;
	}

	/**
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the participaCampana3
	 */
	public String getParticipaCampana3() {
		return participaCampana3;
	}

	/**
	 * @param participaCampana3 the participaCampana3 to set
	 */
	public void setParticipaCampana3(String participaCampana3) {
		this.participaCampana3 = participaCampana3;
	}	


}
