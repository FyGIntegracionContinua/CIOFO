package utilitario.mensajes.verificacion.telefonica;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author rguadarramac
 *
 */
public class ConsultaSolicitudesVerificacionRespuesta extends ObjetoValor  {

	/**
	 * ConsultaSolicitudesVerificacionRespuesta
	 */
	public ConsultaSolicitudesVerificacionRespuesta() {

	}

	/**
	 *
	 */
	private static final long serialVersionUID = 5576855717711340919L;
	/**
	 * EncabezadoRespuesta header
	 */
	private EncabezadoRespuesta header;
	/**
	 * List<BitacoraVerificacionFinsolOV> solicitudes
	 */
	private List<BitacoraVerificacionFinsolOV>	solicitudes;

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
	 * @return getSolicitudes :
	 */
	public List<BitacoraVerificacionFinsolOV> getSolicitudes() {
		return solicitudes;
	}

	/**
	 * @param solicitudes setSolicitudes :
	 */
	public void setSolicitudes(List<BitacoraVerificacionFinsolOV> solicitudes) {
		this.solicitudes = solicitudes;
	}

}
