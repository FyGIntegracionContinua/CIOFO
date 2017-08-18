package tarea.administracion;

import java.util.List;

import utilitario.mensajes.originacion.consulta.ContratoRenovacionPeticion;
import utilitario.mensajes.persona.ActualizarPersonaRespuesta;
import utilitario.mensajes.persona.ConsultaDatosGeneralesPeticion;
import utilitario.mensajes.persona.ConsultaDatosGeneralesRespuesta;
import utilitario.mensajes.persona.ConsultarClienteUnicoPeticion;
import utilitario.mensajes.persona.ConsultarClienteUnicoRespuesta;
import utilitario.mensajes.persona.ConsultarPersonaPeticion;
import utilitario.mensajes.persona.ConsultarPersonaRespuesta;
import utilitario.mensajes.persona.ConsultarPersonaRespuestaOV;
import utilitario.mensajes.persona.PerfilTemporal;
import utilitario.mensajes.persona.PerfilTemporalRespuesta;
import utilitario.mensajes.persona.RegistrarPersonaPeticion;
import utilitario.mensajes.persona.RegistrarPersonaRespuesta;
import utilitario.mensajes.persona.ValidaExistePersonaPeticion;
import utilitario.mensajes.persona.ValidaExistePersonaRespuesta;
import utilitario.mensajes.persona.ValidarCurpPersonaPeticion;
import utilitario.mensajes.persona.ValidarCurpPersonaRespuesta;
import utilitario.mensajes.persona.ValidarDatosPersonaPeticion;
import utilitario.mensajes.persona.ValidarDatosPersonaRespuesta;

/**
 * The Interface AdministracionPersona.
 *
 * @author out_mreyes@independencia.com.mx
 * Interfaz que contiene las operaciones disponibles para la administraci�n de personas
 * dentro de credprod_finsol
 * @version 1.0
 */
public interface AdministracionPersona {

	/**
	 * M�todo para registra una persona tanto en credprod_finsol como en cliente_unico.
	 *
	 * @param uid el uid de la operacion
	 * @param peticion the peticion
	 * @return objeto para indicar el rtesultado de la operaci�n
	 */
	public RegistrarPersonaRespuesta registrarPersona(java.lang.String uid, RegistrarPersonaPeticion peticion);
	/**
	 * M�todo para modificar los datos de una persona registrada previamente.
	 * @param uid el uid de la operacion
	 * @param peticion contiene los datos a actualizar
	 * @return objeto para indicar el resultado de la operaci�n
	 */
	public ActualizarPersonaRespuesta actualizarPersona(java.lang.String uid, RegistrarPersonaPeticion peticion);

	/**
	 * M�todo para realizar la busqueda de las personas, de acuerdo a filtros como son nombres,
	 * fecha de nacimiento y rfc.
	 *
	 * @param uid el uid de la operacion
	 * @param peticion contiene los valores para filtrar la busqueda
	 * @return arreglo de personas que coinciden con los filtros indicados
	 */
	public ConsultarPersonaRespuesta consultarPersona(java.lang.String uid, ConsultarPersonaPeticion peticion);

	/**
	 * M�todo para realizar la busqueda de personas, en la base de cliente �nico en base a nombre,
	 * fecha de nacimiento y rfc.
	 *
	 * @param uid identificador de la operacion
	 * @param peticion contiene los par�metros para realizar la busqueda
	 * @return una lista con las personas que tienen datos coincidentes a los filtros
	 */
	public ConsultarClienteUnicoRespuesta consultarClienteUnico(java.lang.String uid, ConsultarClienteUnicoPeticion peticion);


	/**
	 * M�todo para realizar la busqueda por numero de persona.
	 * @param uid el uid de la operacion
	 * @param peticion contiene los valores para filtrar la busqueda
	 * @return arreglo de personas que coinciden con los filtros indicados
	 */
	public ConsultarPersonaRespuesta consultarDatosPersona(java.lang.String uid, ConsultarPersonaPeticion peticion);

	/**
	 * M�todo para registra un prospecto tanto en credprod_finsol como en cliente_unico.
	 *
	 * @param uid el uid de la operacion
	 * @param peticion the peticion
	 * @return objeto para indicar el rtesultado de la operaci�n
	 */
	public RegistrarPersonaRespuesta registrarProspecto(java.lang.String uid, RegistrarPersonaPeticion peticion);

	/**
	 * M�todo para consultar una persona en credprod_finsol por numero de persoa, clave finsol o t24 y clave de cliente unico.
	 *
	 * @param uid el uid de la operacion
	 * @param peticion the peticion
	 * @return objeto para indicar el rtesultado de la operaci�n
	 */
	public ConsultaDatosGeneralesRespuesta consultaDatosGeneralesPersona(String uid, ConsultaDatosGeneralesPeticion peticion);


	/**
	 * Validar datos persona tarea.
	 *
	 * @param uid the uid
	 * @param peticion the validar persona peticion
	 * @return the validar datos persona respuesta
	 */
	public ValidarDatosPersonaRespuesta validarDatosPersonaTarea(String uid,
			ValidarDatosPersonaPeticion peticion);

	/**
	 * Validar curp persona tarea.
	 *
	 * @param uid the uid
	 * @param peticion the validar curp persona peticion
	 * @return the validar curp persona respuesta
	 */
	public ValidarCurpPersonaRespuesta validarCurpPersonaTarea(String uid,
			ValidarCurpPersonaPeticion peticion);

	/**
	 * Metodo para registrar un permiso temporal para el login
	 * @param uid identificador unico de la transaccion
	 * @param peticion del registro persona
	 * @return XML respuesta
	 */
	public PerfilTemporalRespuesta registrarPermisoTemporalTarea(String uid, PerfilTemporal peticion);

	/**
	 * Metodo para consultar un permiso temporal para el login
	 * @param uid identificador unico de la transaccion
	 * @param peticion del registro persona
	 * @return XML respuesta
	 */
	public PerfilTemporalRespuesta consultarPermisoTemporalTarea(String uid, PerfilTemporal peticion);

	/**
	 * Metodo para dar por concluido un permiso temporal para el login
	 * @param uid identificador unico de la transaccion
	 * @param peticion del registro persona
	 * @return XML respuesta
	 */
	public PerfilTemporalRespuesta terminarPermisoTemporalTarea(String uid, PerfilTemporal peticion);

	/**
	 * Metodo para validar existe persona en la base de datos en base a su nombre y fecha de nacimiento
	 * @param uid identificador unico de la transaccion
	 * @param peticion con los datos de la persona
	 * @return respuesta
	 */
	public ValidaExistePersonaRespuesta validaExistePersona(String uid, ValidaExistePersonaPeticion peticion);

	/**
	 * Consultar la informacion de solicitante para varias personas.
	 *
	 * @param uid :
	 * @param personas :
	 * @return consultarInformacionSolicitante
	 */
	public ConsultarPersonaRespuestaOV consultarInformacionSolicitante(java.lang.String uid,
			ContratoRenovacionPeticion peticion);
	
	/**
	 * Registrar prospecto del aplicativo de caravanas.
	 *
	 * @param uid :
	 * @param peticion :
	 * @param consultaBuro consulta de buro de credito.
	 * @return RegistrarPersonaRespuesta
	 */
	public RegistrarPersonaRespuesta registrarProspectoCaravana(String uid, RegistrarPersonaPeticion peticion, boolean consultaBuro);

}
