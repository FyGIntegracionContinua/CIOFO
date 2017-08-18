package utilitario.mensajes.consultas;

import java.io.Serializable;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class ClientesHistorico.
 */
public class ClientesHistorico extends ObjetoValor implements Serializable {

	/**
	 * Instancia una nueva clientes historico.
	 */
	public ClientesHistorico() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4527898769388671775L;

	/** The ciclo. */
	private java.lang.String	ciclo;

	/** The contrato. */
	private java.lang.String	contrato;
	
	/** numero contrato. */
	private java.lang.String numContrato;

	/** The monto prestamo grupal. */
	private java.lang.Double	montoPrestamoGrupal;

	/**
	 * Establece ciclo.
	 *
	 * @param ciclo a ciclo
	 */
	public void setCiclo(java.lang.String ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * Obtiene ciclo.
	 *
	 * @return ciclo
	 */
	public java.lang.String getCiclo() {
		return ciclo;
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

	/**
	 * Establece monto prestamo grupal.
	 *
	 * @param montoPrestamoGrupal a monto prestamo grupal
	 */
	public void setMontoPrestamoGrupal(java.lang.Double montoPrestamoGrupal) {
		this.montoPrestamoGrupal = montoPrestamoGrupal;
	}

	/**
	 * Obtiene monto prestamo grupal.
	 *
	 * @return monto prestamo grupal
	 */
	public java.lang.Double getMontoPrestamoGrupal() {
		return montoPrestamoGrupal;
	}

	/**
	 * @return the numContrato
	 */
	public java.lang.String getNumContrato() {
		return numContrato;
	}

	/**
	 * @param numContrato the numContrato to set
	 */
	public void setNumContrato(java.lang.String numContrato) {
		this.numContrato = numContrato;
	}
}
