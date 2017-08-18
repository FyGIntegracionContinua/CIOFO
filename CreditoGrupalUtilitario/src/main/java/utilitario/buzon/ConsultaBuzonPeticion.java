package utilitario.buzon;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaBuzonPeticion.
 *
 * @author rguadarramac
 *
 */
public class ConsultaBuzonPeticion extends ObjetoValor {

	/**
	 * long ConsultaBuzonPeticion.java
	 */
	private static final long serialVersionUID = 2659840597574413686L;
	/**
	 * ConsultaBuzonPeticion
	 */
	public ConsultaBuzonPeticion() {

	}
	/**
	 * String ConsultaBuzonPeticion.java
	 */
	private String perfil;
	/**
	 * Integer ConsultaBuzonPeticion.java
	 */
	private Integer sucursal;
	/**
	 * @return the perfil
	 */
	/**
	 * String ConsultaBuzonPeticion.java
	 */
	private String status;
	/**
	 * String ConsultaBuzonPeticion.java
	 */
	private String tipoTarea;

	/**
	 * String ConsultaBuzonPeticion.java
	 */
	private String tipoTareaEx;

	/**
	 * String ConsultaBuzonPeticion.java
	 */
	private String usuarioPropietario;

	/**
	 * @return the tipoTareaEx
	 */
	public String getTipoTareaEx() {
		return tipoTareaEx;
	}
	/**
	 * @param tipoTareaEx the tipoTareaEx to set
	 */
	public void setTipoTareaEx(String tipoTareaEx) {
		this.tipoTareaEx = tipoTareaEx;
	}
	/**
	 * @return getPerfil :
	 */
	public String getPerfil() {
		return perfil;
	}
	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	/**
	 * @return the sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}
	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the tipoTarea
	 */
	public String getTipoTarea() {
		return tipoTarea;
	}
	/**
	 * @param tipoTarea the tipoTarea to set
	 */
	public void setTipoTarea(String tipoTarea) {
		this.tipoTarea = tipoTarea;
	}
	/**
	 * @return the usuarioPropietario
	 */
	public String getUsuarioPropietario() {
		return usuarioPropietario;
	}
	/**
	 * @param usuarioPropietario the usuarioPropietario to set
	 */
	public void setUsuarioPropietario(String usuarioPropietario) {
		this.usuarioPropietario = usuarioPropietario;
	}


}
