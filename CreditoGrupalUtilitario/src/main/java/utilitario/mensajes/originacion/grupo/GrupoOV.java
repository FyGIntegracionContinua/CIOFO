/**
 * Tensegrity - 2011
 */
package utilitario.mensajes.originacion.grupo;

import java.util.Date;

import utilitario.mensajes.comun.DomicilioOV;
import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class GrupoOV.
 *
 * @author Juan Moreno
 * Encapsulalos
 * <ul>
 * 	<li>Identificador</li>
 * 	<li>Nombre del Grupo</li>
 * 	<li>Sucursal</li>
 * 	<li>Analista de operacion</li>
 * 	<li>Domicilio de las reuniones</li>
 * </ul>
 */
public final class GrupoOV extends ObjetoValor {

	/**
	 * Instancia una nueva grupo ov.
	 */
	public GrupoOV() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The identificador. */
	private String identificador;					//Si no exite se da de alta...  ID //CUSTOMER.ID

	 /** The nombre. */
	 private String nombre;							//SHORT.NAME

	/** The analista. */
	private String analista;						//ACCOUNT.OFFICER

	/** The fecha_conformacion. */
	private Date   fecha_conformacion;				//OPENING.DATE

	/** The domicilio. */
	private DomicilioOV domicilio;

	/** The presidente. */
	private String presidente;						//PRESIDENT

	/** The tesorero. */
	private String tesorero;						//TREASURER

	/** The secretario. */
	private String secretario;						//SECRATORY

	/** The supervisor. */
	private String supervisor;						//SUPERVISOR

	/** The sucursal. */
	private Integer sucursal;						//Numero de la sucursal

	/** The cliente t24. */
	private String clienteT24;

	/** The localidad. */
	private	String localidad;

	/** The peticion_ofs. */
	private String peticion_ofs;

	/** The ciclo. */
	private int ciclo;

	/**camapana*/
	private String campana;

	/**contratoPrevio*/
	private String contratoAnterior;

	/**Total integrantes de la competencia*/
	private int totalIntegrantesComp;

	/**
	 * Obtiene peticion_ofs.
	 *
	 * @return the peticion_ofs
	 */
	public String getPeticion_ofs() {
		return peticion_ofs;
	}

	/**
	 * Establece peticion_ofs.
	 *
	 * @param peticion_ofs the peticion_ofs to set
	 */
	public void setPeticion_ofs(String peticion_ofs) {
		this.peticion_ofs = peticion_ofs;
	}

	/**
	 * Obtiene ciclo.
	 *
	 * @return the ciclo
	 */
	public int getCiclo() {
		return ciclo;
	}

	/**
	 * Establece ciclo.
	 *
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * Obtiene identificador.
	 *
	 * @return the identificador
	 */
	public String getIdentificador() {
		return identificador;
	}

	/**
	 * Establece identificador.
	 *
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
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
	 * Obtiene fecha_conformacion.
	 *
	 * @return the fecha_conformacion
	 */
	public Date getFecha_conformacion() {
		return fecha_conformacion;
	}

	/**
	 * Establece fecha_conformacion.
	 *
	 * @param fecha_conformacion the fecha_conformacion to set
	 */
	public void setFecha_conformacion(Date fecha_conformacion) {
		this.fecha_conformacion = fecha_conformacion;
	}


	/**
	 * Obtiene presidente.
	 *
	 * @return the presidente
	 */
	public String getPresidente() {
		return presidente;
	}

	/**
	 * Establece presidente.
	 *
	 * @param presidente the presidente to set
	 */
	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	/**
	 * Obtiene tesorero.
	 *
	 * @return the tesorero
	 */
	public String getTesorero() {
		return tesorero;
	}

	/**
	 * Establece tesorero.
	 *
	 * @param tesorero the tesorero to set
	 */
	public void setTesorero(String tesorero) {
		this.tesorero = tesorero;
	}

	/**
	 * Obtiene secretario.
	 *
	 * @return the secretario
	 */
	public String getSecretario() {
		return secretario;
	}

	/**
	 * Establece secretario.
	 *
	 * @param secretario the secretario to set
	 */
	public void setSecretario(String secretario) {
		this.secretario = secretario;
	}

	/**
	 * Obtiene supervisor.
	 *
	 * @return the supervisor
	 */
	public String getSupervisor() {
		return supervisor;
	}

	/**
	 * Establece supervisor.
	 *
	 * @param supervisor the supervisor to set
	 */
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
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

	/**
	 * Obtiene sucursal.
	 *
	 * @return sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal a sucursal
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Establece localidad.
	 *
	 * @param localidad a localidad
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	/**
	 * Obtiene localidad.
	 *
	 * @return localidad
	 */
	public String getLocalidad() {
		return localidad;
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
	 * @return the campana
	 */
	public String getCampana() {
		return campana;
	}

	/**
	 * @param campana the campana to set
	 */
	public void setCampana(String campana) {
		this.campana = campana;
	}

	/**
	 * @return the contratoAnterior
	 */
	public String getContratoAnterior() {
		return contratoAnterior;
	}

	/**
	 * @param contratoAnterior the contratoAnterior to set
	 */
	public void setContratoAnterior(String contratoAnterior) {
		this.contratoAnterior = contratoAnterior;
	}

	/**
	 * @return the totalIntegrantesComp
	 */
	public int getTotalIntegrantesComp() {
		return totalIntegrantesComp;
	}

	/**
	 * @param totalIntegrantesComp the totalIntegrantesComp to set
	 */
	public void setTotalIntegrantesComp(int totalIntegrantesComp) {
		this.totalIntegrantesComp = totalIntegrantesComp;
	}

}
