package utilitario.mensajes.reportes.garantias;

import utilitario.mensajes.comun.ObjetoValor;

public class PeticionReporteExcepcionGarantia extends ObjetoValor {

	/**
	 * @author lsotos
	 */
	private static final long serialVersionUID = -284717184081398983L;

	/**
	 * número de la región
	 */
	private java.lang.Integer region;

	/**
	 * número de la división
	 */
	private Integer division;

	/**
	 * estatus de la excepción
	 */
	private String estatusExcepcion;

	/**
	 * fecha inicio rango alta excepción
	 */
	private String fechaAltaInicio;

	/**
	 * fecha fin rango alta excepción
	 */
	private String fechaAltaFin;

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
	 * @return the division
	 */
	public Integer getDivision() {
		return division;
	}

	/**
	 * @param division the division to set
	 */
	public void setDivision(Integer division) {
		this.division = division;
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
	 * @return the fechaAltaInicio
	 */
	public String getFechaAltaInicio() {
		return fechaAltaInicio;
	}

	/**
	 * @param fechaAltaInicio the fechaAltaInicio to set
	 */
	public void setFechaAltaInicio(String fechaAltaInicio) {
		this.fechaAltaInicio = fechaAltaInicio;
	}

	/**
	 * @return the fechaAltaFin
	 */
	public String getFechaAltaFin() {
		return fechaAltaFin;
	}

	/**
	 * @param fechaAltaFin the fechaAltaFin to set
	 */
	public void setFechaAltaFin(String fechaAltaFin) {
		this.fechaAltaFin = fechaAltaFin;
	}
}
