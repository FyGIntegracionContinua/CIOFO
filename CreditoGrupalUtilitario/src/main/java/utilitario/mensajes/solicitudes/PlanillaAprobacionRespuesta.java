package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class PlanillaAprobacionRespuesta.
 *
 * @author out_gcorzo
 */
public class PlanillaAprobacionRespuesta extends ObjetoValor {

	/**
	 * Instancia un nuevo Integrante planilla aprobaciones respuesta.
	 */
	public PlanillaAprobacionRespuesta() {
	}
	/** Se genero nuevo serial. */
	private static final long serialVersionUID = 4771230139176220692L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The listaIntegrantesPlanAprob. */
	private List<IntegrantePlanillaAprobOV> listaIntegrantesPlanAprob;

	/**
	 * @return the listaIntegrantesPlanAprob
	 */
	public List<IntegrantePlanillaAprobOV> getListaIntegrantesPlanAprob() {
		return listaIntegrantesPlanAprob;
	}

	/**
	 * @param listaIntegrantesPlanAprob the listaIntegrantesPlanAprob to set
	 */
	public void setListaIntegrantesPlanAprob(
			List<IntegrantePlanillaAprobOV> listaIntegrantesPlanAprob) {
		this.listaIntegrantesPlanAprob = listaIntegrantesPlanAprob;
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
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

}
