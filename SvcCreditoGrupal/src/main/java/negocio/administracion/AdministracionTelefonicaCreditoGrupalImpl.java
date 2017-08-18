package negocio.administracion;

import org.osoa.sca.annotations.Reference;

import tarea.administracion.AdministracionTelefonica;
import transformador.Transformador;
import utilitario.comun.GUIDGenerator;
import utilitario.log.LogHandler;
import utilitario.mensajes.comun.EncabezadoRespuesta;

import utilitario.mensajes.persona.TelefonoOV;
import utilitario.mensajes.verificacion.telefonica.BitacoraVerificacionFinsolOV;
import utilitario.mensajes.verificacion.telefonica.ConsultaInformacionTelefonicaPeticion;
import utilitario.mensajes.verificacion.telefonica.ConsultaInformacionTelefonicaRespuesta;
import utilitario.mensajes.verificacion.telefonica.ConsultaSolicitudesVerificacionPeticion;
import utilitario.mensajes.verificacion.telefonica.ConsultaSolicitudesVerificacionRespuesta;
import utilitario.mensajes.verificacion.telefonica.EstadoSolicitudOV;
import utilitario.mensajes.verificacion.telefonica.IntegrantesOV;
import utilitario.mensajes.verificacion.telefonica.RegistraBitacoraPeticion;
import utilitario.mensajes.verificacion.telefonica.RegistraBitacoraRespuesta;
import utilitario.mensajes.verificacion.telefonica.RespuestainformacionVerificacion;
import utilitario.mensajes.verificacion.telefonica.SolicitudOV;
import utilitario.mensajes.verificacion.telefonica.ValidaStatusSolicitudPeticion;
import utilitario.mensajes.verificacion.telefonica.ValidaStatusSolicitudRespuesta;

public 	class 		AdministracionTelefonicaCreditoGrupalImpl
		implements	AdministracionTelefonicaCreditoGrupal {

	/**
	 * SCA Component Fabric
	 */
	private AdministracionTelefonica administracionTelefonica;
	/**
	 * SCA Component Fabric
	 */
	private Transformador transformador;

	/**
	 * SCA Component Fabric
	 * @param administracionTelefonica :
	 * @param transformador :
	 */
	public AdministracionTelefonicaCreditoGrupalImpl(
			@Reference(name = "administracionTelefonica") AdministracionTelefonica administracionTelefonica,
			@Reference(name = "transformador") Transformador transformador
			) {
		this.administracionTelefonica = administracionTelefonica;
		this.transformador = transformador;
		}

	/**
	 * @param peticion de solicitud
	 * @return respuesta XML
	 */
	public String consultaInformacionVerificacion(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "consultaInformacionVerificacion - Datos de entrada XML: " + peticion);


		//Parametros de entrada
		final Class<?>[] clases = {ConsultaInformacionTelefonicaPeticion.class,
								   ConsultaInformacionTelefonicaRespuesta.class,
								   EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ConsultaInformacionTelefonicaPeticion consultaInformacionpeticion =
					(ConsultaInformacionTelefonicaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultaInformacionVerificacion - Datos de entrada : " + consultaInformacionpeticion);

		//Llamado a funcion principal
		final ConsultaInformacionTelefonicaRespuesta respuesta =
				administracionTelefonica.consultaInformacionVerificacion(uid, consultaInformacionpeticion);
		LogHandler.info(uid, getClass(), "consultaInformacionVerificacion - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "consultaInformacionVerificacion - Datos de salida XML: " + respuestaXML);
		return respuestaXML;


	}

	/**
	 * @param peticion de solicitud
	 * @return respuesta XML
	 */
	public String bitacoraVerificacionTelefonica(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "bitacoraVerificacionTelefonica - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {RegistraBitacoraPeticion.class,
									RegistraBitacoraRespuesta.class,
									  EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final RegistraBitacoraPeticion registraBitacoraPeticion =
						(RegistraBitacoraPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "bitacoraVerificacionTelefonica - Datos de entrada : " + registraBitacoraPeticion);

		//Se genera la salida

		final RegistraBitacoraRespuesta respuesta =
						administracionTelefonica.bitacoraVerificacionTelefonica(uid, registraBitacoraPeticion, null);
		LogHandler.info(uid, getClass(), "bitacoraVerificacionTelefonica - Datos de salida : " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "bitacoraVerificacionTelefonica - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
		}

	/**
	 * @param peticion de solicitud
	 * @return respuesta XML
	 */
	public String respuestaInformacionVerificacion(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "respuestainformacionVerificacion - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {RespuestainformacionVerificacion.class,
								   EncabezadoRespuesta.class};

		//Se genera la salida
		final RespuestainformacionVerificacion respuesta =
						administracionTelefonica.respuestainformacionVerificacion(uid, peticion);
		LogHandler.info(uid, getClass(), "respuestainformacionVerificacion - Datos de salida : " + respuesta);


		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "bitacoraVerificacionTelefonica - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
		}

	/**
	 * @param peticion de solicitud
	 * @return respuesta XML
	 */
	public String consultaEstadoVerificacion(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "consultaEstadoVerificacion - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ValidaStatusSolicitudPeticion.class,
								   ValidaStatusSolicitudRespuesta.class,
								   EstadoSolicitudOV.class,
								   BitacoraVerificacionFinsolOV.class,
								   SolicitudOV.class,
								   IntegrantesOV.class,
								   TelefonoOV.class,
								   EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ValidaStatusSolicitudPeticion validaStatusSolicitudPeticion =
				(ValidaStatusSolicitudPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultaEstadoVerificacion - Datos de entrada : " + validaStatusSolicitudPeticion);

		//Llamado a funcion principal
		final ValidaStatusSolicitudRespuesta respuesta =
					administracionTelefonica.validaEstadoSolicitud(uid, validaStatusSolicitudPeticion);
		LogHandler.info(uid, getClass(), "consultaEstadoVerificacion - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "consultaEstadoVerificacion - Datos de salida XML: " + respuestaXML);
		return respuestaXML;


		}

	/**
	 * @param peticion de solicitud
	 * @return respuesta XML
	 */
	public String consultaSolicitudesVerificacion(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "consultaSolicitudesVerificacion - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ConsultaSolicitudesVerificacionPeticion.class,
								   ConsultaSolicitudesVerificacionRespuesta.class,
								   EstadoSolicitudOV.class,
								   BitacoraVerificacionFinsolOV.class,
								   SolicitudOV.class,
//								   IntegrantesOV.class,
//								   TelefonoOV.class,
								   EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ConsultaSolicitudesVerificacionPeticion   validaSolicitudes =
					(ConsultaSolicitudesVerificacionPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultaSolicitudesVerificacion - Datos de entrada : " + validaSolicitudes);

		//Llamado a funcion principal
		final ConsultaSolicitudesVerificacionRespuesta respuesta =
					administracionTelefonica.consultaSolicitudVerificaciones(uid, validaSolicitudes);
		LogHandler.info(uid, getClass(), "consultaSolicitudesVerificacion - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "consultaSolicitudesVerificacion - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

}
