package utilitario.mensajes.burocredito;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class BuroCreditoComunalRespuesta.
 */
public class BuroCreditoComunalRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva buro credito comunal respuesta.
	 */
	public BuroCreditoComunalRespuesta() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1469297753401052788L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The clientes. */
	private List<BuroCreditoComunal> clientes;

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
	 * Obtiene clientes.
	 *
	 * @return clientes
	 */
	public List<BuroCreditoComunal> getClientes() {
		return clientes;
	}

	/**
	 * Establece clientes.
	 *
	 * @param clientes a clientes
	 */
	public void setClientes(List<BuroCreditoComunal> clientes) {
		this.clientes = clientes;
	}

}
