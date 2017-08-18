/**
 *
 */
package utilitario.mensajes.consultas;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ca.ocampo
 *
 */
public class ReferenciasRespuesta extends ObjetoValor {

	/** Serial. */
	private static final long serialVersionUID = 2819876647163502798L;

	/**
	 * EncabezadoRespuesta ReporteBuroExternoRespuesta.java
	 */
	private EncabezadoRespuesta header;

	/** List<Referencias> referencias. */
	private List<Referencias> referencias;

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
	 * @return the referencias
	 */
	public List<Referencias> getReferencias() {
		return referencias;
	}

	/**
	 * @param referencias the referencias to set
	 */
	public void setReferencias(List<Referencias> referencias) {
		this.referencias = referencias;
	}

}
