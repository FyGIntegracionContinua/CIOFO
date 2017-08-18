/**
 * Tensegrity - Febrero 2011
 */
package utilitario.mensajes.originacion.consulta;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class ConsultaDiaHabilPeticion.
 */
public final class ConsultaDiaHabilPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva consulta dia habil peticion.
	 */
	public ConsultaDiaHabilPeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoPeticion 	header;

	/** The body. */
	private ConsultaDiaHabilOV 	body;

	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public final EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public final void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}

	/**
	 * Obtiene body.
	 *
	 * @return the body
	 */
	public final ConsultaDiaHabilOV getBody() {
		return body;
	}

	/**
	 * Establece body.
	 *
	 * @param body the body to set
	 */
	public final void setBody(ConsultaDiaHabilOV body) {
		this.body = body;
	}

}
