package utilitario.mensajes.solicitudes;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class SemaforoSolicitudesOV.
 *
 * @author out_gcorzo
 * @version 1.0
 */
public class SemaforoSolicitudesOV extends ObjetoValor {

	/**
	 * Instancia un nuevo codigo ov.
	 */
	public SemaforoSolicitudesOV() {
	}
	/** Se genero serial. */
	private static final long serialVersionUID = 31905069059425868L;

	/** The solicitud. */
	private String solicitud;

	/** The montoSolicitado. */
	private double montoSolicitado;

	/** The montoAprobado. */
	private double montoAprobado;

	/** The estatusRevision. */
	private String estatusRevision;

	/** The semaforo. */
	private String semaforo;

	/** The fechaInicioGestion. */
	private Date fechaInicioGestion;

	/** The fechaTermino. */
	private Date fechaTermino;

	/** The fechaObservaciones. */
	private String fechaObservaciones;

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
	 * @return the montoSolicitado
	 */
	public double getMontoSolicitado() {
		return montoSolicitado;
	}

	/**
	 * @param montoSolicitado the montoSolicitado to set
	 */
	public void setMontoSolicitado(double montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}

	/**
	 * @return the montoAprobado
	 */
	public double getMontoAprobado() {
		return montoAprobado;
	}

	/**
	 * @param montoAprobado the montoAprobado to set
	 */
	public void setMontoAprobado(double montoAprobado) {
		this.montoAprobado = montoAprobado;
	}

	/**
	 * @return the estatusRevision
	 */
	public String getEstatusRevision() {
		return estatusRevision;
	}

	/**
	 * @param estatusRevision the estatusRevision to set
	 */
	public void setEstatusRevision(String estatusRevision) {
		this.estatusRevision = estatusRevision;
	}

	/**
	 * @return the semaforo
	 */
	public String getSemaforo() {
		return semaforo;
	}

	/**
	 * @param semaforo the semaforo to set
	 */
	public void setSemaforo(String semaforo) {
		this.semaforo = semaforo;
	}

	/**
	 * @return the fechaInicioGestion
	 */
	public Date getFechaInicioGestion() {
		return fechaInicioGestion;
	}

	/**
	 * @param fechaInicioGestion the fechaInicioGestion to set
	 */
	public void setFechaInicioGestion(Date fechaInicioGestion) {
		this.fechaInicioGestion = fechaInicioGestion;
	}

	/**
	 * @return the fechaTermino
	 */
	public Date getFechaTermino() {
		return fechaTermino;
	}

	/**
	 * @param fechaTermino the fechaTermino to set
	 */
	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	/**
	 * @return the fechaObservaciones
	 */
	public String getFechaObservaciones() {
		return fechaObservaciones;
	}

	/**
	 * @param fechaObservaciones the fechaObservaciones to set
	 */
	public void setFechaObservaciones(String fechaObservaciones) {
		this.fechaObservaciones = fechaObservaciones;
	}

}

