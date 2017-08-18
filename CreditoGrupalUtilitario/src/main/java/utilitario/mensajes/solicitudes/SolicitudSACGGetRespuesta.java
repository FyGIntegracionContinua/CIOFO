package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SolicitudSACGGetRespuesta.
 */
public class SolicitudSACGGetRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva solicitud sacg get respuesta.
	 */
	public SolicitudSACGGetRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3070281355469388664L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The solicitudes. */
	private List<SolicitudSACGGet> solicitudes;

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
	public List<SolicitudSACGGet> getSolicitudes() {
		return solicitudes;
	}

	/**
	 * Establece solicitudes.
	 *
	 * @param solicitudes a solicitudes
	 */
	public void setSolicitudes(List<SolicitudSACGGet> solicitudes) {
		this.solicitudes = solicitudes;
	}

}
