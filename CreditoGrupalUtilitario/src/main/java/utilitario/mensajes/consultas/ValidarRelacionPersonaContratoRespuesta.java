package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

public class ValidarRelacionPersonaContratoRespuesta extends ObjetoValor {


	/**
	 * Instancia una nueva validar relacion persona contrato respuesta.
	 */
	public ValidarRelacionPersonaContratoRespuesta() {
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2420073756128515569L;

	/** The header. */
	private EncabezadoRespuesta header;

	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

}
