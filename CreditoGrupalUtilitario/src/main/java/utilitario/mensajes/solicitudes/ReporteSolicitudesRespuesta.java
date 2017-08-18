package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ReporteSolicitudesRespuesta.
 * @author ltorres
 */
public class ReporteSolicitudesRespuesta extends ObjetoValor {

	/** Serial. */
	private static final long serialVersionUID = -6269087027507980533L;

	/**
	 * EncabezadoRespuesta ReporteBuroExternoRespuesta.java
	 */
	private EncabezadoRespuesta header;

	/** List<ReporteSolicitudOV> solicitudes. */
	private List<ReporteSolicitudOV> solicitudes;

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
	 * Obtiene solicitudes.
	 *
	 * @return the solicitudes
	 */
	public List<ReporteSolicitudOV> getSolicitudes() {
		return solicitudes;
	}

	/**
	 * Establece header.
	 *
	 * @param solicitudes the solicitudes to set
	 */
	public void setSolicitudes(List<ReporteSolicitudOV> solicitudes) {
		this.solicitudes = solicitudes;
	}

}
