/**
 * @version 1.0
 */
package utilitario.mensajes.solicitudes;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author hsamano
 *
 */
public class DiasInhabilesOV extends ObjetoValor {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Sucursal
	 */
	private String sucursal;
	/**
	 * fecha
	 */
	private Date fecha;
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
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}
	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
}
