package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class HistoricoPlanillaObservOV.
 *
 * @author out_gcorzo
 * @version 1.0
 */
public class HistoricoPlanillaObservOV extends ObjetoValor {

	/** Se genero serial. */
	private static final long serialVersionUID = 4130257470142059818L;

	/**
	 * Instancia una nueva historico planilla observacion ov.
	 */
	public HistoricoPlanillaObservOV() {
	}

	/** The idAtomo. */
	private Integer idAtomo;

	/** The horaRegistro. */
	private String horaRegistro;

	/** The comentario. */
	private String comentario;

	/** The observacion. */
	private String observacion;

	/** The seccion. */
	private String seccion;

	/** The agrupamiento. */
	private Integer agrupamiento;

	/**
	 * @return the agrupamiento
	 */
	public Integer getAgrupamiento() {
		return agrupamiento;
	}

	/**
	 * @param agrupamiento the agrupamiento to set
	 */
	public void setAgrupamiento(Integer agrupamiento) {
		this.agrupamiento = agrupamiento;
	}

	/**
	 * @return the idAtomo
	 */
	public Integer getIdAtomo() {
		return idAtomo;
	}

	/**
	 * @param idAtomo the idAtomo to set
	 */
	public void setIdAtomo(Integer idAtomo) {
		this.idAtomo = idAtomo;
	}

	/**
	 * @return the horaRegistro
	 */
	public String getHoraRegistro() {
		return horaRegistro;
	}

	/**
	 * @param horaRegistro the horaRegistro to set
	 */
	public void setHoraRegistro(String horaRegistro) {
		this.horaRegistro = horaRegistro;
	}

	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	/**
	 * @return the seccion
	 */
	public String getSeccion() {
		return seccion;
	}

	/**
	 * @param seccion the seccion to set
	 */
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
}
