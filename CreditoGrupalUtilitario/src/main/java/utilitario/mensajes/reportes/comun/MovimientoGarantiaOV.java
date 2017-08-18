/**
 * MovimientoGarantia
 */
package utilitario.mensajes.reportes.comun;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author hsamano
 *
 */
public class MovimientoGarantiaOV extends ObjetoValor {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 1269260464918389501L;

	/** categoria de movimientos Deposito Garantia */
	private java.util.List<MovimientoDetalleDepgar> movimientos;

	/**
	 * @return the movimientos
	 */
	public java.util.List<MovimientoDetalleDepgar> getMovimientos() {
		return movimientos;
	}

	/**
	 * @param movimientos the movimientos to set
	 */
	public void setMovimientos(java.util.List<MovimientoDetalleDepgar> movimientos) {
		this.movimientos = movimientos;
	}

}
