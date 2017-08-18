/**
 * Respuesta WS depositos garantia
 */
package utilitario.mensajes.reportes.comun;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author hsamano
 *
 */

public class DepositosGarantiaRespuestaOV extends ObjetoValor {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 8212796200837130006L;

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
//	/** Estado de la respuesta */
//	private RespuestaDepGar respuesta;
//
//	/**
//	 * @return the respuesta
//	 */
//	public RespuestaDepGar getRespuesta() {
//		return respuesta;
//	}
//
//	/**
//	 * @param respuesta the respuesta to set
//	 */
//	public void setRespuesta(RespuestaDepGar respuesta) {
//		this.respuesta = respuesta;
//	}
}
