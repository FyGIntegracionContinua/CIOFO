package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AtomosRespuesta.
 */
public class AtomosRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva atomos respuesta.
	 */
	public AtomosRespuesta() {
	}
	/** Se genero clave unica. */
	private static final long serialVersionUID = 1899755542464445978L;

	/** The header. */
	private EncabezadoRespuesta header;
	/** The idAtomo. */
	private int idAtomo;
	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * @return the idAtomo
	 */
	public int getIdAtomo() {
		return idAtomo;
	}

	/**
	 * @param idAtomo the idAtomo to set
	 */
	public void setIdAtomo(int idAtomo) {
		this.idAtomo = idAtomo;
	}

}
