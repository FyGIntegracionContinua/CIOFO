package utilitario.mensajes.persona;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;

public class PerfilTemporal extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4413535044191866565L;

	/** clave del usuario */
	private String claveUsuario;
	/** clave del perfil normal */
	private int idPerfil;
	/** clave del perfil temporal */
	private int idPerfilTemporal;
	/** clave del usuario de la peticion */
	private String usuario;
	/** clave de la sucursal que se le va asignar */
	private int idSucursal;
	/** nombre de la sucursal que se le va asignar */
	private String nombreSucursal;
	/** periodo del permiso en dias */
	private int periodo;
	/** estatus del permiso */
	private String estatus;
	/** vigencia del permiso en dias */
	private Date vigencia;
	/** inicio del permiso en dias */
	private Date fechaInicioPermiso;
	/**
	 * @return the claveUsuario
	 */
	public String getClaveUsuario() {
		return claveUsuario;
	}
	/**
	 * @param claveUsuario the claveUsuario to set
	 */
	public void setClaveUsuario(String claveUsuario) {
		this.claveUsuario = claveUsuario;
	}
	/**
	 * @return the idPerfil
	 */
	public int getIdPerfil() {
		return idPerfil;
	}
	/**
	 * @param idPerfil the idPerfil to set
	 */
	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}
	/**
	 * @return the idPerfilTemporal
	 */
	public int getIdPerfilTemporal() {
		return idPerfilTemporal;
	}
	/**
	 * @param idPerfilTemporal the idPerfilTemporal to set
	 */
	public void setIdPerfilTemporal(int idPerfilTemporal) {
		this.idPerfilTemporal = idPerfilTemporal;
	}
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the idSucursal
	 */
	public int getIdSucursal() {
		return idSucursal;
	}
	/**
	 * @param idSucursal the idSucursal to set
	 */
	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}
	/**
	 * @return the periodo
	 */
	public int getPeriodo() {
		return periodo;
	}
	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}
	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	/**
	 * @return the vigencia
	 */
	public Date getVigencia() {
		return vigencia;
	}
	/**
	 * @param vigencia the vigencia to set
	 */
	public void setVigencia(Date vigencia) {
		this.vigencia = vigencia;
	}
	/**
	 * @return the fechaInicioPermiso
	 */
	public Date getFechaInicioPermiso() {
		return fechaInicioPermiso;
	}
	/**
	 * @param fechaInicioPermiso the fechaInicioPermiso to set
	 */
	public void setFechaInicioPermiso(Date fechaInicioPermiso) {
		this.fechaInicioPermiso = fechaInicioPermiso;
	}
	/**
	 * @return the nombreSucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}
	/**
	 * @param nombreSucursal the nombreSucursal to set
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

}
