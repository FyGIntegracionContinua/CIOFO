package utilitario.reglas.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

public class PeticionReglaIncremento  extends ObjetoValor {

	/**
	 * Instantiates a new peticion regla incremento.
	 */
	public PeticionReglaIncremento() {
	}
	/**
	 * Serial
	 */
	private static final long serialVersionUID = 3806235107206155614L;
	/**
	 * numeroPersona
	 */
	private String numeroPersona;
	/**
	 * numeroContrato
	 */
	private String numeroContrato;
	/**
	 * @return the numeroPersona
	 */
	public String getNumeroPersona() {
		return numeroPersona;
	}
	/**
	 * @param numeroPersona the numeroPersona to set
	 */
	public void setNumeroPersona(String numeroPersona) {
		this.numeroPersona = numeroPersona;
	}
	/**
	 * @return the numeroContrato
	 */
	public String getNumeroContrato() {
		return numeroContrato;
	}
	/**
	 * @param numeroContrato the numeroContrato to set
	 */
	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}
}
