package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * @author out_ltorres
 * @version 1.0
 */
public class ReporteBuroExternoOV extends ObjetoValor {

	/**
	 * long serialVersionUID ReporteBuroExternoOV.java
	 */
	private static final long serialVersionUID = 977758506331555596L;

	/**
	 * String nombreProducto ReporteBuroExternoOV.java
	 */
	private String codigoProducto;

	/**
	 * String descripcionProducto ReporteBuroExternoOV.java
	 */
	private String descripcionProducto;

	/**
	 * Long cumpleValidacion ReporteBuroExternoOV.java
	 */
	private Long cumpleValidacion;

	/**
	 * Double cumpleValidacion ReporteBuroExternoOV.java
	 */
	private Double cumpleValidacionPorcentaje;

	/**
	 * Long noCumpleValidacion ReporteBuroExternoOV.java
	 */
	private Long noCumpleValidacion;

	/**
	 * Double noCumpleValidacionPorcentaje ReporteBuroExternoOV.java
	 */
	private Double noCumpleValidacionPorcentaje;

	/**
	 * Long total ReporteBuroExternoOV.java
	 */
	private Long total;

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
	 * @return the descripcionProducto
	 */
	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	/**
	 * @param descripcionProducto the descripcionProducto to set
	 */
	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	/**
	 * @return the cumpleValidacion
	 */
	public Long getCumpleValidacion() {
		return cumpleValidacion;
	}

	/**
	 * @param cumpleValidacion the cumpleValidacion to set
	 */
	public void setCumpleValidacion(Long cumpleValidacion) {
		this.cumpleValidacion = cumpleValidacion;
	}

	/**
	 * @return the cumpleValidacionPorcentaje
	 */
	public Double getCumpleValidacionPorcentaje() {
		return cumpleValidacionPorcentaje;
	}

	/**
	 * @param cumpleValidacionPorcentaje the cumpleValidacionPorcentaje to set
	 */
	public void setCumpleValidacionPorcentaje(Double cumpleValidacionPorcentaje) {
		this.cumpleValidacionPorcentaje = cumpleValidacionPorcentaje;
	}

	/**
	 * @return the noCumpleValidacion
	 */
	public Long getNoCumpleValidacion() {
		return noCumpleValidacion;
	}

	/**
	 * @param noCumpleValidacion the noCumpleValidacion to set
	 */
	public void setNoCumpleValidacion(Long noCumpleValidacion) {
		this.noCumpleValidacion = noCumpleValidacion;
	}

	/**
	 * @return the noCumpleValidacionPorcentaje
	 */
	public Double getNoCumpleValidacionPorcentaje() {
		return noCumpleValidacionPorcentaje;
	}

	/**
	 * @param noCumpleValidacionPorcentaje the noCumpleValidacionPorcentaje to set
	 */
	public void setNoCumpleValidacionPorcentaje(Double noCumpleValidacionPorcentaje) {
		this.noCumpleValidacionPorcentaje = noCumpleValidacionPorcentaje;
	}

	/**
	 * @return the total
	 */
	public Long getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(Long total) {
		this.total = total;
	}

}
