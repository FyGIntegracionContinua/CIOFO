package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaOportunidadPeticion.
 */
public class ConsultaOportunidadPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva consulta oportunidad peticion.
	 */
	public ConsultaOportunidadPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -20341817207040985L;

	/** The numero contrato. */
	private java.lang.String    numeroContrato;

	/**
	 * Establece numero contrato.
	 *
	 * @param numeroContrato a numero contrato
	 */
	public void setNumeroContrato(java.lang.String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

	/**
	 * Obtiene numero contrato.
	 *
	 * @return numero contrato
	 */
	public java.lang.String getNumeroContrato() {
		return numeroContrato;
	}

}
