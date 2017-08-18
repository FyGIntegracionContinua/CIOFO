package negocio.solicitudes;

import javax.jws.WebService;

import org.oasisopen.sca.annotation.Remotable;

import utilitario.mensajes.burocredito.ResumenBuroPeticion;
import utilitario.mensajes.burocredito.ResumenBuroRespuesta;
import utilitario.mensajes.comun.ConsultaCatalogoPeticionCIOF;
import utilitario.mensajes.comun.ConsultaCatalogoRespuestaCIOF;
import utilitario.mensajes.originacion.consulta.ContratoRenovacionPeticion;
import utilitario.mensajes.originacion.consulta.ContratoRenovacionRespuesta;
import utilitario.mensajes.originacion.consulta.SimplificacionRenovacion;
import utilitario.mensajes.solicitudes.ConsultaComentariosMensajesAtomosPeticion;
import utilitario.mensajes.solicitudes.ConsultaComentariosMensajesAtomosRespuesta;
import utilitario.mensajes.solicitudes.ConsultaSolicitudPlanillaObservacionesPeticion;
import utilitario.mensajes.solicitudes.ConsultaSolicitudPlanillaObservacionesRespuesta;
import utilitario.mensajes.solicitudes.ExcepcionGarantiaPeticion;
import utilitario.mensajes.solicitudes.ExcepcionGarantiaRespuesta;
import utilitario.mensajes.solicitudes.ExcepcionMontoCupoRespuesta;
import utilitario.mensajes.solicitudes.FirmaElectronicaPeticion;
import utilitario.mensajes.solicitudes.PersonasCreditoPeticion;
import utilitario.mensajes.solicitudes.PersonasCreditoRespuesta;
import utilitario.mensajes.solicitudes.ReactivarSolicitudesPeticion;
import utilitario.mensajes.solicitudes.ReactivarSolicitudesRespuesta;
import utilitario.mensajes.solicitudes.SolicitudExcepcionDocumental;
import utilitario.mensajes.solicitudes.SolicitudExcepcionDocumentalRespuesta;
import utilitario.mensajes.solicitudes.SolicitudesRespuesta;
import utilitario.reglas.solicitudes.PeticionReglaIncremento;
import utilitario.reglas.solicitudes.RespuestaReglaIncremento;
import utilitario.reglas.solicitudes.ValidarIntegranteSolicitudPeticion;
import utilitario.reglas.solicitudes.ValidarIntegranteSolicitudRespuesta;

/**
 * @author rguadarramac
 * @version 1.0
 */
@Remotable
@WebService(name = "SolicitudesCredito", targetNamespace = "http://fisa.com.mx/CIOF/SolicitudesCredito/V1.0")
public interface SolicitudesCredito {

	/**
	 * Inserta Solicitud en caso de que en la petici&oacute;n no tenga ID, si trae ID modifica dicha Solicitud.
	 * @return respuestaXML
	 * @param peticion parametro de peticion tipo String
	 */
	public String registrarSolicitud(String peticion);


	/**
	 * @param peticion .
	 * @return String
	 */
	public String cancelarSolicitud(String peticion);

	/**
	 * @param peticion .
	 * @return String
	 */
	public String consultarSolicitud(String peticion);

	/**
	 * @param peticion .
	 * @return String
	 */
	public String registrarAtomos(String peticion);

	/**
	 * @param peticion .
	 * @return String
	 */
	public String registrarSolicitudBuro(String peticion);

	/**
	 * @param peticion .
	 * @return String
	 */
	public String consultarSolicitudBuro(String peticion);

	/**
	 * @param peticion .
	 * @return String
	 */
	public String obtenerDatosSolicitudEncabezado(String peticion);

	/**
	 * @param peticion .
	 * @return String
	 */
	public String registrarSolicitudMinima(String peticion);

	/**
	 * @param peticion .
	 * @return String
	 */
	public String ProcGetAcreditados(String peticion);

	/**
	 * @param peticion .
	 * @return String
	 */
	public String ProcGetSolicitud(String peticion);

	/**
	 * @param peticion .
	 * @return String
	 */
	public String ProcGetSolicitudesTemp(String peticion);

	/**
	 * @param peticion .
	 * @return String
	 */
	public String ProcGetRepSolicitudes(String peticion);

	/**
	 * @param peticion .
	 * @return String
	 */
	public String ProcGetMultiClaveCte(String peticion);

	/**
	 * @param peticion .
	 * @return String
	 */
	public String ProcGetClaveCteUnico(String peticion);

	/**
	 * @param peticion .
	 * @return String
	 */
	public String ProcGetDatosAuditoria(String peticion);

	/**
	 * @param peticion .
	 * @return String
	 */
	public String ProcEliminacionCredito(String peticion);

	/**
	 * @param peticion .
	 * @return String
	 */
	public String ProcGuardarCreditoTemp(String peticion);

	/**
	 * @param peticion .
	 * @return String
	 */
	public String Get_AccessPerfil_FUN(String peticion);

	/**
	 * @param peticion .
	 * @return String
	 */
	public String Get_Submenus_FUN(String peticion);

	/**
	 * @param peticion .
	 * @return String
	 */
	public String ProcGetSolicitudes(String peticion);

	/**
	 * @param peticion .
	 * @return String
	 */
	public String ProcCreditoSolicitud(String peticion);

	/**
	 * @param peticion .
	 * @return String
	 */
	public String consultarSolicitudCredito(String peticion);
	/**
	 * Registrar solicitud buro general.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String registrarSolicitudBuroGeneral(String peticion);

	/**
	 * Consulta pool personas.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultaPoolPersonas(String peticion);

	/**
	 * Modificar pool personas.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String modificarPoolPersonas(String peticion);

	/**
	 * Carga trabajo analista.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String cargaTrabajoAnalista(String peticion);

	/**
	 * Reasignar carga trabajo analista.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String reasignarCargaTrabajoAnalista(String peticion);

	/**
	 * Consultar atomos.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarAtomos(String peticion);

	/**
	 * Consultar status creditos.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarStatusCreditos(String peticion);

	/**
	 * Consultar planilla observaciones.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarPlanillaObservaciones(String peticion);

	/**
	 * Registrar planilla observaciones.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String registrarPlanillaObservaciones(String peticion);

	/**
	 * Cancelar solicitud evaluacion crediticia.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String cancelarSolicitudEvaluacionCrediticia(String peticion);

	/**
	 * Terminar solicitud evaluacion crediticia.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String terminarSolicitudEvaluacionCrediticia(String peticion);

	/**
	 * Enviar planilla observaciones sucursal.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String enviarPlanillaObservacionesSucursal(String peticion);

	/**
	 * Corregir planilla observaciones sucursal.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String corregirPlanillaObservacionesSucursal(String peticion);

	/**
	 * @param peticion String
	 * @return respuesta tipo String
	 */
	public String reporteSolicitudes(String peticion);

	/**
	 * @param peticion String
	 * @return respuesta tipo String
	 */
	public String reporteBuroExterno(String peticion);

	/**
	 * @param peticion String
	 * @return respuesta tipo String
	 */
	public String reporteAsignaciones(String peticion);

	/**
	 * @param peticion String
	 * @return respuesta tipo String
	 */
	public String reporteReasignaciones(String peticion);

	/**
	 * @param peticion String
	 * @return respuesta tipo String
	 */
	public String reporteSucursalesClasificacion(String peticion);


	/**
	 * @param peticion String
	 * @return respuesta tipo String
	 */
	public String validarDatosSolicitud(String peticion);

	/**
	 * Validar tasa interes.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String validarTasaGuardar(String peticion);

	/**
	 * Validar tasa confirmar.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String validarTasaConfirmar(String peticion);


	/**
	 * @param peticion para calcular requerimiento
	 * @return RespuestaReglaIncremento
	 */
	public RespuestaReglaIncremento calculaIncrementoMonto(PeticionReglaIncremento peticion);

	/**
	 * Validar los integrantes que pretenden ser agregados a una solicitud.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String validaIntegranteSolicitud(String peticion);

	/**
	 * Metodo para validar cuando se agrega un integrante en una solicitud.
	 * @param peticion contiene los datos necesarios para realizar la validacion.
	 * @return regresa la respuesta para saber si es posible agregar el cliente o no a la solicitu.
	 */
	public ValidarIntegranteSolicitudRespuesta  validarAgregarIntegranteSolicitud(ValidarIntegranteSolicitudPeticion peticion);

	/**
	 * Guardar solicitud credito.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String guardarSolicitudCredito(String peticion);

	/**
	 * Guardar solicitud cec credito.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String enviarSolicitudCEC(String peticion);

	/**
	 * Guardar solicitud cec credito para el Analista Documental.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String enviarSolicitudCECDocumental(String peticion);

	/**
	 * Generar tarea excepcion garantia
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String generarTareaExcepcionGarantia(String peticion);

	/**
	 * Obtener Tarea Excepcion.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String obtenerBuzonExcepcionGarantia(String peticion);

	/**
	 * Obtener Tarea Excepcion.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String obtenerBuzonExcepcionGarantiaPorIdTarea(String peticion);

	/**
	 * Obtener Tarea Excepcion por tipo tarea.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String obtenerBuzonExPorTipoTarea(String peticion);

	/**
	 * Autorizar Tarea Excepcion.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String autorizaBuzonExcepcion(String peticion);

	/**
	 * Rechazar Tarea Excepcion.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String rechazaBuzonExcepcion(String peticion);

	/**
	 * Funcion para validar un contrato para renovacion financiada
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
   public String validarContratoRenovacionFinanciada(String peticion);

	/**
	 * Obtener Historico Planilla Observaciones
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String obtenerHistoricoPlanillaObserv(String peticion);

	/**
	 * Obtener Integrantes Planilla Aprobaciones
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String obtenerIntegrantesEdoCtaYBuro(String peticion);

	/**
	 * Guardar planilla aprobacion.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String guardarPlanillaAprobacion(String peticion);

	/**
	 * Guardar planilla aprobacion generadas.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarPlanillaAprobacionGeneradas(String peticion);


	/**
	 * Consultar solicitud motivo cancelacion.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarSolicitudMotivoCancelacion(String peticion);

	/**
	 * Consultar lista de codigos por tipo codigo.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarCodigosPorTipoCodigo(String peticion);

	/**
	 * Consultar total de desembolso en un periodo.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarTotalDesembolsoPorPeriodo(String peticion);

	/**
	 * Consultar total semaforos de la persona.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarSemaforosPorPersona(String peticion);
	/**
	 * Enviar una solicitud a verificacion telefonica.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String enviarSolicitudVerificacionTelefonica(String peticion);
	/**
	 * Consultar total de autorizado en un periodo.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarTotalAutorizadoPorPeriodo(String peticion);

	//MIGRACION MODULO CEC
	/**
	 * Consultar buzon de tareas.
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarBuzonTareas(String peticion);

	/**
	 * Consultar atomos por solicitud.
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarAtomosCEC(String peticion);

	/**
	 * Consultar observaciones por solicitud.
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarPlanillaObservacionesCEC(String peticion);

	/**
	 * Cancelar solicitud desde el modulo de aprobacion del CEC
	 * @param peticion the peticion
	 * @return the string
	 */
	public String cancelarSolicitudCEC(String peticion);

	/**
	 * Confirmar solicitud desde el modulo de aprobacion del CEC
	 * @param peticion the peticion
	 * @return the string
	 */
	public String confirmarSolicitud(String peticion);

	/**
	 * Enviar observaciones a sucursal desde el modulo de aprobacion del CEC
	 * @param peticion the peticion
	 * @return the string
	 */
	public String enviarPlanillaObservacionesSucursalCEC(String peticion);

	/**
	 * Consultar Planilla de Aprobacion
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarPlanillaAprobacion(String peticion);

	/**
	 * Correccion de observaciones por la sucursal
	 * @param peticion the peticion
	 * @return the string
	 */
	public String correccionPlanillaObservacionesSucursal(String peticion);

	/**
	 * Consultar Planilla de Aprobacion en formato JSON
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarPlanillaAprobacionJson(String peticion);

	/**
	 * Registro de inicio de gestion del CEC por solicitud
	 * @param peticion the peticion
	 * @return the string
	 */
	public String registroInicioGestionCEC(String peticion);

	/**
	 * Obtener la informacion de la tarea de excepcion de garantia
	 * @param peticion the peticion
	 * @return the string
	 */
	public String obtenerBuzonExcepcionGarantiaPorIdTareaCEC(String peticion);

	/**
	 * Dar por enterada la sucursal de la tarea de excepcion de garantia
	 * @param peticion the peticion
	 * @return the string
	 */
	public String accionEnteradoIdTareaExcepcion(String peticion);

	/**
	 * Obtener el nombre del Divisional que autorizo la excepcion de garantia
	 * @param peticion the peticion
	 * @return the string
	 */
	public String obtenerExcepcionNombreDivisional(String peticion);

	/**
	 * Generar la tarea de excepcion de garantia
	 * @param peticion the peticion
	 * @return the string
	 */
	public String generarTareaExcepcionGarantiaModulo(String peticion);

	/**
	 * Obtener las tareas de excepcion de garantia
	 * @param peticion the peticion
	 * @return the string
	 */
	public String obtenerBuzonExcepcionGarantiaModulo(String peticion);

	/**
	 * Obtener las tareas por tipo tarea
	 * @param peticion the peticion
	 * @return the string
	 */
	public String obtenerBuzonExPorTipoTareaModulo(String peticion);

	/**
	 * Obtener complemento de las tareas de excepcion garantia
	 * @param peticion the peticion
	 * @return the string
	 */
	public String obtenerComplementoBuzonExcepcionGarantia(String peticion);

	/**
	 * Autoriza tarea de excepcion garantia
	 * @param peticion the peticion
	 * @return the string
	 */
	public String autorizaBuzonExcepcionModulo(String peticion);

	/**
	 * Rechaza tarea de excepcion garantia
	 * @param peticion the peticion
	 * @return the string
	 */
	public String rechazaBuzonExcepcionModulo(String peticion);

	/**
	 * Obtener creditos anteriores para mostrar en la tarea de excepcion garantia
	 * @param peticion the peticion
	 * @return the string
	 */
	public String obtenerCreditosAnteriores(String peticion);

	/**
     * Consulta por contrato para renovacion de la simplificacion.
     * @param peticion datos de entrada como el contrato.
     * @return ContratoRenovacionRespuesta respuesta de la peticion
     */
	public ContratoRenovacionRespuesta consultarContratoRenovacion(ContratoRenovacionPeticion peticion);
	/**
	 * Deveulve la informacion para llenar el reporte de solicitud  de credito comunal
	 * @param peticion datos de entrada como el contrato
	 * @return ImpresionFormatos respuesta de la peticion
	 */
	public SimplificacionRenovacion informacionSolicitudCredito(ContratoRenovacionPeticion peticion);

	/**
	 * Deveulve la informacion del último credito para personas
	 * @param peticion datos de entrada para la búsquedas de persona
	 * @return PersonasCreditoRespuesta respuesta de la peticion
	 */
	public PersonasCreditoRespuesta consultaPersonasCredito(PersonasCreditoPeticion peticion);

	/**
	 * Devuele la lista de documentos en blanco a imprimir
	 * @param peticion no lleva nada po el momento
	 * @return lista documentos
	 */
	public ContratoRenovacionRespuesta obtenerDocumentosBlancos(ContratoRenovacionPeticion peticion);

	/**
	 * Actualiza la pantalla de Analista Documental BC.
	 * @param peticion parametro de peticion tipo SolicitudExcepcionDocumental
	 * @return SolicitudExcepcionDocumentalRespuesta
	 */
	public SolicitudExcepcionDocumentalRespuesta registrarSolicitudAnalistaBC(SolicitudExcepcionDocumental peticion);

	/**
	 * Metodo para actualizar la solicitud de Analista Documental BC
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String actualizaSolicitudAnalistaBC(String peticion);

	/**
	 * Metodo que se utiliza para validar el numero de integrantes para
	 * la pantalla del Analista Documental BC.
	 * @param peticion SolicitudSACGPeticion
	 * @return ValidarGuardarSolicitudCECRespuesta
	 */
	public String validaNumeroIntegrantesAnalistaBC(String peticion);


	/**
	 * Consultar buzon de Analista Documental.
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarBuzonAnalistaDocumental(String peticion);



	/**
	 * Metodo para eliminar una cliente de la pantalla Analista Documental BC
	 * @param solicitudPeticion solicitudPeticion
	 * @return SolicitudExcepcionDocumentalRespuesta
	 */
	public SolicitudExcepcionDocumentalRespuesta eliminaClienteAnalistaBC(SolicitudExcepcionDocumental solicitudPeticion);

	/**
	 * Actualiza los estus de la tarea excepcion campaña.
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta actualizacionAutomaticaTareaCampana();

	/**
	 * Actualiza los estus de la tarea excepcion campaña.
	 * @param peticion the excepcion garantia peticion
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta actualizarTareaCampana(ExcepcionGarantiaPeticion peticion);

	/**
	 * Metodo para obtener catalogo de regiones
	 * @param peticion ConsultaCatalogoPeticionCIOF
	 * @return ExcepcionMontoCupoRespuesta
	 */
	public ConsultaCatalogoRespuestaCIOF consultaCatalogoRegiones(ConsultaCatalogoPeticionCIOF peticion);

	/**
	 * Metodo para obtener el detalle de una solicitud con excepción de cupo y monto
	 * @param idTarea idTarea
	 * @return ExcepcionMontoCupoRespuesta
	 */
	public ExcepcionMontoCupoRespuesta consultaSolicitudExcepcionMontoCupo(String idTarea);

	/**
	 * Metodo para obtener calatolo de Asesores
	 * de credito
	 * @param peticion tipo de catalogo
	 * @return ConsultaCatalogoRespuestaCIOF
	 */
	public ConsultaCatalogoRespuestaCIOF consultarCatalogoAsesoresCredito(ConsultaCatalogoPeticionCIOF peticion);

	/**
	 * Metodo para obtener calatolo de Gerentes
	 * Regionales
	 * @param peticion tipo de catalogo
	 * @return ConsultaCatalogoRespuestaCIOF
	 */
	public ConsultaCatalogoRespuestaCIOF consultarCatalogoGerentesRegionales(ConsultaCatalogoPeticionCIOF peticion);

	/**
	 * Metodo para obtener calatolo de Gerentes
	 * de Sucursal
	 * @param peticion tipo de catalogo
	 * @return ConsultaCatalogoRespuestaCIOF
	 */
	public ConsultaCatalogoRespuestaCIOF consultarCatalogoGerentesSucursal(ConsultaCatalogoPeticionCIOF peticion);

	/**
	 * Validacion de simplificacion de renovaciones para producto
	 * OPORTUNIDAD
	 * @param peticion datos del contrato a validar
	 * @return ContratoRenovacionRespuesta respuesta de la peticion
	 */
	public ContratoRenovacionRespuesta validarSimplificacionRenovacionProductos(ContratoRenovacionPeticion peticion);

	/**
	 * Método que se utiliza para consultar las solicitudes que se van a reactivar
	 *
	 * @param uid uid
	 * @param peticion tipo ReactivarSolicitudesPeticion
	 * @return ReactivarSolicitudesRespuesta  tipo ReactivarSolicitudesRespuesta
	 */
	public ReactivarSolicitudesRespuesta consultaReactivarSolicitudes(String uid, ReactivarSolicitudesPeticion peticion);

	/**
	 * Metodo que se utilizar para volver a insertar y reactivar la solicitud.
	 *
	 * @param uid uid
	 * @param solicitud solicitud a reactivar
	 * @param usuario que genera la reactivacion
	 * @return ReactivarSolicitudesRespuesta  tipo ReactivarSolicitudesRespuesta	 */
	public ReactivarSolicitudesRespuesta insertaReactivarSolicitudes(String uid, String solicitud, String usuario);

	/**
	 * Método que se utiliza para consultar las solicitudes que se ya se reactivaron y
	 * se van a mostrar en el ModuloCEC
	 *
	 * @param uid uid
	 * @param solicitud Consulta la solicitud si ya fue reactivada
	 * @return SolicitudesRespuesta  tipo SolicitudesRespuesta
	 */
	public SolicitudesRespuesta consultaReactivarSolicitudesModuloCEC(String uid, String solicitud);

	/**
	 * M&eacute;todo que envia un correo con el resumen de una solicitud
	 * @param peticion datos de la peticion
	 * @return ExcepcionGarantiaRespuesta respuesta
	 */
	public ExcepcionGarantiaRespuesta enviarCorreoSolicitud(ResumenBuroPeticion peticion);

	/**
	 * M&eacute;todo que regresa la informacion del resumen de una solicitud
	 * @param peticion datos d el apeticion
	 * @return ResumenBuroRespuesta respuesta
	 */
	public ResumenBuroRespuesta resumenSolicitudBuro(ResumenBuroPeticion peticion);

	/**
	 * Generar Tarea  para registrar la justificación de excepción de cupos y montos.
	 * @param peticion justificación de excepción de cupos y montos
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta generarFirmaElectronica(FirmaElectronicaPeticion peticion);

	/**
	 * Metodo que envia mensaje encaso de que la solicitud lleve mas de
	 * seis hora sin contestar en un horario habil de 8 a 20 horas
	 * @param peticion observacion de firma electronica
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta mensajeTiempo(ResumenBuroPeticion peticion);

	/**
	 * Generar actualizacion de la tarea  para registrar la observacion y
	 * el codigo de rechazo de excepción de firma electronica.
	 *
	 * @param peticion observacion de firma electronica
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta actualizarTareaFirmaElectronica(ResumenBuroPeticion peticion);

	/**
	 * M&eacute;todo que envia mensaje encaso de que que la solicitud este enproceso o alla sido rechazasa
	 * @param peticion observaci&oacute;n de firma electr&oacute;nica
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta checarEstatusTareaFE(ResumenBuroPeticion peticion);

	/**
	 * M&eacute;todo que consulta los comentarios de divisionales y mensajes del CEC en el seguimiento de solicitudes.
	 * @param peticion contiene el idTarea y solicitud para la cual se requieren los comentarios.
	 * @return respuesta con los comentarios de divisionales y mensajes del CEC
	 */
	public ConsultaComentariosMensajesAtomosRespuesta consultaComentariosMensajesAtomosSolicitudSeguimiento(
			ConsultaComentariosMensajesAtomosPeticion peticion);

	/**
	 * M&eacute;todo que consulta la información del grupo de la planilla de observaciones
	 * @param peticion contiene la solicitud para la cual se requieren la informacion del grupo.
	 * @return respuesta con la información del grupo.
	 */
	public ConsultaSolicitudPlanillaObservacionesRespuesta consultaInformacionGrupoPlanilla(
			ConsultaSolicitudPlanillaObservacionesPeticion peticion);
}

