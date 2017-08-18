package entidad.originacion.secuencias;


import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import utilitario.log.LogHandler;

import entidad.conexiones.FabricaConexiones;

/**
 * @author Juan Moreno
 * Encapsula las funciones de acceso a bd a traves de MyBatis
 * <ul>
 *  <li>Obtener conexion</li>
 * </ul>
 */
public final class GeneraSecuencias {

	/**
	 * Constructor
	 */
	private GeneraSecuencias() {
	}

	/**
	 * mensaje OBTEN_VALOR_ACTUAL_SEC
	 */
	private static final String OBTEN_VALOR_ACTUAL_SEC			= "obtenerValorActualSequencias";
	/**
	 * mensaje ACTUALIZA_SIGUIENTE_VALOR_SEC
	 */
	private static final String ACTUALIZA_SIGUIENTE_VALOR_SEC	= "updateSequenciasSigValor";
	/**
	 * mapa secuencias
	 */
	@SuppressWarnings("unchecked")
	private static Map<Integer, Long>[] secuencias 				= (Map<Integer, Long>[]) new HashMap<?, ?>[3];
	static {
		secuencias[0] = new HashMap<Integer, Long>();
		secuencias[1] = new HashMap<Integer, Long>();
		secuencias[2] = new HashMap<Integer, Long>();
	}
	/**
	 * cadena ACTUAL
	 */
	private static final String ACTUAL 		= "actual";
	/**
	 * cadena INCREMENTO
	 */
	private static final String INCREMENTO 	= "incremento";

	/**
	 * array indice
	 */
	private static Integer [ ]indice 		= new Integer[3];
	/**
	 * array tiposDesc
	 */
	private static String [ ]tiposDesc		= {"PER", "CRE", "T24"};
	/**
	 * Variable persona
	 */
	private static int persona 				= 0;
 	/**
 	 * Variable credito
 	 */
 	private static int credito 				= 1;
 	/**
 	 * Variable T24
 	 */
 	private static int t24					= 2;

 	/**
	 * Obtiene la secuecnia de las personas
	 * @param uid tipo String
	 * @return Sesion.
	 * @throws IOException
	 */
	public static synchronized Long getSigSecuenciaPersonas( String uid ) {
		return getSecuencia( uid, persona );
	}

	/**
	 * Obtiene la secuencia de las solicitudes
	 * @param uid tipo String
	 * @return Sesion.
	 * @throws IOException
	 */
	public static synchronized Long getSigSecuenciaCreditos(String uid) {
		return getSecuencia( uid, credito );
	}

	/**
	 * Obtiene la secuencia equivalente a credprod para T24
	 * @param uid ;
	 * @return getSecuencia
	 */
	public static synchronized Long getSigSecuenciaT24(String uid) {
		return getSecuencia( uid, t24);
		}

	/**
	 * @param uid tipo String
	 * @param tipo Integer
	 * @return secuencia
	 */
	private static Long getSecuencia(String uid,  int tipo ) {
		SqlSession 	sesionTx	= null;
		Long secuencia 			= null;
		if ( secuencias[tipo].size() == 0 ) {
			indice[tipo] = 1;
			try {
				//Recuperamos las secuencias
				sesionTx			= FabricaConexiones.obtenerSesionTx( );
				LogHandler.trace(uid, GeneraSecuencias.class, "==> getSecuencia - " + OBTEN_VALOR_ACTUAL_SEC );
				Map<?, ?> data 	= (Map<?, ?>) sesionTx.selectOne( OBTEN_VALOR_ACTUAL_SEC, tiposDesc[tipo] );
				String actual 		= (data.get(ACTUAL)).toString();
		 		String incremento 	= (data.get(INCREMENTO)).toString();
		 		long actuall 		= Long.valueOf(actual);
				for ( int i = 0; i < Integer.valueOf(incremento);) {
					secuencias[tipo].put( ++i, ++actuall );
				}
				LogHandler.trace(uid, GeneraSecuencias.class,
						"==> getSecuencia - " + ACTUALIZA_SIGUIENTE_VALOR_SEC );
				sesionTx.update( ACTUALIZA_SIGUIENTE_VALOR_SEC, tiposDesc[tipo]);
				sesionTx.commit( );
			} catch (Exception e ) {
				//e.printStackTrace();
				FabricaConexiones.rollBack( sesionTx );
				secuencia = 0L;
				LogHandler.error(uid, GeneraSecuencias.class, "Existio un  error al obtener la secuencia", e);
			} finally {
				FabricaConexiones.close( sesionTx );
			}
		}
		if ( secuencia == null ) {
			secuencia = secuencias[tipo].get( indice[tipo] );
		} else {
			secuencia = null;
		}
		//secuencia =  secuencia == null ? secuencias[tipo].get( indice[tipo] ) : null;
		secuencias[tipo].remove( indice[tipo]++ );
		return secuencia;
 	}

}
