/**
 *
 */
package entidad.asesores.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import utilitario.comun.asesores.AsesorOV;
import utilitario.log.LogHandler;
import entidad.conexiones.FabricaConexiones;

/**
 * @author out_jcmoreno
 *
 */
public final class AsesorData {
	/**
	 * mapa de datos mapAsesores
	 */
	private static Map<String, AsesorOV> mapAsesores 		= new HashMap<String, AsesorOV>();
	/**
	 * mapa de datos mapAsesoresPersonas
	 */
	private static Map<String, AsesorOV> mapAsesoresPersonas = new HashMap<String, AsesorOV>();

	//Seccion estatica para inicializar la clase
	static
		{
		cargarAsesores();
		}

 	//Constructor  ----------------------------------------------------------------------------------------
	/**
	 * Constructor de la clase AsesorData
	 */
	private AsesorData() {
		super();
		}

	/**
	 * @param uid tipo String
	 * @param numAsesor tipo String
	 * @return asesor
	 */
	public static AsesorOV obtenAsesor( String uid, String  numAsesor  ) {
		AsesorOV asesor = null;
		try {
			if ( mapAsesores == null || mapAsesores.size() == 0) {
				cargarAsesores();
				}

			//Compara por el numero de daot24
			if ( numAsesor  != null ) {
				asesor =  mapAsesores.get(numAsesor);	}

			//Si falla compara por el numero de persona
			if ( asesor == null ) {
				asesor =  mapAsesoresPersonas.get(numAsesor);	}

		//Si esto falla, quiere decir que es un asesor no encontrado
		if ( asesor == null || asesor.getNombreCompleto() == null || asesor.getNombreCompleto().trim().equals( "" ) )
				{
				if ( asesor == null ) {
					asesor = new AsesorOV();
					}
				asesor.setNombre( "ASESOR NO ENCONTRADO" );
				asesor.setPersona("");
				}
		} catch ( java.lang.Exception exception ) {
			LogHandler.error(uid, AsesorData.class, "Error en el data Service de Asesror", exception );
			}
		return asesor;
		}

	/**
	 * Metodo para recuperar la clave de persona del Asesor
	 * @param uid tipo string
	 * @param numeroAsesor tipo string
	 * @return claveAsesor
	 */
	public static String obtenerClavePersona( String uid, String numeroAsesor ) {
		//Session para acceso a la BD
		SqlSession 	sesionNTx = null;

		//Variable para almacenar el resultado
		final java.lang.StringBuffer
					claveAsesor = new StringBuffer( "" );
		try	{
			//se abre la session
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			LogHandler.trace(uid, AsesorData.class, "==> obtenerClavePersona - obtenerClavePersonaAsesor");
			claveAsesor.append(
					sesionNTx.selectList( "obtenerClavePersonaAsesor" , numeroAsesor ).get( 0 ).toString() );
			}
		catch ( java.lang.Exception exception ) {
			claveAsesor.append( numeroAsesor );
			LogHandler.error(null, AsesorData.class, "Error al recuperar la clave del Asesor", exception );
			}

		return claveAsesor.toString();
		}

	/**
	 * Metodo para conocer el numero de asesores cargados
	 * @return mapAsesores
	 */
	public static java.lang.Integer getNumeroAsesores() {
		if ( mapAsesores == null  ) {
			return null;
		} else {
			return mapAsesores.size();
		}
		//return mapAsesores == null ? null : mapAsesores.size();
	}

	// Metodos privados  ------------------------------------------------------------------------------
	/**
	 * metodo privado para carga de asesores
	 */
	private static void cargarAsesores() {
		//Obtenemos una lista con todos los asesores
		SqlSession 	sesionBatch = null;
		try {
			//Recuperamos las entidades
			sesionBatch	 = FabricaConexiones.obtenerSesionBatch();
		  	LogHandler.trace(null, AsesorData.class, "static - obtenerListaAsesores" );
		  	@SuppressWarnings("unchecked")
			final java.util.List<AsesorOV> lstAsesores =
								(List<AsesorOV>) sesionBatch.selectList( "obtenerListaAsesores" );
			for ( AsesorOV asesor : lstAsesores ) {
				if ( asesor != null  ) {
					mapAsesores.put( asesor.getDaot24() , asesor );
					mapAsesoresPersonas.put( asesor.getPersona() , asesor );
					}
				}
 			LogHandler.info(null, AsesorData.class,
 					"Se cargaron: " + mapAsesores.size() + " Asesores al Data Service" );
 			}
		catch ( java.lang.Exception exception ) {
 			LogHandler.error(null, AsesorData.class, "Error en el data Service de Asesror", exception );
			}
		finally	{
			FabricaConexiones.close( sesionBatch );
			}
		}
	}
