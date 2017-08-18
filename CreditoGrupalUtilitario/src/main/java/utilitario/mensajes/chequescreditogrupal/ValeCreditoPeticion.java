/**
 *
 */
package utilitario.mensajes.chequescreditogrupal;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ValeCreditoPeticion.
 *
 * @author out_ltorres
 */
public class ValeCreditoPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva vale credito peticion.
	 */
	public ValeCreditoPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2322654038292632720L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The ld consul. */
	private String ldConsul;

	/** The customer id. */
	private String customerId;

	/** The amount. */
	private Double amount;

	/** The no vale. */
	private String noVale;

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}

	/**
	 * Obtiene ld consul.
	 *
	 * @return ld consul
	 */
	public String getLdConsul() {
		return ldConsul;
	}

	/**
	 * Establece ld consul.
	 *
	 * @param ldConsul a ld consul
	 */
	public void setLdConsul(String ldConsul) {
		this.ldConsul = ldConsul;
	}

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
	 * Obtiene no vale.
	 *
	 * @return no vale
	 */
	public String getNoVale() {
		return noVale;
	}

	/**
	 * Establece no vale.
	 *
	 * @param noVale a no vale
	 */
	public void setNoVale(String noVale) {
		this.noVale = noVale;
	}

}
