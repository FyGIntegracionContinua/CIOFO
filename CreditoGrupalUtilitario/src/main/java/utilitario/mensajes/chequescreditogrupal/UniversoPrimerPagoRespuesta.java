/**
 *
 */
package utilitario.mensajes.chequescreditogrupal;


import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class UniversoPrimerPagoRespuesta.
 *
 * @author out_ltorres
 */
public class UniversoPrimerPagoRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva universo primer pago respuesta.
	 */
	public UniversoPrimerPagoRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The cheques. */
	private List<ChequesPrimerPago> cheques;

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
	public List<ChequesPrimerPago> getCheques() {
		return cheques;
	}

	/**
	 * Establece cheques.
	 *
	 * @param cheques a cheques
	 */
	public void setCheques(List<ChequesPrimerPago> cheques) {
		this.cheques = cheques;
	}

}
