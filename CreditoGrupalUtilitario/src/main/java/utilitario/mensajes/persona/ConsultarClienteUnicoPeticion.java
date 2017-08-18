/**
 *
 */
package utilitario.mensajes.persona;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultarClienteUnicoPeticion.
 *
 * @author out_mreyes@independencia.com.mx
 */
public 	class 	ConsultarClienteUnicoPeticion extends ObjetoValor {

	/** UID para serializacion. */
	private static final long serialVersionUID = -812466050146968674L;

	// Atributos de la clase  -----------------------------------------------------------
	/** The header. */
	private EncabezadoPeticion	header;

	/** The persona. */
	private PersonaOV			persona;

	// Constructor  ---------------------------------------------------------------------
	/**
	 * Instancia una nueva consultar cliente unico peticion.
	 */
	public ConsultarClienteUnicoPeticion() {

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
		return persona;
	}

	/**
	 * Establece persona.
	 *
	 * @param persona the persona to set
	 */
	public void setPersona(PersonaOV persona) {
		this.persona = persona;
	}

}
