package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ReasignarCargaTrabajoRespuesta.
 *
 * @author rguadarramac
 */
public class ReasignarCargaTrabajoRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva reasignar carga trabajo respuesta.
	 */
	public ReasignarCargaTrabajoRespuesta() {
	}
	/** Se genero nuevo serial. */
	private static final long serialVersionUID = 4771230139176220692L;

	/** The header. */
	private EncabezadoRespuesta header;

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

}
