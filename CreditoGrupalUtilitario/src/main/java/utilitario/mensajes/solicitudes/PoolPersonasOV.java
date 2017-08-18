package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class PoolPersonasOV.
 *
 * @author rguadarramac
 * @version 1.0
 */
public class PoolPersonasOV extends ObjetoValor {

	/**
	 * Instancia una nueva pool personas ov.
	 */
	public PoolPersonasOV() {
	}

	/** Se genero serial. */
	private static final long serialVersionUID = -9159036514039132884L;

	/** The persona. */
	private String persona;

	/** The nombre. */
	private String nombre;

	/** The tipo perfil. */
	private String tipoPerfil;

	/** The perfil descripcion. */
	private String perfilDescripcion;

	/** The estatus codigo. */
	private String estatusCodigo;

	/** The codigo descripcion. */
	private String codigoDescripcion;

	/** The ponderacion. */
	private Double ponderacion;

	/** The pool perfil. */
	private String poolPerfil;

	/** The ponderacionDia. */
	private Double ponderacionDia;

	/** The ponderacionDia. */
	private Double ponderacionDiaSiguiente;

	/** The tipoAnalista. */
	private String tipoAnalista;

	/** The gruposDia. */
	private int gruposDia;

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
	 * Obtiene tipo perfil.
	 *
	 * @return tipo perfil
	 */
	public String getTipoPerfil() {
		return tipoPerfil;
	}

	/**
	 * Establece tipo perfil.
	 *
	 * @param tipoPerfil a tipo perfil
	 */
	public void setTipoPerfil(String tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

	/**
	 * Obtiene perfil descripcion.
	 *
	 * @return perfil descripcion
	 */
	public String getPerfilDescripcion() {
		return perfilDescripcion;
	}

	/**
	 * Establece perfil descripcion.
	 *
	 * @param perfilDescripcion a perfil descripcion
	 */
	public void setPerfilDescripcion(String perfilDescripcion) {
		this.perfilDescripcion = perfilDescripcion;
	}

	/**
	 * Obtiene estatus codigo.
	 *
	 * @return estatus codigo
	 */
	public String getEstatusCodigo() {
		return estatusCodigo;
	}

	/**
	 * Establece estatus codigo.
	 *
	 * @param estatusCodigo a estatus codigo
	 */
	public void setEstatusCodigo(String estatusCodigo) {
		this.estatusCodigo = estatusCodigo;
	}

	/**
	 * Obtiene codigo descripcion.
	 *
	 * @return codigo descripcion
	 */
	public String getCodigoDescripcion() {
		return codigoDescripcion;
	}

	/**
	 * Establece codigo descripcion.
	 *
	 * @param codigoDescripcion a codigo descripcion
	 */
	public void setCodigoDescripcion(String codigoDescripcion) {
		this.codigoDescripcion = codigoDescripcion;
	}

	/**
	 * Obtiene ponderacion.
	 *
	 * @return ponderacion
	 */
	public Double getPonderacion() {
		return ponderacion;
	}

	/**
	 * Establece ponderacion.
	 *
	 * @param ponderacion a ponderacion
	 */
	public void setPonderacion(Double ponderacion) {
		this.ponderacion = ponderacion;
	}

	/**
	 * Establece pool perfil.
	 *
	 * @param poolPerfil a pool perfil
	 */
	public void setPoolPerfil(String poolPerfil) {
		this.poolPerfil = poolPerfil;
	}

	/**
	 * Obtiene pool perfil.
	 *
	 * @return pool perfil
	 */
	public String getPoolPerfil() {
		return poolPerfil;
	}

	/**
	 * @return the ponderacionDia
	 */
	public Double getPonderacionDia() {
		return ponderacionDia;
	}

	/**
	 * @param ponderacionDia the ponderacionDia to set
	 */
	public void setPonderacionDia(Double ponderacionDia) {
		this.ponderacionDia = ponderacionDia;
	}

	/**
	 * @return the ponderacionDiaSiguiente
	 */
	public Double getPonderacionDiaSiguiente() {
		return ponderacionDiaSiguiente;
	}

	/**
	 * @param ponderacionDiaSiguiente the ponderacionDiaSiguiente to set
	 */
	public void setPonderacionDiaSiguiente(Double ponderacionDiaSiguiente) {
		this.ponderacionDiaSiguiente = ponderacionDiaSiguiente;
	}

	/**
	 * @return the tipoAnalista
	 */
	public String getTipoAnalista() {
		return tipoAnalista;
	}

	/**
	 * @param tipoAnalista the tipoAnalista to set
	 */
	public void setTipoAnalista(String tipoAnalista) {
		this.tipoAnalista = tipoAnalista;
	}

	/**
	 * @return the gruposDia
	 */
	public int getGruposDia() {
		return gruposDia;
	}

	/**
	 * @param gruposDia the gruposDia to set
	 */
	public void setGruposDia(int gruposDia) {
		this.gruposDia = gruposDia;
	}

}
