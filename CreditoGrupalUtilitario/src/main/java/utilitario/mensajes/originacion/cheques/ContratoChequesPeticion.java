/**
 * Tensegrity - 2011
 */
package utilitario.mensajes.originacion.cheques;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ContratoChequesPeticion.
 *
 * @author Juan Moreno
 * Encapsula los datos de la respuesta de la operacion RegistrarCliente...
 * <ul>
 *  <li>Header con el resultado de la operacion</li>
 *  <li>Bod con el resultados solicitado de la respuesta</li>
 * </ul>
 */
public final class ContratoChequesPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva contrato cheques peticion.
	 */
	public ContratoChequesPeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoRespuesta 	header;

	/** The body. */
	private ChequesPeticion body;


	/**
	 * Obtiene body.
	 *
	 * @return the body
	 */
	public ChequesPeticion getBody() {
		return body;
	}

	/**
	 * Establece body.
	 *
	 * @param body the body to set
	 */
	public void setBody(ChequesPeticion body) {
		this.body = body;
	}

	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public final EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public final void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

}
