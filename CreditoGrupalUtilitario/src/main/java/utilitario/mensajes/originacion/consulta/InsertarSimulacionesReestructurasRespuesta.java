package utilitario.mensajes.originacion.consulta;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ReasignarCargaTrabajoRespuesta.
 *
 * @author rguadarramac
 */
public class InsertarSimulacionesReestructurasRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva reasignar carga trabajo respuesta.
	 */
	public InsertarSimulacionesReestructurasRespuesta() {
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
