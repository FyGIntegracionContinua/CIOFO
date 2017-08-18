package utilitario.mensajes.solicitudes;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class CargaTrabajoOV.
 *
 * @author rguadarramac
 * @version 1.0
 */
public class CargaTrabajoOV extends ObjetoValor {

	/**
	 * Instancia una nueva carga trabajo ov.
	 */
	public CargaTrabajoOV() {
	}
	/** Se genero serial. */
	private static final long serialVersionUID = -9159036514039132884L;

	/** The id tarea. */
	private Integer idTarea;

	/** The solicitud. */
	private String solicitud;

	/** The numero grupo. */
	private String numeroGrupo;

	/** The nombre grupo. */
	private String nombreGrupo;

	/** The descripcion. */
	private String descripcion;

	/** The sucursal. */
	private Integer sucursal;

	/** The nombre sucursal. */
	private String nombreSucursal;

	/** The ciclo. */
	private Integer ciclo;

	/** The fecha asignacion. */
	private Date fechaAsignacion;

	/** The ponderacion. */
	private Double ponderacion;

	/** The estatus tarea. */
	private String estatusTarea;

	/** The numero integrantes. */
	private Integer numeroIntegrantes;

	/** The estatus solicitud. */
	private String estatusSolicitud;

	/** The persona. */
	private String persona;

	/** The tipo tarea. */
	private String tipoTarea;

	/** The tipo procesoSolicitud. */
	private String procesoSolicitud;

	/** The tipo campana. */
	private String campana;

	/** The tipo express. */
	private String express;

	/** The tipo categoria. */
	private String categoria;

	/** The tipo categoria. */
	private String codigoProducto;

	/** The tipo categoria. */
	private String tipificacionProducto;

	private String subEstatus;

	/**
	 * Obtiene id tarea.
	 *
	 * @return id tarea
	 */
	public Integer getIdTarea() {
		return idTarea;
	}

	/**
	 * Establece id tarea.
	 *
	 * @param idTarea a id tarea
	 */
	public void setIdTarea(Integer idTarea) {
		this.idTarea = idTarea;
	}

	/**
	 * Obtiene solicitud.
	 *
	 * @return solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}

	/**
	 * Establece solicitud.
	 *
	 * @param solicitud a solicitud
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	/**
	 * Obtiene numero grupo.
	 *
	 * @return numero grupo
	 */
	public String getNumeroGrupo() {
		return numeroGrupo;
	}

	/**
	 * Establece numero grupo.
	 *
	 * @param numeroGrupo a numero grupo
	 */
	public void setNumeroGrupo(String numeroGrupo) {
		this.numeroGrupo = numeroGrupo;
	}

	/**
	 * Obtiene nombre grupo.
	 *
	 * @return nombre grupo
	 */
	public String getNombreGrupo() {
		return nombreGrupo;
	}

	/**
	 * Establece nombre grupo.
	 *
	 * @param nombreGrupo a nombre grupo
	 */
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	/**
	 * Obtiene descripcion.
	 *
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece descripcion.
	 *
	 * @param descripcion a descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	 * Obtiene nombre sucursal.
	 *
	 * @return nombre sucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}

	/**
	 * Establece nombre sucursal.
	 *
	 * @param nombreSucursal a nombre sucursal
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal.trim();
	}

	/**
	 * Obtiene ciclo.
	 *
	 * @return ciclo
	 */
	public Integer getCiclo() {
		return ciclo;
	}

	/**
	 * Establece ciclo.
	 *
	 * @param ciclo a ciclo
	 */
	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * Obtiene fecha asignacion.
	 *
	 * @return fecha asignacion
	 */
	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}

	/**
	 * Establece fecha asignacion.
	 *
	 * @param fechaAsignacion a fecha asignacion
	 */
	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
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
	 * Obtiene estatus tarea.
	 *
	 * @return estatus tarea
	 */
	public String getEstatusTarea() {
		return estatusTarea;
	}

	/**
	 * Establece estatus tarea.
	 *
	 * @param estatusTarea a estatus tarea
	 */
	public void setEstatusTarea(String estatusTarea) {
		this.estatusTarea = estatusTarea;
	}

	/**
	 * Obtiene numero integrantes.
	 *
	 * @return numero integrantes
	 */
	public Integer getNumeroIntegrantes() {
		return numeroIntegrantes;
	}

	/**
	 * Establece numero integrantes.
	 *
	 * @param numeroIntegrantes a numero integrantes
	 */
	public void setNumeroIntegrantes(Integer numeroIntegrantes) {
		this.numeroIntegrantes = numeroIntegrantes;
	}

	/**
	 * Obtiene estatus solicitud.
	 *
	 * @return estatus solicitud
	 */
	public String getEstatusSolicitud() {
		return estatusSolicitud;
	}

	/**
	 * Establece estatus solicitud.
	 *
	 * @param estatusSolicitud a estatus solicitud
	 */
	public void setEstatusSolicitud(String estatusSolicitud) {
		this.estatusSolicitud = estatusSolicitud;
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
	 * Obtiene persona.
	 *
	 * @return persona
	 */
	public String getPersona() {
		return persona;
	}

	/**
	 * Establece tipo tarea.
	 *
	 * @param tipoTarea a tipo tarea
	 */
	public void setTipoTarea(String tipoTarea) {
		this.tipoTarea = tipoTarea;
	}

	/**
	 * Obtiene tipo tarea.
	 *
	 * @return tipo tarea
	 */
	public String getTipoTarea() {
		return tipoTarea;
	}

	/**
	 * @return the procesoSolicitud
	 */
	public String getProcesoSolicitud() {
		return procesoSolicitud;
	}

	/**
	 * @param procesoSolicitud the procesoSolicitud to set
	 */
	public void setProcesoSolicitud(String procesoSolicitud) {
		this.procesoSolicitud = procesoSolicitud;
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
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the codigoProducto
	 */
	public String getCodigoProducto() {
		return codigoProducto;
	}

	/**
	 * @param codigoProducto the codigoProducto to set
	 */
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	/**
	 * @return the tipificacionProducto
	 */
	public String getTipificacionProducto() {
		return tipificacionProducto;
	}

	/**
	 * @param tipificacionProducto the tipificacionProducto to set
	 */
	public void setTipificacionProducto(String tipificacionProducto) {
		this.tipificacionProducto = tipificacionProducto;
	}

	/**
	 * @return the subEstatus
	 */
	public String getSubEstatus() {
		return subEstatus;
	}

	/**
	 * @param subEstatus the subEstatus to set
	 */
	public void setSubEstatus(String subEstatus) {
		this.subEstatus = subEstatus;
	}

}
