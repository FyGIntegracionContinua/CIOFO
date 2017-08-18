/**
 * @author mi.mejorada
 * @version 1.0.0
 */
package negocio.solicitudes;

import java.text.Normalizer;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.osoa.sca.annotations.Reference;

import tarea.burocredito.BuroCreditoTarea;
import tarea.consultas.Consultas;
import tarea.solicitudes.SolicitudesCreditoTarea;
import transformador.Transformador;
import utilitario.buzon.BuzonOV;
import utilitario.buzon.ConsultaAvanceTrabajoPeticion;
import utilitario.buzon.ConsultaAvanceTrabajoRespuesta;
import utilitario.buzon.ConsultaBuzonPeticion;
import utilitario.comun.GUIDGenerator;
import utilitario.log.LogHandler;
import utilitario.mensajes.burocredito.BuroCreditoClienteDetalleGrupoPeticion;
import utilitario.mensajes.burocredito.BuroCreditoClienteDetalleGrupoRespuesta;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.originacion.aprobacion.PlanillaAprobacionPeticionDTO;
import utilitario.mensajes.originacion.aprobacion.PlanillaAprobacionRespuestaDTO;
import utilitario.mensajes.solicitudes.AtomosOV;
import utilitario.mensajes.solicitudes.CancelarSolEvaCrePeticion;
import utilitario.mensajes.solicitudes.CancelarSolEvaCreRespuesta;
import utilitario.mensajes.solicitudes.ConsultarAtomosRespuesta;
import utilitario.mensajes.solicitudes.CorregirPlaObsSucPeticion;
import utilitario.mensajes.solicitudes.CorregirPlaObsSucRespuesta;
import utilitario.mensajes.solicitudes.EnviarPlaObsSucPeticion;
import utilitario.mensajes.solicitudes.EnviarPlaObsSucRespuesta;
import utilitario.mensajes.solicitudes.ExcepcionGarantiaPeticion;
import utilitario.mensajes.solicitudes.ExcepcionGarantiaRespuesta;
import utilitario.mensajes.solicitudes.PlanillaObservacionesOV;
import utilitario.mensajes.solicitudes.PlanillaObservacionesRespuesta;

/**
 * @author out_mreyes
 *
 */
@Path("/moduloCEC")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.APPLICATION_XML)
public class RestModuloCecImpl {

    /**
     * Constructor
     */
    public RestModuloCecImpl() {

    }
	/**
	 * SCA Component
	 */
	private Transformador transformador;

	/**
	 * SCA Component Fabric
	 */
	private Consultas consultas;

	/**
	 * SCA Component Fabric
	 */
	private SolicitudesCreditoTarea solicitudesCredito;

	/**
	 * BuroCreditoTarea SCA
	 */
	private BuroCreditoTarea buroCreditoTarea;

	/**
	 * @param addService inyeccion
	 */
	@Reference
    public void setConsultas(Consultas addService) {
        this.consultas = addService;
    }

	/**
	 * @param addService inyeccion
	 */
	@Reference
    public void setTransformador(Transformador addService) {
        this.transformador = addService;
    }

	/**
	 * @param addService inyeccion
	 */
	@Reference
    public void setSolicitudesCredito(SolicitudesCreditoTarea addService) {
        this.solicitudesCredito = addService;
    }

	/**
	 * @param addService inyeccion
	 */
	@Reference
    public void setBuroCreditoTarea(BuroCreditoTarea addService) {
        this.buroCreditoTarea = addService;
    }

	/**
	 * @param personaAnalista propietario del buzon
	 * @param sucursal para reestrucutra
	 * @param perfil  perfil que desean consultar
	 * @return JSON respuesta
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/consultarBuzonTareas")
	public String consultarBuzonTareas(@QueryParam("personaAnalista") String personaAnalista,
										  @QueryParam("sucursal") String sucursal,
										  @QueryParam("perfil") String perfil
										  ) {
		LogHandler.info("REST", getClass(), "consultarBuzonTareas");
		final java.lang.String uid  = GUIDGenerator.generateGUID( personaAnalista );
		LogHandler.info(uid, getClass(), "consultarBuzonTareas - Datos de entrada :  personaAnalista=" + personaAnalista
						+ " sucursal=" + sucursal + " perfil="  + perfil 	);

		BuzonOV respuesta = null;

		try {
			if (personaAnalista == null || personaAnalista.trim().isEmpty()) {
				throw new Exception("Es necesario el numero de persona del Analista para realizar la consulta.");
			}
			if (sucursal == null) {
				throw new Exception("Es necesario el numero sucursal para realizar la consulta.");
			}
			if (perfil == null || perfil.trim().isEmpty()) {
				throw new Exception("Es necesario el perfil para realizar la consulta.");
			}

			ConsultaBuzonPeticion   peticionBuzon = new ConsultaBuzonPeticion();
			peticionBuzon.setPerfil(perfil);
			peticionBuzon.setSucursal(Integer.valueOf(sucursal));
			peticionBuzon.setUsuarioPropietario(personaAnalista);
			peticionBuzon.setTipoTarea("TECR");
			peticionBuzon.setTipoTareaEx("TOEG");
			peticionBuzon.setStatus("P");

			//Llamado a funci�n principal
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
	 * @param personaAnalista propietario del buzon
	 * @return JSON respuesta
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/consultarGraficaAvance")
	public String consultarGraficaAvance(@QueryParam("personaAnalista") String personaAnalista) {
		LogHandler.info("REST", getClass(), "consultarGraficaAvance");
		final java.lang.String uid  = GUIDGenerator.generateGUID( personaAnalista );
		LogHandler.info(uid, getClass(), "consultarGraficaAvance - Datos de entrada :  personaAnalista=" + personaAnalista);

		ConsultaAvanceTrabajoRespuesta respuesta = null;
		try {
			if (personaAnalista == null || personaAnalista.trim().isEmpty()) {
				throw new Exception("Es necesario el numero de persona del Analista para realizar la consulta.");
			}

			ConsultaAvanceTrabajoPeticion  peticion = new ConsultaAvanceTrabajoPeticion();
			peticion.setUsuarioPropietario(personaAnalista);

			//Llamado a funci�n principal
			respuesta =	solicitudesCredito.consultarGraficaAvanceTarea(uid, peticion);
			LogHandler.info(uid, getClass(), "consultarGraficaAvance - Datos de salida: " + respuesta);
		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON = transformador.transformaObjetoAJSON(uid, respuesta);
		LogHandler.info(uid, getClass(), "consultarBuzonTareas - Datos de salida :");
		return respuestaJSON;

	}


	/**
	 * @param solicitud de la peticion.
	 * @param ordenar de la peticion.
	 * @return JSON respuesta
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/consultarAtomos")
	public String consultarAtomos( @QueryParam("solicitud") String solicitud,
			@QueryParam("ordenar") String ordenar) {
		LogHandler.info("REST", getClass(), "consultarAtomos");
		final java.lang.String uid  = GUIDGenerator.generateGUID( solicitud );
		LogHandler.info(uid, getClass(), "consultarAtomos - Datos de entrada :  solicitud=" + solicitud);
		ConsultarAtomosRespuesta respuesta = null;

		try {
			if (solicitud == null || solicitud.trim().isEmpty()) {
				throw new Exception("Es necesario el numero de solicitud para realizar la consulta.");
			}

			AtomosOV consultarAtomosPeticion = new AtomosOV();

			consultarAtomosPeticion.setSolicitud(solicitud.trim());

			if (ordenar != null) {
				consultarAtomosPeticion.setOrdenar(ordenar);
			}

			//Llamado a funci�n principal
			respuesta = solicitudesCredito.consultarAtomosTarea(uid, consultarAtomosPeticion);
			LogHandler.info(uid, getClass(), "consultarAtomos - Datos de salida: " + respuesta);

		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON =  transformador.transformaObjetoAJSON(uid, respuesta);
		LogHandler.info(uid, getClass(), "consultarBuzonTareas - Datos de salida :");
		return respuestaJSON;
	}

	/**
	 * @param solicitud de la peticion.
	 * @param consultaMarcadas de la peticion.
	 * @return JSON respuesta
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/consultarPlanillaObservaciones")
	public String consultarPlanillaObservaciones( @QueryParam("solicitud") String solicitud,
												  @QueryParam("consultaMarcadas") boolean consultaMarcadas
			) {

		LogHandler.info("REST", getClass(), "consultarPlanillaObservaciones");
		final java.lang.String uid  = GUIDGenerator.generateGUID( solicitud );
		LogHandler.info(uid, getClass(), "consultarPlanillaObservaciones - Datos de entrada :  solicitud=" + solicitud);
		PlanillaObservacionesRespuesta respuesta = null;
		try {
			if (solicitud == null || solicitud.trim().isEmpty()) {
				throw new Exception("Es necesario el numero de solicitud para realizar la consulta.");
			}
			PlanillaObservacionesOV consultarPlanillaPeticion = new PlanillaObservacionesOV();
			consultarPlanillaPeticion.setSolicitud(solicitud.trim());
			consultarPlanillaPeticion.setConsultaCanceladas(true);
			consultarPlanillaPeticion.setConsultaMarcadas(consultaMarcadas);

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
		LogHandler.info(uid, getClass(), "consultarPlanillaObservaciones - Datos de salida :");
		return respuestaJSON;
	}


	/**
	 * @param solicitud a cancelar
	 * @param idTarea del buzon
	 * @param motivoCancelacion del buzon
	 * @param proceso proceso de la cancelacion
	 * @param codigoResolucion del proceso de cancelacion
	 * @param personaAnalista que cancela la solicitud
	 * @return JSON respuesta
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/cancelarSolicitud")
	public String cancelarSolicitud(@QueryParam("solicitud") String solicitud,
									@QueryParam("idTarea") String idTarea,
									@QueryParam("proceso") String proceso,
									@QueryParam("codigoResolucion") String codigoResolucion,
									@QueryParam("personaAnalista") String personaAnalista,
									@QueryParam("motivoCancelacion") String motivoCancelacion) {
		LogHandler.info("REST", getClass(), "cancelarSolicitud");
		final java.lang.String uid  = GUIDGenerator.generateGUID( solicitud );
		LogHandler.info(uid, getClass(), "cancelarSolicitud - Datos de entrada :  solicitud=" + solicitud
				+ " idTarea=" + idTarea + " proceso=" + proceso + " codigoResolucion="
				+ " personaAnalista=" + personaAnalista + " motivoCancelacion=" + motivoCancelacion);
		CancelarSolEvaCreRespuesta respuesta = null;
		try {
			if (solicitud == null || solicitud.trim().isEmpty()) {
				throw new Exception("Es necesario el numero de solicitud para realizar la cancelacion.");
			}
			if (idTarea == null || idTarea.trim().isEmpty()) {
				throw new Exception("Es necesario el id de la tarea para realizar la cancelacion.");
			}
			if (proceso == null || proceso.trim().isEmpty()) {
				throw new Exception("Es necesario el proceso para realizar la cancelacion.");
			}
			if (codigoResolucion == null || codigoResolucion.trim().isEmpty()) {
				throw new Exception("Es necesario el codigo de resolucion para realizar la cancelacion.");
			}
			if (personaAnalista == null || personaAnalista.trim().isEmpty()) {
				throw new Exception("Es necesario el usuario para realizar la cancelacion.");
			}
			if (motivoCancelacion == null || motivoCancelacion.trim().isEmpty()) {
				throw new Exception("Es necesario el motivo de cancelacion para realizar la cancelacion.");
			}

			CancelarSolEvaCrePeticion cancelarPeticion = new CancelarSolEvaCrePeticion();
			cancelarPeticion.setSolicitud(solicitud);
			cancelarPeticion.setIdTarea(Integer.valueOf(idTarea));
			cancelarPeticion.setProceso(proceso);
			cancelarPeticion.setCodigoResolucion(codigoResolucion);
			cancelarPeticion.setUsuario(personaAnalista);
			cancelarPeticion.setMotivoCancelacion(motivoCancelacion);

			respuesta =	solicitudesCredito.cancelarSolicitudEvaluacionCrediticiaTarea(uid, cancelarPeticion);
			LogHandler.info(uid, getClass(), "consultarPlanillaObservaciones - Datos de salida: " + respuesta);
		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON =  transformador.transformaObjetoAJSON(uid, respuesta);
		LogHandler.info(uid, getClass(), "consultarPlanillaObservaciones - Datos de salida :");
		return respuestaJSON;
	}


	/**
	 * @param solicitud a confirmar
	 * @param idTarea del buzon
	 * @param proceso proceso de la confirmar
	 * @param codigoResolucion del proceso de confirmar
	 * @param personaAnalista que confirma la solicitud
	 * @return JSON respuesta
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/confirmarSolicitud")
	public String confirmarSolicitud(@QueryParam("solicitud") String solicitud,
									@QueryParam("idTarea") String idTarea,
									@QueryParam("proceso") String proceso,
									@QueryParam("codigoResolucion") String codigoResolucion,
									@QueryParam("personaAnalista") String personaAnalista) {
		LogHandler.info("REST", getClass(), "confirmarSolicitud");
		final java.lang.String uid  = GUIDGenerator.generateGUID( solicitud );
		LogHandler.info(uid, getClass(), "confirmarSolicitud - Datos de entrada :  solicitud=" + solicitud
				+ " idTarea=" + idTarea + " proceso=" + proceso + " codigoResolucion="
				+ " personaAnalista=" + personaAnalista);
		CancelarSolEvaCreRespuesta respuesta = null;
		try {
			if (solicitud == null || solicitud.trim().isEmpty()) {
				throw new Exception("Es necesario el numero de solicitud para realizar la confirmacion.");
			}
			if (idTarea == null || idTarea.trim().isEmpty()) {
				throw new Exception("Es necesario el id de la tarea para realizar la confirmacion.");
			}
			if (proceso == null || proceso.trim().isEmpty()) {
				throw new Exception("Es necesario el proceso para realizar la confirmacion.");
			}
			if (codigoResolucion == null || codigoResolucion.trim().isEmpty()) {
				throw new Exception("Es necesario el codigo de resolucion para realizar la confirmacion.");
			}
			if (personaAnalista == null || personaAnalista.trim().isEmpty()) {
				throw new Exception("Es necesario el usuario para realizar la confirmacion.");
			}

			CancelarSolEvaCrePeticion peticion = new CancelarSolEvaCrePeticion();
			peticion.setSolicitud(solicitud);
			peticion.setIdTarea(Integer.valueOf(idTarea));
			peticion.setProceso(proceso);
			peticion.setCodigoResolucion(codigoResolucion);
			peticion.setUsuario(personaAnalista);

			respuesta =	solicitudesCredito.terminarSolicitudEvaluacionCrediticiaTarea(uid, peticion);
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
	 * @param solicitud a enviar
	 * @param idTarea del buzon
	 * @param proceso proceso de la enviar
	 * @param codigoResolucion del proceso de enviar
	 * @param personaAnalista que envia la solicitud
	 * @return JSON respuesta
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/enviarPlanillaObservacionesSucursal")
	public String enviarPlanillaObservacionesSucursal(@QueryParam("solicitud") String solicitud,
									@QueryParam("idTarea") String idTarea,
									@QueryParam("proceso") String proceso,
									@QueryParam("codigoResolucion") String codigoResolucion,
									@QueryParam("personaAnalista") String personaAnalista) {
		LogHandler.info("REST", getClass(), "enviarPlanillaObservacionesSucursal");
		final java.lang.String uid  = GUIDGenerator.generateGUID( solicitud );
		LogHandler.info(uid, getClass(), "enviarPlanillaObservacionesSucursal - Datos de entrada :  solicitud=" + solicitud
				+ " idTarea=" + idTarea + " proceso=" + proceso + " codigoResolucion="
				+ " personaAnalista=" + personaAnalista);

		EnviarPlaObsSucRespuesta respuesta = null;
		try {
			if (solicitud == null || solicitud.trim().isEmpty()) {
				throw new Exception("Es necesario el numero de solicitud para realizar el envio.");
			}
			if (idTarea == null || idTarea.trim().isEmpty()) {
				throw new Exception("Es necesario el id de la tarea para realizar el envio.");
			}
			if (proceso == null || proceso.trim().isEmpty()) {
				throw new Exception("Es necesario el proceso para realizar el envio.");
			}
			if (codigoResolucion == null || codigoResolucion.trim().isEmpty()) {
				throw new Exception("Es necesario el codigo de resolucion para realizar el envio.");
			}
			if (personaAnalista == null || personaAnalista.trim().isEmpty()) {
				throw new Exception("Es necesario el usuario para realizar el envio.");
			}

			EnviarPlaObsSucPeticion peticion = new EnviarPlaObsSucPeticion();
			peticion.setSolicitud(solicitud);
			peticion.setIdTarea(Integer.valueOf(idTarea));
			peticion.setProceso(proceso);
			peticion.setCodigoResolucion(codigoResolucion);
			peticion.setUsuario(personaAnalista);
			peticion.setPerfil("PSUC");
			peticion.setStatus("P");

			respuesta =	solicitudesCredito.enviarPlanillaObservacionesSucursalTarea(uid, peticion);
		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON =  transformador.transformaObjetoAJSON(uid, respuesta);
		LogHandler.info(uid, getClass(), "enviarPlanillaObservacionesSucursal - Datos de salida :");
		return respuestaJSON;
	}

	/**
	 * @param solicitud a corregir
	 * @param idTarea del buzon
	 * @param proceso proceso de la corregir
	 * @param codigoResolucion del proceso de correccion
	 * @param personaAnalista que envia la correccion la solicitud
	 * @return JSON respuesta
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/correccionPlanillaObservacionesSucursal")
	public String correccionPlanillaObservacionesSucursal(@QueryParam("solicitud") String solicitud,
									@QueryParam("idTarea") String idTarea,
									@QueryParam("proceso") String proceso,
									@QueryParam("codigoResolucion") String codigoResolucion,
									@QueryParam("personaAnalista") String personaAnalista) {
		LogHandler.info("REST", getClass(), "correccionPlanillaObservacionesSucursal");
		final java.lang.String uid  = GUIDGenerator.generateGUID( solicitud );
		LogHandler.info(uid, getClass(), "correccionPlanillaObservacionesSucursal - Datos de entrada :  solicitud=" + solicitud
				+ " idTarea=" + idTarea + " proceso=" + proceso + " codigoResolucion="
				+ " personaAnalista=" + personaAnalista);

		CorregirPlaObsSucRespuesta respuesta = null;
		try {
			if (solicitud == null || solicitud.trim().isEmpty()) {
				throw new Exception("Es necesario el numero de solicitud para realizar la correccion.");
			}
			if (idTarea == null || idTarea.trim().isEmpty()) {
				throw new Exception("Es necesario el id de la tarea para realizar la correccion.");
			}
			if (proceso == null || proceso.trim().isEmpty()) {
				throw new Exception("Es necesario el proceso para realizar la correccion.");
			}
			if (codigoResolucion == null || codigoResolucion.trim().isEmpty()) {
				throw new Exception("Es necesario el codigo de resolucion para realizar la correccion.");
			}
			if (personaAnalista == null || personaAnalista.trim().isEmpty()) {
				throw new Exception("Es necesario el usuario para realizar la correccion.");
			}

			CorregirPlaObsSucPeticion peticion = new CorregirPlaObsSucPeticion();
			peticion.setSolicitud(solicitud);
			peticion.setIdTarea(Integer.valueOf(idTarea));
			peticion.setProceso(proceso);
			peticion.setCodigoResolucion(codigoResolucion);
			peticion.setUsuario(personaAnalista);

			respuesta =	solicitudesCredito.corregirPlanillaObservacionesSucursalTarea(uid, peticion);
		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON =  transformador.transformaObjetoAJSON(uid, respuesta);
		LogHandler.info(uid, getClass(), "correccionPlanillaObservacionesSucursal - Datos de salida :");
		return respuestaJSON;
	}

	/**
	 * @param solicitud de la peticion.
	 * @param planillaJson de la peticion.
	 * @param idPlanilla de la solicitud
	 * @return JSON respuesta
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/consultarPlanillaAprobacion")
	public String consultarPlanillaAprobacion(@QueryParam("solicitud") String solicitud,
			@QueryParam("planillaJson") boolean planillaJson, @QueryParam("idPlanilla") Integer idPlanilla) {
		LogHandler.info("REST", getClass(), "consultarPlanillaAprobacion");
		final java.lang.String uid  = GUIDGenerator.generateGUID( this.getClass() );

		LogHandler.info(uid, getClass(), "consultarPlanillaAprobacion - Datos de entrada :  planillaJson=" + planillaJson);
		PlanillaAprobacionRespuestaDTO respuesta = null;
		PlanillaAprobacionPeticionDTO consultarPlanillaPeticion = null;
		String respuestaJSON = null;

		try {
			if (planillaJson) {
				consultarPlanillaPeticion = new PlanillaAprobacionPeticionDTO();
				consultarPlanillaPeticion.setPlanillaJson(planillaJson);
				consultarPlanillaPeticion.setIdPlanilla(idPlanilla);
				respuesta = solicitudesCredito.consultarPlanillaAprobacionTarea(uid, consultarPlanillaPeticion, null);

			} else {

				LogHandler.info(uid, getClass(), "consultarPlanillaAprobacion - Datos de entrada :  solicitud=" + solicitud);

				if (solicitud == null || solicitud.trim().isEmpty()) {
					throw new Exception("Es necesario el numero de solicitud para realizar la consulta.");
				}
				consultarPlanillaPeticion = new PlanillaAprobacionPeticionDTO();
				consultarPlanillaPeticion.setSolicitud(solicitud.trim());
				consultarPlanillaPeticion.setTotales(true);
				consultarPlanillaPeticion.setPlanillaJson(planillaJson);
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
	 * @param planillaJson de la peticion.
	 * @param idPlanilla de la solicitud
	 * @return JSON respuesta
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/consultarPlanillaAprobacionJson")
	public String consultarPlanillaAprobacionJson(@QueryParam("planillaJson") boolean planillaJson,
			@QueryParam("idPlanilla") Integer idPlanilla) {
		LogHandler.info("REST", getClass(), "consultarPlanillaAprobacionJson");
		final java.lang.String uid  = GUIDGenerator.generateGUID(this.getClass());

		PlanillaAprobacionRespuestaDTO respuesta = null;
		PlanillaAprobacionPeticionDTO consultarPlanillaPeticion = null;
		String respuestaJSON = null;

		try {
			if (idPlanilla == null || idPlanilla <= 0) {
				throw new Exception("Es necesario el idPlanilla para realizar la consulta.");
			}

				consultarPlanillaPeticion = new PlanillaAprobacionPeticionDTO();
				consultarPlanillaPeticion.setPlanillaJson(planillaJson);
				consultarPlanillaPeticion.setIdPlanilla(idPlanilla);
				respuesta = solicitudesCredito.consultarPlanillaAprobacionTarea(uid, consultarPlanillaPeticion, null);

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

	// excepcion buzon tareas

	/**
	 * @param tipoTarea del buzon
	 * @param sucursal de la excepcion
	 * @param descripcion de la excepcion
	 * @param usuarioAlta qeu registra la excepcion
	 * @param perfil .
	 * @param status estatus de la excepcion
	 * @param justificacion de la excepcion
	 * @return JSON respuesta
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/generarTareaExcepcionGarantia")
	public String generarTareaExcepcionGarantia(@QueryParam("tipoTarea") String tipoTarea,
									@QueryParam("sucursal") String sucursal,
									@QueryParam("descripcion") String descripcion,
									@QueryParam("usuarioAlta") String usuarioAlta,
									@QueryParam("perfil") String perfil,
									@QueryParam("status") String status,
									@QueryParam("justificacion") String justificacion) {
		LogHandler.info("REST", getClass(), "generarTareaExcepcionGarantia");
		final java.lang.String uid  = GUIDGenerator.generateGUID( tipoTarea );
		LogHandler.info(uid, getClass(), "generarTareaExcepcionGarantia - Datos de entrada :  tipoTarea=" + tipoTarea
				+ " sucursal=" + sucursal + " descripcion=" + descripcion + " usuarioAlta=" + usuarioAlta
				+ " perfil=" + perfil + " status=" + status + " justificacion=" + justificacion);
		ExcepcionGarantiaRespuesta respuesta = null;
		try {
			if (tipoTarea == null || tipoTarea.trim().isEmpty()) {
				throw new Exception("Es necesario el numero de solicitud para generar tarea excepcion.");
			}
			if (sucursal == null || sucursal.trim().isEmpty()) {
				throw new Exception("Es necesario el numero de sucursal para generar tarea excepcion.");
			}
			if (descripcion == null || descripcion.trim().isEmpty()) {
				throw new Exception("Es necesarila descripcion para generar tarea excepcion.");
			}
			if (usuarioAlta == null || usuarioAlta.trim().isEmpty()) {
				throw new Exception("Es necesario el usuarioAlta para generar tarea excepcion.");
			}
			if (perfil == null || perfil.trim().isEmpty()) {
				throw new Exception("Es necesario el perfil para generar tarea excepcion.");
			}
			if (status == null || status.trim().isEmpty()) {
				throw new Exception("Es necesario el status para generar tarea excepcion.");
			}
			if (justificacion == null || justificacion.trim().isEmpty()) {
				throw new Exception("Es necesarila justificacion para generar tarea excepcion.");
			}
			ExcepcionGarantiaPeticion exTareaPeticion = new ExcepcionGarantiaPeticion();

			exTareaPeticion.setTipoTarea(tipoTarea);
			exTareaPeticion.setSucursal(sucursal);
			exTareaPeticion.setDescripcion(descripcion);
			exTareaPeticion.setUsuarioAlta(usuarioAlta);
			exTareaPeticion.setPerfil(perfil);
			exTareaPeticion.setStatus(status);
			exTareaPeticion.setJustificacion(justificacion);

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
	 * @param idDivision .
	 * @return JSON respuesta
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/obtenerBuzonExcepcionGarantia")
	public String obtenerBuzonExcepcionGarantia(@QueryParam("idDivision") String idDivision) {
		LogHandler.info("REST", getClass(), "obtenerBuzonExcepcionGarantia");
		final java.lang.String uid  = GUIDGenerator.generateGUID( idDivision );
		LogHandler.info(uid, getClass(), "obtenerBuzonExcepcionGarantiaTarea - Datos de entrada :  idDivision=" + idDivision);
		ExcepcionGarantiaRespuesta respuesta = null;
		try {
			if (idDivision == null || idDivision.trim().isEmpty()) {
				throw new Exception("Es necesario id de division para obtener las tareas excepcion.");
			}

			ExcepcionGarantiaPeticion exTareaPeticion = new ExcepcionGarantiaPeticion();

			exTareaPeticion.setIdDivision(Integer.parseInt(idDivision));

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
	 * @param idTarea .
	 * @return JSON respuesta
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/obtenerBuzonExcepcionGarantiaPorIdTarea")
	public String obtenerBuzonExcepcionGarantiaPorIdTarea(@QueryParam("idTarea") String idTarea) {
		LogHandler.info("REST", getClass(), "obtenerBuzonExcepcionGarantiaPorIdTarea");
		final java.lang.String uid  = GUIDGenerator.generateGUID( idTarea );
		LogHandler.info(uid, getClass(), "obtenerBuzonExcepcionGarantiaPorIdTarea - Datos de entrada :  idTarea=" + idTarea);
		ExcepcionGarantiaRespuesta respuesta = null;
		try {
			if (idTarea == null || idTarea.trim().isEmpty()) {
				throw new Exception("Es necesario id tarea para obtener las tareas excepcion.");
			}

			ExcepcionGarantiaPeticion exTareaPeticion = new ExcepcionGarantiaPeticion();

			exTareaPeticion.setIdTarea(Integer.parseInt(idTarea));

			respuesta =	solicitudesCredito.obtenerBuzonExcepcionGarantiaPorIdTareaTarea(uid, exTareaPeticion);
			LogHandler.info(uid, getClass(), "obtenerBuzonExcepcionGarantiaPorIdTarea - Datos de salida: " + respuesta);
		} catch (Exception ex) {
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}

		final java.lang.String respuestaJSON =  transformador.transformaObjetoAJSON(uid, respuesta);
		LogHandler.info(uid, getClass(), "obtenerBuzonExcepcionGarantiaPorIdTarea - Datos de salida :");
		return respuestaJSON;
	}

	/**
	 * @param tipoTarea .
	 * @return JSON respuesta
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/obtenerBuzonExPorTipoTarea")
	public String obtenerBuzonExPorTipoTarea(@QueryParam("tipoTarea") String tipoTarea) {
		LogHandler.info("REST", getClass(), "obtenerBuzonExPorTipoTarea");
		final java.lang.String uid  = GUIDGenerator.generateGUID( tipoTarea );
		LogHandler.info(uid, getClass(), "obtenerBuzonExPorTipoTarea - Datos de entrada :  tipoTarea=" + tipoTarea);
		BuzonOV respuesta = null;
		try {
			if (tipoTarea == null || tipoTarea.trim().isEmpty()) {
				throw new Exception("Es necesario tipo tarea para obtener las tareas excepcion.");
			}

			ExcepcionGarantiaPeticion exTareaPeticion = new ExcepcionGarantiaPeticion();

			exTareaPeticion.setTipoTarea(tipoTarea);

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
	 * @param idDivision .
	 * @param complemento .
	 * @return JSON respuesta
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/obtenerComplementoBuzonExcepcionGarantia")
	public String obtenerComplementoBuzonExcepcionGarantia(@QueryParam("idDivision") String idDivision,
			@QueryParam("complemento") String complemento) {
		LogHandler.info("REST", getClass(), "obtenerComplementoBuzonExcepcionGarantia");
		final java.lang.String uid  = GUIDGenerator.generateGUID( idDivision );
		LogHandler.info(uid, getClass(), "obtenerComplementoBuzonExcepcionGarantia - Datos de entrada :  idDivision=" + idDivision
				+ " complemento=" + complemento);

		ExcepcionGarantiaRespuesta respuesta = null;
		try {
			if (idDivision == null || idDivision.trim().isEmpty()) {
				throw new Exception("Es necesario id de division para obtener las tareas excepcion.");
			}

			ExcepcionGarantiaPeticion exTareaPeticion = new ExcepcionGarantiaPeticion();

			exTareaPeticion.setIdDivision(Integer.parseInt(idDivision));
			exTareaPeticion.setComplemento(complemento);

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
	 * @param idTarea .
	 * @param usuarioAut .
	 * @param observaciones .
	 * @param tipoTarea .
	 * @param sucursal .
	 * @param descripcion .
	 * @param usuarioAlta .
	 * @param perfil .
	 * @param status .
	 * @param justificacion .
	 * @return JSON respuesta
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/autorizaBuzonExcepcion")
	public String autorizaBuzonExcepcion(
			@QueryParam("tipoTarea") String tipoTarea,
			@QueryParam("sucursal") String sucursal,
			@QueryParam("descripcion") String descripcion,
			@QueryParam("usuarioAlta") String usuarioAlta,
			@QueryParam("perfil") String perfil,
			@QueryParam("status") String status,
			@QueryParam("justificacion") String justificacion,
			@QueryParam("idTarea") String idTarea,
			@QueryParam("usuarioAut") String usuarioAut,
			@QueryParam("observaciones") String observaciones) {
		LogHandler.info("REST", getClass(), "autorizaBuzonExcepcion");
		final java.lang.String uid  = GUIDGenerator.generateGUID( idTarea );
		LogHandler.info(uid, getClass(), "autorizaBuzonExcepcion - Datos de entrada :  idTarea=" + idTarea);
		ExcepcionGarantiaRespuesta respuesta = null;
		try {
			if (idTarea == null || idTarea.trim().isEmpty()) {
				throw new Exception("Es necesario id de la tarea para autorizar la excepcion.");
			}
			if (tipoTarea == null || tipoTarea.trim().isEmpty()) {
				throw new Exception("Es necesario el numero de solicitud para generar tarea excepcion.");
			}
			if (sucursal == null || sucursal.trim().isEmpty()) {
				throw new Exception("Es necesario el numero de sucursal para generar tarea excepcion.");
			}
			if (descripcion == null || descripcion.trim().isEmpty()) {
				throw new Exception("Es necesarila descripcion para generar tarea excepcion.");
			}
			if (usuarioAlta == null || usuarioAlta.trim().isEmpty()) {
				throw new Exception("Es necesario el usuarioAlta para generar tarea excepcion.");
			}
			if (perfil == null || perfil.trim().isEmpty()) {
				throw new Exception("Es necesario el perfil para generar tarea excepcion.");
			}
			if (status == null || status.trim().isEmpty()) {
				throw new Exception("Es necesario el status para generar tarea excepcion.");
			}
			if (justificacion == null || justificacion.trim().isEmpty()) {
				throw new Exception("Es necesarila justificacion para generar tarea excepcion.");
			}

			ExcepcionGarantiaPeticion exTareaPeticion = new ExcepcionGarantiaPeticion();

			exTareaPeticion.setIdTarea(Integer.parseInt(idTarea));
			exTareaPeticion.setUsuarioAut(usuarioAut);
			exTareaPeticion.setObservaciones(observaciones);
			exTareaPeticion.setTipoTarea(tipoTarea);
			exTareaPeticion.setSucursal(sucursal);
			exTareaPeticion.setDescripcion(descripcion);
			exTareaPeticion.setUsuarioAlta(usuarioAlta);
			exTareaPeticion.setPerfil(perfil);
			exTareaPeticion.setStatus(status);
			exTareaPeticion.setJustificacion(justificacion);

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
	 * @param idTarea .
	 * @param usuarioAut .
	 * @param observaciones .
	 * @param tipoTarea .
	 * @param sucursal .
	 * @param descripcion .
	 * @param usuarioAlta .
	 * @param perfil .
	 * @param status .
	 * @param justificacion .
	 * @return JSON respuesta
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/rechazaBuzonExcepcionTarea")
	public String rechazaBuzonExcepcion(
			@QueryParam("tipoTarea") String tipoTarea,
			@QueryParam("sucursal") String sucursal,
			@QueryParam("descripcion") String descripcion,
			@QueryParam("usuarioAlta") String usuarioAlta,
			@QueryParam("perfil") String perfil,
			@QueryParam("status") String status,
			@QueryParam("justificacion") String justificacion,
			@QueryParam("idTarea") String idTarea,
			@QueryParam("usuarioAut") String usuarioAut,
			@QueryParam("observaciones") String observaciones) {
		LogHandler.info("REST", getClass(), "rechazaBuzonExcepcion");
		final java.lang.String uid  = GUIDGenerator.generateGUID( idTarea );
		LogHandler.info(uid, getClass(), "rechazaBuzonExcepcionTarea - Datos de entrada :  idTarea=" + idTarea);
		ExcepcionGarantiaRespuesta respuesta = null;
		try {
			if (idTarea == null || idTarea.trim().isEmpty()) {
				throw new Exception("Es necesario id de la tarea para autorizar la excepcion.");
			}
			if (tipoTarea == null || tipoTarea.trim().isEmpty()) {
				throw new Exception("Es necesario el numero de solicitud para generar tarea excepcion.");
			}
			if (sucursal == null || sucursal.trim().isEmpty()) {
				throw new Exception("Es necesario el numero de sucursal para generar tarea excepcion.");
			}
			if (descripcion == null || descripcion.trim().isEmpty()) {
				throw new Exception("Es necesarila descripcion para generar tarea excepcion.");
			}
			if (usuarioAlta == null || usuarioAlta.trim().isEmpty()) {
				throw new Exception("Es necesario el usuarioAlta para generar tarea excepcion.");
			}
			if (perfil == null || perfil.trim().isEmpty()) {
				throw new Exception("Es necesario el perfil para generar tarea excepcion.");
			}
			if (status == null || status.trim().isEmpty()) {
				throw new Exception("Es necesario el status para generar tarea excepcion.");
			}
			if (justificacion == null || justificacion.trim().isEmpty()) {
				throw new Exception("Es necesarila justificacion para generar tarea excepcion.");
			}

			ExcepcionGarantiaPeticion exTareaPeticion = new ExcepcionGarantiaPeticion();

			exTareaPeticion.setIdTarea(Integer.parseInt(idTarea));
			exTareaPeticion.setUsuarioAut(usuarioAut);
			exTareaPeticion.setObservaciones(observaciones);
			exTareaPeticion.setTipoTarea(tipoTarea);
			exTareaPeticion.setSucursal(sucursal);
			exTareaPeticion.setDescripcion(descripcion);
			exTareaPeticion.setUsuarioAlta(usuarioAlta);
			exTareaPeticion.setPerfil(perfil);
			exTareaPeticion.setStatus(status);
			exTareaPeticion.setJustificacion(justificacion);

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
	 * @param numeroGrupo del buzon
	 * @return JSON respuesta
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/obtenerCreditosAnteriores")
	public String obtenerCreditosAnteriores(@QueryParam("numeroGrupo") String numeroGrupo) {
		LogHandler.info("REST", getClass(), "obtenerCreditosAnteriores");
		final java.lang.String uid  = GUIDGenerator.generateGUID( numeroGrupo );
		LogHandler.info(uid, getClass(), "obtenerCreditosAnteriores - Datos de entrada :  numeroGrupo =" + numeroGrupo);
		BuroCreditoClienteDetalleGrupoRespuesta respuesta = null;

		try {
			if (numeroGrupo == null || numeroGrupo.trim().isEmpty()) {
				throw new Exception("Es necesario el numero de grupo para obtener los creditos anteriores.");
			}

			BuroCreditoClienteDetalleGrupoPeticion detalleGrupoPet = new BuroCreditoClienteDetalleGrupoPeticion();

			detalleGrupoPet.setPrmGrupo(numeroGrupo);

			//Llamado a funcion principal
			respuesta = buroCreditoTarea.prGetDetalleGrupoTarea(uid, detalleGrupoPet);

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
	 * @param idTarea .
	 * @param usuarioEnt .
	 * @return JSON respuesta
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/accionEnteradoIdTareaExcepcion")
	public String accionEnteradoIdTareaExcepcion(
			@QueryParam("idTarea") String idTarea,
			@QueryParam("usuarioEnt") String usuarioEnt) {
		LogHandler.info("REST", getClass(), "accionEnteradoIdTareaExcepcion");
		final java.lang.String uid  = GUIDGenerator.generateGUID( idTarea );
		LogHandler.info(uid, getClass(), "accionEnteradoIdTareaExcepcion - Datos de entrada :  idTarea=" + idTarea);
		ExcepcionGarantiaRespuesta respuesta = null;
		try {
			if (idTarea == null || idTarea.trim().isEmpty()) {
				throw new Exception("Es necesario id de la tarea para la accion enterado la excepcion.");
			}

			ExcepcionGarantiaPeticion exTareaPeticion = new ExcepcionGarantiaPeticion();

			exTareaPeticion.setIdTarea(Integer.parseInt(idTarea));

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
	 * @param idSolicitud .
	 * @return JSON respuesta
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/obtenerExcepcionNombreDivisional")
	public String obtenerExcepcionNombreDivisional(@QueryParam("idSolicitud") String idSolicitud) {
		LogHandler.info("REST", getClass(), "obtenerExcepcionNombreDivisional");
		final java.lang.String uid  = GUIDGenerator.generateGUID( idSolicitud );
		LogHandler.info(uid, getClass(), "obtenerExcepcionNombreDivisional - Datos de entrada :  idSolicitud=" + idSolicitud);

		ExcepcionGarantiaRespuesta respuesta = null;
		try {
			if (idSolicitud == null || idSolicitud.trim().isEmpty()) {
				throw new Exception("Es necesario id de la solicitud para obtener las tareas excepcion.");
			}

			ExcepcionGarantiaPeticion exTareaPeticion = new ExcepcionGarantiaPeticion();

			exTareaPeticion.setSolicitud(idSolicitud);


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
	 * @param idTarea .
	 * @return JSON respuesta
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/registroInicioGestionCEC")
	public String registroInicioGestionCEC(@QueryParam("idTarea") String idTarea) {
		LogHandler.info("REST", getClass(), "registroInicioGestionCEC");
		final java.lang.String uid  = GUIDGenerator.generateGUID( idTarea );
		LogHandler.info(uid, getClass(), "registroInicioGestionCEC - Datos de entrada :  idSolicitud=" + idTarea);

		ExcepcionGarantiaRespuesta respuesta = new ExcepcionGarantiaRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		try {
			if (idTarea == null || idTarea.trim().isEmpty()) {
				throw new Exception("Es necesario id de la tarea para registrar el inicio gestion.");
			}

			int iIdTarea = 0;
			try {
				iIdTarea = Integer.valueOf(idTarea);
			} catch (Exception ex) {
				throw new Exception("El id tarea enviado no es valido debe ser entero.");
			}

			if (iIdTarea <= 0) {
				throw new Exception("El id tarea enviado no es valido debe ser mayor a cero.");
			}

			ExcepcionGarantiaPeticion exTareaPeticion = new ExcepcionGarantiaPeticion();
			exTareaPeticion.setIdTarea(iIdTarea);

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

}
