package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class PlanillaObservacionesRespuesta.
 *
 * @author rguadarramac
 */
public class SolicitudesAlmacenadasRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva planilla observaciones respuesta.
	 */
	public SolicitudesAlmacenadasRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6451899559144662886L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The solicitudes generadas. */
	private List<SolicitudPlanillaAprobacionOV> solicitudesGeneradas;

	/**
	 * Gets the header.
	 *
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Sets the header.
	 *
	 * @param header the new header
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Gets the solicitudes generadas.
	 *
	 * @return the solicitudes generadas
	 */
	public List<SolicitudPlanillaAprobacionOV> getSolicitudesGeneradas() {
		return solicitudesGeneradas;
	}

	/**
	 * Sets the solicitudes generadas.
	 *
	 * @param solicitudesGeneradas the new solicitudes generadas
	 */
	public void setSolicitudesGeneradas(
			List<SolicitudPlanillaAprobacionOV> solicitudesGeneradas) {
		this.solicitudesGeneradas = solicitudesGeneradas;
	}
}
