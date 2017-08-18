package utilitario.mensajes.reportes.comun;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class PersonasBloqueoPeticion.
 */
public class PersonasBloqueoPeticion extends ObjetoValor {

	/** serialVersionUID. */
	private static final long serialVersionUID = 5774954257162933665L;

	 /** Fecha para consultar el reporte de pagos importados. */
	private String fechaInicio;

	/** The fecha fin. */
	private String fechaFin;
	/** The fechaInicioDate. */
	private Date fechaInicioDate;
	/** The fechaFinDate. */
	private Date fechaFinDate;


	/**
	 * Gets the fecha inicio.
	 *
	 * @return the fecha inicio
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Sets the fecha inicio.
	 *
	 * @param fechaInicio the new fecha inicio
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Gets the fecha fin.
	 *
	 * @return the fecha fin
	 */
	public String getFechaFin() {
		return fechaFin;
	}

	/**
	 * Sets the fecha fin.
	 *
	 * @param fechaFin the new fecha fin
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the fechaInicioDate
	 */
	public Date getFechaInicioDate() {
		return fechaInicioDate;
	}

	/**
	 * @param fechaInicioDate the fechaInicioDate to set
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
	 * @param fechaFinDate the fechaFinDate to set
	 */
	public void setFechaFinDate(Date fechaFinDate) {
		this.fechaFinDate = fechaFinDate;
	}

}
