package utilitario.buzon;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author rguadarramac
 *
 */
public class AsignaTareaPropietarioRespuesta extends ObjetoValor {

	/**
	 * AsignaTareaPropietarioRespuesta
	 */
	public AsignaTareaPropietarioRespuesta() {

	}
	/**
	 * long AsignaTareaPropietarioRespuesta.java
	 */
	private static final long serialVersionUID = -2448093340483531260L;
	/**
	 * EncabezadoRespuesta AsignaTareaPropietarioRespuesta.java
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
