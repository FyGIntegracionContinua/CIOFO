package utilitario.mensajes.burocredito;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class BuroCreditoContratoRespuesta.
 */
public class BuroCreditoContratoRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva buro credito contrato respuesta.
	 */
	public BuroCreditoContratoRespuesta() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8247204343356304789L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The max retraso. */
	private Integer maxRetraso;

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
	 * Obtiene max retraso.
	 *
	 * @return max retraso
	 */
	public Integer getMaxRetraso() {
		return maxRetraso;
	}

	/**
	 * Establece max retraso.
	 *
	 * @param maxRetraso a max retraso
	 */
	public void setMaxRetraso(Integer maxRetraso) {
		this.maxRetraso = maxRetraso;
	}

}
