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
public class ObtenerParametrosTasasOV extends ObjetoValor {

	/**
	 * Instantiates a new validar solicitud peticion.
	 */
	public ObtenerParametrosTasasOV() {
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5677000937229085332L;

	/** The solicitud. */
	private String parametro;

	/** The contrato. */
	private String descParametro;

	/** The valor. */
	private String valor;

	/**
	 * Gets the parametro.
	 *
	 * @return the parametro
	 */
	public String getParametro() {
		return parametro;
	}

	/**
	 * Sets the parametro.
	 *
	 * @param parametro the new parametro
	 */
	public void setParametro(String parametro) {
		this.parametro = parametro;
	}

	/**
	 * Gets the desc parametro.
	 *
	 * @return the desc parametro
	 */
	public String getDescParametro() {
		return descParametro;
	}

	/**
	 * Sets the desc parametro.
	 *
	 * @param descParametro the new desc parametro
	 */
	public void setDescParametro(String descParametro) {
		this.descParametro = descParametro;
	}

	/**
	 * Gets the valor.
	 *
	 * @return the valor
	 */
	public String getValor() {
		return valor;
	}

	/**
	 * Sets the valor.
	 *
	 * @param valor the new valor
	 */
	public void setValor(String valor) {
		this.valor = valor;
	}

}
