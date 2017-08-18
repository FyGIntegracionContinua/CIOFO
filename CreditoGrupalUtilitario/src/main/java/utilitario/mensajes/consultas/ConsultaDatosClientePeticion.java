package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaDatosClientePeticion.
 *
 * @author out_oarias
 */
public class ConsultaDatosClientePeticion extends ObjetoValor {

	/**
	 * Instancia una nueva consulta datos cliente peticion.
	 */
	public ConsultaDatosClientePeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5082709112138876166L;

	/** The header. */
	private EncabezadoRespuesta header;

	//private String persona;

	/** The clave persona. */
	private String clavePersona;

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
	 * Obtiene clave persona.
	 *
	 * @return the claveClienteUnico
	 */
	public String getClavePersona() {
		return clavePersona;
	}

	/**
	 * Establece clave persona.
	 *
	 * @param clavePersona a clave persona
	 */
	public void setClavePersona(String clavePersona) {
		this.clavePersona = clavePersona;
	}


}
