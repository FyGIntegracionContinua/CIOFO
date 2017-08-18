/**
 *
 */
package utilitario.reglas.solicitudes;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultarPersonaRespuesta.
 *
 * @author rguadarrama
 */
public 	class 	ValidarTasaInteresRespuesta extends ObjetoValor {


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5677000937229085332L;

	/** The header. */
	private EncabezadoRespuesta			header;

	/** The tasa minima. */
	private Double tasaMinima;

	/** The tasa maxima. */
	private Double tasaMaxima;

	/**
	 * Instancia una nueva consultar persona respuesta.
	 */
	public ValidarTasaInteresRespuesta() {
		header = new EncabezadoRespuesta();
		}

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
}
