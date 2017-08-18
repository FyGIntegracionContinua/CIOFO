/**
 * Tensegrity - Febrero 2011
 */
package utilitario.mensajes.originacion.consulta;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaPeticion.
 *
 * @author Juan Moreno
 * Encapsula los datos de la peticion de registrar un cliente en el servicio de administracion de cuenteas para
 * un credito grupal.
 * <ul>
 * 	<li>Header de la peticion</li>
 * 	<li>Datos del Cleinte</li>
 * </ul>
 */
public final class ConsultaPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva consulta peticion.
	 */
	public ConsultaPeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoPeticion 	header;

	/** The body. */
	private ConsultaFechaOV 	body;

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
	public final ConsultaFechaOV getBody() {
		return body;
	}

	/**
	 * Establece body.
	 *
	 * @param body the body to set
	 */
	public final void setBody(ConsultaFechaOV body) {
		this.body = body;
	}

}
