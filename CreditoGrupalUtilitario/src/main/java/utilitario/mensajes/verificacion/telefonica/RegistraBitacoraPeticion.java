package utilitario.mensajes.verificacion.telefonica;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author rguadarramac
 *
 */
public class RegistraBitacoraPeticion  extends ObjetoValor {

	/**
	 * RegistraBitacoraPeticion
	 */
	public RegistraBitacoraPeticion() {

	}
	/**
	 *
	 */
	private static final long serialVersionUID = 6727126616411338936L;
	/**
	 * EncabezadoPeticion header
	 */
	private EncabezadoPeticion	header;
	/**
	 * String idSolicitud
	 */
	private String idSolicitud;
	/**
	 * String estatusVerificacion
	 */
	private String estatusVerificacion;
	/**
	 * java.util.Date fechaEnvioVerificacion
	 */
	private java.util.Date fechaEnvioVerificacion;
	/**
	 * java.util.Date fechaRespuestaVerificacion
	 */
	private java.util.Date fechaRespuestaVerificacion;
	/**
	 * String comentariosEnvioVerificacion
	 */
	private String comentariosEnvioVerificacion;
	/**
	 * String usuarioEnvioVerificacion
	 */
	private String usuarioEnvioVerificacion;
	/**
	 * String estatusAprobacion
	 */
	private String estatusAprobacion;
	/**
	 * java.util.Date fechaAprobacion
	 */
	private java.util.Date fechaAprobacion;
	/**
	 * String usuarioAprobacion
	 */
	private String usuarioAprobacion;
	/**
	 * boolean envioVerificacion
	 */
	private boolean envioVerificacion;
	/**
	 * boolean aprobacion
	 */
	private boolean aprobacion;
	/**
	 * boolean respuestaCC
	 */
	private boolean respuestaCC;
	/**
	 * String idSolicitudCC
	 */
	private String idSolicitudCC;


	/**
	 * Integer sucursal
	 */
	private Integer sucursal;
	/**
	 * String nombreGrupo
	 */
	private String nombreGrupo;
	/**
	 * @return the header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}
	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}
	/**
	 * @return the idSolicitud
	 */
	public String getIdSolicitud() {
		return idSolicitud;
	}
	/**
	 * @param idSolicitud the idSolicitud to set
	 */
	public void setIdSolicitud(String idSolicitud) {
		this.idSolicitud = idSolicitud;
	}
	/**
	 * @return the estatusVerificacion
	 */
	public String getEstatusVerificacion() {
		return estatusVerificacion;
	}
	/**
	 * @param estatusVerificacion the estatusVerificacion to set
	 */
	public void setEstatusVerificacion(String estatusVerificacion) {
		this.estatusVerificacion = estatusVerificacion;
	}
	/**
	 * @return the fechaEnvioVerificacion
	 */
	public java.util.Date getFechaEnvioVerificacion() {
		return fechaEnvioVerificacion;
	}
	/**
	 * @param fechaEnvioVerificacion the fechaEnvioVerificacion to set
	 */
	public void setFechaEnvioVerificacion(java.util.Date fechaEnvioVerificacion) {
		this.fechaEnvioVerificacion = fechaEnvioVerificacion;
	}
	/**
	 * @return the fechaRespuestaVerificacion
	 */
	public java.util.Date getFechaRespuestaVerificacion() {
		return fechaRespuestaVerificacion;
	}
	/**
	 * @param fechaRespuestaVerificacion the fechaRespuestaVerificacion to set
	 */
	public void setFechaRespuestaVerificacion(
			java.util.Date fechaRespuestaVerificacion) {
		this.fechaRespuestaVerificacion = fechaRespuestaVerificacion;
	}
	/**
	 * @return the comentariosEnvioVerificacion
	 */
	public String getComentariosEnvioVerificacion() {
		return comentariosEnvioVerificacion;
	}
	/**
	 * @param comentariosEnvioVerificacion the comentariosEnvioVerificacion to set
	 */
	public void setComentariosEnvioVerificacion(String comentariosEnvioVerificacion) {
		this.comentariosEnvioVerificacion = comentariosEnvioVerificacion;
	}
	/**
	 * @return the usuarioEnvioVerificacion
	 */
	public String getUsuarioEnvioVerificacion() {
		return usuarioEnvioVerificacion;
	}
	/**
	 * @param usuarioEnvioVerificacion the usuarioEnvioVerificacion to set
	 */
	public void setUsuarioEnvioVerificacion(String usuarioEnvioVerificacion) {
		this.usuarioEnvioVerificacion = usuarioEnvioVerificacion;
	}
	/**
	 * @return the estatusAprobacion
	 */
	public String getEstatusAprobacion() {
		return estatusAprobacion;
	}
	/**
	 * @param estatusAprobacion the estatusAprobacion to set
	 */
	public void setEstatusAprobacion(String estatusAprobacion) {
		this.estatusAprobacion = estatusAprobacion;
	}
	/**
	 * @return the fechaAprobacion
	 */
	public java.util.Date getFechaAprobacion() {
		return fechaAprobacion;
	}
	/**
	 * @param fechaAprobacion the fechaAprobacion to set
	 */
	public void setFechaAprobacion(java.util.Date fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion;
	}
	/**
	 * @return the usuarioAprobacion
	 */
	public String getUsuarioAprobacion() {
		return usuarioAprobacion;
	}
	/**
	 * @param usuarioAprobacion the usuarioAprobacion to set
	 */
	public void setUsuarioAprobacion(String usuarioAprobacion) {
		this.usuarioAprobacion = usuarioAprobacion;
	}
	/**
	 * @return the envioVerificacion
	 */
	public boolean isEnvioVerificacion() {
		return envioVerificacion;
	}
	/**
	 * @param envioVerificacion the envioVerificacion to set
	 */
	public void setEnvioVerificacion(boolean envioVerificacion) {
		this.envioVerificacion = envioVerificacion;
	}
	/**
	 * @return the aprobacion
	 */
	public boolean isAprobacion() {
		return aprobacion;
	}
	/**
	 * @param aprobacion the aprobacion to set
	 */
	public void setAprobacion(boolean aprobacion) {
		this.aprobacion = aprobacion;
	}
	/**
	 * @return the respuestaCC
	 */
	public boolean isRespuestaCC() {
		return respuestaCC;
	}
	/**
	 * @param respuestaCC the respuestaCC to set
	 */
	public void setRespuestaCC(boolean respuestaCC) {
		this.respuestaCC = respuestaCC;
	}
	/**
	 * @return the idSolicitudCC
	 */
	public String getIdSolicitudCC() {
		return idSolicitudCC;
	}
	/**
	 * @param idSolicitudCC the idSolicitudCC to set
	 */
	public void setIdSolicitudCC(String idSolicitudCC) {
		this.idSolicitudCC = idSolicitudCC;
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
