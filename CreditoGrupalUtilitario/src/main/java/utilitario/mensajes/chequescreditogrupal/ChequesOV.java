/**
 * ChequesOV
 */
package utilitario.mensajes.chequescreditogrupal;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author out_ltorres
 *
 */
public class ChequesOV extends ObjetoValor {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 4220874037362854243L;

	/**
	 * Numero de contrato.
	 */
	private String contractNo;

	/**
	 * Id.
	 */
	private String regularityId;

	/**
	 * Sucursal.
	 */
	private String branchName;

	/**
	 * Fecha de Desembolso.
	 */
	private String valueDate;

	/**
	 * Obtiene contractNo.
	 *
	 * @return the contractNo
	 */
	public String getContractNo() {
		return contractNo;
	}

	/**
	 * Establece contractNo.
	 *
	 * @param contractNo the contractNo to set
	 */
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	/**
	 * Obtiene regularityId.
	 *
	 * @return the regularityId
	 */
	public String getRegularityId() {
		return regularityId;
	}

	/**
	 * Establece regularityId.
	 *
	 * @param regularityId the regularityId to set
	 */
	public void setRegularityId(String regularityId) {
		this.regularityId = regularityId;
	}

	/**
	 * Obtiene branchName.
	 *
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}

	/**
	 * Establece branchName.
	 *
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName.trim();
	}

	/**
	 * Obtiene valueDate.
	 *
	 * @return the valueDate
	 */
	public String getValueDate() {
		return valueDate;
	}

	/**
	 * Establece valueDate.
	 *
	 * @param valueDate the valueDate to set
	 */
	public void setValueDate(String valueDate) {
		this.valueDate = valueDate;
	}

}
