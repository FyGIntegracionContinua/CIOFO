package utilitario.mensajes.consultas;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class DatosClienteRespuesta.
 */
public class DatosClienteRespuesta extends ObjetoValor {


	/**
	 * Instancia una nueva datos cliente respuesta.
	 */
	public DatosClienteRespuesta() {
	}
/** The Constant serialVersionUID. */
private static final long serialVersionUID = 5082709112138876166L;

	/** The header. */
	private EncabezadoRespuesta 	header;

	/** The reporte datos cliente. */
	private  List<ReporteDatosCliente> reporteDatosCliente;

	/**
	 * Obtiene reporte datos cliente.
	 *
	 * @return reporte datos cliente
	 */
	public List<ReporteDatosCliente> getReporteDatosCliente() {
		return reporteDatosCliente;
	}

	/**
	 * Establece reporte datos cliente.
	 *
	 * @param reporteDatosCliente a reporte datos cliente
	 */
	public void setReporteDatosCliente(List<ReporteDatosCliente> reporteDatosCliente) {
		this.reporteDatosCliente = reporteDatosCliente;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}


}
