package negocio.administracion;

import java.util.List;

import org.oasisopen.sca.annotation.Reference;

import tarea.administracion.AdministracionPersona;
import transformador.Transformador;
import utilitario.comun.GUIDGenerator;
import utilitario.log.LogHandler;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.originacion.consulta.ContratoRenovacionPeticion;
import utilitario.mensajes.persona.ActualizarPersonaRespuesta;
import utilitario.mensajes.persona.ConsultaDatosGeneralesPeticion;
import utilitario.mensajes.persona.ConsultaDatosGeneralesRespuesta;
import utilitario.mensajes.persona.ConsultarPersonaPeticion;
import utilitario.mensajes.persona.ConsultarPersonaRespuesta;
import utilitario.mensajes.persona.ConsultarPersonaRespuestaOV;
import utilitario.mensajes.persona.DetalleSocioeconomicoOV;
import utilitario.mensajes.persona.DireccionElectronicaOV;
import utilitario.mensajes.persona.DomicilioOV;
import utilitario.mensajes.persona.PerfilTemporal;
import utilitario.mensajes.persona.PerfilTemporalRespuesta;
import utilitario.mensajes.persona.PersonaOV;
import utilitario.mensajes.persona.RegistrarPersonaPeticion;
import utilitario.mensajes.persona.RegistrarPersonaRespuesta;
import utilitario.mensajes.persona.RelacionClaveFinsolOV;
import utilitario.mensajes.persona.RelacionPersonaOV;
import utilitario.mensajes.persona.TelefonoOV;
import utilitario.mensajes.persona.ValidarCurpPersonaPeticion;
import utilitario.mensajes.persona.ValidarCurpPersonaRespuesta;
import utilitario.mensajes.persona.ValidarDatosPersonaPeticion;
import utilitario.mensajes.persona.ValidarDatosPersonaRespuesta;

/**
 * @author out_mreyes@independencia.com.mx
 *
 */
public class AdministracionPersonaFINDEPImpl implements AdministracionPersonaFINDEP
	{
	//Atributos que seran inyectados a traves de fabric
	/**
	 * SCA Component Fabric
	 */
	private Transformador transformador;
	/**
	 * SCA Component Fabric
	 */
	private AdministracionPersona administracionPersona;


	/**
	 * Constructor
	 * SCA Component Fabric
	 * @param administracionPersona :
	 * @param transformador :
	 */
	public AdministracionPersonaFINDEPImpl(@Reference(name = "administracionPersona")
											AdministracionPersona administracionPersona ,
									  		@Reference(name = "transformador") Transformador transformador) {
		this.administracionPersona = administracionPersona;
		this.transformador = transformador;
		}

	/**
	 * @param peticion del registro persona
	 * @return XML respuesta
	 */
	public String registrarPersona(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		//LogHandler.info(uid, getClass(), "registrarPersona - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {RegistrarPersonaPeticion.class,
								   RegistrarPersonaRespuesta.class,
								   PersonaOV.class,
								   DomicilioOV.class,
								   TelefonoOV.class,
								   DetalleSocioeconomicoOV.class,
								   DireccionElectronicaOV.class,
								   RelacionPersonaOV.class,
								   RelacionClaveFinsolOV.class,
								   EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final RegistrarPersonaPeticion
			  registrarPersonaPeticion = (RegistrarPersonaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "registrarPersona - Datos de entrada : " + registrarPersonaPeticion);

		//Llamado a funcion principal
		final RegistrarPersonaRespuesta respuesta = administracionPersona.registrarPersona(uid, registrarPersonaPeticion );
		LogHandler.info(uid, getClass(), "registrarPersona - Datos de salida : " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		//LogHandler.info(uid, getClass(), "registrarPersona - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
		}

	/**
	 * @param peticion del registro persona
	 * @return XML respuesta
	 */
	public String actualizarPersona(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		//LogHandler.info(uid, getClass(), "actualizarPersona - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {RegistrarPersonaPeticion.class,
								   RegistrarPersonaRespuesta.class,
								   ActualizarPersonaRespuesta.class,
								   PersonaOV.class,
								   DomicilioOV.class,
								   TelefonoOV.class,
								   DetalleSocioeconomicoOV.class,
								   DireccionElectronicaOV.class,
								   RelacionPersonaOV.class,
								   RelacionClaveFinsolOV.class,
								   EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final RegistrarPersonaPeticion
			  registrarPersonaPeticion = (RegistrarPersonaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "actualizarPersona - Datos de entrada : " + registrarPersonaPeticion);

		//Llamado a funcion principal
		final ActualizarPersonaRespuesta respuesta = administracionPersona.actualizarPersona(uid, registrarPersonaPeticion );
		LogHandler.info(uid, getClass(), "actualizarPersona - Datos de salida : " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		//LogHandler.info(uid, getClass(), "actualizarPersona - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}


	/**
	 * @param peticion :
	 * @return String
	 */
	public String consultarPersona(String peticion) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		//LogHandler.info(uid, getClass(), "consultarPersona - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ConsultarPersonaPeticion.class,
								   ConsultarPersonaRespuesta.class,
								   PersonaOV.class,
								   DomicilioOV.class,
								   TelefonoOV.class,
								   DetalleSocioeconomicoOV.class,
								   DireccionElectronicaOV.class,
								   RelacionPersonaOV.class,
								   RelacionClaveFinsolOV.class,
								   EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ConsultarPersonaPeticion
			  consultarPersonaPeticion = (ConsultarPersonaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultarPersona - Datos de entrada : " + consultarPersonaPeticion);

		//Llamado a funcion principal
		final ConsultarPersonaRespuesta respuesta = administracionPersona.consultarDatosPersona(uid, consultarPersonaPeticion );
		LogHandler.info(uid, getClass(), "consultarPersona - Datos de salida : " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		return respuestaXML;
	}

	/**
	 * @param peticion :
	 * @return String
	 */
	public String registrarProspecto(String peticion) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		//LogHandler.info(uid, getClass(), "registrarProspecto - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {RegistrarPersonaPeticion.class,
								   RegistrarPersonaRespuesta.class,
								   PersonaOV.class,
								   DomicilioOV.class,
								   RelacionClaveFinsolOV.class,
								   EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final RegistrarPersonaPeticion
			  registrarPersonaPeticion = (RegistrarPersonaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "registrarProspecto - Datos de entrada : " + registrarPersonaPeticion);

		//Llamado a funcion principal
		final RegistrarPersonaRespuesta respuesta = administracionPersona.registrarProspecto(uid, registrarPersonaPeticion );
		LogHandler.info(uid, getClass(), "registrarProspecto - Datos de salida : " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		//LogHandler.info(uid, getClass(), "registrarProspecto - Datos de salida XML: " + respuestaXML);
		return respuestaXML;


	}

	/**
	 * @param peticion :
	 * @return String
	 */
	public String consultaDatosGeneralesPersona(String peticion) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		//LogHandler.info(uid, getClass(), "consultaDatosGeneralesPersona - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ConsultaDatosGeneralesRespuesta.class,
								   ConsultaDatosGeneralesPeticion.class,
								   PersonaOV.class,
								   DomicilioOV.class,
								   TelefonoOV.class,
								   DetalleSocioeconomicoOV.class,
								   DireccionElectronicaOV.class,
								   RelacionPersonaOV.class,
								   RelacionClaveFinsolOV.class,
								   EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ConsultaDatosGeneralesPeticion consultaDatosGeneralesPeticion =
			  (ConsultaDatosGeneralesPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultaDatosGeneralesPersona - Datos de entrada : " + consultaDatosGeneralesPeticion);

		//Llamado a funcion principal
		final ConsultaDatosGeneralesRespuesta respuesta =
				administracionPersona.consultaDatosGeneralesPersona(uid, consultaDatosGeneralesPeticion );
		LogHandler.info(uid, getClass(), "consultaDatosGeneralesPersona - Datos de salida : " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		//LogHandler.info(uid, getClass(), "consultaDatosGeneralesPersona - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion :
	 * @return String
	 */
	public String verificarPersona(String peticion) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		//LogHandler.info(uid, getClass(), "verificarPersona - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ConsultarPersonaPeticion.class,
								   ConsultarPersonaRespuesta.class,
								   PersonaOV.class,
								   DomicilioOV.class,
								   TelefonoOV.class,
								   DetalleSocioeconomicoOV.class,
								   DireccionElectronicaOV.class,
								   RelacionPersonaOV.class,
								   RelacionClaveFinsolOV.class,
								   EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ConsultarPersonaPeticion
			  consultarPersonaPeticion = (ConsultarPersonaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "verificarPersona - Datos de entrada : " + consultarPersonaPeticion);

		//Llamado a funcion principal
		final ConsultarPersonaRespuesta respuesta = administracionPersona.consultarPersona(uid, consultarPersonaPeticion );
		LogHandler.info(uid, getClass(), "verificarPersona - Datos de salida : " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		//LogHandler.info(uid, getClass(), "verificarPersona - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion :
	 * @return String
	 */
	public RegistrarPersonaRespuesta exponeClases(RegistrarPersonaPeticion peticion)
	{
		final RegistrarPersonaRespuesta respuesta = new RegistrarPersonaRespuesta(new String(""));
		return respuesta;
	}

	/**
	 * @param peticion del registro persona
	 * @return XML respuesta
	 */
	public String validarDatosPersona(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		//LogHandler.info(uid, getClass(), "validarPersona - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ValidarDatosPersonaPeticion.class,
									ValidarDatosPersonaRespuesta.class,
									PersonaOV.class,
									DomicilioOV.class,
									TelefonoOV.class,
									DetalleSocioeconomicoOV.class,
									DireccionElectronicaOV.class,
									RelacionPersonaOV.class,
									RelacionClaveFinsolOV.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ValidarDatosPersonaPeticion
			  validarPersonaPeticion = (ValidarDatosPersonaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "validarPersona - Datos de entrada : " + validarPersonaPeticion);

		//Llamado a funcion principal
		final ValidarDatosPersonaRespuesta respuesta =
				administracionPersona.validarDatosPersonaTarea(uid, validarPersonaPeticion );
		LogHandler.info(uid, getClass(), "validarPersona - Datos de salida : " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		//LogHandler.info(uid, getClass(), "validarPersona - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion del registro persona
	 * @return XML respuesta
	 */
	public String validarCurpPersona(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		//LogHandler.info(uid, getClass(), "validarCurpPersona - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ValidarCurpPersonaPeticion.class,
									ValidarCurpPersonaRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ValidarCurpPersonaPeticion
			validarCurpPersonaPeticion = (ValidarCurpPersonaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "validarCurpPersona - Datos de entrada : " + validarCurpPersonaPeticion);

		//Llamado a funcion principal
		final ValidarCurpPersonaRespuesta respuesta =
				administracionPersona.validarCurpPersonaTarea(uid, validarCurpPersonaPeticion);
		LogHandler.info(uid, getClass(), "validarCurpPersona - Datos de salida : " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		//LogHandler.info(uid, getClass(), "validarCurpPersona - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Metodo para registrar un permiso temporal para el login
	 * @param peticion del registro persona
	 * @return XML respuesta
	 */
	public String registrarPermisoTemporal(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		//LogHandler.info(uid, getClass(), "registrarPermisoTemporal - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {PerfilTemporal.class,
									PerfilTemporalRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final PerfilTemporal
			perfilTemporal = (PerfilTemporal) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "registrarPermisoTemporal - Datos de entrada : " + perfilTemporal);

		//Llamado a funcion principal
		final PerfilTemporalRespuesta respuesta =
				administracionPersona.registrarPermisoTemporalTarea(uid, perfilTemporal);
		LogHandler.info(uid, getClass(), "registrarPermisoTemporal - Datos de salida : " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		//LogHandler.info(uid, getClass(), "registrarPermisoTemporal - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Metodo para consultar un permiso temporal para el login
	 * @param peticion del registro persona
	 * @return XML respuesta
	 */
	public String consultarPermisoTemporal(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );

		//Parametros de entrada
		final Class<?>[] clases = {PerfilTemporal.class,
									PerfilTemporalRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final PerfilTemporal
			perfilTemporal = (PerfilTemporal) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultarPermisoTemporal - Datos de entrada : " + perfilTemporal);

		//Llamado a funcion principal
		final PerfilTemporalRespuesta respuesta =
				administracionPersona.consultarPermisoTemporalTarea(uid, perfilTemporal);
		LogHandler.info(uid, getClass(), "consultarPermisoTemporal - Datos de salida : " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		return respuestaXML;
	}


	/**
	 * Metodo para dar por concluido un permiso temporal para el login
	 * @param peticion del registro persona
	 * @return XML respuesta
	 */
	public String terminarPermisoTemporal(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		//LogHandler.info(uid, getClass(), "consultarPermisoTemporal - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {PerfilTemporal.class,
									PerfilTemporalRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final PerfilTemporal
			perfilTemporal = (PerfilTemporal) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultarPermisoTemporal - Datos de entrada : " + perfilTemporal);

		//Llamado a funcion principal
		final PerfilTemporalRespuesta respuesta =
				administracionPersona.terminarPermisoTemporalTarea(uid, perfilTemporal);
		LogHandler.info(uid, getClass(), "consultarPermisoTemporal - Datos de salida : " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		//LogHandler.info(uid, getClass(), "consultarPermisoTemporal - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Consultar la informacion de solicitante para varias personas.
	 *
	 * @param personas :
	 * @return consultarInformacionSolicitante
	 */
	public ConsultarPersonaRespuestaOV consultarInformacionSolicitante(ContratoRenovacionPeticion peticion) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		//LogHandler.info(uid, getClass(), "consultarPersona - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ConsultarPersonaPeticion.class,
								   ConsultarPersonaRespuesta.class,
								   PersonaOV.class,
								   DomicilioOV.class,
								   TelefonoOV.class,
								   DetalleSocioeconomicoOV.class,
								   DireccionElectronicaOV.class,
								   RelacionPersonaOV.class,
								   RelacionClaveFinsolOV.class,
								   EncabezadoRespuesta.class};

		//Llamado a funcion principal
		final ConsultarPersonaRespuestaOV respuesta = administracionPersona.consultarInformacionSolicitante(uid, peticion );
		LogHandler.info(uid, getClass(), "consultarPersona - Datos de salida : " + respuesta);

		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		respuesta.setXml(respuestaXML);
		return respuesta;
	}
	
	/**
	 * Registrar prospecto del aplicativo de caravanas.
	 * @param peticion :
	 * @param consultaBuro consulta de buro de credito
	 * @return String
	 */
	public RegistrarPersonaRespuesta registrarProspectoCaravana(String peticion, boolean consultaBuro) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "registrarProspectoCaravana - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {RegistrarPersonaPeticion.class,
								   RegistrarPersonaRespuesta.class,
								   PersonaOV.class,
								   DomicilioOV.class,
								   TelefonoOV.class,
								   DireccionElectronicaOV.class,
								   RelacionClaveFinsolOV.class,
								   EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final RegistrarPersonaPeticion
			  registrarPersonaPeticion = (RegistrarPersonaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "registrarProspectoCaravana - Datos de entrada : " + registrarPersonaPeticion);

		//Llamado a funcion principal
		final RegistrarPersonaRespuesta respuesta = administracionPersona.registrarProspectoCaravana(uid, registrarPersonaPeticion, consultaBuro );
		LogHandler.info(uid, getClass(), "registrarProspectoCaravana - Datos de salida : " + respuesta);

		return respuesta;
	}

}


