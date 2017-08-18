package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;
import utilitario.mensajes.originacion.contrato.ContratoOV;

/**
 * The Class ObtenerDatosSolicitudRespuesta.
 */
public class ObtenerDatosSolicitudRespuesta extends ObjetoValor {

	/** serial. */
	private static final long serialVersionUID = 2481624307041105116L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The usuario. */
	private ContratoOV contratoOV;

	/**
	 * Gets the header.
	 *
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Sets the header.
	 *
	 * @param header the new header
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Gets the contrato ov.
	 *
	 * @return the contrato ov
	 */
	public ContratoOV getContratoOV() {
		return contratoOV;
	}

	/**
	 * Sets the contrato ov.
	 *
	 * @param contratoOV the new contrato ov
	 */
	public void setContratoOV(ContratoOV contratoOV) {
		this.contratoOV = contratoOV;
	}


}
