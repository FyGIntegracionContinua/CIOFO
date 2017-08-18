/**
 *
 */
package utilitario.mensajes.persona;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultarPersonaRespuesta.
 *
 * @author rguadarrama
 */
public 	class 	ConsultarPersonaRespuesta extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoRespuesta			header;

	/** The persona. */
	private List<PersonaOV>	persona;

	// Constructor  ---------------------------------------------------------------------
	/**
	 * Instancia una nueva consultar persona respuesta.
	 */
	public ConsultarPersonaRespuesta() {
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
	public List<PersonaOV> getPersona() {
		return persona;
	}

	/**
	 * Establece persona.
	 *
	 * @param persona the persona to set
	 */
	public void setPersona(List<PersonaOV> persona) {
		this.persona = persona;
	}

}
