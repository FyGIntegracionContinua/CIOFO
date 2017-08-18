package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class SolicitudesOV.
 *
 * @author rguadarramac
 * @version 1.0
 */
public class ValidarGuardarSolicitudRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva solicitudes obj.
	 */
	public ValidarGuardarSolicitudRespuesta() {
	}
	/** Se genero serial. */
	private static final long serialVersionUID = 9096745766154723290L;

	/** The header. */
	private EncabezadoRespuesta	header;


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


}
