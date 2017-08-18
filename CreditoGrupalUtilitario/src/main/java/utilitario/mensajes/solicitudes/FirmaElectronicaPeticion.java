package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.ObjetoValor;

public class FirmaElectronicaPeticion extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6002607537975936775L;
	/** The uid. */
	private String uid;
	/** The sucursal. */
	private String sucursal;
	/** The descripcion. */
	private String descripcion;
	/** The usuarioAlta. */
	private String usuarioAlta;
	/** The perfil. */
	private String perfil;
	/** The correo. */
	private String correo;
	/** The perfil. */
	private List<String> motivos;
	/**descripcion solicitud*/
	private String motivosDescripcion;
	/** The motivoCEC. */
	private String motivoCEC;
	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the usuarioAlta
	 */
	public String getUsuarioAlta() {
		return usuarioAlta;
	}
	/**
	 * @param usuarioAlta the usuarioAlta to set
	 */
	public void setUsuarioAlta(String usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}
	/**
	 * @return the perfil
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
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * @return the motivos
	 */
	public List<String> getMotivos() {
		return motivos;
	}
	/**
	 * @param motivos the motivos to set
	 */
	public void setMotivos(List<String> motivos) {
		this.motivos = motivos;
	}
	/**
	 * @return the motivosDescripcion
	 */
	public String getMotivosDescripcion() {
		return motivosDescripcion;
	}
	/**
	 * @param motivosDescripcion the motivosDescripcion to set
	 */
	public void setMotivosDescripcion(String motivosDescripcion) {
		this.motivosDescripcion = motivosDescripcion;
	}
	/**
	 * @return the motivoCEC
	 */
	public String getMotivoCEC() {
		return motivoCEC;
	}
	/**
	 * @param motivoCEC the motivoCEC to set
	 */
	public void setMotivoCEC(String motivoCEC) {
		this.motivoCEC = motivoCEC;
	}
}
