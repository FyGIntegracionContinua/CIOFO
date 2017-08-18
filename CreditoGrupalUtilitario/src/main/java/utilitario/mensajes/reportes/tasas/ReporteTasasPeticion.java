package utilitario.mensajes.reportes.tasas;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ca.ocampo
 *
 */
public class ReporteTasasPeticion extends ObjetoValor {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * fecha inicial disposición
	 */
	private String fechaInicial;

	/**
	 * fecha final disposición
	 */
	private String fechaFinal;

	/**
	 * tipo de Movimiento
	 */
	private String tipoMovimiento;

	/**
	 * fechaInicioDate
	 */
	private Date fechaInicioDate;

	/**
	 * fechaFinDate
	 */
	private Date fechaFinDate;
	/**
	 * @return the fechaInicial
	 */
	public String getFechaInicial() {
		return fechaInicial;
	}

	/**
	 * @param fechaInicial = inicio del rango de fecha
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
	 * @param fechaFinal = fin del rango de fecha
	 */
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	/**
	 * @return the tipoMovimiento
	 */
	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	/**
	 * @param tipoMovimiento = tipoMovimiento
	 */
	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	/**
	 * @return the fechaInicioDate
	 */
	public Date getFechaInicioDate() {
		return fechaInicioDate;
	}

	/**
	 * @param fechaInicioDate fechaInicioDate
	 */
	public void setFechaInicioDate(Date fechaInicioDate) {
		this.fechaInicioDate = fechaInicioDate;
	}

	/**
	 * @return the fechaFinDate
	 */
	public Date getFechaFinDate() {
		return fechaFinDate;
	}

	/**
	 * @param fechaFinDate fechaFinDate
	 */
	public void setFechaFinDate(Date fechaFinDate) {
		this.fechaFinDate = fechaFinDate;
	}
}
