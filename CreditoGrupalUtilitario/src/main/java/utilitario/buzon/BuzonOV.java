package utilitario.buzon;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class BuzonOV.
 * @author rguadarramac
 */
public class BuzonOV extends ObjetoValor {

	/**
	 * BuzonOV.
	 */
	public BuzonOV() {

	}

	/** Serial. */
	private static final long serialVersionUID = -7058974314966720834L;

	/** List<TareaOV> buzon. */
	private List<TareaOV> buzon;

	/**
	 * EncabezadoRespuesta BuzonOV.java
	 */
	private EncabezadoRespuesta header;

	/**
	 * Obtiene buzon.
	 *
	 * @return the buzon
	 */
	public List<TareaOV> getBuzon() {
		return buzon;
	}

	/**
	 * Establece buzon.
	 *
	 * @param buzon the buzon to set
	 */
	public void setBuzon(List<TareaOV> buzon) {
		this.buzon = buzon;
	}

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
