package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class PlanillaObservacionesRespuesta.
 *
 * @author rguadarramac
 */
public class SolicitudPlanillaAprobacionRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva planilla observaciones respuesta.
	 */
	public SolicitudPlanillaAprobacionRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6451899559144662886L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The planilla observaciones. */
	private List<PlanillaObservacionesOV> planillaObservaciones;

	/** The solicitudSACG. */
	private SolicitudSACG solicitudSACG;

	/** The SolicitudSACGGrupo. */
	private SolicitudSACGGrupo SolicitudSACGGrupo;

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

	/**
	 * Establece planilla observaciones.
	 *
	 * @param planillaObservaciones a planilla observaciones
	 */
	public void setPlanillaObservaciones(List<PlanillaObservacionesOV> planillaObservaciones) {
		this.planillaObservaciones = planillaObservaciones;
	}

	/**
	 * Obtiene planilla observaciones.
	 *
	 * @return planilla observaciones
	 */
	public List<PlanillaObservacionesOV> getPlanillaObservaciones() {
		return planillaObservaciones;
	}

	/**
	 * @return the solicitudSACG
	 */
	public SolicitudSACG getSolicitudSACG() {
		return solicitudSACG;
	}

	/**
	 * @param solicitudSACG the solicitudSACG to set
	 */
	public void setSolicitudSACG(SolicitudSACG solicitudSACG) {
		this.solicitudSACG = solicitudSACG;
	}

	/**
	 * @return the solicitudSACGGrupo
	 */
	public SolicitudSACGGrupo getSolicitudSACGGrupo() {
		return SolicitudSACGGrupo;
	}

	/**
	 * @param solicitudSACGGrupo the solicitudSACGGrupo to set
	 */
	public void setSolicitudSACGGrupo(SolicitudSACGGrupo solicitudSACGGrupo) {
		SolicitudSACGGrupo = solicitudSACGGrupo;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
