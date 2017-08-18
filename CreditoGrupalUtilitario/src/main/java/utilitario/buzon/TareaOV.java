package utilitario.buzon;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class TareaOV.
 *
 * @author rguadarramac
 */
public class TareaOV  extends ObjetoValor {

	/** serial. */
	private static final long serialVersionUID = 8819534837144818030L;
	/**
	 * Integer TareaOV.java
	 */
	private Integer idTarea;
	/**
	 * String TareaOV.java
	 */
	private String tipoTarea;

	/**
	 * String TareaOV.java
	 */
	private String nombreTarea;

	/**
	 * String TareaOV.java
	 */
	private String tipoTareaEx;

	/**
	 * String TareaOV.java
	 */
	private String descripcion;
	/**
	 * Integer TareaOV.java
	 */
	private Integer region;
	/**
	 * String TareaOV.java
	 */
	private String nombreRegion;
	/**
	 * Integer TareaOV.java
	 */
	private Integer zona;
	/**
	 * String TareaOV.java
	 */
	private String nombreZona;
	/**
	 * Integer TareaOV.java
	 */
	private Integer sucursal;
	/**
	 * String TareaOV.java
	 */
	private String nombreSucursal;

	/**
	 * String TareaOV.java
	 */
	private String propietario;
	/**
	 * String TareaOV.java
	 */
	private String nombrePropietario;

	/**
	 * String TareaOV.java
	 */
	private String fechaAlta;
	/**
	 * String TareaOV.java
	 */
	private String fechaAsignacion;
	/**
	 * String TareaOV.java
	 */
	private String fechaTermino;
	/**
	 * String TareaOV.java
	 */
	private String fechaAutorizacion;
	/**
	 * String TareaOV.java
	 */
	private String fechaCaptura;
	/**
	 * String TareaOV.java
	 */
	private String fechaIngreso;
	/**
	 * String TareaOV.java
	 */
	private String status;
	/**
	 * String TareaOV.java
	 */
	private String perfil;

	/** The descripcion tipo tarea. */
	private String descripcionTipoTarea;

	/** The estatusSolicitud. */
	private String estatusSolicitud;

	/** The estatus. */
	private String estatus;

	/** The codigoResolucion. */
	private String codigoResolucion;

	/** The ciclo. */
	private Integer ciclo;

	/** The codigoProducto. */
	private String codigoProducto;

	/** The categoria. */
	private String categoria;

	/** The express. */
	private String express;

	/** The campana. */
	private String campana;

	/** The nombreGrupo. */
	private String nombreGrupo;

	/** The tipificacionProducto. */
	private String tipificacionProducto;

	/** The solicitud. */
	private String solicitud;

	/** The justificacion. */
	private String justificacion;

	/** The observaciones. */
	private String observaciones;

	/** The contrato. */
	private String contrato;

	/** The espera. */
	private String espera;

	/** The estatusAuth. */
	private String estatusAuth;

	/**
	 * nivelSucursal
	 */
	private String nivelSucursal;

	/**
	 * tipoSucursal
	 */
	private String tipoSucursal;
	/**
	 * tasa
	 */
	private Double tasa;
	/**
	 * plazo
	 */
	private Integer plazo;
	/**
	 * tasa
	 */
	private Double montoSolicitado;

	/**
	 * fechaInicioGestion
	 */
	private String fechaInicioGestion;

	/**
	 * campaña a la que pertenece
	 */
	private String codigoCampana;
	/**
	 * nivelRestriccion
	 */
	private String nivelRestriccion;

	/** correo del divisional*/
	private String correoDivisional;

	/** correo del regional*/
	private String correoRegional;

	/**otro tipo de correo en este caso es el del subdirector comercial*/
	private String otroCorreo;

	/** Resolucion Regional **/
	private String resolucionRegional;

	/** Resolucion Divisional **/
	private String resolucionDivisional;

	/** Resolucion Subdirector **/
	private String resolucionSubdirector;

	/** The idTareaFirmaElec **/
	private Integer idTareaFirmaElec;
	/**
	 * Resolucion Firma Electronica, trae un color de acuerdo a la resolucion de la tarea de firma electronica
	 * green => Aprobada, red => Rechazada, white => enviada o sin resolucion
	 */
	private String resolucionFIE;
	
	private boolean esFirmaElectronica;

	/**
	 * TareaOV.
	 */
	public TareaOV() {

	}

	/**
	 * @return the fechaAutorizacion
	 */
	public String getFechaAutorizacion() {
		return fechaAutorizacion;
	}

	/**
	 * @param fechaAutorizacion the fechaAutorizacion to set
	 */
	public void setFechaAutorizacion(String fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}

	/**
	 * @return the fechaCaptura
	 */
	public String getFechaCaptura() {
		return fechaCaptura;
	}

	/**
	 * @param fechaCaptura the fechaCaptura to set
	 */
	public void setFechaCaptura(String fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}

	/**
	 * @return the fechaIngreso
	 */
	public String getFechaIngreso() {
		return fechaIngreso;
	}

	/**
	 * @param fechaIngreso the fechaIngreso to set
	 */
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	/**
	 * @return the nombreTarea
	 */
	public String getNombreTarea() {
		return nombreTarea;
	}



	/**
	 * @param nombreTarea the nombreTarea to set
	 */
	public void setNombreTarea(String nombreTarea) {
		this.nombreTarea = nombreTarea;
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
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}



	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}



	/**
	 * @return the espera
	 */
	public String getEspera() {
		return espera;
	}



	/**
	 * @param espera the espera to set
	 */
	public void setEspera(String espera) {
		this.espera = espera;
	}



	/**
	 * @return the estatusAuth
	 */
	public String getEstatusAuth() {
		return estatusAuth;
	}



	/**
	 * @param estatusAuth the estatusAuth to set
	 */
	public void setEstatusAuth(String estatusAuth) {
		this.estatusAuth = estatusAuth;
	}



	/**
	 * @return the tipoTareaEx
	 */
	public String getTipoTareaEx() {
		return tipoTareaEx;
	}



	/**
	 * @param tipoTareaEx the tipoTareaEx to set
	 */
	public void setTipoTareaEx(String tipoTareaEx) {
		this.tipoTareaEx = tipoTareaEx;
	}



	/**
	 * Obtiene id tarea.
	 *
	 * @return the idTarea
	 */
	public Integer getIdTarea() {
		return idTarea;
	}

	/**
	 * Establece id tarea.
	 *
	 * @param idTarea the idTarea to set
	 */
	public void setIdTarea(Integer idTarea) {
		this.idTarea = idTarea;
	}

	/**
	 * Obtiene tipo tarea.
	 *
	 * @return the tipoTarea
	 */
	public String getTipoTarea() {
		return tipoTarea;
	}

	/**
	 * Establece tipo tarea.
	 *
	 * @param tipoTarea the tipoTarea to set
	 */
	public void setTipoTarea(String tipoTarea) {
		this.tipoTarea = tipoTarea;
	}

	/**
	 * Obtiene descripcion.
	 *
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece descripcion.
	 *
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene region.
	 *
	 * @return the region
	 */
	public Integer getRegion() {
		return region;
	}

	/**
	 * Establece region.
	 *
	 * @param region the region to set
	 */
	public void setRegion(Integer region) {
		this.region = region;
	}

	/**
	 * Obtiene nombre region.
	 *
	 * @return the nombreRegion
	 */
	public String getNombreRegion() {
		return nombreRegion;
	}

	/**
	 * Establece nombre region.
	 *
	 * @param nombreRegion the nombreRegion to set
	 */
	public void setNombreRegion(String nombreRegion) {
		this.nombreRegion = nombreRegion;
	}

	/**
	 * Obtiene zona.
	 *
	 * @return the zona
	 */
	public Integer getZona() {
		return zona;
	}

	/**
	 * Establece zona.
	 *
	 * @param zona the zona to set
	 */
	public void setZona(Integer zona) {
		this.zona = zona;
	}

	/**
	 * Obtiene nombre zona.
	 *
	 * @return the nombreZona
	 */
	public String getNombreZona() {
		return nombreZona;
	}

	/**
	 * Establece nombre zona.
	 *
	 * @param nombreZona the nombreZona to set
	 */
	public void setNombreZona(String nombreZona) {
		this.nombreZona = nombreZona;
	}

	/**
	 * Obtiene sucursal.
	 *
	 * @return the sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene nombre sucursal.
	 *
	 * @return the nombreSucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}

	/**
	 * Establece nombre sucursal.
	 *
	 * @param nombreSucursal the nombreSucursal to set
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	/**
	 * Obtiene propietario.
	 *
	 * @return the propietario
	 */
	public String getPropietario() {
		return propietario;
	}

	/**
	 * Establece propietario.
	 *
	 * @param propietario the propietario to set
	 */
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	/**
	 * Obtiene nombre propietario.
	 *
	 * @return the nombrePropietario
	 */
	public String getNombrePropietario() {
		return nombrePropietario;
	}

	/**
	 * Establece nombre propietario.
	 *
	 * @param nombrePropietario the nombrePropietario to set
	 */
	public void setNombrePropietario(String nombrePropietario) {
		this.nombrePropietario = nombrePropietario;
	}

	/**
	 * Obtiene fecha alta.
	 *
	 * @return the fechaAlta
	 */
	public String getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * Establece fecha alta.
	 *
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * Obtiene fecha asignacion.
	 *
	 * @return the fechaAsignacion
	 */
	public String getFechaAsignacion() {
		return fechaAsignacion;
	}

	/**
	 * Establece fecha asignacion.
	 *
	 * @param fechaAsignacion the fechaAsignacion to set
	 */
	public void setFechaAsignacion(String fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

	/**
	 * Obtiene fecha termino.
	 *
	 * @return the fechaTermino
	 */
	public String getFechaTermino() {
		return fechaTermino;
	}

	/**
	 * Establece fecha termino.
	 *
	 * @param fechaTermino the fechaTermino to set
	 */
	public void setFechaTermino(String fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	/**
	 * Obtiene status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Establece status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Obtiene perfil.
	 *
	 * @return the perfil
	 */
	public String getPerfil() {
		return perfil;
	}

	/**
	 * Establece perfil.
	 *
	 * @param perfil the perfil to set
	 */
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	/**
	 * Obtiene descripcion tipo tarea.
	 *
	 * @return the descripcionTipoTarea
	 */
	public String getDescripcionTipoTarea() {
		return descripcionTipoTarea;
	}

	/**
	 * Establece descripcion tipo tarea.
	 *
	 * @param descripcionTipoTarea the descripcionTipoTarea to set
	 */
	public void setDescripcionTipoTarea(String descripcionTipoTarea) {
		this.descripcionTipoTarea = descripcionTipoTarea;
	}

	/**
	 * @return the estatusSolicitud
	 */
	public String getEstatusSolicitud() {
		return estatusSolicitud;
	}

	/**
	 * @param estatusSolicitud the estatusSolicitud to set
	 */
	public void setEstatusSolicitud(String estatusSolicitud) {
		this.estatusSolicitud = estatusSolicitud;
	}

	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * @return the codigoResolucion
	 */
	public String getCodigoResolucion() {
		return codigoResolucion;
	}

	/**
	 * @param codigoResolucion the codigoResolucion to set
	 */
	public void setCodigoResolucion(String codigoResolucion) {
		this.codigoResolucion = codigoResolucion;
	}

	/**
	 * @return the ciclo
	 */
	public Integer getCiclo() {
		return ciclo;
	}

	/**
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
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
	 * @return the nivelSucursal
	 */
	public String getNivelSucursal() {
		return nivelSucursal;
	}

	/**
	 * @param nivelSucursal the nivelSucursal to set
	 */
	public void setNivelSucursal(String nivelSucursal) {
		this.nivelSucursal = nivelSucursal;
	}

	/**
	 * @return the tipoSucursal
	 */
	public String getTipoSucursal() {
		return tipoSucursal;
	}

	/**
	 * @param tipoSucursal the tipoSucursal to set
	 */
	public void setTipoSucursal(String tipoSucursal) {
		this.tipoSucursal = tipoSucursal;
	}

	/**
	 * @return the tasa
	 */
	public Double getTasa() {
		return tasa;
	}

	/**
	 * @param tasa the tasa to set
	 */
	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}

	/**
	 * @return the plazo
	 */
	public Integer getPlazo() {
		return plazo;
	}

	/**
	 * @param plazo the plazo to set
	 */
	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}

	/**
	 * @return the montoSolicitado
	 */
	public Double getMontoSolicitado() {
		return montoSolicitado;
	}

	/**
	 * @param montoSolicitado the montoSolicitado to set
	 */
	public void setMontoSolicitado(Double montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}

	/**
	 * @return the fechaInicioGestion
	 */
	public String getFechaInicioGestion() {
		return fechaInicioGestion;
	}

	/**
	 * @param fechaInicioGestion the fechaInicioGestion to set
	 */
	public void setFechaInicioGestion(String fechaInicioGestion) {
		this.fechaInicioGestion = fechaInicioGestion;
	}

	/**
	 * @return the codigoCampana
	 */
	public String getCodigoCampana() {
		return codigoCampana;
	}

	/**
	 * @param codigoCampana the codigoCampana to set
	 */
	public void setCodigoCampana(String codigoCampana) {
		this.codigoCampana = codigoCampana;
	}
	/**
	 * @return the nivelRestriccion
	 */
	public String getNivelRestriccion() {
		return nivelRestriccion;
	}

	/**
	 * @param nivelRestriccion the nivelRestriccion to set
	 */
	public void setNivelRestriccion(String nivelRestriccion) {
		this.nivelRestriccion = nivelRestriccion;
	}

	/**
	 * @return the correoDivisional
	 */
	public String getCorreoDivisional() {
		return correoDivisional;
	}

	/**
	 * @param correoDivisional the correoDivisional to set
	 */
	public void setCorreoDivisional(String correoDivisional) {
		this.correoDivisional = correoDivisional;
	}

	/**
	 * @return the correoRegional
	 */
	public String getCorreoRegional() {
		return correoRegional;
	}

	/**
	 * @param correoRegional the correoRegional to set
	 */
	public void setCorreoRegional(String correoRegional) {
		this.correoRegional = correoRegional;
	}

	/**
	 * @return the otroCorreo
	 */
	public String getOtroCorreo() {
		return otroCorreo;
	}

	/**
	 * @param otroCorreo the otroCorreo to set
	 */
	public void setOtroCorreo(String otroCorreo) {
		this.otroCorreo = otroCorreo;
	}

	/**
	 * @return the resolucionRegional
	 */
	public String getResolucionRegional() {
		return resolucionRegional;
	}

	/**
	 * @param resolucionRegional the resolucionRegional to set
	 */
	public void setResolucionRegional(String resolucionRegional) {
		this.resolucionRegional = resolucionRegional;
	}

	/**
	 * @return the resolucionDivisional
	 */
	public String getResolucionDivisional() {
		return resolucionDivisional;
	}

	/**
	 * @param resolucionDivisional the resolucionDivisional to set
	 */
	public void setResolucionDivisional(String resolucionDivisional) {
		this.resolucionDivisional = resolucionDivisional;
	}

	/**
	 * @return the resolucionSubdirector
	 */
	public String getResolucionSubdirector() {
		return resolucionSubdirector;
	}

	/**
	 * @param resolucionSubdirector the resolucionSubdirector to set
	 */
	public void setResolucionSubdirector(String resolucionSubdirector) {
		this.resolucionSubdirector = resolucionSubdirector;
	}

	/**
	 * @return the resolucionFIE
	 */
	public String getResolucionFIE() {
		return resolucionFIE;
	}

	/**
	 * @param resolucionFIE the resolucionFIE to set
	 */
	public void setResolucionFIE(String resolucionFIE) {
		this.resolucionFIE = resolucionFIE;
	}

	/**
	 * @return the esFirmaElectronica
	 */
	public boolean isEsFirmaElectronica() {
		return esFirmaElectronica;
	}

	/**
	 * @param esFirmaElectronica the esFirmaElectronica to set
	 */
	public void setEsFirmaElectronica(boolean esFirmaElectronica) {
		this.esFirmaElectronica = esFirmaElectronica;
	}

	/**
	 * @return the idTareaFirmaElec
	 */
	public Integer getIdTareaFirmaElec() {
		return idTareaFirmaElec;
	}

	/**
	 * @param idTareaFirmaElec the idTareaFirmaElec to set
	 */
	public void setIdTareaFirmaElec(Integer idTareaFirmaElec) {
		this.idTareaFirmaElec = idTareaFirmaElec;
	}

	/* (non-Javadoc)
	 * @see utilitario.mensajes.comun.ObjetoValor#toString()
	 */
	@Override
	public String toString() {
		return "estatus:" + estatus + "\tcodigoResolucion:" + codigoResolucion;
	}

}
