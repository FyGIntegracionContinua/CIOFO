package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class PlanillaObservacionesPeticion.
 *
 * @author rguadarramac
 */
public class PlanillaObservacionesPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva planilla observaciones peticion.
	 */
	public PlanillaObservacionesPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6451899559144662886L;

	/** The solicitud. */
	private String solicitud;

	/** The usuario. */
	private String usuario;

	/** The planilla observaciones. */
	private List<PlanillaObservacionesOV> planillaObservaciones;

	/** The historico. */
	private Boolean historico;

	/**
	 * Obtiene solicitud.
	 *
	 * @return solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}

	/**
	 * Establece solicitud.
	 *
	 * @param solicitud a solicitud
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
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
	 * Establece planilla observaciones.
	 *
	 * @param planillaObservaciones a planilla observaciones
	 */
	public void setPlanillaObservaciones(
			List<PlanillaObservacionesOV> planillaObservaciones) {
		this.planillaObservaciones = planillaObservaciones;
	}

	/**
	 * Establece usuario.
	 *
	 * @param usuario a usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Obtiene usuario.
	 *
	 * @return usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Gets the historico.
	 *
	 * @return the historico
	 */
	public Boolean getHistorico() {
		return historico;
	}

	/**
	 * Sets the historico.
	 *
	 * @param historico the new historico
	 */
	public void setHistorico(Boolean historico) {
		this.historico = historico;
	}

}
