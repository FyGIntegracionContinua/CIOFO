package utilitario.mensajes.reportes.comun;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ReportesContablesRespuesta.
 */
public class ReportesContablesRespuesta extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -792657573700093538L;

	/** EncabezadoRespuesta header. */
	private EncabezadoRespuesta header;
	/**
	 * java.util.List<java.lang.String> cadena
	 */
	private java.util.List<java.lang.String> cadena;

	/**
	 * ReportesContablesRespuesta.
	 */
	public ReportesContablesRespuesta() {
		header = new EncabezadoRespuesta();
		}

	/**
	 * Establece header.
	 *
	 * @param header setHeader :
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene header.
	 *
	 * @return getHeader :
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece cadena.
	 *
	 * @param cadena setCadena :
	 */
	public void setCadena(java.util.List<java.lang.String> cadena) {
		this.cadena = cadena;
	}

	/**
	 * Obtiene cadena.
	 *
	 * @return getCadena :
	 */
	public java.util.List<java.lang.String> getCadena() {
		return cadena;
	}
}
