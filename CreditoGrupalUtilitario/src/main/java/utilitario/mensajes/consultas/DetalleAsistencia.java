/**
 *
 */
package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ca.ocampo
 *
 */
public class DetalleAsistencia  extends ObjetoValor {

	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = -6493841642301656750L;

	/**
	 * ReporteAsistencias
	 */
	public DetalleAsistencia() {

	}

	/** the dia. */
	private int dia;

	/** the diaLetra. */
	private String diaLetra;

	/** the dia. */
	private int valor;

	/** the tipoAsistencia. */
	private String tipoAsistencia;

	/**
	 * @return the dia
	 */
	public int getDia() {
		return dia;
	}

	/**
	 * @param dia the dia to set
	 */
	public void setDia(int dia) {
		this.dia = dia;
	}

	/**
	 * @return the diaLetra
	 */
	public String getDiaLetra() {
		return diaLetra;
	}

	/**
	 * @param diaLetra the diaLetra to set
	 */
	public void setDiaLetra(String diaLetra) {
		this.diaLetra = diaLetra;
	}

	/**
	 * @return the valor
	 */
	public int getValor() {
		return valor;
	}

	/**
	 * @param valor the valor to set
	 */
	public void setValor(int valor) {
		this.valor = valor;
	}

	/**
	 * @return the tipoAsistencia
	 */
	public String getTipoAsistencia() {
		return tipoAsistencia;
	}

	/**
	 * @param tipoAsistencia the tipoAsistencia to set
	 */
	public void setTipoAsistencia(String tipoAsistencia) {
		this.tipoAsistencia = tipoAsistencia;
	}

	

}
