package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author out_ltorres
 * @version 1.0
 */
public class ReporteAsignacionOV extends ObjetoValor {

	/**
	 * constructor
	 */
	public ReporteAsignacionOV() {

	}
	/**
	 * long serialVersionUID ReporteAsignacionOV.java
	 */
	private static final long serialVersionUID = -1647957268593475586L;

	/**
	 * String producto ReporteAsignacionOV.java
	 */
	private String producto;

	/**
	 * String numeroAnalista ReporteAsignacionOV.java
	 */
	private String numeroAnalista;

	/**
	 * String analista ReporteAsignacionOV.java
	 */
	private String analista;

	/**
	 * String sucursal ReporteAsignacionOV.java
	 */
	private String sucursal;

	/**
	 * String solicitud ReporteAsignacionOV.java
	 */
	private String solicitud;

	/**
	 * String nombreGrupo ReporteAsignacionOV.java
	 */
	private String nombreGrupo;

	/**
	 * Integer ciclo ReporteAsignacionOV.java
	 */
	private Integer ciclo;

	/**
	 * String fechaAsignacion ReporteAsignacionOV.java
	 */
	private String fechaAsignacion;

	/**
	 * String fechaResolucion ReporteAsignacionOV.java
	 */
	private String fechaResolucion;

	/**
	 * String estatus ReporteAsignacionOV.java
	 */
	private String estatus;

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
	 * @return the numeroAnalista
	 */
	public String getNumeroAnalista() {
		return numeroAnalista;
	}

	/**
	 * @param numeroAnalista the numeroAnalista to set
	 */
	public void setNumeroAnalista(String numeroAnalista) {
		this.numeroAnalista = numeroAnalista;
	}

	/**
	 * @return the analista
	 */
	public String getAnalista() {
		return analista;
	}

	/**
	 * @param analista the analista to set
	 */
	public void setAnalista(String analista) {
		this.analista = analista;
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


}
