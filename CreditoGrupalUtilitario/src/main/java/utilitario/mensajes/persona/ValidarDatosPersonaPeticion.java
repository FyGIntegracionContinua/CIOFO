/**
 *
 */
package utilitario.mensajes.persona;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ValidarDatosPersonaPeticion.
 *
 * @author rguadarrama
 */
public 	class 	ValidarDatosPersonaPeticion extends ObjetoValor {


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/** header EncabezadoPeticion. */
	private EncabezadoPeticion	header;

	/** datosPersona PersonaOV. */
	private String	numeroPersona;

	/**
	 * ConsultarPersonaPeticion.
	 */
	public ValidarDatosPersonaPeticion() {

	}

	/**
	 * Gets the header.
	 *
	 * @return the header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Sets the header.
	 *
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}

	/**
	 * Gets the numero persona.
	 *
	 * @return the numero persona
	 */
	public String getNumeroPersona() {
		return numeroPersona;
	}

	/**
	 * Sets the numero persona.
	 *
	 * @param numeroPersona the new numero persona
	 */
	public void setNumeroPersona(String numeroPersona) {
		this.numeroPersona = numeroPersona;
	}



}
