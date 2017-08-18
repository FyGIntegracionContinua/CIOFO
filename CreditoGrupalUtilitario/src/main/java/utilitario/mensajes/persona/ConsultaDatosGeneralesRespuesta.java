package utilitario.mensajes.persona;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaDatosGeneralesRespuesta.
 */
public class ConsultaDatosGeneralesRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva consulta datos generales respuesta.
	 */
	public ConsultaDatosGeneralesRespuesta() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8535501400436659427L;

	/** The header. */
	private EncabezadoRespuesta			header;

	/** The persona. */
	private PersonaOV		persona;

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
