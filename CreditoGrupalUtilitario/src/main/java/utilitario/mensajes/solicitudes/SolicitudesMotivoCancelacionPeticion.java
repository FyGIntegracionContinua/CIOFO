package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SolicitudesRep.
 *
 * @author rguadarrama
 * @version 1.0
 */
public class SolicitudesMotivoCancelacionPeticion extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4320280692278932110L;

	/** The solicitud. */
	private String solicitud;

	/**
	 * Instancia una nueva solicitudes
	 */
	public SolicitudesMotivoCancelacionPeticion() {
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
}
