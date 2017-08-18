/**
 *
 */
package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultarPersonaRespuesta.
 *
 * @author rguadarrama
 */
public 	class 	ValidarSaldoIntegranteRespuesta extends ObjetoValor {


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5677000937229085332L;

	/**
	 * Instancia una nueva consultar persona respuesta.
	 */
	public ValidarSaldoIntegranteRespuesta() {
		header = new EncabezadoRespuesta();
		}

	/** The header. */
	private EncabezadoRespuesta			header;


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
