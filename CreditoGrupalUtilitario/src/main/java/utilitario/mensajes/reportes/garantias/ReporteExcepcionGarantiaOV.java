package utilitario.mensajes.reportes.garantias;

import utilitario.mensajes.comun.ObjetoValor;

public class ReporteExcepcionGarantiaOV extends ObjetoValor {

	/**
	 * @author lsotos
	 */
	private static final long serialVersionUID = -8606127288689143149L;

	/**
	 * número de la región
	 */
	private java.lang.Integer region;

	/**
	 * nombre de la región
	 */
	private java.lang.String nombreRegion;

	/**
	 * número de sucursal
	 */
	private Integer sucursal;

	/**
	 * nombre de la sucursal
	 */
	private String nombreSucursal;

	/**
	 * número de solicitud
	 */
	private String solicitud;

	/**
	 * contrato nuevo
	 */
	private String contratoNuevo;

	/**
	 * contrato anterior
	 */
	private String contratoRenovacion;

	/**
	 * ciclo al que pertenece el grupo
	 */
	private Integer ciclo;

	/**
	 * descripción del producto
	 */
	private String producto;

	/**
	 * alta de la excepción
	 */
	private String fechaAltaExcepcion;

	/**
	 * estatus de la excepción en el buzón tareas
	 */
	private String estatusExcepcion;

	/**
	 * observaciones
	 */
	private String observaciones;

	/**
	 * nombreGrupo
	 */
	private String nombreGrupo;

	/**
	 * @return the region
	 */
	public java.lang.Integer getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(java.lang.Integer region) {
		this.region = region;
	}

	/**
	 * @return the nombreRegion
	 */
	public java.lang.String getNombreRegion() {
		return nombreRegion;
	}

	/**
	 * @param nombreRegion the nombreRegion to set
	 */
	public void setNombreRegion(java.lang.String nombreRegion) {
		this.nombreRegion = nombreRegion;
	}

	/**
	 * @return the sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
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
	 * @return the contratoNuevo
	 */
	public String getContratoNuevo() {
		return contratoNuevo;
	}

	/**
	 * @param contratoNuevo the contratoNuevo to set
	 */
	public void setContratoNuevo(String contratoNuevo) {
		this.contratoNuevo = contratoNuevo;
	}

	/**
	 * @return the contratoRenovacion
	 */
	public String getContratoRenovacion() {
		return contratoRenovacion;
	}

	/**
	 * @param contratoRenovacion the contratoRenovacion to set
	 */
	public void setContratoRenovacion(String contratoRenovacion) {
		this.contratoRenovacion = contratoRenovacion;
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
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

	/**
	 * @return the fechaAltaExcepcion
	 */
	public String getFechaAltaExcepcion() {
		return fechaAltaExcepcion;
	}

	/**
	 * @param fechaAltaExcepcion the fechaAltaExcepcion to set
	 */
	public void setFechaAltaExcepcion(String fechaAltaExcepcion) {
		this.fechaAltaExcepcion = fechaAltaExcepcion;
	}

	/**
	 * @return the estatusExcepcion
	 */
	public String getEstatusExcepcion() {
		return estatusExcepcion;
	}

	/**
	 * @param estatusExcepcion the estatusExcepcion to set
	 */
	public void setEstatusExcepcion(String estatusExcepcion) {
		this.estatusExcepcion = estatusExcepcion;
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
}
