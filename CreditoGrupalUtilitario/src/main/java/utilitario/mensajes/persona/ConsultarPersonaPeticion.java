/**
 *
 */
package utilitario.mensajes.persona;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author out_mreyes@independencia.com.mx
 *
 */
public 	class 	ConsultarPersonaPeticion extends ObjetoValor {
	/**
	 * UID para serializacion
	 */
	private static final long serialVersionUID = -812466050146968674L;

	// Atributos de la clase  -----------------------------------------------------------
	/**
	 * header EncabezadoPeticion
	 */
	private EncabezadoPeticion	header;
	/**
	 * datosPersona PersonaOV
	 */
	private PersonaOV			datosPersona;

	// Constructor  ---------------------------------------------------------------------
	/**
	 * ConsultarPersonaPeticion
	 */
	public ConsultarPersonaPeticion() {

	}

	// Metodos de acceso  ---------------------------------------------------------------
	/**
	 * @return the header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}

	/**
	 * @return the persona
	 */
	public PersonaOV getPersona() {
		return datosPersona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(PersonaOV persona) {
		this.datosPersona = persona;
	}

}
