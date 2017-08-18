/**
 * Tensegrity - Febrero 2011
 */
package utilitario.mensajes.originacion.desembolso;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class DesembolsoPeticion.
 *
 * @author Juan Moreno
 * Encapsula los datos de la peticion de registrar un grupo en el servicio de administracion de cuentas para
 * un credito grupal.
 * <ul>
 * 	<li>Header de la peticion</li>
 * 	<li>Datos del Grupo</li>
 * </ul>
 */
public final class DesembolsoPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva desembolso peticion.
	 */
	public DesembolsoPeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoPeticion 	header;

	/** The body. */
	private DesembolsoOV 		body;

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
	public final DesembolsoOV getBody( ) {
		return body;
	}

	/**
	 * Establece body.
	 *
	 * @param body the body to set
	 */
	public final void setBody( DesembolsoOV body ) {
		this.body = body;
	}

}
