/**
 *
 */
package utilitario.mensajes.chequescreditogrupal;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class FoliosRespuesta.
 *
 * @author out_ltorres
 */
public class FoliosRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva folios respuesta.
	 */
	public FoliosRespuesta() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The folios. */
	private List<ChequesFolio> folios;

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
	public List<ChequesFolio> getFolios() {
		return folios;
	}

	/**
	 * Establece folios.
	 *
	 * @param folios a folios
	 */
	public void setFolios(List<ChequesFolio> folios) {
		this.folios = folios;
	}

}
