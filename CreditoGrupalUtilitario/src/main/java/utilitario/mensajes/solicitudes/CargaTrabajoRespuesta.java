package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class CargaTrabajoRespuesta.
 *
 * @author rguadarramac
 *
 */
public class CargaTrabajoRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva carga trabajo respuesta.
	 */
	public CargaTrabajoRespuesta() {
	}
	/** Se genero nuevo serial. */
	private static final long serialVersionUID = 4771230139176220692L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The carga trabajo. */
	private List<CargaTrabajoOV> cargaTrabajo;

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

	/**
	 * Establece carga trabajo.
	 *
	 * @param cargaTrabajo a carga trabajo
	 */
	public void setCargaTrabajo(List<CargaTrabajoOV> cargaTrabajo) {
		this.cargaTrabajo = cargaTrabajo;
	}

	/**
	 * Obtiene carga trabajo.
	 *
	 * @return carga trabajo
	 */
	public List<CargaTrabajoOV> getCargaTrabajo() {
		return cargaTrabajo;
	}

}
