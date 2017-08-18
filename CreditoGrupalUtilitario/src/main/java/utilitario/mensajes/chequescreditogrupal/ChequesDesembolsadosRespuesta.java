/**
 *
 */
package utilitario.mensajes.chequescreditogrupal;


import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ChequesDesembolsadosRespuesta.
 *
 * @author out_gcorzo
 */
public class ChequesDesembolsadosRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva cheques desembolsados respuesta.
	 */
	public ChequesDesembolsadosRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The cheques. */
	private List<ChequesDesembolsados> cheques;

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
	public List<ChequesDesembolsados> getCheques() {
		return cheques;
	}

	/**
	 * Establece cheques.
	 *
	 * @param cheques a cheques
	 */
	public void setCheques(List<ChequesDesembolsados> cheques) {
		this.cheques = cheques;
	}

}
