package tarea.reportes;

import utilitario.mensajes.reportes.comun.PagosImportadosPeticion;
import utilitario.mensajes.reportes.comun.PagosImportadosRespuesta;
import utilitario.mensajes.reportes.comun.ReportesContablesPeticion;
import utilitario.mensajes.reportes.comun.ReportesContablesRespuesta;

/**
 * @author out_mmejorada
 * @version 1.0.0
 */
public interface Contables {

	/**
	 * Reporte para generar las cifras de activos, pasivos, capital contable y cuentas de orden
	 * @param uid identificador unico de la peticion.
	 * @param peticion datos para obtener el reporte
	 * @return resultado para generar el reporte.
	 */
	public ReportesContablesRespuesta generarReporteBalanceGeneral(String uid, ReportesContablesPeticion peticion);

	/**
	 * Es el desglose de los saldos pasivos de fondeo
	  * @param uid identificador unico de la peticion.
	 * @param peticion datos para obtener el reporte
	 * @return resultado para generar el reporte.
	 */
	public ReportesContablesRespuesta generarReportePasivosdeFondeo(String uid, ReportesContablesPeticion peticion);

	/**
	 * Informaci�n para monitoreo mensual - del estado de resultados
	 * @param uid identificador unico de la peticion.
	 * @param peticion datos para obtener el reporte
	 * @return resultado para generar el reporte.
	 */
	public ReportesContablesRespuesta generarReportedeEstadosResultados(String uid, ReportesContablesPeticion peticion);

	/**
	 * Informaci�n para monitoreo mensual - del castigo y venta de la cartera vencida
	 * @param uid identificador unico de la peticion.
	 * @param peticion datos para obtener el reporte
	 * @return resultado para generar el reporte.
	 */
	public ReportesContablesRespuesta generarReporteCastigoVentadeCarteraVencida(String uid, ReportesContablesPeticion peticion);

	/**
	 * Informaci�n para monitoreo mensual - del riesgo de credito
	 * @param uid identificador unico de la peticion.
	 * @param peticion datos para obtener el reporte
	 * @return resultado para generar el reporte.
	 */
	public ReportesContablesRespuesta generarReporteRiesgoCredito(String uid, ReportesContablesPeticion peticion);

	/**
	 * Informaci�n para monitoreo mensual - del riesgo de mercado
	 * @param uid identificador unico de la peticion.
	 * @param peticion datos para obtener el reporte
	 * @return resultado para generar el reporte.
	 */
	public ReportesContablesRespuesta generarReporteRiesgoMercado(String uid, ReportesContablesPeticion peticion);

	/**
	 * Concentraci�n m�xima de financiamiento por grupo de riesgo com�n
	  * @param uid identificador unico de la peticion.
	 * @param peticion datos para obtener el reporte
	 * @return resultado para generar el reporte.
	 */
	public ReportesContablesRespuesta generarReporteFinanciamientoRiesgoComun(String uid, ReportesContablesPeticion peticion);

	/**
	 * Desglose de Cr�ditos Relacionados
	  * @param uid identificador unico de la peticion.
	 * @param peticion datos para obtener el reporte
	 * @return resultado para generar el reporte.
	 */
	public ReportesContablesRespuesta generarReporteCreditosRelacionados(String uid, ReportesContablesPeticion peticion);

	/**
	 * Reporte para obtener el capital neto
	 * @param uid identificador unico de la peticion.
	 * @param peticion datos para obtener el reporte
	 * @return resultado para generar el reporte.
	 */
	public ReportesContablesRespuesta generarReporteCapitalNeto(String uid, ReportesContablesPeticion peticion);

	/**
	 * Metodo para consultar los pagos importados de una fecha solicitada.
	 * @param uid identificador unico de la peticion.
	 * @param  peticion  contiene la fecha para generar el reporte de pagos importados.
	 * @return respuesta lista de pagos importados.
	 */
	public PagosImportadosRespuesta generarReportePagosImportados(String uid, PagosImportadosPeticion peticion);
}
