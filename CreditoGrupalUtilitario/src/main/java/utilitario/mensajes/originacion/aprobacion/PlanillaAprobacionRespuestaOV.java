/**
 *
 */
package utilitario.mensajes.originacion.aprobacion;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class PlanillaAprobacionRespuestaOV.
 *
 * @author out_oarias
 */
public class PlanillaAprobacionRespuestaOV extends ObjetoValor {

	/**
	 * Instancia una nueva planilla aprobacion respuesta ov.
	 */
	public PlanillaAprobacionRespuestaOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoRespuesta 			header;

	/** The planilla. */
	private List<PlanillaAprobacionOV>  	planilla;

	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Establece planilla.
	 *
	 * @param planilla a planilla
	 */
	public void setPlanilla(List<PlanillaAprobacionOV> planilla) {
		this.planilla = planilla;
	}

	/**
	 * Obtiene planilla.
	 *
	 * @return planilla
	 */
	public List<PlanillaAprobacionOV> getPlanilla() {
		return planilla;
	}

}
