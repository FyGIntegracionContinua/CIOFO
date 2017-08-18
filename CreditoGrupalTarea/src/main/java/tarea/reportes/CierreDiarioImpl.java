/**
 * 
 */
package tarea.reportes;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.fabric3.api.annotation.Consumer;
import org.osoa.sca.annotations.Reference;

import tarea.comun.ComunTarea;
import tarea.comun.ReadProperties;
import tarea.reportes.cierre.GeneradorReportesCSV;
import tarea.transferir.TransferenciaDatosFtp;
import utilitario.log.LogHandler;
import utilitario.mensajes.reportes.cierre.CarteraActivaOV;
import utilitario.mensajes.reportes.cierre.ContratosActivosMoraOV;
import utilitario.mensajes.reportes.cierre.ContratosActivosSaldoFavorOV;
import utilitario.mensajes.reportes.cierre.DesembolsoOpenContractOV;
import utilitario.mensajes.reportes.cierre.DesembolsoRepaymentsOV;
import utilitario.mensajes.reportes.cierre.DesembolsoSEFinsol1OV;
import utilitario.mensajes.reportes.cierre.DesembolsoSEFinsol2OV;
import utilitario.mensajes.reportes.cierre.TiposReporteCierre;
import utilitario.mensajes.reportes.cierre.eventos.EventoReporteCierre;
import entidad.conexiones.FabricaConexiones;

/**
 * @author Juan Carlos Moreno
 *
 */
public class CierreDiarioImpl implements CierreDiario {

	private ComunTarea comun;
	private GeneradorReportesCSV generadorReportes;
	private TransferenciaDatosFtp transferenciaDatosFtp;

	//private static  String RUTA_ARCHIVO = "C:\\Users\\out_lmendez\\Documents\\reportes\\";
	//private static  String RUTA_ARCHIVO = "C:\\";
	private static  String RUTA_ARCHIVO = ReadProperties.reportes.getProp( "reportes.ruta.local" ); //"/home/ciof_des/CIOF/";
	private static java.lang.String RUTA_REMOTA = ReadProperties.reportes.getProp( "reportes.ruta.remota" );//"/home/downloads/reportesCierre/";

	/**
	 * Constructor
	 */
	public CierreDiarioImpl( @Reference(name ="comun") ComunTarea comun,
							 @Reference( name = "generadorReportes") GeneradorReportesCSV reportes,
			 				 @Reference( name = "transferenciaDatosFtp") TransferenciaDatosFtp transferenciaDatosFtp) {

		this.generadorReportes = reportes; //se crea una instancia de mi helper para generar mi reporte en excel
		this.transferenciaDatosFtp = transferenciaDatosFtp;
		this.comun = comun;

	}


	public Integer calculaTotalRegistros(String uid, EventoReporteCierre eventoReporte ) {
		SqlSession sesionBatch 	= null; //inicia sesion para efectuar un query en iBatis
		Integer total  			= null;
		Date fechaCierre	 	= null;
		try {
			fechaCierre  = eventoReporte.getFechaCierre();
			LogHandler.debug( uid, getClass(), "FechaCierre: " + fechaCierre);
			sesionBatch = FabricaConexiones.obtenerSesionBatch();
			if (eventoReporte.getTipoReporte().equals( TiposReporteCierre.CARTERA_ACTIVA ) )
				{
				//Parametros de entrada
				final java.util.Date 	 fechaContable = comun.obtenerFechaContable( uid ).getFecha();
				final java.util.Calendar
								calendarInicio = java.util.Calendar.getInstance();
								calendarInicio.setTime( fechaContable );
								calendarInicio.set( Calendar.DAY_OF_MONTH , 1 );

				final java.util.Calendar
								calendarFin = java.util.Calendar.getInstance();
								calendarFin.setTime( fechaContable );
								calendarFin.add( Calendar.MONTH , 1 );
								calendarFin.set( Calendar.DAY_OF_MONTH , 1 );
								calendarFin.add( Calendar.DAY_OF_MONTH , -1 );

				final java.util.HashMap<String, String>
												params = new HashMap<String, String>();
												params.put( "fechaInicial", SDF.format( fechaCierre ));
												params.put( "fechaInicio" , SDF.format( calendarInicio.getTime() ));
												params.put( "fechaFin" ,    SDF.format( calendarFin.getTime() ));

				LogHandler.trace(uid, getClass(), "==>calculaTotalRegistros - "
				+ OPER_OBTER_TOTAL_REGISTROS_REPORTE_CARTERA_ACTIVA);
				total = (Integer) sesionBatch.selectOne(OPER_OBTER_TOTAL_REGISTROS_REPORTE_CARTERA_ACTIVA , params);
				if ( total == null )
					throw new Exception("ERROR AL OBTENER EL TOTAL DE REGISTROS DEL REPORTE CARTERA ACTIVA.");
				}
			else if ( eventoReporte.getTipoReporte().equals(TiposReporteCierre.CONTRATOS_ACTIVOS_CON_MORA ) ) {
 				LogHandler.trace(uid, getClass(), "==>calculaTotalRegistros - " + OPER_OBTER_TOTAL_REGISTROS_REPORTE_CON_MORA);
				total = (Integer)
						sesionBatch.selectOne(OPER_OBTER_TOTAL_REGISTROS_REPORTE_CON_MORA , SDF.format( fechaCierre ) );
				if ( total == null )
					throw new Exception("ERROR AL OBTENER EL TOTAL DE REGISTROS DEL REPORTE CONTRATOS ACTIVOS CON MORA.");
 			} else if ( eventoReporte.getTipoReporte().equals(TiposReporteCierre.CONTRATOS_ACTIVOS_SALDO_FAVOR ) ) {
				//Hacer el count del total de registros
 				LogHandler.trace(uid, getClass(), "==>calculaTotalRegistros - " + OPER_OBTER_TOTAL_REGISTROS_REPORTE_SALDO_FAVOR);
				total = (Integer)
						sesionBatch.selectOne(OPER_OBTER_TOTAL_REGISTROS_REPORTE_SALDO_FAVOR , SDF.format( fechaCierre ));
				if ( total == null )
					throw new Exception("ERROR AL OBTENER EL TOTAL DE REGISTROS DEL REPORTE CONTRATOS ACTIVOS CON SALDO FAVOR.");
			} else if ( eventoReporte.getTipoReporte().equals(TiposReporteCierre.DESEMBOLSO_OPEN_CONTRACT ) ) {
				//Hacer el count del total de registros
				LogHandler.trace(uid, getClass(), "==>calculaTotalRegistros - "
				+ OPER_OBTER_TOTAL_REGISTROS_REPORTE_DESEMBOLSO_OPEN_CONTRACT);
				total = (Integer)
						sesionBatch.selectOne(OPER_OBTER_TOTAL_REGISTROS_REPORTE_DESEMBOLSO_OPEN_CONTRACT
								, SDF.format( fechaCierre ));
				if ( total == null )
					{
					 throw new Exception("ERROR AL OBTENER EL TOTAL DE REGISTROS DEL REPORTE DESEMBOLSO OPEN CONTRACT.");
					 }
			} else if (eventoReporte.getTipoReporte().equals(TiposReporteCierre.DESEMBOLSO_REPAYMENTS ) ) {
				//Hacer el count del total de registros
				LogHandler.trace(uid, getClass(), "==>calculaTotalRegistros - "
				+ OPER_OBTER_TOTAL_REGISTROS_REPORTE_DESEMBOLSO_REPAYMENTS);
				total = (Integer) sesionBatch.selectOne(OPER_OBTER_TOTAL_REGISTROS_REPORTE_DESEMBOLSO_REPAYMENTS
						, SDF.format( fechaCierre ) );
				if ( total == null )
					throw new Exception("ERROR AL OBTENER EL TOTAL DE REGISTROS DEL REPORTE DESEMBOLSO REPAYMENTS.");
			} else if ( eventoReporte.getTipoReporte().equals(TiposReporteCierre.DESEMBOLOS_SE_FINSOL1 ) ) {
				//Hacer el count del total de registros
				LogHandler.trace(uid, getClass(), "==>calculaTotalRegistros - "
				+ OPER_OBTER_TOTAL_REGISTROS_REPORTE_DESEMBOLSO_SE_FINSOL1);
				total = (Integer) sesionBatch.selectOne( OPER_OBTER_TOTAL_REGISTROS_REPORTE_DESEMBOLSO_SE_FINSOL1
						, SDF.format( fechaCierre ) );
				if ( total == null )
					throw new Exception("ERROR AL OBTENER EL TOTAL DE REGISTROS DEL REPORTE DESEMBOLSO SE_FINSOL1.");
			} else if ( eventoReporte.getTipoReporte().equals(TiposReporteCierre.DESEMBOLOS_SE_FINSOL2) ) {
				//Hacer el count del total de registros
				LogHandler.trace(uid, getClass(), "==>calculaTotalRegistros - "
				+ OPER_OBTER_TOTAL_REGISTROS_REPORTE_DESEMBOLSO_SE_FINSOL2);
				total = (Integer) sesionBatch.selectOne( OPER_OBTER_TOTAL_REGISTROS_REPORTE_DESEMBOLSO_SE_FINSOL2
						, SDF.format( fechaCierre ) );
			}

 		} catch (Exception e) {
			//e.printStackTrace();
 			LogHandler.error(uid, getClass(), e.getMessage(), e);
		}
 		finally {
 			FabricaConexiones.close(sesionBatch);
 		}
		return total;
 	}

	/**
	 *
	 */

	@Consumer("reportesCierre")
	public void generaReporteCierre( EventoReporteCierre eventoReporte ) {
		boolean procesado 	= true;
		String uid 			= eventoReporte.getUid();
		LogHandler.debug(uid, getClass(), "112 Entro a generaReporteCierre asincro" );
		try {

			if ( eventoReporte != null && eventoReporte.getTipoReporte().equals( TiposReporteCierre.CARTERA_ACTIVA ) ) {
				procesado = generaReporteCarteraActiva(uid, eventoReporte.getFechaCierre(), eventoReporte.getTotalRegistros() );
				LogHandler.info( uid, getClass(), procesado ? "Se genero correctamente el Reporte CARTERA_ACTIVA"
						: "No se genero correctamente el Reporte CARTERA_ACTIVA" );
			} else if ( eventoReporte != null
					&&  eventoReporte.getTipoReporte().equals( TiposReporteCierre.CONTRATOS_ACTIVOS_CON_MORA ) ) {
				procesado = generaReporteContratosActivosConMora(uid, eventoReporte.getFechaCierre(),
						eventoReporte.getTotalRegistros() );
				LogHandler.info( uid, getClass(), procesado ? "Se genero correctamente el Reporte CONTRATOS_ACTIVOS_CON_MORA"
						: "No se genero correctamente el Reporte CONTRATOS_ACTIVOS_CON_MORA" );
			} else if ( eventoReporte != null
					&&  eventoReporte.getTipoReporte().equals( TiposReporteCierre.CONTRATOS_ACTIVOS_SALDO_FAVOR) ) {
				procesado = generaReporteSaldoAFavor(uid, eventoReporte.getFechaCierre(), eventoReporte.getTotalRegistros() );
				LogHandler.info( uid, getClass(), procesado ? "Se genero correctamente el Reporte CONTRATOS_ACTIVOS_SALDO_FAVOR"
						: "No se genero correctamente el Reporte CONTRATOS_ACTIVOS_SALDO_FAVOR" );
			} else if ( eventoReporte != null
					&&  eventoReporte.getTipoReporte().equals( TiposReporteCierre.DESEMBOLSO_OPEN_CONTRACT) ) {
				procesado =
				 generaReporteDesembolsoOpenContract(uid, eventoReporte.getFechaCierre(), eventoReporte.getTotalRegistros());
				LogHandler.info( uid, getClass(), procesado ? "Se genero correctamente el Reporte DESEMBOLSO_OPEN_CONTRACT"
						: "No se genero correctamente el Reporte DESEMBOLSO_OPEN_CONTRACT" );
			} else if ( eventoReporte != null
					&&  eventoReporte.getTipoReporte().equals( TiposReporteCierre.DESEMBOLSO_REPAYMENTS) ) {
				procesado = generaReporteRepayment(uid, eventoReporte.getFechaCierre(), eventoReporte.getTotalRegistros() );
				LogHandler.info( uid, getClass(), procesado ? "Se genero correctamente el Reporte DESEMBOLSO_REPAYMENTS"
						: "No se genero correctamente el Reporte DESEMBOLSO_REPAYMENTS" );
			} else if ( eventoReporte != null
					&&  eventoReporte.getTipoReporte().equals( TiposReporteCierre.DESEMBOLOS_SE_FINSOL1) )
				{
				//Reporte FINSOL1
				procesado =
					generaReporteDesembolsoSEFinsol1(uid, eventoReporte.getFechaCierre(), eventoReporte.getTotalRegistros() );
				LogHandler.info( uid, getClass(), procesado ? "Se genero correctamente el Reporte DESEMBOLSO_SE_FINSOL1"
						: "No se genero correctamente el Reporte DESEMBOLSO_SE_FINSOL1" );
				}
			else if ( eventoReporte != null
					&&  eventoReporte.getTipoReporte().equals( TiposReporteCierre.DESEMBOLOS_SE_FINSOL2) ) {
				procesado =
				   generaReporteDesembolsoSEFinsol2(uid, eventoReporte.getFechaCierre(), eventoReporte.getTotalRegistros() );
				LogHandler.info( uid, getClass(), procesado
						? "Se genero correctamente el Reporte DESEMBOLSO_SE_FINSOL2"
								: "No se genero correctamente el Reporte DESEMBOLSO_SE_FINSOL2" );
			}
		} catch (Exception e) {
			//e.printStackTrace();
 			LogHandler.error(uid, getClass(), e.getMessage(), e);
		}
	}

	/* (non-Javadoc)
	 * @see tarea.reportes.CierreDiario#generaReporteCarteraActiva(java.lang.String)
	 */
	@SuppressWarnings("unchecked")

	public boolean generaReporteCarteraActiva(String uid, Date fechaCierre, Integer totalRegistrosAProcesar) {
		SqlSession sesionBatch 						= null; //inicia sesion para efectuar un query en iBatis
		SqlSession sesionNTx 						= null; //inicia sesion para obtener los detalles del contrato
		List<CarteraActivaOV>  listaCarteraActiva	= null; //lista de resultados de iBatis para CarteraActiva
		boolean resultado							= true; //se efectuo correctamente la operacion?
		int actual = 0;

 		try {
 			LogHandler.info( uid ,  getClass(),"Generando  ReporteCarteraActiva  TOTAL DE REGISTROS A PROCESAR: "
 					+  totalRegistrosAProcesar.intValue() );
			double factor = totalRegistrosAProcesar.intValue() > REGISTROS_MINIMOS  ? PORCENTAJE_AVANCE : 1;
			int aProcesar =	(int) Math.round( totalRegistrosAProcesar.intValue() * factor );
			LogHandler.info(uid , getClass(), "Se procesaran: " + aProcesar + "  registros por iteracion.");

			final String fileName = NOMBRE_REPORTE_CARTERA_ACTIVA + FORMATO_FECHA_NOM_REPORTE.format( fechaCierre ) + EXTENSION;

			//crear el archivo .cvs con el encabezado
			boolean estadoOk =
				generadorReportes.generaReporteCSV( uid, TiposReporteCierre.CARTERA_ACTIVA, RUTA_ARCHIVO, fileName );
			if ( !estadoOk )
				{
				throw new Exception("ERROR EL ARCHVIVO YA EXISTE, CERRARLO Y ELIMINARLO.");
				/*nO OMITIR ESTA PARTE ES FUNDAMENTAL*/
				}

			//Parametros de entrada
			final java.util.Date 	 fechaContable = comun.obtenerFechaContable( uid ).getFecha();
			final java.util.Calendar
							calendarInicio = java.util.Calendar.getInstance();
							calendarInicio.setTime( fechaContable );
							calendarInicio.set( Calendar.DAY_OF_MONTH , 1 );

			final java.util.Calendar
							calendarFin = java.util.Calendar.getInstance();
							calendarFin.setTime( fechaContable );
							calendarFin.add( Calendar.MONTH , 1 );
							calendarFin.set( Calendar.DAY_OF_MONTH , 1 );
							calendarFin.add( Calendar.DAY_OF_MONTH , -1 );

			final java.util.HashMap<String, String>
											params = new HashMap<String, String>();
											params.put( "fechaInicial", SDF.format( fechaCierre ));
											params.put( "fechaInicio" , SDF.format( calendarInicio.getTime() ));
											params.put( "fechaFin" ,    SDF.format( calendarFin.getTime() ));

			//for ( ; actual < totalRegistrosAProcesar.intValue(); actual += aProcesar)
				{
				try {
					//Abre conexion
					sesionBatch = FabricaConexiones.obtenerSesionBatch();
					sesionNTx	= FabricaConexiones.obtenerSesionNTx();

					//Obtenemos la lista de objetos a agregarse al reporte
					LogHandler.trace(uid, getClass(), "==> generaReporteCarteraActiva - " + OPER_OBTER_REPORTE_CARTERA_ACTIVA);
					listaCarteraActiva  = (List<CarteraActivaOV>)
							sesionBatch.selectList(OPER_OBTER_REPORTE_CARTERA_ACTIVA , params );
					//, new RowBounds(actual, aProcesar) );

					if ( listaCarteraActiva == null )
						{
						throw new Exception( "La lista carteraActiva viene con valor: NULL" );
						}

					//Agregando las filas recuperadas
					estadoOk = generadorReportes.agregaRegistrosReporteCSVCarteraActiva( uid,
							RUTA_ARCHIVO, fileName, fechaCierre, listaCarteraActiva, aProcesar, sesionNTx );
					if ( !estadoOk )
						{
						LogHandler.error(uid, getClass(), "ERROR AL AGREGAR FILAS AL REPORTE CARTERA ACTIVA.",
								new Exception( "ERROR AL AGREGAR FILAS AL REPORTE CARTERA ACTIVA." ));
						//nO OMITIR ESTA PARTE ES FUNDAMENTAL
						//continue;
						}

					actual = listaCarteraActiva.size();
					LogHandler.info(uid , getClass(), "Procesados: " + actual + " de: " + totalRegistrosAProcesar.intValue()
							+ " -- " +  Math.round( ( actual *100) / totalRegistrosAProcesar.intValue() ) + " %");

					//if ( ( actual + aProcesar ) <= totalRegistrosAProcesar.intValue() )
						//LogHandler.info(uid , getClass(),"Procesados: " + ( actual + aProcesar ) + " de: " + totalRegistrosAProcesar.intValue() +" -- " +  Math.round( ( ( actual + aProcesar ) * 100) / totalRegistrosAProcesar.intValue() ) + " %");

					//Se cierra la conexion
					FabricaConexiones.close( sesionBatch );
					FabricaConexiones.close( sesionNTx );
					}
				catch ( java.lang.Exception exception )
					{
					actual -= aProcesar;
					}
				} //fin del for

			int excedente = ( actual - totalRegistrosAProcesar.intValue() ); //se calcula el excedente de registros
			if (excedente > 0)
				{
				//abre conexion
				sesionBatch = FabricaConexiones.obtenerSesionBatch();
				sesionNTx	= FabricaConexiones.obtenerSesionNTx();

				LogHandler.trace(uid, getClass(), "==> generaReporteCarteraActiva - " + OPER_OBTER_REPORTE_CARTERA_ACTIVA);
				listaCarteraActiva  = (List<CarteraActivaOV>) sesionBatch.selectList(OPER_OBTER_REPORTE_CARTERA_ACTIVA, params,
						new RowBounds((actual - excedente), excedente));

				if ( listaCarteraActiva == null )
					{
					throw new Exception( "listaCarteraActiva viene con valor: NULL" );
					}
				//Agregando las filas excedentes recuperadas
				estadoOk = generadorReportes.agregaRegistrosReporteCSVCarteraActiva(uid, RUTA_ARCHIVO, fileName,
							fechaCierre, listaCarteraActiva, aProcesar, sesionNTx );
				if ( !estadoOk )
					{
					throw new Exception("ERROR AL AGREGAR LAS FILAS EXCEDENTES AL REPORTE.");
					/*nO OMITIR ESTA PARTE ES FUNDAMENTAL*/
					}

				actual -= excedente; //recuperar el total de registros procesados
 				LogHandler.info(uid , getClass(), "Procesados: " + actual + " de: " + totalRegistrosAProcesar.intValue()
 						+ " -- " +  Math.round( ( actual *100) / totalRegistrosAProcesar.intValue() ) + " %");
			}
			/**/
			transfiereReporteFTP( uid, RUTA_ARCHIVO + fileName );

  		} catch (Exception e) {
			//e.printStackTrace();
			resultado = false;
			LogHandler.error( uid, getClass(), "HA FALLADO EL METODO... generaReporteCarteraActiva ", e);
		}
		finally {
			FabricaConexiones.close( sesionBatch );
			FabricaConexiones.close( sesionNTx );
		}
		return resultado;
	}


	/* (non-Javadoc)
	 * @see tarea.reportes.CierreDiario#generaReporteContratosActivosConMora(java.lang.String)
	 */
	@SuppressWarnings("unchecked")

	public boolean generaReporteContratosActivosConMora( String uid, Date fechaCierre, Integer totalRegistrosAProcesar ) {

  		SqlSession sesionBatch 									= null; //inicia sesion para efectuar un query en iBatis
		List<ContratosActivosMoraOV>  listaContratosActivosMora	= null; //lista de resultados de iBatis para CarteraActiva
		boolean resultado										= true; //se efectuo correctamente la operacion?
		int actual = 0;
 		try {
			LogHandler.info( uid, this.getClass(), "GeneraReporteContratosActivosConMora TOTAL DE REGISTROS A PROCESAR: "
					+  totalRegistrosAProcesar.intValue() );
			double factor = totalRegistrosAProcesar.intValue() > REGISTROS_MINIMOS  ? PORCENTAJE_AVANCE : 1 ;
			int aProcesar =	(int) Math.round( totalRegistrosAProcesar.intValue() * factor );
			LogHandler.info( uid, this.getClass(), "Se procesaran: " + aProcesar +"  registros por iteracion.");
 
			String fileName = NOMBRE_REPORTE_CONTRATOS_ACTIVOS_CON_MORA
					+ FORMATO_FECHA_NOM_REPORTE.format( fechaCierre ) + EXTENSION;

			//crear el archivo .cvs con el encabezado
			boolean estadoOk =
				generadorReportes.generaReporteCSV(uid, TiposReporteCierre.CONTRATOS_ACTIVOS_CON_MORA, RUTA_ARCHIVO, fileName );
			if ( !estadoOk )
				throw new Exception("ERROR EL ARCHVIVO YA EXISTE, CERRARLO Y ELIMINARLO.");
			//nO OMITIR ESTA PARTE ES FUNDAMENTAL

			//for ( ; actual < totalRegistrosAProcesar.intValue(); actual += aProcesar)
				{
				try {
					//Abre conexion
					sesionBatch = FabricaConexiones.obtenerSesionBatch();

					//Obtenemos la lista de objetos a agregarse al reporte
					LogHandler.trace(uid, getClass(), "==> generaReporteContratosActivosConMora -"
					+ OPER_OBTER_REPORTE_CONTRATOS_ACTIVOS_MORA);
					listaContratosActivosMora  = (List<ContratosActivosMoraOV>)
							sesionBatch.selectList(OPER_OBTER_REPORTE_CONTRATOS_ACTIVOS_MORA, SDF.format( fechaCierre ) );
					//, new RowBounds(actual, aProcesar) );
					if ( listaContratosActivosMora == null )
						throw new Exception( "La lista contratosActivosMora viene con valor: NULL" );
					//LogHandler.info( uid, this.getClass(),"Tama�o listaContratosActivosMora: " + listaContratosActivosMora.size() );
					//Agregando las filas recuperadas
					estadoOk = generadorReportes.agregaRegistrosReporteCSVContratosActivosConMora(uid, RUTA_ARCHIVO,
							fileName, fechaCierre, listaContratosActivosMora, aProcesar );
					if ( !estadoOk )
						{
						LogHandler.error(uid, getClass(), "ERROR AL AGREGAR FILAS AL REPORTE CONTRATOS ACTIVOS CON MORA.",
								new Exception("ERROR AL AGREGAR FILAS AL REPORTE CONTRATOS ACTIVOS CON MORA."));
						//nO OMITIR ESTA PARTE ES FUNDAMENTAL
						//continue;
						}

					actual = listaContratosActivosMora.size();
					LogHandler.info(uid , getClass(), "Procesados: " + actual + " de: "
					+ totalRegistrosAProcesar.intValue() +" -- "
							+  Math.round( ( actual *100) / totalRegistrosAProcesar.intValue() ) + " %");

					//if ( ( actual + aProcesar ) <= totalRegistrosAProcesar.intValue() )
						//LogHandler.info( uid, this.getClass(),"Procesados: " + ( actual + aProcesar ) + " de: " + totalRegistrosAProcesar.intValue() +" -- " +  Math.round( ( ( actual + aProcesar ) * 100) / totalRegistrosAProcesar.intValue() ) + " %");

					FabricaConexiones.close(sesionBatch);
					}
				catch ( java.lang.Exception exception )
					{
					actual -= aProcesar;
					}
				}//fin del for
			//LogHandler.info( uid, this.getClass(),"VALOR DE \"actual\" UNA VEZ SALIENDO DEL for:  " + actual );
			int excedente = ( actual - totalRegistrosAProcesar.intValue() );
			//se calcula el excedente de registros
			//LogHandler.info( uid, this.getClass(),"VALOR DE \"excedente\" UNA VEZ CALCULADO EL EXCEDENTE DE REGISTROS A PROCESAR:  " + excedente);
			if ( excedente > 0 ) {
				//Abre conexion
				sesionBatch = FabricaConexiones.obtenerSesionBatch();

				LogHandler.trace(uid, getClass(), "==> generaReporteContratosActivosConMora - "
				+ OPER_OBTER_REPORTE_CONTRATOS_ACTIVOS_MORA);
				listaContratosActivosMora  = (List<ContratosActivosMoraOV>)
						sesionBatch.selectList(OPER_OBTER_REPORTE_CONTRATOS_ACTIVOS_MORA, SDF.format( fechaCierre ),
								new RowBounds((actual - excedente), excedente));
				if ( listaContratosActivosMora == null )
					throw new Exception( "listaContratosActivosMora viene con valor: NULL" );
				//Agregando las filas excedentes recuperadas
				estadoOk =
						generadorReportes.agregaRegistrosReporteCSVContratosActivosConMora(uid, RUTA_ARCHIVO,
								fileName, fechaCierre, listaContratosActivosMora, aProcesar );
				if ( !estadoOk )
					throw new Exception("ERROR AL AGREGAR LAS FILAS EXCEDENTES AL REPORTE.");
				//nO OMITIR ESTA PARTE ES FUNDAMENTAL

				actual -= excedente; //recuperar el total de registros procesados
//				LogHandler.info( uid, this.getClass(),"RESUMEN:");
//				LogHandler.info( uid, this.getClass(),"Tama�o listaContratosActivosMora Final: " + listaContratosActivosMora.size() );
//				LogHandler.info( uid, this.getClass(),"VALOR DE \"actual\" FINAL: " + actual);
				LogHandler.info( uid, this.getClass(),"Procesados: " + actual + " de: "
						+ totalRegistrosAProcesar.intValue() +" -- "
						+  Math.round( ( actual *100) / totalRegistrosAProcesar.intValue() ) + " %");
			}

			transfiereReporteFTP( uid, RUTA_ARCHIVO + fileName );

  		} catch (Exception e) {
			resultado = false;
			LogHandler.error( uid, this.getClass(), "HA FALLADO EL METODO... generaReporteContratosActivosConMora ", e);
		}
		finally {
			FabricaConexiones.close(sesionBatch);
		}
		return resultado;
	}


	/* (non-Javadoc)
	 * @see tarea.reportes.CierreDiario#generaReporteSaldoAFavor(java.lang.String)
	 */
	@SuppressWarnings("unchecked")

	public boolean generaReporteSaldoAFavor( String uid, Date fechaCierre, Integer totalRegistrosAProcesar ) {

		SqlSession sesionBatch 											= null; //inicia sesion para efectuar un query en iBatis
		List<ContratosActivosSaldoFavorOV>  listaContratosSaldoFavor	= null; //lista de resultados de iBatis para CarteraActiva
		boolean resultado												= true; //se efectuo correctamente la operacion?
		int actual = 0;
  		try {
 			LogHandler.info( uid, this.getClass(), "GeneraReporteSaldoAFavor TOTAL DE REGISTROS A PROCESAR: "
  		+  totalRegistrosAProcesar.intValue() );
			double factor = totalRegistrosAProcesar.intValue() > REGISTROS_MINIMOS  ? PORCENTAJE_AVANCE : 1;
			int aProcesar =	(int) Math.round( totalRegistrosAProcesar.intValue() * factor );
			LogHandler.info( uid, this.getClass(), "Se procesaran: " + aProcesar + "  registros por iteracion.");

			String fileName = NOMBRE_REPORTE_CONTRATOS_ACTIVOS_CON_SALDO_FAVOR + SDF.format( fechaCierre ) + EXTENSION;

			//crear el archivo .cvs con el encabezado
			boolean estadoOk = generadorReportes.generaReporteCSV(uid, TiposReporteCierre.CONTRATOS_ACTIVOS_SALDO_FAVOR,
					RUTA_ARCHIVO, fileName );
			if ( !estadoOk )
				throw new Exception("ERROR EL ARCHVIVO YA EXISTE, CERRARLO Y ELIMINARLO.");
			//nO OMITIR ESTA PARTE ES FUNDAMENTAL

			for ( ; actual < totalRegistrosAProcesar.intValue(); actual += aProcesar)
				{
				try {
					//Abre conexion
					sesionBatch = FabricaConexiones.obtenerSesionBatch();

					//Obtenemos la lista de objetos a agregarse al reporte
					LogHandler.trace(uid, getClass(), "==>generaReporteSaldoAFavor - "
					+ OPER_OBTER_REPORTE_CONTRATOS_SALDO_FAVOR );
					listaContratosSaldoFavor  = (List<ContratosActivosSaldoFavorOV>)
							sesionBatch.selectList(OPER_OBTER_REPORTE_CONTRATOS_SALDO_FAVOR,
									null, new RowBounds(actual, aProcesar) );
					if ( listaContratosSaldoFavor == null )
						throw new Exception( "La listaContratosSaldoFavor viene con valor: NULL" );
	//				LogHandler.info( uid, this.getClass(),"Tama�o listaContratosSaldoFavor: " + listaContratosSaldoFavor.size() );
					//Agregando las filas recuperadas
					estadoOk = generadorReportes.agregaRegistrosReporteCSVContratosActivosSaldoAFavor( uid, RUTA_ARCHIVO,
							fileName, fechaCierre, listaContratosSaldoFavor );
					if ( !estadoOk )
						{
						LogHandler.error(uid, getClass(), "ERROR AL AGREGAR FILAS AL REPORTE CONTRATOS SALDO FAVOR.",
								new Exception("ERROR AL AGREGAR FILAS AL REPORTE CONTRATOS SALDO FAVOR."));
						//nO OMITIR ESTA PARTE ES FUNDAMENTAL
						continue;
						}

	//				LogHandler.info( uid, this.getClass(),"Se obtuvo el objeto valor para ContratosActivosSaldoFavor");
					if ( ( actual + aProcesar ) <= totalRegistrosAProcesar.intValue() )
						LogHandler.info( uid, this.getClass(),"Procesados: " + ( actual + aProcesar )
								+ " de: " + totalRegistrosAProcesar.intValue() +" -- "
								+  Math.round( ( ( actual + aProcesar ) * 100) / totalRegistrosAProcesar.intValue() ) + " %");

					FabricaConexiones.close(sesionBatch);
					}
				catch ( java.lang.Exception exception )
					{
					actual -= aProcesar;
					}
				} //fin del for
//			LogHandler.info( uid, this.getClass(),"VALOR DE \"actual\" UNA VEZ SALIENDO DEL for:  " + actual );
			int excedente = ( actual - totalRegistrosAProcesar.intValue() ); //se calcula el excedente de registros
//			LogHandler.info( uid, this.getClass(),"VALOR DE \"excedente\" UNA VEZ CALCULADO EL EXCEDENTE DE REGISTROS A PROCESAR:  " + excedente);
			if (actual > 0) {
				//Abre conexion
				sesionBatch = FabricaConexiones.obtenerSesionBatch();

				LogHandler.trace(uid, getClass(), "==> generaReporteSaldoAFavor - " +  OPER_OBTER_REPORTE_CONTRATOS_SALDO_FAVOR);
				listaContratosSaldoFavor  = (List<ContratosActivosSaldoFavorOV>)
						sesionBatch.selectList(OPER_OBTER_REPORTE_CONTRATOS_SALDO_FAVOR, SDF.format( fechaCierre ),
								new RowBounds((actual - excedente), excedente));
				if ( listaContratosSaldoFavor == null )
					throw new Exception( "listaContratosSaldoFavor viene con valor: NULL" );
				//Agregando las filas excedentes recuperadas
				estadoOk = generadorReportes.agregaRegistrosReporteCSVContratosActivosSaldoAFavor(uid, RUTA_ARCHIVO,
						fileName, fechaCierre, listaContratosSaldoFavor );
				if ( !estadoOk )
					throw new Exception("ERROR AL AGREGAR LAS FILAS EXCEDENTES AL REPORTE."); //nO OMITIR ESTA PARTE ES FUNDAMENTAL

				actual -= excedente; //recuperar el total de registros procesados
//				LogHandler.info( uid, this.getClass(),"RESUMEN:");
//				LogHandler.info( uid, this.getClass(),"Tama�o listaContratosSaldoFavor Final: " + listaContratosSaldoFavor.size() );
//				LogHandler.info( uid, this.getClass(),"VALOR DE \"actual\" FINAL: " + actual);
				LogHandler.info( uid, this.getClass(),"Procesados: " + actual + " de: "
						+ totalRegistrosAProcesar.intValue() + " -- "
						+  Math.round( ( actual *100) / totalRegistrosAProcesar.intValue() ) + " %");
			}

			transfiereReporteFTP(uid, RUTA_ARCHIVO + fileName);

  		} catch (Exception e) {
			resultado = false;
			LogHandler.error( uid, this.getClass(), "HA FALLADO EL METODO... generaReporteSaldoAFavor ", e);
		}
		finally {
			FabricaConexiones.close(sesionBatch);
		}
		return resultado;
	}

	/*
	 * (non-Javadoc)
	 * @see tarea.reportes.CierreDiario#generaReporteDesembolsoOpenContract(java.lang.String, java.util.Date, java.lang.Integer)
	 */
	@SuppressWarnings("unchecked")

	public boolean generaReporteDesembolsoOpenContract(String uid, Date fechaCierre, Integer totalRegistrosAProcesar) {
		SqlSession sesionBatch 										= null; //inicia sesion para efectuar un query en iBatis
		List<DesembolsoOpenContractOV>  listaDesembolsoOpenContract	= null; //lista de resultados de iBatis para CarteraActiva
		boolean resultado											= true; //se efectuo correctamente la operacion?
		int actual = 0;
  		try {
 			LogHandler.info( uid, this.getClass(), "GeneraReporteDesembolsoOpenContract TOTAL DE REGISTROS A PROCESAR: "
  		+  totalRegistrosAProcesar.intValue() );
			double factor = totalRegistrosAProcesar.intValue() > REGISTROS_MINIMOS  ? PORCENTAJE_AVANCE : 1;
			int aProcesar =	(int) Math.round(totalRegistrosAProcesar.intValue() * factor );
			LogHandler.info( uid, this.getClass(), "Se procesaran: " + aProcesar +"  registros por iteracion.");
			String fileName = NOMBRE_REPORTE_DESEMBOLSO_OPEN_CONTRACT + SDF.format( fechaCierre ) + EXTENSION;

			//crear el archivo .cvs con el encabezado
			boolean estadoOk = generadorReportes.generaReporteCSV(uid, TiposReporteCierre.DESEMBOLSO_OPEN_CONTRACT,
					RUTA_ARCHIVO, fileName );
			if ( !estadoOk )
				throw new Exception("ERROR EL ARCHVIVO YA EXISTE, CERRARLO Y ELIMINARLO.");
			//nO OMITIR ESTA PARTE ES FUNDAMENTAL

			for ( ; actual < totalRegistrosAProcesar.intValue(); actual += aProcesar)
				{
				try {
					//Abre conexion
					sesionBatch = FabricaConexiones.obtenerSesionBatch();

					//Obtenemos la lista de objetos a agregarse al reporte
					LogHandler.trace(uid, getClass(), "==> generaReporteDesembolsoOpenContract - "
					+ OPER_OBTER_REPORTE_DESEMBOLSO_OPEN_CONTRACT );
					listaDesembolsoOpenContract  = (List<DesembolsoOpenContractOV>)
							sesionBatch.selectList(OPER_OBTER_REPORTE_DESEMBOLSO_OPEN_CONTRACT, SDF.format( fechaCierre ),
									new RowBounds(actual, aProcesar) );
					if ( listaDesembolsoOpenContract == null )
						throw new Exception( "La lista desembolsoOpenContract viene con valor: NULL" );

					//Agregando las filas recuperadas
					estadoOk = generadorReportes.agregaRegistrosReporteCSVDesembolsoOpenContract(uid, RUTA_ARCHIVO, fileName,
							fechaCierre, listaDesembolsoOpenContract );
					if ( !estadoOk )
						{
						LogHandler.error(uid, getClass(), "ERROR AL AGREGAR FILAS AL REPORTE DESEMBOLSO OPEN CONTRACT.",
								new Exception("ERROR AL AGREGAR FILAS AL REPORTE DESEMBOLSO OPEN CONTRACT."));
						//nO OMITIR ESTA PARTE ES FUNDAMENTAL
						continue;
						}

					if ( ( actual + aProcesar ) <= totalRegistrosAProcesar.intValue() )
						LogHandler.info( uid, this.getClass(), "Procesados: " + ( actual + aProcesar )
								+ " de: " + totalRegistrosAProcesar.intValue() +" -- "
								+  Math.round( ( ( actual + aProcesar ) * 100) / totalRegistrosAProcesar.intValue() ) + " %");

					FabricaConexiones.close(sesionBatch);
					}
				catch ( java.lang.Exception exception )
					{
					actual -= aProcesar;
					}
				} //fin del for

			int excedente = ( actual - totalRegistrosAProcesar.intValue() ); //se calcula el excedente de registros

			if (actual > 0) {
				//Abre conexion
				sesionBatch = FabricaConexiones.obtenerSesionBatch();

				LogHandler.trace(uid, getClass(), "==> generaReporteDesembolsoOpenContract - "
				+ OPER_OBTER_REPORTE_DESEMBOLSO_OPEN_CONTRACT );
				listaDesembolsoOpenContract  = (List<DesembolsoOpenContractOV>)
						sesionBatch.selectList(OPER_OBTER_REPORTE_DESEMBOLSO_OPEN_CONTRACT, SDF.format( fechaCierre ),
								new RowBounds((actual - excedente), excedente));
				if ( listaDesembolsoOpenContract == null )
					throw new Exception( "listaDesembolsoOpenContract viene con valor: NULL" );
				//Agregando las filas excedentes recuperadas
				estadoOk = generadorReportes.agregaRegistrosReporteCSVDesembolsoOpenContract(uid, RUTA_ARCHIVO,
						fileName, fechaCierre, listaDesembolsoOpenContract );
				if ( !estadoOk )
					throw new Exception("ERROR AL AGREGAR LAS FILAS EXCEDENTES AL REPORTE.");
				//nO OMITIR ESTA PARTE ES FUNDAMENTAL

				actual -= excedente; //recuperar el total de registros procesados
				LogHandler.info( uid, this.getClass(), "Procesados: " + actual + " de: "
				+ totalRegistrosAProcesar.intValue() + " -- "
						+  Math.round( ( actual *100) / totalRegistrosAProcesar.intValue() ) + " %");
			}
			transfiereReporteFTP(uid, RUTA_ARCHIVO + fileName);
  		} catch (Exception e) {
			resultado = false;
			LogHandler.error( uid, this.getClass(), "HA FALLADO EL METODO... generaReporteDesembolsoOpenContract ", e);
		}
		finally {
			FabricaConexiones.close(sesionBatch);
		}
		return resultado;
	}

	@SuppressWarnings("unchecked")

	public boolean generaReporteRepayment(String uid, Date fechaCierre, Integer totalRegistrosAProcesar) {
		SqlSession sesionBatch 										= null; //inicia sesion para efectuar un query en iBatis
		List<DesembolsoRepaymentsOV>  listaDesembolsoRepayments		= null; //lista de resultados de iBatis para CarteraActiva
		boolean resultado											= true; //se efectuo correctamente la operacion?
		int actual = 0;
 		try {
 			LogHandler.info( uid, this.getClass(), "GeneraReporteDesembolsoRepayment TOTAL DE REGISTROS A PROCESAR: "
 		+  totalRegistrosAProcesar.intValue() );
			double factor = totalRegistrosAProcesar.intValue() > REGISTROS_MINIMOS  ? PORCENTAJE_AVANCE : 1;
			int aProcesar =	(int) Math.round(totalRegistrosAProcesar.intValue() * factor );
			LogHandler.info( uid, this.getClass(), "Se procesaran: " + aProcesar +"  registros por iteracion.");

			String fileName = NOMBRE_REPORTE_DESEMBOLSO_REPAYMENT  + SDF.format( fechaCierre ) + EXTENSION;

			//crear el archivo .cvs con el encabezado
			boolean estadoOk = generadorReportes.generaReporteCSV (uid, TiposReporteCierre.DESEMBOLSO_REPAYMENTS,
					RUTA_ARCHIVO, fileName );
			if ( !estadoOk )
				throw new Exception("ERROR EL ARCHVIVO YA EXISTE, CERRARLO Y ELIMINARLO.");
			//nO OMITIR ESTA PARTE ES FUNDAMENTAL

		 	sesionBatch = FabricaConexiones.obtenerSesionBatch();
		 	for ( ; actual < totalRegistrosAProcesar.intValue(); actual += aProcesar)
		 		{
		 		try {
			 		//Abre conexion
					sesionBatch = FabricaConexiones.obtenerSesionBatch();

					//Obtenemos la lista de objetos a agregarse al reporte
			 		LogHandler.trace(uid, getClass(), "==>generaReporteRepayment - " + OPER_OBTER_REPORTE_REPAYMENTS);
					listaDesembolsoRepayments  = (List<DesembolsoRepaymentsOV>)
							sesionBatch.selectList(OPER_OBTER_REPORTE_REPAYMENTS, SDF.format( fechaCierre ),
									new RowBounds(actual, aProcesar) );
					if ( listaDesembolsoRepayments == null )
						throw new Exception( "La lista desembolsoRepayments viene con valor: NULL" );
	//				LogHandler.debug( null, this.getClass(),"Tama�o listaDesembolsoRepayments: " + listaDesembolsoRepayments.size() );
					//Agregando las filas recuperadas
					estadoOk = generadorReportes.agregaRegistrosReporteCSVDesembolsoRepayment(uid, RUTA_ARCHIVO,
							fileName, fechaCierre, listaDesembolsoRepayments );
					if ( !estadoOk )
						{
						LogHandler.error(uid, getClass(),"ERROR AL AGREGAR FILAS AL REPORTE DESEMBOLSO REPAYMENT",
								new Exception("ERROR AL AGREGAR FILAS AL REPORTE DESEMBOLSO REPAYMENT"));
						//nO OMITIR ESTA PARTE ES FUNDAMENTAL
						continue;
						}

	//				LogHandler.info( uid, this.getClass(),"Se obtuvo el objeto valor para DesembolsoRepayment");
					if ( ( actual + aProcesar ) <= totalRegistrosAProcesar.intValue() )
						LogHandler.info( uid, this.getClass(),"Procesados: " + ( actual + aProcesar )
								+ " de: " + totalRegistrosAProcesar.intValue() + " -- "
								+  Math.round( ( ( actual + aProcesar ) * 100) / totalRegistrosAProcesar.intValue() ) + " %");
					
					FabricaConexiones.close(sesionBatch);
			 		}
				catch ( java.lang.Exception exception )
					{
					actual -= aProcesar;
					}
		 		} //fin del for
//			LogHandler.info( uid, this.getClass(),"VALOR DE \"actual\" UNA VEZ SALIENDO DEL for:  " + actual );

			int excedente = ( actual - totalRegistrosAProcesar.intValue() ); //se calcula el excedente de registros
//			LogHandler.info( uid, this.getClass(),"VALOR DE \"excedente\" UNA VEZ CALCULADO EL EXCEDENTE DE REGISTROS A PROCESAR:  " + excedente);
			if (actual > 0) {
				//Abre conexion
				sesionBatch = FabricaConexiones.obtenerSesionBatch();

				LogHandler.trace(uid, getClass(), "==> generaReporteRepayment - " + OPER_OBTER_REPORTE_REPAYMENTS);
				listaDesembolsoRepayments  = (List<DesembolsoRepaymentsOV>)
						sesionBatch.selectList(OPER_OBTER_REPORTE_REPAYMENTS, SDF.format( fechaCierre ),
								new RowBounds((actual - excedente), excedente));
				if ( listaDesembolsoRepayments == null )
					throw new Exception( "listaDesembolsoRepayments viene con valor: NULL" );
				//Agregando las filas excedentes recuperadas
				estadoOk = generadorReportes.agregaRegistrosReporteCSVDesembolsoRepayment(uid, RUTA_ARCHIVO, fileName,
						fechaCierre, listaDesembolsoRepayments );
				if ( !estadoOk )
					throw new Exception("ERROR AL AGREGAR LAS FILAS EXCEDENTES AL REPORTE.");
				//nO OMITIR ESTA PARTE ES FUNDAMENTAL

				actual -= excedente; //recuperar el total de registros procesados
//				LogHandler.info( uid, this.getClass(),"RESUMEN:");
//				LogHandler.info( uid, this.getClass(),"Tama�o listaDesembolsoRepayments Final: " + listaDesembolsoRepayments.size() );
//				LogHandler.info( uid, this.getClass(),"VALOR DE \"actual\" FINAL: " + actual);
				LogHandler.info( uid, this.getClass(), "Procesados: " + actual + " de: " + totalRegistrosAProcesar.intValue()
						+ " -- " +  Math.round( ( actual *100) / totalRegistrosAProcesar.intValue() ) + " %");
			}
			transfiereReporteFTP(uid, RUTA_ARCHIVO + fileName);
  		} catch (Exception e) {
			resultado = false;
			LogHandler.error( uid, this.getClass(), "HA FALLADO EL METODO... generaReporteDesembolsoRepayment ", e);
		}
		finally {
			FabricaConexiones.close(sesionBatch);
		}
		return resultado;
	}

	@SuppressWarnings("unchecked")

	public boolean generaReporteDesembolsoSEFinsol1(String uid, Date fechaCierre, Integer totalRegistrosAProcesar) {
		SqlSession sesionBatch 										= null; //inicia sesion para efectuar un query en iBatis
		List<DesembolsoSEFinsol1OV>  listaDesembolsoSEFinsol1		= null; //lista de resultados de iBatis para CarteraActiva
		boolean resultado											= true; //se efectuo correctamente la operacion?
		int actual = 0;
  		try {
 			LogHandler.info( uid, this.getClass(), "GeneraReporteDesembolsoSEFinsol1 TOTAL DE REGISTROS A PROCESAR: "
  		+  totalRegistrosAProcesar.intValue() );
			double factor = totalRegistrosAProcesar.intValue() > REGISTROS_MINIMOS  ? PORCENTAJE_AVANCE : 1;
			int aProcesar =	(int) Math.round( totalRegistrosAProcesar.intValue() * factor );
			LogHandler.info( uid, this.getClass(), "Se procesaran: " + aProcesar +"  registros por iteracion.");

 			final String fileName = NOMBRE_REPORTE_DESEMBOLSO_SE_FINSOL1 + SDF.format( fechaCierre ) + EXTENSION;

			//crear el archivo .cvs con el encabezado
			boolean estadoOk = generadorReportes.generaReporteCSV( uid, TiposReporteCierre.DESEMBOLOS_SE_FINSOL1,
					RUTA_ARCHIVO, fileName );
			if ( !estadoOk )
				{
				throw new Exception("ERROR EL ARCHVIVO YA EXISTE, CERRARLO Y ELIMINARLO.");	}
			//nO OMITIR ESTA PARTE ES FUNDAMENTAL

			//Se abre una conexion de tipo batch para soportar la carga deregistros
		 	sesionBatch = FabricaConexiones.obtenerSesionBatch();

		 	/*** Pagos a Capital ***/
		 	LogHandler.trace(uid, getClass(), "==> generaReporteDesembolsoSEFinsol1 - obtenerPagadoCapital");
		 	final List<HashMap<String, Object>>
		 					pagoCapitalQuery = (List<HashMap<String, Object>>)
		 					sesionBatch.selectList("obtenerPagadoCapital", SDF.format( fechaCierre ) );

		 	//Variable para almacenar los pagos a capital
		 	final java.util.HashMap<String, Object>
		 					pagoCapitalMap = new HashMap<String, Object>();

		 	for ( HashMap<String, Object> pagosCap : pagoCapitalQuery )
		 		{
		 		pagoCapitalMap.put(pagosCap.get( "Contrato").toString() , pagosCap.get( "Pagado_Capital"));
		 		}

		 	/*** Pagos a Intereses ***/
		 	LogHandler.trace(uid, getClass(), "==> generaReporteDesembolsoSEFinsol1 - obtenerPagadoCapital");
		 	final List<HashMap<String, Object>>  
							pagoInteresQuery = (List<HashMap<String, Object>>)
							sesionBatch.selectList("obtenerPagadoIntereses", SDF.format( fechaCierre ) );

		 	//Variable para almacenar los pagos a intereses
		 	final java.util.HashMap<String, Object>
							pagoInteresMap = new HashMap<String, Object>();

		 	for ( HashMap<String, Object> pagosInt : pagoInteresQuery )
	 			{
		 		pagoInteresMap.put(pagosInt.get( "Contrato").toString() , pagosInt.get( "Pagado_Intereses"));
	 			}

		 	/*** Pagos a Mora, obtenemos los contratos que realizaron un pago a Mora ***/
		 	LogHandler.trace(uid, getClass(), "==> generaReporteDesembolsoSEFinsol1 - obtenerPagadoMora");
		 	final List<String>
		 			listPagoMora = (List<String>) sesionBatch.selectList("obtenerPagadoMora", SDF.format( fechaCierre ) );

		 	for ( ; actual < totalRegistrosAProcesar.intValue(); actual += aProcesar)
		 		{
		 		try {
			 		//Abre conexion
					sesionBatch = FabricaConexiones.obtenerSesionBatch();

					//Obtenemos la lista de objetos a agregarse al reporte}
			 		LogHandler.trace(uid, getClass(), "==> generaReporteDesembolsoSEFinsol1 - " + OPER_OBTER_REPORTE_SE_FINSOL1 );
					listaDesembolsoSEFinsol1  = (List<DesembolsoSEFinsol1OV>)
							sesionBatch.selectList(OPER_OBTER_REPORTE_SE_FINSOL1, SDF.format( fechaCierre ),
									new RowBounds(actual, aProcesar) );
					if ( listaDesembolsoSEFinsol1 == null )
						{	throw new Exception( "La lista desembolsoSEFinsol1 viene con valor: NULL" );	}
					//LogHandler.debug( null, this.getClass(),"Tama�o listaDesembolsoSEFinsol1: " + listaDesembolsoSEFinsol1.size() );
					//Agregando las filas recuperadas
					estadoOk = generadorReportes.agregaRegistrosReporteCSVDesembolsoSEFinsol1(uid, RUTA_ARCHIVO, fileName,
							fechaCierre, listaDesembolsoSEFinsol1, pagoCapitalMap, pagoInteresMap, listPagoMora );
					if ( !estadoOk )
						{
						LogHandler.error(uid, getClass(),"ERROR AL AGREGAR FILAS AL REPORTE DESEMBOLSO SE_FINSOL1",
								new Exception("ERROR AL AGREGAR FILAS AL REPORTE DESEMBOLSO SE_FINSOL1"));
						//nO OMITIR ESTA PARTE ES FUNDAMENTAL
						continue;
						}

					if ( ( actual + aProcesar ) <= totalRegistrosAProcesar.intValue() )
						LogHandler.info( uid, this.getClass(), "Procesados: " + ( actual + aProcesar )
								+ " de: " + totalRegistrosAProcesar.intValue()
								+ " -- " +  Math.round( ( ( actual + aProcesar ) * 100)
										/ totalRegistrosAProcesar.intValue() ) + " %");

					FabricaConexiones.close(sesionBatch);
		 			}
				catch ( java.lang.Exception exception )
					{
					actual -= aProcesar;
					}
		 		} //fin del for

			int excedente = ( actual - totalRegistrosAProcesar.intValue() ); //se calcula el excedente de registros
			if (actual > 0) {
				//Abre conexion
				sesionBatch = FabricaConexiones.obtenerSesionBatch();

				LogHandler.trace(uid, getClass(), "==> generaReporteDesembolsoSEFinsol1 - " +  OPER_OBTER_REPORTE_SE_FINSOL1);
				listaDesembolsoSEFinsol1  = (List<DesembolsoSEFinsol1OV>) sesionBatch.selectList(OPER_OBTER_REPORTE_SE_FINSOL1,
						SDF.format( fechaCierre ), new RowBounds((actual - excedente), excedente));
				if ( listaDesembolsoSEFinsol1 == null )
					throw new Exception( "listaDesembolsoSEFinsol1 viene con valor: NULL" );
				//Agregando las filas excedentes recuperadas
				estadoOk = generadorReportes.agregaRegistrosReporteCSVDesembolsoSEFinsol1(uid, RUTA_ARCHIVO, fileName, fechaCierre,
						listaDesembolsoSEFinsol1, pagoCapitalMap, pagoInteresMap, listPagoMora );
				if ( !estadoOk )
					throw new Exception("ERROR AL AGREGAR LAS FILAS EXCEDENTES AL REPORTE.");
				//nO OMITIR ESTA PARTE ES FUNDAMENTAL

				actual -= excedente; //recuperar el total de registros procesados
				LogHandler.info( uid, this.getClass(), "Procesados: " + actual + " de: "
				+ totalRegistrosAProcesar.intValue() + " -- " +  Math.round( ( actual *100)
						/ totalRegistrosAProcesar.intValue() ) + " %");
			}
			transfiereReporteFTP(uid, RUTA_ARCHIVO + fileName);
  		} catch (Exception e) {
			resultado = false;
			LogHandler.error( uid, this.getClass(), "HA FALLADO EL METODO... generaReporteDesembolsoSEFinsol1 ", e);
		}
		finally {
			FabricaConexiones.close(sesionBatch);
		}
		return resultado;
	}

	@SuppressWarnings("unchecked")

	public boolean generaReporteDesembolsoSEFinsol2(String uid, Date fechaCierre, Integer totalRegistrosAProcesar) {
		SqlSession sesionBatch 										= null; //inicia sesion para efectuar un query en iBatis
		List<DesembolsoSEFinsol2OV>  listaDesembolsoSEFinsol2		= null; //lista de resultados de iBatis para CarteraActiva
		boolean resultado											= true; //se efectuo correctamente la operacion?
		int actual = 0;
  		try {
 			LogHandler.info( uid, this.getClass(), "GeneraReporteDesembolsoSEFinsol2 TOTAL DE REGISTROS A PROCESAR: "
 					+  totalRegistrosAProcesar.intValue() );
			double factor = totalRegistrosAProcesar.intValue() > REGISTROS_MINIMOS  ? PORCENTAJE_AVANCE : 1;
			int aProcesar =	(int) Math.round( totalRegistrosAProcesar.intValue() * factor );
			LogHandler.info( uid, this.getClass(), "Se procesaran: " + aProcesar + "  registros por iteracion.");

			String fileName = NOMBRE_REPORTE_DESEMBOLSO_SE_FINSOL2 + SDF.format( fechaCierre ) + EXTENSION;

			//crear el archivo .cvs con el encabezado
			boolean estadoOk = generadorReportes.generaReporteCSV (uid, TiposReporteCierre.DESEMBOLOS_SE_FINSOL2,
					RUTA_ARCHIVO, fileName );
			if ( !estadoOk )
				throw new Exception("ERROR EL ARCHVIVO YA EXISTE, CERRARLO Y ELIMINARLO.");
			//nO OMITIR ESTA PARTE ES FUNDAMENTAL

			//Se obtiene la sesion
			sesionBatch = FabricaConexiones.obtenerSesionBatch();

			//Se obtiene el abono a capital
			LogHandler.trace(uid, getClass(), "==> generaReporteDesembolsoSEFinsol2 - obtenerPagadoCapitalSEFinsol2");
			final java.util.List<HashMap<String, Object>>
							listaPagosCapital = (List<HashMap<String, Object>>)
							sesionBatch.selectList( "obtenerPagadoCapitalSEFinsol2", SDF.format( fechaCierre ) );

			final java.util.HashMap<String, Object>
							pagosCapitalMap = new HashMap<String, Object>();

			for( HashMap<String, Object> pagosCap : listaPagosCapital )
		 		{
				pagosCapitalMap.put(pagosCap.get( "Contrato").toString() , pagosCap.get( "Pagado_Capital"));
		 		}

			//Se obtiene el pago de intereses
			LogHandler.trace(uid, getClass(), "==> generaReporteDesembolsoSEFinsol2 - obtenerPagadoInteresesSEFinsol2");
			final java.util.List<HashMap<String, Object>>
							listaPagosInteres = (List<HashMap<String, Object>>)
							sesionBatch.selectList("obtenerPagadoInteresesSEFinsol2", SDF.format( fechaCierre ) );

			final java.util.HashMap<String, Object>
							pagosInteresMap = new HashMap<String, Object>();

			for ( HashMap<String, Object> pagosInt : listaPagosInteres )
				{
				pagosInteresMap.put(pagosInt.get( "Contrato").toString() , pagosInt.get( "Pagado_Intereses"));
				}

			//Se obtiene el pago moratorio
			LogHandler.trace(uid, getClass(), "==> generaReporteDesembolsoSEFinsol2 - obtenerPagadoMoratorio");
			final java.util.List<HashMap<String, Object>>
							listaPagosMora = (List<HashMap<String, Object>>)
							sesionBatch.selectList( "obtenerPagadoMoratorio", SDF.format( fechaCierre ) );

			final java.util.HashMap<String, Object>
							pagosMoraMap = new HashMap<String, Object>();

			for ( HashMap<String, Object> pagosMora : listaPagosMora )
				{
				pagosMoraMap.put(pagosMora.get( "Contrato").toString() , pagosMora.get( "Pagado_Recargos"));
				}

			//Se crea la consulta de los registros por paginas
			for ( ; actual < totalRegistrosAProcesar.intValue(); actual += aProcesar )
				{
				try {
					//Abre conexion
					sesionBatch = FabricaConexiones.obtenerSesionBatch();

					//Obtenemos la lista de objetos a agregarse al reporte
					LogHandler.trace(uid, getClass(), "==> generaReporteDesembolsoSEFinsol2 - "
					+  OPER_OBTER_REPORTE_DESEMBOLSO_SE_FINSOL2);
					listaDesembolsoSEFinsol2  = (List<DesembolsoSEFinsol2OV>)
							sesionBatch.selectList(OPER_OBTER_REPORTE_DESEMBOLSO_SE_FINSOL2, SDF.format( fechaCierre ),
									new RowBounds(actual, aProcesar) );
					if ( listaDesembolsoSEFinsol2 == null )
						{
						throw new Exception( "La lista desembolsoSEFinsol2 viene con valor: NULL" );
						}

					//Agregando las filas recuperadas
					estadoOk = generadorReportes.agregaRegistrosReporteCSVDesembolsoSEFinsol2(uid, RUTA_ARCHIVO,
							fileName, fechaCierre, listaDesembolsoSEFinsol2, pagosCapitalMap, pagosInteresMap, pagosMoraMap );
					if ( !estadoOk )
						{
						LogHandler.error(uid, getClass(), "ERROR AL AGREGAR FILAS AL REPORTE DESEMBOLSO SE_FINSOL2",
								new Exception("ERROR AL AGREGAR FILAS AL REPORTE DESEMBOLSO SE_FINSOL2"));
						//nO OMITIR ESTA PARTE ES FUNDAMENTAL
						continue;
						}

					if ( ( actual + aProcesar ) <= totalRegistrosAProcesar.intValue() )
						LogHandler.info( uid, this.getClass(),"Procesados: " + ( actual + aProcesar )
								+ " de: " + totalRegistrosAProcesar.intValue() + "  "
								+  Math.round( ( ( actual + aProcesar )  * 100)
										/ totalRegistrosAProcesar.intValue() ) + " %");

					FabricaConexiones.close(sesionBatch);
					}
				catch ( java.lang.Exception exception )
					{
					actual -= aProcesar;
					}
				} //fin del for

			int excedente = ( actual - totalRegistrosAProcesar.intValue() ); //se calcula el excedente de registros
			if (actual > 0) {
				//Abre conexion
				sesionBatch = FabricaConexiones.obtenerSesionBatch();

				LogHandler.trace(uid, getClass(), "==> generaReporteDesembolsoSEFinsol2 - "
				+ OPER_OBTER_REPORTE_DESEMBOLSO_SE_FINSOL2);
				listaDesembolsoSEFinsol2  = (List<DesembolsoSEFinsol2OV>)
						sesionBatch.selectList(OPER_OBTER_REPORTE_DESEMBOLSO_SE_FINSOL2, SDF.format( fechaCierre ),
								new RowBounds( (actual - excedente), excedente));
				if ( listaDesembolsoSEFinsol2 == null )
					throw new Exception( "listaDesembolsoSEFinsol2 viene con valor: NULL" );
				//Agregando las filas excedentes recuperadas
				estadoOk = generadorReportes.agregaRegistrosReporteCSVDesembolsoSEFinsol2(uid, RUTA_ARCHIVO,
						fileName, fechaCierre, listaDesembolsoSEFinsol2, pagosCapitalMap, pagosInteresMap, pagosMoraMap );
				if ( !estadoOk )
					throw new Exception("ERROR AL AGREGAR LAS FILAS EXCEDENTES AL REPORTE.");
				//nO OMITIR ESTA PARTE ES FUNDAMENTAL

				actual -= excedente; //recuperar el total de registros procesados
				LogHandler.info( uid, getClass(), "Procesados: " + actual + " de: "
				+ totalRegistrosAProcesar.intValue() + " -- " +  Math.round( ( actual *100)
						/ totalRegistrosAProcesar.intValue() ) + " %");
			}
			transfiereReporteFTP(uid, RUTA_ARCHIVO + fileName);
  		} catch (Exception e) {
			resultado = false;
			LogHandler.error( uid, getClass(), "HA FALLADO EL METODO... generaReporteDesembolsoSEFinsol2 ", e);
		}
		finally {
			FabricaConexiones.close(sesionBatch);
		}
		return resultado;

	}

	/**
	 * Metodo que transmite el archivo via FTP hacia un host establecido
	 * @param fechaCierre
	 */
	private void transfiereReporteFTP( String uid, String absoluteFileName )
		{
		if ( ReadProperties.reportes.getProp( "reportes.tranferir" ) != null
				&& ReadProperties.reportes.getProp( "reportes.tranferir" ).trim().equals( "1" ) )
			{
			try {
				//Se crea el stream del archivo
	 			final java.io.InputStream data =  new java.io.FileInputStream(  absoluteFileName );

	 			//Transferencia remota a traves de fabric
				LogHandler.info( uid, getClass(), "Inicia la transferencia FTP del archivo: " + absoluteFileName);
				transferenciaDatosFtp.transfiereDatos( RUTA_REMOTA + absoluteFileName.substring( RUTA_ARCHIVO.length() ), data );
				LogHandler.info( uid, getClass(), "Finaliz� la transferencia FTP del archivo: " + absoluteFileName );
				}
			catch ( java.lang.Exception exception )
				{
				LogHandler.error(uid, getClass(),"Fallo la transferencia del archivo: "
				+  absoluteFileName + " via FTP, debe realizarse manualmente.", exception );
				}
			}
	}


	}

