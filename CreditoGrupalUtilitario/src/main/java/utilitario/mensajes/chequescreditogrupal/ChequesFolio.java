/**
 *
 */
package utilitario.mensajes.chequescreditogrupal;

/**
 * The Class ChequesFolio.
 *
 * @author out_ltorres
 */
public class ChequesFolio {

	/**
	 * Instancia una nueva cheques folio.
	 */
	public ChequesFolio() {

	}

	/** The folio. */
	private String folio;

	/** The client id. */
	private String clientID;

	/** The cheque. */
	private String cheque;

	/** The integrante. */
	private String integrante;

	/**
	 * Obtiene folio.
	 *
	 * @return folio
	 */
	public String getFolio() {
		return folio;
	}

	/**
	 * Establece folio.
	 *
	 * @param folio a folio
	 */
	public void setFolio(String folio) {
		this.folio = folio;
	}

	/**
	 * Obtiene client id.
	 *
	 * @return client id
	 */
	public String getClientID() {
		return clientID;
	}

	/**
	 * Establece client id.
	 *
	 * @param clientID a client id
	 */
	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	/**
	 * Obtiene cheque.
	 *
	 * @return cheque
	 */
	public String getCheque() {
		return cheque;
	}

	/**
	 * Establece cheque.
	 *
	 * @param cheque a cheque
	 */
	public void setCheque(String cheque) {
		this.cheque = cheque;
	}

	/**
	 * Obtiene integrante.
	 *
	 * @return integrante
	 */
	public String getIntegrante() {
		return integrante;
	}

	/**
	 * Establece integrante.
	 *
	 * @param integrante a integrante
	 */
	public void setIntegrante(String integrante) {
		this.integrante = integrante;
	}

}
