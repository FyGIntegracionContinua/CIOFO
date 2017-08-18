package utilitario.mensajes.reportes.garantias;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

public class RespuestaReporteExcepcionGarantia extends ObjetoValor {

	/**
	 * @author lsotos
	 */
	private static final long serialVersionUID = -6196620899080197683L;

	/**
	 * encabezado.
	 */
	private EncabezadoRespuesta header;

	/** registros List<ReporteExcepcionGarantiaOV>. */
	private List<ReporteExcepcionGarantiaOV> registros;


	/**
	 * @return the registros
	 */
	public List<ReporteExcepcionGarantiaOV> getRegistros() {
		return registros;
	}

	/**
	 * @param registros the registros to set
	 */
	public void setRegistros(List<ReporteExcepcionGarantiaOV> registros) {
		this.registros = registros;
	}

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


}
