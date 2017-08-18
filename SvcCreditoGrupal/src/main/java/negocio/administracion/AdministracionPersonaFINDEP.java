/**
 *
 */
package negocio.administracion;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import utilitario.mensajes.originacion.consulta.ContratoRenovacionPeticion;
import utilitario.mensajes.persona.ConsultarPersonaRespuestaOV;
import utilitario.mensajes.persona.RegistrarPersonaPeticion;
import utilitario.mensajes.persona.RegistrarPersonaRespuesta;

/**
 * @version 1.0.0
 * @author out_mreyes
 * Interfaz que contiene las operaciones disponibles para la administracion de personas
 * dentro de credprod_finsol
 */

@WebService(name = "AdministracionPersona", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionPersona/V1.0")
public interface AdministracionPersonaFINDEP {
	/**
	 * Metodo para registra una persona tanto en credprod_finsol como en cliente_unico
	 * @param  peticion contiene los datos necesarios para realizar la operacion
	 * @return cadena xml con el resultado de la operacion
	 */
	public java.lang.String registrarPersona(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionPersona/V1.0/registrarPersona")
			java.lang.String peticion);
	/**
	 * Metodo para modificar los datos de una persona registrada previamente.
	 * @param peticion contiene los datos a actualizar
	 * @return cadena xml con el resultado de la operacion
	 */
	public java.lang.String actualizarPersona(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionPersona/V1.0/actualizarPersona")
			java.lang.String peticion);

	/**
	 * Metodo para modificar los datos de una persona registrada previamente.
	 * @param peticion contiene los datos a actualizar
	 * @return cadena xml con el resultado de la operacion
	 */
	public java.lang.String consultarPersona(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionPersona/V1.0/consultarPersona")
			java.lang.String peticion);

	/**
	 * Metodo para registra un prospecto tanto en credprod_finsol como en cliente_unico
	 * @param  peticion contiene los datos necesarios para realizar la operacion
	 * @return cadena xml con el resultado de la operacion
	 */
	public java.lang.String registrarProspecto(
			@WebParam(name = "peticion",
					targetNamespace = "http://fisa.com.mx/CIOF/AdministracionPersona/V1.0/registrarProspecto")
			java.lang.String peticion);

	/**
	 * Metodo para consultar una persona en credprod_finsol por numero de persoa, clave finsol o t24 y clave de cliente unico.
	 * @param  peticion contiene los datos necesarios para realizar la operacion
	 * @return cadena xml con el resultado de la operacion
	 */
	public String consultaDatosGeneralesPersona(
			@WebParam(name = "peticion",
					targetNamespace = "http://fisa.com.mx/CIOF/AdministracionPersona/V1.0/consultaDatosGeneralesPersona")
	java.lang.String peticion);

	/**
	 * Metodo para verificar la existencia de una persona por nombre, apellidos y fecha nacimiento
	 * @param  peticion contiene los datos necesarios para realizar la operacion
	 * @return cadena xml con el resultado de la operacion
	 */
	public String verificarPersona(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionPersona/V1.0/verificarPersona")
	java.lang.String peticion);




	/**
	 * Metodo para exponer las clases
	 * @param  peticion contiene los datos necesarios para realizar la operacion
	 * @return cadena xml con el resultado de la operacion
	 */
	public RegistrarPersonaRespuesta exponeClases(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionPersona/V1.0/exponeClases")
			RegistrarPersonaPeticion peticion
			);

	/**
	 * @param peticion String
	 * @return respuesta tipo String
	 */
	public String validarDatosPersona(String peticion);

	/**
	 * @param peticion String
	 * @return respuesta tipo String
	 */
	public String validarCurpPersona(String peticion);

	/**
	 * Metodo para registrar un permiso temporal para el login
	 * @param peticion del registro persona
	 * @return XML respuesta
	 */
	public String registrarPermisoTemporal(String peticion);

	/**
	 * Metodo para consultar un permiso temporal para el login
	 * @param peticion del registro persona
	 * @return XML respuesta
	 */
	public String consultarPermisoTemporal(String peticion);

	/**
	 * Metodo para dar por concluido un permiso temporal para el login
	 * @param peticion del registro persona
	 * @return XML respuesta
	 */
	public String terminarPermisoTemporal(String peticion);

	/**
	 * Consultar la informacion de solicitante para varias personas.
	 *
	 * @param personas :
	 * @return consultarInformacionSolicitante
	 */
	public ConsultarPersonaRespuestaOV consultarInformacionSolicitante(ContratoRenovacionPeticion peticion);
	
	/**
	 * Registrar prospecto del aplicativo de caravanas.
	 * @param peticion :
	 * @param consultaBuro atributo de si se consulta o no el buro de credito.
	 * @return String
	 */
	public RegistrarPersonaRespuesta registrarProspectoCaravana(String peticion, boolean consultaBuro);
}
