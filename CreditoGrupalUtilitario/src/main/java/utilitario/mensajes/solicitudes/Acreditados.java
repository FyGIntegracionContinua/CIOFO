package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class Acreditados.
 *
 * @author out_ltorres
 * @version 1.0
 */
public class Acreditados extends ObjetoValor {

	/**
	 * Instancia una nueva acreditados.
	 */
	public Acreditados() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5416177719556253545L;

	/** The customer id. */
	private String customerId;

	/** The first name. */
	private String firstName;

	/** The other name. */
	private String otherName;

	/** The second name. */
	private String secondName;

	/** The last name. */
	private String lastName;

	/** The gender. */
	private String gender;

	/** The birthdate. */
	private String birthdate;

	/** The rfc. */
	private String rfc;

	/** The persona. */
	private String persona;

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
	 * Obtiene first name.
	 *
	 * @return first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Establece first name.
	 *
	 * @param firstName a first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Obtiene other name.
	 *
	 * @return other name
	 */
	public String getOtherName() {
		return otherName;
	}

	/**
	 * Establece other name.
	 *
	 * @param otherName a other name
	 */
	public void setOtherName(String otherName) {
		this.otherName = otherName;
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
	 * Obtiene gender.
	 *
	 * @return gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Establece gender.
	 *
	 * @param gender a gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
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
	 * @return the persona
	 */
	public String getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(String persona) {
		this.persona = persona;
	}

}
