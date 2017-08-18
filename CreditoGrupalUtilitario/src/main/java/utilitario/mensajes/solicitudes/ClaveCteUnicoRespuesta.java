package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ClaveCteUnicoRespuesta.
 */
public class ClaveCteUnicoRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva clave cte unico respuesta.
	 */
	public ClaveCteUnicoRespuesta() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2363289910345099972L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The clave cliente. */
	private ClaveCliente claveCliente;

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
	 * Obtiene clave cliente.
	 *
	 * @return clave cliente
	 */
	public ClaveCliente getClaveCliente() {
		return claveCliente;
	}

	/**
	 * Establece clave cliente.
	 *
	 * @param claveCliente a clave cliente
	 */
	public void setClaveCliente(ClaveCliente claveCliente) {
		this.claveCliente = claveCliente;
	}


}
