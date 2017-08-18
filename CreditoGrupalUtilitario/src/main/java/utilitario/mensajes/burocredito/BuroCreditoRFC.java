package utilitario.mensajes.burocredito;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class BuroCreditoRFC.
 *
 * @author out_ltorres
 * @version 1.0
 */
public class BuroCreditoRFC extends ObjetoValor {

	/**
	 * Instancia una nueva buro credito rfc.
	 */
	public BuroCreditoRFC() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4903042643973729311L;

	/** The rfc. */
	private String  rfc;

	/** The persona. */
	private String persona;

	/** The customer id. */
	private String customerId;

	/** The customer name. */
	private String customerName;

	/** The second name. */
	private String secondName;

	/** The last name. */
	private String lastName;

	/** The birthdate. */
	private String birthdate;

	/**
	 * Obtiene rfc.
	 *
	 * @return rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * Establece rfc.
	 *
	 * @param rfc a rfc
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	/**
	 * Obtiene persona.
	 *
	 * @return persona
	 */
	public String getPersona() {
		return persona;
	}

	/**
	 * Establece persona.
	 *
	 * @param persona a persona
	 */
	public void setPersona(String persona) {
		this.persona = persona;
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
	 * Obtiene customer name.
	 *
	 * @return customer name
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * Establece customer name.
	 *
	 * @param customerName a customer name
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * Obtiene second name.
	 *
	 * @return second name
	 */
	public String getSecondName() {
		return secondName;
	}

	/**
	 * Establece second name.
	 *
	 * @param secondName a second name
	 */
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	/**
	 * Obtiene last name.
	 *
	 * @return last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Establece last name.
	 *
	 * @param lastName a last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Obtiene birthdate.
	 *
	 * @return birthdate
	 */
	public String getBirthdate() {
		return birthdate;
	}

	/**
	 * Establece birthdate.
	 *
	 * @param birthdate a birthdate
	 */
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

}


