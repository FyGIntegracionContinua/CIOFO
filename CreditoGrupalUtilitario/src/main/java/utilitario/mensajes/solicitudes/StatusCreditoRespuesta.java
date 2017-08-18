package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author rguadarramac
 *
 */
public class StatusCreditoRespuesta extends ObjetoValor {

	/**
	 * StatusCreditoRespuesta
	 */
	public StatusCreditoRespuesta() {
	}
	/**
	 *
	 */
	private static final long serialVersionUID = -6451899559144662886L;

	/**
	 * EncabezadoRespuesta header
	 */
	private EncabezadoRespuesta header;

	/**
	 * List<StatusCreditoOV> statusCreditos
	 */
	private List<StatusCreditoOV> statusCreditos;

	/**
	 * @return header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * @param header EncabezadoRespuesta
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * @param statusCreditos List<StatusCreditoOV>
	 */
	public void setStatusCreditos(List<StatusCreditoOV> statusCreditos) {
		this.statusCreditos = statusCreditos;
	}

	/**
	 * @return statusCreditos
	 */
	public List<StatusCreditoOV> getStatusCreditos() {
		return statusCreditos;
	}


}
