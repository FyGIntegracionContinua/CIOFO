/**
 * ProcUniversoPrimerPagoRespuesta
 */
package utilitario.mensajes.chequescreditogrupal;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author out_ltorres
 *
 */
public class ProcUniversoPrimerPagoRespuesta extends ObjetoValor {

	/**
	 * serial.
	 */
	private static final long serialVersionUID = 6945809692049261977L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The Cheques. */
	private List<ChequesOV> cheques;

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
	 * Obtiene cheques.
	 *
	 * @return cheques
	 */
	public List<ChequesOV> getCheques() {
		return cheques;
	}

	/**
	 * Establece cheques.
	 *
	 * @param cheques a cheques
	 */
	public void setCheques(List<ChequesOV> cheques) {
		this.cheques = cheques;
	}

}
