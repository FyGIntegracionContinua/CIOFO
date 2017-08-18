/**
 *
 */
package utilitario.mensajes.reportes.garantias;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author lsotos
 *
 */
public class ReporteSolicitudesGarantiaPeticion extends ObjetoValor {

	/**
	 *
	 */
	private static final long serialVersionUID = 6939637287178974735L;

	/**
	 * fecha inicial disposición
	 */
	private String fechaInicial;

	/**
	 * fecha final disposición
	 */
	private String fechaFinal;

	/**
	 * número de la división
	 */
	private Integer division;

	/**
	 * número de la región
	 */
	private Integer region;

	/**
	 * número de contrato
	 */
	private String contrato;

	/**
	 * @return the fechaInicial
	 */
	public String getFechaInicial() {
		return fechaInicial;
	}
	/**
	 * @param fechaInicial = inicio del rango de fecha disposición
	 */
	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}
	/**
	 * @return the fechaFinal
	 */
	public String getFechaFinal() {
		return fechaFinal;
	}
	/**
	 * @param fechaFinal = fin del rango de fecha disposición
	 */
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
	/**
	 * @return the division
	 */
	public Integer getDivision() {
		return division;
	}
	/**
	 * @param division número
	 */
	public void setDivision(Integer division) {
		this.division = division;
	}
	/**
	 * @return the region
	 */
	public Integer getRegion() {
		return region;
	}
	/**
	 * @param region número
	 */
	public void setRegion(Integer region) {
		this.region = region;
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

}
