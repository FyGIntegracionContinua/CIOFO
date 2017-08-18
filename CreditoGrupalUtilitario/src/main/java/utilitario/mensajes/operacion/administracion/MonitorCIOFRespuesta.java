package utilitario.mensajes.operacion.administracion;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class MonitorCIOFRespuesta.
 */
public 	class 	MonitorCIOFRespuesta
		extends ObjetoValor {

	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = -6937337571213976678L;

	// Atributos privados  --------------------------------------------------------------------
	/**
	 * header EncabezadoRespuesta
	 */
	private EncabezadoRespuesta 	header;
	/**
	 * reporte ReporteCIOFOV
	 */
	private ReporteCIOFOV			reporte;

	//
	/**
	 * MonitorCIOFRespuesta
	 */
	public MonitorCIOFRespuesta() {
		header = new EncabezadoRespuesta();
		}

	/**
	 * @param header .
	 */
	public void setHeader(EncabezadoRespuesta header) {
			this.header = header;
		}

	/**
	 * @return .
	 */
	public EncabezadoRespuesta getHeader() {
			return header;
		}

	/**
	 * @return the reporte
	 */
	public ReporteCIOFOV getReporte() {
		return reporte;
	}

	/**
	 * @param reporte the reporte to set
	 */
	public void setReporte(ReporteCIOFOV reporte) {
		this.reporte = reporte;
	}

	}
