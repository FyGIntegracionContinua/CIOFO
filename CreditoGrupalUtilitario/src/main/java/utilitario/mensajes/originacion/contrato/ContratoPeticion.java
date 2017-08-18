/**
 * Tensegrity - Febrero 2011
 */
package utilitario.mensajes.originacion.contrato;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;


/**
 * @author Juan Moreno
 * Encapsula los datos de la peticion de registrar un contrato en el servicio de administracion de cuentas para
 * un credito grupal.
 * <ul>
 * 	<li>Header de la peticion</li>
 * 	<li>Datos del contrato o credito</li>
 * </ul>
 */
public final class ContratoPeticion extends ObjetoValor {

	/**
	 * ContratoPeticion
	 */
	public ContratoPeticion() {

	}
	/**
	 * long serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * EncabezadoPeticion header
	 */
	private EncabezadoPeticion 	header;
	/**
	 * ContratoOV body
	 */
	private ContratoOV 		body;
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
	public final ContratoOV getBody( ) {
		return body;
	}
	/**
	 * @param body the body to set
	 */
	public final void setBody( ContratoOV body ) {
		this.body = body;
	}


}
