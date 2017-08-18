package utilitario.mensajes.buro;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class BuroPeticionKit.
 *
 * @author rguadarramac
 */
public class BuroPeticionKit extends ObjetoValor {

	/**
	 * Instancia una nueva buro peticion kit.
	 */
	public BuroPeticionKit() {
	}
	/** Se genero una id unico para el obj. */
	private static final long serialVersionUID = 4716199723716014600L;

	/** The header. */
	private EncabezadoPeticion	header;

	/** The persona. */
	private String persona;

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}

	/**
	 * Establece persona.
	 *
	 * @param persona a persona
	 */
	public void setPersona(String persona) {
		this.persona = persona;
	}

	/**
	 * Obtiene persona.
	 *
	 * @return persona
	 */
	public String getPersona() {
		return persona;
	}


}
