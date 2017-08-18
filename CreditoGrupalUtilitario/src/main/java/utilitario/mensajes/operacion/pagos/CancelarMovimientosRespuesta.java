/**
 *
 */
package utilitario.mensajes.operacion.pagos;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class CancelarMovimientosRespuesta.
 *
 * @author out_mreyes
 */
public 	class 		CancelarMovimientosRespuesta extends 	ObjetoValor {

	/** Id serializacion. */
	private static final long serialVersionUID = 42135514784309044L;

	// Atributos de la clase  -----------------------------------------------------------------
	/** The header. */
	private EncabezadoRespuesta header;

	//Constructores  --------------------------------------------------------------------------
	/**
	 * Instancia una nueva cancelar movimientos respuesta.
	 */
	public CancelarMovimientosRespuesta() {
		header = new EncabezadoRespuesta();
		}

	// Sets y Gets  ---------------------------------------------------------------------------
	/**
	 * Obtiene header respuesta.
	 *
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
