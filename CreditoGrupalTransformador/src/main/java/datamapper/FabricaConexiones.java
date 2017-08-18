package datamapper;

import java.io.Reader;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import utilitario.log.LogHandler;

/**
 * @author Juan Moreno
 * Encapsula las funciones de acceso a bd a traves de MyBatis
 * <ul>
 *  <li>Obtener conexion</li>
 * </ul>
 */
public class FabricaConexiones {

	/**
	 * FACTORY_NTX SqlSessionFactory
	 */
	private static SqlSessionFactory FACTORY_NTX;
 	static {
  		//NTx
 		_obtenerSesionNTx();
	}

 	/**
 	 *  void
 	 */
 	private static void _obtenerSesionNTx() {
 		Reader 						readerNTx;
		SqlSessionFactoryBuilder 	builderNTx;
		SqlSessionFactory 			sqlMapperNTx = null;
		try {
			readerNTx 		= Resources.getResourceAsReader( "datamapper/ConfigNTx.xml" );
			builderNTx 		= new SqlSessionFactoryBuilder( );
			sqlMapperNTx 	= builderNTx.build( readerNTx );
		} catch ( Exception e ) {
			LogHandler.error(null, FabricaConexiones.class, "Existio un error en la fabrica de conexiones de Transformador", e);
		}
		FACTORY_NTX = sqlMapperNTx;
 		}

	/**
	 * Obtiene una sesion a la base de datos.
	 * @return Sesion.
	 * @throws IOException
	 */
	public static SqlSession obtenerSesionNTx( ) throws SQLException {
		SqlSession regreso = null;
			if ( FACTORY_NTX == null ) {
				_obtenerSesionNTx();
			}
			if ( FACTORY_NTX != null ) {
				regreso = FACTORY_NTX.openSession( true );  // auto-commit = true
			}
			if ( regreso == null ) {
				throw new SQLException( "Sin conexion a la base de datos" );
			}
		return regreso;
	}

	/**
	 * Cierra una sesion a la base de datos.
	 * @param  conn Sesion.
	 * @throws IOException
	 */
	public static void close( SqlSession conn ) {
		if ( conn != null ) {
			conn.close( );
		}
	}
	/**
	 * Regresa los cambios de la base de datos.
	 * @param conn Sesion.
	 * @throws IOException
	 */
	public static void rollBack( SqlSession conn ) {
		if ( conn != null ) {
			conn.rollback( );
		}
	}

}
