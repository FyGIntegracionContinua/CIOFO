package utilitario.mensajes.persona;

import utilitario.mensajes.comun.ObjetoValor;

public class ReferenciaOV extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1112252880514305131L;

	/** nombre */
	private String nombre;
	/** apellidoPaterno */
	private String apellidoPaterno;
	/** apellidoMaterno */
	private String apellidoMaterno;
	/** parentesco */
	private String parentesco;
	/** telefonoDirecto */
	private String telefonoDirecto;
	/** telefonoCelular */
	private String telefonoCelular;
	/** domicilio */
	private DomicilioOV	domicilio;

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
	 * @return the parentesco
	 */
	public String getParentesco() {
		return parentesco;
	}
	/**
	 * @param parentesco the parentesco to set
	 */
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	/**
	 * @return the telefonoDirecto
	 */
	public String getTelefonoDirecto() {
		return telefonoDirecto;
	}
	/**
	 * @param telefonoDirecto the telefonoDirecto to set
	 */
	public void setTelefonoDirecto(String telefonoDirecto) {
		this.telefonoDirecto = telefonoDirecto;
	}
	/**
	 * @return the telefonoCelular
	 */
	public String getTelefonoCelular() {
		return telefonoCelular;
	}
	/**
	 * @param telefonoCelular the telefonoCelular to set
	 */
	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}
	/**
	 * @return the domicilio
	 */
	public DomicilioOV getDomicilio() {
		return domicilio;
	}
	/**
	 * @param domicilio the domicilio to set
	 */
	public void setDomicilio(DomicilioOV domicilio) {
		this.domicilio = domicilio;
	}

}
