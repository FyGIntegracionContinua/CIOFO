/**
 * Tensegrity - 2011
 */
package utilitario.mensajes.originacion.cliente;

import java.util.Date;

import utilitario.mensajes.comun.DomicilioOV;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ClienteOV.
 *
 * @author Juan Moreno
 * Encapsula los datos de in cliente Finsol..
 * <ul>
 * 	<li>Numero de persona</li>
 * 	<li>Nombre</li>
 * 	<li>Apellido paterno</li>
 * 	<li>Apellido materno</li>
 * 	<li>RFC</li>
 * 	<li>Fecha de nacimiento</li>
 * 	<li>Cedula CURP</li>
 * 	<li>Correo electronico</li>
 * 	<li>Numero de credencial IFE</li>
 * 	<li>Sexo</li>
 * 	<li>Estado civil</li>
 * 	<li>No. De dependientes</li>
 * 	<li>Ingresos mensuales</li>
 * 	<li>Egresos mensuales</li>
 * 	<li>Telefono Celular</li>
 * 	<li>Lada del telefono celular</li>
 * 	<li>Analista de operacion</li>
 * 	<li>DomicilioOV</li>
 * </ul>
 */
public final class ClienteOV extends ObjetoValor {

	/**
	 * Instancia una nueva cliente ov.
	 */
	public ClienteOV() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The persona. */
	private String persona; 						//Se calcula o se recibe ID

	/** The nombre. */
	private String nombre; 							//SHORT.NAME

	/** The paterno. */
	private String paterno;							//NAME.1

	/** The materno. */
	private String materno;							//SURNAME.2

	/** The rfc. */
	private String rfc;								//RFC

	/** The curp. */
	private java.lang.String curp;					//CURP

	/** The fecha nacimiento. */
	private Date  fechaNacimiento;					//BIRTH.INCORP.DATE

	/** The correo. */
	private String correo;							//MAILING.LIST

	/** The ife. */
	private String ife;								//LEGAL.ID

	/** The genero. */
	private String genero;							//GENDER

	/** The estado civil. */
	private String estadoCivil;					//MARITAL.STATUS

	/** The lada. */
	private String lada;							//TEL.HOME sustring(1,2)

	/** The telefono. */
	private String telefono;	//TEL.HOME sustring2,8) Si no son 10 solo se toma el telefono no lada

	/** The analista. */
	private String analista;						//ACCOUNT.OFFICER

	/** The cliente t24. */
	private String clienteT24;

	/** The domicilio. */
	private DomicilioOV	domicilio;

	/** The ofs_peticion. */
	private String ofs_peticion;					//Cadena OFS que se guarda para la respuesta;

	/** The actividad economica. */
	private	String actividadEconomica;

	/** The telefono celular. */
	private String telefonoCelular;

	/** The telefono empleo. */
	private String telefonoEmpleo;

	/**
	 * Obtiene persona.
	 *
	 * @return the persona
	 */
	public String getPersona() {
		return persona;
	}

	/**
	 * Establece persona.
	 *
	 * @param persona the persona to set
	 */
	public void setPersona(String persona) {
		this.persona = persona;
	}

	/**
	 * Obtiene nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece nombre.
	 *
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene paterno.
	 *
	 * @return the paterno
	 */
	public String getPaterno() {
		return paterno;
	}

	/**
	 * Establece paterno.
	 *
	 * @param paterno the paterno to set
	 */
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	/**
	 * Obtiene materno.
	 *
	 * @return the materno
	 */
	public String getMaterno() {
		return materno;
	}

	/**
	 * Establece materno.
	 *
	 * @param materno the materno to set
	 */
	public void setMaterno(String materno) {
		this.materno = materno;
	}

	/**
	 * Obtiene rfc.
	 *
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * Establece rfc.
	 *
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	/**
	 * Obtiene fecha nacimiento.
	 *
	 * @return the fecha_nacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Establece fecha nacimiento.
	 *
	 * @param fecha_nacimiento the fecha_nacimiento to set
	 */
	public void setFechaNacimiento(Date fecha_nacimiento) {
		this.fechaNacimiento = fecha_nacimiento;
	}

	/**
	 * Obtiene correo.
	 *
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * Establece correo.
	 *
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * Obtiene ife.
	 *
	 * @return the ife
	 */
	public String getIfe() {
		return ife;
	}

	/**
	 * Establece ife.
	 *
	 * @param ife the ife to set
	 */
	public void setIfe(String ife) {
		this.ife = ife;
	}

	/**
	 * Obtiene genero.
	 *
	 * @return the genero
	 */
	public String getGenero() {
		return genero;
	}

	/**
	 * Establece genero.
	 *
	 * @param genero the genero to set
	 */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/**
	 * Obtiene estado civil.
	 *
	 * @return the estado_civil
	 */
	public String getEstadoCivil() {
		return estadoCivil;
	}

	/**
	 * Establece estado civil.
	 *
	 * @param estado_civil the estado_civil to set
	 */
	public void setEstadoCivil(String estado_civil) {
		this.estadoCivil = estado_civil;
	}

	/**
	 * Obtiene lada.
	 *
	 * @return the lada
	 */
	public String getLada() {
		return lada;
	}

	/**
	 * Establece lada.
	 *
	 * @param lada the lada to set
	 */
	public void setLada(String lada) {
		this.lada = lada;
	}

	/**
	 * Obtiene telefono.
	 *
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * Establece telefono.
	 *
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Obtiene analista.
	 *
	 * @return the analista
	 */
	public String getAnalista() {
		return analista;
	}

	/**
	 * Establece analista.
	 *
	 * @param analista the analista to set
	 */
	public void setAnalista(String analista) {
		this.analista = analista;
	}

	/**
	 * Obtiene domicilio.
	 *
	 * @return the domicilio
	 */
	public DomicilioOV getDomicilio() {
		return domicilio;
	}

	/**
	 * Establece domicilio.
	 *
	 * @param domicilio the domicilio to set
	 */
	public void setDomicilio(DomicilioOV domicilio) {
		this.domicilio = domicilio;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	  public int hashCode() {
		Integer anyInt = 0;
	    return anyInt;
	  }

	/**
	 * Obtiene ofs_peticion.
	 *
	 * @return the ofs_peticion
	 */
	public String getOfs_peticion() {
		return ofs_peticion;
	}

	/**
	 * Establece ofs_peticion.
	 *
	 * @param ofs_peticion the ofs_peticion to set
	 */
	public void setOfs_peticion(String ofs_peticion) {
		this.ofs_peticion = ofs_peticion;
	}

	/**
	 * Establece actividad economica.
	 *
	 * @param actividadEconomica a actividad economica
	 */
	public void setActividadEconomica(String actividadEconomica) {
		this.actividadEconomica = actividadEconomica;
	}

	/**
	 * Obtiene actividad economica.
	 *
	 * @return actividad economica
	 */
	public String getActividadEconomica() {
		return actividadEconomica;
	}

	/**
	 * Establece cliente t24.
	 *
	 * @param clienteT24 a cliente t24
	 */
	public void setClienteT24(String clienteT24) {
		this.clienteT24 = clienteT24;
	}

	/**
	 * Obtiene cliente t24.
	 *
	 * @return cliente t24
	 */
	public String getClienteT24() {
		return clienteT24;
	}

	/**
	 * Obtiene curp.
	 *
	 * @return the curp
	 */
	public java.lang.String getCurp() {
		return curp;
	}

	/**
	 * Establece curp.
	 *
	 * @param curp the curp to set
	 */
	public void setCurp(java.lang.String curp) {
		this.curp = curp;
	}

	/**
	 * Obtiene telefono celular.
	 *
	 * @return telefono celular
	 */
	public String getTelefonoCelular() {
		return telefonoCelular;
	}

	/**
	 * Establece telefono celular.
	 *
	 * @param telefonoCelular a telefono celular
	 */
	public void setTelefonoCelular(String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	/**
	 * Obtiene telefono empleo.
	 *
	 * @return telefono empleo
	 */
	public String getTelefonoEmpleo() {
		return telefonoEmpleo;
	}

	/**
	 * Establece telefono empleo.
	 *
	 * @param telefonoEmpleo a telefono empleo
	 */
	public void setTelefonoEmpleo(String telefonoEmpleo) {
		this.telefonoEmpleo = telefonoEmpleo;
	}

}
