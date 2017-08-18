/**
 * Tensegrity - 2011
 */
package utilitario.mensajes.originacion.consulta;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class ConsultaDiaHabilOV.
 */
public final class ConsultaDiaHabilOV extends ObjetoValor {

	/**
	 * Instancia una nueva consulta dia habil ov.
	 */
	public ConsultaDiaHabilOV() { }
	/** The Constant serialVersionUID. */
	private static final long 	serialVersionUID = 1L;

	 /** The fecha. */
	 private java.util.Date  	fecha;			//PARAMETROS FECHA

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
	 * Obtiene fecha.
	 *
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Establece fecha.
	 *
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
