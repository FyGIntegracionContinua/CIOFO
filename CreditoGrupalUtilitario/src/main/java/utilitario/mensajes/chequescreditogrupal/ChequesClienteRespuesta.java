/**
 *
 */
package utilitario.mensajes.chequescreditogrupal;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ChequesClienteRespuesta.
 *
 * @author out_ltorres
 */
public class ChequesClienteRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva cheques cliente respuesta.
	 */
	public ChequesClienteRespuesta() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4L;

	/** The header. */
	private EncabezadoRespuesta header;

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

}
