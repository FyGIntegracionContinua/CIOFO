package utilitario.mensajes.consultas;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AsignacionDetalleRespuesta.
 *
 * @author rguadarramac
 */
public class AsignacionDetalleRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva asignacion detalle respuesta.
	 */
	public AsignacionDetalleRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2616763700807344368L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The asignaciones detalle. */
	private List<AsignacionDetalleOV> asignacionesDetalle;

	/** The asignaciones detalle oracle. */
	private List<AsignacionDetalleOV> asignacionesDetalleOracle;

	/** The detalles agenda. */
	private List<DetallesAgendaOV> detallesAgenda;


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
	 * Establece asignaciones detalle.
	 *
	 * @param asignacionesDetalle a asignaciones detalle
	 */
	public void setAsignacionesDetalle(List<AsignacionDetalleOV> asignacionesDetalle) {
		this.asignacionesDetalle = asignacionesDetalle;
	}

	/**
	 * Obtiene asignaciones detalle.
	 *
	 * @return asignaciones detalle
	 */
	public List<AsignacionDetalleOV> getAsignacionesDetalle() {
		return asignacionesDetalle;
	}

	/**
	 * Establece asignaciones detalle oracle.
	 *
	 * @param asignacionesDetalleOracle a asignaciones detalle oracle
	 */
	public void setAsignacionesDetalleOracle(
			List<AsignacionDetalleOV> asignacionesDetalleOracle) {
		this.asignacionesDetalleOracle = asignacionesDetalleOracle;
	}

	/**
	 * Obtiene asignaciones detalle oracle.
	 *
	 * @return asignaciones detalle oracle
	 */
	public List<AsignacionDetalleOV> getAsignacionesDetalleOracle() {
		return asignacionesDetalleOracle;
	}

	/**
	 * Establece detalles agenda.
	 *
	 * @param detallesAgenda a detalles agenda
	 */
	public void setDetallesAgenda(List<DetallesAgendaOV> detallesAgenda) {
		this.detallesAgenda = detallesAgenda;
	}

	/**
	 * Obtiene detalles agenda.
	 *
	 * @return detalles agenda
	 */
	public List<DetallesAgendaOV> getDetallesAgenda() {
		return detallesAgenda;
	}


}
