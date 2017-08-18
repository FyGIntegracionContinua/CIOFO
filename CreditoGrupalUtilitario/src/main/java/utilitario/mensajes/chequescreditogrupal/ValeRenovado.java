/**
 *
 */
package utilitario.mensajes.chequescreditogrupal;

/**
 * The Class ValeRenovado.
 *
 * @author out_ltorres
 */
public class ValeRenovado {

	/**
	 * Instancia una nueva vale renovado.
	 */
	public ValeRenovado() {
	}
	 /** The customer id. */
 	private String customerId;

	 /** The amount. */
 	private Double amount;

	 /** The no vale credito. */
 	private String noValeCredito;

	/**
	 * Obtiene customer id.
	 *
	 * @return customer id
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * Establece customer id.
	 *
	 * @param customerId a customer id
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * Obtiene amount.
	 *
	 * @return amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * Establece amount.
	 *
	 * @param amount a amount
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * Obtiene no vale credito.
	 *
	 * @return no vale credito
	 */
	public String getNoValeCredito() {
		return noValeCredito;
	}

	/**
	 * Establece no vale credito.
	 *
	 * @param noValeCredito a no vale credito
	 */
	public void setNoValeCredito(String noValeCredito) {
		this.noValeCredito = noValeCredito;
	}



}
