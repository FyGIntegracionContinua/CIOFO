/**
 *
 */
package utilitario.mensajes.reportes.cierre.eventos;

import java.io.Serializable;
import java.util.Date;

import utilitario.mensajes.consultas.ReporteDatosClientePeticion;
import utilitario.mensajes.reportes.cierre.ReporteDesembolsoPeticion;
import utilitario.mensajes.reportes.cierre.TiposReporteCierre;

/**
 * @author out_jcmoreno
 *
 */
public class EventoReporteCierre implements Serializable {


	/**
	 * long serialVersionUID
	 */
	private static final long serialVersionUID = 3L;
	/**
	 * TiposReporteCierre tipoReporte
	 */
	private TiposReporteCierre tipoReporte;
	/**
	 * Date fechaCierre
	 */
	private Date fechaCierre;
	/**
	 * Integer totalRegistros
	 */
	private Integer totalRegistros;
	/**
	 * String uid
	 */
	private String uid;
	/**
	 * ReporteDesembolsoPeticion desembolsoPeticion
	 */
	private ReporteDesembolsoPeticion desembolsoPeticion;
	/**
	 * ReporteDatosClientePeticion reporteDatosCliente
	 */
	private ReporteDatosClientePeticion reporteDatosCliente;
 	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * @return the fechaCierre
	 */
	public Date getFechaCierre() {
		return fechaCierre;
	}

	/**
	 * @param fechaCierre the fechaCierre to set
	 */
	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
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

	/**
	 *
	 */
	public EventoReporteCierre() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param tipo :
	 */
	public EventoReporteCierre( TiposReporteCierre tipo ) {
		this.setTipoReporte(tipo);
	}

	/**
	 * @param tipo the tipoReporte to set
	 */
	public void setTipoReporte(TiposReporteCierre tipo) {
		this.tipoReporte = tipo;
	}

	/**
	 * @return the tipoReporte
	 */
	public TiposReporteCierre getTipoReporte( ) {
		return tipoReporte;
	}

	/**
	 * @return the desembolsoPeticion
	 */
	public ReporteDesembolsoPeticion getDesembolsoPeticion() {
		return desembolsoPeticion;
	}

	/**
	 * @param desembolsoPeticion the desembolsoPeticion to set
	 */
	public void setDesembolsoPeticion(ReporteDesembolsoPeticion desembolsoPeticion) {
		this.desembolsoPeticion = desembolsoPeticion;
	}

	/**
	 * @return getReporteDatosCliente :
	 */
	public ReporteDatosClientePeticion getReporteDatosCliente() {
		return reporteDatosCliente;
	}

	/**
	 * @param reporteDatosCliente setReporteDatosCliente :
	 */
	public void setReporteDatosCliente(
			ReporteDatosClientePeticion reporteDatosCliente) {
		this.reporteDatosCliente = reporteDatosCliente;
	}


}
