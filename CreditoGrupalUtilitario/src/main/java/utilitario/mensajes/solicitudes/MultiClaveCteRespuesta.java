package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class MultiClaveCteRespuesta.
 */
public class MultiClaveCteRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva multi clave cte respuesta.
	 */
	public MultiClaveCteRespuesta() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8682934025372945815L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The multi claves. */
	private List<ClaveCliente> multiClaves;

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
	 * Obtiene multi claves.
	 *
	 * @return multi claves
	 */
	public List<ClaveCliente> getMultiClaves() {
		return multiClaves;
	}

	/**
	 * Establece multi claves.
	 *
	 * @param multiClaves a multi claves
	 */
	public void setMultiClaves(List<ClaveCliente> multiClaves) {
		this.multiClaves = multiClaves;
	}

}
