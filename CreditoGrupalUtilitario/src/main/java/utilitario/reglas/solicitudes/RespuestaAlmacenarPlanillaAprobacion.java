package utilitario.reglas.solicitudes;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

public class RespuestaAlmacenarPlanillaAprobacion  extends ObjetoValor {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -4182335161996149066L;

	/**
	 * Instantiates a new respuesta regla incremento.
	 */
	public RespuestaAlmacenarPlanillaAprobacion() {
	}

	/**
	 * EncabezadoRespuesta header
	 */
	private EncabezadoRespuesta header;

	/**
	 * Gets the header.
	 *
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}
	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

}
