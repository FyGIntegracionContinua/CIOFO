package utilitario.mensajes.administracion.contrato;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ActualizarSolicitudReasignarCarteraRespuesta.
 *
 * @author out_mreyes
 */
public 	class 	ActualizarSolicitudReasignarCarteraRespuesta
		extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 303989254178347105L;

	//Atributos de la clase  -----------------------------------------------------------------------------
	/** The header. */
	private EncabezadoRespuesta 	header;

	//Constructor  ---------------------------------------------------------------------------------------
	/**
	 * Instancia una nueva actualizar solicitud reasignar cartera respuesta.
	 */
	public ActualizarSolicitudReasignarCarteraRespuesta() {
		header = new EncabezadoRespuesta();
		}

	//GET - SET  ---------------------------------------------------------------------
	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

}
