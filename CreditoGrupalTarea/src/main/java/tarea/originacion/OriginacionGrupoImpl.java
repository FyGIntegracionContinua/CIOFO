/**
 * Tensegrity - 2011
 */
package tarea.originacion;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.osoa.sca.annotations.Reference;

import tarea.comun.ComunTarea;
import tarea.comun.DataEstado;
import utilitario.comun.Funciones;
import utilitario.log.LogHandler;
import utilitario.mensajes.comun.ResultadoOV;
import utilitario.mensajes.originacion.grupo.GrupoOV;
import entidad.conexiones.FabricaConexiones;
import entidad.originacion.secuencias.GeneraSecuencias;

 

/**
 * @author Juan Moreno
 * Encapsula la implementacion del componente Entity OriginacionGrupo.
 * <ul>
 *  <li></li>
 * </ul>
 */
public final class OriginacionGrupoImpl implements OriginacionGrupo {

	ComunTarea comun;

	public OriginacionGrupoImpl( @Reference(name = "comun") ComunTarea comun ) {
		 this.comun = comun;
	}

	public HashMap<String, String> obtenerIdentificador( String uid ) {
		final java.util.HashMap<String, String> claves = new HashMap<String, String>();
		String identificador = null;
		try {
			Long id = GeneraSecuencias.getSigSecuenciaPersonas( uid );
			if ( id != null )
				{
				identificador = Funciones.padLeftZeros( id.toString(),  9 );
				claves.put( "credprod" , identificador );
				claves.put( "t24" , "" + GeneraSecuencias.getSigSecuenciaT24(uid) );
				}
		}
		catch ( Exception e) {
			LogHandler.error(uid, this.getClass(), "Existio un error dentro de OriginacionGrupoImpl obtenerIdentificador: " + e.getMessage(), e);
		} finally {
			LogHandler.info(uid, this.getClass(), "EL identificadr de grupo generado es: " + identificador);	
		}
		return claves;
	}


	/* (non-Javadoc)
	 * @see fisa.core.grupal.entidad.Grupo#existe(java.lang.String)
	 */
	public boolean existe( String uid, String grupo ) {
		boolean 	regreso = true;
		SqlSession 	sesion	= null ;
		try {
			sesion = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(), "==> existe -  " + OPER_CONTAR_PERSONA);
			if( ( Integer ) sesion.selectOne( OPER_CONTAR_PERSONA, grupo ) == 0 )
				regreso = false;
		} 
		catch (Exception e) {	
			LogHandler.error(uid, this.getClass(), "Existio un error cuando se buscaba el grupo a actualizar: " + e.getMessage(),e);
			regreso = false;
		} finally {
			FabricaConexiones.close( sesion );
		}
 
		return regreso;
	}

	/* (non-Javadoc)
	 * @see fisa.core.grupal.entidad.Grupo#registrar(fisa.core.grupal.vo.GrupoVO)
	 */
 	public ResultadoOV registrar(String uid,  GrupoOV grupo ) {
		final String MSG = "REGISTRADO.";
		SqlSession 				sesion				= null ;
		Map<String, Object> 	params		 		= new HashMap<String, Object>( );
		Date					fechaAlta			= new Date( );
		ResultadoOV				resultado			= new ResultadoOV( );
		ResultadoOV				regreso				= new ResultadoOV( );

		if( grupo.getDomicilio( ) == null || grupo.getDomicilio( ).getCalle( ) == null || 
			grupo.getDomicilio( ).getColonia( ) == null || grupo.getDomicilio().getCp( ) == null || 
			grupo.getDomicilio( ).getLocalidad() == null || 
			grupo.getDomicilio( ).getEntidad( ) == null || grupo.getDomicilio( ).getMunicipio( ) == null )
			{
			regreso.setMensaje( "GRUPO NO REGISTRADO." );
			regreso.setEstatus( false );
			regreso.setIdentificador( "" );
			return regreso;
			}
		
		regreso.setEstatus( false );
		regreso.setUid( uid );
		params.put( PERSONA, grupo.getIdentificador( ) );
		params.put( NOMBRE, grupo.getNombre( ).toUpperCase() );
		params.put( CALLE, grupo.getDomicilio( ) != null && grupo.getDomicilio( ).getCalle( ) != null ? grupo.getDomicilio( ).getCalle( ) : "");
		params.put( COLONIA, grupo.getDomicilio( ) != null && grupo.getDomicilio( ).getColonia( ) != null ? grupo.getDomicilio( ).getColonia( ) :"" );
		params.put( CP, grupo.getDomicilio( ) != null && grupo.getDomicilio().getCp( ) != null ? grupo.getDomicilio().getCp( ) : 0 );
		params.put( ENTIDAD, grupo.getDomicilio( ) != null && grupo.getDomicilio( ).getEntidad( ) != null ? grupo.getDomicilio( ).getEntidad( ) : "" );
		params.put( CIUDAD, grupo.getDomicilio( ) != null && grupo.getDomicilio( ).getLocalidad() != null ? grupo.getDomicilio( ).getLocalidad() : "" );
		params.put( FECHA_ALTA, fechaAlta != null ? fechaAlta : "" );
		params.put( MUNICIPIO, grupo.getDomicilio( ) != null && grupo.getDomicilio( ).getMunicipio( ) != null ? grupo.getDomicilio( ).getMunicipio( ) : "" );
		params.put( FECHA_ULT_MOD, fechaAlta   );
		
 		try {
 			//Se valida la entidad
 			if( params.get( ENTIDAD ) != null && !params.get( ENTIDAD ).toString().trim().equals( "" ) )
 				{
 				if( params.get( ENTIDAD ).toString().trim().length() > 3 )
 					{
 					//Se cambia la entidad
 					params.put( ENTIDAD, DataEstado.mapClaveEntidad( params.get( ENTIDAD ).toString().trim() ) );
 					}
 				}
 			
 			sesion = FabricaConexiones.obtenerSesionTx( );
 			LogHandler.trace(uid, getClass(), "==>registrar - " +  OPER_REGISTRAR_GRUPO);
			resultado = ( ResultadoOV ) sesion.selectOne( OPER_REGISTRAR_GRUPO, params );
			LogHandler.debug(uid, this.getClass(), "Resultado: " + resultado );
			if( resultado == null || !resultado.isSuccess( ) )
				throw new Exception( "" );
			
			final java.util.HashMap<String, String> 
			paramsClaves = new HashMap<String, String>();
			paramsClaves.put( "persona"  , grupo.getIdentificador() != null ? grupo.getIdentificador() :"" );
			paramsClaves.put( "clave_T24", grupo.getClienteT24( ) != null ? grupo.getClienteT24( ) :"" );


			//Se registra la relacion de claves
			LogHandler.trace(uid, getClass(), "==> registrar - registrarRelacionClaveFinsol");
			sesion.insert( "registrarRelacionClaveFinsol", paramsClaves );
			
			sesion.commit( true );
			regreso.setEstatus( resultado.isSuccess( ) );
			regreso.setEstatus( true );
			regreso.setMensaje( MENSAJE_OK + MSG );
		} catch ( Exception e ) {
			FabricaConexiones.rollBack( sesion );
			regreso.setMensaje( e.getCause() instanceof java.sql.SQLTimeoutException  ? MENSAJE_TIMEOUT + MSG : MENSAJE_ERROR + MSG );
			regreso.setExcepcion( e.getCause() +"");
			regreso.setEstatus( false );
			regreso.setCodigo( null );
			LogHandler.error(uid, this.getClass(), "Existio un error al crear el grupo: " + e.getMessage(), e );
		}
		finally {
			FabricaConexiones.close( sesion );
			regreso.setIdentificador(grupo.getClienteT24( ));
			regreso.setPeticion_Ofs(grupo.getPeticion_ofs());
			LogHandler.info(uid, this.getClass(), " OriginacionGrupo OK: " + regreso);
		}
		return regreso;
	}

	/* (non-Javadoc)
	 * @see fisa.core.grupal.entidad.Grupo#actualizar(fisa.core.grupal.vo.GrupoVO)
	 */
 	public ResultadoOV actualizarTx( String uid, SqlSession sesion, GrupoOV grupo ) {
		String MSG = "ACTUALIZADO.";
		Map<String, Object> params 		= new HashMap<String, Object>( );
 		Date				fechaModificacion	= new Date( );
		ResultadoOV			regreso				= new ResultadoOV( );

		if( grupo.getDomicilio( ) == null || grupo.getDomicilio( ).getCalle( ) == null || grupo.getDomicilio( ).getColonia( ) == null ||
				grupo.getDomicilio().getCp( ) == null || grupo.getDomicilio( ).getEntidad( ) == null || 
				grupo.getDomicilio( ).getLocalidad() == null || grupo.getDomicilio( ).getMunicipio( ) == null )
			{
			regreso.setMensaje( "GRUPO NO ACTUALIZADO." );
			regreso.setEstatus( true );
			return regreso;
			}

		params.put( PERSONA, grupo.getIdentificador()  );
		params.put( NOMBRE, grupo.getNombre() );
		params.put( CALLE, grupo.getDomicilio( ) != null && grupo.getDomicilio( ).getCalle( ) != null ? grupo.getDomicilio( ).getCalle( ) : "");
		params.put( COLONIA, grupo.getDomicilio( ) != null && grupo.getDomicilio( ).getColonia( ) != null ? grupo.getDomicilio( ).getColonia( ) :"" );
		params.put( CP, grupo.getDomicilio( ) != null && grupo.getDomicilio().getCp( ) != null ?grupo.getDomicilio().getCp( ) :0 );
		params.put( ENTIDAD, grupo.getDomicilio( ) != null && grupo.getDomicilio( ).getEntidad( ) != null ? grupo.getDomicilio( ).getEntidad( ) : "" );
		params.put( CIUDAD, grupo.getDomicilio( ) != null && grupo.getDomicilio( ).getLocalidad() != null ? grupo.getDomicilio( ).getLocalidad() : "" );
		params.put( MUNICIPIO, grupo.getDomicilio( ) != null && grupo.getDomicilio( ).getMunicipio( ) != null ? grupo.getDomicilio( ).getMunicipio( ) : "" );
		params.put( FECHA_ULT_MOD, fechaModificacion );
 		try {
 			//Se valida la entidad
 			if( params.get( ENTIDAD ) != null && !params.get( ENTIDAD ).toString().trim().equals( "" ) )
 				{
 				if( params.get( ENTIDAD ).toString().trim().length() > 3 )
 					{
 					//Se cambia la entidad
 					params.put( ENTIDAD, DataEstado.mapClaveEntidad( params.get( ENTIDAD ).toString().trim() ) );
 					}
 				}

 			LogHandler.trace(uid, getClass(), "actualizarTx - " + OPER_ACTUALIZAR_GRUPO);
			sesion.update( OPER_ACTUALIZAR_GRUPO, params );
			regreso.setMensaje(  MENSAJE_OK + MSG );
			regreso.setEstatus( true );
		} catch ( Exception e ) {
			regreso.setMensaje( e.getCause() instanceof java.sql.SQLTimeoutException  ? MENSAJE_TIMEOUT + MSG : MENSAJE_ERROR + MSG );
			regreso.setExcepcion( e.getCause() +"");
			regreso.setEstatus( false );
			regreso.setCodigo( null );
			LogHandler.error(uid, this.getClass(), "Existio un error al actualizarTX el grupo: " + grupo + " - " + e.getMessage(), e );
		} 
		return regreso;
	}

	/* (non-Javadoc)
	 * @see fisa.core.grupal.entidad.Grupo#actualizar(fisa.core.grupal.vo.GrupoVO)
	 */
	public ResultadoOV actualizar(String uid, GrupoOV grupo ) {
		String MSG = "ACTUALIZADO.";
		SqlSession 	sesion	= null ;
		ResultadoOV	regreso	= new ResultadoOV( );

 		try {
			sesion 	= FabricaConexiones.obtenerSesionTx();
			regreso = actualizarTx(uid, sesion, grupo);
			sesion.commit( true );
		} catch ( Exception e ) {
			FabricaConexiones.rollBack( sesion );
			regreso.setMensaje( e.getCause() instanceof java.sql.SQLTimeoutException  ? MENSAJE_TIMEOUT + MSG : MENSAJE_ERROR + MSG );
			regreso.setExcepcion( e.getCause() +"");
			regreso.setEstatus(false);
			regreso.setCodigo(null);
			LogHandler.error(uid, this.getClass(), "Existio un error al actualizar el grupo: " + grupo + " - " + e.getMessage(), e );
 		}
		finally {
			FabricaConexiones.close( sesion );
			regreso.setUid(uid);
			regreso.setIdentificador(grupo.getClienteT24());
			regreso.setPeticion_Ofs(grupo.getPeticion_ofs());
 			LogHandler.info(uid, this.getClass(), "ActualizarGrupo: " + regreso );
		}
		return regreso;
	}

	/*
	 * (non-Javadoc)
	 * @see tarea.originacion.OriginacionGrupo#existeGrupo(java.lang.String, utilitario.mensajes.originacion.grupo.GrupoOV)
	 */
	@SuppressWarnings("unchecked")
	public ResultadoOV existeGrupo(String uid, GrupoOV grupoOV)
		{
		final ResultadoOV resultadoOV = new ResultadoOV();
		SqlSession sesion = null ;
		try {
			//Se establece la conexion
			sesion = FabricaConexiones.obtenerSesionNTx();

			//Datos para la consulta
			final java.util.HashMap<String, Object> 
								  parametrosMap = new java.util.HashMap<String, Object>();
								  parametrosMap.put( "nombre" 	, grupoOV.getNombre().trim() );
								  parametrosMap.put( "sucursal" , grupoOV.getSucursal() );

			//Se realiza la consulta
			LogHandler.trace(uid, getClass(), "==> existeGrupo - " +  OPER_BUSCAR_GRUPO );
			final java.util.List<Integer> result = (java.util.List<Integer>)sesion.selectList( OPER_BUSCAR_GRUPO, parametrosMap ); 
			resultadoOV.setIdentificador( result.size() == 0 ? "" : result.get(0).toString() );			
			} 
		catch (Exception e) {
			LogHandler.error(uid, this.getClass(), "Existio un error cuando se buscaba el nombre de grupo: " + e.getMessage(),e);
			resultadoOV.setIdentificador( "" );
		} finally {
			FabricaConexiones.close( sesion );
		}
 
		return resultadoOV;
		}

	/*
	 * (non-Javadoc)
	 * @see tarea.originacion.OriginacionGrupo#obtenerClaveCredprod(java.lang.String, java.lang.String)
	 */
	public String obtenerClaveCredprod(String uid, String t24) 
		{
		return comun.obtenerPersonaCliente(uid,t24 );
		}
}
