package utilitario.mensajes.reportes.tasas;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ca.ocampo
 *
 */
public class ReporteTasasRespuesta extends ObjetoValor  {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Manejo de Errores
	 */
	private EncabezadoRespuesta header;

	/**
	 * registros de la consulta
	 */
	private List<ReporteTasasOV> registros;

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
	public List<ReporteTasasOV> getRegistros() {
		return registros;
	}

	/**
	 * @param registros the registros to set
	 */
	public void setRegistros(List<ReporteTasasOV> registros) {
		this.registros = registros;
	}


}
