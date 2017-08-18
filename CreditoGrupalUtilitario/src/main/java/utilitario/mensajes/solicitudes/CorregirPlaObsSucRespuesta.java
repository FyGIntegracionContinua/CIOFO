package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class CorregirPlaObsSucRespuesta.
 *
 * @author rguadarramac
 */
public class CorregirPlaObsSucRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva corregir pla obs suc respuesta.
	 */
	public CorregirPlaObsSucRespuesta() {
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
