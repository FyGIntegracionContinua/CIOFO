package utilitario.mensajes.reportes.comun;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;
import utilitario.mensajes.persona.PersonaOV;

/**
 * The Class ReportesContablesRespuesta.
 */
public class PersonasBloqueoRespuesta extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -792657573700093538L;

	/** EncabezadoRespuesta header. */
	private EncabezadoRespuesta header;
	/**
	 * java.util.List<java.lang.String> cadena
	 */
	private List<PersonaOV> personasBloqueadas;

	/**
	 * ReportesContablesRespuesta.
	 */
	public PersonasBloqueoRespuesta() {
		header = new EncabezadoRespuesta();
		}

	/**
	 * Establece header.
	 *
	 * @param header setHeader :
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene header.
	 *
	 * @return getHeader :
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Gets the personas bloqueadas.
	 *
	 * @return the personas bloqueadas
	 */
	public List<PersonaOV> getPersonasBloqueadas() {
		return personasBloqueadas;
	}

	/**
	 * Sets the personas bloqueadas.
	 *
	 * @param personasBloqueadas the new personas bloqueadas
	 */
	public void setPersonasBloqueadas(List<PersonaOV> personasBloqueadas) {
		this.personasBloqueadas = personasBloqueadas;
	}


}
