package utilitario.mensajes.reportes.cierre;

import utilitario.mensajes.comun.EncabezadoRespuesta;

/**
 * The Class ReportesCierreRespuesta.
 */
public class ReportesCierreRespuesta {

	/**
	 * ReportesCierreRespuesta
	 */
	public ReportesCierreRespuesta() {

	}
	/**
	 * EncabezadoRespuesta header
	 */
	private EncabezadoRespuesta header;
	/**
	 * Integer totalRegistros
	 */
	private Integer totalRegistros;
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
	 * @return the totalRegistros
	 */
	public Integer getTotalRegistros() {
		return totalRegistros;
	}
	/**
	 * @param totalRegistros the totalRegistros to set
	 */
	public void setTotalRegistros(Integer totalRegistros) {
		this.totalRegistros = totalRegistros;
	}

}
