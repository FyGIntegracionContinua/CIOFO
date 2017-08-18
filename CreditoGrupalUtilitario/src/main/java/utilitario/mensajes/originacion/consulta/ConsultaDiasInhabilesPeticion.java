/**
 * Tensegrity - Febrero 2011
 */
package utilitario.mensajes.originacion.consulta;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class ConsultaDiasInhabilesPeticion.
 */
public final class ConsultaDiasInhabilesPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva consulta dias inhabiles peticion.
	 */
	public ConsultaDiasInhabilesPeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoPeticion 		header;

	/** The body. */
	private ConsultaDiaInhabilOV 	body;

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
	public final ConsultaDiaInhabilOV getBody() {
		return body;
	}

	/**
	 * Establece body.
	 *
	 * @param body the body to set
	 */
	public final void setBody(ConsultaDiaInhabilOV body) {
		this.body = body;
	}

}
