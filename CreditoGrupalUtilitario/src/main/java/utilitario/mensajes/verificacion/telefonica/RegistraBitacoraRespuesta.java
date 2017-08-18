package utilitario.mensajes.verificacion.telefonica;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author rguadarramac
 *
 */
public class RegistraBitacoraRespuesta extends ObjetoValor {

	/**
	 * RegistraBitacoraRespuesta
	 */
	public RegistraBitacoraRespuesta() {

	}
	/**
	 *
	 */
	private static final long serialVersionUID = 7157146346472731937L;
	/**
	 * EncabezadoRespuesta header
	 */
	private EncabezadoRespuesta header;
	/**
	 * @return getHeader :
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}
	/**
	 * @param header setHeader :
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

}
