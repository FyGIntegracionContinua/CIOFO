/**
 *
 */
package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ca.ocampo
 *
 */
public class ConsultaSolicitudPlanillaObservacionesRespuesta extends ObjetoValor {

	/**
	 * La constante serialVersionUID.
	 */
	private static final long serialVersionUID = -5315273520870518860L;

	/**
	 * Constructor
	 */
	public ConsultaSolicitudPlanillaObservacionesRespuesta() {

	}

	/**
	 * The header.
	 */
	private EncabezadoRespuesta header;

	/** The ConsultaSolicitudPlanillaObservacionesOV. */
	private List<ConsultaSolicitudPlanillaObservacionesOV> solicitudes;

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
	 * @return the solicitudes
	 */
	public List<ConsultaSolicitudPlanillaObservacionesOV> getSolicitudes() {
		return solicitudes;
	}

	/**
	 * @param solicitudes the solicitudes to set
	 */
	public void setSolicitudes(
			List<ConsultaSolicitudPlanillaObservacionesOV> solicitudes) {
		this.solicitudes = solicitudes;
	}


}
