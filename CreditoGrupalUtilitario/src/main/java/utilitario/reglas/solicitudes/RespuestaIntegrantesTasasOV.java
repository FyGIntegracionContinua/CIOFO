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
public class RespuestaIntegrantesTasasOV extends ObjetoValor {

	/**
	 * Instantiates a new validar solicitud peticion.
	 */
	public RespuestaIntegrantesTasasOV() {
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5677000937229085332L;

	/** The cliente. */
	private String cliente;

	/** The integrante. */
	private String integrante;

	/**
	 * Gets the cliente.
	 *
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * Sets the cliente.
	 *
	 * @param cliente the new cliente
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	/**
	 * Gets the integrante.
	 *
	 * @return the integrante
	 */
	public String getIntegrante() {
		return integrante;
	}

	/**
	 * Sets the integrante.
	 *
	 * @param integrante the new integrante
	 */
	public void setIntegrante(String integrante) {
		this.integrante = integrante;
	}


}
