package utilitario.mensajes.chequescreditogrupal;


/**
 * The Class ChequesCliente.
 *
 * @author out_ltorres
 */
public class ChequesCliente {

	/**
	 * Instancia una nueva cheques cliente.
	 */
	public ChequesCliente() {

	}

	/** The folio. */
	private Long folio;

	/** The client id. */
	private String clientId;

	/** The contrato ld. */
	private String contratoLD;

	/**
	 * Obtiene folio.
	 *
	 * @return folio
	 */
	public Long getFolio() {
		return folio;
	}

	/**
	 * Establece folio.
	 *
	 * @param folio a folio
	 */
	public void setFolio(Long folio) {
		this.folio = folio;
	}

	/**
	 * Obtiene client id.
	 *
	 * @return client id
	 */
	public String getClientId() {
		return clientId;
	}

	/**
	 * Establece client id.
	 *
	 * @param clientId a client id
	 */
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	/**
	 * Obtiene contrato ld.
	 *
	 * @return contrato ld
	 */
	public String getContratoLD() {
		return contratoLD;
	}

	/**
	 * Establece contrato ld.
	 *
	 * @param contratoLD a contrato ld
	 */
	public void setContratoLD(String contratoLD) {
		this.contratoLD = contratoLD;
	}

}
