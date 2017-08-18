package utilitario.mensajes.administracion.contrato;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class RevertirSaldoAFavorRespuesta.
 *
 * @author out_mreyes
 */
public 	class 	RevertirSaldoAFavorRespuesta
		extends ObjetoValor	{

	/**
	 * Instancia una nueva revertir saldo a favor respuesta.
	 */
	public RevertirSaldoAFavorRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2343449501266343398L;

	// Atributos de la clase  -------------------------------------------------------------------
	/** The encabezado respuesta. */
	private EncabezadoRespuesta 	encabezadoRespuesta;

	// Metodos de la clase  ---------------------------------------------------------------------
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
