/**
 * Tensegrity - 2011
 */
package utilitario.mensajes.originacion.consulta;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class ConsultaDiaInhabilOV.
 */
public final class ConsultaDiaInhabilOV extends ObjetoValor {

	/**
	 * Instancia una nueva consulta dia inhabil ov.
	 */
	public ConsultaDiaInhabilOV() { }
	/** The Constant serialVersionUID. */
	private static final long 	serialVersionUID = 1L;

	 /** The year. */
	 private java.lang.Integer  	year;					//PARAMETROS FECHA

	 /** The sucursal. */
	 private java.lang.Integer 	sucursal;

	/**
	 * Obtiene sucursal.
	 *
	 * @return the sucursal
	 */
	public java.lang.Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(java.lang.Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene year.
	 *
	 * @return the year
	 */
	public java.lang.Integer getYear() {
		return year;
	}

	/**
	 * Establece year.
	 *
	 * @param year the year to set
	 */
	public void setYear(java.lang.Integer year) {
		this.year = year;
	}

}
