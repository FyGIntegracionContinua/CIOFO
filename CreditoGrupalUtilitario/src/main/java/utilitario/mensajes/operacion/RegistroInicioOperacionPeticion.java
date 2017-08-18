package utilitario.mensajes.operacion;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class RegistroInicioOperacionPeticion.
 */
public class RegistroInicioOperacionPeticion extends ObjetoValor  {


	/**
	 * RegistroInicioOperacionPeticion.
	 */
	public RegistroInicioOperacionPeticion() {
		super();
	}

	/** serialVersionUID long. */
	private static final long serialVersionUID = 5758869577975020377L;

	/** sucursal Integer. */
	private Integer sucursal;

	/** registro Boolean. */
	private Boolean registro;

	/** usuario String. */
	private String usuario;


	/**
	 * Obtiene sucursal.
	 *
	 * @return .
	 */
	public Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal .
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene registro.
	 *
	 * @return .
	 */
	public Boolean getRegistro() {
		return registro;
	}

	/**
	 * Establece registro.
	 *
	 * @param registro .
	 */
	public void setRegistro(Boolean registro) {
		this.registro = registro;
	}

	/**
	 * Obtiene usuario.
	 *
	 * @return .
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Establece usuario.
	 *
	 * @param usuario .
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



}
