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
public 	class 	ValidarDatosPersonaRespuesta extends ObjetoValor {


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5677000937229085332L;

	/** The header. */
	private EncabezadoRespuesta			header;

	/** The persona. */
	private ValidaPersonaOV	persona;

	/** The relaciones persona. */
	private List<RelacionPersonaOV> relacionesPersona;

	/**
	 * Instancia una nueva consultar persona respuesta.
	 */
	public ValidarDatosPersonaRespuesta() {
		header = new EncabezadoRespuesta();
		}

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
	public ValidaPersonaOV getPersona() {
		return persona;
	}

	/**
	 * Establece persona.
	 *
	 * @param persona the persona to set
	 */
	public void setPersona(ValidaPersonaOV persona) {
		this.persona = persona;
	}

	/**
	 * Gets the relaciones persona.
	 *
	 * @return the relaciones persona
	 */
	public List<RelacionPersonaOV> getRelacionesPersona() {
		return relacionesPersona;
	}

	/**
	 * Sets the relaciones persona.
	 *
	 * @param relacionesPersona the new relaciones persona
	 */
	public void setRelacionesPersona(List<RelacionPersonaOV> relacionesPersona) {
		this.relacionesPersona = relacionesPersona;
	}

}
