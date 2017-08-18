/**
 *
 */
package utilitario.mensajes.reportes.garantias;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author lsotos
 *
 */
public class ReporteSolicitudesGarantiasRespuesta extends ObjetoValor {

	/**
	 *
	 */
	private static final long serialVersionUID = -7147185708113720549L;


	/**
	 * Manejo de Errores
	 */
	private EncabezadoRespuesta header;

	/**
	 * registros de la consulta
	 */
	private List<ReporteSolicitudesGarantiaOV> registros;

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
	 * @return the registros
	 */
	public List<ReporteSolicitudesGarantiaOV> getRegistros() {
		return registros;
	}

	/**
	 * @param registros the registros to set
	 */
	public void setRegistros(List<ReporteSolicitudesGarantiaOV> registros) {
		this.registros = registros;
	}

}

