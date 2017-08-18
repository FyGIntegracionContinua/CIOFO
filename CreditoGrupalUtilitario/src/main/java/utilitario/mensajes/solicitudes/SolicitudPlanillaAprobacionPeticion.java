package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class PlanillaObservacionesPeticion.
 *
 * @author rguadarramac
 */
public class SolicitudPlanillaAprobacionPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva planilla observaciones peticion.
	 */
	public SolicitudPlanillaAprobacionPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6451899559144662886L;

	/** The solicitud. */
	private String solicitud;

	/** The usuario. */
	private Integer idAtomo;

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
	 * Gets the id atomo.
	 *
	 * @return the id atomo
	 */
	public Integer getIdAtomo() {
		return idAtomo;
	}

	/**
	 * Sets the id atomo.
	 *
	 * @param idAtomo the new id atomo
	 */
	public void setIdAtomo(Integer idAtomo) {
		this.idAtomo = idAtomo;
	}


}
