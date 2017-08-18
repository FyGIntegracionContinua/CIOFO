/**
 * Repuesta contrato Finsol
 */
package utilitario.mensajes.impresiondocs.comun;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author hsamano
 *
 */
public class ContratoFinsolRespuesta extends ObjetoValor{
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 7327044963247888105L;
	/**
	 * Encabezado de la respuesta
	 */
	private EncabezadoRespuesta header;
	/**
	 * Objeto contrato
	 */
	private ContratoFinsolOV contrato;
	/**
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}
	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}
	/**
	 * @return the contrato
	 */
	public ContratoFinsolOV getContrato() {
		return contrato;
	}
	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(ContratoFinsolOV contrato) {
		this.contrato = contrato;
	}
}
