package utilitario.mensajes.chequescreditogrupal;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ChequesRegeneraFolioPeticion.
 *
 * @author out_ltorres
 */
public class ChequesRegeneraFolioPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva cheques regenera folio peticion.
	 */
	public ChequesRegeneraFolioPeticion() {

	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7626887119747769166L;

	/** The header. */
	private EncabezadoPeticion	header;

	/** The folio anterior. */
	private Long folioAnterior;

	/** The folio nuevo. */
	private Long folioNuevo;

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}

	/**
	 * Obtiene folio anterior.
	 *
	 * @return folio anterior
	 */
	public Long getFolioAnterior() {
		return folioAnterior;
	}

	/**
	 * Establece folio anterior.
	 *
	 * @param folioAnterior a folio anterior
	 */
	public void setFolioAnterior(Long folioAnterior) {
		this.folioAnterior = folioAnterior;
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
