package utilitario.mensajes.persona;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

public class ConsultarPersonaRespuestaOV extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoRespuesta			header;

	/** The persona. */
	private List<PersonaSimplificacionOV>	persona;

	/** The xml. */
	private String	xml;

	// Constructor  ---------------------------------------------------------------------
	/**
	 * Instancia una nueva consultar persona respuesta.
	 */
	public ConsultarPersonaRespuestaOV() {
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
	public List<PersonaSimplificacionOV> getPersona() {
		return persona;
	}

	/**
	 * Establece persona.
	 *
	 * @param persona the persona to set
	 */
	public void setPersona(List<PersonaSimplificacionOV> persona) {
		this.persona = persona;
	}

	/**
	 * @return the xml
	 */
	public String getXml() {
		return xml;
	}

	/**
	 * @param xml the xml to set
	 */
	public void setXml(String xml) {
		this.xml = xml;
	}

}

