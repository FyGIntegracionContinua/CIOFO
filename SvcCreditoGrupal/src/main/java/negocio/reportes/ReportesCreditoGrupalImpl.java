/**
 *
 */
package negocio.reportes;

import org.fabric3.api.annotation.Producer;
import org.osoa.sca.annotations.Reference;

import tarea.reportes.Amortizacion;
import tarea.reportes.CierreDiario;
import tarea.reportes.Contables;
import tarea.reportes.Generales;
import tarea.reportes.EstadoCuenta;
import transformador.Transformador;
import utilitario.comun.GUIDGenerator;
import utilitario.log.LogHandler;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.reportes.amortizacion.AmortizacionPeticion;
import utilitario.mensajes.reportes.amortizacion.AmortizacionRespuesta;
import utilitario.mensajes.reportes.cierre.ReportesCierrePeticion;
import utilitario.mensajes.reportes.cierre.ReportesCierreRespuesta;
import utilitario.mensajes.reportes.cierre.TiposReporteCierre;
import utilitario.mensajes.reportes.cierre.eventos.EventoReporteCierre;
import utilitario.mensajes.reportes.cierre.eventos.ReportesCierre;
import utilitario.mensajes.reportes.comun.PagosImportadosPeticion;
import utilitario.mensajes.reportes.comun.PagosImportadosRespuesta;
import utilitario.mensajes.reportes.comun.PersonasBloqueoPeticion;
import utilitario.mensajes.reportes.comun.PersonasBloqueoRespuesta;
import utilitario.mensajes.reportes.comun.ReportesContablesPeticion;
import utilitario.mensajes.reportes.comun.ReportesContablesRespuesta;
import utilitario.mensajes.reportes.estadocuenta.EstadoCuentaPeticion;
import utilitario.mensajes.reportes.estadocuenta.EstadoCuentaRespuesta;
import utilitario.mensajes.reportes.garantias.PeticionReporteExcepcionGarantia;
import utilitario.mensajes.reportes.garantias.ReporteExcepcionGarantiaOV;
import utilitario.mensajes.reportes.garantias.ReporteSolicitudesGarantiaOV;
import utilitario.mensajes.reportes.garantias.ReporteSolicitudesGarantiaPeticion;
import utilitario.mensajes.reportes.garantias.ReporteSolicitudesGarantiasRespuesta;
import utilitario.mensajes.reportes.garantias.RespuestaReporteExcepcionGarantia;
import utilitario.mensajes.reportes.tasas.ReporteTasasPeticion;
import utilitario.mensajes.reportes.tasas.ReporteTasasRespuesta;

/**
 * @author mi.mejorada
 *
 */
public class ReportesCreditoGrupalImpl implements ReportesCreditoGrupal {

	/**
	 * componente SCA
	 */
	private EstadoCuenta estadoCuenta;
	/**
	 * componente SCA
	 */
	private Amortizacion amortizacion;
	/**
	 * componente SCA
	 */
	private CierreDiario cierre;
	/**
	 * componente SCA
	 */
	private Contables contables;

	/** The generales. */
	private Generales generales;

	/**
	 * notacion SCA Fabric
	 */
	@Producer
	private ReportesCierre reportesCierre;

	/**
	 * transformador
	 */
	private Transformador transformador;

/**
 * Contructor para inyectar las referencias creadas por Fabric
 * @param estadoCuenta sca componente variable
 * @param amortizacion sca componente variable
 * @param cierre sca componente variable
 * @param contables sca componente variable
 * @param generales sca composite
 * @param transformador sca componente variable
 */
	public ReportesCreditoGrupalImpl(@Reference(name = "estadoCuenta") EstadoCuenta  estadoCuenta ,
									  @Reference(name = "amortizacion") Amortizacion  amortizacion ,
									  @Reference(name = "cierre") CierreDiario cierre ,
									  @Reference(name = "contables") Contables contables,
									  @Reference(name = "generales") Generales generales,
									  @Reference(name = "transformador") Transformador transformador) {
		this.estadoCuenta =   estadoCuenta;
		this.amortizacion  = amortizacion;
		this.cierre = cierre;
		this.contables = contables;
		this.generales = generales;
		this.transformador = transformador;
	}

	/**
	 * @param cuenta peticion de solicitud
	 * @return respuesta
	 */
	public EstadoCuentaRespuesta obtenerEstadoCuenta(EstadoCuentaPeticion cuenta) {
		//Podemos hacer alguna l�gica con los par�metros de entrada
		final String uid = GUIDGenerator.generateGUID(cuenta);
		LogHandler.info(uid, getClass(), "obtenerEstadoCuenta - Datos de entrada : " + cuenta);

		//Salida
		final EstadoCuentaRespuesta estadoCuentaRespuesta = estadoCuenta.obtenerEstadoCuenta(uid, cuenta);
		LogHandler.info(uid, getClass(), "obtenerEstadoCuenta - Datos de salida : " + estadoCuentaRespuesta);
		return estadoCuentaRespuesta;
	}


	/**
	 * @param cuenta peticion de solicitud
	 * @return respuesta
	 */
	public AmortizacionRespuesta obtenerAmortizacionGrupo(AmortizacionPeticion cuenta) {
		//Podemos hacer alguna l�gica con los par�metros de entrada
		final String uid = GUIDGenerator.generateGUID(cuenta);
		LogHandler.info(uid, getClass(), "obtenerAmortizacionGrupo - Datos de entrada : " + cuenta);

		final AmortizacionRespuesta amortizacionRespuesta = amortizacion.obtenerAmortizacionGrupo(uid, cuenta);
		LogHandler.info(uid, getClass(), "obtenerAmortizacionGrupo - Datos de salida : " + amortizacionRespuesta);
		return amortizacionRespuesta;
	}

	/**
	 * @param cuenta peticion de solicitud
	 * @return respuesta
	 */
	public AmortizacionRespuesta obtenerAmortizacionIndividual(AmortizacionPeticion cuenta) {
		//Podemos hacer alguna l�gica con los par�metros de entrada
		final String uid = GUIDGenerator.generateGUID(cuenta);
		LogHandler.info(uid, getClass(), "obtenerAmortizacionIndividual - Datos de entrada : " + cuenta);

		//Salida
		final AmortizacionRespuesta amortizacionRespuesta = amortizacion.obtenerAmortizacionIndividual(uid, cuenta);
		LogHandler.info(uid, getClass(), "obtenerAmortizacionIndividual - Datos de salida : " + amortizacionRespuesta);
		return amortizacionRespuesta;
	}

	/**
	 * @param  peticion  contiene la peticion del reporte.
	 * @return respuesta del metodo.
	 */
	public ReportesCierreRespuesta generaReporteCarteraActiva(ReportesCierrePeticion peticion)
		{
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "generaReporteCarteraActiva - Datos de entrada : " + peticion);
		final ReportesCierreRespuesta respuesta = new ReportesCierreRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		final EventoReporteCierre eventoReporte = new EventoReporteCierre(TiposReporteCierre.CARTERA_ACTIVA);
		eventoReporte.setUid(uid);
		eventoReporte.setFechaCierre(peticion.getFechaCierre());
		final Integer totalRegistros = cierre.calculaTotalRegistros(uid, eventoReporte);
		if (totalRegistros == null) {
			respuesta.getHeader().setEstatus(false);
			respuesta.setTotalRegistros(0);
			respuesta.getHeader().setMensaje("No se pudo iniciar el proceso de generacion del reporte...");
			return respuesta;
		}
		LogHandler.debug(uid, getClass(), "99 generaReporteCarteraActiva");
		respuesta.getHeader().setEstatus(true);
		respuesta.setTotalRegistros(totalRegistros);
		respuesta.getHeader().setMensaje("El reporte de CARTERA_ACTIVA se esta generando. Tendra un total de: "
								+ totalRegistros + " registros. Espere a que se termine de procesar.");
		eventoReporte.setTotalRegistros(totalRegistros);
		reportesCierre.generaReporteCierre(eventoReporte); //Llamado asincrono

		LogHandler.info(uid, getClass(), "generaReporteCarteraActiva - Datos de salida : " + respuesta);
		return respuesta;
		}

	/**
	 * @param  peticion  contiene la peticion del reporte.
	 * @return respuesta del metodo.
	 */
	public ReportesCierreRespuesta generaReporteContratosActivosConMora(ReportesCierrePeticion peticion/*, String uid*/) {
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "generaReporteContratosActivosConMora - Datos de entrada : " + peticion);
		final ReportesCierreRespuesta respuesta = new ReportesCierreRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		final EventoReporteCierre eventoReporte = new EventoReporteCierre(TiposReporteCierre.CONTRATOS_ACTIVOS_CON_MORA);
		eventoReporte.setUid(uid);
		eventoReporte.setFechaCierre(peticion.getFechaCierre());
		final Integer totalRegistros = cierre.calculaTotalRegistros(uid, eventoReporte);
		if (totalRegistros == null) {
			respuesta.getHeader().setEstatus(false);
			respuesta.setTotalRegistros(0);
			respuesta.getHeader().setMensaje("No se pudo iniciar el proceso de generacion del reporte...");
			return respuesta;
		}
		respuesta.getHeader().setEstatus(true);
		respuesta.setTotalRegistros(totalRegistros);
		respuesta.getHeader().setMensaje("El reporte de  CONTRATOS_ACTIVOS_CON_MORA se esta generando. Tendra un total de: "
										+ totalRegistros + " registros. Espere a que se termine de procesar.");
		eventoReporte.setTotalRegistros(totalRegistros);
		reportesCierre.generaReporteCierre(eventoReporte); //Llamado asincrono

		LogHandler.info(uid, getClass(), "generaReporteContratosActivosConMora - Datos de salida : " + respuesta);
		return respuesta;

	}

	/**
	 * @param  peticion  contiene la peticion del reporte.
	 * @return respuesta del metodo.
	 */
	public ReportesCierreRespuesta generaReporteContratosActivosSaldoFavor(ReportesCierrePeticion peticion/*, String uid*/) {
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "generaReporteContratosActivosSaldoFavor - Datos de entrada : " + peticion);
		final ReportesCierreRespuesta respuesta = new ReportesCierreRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		final EventoReporteCierre eventoReporte = new EventoReporteCierre(TiposReporteCierre.CONTRATOS_ACTIVOS_SALDO_FAVOR);
		eventoReporte.setUid(uid);
		eventoReporte.setFechaCierre(peticion.getFechaCierre());
		final Integer totalRegistros = cierre.calculaTotalRegistros(uid, eventoReporte);
		if (totalRegistros == null) {
			respuesta.getHeader().setEstatus(false);
			respuesta.setTotalRegistros(0);
			respuesta.getHeader().setMensaje("No se pudo iniciar el proceso de generacion del reporte...");
			return respuesta;
		}
		respuesta.getHeader().setEstatus(true);
		respuesta.setTotalRegistros(totalRegistros);
		respuesta.getHeader().setMensaje("El reporte de CONTRATOS_ACTIVOS_CON_SALDO_FAVOR se esta generando. Tendra un total de: "
						+ totalRegistros + " registros. Espere a que se termine de procesar.");
		eventoReporte.setTotalRegistros(totalRegistros);
		reportesCierre.generaReporteCierre(eventoReporte); //Llamado asincrono

		LogHandler.info(uid, getClass(), "generaReporteContratosActivosSaldoFavor - Datos de salida : " + respuesta);
		return respuesta;
	}

	/**
	 * @param  peticion  contiene la peticion del reporte.
	 * @return respuesta del metodo.
	 */
	public ReportesCierreRespuesta generaReporteDesembolsoRepayments(ReportesCierrePeticion peticion /*, String uid*/) {
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "generaReporteDesembolsoRepayments - Datos de entrada : " + peticion);
		final ReportesCierreRespuesta respuesta = new ReportesCierreRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		final EventoReporteCierre eventoReporte = new EventoReporteCierre(TiposReporteCierre.DESEMBOLSO_REPAYMENTS);
		eventoReporte.setUid(uid);
		eventoReporte.setFechaCierre(peticion.getFechaCierre());
		final Integer totalRegistros = cierre.calculaTotalRegistros(uid, eventoReporte);
		if (totalRegistros == null) {
			respuesta.getHeader().setEstatus(false);
			respuesta.setTotalRegistros(0);
			respuesta.getHeader().setMensaje("No se pudo iniciar el proceso de generacion del reporte...");
			return respuesta;
		}
		respuesta.getHeader().setEstatus(true);
		respuesta.setTotalRegistros(totalRegistros);
		respuesta.getHeader().setMensaje("El reporte de DESEMBOLSO_REPAYMENTS se esta generando. Tendra un total de: "
				+ totalRegistros + " registros. Espere a que se termine de procesar.");
		eventoReporte.setTotalRegistros(totalRegistros);
		reportesCierre.generaReporteCierre(eventoReporte); //Llamado asincrono

		LogHandler.info(uid, getClass(), "generaReporteDesembolsoRepayments - Datos de salida : " + respuesta);
		return respuesta;
	}

	/**
	 * @param  peticion  contiene la peticion del reporte.
	 * @return respuesta del metodo.
	 */
	public ReportesCierreRespuesta generaReporteDesembolsoSEFinsol1(ReportesCierrePeticion peticion/*, String uid*/) {
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "generaReporteDesembolsoSEFinsol1 - Datos de entrada : " + peticion);
		final ReportesCierreRespuesta respuesta = new ReportesCierreRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		final EventoReporteCierre eventoReporte = new EventoReporteCierre(TiposReporteCierre.DESEMBOLOS_SE_FINSOL1);
		eventoReporte.setUid(uid);
		eventoReporte.setFechaCierre(peticion.getFechaCierre());
		final Integer totalRegistros = cierre.calculaTotalRegistros(uid, eventoReporte);
		if (totalRegistros == null) {
			respuesta.getHeader().setEstatus(false);
			respuesta.setTotalRegistros(0);
			respuesta.getHeader().setMensaje("No se pudo iniciar el proceso de generacion del reporte...");
			return respuesta;
		}
		respuesta.getHeader().setEstatus(true);
		respuesta.setTotalRegistros(totalRegistros);
		respuesta.getHeader().setMensaje("El reporte de DESEMBOLOS_SE_FINSOL1 se esta generando. Tendra un total de: "
				+ totalRegistros + " registros. Espere a que se termine de procesar.");
		eventoReporte.setTotalRegistros(totalRegistros);
		reportesCierre.generaReporteCierre(eventoReporte); //Llamado asincrono

		LogHandler.info(uid, getClass(), "generaReporteDesembolsoSEFinsol1 - Datos de salida : " + respuesta);
		return respuesta;
	}

	/**
	 * @param  peticion  contiene la peticion del reporte.
	 * @return respuesta del metodo.
	 */
	public ReportesCierreRespuesta generaReporteDesembolsoSEFinsol2(ReportesCierrePeticion peticion/*, String uid*/) {
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "generaReporteDesembolsoSEFinsol2 - Datos de entrada : " + peticion);
		final ReportesCierreRespuesta respuesta = new ReportesCierreRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		final EventoReporteCierre eventoReporte = new EventoReporteCierre(TiposReporteCierre.DESEMBOLOS_SE_FINSOL2);
		eventoReporte.setUid(uid);
		eventoReporte.setFechaCierre(peticion.getFechaCierre());
		final Integer totalRegistros = cierre.calculaTotalRegistros(uid, eventoReporte);
		if (totalRegistros == null) {
			respuesta.getHeader().setEstatus(false);
			respuesta.setTotalRegistros(0);
			respuesta.getHeader().setMensaje("No se pudo iniciar el proceso de generacion del reporte...");
			return respuesta;
		}
		respuesta.getHeader().setEstatus(true);
		respuesta.setTotalRegistros(totalRegistros);
		respuesta.getHeader().setMensaje("El reporte de DESEMBOLOS_SE_FINSOL2 se esta generando. Tendra un total de: "
				+ totalRegistros + " registros. Espere a que se termine de procesar.");
		eventoReporte.setTotalRegistros(totalRegistros);
		reportesCierre.generaReporteCierre(eventoReporte); //Llamado asincrono

		LogHandler.info(uid, getClass(), "generaReporteDesembolsoSEFinsol2 - Datos de salida : " + respuesta);
		return respuesta;
	}

	/**
	 * @param  peticion  contiene la peticion del reporte.
	 * @return respuesta del metodo.
	 */
	public ReportesCierreRespuesta generaReporteDesembolsoOpenContract(ReportesCierrePeticion peticion/*, String uid*/) {
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "generaReporteDesembolsoSEFinsol2 - Datos de entrada : " + peticion);
		final ReportesCierreRespuesta respuesta = new ReportesCierreRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		final EventoReporteCierre eventoReporte = new EventoReporteCierre(TiposReporteCierre.DESEMBOLSO_OPEN_CONTRACT);
		eventoReporte.setUid(uid);
		eventoReporte.setFechaCierre(peticion.getFechaCierre());
		final Integer totalRegistros = cierre.calculaTotalRegistros(uid, eventoReporte);
		if (totalRegistros == null) {
			respuesta.getHeader().setEstatus(false);
			respuesta.setTotalRegistros(0);
			respuesta.getHeader().setMensaje("No se pudo iniciar el proceso de generacion del reporte...");
			return respuesta;
		}
		respuesta.getHeader().setEstatus(true);
		respuesta.setTotalRegistros(totalRegistros);
		respuesta.getHeader().setMensaje("El reporte de  DESEMBOLSO_OPEN_CONTRACT se esta generando. Tendra un total de: "
		+ totalRegistros + " registros. Espere a que se termine de procesar.");
		eventoReporte.setTotalRegistros(totalRegistros);
		reportesCierre.generaReporteCierre(eventoReporte); //Llamado asincrono

		LogHandler.info(uid, getClass(), "generaReporteDesembolsoSEFinsol2 - Datos de salida : " + respuesta);
		return respuesta;
	}

	/**
	 * @param  peticion  contiene la peticion del reporte.
	 * @return respuesta del metodo.
	 */
	public ReportesCierreRespuesta[] generarReportesCierre(ReportesCierrePeticion peticion)
		{
		final Integer numeroReportesCierre = 7;
		//Se genera un uid para todos los reportes
		//final java.lang.String uid = GUIDGenerator.generateGUID( peticion );

		/*Se procede a la generacion de los reportes*/

		//Objeto que contiene la respuesta de todos los reportes
		ReportesCierreRespuesta [] respuesta = new ReportesCierreRespuesta[numeroReportesCierre];

		//generaReporteCarteraActiva
		respuesta[0] = generaReporteCarteraActiva(peticion); //, uid);

		//generaReporteContratosActivosConMora
		respuesta[1] = generaReporteContratosActivosConMora(peticion); //, uid);

		//generaReporteContratosActivosSaldoFavor
		respuesta[2] = generaReporteContratosActivosSaldoFavor(peticion); //, uid);

		//generaReporteDesembolsoRepayments
		respuesta[3] = generaReporteDesembolsoRepayments(peticion); //, uid);

		//generaReporteDesembolsoSEFinsol1
		respuesta[4] = generaReporteDesembolsoSEFinsol1(peticion); //, uid);

		//generaReporteDesembolsoSEFinsol2
		respuesta[5] = generaReporteDesembolsoSEFinsol2(peticion); //, uid);

		//generaReporteDesembolsoOpenContract
		respuesta[6] = generaReporteDesembolsoOpenContract(peticion); //, uid);

		return respuesta;
		}

	/**
	 * @param  peticion  contiene la peticion del reporte.
	 * @return respuesta del metodo.
	 */
	public ReportesContablesRespuesta generarReporteBalanceGeneral(ReportesContablesPeticion peticion)
		{
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "generarReporteBalanceGeneral - Datos de entrada : " + peticion);

		//Se recibe la salida
		final ReportesContablesRespuesta reportesContablesRespuesta = contables.generarReporteBalanceGeneral(uid, peticion);
		LogHandler.info(uid, getClass(), "generarReporteBalanceGeneral - Datos de salida : " + reportesContablesRespuesta);
		return reportesContablesRespuesta;
		}

	/**
	 * @param  peticion  contiene la peticion del reporte.
	 * @return respuesta del metodo.
	 */
	public ReportesContablesRespuesta generarReportePasivosdeFondeo(ReportesContablesPeticion peticion)
		{
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "generarReportePasivosdeFondeo - Datos de entrada : " + peticion);

		//Se recibe la salida
		final ReportesContablesRespuesta reportesContablesRespuesta = contables.generarReportePasivosdeFondeo(uid, peticion);
		LogHandler.info(uid, getClass(), "generarReportePasivosdeFondeo - Datos de salida : " + reportesContablesRespuesta);
		return reportesContablesRespuesta;
		}

	/**
	 * @param  peticion  contiene la peticion del reporte.
	 * @return respuesta del metodo.
	 */
	public ReportesContablesRespuesta generarReportedeEstadosResultados(
			ReportesContablesPeticion peticion) {
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "generarReportedeEstadosResultados - Datos de entrada : " + peticion);

		//Se recibe la salida
		final ReportesContablesRespuesta reportesContablesRespuesta = contables.generarReportedeEstadosResultados(uid, peticion);
		LogHandler.info(uid, getClass(), "generarReportedeEstadosResultados - Datos de salida : " + reportesContablesRespuesta);
		return reportesContablesRespuesta;
	}

	/**
	 * @param  peticion  contiene la peticion del reporte.
	 * @return respuesta del metodo.
	 */
	public ReportesContablesRespuesta generarReporteCastigoVentadeCarteraVencida(
			ReportesContablesPeticion peticion) {
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "generarReporteCastigoVentadeCarteraVencida - Datos de entrada : " + peticion);

		//Se recibe la salida
		final ReportesContablesRespuesta reportesContablesRespuesta
				= contables.generarReporteCastigoVentadeCarteraVencida(uid, peticion);
		LogHandler.info(uid, getClass(), "generarReporteCastigoVentadeCarteraVencida - Datos de salida : "
					+ reportesContablesRespuesta);
		return reportesContablesRespuesta;
	}

	/**
	 * @param  peticion  contiene la peticion del reporte.
	 * @return respuesta del metodo.
	 */
	public ReportesContablesRespuesta generarReporteRiesgoCredito(ReportesContablesPeticion peticion)
		{
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "generarReporteRiesgoCredito - Datos de entrada : " + peticion);

		//Se recibe la salida
		final ReportesContablesRespuesta reportesContablesRespuesta = contables.generarReporteRiesgoCredito(uid, peticion);
		LogHandler.info(uid, getClass(), "generarReporteRiesgoCredito - Datos de salida : " + reportesContablesRespuesta);
		return reportesContablesRespuesta;
		}

	/**
	 * @param  peticion  contiene la peticion del reporte.
	 * @return respuesta del metodo.
	 */
	public ReportesContablesRespuesta generarReporteRiesgoMercado(
			ReportesContablesPeticion peticion) {
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "generarReporteRiesgoMercado - Datos de entrada : " + peticion);

		//Se recibe la salida
		final ReportesContablesRespuesta reportesContablesRespuesta = contables.generarReporteRiesgoMercado(uid, peticion);
		LogHandler.info(uid, getClass(), "generarReporteRiesgoMercado - Datos de salida : " + reportesContablesRespuesta);
		return reportesContablesRespuesta;
	}

	/**
	 * @param  peticion  contiene la peticion del reporte.
	 * @return respuesta del metodo.
	 */
	public ReportesContablesRespuesta generarReporteFinanciamientoRiesgoComun(ReportesContablesPeticion peticion)
		{
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "generarReporteFinanciamientoRiesgoComun - Datos de entrada : " + peticion);

		//Se recibe la salida
		final ReportesContablesRespuesta reportesContablesRespuesta
		= contables.generarReporteFinanciamientoRiesgoComun(uid, peticion);
		LogHandler.info(uid, getClass(), "generarReporteFinanciamientoRiesgoComun - Datos de salida : "
				+ reportesContablesRespuesta);
		return reportesContablesRespuesta;
		}

	/**
	 * @param  peticion  contiene la peticion del reporte.
	 * @return respuesta del metodo.
	 */
	public ReportesContablesRespuesta generarReporteCreditosRelacionados(ReportesContablesPeticion peticion)
		{
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "generarReporteCreditosRelacionados - Datos de entrada : " + peticion);

		//Se recibe la salida
		final ReportesContablesRespuesta reportesContablesRespuesta = contables.generarReporteCreditosRelacionados(uid, peticion);
		LogHandler.info(uid, getClass(), "generarReporteCreditosRelacionados - Datos de salida : " + reportesContablesRespuesta);
		return reportesContablesRespuesta;
		}

	/**
	 * @param  peticion  contiene la peticion del reporte.
	 * @return respuesta del metodo.
	 */
	public ReportesContablesRespuesta generarReporteCapitalNeto(ReportesContablesPeticion peticion) {
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "generarReporteCapitalNeto - Datos de entrada : " + peticion);

		//Se recibe la salida
		final ReportesContablesRespuesta reportesContablesRespuesta = contables.generarReporteCapitalNeto(uid, peticion);
		LogHandler.info(uid, getClass(), "generarReporteCapitalNeto - Datos de salida : " + reportesContablesRespuesta);
		return reportesContablesRespuesta;
	}

	/**
	 * Metodo para consultar los pagos importados de una fecha solicitada.
	 * @param  peticion  contiene la fecha para generar el reporte de pagos importados.
	 * @return respuesta lista de pagos importados.
	 */
	public PagosImportadosRespuesta generarReportePagosImportados(PagosImportadosPeticion peticion) {
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "generarReportePagosImportados - Datos de entrada : " + peticion);

		//Se recibe la salida
		final PagosImportadosRespuesta pagosImportadosRespuesta = contables.generarReportePagosImportados(uid, peticion);
		LogHandler.info(uid, getClass(), "generarReportePagosImportados - Datos de salida : " + pagosImportadosRespuesta);
		return pagosImportadosRespuesta;
	}

	/**
	 * Metodo para consultar las personas bloqueadas de un rango de fechas.
	 * @param  peticion  contiene la fecha para generar el reporte.
	 * @return respuesta lista de personas.
	 */
	public PersonasBloqueoRespuesta generarReportePersonasBloqueadas(
			PersonasBloqueoPeticion peticion) {
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "generarReportePersonasBloqueadas - Datos de entrada : " + peticion);

		//Se recibe la salida
		final PersonasBloqueoRespuesta personasBloqueoRespuesta = generales.obtenerReportePersonasBloqueadasTarea(uid, peticion);
		LogHandler.info(uid, getClass(), "generarReportePersonasBloqueadas - Datos de salida : " + personasBloqueoRespuesta);
		return personasBloqueoRespuesta;
	}


	/**
	 * Método para consultar las solicitudes con excepciones para un rango de fechas.
	 * @param  peticion  contiene los siguientes parámetros: división, región, estatus, fecha_inicial, fecha_final.
	 * @return respuesta lista de pagos importados.
	 */
	public String generarReporteExcepcionesBuzon(String peticion) {
		final String uid = GUIDGenerator.generateGUID(peticion);

		LogHandler.info(uid, getClass(), "generarReporteExcepcionesBuzon - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ReporteExcepcionGarantiaOV.class,
									RespuestaReporteExcepcionGarantia.class,
									PeticionReporteExcepcionGarantia.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final PeticionReporteExcepcionGarantia excepcionesPeticion = (PeticionReporteExcepcionGarantia)
				transformador.transformaXMLAObjeto(uid, peticion, clases);


		//Se recibe la salida
		RespuestaReporteExcepcionGarantia respuestaReporteExcepcionGarantia =
				generales.obtenerReporteExcepcionesBuzon(uid, excepcionesPeticion);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuestaReporteExcepcionGarantia, clases);

		LogHandler.info(uid, getClass(), "generarReporteExcepcionesBuzon - Datos de salida : "
				+ respuestaXML);

		return respuestaXML;

	}

	/**
	 * Método para consultar las solicitudes con garantías.
	 * @param  peticion  contiene los siguientes parámetros: división, región, contrato, fecha_inicial, fecha_final.
	 * @return respuesta lista de solicitudes de garantías.
	 */
	public String generarReporteSolicitudesGarantias(String peticion) {
		final String uid = GUIDGenerator.generateGUID(peticion);

		LogHandler.info(uid, getClass(), "generarReporteSolicitudesGarantias - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ReporteSolicitudesGarantiaOV.class,
									ReporteSolicitudesGarantiaPeticion.class,
									ReporteSolicitudesGarantiasRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ReporteSolicitudesGarantiaPeticion peticionObjeto = (ReporteSolicitudesGarantiaPeticion)
				transformador.transformaXMLAObjeto(uid, peticion, clases);


		//Se recibe la salida
		ReporteSolicitudesGarantiasRespuesta respuestaObjeto =
				generales.obtenerReporteSolicitudesGarantia(uid, peticionObjeto);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuestaObjeto, clases);

		LogHandler.info(uid, getClass(), "generarReporteSolicitudesGarantias - Datos de salida : "
				+ respuestaXML);

		return respuestaXML;

	}

	/**
	 * Método para consultar el reporte de tasas.
	 * @param peticion contiene los siguientes parametros: fechaInicial y fechaFinal
	 * @return respuesta lista de reporte de tasas
	 */
	public ReporteTasasRespuesta generarReporteTasas(ReporteTasasPeticion peticion) {
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "generarReporteTasas - Datos de entrada " +  peticion);

		//Se recibe la salida
		final ReporteTasasRespuesta respuesta = generales.obtenerReporteTasas(uid, peticion);
		LogHandler.info(uid, getClass(), "generarReporteTasas - Datos de salida " +  respuesta);

		return respuesta;
	}

	/**
	 * @param cuenta peticion de solicitud
	 * @return respuesta
	 */
	public String obtenerEstadoCuentaJSON(EstadoCuentaPeticion cuenta) {
		//Podemos hacer alguna logica con los parametros de entrada
		final String uid = GUIDGenerator.generateGUID(cuenta);
		LogHandler.info(uid, getClass(), "obtenerEstadoCuenta - Datos de entrada : " + cuenta);

		//Salida
		final EstadoCuentaRespuesta estadoCuentaRespuesta = estadoCuenta.obtenerEstadoCuenta(uid, cuenta);
		LogHandler.info(uid, getClass(), "obtenerEstadoCuenta - Datos de salida : " + estadoCuentaRespuesta);
		return transformador.transformaObjetoAJSON(uid, estadoCuentaRespuesta);
	}
}
