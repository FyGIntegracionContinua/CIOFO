package tarea.solicitudes;


import java.util.List;

import org.apache.ibatis.session.SqlSession;

import utilitario.buzon.BuzonOV;
import utilitario.buzon.ConsultaAvanceTrabajoPeticion;
import utilitario.buzon.ConsultaAvanceTrabajoRespuesta;
import utilitario.comun.Constantes;
import utilitario.mensajes.burocredito.ResumenBuroPeticion;
import utilitario.mensajes.burocredito.ResumenBuroRespuesta;
import utilitario.mensajes.comun.ConsultaCatalogoPeticionCIOF;
import utilitario.mensajes.comun.ConsultaCatalogoRespuestaCIOF;
import utilitario.mensajes.impresiondocs.comun.ContratoPeticionKit;
import utilitario.mensajes.originacion.aprobacion.IntegrantePlanillaAprobacionDTO;
import utilitario.mensajes.originacion.aprobacion.PlanillaAprobacionPeticionDTO;
import utilitario.mensajes.originacion.aprobacion.PlanillaAprobacionRespuestaDTO;
import utilitario.mensajes.originacion.consulta.ContratoRenovacionPeticion;
import utilitario.mensajes.originacion.consulta.ContratoRenovacionRespuesta;
import utilitario.mensajes.originacion.consulta.SimplificacionRenovacion;
import utilitario.mensajes.originacion.contrato.ContratoOV;
import utilitario.mensajes.solicitudes.*;
import utilitario.mensajes.verificacion.telefonica.ConsultaInformacionTelefonicaPeticion;
import utilitario.mensajes.verificacion.telefonica.ConsultaInformacionTelefonicaRespuesta;
import utilitario.reglas.solicitudes.PeticionReglaIncremento;
import utilitario.reglas.solicitudes.RespuestaAlmacenarPlanillaAprobacion;
import utilitario.reglas.solicitudes.RespuestaReglaIncremento;
import utilitario.reglas.solicitudes.ValidaIntegrantePeticion;
import utilitario.reglas.solicitudes.ValidaIntegranteRespuesta;
import utilitario.reglas.solicitudes.ValidarIntegranteSolicitudPeticion;
import utilitario.reglas.solicitudes.ValidarIntegranteSolicitudRespuesta;
import utilitario.reglas.solicitudes.ValidarTasaInteresPeticion;
import utilitario.reglas.solicitudes.ValidarTasaInteresRespuesta;


/**
 * The Interface AdministracionCredito.
 *
 * @author mmejorada, rguadarrama, ltorres
 * @version 1.0
 */
public interface SolicitudesCreditoTarea extends Constantes {


	/**
	 * ERROR_OPENRULES
	 */
	public static final String ERROR_OPENRULES = "ERROR";

	/**
	 * CIEN
	 */
	public static final int CIEN = 100;

	/** DIA VIERNES */
	public static final int DIA_VIERNES = 5;

	/** DIA VIERNES */
	public static final int QUERY_HORA_MAX = 23;
	/** DIA VIERNES */
	public static final int QUERY_MINUTO_MAX = 59;
	/** DIA VIERNES */
	public static final int QUERY_SEGUNDO_MAX = 59;
	/** DIA VIERNES */
	public static final int QUERY_MILISEGUNDO_MAX = 999;
	/** DIA VIERNES */
	public static final int QUERY_ANIO_MIN = 1900;

	/**
	 * @param uid String
	 * @param solicitudPeticion SolicitudesPeticion
	 * @return respuesta tipo SolicitudesRespuesta
	 */
	SolicitudesRespuesta registrarSolicitudTarea(String uid,  SolicitudesPeticion solicitudPeticion);

	/**
	 * @param uid String
	 * @param sesion SqlSession
	 * @param solicitudesPeticion SolicitudesPeticion
	 * @return respuesta tipo ReporteSolicitudesRespuesta
	 */
	SolicitudesRespuesta cancelarSolicitudTarea(String uid, SqlSession sesion, SolicitudesPeticion solicitudesPeticion);

	/**
	 * @param uid String
	 * @param solicitudesPeticion SolicitudesPeticion
	 * @return respuesta tipo SolicitudesRespuesta
	 */
	SolicitudesRespuesta consultarSolicitudTarea(String uid, SolicitudesPeticion solicitudesPeticion);

	/**
	 * Metodo para registrar en la tabla de atomos
	 * @param uid String
	 * @param sesion SqlSession
	 * @param peticion AtomosOV
	 * @return respuesta tipo AtomosRespuesta
	 */
	AtomosRespuesta registrarAtomosTarea(String uid, SqlSession sesion , AtomosOV peticion);

	/**
	 * @param uid String
	 * @param acreditadosPeticion AcreditadosPeticion
	 * @return respuesta tipo AcreditadosRespuesta
	 */
	AcreditadosRespuesta procGetAcreditadosTarea(String uid, AcreditadosPeticion acreditadosPeticion);

	/**
	 * @param uid String
	 * @param peticion SolicitudBuroOV
	 * @return respuesta tipo SolicitudBuroRespuesta
	 */
	SolicitudBuroRespuesta registrarSolicitudBuroTarea(String uid, SolicitudBuroOV peticion);

	/**
	 * @param uid String
	 * @param contratoPeticionKit ContratoPeticionKit
	 * @return respuesta tipo SolicitudIDRespuesta
	 */
	SolicitudIDRespuesta procGetSolicitudTarea(String uid, ContratoPeticionKit contratoPeticionKit);

	/**
	 * @param uid String
	 * @param peticion SolicitudBuroOV
	 * @return respuesta tipo ConsultaSolicitudBuroRespuesta
	 */
	ConsultaSolicitudBuroRespuesta consultaSolicitudBuroTarea(String uid, SolicitudBuroOV peticion);

	/**
	 * @param uid String
	 * @param solicitudesTempPeticion SolicitudesTempPeticion
	 * @return respuesta tipo SolicitudesTempRespuesta
	 */
	SolicitudesTempRespuesta procGetSolicitudesTempTarea(String uid, SolicitudesTempPeticion solicitudesTempPeticion);

	/**
	 * @param uid String
	 * @param peticion SolicitudBuroOV
	 * @return respuesta tipo EncabezadoSolicitudRespuesta
	 */
	EncabezadoSolicitudRespuesta obtenerDatosSolicitudEncabezadoTarea(String uid, SolicitudBuroOV peticion);

	/**
	 * @param uid String
	 * @param peticion SolicitudBuroOV
	 * @return respuesta tipo EncabezadoSolicitudRespuesta
	 */
	EncabezadoSolicitudRespuesta obtenerDatosSolicitudEncabezadoAnalistaDocumentalBCTarea(String uid, SolicitudBuroOV peticion);

	/**
	 * @param uid String
	 * @param solicitudesRepPeticion SolicitudesRepPeticion
	 * @return respuesta tipo SolicitudesRepRespuesta
	 */
	SolicitudesRepRespuesta procGetRepSolicitudesTarea(String uid, SolicitudesRepPeticion solicitudesRepPeticion);

	/**
	 * @param uid String
	 * @param sesion SqlSession
	 * @param peticion SolicitudesOV
	 * @return respuesta tipo SolicitudesRespuesta
	 */
	SolicitudesRespuesta registrarSolicitudMinimaTarea(String uid, SqlSession sesion , SolicitudesOV peticion);

	/**
	 * @param uid String
	 * @param multiClaveCtePeticion MultiClaveCtePeticion
	 * @return respuesta tipo MultiClaveCteRespuesta
	 */
	MultiClaveCteRespuesta procGetMultiClaveCteTarea(String uid, MultiClaveCtePeticion multiClaveCtePeticion);

	/**
	 * @param uid String
	 * @param claveCteUnicoPeticion ClaveCteUnicoPeticion
	 * @return respuesta tipo ClaveCteUnicoRespuesta
	 */
	ClaveCteUnicoRespuesta procGetClaveCteUnicoTarea(String uid, ClaveCteUnicoPeticion claveCteUnicoPeticion);

	/**
	 * @param uid String
	 * @param auditoriaPeticion AuditoriaPeticion
	 * @return respuesta tipo AuditoriaRespuesta
	 */
	AuditoriaRespuesta procGetDatosAuditoriaTarea(String uid, AuditoriaPeticion auditoriaPeticion);

	/**
	 * @param uid String
	 * @param eliminacionCreditoPeticion EliminacionCreditoPeticion
	 * @return respuesta tipo SolicitudesRespuesta
	 */
	SolicitudesRespuesta procEliminacionCreditoTarea(String uid, EliminacionCreditoPeticion eliminacionCreditoPeticion);

	/**
	 * @param uid String
	 * @param solicitudesSACGPeticion SolicitudSACGPeticion
	 * @return respuesta tipo SolicitudesRespuesta
	 */
	SolicitudesRespuesta procGuardarCreditoTempTarea(String uid, SolicitudSACGPeticion solicitudesSACGPeticion);

	/**
	 * @param uid String
	 * @param solicitudSACGGetPeticion SolicitudSACGGetPeticion
	 * @return respuesta tipo SolicitudSACGGetRespuesta
	 */
	SolicitudSACGGetRespuesta procGetSolicitudesTarea(String uid, SolicitudSACGGetPeticion solicitudSACGGetPeticion);

	/**
	 * @param uid String
	 * @param solicitudesPeticion SolicitudesPeticion
	 * @return respuesta tipo SolicitudSACGRespuesta
	 */
	SolicitudSACGRespuesta procCreditoSolicitudTarea(String uid, SolicitudesPeticion solicitudesPeticion);

	/**
	 * @param uid String
	 * @param solicitudesPeticion SolicitudesPeticion
	 * @return respuesta tipo SolicitudSACGRespuesta
	 */
	SolicitudSACGRespuesta consultarSolicitudCreditoTarea(String uid, SolicitudesPeticion solicitudesPeticion);

	/**
	 * @param uid String
	 * @param accessPerfilPeticion AccessPerfilPeticion
	 * @return respuesta tipo AccessPerfilRespuesta
	 */
	AccessPerfilRespuesta get_AccessPerfil_FUNTarea(String uid, AccessPerfilPeticion accessPerfilPeticion);

	/**
	 * @param uid String
	 * @param subMenusPeticion SubMenusPeticion
	 * @return respuesta tipo AccessPerfilRespuesta
	 */
	AccessPerfilRespuesta get_Submenus_FUNTarea(String uid, SubMenusPeticion subMenusPeticion);

	/**
	 * @param uid String
	 * @param peticion SolicitudBuroGeneralOV
	 * @return respuesta tipo SolicitudesRespuesta
	 */
	SolicitudesRespuesta registrarSolicitudBuroGeneral(String uid, SolicitudBuroGeneralOV peticion);

	/**
	 * @param uid String
	 * @param peticion PoolPersonasOV
	 * @return respuesta tipo ConsultaPoolPersonasRespuesta
	 */
	ConsultaPoolPersonasRespuesta consultaPoolPersonasTarea(String uid, PoolPersonasOV peticion);

	/**
	 * @param uid String
	 * @param peticion ModificaPoolPersonasOV
	 * @return respuesta tipo ModificarPoolPersonasRespuesta
	 */
	ModificarPoolPersonasRespuesta modificarPoolPersonasTarea(String uid, ModificaPoolPersonasOV peticion);

	/**
	 * @param uid String
	 * @param peticion CargaTrabajoOV
	 * @return respuesta tipo CargaTrabajoOV
	 */
	CargaTrabajoRespuesta cargaTrabajoAnalistaTarea(String uid, CargaTrabajoOV peticion);

	/**
	 * @param uid String
	 * @param peticion ReasignarCargaTrabajoPeticion
	 * @return respuesta tipo ReasignarCargaTrabajoRespuesta
	 */
	ReasignarCargaTrabajoRespuesta reasignarCargaTrabajoAnalistaTarea(String uid, ReasignarCargaTrabajoPeticion peticion);

	/**
	 * @param uid String
	 * @param peticion AtomosOV
	 * @return respuesta tipo ConsultarAtomosRespuesta
	 */
	ConsultarAtomosRespuesta consultarAtomosTarea(String uid, AtomosOV peticion);

	/**
	 * @param uid String
	 * @param peticion StatusCreditoOV
	 * @return respuesta tipo StatusCreditoRespuesta
	 */
	StatusCreditoRespuesta consultarStatusCreditosTarea(String uid,	StatusCreditoOV peticion);

	/**
	 * @param uid String
	 * @param peticion PlanillaObservacionesOV
	 * @return respuesta tipo PlanillaObservacionesRespuesta
	 */
	PlanillaObservacionesRespuesta consultarPlanillaObservacionesTarea(String uid, PlanillaObservacionesOV peticion);

	/**
	 * @param uid String
	 * @param peticion PlanillaObservacionesPeticion
	 * @return respuesta tipo PlanillaObservacionesRespuesta
	 */
	PlanillaObservacionesRespuesta registrarPlanillaObservacionesTarea(String uid, PlanillaObservacionesPeticion peticion);

	/**
	 * @param uid String
	 * @param peticion CancelarSolEvaCrePeticion
	 * @return respuesta tipo CancelarSolEvaCreRespuesta
	 */
	CancelarSolEvaCreRespuesta cancelarSolicitudEvaluacionCrediticiaTarea(String uid, CancelarSolEvaCrePeticion peticion);

	/**
	 * @param uid String
	 * @param peticion CancelarSolEvaCrePeticion
	 * @return respuesta tipo CancelarSolEvaCreRespuesta
	 */
	CancelarSolEvaCreRespuesta terminarSolicitudEvaluacionCrediticiaTarea(String uid, CancelarSolEvaCrePeticion peticion);

	/**
	 * @param uid String
	 * @param peticion EnviarPlaObsSucPeticion
	 * @return respuesta tipo EnviarPlaObsSucRespuesta
	 */
	EnviarPlaObsSucRespuesta enviarPlanillaObservacionesSucursalTarea(String uid, EnviarPlaObsSucPeticion peticion);

	/**
	 * @param uid String
	 * @param peticion CorregirPlaObsSucPeticion
	 * @return respuesta tipo CorregirPlaObsSucRespuesta
	 */
	CorregirPlaObsSucRespuesta corregirPlanillaObservacionesSucursalTarea(String uid, CorregirPlaObsSucPeticion peticion);

	/**
	 * @param uid String
	 * @param reporteSolicitudesPeticion ReporteSolicitudesPeticion
	 * @return respuesta tipo ReporteSolicitudesRespuesta
	 */
	ReporteSolicitudesRespuesta reporteSolicitudesTarea(String uid, ReporteSolicitudesPeticion reporteSolicitudesPeticion);

	/**
	 * @param uid String
	 * @param reporteSolicitudesPeticion ReporteSolicitudesPeticion
	 * @return respuesta tipo ReporteBuroExternoRespuesta
	 */
	ReporteBuroExternoRespuesta reporteBuroExternoTarea(String uid, ReporteSolicitudesPeticion reporteSolicitudesPeticion);

	/**
	 * @param uid String
	 * @param reporteSolicitudesPeticion ReporteSolicitudesPeticion
	 * @return respuesta tipo ReporteAsignacionesRespuesta
	 */
	public ReporteAsignacionesRespuesta reporteAsignacionesTarea(
			String uid, ReporteSolicitudesPeticion reporteSolicitudesPeticion);

	/**
	 * @param uid String
	 * @param reporteSolicitudesPeticion ReporteSolicitudesPeticion
	 * @return respuesta tipo ReporteReasignacionesRespuesta
	 */
	public ReporteReasignacionesRespuesta reporteReasignacionesTarea(
			String uid, ReporteSolicitudesPeticion reporteSolicitudesPeticion);
	/**
	 * @param uid String
	 * @param reporteClasificacionSucursalesPeticion ReporteClasificacionSucursalesPeticion
	 * @return respuesta tipo ReporteClasificacionSucursalesRespuesta
	 */
	public ReporteClasificacionSucursalesRespuesta reporteClasificacionSucursalesTarea(
			String uid, ReporteClasificacionSucursalesPeticion reporteClasificacionSucursalesPeticion);

	/**
	 * Validar datos solicitud tarea.
	 *
	 * @param uid the uid
	 * @param peticion the peticion
	 * @return the validar solicitud respuesta
	 */
	public ValidarSolicitudRespuesta validarDatosSolicitudTarea(String uid, ValidarSolicitudPeticion peticion);

	/**
	 * @param uid :
	 * @param peticion :
	 * @return ConsultaAvanceTrabajoRespuesta
	 */
	public ConsultaAvanceTrabajoRespuesta consultarGraficaAvanceTarea(
			String uid, ConsultaAvanceTrabajoPeticion peticion);


	/**
	 * Consultar planilla aprobacion tarea.
	 *
	 * @param uid the uid
	 * @param peticion the peticion
	 * @param sesion the sesion
	 * @return the planilla aprobacion respuesta dto
	 */
	PlanillaAprobacionRespuestaDTO consultarPlanillaAprobacionTarea(String uid,
			PlanillaAprobacionPeticionDTO peticion, SqlSession sesion);

	/**
	 * Validar tasa interes tarea.
	 *
	 * @param uid the uid
	 * @param peticion the peticion
	 * @return the validar tasa interes respuesta
	 */
	public ValidarTasaInteresRespuesta validarTasaInteresTarea(String uid,	ValidarTasaInteresPeticion peticion);


	/**
	 * Validar tasa interes tarea.
	 *
	 * @param uid the uid
	 * @param peticion the peticion
	 * @return the validar tasa interes respuesta
	 */
	public ValidarTasaInteresRespuesta validarTasaConfirmarTarea(String uid,	ValidarTasaInteresPeticion peticion);


	/**
	 * @param uid identificador unico
	 * @param peticion para calcular el incremento
	 * @return respuesta
	 */
	public RespuestaReglaIncremento calculaIncrementoMontoTarea(String uid, PeticionReglaIncremento peticion);


	/**
	 * Almacenar planilla aprobacion tarea.
	 *
	 * @param uid the uid
	 * @param peticion the peticion
	 * @param solicitud the solicitud
	 * @param sesion the sesion
	 * @return the respuesta almacenar planilla aprobacion
	 */
	public RespuestaAlmacenarPlanillaAprobacion almacenarPlanillaAprobacionIntegrantesTarea(String uid,
			List<IntegrantePlanillaAprobacionDTO> peticion, CabeceraPlanillaAprobacionOV solicitud, SqlSession sesion);


	/**
	 * Valida los integrantes de una solicitud
	 *
	 * @param uid identificador unico
	 * @param peticion para calcular el incremento
	 * @return respuesta
	 */
	public ValidaIntegranteRespuesta validaIntegranteSolicitud(String uid, ValidaIntegrantePeticion peticion);

	/**
	 * Metodo para validar cuando se agrega un integrante en una solicitud.
	 * @param peticion contiene los datos necesarios para realizar la validacion.
	 * @param uid identificador unico de la transaccion para el log.
	 * @return regresa la respuesta para saber si es posible agregar el cliente o no a la solicitu.
	 */
	public ValidarIntegranteSolicitudRespuesta validarAgregarIntegranteSolicitud(String uid,
			ValidarIntegranteSolicitudPeticion peticion);

	/**
	 * Guarda la solicitud de un credito.
	 *
	 * @param uid the uid
	 * @param solicitudesSACGPeticion the solicitudes sacg peticion
	 * @return the solicitudes respuesta
	 */
	public SolicitudesRespuesta guardarSolicitudCreditoTarea(String uid,
			SolicitudSACGPeticion solicitudesSACGPeticion);

	/**
	 * Validar datos guardar solicitud credito.
	 *
	 * @param uid the uid
	 * @param peticion the peticion
	 * @return respuesta ValidarGuardarSolicitudRespuesta
	 */
	public ValidarGuardarSolicitudRespuesta validarGuardarSolicitudCredito(String uid, SolicitudSACGPeticion peticion);

	/**
	 * Validar guardar solicitud cec credito sol.
	 *
	 * @param uid the uid
	 * @param peticion the peticion
	 * @return the validar guardar solicitud cec respuesta
	 */
	public ValidarGuardarSolicitudCECRespuesta validarGuardarSolicitudCECCreditoSol(String uid, SolicitudSACGPeticion peticion);

	/**
	 * Enviar solicitud cec credito.
	 *
	 * @param uid the uid
	 * @param peticion the peticion
	 * @return the solicitudes respuesta
	 */
	public EnviarSolicitudCecRespuesta enviarSolicitudCEC(String uid, ObtenerDatosSolicitudPeticion peticion);

	/**
	 * Enviar solicitud cec credito para el Analista Documental.
	 *
	 * @param uid the uid
	 * @param peticion the peticion
	 * @return the solicitudes respuesta
	 */
	public EnviarSolicitudCecRespuesta enviarSolicitudCECDocumental(String uid, ObtenerDatosSolicitudPeticion peticion);

	/**
	 * Metodo que valida ultima parte del hold enviar solicitud cec tarea.
	 *
	 * @param uid the uid
	 * @param peticion the peticion
	 * @param contratoOV the contrato ov
	 * @return the enviar solicitud cec tarea respuesta
	 */
	public EnviarSolicitudCecTareaRespuesta enviarSolicitudCECTarea(String uid, ObtenerDatosSolicitudPeticion peticion,
			ContratoOV contratoOV);

	/**
	 * Obtener datos solicitud.
	 *
	 * @param uid the uid
	 * @param peticion the peticion
	 * @return the contrato ov
	 */
	public ObtenerDatosSolicitudRespuesta obtenerDatosSolicitud(String uid, ObtenerDatosSolicitudPeticion peticion);

	/**
	 * Actualizar desertor tarea.
	 *
	 * @param uid the uid
	 * @param peticion the actualizar desertor peticion
	 * @return the actualizar desertor respuesta
	 */
	public ActualizarDesertorRespuesta actualizarDesertorTarea(String uid, ActualizarDesertorPeticion peticion);

	/**
	 * Funcion para validar un contrato para renovacion financiada
	 *
	 * @param uid the uid
	 * @param peticion the peticion
	 * @return the string
	 */
	public ValidarContratoRespuesta validarContratoRenovacionFinanciada(String uid,
			ValidarContratoPeticion peticion);

	/**
	 * Generar Tarea Excepcion.
	 *
	 * @param uid the uid
	 * @param peticion the excepcion garantia peticion
	 * @param sesionExterna sesion externa de BD
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta generarTareaExcepcionGarantiaTarea(String uid,
			ExcepcionGarantiaPeticion peticion, SqlSession sesionExterna);

	/**
	 * Generar Complemento Tarea Excepcion.
	 *
	 * @param uid the uid
	 * @param peticion the excepcion garantia peticion
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta obtenerComplementoBuzonExcepcionGarantiaTarea(String uid,
			ExcepcionGarantiaPeticion peticion);

	/**
	 * Obtener Tarea Excepcion.
	 *
	 * @param uid the uid
	 * @param peticion the excepcion garantia peticion
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta obtenerBuzonExcepcionGarantiaTarea(String uid,
			ExcepcionGarantiaPeticion peticion);

	/**
	 * Obtener Tarea Excepcion por idTarea.
	 *
	 * @param uid the uid
	 * @param peticion the excepcion garantia peticion
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta obtenerBuzonExcepcionGarantiaPorIdTareaTarea(String uid,
			ExcepcionGarantiaPeticion peticion);

	/**
	 * Obtener Tarea Excepcion por tipoTarea.
	 *
	 * @param uid the uid
	 * @param peticion the excepcion garantia peticion
	 * @return the the excepcion garantia respuesta
	 */
	public BuzonOV obtenerBuzonExPorTipoTareaTarea(String uid,
			ExcepcionGarantiaPeticion peticion);

	/**
	 * Autorizar Tarea Excepcion.
	 *
	 * @param uid the uid
	 * @param peticion the excepcion garantia peticion
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta autorizaBuzonExcepcionTarea(String uid,
			ExcepcionGarantiaPeticion peticion);

	/**
	 * Rechazar Tarea Excepcion.
	 *
	 * @param uid the uid
	 * @param peticion the excepcion garantia peticion
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta rechazaBuzonExcepcionTarea(String uid,
			ExcepcionGarantiaPeticion peticion);

	/**
	 * Rechazar Tarea Excepcion.
	 *
	 * @param uid the uid
	 * @param peticion the excepcion garantia peticion
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta accionEnteradoIdTareaExcepcion(String uid,
			ExcepcionGarantiaPeticion peticion);

	/**
	 * Obtener Nombre Divisional Tarea Excepcion.
	 *
	 * @param uid the uid
	 * @param peticion the excepcion garantia peticion
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta obtenerExcepcionNombreDivisionalTarea(String uid,
			ExcepcionGarantiaPeticion peticion);

	/**
	 * Obtener Historico Planilla Observacion.
	 *
	 * @param uid the uid
	 * @param peticion the historico planilla observacion peticion
	 * @return the the historico planilla observacion respuesta
	 */
	public HistoricoPlanillaObservRespuesta obtenerHistoricoPlanillaObservTarea(String uid,
			HistoricoPlanillaObservPeticion peticion);

	/**
	 * Guardar solicitud planilla aprobacion.
	 *
	 * @param uid the uid
	 * @param peticion the peticion
	 * @param sesionExterna the peticion
	 * @return the solicitudes respuesta
	 */
	public SolicitudPlanillaAprobacionRespuesta guardarSolicitudPlanillaAprobacion(String uid,
			SolicitudPlanillaAprobacionPeticion peticion,  SqlSession sesionExterna);

	/**
	 * Obtener Integrantes Planilla Aprobacion.
	 *
	 * @param uid the uid
	 * @param peticion the integrantes planilla Aprobacion peticion
	 * @return the historico planilla Aprobacion respuesta
	 */
	public PlanillaAprobacionRespuesta obtenerIntegrantesEdoCtaYBuro(String uid,
			PlanillaAprobacionPeticion peticion);

	/**
	 * Consultar solicitudes planilla aprobacion almacenadas tarea.
	 *
	 * @param uid the uid
	 * @param peticion the peticion
	 * @return the solicitudes almacenadas respuesta
	 */
	public SolicitudesAlmacenadasRespuesta consultarSolicitudesPlanillaAprobacionAlmacenadasTarea(String uid,
			SolicitudPlanillaAprobacionPeticion peticion);

	/**
	 * Consultar solicitud motivo cancelacion tarea.
	 *
	 * @param uid the uid
	 * @param peticion the peticion motivo
	 * @return the solicitudes motivo cancelacion respuesta
	 */
	SolicitudesMotivoCancelacionRespuesta consultarSolicitudMotivoCancelacionTarea(
			String uid, SolicitudesMotivoCancelacionPeticion peticion);

	/**
	 * Consultar solicitud codigos por tipo codigo.
	 *
	 * @param uid the uid
	 * @param peticion the peticion codigos
	 * @return the lista codigos respuesta
	 */
	public CodigosRespuesta consultarCodigosPorTipoCodigoTarea(
			String uid, CodigosPeticion peticion);

	/**
	 * Consultar total desembolso por periodo
	 *
	 * @param uid the uid
	 * @param peticion the peticion desembolso
	 * @return the objeto desembolso respuesta
	 */
	public TotalDesembolsoRespuesta consultarTotalDesembolsoPorPeriodo(
			String uid, TotalDesembolsoPeticion peticion);

	/**
	 * Consultar semaforos por persona
	 *
	 * @param uid the uid
	 * @param peticion the peticion semaforos
	 * @return the lista semaforos respuesta
	 */
	public SemaforoSolicitudesRespuesta consultarSemaforosPorPersona(
			String uid, SemaforoSolicitudesPeticion peticion);

	/**
	 * Enviar una solicitud a verificacion telefonica.
	 * @param uid identificador unico de la transaccion
	 * @param peticion solicitud a enviar al call center
	 * @param sesion transaccional
	 * @return respuesta
	 */
	public ConsultaInformacionTelefonicaRespuesta enviarSolicitudVerificacionTelefonica(
		String uid, ConsultaInformacionTelefonicaPeticion peticion,
		SqlSession sesion);
	/**
	 * Consultar total autorizado por periodo
	 *
	 * @param uid the uid
	 * @param peticion the peticion desembolso
	 * @return the objeto desembolso respuesta
	 */
	public TotalDesembolsoRespuesta consultarTotalAutorizadoPorPeriodo(
			String uid, TotalDesembolsoPeticion peticion);
	/**
	 * Registrar el inicio de gestion de una solicitud CEC.
	 *
	 * @param uid the uid
	 * @param peticion the excepcion garantia peticion
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta registroInicioGestionCEC(
			String uid, ExcepcionGarantiaPeticion peticion);

	 /**
     * Consulta por contrato para renovacion de la simplificacion.
     * @param uid id de la transacci&eacute;n
     * @param peticion datos de entrada como el contrato.
     * @return ContratoRenovacionRespuesta respuesta de la peticion
     */
	public ContratoRenovacionRespuesta consultarContratoRenovacion(String uid, ContratoRenovacionPeticion peticion);
	 /**
     * Deveulve la informacion para llenar el reporte de solicitud  de credito comunal
     * @param uid id de la transacci&eacute;n
     * @param peticion datos de entrada como el contrato.
     * @return SimplificacionRenovacion respuesta de la peticion
     */
	public SimplificacionRenovacion informacionSolicitudCredito(String uid, ContratoRenovacionPeticion peticion);

	/**
	 * @param uid String
	 * @param acreditadosPeticion AcreditadosPeticion
	 * @return respuesta tipo PersonasCreditoRespuesta
	 */
	public PersonasCreditoRespuesta informacionPersonasCredito(String uid, PersonasCreditoPeticion acreditadosPeticion);

	/**
	 * Devuele la lista de documentos en blanco a imprimir
	 * @param peticion no lleva nada po el momento
	 * @param uid identificador unico
	 * @return lista documentos
	 */
	public ContratoRenovacionRespuesta obtenerDocumentosBlancos(String uid, ContratoRenovacionPeticion peticion);

	/**
	 * @param uid String
	 * @param solicitudPeticion SolicitudExcepcionDocumental
	 * @return respuesta tipo SolicitudExcepcionDocumentalRespuesta
	 */
	public SolicitudExcepcionDocumentalRespuesta registrarSolicitudAnalistaBCTarea(String uid,
			SolicitudExcepcionDocumental solicitudPeticion);

	/**
	 * Metodo para actualizar la solicitud de Analista Documental BC
	 * @param uid String
	 * @param solicitudesPeticion SolicitudesPeticion
	 * @return respuesta tipo SolicitudesRespuesta
	 */
	public SolicitudesRespuesta actualizaSolicitudAnalistaBCTarea(String uid,
			SolicitudesPeticion solicitudesPeticion);

	/**
	 * Metodo que se utiliza para validar el numero de integrantes para
	 * la pantalla del Analista Documental BC.
	 * @param uid String
	 * @param peticion SolicitudSACGPeticion
	 * @return solicitudesRespuesta
	 */
	public SolicitudesRespuesta validaNumeroIntegrantesAnalistaBCTarea(String uid,
			SolicitudSACGPeticion peticion);

	/**
	 * Metodo para eliminar una cliente de la pantalla Analista Documental BC
	 * @param uid Identificador unico
	 * @param solicitudPeticion solicitudPeticion
	 * @return SolicitudExcepcionDocumentalRespuesta
	 */
	public SolicitudExcepcionDocumentalRespuesta eliminaClienteAnalistaBCTarea(String uid,
			SolicitudExcepcionDocumental solicitudPeticion);

	/**
	 * m&eacute;todo para consultar si el contrato tiene 60 dias o mas de atraso
	 * @param peticion con los datos del contrato a consultar
	 * @param uid id de la transaccion
	 * @return ConsultaCatalogoRespuesta respuesta del contrato com mayor a 60 dias
	 */
	public ConsultaCatalogoRespuestaCIOF validacionContrato(String uid, ConsultaCatalogoPeticionCIOF peticion);

	/**
	 * Actualiza los esttus de la tarea excepcion campaña.
	 *
	 * @param uid the uid
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta actualizacionAutomaticaTareaCampana(String uid);

	/**
	 * Actualiza los estus de la tarea excepcion campaña.
	 *
	 * @param uid the uid
	 * @param peticion the excepcion garantia peticion
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta actualizarTareaCampana(String uid, ExcepcionGarantiaPeticion peticion);

		/**
	 * m&eacute;todo para consultar catalogos de Regiones
	 * @param uid  id de la transaccion unica
	 * @param peticion con los datos de la region
	 * @return ConsultaCatalogoRespuesta lista de regiones
	 */
	public ConsultaCatalogoRespuestaCIOF consultaCatalogoRegiones(String uid, ConsultaCatalogoPeticionCIOF peticion);


	/**
	 * método que obtiene el detalle de la solicitud con excepción de monto y cupo
	 * @param uid id unico de transaccion
	 * @param idTarea idTarea donde viene el numero de solicitud
	 * @return ExcepcionMontoCupoRespuesta
	 */
	public ExcepcionMontoCupoRespuesta consultaSolicitudExcepcionMontoCupoTarea(String uid, String idTarea);

	/**
	 * m&eacute;todo para consultar catalogos de Asesores
	 * de credito
	 * @param uid  id de la transaccion unica
	 * @param peticion con los datos de asesores
	 * @return ConsultaCatalogoRespuesta lista de asesores
	 */
	public ConsultaCatalogoRespuestaCIOF consultarCatalogoAsesoresCredito(String uid, ConsultaCatalogoPeticionCIOF peticion);

	/**
	 * m&eacute;todo para consultar catalogos de gerentes
	 * de sucursales
	 * @param uid  id de la transaccion unica
	 * @param peticion con los datos de gerentes de
	 * sucursales
	 * @return ConsultaCatalogoRespuesta lista de gerentes
	 * de sucursales
	 */
	public ConsultaCatalogoRespuestaCIOF consultarCatalogoGerenteSucursal(String uid, ConsultaCatalogoPeticionCIOF peticion);

	/**
	 * m&eacute;todo para consultar catalogos de gerentes
	 * de Regiones
	 * @param uid  id de la transaccion unica
	 * @param peticion con los datos de gerentes de
	 * regiones
	 * @return ConsultaCatalogoRespuesta lista de gerentes
	 * de regiones
	 */
	public ConsultaCatalogoRespuestaCIOF consultarCatalogoGerentesRegionales(String uid, ConsultaCatalogoPeticionCIOF peticion);

	/**
	 * m&eacute;todo para validar los productos
	 * de simplificacion de renovacion
	 * @param uid  id de la transaccion unica
	 * @param peticion con los datos del
	 * contrato
	 * @return ContratoRenovacionRespuesta
	 * mensajes de validaciones.
	 */
	public ContratoRenovacionRespuesta validarSimplificacionRenovacionProductos(String uid, ContratoRenovacionPeticion peticion);
	/**
	 * Metodo para validar los productos comunal y solidario con
	 * las reglas de renovaciones express, para simplificacion
	 * de renovacion 2
	 * @param uid para el log
	 * @param peticion contrato y solicitud
	 * @param sesion pasada por el metodo invocador
	 * @return monto maximo
	 */
	public ValidaIntegranteRespuesta calcularMontoPreAprobadoPersona(final String uid,
			final ValidaIntegrantePeticion peticion, final SqlSession sesion);

	/**
	 * Método que se utiliza para consultar las solicitudes que se van a reactivar
	 *
	 * @param uid uid
	 * @param peticion tipo ReactivarSolicitudesPeticion
	 * @return ReactivarSolicitudesRespuesta  tipo ReactivarSolicitudesRespuesta
	 */
	public ReactivarSolicitudesRespuesta consultaReactivarSolicitudesTarea(String uid, ReactivarSolicitudesPeticion peticion);

	/**
	 * Metodo que se utilizar para volver a insertar y reactivar la solicitud.
	 *
	 * @param uid uid
	 * @param solicitud solicitud a reactivar
	 * @param usuario que genera la reactivacion
	 * @return ReactivarSolicitudesRespuesta  tipo ReactivarSolicitudesRespuesta
	 */
	public ReactivarSolicitudesRespuesta insertaReactivarSolicitudesTarea(String uid, String solicitud, String usuario);

	/**
	 * Método que se utiliza para consultar las solicitudes que se ya se reactivaron y
	 * se van a mostrar en el ModuloCEC
	 *
	 * @param uid uid
	 * @param solicitud Consulta la solicitud si ya fue reactivada
	 * @return SolicitudesRespuesta  tipo SolicitudesRespuesta
	 */
	public SolicitudesRespuesta consultaReactivarSolicitudesModuloCECTarea(String uid, String solicitud);

	/**
	 * M&eacute;todo que envia un correo con el resumen de una solicitud
	 * @param uid  id &uacute;nico de transacci&oacute;n
	 * @param peticion datos de la peticion
	 * @return ExcepcionGarantiaRespuesta respuesta
	 */
	public ExcepcionGarantiaRespuesta enviarCorreoSolicitud(String uid, ResumenBuroPeticion peticion);

	/**
	 * M&eacute;todo que regresa la informacion del resumen de una solicitud
	 * @param uid  id &uacute;nico de transacci&oacute;n
	 * @param peticion datos d el apeticion
	 * @return ResumenBuroRespuesta respuesta
	 */
	public ResumenBuroRespuesta resumenSolicitudBuro(String uid, ResumenBuroPeticion peticion);

	/**
	 * Generar Tarea  para registrar la justificación de excepción de cupos y montos.
	 *
	 * @param uid the uid
	 * @param peticion justificación de excepción de cupos y montos
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta generarFirmaElectronicaTarea(String uid,	FirmaElectronicaPeticion peticion);

	/**
	 * M&eacute;todo que envia mensaje encaso de que la solicitud lleve mas de
	 * seis hora sin contestar en un horario habil de 8 a 20 horas
	 *
	 * @param uid the uid
	 * @param peticion observacion de firma electronica
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta mensajeTiempo(String uid, ResumenBuroPeticion peticion);

	/**
	 * Generar actualizacion de la tarea  para registrar la observacion y
	 * el codigo de rechazo de excepci&oacute;n de firma electr&oacute;nica.
	 *
	 * @param uid the uid
	 * @param peticion observacion de firma electronica
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta actualizarTareaFirmaElectronica(String uid, ResumenBuroPeticion peticion);

	/**
	 * M&eacute;todo que envia mensaje encaso de que que la solicitud este enproceso o alla sido rechazasa
	 *
	 * @param uid the uid
	 * @param peticion observaci&oacute;n de firma electr&oacute;nica
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta checarEstatusTareaFE(String uid, ResumenBuroPeticion peticion);

	/**
	 * Metodo que devuelve los comentarios de divisionales y mensajes del CEC para una tarea en cada atomo por
	 * el que pasa la solicitud.
	 * @param uid the uid
	 * @param peticion idTarea y solicitud
	 * @return los comentarios de divisionales y mensajes del CEC
	 */
	public ConsultaComentariosMensajesAtomosRespuesta consultaComentariosMnjsSolicitudSegimientoTarea(String uid, ConsultaComentariosMensajesAtomosPeticion peticion);

	/**
	 * M&eacute;todo que consulta la información del grupo de la planilla de observaciones
	 * @param uid the uid
	 * @param peticion  solicitud para la cual se requieren la informacion del grupo.
	 * @return respuesta con la información del grupo.
	 */
	public ConsultaSolicitudPlanillaObservacionesRespuesta consultaInformacionGrupoPlanillaTarea(String uid,
			ConsultaSolicitudPlanillaObservacionesPeticion peticion);

}
