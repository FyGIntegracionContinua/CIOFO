package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AcreditadosCredito.
 *
 * @author Luis Rodrigo Soto Solórzano
 * @version 1.0
 */
public class PersonasCredito extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1401151863910049836L;

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

	/** The ultimoContrato. */
	private String ultimoContrato;

	/** The ultimoLD. */
	private String ultimoLD;

	/** The nombreGrupo. */
	private String nombreGrupo;
	
	/** The monto. */
	private double monto;
	/** The nombreGerenteSucursal. */
	private String nombreGerenteSucursal;
	
	/** The numeroGerenteSucursal. */
	private String numeroGerenteSucursal;
	
	/** The nombreGerenteRegional. */
	private String nombreGerenteRegional;
	
	/** The numeroGerenteRegional. */
	private String numeroGerenteRegional;
	
	/** The nombreAsesorCredito. */
	private String nombreAsesorCredito;
	
	/** The numeroAsesor. */
	private String numeroAsesor;
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

	/**
	 * @return the ultimoContrato
	 */
	public String getUltimoContrato() {
		return ultimoContrato;
	}

	/**
	 * @param ultimoContrato the ultimoContrato to set
	 */
	public void setUltimoContrato(String ultimoContrato) {
		this.ultimoContrato = ultimoContrato;
	}

	/**
	 * @return the ultimoLD
	 */
	public String getUltimoLD() {
		return ultimoLD;
	}

	/**
	 * @param ultimoLD the ultimoLD to set
	 */
	public void setUltimoLD(String ultimoLD) {
		this.ultimoLD = ultimoLD;
	}

	/**
	 * @return the nombreGrupo
	 */
	public String getNombreGrupo() {
		return nombreGrupo;
	}

	/**
	 * @param nombreGrupo the nombreGrupo to set
	 */
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	/**
	 * @return the monto
	 */
	public double getMonto() {
		return monto;
	}

	/**
	 * @param monto the monto to set
	 */
	public void setMonto(double monto) {
		this.monto = monto;
	}

	/**
	 * @return the nombreGerenteSucursal
	 */
	public String getNombreGerenteSucursal() {
		return nombreGerenteSucursal;
	}

	/**
	 * @param nombreGerenteSucursal the nombreGerenteSucursal to set
	 */
	public void setNombreGerenteSucursal(String nombreGerenteSucursal) {
		this.nombreGerenteSucursal = nombreGerenteSucursal;
	}

	/**
	 * @return the numeroGerenteSucursal
	 */
	public String getNumeroGerenteSucursal() {
		return numeroGerenteSucursal;
	}

	/**
	 * @param numeroGerenteSucursal the numeroGerenteSucursal to set
	 */
	public void setNumeroGerenteSucursal(String numeroGerenteSucursal) {
		this.numeroGerenteSucursal = numeroGerenteSucursal;
	}

	/**
	 * @return the nombreGerenteRegional
	 */
	public String getNombreGerenteRegional() {
		return nombreGerenteRegional;
	}

	/**
	 * @param nombreGerenteRegional the nombreGerenteRegional to set
	 */
	public void setNombreGerenteRegional(String nombreGerenteRegional) {
		this.nombreGerenteRegional = nombreGerenteRegional;
	}

	/**
	 * @return the numeroGerenteRegional
	 */
	public String getNumeroGerenteRegional() {
		return numeroGerenteRegional;
	}

	/**
	 * @param numeroGerenteRegional the numeroGerenteRegional to set
	 */
	public void setNumeroGerenteRegional(String numeroGerenteRegional) {
		this.numeroGerenteRegional = numeroGerenteRegional;
	}

	/**
	 * @return the nombreAsesorCredito
	 */
	public String getNombreAsesorCredito() {
		return nombreAsesorCredito;
	}

	/**
	 * @param nombreAsesorCredito the nombreAsesorCredito to set
	 */
	public void setNombreAsesorCredito(String nombreAsesorCredito) {
		this.nombreAsesorCredito = nombreAsesorCredito;
	}

	/**
	 * @return the numeroAsesor
	 */
	public String getNumeroAsesor() {
		return numeroAsesor;
	}

	/**
	 * @param numeroAsesor the numeroAsesor to set
	 */
	public void setNumeroAsesor(String numeroAsesor) {
		this.numeroAsesor = numeroAsesor;
	}

}
