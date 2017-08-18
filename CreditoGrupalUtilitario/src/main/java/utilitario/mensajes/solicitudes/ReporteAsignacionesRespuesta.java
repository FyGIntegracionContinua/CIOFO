package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ReporteAsignacionesRespuesta.
 * @author ltorres
 */
public class ReporteAsignacionesRespuesta extends ObjetoValor {

	/** Serial. */
	private static final long serialVersionUID = 9102731223299032188L;

	/**
	 * EncabezadoRespuesta ReporteAsignacionesRespuesta.java
	 */
	private EncabezadoRespuesta header;

	/** List<ReporteAsignacionOV> asignaciones. */
	private List<ReporteAsignacionOV> asignaciones;

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
	 * @return the asignaciones
	 */
	public List<ReporteAsignacionOV> getAsignaciones() {
		return asignaciones;
	}

	/**
	 * @param asignaciones the asignaciones to set
	 */
	public void setAsignaciones(List<ReporteAsignacionOV> asignaciones) {
		this.asignaciones = asignaciones;
	}

}
