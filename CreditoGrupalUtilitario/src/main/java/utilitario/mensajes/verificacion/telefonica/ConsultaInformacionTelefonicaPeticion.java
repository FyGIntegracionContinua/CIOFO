package utilitario.mensajes.verificacion.telefonica;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author equipo desarrollo
 *
 */
public class ConsultaInformacionTelefonicaPeticion extends ObjetoValor {

	/**
	 * ConsultaInformacionTelefonicaPeticion
	 */
	public ConsultaInformacionTelefonicaPeticion() {

	}
	/**
	 *
	 */
	private static final long serialVersionUID = -6342670111166782027L;
	/**
	 * EncabezadoPeticion header
	 */
	private EncabezadoPeticion	header;
	/**
	 * String idSolicitud
	 */
	private String idSolicitud;
	/**
	 * String usuario
	 */
	private String usuario;
	/**
	 * String sucursal
	 */
	private Integer sucursal;
	/**
	 * String nombreGrupo
	 */
	private String nombreGrupo;
	/**
	 * @return getHeader :
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}
	/**
	 * @param header setHeader :
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}
	/**
	 * @return getIdSolicitud :
	 */
	public String getIdSolicitud() {
		return idSolicitud;
	}
	/**
	 * @param idSolicitud setIdSolicitud :
	 */
	public void setIdSolicitud(String idSolicitud) {
		this.idSolicitud = idSolicitud;
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
	 * @return the nombreGrupo
	 */
	public String getNombreGrupo() {
		return nombreGrupo;
	}
	/**
	 * @param nombreGrupo the nombreGrupo to set
	 */
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

}
