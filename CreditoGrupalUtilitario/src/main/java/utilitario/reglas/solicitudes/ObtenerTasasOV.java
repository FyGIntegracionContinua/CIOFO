/**
 *
 */
package utilitario.reglas.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultarPersonaRespuesta.
 *
 * @author rguadarrama
 */
public class ObtenerTasasOV extends ObjetoValor {

	/**
	 * Instantiates a new validar solicitud peticion.
	 */
	public ObtenerTasasOV() {
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5677000937229085332L;

	/** The renovacion. */
	private Double tasaMaxima;

	/** The campana. */
	private Double tasaMinima;

	/** The incremento. */
	private Double incremento;


	/**
	 * Gets the tasa maxima.
	 *
	 * @return the tasa maxima
	 */
	public Double getTasaMaxima() {
		return tasaMaxima;
	}

	/**
	 * Sets the tasa maxima.
	 *
	 * @param tasaMaxima the new tasa maxima
	 */
	public void setTasaMaxima(Double tasaMaxima) {
		this.tasaMaxima = tasaMaxima;
	}

	/**
	 * Gets the tasa minima.
	 *
	 * @return the tasa minima
	 */
	public Double getTasaMinima() {
		return tasaMinima;
	}

	/**
	 * Sets the tasa minima.
	 *
	 * @param tasaMinima the new tasa minima
	 */
	public void setTasaMinima(Double tasaMinima) {
		this.tasaMinima = tasaMinima;
	}

	/**
	 * Gets the incremento.
	 *
	 * @return the incremento
	 */
	public Double getIncremento() {
		return incremento;
	}

	/**
	 * Sets the incremento.
	 *
	 * @param incremento the new incremento
	 */
	public void setIncremento(Double incremento) {
		this.incremento = incremento;
	}


}
