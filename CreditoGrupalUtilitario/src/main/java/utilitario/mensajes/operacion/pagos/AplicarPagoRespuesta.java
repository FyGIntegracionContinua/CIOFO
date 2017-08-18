package utilitario.mensajes.operacion.pagos;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author out_mreyes
 *
 */
public 	class 		AplicarPagoRespuesta extends 	ObjetoValor {
	/**
	 * Id serializacion
	 */
	private static final long serialVersionUID = 42135514784309044L;

	// Atributos de la clase  -----------------------------------------------------------------
	/**
	 * header EncabezadoRespuesta
	 */
	private EncabezadoRespuesta header;
	/**
	 * idTransaccion Integer
	 */
	private Integer idTransaccion;

    /** The id promesaLiquidacion. */
    private boolean promesaLiquidacion;

	/**
	 * @return .
	 */
	public Integer getIdTransaccion() {
		return idTransaccion;
	}

	/**
	 * @param idTransaccion .
	 */
	public void setIdTransaccion(Integer idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	//Constructores  --------------------------------------------------------------------------
	/**
	 * AplicarPagoRespuesta
	 */
	public AplicarPagoRespuesta() {
		header = new EncabezadoRespuesta();
		}

	// Sets y Gets  ---------------------------------------------------------------------------
	/**
	 * @return the encabezadoRespuesta
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * @param header .
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * @return the promesaLiquidacion
	 */
	public boolean isPromesaLiquidacion() {
		return promesaLiquidacion;
	}

	/**
	 * @param promesaLiquidacion the promesaLiquidacion to set
	 */
	public void setPromesaLiquidacion(boolean promesaLiquidacion) {
		this.promesaLiquidacion = promesaLiquidacion;
	}

}
