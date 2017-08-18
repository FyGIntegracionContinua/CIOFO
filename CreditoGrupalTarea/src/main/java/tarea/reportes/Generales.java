package tarea.reportes;

import utilitario.mensajes.reportes.comun.PersonasBloqueoPeticion;
import utilitario.mensajes.reportes.comun.PersonasBloqueoRespuesta;
import utilitario.mensajes.reportes.garantias.PeticionReporteExcepcionGarantia;
import utilitario.mensajes.reportes.garantias.ReporteSolicitudesGarantiaPeticion;
import utilitario.mensajes.reportes.garantias.ReporteSolicitudesGarantiasRespuesta;
import utilitario.mensajes.reportes.garantias.RespuestaReporteExcepcionGarantia;
import utilitario.mensajes.reportes.tasas.ReporteTasasPeticion;
import utilitario.mensajes.reportes.tasas.ReporteTasasRespuesta;

/**
 * The Interface Generales.
 * @author rguadarrama
 * @version 1.0
 */
public interface Generales {

	/**
	 * Metodo para obtener el reporte de las personas que estan bloqueadas.
	 *
	 * @param uid tipo String
	 * @param peticion tipo PersonasBloqueoPeticion
	 * @return PersonasBloqueoRespuesta
	 */
	public PersonasBloqueoRespuesta obtenerReportePersonasBloqueadasTarea(String uid, PersonasBloqueoPeticion peticion);

	/**
	 * Método para obtener el reporte de las solicitudes con excepciones de garantía.
	 *
	 * @param uid tipo String
	 * @param peticion división, región, estatus, fecha inicial, fecha final
	 * @return 	lista de (region, nombreRegion, sucursal, nombreSucursal, solicitud, contratoNuevo, contratoRenovacion,
	 * 			ciclo, producto, fechaAltaExcepcion, estatusExcepcion, observaciones)
	 */
	public RespuestaReporteExcepcionGarantia obtenerReporteExcepcionesBuzon(
			String uid, PeticionReporteExcepcionGarantia peticion);

	/**
	 * Método para obtener el reporte de las solicitudes con garantía.
	 *
	 * @param uid tipo String
	 * @param peticion división, región, contrato, fecha inicial, fecha final
	 * @return 	lista de (contrato, grupo, nombreGrupo, ciclo, sucursal, nombreSucursal, region, nombreRegion, division,
	 * 					nombreDivision, garantiaRequeridaPct, garantiaRequeridaMonto, garantiaDeposito, garantiaTraspaso,
	 * 					garantiaDiferencia, garantiaDevoluciones, garantiaTotal, autorizacionExcepcion, fechaDesembolsoGrarantia,
	 * 					fechaDeposito, fechaTraspaso, banco, diasPago)
	 */
	public ReporteSolicitudesGarantiasRespuesta obtenerReporteSolicitudesGarantia(
			String uid, ReporteSolicitudesGarantiaPeticion peticion);

	/***
	 * Método para obtener el reporte de Tasas
	 * 
	 * @param uid tipo String
	 * @param peticion fecha inicial, fecha final, tipo Movimiento
	 * @return lista de (tasaActual, tasaInteres, tasaAnual, tasaInteresAnual, contratoLD, sucursal, sucursalNombre,
	 * 					usuarioReestructura, fechaReestructura, contrato, cliente, fechaContrato)
	 */
	public ReporteTasasRespuesta obtenerReporteTasas(
			String uid, ReporteTasasPeticion peticion);
}
