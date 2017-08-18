package utilitario.mensajes.verificacion.telefonica;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ValidaStatusSolicitudRespuesta.
 *
 * @author rguadarramac
 */
public class ValidaStatusSolicitudRespuesta extends ObjetoValor {

	/**
	 * ValidaStatusSolicitudRespuesta
	 */
	public ValidaStatusSolicitudRespuesta() {

	}
	/**
	 *
	 */
	private static final long serialVersionUID = -4586211535586572690L;

	/**
	 * EncabezadoRespuesta header
	 */
	private EncabezadoRespuesta header;
	/**
	 * EstadoSolicitudOV estadoSolicitudOV
	 */
	private EstadoSolicitudOV 	estadoSolicitudOV;

	/**
	 * @return getHeader :
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * @param header setHeader :
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * @return getEstadoSolicitudOV :
	 */
	public EstadoSolicitudOV getEstadoSolicitudOV() {
		return estadoSolicitudOV;
	}

	/**
	 * @param estadoSolicitudOV setEstadoSolicitudOV :
	 */
	public void setEstadoSolicitudOV(EstadoSolicitudOV estadoSolicitudOV) {
		this.estadoSolicitudOV = estadoSolicitudOV;
	}

}
