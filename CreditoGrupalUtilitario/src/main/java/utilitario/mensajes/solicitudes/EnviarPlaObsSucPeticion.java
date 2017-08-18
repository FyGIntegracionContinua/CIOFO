package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class EnviarPlaObsSucPeticion.
 *
 * @author rguadarramac
 * @version 1.0
 */
public class EnviarPlaObsSucPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva enviar pla obs suc peticion.
	 */
	public EnviarPlaObsSucPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -810147433747092963L;

	/** The id tarea. */
	private Integer idTarea;

	/** The proceso. */
	private String proceso;

	/** The codigo resolucion. */
	private String codigoResolucion;

	/** The usuario. */
	private String usuario;

	/** The solicitud. */
	private String solicitud;

	/** The perfil. */
	private String perfil;

	/** The status. */
	private String status;

	/**
	 * Obtiene perfil.
	 *
	 * @return perfil
	 */
	public String getPerfil() {
		return perfil;
	}

	/**
	 * Establece perfil.
	 *
	 * @param perfil a perfil
	 */
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	/**
	 * Obtiene status.
	 *
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Establece status.
	 *
	 * @param status a status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Obtiene id tarea.
	 *
	 * @return id tarea
	 */
	public Integer getIdTarea() {
		return idTarea;
	}

	/**
	 * Establece id tarea.
	 *
	 * @param idTarea a id tarea
	 */
	public void setIdTarea(Integer idTarea) {
		this.idTarea = idTarea;
	}

	/**
	 * Obtiene proceso.
	 *
	 * @return proceso
	 */
	public String getProceso() {
		return proceso;
	}

	/**
	 * Establece proceso.
	 *
	 * @param proceso a proceso
	 */
	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	/**
	 * Obtiene codigo resolucion.
	 *
	 * @return codigo resolucion
	 */
	public String getCodigoResolucion() {
		return codigoResolucion;
	}

	/**
	 * Establece codigo resolucion.
	 *
	 * @param codigoResolucion a codigo resolucion
	 */
	public void setCodigoResolucion(String codigoResolucion) {
		this.codigoResolucion = codigoResolucion;
	}

	/**
	 * Obtiene usuario.
	 *
	 * @return usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Establece usuario.
	 *
	 * @param usuario a usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Establece solicitud.
	 *
	 * @param solicitud a solicitud
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	/**
	 * Obtiene solicitud.
	 *
	 * @return solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}

}
