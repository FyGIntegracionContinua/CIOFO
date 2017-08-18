/**
 * 
 */
package utilitario.mensajes.operacion;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * metodo de respuesta del registro de operacion
 * @author rmontellano
 * @version 4.13
 */
public class RegistrOperacionesRespuesta extends ObjetoValor {
	/**
	 * id unico
	 */
	private static final long serialVersionUID = -492406247785594470L;

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
