package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultarReasignacionesRespuesta.
 *
 * @author out_mreyes
 */
public 	class 	ConsultarReasignacionesRespuesta
		extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2362237146458086954L;

	// Atributos privados  ------------------------------------------------------------------
	/** The header. */
	private EncabezadoRespuesta				header;

	/** The resultado. */
	private java.util.List<ReasignacionOV>	resultado;

	// Constructor --------------------------------------------------------------------------
	/**
	 * Instancia una nueva consultar reasignaciones respuesta.
	 */
	public ConsultarReasignacionesRespuesta() {
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
	public java.util.List<ReasignacionOV> getResultado() {
		return resultado;
	}

	/**
	 * Establece resultado.
	 *
	 * @param resultado the resultado to set
	 */
	public void setResultado(java.util.List<ReasignacionOV> resultado) {
		this.resultado = resultado;
	}

}
