/**
 * Tensegrity - Febrero 2011
 */
package utilitario.mensajes.originacion.cliente;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ClientePeticion.
 *
 * @author Juan Moreno
 * Encapsula los datos de la peticion de registrar un cliente en el servicio de administracion de cuenteas para
 * un credito grupal.
 * <ul>
 * 	<li>Header de la peticion</li>
 * 	<li>Datos del Cleinte</li>
 * </ul>
 */
public final class ClientePeticion extends ObjetoValor {

	/**
	 * Instancia una nueva cliente peticion.
	 */
	public ClientePeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoPeticion 	header;

	/** The body. */
	private ClienteOV 		body;

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
	public final ClienteOV getBody() {
		return body;
	}

	/**
	 * Establece body.
	 *
	 * @param body the body to set
	 */
	public final void setBody(ClienteOV body) {
		this.body = body;
	}

}
