package utilitario.mensajes.persona;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class RegistrarPersonaPeticion.
 *
 * @author out_mreyes@independencia.com.mx
 */
public 	class 	RegistrarPersonaPeticion extends ObjetoValor {

	/** UID para serializacion. */
	private static final long serialVersionUID = -812466050146968674L;

	// Atributos de la clase  -----------------------------------------------------------
	/** The header. */
	private EncabezadoPeticion	header;

	/** The datos persona. */
	private PersonaOV 			datosPersona;

	// Constructor  ---------------------------------------------------------------------
	/**
	 * Instancia una nueva registrar persona peticion.
	 */
	public RegistrarPersonaPeticion() {
		}

	// Metodos de acceso  ---------------------------------------------------------------
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
	 * Obtiene persona.
	 *
	 * @return the persona
	 */
	public PersonaOV getPersona() {
		return datosPersona;
	}

	/**
	 * Establece persona.
	 *
	 * @param persona the persona to set
	 */
	public void setPersona(PersonaOV persona) {
		this.datosPersona = persona;
	}

}
