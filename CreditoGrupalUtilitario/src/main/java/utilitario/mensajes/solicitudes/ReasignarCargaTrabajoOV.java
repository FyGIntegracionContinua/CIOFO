package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class ReasignarCargaTrabajoOV.
 *
 * @author rguadarramac
 * @version 1.0
 */
public class ReasignarCargaTrabajoOV extends ObjetoValor {

	/**
	 * Instancia una nueva reasignar carga trabajo ov.
	 */
	public ReasignarCargaTrabajoOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1226981832193300168L;

	/** The id tarea. */
	private Integer idTarea;

	/** The usuario prop. */
	private String usuarioProp;

	/** The nuevo usuario prop. */
	private String nuevoUsuarioProp;

	/** The usuario reasigna. */
	private String usuarioReasigna;

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
	 * Obtiene usuario prop.
	 *
	 * @return usuario prop
	 */
	public String getUsuarioProp() {
		return usuarioProp;
	}

	/**
	 * Establece usuario prop.
	 *
	 * @param usuarioProp a usuario prop
	 */
	public void setUsuarioProp(String usuarioProp) {
		this.usuarioProp = usuarioProp;
	}

	/**
	 * Obtiene nuevo usuario prop.
	 *
	 * @return nuevo usuario prop
	 */
	public String getNuevoUsuarioProp() {
		return nuevoUsuarioProp;
	}

	/**
	 * Establece nuevo usuario prop.
	 *
	 * @param nuevoUsuarioProp a nuevo usuario prop
	 */
	public void setNuevoUsuarioProp(String nuevoUsuarioProp) {
		this.nuevoUsuarioProp = nuevoUsuarioProp;
	}

	/**
	 * Obtiene usuario reasigna.
	 *
	 * @return usuario reasigna
	 */
	public String getUsuarioReasigna() {
		return usuarioReasigna;
	}

	/**
	 * Establece usuario reasigna.
	 *
	 * @param usuarioReasigna a usuario reasigna
	 */
	public void setUsuarioReasigna(String usuarioReasigna) {
		this.usuarioReasigna = usuarioReasigna;
	}



}
