package negocio.solicitudes;


import java.text.Normalizer;

import org.oasisopen.sca.annotation.Reference;

import tarea.burocredito.BuroCreditoTarea;
import tarea.consultas.Consultas;
import tarea.solicitudes.SolicitudesCreditoTarea;
import transformador.Transformador;
import utilitario.buzon.BuzonOV;
import utilitario.buzon.ConsultaBuzonPeticion;
import utilitario.buzon.TareaOV;
import utilitario.comun.GUIDGenerator;
import utilitario.log.LogHandler;
import utilitario.mensajes.burocredito.BuroCreditoClienteDetalleGrupoPeticion;
import utilitario.mensajes.burocredito.BuroCreditoClienteDetalleGrupoRespuesta;
import utilitario.mensajes.burocredito.ResumenBuroPeticion;
import utilitario.mensajes.burocredito.ResumenBuroRespuesta;
import utilitario.mensajes.comun.ConsultaCatalogoPeticionCIOF;
import utilitario.mensajes.comun.ConsultaCatalogoRespuestaCIOF;
import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.impresiondocs.comun.ContratoPeticionKit;
import utilitario.mensajes.originacion.aprobacion.PlanillaAprobacionPeticionDTO;
import utilitario.mensajes.originacion.aprobacion.PlanillaAprobacionRespuestaDTO;
import utilitario.mensajes.originacion.consulta.ContratoRenovacionPeticion;
import utilitario.mensajes.originacion.consulta.ContratoRenovacionRespuesta;
import utilitario.mensajes.originacion.consulta.SimplificacionRenovacion;
import utilitario.mensajes.solicitudes.*;
import utilitario.mensajes.verificacion.telefonica.ConsultaInformacionTelefonicaPeticion;
import utilitario.mensajes.verificacion.telefonica.ConsultaInformacionTelefonicaRespuesta;
import utilitario.reglas.solicitudes.PeticionReglaIncremento;
import utilitario.reglas.solicitudes.RespuestaReglaIncremento;
import utilitario.reglas.solicitudes.ValidaIntegrantePeticion;
import utilitario.reglas.solicitudes.ValidaIntegranteRespuesta;
import utilitario.reglas.solicitudes.ValidarIntegranteSolicitudPeticion;
import utilitario.reglas.solicitudes.ValidarIntegranteSolicitudRespuesta;
import utilitario.reglas.solicitudes.ValidarTasaInteresPeticion;
import utilitario.reglas.solicitudes.ValidarTasaInteresRespuesta;

/**
 * @author rguadarramac
 * @version 1.0
 */
public class SolicitudesCreditoImpl implements SolicitudesCredito {

	/**
	 * Variable SolicitudesCreditoTarea
	 */
	private SolicitudesCreditoTarea solicitudesCredito;
	/**
	 * Variable transformador
	 */
	private Transformador transformador;

	/**
	 * Variable consultas
	 */
	private Consultas consultas;

	/**
	 * BuroCreditoTarea SCA
	 */
	private BuroCreditoTarea buroCreditoTarea;

	/**
	 * @param solicitudesCredito de tipo SolicitudesCreditoTarea
	 * @param transformador de tipo Transformador
	 */
	public SolicitudesCreditoImpl(
			@Reference(name = "solicitudesCredito") SolicitudesCreditoTarea solicitudesCredito,
			@Reference(name = "transformador") Transformador transformador,
			@Reference(name = "consultas") Consultas consultas,
			@Reference(name = "buroCreditoTarea") BuroCreditoTarea buroCreditoTarea
			) {
		this.solicitudesCredito = solicitudesCredito;
		this.transformador = transformador;
		this.consultas = consultas;
		this.buroCreditoTarea = buroCreditoTarea;
 		}


	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String registrarSolicitud(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "registrarSolicitud: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {SolicitudesOV.class,
									SolicitudIntegrantesOV.class,
									SolicitudesPeticion.class,
									SolicitudesRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final SolicitudesPeticion solicitudesPeticion =
			(SolicitudesPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "registrarSolicitud: - Datos de entrada : " + solicitudesPeticion);

		//Llamado a funci?n principal
		final SolicitudesRespuesta respuesta = solicitudesCredito.registrarSolicitudTarea(uid, solicitudesPeticion);
		LogHandler.info(uid, getClass(), "registrarSolicitud: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "registrarSolicitud: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String cancelarSolicitud(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "cancelarSolicitud: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {SolicitudesPeticion.class,
									SolicitudesRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final SolicitudesPeticion solicitudesPeticion =
			(SolicitudesPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "cancelarSolicitud: - Datos de entrada : " + solicitudesPeticion);

		//Llamado a funci?n principal
		final SolicitudesRespuesta respuesta = solicitudesCredito.cancelarSolicitudTarea(uid, null, solicitudesPeticion);
		LogHandler.info(uid, getClass(), "cancelarSolicitud: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "cancelarSolicitud: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String consultarSolicitud(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "consultarSolicitud: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {SolicitudesOV.class,
									SolicitudIntegrantesOV.class,
									SolicitudesPeticion.class,
									SolicitudesRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final SolicitudesPeticion solicitudesPeticion =
			(SolicitudesPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultarSolicitud: - Datos de entrada : " + solicitudesPeticion);

		//Llamado a funci?n principal
		final SolicitudesRespuesta respuesta = solicitudesCredito.consultarSolicitudTarea(uid, solicitudesPeticion);
		LogHandler.info(uid, getClass(), "consultarSolicitud: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "consultarSolicitud: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String registrarAtomos(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "registrarAtomos - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {AtomosOV.class,
									AtomosRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final AtomosOV   atomosPeticion =
			(AtomosOV) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "registrarAtomos - Datos de entrada : " + atomosPeticion);

		//Llamado a funci?n principal
		final AtomosRespuesta respuesta = solicitudesCredito.registrarAtomosTarea(uid, null, atomosPeticion);
		LogHandler.info(uid, getClass(), "registrarAtomos - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "registrarAtomos - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String registrarSolicitudBuro(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "registrarSolicitudBuro - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {SolicitudBuroOV.class,
									SolicitudBuroRespuesta.class,
									SolicitudBuroClienteOV.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final SolicitudBuroOV   solicitudBuroPeticion =
			(SolicitudBuroOV) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "registrarSolicitudBuro - Datos de entrada : " + solicitudBuroPeticion);

		//Llamado a funci?n principal
		final SolicitudBuroRespuesta respuesta =
				solicitudesCredito.registrarSolicitudBuroTarea(uid, solicitudBuroPeticion);
		LogHandler.info(uid, getClass(), "registrarSolicitudBuro - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "registrarSolicitudBuro - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String consultarSolicitudBuro(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "consultarSolicitudBuro - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {SolicitudBuroOV.class,
									ConsultaSolicitudBuroRespuesta.class,
									SolicitudBuroClienteOV.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final SolicitudBuroOV   consultaSolicitudBuroPeticion =
			(SolicitudBuroOV) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultarSolicitudBuro - Datos de entrada : " + consultaSolicitudBuroPeticion);

		//Llamado a funci?n principal
		final ConsultaSolicitudBuroRespuesta respuesta =
				solicitudesCredito.consultaSolicitudBuroTarea(uid, consultaSolicitudBuroPeticion);

		LogHandler.info(uid, getClass(), "consultarSolicitudBuro - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "consultarSolicitudBuro - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String obtenerDatosSolicitudEncabezado(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "obtenerDatosSolicitudEncabezado - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {SolicitudBuroOV.class,
									EncabezadoSolicitudRespuesta.class,

									EncabezadoRespuesta.class};


		//Conversion de XML a Object
		final SolicitudBuroOV   obtenerDatosSolicitudEncabezadoPeticion =
			(SolicitudBuroOV) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "obtenerDatosSolicitudEncabezado - Datos de entrada : "
						+ obtenerDatosSolicitudEncabezadoPeticion);

		//Llamado a funci?n principal
		final EncabezadoSolicitudRespuesta respuesta
					= solicitudesCredito.obtenerDatosSolicitudEncabezadoTarea(uid, obtenerDatosSolicitudEncabezadoPeticion);
		LogHandler.info(uid, getClass(), "obtenerDatosSolicitudEncabezado - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "obtenerDatosSolicitudEncabezado - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String registrarSolicitudMinima(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "cancelarSolicitudOrcl - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {SolicitudesOV.class,
									SolicitudesRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final SolicitudesOV   solicitudMinimaPeticion =
			(SolicitudesOV) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "cancelarSolicitudOrcl - Datos de entrada : " + solicitudMinimaPeticion);

		//Llamado a funci?n principal
		final SolicitudesRespuesta respuesta
				= solicitudesCredito.registrarSolicitudMinimaTarea(uid, null, solicitudMinimaPeticion);
		LogHandler.info(uid, getClass(), "cancelarSolicitudOrcl - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "cancelarSolicitudOrcl - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String ProcGetAcreditados(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "ProcGetAcreditados: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {Acreditados.class,
									AcreditadosPeticion.class,
									AcreditadosRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final AcreditadosPeticion acreditadosPeticion =
			(AcreditadosPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "ProcGetAcreditados: - Datos de entrada : " + acreditadosPeticion);

		//Llamado a funci?n principal
		final AcreditadosRespuesta respuesta = solicitudesCredito.procGetAcreditadosTarea(uid, acreditadosPeticion);
		LogHandler.info(uid, getClass(), "ProcGetAcreditados: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "ProcGetAcreditados: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String ProcGetSolicitud(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "ProcGetSolicitud: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ContratoPeticionKit.class,
									SolicitudIDRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ContratoPeticionKit contratoPeticionKit =
			(ContratoPeticionKit) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "ProcGetSolicitud: - Datos de entrada : " + contratoPeticionKit);

		//Llamado a funci?n principal
		final SolicitudIDRespuesta respuesta = solicitudesCredito.procGetSolicitudTarea(uid, contratoPeticionKit);
		LogHandler.info(uid, getClass(), "ProcGetSolicitud: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "ProcGetSolicitud: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String ProcGetSolicitudesTemp(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "ProcGetSolicitudesTemp: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {SolicitudesTemp.class,
									SolicitudesTempPeticion.class,
									SolicitudesTempRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final SolicitudesTempPeticion solicitudesTempPeticion =
			(SolicitudesTempPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "ProcGetSolicitudesTemp: - Datos de entrada : " + solicitudesTempPeticion);

		//Llamado a funci?n principal
		final SolicitudesTempRespuesta respuesta = solicitudesCredito.procGetSolicitudesTempTarea(uid, solicitudesTempPeticion);
		LogHandler.info(uid, getClass(), "ProcGetSolicitudesTemp: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "ProcGetSolicitudesTemp: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String ProcGetRepSolicitudes(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "ProcGetRepSolicitudes: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {SolicitudesRep.class,
									SolicitudesRepPeticion.class,
									SolicitudesRepRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final SolicitudesRepPeticion solicitudesRepPeticion =
			(SolicitudesRepPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "ProcGetRepSolicitudes: - Datos de entrada : " + solicitudesRepPeticion);

		//Llamado a funci?n principal
		final SolicitudesRepRespuesta respuesta = solicitudesCredito.procGetRepSolicitudesTarea(uid, solicitudesRepPeticion);
		LogHandler.info(uid, getClass(), "ProcGetRepSolicitudes: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "ProcGetRepSolicitudes: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String ProcGetMultiClaveCte(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "ProcGetMultiClaveCte: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ClaveCliente.class,
									MultiClaveCtePeticion.class,
									MultiClaveCteRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final MultiClaveCtePeticion multiClaveCtePeticion =
			(MultiClaveCtePeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "ProcGetMultiClaveCte: - Datos de entrada : " + multiClaveCtePeticion);

		//Llamado a funci?n principal
		final MultiClaveCteRespuesta respuesta = solicitudesCredito.procGetMultiClaveCteTarea(uid, multiClaveCtePeticion);
		LogHandler.info(uid, getClass(), "ProcGetMultiClaveCte: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "ProcGetMultiClaveCte: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String ProcGetClaveCteUnico(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "ProcGetClaveCteUnico: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ClaveCliente.class,
									ClaveCteUnicoPeticion.class,
									ClaveCteUnicoRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ClaveCteUnicoPeticion claveCteUnicoPeticion =
			(ClaveCteUnicoPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "ProcGetClaveCteUnico: - Datos de entrada : " + claveCteUnicoPeticion);

		//Llamado a funci?n principal
		final ClaveCteUnicoRespuesta respuesta = solicitudesCredito.procGetClaveCteUnicoTarea(uid, claveCteUnicoPeticion);
		LogHandler.info(uid, getClass(), "ProcGetClaveCteUnico: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "ProcGetClaveCteUnico: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String ProcGetDatosAuditoria(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "ProcGetDatosAuditoria: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {Auditoria.class,
									AuditoriaPeticion.class,
									AuditoriaRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final AuditoriaPeticion auditoriaPeticion =
			(AuditoriaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "ProcGetDatosAuditoria: - Datos de entrada : " + auditoriaPeticion);

		//Llamado a funci?n principal
		final AuditoriaRespuesta respuesta = solicitudesCredito.procGetDatosAuditoriaTarea(uid, auditoriaPeticion);
		LogHandler.info(uid, getClass(), "ProcGetDatosAuditoria: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "ProcGetDatosAuditoria: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String ProcEliminacionCredito(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "ProcEliminacionCredito: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {EliminacionCreditoPeticion.class,
									SolicitudesRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final EliminacionCreditoPeticion eliminacionCreditoPeticion =
			(EliminacionCreditoPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "ProcEliminacionCredito: - Datos de entrada : " + eliminacionCreditoPeticion);

		//Llamado a funci?n principal
		final SolicitudesRespuesta respuesta = solicitudesCredito.procEliminacionCreditoTarea(uid, eliminacionCreditoPeticion);
		LogHandler.info(uid, getClass(), "ProcEliminacionCredito: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "ProcEliminacionCredito: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String ProcGuardarCreditoTemp(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "ProcGuardarCreditoTemp: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {SolicitudSACG.class,
									SolicitudSACGIntegrante.class,
									SolicitudSACGPeticion.class,
									SolicitudesRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final SolicitudSACGPeticion solicitudesSACGPeticion =
			(SolicitudSACGPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "ProcGuardarCreditoTemp: - Datos de entrada : " + solicitudesSACGPeticion);

		//Llamado a funci?n principal
		final SolicitudesRespuesta respuesta = solicitudesCredito.procGuardarCreditoTempTarea(uid, solicitudesSACGPeticion);
		LogHandler.info(uid, getClass(), "ProcGuardarCreditoTemp: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "ProcGuardarCreditoTemp: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String Get_AccessPerfil_FUN(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.debug(uid, getClass(), "Get_AccessPerfil_FUN: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {Menu.class,
									AccessPerfilPeticion.class,
									AccessPerfilRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final AccessPerfilPeticion accessPerfilPeticion =
			(AccessPerfilPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);

		//Llamado a funci?n principal
		final AccessPerfilRespuesta respuesta = solicitudesCredito.get_AccessPerfil_FUNTarea(uid, accessPerfilPeticion);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String Get_Submenus_FUN(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.debug(uid, getClass(), "Get_Submenus_FUN: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {Menu.class,
									SubMenusPeticion.class,
									AccessPerfilRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final SubMenusPeticion subMenusPeticion =
			(SubMenusPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);

		//Llamado a funci?n principal
		final AccessPerfilRespuesta respuesta = solicitudesCredito.get_Submenus_FUNTarea(uid, subMenusPeticion);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String ProcGetSolicitudes(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "ProcGetSolicitudes: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {SolicitudSACGGet.class,
									SolicitudSACGGetPeticion.class,
									SolicitudSACGGetRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final SolicitudSACGGetPeticion solicitudSACGGetPeticion =
			(SolicitudSACGGetPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "ProcGetSolicitudes: - Datos de entrada : " + solicitudSACGGetPeticion);

		//Llamado a funci?n principal
		final SolicitudSACGGetRespuesta respuesta =
				solicitudesCredito.procGetSolicitudesTarea(uid, solicitudSACGGetPeticion);
		LogHandler.info(uid, getClass(), "ProcGetSolicitudes: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String ProcCreditoSolicitud(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "ProcCreditoSolicitud: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {SolicitudSACG.class,
									SolicitudSACGGrupo.class,
									SolicitudSACGIntegrante.class,
									SolicitudesPeticion.class,
									SolicitudSACGRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final SolicitudesPeticion solicitudesPeticion =
			(SolicitudesPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "ProcCreditoSolicitud: - Datos de entrada : " + solicitudesPeticion);

		//Llamado a funci?n principal
		final SolicitudSACGRespuesta respuesta = solicitudesCredito.procCreditoSolicitudTarea(uid, solicitudesPeticion);
		LogHandler.info(uid, getClass(), "ProcCreditoSolicitud: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String consultarSolicitudCredito(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "consultarSolicitudCredito: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {SolicitudSACG.class,
									SolicitudSACGGrupo.class,
									SolicitudSACGIntegrante.class,
									SolicitudesPeticion.class,
									SolicitudSACGRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final SolicitudesPeticion solicitudesPeticion =
			(SolicitudesPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultarSolicitudCredito: - Datos de entrada : " + solicitudesPeticion);

		//Llamado a funci?n principal
		final SolicitudSACGRespuesta respuesta = solicitudesCredito.consultarSolicitudCreditoTarea(uid, solicitudesPeticion);
		LogHandler.info(uid, getClass(), "consultarSolicitudCredito: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "consultarSolicitudCredito: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String registrarSolicitudBuroGeneral(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "registrarSolicitudBuroGeneral - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {SolicitudBuroGeneralOV.class,
									SolicitudesRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final SolicitudBuroGeneralOV   solicitud =
			(SolicitudBuroGeneralOV) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "registrarSolicitudBuroGeneral - Datos de entrada : " + solicitud);

		//Llamado a funci?n principal
		final SolicitudesRespuesta respuesta = solicitudesCredito.registrarSolicitudBuroGeneral(uid, solicitud);
		LogHandler.info(uid, getClass(), "registrarSolicitudBuroGeneral - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "registrarSolicitudBuroGeneral - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String consultaPoolPersonas(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "consultaPoolPersonas - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ConsultaPoolPersonasRespuesta.class,
									PoolPersonasOV.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final PoolPersonasOV   consultaPoolPersonaPeticion =
			(PoolPersonasOV) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultaPoolPersonas - Datos de entrada : " + consultaPoolPersonaPeticion);

		//Llamado a funci?n principal
		final ConsultaPoolPersonasRespuesta respuesta =
				solicitudesCredito.consultaPoolPersonasTarea(uid, consultaPoolPersonaPeticion);
		LogHandler.info(uid, getClass(), "consultaPoolPersonas - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "consultaPoolPersonas - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String modificarPoolPersonas(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "modificarPoolPersonas - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ModificarPoolPersonasRespuesta.class,
									ModificaPoolPersonasOV.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ModificaPoolPersonasOV   modificarPoolPersonaPeticion =
			(ModificaPoolPersonasOV) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "modificarPoolPersonas - Datos de entrada : " + modificarPoolPersonaPeticion);

		//Llamado a funci?n principal
		final ModificarPoolPersonasRespuesta respuesta =
				solicitudesCredito.modificarPoolPersonasTarea(uid, modificarPoolPersonaPeticion);
		LogHandler.info(uid, getClass(), "modificarPoolPersonas - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "modificarPoolPersonas - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String cargaTrabajoAnalista(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "cargaTrabajoAnalista - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {CargaTrabajoRespuesta.class,
									CargaTrabajoOV.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final CargaTrabajoOV   cargaTrabajoAnalistaPeticion =
			(CargaTrabajoOV) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "cargaTrabajoAnalista - Datos de entrada : " + cargaTrabajoAnalistaPeticion);

		//Llamado a funci?n principal
		final CargaTrabajoRespuesta respuesta =
				solicitudesCredito.cargaTrabajoAnalistaTarea(uid, cargaTrabajoAnalistaPeticion);
		LogHandler.info(uid, getClass(), "cargaTrabajoAnalista - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "cargaTrabajoAnalista - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String reasignarCargaTrabajoAnalista(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "reasignarCargaTrabajoAnalista - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ReasignarCargaTrabajoPeticion.class,
									ReasignarCargaTrabajoRespuesta.class,
									ReasignarCargaTrabajoOV.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ReasignarCargaTrabajoPeticion reasignarCargaTrabajoAnalistaPeticion =
			(ReasignarCargaTrabajoPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(),
				"reasignarCargaTrabajoAnalista - Datos de entrada : " + reasignarCargaTrabajoAnalistaPeticion);

		//Llamado a funci?n principal
		final ReasignarCargaTrabajoRespuesta respuesta =
				solicitudesCredito.reasignarCargaTrabajoAnalistaTarea(uid, reasignarCargaTrabajoAnalistaPeticion);
		LogHandler.info(uid, getClass(), "reasignarCargaTrabajoAnalista - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "reasignarCargaTrabajoAnalista - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String consultarAtomos(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "consultarAtomos - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ConsultarAtomosRespuesta.class,
									AtomosOV.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final AtomosOV consultarAtomosPeticion =
			(AtomosOV) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultarAtomos - Datos de entrada : " + consultarAtomosPeticion);

		//Llamado a funci?n principal
		final ConsultarAtomosRespuesta respuesta = solicitudesCredito.consultarAtomosTarea(uid, consultarAtomosPeticion);
		LogHandler.info(uid, getClass(), "consultarAtomos - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String consultarStatusCreditos(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "consultarStatusCreditos - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {StatusCreditoRespuesta.class,
									StatusCreditoOV.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final StatusCreditoOV consultarStatusPeticion =
			(StatusCreditoOV) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultarStatusCreditos - Datos de entrada : " + consultarStatusPeticion);

		//Llamado a funci?n principal
		final StatusCreditoRespuesta respuesta =
				solicitudesCredito.consultarStatusCreditosTarea(uid, consultarStatusPeticion);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);

		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String consultarPlanillaObservaciones(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "consultarPlanillaObservaciones - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {PlanillaObservacionesRespuesta.class,
									PlanillaObservacionesOV.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final PlanillaObservacionesOV consultarPlanillaPeticion =
			(PlanillaObservacionesOV) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(),
				"consultarPlanillaObservaciones - Datos de entrada : " + consultarPlanillaPeticion);

		//Llamado a funci?n principal
		final PlanillaObservacionesRespuesta respuesta =
				solicitudesCredito.consultarPlanillaObservacionesTarea(uid, consultarPlanillaPeticion);
		LogHandler.info(uid, getClass(), "consultarPlanillaObservaciones - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "consultarPlanillaObservaciones - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String registrarPlanillaObservaciones(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "insertarPlanillaObservaciones - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {PlanillaObservacionesRespuesta.class,
									PlanillaObservacionesPeticion.class,
									PlanillaObservacionesOV.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final PlanillaObservacionesPeticion insertarPlanillaPeticion =
			(PlanillaObservacionesPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(),
				"insertarPlanillaObservaciones - Datos de entrada : " + insertarPlanillaPeticion);

		//Llamado a funci?n principal
		final PlanillaObservacionesRespuesta respuesta =
				solicitudesCredito.registrarPlanillaObservacionesTarea(uid, insertarPlanillaPeticion);
		LogHandler.info(uid, getClass(), "insertarPlanillaObservaciones - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "insertarPlanillaObservaciones - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String cancelarSolicitudEvaluacionCrediticia(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "cancelarSolicitudEvaluacionCrediticia - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {CancelarSolEvaCrePeticion.class,
									CancelarSolEvaCreRespuesta.class,
									TareaOV.class,
									AtomosRespuesta.class,
									AtomosOV.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final CancelarSolEvaCrePeticion cancelarPeticion =
			(CancelarSolEvaCrePeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(),
				"cancelarSolicitudEvaluacionCrediticia - Datos de entrada : " + cancelarPeticion);

		//Llamado a funci?n principal
		final CancelarSolEvaCreRespuesta  respuesta =
				solicitudesCredito.cancelarSolicitudEvaluacionCrediticiaTarea(uid, cancelarPeticion);
		LogHandler.info(uid, getClass(), "cancelarSolicitudEvaluacionCrediticia - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "cancelarSolicitudEvaluacionCrediticia - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String terminarSolicitudEvaluacionCrediticia(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "terminarSolicitudEvaluacionCrediticia - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {CancelarSolEvaCrePeticion.class,
									CancelarSolEvaCreRespuesta.class,
									TareaOV.class,
									AtomosRespuesta.class,
									AtomosOV.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final CancelarSolEvaCrePeticion cancelarPeticion =
			(CancelarSolEvaCrePeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(),
				"terminarSolicitudEvaluacionCrediticia - Datos de entrada : " + cancelarPeticion);

		//Llamado a funci?n principal
		final CancelarSolEvaCreRespuesta  respuesta =
				solicitudesCredito.terminarSolicitudEvaluacionCrediticiaTarea(uid, cancelarPeticion);
		LogHandler.info(uid, getClass(), "terminarSolicitudEvaluacionCrediticia - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "terminarSolicitudEvaluacionCrediticia - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String enviarPlanillaObservacionesSucursal(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "enviarPlanillaObservacionesSucursal - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {EnviarPlaObsSucPeticion.class,
									EnviarPlaObsSucRespuesta.class,
									CargaTrabajoOV.class,
									AtomosRespuesta.class,
									AtomosOV.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final EnviarPlaObsSucPeticion cancelarPeticion =
			(EnviarPlaObsSucPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "enviarPlanillaObservacionesSucursal - Datos de entrada : " + cancelarPeticion);

		//Llamado a funci?n principal
		final EnviarPlaObsSucRespuesta  respuesta =
				solicitudesCredito.enviarPlanillaObservacionesSucursalTarea(uid, cancelarPeticion);
		LogHandler.info(uid, getClass(), "enviarPlanillaObservacionesSucursal - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "enviarPlanillaObservacionesSucursal - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String corregirPlanillaObservacionesSucursal(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "corregirPlanillaObservacionesSucursal - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {CorregirPlaObsSucPeticion.class,
									CorregirPlaObsSucRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final CorregirPlaObsSucPeticion corregirPeticion =
			(CorregirPlaObsSucPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(),
				"corregirPlanillaObservacionesSucursal - Datos de entrada : " + corregirPeticion);

		//Llamado a funci?n principal
		final CorregirPlaObsSucRespuesta  respuesta = solicitudesCredito.corregirPlanillaObservacionesSucursalTarea(
				uid, corregirPeticion);
		LogHandler.info(uid, getClass(), "corregirPlanillaObservacionesSucursal - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "corregirPlanillaObservacionesSucursal - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String reporteSolicitudes(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "reporteSolicitudes - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ReporteSolicitudesPeticion.class,
									ReporteSolicitudesRespuesta.class,
									ReporteSolicitudOV.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ReporteSolicitudesPeticion reporteSolicitudesPeticion =
			(ReporteSolicitudesPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "reporteSolicitudes - Datos de entrada : " + reporteSolicitudesPeticion);

		//Llamado a funci?n principal
		final ReporteSolicitudesRespuesta respuesta = solicitudesCredito.reporteSolicitudesTarea(uid, reporteSolicitudesPeticion);
		LogHandler.info(uid, getClass(), "reporteSolicitudes - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "reporteSolicitudes - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String reporteBuroExterno(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "reporteBuroExterno - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ReporteSolicitudesPeticion.class,
									ReporteBuroExternoRespuesta.class,
									ReporteBuroExternoOV.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ReporteSolicitudesPeticion reporteSolicitudesPeticion =
			(ReporteSolicitudesPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "reporteBuroExterno - Datos de entrada : " + reporteSolicitudesPeticion);

		//Llamado a funci?n principal
		final ReporteBuroExternoRespuesta respuesta = solicitudesCredito.reporteBuroExternoTarea(uid, reporteSolicitudesPeticion);
		LogHandler.info(uid, getClass(), "reporteBuroExterno - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "reporteBuroExterno - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String reporteAsignaciones(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "reporteAsignaciones - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ReporteSolicitudesPeticion.class,
									ReporteAsignacionesRespuesta.class,
									ReporteAsignacionOV.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ReporteSolicitudesPeticion reporteSolicitudesPeticion =
			(ReporteSolicitudesPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "reporteAsignaciones - Datos de entrada : " + reporteSolicitudesPeticion);

		//Llamado a funci?n principal
		final ReporteAsignacionesRespuesta respuesta =
				solicitudesCredito.reporteAsignacionesTarea(uid, reporteSolicitudesPeticion);
		LogHandler.info(uid, getClass(), "reporteAsignaciones - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "reporteAsignaciones - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String reporteReasignaciones(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "reporteAsignaciones - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ReporteSolicitudesPeticion.class,
									ReporteReasignacionesRespuesta.class,
									ReporteReasignacionOV.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ReporteSolicitudesPeticion reporteSolicitudesPeticion =
			(ReporteSolicitudesPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "reporteAsignaciones - Datos de entrada : " + reporteSolicitudesPeticion);

		//Llamado a funci?n principal
		final ReporteReasignacionesRespuesta respuesta =
				solicitudesCredito.reporteReasignacionesTarea(uid, reporteSolicitudesPeticion);
		LogHandler.info(uid, getClass(), "reporteAsignaciones - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "reporteAsignaciones - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String reporteSucursalesClasificacion(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "reporteSucursalesClasificacion - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ReporteClasificacionSucursalesPeticion.class,
									ReporteClasificacionSucursalesRespuesta.class,
									ReporteClasificacionSucursalesOV.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ReporteClasificacionSucursalesPeticion reporteClasificacionSucursalesPeticion =
			(ReporteClasificacionSucursalesPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "reporteSucursalesClasificacion - Datos de entrada : "
			+ reporteClasificacionSucursalesPeticion);

		//Llamado a funci?n principal
		final ReporteClasificacionSucursalesRespuesta respuesta
		= solicitudesCredito.reporteClasificacionSucursalesTarea(uid, reporteClasificacionSucursalesPeticion);
		LogHandler.info(uid, getClass(), "reporteSucursalesClasificacion - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "reporteSucursalesClasificacion - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String validarDatosSolicitud(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "validarDatosSolicitudes - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ValidaSolicitudOV.class,
									ValidarSolicitudPeticion.class,
									ValidarSolicitudRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ValidarSolicitudPeticion validaSolicitudesPeticion =
			(ValidarSolicitudPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "validarDatosSolicitudes - Datos de entrada : " + validaSolicitudesPeticion);

		//Llamado a funci?n principal
		final ValidarSolicitudRespuesta respuesta =
				solicitudesCredito.validarDatosSolicitudTarea(uid, validaSolicitudesPeticion);
		LogHandler.info(uid, getClass(), "validarDatosSolicitudes - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "validarDatosSolicitudes - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String validarTasaGuardar(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "validarTasaGuardar - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ValidarTasaInteresPeticion.class,
									ValidarTasaInteresRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ValidarTasaInteresPeticion validarTasaInteres =
			(ValidarTasaInteresPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "validarTasaGuardar - Datos de entrada : " + validarTasaInteres);

		//Llamado a funci?n principal
		final ValidarTasaInteresRespuesta respuesta =
				solicitudesCredito.validarTasaInteresTarea(uid, validarTasaInteres);
		LogHandler.info(uid, getClass(), "validarTasaGuardar - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		return respuestaXML;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String validarTasaConfirmar(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "validarTasaConfirmar - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ValidarTasaInteresPeticion.class,
									ValidarTasaInteresRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ValidarTasaInteresPeticion validarTasaInteres =
			(ValidarTasaInteresPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "validarTasaConfirmar - Datos de entrada : " + validarTasaInteres);

		//Llamado a funci?n principal
		final ValidarTasaInteresRespuesta respuesta =
				solicitudesCredito.validarTasaConfirmarTarea(uid, validarTasaInteres);
		LogHandler.info(uid, getClass(), "validarTasaConfirmar - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "validarTasaConfirmar - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}


	/**
	 * @param peticion para calcular requerimiento
	 * @return RespuestaReglaIncremento
	 */
	public RespuestaReglaIncremento calculaIncrementoMonto(PeticionReglaIncremento peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "calculaIncrementoMonto - Datos de entrada : " + peticion);
		final RespuestaReglaIncremento respuesta = solicitudesCredito.calculaIncrementoMontoTarea(uid, peticion);
		LogHandler.info(uid, getClass(), "calculaIncrementoMonto - Datos de salida : " + respuesta);
		return respuesta;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String validaIntegranteSolicitud(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "validaIntegranteSolicitud - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ValidaIntegrantePeticion.class,
									ValidaIntegranteRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ValidaIntegrantePeticion validaIntegrantePeticion =
			(ValidaIntegrantePeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "validaIntegranteSolicitud - Datos de entrada : " + validaIntegrantePeticion);

		//Llamado a funci?n principal
		final ValidaIntegranteRespuesta respuesta =
				solicitudesCredito.validaIntegranteSolicitud(uid, validaIntegrantePeticion);
		LogHandler.info(uid, getClass(), "validaIntegranteSolicitud - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "validaIntegranteSolicitud - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Metodo para validar cuando se agrega un integrante en una solicitud.
	 * @param peticion contiene los datos necesarios para realizar la validacion.
	 * @return regresa la respuesta para saber si es posible agregar el cliente o no a la solicitu.
	 */
	public ValidarIntegranteSolicitudRespuesta  validarAgregarIntegranteSolicitud(ValidarIntegranteSolicitudPeticion peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "validarAgregarIntegranteSolicitud - Datos de entrada : " + peticion);
		final ValidarIntegranteSolicitudRespuesta respuesta =
				solicitudesCredito.validarAgregarIntegranteSolicitud(uid, peticion);
		LogHandler.info(uid, getClass(), "validarAgregarIntegranteSolicitud - Datos de salida: " + respuesta);
		return respuesta;
	}

	/**
	 * Guardar solicitud credito.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String guardarSolicitudCredito(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "guardarSolicitudCredito: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {SolicitudSACG.class,
									SolicitudSACGIntegrante.class,
									SolicitudSACGPeticion.class,
									SolicitudesRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final SolicitudSACGPeticion solicitudesSACGPeticion =
			(SolicitudSACGPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "guardarSolicitudCredito: - Datos de entrada : " + solicitudesSACGPeticion);

		//Llamado a funci?n principal
		final SolicitudesRespuesta respuesta = solicitudesCredito.guardarSolicitudCreditoTarea(uid, solicitudesSACGPeticion);
		LogHandler.info(uid, getClass(), "guardarSolicitudCredito: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "guardarSolicitudCredito: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Guardar solicitud cec credito.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String enviarSolicitudCEC(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "enviarSolicitudCEC: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ObtenerDatosSolicitudPeticion.class,
									EnviarSolicitudCecRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ObtenerDatosSolicitudPeticion obtenerDatosSolicitudPeticion =
			(ObtenerDatosSolicitudPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "enviarSolicitudCEC: - Datos de entrada : " + obtenerDatosSolicitudPeticion);

		//Llamado a funci?n principal
		final EnviarSolicitudCecRespuesta respuesta = solicitudesCredito.enviarSolicitudCEC(uid, obtenerDatosSolicitudPeticion);
		LogHandler.info(uid, getClass(), "enviarSolicitudCEC: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "enviarSolicitudCEC: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Guardar solicitud cec credito para el Analista Documental.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String enviarSolicitudCECDocumental(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "enviarSolicitudCEC: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ObtenerDatosSolicitudPeticion.class,
									EnviarSolicitudCecRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ObtenerDatosSolicitudPeticion obtenerDatosSolicitudPeticion =
			(ObtenerDatosSolicitudPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "enviarSolicitudCEC: - Datos de entrada : " + obtenerDatosSolicitudPeticion);

		//Llamado a funci?n principal
		final EnviarSolicitudCecRespuesta respuesta =
				solicitudesCredito.enviarSolicitudCECDocumental(uid, obtenerDatosSolicitudPeticion);
		LogHandler.info(uid, getClass(), "enviarSolicitudCEC: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "enviarSolicitudCEC: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Generar tarea excepcion garantia
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String generarTareaExcepcionGarantia(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "generarTareaExcepcionGarantia: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ExcepcionGarantiaPeticion.class,
									ExcepcionGarantiaRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ExcepcionGarantiaPeticion genExcepcionGarantiaPeticion =
			(ExcepcionGarantiaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "generarTareaExcepcionGarantia: - Datos de entrada : " + genExcepcionGarantiaPeticion);

		//Llamado a funci?n principal
		final ExcepcionGarantiaRespuesta respuesta = solicitudesCredito.generarTareaExcepcionGarantiaTarea(uid,
				genExcepcionGarantiaPeticion,  null);
		LogHandler.info(uid, getClass(), "generarTareaExcepcionGarantia: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "generarTareaExcepcionGarantia: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Funcion para validar un contrato para renovacion financiada
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
   public String validarContratoRenovacionFinanciada(String peticion) {
	   final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "validarContratoRenovacionFinanciada: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ValidarContratoPeticion.class,
									ValidarContratoRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ValidarContratoPeticion peticionObj =
			(ValidarContratoPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "validarContratoRenovacionFinanciada: - Datos de entrada : " + peticionObj);

		//Llamado a funci?n principal
		final ValidarContratoRespuesta respuesta = solicitudesCredito.validarContratoRenovacionFinanciada(uid, peticionObj);
		LogHandler.info(uid, getClass(), "validarContratoRenovacionFinanciada: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "validarContratoRenovacionFinanciada: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
   }

	/**
	 * Obtener tarea excepcion garantia
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String obtenerBuzonExcepcionGarantia(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "obtenerBuzonExcepcionGarantia: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ExcepcionGarantiaPeticion.class,
									ExcepcionGarantiaRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ExcepcionGarantiaPeticion genExcepcionGarantiaPeticion =
			(ExcepcionGarantiaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "obtenerBuzonExcepcionGarantia: - Datos de entrada : "
			+ genExcepcionGarantiaPeticion);

		//Llamado a funci?n principal
		final ExcepcionGarantiaRespuesta respuesta =
				solicitudesCredito.obtenerBuzonExcepcionGarantiaTarea(uid, genExcepcionGarantiaPeticion);
		LogHandler.info(uid, getClass(), "obtenerBuzonExcepcionGarantia: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "obtenerBuzonExcepcionGarantia: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Obtener tarea excepcion garantia
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String obtenerBuzonExcepcionGarantiaPorIdTarea(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "obtenerBuzonExcepcionGarantiaPorIdTarea: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ExcepcionGarantiaPeticion.class,
									ExcepcionGarantiaRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ExcepcionGarantiaPeticion genExcepcionGarantiaPeticion =
			(ExcepcionGarantiaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "obtenerBuzonExcepcionGarantiaPorIdTarea: - Datos de entrada : "
			+ genExcepcionGarantiaPeticion);

		//Llamado a funci?n principal
		final ExcepcionGarantiaRespuesta respuesta =
				solicitudesCredito.obtenerBuzonExcepcionGarantiaPorIdTareaTarea(uid, genExcepcionGarantiaPeticion);
		LogHandler.info(uid, getClass(), "obtenerBuzonExcepcionGarantiaPorIdTarea: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "obtenerBuzonExcepcionGarantiaPorIdTarea: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Obtener tarea excepcion garantia por tipo tarea
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String obtenerBuzonExPorTipoTarea(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "obtenerBuzonExPorTipoTarea: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ExcepcionGarantiaPeticion.class,
									ExcepcionGarantiaRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ExcepcionGarantiaPeticion genExcepcionGarantiaPeticion =
			(ExcepcionGarantiaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "obtenerBuzonExPorTipoTarea: - Datos de entrada : "
			+ genExcepcionGarantiaPeticion);

		//Llamado a funci?n principal
		final BuzonOV respuesta =
				solicitudesCredito.obtenerBuzonExPorTipoTareaTarea(uid, genExcepcionGarantiaPeticion);
		LogHandler.info(uid, getClass(), "obtenerBuzonExPorTipoTarea: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "obtenerBuzonExPorTipoTarea: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Autorizar tarea excepcion garantia
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String autorizaBuzonExcepcion(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "autorizaBuzonExcepcion: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ExcepcionGarantiaPeticion.class,
									ExcepcionGarantiaRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ExcepcionGarantiaPeticion genExcepcionGarantiaPeticion =
			(ExcepcionGarantiaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "autorizaBuzonExcepcion: - Datos de entrada : " + genExcepcionGarantiaPeticion);

		//Llamado a funci?n principal
		final ExcepcionGarantiaRespuesta respuesta = solicitudesCredito.autorizaBuzonExcepcionTarea(uid,
				genExcepcionGarantiaPeticion);
		LogHandler.info(uid, getClass(), "autorizaBuzonExcepcion: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "autorizaBuzonExcepcion: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Rechazar tarea excepcion garantia
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String rechazaBuzonExcepcion(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "rechazaBuzonExcepcionTarea: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ExcepcionGarantiaPeticion.class,
									ExcepcionGarantiaRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ExcepcionGarantiaPeticion genExcepcionGarantiaPeticion =
			(ExcepcionGarantiaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "rechazaBuzonExcepcion: - Datos de entrada : " + genExcepcionGarantiaPeticion);

		//Llamado a funci?n principal
		final ExcepcionGarantiaRespuesta respuesta = solicitudesCredito.rechazaBuzonExcepcionTarea(uid,
				genExcepcionGarantiaPeticion);
		LogHandler.info(uid, getClass(), "rechazaBuzonExcepcion: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "rechazaBuzonExcepcion: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Obtener Historico Planilla Observaciones
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String obtenerHistoricoPlanillaObserv(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "obtenerHistoricoPlanillaObserv: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {
									HistoricoPlanillaObservOV.class,
									HistoricoPlanillaObservPeticion.class,
									HistoricoPlanillaObservRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final HistoricoPlanillaObservPeticion genHistoricoPlanillaObservPeticion =
			(HistoricoPlanillaObservPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "obtenerHistoricoPlanillaObserv: - Datos de entrada : "
			+ genHistoricoPlanillaObservPeticion);

		//Llamado a funcion principal
		final HistoricoPlanillaObservRespuesta respuesta =
				solicitudesCredito.obtenerHistoricoPlanillaObservTarea(uid, genHistoricoPlanillaObservPeticion);
		LogHandler.info(uid, getClass(), "obtenerHistoricoPlanillaObserv: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "obtenerHistoricoPlanillaObserv: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Obtener Historico Planilla Observaciones
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String obtenerIntegrantesEdoCtaYBuro(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "obtenerIntegrantesEdoCtaYBuro: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {IntegrantePlanillaAprobOV.class,
									PlanillaAprobacionPeticion.class,
									PlanillaAprobacionRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final PlanillaAprobacionPeticion genIntegrantesPlanillaOAprobPeticion =
			(PlanillaAprobacionPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "obtenerIntegrantesEdoCtaYBuro: - Datos de entrada : "
			+ genIntegrantesPlanillaOAprobPeticion);

		//Llamado a funcion principal
		final PlanillaAprobacionRespuesta respuesta =
				solicitudesCredito.obtenerIntegrantesEdoCtaYBuro(uid, genIntegrantesPlanillaOAprobPeticion);
		LogHandler.info(uid, getClass(), "obtenerIntegrantesEdoCtaYBuro: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "obtenerIntegrantesEdoCtaYBuro: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Guardar planilla aprobacion.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String guardarPlanillaAprobacion(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "guardarPlanillaAprobacion: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {SolicitudPlanillaAprobacionPeticion.class,
									SolicitudPlanillaAprobacionRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final SolicitudPlanillaAprobacionPeticion planillaPeticion =
			(SolicitudPlanillaAprobacionPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "guardarPlanillaAprobacion: - Datos de entrada : " + planillaPeticion);

		//Llamado a funci?n principal
		final SolicitudPlanillaAprobacionRespuesta respuesta =
				solicitudesCredito.guardarSolicitudPlanillaAprobacion(uid, planillaPeticion, null);
		LogHandler.info(uid, getClass(), "guardarPlanillaAprobacion: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "guardarPlanillaAprobacion: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Guardar planilla aprobacion generadas.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarPlanillaAprobacionGeneradas(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "consultarPlanillaAprobacionGeneradas: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {SolicitudPlanillaAprobacionPeticion.class,
									SolicitudesAlmacenadasRespuesta.class,
									SolicitudPlanillaAprobacionOV.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final SolicitudPlanillaAprobacionPeticion planillaPeticion =
			(SolicitudPlanillaAprobacionPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultarPlanillaAprobacionGeneradas: - Datos de entrada : " + planillaPeticion);

		//Llamado a funci?n principal
		final SolicitudesAlmacenadasRespuesta respuesta =
				solicitudesCredito.consultarSolicitudesPlanillaAprobacionAlmacenadasTarea(uid, planillaPeticion);
		LogHandler.info(uid, getClass(), "consultarPlanillaAprobacionGeneradas: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "consultarPlanillaAprobacionGeneradas: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Consultar solicitud motivo cancelacion.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarSolicitudMotivoCancelacion(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "consultarSolicitudMotivoCancelacion: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {SolicitudesMotivoCancelacionPeticion.class,
									SolicitudesMotivoCancelacionRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final SolicitudesMotivoCancelacionPeticion peticionMotivo =
			(SolicitudesMotivoCancelacionPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultarSolicitudMotivoCancelacion: - Datos de entrada : " + peticionMotivo);

		//Llamado a funci?n principal
		final SolicitudesMotivoCancelacionRespuesta respuesta =
				solicitudesCredito.consultarSolicitudMotivoCancelacionTarea(uid, peticionMotivo);
		LogHandler.info(uid, getClass(), "consultarSolicitudMotivoCancelacion: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "consultarSolicitudMotivoCancelacion: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Consultar lista de codigos por tipo codigo.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarCodigosPorTipoCodigo(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "consultarCodigosPorTipoCodigo: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {CodigosPeticion.class,
									CodigosRespuesta.class,
									CodigoOV.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final CodigosPeticion peticionCodigos =
			(CodigosPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultarCodigosPorTipoCodigo: - Datos de entrada : " + peticionCodigos);

		//Llamado a funci?n principal
		final CodigosRespuesta respuesta =
				solicitudesCredito.consultarCodigosPorTipoCodigoTarea(uid, peticionCodigos);
		LogHandler.info(uid, getClass(), "consultarCodigosPorTipoCodigo: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "consultarCodigosPorTipoCodigo: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Consultar total de desembolso en un periodo.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarTotalDesembolsoPorPeriodo(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "consultarTotalDesembolsoPorPeriodo: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {TotalDesembolsoPeticion.class,
									TotalDesembolsoRespuesta.class,
									TotalDesembolsoOV.class,
									EncabezadoRespuesta.class};
		//Conversion de XML a Object
		final TotalDesembolsoPeticion peticionDesembolso =
			(TotalDesembolsoPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultarTotalDesembolsoPorPeriodo: - Datos de entrada : " + peticionDesembolso);

		//Llamado a funci?n principal
		final TotalDesembolsoRespuesta respuesta =
				solicitudesCredito.consultarTotalDesembolsoPorPeriodo(uid, peticionDesembolso);
		LogHandler.info(uid, getClass(), "consultarTotalDesembolsoPorPeriodo: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "consultarTotalDesembolsoPorPeriodo: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Consultar lista semaforos de la persona.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarSemaforosPorPersona(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "consultarSemaforosPorSolicitud: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {SemaforoSolicitudesPeticion.class,
									SemaforoSolicitudesRespuesta.class,
									SemaforoSolicitudesOV.class,
									EncabezadoRespuesta.class};
		//Conversion de XML a Object
		final SemaforoSolicitudesPeticion peticionsemaforos =
			(SemaforoSolicitudesPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultarSemaforosPorSolicitud: - Datos de entrada : " + peticionsemaforos);

		//Llamado a funci?n principal
		final SemaforoSolicitudesRespuesta respuesta =
				solicitudesCredito.consultarSemaforosPorPersona(uid, peticionsemaforos);
		LogHandler.info(uid, getClass(), "consultarSemaforosPorSolicitud: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "consultarSemaforosPorSolicitud: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Enviar una solicitud a verificacion telefonica.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String enviarSolicitudVerificacionTelefonica(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "enviarSolicitudVerificacionTelefonica: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ConsultaInformacionTelefonicaPeticion.class,
									ConsultaInformacionTelefonicaRespuesta.class,
									EncabezadoRespuesta.class};
		//Conversion de XML a Object
		final ConsultaInformacionTelefonicaPeticion peticionVT =
			(ConsultaInformacionTelefonicaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "enviarSolicitudVerificacionTelefonica: - Datos de entrada : " + peticion);

		//Llamado a funci?n principal
		final ConsultaInformacionTelefonicaRespuesta respuesta =
				solicitudesCredito.enviarSolicitudVerificacionTelefonica(uid, peticionVT, null);
		LogHandler.info(uid, getClass(), "enviarSolicitudVerificacionTelefonica: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "enviarSolicitudVerificacionTelefonica: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Consultar total de autorizado en un periodo.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarTotalAutorizadoPorPeriodo(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "consultarTotalAutorizadoPorPeriodo: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {TotalDesembolsoPeticion.class,
									TotalDesembolsoRespuesta.class,
									TotalDesembolsoOV.class,
									EncabezadoRespuesta.class};
		//Conversion de XML a Object
		final TotalDesembolsoPeticion peticionDesembolso =
			(TotalDesembolsoPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultarTotalAutorizadoPorPeriodo: - Datos de entrada : " + peticionDesembolso);

		//Llamado a funci?n principal
		final TotalDesembolsoRespuesta respuesta =
				solicitudesCredito.consultarTotalAutorizadoPorPeriodo(uid, peticionDesembolso);
		LogHandler.info(uid, getClass(), "consultarTotalAutorizadoPorPeriodo: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "consultarTotalAutorizadoPorPeriodo: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	//MIGRACION MODULO CEC
	/**
	 * Consultar buzon de tareas.
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarBuzonTareas(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "consultarBuzonTareas: - Datos de entrada : " + peticion);

		BuzonOV respuesta = null;

		try {
			//Parametros de entrada
			final Class<?>[] clases = {PeticionModuloCEC.class,
										EncabezadoRespuesta.class};

			final PeticionModuloCEC peticionTarea =
					(PeticionModuloCEC) transformador.transformaXMLAObjeto(uid, peticion, clases);

			if (peticionTarea.getPersonaAnalista() == null || peticionTarea.getPersonaAnalista().trim().isEmpty()) {
				throw new Exception("Es necesario el numero de persona del Analista para realizar la consulta.");
			}
			if (peticionTarea.getSucursal() == null) {
				throw new Exception("Es necesario el numero sucursal para realizar la consulta.");
			}
			if (peticionTarea.getPerfil() == null || peticionTarea.getPerfil().trim().isEmpty()) {
				throw new Exception("Es necesario el perfil para realizar la consulta.");
			}

			ConsultaBuzonPeticion   peticionBuzon = new ConsultaBuzonPeticion();
			peticionBuzon.setPerfil(peticionTarea.getPerfil());
			peticionBuzon.setSucursal(Integer.valueOf(peticionTarea.getSucursal()));
			peticionBuzon.setUsuarioPropietario(peticionTarea.getPersonaAnalista());
			peticionBuzon.setTipoTarea("TECR");
			peticionBuzon.setTipoTareaEx("TOEG");
			peticionBuzon.setStatus("P");

			respuesta =	consultas.consultaBuzonTareas(uid, peticionBuzon);

			LogHandler.info(uid, getClass(), "consultaBuzonTareas - Datos de salida: ");
		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON = transformador.transformaObjetoAJSON(uid, respuesta);
		return respuestaJSON;
	}

	/**
	 * Consultar atomos por solicitud.
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarAtomosCEC(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "consultarAtomos - Datos de entrada :  peticion=" + peticion);
		ConsultarAtomosRespuesta respuesta = null;

		try {
			//Parametros de entrada
			final Class<?>[] clases = {AtomosOV.class,
										EncabezadoRespuesta.class};

			final AtomosOV consultarAtomosPeticion =
					(AtomosOV) transformador.transformaXMLAObjeto(uid, peticion, clases);

			if (consultarAtomosPeticion.getSolicitud() == null
					|| consultarAtomosPeticion.getSolicitud().trim().isEmpty()) {
				throw new Exception("Es necesario el numero de solicitud para realizar la consulta.");
			}

			consultarAtomosPeticion.setSolicitud(consultarAtomosPeticion.getSolicitud().trim());

			if (consultarAtomosPeticion.getOrdenar() != null) {
				consultarAtomosPeticion.setOrdenar(consultarAtomosPeticion.getOrdenar());
			}

			//Llamado a funci�n principal
			respuesta = solicitudesCredito.consultarAtomosTarea(uid, consultarAtomosPeticion);
			LogHandler.info(uid, getClass(), "consultarAtomos - Datos de salida: " + respuesta);

		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON =  transformador.transformaObjetoAJSON(uid, respuesta);
		LogHandler.info(uid, getClass(), "consultarAtomos - Datos de salida :");
		return respuestaJSON;
	}

	/**
	 * Consultar observaciones por solicitud.
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarPlanillaObservacionesCEC(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "consultarPlanillaObservaciones - Datos de entrada :  peticion=" + peticion);
		PlanillaObservacionesRespuesta respuesta = null;
		try {
			//Parametros de entrada
			final Class<?>[] clases = {PeticionModuloCEC.class,
										EncabezadoRespuesta.class};

			final PeticionModuloCEC peticionTarea =
					(PeticionModuloCEC) transformador.transformaXMLAObjeto(uid, peticion, clases);

			if (peticionTarea.getSolicitud() == null || peticionTarea.getSolicitud().trim().isEmpty()) {
				throw new Exception("Es necesario el numero de solicitud para realizar la consulta.");
			}

			PlanillaObservacionesOV consultarPlanillaPeticion = new PlanillaObservacionesOV();
			consultarPlanillaPeticion.setSolicitud(peticionTarea.getSolicitud().trim());
			consultarPlanillaPeticion.setConsultaCanceladas(true);
			consultarPlanillaPeticion.setConsultaMarcadas(peticionTarea.isConsultaMarcadas());

			respuesta = solicitudesCredito.consultarPlanillaObservacionesTarea(uid, consultarPlanillaPeticion);
			LogHandler.info(uid, getClass(), "consultarPlanillaObservaciones - Datos de salida: " + respuesta);

			if (respuesta.getPlanillaObservaciones().size() > 0) {
				for ( PlanillaObservacionesOV observacion : respuesta.getPlanillaObservaciones()) {
					String descripcion = observacion.getDescripcion();
					descripcion = Normalizer.normalize(descripcion, Normalizer.Form.NFD);
					descripcion = descripcion.replaceAll("[^\\p{ASCII}]", "");
					observacion.setDescripcion(descripcion);

					String seccion = observacion.getDescSeccion();
					seccion = Normalizer.normalize(seccion, Normalizer.Form.NFD);
					seccion = seccion.replaceAll("[^\\p{ASCII}]", "");
					observacion.setDescSeccion(seccion);
				}
			}

		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON = transformador.transformaObjetoAJSON(uid, respuesta);
		return respuestaJSON;
	}

	/**
	 * Cancelar solicitud desde el modulo de aprobacion del CEC
	 * @param peticion the peticion
	 * @return the string
	 */
	public String cancelarSolicitudCEC(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "cancelarSolicitud - Datos de entrada :  peticion=" + peticion);

		final Class<?>[] clases = {CancelarSolEvaCrePeticion.class,
				EncabezadoRespuesta.class};

		final CancelarSolEvaCrePeticion cancelarPeticion =
				(CancelarSolEvaCrePeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "cancelarSolicitud - Datos de entrada :  cancelarPeticion=" + cancelarPeticion);

		CancelarSolEvaCreRespuesta respuesta = null;
		try {
			if (cancelarPeticion.getSolicitud() == null || cancelarPeticion.getSolicitud().trim().isEmpty()) {
				throw new Exception("Es necesario el numero de solicitud para realizar la cancelacion.");
			}
			if (cancelarPeticion.getIdTarea() == null ) {
				throw new Exception("Es necesario el id de la tarea para realizar la cancelacion.");
			}
			if (cancelarPeticion.getProceso() == null || cancelarPeticion.getProceso().trim().isEmpty()) {
				throw new Exception("Es necesario el proceso para realizar la cancelacion.");
			}
			if (cancelarPeticion.getCodigoResolucion() == null || cancelarPeticion.getCodigoResolucion().trim().isEmpty()) {
				throw new Exception("Es necesario el codigo de resolucion para realizar la cancelacion.");
			}
			if (cancelarPeticion.getUsuario() == null || cancelarPeticion.getUsuario().trim().isEmpty()) {
				throw new Exception("Es necesario el usuario para realizar la cancelacion.");
			}
			if (cancelarPeticion.getMotivoCancelacion() == null || cancelarPeticion.getMotivoCancelacion().trim().isEmpty()) {
				throw new Exception("Es necesario el motivo de cancelacion para realizar la cancelacion.");
			}

			respuesta =	solicitudesCredito.cancelarSolicitudEvaluacionCrediticiaTarea(uid, cancelarPeticion);
			LogHandler.info(uid, getClass(), "cancelarSolicitud - Datos de salida: " + respuesta);
		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON =  transformador.transformaObjetoAJSON(uid, respuesta);
		return respuestaJSON;
	}

	/**
	 * Confirmar solicitud desde el modulo de aprobacion del CEC
	 * @param peticion the peticion
	 * @return the string
	 */
	public String confirmarSolicitud(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "confirmarSolicitud - Datos de entrada :  peticion=" + peticion);
		CancelarSolEvaCreRespuesta respuesta = null;
		try {
			final Class<?>[] clases = {CancelarSolEvaCrePeticion.class,
					EncabezadoRespuesta.class};

			final CancelarSolEvaCrePeticion confirmarPeticion =
					(CancelarSolEvaCrePeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
			LogHandler.info(uid, getClass(), "confirmarSolicitud - Datos de entrada :  confirmarPeticion=" + confirmarPeticion);

			if (confirmarPeticion.getSolicitud() == null || confirmarPeticion.getSolicitud().trim().isEmpty()) {
				throw new Exception("Es necesario el numero de solicitud para realizar la confirmacion.");
			}
			if (confirmarPeticion.getIdTarea() == null ) {
				throw new Exception("Es necesario el id de la tarea para realizar la confirmacion.");
			}
			if (confirmarPeticion.getProceso() == null || confirmarPeticion.getProceso().trim().isEmpty()) {
				throw new Exception("Es necesario el proceso para realizar la confirmacion.");
			}
			if (confirmarPeticion.getCodigoResolucion() == null || confirmarPeticion.getCodigoResolucion().trim().isEmpty()) {
				throw new Exception("Es necesario el codigo de resolucion para realizar la confirmacion.");
			}
			if (confirmarPeticion.getUsuario() == null || confirmarPeticion.getUsuario().trim().isEmpty()) {
				throw new Exception("Es necesario el usuario para realizar la confirmacion.");
			}

			respuesta =	solicitudesCredito.terminarSolicitudEvaluacionCrediticiaTarea(uid, confirmarPeticion);
			LogHandler.info(uid, getClass(), "confirmarSolicitud - Datos de salida: " + respuesta);
		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON =  transformador.transformaObjetoAJSON(uid, respuesta);
		LogHandler.info(uid, getClass(), "confirmarSolicitud - Datos de salida :");
		return respuestaJSON;
	}

	/**
	 * Enviar observaciones a sucursal desde el modulo de aprobacion del CEC
	 * @param peticion the peticion
	 * @return the string
	 */
	public String enviarPlanillaObservacionesSucursalCEC(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "enviarPlanillaObservacionesSucursalCEC - Datos de entrada :  peticion=" + peticion);

		EnviarPlaObsSucRespuesta respuesta = null;
		try {
			final Class<?>[] clases = {EnviarPlaObsSucPeticion.class,
					EncabezadoRespuesta.class};

			final EnviarPlaObsSucPeticion sucursalPeticion =
					(EnviarPlaObsSucPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);

			if (sucursalPeticion.getSolicitud() == null || sucursalPeticion.getSolicitud().trim().isEmpty()) {
				throw new Exception("Es necesario el numero de solicitud para realizar el envio.");
			}
			if (sucursalPeticion.getIdTarea() == null) {
				throw new Exception("Es necesario el id de la tarea para realizar el envio.");
			}
			if (sucursalPeticion.getProceso() == null || sucursalPeticion.getProceso().trim().isEmpty()) {
				throw new Exception("Es necesario el proceso para realizar el envio.");
			}
			if (sucursalPeticion.getCodigoResolucion() == null || sucursalPeticion.getCodigoResolucion().trim().isEmpty()) {
				throw new Exception("Es necesario el codigo de resolucion para realizar el envio.");
			}
			if (sucursalPeticion.getUsuario() == null || sucursalPeticion.getUsuario().trim().isEmpty()) {
				throw new Exception("Es necesario el usuario para realizar el envio.");
			}

			sucursalPeticion.setPerfil("PSUC");
			sucursalPeticion.setStatus("P");

			respuesta =	solicitudesCredito.enviarPlanillaObservacionesSucursalTarea(uid, sucursalPeticion);
		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON =  transformador.transformaObjetoAJSON(uid, respuesta);
		LogHandler.info(uid, getClass(), "enviarPlanillaObservacionesSucursalCEC - Datos de salida :");
		return respuestaJSON;
	}

	/**
	 * Consultar Planilla de Aprobacion
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarPlanillaAprobacion(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );

		LogHandler.info(uid, getClass(), "consultarPlanillaAprobacion - Datos de entrada :  peticion=" + peticion);
		PlanillaAprobacionRespuestaDTO respuesta = null;
		PlanillaAprobacionPeticionDTO consultarPlanillaPeticion = null;
		String respuestaJSON = null;

		try {
			final Class<?>[] clases = {PlanillaAprobacionPeticionDTO.class,
					EncabezadoRespuesta.class};
			consultarPlanillaPeticion =
					(PlanillaAprobacionPeticionDTO) transformador.transformaXMLAObjeto(uid, peticion, clases);
			LogHandler.info(uid, getClass(), "consultarPlanillaAprobacion :  consultarPlanillaAprobacion="
					+ consultarPlanillaPeticion);
			if (consultarPlanillaPeticion.getPlanillaJson()) {
				respuesta = solicitudesCredito.consultarPlanillaAprobacionTarea(uid, consultarPlanillaPeticion, null);

			} else {
				LogHandler.info(uid, getClass(), "consultarPlanillaAprobacion - solicitud="
				+ consultarPlanillaPeticion.getSolicitud());
				if (consultarPlanillaPeticion.getSolicitud() == null
						|| consultarPlanillaPeticion.getSolicitud().trim().isEmpty()) {
					throw new Exception("Es necesario el numero de solicitud para realizar la consulta.");
				}
				consultarPlanillaPeticion.setTotales(true);
				respuesta = solicitudesCredito.consultarPlanillaAprobacionTarea(uid, consultarPlanillaPeticion, null);
			}
		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		if (consultarPlanillaPeticion.getPlanillaJson() && respuesta.getHeader().isEstatus()) {
			respuestaJSON = respuesta.getJsonPlanilla();
			LogHandler.info(uid, getClass(), "consultarPlanillaAprobacion - Datos de salida :" + respuestaJSON);
		} else {
			respuestaJSON = transformador.transformaObjetoAJSON(uid, respuesta);
			LogHandler.info(uid, getClass(), "consultarPlanillaAprobacion - Datos de salida :" + respuestaJSON);
		}

		return respuestaJSON;
	}

	/**
	 * Correccion de observaciones por la sucursal
	 * @param peticion the peticion
	 * @return the string
	 */
	public String correccionPlanillaObservacionesSucursal(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "correccionPlanillaObservacionesSucursal - Datos de entrada :  peticion=" + peticion);

		CorregirPlaObsSucRespuesta respuesta = null;
		try {
			final Class<?>[] clases = {CorregirPlaObsSucPeticion.class,
					EncabezadoRespuesta.class};

			CorregirPlaObsSucPeticion planillaPeticion =
					(CorregirPlaObsSucPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);

			LogHandler.info(uid, getClass(), "correccionPlanillaObservacionesSucursal :  planillaPeticion="
					+ planillaPeticion);

			if (planillaPeticion.getSolicitud() == null || planillaPeticion.getSolicitud().trim().isEmpty()) {
				throw new Exception("Es necesario el numero de solicitud para realizar la correccion.");
			}
			if (planillaPeticion.getIdTarea() == null) {
				throw new Exception("Es necesario el id de la tarea para realizar la correccion.");
			}
			if (planillaPeticion.getProceso() == null || planillaPeticion.getProceso().trim().isEmpty()) {
				throw new Exception("Es necesario el proceso para realizar la correccion.");
			}
			if (planillaPeticion.getCodigoResolucion() == null || planillaPeticion.getCodigoResolucion().trim().isEmpty()) {
				throw new Exception("Es necesario el codigo de resolucion para realizar la correccion.");
			}
			if (planillaPeticion.getUsuario() == null || planillaPeticion.getUsuario().trim().isEmpty()) {
				throw new Exception("Es necesario el usuario para realizar la correccion.");
			}

			respuesta =	solicitudesCredito.corregirPlanillaObservacionesSucursalTarea(uid, planillaPeticion);
		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON =  transformador.transformaObjetoAJSON(uid, respuesta);
		LogHandler.info(uid, getClass(), "correccionPlanillaObservacionesSucursal - Datos de salida :");
		return respuestaJSON;
	}

	/**
	 * Consultar Planilla de Aprobacion en formato JSON
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarPlanillaAprobacionJson(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		PlanillaAprobacionRespuestaDTO respuesta = null;
		PlanillaAprobacionPeticionDTO consultarPlanillaPeticion = null;
		String respuestaJSON = null;
		try {
			final Class<?>[] clases = {PlanillaAprobacionPeticionDTO.class,
					EncabezadoRespuesta.class};
			consultarPlanillaPeticion =
					(PlanillaAprobacionPeticionDTO) transformador.transformaXMLAObjeto(uid, peticion, clases);

			if (consultarPlanillaPeticion.getIdPlanilla() == null || consultarPlanillaPeticion.getIdPlanilla() <= 0) {
				throw new Exception("Es necesario el idPlanilla para realizar la consulta.");
			}
			respuesta = solicitudesCredito.consultarPlanillaAprobacionTarea(uid, consultarPlanillaPeticion, null);

		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}
		if (consultarPlanillaPeticion.getPlanillaJson() && respuesta.getHeader().isEstatus()) {
			respuestaJSON = respuesta.getJsonPlanilla();
			LogHandler.info(uid, getClass(), "consultarPlanillaAprobacionJson - Datos de salida :" + respuestaJSON);
		} else {
			respuestaJSON = transformador.transformaObjetoAJSON(uid, respuesta);
			LogHandler.info(uid, getClass(), "consultarPlanillaAprobacionJson - Datos de salida :" + respuestaJSON);
		}
		return respuestaJSON;
	}

	/**
	 * Registro de inicio de gestion del CEC por solicitud
	 * @param peticion the peticion
	 * @return the string
	 */
	public String registroInicioGestionCEC(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "registroInicioGestionCEC - Datos de entrada :  peticion=" + peticion);

		ExcepcionGarantiaRespuesta respuesta = new ExcepcionGarantiaRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		try {
			final Class<?>[] clases = {ExcepcionGarantiaPeticion.class,
					EncabezadoRespuesta.class};
			ExcepcionGarantiaPeticion exTareaPeticion =
					(ExcepcionGarantiaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);

			if (exTareaPeticion.getIdTarea() == null) {
				throw new Exception("Es necesario id de la tarea para registrar el inicio gestion.");
			}

			if (exTareaPeticion.getIdTarea() <= 0) {
				throw new Exception("El id tarea enviado no es valido debe ser mayor a cero.");
			}

			respuesta =	solicitudesCredito.registroInicioGestionCEC(uid, exTareaPeticion);
			LogHandler.info(uid, getClass(), "registroInicioGestionCEC - Datos de salida: " + respuesta);
		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON =  transformador.transformaObjetoAJSON(uid, respuesta);
		LogHandler.info(uid, getClass(), "registroInicioGestionCEC - Datos de salida :");
		return respuestaJSON;
	}

	/**
	 * Obtener la informacion de la tarea de excepcion de garantia
	 * @param peticion the peticion
	 * @return the string
	 */
	public String obtenerBuzonExcepcionGarantiaPorIdTareaCEC(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "obtenerBuzonExcepcionGarantiaPorIdTareaCEC - Datos de entrada :  peticion=" + peticion);
		ExcepcionGarantiaRespuesta respuesta = null;
		try {
			final Class<?>[] clases = {ExcepcionGarantiaPeticion.class,
					EncabezadoRespuesta.class};
			ExcepcionGarantiaPeticion exTareaPeticion =
					(ExcepcionGarantiaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);

			if (exTareaPeticion.getIdTarea() == null) {
				throw new Exception("Es necesario id tarea para obtener las tareas excepcion.");
			}
			if (exTareaPeticion.getIdTarea() <= 0) {
				throw new Exception("El id tarea enviado no es valido debe ser mayor a cero.");
			}

			respuesta =	solicitudesCredito.obtenerBuzonExcepcionGarantiaPorIdTareaTarea(uid, exTareaPeticion);
			LogHandler.info(uid, getClass(), "obtenerBuzonExcepcionGarantiaPorIdTareaCEC - Datos de salida: " + respuesta);
		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}
		final java.lang.String respuestaJSON =  transformador.transformaObjetoAJSON(uid, respuesta);
		LogHandler.info(uid, getClass(), "obtenerBuzonExcepcionGarantiaPorIdTareaCEC - Datos de salida :");
		return respuestaJSON;

	}

	/**
	 * Dar por enterada la sucursal de la tarea de excepcion de garantia
	 * @param peticion the peticion
	 * @return the string
	 */
	public String accionEnteradoIdTareaExcepcion(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "accionEnteradoIdTareaExcepcion - Datos de entrada :  peticion=" + peticion);
		ExcepcionGarantiaRespuesta respuesta = null;
		try {
			final Class<?>[] clases = {ExcepcionGarantiaPeticion.class,
					EncabezadoRespuesta.class};
			ExcepcionGarantiaPeticion exTareaPeticion =
					(ExcepcionGarantiaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);

			if (exTareaPeticion.getIdTarea() == null) {
				throw new Exception("Es necesario id de la tarea para la accion enterado la excepcion.");
			}
			if (exTareaPeticion.getIdTarea() <= 0) {
				throw new Exception("El id tarea enviado no es valido debe ser mayor a cero.");
			}
			respuesta =	solicitudesCredito.accionEnteradoIdTareaExcepcion(uid, exTareaPeticion);
			LogHandler.info(uid, getClass(), "accionEnteradoIdTareaExcepcion - Datos de salida: " + respuesta);
		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON =  transformador.transformaObjetoAJSON(uid, respuesta);
		LogHandler.info(uid, getClass(), "accionEnteradoIdTareaExcepcion - Datos de salida :");
		return respuestaJSON;
	}

	/**
	 * Obtener el nombre del Divisional que autorizo la excepcion de garantia
	 * @param peticion the peticion
	 * @return the string
	 */
	public String obtenerExcepcionNombreDivisional(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "obtenerExcepcionNombreDivisional - Datos de entrada :  peticion=" + peticion);

		ExcepcionGarantiaRespuesta respuesta = null;
		try {
			final Class<?>[] clases = {ExcepcionGarantiaPeticion.class,
					EncabezadoRespuesta.class};
			ExcepcionGarantiaPeticion exTareaPeticion =
					(ExcepcionGarantiaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);

			if (exTareaPeticion.getSolicitud() == null || exTareaPeticion.getSolicitud().trim().isEmpty()) {
				throw new Exception("Es necesario id de la solicitud para obtener las tareas excepcion.");
			}
			respuesta =	solicitudesCredito.obtenerExcepcionNombreDivisionalTarea(uid, exTareaPeticion);
			LogHandler.info(uid, getClass(), "obtenerExcepcionNombreDivisional - Datos de salida: " + respuesta);
		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON =  transformador.transformaObjetoAJSON(uid, respuesta);
		LogHandler.info(uid, getClass(), "obtenerExcepcionNombreDivisional - Datos de salida :");
		return respuestaJSON;
	}

	/**
	 * Generar la tarea de excepcion de garantia
	 * @param peticion the peticion
	 * @return the string
	 */
	public String generarTareaExcepcionGarantiaModulo(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "generarTareaExcepcionGarantia - Datos de entrada :  peticion=" + peticion);
		ExcepcionGarantiaRespuesta respuesta = null;
		try {
			final Class<?>[] clases = {ExcepcionGarantiaPeticion.class,
					EncabezadoRespuesta.class};
			ExcepcionGarantiaPeticion exTareaPeticion =
					(ExcepcionGarantiaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);

			if (exTareaPeticion.getTipoTarea() == null || exTareaPeticion.getTipoTarea().trim().isEmpty()) {
				throw new Exception("Es necesario el numero de solicitud para generar tarea excepcion.");
			}
			if (exTareaPeticion.getSucursal() == null || exTareaPeticion.getSucursal().trim().isEmpty()) {
				throw new Exception("Es necesario el numero de sucursal para generar tarea excepcion.");
			}
			if (exTareaPeticion.getDescripcion() == null || exTareaPeticion.getDescripcion().trim().isEmpty()) {
				throw new Exception("Es necesarila descripcion para generar tarea excepcion.");
			}
			if (exTareaPeticion.getUsuarioAlta() == null || exTareaPeticion.getUsuarioAlta().trim().isEmpty()) {
				throw new Exception("Es necesario el usuarioAlta para generar tarea excepcion.");
			}
			if (exTareaPeticion.getPerfil() == null || exTareaPeticion.getPerfil().trim().isEmpty()) {
				throw new Exception("Es necesario el perfil para generar tarea excepcion.");
			}
			if (exTareaPeticion.getStatus() == null || exTareaPeticion.getStatus().trim().isEmpty()) {
				throw new Exception("Es necesario el status para generar tarea excepcion.");
			}
			if (exTareaPeticion.getJustificacion() == null || exTareaPeticion.getJustificacion().trim().isEmpty()) {
				throw new Exception("Es necesarila justificacion para generar tarea excepcion.");
			}

			respuesta =	solicitudesCredito.generarTareaExcepcionGarantiaTarea(uid, exTareaPeticion, null);
			LogHandler.info(uid, getClass(), "generarTareaExcepcionGarantia - Datos de salida: " + respuesta);
		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON =  transformador.transformaObjetoAJSON(uid, respuesta);
		LogHandler.info(uid, getClass(), "generarTareaExcepcionGarantia - Datos de salida :");
		return respuestaJSON;
	}

	/**
	 * Obtener las tareas de excepcion de garantia
	 * @param peticion the peticion
	 * @return the string
	 */
	public String obtenerBuzonExcepcionGarantiaModulo(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "obtenerBuzonExcepcionGarantiaTarea - Datos de entrada :  peticion=" + peticion);
		ExcepcionGarantiaRespuesta respuesta = null;
		try {
			final Class<?>[] clases = {ExcepcionGarantiaPeticion.class,
					EncabezadoRespuesta.class};
			ExcepcionGarantiaPeticion exTareaPeticion =
					(ExcepcionGarantiaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);

			if (exTareaPeticion.getIdDivision() == null) {
				throw new Exception("Es necesario id de division para obtener las tareas excepcion.");
			}

			respuesta =	solicitudesCredito.obtenerBuzonExcepcionGarantiaTarea(uid, exTareaPeticion);
			LogHandler.info(uid, getClass(), "obtenerBuzonExcepcionGarantia - Datos de salida: " + respuesta);
		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON =  transformador.transformaObjetoAJSON(uid, respuesta);
		LogHandler.info(uid, getClass(), "obtenerBuzonExcepcionGarantia - Datos de salida :");
		return respuestaJSON;

	}

	/**
	 * Obtener las tareas por tipo tarea
	 * @param peticion the peticion
	 * @return the string
	 */
	public String obtenerBuzonExPorTipoTareaModulo(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "obtenerBuzonExPorTipoTarea - Datos de entrada :  peticion=" + peticion);
		BuzonOV respuesta = null;
		try {
			final Class<?>[] clases = {ExcepcionGarantiaPeticion.class,
					EncabezadoRespuesta.class};
			ExcepcionGarantiaPeticion exTareaPeticion =
					(ExcepcionGarantiaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);

			if (exTareaPeticion.getTipoTarea() == null || exTareaPeticion.getTipoTarea().trim().isEmpty()) {
				throw new Exception("Es necesario tipo tarea para obtener las tareas excepcion.");
			}
			exTareaPeticion.setSucursal("0");
			respuesta =	solicitudesCredito.obtenerBuzonExPorTipoTareaTarea(uid, exTareaPeticion);
			LogHandler.info(uid, getClass(), "obtenerBuzonExPorTipoTarea - Datos de salida: " + respuesta);
		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON =  transformador.transformaObjetoAJSON(uid, respuesta);
		LogHandler.info(uid, getClass(), "obtenerBuzonExPorTipoTarea - Datos de salida :");
		return respuestaJSON;
	}

	/**
	 * Obtener complemento de las tareas de excepcion garantia
	 * @param peticion the peticion
	 * @return the string
	 */
	public String obtenerComplementoBuzonExcepcionGarantia(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "obtenerComplementoBuzonExcepcionGarantia - Datos de entrada :  peticion=" + peticion);

		ExcepcionGarantiaRespuesta respuesta = null;
		try {
			final Class<?>[] clases = {ExcepcionGarantiaPeticion.class,
					EncabezadoRespuesta.class};
			ExcepcionGarantiaPeticion exTareaPeticion =
					(ExcepcionGarantiaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);

			if (exTareaPeticion.getIdDivision() == null) {
				throw new Exception("Es necesario id de division para obtener las tareas excepcion.");
			}

			respuesta =	solicitudesCredito.obtenerComplementoBuzonExcepcionGarantiaTarea(uid, exTareaPeticion);
			LogHandler.info(uid, getClass(), "obtenerComplementoBuzonExcepcionGarantia - Datos de salida: " + respuesta);
		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON =  transformador.transformaObjetoAJSON(uid, respuesta);
		LogHandler.info(uid, getClass(), "obtenerComplementoBuzonExcepcionGarantia - Datos de salida :");
		return respuestaJSON;
	}

	/**
	 * Autoriza tarea de excepcion garantia
	 * @param peticion the peticion
	 * @return the string
	 */
	public String autorizaBuzonExcepcionModulo(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "autorizaBuzonExcepcion - Datos de entrada :  idTarea=" + peticion);
		ExcepcionGarantiaRespuesta respuesta = null;
		try {
			final Class<?>[] clases = {ExcepcionGarantiaPeticion.class,
					EncabezadoRespuesta.class};
			ExcepcionGarantiaPeticion exTareaPeticion =
					(ExcepcionGarantiaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);

			if (exTareaPeticion.getIdTarea() == null) {
				throw new Exception("Es necesario id de la tarea para autorizar la excepcion.");
			}
			if (exTareaPeticion.getTipoTarea() == null || exTareaPeticion.getTipoTarea().trim().isEmpty()) {
				throw new Exception("Es necesario el numero de solicitud para generar tarea excepcion.");
			}
			if (exTareaPeticion.getSucursal() == null || exTareaPeticion.getSucursal().trim().isEmpty()) {
				throw new Exception("Es necesario el numero de sucursal para generar tarea excepcion.");
			}
			if (exTareaPeticion.getDescripcion() == null || exTareaPeticion.getDescripcion().trim().isEmpty()) {
				throw new Exception("Es necesarila descripcion para generar tarea excepcion.");
			}
			if (exTareaPeticion.getUsuarioAlta() == null || exTareaPeticion.getUsuarioAlta().trim().isEmpty()) {
				throw new Exception("Es necesario el usuarioAlta para generar tarea excepcion.");
			}
			if (exTareaPeticion.getPerfil() == null || exTareaPeticion.getPerfil().trim().isEmpty()) {
				throw new Exception("Es necesario el perfil para generar tarea excepcion.");
			}
			if (exTareaPeticion.getStatus() == null || exTareaPeticion.getStatus().trim().isEmpty()) {
				throw new Exception("Es necesario el status para generar tarea excepcion.");
			}
			if (exTareaPeticion.getJustificacion() == null || exTareaPeticion.getJustificacion().trim().isEmpty()) {
				throw new Exception("Es necesarila justificacion para generar tarea excepcion.");
			}

			respuesta =	solicitudesCredito.autorizaBuzonExcepcionTarea(uid, exTareaPeticion);
			LogHandler.info(uid, getClass(), "autorizaBuzonExcepcion - Datos de salida: " + respuesta);
		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON =  transformador.transformaObjetoAJSON(uid, respuesta);
		LogHandler.info(uid, getClass(), "autorizaBuzonExcepcion - Datos de salida :");
		return respuestaJSON;
	}

	/**
	 * Rechaza tarea de excepcion garantia
	 * @param peticion the peticion
	 * @return the string
	 */
	public String rechazaBuzonExcepcionModulo(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "rechazaBuzonExcepcionTarea - Datos de entrada :  idTarea=" + peticion);
		ExcepcionGarantiaRespuesta respuesta = null;
		try {
			final Class<?>[] clases = {ExcepcionGarantiaPeticion.class,
					EncabezadoRespuesta.class};
			ExcepcionGarantiaPeticion exTareaPeticion =
					(ExcepcionGarantiaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);

			if (exTareaPeticion.getIdTarea() == null) {
				throw new Exception("Es necesario id de la tarea para autorizar la excepcion.");
			}
			if (exTareaPeticion.getTipoTarea() == null || exTareaPeticion.getTipoTarea().trim().isEmpty()) {
				throw new Exception("Es necesario el numero de solicitud para generar tarea excepcion.");
			}
			if (exTareaPeticion.getSucursal() == null || exTareaPeticion.getSucursal().trim().isEmpty()) {
				throw new Exception("Es necesario el numero de sucursal para generar tarea excepcion.");
			}
			if (exTareaPeticion.getDescripcion() == null || exTareaPeticion.getDescripcion().trim().isEmpty()) {
				throw new Exception("Es necesarila descripcion para generar tarea excepcion.");
			}
			if (exTareaPeticion.getUsuarioAlta() == null || exTareaPeticion.getUsuarioAlta().trim().isEmpty()) {
				throw new Exception("Es necesario el usuarioAlta para generar tarea excepcion.");
			}
			if (exTareaPeticion.getPerfil() == null || exTareaPeticion.getPerfil().trim().isEmpty()) {
				throw new Exception("Es necesario el perfil para generar tarea excepcion.");
			}
			if (exTareaPeticion.getStatus() == null || exTareaPeticion.getStatus().trim().isEmpty()) {
				throw new Exception("Es necesario el status para generar tarea excepcion.");
			}
			if (exTareaPeticion.getJustificacion() == null || exTareaPeticion.getJustificacion().trim().isEmpty()) {
				throw new Exception("Es necesarila justificacion para generar tarea excepcion.");
			}

			respuesta =	solicitudesCredito.rechazaBuzonExcepcionTarea(uid, exTareaPeticion);
			LogHandler.info(uid, getClass(), "rechazaBuzonExcepcionTarea - Datos de salida: " + respuesta);
		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON =  transformador.transformaObjetoAJSON(uid, respuesta);
		LogHandler.info(uid, getClass(), "rechazaBuzonExcepcionTarea - Datos de salida :");
		return respuestaJSON;
	}

	/**
	 * Obtener creditos anteriores para mostrar en la tarea de excepcion garantia
	 * @param peticion the peticion
	 * @return the string
	 */
	public String obtenerCreditosAnteriores(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "obtenerCreditosAnteriores - Datos de entrada :  numeroGrupo =" + peticion);
		BuroCreditoClienteDetalleGrupoRespuesta respuesta = null;

		try {
			final Class<?>[] clases = {BuroCreditoClienteDetalleGrupoPeticion.class,
					EncabezadoRespuesta.class};
			BuroCreditoClienteDetalleGrupoPeticion buroPeticion =
					(BuroCreditoClienteDetalleGrupoPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);

			if (buroPeticion.getPrmGrupo() == null || buroPeticion.getPrmGrupo().trim().isEmpty()) {
				throw new Exception("Es necesario el numero de grupo para obtener los creditos anteriores.");
			}
			//Llamado a funcion principal
			respuesta = buroCreditoTarea.prGetDetalleGrupoTarea(uid, buroPeticion);
			LogHandler.info(uid, getClass(), "obtenerCreditosAnteriores - Datos de salida: " + respuesta);
		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON =  transformador.transformaObjetoAJSON(uid, respuesta);
		LogHandler.info(uid, getClass(), "obtenerCreditosAnteriores - Datos de salida :");
		return respuestaJSON;
	}

	 /**
     * Consulta por contrato para renovacion de la simplificacion.
     * @param peticion datos de entrada como el contrato.
     * @return ContratoRenovacionRespuesta respuesta de la peticion
     */
	public ContratoRenovacionRespuesta consultarContratoRenovacion(ContratoRenovacionPeticion peticion) {
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "consultarContratoRenovacion - Datos de entrada : " + peticion);
		final ContratoRenovacionRespuesta
			respuesta = solicitudesCredito.consultarContratoRenovacion(uid, peticion);
		LogHandler.info(uid, getClass(), "consultarContratoRenovacion - Datos de salida : "
				+ respuesta);
		return respuesta;
	}

	/**
	 * Deveulve la informacion para llenar el reporte de solicitud  de credito comunal
	 * @param peticion datos de entrada como el contrato
	 * @return SimplificacionRenovacion respuesta de la peticion
	 */
	public SimplificacionRenovacion informacionSolicitudCredito(ContratoRenovacionPeticion peticion) {
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "informacionSolicitudCreditoComunal - Datos de entrada : " + peticion);
		final SimplificacionRenovacion
			respuesta = solicitudesCredito.informacionSolicitudCredito(uid, peticion);
		LogHandler.info(uid, getClass(), "informacionSolicitudCreditoComunal - Datos de salida : "
				+ respuesta);
		return respuesta;
	}

	/**
	 * Deveulve la informacion de un grupo de personas y la información de su último crédito sin considerar oportunidad
	 * @param peticion datos de entrada de la persona
	 * @return PersonasCreditoRespuesta respuesta de la peticion
	 */
	public PersonasCreditoRespuesta consultaPersonasCredito(PersonasCreditoPeticion peticion) {
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "consultaPersonasCredito - Datos de entrada : " + peticion);
		final PersonasCreditoRespuesta
			respuesta = solicitudesCredito.informacionPersonasCredito(uid, peticion);
		LogHandler.info(uid, getClass(), "consultaPersonasCredito - Datos de salida : "
				+ respuesta);
		return respuesta;
	}

	/**
	 * Devuele la lista de documentos en blanco a imprimir
	 * @param peticion no lleva nada po el momento
	 * @return lista documentos
	 */
	public ContratoRenovacionRespuesta obtenerDocumentosBlancos(ContratoRenovacionPeticion peticion) {
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "obtenerDocumentosBlancos - Datos de entrada : " + peticion);
		final ContratoRenovacionRespuesta
			respuesta = solicitudesCredito.obtenerDocumentosBlancos(uid, peticion);
		LogHandler.info(uid, getClass(), "obtenerDocumentosBlancos - Datos de salida : "
				+ respuesta);
		return respuesta;
	}

	/**
	 * Actualiza la pantalla de Analista Documental BC.
	 * @param peticion parametro de peticion tipo SolicitudExcepcionDocumental
	 * @return SolicitudExcepcionDocumentalRespuesta
	 */
	public SolicitudExcepcionDocumentalRespuesta registrarSolicitudAnalistaBC(SolicitudExcepcionDocumental peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "registrarSolicitudAnalistaBC: - Datos de entrada : " + peticion);
		final SolicitudExcepcionDocumentalRespuesta respuesta
			= solicitudesCredito.registrarSolicitudAnalistaBCTarea(uid, peticion);
		LogHandler.info(uid, getClass(), "registrarSolicitudAnalistaBC: - Datos de salida: " + respuesta);

		return respuesta;
	}

	/**
	 * Metodo para actualizar la solicitud de Analista Documental BC
	 * @param peticion peticion de solicitud
	 * @return XML de respuesta
	 */
	public String actualizaSolicitudAnalistaBC(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "cancelarSolicitud: - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {SolicitudesPeticion.class,
									SolicitudesOV.class,
									SolicitudIntegrantesOV.class,
									SolicitudesRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final SolicitudesPeticion solicitudesPeticion =
			(SolicitudesPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "actualizaSolicitudAnalistaBC: - Datos de entrada : " + solicitudesPeticion);

		//Llamado a funci?n principal
		final SolicitudesRespuesta respuesta = solicitudesCredito.actualizaSolicitudAnalistaBCTarea(uid, solicitudesPeticion);
		LogHandler.info(uid, getClass(), "actualizaSolicitudAnalistaBC: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "actualizaSolicitudAnalistaBC: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;

	}

	/**
	 * Metodo que se utiliza para validar el numero de integrantes para
	 * la pantalla del Analista Documental BC.
	 * @param peticion SolicitudSACGPeticion
	 * @return ValidarGuardarSolicitudCECRespuesta
	 */
	public String validaNumeroIntegrantesAnalistaBC(String peticion) {

		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "- Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {SolicitudSACG.class,
									SolicitudSACGIntegrante.class,
									SolicitudSACGPeticion.class,
									SolicitudesRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final SolicitudSACGPeticion solicitudesSACGPeticion =
			(SolicitudSACGPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "- Datos de entrada : " + solicitudesSACGPeticion);

		//Llamado a funci?n principal
		final SolicitudesRespuesta respuesta = solicitudesCredito.validaNumeroIntegrantesAnalistaBCTarea(
				uid, solicitudesSACGPeticion);
		LogHandler.info(uid, getClass(), "- Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "- Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}


	/**
	 * Consultar buzon de tareas.
	 * @param peticion the peticion
	 * @return the string
	 */
	public String consultarBuzonAnalistaDocumental(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "consultarBuzonAnalistaDocumental: - Datos de entrada : " + peticion);

		BuzonOV respuesta = null;

		try {
			//Parametros de entrada
			final Class<?>[] clases = {PeticionModuloCEC.class,
										EncabezadoRespuesta.class};

			final PeticionModuloCEC peticionTarea =
					(PeticionModuloCEC) transformador.transformaXMLAObjeto(uid, peticion, clases);

			if (peticionTarea.getPersonaAnalista() == null || peticionTarea.getPersonaAnalista().trim().isEmpty()) {
				throw new Exception("Es necesario el numero de persona del Analista para realizar la consulta.");
			}
			if (peticionTarea.getSucursal() == null) {
				throw new Exception("Es necesario el numero sucursal para realizar la consulta.");
			}
			if (peticionTarea.getPerfil() == null || peticionTarea.getPerfil().trim().isEmpty()) {
				throw new Exception("Es necesario el perfil para realizar la consulta.");
			}

			ConsultaBuzonPeticion   peticionBuzon = new ConsultaBuzonPeticion();
			peticionBuzon.setPerfil(peticionTarea.getPerfil());
			peticionBuzon.setSucursal(Integer.valueOf(peticionTarea.getSucursal()));
			peticionBuzon.setUsuarioPropietario(peticionTarea.getPersonaAnalista());
			peticionBuzon.setTipoTarea("TRED");
			peticionBuzon.setStatus("P");

			respuesta =	consultas.consultaBuzonAnalistaDocumental(uid, peticionBuzon);

			LogHandler.info(uid, getClass(), "consultarBuzonAnalistaDocumental - Datos de salida: ");
		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON = transformador.transformaObjetoAJSON(uid, respuesta);
		return respuestaJSON;
	}

	/**
	 * Metodo para eliminar una cliente de la pantalla Analista Documental BC
	 * @param peticion solicitudPeticion
	 * @return SolicitudExcepcionDocumentalRespuesta
	 */
	public SolicitudExcepcionDocumentalRespuesta eliminaClienteAnalistaBC(SolicitudExcepcionDocumental peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "eliminaClienteAnalistaBC: - Datos de entrada : " + peticion);
		final SolicitudExcepcionDocumentalRespuesta respuesta
			= solicitudesCredito.eliminaClienteAnalistaBCTarea(uid, peticion);
		LogHandler.info(uid, getClass(), "eliminaClienteAnalistaBC: - Datos de salida: " + respuesta);

		return respuesta;
	}

		/**
	 * Metodo para consultar catalogo de regiones
	 * @param peticion ConsultaCatalogoPeticionCIOF
	 * @return ConsultaCatalogoRespuestaCIOF
	 */
	public ConsultaCatalogoRespuestaCIOF consultaCatalogoRegiones(ConsultaCatalogoPeticionCIOF peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info( uid, this.getClass(), "consultaCatalogoRegiones");
		final ConsultaCatalogoRespuestaCIOF respuesta
			= solicitudesCredito.consultaCatalogoRegiones(uid, peticion);
		LogHandler.info(uid, getClass(), "consultaCatalogoRegiones: - Datos de salida: " + respuesta);
		return respuesta;
	}

	/**
	 * Actualiza los estus de la tarea excepcion campaña.
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta actualizacionAutomaticaTareaCampana() {
		final java.lang.String uid  = GUIDGenerator.generateGUID("");
		LogHandler.info(uid, getClass(), "actualizacionAutomaticaTareaCampana: - Datos de entrada  " );
		ExcepcionGarantiaRespuesta respuesta = solicitudesCredito.actualizacionAutomaticaTareaCampana(uid);
		LogHandler.info(uid, getClass(), "actualizacionAutomaticaTareaCampana: - Datos de salida: " + respuesta);
		return respuesta;
	}

	/**
	 * Actualiza los estus de la tarea excepcion campaña.
	 * @param peticion the excepcion garantia peticion
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta actualizarTareaCampana(ExcepcionGarantiaPeticion peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "actualizarTareaCampana: - Datos de entrada : " + peticion);
		ExcepcionGarantiaRespuesta respuesta = solicitudesCredito.actualizarTareaCampana(uid, peticion);
		LogHandler.info(uid, getClass(), "actualizarTareaCampana: - Datos de salida: " + respuesta);
		return respuesta;
	}

	/**
	 * Método para obtener el detalle de una solicitud con excepción de cupo y monto
	 * @param idTarea idTarea
	 * @return ExcepcionMontoCupoRespuesta
	 */
	public ExcepcionMontoCupoRespuesta consultaSolicitudExcepcionMontoCupo(String idTarea) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( idTarea );

		LogHandler.info(uid, getClass(), "consultaSolicitudExcepcionMontoCupo: - Datos de entrada : " + idTarea);
		final ExcepcionMontoCupoRespuesta respuesta
			= solicitudesCredito.consultaSolicitudExcepcionMontoCupoTarea(uid, idTarea);
		LogHandler.info(uid, getClass(), "consultaSolicitudExcepcionMontoCupo: - Datos de salida: " + respuesta);

		return respuesta;
	}

	/**
	 * Metodo para obtener el catalogo de los nombres de los asesores de credito
	 * para simplificacion de renovacion 2
	 * @param peticion tipo ConsultaCatalogoPeticionCIOF
	 * @return ConsultaCatalogoRespuestaCIOF
	 */
	public ConsultaCatalogoRespuestaCIOF consultarCatalogoAsesoresCredito(
			ConsultaCatalogoPeticionCIOF peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info( uid, this.getClass(), "consultaCatalogoAsesoresCredito");
		final ConsultaCatalogoRespuestaCIOF respuesta
			= solicitudesCredito.consultarCatalogoAsesoresCredito(uid, peticion);
		LogHandler.info(uid, getClass(), "consultaCatalogoAsesoresCredito: - Datos de salida: " + respuesta);
		return respuesta;
	}


	/**
	 * Metodo para obtener el catalogo de los nombres de los gerentes
	 * regionales para simplificacion de renovacion 2
	 * @param peticion tipo ConsultaCatalogoPeticionCIOF
	 * @return ConsultaCatalogoRespuestaCIOF
	 */
	public ConsultaCatalogoRespuestaCIOF consultarCatalogoGerentesRegionales(
			ConsultaCatalogoPeticionCIOF peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info( uid, this.getClass(), "consultaCatalogoRegiones");
		final ConsultaCatalogoRespuestaCIOF respuesta
			= solicitudesCredito.consultarCatalogoGerentesRegionales(uid, peticion);
		LogHandler.info(uid, getClass(), "consultaCatalogoGerentesReginales: - Datos de salida: " + respuesta);
		return respuesta;
	}


	/**
	 * metodo para obtener el catalogo de los nombres de los gerentes de sucursales
	 * para simplificacion de la renovacion
	 * @param peticion tipo ConsultaCatalogoPeticionCIOF
	 * @return ConsultaCatalogoRespuestaCIOF
	 */
	public ConsultaCatalogoRespuestaCIOF consultarCatalogoGerentesSucursal(
			ConsultaCatalogoPeticionCIOF peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info( uid, this.getClass(), "consultaCatalogoGerentesSucursal");
		final ConsultaCatalogoRespuestaCIOF respuesta
			= solicitudesCredito.consultarCatalogoGerenteSucursal(uid, peticion);
		LogHandler.info(uid, getClass(), "consultaCatalogoGerentesSucursal: - Datos de salida: " + respuesta);
		return respuesta;
	}

	/**
	 * Metodo que valida producto de simplificacion
	 * renovacion ContratoRenovacionRespuesta con mensajes de las validaciones
	 * @param peticion tipo ContratoRenovacionPeticion
	 * @return ContratoRenovacionRespuesta
	 */
	public ContratoRenovacionRespuesta validarSimplificacionRenovacionProductos(
			ContratoRenovacionPeticion peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info( uid, this.getClass(), "validarSimplificacionRenovacionProductos");
		final ContratoRenovacionRespuesta respuesta
			= solicitudesCredito.validarSimplificacionRenovacionProductos(uid, peticion);
		LogHandler.info(uid, getClass(), "validarSimplificacionRenovacionProductos: - Datos de salida: " + respuesta);
		return respuesta;
	}

	/**
	 * Método que se utiliza para consultar las solicitudes que se van a reactivar
	 *
	 * @param uid uid
	 * @param peticion tipo ReactivarSolicitudesPeticion
	 * @return ReactivarSolicitudesRespuesta  tipo ReactivarSolicitudesRespuesta
	 */
	public ReactivarSolicitudesRespuesta consultaReactivarSolicitudes(String uid, ReactivarSolicitudesPeticion peticion) {
		LogHandler.info(uid, getClass(), "consultaReactivarSolicitudes: - Datos de entrada  " );
		ReactivarSolicitudesRespuesta respuesta = solicitudesCredito.consultaReactivarSolicitudesTarea(uid, peticion);
		LogHandler.info(uid, getClass(), "consultaReactivarSolicitudes: - Datos de salida: " + respuesta);
		return respuesta;
	}

	/**
	 * Metodo que se utilizar para volver a insertar y reactivar la solicitud.
	 *
	 * @param uid uid
	 * @param solicitud solicitud a reactivar
	 * @param usuario que genera la reactivacion
	 * @return ReactivarSolicitudesRespuesta  tipo ReactivarSolicitudesRespuesta
	 */
	public ReactivarSolicitudesRespuesta insertaReactivarSolicitudes(String uid, String solicitud, String usuario) {
		LogHandler.info(uid, getClass(), "insertaReactivarSolicitudes: - Datos de entrada  - solicitud "  + solicitud);
		ReactivarSolicitudesRespuesta respuesta = solicitudesCredito.insertaReactivarSolicitudesTarea(uid, solicitud, usuario);
		LogHandler.info(uid, getClass(), "insertaReactivarSolicitudes: - Datos de salida: " + respuesta);
		return respuesta;
	}

	/**
	 * Método que se utiliza para consultar las solicitudes que se ya se reactivaron y
	 * se van a mostrar en el ModuloCEC
	 *
	 * @param uid uid
	 * @param solicitud Consulta la solicitud si ya fue reactivada
	 * @return SolicitudesRespuesta  tipo ReactivarSolicitudesRespuesta
	 */
	public SolicitudesRespuesta consultaReactivarSolicitudesModuloCEC(String uid, String solicitud) {
		SolicitudesRespuesta respuesta = new SolicitudesRespuesta();
		LogHandler.info(uid, getClass(), "consultaReactivarSolicitudesModuloCEC: - Datos de entrada  " );
		respuesta = solicitudesCredito.consultaReactivarSolicitudesModuloCECTarea(uid, solicitud);
		LogHandler.info(uid, getClass(), "consultaReactivarSolicitudesModuloCEC: - Datos de salida: " + respuesta);
		return respuesta;
	}

	/**
	 * M&eacute;todo que envia un correo con el resumen de una solicitud
	 * @param peticion datos de la peticion
	 * @return ExcepcionGarantiaRespuesta respuesta
	 */
	public ExcepcionGarantiaRespuesta enviarCorreoSolicitud(ResumenBuroPeticion peticion) {
		String uid = peticion == null ? "" : peticion.getUid();
		LogHandler.info(uid, getClass(), "enviarCorreoSolicitud: - Datos de entrada  - solicitud "  + peticion);
		ExcepcionGarantiaRespuesta respuesta = new ExcepcionGarantiaRespuesta();
		respuesta = solicitudesCredito.enviarCorreoSolicitud(uid, peticion);
		LogHandler.info(uid, getClass(), "enviarCorreoSolicitud: - Datos de salida: " + respuesta);
		return respuesta;
	}

	/**
	 * M&eacute;todo que regresa la informacion del resumen de una solicitud
	 * @param peticion datos d el apeticion
	 * @return ResumenBuroRespuesta respuesta
	 */
	public ResumenBuroRespuesta resumenSolicitudBuro(ResumenBuroPeticion peticion) {
		String uid = peticion == null ? "" : peticion.getUid();
		LogHandler.info(uid, getClass(), "resumenSolicitudBuro: - Datos de entrada  - solicitud "  + peticion);
		ResumenBuroRespuesta respuesta = solicitudesCredito.resumenSolicitudBuro(uid, peticion);
		LogHandler.info(uid, getClass(), "resumenSolicitudBuro: - Datos de salida: " + respuesta);
		return respuesta;
	}

	/**
	 * Generar Tarea  para registrar la justificación de excepción de cupos y montos.
	 * @param peticion justificación de excepción de cupos y montos
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta generarFirmaElectronica(FirmaElectronicaPeticion peticion) {
		String uid = peticion == null ? "" : peticion.getUid();
		if (uid == null || uid.trim().isEmpty()) {
			uid = GUIDGenerator.generateGUID( peticion );
		}
		LogHandler.info(uid, getClass(), "generarFirmaElectronicaTarea: - Datos de entrada  - "  + peticion);
		ExcepcionGarantiaRespuesta respuesta = solicitudesCredito.generarFirmaElectronicaTarea(uid, peticion);
		LogHandler.info(uid, getClass(), "generarFirmaElectronicaTarea: - Datos de salida: " + respuesta);
		return respuesta;
	}

	/**
	 * Metodo que envia mensaje encaso de que la solicitud lleve mas de
	 * seis hora sin contestar en un horario habil de 8 a 20 horas
	 * @param peticion observacion de firma electronica
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta mensajeTiempo(ResumenBuroPeticion peticion) {
		String uid = peticion == null ? "" : peticion.getUid();
		if (uid == null || uid.trim().isEmpty()) {
			uid = GUIDGenerator.generateGUID( peticion );
		}
		LogHandler.info(uid, getClass(), "mensajeTiempo: - Datos de entrada  - "  + peticion);
		ExcepcionGarantiaRespuesta respuesta = solicitudesCredito.mensajeTiempo(uid, peticion);
		LogHandler.info(uid, getClass(), "mensajeTiempo: - Datos de salida: " + respuesta);
		return respuesta;
	}

	/**
	 * Generar actualizacion de la tarea  para registrar la observacion y
	 * el codigo de rechazo de excepción de firma electronica.
	 *
	 * @param peticion observacion de firma electronica
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta actualizarTareaFirmaElectronica(ResumenBuroPeticion peticion) {
		String uid = peticion == null ? "" : peticion.getUid();
		if (uid == null || uid.trim().isEmpty()) {
			uid = GUIDGenerator.generateGUID( peticion );
		}
		LogHandler.info(uid, getClass(), "actualizarTareaFirmaElectronica: - Datos de entrada  - "  + peticion);
		ExcepcionGarantiaRespuesta respuesta = solicitudesCredito.actualizarTareaFirmaElectronica(uid, peticion);
		LogHandler.info(uid, getClass(), "actualizarTareaFirmaElectronica: - Datos de salida: " + respuesta);
		return respuesta;
	}

	/**
	 * M&eacute;todo que envia mensaje encaso de que que la solicitud este enproceso o alla sido rechazasa
	 * @param peticion observaci&oacute;n de firma electr&oacute;nica
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta checarEstatusTareaFE(ResumenBuroPeticion peticion) {
		String uid = peticion == null ? "" : peticion.getUid();
		if (uid == null || uid.trim().isEmpty()) {
			uid = GUIDGenerator.generateGUID( peticion );
		}
		LogHandler.info(uid, getClass(), "checarEstatusTareaFE: - Datos de entrada  - "  + peticion);
		ExcepcionGarantiaRespuesta respuesta = solicitudesCredito.checarEstatusTareaFE(uid, peticion);
		LogHandler.info(uid, getClass(), "checarEstatusTareaFE: - Datos de salida: " + respuesta);
		return respuesta;
	}

	/**
	 * M&eacute;todo que consulta los comentarios de divisionales y mensajes del CEC en el seguimiento de solicitudes.
	 * @param peticion contiene el idTarea y solicitud para la cual se requieren los comentarios.
	 * @return respuesta con los comentarios de divisionales y mensajes del CEC
	 */
	public ConsultaComentariosMensajesAtomosRespuesta consultaComentariosMensajesAtomosSolicitudSeguimiento(
			ConsultaComentariosMensajesAtomosPeticion peticion) {

		String uid = peticion == null ? "" : peticion.getUid();

		if (uid == null || uid.trim().isEmpty()) {
			uid = GUIDGenerator.generateGUID(peticion);
		}

		LogHandler.info(uid, getClass(), "consultaComentariosMensajesAtomosSolicitudSeguimiento: - Datos de entrada - "
				+ peticion);

		ConsultaComentariosMensajesAtomosRespuesta respuesta
			= solicitudesCredito.consultaComentariosMnjsSolicitudSegimientoTarea(uid, peticion);
		LogHandler.info(uid, getClass(), "consultaComentariosMensajesAtomosSolicitudSeguimiento: - Datos de salida - "
		+ respuesta);
		return respuesta;
	}

	/**
	 * M&eacute;todo que consulta la información del grupo de la planilla de observaciones
	 * @param peticion contiene la solicitud para la cual se requieren la informacion del grupo.
	 * @return respuesta con la información del grupo.
	 */
	public ConsultaSolicitudPlanillaObservacionesRespuesta consultaInformacionGrupoPlanilla(
			ConsultaSolicitudPlanillaObservacionesPeticion peticion) {

		String uid = peticion == null ? "" : peticion.getUid();

		if (uid == null || uid.trim().isEmpty()) {
			uid = GUIDGenerator.generateGUID(peticion);
		}

		LogHandler.info(uid, getClass(), "- Datos de entrada - " + peticion.getSolicitud());
		ConsultaSolicitudPlanillaObservacionesRespuesta respuesta
			= solicitudesCredito.consultaInformacionGrupoPlanillaTarea(uid, peticion);
		LogHandler.info(uid, getClass(), "- Datos de salida - " + respuesta);

		return respuesta;
	}
}
