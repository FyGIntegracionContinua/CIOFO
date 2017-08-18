package utilitario.mensajes.burocredito;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class BuroCreditoClienteRespuesta.
 */
public class BuroCreditoClienteRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva buro credito cliente respuesta.
	 */
	public BuroCreditoClienteRespuesta() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8521103259775089467L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The cliente. */
	private BuroCreditoCliente cliente;

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
	 * Obtiene cliente.
	 *
	 * @return cliente
	 */
	public BuroCreditoCliente getCliente() {
		return cliente;
	}

	/**
	 * Establece cliente.
	 *
	 * @param cliente a cliente
	 */
	public void setCliente(BuroCreditoCliente cliente) {
		this.cliente = cliente;
	}

}
