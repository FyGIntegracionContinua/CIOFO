package utilitario.mensajes.operacion.pagos;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

public class AlmacenarArchivoOxxoRespuesta extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -9109521992046166216L;
	/**
	 * header EncabezadoRespuesta
	 */
	private EncabezadoRespuesta header;
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
