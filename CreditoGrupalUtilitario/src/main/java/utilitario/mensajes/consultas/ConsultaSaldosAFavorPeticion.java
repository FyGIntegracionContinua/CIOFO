package utilitario.mensajes.consultas;

import java.io.Serializable;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaSaldosAFavorPeticion.
 *
 * @author out_mreyes
 */
public 	class 		ConsultaSaldosAFavorPeticion
		extends 	ObjetoValor
		implements	Serializable {

	/**
	 * Instancia una nueva consulta saldos a favor peticion.
	 */
	public ConsultaSaldosAFavorPeticion() {
	}
	/** 	Serializacion del objeto. */
	private static final long serialVersionUID = 2666652325730606937L;

	// Atributos de la clase  -------------------------------------------------------------------
	/** The sucursal. */
	private java.lang.Integer sucursal;

	/** The contrato. */
	private java.lang.String contrato;

	// Sets y Gets  -----------------------------------------------------------------------------
	/**
	 * Obtiene sucursal.
	 *
	 * @return the sucursal
	 */
	public java.lang.Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(java.lang.Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Establece contrato.
	 *
	 * @param contrato a contrato
	 */
	public void setContrato(java.lang.String contrato) {
		this.contrato = contrato;
	}

	/**
	 * Obtiene contrato.
	 *
	 * @return contrato
	 */
	public java.lang.String getContrato() {
		return contrato;
	}

}
