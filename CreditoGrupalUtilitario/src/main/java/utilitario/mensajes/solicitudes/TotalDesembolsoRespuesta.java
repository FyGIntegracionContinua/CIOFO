package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class CodigosRespuesta.
 * @author out_gcorzo
 */
public class TotalDesembolsoRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva codigos respuesta.
	 */
	public TotalDesembolsoRespuesta() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6035371579190210677L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The totalDesembolso. */
	private TotalDesembolsoOV totalDesembolso;

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
	 * @return the totalDesembolso
	 */
	public TotalDesembolsoOV getTotalDesembolso() {
		return totalDesembolso;
	}

	/**
	 * @param totalDesembolso the totalDesembolso to set
	 */
	public void setTotalDesembolso(TotalDesembolsoOV totalDesembolso) {
		this.totalDesembolso = totalDesembolso;
	}
}
