/**
 * Tensegrity - 2011
 */
package tarea.originacion;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import utilitario.mensajes.comun.ResultadoOV;
import utilitario.mensajes.originacion.grupo.GrupoOV;



/**
 * @author Juan Moreno
 * Encapsula las operaciones de el componente Entity grupo
 * <ul>
 *  <li>Valida si esxiste un grupo.</li>
 *  <li>Registra un grupo.</li>
 *  <li>Actualiza un grupo.</li>
 * </ul>
 */
public interface OriginacionGrupo {
	
	//Nombre de las consultas mapeadas
	static final String  OPER_CONTAR_PERSONA	= "contarPersona";
	static final String  OPER_REGISTRAR_GRUPO	= "registrarGrupo";
	static final String  OPER_ACTUALIZAR_GRUPO	= "actualizarGrupo";
	static final String	 OPER_BUSCAR_GRUPO		= "buscarGrupo";
	
	static final String	 PERSONA				= "persona";
	static final String	 NOMBRE					= "nombre";
	static final String	 CALLE					= "calle";
	static final String	 COLONIA				= "colonia";
	static final String	 CP						= "cp";
	static final String	 ENTIDAD				= "entidad";
	static final String	 CIUDAD					= "ciudad";
	static final String	 FECHA_ALTA				= "fecha_alta";
	static final String	 MUNICIPIO				= "municipio";
	static final String	 FECHA_ULT_MOD			= "fecha_ult_mod";
	
	static final String	 MENSAJE_OK				= "GRUPO ";
	static final String	 MENSAJE_ERROR			= "GRUPO NO ";
	static final String	 MENSAJE_TIMEOUT		= "FSERROR_TIMEOUT, GRUPO NO ";
	
	/**
	 * Genera un nuevo numero de persona que se empleara con Personalidad G
	 * @return Numero de persona
	 */
	public HashMap<String, String> obtenerIdentificador(String uid );
	
	/**
	 * Valida si esxiste un grupo.
	 * @param grupo Numero del grupo
	 * @return true cuando el grupo ya esta reguistrado, false en caso contrario
	 */
	public boolean existe( String uid, String grupo );
	/**
	 * Registra un grupo.
	 * Registra los datos del grupo (tablas persona y grupo)
	 * @param grupo Datos a guardar.
	 * @return Resultado de la operacion
	 */
	public ResultadoOV registrar(String uid,  GrupoOV grupo );
	/**
	 * Actualiza un grupo.
	 * actualiza los datos del grupo (tablas persona y grupo)
	 * @param grupo Datos del grupo
	 * @return Resultado de la operacion
	 */
	public ResultadoOV actualizar( String uid, GrupoOV grupo );
	
	/**
	 * Actualiza un grupo.
	 * actualiza los datos del grupo (tablas persona y grupo)
	 * @param sesion sesion con la que se accesa a la base de datos
	 * @param grupo Datos del grupo
	 * @return Resultado de la operacion
	 */
	ResultadoOV actualizarTx( String uid, SqlSession sesion, GrupoOV grupo );

	/**
	 * Busca un grupo a partir del nombre del mismo
	 * @param uid
	 * @param grupoOV
	 * @return
	 */
	public ResultadoOV existeGrupo( java.lang.String uid, utilitario.mensajes.originacion.grupo.GrupoOV grupoOV );
	
	/**
	 * Funcion par5a obtener la equivalencia t24-credprod
	 * @param uid
	 * @param t24
	 * @return
	 */
	public String obtenerClaveCredprod(java.lang.String uid, java.lang.String t24);
	}
