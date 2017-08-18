package utilitario.mensajes.verificacion.telefonica;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author rguadarramac
 *
 */
public class RespuestainformacionVerificacion extends ObjetoValor {

	/**
	 * RespuestainformacionVerificacion
	 */
	public RespuestainformacionVerificacion() {

	}
	/**
	 *
	 */
	private static final long serialVersionUID = 5317186900756458360L;
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
