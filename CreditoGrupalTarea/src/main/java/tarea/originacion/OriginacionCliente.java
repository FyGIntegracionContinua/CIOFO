/**
 * Tensegrity - 2011
 */
package tarea.originacion;

import utilitario.mensajes.comun.ResultadoOV;
import utilitario.mensajes.originacion.cliente.ClientePeticion;


 

/**
 * @author Juan Moreno
 * Encapsula las operaciones sobre una entidad persona.
 * <ul>
 *  <li>Validar que exista una persona</li>
 *  <li>Registrar una persona grupal.</li>
 *  <li>Actualizar una persona grupal.</li>
 *  <li></li>
 *  <li></li>
 * </ul>
 */
public interface OriginacionCliente {

	 //Definicion de llamadas a operacion de la capa de entidad ibatis
	 static final String OPER_CONTAR_PERSONA 		= "contarPersona";
	 static final String OPER_REGISTRAR_PERSONA 	= "registrarPersona";
	 static final String OPER_REGISTRAR_TELEFONO 	= "registrarTelefono";
	 static final String OPER_ACTUALIZAR_PERSONA 	= "actualizarPersona";
	
	 //Definicion de los nombres de campos que reciben las operaciones definidas en ibatis
	 static final String	PERSONA						= "persona";
	 static final String	NOMBRE						= "nombre";
	 static final String	APELLIDO_PAT				= "apellido_pat";
	 static final String	APELLIDO_MAT				= "apellido_mat";
	 static final String	RFC							= "rfc";
	 static final String	FECHA_NACIMIENTO			= "fecha_nacimiento";
	 static final String	SEXO						= "sexo";
	 static final String	EDO_CIVIL					= "edo_civil";
	 static final String	CALLE						= "calle";
	 static final String	COLONIA						= "colonia";
	 static final String	CP							= "cp";
	 static final String	ENTIDAD						= "entidad";
	 static final String	CIUDAD						= "ciudad"; 
	 static final String	FECHA_ALTA					= "fecha_alta";
	 static final String	MUNICIPIO					= "municipio";
	 static final String	FECHA_ULT_MOD				= "fecha_ult_mod";
	 static final String	CORREO						= "correo";
	 static final String	NUMERO_IDENTIFICACION		= "numero_identificacion";
	 static final String	ANALISTA					= "analista";
	 static final String	TELEFONO					= "telefono";
	 static final String	LADA						= "lada";
	 static final String	TELEFONO_DIRE				= "DIRE";
	 static final String	TELEFONO_CELU				= "CELU";
	 static final String	TELEFONO_EMPL				= "EMPL";
	 static final String	TIPO						= "tipo";
	 static final String	MENSAJE_OK					= "CLIENTE ";
	 static final String	MENSAJE_ERROR				= "CLIENTE NO ";
	 static final String	MENSAJE_TIMEOUT				= "FSERROR_TIMEOUT, CLIENTE NO ";
	 static final String 	ACTIVIDAD_ECONOMICA			= "actividad_economica";
	 static final String	CLIENTET24					= "CLIENTET24";

	
	
	/**
	 * Genera un nuevo numero de persona
	 * @return Numero de persona
	 */
	 java.util.HashMap<String, String> obtenerIdentificador( String uid, String t24, String credprod );
	
	/**
	 * Valida si esxiste una persona.
	 * @param persona Numero de persona
	 * @return true cuando la persona ya esta reguistrada, false en caso contrario
	 */
	boolean existe(String uid,  String persona );
	
	/**
	 * Registra una persona.
	 * Registra telefono, referencias, persona e informacion complementaria (miembro_grupo)
	 * @param cliente Datos a guardar.
	 * @return Resultado de la operacion
	 */
	public ResultadoOV registrar( String uid, ClientePeticion cliente );
	
	/**
	 * Actualiza una persona.
	 * actualiza los registros de telefono, referencias, persona e informacion complementaria (miembro_grupo)
	 * @param cliente Datos del cliente.
	 * @return Resultado de la operacion
	 */
	public ResultadoOV actualizar( String uid, ClientePeticion cliente );
	
	
	/**
	 * Para obtener la relacion credprod - t24
	 * @param uid
	 * @param t24
	 * @return
	 */
	public java.lang.String obtenerClaveCredprod( java.lang.String uid, java.lang.String t24 );
}
