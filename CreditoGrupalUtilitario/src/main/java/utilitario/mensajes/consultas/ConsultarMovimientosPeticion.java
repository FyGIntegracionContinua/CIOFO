package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultarMovimientosPeticion.
 *
 * @author out_mreyes
 */
public 	class 	ConsultarMovimientosPeticion
		extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2362237146458086954L;

	// Atributos privados  ------------------------------------------------------------------
	/** The contrato. */
	private java.lang.String		contrato;

	/** The tipo moviemiento. */
	private java.lang.String		tipoMoviemiento;

	// Constructor --------------------------------------------------------------------------
	/**
	 * Instancia una nueva consultar movimientos peticion.
	 */
	public ConsultarMovimientosPeticion() {
		}

	// Funciones get y set  -----------------------------------------------------------------
	/**
	 * Obtiene contrato.
	 *
	 * @return the contrato
	 */
	public java.lang.String getContrato() {
		return contrato;
	}

	/**
	 * Establece contrato.
	 *
	 * @param contrato the contrato to set
	 */
	public void setContrato(java.lang.String contrato) {
		this.contrato = contrato;
	}

	/**
	 * Obtiene tipo moviemiento.
	 *
	 * @return the tipoMoviemiento
	 */
	public java.lang.String getTipoMoviemiento() {
		return tipoMoviemiento;
	}

	/**
	 * Establece tipo moviemiento.
	 *
	 * @param tipoMoviemiento the tipoMoviemiento to set
	 */
	public void setTipoMoviemiento(java.lang.String tipoMoviemiento) {
		this.tipoMoviemiento = tipoMoviemiento;
	}

}
