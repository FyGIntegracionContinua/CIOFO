package utilitario.mensajes.originacion.aprobacion;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;
import utilitario.mensajes.solicitudes.CabeceraPlanillaAprobacionOV;

public class PlanillaAprobacionRespuestaDTO  extends ObjetoValor {

	/**
	 * LONG
	 */
	private static final long serialVersionUID = 5824910257826119613L;

	/**
	 * Resultado Consulta
	 */
	private EncabezadoRespuesta 			header;

	/** The cabecera. */
	private CabeceraPlanillaAprobacionOV cabecera;

	/**
	 * Integrantes de la solicitud
	 */
	private List<IntegrantePlanillaAprobacionDTO> integrantes;

	/** The json planilla. */
	private String jsonPlanilla;

	/**
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * @return the integrantes
	 */
	public List<IntegrantePlanillaAprobacionDTO> getIntegrantes() {
		return integrantes;
	}

	/**
	 * @param integrantes the integrantes to set
	 */
	public void setIntegrantes(List<IntegrantePlanillaAprobacionDTO> integrantes) {
		this.integrantes = integrantes;
	}

	/**
	 * @return the cabecera
	 */
	public CabeceraPlanillaAprobacionOV getCabecera() {
		return cabecera;
	}

	/**
	 * @param cabecera the cabecera to set
	 */
	public void setCabecera(CabeceraPlanillaAprobacionOV cabecera) {
		this.cabecera = cabecera;
	}

	/**
	 * @return the jsonPlanilla
	 */
	public String getJsonPlanilla() {
		return jsonPlanilla;
	}

	/**
	 * @param jsonPlanilla the jsonPlanilla to set
	 */
	public void setJsonPlanilla(String jsonPlanilla) {
		this.jsonPlanilla = jsonPlanilla;
	}

}
