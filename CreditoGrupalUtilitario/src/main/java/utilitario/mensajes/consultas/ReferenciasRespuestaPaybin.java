/**
 *
 */
package utilitario.mensajes.consultas;


import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ca.ocampo
 *
 */
public class ReferenciasRespuestaPaybin  extends ObjetoValor {

	/**
	 * Serial.
	 */
	private static final long serialVersionUID = 5842814692374577587L;

	/**
	 * EncabezadoRespuesta ReporteBuroExternoRespuesta.java
	 */
	private EncabezadoRespuesta header;

	/**
	 * String referencia
	 */
	private String referencia;

	/**
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

	/**
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}

	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

}
