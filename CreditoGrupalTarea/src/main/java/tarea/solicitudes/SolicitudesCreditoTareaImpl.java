package tarea.solicitudes;

import java.io.StringReader;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import mx.com.findep.crediseguros.webservice.finsol.CalculoCostoSeguroServiceLocator;

import org.apache.ibatis.session.SqlSession;
import org.joda.time.LocalDateTime;
import org.joda.time.Minutes;
import org.osoa.sca.annotations.Reference;
import org.tempuri.WSRecibeDatos_asmx.WSRecibeDatosLocator;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import tarea.administracion.AdministracionPersona;
import tarea.administracion.AdministracionTelefonica;
import tarea.burocredito.BuroCreditoTarea;
import tarea.burocredito.PlanillaAprobacion;
import tarea.comun.ComunTarea;
import tarea.comun.EnvioDeCorreos;
import tarea.comun.ReadProperties;
import tarea.consultas.Consultas;
import tarea.originacion.OriginacionConsultas;
import tarea.originacion.OriginacionGrupo;
import tarea.seguros.SegurosTarea;
import transformador.Transformador;
import utilitario.buzon.AvanceTrabajo;
import utilitario.buzon.BuzonOV;
import utilitario.buzon.ConsultaAvanceTrabajoPeticion;
import utilitario.buzon.ConsultaAvanceTrabajoRespuesta;
import utilitario.buzon.TareaOV;
import utilitario.comun.CatalogoFormatos;
import utilitario.comun.Constantes;
import utilitario.comun.FechaTiempo;
import utilitario.comun.Funciones;
import utilitario.comun.Validaciones;
import utilitario.log.LogHandler;
import utilitario.mensajes.burocredito.BuroCreditoPlanillaAprobacionPeticion;
import utilitario.mensajes.burocredito.BuroCreditoPlanillaAprobacionRespuesta;
import utilitario.mensajes.burocredito.ConsultaBuroPeticion;
import utilitario.mensajes.burocredito.ConsultaBuroRespuesta;
import utilitario.mensajes.burocredito.ResumenBuroCliente;
import utilitario.mensajes.burocredito.ResumenBuroPeticion;
import utilitario.mensajes.burocredito.ResumenBuroRespuesta;
import utilitario.mensajes.burocredito.ValidaSolicitudPeticion;
import utilitario.mensajes.comun.CatalogosOV;
import utilitario.mensajes.comun.ConsultaCatalogoPeticionCIOF;
import utilitario.mensajes.comun.ConsultaCatalogoRespuestaCIOF;
import utilitario.mensajes.comun.DomicilioOV;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.FechaContableOV;
import utilitario.mensajes.comun.ResultadoOV;
import utilitario.mensajes.consultas.AsignacionDetalleOV;
import utilitario.mensajes.consultas.ConsultaCreditoPeticion;
import utilitario.mensajes.consultas.DatosCreditoIntegrantesRespuesta;
import utilitario.mensajes.consultas.DatosIntegranteResumenOV;
import utilitario.mensajes.consultas.SucursalOV;
import utilitario.mensajes.consultas.VerificaAsignacionRespuesta;
import utilitario.mensajes.correo.EnviarCorreoRespuesta;
import utilitario.mensajes.impresiondocs.comun.ContratoPeticionKit;
import utilitario.mensajes.originacion.aprobacion.IntegranteCreditoPlanillaAprobacionDTO;
import utilitario.mensajes.originacion.aprobacion.IntegrantePlanillaAprobacionDTO;
import utilitario.mensajes.originacion.aprobacion.PlanillaAprobacionPeticionDTO;
import utilitario.mensajes.originacion.aprobacion.PlanillaAprobacionRespuestaDTO;
import utilitario.mensajes.originacion.consulta.ClientesGrupo;
import utilitario.mensajes.originacion.consulta.ConsultaFechaOV;
import utilitario.mensajes.originacion.consulta.ConsultaRespuesta;
import utilitario.mensajes.originacion.consulta.ContratoRenovacionPeticion;
import utilitario.mensajes.originacion.consulta.ContratoRenovacionRespuesta;
import utilitario.mensajes.originacion.consulta.DirectivaGrupo;
import utilitario.mensajes.originacion.consulta.DocumentosKit;
import utilitario.mensajes.originacion.consulta.ImpresionFormatos;
import utilitario.mensajes.originacion.consulta.IntegrantesKit;
import utilitario.mensajes.originacion.consulta.KitImpresionSimplificacionRenovacion;
import utilitario.mensajes.originacion.consulta.ObtenerMontosSegurosRespuesta;
import utilitario.mensajes.originacion.consulta.ParGeneralOV;
import utilitario.mensajes.originacion.consulta.SimplificacionRenovacion;
import utilitario.mensajes.originacion.contrato.ContratoOV;
import utilitario.mensajes.originacion.contrato.IntegranteOV;
import utilitario.mensajes.originacion.grupo.GrupoOV;
import utilitario.mensajes.persona.ValidarDatosPersonaPeticion;
import utilitario.mensajes.persona.ValidarDatosPersonaRespuesta;
import utilitario.mensajes.seguros.BeneficiariosClienteOV;
import utilitario.mensajes.seguros.PeticionConsulta;
import utilitario.mensajes.seguros.SegurosRespuestaConsulta;
import utilitario.mensajes.seguros.cliente;
import utilitario.mensajes.solicitudes.*;
import utilitario.mensajes.verificacion.telefonica.ConsultaInformacionTelefonicaPeticion;
import utilitario.mensajes.verificacion.telefonica.ConsultaInformacionTelefonicaRespuesta;
import utilitario.mensajes.verificacion.telefonica.RegistraBitacoraPeticion;
import utilitario.mensajes.verificacion.telefonica.RegistraBitacoraRespuesta;
import utilitario.reglas.solicitudes.InputReglasIncremento;
import utilitario.reglas.solicitudes.InputReglasTasaInteres;
import utilitario.reglas.solicitudes.ObtenerParametrosTasasOV;
import utilitario.reglas.solicitudes.ObtenerTasasOV;
import utilitario.reglas.solicitudes.PeticionReglaIncremento;
import utilitario.reglas.solicitudes.Response;
import utilitario.reglas.solicitudes.RespuestaAlmacenarPlanillaAprobacion;
import utilitario.reglas.solicitudes.RespuestaIntegrantesTasasOV;
import utilitario.reglas.solicitudes.RespuestaMaximoRetrasoOV;
import utilitario.reglas.solicitudes.RespuestaReglaIncremento;
import utilitario.reglas.solicitudes.RespuestaSolicitudTasasOV;
import utilitario.reglas.solicitudes.ValidaIntegranteDTO;
import utilitario.reglas.solicitudes.ValidaIntegrantePeticion;
import utilitario.reglas.solicitudes.ValidaIntegranteRespuesta;
import utilitario.reglas.solicitudes.ValidarIntegranteSolicitudPeticion;
import utilitario.reglas.solicitudes.ValidarIntegranteSolicitudRespuesta;
import utilitario.reglas.solicitudes.ValidarTasaInteresPeticion;
import utilitario.reglas.solicitudes.ValidarTasaInteresRespuesta;

import com.findep.finsol.asignacion.AsignacionRespuesta;
import com.findep.finsol.asignacion.AsignacionServiceServiceLocator;
import com.openrules.ruleengine.OpenRulesEngine;

import datamapper.DataMapper;
import entidad.conexiones.FabricaConexiones;

public class SolicitudesCreditoTareaImpl implements SolicitudesCreditoTarea {

	/**
	 * SCA Componente Fabric
	 */
	private ComunTarea comun;
	/**
	 * SCA Componente Fabric
	 */
	private OriginacionGrupo grupo;
	/**
	 * SCA Componente Fabric
	 */
	private Consultas consultas;
	/**
	 * SCA Componente Fabric
	 */
	private PlanillaAprobacion planilla;
	/**
	 * BuroCreditoTarea SCA
	 */
	private BuroCreditoTarea buroCreditoTarea;
	/**
	 * AdministracionPersona SCA
	 */
	private AdministracionPersona administracionPersona;

	/** The seguros. */
	private SegurosTarea seguros;

	/** The administracion telefonica. */
	private AdministracionTelefonica administracionTelefonica;

	/** The respuesta asignacion. */
	private AsignacionRespuesta respuestaAsignacion;

	/**
	 * SCA Componente Fabric
	 */
	private OriginacionConsultas consultasOriginacion;

	/** The transformador. */
	private Transformador transformador;

	/** The MAXIMO_VARCHAR. */
	private final static int MAXIMO_VARCHAR = 8000;

	/** The PORCENTAJE_INTEGRANTES. */
	private final static double PORCENTAJE_INTEGRANTES = 100.0;

	/** The PORCENTAJE_MONTO PRE APROBADO OPORTUNIDAD. */
	private final static double PORCENTAJE_MONTO_PREAPROBADO = 100.0;

	/**
	 * @param grupo
	 *            :
	 * @param comun
	 *            :
	 * @param planilla
	 *            :
	 * @param seguros
	 *            :
	 * @param administracionTelefonica
	 *            :
	 * @param administracionPersona
	 *            :
	 * @param buroCreditoTarea
	 *            fabric
	 * @param consultasOriginacion
	 *            fabric
	 * @param transformador
	 *            fabric
	 * @param consultas
	 *            Constructor
	 */
	public SolicitudesCreditoTareaImpl(
			@Reference(name = "comun") ComunTarea comun,
			@Reference(name = "grupo") OriginacionGrupo grupo,
			@Reference(name = "consultas") Consultas consultas,
			@Reference(name = "planilla") PlanillaAprobacion planilla,
			@Reference(name = "buroCreditoTarea") BuroCreditoTarea buroCreditoTarea,
			@Reference(name = "seguros") SegurosTarea seguros,
			@Reference(name = "administracionTelefonica") AdministracionTelefonica administracionTelefonica,
			@Reference(name = "administracionPersona") AdministracionPersona administracionPersona,
			@Reference(name = "consultasOriginacion") OriginacionConsultas consultasOriginacion,
			@Reference(name = "transformador") Transformador transformador) {
		this.comun = comun;
		this.grupo = grupo;
		this.consultas = consultas;
		this.planilla = planilla;
		this.buroCreditoTarea = buroCreditoTarea;
		this.administracionPersona = administracionPersona;
		this.seguros = seguros;
		this.administracionTelefonica = administracionTelefonica;
		this.consultasOriginacion = consultasOriginacion;
		this.transformador = transformador;
	}

	/**
	 * Metodo para registrar una solicitud
	 * 
	 * @param uid
	 *            String
	 * @param solicitudesPeticion
	 *            SolicitudesPeticion
	 * @return respuesta tipo SolicitudesRespuesta
	 */
	public SolicitudesRespuesta registrarSolicitudTarea(String uid,
			SolicitudesPeticion solicitudesPeticion) {
		SolicitudesRespuesta solicitudesRespuesta = new SolicitudesRespuesta();
		solicitudesRespuesta.setHeader(new EncabezadoRespuesta());
		solicitudesRespuesta.getHeader().setUID(uid);
		solicitudesRespuesta.getHeader().setEstatus(true);
		SqlSession sesionTx = null;
		SqlSession sesionNTx = null;
		List<SolicitudIntegrantesOV> solicitudIntegrantesOVList = new ArrayList<SolicitudIntegrantesOV>();
		SolicitudesOV solicitudesOV = null;
		String mensaje = "";
		String validaStr = "";
		try {
			// Se abre la conexion hacia la base de datos
			sesionTx = FabricaConexiones.obtenerSesionTx();
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			solicitudesOV = solicitudesPeticion.getSolicitud();
			if (solicitudesOV == null) {
				// throw new
				// Exception(ReadProperties.mensajes.getProp("solicitudes.registrar.peticion.datos.incorrectos"));
				throw new Exception(DATOS_INCORRECTOS);
			}

			java.util.HashMap<String, Object> solicitudParametros = new java.util.HashMap<String, Object>();

			solicitudIntegrantesOVList = solicitudesPeticion.getIntegrantes();

			String[] integranteDatosRequeridos = { "autorizoConsultaImss",
					"bcScore", "cargoMesaDirectiva", "chequePara",
					"clasificacionFira", "claveImss", "claveResoImss",
					"claveResoInfonavit", "cliente", "codigoDestinoCredito",
					"contratoAnterior", "efectivoOtorgado",
					"efectivoSolicitado", "egresos", "etapa", "etapaAnterior",
					"findepScore", "hitBc", "ingresos", "medioContacto",
					"montoAhorro", "montoContratoAnterior",
					"montoFinanciadoContAnt", "montoOtorgado", "montoPago",
					"montoSeguro", "montoSolicitado", "motivoStatus",
					"numeroCuentasBc", "numeroIntegrante", "otrosIngresos",
					"pctParticipacion", "solicitud", "status", "tablaScore",
					"tipoDisposicion", "seguro" };

			if (solicitudesOV.getSolicitud() == null) {
				// Insert
				mensaje = "SE HA INSERTADO LA SOLICITUD";

				LogHandler.trace(uid, getClass(),
						"registrarSolicitudTarea: - obtenerFolioSolicitud");
				LogHandler.info(uid, getClass(),
						"registrarSolicitudTarea: - obtenerFolioSolicitud");
				final java.lang.String solicitudFolio = (java.lang.String) sesionNTx
						.selectOne("obtenerFolioSolicitud");
				String[] solicitudesDatosRequeridos = { "cat", "categoria",
						"ciclo", "claveCorresponsal", "claveEmpresa",
						"cliente", "codigoProducto", "comisionApertura",
						"contrato", "contratoAnt", "contratoRecomienda",
						"creditoGrupal", "diaPago", "diaReunion",
						"efectivoOtorgado", "efectivoSolicitado", "getEtapa",
						"etapaAnterior", "fechaCaptura", "fechaResolucion",
						"fechaUltMod", "frecuenciaPago", "grupoVentas",
						"gteSucursal", "gteVentas", "horaCaptura",
						"horaResolucion", "horaReunion", "horaUltMod",
						"montoFinanciadoContAnt", "montoOtorgado", "montoPago",
						"montoSolicitado", "motivoStatus",
						"numeroFamiliaresGrupo", "numeroIntegrantes",
						"oficina", "oficinaDisposicion", "origenVenta",
						"plazo", "plazoSolicitado", "segmento", "solicitud",
						"status", "tasa", "tipoVerificacion", "vendedor",
						"vendedorOrig", "seguro" };

				solicitudesOV.setSolicitud(solicitudFolio);

				validaStr = Validaciones.datosRequeridos(solicitudesOV,
						solicitudesDatosRequeridos);
				if (!validaStr.equalsIgnoreCase("")) {
					throw new Exception(DATOS_REQUERIDOS + validaStr);
				}

				LogHandler.info(uid, getClass(),
						"registrarSolicitudTarea: - solicitudFolio: "
								+ solicitudFolio);
				solicitudParametros = new java.util.HashMap<String, Object>();
				solicitudParametros = Funciones
						.objectToHashMapInsert(solicitudesOV);
				LogHandler.trace(uid, getClass(),
						"registrarSolicitudTarea: - insertaSolicitud");
				LogHandler.info(uid, getClass(),
						"registrarSolicitudTarea: - insertaSolicitud");
				sesionTx.insert("insertaSolicitud", solicitudParametros);

				// inserta integrantes

				if (solicitudIntegrantesOVList != null) {
					for (int i = 0; i < solicitudIntegrantesOVList.size(); i++) {
						java.util.HashMap<String, Object> integranteParametros = null;
						SolicitudIntegrantesOV solicitudIntegrantesOV = new SolicitudIntegrantesOV();
						solicitudIntegrantesOV = solicitudIntegrantesOVList
								.get(i);
						solicitudIntegrantesOV.setSolicitud(solicitudFolio);

						final Integer integranteNumeroQuery = (Integer) sesionTx
								.selectOne("obtenerNumeroIntegrante",
										solicitudFolio);
						if (integranteNumeroQuery == null) {
							throw new Exception(
									"NO SE PUDO OBTENER NUMERO DE INTEGRANTE");
						}
						solicitudIntegrantesOV
								.setNumeroIntegrante(integranteNumeroQuery);

						validaStr = Validaciones.datosRequeridos(
								solicitudIntegrantesOV,
								integranteDatosRequeridos);
						if (!validaStr.equalsIgnoreCase("")) {
							throw new Exception(DATOS_REQUERIDOS + validaStr);
						}

						integranteParametros = Funciones
								.objectToHashMapInsert(solicitudIntegrantesOV);
						LogHandler.trace(uid, getClass(),
								"registrarSolicitudTarea: - insertaSolicitudIntegrante.cliente: "
										+ solicitudIntegrantesOV.getCliente());
						LogHandler.info(uid, getClass(),
								"registrarSolicitudTarea: - insertaSolicitudIntegrante.cliente: "
										+ solicitudIntegrantesOV.getCliente());
						sesionTx.insert("insertaSolicitudIntegrante",
								integranteParametros);
					}
				}

			} else {
				// Update
				mensaje = "SE HA ACTUALIZADO LA SOLICITUD";
				solicitudParametros = Funciones
						.objectToHashMapUpdate(solicitudesOV);
				LogHandler.info(uid, getClass(),
						"registrarSolicitudTarea: - solicitudParametros: +"
								+ solicitudParametros + "+");
				final String solicitudFolio = solicitudesOV.getSolicitud();

				String solicitudQuery = (String) sesionNTx.selectOne(
						"buscaSolicitud", solicitudFolio);
				if (solicitudQuery == null) {
					solicitudQuery = "";
				} else {
					solicitudQuery = solicitudQuery.trim();
				}

				if (!(solicitudQuery.equalsIgnoreCase(solicitudFolio))) { // Update
																			// Integrante
					LogHandler.info(uid, getClass(),
							"registrarSolicitudTarea: - solicitudQuery: +"
									+ solicitudQuery + "+");
					LogHandler.info(uid, getClass(),
							"registrarSolicitudTarea: - solicitudFolio: +"
									+ solicitudFolio + "+");
					LogHandler.info(uid, getClass(),
							"registrarSolicitudTarea: - buscaSolicitud: Solicitud ="
									+ solicitudFolio + "= no encontrada");
					throw new Exception("SOLICITUD NO EXISTE");
				}

				LogHandler.trace(uid, getClass(),
						"registrarSolicitudTarea: - actualizaSolicitud");
				LogHandler.info(uid, getClass(),
						"registrarSolicitudTarea: - actualizaSolicitud");
				int registrosAfectados = sesionTx.update("actualizaSolicitud",
						solicitudParametros);
				LogHandler.info(uid, getClass(),
						"registrarSolicitudTarea: - registrosAfectados: "
								+ registrosAfectados);
				if (registrosAfectados == 0) {
					throw new Exception(ERROR_ACTUALIZACION);
				}

				if (solicitudIntegrantesOVList != null) {
					for (int i = 0; i < solicitudIntegrantesOVList.size(); i++) {
						java.util.HashMap<String, Object> integranteParametros = null;
						SolicitudIntegrantesOV solicitudIntegrantesOV = new SolicitudIntegrantesOV();
						solicitudIntegrantesOV = solicitudIntegrantesOVList
								.get(i);
						solicitudIntegrantesOV.setSolicitud(solicitudFolio);

						if (solicitudIntegrantesOV.getCliente() == null) {
							throw new Exception(DATOS_INCORRECTOS);
						}
						java.util.HashMap<String, Object> integranteBuscaParametros = new java.util.HashMap<String, Object>();
						integranteBuscaParametros.put("solicitud",
								solicitudesOV.getSolicitud());
						integranteBuscaParametros.put("cliente",
								solicitudIntegrantesOV.getCliente());
						LogHandler.info(uid, getClass(),
								"registrarSolicitudTarea:- integranteBuscaParametros: "
										+ integranteBuscaParametros);
						LogHandler
								.trace(uid, getClass(),
										"registrarSolicitudTarea:- buscaIntegranteSolicitud:");
						LogHandler
								.info(uid, getClass(),
										"registrarSolicitudTarea:- buscaIntegranteSolicitud:");
						String clienteQuery = (String) sesionTx.selectOne(
								"buscaIntegranteSolicitud",
								integranteBuscaParametros);
						if (clienteQuery == null) {
							clienteQuery = "";
						} else {
							clienteQuery = clienteQuery.trim();
						}

						LogHandler.info(uid, getClass(),
								"registrarSolicitudTarea: \n\n- clienteQuery: "
										+ clienteQuery + "\n\n");
						LogHandler.info(uid, getClass(),
								"registrarSolicitudTarea: \n\n- OV.getCliente(): "
										+ solicitudIntegrantesOV.getCliente()
										+ "\n\n");

						if (clienteQuery
								.equalsIgnoreCase(solicitudIntegrantesOV
										.getCliente())) { // Update Integrante
							integranteParametros = Funciones
									.objectToHashMapUpdate(solicitudIntegrantesOV);
							LogHandler.trace(
									uid,
									getClass(),
									"registrarSolicitudTarea: - actualizaSolicitudIntegrante.cliente: "
											+ solicitudIntegrantesOV
													.getCliente());
							LogHandler.info(
									uid,
									getClass(),
									"registrarSolicitudTarea: - actualizaSolicitudIntegrante.cliente: "
											+ solicitudIntegrantesOV
													.getCliente());
							int registrosAfectadosI = sesionTx.update(
									"actualizaSolicitudIntegrante",
									integranteParametros);
							LogHandler.info(uid, getClass(),
									"registrarSolicitudTarea: - registrosAfectadosI: "
											+ registrosAfectadosI);
							if (registrosAfectadosI == 0) {
								throw new Exception(ERROR_ACTUALIZACION);
							}

						} else { // Insert Integrante

							LogHandler
									.trace(uid, getClass(),
											"registrarSolicitudTarea: obtenerNumeroIntegrante");
							LogHandler
									.info(uid, getClass(),
											"registrarSolicitudTarea: obtenerNumeroIntegrante");
							final Integer integranteNumeroQuery = (Integer) sesionTx
									.selectOne("obtenerNumeroIntegrante",
											solicitudFolio);

							if (integranteNumeroQuery == null) {
								throw new Exception(
										"NO SE PUDO OBTENER NUMERO DE INTEGRANTE");
							}
							solicitudIntegrantesOV
									.setNumeroIntegrante(integranteNumeroQuery);
							LogHandler.info(uid, getClass(),
									"registrarSolicitudTarea: \n\n- integranteNumeroQuery: "
											+ integranteNumeroQuery + "\n\n");

							validaStr = Validaciones.datosRequeridos(
									solicitudIntegrantesOV,
									integranteDatosRequeridos);
							if (!validaStr.equalsIgnoreCase("")) {
								throw new Exception(DATOS_REQUERIDOS
										+ validaStr);
							}
							integranteParametros = Funciones
									.objectToHashMapInsert(solicitudIntegrantesOV);
							LogHandler
									.trace(uid, getClass(),
											"registrarSolicitudTarea: insertaSolicitudIntegrante");
							LogHandler
									.info(uid, getClass(),
											"registrarSolicitudTarea: insertaSolicitudIntegrante");
							sesionTx.insert("insertaSolicitudIntegrante",
									integranteParametros);

						}
					}
				}
			}

			LogHandler.info(uid, getClass(),
					"registrarSolicitudTarea: - insertaSolicitudes");
			LogHandler.trace(uid, getClass(),
					"registrarSolicitudTarea: - insertaSolicitudes");
			sesionTx.commit(true);
			solicitudesRespuesta.getHeader().setMensaje(mensaje);
		} catch (Exception ex) {
			FabricaConexiones.rollBack(sesionTx);
			LogHandler.error(uid, getClass(),
					"registrarSolicitudTarea: " + ex.getMessage(), ex);
			solicitudesRespuesta.getHeader().setEstatus(false);
			solicitudesRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			solicitudesRespuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionTx);
			FabricaConexiones.close(sesionNTx);
		}

		return solicitudesRespuesta;
	}

	/**
	 * @param uid
	 *            identificador unico
	 * @param sesion
	 *            externa
	 * @param solicitudesPeticion
	 *            peticion
	 * @return respuesta de la cancelacion de la solicitud
	 */
	public SolicitudesRespuesta cancelarSolicitudTarea(String uid,
			SqlSession sesion, SolicitudesPeticion solicitudesPeticion) {
		SolicitudesRespuesta solicitudesRespuesta = new SolicitudesRespuesta();
		solicitudesRespuesta.setHeader(new EncabezadoRespuesta());
		solicitudesRespuesta.getHeader().setUID(uid);
		solicitudesRespuesta.getHeader().setEstatus(true);
		SqlSession sesionTx = null;
		// SqlSession sesionNTx = null;
		boolean sesionExterna = false;
		// SqlSession sesionOracleTx = null;
		String validaStr = "";
		try {
			// Se abre la conexion hacia la base de datos
			if (sesion == null) {
				sesionTx = FabricaConexiones.obtenerSesionTx();
			} else {
				sesionTx = sesion;
				sesionExterna = true;
			}

			java.util.HashMap<String, Object> solicitudLogParametros = null;
			String[] solicitudDatosRequeridos = { "solicitudId", "usuarioId",
					"motivo" };
			java.util.HashMap<String, Object> solicitudParametros = new java.util.HashMap<String, Object>();
			validaStr = Validaciones.datosRequeridos(solicitudesPeticion,
					solicitudDatosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			// Validamos que exista solicitud
			// sesionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(),
					"cancelarSolicitudTarea: - existeSolicitud");
			LogHandler.info(uid, getClass(),
					"cancelarSolicitudTarea: - existeSolicitud");
			Integer numeroSolicutudes = (Integer) sesionTx.selectOne(
					"existeSolicitud", solicitudesPeticion.getSolicitudId());
			if (numeroSolicutudes == 0) {

				if (solicitudesPeticion.getSolicitud() == null) {
					solicitudesPeticion.setSolicitud(new SolicitudesOV());
				}

				solicitudesPeticion.getSolicitud().setSolicitud(
						solicitudesPeticion.getSolicitudId());

				SolicitudesRespuesta respuestaRegistrar = registrarSolicitudMinimaTarea(
						uid, sesionTx, solicitudesPeticion.getSolicitud());

				if (!respuestaRegistrar.getHeader().isEstatus()) {
					throw new Exception(respuestaRegistrar.getHeader()
							.getMensaje());
				}

				// Registrar Solicitud Minima
				AtomosOV peticionAtomo = new AtomosOV();
				peticionAtomo
						.setSolicitud(solicitudesPeticion.getSolicitudId());
				peticionAtomo.setProceso("ORIGEN");
				peticionAtomo
						.setComentario("SE GENERA SOLICITUD MINIMA POR CONSISTENCIA.");
				peticionAtomo.setStatus("A");
				peticionAtomo.setUsuarioGeneroAtomo(solicitudesPeticion
						.getUsuarioId());

				AtomosRespuesta atomosRespuesta = registrarAtomosTarea(uid,
						sesionTx, peticionAtomo);

				if (!atomosRespuesta.getHeader().isEstatus()) {
					throw new Exception(atomosRespuesta.getHeader()
							.getMensaje());
				}
			}

			solicitudLogParametros = Funciones
					.objectToHashMapUpdate(solicitudesPeticion);
			solicitudLogParametros.put("descripcion", "CANCELACION");
			LogHandler.trace(uid, getClass(),
					"cancelarSolicitudTarea: - insertaSolicitudLog");
			LogHandler.info(uid, getClass(),
					"cancelarSolicitudTarea: - insertaSolicitudLog");
			sesionTx.insert("insertaSolicitudLog", solicitudLogParametros);

			solicitudParametros.put("solicitud",
					solicitudesPeticion.getSolicitudId());
			solicitudParametros.put("motivoStatus", "CANCELACION");
			solicitudParametros.put("status", "X");
			solicitudParametros.put("fechaUltMod", new java.util.Date());
			solicitudParametros.put("horaUltMod", new java.util.Date());
			// 2014-05-06
			solicitudParametros.put("estatus", "CANCELADA");
			solicitudParametros
					.put("descripcion",
							solicitudesPeticion.getMotivo() != null ? solicitudesPeticion
									.getMotivo() : "");
			// motivo cancelacion
			solicitudParametros
					.put("motivoCancelacion",
							solicitudesPeticion.getMotivoCancelacion() != null ? solicitudesPeticion
									.getMotivoCancelacion() : "");

			LogHandler.trace(uid, getClass(),
					"cancelarSolicitudTarea: - actualizaSolicitud");
			LogHandler.info(uid, getClass(),
					"cancelarSolicitudTarea: - actualizaSolicitud");
			int registrosAfectados = sesionTx.update("actualizaSolicitud",
					solicitudParametros);
			LogHandler.info(uid, getClass(),
					"cancelarSolicitudTarea: - registrosAfectados: "
							+ registrosAfectados);
			if (registrosAfectados == 0) {
				throw new Exception(ERROR_ACTUALIZACION);
			}

			// Registrar Solicitud Minima
			AtomosOV peticionAtomo = new AtomosOV();
			peticionAtomo.setSolicitud(solicitudesPeticion.getSolicitudId());
			peticionAtomo.setProceso("CANCELADA");
			peticionAtomo.setComentario("");
			peticionAtomo.setStatus("A");
			peticionAtomo
					.setCodigoResolucion(solicitudesPeticion.getMotivo() != null ? solicitudesPeticion
							.getMotivo() : "");
			peticionAtomo.setUsuarioGeneroAtomo(solicitudesPeticion
					.getUsuarioId());

			AtomosRespuesta atomosRespuesta = registrarAtomosTarea(uid,
					sesionTx, peticionAtomo);

			if (!atomosRespuesta.getHeader().isEstatus()) {
				throw new Exception(atomosRespuesta.getHeader().getMensaje());
			}

			// Verifica si tiene tareas pendientes en el buzon de tareas
			LogHandler.trace(uid, getClass(),
					"cancelarSolicitudTarea: - eliminarTareasBuzonSolicitud");
			LogHandler.info(uid, getClass(),
					"cancelarSolicitudTarea: - eliminarTareasBuzonSolicitud");
			sesionTx.update("eliminarTareasBuzonSolicitud", solicitudParametros);

			if (!sesionExterna) {
				sesionTx.commit(true);
			}

			solicitudesRespuesta.getHeader().setMensaje("SOLICITUD CANCELADA");

		} catch (Exception ex) {
			if (!sesionExterna) {
				FabricaConexiones.rollBack(sesionTx);
			}
			LogHandler.error(uid, getClass(),
					"cancelarSolicitudTarea: " + ex.getMessage(), ex);
			solicitudesRespuesta.getHeader().setEstatus(false);
			solicitudesRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			solicitudesRespuesta.getHeader().setCodigo(
					"cancelarSolicitudTarea: " + ex.getMessage());
		} finally {
			// FabricaConexiones.close(sesionNTx);
			if (!sesionExterna) {
				FabricaConexiones.close(sesionTx);
			}
		}

		return solicitudesRespuesta;
	}

	/**
	 * @param uid
	 *            identificador unico
	 * @param solicitudesPeticion
	 *            peticion
	 * @return respuesta de la consulta de la solicitud
	 */
	@SuppressWarnings("unchecked")
	public SolicitudesRespuesta consultarSolicitudTarea(String uid,
			SolicitudesPeticion solicitudesPeticion) {
		SolicitudesRespuesta solicitudesRespuesta = new SolicitudesRespuesta();
		solicitudesRespuesta.setHeader(new EncabezadoRespuesta());
		solicitudesRespuesta.getHeader().setUID(uid);
		solicitudesRespuesta.getHeader().setEstatus(true);

		SqlSession sesionNTx = null;
		SolicitudesOV solicitudesOV = null;
		List<SolicitudIntegrantesOV> solicitudIntegrantesOVList = null;
		String validaStr = "";
		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			String[] solicitudDatosRequeridos = { "solicitudId" };

			validaStr = Validaciones.datosRequeridos(solicitudesPeticion,
					solicitudDatosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			LogHandler.trace(uid, getClass(),
					"consultarSolicitudTarea: - consultaSolicitud");
			LogHandler.info(uid, getClass(),
					"consultarSolicitudTarea: - consultaSolicitud");
			solicitudesOV = (SolicitudesOV) sesionNTx.selectOne(
					"consultaSolicitud", solicitudesPeticion.getSolicitudId());

			if (solicitudesOV == null) {
				throw new Exception(SOLICITUD_NO_ENCONTRADA);
			}

			LogHandler.trace(uid, getClass(),
					"consultarSolicitudTarea: - consultaIntegrantes");
			LogHandler.info(uid, getClass(),
					"consultarSolicitudTarea: - consultaIntegrantes");
			solicitudIntegrantesOVList = sesionNTx.selectList(
					"consultaIntegrantes", solicitudesOV.getSolicitud());

			solicitudesRespuesta.setSolicitud(solicitudesOV);
			solicitudesRespuesta.setIntegrantes(solicitudIntegrantesOVList);

		} catch (Exception ex) {
			LogHandler.error(uid, getClass(),
					"consultarSolicitudTarea: " + ex.getMessage(), ex);
			solicitudesRespuesta.getHeader().setEstatus(false);
			solicitudesRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			solicitudesRespuesta.getHeader().setCodigo(
					"consultarSolicitudTarea: " + ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}

		return solicitudesRespuesta;

	}

	/**
	 * Metodo para registrar en la tabla de atomos
	 * 
	 * @param uid
	 *            String
	 * @param sesion
	 *            SqlSession
	 * @param peticion
	 *            AtomosOV
	 * @return respuesta tipo AtomosRespuesta
	 */
	public AtomosRespuesta registrarAtomosTarea(String uid, SqlSession sesion,
			AtomosOV peticion) {
		AtomosRespuesta respuesta = new AtomosRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionTx = null;
		boolean sesionExterna = false;
		try {
			// Se abre la conexion hacia la base de datos
			if (sesion == null) {
				sesionTx = FabricaConexiones.obtenerSesionTx();
			} else {
				sesionTx = sesion;
				sesionExterna = true;
			}

			// Calendar myDate = Calendar.getInstance();

			if (peticion == null) {
				throw new Exception("La peticion esta vacia o es nula");
			}

			// parametros de consulta
			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			// parametros.put( "id_atomo" , peticion.getId_atomo() != null ?
			// peticion.getId_atomo() : 0.0);
			parametros.put("proceso",
					peticion.getProceso() != null ? peticion.getProceso() : "");
			parametros.put("id_proceso",
					peticion.getIdProceso() != null ? peticion.getIdProceso()
							: 0.0);
			parametros.put("id_tarea",
					peticion.getIdTarea() != null ? peticion.getIdTarea() : 0);
			parametros.put("solicitud",
					peticion.getSolicitud() != null ? peticion.getSolicitud()
							: "");
			parametros.put("cliente",
					peticion.getCliente() != null ? peticion.getCliente() : "");
			parametros.put(
					"usuario_genero_atomo",
					peticion.getUsuarioGeneroAtomo() != null ? peticion
							.getUsuarioGeneroAtomo() : "");
			parametros.put("status",
					peticion.getStatus() != null ? peticion.getStatus() : "A");
			parametros.put("tipo_atomo",
					peticion.getTipoAtomo() != null ? peticion.getTipoAtomo()
							: "");
			parametros.put("es_critico",
					peticion.getEsCritico() != null ? peticion.getEsCritico()
							: "");
			parametros.put("etapa",
					peticion.getEtapa() != null ? peticion.getEtapa() : "");
			@SuppressWarnings("deprecation")
			Date miFecha = new Date("01/01/1900");
			// parametros.put( "hora_registro" , peticion.getHoraRegistro() !=
			// null ? peticion.getHoraRegistro() : myDate.getTime());
			parametros.put(
					"hora_resolucion",
					peticion.getHoraResolucion() != null ? peticion
							.getHoraResolucion() : miFecha);
			parametros.put(
					"codigo_resolucion",
					peticion.getCodigoResolucion() != null ? peticion
							.getCodigoResolucion() : "");
			parametros.put("resolucion",
					peticion.getResolucion() != null ? peticion.getResolucion()
							: "");
			parametros.put("comentario",
					peticion.getComentario() != null ? peticion.getComentario()
							: "");
			parametros.put(
					"id_atomo_anterior",
					peticion.getIdAtomoAnterior() != null ? peticion
							.getIdAtomoAnterior() : 0.0);
			parametros.put(
					"genero_atomo_siguiente",
					peticion.getGeneroAtomoSiguiente() != null ? peticion
							.getGeneroAtomoSiguiente() : "");
			parametros.put(
					"origen_error",
					peticion.getOrigenError() != null ? peticion
							.getOrigenError() : "");
			parametros.put(
					"numero_integrante",
					peticion.getNumeroIntegrante() != null ? peticion
							.getNumeroIntegrante() : 0);

			// Validar ENVIO_CEC
			LogHandler.trace(uid, getClass(),
					"==> registrarAtomosTarea - verificaAtomo");
			if (parametros.get("proceso").toString().equals("ENVIO_CEC")) {
				Integer existeAtomo = (Integer) sesionTx.selectOne(
						"verificaExisteAtomo", parametros);
				if (existeAtomo == null) {
					existeAtomo = 0;
				}
				if (existeAtomo > 0) {
					// Existe el atomo
					respuesta.getHeader().setMensaje(
							"No se inserto el atomo, ya existia [ENVIO_CEC].");
					return respuesta;
				}
			}

			// Validamos si el registro del atomo es el mismo que el anterior
			LogHandler.trace(uid, getClass(),
					"==> registrarAtomosTarea - verificaUltimoAtomo");
			AtomosOV ultimoAtomo = (AtomosOV) sesionTx.selectOne(
					"verificaUltimoAtomo", parametros);

			if (ultimoAtomo != null) {
				if (ultimoAtomo.getProceso().trim()
						.equals(parametros.get("proceso").toString().trim())
						&& ultimoAtomo
								.getUsuarioGeneroAtomo()
								.trim()
								.equals(parametros.get("usuario_genero_atomo")
										.toString().trim())) {
					respuesta.getHeader().setMensaje(
							"No se inserto el atomo, ya existia.");
					return respuesta;
				}
			}
			LogHandler.trace(uid, getClass(),
					"==> registrarAtomosTarea - insertaAtomos");
			sesionTx.insert("insertaAtomos", parametros);

			if (parametros.get("idAtomo") == null) {
				parametros.put("idAtomo", 0);
			}
			respuesta.setIdAtomo(Integer.valueOf(parametros.get("idAtomo")
					.toString()));

			boolean actualizarEstatus = true;
			if (peticion.getProceso() != null
					&& peticion.getProceso().equals(
							Constantes.ATOMO_FIRMA_ELECTRONICA)) {
				actualizarEstatus = false;
			}

			if (actualizarEstatus) {
				// Actualizar estatus de la solicitud
				final java.util.HashMap<String, Object> parametrosSolicitud = new HashMap<String, Object>();
				LogHandler.trace(uid, getClass(),
						"==> registrarAtomosTarea - actualizaCreditoTempMO");
				parametrosSolicitud.put(
						"id",
						peticion.getSolicitud() != null ? peticion
								.getSolicitud() : "");
				parametrosSolicitud.put("estatus",
						peticion.getProceso() != null ? peticion.getProceso()
								: "");
				parametrosSolicitud.put(
						"desEstatus",
						peticion.getCodigoResolucion() != null ? peticion
								.getCodigoResolucion() : "");
				// Actualiza la fecha del campo fecha_reg_exp_cm cuando se crea
				// el atomo por primera vez de solicitudes_finsol
				parametrosSolicitud.put("actualizaFecha", "NO");
				sesionTx.update("actualizaCreditoTempMO", parametrosSolicitud);
			}
			// RIMM:esta parte se agrega para la actualizacion de la
			// fecha_aprobacion_cec
			if (parametros.get("proceso").toString().equals("EVALUACION_CEC")
					&& parametros.get("codigo_resolucion").toString()
							.equals("EVCR_OK")) {
				LogHandler
						.trace(uid, getClass(),
								"==> registrarAtomosTarea - actualizaFechaAprobacion del cec ");
				sesionTx.update("actualizaFechaAprobacion",
						parametros.get("solicitud").toString());
			}

			// mandando llamar servicio Robert para guardar la solicitud
			if (peticion.getProceso() != null
					&& peticion.getProceso().equals("ASIGNACION_CEC")
					&& (peticion.getCodigoResolucion() == null
							|| peticion.getCodigoResolucion().equals("") || peticion
							.getCodigoResolucion().isEmpty())) {

				SolicitudPlanillaAprobacionPeticion peticionSolPlan = new SolicitudPlanillaAprobacionPeticion();

				peticionSolPlan.setSolicitud(peticion.getSolicitud());
				peticionSolPlan.setIdAtomo(respuesta.getIdAtomo());

				SolicitudPlanillaAprobacionRespuesta respuestaPlanilla = guardarSolicitudPlanillaAprobacion(
						uid, peticionSolPlan, sesionTx);

				if (respuestaPlanilla.getHeader().isEstatus()) {
					LogHandler.info(
							uid,
							getClass(),
							"==> solicitud guardada : "
									+ peticion.getSolicitud());
				} else {
					LogHandler.info(
							uid,
							getClass(),
							"==> no se pudo guardar la solicitud : "
									+ peticion.getSolicitud()
									+ " Error: "
									+ respuestaPlanilla.getHeader()
											.getMensaje());
					throw new Exception(respuestaPlanilla.getHeader()
							.getMensaje());
				}

			} else {
				LogHandler.info(uid, getClass(),
						"==> no se pudo guardar la solicitud");
			}

			// proceso que se agrega para el documental
			if (peticion.getProceso() != null
					&& !peticion.getProceso().isEmpty()
					&& peticion.getProceso().equals("ASIGNACION_DOC")) {
				sesionTx.update("actualizarFechAsignacionDocumental",
						peticion.getSolicitud());
				LogHandler
						.info(uid, getClass(),
								"Se actualizo correctamente el campo fecha_asigna_documental..");
			}

			if (!sesionExterna) {
				sesionTx.commit(true);
			}
			respuesta.getHeader().setMensaje(
					"Se ha insertado con exito un atomo");

		} catch (Exception ex) {
			if (!sesionExterna) {
				FabricaConexiones.rollBack(sesionTx);
			}
			LogHandler.error(uid, getClass(),
					"registrarAtomosTarea(): " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		} finally {
			if (!sesionExterna) {
				FabricaConexiones.close(sesionTx);
			}
		}

		return respuesta;

	}

	@SuppressWarnings("unchecked")
	public SolicitudBuroRespuesta registrarSolicitudBuroTarea(String uid,
			SolicitudBuroOV peticion) {
		SolicitudBuroRespuesta respuesta = new SolicitudBuroRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesion = null;
		SqlSession sesionTx = null;
		try {
			// Se abre la conexion hacia la base de datos
			sesion = FabricaConexiones.obtenerSesionNTx();
			sesionTx = FabricaConexiones.obtenerSesionTx();

			if (peticion == null || peticion.getSolicitud() == null
					|| peticion.getSolicitud().equals("")) {
				throw new java.lang.Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.registrar.peticion.datos.incorrectos"));
			}

			if (peticion.getIntegrantes().size() == 0) {
				throw new java.lang.Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.registrar.peticion.datos.integrantes"));
			}

			// update por solicitud -> status = 'X'
			// En esta seccion me traigo a la persona en cualquier forma
			LogHandler.trace(uid, getClass(),
					"==> registrarSolicitudBuroTarea - existeSolicitudInicial");

			List<SolicitudBuroOV> existeSolicitudBuro = (List<SolicitudBuroOV>) sesion
					.selectList("existeSolicitudInicial",
							peticion.getSolicitud());
			if (existeSolicitudBuro.size() > 0) {

				final java.util.HashMap<String, Object> parametrosUpdateInicio = new HashMap<String, Object>();
				parametrosUpdateInicio
						.put("solicitud", peticion.getSolicitud());
				parametrosUpdateInicio.put("status", "X");

				LogHandler
						.trace(uid, getClass(),
								"==> registrarSolicitudBuroTarea - actualizarSolicitudBuro");
				sesionTx.update("actualizarSolicitudBuro",
						parametrosUpdateInicio);
				respuesta
						.getHeader()
						.setMensaje(
								"Se ha modificado con exito la solicitud buro en inicio...");
			}

			for (SolicitudBuroClienteOV integrante : peticion.getIntegrantes()) {

				if (integrante.getPersona() == null
						|| integrante.getPersona().trim().equals("")) {
					throw new java.lang.Exception(
							ReadProperties.mensajes
									.getProp("solicitudes.registrar.peticion.datos.incorrectos"));
				}

				// En esta seccion me traigo a la persona en cualquier forma
				LogHandler
						.trace(uid, getClass(),
								"==> registrarSolicitudBuroTarea - obtenerPersonaSolicitud");

				String personaSolicitud = (String) sesion.selectOne(
						"obtenerPersonaSolicitud", integrante.getPersona());
				if (personaSolicitud == null) {
					throw new Exception(
							ReadProperties.mensajes
									.getProp("solicitudes.registrar.solicitud.buro.persona.inexistente")
									+ " " + integrante.getPersona());
				}

				// parametros de consulta
				final java.util.HashMap<String, Object> parametrosValida = new HashMap<String, Object>();
				parametrosValida
						.put("solicitud",
								peticion == null
										|| peticion.getSolicitud() == null
										|| peticion.getSolicitud().trim()
												.isEmpty() ? null : peticion
										.getSolicitud());

				parametrosValida.put("persona", personaSolicitud);
				// Se obtiene la consulta a solicitud_buro
				LogHandler.trace(uid, getClass(),
						"==> consultaSolicitudBuroTarea - existeSolicitudBuro");
				List<SolicitudBuroOV> solicitudes = (List<SolicitudBuroOV>) sesionTx
						.selectList("existeSolicitudBuro", parametrosValida);

				if (solicitudes.isEmpty()) {
					// parametros de consulta
					final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
					parametros.put("solicitud",
							peticion.getSolicitud() != null ? peticion
									.getSolicitud().trim() : "");
					parametros.put("persona",
							personaSolicitud != null ? personaSolicitud : "");
					parametros.put("cuentas_mop01", 0);
					parametros.put("cuentas_mop02", 0);
					parametros.put("cuentas_mop03", 0);
					parametros.put("cuentas_mop04", 0);
					parametros.put("cuentas_mop05", 0);
					parametros.put("cuentas_mop06", 0);
					parametros.put("cuentas_mop07", 0);
					parametros.put("cuentas_mop96", 0);
					parametros.put("cuentas_mop97", 0);
					parametros.put("cuentas_mop99", 0);
					parametros.put("cuentas_mopur", 0);
					parametros
							.put("folio_consulta_buro",
									integrante.getFolioConsultaBuro() != null ? integrante
											.getFolioConsultaBuro() : "");
					parametros.put("status", "A");
					parametros.put("hipotecario", "");
					parametros.put("hipotecario_mop", "");
					parametros.put("hipotecario_desc", "");
					parametros.put("automotriz", "");
					parametros.put("automotriz_mop", "");
					parametros.put("automotriz_desc", "");
					parametros.put("descarte", "");
					parametros.put("desc_descarte", "");
					parametros.put("mop99_saldo_vencido", 0.0);

					LogHandler
							.trace(uid, getClass(),
									"==> registrarSolicitudBuroTarea - insertaSolicitudBuro");
					sesionTx.insert("insertaSolicitudBuro", parametros);
					respuesta.getHeader().setMensaje(
							"Se ha insertado con exito una solicitud buro");

				} else {
					// parametros de consulta
					final java.util.HashMap<String, Object> parametrosUpdate = new HashMap<String, Object>();
					parametrosUpdate.put("solicitud", peticion.getSolicitud());
					parametrosUpdate.put("persona",
							personaSolicitud != null ? personaSolicitud : "");
					parametrosUpdate.put("cuentas_mop01", 0);
					parametrosUpdate.put("cuentas_mop02", 0);
					parametrosUpdate.put("cuentas_mop03", 0);
					parametrosUpdate.put("cuentas_mop04", 0);
					parametrosUpdate.put("cuentas_mop05", 0);
					parametrosUpdate.put("cuentas_mop06", 0);
					parametrosUpdate.put("cuentas_mop07", 0);
					parametrosUpdate.put("cuentas_mop96", 0);
					parametrosUpdate.put("cuentas_mop97", 0);
					parametrosUpdate.put("cuentas_mop99", 0);
					parametrosUpdate.put("cuentas_mopur", 0);
					parametrosUpdate.put("folio_consulta_buro",
							integrante.getFolioConsultaBuro());
					parametrosUpdate.put("status", "A");
					parametrosUpdate.put("hipotecario", "");
					parametrosUpdate.put("hipotecario_mop", "");
					parametrosUpdate.put("hipotecario_desc", "");
					parametrosUpdate.put("automotriz", "");
					parametrosUpdate.put("automotriz_mop", "");
					parametrosUpdate.put("automotriz_desc", "");
					parametrosUpdate.put("descarte", "");
					parametrosUpdate.put("desc_descarte", "");
					parametrosUpdate.put("mop99_saldo_vencido", 0);

					LogHandler
							.trace(uid, getClass(),
									"==> registrarSolicitudBuroTarea - actualizarSolicitudBuro");
					sesionTx.update("actualizarSolicitudBuro", parametrosUpdate);
					respuesta.getHeader().setMensaje(
							"Se ha modificado con exito la solicitud buro");
				}
			}
			sesionTx.commit(true);
		} catch (Exception exception) {
			LogHandler.info(uid, getClass(), "rollBack!!!");
			FabricaConexiones.rollBack(sesionTx);
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(exception.getMessage());
			respuesta.getHeader().setEstatus(false);
			LogHandler.error(
					uid,
					this.getClass(),
					"Error en registrarSolicitudBuroTarea : "
							+ exception.getMessage(), exception);
		} finally {
			FabricaConexiones.close(sesion);
			FabricaConexiones.close(sesionTx);
		}
		return respuesta;
	}

	@SuppressWarnings("unchecked")
	public ConsultaSolicitudBuroRespuesta consultaSolicitudBuroTarea(
			String uid, SolicitudBuroOV peticion) {
		ConsultaSolicitudBuroRespuesta respuesta = new ConsultaSolicitudBuroRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);

		SqlSession sesion = null;
		try {
			sesion = FabricaConexiones.obtenerSesionNTx();

			// parametros de consulta
			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("solicitud",
					peticion == null || peticion.getSolicitud() == null
							|| peticion.getSolicitud().trim().isEmpty() ? null
							: peticion.getSolicitud());
			parametros.put("status", "A");
			SolicitudBuroOV solicitud = new SolicitudBuroOV();
			List<SolicitudBuroClienteOV> solicitudes = new ArrayList<SolicitudBuroClienteOV>();

			// Se obtiene la consulta a solicitud_buro
			LogHandler.trace(uid, getClass(),
					"==> consultaSolicitudBuroTarea - obtenerSolicitudBuro");
			solicitudes = (List<SolicitudBuroClienteOV>) sesion.selectList(
					"obtenerSolicitudBuro", parametros);

			if (solicitudes.size() == 0) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.consulta.solicitud.buro.inexistente"));
			}
			respuesta.getHeader().setMensaje(
					"La consulta se ha realizado con exito.");
			solicitud.setIntegrantes(solicitudes);
			respuesta.setSolicitudesBuro(solicitud);

		} catch (Exception exception) {
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(exception.getMessage());
			respuesta.getHeader().setEstatus(false);
			LogHandler.error(
					uid,
					this.getClass(),
					"Error en consultaSolicitudBuroTarea : "
							+ exception.getMessage(), exception);
		} finally {
			FabricaConexiones.close(sesion);
		}

		return respuesta;
	}

	public SolicitudesRespuesta registrarSolicitudMinimaTarea(String uid,
			SqlSession sesion, SolicitudesOV peticion) {
		SolicitudesRespuesta respuesta = new SolicitudesRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionTx = null;
		SqlSession sesionNTx = null;
		boolean sesionExterna = false;

		try {
			// Se abre la conexion hacia la base de datos
			if (sesion == null) {
				sesionTx = FabricaConexiones.obtenerSesionTx();
			} else {
				sesionTx = sesion;
				sesionExterna = true;
			}

			if (peticion.getSolicitud() == null) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.registrar.peticion.datos.incorrectos"));
			}

			Calendar fechaActual = Calendar.getInstance();
			Calendar fechaInicio = Calendar.getInstance();
			fechaInicio.set(QUERY_ANIO_MIN, 1, 1);

			LogHandler.trace(uid, getClass(),
					"==> registrarSolicitudBuroTarea - existeSolicitud");

			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			Integer numeroSolicutudes = (Integer) sesionNTx.selectOne(
					"existeSolicitud", peticion.getSolicitud());
			if (numeroSolicutudes == 0) {
				final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
				parametros.put("solicitud", peticion.getSolicitud());
				parametros.put(
						"claveEmpresa",
						peticion.getClaveEmpresa() != null ? peticion
								.getClaveEmpresa() : "100000000003");
				parametros.put(
						"creditoGrupal",
						peticion.getCreditoGrupal() != null ? peticion
								.getCreditoGrupal() : "");
				parametros.put(
						"numeroIntegrantes",
						peticion.getNumeroIntegrantes() != null ? peticion
								.getNumeroIntegrantes() : 0);
				parametros.put("oficina",
						peticion.getOficina() != null ? peticion.getOficina()
								: 0);
				parametros.put("segmento",
						peticion.getSegmento() != null ? peticion.getSegmento()
								: "");
				parametros.put(
						"categoria",
						peticion.getCategoria() != null ? peticion
								.getCategoria() : "");
				parametros.put(
						"codigoProducto",
						peticion.getCodigoProducto() != null ? peticion
								.getCodigoProducto() : "");
				parametros.put("cliente",
						peticion.getCliente() != null ? peticion.getCliente()
								: "");
				parametros.put(
						"efectivoSolicitado",
						peticion.getEfectivoSolicitado() != null ? peticion
								.getEfectivoSolicitado() : 0.0);
				parametros.put(
						"montoSolicitado",
						peticion.getMontoSolicitado() != null ? peticion
								.getMontoSolicitado() : 0.0);
				parametros.put(
						"frecuenciaPago",
						peticion.getFrecuenciaPago() != null ? peticion
								.getFrecuenciaPago() : "S");
				parametros.put(
						"plazoSolicitado",
						peticion.getPlazoSolicitado() != null ? peticion
								.getPlazoSolicitado() : 0);
				parametros.put("diaPago",
						peticion.getDiaPago() != null ? peticion.getDiaPago()
								: 0);
				parametros.put("tasa",
						peticion.getTasa() != null ? peticion.getTasa() : 0.0);
				parametros.put(
						"comisionApertura",
						peticion.getComisionApertura() != null ? peticion
								.getComisionApertura() : 0.0);
				parametros.put("cat",
						peticion.getCat() != null ? peticion.getCat() : 0.0);
				parametros.put(
						"oficinaDisposicion",
						peticion.getOficinaDisposicion() != null ? peticion
								.getOficinaDisposicion() : 0);
				parametros.put("plazo",
						peticion.getPlazo() != null ? peticion.getPlazo() : 0);
				parametros.put(
						"horaReunion",
						peticion.getHoraReunion() != null ? peticion
								.getHoraReunion() : "");
				parametros.put(
						"diaReunion",
						peticion.getDiaReunion() != null ? peticion
								.getDiaReunion() : 0);
				parametros.put(
						"numeroFamiliaresGrupo",
						peticion.getNumeroFamiliaresGrupo() != null ? peticion
								.getNumeroFamiliaresGrupo() : 0);
				parametros.put(
						"montoPago",
						peticion.getMontoPago() != null ? peticion
								.getMontoPago() : 0.0);
				parametros.put(
						"montoFinanciadoContAnt",
						peticion.getMontoFinanciadoContAnt() != null ? peticion
								.getMontoFinanciadoContAnt() : 0.0);
				parametros.put(
						"contratoAnt",
						peticion.getContratoAnt() != null ? peticion
								.getContratoAnt() : "");
				parametros.put(
						"fechaResolucion",
						peticion.getFechaResolucion() != null ? peticion
								.getFechaResolucion() : fechaInicio.getTime());
				parametros.put(
						"horaResolucion",
						peticion.getHoraResolucion() != null ? peticion
								.getHoraResolucion() : fechaInicio.getTime());
				parametros.put(
						"efectivoOtorgado",
						peticion.getEfectivoOtorgado() != null ? peticion
								.getEfectivoOtorgado() : 0.0);
				parametros.put(
						"montoOtorgado",
						peticion.getMontoOtorgado() != null ? peticion
								.getMontoOtorgado() : 0.0);
				parametros.put("contrato",
						peticion.getContrato() != null ? peticion.getContrato()
								: "");
				parametros.put("vendedor",
						peticion.getVendedor() != null ? peticion.getVendedor()
								: "");
				parametros.put(
						"vendedorOrig",
						peticion.getVendedorOrig() != null ? peticion
								.getVendedorOrig() : "");
				parametros.put(
						"gteVentas",
						peticion.getGteVentas() != null ? peticion
								.getGteVentas() : "");
				parametros.put(
						"grupoVentas",
						peticion.getGrupoVentas() != null ? peticion
								.getGrupoVentas() : 0);
				parametros.put(
						"gteSucursal",
						peticion.getGteSucursal() != null ? peticion
								.getGteSucursal() : "");
				parametros.put(
						"contratoRecomienda",
						peticion.getContratoRecomienda() != null ? peticion
								.getContratoRecomienda() : "");
				parametros.put(
						"claveCorresponsal",
						peticion.getClaveCorresponsal() != null ? peticion
								.getClaveCorresponsal() : "");
				parametros.put("status",
						peticion.getStatus() != null ? peticion.getStatus()
								: "A");
				parametros.put("ciclo",
						peticion.getCiclo() != null ? peticion.getCiclo() : 0);
				parametros.put(
						"origenVenta",
						peticion.getOrigenVenta() != null ? peticion
								.getOrigenVenta() : "");
				parametros.put("etapa",
						peticion.getEtapa() != null ? peticion.getEtapa() : "");
				parametros.put(
						"tipoVerificacion",
						peticion.getTipoVerificacion() != null ? peticion
								.getTipoVerificacion() : "");
				parametros.put(
						"fechaCaptura",
						peticion.getFechaCaptura() != null ? peticion
								.getFechaCaptura() : fechaActual.getTime());
				parametros.put(
						"horaCaptura",
						peticion.getHoraCaptura() != null ? peticion
								.getHoraCaptura() : fechaActual.getTime());
				parametros.put(
						"etapaAnterior",
						peticion.getEtapaAnterior() != null ? peticion
								.getEtapaAnterior() : "");
				parametros.put(
						"motivoStatus",
						peticion.getMotivoStatus() != null ? peticion
								.getMotivoStatus() : "");
				parametros.put(
						"fechaUltMod",
						peticion.getFechaUltMod() != null ? peticion
								.getFechaUltMod() : fechaActual.getTime());
				parametros.put(
						"horaUltMod",
						peticion.getHoraUltMod() != null ? peticion
								.getHoraUltMod() : fechaActual.getTime());
				parametros
						.put("usuarioRegistraSolicitud",
								peticion.getUsuarioRegistraSolicitud() != null ? peticion
										.getUsuarioRegistraSolicitud() : "");
				LogHandler.info(uid, getClass(),
						"==> registrarSolicitudMinimaTarea - insertaSolicitud");
				LogHandler.trace(uid, getClass(),
						"==> registrarSolicitudMinimaTarea - insertaSolicitud");
				sesionTx.insert("insertaSolicitud", parametros);
				if (!sesionExterna) {
					sesionTx.commit(true);
				}
			}

			respuesta.getHeader().setMensaje("SE HA INSERTADO LA SOLICITUD");

		} catch (Exception ex) {
			if (!sesionExterna) {
				FabricaConexiones.rollBack(sesionTx);
			}
			LogHandler.error(uid, getClass(), "registrarSolicitudTarea(): "
					+ ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(
					"registrarSolicitudTarea(): " + ex.getMessage());
		} finally {
			if (!sesionExterna) {
				FabricaConexiones.close(sesionTx);
			}
			FabricaConexiones.close(sesionNTx);
		}

		return respuesta;
	}

	public EncabezadoSolicitudRespuesta obtenerDatosSolicitudEncabezadoTarea(
			String uid, SolicitudBuroOV peticion) {
		EncabezadoSolicitudRespuesta respuesta = new EncabezadoSolicitudRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);

		SqlSession sesion = null;
		try {
			sesion = FabricaConexiones.obtenerSesionNTx();

			// parametros de consulta
			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("id", peticion == null
					|| peticion.getSolicitud() == null
					|| peticion.getSolicitud().toString().isEmpty() ? null
					: peticion.getSolicitud());

			LogHandler
					.trace(uid, getClass(),
							"==> obtenerDatosSolicitudEncabezadoTarea - consultaSolicitudEncabezadoMO");
			SolicitudBuroOV solicitudEncabezado = (SolicitudBuroOV) sesion
					.selectOne("consultaSolicitudEncabezadoMO", parametros);

			if (solicitudEncabezado == null) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitud.encabezado.consulta.inexistente"));
			}

			respuesta.getHeader().setMensaje(
					"La consulta se ha realizado con exito.");
			respuesta.setSolicitudEncabezado(solicitudEncabezado);

		} catch (Exception exception) {
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(exception.getMessage());
			respuesta.getHeader().setEstatus(false);
			LogHandler.error(uid, this.getClass(),
					"Error en obtenerDatosSolicitudEncabezadoTarea : "
							+ exception.getMessage(), exception);
		} finally {
			FabricaConexiones.close(sesion);
		}

		return respuesta;
	}

	/**
	 * @param uid
	 *            String
	 * @param peticion
	 *            SolicitudBuroOV
	 * @return respuesta tipo EncabezadoSolicitudRespuesta
	 */
	public EncabezadoSolicitudRespuesta obtenerDatosSolicitudEncabezadoAnalistaDocumentalBCTarea(
			String uid, SolicitudBuroOV peticion) {
		EncabezadoSolicitudRespuesta respuesta = new EncabezadoSolicitudRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);

		SqlSession sesion = null;
		try {
			sesion = FabricaConexiones.obtenerSesionNTx();

			// parametros de consulta
			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("id", peticion == null
					|| peticion.getSolicitud() == null
					|| peticion.getSolicitud().toString().isEmpty() ? null
					: peticion.getSolicitud());

			LogHandler
					.trace(uid,
							getClass(),
							"==> obtenerDatosSolicitudEncabezadoAnalistaDocumentalBCTarea "
									+ " - consultaSolicitudEncabezadoMOAnalistaDocumentalBC");
			SolicitudBuroOV solicitudEncabezado = (SolicitudBuroOV) sesion
					.selectOne(
							"consultaSolicitudEncabezadoMOAnalistaDocumentalBC",
							parametros);

			if (solicitudEncabezado == null) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitud.encabezado.consulta.inexistente"));
			}

			respuesta.getHeader().setMensaje(
					"La consulta se ha realizado con exito.");
			respuesta.setSolicitudEncabezado(solicitudEncabezado);

		} catch (Exception exception) {
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(exception.getMessage());
			respuesta.getHeader().setEstatus(false);
			LogHandler.error(uid, this.getClass(),
					"Error en obtenerDatosSolicitudEncabezadoTarea : "
							+ exception.getMessage(), exception);
		} finally {
			FabricaConexiones.close(sesion);
		}

		return respuesta;
	}

	@SuppressWarnings("unchecked")
	public AcreditadosRespuesta procGetAcreditadosTarea(String uid,
			AcreditadosPeticion acreditadosPeticion) {
		AcreditadosRespuesta acreditadosRespuesta = new AcreditadosRespuesta();
		acreditadosRespuesta.setHeader(new EncabezadoRespuesta());
		acreditadosRespuesta.getHeader().setUID(uid);
		acreditadosRespuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		List<Acreditados> acreditadosList = null;
		String validaStr = "";
		try {

			if ((acreditadosPeticion.getFechaNacimiento() == null || acreditadosPeticion
					.getFechaNacimiento().equals(""))
					&& (acreditadosPeticion.getpNombre() == null || acreditadosPeticion
							.getpNombre().equals(""))
					&& (acreditadosPeticion.getpAPaterno() == null || acreditadosPeticion
							.getpAPaterno().equals(""))
					&& (acreditadosPeticion.getpAMaterno() == null || acreditadosPeticion
							.getpAMaterno().equals(""))) {
				if (!Validaciones.rfcValido(acreditadosPeticion.getRfc())) {
					throw new Exception(RFC_INVALIDO);
				}
			} else {
				String[] datosRequeridos = { "pNombre", "pAPaterno",
						"fechaNacimiento" };
				validaStr = Validaciones.datosRequeridos(acreditadosPeticion,
						datosRequeridos);
				if (!validaStr.equalsIgnoreCase("")) {
					throw new Exception(DATOS_REQUERIDOS + validaStr);
				}
			}
			java.util.HashMap<String, Object> peticionParametros = new java.util.HashMap<String, Object>();
			peticionParametros = Funciones
					.objectToHashMapUpdate(acreditadosPeticion);
			// Se abre la sesion No transaccional sybase
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(),
					"ProcGetAcreditadosTarea: - consultaProcGetAcreditados");
			LogHandler.info(uid, getClass(),
					"ProcGetAcreditadosTarea: - consultaProcGetAcreditados");
			acreditadosList = sesionNTx.selectList(
					"consultaProcGetAcreditados", peticionParametros);
			if (acreditadosList.isEmpty()) {
				throw new Exception(CLIENTE_INEXISTENTE);
			}
			acreditadosRespuesta.setAcreditados(acreditadosList);
		} catch (Exception ex) {
			LogHandler.error(uid, getClass(),
					"ProcGetAcreditadosTarea: " + ex.getMessage(), ex);
			acreditadosRespuesta.getHeader().setEstatus(false);
			acreditadosRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			acreditadosRespuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return acreditadosRespuesta;
	}

	public SolicitudIDRespuesta procGetSolicitudTarea(String uid,
			ContratoPeticionKit contratoPeticionKit) {
		SolicitudIDRespuesta solicitudIDRespuesta = new SolicitudIDRespuesta();
		solicitudIDRespuesta.setHeader(new EncabezadoRespuesta());
		solicitudIDRespuesta.getHeader().setUID(uid);
		solicitudIDRespuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		String solicitudID = null;
		String validaStr = "";
		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			String[] datosRequeridos = { "contrato" };
			validaStr = Validaciones.datosRequeridos(contratoPeticionKit,
					datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}
			LogHandler.trace(uid, getClass(),
					"ProcGetSolicitudTarea: - consultaProcGetSolicitud");
			LogHandler.info(uid, getClass(),
					"ProcGetSolicitudTarea: - consultaProcGetSolicitud");
			solicitudID = (String) sesionNTx.selectOne(
					"consultaProcGetSolicitud",
					contratoPeticionKit.getContrato());
			if (solicitudID == null || solicitudID.equals("")) {
				throw new Exception(SOLICITUD_NO_ENCONTRADA);
			}
			solicitudIDRespuesta.setID(solicitudID);
		} catch (Exception ex) {
			LogHandler.error(uid, getClass(),
					"ProcGetSolicitudTarea: " + ex.getMessage(), ex);
			solicitudIDRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			solicitudIDRespuesta.getHeader().setEstatus(false);
			solicitudIDRespuesta.getHeader().setCodigo(ex.getMessage());

		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return solicitudIDRespuesta;
	}

	@SuppressWarnings("unchecked")
	public SolicitudesTempRespuesta procGetSolicitudesTempTarea(String uid,
			SolicitudesTempPeticion solicitudesTempPeticion) {
		SolicitudesTempRespuesta solicitudesTempRespuesta = new SolicitudesTempRespuesta();
		solicitudesTempRespuesta.setHeader(new EncabezadoRespuesta());
		solicitudesTempRespuesta.getHeader().setUID(uid);
		solicitudesTempRespuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		List<SolicitudesTemp> solicitudesTempList = null;
		String validaStr = "";
		try {
			String[] datosRequeridos = { "pSucursal", "pNombreGrupo" };

			validaStr = Validaciones.datosRequeridos(solicitudesTempPeticion,
					datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			java.util.HashMap<String, Object> peticionParametros = new java.util.HashMap<String, Object>();
			peticionParametros = Funciones
					.objectToHashMapUpdate(solicitudesTempPeticion);
			if (!solicitudesTempPeticion.getpSucursal().equalsIgnoreCase("%")) {
				peticionParametros.put("pSucursalInt",
						Long.parseLong(solicitudesTempPeticion.getpSucursal()));
			}

			// Se abre la sesion No transaccional sybase
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler
					.trace(uid, getClass(),
							"ProcGetSolicitudesTempTarea: - consultaProcGetSolicitudesTemp");
			LogHandler
					.info(uid, getClass(),
							"ProcGetSolicitudesTempTarea: - consultaProcGetSolicitudesTemp");
			solicitudesTempList = sesionNTx.selectList(
					"consultaProcGetSolicitudesTemp", peticionParametros);

			if (solicitudesTempList.isEmpty()) {
				throw new Exception(CONSULTA_SIN_REGISTROS);
			}
			solicitudesTempRespuesta.setSolicitudes(solicitudesTempList);
		} catch (Exception ex) {
			LogHandler.error(uid, getClass(), "ProcGetSolicitudesTempTarea: "
					+ ex.getMessage(), ex);
			solicitudesTempRespuesta.getHeader().setEstatus(false);
			solicitudesTempRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			solicitudesTempRespuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return solicitudesTempRespuesta;

	}

	@SuppressWarnings("unchecked")
	public SolicitudesRepRespuesta procGetRepSolicitudesTarea(String uid,
			SolicitudesRepPeticion solicitudesRepPeticion) {
		SolicitudesRepRespuesta solicitudesRepRespuesta = new SolicitudesRepRespuesta();
		solicitudesRepRespuesta.setHeader(new EncabezadoRespuesta());
		solicitudesRepRespuesta.getHeader().setUID(uid);
		solicitudesRepRespuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		List<SolicitudesRep> solicitudesRepList = null;
		String validaStr = "";
		try {
			String[] datosRequeridos = { "pFechaInicio", "pFechaFin",
					"pSucursal", "pEstatus", "pCiclo", "pProducto" };
			validaStr = Validaciones.datosRequeridos(solicitudesRepPeticion,
					datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			if (!Validaciones.fechaValida(solicitudesRepPeticion
					.getpFechaInicio())) {
				LogHandler.info(
						uid,
						getClass(),
						"ProcGetRepSolicitudesTarea: - " + FECHA_INVALIDA
								+ " :: pFechaInicio: "
								+ solicitudesRepPeticion.getpFechaInicio());
				throw new Exception(FECHA_INVALIDA);
			}

			if (!Validaciones
					.fechaValida(solicitudesRepPeticion.getpFechaFin())) {
				LogHandler.info(
						uid,
						getClass(),
						"ProcGetRepSolicitudesTarea: - " + FECHA_INVALIDA
								+ " :: pFechaFin: "
								+ solicitudesRepPeticion.getpFechaFin());
				throw new Exception(FECHA_INVALIDA);
			}

			java.util.HashMap<String, Object> peticionParametros = new java.util.HashMap<String, Object>();
			peticionParametros = Funciones
					.objectToHashMapUpdate(solicitudesRepPeticion);

			if (!solicitudesRepPeticion.getpSucursal().equalsIgnoreCase("%")) {
				peticionParametros.put("pSucursalInt",
						Long.parseLong(solicitudesRepPeticion.getpSucursal()));
			}
			if (!solicitudesRepPeticion.getpCiclo().equalsIgnoreCase("%")) {
				peticionParametros.put("pCicloInt",
						Integer.parseInt(solicitudesRepPeticion.getpCiclo()));
			}
			// Se abre la sesion No transaccional sybase
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(),
					"ProcGetRepSolicitudesTarea: - consultaPrGetFecha");
			LogHandler.info(uid, getClass(),
					"ProcGetRepSolicitudesTarea: - consultaPrGetFecha");
			Date fechaContable = (Date) sesionNTx
					.selectOne("consultaPrGetFecha");
			if (fechaContable == null) {
				throw new Exception(CONSULTA_SIN_REGISTROS);
			}
			LogHandler.info(uid, getClass(),
					"ProcGetRepSolicitudesTarea: fechaContable: "
							+ fechaContable);
			peticionParametros.put("fechaContable", fechaContable);

			LogHandler
					.trace(uid, getClass(),
							"ProcGetRepSolicitudesTarea: - consultaProcGetRepSolicitudes");
			LogHandler
					.info(uid, getClass(),
							"ProcGetRepSolicitudesTarea: - consultaProcGetRepSolicitudes");
			solicitudesRepList = sesionNTx.selectList(
					"consultaProcGetRepSolicitudes", peticionParametros);

			if (solicitudesRepList.isEmpty()) {
				throw new Exception(CONSULTA_SIN_REGISTROS);
			}
			solicitudesRepRespuesta.setSolicitudes(solicitudesRepList);
		} catch (Exception ex) {
			LogHandler.error(uid, getClass(), "ProcGetRepSolicitudesTarea: "
					+ ex.getMessage(), ex);
			solicitudesRepRespuesta.getHeader().setEstatus(false);
			solicitudesRepRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			solicitudesRepRespuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return solicitudesRepRespuesta;
	}

	@SuppressWarnings("unchecked")
	public MultiClaveCteRespuesta procGetMultiClaveCteTarea(String uid,
			MultiClaveCtePeticion multiClaveCtePeticion) {
		MultiClaveCteRespuesta multiClaveCteRespuesta = new MultiClaveCteRespuesta();
		multiClaveCteRespuesta.setHeader(new EncabezadoRespuesta());
		multiClaveCteRespuesta.getHeader().setUID(uid);
		multiClaveCteRespuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		List<ClaveCliente> multiClaveCteList = null;
		String validaStr = "";
		try {
			String[] datosRequeridos = { "pCodigosCliente" };

			validaStr = Validaciones.datosRequeridos(multiClaveCtePeticion,
					datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			List<String> tmpList = multiClaveCtePeticion.getpCodigosCliente();

			// Se abre la sesion No transaccional sybase
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler
					.trace(uid, getClass(),
							"ProcGetMultiClaveCteTarea: - consultaProcGetMultiClaveCte");
			LogHandler
					.info(uid, getClass(),
							"ProcGetMultiClaveCteTarea: - consultaProcGetMultiClaveCte");
			multiClaveCteList = sesionNTx.selectList(
					"consultaProcGetMultiClaveCte", tmpList);

			if (multiClaveCteList.isEmpty()) {
				throw new Exception(CONSULTA_SIN_REGISTROS);
			}
			multiClaveCteRespuesta.setMultiClaves(multiClaveCteList);
		} catch (Exception ex) {
			LogHandler.error(uid, getClass(), "ProcGetMultiClaveCteTarea: "
					+ ex.getMessage(), ex);
			multiClaveCteRespuesta.getHeader().setEstatus(false);
			multiClaveCteRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			multiClaveCteRespuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return multiClaveCteRespuesta;
	}

	public ClaveCteUnicoRespuesta procGetClaveCteUnicoTarea(String uid,
			ClaveCteUnicoPeticion claveCteUnicoPeticion) {
		ClaveCteUnicoRespuesta claveCteUnicoRespuesta = new ClaveCteUnicoRespuesta();
		claveCteUnicoRespuesta.setHeader(new EncabezadoRespuesta());
		claveCteUnicoRespuesta.getHeader().setUID(uid);
		claveCteUnicoRespuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		ClaveCliente claveCliente = null;
		String validaStr = "";
		try {
			String[] datosRequeridos = { "pCodigoCliente" };

			validaStr = Validaciones.datosRequeridos(claveCteUnicoPeticion,
					datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			// Se abre la sesion No transaccional sybase
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler
					.trace(uid, getClass(),
							"ProcGetClaveCteUnicoTarea: - consultaProcGetClaveCteUnico");
			LogHandler
					.info(uid, getClass(),
							"ProcGetClaveCteUnicoTarea: - consultaProcGetClaveCteUnico");
			claveCliente = (ClaveCliente) sesionNTx.selectOne(
					"consultaProcGetClaveCteUnico",
					claveCteUnicoPeticion.getpCodigoCliente());

			if (claveCliente == null) {
				throw new Exception(CONSULTA_SIN_REGISTROS);
			}
			claveCteUnicoRespuesta.setClaveCliente(claveCliente);
		} catch (Exception ex) {
			LogHandler.error(uid, getClass(), "ProcGetClaveCteUnicoTarea: "
					+ ex.getMessage(), ex);
			claveCteUnicoRespuesta.getHeader().setEstatus(false);
			claveCteUnicoRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			claveCteUnicoRespuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return claveCteUnicoRespuesta;
	}

	@SuppressWarnings("unchecked")
	public AuditoriaRespuesta procGetDatosAuditoriaTarea(String uid,
			AuditoriaPeticion auditoriaPeticion) {
		AuditoriaRespuesta auditoriaRespuesta = new AuditoriaRespuesta();
		auditoriaRespuesta.setHeader(new EncabezadoRespuesta());
		auditoriaRespuesta.getHeader().setUID(uid);
		auditoriaRespuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		List<Auditoria> auditorias = null;
		String validaStr = "";
		try {
			String[] datosRequeridos = { "pSolicitud" };

			validaStr = Validaciones.datosRequeridos(auditoriaPeticion,
					datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			// Se abre la sesion No transaccional sybase
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler
					.trace(uid, getClass(),
							"ProcGetDatosAuditoriaTarea: - consultaProcGetDatosAuditoria");
			LogHandler
					.info(uid, getClass(),
							"ProcGetDatosAuditoriaTarea: - consultaProcGetDatosAuditoria");
			auditorias = (List<Auditoria>) sesionNTx.selectList(
					"consultaProcGetDatosAuditoria",
					auditoriaPeticion.getpSolicitud());

			if (auditorias.isEmpty()) {
				throw new Exception(CONSULTA_SIN_REGISTROS);
			}
			auditoriaRespuesta.setAuditorias(auditorias);
		} catch (Exception ex) {
			LogHandler.error(uid, getClass(), "ProcGetDatosAuditoriaTarea: "
					+ ex.getMessage(), ex);
			auditoriaRespuesta.getHeader().setEstatus(false);
			auditoriaRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			auditoriaRespuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return auditoriaRespuesta;
	}

	public SolicitudesRespuesta procEliminacionCreditoTarea(String uid,
			EliminacionCreditoPeticion eliminacionCreditoPeticion) {
		SolicitudesRespuesta solicitudesRespuesta = new SolicitudesRespuesta();
		solicitudesRespuesta.setHeader(new EncabezadoRespuesta());
		solicitudesRespuesta.getHeader().setUID(uid);
		solicitudesRespuesta.getHeader().setEstatus(true);
		int registrosAfectados = 0;

		SqlSession sesionTx = null;
		String validaStr = "";
		try {
			sesionTx = FabricaConexiones.obtenerSesionTx();
			java.util.HashMap<String, Object> solicitudLogParametros = null;
			String[] solicitudDatosRequeridos = { "pContrato", "pUsuario" };

			validaStr = Validaciones.datosRequeridos(
					eliminacionCreditoPeticion, solicitudDatosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			solicitudLogParametros = Funciones
					.objectToHashMapUpdate(eliminacionCreditoPeticion);
			solicitudLogParametros.put("descripcion", "ELIMINACION");

			LogHandler
					.trace(uid, getClass(),
							"ProcEliminacionCreditoTarea: - insertaProcEliminacionCreditoLog");
			LogHandler
					.info(uid, getClass(),
							"ProcEliminacionCreditoTarea: - insertaProcEliminacionCreditoLog");
			registrosAfectados = sesionTx.insert(
					"insertaProcEliminacionCreditoLog", solicitudLogParametros);
			LogHandler.info(uid, getClass(),
					"ProcEliminacionCreditoTarea: - registrosAfectados: "
							+ registrosAfectados);
			if (registrosAfectados == 0) {
				throw new Exception(ERROR_ACTUALIZACION);
			}

			LogHandler
					.trace(uid, getClass(),
							"ProcEliminacionCreditoTarea: - actualizaProcEliminacionCredito");
			LogHandler
					.info(uid, getClass(),
							"ProcEliminacionCreditoTarea: - actualizaProcEliminacionCredito");
			registrosAfectados = sesionTx.update(
					"actualizaProcEliminacionCredito",
					eliminacionCreditoPeticion.getpContrato());
			LogHandler.info(uid, getClass(),
					"ProcEliminacionCreditoTarea: - registrosAfectados: "
							+ registrosAfectados);
			if (registrosAfectados == 0) {
				throw new Exception(ERROR_ACTUALIZACION);
			}

			sesionTx.commit(true);
			solicitudesRespuesta.getHeader().setMensaje(SOLICITUD_ELIMINADA);

		} catch (Exception ex) {
			FabricaConexiones.rollBack(sesionTx);
			LogHandler.error(uid, getClass(), "ProcEliminacionCreditoTarea: "
					+ ex.getMessage(), ex);
			solicitudesRespuesta.getHeader().setEstatus(false);
			solicitudesRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			solicitudesRespuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionTx);
		}

		return solicitudesRespuesta;
	}

	@SuppressWarnings({ "null", "unchecked" })
	public SolicitudesRespuesta procGuardarCreditoTempTarea(String uid,
			SolicitudSACGPeticion solicitudesSACGPeticion) {
		SolicitudesRespuesta solicitudesRespuesta = new SolicitudesRespuesta();
		solicitudesRespuesta.setHeader(new EncabezadoRespuesta());
		solicitudesRespuesta.getHeader().setUID(uid);
		solicitudesRespuesta.getHeader().setEstatus(true);
		SqlSession sesionTx = null;
		SqlSession sesionNTx = null;
		String mensaje = "";
		String validaStr = "";
		String mensajeValidaSaldoRenFin = "";
		int registrosAfectados = 0;
		try {

			if (solicitudesSACGPeticion == null) {
				throw new Exception(DATOS_INCORRECTOS);
			}

			sesionTx = FabricaConexiones.obtenerSesionTx();
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			// Obtiene cargos de los integrantes:
			String cargoPresidente = "";
			String cargoSecretario = "";
			String cargoSupervisor = "";
			String cargoTesorero = "";

			String[] integranteDatosRequeridos = { "codigoT24",
					"nuevoCreditoSolicitado", "ahorro", "propositoPrestamo",
					"aprobado", "tipoLocalidad" };
			DomicilioOV domicilioOV = null;
			GrupoOV grupoOV = new GrupoOV();
			if (solicitudesSACGPeticion.getSolicitudSACGGrupo() != null) {
				if (solicitudesSACGPeticion.getSolicitudSACGGrupo()
						.getPresidente() != null
						&& !solicitudesSACGPeticion.getSolicitudSACGGrupo()
								.getPresidente().equalsIgnoreCase("")) {
					LogHandler
							.trace(uid, getClass(),
									"ProcGuardarCreditoTempTarea: - buscarClavePersonaSolicitud.Presidente");
					LogHandler
							.info(uid, getClass(),
									"ProcGuardarCreditoTempTarea: - buscarClavePersonaSolicitud.Presidente");
					cargoPresidente = (String) sesionTx.selectOne(
							"buscarClavePersonaSolicitud",
							solicitudesSACGPeticion.getSolicitudSACGGrupo()
									.getPresidente());
					LogHandler.info(uid, getClass(),
							"ProcGuardarCreditoTempTarea: - cargoPresidente: "
									+ cargoPresidente);
				}
				if (solicitudesSACGPeticion.getSolicitudSACGGrupo()
						.getSecretario() != null
						&& !solicitudesSACGPeticion.getSolicitudSACGGrupo()
								.getSecretario().equalsIgnoreCase("")) {
					LogHandler
							.trace(uid, getClass(),
									"ProcGuardarCreditoTempTarea: - buscarClavePersonaSolicitud.Secretario");
					LogHandler
							.info(uid, getClass(),
									"ProcGuardarCreditoTempTarea: - buscarClavePersonaSolicitud.Secretario");
					cargoSecretario = (String) sesionTx.selectOne(
							"buscarClavePersonaSolicitud",
							solicitudesSACGPeticion.getSolicitudSACGGrupo()
									.getSecretario());
					LogHandler.info(uid, getClass(),
							"ProcGuardarCreditoTempTarea: - cargoSecretario: "
									+ cargoSecretario);
				}
				if (solicitudesSACGPeticion.getSolicitudSACGGrupo()
						.getSupervisor() != null
						&& !solicitudesSACGPeticion.getSolicitudSACGGrupo()
								.getSupervisor().equalsIgnoreCase("")) {
					LogHandler
							.trace(uid, getClass(),
									"ProcGuardarCreditoTempTarea: - buscarClavePersonaSolicitud.Supervisor");
					LogHandler
							.info(uid, getClass(),
									"ProcGuardarCreditoTempTarea: - buscarClavePersonaSolicitud.Supervisor");
					cargoSupervisor = (String) sesionTx.selectOne(
							"buscarClavePersonaSolicitud",
							solicitudesSACGPeticion.getSolicitudSACGGrupo()
									.getSupervisor());
					LogHandler.info(uid, getClass(),
							"ProcGuardarCreditoTempTarea: - cargoSupervisor: "
									+ cargoSupervisor);
				}
				if (solicitudesSACGPeticion.getSolicitudSACGGrupo()
						.getTesorero() != null
						&& !solicitudesSACGPeticion.getSolicitudSACGGrupo()
								.getTesorero().equalsIgnoreCase("")) {
					LogHandler
							.trace(uid, getClass(),
									"ProcGuardarCreditoTempTarea: - buscarClavePersonaSolicitud.Tesorero");
					LogHandler
							.info(uid, getClass(),
									"ProcGuardarCreditoTempTarea: - buscarClavePersonaSolicitud.Tesorero");
					cargoTesorero = (String) sesionTx.selectOne(
							"buscarClavePersonaSolicitud",
							solicitudesSACGPeticion.getSolicitudSACGGrupo()
									.getTesorero());
					LogHandler.info(uid, getClass(),
							"ProcGuardarCreditoTempTarea: - cargoTesorero: "
									+ cargoTesorero);
				}

			}

			// Validacion dia de pago y dia reunion
			String categoria = DataMapper.mapCategoriaProductos
					.get(solicitudesSACGPeticion.getSolicitudSACG()
							.getProducto());
			if (categoria == null) {
				categoria = "";
			}
			if (categoria.equals("COMUNAL") || categoria.equals("SOLIDARIO")) {
				LogHandler.info(uid, getClass(),
						"ProcGuardarCreditoTempTarea: - getId: "
								+ solicitudesSACGPeticion.getSolicitudSACG()
										.getId());
				LogHandler.info(uid, getClass(),
						"ProcGuardarCreditoTempTarea: - getExpress: "
								+ solicitudesSACGPeticion.getSolicitudSACG()
										.getExpress());
				if (!((solicitudesSACGPeticion.getSolicitudSACG().getId() == null
						|| solicitudesSACGPeticion.getSolicitudSACG().getId()
								.equalsIgnoreCase("") || solicitudesSACGPeticion
						.getSolicitudSACG().getId().equalsIgnoreCase("0")) && (solicitudesSACGPeticion
						.getSolicitudSACG().getExpress() != null && solicitudesSACGPeticion
						.getSolicitudSACG().getExpress().equals("S")))) {
					if (solicitudesSACGPeticion.getSolicitudSACG()
							.getDiaReunion() == null
							|| solicitudesSACGPeticion.getSolicitudSACG()
									.getDiaReunion() == 0) {
						throw new Exception(
								"Debe seleccionar el dia de reunion.");
					}

					if (solicitudesSACGPeticion.getSolicitudSACG().getDiaPago() == null
							|| solicitudesSACGPeticion.getSolicitudSACG()
									.getDiaPago() == 0) {
						throw new Exception("Verifique dia de pago.");
					}
					EncabezadoRespuesta respuestaValidacionDiaPago = validarDiaReunionPago(
							uid, solicitudesSACGPeticion);
					if (!respuestaValidacionDiaPago.isEstatus()) {
						throw new Exception(
								respuestaValidacionDiaPago.getMensaje());
					}
				}
			}

			java.lang.String solicitudFolio = "";
			// INSERT Solicitud.
			if (solicitudesSACGPeticion.getSolicitudSACG().getId() == null
					|| solicitudesSACGPeticion.getSolicitudSACG().getId()
							.equalsIgnoreCase("")
					|| solicitudesSACGPeticion.getSolicitudSACG().getId()
							.equalsIgnoreCase("0")) {
				mensaje = SOLICITUD_GUARDADA;

				String[] grupoDatosRequeridos = { "nombre", "analista" };

				if (solicitudesSACGPeticion.getSolicitudSACGGrupo() == null) {
					throw new Exception(DATOS_INCORRECTOS);
				}

				validaStr = Validaciones.datosRequeridos(
						solicitudesSACGPeticion.getSolicitudSACGGrupo(),
						grupoDatosRequeridos);
				if (!validaStr.equalsIgnoreCase("")) {
					throw new Exception(DATOS_REQUERIDOS + validaStr);
				}

				LogHandler.trace(uid, getClass(),
						"ProcGuardarCreditoTempTarea: - obtenerFolioSolicitud");
				LogHandler.info(uid, getClass(),
						"ProcGuardarCreditoTempTarea: - obtenerFolioSolicitud");
				solicitudFolio = (java.lang.String) sesionNTx
						.selectOne("obtenerFolioSolicitud");

				solicitudesSACGPeticion.getSolicitudSACG()
						.setId(solicitudFolio);

				String[] solicitudDatosRequeridos = { "id", "sucursal", "tasa",
						"plazo", "nuevoCreditoSolicitado", "renovacion",
						"visualizaCec", "renovacionFinanciada" };

				validaStr = Validaciones.datosRequeridos(
						solicitudesSACGPeticion.getSolicitudSACG(),
						solicitudDatosRequeridos);
				if (!validaStr.equalsIgnoreCase("")) {
					throw new Exception(DATOS_REQUERIDOS + validaStr);
				}

				// *** Validacion saldos por integrantes renovacion financiada
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getRenovacionFinanciada()
						&& solicitudesSACGPeticion.getSolicitudSACG()
								.getContratoPrevio() != null
						&& !solicitudesSACGPeticion.getSolicitudSACG()
								.getContratoPrevio().trim().equals("")) {

					for (int i = 0; i < solicitudesSACGPeticion
							.getSolicitudSACGIntegrantes().size(); i++) {
						if (solicitudesSACGPeticion
								.getSolicitudSACGIntegrantes().get(i)
								.getNuevoCreditoSolicitado() > 0) {
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getSaldoActual() > solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getNuevoCreditoSolicitado()
									&& !solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getDesertor().equals("S")) {
								mensajeValidaSaldoRenFin = "El saldo actual "
										+ solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getSaldoActual()
										+ " es mayor al monto solicitado "
										+ solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i)
												.getNuevoCreditoSolicitado()
										+ " para el cliente: "
										// +
										// solicitudesSACGPeticion.getSolicitudSACGIntegrantes().get(i).getCodigoT24().trim()
										+ solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getNombreCompleto();
							}
						}
					}

				}

				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getVisualizaCec().trim().equals("true")) {
					if (solicitudesSACGPeticion.getSolicitudSACG()
							.getRenovacionFinanciada()
							&& solicitudesSACGPeticion.getSolicitudSACG()
									.getContratoPrevio() != null
							&& !solicitudesSACGPeticion.getSolicitudSACG()
									.getContratoPrevio().trim().equals("")) {

						for (int i = 0; i < solicitudesSACGPeticion
								.getSolicitudSACGIntegrantes().size(); i++) {
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getSaldoActual() > solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getNuevoCreditoSolicitado()
									&& !solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getDesertor().equals("S")) {
								mensajeValidaSaldoRenFin = "El saldo actual "
										+ solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getSaldoActual()
										+ " es mayor al monto solicitado "
										+ solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i)
												.getNuevoCreditoSolicitado()
										+ " para el cliente: "
										// +
										// solicitudesSACGPeticion.getSolicitudSACGIntegrantes().get(i).getCodigoT24().trim()
										+ solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getNombreCompleto();
							}
						}
					}
				}

				if (!mensajeValidaSaldoRenFin.equals("")) {
					throw new Exception(mensajeValidaSaldoRenFin);
				}
				// *** Fin Validacion saldos por integrantes renovacion
				// financiada

				// ::::::::::::::::::::::::::::::::::::::::::::::::::::: grupo
				// ::::::::::::::::::::::::::::::

				// Obtener el numero persona de Grupo. IN: clave_finsol; OUT:
				// persona.
				String grupoPersona = null;
				if (solicitudesSACGPeticion.getSolicitudSACGGrupo().getCodigo() != null) {
					LogHandler.trace(uid, getClass(),
							"ProcGuardarCreditoTempTarea: - obtenerPersonaMin");
					LogHandler.info(uid, getClass(),
							"ProcGuardarCreditoTempTarea: - obtenerPersonaMin");
					grupoPersona = (String) sesionNTx.selectOne(
							"obtenerPersonaMin", solicitudesSACGPeticion
									.getSolicitudSACGGrupo().getCodigo());
				}

				if (grupoPersona == null) {
					final HashMap<String, String> id = grupo
							.obtenerIdentificador(uid);
					if (id.get("credprod") != null && id.get("t24") != null) {
						grupoOV.setIdentificador(id.get("credprod"));
						grupoOV.setClienteT24(id.get("t24"));
						grupoOV.setNombre(solicitudesSACGPeticion
								.getSolicitudSACGGrupo().getNombre());

						if (solicitudesSACGPeticion.getSolicitudSACGGrupo()
								.getFechaConformacion() != null) {
							grupoOV.setFecha_conformacion(solicitudesSACGPeticion
									.getSolicitudSACGGrupo()
									.getFechaConformacion());
						}

						if (solicitudesSACGPeticion.getSolicitudSACG()
								.getPersonaDomReunion() != null
								&& !solicitudesSACGPeticion.getSolicitudSACG()
										.getPersonaDomReunion()
										.equalsIgnoreCase("")) {

							final HashMap<String, Object> parametros = new HashMap<String, Object>();
							parametros.put("persona", solicitudesSACGPeticion
									.getSolicitudSACG().getPersonaDomReunion());
							HashMap<String, Object> datosExtraPersona = new HashMap<String, Object>();
							LogHandler
									.trace(uid, getClass(),
											"ProcGuardarCreditoTempTarea: consultarDatosExtraPersona");
							LogHandler
									.info(uid, getClass(),
											"ProcGuardarCreditoTempTarea: consultarDatosExtraPersona");
							datosExtraPersona = (HashMap<String, Object>) sesionNTx
									.selectOne("consultarDatosExtraPersona",
											parametros);
							if (datosExtraPersona != null) {
								domicilioOV = new DomicilioOV();
								domicilioOV.setCalle(datosExtraPersona.get(
										"calle").toString());
								domicilioOV.setColonia(datosExtraPersona.get(
										"colonia").toString());
								domicilioOV.setCp((Integer) datosExtraPersona
										.get("cp"));
								domicilioOV.setLocalidad(datosExtraPersona.get(
										"ciudad").toString());
								domicilioOV.setEntidad(datosExtraPersona.get(
										"entidad").toString());
								domicilioOV.setMunicipio(datosExtraPersona.get(
										"municipio").toString());
							}
						}
						if (domicilioOV == null) {
							domicilioOV = new DomicilioOV();
							domicilioOV.setCalle("");
							domicilioOV.setColonia("");
							domicilioOV.setCp(0);
							domicilioOV.setLocalidad("");
							domicilioOV.setEntidad("");
							domicilioOV.setMunicipio("");
						}
						// domicilioOV
						grupoOV.setDomicilio(domicilioOV);
						ResultadoOV resultado;
						resultado = grupo.registrar(uid, grupoOV);
						if (!resultado.isSuccess()) {
							throw new Exception(resultado.getCodigo());
						}
						grupoPersona = id.get("credprod");
					} else {
						throw new Exception(ERROR_INSERCION);
					}
				}

				// ::::::::::::::::::::::::::::::::::::::::::::::::::::::::
				// /grupo :::::::::::::::::::::::::::

				// :::::::::::::::::::::::::::::::::::::::::::::::::::::
				// solicitud :::::::::::::::::::::::::::

				SolicitudesOV solicitudesOV = new SolicitudesOV();

				solicitudesOV.setSolicitud(solicitudFolio);
				solicitudesOV.setOficina(solicitudesSACGPeticion
						.getSolicitudSACG().getSucursal());
				solicitudesOV.setTasa(solicitudesSACGPeticion
						.getSolicitudSACG().getTasa());
				solicitudesOV.setPlazo(solicitudesSACGPeticion
						.getSolicitudSACG().getPlazo());
				solicitudesOV.setEfectivoSolicitado(solicitudesSACGPeticion
						.getSolicitudSACG().getNuevoCreditoSolicitado());

				if (solicitudesSACGPeticion.getSolicitudSACG().getRenovacion()) {
					if (solicitudesSACGPeticion.getSolicitudSACG()
							.getRenovacionFinanciada()) {
						solicitudesOV
								.setCategoria(SOLICITUD_CATEGORIA_FINANCIADA);
					} else {
						solicitudesOV
								.setCategoria(SOLICITUD_CATEGORIA_ORDINARIA);
					}
				}

				solicitudesOV.setStatus(SOLICITUD_STATUS_APROBADO);
				solicitudesOV.setCliente(grupoPersona);
				solicitudesOV.setEtapa(solicitudesSACGPeticion
						.getSolicitudSACG().getVisualizaCec());

				if (solicitudesSACGPeticion.getSolicitudSACG().getCiclo() != null) {
					solicitudesOV.setCiclo(solicitudesSACGPeticion
							.getSolicitudSACG().getCiclo());
				} else {
					solicitudesOV.setCiclo(0);
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getContratoPrevio() != null) {
					// Obtener contrato de contrato_clave_finsol para contrato
					// anterior.
					LogHandler
							.trace(uid,
									getClass(),
									"ProcGuardarCreditoTempTarea.insert.solicitud.ContratoPrevio: - obtenerRelacionContrato");
					LogHandler
							.info(uid,
									getClass(),
									"ProcGuardarCreditoTempTarea.insert.solicitud.ContratoPrevio: - obtenerRelacionContrato");
					String contratoTmp = (String) sesionNTx.selectOne(
							"obtenerRelacionContrato", solicitudesSACGPeticion
									.getSolicitudSACG().getContratoPrevio());
					if (contratoTmp == null) {
						throw new Exception(
								ReadProperties.mensajes
										.getProp("ciof.contratoinvalido"));
					}
					solicitudesOV.setContratoAnt(contratoTmp);
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getDiaPago() != null) {
					solicitudesOV.setDiaPago(solicitudesSACGPeticion
							.getSolicitudSACG().getDiaPago());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getProducto() != null) {
					solicitudesOV.setCodigoProducto(solicitudesSACGPeticion
							.getSolicitudSACG().getProducto());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getFrecuenciaPago() != null) {
					solicitudesOV.setFrecuenciaPago(solicitudesSACGPeticion
							.getSolicitudSACG().getFrecuenciaPago());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getDiaReunion() != null) {
					solicitudesOV.setDiaReunion(solicitudesSACGPeticion
							.getSolicitudSACG().getDiaReunion());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getHoraReunion() != null) {
					solicitudesOV.setHoraReunion(solicitudesSACGPeticion
							.getSolicitudSACG().getHoraReunion());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getFechaSolicitud() != null) {
					solicitudesOV.setFechaCaptura(solicitudesSACGPeticion
							.getSolicitudSACG().getFechaSolicitud());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getFechaDesembolso() != null) {
					solicitudesOV.setFechaResolucion(solicitudesSACGPeticion
							.getSolicitudSACG().getFechaDesembolso());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getUsuarioRegistraSolicitud() != null) {
					solicitudesOV
							.setUsuarioRegistraSolicitud(solicitudesSACGPeticion
									.getSolicitudSACG()
									.getUsuarioRegistraSolicitud());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getHoraReunionFin() != null) {
					solicitudesOV.setHoraReunionFin(solicitudesSACGPeticion
							.getSolicitudSACG().getHoraReunionFin());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getPersonaDomReunion() != null) {
					solicitudesOV.setPersonaDomReunion(solicitudesSACGPeticion
							.getSolicitudSACG().getPersonaDomReunion());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getExcepcionGarantia() != null) {
					solicitudesOV.setExcepcionGarantia(solicitudesSACGPeticion
							.getSolicitudSACG().getExcepcionGarantia());
				}
				// AOC Se agrega entrarBuzon
				if (solicitudesSACGPeticion.getSolicitudSACG().getEntrarBuzon() != null) {
					solicitudesOV.setEntrarBuzon(solicitudesSACGPeticion
							.getSolicitudSACG().getEntrarBuzon());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getAutorizacionGarantia() != null) {
					solicitudesOV
							.setAutorizacionGarantia(solicitudesSACGPeticion
									.getSolicitudSACG()
									.getAutorizacionGarantia());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getUsuarioAutorizacion() != null) {
					solicitudesOV
							.setUsuarioAutorizacion(solicitudesSACGPeticion
									.getSolicitudSACG()
									.getUsuarioAutorizacion());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getFechaAutorizacion() != null) {
					solicitudesOV.setFechaAutorizacion(solicitudesSACGPeticion
							.getSolicitudSACG().getFechaAutorizacion());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getSeguro() != null) {
					solicitudesOV.setSeguro(solicitudesSACGPeticion
							.getSolicitudSACG().getSeguro());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getSeguro() == null) {
					solicitudesOV.setSeguro("N");
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getEstatus() != null) {
					solicitudesOV.setEstatus(solicitudesSACGPeticion
							.getSolicitudSACG().getEstatus());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getDesEstatus() != null) {
					solicitudesOV.setDescripcion(solicitudesSACGPeticion
							.getSolicitudSACG().getDesEstatus());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getFechaFin() != null) {
					solicitudesOV.setFechaFin(solicitudesSACGPeticion
							.getSolicitudSACG().getFechaFin());
				}

				if (solicitudesSACGPeticion.getSolicitudSACG().getCdgAsesor() != null) {
					solicitudesOV.setVendedor(solicitudesSACGPeticion
							.getSolicitudSACG().getCdgAsesor());
				} else {
					solicitudesOV.setVendedor(solicitudesSACGPeticion
							.getSolicitudSACGGrupo().getAnalista());
				}

				if (solicitudesSACGPeticion.getSolicitudSACG().getContratoLD() != null) {
					if (!solicitudesSACGPeticion.getSolicitudSACG()
							.getContratoLD().equalsIgnoreCase("")) {
						// Obtener contrato de contrato_clave_finsol
						LogHandler
								.trace(uid,
										getClass(),
										"ProcGuardarCreditoTempTarea.insert.solicitud.ContratoLD: - obtenerRelacionContrato");
						LogHandler
								.info(uid,
										getClass(),
										"ProcGuardarCreditoTempTarea.insert.solicitud.ContratoLD: - obtenerRelacionContrato");
						String contratoTmp = (String) sesionNTx.selectOne(
								"obtenerRelacionContrato",
								solicitudesSACGPeticion.getSolicitudSACG()
										.getContratoLD());
						if (contratoTmp == null) {
							throw new Exception(
									ReadProperties.mensajes
											.getProp("ciof.contratoinvalido"));
						}
						solicitudesOV.setContrato(contratoTmp);
					}
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getExpress() != null) {
					solicitudesOV.setExpress(solicitudesSACGPeticion
							.getSolicitudSACG().getExpress());
				} else {
					solicitudesOV.setExpress("N");
				}

				if (solicitudesSACGPeticion.getSolicitudSACG().getCampana() != null) {
					solicitudesOV.setCampana(solicitudesSACGPeticion
							.getSolicitudSACG().getCampana());
				}

				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getSenalamientoExcepcion() != null) {
					solicitudesOV
							.setSenalamientoExcepcion(solicitudesSACGPeticion
									.getSolicitudSACG()
									.getSenalamientoExcepcion());
				}

				// Deposito Garantia ***

				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getTraspasoGarantia() != null) {
					solicitudesOV.setTraspasoGarantia(solicitudesSACGPeticion
							.getSolicitudSACG().getTraspasoGarantia());
				} else {
					solicitudesOV.setTraspasoGarantia("N");
				}

				if (solicitudesSACGPeticion.getSolicitudSACG().getPctGarantia() != null) {
					solicitudesOV.setPctGarantia(solicitudesSACGPeticion
							.getSolicitudSACG().getPctGarantia());
				} else {
					solicitudesOV.setPctGarantia(0);
				}

				// MIMH 20150713
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getAplicarGarantia() == null) {
					solicitudesOV.setAplicarGarantia("N");
				} else {
					solicitudesOV.setAplicarGarantia(solicitudesSACGPeticion
							.getSolicitudSACG().getAplicarGarantia());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getAplicarGarantiaDesertor() == null) {
					solicitudesOV.setAplicarGarantiaDesertor("N");
				} else {
					solicitudesOV
							.setAplicarGarantiaDesertor(solicitudesSACGPeticion
									.getSolicitudSACG()
									.getAplicarGarantiaDesertor());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getJustificacionExc() == null) {
					solicitudesOV.setJustificacionExc("");
				} else {
					solicitudesOV.setJustificacionExc(solicitudesSACGPeticion
							.getSolicitudSACG().getJustificacionExc());
				}

				// Fin Deposito Garantia

				java.util.HashMap<String, Object> solicitudParametros = Funciones
						.objectToHashMapInsert(solicitudesOV);
				LogHandler.trace(uid, getClass(),
						"ProcGuardarCreditoTempTarea: - insertaSolicitud");
				LogHandler.info(uid, getClass(),
						"ProcGuardarCreditoTempTarea: - insertaSolicitud");
				registrosAfectados = sesionTx.insert("insertaSolicitud",
						solicitudParametros);
				LogHandler.info(uid, getClass(),
						"ProcGuardarCreditoTempTarea: - registrosAfectados: "
								+ registrosAfectados);
				if (registrosAfectados == 0) {
					throw new Exception(ERROR_INSERCION);
				}

				// :::::::::::::::::::::::::::::::::::::::::::::::::::::
				// /solicitud :::::::::::::::::::::::::::::::::::::::::::

				// :::::::::::::::::::::::::::::::::::::::::::::::::::::
				// integrantes ::::::::::::::::::::::::::::::::::::::::::

				if (solicitudesSACGPeticion.getSolicitudSACGIntegrantes() != null) {
					for (int i = 0; i < solicitudesSACGPeticion
							.getSolicitudSACGIntegrantes().size(); i++) {
						if (solicitudesSACGPeticion
								.getSolicitudSACGIntegrantes().get(i)
								.getStatus() == null) {

							validaStr = Validaciones.datosRequeridos(
									solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes().get(
													i),
									integranteDatosRequeridos);
							if (!validaStr.equalsIgnoreCase("")) {
								throw new Exception(DATOS_REQUERIDOS
										+ validaStr);
							}

							java.util.HashMap<String, Object> integranteParametros = null;
							SolicitudIntegrantesOV solicitudIntegrantesOV = new SolicitudIntegrantesOV();
							solicitudIntegrantesOV.setSolicitud(solicitudFolio);

							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getCodigoPocg() == null
									|| solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getCodigoPocg()
											.equalsIgnoreCase("")) {
								// Realizar consulta con CODIGO_T24
								LogHandler
										.trace(uid, getClass(),
												"ProcGuardarCreditoTempTarea: - buscarClavePersonaSolicitud");
								LogHandler
										.info(uid, getClass(),
												"ProcGuardarCreditoTempTarea: - buscarClavePersonaSolicitud");
								solicitudIntegrantesOV
										.setCliente((String) sesionTx
												.selectOne(
														"buscarClavePersonaSolicitud",
														solicitudesSACGPeticion
																.getSolicitudSACGIntegrantes()
																.get(i)
																.getCodigoT24()));
							} else {
								solicitudIntegrantesOV
										.setCliente(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getCodigoPocg());
							}

							if (solicitudIntegrantesOV.getCliente()
									.equalsIgnoreCase(cargoPresidente)) {
								solicitudIntegrantesOV
										.setCargoMesaDirectiva(ID_PRESIDENTE);
							} else if (solicitudIntegrantesOV.getCliente()
									.equalsIgnoreCase(cargoSecretario)) {
								solicitudIntegrantesOV
										.setCargoMesaDirectiva(ID_SECRETARIO);
							} else if (solicitudIntegrantesOV.getCliente()
									.equalsIgnoreCase(cargoSupervisor)) {
								solicitudIntegrantesOV
										.setCargoMesaDirectiva(ID_SUPERVISOR);
							} else if (solicitudIntegrantesOV.getCliente()
									.equalsIgnoreCase(cargoTesorero)) {
								solicitudIntegrantesOV
										.setCargoMesaDirectiva(ID_TESORERO);
							}

							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getUltimoCreditoAprobado() != null) {
								solicitudIntegrantesOV
										.setMontoContratoAnterior(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i)
												.getUltimoCreditoAprobado());
							}

							// Monto Ahorro
							if (solicitudesSACGPeticion.getSolicitudSACG()
									.getProducto().trim()
									.equals(PRODUCTO_DG_SEMANAL)
									|| solicitudesSACGPeticion
											.getSolicitudSACG().getProducto()
											.trim()
											.equals(PRODUCTO_DG_CATORCENAL)) {

								if (solicitudesSACGPeticion.getSolicitudSACG()
										.getExpress().equals("S")) {

									solicitudesSACGPeticion
											.getSolicitudSACG()
											.setPctGarantia(
													solicitudesSACGPeticion
															.getSolicitudSACG()
															.getPctGarantia() != null ? solicitudesSACGPeticion
															.getSolicitudSACG()
															.getPctGarantia()
															: 0);

									Double montoAhorro = (solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getNuevoCreditoSolicitado() * solicitudesSACGPeticion
											.getSolicitudSACG()
											.getPctGarantia())
											/ Constantes.CENTENA_DOUBLE;

									// solicitudIntegrantesOV.setMontoAhorro(
									// solicitudesSACGPeticion.getSolicitudSACGIntegrantes().get(i).getAhorro()
									// != null
									// ?
									// solicitudesSACGPeticion.getSolicitudSACGIntegrantes().get(i).getAhorro()
									// : 0.0);

									solicitudIntegrantesOV
											.setMontoAhorro(montoAhorro);
								} else {

									solicitudesSACGPeticion
											.getSolicitudSACG()
											.setPctGarantia(
													solicitudesSACGPeticion
															.getSolicitudSACG()
															.getPctGarantia() != null ? solicitudesSACGPeticion
															.getSolicitudSACG()
															.getPctGarantia()
															: 0);
									Double montoAhorro = (solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getNuevoCreditoSolicitado() * solicitudesSACGPeticion
											.getSolicitudSACG()
											.getPctGarantia())
											/ Constantes.CENTENA_DOUBLE;

									solicitudIntegrantesOV
											.setMontoAhorro(montoAhorro);
								}

							} else {
								solicitudIntegrantesOV
										.setMontoAhorro(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getAhorro() != null ? solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getAhorro()
												: 0.0);
							}

							solicitudIntegrantesOV
									.setEfectivoSolicitado(solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getNuevoCreditoSolicitado());

							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getAhorro() != null) {
								solicitudIntegrantesOV
										.setMontoAhorro(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getAhorro());
							} else {
								solicitudIntegrantesOV.setMontoAhorro(0.0);
							}

							solicitudIntegrantesOV
									.setCodigoDestinoCredito(solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getPropositoPrestamo());
							solicitudIntegrantesOV
									.setAprobado(solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getAprobado());
							solicitudIntegrantesOV
									.setClasificacionFira(solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getTipoLocalidad());

							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getContratoPrevio() != null) {
								// Obtener contrato de contrato_clave_finsol
								// para contrato anterior de Integrante.
								LogHandler.trace(uid, getClass(),
										"ProcGuardarCreditoTempTarea.insert.integrante.ContratoPrevio:"
												+ " - obtenerRelacionContrato");
								LogHandler.info(uid, getClass(),
										"ProcGuardarCreditoTempTarea.insert.integrante.ContratoPrevio:"
												+ " - obtenerRelacionContrato");
								String contratoTmp = (String) sesionNTx
										.selectOne(
												"obtenerRelacionContrato",
												solicitudesSACGPeticion
														.getSolicitudSACGIntegrantes()
														.get(i)
														.getContratoPrevio());
								if (contratoTmp == null) {
									throw new Exception(
											ReadProperties.mensajes
													.getProp("ciof.contratoinvalido"));
								}
								solicitudIntegrantesOV
										.setContratoAnterior(contratoTmp);

							}

							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getSaldoActual() != null) {
								solicitudIntegrantesOV
										.setSaldoActual(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getSaldoActual());
							}

							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getConsultaBuro() != null) {
								solicitudIntegrantesOV
										.setReferencia(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getConsultaBuro());
							}

							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getSeguro() != null) {
								solicitudIntegrantesOV
										.setSeguro(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getSeguro());
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getSeguro() == null) {
								solicitudIntegrantesOV.setSeguro("N");
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getIguala() == null) {
								solicitudIntegrantesOV.setIguala("N");
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getCiclo() != null) {
								solicitudIntegrantesOV
										.setCiclo(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getCiclo());
							} else {
								solicitudIntegrantesOV.setCiclo(0);
							}

							// 20140911 Agregar plazo seguro
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getPlazoSeguro() == null) {
								solicitudIntegrantesOV.setPlazoSeguro("");
							} else {
								solicitudIntegrantesOV
										.setPlazoSeguro(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getPlazoSeguro());
							}

							// 20141010 Agregar seguro Enfermedad
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getSeguroEnfermedad() == null) {
								solicitudIntegrantesOV.setSeguroEnfermedad("");
							} else {
								solicitudIntegrantesOV
										.setSeguroEnfermedad(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getSeguroEnfermedad());
							}

							// Se agrega desertor
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getDesertor() == null) {
								solicitudIntegrantesOV.setDesertor("N");
							} else {
								solicitudIntegrantesOV
										.setDesertor(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getDesertor());

								if (solicitudIntegrantesOV.getDesertor()
										.equals("S")) {
									solicitudIntegrantesOV.setStatus("X");
								}
							}

							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getPerteneceCreditoRenovar() == null) {
								solicitudIntegrantesOV
										.setPerteneceCreditoRenovar("N");
							} else {
								solicitudIntegrantesOV
										.setPerteneceCreditoRenovar(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i)
												.getPerteneceCreditoRenovar());
							}

							// 20150721 garantia aplicar por desertor
							solicitudIntegrantesOV
									.setGarantiaAplicada(solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getGarantiaAplicada());

							solicitudIntegrantesOV
									.setDiferenciaPago(solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getDiferenciaPago());

							solicitudIntegrantesOV
									.setTipoDisposicion(INTEGRANTE_TDISP_CHEQUE);
							solicitudIntegrantesOV
									.setStatus(INTEGRANTE_STATUS_ACTIVO);
							LogHandler
									.trace(uid, getClass(),
											"ProcGuardarCreditoTempTarea: - obtenerNumeroIntegrante");
							LogHandler
									.info(uid, getClass(),
											"ProcGuardarCreditoTempTarea: - obtenerNumeroIntegrante");
							final Integer integranteNumeroQuery = (Integer) sesionTx
									.selectOne("obtenerNumeroIntegrante",
											solicitudFolio);
							if (integranteNumeroQuery == null) {
								throw new Exception(INTEGRANTE_ERROR_NUMERO);
							}
							solicitudIntegrantesOV
									.setNumeroIntegrante(integranteNumeroQuery);
							integranteParametros = Funciones
									.objectToHashMapInsert(solicitudIntegrantesOV);

							// Busca si el integrante ya esta insertado o
							// eliminado.
							java.util.HashMap<String, Object> integranteBuscaParametros = new java.util.HashMap<String, Object>();
							integranteBuscaParametros.put("solicitud",
									solicitudesOV.getSolicitud());
							integranteBuscaParametros.put("cliente",
									solicitudIntegrantesOV.getCliente());
							LogHandler
									.trace(uid, getClass(),
											"ProcGuardarCreditoTempTarea: - buscaIntegranteStatusSolicitud");
							LogHandler
									.info(uid, getClass(),
											"ProcGuardarCreditoTempTarea: - buscaIntegranteStatusSolicitud");
							java.util.HashMap<String, Object> clienteEliminadoQuery = (java.util.HashMap<String, Object>) sesionTx
									.selectOne(
											"buscaIntegranteStatusSolicitud",
											integranteBuscaParametros);
							if (clienteEliminadoQuery != null) {
								if (clienteEliminadoQuery.get("status").equals(
										"X")) {
									throw new Exception(
											INTEGRANTE_INSERT_DUPLICIDAD_E);
								} else {
									throw new Exception(
											INTEGRANTE_INSERT_DUPLICIDAD);
								}

							}

							LogHandler.trace(
									uid,
									getClass(),
									"ProcGuardarCreditoTempTarea: - insertaSolicitudIntegrante.cliente: "
											+ solicitudIntegrantesOV
													.getCliente());
							LogHandler.info(
									uid,
									getClass(),
									"ProcGuardarCreditoTempTarea: - insertaSolicitudIntegrante.cliente: "
											+ solicitudIntegrantesOV
													.getCliente());
							registrosAfectados = sesionTx.insert(
									"insertaSolicitudIntegrante",
									integranteParametros);
							LogHandler.info(uid, getClass(),
									"ProcGuardarCreditoTempTarea: - registrosAfectados: "
											+ registrosAfectados);
							if (registrosAfectados == 0) {
								throw new Exception(ERROR_INSERCION);
							}
						}
					}
				}
				// :::::::::::::::::::::::::::::::::::::::::::::::::::::
				// /integrantes ::::::::::::::::::::::::::::

			}
			// UPDATE Solictud.
			else {
				mensaje = SOLICITUD_ACTUALIZADA;

				// *** Validacion saldos por integrantes renovacion financiada
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getRenovacionFinanciada()
						&& solicitudesSACGPeticion.getSolicitudSACG()
								.getContratoPrevio() != null
						&& !solicitudesSACGPeticion.getSolicitudSACG()
								.getContratoPrevio().trim().equals("")) {

					for (int i = 0; i < solicitudesSACGPeticion
							.getSolicitudSACGIntegrantes().size(); i++) {
						if (solicitudesSACGPeticion
								.getSolicitudSACGIntegrantes().get(i)
								.getNuevoCreditoSolicitado() > 0) {
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getSaldoActual() > solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getNuevoCreditoSolicitado()
									&& !solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getDesertor().equals("S")) {
								mensajeValidaSaldoRenFin = "El saldo actual "
										+ solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getSaldoActual()
										+ " es mayor al monto solicitado "
										+ solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i)
												.getNuevoCreditoSolicitado()
										+ " para el cliente: "
										// +
										// solicitudesSACGPeticion.getSolicitudSACGIntegrantes().get(i).getCodigoT24().trim()
										+ solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getNombreCompleto();
							}
						}
					}

				}

				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getVisualizaCec().trim().equals("true")) {
					if (solicitudesSACGPeticion.getSolicitudSACG()
							.getRenovacionFinanciada()
							&& solicitudesSACGPeticion.getSolicitudSACG()
									.getContratoPrevio() != null
							&& !solicitudesSACGPeticion.getSolicitudSACG()
									.getContratoPrevio().trim().equals("")) {

						for (int i = 0; i < solicitudesSACGPeticion
								.getSolicitudSACGIntegrantes().size(); i++) {
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getSaldoActual() > solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getNuevoCreditoSolicitado()
									&& !solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getDesertor().equals("S")) {
								mensajeValidaSaldoRenFin = "El saldo actual "
										+ solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getSaldoActual()
										+ " es mayor al monto solicitado "
										+ solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i)
												.getNuevoCreditoSolicitado()
										+ " para el cliente: "
										// +
										// solicitudesSACGPeticion.getSolicitudSACGIntegrantes().get(i).getCodigoT24().trim()
										+ solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getNombreCompleto();
							}
						}
					}
				}

				if (!mensajeValidaSaldoRenFin.equals("")) {
					throw new Exception(mensajeValidaSaldoRenFin);
				}
				// *** Fin Validacion saldos por integrantes renovacion
				// financiada

				// :::::::::::::::::::::::::::::::::::::::::::::::::::::
				// solicitud :::::::::::::::::::::::::::::::

				solicitudFolio = solicitudesSACGPeticion.getSolicitudSACG()
						.getId();
				SolicitudesOV solicitudesOV = new SolicitudesOV();
				solicitudesOV.setSolicitud(solicitudFolio);
				if (solicitudesSACGPeticion.getSolicitudSACG().getSucursal() != null) {
					solicitudesOV.setOficina(solicitudesSACGPeticion
							.getSolicitudSACG().getSucursal());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getProducto() != null) {
					solicitudesOV.setCodigoProducto(solicitudesSACGPeticion
							.getSolicitudSACG().getProducto());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getTasa() != null) {
					solicitudesOV.setTasa(solicitudesSACGPeticion
							.getSolicitudSACG().getTasa());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getPlazo() != null) {
					solicitudesOV.setPlazo(solicitudesSACGPeticion
							.getSolicitudSACG().getPlazo());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getFrecuenciaPago() != null) {
					solicitudesOV.setFrecuenciaPago(solicitudesSACGPeticion
							.getSolicitudSACG().getFrecuenciaPago());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getDiaReunion() != null) {
					solicitudesOV.setDiaReunion(solicitudesSACGPeticion
							.getSolicitudSACG().getDiaReunion());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getHoraReunion() != null) {
					solicitudesOV.setHoraReunion(solicitudesSACGPeticion
							.getSolicitudSACG().getHoraReunion());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getNuevoCreditoSolicitado() != null) {
					solicitudesOV.setEfectivoSolicitado(solicitudesSACGPeticion
							.getSolicitudSACG().getNuevoCreditoSolicitado());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getFechaSolicitud() != null) {
					solicitudesOV.setFechaCaptura(solicitudesSACGPeticion
							.getSolicitudSACG().getFechaSolicitud());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getFechaDesembolso() != null) {
					solicitudesOV.setFechaResolucion(solicitudesSACGPeticion
							.getSolicitudSACG().getFechaDesembolso());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getCdgAsesor() != null) {
					solicitudesOV.setVendedor(solicitudesSACGPeticion
							.getSolicitudSACG().getCdgAsesor());
				} else if (solicitudesSACGPeticion.getSolicitudSACGGrupo() != null
						&& solicitudesSACGPeticion.getSolicitudSACGGrupo()
								.getAnalista() != null) {
					solicitudesOV.setVendedor(solicitudesSACGPeticion
							.getSolicitudSACGGrupo().getAnalista());
				}

				if (solicitudesSACGPeticion.getSolicitudSACG().getRenovacion() != null
						&& solicitudesSACGPeticion.getSolicitudSACG()
								.getRenovacion()) {
					if (solicitudesSACGPeticion.getSolicitudSACG()
							.getRenovacionFinanciada() != null
							&& solicitudesSACGPeticion.getSolicitudSACG()
									.getRenovacionFinanciada()) {
						solicitudesOV
								.setCategoria(SOLICITUD_CATEGORIA_FINANCIADA);
					} else {
						solicitudesOV
								.setCategoria(SOLICITUD_CATEGORIA_ORDINARIA);
					}
				}

				if (solicitudesSACGPeticion.getSolicitudSACG().getContratoLD() != null) {
					if (!solicitudesSACGPeticion.getSolicitudSACG()
							.getContratoLD().equalsIgnoreCase("")) {
						// Obtener contrato de contrato_clave_finsol
						LogHandler.trace(uid, getClass(),
								"ProcGuardarCreditoTempTarea.update.solicitud.ContratoLD:"
										+ " - obtenerRelacionContrato");
						LogHandler.info(uid, getClass(),
								"ProcGuardarCreditoTempTarea.update.solicitud.ContratoLD:"
										+ " - obtenerRelacionContrato");
						String contratoTmp = (String) sesionNTx.selectOne(
								"obtenerRelacionContrato",
								solicitudesSACGPeticion.getSolicitudSACG()
										.getContratoLD());
						if (contratoTmp == null) {
							throw new Exception(
									ReadProperties.mensajes
											.getProp("ciof.contratoinvalido"));
						}
						solicitudesOV.setContrato(contratoTmp);
						// Se envia fecha pero se usa el GETDATE() en consulta.
						solicitudesOV.setHoraResolucion(new Date());
					}
				}

				if (solicitudesSACGPeticion.getSolicitudSACG().getCiclo() != null) {
					solicitudesOV.setCiclo(solicitudesSACGPeticion
							.getSolicitudSACG().getCiclo());
				}

				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getVisualizaCec() != null) {
					solicitudesOV.setEtapa(solicitudesSACGPeticion
							.getSolicitudSACG().getVisualizaCec());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getContratoPrevio() != null) {
					if (!solicitudesSACGPeticion.getSolicitudSACG()
							.getContratoPrevio().equalsIgnoreCase("")) {
						// Obtener contrato de contrato_clave_finsol para
						// contrato anterior.
						LogHandler.trace(uid, getClass(),
								"ProcGuardarCreditoTempTarea.update.solicitud.ContratoPrevio:"
										+ " - obtenerRelacionContrato");
						LogHandler.info(uid, getClass(),
								"ProcGuardarCreditoTempTarea.update.solicitud.ContratoPrevio:"
										+ " - obtenerRelacionContrato");
						String contratoTmp = (String) sesionNTx.selectOne(
								"obtenerRelacionContrato",
								solicitudesSACGPeticion.getSolicitudSACG()
										.getContratoPrevio());
						if (contratoTmp == null) {
							throw new Exception(
									ReadProperties.mensajes
											.getProp("ciof.contratoinvalido"));
						}
						solicitudesOV.setContratoAnt(contratoTmp);
					}
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getDiaPago() != null) {
					solicitudesOV.setDiaPago(solicitudesSACGPeticion
							.getSolicitudSACG().getDiaPago());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getHoraReunionFin() != null) {
					solicitudesOV.setHoraReunionFin(solicitudesSACGPeticion
							.getSolicitudSACG().getHoraReunionFin());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getPersonaDomReunion() != null) {
					solicitudesOV.setPersonaDomReunion(solicitudesSACGPeticion
							.getSolicitudSACG().getPersonaDomReunion());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getUsuarioRegistraSolicitud() != null) {
					solicitudesOV
							.setUsuarioRegistraSolicitud(solicitudesSACGPeticion
									.getSolicitudSACG()
									.getUsuarioRegistraSolicitud());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getHoraReunionFin() != null) {
					solicitudesOV.setHoraReunionFin(solicitudesSACGPeticion
							.getSolicitudSACG().getHoraReunionFin());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getPersonaDomReunion() != null) {
					solicitudesOV.setPersonaDomReunion(solicitudesSACGPeticion
							.getSolicitudSACG().getPersonaDomReunion());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getExcepcionGarantia() != null) {
					solicitudesOV.setExcepcionGarantia(solicitudesSACGPeticion
							.getSolicitudSACG().getExcepcionGarantia());
				}
				// AOC Se agrega entrarBuzon
				if (solicitudesSACGPeticion.getSolicitudSACG().getEntrarBuzon() != null) {
					solicitudesOV.setEntrarBuzon(solicitudesSACGPeticion
							.getSolicitudSACG().getEntrarBuzon());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getAutorizacionGarantia() != null) {
					solicitudesOV
							.setAutorizacionGarantia(solicitudesSACGPeticion
									.getSolicitudSACG()
									.getAutorizacionGarantia());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getUsuarioAutorizacion() != null) {
					solicitudesOV
							.setUsuarioAutorizacion(solicitudesSACGPeticion
									.getSolicitudSACG()
									.getUsuarioAutorizacion());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getFechaAutorizacion() != null) {
					solicitudesOV.setFechaAutorizacion(solicitudesSACGPeticion
							.getSolicitudSACG().getFechaAutorizacion());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getSeguro() != null) {
					solicitudesOV.setSeguro(solicitudesSACGPeticion
							.getSolicitudSACG().getSeguro());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getEstatus() != null) {
					solicitudesOV.setEstatus(solicitudesSACGPeticion
							.getSolicitudSACG().getEstatus());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getDesEstatus() != null) {
					solicitudesOV.setDescripcion(solicitudesSACGPeticion
							.getSolicitudSACG().getDesEstatus());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getFechaFin() != null) {
					solicitudesOV.setFechaFin(solicitudesSACGPeticion
							.getSolicitudSACG().getFechaFin());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getExpress() != null) {
					solicitudesOV.setExpress(solicitudesSACGPeticion
							.getSolicitudSACG().getExpress());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getCampana() != null) {
					solicitudesOV.setCampana(solicitudesSACGPeticion
							.getSolicitudSACG().getCampana());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getSenalamientoExcepcion() != null) {
					solicitudesOV
							.setSenalamientoExcepcion(solicitudesSACGPeticion
									.getSolicitudSACG()
									.getSenalamientoExcepcion());
				}

				// Deposito Garantia ***

				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getTraspasoGarantia() != null) {
					solicitudesOV.setTraspasoGarantia(solicitudesSACGPeticion
							.getSolicitudSACG().getTraspasoGarantia());
				}

				if (solicitudesSACGPeticion.getSolicitudSACG().getPctGarantia() != null) {
					solicitudesOV.setPctGarantia(solicitudesSACGPeticion
							.getSolicitudSACG().getPctGarantia());
				} else {
					solicitudesOV.setPctGarantia(0);
				}

				// MIMH 20150713
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getAplicarGarantia() == null) {
					solicitudesOV.setAplicarGarantia("N");
				} else {
					solicitudesOV.setAplicarGarantia(solicitudesSACGPeticion
							.getSolicitudSACG().getAplicarGarantia());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getAplicarGarantiaDesertor() == null) {
					solicitudesOV.setAplicarGarantiaDesertor("N");
				} else {
					solicitudesOV
							.setAplicarGarantiaDesertor(solicitudesSACGPeticion
									.getSolicitudSACG()
									.getAplicarGarantiaDesertor());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getJustificacionExc() == null) {
					solicitudesOV.setJustificacionExc("");
				} else {
					solicitudesOV.setJustificacionExc(solicitudesSACGPeticion
							.getSolicitudSACG().getJustificacionExc());
				}

				// Fin Deposito Garantia

				String[] solicitudDatosRequeridos = { "solicitud" };
				validaStr = Validaciones.datosRequeridos(solicitudesOV,
						solicitudDatosRequeridos);
				if (!validaStr.equalsIgnoreCase("")) {
					throw new Exception(DATOS_REQUERIDOS + validaStr);
				}

				java.util.HashMap<String, Object> solicitudParametros = Funciones
						.objectToHashMapUpdate(solicitudesOV);
				LogHandler.trace(uid, getClass(),
						"ProcGuardarCreditoTempTarea: - actualizaSolicitud");
				LogHandler.info(uid, getClass(),
						"ProcGuardarCreditoTempTarea: - actualizaSolicitud");
				registrosAfectados = sesionTx.update("actualizaSolicitud",
						solicitudParametros);
				LogHandler.info(uid, getClass(),
						"ProcGuardarCreditoTempTarea: - registrosAfectados: "
								+ registrosAfectados);
				if (registrosAfectados == 0) {
					throw new Exception(ERROR_INSERCION);
				}

				solicitudesSACGPeticion.getSolicitudSACG().setVisualizaCec(
						solicitudesSACGPeticion.getSolicitudSACG()
								.getVisualizaCec() == null ? "false"
								: solicitudesSACGPeticion.getSolicitudSACG()
										.getVisualizaCec());
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getVisualizaCec().trim().equals("true")) {
					// Si tiene etapa = true, insertamos el envio_cec
					// Registrar ENVIO_CEC
					AtomosOV peticionAtomo = new AtomosOV();
					peticionAtomo.setSolicitud(solicitudesOV.getSolicitud());
					peticionAtomo.setProceso("ENVIO_CEC");
					peticionAtomo.setComentario("");
					peticionAtomo.setStatus("A");
					peticionAtomo.setUsuarioGeneroAtomo(solicitudesOV
							.getUsuarioRegistraSolicitud());

					AtomosRespuesta atomosRespuesta = registrarAtomosTarea(uid,
							sesionTx, peticionAtomo);

					if (!atomosRespuesta.getHeader().isEstatus()) {
						throw new Exception(atomosRespuesta.getHeader()
								.getMensaje());
					}
				}
				// :::::::::::::::::::::::::::::::::: /solicitud
				// ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
				// ::::::::::::::::::::::::::::::::::: grupo
				// :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getPersonaDomReunion() != null
						&& !solicitudesSACGPeticion.getSolicitudSACG()
								.getPersonaDomReunion().equalsIgnoreCase("")) {
					final HashMap<String, Object> parametros = new HashMap<String, Object>();
					parametros.put("persona", solicitudesSACGPeticion
							.getSolicitudSACG().getPersonaDomReunion());
					HashMap<String, Object> datosExtraPersona = new HashMap<String, Object>();
					LogHandler
							.trace(uid, getClass(),
									"ProcGuardarCreditoTempTarea: - consultarDatosExtraPersona");
					LogHandler
							.info(uid, getClass(),
									"ProcGuardarCreditoTempTarea: - consultarDatosExtraPersona");
					datosExtraPersona = (HashMap<String, Object>) sesionNTx
							.selectOne("consultarDatosExtraPersona", parametros);
					if (datosExtraPersona != null) {
						domicilioOV = new DomicilioOV();
						domicilioOV.setCalle(datosExtraPersona.get("calle")
								.toString());
						domicilioOV.setColonia(datosExtraPersona.get("colonia")
								.toString());
						domicilioOV
								.setCp((Integer) datosExtraPersona.get("cp"));
						domicilioOV.setLocalidad(datosExtraPersona
								.get("ciudad").toString());
						domicilioOV.setEntidad(datosExtraPersona.get("entidad")
								.toString());
						domicilioOV.setMunicipio(datosExtraPersona.get(
								"municipio").toString());
					}
					if (domicilioOV == null) {
						domicilioOV = new DomicilioOV();
						domicilioOV.setCalle("");
						domicilioOV.setColonia("");
						domicilioOV.setCp(0);
						domicilioOV.setLocalidad("");
						domicilioOV.setEntidad("");
						domicilioOV.setMunicipio("");
					}

					SolicitudesOV solicitudesOVTemp = new SolicitudesOV();
					LogHandler
							.trace(uid, getClass(),
									"ProcGuardarCreditoTempTarea: - consultaSolicitudTx");
					LogHandler
							.info(uid, getClass(),
									"ProcGuardarCreditoTempTarea: - consultaSolicitudTx");
					solicitudesOVTemp = (SolicitudesOV) sesionTx.selectOne(
							"consultaSolicitudTx", solicitudesSACGPeticion
									.getSolicitudSACG().getId());

					if (solicitudesOVTemp == null) {
						throw new Exception(SOLICITUD_NO_ENCONTRADA);
					}
					grupoOV.setIdentificador(solicitudesOVTemp.getCliente());
					grupoOV.setDomicilio(domicilioOV);
					ResultadoOV resultado;
					resultado = grupo.actualizarTx(uid, sesionTx, grupoOV);
					if (!resultado.isSuccess()) {
						throw new Exception(resultado.getCodigo());
					}
				}

				// :::::::::::::::::::::::::::::::::::: /grupo
				// :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
				// ::::::::::::::::::::::::::::::: integrantes
				// ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

				String[] integranteDatosRequeridosUpdate = { "solicitud",
						"cliente" };
				if (solicitudesSACGPeticion.getSolicitudSACGIntegrantes() != null) {
					// Elimina los cargos de los integrantes
					LogHandler
							.trace(uid, getClass(),
									"ProcGuardarCreditoTempTarea: - eliminaCargoIntegrantesSolicitud");
					LogHandler
							.info(uid, getClass(),
									"ProcGuardarCreditoTempTarea: - eliminaCargoIntegrantesSolicitud");
					sesionTx.update("eliminaCargoIntegrantesSolicitud",
							solicitudesOV.getSolicitud());

					for (int i = 0; i < solicitudesSACGPeticion
							.getSolicitudSACGIntegrantes().size(); i++) {
						java.util.HashMap<String, Object> integranteParametros = null;
						SolicitudIntegrantesOV solicitudIntegrantesOV = new SolicitudIntegrantesOV();
						solicitudIntegrantesOV.setSolicitud(solicitudFolio);

						if (solicitudesSACGPeticion
								.getSolicitudSACGIntegrantes().get(i)
								.getCodigoPocg() == null
								|| solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getCodigoPocg().equalsIgnoreCase("")) {
							// Realizar consulta con CODIGO_T24

							String clienteStr = "";
							LogHandler
									.trace(uid, getClass(),
											"ProcGuardarCreditoTempTarea: - buscarClavePersonaSolicitud");
							LogHandler
									.info(uid, getClass(),
											"ProcGuardarCreditoTempTarea: - buscarClavePersonaSolicitud");
							clienteStr = (String) sesionTx.selectOne(
									"buscarClavePersonaSolicitud",
									solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getCodigoT24());
							if (clienteStr == null) {
								LogHandler
										.info(uid,
												getClass(),
												"ProcGuardarCreditoTempTarea: No se obtubo la clave persona del"
														+ "cliente: "
														+ solicitudesSACGPeticion
																.getSolicitudSACGIntegrantes()
																.get(i)
																.getCodigoT24());
							}

							if (clienteStr != null
									|| !clienteStr.equalsIgnoreCase("")) {
								solicitudIntegrantesOV.setCliente(clienteStr);
							}
						} else {
							solicitudIntegrantesOV
									.setCliente(solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getCodigoPocg());
						}

						if (solicitudIntegrantesOV.getCliente()
								.equalsIgnoreCase(cargoPresidente)) {
							solicitudIntegrantesOV
									.setCargoMesaDirectiva(ID_PRESIDENTE);
						} else if (solicitudIntegrantesOV.getCliente()
								.equalsIgnoreCase(cargoSecretario)) {
							solicitudIntegrantesOV
									.setCargoMesaDirectiva(ID_SECRETARIO);
						} else if (solicitudIntegrantesOV.getCliente()
								.equalsIgnoreCase(cargoSupervisor)) {
							solicitudIntegrantesOV
									.setCargoMesaDirectiva(ID_SUPERVISOR);
						} else if (solicitudIntegrantesOV.getCliente()
								.equalsIgnoreCase(cargoTesorero)) {
							solicitudIntegrantesOV
									.setCargoMesaDirectiva(ID_TESORERO);
						} else {
							solicitudIntegrantesOV.setCargoMesaDirectiva("");
						}

						java.util.HashMap<String, Object> integranteBuscaParametros = new java.util.HashMap<String, Object>();
						integranteBuscaParametros.put("solicitud",
								solicitudesOV.getSolicitud());
						integranteBuscaParametros.put("cliente",
								solicitudIntegrantesOV.getCliente());

						LogHandler
								.trace(uid, getClass(),
										"ProcGuardarCreditoTempTarea: - buscaIntegranteSolicitud");
						LogHandler
								.info(uid, getClass(),
										"ProcGuardarCreditoTempTarea: - buscaIntegranteSolicitud");
						String clienteQuery = (String) sesionTx.selectOne(
								"buscaIntegranteSolicitud",
								integranteBuscaParametros);
						if (clienteQuery == null) {
							clienteQuery = "";
						} else {
							clienteQuery = clienteQuery.trim();
						}
						solicitudIntegrantesOV
								.setStatus(INTEGRANTE_STATUS_ACTIVO);

						// UPDATE Integrantes.
						if (solicitudIntegrantesOV.getCliente()
								.equalsIgnoreCase(clienteQuery)) {
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getUltimoCreditoAprobado() != null) {
								solicitudIntegrantesOV
										.setMontoContratoAnterior(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i)
												.getUltimoCreditoAprobado());
							}

							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getNuevoCreditoSolicitado() != null) {
								solicitudIntegrantesOV
										.setEfectivoSolicitado(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i)
												.getNuevoCreditoSolicitado());
							}

							// Monto Ahorro
							if (solicitudesSACGPeticion.getSolicitudSACG()
									.getProducto().trim()
									.equals(PRODUCTO_DG_SEMANAL)
									|| solicitudesSACGPeticion
											.getSolicitudSACG().getProducto()
											.trim()
											.equals(PRODUCTO_DG_CATORCENAL)) {
								Double montoAhorro = (solicitudIntegrantesOV
										.getEfectivoSolicitado() * solicitudesOV
										.getPctGarantia())
										/ Constantes.CENTENA_DOUBLE;
								solicitudIntegrantesOV
										.setMontoAhorro(montoAhorro);
							} else {
								solicitudIntegrantesOV
										.setMontoAhorro(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getAhorro() != null ? solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getAhorro()
												: 0.0);
							}

							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getPropositoPrestamo() != null) {
								solicitudIntegrantesOV
										.setCodigoDestinoCredito(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getPropositoPrestamo());
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getAprobado() != null) {
								solicitudIntegrantesOV
										.setAprobado(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getAprobado());
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getContratoPrevio() != null) {
								// Obtener contrato de contrato_clave_finsol
								// para contrato anterior de Integrante.
								LogHandler.trace(uid, getClass(),
										"ProcGuardarCreditoTempTarea.update.integrante.ContratoPrevio.update:"
												+ " - obtenerRelacionContrato");
								LogHandler.info(uid, getClass(),
										"ProcGuardarCreditoTempTarea.update.integrante.ContratoPrevio.update:"
												+ " - obtenerRelacionContrato");
								String contratoTmp = (String) sesionNTx
										.selectOne(
												"obtenerRelacionContrato",
												solicitudesSACGPeticion
														.getSolicitudSACGIntegrantes()
														.get(i)
														.getContratoPrevio());
								if (contratoTmp == null) {
									throw new Exception(
											ReadProperties.mensajes
													.getProp("ciof.contratoinvalido"));
								}
								solicitudIntegrantesOV
										.setContratoAnterior(contratoTmp);
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getSaldoActual() != null) {
								solicitudIntegrantesOV
										.setSaldoActual(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getSaldoActual());
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getTipoLocalidad() != null) {
								solicitudIntegrantesOV
										.setClasificacionFira(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getTipoLocalidad());
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getStatus() != null) {
								solicitudIntegrantesOV
										.setStatus(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getStatus());
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getConsultaBuro() != null) {
								solicitudIntegrantesOV
										.setReferencia(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getConsultaBuro());
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getSeguro() != null) {
								solicitudIntegrantesOV
										.setSeguro(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getSeguro());
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getIguala() != null) {
								solicitudIntegrantesOV
										.setIguala(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getIguala());
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getCiclo() != null) {
								solicitudIntegrantesOV
										.setCiclo(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getCiclo());
							}

							// 20140911 Agregar plazo seguro
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getPlazoSeguro() == null) {
								solicitudIntegrantesOV.setPlazoSeguro("");
							} else {
								solicitudIntegrantesOV
										.setPlazoSeguro(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getPlazoSeguro());
							}

							// 20141010 Agregar seguro enfermedad
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getSeguroEnfermedad() == null) {
								solicitudIntegrantesOV.setSeguroEnfermedad("");
							} else {
								solicitudIntegrantesOV
										.setSeguroEnfermedad(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getSeguroEnfermedad());
							}

							// Se agrega desertor
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getDesertor() == null) {
								solicitudIntegrantesOV.setDesertor("N");
							} else {
								solicitudIntegrantesOV
										.setDesertor(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getDesertor());

								if (solicitudIntegrantesOV.getDesertor()
										.equals("S")) {
									solicitudIntegrantesOV.setStatus("X");
								}
							}

							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getPerteneceCreditoRenovar() == null) {
								solicitudIntegrantesOV
										.setPerteneceCreditoRenovar("N");
							} else {
								solicitudIntegrantesOV
										.setPerteneceCreditoRenovar(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i)
												.getPerteneceCreditoRenovar());
							}

							// 20150721 garantia aplicar por desertor
							solicitudIntegrantesOV
									.setGarantiaAplicada(solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getGarantiaAplicada());

							solicitudIntegrantesOV
									.setDiferenciaPago(solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getDiferenciaPago());

							validaStr = Validaciones.datosRequeridos(
									solicitudIntegrantesOV,
									integranteDatosRequeridosUpdate);
							if (!validaStr.equalsIgnoreCase("")) {
								throw new Exception(DATOS_REQUERIDOS
										+ validaStr);
							}

							integranteParametros = Funciones
									.objectToHashMapUpdate(solicitudIntegrantesOV);
							LogHandler.trace(
									uid,
									getClass(),
									"ProcGuardarCreditoTempTarea: - actualizaSolicitudIntegrante.cliente: "
											+ solicitudIntegrantesOV
													.getCliente());
							LogHandler.info(
									uid,
									getClass(),
									"ProcGuardarCreditoTempTarea: - actualizaSolicitudIntegrante.cliente: "
											+ solicitudIntegrantesOV
													.getCliente());
							registrosAfectados = sesionTx.update(
									"actualizaSolicitudIntegrante",
									integranteParametros);
							LogHandler.info(uid, getClass(),
									"ProcGuardarCreditoTempTarea: - registrosAfectados: "
											+ registrosAfectados);
							if (registrosAfectados == 0) {
								throw new Exception(ERROR_ACTUALIZACION);
							}

						}
						// INSERT Integrantes.
						else {
							boolean integranteInsert = true;
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getStatus() != null) {
								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getStatus().equalsIgnoreCase("X")) {
									integranteInsert = false;
								}
							}

							if (integranteInsert) {
								// Busca si el integrante ya esta eliminado.
								LogHandler
										.trace(uid, getClass(),
												"ProcGuardarCreditoTempTarea: - buscaIntegranteStatusSolicitud");
								LogHandler
										.info(uid, getClass(),
												"ProcGuardarCreditoTempTarea: - buscaIntegranteStatusSolicitud");
								java.util.HashMap<String, Object> clienteEliminadoQuery = (java.util.HashMap<String, Object>) sesionTx
										.selectOne(
												"buscaIntegranteStatusSolicitud",
												integranteBuscaParametros);
								if (clienteEliminadoQuery != null) {
									if (clienteEliminadoQuery.get("status")
											.equals("X")) {
										throw new Exception(
												INTEGRANTE_INSERT_DUPLICIDAD_E);
									}
								}

								validaStr = Validaciones.datosRequeridos(
										solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i),
										integranteDatosRequeridos);
								if (!validaStr.equalsIgnoreCase("")) {
									throw new Exception(DATOS_REQUERIDOS
											+ validaStr);
								}

								solicitudIntegrantesOV
										.setEfectivoSolicitado(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i)
												.getNuevoCreditoSolicitado());

								// Monto Ahorro
								if (solicitudesSACGPeticion.getSolicitudSACG()
										.getProducto().trim()
										.equals(PRODUCTO_DG_SEMANAL)
										|| solicitudesSACGPeticion
												.getSolicitudSACG()
												.getProducto().trim()
												.equals(PRODUCTO_DG_CATORCENAL)) {
									Double montoAhorro = (solicitudIntegrantesOV
											.getEfectivoSolicitado() * solicitudesOV
											.getPctGarantia())
											/ Constantes.CENTENA_DOUBLE;
									solicitudIntegrantesOV
											.setMontoAhorro(montoAhorro);
								} else {
									solicitudIntegrantesOV
											.setMontoAhorro(solicitudesSACGPeticion
													.getSolicitudSACGIntegrantes()
													.get(i).getAhorro() != null ? solicitudesSACGPeticion
													.getSolicitudSACGIntegrantes()
													.get(i).getAhorro()
													: 0.0);
								}

								solicitudIntegrantesOV
										.setCodigoDestinoCredito(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getPropositoPrestamo());
								solicitudIntegrantesOV
										.setAprobado(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getAprobado());
								solicitudIntegrantesOV
										.setClasificacionFira(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getTipoLocalidad());
								solicitudIntegrantesOV
										.setTipoDisposicion(INTEGRANTE_TDISP_CHEQUE);

								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getUltimoCreditoAprobado() != null) {
									solicitudIntegrantesOV
											.setMontoContratoAnterior(solicitudesSACGPeticion
													.getSolicitudSACGIntegrantes()
													.get(i)
													.getUltimoCreditoAprobado());
								}
								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getContratoPrevio() != null) {
									// Obtener contrato de contrato_clave_finsol
									// para contrato anterior de Integrante.
									LogHandler
											.trace(uid,
													getClass(),
													"ProcGuardarCreditoTempTarea.update.integrante.ContratoPrevio.insert:"
															+ " - obtenerRelacionContrato");
									LogHandler
											.info(uid,
													getClass(),
													"ProcGuardarCreditoTempTarea.update.integrante.ContratoPrevio.insert:"
															+ " - obtenerRelacionContrato");
									String contratoTmp = (String) sesionNTx
											.selectOne(
													"obtenerRelacionContrato",
													solicitudesSACGPeticion
															.getSolicitudSACGIntegrantes()
															.get(i)
															.getContratoPrevio());
									if (contratoTmp == null) {
										throw new Exception(
												ReadProperties.mensajes
														.getProp("ciof.contratoinvalido"));
									}
									solicitudIntegrantesOV
											.setContratoAnterior(contratoTmp);
								}
								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getSaldoActual() != null) {
									solicitudIntegrantesOV
											.setSaldoActual(solicitudesSACGPeticion
													.getSolicitudSACGIntegrantes()
													.get(i).getSaldoActual());
								}
								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getConsultaBuro() != null) {
									solicitudIntegrantesOV
											.setReferencia(solicitudesSACGPeticion
													.getSolicitudSACGIntegrantes()
													.get(i).getConsultaBuro());
								}
								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getSeguro() != null) {
									solicitudIntegrantesOV
											.setSeguro(solicitudesSACGPeticion
													.getSolicitudSACGIntegrantes()
													.get(i).getSeguro());
								}
								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getSeguro() == null) {
									solicitudIntegrantesOV.setSeguro("N");
								}
								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getCiclo() != null) {
									solicitudIntegrantesOV
											.setCiclo(solicitudesSACGPeticion
													.getSolicitudSACGIntegrantes()
													.get(i).getCiclo());
								} else {
									solicitudIntegrantesOV.setCiclo(0);
								}

								// 20140911 Agregar plazo seguro
								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getPlazoSeguro() == null) {
									solicitudIntegrantesOV.setPlazoSeguro("");
								} else {
									solicitudIntegrantesOV
											.setPlazoSeguro(solicitudesSACGPeticion
													.getSolicitudSACGIntegrantes()
													.get(i).getPlazoSeguro());
								}

								// 20141010 Agregar seguro enfermedad
								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getSeguroEnfermedad() == null) {
									solicitudIntegrantesOV
											.setSeguroEnfermedad("");
								} else {
									solicitudIntegrantesOV
											.setSeguroEnfermedad(solicitudesSACGPeticion
													.getSolicitudSACGIntegrantes()
													.get(i)
													.getSeguroEnfermedad());
								}

								// Se agrega desertor
								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getDesertor() == null) {
									solicitudIntegrantesOV.setDesertor("N");
								} else {
									solicitudIntegrantesOV
											.setDesertor(solicitudesSACGPeticion
													.getSolicitudSACGIntegrantes()
													.get(i).getDesertor());

									if (solicitudIntegrantesOV.getDesertor()
											.equals("S")) {
										solicitudIntegrantesOV.setStatus("X");
									}
								}

								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getPerteneceCreditoRenovar() == null) {
									solicitudIntegrantesOV
											.setPerteneceCreditoRenovar("N");
								} else {
									solicitudIntegrantesOV
											.setPerteneceCreditoRenovar(solicitudesSACGPeticion
													.getSolicitudSACGIntegrantes()
													.get(i)
													.getPerteneceCreditoRenovar());
								}

								// 20150721 garantia aplicar por desertor
								solicitudIntegrantesOV
										.setGarantiaAplicada(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getGarantiaAplicada());

								solicitudIntegrantesOV
										.setDiferenciaPago(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getDiferenciaPago());

								LogHandler
										.trace(uid, getClass(),
												"ProcGuardarCreditoTempTarea: - obtenerNumeroIntegrante");
								LogHandler
										.info(uid, getClass(),
												"ProcGuardarCreditoTempTarea: - obtenerNumeroIntegrante");
								final Integer integranteNumeroQuery = (Integer) sesionTx
										.selectOne("obtenerNumeroIntegrante",
												solicitudFolio);
								if (integranteNumeroQuery == null) {
									throw new Exception(INTEGRANTE_ERROR_NUMERO);
								}
								solicitudIntegrantesOV
										.setNumeroIntegrante(integranteNumeroQuery);
								integranteParametros = Funciones
										.objectToHashMapInsert(solicitudIntegrantesOV);
								LogHandler.trace(
										uid,
										getClass(),
										"ProcGuardarCreditoTempTarea: - insertaSolicitudIntegrante.cliente: "
												+ solicitudIntegrantesOV
														.getCliente());
								LogHandler.info(
										uid,
										getClass(),
										"ProcGuardarCreditoTempTarea: - insertaSolicitudIntegrante.cliente: "
												+ solicitudIntegrantesOV
														.getCliente());
								registrosAfectados = sesionTx.insert(
										"insertaSolicitudIntegrante",
										integranteParametros);
								LogHandler.info(uid, getClass(),
										"ProcGuardarCreditoTempTarea: - registrosAfectados: "
												+ registrosAfectados);
								if (registrosAfectados == 0) {
									throw new Exception(ERROR_INSERCION);
								}
							}
						}
					} // for
				} // null
					// :::::::::::::::::::::::::::::::::::::::::::::::::::::
					// /integrantes ::::::::::::::::::::::::::::::::::::::::
			}

			SolicitudesOV solicitudesOVUpdateNumIntegrantes = new SolicitudesOV();
			solicitudesOVUpdateNumIntegrantes.setSolicitud(solicitudFolio);
			final java.lang.Integer numIntegrantes = (java.lang.Integer) sesionTx
					.selectOne("numeroIntegrantes", solicitudFolio);
			solicitudesOVUpdateNumIntegrantes
					.setNumeroIntegrantes(numIntegrantes);
			java.util.HashMap<String, Object> solicitudParametros = Funciones
					.objectToHashMapUpdate(solicitudesOVUpdateNumIntegrantes);

			LogHandler
					.trace(uid, getClass(),
							"ProcGuardarCreditoTempTarea: - actualizaSolicitud.numeroIntegrantes");
			LogHandler
					.info(uid, getClass(),
							"ProcGuardarCreditoTempTarea: - actualizaSolicitud.numeroIntegrantes");
			registrosAfectados = sesionTx.update("actualizaSolicitud",
					solicitudParametros);
			LogHandler.info(uid, getClass(),
					"ProcGuardarCreditoTempTarea: - registrosAfectados: "
							+ registrosAfectados);
			if (registrosAfectados == 0) {
				throw new Exception(ERROR_ACTUALIZACION);
			}

			// AOC validacion para Justificacion Garantia
			if (solicitudesSACGPeticion.getSolicitudSACG().getExpress() != null
					&& solicitudesSACGPeticion.getSolicitudSACG()
							.getEntrarBuzon() != null) {

				if (solicitudesSACGPeticion.getSolicitudSACG().getExpress()
						.equals("S")
						&& solicitudesSACGPeticion.getSolicitudSACG()
								.getExcepcionGarantia().equals("true")
						&& solicitudesSACGPeticion.getSolicitudSACG()
								.getEntrarBuzon().equals("S")) {

					// Validacion excepcion garantia
					Integer porcentajeMinimoGarantia = Integer
							.valueOf(comun
									.obtenerParGeneral(uid,
											"com.mx.finsol.originacion.pctgarantia.minima"));

					if (solicitudesSACGPeticion.getSolicitudSACG()
							.getPctGarantia() == null) {
						solicitudesSACGPeticion.getSolicitudSACG()
								.setPctGarantia(0);
					}

					// aqui en esta parte se genera la tarea de excepcion
					if (solicitudesSACGPeticion.getSolicitudSACG()
							.getPctGarantia().intValue() < porcentajeMinimoGarantia
							.intValue()
							&& solicitudesSACGPeticion.getSolicitudSACG()
									.getEntrarBuzon().equals("S")) {

						ExcepcionGarantiaPeticion peticionExc = new ExcepcionGarantiaPeticion();
						peticionExc.setTipoTarea("TOEG");
						peticionExc.setSucursal(String
								.valueOf(solicitudesSACGPeticion
										.getSolicitudSACG().getSucursal()));
						peticionExc.setDescripcion(solicitudesSACGPeticion
								.getSolicitudSACG().getId());
						peticionExc.setUsuarioAlta(solicitudesSACGPeticion
								.getSolicitudSACG()
								.getUsuarioRegistraSolicitud());
						peticionExc.setPerfil("PCOM");
						peticionExc.setStatus("P");
						peticionExc.setJustificacion(solicitudesSACGPeticion
								.getSolicitudSACG().getJustificacionExc());

						ExcepcionGarantiaRespuesta respuestaExc = generarTareaExcepcionGarantiaTarea(
								uid, peticionExc, sesionTx);

						if (!respuestaExc.getHeader().isEstatus()) {
							throw new Exception(
									"Ocurrio un error en generar tarea excepcion : "
											+ respuestaExc.getHeader()
													.getMensaje());
						}
					}
				}
			}

			sesionTx.commit(true);
			solicitudesRespuesta.setId(solicitudFolio);
			solicitudesRespuesta.getHeader().setMensaje(mensaje);

		} catch (Exception ex) {
			FabricaConexiones.rollBack(sesionTx);
			LogHandler.error(uid, getClass(), "ProcGuardarCreditoTempTarea: "
					+ ex.getMessage(), ex);
			solicitudesRespuesta.getHeader().setEstatus(false);
			solicitudesRespuesta.getHeader().setMensaje(ERROR_CONSULTA);

			if (ex.getMessage().indexOf("PK_solicitud_integrantes") != -1
					&& ex.getMessage().indexOf(
							"Attempt to insert duplicate key row") != -1) {
				solicitudesRespuesta.getHeader().setCodigo(
						INTEGRANTE_INSERT_DUPLICIDAD_E);
			} else {
				solicitudesRespuesta.getHeader().setCodigo(ex.getMessage());
			}
		} finally {
			FabricaConexiones.close(sesionTx);
			FabricaConexiones.close(sesionNTx);
		}

		return solicitudesRespuesta;
	}

	@SuppressWarnings({ "unchecked" })
	public SolicitudSACGGetRespuesta procGetSolicitudesTarea(String uid,
			SolicitudSACGGetPeticion solicitudSACGGetPeticion) {
		SolicitudSACGGetRespuesta solicitudSACGGetRespuesta = new SolicitudSACGGetRespuesta();
		solicitudSACGGetRespuesta.setHeader(new EncabezadoRespuesta());
		solicitudSACGGetRespuesta.getHeader().setUID(uid);
		solicitudSACGGetRespuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		List<SolicitudSACGGet> solicitudSACGGet = null;
		String validaStr = "";
		try {
			String[] datosRequeridos = { "pEstatus", "pSucursal" };

			validaStr = Validaciones.datosRequeridos(solicitudSACGGetPeticion,
					datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			if (!solicitudSACGGetPeticion.getpEstatus().equalsIgnoreCase(
					SOLICITUD_ESTATUS_AUTORIZADO)
					&& !solicitudSACGGetPeticion.getpEstatus()
							.equalsIgnoreCase(SOLICITUD_ESTATUS_REVISION)
					&& !solicitudSACGGetPeticion.getpEstatus()
							.equalsIgnoreCase(SOLICITUD_ESTATUS_CAPTURA)
					&& !solicitudSACGGetPeticion.getpEstatus()
							.equalsIgnoreCase(SOLICITUD_ESTATUS_TODOS)) {
				throw new Exception(SOLICITUD_ESTATUS_NO_VALIDO);
			}

			Integer sucursalTmp = null;
			java.util.HashMap<String, Object> solicitudParametros = new java.util.HashMap<String, Object>();
			if (!solicitudSACGGetPeticion.getpSucursal().equalsIgnoreCase(
					SOLICITUD_ESTATUS_TODOS)) {
				try {
					sucursalTmp = Integer.parseInt(solicitudSACGGetPeticion
							.getpSucursal());
				} catch (NumberFormatException e) {
					sucursalTmp = null;
				}
				solicitudParametros.put("pSucursalInt", sucursalTmp);
			}

			if (!solicitudSACGGetPeticion.getpSucursal().equalsIgnoreCase(
					SOLICITUD_ESTATUS_TODOS)
					&& sucursalTmp == null) {
				throw new Exception(SOLICITUD_SUCURSAL_NO_VALIDA);
			}

			// Se abre la sesion No transaccional sybase
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			if (solicitudSACGGetPeticion.getpEstatus().equalsIgnoreCase(
					SOLICITUD_ESTATUS_AUTORIZADO)
					|| solicitudSACGGetPeticion.getpEstatus().equalsIgnoreCase(
							SOLICITUD_ESTATUS_TODOS)) {
				LogHandler.trace(uid, getClass(),
						"ProcGetSolicitudesTarea: - consultaPrGetFecha");
				LogHandler.info(uid, getClass(),
						"ProcGetSolicitudesTarea: - consultaPrGetFecha");
				Date fechaContable = (Date) sesionNTx
						.selectOne("consultaPrGetFecha");
				if (fechaContable == null) {
					throw new Exception(CONSULTA_SIN_REGISTROS);
				}
				LogHandler.info(uid, getClass(),
						"ProcGetSolicitudesTarea: fechaContable: "
								+ fechaContable);
				solicitudParametros.put("fechaContable", fechaContable);
			}
			solicitudParametros.put("pEstatus",
					solicitudSACGGetPeticion.getpEstatus());
			solicitudParametros.put("pSucursal",
					solicitudSACGGetPeticion.getpSucursal());

			LogHandler.trace(uid, getClass(),
					"ProcGetSolicitudesTarea: consultaProcGetSolicitudes");
			LogHandler.info(uid, getClass(),
					"ProcGetSolicitudesTarea: consultaProcGetSolicitudes");
			solicitudSACGGet = (List<SolicitudSACGGet>) sesionNTx.selectList(
					"consultaProcGetSolicitudes", solicitudParametros);

			if (solicitudSACGGet.isEmpty()) {
				throw new Exception(CONSULTA_SIN_REGISTROS);
			}
			solicitudSACGGetRespuesta.setSolicitudes(solicitudSACGGet);
		} catch (Exception ex) {
			LogHandler.error(uid, getClass(),
					"ProcGetSolicitudesTarea: " + ex.getMessage(), ex);
			solicitudSACGGetRespuesta.getHeader().setEstatus(false);
			solicitudSACGGetRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			solicitudSACGGetRespuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return solicitudSACGGetRespuesta;
	}

	@SuppressWarnings("unchecked")
	public SolicitudSACGRespuesta procCreditoSolicitudTarea(String uid,
			SolicitudesPeticion solicitudesPeticion) {
		SolicitudSACGRespuesta solicitudSACGRespuesta = new SolicitudSACGRespuesta();
		solicitudSACGRespuesta.setHeader(new EncabezadoRespuesta());
		solicitudSACGRespuesta.getHeader().setUID(uid);
		solicitudSACGRespuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		SolicitudSACG solicitudSACG = null;
		SolicitudSACGGrupo solicitudSACGGrupo = null;
		List<SolicitudSACGIntegrante> solicitudSACGIntegrante = new ArrayList<SolicitudSACGIntegrante>();
		String validaStr = "";
		try {
			String[] datosRequeridos = { "solicitudId" };
			validaStr = Validaciones.datosRequeridos(solicitudesPeticion,
					datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			// Se abre la sesion No transaccional sybase
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler
					.trace(uid, getClass(),
							"ProcCreditoSolicitudTarea: - consultaProcCreditoSolicitud");
			LogHandler
					.info(uid, getClass(),
							"ProcCreditoSolicitudTarea: - consultaProcCreditoSolicitud");
			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("solicitud", solicitudesPeticion.getSolicitudId());
			parametros.put("producto", solicitudesPeticion.getProducto());
			solicitudSACG = (SolicitudSACG) sesionNTx.selectOne(
					"consultaProcCreditoSolicitud", parametros);
			if (solicitudSACG == null) {
				throw new Exception(CONSULTA_SIN_REGISTROS);
			}

			// se recupera si existe una tarea pendiente TRED
			tareasPendientes(uid, solicitudSACG, Constantes.TAREA_DOCUMENTAL);
			LogHandler.info(uid, this.getClass(),
					"obtenerTareasPendientesBuzon--tareaspendientes: "
							+ solicitudSACG.getTareaDocumentalPendiente());

			// se agrega el estatus del atomo de laexcepcion de cupos y montos
			String resolucionCupoMonto = (String) sesionNTx.selectOne(
					"obtenerStatusExceptionMonto",
					solicitudesPeticion.getSolicitudId());

			if (resolucionCupoMonto != null
					&& !resolucionCupoMonto.trim().isEmpty()) {
				solicitudSACG
						.setEstatusRestriccionCupoMonto(resolucionCupoMonto);
			} else {
				solicitudSACG.setEstatusRestriccionCupoMonto("");
			}
			if (solicitudSACG.getContratoPrevio() != null
					&& !solicitudSACG.getContratoPrevio().isEmpty()) {
				ConsultaCatalogoPeticionCIOF peticion = new ConsultaCatalogoPeticionCIOF();
				peticion.setContrato(solicitudSACG.getContratoPrevio());
				ConsultaCatalogoRespuestaCIOF diasAtraso = validacionContrato(
						uid, peticion);

				if (diasAtraso != null && diasAtraso.getDiasAtraso() > 0) {
					solicitudSACG.setDiasMora(diasAtraso.getDiasAtraso());
				} else {
					solicitudSACG.setDiasMora(0);
				}
			}

			LogHandler
					.trace(uid, getClass(),
							"ProcCreditoSolicitudTarea: - consultaProcCreditoSolicitudGrupo");
			LogHandler
					.info(uid, getClass(),
							"ProcCreditoSolicitudTarea: - consultaProcCreditoSolicitudGrupo");
			solicitudSACGGrupo = (SolicitudSACGGrupo) sesionNTx.selectOne(
					"consultaProcCreditoSolicitudGrupo",
					solicitudesPeticion.getSolicitudId());
			if (solicitudSACGGrupo == null) {
				throw new Exception(CONSULTA_SIN_REGISTROS);
			}
			LogHandler
					.trace(uid, getClass(),
							"ProcCreditoSolicitudTarea: - consultaProcCreditoSolicitudIntegrantes");
			LogHandler
					.info(uid, getClass(),
							"ProcCreditoSolicitudTarea: - consultaProcCreditoSolicitudIntegrantes");
			solicitudSACGIntegrante = (List<SolicitudSACGIntegrante>) sesionNTx
					.selectList("consultaProcCreditoSolicitudIntegrantes",
							solicitudesPeticion.getSolicitudId());

			if (solicitudSACG.getRenovacionFinanciada()) {
				LogHandler
						.trace(uid, getClass(),
								"ProcCreditoSolicitudTarea: - obtenerDesertoresFinanciada");
				LogHandler
						.info(uid, getClass(),
								"ProcCreditoSolicitudTarea: - obtenerDesertoresFinanciada");
				List<SolicitudSACGIntegrante> desertores = (List<SolicitudSACGIntegrante>) sesionNTx
						.selectList("obtenerDesertoresFinanciada",
								solicitudesPeticion.getSolicitudId());

				if (desertores == null) {
					throw new Exception(
							"Ocurrio un error al obtener los desertores");
				}

				if (desertores.size() > 0) {
					for (int i = 0; i < desertores.size(); i++) {
						solicitudSACGIntegrante.add(desertores.get(i));
					}
				}
			}

			for (SolicitudSACGIntegrante integrante : solicitudSACGIntegrante) {
				integrante.setCurp(integrante.getCurp().trim());
			}

			// Se agrega el saldoActual a Renovacion Financiada Exprees
			// ORIG-458 AOC
			if (solicitudSACG.getRenovacionFinanciada()
					&& solicitudSACG.getExpress().equals("S")) {

				DatosCreditoIntegrantesRespuesta respuestaIntegrantes = new DatosCreditoIntegrantesRespuesta();
				ConsultaCreditoPeticion peticionIntegrantes = new ConsultaCreditoPeticion();
				peticionIntegrantes.setContrato(solicitudSACG
						.getNumContratoPrevio());
				peticionIntegrantes.setSucursal(solicitudSACG.getSucursal());

				respuestaIntegrantes = consultas
						.obtenerDatosCreditoIntegrantes(uid,
								peticionIntegrantes);

				if (respuestaIntegrantes.getHeader().isEstatus()
						&& respuestaIntegrantes.getIntegrantes() != null
						&& respuestaIntegrantes.getIntegrantes().length > 0) {

					for (SolicitudSACGIntegrante integrante : solicitudSACGIntegrante) {
						for (DatosIntegranteResumenOV res : respuestaIntegrantes
								.getIntegrantes()) {
							if (integrante.getCodigoPocg().equals(
									res.getCliente())) {
								integrante.setSaldoActual(res
										.getSaldoLiquidar());
							}
						}
					}
				}
			}
			solicitudSACGRespuesta.setSolicitudSACG(solicitudSACG);
			solicitudSACGRespuesta.setSolicitudSACGGrupo(solicitudSACGGrupo);
			solicitudSACGRespuesta.setIntegrantes(solicitudSACGIntegrante);

			/*
			 * //Se agrega la lista de clientes con curp incorrecto
			 * List<SolicitudSACGIntegranteCurp> integrantesCurp = new
			 * ArrayList<SolicitudSACGIntegranteCurp>(); for (
			 * SolicitudSACGIntegrante integrante : solicitudSACGIntegrante ) {
			 * if (integrante.getCurp().trim().isEmpty()) {
			 * SolicitudSACGIntegranteCurp inte = new
			 * SolicitudSACGIntegranteCurp();
			 * inte.setPersona(integrante.getCodigoPocg());
			 * inte.setNombreCompleto(integrante.getNombreCompleto());
			 * integrantesCurp.add(inte); } }
			 * solicitudSACGRespuesta.setIntegrantesCurp(integrantesCurp);
			 */
		} catch (Exception ex) {
			LogHandler.error(uid, getClass(), "ProcCreditoSolicitudTarea: "
					+ ex.getMessage(), ex);
			solicitudSACGRespuesta.getHeader().setEstatus(false);
			solicitudSACGRespuesta.getHeader().setMensaje(ex.getMessage());
			solicitudSACGRespuesta.getHeader().setCodigo(ERROR_CONSULTA);
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return solicitudSACGRespuesta;
	}

	public SolicitudSACGRespuesta consultarSolicitudCreditoTarea(String uid,
			SolicitudesPeticion solicitudesPeticion) {
		SolicitudSACGRespuesta solicitudSACGRespuesta = new SolicitudSACGRespuesta();
		solicitudSACGRespuesta.setHeader(new EncabezadoRespuesta());
		solicitudSACGRespuesta.getHeader().setUID(uid);
		solicitudSACGRespuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		SolicitudSACG solicitudSACG = null;
		SolicitudSACGGrupo solicitudSACGGrupo = null;

		String validaStr = "";
		try {
			String[] datosRequeridos = { "solicitudId", "sucursal" };
			validaStr = Validaciones.datosRequeridos(solicitudesPeticion,
					datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			// Se abre la sesion No transaccional sybase
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler
					.trace(uid, getClass(),
							"consultarSolicitudCreditoTarea: - consultaProcCreditoSolicitud");
			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("solicitud", solicitudesPeticion.getSolicitudId());
			parametros.put("producto", " ");

			solicitudSACG = (SolicitudSACG) sesionNTx.selectOne(
					"consultaProcCreditoSolicitud", parametros);
			if (solicitudSACG == null) {
				throw new Exception(CONSULTA_SIN_REGISTROS);
			}

			if (!(solicitudesPeticion.getSucursal() == 0
					|| solicitudesPeticion.getSucursal() == 12
					|| solicitudesPeticion.getSucursal() == 12000 || solicitudesPeticion
						.getSucursal() == 120)) {

				if (solicitudesPeticion.getSucursal().intValue() != solicitudSACG
						.getSucursal().intValue()) {
					throw new Exception(
							ReadProperties.mensajes
									.getProp("solicitudes.scanner.solicitud.sucursal.mal"));
				}
			}

			LogHandler
					.trace(uid, getClass(),
							"consultarSolicitudCreditoTarea: - consultaProcCreditoSolicitudGrupo");
			solicitudSACGGrupo = (SolicitudSACGGrupo) sesionNTx.selectOne(
					"consultaProcCreditoSolicitudGrupo",
					solicitudesPeticion.getSolicitudId());
			if (solicitudSACGGrupo == null) {
				throw new Exception(CONSULTA_SIN_REGISTROS);
			}

			/*
			 * //Validacion del buro //Obtenemos valor dias validacion
			 * LogHandler.trace(uid, getClass(),
			 * "consultarSolicitudCreditoTarea: - obtenerParGeneral");
			 * ParGeneralOV parCiclo = (ParGeneralOV)
			 * sesionNTx.selectOne("obtenerParGeneral", "BURO_VALCI");
			 * 
			 * if (parCiclo == null) { throw new
			 * Exception(ReadProperties.mensajes.getProp(
			 * "solicitudes.scanner.sin.parametro.ciclo")); }
			 * 
			 * if (solicitudSACG.getCiclo() == null) { throw new
			 * Exception(ReadProperties.mensajes.getProp(
			 * "solicitudes.scanner.sin.ciclo")); } if (solicitudSACG.getCiclo()
			 * < Integer.parseInt(parCiclo.getCgValor()) &&
			 * solicitudSACG.getCategoriaProducto().trim().equals("COMN") ) {
			 * LogHandler.info(uid, getClass(),
			 * "consultarSolicitudCreditoTarea: - Necesita validacion Buro");
			 * //Necesita validacion al buro de credito LogHandler.trace(uid,
			 * getClass(), "consultarSolicitudCreditoTarea: - validacionBuro");
			 * String resultado = (String) sesionNTx.selectOne("validacionBuro",
			 * solicitudesPeticion.getSolicitudId());
			 * 
			 * if (resultado == null || resultado.trim().isEmpty()) { throw new
			 * Exception(ReadProperties.mensajes.getProp(
			 * "solicitudes.scanner.sin.validacion")); }
			 * 
			 * if (resultado.trim().equals("RECHAZADO")) { throw new
			 * Exception(ReadProperties.mensajes.getProp(
			 * "solicitudes.scanner.con.validacion.mal")); } }
			 * 
			 * //Validacion de verificacion telefonica //Obtenemos valor dias
			 * validacion LogHandler.trace(uid, getClass(),
			 * "consultarSolicitudCreditoTarea: - obtenerParGeneral");
			 * ParGeneralOV parCicloVerificacionTelefonica = (ParGeneralOV)
			 * sesionNTx.selectOne("obtenerParGeneral", "VETE_VALCI");
			 * 
			 * if (parCicloVerificacionTelefonica == null) { throw new
			 * Exception(ReadProperties.mensajes.getProp(
			 * "solicitudes.scanner.sin.parametro.ciclo.vt")); } if
			 * (solicitudSACG.getCiclo() <=
			 * Integer.parseInt(parCicloVerificacionTelefonica.getCgValor()) &&
			 * solicitudSACG.getCategoriaProducto().trim().equals("COMN") ) {
			 * LogHandler.info(uid, getClass(),
			 * "consultarSolicitudCreditoTarea: - Necesita verificacion Telefonica"
			 * ); //Necesita verificacion telefonica
			 * 
			 * LogHandler.trace(uid, getClass(),
			 * "consultarSolicitudCreditoTarea: - validacionBuro"); Integer
			 * resultado = (Integer)
			 * sesionNTx.selectOne("validacionVerificacionTelefonica",
			 * solicitudesPeticion.getSolicitudId());
			 * 
			 * if (resultado == null || resultado == 0) { throw new
			 * Exception(ReadProperties.mensajes.getProp(
			 * "solicitudes.scanner.sin.validacion.vt")); } }
			 */
			// Validamos que este capturada completamente
			ValidarSolicitudPeticion peticionValida = new ValidarSolicitudPeticion();
			peticionValida.setNumeroSolicitud(solicitudesPeticion
					.getSolicitudId());
			ValidarSolicitudRespuesta respuestaValidacion = validarDatosSolicitudTarea(
					uid, peticionValida);

			if (!respuestaValidacion.getHeader().isEstatus()) {
				throw new Exception(respuestaValidacion.getHeader()
						.getMensaje());
			}

			solicitudSACGRespuesta.setSolicitudSACG(solicitudSACG);
			solicitudSACGRespuesta.setSolicitudSACGGrupo(solicitudSACGGrupo);
			solicitudSACGRespuesta.setIntegrantes(null);

		} catch (Exception ex) {
			LogHandler.error(uid, getClass(), "ProcCreditoSolicitudTarea: "
					+ ex.getMessage(), ex);
			solicitudSACGRespuesta.getHeader().setEstatus(false);
			solicitudSACGRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			solicitudSACGRespuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return solicitudSACGRespuesta;
	}

	@SuppressWarnings("unchecked")
	public AccessPerfilRespuesta get_AccessPerfil_FUNTarea(String uid,
			AccessPerfilPeticion accessPerfilPeticion) {
		AccessPerfilRespuesta accessPerfilRespuesta = new AccessPerfilRespuesta();
		accessPerfilRespuesta.setHeader(new EncabezadoRespuesta());
		accessPerfilRespuesta.getHeader().setUID(uid);
		accessPerfilRespuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		List<Menu> menus = null;
		String validaStr = "";
		try {
			String[] datosRequeridos = { "idUsuario", "idAplicacion" };

			validaStr = Validaciones.datosRequeridos(accessPerfilPeticion,
					datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			// Se abre la sesion No transaccional sybase
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(),
					"Get_AccessPerfil_FUNTarea: - consultaGetAccessPerfilFUN");
			// LogHandler.info(uid, getClass(),
			// "Get_AccessPerfil_FUNTarea: - consultaGetAccessPerfilFUN");
			menus = (List<Menu>) sesionNTx.selectList(
					"consultaGetAccessPerfilFUN", accessPerfilPeticion);

			if (menus.isEmpty()) {
				throw new Exception(CONSULTA_SIN_REGISTROS);
			}
			accessPerfilRespuesta.setMenus(menus);
		} catch (Exception ex) {
			LogHandler.error(uid, getClass(), "Get_AccessPerfil_FUNTarea: "
					+ ex.getMessage(), ex);
			accessPerfilRespuesta.getHeader().setEstatus(false);
			accessPerfilRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			accessPerfilRespuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return accessPerfilRespuesta;
	}

	@SuppressWarnings("unchecked")
	public AccessPerfilRespuesta get_Submenus_FUNTarea(String uid,
			SubMenusPeticion subMenusPeticion) {
		AccessPerfilRespuesta accessPerfilRespuesta = new AccessPerfilRespuesta();
		accessPerfilRespuesta.setHeader(new EncabezadoRespuesta());
		accessPerfilRespuesta.getHeader().setUID(uid);
		accessPerfilRespuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		List<Menu> menus = null;
		String validaStr = "";
		try {
			String[] datosRequeridos = { "idPadre", "idPerfil", "idAplicacion" };

			validaStr = Validaciones.datosRequeridos(subMenusPeticion,
					datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			// Se abre la sesion No transaccional sybase
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(),
					"Get_Submenus_FUNTarea: - consultaGetSubmenusFUN");
			// LogHandler.info(uid, getClass(),
			// "Get_Submenus_FUNTarea: - consultaGetSubmenusFUN");
			menus = (List<Menu>) sesionNTx.selectList("consultaGetSubmenusFUN",
					subMenusPeticion);

			if (menus.isEmpty()) {
				throw new Exception(CONSULTA_SIN_REGISTROS);
			}
			accessPerfilRespuesta.setMenus(menus);
		} catch (Exception ex) {
			LogHandler.error(uid, getClass(),
					"Get_Submenus_FUNTarea: " + ex.getMessage(), ex);
			accessPerfilRespuesta.getHeader().setEstatus(false);
			accessPerfilRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			accessPerfilRespuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return accessPerfilRespuesta;
	}

	/**
	 * @param uid
	 *            String
	 * @param peticion
	 *            SolicitudBuroGeneralOV
	 * @return respuesta
	 */
	public SolicitudesRespuesta registrarSolicitudBuroGeneral(String uid,
			SolicitudBuroGeneralOV peticion) {
		SolicitudesRespuesta respuesta = new SolicitudesRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionTx = null;

		try {

			if (peticion.getSolicitud() == null) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.registrar.peticion.datos.incorrectos"));
			}

			sesionTx = FabricaConexiones.obtenerSesionTx();

			LogHandler
					.trace(uid, getClass(),
							"==> registrarSolicitudBuroGeneral - registrarSolicitudBuroGeneral");

			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("solicitud", peticion.getSolicitud());
			parametros.put(
					"valorTipificacion",
					peticion.getValorTipificacion() != null ? peticion
							.getValorTipificacion() : "");
			parametros.put(
					"promedioEdad",
					peticion.getPromedioEdad() != null ? peticion
							.getPromedioEdad() : 0.0);
			parametros.put(
					"porcentajeCuentas1",
					peticion.getPorcentajeCuentas1() != null ? peticion
							.getPorcentajeCuentas1() : 0.0);
			parametros.put(
					"porcentajeCuentas2",
					peticion.getPorcentajeCuentas2() != null ? peticion
							.getPorcentajeCuentas2() : 0.0);
			parametros.put("resultado",
					peticion.getResultado() != null ? peticion.getResultado()
							: "");
			sesionTx.insert("registrarSolicitudBuroGeneral", parametros);

			sesionTx.commit(true);

		} catch (Exception exception) {
			FabricaConexiones.rollBack(sesionTx);
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(exception.getMessage());
			respuesta.getHeader().setEstatus(false);
			LogHandler.error(
					uid,
					this.getClass(),
					"Error en registrarSolicitudBuroGeneral : "
							+ exception.getMessage(), exception);
		} finally {
			FabricaConexiones.close(sesionTx);
		}
		return respuesta;

	}

	@SuppressWarnings("unchecked")
	public ConsultaPoolPersonasRespuesta consultaPoolPersonasTarea(String uid,
			PoolPersonasOV peticion) {
		ConsultaPoolPersonasRespuesta respuesta = new ConsultaPoolPersonasRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);

		SqlSession sesion = null;
		try {
			sesion = FabricaConexiones.obtenerSesionNTx();

			// parametros de consulta
			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("poolPerfil",
					peticion == null || peticion.getPoolPerfil() == null
							|| peticion.getPoolPerfil().trim().isEmpty() ? null
							: peticion.getPoolPerfil());

			// Se obtiene la consulta consultarPoolPersonas
			LogHandler.info(uid, getClass(),
					"==> consultaPoolPersonasTarea - consultarPoolPersonas");
			LogHandler.trace(uid, getClass(),
					"==> consultaPoolPersonasTarea - consultarPoolPersonas");
			List<PoolPersonasOV> poolPersonas = sesion.selectList(
					"consultarPoolPersonas", parametros);

			if (poolPersonas.size() == 0) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.consulta.poolpersonas.inexistente"));
			}

			for (int i = 0; i < poolPersonas.size(); i++) {

				// Se obtiene la consulta consultarPoolPersonas
				LogHandler
						.info(uid, getClass(),
								"==> cargaTrabajoAnalistaTarea - obtenerPonderacionRemanente");
				LogHandler
						.trace(uid, getClass(),
								"==> cargaTrabajoAnalistaTarea - obtenerPonderacionRemanente");
				Double ponderacion = (Double) sesion.selectOne(
						"obtenerPonderacionRemanente", poolPersonas.get(i)
								.getPersona());

				if (ponderacion == null) {
					throw new Exception(
							ReadProperties.mensajes
									.getProp("solicitudes.solicitudes.consulta.poolpersonas.ponderacion"));
				}

				poolPersonas.get(i).setPonderacion(ponderacion);

				final java.util.HashMap<String, Object> parametrosAsignacion = new HashMap<String, Object>();
				parametrosAsignacion.put("persona", poolPersonas.get(i)
						.getPersona());
				parametrosAsignacion.put("diaAsignacion", 0);
				LogHandler
						.trace(uid, getClass(),
								"==> cargaTrabajoAnalistaTarea - obtenerPonderacionRemanente");
				PoolPersonasOV ponderacionDia = (PoolPersonasOV) sesion
						.selectOne("obtenerPonderacionPorDia",
								parametrosAsignacion);
				parametrosAsignacion.put("diaAsignacion", 1);
				PoolPersonasOV ponderacionDiaSiguiente = (PoolPersonasOV) sesion
						.selectOne("obtenerPonderacionPorDia",
								parametrosAsignacion);

				poolPersonas.get(i).setGruposDia(ponderacionDia.getGruposDia());
				poolPersonas.get(i).setPonderacionDia(
						ponderacionDia.getPonderacion());
				poolPersonas.get(i).setPonderacionDiaSiguiente(
						ponderacionDiaSiguiente.getPonderacion());
			}

			respuesta.getHeader().setMensaje(
					"La consulta se ha realizado con exito.");
			respuesta.setPoolPersonas(poolPersonas);

		} catch (Exception exception) {
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(exception.getMessage());
			respuesta.getHeader().setEstatus(false);
			LogHandler.error(
					uid,
					this.getClass(),
					"Error en consultaPoolPersonasTarea : "
							+ exception.getMessage(), exception);
		} finally {
			FabricaConexiones.close(sesion);
		}

		return respuesta;
	}

	/**
	 * @param uid
	 *            String
	 * @param persona
	 *            String
	 * @return ponderacion
	 */
	public Double consultarPonderacion(String uid, String persona) {
		SqlSession sesion = null;
		try {
			sesion = FabricaConexiones.obtenerSesionNTx();

			// Se obtiene la consulta consultarPoolPersonas
			LogHandler
					.info(uid, getClass(),
							"==> cargaTrabajoAnalistaTarea - obtenerPonderacionRemanente");
			LogHandler
					.trace(uid, getClass(),
							"==> cargaTrabajoAnalistaTarea - obtenerPonderacionRemanente");
			Double ponderacion = (Double) sesion.selectOne(
					"obtenerPonderacionRemanente", persona);

			if (ponderacion == null) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.solicitudes.consulta.poolpersonas.ponderacion"));
			}

			return ponderacion;
		} catch (Exception exception) {
			exception.getMessage();
			return null;
		} finally {
			FabricaConexiones.close(sesion);
		}

	}

	public ModificarPoolPersonasRespuesta modificarPoolPersonasTarea(
			String uid, ModificaPoolPersonasOV peticion) {
		ModificarPoolPersonasRespuesta respuesta = new ModificarPoolPersonasRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesion = null;
		SqlSession sesionTx = null;

		try {
			sesion = FabricaConexiones.obtenerSesionNTx();

			sesionTx = FabricaConexiones.obtenerSesionTx();

			if (peticion == null || peticion.getPersona() == null
					|| peticion.getEstatus() == null
					|| peticion.getUsuarioMod() == null
					|| peticion.getTipoPerfil() == null) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.modificar.poolpersonas.datos.incorrectos"));
			}

			LogHandler.info(uid, getClass(),
					"==> modificarPoolPersonasTarea - existePersonaPool");
			LogHandler.trace(uid, getClass(),
					"==> modificarPoolPersonasTarea - existePersonaPool ");
			String persona = (String) sesion.selectOne("existePersonaPool",
					peticion.getPersona());

			if (persona == null) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.modificar.poolpersonas.persona.inexistente"));
			}

			LogHandler.info(uid, getClass(),
					"==> modificarPoolPersonasTarea - modificaPoolPersonas");
			LogHandler.trace(uid, getClass(),
					"==> modificarPoolPersonasTarea - modificaPoolPersonas");

			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("persona", peticion.getPersona());
			parametros.put("tipoPerfil", peticion.getTipoPerfil());
			parametros.put("estatus", peticion.getEstatus());
			parametros.put("usuarioMod", peticion.getUsuarioMod());

			int regAfectados = sesionTx.update("modificaPoolPersonas",
					parametros);

			if (regAfectados != 0) {
				sesionTx.delete("eliminaEstatusAnalista", parametros);
			}

			if (regAfectados != 0) {
				regAfectados = sesionTx.insert("insertaEstatusAnalista",
						parametros);
			}

			if (regAfectados == 0) {
				throw new Exception("No se actualizó el analista");
			}

			sesionTx.commit(true);

			respuesta.getHeader().setMensaje(
					"Se ha modificado con exito la persona");

		} catch (Exception exception) {
			FabricaConexiones.rollBack(sesionTx);
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(exception.getMessage());
			respuesta.getHeader().setEstatus(false);
			LogHandler.error(
					uid,
					this.getClass(),
					"Error en modificarPoolPersonasTarea : "
							+ exception.getMessage(), exception);
		} finally {
			FabricaConexiones.close(sesion);
			FabricaConexiones.close(sesionTx);
		}
		return respuesta;
	}

	/**
	 * @param uid
	 *            identificador unico de la transaccion
	 * @param peticion
	 *            identificador unico de la transaccion
	 * @return respuesta
	 */
	public CargaTrabajoRespuesta cargaTrabajoAnalistaTarea(String uid,
			CargaTrabajoOV peticion) {
		CargaTrabajoRespuesta respuesta = new CargaTrabajoRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);

		SqlSession sesion = null;
		try {
			sesion = FabricaConexiones.obtenerSesionNTx();

			if (peticion == null || peticion.getPersona() == null) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.modificar.poolpersonas.datos.incorrectos"));
			}

			// parametros de consulta
			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("persona", peticion.getPersona());

			// Se obtiene la consulta consultarPoolPersonas
			LogHandler
					.info(uid, getClass(),
							"==> cargaTrabajoAnalistaTarea - obtenerCargaTrabajoPersona");
			LogHandler
					.trace(uid, getClass(),
							"==> cargaTrabajoAnalistaTarea - obtenerCargaTrabajoPersona");
			@SuppressWarnings("unchecked")
			List<CargaTrabajoOV> cargaTrabajo = sesion.selectList(
					"obtenerCargaTrabajoPersona", parametros);

			if (cargaTrabajo.size() == 0) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.consulta.poolpersonas.inexistente"));
			}

			for (CargaTrabajoOV ctrabajo : cargaTrabajo) {
				ctrabajo.setTipificacionProducto(FuncionesComunes.tipificacionProductos(
						ctrabajo.getCodigoProducto() == null ? "" : ctrabajo
								.getCodigoProducto(), ctrabajo.getCategoria()
								.trim().equals("FIN") ? true : false, ctrabajo
								.getExpress().trim().equals("S") ? true : false));
				ctrabajo.setNombreSucursal(ctrabajo.getNombreSucursal().trim());
			}

			respuesta.getHeader().setMensaje(
					"La consulta se ha realizado con exito.");
			respuesta.setCargaTrabajo(cargaTrabajo);

		} catch (Exception exception) {
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(exception.getMessage());
			respuesta.getHeader().setEstatus(false);
			LogHandler.error(
					uid,
					this.getClass(),
					"Error en cargaTrabajoAnalistaTarea : "
							+ exception.getMessage(), exception);
		} finally {
			FabricaConexiones.close(sesion);
		}

		return respuesta;
	}

	public ReasignarCargaTrabajoRespuesta reasignarCargaTrabajoAnalistaTarea(
			String uid, ReasignarCargaTrabajoPeticion peticion) {
		ReasignarCargaTrabajoRespuesta respuesta = new ReasignarCargaTrabajoRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionTx = null;

		try {

			sesionTx = FabricaConexiones.obtenerSesionTx();

			for (int i = 0; i < peticion.getReasignaciones().size(); i++) {

				if (peticion == null
						|| peticion.getReasignaciones().get(i)
								.getNuevoUsuarioProp() == null
						|| peticion.getReasignaciones().get(i).getIdTarea() == null) {
					throw new Exception(
							ReadProperties.mensajes
									.getProp("solicitudes.modificar.poolpersonas.datos.incorrectos"));
				}

				if (peticion.getReasignaciones().get(i).getUsuarioProp() == peticion
						.getReasignaciones().get(i).getNuevoUsuarioProp()) {
					throw new Exception(
							ReadProperties.mensajes
									.getProp("solicitudes.reasignar.carga.trabajo.mismo.propietario"));

				}
				final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
				parametros.put("nuevoPropietario", peticion.getReasignaciones()
						.get(i).getNuevoUsuarioProp());
				parametros.put("idTarea", peticion.getReasignaciones().get(i)
						.getIdTarea());

				LogHandler
						.info(uid, getClass(),
								"==> reasignarCargaTrabajoAnalistaTarea - reasignarCargaTrabajo");
				LogHandler
						.trace(uid, getClass(),
								"==> reasignarCargaTrabajoAnalistaTarea - reasignarCargaTrabajo");

				sesionTx.update("reasignarCargaTrabajo", parametros);

				final java.util.HashMap<String, Object> parametrosRegistrar = new HashMap<String, Object>();
				parametrosRegistrar.put("idTarea", peticion.getReasignaciones()
						.get(i).getIdTarea());
				parametrosRegistrar.put("usuarioProp", peticion
						.getReasignaciones().get(i).getUsuarioProp());
				parametrosRegistrar.put("nuevoUsuarioProp", peticion
						.getReasignaciones().get(i).getNuevoUsuarioProp());
				parametrosRegistrar.put("usuarioReasigna", peticion
						.getReasignaciones().get(i).getUsuarioReasigna());

				LogHandler
						.info(uid, getClass(),
								"==> reasignarCargaTrabajoAnalistaTarea - registrarBuzonTareaReasignacion");
				LogHandler
						.trace(uid, getClass(),
								"==> reasignarCargaTrabajoAnalistaTarea - registrarBuzonTareaReasignacion");

				sesionTx.insert("registrarBuzonTareaReasignacion",
						parametrosRegistrar);

			}

			sesionTx.commit(true);

			respuesta.getHeader().setMensaje(
					"Se ha modificado y agregado con exito la tarea");

		} catch (Exception exception) {
			FabricaConexiones.rollBack(sesionTx);
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(exception.getMessage());
			respuesta.getHeader().setEstatus(false);
			LogHandler.error(uid, this.getClass(),
					"Error en reasignarCargaTrabajoAnalistaTarea : "
							+ exception.getMessage(), exception);
		} finally {
			FabricaConexiones.close(sesionTx);
		}
		return respuesta;
	}

	public ConsultarAtomosRespuesta consultarAtomosTarea(String uid,
			AtomosOV peticion) {
		ConsultarAtomosRespuesta respuesta = new ConsultarAtomosRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);

		SqlSession sesion = null;

		try {
			sesion = FabricaConexiones.obtenerSesionNTx();

			if (peticion == null || peticion.getSolicitud() == null) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.peticion.datos.incorrectos"));
			}

			// parametros de consulta
			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("solicitud", peticion.getSolicitud());
			parametros.put("ordenar", peticion.getOrdenar());

			// Se obtiene la consulta consultarPoolPersonas
			LogHandler.info(uid, getClass(),
					"==> consultarAtomosTarea - obtenerAtomoSolicitud");
			LogHandler.trace(uid, getClass(),
					"==> consultarAtomosTarea - obtenerAtomoSolicitud");

			@SuppressWarnings("unchecked")
			List<AtomosOV> atomos = sesion.selectList("obtenerAtomoSolicitud",
					parametros);

			if (atomos.size() == 0) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.consulta.atomos"));
			}

			respuesta.getHeader().setMensaje(
					"La consulta se ha realizado con exito.");
			respuesta.setAtomos(atomos);

		} catch (Exception exception) {
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(exception.getMessage());
			respuesta.getHeader().setEstatus(false);
			LogHandler
					.error(uid,
							this.getClass(),
							"Error en consultarAtomosTarea : "
									+ exception.getMessage(), exception);
		} finally {
			FabricaConexiones.close(sesion);
		}

		return respuesta;
	}

	public StatusCreditoRespuesta consultarStatusCreditosTarea(String uid,
			StatusCreditoOV peticion) {
		StatusCreditoRespuesta respuesta = new StatusCreditoRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);

		SqlSession sesion = null;

		try {
			sesion = FabricaConexiones.obtenerSesionNTx();

			if (peticion == null) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.peticion.datos.incorrectos"));
			}

			// parametros de consulta
			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("solicitud", peticion.getSolicitud());
			parametros.put("sucursal", peticion.getSucursal());
			parametros.put("desde", peticion.getFechaCaptura());
			parametros.put("hasta", peticion.getFechaFin());
			parametros.put("estatus", peticion.getEstatus());
			parametros.put("region", peticion.getRegion());
			parametros.put("division", peticion.getDivision());

			// Se obtiene la consulta consultarPoolPersonas
			LogHandler.info(uid, getClass(),
					"==> consultarStatusCreditosTarea - obtenerStatusCredito");
			LogHandler.trace(uid, getClass(),
					"==> consultarStatusCreditosTarea - obtenerStatusCredito");

			@SuppressWarnings("unchecked")
			List<StatusCreditoOV> statusCreditos = sesion.selectList(
					"obtenerStatusCredito", parametros);

			if (statusCreditos.size() == 0) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.consulta.sin.resultados"));
			}

			for (StatusCreditoOV solicitud : statusCreditos) {
				solicitud
						.setTipificacionProducto(FuncionesComunes.tipificacionProductos(
								solicitud.getCodigoProducto() == null ? ""
										: solicitud.getCodigoProducto(),
								solicitud.getCategoria().trim().equals("FIN") ? true
										: false, solicitud.getExpress().trim()
										.equals("S") ? true : false));
				solicitud.setSolicitud(solicitud.getSolicitud().trim());

				final java.util.HashMap<String, Object> param = new HashMap<String, Object>();
				param.put("solicitud", solicitud.getSolicitud());
				LogHandler.trace(uid, getClass(),
						"==> - consultaClienteNuevoGrupo");

				List<Comentarios> integrantes = sesion.selectList(
						"ObtieneJustificacionPorSolicitud", param);

				if (integrantes.size() > 0) {
					int integrantesNuevos = 0;
					String persona = "";
					String analista = "";
					for (Comentarios integrante : integrantes) {
						if (integrante.getCliente() != null) {
							integrantesNuevos++;
							persona += integrante.getCliente() + ", ";
							analista = integrante.getUsuarioElimina();
						}
					}

					if (persona.endsWith(", ")) {
						int caracter = persona.lastIndexOf(", ");

						persona = persona.substring(0, caracter);
					}

					String respuestaCadena = "Total de Cliente Eliminados = "
							+ integrantesNuevos;
					respuestaCadena += ": " + persona;
					respuestaCadena += ": Analista: " + analista;

					solicitud.setMotivoJustificacion(solicitud
							.getMotivoJustificacion() + respuestaCadena);
				}
			}
			respuesta.getHeader().setMensaje(
					"La consulta se ha realizado con exito.");
			respuesta.setStatusCreditos(statusCreditos);

		} catch (Exception exception) {
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(exception.getMessage());
			respuesta.getHeader().setEstatus(false);
			LogHandler.error(
					uid,
					this.getClass(),
					"Error en consultarStatusCreditosTarea : "
							+ exception.getMessage(), exception);
		} finally {
			FabricaConexiones.close(sesion);
		}

		return respuesta;
	}

	public PlanillaObservacionesRespuesta consultarPlanillaObservacionesTarea(
			String uid, PlanillaObservacionesOV peticion) {
		PlanillaObservacionesRespuesta respuesta = new PlanillaObservacionesRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);

		SqlSession sesion = null;

		try {
			sesion = FabricaConexiones.obtenerSesionNTx();

			if (peticion == null || peticion.getSolicitud() == null) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.peticion.datos.incorrectos"));
			}

			LogHandler
					.trace(uid, getClass(),
							"consultarPlanillaObservacionesTarea: - consultaProcCreditoSolicitudTodas");
			SolicitudSACG solicitudSACG = (SolicitudSACG) sesion.selectOne(
					"consultaProcCreditoSolicitudTodas",
					peticion.getSolicitud());

			if (solicitudSACG == null) {
				throw new Exception(CONSULTA_SIN_REGISTROS);
			}

			if (solicitudSACG.getStatus().trim().equals("X")
					&& !peticion.isConsultaCanceladas()) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.consulta.solicitud.cancelada"));
			}

			// parametros de consulta
			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("solicitud", peticion.getSolicitud());
			parametros.put("soloMarcadas", peticion.isConsultaMarcadas());

			// Se obtiene la consulta consultarPoolPersonas
			LogHandler
					.info(uid, getClass(),
							"==> consultarPlanillaObservacionesTarea - obtenerPlanillaObservaciones");
			LogHandler
					.trace(uid, getClass(),
							"==> consultarPlanillaObservacionesTarea - obtenerPlanillaObservaciones");

			@SuppressWarnings("unchecked")
			List<PlanillaObservacionesOV> planillaObservaciones = sesion
					.selectList("obtenerPlanillaObservaciones", parametros);

			if (planillaObservaciones.size() == 0) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.consulta.sin.resultados"));
			}

			LogHandler
					.trace(uid, getClass(),
							"consultarPlanillaObservacionesTarea: - consultaProcCreditoSolicitudGrupo");
			SolicitudSACGGrupo solicitudSACGGrupo = (SolicitudSACGGrupo) sesion
					.selectOne("consultaProcCreditoSolicitudGrupo",
							peticion.getSolicitud());
			if (solicitudSACGGrupo == null) {
				throw new Exception(CONSULTA_SIN_REGISTROS);
			}

			// Validamos si tiene una tarea hija, es decir ya fue alguna vez a
			// sucursal
			Integer count = (Integer) sesion.selectOne(
					"validaExisteTareaSucursal", peticion.getSolicitud());

			if (count > 0) {
				solicitudSACG.setDesEstatus("PSUC");
			}

			respuesta.getHeader().setMensaje(
					"La consulta se ha realizado con exito.");
			respuesta.setPlanillaObservaciones(planillaObservaciones);
			respuesta.setSolicitudSACG(solicitudSACG);
			respuesta.setSolicitudSACGGrupo(solicitudSACGGrupo);
			// Thread.sleep(120000);
		} catch (Exception exception) {
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(exception.getMessage());
			respuesta.getHeader().setEstatus(false);
			LogHandler.error(uid, this.getClass(),
					"Error en consultarPlanillaObservacionesTarea : "
							+ exception.getMessage(), exception);
		} finally {
			FabricaConexiones.close(sesion);
		}
		return respuesta;
	}

	public PlanillaObservacionesRespuesta registrarPlanillaObservacionesTarea(
			String uid, PlanillaObservacionesPeticion peticion) {
		PlanillaObservacionesRespuesta respuesta = new PlanillaObservacionesRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionTx = null;
		SqlSession sesionNTx = null;

		try {

			if (peticion == null || peticion.getSolicitud() == null) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.modificar.poolpersonas.datos.incorrectos"));
			}

			if (peticion.getHistorico() == null) {
				peticion.setHistorico(false);
			}

			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			// Validamos si la solicitud sigue activa
			SolicitudSACG solicitudSACG = (SolicitudSACG) sesionNTx.selectOne(
					"consultaProcCreditoSolicitudTodas",
					peticion.getSolicitud());
			if (solicitudSACG.getStatus().trim().equals("X")) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.consulta.solicitud.cancelada"));
			}

			LogHandler
					.trace(uid, getClass(),
							"==> enviarPlanillaObservacionesSucursalTarea : validaTareaHijaUnica");
			Integer resValida = (Integer) sesionNTx.selectOne(
					"validaTareaHijaUnicaSlicitud", peticion.getSolicitud());

			if (resValida > 0) {
				throw new Exception(
						"La solicitud esta en revision en la sucursal, por comentarios en la planilla de observaciones.");
			}

			sesionTx = FabricaConexiones.obtenerSesionTx();

			if (!peticion.getPlanillaObservaciones().isEmpty()) {
				sesionTx.update("eliminaCamposPlanillaObservaciones",
						peticion.getSolicitud());
			} else {
				throw new Exception(
						"La peticion no tiene observaciones, es necesaria al menos una.");
			}

			for (int i = 0; i < peticion.getPlanillaObservaciones().size(); i++) {

				final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
				parametros.put("solicitud", peticion.getSolicitud());
				parametros.put("campoId", peticion.getPlanillaObservaciones()
						.get(i).getCampoId());
				parametros.put("valorBinario", peticion
						.getPlanillaObservaciones().get(i).getValorBinario());
				parametros
						.put("valorComentario", peticion
								.getPlanillaObservaciones().get(i)
								.getValorComentario());

				LogHandler
						.trace(uid, getClass(),
								"==> insertarPlanillaObservacionesTarea - insertarCamposPlanillaObservaciones");

				sesionTx.insert("insertarCamposPlanillaObservaciones",
						parametros);

			} // fin for

			if (peticion.getHistorico()) {

				final java.util.HashMap<String, Object> parametrosHis = new HashMap<String, Object>();
				parametrosHis.put("solicitud", peticion.getSolicitud());

				LogHandler
						.info(uid, getClass(),
								"==> insertarPlanillaObservacionesTarea - cargarPlanillaObservaciones");
				LogHandler
						.trace(uid, getClass(),
								"==> insertarPlanillaObservacionesTarea - cargarPlanillaObservaciones");

				sesionTx.insert("insertarPlanillaObservacionesHis",
						parametrosHis);

			}

			final java.util.HashMap<String, Object> parametrosActualizarTEC = new HashMap<String, Object>();
			parametrosActualizarTEC.put("solicitud", peticion.getSolicitud());
			parametrosActualizarTEC.put("usuario", peticion.getUsuario());

			LogHandler
					.info(uid, getClass(),
							"==> insertarPlanillaObservacionesTarea - actualizarTareasEvaluacionCreditos");
			LogHandler
					.trace(uid, getClass(),
							"==> insertarPlanillaObservacionesTarea - actualizarTareasEvaluacionCreditos");

			sesionTx.update("actualizarTareasEvaluacionCreditos",
					parametrosActualizarTEC);

			sesionTx.commit(true);

			respuesta.getHeader().setMensaje(
					"Se ha actualizado con exito la tarea");

		} catch (Exception exception) {
			if (sesionTx != null) {
				FabricaConexiones.rollBack(sesionTx);
			}
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(exception.getMessage());
			respuesta.getHeader().setEstatus(false);
			LogHandler.error(uid, this.getClass(),
					"Error en insertarPlanillaObservacionesTarea : "
							+ exception.getMessage(), exception);
		} finally {
			if (sesionTx != null) {
				FabricaConexiones.close(sesionTx);
			}
			FabricaConexiones.close(sesionNTx);

		}
		return respuesta;
	}

	public CancelarSolEvaCreRespuesta cancelarSolicitudEvaluacionCrediticiaTarea(
			String uid, CancelarSolEvaCrePeticion peticion) {
		CancelarSolEvaCreRespuesta respuesta = new CancelarSolEvaCreRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionTx = null;
		SqlSession sesionNTx = null;

		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			sesionTx = FabricaConexiones.obtenerSesionTx();

			// obtenemos la consulta planilla aprobacion
			PlanillaAprobacionPeticionDTO peticionPlanilla = new PlanillaAprobacionPeticionDTO();
			peticionPlanilla.setSolicitud(peticion.getSolicitud());
			peticionPlanilla.setTotales(false);
			PlanillaAprobacionRespuestaDTO respuestaPlanillaAprobacion = consultarPlanillaAprobacionTarea(
					uid, peticionPlanilla, null);
			LogHandler.info(uid, getClass(), "respuestaPlanillaAprobacion -> "
					+ respuestaPlanillaAprobacion);
			if (!respuestaPlanillaAprobacion.getHeader().isEstatus()) {
				throw new Exception(respuestaPlanillaAprobacion.getHeader()
						.getMensaje());
			}

			// Validamos si la solicitud sigue activa
			SolicitudSACG solicitudSACG = (SolicitudSACG) sesionNTx.selectOne(
					"consultaProcCreditoSolicitudTodas",
					peticion.getSolicitud());
			if (solicitudSACG.getStatus().trim().equals("X")) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.consulta.solicitud.cancelada"));
			}

			LogHandler
					.info(uid, getClass(),
							"==> cancelarSolicitudEvaluacionCrediticiaTarea : validaTareaHijaUnica");
			LogHandler
					.trace(uid, getClass(),
							"==> cancelarSolicitudEvaluacionCrediticiaTarea : validaTareaHijaUnica");

			Integer resValida = (Integer) sesionNTx.selectOne(
					"validaTareaHijaUnica", peticion.getIdTarea());

			if (resValida == null) {
				throw new Exception(
						"No se pudo realizar la consulta validaTareaHijaUnica");
			}

			if (resValida > 0) {
				LogHandler
						.info(uid, getClass(),
								"==> cancelarSolicitudEvaluacionCrediticiaTarea : actualizarBuzonTareaHija");
				LogHandler
						.trace(uid, getClass(),
								"==> cancelarSolicitudEvaluacionCrediticiaTarea : actualizarBuzonTareaHija");
				sesionTx.update("actualizarBuzonTareaHija",
						peticion.getIdTarea());
			}

			TareaOV miTareaOV = new TareaOV();
			miTareaOV.setIdTarea(peticion.getIdTarea());

			LogHandler
					.info(uid, getClass(),
							"==> cancelarSolicitudEvaluacionCrediticiaTarea : terminarBuzonTarea");
			LogHandler
					.trace(uid, getClass(),
							"==> cancelarSolicitudEvaluacionCrediticiaTarea : terminarBuzonTarea");
			EncabezadoRespuesta terminarBuzon = consultas.terminarBuzonTarea(
					uid, sesionTx, miTareaOV);

			if (!terminarBuzon.isEstatus()) {
				throw new Exception(terminarBuzon.getMensaje());
			} else {
				respuesta.getHeader().setMensaje(terminarBuzon.getMensaje());
			}

			AtomosOV miAtomoOV = new AtomosOV();
			miAtomoOV.setSolicitud(peticion.getSolicitud());
			miAtomoOV.setProceso(peticion.getProceso());
			miAtomoOV.setCodigoResolucion(peticion.getCodigoResolucion());
			miAtomoOV.setHoraResolucion(new Date());
			miAtomoOV.setUsuarioGeneroAtomo(peticion.getUsuario());

			LogHandler
					.info(uid, getClass(),
							"==> cancelarSolicitudEvaluacionCrediticiaTarea : registrarAtomosTarea");
			LogHandler
					.trace(uid, getClass(),
							"==> cancelarSolicitudEvaluacionCrediticiaTarea : registrarAtomosTarea");
			AtomosRespuesta registarAtomos = registrarAtomosTarea(uid,
					sesionTx, miAtomoOV);

			if (!registarAtomos.getHeader().isEstatus()) {
				throw new Exception(registarAtomos.getHeader().getMensaje());
			} else {
				respuesta.getHeader().setMensaje(
						registarAtomos.getHeader().getMensaje());
			}

			// Se agrega la insercion de los datos de la planilla ***
			SolicitudPlanillaAprobacionPeticion peticionSolPlan = new SolicitudPlanillaAprobacionPeticion();

			peticionSolPlan.setSolicitud(peticion.getSolicitud());
			peticionSolPlan.setIdAtomo(registarAtomos.getIdAtomo());

			SolicitudPlanillaAprobacionRespuesta respuestaAlmacenarPlanilla = guardarSolicitudPlanillaAprobacion(
					uid, peticionSolPlan, sesionTx);

			if (!respuestaAlmacenarPlanilla.getHeader().isEstatus()) {
				throw new Exception(respuestaAlmacenarPlanilla.getHeader()
						.getMensaje());
			}

			SolicitudesPeticion miSolicitudPeticion = new SolicitudesPeticion();
			miSolicitudPeticion.setSolicitudId(peticion.getSolicitud());
			miSolicitudPeticion.setUsuarioId(peticion.getUsuario());
			miSolicitudPeticion.setMotivo(peticion.getCodigoResolucion());
			miSolicitudPeticion.setMotivoCancelacion(peticion
					.getMotivoCancelacion());

			LogHandler
					.info(uid, getClass(),
							"==> cancelarSolicitudEvaluacionCrediticiaTarea : cancelarSolicitudTarea");
			LogHandler
					.trace(uid, getClass(),
							"==> cancelarSolicitudEvaluacionCrediticiaTarea : cancelarSolicitudTarea");
			SolicitudesRespuesta cancelarSolicitud = cancelarSolicitudTarea(
					uid, sesionTx, miSolicitudPeticion);

			if (!cancelarSolicitud.getHeader().isEstatus()) {
				throw new Exception(registarAtomos.getHeader().getMensaje());
			} else {
				respuesta.getHeader().setMensaje(
						registarAtomos.getHeader().getMensaje());
			}

			sesionTx.commit(true);

			respuesta.getHeader().setMensaje(
					"Se cancelo la solicitud con exito.");

		} catch (Exception exception) {
			FabricaConexiones.rollBack(sesionTx);
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(exception.getMessage());
			respuesta.getHeader().setEstatus(false);
			LogHandler.error(uid, this.getClass(),
					"Error en cancelarSolicitudEvaluacionCrediticiaTarea : "
							+ exception.getMessage(), exception);
		} finally {
			FabricaConexiones.close(sesionNTx);
			FabricaConexiones.close(sesionTx);
		}
		return respuesta;
	}

	public CancelarSolEvaCreRespuesta terminarSolicitudEvaluacionCrediticiaTarea(
			String uid, CancelarSolEvaCrePeticion peticion) {
		CancelarSolEvaCreRespuesta respuesta = new CancelarSolEvaCreRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionTx = null;
		SqlSession sesionNTx = null;

		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			sesionTx = FabricaConexiones.obtenerSesionTx();

			// obtenemos la consulta planilla aprobacion
			PlanillaAprobacionPeticionDTO peticionPlanilla = new PlanillaAprobacionPeticionDTO();
			peticionPlanilla.setSolicitud(peticion.getSolicitud());
			peticionPlanilla.setTotales(false);
			PlanillaAprobacionRespuestaDTO respuestaPlanillaAprobacion = consultarPlanillaAprobacionTarea(
					uid, peticionPlanilla, null);

			if (!respuestaPlanillaAprobacion.getHeader().isEstatus()) {
				throw new Exception(respuestaPlanillaAprobacion.getHeader()
						.getMensaje());
			}

			// Validamos si la solicitud sigue activa
			SolicitudSACG solicitudSACG = (SolicitudSACG) sesionNTx.selectOne(
					"consultaProcCreditoSolicitudTodas",
					peticion.getSolicitud());
			if (solicitudSACG.getStatus().trim().equals("X")) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.consulta.solicitud.cancelada"));
			}

			LogHandler
					.info(uid, getClass(),
							"==> terminarSolicitudEvaluacionCrediticiaTarea : validaTareaHijaUnica");
			LogHandler
					.trace(uid, getClass(),
							"==> terminarSolicitudEvaluacionCrediticiaTarea : validaTareaHijaUnica");
			Integer resValida = (Integer) sesionNTx.selectOne(
					"validaTareaHijaUnica", peticion.getIdTarea());

			if (resValida == 0) {

				TareaOV miTareaOV = new TareaOV();
				miTareaOV.setIdTarea(peticion.getIdTarea());

				LogHandler
						.info(uid, getClass(),
								"==> terminarSolicitudEvaluacionCrediticiaTarea : terminarBuzonTarea");
				LogHandler
						.trace(uid, getClass(),
								"==> terminarSolicitudEvaluacionCrediticiaTarea : terminarBuzonTarea");
				EncabezadoRespuesta terminarBuzon = consultas
						.terminarBuzonTarea(uid, sesionTx, miTareaOV);

				if (!terminarBuzon.isEstatus()) {
					throw new Exception(terminarBuzon.getMensaje());
				} else {
					respuesta.getHeader()
							.setMensaje(terminarBuzon.getMensaje());
				}

				AtomosOV miAtomoOV = new AtomosOV();
				miAtomoOV.setSolicitud(peticion.getSolicitud());
				miAtomoOV.setProceso(peticion.getProceso());
				miAtomoOV.setCodigoResolucion(peticion.getCodigoResolucion());
				miAtomoOV.setHoraResolucion(new Date());
				miAtomoOV.setUsuarioGeneroAtomo(peticion.getUsuario());

				LogHandler
						.info(uid, getClass(),
								"==> terminarSolicitudEvaluacionCrediticiaTarea : registrarAtomosTarea");
				LogHandler
						.trace(uid, getClass(),
								"==> terminarSolicitudEvaluacionCrediticiaTarea : registrarAtomosTarea");
				AtomosRespuesta registarAtomos = registrarAtomosTarea(uid,
						sesionTx, miAtomoOV);

				if (!registarAtomos.getHeader().isEstatus()) {
					throw new Exception(registarAtomos.getHeader().getMensaje());
				} else {
					respuesta.getHeader().setMensaje(
							registarAtomos.getHeader().getMensaje());
				}

				// Se agrega la insercion de los datos de la planilla ***
				SolicitudPlanillaAprobacionPeticion peticionSolPlan = new SolicitudPlanillaAprobacionPeticion();

				peticionSolPlan.setSolicitud(peticion.getSolicitud());
				peticionSolPlan.setIdAtomo(registarAtomos.getIdAtomo());

				SolicitudPlanillaAprobacionRespuesta respuestaAlmacenarPlanilla = guardarSolicitudPlanillaAprobacion(
						uid, peticionSolPlan, sesionTx);

				if (respuestaAlmacenarPlanilla.getHeader().getMensaje() != null
						&& respuestaAlmacenarPlanilla.getHeader().isEstatus()) {

					sesionTx.commit(true);

					respuesta
							.getHeader()
							.setMensaje(
									respuestaAlmacenarPlanilla.getHeader()
											.getMensaje()
											+ "Se ha completado terminarSolicitudEvaluacionCrediticiaTarea sin errores");

				} else {
					throw new Exception(respuestaAlmacenarPlanilla.getHeader()
							.getMensaje());
				}
			} else {
				throw new Exception(
						"La solicitud esta en revisi�n en la sucursal, por comentarios en la planilla de observaciones.");
			}
		} catch (Exception exception) {
			FabricaConexiones.rollBack(sesionTx);
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(exception.getMessage());
			respuesta.getHeader().setEstatus(false);
			LogHandler.error(uid, this.getClass(),
					"Error en terminarSolicitudEvaluacionCrediticiaTarea : "
							+ exception.getMessage(), exception);
		} finally {
			FabricaConexiones.close(sesionNTx);
			FabricaConexiones.close(sesionTx);
		}
		return respuesta;
	}

	public EnviarPlaObsSucRespuesta enviarPlanillaObservacionesSucursalTarea(
			String uid, EnviarPlaObsSucPeticion peticion) {

		EnviarPlaObsSucRespuesta respuesta = new EnviarPlaObsSucRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionTx = null;
		SqlSession sesionNTx = null;

		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			sesionTx = FabricaConexiones.obtenerSesionTx();

			// Validamos si la solicitud sigue activa
			SolicitudSACG solicitudSACG = (SolicitudSACG) sesionNTx.selectOne(
					"consultaProcCreditoSolicitudTodas",
					peticion.getSolicitud());
			if (solicitudSACG.getStatus().trim().equals("X")) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.consulta.solicitud.cancelada"));
			}

			LogHandler
					.info(uid, getClass(),
							"==> enviarPlanillaObservacionesSucursalTarea : validaTareaHijaUnica");
			LogHandler
					.trace(uid, getClass(),
							"==> enviarPlanillaObservacionesSucursalTarea : validaTareaHijaUnica");
			Integer resValida = (Integer) sesionNTx.selectOne(
					"validaTareaHijaUnica", peticion.getIdTarea());

			if (resValida == 0) {

				AtomosOV miAtomoOV = new AtomosOV();
				miAtomoOV.setSolicitud(peticion.getSolicitud());
				miAtomoOV.setProceso(peticion.getProceso());
				miAtomoOV.setCodigoResolucion(peticion.getCodigoResolucion());
				miAtomoOV.setUsuarioGeneroAtomo(peticion.getUsuario());

				LogHandler
						.info(uid, getClass(),
								"==> enviarPlanillaObservacionesSucursalTarea : registrarAtomosTarea");
				LogHandler
						.trace(uid, getClass(),
								"==> enviarPlanillaObservacionesSucursalTarea : registrarAtomosTarea");
				AtomosRespuesta registarAtomos = registrarAtomosTarea(uid,
						sesionTx, miAtomoOV);

				if (!registarAtomos.getHeader().isEstatus()) {
					throw new Exception(registarAtomos.getHeader().getMensaje());
				}

				LogHandler
						.info(uid, getClass(),
								"==> enviarPlanillaObservacionesSucursalTarea : obtenerBuzonTareaidTarea");
				LogHandler
						.trace(uid, getClass(),
								"==> enviarPlanillaObservacionesSucursalTarea : obtenerBuzonTareaidTarea");
				CargaTrabajoOV resConsulta = (CargaTrabajoOV) sesionNTx
						.selectOne("obtenerBuzonTareaidTarea",
								peticion.getIdTarea());

				if (resConsulta == null) {
					throw new Exception(
							"LA CONSULTA NO ARROJO RESULTADOS PARA EL ID PROPORCIONADO");
				}

				final java.util.HashMap<String, Object> parametrosBuzonTareas = new HashMap<String, Object>();
				parametrosBuzonTareas.put("tipoTarea",
						resConsulta.getTipoTarea());
				parametrosBuzonTareas
						.put("sucursal", resConsulta.getSucursal());
				parametrosBuzonTareas.put("descripcion",
						resConsulta.getDescripcion());
				parametrosBuzonTareas.put("fechaAlta", new Date());
				parametrosBuzonTareas.put("usuarioAlta", peticion.getUsuario());
				parametrosBuzonTareas.put("fechaUltMod", new Date());
				parametrosBuzonTareas.put("perfil", peticion.getPerfil());
				parametrosBuzonTareas.put("status", peticion.getStatus());
				parametrosBuzonTareas
						.put("idTareaPadre", peticion.getIdTarea());
				LogHandler
						.trace(uid, getClass(),
								"==> enviarPlanillaObservacionesSucursalTarea - insertaBuzonTareasPlanilla");
				Integer numeroRegistros = sesionTx.insert(
						"insertaBuzonTareasPlanilla", parametrosBuzonTareas);

				LogHandler.info(uid, getClass(), "" + numeroRegistros);

				final java.util.HashMap<String, Object> parametrosObservaciones = new HashMap<String, Object>();
				parametrosObservaciones.put("idAtomo",
						registarAtomos.getIdAtomo());
				parametrosObservaciones.put("solicitud",
						peticion.getSolicitud());
				sesionTx.update("actualizarAtomoObservaciones",
						parametrosObservaciones);

				sesionTx.commit(true);
				respuesta
						.getHeader()
						.setMensaje(
								"Se ha completado enviarPlanillaObservacionesSucursalTarea sin errores");
			} else {
				throw new Exception(
						"La solicitud esta en revisi�n en la sucursal, por comentarios en la planilla de observaciones.");
			}
		} catch (Exception exception) {
			FabricaConexiones.rollBack(sesionTx);
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(exception.getMessage());
			respuesta.getHeader().setEstatus(false);
			LogHandler.error(uid, this.getClass(),
					"Error en enviarPlanillaObservacionesSucursalTarea : "
							+ exception.getMessage(), exception);
		} finally {
			FabricaConexiones.close(sesionNTx);
			FabricaConexiones.close(sesionTx);
		}
		return respuesta;
	}

	public CorregirPlaObsSucRespuesta corregirPlanillaObservacionesSucursalTarea(
			String uid, CorregirPlaObsSucPeticion peticion) {
		CorregirPlaObsSucRespuesta respuesta = new CorregirPlaObsSucRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionTx = null;
		SqlSession sesionNTx = null;

		try {
			sesionTx = FabricaConexiones.obtenerSesionTx();
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			// Validamos si la solicitud sigue activa
			SolicitudSACG solicitudSACG = (SolicitudSACG) sesionNTx.selectOne(
					"consultaProcCreditoSolicitudTodas",
					peticion.getSolicitud());
			if (solicitudSACG.getStatus().trim().equals("X")) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.consulta.solicitud.cancelada"));
			}

			if (solicitudSACG.getVisualizaCec() == null
					|| solicitudSACG.getVisualizaCec().trim().isEmpty()
					|| solicitudSACG.getVisualizaCec().trim().equals("false")) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.consulta.solicitud.sin.hold"));
			}

			LogHandler
					.info(uid, getClass(),
							"==> corregirPlanillaObservacionesSucursalTarea : terminarTareaSucursal");
			LogHandler
					.trace(uid, getClass(),
							"==> corregirPlanillaObservacionesSucursalTarea : terminarTareaSucursal");
			sesionTx.update("terminarTareaSucursal", peticion.getIdTarea());

			AtomosOV miAtomoOV = new AtomosOV();
			miAtomoOV.setSolicitud(peticion.getSolicitud());
			miAtomoOV.setProceso(peticion.getProceso());
			miAtomoOV.setCodigoResolucion(peticion.getCodigoResolucion());
			miAtomoOV.setHoraResolucion(new Date());
			miAtomoOV.setUsuarioGeneroAtomo(peticion.getUsuario());

			LogHandler
					.info(uid, getClass(),
							"==> corregirPlanillaObservacionesSucursalTarea : registrarAtomosTarea");
			LogHandler
					.trace(uid, getClass(),
							"==> corregirPlanillaObservacionesSucursalTarea : registrarAtomosTarea");
			AtomosRespuesta registarAtomos = registrarAtomosTarea(uid,
					sesionTx, miAtomoOV);

			if (!registarAtomos.getHeader().isEstatus()) {
				throw new Exception(registarAtomos.getHeader().getMensaje());
			}

			sesionTx.commit(true);
			respuesta
					.getHeader()
					.setMensaje(
							"Se ha completado corregirPlanillaObservacionesSucursalTarea sin errores");

		} catch (Exception exception) {
			FabricaConexiones.rollBack(sesionTx);
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(exception.getMessage());
			respuesta.getHeader().setEstatus(false);
			LogHandler.error(uid, this.getClass(),
					"Error en corregirPlanillaObservacionesSucursalTarea : "
							+ exception.getMessage(), exception);
		} finally {
			FabricaConexiones.close(sesionTx);
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	@SuppressWarnings("unchecked")
	public ReporteSolicitudesRespuesta reporteSolicitudesTarea(String uid,
			ReporteSolicitudesPeticion reporteSolicitudesPeticion) {
		ReporteSolicitudesRespuesta reporteSolicitudesRespuesta = new ReporteSolicitudesRespuesta();
		reporteSolicitudesRespuesta.setHeader(new EncabezadoRespuesta());
		reporteSolicitudesRespuesta.getHeader().setUID(uid);
		reporteSolicitudesRespuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		List<ReporteSolicitudOV> solicitudes = null;
		String validaStr = "";
		// Date fechaAsignacionPool;
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		try {
			String[] datosRequeridos = { "fechaInicial", "fechaFinal" };
			/*
			 * "division", "region", "sucursal", "producto", "estatus",
			 * "ciclo"};
			 */

			validaStr = Validaciones.datosRequeridos(
					reporteSolicitudesPeticion, datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("ciof.error.datos.requeridos")
								+ validaStr);
			}

			// Se abre la sesion No transaccional sybase
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(),
					"reporteSolicitudesTarea: - consultaReporteSolicitudes");
			LogHandler.info(uid, getClass(),
					"reporteSolicitudesTarea: - consultaReporteSolicitudes");
			solicitudes = (List<ReporteSolicitudOV>) sesionNTx.selectList(
					"consultaReporteSolicitudes", reporteSolicitudesPeticion);

			if (solicitudes.isEmpty()) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("consulta.monitor.imagenes.sinresultados"));
			}
			ArrayList<SabadosLaboralesOV> sabadosHabiles = comun
					.obtenerSabadosLaborables(uid, reporteSolicitudesPeticion);
			ArrayList<DiasInhabilesOV> diasInhabiles = comun
					.obtenerDiasInhabiles(uid, 0);

			ParGeneralOV valorMinutosRespuesta = comun.obtenerParGeneralOV(uid,
					"MINRESSOL");
			if (valorMinutosRespuesta == null
					|| valorMinutosRespuesta.getCgValor().trim().isEmpty()) {
				throw new Exception(
						"No fue posible obtener el tiempo de respuesta.");
			}
			ParGeneralOV horaEntradaSEM = comun.obtenerParGeneralOV(uid,
					"HRENTSEM");
			if (horaEntradaSEM == null
					|| horaEntradaSEM.getCgValor().trim().isEmpty()) {
				throw new Exception(
						"No fue posible obtener hora de entrada semanal.");
			}
			ParGeneralOV horaSalidaSEM = comun.obtenerParGeneralOV(uid,
					"HRSALSEM");
			if (horaSalidaSEM == null
					|| horaSalidaSEM.getCgValor().trim().isEmpty()) {
				throw new Exception(
						"No fue posible obtener hora de salida semanal.");
			}
			ParGeneralOV horaEntradaSAB = comun.obtenerParGeneralOV(uid,
					"HRENTSAB");
			if (horaEntradaSAB == null
					|| horaEntradaSAB.getCgValor().trim().isEmpty()) {
				throw new Exception(
						"No fue posible obtener hora de entrada sabado.");
			}
			ParGeneralOV horaSalidaSAB = comun.obtenerParGeneralOV(uid,
					"HRSALSAB");
			if (horaSalidaSAB == null
					|| horaSalidaSAB.getCgValor().trim().isEmpty()) {
				throw new Exception(
						"No fue posible obtener hora de salida sabado.");
			}
			// iteracion del objeto para agregar nuevos campos calculados
			for (ReporteSolicitudOV temp : solicitudes) {
				// fechaAsignacionPool = (Date)
				// sesionNTx.selectOne("obtenerFechaAsignacionPool",
				// temp.getSolicitud());
				// if (fechaAsignacionPool == null) {
				// throw new
				// Exception("No fue posible obtener la fecha asignaPool de la solicitud: "
				// + temp.getSolicitud());
				// }
				LogHandler.info(uid, getClass(), "reporteSolicitudesTarea: "
						+ temp.getFechaAsignacion());
				if (temp.getFechaAsignacion() == null
						|| temp.getFechaAsignacion().equals(null)
						|| "".equals(temp.getFechaAsignacion())) {
					temp.setFechaRespuestaMaxima("");
				} else {
					// Se obtiene el campo fechaRespuestaMaxima
					temp.setFechaRespuestaMaxima(formato.format(comun
							.getFechaMaximaRespuestaCEC(uid, sabadosHabiles,
									formato.parse(temp.getFechaAsignacion()),
									diasInhabiles,
									valorMinutosRespuesta.getCgValor(),
									horaEntradaSEM.getCgValor(),
									horaSalidaSEM.getCgValor(),
									horaEntradaSAB.getCgValor(),
									horaSalidaSAB.getCgValor())));
				}
				// LogHandler.info(uid, getClass(),
				// "reporteSolicitudesTarea >>> obj: " + temp);
				// Se obtiene el campo tiempoAnalisis
				if (temp.getFechaInicioGestion() != null
						&& temp.getFechaTermino() != null
						&& (temp.getFechaObservaciones() == null || ""
								.equals(temp.getFechaObservaciones().trim()))) {
					temp.setTiempoAnalisis(Minutes
							.minutesBetween(
									new LocalDateTime(temp
											.getFechaInicioGestion().getTime()),
									new LocalDateTime(temp.getFechaTermino()
											.getTime())).getMinutes()
							+ "");
				} else if (temp.getFechaInicioGestion() != null
						&& (temp.getFechaObservaciones() != null && !""
								.equals(temp.getFechaObservaciones().trim()))) {
					temp.setTiempoAnalisis(Minutes.minutesBetween(
							new LocalDateTime(temp.getFechaInicioGestion()
									.getTime()),
							new LocalDateTime(formato.parse(
									temp.getFechaObservaciones()).getTime()))
							.getMinutes()
							+ "");
				} else if (temp.getFechaInicioGestion() != null
						&& temp.getFechaTermino() == null
						&& (temp.getFechaObservaciones() == null || ""
								.equals(temp.getFechaObservaciones().trim()))) {
					temp.setTiempoAnalisis(Minutes.minutesBetween(
							new LocalDateTime(temp.getFechaInicioGestion()
									.getTime()), new LocalDateTime())
							.getMinutes()
							+ "");
				} else {
					temp.setTiempoAnalisis("");
				}
				// Se obtiene el campo estatusRevision
				if (temp.getFechaInicioGestion() != null
						&& !"N/A".equals(temp.getEstatusRevision().trim())
						&& temp.getFechaTermino() != null) {
					temp.setEstatusRevision(Minutes
							.minutesBetween(
									new LocalDateTime(temp
											.getFechaInicioGestion().getTime()),
									new LocalDateTime(temp.getFechaTermino()
											.getTime())).getMinutes()
							+ "");
				}
			}
			reporteSolicitudesRespuesta.setSolicitudes(solicitudes);
		} catch (Exception ex) {
			LogHandler.error(uid, getClass(),
					"reporteSolicitudesTarea: " + ex.getMessage(), ex);
			reporteSolicitudesRespuesta.getHeader().setEstatus(false);
			reporteSolicitudesRespuesta.getHeader().setMensaje(
					ReadProperties.mensajes.getProp("ciof.error.consulta"));
			reporteSolicitudesRespuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return reporteSolicitudesRespuesta;
	}

	@SuppressWarnings("unchecked")
	public ReporteBuroExternoRespuesta reporteBuroExternoTarea(String uid,
			ReporteSolicitudesPeticion reporteSolicitudesPeticion) {
		ReporteBuroExternoRespuesta reporteBuroExternoRespuesta = new ReporteBuroExternoRespuesta();
		reporteBuroExternoRespuesta.setHeader(new EncabezadoRespuesta());
		reporteBuroExternoRespuesta.getHeader().setUID(uid);
		reporteBuroExternoRespuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		List<ReporteBuroExternoOV> productos = null;
		String validaStr = "";
		try {
			String[] datosRequeridos = { "fechaInicial", "fechaFinal" };
			/*
			 * "division", "region", "sucursal", "producto", "ciclo"};
			 */

			validaStr = Validaciones.datosRequeridos(
					reporteSolicitudesPeticion, datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("ciof.error.datos.requeridos")
								+ validaStr);
			}
			// Se abre la sesion No transaccional sybase
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(),
					"reporteBuroExternoTarea: - consultaReporteBuroExterno");
			LogHandler.info(uid, getClass(),
					"reporteBuroExternoTarea: - consultaReporteBuroExterno");
			productos = (List<ReporteBuroExternoOV>) sesionNTx.selectList(
					"consultaReporteBuroExterno", reporteSolicitudesPeticion);

			if (productos.isEmpty()) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.consulta.sin.resultados"));
			}
			reporteBuroExternoRespuesta.setProductos(productos);
		} catch (Exception ex) {
			LogHandler.error(uid, getClass(),
					"reporteBuroExternoTarea: " + ex.getMessage(), ex);
			reporteBuroExternoRespuesta.getHeader().setEstatus(false);
			reporteBuroExternoRespuesta.getHeader().setMensaje(
					ReadProperties.mensajes.getProp("ciof.error.consulta"));
			reporteBuroExternoRespuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return reporteBuroExternoRespuesta;
	}

	@SuppressWarnings("unchecked")
	public ReporteAsignacionesRespuesta reporteAsignacionesTarea(String uid,
			ReporteSolicitudesPeticion reporteSolicitudesPeticion) {
		ReporteAsignacionesRespuesta reporteAsignacionesRespuesta = new ReporteAsignacionesRespuesta();
		reporteAsignacionesRespuesta.setHeader(new EncabezadoRespuesta());
		reporteAsignacionesRespuesta.getHeader().setUID(uid);
		reporteAsignacionesRespuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		List<ReporteAsignacionOV> asignaciones = null;
		String validaStr = "";
		try {
			String[] datosRequeridos = { "fechaInicial", "fechaFinal" };
			/* "producto", "sucursal"}; */

			validaStr = Validaciones.datosRequeridos(
					reporteSolicitudesPeticion, datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("ciof.error.datos.requeridos")
								+ validaStr);
			}
			Calendar cal = Calendar.getInstance();
			cal.setTime(reporteSolicitudesPeticion.getFechaInicial());
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			reporteSolicitudesPeticion.setFechaInicial(cal.getTime());

			cal.setTime(reporteSolicitudesPeticion.getFechaFinal());
			cal.set(Calendar.HOUR_OF_DAY, QUERY_HORA_MAX);
			cal.set(Calendar.MINUTE, QUERY_MINUTO_MAX);
			cal.set(Calendar.SECOND, QUERY_SEGUNDO_MAX);
			cal.set(Calendar.MILLISECOND, QUERY_MILISEGUNDO_MAX);
			reporteSolicitudesPeticion.setFechaFinal(cal.getTime());
			LogHandler.info(uid, getClass(),
					"reporteAsignacionesTarea: - FechaInicial: "
							+ reporteSolicitudesPeticion.getFechaInicial());
			LogHandler.info(uid, getClass(),
					"reporteAsignacionesTarea: - FechaFinal: "
							+ reporteSolicitudesPeticion.getFechaFinal());
			// Se abre la sesion No transaccional sybase
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(),
					"reporteAsignacionesTarea: - consultaReporteAsignaciones");
			LogHandler.info(uid, getClass(),
					"reporteAsignacionesTarea: - consultaReporteAsignaciones");
			asignaciones = (List<ReporteAsignacionOV>) sesionNTx.selectList(
					"consultaReporteAsignaciones", reporteSolicitudesPeticion);
			if (asignaciones.isEmpty()) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.consulta.sin.resultados"));
			}
			reporteAsignacionesRespuesta.setAsignaciones(asignaciones);
		} catch (Exception ex) {
			LogHandler.error(uid, getClass(),
					"reporteAsignacionesTarea: " + ex.getMessage(), ex);
			reporteAsignacionesRespuesta.getHeader().setEstatus(false);
			reporteAsignacionesRespuesta.getHeader().setMensaje(
					ReadProperties.mensajes.getProp("ciof.error.consulta"));
			reporteAsignacionesRespuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return reporteAsignacionesRespuesta;
	}

	@SuppressWarnings("unchecked")
	public ReporteReasignacionesRespuesta reporteReasignacionesTarea(
			String uid, ReporteSolicitudesPeticion reporteSolicitudesPeticion) {
		ReporteReasignacionesRespuesta reporteReasignacionesRespuesta = new ReporteReasignacionesRespuesta();
		reporteReasignacionesRespuesta.setHeader(new EncabezadoRespuesta());
		reporteReasignacionesRespuesta.getHeader().setUID(uid);
		reporteReasignacionesRespuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		List<ReporteReasignacionOV> reasignaciones = null;
		String validaStr = "";
		try {
			String[] datosRequeridos = { "fechaInicial", "fechaFinal" };
			/* "producto", "sucursal"}; */

			validaStr = Validaciones.datosRequeridos(
					reporteSolicitudesPeticion, datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("ciof.error.datos.requeridos")
								+ validaStr);
			}
			Calendar cal = Calendar.getInstance();
			cal.setTime(reporteSolicitudesPeticion.getFechaInicial());
			cal.set(Calendar.HOUR_OF_DAY, 0);
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			reporteSolicitudesPeticion.setFechaInicial(cal.getTime());

			cal.setTime(reporteSolicitudesPeticion.getFechaFinal());
			cal.set(Calendar.HOUR_OF_DAY, QUERY_HORA_MAX);
			cal.set(Calendar.MINUTE, QUERY_MINUTO_MAX);
			cal.set(Calendar.SECOND, QUERY_SEGUNDO_MAX);
			cal.set(Calendar.MILLISECOND, QUERY_MILISEGUNDO_MAX);
			reporteSolicitudesPeticion.setFechaFinal(cal.getTime());
			LogHandler.info(uid, getClass(),
					"reporteReasignacionesTarea: - FechaInicial: "
							+ reporteSolicitudesPeticion.getFechaInicial());
			LogHandler.info(uid, getClass(),
					"reporteReasignacionesTarea: - FechaFinal: "
							+ reporteSolicitudesPeticion.getFechaFinal());
			// Se abre la sesion No transaccional sybase
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler
					.trace(uid, getClass(),
							"reporteReasignacionesTarea: - consultaReporteReasignaciones");
			LogHandler
					.info(uid, getClass(),
							"reporteReasignacionesTarea: - consultaReporteReasignaciones");
			reasignaciones = (List<ReporteReasignacionOV>) sesionNTx
					.selectList("consultaReporteReasignaciones",
							reporteSolicitudesPeticion);
			if (reasignaciones.isEmpty()) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.consulta.sin.resultados"));
			}
			reporteReasignacionesRespuesta.setReasignaciones(reasignaciones);
		} catch (Exception ex) {
			LogHandler.error(uid, getClass(), "reporteReasignacionesTarea: "
					+ ex.getMessage(), ex);
			reporteReasignacionesRespuesta.getHeader().setEstatus(false);
			reporteReasignacionesRespuesta.getHeader().setMensaje(
					ReadProperties.mensajes.getProp("ciof.error.consulta"));
			reporteReasignacionesRespuesta.getHeader().setCodigo(
					ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return reporteReasignacionesRespuesta;
	}

	@SuppressWarnings("unchecked")
	public ReporteClasificacionSucursalesRespuesta reporteClasificacionSucursalesTarea(
			String uid,
			ReporteClasificacionSucursalesPeticion reporteClasificacionSucursalesPeticion) {
		ReporteClasificacionSucursalesRespuesta reporteClasificacionSucursalesRespuesta = new ReporteClasificacionSucursalesRespuesta();
		reporteClasificacionSucursalesRespuesta
				.setHeader(new EncabezadoRespuesta());
		reporteClasificacionSucursalesRespuesta.getHeader().setUID(uid);
		reporteClasificacionSucursalesRespuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		List<ReporteClasificacionSucursalesOV> sucursales = null;
		// String validaStr = "";
		try {
			/*
			 * String[] datosRequeridos = {"fechaInicial", "fechaFinal"};
			 * "division", "region", "sucursal", "producto", "estatus",
			 * "ciclo"};
			 * 
			 * validaStr =
			 * Validaciones.datosRequeridos(reporteClasificacionSucursalesPeticion
			 * , datosRequeridos); if (!validaStr.equalsIgnoreCase("")) { throw
			 * new Exception(ReadProperties.mensajes.getProp(
			 * "ciof.error.datos.requeridos") + validaStr ); }
			 */

			// Se abre la sesion No transaccional sybase
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler
					.trace(uid, getClass(),
							"reporteClasificacionSucursalesTarea: - consultaClasificacionSucursales");
			LogHandler
					.info(uid, getClass(),
							"reporteClasificacionSucursalesTarea: - consultaClasificacionSucursales");
			sucursales = (List<ReporteClasificacionSucursalesOV>) sesionNTx
					.selectList("consultaClasificacionSucursales",
							reporteClasificacionSucursalesRespuesta);
			if (sucursales.isEmpty()) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("solicitudes.consulta.sin.resultados"));
			}
			reporteClasificacionSucursalesRespuesta
					.setSucursalesClasif(sucursales);
		} catch (Exception ex) {
			LogHandler.error(uid, getClass(),
					"reporteClasificacionSucursalesTarea: " + ex.getMessage(),
					ex);
			reporteClasificacionSucursalesRespuesta.getHeader().setEstatus(
					false);
			reporteClasificacionSucursalesRespuesta.getHeader().setMensaje(
					ReadProperties.mensajes.getProp("ciof.error.consulta"));
			reporteClasificacionSucursalesRespuesta.getHeader().setCodigo(
					ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return reporteClasificacionSucursalesRespuesta;
	}

	public ValidarSolicitudRespuesta validarDatosSolicitudTarea(String uid,
			ValidarSolicitudPeticion peticion) {
		ValidarSolicitudRespuesta respuesta = new ValidarSolicitudRespuesta();
		FuncionesComunes funcionesComunes = new FuncionesComunes();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		String mensajes = "La solicitud no tiene captura completa, falta: ";
		Boolean estatus = true;

		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if (peticion == null || peticion.getNumeroSolicitud() == null
					|| peticion.getNumeroSolicitud().trim().isEmpty()) {
				throw new Exception("Los datos de la peticion son incorrectos");
			}

			LogHandler
					.trace(uid, getClass(),
							"validarDatosSolicitudTarea: - obtenerValidarDatosSolicitud");
			LogHandler
					.info(uid, getClass(),
							"validarDatosSolicitudTarea: - obtenerValidarDatosSolicitud");

			ValidaSolicitudOV datosSol = (ValidaSolicitudOV) sesionNTx
					.selectOne("obtenerValidarDatosSolicitud",
							peticion.getNumeroSolicitud());

			if (datosSol == null) {
				throw new Exception(
						"No existe informacion para el numero de solicitud de la peticion");
			} else {

				if (datosSol.getStatus().equals("X")) {
					throw new Exception(
							"El estatus de la solicitud es CANCELADA");
				}

				// Validaciones datosPersona
				if (!funcionesComunes.validarString(datosSol.getCliente())) {
					mensajes = mensajes + "Nombre Grupo \n";
					estatus = false;
				}
				if (datosSol.getVendedor().trim().equals("-1")) {
					mensajes = mensajes + "Asesor de Credito \n";
					estatus = false;
				}
				if (!funcionesComunes.validarString(datosSol.getVendedor())) {
					mensajes = mensajes + "Asesor de Credito \n";
					estatus = false;
				}
				if (!funcionesComunes.validarString(datosSol
						.getCodigoProducto())) {
					mensajes = mensajes + "Producto \n";
					estatus = false;
				}
				if (!funcionesComunes.validarDoble(datosSol.getTasa())
						|| !funcionesComunes.validarDobleMayorCero(datosSol
								.getTasa())) {
					mensajes = mensajes + "Tasa \n";
					estatus = false;
				}
				if (!funcionesComunes.validarEntero(datosSol.getPlazo())
						|| !funcionesComunes.validarEnteroMayorCero(datosSol
								.getPlazo())) {
					mensajes = mensajes + "Plazo \n";
					estatus = false;
				}

				if (!funcionesComunes.validarFecha(datosSol.getFechaCaptura())) {
					mensajes = mensajes + "Fecha de Desembolso \n";
					estatus = false;
				}

				// Valida que no sea GOS1
				if (!datosSol.getCodigoProducto().equals("GOS1")) {
					if (!funcionesComunes.validarEntero(datosSol
							.getDiaReunion())) {
						mensajes = mensajes + "Dia de Reunion \n";
						estatus = false;
					}
					if (!funcionesComunes.validarString(datosSol
							.getHoraReunionInicio())) {
						mensajes = mensajes + "Hora de Reunion Inicial \n";
						estatus = false;
					}
					if (!funcionesComunes.validarString(datosSol
							.getHoraReunionFin())) {
						mensajes = mensajes + "Hora de Reunion Final \n";
						estatus = false;
					}
					if (!funcionesComunes.validarEntero(datosSol.getDiaPago())) {
						mensajes = mensajes + "Dia de Pago \n";
						estatus = false;
					}
				}

				// Validar idRelaciones
				LogHandler
						.info(uid, getClass(),
								"==> validarDatosSolicitudTarea - obtenerClientesValidarSolicitud");
				LogHandler
						.trace(uid, getClass(),
								"==> validarDatosSolicitudTarea - obtenerClientesValidarSolicitud");

				@SuppressWarnings("unchecked")
				List<ValidaSolicitudOV> integrantesSolicitud = (List<ValidaSolicitudOV>) sesionNTx
						.selectList("obtenerClientesValidarSolicitud",
								peticion.getNumeroSolicitud());

				if (integrantesSolicitud == null
						|| integrantesSolicitud.size() == 0) {
					throw new Exception(
							"La solicitud no cuenta con integrantes");
				} else {

					// Obtenemos valoresMinimo integrantes
					LogHandler.trace(uid, getClass(),
							"validarDatosSolicitudTarea: - obtenerParGeneral");
					ParGeneralOV minComunalNuevo = comun.obtenerParGeneralOV(
							uid, "NIM_COMN");
					// (ParGeneralOV) sesionNTx.selectOne("obtenerParGeneral",
					// "NIM_COMN");

					LogHandler.trace(uid, getClass(),
							"validarDatosSolicitudTarea: - obtenerParGeneral");
					ParGeneralOV minComunalReno = comun.obtenerParGeneralOV(
							uid, "NIM_COMR");
					// (ParGeneralOV) sesionNTx.selectOne("obtenerParGeneral",
					// "NIM_COMR");

					LogHandler.trace(uid, getClass(),
							"validarDatosSolicitudTarea: - obtenerParGeneral");
					ParGeneralOV minSolidario = comun.obtenerParGeneralOV(uid,
							"NIM_SOL");
					// (ParGeneralOV) sesionNTx.selectOne("obtenerParGeneral",
					// "NIM_SOL");

					LogHandler.trace(uid, getClass(),
							"validarDatosSolicitudTarea: - obtenerParGeneral");
					ParGeneralOV minOportunidad = comun.obtenerParGeneralOV(
							uid, "NIM_OP");
					// (ParGeneralOV) sesionNTx.selectOne("obtenerParGeneral",
					// "NIM_OP");

					if (minComunalNuevo == null
							|| minComunalNuevo.getCgValor().trim().isEmpty()
							|| minComunalReno == null
							|| minComunalReno.getCgValor().trim().isEmpty()
							|| minSolidario == null
							|| minSolidario.getCgValor().trim().isEmpty()
							|| minOportunidad == null
							|| minOportunidad.getCgValor().trim().isEmpty()) {
						throw new Exception(
								"No fue posible obtener los parametros para la validacion de buro.");
					}

					// Validacion numero de integrantes
					if (datosSol.getCategoria().trim().equals("COMN")
							&& datosSol.getCiclo().intValue() == 0
							&& integrantesSolicitud.size() < Integer
									.valueOf(minComunalNuevo.getCgValor()
											.trim())) {
						throw new Exception(
								"No cumple con el minimo de integrantes");
					}
					if (datosSol.getCategoria().trim().equals("COMN")
							&& datosSol.getCiclo().intValue() > 0
							&& integrantesSolicitud.size() < Integer
									.valueOf(minComunalReno.getCgValor().trim())) {
						throw new Exception(
								"No cumple con el minimo de integrantes");
					}
					if (datosSol.getCategoria().trim().equals("SOLN")
							&& integrantesSolicitud.size() < Integer
									.valueOf(minSolidario.getCgValor().trim())) {
						throw new Exception(
								"No cumple con el minimo de integrantes");
					}
					if (datosSol.getCategoria().trim().equals("OPON")
							&& integrantesSolicitud.size() < Integer
									.valueOf(minOportunidad.getCgValor().trim())) {
						throw new Exception(
								"No cumple con el minimo de integrantes");
					}

					for (int i = 0; i < integrantesSolicitud.size(); i++) {

						// parametros de consulta
						final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();

						parametros.put("cliente", integrantesSolicitud.get(i)
								.getCliente());
						parametros.put("solicitud",
								peticion.getNumeroSolicitud());

						// Se obtiene la consulta para Relaciones
						LogHandler
								.info(uid, getClass(),
										"==> validarDatosPersonaTarea - obtenerDatosClientesValidarSolicitud");
						LogHandler
								.trace(uid, getClass(),
										"==> validarDatosPersonaTarea - obtenerDatosClientesValidarSolicitud");

						ValidaIntegrantesSolicitudOV cliente = (ValidaIntegrantesSolicitudOV) sesionNTx
								.selectOne(
										"obtenerDatosClientesValidarSolicitud",
										parametros);

						if (cliente == null) {
							mensajes = mensajes
									+ "No existe informacion para el cliente"
									+ integrantesSolicitud.get(i).getCliente();
						} else {
							if (!cliente.getStatus().equals("X")) {
								if (!funcionesComunes.validarDoble(cliente
										.getEfectivoSolicitado())
										|| !funcionesComunes
												.validarDobleMayorCero(cliente
														.getEfectivoSolicitado())) {
									mensajes = mensajes
											+ "Credito Solicitado del Cliente "
											+ integrantesSolicitud.get(i)
													.getCliente() + " \n";
									estatus = false;
								}
								if (!funcionesComunes.validarString(cliente
										.getCodigoDestinoCredito())) {
									mensajes = mensajes
											+ "Destino del Credito del Cliente "
											+ integrantesSolicitud.get(i)
													.getCliente() + " \n";
									estatus = false;
								}
							}
						}
					} // fin for
				} // fin else 2
			} // fin else 1

			respuesta.getHeader().setEstatus(estatus);
			if (estatus) {
				respuesta.getHeader().setMensaje("La solicitud es valida");
			} else {
				respuesta.getHeader().setMensaje(mensajes);
			}
		} catch (Exception exception) {
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(mensajes + exception.getMessage());
			respuesta.getHeader().setEstatus(false);
			LogHandler.error(
					uid,
					this.getClass(),
					"Error en validarDatosSolicitudTarea : "
							+ exception.getMessage(), exception);
		} finally {
			FabricaConexiones.close(sesionNTx);
		}

		return respuesta;
	}

	/**
	 * @param uid
	 *            :
	 * @param peticion
	 *            :
	 * @return ConsultaAvanceTrabajoRespuesta
	 */
	public ConsultaAvanceTrabajoRespuesta consultarGraficaAvanceTarea(
			String uid, ConsultaAvanceTrabajoPeticion peticion) {
		ConsultaAvanceTrabajoRespuesta respuesta = new ConsultaAvanceTrabajoRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;

		try {
			// Se abre la sesion No transaccional sybase
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler
					.trace(uid, getClass(),
							"consultarGraficaAvanceTarea: - consultarGraficaAvanceTarea");
			LogHandler
					.info(uid, getClass(),
							"consultarGraficaAvanceTarea: - consultarGraficaAvanceTarea");
			AvanceTrabajo respuestaConsulta = (AvanceTrabajo) sesionNTx
					.selectOne("consultarGraficaAvanceTarea", peticion
							.getUsuarioPropietario().trim());

			if (respuestaConsulta == null) {
				throw new Exception("La consulta no pudo ser realizada.");
			}

			double porcentajeIndividual = (respuestaConsulta
					.getPonderacionTerminadas() * CIEN)
					/ respuestaConsulta.getPonderacionGrupo();
			respuestaConsulta
					.setPonderacionTerminadas(redondear(porcentajeIndividual));
			if (respuestaConsulta.getPonderacionGrupo() == 0) {
				respuestaConsulta.setPonderacionGrupo(0);
			} else {
				respuestaConsulta.setPonderacionGrupo(CIEN);
			}
			List<AvanceTrabajo> lista = new ArrayList<AvanceTrabajo>();
			AvanceTrabajo barra1 = new AvanceTrabajo();
			barra1.setPonderacionTerminadas(respuestaConsulta
					.getPonderacionTerminadas());
			AvanceTrabajo barra2 = new AvanceTrabajo();
			barra2.setPonderacionTerminadas(respuestaConsulta
					.getPonderacionGrupo());
			lista.add(barra1);
			lista.add(barra2);
			respuesta.setBarra(lista);
			respuesta.setEstatusAvance(respuestaConsulta);
		} catch (Exception ex) {
			LogHandler.error(uid, getClass(), "consultarGraficaAvanceTarea: "
					+ ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(
					ReadProperties.mensajes.getProp("ciof.error.consulta"));
			respuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * Almacenar planilla aprobacion tarea.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the peticion
	 * @param solicitud
	 *            the solicitud
	 * @param sesion
	 *            the sesion
	 * @return the respuesta almacenar planilla aprobacion
	 */
	public RespuestaAlmacenarPlanillaAprobacion almacenarPlanillaAprobacionIntegrantesTarea(
			String uid, List<IntegrantePlanillaAprobacionDTO> peticion,
			CabeceraPlanillaAprobacionOV solicitud, SqlSession sesion) {

		RespuestaAlmacenarPlanillaAprobacion respuesta = new RespuestaAlmacenarPlanillaAprobacion();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionTx = null;

		boolean sesionExterna = false;

		try {
			// Se abre la conexion hacia la base de datos
			if (sesion == null) {
				sesionTx = FabricaConexiones.obtenerSesionTx();
			} else {
				sesionTx = sesion;
				sesionExterna = true;
			}
			if (peticion.size() == 0 || peticion == null) {
				throw new Exception("La lista de integrantes esta vacia");
			}

			LogHandler
					.info(uid,
							getClass(),
							"almacenarPlanillaAprobacionIntegrantesTarea - obtenerIdSolicitudPlanillaAprobacion");
			LogHandler
					.trace(uid,
							getClass(),
							"almacenarPlanillaAprobacionIntegrantesTarea - obtenerIdSolicitudPlanillaAprobacion");
			Integer idPlanilla = (Integer) sesionTx.selectOne(
					"obtenerIdSolicitudPlanillaAprobacion",
					solicitud.getSolicitud());

			for (int i = 0; i < peticion.size(); i++) {
				// parametros de consulta
				final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
				// solicitudesPeticion.getMotivo() != null ?
				// solicitudesPeticion.getMotivo() : "");
				parametros.put("idPlanilla", idPlanilla);
				parametros.put(
						"solicitud",
						solicitud.getSolicitud() != null ? solicitud
								.getSolicitud() : "");
				parametros.put("persona",
						peticion.get(i).getPersona() != null ? peticion.get(i)
								.getPersona() : "");
				parametros.put("claveClienteUnico", peticion.get(i)
						.getClaveClienteUnico() != null ? peticion.get(i)
						.getClaveClienteUnico() : "");

				// Datos por Integrante
				parametros.put("dINombreCliente", peticion.get(i)
						.getdINombreCliente() != null ? peticion.get(i)
						.getdINombreCliente() : "");
				parametros.put("dIEdad", peticion.get(i).getdIEdad());
				parametros.put("dIEstadoCivil", peticion.get(i)
						.getdIEstadoCivil() != null ? peticion.get(i)
						.getdIEstadoCivil() : "");
				parametros.put("dICiclo", peticion.get(i).getdICiclo());
				parametros.put("dIContratoAnterior", peticion.get(i)
						.getdIContratoAnterior() != null ? peticion.get(i)
						.getdIContratoAnterior() : "");
				parametros.put("dIMontoContratoAnterior", peticion.get(i)
						.getdIMontoContratoAnterior());
				parametros
						.put("dIEstatusContratoAnterior",
								peticion.get(i).getdIEstatusContratoAnterior() != null ? peticion
										.get(i).getdIEstatusContratoAnterior()
										: "");
				parametros.put("dIProductoContratoAnterior", peticion.get(i)
						.getdIProductoContratoAnterior() != null ? peticion
						.get(i).getdIProductoContratoAnterior() : "");
				parametros.put("dITipificacionProducto", peticion.get(i)
						.getdITipificacionProducto() != null ? peticion.get(i)
						.getdITipificacionProducto() : "");
				parametros.put("dIMontoSolicitado", peticion.get(i)
						.getdIMontoSolicitado());
				parametros.put("dIMontoPropuesto", peticion.get(i)
						.getdIMontoPropuesto());

				// estos tres no se mapean en el xml, estaban antes pero se
				// quitaron de la tabla
				parametros.put("dILinkEstadoCuenta", peticion.get(i)
						.getdILinkEstadoCuenta());
				parametros.put("dILinkResumenBuros", peticion.get(i)
						.getdILinkResumenBuros());
				parametros.put("dILinkBuroCredito", peticion.get(i)
						.getdILinkBuroCredito());

				// Antecedentes Finsol
				parametros.put("aFmontoUltimoCredito", peticion.get(i)
						.getaFmontoUltimoCredito());
				parametros.put("aFmaximoAtrasoUltimoCredito", peticion.get(i)
						.getaFmaximoAtrasoUltimoCredito());
				parametros.put("aFmaximoAtrasoPosteriorUltimoCredito", peticion
						.get(i).getaFmaximoAtrasoPosteriorUltimoCredito());
				parametros.put("aFmontoPenultimoCredito", peticion.get(i)
						.getaFmontoPenultimoCredito());
				parametros.put("aFmaximoAtrasoPenultimoCredito", peticion
						.get(i).getaFmaximoAtrasoPenultimoCredito());
				parametros.put("aFmaximoAtrasoPosteriorPenultimoCredito",
						peticion.get(i)
								.getaFmaximoAtrasoPosteriorPenultimoCredito());
				parametros.put("aFmontoAntepenultimoCredito", peticion.get(i)
						.getaFmontoAntepenultimoCredito());
				parametros.put("aFmaximoAtrasoAntepenultimoCredito", peticion
						.get(i).getaFmaximoAtrasoAntepenultimoCredito());
				parametros
						.put("aFmaximoAtrasoPosteriorAntepenultimoCredito",
								peticion.get(i)
										.getaFmaximoAtrasoPosteriorAntepenultimoCredito());

				// Antecedentes Sistema Financiero
				parametros.put("asFFolioConsulta", peticion.get(i)
						.getAsFFolioConsulta() != null ? peticion.get(i)
						.getAsFFolioConsulta() : "");
				parametros.put("aSFVigencia",
						peticion.get(i).getaSFVigencia() != null ? peticion
								.get(i).getaSFVigencia() : "");
				parametros.put("aSFSaldoDeudaVigente", peticion.get(i)
						.getaSFSaldoDeudaVigente());
				parametros.put("aSFSaldoDeudaVencido", peticion.get(i)
						.getaSFSaldoDeudaVencido());
				parametros.put("aSFCuotaSemanal", peticion.get(i)
						.getaSFCuotaSemanal());
				parametros.put("aSFMopMaximoAbierto", peticion.get(i)
						.getaSFMopMaximoAbierto() != null ? peticion.get(i)
						.getaSFMopMaximoAbierto() : "");
				parametros.put("aSFMopMaximoCerrado", peticion.get(i)
						.getaSFMopMaximoCerrado() != null ? peticion.get(i)
						.getaSFMopMaximoCerrado() : "");
				parametros.put("aSFMopAutomotrizHipotecario", peticion.get(i)
						.getaSFMopAutomotrizHipotecario() != null ? peticion
						.get(i).getaSFMopAutomotrizHipotecario() : "");
				parametros
						.put("aSFSaldoVenciodotrizHipotecario",
								peticion.get(i)
										.getaSFSaldoVenciodotrizHipotecario() != null ? peticion
										.get(i)
										.getaSFSaldoVenciodotrizHipotecario()
										: "");

				// Situacion Economica Financiera
				parametros.put("sECuotaSemanal", peticion.get(i)
						.getsECuotaSemanal());
				parametros.put("sETipoDomicilio", peticion.get(i)
						.getsETipoDomicilio() != null ? peticion.get(i)
						.getsETipoDomicilio() : "");
				parametros.put("sETiempoResidencia", peticion.get(i)
						.getsETiempoResidencia());
				parametros.put("sEDestinoCredito", peticion.get(i)
						.getsEDestinoCredito() != null ? peticion.get(i)
						.getsEDestinoCredito() : "");
				parametros.put("sEActividadPrimaria", peticion.get(i)
						.getsEActividadPrimaria() != null ? peticion.get(i)
						.getsEActividadPrimaria() : "");
				parametros.put("sEAntiguedadNegocio", peticion.get(i)
						.getsEAntiguedadNegocio());
				parametros.put("sEAntiguedadRubro", peticion.get(i)
						.getsEAntiguedadRubro());
				parametros.put("sETipoNegocio", peticion.get(i)
						.getsETipoNegocio() != null ? peticion.get(i)
						.getsETipoNegocio() : "");
				parametros.put("sEPorcentajeGanancia", peticion.get(i)
						.getsEPorcentajeGanancia());
				parametros.put("sEGananciaSemanalNegocio", peticion.get(i)
						.getsEGananciaSemanalNegocio());
				parametros.put("sEOtrosIngresos", peticion.get(i)
						.getsEOtrosIngresos());
				parametros.put("sEGananciaActividadSecundaria", peticion.get(i)
						.getsEGananciaActividadSecundaria());
				parametros.put("sETotalGastosFamiliares", peticion.get(i)
						.getsETotalGastosFamiliares());
				parametros.put("sEDisponibleCalculado", peticion.get(i)
						.getsEDisponibleCalculado());
				parametros.put("sEMontoDeclarado", validarDobleNan(peticion
						.get(i).getsEMontoDeclarado()));
				parametros.put("sESuperavitCuotaMonto",
						validarDobleNan(peticion.get(i)
								.getsESuperavitCuotaMonto()));
				parametros.put("sESuperavitCuotaDisponible",
						validarDobleNan(peticion.get(i)
								.getsESuperavitCuotaDisponible()));
				parametros.put("sETotalDeclaradoNegocio", peticion.get(i)
						.getsETotalDeclaradoNegocio());

				LogHandler
						.trace(uid, getClass(),
								"almacenarPlanillaAprobacionIntegrantesTarea -insertaPlanillaAprobacion");
				sesionTx.insert("insertaPlanillaAprobacion", parametros);
			}

			if (!sesionExterna) {
				sesionTx.commit(true);
			}

			respuesta
					.getHeader()
					.setMensaje(
							"Se ha insertado con exito la lista de planilla aprobacion. ");

		} catch (Exception ex) {
			if (!sesionExterna) {
				FabricaConexiones.rollBack(sesionTx);
			}
			LogHandler.error(uid, getClass(),
					"Existio un error en almacenarPlanillaAprobacionIntegrantesTarea(): "
							+ ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		} finally {
			if (!sesionExterna) {
				FabricaConexiones.close(sesionTx);
			}
		}

		return respuesta;
	}

	/**
	 * @param uid
	 *            identificador unico
	 * @param peticion
	 *            para calcular el incremento
	 * @return respuesta
	 */
	@SuppressWarnings("unchecked")
	public RespuestaReglaIncremento calculaIncrementoMontoTarea(String uid,
			PeticionReglaIncremento peticion) {
		RespuestaReglaIncremento respuesta = new RespuestaReglaIncremento();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		// Sesion no transaccional a sybase
		SqlSession sesionNTx = null;

		try {

			if (peticion.getNumeroContrato() == null
					|| peticion.getNumeroContrato().trim().isEmpty()) {
				throw new Exception(
						"El numero de contrato es necesario en la petici�n.");
			}

			if (peticion.getNumeroPersona() == null
					|| peticion.getNumeroPersona().trim().isEmpty()) {
				throw new Exception(
						"El numero de persona es necesario en la petici�n.");
			}

			// Abrimos conexion
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			// Obtener numero de contrato
			LogHandler.trace(uid, getClass(), "==> obtenerRelacionContrato");
			peticion.setNumeroContrato((String) sesionNTx.selectOne(
					"obtenerRelacionContrato", peticion.getNumeroContrato()));

			if (peticion.getNumeroContrato() == null
					|| peticion.getNumeroContrato().trim().isEmpty()) {
				throw new Exception(
						"El numero de contrato no existe en la base de datos.");
			}

			final HashMap<String, Object> pContratoIntegrante = new HashMap<String, Object>();
			pContratoIntegrante.put("contrato", peticion.getNumeroContrato());
			pContratoIntegrante.put("integrante", peticion.getNumeroPersona());

			java.util.HashMap<String, Object> datosIntegrante = (java.util.HashMap<String, Object>) sesionNTx
					.selectOne("obtenerInformacionIntegrante",
							pContratoIntegrante);

			if (datosIntegrante == null) {
				throw new Exception(
						"No existe informacion para los datos proporcionados contrato-integrante.");
			}

			InputReglasIncremento request = new InputReglasIncremento();
			request.setCiclo(Integer.valueOf(datosIntegrante.get(
					"ciclo_integrante").toString()));

			if (datosIntegrante.get("maximo_retraso") == null
					|| datosIntegrante.get("maximo_retraso").toString()
							.isEmpty()) {
				datosIntegrante.put("maximo_retraso", "0");
			}

			if (datosIntegrante.get("dias_fecha_fin") == null
					|| datosIntegrante.get("dias_fecha_fin").toString()
							.isEmpty()) {
				datosIntegrante.put("dias_fecha_fin", "0");
			}

			request.setAtrasoMaximo(Integer.valueOf(datosIntegrante.get(
					"maximo_retraso").toString()));
			request.setAtrasoFechaFin(Integer.valueOf(datosIntegrante.get(
					"dias_fecha_fin").toString()));

			/*
			 * if (request.getAtrasoMaximo() == 0 && request.getAtrasoFechaFin()
			 * >) {
			 * 
			 * }
			 */
			// request.setAtrasoMaximo( 7 );
			// request.setAtrasoFechaFin( -16 );

			LogHandler.info(uid, getClass(), "REQUEST: " + request.toString());
			RespuestaReglaIncremento respuestaOpenRules = obtenerIncremento(
					uid, request);
			respuesta.setPersona(peticion.getNumeroPersona());
			respuesta.setPorcentajeIncremento(respuestaOpenRules
					.getPorcentajeIncremento());
			respuesta.setOtorgaCredito(respuestaOpenRules.isOtorgaCredito());

		} catch (Exception ex) {
			LogHandler.error(uid, getClass(),
					"calculaIncrementoMonto: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}

		return respuesta;
	}

	/**
	 * @param uid
	 *            Identificador unico de la transaccion
	 * @param request
	 *            Peticion de reglas de incremento para el motor de reglas
	 * @return Resultado del motor de reglas
	 * @throws Exception
	 */
	public RespuestaReglaIncremento obtenerIncremento(String uid,
			InputReglasIncremento request) throws Exception {
		RespuestaReglaIncremento respuesta = new RespuestaReglaIncremento();

		String rutaOpenRules = comun.obtenerParGeneralOV(uid,
				"com.mx.finsol.ciof.ruta.openrules").getCgValor();
		// OpenRules
		String fileName = "file:" + rutaOpenRules;

		OpenRulesEngine engine = new OpenRulesEngine(fileName);
		String methodName = "obtenerReglasIncrementoAnterior";
		Response response = new Response();
		Object[] objectsPeticionPerfil = new Object[] { request, response };
		engine.run(methodName, objectsPeticionPerfil);

		LogHandler.info(uid, getClass(),
				" - OTORGA:" + response.getMap().get("otorga").toString());
		LogHandler.info(uid, getClass(), " - PORCENTAJE:"
				+ response.getMap().get("porcentaje").toString());

		if (response.getMap().get("otorga").toString().trim()
				.equals(ERROR_OPENRULES)) {
			throw new Exception("No existe el caso en las reglas de negocio");
		} else if (response.getMap().get("otorga").toString().trim()
				.equals("SI")) {
			respuesta.setPorcentajeIncremento((Double) response.getMap().get(
					"porcentaje"));
			respuesta.setOtorgaCredito(true);

		} else if (response.getMap().get("otorga").toString().trim()
				.equals("NO")) {

			respuesta.setPorcentajeIncremento(0.0);
			respuesta.setOtorgaCredito(false);
		}

		return respuesta;
	}

	/**
	 * Validar tasa interes tarea.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the peticion
	 * @return the validar tasa interes respuesta
	 */
	public ValidarTasaInteresRespuesta validarTasaInteresTarea(String uid,
			ValidarTasaInteresPeticion peticion) {

		ValidarTasaInteresRespuesta respuesta = new ValidarTasaInteresRespuesta();
		// FuncionesComunes funcionesComunes = new FuncionesComunes();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if (peticion == null || peticion.getRenovacion() == null
					|| peticion.getCampana() == null
					|| peticion.getCentralCec() == null
					|| peticion.getTasa() == null) {
				String mensajePeticion = "";
				// puede o no venir la solicitud
				if (peticion.getTasa() == null) {
					mensajePeticion = "La peticion no contiene la tasa.";
				}
				throw new Exception(
						"Los datos de la peticion son incorrectos. "
								+ mensajePeticion);
			}

			// Si no es renovacion
			if (!peticion.getRenovacion()) {
				ObtenerTasasOV tasas = obtenerTasaInteres(uid,
						peticion.getRenovacion(), peticion.getCampana(),
						peticion.getCentralCec());
				if (tasas == null) {
					throw new Exception("No se obtubo informacion de tasas");
				}

				EncabezadoRespuesta respuestaTasas = obtenerRespuestaTasas(
						peticion.getTasa(), tasas.getTasaMinima(),
						tasas.getTasaMaxima());
				respuesta.getHeader().setMensaje(respuestaTasas.getMensaje());
				respuesta.getHeader().setEstatus(respuestaTasas.isEstatus());
				respuesta.setTasaMinima(tasas.getTasaMinima());
				respuesta.setTasaMaxima(tasas.getTasaMaxima());

			} else {
				// Si es renovacion
				if (peticion.getContratoAnterior() == null) {
					throw new Exception(
							"Los datos de la peticion son incorrectos no cuenta con contrato anterior para la renovacion");
				}

				// obtenemos el contrato
				String contrato = (String) sesionNTx.selectOne(
						"obtenerRelacionContrato",
						peticion.getContratoAnterior());
				if (contrato == null || contrato.trim().isEmpty()) {
					throw new Exception(
							"El contrato de la peticion no es valido.");
				}

				// obtenemos la fecha contable
				FechaContableOV fechaContable = comun.obtenerFechaContable(uid);
				if (fechaContable == null || fechaContable.getFecha() == null) {
					throw new Exception("La fecha contable no se pudo obtener.");
				}

				// obtenemos la consulta
				java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();
				parametros.put("fechaContable",
						formatter.format(fechaContable.getFecha()));
				parametros.put("contrato", contrato);

				LogHandler
						.trace(uid, getClass(),
								"validarTasaInteresTarea: - consultaMaximoRetrasoContrato");
				LogHandler
						.info(uid, getClass(),
								"validarTasaInteresTarea: - consultaMaximoRetrasoContrato");

				RespuestaMaximoRetrasoOV resMaximoRetraso = (RespuestaMaximoRetrasoOV) sesionNTx
						.selectOne("consultaMaximoRetrasoContrato", parametros);

				if (resMaximoRetraso == null) {
					throw new Exception(
							"No existe informacion de Maximo Retraso para el contrato de la peticion");
				}

				// En credprod la tasa es mensual sin IVA
				if (resMaximoRetraso.getTasa() != null
						&& resMaximoRetraso.getNumeroSucursal() != null) {
					final HashMap<Object, Object> params = new HashMap<Object, Object>();
					params.put("sucursal", resMaximoRetraso.getNumeroSucursal());
					params.put("codigo", "IVIN");
					params.put("fecha",
							formatter.format(fechaContable.getFecha()));

					LogHandler.trace(uid, getClass(),
							"==> validarTasaInteresTarea - verValorHistorico ");
					final java.lang.Integer iva = (Integer) sesionNTx
							.selectOne("verValorHistorico", params);
					LogHandler.info(uid, getClass(),
							"IVA obtenido=" + iva + " Sucursal="
									+ resMaximoRetraso.getNumeroSucursal());
					if (iva != null) {
						Double tasa = resMaximoRetraso.getTasa()
								* (1 + (iva.doubleValue() / CIEN)) * 12;
						tasa = Math.rint(tasa * CIEN) / CIEN;
						LogHandler.info(
								uid,
								getClass(),
								"TASA anualizada con iva=" + tasa
										+ " contrato="
										+ resMaximoRetraso.getContrato());
						resMaximoRetraso.setTasa(tasa);
					} else {
						LogHandler.warn(uid, getClass(),
								"No se pudo anualizar la tasa");
						throw new Exception("No se pudo anualizar la tasa");
					}
				}

				// Se obtiene la parte de los parametros
				LogHandler.trace(uid, getClass(),
						"validarTasaInteresTarea: - consultarParametrosTasas");
				LogHandler.info(uid, getClass(),
						"validarTasaInteresTarea: - consultarParametrosTasas");

				// IN ('DILI_CRENU','PORC_CRENU')
				ObtenerParametrosTasasOV resParametros = (ObtenerParametrosTasasOV) sesionNTx
						.selectOne("consultarParametrosTasas", "DILI_CRENU");
				if (resParametros == null) {
					throw new Exception("No se pudo obtener los parametros");
				}

				// Validacion dias no renovado si es mayor a 365
				if (resMaximoRetraso.getDiasNoRenovado() > Integer
						.parseInt(resParametros.getValor())) {
					LogHandler
							.info(uid, getClass(),
									"validarTasaInteresTarea: - Renovacion dias -> nuevo");
					peticion.setRenovacion(false);
					ObtenerTasasOV tasas = obtenerTasaInteres(uid,
							peticion.getRenovacion(), peticion.getCampana(),
							peticion.getCentralCec());
					if (tasas == null) {
						throw new Exception("No se obtubo informacion de tasas");
					}

					EncabezadoRespuesta respuestaTasas = obtenerRespuestaTasas(
							peticion.getTasa(), tasas.getTasaMinima(),
							tasas.getTasaMaxima());
					respuesta.getHeader().setMensaje(
							respuestaTasas.getMensaje());
					respuesta.getHeader()
							.setEstatus(respuestaTasas.isEstatus());
					respuesta.setTasaMinima(tasas.getTasaMinima());
					respuesta.setTasaMaxima(tasas.getTasaMaxima());

				} else {
					Integer ciclo = 0;

					if (peticion.getSolicitud() != null
							&& !peticion.getSolicitud().trim().isEmpty()) {
						// ORIG-239 Tasas se agrega codigo para obtener el ciclo
						// de la solicitud y poder determinar el incremento de
						// las tasas
						parametros.put("solicitud", peticion.getSolicitud());
						SolicitudesOV resSolicitud = (SolicitudesOV) sesionNTx
								.selectOne("obtenerSolicitudTasas", parametros);

						if (resSolicitud == null) {
							throw new Exception(
									"No existe informacion de M para el contrato de la peticion");
						}

						ciclo = resSolicitud.getCiclo();

					} else {
						ciclo = resMaximoRetraso.getCiclo();
					}

					// Tasas con incremento & > 356
					ObtenerTasasOV tasasIncremento = obtenerTasaInteresIncremento(
							uid, peticion.getRenovacion(),
							peticion.getCentralCec(),
							resMaximoRetraso.getMaximoRetraso(), ciclo);
					if (tasasIncremento == null) {
						throw new Exception(
								"No se obtubo informacion de tasas incremento");
					}
					Double tasaActual = 0.0;

					if (tasasIncremento.getTasaMinima() == -1.0
							|| tasasIncremento.getTasaMinima() == null) {
						tasaActual = resMaximoRetraso.getTasa()
								+ tasasIncremento.getIncremento();
						tasaActual = roundTwoDecimals(tasaActual);

						EncabezadoRespuesta respuestaTasas = obtenerRespuestaTasas(
								peticion.getTasa(), tasaActual,
								tasasIncremento.getTasaMaxima());
						respuesta.getHeader().setMensaje(
								respuestaTasas.getMensaje());
						respuesta.getHeader().setEstatus(
								respuestaTasas.isEstatus());
						respuesta.setTasaMinima(tasaActual);
						respuesta
								.setTasaMaxima(tasasIncremento.getTasaMaxima());

					} else {

						EncabezadoRespuesta respuestaTasas = obtenerRespuestaTasas(
								peticion.getTasa(),
								tasasIncremento.getTasaMinima(),
								tasasIncremento.getTasaMaxima());
						respuesta.getHeader().setMensaje(
								respuestaTasas.getMensaje());
						respuesta.getHeader().setEstatus(
								respuestaTasas.isEstatus());
						respuesta
								.setTasaMinima(tasasIncremento.getTasaMinima());
						respuesta
								.setTasaMaxima(tasasIncremento.getTasaMaxima());

					} // fin else NA
				} // fin dias no renovado 365
			} // fin else renovacion

			/* ORIG-303 topar tasa LRSS 02/dic/2015 */
			LogHandler.info(uid, this.getClass(), respuesta.toString());
			ParGeneralOV tasaProductos = comun.obtenerParGeneralOV(uid,
					"TASA_MAXIMA_PRODUCTOS");
			Double tasaMaxima = Double.parseDouble(tasaProductos.getCgValor());
			boolean cambiaTasa = false;
			LogHandler
					.info(uid, this.getClass(), tasaMaxima.doubleValue() + "");
			LogHandler.info(uid, this.getClass(), respuesta.getTasaMaxima()
					.doubleValue() + "");
			LogHandler.info(uid, this.getClass(), respuesta.getTasaMinima()
					.doubleValue() + "");

			if (respuesta.getTasaMaxima().doubleValue() > tasaMaxima
					.doubleValue()) {
				respuesta.setTasaMaxima(tasaMaxima);
			}

			if (respuesta.getTasaMinima().doubleValue() > tasaMaxima
					.doubleValue()) {
				respuesta.setTasaMinima(tasaMaxima);
			}

			if (peticion.getTasa().doubleValue() > respuesta.getTasaMaxima()
					.doubleValue()) {
				respuesta.getHeader().setEstatus(false);
				cambiaTasa = true;
			}

			if (peticion.getTasa().doubleValue() < respuesta.getTasaMinima()
					.doubleValue()) {
				respuesta.getHeader().setEstatus(false);
				cambiaTasa = true;
			}

			if (cambiaTasa) {
				LogHandler.info(uid, this.getClass(), "cambiaTasa");
				respuesta.getHeader().setMensaje(
						"Tasa debe estar en el rango de "
								+ respuesta.getTasaMinima().toString() + " y "
								+ respuesta.getTasaMaxima().toString());
			}

		} catch (Exception exception) {
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(
					"Error en validarTasaInteresTarea : "
							+ exception.getMessage());
			respuesta.getHeader().setEstatus(false);
			LogHandler.error(
					uid,
					this.getClass(),
					"Error en validarTasaInteresTarea : "
							+ exception.getMessage(), exception);
		} finally {
			FabricaConexiones.close(sesionNTx);
		}

		return respuesta;
	}

	/**
	 * Obtener respuesta tasas.
	 *
	 * @param tasa
	 *            the tasa
	 * @param tasaMinima
	 *            the tasa minima
	 * @param tasaMaxima
	 *            the tasa maxima
	 * @return the encabezado respuesta
	 * @throws Exception
	 */
	public EncabezadoRespuesta obtenerRespuestaTasas(Double tasa,
			Double tasaMinima, Double tasaMaxima) throws Exception {
		/* ORIG-303 topar tasa LRSS 02/dic/2015 */
		ParGeneralOV tasaProductos = comun.obtenerParGeneralOV("",
				"TASA_MAXIMA_PRODUCTOS");
		Double tasaMaximaProductos = Double.parseDouble(tasaProductos
				.getCgValor());

		if (tasaMinima > tasaMaximaProductos) {
			tasaMinima = tasaMaximaProductos;
		}

		if (tasaMaxima > tasaMaximaProductos) {
			tasaMaxima = tasaMaximaProductos;
		}

		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();

		if (tasaMinima <= tasa & tasa <= tasaMaxima) {
			respuesta.setMensaje("Tasa dentro de politica");
			respuesta.setEstatus(true);
		} else {
			respuesta.setMensaje("Tasa debe estar en el rango de " + tasaMinima
					+ " y " + tasaMaxima);
			respuesta.setEstatus(false);
		}

		return respuesta;
	}

	/**
	 * Obtener tasa interes.
	 *
	 * @param uid
	 *            the uid
	 * @param renovacion
	 *            the renovacion
	 * @param campana
	 *            the campana
	 * @param centralCec
	 *            the central cec
	 * @return the obtener tasas ov
	 */
	public ObtenerTasasOV obtenerTasaInteres(String uid, boolean renovacion,
			boolean campana, boolean centralCec) throws Exception {

		ObtenerTasasOV respuesta = new ObtenerTasasOV();
		String rutaOpenRules = comun.obtenerParGeneralOV(uid,
				"com.mx.finsol.ciof.ruta.openrules").getCgValor();
		// OpenRules
		String fileName = "file:" + rutaOpenRules;

		LogHandler.info(uid, getClass(), fileName);

		OpenRulesEngine engine = new OpenRulesEngine(fileName);
		String methodName = "obtenerTasaInteres";
		Response response = new Response();
		InputReglasTasaInteres request = new InputReglasTasaInteres();
		request.setRenovacion(renovacion);
		request.setCampana(campana);
		request.setCentralCec(centralCec);
		Object[] objectsPeticionPerfil = new Object[] { request, response };

		engine.run(methodName, objectsPeticionPerfil);

		if (response.getMap().get("tasaMinima") == null) {
			respuesta.setTasaMinima(0.0);
		} else {
			respuesta.setTasaMinima(Double.valueOf(response.getMap()
					.get("tasaMinima").toString()));
		}

		LogHandler.info(uid, getClass(), "tasaMinima: " + respuesta);

		if (response.getMap().get("tasaMaxima") == null) {
			respuesta.setTasaMaxima(0.0);
		} else {
			respuesta.setTasaMaxima(Double.valueOf(response.getMap()
					.get("tasaMaxima").toString()));
		}

		LogHandler.info(uid, getClass(), "tasaMaximaSuc: " + respuesta);

		return respuesta;
	}

	/**
	 * Obtener tasa interes incremento.
	 *
	 * @param uid
	 *            the uid
	 * @param renovacion
	 *            the renovacion
	 * @param centralCec
	 *            the central cec
	 * @param atraso
	 *            the atraso
	 * @param ciclo
	 *            .
	 * @return the obtener tasas ov
	 */
	public ObtenerTasasOV obtenerTasaInteresIncremento(String uid,
			boolean renovacion, boolean centralCec, Integer atraso,
			Integer ciclo) throws Exception {

		ObtenerTasasOV respuesta = new ObtenerTasasOV();
		String rutaOpenRules = comun.obtenerParGeneralOV(uid,
				"com.mx.finsol.ciof.ruta.openrules").getCgValor();
		// String rutaOpenRules = "C:/rulesFinsol/RNFinsol.xls";

		// OpenRules
		String fileName = "file:" + rutaOpenRules;

		LogHandler.info(uid, getClass(), fileName);

		OpenRulesEngine engine = new OpenRulesEngine(fileName);
		String methodName = "obtenerTasaInteresIncremento";
		Response response = new Response();
		InputReglasTasaInteres request = new InputReglasTasaInteres();
		request.setRenovacion(renovacion);
		request.setCentralCec(centralCec);
		double d = atraso.doubleValue();
		request.setAtraso(d);
		request.setCiclo(ciclo);

		LogHandler.info(uid, getClass(), "renovacion=" + request.isRenovacion()
				+ " centralCec=" + request.isCentralCec() + " atraso "
				+ request.getAtraso() + " ciclo " + request.getCiclo());

		Object[] objectsPeticionPerfil = new Object[] { request, response };

		engine.run(methodName, objectsPeticionPerfil);
		if (response.getMap().get("incremento") == null) {
			respuesta.setIncremento(0.0);
		} else {
			respuesta.setIncremento(Double.valueOf(response.getMap()
					.get("incremento").toString()));
		}

		LogHandler.info(uid, getClass(),
				"incremento: " + respuesta.getIncremento());

		if (response.getMap().get("tasaMinima") == null) {
			respuesta.setTasaMinima(0.0);
		} else {
			if (response.getMap().get("tasaMinima").toString().equals("NA")) {
				respuesta.setTasaMinima(-1.0);
			} else {
				respuesta.setTasaMinima(Double.valueOf(response.getMap()
						.get("tasaMinima").toString()));
			}
		}

		LogHandler.info(uid, getClass(),
				"tasaMinima: " + respuesta.getTasaMinima());

		if (response.getMap().get("tasaMaxima") == null) {
			respuesta.setTasaMaxima(0.0);
		} else {
			respuesta.setTasaMaxima(Double.valueOf(response.getMap()
					.get("tasaMaxima").toString()));
		}

		LogHandler.info(uid, getClass(),
				"tasaMaximaSuc: " + respuesta.getTasaMaxima());

		LogHandler.info(uid, getClass(),
				"obtenerTasaInteresIncremento: respuesta=" + respuesta);

		return respuesta;
	}

	/**
	 * Validar tasa interes tarea.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the peticion
	 * @return the validar tasa interes respuesta
	 */
	@SuppressWarnings("unchecked")
	public ValidarTasaInteresRespuesta validarTasaConfirmarTarea(String uid,
			ValidarTasaInteresPeticion peticion) {

		ValidarTasaInteresRespuesta respuesta = new ValidarTasaInteresRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		int numeroIntegrantes;
		// FuncionesComunes funcionesComunes = new FuncionesComunes();
		// SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if (peticion == null || peticion.getCentralCec() == null) {
				throw new Exception("Los datos de la peticion son incorrectos");
			}
			if (peticion.getSolicitud() == null
					|| peticion.getSolicitud().trim().isEmpty()) {
				throw new Exception(
						"La solicitud es obligatoria en la peticion.");
			}

			/*
			 * if (peticion.getTasa() == null || peticion.getTasa() <= 0) {
			 * throw new Exception("La tasa es obligatoria en la peticion."); }
			 */

			if (peticion.getIntegrantes() <= 0) {
				throw new Exception(
						"El numero de integrantes es obligatoria en la peticion.");
			}

			peticion.setRenovacion(true);

			// obtenemos la consulta
			java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();
			parametros.put("solicitud", peticion.getSolicitud());

			LogHandler
					.trace(uid, getClass(),
							"validarTasaConfirmarTarea: - obtenerSolicitudTasasInteres");
			LogHandler
					.info(uid, getClass(),
							"validarTasaConfirmarTarea: - obtenerSolicitudTasasInteres");

			RespuestaSolicitudTasasOV resSolicitud = (RespuestaSolicitudTasasOV) sesionNTx
					.selectOne("obtenerSolicitudTasasInteres", parametros);

			if (resSolicitud == null) {
				throw new Exception("No existen datos para la solicitud");
			}
			// centralCec ya
			peticion.setRenovacion(resSolicitud.getRenovacion());
			peticion.setContratoAnterior(resSolicitud.getContrato());
			// Se deja la tasa y campa�a que se envia en la peticion
			// peticion.setCampana(resSolicitud.getCampana());
			// peticion.setTasa(resSolicitud.getTasa());

			if (resSolicitud.getContrato().equals("false")
					|| resSolicitud.getContrato() == null) {
				peticion.setRenovacion(false);

				// Obtener Integrantes de la Solicitud
				// obtenemos la consulta
				/*
				 * java.util.HashMap<String, Object> parametrosIntegrantes = new
				 * java.util.HashMap<String, Object>();
				 * parametrosIntegrantes.put("solicitud",
				 * peticion.getSolicitud());
				 * 
				 * LogHandler.trace(uid, getClass(),
				 * "validarTasaConfirmarTarea: - obtenerIntegrantesSolicitudTasas"
				 * ); LogHandler.info(uid, getClass(),
				 * "validarTasaConfirmarTarea: - obtenerIntegrantesSolicitudTasas"
				 * );
				 * 
				 * Integer resIntegrantes = (Integer)
				 * sesionNTx.selectOne("obtenerIntegrantesSolicitudTasas",
				 * parametrosIntegrantes);
				 * 
				 * if (resIntegrantes == null || resIntegrantes == 0) { throw
				 * new Exception("No existen integrantes para la solicitud"); }
				 * numeroIntegrantes = resIntegrantes;
				 */
				// Se coloca el numero de integrantes de la peticion.
				numeroIntegrantes = peticion.getIntegrantes();

			} else {
				// Codigo para validar 50% integrantes
				// obtenemos la consulta
				java.util.HashMap<String, Object> parametrosIntegrantes = new java.util.HashMap<String, Object>();
				parametrosIntegrantes.put("solicitud", peticion.getSolicitud());
				parametrosIntegrantes.put("contratoAnterior",
						resSolicitud.getContrato());

				LogHandler
						.trace(uid, getClass(),
								"validarTasaConfirmarTarea: - obtenerIntegrantesCreditoAnteriorTasas");
				LogHandler
						.info(uid, getClass(),
								"validarTasaConfirmarTarea: - obtenerIntegrantesCreditoAnteriorTasas");

				List<RespuestaIntegrantesTasasOV> resIntegrantes = sesionNTx
						.selectList("obtenerIntegrantesCreditoAnteriorTasas",
								parametrosIntegrantes);

				if (resIntegrantes == null || resIntegrantes.size() == 0) {
					throw new Exception(
							"No existen integrantes para la solicitud");
				}

				// Se obtiene la parte de los parametros
				LogHandler
						.trace(uid, getClass(),
								"validarTasaConfirmarTarea: - consultarParametrosTasas");
				LogHandler
						.info(uid, getClass(),
								"validarTasaConfirmarTarea: - consultarParametrosTasas");

				// IN ('DILI_CRENU','PORC_CRENU')
				ObtenerParametrosTasasOV resParametros = (ObtenerParametrosTasasOV) sesionNTx
						.selectOne("consultarParametrosTasas", "PORC_CRENU");
				if (resParametros == null) {
					throw new Exception("No se pudo obtener los parametros");
				}

				// resSolicitud.getNumeroIntegrantes() numero integrantes
				// contrato anterior
				// resIntegrantes.size() numero de integrantes que si renuevan

				Float integrantes50 = (float) (resSolicitud
						.getNumeroIntegrantes() * Double.valueOf(resParametros
						.getValor()));
				integrantes50 = integrantes50 / CIEN;

				LogHandler.info(uid, getClass(), "integrantes Anterior: "
						+ resSolicitud.getNumeroIntegrantes());
				LogHandler.info(uid, getClass(), "integrantes al 50%: "
						+ integrantes50);

				if (resIntegrantes.size() >= integrantes50) {
					peticion.setRenovacion(true);
				} else {
					peticion.setRenovacion(false);
				}

				// numeroIntegrantes = resIntegrantes.size();
				numeroIntegrantes = peticion.getIntegrantes();

			}
			LogHandler.info(
					uid,
					getClass(),
					"validarTasaConfirmarTarea: renovacion="
							+ peticion.getRenovacion());

			LogHandler.info(uid, getClass(),
					"validarTasaConfirmarTarea: - numeroIntegrantes="
							+ numeroIntegrantes);

			if (!peticion.getRenovacion()) {

				if (peticion.getCentralCec() || peticion.getCampana()) {

					ValidarTasaInteresRespuesta miValidacionTasa = validarTasaInteresTarea(
							uid, peticion);
					respuesta.getHeader().setMensaje(
							miValidacionTasa.getHeader().getMensaje());
					respuesta.getHeader().setEstatus(
							miValidacionTasa.getHeader().isEstatus());
					respuesta.setTasaMinima(miValidacionTasa.getTasaMinima());
					respuesta.setTasaMaxima(miValidacionTasa.getTasaMaxima());

				} else {

					ObtenerTasasOV tasas = obtenerTasaInteresIntegrantes(uid,
							numeroIntegrantes);
					if (tasas == null) {
						throw new Exception("No se obtuvo informacion de tasas");
					}

					EncabezadoRespuesta respuestaTasas = obtenerRespuestaTasas(
							peticion.getTasa(), tasas.getTasaMinima(),
							tasas.getTasaMaxima());
					respuesta.getHeader().setMensaje(
							respuestaTasas.getMensaje());
					respuesta.getHeader()
							.setEstatus(respuestaTasas.isEstatus());
					respuesta.setTasaMinima(tasas.getTasaMinima());
					respuesta.setTasaMaxima(tasas.getTasaMaxima());
				}
			} else {

				ValidarTasaInteresRespuesta miValidacionTasa = validarTasaInteresTarea(
						uid, peticion);
				respuesta.getHeader().setMensaje(
						miValidacionTasa.getHeader().getMensaje());
				respuesta.getHeader().setEstatus(
						miValidacionTasa.getHeader().isEstatus());
				respuesta.setTasaMinima(miValidacionTasa.getTasaMinima());
				respuesta.setTasaMaxima(miValidacionTasa.getTasaMaxima());

			}

			/* ORIG-303 topar tasa LRSS 02/dic/2015 */
			ParGeneralOV tasaProductos = comun.obtenerParGeneralOV(uid,
					"TASA_MAXIMA_PRODUCTOS");
			Double tasaMaxima = Double.parseDouble(tasaProductos.getCgValor());
			boolean cambiaTasa = false;
			if (respuesta.getTasaMaxima().doubleValue() > tasaMaxima
					.doubleValue()) {
				respuesta.setTasaMaxima(tasaMaxima);
			}

			if (respuesta.getTasaMinima().doubleValue() > tasaMaxima
					.doubleValue()) {
				respuesta.setTasaMinima(tasaMaxima);
			}

			if (peticion.getTasa().doubleValue() > respuesta.getTasaMaxima()
					.doubleValue()) {
				respuesta.getHeader().setEstatus(false);
				cambiaTasa = true;
			}

			if (peticion.getTasa().doubleValue() < respuesta.getTasaMinima()
					.doubleValue()) {
				respuesta.getHeader().setEstatus(false);
				cambiaTasa = true;
			}

			if (cambiaTasa) {
				respuesta.getHeader().setMensaje(
						"Tasa debe estar en el rango de "
								+ respuesta.getTasaMinima().toString() + " y"
								+ respuesta.getTasaMaxima().toString());
			}

		} catch (Exception exception) {
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(exception.getMessage());
			respuesta.getHeader().setEstatus(false);
			LogHandler.error(
					uid,
					this.getClass(),
					"Error en validarTasaConfirmarTarea : "
							+ exception.getMessage(), exception);
		} finally {
			FabricaConexiones.close(sesionNTx);
		}

		return respuesta;
	}

	/**
	 * Obtener tasa interes integrantes.
	 *
	 * @param uid
	 *            the uid
	 * @param numeroIntegrantes
	 *            the numero integrantes
	 * @return the obtener tasas ov
	 */
	public ObtenerTasasOV obtenerTasaInteresIntegrantes(String uid,
			int numeroIntegrantes) throws Exception {

		LogHandler.info(uid, getClass(), "Entra obtenerTasaInteresIntegrantes");

		ObtenerTasasOV respuesta = new ObtenerTasasOV();
		String rutaOpenRules = comun.obtenerParGeneralOV(uid,
				"com.mx.finsol.ciof.ruta.openrules").getCgValor();
		// OpenRules
		String fileName = "file:" + rutaOpenRules;

		LogHandler.info(uid, getClass(), fileName);

		OpenRulesEngine engine = new OpenRulesEngine(fileName);
		String methodName = "obtenerTasaInteresIntegrantes";
		Response response = new Response();
		InputReglasTasaInteres request = new InputReglasTasaInteres();
		request.setNumeroIntegrantes(numeroIntegrantes);

		Object[] objectsPeticionPerfil = new Object[] { request, response };

		engine.run(methodName, objectsPeticionPerfil);

		if (response.getMap().get("tasaMinima") == null) {
			respuesta.setTasaMinima(0.0);
		} else {
			respuesta.setTasaMinima(Double.valueOf(response.getMap()
					.get("tasaMinima").toString()));
		}

		LogHandler.info(uid, getClass(), "tasaMinima: " + respuesta);

		if (response.getMap().get("tasaMaxima") == null) {
			respuesta.setTasaMaxima(0.0);
		} else {
			respuesta.setTasaMaxima(Double.valueOf(response.getMap()
					.get("tasaMaxima").toString()));
		}

		LogHandler.info(uid, getClass(), "tasaMaximaSuc: " + respuesta);

		return respuesta;
	}

	public RespuestaAlmacenarPlanillaAprobacion almacenarPlanillaAprobacionTarea(
			String uid, List<IntegrantePlanillaAprobacionDTO> peticion,
			String solicitud, SqlSession sesion) {

		RespuestaAlmacenarPlanillaAprobacion respuesta = new RespuestaAlmacenarPlanillaAprobacion();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionTx = null;

		boolean sesionExterna = false;

		try {
			// Se abre la conexion hacia la base de datos
			if (sesion == null) {
				sesionTx = FabricaConexiones.obtenerSesionTx();
			} else {
				sesionTx = sesion;
				sesionExterna = true;
			}
			if (peticion.size() == 0 || peticion == null) {
				throw new Exception("La lista de integrantes esta vacia");
			}

			for (int i = 0; i < peticion.size(); i++) {
				// parametros de consulta
				final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
				// solicitudesPeticion.getMotivo() != null ?
				// solicitudesPeticion.getMotivo() : "");
				parametros.put("solicitud", solicitud != null ? solicitud : "");
				parametros.put("persona",
						peticion.get(i).getPersona() != null ? peticion.get(i)
								.getPersona() : "");
				parametros.put("claveClienteUnico", peticion.get(i)
						.getClaveClienteUnico() != null ? peticion.get(i)
						.getClaveClienteUnico() : "");

				// Datos por Integrante
				parametros.put("dINombreCliente", peticion.get(i)
						.getdINombreCliente() != null ? peticion.get(i)
						.getdINombreCliente() : "");
				parametros.put("dIEdad", peticion.get(i).getdIEdad());
				parametros.put("dIEstadoCivil", peticion.get(i)
						.getdIEstadoCivil() != null ? peticion.get(i)
						.getdIEstadoCivil() : "");
				parametros.put("dICiclo", peticion.get(i).getdICiclo());
				parametros.put("dIContratoAnterior", peticion.get(i)
						.getdIContratoAnterior() != null ? peticion.get(i)
						.getdIContratoAnterior() : "");
				parametros.put("dIMontoContratoAnterior", peticion.get(i)
						.getdIMontoContratoAnterior());
				parametros
						.put("dIEstatusContratoAnterior",
								peticion.get(i).getdIEstatusContratoAnterior() != null ? peticion
										.get(i).getdIEstatusContratoAnterior()
										: "");
				parametros.put("dIProductoContratoAnterior", peticion.get(i)
						.getdIProductoContratoAnterior() != null ? peticion
						.get(i).getdIProductoContratoAnterior() : "");
				parametros.put("dITipificacionProducto", peticion.get(i)
						.getdITipificacionProducto() != null ? peticion.get(i)
						.getdITipificacionProducto() : "");
				parametros.put("dIMontoSolicitado", peticion.get(i)
						.getdIMontoSolicitado());
				parametros.put("dIMontoPropuesto", peticion.get(i)
						.getdIMontoPropuesto());

				// estos tres no se mapean en el xml, estaban antes pero se
				// quitaron de la tabla
				parametros.put("dILinkEstadoCuenta", peticion.get(i)
						.getdILinkEstadoCuenta());
				parametros.put("dILinkResumenBuros", peticion.get(i)
						.getdILinkResumenBuros());
				parametros.put("dILinkBuroCredito", peticion.get(i)
						.getdILinkBuroCredito());

				// Antecedentes Finsol
				parametros.put("aFmontoUltimoCredito", peticion.get(i)
						.getaFmontoUltimoCredito());
				parametros.put("aFmaximoAtrasoUltimoCredito", peticion.get(i)
						.getaFmaximoAtrasoUltimoCredito());
				parametros.put("aFmaximoAtrasoPosteriorUltimoCredito", peticion
						.get(i).getaFmaximoAtrasoPosteriorUltimoCredito());
				parametros.put("aFmontoPenultimoCredito", peticion.get(i)
						.getaFmontoPenultimoCredito());
				parametros.put("aFmaximoAtrasoPenultimoCredito", peticion
						.get(i).getaFmaximoAtrasoPenultimoCredito());
				parametros.put("aFmaximoAtrasoPosteriorPenultimoCredito",
						peticion.get(i)
								.getaFmaximoAtrasoPosteriorPenultimoCredito());
				parametros.put("aFmontoAntepenultimoCredito", peticion.get(i)
						.getaFmontoAntepenultimoCredito());
				parametros.put("aFmaximoAtrasoAntepenultimoCredito", peticion
						.get(i).getaFmaximoAtrasoAntepenultimoCredito());
				parametros
						.put("aFmaximoAtrasoPosteriorAntepenultimoCredito",
								peticion.get(i)
										.getaFmaximoAtrasoPosteriorAntepenultimoCredito());

				// Antecedentes Sistema Financiero
				parametros.put("asFFolioConsulta", peticion.get(i)
						.getAsFFolioConsulta() != null ? peticion.get(i)
						.getAsFFolioConsulta() : "");
				parametros.put("aSFVigencia",
						peticion.get(i).getaSFVigencia() != null ? peticion
								.get(i).getaSFVigencia() : "");
				parametros.put("aSFSaldoDeudaVigente", peticion.get(i)
						.getaSFSaldoDeudaVigente());
				parametros.put("aSFSaldoDeudaVencido", peticion.get(i)
						.getaSFSaldoDeudaVencido());
				parametros.put("aSFCuotaSemanal", peticion.get(i)
						.getaSFCuotaSemanal());
				parametros.put("aSFMopMaximoAbierto", peticion.get(i)
						.getaSFMopMaximoAbierto() != null ? peticion.get(i)
						.getaSFMopMaximoAbierto() : "");
				parametros.put("aSFMopMaximoCerrado", peticion.get(i)
						.getaSFMopMaximoCerrado() != null ? peticion.get(i)
						.getaSFMopMaximoCerrado() : "");
				parametros.put("aSFMopAutomotrizHipotecario", peticion.get(i)
						.getaSFMopAutomotrizHipotecario() != null ? peticion
						.get(i).getaSFMopAutomotrizHipotecario() : "");
				parametros
						.put("aSFSaldoVenciodotrizHipotecario",
								peticion.get(i)
										.getaSFSaldoVenciodotrizHipotecario() != null ? peticion
										.get(i)
										.getaSFSaldoVenciodotrizHipotecario()
										: "");

				// Situacion Economica Financiera
				parametros.put("sECuotaSemanal", peticion.get(i)
						.getsECuotaSemanal());
				parametros.put("sETipoDomicilio", peticion.get(i)
						.getsETipoDomicilio() != null ? peticion.get(i)
						.getsETipoDomicilio() : "");
				parametros.put("sETiempoResidencia", peticion.get(i)
						.getsETiempoResidencia());
				parametros.put("sEDestinoCredito", peticion.get(i)
						.getsEDestinoCredito() != null ? peticion.get(i)
						.getsEDestinoCredito() : "");
				parametros.put("sEActividadPrimaria", peticion.get(i)
						.getsEActividadPrimaria() != null ? peticion.get(i)
						.getsEActividadPrimaria() : "");
				parametros.put("sEAntiguedadNegocio", peticion.get(i)
						.getsEAntiguedadNegocio());
				parametros.put("sEAntiguedadRubro", peticion.get(i)
						.getsEAntiguedadRubro());
				parametros.put("sETipoNegocio", peticion.get(i)
						.getsETipoNegocio() != null ? peticion.get(i)
						.getsETipoNegocio() : "");
				parametros.put("sEPorcentajeGanancia", peticion.get(i)
						.getsEPorcentajeGanancia());
				parametros.put("sEGananciaSemanalNegocio", peticion.get(i)
						.getsEGananciaSemanalNegocio());
				parametros.put("sEOtrosIngresos", peticion.get(i)
						.getsEOtrosIngresos());
				parametros.put("sEGananciaActividadSecundaria", peticion.get(i)
						.getsEGananciaActividadSecundaria());
				parametros.put("sETotalGastosFamiliares", peticion.get(i)
						.getsETotalGastosFamiliares());
				parametros.put("sEDisponibleCalculado", peticion.get(i)
						.getsEDisponibleCalculado());
				parametros.put("sEMontoDeclarado", validarDobleNan(peticion
						.get(i).getsEMontoDeclarado()));
				parametros.put("sESuperavitCuotaMonto",
						validarDobleNan(peticion.get(i)
								.getsESuperavitCuotaMonto()));
				parametros.put("sESuperavitCuotaDisponible",
						validarDobleNan(peticion.get(i)
								.getsESuperavitCuotaDisponible()));
				parametros.put("sETotalDeclaradoNegocio", peticion.get(i)
						.getsETotalDeclaradoNegocio());

				LogHandler
						.trace(uid, getClass(),
								"==> almacenarPlanillaAprobacionTarea - insertaPlanillaAprobacion");
				sesionTx.insert("insertaPlanillaAprobacion", parametros);
			}

			if (!sesionExterna) {
				sesionTx.commit(true);
			}

			respuesta
					.getHeader()
					.setMensaje(
							"Se ha insertado con exito la lista de planilla aprobacion. ");

		} catch (Exception ex) {
			if (!sesionExterna) {
				FabricaConexiones.rollBack(sesionTx);
			}
			LogHandler.error(uid, getClass(),
					"Existio un error en almacenarPlanillaAprobacionTarea(): "
							+ ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		} finally {
			if (!sesionExterna) {
				FabricaConexiones.close(sesionTx);
			}
		}

		return respuesta;
	}

	/**
	 * Metodo para validar los productos comunal y solidario con las reglas de
	 * renovaciones express, para simplificacion de renovacion 2
	 * 
	 * @param uid
	 *            para el log
	 * @param peticion
	 *            contrato y solicitud
	 * @param sesion
	 *            pasada por el metodo invocador
	 * @return monto maximo
	 */
	@SuppressWarnings("unchecked")
	public ValidaIntegranteRespuesta validarSimplificacionComunalSolidario(
			final String uid, final ValidaIntegrantePeticion peticion,
			final SqlSession sesion) {
		java.util.HashMap<String, Object> peticionParametros = null;
		List<HashMap<String, Object>> datosSolicitud = null;
		ValidaIntegranteRespuesta respuesta = null;
		ValidaIntegranteDTO datosIntegrante = null;
		DecimalFormat formateador = null;
		Date fechaContable = null;
		String rutaOpenRules = "";
		String fileName = "";
		try {
			LogHandler.info(uid, getClass(),
					"validarSimplificacionComunalSolidario - Entra");
			respuesta = new ValidaIntegranteRespuesta();
			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setEstatus(true);

			// OPEN RULES RULEIRAS
			rutaOpenRules = comun.obtenerParGeneralOV(uid,
					"com.mx.finsol.ciof.ruta.openrules").getCgValor();
			// rutaOpenRules = "C:/rulesFinsol/RNFinsol.xls";

			fileName = "file:" + rutaOpenRules;
			LogHandler
					.info(uid, getClass(), "OPEN RULES FILE NAME=" + fileName);
			if (fileName == null || fileName.trim().isEmpty()) {
				throw new Exception(
						"No fue posible recuperar la ruta del archivo de reglas de negocio.");
			}

			fechaContable = (Date) sesion.selectOne("consultaPrGetFecha");
			if (fechaContable == null) {
				throw new Exception("No se pudo recuperar la fecha contable.");
			}

			// Obtener datos persona
			peticionParametros = new java.util.HashMap<String, Object>();
			LogHandler.info(uid, getClass(),
					"validarSimplificacionComunalSolidario:"
							+ " fechaContable: " + fechaContable);
			peticionParametros.put("fechaContable", fechaContable);
			peticionParametros.put("persona", peticion.getPersona().trim());
			LogHandler.trace(uid, getClass(),
					"validarSimplificacionComunalSolidario:"
							+ " - datosIntegranteValidar");
			datosIntegrante = (ValidaIntegranteDTO) sesion.selectOne(
					"datosIntegranteValidar", peticionParametros);
			if (datosIntegrante == null) {
				throw new Exception("El cliente solicitado no existe.");
			}

			// Obtenemos datos de la solicitud
			LogHandler
					.trace(uid, getClass(),
							"validarSimplificacionComunalSolidario: - obtieneExpressSolicitud");
			datosSolicitud = (List<HashMap<String, Object>>) sesion.selectList(
					"obtieneExpressSolicitud", peticion.getSolicitud());

			if (datosSolicitud == null || datosSolicitud.isEmpty()) {
				throw new Exception(
						"No fue posible obtener los datos de la solicitud.");
			}

			LogHandler.trace(uid, getClass(),
					"validacionSolicitudExpress: - obtenerParGeneral");
			ParGeneralOV montoMaximo = comun.obtenerParGeneralOV(uid,
					"RE_MONTOMA");

			if (montoMaximo == null
					|| montoMaximo.getCgValor().trim().isEmpty()) {
				throw new Exception(
						"No fue posible obtener los parametros para la validacion "
								+ "RE_MONTOMAX.");
			}
			double dMontoMaximo = Double.parseDouble(montoMaximo.getCgValor()
					.trim());

			double incremento = 0;
			InputReglasIncremento inputReglas = new InputReglasIncremento();

			// Se genera el input para las reglas de incrementos
			inputReglas.setCiclo(datosIntegrante.getCiclo());
			inputReglas.setAtrasoMaximo(Integer.parseInt(datosSolicitud.get(0)
					.get("maximoAtraso").toString()));
			inputReglas.setAtrasoFechaFin(Integer.parseInt(datosSolicitud
					.get(0).get("atrasoFechaFin").toString()));
			// MIMH 20140923
			inputReglas
					.setAtrasoFechaFin(inputReglas.getAtrasoFechaFin() < 0 ? 0
							: inputReglas.getAtrasoFechaFin());
			inputReglas.setMontoManejado(datosIntegrante.getMontoBase());

			// validacion si en el ciclo 1 manejaron mas de 10,000 - Caso
			// Especial
			if (datosIntegrante.getCiclo() >= 1
					&& datosIntegrante.getCiclo() <= 2
					&& datosIntegrante.getMontoBase() < 10000) {
				LogHandler
						.info(uid,
								getClass(),
								"Se verifica si el cliente en ciclo 1 o 2 manejo mas de 10000 en el primer ciclo.");
				// obtenemos su monto manejado en ciclo = 1
				Double montoPrimerCiclo = (Double) sesion
						.selectOne("obtenerMontoPrimerCiclo", peticion
								.getPersona().trim());
				if (montoPrimerCiclo.doubleValue() >= 10000) {
					LogHandler
							.info(uid, getClass(),
									"El cliente si manejo mas de 10000 en el primer ciclo.");
					inputReglas
							.setMontoManejado(montoPrimerCiclo.doubleValue());
				}
			}

			// OpenRules
			OpenRulesEngine engine = new OpenRulesEngine(fileName);
			String methodName = "obtenerReglasIncremento";
			Response response = new Response();
			LogHandler.info(uid, getClass(), "Input Reglas=" + inputReglas);
			Object[] objects = new Object[] { inputReglas, response };

			engine.run(methodName, objects);

			LogHandler
					.info(uid, getClass(),
							"validarSimplificacionComunalSolidario: Resultado OPENRULES");
			LogHandler.info(uid, getClass(),
					"validarSimplificacionComunalSolidario: Porcentaje="
							+ response.getMap().get("porcentaje").toString());
			LogHandler.info(uid, getClass(),
					"validarSimplificacionComunalSolidario: Maximo="
							+ response.getMap().get("maximo").toString());
			LogHandler.info(uid, getClass(),
					"validarSimplificacionComunalSolidario: Error="
							+ response.getMap().get("error").toString());
			LogHandler.info(uid, getClass(),
					"validarSimplificacionComunalSolidario: Otorga="
							+ response.getMap().get("otorga").toString());

			if (response.getMap().get("otorga").toString().trim().equals("NO")) {
				throw new Exception(
						"El cliente incumple con la regla de incremento, "
								+ response.getMap().get("error").toString()
								+ ". [" + datosIntegrante.getNombreCompleto()
								+ "]");
			}

			incremento = Double.parseDouble(response.getMap().get("porcentaje")
					.toString());

			boolean errorExtra = false;
			String errorMensajeExtra = "";

			double maximo = datosIntegrante.getMontoBase()
					* ((incremento / CIEN) + 1);
			LogHandler.info(uid, getClass(),
					"validarSimplificacionComunalSolidario: Maximo=" + maximo);
			maximo = incrementoRedondeo(maximo);
			LogHandler.info(uid, getClass(),
					"validarSimplificacionComunalSolidario: Maximo Redondeo="
							+ maximo);
			LogHandler.info(uid, getClass(),
					"validarSimplificacionComunalSolidario: Base="
							+ datosIntegrante.getMontoBase());

			if (Double.parseDouble(response.getMap().get("maximo").toString()) > maximo) {
				maximo = Double.parseDouble(response.getMap().get("maximo")
						.toString());
			}
			// Se valida si los clientes ya manejan mas del monto maximo 60,000
			if (datosIntegrante.getMontoBase() > dMontoMaximo) {
				maximo = datosIntegrante.getMontoBase();
			} else if (maximo > dMontoMaximo) {
				maximo = dMontoMaximo;
			}

			LogHandler.info(uid, getClass(),
					"validarSimplificacionComunalSolidario: Maximo Final="
							+ maximo);

			if (peticion.getMonto() > maximo) {

				throw new Exception(
						"El cliente incumple con la regla de incremento, "
								+ (!errorExtra ? response.getMap().get("error")
										.toString() : errorMensajeExtra)
								+ ", el monto al que tiene acceso por pol�tica es "
								+ formateador.format(maximo) + " ["
								+ datosIntegrante.getNombreCompleto() + "]");
			}

			respuesta.setMontoMaximo(maximo);
			respuesta.getHeader().setMensaje("Si tiene una cuenta que cumple.");
		} catch (Exception ex) {
			LogHandler.error(uid, getClass(),
					"Existio un error "
							+ "en validarSimplificacionComunalSolidario(): "
							+ ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}
		return respuesta;
	}

	/**
	 * Metodo para validar los productos comunal y solidario con las reglas de
	 * renovaciones express, para simplificacion de renovacion 2
	 * 
	 * @param uid
	 *            para el log
	 * @param peticion
	 *            contrato y solicitud
	 * @param sesion
	 *            pasada por el metodo invocador
	 * @return monto maximo
	 */
	@SuppressWarnings("unchecked")
	public ValidaIntegranteRespuesta calcularMontoPreAprobadoPersona(
			final String uid, final ValidaIntegrantePeticion peticion,
			final SqlSession sesion) {
		java.util.HashMap<String, Object> peticionParametros = null;
		List<HashMap<String, Object>> datosSolicitud = null;
		ValidaIntegranteRespuesta respuesta = null;
		ValidaIntegranteDTO datosIntegrante = null;
		DecimalFormat formateador = null;
		Date fechaContable = null;
		String rutaOpenRules = "";
		String fileName = "";
		try {
			LogHandler.info(uid, getClass(),
					"calcularMontoPreAprobadoPersona - Entra");
			respuesta = new ValidaIntegranteRespuesta();
			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setEstatus(true);

			// OPEN RULES RULEIRAS
			rutaOpenRules = comun.obtenerParGeneralOV(uid,
					"com.mx.finsol.ciof.ruta.openrules").getCgValor();
			// rutaOpenRules = "C:/rulesFinsol/RNFinsol.xls";

			fileName = "file:" + rutaOpenRules;
			LogHandler
					.info(uid, getClass(), "OPEN RULES FILE NAME=" + fileName);
			if (fileName == null || fileName.trim().isEmpty()) {
				throw new Exception(
						"No fue posible recuperar la ruta del archivo de reglas de negocio.");
			}

			fechaContable = (Date) sesion.selectOne("consultaPrGetFecha");
			if (fechaContable == null) {
				throw new Exception("No se pudo recuperar la fecha contable.");
			}

			// Obtener datos persona
			peticionParametros = new java.util.HashMap<String, Object>();
			LogHandler.info(uid, getClass(), "calcularMontoPreAprobadoPersona:"
					+ " fechaContable: " + fechaContable);
			LogHandler.info(uid, getClass(), "calcularMontoPreAprobadoPersona:"
					+ " persona: ===> " + peticion.getPersona().trim());
			peticionParametros.put("fechaContable", fechaContable);
			peticionParametros.put("persona", peticion.getPersona().trim());

			LogHandler.trace(uid, getClass(),
					"calcularMontoPreAprobadoPersona:"
							+ " - datosIntegranteValidar");
			datosIntegrante = (ValidaIntegranteDTO) sesion.selectOne(
					"datosIntegranteValidar", peticionParametros);

			if (datosIntegrante == null) {
				throw new Exception("El cliente solicitado no existe.");
			}

			LogHandler.trace(uid, getClass(),
					"validacionSolicitudExpress: - obtenerParGeneral");
			ParGeneralOV montoMaximo = comun.obtenerParGeneralOV(uid,
					"RE_MONTOMA");

			if (montoMaximo == null
					|| montoMaximo.getCgValor().trim().isEmpty()) {
				throw new Exception(
						"No fue posible obtener los parametros para la validacion "
								+ "RE_MONTOMAX.");
			}
			double dMontoMaximo = Double.parseDouble(montoMaximo.getCgValor()
					.trim());

			double incremento = 0;
			InputReglasIncremento inputReglas = new InputReglasIncremento();

			// Se genera el input para las reglas de incrementos
			inputReglas.setCiclo(datosIntegrante.getCiclo());
			inputReglas.setAtrasoMaximo(datosIntegrante.getMaximoRetraso());
			inputReglas.setAtrasoFechaFin(datosIntegrante.getAtrasoFechaFin());
			// MIMH 20140923
			inputReglas
					.setAtrasoFechaFin(inputReglas.getAtrasoFechaFin() < 0 ? 0
							: inputReglas.getAtrasoFechaFin());
			inputReglas.setMontoManejado(datosIntegrante.getMontoBase());

			// validacion si en el ciclo 1 manejaron mas de 10,000 - Caso
			// Especial
			if (datosIntegrante.getCiclo() >= 1
					&& datosIntegrante.getCiclo() <= 2
					&& datosIntegrante.getMontoBase() < 10000) {
				LogHandler
						.info(uid,
								getClass(),
								"Se verifica si el cliente en ciclo 1 o 2 manejo mas de 10000 en el primer ciclo.");
				// obtenemos su monto manejado en ciclo = 1
				Double montoPrimerCiclo = (Double) sesion
						.selectOne("obtenerMontoPrimerCiclo", peticion
								.getPersona().trim());
				if (montoPrimerCiclo.doubleValue() >= 10000) {
					LogHandler
							.info(uid, getClass(),
									"El cliente si manejo mas de 10000 en el primer ciclo.");
					inputReglas
							.setMontoManejado(montoPrimerCiclo.doubleValue());
				}
			}

			// OpenRules
			OpenRulesEngine engine = new OpenRulesEngine(fileName);
			String methodName = "obtenerReglasIncremento";
			Response response = new Response();
			LogHandler.info(uid, getClass(), "Input Reglas=" + inputReglas);
			Object[] objects = new Object[] { inputReglas, response };

			engine.run(methodName, objects);

			LogHandler
					.info(uid, getClass(),
							"validarSimplificacionComunalSolidario: Resultado OPENRULES");
			LogHandler.info(uid, getClass(),
					"validarSimplificacionComunalSolidario: Porcentaje="
							+ response.getMap().get("porcentaje").toString());
			LogHandler.info(uid, getClass(),
					"validarSimplificacionComunalSolidario: Maximo="
							+ response.getMap().get("maximo").toString());
			LogHandler.info(uid, getClass(),
					"validarSimplificacionComunalSolidario: Error="
							+ response.getMap().get("error").toString());
			LogHandler.info(uid, getClass(),
					"validarSimplificacionComunalSolidario: Otorga="
							+ response.getMap().get("otorga").toString());

			/*
			 * if
			 * (response.getMap().get("otorga").toString().trim().equals("NO"))
			 * {
			 * 
			 * throw new Exception(
			 * "El cliente incumple con la regla de incremento, " +
			 * response.getMap().get("error").toString() + ". [" +
			 * datosIntegrante.getNombreCompleto() + "]"); }
			 */
			incremento = Double.parseDouble(response.getMap().get("porcentaje")
					.toString());

			boolean errorExtra = false;
			String errorMensajeExtra = "";

			double maximo = datosIntegrante.getMontoBase()
					* ((incremento / CIEN) + 1);
			LogHandler.info(uid, getClass(),
					"validarSimplificacionComunalSolidario: Maximo=" + maximo);
			maximo = incrementoRedondeo(maximo);
			LogHandler.info(uid, getClass(),
					"validarSimplificacionComunalSolidario: Maximo Redondeo="
							+ maximo);
			LogHandler.info(uid, getClass(),
					"validarSimplificacionComunalSolidario: Base="
							+ datosIntegrante.getMontoBase());

			if (Double.parseDouble(response.getMap().get("maximo").toString()) > maximo) {
				maximo = Double.parseDouble(response.getMap().get("maximo")
						.toString());
			}
			// Se valida si los clientes ya manejan mas del monto maximo 60,000
			if (datosIntegrante.getMontoBase() > dMontoMaximo) {
				maximo = datosIntegrante.getMontoBase();
			} else if (maximo > dMontoMaximo) {
				maximo = dMontoMaximo;
			}

			LogHandler.info(uid, getClass(),
					"validarSimplificacionComunalSolidario: Maximo Final="
							+ maximo);
			/*
			 * if ( peticion.getMonto() > maximo ) {
			 * 
			 * throw new Exception(
			 * "El cliente incumple con la regla de incremento, " + (
			 * !errorExtra ? response.getMap().get("error").toString() :
			 * errorMensajeExtra ) +
			 * ", el monto al que tiene acceso por pol�tica es " +
			 * formateador.format(maximo) + " [" +
			 * datosIntegrante.getNombreCompleto() + "]"); }
			 */
			respuesta.setMontoMaximo(maximo);
			respuesta.getHeader().setMensaje("Si tiene una cuenta que cumple.");
		} catch (Exception ex) {
			LogHandler.error(uid, getClass(),
					"Existio un error "
							+ "en validarSimplificacionComunalSolidario(): "
							+ ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}
		return respuesta;
	}

	/**
	 * @param uid
	 *            identificador unico
	 * @param peticion
	 *            para calcular el incremento
	 * @return respuesta
	 */
	@SuppressWarnings("unchecked")
	public ValidaIntegranteRespuesta validaIntegranteSolicitud(String uid,
			ValidaIntegrantePeticion peticion) {
		ValidaIntegranteRespuesta respuesta = new ValidaIntegranteRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		DecimalFormat formateador = new DecimalFormat("$###,###,###.##");

		SqlSession sesion = null;

		try {
			// Validamos que la peticion contenga lo necesario
			LogHandler.info(uid, getClass(),
					"validaIntegranteSolicitud - Entra");
			if (peticion == null) {
				throw new Exception(
						"La peticion de validacion no puede estar vacia.");
			}
			if (peticion.getPersona() == null
					|| peticion.getPersona().trim().isEmpty()) {
				throw new Exception(
						"El numero de persona es obligatorio en la peticion.");
			}
			if (peticion.getProducto() == null
					|| peticion.getProducto().trim().isEmpty()) {
				throw new Exception(
						"El producto es obligatorio en la peticion.");
			}
			if (peticion.getSolicitud() == null
					|| peticion.getSolicitud().trim().isEmpty()) {
				throw new Exception(
						"La solicitud es obligatoria en la peticion.");
			}
			if (peticion.getMonto() <= 0d) {
				throw new Exception(
						"El monto debe ser mayor a cero en la peticion.");
			}
			// Abrimos sesion a BD
			LogHandler.info(uid, getClass(),
					"validaIntegranteSolicitud - Abriendo conexion...");
			sesion = FabricaConexiones.obtenerSesionNTx();

			String rutaOpenRules = comun.obtenerParGeneralOV(uid,
					"com.mx.finsol.ciof.ruta.openrules").getCgValor();
			// OpenRules
			String fileName = "file:" + rutaOpenRules;
			LogHandler
					.info(uid, getClass(), "OPEN RULES FILE NAME=" + fileName);

			if (fileName == null || fileName.trim().isEmpty()) {
				throw new Exception(
						"No fue posible recuperar la ruta del archivo de reglas de negocio.");
			}

			if (peticion.isExpress()) {

				LogHandler.info(uid, getClass(),
						"validaIntegranteSolicitud: EXPRESS");

				Date fechaContable = (Date) sesion
						.selectOne("consultaPrGetFecha");
				if (fechaContable == null) {
					throw new Exception(
							"No se pudo recuperar la fecha contable.");
				}
				// Obtener datos persona
				java.util.HashMap<String, Object> peticionParametros = new java.util.HashMap<String, Object>();
				LogHandler.info(uid, getClass(),
						"validaIntegranteSolicitud: fechaContable: "
								+ fechaContable);
				peticionParametros.put("fechaContable", fechaContable);
				peticionParametros.put("persona", peticion.getPersona().trim());
				LogHandler.trace(uid, getClass(),
						"validaIntegranteSolicitud: - datosIntegranteValidar");
				ValidaIntegranteDTO datosIntegrante = (ValidaIntegranteDTO) sesion
						.selectOne("datosIntegranteValidar", peticionParametros);

				if (datosIntegrante == null) {
					throw new Exception("El cliente solicitado no existe.");
				}
				respuesta.setDatosIntegrante(datosIntegrante);

				// Obtenemos datos de la solicitud
				LogHandler.trace(uid, getClass(),
						"validaIntegranteSolicitud: - obtieneExpressSolicitud");
				List<HashMap<String, Object>> datosSolicitud = (List<HashMap<String, Object>>) sesion
						.selectList("obtieneExpressSolicitud",
								peticion.getSolicitud());

				if (datosSolicitud == null || datosSolicitud.isEmpty()) {
					throw new Exception(
							"No fue posible obtener los datos de la solicitud.");
				}

				// Validacion del cliente continuo (sin renovacion -> 0 )
				LogHandler.info(uid, getClass(), "CICLO INTEGRANTE="
						+ datosIntegrante.getCiclo());

				LogHandler.trace(uid, getClass(),
						"validacionSolicitudExpress: - obtenerParGeneral");
				ParGeneralOV diasRenovacionNuevo = comun.obtenerParGeneralOV(
						uid, "RE_DIAS_NU");
				// (ParGeneralOV) sesion.selectOne("obtenerParGeneral",
				// "RE_DIAS_NU");

				LogHandler.trace(uid, getClass(),
						"validacionSolicitudExpress: - obtenerParGeneral");
				ParGeneralOV montoMaximo = comun.obtenerParGeneralOV(uid,
						"RE_MONTOMA");
				// (ParGeneralOV) sesion.selectOne("obtenerParGeneral",
				// "RE_MONTOMA");

				LogHandler.trace(uid, getClass(),
						"validacionSolicitudExpress: - obtenerParGeneral");
				ParGeneralOV montoIguala = comun.obtenerParGeneralOV(uid,
						"RE_MONCAIG");
				// (ParGeneralOV) sesion.selectOne("obtenerParGeneral",
				// "RE_MONCAIG");

				if (diasRenovacionNuevo == null
						|| diasRenovacionNuevo.getCgValor().trim().isEmpty()
						|| montoMaximo == null
						|| montoMaximo.getCgValor().trim().isEmpty()
						|| montoIguala == null
						|| montoIguala.getCgValor().trim().isEmpty()) {
					throw new Exception(
							"No fue posible obtener los parametros para la validacion "
									+ "RE_DIAS_NU,RE_MONTOMAX,RE_MONCAIG.");
				}
				double dMontoMaximo = Double.parseDouble(montoMaximo
						.getCgValor().trim());
				int diasRenovacion = Integer.valueOf(diasRenovacionNuevo
						.getCgValor().trim());
				LogHandler.info(uid, getClass(),
						"validaIntegranteSolicitud: diasRenovacion="
								+ diasRenovacion);
				boolean clienteConsideradoNuevo = false;
				if (datosIntegrante.getDiasLiquidacion() > diasRenovacion) {
					LogHandler
							.info(uid, getClass(),
									"validaIntegranteSolicitud: Cliente considerado como nuevo.");
					clienteConsideradoNuevo = true;
					datosIntegrante.setCiclo(0);
				}

				LogHandler.info(
						uid,
						getClass(),
						"CICLO INTEGRANTE DV CONTINUIDAD="
								+ datosIntegrante.getCiclo());

				boolean antiguo = false;
				boolean pertenecioGrupo = false;

				if (datosSolicitud.get(0).get("contratoAnterior").toString()
						.trim().isEmpty()) {
					throw new Exception(
							"La informacion de la solicitud es incorrecta no tiene contrato anterior.");
				}
				for (int i = 0; i < datosSolicitud.size(); i++) {
					if (datosSolicitud.get(i).get("integrante").toString()
							.trim().equals(peticion.getPersona().trim())) {
						pertenecioGrupo = true;
					}
				}

				// 20140828 Se considera como antiguo a clientes con ciclo > 0
				if (datosIntegrante.getCiclo() > 0) {
					antiguo = true;
				}

				// primero validar buro de credito
				ValidaSolicitudPeticion peticionBuro = new ValidaSolicitudPeticion();
				peticionBuro.setIntegrante(peticion.getPersona());
				peticionBuro.setOrdinaria(datosSolicitud.get(0)
						.get("tipoRenovacion").toString().equals("ORD"));
				peticionBuro.setAntiguo(antiguo);
				ConsultaSolicitudBuroRespuesta respuestaBuro = buroCreditoTarea
						.validacionBuroClienteSolicitudExpress(uid,
								peticionBuro);

				LogHandler.info(uid, getClass(), "VALIDACION BURO EXPRESS ="
						+ respuestaBuro);
				if (!respuestaBuro.getHeader().isEstatus()) {
					throw new Exception(respuestaBuro.getHeader().getMensaje()
							+ " [" + datosIntegrante.getNombreCompleto() + "].");
				}

				// Campa�a Iguala
				if (peticion.isIguala()) {
					LogHandler.info(uid, getClass(),
							"validaIntegranteSolicitud: Campaña Iguala.");

					// Validar cuenta
					ValidaSolicitudPeticion peticionBuroCampana = new ValidaSolicitudPeticion();
					peticionBuroCampana.setIntegrante(peticion.getPersona());
					peticionBuroCampana.setMontoSolicitado(peticion.getMonto());
					ConsultaSolicitudBuroRespuesta respuestaBuroCampana = buroCreditoTarea
							.validacionBuroClienteSolicitudExpressIguala(uid,
									peticionBuroCampana);

					if (!respuestaBuroCampana.getHeader().isEstatus()) {
						throw new Exception(
								"El cliente incumple con la validacion "
										+ respuestaBuroCampana.getHeader()
												.getMensaje()
										+ " y por tanto las condiciones de renovaci�n express"
										+ " no pueden ser de CAMPAÑA IGUALA y debe ser sujeto a las condiciones generales de"
										+ " renovacion express " + " ["
										+ datosIntegrante.getNombreCompleto()
										+ "].");
					}

					double dMontoIguala = Double.parseDouble(montoIguala
							.getCgValor().trim());
					if (peticion.getMonto() > dMontoIguala) {
						throw new Exception(
								"El cliente incumple con la validaci�n del monto maximo ["
										+ formateador.format(dMontoIguala)
										+ "] y por tanto las condiciones de renovacion express"
										+ " no pueden ser de CAMPAÑA IGUALA y debe ser sujeto a las condiciones generales de"
										+ " renovaci�n express " + " ["
										+ datosIntegrante.getNombreCompleto()
										+ "].");
					}
					respuesta.getHeader().setMensaje(
							"Si tiene una cuenta que cumple.");
					return respuesta;
				}
				// Validacion para nuevos ciclo 0
				if (datosIntegrante.getCiclo() == 0) {
					// Comunales
					if (DataMapper.mapCategoriaProductos.get(
							peticion.getProducto()).equals("COMUNAL")) {

						InputReglasIncremento inputReglas = new InputReglasIncremento();
						inputReglas.setEdad(datosIntegrante.getEdad());
						inputReglas.setExperienciaCrediticia(datosIntegrante
								.getExperiencia().trim());
						inputReglas.setCiclo(datosIntegrante.getCiclo());
						OpenRulesEngine engine = new OpenRulesEngine(fileName);
						String methodName = "obtenerMontosCicloCero";
						Response response = new Response();

						Object[] objects = new Object[] { inputReglas, response };

						engine.run(methodName, objects);

						if (peticion.getMonto() < Double.parseDouble(response
								.getMap().get("minimo").toString())
								|| peticion.getMonto() > Double
										.parseDouble(response.getMap()
												.get("maximo").toString())) {
							if (clienteConsideradoNuevo) {
								throw new Exception(
										"El cliente tiene mas de un a�o sin renovar se considera como Nuevo. "
												+ response.getMap()
														.get("error")
														.toString()
												+ " ["
												+ datosIntegrante
														.getNombreCompleto()
												+ "]");
							} else {
								throw new Exception(response.getMap()
										.get("error").toString()
										+ " ["
										+ datosIntegrante.getNombreCompleto()
										+ "]");
							}
						}

					}
				} else {
					double incremento = 0;
					double incrementoMop99HipAut = 0;
					LogHandler
							.info(uid, getClass(),
									"validaIntegranteSolicitud: ciclo > 0 y sin mop99 ni hipotecario automotriz.");
					InputReglasIncremento inputReglas = new InputReglasIncremento();

					// Se genera el input para las reglas de incrementos
					inputReglas.setCiclo(datosIntegrante.getCiclo());

					if (pertenecioGrupo) {
						inputReglas.setAtrasoMaximo(Integer
								.parseInt(datosSolicitud.get(0)
										.get("maximoAtraso").toString()));
						inputReglas.setAtrasoFechaFin(Integer
								.parseInt(datosSolicitud.get(0)
										.get("atrasoFechaFin").toString()));
						// MIMH 20140923
						inputReglas.setAtrasoFechaFin(inputReglas
								.getAtrasoFechaFin() < 0 ? 0 : inputReglas
								.getAtrasoFechaFin());
					} else {
						LogHandler.info(uid, getClass(),
								"Cliente antiguo se obtiene el ultimo monto");
						inputReglas.setAtrasoMaximo(datosIntegrante
								.getMaximoRetraso());
						inputReglas.setAtrasoFechaFin(datosIntegrante
								.getAtrasoFechaFin() < 0 ? 0 : datosIntegrante
								.getAtrasoFechaFin());
					}

					inputReglas
							.setMontoManejado(datosIntegrante.getMontoBase());

					// validacion si en el ciclo 1 manejaron mas de 10,000 -
					// Caso Especial
					if (datosIntegrante.getCiclo() >= 1
							&& datosIntegrante.getCiclo() <= 2
							&& datosIntegrante.getMontoBase() < 10000) {
						LogHandler
								.info(uid,
										getClass(),
										"Se verifica si el cliente en ciclo 1 o 2 manejo mas de 10000 en el primer ciclo.");
						// obtenemos su monto manejado en ciclo = 1
						Double montoPrimerCiclo = (Double) sesion.selectOne(
								"obtenerMontoPrimerCiclo", peticion
										.getPersona().trim());
						if (montoPrimerCiclo.doubleValue() >= 10000) {
							LogHandler
									.info(uid, getClass(),
											"El cliente si manejo mas de 10000 en el primer ciclo.");
							inputReglas.setMontoManejado(montoPrimerCiclo
									.doubleValue());
						}
					}

					// OpenRules
					OpenRulesEngine engine = new OpenRulesEngine(fileName);
					String methodName = "obtenerReglasIncremento";
					Response response = new Response();
					LogHandler.info(uid, getClass(), "Input Reglas="
							+ inputReglas);
					Object[] objects = new Object[] { inputReglas, response };

					engine.run(methodName, objects);

					LogHandler.info(uid, getClass(),
							"validaIntegranteSolicitud: Resultado OPENRULES");
					LogHandler.info(uid, getClass(),
							"validaIntegranteSolicitud: Porcentaje="
									+ response.getMap().get("porcentaje")
											.toString());
					LogHandler.info(uid, getClass(),
							"validaIntegranteSolicitud: Maximo="
									+ response.getMap().get("maximo")
											.toString());
					LogHandler
							.info(uid, getClass(),
									"validaIntegranteSolicitud: Error="
											+ response.getMap().get("error")
													.toString());
					LogHandler.info(uid, getClass(),
							"validaIntegranteSolicitud: Otorga="
									+ response.getMap().get("otorga")
											.toString());

					if (response.getMap().get("otorga").toString().trim()
							.equals("NO")) {
						throw new Exception(
								"El cliente incumple con la regla de incremento, "
										+ response.getMap().get("error")
												.toString() + ". ["
										+ datosIntegrante.getNombreCompleto()
										+ "]");
					}

					incremento = Double.parseDouble(response.getMap()
							.get("porcentaje").toString());

					// Validamos si el cliente tiene mop99 o credito automotriz
					// o hipotecario
					boolean errorExtra = false;
					String errorMensajeExtra = "";
					LogHandler
							.info(uid,
									getClass(),
									"validaIntegranteSolicitud: Verificar Tiene Mop 99 o Automotriz-Hipotecario?????");
					if (respuestaBuro.getRespuestaIncremento().isMop99()
							|| respuestaBuro.getRespuestaIncremento()
									.isHipotecarioAutomotriz()) {

						LogHandler
								.info(uid, getClass(),
										"validaIntegranteSolicitud: Tiene Mop 99 o Automotriz-Hipotecario.");
						InputReglasIncremento inputReglasExtras = new InputReglasIncremento();
						inputReglasExtras.setMop99(respuestaBuro
								.getRespuestaIncremento().isMop99());
						inputReglasExtras
								.setAutomotrizHipotecario(respuestaBuro
										.getRespuestaIncremento()
										.isHipotecarioAutomotriz());
						// OpenRules
						engine = new OpenRulesEngine(fileName);
						String methodNameExtra = "obtenerIncrementosBuro";
						Response responseExtra = new Response();

						Object[] objectsExtra = new Object[] {
								inputReglasExtras, responseExtra };

						engine.run(methodNameExtra, objectsExtra);
						LogHandler.info(
								uid,
								getClass(),
								"validaIntegranteSolicitud: Extra Porcentaje="
										+ responseExtra.getMap()
												.get("porcentaje").toString());
						incrementoMop99HipAut = Double
								.parseDouble(responseExtra.getMap()
										.get("porcentaje").toString());

						LogHandler.info(uid, getClass(),
								"validaIntegranteSolicitud: PorcentajeNormal="
										+ incremento + " PorcentajeExtra="
										+ incrementoMop99HipAut);
						if (incrementoMop99HipAut < incremento) {
							LogHandler
									.info(uid, getClass(),
											"validaIntegranteSolicitud: Cambio Porcentaje");
							incremento = incrementoMop99HipAut;
							errorExtra = true;
							errorMensajeExtra = response.getMap().get("error")
									.toString();
						}
					}

					double maximo = datosIntegrante.getMontoBase()
							* ((incremento / CIEN) + 1);
					LogHandler.info(uid, getClass(),
							"validaIntegranteSolicitud: Maximo=" + maximo);
					maximo = incrementoRedondeo(maximo);
					LogHandler.info(uid, getClass(),
							"validaIntegranteSolicitud: Maximo Redondeo="
									+ maximo);
					LogHandler.info(uid, getClass(),
							"validaIntegranteSolicitud: Base="
									+ datosIntegrante.getMontoBase());

					if (Double.parseDouble(response.getMap().get("maximo")
							.toString()) > maximo) {
						maximo = Double.parseDouble(response.getMap()
								.get("maximo").toString());
					}
					// Se valida si los clientes ya manejan mas del monto maximo
					// 60,000
					if (datosIntegrante.getMontoBase() > dMontoMaximo) {
						maximo = datosIntegrante.getMontoBase();
					} else if (maximo > dMontoMaximo) {
						maximo = dMontoMaximo;
					}
					LogHandler
							.info(uid, getClass(),
									"validaIntegranteSolicitud: Maximo Final="
											+ maximo);
					if (peticion.getMonto() > maximo) {

						throw new Exception(
								"El cliente incumple con la regla de incremento, "
										+ (!errorExtra ? response.getMap()
												.get("error").toString()
												: errorMensajeExtra)
										+ ", el monto al que tiene acceso por pol�tica es "
										+ formateador.format(maximo) + " ["
										+ datosIntegrante.getNombreCompleto()
										+ "]");
					}
				}
			} // es Express?
		} catch (Exception ex) {
			LogHandler.error(
					uid,
					getClass(),
					"Existio un error en validaIntegranteSolicitud(): "
							+ ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesion);
		}
		return respuesta;
	}

	/**
	 * Metodo para validar cuando se agrega un integrante en una solicitud.
	 * 
	 * @param peticion
	 *            contiene los datos necesarios para realizar la validacion.
	 * @param uid
	 *            identificador unico de la transaccion para el log.
	 * @return regresa la respuesta para saber si es posible agregar el cliente
	 *         o no a la solicitu.
	 */
	public ValidarIntegranteSolicitudRespuesta validarAgregarIntegranteSolicitud(
			String uid, ValidarIntegranteSolicitudPeticion peticion) {

		ValidarIntegranteSolicitudRespuesta respuesta = new ValidarIntegranteSolicitudRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setMensaje("Validacion correcta");
		SqlSession sesion = null;
		try {
			if (peticion == null) {
				throw new Exception("La peticion no es correcta, es nula.");
			}
			if (peticion.getFechaDesembolso() == null) {
				throw new Exception(
						"La peticion no es correcta, es necesaria la fecha desembolso.");
			}
			if (peticion.getMontoSolicitado() <= 0) {
				throw new Exception(
						"La peticion no es correcta, el monto solicitado debe ser mayor a 0.");
			}
			if (peticion.getPersona() == null
					|| peticion.getPersona().trim().isEmpty()) {
				throw new Exception(
						"La peticion no es correcta, el numero de persona es incorrecto.");
			}
			if (peticion.getPlazoSolicitud() <= 0) {
				throw new Exception(
						"La peticion no es correcta, el plazo solicitado debe ser mayor a 0.");
			}
			if (peticion.isSeguroVida()) {
				if (peticion.getPlazoSeguro() == null
						|| peticion.getPlazoSeguro().isEmpty()) {
					throw new Exception(
							"La peticion no es correcta, falta el plazo seguro.");
				}
			}
			if (peticion.getFrecuencia() == null
					|| peticion.getFrecuencia().isEmpty()) {
				throw new Exception(
						"La peticion no es correcta, falta la frecuencia.");
			}
			if (peticion.getUsuario() == null
					|| peticion.getUsuario().trim().isEmpty()) {
				throw new Exception(
						"La peticion no es correcta, el usuario es incorrecto.");
			}
			if (peticion.getSucursal() < 0) {
				throw new Exception("La sucursal en la peticion es necesaria.");
			}
			// Obtenemos el numero de persona
			String persona = comun.obtenerPersonaCliente(uid,
					peticion.getPersona());
			if (persona == null || persona.trim().isEmpty()) {
				throw new Exception(
						"La peticion no es correcta,  el numero de persona no existe.");
			}

			// Validamos que la captura sea completa de los clientes
			ValidarDatosPersonaPeticion peticionValidarDatosPersona = new ValidarDatosPersonaPeticion();
			peticionValidarDatosPersona.setNumeroPersona(persona);
			ValidarDatosPersonaRespuesta resValidarDatosPerosna = administracionPersona
					.validarDatosPersonaTarea(uid, peticionValidarDatosPersona);

			if (!resValidarDatosPerosna.getHeader().isEstatus()) {
				throw new Exception("Error en validar Datos de la Persona: "
						+ resValidarDatosPerosna.getHeader().getMensaje());
			}

			sesion = FabricaConexiones.obtenerSesionNTx();

			LogHandler
					.trace(uid, getClass(),
							"validarAgregarIntegranteSolicitud: - obtenerDatosValidarAgregarIntegrante");
			ValidaIntegranteDTO datosIntegrante = (ValidaIntegranteDTO) sesion
					.selectOne("obtenerDatosValidarAgregarIntegrante", persona);

			// Validamos que no tenga un codigo de bloqueo.
			if (!datosIntegrante.getBloqueo().trim().isEmpty()) {
				throw new Exception(
						"La persona tiene un codigo de bloqueo, no se puede agregar a la solicitud.");
			}
			SimpleDateFormat formatoDeFecha = new SimpleDateFormat("yyyy-MM-dd");
			datosIntegrante.setEdad(comun.calcularEdad(formatoDeFecha
					.parse(datosIntegrante.getFechaNacimiento())));

			int edadMinima = 0;
			int edadMaxima = 0;
			double montoMinimo = 0d;
			double montoMaximo = 0d;

			if (datosIntegrante.getExperiencia() == null) {
				datosIntegrante.setExperiencia("0");
			}

			if (datosIntegrante.getCiclo() == 0) {
				edadMinima = Integer.parseInt(comun.obtenerParGeneral(uid,
						"COGNUEDMIN"));
				edadMaxima = Integer.parseInt(comun.obtenerParGeneral(uid,
						"COGNUEDMAX"));

				if (datosIntegrante.getExperiencia().trim().equals("1")) {
					montoMinimo = Double.parseDouble(comun.obtenerParGeneral(
							uid, "COGNEMOMIN"));
					montoMaximo = Double.parseDouble(comun.obtenerParGeneral(
							uid, "COGNEMOMAX"));
				} else {
					montoMinimo = Double.parseDouble(comun.obtenerParGeneral(
							uid, "COGNSMOMIN"));
					montoMaximo = Double.parseDouble(comun.obtenerParGeneral(
							uid, "COGNSMOMAX"));
				}
			} else {
				edadMinima = Integer.parseInt(comun.obtenerParGeneral(uid,
						"COGEXEDMIN"));
				edadMaxima = Integer.parseInt(comun.obtenerParGeneral(uid,
						"COGEXEDMAX"));

				montoMinimo = Double.parseDouble(comun.obtenerParGeneral(uid,
						"COGEXMOMIN"));
				montoMaximo = Double.parseDouble(comun.obtenerParGeneral(uid,
						"COGEXMOMAX"));
			}

			// Validacion de la edad
			if (datosIntegrante.getEdad() < edadMinima
					|| datosIntegrante.getEdad() > edadMaxima) {
				throw new Exception(
						"La edad del cliente esta fuera del rango permitido (Min: "
								+ edadMinima + ", Max: " + edadMaxima + ")");
			}

			if (peticion.getMontoSolicitado() < montoMinimo
					|| peticion.getMontoSolicitado() > montoMaximo) {
				throw new Exception(
						"El monto solicitado esta fuera del rango permitido (Min: "
								+ montoMinimo + ", Max: " + montoMaximo + ")");
			}

			// Validamos que el estatus de su ultimo contrato no sea nuevo ni
			// vendido
			LogHandler
					.trace(uid, getClass(),
							"validarAgregarIntegranteSolicitud: - obtenerEstatusUltimoContrato");
			String statusContrato = (String) sesion.selectOne(
					"obtenerEstatusUltimoContrato", persona);
			statusContrato = statusContrato == null ? "" : statusContrato;
			if (statusContrato.equals("N")) {
				throw new Exception(
						"El cliente tiene un crédito en estatus Nuevo");
			}

			if (statusContrato.equals("V")) {
				throw new Exception(
						"El cliente tiene un crédito en estatus Vendido");
			}

			boolean consultaAutomatica = Boolean.parseBoolean(comun
					.obtenerParGeneral(uid, "CONBUROAUT"));
			LogHandler.info(uid, getClass(),
					"validarAgregarIntegranteSolicitud: *consultaAutomatica*"
							+ consultaAutomatica);
			if (consultaAutomatica) {
				// Realizamos consulta al buro de credito
				ConsultaBuroPeticion peticionBuro = new ConsultaBuroPeticion();
				peticionBuro.setPersona(persona);
				peticionBuro.setSucursal(peticion.getSucursal());
				peticionBuro.setUsuario(peticion.getUsuario());
				peticionBuro.setImporte(peticion.getMontoSolicitado());
				ConsultaBuroRespuesta respuestaBuro = buroCreditoTarea
						.consultaBuroCredito(uid, peticionBuro);
				if (!respuestaBuro.getHeader().isEstatus()) {
					throw new Exception("Error en consultar Buro de Credito: "
							+ respuestaBuro.getHeader().getMensaje());
				}
			}

			int edadMinimaSeguro = 0;
			int edadMaximaSeguro = 0;
			// Validaciones Seguro de Vida
			if (peticion.isSeguroVida() || peticion.isSeguroEnfermedad()) {
				edadMinimaSeguro = Integer.parseInt(comun.obtenerParGeneral(
						uid, "SEGEDADMIN"));
				edadMaximaSeguro = Integer.parseInt(comun.obtenerParGeneral(
						uid, "SEGEDADMAX"));

				if (datosIntegrante.getEdad() < edadMinimaSeguro
						|| datosIntegrante.getEdad() >= edadMaximaSeguro) {
					throw new Exception(
							"La edad del cliente esta fuera del rango permitido para el seguro (Min: "
									+ edadMinimaSeguro + ", Max: "
									+ (edadMaximaSeguro - 1) + ")");
				}
			}

			// Validacion ObtenerCostoSeguros
			ObtenerMontosSegurosRespuesta resMontoSeguros = obtenerMontoSegurosCliente(
					uid, peticion);

			if (!resMontoSeguros.getHeader().isEstatus()) {
				throw new Exception(
						"Ocurrio un error al validar obtener montos de seguros: "
								+ resMontoSeguros.getHeader().getMensaje()
								+ " para el cliente: " + peticion.getPersona());
			}

		} catch (Exception ex) {
			LogHandler.error(uid, getClass(),
					"Existio un error en validarAgregarIntegranteSolicitud(): "
							+ ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesion);
		}
		return respuesta;
	}

	/**
	 * Obtiene los montos seguros.
	 *
	 * @param uid
	 *            the uid
	 * @param peticionCliente
	 *            the ValidarIntegranteSolicitudPeticion
	 * @return the obtener montos seguros respuesta
	 */
	public ObtenerMontosSegurosRespuesta obtenerMontoSegurosCliente(String uid,
			ValidarIntegranteSolicitudPeticion peticionCliente) {

		ObtenerMontosSegurosRespuesta respuesta = new ObtenerMontosSegurosRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesion = null;

		// Parte para calcular Montos Seguros
		// Parametros de entrada
		Double montoTotalSeguroVida = 0.0;
		Double montoTotalSeguroEnfermedades = 0.0;
		Integer plazoSeguro = 0;
		Integer plazoCredito = 0;
		String peticion = "";
		String seguroVida = "";
		String seguroEnfermedad = "";

		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"dd/MM/yyyy");

		try {

			if (peticionCliente.getPersona() != null) {
				if (peticionCliente.isSeguroVida()
						|| peticionCliente.isSeguroEnfermedad()) {

					peticion += "<clientes>";

					if (peticionCliente.isSeguroVida()) {
						seguroVida = "S";
					} else {
						seguroVida = "N";
					}

					if (peticionCliente.isSeguroEnfermedad()) {
						seguroEnfermedad = "S";
					} else {
						seguroEnfermedad = "N";
					}

					if (peticionCliente.getPlazoSeguro() != null
							&& !peticionCliente.getPlazoSeguro().isEmpty()) {
						if (peticionCliente.getPlazoSeguro().equals("A")) {
							plazoSeguro = Constantes.SEMANAS_ANIO;
						}
					}

					if (peticionCliente.getPlazoSeguro().equals("C")) {
						plazoSeguro = obtienePlazoSeguroSemanas(
								peticionCliente.getFrecuencia(),
								peticionCliente.getPlazoSolicitud());
					}

					plazoCredito = obtienePlazoSeguroSemanas(
							peticionCliente.getFrecuencia(),
							peticionCliente.getPlazoSolicitud());

					peticion += "<cliente>";
					peticion += "<inicioVigencia>"
							+ simpleDateFormat.format(peticionCliente
									.getFechaDesembolso())
							+ "</inicioVigencia>";
					peticion += "<numeroPersona>"
							+ peticionCliente.getPersona().trim()
							+ "</numeroPersona>";
					peticion += "<plazoSeguro>" + plazoSeguro
							+ "</plazoSeguro>";
					peticion += "<seguroVida>" + seguroVida + "</seguroVida>";
					peticion += "<plazoCredito>" + plazoCredito
							+ "</plazoCredito>";
					peticion += "<seguroEnfermedad>" + seguroEnfermedad
							+ "</seguroEnfermedad>";
					peticion += "</cliente>";

					peticion += "</clientes>";

					// Se genera la peticion
					LogHandler.info(uid, getClass(),
							"obtenerMontoSeguros - Datos de salida XML: "
									+ peticion);

					LogHandler.info(uid, getClass(),
							"confirmarCreditoTarea - Abriendo conexion...");
					sesion = FabricaConexiones.obtenerSesionNTx();

					LogHandler.info(uid, getClass(),
							"Se intenta obtener una instancia del WS");

					// mx.com.findep.crediseguros.webservice.finsol

					LogHandler.trace(uid, getClass(),
							"obtenerMontoSeguros: - obtenerParGeneral");
					ParGeneralOV urlWSCalCos = comun.obtenerParGeneralOV(uid,
							"WS_CAL_COS");
					// (ParGeneralOV) sesion.selectOne("obtenerParGeneral",
					// "WS_CAL_COS");
					if (urlWSCalCos == null
							|| urlWSCalCos.getCgValor().trim().isEmpty()) {
						throw new Exception(
								"No fue posible obtener la URL del servicio de obtener monto seguros.");
					}

					LogHandler.info(uid, getClass(),
							"obtenerMontoSeguros - calcularCostoSeguro="
									+ urlWSCalCos.getCgValor().trim());

					CalculoCostoSeguroServiceLocator servicioSeguros = new CalculoCostoSeguroServiceLocator();
					servicioSeguros
							.setCalculoCostoSeguroPortEndpointAddress(urlWSCalCos
									.getCgValor().trim());
					String respuestaCalcular = servicioSeguros
							.getCalculoCostoSeguroPort().calcularCostoSeguro(
									peticion);

					LogHandler.info(uid, getClass(),
							"obtenerMontoSeguros - calcularCostoSeguro="
									+ respuestaCalcular);

					if (respuestaCalcular.contains("mensajeError")
							|| respuestaCalcular.contains("false")) {
						// Ocurrio un error en la anulacion del seguro
						String tag = "mensajeError";
						String value = "";
						String tagBuscar = "<" + tag + ">";
						String tagFinBuscar = "</" + tag + ">";
						value = respuestaCalcular.substring(
								respuestaCalcular.indexOf(tagBuscar)
										+ tagBuscar.length(),
								respuestaCalcular.indexOf(tagFinBuscar));
						throw new Exception(
								"Ocurrio un error en web service para Calcular Costos Seguros - calcularCostoSeguro: "
										+ value);
					}

					// Convertir a objeto y sumar montos;

					DocumentBuilderFactory dbf = DocumentBuilderFactory
							.newInstance();
					DocumentBuilder db = dbf.newDocumentBuilder();
					InputSource is = new InputSource();
					is.setCharacterStream(new StringReader(respuestaCalcular));

					Document doc = db.parse(is);
					NodeList nodes = doc.getElementsByTagName("cliente");

					List<cliente> clientes = new ArrayList<cliente>();

					// iterate the employees
					for (int i = 0; i < nodes.getLength(); i++) {
						Element element = (Element) nodes.item(i);

						cliente nuevoCliente = new cliente();

						NodeList costoSeguroVida = element
								.getElementsByTagName("costoSeguroVida");
						Element line = (Element) costoSeguroVida.item(0);
						if (line != null) {

							nuevoCliente
									.setCostoSeguroVida(Double
											.parseDouble(getCharacterDataFromElement(line)));
							montoTotalSeguroVida += Double
									.parseDouble(getCharacterDataFromElement(line));
						}

						NodeList costoSeguroEnfermedad = element
								.getElementsByTagName("costoSeguroEnfermedad");
						Element line2 = (Element) costoSeguroEnfermedad.item(0);
						if (line2 != null) {

							nuevoCliente
									.setCostoSeguroEnfermedad(Double
											.parseDouble(getCharacterDataFromElement(line2)));
							montoTotalSeguroEnfermedades += Double
									.parseDouble(getCharacterDataFromElement(line2));
						}

						NodeList numeroPersona = element
								.getElementsByTagName("numeroPersona");
						Element line3 = (Element) numeroPersona.item(0);
						if (line3 != null) {

							nuevoCliente
									.setNumeroPersona(getCharacterDataFromElement(line3));
						}
						clientes.add(nuevoCliente);
					}

					respuesta.setMontoTotalSeguroVida(montoTotalSeguroVida);
					respuesta
							.setMontoTotalSeguroEnfermedades(montoTotalSeguroEnfermedades);
					respuesta.setClientes(clientes);

				} // fin if2
			} // fin if1

		} catch (Exception e) {
			LogHandler.error(
					uid,
					getClass(),
					"Existio un error en obtienerMontoSeguros(): "
							+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());
		} finally {
			FabricaConexiones.close(sesion);
		}
		return respuesta;
	}

	/**
	 * Gets the character data from element.
	 *
	 * @param e
	 *            the e
	 * @return the character data from element
	 */
	public static String getCharacterDataFromElement(Element e) {
		Node child = e.getFirstChild();
		if (child instanceof CharacterData) {
			CharacterData cd = (CharacterData) child;
			return cd.getData();
		}
		return "?";
	}

	/**
	 * Obtiene plazo seguro semanas.
	 *
	 * @param frecuencia
	 *            the producto
	 * @param plazo
	 *            the plazo
	 * @return the int
	 */
	public int obtienePlazoSeguroSemanas(String frecuencia, int plazo) {

		if (frecuencia.equals("C")) {
			plazo = plazo * 2;
		}

		return plazo;
	}

	/**
	 * Validar doble.
	 *
	 * @param valor
	 *            the valor
	 * @return the boolean
	 */
	public Double validarDobleNan(double valor) {

		Double valorDoble = valor;
		try {
			if (valorDoble == null || valorDoble.isInfinite()
					|| valorDoble.isNaN() || valorDoble < 0) {
				valorDoble = 0.0;
			}
		} catch (Exception e) {
			valorDoble = 0.0;
		}
		return valorDoble;
	}

	/**
	 * @param valor
	 *            a redondear con el incremento
	 * @return valor redondeo
	 */
	public double incrementoRedondeo(double valor) {
		double valorRedondeo = 0;

		double modulo = valor % Constantes.MIL;
		double modulo2 = valor % Constantes.QUINIENTOS;

		if (modulo == 0 || modulo2 == 0) {
			valorRedondeo = valor;
		} else if (modulo > 0 && modulo < Constantes.QUINIENTOS) {
			valorRedondeo = valor + (Constantes.QUINIENTOS - modulo);
		} else if (modulo > Constantes.QUINIENTOS && modulo < Constantes.MIL) {
			valorRedondeo = valor + (Constantes.MIL - modulo);
		}

		return valorRedondeo;
	}

	/**
	 * Redondear un numero double.
	 *
	 * @param numero
	 *            a redondear
	 * @return numero redondeado
	 */
	public double redondear(double numero) {
		return Math.rint(numero * CIEN) / CIEN;
	}

	/**
	 * Round two decimals.
	 *
	 * @param d
	 *            the d
	 * @return el valor double redondeado
	 */
	public double roundTwoDecimals(double d) {
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		return Double.valueOf(twoDForm.format(d));
	}

	/**
	 * validarRangoNumero
	 *
	 * @param rango
	 *            the rango
	 * @param numero
	 *            the numero
	 * @return el valor de la validacion
	 */
	public boolean validarRangoNumero(Double rango, Double numero) {
		Double rangoA = rango + 1;
		Double rangoB = rango - 1;
		boolean respuesta = false;

		if (numero > rangoB & numero < rangoA) {
			respuesta = true;
		}

		return respuesta;
	}

	/**
	 * Guarda la solicitud de un credito.
	 *
	 * @param uid
	 *            the uid
	 * @param solicitudesSACGPeticion
	 *            the solicitudes sacg peticion
	 * @return the solicitudes respuesta
	 */
	@SuppressWarnings({ "unchecked", "null" })
	public SolicitudesRespuesta guardarSolicitudCreditoTarea(String uid,
			SolicitudSACGPeticion solicitudesSACGPeticion) {
		SolicitudesRespuesta solicitudesRespuesta = new SolicitudesRespuesta();
		solicitudesRespuesta.setHeader(new EncabezadoRespuesta());
		solicitudesRespuesta.getHeader().setUID(uid);
		solicitudesRespuesta.getHeader().setEstatus(true);
		SqlSession sesionTx = null;
		SqlSession sesionNTx = null;
		String mensaje = "";
		String validaStr = "";
		int registrosAfectados = 0;
		String msjRompeFlujo = "break";
		String msjInformativo = "continue";
		String msjPopUp = "popUp";
		String msjCuposMontos = "";
		String tipoTareaCampana = "";
		int tareaPendienteCuposYMonto = 0;

		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			if (solicitudesSACGPeticion == null) {
				throw new Exception(DATOS_INCORRECTOS);
			}

			ValidarGuardarSolicitudRespuesta validacionesRespuesta = validarGuardarSolicitudCredito(
					uid, solicitudesSACGPeticion);

			// se recupera si existe un tarea pendiente de cupo y monto TRCE
			tareaPendienteCuposYMonto = tareasPendientes(uid,
					solicitudesSACGPeticion.getSolicitudSACG(),
					Constantes.TAREA_CUPO_MONTO);
			LogHandler.info(uid, this.getClass(),
					"guardarSolicitudCreditoTarea--tareaspendientesTRCE: "
							+ tareaPendienteCuposYMonto);

			// se recupera si existe una tarea pendiente TRED
			tareasPendientes(uid, solicitudesSACGPeticion.getSolicitudSACG(),
					Constantes.TAREA_DOCUMENTAL);
			LogHandler.info(uid, this.getClass(),
					"guardarSolicitudCreditoTarea--tareaspendientesTRED: "
							+ solicitudesSACGPeticion.getSolicitudSACG()
									.getTareaDocumentalPendiente());

			// Validacion dia de pago y dia reunion
			EncabezadoRespuesta respuestaValidacionDiaPago = validarDiaReunionPago(
					uid, solicitudesSACGPeticion);
			if (!respuestaValidacionDiaPago.isEstatus()) {
				throw new Exception(respuestaValidacionDiaPago.getMensaje());
			}

			// Validaciones renovacion financiada
			if (solicitudesSACGPeticion.getSolicitudSACG().getRenovacion()
					&& solicitudesSACGPeticion.getSolicitudSACG()
							.getRenovacionFinanciada()) {
				// Validar contrato
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getContratoPrevio() == null
						|| solicitudesSACGPeticion.getSolicitudSACG()
								.getContratoPrevio().trim().isEmpty()) {
					throw new Exception(
							"Es necesario un contrato previo para renovacion financiada.");
				}
				ValidarContratoPeticion peticionValidaFinanciada = new ValidarContratoPeticion();
				peticionValidaFinanciada.setContrato(solicitudesSACGPeticion
						.getSolicitudSACG().getContratoPrevio());
				ValidarContratoRespuesta resValidacion = validarContratoRenovacionFinanciada(
						uid, peticionValidaFinanciada);
				if (!resValidacion.getHeader().isEstatus()) {
					throw new Exception(resValidacion.getHeader().getMensaje());
				}

				// Se agrega validacion Desertor Aplicar Garantia ***
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getAplicarGarantiaDesertor().equals("S")) {
					Double sumaPctParticipacion = 0.0;
					Double montoAplicarGarantiaDesertor = 0.0;
					Double saldoActualDesertores = 0.0;

					// Datos Contrato Anterior
					String contratoAnterior = comun.obtenerNumeroContrato(uid,
							solicitudesSACGPeticion.getSolicitudSACG()
									.getContratoPrevio());

					if (contratoAnterior == null) {
						throw new Exception(
								"No hay resultados para obtener el numero de contrato anterior.");
					}

					// Se obtiene porcentaje participacion por integrantes si es
					// Desertor
					for (int i = 0; i < solicitudesSACGPeticion
							.getSolicitudSACGIntegrantes().size(); i++) {
						if (solicitudesSACGPeticion
								.getSolicitudSACGIntegrantes().get(i)
								.getDesertor().equals("S")) {

							final java.util.HashMap<String, Object> parametrosIntegrante = new HashMap<String, Object>();
							parametrosIntegrante.put("contrato",
									contratoAnterior);
							parametrosIntegrante.put(
									"integrante",
									solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getCodigoPocg());
							Double pctParticipacion = (Double) sesionNTx
									.selectOne(
											"obtenerPctParticipacionIntegrante",
											parametrosIntegrante);

							if (pctParticipacion == null) {
								throw new Exception(
										"No hay resultados para obtener el porcentaje de participacion del cliente "
												+ solicitudesSACGPeticion
														.getSolicitudSACGIntegrantes()
														.get(i).getCodigoPocg());
							}

							solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.setPctParticipacion(pctParticipacion);
						}
					}

					// Se obtiene la suma pctj participacion
					for (int i = 0; i < solicitudesSACGPeticion
							.getSolicitudSACGIntegrantes().size(); i++) {
						if (solicitudesSACGPeticion
								.getSolicitudSACGIntegrantes().get(i)
								.getDesertor().equals("S")) {
							sumaPctParticipacion = sumaPctParticipacion
									+ solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getPctParticipacion();

							montoAplicarGarantiaDesertor = montoAplicarGarantiaDesertor
									+ solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getGarantiaAplicada();

							saldoActualDesertores = saldoActualDesertores
									+ solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getSaldoActual();
						}

					}

					LogHandler.info(uid, getClass(), "sumaPctParticipacion: "
							+ sumaPctParticipacion);
					LogHandler.info(uid, getClass(),
							"montoAplicarGarantiaDesertor: "
									+ montoAplicarGarantiaDesertor);
					LogHandler.info(uid, getClass(), "saldoActualDesertores: "
							+ saldoActualDesertores);

					final java.util.HashMap<String, Object> parametrosConAnt = new HashMap<String, Object>();
					parametrosConAnt.put("contratoAnt", contratoAnterior);

					LogHandler.trace(uid, getClass(),
							"confirmarCreditoTarea: - obtDatAntConfirmar");
					ContratoOV contratoAntOV = (ContratoOV) sesionNTx
							.selectOne("obtDatAntConfirmar", parametrosConAnt);

					if (contratoAntOV == null) {
						throw new Exception(
								"No se pudo recuperar informacion del contrato anterior para el traspaso de"
										+ " garantia.");
					}

					LogHandler.info(uid, getClass(), "saldoActualCredito: "
							+ contratoAntOV.getSaldoGarantia());

					for (int i = 0; i < solicitudesSACGPeticion
							.getSolicitudSACGIntegrantes().size(); i++) {
						if (solicitudesSACGPeticion
								.getSolicitudSACGIntegrantes().get(i)
								.getDesertor().equals("S")) {

							// Cambio si supera monto financiado por integrante
							if (saldoActualDesertores <= contratoAntOV
									.getSaldoGarantia()) {
								solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes()
										.get(i)
										.setValidaDesertorGarantiaAplicar(
												solicitudesSACGPeticion
														.getSolicitudSACGIntegrantes()
														.get(i)
														.getSaldoActual());
							} else {

								solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes()
										.get(i)
										.setValidaDesertorGarantiaAplicar(
												roundTwoDecimals(solicitudesSACGPeticion
														.getSolicitudSACGIntegrantes()
														.get(i)
														.getPctParticipacion()
														* contratoAntOV
																.getSaldoGarantia()
														/ sumaPctParticipacion));
							}

							LogHandler
									.info(uid,
											getClass(),
											"montoDesertorGarantiaCalculado: "
													+ solicitudesSACGPeticion
															.getSolicitudSACGIntegrantes()
															.get(i)
															.getValidaDesertorGarantiaAplicar()
															.doubleValue());
							LogHandler
									.info(uid,
											getClass(),
											"montoDesertorGarantiaRecibido: "
													+ roundTwoDecimals(solicitudesSACGPeticion
															.getSolicitudSACGIntegrantes()
															.get(i)
															.getGarantiaAplicada()));

							// if
							// (solicitudesSACGPeticion.getSolicitudSACGIntegrantes().get(i).getValidaDesertorGarantiaAplicar()
							// .doubleValue()
							// !=
							// roundTwoDecimals(solicitudesSACGPeticion.getSolicitudSACGIntegrantes().get(i)
							// .getGarantiaAplicada())) {
							// throw new
							// Exception("El monto del desertor que se desea aplicar es invalido para el cliente: "
							// +
							// solicitudesSACGPeticion.getSolicitudSACGIntegrantes().get(i).getCodigoPocg());
							// }

							if (!validarRangoNumero(
									solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i)
											.getValidaDesertorGarantiaAplicar()
											.doubleValue(),
									roundTwoDecimals(solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getGarantiaAplicada()))) {
								throw new Exception(
										"El monto del desertor que se desea aplicar es invalido para el cliente: "
												+ solicitudesSACGPeticion
														.getSolicitudSACGIntegrantes()
														.get(i).getCodigoPocg());
							}
						}
					} // fin for

				} // fin validacion aplicar garantia desertores

			}

			if (!validacionesRespuesta.getHeader().isEstatus()) {
				// RIMM:: Fase 1 ORIG-276 Automatizacion de consulta de Buro
				if (validacionesRespuesta.getHeader().getCodigo() != null) {
					solicitudesRespuesta.getHeader().setCodigo(
							validacionesRespuesta.getHeader().getCodigo());
					throw new Exception(validacionesRespuesta.getHeader()
							.getMensaje());
				}
				// RIMM::Fase 2 ORIG-276 Automatizacion de consulta de Buro
				if (validacionesRespuesta.getHeader().getMensaje()
						.endsWith(msjInformativo)) {
					msjCuposMontos = validacionesRespuesta.getHeader()
							.getMensaje().replace(msjInformativo, "");
				} else {
					if (validacionesRespuesta.getHeader().getMensaje()
							.endsWith(msjRompeFlujo)) {
						validacionesRespuesta.getHeader().setMensaje(
								validacionesRespuesta.getHeader().getMensaje()
										.replace(msjRompeFlujo, ""));
					} else if (validacionesRespuesta.getHeader().getMensaje()
							.endsWith(msjPopUp)) {
						String msj = validacionesRespuesta.getHeader()
								.getMensaje().replace(msjPopUp, "");
						solicitudesRespuesta.setExcepcionCupoMonto(true);
						if (msj.startsWith(Constantes.TIPO_TAREA_CUPO)) {
							tipoTareaCampana = Constantes.TIPO_TAREA_CUPO;
							msj = msj.replace(Constantes.TIPO_TAREA_CUPO, "");
						} else if (msj.startsWith(Constantes.TIPO_TAREA_MONTO)) {
							tipoTareaCampana = Constantes.TIPO_TAREA_MONTO;
							msj = msj.replace(Constantes.TIPO_TAREA_MONTO, "");
						} else if (msj
								.startsWith(Constantes.TIPO_TAREA_CUPO_MONTO)) {
							tipoTareaCampana = Constantes.TIPO_TAREA_CUPO_MONTO;
							msj = msj.replace(Constantes.TIPO_TAREA_CUPO_MONTO,
									"");
						}
						validacionesRespuesta.getHeader().setMensaje(msj);
					}
					throw new Exception(validacionesRespuesta.getHeader()
							.getMensaje());
				}
				if (!validacionesRespuesta.getHeader().getMensaje().equals("")
						&& msjCuposMontos.equals("")) {
					throw new Exception(validacionesRespuesta.getHeader()
							.getMensaje());
				}
			}

			if (solicitudesSACGPeticion.getSolicitudSACG().getVisualizaCec() != null
					&& solicitudesSACGPeticion.getSolicitudSACG()
							.getVisualizaCec().trim().toLowerCase()
							.equals("true")) {

				ValidarGuardarSolicitudCECRespuesta valCECRespuesta = validarGuardarSolicitudCECCreditoSol(
						uid, solicitudesSACGPeticion);

				if (!valCECRespuesta.getHeader().isEstatus()) {
					solicitudesRespuesta
							.getHeader()
							.setCodigo(
									valCECRespuesta.getHeader().getCodigo() != null ? valCECRespuesta
											.getHeader().getCodigo() : " ");
					throw new Exception(
							"Error al validar - validarGuardarSolicitudCECCreditoSol: "
									+ valCECRespuesta.getHeader().getMensaje() != null ? valCECRespuesta
									.getHeader().getMensaje()
									: "Ocurrio un error en validarGuardarSolicitudCECCreditoSol");
				}

				// Falta el envio al CEC +++? Se envia al CEC con el nuevo
				// metodo???

			}

			sesionTx = FabricaConexiones.obtenerSesionTx();

			// Obtiene cargos de los integrantes:
			String cargoPresidente = "";
			String cargoSecretario = "";
			String cargoSupervisor = "";
			String cargoTesorero = "";

			String[] integranteDatosRequeridos = { "codigoT24",
					"nuevoCreditoSolicitado", "ahorro", "propositoPrestamo",
					"aprobado", "tipoLocalidad" };
			DomicilioOV domicilioOV = null;
			GrupoOV grupoOV = new GrupoOV();
			if (solicitudesSACGPeticion.getSolicitudSACGGrupo() != null) {
				if (solicitudesSACGPeticion.getSolicitudSACGGrupo()
						.getPresidente() != null
						&& !solicitudesSACGPeticion.getSolicitudSACGGrupo()
								.getPresidente().equalsIgnoreCase("")) {
					LogHandler
							.trace(uid, getClass(),
									"guardarSolicitudCreditoTarea: - buscarClavePersonaSolicitud.Presidente");
					LogHandler
							.info(uid, getClass(),
									"guardarSolicitudCreditoTarea: - buscarClavePersonaSolicitud.Presidente");
					cargoPresidente = (String) sesionTx.selectOne(
							"buscarClavePersonaSolicitud",
							solicitudesSACGPeticion.getSolicitudSACGGrupo()
									.getPresidente());
					LogHandler.info(uid, getClass(),
							"guardarSolicitudCreditoTarea: - cargoPresidente: "
									+ cargoPresidente);
				}
				if (solicitudesSACGPeticion.getSolicitudSACGGrupo()
						.getSecretario() != null
						&& !solicitudesSACGPeticion.getSolicitudSACGGrupo()
								.getSecretario().equalsIgnoreCase("")) {
					LogHandler
							.trace(uid, getClass(),
									"guardarSolicitudCreditoTarea: - buscarClavePersonaSolicitud.Secretario");
					LogHandler
							.info(uid, getClass(),
									"guardarSolicitudCreditoTarea: - buscarClavePersonaSolicitud.Secretario");
					cargoSecretario = (String) sesionTx.selectOne(
							"buscarClavePersonaSolicitud",
							solicitudesSACGPeticion.getSolicitudSACGGrupo()
									.getSecretario());
					LogHandler.info(uid, getClass(),
							"guardarSolicitudCreditoTarea: - cargoSecretario: "
									+ cargoSecretario);
				}
				if (solicitudesSACGPeticion.getSolicitudSACGGrupo()
						.getSupervisor() != null
						&& !solicitudesSACGPeticion.getSolicitudSACGGrupo()
								.getSupervisor().equalsIgnoreCase("")) {
					LogHandler
							.trace(uid, getClass(),
									"guardarSolicitudCreditoTarea: - buscarClavePersonaSolicitud.Supervisor");
					LogHandler
							.info(uid, getClass(),
									"guardarSolicitudCreditoTarea: - buscarClavePersonaSolicitud.Supervisor");
					cargoSupervisor = (String) sesionTx.selectOne(
							"buscarClavePersonaSolicitud",
							solicitudesSACGPeticion.getSolicitudSACGGrupo()
									.getSupervisor());
					LogHandler.info(uid, getClass(),
							"guardarSolicitudCreditoTarea: - cargoSupervisor: "
									+ cargoSupervisor);
				}
				if (solicitudesSACGPeticion.getSolicitudSACGGrupo()
						.getTesorero() != null
						&& !solicitudesSACGPeticion.getSolicitudSACGGrupo()
								.getTesorero().equalsIgnoreCase("")) {
					LogHandler
							.trace(uid, getClass(),
									"guardarSolicitudCreditoTarea: - buscarClavePersonaSolicitud.Tesorero");
					LogHandler
							.info(uid, getClass(),
									"guardarSolicitudCreditoTarea: - buscarClavePersonaSolicitud.Tesorero");
					cargoTesorero = (String) sesionTx.selectOne(
							"buscarClavePersonaSolicitud",
							solicitudesSACGPeticion.getSolicitudSACGGrupo()
									.getTesorero());
					LogHandler.info(uid, getClass(),
							"guardarSolicitudCreditoTarea: - cargoTesorero: "
									+ cargoTesorero);
				}

			}

			java.lang.String solicitudFolio = "";
			// INSERT Solicitud.
			if (solicitudesSACGPeticion.getSolicitudSACG().getId() == null
					|| solicitudesSACGPeticion.getSolicitudSACG().getId()
							.equalsIgnoreCase("")
					|| solicitudesSACGPeticion.getSolicitudSACG().getId()
							.equalsIgnoreCase("0")) {
				mensaje = SOLICITUD_GUARDADA;

				String[] grupoDatosRequeridos = { "nombre", "analista" };

				if (solicitudesSACGPeticion.getSolicitudSACGGrupo() == null) {
					throw new Exception(DATOS_INCORRECTOS);
				}

				validaStr = Validaciones.datosRequeridos(
						solicitudesSACGPeticion.getSolicitudSACGGrupo(),
						grupoDatosRequeridos);
				if (!validaStr.equalsIgnoreCase("")) {
					throw new Exception(DATOS_REQUERIDOS + validaStr);
				}

				LogHandler
						.trace(uid, getClass(),
								"guardarSolicitudCreditoTarea: - obtenerFolioSolicitud");
				LogHandler
						.info(uid, getClass(),
								"guardarSolicitudCreditoTarea: - obtenerFolioSolicitud");
				solicitudFolio = (java.lang.String) sesionNTx
						.selectOne("obtenerFolioSolicitud");

				solicitudesSACGPeticion.getSolicitudSACG()
						.setId(solicitudFolio);

				String[] solicitudDatosRequeridos = { "id", "sucursal", "tasa",
						"plazo", "nuevoCreditoSolicitado", "renovacion",
						"visualizaCec", "renovacionFinanciada" };

				validaStr = Validaciones.datosRequeridos(
						solicitudesSACGPeticion.getSolicitudSACG(),
						solicitudDatosRequeridos);
				if (!validaStr.equalsIgnoreCase("")) {
					throw new Exception(DATOS_REQUERIDOS + validaStr);
				}

				// ::::::::::::::::::::::::::::::::::::::::::::::::::::: grupo
				// ::::::::::::::::::::::::::::::

				// Obtener el numero persona de Grupo. IN: clave_finsol; OUT:
				// persona.
				String grupoPersona = null;
				if (solicitudesSACGPeticion.getSolicitudSACGGrupo().getCodigo() != null) {
					LogHandler
							.trace(uid, getClass(),
									"guardarSolicitudCreditoTarea: - obtenerPersonaMin");
					LogHandler
							.info(uid, getClass(),
									"guardarSolicitudCreditoTarea: - obtenerPersonaMin");
					grupoPersona = (String) sesionNTx.selectOne(
							"obtenerPersonaMin", solicitudesSACGPeticion
									.getSolicitudSACGGrupo().getCodigo());
				}

				if (grupoPersona == null) {
					final HashMap<String, String> id = grupo
							.obtenerIdentificador(uid);
					if (id.get("credprod") != null && id.get("t24") != null) {
						grupoOV.setIdentificador(id.get("credprod"));
						grupoOV.setClienteT24(id.get("t24"));
						grupoOV.setNombre(solicitudesSACGPeticion
								.getSolicitudSACGGrupo().getNombre());

						if (solicitudesSACGPeticion.getSolicitudSACGGrupo()
								.getFechaConformacion() != null) {
							grupoOV.setFecha_conformacion(solicitudesSACGPeticion
									.getSolicitudSACGGrupo()
									.getFechaConformacion());
						}

						if (solicitudesSACGPeticion.getSolicitudSACG()
								.getPersonaDomReunion() != null
								&& !solicitudesSACGPeticion.getSolicitudSACG()
										.getPersonaDomReunion()
										.equalsIgnoreCase("")) {

							final HashMap<String, Object> parametros = new HashMap<String, Object>();
							parametros.put("persona", solicitudesSACGPeticion
									.getSolicitudSACG().getPersonaDomReunion());
							HashMap<String, Object> datosExtraPersona = new HashMap<String, Object>();
							LogHandler
									.trace(uid, getClass(),
											"guardarSolicitudCreditoTarea: consultarDatosExtraPersona");
							LogHandler
									.info(uid, getClass(),
											"guardarSolicitudCreditoTarea: consultarDatosExtraPersona");
							datosExtraPersona = (HashMap<String, Object>) sesionNTx
									.selectOne("consultarDatosExtraPersona",
											parametros);
							if (datosExtraPersona != null) {
								domicilioOV = new DomicilioOV();
								domicilioOV.setCalle(datosExtraPersona.get(
										"calle").toString());
								domicilioOV.setColonia(datosExtraPersona.get(
										"colonia").toString());
								domicilioOV.setCp((Integer) datosExtraPersona
										.get("cp"));
								domicilioOV.setLocalidad(datosExtraPersona.get(
										"ciudad").toString());
								domicilioOV.setEntidad(datosExtraPersona.get(
										"entidad").toString());
								domicilioOV.setMunicipio(datosExtraPersona.get(
										"municipio").toString());
							}
						}
						if (domicilioOV == null) {
							domicilioOV = new DomicilioOV();
							domicilioOV.setCalle("");
							domicilioOV.setColonia("");
							domicilioOV.setCp(0);
							domicilioOV.setLocalidad("");
							domicilioOV.setEntidad("");
							domicilioOV.setMunicipio("");
						}
						// domicilioOV
						grupoOV.setDomicilio(domicilioOV);
						ResultadoOV resultado;
						resultado = grupo.registrar(uid, grupoOV);
						if (!resultado.isSuccess()) {
							throw new Exception(resultado.getCodigo());
						}
						grupoPersona = id.get("credprod");
					} else {
						throw new Exception(ERROR_INSERCION);
					}
				}

				// ::::::::::::::::::::::::::::::::::::::::::::::::::::::::
				// /grupo :::::::::::::::::::::::::::

				// :::::::::::::::::::::::::::::::::::::::::::::::::::::
				// solicitud :::::::::::::::::::::::::::

				SolicitudesOV solicitudesOV = new SolicitudesOV();

				solicitudesOV.setSolicitud(solicitudFolio);
				solicitudesOV.setOficina(solicitudesSACGPeticion
						.getSolicitudSACG().getSucursal());
				solicitudesOV.setTasa(solicitudesSACGPeticion
						.getSolicitudSACG().getTasa());
				solicitudesOV.setPlazo(solicitudesSACGPeticion
						.getSolicitudSACG().getPlazo());
				solicitudesOV.setEfectivoSolicitado(solicitudesSACGPeticion
						.getSolicitudSACG().getNuevoCreditoSolicitado());

				if (solicitudesSACGPeticion.getSolicitudSACG().getRenovacion()) {
					if (solicitudesSACGPeticion.getSolicitudSACG()
							.getRenovacionFinanciada()) {
						solicitudesOV
								.setCategoria(SOLICITUD_CATEGORIA_FINANCIADA);
					} else {
						solicitudesOV
								.setCategoria(SOLICITUD_CATEGORIA_ORDINARIA);
					}
				}

				solicitudesOV.setStatus(SOLICITUD_STATUS_APROBADO);
				solicitudesOV.setCliente(grupoPersona);
				solicitudesOV.setEtapa(solicitudesSACGPeticion
						.getSolicitudSACG().getVisualizaCec());

				if (solicitudesSACGPeticion.getSolicitudSACG().getCiclo() != null) {
					solicitudesOV.setCiclo(solicitudesSACGPeticion
							.getSolicitudSACG().getCiclo());
				} else {
					solicitudesOV.setCiclo(0);
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getContratoPrevio() != null) {
					// Obtener contrato de contrato_clave_finsol para contrato
					// anterior.
					LogHandler
							.trace(uid,
									getClass(),
									"guardarSolicitudCreditoTarea.insert.solicitud.ContratoPrevio: - obtenerRelacionContrato");
					LogHandler
							.info(uid,
									getClass(),
									"guardarSolicitudCreditoTarea.insert.solicitud.ContratoPrevio: - obtenerRelacionContrato");
					String contratoTmp = (String) sesionNTx.selectOne(
							"obtenerRelacionContrato", solicitudesSACGPeticion
									.getSolicitudSACG().getContratoPrevio());
					if (contratoTmp == null) {
						throw new Exception(
								ReadProperties.mensajes
										.getProp("ciof.contratoinvalido"));
					}
					solicitudesOV.setContratoAnt(contratoTmp);
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getDiaPago() != null) {
					solicitudesOV.setDiaPago(solicitudesSACGPeticion
							.getSolicitudSACG().getDiaPago());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getProducto() != null) {
					solicitudesOV.setCodigoProducto(solicitudesSACGPeticion
							.getSolicitudSACG().getProducto());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getFrecuenciaPago() != null) {
					solicitudesOV.setFrecuenciaPago(solicitudesSACGPeticion
							.getSolicitudSACG().getFrecuenciaPago());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getDiaReunion() != null) {
					solicitudesOV.setDiaReunion(solicitudesSACGPeticion
							.getSolicitudSACG().getDiaReunion());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getHoraReunion() != null) {
					solicitudesOV.setHoraReunion(solicitudesSACGPeticion
							.getSolicitudSACG().getHoraReunion());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getFechaSolicitud() != null) {
					solicitudesOV.setFechaCaptura(solicitudesSACGPeticion
							.getSolicitudSACG().getFechaSolicitud());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getFechaDesembolso() != null) {
					solicitudesOV.setFechaResolucion(solicitudesSACGPeticion
							.getSolicitudSACG().getFechaDesembolso());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getUsuarioRegistraSolicitud() != null) {
					solicitudesOV
							.setUsuarioRegistraSolicitud(solicitudesSACGPeticion
									.getSolicitudSACG()
									.getUsuarioRegistraSolicitud());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getHoraReunionFin() != null) {
					solicitudesOV.setHoraReunionFin(solicitudesSACGPeticion
							.getSolicitudSACG().getHoraReunionFin());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getPersonaDomReunion() != null) {
					if (!solicitudesSACGPeticion.getSolicitudSACG()
							.getPersonaDomReunion().trim().isEmpty()) {
						solicitudesOV
								.setPersonaDomReunion(comun
										.obtenerPersonaCliente(uid,
												solicitudesSACGPeticion
														.getSolicitudSACG()
														.getPersonaDomReunion()
														.trim()));
					}
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getExcepcionGarantia() != null) {
					solicitudesOV.setExcepcionGarantia(solicitudesSACGPeticion
							.getSolicitudSACG().getExcepcionGarantia());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getAutorizacionGarantia() != null) {
					solicitudesOV
							.setAutorizacionGarantia(solicitudesSACGPeticion
									.getSolicitudSACG()
									.getAutorizacionGarantia());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getUsuarioAutorizacion() != null) {
					solicitudesOV
							.setUsuarioAutorizacion(solicitudesSACGPeticion
									.getSolicitudSACG()
									.getUsuarioAutorizacion());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getFechaAutorizacion() != null) {
					solicitudesOV.setFechaAutorizacion(solicitudesSACGPeticion
							.getSolicitudSACG().getFechaAutorizacion());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getSeguro() != null) {
					solicitudesOV.setSeguro(solicitudesSACGPeticion
							.getSolicitudSACG().getSeguro());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getSeguro() == null) {
					solicitudesOV.setSeguro("N");
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getEstatus() != null) {
					solicitudesOV.setEstatus(solicitudesSACGPeticion
							.getSolicitudSACG().getEstatus());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getDesEstatus() != null) {
					solicitudesOV.setDescripcion(solicitudesSACGPeticion
							.getSolicitudSACG().getDesEstatus());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getFechaFin() != null) {
					solicitudesOV.setFechaFin(solicitudesSACGPeticion
							.getSolicitudSACG().getFechaFin());
				}

				if (solicitudesSACGPeticion.getSolicitudSACG().getCdgAsesor() != null) {
					solicitudesOV.setVendedor(solicitudesSACGPeticion
							.getSolicitudSACG().getCdgAsesor());
				} else {
					solicitudesOV.setVendedor(solicitudesSACGPeticion
							.getSolicitudSACGGrupo().getAnalista());
				}

				if (solicitudesSACGPeticion.getSolicitudSACG().getContratoLD() != null) {
					if (!solicitudesSACGPeticion.getSolicitudSACG()
							.getContratoLD().equalsIgnoreCase("")) {
						// Obtener contrato de contrato_clave_finsol
						LogHandler
								.trace(uid,
										getClass(),
										"guardarSolicitudCreditoTarea.insert.solicitud.ContratoLD: - obtenerRelacionContrato");
						LogHandler
								.info(uid,
										getClass(),
										"guardarSolicitudCreditoTarea.insert.solicitud.ContratoLD: - obtenerRelacionContrato");
						String contratoTmp = (String) sesionNTx.selectOne(
								"obtenerRelacionContrato",
								solicitudesSACGPeticion.getSolicitudSACG()
										.getContratoLD());
						if (contratoTmp == null) {
							throw new Exception(
									ReadProperties.mensajes
											.getProp("ciof.contratoinvalido"));
						}
						solicitudesOV.setContrato(contratoTmp);
					}
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getExpress() != null) {
					solicitudesOV.setExpress(solicitudesSACGPeticion
							.getSolicitudSACG().getExpress());
				} else {
					solicitudesOV.setExpress("N");
				}

				if (solicitudesSACGPeticion.getSolicitudSACG().getCampana() != null) {
					solicitudesOV.setCampana(solicitudesSACGPeticion
							.getSolicitudSACG().getCampana());
				}

				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getSenalamientoExcepcion() != null) {
					solicitudesOV
							.setSenalamientoExcepcion(solicitudesSACGPeticion
									.getSolicitudSACG()
									.getSenalamientoExcepcion());
				}

				// Deposito Garantia ***

				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getTraspasoGarantia() != null) {
					solicitudesOV.setTraspasoGarantia(solicitudesSACGPeticion
							.getSolicitudSACG().getTraspasoGarantia());
				}

				if (solicitudesSACGPeticion.getSolicitudSACG().getPctGarantia() != null) {
					solicitudesOV.setPctGarantia(solicitudesSACGPeticion
							.getSolicitudSACG().getPctGarantia());
				} else {
					solicitudesOV.setPctGarantia(0);
				}
				// MIMH 20150713
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getAplicarGarantia() == null) {
					solicitudesOV.setAplicarGarantia("N");
				} else {
					solicitudesOV.setAplicarGarantia(solicitudesSACGPeticion
							.getSolicitudSACG().getAplicarGarantia());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getAplicarGarantiaDesertor() == null) {
					solicitudesOV.setAplicarGarantiaDesertor("N");
				} else {
					solicitudesOV
							.setAplicarGarantiaDesertor(solicitudesSACGPeticion
									.getSolicitudSACG()
									.getAplicarGarantiaDesertor());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getJustificacionExc() == null) {
					solicitudesOV.setJustificacionExc("");
				} else {
					solicitudesOV.setJustificacionExc(solicitudesSACGPeticion
							.getSolicitudSACG().getJustificacionExc());
				}

				// Fin Deposito Garantia

				java.util.HashMap<String, Object> solicitudParametros = Funciones
						.objectToHashMapInsert(solicitudesOV);
				LogHandler.trace(uid, getClass(),
						"guardarSolicitudCreditoTarea: - insertaSolicitud");
				LogHandler.info(uid, getClass(),
						"guardarSolicitudCreditoTarea: - insertaSolicitud");
				registrosAfectados = sesionTx.insert("insertaSolicitud",
						solicitudParametros);
				LogHandler.info(uid, getClass(),
						"guardarSolicitudCreditoTarea: - registrosAfectados: "
								+ registrosAfectados);
				if (registrosAfectados == 0) {
					throw new Exception(ERROR_INSERCION);
				}

				// :::::::::::::::::::::::::::::::::::::::::::::::::::::
				// /solicitud :::::::::::::::::::::::::::::::::::::::::::

				// :::::::::::::::::::::::::::::::::::::::::::::::::::::
				// integrantes ::::::::::::::::::::::::::::::::::::::::::

				if (solicitudesSACGPeticion.getSolicitudSACGIntegrantes() != null) {
					for (int i = 0; i < solicitudesSACGPeticion
							.getSolicitudSACGIntegrantes().size(); i++) {
						if (solicitudesSACGPeticion
								.getSolicitudSACGIntegrantes().get(i)
								.getStatus() == null) {

							validaStr = Validaciones.datosRequeridos(
									solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes().get(
													i),
									integranteDatosRequeridos);
							if (!validaStr.equalsIgnoreCase("")) {
								throw new Exception(DATOS_REQUERIDOS
										+ validaStr);
							}

							java.util.HashMap<String, Object> integranteParametros = null;
							SolicitudIntegrantesOV solicitudIntegrantesOV = new SolicitudIntegrantesOV();
							solicitudIntegrantesOV.setSolicitud(solicitudFolio);

							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getCodigoPocg() == null
									|| solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getCodigoPocg()
											.equalsIgnoreCase("")) {
								// Realizar consulta con CODIGO_T24
								LogHandler
										.trace(uid, getClass(),
												"guardarSolicitudCreditoTarea: - buscarClavePersonaSolicitud");
								LogHandler
										.info(uid, getClass(),
												"guardarSolicitudCreditoTarea: - buscarClavePersonaSolicitud");
								solicitudIntegrantesOV
										.setCliente((String) sesionTx
												.selectOne(
														"buscarClavePersonaSolicitud",
														solicitudesSACGPeticion
																.getSolicitudSACGIntegrantes()
																.get(i)
																.getCodigoT24()));
							} else {
								solicitudIntegrantesOV
										.setCliente(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getCodigoPocg());
							}

							if (solicitudIntegrantesOV.getCliente()
									.equalsIgnoreCase(cargoPresidente)) {
								solicitudIntegrantesOV
										.setCargoMesaDirectiva(ID_PRESIDENTE);
							} else if (solicitudIntegrantesOV.getCliente()
									.equalsIgnoreCase(cargoSecretario)) {
								solicitudIntegrantesOV
										.setCargoMesaDirectiva(ID_SECRETARIO);
							} else if (solicitudIntegrantesOV.getCliente()
									.equalsIgnoreCase(cargoSupervisor)) {
								solicitudIntegrantesOV
										.setCargoMesaDirectiva(ID_SUPERVISOR);
							} else if (solicitudIntegrantesOV.getCliente()
									.equalsIgnoreCase(cargoTesorero)) {
								solicitudIntegrantesOV
										.setCargoMesaDirectiva(ID_TESORERO);
							}

							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getUltimoCreditoAprobado() != null) {
								solicitudIntegrantesOV
										.setMontoContratoAnterior(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i)
												.getUltimoCreditoAprobado());
							}

							solicitudIntegrantesOV
									.setEfectivoSolicitado(solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getNuevoCreditoSolicitado());

							Double montoAhorro = (solicitudIntegrantesOV
									.getEfectivoSolicitado() * solicitudesOV
									.getPctGarantia())
									/ Constantes.CENTENA_DOUBLE;

							// Monto Ahorro
							solicitudIntegrantesOV.setMontoAhorro(montoAhorro);

							solicitudIntegrantesOV
									.setCodigoDestinoCredito(solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getPropositoPrestamo());
							solicitudIntegrantesOV
									.setAprobado(solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getAprobado());
							solicitudIntegrantesOV
									.setClasificacionFira(solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getTipoLocalidad());

							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getContratoPrevio() != null) {
								// Obtener contrato de contrato_clave_finsol
								// para contrato anterior de Integrante.
								LogHandler.trace(uid, getClass(),
										"guardarSolicitudCreditoTarea.insert.integrante.ContratoPrevio:"
												+ " - obtenerRelacionContrato");
								LogHandler.info(uid, getClass(),
										"guardarSolicitudCreditoTarea.insert.integrante.ContratoPrevio:"
												+ " - obtenerRelacionContrato");
								String contratoTmp = (String) sesionNTx
										.selectOne(
												"obtenerRelacionContrato",
												solicitudesSACGPeticion
														.getSolicitudSACGIntegrantes()
														.get(i)
														.getContratoPrevio());
								if (contratoTmp == null) {
									throw new Exception(
											ReadProperties.mensajes
													.getProp("ciof.contratoinvalido"));
								}
								solicitudIntegrantesOV
										.setContratoAnterior(contratoTmp);

							}

							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getSaldoActual() != null) {
								solicitudIntegrantesOV
										.setSaldoActual(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getSaldoActual());
							}

							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getConsultaBuro() != null) {
								solicitudIntegrantesOV
										.setReferencia(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getConsultaBuro());
							}

							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getSeguro() != null) {
								solicitudIntegrantesOV
										.setSeguro(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getSeguro());
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getSeguro() == null) {
								solicitudIntegrantesOV.setSeguro("N");
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getIguala() == null) {
								solicitudIntegrantesOV.setIguala("N");
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getCiclo() != null) {
								solicitudIntegrantesOV
										.setCiclo(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getCiclo());
							} else {
								solicitudIntegrantesOV.setCiclo(0);
							}

							// 20140911 Agregar plazo seguro
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getPlazoSeguro() == null) {
								solicitudIntegrantesOV.setPlazoSeguro("");
							} else {
								solicitudIntegrantesOV
										.setPlazoSeguro(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getPlazoSeguro());
							}

							// 20141010 Agregar seguro Enfermedad
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getSeguroEnfermedad() == null) {
								solicitudIntegrantesOV.setSeguroEnfermedad("");
							} else {
								solicitudIntegrantesOV
										.setSeguroEnfermedad(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getSeguroEnfermedad());
							}

							// Se agrega desertor
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getDesertor() == null) {
								solicitudIntegrantesOV.setDesertor("N");
							} else {
								solicitudIntegrantesOV
										.setDesertor(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getDesertor());

								if (solicitudIntegrantesOV.getDesertor()
										.equals("S")) {
									solicitudIntegrantesOV.setStatus("X");
								}
							}

							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getPerteneceCreditoRenovar() == null) {
								solicitudIntegrantesOV
										.setPerteneceCreditoRenovar("N");
							} else {
								solicitudIntegrantesOV
										.setPerteneceCreditoRenovar(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i)
												.getPerteneceCreditoRenovar());
							}

							// 20150721 garantia aplicar por desertor
							solicitudIntegrantesOV
									.setGarantiaAplicada(solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getGarantiaAplicada());

							solicitudIntegrantesOV
									.setDiferenciaPago(solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getDiferenciaPago());

							solicitudIntegrantesOV
									.setTipoDisposicion(INTEGRANTE_TDISP_CHEQUE);
							solicitudIntegrantesOV
									.setStatus(INTEGRANTE_STATUS_ACTIVO);
							LogHandler
									.trace(uid, getClass(),
											"guardarSolicitudCreditoTarea: - obtenerNumeroIntegrante");
							LogHandler
									.info(uid, getClass(),
											"guardarSolicitudCreditoTarea: - obtenerNumeroIntegrante");
							final Integer integranteNumeroQuery = (Integer) sesionTx
									.selectOne("obtenerNumeroIntegrante",
											solicitudFolio);
							if (integranteNumeroQuery == null) {
								throw new Exception(INTEGRANTE_ERROR_NUMERO);
							}
							solicitudIntegrantesOV
									.setNumeroIntegrante(integranteNumeroQuery);
							integranteParametros = Funciones
									.objectToHashMapInsert(solicitudIntegrantesOV);

							// Busca si el integrante ya esta insertado o
							// eliminado.
							java.util.HashMap<String, Object> integranteBuscaParametros = new java.util.HashMap<String, Object>();
							integranteBuscaParametros.put("solicitud",
									solicitudesOV.getSolicitud());
							integranteBuscaParametros.put("cliente",
									solicitudIntegrantesOV.getCliente());
							LogHandler
									.trace(uid, getClass(),
											"guardarSolicitudCreditoTarea: - buscaIntegranteStatusSolicitud");
							LogHandler
									.info(uid, getClass(),
											"guardarSolicitudCreditoTarea: - buscaIntegranteStatusSolicitud");
							java.util.HashMap<String, Object> clienteEliminadoQuery = (java.util.HashMap<String, Object>) sesionTx
									.selectOne(
											"buscaIntegranteStatusSolicitud",
											integranteBuscaParametros);
							if (clienteEliminadoQuery != null) {
								if (clienteEliminadoQuery.get("status").equals(
										"X")) {
									throw new Exception(
											INTEGRANTE_INSERT_DUPLICIDAD_E);
								} else {
									throw new Exception(
											INTEGRANTE_INSERT_DUPLICIDAD);
								}

							}

							LogHandler.trace(
									uid,
									getClass(),
									"guardarSolicitudCreditoTarea: - insertaSolicitudIntegrante.cliente: "
											+ solicitudIntegrantesOV
													.getCliente());
							LogHandler.info(
									uid,
									getClass(),
									"guardarSolicitudCreditoTarea: - insertaSolicitudIntegrante.cliente: "
											+ solicitudIntegrantesOV
													.getCliente());
							registrosAfectados = sesionTx.insert(
									"insertaSolicitudIntegrante",
									integranteParametros);
							LogHandler.info(uid, getClass(),
									"guardarSolicitudCreditoTarea: - registrosAfectados: "
											+ registrosAfectados);
							if (registrosAfectados == 0) {
								throw new Exception(ERROR_INSERCION);
							}
						}
					}
				}
				// :::::::::::::::::::::::::::::::::::::::::::::::::::::
				// /integrantes ::::::::::::::::::::::::::::

				// Atomo ORIGEN
				AtomosOV peticionAtomo = new AtomosOV();
				peticionAtomo.setSolicitud(solicitudesSACGPeticion
						.getSolicitudSACG().getId());
				peticionAtomo.setProceso("ORIGEN");
				peticionAtomo.setComentario("");
				peticionAtomo.setStatus("A");
				peticionAtomo.setUsuarioGeneroAtomo(solicitudesSACGPeticion
						.getSolicitudSACG().getUsuarioRegistraSolicitud());
				AtomosRespuesta atomosRespuesta = registrarAtomosTarea(uid,
						sesionTx, peticionAtomo);

				if (!atomosRespuesta.getHeader().isEstatus()) {
					throw new Exception(atomosRespuesta.getHeader()
							.getMensaje());
				}
			}

			// UPDATE Solictud.
			else {
				mensaje = SOLICITUD_ACTUALIZADA;

				// :::::::::::::::::::::::::::::::::::::::::::::::::::::
				// solicitud :::::::::::::::::::::::::::::::

				solicitudFolio = solicitudesSACGPeticion.getSolicitudSACG()
						.getId();
				SolicitudesOV solicitudesOV = new SolicitudesOV();
				solicitudesOV.setSolicitud(solicitudFolio);
				if (solicitudesSACGPeticion.getSolicitudSACG().getSucursal() != null) {
					solicitudesOV.setOficina(solicitudesSACGPeticion
							.getSolicitudSACG().getSucursal());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getProducto() != null) {
					solicitudesOV.setCodigoProducto(solicitudesSACGPeticion
							.getSolicitudSACG().getProducto());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getTasa() != null) {
					solicitudesOV.setTasa(solicitudesSACGPeticion
							.getSolicitudSACG().getTasa());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getPlazo() != null) {
					solicitudesOV.setPlazo(solicitudesSACGPeticion
							.getSolicitudSACG().getPlazo());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getFrecuenciaPago() != null) {
					solicitudesOV.setFrecuenciaPago(solicitudesSACGPeticion
							.getSolicitudSACG().getFrecuenciaPago());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getDiaReunion() != null) {
					solicitudesOV.setDiaReunion(solicitudesSACGPeticion
							.getSolicitudSACG().getDiaReunion());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getHoraReunion() != null) {
					solicitudesOV.setHoraReunion(solicitudesSACGPeticion
							.getSolicitudSACG().getHoraReunion());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getNuevoCreditoSolicitado() != null) {
					solicitudesOV.setEfectivoSolicitado(solicitudesSACGPeticion
							.getSolicitudSACG().getNuevoCreditoSolicitado());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getFechaSolicitud() != null) {
					solicitudesOV.setFechaCaptura(solicitudesSACGPeticion
							.getSolicitudSACG().getFechaSolicitud());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getFechaDesembolso() != null) {
					solicitudesOV.setFechaResolucion(solicitudesSACGPeticion
							.getSolicitudSACG().getFechaDesembolso());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getCdgAsesor() != null) {
					solicitudesOV.setVendedor(solicitudesSACGPeticion
							.getSolicitudSACG().getCdgAsesor());
				} else if (solicitudesSACGPeticion.getSolicitudSACGGrupo() != null
						&& solicitudesSACGPeticion.getSolicitudSACGGrupo()
								.getAnalista() != null) {
					solicitudesOV.setVendedor(solicitudesSACGPeticion
							.getSolicitudSACGGrupo().getAnalista());
				}

				if (solicitudesSACGPeticion.getSolicitudSACG().getRenovacion() != null
						&& solicitudesSACGPeticion.getSolicitudSACG()
								.getRenovacion()) {
					if (solicitudesSACGPeticion.getSolicitudSACG()
							.getRenovacionFinanciada() != null
							&& solicitudesSACGPeticion.getSolicitudSACG()
									.getRenovacionFinanciada()) {
						solicitudesOV
								.setCategoria(SOLICITUD_CATEGORIA_FINANCIADA);
					} else {
						solicitudesOV
								.setCategoria(SOLICITUD_CATEGORIA_ORDINARIA);
					}
				}

				if (solicitudesSACGPeticion.getSolicitudSACG().getContratoLD() != null) {
					if (!solicitudesSACGPeticion.getSolicitudSACG()
							.getContratoLD().equalsIgnoreCase("")) {
						// Obtener contrato de contrato_clave_finsol
						LogHandler.trace(uid, getClass(),
								"guardarSolicitudCreditoTarea.update.solicitud.ContratoLD:"
										+ " - obtenerRelacionContrato");
						LogHandler.info(uid, getClass(),
								"guardarSolicitudCreditoTarea.update.solicitud.ContratoLD:"
										+ " - obtenerRelacionContrato");
						String contratoTmp = (String) sesionNTx.selectOne(
								"obtenerRelacionContrato",
								solicitudesSACGPeticion.getSolicitudSACG()
										.getContratoLD());
						if (contratoTmp == null) {
							throw new Exception(
									ReadProperties.mensajes
											.getProp("ciof.contratoinvalido"));
						}
						solicitudesOV.setContrato(contratoTmp);
						// Se envia fecha pero se usa el GETDATE() en consulta.
						solicitudesOV.setHoraResolucion(new Date());
					}
				}

				if (solicitudesSACGPeticion.getSolicitudSACG().getCiclo() != null) {
					solicitudesOV.setCiclo(solicitudesSACGPeticion
							.getSolicitudSACG().getCiclo());
				}

				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getVisualizaCec() != null) {
					solicitudesOV.setEtapa(solicitudesSACGPeticion
							.getSolicitudSACG().getVisualizaCec());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getContratoPrevio() != null) {
					if (!solicitudesSACGPeticion.getSolicitudSACG()
							.getContratoPrevio().equalsIgnoreCase("")) {
						// Obtener contrato de contrato_clave_finsol para
						// contrato anterior.
						LogHandler.trace(uid, getClass(),
								"guardarSolicitudCreditoTarea.update.solicitud.ContratoPrevio:"
										+ " - obtenerRelacionContrato");
						LogHandler.info(uid, getClass(),
								"guardarSolicitudCreditoTarea.update.solicitud.ContratoPrevio:"
										+ " - obtenerRelacionContrato");
						String contratoTmp = (String) sesionNTx.selectOne(
								"obtenerRelacionContrato",
								solicitudesSACGPeticion.getSolicitudSACG()
										.getContratoPrevio());
						if (contratoTmp == null) {
							throw new Exception(
									ReadProperties.mensajes
											.getProp("ciof.contratoinvalido"));
						}
						solicitudesOV.setContratoAnt(contratoTmp);
					}
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getDiaPago() != null) {
					solicitudesOV.setDiaPago(solicitudesSACGPeticion
							.getSolicitudSACG().getDiaPago());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getHoraReunionFin() != null) {
					solicitudesOV.setHoraReunionFin(solicitudesSACGPeticion
							.getSolicitudSACG().getHoraReunionFin());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getPersonaDomReunion() != null) {
					solicitudesOV.setPersonaDomReunion(solicitudesSACGPeticion
							.getSolicitudSACG().getPersonaDomReunion());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getUsuarioRegistraSolicitud() != null) {
					solicitudesOV
							.setUsuarioRegistraSolicitud(solicitudesSACGPeticion
									.getSolicitudSACG()
									.getUsuarioRegistraSolicitud());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getHoraReunionFin() != null) {
					solicitudesOV.setHoraReunionFin(solicitudesSACGPeticion
							.getSolicitudSACG().getHoraReunionFin());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getPersonaDomReunion() != null) {
					if (!solicitudesSACGPeticion.getSolicitudSACG()
							.getPersonaDomReunion().trim().isEmpty()) {
						solicitudesOV
								.setPersonaDomReunion(comun
										.obtenerPersonaCliente(uid,
												solicitudesSACGPeticion
														.getSolicitudSACG()
														.getPersonaDomReunion()
														.trim()));
					}
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getExcepcionGarantia() != null) {
					solicitudesOV.setExcepcionGarantia(solicitudesSACGPeticion
							.getSolicitudSACG().getExcepcionGarantia());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getAutorizacionGarantia() != null) {
					solicitudesOV
							.setAutorizacionGarantia(solicitudesSACGPeticion
									.getSolicitudSACG()
									.getAutorizacionGarantia());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getUsuarioAutorizacion() != null) {
					solicitudesOV
							.setUsuarioAutorizacion(solicitudesSACGPeticion
									.getSolicitudSACG()
									.getUsuarioAutorizacion());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getFechaAutorizacion() != null) {
					solicitudesOV.setFechaAutorizacion(solicitudesSACGPeticion
							.getSolicitudSACG().getFechaAutorizacion());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getSeguro() != null) {
					solicitudesOV.setSeguro(solicitudesSACGPeticion
							.getSolicitudSACG().getSeguro());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getEstatus() != null) {
					solicitudesOV.setEstatus(solicitudesSACGPeticion
							.getSolicitudSACG().getEstatus());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getDesEstatus() != null) {
					solicitudesOV.setDescripcion(solicitudesSACGPeticion
							.getSolicitudSACG().getDesEstatus());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getFechaFin() != null) {
					solicitudesOV.setFechaFin(solicitudesSACGPeticion
							.getSolicitudSACG().getFechaFin());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getExpress() != null) {
					solicitudesOV.setExpress(solicitudesSACGPeticion
							.getSolicitudSACG().getExpress());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG().getCampana() != null) {
					solicitudesOV.setCampana(solicitudesSACGPeticion
							.getSolicitudSACG().getCampana());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getSenalamientoExcepcion() != null) {
					solicitudesOV
							.setSenalamientoExcepcion(solicitudesSACGPeticion
									.getSolicitudSACG()
									.getSenalamientoExcepcion());
				}

				// Deposito Garantia ***

				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getTraspasoGarantia() != null) {
					solicitudesOV.setTraspasoGarantia(solicitudesSACGPeticion
							.getSolicitudSACG().getTraspasoGarantia());
				}

				if (solicitudesSACGPeticion.getSolicitudSACG().getPctGarantia() != null) {
					solicitudesOV.setPctGarantia(solicitudesSACGPeticion
							.getSolicitudSACG().getPctGarantia());
				} else {
					solicitudesOV.setPctGarantia(0);
				}
				// MIMH 20150713
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getAplicarGarantia() == null) {
					solicitudesOV.setAplicarGarantia("N");
				} else {
					solicitudesOV.setAplicarGarantia(solicitudesSACGPeticion
							.getSolicitudSACG().getAplicarGarantia());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getAplicarGarantiaDesertor() == null) {
					solicitudesOV.setAplicarGarantiaDesertor("N");
				} else {
					solicitudesOV
							.setAplicarGarantiaDesertor(solicitudesSACGPeticion
									.getSolicitudSACG()
									.getAplicarGarantiaDesertor());
				}
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getJustificacionExc() == null) {
					solicitudesOV.setJustificacionExc("");
				} else {
					solicitudesOV.setJustificacionExc(solicitudesSACGPeticion
							.getSolicitudSACG().getJustificacionExc());
				}
				// Fin Deposito Garantia

				String[] solicitudDatosRequeridos = { "solicitud" };
				validaStr = Validaciones.datosRequeridos(solicitudesOV,
						solicitudDatosRequeridos);
				if (!validaStr.equalsIgnoreCase("")) {
					throw new Exception(DATOS_REQUERIDOS + validaStr);
				}

				// Limpia el domicilio de personas
				LogHandler.trace(uid, getClass(),
						"guardarSolicitudCreditoTarea: - actualizaPerDomReu");
				LogHandler.info(uid, getClass(),
						"guardarSolicitudCreditoTarea: - actualizaPerDomReu");
				sesionTx.update("actualizaPerDomReu",
						solicitudesOV.getSolicitud());

				java.util.HashMap<String, Object> solicitudParametros = Funciones
						.objectToHashMapUpdate(solicitudesOV);
				LogHandler.trace(uid, getClass(),
						"guardarSolicitudCreditoTarea: - actualizaSolicitud");
				LogHandler.info(uid, getClass(),
						"guardarSolicitudCreditoTarea: - actualizaSolicitud");
				registrosAfectados = sesionTx.update("actualizaSolicitud",
						solicitudParametros);
				LogHandler.info(uid, getClass(),
						"guardarSolicitudCreditoTarea: - registrosAfectados: "
								+ registrosAfectados);
				if (registrosAfectados == 0) {
					throw new Exception(ERROR_INSERCION);
				}

				solicitudesSACGPeticion.getSolicitudSACG().setVisualizaCec(
						solicitudesSACGPeticion.getSolicitudSACG()
								.getVisualizaCec() == null ? "false"
								: solicitudesSACGPeticion.getSolicitudSACG()
										.getVisualizaCec());
				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getVisualizaCec().trim().equals("true")) {
					// Si tiene etapa = true, insertamos el envio_cec
					// Registrar ENVIO_CEC
					AtomosOV peticionAtomo = new AtomosOV();
					peticionAtomo.setSolicitud(solicitudesOV.getSolicitud());
					peticionAtomo.setProceso("ENVIO_CEC");
					peticionAtomo.setComentario("");
					peticionAtomo.setStatus("A");
					peticionAtomo.setUsuarioGeneroAtomo(solicitudesOV
							.getUsuarioRegistraSolicitud());

					AtomosRespuesta atomosRespuesta = registrarAtomosTarea(uid,
							sesionTx, peticionAtomo);

					if (!atomosRespuesta.getHeader().isEstatus()) {
						throw new Exception(atomosRespuesta.getHeader()
								.getMensaje());
					}
				}
				// :::::::::::::::::::::::::::::::::: /solicitud
				// ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
				// ::::::::::::::::::::::::::::::::::: grupo
				// :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

				if (solicitudesSACGPeticion.getSolicitudSACG()
						.getPersonaDomReunion() != null
						&& !solicitudesSACGPeticion.getSolicitudSACG()
								.getPersonaDomReunion().equalsIgnoreCase("")) {
					final HashMap<String, Object> parametros = new HashMap<String, Object>();
					parametros.put("persona", solicitudesSACGPeticion
							.getSolicitudSACG().getPersonaDomReunion());
					HashMap<String, Object> datosExtraPersona = new HashMap<String, Object>();
					LogHandler
							.trace(uid, getClass(),
									"guardarSolicitudCreditoTarea: - consultarDatosExtraPersona");
					LogHandler
							.info(uid, getClass(),
									"guardarSolicitudCreditoTarea: - consultarDatosExtraPersona");
					datosExtraPersona = (HashMap<String, Object>) sesionNTx
							.selectOne("consultarDatosExtraPersona", parametros);
					if (datosExtraPersona != null) {
						domicilioOV = new DomicilioOV();
						domicilioOV.setCalle(datosExtraPersona.get("calle")
								.toString());
						domicilioOV.setColonia(datosExtraPersona.get("colonia")
								.toString());
						domicilioOV
								.setCp((Integer) datosExtraPersona.get("cp"));
						domicilioOV.setLocalidad(datosExtraPersona
								.get("ciudad").toString());
						domicilioOV.setEntidad(datosExtraPersona.get("entidad")
								.toString());
						domicilioOV.setMunicipio(datosExtraPersona.get(
								"municipio").toString());
					}
					if (domicilioOV == null) {
						domicilioOV = new DomicilioOV();
						domicilioOV.setCalle("");
						domicilioOV.setColonia("");
						domicilioOV.setCp(0);
						domicilioOV.setLocalidad("");
						domicilioOV.setEntidad("");
						domicilioOV.setMunicipio("");
					}

					SolicitudesOV solicitudesOVTemp = new SolicitudesOV();
					LogHandler
							.trace(uid, getClass(),
									"guardarSolicitudCreditoTarea: - consultaSolicitudTx");
					LogHandler
							.info(uid, getClass(),
									"guardarSolicitudCreditoTarea: - consultaSolicitudTx");
					solicitudesOVTemp = (SolicitudesOV) sesionTx.selectOne(
							"consultaSolicitudTx", solicitudesSACGPeticion
									.getSolicitudSACG().getId());

					if (solicitudesOVTemp == null) {
						throw new Exception(SOLICITUD_NO_ENCONTRADA);
					}
					grupoOV.setIdentificador(solicitudesOVTemp.getCliente());
					grupoOV.setDomicilio(domicilioOV);
					ResultadoOV resultado;
					resultado = grupo.actualizarTx(uid, sesionTx, grupoOV);
					if (!resultado.isSuccess()) {
						throw new Exception(resultado.getCodigo());
					}
				}

				// :::::::::::::::::::::::::::::::::::: /grupo
				// :::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
				// ::::::::::::::::::::::::::::::: integrantes
				// ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::

				String[] integranteDatosRequeridosUpdate = { "solicitud",
						"cliente" };

				LogHandler
						.trace(uid, getClass(),
								"guardarSolicitudCreditoTarea: - pasaXIntegrantesSolicitud");
				LogHandler
						.info(uid, getClass(),
								"guardarSolicitudCreditoTarea: - pasaXIntegrantesSolicitud");
				sesionTx.update("pasaXIntegrantesSolicitud",
						solicitudesOV.getSolicitud());

				if (solicitudesSACGPeticion.getSolicitudSACGIntegrantes() != null) {

					// Elimina los cargos de los integrantes
					LogHandler
							.trace(uid, getClass(),
									"guardarSolicitudCreditoTarea: - eliminaCargoIntegrantesSolicitud");
					LogHandler
							.info(uid, getClass(),
									"guardarSolicitudCreditoTarea: - eliminaCargoIntegrantesSolicitud");
					sesionTx.update("eliminaCargoIntegrantesSolicitud",
							solicitudesOV.getSolicitud());

					for (int i = 0; i < solicitudesSACGPeticion
							.getSolicitudSACGIntegrantes().size(); i++) {
						java.util.HashMap<String, Object> integranteParametros = null;
						SolicitudIntegrantesOV solicitudIntegrantesOV = new SolicitudIntegrantesOV();
						solicitudIntegrantesOV.setSolicitud(solicitudFolio);

						if (solicitudesSACGPeticion
								.getSolicitudSACGIntegrantes().get(i)
								.getCodigoPocg() == null
								|| solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getCodigoPocg().equalsIgnoreCase("")) {
							// Realizar consulta con CODIGO_T24

							String clienteStr = "";
							LogHandler
									.trace(uid, getClass(),
											"guardarSolicitudCreditoTarea: - buscarClavePersonaSolicitud");
							LogHandler
									.info(uid, getClass(),
											"guardarSolicitudCreditoTarea: - buscarClavePersonaSolicitud");
							clienteStr = (String) sesionTx.selectOne(
									"buscarClavePersonaSolicitud",
									solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getCodigoT24());
							if (clienteStr == null) {
								LogHandler
										.info(uid,
												getClass(),
												"ProcGuardarCreditoTempTarea: No se obtubo la clave persona del"
														+ "cliente: "
														+ solicitudesSACGPeticion
																.getSolicitudSACGIntegrantes()
																.get(i)
																.getCodigoT24());
							}

							if (clienteStr != null
									|| !clienteStr.equalsIgnoreCase("")) {
								solicitudIntegrantesOV.setCliente(clienteStr);
							}
						} else {
							solicitudIntegrantesOV
									.setCliente(solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getCodigoPocg());
						}

						if (solicitudIntegrantesOV.getCliente()
								.equalsIgnoreCase(cargoPresidente)) {
							solicitudIntegrantesOV
									.setCargoMesaDirectiva(ID_PRESIDENTE);
						} else if (solicitudIntegrantesOV.getCliente()
								.equalsIgnoreCase(cargoSecretario)) {
							solicitudIntegrantesOV
									.setCargoMesaDirectiva(ID_SECRETARIO);
						} else if (solicitudIntegrantesOV.getCliente()
								.equalsIgnoreCase(cargoSupervisor)) {
							solicitudIntegrantesOV
									.setCargoMesaDirectiva(ID_SUPERVISOR);
						} else if (solicitudIntegrantesOV.getCliente()
								.equalsIgnoreCase(cargoTesorero)) {
							solicitudIntegrantesOV
									.setCargoMesaDirectiva(ID_TESORERO);
						} else {
							solicitudIntegrantesOV.setCargoMesaDirectiva("");
						}

						java.util.HashMap<String, Object> integranteBuscaParametros = new java.util.HashMap<String, Object>();
						integranteBuscaParametros.put("solicitud",
								solicitudesOV.getSolicitud());
						integranteBuscaParametros.put("cliente",
								solicitudIntegrantesOV.getCliente());

						LogHandler
								.trace(uid, getClass(),
										"guardarSolicitudCreditoTarea: - buscaIntegranteSolicitud");
						LogHandler
								.info(uid, getClass(),
										"guardarSolicitudCreditoTarea: - buscaIntegranteSolicitud");
						String clienteQuery = (String) sesionTx.selectOne(
								"buscaIntegranteSolicitud",
								integranteBuscaParametros);
						if (clienteQuery == null) {
							clienteQuery = "";
						} else {
							clienteQuery = clienteQuery.trim();
						}
						solicitudIntegrantesOV
								.setStatus(INTEGRANTE_STATUS_ACTIVO);

						// UPDATE Integrantes.
						if (solicitudIntegrantesOV.getCliente()
								.equalsIgnoreCase(clienteQuery)) {
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getUltimoCreditoAprobado() != null) {
								solicitudIntegrantesOV
										.setMontoContratoAnterior(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i)
												.getUltimoCreditoAprobado());
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getNuevoCreditoSolicitado() != null) {
								solicitudIntegrantesOV
										.setEfectivoSolicitado(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i)
												.getNuevoCreditoSolicitado());
							}
							Double montoAhorro = (solicitudIntegrantesOV
									.getEfectivoSolicitado() * solicitudesOV
									.getPctGarantia())
									/ Constantes.CENTENA_DOUBLE;

							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getAhorro() != null) {
								solicitudIntegrantesOV
										.setMontoAhorro(montoAhorro);
							} else {
								solicitudIntegrantesOV.setMontoAhorro(0.0);
							}

							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getPropositoPrestamo() != null) {
								solicitudIntegrantesOV
										.setCodigoDestinoCredito(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getPropositoPrestamo());
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getAprobado() != null) {
								solicitudIntegrantesOV
										.setAprobado(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getAprobado());
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getContratoPrevio() != null) {
								// Obtener contrato de contrato_clave_finsol
								// para contrato anterior de Integrante.
								LogHandler.trace(uid, getClass(),
										"guardarSolicitudCreditoTarea.update.integrante.ContratoPrevio.update:"
												+ " - obtenerRelacionContrato");
								LogHandler.info(uid, getClass(),
										"guardarSolicitudCreditoTarea.update.integrante.ContratoPrevio.update:"
												+ " - obtenerRelacionContrato");
								String contratoTmp = (String) sesionNTx
										.selectOne(
												"obtenerRelacionContrato",
												solicitudesSACGPeticion
														.getSolicitudSACGIntegrantes()
														.get(i)
														.getContratoPrevio());
								if (contratoTmp == null) {
									throw new Exception(
											ReadProperties.mensajes
													.getProp("ciof.contratoinvalido"));
								}
								solicitudIntegrantesOV
										.setContratoAnterior(contratoTmp);
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getSaldoActual() != null) {
								solicitudIntegrantesOV
										.setSaldoActual(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getSaldoActual());
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getTipoLocalidad() != null) {
								solicitudIntegrantesOV
										.setClasificacionFira(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getTipoLocalidad());
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getStatus() != null) {
								solicitudIntegrantesOV
										.setStatus(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getStatus());
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getConsultaBuro() != null) {
								solicitudIntegrantesOV
										.setReferencia(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getConsultaBuro());
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getSeguro() != null) {
								solicitudIntegrantesOV
										.setSeguro(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getSeguro());
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getIguala() != null) {
								solicitudIntegrantesOV
										.setIguala(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getIguala());
							}
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getCiclo() != null) {
								solicitudIntegrantesOV
										.setCiclo(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getCiclo());
							}

							// 20140911 Agregar plazo seguro
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getPlazoSeguro() == null) {
								solicitudIntegrantesOV.setPlazoSeguro("");
							} else {
								solicitudIntegrantesOV
										.setPlazoSeguro(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getPlazoSeguro());
							}

							// 20141010 Agregar seguro enfermedad
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getSeguroEnfermedad() == null) {
								solicitudIntegrantesOV.setSeguroEnfermedad("");
							} else {
								solicitudIntegrantesOV
										.setSeguroEnfermedad(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getSeguroEnfermedad());
							}

							// Se agrega desertor
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getDesertor() == null) {
								solicitudIntegrantesOV.setDesertor("N");
							} else {
								solicitudIntegrantesOV
										.setDesertor(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getDesertor());

								if (solicitudIntegrantesOV.getDesertor()
										.equals("S")) {
									solicitudIntegrantesOV.setStatus("X");
								}
							}

							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getPerteneceCreditoRenovar() == null) {
								solicitudIntegrantesOV
										.setPerteneceCreditoRenovar("N");
							} else {
								solicitudIntegrantesOV
										.setPerteneceCreditoRenovar(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i)
												.getPerteneceCreditoRenovar());
							}

							// 20150721 garantia aplicar por desertor
							solicitudIntegrantesOV
									.setGarantiaAplicada(solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getGarantiaAplicada());

							solicitudIntegrantesOV
									.setDiferenciaPago(solicitudesSACGPeticion
											.getSolicitudSACGIntegrantes()
											.get(i).getDiferenciaPago());

							validaStr = Validaciones.datosRequeridos(
									solicitudIntegrantesOV,
									integranteDatosRequeridosUpdate);
							if (!validaStr.equalsIgnoreCase("")) {
								throw new Exception(DATOS_REQUERIDOS
										+ validaStr);
							}

							integranteParametros = Funciones
									.objectToHashMapUpdate(solicitudIntegrantesOV);
							LogHandler.trace(
									uid,
									getClass(),
									"guardarSolicitudCreditoTarea: - actualizaSolicitudIntegrante.cliente: "
											+ solicitudIntegrantesOV
													.getCliente());
							LogHandler.info(
									uid,
									getClass(),
									"guardarSolicitudCreditoTarea: - actualizaSolicitudIntegrante.cliente: "
											+ solicitudIntegrantesOV
													.getCliente());
							registrosAfectados = sesionTx.update(
									"actualizaSolicitudIntegrante",
									integranteParametros);
							LogHandler.info(uid, getClass(),
									"guardarSolicitudCreditoTarea: - registrosAfectados: "
											+ registrosAfectados);
							if (registrosAfectados == 0) {
								throw new Exception(ERROR_ACTUALIZACION);
							}

						}
						// INSERT Integrantes.
						else {
							boolean integranteInsert = true;
							if (solicitudesSACGPeticion
									.getSolicitudSACGIntegrantes().get(i)
									.getStatus() != null) {
								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getStatus().equalsIgnoreCase("X")) {
									integranteInsert = false;
								}
							}

							if (integranteInsert) {
								// Busca si el integrante ya esta eliminado.
								LogHandler
										.trace(uid, getClass(),
												"guardarSolicitudCreditoTarea: - buscaIntegranteStatusSolicitud");
								LogHandler
										.info(uid, getClass(),
												"guardarSolicitudCreditoTarea:-buscaIntegranteStatusSolicitud");
								java.util.HashMap<String, Object> clienteEliminadoQuery = (java.util.HashMap<String, Object>) sesionTx
										.selectOne(
												"buscaIntegranteStatusSolicitud",
												integranteBuscaParametros);
								if (clienteEliminadoQuery != null) {
									if (clienteEliminadoQuery.get("status")
											.equals("X")) {
										throw new Exception(
												INTEGRANTE_INSERT_DUPLICIDAD_E);
									}
								}

								validaStr = Validaciones.datosRequeridos(
										solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i),
										integranteDatosRequeridos);
								if (!validaStr.equalsIgnoreCase("")) {
									throw new Exception(DATOS_REQUERIDOS
											+ validaStr);
								}
								solicitudIntegrantesOV
										.setEfectivoSolicitado(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i)
												.getNuevoCreditoSolicitado());

								Double montoAhorro = (solicitudIntegrantesOV
										.getEfectivoSolicitado() * solicitudesOV
										.getPctGarantia())
										/ Constantes.CENTENA_DOUBLE;
								solicitudIntegrantesOV
										.setMontoAhorro(montoAhorro);

								solicitudIntegrantesOV
										.setCodigoDestinoCredito(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getPropositoPrestamo());
								solicitudIntegrantesOV
										.setAprobado(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getAprobado());
								solicitudIntegrantesOV
										.setClasificacionFira(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getTipoLocalidad());
								solicitudIntegrantesOV
										.setTipoDisposicion(INTEGRANTE_TDISP_CHEQUE);

								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getUltimoCreditoAprobado() != null) {
									solicitudIntegrantesOV
											.setMontoContratoAnterior(solicitudesSACGPeticion
													.getSolicitudSACGIntegrantes()
													.get(i)
													.getUltimoCreditoAprobado());
								}
								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getContratoPrevio() != null) {
									// Obtener contrato de contrato_clave_finsol
									// para contrato anterior de Integrante.
									LogHandler
											.trace(uid,
													getClass(),
													"guardarSolicitudCreditoTarea.update.integrante.ContratoPrevio.insert:"
															+ " - obtenerRelacionContrato");
									LogHandler
											.info(uid,
													getClass(),
													"guardarSolicitudCreditoTarea.update.integrante.ContratoPrevio.insert:"
															+ " - obtenerRelacionContrato");
									String contratoTmp = (String) sesionNTx
											.selectOne(
													"obtenerRelacionContrato",
													solicitudesSACGPeticion
															.getSolicitudSACGIntegrantes()
															.get(i)
															.getContratoPrevio());
									if (contratoTmp == null) {
										throw new Exception(
												ReadProperties.mensajes
														.getProp("ciof.contratoinvalido"));
									}
									solicitudIntegrantesOV
											.setContratoAnterior(contratoTmp);
								}
								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getSaldoActual() != null) {
									solicitudIntegrantesOV
											.setSaldoActual(solicitudesSACGPeticion
													.getSolicitudSACGIntegrantes()
													.get(i).getSaldoActual());
								}
								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getConsultaBuro() != null) {
									solicitudIntegrantesOV
											.setReferencia(solicitudesSACGPeticion
													.getSolicitudSACGIntegrantes()
													.get(i).getConsultaBuro());
								}
								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getSeguro() != null) {
									solicitudIntegrantesOV
											.setSeguro(solicitudesSACGPeticion
													.getSolicitudSACGIntegrantes()
													.get(i).getSeguro());
								}
								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getSeguro() == null) {
									solicitudIntegrantesOV.setSeguro("N");
								}
								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getCiclo() != null) {
									solicitudIntegrantesOV
											.setCiclo(solicitudesSACGPeticion
													.getSolicitudSACGIntegrantes()
													.get(i).getCiclo());
								} else {
									solicitudIntegrantesOV.setCiclo(0);
								}

								// 20140911 Agregar plazo seguro
								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getPlazoSeguro() == null) {
									solicitudIntegrantesOV.setPlazoSeguro("");
								} else {
									solicitudIntegrantesOV
											.setPlazoSeguro(solicitudesSACGPeticion
													.getSolicitudSACGIntegrantes()
													.get(i).getPlazoSeguro());
								}

								// 20141010 Agregar seguro enfermedad
								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getSeguroEnfermedad() == null) {
									solicitudIntegrantesOV
											.setSeguroEnfermedad("");
								} else {
									solicitudIntegrantesOV
											.setSeguroEnfermedad(solicitudesSACGPeticion
													.getSolicitudSACGIntegrantes()
													.get(i)
													.getSeguroEnfermedad());
								}

								// Se agrega desertor
								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getDesertor() == null) {
									solicitudIntegrantesOV.setDesertor("N");
								} else {
									solicitudIntegrantesOV
											.setDesertor(solicitudesSACGPeticion
													.getSolicitudSACGIntegrantes()
													.get(i).getDesertor());

									if (solicitudIntegrantesOV.getDesertor()
											.equals("S")) {
										solicitudIntegrantesOV.setStatus("X");
									}
								}

								if (solicitudesSACGPeticion
										.getSolicitudSACGIntegrantes().get(i)
										.getPerteneceCreditoRenovar() == null) {
									solicitudIntegrantesOV
											.setPerteneceCreditoRenovar("N");
								} else {
									solicitudIntegrantesOV
											.setPerteneceCreditoRenovar(solicitudesSACGPeticion
													.getSolicitudSACGIntegrantes()
													.get(i)
													.getPerteneceCreditoRenovar());
								}

								// 20150721 garantia aplicar por desertor
								solicitudIntegrantesOV
										.setGarantiaAplicada(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getGarantiaAplicada());

								solicitudIntegrantesOV
										.setDiferenciaPago(solicitudesSACGPeticion
												.getSolicitudSACGIntegrantes()
												.get(i).getDiferenciaPago());

								LogHandler
										.trace(uid, getClass(),
												"guardarSolicitudCreditoTarea: - obtenerNumeroIntegrante");
								LogHandler
										.info(uid, getClass(),
												"guardarSolicitudCreditoTarea: - obtenerNumeroIntegrante");
								final Integer integranteNumeroQuery = (Integer) sesionTx
										.selectOne("obtenerNumeroIntegrante",
												solicitudFolio);
								if (integranteNumeroQuery == null) {
									throw new Exception(INTEGRANTE_ERROR_NUMERO);
								}
								solicitudIntegrantesOV
										.setNumeroIntegrante(integranteNumeroQuery);
								integranteParametros = Funciones
										.objectToHashMapInsert(solicitudIntegrantesOV);
								LogHandler.trace(
										uid,
										getClass(),
										"guardarSolicitudCreditoTarea: - insertaSolicitudIntegrante.cliente: "
												+ solicitudIntegrantesOV
														.getCliente());
								LogHandler.info(
										uid,
										getClass(),
										"guardarSolicitudCreditoTarea: - insertaSolicitudIntegrante.cliente: "
												+ solicitudIntegrantesOV
														.getCliente());
								registrosAfectados = sesionTx.insert(
										"insertaSolicitudIntegrante",
										integranteParametros);
								LogHandler.info(uid, getClass(),
										"guardarSolicitudCreditoTarea: - registrosAfectados: "
												+ registrosAfectados);
								if (registrosAfectados == 0) {
									throw new Exception(ERROR_INSERCION);
								}
							}
						}
					} // for
				} // null
					// :::::::::::::::::::::::::::::::::::::::::::::::::::::
					// /integrantes ::::::::::::::::::::::::::::::::::::::::
			}

			SolicitudesOV solicitudesOVUpdateNumIntegrantes = new SolicitudesOV();
			solicitudesOVUpdateNumIntegrantes.setSolicitud(solicitudFolio);
			final java.lang.Integer numIntegrantes = (java.lang.Integer) sesionTx
					.selectOne("numeroIntegrantes", solicitudFolio);
			solicitudesOVUpdateNumIntegrantes
					.setNumeroIntegrantes(numIntegrantes);
			java.util.HashMap<String, Object> solicitudParametros = Funciones
					.objectToHashMapUpdate(solicitudesOVUpdateNumIntegrantes);

			LogHandler
					.trace(uid, getClass(),
							"guardarSolicitudCreditoTarea: - actualizaSolicitud.numeroIntegrantes");
			LogHandler
					.info(uid, getClass(),
							"guardarSolicitudCreditoTarea: - actualizaSolicitud.numeroIntegrantes");
			registrosAfectados = sesionTx.update("actualizaSolicitud",
					solicitudParametros);
			LogHandler.info(uid, getClass(),
					"guardarSolicitudCreditoTarea: - registrosAfectados: "
							+ registrosAfectados);
			if (registrosAfectados == 0) {
				throw new Exception(ERROR_ACTUALIZACION);
			}

			sesionTx.commit(true);
			// ::::::::: se gerea en este punto la tarea de cupos y montos,
			// debido a que en este punto si no
			// no se a generado la solicitud se cree
			// ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
			// mandar a buzon del regional en caso de que alla alguna excepcion
			// de monto o cupo --------------
			if (tareaPendienteCuposYMonto == 0
					&& solicitudesSACGPeticion.getSolicitudSACG()
							.getJustificacionMontoYCupo() != null
					&& !solicitudesSACGPeticion.getSolicitudSACG()
							.getJustificacionMontoYCupo().trim().isEmpty()
					&& solicitudesSACGPeticion.getSolicitudSACG().getId() != null
					&& !solicitudesSACGPeticion.getSolicitudSACG().getId()
							.trim().isEmpty()) {
				LogHandler.info(uid, getClass(),
						"guardarSolicitudCreditoTarea: - iniciando envio"
								+ " de excepcion de cupo o monto ");
				ExcepcionGarantiaPeticion peticion = new ExcepcionGarantiaPeticion();
				if (solicitudesSACGPeticion.getSolicitudSACG() != null
						&& solicitudesSACGPeticion
								.getSolicitudSACGIntegrantes() != null
						&& solicitudesSACGPeticion.getSolicitudSACGGrupo() != null) {
					peticion.setCiclo(solicitudesSACGPeticion
							.getSolicitudSACG().getCiclo());
					peticion.setSolicitud(solicitudesSACGPeticion
							.getSolicitudSACG().getId());
					peticion.setNombreAsesor(solicitudesSACGPeticion
							.getSolicitudSACG().getNombreAsesor());
					peticion.setObservaciones(solicitudesSACGPeticion
							.getSolicitudSACG().getJustificacionMontoYCupo());
					peticion.setNombreGrupo(solicitudesSACGPeticion
							.getSolicitudSACGGrupo().getNombre());
					peticion.setPerfil(Constantes.PUESTO_REGIONAL);
					// LogHandler.info(uid, getClass(),
					// "getUsuarioAutorizacion: "
					// +
					// solicitudesSACGPeticion.getSolicitudSACG().getUsuarioAutorizacion());
					// peticion.setUsuarioAut(solicitudesSACGPeticion.getSolicitudSACG().getUsuarioAutorizacion());
					peticion.setMontoSolicitado(solicitudesSACGPeticion
							.getSolicitudSACG().getNuevoCreditoSolicitado());
					peticion.setNumeroIntegrantes(solicitudesSACGPeticion
							.getSolicitudSACGIntegrantes().size());
					LogHandler.info(uid, getClass(),
							"guardarSolicitudCreditoTarea: - sucursal: "
									+ solicitudesSACGPeticion
											.getSolicitudSACG().getSucursal());
					peticion.setSucursal(solicitudesSACGPeticion
							.getSolicitudSACG().getSucursal() + "");

					LogHandler.info(uid, getClass(),
							"guardarSolicitudCreditoTarea: - peticion de"
									+ " correo monto y cupo: " + peticion);
				}

				EnviarCorreoRespuesta res = enviarCorreoPorPerfil(uid,
						peticion, Constantes.CORREO_REGIONAL);
				if (res == null || res != null && !res.getHeader().isEstatus()) {
					LogHandler.trace(uid, getClass(),
							"guardarSolicitudCreditoTarea: No se puedo enviar correo"
									+ " al gerente Regional de la sucursal: "
									+ solicitudesSACGPeticion
											.getSolicitudSACG().getSucursal());

				}

				// proceso de enviar tarea al Buzón de Excepciones del Gerente
				// Regional
				ExcepcionGarantiaPeticion petCupoMonto = new ExcepcionGarantiaPeticion();
				petCupoMonto
						.setTipoTarea(Constantes.TIPO_TAREA_CAMPANA_EXCEPTION);
				petCupoMonto.setSucursal(solicitudesSACGPeticion
						.getSolicitudSACG().getSucursal().toString());
				petCupoMonto.setDescripcion(solicitudesSACGPeticion
						.getSolicitudSACG().getId());
				petCupoMonto.setUsuarioAlta(solicitudesSACGPeticion
						.getSolicitudSACG().getUsuarioRegistraSolicitud());
				petCupoMonto.setPerfil("PCOM");
				petCupoMonto.setStatus("P");
				petCupoMonto.setJustificacion(solicitudesSACGPeticion
						.getSolicitudSACG().getJustificacionMontoYCupo());
				petCupoMonto.setTipoException(solicitudesSACGPeticion
						.getSolicitudSACG().getTipoExcepcion());

				// sacar el numero de persoa del regional
				// obtenerNumeroPersonaRegional

				petCupoMonto.setUsuarioAut(peticion.getUsuarioAut());

				ExcepcionGarantiaRespuesta respuestaExc = generarExcepcionCuposMontosTarea(
						uid, petCupoMonto, sesionTx);

				if (!respuestaExc.getHeader().isEstatus()) {
					throw new Exception(
							"Ocurrio un error en generar tarea excepcion de cupos o montos : "
									+ respuestaExc.getHeader().getMensaje());
				}
				LogHandler
						.info(uid,
								getClass(),
								"guardarSolicitudCreditoTarea: -"
										+ " termino envio de excepcion de cupo o monto ");
			} // se termina de enviar la tarea a buzon
			sesionTx.commit(true);
			// ::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::
			solicitudesRespuesta.setId(solicitudFolio);
			solicitudesRespuesta.getHeader().setMensaje(
					mensaje + "\n" + msjCuposMontos);

		} catch (Exception ex) {
			FabricaConexiones.rollBack(sesionTx);
			LogHandler
					.error(uid,
							getClass(),
							"Error en guardarSolicitudCreditoTarea: "
									+ ex.getMessage(), ex);
			solicitudesRespuesta.getHeader().setEstatus(false);
			solicitudesRespuesta.getHeader().setMensaje(
					"Error al guardar la Solicitud: \n" + ex.getMessage());

			// se agrega el tipoTareaExcepcion en caso de existir
			if (solicitudesRespuesta.getSolicitud() != null) {
				solicitudesRespuesta.getSolicitud().setTipoExcepcion(
						tipoTareaCampana);
			} else {
				SolicitudesOV solicitud = new SolicitudesOV();
				solicitud.setTipoExcepcion(tipoTareaCampana);
				solicitudesRespuesta.setSolicitud(solicitud);
			}

			if (solicitudesRespuesta.isExcepcionCupoMonto()
					|| ex.getMessage().contains("La sucursal tiene la")) {
				solicitudesRespuesta.getHeader().setMensaje(ex.getMessage());
				// se agrega el tipoTareaExcepcion en caso de existir
				if (solicitudesRespuesta.getSolicitud() != null
						&& solicitudesRespuesta.isExcepcionCupoMonto()) {
					solicitudesRespuesta.getSolicitud().setTipoExcepcion(
							tipoTareaCampana);
				} else {
					SolicitudesOV solicitud = new SolicitudesOV();
					solicitud.setTipoExcepcion(tipoTareaCampana);
					solicitudesRespuesta.setSolicitud(solicitud);
				}
			}

			if (ex.getMessage().indexOf("PK_solicitud_integrantes") != -1
					&& ex.getMessage().indexOf(
							"Attempt to insert duplicate key row") != -1) {
				solicitudesRespuesta.getHeader().setCodigo(
						INTEGRANTE_INSERT_DUPLICIDAD_E);
			} else {
				LogHandler
						.error(uid,
								getClass(),
								"Error en guardarSolicitudCreditoTarea: "
										+ solicitudesRespuesta.getHeader()
												.getCodigo() != null ? solicitudesRespuesta
										.getHeader().getCodigo() : "", ex);
			}
		} finally {
			FabricaConexiones.close(sesionTx);
			FabricaConexiones.close(sesionNTx);
		}

		return solicitudesRespuesta;
	}

	/**
	 * Validar datos guardar solicitud credito.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the peticion
	 * @return respuesta ValidarGuardarSolicitudRespuesta
	 */
	public ValidarGuardarSolicitudRespuesta validarGuardarSolicitudCredito(
			String uid, SolicitudSACGPeticion peticion) {
		ValidarGuardarSolicitudRespuesta respuesta = new ValidarGuardarSolicitudRespuesta();

		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		String mensaje = "";

		SimpleDateFormat df = new SimpleDateFormat("HH:mm", new Locale("es",
				"ES"));

		try {

			if (peticion == null) {
				mensaje += "Los datos de la peticion son incorrectos, no se puede realizar validacion. <br>";
			}

			if (peticion.getSolicitudSACG().getUsuarioRegistraSolicitud() == null
					|| peticion.getSolicitudSACG()
							.getUsuarioRegistraSolicitud().trim().isEmpty()) {
				mensaje += "Debe enviar el usuario de registro solicitud. <br>";
			}

			if (peticion.getSolicitudSACG().getDiaReunion() == null
					|| peticion.getSolicitudSACG().getDiaReunion() == 0) {
				mensaje += "Debe seleccionar el dia de reunion. <br>";
			}

			if (peticion.getSolicitudSACG().getCiclo() == null) {
				mensaje += "Debe tener ciclo. <br>";
			}

			if (peticion.getSolicitudSACG().getCampana() == null) {
				mensaje += "Falta la campaña por default. <br>";
			}

			if (peticion.getSolicitudSACG().getFrecuenciaPago() == null
					|| peticion.getSolicitudSACG().getFrecuenciaPago().trim()
							.isEmpty()) {
				mensaje += "Debe tener frecuencia de pago. <br>";
			}

			if (peticion.getSolicitudSACG().getHoraReunion() == null
					|| peticion.getSolicitudSACG().getHoraReunion().isEmpty()
					|| peticion.getSolicitudSACG().getHoraReunion().equals("")) {
				mensaje += "Falta la hora inicial de la reunion grupal. <br>";
			}

			if (peticion.getSolicitudSACG().getHoraReunionFin() == null
					|| peticion.getSolicitudSACG().getHoraReunionFin()
							.isEmpty()
					|| peticion.getSolicitudSACG().getHoraReunionFin()
							.equals("")) {
				mensaje += "Falta la hora final de la reunion grupal. <br>";
			}

			Date horaInicio = new Date(df.parse(
					peticion.getSolicitudSACG().getHoraReunion()).getTime());

			Date horaFin = new Date(df.parse(
					peticion.getSolicitudSACG().getHoraReunionFin()).getTime());

			if (horaFin.before(horaInicio)) {
				mensaje += "La hora final debe ser mayor que la hora inicial. <br>";
			}

			if (peticion.getSolicitudSACG().getTasa() == null
					|| peticion.getSolicitudSACG().getTasa() == 0) {
				mensaje += "Debe ingresar una tasa valida. <br>";
			}

			if (peticion.getSolicitudSACG().getPlazo() == null
					|| peticion.getSolicitudSACG().getPlazo() == 0) {
				mensaje += "Debe ingresar una plazo valido. <br>";
			}

			if (peticion.getSolicitudSACGGrupo().getNombre() == null
					|| peticion.getSolicitudSACGGrupo().getNombre().isEmpty()
					|| peticion.getSolicitudSACGGrupo().getNombre().equals("")) {
				mensaje += "Debe ingresar una nombre de grupo. <br>";
			}

			if (peticion.getSolicitudSACGGrupo().getCodigo() == null
					|| peticion.getSolicitudSACGGrupo().getCodigo().isEmpty()
					|| peticion.getSolicitudSACGGrupo().getCodigo().equals("")) {
				mensaje += "Debe tener un codigo de grupo. <br>";
			}

			if (peticion.getSolicitudSACGGrupo().getAnalista() == null
					|| peticion.getSolicitudSACGGrupo().getAnalista().isEmpty()
					|| peticion.getSolicitudSACGGrupo().getAnalista()
							.equals("")) {
				mensaje += "Verifique asesor. <br>";
			}

			if (peticion.getSolicitudSACG().getDiaPago() == null
					|| peticion.getSolicitudSACG().getDiaPago() == 0) {
				mensaje += "Verifique dia de pago. <br>";
			}

			if (peticion.getSolicitudSACG().getProducto() == null
					|| peticion.getSolicitudSACG().getProducto().isEmpty()
					|| peticion.getSolicitudSACG().getProducto().equals("")) {
				mensaje += "Verifique producto. <br>";
			}

			if (peticion.getSolicitudSACG().getFechaDesembolso() == null
					|| peticion.getSolicitudSACG().getFechaDesembolso()
							.toString().isEmpty()
					|| peticion.getSolicitudSACG().getFechaDesembolso()
							.toString().equals("")) {
				mensaje += "Verifique la fecha de desembolso. <br>";
			}

			// ------------------validacion de automatizacion de buro fase 2:
			// cupos y montos de campaña------------------------
			if (peticion.getSolicitudSACG().getPerfil() == null
					|| peticion.getSolicitudSACG().getPerfil().toString()
							.isEmpty()
					|| peticion.getSolicitudSACG().getPerfil().toString()
							.equals("")) {
				mensaje += "Verifique el perfil enviado. <br>";
			}

			if (peticion.getSolicitudSACG().getJustificacionMontoYCupo() == null
					|| peticion.getSolicitudSACG().getJustificacionMontoYCupo()
							.trim().isEmpty()
					&& !peticion.getSolicitudSACG().getPerfil()
							.equals(Constantes.PERFIL_CEC)) {
				mensaje += validacionCuposYMontosCampana(uid, peticion);
				if (!mensaje.equals("")) {
					throw new Exception(mensaje);
				}
			}

			// -------------------validacion de automatizacion de buro fase 1:
			// minimo integrantes contrato antrior ----------
			mensaje += validacionMinimoIntegrantesGuardar(uid, peticion);

			if (!mensaje.equals("")) {
				if (mensaje.endsWith("Bloqueante")) {
					respuesta.getHeader().setCodigo("Bloqueante");
					mensaje = mensaje.replace("Bloqueante", "");
				}
				LogHandler.info(uid, getClass(),
						"Error en validarGuardarSolicitudCredito: " + mensaje);
				throw new Exception(mensaje);
			}

		} catch (Exception e) {

			LogHandler.error(
					uid,
					getClass(),
					"Error en validarGuardarSolicitudCredito: "
							+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());
		}

		return respuesta;
	}

	/**
	 * metodo que realiza la validacion al guardar del minimo de integrantes
	 * 
	 * @param uid
	 *            id unico de transaccion
	 * @param peticion
	 *            peticion
	 * @return String mensaje si se se cumple aluna validacion
	 */
	@SuppressWarnings("unchecked")
	public String validacionMinimoIntegrantesGuardar(String uid,
			SolicitudSACGPeticion peticion) {
		LogHandler.info(uid, getClass(),
				"Entrando al metodo validacionMinimoIntegrantesGuardar-----");
		String respuesta = "";
		SqlSession sesionNTx = null;
		RespuestaSolicitudTasasOV resSolicitud = null;
		try {

			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if (peticion != null && peticion.getSolicitudSACG() != null
					&& peticion.getSolicitudSACG().getRenovacion()
					&& peticion.getSolicitudSACG().getContratoPrevio() != null) {
				// Validar si existe el contrato ya sea ld o contrato
				String contratoAnterior = comun.obtenerNumeroContrato(uid,
						peticion.getSolicitudSACG().getContratoPrevio());

				LogHandler.info(uid, this.getClass(),
						"validacionMinimoIntegrantesGuardar--numero de contrato: "
								+ contratoAnterior);

				// Validaciones
				if (contratoAnterior == null || contratoAnterior.isEmpty()) {
					throw new Exception(
							"El Número de Contrato de la petición no existe.");
				}

				// validacion de que alla cumplido con los integrantes
				// requeridos en el ciclo anterior
				// obtenemos la consulta
				java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();
				parametros.put("contratoAnterior", contratoAnterior);

				LogHandler.info(uid, getClass(),
						"validacionMinimoIntegrantesGuardar: - obtenerSolicitudTasasInteres: "
								+ parametros);

				// Este query nos regresa la solicitud, contratoAnterior,
				// campana renovacion, tasa,
				// ciclo y numero de intregrantes anteriores

				if (peticion.getSolicitudSACG().getId() != null
						&& !peticion.getSolicitudSACG().getId().trim()
								.isEmpty()) {
					parametros.put("solicitud", peticion.getSolicitudSACG()
							.getId());
					resSolicitud = (RespuestaSolicitudTasasOV) sesionNTx
							.selectOne("obtenerSolicitudTasasInteres",
									parametros);

					if (resSolicitud == null) {
						throw new Exception(
								"No existen datos para la solicitud");
					}
				}
				// este query nos regresa los integrantes que estan en el
				// contrato anterior
				List<RespuestaIntegrantesTasasOV> resIntegrantes = sesionNTx
						.selectList("obtenerIntegrantesCreditoAnterior",
								parametros);

				if (resIntegrantes == null || resIntegrantes.size() == 0) {
					throw new Exception(
							"El número de integrantes del contrato anterior no se pudo recuperar");
				}

				LogHandler.info(
						uid,
						getClass(),
						"validacionMinimoIntegrantesGuardar:"
								+ " tamaño de la lista: "
								+ resIntegrantes.size());

				if (peticion.getSolicitudSACGIntegrantes() == null
						|| peticion.getSolicitudSACGIntegrantes().size() == 0) {
					throw new Exception(
							"La solicitud debe contar por lo mínimo con un integrante para poder validarla...");
				}

				// comparar los integrantes del contrato anterior con los
				// actuales
				int integratesActualAnterior = 0;
				for (RespuestaIntegrantesTasasOV integranteViejo : resIntegrantes) {
					for (SolicitudSACGIntegrante integranteActual : peticion
							.getSolicitudSACGIntegrantes()) {
						if (integranteViejo
								.getIntegrante()
								.trim()
								.equals(integranteActual.getCodigoPocg().trim())) {
							integratesActualAnterior++;
							break;
						}
					}
				}

				LogHandler
						.info(uid,
								getClass(),
								"validacionMinimoIntegrantesGuardar:"
										+ " Número de integrantes en el contrato viejo y actual: "
										+ integratesActualAnterior);

				int ciclo = peticion.getSolicitudSACG().getCiclo();
				String campana = "";

				if (peticion.getSolicitudSACG().getCampana() != null) {
					campana = peticion.getSolicitudSACG().getCampana().trim();
				} else if (resSolicitud.getCampanaDescripcion() != null) {
					campana = resSolicitud.getCampanaDescripcion().trim();
				}

				HashMap<String, Object> valoresJDNI = new HashMap<String, Object>();

				LogHandler.info(uid, getClass(),
						"validacionMinimoIntegrantesGuardar:" + " ciclo: "
								+ ciclo + " campaña: " + campana);

				if (ciclo > 0) {

					valoresJDNI = obtenerMapaJdni(uid, "COMGAINMIN",
							"NDIAVENCLR", "PORC_CRENU", "COMESINMIN");

					int minIntOcho = Integer.parseInt(valoresJDNI.get(
							"COMGAINMIN").toString()); // 8
					double porcentajaRenovar = Double.parseDouble(valoresJDNI
							.get("PORC_CRENU").toString()); // 50.0
					int minIntTres = Integer.parseInt(valoresJDNI.get(
							"COMESINMIN").toString()); // 3
					int integrantesAnteriores = resIntegrantes.size();

					LogHandler
							.info(uid,
									getClass(),
									"validacionMinimoIntegrantesGuardar: Ciclo:\tporcentajeMinimoRenovar"
											+ "\tintegrantesAnteriores\tminIntOcho\t minIntTres");
					LogHandler.info(uid, getClass(),
							"validacionMinimoIntegrantesGuardar: " + ciclo
									+ "\t" + porcentajaRenovar + "\t"
									+ integrantesAnteriores + "\t" + minIntOcho
									+ "\t" + minIntTres);

					// validacion de si cumplio con el minimo de integrantes en
					// el contrato anterior para ciclo uno
					if (ciclo <= Constantes.CICLO_CUATRO) {
						if (!campana.equals("CE05")) {
							if (peticion.getSolicitudSACG().getCiclo() == Constantes.CICLO_UNO) {
								if (integrantesAnteriores < minIntOcho) {
									respuesta += "Este grupo no cumplió en el ciclo anterior con el mínimo de integrantes."
											+ " Favor de ingresarlo como un grupo nuevo.<br>Bloqueante";
								} else if (ciclo > 1
										&& integrantesAnteriores < Constantes.INTEGRANTE_CICLO_DOS) {
									respuesta += "Este grupo no cumplió en el ciclo anterior con el mínimo de integrantes."
											+ " Favor de ingresarlo como un grupo nuevo.<br>Bloqueante";
								}
							}
						} else {
							if (integrantesAnteriores < minIntTres) {
								respuesta += "Este grupo no cumplió en el ciclo anterior con el mínimo de integrantes."
										+ " Favor de ingresarlo como un grupo nuevo.<br>Bloqueante";
							}
						}
					}
					// validacion de que se conserve el 50% de los integrantes
					// del ciclo anterior
					if (peticion.getSolicitudSACG().getId() != null
							&& !peticion.getSolicitudSACG().getId().trim()
									.isEmpty() && !campana.equals("CE05")) {
						Float integrantes50 = (float) (integrantesAnteriores * porcentajaRenovar);
						integrantes50 = (float) Math
								.round(integrantes50 / CIEN);

						LogHandler.info(uid, getClass(),
								"validacionMinimoIntegrantesGuardar:"
										+ " integrantes al 50%: "
										+ integrantes50);

						if (integratesActualAnterior < integrantes50) {
							respuesta += "El grupo debe conservar el "
									+ porcentajaRenovar
									+ "% de los integrantes originales. <br>"
									+ " Favor de ingresarlo como un grupo nuevo <br>Bloqueante";
						}
					}
				}
			} else {
				LogHandler
						.info(uid,
								this.getClass(),
								" Por ahorita no se hizo la validacion del metodo"
										+ "validacionMinimoIntegrantesGuardar ya que no se cuenta un"
										+ " con una solicitud para la validacion ");
			}
		} catch (Exception e) {
			LogHandler
					.error(uid,
							getClass(),
							"validacionMinimoIntegrantesGuardar - Ocurrio un error debido a:  ",
							e);
			respuesta = e.getMessage();
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * Validar datos guardar solicitud credito.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the contrato ov
	 * @return respuesta ValidarGuardarSolicitudRespuesta
	 */
	public ValidarGuardarSolicitudCECRespuesta validarGuardarSolicitudCECCreditoSol(
			String uid, SolicitudSACGPeticion peticion) {

		ValidarGuardarSolicitudCECRespuesta respuesta = new ValidarGuardarSolicitudCECRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesion = null;

		String mensaje = "";

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat simpleDateFormatIng = new SimpleDateFormat(
				"yyyy/MM/dd");

		try {

			sesion = FabricaConexiones.obtenerSesionNTx();

			Date fechaContable = comun.obtenerFechaContable(uid).getFecha();
			if (peticion == null
					|| peticion.getSolicitudSACG().getCiclo() == null
					|| peticion.getSolicitudSACG().getFrecuenciaPago() == null
					|| peticion.getSolicitudSACG().getPlazo() == null
					|| peticion.getSolicitudSACG().getId() == null
					|| peticion.getSolicitudSACG().getId().trim().isEmpty()) {
				String mensajePeticion = "";
				if (peticion.getSolicitudSACG().getCiclo() == null) {
					mensajePeticion = "La peticion no contiene ciclo para las validaciones del CEC.";
				}
				if (peticion.getSolicitudSACG().getFrecuenciaPago() == null) {
					mensajePeticion = "La peticion no contiene frecuencia para las validaciones del CEC.";
				}
				if (peticion.getSolicitudSACG().getPlazo() == null) {
					mensajePeticion = "La peticion no contiene plazo para las validaciones del CEC.";
				}
				if (peticion.getSolicitudSACG().getId() == null
						|| peticion.getSolicitudSACG().getId().trim().isEmpty()) {
					mensajePeticion = "La peticion no contiene id solicitud, la cual es necesaria para las validaciones del CEC.";
				}
				throw new Exception(
						"La peticion es incorrecta para realizar las validaciones del CEC. "
								+ mensajePeticion);
			}

			LogHandler
					.trace(uid, getClass(),
							"validarGuardarSolicitudCECCreditoSol: - obtenerRenovacionSolicitud");
			String categoria = (String) sesion.selectOne(
					"obtenerRenovacionSolicitud", peticion.getSolicitudSACG()
							.getId());

			if (categoria == null) {
				throw new Exception(
						"Error al obtener la categoria en validaciones CEC");
			} else {
				peticion.getSolicitudSACG().setCategoriaProducto(categoria);
			}

			// Validacion fecha fin
			ConsultaFechaOV peticionValidaFechaFin = new ConsultaFechaOV();
			peticionValidaFechaFin.setDiaPago(peticion.getSolicitudSACG()
					.getDiaPago());
			peticionValidaFechaFin.setPerido(peticion.getSolicitudSACG()
					.getFrecuenciaPago());
			peticionValidaFechaFin.setPlazo(peticion.getSolicitudSACG()
					.getPlazo());
			peticionValidaFechaFin.setSucursal(peticion.getSolicitudSACG()
					.getSucursal());
			peticionValidaFechaFin.setFecha(peticion.getSolicitudSACG()
					.getFechaDesembolso());

			ConsultaRespuesta respuestaValidaFechaFin = consultasOriginacion
					.calcularFechaFinContrato(uid, peticionValidaFechaFin);

			if (!respuestaValidaFechaFin.getHeader().isEstatus()) {
				throw new Exception("Error en validacion fecha fin: "
						+ respuestaValidaFechaFin.getHeader().getMensaje()
						+ "-" + respuestaValidaFechaFin.getHeader().getUID());
			}
			LogHandler.info(uid, getClass(),
					"validarGuardarSolicitudCECCreditoSol: - Validacion fecha fin:"
							+ respuestaValidaFechaFin.getFechaFin() + " ? "
							+ peticion.getSolicitudSACG().getFechaFin());

			SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
			String fechaCalculo = formatoFecha.format(respuestaValidaFechaFin
					.getFechaFin());
			String fechaPeticion = formatoFecha.format(peticion
					.getSolicitudSACG().getFechaFin());

			LogHandler.info(uid, getClass(),
					"validarGuardarSolicitudCECCreditoSol: - Validacion fecha fin:"
							+ fechaPeticion + " ? " + fechaCalculo);

			if (!fechaPeticion.equals(fechaCalculo)) {
				throw new Exception("La fecha fin enviada es incorrecta.");
			}

			// Validacion numero de integrantes y plazo

			// Nuevo Credito
			if (peticion.getSolicitudSACG().getCiclo() == 0) {
				LogHandler
						.trace(uid, getClass(),
								"validarGuardarSolicitudCECCreditoSol: - obtenerParGeneral");
				ParGeneralOV valorMin = comun.obtenerParGeneralOV(uid,
						"COMGAINMIN");
				// (ParGeneralOV) sesion.selectOne("obtenerParGeneral",
				// "COMGAINMIN");
				if (valorMin == null || valorMin.getCgValor().trim().isEmpty()) {
					throw new Exception(
							"No fue posible obtener el numero minimo de integrantes.");
				}
				ParGeneralOV valorMax = comun.obtenerParGeneralOV(uid,
						"COMGAINMAX");
				// (ParGeneralOV) sesion.selectOne("obtenerParGeneral",
				// "COMGAINMAX");
				if (valorMax == null || valorMax.getCgValor().trim().isEmpty()) {
					throw new Exception(
							"No fue posible obtener el numero maximo de integrantes.");
				}
				if (peticion.getSolicitudSACGIntegrantes().size() < Integer
						.parseInt(valorMin.getCgValor())
						|| peticion.getSolicitudSACGIntegrantes().size() > Integer
								.parseInt(valorMax.getCgValor())) {
					throw new Exception(
							"El número de integrantes esta fuera del rango permitido (min: "
									+ valorMin.getCgValor() + " , max: "
									+ valorMax.getCgValor() + ")");
				}
			}

			// Renovacion
			if (peticion.getSolicitudSACG().getCiclo() > 0) {
				LogHandler
						.trace(uid, getClass(),
								"validarGuardarSolicitudCECCreditoSol: - obtenerParGeneral");
				ParGeneralOV valorMin = comun.obtenerParGeneralOV(uid,
						"COMREINMIN");
				// (ParGeneralOV) sesion.selectOne("obtenerParGeneral",
				// "COMREINMIN");
				if (valorMin == null || valorMin.getCgValor().trim().isEmpty()) {
					throw new Exception(
							"No fue posible obtener el numero minimo de integrantes.");
				}
				ParGeneralOV valorMax = comun.obtenerParGeneralOV(uid,
						"COMREINMAX");
				// (ParGeneralOV) sesion.selectOne("obtenerParGeneral",
				// "COMREINMAX");
				if (valorMax == null || valorMax.getCgValor().trim().isEmpty()) {
					throw new Exception(
							"No fue posible obtener el numero maximo de integrantes.");
				}

				if (peticion.getSolicitudSACG().getRenovacionFinanciada()) {
					int integrantesActivos = 0;
					for (SolicitudSACGIntegrante integrante : peticion
							.getSolicitudSACGIntegrantes()) {
						if (!integrante.getDesertor().equals("S")) {
							integrantesActivos++;
						}
					}
					if (integrantesActivos < Integer.parseInt(valorMin
							.getCgValor())
							|| integrantesActivos > Integer.parseInt(valorMax
									.getCgValor())) {
						throw new Exception("El número de integrantes ["
								+ integrantesActivos
								+ "] esta fuera del rango permitido (min: "
								+ valorMin.getCgValor() + " , max: "
								+ valorMax.getCgValor() + ")");
					}
				} else {
					if (peticion.getSolicitudSACGIntegrantes().size() < Integer
							.parseInt(valorMin.getCgValor())
							|| peticion.getSolicitudSACGIntegrantes().size() > Integer
									.parseInt(valorMax.getCgValor())) {
						throw new Exception(
								"El número de integrantes esta fuera del rango permitido (min: "
										+ valorMin.getCgValor() + " , max: "
										+ valorMax.getCgValor() + ")");
					}
				}
			}

			if (peticion.getSolicitudSACG().getFrecuenciaPago().trim()
					.equals("S")) {
				LogHandler
						.trace(uid, getClass(),
								"validarGuardarSolicitudCECCreditoSol: - obtenerParGeneral");
				ParGeneralOV plazoMin = comun.obtenerParGeneralOV(uid,
						"PLAMINSEM");
				// (ParGeneralOV) sesion.selectOne("obtenerParGeneral",
				// "PLAMINSEM");
				if (plazoMin == null || plazoMin.getCgValor().trim().isEmpty()) {
					throw new Exception(
							"No fue posible obtener el plazo minimo.");
				}
				ParGeneralOV plazoMax = comun.obtenerParGeneralOV(uid,
						"PLAMAXSEM");
				// (ParGeneralOV) sesion.selectOne("obtenerParGeneral",
				// "PLAMAXSEM");
				if (plazoMax == null || plazoMax.getCgValor().trim().isEmpty()) {
					throw new Exception(
							"No fue posible obtener el plazo maximo.");
				}
				if (peticion.getSolicitudSACG().getPlazo() < Integer
						.parseInt(plazoMin.getCgValor())
						|| peticion.getSolicitudSACG().getPlazo() > Integer
								.parseInt(plazoMax.getCgValor())) {
					throw new Exception("Verifique plazo (Min: "
							+ plazoMin.getCgValor() + " , Max: "
							+ plazoMax.getCgValor());
				}
			}

			if (peticion.getSolicitudSACG().getFrecuenciaPago().trim()
					.equals("C")) {
				LogHandler
						.trace(uid, getClass(),
								"validarGuardarSolicitudCECCreditoSol: - obtenerParGeneral");
				ParGeneralOV plazoMin = comun.obtenerParGeneralOV(uid,
						"PLAMINCAT");
				// (ParGeneralOV) sesion.selectOne("obtenerParGeneral",
				// "PLAMINCAT");
				if (plazoMin == null || plazoMin.getCgValor().trim().isEmpty()) {
					throw new Exception(
							"No fue posible obtener el plazo minimo.");
				}
				ParGeneralOV plazoMax = comun.obtenerParGeneralOV(uid,
						"PLAMAXCAT");
				// (ParGeneralOV) sesion.selectOne("obtenerParGeneral",
				// "PLAMAXCAT");
				if (plazoMax == null || plazoMax.getCgValor().trim().isEmpty()) {
					throw new Exception(
							"No fue posible obtener el plazo maximo.");
				}
				if (peticion.getSolicitudSACG().getPlazo() < Integer
						.parseInt(plazoMin.getCgValor())
						|| peticion.getSolicitudSACG().getPlazo() > Integer
								.parseInt(plazoMax.getCgValor())) {
					throw new Exception("Verifique plazo (Min: "
							+ plazoMin.getCgValor() + " , Max: "
							+ plazoMax.getCgValor());
				}
			}
			// Fin Validacion numero de integrantes y plazo

			// Validacion persona domicilio reunion
			if (peticion.getSolicitudSACG().getPersonaDomReunion() == null
					|| peticion.getSolicitudSACG().getPersonaDomReunion()
							.trim().isEmpty()) {
				mensaje += "Debe seleccionar un domicilio de reunion. <br>";
			} else {
				peticion.getSolicitudSACG().setPersonaDomReunion(
						comun.obtenerPersonaCliente(uid, peticion
								.getSolicitudSACG().getPersonaDomReunion()
								.trim()));
				LogHandler
						.trace(uid, getClass(),
								"validarGuardarSolicitudCECCreditoSol: - existePerDomReu");
				Integer existePersona = (Integer) sesion.selectOne(
						"existePerDomReu", peticion.getSolicitudSACG()
								.getPersonaDomReunion().trim());

				if (existePersona == 0 || existePersona == null) {
					mensaje += "La persona del domicilio de reunion no es valida. <br>";
				}

				esDesertor(peticion, peticion.getSolicitudSACG()
						.getPersonaDomReunion().trim());

			}

			// Fin Validacion persona domicilio reunion

			// Validacion mesa directiva
			if (peticion.getSolicitudSACGGrupo().getPresidente() == null
					|| peticion.getSolicitudSACGGrupo().getPresidente().trim()
							.isEmpty()) {
				mensaje += "Verifique los integrantes de la mesa directiva. <br>";
			} else {
				peticion.getSolicitudSACGGrupo()
						.setPresidente(
								comun.obtenerPersonaCliente(uid, peticion
										.getSolicitudSACGGrupo()
										.getPresidente().trim()));
				LogHandler
						.trace(uid, getClass(),
								"validarGuardarSolicitudCECCreditoSol: - existePersona Presidente");
				Integer existePresi = (Integer) sesion.selectOne(
						"existePerDomReu", peticion.getSolicitudSACGGrupo()
								.getPresidente().trim());

				if (existePresi == 0 || existePresi == null) {
					mensaje += "El presidente no es una persona valida. <br>";
				}
				esDesertor(peticion, peticion.getSolicitudSACGGrupo()
						.getPresidente().trim());
			}

			if (peticion.getSolicitudSACGGrupo().getSecretario() == null
					|| peticion.getSolicitudSACGGrupo().getSecretario().trim()
							.isEmpty()) {
				if (!mensaje
						.contains("Verifique los integrantes de la mesa directiva.")) {
					mensaje += "Verifique los integrantes de la mesa directiva. <br>";
				}
			} else {
				peticion.getSolicitudSACGGrupo()
						.setSecretario(
								comun.obtenerPersonaCliente(uid, peticion
										.getSolicitudSACGGrupo()
										.getSecretario().trim()));
				LogHandler
						.trace(uid, getClass(),
								"validarGuardarSolicitudCECCreditoSol: - existePerDomReu Secretario");
				Integer existeSecr = (Integer) sesion.selectOne(
						"existePerDomReu", peticion.getSolicitudSACGGrupo()
								.getSecretario().trim());

				if (existeSecr == 0 || existeSecr == null) {
					mensaje += "El secretario no es una persona valida. <br>";
				}
				esDesertor(peticion, peticion.getSolicitudSACGGrupo()
						.getSecretario().trim());
			}

			if (peticion.getSolicitudSACGGrupo().getTesorero() == null
					|| peticion.getSolicitudSACGGrupo().getTesorero().trim()
							.isEmpty()) {
				if (!mensaje
						.contains("Verifique los integrantes de la mesa directiva.")) {
					mensaje += "Verifique los integrantes de la mesa directiva. <br>";
				}
			} else {
				peticion.getSolicitudSACGGrupo().setTesorero(
						comun.obtenerPersonaCliente(uid, peticion
								.getSolicitudSACGGrupo().getTesorero().trim()));
				LogHandler
						.trace(uid, getClass(),
								"validarGuardarSolicitudCECCreditoSol: - existePerDomReu Tesorero");
				Integer existeTeso = (Integer) sesion.selectOne(
						"existePerDomReu", peticion.getSolicitudSACGGrupo()
								.getTesorero().trim());
				if (existeTeso == 0 || existeTeso == null) {
					mensaje += "El tesorero no es una persona valida. <br>";
				}
				esDesertor(peticion, peticion.getSolicitudSACGGrupo()
						.getTesorero().trim());
			}

			// Fin Validacion mesa directiva

			// Renovacion Financiada
			if (peticion.getSolicitudSACG().getRenovacionFinanciada()) {

				// Validacion ciclos integrantes
				LogHandler
						.trace(uid, getClass(),
								"validarGuardarSolicitudCECCreditoSol: - obtenerParGeneral");
				Integer cicloMinimoIntegrante = Integer
						.valueOf(comun
								.obtenerParGeneral(uid,
										"com.mx.finsol.originacion.financiada.ciclomin.integrate"));

				Double porcentajeMinimoCiclo = Double
						.valueOf(comun
								.obtenerParGeneral(uid,
										"com.mx.finsol.originacion.financiada.ciclomin.integrate.pct"));

				LogHandler.info(uid, getClass(),
						"Validacion ciclos integrantes cicloMinimoIntegrante="
								+ cicloMinimoIntegrante);
				LogHandler.info(uid, getClass(),
						"Validacion ciclos integrantes porcentajeMinimoCiclo="
								+ porcentajeMinimoCiclo);

				double totalIntegrantes = 0d;
				double totalIntegrantesMenor = 0d;
				for (int i = 0; i < peticion.getSolicitudSACGIntegrantes()
						.size(); i++) {
					if (!peticion.getSolicitudSACGIntegrantes().get(i)
							.getDesertor().equals("S")) {
						totalIntegrantes++;
						if (peticion.getSolicitudSACGIntegrantes().get(i)
								.getCiclo() == null) {
							peticion.getSolicitudSACGIntegrantes().get(i)
									.setCiclo(0);
						}
						if (peticion.getSolicitudSACGIntegrantes().get(i)
								.getCiclo().intValue() < cicloMinimoIntegrante
								.intValue()) {
							totalIntegrantesMenor++;
						}
					}
				}

				LogHandler.info(uid, getClass(),
						"Validacion ciclos integrantes totalIntegrantes="
								+ totalIntegrantes);
				LogHandler.info(uid, getClass(),
						"Validacion ciclos integrantes totalIntegrantesMenor="
								+ totalIntegrantesMenor);

				double porcentaje = (totalIntegrantesMenor / totalIntegrantes)
						* Constantes.CENTENA_DOUBLE;

				LogHandler.info(uid, getClass(),
						"Validacion ciclos integrantes porcentaje="
								+ porcentaje);

				if (porcentaje > porcentajeMinimoCiclo.doubleValue()) {
					throw new Exception(
							"No cumple con el porcentaje de integrantes con ciclo mayor a "
									+ cicloMinimoIntegrante);
				}

				// Validacion Dias Renovacion Financiada
				LogHandler
						.trace(uid, getClass(),
								"validarGuardarSolicitudCECCreditoSol: - obtenerParGeneral");
				ParGeneralOV diasRen = comun.obtenerParGeneralOV(uid,
						"DIASRENFIN");
				// (ParGeneralOV) sesion.selectOne("obtenerParGeneral",
				// "DIASRENFIN");
				if (diasRen == null || diasRen.getCgValor().trim().isEmpty()) {
					throw new Exception(
							"No fue posible obtener los dias de Renovacion de par_general.");
				}

				String numConAnt = comun.obtenerNumeroContrato(uid, peticion
						.getSolicitudSACG().getContratoPrevio());

				if (numConAnt == null) {
					throw new Exception(
							"No hay resultados para el numero de contrato anterior (financiada).");
				}

				final java.util.HashMap<String, Object> paramDias = new HashMap<String, Object>();
				paramDias.put("contratoAnt", numConAnt);
				paramDias.put("dias", diasRen.getCgValor());

				ContratoOV contratoAnt = (ContratoOV) sesion.selectOne(
						"obtFecDatAntConfirmar", paramDias);

				if (contratoAnt == null) {
					throw new Exception(
							"No se pudo recuperar informacion del contrato anterior para la validacion de los"
									+ "dias de renovacion financiada.");
				}

				if (fechaContable.after(contratoAnt.getFechaMaxima())
						|| fechaContable.equals(contratoAnt.getFechaMaxima())) {
					mensaje += "La renovación debio ser capturada/guardada antes de: "
							+ simpleDateFormat.format(contratoAnt
									.getFechaMaxima());
				}

				// Validacion de montos
				for (int i = 0; i < peticion.getSolicitudSACGIntegrantes()
						.size(); i++) {

					if (peticion.getSolicitudSACGIntegrantes().get(i)
							.getNuevoCreditoSolicitado() == null) {
						peticion.getSolicitudSACGIntegrantes().get(i)
								.setNuevoCreditoSolicitado(0d);
					}
					if (peticion.getSolicitudSACGIntegrantes().get(i)
							.getSaldoActual() == null) {
						peticion.getSolicitudSACGIntegrantes().get(i)
								.setSaldoActual(0d);
					}

					if (!peticion.getSolicitudSACGIntegrantes().get(i)
							.getDesertor().equals("S")) {

						if (peticion.getSolicitudSACGIntegrantes().get(i)
								.getSaldoActual() > peticion
								.getSolicitudSACGIntegrantes().get(i)
								.getNuevoCreditoSolicitado()
								&& !peticion.getSolicitudSACGIntegrantes()
										.get(i).getDesertor().equals("S")) {
							throw new Exception(
									"Monto del nuevo crédito solicitado $"
											+ peticion
													.getSolicitudSACGIntegrantes()
													.get(i)
													.getNuevoCreditoSolicitado()
											+ " debe ser mayor al saldo que tiene en el contrato actual $"
											+ peticion
													.getSolicitudSACGIntegrantes()
													.get(i).getSaldoActual()
											+ " para el cliente: "
											+ peticion
													.getSolicitudSACGIntegrantes()
													.get(i).getNombreCompleto());
						}
					}
				}

			}
			// Fin Validacion Dias Renovacion Financiada

			// Validar beneficiarios

			Boolean tieneSeguroVida = existeSeguroVidaSolicitud(peticion
					.getSolicitudSACGIntegrantes());

			if (tieneSeguroVida == null) {
				throw new Exception(
						"Ocurrio un error al verificar si algun integrante tiene seguro de vida");
			}

			if (tieneSeguroVida) {
				List<BeneficiariosClienteOV> listaBeneficiarios = new ArrayList<BeneficiariosClienteOV>();

				for (int i = 0; i < peticion.getSolicitudSACGIntegrantes()
						.size(); i++) {
					BeneficiariosClienteOV beneficiario = new BeneficiariosClienteOV();

					if (peticion.getSolicitudSACGIntegrantes().get(i)
							.getSeguro().equals("S")) {
						beneficiario.setPersona(peticion
								.getSolicitudSACGIntegrantes().get(i)
								.getCodigoPocg());
						listaBeneficiarios.add(beneficiario);
					}
				}

				// se obtienen los beneficiarios con los clientes
				PeticionConsulta peticionBeneficiarios = new PeticionConsulta();
				peticionBeneficiarios
						.setBeneficiariosClientes(listaBeneficiarios);

				SegurosRespuestaConsulta beneficiariosRespuesta = seguros
						.consultaPersonaBeneficiarios(uid,
								peticionBeneficiarios);

				if (!beneficiariosRespuesta.getHeader().isEstatus()) {
					throw new Exception(
							"Ocurrio un error al validar Beneficiarios: "
									+ beneficiariosRespuesta.getHeader()
											.getMensaje());
				}

				// se verifica que todos los clientes tengan beneficiarios
				String mensajeBeneficiarios = "";

				for (int i = 0; i < peticion.getSolicitudSACGIntegrantes()
						.size(); i++) {
					if (peticion.getSolicitudSACGIntegrantes().get(i)
							.getSeguro().equals("S")) {
						Boolean existeBen = false;
						for (int j = 0; j < beneficiariosRespuesta
								.getBeneficiarioCliente().size(); j++) {
							if (peticion
									.getSolicitudSACGIntegrantes()
									.get(i)
									.getCodigoPocg()
									.trim()
									.contentEquals(
											beneficiariosRespuesta
													.getBeneficiarioCliente()
													.get(j).getPersona().trim())) {
								existeBen = true;
							}
						}
						peticion.getSolicitudSACGIntegrantes().get(i)
								.setExistenBeneficiarios(existeBen);
					}
				}

				for (int i = 0; i < peticion.getSolicitudSACGIntegrantes()
						.size(); i++) {
					if (peticion.getSolicitudSACGIntegrantes().get(i)
							.getSeguro().equals("S")
							&& !peticion.getSolicitudSACGIntegrantes().get(i)
									.isExistenBeneficiarios()) {

						mensajeBeneficiarios = mensajeBeneficiarios
								+ "El cliente "
								+ peticion.getSolicitudSACGIntegrantes().get(i)
										.getNombreCompleto()
								+ " no cuenta con beneficiarios\n";

					}
				}

				if (!mensajeBeneficiarios.equals("")) {
					mensaje += mensajeBeneficiarios + " <br>";
				}

			}
			// Fin Validar beneficiarios

			// Validacion Agenda
			AsignacionDetalleOV asignacionDetalleOV = new AsignacionDetalleOV();
			asignacionDetalleOV.setNumeroSucursal(peticion.getSolicitudSACG()
					.getSucursal());
			asignacionDetalleOV.setNumeroAsesor(peticion.getSolicitudSACG()
					.getCdgAsesor());
			asignacionDetalleOV.setDiaReunion(peticion.getSolicitudSACG()
					.getDiaReunion());
			asignacionDetalleOV.setHoraReunionInicio(peticion
					.getSolicitudSACG().getHoraReunion());
			asignacionDetalleOV.setHoraReunionFin(peticion.getSolicitudSACG()
					.getHoraReunionFin());
			asignacionDetalleOV.setProducto(peticion.getSolicitudSACG()
					.getProducto());
			asignacionDetalleOV.setFrecuencia(peticion.getSolicitudSACG()
					.getFrecuenciaPago());
			asignacionDetalleOV.setFechaInicio(simpleDateFormatIng
					.format(peticion.getSolicitudSACG().getFechaDesembolso()));
			asignacionDetalleOV.setIdSolicitud(peticion.getSolicitudSACG()
					.getId());

			VerificaAsignacionRespuesta respAsignacion = consultas
					.validaAsignacionTarea(uid, asignacionDetalleOV);

			if (!respAsignacion.getHeader().isEstatus()) {
				mensaje += "Error en valida asignacion: "
						+ respAsignacion.getHeader().getMensaje() + " <br>";
				respuesta
						.getHeader()
						.setCodigo(
								respAsignacion.getHeader().getCodigo() != null ? respAsignacion
										.getHeader().getCodigo() : "");
			}
			// Fin Validacion Agenda

			if (peticion.getSolicitudSACG().getTraspasoGarantia() == null
					|| peticion.getSolicitudSACG().getTraspasoGarantia().trim()
							.isEmpty()) {
				peticion.getSolicitudSACG().setTraspasoGarantia("N");
			}
			// Validacion Traspaso
			if (peticion.getSolicitudSACG().getTraspasoGarantia().equals("S")) {

				if (peticion.getSolicitudSACG().getContratoPrevio() != null
						&& !peticion.getSolicitudSACG().getContratoPrevio()
								.isEmpty()) {

					String numConAnt = comun.obtenerNumeroContrato(uid,
							peticion.getSolicitudSACG().getContratoPrevio()
									.trim());

					if (numConAnt == null) {
						throw new Exception(
								"No hay resultados para obtener el numero de contrato anterior.");
					}

					final java.util.HashMap<String, Object> parametrosConAnt = new HashMap<String, Object>();
					parametrosConAnt.put("contratoAnt", numConAnt);

					ContratoOV contratoAnt = (ContratoOV) sesion.selectOne(
							"obtDatAntConfirmar", parametrosConAnt);

					if (contratoAnt == null) {
						throw new Exception(
								"No se pudo recuperar informacion del contrato anterior para la validacion de traspaso de"
										+ " garantia.");
					}

					if (contratoAnt.getProducto().trim().equals("GCDG")
							|| contratoAnt.getProducto().trim().equals("GCDC")) {
						if (contratoAnt.getSaldoGarantia() <= 0) {
							mensaje += "No es posible realizar el traspaso de la garantia, no existe saldo. <br>";
						}
					} else {
						mensaje += "El credito anterior no pertenece al producto de garantia, no es posible realizar el traspaso "
								+ "de la garantia. <br>";
					}
				} else {
					throw new Exception(
							"El credito no cuenta con un credito anterior, pero traspaso garantia esta como SI");
				}
			}
			// Fin Validacion Traspaso

			// Valdiacion excepcion garantia
			Integer porcentajeMinimoGarantia = Integer.valueOf(comun
					.obtenerParGeneral(uid,
							"com.mx.finsol.originacion.pctgarantia.minima"));
			if (peticion.getSolicitudSACG().getPctGarantia() == null) {
				peticion.getSolicitudSACG().setPctGarantia(0);
			}

			if (peticion.getSolicitudSACG().getPctGarantia().intValue() < porcentajeMinimoGarantia
					.intValue()) {
				// Genera excepcion
				if (peticion.getSolicitudSACG().getJustificacionExc() == null
						|| peticion.getSolicitudSACG().getJustificacionExc()
								.trim().isEmpty()) {
					throw new Exception(
							"Es necesario el mensaje de justificación para generar la excepcion de garantía.");
				}
				peticion.getSolicitudSACG().setExcepcionGarantia("S");
			}

			if (!mensaje.equals("")) {
				throw new Exception(mensaje);
			}

			// LRSS ORIG-286 validación de justificación de la excepción
			if (peticion.getSolicitudSACG().isEnviarDocumental()
					&& (peticion.getSolicitudSACG()
							.getJustificacionValidacionDocumental() == null || peticion
							.getSolicitudSACG()
							.getJustificacionValidacionDocumental().toString()
							.isEmpty())) {
				throw new Exception(
						"Es necesario el mensaje de justificación para generar la excepcion de validación BC.");
			}

		} catch (Exception e) {

			LogHandler.error(
					uid,
					getClass(),
					"Error en validarGuardarSolicitudCECCreditoSol: "
							+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesion);
		}
		return respuesta;
	}

	/**
	 * Verifica si Seguro completo.
	 *
	 * @param list
	 *            the arreglo integrantes
	 * @return the string
	 */
	private Boolean existeSeguroVidaSolicitud(List<SolicitudSACGIntegrante> list) {
		Boolean unotieneSeguro = false;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getSeguro().equals("S")) {
				unotieneSeguro = true;
			}
		}
		return unotieneSeguro;
	}

	/**
	 * Diferencia en dias.
	 *
	 * @param fechaMayor
	 *            the fecha mayor
	 * @param fechaMenor
	 *            the fecha menor
	 * @return the int
	 */
	public static int diferenciaEnDias(Date fechaMayor, Date fechaMenor) {
		long diferenciaEnMs = fechaMayor.getTime() - fechaMenor.getTime();
		long dias = diferenciaEnMs / (1000 * 60 * 60 * 24);
		return (int) dias;
	}

	/**
	 * Enviar solicitud cec credito.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the peticion
	 * @return the solicitudes respuesta
	 */
	public EnviarSolicitudCecRespuesta enviarSolicitudCEC(String uid,
			ObtenerDatosSolicitudPeticion peticion) {

		EnviarSolicitudCecRespuesta respuesta = new EnviarSolicitudCecRespuesta();
		SolicitudSACG solicitudSACG = new SolicitudSACG();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensaje(
				"La solicitud se envio correctamente al CEC.");

		SqlSession sesionTx = null;

		try {
			if (peticion == null || peticion.getSolicitud() == null
					|| peticion.getSolicitud().isEmpty()
					|| peticion.getUsuario() == null
					|| peticion.getUsuario().isEmpty()) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}

			// RIMM:: se recupera si existe una tarea pendiente TRED
			solicitudSACG.setId(peticion.getSolicitud().trim());
			tareasPendientes(uid, solicitudSACG, Constantes.TAREA_DOCUMENTAL);
			LogHandler.info(uid, this.getClass(),
					"obtenerTareasPendientesBuzon--tareaspendientes: "
							+ solicitudSACG.getTareaDocumentalPendiente());

			if (solicitudSACG.getTareaDocumentalPendiente() == 0) {

				ObtenerDatosSolicitudRespuesta respObtDatSolicitud = obtenerDatosSolicitud(
						uid, peticion);

				if (!respObtDatSolicitud.getHeader().isEstatus()) {

					throw new Exception(
							"Error al obtener los datos de la solicitud: "
									+ respObtDatSolicitud.getHeader()
											.getMensaje());
				}

				/*
				 * ValidarGuardarSolicitudCECRespuesta valCECRespuesta =
				 * validarGuardarSolicitudCECCredito(uid,
				 * respObtDatSolicitud.getContratoOV());
				 * 
				 * if (!valCECRespuesta.getHeader().isEstatus()) { throw new
				 * Exception(
				 * "Error al validar - validarGuardarSolicitudCECCredito: " +
				 * valCECRespuesta.getHeader().getMensaje()); }
				 */
				LogHandler.info(uid, getClass(), " enviarSolicitudCECTarea");
				EnviarSolicitudCecTareaRespuesta respuestaEnviarCECTarea = enviarSolicitudCECTarea(
						uid, peticion, respObtDatSolicitud.getContratoOV());

				if (!respuestaEnviarCECTarea.getHeader().isEstatus()) {
					throw new Exception("Error al validar: "
							+ respuestaEnviarCECTarea.getHeader().getMensaje());
				}
			} else {
				respuesta.getHeader().setMensaje(
						"La solicitud cuenta con "
								+ solicitudSACG.getTareaDocumentalPendiente()
								+ " tarea pendiente.");
			}

		} catch (Exception e) {
			try {
				sesionTx = FabricaConexiones.obtenerSesionTx();

				sesionTx.update("actualizarEtapaFalseSolicitud",
						peticion.getSolicitud());

				sesionTx.commit(true);
			} catch (Exception ex) {
				FabricaConexiones.rollBack(sesionTx);
			}

			LogHandler.error(uid, getClass(), "Error en enviarSolicitudCEC: "
					+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionTx);
		}
		return respuesta;
	}

	/**
	 * Enviar solicitud cec credito.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the peticion
	 * @return the solicitudes respuesta
	 */
	public EnviarSolicitudCecRespuesta enviarSolicitudCECDocumental(String uid,
			ObtenerDatosSolicitudPeticion peticion) {

		EnviarSolicitudCecRespuesta respuesta = new EnviarSolicitudCecRespuesta();
		SolicitudSACG solicitudSACG = new SolicitudSACG();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensaje(
				"La solicitud se envio correctamente al CEC.");

		SqlSession sesionTx = null;

		try {
			if (peticion == null || peticion.getSolicitud() == null
					|| peticion.getSolicitud().isEmpty()
					|| peticion.getUsuario() == null
					|| peticion.getUsuario().isEmpty()) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}

			// RIMM:: se recupera si existe una tarea pendiente TRED
			solicitudSACG.setId(peticion.getSolicitud().trim());
			tareasPendientes(uid, solicitudSACG, Constantes.TAREA_DOCUMENTAL);
			LogHandler.info(uid, this.getClass(),
					"obtenerTareasPendientesBuzon--tareaspendientes: "
							+ solicitudSACG.getTareaDocumentalPendiente());

			if (solicitudSACG.getTareaDocumentalPendiente() == 0) {
				ObtenerDatosSolicitudRespuesta respObtDatSolicitud = obtenerDatosSolicitud(
						uid, peticion);

				if (!respObtDatSolicitud.getHeader().isEstatus()) {

					throw new Exception(
							"Error al obtener los datos de la solicitud: "
									+ respObtDatSolicitud.getHeader()
											.getMensaje());
				}

				LogHandler.info(uid, getClass(), " enviarSolicitudCECTarea");
				EnviarSolicitudCecTareaRespuesta respuestaEnviarCECTarea = enviarSolicitudCECTarea(
						uid, peticion, respObtDatSolicitud.getContratoOV());

				if (!respuestaEnviarCECTarea.getHeader().isEstatus()) {
					throw new Exception("Error al validar: "
							+ respuestaEnviarCECTarea.getHeader().getMensaje());
				}
			} else {
				respuesta.getHeader().setMensaje(
						"La solicitud cuenta con "
								+ solicitudSACG.getTareaDocumentalPendiente()
								+ " tarea pendiente.");
			}

		} catch (Exception e) {
			FabricaConexiones.rollBack(sesionTx);
			LogHandler.error(uid, getClass(), "Error en enviarSolicitudCEC: "
					+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionTx);
		}
		return respuesta;
	}

	/**
	 * Metodo que valida ultima parte del hold enviar solicitud cec tarea.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the peticion
	 * @param contratoOV
	 *            the contrato ov
	 * @return the enviar solicitud cec tarea respuesta
	 */
	public EnviarSolicitudCecTareaRespuesta enviarSolicitudCECTarea(String uid,
			ObtenerDatosSolicitudPeticion peticion, ContratoOV contratoOV) {
		EnviarSolicitudCecTareaRespuesta respuesta = new EnviarSolicitudCecTareaRespuesta();
		SolicitudSACG solicitudSACG = new SolicitudSACG();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesion = null;
		SqlSession sesionTx = null;

		try {

			sesion = FabricaConexiones.obtenerSesionNTx();
			sesionTx = FabricaConexiones.obtenerSesionTx();

			// Verificacion Telefonica
			// Solo para : 21050,21057,21070,21071
			// mapProductos.put("21050", "GCS1"); //CREDITO COMUNAL
			// mapProductos.put("21057", "GCC1"); //CREDITO COMUNAL FORTNIGHT
			// mapProductos.put("21070", "GCDG"); //CREDITO COMUNAL DEPOSITO
			// GARANTIA SEMANAL
			// mapProductos.put("21071", "GCDC"); //CREDITO COMUNAL DEPOSITO
			// GARANTIA CATORCENAL

			LogHandler
					.trace(uid,
							getClass(),
							"enviarSolicitudCECTarea: - obtenerParGeneral: VARIABLE_CICLO_VERIFICACION_TELEFONICA");
			String varVerificacion = comun.obtenerParGeneral(uid, "VCIC_VE_TE");

			if (contratoOV.getGrupo().getCiclo() <= Integer
					.parseInt(varVerificacion)) {
				if (contratoOV.getProducto().equals("GCS1")
						|| contratoOV.getProducto().equals("GCC1")
						|| contratoOV.getProducto().equals("GCDG")
						|| contratoOV.getProducto().equals("GCDC")) {

					ConsultaInformacionTelefonicaPeticion peticionVT = new ConsultaInformacionTelefonicaPeticion();

					peticionVT.setIdSolicitud(contratoOV.getSolicitud().trim());
					peticionVT.setSucursal(contratoOV.getSucursal());
					peticionVT
							.setNombreGrupo(contratoOV.getGrupo().getNombre());
					peticionVT.setUsuario(peticion.getUsuario());

					ConsultaInformacionTelefonicaRespuesta respConsVT = enviarSolicitudVerificacionTelefonica(
							uid, peticionVT, sesionTx);

					if (!respConsVT.getHeader().isEstatus()) {
						throw new Exception("ERROR Enviar Call Center: "
								+ respConsVT.getHeader().getMensaje());
					}

				}
			}
			// Fin Verificacion Telefonica

			// Update a solicitudes Finsol
			final java.util.HashMap<String, Object> parametrosActCont = new HashMap<String, Object>();
			parametrosActCont.put("solicitud", peticion.getSolicitud());

			sesionTx.update("actualizarEtapaCEC", parametrosActCont);
			// Fin Update a solicitudes Finsol

			// Valdiacion excepcion garantia
			Integer porcentajeMinimoGarantia = Integer.valueOf(comun
					.obtenerParGeneral(uid,
							"com.mx.finsol.originacion.pctgarantia.minima"));
			if (contratoOV.getPctGarantia() == null) {
				contratoOV.setPctGarantia(0);
			}
			boolean excepcionGarantia = false;

			// LRSS ORIG-276 para saber si se genera una tarea al CEC o al
			// CEC-Dcomental
			if (!peticion.isEnviarDocumental()) {
				// aqui en esta parte se genera la tarea de excepcion
				if ((contratoOV.getPctGarantia().intValue() < porcentajeMinimoGarantia
						.intValue()) && peticion.getEntrarBuzon().equals("S")) {
					ExcepcionGarantiaPeticion peticionExc = new ExcepcionGarantiaPeticion();
					peticionExc.setTipoTarea("TOEG");
					peticionExc.setSucursal(String.valueOf(contratoOV
							.getSucursal()));
					peticionExc.setDescripcion(peticion.getSolicitud());
					peticionExc.setUsuarioAlta(peticion.getUsuario());
					peticionExc.setPerfil("PCOM");
					peticionExc.setStatus("P");
					peticionExc.setJustificacion(contratoOV
							.getJustificacionExc());

					ExcepcionGarantiaRespuesta respuestaExc = generarTareaExcepcionGarantiaTarea(
							uid, peticionExc, sesionTx);

					if (!respuestaExc.getHeader().isEstatus()) {
						throw new Exception(
								"Ocurrio un error en generar tarea excepcion : "
										+ respuestaExc.getHeader().getMensaje());
					}
					excepcionGarantia = true;
				}
			}

			sesionTx.commit(true);

			// LRSS ORIG-276 se agregó este if para indicar si es tarea al cec o
			// documental-cec
			// wsAsignacion
			LogHandler.trace(uid, getClass(),
					"enviarSolicitudCECTarea: - obtenerParGeneral: "
							+ "VARIABLE WEB SERVICE ASIGNACION");
			String urlWSAsignacion = comun.obtenerParGeneral(uid, "WS_ASIGNAC");

			LogHandler.info(uid, getClass(),
					"Se intenta obtener una instancia del WS de Asignacion");
			AsignacionServiceServiceLocator servicioAsignacion = new AsignacionServiceServiceLocator();
			servicioAsignacion
					.setAsignacionServicePortEndpointAddress(urlWSAsignacion);

			if (!peticion.isEnviarDocumental()) {
				if (!excepcionGarantia) {
					respuestaAsignacion = servicioAsignacion
							.getAsignacionServicePort()
							.registraSolicitudAsignacion(
									contratoOV.getSolicitud().trim());

					if (!respuestaAsignacion.isEstatus()) {
						throw new Exception(
								"Ocurrio un error en registraSolicitudAsignacion, se envía a la url "
										+ urlWSAsignacion + " : "
										+ respuestaAsignacion.getMensaje());
					}
					// Fin Asignacion
				}
			} else {

				// se recupera si existe un tarea pendiente de cupo y monto TRCE
				solicitudSACG.setId(peticion.getSolicitud().trim());
				int tareaPendienteCuposYMonto = tareasPendientes(uid,
						solicitudSACG, Constantes.TAREA_CUPO_MONTO);
				LogHandler.info(uid, this.getClass(),
						"guardarSolicitudCreditoTarea--tareaspendientesTRCE: "
								+ tareaPendienteCuposYMonto);

				if (tareaPendienteCuposYMonto == 0) {

					respuestaAsignacion = servicioAsignacion
							.getAsignacionServicePort()
							.registraSolicitudDocumental(
									peticion.getSolicitud().trim(),
									peticion.getJustificacionExcepcionDocumental()
											.trim());

					if (!respuestaAsignacion.isEstatus()) {
						throw new Exception(
								"Ocurrio un error en registraSolicitudAsignacionDocumental, se envía a la url "
										+ urlWSAsignacion + " : "
										+ respuestaAsignacion.getMensaje());
					} else {
						// actualizar el campo de fecha_asigna_documental
						sesionTx.update("actualizarFechAsignacionDocumental",
								peticion.getSolicitud());
						LogHandler
								.info(uid, getClass(),
										"Se actualizo correctamente el campo fecha_asigna_documental..");
					}
				} else {
					LogHandler
							.info(uid,
									this.getClass(),
									"enviarSolicitudCECTarea no se envio a documental "
											+ "por que cuenta con una tarea pendiente de cupo y monto. ");
				}
			}

			respuesta.getHeader().setMensaje(
					"Se ha completado correctamente enviarSolicitudCECTarea");

			sesionTx.commit(true);

		} catch (Exception e) {
			FabricaConexiones.rollBack(sesionTx);
			LogHandler.error(uid, getClass(),
					"Error en enviarSolicitudCECTarea: " + e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesion);
			FabricaConexiones.close(sesionTx);
		}

		return respuesta;
	}

	/**
	 * Obtener datos solicitud.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the peticion
	 * @return the contrato ov
	 */
	public ObtenerDatosSolicitudRespuesta obtenerDatosSolicitud(String uid,
			ObtenerDatosSolicitudPeticion peticion) {
		ObtenerDatosSolicitudRespuesta respuesta = new ObtenerDatosSolicitudRespuesta();

		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesion = null;

		try {

			sesion = FabricaConexiones.obtenerSesionNTx();

			if (peticion == null || peticion.getSolicitud() == null
					|| peticion.getSolicitud().isEmpty()
					|| peticion.getUsuario() == null
					|| peticion.getUsuario().isEmpty()) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}

			// Obtener los elementos del contrato
			LogHandler.trace(uid, getClass(),
					"obtenerDatosSolicitud: - obtenerConfirmarCredito");
			LogHandler.info(uid, getClass(),
					"obtenerDatosSolicitud: - obtenerConfirmarCredito");
			ContratoOV contrato = (ContratoOV) sesion.selectOne(
					"obtenerConfirmarCredito", peticion.getSolicitud());

			if (contrato == null) {
				throw new Exception(
						"La consulta no arrojo resultados para la solicitud, la solicitud no existe o esta cancelada");
			}

			contrato.setUsuario(peticion.getUsuario());
			contrato.setAsesor(contrato.getAsesor().trim());
			contrato.setContratoActual(contrato.getContratoActual().trim());
			contrato.setNumero_cliente_reunion(contrato
					.getNumero_cliente_reunion().trim());
			contrato.setSolicitud(contrato.getSolicitud().trim());

			// LRSS ORIG-276 se agrega la justificación
			if (peticion.isEnviarDocumental()) {
				contrato.setEnviarDocumental(peticion.isEnviarDocumental());
				contrato.setJustificacionExcepcionDocumental(peticion
						.getJustificacionExcepcionDocumental());
			} else {
				contrato.setEnviarDocumental(false);
			}

			// Obtener los elementos del grupo
			LogHandler.trace(uid, getClass(),
					"obtenerDatosSolicitud: - obtenerConfirmarGrupo");
			LogHandler.info(uid, getClass(),
					"obtenerDatosSolicitud: - obtenerConfirmarGrupo");
			GrupoOV grupoOV = (GrupoOV) sesion.selectOne(
					"obtenerConfirmarGrupo", peticion.getSolicitud());

			if (grupoOV == null) {
				throw new Exception(
						"La consulta no arrojo resultados de grupo para la solicitud");
			}

			grupoOV.setIdentificador(grupoOV.getIdentificador().trim());
			grupoOV.setPresidente(grupoOV.getPresidente().trim());
			grupoOV.setSecretario(grupoOV.getSecretario().trim());
			grupoOV.setTesorero(grupoOV.getTesorero().trim());

			contrato.setGrupo(grupoOV);

			// Obtener los elementos de integrantes
			LogHandler.trace(uid, getClass(),
					"obtenerDatosSolicitud: - obtenerConfirmarIntegrantes");
			LogHandler.info(uid, getClass(),
					"obtenerDatosSolicitud: - obtenerConfirmarIntegrantes");
			@SuppressWarnings("unchecked")
			List<IntegranteOV> integrantesList = (List<IntegranteOV>) sesion
					.selectList("obtenerConfirmarIntegrantes",
							peticion.getSolicitud());

			if (integrantesList == null || integrantesList.size() == 0) {
				throw new Exception(
						"La consulta no arrojo resultados de integrantes para la solicitud");
			}

			contrato.setIntegrantesList(integrantesList);

			respuesta.setContratoOV(contrato);
			respuesta.getHeader().setMensaje(
					"Se han obtenido los datos de la solicitud");

		} catch (Exception e) {

			LogHandler.error(uid, getClass(),
					"Error en obtenerDatosSolicitud: " + e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesion);
		}
		return respuesta;
	}

	public ActualizarDesertorRespuesta actualizarDesertorTarea(String uid,
			ActualizarDesertorPeticion peticion) {
		ActualizarDesertorRespuesta respuesta = new ActualizarDesertorRespuesta();

		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionTx = null;

		try {

			sesionTx = FabricaConexiones.obtenerSesionTx();

			if (peticion == null || peticion.getSolicitud() == null
					|| peticion.getCliente() == null) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}

			// Se realiza la validacion para la relacion de sucursal-contrato
			final java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();

			parametros.put("solicitud", peticion.getSolicitud());
			parametros.put("cliente", peticion.getCliente());

			sesionTx.update("actualizarDesertor", parametros);

			sesionTx.commit();

		} catch (Exception e) {

			FabricaConexiones.rollBack(sesionTx);

			LogHandler.error(uid, getClass(),
					"Error en actualizarDesertorTarea: " + e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionTx);
		}
		return respuesta;
	}

	/**
	 * Funcion para validar un contrato para renovacion financiada
	 * 
	 * @param uid
	 *            identificador unico de la transaccion
	 * @param peticion
	 *            the peticion
	 * @return the string
	 */
	@SuppressWarnings("unchecked")
	public ValidarContratoRespuesta validarContratoRenovacionFinanciada(
			String uid, ValidarContratoPeticion peticion) {
		ValidarContratoRespuesta respuesta = new ValidarContratoRespuesta();

		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionNTx = null;

		try {

			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.info(uid, getClass(),
					"validarContratoRenovacionFinanciada ");
			if (peticion == null || peticion.getContrato() == null
					|| peticion.getContrato().trim().isEmpty()) {
				throw new Exception("La peticion o sus datos son incorrectos.");
			}

			String contrato = comun.obtenerNumeroContrato(uid,
					peticion.getContrato());

			if (contrato == null || contrato.isEmpty()) {
				throw new Exception("El contrato de la peticion es invalido.");
			}

			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			final FechaContableOV fechaContable = comun
					.obtenerFechaContable(uid);

			final HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("contrato", contrato);
			parametros.put("fechaContable",
					formatter.format(fechaContable.getFecha()));

			LogHandler
					.trace(uid,
							getClass(),
							"==> validarContratoRenovacionFinanciada - obtenerDatosCreditoRenovacionFinanciada");

			HashMap<String, Object> datosContrato = (HashMap<String, Object>) sesionNTx
					.selectOne("obtenerDatosCreditoRenovacionFinanciada",
							parametros);

			String mensaje = "El crédito no aplica para renovación financiada. ";

			if (!datosContrato.get("status").toString().equals("D")) {
				throw new Exception(mensaje
						+ "El estatus es incorrecto, debe estar DISPUESTO.");
			}

			Integer cicloMinimo = Integer.valueOf(comun.obtenerParGeneral(uid,
					"com.mx.finsol.originacion.financiada.ciclo.minimo"));
			Integer cicloContrato = Integer.valueOf(datosContrato.get(
					"cicloGrupo").toString());

			if (cicloContrato.intValue() < cicloMinimo.intValue()) {
				throw new Exception(mensaje + "Es ciclo " + cicloContrato + ".");
			}

			Integer diasMora = Integer.valueOf(datosContrato.get("diasMora")
					.toString());
			if (diasMora.intValue() > 0) {
				throw new Exception(mensaje + "El crédito está en mora.");
			}

			Integer pagosMinimo = Integer
					.valueOf(comun
							.obtenerParGeneral(uid,
									"com.mx.finsol.originacion.financiada.pagos.faltantes.minimo"));

			Integer pagosFaltantes = Integer.valueOf(datosContrato.get(
					"pagosFaltantes").toString());

			// Consideramos creditos catorcenales
			if (datosContrato.get("frecuencia").toString().equals("C")) {
				pagosFaltantes = pagosFaltantes * 2;
			}

			LogHandler.info(uid, getClass(), "pagosFaltantes=" + pagosFaltantes
					+ "pagosMinimo=" + pagosMinimo);
			if (pagosFaltantes.intValue() > pagosMinimo.intValue()) {
				throw new Exception(mensaje
						+ "Número de pagos pendientes mayor al  permitido.");
			}

			// Maximo retraso
			Integer maximoRetraso = Integer
					.valueOf(comun
							.obtenerParGeneral(uid,
									"com.mx.finsol.originacion.financiada.contrato.maximoretraso"));
			Integer maximoRetrasoContrato = Integer.valueOf(datosContrato.get(
					"maximoRetraso").toString());

			if (maximoRetrasoContrato.intValue() > maximoRetraso.intValue()) {
				throw new Exception(mensaje
						+ "Contrato vigente con dias atraso ["
						+ maximoRetrasoContrato + "].");
			}

			Integer maximoRetrasoAnterior = Integer
					.valueOf(comun
							.obtenerParGeneral(uid,
									"com.mx.finsol.originacion.financiada.contratoant.maximoretraso"));

			Integer maximoDiasLiquidacion = Integer
					.valueOf(comun
							.obtenerParGeneral(uid,
									"com.mx.finsol.originacion.financiada.contratoant.liquidacion"));

			LogHandler
					.trace(uid,
							getClass(),
							"==> validarContratoRenovacionFinanciada - obtenerDatosCreditoAnteriorRenovacionFinanciada");

			parametros.clear();
			parametros.put("cliente", datosContrato.get("cliente").toString());
			parametros.put("ciclo", cicloContrato);
			LogHandler
					.trace(uid,
							getClass(),
							"==> validarContratoRenovacionFinanciada - obtenerDatosCreditoAnteriorRenovacionFinanciada");

			HashMap<String, Object> datosContratoAnterior = (HashMap<String, Object>) sesionNTx
					.selectOne(
							"obtenerDatosCreditoAnteriorRenovacionFinanciada",
							parametros);

			if (datosContratoAnterior == null) {
				throw new Exception(
						"No fue posible recuperar los datos del contrato anterior ciclo="
								+ (cicloContrato - 1) + ".");
			}
			String contratoAnterior = datosContratoAnterior.get("contrato")
					.toString();
			Integer maximoRetrasoContratoAnt = Integer
					.valueOf(datosContratoAnterior.get("maximoRetraso")
							.toString());
			Integer diasLiquidacion = Integer.valueOf(datosContratoAnterior
					.get("diasLiquidacion").toString());
			String contratoAnteriorLD = datosContratoAnterior
					.get("contrato_LD").toString();

			if (maximoRetrasoContratoAnt.intValue() > maximoRetrasoAnterior
					.intValue()) {
				throw new Exception(mensaje + "Contrato anterior "
						+ contratoAnterior + " - " + contratoAnteriorLD
						+ " con días atraso [" + maximoRetrasoContratoAnt
						+ " días].");
			}

			if (diasLiquidacion.intValue() > maximoDiasLiquidacion.intValue()) {
				throw new Exception(
						mensaje
								+ "Contrato anterior "
								+ contratoAnterior
								+ " - "
								+ contratoAnteriorLD
								+ " no liquido en tiempo, días despues de fecha esperada de liquidacion ["
								+ diasLiquidacion + " días].");
			}

			// Validacion Dias Renovacion Financiada
			LogHandler
					.trace(uid, getClass(),
							"validarGuardarSolicitudCECCreditoSol: - obtenerParGeneral");
			ParGeneralOV diasRen = comun.obtenerParGeneralOV(uid, "DIASRENFIN");
			// (ParGeneralOV) sesionNTx.selectOne("obtenerParGeneral",
			// "DIASRENFIN");
			if (diasRen == null || diasRen.getCgValor().trim().isEmpty()) {
				throw new Exception(
						"No fue posible obtener los dias de Renovacion de par_general.");
			}

			final java.util.HashMap<String, Object> paramDias = new HashMap<String, Object>();
			paramDias.put("contratoAnt", contrato);
			paramDias.put("dias", diasRen.getCgValor());
			LogHandler
					.trace(uid, getClass(),
							"==> validarContratoRenovacionFinanciada - obtFecDatAntConfirmar");
			ContratoOV contratoAnt = (ContratoOV) sesionNTx.selectOne(
					"obtFecDatAntConfirmar", paramDias);

			if (contratoAnt == null) {
				throw new Exception(
						"No se pudo recuperar informacion del contrato anterior para la validacion de los"
								+ "dias de renovacion financiada.");
			}

			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
					"dd/MM/yyyy");
			if (fechaContable.getFecha().after(contratoAnt.getFechaMaxima())
					|| fechaContable.equals(contratoAnt.getFechaMaxima())) {
				throw new Exception(
						"La renovación debio ser capturada/guardada antes de: "
								+ simpleDateFormat.format(contratoAnt
										.getFechaMaxima()));
			}

		} catch (Exception e) {
			LogHandler.error(
					uid,
					getClass(),
					"Error en validarContratoRenovacionFinanciada: "
							+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * Generar Tarea Excepcion.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the excepcion garantia peticion
	 * @param sesionExterna
	 *            sesion externa de BD
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta generarTareaExcepcionGarantiaTarea(
			String uid, ExcepcionGarantiaPeticion peticion,
			SqlSession sesionExterna) {

		ExcepcionGarantiaRespuesta respuesta = new ExcepcionGarantiaRespuesta();

		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionTx = null;

		try {

			if (sesionExterna == null) {
				sesionTx = FabricaConexiones.obtenerSesionTx();
			} else {
				sesionTx = sesionExterna;
			}

			if (peticion == null) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}

			final java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();

			// buzon_tareas
			parametros.put("tipoTarea", peticion.getTipoTarea());
			parametros.put("sucursal", new Integer(peticion.getSucursal()));
			parametros.put("descripcion", peticion.getDescripcion());
			parametros.put("usuarioAlta", peticion.getUsuarioAlta());
			parametros.put("perfil", peticion.getPerfil());
			parametros.put("status", peticion.getStatus());
			parametros.put("idTareaPadre", peticion.getIdTareaPadre());

			Integer insertBT = (Integer) sesionTx.insert(
					"insertaBuzonTareaExcepcionGarantia", parametros);
			LogHandler.info(uid, getClass(),
					"generarTareaExcepcionGarantiaTarea insertBT: " + insertBT);
			// insertaTareaExcepcionGarantia
			// parametros.put("idTarea" , idTarea);
			parametros.put("solicitud", peticion.getDescripcion());
			parametros.put("justificacion", peticion.getJustificacion());
			sesionTx.insert("insertaTareaExcepcionGarantia", parametros);

			// Atomo ATOMO_EXCEPCION_GARANTIA
			AtomosOV peticionAtomo = new AtomosOV();
			peticionAtomo.setSolicitud(peticion.getDescripcion());
			peticionAtomo.setProceso(Constantes.ATOMO_EXCEPCION_GARANTIA);
			peticionAtomo
					.setCodigoResolucion(Constantes.ATOMO_EXCEPCION_GARANTIA_INICIO);
			peticionAtomo.setComentario("");
			peticionAtomo.setStatus("A");
			peticionAtomo.setUsuarioGeneroAtomo(peticion.getUsuarioAlta());
			AtomosRespuesta atomosRespuesta = registrarAtomosTarea(uid,
					sesionTx, peticionAtomo);

			if (!atomosRespuesta.getHeader().isEstatus()) {
				throw new Exception("ATOMO_EXCEPCION_GARANTIA:"
						+ atomosRespuesta.getHeader().getMensaje());
			}

			if (sesionExterna == null) {
				sesionTx.commit();
			}

		} catch (Exception e) {
			if (sesionExterna == null) {
				FabricaConexiones.rollBack(sesionTx);
			}

			LogHandler
					.error(uid,
							getClass(),
							"Error en generarTareaExcepcionGarantia: "
									+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			if (sesionExterna == null) {
				FabricaConexiones.close(sesionTx);
			}
		}
		return respuesta;
	}

	/**
	 * Obtener Tarea Excepcion.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the excepcion garantia peticion
	 * @return the the excepcion garantia respuesta
	 */
	@SuppressWarnings("unchecked")
	public ExcepcionGarantiaRespuesta obtenerBuzonExcepcionGarantiaTarea(
			String uid, ExcepcionGarantiaPeticion peticion) {
		ExcepcionGarantiaRespuesta respuesta = new ExcepcionGarantiaRespuesta();
		List<BuzonExcepcionOV> exBuzonList = null;
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;

		try {

			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			if (peticion == null) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}
			if (peticion.getClavePuesto() == null
					|| peticion.getClavePuesto().trim().isEmpty()) {
				throw new Exception("La clave de puesto es obligatoria.");
			}

			// Divisional y Subdirector Comercial
			if (peticion.getClavePuesto().equals(Constantes.PUESTO_DIVISIONAL)
					|| peticion.getClavePuesto().equals(
							Constantes.PUESTO_SUBCOMERCIAL)
					|| Constantes.PUESTO_RIESGOS.indexOf(peticion
							.getClavePuesto()) >= 0) {

				final java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();
				parametros.put("division", peticion.getIdDivision());

				if (Constantes.PUESTO_RIESGOS
						.indexOf(peticion.getClavePuesto()) >= 0) {
					parametros.put("region", peticion.getIdRegion());
				}

				exBuzonList = sesionNTx.selectList("obtenerBuzonExAsigPorDiv",
						parametros);
			}

			// se agrega la parte de las excepciones por monto o cupo LRSS
			// ORIG-276
			if (peticion.getClavePuesto().equals(Constantes.PUESTO_REGIONAL)
					|| peticion.getClavePuesto().equals(
							Constantes.PUESTO_DIVISIONAL)
					|| Constantes.PUESTO_RIESGOS.indexOf(peticion
							.getClavePuesto()) >= 0) {

				if (peticion.getIdRegion() < 0
						&& peticion.getClavePuesto().equals(
								Constantes.PUESTO_REGIONAL)) {
					throw new Exception("La clave de la región es obligatorio.");
				}

				if (peticion.getIdDivision() < 0
						&& peticion.getClavePuesto().equals(
								Constantes.PUESTO_DIVISIONAL)) {
					throw new Exception(
							"La clave de la división es obligatorio.");
				}

				final java.util.HashMap<String, Object> parametros1 = new java.util.HashMap<String, Object>();

				if (peticion.getClavePuesto()
						.equals(Constantes.PUESTO_REGIONAL)
						&& peticion.getIdRegion() > 0) {
					parametros1.put("region", peticion.getIdRegion());
				}

				if (peticion.getClavePuesto().equals(
						Constantes.PUESTO_DIVISIONAL)
						&& peticion.getIdDivision() > 0) {
					parametros1.put("division", peticion.getIdDivision());
				}

				if (Constantes.PUESTO_RIESGOS
						.indexOf(peticion.getClavePuesto()) >= 0) {
					parametros1.put("riesgos", "1");
					if (peticion.getIdDivision() > 0) {
						parametros1.put("region", peticion.getIdRegion());
					}

				}

				List<BuzonExcepcionOV> exBuzonExcepCampaniaList = sesionNTx
						.selectList("obtenerBuzonExcepcionesCampania",
								parametros1);

				if (exBuzonList == null) {
					exBuzonList = new ArrayList<BuzonExcepcionOV>();
				}

				if (exBuzonExcepCampaniaList.size() > 0) {
					for (BuzonExcepcionOV buzon : exBuzonExcepCampaniaList) {
						exBuzonList.add(buzon);
					}
				}
			}

			respuesta.setListaExcepciones(exBuzonList);

		} catch (Exception e) {
			LogHandler.error(
					uid,
					getClass(),
					"Error en obtenerBuzonExcepcionGarantiaTarea: "
							+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * Obtener Tarea Excepcion por idTarea.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the excepcion garantia peticion
	 * @return the the excepcion garantia respuesta
	 */
	@SuppressWarnings("unchecked")
	public ExcepcionGarantiaRespuesta obtenerBuzonExcepcionGarantiaPorIdTareaTarea(
			String uid, ExcepcionGarantiaPeticion peticion) {
		ExcepcionGarantiaRespuesta respuesta = new ExcepcionGarantiaRespuesta();

		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionNTx = null;

		try {

			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if (peticion == null) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}

			final java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();

			// buzon_tareas
			parametros.put("idTarea", peticion.getIdTarea());

			List<BuzonExcepcionOV> exBuzonList = sesionNTx.selectList(
					"obtenerBuzonExPorIdTarea", parametros);
			respuesta.setListaExcepciones(exBuzonList);

		} catch (Exception e) {
			LogHandler.error(uid, getClass(),
					"Error en obtenerBuzonExcepcionGarantiaPorIdTareaTarea: "
							+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * Obtener Tarea Excepcion por idTarea.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the excepcion garantia peticion
	 * @return the the excepcion garantia respuesta
	 */
	@SuppressWarnings("unchecked")
	public BuzonOV obtenerBuzonExPorTipoTareaTarea(String uid,
			ExcepcionGarantiaPeticion peticion) {
		BuzonOV respuesta = new BuzonOV();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);

		SqlSession sesionNTx = null;

		try {

			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if (peticion == null) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}

			final java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();

			// buzon_tareas
			parametros.put("tipoTarea", peticion.getTipoTarea());
			parametros
					.put("sucursal", Integer.parseInt(peticion.getSucursal()));

			List<TareaOV> exBuzonList = sesionNTx.selectList(
					"obtenerBuzonTareasExPorTipoTareaNuevo", parametros);
			respuesta.setBuzon(exBuzonList);

		} catch (Exception e) {

			LogHandler.error(
					uid,
					getClass(),
					"Error en obtenerBuzonExPorTipoTareaTarea: "
							+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * Obtener Complemento Tarea Excepcion.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the excepcion garantia peticion
	 * @return the the excepcion garantia respuesta
	 */
	@SuppressWarnings("unchecked")
	public ExcepcionGarantiaRespuesta obtenerComplementoBuzonExcepcionGarantiaTarea(
			String uid, ExcepcionGarantiaPeticion peticion) {
		ExcepcionGarantiaRespuesta respuesta = new ExcepcionGarantiaRespuesta();

		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionNTx = null;

		try {

			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if (peticion == null) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}

			final java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();

			// buzon_tareas
			parametros.put("division", peticion.getIdDivision());
			parametros.put("complemento", peticion.getComplemento());
			List<BuzonExcepcionOV> exBuzonList = sesionNTx.selectList(
					"obtenerBuzonExAsigOtrasDiv", parametros);
			respuesta.setListaExcepciones(exBuzonList);

		} catch (Exception e) {

			LogHandler.error(
					uid,
					getClass(),
					"Error en obtenerBuzonExcepcionGarantiaTarea: "
							+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * Obtener Complemento Tarea Excepcion.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the excepcion garantia peticion
	 * @return the the excepcion garantia respuesta
	 */
	@SuppressWarnings("unchecked")
	public ExcepcionGarantiaRespuesta obtenerExcepcionNombreDivisionalTarea(
			String uid, ExcepcionGarantiaPeticion peticion) {
		ExcepcionGarantiaRespuesta respuesta = new ExcepcionGarantiaRespuesta();

		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionNTx = null;

		try {

			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if (peticion == null) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}

			final java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();

			// buzon_tareas
			parametros.put("solicitud", peticion.getSolicitud());

			List<BuzonExcepcionOV> exBuzonList = sesionNTx.selectList(
					"obtenerExcepcionNombreDivisional", parametros);

			respuesta.setListaExcepciones(exBuzonList);

		} catch (Exception e) {

			LogHandler.error(
					uid,
					getClass(),
					"Error en obtenerExcepcionNombreDivisionalTarea: "
							+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * Autoriza Tarea Excepcion.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the excepcion garantia peticion
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta autorizaBuzonExcepcionTarea(String uid,
			ExcepcionGarantiaPeticion peticion) {
		ExcepcionGarantiaRespuesta respuesta = new ExcepcionGarantiaRespuesta();

		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionTx = null;

		try {

			sesionTx = FabricaConexiones.obtenerSesionTx();

			if (peticion == null) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}

			final java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();

			// buzon_tareas
			parametros.put("idTarea", peticion.getIdTarea());
			parametros.put("usuarioAut", peticion.getUsuarioAut());
			parametros.put("observaciones", peticion.getObservaciones());

			// generar buzon_tareas
			parametros.put("tipoTarea", peticion.getTipoTarea());
			parametros.put("sucursal", new Integer(peticion.getSucursal()));
			parametros.put("descripcion", peticion.getDescripcion());
			parametros.put("usuarioAlta", peticion.getUsuarioAlta());
			parametros.put("perfil", peticion.getPerfil());
			parametros.put("status", peticion.getStatus());
			parametros.put("idTareaPadre", peticion.getIdTarea());

			int registrosAfectadosTar = sesionTx.update(
					"autorizaBuzonExcepcionTareasExGar", parametros);

			if (registrosAfectadosTar == 0) {
				throw new Exception(ERROR_ACTUALIZACION);
			}

			int registrosAfectadosBuz = sesionTx.update(
					"autorizaBuzonExcepcion", parametros);

			if (registrosAfectadosBuz == 0) {
				throw new Exception(ERROR_ACTUALIZACION);
			}

			Integer insertBT = (Integer) sesionTx.insert(
					"insertaBuzonTareaExcepcionGarantia", parametros);

			if (insertBT == 0) {
				throw new Exception(ERROR_ACTUALIZACION);
			}

			// Atomo ATOMO_EXCEPCION_GARANTIA
			AtomosOV peticionAtomo = new AtomosOV();
			peticionAtomo.setSolicitud(peticion.getDescripcion());
			peticionAtomo.setProceso(Constantes.ATOMO_EXCEPCION_GARANTIA);
			peticionAtomo
					.setCodigoResolucion(Constantes.ATOMO_EXCEPCION_GARANTIA_OK);
			peticionAtomo.setComentario("");
			peticionAtomo.setStatus("A");
			peticionAtomo.setUsuarioGeneroAtomo(peticion.getUsuarioAlta());

			AtomosRespuesta atomosRespuesta = registrarAtomosTarea(uid,
					sesionTx, peticionAtomo);

			if (!atomosRespuesta.getHeader().isEstatus()) {
				throw new Exception("ATOMO_EXCEPCION_GARANTIA:"
						+ atomosRespuesta.getHeader().getMensaje());
			}

			sesionTx.commit();

			// Si es express no aplica.

			if (peticion.getExpress() == null) {
				peticion.setExpress("");
			}

			if (!peticion.getExpress().trim().equals("S")) {
				// Asignacion
				LogHandler.trace(uid, getClass(),
						"autorizaBuzonExcepcionTarea: - obtenerParGeneral: "
								+ "VARIABLE WEB SERVICE ASIGNACION");
				String urlWSAsignacion = comun.obtenerParGeneral(uid,
						"WS_ASIGNAC");

				LogHandler
						.info(uid, getClass(),
								"Se intenta obtener una instancia del WS de Asignacion");
				AsignacionServiceServiceLocator servicioAsignacion = new AsignacionServiceServiceLocator();
				servicioAsignacion
						.setAsignacionServicePortEndpointAddress(urlWSAsignacion);
				respuestaAsignacion = servicioAsignacion
						.getAsignacionServicePort()
						.registraSolicitudAsignacion(
								peticion.getDescripcion().trim());

				if (!respuestaAsignacion.isEstatus()) {
					throw new Exception(
							"Ocurrio un error en registraSolicitudAsignacion, se envía a la url "
									+ urlWSAsignacion + " : "
									+ respuestaAsignacion.getMensaje());
				}
				// Fin Asignacion
			}
		} catch (Exception e) {

			FabricaConexiones.rollBack(sesionTx);

			LogHandler.error(uid, getClass(),
					"Error en autorizaBuzonExcepcionTarea: " + e.getMessage(),
					e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionTx);
		}
		return respuesta;

	}

	/**
	 * Rechaza Tarea Excepcion.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the excepcion garantia peticion
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta rechazaBuzonExcepcionTarea(String uid,
			ExcepcionGarantiaPeticion peticion) {
		ExcepcionGarantiaRespuesta respuesta = new ExcepcionGarantiaRespuesta();

		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionTx = null;

		try {

			sesionTx = FabricaConexiones.obtenerSesionTx();

			if (peticion == null) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}

			final java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();

			// buzon_tareas
			parametros.put("idTarea", peticion.getIdTarea());
			parametros.put("usuarioAut", peticion.getUsuarioAut());
			parametros.put("observaciones", peticion.getObservaciones());

			// generar buzon_tareas
			parametros.put("tipoTarea", peticion.getTipoTarea());
			parametros.put("sucursal", new Integer(peticion.getSucursal()));
			parametros.put("descripcion", peticion.getDescripcion());
			parametros.put("usuarioAlta", peticion.getUsuarioAlta());
			parametros.put("perfil", peticion.getPerfil());
			parametros.put("status", peticion.getStatus());
			parametros.put("idTareaPadre", peticion.getIdTarea());

			int registrosAfectadosTar = sesionTx.update(
					"rechazaBuzonExcepcionTareasExGar", parametros);

			if (registrosAfectadosTar == 0) {
				throw new Exception(ERROR_ACTUALIZACION);
			}

			int registrosAfectadosBuz = sesionTx.update(
					"rechazaBuzonExcepcion", parametros);

			if (registrosAfectadosBuz == 0) {
				throw new Exception(ERROR_ACTUALIZACION);
			}

			Integer insertBT = (Integer) sesionTx.insert(
					"insertaBuzonTareaExcepcionGarantia", parametros);

			if (insertBT == 0) {
				throw new Exception(ERROR_ACTUALIZACION);
			}

			// Quitamos el HOLD de la solicitud
			sesionTx.update("actualizarEtapaFalseSolicitud",
					peticion.getDescripcion());

			// Atomo ATOMO_EXCEPCION_GARANTIA
			AtomosOV peticionAtomo = new AtomosOV();
			peticionAtomo.setSolicitud(peticion.getDescripcion());
			peticionAtomo.setProceso(Constantes.ATOMO_EXCEPCION_GARANTIA);
			peticionAtomo
					.setCodigoResolucion(Constantes.ATOMO_EXCEPCION_GARANTIA_RECHAZO);
			peticionAtomo.setComentario("");
			peticionAtomo.setStatus("A");
			peticionAtomo.setUsuarioGeneroAtomo(peticion.getUsuarioAlta());

			AtomosRespuesta atomosRespuesta = registrarAtomosTarea(uid,
					sesionTx, peticionAtomo);

			if (!atomosRespuesta.getHeader().isEstatus()) {
				throw new Exception("ATOMO_EXCEPCION_GARANTIA:"
						+ atomosRespuesta.getHeader().getMensaje());
			}

			sesionTx.commit();

		} catch (Exception e) {

			FabricaConexiones.rollBack(sesionTx);

			LogHandler
					.error(uid,
							getClass(),
							"Error en rechazaBuzonExcepcionTarea: "
									+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionTx);
		}
		return respuesta;
	}

	/**
	 * Rechaza Tarea Excepcion.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the excepcion garantia peticion
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta accionEnteradoIdTareaExcepcion(
			String uid, ExcepcionGarantiaPeticion peticion) {
		ExcepcionGarantiaRespuesta respuesta = new ExcepcionGarantiaRespuesta();

		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionTx = null;

		try {

			sesionTx = FabricaConexiones.obtenerSesionTx();

			if (peticion == null) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}

			final java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();

			// buzon_tareas
			parametros.put("idTarea", peticion.getIdTarea());

			int registrosAfectadosTar = sesionTx.update(
					"accionEnteradoIdTareaExcepcion", parametros);

			if (registrosAfectadosTar == 0) {
				throw new Exception(ERROR_ACTUALIZACION);
			}

			sesionTx.commit();

		} catch (Exception e) {

			FabricaConexiones.rollBack(sesionTx);

			LogHandler
					.error(uid,
							getClass(),
							"Error en rechazaBuzonExcepcionTarea: "
									+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionTx);
		}
		return respuesta;
	}

	/**
	 * @param peticion
	 *            peticion de solicitud
	 * @param persona
	 *            numero persona
	 * @return si es desertor
	 * @throws Exception
	 */
	public boolean esDesertor(SolicitudSACGPeticion peticion, String persona)
			throws Exception {
		boolean existe = false;
		for (SolicitudSACGIntegrante integrante : peticion
				.getSolicitudSACGIntegrantes()) {
			if (integrante.getDesertor() == null) {
				integrante.setDesertor("N");
			}
			if (integrante.getDesertor().equals("S")
					&& integrante.getCodigoPocg().trim().equals(persona)) {
				throw new Exception(
						"La mesa directiva o domicilio reunion no puede ser desertores.");

			}
		}
		return existe;
	}

	/**
	 * Obtener Historico Planilla Observacion.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the historico planilla observacion peticion
	 * @return the the historico planilla observacion respuesta
	 */
	@SuppressWarnings("unchecked")
	public HistoricoPlanillaObservRespuesta obtenerHistoricoPlanillaObservTarea(
			String uid, HistoricoPlanillaObservPeticion peticion) {
		HistoricoPlanillaObservRespuesta respuesta = new HistoricoPlanillaObservRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);

		SqlSession sesionNTx = null;

		try {

			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if (peticion == null) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}

			final java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();

			parametros.put("solicitud", peticion.getIdSolicitud());

			List<HistoricoPlanillaObservOV> listaHistoricoPlanObserv = sesionNTx
					.selectList("obtenerHistoricoPlanillaObserv", parametros);

			int idAtomoAux = 0;
			int idAtomo = 0;
			boolean bandera = true;
			int agrupamiento = 1;

			for (Iterator iterator = listaHistoricoPlanObserv.iterator(); iterator
					.hasNext();) {
				HistoricoPlanillaObservOV historicoPlanillaObservOV = (HistoricoPlanillaObservOV) iterator
						.next();

				if (bandera) {
					idAtomo = historicoPlanillaObservOV.getIdAtomo().intValue();
					historicoPlanillaObservOV.setAgrupamiento(agrupamiento);
					bandera = false;
				} else {
					idAtomoAux = historicoPlanillaObservOV.getIdAtomo()
							.intValue();
					if (idAtomo == idAtomoAux) {
						historicoPlanillaObservOV.setAgrupamiento(agrupamiento);
					} else {
						agrupamiento++;
						historicoPlanillaObservOV.setAgrupamiento(agrupamiento);
					}
					idAtomo = idAtomoAux;
				}
			}

			respuesta.setListaHistoricoPlanObserv(listaHistoricoPlanObserv);

		} catch (Exception e) {

			LogHandler.error(
					uid,
					getClass(),
					"Error en obtenerHistoricoPlanillaObservTarea: "
							+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * Guardar solicitud planilla aprobacion.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the peticion
	 * @param sesionExterna
	 *            the SqlSession
	 * @return the solicitudes respuesta
	 */
	public SolicitudPlanillaAprobacionRespuesta guardarSolicitudPlanillaAprobacion(
			String uid, SolicitudPlanillaAprobacionPeticion peticion,
			SqlSession sesionExterna) {
		SolicitudPlanillaAprobacionRespuesta respuesta = new SolicitudPlanillaAprobacionRespuesta();

		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		// SqlSession sesionNTx = null;
		SqlSession sesionTx = null;

		try {

			// sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if (sesionExterna == null) {
				sesionTx = FabricaConexiones.obtenerSesionTx();
			} else {
				sesionTx = sesionExterna;
			}

			if (peticion == null || peticion.getSolicitud() == null
					|| peticion.getSolicitud().isEmpty()) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}

			if (peticion.getIdAtomo() <= 0 || peticion.getIdAtomo() == null) {
				throw new Exception("El id del atomo es incorrecto");
			}

			PlanillaAprobacionPeticionDTO peticionConsulta = new PlanillaAprobacionPeticionDTO();

			peticionConsulta.setSolicitud(peticion.getSolicitud().trim());

			// obtenemos la consulta planilla aprobacion
			PlanillaAprobacionRespuestaDTO consulta = consultarPlanillaAprobacionTarea(
					uid, peticionConsulta, sesionTx);

			if (!consulta.getHeader().isEstatus()) {
				throw new Exception(consulta.getHeader().getMensaje());
			}

			// Validamos si la solicitud sigue activa
			if (consulta.getCabecera().getStatus().trim().equals("X")) {
				throw new Exception(
						"La operación no puede ser realizada, la solicitud ya fue cancelada.");
			}

			final java.lang.String respuestaJSON = transformador
					.transformaObjetoAJSON(uid, consulta);
			LogHandler.info(uid, getClass(),
					"guardarSolicitudPlanillaAprobacion - Datos de salida :"
							+ respuestaJSON);

			// Parametros para el insert
			final java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();
			parametros.put("solicitud", consulta.getCabecera().getSolicitud());
			parametros.put("producto", consulta.getCabecera()
					.getCodigoProducto());
			parametros.put("sucursal",
					Integer.parseInt(consulta.getCabecera().getSucursal()));
			parametros.put("plazo", consulta.getCabecera().getPlazo());
			parametros
					.put("frecuencia", consulta.getCabecera().getFrecuencia());

			parametros.put("montoSolicitado", consulta.getCabecera()
					.getMontoSolicitado());
			parametros.put("tasa", consulta.getCabecera().getTasa());
			parametros.put("ciclo", consulta.getCabecera().getCiclo());
			parametros
					.put("campana", consulta.getCabecera().getCodigoCampana());
			parametros.put("nivelRestriccion", consulta.getCabecera()
					.getNivelRestriccion());

			parametros.put("tipificacionSucursal", consulta.getCabecera()
					.getTipoSucursal());
			parametros.put("resultadoVerificacionTel", consulta.getCabecera()
					.getVerificacionTelefonica());
			parametros.put("resultadoBuroCredito", consulta.getCabecera()
					.getVerificacionBuroCredito());
			parametros.put("usuarioBuroCredito", "Automatico");
			if (respuestaJSON.length() <= MAXIMO_VARCHAR) {
				parametros.put("jsonPlanilla", respuestaJSON);
			} else {
				parametros.put("jsonPlanilla",
						respuestaJSON.substring(0, MAXIMO_VARCHAR));
			}

			parametros.put("idAtomo",
					peticion.getIdAtomo() != null ? peticion.getIdAtomo() : "");
			parametros.put("estatus", consulta.getCabecera().getStatus());

			LogHandler
					.info(uid, getClass(),
							"guardarSolicitudPlanillaAprobacion - insertaSolicitudPlanillaAprobacion:");
			LogHandler
					.trace(uid, getClass(),
							"guardarSolicitudPlanillaAprobacion - insertaSolicitudPlanillaAprobacion:");

			for (String string : parametros.keySet()) {
				LogHandler.info(uid, getClass(),
						string + " -- " + parametros.get(string));
			}

			sesionTx.insert("insertaSolicitudPlanillaAprobacion", parametros);
			int vueltas = respuestaJSON.length() / MAXIMO_VARCHAR;
			int modulo = respuestaJSON.length() % MAXIMO_VARCHAR;

			if (modulo == 0) {
				vueltas = vueltas - 1;
			}
			LogHandler.info(uid, getClass(), "VUELTAS" + vueltas);
			Integer idPlanilla = (Integer) sesionTx.selectOne(
					"obtenerIdSolicitudPlanillaAprobacion", consulta
							.getCabecera().getSolicitud());

			parametros.put("idPlanilla", idPlanilla);

			for (int i = 1; i <= vueltas; i++) {
				if (i == vueltas) {
					parametros.put("jsonPlanilla",
							respuestaJSON.substring(MAXIMO_VARCHAR * i));
				} else {
					parametros.put("jsonPlanilla", respuestaJSON.substring(
							MAXIMO_VARCHAR * i, MAXIMO_VARCHAR * (i + 1)));
				}
				sesionTx.update("updateSolicitudPlanillaAprobacion", parametros);
			}

			RespuestaAlmacenarPlanillaAprobacion almacenaPlanilla = almacenarPlanillaAprobacionIntegrantesTarea(
					uid, consulta.getIntegrantes(), consulta.getCabecera(),
					sesionTx);

			if (!almacenaPlanilla.getHeader().isEstatus()) {
				throw new Exception(almacenaPlanilla.getHeader().getMensaje());
			}

			respuesta.getHeader().setMensaje(
					"Solicitud Planilla Aprobación guardada");

			if (sesionExterna == null) {
				sesionTx.commit();
			}

		} catch (Exception e) {

			if (sesionExterna == null) {
				FabricaConexiones.rollBack(sesionTx);
			}
			LogHandler.error(
					uid,
					getClass(),
					"Error en guardarSolicitudPlanillaAprobacion: "
							+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			if (sesionExterna == null) {
				FabricaConexiones.close(sesionTx);
			}
		}
		return respuesta;
	}

	/**
	 * @param uid
	 *            :
	 * @param peticion
	 *            Solicitud
	 * @param sesionTx
	 * @return PlanillaAprobacionRespuestaDTO
	 */
	@SuppressWarnings("unchecked")
	public PlanillaAprobacionRespuestaDTO consultarPlanillaAprobacionTarea(
			String uid, PlanillaAprobacionPeticionDTO peticion,
			SqlSession sesion) {
		PlanillaAprobacionRespuestaDTO respuesta = new PlanillaAprobacionRespuestaDTO();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		SqlSession sesionTx = null;
		boolean sesionExterna = false;

		try {

			if (sesion == null) {
				sesionTx = FabricaConexiones.obtenerSesionTx();
			} else {
				sesionTx = sesion;
				sesionExterna = true;
			}

			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if (peticion.getPlanillaJson()) {

				if (peticion.getIdPlanilla() == null
						|| peticion.getIdPlanilla() <= 0) {
					throw new Exception(
							"El id de la planilla es obligatorio para la consulta.");
				}

				// Se agrega consulta para la cabecera
				LogHandler
						.trace(uid, getClass(),
								"consultarPlanillaAprobacionTarea: - obtenerJsonPlanillaAprobacion");
				LogHandler
						.info(uid, getClass(),
								"consultarPlanillaAprobacionTarea: - obtenerJsonPlanillaAprobacion");
				SolicitudPlanillaAprobacionOV datosPlanilla = (SolicitudPlanillaAprobacionOV) sesionNTx
						.selectOne("obtenerJsonPlanillaAprobacion",
								peticion.getIdPlanilla());

				if (datosPlanilla == null) {
					throw new Exception(
							"La consulta no pudo ser realizada para obtener los datos de la solicitud.");
				}
				if (datosPlanilla.getJsonPlanilla() == null
						|| datosPlanilla.getJsonPlanilla().isEmpty()) {
					throw new Exception(
							"La consulta no contiene el json de la planilla.");
				}

				respuesta.setJsonPlanilla(datosPlanilla.getJsonPlanilla());

			} else {
				LogHandler
						.trace(uid, getClass(),
								"consultarPlanillaAprobacionTarea: - obtenerParGeneral");
				ParGeneralOV urlBuro = comun.obtenerParGeneralOV(uid,
						"BURO_UBURO");
				// (ParGeneralOV) sesionNTx.selectOne("obtenerParGeneral",
				// "BURO_UBURO");

				LogHandler
						.trace(uid, getClass(),
								"consultarPlanillaAprobacionTarea: - obtenerParGeneral");
				ParGeneralOV urlResumen = comun.obtenerParGeneralOV(uid,
						"BURO_URESU");
				// (ParGeneralOV) sesionNTx.selectOne("obtenerParGeneral",
				// "BURO_URESU");

				LogHandler
						.trace(uid, getClass(),
								"consultarPlanillaAprobacionTarea: - obtenerParGeneral");
				ParGeneralOV urlEdoCuenta = comun.obtenerParGeneralOV(uid,
						"BURO_UEDOC");
				// (ParGeneralOV) sesionNTx.selectOne("obtenerParGeneral",
				// "BURO_UEDOC");

				if (urlBuro == null || urlBuro.getCgValor().trim().isEmpty()
						|| urlResumen == null
						|| urlResumen.getCgValor().trim().isEmpty()
						|| urlEdoCuenta == null
						|| urlEdoCuenta.getCgValor().trim().isEmpty()) {
					throw new Exception(
							"No fue posible obtener los parametros para la planilla de aprobacion.");
				}
				LogHandler.info(
						uid,
						getClass(),
						"consultarPlanillaAprobacionTarea:"
								+ "peticion.getSolicitud()"
								+ peticion.getSolicitud());
				LogHandler
						.trace(uid, getClass(),
								"consultarPlanillaAprobacionTarea: - obtenerDatosPlanillaAprobacion");
				LogHandler
						.info(uid, getClass(),
								"consultarPlanillaAprobacionTarea: - obtenerDatosPlanillaAprobacion");
				List<IntegrantePlanillaAprobacionDTO> integrantes = (List<IntegrantePlanillaAprobacionDTO>) sesionTx
						.selectList("obtenerDatosPlanillaAprobacionModuloCEC",
								peticion.getSolicitud());

				if (integrantes == null) {
					throw new Exception(
							"La consulta para los datos de cabecera no pudo ser realizada.");
				}

				// Se agrega consulta para la cabecera
				LogHandler
						.trace(uid, getClass(),
								"consultarPlanillaAprobacionTarea: - obtenerDatosCabeceraPlanillaAprobacion");
				LogHandler
						.info(uid, getClass(),
								"consultarPlanillaAprobacionTarea: - obtenerDatosCabeceraPlanillaAprobacion");
				CabeceraPlanillaAprobacionOV datosCabecera = (CabeceraPlanillaAprobacionOV) sesionTx
						.selectOne("obtenerDatosCabeceraPlanillaAprobacion",
								peticion.getSolicitud());

				if (datosCabecera == null) {
					throw new Exception("La consulta no pudo ser realizada.");
				}

				String mensajeException = (String) sesionTx.selectOne(
						"obtenerMensajExcepcion", peticion.getSolicitud());

				if (mensajeException != null
						&& !mensajeException.trim().isEmpty()) {
					datosCabecera.setVerificacionBuroCredito(mensajeException);
				}

				datosCabecera.setSolicitud(datosCabecera.getSolicitud().trim());
				datosCabecera.setUsuarioCec("Automático");

				respuesta.setCabecera(datosCabecera);

				for (IntegrantePlanillaAprobacionDTO integrante : integrantes) {
					integrante.setsESuperavitCuotaMonto(integrante
							.getsEMontoDeclarado()
							/ integrante.getsECuotaSemanal());
					integrante.setsESuperavitCuotaDisponible(integrante
							.getsEDisponibleCalculado()
							/ integrante.getsECuotaSemanal());
					integrante.setdICiclo(integrante.getdICiclo() + 1);
					integrante.setdILinkBuroCredito(urlBuro.getCgValor()
							+ integrante.getPersona());
					integrante.setdILinkResumenBuros(urlResumen.getCgValor()
							+ integrante.getPersona());
					integrante.setsETipoDomicilio(integrante
							.getsETipoDomicilio().toUpperCase());

					Date fechaContable = (Date) sesionNTx
							.selectOne("consultaPrGetFecha");

					final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
					parametros.put("fechaContable", fechaContable);
					parametros.put("integrante", integrante.getPersona());
					LogHandler
							.trace(uid, getClass(),
									"consultarPlanillaAprobacionTarea: - obtenerCreditosPorPersona");
					List<IntegranteCreditoPlanillaAprobacionDTO> creditos = (List<IntegranteCreditoPlanillaAprobacionDTO>) sesionNTx
							.selectList("obtenerCreditosPorPersona", parametros);

					boolean contratoAnterior = true;
					boolean ultimo = true;
					boolean penultimo = true;
					boolean antepenultimo = true;
					for (IntegranteCreditoPlanillaAprobacionDTO credito : creditos) {
						if (contratoAnterior
								&& !credito.getProducto().trim().equals("GOS1")) {
							integrante.setdIContratoAnterior(credito
									.getContratoLD());
							integrante.setdIEstatusContratoAnterior(credito
									.getEstatusCredito());
							integrante.setdIProductoContratoAnterior(credito
									.getProducto());
							integrante
									.setdITipificacionProducto(FuncionesComunes.tipificacionProductos(
											integrante
													.getdIProductoContratoAnterior(),
											credito.getMontoFinanciado() > 0 ? true
													: false, false));
							contratoAnterior = false;
							integrante.setdIMontoContratoAnterior(credito
									.getMontoOtorgado());
							integrante.setdILinkEstadoCuenta(urlEdoCuenta
									.getCgValor() + credito.getContratoLD());
						}

						if (ultimo) {
							integrante.setaFmontoUltimoCredito(credito
									.getMontoOtorgado());
							integrante.setaFmaximoAtrasoUltimoCredito(credito
									.getMaximoRetraso() != null ? credito
									.getMaximoRetraso() : 0);
							integrante
									.setaFmaximoAtrasoPosteriorUltimoCredito(credito
											.getDiasFechaFin() != null ? credito
											.getDiasFechaFin() : 0);
							ultimo = false;
						} else if (penultimo) {
							integrante.setaFmontoPenultimoCredito(credito
									.getMontoOtorgado());
							integrante
									.setaFmaximoAtrasoPenultimoCredito(credito
											.getMaximoRetraso() != null ? credito
											.getMaximoRetraso() : 0);
							integrante
									.setaFmaximoAtrasoPosteriorPenultimoCredito(credito
											.getDiasFechaFin() != null ? credito
											.getDiasFechaFin() : 0);
							penultimo = false;
						} else if (antepenultimo) {
							integrante.setaFmontoAntepenultimoCredito(credito
									.getMontoOtorgado());
							integrante
									.setaFmaximoAtrasoAntepenultimoCredito(credito
											.getMaximoRetraso() != null ? credito
											.getMaximoRetraso() : 0);
							integrante
									.setaFmaximoAtrasoPosteriorAntepenultimoCredito(credito
											.getDiasFechaFin() != null ? credito
											.getDiasFechaFin() : 0);
							antepenultimo = false;
						}
					}

					integrante.setdILinkEstadoCuenta(integrante
							.getdILinkEstadoCuenta() == null ? "" : integrante
							.getdILinkEstadoCuenta());
					integrante.setdIContratoAnterior(integrante
							.getdIContratoAnterior() == null ? "" : integrante
							.getdIContratoAnterior());
					integrante.setdIEstatusContratoAnterior(integrante
							.getdIEstatusContratoAnterior() == null ? ""
							: integrante.getdIEstatusContratoAnterior());
					integrante.setdIProductoContratoAnterior(integrante
							.getdIProductoContratoAnterior() == null ? ""
							: integrante.getdIProductoContratoAnterior());
					integrante.setdITipificacionProducto(integrante
							.getdITipificacionProducto() == null ? ""
							: integrante.getdITipificacionProducto());

					// Redondeos
					integrante.setsESuperavitCuotaMonto(redondear(integrante
							.getsESuperavitCuotaMonto()));
					integrante
							.setsESuperavitCuotaDisponible(redondear(integrante
									.getsESuperavitCuotaDisponible()));
					integrante.setsECuotaSemanal(redondear(integrante
							.getsECuotaSemanal()));
					integrante.setsEPorcentajeGanancia(redondear(integrante
							.getsEPorcentajeGanancia()));

					// Obtenemos Incremeto Propuesto

					if (creditos.size() != 0) {
						PeticionReglaIncremento peticionIncremento = new PeticionReglaIncremento();
						peticionIncremento.setNumeroPersona(integrante
								.getPersona());
						peticionIncremento.setNumeroContrato(integrante
								.getdIContratoAnterior());
						RespuestaReglaIncremento respuestaIncremento = calculaIncrementoMontoTarea(
								uid, peticionIncremento);
						if (respuestaIncremento.isOtorgaCredito()) {
							integrante
									.setdIMontoPropuesto(integrante
											.getdIMontoContratoAnterior()
											* ((respuestaIncremento
													.getPorcentajeIncremento() / 100.0) + 1));
						} else {
							integrante.setdIMontoPropuesto(0.0);
						}
					} else {
						integrante.setdIMontoPropuesto(0.0);
					}

					LogHandler.info(uid, getClass(),
							"consultarPlanillaAprobacionTarea:" + "BURO");

					BuroCreditoPlanillaAprobacionPeticion peticionBuro = new BuroCreditoPlanillaAprobacionPeticion();
					peticionBuro.setPersona(integrante.getPersona());
					BuroCreditoPlanillaAprobacionRespuesta respuestaBuro = planilla
							.obtenerDatosPlanillaAprobacion(uid, peticionBuro);

					if (respuestaBuro.getHeader().isEstatus()) {
						integrante.setaSFVigencia("");
						integrante.setaSFSaldoDeudaVigente(respuestaBuro
								.getSaldoActual());
						integrante.setaSFSaldoDeudaVencido(respuestaBuro
								.getSaldoVencido());
						integrante.setaSFCuotaSemanal(respuestaBuro
								.getCuotaSemanal());
						integrante.setaSFMopMaximoAbierto(respuestaBuro
								.getMopMaximoAbierto() + "");
						integrante.setaSFMopMaximoCerrado(respuestaBuro
								.getMopMaximoCerrado() + "");
						integrante.setaSFMopAutomotrizHipotecario(respuestaBuro
								.getMopAutoHipo() + "");
						integrante
								.setaSFSaldoVenciodotrizHipotecario(respuestaBuro
										.getSaldoAutoHipo() + "");

						integrante.setAsFFolioConsulta(respuestaBuro
								.getFolioConsulta());

						integrante.setClavesObservacion(respuestaBuro
								.getClavesObserv());

					} else {
						throw new Exception(respuestaBuro.getHeader()
								.getMensaje());
					}
				}
				Collections.sort(integrantes);

				/*
				 * private double sECuotaSemanal; private String
				 * sETipoDomicilio; private int sETiempoResidencia; private
				 * String sEDestinoCredito; private String sEActividadPrimaria;
				 * private int sEAntiguedadNegocio; private int
				 * sEAntiguedadRubro; private String sETipoNegocio; private
				 * double sEPorcentajeGanancia; private double
				 * sEGananciaSemanalNegocio; private double sEOtrosIngresos;
				 * private double sEGananciaActividadSecundaria; private double
				 * sETotalGastosFamiliares; private double
				 * sEDisponibleCalculado; private double sEMontoDeclarado;
				 * private double sESuperavitCuotaMonto; private double
				 * sESuperavitCuotaDisponible; private double
				 * sETotalDeclaradoNegocio;
				 */
				// Agregar Totales

				if (peticion.isTotales()) {
					IntegrantePlanillaAprobacionDTO totales = new IntegrantePlanillaAprobacionDTO();
					totales.setPersona("");
					totales.setClaveClienteUnico("");
					totales.setdINombreCliente("");
					totales.setdIEdad(0);
					totales.setdIEstadoCivil("");
					totales.setdIContratoAnterior("");
					totales.setdIMontoSolicitado(0);
					totales.setdIMontoPropuesto(0);
					totales.setaFmontoUltimoCredito(0);
					totales.setaFmontoPenultimoCredito(0);
					totales.setaFmontoAntepenultimoCredito(0);
					totales.setaSFSaldoDeudaVigente(0);
					totales.setaSFSaldoDeudaVencido(0);
					totales.setaSFCuotaSemanal(0);

					totales.setsECuotaSemanal(0);
					totales.setsEGananciaSemanalNegocio(0);
					totales.setsEOtrosIngresos(0);
					totales.setsEGananciaActividadSecundaria(0);
					totales.setsETotalGastosFamiliares(0);
					totales.setsEDisponibleCalculado(0);
					totales.setsEMontoDeclarado(0);
					totales.setsESuperavitCuotaMonto(0);
					totales.setsESuperavitCuotaDisponible(0);
					totales.setsETotalDeclaradoNegocio(0);

					for (int i = 0; i < integrantes.size(); i++) {
						totales.setdIMontoSolicitado(totales
								.getdIMontoSolicitado()
								+ integrantes.get(i).getdIMontoSolicitado());
						totales.setaFmontoUltimoCredito(totales
								.getaFmontoUltimoCredito()
								+ integrantes.get(i).getaFmontoUltimoCredito());
						totales.setaFmontoPenultimoCredito(totales
								.getaFmontoPenultimoCredito()
								+ integrantes.get(i)
										.getaFmontoPenultimoCredito());
						totales.setaFmontoAntepenultimoCredito(totales
								.getaFmontoAntepenultimoCredito()
								+ integrantes.get(i)
										.getaFmontoAntepenultimoCredito());
						totales.setaSFSaldoDeudaVigente(totales
								.getaSFSaldoDeudaVigente()
								+ integrantes.get(i).getaSFSaldoDeudaVigente());
						totales.setaSFSaldoDeudaVencido(totales
								.getaSFSaldoDeudaVencido()
								+ integrantes.get(i).getaSFSaldoDeudaVencido());
						totales.setaSFCuotaSemanal(totales.getaSFCuotaSemanal()
								+ integrantes.get(i).getaSFCuotaSemanal());

						totales.setsECuotaSemanal(totales.getsECuotaSemanal()
								+ integrantes.get(i).getsECuotaSemanal());
						totales.setsEGananciaSemanalNegocio(totales
								.getsEGananciaSemanalNegocio()
								+ integrantes.get(i)
										.getsEGananciaSemanalNegocio());
						totales.setsEOtrosIngresos(totales.getsEOtrosIngresos()
								+ integrantes.get(i).getsEOtrosIngresos());
						totales.setsEGananciaActividadSecundaria(totales
								.getsEGananciaActividadSecundaria()
								+ integrantes.get(i)
										.getsEGananciaActividadSecundaria());
						totales.setsETotalGastosFamiliares(totales
								.getsETotalGastosFamiliares()
								+ integrantes.get(i)
										.getsETotalGastosFamiliares());
						totales.setsEDisponibleCalculado(totales
								.getsEDisponibleCalculado()
								+ integrantes.get(i).getsEDisponibleCalculado());
						totales.setsEMontoDeclarado(totales
								.getsEMontoDeclarado()
								+ integrantes.get(i).getsEMontoDeclarado());
						totales.setsESuperavitCuotaMonto(totales
								.getsESuperavitCuotaMonto()
								+ integrantes.get(i).getsESuperavitCuotaMonto());
						totales.setsESuperavitCuotaDisponible(totales
								.getsESuperavitCuotaDisponible()
								+ integrantes.get(i)
										.getsESuperavitCuotaDisponible());
						totales.setsETotalDeclaradoNegocio(totales
								.getsETotalDeclaradoNegocio()
								+ integrantes.get(i)
										.getsETotalDeclaradoNegocio());

						totales.setdIMontoPropuesto(integrantes.get(i)
								.getdIMontoPropuesto());
					}
					integrantes.add(totales);

				}

				respuesta.setIntegrantes(integrantes);
			}
			if (!sesionExterna) {
				sesionTx.commit(true);
			}
		}

		catch (Exception ex) {
			if (!sesionExterna) {
				FabricaConexiones.rollBack(sesionTx);
			}
			LogHandler.error(uid, getClass(),
					"consultarPlanillaAprobacionTarea: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
			if (!sesionExterna) {
				FabricaConexiones.close(sesionTx);
			}
		}
		return respuesta;
	}

	/**
	 * Obtener Integrantes Planilla Aprobacion.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the integrantes planilla aprobacion peticion
	 * @return the the historico integrantes aprobacion respuesta
	 */
	@SuppressWarnings("unchecked")
	public PlanillaAprobacionRespuesta obtenerIntegrantesEdoCtaYBuro(
			String uid, PlanillaAprobacionPeticion peticion) {
		PlanillaAprobacionRespuesta respuesta = new PlanillaAprobacionRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);

		SqlSession sesionNTx = null;

		try {

			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if (peticion == null) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}

			final java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();

			parametros.put("solicitud", peticion.getIdSolicitud());

			String ligaEdoCuenta = comun.obtenerParGeneral(uid, "BURO_UEDOC");

			String ligaBuro = comun.obtenerParGeneral(uid, "BURO_FBURO");

			List<IntegrantePlanillaAprobOV> listaIntegrantesPlanAprob = sesionNTx
					.selectList("obtenerIntegrantesEdoCtaYBuro", parametros);

			for (Iterator iterator = listaIntegrantesPlanAprob.iterator(); iterator
					.hasNext();) {
				IntegrantePlanillaAprobOV integranteOV = (IntegrantePlanillaAprobOV) iterator
						.next();

				if (integranteOV.getFolioBuro().startsWith("0009")) {
					integranteOV.setLigaBuroFolio(ligaBuro
							+ integranteOV.getFolioBuro().substring(4, 13));
				} else {
					integranteOV.setLigaBuroFolio(ligaBuro
							+ integranteOV.getFolioBuro());
				}

				if (integranteOV.getContrato() == null
						|| integranteOV.getContrato().equals(" ")
						|| integranteOV.getContrato().equals("")
						|| integranteOV.getContrato().isEmpty()) {

					integranteOV.setLigaEdoCtaCto("NL");

				} else {
					integranteOV.setLigaEdoCtaCto(ligaEdoCuenta
							+ integranteOV.getContrato());
				}
			}

			respuesta.setListaIntegrantesPlanAprob(listaIntegrantesPlanAprob);

			if (listaIntegrantesPlanAprob.size() <= 0) {
				respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensaje(
						"La consulta no regresó datos de integrantes");
			}

		} catch (Exception e) {

			LogHandler
					.error(uid,
							getClass(),
							"Error en obtenerIntegrantesEdoCtaYBuro: "
									+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * Consultar solicitudes planilla aprobacion almacenadas tarea.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the peticion
	 * @return the solicitudes almacenadas respuesta
	 */
	public SolicitudesAlmacenadasRespuesta consultarSolicitudesPlanillaAprobacionAlmacenadasTarea(
			String uid, SolicitudPlanillaAprobacionPeticion peticion) {
		SolicitudesAlmacenadasRespuesta respuesta = new SolicitudesAlmacenadasRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);

		SqlSession sesionNTx = null;

		try {

			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if (peticion == null) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}

			LogHandler.trace(uid, getClass(),
					"consultarSolicitudesPlanillaAprobacionAlmacenadasTarea:"
							+ "- obtenerSolicitudesPlanillaAprobacion");
			@SuppressWarnings("unchecked")
			List<SolicitudPlanillaAprobacionOV> solicitudesGeneradas = sesionNTx
					.selectList("obtenerSolicitudesPlanillaAprobacion",
							peticion.getSolicitud());

			if (solicitudesGeneradas == null
					|| solicitudesGeneradas.size() == 0) {
				throw new Exception("La consulta no regreso datos.");
			}

			respuesta.setSolicitudesGeneradas(solicitudesGeneradas);

		} catch (Exception e) {

			LogHandler.error(uid, getClass(),
					"Error en consultarSolicitudesPlanillaAprobacionAlmacenadasTarea: "
							+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * Consultar solicitud motivo cancelacion tarea.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the peticion motivo
	 * @return the solicitudes motivo cancelacion respuesta
	 */
	public SolicitudesMotivoCancelacionRespuesta consultarSolicitudMotivoCancelacionTarea(
			String uid, SolicitudesMotivoCancelacionPeticion peticion) {
		SolicitudesMotivoCancelacionRespuesta respuesta = new SolicitudesMotivoCancelacionRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);

		SqlSession sesionNTx = null;

		try {

			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if (peticion == null || peticion.getSolicitud() == null
					|| peticion.getSolicitud().isEmpty()) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}

			LogHandler.trace(uid, getClass(),
					"consultarSolicitudMotivoCancelacionTarea:"
							+ "- obtenerSolicitudMotivoCancelacion");
			SolicitudesOV solicitud = (SolicitudesOV) sesionNTx.selectOne(
					"obtenerSolicitudMotivoCancelacion",
					peticion.getSolicitud());

			if (solicitud == null) {
				throw new Exception(
						"Error al obtener la consulta de la solicitud para obtener el motivo de cancelacion.");
			}

			respuesta.setMotivoCancelacion(solicitud.getMotivoCancelacion());

		} catch (Exception e) {

			LogHandler.error(
					uid,
					getClass(),
					"Error en consultarSolicitudMotivoCancelacionTarea: "
							+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * Consultar codigos por tipo codigo.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the peticion codigos
	 * @return the lista codigos respuesta
	 */
	public CodigosRespuesta consultarCodigosPorTipoCodigoTarea(String uid,
			CodigosPeticion peticion) {
		CodigosRespuesta respuesta = new CodigosRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);

		SqlSession sesionNTx = null;

		try {

			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if (peticion == null || peticion.getTipoCodigo() == null
					|| peticion.getTipoCodigo().isEmpty()) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}

			LogHandler.trace(uid, getClass(),
					"consultarCodigosPorTipoCodigoTarea:"
							+ "- obtenerCodigosPorTipoCodigo");

			@SuppressWarnings("unchecked")
			List<CodigoOV> listaCodigos = (ArrayList<CodigoOV>) sesionNTx
					.selectList("obtenerCodigosPorTipoCodigo",
							peticion.getTipoCodigo());

			if (listaCodigos == null || listaCodigos.size() <= 0) {
				throw new Exception(
						"Error al obtener la consulta de lista de codigos.");
			}

			respuesta.setCodigos(listaCodigos);

		} catch (Exception e) {

			LogHandler.error(
					uid,
					getClass(),
					"Error en consultarCodigosPorTipoCodigoTarea: "
							+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * Consultar total desembolso por periodo
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the peticion desembolso
	 * @return the objeto desembolso respuesta
	 */
	public TotalDesembolsoRespuesta consultarTotalDesembolsoPorPeriodo(
			String uid, TotalDesembolsoPeticion peticion) {
		TotalDesembolsoRespuesta respuesta = new TotalDesembolsoRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);

		String validaStr = "";
		SqlSession sesionNTx = null;

		try {

			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			String[] datosRequeridos = { "fechaInicial", "fechaFinal" };
			/*
			 * "division", "region", "sucursal", "producto", "estatus",
			 * "ciclo"};
			 */

			validaStr = Validaciones.datosRequeridos(peticion, datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("ciof.error.datos.requeridos")
								+ validaStr);
			}

			if (peticion == null || peticion.getFechaInicial() == null
					|| peticion.getFechaFinal() == null) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}

			LogHandler.trace(uid, getClass(),
					"consultarTotalDesembolsoPorPeriodo:"
							+ "- obtenerTotalDesembolsoPeriodo");

			TotalDesembolsoOV totalDesembolso = (TotalDesembolsoOV) sesionNTx
					.selectOne("obtenerTotalDesembolsoPeriodo", peticion);

			if (totalDesembolso == null) {
				throw new Exception(
						"Error al obtener el objeto total desembolso.");
			}

			respuesta.setTotalDesembolso(totalDesembolso);

		} catch (Exception e) {

			LogHandler.error(
					uid,
					getClass(),
					"Error en consultarTotalDesembolsoPorPeriodo: "
							+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * Consultar semaforos por persona
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the peticion semaforos
	 * @return the lista semaforos respuesta
	 */
	public SemaforoSolicitudesRespuesta consultarSemaforosPorPersona(
			String uid, SemaforoSolicitudesPeticion peticion) {
		SemaforoSolicitudesRespuesta respuesta = new SemaforoSolicitudesRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SqlSession sesionNTx = null;

		try {

			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if (peticion == null || peticion.getFechaFinal() == null
					|| peticion.getFechaInicial() == null) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}

			LogHandler.trace(uid, getClass(), "consultarSemaforosPorPersona:"
					+ "- obtenerSemaforoSolPoPersona");

			@SuppressWarnings("unchecked")
			List<SemaforoSolicitudesOV> listaSolSemaforos = (ArrayList<SemaforoSolicitudesOV>) sesionNTx
					.selectList("obtenerSemaforoSolPorPersona", peticion);

			if (listaSolSemaforos == null || listaSolSemaforos.size() <= 0) {
				throw new Exception(
						"Error al obtener la consulta de lista de semaforos.");
			}

			for (Iterator iterator = listaSolSemaforos.iterator(); iterator
					.hasNext();) {
				SemaforoSolicitudesOV semaforoSolicitudesOV = (SemaforoSolicitudesOV) iterator
						.next();

				// Se obtiene el campo estatusRevision
				if (semaforoSolicitudesOV.getFechaInicioGestion() != null
						&& !"N/A".equals(semaforoSolicitudesOV
								.getEstatusRevision().trim())
						&& semaforoSolicitudesOV.getFechaTermino() != null) {

					semaforoSolicitudesOV
							.setEstatusRevision(Minutes
									.minutesBetween(
											new LocalDateTime(
													semaforoSolicitudesOV
															.getFechaInicioGestion()
															.getTime()),
											new LocalDateTime(
													semaforoSolicitudesOV
															.getFechaTermino()
															.getTime()))
									.getMinutes()
									+ "");
				}

				if (semaforoSolicitudesOV.getFechaInicioGestion() != null
						&& semaforoSolicitudesOV.getFechaTermino() != null
						&& (semaforoSolicitudesOV.getFechaObservaciones() == null || ""
								.equals(semaforoSolicitudesOV
										.getFechaObservaciones().trim()))) {
					semaforoSolicitudesOV
							.setEstatusRevision(Minutes
									.minutesBetween(
											new LocalDateTime(
													semaforoSolicitudesOV
															.getFechaInicioGestion()
															.getTime()),
											new LocalDateTime(
													semaforoSolicitudesOV
															.getFechaTermino()
															.getTime()))
									.getMinutes()
									+ "");
				} else if (semaforoSolicitudesOV.getFechaInicioGestion() != null
						&& (semaforoSolicitudesOV.getFechaObservaciones() != null && !""
								.equals(semaforoSolicitudesOV
										.getFechaObservaciones().trim()))) {
					semaforoSolicitudesOV
							.setEstatusRevision(Minutes
									.minutesBetween(
											new LocalDateTime(
													semaforoSolicitudesOV
															.getFechaInicioGestion()
															.getTime()),
											new LocalDateTime(
													formato.parse(
															semaforoSolicitudesOV
																	.getFechaObservaciones())
															.getTime()))
									.getMinutes()
									+ "");
				} else if (semaforoSolicitudesOV.getFechaInicioGestion() != null
						&& semaforoSolicitudesOV.getFechaTermino() == null
						&& (semaforoSolicitudesOV.getFechaObservaciones() == null || ""
								.equals(semaforoSolicitudesOV
										.getFechaObservaciones().trim()))) {
					semaforoSolicitudesOV
							.setEstatusRevision(Minutes
									.minutesBetween(
											new LocalDateTime(
													semaforoSolicitudesOV
															.getFechaInicioGestion()
															.getTime()),
											new LocalDateTime()).getMinutes()
									+ "");
				} else {
					semaforoSolicitudesOV.setEstatusRevision("");
				}

				if (semaforoSolicitudesOV.getEstatusRevision() == null) {
					semaforoSolicitudesOV.setEstatusRevision("");
				}
				// Semaforos
				if (!semaforoSolicitudesOV.getEstatusRevision().equals("")) {
					int minutos = Integer.valueOf(
							semaforoSolicitudesOV.getEstatusRevision())
							.intValue();

					if (minutos <= peticion.getRangoVerde()) {
						semaforoSolicitudesOV.setSemaforo("verde");
					} else if (minutos > peticion.getRangoVerde()
							&& minutos <= peticion.getRangoAmarillo()) {
						semaforoSolicitudesOV.setSemaforo("amarillo");
					} else {
						semaforoSolicitudesOV.setSemaforo("rojo");
					}
				}
			}

			respuesta.setListaSolSemaforos(listaSolSemaforos);

		} catch (Exception e) {

			LogHandler.error(uid, getClass(),
					"Error en consultarSemaforosPorPersona: " + e.getMessage(),
					e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * Enviar una solicitud a verificacion telefonica.
	 * 
	 * @param uid
	 *            identificador unico de la transaccion
	 * @param peticion
	 *            solicitud a enviar al call center
	 * @param sesion
	 *            transaccional
	 * @return respuesta
	 */
	public ConsultaInformacionTelefonicaRespuesta enviarSolicitudVerificacionTelefonica(
			String uid, ConsultaInformacionTelefonicaPeticion peticion,
			SqlSession sesion) {
		ConsultaInformacionTelefonicaRespuesta respuesta = new ConsultaInformacionTelefonicaRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		SqlSession sesionTx = null;
		try {

			if (peticion.getUsuario() == null
					|| peticion.getUsuario().trim().isEmpty()) {
				throw new Exception("El usuario es necesario en la peticion.");
			}
			if (peticion.getSucursal() == null || peticion.getSucursal() <= 0) {
				throw new Exception("La sucursal es necesario en la peticion.");
			}
			if (peticion.getNombreGrupo() == null
					|| peticion.getNombreGrupo().trim().isEmpty()) {
				throw new Exception("El usuario es necesario en la peticion.");
			}
			respuesta = administracionTelefonica
					.consultaInformacionVerificacion(uid, peticion);

			if (!respuesta.getHeader().isEstatus()) {
				throw new Exception(respuesta.getHeader().getMensaje());
			}
			if (respuesta.getCadenaSIMACC() == null
					|| respuesta.getCadenaSIMACC().trim().isEmpty()) {
				throw new Exception("No fue posible generar la cadena SIMACC");
			}
			// CONEXION BD
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if (sesion == null) {
				sesionTx = FabricaConexiones.obtenerSesionTx();
			} else {
				sesionTx = sesion;
			}

			// Parametros
			LogHandler.trace(uid, getClass(), "obtenerParGeneral: US_VER_TEL");
			String userVT = comun.obtenerParGeneral(uid, "US_VER_TEL");

			LogHandler.trace(uid, getClass(), "obtenerParGeneral: PW_VER_TEL");
			String passwVT = comun.obtenerParGeneral(uid, "PW_VER_TEL");

			LogHandler.trace(uid, getClass(), "obtenerParGeneral: OK_VER_TEL");
			String respuestaOK = comun.obtenerParGeneral(uid, "OK_VER_TEL");

			LogHandler.trace(uid, getClass(),
					"obtenerParGeneral: WEB SERVICE VERIFICACION TELEFONICA");
			String urlWSVerTel = comun.obtenerParGeneral(uid,
					"com.mx.finsol.originacion.verificacion.telefonica.ws");

			LogHandler.info(uid, getClass(), respuesta.getCadenaSIMACC());
			// LLAMADO WS CALL CENTER
			WSRecibeDatosLocator ws = new WSRecibeDatosLocator();
			ws.setWSRecibeDatosSoapEndpointAddress(urlWSVerTel);

			String respuestaVT = ws.getWSRecibeDatosSoap().recibirDatos(userVT,
					passwVT, respuesta.getCadenaSIMACC());
			LogHandler.info(uid, getClass(), respuestaVT);
			if (respuestaVT.contains(respuestaOK)) {

				RegistraBitacoraPeticion peticionBitacora = new RegistraBitacoraPeticion();

				peticionBitacora.setIdSolicitud(peticion.getIdSolicitud());
				peticionBitacora.setUsuarioEnvioVerificacion(peticion
						.getUsuario());
				peticionBitacora.setIdSolicitudCC(respuesta.getIdSolicitudCC());
				peticionBitacora.setSucursal(peticion.getSucursal());
				peticionBitacora.setNombreGrupo(peticion.getNombreGrupo());
				peticionBitacora.setEnvioVerificacion(true);

				RegistraBitacoraRespuesta respuestaBitacora = administracionTelefonica
						.bitacoraVerificacionTelefonica(uid, peticionBitacora,
								sesionTx);

				if (!respuestaBitacora.getHeader().isEstatus()) {
					throw new Exception(
							"Ocurrio un error en bitacoraVerificacionTelefonica: "
									+ respuestaBitacora.getHeader()
											.getMensaje());
				}

				LogHandler.info(uid, getClass(),
						"enviarSolicitudCECTarea - bitacoraVerificacionTelefonica= "
								+ respuestaBitacora.getHeader().getMensaje());

			} else {
				throw new Exception(
						"Ocurrio un error en enviar a Call Center, URL ["
								+ urlWSVerTel + "] : " + respuestaVT);
			}

			if (sesion == null) {
				sesionTx.commit();
			}

		} catch (Exception e) {
			if (sesion == null) {
				FabricaConexiones.rollBack(sesionTx);
			}
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
			if (sesion == null) {
				FabricaConexiones.close(sesion);
			}
		}

		return respuesta;
	}

	/**
	 * Consultar total autorizado por periodo
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the peticion desembolso
	 * @return the objeto desembolso respuesta
	 */
	public TotalDesembolsoRespuesta consultarTotalAutorizadoPorPeriodo(
			String uid, TotalDesembolsoPeticion peticion) {
		TotalDesembolsoRespuesta respuesta = new TotalDesembolsoRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);

		String validaStr = "";
		SqlSession sesionNTx = null;

		try {

			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			String[] datosRequeridos = { "fechaInicial", "fechaFinal" };

			validaStr = Validaciones.datosRequeridos(peticion, datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(
						ReadProperties.mensajes
								.getProp("ciof.error.datos.requeridos")
								+ validaStr);
			}

			if (peticion == null || peticion.getFechaInicial() == null
					|| peticion.getFechaFinal() == null) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}

			LogHandler.trace(uid, getClass(),
					"consultarTotalDesembolsoPorPeriodo:"
							+ "- obtenerTotalDesembolsoPeriodo");

			TotalDesembolsoOV totalDesembolso = (TotalDesembolsoOV) sesionNTx
					.selectOne("obtenerTotalAutorizadoPeriodo", peticion);

			if (totalDesembolso == null) {
				throw new Exception(
						"Error al obtener el objeto total desembolso.");
			}

			respuesta.setTotalDesembolso(totalDesembolso);

		} catch (Exception e) {

			LogHandler.error(
					uid,
					getClass(),
					"Error en consultarTotalAutorizadoPorPeriodo: "
							+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * @param uid
	 *            identificador de la transaccion
	 * @param solicitudesSACGPeticion
	 *            peticion
	 * @return resultado de la validacion del dia pago y dia reunion
	 */
	@SuppressWarnings("unchecked")
	private EncabezadoRespuesta validarDiaReunionPago(String uid,
			SolicitudSACGPeticion solicitudesSACGPeticion) {
		EncabezadoRespuesta respuesta = new EncabezadoRespuesta();
		respuesta.setEstatus(true);
		respuesta.setUID(uid);
		SqlSession sesionNTx = null;

		try {

			final int varDias = Integer.parseInt(comun.obtenerParGeneralOV(uid,
					"mx.com.finsol.originacion.diareunionpago.difdias")
					.getCgValor());
			final int varDiasMaximoRetraso = Integer
					.parseInt(comun
							.obtenerParGeneralOV(uid,
									"mx.com.finsol.originacion.diareunionpago.maxretraso")
							.getCgValor());
			final String diasCreditosMorosos = comun
					.obtenerParGeneralOV(uid,
							"mx.com.finsol.originacion.diareunionpago.dias.malhistorial")
					.getCgValor();
			final String diasCreditosNuevos = comun.obtenerParGeneralOV(uid,
					"mx.com.finsol.originacion.diareunionpago.dias.nuevos")
					.getCgValor();
			// ORIG-434 Ajuste Dia Pago
			final String diasCreditosNuevosEstrellas = comun
					.obtenerParGeneralOV(uid,
							"mx.com.finsol.originacion.diareunionpago.dias.nuevos.estrellas")
					.getCgValor();
			final String estrellasPermitidas = comun
					.obtenerParGeneralOV(uid,
							"mx.com.finsol.originacion.diareunionpago.nuevos.estrellas")
					.getCgValor();
			final int numeroGruposLimite = Integer
					.parseInt(comun
							.obtenerParGeneralOV(uid,
									"mx.com.finsol.originacion.diareunionpago.nuevos.grupos")
							.getCgValor());

			if (solicitudesSACGPeticion.getSolicitudSACG().getDiaReunion()
					.intValue() == DIA_VIERNES
					&& solicitudesSACGPeticion.getSolicitudSACG().getDiaPago()
							.intValue() != DIA_VIERNES) {
				throw new Exception(
						"Si el día de reunión es VIERNES, el día de pago debe ser VIERNES.");
			}
			int diasDiferencia = solicitudesSACGPeticion.getSolicitudSACG()
					.getDiaPago().intValue()
					- solicitudesSACGPeticion.getSolicitudSACG()
							.getDiaReunion().intValue();
			LogHandler
					.info(uid, getClass(), "diasDiferencia " + diasDiferencia);

			if (diasDiferencia > varDias || diasDiferencia < 0) {
				throw new Exception(
						"El dia de reunión y el dia de pago, solo pueden tener "
								+ varDias + " día(s) de diferencia.");
			}

			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if (!(solicitudesSACGPeticion.getSolicitudSACG()
					.getContratoPrevio() == null || solicitudesSACGPeticion
					.getSolicitudSACG().getContratoPrevio().isEmpty())) {

				String contrato = comun.obtenerNumeroContrato(uid,
						solicitudesSACGPeticion.getSolicitudSACG()
								.getContratoPrevio());

				if (contrato == null || contrato.isEmpty()) {
					throw new Exception(
							"El contrato de la peticion es invalido.");
				}

				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
				final FechaContableOV fechaContable = comun
						.obtenerFechaContable(uid);

				final HashMap<String, Object> parametros = new HashMap<String, Object>();
				parametros.put("contrato", contrato);
				parametros.put("fechaContable",
						formatter.format(fechaContable.getFecha()));

				LogHandler
						.trace(uid,
								getClass(),
								"==> validarContratoRenovacionFinanciada - obtenerDatosCreditoRenovacionFinanciada");

				HashMap<String, Object> datosContrato = (HashMap<String, Object>) sesionNTx
						.selectOne("obtenerDatosCreditoRenovacionFinanciada",
								parametros);

				Integer maximoRetrasoContrato = Integer.valueOf(datosContrato
						.get("maximoRetraso").toString());

				// Si es mayor a 7 dias de atraso los dias de reunion deben ser
				// lunes, martes o miercoles
				if (maximoRetrasoContrato > varDiasMaximoRetraso) {

					String[] dias = diasCreditosMorosos.split(";");
					boolean diaCorrecto = false;
					for (int i = 0; i < dias.length; i++) {
						if (solicitudesSACGPeticion.getSolicitudSACG()
								.getDiaPago().intValue() == Integer
								.parseInt(dias[i])) {
							diaCorrecto = true;
						}
					}
					if (!diaCorrecto) {
						throw new Exception(
								"Por el historial crediticio del crédito los días de pago solo pueden ser LUNES, MARTES y MIERCOLES.");
					}
				}
			}
			// GRUPOS NUEVOS
			if (solicitudesSACGPeticion.getSolicitudSACG().getCiclo() == 0) {

				// ORIG-434 Ajuste Dia Pago
				// Validacion Estrellas
				final HashMap<String, Object> parametros = new HashMap<String, Object>();
				parametros.put("asesor", solicitudesSACGPeticion
						.getSolicitudSACG().getCdgAsesor().trim());
				Integer noEstrellas = (Integer) sesionNTx.selectOne(
						"consultarNumeroEstrellasAsesor", parametros);
				if (noEstrellas == null) {
					noEstrellas = 0;
				}
				boolean asesorEstrella = comun.encontrarNumeroCadena(
						estrellasPermitidas, ";", noEstrellas);

				if (asesorEstrella) {
					Integer noGrupos = (Integer) sesionNTx.selectOne(
							"consultarNumeroGruposAsesor", parametros);
					if (noGrupos == null) {
						noGrupos = 0;
					}
					// Caso Asesor Estrella
					if (noGrupos >= numeroGruposLimite) {
						boolean diaCorrecto = comun.encontrarNumeroCadena(
								diasCreditosNuevosEstrellas, ";",
								solicitudesSACGPeticion.getSolicitudSACG()
										.getDiaPago().intValue());
						if (!diaCorrecto) {
							throw new Exception(
									"[*] Para los créditos nuevos los días de pago solo pueden ser "
											+ "LUNES, MARTES, MIERCOLES, JUEVES y VIERNES.");
						}
					} else {
						boolean diaCorrecto = comun.encontrarNumeroCadena(
								diasCreditosNuevos, ";",
								solicitudesSACGPeticion.getSolicitudSACG()
										.getDiaPago().intValue());
						if (!diaCorrecto) {
							throw new Exception(
									"[*] Para los créditos nuevos los días de pago solo pueden ser LUNES, MARTES y MIERCOLES.");
						}
					}
				} else {
					boolean diaCorrecto = comun
							.encontrarNumeroCadena(diasCreditosNuevos, ";",
									solicitudesSACGPeticion.getSolicitudSACG()
											.getDiaPago().intValue());
					if (!diaCorrecto) {
						throw new Exception(
								"Para los créditos nuevos los días de pago solo pueden ser LUNES, MARTES y MIERCOLES.");
					}
				}
			}
		} catch (Exception e) {
			LogHandler.error(uid, getClass(),
					"Error en validarDiaReunionPago: " + e.getMessage(), e);
			respuesta.setEstatus(false);
			respuesta.setMensaje(e.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}

		return respuesta;
	}

	/**
	 * Registrar el inicio de gestion de una solicitud CEC.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the excepcion garantia peticion
	 * @return the the excepcion garantia respuesta
	 */
	@SuppressWarnings("unchecked")
	public ExcepcionGarantiaRespuesta registroInicioGestionCEC(String uid,
			ExcepcionGarantiaPeticion peticion) {
		ExcepcionGarantiaRespuesta respuesta = new ExcepcionGarantiaRespuesta();

		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionTx = null;

		try {

			sesionTx = FabricaConexiones.obtenerSesionTx();

			if (peticion == null) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}

			final java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();
			parametros.put("idTarea", peticion.getIdTarea());

			Integer registros = sesionTx.update("registroInicioGestionCEC",
					parametros);

			if (registros == 0) {
				throw new Exception(
						"No fue posible registrar el inicio de gestion.");
			}

			sesionTx.commit();
			respuesta.getHeader().setMensaje(
					"Registro inicio gestion correcto.");

		} catch (Exception e) {

			FabricaConexiones.rollBack(sesionTx);

			LogHandler.error(uid, getClass(),
					"Error en registroInicioGestionCEC: " + e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionTx);
		}
		return respuesta;
	}

	@SuppressWarnings("unchecked")
	public ContratoRenovacionRespuesta consultarContratoRenovacion(String uid,
			ContratoRenovacionPeticion peticion) {
		ContratoRenovacionRespuesta respuesta = new ContratoRenovacionRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		Date fechaValor = null;
		try {
			if (peticion.getContrato() == null
					|| peticion.getContrato().trim().isEmpty()) {
				throw new Exception(
						"El contrato es obligatorio para realizar la consulta.");
			}
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			int diasMoraPermitidos = Integer.valueOf(
					comun.obtenerParGeneralOV(uid,
							"mx.com.findep.finsol.kitrenovacion.diasmora")
							.getCgValor()).intValue();
			int diasFechaLiquidacion = Integer.valueOf(
					comun.obtenerParGeneralOV(uid,
							"mx.com.findep.finsol.kitrenovacion.semanas")
							.getCgValor()).intValue()
					* Constantes.DIAS_SEMANA;
			double montoActaInstalacion = Integer
					.valueOf(
							comun.obtenerParGeneralOV(uid,
									"mx.com.findep.finsol.kitrenovacion.comunal.montoacta")
									.getCgValor()).doubleValue();
			double montoCertificacionDom = Integer
					.valueOf(
							comun.obtenerParGeneralOV(uid,
									"mx.com.findep.finsol.kitrenovacion.solidario.montocertificacion")
									.getCgValor()).doubleValue();

			// Validar si existe el contrato
			String numeroContrato = comun.obtenerNumeroContrato(uid,
					peticion.getContrato());

			// Validaciones
			if (numeroContrato == null || numeroContrato.isEmpty()) {
				respuesta.setMostrarInformacion(false);
				throw new Exception(
						"El Número de Contrato ingresado no existe.");
			}

			FechaContableOV datosFechaContable = comun
					.obtenerFechaContable(uid);

			Date fechaCont = datosFechaContable.getFecha();
			Calendar cal = new GregorianCalendar();
			cal.setTimeInMillis(fechaCont.getTime());
			fechaValor = cal.getTime();

			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("contrato", numeroContrato);
			params.put("fechaActual", fechaValor);
			respuesta = (ContratoRenovacionRespuesta) sesionNTx.selectOne(
					"obtenerDatosContratoRenovacion", params);
			if (respuesta == null) {
				respuesta = new ContratoRenovacionRespuesta();
				respuesta.setHeader(new EncabezadoRespuesta());
				respuesta.getHeader().setUID(uid);
				respuesta.getHeader().setEstatus(true);
				throw new Exception(
						"El Número de Contrato ingresado no es parte de la cartera.");
			}
			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setEstatus(true);

			// Validacion sucursal
			if (peticion.getSucursal() != 0) {
				if (peticion.getSucursal() != respuesta.getSucursal()) {
					respuesta.setMostrarInformacion(false);
					throw new Exception(
							"El contrato ingresado no pertenece a la sucursal.");
				}
			}
			// Validacion dias mora
			if (respuesta.getDiasMora() > diasMoraPermitidos) {
				respuesta.setMostrarInformacion(true);
				throw new Exception(
						"No se puede generar los formatos porque el grupo cuenta con más de 14 días mora.");
			}

			// //Validacion de prospecto
			// if ( respuesta.getDiasFaltantesLiquidacion() >
			// diasFechaLiquidacion ) {
			// respuesta.setMostrarInformacion(true);
			// throw new
			// Exception("No se puede generar los formatos porque el grupo no cumple con la regla de renovacion "
			// + "(4 semanas o 2 catorcenas).");
			// }

			final int diasPrevios = Integer.parseInt(comun.obtenerParGeneralOV(
					uid, "mx.com.findep.finsol.kitrenovacion.solicitante.dias")
					.getCgValor());

			params.clear();
			params.put("contrato", numeroContrato);
			params.put("dias", diasPrevios);
			params.put("fechaActual", fechaValor);
			List<IntegrantesKit> integrantes = (List<IntegrantesKit>) sesionNTx
					.selectList("obtenerIntegrantesContratoRenovacion", params);
			respuesta.setIntegrantes(integrantes);
			// Agregamos lista documentos
			params.clear();
			params.put("categoria", respuesta.getCategoria());

			List<DocumentosKit> documentos = (List<DocumentosKit>) sesionNTx
					.selectList("obtenerDocumentosContratoRenovacion", params);
			respuesta.setDocumentos(documentos);

			if (respuesta.getCategoria().trim().equals("COMN")) {
				for (IntegrantesKit integrante : integrantes) {
					if (integrante.getMonto() >= montoActaInstalacion) {
						for (DocumentosKit documento : documentos) {
							if (documento.getCodigo().trim().equals("AIMD")) {
								documento.setSeleccionado(true);
								break;
							}
						}
					}
				}
			} else if (respuesta.getCategoria().trim().equals("SOLN")) {
				for (IntegrantesKit integrante : integrantes) {
					if (integrante.getMonto() >= montoCertificacionDom) {
						for (DocumentosKit documento : documentos) {
							if (documento.getCodigo().trim().equals("CDPN")) {
								documento.setSeleccionado(true);
								break;
							}
						}
					}
				}
			}
		} catch (Exception ex) {
			LogHandler.error(uid, this.getClass(),
					"consultarContratoRenovacion " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}

		return respuesta;
	}

	/**
	 * Deveulve la informacion para llenar el reporte de las solicitudes
	 * solicitud
	 * 
	 * @param uid
	 *            id de la transacci&eacute;n
	 * @param peticion
	 *            datos de entrada como el contrato.
	 * @return SimplificacionRenovacion respuesta de la peticion
	 */
	@SuppressWarnings("unchecked")
	public SimplificacionRenovacion informacionSolicitudCredito(String uid,
			ContratoRenovacionPeticion peticion) {
		LogHandler.info(uid, this.getClass(),
				"Contrato : " + peticion.getContrato() + "integrantes nuevos: "
						+ peticion.getIntegrantesNuevos() + "codigoDocumento: "
						+ peticion.getCodigoDocumento());

		SimplificacionRenovacion respuesta = new SimplificacionRenovacion();
		KitImpresionSimplificacionRenovacion kit = new KitImpresionSimplificacionRenovacion();
		ValidaIntegrantePeticion peticionIntegrante = null;
		ValidaIntegranteRespuesta respuestaIntegrante = null;
		ImpresionFormatos formatos = new ImpresionFormatos();
		int filasEnBlanco = 0;
		double montoGrupo = 0.0;
		int porcentajeMontoPreAprobadoOportunidad = 0;
		double calculoMontoPreaprobado = 0;
		double montoPreabrobadoOportunidad = 0.00;
		String montoIntegrante = "";

		// Parametros de entrada
		final Class<?>[] clases = { KitImpresionSimplificacionRenovacion.class,
				ImpresionFormatos.class, ClientesGrupo.class,
				DirectivaGrupo.class };

		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionNTx = null;
		try {
			// validamos que la peticion traiga alguno de los formatos validos
			if (!CatalogoFormatos.obtenerListaSiglas().contains(
					peticion.getCodigoDocumento())) {
				throw new Exception("El codigo del documento no existe: "
						+ peticion.getCodigoDocumento());
			}
			// validamos que venga el contrato
			if (peticion.getContrato() == null
					|| peticion.getContrato().trim().isEmpty()) {
				throw new Exception(
						"El contrato es obligatorio para realizar la consulta.");
			}

			// Validar si existe el contrato ya sea ld o contrato
			String numeroContrato = comun.obtenerNumeroContrato(uid,
					peticion.getContrato());
			LogHandler.info(uid, this.getClass(), "numero de contrato: "
					+ numeroContrato);

			// Validaciones
			if (numeroContrato == null || numeroContrato.isEmpty()) {
				throw new Exception(
						"El Número de Contrato de la petición no existe.");
			}

			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			String solicitud = (String) sesionNTx.selectOne(
					"buscaSolicitudContrato", numeroContrato);

			if (solicitud == null || solicitud.isEmpty()) {
				throw new Exception("La solicitud de la petición no existe.");
			}

			porcentajeMontoPreAprobadoOportunidad = Integer
					.valueOf(
							comun.obtenerParGeneralOV(uid,
									"mx.com.finsol.kitimpresion.formatos.porcentaje.preaprobado.oportunidad")
									.getCgValor()).intValue();
			// porcentajeMontoPreAprobadoOportunidad = 50;
			LogHandler.info(uid, this.getClass(),
					"porcentajeMontoPreAprobadoOportunidad: "
							+ porcentajeMontoPreAprobadoOportunidad);

			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("contrato", numeroContrato);

			formatos = (ImpresionFormatos) sesionNTx.selectOne(
					"obtenerDatosSolicitudDeCredito", params);
			LogHandler.info(
					uid,
					this.getClass(),
					"obtenerDatosSolicitudDeCreditoComunal: "
							+ formatos.getContrato());

			if (peticion.getCodigoDocumento().equals(
					CatalogoFormatos.COOP.getSiglas())) {
				LogHandler.info(
						uid,
						this.getClass(),
						"No se reemplazan nombres."
								+ CatalogoFormatos.COOP.getSiglas());
			} else {
				LogHandler.info(uid, this.getClass(), "Se reemplazan nombres."
						+ peticion.getCodigoDocumento());

				if (peticion.getNombreAsesor() == null
						|| peticion.getNombreAsesor().equals("")
						|| peticion.getNombreAsesor().equals("SIN ASESOR")) {
					LogHandler.info(uid, this.getClass(),
							"NombreAsesor vacio o nulo.");
					formatos.setNombreAsesorCredito("");
				} else {
					LogHandler.info(
							uid,
							this.getClass(),
							"Se cambia NombreAsesor: "
									+ formatos.getNombreAsesorCredito()
									+ ", por:  " + peticion.getNombreAsesor());
					formatos.setNombreAsesorCredito(peticion.getNombreAsesor());
				}

				if (peticion.getNombreGerenteRegional() == null
						|| peticion.getNombreGerenteRegional().equals("")
						|| peticion.getNombreGerenteRegional().equals(
								"SIN GERENTE REGIONAL")) {
					LogHandler.info(uid, this.getClass(),
							"NombreGerenteRegional vacio o nulo.");
					formatos.setNombreGerenteRegional("");
				} else {
					LogHandler.info(
							uid,
							this.getClass(),
							"Se cambia NombreGerenteRegional: "
									+ formatos.getNombreGerenteRegional()
									+ ", por:  "
									+ peticion.getNombreGerenteRegional());
					formatos.setNombreGerenteRegional(peticion
							.getNombreGerenteRegional());
				}

				if (peticion.getNombreGerenteSucursal() == null
						|| peticion.getNombreGerenteSucursal().equals("")
						|| peticion.getNombreGerenteSucursal().equals(
								"SIN GERENTE SUCURSAL")) {
					LogHandler.info(uid, this.getClass(),
							"NombreGerenteSucursal vacio o nulo.");
					formatos.setNombreGerenteSucursal("");
				} else {
					LogHandler.info(
							uid,
							this.getClass(),
							"Se cambia NombreGerenteSucursal: "
									+ formatos.getNombreGerenteSucursal()
									+ ", por:  "
									+ peticion.getNombreGerenteSucursal());
					formatos.setNombreGerenteSucursal(peticion
							.getNombreGerenteSucursal());
				}
			}

			// obtenemos la lista de integrantes
			if (peticion.getCodigoDocumento().equals(
					CatalogoFormatos.SOCO.getSiglas())) {
				List<String> listNumeros = Arrays.asList(peticion
						.getArrayPersonas());
				params.put("listaPersonas", listNumeros);
			} else {
				params.put("listaPersonas", null);
			}

			// obtenemos la lista de integrantes
			List<ClientesGrupo> integrantes = (List<ClientesGrupo>) sesionNTx
					.selectList("integrantesSolicitudDeCredito", params);
			LogHandler.info(uid, this.getClass(),
					"integrantesSolicitudDeCreditoComunal: " + integrantes);

			if (integrantes.size() == 0) {
				throw new Exception(
						"No fue posible recuperar la informacion del contrato solicitado.");
			}

			// Calculo del monto preaprobado integrante
			for (int i = 0; i < integrantes.size(); i++) {
				LogHandler.info(uid, this.getClass(),
						"integrantesSolicitudDeCreditoComunal tamaño: "
								+ integrantes.size());

				// validacion que se agrega para aumentarle el ciclo al
				// integrante del grupo
				if (!peticion.getCodigoDocumento().equals(
						CatalogoFormatos.SOCO.getSiglas())) {
					integrantes.get(i).setCicloClienteGrupo(
							integrantes.get(i).getCicloClienteGrupo() + 1);
				}

				double creditoAnterior = Double.parseDouble(integrantes.get(i)
						.getCreditoVigenteClienteGrupo());

				integrantes.get(i).setCreditoVigenteClienteGrupo(
						Validaciones.formatoMoneda(uid, creditoAnterior));
				montoGrupo = montoGrupo + creditoAnterior;

				if (peticion.getCodigoDocumento().equals(
						CatalogoFormatos.SOCC.getSiglas())
						|| peticion.getCodigoDocumento().equals(
								CatalogoFormatos.SOCS.getSiglas())) {

					peticionIntegrante = new ValidaIntegrantePeticion();
					peticionIntegrante.setPersona(integrantes.get(i)
							.getNumPersonaClienteGrupo());
					peticionIntegrante.setSolicitud(solicitud);
					respuestaIntegrante = validarSimplificacionComunalSolidario(
							uid, peticionIntegrante, sesionNTx);

					integrantes.get(i).setCreditoPreAprobadoClienteGrupo(
							Validaciones.formatoMoneda(uid,
									respuestaIntegrante.getMontoMaximo()));

				} else {
					// PeticionReglaIncremento peticionIncremento = new
					// PeticionReglaIncremento();
					// peticionIncremento.setNumeroPersona(integrantes.get(i).getNumPersonaClienteGrupo());
					// peticionIncremento.setNumeroContrato(numeroContrato);
					// RespuestaReglaIncremento respuestaIncremento =
					// calculaIncrementoMontoTarea(uid, peticionIncremento);
					//
					// if ( respuestaIncremento.isOtorgaCredito() ) {
					// double creditoPreaprobado = creditoAnterior
					// * ((respuestaIncremento.getPorcentajeIncremento() /
					// Constantes.CENTENA_DOUBLE) + 1);
					//
					// integrantes.get(i).setCreditoPreAprobadoClienteGrupo(Validaciones.formatoMoneda(uid,
					// creditoPreaprobado ));
					// } else {
					// integrantes.get(i).setCreditoPreAprobadoClienteGrupo("0.00");
					// }
					montoIntegrante = integrantes.get(i)
							.getCreditoVigenteClienteGrupo();
					LogHandler.info(uid, this.getClass(), "montoIntegrante: "
							+ montoIntegrante);
					montoIntegrante = montoIntegrante.replaceAll(",", "");
					LogHandler.info(uid, this.getClass(),
							"montoIntegrante replace ,: " + montoIntegrante);
					montoPreabrobadoOportunidad = Double
							.parseDouble(montoIntegrante);
					LogHandler.info(uid, this.getClass(),
							"montoPreabrobadoOportunidad: "
									+ montoPreabrobadoOportunidad);
					calculoMontoPreaprobado = montoPreabrobadoOportunidad
							* porcentajeMontoPreAprobadoOportunidad
							/ PORCENTAJE_MONTO_PREAPROBADO;
					LogHandler.info(uid, this.getClass(),
							"calculoMontoPreaprobado: "
									+ calculoMontoPreaprobado);
					integrantes.get(i).setCreditoPreAprobadoClienteGrupo(
							Validaciones.formatoMoneda(uid,
									calculoMontoPreaprobado));
					LogHandler
							.info(uid,
									this.getClass(),
									"getCreditoPreAprobadoClienteGrupo: "
											+ integrantes
													.get(i)
													.getCreditoPreAprobadoClienteGrupo());
				}

			}

			// rellenar las filas en blanco de acuerdo al tipo de producto
			if (integrantes.size() > 0) {
				if (peticion.getCodigoDocumento().equals(
						CatalogoFormatos.AIMD.getSiglas())
						|| peticion.getCodigoDocumento().equals(
								CatalogoFormatos.CDPN.getSiglas())) {
					filasEnBlanco = peticion.getIntegrantesNuevos();
				} else if (peticion.getCodigoDocumento().equals(
						CatalogoFormatos.COOP.getSiglas())) {
					filasEnBlanco = 0;
				} else {
					int moduloIntegrante = (integrantes.size() + peticion
							.getIntegrantesNuevos()) % Constantes.DIEZ;
					// validacion para las filas en blanco
					if (moduloIntegrante == 0) {
						filasEnBlanco = peticion.getIntegrantesNuevos();
					} else {
						filasEnBlanco = peticion.getIntegrantesNuevos()
								+ (Constantes.DIEZ - moduloIntegrante);
					}
				}

				for (int i = 0; i < filasEnBlanco; i++) {
					ClientesGrupo clientesGrupo = new ClientesGrupo();
					clientesGrupo.setCreditoVigenteClienteGrupo(" ");
					clientesGrupo.setCreditoPreAprobadoClienteGrupo(" ");
					integrantes.add(clientesGrupo);
				}
				// agregamos el numero de cliente del grupo
				for (int i = 0; i < integrantes.size(); i++) {
					integrantes.get(i).setNumeroClienteGrupo(i + 1);
					LogHandler.info(uid, this.getClass(), i
							+ " numeroIntegrante: "
							+ integrantes.get(i).getNumeroClienteGrupo());
				}
			}
			// validacion de si es un AIMD(ACTA DE INSTALACION DE LA MESA
			// DIRECTIVA Y REGLAMENTO INTERNO)
			List<ClientesGrupo> clientesA = new ArrayList<ClientesGrupo>();
			List<ClientesGrupo> clientesB = new ArrayList<ClientesGrupo>();

			if (peticion.getCodigoDocumento().equals(
					CatalogoFormatos.AIMD.getSiglas())) {
				int size = integrantes.size() % 2;
				if (size != 0) {
					ClientesGrupo clientesGrupo = new ClientesGrupo();
					clientesGrupo.setCreditoVigenteClienteGrupo(" ");
					clientesGrupo.setCreditoPreAprobadoClienteGrupo(" ");
					clientesGrupo.setNumeroClienteGrupo(integrantes.size() + 1);
					integrantes.add(clientesGrupo);
				}
				for (int i = 0; i < integrantes.size(); i++) {
					if (integrantes.get(i).getNumeroClienteGrupo() % 2 == 0) {
						clientesB.add(integrantes.get(i));
					} else {
						clientesA.add(integrantes.get(i));
					}
				}
			}
			LogHandler.info(uid, this.getClass(),
					"tamaño de la listaA : " + clientesA.size()
							+ "tamaño de la lista B: " + clientesB.size());

			// se agrega a los integrantes y a la tasa
			if (formatos != null) {
				if (peticion.getCodigoDocumento().equals(
						CatalogoFormatos.AIMD.getSiglas())) {
					formatos.setClientesA(clientesA);
					formatos.setClientesB(clientesB);
				} else {
					formatos.setClientesA(integrantes);
				}
				formatos.setTasaInteresAnual((float) obtenerTasaIncrementoContrato(
						uid, numeroContrato, peticion.getCodigoDocumento()));
				formatos.setFechaFin(Validaciones.convertirStringFecha(uid,
						formatos.getFechaFin(), false));
				formatos.setMontoGrupalAprobado(Validaciones.formatoMoneda(uid,
						montoGrupo));
				formatos.setFechaImpresion(Validaciones.convertirStringFecha(
						uid, null, true));
			}

			// validacio para COOP(Comformidad de Oportunidad)
			if (peticion.getCodigoDocumento().equals(
					CatalogoFormatos.COOP.getSiglas())) {
				List<DirectivaGrupo> directiva = new ArrayList<DirectivaGrupo>();
				List<String> integrantEliminar = new ArrayList<String>();
				for (int i = 0; i < integrantes.size(); i++) {
					DirectivaGrupo directivaGrupo = new DirectivaGrupo();
					if (integrantes.get(i).getRolIntegrante()
							.equals(Constantes.PRES)
							|| integrantes.get(i).getRolIntegrante()
									.equals(Constantes.SUPE)) {
						formatos.setNombrePresidentaCoordinador(integrantes
								.get(i).getNombreClienteGrupo());
						directivaGrupo.setNombreDirectivaGrupo(integrantes.get(
								i).getNombreClienteGrupo());
						directivaGrupo.setPuestoDirectivaGrupo(integrantes.get(
								i).getRolIntegrante());
						integrantEliminar.add(integrantes.get(i)
								.getNumPersonaClienteGrupo());
						directiva.add(directivaGrupo);
					} else if (integrantes.get(i).getRolIntegrante()
							.equals(Constantes.SECR)) {
						formatos.setNombreSecretaria(integrantes.get(i)
								.getNombreClienteGrupo());
						directivaGrupo.setNombreDirectivaGrupo(integrantes.get(
								i).getNombreClienteGrupo());
						directivaGrupo.setPuestoDirectivaGrupo(integrantes.get(
								i).getRolIntegrante());
						integrantEliminar.add(integrantes.get(i)
								.getNumPersonaClienteGrupo());
						directiva.add(directivaGrupo);
					} else if (integrantes.get(i).getRolIntegrante()
							.equals(Constantes.TESO)) {
						formatos.setNombreTesorera(integrantes.get(i)
								.getNombreClienteGrupo());
						directivaGrupo.setNombreDirectivaGrupo(integrantes.get(
								i).getNombreClienteGrupo());
						directivaGrupo.setPuestoDirectivaGrupo(integrantes.get(
								i).getRolIntegrante());
						integrantEliminar.add(integrantes.get(i)
								.getNumPersonaClienteGrupo());
						directiva.add(directivaGrupo);
					}
				}
				formatos.setDirectiva(directiva);
				// quitar de integrantes los de la mesa directiva ya estan la
				// lista directiva
				for (String persona : integrantEliminar) {
					Validaciones.eliminarIntegrantes(uid, integrantes, persona);
				}
			}

			// se le agrega un 1 al grupo dependiendo del tipo de documento
			LogHandler.info(uid, this.getClass(),
					"ciclo actual: " + formatos.getCiclo());
			if (peticion.getCodigoDocumento().equals(
					CatalogoFormatos.CDPN.getSiglas())
					|| peticion.getCodigoDocumento().equals(
							CatalogoFormatos.SOCS.getSiglas())
					|| peticion.getCodigoDocumento().equals(
							CatalogoFormatos.SOCC.getSiglas())) {
				formatos.setCiclo(formatos.getCiclo() + 1);
				LogHandler.info(uid, this.getClass(), "ciclo nuevo: "
						+ formatos.getCiclo());
			}

			if (peticion.getCodigoDocumento().equals(
					CatalogoFormatos.SOCO.getSiglas())) {
				formatos.setPlazo(0);
				formatos.setTasaInteresAnual(0);
			}

			kit.setImpresionFormatos(formatos);
			respuesta.setKitImpresionSimplificacionRenovacion(kit);

			// convertir el kit de impresiones a un xml
			String xml = transformador.transformaObjetoAXML(uid, kit, clases);
			// cambiar los tag que contienen mayusculas
			if (xml != null && xml.contains("impresionFormatos")
					&& xml.contains("ClientesGrupo")) {
				xml = xml
						.replace("impresionFormatos", "ImpresionFormatos")
						.replace("ClientesGrupo", "clienteGrupo")
						.replace("DirectivaGrupo", "directivaGrupo")
						.replace("nombredirectivaGrupo", "nombreDirectivaGrupo")
						.replace("puestodirectivaGrupo", "puestoDirectivaGrupo");
			}
			respuesta.setSolicitudXml(xml);
			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setEstatus(true);
			LogHandler.info(uid, this.getClass(), "xml : " + xml);

		} catch (Exception ex) {
			LogHandler
					.error(uid,
							this.getClass(),
							"informacionSolicitudCreditoComunal "
									+ ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}

		return respuesta;
	}

	/**
	 * Metodo para obtener la nueva tasa de un contrato por incremento
	 * 
	 * @param uid
	 *            identificado unico de la transaccion
	 * @param contrato
	 *            a calcula la nueva tasa
	 * @param codigoDocumento
	 *            categorial del producto como (SOCO)
	 * @return la tasa con incremento
	 * @throws Exception
	 */
	public double obtenerTasaIncrementoContrato(String uid, String contrato,
			String codigoDocumento) throws Exception {
		double tasaNueva = 0;
		SqlSession sesionNTx = FabricaConexiones.obtenerSesionNTx();
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("contrato", contrato);

		ParGeneralOV tasaProductos = comun.obtenerParGeneralOV(uid,
				"TASA_MAXIMA_PRODUCTOS");
		double tasaMaxima = Double.parseDouble(tasaProductos.getCgValor());

		ImpresionFormatos formatos = (ImpresionFormatos) sesionNTx.selectOne(
				"obtenerDatosTasaIncremento", params);

		LogHandler.info(uid, this.getClass(),
				"Tasa anual: " + formatos.getTasaInteresAnual());

		// validacion para el tipo de contrato oportunidad no se le hace el
		// incremento a la tasa
		if (codigoDocumento.equals(CatalogoFormatos.SOCO.getSiglas())) {
			tasaNueva = formatos.getTasaInteresAnual();
		} else {

			ObtenerTasasOV tasasIncremento = obtenerTasaInteresIncremento(uid,
					true, false, formatos.getMaximoAtraso(),
					formatos.getCiclo());
			if (tasasIncremento == null) {
				throw new Exception(
						"No se obtubo informacion de tasas incremento");
			}

			LogHandler.info(uid, this.getClass(), "incremento ->"
					+ tasasIncremento.getIncremento());
			tasaNueva = formatos.getTasaInteresAnual()
					+ tasasIncremento.getIncremento().doubleValue();
			LogHandler.info(uid, this.getClass(), "tasa nueva ->"
					+ tasasIncremento.getIncremento());
		}

		if (tasaNueva > tasaMaxima) {
			tasaNueva = tasaMaxima;
		}
		return tasaNueva;
	}

	/**
	 * Metodo para regresar una lista de clientes y la información de su último
	 * contrato
	 * 
	 * @param uid
	 *            String
	 * @param acreditadosPeticion
	 *            AcreditadosPeticion
	 * @return respuesta tipo PersonasCreditoRespuesta
	 */
	@SuppressWarnings("unchecked")
	public PersonasCreditoRespuesta informacionPersonasCredito(String uid,
			PersonasCreditoPeticion acreditadosPeticion) {
		PersonasCreditoRespuesta personasCreditoRespuesta = new PersonasCreditoRespuesta();
		personasCreditoRespuesta.setHeader(new EncabezadoRespuesta());
		personasCreditoRespuesta.getHeader().setUID(uid);
		personasCreditoRespuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		List<PersonasCredito> personasList = null;
		String validaStr = "";
		try {

			if (acreditadosPeticion.getPersona() != null) {

				String numeroPersona = comun.obtenerPersonaCliente(uid,
						acreditadosPeticion.getPersona());
				sesionNTx = FabricaConexiones.obtenerSesionNTx();
				if (numeroPersona.trim().isEmpty()) {
					throw new Exception(
							"El Número de Persona ingresado no existe");
				}
				String bloqueo = (String) sesionNTx.selectOne(
						"consultarBloqueoPersona", numeroPersona);
				if (bloqueo == null) {
					bloqueo = "";
				}
				if (!bloqueo.trim().isEmpty()) {
					throw new Exception(
							"El número de persona ingresado está bloqueado. "
									+ "Verifique la información con el área de Operaciones");
				}

				java.util.HashMap<String, Object> peticionParametros = new java.util.HashMap<String, Object>();
				LogHandler
						.trace(uid, getClass(),
								"informacionPersonasCredito: - consultaPersonasCredito");
				LogHandler
						.info(uid, getClass(),
								"informacionPersonasCredito: - consultaPersonasCredito");
				peticionParametros.put("numeroPersona", numeroPersona);
				personasList = sesionNTx.selectList("consultaPersonasCredito",
						peticionParametros);
				if (personasList.isEmpty()) {
					throw new Exception(CLIENTE_INEXISTENTE);
				}
				personasCreditoRespuesta.setPersonas(personasList);
			} else {
				if ((acreditadosPeticion.getFechaNacimiento() == null || acreditadosPeticion
						.getFechaNacimiento().equals(""))
						&& (acreditadosPeticion.getpNombre() == null || acreditadosPeticion
								.getpNombre().equals(""))
						&& (acreditadosPeticion.getpAPaterno() == null || acreditadosPeticion
								.getpAPaterno().equals(""))
						&& (acreditadosPeticion.getpAMaterno() == null || acreditadosPeticion
								.getpAMaterno().equals(""))) {

					if (!Validaciones.rfcValido(acreditadosPeticion.getRfc())) {
						throw new Exception(RFC_INVALIDO);
					} else {
						acreditadosPeticion.setRfc(acreditadosPeticion.getRfc()
								.toUpperCase());
					}
				} else {
					String[] datosRequeridos = { "pNombre", "pAPaterno",
							"fechaNacimiento" };
					validaStr = Validaciones.datosRequeridos(
							acreditadosPeticion, datosRequeridos);
					if (!validaStr.equalsIgnoreCase("")) {
						throw new Exception(DATOS_REQUERIDOS + validaStr);
					}
				}
				java.util.HashMap<String, Object> peticionParametros = new java.util.HashMap<String, Object>();
				peticionParametros = Funciones
						.objectToHashMapUpdate(acreditadosPeticion);
				// Se abre la sesion No transaccional sybase
				sesionNTx = FabricaConexiones.obtenerSesionNTx();
				LogHandler
						.trace(uid, getClass(),
								"informacionPersonasCredito: - consultaPersonasCredito");
				LogHandler
						.info(uid, getClass(),
								"informacionPersonasCredito: - consultaPersonasCredito");
				personasList = sesionNTx.selectList("consultaPersonasCredito",
						peticionParametros);
				if (personasList.isEmpty()) {
					throw new Exception(CLIENTE_INEXISTENTE);
				}
				personasCreditoRespuesta.setPersonas(personasList);
			}
		} catch (Exception ex) {
			LogHandler.error(uid, getClass(),
					"informacionPersonasCreditoTarea: " + ex.getMessage(), ex);
			personasCreditoRespuesta.getHeader().setEstatus(false);
			personasCreditoRespuesta.getHeader().setMensaje(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return personasCreditoRespuesta;
	}

	/**
	 * Devuele la lista de documentos en blanco a imprimir
	 * 
	 * @param peticion
	 *            no lleva nada po el momento
	 * @param uid
	 *            identificador unico
	 * @return lista documentos
	 */
	@SuppressWarnings("unchecked")
	public ContratoRenovacionRespuesta obtenerDocumentosBlancos(String uid,
			ContratoRenovacionPeticion peticion) {
		ContratoRenovacionRespuesta respuesta = new ContratoRenovacionRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;

		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.clear();
			params.put("categoria", peticion.getCategoria());
			List<DocumentosKit> documentos = (List<DocumentosKit>) sesionNTx
					.selectList("obtenerDocumentosContratoRenovacion", params);
			respuesta.setDocumentos(documentos);
		} catch (Exception ex) {
			LogHandler.error(uid, this.getClass(),
					"consultarContratoRenovacion " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}

		return respuesta;
	}

	/**
	 * Metodo para registrar una solicitud de la pantalla Analista Documental BC
	 * 
	 * @param uid
	 *            Identificador unico
	 * @param solicitudPeticion
	 *            solicitudPeticion
	 * @return SolicitudExcepcionDocumentalRespuesta
	 */
	public SolicitudExcepcionDocumentalRespuesta registrarSolicitudAnalistaBCTarea(
			String uid, SolicitudExcepcionDocumental solicitudPeticion) {

		SolicitudExcepcionDocumentalRespuesta solicitudRespuesta = new SolicitudExcepcionDocumentalRespuesta();
		solicitudRespuesta.setHeader(new EncabezadoRespuesta());
		solicitudRespuesta.getHeader().setUID(uid);
		solicitudRespuesta.getHeader().setEstatus(true);
		SqlSession sesionTx = null;
		String solicitud = "";
		long idTarea = 0;

		try {
			// Se abre la conexion hacia la base de datos
			sesionTx = FabricaConexiones.obtenerSesionTx();

			solicitud = solicitudPeticion.getSolicitud();
			idTarea = solicitudPeticion.getIdTarea();

			if (solicitud == null || idTarea == 0) {
				throw new Exception(DATOS_INCORRECTOS);
			}

			java.util.HashMap<String, Object> solicitudParametros = new java.util.HashMap<String, Object>();

			solicitudParametros = Funciones
					.objectToHashMapUpdate(solicitudPeticion);
			LogHandler.info(uid, getClass(),
					"registrarSolicitudAnalistaBC: - solicitudParametros: + "
							+ solicitudParametros + " +");

			LogHandler
					.info(uid, getClass(),
							"registrarSolicitudAnalistaBC: - actualizaSolicitudAnalistaBC");
			int registrosAfectados = sesionTx.update(
					"actualizaSolicitudAnalistaBC", solicitudParametros);
			LogHandler.info(uid, getClass(),
					"registrarSolicitudAnalistaBC: - registrosAfectados: "
							+ registrosAfectados);

			// Update a solicitudes Finsol
			final java.util.HashMap<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("idTarea", idTarea);

			if (solicitudPeticion.getMotivoExcepcion() != null) {
				if (solicitudPeticion.getMotivoExcepcion().equals("")) {
					parameters.put("status", "P");
				} else {
					parameters.put("status", "A");
				}
			}

			int registroBuzonTareas = sesionTx.update(
					"actualizaSolicitudBuzonTareas", parameters);
			LogHandler.info(uid, getClass(),
					"registrarSolicitudAnalistaBC: - registroBuzonTareas: "
							+ registroBuzonTareas);

			if (registrosAfectados == 0 || registroBuzonTareas == 0) {
				throw new Exception(ERROR_ACTUALIZACION);
			}

			if (solicitudPeticion.getAccion() != null) {
				if (solicitudPeticion.getAccion().equals("APROBADA")) {

					// Registrar Solicitud Minima
					AtomosOV peticionAtomo = new AtomosOV();
					peticionAtomo.setSolicitud(solicitud);
					peticionAtomo.setProceso("VALIDACION_BC");
					peticionAtomo.setComentario("");
					peticionAtomo.setStatus("A");
					peticionAtomo.setCodigoResolucion("APROBADA");
					peticionAtomo.setUsuarioGeneroAtomo(solicitudPeticion
							.getUsuarioGestion());

					AtomosRespuesta atomosRespuesta = registrarAtomosTarea(uid,
							sesionTx, peticionAtomo);

					if (!atomosRespuesta.getHeader().isEstatus()) {
						throw new Exception(atomosRespuesta.getHeader()
								.getMensaje());
					}
				} else if (solicitudPeticion.getAccion().equals("EXCEPCION_BC")) {

					// Registrar Solicitud Minima
					AtomosOV peticionAtomo = new AtomosOV();
					peticionAtomo.setSolicitud(solicitud);
					peticionAtomo.setProceso("VALIDACION_BC");
					peticionAtomo.setComentario("");
					peticionAtomo.setStatus("A");
					peticionAtomo.setCodigoResolucion("EXCEP_BC");
					peticionAtomo.setUsuarioGeneroAtomo(solicitudPeticion
							.getUsuarioGestion());

					AtomosRespuesta atomosRespuesta = registrarAtomosTarea(uid,
							sesionTx, peticionAtomo);

					if (!atomosRespuesta.getHeader().isEstatus()) {
						throw new Exception(atomosRespuesta.getHeader()
								.getMensaje());
					}
				} else if (solicitudPeticion.getAccion().equals("RECHAZADA")) {
					SolicitudesRespuesta solicitudesRespuesta = new SolicitudesRespuesta();
					SolicitudesPeticion peticion = new SolicitudesPeticion();

					peticion.setSolicitudId(solicitud);
					peticion.setUsuarioId(solicitudPeticion.getUsuarioGestion());
					peticion.setMotivo("VALIDA_BC");
					peticion.setMotivoCancelacion(solicitudPeticion
							.getMotivoCancelacion());

					solicitudesRespuesta = cancelarSolicitudTarea(uid,
							sesionTx, peticion);

					if (!solicitudesRespuesta.getHeader().isEstatus()) {
						LogHandler.info(uid, getClass(),
								"registrarSolicitudAnalistaBC: ");
						throw new Exception(
								"Error al momento de eliminar la solicitud ");
					}
				}
			}

			LogHandler.info(uid, getClass(),
					"registrarSolicitudAnalistaBC: -> ");
			sesionTx.commit(true);
			solicitudRespuesta.setId(solicitud);
			solicitudRespuesta.getHeader().setMensaje(
					"Se actualizó correctamente la solicitud");
		} catch (Exception ex) {
			FabricaConexiones.rollBack(sesionTx);
			LogHandler.error(uid, getClass(), "registrarSolicitudAnalistaBC: "
					+ ex.getMessage(), ex);
			solicitudRespuesta.setId(solicitud);
			solicitudRespuesta.getHeader().setEstatus(false);
			solicitudRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			solicitudRespuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionTx);
		}

		return solicitudRespuesta;
	}

	/**
	 * Metodo para actualizar la solicitud de Analista Documental BC
	 * 
	 * @param uid
	 *            String
	 * @param solicitudesPeticion
	 *            SolicitudesPeticion
	 * @return respuesta tipo SolicitudesRespuesta
	 */
	public SolicitudesRespuesta actualizaSolicitudAnalistaBCTarea(String uid,
			SolicitudesPeticion solicitudesPeticion) {
		SolicitudesRespuesta solicitudesRespuesta = new SolicitudesRespuesta();
		solicitudesRespuesta.setHeader(new EncabezadoRespuesta());
		solicitudesRespuesta.getHeader().setUID(uid);
		solicitudesRespuesta.getHeader().setEstatus(true);
		SqlSession sesionTx = null;
		SqlSession sesionNTx = null;
		List<SolicitudIntegrantesOV> solicitudIntegrantesOVList = new ArrayList<SolicitudIntegrantesOV>();
		SolicitudesOV solicitudesOV = null;
		String mensaje = "";
		String validaStr = "";
		try {
			// Se abre la conexion hacia la base de datos
			sesionTx = FabricaConexiones.obtenerSesionTx();
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			solicitudesOV = solicitudesPeticion.getSolicitud();
			if (solicitudesOV == null) {
				// throw new
				// Exception(ReadProperties.mensajes.getProp("solicitudes.registrar.peticion.datos.incorrectos"));
				throw new Exception(DATOS_INCORRECTOS);
			}

			java.util.HashMap<String, Object> solicitudParametros = new java.util.HashMap<String, Object>();

			solicitudIntegrantesOVList = solicitudesPeticion.getIntegrantes();

			String[] integranteDatosRequeridos = { "solicitud", "empresaOrigen" };

			// Update
			mensaje = "SE HA ACTUALIZADO LA SOLICITUD";
			solicitudParametros = Funciones
					.objectToHashMapUpdate(solicitudesOV);
			LogHandler.info(uid, getClass(),
					"actualizaSolicitudAnalistaBCTarea: - solicitudParametros: +"
							+ solicitudParametros + "+");
			final String solicitudFolio = solicitudesOV.getSolicitud();

			String solicitudQuery = (String) sesionNTx.selectOne(
					"buscaSolicitud", solicitudFolio);
			if (solicitudQuery == null) {
				solicitudQuery = "";
			} else {
				solicitudQuery = solicitudQuery.trim();
			}

			if (!(solicitudQuery.equalsIgnoreCase(solicitudFolio))) { // Update
																		// Integrante
				LogHandler.info(uid, getClass(), "solicitudQuery: +"
						+ solicitudQuery + "+");
				LogHandler.info(uid, getClass(), "solicitudFolio: +"
						+ solicitudFolio + "+");
				LogHandler.info(uid, getClass(), "buscaSolicitud: Solicitud ="
						+ solicitudFolio + "= no encontrada");
				throw new Exception("SOLICITUD NO EXISTE");
			}

			/*
			 * LogHandler.trace(uid, getClass(), "actualizaSolicitud");
			 * LogHandler.info(uid, getClass(), "actualizaSolicitud"); int
			 * registrosAfectados =
			 * sesionTx.update("actualizaSolicitudIntegrantesAnalistaBC",
			 * solicitudParametros); LogHandler.info(uid, getClass(),
			 * "registrosAfectados: " + registrosAfectados); if
			 * (registrosAfectados == 0) { throw new
			 * Exception(ERROR_ACTUALIZACION); }
			 */

			// Update a solicitudes Finsol
			final java.util.HashMap<String, Object> parActCont = new HashMap<String, Object>();
			parActCont.put("solicitud", solicitudesOV.getSolicitud());
			parActCont.put("campana", solicitudesOV.getCampana());

			LogHandler
					.trace(uid, getClass(),
							"actualizaSolicitudAnalistaBCTarea: - actualizaSolicitudFinsolAnalistaBC");
			Integer filas = sesionTx.update(
					"actualizaSolicitudFinsolAnalistaBC", parActCont);

			LogHandler.info(uid, this.getClass(),
					"ACTUALIZAR filas afectadas  [ " + filas + " ]");

			if (filas == 0) {
				throw new Exception(ERROR_ACTUALIZACION);
			}

			if (solicitudIntegrantesOVList != null) {
				for (int i = 0; i < solicitudIntegrantesOVList.size(); i++) {
					java.util.HashMap<String, Object> integranteParametros = null;
					SolicitudIntegrantesOV solicitudIntegrantesOV = new SolicitudIntegrantesOV();
					solicitudIntegrantesOV = solicitudIntegrantesOVList.get(i);
					solicitudIntegrantesOV.setSolicitud(solicitudFolio);

					if (solicitudIntegrantesOV.getCliente() == null) {
						throw new Exception(DATOS_INCORRECTOS);
					}
					java.util.HashMap<String, Object> integranteBuscaParametros = new java.util.HashMap<String, Object>();
					integranteBuscaParametros.put("solicitud",
							solicitudesOV.getSolicitud());
					integranteBuscaParametros.put("cliente",
							solicitudIntegrantesOV.getCliente());
					LogHandler.info(uid, getClass(),
							"integranteBuscaParametros: "
									+ integranteBuscaParametros);
					LogHandler.trace(uid, getClass(),
							"buscaIntegranteSolicitud:");
					LogHandler.info(uid, getClass(),
							"buscaIntegranteSolicitud:");
					String clienteQuery = (String) sesionTx.selectOne(
							"buscaIntegranteSolicitud",
							integranteBuscaParametros);
					if (clienteQuery == null) {
						clienteQuery = "";
					} else {
						clienteQuery = clienteQuery.trim();
					}

					LogHandler.info(uid, getClass(), "\n\n- clienteQuery: "
							+ clienteQuery + "\n\n");
					LogHandler.info(uid, getClass(), "\n\n- OV.getCliente(): "
							+ solicitudIntegrantesOV.getCliente() + "\n\n");

					if (clienteQuery.equalsIgnoreCase(solicitudIntegrantesOV
							.getCliente())) { // Update Integrante
						integranteParametros = Funciones
								.objectToHashMapUpdate(solicitudIntegrantesOV);
						LogHandler.trace(uid, getClass(),
								"actualizaSolicitudIntegrante.cliente: "
										+ solicitudIntegrantesOV.getCliente());
						LogHandler.info(uid, getClass(),
								"actualizaSolicitudIntegrante.cliente: "
										+ solicitudIntegrantesOV.getCliente());
						int registrosAfectadosI = sesionTx.update(
								"actualizaSolicitudIntegrantesAnalistaBC",
								integranteParametros);
						LogHandler.info(uid, getClass(),
								"actualizaSolicitudAnalistaBCTarea: - registrosAfectadosI: "
										+ registrosAfectadosI);
						if (registrosAfectadosI == 0) {
							throw new Exception(ERROR_ACTUALIZACION);
						}
					}
				}
			}

			sesionTx.commit(true);
			solicitudesRespuesta.getHeader().setMensaje(mensaje);
		} catch (Exception ex) {
			LogHandler
					.error(uid,
							getClass(),
							"actualizaSolicitudAnalistaBCTarea: "
									+ ex.getMessage(), ex);
			FabricaConexiones.rollBack(sesionTx);
			solicitudesRespuesta.getHeader().setEstatus(false);
			solicitudesRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			solicitudesRespuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionTx);
			FabricaConexiones.close(sesionNTx);
		}

		return solicitudesRespuesta;
	}

	/**
	 * Metodo que se utiliza para validar el numero de integrantes para la
	 * pantalla del Analista Documental BC.
	 * 
	 * @param uid
	 *            String
	 * @param peticion
	 *            SolicitudSACGPeticion
	 * @return ValidarGuardarSolicitudCECRespuesta
	 */
	public SolicitudesRespuesta validaNumeroIntegrantesAnalistaBCTarea(
			String uid, SolicitudSACGPeticion peticion) {

		SolicitudesRespuesta solicitudesRespuesta = new SolicitudesRespuesta();
		solicitudesRespuesta.setHeader(new EncabezadoRespuesta());
		solicitudesRespuesta.getHeader().setUID(uid);
		solicitudesRespuesta.getHeader().setEstatus(true);

		try {

			// Validacion numero de integrantes
			// Nuevo Credito
			if (peticion.getSolicitudSACG().getCiclo() == 0) {
				LogHandler.trace(uid, getClass(), "- obtenerParGeneral -");

				ParGeneralOV valorMin = comun.obtenerParGeneralOV(uid,
						"COMGAINMIN");

				if (valorMin == null || valorMin.getCgValor().trim().isEmpty()) {
					throw new Exception(
							"No fue posible obtener el numero minimo de integrantes.");
				}

				ParGeneralOV valorMax = comun.obtenerParGeneralOV(uid,
						"COMGAINMAX");

				if (valorMax == null || valorMax.getCgValor().trim().isEmpty()) {
					throw new Exception(
							"No fue posible obtener el numero maximo de integrantes.");
				}

				if (peticion.getSolicitudSACGIntegrantes().size() < Integer
						.parseInt(valorMin.getCgValor())
						|| peticion.getSolicitudSACGIntegrantes().size() > Integer
								.parseInt(valorMax.getCgValor())) {
					throw new Exception(
							"No cumple con el mínimo de integrantes,"
									+ "debe regresar la solicitud al Analista de Sucursal");
				}
			}

			// Renovacion
			if (peticion.getSolicitudSACG().getCiclo() > 0) {

				LogHandler.trace(uid, getClass(), "- obtenerParGeneral-");
				ParGeneralOV campana = comun.obtenerParGeneralOV(uid,
						"PARAMETRO_CAMPANA");
				if (campana == null || campana.getCgValor().trim().isEmpty()) {
					throw new Exception(
							"No fue posible obtener el valor de la campaña.");
				}

				if (peticion.getSolicitudSACG().getCampana() != null) {
					if (peticion.getSolicitudSACG().getCampana()
							.equals(campana.getCgValor().trim())) {

						ParGeneralOV valorMinCampana = comun
								.obtenerParGeneralOV(uid, "COMREINMIN");
						if (valorMinCampana == null
								|| valorMinCampana.getCgValor().trim()
										.isEmpty()) {
							throw new Exception(
									"No fue posible obtener el numero minimo de integrantes.");
						}

						ParGeneralOV valorMaxCampana = comun
								.obtenerParGeneralOV(uid, "COMREINMAX");
						if (valorMaxCampana == null
								|| valorMaxCampana.getCgValor().trim()
										.isEmpty()) {
							throw new Exception(
									"No fue posible obtener el numero maximo de integrantes.");
						}

						if (peticion.getSolicitudSACGIntegrantes().size() < Integer
								.parseInt(valorMinCampana.getCgValor())
								|| peticion.getSolicitudSACGIntegrantes()
										.size() > Integer
										.parseInt(valorMaxCampana.getCgValor())) {
							throw new Exception(
									"No cumple con el mínimo de integrantes,"
											+ "debe regresar la solicitud al Analista de Sucursal");
						}

					} else {
						ParGeneralOV valorMinRenovacion = comun
								.obtenerParGeneralOV(uid, "COMREINMIN");

						if (valorMinRenovacion == null
								|| valorMinRenovacion.getCgValor().trim()
										.isEmpty()) {
							throw new Exception(
									"No fue posible obtener el numero minimo de integrantes.");
						}

						ParGeneralOV valorMaxRenovacion = comun
								.obtenerParGeneralOV(uid, "COMREINMAX");

						if (valorMaxRenovacion == null
								|| valorMaxRenovacion.getCgValor().trim()
										.isEmpty()) {
							throw new Exception(
									"No fue posible obtener el numero maximo de integrantes.");
						}

						if (peticion.getSolicitudSACGIntegrantes().size() < Integer
								.parseInt(valorMinRenovacion.getCgValor())
								|| peticion.getSolicitudSACGIntegrantes()
										.size() > Integer
										.parseInt(valorMaxRenovacion
												.getCgValor())) {
							throw new Exception(
									"No cumple con el mínimo de integrantes,"
											+ "debe regresar la solicitud al Analista de Sucursal");
						}
					}
				} else {
					ParGeneralOV valorMinRenov = comun.obtenerParGeneralOV(uid,
							"COMREINMIN");

					if (valorMinRenov == null
							|| valorMinRenov.getCgValor().trim().isEmpty()) {
						throw new Exception(
								"No fue posible obtener el numero minimo de integrantes.");
					}

					ParGeneralOV valorMaxRenov = comun.obtenerParGeneralOV(uid,
							"COMREINMAX");

					if (valorMaxRenov == null
							|| valorMaxRenov.getCgValor().trim().isEmpty()) {
						throw new Exception(
								"No fue posible obtener el numero maximo de integrantes.");
					}

					if (peticion.getSolicitudSACGIntegrantes().size() < Integer
							.parseInt(valorMinRenov.getCgValor())
							|| peticion.getSolicitudSACGIntegrantes().size() > Integer
									.parseInt(valorMaxRenov.getCgValor())) {
						throw new Exception(
								"No cumple con el mínimo de integrantes,"
										+ "debe regresar la solicitud al Analista de Sucursal");
					}
				}
			}
		} catch (Exception e) {
			LogHandler.error(uid, getClass(),
					"Error en obtenerDatosSolicitud: " + e.getMessage(), e);
			solicitudesRespuesta.getHeader().setEstatus(false);
			solicitudesRespuesta.getHeader().setMensaje(e.getMessage());
		}
		return solicitudesRespuesta;
	}

	/**
	 * Metodo para eliminar una cliente de la pantalla Analista Documental BC
	 * 
	 * @param uid
	 *            Identificador unico
	 * @param solicitudPeticion
	 *            solicitudPeticion
	 * @return SolicitudExcepcionDocumentalRespuesta
	 */
	public SolicitudExcepcionDocumentalRespuesta eliminaClienteAnalistaBCTarea(
			String uid, SolicitudExcepcionDocumental solicitudPeticion) {

		SolicitudExcepcionDocumentalRespuesta solicitudRespuesta = new SolicitudExcepcionDocumentalRespuesta();
		solicitudRespuesta.setHeader(new EncabezadoRespuesta());
		solicitudRespuesta.getHeader().setUID(uid);
		solicitudRespuesta.getHeader().setEstatus(true);
		SqlSession sesionTx = null;
		String solicitud = "";

		try {
			// Se abre la conexion hacia la base de datos
			sesionTx = FabricaConexiones.obtenerSesionTx();

			solicitud = solicitudPeticion.getSolicitud();
			java.util.HashMap<String, Object> solicitudParametros = new java.util.HashMap<String, Object>();

			solicitudParametros = Funciones
					.objectToHashMapUpdate(solicitudPeticion);
			LogHandler.info(uid, getClass(),
					"eliminaClienteAnalistaBCTarea: - solicitudParametros: + "
							+ solicitudParametros + " +");

			LogHandler
					.info(uid, getClass(),
							"eliminaClienteAnalistaBCTarea: - eliminaIntegranteAnalistaDocumentalBC");
			int registrosAfectados = sesionTx.update(
					"eliminaIntegranteAnalistaDocumentalBC",
					solicitudParametros);
			LogHandler.info(uid, getClass(),
					"eliminaClienteAnalistaBCTarea: - registrosAfectados: "
							+ registrosAfectados);

			if (registrosAfectados == 0) {
				throw new Exception(ERROR_ACTUALIZACION);
			}

			LogHandler.info(uid, getClass(),
					"eliminaClienteAnalistaBCTarea: -> ");
			sesionTx.commit(true);
			solicitudRespuesta.setId(solicitud);
			solicitudRespuesta.getHeader().setMensaje(
					"Se actualizó correctamente la solicitud");
		} catch (Exception ex) {
			FabricaConexiones.rollBack(sesionTx);
			LogHandler.error(uid, getClass(), "eliminaClienteAnalistaBCTarea: "
					+ ex.getMessage(), ex);
			solicitudRespuesta.setId(solicitud);
			solicitudRespuesta.getHeader().setEstatus(false);
			solicitudRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			solicitudRespuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionTx);
		}

		return solicitudRespuesta;
	}

	/**
	 * m&eacute;todo para consultar si el contrato tiene 60 dias o mas de atraso
	 * 
	 * @param peticion
	 *            con los datos del contrato a consultar
	 * @param uid
	 *            id de la transaccion
	 * @return ConsultaCatalogoRespuesta respuesta del contrato com mayor a 60
	 *         dias
	 */
	public ConsultaCatalogoRespuestaCIOF validacionContrato(String uid,
			ConsultaCatalogoPeticionCIOF peticion) {

		ConsultaCatalogoRespuestaCIOF respuesta = new ConsultaCatalogoRespuestaCIOF();
		respuesta.setHeader(new EncabezadoRespuesta());
		SqlSession sesionNTx = null;

		try {
			if (peticion.getContrato() == null
					|| peticion.getContrato().trim().isEmpty()) {
				throw new Exception(
						"El contrato es obligatorio para realizar la consulta.");
			}

			// Validar si existe el contrato ya sea ld o contrato
			String numeroContrato = comun.obtenerNumeroContrato(uid,
					peticion.getContrato());
			LogHandler
					.info(uid, this.getClass(),
							"validacionContrato--numero de contrato: "
									+ numeroContrato);

			// Validaciones
			if (numeroContrato == null || numeroContrato.isEmpty()) {
				throw new Exception(
						"El Número de Contrato de la petición no existe.");
			}

			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			final FechaContableOV fechaContable = comun
					.obtenerFechaContable(uid);

			final HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("contrato", numeroContrato);
			parametros.put("fechaContable",
					formatter.format(fechaContable.getFecha()));

			LogHandler.info(uid, this.getClass(),
					"validacionContrato--parametros: " + parametros);

			int diasAtraso = (Integer) sesionNTx.selectOne(
					"obtenerDiasAtrasoContrato", parametros);

			LogHandler.info(uid, this.getClass(),
					"validacionContrato--dias de atraso: " + diasAtraso);

			respuesta.setDiasAtraso(diasAtraso);

			if (diasAtraso < Constantes.DIAS_ATRASO) {
				respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setUID(uid);
				respuesta.getHeader().setMensaje(
						"Este grupo no cumple para Renovación Especial.");
				return respuesta;
			} else {
				respuesta.getHeader().setEstatus(true);
				respuesta.getHeader().setUID(uid);
				respuesta.getHeader().setMensaje(
						"Este grupo cumple para Renovación Especial.");
			}

		} catch (Exception ex) {
			respuesta.getHeader().setMensaje(
					"Ocurrio al validar los 60 días del contrato "
							+ ex.getMessage());
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setUID(uid);
			LogHandler.error(
					uid,
					this.getClass(),
					"Ocurrio al validar los 60 días del contrato "
							+ ex.getMessage(), ex);
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * metodo que obtiene los valores de la JDNI
	 * 
	 * @param uid
	 *            id de la transaccion
	 * @param variables
	 *            nombres de las JDNI
	 * @return HashMap<String, Object> con los valores de las JDNI
	 */
	public HashMap<String, Object> obtenerMapaJdni(String uid,
			String... variables) throws Exception {
		LogHandler.info(uid, getClass(), "obtenerMapaJdni: " + variables);
		HashMap<String, Object> valores = new java.util.HashMap<String, Object>();
		if (variables != null) {
			for (String valor : variables) {
				ParGeneralOV parGeneral = comun.obtenerParGeneralOV(uid, valor);
				if (parGeneral == null
						|| parGeneral.getCgValor().trim().isEmpty()) {
					throw new Exception("No fue posible recueperar la jdni: "
							+ valor);
				}
				valores.put(valor, parGeneral.getCgValor());
			}
		}
		return valores;
	}

	/**
	 * metodo que envia correos de cauerdo al perfil
	 * 
	 * @param uid
	 *            id de la transaccion
	 * @param peticion
	 *            de la solicitud
	 * @param perfil
	 *            del solicitante
	 * @return EnviarCorreoRespuesta enviar correo de respuesta.
	 */
	public EnviarCorreoRespuesta enviarCorreoPorPerfil(String uid,
			ExcepcionGarantiaPeticion peticion, String perfil) throws Exception {
		LogHandler.info(uid, getClass(),
				"-------entrando al metodo enviarCorreoPorPerfil-------"
						+ peticion);
		EnviarCorreoRespuesta res = new EnviarCorreoRespuesta();
		res.setHeader(new EncabezadoRespuesta());
		ExcepcionGarantiaPeticion valorFaltante = new ExcepcionGarantiaPeticion();
		String correo = null;
		SqlSession sesionNTx = null;
		HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();
		try {

			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			// obtenemos el correo de acuerdo al perfil por sucursal
			if (peticion.getSucursal() != null
					&& !peticion.getSucursal().isEmpty() && perfil != null
					&& peticion.getSolicitud() != null
					&& !peticion.getSolicitud().isEmpty()) {
				// obtenemos en que base de datos trabajamos

				String dbEntorno = sesionNTx.getConfiguration().getVariables()
						.getProperty("db.entorno");
				LogHandler.info(uid, getClass(),
						"enviarCorreoPorPerfil:	dbEntorno: " + dbEntorno);

				parametros.put("sucursal",
						Integer.parseInt(peticion.getSucursal()));
				parametros.put("solicitud", peticion.getSolicitud());
				parametros.put("perfil", perfil);
				parametros.put("dbEntorno", dbEntorno);

				// este query llena los campos de sucursal, campana, correo,
				// usuarioAut(regional divisional o riesgo)
				valorFaltante = (ExcepcionGarantiaPeticion) sesionNTx
						.selectOne("obtenerCorreoPorPerfil", parametros);
				LogHandler.info(uid, getClass(),
						"enviarCorreoPorPerfil:obtenerCorreoPorPerfil  "
								+ valorFaltante);

				if (!perfil.equals(Constantes.CORREO_RIESGO)
						&& (valorFaltante.getCorreo() == null || valorFaltante
								.getUsuarioAut() == null)) {
					LogHandler.info(uid, getClass(),
							"enviarCorreoPorPerfil: obtenerCorreoPorPerfil"
									+ "  no recupero datos para la solicitud: "
									+ peticion.getSolicitud());
					return res;
				}
				peticion.setCorreo(valorFaltante.getCorreo());
				peticion.setCampana(valorFaltante.getCampana());
				peticion.setNombreSucursal(valorFaltante.getSucursal()); // se
																			// sobreescribe
																			// nuevamente.

				if (perfil.equals(Constantes.CORREO_REGIONAL)) {
					peticion.setUsuarioAut(valorFaltante.getUsuarioAut());
				}

				if (perfil.equals(Constantes.CORREO_RIESGO)) {
					HashMap<String, Object> valoresJDNI = new HashMap<String, Object>();
					valoresJDNI = obtenerMapaJdni(uid, "CORREO_RIESGO");
					correo = Validaciones.obtenerListaCodigos(uid,
							valoresJDNI.get("CORREO_RIESGO").toString()).get(0);
					if (correo == null || correo.trim().isEmpty()) {
						throw new Exception(
								"No se pudo recuperar la JDNI: CORREO_RIESGO");
					}
					peticion.setCorreo(correo.trim());
				}
			} else {
				LogHandler
						.info(uid, getClass(),
								"La petición es incorrecta, falta la sucural o la solicitud");
				res.getHeader().setEstatus(false);
				res.getHeader()
						.setMensaje(
								"La petición es incorrecta, falta la sucural o la solicitud");
				return res;
			}
			LogHandler.info(uid, getClass(), "enviarCorreoPorPerfil: correo "
					+ correo);
			// enviamos correo o notificacion al regional
			if (peticion.getCorreo() != null) {
				res = EnvioDeCorreos.enviarCorreo(uid, peticion);
				if (!res.getHeader().isEstatus()) {
					LogHandler.info(uid, getClass(),
							"guardarSolicitudCreditoTarea: No se puedo enviar correo"
									+ " al gerente Regional de la sucursal: "
									+ peticion.getSucursal() + " debido a "
									+ res.getHeader().getMensaje());
				}
			} else {
				LogHandler.info(uid, getClass(),
						"guardarSolicitudCreditoTarea: No se puedo enviar correo"
								+ " al gerente Regional de la sucursal: "
								+ peticion.getSucursal()
								+ " ya que no cuenta con un correo");
			}
		} catch (Exception ex) {
			LogHandler.error(uid, getClass(), "NO SE PUDO ENVIAR CORREO A "
					+ correo, ex);
			throw new Exception("No se pudo enviar el correo " + correo);
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return res;
	}

	/**
	 * Generar Tarea para registrar la justificación de excepción de cupos y
	 * montos.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            justificación de excepción de cupos y montos
	 * @param sesionExterna
	 *            sesion externa de BD
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta generarExcepcionCuposMontosTarea(
			String uid, ExcepcionGarantiaPeticion peticion,
			SqlSession sesionExterna) {

		ExcepcionGarantiaRespuesta respuesta = new ExcepcionGarantiaRespuesta();

		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionTx = null;
		int idTarea = 0;

		try {

			if (sesionExterna == null) {
				sesionTx = FabricaConexiones.obtenerSesionTx();
			} else {
				sesionTx = sesionExterna;
			}

			if (peticion == null) {
				throw new Exception("La peticion viene nula");
			} else if (peticion.getTipoTarea() == null
					|| peticion.getTipoTarea().trim().isEmpty()) {
				throw new Exception("Falta el TipoTarea en la peticion");
			} else if (peticion.getSucursal() == null
					|| peticion.getSucursal().trim().isEmpty()) {
				throw new Exception("Falta la Sucursal en la peticion");
			} else if (peticion.getDescripcion() == null
					|| peticion.getDescripcion().trim().isEmpty()) {
				throw new Exception("Falta la Solicitud en la peticion");
			} else if (peticion.getUsuarioAlta() == null
					|| peticion.getUsuarioAlta().trim().isEmpty()) {
				throw new Exception("Falta el UsuarioAlta en la peticion");
			} else if (peticion.getPerfil() == null
					|| peticion.getPerfil().trim().isEmpty()) {
				throw new Exception("Falta el Perfil en la peticion");
			} else if (peticion.getStatus() == null
					|| peticion.getStatus().trim().isEmpty()) {
				throw new Exception("Falta el Status en la peticion");
			} else if (peticion.getJustificacion() == null
					|| peticion.getJustificacion().trim().isEmpty()) {
				throw new Exception("Falta la Justificacion en la peticion");
			} else if (peticion.getTipoException() == null
					|| peticion.getTipoException().trim().isEmpty()) {
				throw new Exception("Falta la TipoException en la peticion");
			}

			// else if (peticion.getUsuarioAut() == null ||
			// peticion.getUsuarioAut().trim().isEmpty()) {
			// throw new Exception("Falta la UsuarioAut en la peticion");
			// }

			final java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();

			// parametros para el insert en la tabla buzon_tareas
			parametros.put("tipoTarea", peticion.getTipoTarea()); // TRCE- tarea
																	// campaña
			parametros.put("sucursal", new Integer(peticion.getSucursal()));
			parametros.put("descripcion", peticion.getDescripcion());
			parametros.put("usuarioAlta", peticion.getUsuarioAlta());
			parametros.put("perfil", peticion.getPerfil()); // PCOM
			parametros.put("status", peticion.getStatus()); // P
			parametros.put("tipoException", peticion.getTipoException()); // CUPO,
																			// MNTO,
																			// CUMO
			parametros.put("idTareaPadre", peticion.getIdTareaPadre());
			// parametros.put("usuarioPropietario", peticion.getUsuarioAut());
			// parametros.put("fechaAsignacion", "SI");

			Integer insertBT = (Integer) sesionTx.insert(
					"insertaBuzonTareaExcepcionGarantia", parametros);
			LogHandler.info(
					uid,
					getClass(),
					"generarExcepcionCuposMontosTarea idTarea: "
							+ parametros.get("idTarea"));

			idTarea = Integer.parseInt(parametros.get("idTarea").toString());
			// parametros para el insert en la tabla tareas_excepcion_campania
			parametros.put("idTarea", idTarea);
			parametros.put("solicitud", peticion.getDescripcion());
			parametros.put("justificacion", peticion.getJustificacion());
			sesionTx.insert("insertaTareaExcepcionCampana", parametros);

			// Atomo ATOMO_EXCEPCION_GARANTIA
			AtomosOV peticionAtomo = new AtomosOV();
			peticionAtomo.setSolicitud(peticion.getDescripcion());
			peticionAtomo.setProceso(Constantes.ATOMO_EXCEPCION_CUPO_MONTO);
			peticionAtomo
					.setCodigoResolucion(Constantes.ATOMO_EXCEPCION_GARANTIA_INICIO);
			peticionAtomo.setComentario("");
			peticionAtomo.setStatus("A");
			peticionAtomo.setUsuarioGeneroAtomo(peticion.getUsuarioAlta());
			peticionAtomo.setActualizarSolicitud("SI");
			peticionAtomo.setIdTarea(idTarea);
			AtomosRespuesta atomosRespuesta = registrarAtomosExceptionTarea(
					uid, sesionTx, peticionAtomo);

			if (!atomosRespuesta.getHeader().isEstatus()) {
				throw new Exception("ATOMO_EXCEPCION_CUPO_MONTO:"
						+ atomosRespuesta.getHeader().getMensaje());
			}

			if (sesionExterna == null) {
				sesionTx.commit();
			}

		} catch (Exception e) {
			if (sesionExterna == null) {
				FabricaConexiones.rollBack(sesionTx);
			}

			LogHandler
					.error(uid,
							getClass(),
							"Error en generarTareaExcepcionGarantia: "
									+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			if (sesionExterna == null) {
				FabricaConexiones.close(sesionTx);
			}
		}
		return respuesta;
	}

	/**
	 * Metodo para registrar en la tabla de atomos para montos y cupos
	 * 
	 * @param uid
	 *            uid unico de transaccion
	 * @param sesion
	 *            sesion actual
	 * @param peticion
	 *            AtomosOV
	 * @return respuesta tipo AtomosRespuesta
	 */
	public AtomosRespuesta registrarAtomosExceptionTarea(String uid,
			SqlSession sesion, AtomosOV peticion) {
		AtomosRespuesta respuesta = new AtomosRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionTx = null;
		boolean sesionExterna = false;
		try {
			// Se abre la conexion hacia la base de datos
			if (sesion == null) {
				sesionTx = FabricaConexiones.obtenerSesionTx();
			} else {
				sesionTx = sesion;
				sesionExterna = true;
			}

			// Calendar myDate = Calendar.getInstance();

			if (peticion == null) {
				throw new Exception("La peticion esta vacia o es nula");
			}

			// parametros de consulta
			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			// parametros.put( "id_atomo" , peticion.getId_atomo() != null ?
			// peticion.getId_atomo() : 0.0);
			parametros.put("proceso",
					peticion.getProceso() != null ? peticion.getProceso() : "");
			parametros.put("id_proceso",
					peticion.getIdProceso() != null ? peticion.getIdProceso()
							: 0.0);
			parametros.put("id_tarea",
					peticion.getIdTarea() != null ? peticion.getIdTarea() : 0);
			parametros.put("solicitud",
					peticion.getSolicitud() != null ? peticion.getSolicitud()
							: "");
			parametros.put("cliente",
					peticion.getCliente() != null ? peticion.getCliente() : "");
			parametros.put(
					"usuario_genero_atomo",
					peticion.getUsuarioGeneroAtomo() != null ? peticion
							.getUsuarioGeneroAtomo() : "");
			parametros.put("status",
					peticion.getStatus() != null ? peticion.getStatus() : "A");
			parametros.put("tipo_atomo",
					peticion.getTipoAtomo() != null ? peticion.getTipoAtomo()
							: "");
			parametros.put("es_critico",
					peticion.getEsCritico() != null ? peticion.getEsCritico()
							: "");
			parametros.put("etapa",
					peticion.getEtapa() != null ? peticion.getEtapa() : "");
			@SuppressWarnings("deprecation")
			Date miFecha = new Date("01/01/1900");
			// parametros.put( "hora_registro" , peticion.getHoraRegistro() !=
			// null ? peticion.getHoraRegistro() : myDate.getTime());
			parametros.put(
					"hora_resolucion",
					peticion.getHoraResolucion() != null ? peticion
							.getHoraResolucion() : miFecha);
			parametros.put(
					"codigo_resolucion",
					peticion.getCodigoResolucion() != null ? peticion
							.getCodigoResolucion() : "");
			parametros.put("resolucion",
					peticion.getResolucion() != null ? peticion.getResolucion()
							: "");
			parametros.put("comentario",
					peticion.getComentario() != null ? peticion.getComentario()
							: "");
			parametros.put(
					"id_atomo_anterior",
					peticion.getIdAtomoAnterior() != null ? peticion
							.getIdAtomoAnterior() : 0.0);
			parametros.put(
					"genero_atomo_siguiente",
					peticion.getGeneroAtomoSiguiente() != null ? peticion
							.getGeneroAtomoSiguiente() : "");
			parametros.put(
					"origen_error",
					peticion.getOrigenError() != null ? peticion
							.getOrigenError() : "");
			parametros.put(
					"numero_integrante",
					peticion.getNumeroIntegrante() != null ? peticion
							.getNumeroIntegrante() : 0);

			// Validamos si el registro del atomo es el mismo que el anterior
			LogHandler.trace(uid, getClass(),
					"==> registrarAtomosExceptionTarea - verificaUltimoAtomo");
			AtomosOV ultimoAtomo = (AtomosOV) sesionTx.selectOne(
					"verificaUltimoAtomo", parametros);

			if (ultimoAtomo != null) {
				if (ultimoAtomo.getProceso().trim()
						.equals(parametros.get("proceso").toString().trim())
						&& ultimoAtomo
								.getUsuarioGeneroAtomo()
								.trim()
								.equals(parametros.get("usuario_genero_atomo")
										.toString().trim())) {
					respuesta.getHeader().setMensaje(
							"No se inserto el atomo, ya existia.");
					return respuesta;
				}
			}
			LogHandler.trace(uid, getClass(),
					"==> registrarAtomosExceptionTarea - insertaAtomos");
			sesionTx.insert("insertaAtomos", parametros);

			if (parametros.get("idAtomo") == null) {
				parametros.put("idAtomo", 0);
			}
			LogHandler.trace(uid, getClass(),
					"==> registrarAtomosExceptionTarea idAtomo : "
							+ parametros.get("idAtomo").toString());
			respuesta.setIdAtomo(Integer.valueOf(parametros.get("idAtomo")
					.toString()));

			// Actualizar estatus de la solicitud

			final java.util.HashMap<String, Object> parametrosSolicitud = new HashMap<String, Object>();
			LogHandler.trace(uid, getClass(),
					"==> registrarAtomosTarea - actualizaCreditoTempMO");
			parametrosSolicitud.put("id",
					peticion.getSolicitud() != null ? peticion.getSolicitud()
							: "");
			parametrosSolicitud.put("estatus",
					peticion.getProceso() != null ? peticion.getProceso() : "");
			parametrosSolicitud.put(
					"desEstatus",
					peticion.getCodigoResolucion() != null ? peticion
							.getCodigoResolucion() : "");
			// Actualiza la fecha del campo fecha_reg_exp_cm cuando se crea el
			// atomo por primera vez de solicitudes_finsol
			parametrosSolicitud.put(
					"actualizaFecha",
					peticion.getActualizarSolicitud() != null ? peticion
							.getActualizarSolicitud() : "NO");
			sesionTx.update("actualizaCreditoTempMO", parametrosSolicitud); //

			if (!sesionExterna) {
				sesionTx.commit(true);
			}
			respuesta.getHeader().setMensaje(
					"Se ha insertado con exito un atomo");

		} catch (Exception ex) {
			if (!sesionExterna) {
				FabricaConexiones.rollBack(sesionTx);
			}
			LogHandler.error(uid, getClass(),
					"registrarAtomosExceptionTarea(): " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		} finally {
			if (!sesionExterna) {
				FabricaConexiones.close(sesionTx);
			}
		}

		return respuesta;

	}

	/**
	 * metodo que realiza la validacion al guardar del minimo de integrantes
	 * 
	 * @param uid
	 *            id unico de transaccion
	 * @param peticion
	 *            peticion
	 * @return String mensaje si se se cumple aluna validacion
	 */
	@SuppressWarnings("unchecked")
	public String validacionCuposYMontosCampana(String uid,
			SolicitudSACGPeticion peticion) {
		LogHandler.info(uid, getClass(),
				"------- Entrando al metodo validacionCuposYMontosCampana con la sucursal: "
						+ peticion.getSolicitudSACG().getSucursal()
						+ "-----------");
		String respuesta = "";
		SqlSession sesionNTx = null;
		int sizeSolicitudesAprobadas = 0;
		int sizeSolicitudesBuzon = 0;
		int cuposCampanaDisponible = 0;
		double montoExposicionPorMes = 0.0;
		double montoExpocicionDisponible = 0.0;
		boolean excedeCupo = false;
		boolean excedeMonto = false;
		boolean excepcion = false;
		String msjRompeFlujo = "break";
		String msjInformativo = "continue";
		// esta variable indica que los mensajes son de confirmacion
		String msjPopUp = "popUp";
		int ciclo = peticion.getSolicitudSACG().getCiclo();
		String campana = peticion.getSolicitudSACG().getCampana() == null ? ""
				: peticion.getSolicitudSACG().getCampana();
		LogHandler.info(uid, getClass(), "ciclo: " + ciclo + "\tcampana: "
				+ campana);

		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			// paso1: Número máximo de cupos configurado en la sucursal para
			// campaña 1.
			SucursalOV sucursal = (SucursalOV) sesionNTx.selectOne(
					"obtenerConfiguracionSucursalCupMon", peticion
							.getSolicitudSACG().getSucursal());

			if (sucursal == null) {
				throw new Exception(
						"No existen datos a configurar para la sucursal: "
								+ peticion.getSolicitudSACG().getSucursal());
			}

			LogHandler.info(uid, getClass(),
					"montoDesertorGarantiaCalculado: Restricciones sucursal "
							+ sucursal);

			// validacion 4: la sucursal tiene la restricción Suspensión
			// Temporal de Nuevos Grupos
			if (ciclo == 0 && sucursal.getSuspencionGrupoNuevo().equals("S")) {
				excepcion = true;
				respuesta += "La sucursal tiene la restricción \"Suspensión Temporal de Nuevos Grupos\""
						+ msjRompeFlujo;
			}

			// validacion 5: la sucursal tiene la restricción Colocación mayor a
			// 16 semanas (aplica para ciclos 1, 2 y 3)
			HashMap<String, Object> valoresJDNI = new HashMap<String, Object>();
			valoresJDNI = obtenerMapaJdni(
					uid,
					"com.mx.finsol.originacion.financiada.contratoant.maximoretraso",
					"PLAZO_MAYOR_SEMANAL", "CICLOS_CATORCENAL",
					"CICLOS_SEMANAL");
			int diasMaxAtraso = Integer
					.parseInt(valoresJDNI
							.get("com.mx.finsol.originacion.financiada.contratoant.maximoretraso")
							.toString()); // 14
			int plazoMayor = Integer.parseInt(valoresJDNI.get(
					"PLAZO_MAYOR_SEMANAL").toString()); // 16
			List<String> ciclosCatorcenal = Validaciones.obtenerListaCodigos(
					uid, valoresJDNI.get("CICLOS_CATORCENAL").toString()); // 0;1;2;3
			// 0;1;2
			List<String> ciclosSemanal = Validaciones.obtenerListaCodigos(uid,
					valoresJDNI.get("CICLOS_SEMANAL").toString());
			LogHandler.info(uid, this.getClass(),
					"validacionCuposYMontosCampana--diasMaxAtraso: "
							+ diasMaxAtraso + "\tplazomayor: " + plazoMayor
							+ "\t ciclosSemanal: " + ciclosSemanal
							+ "\t ciclosCatorcenal: " + ciclosCatorcenal);

			String contratoAnterior;
			int diasAtraso = 0;
			// String campanAnterior = null;

			if (ciclo > 0
					&& peticion.getSolicitudSACG().getContratoPrevio() != null) {
				contratoAnterior = comun.obtenerNumeroContrato(uid, peticion
						.getSolicitudSACG().getContratoPrevio());
				LogHandler.info(uid, this.getClass(),
						"validacionCuposYMontosCampana--numero de contrato: "
								+ contratoAnterior);
				// Validaciones
				if (contratoAnterior == null || contratoAnterior.isEmpty()) {
					throw new Exception(
							"El Número de Contrato de la petición no existe.");
				}
				// se comenta por que por ahorita no se manejan campañas
				// campanAnterior = (String)
				// sesionNTx.selectOne("campanaPorcontrato", contratoAnterior);

				LogHandler.info(uid, this.getClass(),
						"validacionCuposYMontosCampana--contrato: "
								+ contratoAnterior);
				diasAtraso = (Integer) sesionNTx.selectOne(
						"diasMoraBuroCredito", contratoAnterior);
				LogHandler.info(uid, this.getClass(),
						"validacionCuposYMontosCampana--dias de atraso: "
								+ diasAtraso);
			}

			String cicloCadena = ciclo + "";
			int plazoSemanalMaximo = 0;

			// validacion nueva que se agrega si es un 1 tiene restriccion y si
			// es un 0 no tiene restriccion
			if (sucursal.getPlazoRestriccionSemanal() == 1) {
				plazoSemanalMaximo = plazoMayor;
			}

			if (peticion.getSolicitudSACG().getFrecuenciaPago().equals("S")
					&& plazoSemanalMaximo > 0
					&& ciclosSemanal.contains(cicloCadena)) {
				if (ciclo == 0
						&& peticion.getSolicitudSACG().getPlazo() > plazoSemanalMaximo) {
					excepcion = true;
					respuesta += "La sucursal tiene la restricción \"Colocación mayor a 16 semanas\""
							+ msjRompeFlujo;
				} else if (ciclo > 0
						&& peticion.getSolicitudSACG().getPlazo() > plazoSemanalMaximo
						&& diasAtraso > diasMaxAtraso) {
					excepcion = true;
					respuesta += "La sucursal tiene la restricción \"Colocación mayor a 16 semanas\""
							+ msjRompeFlujo;
				}
			}

			// validacion 6: la sucursal tiene la restricción \"Colocación pago
			// catorcenal\" (aplica para ciclos 1, 2, 3)
			boolean pagoCatorcenal = peticion.getSolicitudSACG()
					.getFrecuenciaPago().equals("C");
			if (sucursal.getPlazoRestriccionCatorcenal().equals("S")
					&& pagoCatorcenal && ciclosCatorcenal != null
					&& ciclosCatorcenal.contains(cicloCadena)) {
				if (ciclo == Constantes.CICLO_TRES
						&& diasAtraso > diasMaxAtraso) {
					excepcion = true;
					respuesta += "La sucursal tiene la restricción \"Colocación pago catorcenal\""
							+ msjRompeFlujo;
				} else if (ciclo >= Constantes.CICLO_UNO
						&& campana.equals(Constantes.CAMPANA_UNO)
						&& diasAtraso > diasMaxAtraso) {
					excepcion = true;
					respuesta += "La sucursal tiene la restricción \"Colocación pago catorcenal\", tendrá que"
							+ " migrar a pago semanal." + msjRompeFlujo;
				} else if (ciclo >= Constantes.CICLO_UNO
						&& diasAtraso > diasMaxAtraso) {
					excepcion = true;
					respuesta += "La sucursal tiene la restricción \"Colocación pago catorcenal\""
							+ msjRompeFlujo;
				} else if (ciclo == 0) {
					excepcion = true;
					respuesta += "La sucursal tiene la restricción \"Colocación pago catorcenal\""
							+ msjRompeFlujo;
				}
			}

			// nos regresa la respuesta, ya que no tiene caso que entre a cupo o
			// monto.
			if (excepcion) {
				return respuesta;
			}

			// generar la excepcion de cupo o monto

			int tareaPendienteCuposYMonto = tareasPendientes(uid,
					peticion.getSolicitudSACG(), Constantes.TAREA_CUPO_MONTO);
			int tareaAprobada = tareasAprobadas(uid,
					peticion.getSolicitudSACG(), Constantes.TAREA_CUPO_MONTO);

			LogHandler.info(uid, getClass(),
					"validarGuardarSolicitudCredito: tareaPendienteCuposYMonto:"
							+ tareaPendienteCuposYMonto);
			LogHandler.info(uid, getClass(),
					"validarGuardarSolicitudCredito: tareaAprobada:"
							+ tareaAprobada);

			if (peticion.getSolicitudSACG().getCampana()
					.equals(Constantes.CAMPANA_UNO)
					&& ciclo == 0
					&& tareaPendienteCuposYMonto == 0
					&& tareaAprobada == 0) {
				// validacion que se agrega cuando el efectivo solicitado es 0 y
				// el numero de integrantes es 0 o no cumple con la campaña
				if (peticion.getSolicitudSACGIntegrantes() == null) {
					LogHandler
							.info(uid, getClass(),
									"validacionCuposYMontosCampana: no se valida, no hay integrantes");
					return respuesta;
				} else if (peticion.getSolicitudSACGIntegrantes() != null
						&& peticion.getSolicitudSACG().getContratoPrevio() == null) {
					if (peticion.getSolicitudSACGIntegrantes().size() < Constantes.INTEGRANTE_CICLO_UNO) {
						LogHandler.info(uid, getClass(),
								"validacionCuposYMontosCampana: no se valida,"
										+ " no cumple con integrantes");
						return respuesta;
					} else if (peticion.getSolicitudSACG()
							.getNuevoCreditoSolicitado() != null
							&& peticion.getSolicitudSACG()
									.getNuevoCreditoSolicitado() <= 0.0) {
						LogHandler.info(uid, getClass(),
								"validacionCuposYMontosCampana: no se valida,"
										+ " no cumple con monto");
						return respuesta;
					}
				}

				// ---- validacion 1: Si se excede el cupo campana 1 para ciclo
				// 1, mayor al disponible en la sucursal
				// paso 2: Número de solicitudes con campaña 1 aprobadas en la
				// sucursal en el mes en curso.
				List<SolicitudesOV> solicitudesAprobadas = (List<SolicitudesOV>) sesionNTx
						.selectList("obtenerSolicitudesAprobadas", peticion
								.getSolicitudSACG().getSucursal());

				sizeSolicitudesAprobadas = solicitudesAprobadas == null ? 0
						: solicitudesAprobadas.size();

				// paso 3: Número de solicitudes campaña 1 que están en el buzón
				// del Gerente Regional en el mes actual.
				List<SolicitudesOV> solicitudesBuzon = (List<SolicitudesOV>) sesionNTx
						.selectList("obtenerSolicitudesEnBuzon", peticion
								.getSolicitudSACG().getSucursal());

				sizeSolicitudesBuzon = solicitudesBuzon == null ? 0
						: solicitudesBuzon.size();

				// nota: se le aumenta un uno en el cupo para tomar en cuenta a
				// la solicitud actual
				cuposCampanaDisponible = sucursal.getCuposCampana()
						- (sizeSolicitudesAprobadas + sizeSolicitudesBuzon + 1);

				LogHandler.info(
						uid,
						getClass(),
						"validacionCuposYMontosCampana=> SolicitudesAprobadas: "
								+ sizeSolicitudesAprobadas
								+ "\tSolicitudesBuzon:" + sizeSolicitudesBuzon
								+ "\tcuposCampana: "
								+ sucursal.getCuposCampana()
								+ "\tcuposCampanaDisponible: "
								+ cuposCampanaDisponible);

				if ((sizeSolicitudesAprobadas + sizeSolicitudesBuzon) >= sucursal
						.getCuposCampana()) {
					excedeCupo = true;
					respuesta = Constantes.TIPO_TAREA_CUPO
							+ "La cantidad de cupo que intenta registrar"
							+ " es mayor al permitido en la sucursal."
							+ " El número máximo es de: "
							+ sucursal.getCuposCampana()
							+ " cupos. ¿Desea Generar una Excepción?"
							+ msjPopUp;
				}

				// validacion 2: supera el número disponible de Cupos Campaña y
				// supera el Monto de Exposición
				// en el mes por Campaña disponible en la sucursal
				List<SolicitudesOV> listBuzonAprobadas = new ArrayList<SolicitudesOV>();
				if (solicitudesAprobadas != null
						&& solicitudesAprobadas.size() > 0) {
					listBuzonAprobadas = solicitudesAprobadas;
				}
				if (solicitudesBuzon != null && solicitudesBuzon.size() > 0) {
					listBuzonAprobadas.addAll(solicitudesBuzon);
				}

				for (SolicitudesOV solicitud : listBuzonAprobadas) {
					if (solicitud.getEfectivoSolicitado() != null) {
						montoExposicionPorMes = montoExposicionPorMes
								+ solicitud.getEfectivoSolicitado();
					}
				}

				// Nota: se toma en cuenta el monto que se desea aprobar
				if (peticion.getSolicitudSACG().getNuevoCreditoSolicitado() != null) {
					montoExposicionPorMes = montoExposicionPorMes
							+ peticion.getSolicitudSACG()
									.getNuevoCreditoSolicitado();
				}

				LogHandler.info(uid, getClass(),
						"validacionCuposYMontosCampana=> montoExposicionPorMes: "
								+ sucursal.getMontoMesCampania()
								+ "\tmontoExposicionPorMesAprobBuz:"
								+ montoExposicionPorMes);

				montoExpocicionDisponible = sucursal.getMontoMesCampania()
						- montoExposicionPorMes;

				if (montoExposicionPorMes > sucursal.getMontoMesCampania()) {
					excedeMonto = true;
					respuesta = Constantes.TIPO_TAREA_MONTO
							+ "La Suma de los Montos ingresados en los cupos rebasa el"
							+ " Monto de Exposición en el mes por Campaña."
							+ " El monto máximo es de "
							+ sucursal.getMontoMesCampania() + " . "
							+ "¿Desea generar una excepción?" + msjPopUp;
				}

				// validacion 3: supera el número disponible de Cupos Campaña y
				// supera el Monto de Exposición
				if (excedeMonto && excedeCupo) {
					respuesta = Constantes.TIPO_TAREA_CUPO_MONTO
							+ "La Solicitud con campaña que intenta"
							+ " registrar supera el número máximo"
							+ " de \"Cupos Campaña\" y \"Monto de Exposición en el mes\" en Sucursal."
							+ " El número de \"Cupos Campaña\" máximo es "
							+ sucursal.getCuposCampana()
							+ " y el \"Monto máximo de exposición en el mes\" máximo es "
							+ sucursal.getMontoMesCampania()
							+ " . ¿Desea generar una excepción?" + msjPopUp;
					return respuesta;
				}

				if (excedeMonto || excedeCupo) {
					return respuesta;
				} else {
					// validacion 7: En el caso de que se registre exitosamente
					// un cupo campaña y el monto de
					// exposición en el mes sea inferior al permitido en
					// sucursal
					if (cuposCampanaDisponible > 0
							&& montoExpocicionDisponible > 0.0) {
						respuesta = " Cupos Disponibles \""
								+ cuposCampanaDisponible
								+ "\"  y  Monto de exposición en el mes"
								+ " por campaña Disponibles \""
								+ montoExpocicionDisponible + "\""
								+ msjInformativo;
					}
				}
			}

		} catch (Exception e) {
			LogHandler
					.error(uid,
							getClass(),
							"validacionCuposYMontosCampana - Ocurrio un error debido a:  ",
							e);
			respuesta = e.getMessage();
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * Actualiza los esttus de la tarea excepcion campaña.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            the excepcion garantia peticion
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta actualizarTareaCampana(String uid,
			ExcepcionGarantiaPeticion peticion) {

		ExcepcionGarantiaRespuesta respuesta = new ExcepcionGarantiaRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionTx = null;
		// variable donde se almacena a que perfil se le envia correo
		String perfilCorreo = null;
		// variable que sirve para actualizar la tarea
		String perfilAutoriza = null;
		String estatus = null;

		try {
			sesionTx = FabricaConexiones.obtenerSesionTx();

			if (peticion == null || peticion.getEstatusAut() == null
					|| peticion.getEstatusAut().trim().isEmpty()
					|| peticion.getSolicitud() == null
					|| peticion.getSolicitud().trim().isEmpty()
					|| peticion.getSucursal() == null
					|| peticion.getSucursal().trim().isEmpty()
					|| peticion.getPerfil() == null
					|| peticion.getPerfil().trim().isEmpty()
					|| peticion.getIdTarea() == null
					|| peticion.getIdTarea() == 0
					|| peticion.getUsuarioAut() == null
					|| peticion.getUsuarioAut().trim().isEmpty()) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}

			final java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();
			HashMap<String, Object> valoresJDNI = new HashMap<String, Object>();
			valoresJDNI = obtenerMapaJdni(uid, "PERFIL_REGIONAL",
					"PERFIL_DIVISIONAL", "PERFIL_RIESGO");
			List<String> perfilRegional = Validaciones.obtenerListaCodigos(uid,
					valoresJDNI.get("PERFIL_REGIONAL").toString());
			List<String> perfilDivisional = Validaciones.obtenerListaCodigos(
					uid, valoresJDNI.get("PERFIL_DIVISIONAL").toString());
			List<String> perfilRiesgo = Validaciones.obtenerListaCodigos(uid,
					valoresJDNI.get("PERFIL_RIESGO").toString());

			if (perfilRegional == null || perfilRegional.size() == 0
					|| perfilDivisional == null || perfilDivisional.size() == 0
					|| perfilRiesgo == null || perfilRiesgo.size() == 0) {
				throw new Exception(
						"No se pudieron recuperar los valores de las JDNI: PERFIL_REGIONAL,"
								+ " PERFIL_DIVISIONAL, PERFIL_RIESGO");
			}

			// checar el perfil
			if (perfilRegional.contains(peticion.getPerfil())) {
				// varable que se llena para el correo
				perfilCorreo = Constantes.CORREO_DIVISIONAL;
				perfilAutoriza = Constantes.CORREO_REGIONAL;

			} else if (perfilDivisional.contains(peticion.getPerfil())) {
				perfilCorreo = Constantes.CORREO_RIESGO;
				perfilAutoriza = Constantes.CORREO_DIVISIONAL;

			} else if (perfilRiesgo.contains(peticion.getPerfil())) {
				perfilAutoriza = Constantes.CORREO_RIESGO;
			}

			if (peticion.getEstatusAut() != null) {
				estatus = peticion.getEstatusAut().substring(0,
						Constantes.LIMITE_STATUS);
			}

			// envio de correo de notificacio si es que es divisional o de
			// riesgo
			if (peticion.getEstatusAut().equals(
					Constantes.ATOMO_EXCEPCION_GARANTIA_OK)) {
				enviarCorreoPorPerfil(uid, peticion, perfilCorreo);
			}

			// actualizacion de tareas_excepcion_campania
			parametros.put("idTarea", peticion.getIdTarea());
			parametros.put("solicitud", peticion.getSolicitud());
			parametros.put("status", estatus);
			parametros.put("statusInicial", peticion.getEstatusAut().charAt(0)
					+ "");
			parametros.put("perfilAutoriza", perfilAutoriza);
			parametros.put("personAutoriza", peticion.getUsuarioAut());
			parametros.put(
					"observaciones",
					peticion.getObservaciones() != null ? peticion
							.getObservaciones() : "");
			LogHandler.info(uid, getClass(),
					"actualizarTareaCampana parametros: " + parametros);

			sesionTx.update("actualizarBuzonTareaCampania", parametros);

			// actualizacion buzon_tareas
			if (peticion.getEstatusAut().equals(
					Constantes.ATOMO_EXCEPCION_GARANTIA_RECHAZO)
					|| (perfilAutoriza.equals(Constantes.CORREO_RIESGO) && peticion
							.getEstatusAut().equals(
									Constantes.ATOMO_EXCEPCION_GARANTIA_OK))) {
				sesionTx.update("actualizarBuzonTarea", parametros);

				// Atomo ATOMO_EXCEPCION_GARANTIA
				AtomosOV peticionAtomo = new AtomosOV();
				peticionAtomo.setSolicitud(peticion.getSolicitud());
				peticionAtomo.setProceso(Constantes.ATOMO_EXCEPCION_CUPO_MONTO);
				peticionAtomo.setCodigoResolucion(peticion.getEstatusAut());
				peticionAtomo.setComentario("");
				peticionAtomo.setStatus("A");
				peticionAtomo.setUsuarioGeneroAtomo(peticion.getUsuarioAut());
				peticionAtomo.setIdTarea(peticion.getIdTarea());
				AtomosRespuesta atomosRespuesta = registrarAtomosExceptionTarea(
						uid, sesionTx, peticionAtomo);

				if (!atomosRespuesta.getHeader().isEstatus()) {
					throw new Exception("ATOMO_EXCEPCION_GARANTIA:"
							+ atomosRespuesta.getHeader().getMensaje());
				}
			}
			sesionTx.commit();

		} catch (Exception e) {
			FabricaConexiones.rollBack(sesionTx);
			LogHandler.error(uid, getClass(),
					"Error en actualizarTareaCampana: " + e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionTx);
		}
		return respuesta;
	}

	/**
	 * Actualiza los esttus de la tarea excepcion campaña.
	 *
	 * @param uid
	 *            the uid
	 * @return the the excepcion garantia respuesta
	 */
	@SuppressWarnings("unchecked")
	public ExcepcionGarantiaRespuesta actualizacionAutomaticaTareaCampana(
			String uid) {
		LogHandler
				.info(uid, getClass(),
						"------Entrando al metodo actualizacionAutomaticaTareaCampana -------");
		ExcepcionGarantiaRespuesta respuesta = new ExcepcionGarantiaRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionNTx = null;
		List<ExcepcionGarantiaPeticion> listaReginal = null;
		List<ExcepcionGarantiaPeticion> listaDivisional = null;

		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			// obtencion de las jdni de tiempo
			HashMap<String, Object> valoresJDNI = new HashMap<String, Object>();
			valoresJDNI = obtenerMapaJdni(uid, "TIEMPO_ESPERA_REGIONAL",
					"TIEMPO_ESPERA_DIVISIONAL");
			int tiempoEsperaRegional = Integer.parseInt(valoresJDNI.get(
					"TIEMPO_ESPERA_REGIONAL").toString());
			int tiempoEsperaDivisional = Integer.parseInt(valoresJDNI.get(
					"TIEMPO_ESPERA_DIVISIONAL").toString());

			if (tiempoEsperaRegional == 0 || tiempoEsperaDivisional == 0) {
				throw new Exception(
						"No se pudo recuperar la JDNI:TIEMPO_ESPERA_REGIONAL, TIEMPO_ESPERA_DIVISIONAL");
			}
			LogHandler.info(uid, getClass(),
					"actualizacionAutomaticaTareaCampana-"
							+ " tiempoEsperaRegional: " + tiempoEsperaRegional
							+ " \ntiempoEsperaDivisional: "
							+ tiempoEsperaDivisional);

			// solicitudes con un tiempo mayor o igual a 30 min que no han sido
			// aprobadas por el regional
			listaReginal = (List<ExcepcionGarantiaPeticion>) sesionNTx
					.selectList("actualizacionAutomaticaRegional",
							tiempoEsperaRegional);

			if (listaReginal != null && listaReginal.size() > 0) {
				for (ExcepcionGarantiaPeticion peticion : listaReginal) {
					peticion.setObservaciones("Actualizacion automatica del sistema");
					peticion.setEstatusAut("APROBADA");
					peticion.setPerfil(Constantes.PUESTO_REGIONAL);
					peticion.setUsuarioAut(Constantes.USUARIO_SISTEMA);

					respuesta = actualizarTareaCampana(uid, peticion);

					if (respuesta != null && !respuesta.getHeader().isEstatus()) {
						LogHandler.info(uid, getClass(),
								"Ocurrio una error al actualizar al regional id_tarea: "
										+ peticion.getIdTarea()
										+ " Mensaje Error: "
										+ respuesta.getHeader().getMensaje());
					}
				}
			} else {
				LogHandler.info(uid, getClass(),
						"No hay solicitudes para actualizar al regional....");
			}
			// solicitudes con un tiempo mayor o igual a 10000 min que no han
			// sido aprobadas por el divisional
			listaDivisional = (List<ExcepcionGarantiaPeticion>) sesionNTx
					.selectList("actualizacionAutomaticaDivisional",
							tiempoEsperaDivisional);

			if (listaDivisional != null && listaDivisional.size() > 0) {
				for (ExcepcionGarantiaPeticion peticion : listaDivisional) {
					peticion.setObservaciones("Actualizacion automatica del sistema");
					peticion.setEstatusAut("APROBADA");
					peticion.setPerfil(Constantes.PUESTO_DIVISIONAL);
					peticion.setUsuarioAut(Constantes.USUARIO_SISTEMA);

					respuesta = actualizarTareaCampana(uid, peticion);

					if (respuesta != null && !respuesta.getHeader().isEstatus()) {
						LogHandler.info(uid, getClass(),
								"Ocurrio una error al actualizar al divisional id_tarea: "
										+ peticion.getIdTarea()
										+ " Mensaje Error: "
										+ respuesta.getHeader().getMensaje());
					}
				}
			} else {
				LogHandler
						.info(uid, getClass(),
								"No hay solicitudes para actualizar al divisional por el momento....");
			}

		} catch (Exception e) {
			LogHandler.error(
					uid,
					getClass(),
					"Error en actualizacionAutomaticaTareaCampana: "
							+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	@SuppressWarnings("unchecked")
	public ConsultaCatalogoRespuestaCIOF consultaCatalogoRegiones(String uid,
			ConsultaCatalogoPeticionCIOF peticion) {

		LogHandler
				.info(uid, this.getClass(),
						"consultaCatalogo: entrando al metodo consultaCatalogoRegiones");

		ConsultaCatalogoRespuestaCIOF respuesta = new ConsultaCatalogoRespuestaCIOF();
		respuesta.setHeader(new EncabezadoRespuesta());
		SqlSession sesionNTx = null;
		List<CatalogosOV> regionesList = null;
		List<CatalogosOV> regionesListRespuesta = null;

		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			regionesList = (List<CatalogosOV>) sesionNTx
					.selectList("obtenCatalogoRegiones");
			if (regionesList == null || regionesList.size() <= 0) {
				throw new Exception("Lista de Regiones null o vacia.");
			} else {
				regionesListRespuesta = new ArrayList<CatalogosOV>();
				for (CatalogosOV catalogosOV : regionesList) {
					if (catalogosOV.getDescripcion().contains("CERRADAS")) {
						catalogosOV.setDescripcion("TODAS");
					}
					regionesListRespuesta.add(catalogosOV);
				}
			}
			respuesta.setCatalogo(regionesListRespuesta);
			respuesta.getHeader().setEstatus(true);
			respuesta.getHeader().setMensaje("Respuesta Exitosa");

		} catch (Exception ex) {
			respuesta.getHeader().setMensaje(
					"Ocurrio un error al obtener el catalogo de Regiones "
							+ ex.getMessage());
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setUID(uid);
			LogHandler.error(
					uid,
					this.getClass(),
					"Ocurrio un error al obtener el catalogo de Regiones "
							+ ex.getMessage(), ex);
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * metodo que recupera si se teinen tareas pendientes
	 * 
	 * @param uid
	 *            id unico de transaccion
	 * @param solicitudSACG
	 *            id unico de la solicitud
	 * @param tipoTarea
	 *            tipo tarea que se busca
	 * @return int numero de tareas pendientes
	 */
	public int tareasPendientes(String uid, SolicitudSACG solicitudSACG,
			String tipoTarea) {
		int tareasPendientes = 0;
		final HashMap<String, Object> parametrosDiasMora = new HashMap<String, Object>();
		SqlSession sesionNTx = null;
		try {
			// Se abre la sesion No transaccional sybase
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if (solicitudSACG != null && solicitudSACG.getId() != null
					&& !solicitudSACG.getId().trim().isEmpty()) {

				parametrosDiasMora.put("solicitud", solicitudSACG.getId());
				parametrosDiasMora.put("tipoTarea", tipoTarea);

				tareasPendientes = (Integer) sesionNTx.selectOne(
						"obtenerTareasPendientesBuzon", parametrosDiasMora);
				LogHandler.info(uid, this.getClass(),
						"tareasPendientes--tareaspendientes: "
								+ tareasPendientes);

				if (tipoTarea.equals(Constantes.TAREA_DOCUMENTAL)) {
					if (tareasPendientes > 0) {
						if (solicitudSACG.getFechaAsignacionDocumental() != null) {
							solicitudSACG.setTareaDocumentalPendiente(1);
						} else {
							solicitudSACG
									.setTareaDocumentalPendiente(tareasPendientes);
						}
					} else {
						if (solicitudSACG.getFechaAsignacionDocumental() != null) {
							solicitudSACG.setTareaDocumentalPendiente(1);
						} else {
							solicitudSACG.setTareaDocumentalPendiente(0);
						}
					}
				}
			}

		} catch (Exception ex) {
			LogHandler.error(uid, getClass(),
					"tareasPendientes: " + ex.getMessage(), ex);
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return tareasPendientes;
	}

	/**
	 * método que obtiene el detalle de la solicitud con excepción de monto y
	 * cupo
	 * 
	 * @param uid
	 *            id unico de transaccion
	 * @param idTarea
	 *            idTarea donde viene el numero de idTarea
	 * @return ExcepcionMontoCupoRespuesta
	 */
	public ExcepcionMontoCupoRespuesta consultaSolicitudExcepcionMontoCupoTarea(
			String uid, String idTarea) {
		// obtenerDetalleSolicitudExcepcionCupoMonto
		ExcepcionMontoCupoRespuesta respuesta = new ExcepcionMontoCupoRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;

		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();

			parametros.put("idTarea", Integer.parseInt(idTarea));
			ExcepcionMontoCupoOV respuestaExcepcion = (ExcepcionMontoCupoOV) sesionNTx
					.selectOne("obtenerDetalleSolicitudExcepcionCupoMonto",
							parametros);

			if (respuestaExcepcion != null) {
				respuesta.setSolicitudExcepciones(respuestaExcepcion);
			} else {
				throw new Exception("No hay resultados para la consulta");
			}

		} catch (Exception ex) {
			LogHandler.error(
					uid,
					getClass(),
					"consultaSolicitudExcepcionMontoCupoTarea: "
							+ ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ERROR_CONSULTA);
			respuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}

		return respuesta;
	}

	/**
	 * metodo que obtiene el catalogo de asesores de credito
	 * 
	 * @param uid
	 *            id de transaccion
	 * @param peticion
	 *            peticion
	 * @return ConsultaCatalogoRespuestaCIOF
	 */
	@SuppressWarnings("unchecked")
	public ConsultaCatalogoRespuestaCIOF consultarCatalogoAsesoresCredito(
			String uid, ConsultaCatalogoPeticionCIOF peticion) {
		LogHandler.info(
				uid,
				this.getClass(),
				"consultaCatalogo: entrando al metodo"
						+ " consultaCatalogoAsesoresCredito: "
						+ peticion.getSucursal());

		ConsultaCatalogoRespuestaCIOF respuesta = new ConsultaCatalogoRespuestaCIOF();
		respuesta.setHeader(new EncabezadoRespuesta());
		SqlSession sesionNTx = null;
		List<CatalogosOV> asesoresList = null;
		CatalogosOV catalogosOV = null;
		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			asesoresList = (List<CatalogosOV>) sesionNTx.selectList(
					"obtenerCatalogoAsesoresCredito", peticion.getSucursal());
			if (asesoresList == null || asesoresList.size() <= 0) {
				throw new Exception("Lista de asesores  null o vacia.");
			} else {
				catalogosOV = new CatalogosOV();
				catalogosOV.setCodigo("0");
				catalogosOV.setDescripcion("SIN ASESOR");
				asesoresList.add(catalogosOV);
			}
			respuesta.setCatalogo(asesoresList);
			respuesta.getHeader().setEstatus(true);
			respuesta.getHeader().setMensaje("Respuesta Exitosa");

		} catch (Exception ex) {
			respuesta.getHeader().setMensaje(
					"Ocurrio un error al obtener" + " el catalogo de asesores "
							+ ex.getMessage());
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setUID(uid);
			LogHandler.error(uid, this.getClass(),
					"Ocurrio un error al obtener" + " el catalogo de asesores "
							+ ex.getMessage(), ex);
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * metodo que obtiene el catalogo de gerentes de sucursales
	 * 
	 * @param uid
	 *            id de transaccion
	 * @param peticion
	 *            peticion
	 * @return ConsultaCatalogoRespuestaCIOF
	 */
	@SuppressWarnings("unchecked")
	public ConsultaCatalogoRespuestaCIOF consultarCatalogoGerenteSucursal(
			String uid, ConsultaCatalogoPeticionCIOF peticion) {
		LogHandler.info(
				uid,
				this.getClass(),
				"consultaCatalogo: entrando al metodo"
						+ " consultaCatalogoGerenteSucursal: "
						+ peticion.getSucursal());

		ConsultaCatalogoRespuestaCIOF respuesta = new ConsultaCatalogoRespuestaCIOF();
		respuesta.setHeader(new EncabezadoRespuesta());
		SqlSession sesionNTx = null;
		List<CatalogosOV> gerentesSucursalesList = null;
		CatalogosOV catalogosOV = null;
		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			gerentesSucursalesList = (List<CatalogosOV>) sesionNTx
					.selectList("obtenerCatalogoGerentesSucursales",
							peticion.getSucursal());
			if (gerentesSucursalesList == null
					|| gerentesSucursalesList.size() <= 0) {
				throw new Exception(
						"Lista de gerentes de sucursales null o vacia.");
			} else {
				catalogosOV = new CatalogosOV();
				catalogosOV.setCodigo("0");
				catalogosOV.setDescripcion("SIN GERENTE SUCURSAL");
				gerentesSucursalesList.add(catalogosOV);
			}
			respuesta.setCatalogo(gerentesSucursalesList);
			respuesta.getHeader().setEstatus(true);
			respuesta.getHeader().setMensaje("Respuesta Exitosa");

		} catch (Exception ex) {
			respuesta.getHeader().setMensaje(
					"Ocurrio un error al obtener"
							+ " el catalogo de gerentes de sucursales "
							+ ex.getMessage());
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setUID(uid);
			LogHandler.error(
					uid,
					this.getClass(),
					"Ocurrio un error al obtener"
							+ " el catalogo de gerentes de sucursales "
							+ ex.getMessage(), ex);
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * metodo que obtiene el catalogo de gerentes regionales
	 * 
	 * @param uid
	 *            id de transaccion
	 * @param peticion
	 *            peticion
	 * @return ConsultaCatalogoRespuestaCIOF
	 */
	@SuppressWarnings("unchecked")
	public ConsultaCatalogoRespuestaCIOF consultarCatalogoGerentesRegionales(
			String uid, ConsultaCatalogoPeticionCIOF peticion) {
		LogHandler.info(
				uid,
				this.getClass(),
				"consultaCatalogo: entrando al metodo"
						+ " consultaCatalogoGerentesRegionales: "
						+ peticion.getSucursal());

		ConsultaCatalogoRespuestaCIOF respuesta = new ConsultaCatalogoRespuestaCIOF();
		respuesta.setHeader(new EncabezadoRespuesta());
		SqlSession sesionNTx = null;
		List<CatalogosOV> regionalesList = null;
		CatalogosOV catalogosOV = null;
		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			regionalesList = (List<CatalogosOV>) sesionNTx
					.selectList("obtenerCatalogoGerentesRegionales",
							peticion.getSucursal());
			if (regionalesList == null || regionalesList.size() <= 0) {
				throw new Exception(
						"Lista de gerentes regionales null o vacia.");
			} else {
				catalogosOV = new CatalogosOV();
				catalogosOV.setCodigo("0");
				catalogosOV.setDescripcion("SIN GERENTE REGIONAL");
				regionalesList.add(catalogosOV);
			}
			respuesta.setCatalogo(regionalesList);
			respuesta.getHeader().setEstatus(true);
			respuesta.getHeader().setMensaje("Respuesta Exitosa");

		} catch (Exception ex) {
			respuesta.getHeader().setMensaje(
					"Ocurrio un error al obtener"
							+ " el catalogo de gerentes regionales "
							+ ex.getMessage());
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setUID(uid);
			LogHandler.error(
					uid,
					this.getClass(),
					"Ocurrio un error al obtener"
							+ " el catalogo de gerentes regionales "
							+ ex.getMessage(), ex);
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * Metodo que realiza las validaciones de producto Oportunidad para
	 * Simplificacion de renovacion.
	 */
	@SuppressWarnings("unused")
	public ContratoRenovacionRespuesta validarSimplificacionRenovacionProductos(
			String uid, ContratoRenovacionPeticion peticion) {
		LogHandler
				.info(uid, this.getClass(),
						"Entrando al metodo validarSimplificacionRenovacionProductos...");
		ContratoRenovacionRespuesta respuesta = new ContratoRenovacionRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		Date fechaValor = null;
		StringBuffer sb = null;
		int integrantesOriginales = 0;
		int porcentajePermitido = 0;
		double calculoPorcentaje = 0;

		try {
			LogHandler.info(uid, this.getClass(),
					"Contrato: " + peticion.getContrato());
			if (peticion.getContrato() == null
					|| peticion.getContrato().trim().isEmpty()) {
				LogHandler
						.info(uid, this.getClass(),
								"ERROR: El contrato es obligatorio para realizar la consulta.");
				throw new Exception(
						"El contrato es obligatorio para realizar la consulta.");
			}
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			// SRH Simplificacion de renovacion fase 2
			int diasMoraProductoOportunidad = Integer
					.valueOf(
							comun.obtenerParGeneralOV(uid,
									"mx.com.finsol.kitimpresion.formatos.oportunidad.dias.mora")
									.getCgValor()).intValue();
			// int diasMoraProductoOportunidad = 7;
			LogHandler.info(uid, this.getClass(),
					"diasMoraProductoOportunidad: "
							+ diasMoraProductoOportunidad);

			int cicloIntegrantesProductoOportunidad = Integer
					.valueOf(
							comun.obtenerParGeneralOV(uid,
									"mx.com.finsol.kitimpresion.formatos.oportunidad.ciclo.integrante")
									.getCgValor()).intValue();
			// int cicloIntegrantesProductoOportunidad = 3;
			LogHandler.info(uid, this.getClass(),
					"cicloIntegrantesProductoOportunidad: "
							+ cicloIntegrantesProductoOportunidad);

			int cicloGrupoProductoOportunidad = Integer
					.valueOf(
							comun.obtenerParGeneralOV(uid,
									"mx.com.finsol.kitimpresion.formatos.oportunidad.ciclo.grupo")
									.getCgValor()).intValue();
			// int cicloGrupoProductoOportunidad = 3;
			LogHandler.info(uid, this.getClass(),
					"cicloGrupoProductoOportunidad: "
							+ cicloGrupoProductoOportunidad);

			int minimoIntegrantesProductoOportunidad = Integer
					.valueOf(
							comun.obtenerParGeneralOV(uid,
									"mx.com.finsol.kitimpresion.formatos.oportunidad.minimo.integrantes")
									.getCgValor()).intValue();
			// int minimoIntegrantesProductoOportunidad = 2;
			LogHandler.info(uid, this.getClass(),
					"minimoIntegrantesProductoOportunidad: "
							+ minimoIntegrantesProductoOportunidad);

			int maximoIntegrantesProductoOportunidad = Integer
					.valueOf(
							comun.obtenerParGeneralOV(uid,
									"mx.com.finsol.kitimpresion.formatos.oportunidad.maximo.integrantes")
									.getCgValor()).intValue();
			// int maximoIntegrantesProductoOportunidad = 50;
			LogHandler.info(uid, this.getClass(),
					"maximoIntegrantesProductoOportunidad: "
							+ maximoIntegrantesProductoOportunidad);

			int diasFechaLiquidacion = Integer.valueOf(
					comun.obtenerParGeneralOV(uid,
							"mx.com.findep.finsol.kitrenovacion.semanas")
							.getCgValor()).intValue()
					* Constantes.DIAS_SEMANA;

			// Validar si existe el contrato
			String numeroContrato = comun.obtenerNumeroContrato(uid,
					peticion.getContrato());

			// Validaciones
			if (numeroContrato == null || numeroContrato.isEmpty()) {
				LogHandler.info(uid, this.getClass(),
						"ERROR: El Número de Contrato ingresado no existe.");
				throw new Exception(
						"El Número de Contrato ingresado no existe.");
			}

			FechaContableOV datosFechaContable = comun
					.obtenerFechaContable(uid);

			Date fechaCont = datosFechaContable.getFecha();
			Calendar cal = new GregorianCalendar();
			cal.setTimeInMillis(fechaCont.getTime());
			fechaValor = cal.getTime();
			LogHandler.info(uid, this.getClass(), "fechaValor. " + fechaValor);

			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("contrato", numeroContrato);
			params.put("fechaActual", fechaValor);

			if (peticion.getCodigo().equals(CatalogoFormatos.SOCO.getSiglas())) {
				params.put("oportunidad", true);
			} else {
				params.put("oportunidad", false);
			}

			respuesta = (ContratoRenovacionRespuesta) sesionNTx.selectOne(
					"validarDatosContratoSimplificacion", params);

			if (respuesta == null) {
				respuesta = new ContratoRenovacionRespuesta();
				respuesta.setHeader(new EncabezadoRespuesta());
				respuesta.getHeader().setUID(uid);
				respuesta.getHeader().setEstatus(true);
				LogHandler
						.info(uid,
								this.getClass(),
								"ERROR: Para generar los formatos,"
										+ " es necesario que el contrato actual esté activo.");
				throw new Exception("Para generar los formatos,"
						+ " es necesario que el contrato actual esté activo.");
			}

			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setEstatus(true);

			if (peticion.getProducto()
					.equals(CatalogoFormatos.SOLI.getSiglas())
					|| peticion.getProducto().equals(
							CatalogoFormatos.COMU.getSiglas())) {
				// Validacion de prospecto
				if (respuesta.getDiasFaltantesLiquidacion() > diasFechaLiquidacion) {
					respuesta.setMostrarInformacion(true);
					throw new Exception(
							"No se puede generar los formatos porque el grupo no cumple con la regla de renovación "
									+ "(4 semanas o 2 catorcenas).");
				}

			} else {
				// Validacion dias mora
				if (respuesta.getDiasMora() > diasMoraProductoOportunidad) {
					LogHandler.info(uid, this.getClass(),
							"ERROR: Para generar los formatos, es necesario que"
									+ " el contrato no presente más de "
									+ diasMoraProductoOportunidad
									+ " días mora.");
					throw new Exception(
							"Para generar los formatos, es necesario que"
									+ " el contrato no presente más de "
									+ diasMoraProductoOportunidad
									+ " días mora.");
				}
				// Validacion de cicloGrupo
				if (respuesta.getCiclo() < cicloGrupoProductoOportunidad) {
					LogHandler.info(uid, this.getClass(),
							"ERROR: El grupo tiene menos de "
									+ cicloGrupoProductoOportunidad
									+ " ciclos en FINSOL."
									+ " No se pueden generar los formatos.");
					throw new Exception("El grupo tiene menos de "
							+ cicloGrupoProductoOportunidad
							+ " ciclos en FINSOL."
							+ " No se pueden generar los formatos.");
				}

				params.clear();
				params.put("contrato", numeroContrato);
				@SuppressWarnings("unchecked")
				List<IntegrantesKit> integrantes = (List<IntegrantesKit>) sesionNTx
						.selectList("validarIntegrantesContratoSimplificacion",
								params);
				if (integrantes == null) {
					LogHandler.info(uid, this.getClass(),
							"ERROR: No fue posible obtener los integrantes.");
					throw new Exception(
							"No fue posible obtener los integrantes.");
				} else {

					if (peticion.getCodigo().equals(
							CatalogoFormatos.SOCO.getSiglas())) {
						List<String> integrantesCicloMenor = new ArrayList<String>();
						for (String personaOportunidad : peticion
								.getArrayPersonas()) {
							for (IntegrantesKit integrante : integrantes) {
								if (integrante.getPersona().equals(
										personaOportunidad)) {
									if (integrante.getCicloClienteGrupo() < cicloIntegrantesProductoOportunidad) {
										LogHandler
												.info(uid,
														this.getClass(),
														integrante.getPersona()
																+ ", su ciclo es:  "
																+ integrante
																		.getCicloClienteGrupo());
										integrantesCicloMenor.add(integrante
												.getNombre());
									}
								}
							}
						}

						if (integrantesCicloMenor == null) {
							LogHandler.info(uid, this.getClass(),
									"Sin integrantes Ciclo Menor.");
						} else if (integrantesCicloMenor.size() > 0) {
							sb = new StringBuffer();
							sb.append("Los integrantes: ");
							for (String nombre : integrantesCicloMenor) {
								sb.append("" + nombre + ", ");
							}
							sb.append(" tiene(n) menos de "
									+ cicloIntegrantesProductoOportunidad
									+ " ciclos en FINSOL.");
							sb.append(" No se puede generar los formatos.");
							LogHandler.info(uid, this.getClass(), "ERROR: "
									+ sb.toString());
							throw new Exception(sb.toString());
						}
					}

					if (peticion.getCodigo().equals(
							CatalogoFormatos.SOCO.getSiglas())) {
						if (peticion.getArrayPersonas().length < minimoIntegrantesProductoOportunidad) {
							LogHandler
									.info(uid,
											this.getClass(),
											"ERROR: Se requiere al menos "
													+ minimoIntegrantesProductoOportunidad
													+ " integrantes para la generación de formatos del producto Oportunidad.");
							throw new Exception(
									"Se requiere al menos "
											+ minimoIntegrantesProductoOportunidad
											+ " integrantes"
											+ " para la generación de formatos del producto Oportunidad.");
						}
					}

					LogHandler.info(uid, this.getClass(),
							"Validar Porcentaje: " + peticion.isPorcentaje());
					if (peticion.isPorcentaje()) {
						calculoPorcentaje = integrantes.size()
								* maximoIntegrantesProductoOportunidad
								/ PORCENTAJE_INTEGRANTES;
						LogHandler.info(uid, this.getClass(), "El "
								+ maximoIntegrantesProductoOportunidad
								+ " % de " + integrantes.size() + " es "
								+ calculoPorcentaje);

						if (peticion.getArrayPersonas().length > calculoPorcentaje) {
							LogHandler
									.info(uid,
											this.getClass(),
											"ERROR: Los integrantes seleccionados rebasa el "
													+ maximoIntegrantesProductoOportunidad
													+ " % de integrantes que pueden recibir un crédito oportunidad,"
													+ " de acuerdo al número de integrantes del contrato actual / anterior.");
							throw new Exception(
									"Los integrantes seleccionados rebasa el "
											+ maximoIntegrantesProductoOportunidad
											+ " % de integrantes que pueden recibir un crédito oportunidad,"
											+ " de acuerdo al número de integrantes del contrato actual / anterior.");
						}
					}

				}
			}

			LogHandler.info(uid, this.getClass(), "Validaciones OK.");
			respuesta.getHeader().setMensaje("Validaciones OK.");
		} catch (Exception ex) {
			LogHandler.error(
					uid,
					this.getClass(),
					"validarSimplificacionRenovacionProductos "
							+ ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}

		return respuesta;
	}

	/**
	 * metodo que recupera si ya tubo una tarea aprobada
	 * 
	 * @param uid
	 *            id unico de transaccion
	 * @param solicitudSACG
	 *            id unico de la solicitud
	 * @param tipoTarea
	 *            tipo tarea que se busca
	 * @return int numero de tareas pendientes
	 */
	public int tareasAprobadas(String uid, SolicitudSACG solicitudSACG,
			String tipoTarea) {
		int tareasAprobadas = 0;
		final HashMap<String, Object> parametrosDiasMora = new HashMap<String, Object>();
		SqlSession sesionNTx = null;
		try {
			// Se abre la sesion No transaccional sybase
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if (solicitudSACG != null && solicitudSACG.getId() != null
					&& !solicitudSACG.getId().trim().isEmpty()) {

				parametrosDiasMora.put("solicitud", solicitudSACG.getId());
				parametrosDiasMora.put("tipoTarea", tipoTarea);

				tareasAprobadas = (Integer) sesionNTx.selectOne(
						"obtenerTareasAprobadas", parametrosDiasMora);
				LogHandler.info(uid, this.getClass(),
						"tareasAprobadas:obtenerTareasAprobadas"
								+ tareasAprobadas);

			} else {
				LogHandler.info(uid, this.getClass(),
						"tareasAprobadas: no hay solicitud generada aun.");
			}

		} catch (Exception ex) {
			LogHandler.error(uid, getClass(),
					"tareasAprobadas: " + ex.getMessage(), ex);
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return tareasAprobadas;
	}

	/**
	 * Método que se utiliza para consultar las solicitudes que se van a
	 * reactivar
	 *
	 * @param uid
	 *            uid
	 * @param peticion
	 *            tipo ReactivarSolicitudesPeticion
	 * @return ReactivarSolicitudesRespuesta tipo ReactivarSolicitudesRespuesta
	 */
	public ReactivarSolicitudesRespuesta consultaReactivarSolicitudesTarea(
			String uid, ReactivarSolicitudesPeticion peticion) {

		ReactivarSolicitudesRespuesta respuesta = new ReactivarSolicitudesRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;

		try {
			// Se abre la conexion hacia la base de datos
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			LogHandler.info(uid, getClass(),
					"==> sucursal " + peticion.getSucursal());

			ParGeneralOV dias = comun.obtenerParGeneralOV(uid,
					"DIAS_REACTIVAR_SOLICITUDES");
			if (dias == null || dias.getCgValor().trim().isEmpty()) {
				throw new Exception(
						"No se pudo recuperar la jdni DIAS_REACTIVAR_SOLICITUDES.");
			}

			final java.util.HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("sucursal", Integer.parseInt(peticion.getSucursal()));
			param.put("dia", Integer.parseInt(dias.getCgValor()));

			if (peticion.getAccion().equals("consulta")) {

				final List<ReactivarSolicitudes> listaSolicitudes = (List<ReactivarSolicitudes>) sesionNTx
						.selectList("obtenerReactivarSolicitudes", param);

				if (listaSolicitudes.size() == 0) {
					throw new Exception(
							"No se obtuvieron resultados para la consulta de reactivación de solicitudes ");
				}

				respuesta.setReactivarSolicitudes(listaSolicitudes);

			} else if (peticion.getAccion().equals("consultaObservacion")) {

				final java.util.HashMap<String, Object> parameters = new HashMap<String, Object>();
				parameters.put("sucursal",
						Integer.parseInt(peticion.getSucursal()));
				parameters.put("dia", Integer.parseInt(dias.getCgValor()));
				parameters.put("solicitud", peticion.getSolicitud());

				final List<ReactivarSolicitudes> listaComentarios = (List<ReactivarSolicitudes>) sesionNTx
						.selectList("obtenerComentariosReactivarSolicitudes",
								parameters);

				if (listaComentarios.size() == 0) {
					ReactivarSolicitudes comentarios = new ReactivarSolicitudes();
					comentarios.setSolicitud(peticion.getSolicitud());
					comentarios.setComentario("SIN COMENTARIOS");
					comentarios.setObservacion("SIN OBSERVACION");
					comentarios.setMotivoCancelacion("SIN MOTIVO");

					listaComentarios.add(comentarios);
				}
				respuesta.setReactivarSolicitudes(listaComentarios);
			}
		} catch (Exception ex) {
			LogHandler
					.error(uid,
							getClass(),
							"consultaReactivarSolicitudesTarea: "
									+ ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(
					"Se ha producido un erro al momento de la consulta de reactivar solicitudes  "
							+ ex.getMessage());
			respuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * Metodo que se utilizar para volver a insertar y reactivar la solicitud.
	 *
	 * @param uid
	 *            uid
	 * @param solicitud
	 *            solicitud a reactivar
	 * @param usuario
	 *            que genera la reactivacion
	 * @return ReactivarSolicitudesRespuesta tipo ReactivarSolicitudesRespuesta
	 */
	public ReactivarSolicitudesRespuesta insertaReactivarSolicitudesTarea(
			String uid, String solicitud, String usuario) {

		ReactivarSolicitudesRespuesta respuesta = new ReactivarSolicitudesRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionTx = null;
		SqlSession sesionNTx = null;
		int insertaSolicitud = 0;
		int insertaCliente = 0;
		List<SolicitudesOV> solicitudesOV = null;
		try {
			// Se abre la conexion hacia la base de datos
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			sesionTx = FabricaConexiones.obtenerSesionTx();

			LogHandler.info(uid, getClass(), "==> sucursal " + solicitud);

			ParGeneralOV paramReactivacion = comun.obtenerParGeneralOV(uid,
					"PARAMETRO_REACTIVACION");
			if (paramReactivacion == null
					|| paramReactivacion.getCgValor().trim().isEmpty()) {
				throw new Exception(
						"No fue posible obtener el parametro de reactivaciond de solicitudes de par_general.");
			}
			Integer parametroReactivacion = Integer.parseInt(paramReactivacion
					.getCgValor());

			Integer valorParametro = (Integer) sesionTx.selectOne(
					"obtieneParametroReactivarSolicitudes", solicitud);

			if (valorParametro != null) {
				if (valorParametro > 0) {
					throw new Exception(
							"Está solicitud se reactivo Anteriormente. ");
				}
			}

			java.lang.String solicitudFolio = "";
			solicitudFolio = (java.lang.String) sesionNTx
					.selectOne("obtenerFolioSolicitud");
			// solicitudFolio = "157924";
			if (solicitudFolio.equals(null)) {
				throw new Exception(
						"No se obtuvo el folio de la nueva solicitud para la reactivación de solicitudes ");
			}

			final java.util.HashMap<String, Object> param = new HashMap<String, Object>();
			param.put("solicitud", solicitud);
			param.put("solicitudFolio", solicitudFolio);
			param.put("paramReactivacion", parametroReactivacion);

			insertaSolicitud = sesionTx.insert("insertaReactivarSolicitud",
					param);

			if (insertaSolicitud == 0) {
				throw new Exception(
						"No se obtuvieron resultados para la inserción de la solicitud"
								+ " para reactivación de solicitudes ");
			}

			Integer filasPrimero = sesionTx.update(
					"actualizaSolicutdReactivadaPrimero", param);
			LogHandler.info(uid, this.getClass(),
					"ACTUALIZAR filas afectadas  [ " + filasPrimero + " ]");

			if (filasPrimero == 0) {
				throw new Exception(
						"SE HA PRODUCIDO UN ERROR DURANTE LA ACTUALIZACION DE SOLICITUD FINSOL");
			}

			solicitudesOV = sesionTx.selectList("consultaSolicitudReactivada",
					solicitud);

			if (solicitudesOV != null) {
				if (solicitudesOV.size() > 0) {

					for (int i = 0; i < solicitudesOV.size(); i++) {
						LogHandler.info(uid, getClass(), "reactivacion - "
								+ solicitudesOV.get(i).getReactivacion());
						LogHandler.info(uid, getClass(),
								"parametroReactivacion - "
										+ parametroReactivacion.toString());
						if (solicitudesOV.get(i).getReactivacion() <= parametroReactivacion) {

							Integer contador = solicitudesOV.get(i)
									.getReactivacion();
							contador++;

							final java.util.HashMap<String, Object> parametrosActualizaReactivacion = new HashMap<String, Object>();
							parametrosActualizaReactivacion.put("solicitud",
									solicitud);
							parametrosActualizaReactivacion.put(
									"paramReactivacion", contador);

							Integer filas = sesionTx.update(
									"actualizaSolicutdReactivada",
									parametrosActualizaReactivacion);
							LogHandler.info(uid, this.getClass(),
									"ACTUALIZAR filas afectadas  [ " + filas
											+ " ]");

							if (filas == 0) {
								throw new Exception(
										"SE HA PRODUCIDO UN ERROR DURANTE LA ACTUALIZACION DE SOLICITUD FINSOL");
							}
						} else {
							throw new Exception(
									"Ya se reactivo la solicitud anteriormente ");
						}
					}
				}
			}

			final List<ReactivarSolicitudes> listaClientes = (List<ReactivarSolicitudes>) sesionTx
					.selectList("obtieneClienteReactivarSolicitudes", param);

			if (listaClientes.size() == 0) {
				throw new Exception(
						"No se obtuvieron resultados para la inserción de cliente para reactivación de solicitudes ");
			}

			for (int i = 0; i < listaClientes.size(); i++) {

				final java.util.HashMap<String, Object> parameters = new HashMap<String, Object>();
				parameters
						.put("solicitud", listaClientes.get(i).getSolicitud());
				parameters.put("solicitudFolio", solicitudFolio);
				parameters.put("cliente", listaClientes.get(i).getCliente());
				LogHandler.info(uid, getClass(), "Se inserta el cliente - "
						+ listaClientes.get(i).getCliente());

				insertaCliente = sesionTx.insert(
						"insertaReactivarSolicitudCliente", parameters);

				if (insertaCliente == 0) {
					throw new Exception(
							"Surgió un error al momento de insertar el cliente - "
									+ listaClientes.get(i).getCliente());
				}
			}

			// Atomo ORIGEN
			AtomosOV peticionAtomo = new AtomosOV();
			peticionAtomo.setSolicitud(solicitudFolio);
			peticionAtomo.setProceso("ORIGEN");
			peticionAtomo.setComentario("");
			peticionAtomo.setStatus("A");
			peticionAtomo.setUsuarioGeneroAtomo(usuario);
			AtomosRespuesta atomosRespuesta = registrarAtomosTarea(uid,
					sesionTx, peticionAtomo);

			if (!atomosRespuesta.getHeader().isEstatus()) {
				throw new Exception(atomosRespuesta.getHeader().getMensaje());
			}

			sesionTx.commit(true);
			respuesta.getHeader().setMensaje(
					"El número de solicitud generado es: " + solicitudFolio);
		} catch (Exception ex) {
			FabricaConexiones.rollBack(sesionTx);
			LogHandler.error(uid, getClass(),
					"insertaReactivarSolicitudesTarea: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(
					"Se ha producido un error al momento de reactivar solicitudes.  "
							+ ex.getMessage());
			respuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
			FabricaConexiones.close(sesionTx);
		}
		return respuesta;
	}

	/**
	 * Método que se utiliza para consultar las solicitudes que se ya se
	 * reactivaron y se van a mostrar en el ModuloCEC
	 *
	 * @param uid
	 *            uid
	 * @param solicitud
	 *            Consulta la solicitud si ya fue reactivada
	 * @return SolicitudesRespuesta tipo ReactivarSolicitudesRespuesta
	 */
	public SolicitudesRespuesta consultaReactivarSolicitudesModuloCECTarea(
			String uid, String solicitud) {
		SolicitudesRespuesta respuesta = new SolicitudesRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		SolicitudesOV solicitudesOV = null;
		try {
			// Se abre la conexion hacia la base de datos
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			LogHandler.info(uid, getClass(), "==> sucursal " + solicitud);

			solicitudesOV = (SolicitudesOV) sesionNTx.selectOne(
					"obtenerReactivarSolicitudesModuloCEC", solicitud);

			if (solicitudesOV != null) {
				if (solicitudesOV.getReactivacion() == null
						&& solicitudesOV.getSolicitudOrigen() == null) {
					respuesta.getHeader().setEstatus(false);
				} else {
					respuesta.getHeader().setEstatus(true);
					respuesta.getHeader().setMensaje(
							solicitudesOV.getSolicitudOrigen());
				}
			}

			respuesta.setSolicitud(solicitudesOV);
		} catch (Exception ex) {
			LogHandler
					.error(uid,
							getClass(),
							"consultaReactivarSolicitudesModuloCEC: "
									+ ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(
					"Se ha producido un error al momento de consultar reactivar solicitudes"
							+ " para el modulo CEC " + ex.getMessage());
			respuesta.getHeader().setCodigo(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;

	}

	/**
	 * M&eacute;todo que envia un correo con el resumen de una solicitud
	 * 
	 * @param uid
	 *            id &uacute;nico de transacci&oacute;n
	 * @param peticion
	 *            datos de la peticion
	 * @return ExcepcionGarantiaRespuesta respuesta
	 */
	public ExcepcionGarantiaRespuesta enviarCorreoSolicitud(String uid, ResumenBuroPeticion peticion) {
		LogHandler.info(uid, getClass(), "enviarCorreoSolicitud :::: Init  peticion:" + peticion);
		ExcepcionGarantiaRespuesta respuesta = new ExcepcionGarantiaRespuesta();
		ResumenBuroRespuesta resumen = null;
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensaje("TRANSACCION EXITOSA");
		EnvioDeCorreos enviarCorreo = new EnvioDeCorreos();
		SqlSession sesionNTx = null;

		try {
			if (peticion == null || peticion.getSolicitud() == null || peticion.getSolicitud().isEmpty()
					|| peticion.getCorreo() == null || peticion.getCorreo().isEmpty()
					|| peticion.getUsuarioAutoriza() == null || peticion.getUsuarioAutoriza().isEmpty()
					|| peticion.getIdTarea() == null || peticion.getMotivoExcepcion() == null
					|| peticion.getMotivoExcepcion().isEmpty()
					|| peticion.getMotivoCEC().isEmpty()) {
				throw new Exception("La petición no cuenta con los datos necesarios para el envio de correo");
			}
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			HashMap<String, Object> valoresJDNI = new HashMap<String, Object>();
			valoresJDNI = obtenerMapaJdni(uid, "CONSULTA_SOLICITUD_FD", "REGISTAR_OPERACION_FD",
					                          "CORREO_SUB_COMERCIAL", "PERSONA_SUB_COMERCIAL");
			//"http://10.1.50.152:7001/FirmaDigitalWEB/ConsultarAprobacionElectronica?";
			String urlConsulta = valoresJDNI.get("CONSULTA_SOLICITUD_FD").toString();
			// "http://10.1.50.152:7001/FirmaDigitalWEB/RegistrarOperacion?";
			String urlOperacion = valoresJDNI.get("REGISTAR_OPERACION_FD").toString();
			// ha.rito@finsol.com.mx
			String correoSubComercial = valoresJDNI.get("CORREO_SUB_COMERCIAL").toString();
			//722858960
			String personaSubComercial = valoresJDNI.get("PERSONA_SUB_COMERCIAL").toString();
			if (urlConsulta == null || urlConsulta.trim().isEmpty()
			   || urlOperacion == null || urlOperacion.trim().isEmpty()
			   || correoSubComercial == null || correoSubComercial.trim().isEmpty()
			   || personaSubComercial == null || personaSubComercial.trim().isEmpty() ) {
			   throw new Exception("No se encontraron las JDNI: CONSULTA_SOLICITUD_FD,  REGISTAR_OPERACION_FD,"
			   		+ " CORREO_SUB_COMERCIAL o PERSONA_SUB_COMERCIAL ");
			}
			LogHandler.info(uid, getClass(), "enviarCorreoSolicitud:urlConsulta: " + urlConsulta + "\turlOperacion:"
			+ urlOperacion + "\tcorreoSubComercial:" + correoSubComercial + "\tpersonaSubComercial:" + personaSubComercial);

			peticion.setPersonaAutoriza(peticion.getUsuarioAutoriza());
			resumen = resumenSolicitudBuro(uid, peticion);

			if (resumen != null && resumen.getHeader() != null && resumen.getHeader().isEstatus()) {
				if (peticion.getCorreo().contains(",")) {
					String [] correos =  peticion.getCorreo().split(",");
					LogHandler.info(uid, getClass(), "Correos a enviar: " + correos);
					for (String correo : correos) {
						String consulta = "";
						String operacion = "";
						if (correo.contains("Sin Correo")) {
							continue;
						} else {
					       String persona = (String) sesionNTx.selectOne("existePersonaEnRO", correo.trim());
					       if (persona == null || persona.isEmpty()) {
						       throw new Exception("No se encontraron en red operativa el"
						       		+ " numero de persona del correo: " + correo);
					       } else {
					       	consulta = urlConsulta.trim() + "idTarea=" + peticion.getIdTarea()
							     + "&solicitud=" + peticion.getSolicitud().trim() + "&usuarioAut="
							     +  persona;
					       	operacion = urlOperacion.trim() + "idTarea=" + peticion.getIdTarea()
					             + "&solicitud=" + peticion.getSolicitud().trim() + "&usuarioAut="
					             +  persona;
					      }
						}
						LogHandler.info(uid, getClass(), "consulta:" + consulta + "\toperacion:" + operacion + "\tcorreo:" + correo);
					// se le envia el correo a cada persona
					   peticion.setCorreo(correo);
						resumen.setUrlConsultaDatosSolicitud(consulta);
						resumen.setUrlRealiazarOperacionSolicitud(operacion);
						resumen.setMotivoCEC(peticion.getMotivoCEC());
						EnviarCorreoRespuesta enviar = enviarCorreo.enviarCorreoSolicitud(uid, peticion, resumen);
						if (enviar == null || enviar.getHeader() == null || !enviar.getHeader().isEstatus()) {
							throw new Exception("No se pudo enviar el correo de la solicitud: " + peticion.getSolicitud()
							 + "debido a : " + enviar != null && enviar.getHeader() != null
							 ? enviar.getHeader().getMensaje() : "");
						}
					}
				} else {
					String persona = null;
					if (peticion.getCorreo().trim().equals(correoSubComercial.trim())) {
						persona = personaSubComercial.trim();
					} else {
					   persona = (String) sesionNTx.selectOne("existePersonaEnRO", peticion.getCorreo().trim());
					}
					if (persona == null || persona.isEmpty()) {
						throw new Exception(
								"No se encontraron en red operativa el numero de persona del correo: " + peticion.getCorreo());
					} else {
						urlConsulta = urlConsulta.trim() + "solicitud=" + peticion.getSolicitud().trim()
								+ "&usuarioAut=" + persona + "&idTarea=" + peticion.getIdTarea();
						urlOperacion = urlOperacion.trim() + "solicitud=" + peticion.getSolicitud().trim()
								+ "&usuarioAut=" + persona + "&idTarea=" + peticion.getIdTarea();
					}
					LogHandler.info(uid, getClass(), "urlConsulta:" + urlConsulta + "\turlOperacion:" + urlOperacion
							+ "\tcorreo:" + peticion.getCorreo());
					resumen.setUrlConsultaDatosSolicitud(urlConsulta);
					resumen.setUrlRealiazarOperacionSolicitud(urlOperacion);
					resumen.setMotivoCEC(peticion.getMotivoCEC());
					resumen.setPersonaAutoriza(persona);

					EnviarCorreoRespuesta enviar = enviarCorreo.enviarCorreoSolicitud(uid, peticion, resumen);
					if (enviar == null || enviar.getHeader() == null || !enviar.getHeader().isEstatus()) {
						throw new Exception("No se pudo enviar el correo de la solicitud: " + peticion.getSolicitud()
								+ "debido a : " + enviar != null && enviar.getHeader() != null
										? enviar.getHeader().getMensaje() : "");
					}
				}
			} else {
				throw new Exception("No se encontraron datos para la solicitud: " + peticion.getSolicitud());
			}

		} catch (Exception ex) {
			LogHandler.error(uid, getClass(), "enviarCorreoSolicitud: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}  finally {
			FabricaConexiones.close(sesionNTx);
		}

		return respuesta;

	}

	/**
	 * M&eacute;todo que regresa la informacion del resumen de una solicitud
	 *
	 * @param uid
	 *            id &uacute;nico de transacci&oacute;n
	 * @param peticion
	 *            datos d el apeticion
	 * @return ResumenBuroRespuesta respuesta
	 */
	@SuppressWarnings("unchecked")
	public ResumenBuroRespuesta resumenSolicitudBuro(String uid,
			ResumenBuroPeticion peticion) {
		LogHandler.info(uid, getClass(),
				"resumenSolicitudBuro :::: Init  peticion:" + peticion);
		ResumenBuroRespuesta respuesta = new ResumenBuroRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensaje("TRANSACCION EXITOSA");
		String solicitud = null;
		List<InformacionContratosAnteriores> listInfoContratoAnterior = null;
		List<ResumenBuroCliente> listResumenBuroCliente = null;
		SqlSession sesionNTx = null;

		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if (peticion == null || peticion.getSolicitud() == null
					|| peticion.getSolicitud().isEmpty()) {
				throw new Exception(
						"Es necesario que la peticion contenga la solicitud, usuarioAutoriza, perfil y idTarea");
			}
			solicitud = peticion.getSolicitud();
			/*
			 * Este query nos regresa el nombre de la sucursal, el nivel de
			 * riesgo, nombre del grupo y motivo por el que se envia la
			 * solicitud NOTA:ESTO QUEDO PENDIENTE.
			 */
			ExcepcionGarantiaPeticion encabezado = (ExcepcionGarantiaPeticion) sesionNTx
					.selectOne("encabezadoSolicitudFirmaDigital", solicitud);

			if (encabezado != null) {
				respuesta.setNombreGrupo(encabezado.getNombreGrupo());
				respuesta.setNombreSucursal(encabezado.getNombreSucursal());
				respuesta.setTipificacionSucursal(encabezado
						.getTipificacionSucursal());
				respuesta
						.setTituloEncabezado("Aprobación Electrónica de la Solicitud: ");
				respuesta.setMotivoCEC(encabezado.getMotivoCEC());
				String motivos = "";
				if (peticion.getMotivosDescripcion() != null
						&& !peticion.getMotivosDescripcion().trim().isEmpty()) {
					motivos = peticion.getMotivosDescripcion();
				} else {
					List<ExcepcionGarantiaPeticion> listaMotivos = (List<ExcepcionGarantiaPeticion>) sesionNTx
							.selectList("listaMotivosFE", solicitud);
					if (listaMotivos != null && listaMotivos.size() > 0) {
						for (ExcepcionGarantiaPeticion motivo : listaMotivos) {
							motivos += motivo.getJustificacion() + ", ";
						}
					}
				}
				if (motivos.endsWith(", ")) {
					motivos = motivos.substring(0, motivos.length() - 2);
				}
				respuesta.setMotivoExcepcion(motivos);

			} else {
				throw new Exception(
						"No se encontro informacion para la solicitud: "
								+ solicitud);
			}
			// traemos la informacion actual de la solicitud y sus contratos
			// anteriores
			listInfoContratoAnterior = solicitudFirmaDigital(uid, peticion);
			if (listInfoContratoAnterior == null
					|| listInfoContratoAnterior.size() == 0) {
				throw new Exception(
						"No se encontro información de los contratos anteriores  para la solicitud: "
								+ solicitud);
			}
			respuesta
					.setInformacionContratosAnteriores(listInfoContratoAnterior);

			// traemos el resumen de buro de cada cliente
			listResumenBuroCliente = buroCreditoTarea.resumenBuroSolicitud(uid,
					peticion);
			if (listResumenBuroCliente == null
					|| listResumenBuroCliente.size() == 0) {
				throw new Exception(
						"No se encontro información de buro para los integrantes de la solicitud: "
								+ solicitud);
			}
			respuesta.setResumenCliente(listResumenBuroCliente);

		} catch (Exception ex) {
			LogHandler.error(uid, getClass(),
					"resumenSolicitudBuro: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}

		return respuesta;
	}

	/**
	 * M&eacute;todo que valida los motivos de la solicitud
	 * @param uid transaccion unica
	 * @param listaMotivos datos de la peticion
	 * @return Regresa si la respuesta es valida o no
	 */
	private boolean validaMotivosSolicitud(String uid, List<ExcepcionGarantiaPeticion> listaMotivos) {
		LogHandler.info(uid, getClass(), "validaMotivosSolicitud :::: Init  peticion: ");
		boolean respuesta = false;
		try {

			String[] validaMotivos;
			if (listaMotivos.size() > 0) {

				HashMap<String, Object> valoresJDNI = new HashMap<String, Object>();
				valoresJDNI = obtenerMapaJdni(uid, "MOTIVOS_DIVISIONAL", "REGISTAR_OPERACION_FD");

				String[] motivosDivisional = valoresJDNI.get("MOTIVOS_DIVISIONAL").toString().split(",");

				if (motivosDivisional.length > 0 ) {
					for (int i = 0; i < listaMotivos.size(); i++) {
						for (int j = 0; j < motivosDivisional.length; j++) {
							if (listaMotivos.get(i).getJustificacion().equals(motivosDivisional[j].trim())) {
								return true;
							}
						}
					}
				}
			}
		} catch (Exception ex) {
			respuesta = false;
		}
		return respuesta;
	}

	/**
	 * M&eacute;todo que recupera los datos de la solicitud y los contratos
	 * anteriores.
	 *
	 * @param uid
	 *            transaccion unica
	 * @param peticion
	 *            datos de la peticion
	 * @return lista de de datos de los contrato anteriores y solicitud actual.
	 */
	public List<InformacionContratosAnteriores> solicitudFirmaDigital(String uid, ResumenBuroPeticion peticion) {
		LogHandler.info(uid, getClass(), "Entrando al metodo solicitudFirmaDigital-----");

		List<InformacionContratosAnteriores> listInfoContratoAnterior = new ArrayList<InformacionContratosAnteriores>();
		InformacionContratosAnteriores infoCiclo = null;
		String solicitud = null;

		SqlSession sesionNTx = null;

		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			solicitud = peticion.getSolicitud();

			//Se agregan variables para la consulta de las URL's por medio de par_general
			ParGeneralOV urlEstadoCuenta = comun.obtenerParGeneralOV(uid, "URL_ESTADO_CUENTA");
			if ( urlEstadoCuenta == null || urlEstadoCuenta.getCgValor().trim().isEmpty()) {
			   throw new Exception("No se encontraron las JDNI: URL_ESTADO_CUENTA" );
			}

			ParGeneralOV urlIconoPdf = comun.obtenerParGeneralOV(uid, "URL_ICONO_PDF");
			if ( urlIconoPdf == null || urlIconoPdf.getCgValor().trim().isEmpty()) {
			   throw new Exception("No se encontraron las JDNI: URL_ICONO_PDF" );
			}

			/* este query nos regresa la informacion de la solicitud actual y los contratos anteriores
			* como: ciclo, ld, solicitud anterior, producto, campana, tasa, %garantia, monto, plazo, etc...
			*/
			LogHandler.info(uid, getClass(), "solicitudFirmaDigital:Solicitud: " + solicitud);
			for (int repetir = 0; repetir < Constantes.REPETIR_CONTRATOS; repetir++) {
				infoCiclo = new InformacionContratosAnteriores();
				infoCiclo = (InformacionContratosAnteriores) sesionNTx.selectOne("obtenerInfoContratoAnterior", solicitud);
				if (infoCiclo != null ) {
					infoCiclo.setCiclo(infoCiclo.getCiclo() + 1);  // se le egrega un 1 al ciclo
					infoCiclo.setEstadoCuenta(infoCiclo.getContratoLd() == null ? null
							: urlEstadoCuenta.getCgValor() + "cdgsucursal=0&contrato="
							+ infoCiclo.getContratoLd().trim() + "&mostAcred=Ok&muestraCancelaciones=N");
					infoCiclo.setUrlIconoPdf(urlIconoPdf.getCgValor());
					infoCiclo.setPersonaAutoriza(peticion.getUsuarioAutoriza());
				   listInfoContratoAnterior.add(infoCiclo);
				   if (infoCiclo.getSolicitudAnterior() != null && !infoCiclo.getSolicitudAnterior().isEmpty()) {
				   	solicitud = infoCiclo.getSolicitudAnterior().trim();
				   } else {
				   	break;
				   }
				}
			}
			LogHandler.info(uid, getClass(), "solicitudFirmaDigital:obtenerInfoContratoAnterior: "
			                           + listInfoContratoAnterior);

		} catch (Exception e) {
			   LogHandler.error(uid, getClass(), "Error en solicitudFirmaDigital: " + e.getMessage(), e);

		} finally {
				FabricaConexiones.close(sesionNTx);
		}
		return listInfoContratoAnterior;
	}

	/**
	 * Generar Tarea para registrar la justificación de excepción de cupos y
	 * montos.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            justificación de excepción de cupos y montos
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta generarFirmaElectronicaTarea(String uid,
			FirmaElectronicaPeticion peticion) {

		ExcepcionGarantiaRespuesta respuesta = new ExcepcionGarantiaRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionTx = null;
		SqlSession sesionNTx = null;
		int idTarea = 0;
		String motivoExcepcion = "";

		try {

			if (peticion == null) {
				throw new Exception("La peticion viene nula.");
			} else if (peticion.getSucursal() == null
					|| peticion.getSucursal().trim().isEmpty()) {
				throw new Exception("Falta la Sucursal en la peticion.");
			} else if (peticion.getDescripcion() == null
					|| peticion.getDescripcion().trim().isEmpty()) {
				throw new Exception("Falta la Solicitud en la peticion.");
			} else if (peticion.getUsuarioAlta() == null
					|| peticion.getUsuarioAlta().trim().isEmpty()) {
				throw new Exception("Falta el UsuarioAlta en la peticion.");
			} else if (peticion.getPerfil() == null
					|| peticion.getPerfil().trim().isEmpty()) {
				throw new Exception("Falta el Perfil en la peticion.");
			} else if (peticion.getCorreo() == null
					|| peticion.getCorreo().trim().isEmpty()) {
				throw new Exception("Falta el correo en la peticion.");
			} else if (peticion.getMotivos() == null
					|| peticion.getMotivos().size() == 0) {
				throw new Exception(
						"La peticion debe tener al menos un motivo de firma electronica.");
			} else if (peticion.getMotivoCEC() == null
					|| peticion.getMotivoCEC().trim().isEmpty()) {
				throw new Exception(
						"La peticion debe tener al menos una observación de firma electronica.");
			}

			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			// Validamos que solo tenga una tarea de firma electronica por
			// solicitud.
			Integer noTareasFirmaElectronica = (Integer) sesionNTx.selectOne(
					"existeTareaFirmaElectronica", peticion.getDescripcion()
							.trim());
			if (noTareasFirmaElectronica.intValue() != 0) {
				throw new Exception(
						"La solicitud ya tiene una peticion de firma electronica.");
			}

			sesionTx = FabricaConexiones.obtenerSesionTx();

			final java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();
			// parametros para el insert en la tabla buzon_tareas
			parametros.put("tipoTarea", Constantes.TAREA_FIRMA_ELECTRONICA); // TFIE
			parametros.put("sucursal", new Integer(peticion.getSucursal()));
			parametros.put("descripcion", peticion.getDescripcion());
			parametros.put("usuarioAlta", peticion.getUsuarioAlta());
			parametros.put("perfil", "PCOM"); // PCOM
			parametros.put("status", "P");
			Integer insertBT = (Integer) sesionTx.insert(
					"insertaBuzonTareaFirmaElectronica", parametros);
			LogHandler.info(
					uid,
					getClass(),
					"insertaBuzonTareaFirmaElectronica idTarea: "
							+ parametros.get("idTarea"));
			if (insertBT.intValue() == 0) {
				throw new Exception(
						"Existio un error en registrar la tarea de firma electronica.");
			}
			idTarea = Integer.parseInt(parametros.get("idTarea").toString());
			// parametros para el insert en la tabla tareas_excepcion_campania
			parametros.put("idTarea", idTarea);
			parametros.put("solicitud", peticion.getDescripcion());
			parametros.put("correo", peticion.getCorreo());
			parametros.put("motivoCEC", peticion.getMotivoCEC());
			sesionTx.insert("insertaTareaFirmaElectronica", parametros);
			// Insertamos motivos de la firma electronica
			for (String motivo : peticion.getMotivos()) {
				parametros.put("motivo", motivo);
				motivoExcepcion = motivoExcepcion + ", " + motivo;
				sesionTx.insert("insertaDetalleTareaFirmaElectronica",
						parametros);
			}

			// Atomo FIRMA_ELECTRONICA
			AtomosOV peticionAtomo = new AtomosOV();
			peticionAtomo.setSolicitud(peticion.getDescripcion());
			peticionAtomo.setProceso(Constantes.ATOMO_FIRMA_ELECTRONICA);
			peticionAtomo
					.setCodigoResolucion(Constantes.ATOMO_CR_FIRMA_ELECTRONICA_PETICION);
			peticionAtomo.setComentario("");
			peticionAtomo.setStatus("A");
			peticionAtomo.setUsuarioGeneroAtomo(peticion.getUsuarioAlta());
			peticionAtomo.setActualizarSolicitud("NO");
			peticionAtomo.setIdTarea(idTarea);
			AtomosRespuesta atomosRespuesta = registrarAtomosTarea(uid,
					sesionTx, peticionAtomo);

			if (!atomosRespuesta.getHeader().isEstatus()) {
				throw new Exception(
						Constantes.ATOMO_CR_FIRMA_ELECTRONICA_PETICION + ": "
								+ atomosRespuesta.getHeader().getMensaje());
			}

			// Envia correo
			ResumenBuroPeticion correoPeticion = new ResumenBuroPeticion();
			correoPeticion.setUid(uid);
			correoPeticion.setCorreo(peticion.getCorreo());
			correoPeticion.setIdTarea(Long.valueOf(idTarea));
			correoPeticion.setSolicitud(peticion.getDescripcion().trim());
			correoPeticion.setUsuarioAutoriza(peticion.getUsuarioAlta());
			correoPeticion.setMotivoExcepcion(motivoExcepcion);
			correoPeticion.setMotivosDescripcion(peticion
					.getMotivosDescripcion());
			correoPeticion.setMotivoCEC(peticion.getMotivoCEC());
			ExcepcionGarantiaRespuesta respuestaCorreo = enviarCorreoSolicitud(
					uid, correoPeticion);
			if (!respuestaCorreo.getHeader().isEstatus()) {
				throw new Exception(
						Constantes.ATOMO_CR_FIRMA_ELECTRONICA_PETICION
								+ "-CORREO: "
								+ respuestaCorreo.getHeader().getMensaje());
			}
			// COMMIT
			sesionTx.commit();

		} catch (Exception e) {
			FabricaConexiones.rollBack(sesionTx);
			LogHandler
					.error(uid,
							getClass(),
							"Error en generarTareaExcepcionGarantia: "
									+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionNTx);
			FabricaConexiones.close(sesionTx);
		}
		return respuesta;
	}

	/**
	 * Generar actualizacion de la tarea para registrar la observacion y el
	 * codigo de rechazo de excepción de firma electronica.
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            observacion de firma electronica
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta actualizarTareaFirmaElectronica(
			String uid, ResumenBuroPeticion peticion) {
		LogHandler.info(uid, getClass(),
				"----- inicio actualizarTareaFirmaElectronica: ---- "
						+ peticion);
		ExcepcionGarantiaRespuesta respuesta = new ExcepcionGarantiaRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionTx = null;
		SqlSession sesionNTx = null;

		try {

			if (peticion == null) {
				throw new Exception("La peticion viene nula.");
			} else if (peticion.getIdTarea() == null
					|| peticion.getIdTarea() < 0) {
				throw new Exception("Falta el IdTarea en la peticion.");
			} else if (peticion.getSolicitud() == null
					|| peticion.getSolicitud().trim().isEmpty()) {
				throw new Exception("Falta la Solicitud en la peticion.");
			} else if (peticion.getUsuarioAutoriza() == null
					|| peticion.getUsuarioAutoriza().trim().isEmpty()) {
				throw new Exception("Falta el UsuarioAutoriza en la peticion.");
			} else if (peticion.getOperacion() == null
					|| peticion.getOperacion().trim().isEmpty()) {
				throw new Exception("Falta la Operacion en la peticion.");
			}

			if (peticion.getOperacion().equals(
					Constantes.ATOMO_CR_FIRMA_ELECTRONICA_RECHAZO)) {
				if (peticion.getObservacion() == null
						|| peticion.getObservacion().trim().isEmpty()) {
					throw new Exception("Falta la Observacion en la peticion.");
				}
			}
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			sesionTx = FabricaConexiones.obtenerSesionTx();

			boolean respuestaMotivos = false;
			final java.util.HashMap<String, Object> parametrosEscalamiento = new java.util.HashMap<String, Object>();
			List<ExcepcionGarantiaPeticion> listaMotivos = (List<ExcepcionGarantiaPeticion>) sesionNTx
					.selectList("listaMotivos", peticion.getSolicitud());

			SolicitudFirmaElectronica solicitud = new SolicitudFirmaElectronica();
			solicitud = (SolicitudFirmaElectronica) sesionNTx.selectOne(
					"checaDatosFirmaElectronica", peticion.getIdTarea());
			String motivos = "";
			List<ExcepcionGarantiaPeticion> listaMotivosDescripcion = (List<ExcepcionGarantiaPeticion>) sesionNTx
					.selectList("listaMotivosFE", peticion.getSolicitud());
			if (listaMotivosDescripcion != null && listaMotivosDescripcion.size() > 0) {
				for (ExcepcionGarantiaPeticion motivo : listaMotivosDescripcion) {
					motivos += motivo.getJustificacion() + ", ";
				}
			}

			String codigoEscalamiento = peticion.getOperacion().substring(0, Constantes.LIMITE_STATUS);
			String observacionEscalamiento = peticion.getObservacion() == null ? "" : peticion.getObservacion();

			if (listaMotivos != null && listaMotivos.size() > 0) {

				respuestaMotivos = validaMotivosSolicitud(uid, listaMotivos);

				//Se valida la lista de Motivos si trae un true va a validar el escalamiento
				//Primero el regional, posteriormente Divisional o Subdirector Comercial
				//Si la lista trae un false se aprueba la solicitud por el Gerente Regional
				if (respuestaMotivos) {

					// Validamos que la tarea no alla sido atendida por el Gerente Regional
					Integer checarTareaFueAtendida = (Integer) sesionNTx.selectOne(
							"checarFEFueAtendida", peticion.getIdTarea());

					// Validamos que la tarea no alla sido atendida por el Gerente Divisional
					Integer checarTareaFueAtendidaDivisional = (Integer) sesionNTx.selectOne(
							"checarTareaFueAtendidaDivisional", peticion.getIdTarea());

					// Validamos que la tarea no alla sido atendida por el Subdirector Comercial
					Integer checarTareaFueAtendidaSubdirector = (Integer) sesionNTx.selectOne(
							"checarTareaFueAtendidaSubdirector", peticion.getIdTarea());

					// Validamos que el usuario del Divisional si tiene la solicitud
					Integer checarDivisional = (Integer) sesionNTx.selectOne(
							"checarDivisional", peticion.getIdTarea());

					// Validamos que el usuario del Subdirector si tiene la solicitud
					Integer checarSubdirector = (Integer) sesionNTx.selectOne(
							"checarSubdirector", peticion.getIdTarea());

					if (checarTareaFueAtendida.intValue() != 0) {
						if (checarDivisional > 0) {

							// parametros para el insert en la tabla tareas_firma_electronica
							parametrosEscalamiento.put("perfilAutoriza", Constantes.DIVISIONAL);
							parametrosEscalamiento.put("observaciones", solicitud.getObservaciones()
									+ " DIVISIONAL: " + peticion.getObservacion());
							parametrosEscalamiento.put("usuario", peticion.getUsuarioAutoriza());
							parametrosEscalamiento.put("codigo", codigoEscalamiento);
							parametrosEscalamiento.put("autoriza", "Si");
							parametrosEscalamiento.put("idTarea", peticion.getIdTarea());
							sesionTx.update("actualizaTareaFE", parametrosEscalamiento);

							// parametros para el insert en la tabla buzon_tareas
							parametrosEscalamiento.put("idTarea", peticion.getIdTarea());
							parametrosEscalamiento.put("usuario", peticion.getUsuarioAutoriza());
							sesionTx.update("actualizaTareaFEBuzon", parametrosEscalamiento);

							String codigoResolucion = null;
							if (peticion.getOperacion().equals(
									Constantes.ATOMO_CR_FIRMA_ELECTRONICA_OK)) {
								codigoResolucion = Constantes.ATOMO_CR_FIRMA_ELECTRONICA_OK;
							} else {
								codigoResolucion = Constantes.ATOMO_CR_FIRMA_ELECTRONICA_RECHAZO;
							}

							// Atomo FIRMA_ELECTRONICA
							AtomosOV peticionAtomo = new AtomosOV();
							peticionAtomo.setSolicitud(peticion.getSolicitud());
							peticionAtomo.setProceso(Constantes.ATOMO_FIRMA_ELECTRONICA);
							peticionAtomo.setCodigoResolucion(codigoResolucion);
							peticionAtomo.setComentario("");
							peticionAtomo.setStatus("A");
							peticionAtomo.setUsuarioGeneroAtomo(peticion.getUsuarioAutoriza());
							peticionAtomo.setActualizarSolicitud("NO");
							peticionAtomo.setIdTarea(Integer.parseInt(peticion.getIdTarea()
									.toString()));
							AtomosRespuesta atomosRespuesta = registrarAtomosTarea(uid,
									sesionTx, peticionAtomo);

							if (!atomosRespuesta.getHeader().isEstatus()) {
								throw new Exception(codigoResolucion + ": "
										+ atomosRespuesta.getHeader().getMensaje());
							}

						} else if (checarSubdirector > 0) {

							// parametros para el insert en la tabla tareas_firma_electronica
							parametrosEscalamiento.put("perfilAutoriza", Constantes.SUBDIRECTOR);
							parametrosEscalamiento.put("observaciones", solicitud.getObservaciones()
									+ " SUBDIRECTOR: " + peticion.getObservacion());
							parametrosEscalamiento.put("autoriza", "Si");
							parametrosEscalamiento.put("usuario", peticion.getUsuarioAutoriza());
							parametrosEscalamiento.put("codigo", codigoEscalamiento);
							parametrosEscalamiento.put("idTarea", peticion.getIdTarea());
							sesionTx.update("actualizaTareaFE", parametrosEscalamiento);

							// parametros para el insert en la tabla buzon_tareas
							parametrosEscalamiento.put("idTarea", peticion.getIdTarea());
							parametrosEscalamiento.put("usuario", peticion.getUsuarioAutoriza());
							sesionTx.update("actualizaTareaFEBuzon", parametrosEscalamiento);

							String codigoResolucion = null;
							if (peticion.getOperacion().equals(
									Constantes.ATOMO_CR_FIRMA_ELECTRONICA_OK)) {
								codigoResolucion = Constantes.ATOMO_CR_FIRMA_ELECTRONICA_OK;
							} else {
								codigoResolucion = Constantes.ATOMO_CR_FIRMA_ELECTRONICA_RECHAZO;
							}

							// Atomo FIRMA_ELECTRONICA
							AtomosOV peticionAtomo = new AtomosOV();
							peticionAtomo.setSolicitud(peticion.getSolicitud());
							peticionAtomo.setProceso(Constantes.ATOMO_FIRMA_ELECTRONICA);
							peticionAtomo.setCodigoResolucion(codigoResolucion);
							peticionAtomo.setComentario("");
							peticionAtomo.setStatus("A");
							peticionAtomo.setUsuarioGeneroAtomo(peticion.getUsuarioAutoriza());
							peticionAtomo.setActualizarSolicitud("NO");
							peticionAtomo.setIdTarea(Integer.parseInt(peticion.getIdTarea()
									.toString()));
							AtomosRespuesta atomosRespuesta = registrarAtomosTarea(uid,
									sesionTx, peticionAtomo);

							if (!atomosRespuesta.getHeader().isEstatus()) {
								throw new Exception(codigoResolucion + ": "
										+ atomosRespuesta.getHeader().getMensaje());
							}

						} else {
							throw new Exception("La solicitud ya fue atendida por el Gerente Regional.");
						}
					} else {
						// parametros para el insert en la tabla tareas_firma_electronica
						parametrosEscalamiento.put("perfilAutoriza", Constantes.REGIONAL);
						parametrosEscalamiento.put("usuario", peticion.getUsuarioAutoriza());
						parametrosEscalamiento.put("codigo", codigoEscalamiento);
						parametrosEscalamiento.put("observacion", observacionEscalamiento);
						parametrosEscalamiento.put("idTarea", peticion.getIdTarea());
						sesionTx.update("actualizaTareaFE", parametrosEscalamiento);

						if (codigoEscalamiento.equals("APRO")) {

							if (checarTareaFueAtendidaDivisional == 0) {

								SolicitudFirmaElectronica correoDivisional = new SolicitudFirmaElectronica();
								ResumenBuroPeticion correoPeticion = new ResumenBuroPeticion();
								ExcepcionGarantiaRespuesta respuestaCorreo = new ExcepcionGarantiaRespuesta();

								correoDivisional = (SolicitudFirmaElectronica)
										sesionNTx.selectOne("obtenerCorreoDivisionalEscalamiento", peticion.getSolicitud());
								if (correoDivisional.getCorreoDivisional() == null
									|| correoDivisional.getCorreoDivisional().isEmpty()
									|| correoDivisional.getCorreoDivisional().equals("")
									|| correoDivisional.getCorreoDivisional().equals(" ")) {
									ParGeneralOV correoSubComercial =  comun.obtenerParGeneralOV(uid, "CORREO_SUB_COMERCIAL");
									ParGeneralOV personaSubComercial = comun.obtenerParGeneralOV(uid, "PERSONA_SUB_COMERCIAL");
									if (correoSubComercial == null || correoSubComercial.getCgValor() == null) {
										throw new Exception("No fue posible recueperar la jdni: CORREO_SUB_COMERCIAL");
								    }

									if (personaSubComercial == null || personaSubComercial.getCgValor() == null) {
										throw new Exception("No fue posible recueperar la jdni: PERSONA_SUB_COMERCIAL");
								    }
									LogHandler.info(uid, getClass(), "PERSONA_SUB_COMERCIAL:" + personaSubComercial.getCgValor());
									LogHandler.info(uid, getClass(), "CORREO_SUB_COMERCIAL:" + correoSubComercial.getCgValor());

									ParGeneralOV correoSubdirectorRiesgos
										= comun.obtenerParGeneralOV(uid, "CORREO_SUBDIRECTOR_RIESGOS");
									ParGeneralOV personaSubdirectorRiesgos
										= comun.obtenerParGeneralOV(uid, "PERSONA_SUBDIRECTOR_RIESGOS");

									if (correoSubdirectorRiesgos == null || correoSubdirectorRiesgos.getCgValor() == null) {
										throw new Exception("No fue posible recueperar la jdni: CORREO_SUBDIRECTOR_RIESGOS");
								    }

									if (personaSubdirectorRiesgos == null || personaSubdirectorRiesgos.getCgValor() == null) {
										throw new Exception("No fue posible recueperar la jdni: PERSONA_SUBDIRECTOR_RIESGOS");
								    }

									// parametros para el insert en la tabla tareas_firma_electronica
									parametrosEscalamiento.put("perfilAutoriza", Constantes.SUBDIRECTOR);
									parametrosEscalamiento.put("usuario",  personaSubComercial.getCgValor());
									parametrosEscalamiento.put("correo", solicitud.getCorreo()
											+ "," + correoSubComercial.getCgValor());
									parametrosEscalamiento.put("nuevaTarea", "Si");
									parametrosEscalamiento.put("idTarea", peticion.getIdTarea());
									sesionTx.update("actualizaTareaFE", parametrosEscalamiento);

									String[] personaEnvioCorreosSubdirectores = new String[2];
									String[] correoEnvioCorrerosSubdirectores = new String[2];

									personaEnvioCorreosSubdirectores[0] = personaSubComercial.getCgValor();
									personaEnvioCorreosSubdirectores[1] = personaSubdirectorRiesgos.getCgValor();
									correoEnvioCorrerosSubdirectores[0] = correoSubComercial.getCgValor();
									correoEnvioCorrerosSubdirectores[1] = correoSubdirectorRiesgos.getCgValor();

									for (int i = 0; i < personaEnvioCorreosSubdirectores.length; i++) {

										// Envia correo
										correoPeticion.setUid(uid);
										correoPeticion.setCorreo(correoEnvioCorrerosSubdirectores[i]);
										correoPeticion.setIdTarea(Long.valueOf(peticion.getIdTarea()));
										correoPeticion.setSolicitud(peticion.getSolicitud().trim());
										correoPeticion.setUsuarioAutoriza(peticion.getUsuarioAutoriza());
										correoPeticion.setMotivoExcepcion("-");
										correoPeticion.setMotivosDescripcion(motivos);
										correoPeticion.setMotivoCEC(solicitud.getMotivoCEC());
										respuestaCorreo = enviarCorreoSolicitud(uid, correoPeticion);

										if (respuestaCorreo == null || respuestaCorreo.getHeader() == null
												|| !respuestaCorreo.getHeader().isEstatus()) {
											throw new Exception("No se pudo enviar el correo de la solicitud: "
												+ peticion.getSolicitud() + "debido a : " + respuestaCorreo != null
												&& respuestaCorreo.getHeader() != null
												? respuestaCorreo.getHeader().getMensaje() : "");
										}
									}
								} else {
									// Se envía al Divisional
									// parametros para el insert en la tabla tareas_firma_electronica
									parametrosEscalamiento.put("perfilAutoriza", Constantes.DIVISIONAL);
									parametrosEscalamiento.put("usuario", correoDivisional.getPersonaDivisional());
									parametrosEscalamiento.put("correo", solicitud.getCorreo()
											+ "," + correoDivisional.getCorreoDivisional());
									parametrosEscalamiento.put("nuevaTarea", "Si");
									parametrosEscalamiento.put("idTarea", peticion.getIdTarea());
									sesionTx.update("actualizaTareaFE", parametrosEscalamiento);

									// Envia correo
									correoPeticion.setUid(uid);
									correoPeticion.setCorreo(correoDivisional.getCorreoDivisional());
									correoPeticion.setIdTarea(Long.valueOf(peticion.getIdTarea()));
									correoPeticion.setSolicitud(peticion.getSolicitud().trim());
									correoPeticion.setUsuarioAutoriza(correoDivisional.getPersonaDivisional());
									correoPeticion.setMotivoExcepcion("-");
									correoPeticion.setMotivosDescripcion(motivos);
									correoPeticion.setMotivoCEC(solicitud.getMotivoCEC());
									respuestaCorreo = enviarCorreoSolicitud(uid, correoPeticion);

									if (respuestaCorreo == null || respuestaCorreo.getHeader() == null
											|| !respuestaCorreo.getHeader().isEstatus()) {
										throw new Exception("No se pudo enviar el correo de la solicitud: "
											+ peticion.getSolicitud() + "debido a : " + respuestaCorreo != null
											&& respuestaCorreo.getHeader() != null
											? respuestaCorreo.getHeader().getMensaje() : "");
									}
								}
							} else {
								// parametros para el insert en la tabla tareas_firma_electronica
								parametrosEscalamiento.put("perfilAutoriza", Constantes.DIVISIONAL);
								parametrosEscalamiento.put("usuario", peticion.getUsuarioAutoriza());
								parametrosEscalamiento.put("autoriza", "Si");
								parametrosEscalamiento.put("idTarea", peticion.getIdTarea());
								sesionTx.update("actualizaTareaFE", parametrosEscalamiento);
							}
						} else if (codigoEscalamiento.equals("RECH")) {

							// parametros para el insert en la tabla buzon_tareas
							parametrosEscalamiento.put("idTarea", peticion.getIdTarea());
							parametrosEscalamiento.put("usuario", peticion.getUsuarioAutoriza());
							sesionTx.update("actualizaTareaFEBuzon", parametrosEscalamiento);

							String codigoResolucion = null;
							if (peticion.getOperacion().equals(
									Constantes.ATOMO_CR_FIRMA_ELECTRONICA_OK)) {
								codigoResolucion = Constantes.ATOMO_CR_FIRMA_ELECTRONICA_OK;
							} else {
								codigoResolucion = Constantes.ATOMO_CR_FIRMA_ELECTRONICA_RECHAZO;
							}

							// Atomo FIRMA_ELECTRONICA
							AtomosOV peticionAtomo = new AtomosOV();
							peticionAtomo.setSolicitud(peticion.getSolicitud());
							peticionAtomo.setProceso(Constantes.ATOMO_FIRMA_ELECTRONICA);
							peticionAtomo.setCodigoResolucion(codigoResolucion);
							peticionAtomo.setComentario("");
							peticionAtomo.setStatus("A");
							peticionAtomo.setUsuarioGeneroAtomo(peticion.getUsuarioAutoriza());
							peticionAtomo.setActualizarSolicitud("NO");
							peticionAtomo.setIdTarea(Integer.parseInt(peticion.getIdTarea()
									.toString()));
							AtomosRespuesta atomosRespuesta = registrarAtomosTarea(uid,
									sesionTx, peticionAtomo);

							if (!atomosRespuesta.getHeader().isEstatus()) {
								throw new Exception(codigoResolucion + ": "
										+ atomosRespuesta.getHeader().getMensaje());
							}
						}
					}
				} else {
					// parametros para el insert en la tabla tareas_firma_electronica
					parametrosEscalamiento.put("perfilAutoriza", Constantes.REGIONAL);
					parametrosEscalamiento.put("usuario", peticion.getUsuarioAutoriza());
					parametrosEscalamiento.put("codigo", codigoEscalamiento);
					parametrosEscalamiento.put("observacion", observacionEscalamiento);
					parametrosEscalamiento.put("idTarea", peticion.getIdTarea());
					sesionTx.update("actualizaTareaFE", parametrosEscalamiento);

					// parametros para el insert en la tabla buzon_tareas
					parametrosEscalamiento.put("idTarea", peticion.getIdTarea());
					parametrosEscalamiento.put("usuario", peticion.getUsuarioAutoriza());
					sesionTx.update("actualizaTareaFEBuzon", parametrosEscalamiento);

					String codigoResolucion = null;
					if (peticion.getOperacion().equals(
							Constantes.ATOMO_CR_FIRMA_ELECTRONICA_OK)) {
						codigoResolucion = Constantes.ATOMO_CR_FIRMA_ELECTRONICA_OK;
					} else {
						codigoResolucion = Constantes.ATOMO_CR_FIRMA_ELECTRONICA_RECHAZO;
					}

					// Atomo FIRMA_ELECTRONICA
					AtomosOV peticionAtomo = new AtomosOV();
					peticionAtomo.setSolicitud(peticion.getSolicitud());
					peticionAtomo.setProceso(Constantes.ATOMO_FIRMA_ELECTRONICA);
					peticionAtomo.setCodigoResolucion(codigoResolucion);
					peticionAtomo.setComentario("");
					peticionAtomo.setStatus("A");
					peticionAtomo.setUsuarioGeneroAtomo(peticion.getUsuarioAutoriza());
					peticionAtomo.setActualizarSolicitud("NO");
					peticionAtomo.setIdTarea(Integer.parseInt(peticion.getIdTarea()
							.toString()));
					AtomosRespuesta atomosRespuesta = registrarAtomosTarea(uid,
							sesionTx, peticionAtomo);

					if (!atomosRespuesta.getHeader().isEstatus()) {
						throw new Exception(codigoResolucion + ": "
								+ atomosRespuesta.getHeader().getMensaje());
					}
				}
			}
			// COMMIT
			sesionTx.commit();

		} catch (Exception e) {
			FabricaConexiones.rollBack(sesionTx);
			LogHandler
					.error(uid,
							getClass(),
							"Error en generarTareaExcepcionGarantia: "
									+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionNTx);
			FabricaConexiones.close(sesionTx);
		}
		return respuesta;
	}

	/**
	 * Metodo que envia mensaje encaso de que la solicitud lleve mas de seis
	 * hora sin contestar en un horario habil de 8 a 20 horas
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            observacion de firma electronica
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta mensajeTiempo(String uid,
			ResumenBuroPeticion peticion) {

		ExcepcionGarantiaRespuesta respuesta = new ExcepcionGarantiaRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		int horasEspera = Constantes.HORA_ESPERA;
		int horasTrancurridas = 0;
		int horasNoHabiles = 0;
		boolean horarioHabil = false;
		String msj = "";

		try {

			if (peticion == null) {
				throw new Exception("La peticion viene nula.");
			} else if (peticion.getIdTarea() == null
					|| peticion.getIdTarea() < 0) {
				throw new Exception("Falta el IdTarea en la peticion.");
			}

			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			// Validamos que solo tenga una tarea de firma electronica por
			// solicitud.
			FechaTiempo tiempo = (FechaTiempo) sesionNTx.selectOne(
					"tiempoEsperaFE", peticion.getIdTarea());
			if (tiempo == null) {
				throw new Exception(
						"No se recupero la fecha_alta de buzon_tareas para el id:"
								+ peticion.getIdTarea());
			}
			if (tiempo.getEstatusTarea() != null
					&& tiempo.getEstatusTarea().trim().equals("A")) {
				throw new Exception("La tarea: " + peticion.getIdTarea()
						+ " ya fue atendida.");
			}
			tiempo.setIntervaloInicial(Constantes.INTERVALO_INICIAL);
			tiempo.setIntervaloFinal(Constantes.INTERVALO_FINAL);
			LogHandler.info(uid, getClass(), "mensajeTiempo tiempoEsperaFE: "
					+ tiempo);

			if (tiempo != null && tiempo.getDiasTranscurridos() == 0
					&& tiempo.getMesesTranscurridos() == 0
					&& tiempo.getYearsTrancurridos() == 0) {
				horarioHabil = rangoDeHorarios("", tiempo);
				if (horarioHabil) {
					horasTrancurridas = tiempo.getHorasTranscurridas();
				} else {
					if (tiempo.getHoraAlta() < tiempo.getIntervaloInicial()) {
						horasNoHabiles = tiempo.getIntervaloInicial()
								- tiempo.getHoraAlta();
					} else {
						horasNoHabiles = tiempo.getHoraAlta()
								- tiempo.getIntervaloFinal();
					}
					horasTrancurridas = tiempo.getHorasTranscurridas()
							- horasNoHabiles;
				}
			} else if (tiempo.getDiasTranscurridos() == 1
					&& tiempo.getMesesTranscurridos() == 0
					&& tiempo.getYearsTrancurridos() == 0) {
				horarioHabil = rangoDeHorarios("", tiempo);
				if (horarioHabil) {
					horasTrancurridas = tiempo.getHorasTranscurridas()
							- Constantes.DESCUENTO_HORA;
				} else {
					if (tiempo.getHoraAlta() < tiempo.getIntervaloInicial()) {
						horasNoHabiles = tiempo.getIntervaloInicial()
								- tiempo.getHoraAlta();
						horasTrancurridas = tiempo.getHorasTranscurridas()
								- horasNoHabiles;
					} else {
						horasNoHabiles = tiempo.getHoraAlta()
								- tiempo.getIntervaloFinal();
						horasNoHabiles = Constantes.DESCUENTO_HORA
								- horasNoHabiles;
						horasTrancurridas = tiempo.getHorasTranscurridas()
								- horasNoHabiles;
					}
				}
			} else {
				msj = "El tiempo que tiene la solicitud de aprobación desde su envío hasta ahora son más de 6 horas";
			}

			if (horasTrancurridas > horasEspera) {
				msj = "El tiempo que tiene la solicitud de aprobación desde su envío hasta ahora son más de 6 horas";
			}
			LogHandler.info(uid, getClass(), "horasTrancurridas:"
					+ horasTrancurridas);
			LogHandler.info(uid, getClass(), "msj: " + msj);

			if (!msj.trim().isEmpty()) {
				respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensaje(msj);
			}

		} catch (Exception e) {
			LogHandler
					.error(uid,
							getClass(),
							"Error en generarTareaExcepcionGarantia: "
									+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * cehecamos si la diferencia de dos valores esta en un rango determinado
	 * 
	 * @param uid
	 *            id unico de transaccion
	 * @param tiempo
	 *            valor que se utilizan para comparar
	 * @return boolean nos regersa un true si esta en ese rango de 30 min antes
	 *         de que salga
	 */
	public boolean rangoDeHorarios(String uid, FechaTiempo tiempo) {
		System.out.println(uid + "---Entrando al metodo rangoDeHorarios ");
		boolean estaEnRango = false;

		if (tiempo.getHoraAlta() >= tiempo.getIntervaloInicial()
				&& tiempo.getHoraAlta() <= tiempo.getIntervaloFinal()) {
			estaEnRango = true;
			System.out.println(tiempo.getIntervaloInicial() + "["
					+ tiempo.getHoraAlta() + "]" + tiempo.getIntervaloFinal()
					+ ":" + estaEnRango);
		} else {
			System.out.println(tiempo.getIntervaloInicial() + "["
					+ tiempo.getHoraAlta() + "]" + tiempo.getIntervaloFinal()
					+ ":" + estaEnRango);
		}
		System.out.println(uid + "terminando metodo rangoDeHorarios --- "
				+ estaEnRango);
		return estaEnRango;
	}

	/**
	 * Metodo que envia mensaje encaso de que que la solicitud este enproceso o
	 * alla sido rechazasa
	 *
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            observacion de firma electronica
	 * @return the the excepcion garantia respuesta
	 */
	public ExcepcionGarantiaRespuesta checarEstatusTareaFE(String uid,
			ResumenBuroPeticion peticion) {
		LogHandler.info(uid, getClass(), "checarEstatusTareaFE peticion: "
				+ peticion);

		ExcepcionGarantiaRespuesta respuesta = new ExcepcionGarantiaRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesionNTx = null;
		String msj = "";

		try {

			if (peticion == null) {
				throw new Exception("La peticion viene nula.");
			} else if (peticion.getSolicitud() == null
					|| peticion.getSolicitud().trim().isEmpty()) {
				throw new Exception("Falta la solicitud en la petición.");
			}

			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			// Validamos que solo tenga una tarea de firma electronica por
			// solicitud.
			TareaOV tarea = (TareaOV) sesionNTx.selectOne("checarFEPendiente",
					peticion.getSolicitud());
			LogHandler.info(uid, getClass(), "checarEstatusTareaFE tarea: "
					+ tarea);
			if (tarea == null) {
				respuesta.getHeader().setEstatus(true);
				respuesta.getHeader().setMensaje("TRANSACCION EXITOSA");
				return respuesta;
			} else {
				if (tarea.getEstatus() != null
						&& tarea.getEstatus().trim().equals("P")) {
					msj = "En proceso de aprobación electrónica.";
				}
				// else {
				// if (tarea.getCodigoResolucion() != null &&
				// tarea.getCodigoResolucion().trim().equals("RECH")) {
				// if (peticion.getOperacion() != null &&
				// peticion.getOperacion().trim().equals("EVALUAR")) {
				// msj =
				// "No se puede Evaluar correctamente la solicitud porque el Gerente Regional"
				// +
				// " y/o Divisional rechazó la solicitud de Aprobación Electrónica.";
				// }
				// }
				// }
			}
			LogHandler
					.info(uid, getClass(), "checarEstatusTareaFE msj: " + msj);

			if (!msj.trim().isEmpty()) {
				respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensaje(msj);
			}

		} catch (Exception e) {
			LogHandler
					.error(uid,
							getClass(),
							"Error en generarTareaExcepcionGarantia: "
									+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * Metodo que devuelve los comentarios de divisionales y mensajes del CEC
	 * para una tarea en cada atomo por el que pasa la solicitud.
	 * 
	 * @param uid
	 *            the uid
	 * @param peticion
	 *            idTarea y solicitud
	 * @return los comentarios de divisionales y mensajes del CEC
	 */
	public ConsultaComentariosMensajesAtomosRespuesta consultaComentariosMnjsSolicitudSegimientoTarea(
			String uid, ConsultaComentariosMensajesAtomosPeticion peticion) {

		ConsultaComentariosMensajesAtomosRespuesta respuesta = new ConsultaComentariosMensajesAtomosRespuesta();
		SqlSession sesionNTx = null;

		try {
			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			if (peticion.getProceso() == null
					|| peticion.getProceso().trim().isEmpty()) {
				throw new Exception("El Proceso es obligatorio.");
			}
			if (peticion.getIdTarea() == null || peticion.getIdTarea() == 0) {
				throw new Exception(
						"El idTarea es obligatorio y diferente de cero.");
			}
			if (peticion.getSolicitud() == null
					|| peticion.getSolicitud().trim().isEmpty()) {
				throw new Exception("La solicitud es obligatoria.");
			}

			parametros.put("id_tarea", peticion.getIdTarea());
			parametros.put("solicitud", peticion.getSolicitud());

			CatalogoAtomosEnum catalogoAtomos = CatalogoAtomosEnum
					.valueOf(peticion.getProceso());

			/**
			 * De acuerdo al parametro proceso se seleccionara el query que debe
			 * ejecutarse
			 **/
			switch (catalogoAtomos) {
			case FIRMA_ELECTRONICA:
				sesionNTx = FabricaConexiones.obtenerSesionNTx();
				respuesta = (ConsultaComentariosMensajesAtomosRespuesta) sesionNTx
						.selectOne(
								"consultaComentariosMensajesFirmaElectronica",
								parametros);
				if (respuesta == null) {
					throw new Exception(
							"No se encontraron datos para la consulta de Firma Electrónica");
				}
				break;
			default:
				throw new Exception(
						"El proceso no existe, es necesario registrarlo en CatalogoAtomosEnum");
			}

			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setEstatus(true);

		} catch (Exception e) {
			LogHandler.error(uid, getClass(),
					" :.: consultaComentariosMnjsSolicitudSegimientoTarea: "
							+ e.getMessage(), e);
			if (respuesta == null) {
				respuesta = new ConsultaComentariosMensajesAtomosRespuesta();
			}
			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}

	/**
	 * M&eacute;todo que consulta la información del grupo de la planilla de observaciones
	 * @param uid the uid
	 * @param peticion  solicitud para la cual se requieren la informacion del grupo.
	 * @return respuesta con la información del grupo.
	 */
	public ConsultaSolicitudPlanillaObservacionesRespuesta consultaInformacionGrupoPlanillaTarea(String uid,
			ConsultaSolicitudPlanillaObservacionesPeticion peticion) {

		ConsultaSolicitudPlanillaObservacionesRespuesta respuesta = new ConsultaSolicitudPlanillaObservacionesRespuesta();
		SqlSession sesionNTx = null;

		try {

			List<ConsultaSolicitudPlanillaObservacionesOV> solicitudes = null;

			if (peticion.getSolicitud() == null || peticion.getSolicitud().trim().isEmpty()) {
				throw new Exception("La solicitud es obligatoria.");
			}

			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			solicitudes = (List<ConsultaSolicitudPlanillaObservacionesOV>)
					sesionNTx.selectList("consultaInformacionGrupoPlanilla", peticion.getSolicitud());

			if (solicitudes.size() ==  0) {
				throw new Exception( "No se encontraron datos para la consulta de información de grupo");
			}

			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setEstatus(true);
			respuesta.setSolicitudes(solicitudes);

		} catch (Exception e) {
			LogHandler.error(uid, getClass(), " :.: consultaInformacionGrupoPlanillaTarea: " + e.getMessage(), e);

			respuesta.setHeader(new EncabezadoRespuesta());
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());
		} finally {
				FabricaConexiones.close(sesionNTx);
		}
		return respuesta;
	}
}
