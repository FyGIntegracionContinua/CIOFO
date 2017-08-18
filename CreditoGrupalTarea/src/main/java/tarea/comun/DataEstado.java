package tarea.comun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import utilitario.log.LogHandler;
import entidad.conexiones.FabricaConexiones;

/**
 * @author Juan Carlos Moreno
 */
public final class DataEstado
	{

	/**  Mapa para los entidades	 */
	private static Map<String, String> mapEntidades	= new LinkedHashMap<String, String>();

	static {
		//Estados
 		recuperaEstados();
 	}
	/**  Constructor	 */
	private DataEstado() { }
 	/**
 	 * Metodo para recuperar los estados y cargarlos en un mapa
 	 */
 	private static void recuperaEstados() {
 		//Obtenemos una lista con todas las entidades del pais
		SqlSession 	sesionNTx = null;
		try	{
			//Recuperamos las entidades
		  	sesionNTx	 = FabricaConexiones.obtenerSesionNTx();
		  	LogHandler.trace("MAPPER", DataEstado.class, "==> static - obtenerClavesEntidades" );
			@SuppressWarnings("unchecked")
			final ArrayList<HashMap<String,  String>>	lstEntidades
				= (ArrayList<HashMap<String, String>>) sesionNTx.selectList( "obtenerClavesEstados" );

			//Se recupera una lista, con valores de codigos y nombres, se deben iterar y crear un mapa para su manipulacion
			for (java.util.HashMap<String, String> entidades : lstEntidades )
				{
				mapEntidades.put( (String) entidades.get( "codigo_financiera" ), (String) entidades.get( "estado" ) );
				}
 			}
		catch ( java.lang.Exception exception ) {
 			LogHandler.error(null, DataEstado.class, "Error al momento de cargar las entidades", exception );
 			}
 		finally
			{
			FabricaConexiones.close( sesionNTx);
			}
 		}

	/**
	 * @param entidadT24 clave de la entidad en T24
	 * @return estado
	 */
	public static String mapClaveEntidad( String entidadT24 ) {
		String claveEntidad 	= null;
		try {
			//Si no hay datos cargados se cargan
			if ( mapEntidades.size() == 0 ) {
				recuperaEstados();
			}

			Iterator<String> keys	= mapEntidades.keySet( ).iterator( );
			while ( keys.hasNext( ) ) {
				claveEntidad = keys.next();
				String entidad = mapEntidades.get( claveEntidad );
				if ( entidadT24.endsWith( "SUR" ) &&  entidad.equalsIgnoreCase( entidadT24 ) ) {
					break;
				}
				else {
					if ( entidad.startsWith( entidadT24 ) ) {
						break;
					}
				}
			}
		} catch ( Exception e) {
			LogHandler.error(null, DataEstado.class, "Error en el metodo mapClaveEntidad", e);
			claveEntidad = null;
		}
		return claveEntidad;
	}

	/**
	 * @param codigoEntidad codigo del estado.
	 * @return si el codigo de estado existe.
	 */
	public static boolean validaClaveEntidad( String codigoEntidad ) {
		boolean existe = false;
		String claveEntidad 	= null;
		try {
			//Si no hay datos cargados se cargan
			if ( mapEntidades.size() == 0 ) {
				recuperaEstados();
			}

			Iterator<String> keys	= mapEntidades.keySet( ).iterator( );
			while ( keys.hasNext( ) ) {
				claveEntidad = keys.next().trim();
				if (claveEntidad.equals(codigoEntidad) ) {
					existe = true;
					break;
				}
			}
		} catch (Exception e) {
			LogHandler.error(null, DataEstado.class, "Error en el metodo mapClaveEntidad", e);
			claveEntidad = null;
		}
		return existe;
	}


	/**
	 * @return el numero de estados cargados.
	 */
	public static Integer getNumeroEntidades() {
		return mapEntidades == null ? null : mapEntidades.size();
	}
 }
