/**
 * Tensegrity - Febrero 2011
 */
package utilitario.mensajes.originacion.cliente;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ActualizarChequeClientePeticion.
 *
 * @author Juan Moreno
 * Encapsula los datos de la peticion de registrar un cliente en el servicio de administracion de cuenteas para
 * un credito grupal.
 * <ul>
 * 	<li>Header de la peticion</li>
 * 	<li>Datos del Cleinte</li>
 * </ul>
 */
public final class ActualizarChequeClientePeticion extends ObjetoValor {

	/**
	 * Instancia una nueva actualizar cheque cliente peticion.
	 */
	public ActualizarChequeClientePeticion() { }

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoPeticion 	header;

	/** The contrato. */
	private java.lang.String	contrato;

	/** The integrante. */
	private java.lang.String	integrante;

	/** The cheque. */
	private java.lang.Integer	cheque;

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
	 * Obtiene contrato.
	 *
	 * @return the contrato
	 */
	public java.lang.String getContrato() {
		return contrato;
	}

	/**
	 * Establece contrato.
	 *
	 * @param contrato the contrato to set
	 */
	public void setContrato(java.lang.String contrato) {
		this.contrato = contrato;
	}

	/**
	 * Obtiene integrante.
	 *
	 * @return the integrante
	 */
	public java.lang.String getIntegrante() {
		return integrante;
	}

	/**
	 * Establece integrante.
	 *
	 * @param integrante the integrante to set
	 */
	public void setIntegrante(java.lang.String integrante) {
		this.integrante = integrante;
	}

	/**
	 * Obtiene cheque.
	 *
	 * @return the cheque
	 */
	public java.lang.Integer getCheque() {
		return cheque;
	}

	/**
	 * Establece cheque.
	 *
	 * @param cheque the cheque to set
	 */
	public void setCheque(java.lang.Integer cheque) {
		this.cheque = cheque;
	}
}
