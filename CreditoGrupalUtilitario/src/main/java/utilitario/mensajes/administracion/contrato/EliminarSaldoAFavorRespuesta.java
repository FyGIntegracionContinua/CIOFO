package utilitario.mensajes.administracion.contrato;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class EliminarSaldoAFavorRespuesta.
 *
 * @author out_mreyes
 */
public 	class 	EliminarSaldoAFavorRespuesta
		extends	ObjetoValor	{

	/**
	 * Instancia una nueva eliminar saldo a favor respuesta.
	 */
	public EliminarSaldoAFavorRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3863944726121819273L;

	// Atributos de la clase  ----------------------------------------------------------
	/** The encabezado respuesta. */
	private EncabezadoRespuesta 	encabezadoRespuesta;

	/** The eliminar saldo a favor ov. */
	private EliminarSaldoAFavorOV	eliminarSaldoAFavorOV;

	// Metodos   -----------------------------------------------------------------------
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

	/**
	 * Obtiene eliminar saldo a favor ov.
	 *
	 * @return the eliminarSaldoAFavorOV
	 */
	public EliminarSaldoAFavorOV getEliminarSaldoAFavorOV() {
		return eliminarSaldoAFavorOV;
	}

	/**
	 * Establece eliminar saldo a favor ov.
	 *
	 * @param eliminarSaldoAFavorOV the eliminarSaldoAFavorOV to set
	 */
	public void setEliminarSaldoAFavorOV(EliminarSaldoAFavorOV eliminarSaldoAFavorOV) {
		this.eliminarSaldoAFavorOV = eliminarSaldoAFavorOV;
	}

}
