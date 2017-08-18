/**
 * Respuesta ws
 */
package utilitario.mensajes.reportes.comun;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author hsamano
 *
 */
public class RespuestaDepGar extends ObjetoValor {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = -4441801859667091365L;

	/** Estado de la respuesta */
	private StatusDepGar status;

	/** Movimientos Depositos garantia */
	private MovimientoGarantiaOV movimientoGarantia;

	/**
	 * @return the status
	 */
	public StatusDepGar getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(StatusDepGar status) {
		this.status = status;
	}

	/**
	 * @return the movimientoGarantia
	 */
	public MovimientoGarantiaOV getMovimientoGarantia() {
		return movimientoGarantia;
	}

	/**
	 * @param movimientoGarantia the movimientoGarantia to set
	 */
	public void setMovimientoGarantia(MovimientoGarantiaOV movimientoGarantia) {
		this.movimientoGarantia = movimientoGarantia;
	}
}
