
package negocio.reportes;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.oasisopen.sca.annotation.Remotable;

import utilitario.mensajes.reportes.amortizacion.AmortizacionPeticion;
import utilitario.mensajes.reportes.amortizacion.AmortizacionRespuesta;
import utilitario.mensajes.reportes.cierre.ReportesCierrePeticion;
import utilitario.mensajes.reportes.cierre.ReportesCierreRespuesta;
import utilitario.mensajes.reportes.comun.PagosImportadosPeticion;
import utilitario.mensajes.reportes.comun.PagosImportadosRespuesta;
import utilitario.mensajes.reportes.comun.PersonasBloqueoPeticion;
import utilitario.mensajes.reportes.comun.PersonasBloqueoRespuesta;
import utilitario.mensajes.reportes.comun.ReportesContablesPeticion;
import utilitario.mensajes.reportes.comun.ReportesContablesRespuesta;
import utilitario.mensajes.reportes.estadocuenta.EstadoCuentaPeticion;
import utilitario.mensajes.reportes.estadocuenta.EstadoCuentaRespuesta;
import utilitario.mensajes.reportes.garantias.PeticionReporteExcepcionGarantia;
import utilitario.mensajes.reportes.garantias.RespuestaReporteExcepcionGarantia;
import utilitario.mensajes.reportes.tasas.ReporteTasasPeticion;
import utilitario.mensajes.reportes.tasas.ReporteTasasRespuesta;

 /**
 * @author Juan Moreno
 * @version 1.0
 * Encapsula las operaciones del componente de ReportesCreditoGrupal de credito Grupal.
  */
@Remotable
@WebService(name = "ReportesCreditoGrupal", targetNamespace = "http://fisa.com.mx/CIOF/ReportesCreditoGrupal/V1.0")
public interface ReportesCreditoGrupal {

	/**
	 * Operaci�n que consulta la informaci�n necesaria para conocer un estado de cuenta de un cr�dito dado.
	 * @param cuenta peticion
	 * @param EstadoCuentaPeticion
	 * @return EstadoCuentaRespuesta
	 */
	public EstadoCuentaRespuesta obtenerEstadoCuenta(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ReportesCreditoGrupal/V1.0")
			EstadoCuentaPeticion cuenta);

	/**
	 * Operaci�n que consulta la informaci�n necesaria para conocer la informaci�n de amortizaci�n de un cr�dito grupal.
	 * @param cuenta peticion
	 * @param AmortizacionPeticion
	 * @return AmortizacionRespuesta
	 */
	public AmortizacionRespuesta obtenerAmortizacionGrupo(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ReportesCreditoGrupal/V1.0")
			AmortizacionPeticion cuenta);

	/**
 	 *Operaci�n que consulta la informaci�n necesaria para conocer la informaci�n de amortizaci�n de un cr�dito individual.
 	 * @param cuenta peticion
	 * @param AmortizacionPeticion
	 * @return AmortizacionRespuesta
	 */
	public AmortizacionRespuesta obtenerAmortizacionIndividual(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ReportesCreditoGrupal/V1.0")
			AmortizacionPeticion cuenta);

	/**
	 * TODO
	 * @param peticion peticion
	 * @return ReportesCierreRespuesta
	 */
	public ReportesCierreRespuesta generaReporteCarteraActiva(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ReportesCreditoGrupal/V1.0")
			ReportesCierrePeticion peticion);

	/**
	 * TODO
	 * @param peticion peticion
	 * @return ReportesCierreRespuesta
	 */
	public ReportesCierreRespuesta generaReporteContratosActivosConMora(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ReportesCreditoGrupal/V1.0")
			ReportesCierrePeticion peticion);

	/**
	 * TODO
	 * @param peticion peticion
	 * @return ReportesCierreRespuesta
	 */
	public ReportesCierreRespuesta generaReporteContratosActivosSaldoFavor(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ReportesCreditoGrupal/V1.0")
			ReportesCierrePeticion peticion);

	/**
	 * TODO
	 * @param peticion peticion
	 * @return ReportesCierreRespuesta
	 */
	public ReportesCierreRespuesta generaReporteDesembolsoRepayments(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ReportesCreditoGrupal/V1.0")
			ReportesCierrePeticion peticion);

	/**
	 * TODO
	 * @param peticion peticion
	 * @return ReportesCierreRespuesta
	 */
	public ReportesCierreRespuesta generaReporteDesembolsoSEFinsol1(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ReportesCreditoGrupal/V1.0")
			ReportesCierrePeticion peticion);

	/**
	 * TODO
	 * @param peticion peticion
	 * @return ReportesCierreRespuesta
	 */
	public ReportesCierreRespuesta generaReporteDesembolsoSEFinsol2(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ReportesCreditoGrupal/V1.0")
			ReportesCierrePeticion peticion);

	/**
	 * TODO
	 * @param peticion peticion
	 * @return ReportesCierreRespuesta
	 */
	public ReportesCierreRespuesta[] generarReportesCierre(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ReportesCreditoGrupal/V1.0")
			ReportesCierrePeticion peticion);

	/**
	 * TODO
	 * @param peticion peticion
	 * @return ReportesContablesRespuesta
	 */
	public ReportesContablesRespuesta generarReporteBalanceGeneral(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ReportesCreditoGrupal/V1.0")
			ReportesContablesPeticion peticion);

	/**
	 * Es el desglose de los saldos pasivos de fondeo
	* @param peticion peticion
	 * @return ReportesContablesRespuesta
	 */
	public ReportesContablesRespuesta generarReportePasivosdeFondeo(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ReportesCreditoGrupal/V1.0")
			ReportesContablesPeticion peticion);

	/**
	 * Informaci�n para monitoreo mensual - del estado de resultados
	 * @param peticion peticion
	 * @return ReportesContablesRespuesta
	 */
	public ReportesContablesRespuesta generarReportedeEstadosResultados(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ReportesCreditoGrupal/V1.0")
			ReportesContablesPeticion peticion);

	/**
	 * Informaci�n para monitoreo mensual - del castigo y venta de la cartera vencida
	 * @param peticion peticion
	 * @return ReportesContablesRespuesta
	 */
	public ReportesContablesRespuesta generarReporteCastigoVentadeCarteraVencida(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ReportesCreditoGrupal/V1.0")
			ReportesContablesPeticion peticion);

	/**
	 * Informaci�n para monitoreo mensual - del riesgo de credito
	 * @param peticion peticion
	 * @return ReportesContablesRespuesta
	 */
	public ReportesContablesRespuesta generarReporteRiesgoCredito(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ReportesCreditoGrupal/V1.0")
			ReportesContablesPeticion peticion);

	/**
	 * Informaci�n para monitoreo mensual - del riesgo de mercado
	 * @param peticion peticion
	 * @return ReportesContablesRespuesta
	 */
	public ReportesContablesRespuesta generarReporteRiesgoMercado(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ReportesCreditoGrupal/V1.0")
			ReportesContablesPeticion peticion);

	/**
	 * Concentraci�n m�xima de financiamiento por grupo de riesgo com�n
	 * @param peticion peticion
	 * @return ReportesContablesRespuesta
	 */
	public ReportesContablesRespuesta generarReporteFinanciamientoRiesgoComun(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ReportesCreditoGrupal/V1.0")
			ReportesContablesPeticion peticion);

	/**
	 * Desglose de Cr�ditos Relacionados
	 * @param peticion peticion
	  * @return ReportesContablesRespuesta
	 */
	public ReportesContablesRespuesta generarReporteCreditosRelacionados(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ReportesCreditoGrupal/V1.0")
			ReportesContablesPeticion peticion);

	/**
	 * Reporte para obtener el capital neto
	 * @param peticion peticion
	 * @return ReportesContablesRespuesta
	 */
	public ReportesContablesRespuesta generarReporteCapitalNeto(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ReportesCreditoGrupal/V1.0")
			ReportesContablesPeticion peticion);

	/**
	 * Metodo para consultar los pagos importados de una fecha solicitada.
	 * @param  peticion  contiene la fecha para generar el reporte de pagos importados.
	 * @return respuesta lista de pagos importados.
	 */
	public PagosImportadosRespuesta generarReportePagosImportados(PagosImportadosPeticion peticion);

	/**
	 * Metodo para consultar las personas bloqueadas de una fecha solicitada.
	 * @param  peticion  contiene la fecha para generar el reporte de pagos importados.
	 * @return respuesta lista de pagos importados.
	 */
	public PersonasBloqueoRespuesta generarReportePersonasBloqueadas(PersonasBloqueoPeticion peticion);

	/**
	 * Método para consultar las solicitudes con excepciones para un rango de fechas.
	 * @param  peticion  contiene los siguientes parámetros: división, región, estatus, fecha_inicial, fecha_final.
	 * @return respuesta lista de solicitudes con excepciones.
	 */
	public String generarReporteExcepcionesBuzon(String peticion);

	/**
	 * Método para consultar las solicitudes con garantías.
	 * @param  peticion  contiene los siguientes parámetros: división, región, contrato, fecha_inicial, fecha_final.
	 * @return respuesta lista de solicitudes de garantías.
	 */
	public String generarReporteSolicitudesGarantias(String peticion);

	/**
	 * Método para consultar el reporte de tasas.
	 * @param peticion contiene los siguientes parametros: fechaInicial y fechaFinal
	 * @return respuesta lista de reporte de tasas
	 */
	public ReporteTasasRespuesta generarReporteTasas(ReporteTasasPeticion peticion);

	/**
	 * Operacion que consulta la informacion necesaria para conocer un estado de cuenta de un credito dado.
	 * @param cuenta peticion
	 * @param EstadoCuentaPeticion
	 * @return EstadoCuentaRespuesta JSON
	 */
	public String obtenerEstadoCuentaJSON(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ReportesCreditoGrupal/V1.0")
			EstadoCuentaPeticion cuenta);
}

