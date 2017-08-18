package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultarMovimientosRespuesta.
 */
public 	class 	ConsultarMovimientosRespuesta
		extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 213261886525776918L;

	/** The header. */
	private EncabezadoRespuesta 				header;

	/** The movimientos. */
	private java.util.ArrayList<MovimientoOV>	movimientos;

	//Constructor  ------------------------------------------------------------------------------
	/**
	 * Instancia una nueva consultar movimientos respuesta.
	 */
	public ConsultarMovimientosRespuesta() {
		header = new EncabezadoRespuesta();
		}

	//Get and Set  ------------------------------------------------------------------------------
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
	 * Obtiene movimientos.
	 *
	 * @return the movimientos
	 */
	public java.util.ArrayList<MovimientoOV> getMovimientos() {
		return movimientos;
	}

	/**
	 * Establece movimientos.
	 *
	 * @param movimientos the movimientos to set
	 */
	public void setMovimientos(java.util.ArrayList<MovimientoOV> movimientos) {
		this.movimientos = movimientos;
	}
}
