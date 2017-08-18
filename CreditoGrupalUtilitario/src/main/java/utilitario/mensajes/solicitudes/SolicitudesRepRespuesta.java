package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SolicitudesRepRespuesta.
 */
public class SolicitudesRepRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva solicitudes rep respuesta.
	 */
	public SolicitudesRepRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 846509631467295401L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The solicitudes. */
	List <SolicitudesRep> solicitudes;

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
	 * Obtiene solicitudes.
	 *
	 * @return solicitudes
	 */
	public List<SolicitudesRep> getSolicitudes() {
		return solicitudes;
	}

	/**
	 * Establece solicitudes.
	 *
	 * @param solicitudes a solicitudes
	 */
	public void setSolicitudes(List<SolicitudesRep> solicitudes) {
		this.solicitudes = solicitudes;
	}

}
