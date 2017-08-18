package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ClaveCteUnicoPeticion.
 *
 * @author out_ltorres
 */
public class ClaveCteUnicoPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva clave cte unico peticion.
	 */
	public ClaveCteUnicoPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3110616347499633664L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The p codigo cliente. */
	private String pCodigoCliente;

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
	 * Obtiene p codigo cliente.
	 *
	 * @return p codigo cliente
	 */
	public String getpCodigoCliente() {
		return pCodigoCliente;
	}

	/**
	 * Establece p codigo cliente.
	 *
	 * @param pCodigoCliente a p codigo cliente
	 */
	public void setpCodigoCliente(String pCodigoCliente) {
		this.pCodigoCliente = pCodigoCliente;
	}

}
