package utilitario.mensajes.consultas;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AsignacionSucursalRespuesta.
 *
 * @author rguadarramac
 *
 */
public class AsignacionSucursalRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva asignacion sucursal respuesta.
	 */
	public AsignacionSucursalRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2616763700807344368L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The asignaciones. */
	private List<AsignacionOV> asignaciones;

	/** The asignaciones fuera horario. */
	private List<AsignacionOV> asignacionesFueraHorario;

	/** The asignaciones solicitud. */
	private List<AsignacionOV> asignacionesSolicitud;

	/**
	 * Obtiene asignaciones solicitud.
	 *
	 * @return asignaciones solicitud
	 */
	public List<AsignacionOV> getAsignacionesSolicitud() {
		return asignacionesSolicitud;
	}

	/**
	 * Establece asignaciones solicitud.
	 *
	 * @param asignacionesSolicitud a asignaciones solicitud
	 */
	public void setAsignacionesSolicitud(List<AsignacionOV> asignacionesSolicitud) {
		this.asignacionesSolicitud = asignacionesSolicitud;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece asignaciones.
	 *
	 * @param asignaciones a asignaciones
	 */
	public void setAsignaciones(List<AsignacionOV> asignaciones) {
		this.asignaciones = asignaciones;
	}

	/**
	 * Obtiene asignaciones.
	 *
	 * @return asignaciones
	 */
	public List<AsignacionOV> getAsignaciones() {
		return asignaciones;
	}

	/**
	 * Obtiene asignaciones fuera horario.
	 *
	 * @return asignaciones fuera horario
	 */
	public List<AsignacionOV> getAsignacionesFueraHorario() {
		return asignacionesFueraHorario;
	}

	/**
	 * Establece asignaciones fuera horario.
	 *
	 * @param asignacionesFueraHorario a asignaciones fuera horario
	 */
	public void setAsignacionesFueraHorario(
			List<AsignacionOV> asignacionesFueraHorario) {
		this.asignacionesFueraHorario = asignacionesFueraHorario;
	}


}
