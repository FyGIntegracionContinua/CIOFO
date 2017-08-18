/**
 *
 */
package utilitario.mensajes.chequescreditogrupal;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ChequesDesembolsadosPeticion.
 *
 * @author out_gcorzo
 */
public class ChequesDesembolsadosPeticion  extends ObjetoValor {

	/**
	 * Instancia una nueva cheques desembolsados peticion.
	 */
	public ChequesDesembolsadosPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1863518522458278164L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The fecha inicial. */
	private String fechaInicial;

	/** The fecha Final. */
	private String fechaFinal;

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
	 * Obtiene fechaInicial.
	 *
	 * @return fechaInicial
	 */
	public String getFechaInicial() {
		return fechaInicial;
	}

	/**
	 * Establece fechaInicial.
	 *
	 * @param fechaInicial a fechaInicial
	 */
	public void setFechaInicial(String fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	/**
	 * Obtiene fechaFinal.
	 *
	 * @return fechaFinal
	 */
	public String getFechaFinal() {
		return fechaFinal;
	}

	/**
	 * Establece fechaFinal.
	 *
	 * @param fechaFinal a fechaFinal
	 */
	public void setFechaFinal(String fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
}
