package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultarReasignacionesMultiplesRespuesta.
 *
 * @author out_mreyes
 */
public 	class 	ConsultarReasignacionesMultiplesRespuesta
		extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2362237146458086954L;

	// Atributos privados  ------------------------------------------------------------------
	/** The header. */
	private EncabezadoRespuesta						header;

	/** The resultado. */
	private java.util.List<ReasignacionMultipleOV>	resultado;

	// Constructor --------------------------------------------------------------------------
	/**
	 * Instancia una nueva consultar reasignaciones multiples respuesta.
	 */
	public ConsultarReasignacionesMultiplesRespuesta() {
		header = new EncabezadoRespuesta();
		}

	// Funciones get y set  -----------------------------------------------------------------

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

	/**
	 * Obtiene resultado.
	 *
	 * @return the resultado
	 */
	public java.util.List<ReasignacionMultipleOV> getResultado() {
		return resultado;
	}

	/**
	 * Establece resultado.
	 *
	 * @param resultado the resultado to set
	 */
	public void setResultado(java.util.List<ReasignacionMultipleOV> resultado) {
		this.resultado = resultado;
	}

}
