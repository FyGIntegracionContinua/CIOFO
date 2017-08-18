/**
 *
 */
package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ca.ocampo
 *
 */
public class ReactivarSolicitudesRespuesta  extends ObjetoValor {

	/**
	 * Instantiates a new validar solicitud peticion.
	 */
	public ReactivarSolicitudesRespuesta() {
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3207194015158023183L;

	/** The header. */
	private EncabezadoRespuesta header;

	/**The ReactivarSolicitudes */
	List<ReactivarSolicitudes> reactivarSolicitudes;

	/**
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * @return the reactivarSolicitudes
	 */
	public List<ReactivarSolicitudes> getReactivarSolicitudes() {
		return reactivarSolicitudes;
	}

	/**
	 * @param reactivarSolicitudes the reactivarSolicitudes to set
	 */
	public void setReactivarSolicitudes(
			List<ReactivarSolicitudes> reactivarSolicitudes) {
		this.reactivarSolicitudes = reactivarSolicitudes;
	}


}
