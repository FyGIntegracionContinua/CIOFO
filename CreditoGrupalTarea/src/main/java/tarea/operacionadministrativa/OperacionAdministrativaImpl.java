/**
 * 
 */
package tarea.operacionadministrativa;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.fabric3.api.annotation.Producer;
import org.oasisopen.sca.annotation.Reference;

import tarea.comun.ComunTarea;
import tarea.comun.ReadProperties;
import utilitario.log.LogHandler;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.FechaContableOV;
import utilitario.mensajes.comun.ResultadoOV;
import utilitario.mensajes.condonaciones.comun.CreditoSaldo;
import utilitario.mensajes.operacion.CargaInformacionPeticion;
import utilitario.mensajes.operacion.CargaInformacionRespuesta;
import utilitario.mensajes.operacion.ConsultaInicioOperacionPeticion;
import utilitario.mensajes.operacion.ConsultaInicioOperacionRespuesta;
import utilitario.mensajes.operacion.ContratoPagosLineaOV;
import utilitario.mensajes.operacion.RegistroInicioOperacionPeticion;
import utilitario.mensajes.operacion.RegistroInicioOperacionRespuesta;
import utilitario.mensajes.operacion.administracion.CandadoPeticion;
import utilitario.mensajes.operacion.administracion.DiasPeticion;
import utilitario.mensajes.operacion.administracion.MonitorCIOFRespuesta;
import utilitario.mensajes.operacion.administracion.OperacionAdministrativaRespuesta;
import utilitario.mensajes.operacion.administracion.ReporteCIOFOV;
import utilitario.mensajes.operacion.administracion.SucursalCambiosPeticion;
import utilitario.mensajes.operacion.administracion.SucursalPeticion;
import utilitario.mensajes.operacion.administracion.eventos.CierreFinsol;
import utilitario.mensajes.operacion.cierre.OperacionCierrePeticion;
import utilitario.mensajes.operacion.cierre.OperacionCierreRespuesta;
import utilitario.mensajes.reportes.cierre.eventos.EventoReporteCierre;
import datamapper.DataMapper;
import entidad.asesores.data.AsesorData;
import entidad.conexiones.FabricaConexiones;


/**
 * @author out_mreyes
 *
 */
public 	class 		OperacionAdministrativaImpl 
		implements 	OperacionAdministrativa 
	{
	@Producer
	private CierreFinsol cierreFinsol;
	private ComunTarea comun;
	/**
	 * formatter SimpleDateFormat
	 */
	private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("yyyyMMdd");

	public OperacionAdministrativaImpl(
			@Reference(name = "comun") ComunTarea comun
			) {
	 this.comun = comun;
	}
	/* (non-Javadoc)
	 * @see tarea.operacionadministrativa.OperacionAdministrativa#cambioApoderadoLegal(java.lang.String)
	 */

	public OperacionAdministrativaRespuesta modificarSucursal(SucursalCambiosPeticion peticion, String uid) 
		{
		//Objeto para regresar la respuesta
		final OperacionAdministrativaRespuesta respuesta = new OperacionAdministrativaRespuesta();

		//Objeto para generar la conexion
		SqlSession sesionTx = null;

		//Se realiza la ejecucion
		try	{
			//Se valida que exista la sucursal
			if( peticion.getSucursal() == null )
				{
				throw new Exception( ReadProperties.mensajes.getProp("ciof.error.datos.incompletos") );
				}

			//Si no hay cambios se regresa el resultado
			if( ( peticion.getFechaEscritura() == null  || peticion.getFechaEscritura().trim().equals( "" ) )  && 
				( peticion.getNombreApoderado() == null || peticion.getNombreApoderado().trim().equals( "" ) ) &&
				( peticion.getNombreGerente() == null 	|| peticion.getNombreGerente().trim().equals( "" ) )   &&
				( peticion.getNumeroEscritura() == null || peticion.getNumeroEscritura().trim().equals( "" ) ) &&
				( peticion.getCalle() == null 			|| peticion.getCalle().trim().equals( "" ) )		   &&
				( peticion.getCp() == null 				|| peticion.getCp() == 0 )							   &&
				( peticion.getColonia() == null 		|| peticion.getColonia().trim().equals( "" ) )		   &&
				( peticion.getCiudad() == null 			|| peticion.getCiudad().trim().equals( "" ) )			)
				{
				throw new Exception( "Debe existir al menos un campo para modificar" );
				}

			//Se abre la conexion
			sesionTx = FabricaConexiones.obtenerSesionTx();

			//Se consulta el registro para saber si existe y traer lo que se modifica
			LogHandler.trace(uid, getClass(), "==> modificarSucursal - obtenerDatosSucursal");
			final SucursalCambiosPeticion busquedaResult = (SucursalCambiosPeticion)sesionTx.selectOne( "obtenerDatosSucursal", peticion.getSucursal() );

			//Se determinan los campos para actualizar
			if( peticion.getFechaEscritura() != null  && !peticion.getFechaEscritura().trim().equals( "" ) )
				{	busquedaResult.setFechaEscritura( peticion.getFechaEscritura() );							}

			if( peticion.getNombreApoderado() != null && !peticion.getNombreApoderado().trim().equals( "" ) )
				{	busquedaResult.setNombreApoderado( peticion.getNombreApoderado() );							}

			if( peticion.getNombreGerente() != null && !peticion.getNombreGerente().trim().equals( "" ) )
				{	busquedaResult.setNombreGerente( peticion.getNombreGerente() );								}
			
			if( peticion.getNumeroEscritura() != null && !peticion.getNumeroEscritura().trim().equals( "" ) )
				{	busquedaResult.setNumeroEscritura( peticion.getNumeroEscritura() );							}
			
			if( peticion.getCalle() != null && !peticion.getCalle().trim().equals( "" ) )
				{	busquedaResult.setCalle( peticion.getCalle() );												}
			
			if( peticion.getCp() != null )
				{	busquedaResult.setCp( peticion.getCp() );													}
			
			if( peticion.getColonia() != null && !peticion.getColonia().trim().equals( "" ) )
				{	busquedaResult.setColonia( peticion.getColonia() );											}
			
			if( peticion.getCiudad() != null && !peticion.getCiudad().trim().equals( "" ) )
				{	busquedaResult.setCiudad( peticion.getCiudad() );											}

			//Objeto para el manejo de los par�metros
			final java.util.HashMap<String, Object>
								paramsMap = new HashMap<String, Object>();
								paramsMap.put( "nombreApoderado", busquedaResult.getNombreApoderado()	);
								paramsMap.put( "fechaEscritura"	, busquedaResult.getFechaEscritura()	);
								paramsMap.put( "numeroEscritura", busquedaResult.getNumeroEscritura()	);
								paramsMap.put( "nombreGerente"	, busquedaResult.getNombreGerente()		);
								paramsMap.put( "calle"			, busquedaResult.getCalle()				);
								paramsMap.put( "colonia"		, busquedaResult.getColonia()			);
								paramsMap.put( "cp"				, busquedaResult.getCp()				);
								paramsMap.put( "ciudad"			, busquedaResult.getCiudad()			);
								paramsMap.put( "sucursal"		, peticion.getSucursal()				);

			//Se actualizan los datos
			LogHandler.trace(uid, getClass(), "==> modificarSucursal - updateSucursal");
			sesionTx.update( "updateSucursal", paramsMap );

			//se realiza el commit de la peticion
			sesionTx.commit( true );

			//Se arma la respuesta
			respuesta.getHeader().setEstatus( true );
			}
		catch( java.lang.Exception exception )
			{
			if(sesionTx != null)
				{	sesionTx.rollback( true );		}

			LogHandler.error(uid, getClass(), "Error al actualizar el apoderado: " + exception.getMessage(), exception);
			respuesta.getHeader().setEstatus	( false );
			respuesta.getHeader().setUID		( uid 	);
			respuesta.getHeader().setMensaje	( exception.getMessage() );
			}
		finally
			{
			FabricaConexiones.close( sesionTx );
			}

		return respuesta;
		}

	/* (non-Javadoc)
	 * @see tarea.operacionadministrativa.OperacionAdministrativa#candadoDesembolsos(java.lang.String)
	 */
	public 	OperacionAdministrativaRespuesta candadoDesembolsos(CandadoPeticion peticion, String uid) 
		{
		final OperacionAdministrativaRespuesta regreso = new OperacionAdministrativaRespuesta( );
		SqlSession sesionTx = null;

		try	{
		//Se abre la conexion
			sesionTx = FabricaConexiones.obtenerSesionTx();
		//Se actualizan los datos
			LogHandler.trace(uid, getClass(), "==> asignarDiaFestivo - candadoDesembolsos");
			sesionTx.insert( "insertarFechaDeseada", peticion.getFechaInicial());
			sesionTx.commit( true );
			regreso.getHeader().setMensaje("EXITOSO");
			regreso.getHeader().setEstatus(true);
			regreso.getHeader().setUID(uid);
			}
		catch ( java.lang.Exception exception )
			{
			regreso.getHeader( ).setEstatus(false);
			regreso.getHeader( ).setMensaje( exception.getMessage() );
			regreso.getHeader().setUID(uid);
			sesionTx.rollback();
			LogHandler.error(uid, getClass(), "Error al actualizar los dias de candado: " + exception.getMessage(), exception);
			}
		finally
			{
			FabricaConexiones.close( sesionTx );
			}
		return regreso;
		}

	/*
	 * (non-Javadoc)
	 * @see tarea.operacionadministrativa.OperacionAdministrativa#altaSucursal(utilitario.mensajes.operacion.administracion.SucursalPeticion, java.lang.String)
	 */

	public OperacionAdministrativaRespuesta altaSucursal( SucursalPeticion peticion, String uid)
		{
		LogHandler.info(uid, getClass(), "Entro a altaSucursal ... OK");
		LogHandler.info(uid, getClass(), "Datos de entrada : peticion = " + peticion);

		//Objeto para la respuesta
		final OperacionAdministrativaRespuesta
							operacionAdministrativaRespuesta = new OperacionAdministrativaRespuesta();

		//Sesion para utilizar mybatis
		SqlSession sessionTx = null;

		try {
			sessionTx = FabricaConexiones.obtenerSesionTx();

			//parametros para almacenar la sucursal
			final HashMap<String, Object>
						paramAltaSucursal = new HashMap<String, Object>();
						paramAltaSucursal.put( "sucursal"	 , peticion.getSucursal()		);
						paramAltaSucursal.put( "iva"	 	 , peticion.getIva()			);
						paramAltaSucursal.put( "nombre"	 	 , peticion.getNombreSucursal()	);
						paramAltaSucursal.put( "calle"	 	 , peticion.getCalle()			);
						paramAltaSucursal.put( "colonia" 	 , peticion.getColonia()		);
						paramAltaSucursal.put( "codigoPostal", peticion.getCp()				);
						paramAltaSucursal.put( "ciudad"		 , peticion.getCiudad()			);
						paramAltaSucursal.put( "entidad"	 , peticion.getClaveEstado()	);
						paramAltaSucursal.put( "lada"		 , peticion.getLada()			);
						paramAltaSucursal.put( "telefono1"   , peticion.getTelefono()		);
						paramAltaSucursal.put( "telefono2"   , peticion.getTelefono2()		);
						paramAltaSucursal.put( "telefono3"   , peticion.getTelefono3()		);
						paramAltaSucursal.put( "fax"		 , peticion.getFax()			);
						paramAltaSucursal.put( "region"		 , peticion.getRegion()			);
						paramAltaSucursal.put( "numeroEscritura", peticion.getNumeroEscritura()  );
						paramAltaSucursal.put( "fechaEscritura" , peticion.getFechaEscritura()	 );
						paramAltaSucursal.put( "nombreApoderado", peticion.getNombreApoderado()	 );

			LogHandler.trace(uid, getClass(), "==> altaSucursal - insertarSucursal");
			sessionTx.selectOne( "insertarSucursal", paramAltaSucursal );
			sessionTx.commit( true );
			}
		catch ( java.lang.Exception exception ) {
			LogHandler.error(uid, getClass(), "Error al intentar dar de alta la sucursal: " + exception.getMessage(), exception);
			operacionAdministrativaRespuesta.getHeader().setEstatus( false );
			operacionAdministrativaRespuesta.getHeader().setMensaje( exception.getMessage() );
			operacionAdministrativaRespuesta.getHeader().setUID( uid );
			}
		finally
			{
			FabricaConexiones.close( sessionTx );
			}
		return operacionAdministrativaRespuesta;
		}

	/* (non-Javadoc)
	 * @see tarea.operacionadministrativa.OperacionAdministrativa#asignarDiaFestivo(java.lang.String)
	 */

	public OperacionAdministrativaRespuesta asignarDiaFestivo(DiasPeticion peticion, String uid) {
		final OperacionAdministrativaRespuesta regreso = new OperacionAdministrativaRespuesta( );
		SqlSession sesionTx = null;

		try	{
		//Se abre la conexion
			sesionTx = FabricaConexiones.obtenerSesionTx();

			final java.text.SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyyMMdd");
		//Se actualizan los datos
			LogHandler.trace(uid, getClass(), "==> asignarDiaFestivo - asignacionDiaFestivo");
			sesionTx.insert( "asignacionDiaFestivo", simpleDateFormat.format( peticion.getFecha() ) );
				regreso.getHeader( ).setEstatus( true );
				regreso.getHeader( ).setMensaje("EXITOSO");
				sesionTx.commit( true );
			}
			catch ( java.lang.Exception exception ) {
				regreso.getHeader( ).setEstatus(false);
				regreso.getHeader( ).setMensaje("No se pudo realizar la actualizacion: " + exception.getMessage() );
				regreso.getHeader().setUID(uid);
				if ( sesionTx != null ) {
					sesionTx.rollback();
				}
				LogHandler.error(uid, getClass(), "Error al actualizar los dias inhabiles: " + exception.getMessage(), exception);
			}
			finally	{
				FabricaConexiones.close( sesionTx );
			}
			return regreso;
		}

	/*
	 * (non-Javadoc)
	 * @see tarea.operacionadministrativa.OperacionAdministrativa#ejecutarCierreFinsol(java.lang.String, java.util.Date)
	 */

	public OperacionCierreRespuesta ejecutarCierreFinsol(String uid, Date fechaCierre)	{
		LogHandler.info(uid, getClass(), "Entrando en ejecutarCierreFinsol .. OK");
		LogHandler.info(uid, getClass(), "Datos de entrada [uid = " + uid + ", fechaCierre = " + fechaCierre + "]");

		//Objeto que contiene la respuesta de la operaci�n
		final 	OperacionCierreRespuesta
				operacionCierreRespuesta = new OperacionCierreRespuesta();
				operacionCierreRespuesta.getEncabezadoRespuesta().setEstatus( true );

		//Valor de entrada no sea nulo
		if ( fechaCierre == null ) {
			LogHandler.error(uid, getClass(), "Parametro de entrada incorrecto fechaCierre = " + fechaCierre, null);
			operacionCierreRespuesta.getEncabezadoRespuesta().setEstatus( false );
			operacionCierreRespuesta.getEncabezadoRespuesta().setUID	( uid 	);
			operacionCierreRespuesta.getEncabezadoRespuesta().setMensaje( "Parametro de entrada incorrecto" );
			return operacionCierreRespuesta;
		}

		//Objeto para el llamado de la funcion a base de eventos
		final 	EventoReporteCierre
				eventoReporteCierre = new EventoReporteCierre();
				eventoReporteCierre.setUid(uid);
				eventoReporteCierre.setFechaCierre(fechaCierre);

		//Se genera la peticion asincrona
		cierreFinsol.ejecutarCierre( eventoReporteCierre );

		return operacionCierreRespuesta;
		}

	/*
	 * (non-Javadoc)
	 * @see tarea.operacionadministrativa.OperacionAdministrativa#ejecutarCierreFinsolSinc(java.lang.String, java.util.Date)
	 */
	@SuppressWarnings("unchecked")

	public OperacionCierreRespuesta ejecutarCierreFinsolSinc(String uid, OperacionCierrePeticion peticion) {
		LogHandler.info(uid, getClass(), "Entrando en ejecutarCierreFinsolSinc .. OK");
		LogHandler.info(uid, getClass(), "Datos de entrada [uid = " + uid + ", fechaCierre = " + peticion.getFechaCierre() + "]");

		//Objeto que contiene la respuesta de la operaci�n
			OperacionCierreRespuesta
				operacionCierreRespuesta = new OperacionCierreRespuesta();
				operacionCierreRespuesta.getEncabezadoRespuesta().setEstatus( true );

		//Valor de entrada no sea nulo
		if ( peticion.getFechaCierre() == null ) {
			LogHandler.error(uid, getClass(), "Parametro de entrada incorrecto fechaCierre = " + peticion.getFechaCierre(), null);
			operacionCierreRespuesta.getEncabezadoRespuesta().setEstatus( false );
			operacionCierreRespuesta.getEncabezadoRespuesta().setUID( uid 	);
			operacionCierreRespuesta.getEncabezadoRespuesta().setMensaje( "Parametro de entrada incorrecto" );
			return operacionCierreRespuesta;
			}

		//Objeto para el llamado de la funcion a base de eventos
		final 	EventoReporteCierre
				eventoReporteCierre = new EventoReporteCierre();
				eventoReporteCierre.setUid(uid);
				eventoReporteCierre.setFechaCierre(peticion.getFechaCierre());

		//Objeto para acceso a los datos
		SqlSession sesionNTx = null;
		//SqlSession sesionOrclNTx = null;
		SqlSession sesionBatch = null;

		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			final java.text.SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyyMMdd" );

			//Para formatear la fecha de entrada
			final java.util.Calendar
							calendarEntrance = Calendar.getInstance();
							calendarEntrance.setTime( eventoReporteCierre.getFechaCierre() );
							calendarEntrance.set( Calendar.HOUR , 0);
							calendarEntrance.set( Calendar.MINUTE , 0);
							calendarEntrance.set( Calendar.SECOND , 0);
							calendarEntrance.set( Calendar.MILLISECOND , 0);

			//Se preparan los parametros de entrada
			final java.util.HashMap<String, Object>
											params = new java.util.HashMap<String, Object>();
											params.put( "fecha"	  , dateFormat.format( eventoReporteCierre.getFechaCierre() ) );
											params.put( "sucursal", 0		    );

			//Formateo de fechas
			final SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );

			if ( peticion.isValidaciones()) {
				//Se preparan los parametros de entrada
				final java.util.HashMap<String, Object>
								paramsControl = new java.util.HashMap<String, Object>();
								paramsControl.put( "cve_servicio"  , "DEPOSITOS_GARANTIA" );
								paramsControl.put( "id_proceso_servicio", "CARGA_UNIVERSO_PAGOS");
								paramsControl.put( "fecha_operacion", dateFormat.format( eventoReporteCierre.getFechaCierre()));

				LogHandler.trace(eventoReporteCierre.getUid(), getClass(), "==> ejecutarCierreFinsol - validaControlServicio");
				final java.lang.Integer cargaUniverso
					= (java.lang.Integer) sesionNTx.selectOne( "validaControlServicio", paramsControl );

				if ( cargaUniverso == null || cargaUniverso <= 0 ) {
				throw new Exception( "Error: No existe registro de la carga de pagos deposito garantia ["
						+ dateFormat.format( eventoReporteCierre.getFechaCierre()) + "." );
				}

				paramsControl.clear();
				paramsControl.put( "cve_servicio"  , "DEPOSITOS_GARANTIA" );
				paramsControl.put( "id_proceso_servicio", "APLICACION_INCUMPLIMIENTO");
				paramsControl.put( "fecha_operacion", dateFormat.format( eventoReporteCierre.getFechaCierre()));

				LogHandler.trace(eventoReporteCierre.getUid(), getClass(), "==> ejecutarCierreFinsol - validaControlServicio");
				final java.lang.Integer aplicacionIncumplimiento
					= (java.lang.Integer) sesionNTx.selectOne( "validaControlServicio", paramsControl );

				if ( aplicacionIncumplimiento == null || aplicacionIncumplimiento <= 0 ) {
					throw new Exception( "Error: No existe registro del proceso de aplicacion de garantia por incumplimiento ["
							+ dateFormat.format( eventoReporteCierre.getFechaCierre()) + "." );
				}
				//MIMH 20170104 Comentar para proxima liberacion
				//CARGA CONTRATOS POSTGRES NUBE
				/*
				paramsControl.clear();
				paramsControl.put( "cve_servicio"  , "PAGOS_EN_LINEA" );
				paramsControl.put( "id_proceso_servicio", "CARGA_CONTRATOS");
				paramsControl.put( "fecha_operacion", dateFormat.format( eventoReporteCierre.getFechaCierre()));

				LogHandler.trace(eventoReporteCierre.getUid(), getClass(), "==> ejecutarCierreFinsol - validaControlServicio");
				final java.lang.Integer cargaContratosPostgres
					= (java.lang.Integer) sesionNTx.selectOne( "validaControlServicio", paramsControl );

				if ( cargaContratosPostgres == null || cargaContratosPostgres <= 0 ) {
					throw new Exception( "Error: No existe registro del proceso de carga contratos nube postgres ["
							+ dateFormat.format( eventoReporteCierre.getFechaCierre()) + "." );
				}
				*/
			}
			//Realizar cierre finsol
			sesionBatch = FabricaConexiones.obtenerSesionBatch();
			LogHandler.trace(eventoReporteCierre.getUid(), getClass(), "==> ejecutarCierreFinsol - realizarCierreFinsol");
			final java.util.HashMap<String, Object>
					resultadoCierre = (HashMap<String, Object>) sesionBatch.selectOne( "realizarCierreFinsol",
							simpleDateFormat.format( eventoReporteCierre.getFechaCierre() ) );

			//Validar la ejecucion de la consulta
			if (resultadoCierre == null) {
				throw new Exception( "Error al intentar realizar el cierreFinsol" );
			}

			//Se cargan los resultados
			if ( resultadoCierre.get( "retorno" ).toString().equals( "-1" )) {
				throw new Exception( resultadoCierre.get( "mensaje" ).toString() );
			}

			//Se incluye la parte de RING
			OperacionCierreRespuesta respuesta = new OperacionCierreRespuesta();
			respuesta = ajusteSaldosAFavor(uid);

			operacionCierreRespuesta = respuesta;

			}
		catch ( java.lang.Exception exception ) {
			operacionCierreRespuesta.getEncabezadoRespuesta().setEstatus(false);
			operacionCierreRespuesta.getEncabezadoRespuesta().setMensaje(
					"Error al ejecutar el cierre: " + exception.getMessage());
			operacionCierreRespuesta.getEncabezadoRespuesta().setCodigo(uid);
			LogHandler.error( eventoReporteCierre.getUid(), getClass(), exception.getMessage(), exception );
			}
		finally {
			FabricaConexiones.close( sesionNTx 	   );
			//FabricaConexiones.close( sesionOrclNTx );
			FabricaConexiones.close( sesionBatch   );
			}

		return operacionCierreRespuesta;
		}

	/*
	 * (non-Javadoc)
	 * @see tarea.operacionadministrativa.OperacionAdministrativa#monitorearCIOF(java.lang.String)
	 */
	
	public MonitorCIOFRespuesta monitorearCIOF(String uid) 
		{
		final MonitorCIOFRespuesta respuesta = new MonitorCIOFRespuesta( );
		
		try	{
			//Objeto con el reporte del estado de CIOF
			final ReporteCIOFOV reporteCIOFOV = new ReporteCIOFOV();
			
			LogHandler.desactivarLog();
			
			/*Conexiones Sybase*/
			//No transaccional
			try	{
				final SqlSession sessionNTx = FabricaConexiones.obtenerSesionNTx();
				reporteCIOFOV.setConexionSybaseNTx( "Conexion exitosa." );
				FabricaConexiones.close( sessionNTx );
				}
			catch( java.lang.Exception exception )
				{
				reporteCIOFOV.setConexionSybaseNTx( "Error en la conexi�n." );
				LogHandler.error(uid, getClass(), "Fallo la conexi�n NTx-Sybase", exception );
				}
			
			//Transaccional
			try	{
				final SqlSession sessionTx = FabricaConexiones.obtenerSesionNTx();
				reporteCIOFOV.setConexionSybaseTx( "Conexion exitosa." );
				FabricaConexiones.close( sessionTx );
				}
			catch( java.lang.Exception exception )
				{
				reporteCIOFOV.setConexionSybaseTx( "Error en la conexi�n." );
				LogHandler.error(uid, getClass(), "Fallo la conexi�n Tx-Sybase", exception );
				}
			
			//Batch
			try	{
				final SqlSession sessionBatch = FabricaConexiones.obtenerSesionNTx();
				reporteCIOFOV.setConexionSybaseBatch( "Conexion exitosa." );
				FabricaConexiones.close( sessionBatch );
				}
			catch( java.lang.Exception exception )
				{
				reporteCIOFOV.setConexionSybaseBatch( "Error en la conexi�n." );
				LogHandler.error(uid, getClass(), "Fallo la conexi�n Batch-Sybase", exception );
				}
			
			//Host Sybase
			reporteCIOFOV.setHostSybase( FabricaConexiones.hostSybase() );
			
			/*Conexiones Oracle*/
			//No transaccional
			try {				
				reporteCIOFOV.setConexionOracle( "Conexion exitosa." );			
				}
			catch( java.lang.Exception exception )
				{
				reporteCIOFOV.setConexionOracle( "Error en la conexi�n." );
				LogHandler.error(uid, getClass(), "Fallo la conexi�n NTx-Oracle", exception );
				}
			
			//Host Oracle
			reporteCIOFOV.setHostOracle( FabricaConexiones.hostOracle() );
			
			/*Catalogos*/
			//Estados
			if( DataMapper.getNumeroEntidades() == null || DataMapper.getNumeroEntidades() == 0 )
				{
				reporteCIOFOV.setEntidades( "Error en el mapper de Entidades Federativas, numero de estados : " + DataMapper.getNumeroEntidades() );
				LogHandler.error(uid, getClass(), "Error en el mapper de Entidades Federativas.", new Exception( "Error en el mapper de Entidades Federativas." ));
				}
			else
				{
				reporteCIOFOV.setEntidades( "Entidades cargadas : " + DataMapper.getNumeroEntidades() );
				}
			
			//Asesores
			if( AsesorData.getNumeroAsesores() == null || AsesorData.getNumeroAsesores() == 0 )
				{
				reporteCIOFOV.setAsesores( "Error en el mapper de Asesores, numero de asesores : " + AsesorData.getNumeroAsesores() );
				LogHandler.error(uid, getClass(), "Error en el mapper de Asesores.", new Exception( "Error en el mapper de Asesores." ));
				}
			else
				{
				reporteCIOFOV.setAsesores( "Asesores cargados : " + AsesorData.getNumeroAsesores() );
				}
			
			/*Datos del sistema*/
			//Version CIOF
			reporteCIOFOV.setVersion( "1.22.0" );
			
			//Memoria libre del sisteman en Mega Bytes
			reporteCIOFOV.setMemoriaLibre( "" + ( ( ( new java.io.File( "/" ) ).getFreeSpace() / 1024.0 ) / 1024.0 ) + " MB" );
			
			//Host
			reporteCIOFOV.setHost( java.net.InetAddress.getLocalHost().getHostAddress() );
			
			respuesta.setReporte( reporteCIOFOV );
			respuesta.getHeader().setEstatus( true );
			}
		catch( java.lang.Exception exception )
			{
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setMensaje( "No se puede monitorear : ERROR - " + exception.getMessage() );
			respuesta.getHeader().setUID	( uid );
			LogHandler.error(uid, getClass(), "Error al monitorearCIOF:" + exception.getMessage(), exception);
			}
		return respuesta;
		}
	
	@SuppressWarnings("unchecked")
	public OperacionCierreRespuesta ajusteSaldosAFavor(String uid) {
		  
		  final OperacionCierreRespuesta operacionCierreRespuesta = new OperacionCierreRespuesta();
		  operacionCierreRespuesta.getEncabezadoRespuesta().setEstatus( true );
		  
		  LogHandler.info(uid, getClass(), "Entrando en ajusteSaldosAFavor...");
		  
		  SqlSession sessionNTx = null;
		  SqlSession sessionTx = null;
		  FechaContableOV fechaContable = null;
		  try
		  {
		    sessionNTx = FabricaConexiones.obtenerSesionNTx();		  
		    fechaContable = comun.obtenerFechaContable(uid);
		  
		    HashMap<String, Object> paramsValorHistorico = new HashMap<String, Object>();
		    
		    paramsValorHistorico.put("sucursal", 0);
		    paramsValorHistorico.put("codigo", "MISF");
		    paramsValorHistorico.put("fecha", new Date());
		    Integer monto = 0;
		    
			LogHandler.trace(uid, getClass(), "==> ajusteSaldosAFavor - verValorHistorico " );
			monto = (Integer) sessionNTx.selectOne("verValorHistorico", paramsValorHistorico);
			monto = monto * -1;
			
			LogHandler.info(uid, getClass(), "Valor MISF [" + monto +"]");
			
		    java.util.HashMap<String ,Object> params = new java.util.HashMap<String ,Object>();		    
		    params.put("monto", monto );
						
			LogHandler.trace(uid, getClass(), "==> ajusteSaldosAFavor - universoSaldosAFavor" );
			
			final java.util.ArrayList<java.util.HashMap<String ,Object>> 
									creditosSaldoAFavor = ( ArrayList<java.util.HashMap<String ,Object>> )sessionNTx.selectList( "universoSaldosAFavor" , params );
			
			LogHandler.info(uid, getClass(), "Total creditos con saldo a favor [" + creditosSaldoAFavor.size() +"]");
			
			for( java.util.HashMap<String ,Object> credito : creditosSaldoAFavor )
			{				
				try
				{
					sessionTx = FabricaConexiones.obtenerSesionTx();
					
					
					HashMap<String, Object> paramsInsert = new HashMap<String, Object>();
					paramsInsert.put("contrato", credito.get("contrato"));
					paramsInsert.put("sucursal", credito.get("sucursal"));
					paramsInsert.put("monto", credito.get("saldoFavor"));
					paramsInsert.put("no_ult_pago", credito.get("no_ult_pago"));
					paramsInsert.put("fechaContable", new SimpleDateFormat("yyyy-MM-dd").format( fechaContable.getFecha() ) );
					
					LogHandler.trace(uid, getClass(), "==> ajusteSaldosAFavor - insertMovimientoRING" );					
					int resultInsert = sessionTx.insert("insertMovimientoRING", paramsInsert);
					
					if(resultInsert < 1)
						throw new Exception("No se pudo realizar el insert del movimiento RING.");
					
					int resultUpdate = sessionTx.update( "actualizarMontoCapital", paramsInsert);
					
					if(resultUpdate < 1)
						throw new Exception("No se pudo realizar el update del movimiento RING.");
																								
					sessionTx.commit();
				}
				catch (Exception ex) {
					FabricaConexiones.rollBack( sessionTx );
					LogHandler.error( uid , getClass(), ex.getMessage(), ex );
				}
				
			}
		  		  
		  }
		  
		  catch( java.lang.Exception exception )
		  {
			operacionCierreRespuesta.getEncabezadoRespuesta().setEstatus(false);
			operacionCierreRespuesta.getEncabezadoRespuesta().setMensaje( "Error al ejecutar el cierre: " + exception.getMessage());
			operacionCierreRespuesta.getEncabezadoRespuesta().setCodigo(uid);
			operacionCierreRespuesta.getEncabezadoRespuesta().setUID(uid);
			LogHandler.error( uid , getClass(), exception.getMessage(), exception );
		  }		  
		  finally {
				 FabricaConexiones.close(sessionNTx);
				 FabricaConexiones.close(sessionTx);
			  }
		  return operacionCierreRespuesta;
		  
    }
	  

	@SuppressWarnings("unchecked")
	public RegistroInicioOperacionRespuesta registraInicioOperacion(String uid,RegistroInicioOperacionPeticion peticion ) {
	
		RegistroInicioOperacionRespuesta respuesta = new RegistroInicioOperacionRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);
		
		SqlSession sessionNTx = null;
		SqlSession sesionTX = null;
		FechaContableOV fechaContable = null;
		  try
		  {
			sessionNTx = FabricaConexiones.obtenerSesionNTx();	
			sesionTX = FabricaConexiones.obtenerSesionTx();
		    fechaContable = comun.obtenerFechaContable(uid);
		    		   
		    	
		    if( peticion.getSucursal() == null || peticion.getSucursal() == 0 || peticion.getSucursal() == 120 )
			{
		    	throw new Exception("La peticion debe contener una sucursal valida.");
			}
		    
		    
		    if(peticion.getRegistro() == null) {
		    	throw new Exception("La peticion debe contener un valor en tipo de operacion valido.");
		    }
		    
		    if(peticion.getUsuario() == null || peticion.getUsuario().equals("") ) {
		    	throw new Exception("La peticion debe contener un usuario valido.");
		    }
		    

		    SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		    		    		    
		    HashMap<String, Object> params = new HashMap<String, Object>();
		    params.put("fechaContable", formatter.format(fechaContable.getFecha()) );
		    params.put("sucursal",  peticion.getSucursal() );
		    params.put("usuario", peticion.getUsuario() );
		    params.put("fechaInicio", formatter.format(fechaContable.getFecha()));
			params.put("fechaFin", formatter.format(fechaContable.getFecha()));
		    
		    if(peticion.getRegistro()) {
		    	
		    	ResultadoOV aperturaCaja = comun.aperturaCaja(uid, peticion.getSucursal(), fechaContable.getFecha());
		    	
		    	if ( aperturaCaja.getCodigoRetorno() < 0 )
				{
				throw new Exception ( ReadProperties.mensajes.getProp("ciof.error.cajavirtual"));
				}
		    			    	
				LogHandler.trace(uid, getClass(), "==> registraInicioOperacion - actualizaUsuarioInicioOperacion");
				sesionTX.update("actualizaUsuarioInicioOperacion", params);		    	
		    	
		    }
		    		    
		    sesionTX.commit(true);		    
		    		    
		    LogHandler.trace(uid, getClass(), "==> registraInicioOperacion - consultaInicioOperaciones" );
		    HashMap<String, Object> fechaInicioOperacion = (HashMap<String, Object>) sessionNTx.selectOne("consultaInicioOperacion", params);
		    		    		    
		    respuesta.setFechaContable(fechaContable.getFecha());
		    respuesta.setFechaInicioOperacion(fechaInicioOperacion == null ? null : (java.util.Date)fechaInicioOperacion.get("fechaInicioOperacion"));		    
			respuesta.setUsuario(fechaInicioOperacion == null ? "" : fechaInicioOperacion.get("usuario").toString());
			respuesta.setNombreSucursal(fechaInicioOperacion == null ? "" :fechaInicioOperacion.get("nombreSucursal").toString());
			respuesta.setSucursal(fechaInicioOperacion == null ? 0 : (Integer)fechaInicioOperacion.get("sucursal"));

		  }
		  catch( java.lang.Exception exception )
		  {
			  respuesta.getHeader().setEstatus(false);
			  respuesta.getHeader().setMensaje( "Error al ejecutar al registraInicioOperacion: " + exception.getMessage());
			  respuesta.getHeader().setCodigo(uid);
			  LogHandler.error( uid , getClass(), exception.getMessage(), exception );
		  }
		  finally {
				 FabricaConexiones.close(sessionNTx);
				 FabricaConexiones.close(sesionTX);
		  }

		return respuesta;
	}

	@SuppressWarnings("unchecked")
	public ConsultaInicioOperacionRespuesta consultaInicioOperacion(String uid,ConsultaInicioOperacionPeticion peticion ) {
		ConsultaInicioOperacionRespuesta respuesta = new ConsultaInicioOperacionRespuesta();

		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);

		SqlSession sessionNTx = null;

		 try
		  {
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			if ( peticion.getSucursal() == null || peticion.getSucursal() == 0 || peticion.getSucursal() == 120 ) {
					peticion.setSucursal( 0 );
			}
			java.util.HashMap<String, Object> params = new java.util.HashMap<String, Object>();
			params.put("sucursal", peticion.getSucursal() != null ? peticion.getSucursal() : 0);
			params.put("fechaInicio", peticion.getFechaInicio());
			params.put("fechaFin", peticion.getFechaFin());
			LogHandler.trace(uid, getClass(), "==> consultaInicioOperacion - consultaInicioOperacion" );
			final java.util.ArrayList<HashMap<String,Object>> registros = ( ArrayList<HashMap<String,Object>>) sessionNTx.selectList( "consultaInicioOperacion" , params );				

			//Se valida que la consulta arroje algun resultado
			if ( registros == null || registros.isEmpty() ) {
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.consultas.registrosvacios" ) );
			}

			final java.util.ArrayList<RegistroInicioOperacionRespuesta> registrosRespuesta = new ArrayList<RegistroInicioOperacionRespuesta>();

			for ( HashMap<String, Object> registro : registros ) {
				RegistroInicioOperacionRespuesta registroInicio = new RegistroInicioOperacionRespuesta();
				registroInicio.setFechaContable((java.util.Date) registro.get("fechaContable"));
				registroInicio.setFechaInicioOperacion((java.util.Date) registro.get("fechaInicioOperacion"));
				registroInicio.setUsuario(registro.get("usuario").toString());
				registroInicio.setNombreSucursal(registro.get("nombreSucursal").toString());
				registroInicio.setSucursal((Integer) registro.get("sucursal"));
				registrosRespuesta.add(registroInicio);
			}

			//Se asignan los resultados
			respuesta.setRegistros(registrosRespuesta);

		  }
		 catch ( java.lang.Exception exception )
		  {
			  respuesta.getHeader().setEstatus(false);
			  respuesta.getHeader().setMensaje( "Error al ejecutar al consultaInicioOperacion: " + exception.getMessage());
			  respuesta.getHeader().setCodigo(uid);
			  LogHandler.error( uid , getClass(), exception.getMessage(), exception );
		  }
		 finally {
			 FabricaConexiones.close(sessionNTx);
		 }
		return respuesta;
	}

	/**
	 * Activar Log Completo CIOF
	 * @return resultado operacion
	*/
	public boolean activarLog() {
		LogHandler.activarLog();
		 LogHandler.info( "NO UID" , getClass(), "Log activado." );
		return true;
	}
	/**
	 * Desctivar Log Completo CIOF
	 * @return resultado operacion
	*/
	public boolean desactivarLog() {
		LogHandler.info( "NO UID" , getClass(), "Log desactivado." );
		LogHandler.desactivarLog();
		return true;
	}

	/**
	 * Activar Log Completo de consultas a la BD
	 * @return resultado operacion
	 */
    public boolean activarLogSQL() {
		LogHandler.activarLogSQL();
		LogHandler.info( "NO UID" , getClass(), "Log activado SQL." );
		return true;
    }

    /**
	 * Desactivar Log Completo de consultas a la BD
	 * @return resultado operacion
	 */
	public boolean desactivarLogSQL() {
		LogHandler.info( "NO UID" , getClass(), "Log desactivado SQL." );
		LogHandler.desactivarLogSQL();
		return true;
	}

	/**
	 * Metodo para cargar la informacion de los contratos en la nube
	 * @param uid Identificador unico de la transaccion
	 * @param peticion del cierre
	 * @return Respuesta de la carga
	 */
	@SuppressWarnings("unchecked")
	public CargaInformacionRespuesta cargarContratosPagosEnLinea(String uid, CargaInformacionPeticion peticion) {
		CargaInformacionRespuesta respuesta = new CargaInformacionRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);

		SqlSession sessionNTx = null;
		SqlSession sessionTx = null;
		SqlSession sessionSybase = null;
		SqlSession sessionSybaseTx = null;
		 try
		  {
			//Conexion Sybase
			sessionSybase = FabricaConexiones.obtenerSesionNTx();
			sessionSybaseTx = FabricaConexiones.obtenerSesionTx();
			//Conexion Postgres
			sessionNTx = FabricaConexiones.obtenerSesionPostgresNTx();
			sessionTx = FabricaConexiones.obtenerSesionPostgresTx();
			FechaContableOV fechaContable = null;
			fechaContable = comun.obtenerFechaContable(uid);
			List<ContratoPagosLineaOV> contratos = new ArrayList<ContratoPagosLineaOV>();
			java.util.HashMap<String , Object> params = new java.util.HashMap<String, Object>();
			params.put("fechaActual", FORMATTER.format(fechaContable.getFecha().getTime()));

			java.util.HashMap<String , Object> paramsControl = new java.util.HashMap<String, Object>();
			paramsControl.put("fechaOperacion", FORMATTER.format(fechaContable.getFecha().getTime()));
			paramsControl.put("cveServicio", "PAGOS_EN_LINEA");
			paramsControl.put("idProceso", "CARGA_CONTRATOS");
			sessionSybaseTx.insert("insertControlServicio", paramsControl);
			LogHandler.info( uid , getClass(), "idRegistro= "  + paramsControl.get("idRegistro"));

			if ( peticion.isCargaInicial() ) {
				params.put("fechaInicio", peticion.getFechaInicio());
				params.put("fechaFin", peticion.getFechaFin());
				contratos = (List<ContratoPagosLineaOV>) sessionSybase.selectList(
						"consultaInicialContratosCargaPagosEnLinea", params);
			} else {
				contratos = (List<ContratoPagosLineaOV>) sessionSybase.selectList("consultaContratosCargaPagosEnLinea", params);
			}
			//Carga de contratos a Postgres
			for (ContratoPagosLineaOV registro : contratos ) {
				LogHandler.info( uid , getClass(), "Contrato... "  + registro);
				if (registro.getNoPago() > registro.getNoPagos()) {
					registro.setNoPago(registro.getNoPagos());
				}
				params.put( "contrato"   , registro.getContrato() );
				final CreditoSaldo creditoSaldo = (CreditoSaldo) sessionSybase.selectOne( "obtenerSaldoFv", params );
				registro.setMontoCorriente(creditoSaldo.getMontoCorriente());
				registro.setMontoTotal(creditoSaldo.getSaldoLiquidar());
				registro.setCapitalInsoluto(creditoSaldo.getInsoluto());
				registro.setSaldoLiquidar(creditoSaldo.getSaldoLiquidar());
				registro.setMontoPagoAtrasado(creditoSaldo.getMontoPagoAtrasado());
				int existe = (Integer) sessionNTx.selectOne("existeContratoPostgres", registro.getContrato());
				if (existe == 0) {
					sessionTx.insert("insertaContratoPostgres", registro);
				} else {
					sessionTx.update("actualizaContratoPostgres", registro);
				}
				sessionTx.commit(true);
			}

			sessionSybaseTx.insert("actualizaControlServicioFin", paramsControl);
			sessionSybaseTx.commit(true);
		  }
		 catch (java.lang.Exception exception ) {
			  FabricaConexiones.rollBack(sessionTx);
			  FabricaConexiones.rollBack(sessionSybaseTx);
			  respuesta.getHeader().setEstatus(false);
			  respuesta.getHeader().setMensaje( "Error al ejecutar al consultaInicioOperacion: " + exception.getMessage());
			  respuesta.getHeader().setCodigo(uid);
			  LogHandler.error( uid , getClass(), exception.getMessage(), exception );
		  }
		 finally {
			 FabricaConexiones.close(sessionNTx);
			 FabricaConexiones.close(sessionTx);
			 FabricaConexiones.close(sessionSybase);
			 FabricaConexiones.close(sessionSybaseTx);
		 }
		return respuesta;
	}
}
