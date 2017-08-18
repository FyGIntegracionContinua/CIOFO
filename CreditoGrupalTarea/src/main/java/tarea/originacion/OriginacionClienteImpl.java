/**
 * Tensegrity - 2011
 */
package tarea.originacion;

import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.osoa.sca.annotations.Reference;

import tarea.comun.ComunTarea;
import tarea.comun.DataEstado;
import tarea.comun.ReadProperties;
import utilitario.comun.Funciones;
import utilitario.log.LogHandler;
import utilitario.mensajes.comun.ResultadoOV;
import utilitario.mensajes.originacion.cliente.ClienteOV;
import utilitario.mensajes.originacion.cliente.ClientePeticion;
import entidad.conexiones.FabricaConexiones;
import entidad.originacion.secuencias.GeneraSecuencias;

/**
 * @author Juan Moreno
 * Implementacion del componenete Entity ChequesSIC.
 * <ul>
 *  <li></li>
 * </ul>
 */
public final class OriginacionClienteImpl implements OriginacionCliente {

	private ComunTarea comun;
	public OriginacionClienteImpl( @Reference(name = "comun") ComunTarea comun ) {
		this.comun = comun;
	}

	/*
	 * (non-Javadoc)
	 * @see tarea.originacion.OriginacionCliente#obtenerIdentificador(java.lang.String, java.lang.String, java.lang.String)
	 */
	public  final java.util.HashMap<String, String> obtenerIdentificador( String uid,String t24, String credprod) {
		final java.util.HashMap<String, String> claves = new HashMap<String, String>();
		String identificador = null;
		try {
			//Solo si no se manda la clave de credprod se genera
			final Long id = credprod == null || credprod.trim().equals( "" )
					? GeneraSecuencias.getSigSecuenciaPersonas( uid ) : 0L;

			LogHandler.debug(uid, this.getClass(), "El id de la secuencuia es:" + id);
			if ( id != null )
				{
				identificador = credprod == null || credprod.trim().equals( "" )
						 ? Funciones.padLeftZeros( id.toString(),  9 ) : credprod;
				claves.put( "credprod" , identificador );
				claves.put( "t24" , "" + ( ( t24 == null || t24.trim().equals( "" ) )
						&& ( credprod == null || credprod.trim().equals( "" ) )
						? GeneraSecuencias.getSigSecuenciaT24(uid) : t24) );
				}
		} catch ( Exception e) {
			e.printStackTrace();
			LogHandler.error(uid, this.getClass(), "Existio un error dentro de obtenerIdentificador", e);
		}
		finally {
			LogHandler.info(uid, this.getClass(), "EL identificadr generado es: " + identificador);
		}
		return claves;
	}

	/* (non-Javadoc)
	 * @see fisa.core.grupal.entidad.Persona#existe(java.lang.String)
	 */
	public boolean existe( String uid, String persona ) {
		boolean 	regreso = false;
		SqlSession 	sesion	= null;
		if ( persona != null ) {
			try {
				sesion = FabricaConexiones.obtenerSesionNTx();

				//Se recupera la clave de credprod
				final  String personaCredprod = comun.obtenerPersonaCliente(uid, persona);

				//Solo si la entrada es una claveCredprod
				if ( !personaCredprod.equals( "" ) )
					{
					persona = personaCredprod;
					}

				LogHandler.trace(uid, getClass(), "==> existe - " + OPER_CONTAR_PERSONA );
				if ( ( Integer ) sesion.selectOne( OPER_CONTAR_PERSONA, persona ) != 0 )
					regreso = true;
				}
			catch (Exception e)
				{
				LogHandler.error(uid, this.getClass(),
						"Existio un error dentro del metodo existe de OriginacionCliente:" + e.getMessage(), e);
				regreso = false;
				}
			finally
				{
				FabricaConexiones.close( sesion );
				}
		}
		return regreso;
	}

	/* (non-Javadoc)
	 * @see fisa.core.grupal.entidad.Persona#registrar(fisa.core.grupal.vo.ClienteVO)
	 */
	
	public ResultadoOV registrar(String uid, ClientePeticion peticion ) {
		String MSG = "REGISTRADO.";
		SqlSession 					sesionTx			= null;
		Map<String, Object>			params		 		= new HashMap<String, Object>( );
 		Date						fechaAlta			= new Date( );
 		ResultadoOV					regreso				= new ResultadoOV( );
 		ResultadoOV					resultado			= new ResultadoOV( );
 		regreso.setUid( uid );

 		ClienteOV cliente = peticion.getBody();

 		LogHandler.debug( uid, this.getClass(), "Objeto de entrada: ClienteOV [ " + cliente + " ]");

 		params.put( PERSONA, cliente.getPersona( ) );
 		params.put( NOMBRE, cliente.getNombre( )  != null ? cliente.getNombre( ) : "");
 		params.put( APELLIDO_PAT, cliente.getPaterno() != null ? cliente.getPaterno() : "");
 		params.put( APELLIDO_MAT, cliente.getMaterno() != null ? cliente.getMaterno() : "");
 		params.put( RFC, cliente.getRfc() != null ?  cliente.getRfc() : "");
 		params.put( "curp", cliente.getCurp() != null ?  cliente.getCurp() : "");
 		params.put( FECHA_NACIMIENTO, cliente.getFechaNacimiento() != null ?  cliente.getFechaNacimiento() : "");
 		params.put( SEXO, cliente.getGenero() != null ? cliente.getGenero() : "");
 		params.put( EDO_CIVIL, cliente.getEstadoCivil() != null ? cliente.getEstadoCivil() : "");
 		params.put( CALLE, cliente.getDomicilio().getCalle() != null ? cliente.getDomicilio().getCalle() : "");
 		params.put( COLONIA, cliente.getDomicilio().getColonia() != null ?  cliente.getDomicilio().getColonia() : "");
 		params.put( CP, cliente.getDomicilio().getCp() );
 		params.put( ENTIDAD, cliente.getDomicilio().getEntidad() != null ? cliente.getDomicilio().getEntidad() : "");
 		params.put( CIUDAD, cliente.getDomicilio().getLocalidad() != null ? cliente.getDomicilio().getLocalidad() : "");
 		params.put( FECHA_ALTA, fechaAlta != null ?  fechaAlta : "");
 		params.put( MUNICIPIO, cliente.getDomicilio().getMunicipio() != null ? cliente.getDomicilio().getMunicipio() : "");
 		params.put( FECHA_ULT_MOD, fechaAlta != null ? fechaAlta : "");
 		params.put( NUMERO_IDENTIFICACION, cliente.getIfe() != null ? cliente.getIfe() : "" );
 		params.put( ACTIVIDAD_ECONOMICA, cliente.getActividadEconomica() != null ? cliente.getActividadEconomica() : "" );
 
		try {
			//Mapear entidad
			if ( params.get( ENTIDAD ) != null && !params.get( ENTIDAD ).toString().trim().equals( "" ) )
				{
				if ( params.get( ENTIDAD ).toString().trim().length() > 3 )
					{
					//Se cambia la entidad
					params.put( ENTIDAD, DataEstado.mapClaveEntidad( params.get( ENTIDAD ).toString().trim() ) );
					}
				}

			//Se abre conexion
			sesionTx 	= FabricaConexiones.obtenerSesionTx();

			//Se valida si existe el cliente
			final java.lang.Boolean existeCliente = comun.existeCliente(uid, cliente.getPersona( ) );

	 		if ( existeCliente )
	 			{
	 			resultado = actualizar(uid, peticion );
	 			}
	 		else
		 		{
				LogHandler.trace(uid, getClass(), "==> registrar - " + OPER_REGISTRAR_PERSONA );
				resultado 	= (ResultadoOV)
						sesionTx.selectOne( OPER_REGISTRAR_PERSONA, params ); //Realizamos la peticion a la capa de Entidad
		 		}

			LogHandler.debug(uid, getClass(), "Originacion Cliente 130 regreso: " + resultado );
			if ( resultado == null || !resultado.isSuccess( ) )
				throw new Exception( );

			if ( !existeCliente )
				{
				if ( cliente.getTelefono( ) != null && !cliente.getTelefono( ).equals("") )
					registrarTelefono( uid, sesionTx, cliente.getPersona( ), cliente.getTelefono( ), cliente.getLada( ), TELEFONO_DIRE , peticion.getHeader().getConsumer() );

				//Nuevos telefonos
				//Celular
				if ( cliente.getTelefonoCelular() != null && !cliente.getTelefonoCelular( ).equals("") )
					registrarTelefono( uid, sesionTx, cliente.getPersona( ), cliente.getTelefonoCelular( ), "" , TELEFONO_CELU , peticion.getHeader().getConsumer() );

				//Emplep
				if ( cliente.getTelefonoEmpleo() != null && !cliente.getTelefonoEmpleo( ).equals("") )
					registrarTelefono( uid, sesionTx, cliente.getPersona( ),
							cliente.getTelefonoEmpleo( ), "" , TELEFONO_EMPL , peticion.getHeader().getConsumer() );

				final java.util.HashMap<String, String> 
										paramsClaves = new HashMap<String, String>();
										paramsClaves.put( "persona"  , cliente.getPersona( )
												!= null ? cliente.getPersona( ) : "" );
										paramsClaves.put( "clave_T24", cliente.getClienteT24( )
												!= null ? cliente.getClienteT24( ) : "" );

				//Se registra la relacion de claves
				LogHandler.trace(uid, getClass(), "==> registrar - registrarRelacionClaveFinsol");
				sesionTx.insert( "registrarRelacionClaveFinsol", paramsClaves );

				}
			if ( !existeCliente )
				{	sesionTx.commit( true );	}

			cliente.setPersona( cliente.getClienteT24( ) );
			regreso.setMensaje( MENSAJE_OK + MSG + "  " + resultado.getMensaje() );
			regreso.setEstatus( true );
			regreso.setCodigo( resultado.getCodigo() );

		} catch ( Exception e ) {
			//e.printStackTrace();
			FabricaConexiones.rollBack( sesionTx );
			regreso.setMensaje( e.getCause() instanceof java.sql.SQLTimeoutException
					? MENSAJE_TIMEOUT + MSG : MENSAJE_ERROR + MSG );
			regreso.setExcepcion( e.getCause() + "");
			regreso.setEstatus( false );
			regreso.setCodigo( null );
			regreso.setUid(uid);
			LogHandler.error(uid,  getClass(), "Ocurrio un error al registrar el cliente: " + e.getMessage(), e);
		} finally {
			FabricaConexiones.close( sesionTx );
			regreso.setIdentificador(cliente.getClienteT24());
			regreso.setPeticion_Ofs( cliente.getOfs_peticion() );
			LogHandler.info(uid, getClass(), "Cliente Registrado: " + regreso.getIdentificador() );
		}
		return regreso;
	}

	/* (non-Javadoc)
	 * @see fisa.core.grupal.entidad.Persona#actualizar(fisa.core.grupal.vo.ClienteVO)
	 */
	public ResultadoOV actualizar( String uid, ClientePeticion peticion ) {
		String MSG = "ACTUALIZADO.";
		SqlSession 					sesion				= null;
		Map<String, Object>		 	params		 		= new HashMap<String, Object>( );
 		Date						fechaModificacion	= new Date( );
		ResultadoOV					regreso				= new ResultadoOV( );
		regreso.setUid( uid );
		regreso.setEstatus( false );

		ClienteOV cliente = peticion.getBody();

 		LogHandler.debug( uid, this.getClass(), "DATOS: " + cliente);

 		//Se le asigna el cliente
 		cliente.setPersona( comun.obtenerPersonaCliente(uid, cliente.getPersona( )) );
 

 		params.put( PERSONA, cliente.getPersona( ) );
 		params.put( NOMBRE, cliente.getNombre( )  != null ? cliente.getNombre( ) : "");
 		params.put( APELLIDO_PAT, cliente.getPaterno() != null ? cliente.getPaterno() : "");
 		params.put( APELLIDO_MAT, cliente.getMaterno() != null ? cliente.getMaterno() : "");
 		params.put( RFC, cliente.getRfc() != null ?  cliente.getRfc() : "");
 		params.put( "curp", cliente.getCurp() != null ?  cliente.getCurp() : null);
 		params.put( FECHA_NACIMIENTO, cliente.getFechaNacimiento() != null ?  cliente.getFechaNacimiento() : "");
 		params.put( SEXO, cliente.getGenero() != null ? cliente.getGenero() : "");
 		params.put( EDO_CIVIL, cliente.getEstadoCivil() != null ? cliente.getEstadoCivil() : "");
 		params.put( CALLE, cliente.getDomicilio().getCalle() != null ? cliente.getDomicilio().getCalle() : "");
 		params.put( COLONIA, cliente.getDomicilio().getColonia() != null ?  cliente.getDomicilio().getColonia() : "");
 		params.put( CP, cliente.getDomicilio().getCp() );
 		params.put( ENTIDAD, cliente.getDomicilio().getEntidad() != null ? cliente.getDomicilio().getEntidad() : "");
 		params.put( CIUDAD, cliente.getDomicilio().getLocalidad() != null ? cliente.getDomicilio().getLocalidad() : "");
 		params.put( MUNICIPIO, cliente.getDomicilio().getMunicipio() != null ? cliente.getDomicilio().getMunicipio() : "");
 		params.put( FECHA_ULT_MOD, fechaModificacion  );
 		params.put( NUMERO_IDENTIFICACION, cliente.getIfe() != null ? cliente.getIfe() : "" );

		try {
			//Mapear entidad
			if ( params.get( ENTIDAD ) != null && !params.get( ENTIDAD ).toString().trim().equals( "" ) )
				{
				if ( params.get( ENTIDAD ).toString().trim().length() > 3 )
					{
					//Se cambia la entidad
					params.put( ENTIDAD, DataEstado.mapClaveEntidad( params.get( ENTIDAD ).toString().trim() ) );
					}
				}

			//Se validan parametros de entrada
			if ( cliente.getPersona( ) == null )
				{
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.datos.incompletos" ) );
				}

			//Se valida que el cliente exista

			sesion 		= FabricaConexiones.obtenerSesionTx( );

			LogHandler.trace(uid, getClass(), "==> actualizar - " + OPER_ACTUALIZAR_PERSONA);
			sesion.update( OPER_ACTUALIZAR_PERSONA, params );
			if( cliente.getTelefono( ) != null && !cliente.getTelefono( ).equals("") )
				registrarTelefono(uid, sesion, cliente.getPersona( ), cliente.getTelefono( ), cliente.getLada( ), TELEFONO_DIRE , peticion.getHeader().getConsumer() );

			//Nuevos telefonos
			//Celular
			if( cliente.getTelefonoCelular() != null && !cliente.getTelefonoCelular( ).equals("") )
				registrarTelefono( uid,sesion, cliente.getPersona( ), cliente.getTelefonoCelular( ), "" , TELEFONO_CELU , peticion.getHeader().getConsumer() );

			//Emplep
			if( cliente.getTelefonoEmpleo() != null && !cliente.getTelefonoEmpleo( ).equals("") )
				registrarTelefono( uid,sesion, cliente.getPersona( ), cliente.getTelefonoEmpleo( ), "" , TELEFONO_EMPL , peticion.getHeader().getConsumer() );

			regreso.setMensaje( MENSAJE_OK + MSG );
			regreso.setEstatus( true );
			sesion.commit( true );
			}
		catch ( Exception e )
			{
			FabricaConexiones.rollBack( sesion );
			regreso.setMensaje( "Error al actualizar el cliente : " + e.getMessage() );
			regreso.setEstatus( false );
			LogHandler.error(uid, this.getClass(), "Existe un error al actualizar el cliente: " + e.getMessage(), e);
			}
		finally
			{
			FabricaConexiones.close( sesion );
			LogHandler.info(uid, getClass(), "Cliente Actualizado: " + regreso);
			regreso.setIdentificador(cliente.getClienteT24());
			regreso.setPeticion_Ofs( cliente.getOfs_peticion() );
			}
		return regreso;
	}
	
	/**
	 * Registra un telefono
	 * @param sesion Sesion a la base de datos.
	 * @param persona Identificador  de  la persona.
	 * @param ciclo Ciclo del cliente
	 * @param referencia Datos de la referencia familiar
	 * @throws SQLException 
	 */
	private void registrarTelefono( String uid, SqlSession sesion, String persona,
			String telefono, String lada, String tipo, String origen ) throws SQLException {
		Map<String, Object> 	parametros 	= new HashMap<String, Object>( );
		ResultadoOV				resultado;
			telefono  = telefono.replace("-", "").trim();
			origen = origen == null ? "POCG" : origen;
			origen = origen.equals("") ? "POCG" : origen;

			parametros.put( PERSONA, persona );
			parametros.put( TELEFONO, telefono != null ? telefono : "");
			parametros.put( LADA, lada != null ? lada : ""  );
			parametros.put( TIPO, tipo );
			parametros.put(FECHA_ALTA, new Date());
			parametros.put("origen", origen);

			LogHandler.trace(uid, getClass(), "==> registrarTelefono - " + OPER_REGISTRAR_TELEFONO);
 			resultado = (ResultadoOV) sesion.selectOne(OPER_REGISTRAR_TELEFONO, parametros);

 			if ( resultado.getCodigo().trim().equals("-2") ) {
 				//Ya existe un telefono pero se deja pasar
 			} else {
	 			if ( !resultado.isSuccess( ) )
					throw new SQLException( resultado.getMensaje( ) );
 			}
	}

	/*
	 * (non-Javadoc)
	 * @see tarea.originacion.OriginacionCliente#obtenerClaveCredprod(java.lang.String, java.lang.String)
	 */
	public String obtenerClaveCredprod(String uid, String t24)
		{
		return comun.obtenerPersonaCliente(uid,t24 );
		}
}

