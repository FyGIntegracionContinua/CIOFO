/**
 *
 */
package utilitario.mensajes.chequescreditogrupal;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class FoliosImpRespuesta.
 *
 * @author out_ltorres
 */
public class FoliosImpRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva folios imp respuesta.
	 */
	public FoliosImpRespuesta() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6607266283394012703L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The folios. */
	private List<FolioImp> folios;

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
	 * Obtiene folios.
	 *
	 * @return folios
	 */
	public List<FolioImp> getFolios() {
		return folios;
	}

	/**
	 * Establece folios.
	 *
	 * @param folios a folios
	 */
	public void setFolios(List<FolioImp> folios) {
		this.folios = folios;
	}


}
