package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultarAtomosRespuesta.
 *
 * @author rguadarramac
 *
 */
public class ConsultarAtomosRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva consultar atomos respuesta.
	 */
	public ConsultarAtomosRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6451899559144662886L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The atomos. */
	private List<AtomosOV> atomos;

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
	 * Establece atomos.
	 *
	 * @param atomos a atomos
	 */
	public void setAtomos(List<AtomosOV> atomos) {
		this.atomos = atomos;
	}

	/**
	 * Obtiene atomos.
	 *
	 * @return atomos
	 */
	public List<AtomosOV> getAtomos() {
		return atomos;
	}

}
