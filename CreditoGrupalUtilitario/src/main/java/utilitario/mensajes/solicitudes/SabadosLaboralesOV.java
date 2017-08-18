/**
 * Obj OV
 */
package utilitario.mensajes.solicitudes;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author hsamano
 *
 */
public class SabadosLaboralesOV extends ObjetoValor {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = -2013471414845636817L;
	/**
	 * Sabado laborable
	 */
	private Date fecha;
	/**
	 * Fecha de alta
	 */
	private Date fechaAlta;
	/**
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the fechaAlta
	 */
	public Date getFechaAlta() {
		return fechaAlta;
	}
	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
}
