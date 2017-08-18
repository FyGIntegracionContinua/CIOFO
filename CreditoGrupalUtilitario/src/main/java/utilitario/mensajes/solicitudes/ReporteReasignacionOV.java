package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author out_ltorres
 * @version 1.0
 */
public class ReporteReasignacionOV extends ObjetoValor {

	/**
	 * long serialVersionUID ReporteReasignacionOV.java
	 */
	private static final long serialVersionUID = -4021246835561714192L;

	/**
	 * String producto ReporteReasignacionOV.java
	 */
	private String producto;

	/**
	 * String numeroAnalistaAnterior ReporteReasignacionOV.java
	 */
	private String numeroAnalistaAnterior;

	/**
	 * String analistaAnterior ReporteReasignacionOV.java
	 */
	private String analistaAnterior;

	/**
	 * String numeroAnalistaNuevo ReporteReasignacionOV.java
	 */
	private String numeroAnalistaNuevo;

	/**
	 * String analistaNuevo ReporteReasignacionOV.java
	 */
	private String analistaNuevo;

	/**
	 * String sucursal ReporteReasignacionOV.java
	 */
	private String sucursal;

	/**
	 * String solicitud ReporteReasignacionOV.java
	 */
	private String solicitud;

	/**
	 * String nombreGrupo ReporteReasignacionOV.java
	 */
	private String nombreGrupo;

	/**
	 * Integer ciclo ReporteReasignacionOV.java
	 */
	private Integer ciclo;

	/**
	 * String fechaAsignacion ReporteReasignacionOV.java
	 */
	private String fechaAsignacion;

	/**
	 * String fechaResolucion ReporteReasignacionOV.java
	 */
	private String fechaResolucion;

	/**
	 * String ponderacion ReporteAsignacionOV.java
	 */
	private String ponderacion;

	/**
	 * @return the ponderacion
	 */
	public String getPonderacion() {
		return ponderacion;
	}

	/**
	 * @param ponderacion the ponderacion to set
	 */
	public void setPonderacion(String ponderacion) {
		this.ponderacion = ponderacion;
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
	 * @return the numeroAnalistaAnterior
	 */
	public String getNumeroAnalistaAnterior() {
		return numeroAnalistaAnterior;
	}

	/**
	 * @param numeroAnalistaAnterior the numeroAnalistaAnterior to set
	 */
	public void setNumeroAnalistaAnterior(String numeroAnalistaAnterior) {
		this.numeroAnalistaAnterior = numeroAnalistaAnterior;
	}

	/**
	 * @return the analistaAnterior
	 */
	public String getAnalistaAnterior() {
		return analistaAnterior;
	}

	/**
	 * @param analistaAnterior the analistaAnterior to set
	 */
	public void setAnalistaAnterior(String analistaAnterior) {
		this.analistaAnterior = analistaAnterior;
	}

	/**
	 * @return the numeroAnalistaNuevo
	 */
	public String getNumeroAnalistaNuevo() {
		return numeroAnalistaNuevo;
	}

	/**
	 * @param numeroAnalistaNuevo the numeroAnalistaNuevo to set
	 */
	public void setNumeroAnalistaNuevo(String numeroAnalistaNuevo) {
		this.numeroAnalistaNuevo = numeroAnalistaNuevo;
	}

	/**
	 * @return the analistaNuevo
	 */
	public String getAnalistaNuevo() {
		return analistaNuevo;
	}

	/**
	 * @param analistaNuevo the analistaNuevo to set
	 */
	public void setAnalistaNuevo(String analistaNuevo) {
		this.analistaNuevo = analistaNuevo;
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
	 * @return the fechaResolucion
	 */
	public String getFechaResolucion() {
		return fechaResolucion;
	}

	/**
	 * @param fechaResolucion the fechaResolucion to set
	 */
	public void setFechaResolucion(String fechaResolucion) {
		this.fechaResolucion = fechaResolucion.trim();
	}

}
