package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

public class ValidarRelacionPersonaContratoPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva validar relacion persona contrato peticion.
	 */
	public ValidarRelacionPersonaContratoPeticion() {
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2420073756128515569L;
	/** The header. */
	private EncabezadoPeticion header;
	/** The persona. */
	private String persona;
	/** The contrato. */
	private String contrato;


	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}

	/**
	 * @return the persona
	 */
	public String getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(String persona) {
		this.persona = persona;
	}

	/**
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
}
