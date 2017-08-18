/**
 *
 */
package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ca.ocampo
 *
 */
public class SolicitudExcepcionDocumental extends ObjetoValor {

	/**
	 * Instancia una nueva SolicitudExcepcionDocumental.
	 */
	public SolicitudExcepcionDocumental() {
	}
	/** Se genero serial. */
	private static final long serialVersionUID = 2506284473601617900L;

	/** The idTarea. */
	private long idTarea;

	/** The solicitud. */
	private String solicitud;

	/** The justificacionOrig. */
	private String justificacionOrig;

	/** The motivoCancelacion. */
	private String motivoCancelacion;

	/** The motivoExcepcion. */
	private String motivoExcepcion;

	/** The codigoEstatus. */
	private String codigoEstatus;

	/** The usuarioGestion. */
	private String usuarioGestion;

	/** The observaciones. */
	private String observaciones;

	/** The accion. */
	private String accion;

	/** The clienteElimina. */
	private String clienteElimina;

	/** The usuarioElimina. */
	private String usuarioElimina;

	/**
	 * @return the idTarea
	 */
	public long getIdTarea() {
		return idTarea;
	}

	/**
	 * @param idTarea the idTarea to set
	 */
	public void setIdTarea(long idTarea) {
		this.idTarea = idTarea;
	}

	/**
	 * @return the solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}

	/**
	 * @param solicitud the solicitud to set
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	/**
	 * @return the justificacionOrig
	 */
	public String getJustificacionOrig() {
		return justificacionOrig;
	}

	/**
	 * @param justificacionOrig the justificacionOrig to set
	 */
	public void setJustificacionOrig(String justificacionOrig) {
		this.justificacionOrig = justificacionOrig;
	}

	/**
	 * @return the motivoCancelacion
	 */
	public String getMotivoCancelacion() {
		return motivoCancelacion;
	}

	/**
	 * @param motivoCancelacion the motivoCancelacion to set
	 */
	public void setMotivoCancelacion(String motivoCancelacion) {
		this.motivoCancelacion = motivoCancelacion;
	}

	/**
	 * @return the motivoExcepcion
	 */
	public String getMotivoExcepcion() {
		return motivoExcepcion;
	}

	/**
	 * @param motivoExcepcion the motivoExcepcion to set
	 */
	public void setMotivoExcepcion(String motivoExcepcion) {
		this.motivoExcepcion = motivoExcepcion;
	}

	/**
	 * @return the codigoEstatus
	 */
	public String getCodigoEstatus() {
		return codigoEstatus;
	}

	/**
	 * @param codigoEstatus the codigoEstatus to set
	 */
	public void setCodigoEstatus(String codigoEstatus) {
		this.codigoEstatus = codigoEstatus;
	}

	/**
	 * @return the usuarioGestion
	 */
	public String getUsuarioGestion() {
		return usuarioGestion;
	}

	/**
	 * @param usuarioGestion the usuarioGestion to set
	 */
	public void setUsuarioGestion(String usuarioGestion) {
		this.usuarioGestion = usuarioGestion;
	}

	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 * @return the accion
	 */
	public String getAccion() {
		return accion;
	}

	/**
	 * @param accion the accion to set
	 */
	public void setAccion(String accion) {
		this.accion = accion;
	}

	/**
	 * @return the clienteElimina
	 */
	public String getClienteElimina() {
		return clienteElimina;
	}

	/**
	 * @param clienteElimina the clienteElimina to set
	 */
	public void setClienteElimina(String clienteElimina) {
		this.clienteElimina = clienteElimina;
	}

	/**
	 * @return the usuarioElimina
	 */
	public String getUsuarioElimina() {
		return usuarioElimina;
	}

	/**
	 * @param usuarioElimina the usuarioElimina to set
	 */
	public void setUsuarioElimina(String usuarioElimina) {
		this.usuarioElimina = usuarioElimina;
	}


}
