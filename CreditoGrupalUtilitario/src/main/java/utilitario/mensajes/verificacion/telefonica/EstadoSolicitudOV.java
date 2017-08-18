package utilitario.mensajes.verificacion.telefonica;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author equipo desarrollo
 *
 */
public class EstadoSolicitudOV extends ObjetoValor {

	/**
	 * EstadoSolicitudOV
	 */
	public EstadoSolicitudOV() {

	}
	/**
	 *
	 */
	private static final long serialVersionUID = -1262225764676766733L;

	/**
	 * BitacoraVerificacionFinsolOV bitacoraVerificacionFinsolOV
	 */
	private BitacoraVerificacionFinsolOV bitacoraVerificacionFinsolOV;
	/**
	 * SolicitudOV solicitudOV
	 */
	private SolicitudOV					 solicitudOV;

	/**
	 * @return getBitacoraVerificacionFinsolOV :
	 */
	public BitacoraVerificacionFinsolOV getBitacoraVerificacionFinsolOV() {
		return bitacoraVerificacionFinsolOV;
	}
	/**
	 * @param bitacoraVerificacionFinsolOV setBitacoraVerificacionFinsolOV :
	 */
	public void setBitacoraVerificacionFinsolOV(
			BitacoraVerificacionFinsolOV bitacoraVerificacionFinsolOV) {
		this.bitacoraVerificacionFinsolOV = bitacoraVerificacionFinsolOV;
	}
	/**
	 * @return getSolicitudOV :
	 */
	public SolicitudOV getSolicitudOV() {
		return solicitudOV;
	}
	/**
	 * @param solicitudOV setSolicitudOV :
	 */
	public void setSolicitudOV(SolicitudOV solicitudOV) {
		this.solicitudOV = solicitudOV;
	}

}
