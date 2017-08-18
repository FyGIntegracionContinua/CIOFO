package utilitario.mensajes.administracion.contrato;

import java.util.ArrayList;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class TransferirSaldosAFavorCreditosVigentesRespuesta.
 *
 * @author out_mreyes
 */
public 	class 	TransferirSaldosAFavorCreditosVigentesRespuesta
		extends ObjetoValor	{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2343449501266343398L;

	// Atributos de la clase  -------------------------------------------------------------------
	/** The header. */
	private EncabezadoRespuesta 								header;

	/** The reporte saldos a favor. */
	private java.util.List<AjusteSaldoAFavorMasivoRespuesta>	reporteSaldosAFavor;

	// Constructor  -----------------------------------------------------------------------------
	/**
	 * Instancia una nueva transferir saldos a favor creditos vigentes respuesta.
	 */
	public TransferirSaldosAFavorCreditosVigentesRespuesta() {
		reporteSaldosAFavor = new ArrayList<AjusteSaldoAFavorMasivoRespuesta>();
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
	 * Obtiene reporte saldos a favor.
	 *
	 * @return the reporteSaldosAFavor
	 */
	public java.util.List<AjusteSaldoAFavorMasivoRespuesta> getReporteSaldosAFavor() {
		return reporteSaldosAFavor;
	}

	/**
	 * Establece reporte saldos a favor.
	 *
	 * @param reporteSaldosAFavor the reporteSaldosAFavor to set
	 */
	public void setReporteSaldosAFavor(
			java.util.List<AjusteSaldoAFavorMasivoRespuesta> reporteSaldosAFavor) {
		this.reporteSaldosAFavor = reporteSaldosAFavor;
	}

}
