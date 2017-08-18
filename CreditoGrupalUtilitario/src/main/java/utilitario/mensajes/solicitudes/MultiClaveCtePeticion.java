/**
 *
 */
package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class MultiClaveCtePeticion.
 *
 * @author out_ltorres
 */
public class MultiClaveCtePeticion extends ObjetoValor {

	/**
	 * Instancia una nueva multi clave cte peticion.
	 */
	public MultiClaveCtePeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3760114757543566970L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The p codigos cliente. */
	private List<String> pCodigosCliente;

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
	 * Obtiene p codigos cliente.
	 *
	 * @return p codigos cliente
	 */
	public List<String> getpCodigosCliente() {
		return pCodigosCliente;
	}

	/**
	 * Establece p codigos cliente.
	 *
	 * @param pCodigosCliente a p codigos cliente
	 */
	public void setpCodigosCliente(List<String> pCodigosCliente) {
		this.pCodigosCliente = pCodigosCliente;
	}

}
