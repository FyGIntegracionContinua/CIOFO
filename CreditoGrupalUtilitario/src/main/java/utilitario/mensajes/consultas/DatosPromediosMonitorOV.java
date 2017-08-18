package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

public class DatosPromediosMonitorOV extends ObjetoValor {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -5355029712791270806L;

	/**
	 * Instancia una nueva datos imagenes monitor ov.
	 */
	public DatosPromediosMonitorOV() {
	}

	/** The promedioDiario. */
	private String promedioDiario;

	/** The promedioMes. */
	private String promedioMes;

	/** The promedioSemestral. */
	private String promedioSemestral;

	/** The numArchEnvDiario. */
	private String numArchEnvDiario;

	/** The numArchEnvMes. */
	private String numArchEnvMes;

	/** The numArchEnvHist. */
	private String numArchEnvHist;

	/** The numArchError. */
	private String numArchError;

	/**
	 * Obtiene promedioDiario.
	 *
	 * @return the promedioDiario
	 */
	public String getPromedioDiario() {
		return promedioDiario;
	}

	/**
	 * Establece promedioDiario.
	 *
	 * @param promedioDiario the promedioDiario to set
	 */
	public void setPromedioDiario(String promedioDiario) {
		this.promedioDiario = promedioDiario;
	}

	/**
	 * Obtiene promedioMes.
	 *
	 * @return the promedioMes
	 */
	public String getPromedioMes() {
		return promedioMes;
	}

	/**
	 * Establece promedioMes.
	 *
	 * @param promedioMes the promedioMes to set
	 */
	public void setPromedioMes(String promedioMes) {
		this.promedioMes = promedioMes;
	}

	/**
	 * Obtiene promedioSemestral.
	 *
	 * @return the promedioSemestral
	 */
	public String getPromedioSemestral() {
		return promedioSemestral;
	}

	/**
	 * Establece promedioSemestral.
	 *
	 * @param promedioSemestral the promedioSemestral to set
	 */
	public void setPromedioSemestral(String promedioSemestral) {
		this.promedioSemestral = promedioSemestral;
	}

	/**
	 * Obtiene numArchEnvDiario.
	 *
	 * @return the numArchEnvDiario
	 */
	public String getNumArchEnvDiario() {
		return numArchEnvDiario;
	}

	/**
	 * Establece numArchEnvDiario.
	 *
	 * @param numArchEnvDiario the numArchEnvDiario to set
	 */
	public void setNumArchEnvDiario(String numArchEnvDiario) {
		this.numArchEnvDiario = numArchEnvDiario;
	}

	/**
	 * Obtiene numArchEnvMes.
	 *
	 * @return the numArchEnvMes
	 */
	public String getNumArchEnvMes() {
		return numArchEnvMes;
	}

	/**
	 * Establece numArchEnvMes.
	 *
	 * @param numArchEnvMes the numArchEnvMes to set
	 */
	public void setNumArchEnvMes(String numArchEnvMes) {
		this.numArchEnvMes = numArchEnvMes;
	}

	/**
	 * Obtiene numArchEnvHist.
	 *
	 * @return the numArchEnvHist
	 */
	public String getNumArchEnvHist() {
		return numArchEnvHist;
	}

	/**
	 * Establece numArchEnvHist.
	 *
	 * @param numArchEnvHist the numArchEnvHist to set
	 */
	public void setNumArchEnvHist(String numArchEnvHist) {
		this.numArchEnvHist = numArchEnvHist;
	}

	/**
	 * @return the numArchError
	 */
	public String getNumArchError() {
		return numArchError;
	}

	/**
	 * @param numArchError the numArchError to set
	 */
	public void setNumArchError(String numArchError) {
		this.numArchError = numArchError;
	}
}
