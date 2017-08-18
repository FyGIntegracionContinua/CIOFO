/**
 * Tensegrity - Febrero 2011
 */
package utilitario.mensajes.originacion.grupo;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class GrupoPeticion.
 *
 * @author Juan Moreno
 * Encapsula los datos de la peticion de registrar un grupo en el servicio de administracion de cuentas para
 * un credito grupal.
 * <ul>
 * 	<li>Header de la peticion</li>
 * 	<li>Datos del Grupo</li>
 * </ul>
 */
public final class GrupoPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva grupo peticion.
	 */
	public GrupoPeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoPeticion 	header;

	/** The body. */
	private GrupoOV 		body;
	/**
	 * @return the header
	 */
	public final EncabezadoPeticion getHeader() {
		return header;
	}
	/**
	 * @param header the header to set
	 */
	public final void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}
	/**
	 * @return the body
	 */
	public final GrupoOV getBody( ) {
		return body;
	}
	/**
	 * @param body the body to set
	 */
	public final void setBody( GrupoOV body ) {
		this.body = body;
	}

}
