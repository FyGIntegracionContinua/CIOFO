package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ObtenerDatosSolicitudRespuesta.
 */
public class EnviarSolicitudCecRespuesta extends ObjetoValor {

	/** serial. */
	private static final long serialVersionUID = 2481624307041105116L;

	/** The header. */
	private EncabezadoRespuesta header;

	/**
	 * Gets the header.
	 *
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Sets the header.
	 *
	 * @param header the new header
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}


}
