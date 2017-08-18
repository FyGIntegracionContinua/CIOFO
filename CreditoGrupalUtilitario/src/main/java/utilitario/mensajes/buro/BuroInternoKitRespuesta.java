package utilitario.mensajes.buro;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class BuroInternoKitRespuesta.
 *
 * @author rguadarramac
 * @version 1.0
 */
public class BuroInternoKitRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva buro interno kit respuesta.
	 */
	public BuroInternoKitRespuesta() {
	}
	/** Se genero un serial unico. */
	private static final long serialVersionUID = -1052319595342302724L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The buros. */
	private List<BuroInternoOV> buros;

	/** The persona. */
	private String persona;

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene persona.
	 *
	 * @return persona
	 */
	public String getPersona() {
		return persona;
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
	 * Obtiene buros.
	 *
	 * @return buros
	 */
	public List<BuroInternoOV> getBuros() {
		return buros;
	}

	/**
	 * Establece buros.
	 *
	 * @param buros a buros
	 */
	public void setBuros(List<BuroInternoOV> buros) {
		this.buros = buros;
	}
}
