/**
 *
 */
package utilitario.mensajes.chequescreditogrupal;


import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class ChequesRegeneraFolioRespuesta.
 *
 * @author out_ltorres
 */
public class ChequesRegeneraFolioRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva cheques regenera folio respuesta.
	 */
	public ChequesRegeneraFolioRespuesta() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The folio nuevo. */
	private Long folioNuevo;

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
	 * Obtiene folio nuevo.
	 *
	 * @return folio nuevo
	 */
	public Long getFolioNuevo() {
		return folioNuevo;
	}

	/**
	 * Establece folio nuevo.
	 *
	 * @param folioNuevo a folio nuevo
	 */
	public void setFolioNuevo(Long folioNuevo) {
		this.folioNuevo = folioNuevo;
	}

}
