/**
 *
 */
package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ca.ocampo
 *
 */
public class SolicitudExcepcionDocumentalRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva SolicitudExcepcionDocumentalRespuesta.
	 */
	public SolicitudExcepcionDocumentalRespuesta() {
	}
	/** Se genero nuevo serial. */
	private static final long serialVersionUID = -4646260967009156540L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The solicitud. */
	private SolicitudExcepcionDocumental solicitud;

	/** The id. */
	private String id;

	/**
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * @return the solicitud
	 */
	public SolicitudExcepcionDocumental getSolicitud() {
		return solicitud;
	}

	/**
	 * @param solicitud the solicitud to set
	 */
	public void setSolicitud(SolicitudExcepcionDocumental solicitud) {
		this.solicitud = solicitud;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


}
