package utilitario.mensajes.operacion;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

public class CargaInformacionRespuesta extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 40900563085981932L;
	/** The header. */
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
