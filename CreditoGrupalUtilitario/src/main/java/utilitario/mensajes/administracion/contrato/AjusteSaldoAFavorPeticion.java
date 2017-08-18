package utilitario.mensajes.administracion.contrato;

import java.io.Serializable;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AjusteSaldoAFavorPeticion.
 *
 * @author out_mreyes
 */
public 	class 		AjusteSaldoAFavorPeticion
		extends 	ObjetoValor
		implements	Serializable {

	/**
	 * Instancia una nueva ajuste saldo a favor peticion.
	 */
	public AjusteSaldoAFavorPeticion() {
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6965653121347729140L;

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
