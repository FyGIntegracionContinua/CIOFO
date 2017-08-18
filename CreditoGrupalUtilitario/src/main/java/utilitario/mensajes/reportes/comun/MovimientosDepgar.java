/**
 * Movimientos deposito garantias
 */
package utilitario.mensajes.reportes.comun;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author hsamano
 *
 */
public class MovimientosDepgar extends ObjetoValor {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 3725011029576791316L;

	/**
	 * Movimiento de garantia
	 */
	private java.util.List<MovimientoDetalleDepgar> movimiento;

	/**
	 * @return the movimiento
	 */
	public java.util.List<MovimientoDetalleDepgar> getMovimiento() {
		return movimiento;
	}

	/**
	 * @param movimiento the movimiento to set
	 */
	public void setMovimiento(java.util.List<MovimientoDetalleDepgar> movimiento) {
		this.movimiento = movimiento;
	}

}
