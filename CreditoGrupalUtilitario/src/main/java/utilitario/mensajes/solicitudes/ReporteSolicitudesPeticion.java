package utilitario.mensajes.solicitudes;

import java.util.Date;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ReporteSolicitudesRespuesta
 * @author out_ltorres
 *
 */
public class ReporteSolicitudesPeticion extends ObjetoValor {

	/** Serial. */
	private static final long serialVersionUID = -1592101649103687682L;

	/**
	 * EncabezadoRespuesta ReporteBuroExternoRespuesta.java
	 */
	private EncabezadoPeticion header;

	/**
	 * Date fechaInicial ReporteSolicitudesPeticion.java
	 */
	private Date fechaInicial;

	/**
	 * Date fechaFinal ReporteSolicitudesPeticion.java
	 */
	private Date fechaFinal;

	/**
	 * Long division ReporteSolicitudesPeticion.java
	 */
	private Long division;

	/**
	 * Long region ReporteSolicitudesPeticion.java
	 */
	private Long region;

	/**
	 * Long sucursal ReporteSolicitudesPeticion.java
	 */
	private Long sucursal;

	/**
	 * String producto ReporteSolicitudesPeticion.java
	 */
	private String producto;

	/**
	 * String estatus ReporteSolicitudesPeticion.java
	 */
	private String estatus;

	/**
	 * Integer ciclo ReporteSolicitudesPeticion.java
	 */
	private Integer ciclo;

	/**
	 * String analista ReporteSolicitudesPeticion.java
	 */
	private String analista;

	/**
	 * String renovacion ReporteSolicitudesPeticion.java
	 */
	private String renovacion;

	/**
	 * Obtiene analista.
	 *
	 * @return the analista
	 */
	public String getAnalista() {
		return analista;
	}

	/**
	 * Obtiene analista.
	 * @param analista the analista to set
	 */
	public void setAnalista(String analista) {
		this.analista = analista;
	}

	/**
	 * Obtiene renovacion.
	 *
	 * @return the renovacion
	 */
	public String getRenovacion() {
		return renovacion;
	}

	/**
	 * Obtiene renovacion.
	 *
	  * @param renovacion the renovacion to set
	 */
	public void setRenovacion(String renovacion) {
		this.renovacion = renovacion;
	}

	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}

	/**
	 * Obtiene fechaInicial.
	 *
	 * @return the fechaInicial
	 */
	public Date getFechaInicial() {
		return fechaInicial;
	}

	/**
	 * Establece fechaInicial.
	 *
	 * @param fechaInicial the fechaInicial to set
	 */
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	/**
	 * Obtiene fechaFinal.
	 *
	 * @return the fechaFinal
	 */
	public Date getFechaFinal() {
		return fechaFinal;
	}

	/**
	 * Establece fechaFinal.
	 *
	 * @param fechaFinal the fechaFinal to set
	 */
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	/**
	 * Obtiene division.
	 *
	 * @return the division
	 */
	public Long getDivision() {
		return division;
	}

	/**
	 * Establece division.
	 *
	 * @param division the division to set
	 */
	public void setDivision(Long division) {
		this.division = division;
	}

	/**
	 * Obtiene region.
	 *
	 * @return the region
	 */
	public Long getRegion() {
		return region;
	}

	/**
	 * Establece region.
	 *
	 * @param region the region to set
	 */
	public void setRegion(Long region) {
		this.region = region;
	}

	/**
	 * Obtiene sucursal.
	 *
	 * @return the sucursal
	 */
	public Long getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(Long sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene producto.
	 *
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * Establece producto.
	 *
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
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
	 * Obtiene ciclo.
	 *
	 * @return the ciclo
	 */
	public Integer getCiclo() {
		return ciclo;
	}

	/**
	 * Establece ciclo.
	 *
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}

}
