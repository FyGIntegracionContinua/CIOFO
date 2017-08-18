/**
 * Tensegrity - Febrero 2011
 */
package utilitario.mensajes.originacion.cancelacion;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class CancelacionContratoPeticion.
 *
 * @author Juan Moreno
 * Encapsula los datos de la peticion de registrar un contrato en el servicio de administracion de cuentas para
 * un credito grupal.
 * <ul>
 * 	<li>Header de la peticion</li>
 * 	<li>Datos del contrato o credito</li>
 * </ul>
 */
public final class CancelacionContratoPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva cancelacion contrato peticion.
	 */
	public CancelacionContratoPeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4805675612030611082L;

	/** The header. */
	private EncabezadoPeticion 	header;

	/** The body. */
	private CancelacionContratoOV 		body;

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
	public final CancelacionContratoOV getBody( ) {
		return body;
	}

	/**
	 * Establece body.
	 *
	 * @param body the body to set
	 */
	public final void setBody( CancelacionContratoOV body ) {
		this.body = body;
	}

}
