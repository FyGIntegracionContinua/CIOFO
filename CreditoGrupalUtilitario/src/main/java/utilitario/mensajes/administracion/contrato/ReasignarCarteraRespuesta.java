package utilitario.mensajes.administracion.contrato;

import java.util.ArrayList;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ReasignarCarteraRespuesta.
 *
 * @author out_mreyes
 */
public 	class 	ReasignarCarteraRespuesta
		extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2343449501266343398L;

	// Atributos de la clase  -------------------------------------------------------------------
	/** The header. */
	private EncabezadoRespuesta 						header;

	/** The reporte reasignados. */
	private java.util.List<ReasignarCarteraReporteOV>	reporteReasignados;

	// Constructor  -----------------------------------------------------------------------------
	/**
	 * Instancia una nueva reasignar cartera respuesta.
	 */
	public ReasignarCarteraRespuesta() {
		reporteReasignados = new ArrayList<ReasignarCarteraReporteOV>();
		header = new EncabezadoRespuesta();
		}

	// Metodos de la clase  ---------------------------------------------------------------------
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
	 * Obtiene reporte reasignados.
	 *
	 * @return the reporteReasignados
	 */
	public java.util.List<ReasignarCarteraReporteOV> getReporteReasignados() {
		return reporteReasignados;
	}

	/**
	 * Establece reporte reasignados.
	 *
	 * @param reporteReasignados the reporteReasignados to set
	 */
	public void setReporteReasignados(
			java.util.List<ReasignarCarteraReporteOV> reporteReasignados) {
		this.reporteReasignados = reporteReasignados;
	}

}
