/**
 *
 */
package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ca.ocampo
 *
 */
public class ConsultaSolicitudPlanillaObservacionesPeticion  extends ObjetoValor {

	/**
	 * La constante serialVersionUID.
	 */
	private static final long serialVersionUID = -7199940664624461512L;

	/**
	 * Constructor
	 */
	public ConsultaSolicitudPlanillaObservacionesPeticion() {

	}

	/**
	 * número de la solictud
	 */
	private String solicitud;

	/**
	 * número de la solictud
	 */
	private String uid;

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
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

}
