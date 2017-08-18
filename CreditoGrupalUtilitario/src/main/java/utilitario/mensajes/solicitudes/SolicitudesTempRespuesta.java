package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SolicitudesTempRespuesta.
 */
public class SolicitudesTempRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva solicitudes temp respuesta.
	 */
	public SolicitudesTempRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8376487321086775604L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The solicitudes. */
	private List<SolicitudesTemp> solicitudes;

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
	public List<SolicitudesTemp> getSolicitudes() {
		return solicitudes;
	}

	/**
	 * Establece solicitudes.
	 *
	 * @param solicitudes a solicitudes
	 */
	public void setSolicitudes(List<SolicitudesTemp> solicitudes) {
		this.solicitudes = solicitudes;
	}

}
