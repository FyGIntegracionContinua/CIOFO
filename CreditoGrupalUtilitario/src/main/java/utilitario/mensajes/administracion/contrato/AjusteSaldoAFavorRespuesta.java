package utilitario.mensajes.administracion.contrato;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AjusteSaldoAFavorRespuesta.
 *
 * @author out_mreyes
 */
public 	class 		AjusteSaldoAFavorRespuesta
		extends 	ObjetoValor {

	/**
	 * Instancia una nueva ajuste saldo a favor respuesta.
	 */
	public AjusteSaldoAFavorRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 42135514784309044L;

	// Atributos de la clase  -----------------------------------------------------------------
	/** The encabezado respuesta. */
	private EncabezadoRespuesta encabezadoRespuesta;

	/** The id transaccion. */
	private Integer idTransaccion;


	/**
	 * Obtiene id transaccion.
	 *
	 * @return id transaccion
	 */
	public Integer getIdTransaccion() {
		return idTransaccion;
	}

	/**
	 * Establece id transaccion.
	 *
	 * @param idTransaccion a id transaccion
	 */
	public void setIdTransaccion(Integer idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	// Sets y Gets  ---------------------------------------------------------------------------
	/**
	 * Obtiene encabezado respuesta.
	 *
	 * @return the encabezadoRespuesta
	 */
	public EncabezadoRespuesta getEncabezadoRespuesta() {
		return encabezadoRespuesta;
	}

	/**
	 * Establece encabezado respuesta.
	 *
	 * @param encabezadoRespuesta the encabezadoRespuesta to set
	 */
	public void setEncabezadoRespuesta(EncabezadoRespuesta encabezadoRespuesta) {
		this.encabezadoRespuesta = encabezadoRespuesta;
	}

}
