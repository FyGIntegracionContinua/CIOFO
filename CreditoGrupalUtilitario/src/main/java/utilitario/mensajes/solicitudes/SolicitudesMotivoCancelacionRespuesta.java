package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SolicitudesRep.
 *
 * @author rguadarrama
 * @version 1.0
 */
public class SolicitudesMotivoCancelacionRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva solicitudes rep.
	 */
	public SolicitudesMotivoCancelacionRespuesta() {
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4320280692278932110L;

	/**
	 * EncabezadoRespuesta header ReporteReasignacionesRespuesta.java
	 */
	private EncabezadoRespuesta header;

	/** The motivo cancelacion. */
	private String motivoCancelacion;

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
	 * @return the motivoCancelacion
	 */
	public String getMotivoCancelacion() {
		return motivoCancelacion;
	}

	/**
	 * @param motivoCancelacion the motivoCancelacion to set
	 */
	public void setMotivoCancelacion(String motivoCancelacion) {
		this.motivoCancelacion = motivoCancelacion;
	}
}
