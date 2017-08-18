package utilitario.mensajes.solicitudes;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class SolicitudSACGGrupo.
 *
 * @author out_ltorres
 * @version 1.0
 */
public class SolicitudSACGGrupo extends ObjetoValor {

	/**
	 * Instancia una nueva solicitud sacg grupo.
	 */
	public SolicitudSACGGrupo() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4541108256460762774L;

	/** The id credito. */
	private String idCredito;

	/** The codigo. */
	private String codigo;

	/** The nombre. */
	private String nombre;

	/** The analista. */
	private String analista;

	/** The presidente. */
	private String presidente;

	/** The secretario. */
	private String secretario;

	/** The supervisor. */
	private String supervisor;

	/** The tesorero. */
	private String tesorero;

	/** The fecha conformacion. */
	private Date fechaConformacion;

	/** The estatus pocg. */
	private Integer estatusPocg;

	/** The presidentePersona. */
	private String presidentePersona;
	/** The tesoreroPersona. */
	private String tesoreroPersona;
	/** The secretarioPersona. */
	private String secretarioPersona;
	/** The supervisorPersona. */
	private String supervisorPersona;

	/** correo del Gerente Regional, disional o de riesgo*/
	private String correo;
	/**numero de integrantes*/
	private int numeroIntegrantes;

	/**
	 * Obtiene id credito.
	 *
	 * @return id credito
	 */
	public String getIdCredito() {
		return idCredito;
	}

	/**
	 * Establece id credito.
	 *
	 * @param idCredito a id credito
	 */
	public void setIdCredito(String idCredito) {
		this.idCredito = idCredito;
	}

	/**
	 * Obtiene codigo.
	 *
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Establece codigo.
	 *
	 * @param codigo a codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtiene nombre.
	 *
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece nombre.
	 *
	 * @param nombre a nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene analista.
	 *
	 * @return analista
	 */
	public String getAnalista() {
		return analista;
	}

	/**
	 * Establece analista.
	 *
	 * @param analista a analista
	 */
	public void setAnalista(String analista) {
		this.analista = analista.trim();
	}

	/**
	 * Obtiene presidente.
	 *
	 * @return presidente
	 */
	public String getPresidente() {
		return presidente;
	}

	/**
	 * Establece presidente.
	 *
	 * @param presidente a presidente
	 */
	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	/**
	 * Obtiene secretario.
	 *
	 * @return secretario
	 */
	public String getSecretario() {
		return secretario;
	}

	/**
	 * Establece secretario.
	 *
	 * @param secretario a secretario
	 */
	public void setSecretario(String secretario) {
		this.secretario = secretario;
	}

	/**
	 * Obtiene supervisor.
	 *
	 * @return supervisor
	 */
	public String getSupervisor() {
		return supervisor;
	}

	/**
	 * Establece supervisor.
	 *
	 * @param supervisor a supervisor
	 */
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	/**
	 * Obtiene tesorero.
	 *
	 * @return tesorero
	 */
	public String getTesorero() {
		return tesorero;
	}

	/**
	 * Establece tesorero.
	 *
	 * @param tesorero a tesorero
	 */
	public void setTesorero(String tesorero) {
		this.tesorero = tesorero;
	}

	/**
	 * Obtiene fecha conformacion.
	 *
	 * @return fecha conformacion
	 */
	public Date getFechaConformacion() {
		return fechaConformacion;
	}

	/**
	 * Establece fecha conformacion.
	 *
	 * @param fechaConformacion a fecha conformacion
	 */
	public void setFechaConformacion(Date fechaConformacion) {
		this.fechaConformacion = fechaConformacion;
	}

	/**
	 * Obtiene estatus pocg.
	 *
	 * @return estatus pocg
	 */
	public Integer getEstatusPocg() {
		return estatusPocg;
	}

	/**
	 * Establece estatus pocg.
	 *
	 * @param estatusPocg a estatus pocg
	 */
	public void setEstatusPocg(Integer estatusPocg) {
		this.estatusPocg = estatusPocg;
	}

	/**
	 * @return the presidentePersona
	 */
	public String getPresidentePersona() {
		return presidentePersona;
	}

	/**
	 * @param presidentePersona the presidentePersona to set
	 */
	public void setPresidentePersona(String presidentePersona) {
		this.presidentePersona = presidentePersona;
	}

	/**
	 * @return the tesoreroPersona
	 */
	public String getTesoreroPersona() {
		return tesoreroPersona;
	}

	/**
	 * @param tesoreroPersona the tesoreroPersona to set
	 */
	public void setTesoreroPersona(String tesoreroPersona) {
		this.tesoreroPersona = tesoreroPersona;
	}

	/**
	 * @return the secretarioPersona
	 */
	public String getSecretarioPersona() {
		return secretarioPersona;
	}

	/**
	 * @param secretarioPersona the secretarioPersona to set
	 */
	public void setSecretarioPersona(String secretarioPersona) {
		this.secretarioPersona = secretarioPersona;
	}

	/**
	 * @return the supervisorPersona
	 */
	public String getSupervisorPersona() {
		return supervisorPersona;
	}

	/**
	 * @param supervisorPersona the supervisorPersona to set
	 */
	public void setSupervisorPersona(String supervisorPersona) {
		this.supervisorPersona = supervisorPersona;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the numeroIntegrantes
	 */
	public int getNumeroIntegrantes() {
		return numeroIntegrantes;
	}

	/**
	 * @param numeroIntegrantes the numeroIntegrantes to set
	 */
	public void setNumeroIntegrantes(int numeroIntegrantes) {
		this.numeroIntegrantes = numeroIntegrantes;
	}

}
