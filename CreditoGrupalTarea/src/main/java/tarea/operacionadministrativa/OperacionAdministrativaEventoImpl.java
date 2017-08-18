/**
 * 
 */
package tarea.operacionadministrativa;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.fabric3.api.annotation.Consumer;

import tarea.comun.ReadProperties;
import utilitario.log.LogHandler;
import utilitario.mensajes.reportes.cierre.eventos.EventoReporteCierre;
import entidad.conexiones.FabricaConexiones;

/**
 * @author out_mreyes
 *
 */
public 	class 		OperacionAdministrativaEventoImpl 
		implements	OperacionAdministrativaEvento 
	{
	
	@SuppressWarnings("unchecked")
	@Consumer("cierreFinsol")
	public void ejecutarCierre(EventoReporteCierre evento) 
		{
		LogHandler.info(evento.getUid(), getClass(), "Entrando en ejecutarCierre asincronamente .. OK");
		LogHandler.info(evento.getUid(), getClass(), "Datos de entrada evento = " + evento );
		
		//Objeto para acceso a los datos
		SqlSession sesionNTx = null;		
		SqlSession sesionBatch = null;
		
		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			
			final java.text.SimpleDateFormat dateFormat = new SimpleDateFormat( "yyyyMMdd" );
			
			//Para formatear la fecha de entrada
			final java.util.Calendar 
							calendarEntrance = Calendar.getInstance();
							calendarEntrance.setTime( evento.getFechaCierre() );
							calendarEntrance.set( Calendar.HOUR , 0);
							calendarEntrance.set( Calendar.MINUTE , 0);
							calendarEntrance.set( Calendar.SECOND , 0);
							calendarEntrance.set( Calendar.MILLISECOND , 0);			
			
			//Se preparan los parametros de entrada
			final java.util.HashMap<String, Object> 
											params = new java.util.HashMap<String, Object>();
											params.put( "fecha"	  , dateFormat.format( evento.getFechaCierre() ) );
											params.put( "sucursal", 0		    );
			
			//Validar fecha cierre
			LogHandler.trace(evento.getUid(), getClass(), "==> ejecutarCierreFinsol - verificaDiaNoHabDom");
			final java.lang.Integer fechaValida = (java.lang.Integer)sesionNTx.selectOne( "verificaDiaNoHabDom", params );
			
			if( fechaValida == 0)//1 significa que salio true en la verificación, de que no es un dia habil
				{			
				
				//Formato para la fecha
				//final SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );
				
				//Se comprueba que si existan registros
				LogHandler.trace(evento.getUid(), getClass(), "==> ejecutarCierreFinsol - obtenerRegistrosPreimportados");
				//final java.lang.Integer registros = (Integer)sesionOrclNTx.selectOne( "obtenerRegistrosPreimportados",  calendarEntrance.getTime() );
				final java.lang.Integer registros = 1;
				if( registros == null || registros <= 0 )
					{
					throw new Exception( ReadProperties.mensajes.getProp("operacionadministrativa.errofaltapagos") );
					}				
				//Se comprueba que si existan registros pendientes por aplicar
				LogHandler.trace(evento.getUid(), getClass(), "==> ejecutarCierreFinsol - obtenerRegistrosPendientes");
				//final java.lang.Integer registrosPendientes = (Integer)sesionOrclNTx.selectOne( "obtenerRegistrosPendientes",calendarEntrance.getTime() );
				final java.lang.Integer registrosPendientes = 0;
				if( registrosPendientes != null && registrosPendientes > 0 )
					{
					throw new Exception( ReadProperties.mensajes.getProp("operacionadministrativa.errofaltapagospendientes") ); 
					}
				}
			
			//Realizar cierre finsol
			sesionBatch = FabricaConexiones.obtenerSesionBatch();
			LogHandler.trace(evento.getUid(), getClass(), "==> ejecutarCierreFinsol - realizarCierreFinsol");
			final java.util.HashMap<String, Object> 
									resultadoCierre = (HashMap<String, Object>)sesionBatch.selectOne( "realizarCierreFinsol", evento.getFechaCierre() );
			
			//Validar la ejecucion de la consulta
			if(resultadoCierre == null)
				{
				throw new Exception( ReadProperties.mensajes.getProp("ciof.error.cierre") );
				}
			
			//Se cargan los resultados
			if( resultadoCierre.get( "retorno" ).toString().equals( "-1" ))
				{
				throw new Exception( resultadoCierre.get( "mensaje" ).toString() );
				}
			}
		catch( java.lang.Exception exception )
			{
			LogHandler.error( evento.getUid(), getClass(), exception.getMessage(), exception );			
			}
		finally
			{
			FabricaConexiones.close( sesionNTx 	   );			
			FabricaConexiones.close( sesionBatch   );
			}
		}

	}
