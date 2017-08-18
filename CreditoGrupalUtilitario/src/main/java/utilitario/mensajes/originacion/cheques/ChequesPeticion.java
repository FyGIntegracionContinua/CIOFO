/**
 * Tensegrity - Febrero 2011
 */
package utilitario.mensajes.originacion.cheques;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ChequesPeticion.
 *
 * @author Juan Moreno
 * Encapsula los datos de la peticion de registrar un cliente en el servicio de administracion de cuenteas para
 * un credito grupal.
 * <ul>
 * 	<li>Header de la peticion</li>
 * 	<li>Datos del Cleinte</li>
 * </ul>
 */
public final class ChequesPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva cheques peticion.
	 */
	public ChequesPeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The contrato. */
	private String 		contrato;


	/**
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}


	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

}
