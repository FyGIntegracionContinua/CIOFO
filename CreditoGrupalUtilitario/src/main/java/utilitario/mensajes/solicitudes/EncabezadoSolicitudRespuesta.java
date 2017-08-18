package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class EncabezadoSolicitudRespuesta.
 *
 * @author rguadarramac
 */
public class EncabezadoSolicitudRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva encabezado solicitud respuesta.
	 */
	public EncabezadoSolicitudRespuesta() {
	}
	/** Se genero nuevo serial. */
	private static final long serialVersionUID = 5877981102198513561L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The solicitud encabezado. */
	private SolicitudBuroOV solicitudEncabezado;

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
	 * Establece solicitud encabezado.
	 *
	 * @param solicitudEncabezado a solicitud encabezado
	 */
	public void setSolicitudEncabezado(SolicitudBuroOV solicitudEncabezado) {
		this.solicitudEncabezado = solicitudEncabezado;
	}

	/**
	 * Obtiene solicitud encabezado.
	 *
	 * @return solicitud encabezado
	 */
	public SolicitudBuroOV getSolicitudEncabezado() {
		return solicitudEncabezado;
	}


}
