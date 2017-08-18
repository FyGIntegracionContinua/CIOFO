/**
 *
 */
package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AuditoriaPeticion.
 *
 * @author out_ltorres
 */
public class AuditoriaPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva auditoria peticion.
	 */
	public AuditoriaPeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1255447782180796419L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The p solicitud. */
	private String pSolicitud;

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
	 * Obtiene p solicitud.
	 *
	 * @return p solicitud
	 */
	public String getpSolicitud() {
		return pSolicitud;
	}

	/**
	 * Establece p solicitud.
	 *
	 * @param pSolicitud a p solicitud
	 */
	public void setpSolicitud(String pSolicitud) {
		this.pSolicitud = pSolicitud;
	}

}
