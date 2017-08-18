package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

public class PersonasCreditoRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva acreditados respuesta.
	 */
	public PersonasCreditoRespuesta() {
	}

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -702389541526734300L;

	/**header*/
	private EncabezadoRespuesta header;

	/**personas*/
	private List<PersonasCredito> personas;

	/**
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * @return the personas
	 */
	public List<PersonasCredito> getPersonas() {
		return personas;
	}

	/**
	 * @param personas the personas to set
	 */
	public void setPersonas(List<PersonasCredito> personas) {
		this.personas = personas;
	}

}
