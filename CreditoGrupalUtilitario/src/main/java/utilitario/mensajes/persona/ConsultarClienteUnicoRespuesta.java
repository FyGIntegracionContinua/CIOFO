/**
 *
 */
package utilitario.mensajes.persona;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultarClienteUnicoRespuesta.
 *
 * @author out_mreyes@independencia.com.mx
 */
public 	class 	ConsultarClienteUnicoRespuesta extends ObjetoValor {

	/** UID para serializacion. */
	private static final long serialVersionUID = -812466050146968674L;

	// Atributos de la clase  -----------------------------------------------------------
	/** The header. */
	private EncabezadoRespuesta			header;

	/** The persona. */
	private java.util.List<PersonaOV>	persona;

	// Constructor  ---------------------------------------------------------------------
	/**
	 * Instancia una nueva consultar cliente unico respuesta.
	 */
	public ConsultarClienteUnicoRespuesta()	{
		header = new EncabezadoRespuesta();
		}

	// Metodos de acceso  ---------------------------------------------------------------
	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene persona.
	 *
	 * @return the persona
	 */
	public java.util.List<PersonaOV> getPersona() {
		return persona;
	}

	/**
	 * Establece persona.
	 *
	 * @param persona the persona to set
	 */
	public void setPersona(java.util.List<PersonaOV> persona) {
		this.persona = persona;
	}

}
