package utilitario.mensajes.originacion.aprobacion;

import utilitario.mensajes.comun.ObjetoValor;

public class PlanillaAprobacionPeticionDTO extends ObjetoValor {

	/**
	 * constructor
	 */
	public PlanillaAprobacionPeticionDTO() {

	}
	/**
	 * LONG
	 */
	private static final long serialVersionUID = 8939890693320272384L;

	/**
	 * Solicitud Peticion
	 */
	private String solicitud;

	/**
	 * totales
	 */
	private boolean totales;

	/** The planilla json. */
	private boolean planillaJson;

	/** The id planilla. */
	private Integer idPlanilla;

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
	 * @return the totales
	 */
	public boolean isTotales() {
		return totales;
	}

	/**
	 * @param totales the totales to set
	 */
	public void setTotales(boolean totales) {
		this.totales = totales;
	}

	/**
	 * @return the planillaJson
	 */
	public boolean getPlanillaJson() {
		return planillaJson;
	}

	/**
	 * @param planillaJson the planillaJson to set
	 */
	public void setPlanillaJson(boolean planillaJson) {
		this.planillaJson = planillaJson;
	}

	/**
	 * @return the idPlanilla
	 */
	public Integer getIdPlanilla() {
		return idPlanilla;
	}

	/**
	 * @param idPlanilla the idPlanilla to set
	 */
	public void setIdPlanilla(Integer idPlanilla) {
		this.idPlanilla = idPlanilla;
	}

}
