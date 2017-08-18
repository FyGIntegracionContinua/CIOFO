package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ExcepcionGarantiaPeticion.
 *
 * @author out_gcorzo
 * @version 1.0
 */
public class ExcepcionGarantiaPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva excepcion garantia peticion
	 */
	public ExcepcionGarantiaPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -810147433747092963L;

	//buzon tarea

	/** The id tarea. */
	private Integer idTarea;

	/** The tipoTarea. */
	private String tipoTarea;

	/** The sucursal. */
	private String sucursal;

	/** The descripcion. */
	private String descripcion;

	/** The fechaAlta. */
	private String fechaAlta;

	/** The usuarioAlta. */
	private String usuarioAlta;

	/** The fechaAsignacion. */
	private String fechaAsignacion;

	/** The fechaUltMod. */
	private String fechaUltMod;

	/** The usuarioPropietario. */
	private String usuarioPropietario;

	/** The fechaTermino. */
	private String fechaTermino;

	/** The perfil. */
	private String perfil;

	/** The status. */
	private String status;

	/** The idTareaPadre. */
	private Integer idTareaPadre;

	/** The idDivision. */
	private Integer idDivision;

	// tareas_excepcion_garantia

	/** The justificacion. */
	private String justificacion;

	/** The estatusAut. */
	private String estatusAut;

	/** The usuarioAut. */
	private String usuarioAut;

	/** The fechaAut. */
	private String fechaAut;

	/** The observaciones. */
	private String observaciones;

	/** The solicitud. */
	private String solicitud;

	/** The complemento. */
	private String complemento;

	/** The express. */
	private String express;

	/** The clavePuesto. */
	private String clavePuesto;

	/** The idRegion. */
	private int idRegion;

	/** tipo de excepcion que se esta originando*/
	private String tipoException;

	/**cico de la solicitud*/
	private int ciclo;

	/**campana de la solicitud*/
	private String campana;

	/**nombre del asesor*/
	private String nombreAsesor;

	/**nombre del grupo*/
	private String nombreGrupo;

	/**numeroIntegrantes*/
	private int numeroIntegrantes;

	/** monto solicitado por el grupo*/
	private double montoSolicitado;

	/**correo del regional, divisional o riesgo*/
	private String correo;

	/**nombre de la sucursal*/
	private String nombreSucursal;

	/**tipificacion de la sucursal*/
	private String tipificacionSucursal;

	/**The motivoCEC. */
	private String motivoCEC;

	/**
	 * @return the complemento
	 */
	public String getComplemento() {
		return complemento;
	}

	/**
	 * @param complemento the complemento to set
	 */
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	/**
	 * @return the idDivision
	 */
	public Integer getIdDivision() {
		return idDivision;
	}

	/**
	 * @param idDivision the idDivision to set
	 */
	public void setIdDivision(Integer idDivision) {
		this.idDivision = idDivision;
	}

	/**
	 * @return the solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}

	/**
	 * @param solicitud the solicitud to set
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	/**
	 * @return the idTarea
	 */
	public Integer getIdTarea() {
		return idTarea;
	}

	/**
	 * @param idTarea the idTarea to set
	 */
	public void setIdTarea(Integer idTarea) {
		this.idTarea = idTarea;
	}

	/**
	 * @return the tipoTarea
	 */
	public String getTipoTarea() {
		return tipoTarea;
	}

	/**
	 * @param tipoTarea the tipoTarea to set
	 */
	public void setTipoTarea(String tipoTarea) {
		this.tipoTarea = tipoTarea;
	}

	/**
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the fechaAlta
	 */
	public String getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * @return the usuarioAlta
	 */
	public String getUsuarioAlta() {
		return usuarioAlta;
	}

	/**
	 * @param usuarioAlta the usuarioAlta to set
	 */
	public void setUsuarioAlta(String usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}

	/**
	 * @return the fechaAsignacion
	 */
	public String getFechaAsignacion() {
		return fechaAsignacion;
	}

	/**
	 * @param fechaAsignacion the fechaAsignacion to set
	 */
	public void setFechaAsignacion(String fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	/**
	 * @return the fechaUltMod
	 */
	public String getFechaUltMod() {
		return fechaUltMod;
	}

	/**
	 * @param fechaUltMod the fechaUltMod to set
	 */
	public void setFechaUltMod(String fechaUltMod) {
		this.fechaUltMod = fechaUltMod;
	}

	/**
	 * @return the usuarioPropietario
	 */
	public String getUsuarioPropietario() {
		return usuarioPropietario;
	}

	/**
	 * @param usuarioPropietario the usuarioPropietario to set
	 */
	public void setUsuarioPropietario(String usuarioPropietario) {
		this.usuarioPropietario = usuarioPropietario;
	}

	/**
	 * @return the fechaTermino
	 */
	public String getFechaTermino() {
		return fechaTermino;
	}

	/**
	 * @param fechaTermino the fechaTermino to set
	 */
	public void setFechaTermino(String fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	/**
	 * @return the perfil
	 */
	public String getPerfil() {
		return perfil;
	}

	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the idTareaPadre
	 */
	public Integer getIdTareaPadre() {
		return idTareaPadre;
	}

	/**
	 * @param idTareaPadre the idTareaPadre to set
	 */
	public void setIdTareaPadre(Integer idTareaPadre) {
		this.idTareaPadre = idTareaPadre;
	}

	/**
	 * @return the justificacion
	 */
	public String getJustificacion() {
		return justificacion;
	}

	/**
	 * @param justificacion the justificacion to set
	 */
	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}

	/**
	 * @return the estatusAut
	 */
	public String getEstatusAut() {
		return estatusAut;
	}

	/**
	 * @param estatusAut the estatusAut to set
	 */
	public void setEstatusAut(String estatusAut) {
		this.estatusAut = estatusAut;
	}

	/**
	 * @return the usuarioAut
	 */
	public String getUsuarioAut() {
		return usuarioAut;
	}

	/**
	 * @param usuarioAut the usuarioAut to set
	 */
	public void setUsuarioAut(String usuarioAut) {
		this.usuarioAut = usuarioAut;
	}

	/**
	 * @return the fechaAut
	 */
	public String getFechaAut() {
		return fechaAut;
	}

	/**
	 * @param fechaAut the fechaAut to set
	 */
	public void setFechaAut(String fechaAut) {
		this.fechaAut = fechaAut;
	}

	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 * @return the express
	 */
	public String getExpress() {
		return express;
	}

	/**
	 * @param express the express to set
	 */
	public void setExpress(String express) {
		this.express = express;
	}

	/**
	 * @return the clavePuesto
	 */
	public String getClavePuesto() {
		return clavePuesto;
	}

	/**
	 * @param clavePuesto the clavePuesto to set
	 */
	public void setClavePuesto(String clavePuesto) {
		this.clavePuesto = clavePuesto;
	}

	/**
	 * @return the idRegion
	 */
	public int getIdRegion() {
		return idRegion;
	}

	/**
	 * @param idRegion the idRegion to set
	 */
	public void setIdRegion(int idRegion) {
		this.idRegion = idRegion;
	}

	/**
	 * @return the tipoException
	 */
	public String getTipoException() {
		return tipoException;
	}

	/**
	 * @param tipoException the tipoException to set
	 */
	public void setTipoException(String tipoException) {
		this.tipoException = tipoException;
	}

	/**
	 * @return the ciclo
	 */
	public int getCiclo() {
		return ciclo;
	}

	/**
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
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
	 * @return the nombreAsesor
	 */
	public String getNombreAsesor() {
		return nombreAsesor;
	}

	/**
	 * @param nombreAsesor the nombreAsesor to set
	 */
	public void setNombreAsesor(String nombreAsesor) {
		this.nombreAsesor = nombreAsesor;
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

	/**
	 * @return the montoSolicitado
	 */
	public double getMontoSolicitado() {
		return montoSolicitado;
	}

	/**
	 * @param montoSolicitado the montoSolicitado to set
	 */
	public void setMontoSolicitado(double montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
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
	 * @return the nombreSucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}

	/**
	 * @param nombreSucursal the nombreSucursal to set
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	/**
	 * @return the tipificacionSucursal
	 */
	public String getTipificacionSucursal() {
		return tipificacionSucursal;
	}

	/**
	 * @param tipificacionSucursal the tipificacionSucursal to set
	 */
	public void setTipificacionSucursal(String tipificacionSucursal) {
		this.tipificacionSucursal = tipificacionSucursal;
	}

	/**
	 * @return the motivoCEC
	 */
	public String getMotivoCEC() {
		return motivoCEC;
	}

	/**
	 * @param motivoCEC the motivoCEC to set
	 */
	public void setMotivoCEC(String motivoCEC) {
		this.motivoCEC = motivoCEC;
	}

	/* (non-Javadoc)
	 * @see utilitario.mensajes.comun.ObjetoValor#toString()
	 */
	@Override
	public String toString() {
		return "Usuario: " + usuarioAut + "\tcampana: " + campana + "\tSucursal:" + sucursal + "\tCorreo" + correo
				+ "\t nombre sucursal: " + nombreSucursal;
	}

}
