package entidad.conexiones;


import java.io.Reader;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import utilitario.log.LogHandler;

/**
 * @author Juan Moreno
 * Encapsula las funciones de acceso a bd a traves de iBatis
 * <ul>
 *  <li>Obtener conexion</li>
 * </ul>
 */
public final class FabricaConexiones {

	/**
	 * Constructor de la clase FabricaConexiones
	 */
	private FabricaConexiones() {
		//;//Evita que se generen objetos de esta clase
		}

	/**
	 * sesion SqlSessionFactory
	 */
	private static SqlSessionFactory fACTORY_TX;
	/**
	 * sesion FACTORY_NTX
	 */
	private static SqlSessionFactory fACTORY_NTX;
	/**
	 * sesion FACTORY_BATCH
	 */
	private static SqlSessionFactory fACTORY_BATCH;
	/**
	 * sesion FACTORY_ORCL_NTX
	 */
	private static SqlSessionFactory fACTORY_ORCL_NTX;
	/**
	 * sesion FACTORY_ORCL_TX
	 */
	private static SqlSessionFactory fACTORY_ORCL_TX;
	/**
	 * sesion FACTORY_ORCL_CU_TX
	 */
	private static SqlSessionFactory fACTORY_ORCL_CU_TX;
	/**
	 * sesion FACTORY_ORCL_CU_NTX
	 */
	private static SqlSessionFactory fACTORY_ORCL_CU_NTX;
	/**
	 * sesion FACTORY_SQL_BATCH
	 */
	private static SqlSessionFactory fACTORY_SQL_BATCH;
	/**
	 * sesion FACTORY_SYBASE_IQ para conexion con IQ
	 */
	private static SqlSessionFactory fACTORY_SYBASE_IQ;
	/**
	 * sesion fACTORY_POSTGRES para conexion con Postgres
	 */
	private static SqlSessionFactory fACTORY_POSTGRES;

	static {
		//Tx
		iobtenerSesionTx();

		//NTx
		iobtenerSesionNTx();

		//Batch
		iobtenerSesionBatch();

		//ORCL CU Tx
		iobtenerSesionOrclCUTx();

		//ORCL CU NTx
		iobtenerSesionOrclCUNTx();

		//ORCL NTx
		iobtenerSesionOrclNTx();

		//ORCL NTx
		iobtenerSesionOrclTx();

		//Sql Server
		iobtenerSesionSqlBatch();

		//Sybase IQ
		iobtenerSesionSybaseIQ();

		//Postgres
		iobtenerSesionPostgres();
	}

	/**
	 * Obtiene una sesion a la base de datos.
	 * @throws IOException
	 */
	private static void iobtenerSesionTx() {
		Reader 						readerTx;
		SqlSessionFactoryBuilder 	builderTx;
		SqlSessionFactory 			sqlMapperTx = null;
		try {
			readerTx 		= Resources.getResourceAsReader( "entidad/ConfigTx.xml" );
			builderTx 		= new SqlSessionFactoryBuilder( );
			sqlMapperTx 	= builderTx.build( readerTx );
		} catch ( Exception e ) {
			LogHandler.error(null, FabricaConexiones.class, "Error : " + e.getMessage(), e );
			LogHandler.error(null, FabricaConexiones.class, "Error : " + e.getCause(), e );
			LogHandler.error(null, FabricaConexiones.class, "Error : " + e.getClass().getName(), e );
			LogHandler.error(null, FabricaConexiones.class, "Existio un erorr en la Fabrica de Conexiones Tx", e);
 		}
		fACTORY_TX = sqlMapperTx;
		}

	/**
	 * Obtiene una sesion a la base de datos.
	 * @throws IOException
	 */
	private static void iobtenerSesionNTx()	{
		Reader 						readerNTx;
		SqlSessionFactoryBuilder 	builderNTx;
		SqlSessionFactory 			sqlMapperNTx = null;
		try {
			readerNTx 		= Resources.getResourceAsReader( "entidad/ConfigNTx.xml" );
			builderNTx 		= new SqlSessionFactoryBuilder( );
			sqlMapperNTx 	= builderNTx.build( readerNTx );
		} catch ( Exception e ) {
			LogHandler.error(null, FabricaConexiones.class, "Exsitio un erorr en la Fabrica de Conexiones NTx", e);
 		}
		fACTORY_NTX = sqlMapperNTx;
		}

	/**
	 * Obtiene una sesion a la base de datos.
	 * @throws IOException
	 */
	private static void iobtenerSesionBatch() {
		Reader 						readerBatch;
		SqlSessionFactoryBuilder 	builderBatch;
		SqlSessionFactory 			sqlMapperBatch = null;
		try {
			readerBatch 	= Resources.getResourceAsReader( "entidad/ConfigBatch.xml" );
			builderBatch 	= new SqlSessionFactoryBuilder( );
			sqlMapperBatch 	= builderBatch.build( readerBatch );
		} catch ( Exception e ) {
			LogHandler.error(null, FabricaConexiones.class, "Existio un erorr en la Fabrica de Conexiones Batch", e);
 		}
		fACTORY_BATCH = sqlMapperBatch;
		}

	/**
	 * Obtiene una sesion a la base de datos.
	 * @throws IOException
	 */
	private static void iobtenerSesionOrclNTx()	{
		Reader 						readerOrclNTx;
		SqlSessionFactoryBuilder 	builderOrclNTx;
		SqlSessionFactory 			sqlMapperOrclNTx = null;
		try {
			readerOrclNTx 		= Resources.getResourceAsReader( "entidad/ConfigOrclNTx.xml" );
			builderOrclNTx 		= new SqlSessionFactoryBuilder( );
			sqlMapperOrclNTx 	= builderOrclNTx.build( readerOrclNTx );
		} catch ( Exception e ) {
			LogHandler.error(null, FabricaConexiones.class,
					"Existio un erorr en la Fabrica de Conexiones Orcl NTx", e);
 		}
		fACTORY_ORCL_NTX = sqlMapperOrclNTx;
		}

	/**
	 * Obtiene una sesion a la base de datos.
	 * @throws IOException
	 */
	private static void iobtenerSesionOrclTx()	{
		Reader 						readerOrclTx;
		SqlSessionFactoryBuilder 	builderOrclTx;
		SqlSessionFactory 			sqlMapperOrclTx = null;
		try {
			readerOrclTx 		= Resources.getResourceAsReader( "entidad/ConfigOrclNTx.xml" );
			builderOrclTx 		= new SqlSessionFactoryBuilder( );
			sqlMapperOrclTx 	= builderOrclTx.build( readerOrclTx );
		} catch ( Exception e ) {
			LogHandler.error(null, FabricaConexiones.class,
					"Existio un erorr en la Fabrica de Conexiones Orcl Tx", e);
 		}
		fACTORY_ORCL_TX = sqlMapperOrclTx;
		}

	/**
	 * Obtiene una sesion a la base de datos.
	 * @throws IOException
	 */
	private static void iobtenerSesionOrclCUTx() {
		Reader 						readerOrclNTx;
		SqlSessionFactoryBuilder 	builderOrclNTx;
		SqlSessionFactory 			sqlMapperOrclNTx = null;
		try {
			readerOrclNTx 		= Resources.getResourceAsReader( "entidad/ConfigOrclTx.xml" );
			builderOrclNTx 		= new SqlSessionFactoryBuilder( );
			sqlMapperOrclNTx 	= builderOrclNTx.build( readerOrclNTx );
		} catch ( Exception e ) {
			LogHandler.error(null, FabricaConexiones.class,
					"Existio un erorr en la Fabrica de Conexiones Orcl Tx", e);
			}
		fACTORY_ORCL_CU_TX = sqlMapperOrclNTx;
		}

	/**
	 * Obtiene una sesion a la base de datos.
	 * @throws IOException
	 */
	private static void iobtenerSesionOrclCUNTx() {
	Reader 						readerOrclNTx;
	SqlSessionFactoryBuilder 	builderOrclNTx;
	SqlSessionFactory 			sqlMapperOrclNTx = null;
	try {
		readerOrclNTx 		= Resources.getResourceAsReader( "entidad/ConfigOrclTx.xml" );
		builderOrclNTx 		= new SqlSessionFactoryBuilder( );
		sqlMapperOrclNTx 	= builderOrclNTx.build( readerOrclNTx );
	} catch ( Exception e ) {
		LogHandler.error(null, FabricaConexiones.class, "Existio un erorr en la Fabrica de Conexiones Orcl Tx", e);
		}
		fACTORY_ORCL_CU_NTX = sqlMapperOrclNTx;
	}

	/**
	 * Obtiene una sesion a la base de datos.
	 * @throws IOException
	 */
	private static void iobtenerSesionSqlBatch() {
		Reader 						readerBatch;
		SqlSessionFactoryBuilder 	builderBatch;
		SqlSessionFactory 			sqlMapperBatch = null;
		try {
			readerBatch 	= Resources.getResourceAsReader( "entidad/ConfigSqlBatch.xml" );
			builderBatch 	= new SqlSessionFactoryBuilder( );
			sqlMapperBatch 	= builderBatch.build( readerBatch );
		} catch ( Exception e ) {
			LogHandler.error(null, FabricaConexiones.class,
					"Existio un erorr en la Fabrica de Conexiones SQL Server Batch", e);
			}
		fACTORY_SQL_BATCH = sqlMapperBatch;
		}

	/**
	 * Obtiene una sesion a IQ
	 */
	private static void iobtenerSesionSybaseIQ() {
		Reader 						readerBatch;
		SqlSessionFactoryBuilder 	builderBatch;
		SqlSessionFactory 			sqlMapperBatch = null;
		try {
			readerBatch 	= Resources.getResourceAsReader( "entidad/ConfigIQSybase.xml" );
			builderBatch 	= new SqlSessionFactoryBuilder( );
			sqlMapperBatch 	= builderBatch.build( readerBatch );
		} catch ( Exception e ) {
			LogHandler.error(null, FabricaConexiones.class,
					"Existio un erorr en la Fabrica de Conexiones SQL Server Batch", e);
			}
		fACTORY_SYBASE_IQ = sqlMapperBatch;
		}

	/**
	 * Obtiene una sesion a IQ
	 */
	private static void iobtenerSesionPostgres() {
		Reader 						readerPostgres;
		SqlSessionFactoryBuilder 	builderPostgres;
		SqlSessionFactory 			sqlMapperPostgres = null;
		try {
			readerPostgres 	= Resources.getResourceAsReader( "entidad/ConfigPostgres.xml" );
			builderPostgres 	= new SqlSessionFactoryBuilder( );
			sqlMapperPostgres 	= builderPostgres.build( readerPostgres );
		} catch ( Exception e ) {
			LogHandler.error(null, FabricaConexiones.class,
					"Existio un erorr en la Fabrica de Conexiones Postgres", e);
			}
		fACTORY_POSTGRES = sqlMapperPostgres;
	}

	/**
	 * Obtiene una sesion a la base de datos.
	 * @return Sesion.
	 * @throws IOException
	 */
	public static SqlSession obtenerSesionTx( ) throws SQLException {
		SqlSession regreso = null;
		try {
			if ( fACTORY_TX == null ) {
				iobtenerSesionTx();
			}
			if ( fACTORY_TX != null ) {
				regreso = fACTORY_TX.openSession( false );
			}
			if ( regreso == null ) {
				throw new Exception(  );
			}
		} catch (Exception e) {
			LogHandler.error(null, FabricaConexiones.class, "Existio un erorr al obtenerSesionTx", e);
			throw new SQLException( "Sin conexion TX a la base de datos" );
		}
		return regreso;
	}


	/**
	 * Obtiene una sesion a la base de datos.
	 * @return Sesion.
	 * @throws IOException
	 */
	public static SqlSession obtenerSesionNTx( ) throws SQLException {
		SqlSession regreso = null;
		try {
			if ( fACTORY_NTX == null ) {
				iobtenerSesionNTx();
			}
			if ( fACTORY_NTX != null ) {
				regreso = fACTORY_NTX.openSession( true ); //Autocommit ON, no permite transacciones
			}
			if ( regreso == null ) {
				throw new Exception(  );
			}
		} catch (Exception e) {
			LogHandler.error(null, FabricaConexiones.class, "Exsitio un erorr al obtenerSesionNTx", e);
			throw new SQLException( "Sin conexion NTX a la base de datos" );
		}
		return regreso;
	}

	/**
	 * Obtiene una sesion a la base de datos.
	 * @return Sesion.
	 * @throws IOException
	 */
	public static SqlSession obtenerSesionBatch( ) throws SQLException {
		SqlSession regreso = null;
		try {
			if ( fACTORY_BATCH == null ) {
				iobtenerSesionBatch();
			}
			if ( fACTORY_BATCH != null ) {
				regreso = fACTORY_BATCH.openSession( true ); //Autocommit ON, no permite transacciones
			}
			if ( regreso == null ) {
				throw new Exception(  );
			}
		} catch (Exception e) {
			LogHandler.error(null, FabricaConexiones.class, "Exsitio un erorr al obtenerSesionBatch", e);
			throw new SQLException( "Sin conexion BATCH a la base de datos" );
		}
		return regreso;
	}

	/**
	 * Obtiene una sesion a la base de datos.
	 * @return Sesion.
	 * @throws IOException
	 */
	public static SqlSession obtenerSesionOrclNTx( ) throws SQLException {
		SqlSession regreso = null;
		try {
			if ( fACTORY_ORCL_NTX == null ) {
				iobtenerSesionOrclNTx();
			}
			if ( fACTORY_ORCL_NTX != null ) {
				regreso = fACTORY_ORCL_NTX.openSession( true ); //Autocommit ON, no permite transacciones
			}
			if ( regreso == null ) {
				throw new Exception(  );
			}
		} catch (Exception e) {
			LogHandler.error(null, FabricaConexiones.class, "Existio un erorr al obtenerSesionOrclNTx", e);
			throw new SQLException( "Sin conexion ORACLE NTX a la base de datos" );
		}
		return regreso;
	}

	/**
	 * Obtiene una sesion a la base de datos.
	 * @return Sesion.
	 * @throws IOException
	 */
	public static SqlSession obtenerSesionOrclTx( ) throws SQLException {
		SqlSession regreso = null;
		try {
			if ( fACTORY_ORCL_TX == null ) {
				iobtenerSesionOrclTx();
			}
			if ( fACTORY_ORCL_TX != null ) {
				regreso = fACTORY_ORCL_TX.openSession( false ); //Autocommit ON, no permite transacciones
			}
			if ( regreso == null ) {
				throw new Exception(  );
			}
		} catch (Exception e) {
			LogHandler.error(null, FabricaConexiones.class, "Existio un erorr al obtenerSesionOrclTx", e);
			throw new SQLException( "Sin conexion ORACLE TX a la base de datos" );
		}
		return regreso;
	}

	/**
	 * Obtiene una sesion a la base de datos.
	 * @return Sesion.
	 * @throws IOException
	 */
	public static SqlSession obtenerSesionOrclCUTx( ) throws SQLException {
		SqlSession regreso = null;
		try {
			if ( fACTORY_ORCL_CU_TX == null ) {
				iobtenerSesionOrclCUTx();
			}
			if ( fACTORY_ORCL_CU_TX != null ) {
				regreso = fACTORY_ORCL_CU_TX.openSession( false ); //Autocommit ON, no permite transacciones
			}
			if ( regreso == null ) {
				throw new Exception(  );
			}
		} catch (Exception e) {
			LogHandler.error(null, FabricaConexiones.class, "Existio un erorr al obtenerSesionOrclCUTx", e);
			throw new SQLException( "Sin conexion ORACLE TX a la base de datos" );
		}
		return regreso;
	}

	/**
	 * Obtiene una sesion a la base de datos.
	 * @return Sesion.
	 * @throws IOException
	 */
	public static SqlSession obtenerSesionOrclCUNTx( ) throws SQLException {
		SqlSession regreso = null;
		try {
			if ( fACTORY_ORCL_CU_NTX == null ) {
				iobtenerSesionOrclCUTx();
			}
			if ( fACTORY_ORCL_CU_NTX != null ) {
				regreso = fACTORY_ORCL_CU_NTX.openSession( true ); //Autocommit ON, no permite transacciones
			}
			if ( regreso == null ) {
				throw new Exception(  );
			}
		} catch (Exception e) {
			LogHandler.error(null, FabricaConexiones.class, "Existio un erorr al obtenerSesionOrclCUNTx", e);
			throw new SQLException( "Sin conexion ORACLE TX a la base de datos" );
		}
		return regreso;
	}

	/**
	 * Obtiene una sesion a la base de datos.
	 * @return Sesion.
	 * @throws IOException
	 */
	public static SqlSession obtenerSesionSqlBatch( ) throws SQLException {
		SqlSession regreso = null;
		try {
			if ( fACTORY_SQL_BATCH == null ) {
				iobtenerSesionSqlBatch();
			}
			if ( fACTORY_SQL_BATCH != null ) {
				regreso = fACTORY_SQL_BATCH.openSession( true ); //Autocommit ON, no permite transacciones
			}
			if ( regreso == null ) {
				throw new Exception(  );
			}
		} catch (Exception e) {
			LogHandler.error(null, FabricaConexiones.class, "Existio un erorr al obtenerSesionSqlBatch", e);
			throw new SQLException( "Sin conexion SQL Server a la base de datos" );
		}
		return regreso;
	}

	/**
	 * Obtiene una sesion a la base de datos.
	 * @return Sesion.
	 * @throws IOException
	 */
	public static SqlSession obtenerSesionSybaseIQ( ) throws SQLException {
		SqlSession regreso = null;
		try {
			if ( fACTORY_SYBASE_IQ == null ) {
				iobtenerSesionSybaseIQ();
			}
			if ( fACTORY_SYBASE_IQ != null ) {
				regreso = fACTORY_SYBASE_IQ.openSession( true ); //Autocommit ON, no permite transacciones
			}
			if ( regreso == null ) {
				throw new Exception(  );
			}
		} catch (Exception e) {
			LogHandler.error(null, FabricaConexiones.class, "Existio un erorr al obtenerSessionSybaseIQ", e);
			throw new SQLException( "Sin conexion Sybase IQ a la base de datos" );
		}
		return regreso;
	}

	/**
	 * Obtiene una sesion a la base de datos.
	 * @return Sesion.
	 * @throws IOException
	 */
	public static SqlSession obtenerSesionPostgresTx( ) throws SQLException {
		SqlSession regreso = null;
		try {
			if ( fACTORY_POSTGRES == null ) {
				iobtenerSesionPostgres();
			}
			if ( fACTORY_POSTGRES != null ) {
				regreso = fACTORY_POSTGRES.openSession( false ); //Autocommit ON, no permite transacciones
			}
			if ( regreso == null ) {
				throw new Exception(  );
			}
		} catch (Exception e) {
			LogHandler.error(null, FabricaConexiones.class, "Existio un erorr al obtenerSesionPostgresTx", e);
			throw new SQLException( "Sin conexion Postgres a la base de datos" );
		}
		return regreso;
	}

	/**
	 * Obtiene una sesion a la base de datos.
	 * @return Sesion.
	 * @throws IOException
	 */
	public static SqlSession obtenerSesionPostgresNTx( ) throws SQLException {
		SqlSession regreso = null;
		try {
			if ( fACTORY_POSTGRES == null ) {
				iobtenerSesionPostgres();
			}
			if ( fACTORY_POSTGRES != null ) {
				regreso = fACTORY_POSTGRES.openSession( true ); //Autocommit ON, no permite transacciones
			}
			if ( regreso == null ) {
				throw new Exception(  );
			}
		} catch (Exception e) {
			LogHandler.error(null, FabricaConexiones.class, "Existio un erorr al obtenerSesionPostgresNTx", e);
			throw new SQLException( "Sin conexion Postgres a la base de datos" );
		}
		return regreso;
	}

	/**
	 * Cierra una sesion a la base de datos.
	 * @param conn tipo SqlSession
	 * @throws IOException
	 */
	public static void close(SqlSession conn) {
		if ( conn != null ) {
			conn.close( );
			conn = null;
			}
	}
	/**
	 * Regresa los cambios de la base de datos.
	 * @param conn tipo SqlSession
	 * @throws IOException
	 */
	public static void rollBack(SqlSession conn) {
		if ( conn != null ) {
			conn.rollback( true );
		}
	}

	/**
	 * obtiene los datos para hostear en sybase
	 * @return respuesta
	 */
	public static String hostSybase( ) {
		final Properties properties = new Properties();
		final java.lang.StringBuffer respuesta = new StringBuffer();
		try {
			properties.load( Resources.getResourceAsReader( "entidad/config.properties" ) );
			respuesta.append( properties.getProperty( "sybase.ip" ) );
			} catch ( java.lang.Exception exception ) {
					respuesta.append( "Fallo IP" );
			}
		return respuesta.toString();
		}

	/**
	 * Obtiene datos para una sesion en Oracle
	 * @return respuesta
	 */
	public static String hostOracle( ) {
		final Properties properties = new Properties();
		final java.lang.StringBuffer respuesta = new StringBuffer();
		try {
			properties.load( Resources.getResourceAsReader( "entidad/config.properties" ) );
			respuesta.append( properties.getProperty( "oracle.ip" ) );
			}
		catch ( java.lang.Exception exception ) {
			respuesta.append( "Fallo IP" );
			}
		return respuesta.toString();
		}

	/**
	 * Obtiene los datos para una sesion SqlServer
	 * @return respuesta
	 */
	public static String hostSqlServer( ) {
		final Properties properties = new Properties();
		final java.lang.StringBuffer respuesta = new StringBuffer();
		try {
			properties.load( Resources.getResourceAsReader( "entidad/config.properties" ) );
			respuesta.append( properties.getProperty( "sqlserver.ip" ) );
			}
		catch ( java.lang.Exception exception ) {
			respuesta.append( "Fallo IP" );
			}
		return respuesta.toString();
		}

	/**
	 * Recupera los datos para Sybase IQ
	 * @return respuesta
	 */
	public static String hostSybaseIQ( ) {
		final Properties properties = new Properties();
		final java.lang.StringBuffer respuesta = new StringBuffer();
		try {
			properties.load( Resources.getResourceAsReader( "entidad/config.properties" ) );
			respuesta.append( properties.getProperty( "iqsybase.ip" ) );
			}
		catch ( java.lang.Exception exception ) {
			respuesta.append( "Fallo IP" );
			}
		return respuesta.toString();
		}

}
