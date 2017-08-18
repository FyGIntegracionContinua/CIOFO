/**
 *
 */
package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class CodigosPeticion.
 *
 * @author out_gcorzo
 */
public class CodigosPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva codigos peticion.
	 */
	public CodigosPeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1255447782180796419L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The tipoCodigo. */
	private String tipoCodigo;

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
	 * @return the tipoCodigo
	 */
	public String getTipoCodigo() {
		return tipoCodigo;
	}

	/**
	 * @param tipoCodigo the tipoCodigo to set
	 */
	public void setTipoCodigo(String tipoCodigo) {
		this.tipoCodigo = tipoCodigo;
	}

}
