package utilitario.mensajes.correo;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author equipo desarrollo
 *
 */
public class EnviarCorreoRespuesta extends ObjetoValor {


	/**
	 * long serialVersionUID
	 */
	private static final long serialVersionUID = 6927813521528602444L;
	/**
	 * EncabezadoRespuesta header
	 */
	private EncabezadoRespuesta header;


	/**
	 * EnviarCorreoRespuesta
	 */
	public EnviarCorreoRespuesta() {

	}

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
