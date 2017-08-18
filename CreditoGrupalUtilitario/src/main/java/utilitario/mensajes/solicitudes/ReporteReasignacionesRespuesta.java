package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ReporteAsignacionesRespuesta.
 * @author ltorres
 */
public class ReporteReasignacionesRespuesta extends ObjetoValor {

	/** Serial. */
	private static final long serialVersionUID = -4330088774231656504L;

	/**
	 * EncabezadoRespuesta header ReporteReasignacionesRespuesta.java
	 */
	private EncabezadoRespuesta header;

	/** List<ReporteReasignacionOV> reasignaciones. */
	private List<ReporteReasignacionOV> reasignaciones;

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
	 * @return the reasignaciones
	 */
	public List<ReporteReasignacionOV> getReasignaciones() {
		return reasignaciones;
	}

	/**
	 * @param reasignaciones the reasignaciones to set
	 */
	public void setReasignaciones(List<ReporteReasignacionOV> reasignaciones) {
		this.reasignaciones = reasignaciones;
	}

}
