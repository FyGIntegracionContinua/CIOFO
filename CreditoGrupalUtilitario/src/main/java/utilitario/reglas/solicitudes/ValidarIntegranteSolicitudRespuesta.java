package utilitario.reglas.solicitudes;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

public class ValidarIntegranteSolicitudRespuesta extends ObjetoValor {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -8685525283854685098L;
	/** The header. */
	private EncabezadoRespuesta			header;
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
