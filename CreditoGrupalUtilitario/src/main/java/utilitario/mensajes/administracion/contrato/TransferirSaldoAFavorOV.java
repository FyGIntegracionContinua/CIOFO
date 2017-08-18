package utilitario.mensajes.administracion.contrato;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class TransferirSaldoAFavorOV.
 *
 * @author out_mreyes
 */
public 	class 		TransferirSaldoAFavorOV		extends 	ObjetoValor {

	/**
	 * Instancia una nueva transferir saldo a favor ov.
	 */
	public TransferirSaldoAFavorOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6579637497294480246L;

	// Atributos de la clase  -------------------------------------------------------------
	/** The contrato origen. */
	private java.lang.String		contratoOrigen;

	/** The contrato destino. */
	private java.lang.String		contratoDestino;

	/** The monto transferir. */
	private java.lang.Double		montoTransferir;

	// Gets y Sets  -----------------------------------------------------------------------
	/**
	 * Obtiene contrato origen.
	 *
	 * @return the contratoOrigen
	 */
	public java.lang.String getContratoOrigen() {
		return contratoOrigen;
	}

	/**
	 * Establece contrato origen.
	 *
	 * @param contratoOrigen the contratoOrigen to set
	 */
	public void setContratoOrigen(java.lang.String contratoOrigen) {
		this.contratoOrigen = contratoOrigen;
	}

	/**
	 * Obtiene contrato destino.
	 *
	 * @return the contratoDestino
	 */
	public java.lang.String getContratoDestino() {
		return contratoDestino;
	}

	/**
	 * Establece contrato destino.
	 *
	 * @param contratoDestino the contratoDestino to set
	 */
	public void setContratoDestino(java.lang.String contratoDestino) {
		this.contratoDestino = contratoDestino;
	}

	/**
	 * Establece monto transferir.
	 *
	 * @param montoTransferir a monto transferir
	 */
	public void setMontoTransferir(java.lang.Double montoTransferir) {
		this.montoTransferir = montoTransferir;
	}

	/**
	 * Obtiene monto transferir.
	 *
	 * @return monto transferir
	 */
	public java.lang.Double getMontoTransferir() {
		return montoTransferir;
	}

	/**
	 * @return the porcentaje
	 */
	}
