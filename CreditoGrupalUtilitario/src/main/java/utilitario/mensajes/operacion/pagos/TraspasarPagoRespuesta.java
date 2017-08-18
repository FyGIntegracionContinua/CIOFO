/**
 *
 */
package utilitario.mensajes.operacion.pagos;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author out_mreyes
 *
 */
public 	class 		TraspasarPagoRespuesta extends 	ObjetoValor {
	/**
	 * Id serializacion
	 */
	private static final long serialVersionUID = 42135514784309044L;

	// Atributos de la clase  -----------------------------------------------------------------
	/** The header. */
	private EncabezadoRespuesta header;

	//Constructores  --------------------------------------------------------------------------
	/**
	 * Instancia una nueva traspasar pago respuesta.
	 */
	public TraspasarPagoRespuesta() {
		header = new EncabezadoRespuesta();
		}

	// Sets y Gets  ---------------------------------------------------------------------------
	/**
	 * @return the encabezadoRespuesta
	 */
	public EncabezadoRespuesta getHeaderRespuesta() {
		return header;
	}

	/**
	 * Establece header respuesta.
	 *
	 * @param header a header respuesta
	 */
	public void setHeaderRespuesta(EncabezadoRespuesta header) {
		this.header = header;
	}

}
