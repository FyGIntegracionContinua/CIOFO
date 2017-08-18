/**
 *
 */
package utilitario.mensajes.chequescreditogrupal;

/**
 * The Class FolioImp.
 *
 * @author out_ltorres
 */
public class FolioImp {

	/**
	 * Instancia una nueva folio imp.
	 */
	public FolioImp() { }
	/** The folio. */
	private Long folio;

	/** The cliente id. */
	private String clienteId;

	/** The status. */
	private Integer status;

	/** The cheque. */
	private Long cheque;

	/** The integrante. */
	private String integrante;

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
	 * Obtiene cliente id.
	 *
	 * @return cliente id
	 */
	public String getClienteId() {
		return clienteId;
	}

	/**
	 * Establece cliente id.
	 *
	 * @param clienteId a cliente id
	 */
	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	/**
	 * Obtiene status.
	 *
	 * @return status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * Establece status.
	 *
	 * @param status a status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * Obtiene cheque.
	 *
	 * @return cheque
	 */
	public Long getCheque() {
		return cheque;
	}

	/**
	 * Establece cheque.
	 *
	 * @param cheque a cheque
	 */
	public void setCheque(Long cheque) {
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
