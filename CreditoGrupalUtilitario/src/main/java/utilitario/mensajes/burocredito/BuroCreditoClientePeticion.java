/**
 *
 */
package utilitario.mensajes.burocredito;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class BuroCreditoClientePeticion.
 *
 * @author out_ltorres
 */
public class BuroCreditoClientePeticion extends ObjetoValor {

	/**
	 * Instancia una nueva buro credito cliente peticion.
	 */
	public BuroCreditoClientePeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4455623882728362370L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The clave cliente. */
	private String claveCliente;

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
	 * Obtiene clave cliente.
	 *
	 * @return clave cliente
	 */
	public String getClaveCliente() {
		return claveCliente;
	}

	/**
	 * Establece clave cliente.
	 *
	 * @param claveCliente a clave cliente
	 */
	public void setClaveCliente(String claveCliente) {
		this.claveCliente = claveCliente;
	}

}
