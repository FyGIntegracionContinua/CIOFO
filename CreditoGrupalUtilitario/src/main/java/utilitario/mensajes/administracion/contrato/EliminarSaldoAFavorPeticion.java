package utilitario.mensajes.administracion.contrato;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class EliminarSaldoAFavorPeticion.
 *
 * @author out_mreyes
 */
public 	class 	EliminarSaldoAFavorPeticion	extends ObjetoValor {

	/**
	 * Instancia una nueva eliminar saldo a favor peticion.
	 */
	public EliminarSaldoAFavorPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4423002206273081740L;

	// Atributos privados  ----------------------------------------------------------------
	/** The contrato. */
	private java.lang.String 	contrato;

	// Metodos publicos  ------------------------------------------------------------------
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

}
