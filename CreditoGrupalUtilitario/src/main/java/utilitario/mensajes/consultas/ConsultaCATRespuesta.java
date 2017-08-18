package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaCATRespuesta.
 *
 * @author out_mreyes
 */
public 	class 	ConsultaCATRespuesta
		extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5495377830189076480L;

	// Atributos privados  ------------------------------------------------------------------
	/** The header. */
	private EncabezadoRespuesta 	header;

	/** The cat. */
	private java.lang.Double		CAT;

	// Constructor --------------------------------------------------------------------------
	/**
	 * Instancia una nueva consulta cat respuesta.
	 */
	public ConsultaCATRespuesta() {
		header = new EncabezadoRespuesta();
		}

	// Funciones get y set  -----------------------------------------------------------------
	/**
	 * Obtiene cat.
	 *
	 * @return the cAT
	 */
	public java.lang.Double getCAT() {
		return CAT;
	}

	/**
	 * Establece cat.
	 *
	 * @param cAT the cAT to set
	 */
	public void setCAT(java.lang.Double cAT) {
		CAT = cAT;
	}

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
