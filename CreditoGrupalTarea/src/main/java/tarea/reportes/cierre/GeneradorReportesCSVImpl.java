package tarea.reportes.cierre;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.osoa.sca.annotations.Constructor;

import utilitario.comun.asesores.AsesorOV;
import utilitario.log.LogHandler;
import utilitario.mensajes.reportes.cierre.CarteraActivaOV;
import utilitario.mensajes.reportes.cierre.ContratosActivosMoraOV;
import utilitario.mensajes.reportes.cierre.ContratosActivosSaldoFavorOV;
import utilitario.mensajes.reportes.cierre.DesembolsoOpenContractOV;
import utilitario.mensajes.reportes.cierre.DesembolsoRepaymentsOV;
import utilitario.mensajes.reportes.cierre.DesembolsoSEFinsol1OV;
import utilitario.mensajes.reportes.cierre.DesembolsoSEFinsol2OV;
import utilitario.mensajes.reportes.cierre.TiposReporteCierre;
import entidad.asesores.data.AsesorData;

public class GeneradorReportesCSVImpl implements GeneradorReportesCSV {

 	@Constructor
	public GeneradorReportesCSVImpl(  ) {

	}


	public boolean generaReporteCSV (String uid,  TiposReporteCierre tipo , String path, String fileName  ) {
 		boolean resultado 	= true;
 		String[] encabezado	= null;
		try {
			if ( TiposReporteCierre.CARTERA_ACTIVA.equals(tipo) )
				encabezado = ENCABEZADO_CARTERA_ACTIVA;
			else if ( TiposReporteCierre.CONTRATOS_ACTIVOS_CON_MORA.equals(tipo) )
				encabezado = ENCABEZADO_CONTRATOS_ACTIVOS_CON_MORA;
			else if ( TiposReporteCierre.CONTRATOS_ACTIVOS_SALDO_FAVOR.equals(tipo) )
				encabezado = ENCABEZADO_CONTRATOS_ACTIVOS_CON_SALDO_FAVOR;
			else if ( TiposReporteCierre.DESEMBOLSO_OPEN_CONTRACT.equals(tipo) )
				encabezado = ENCABEZADO_DESEMBOLSO_OPEN_CONTRACT;
			else if ( TiposReporteCierre.DESEMBOLSO_REPAYMENTS.equals(tipo) )
				encabezado = ENCABEZADO_DESEMBOLSO_REPAYMENT;
			else if ( TiposReporteCierre.DESEMBOLOS_SE_FINSOL1.equals(tipo) )
				encabezado = ENCABEZADO_DESEMBOLSO_SE_FINSOL1;
			else if ( TiposReporteCierre.DESEMBOLOS_SE_FINSOL2.equals(tipo) )
				encabezado = ENCABEZADO_DESEMBOLSO_SE_FINSOL2;
			else if ( encabezado == null ) return false;

			fileName = path + fileName;
 			File archivo = new File(  fileName);
			if (archivo.exists() &&  !archivo.renameTo(new File(fileName + "." + System.currentTimeMillis()))) {
				resultado = false;
				throw new Exception();
			}
			FileWriter archivoSalida = new FileWriter( archivo );
    		for(String st : encabezado )//se agrega header segun tipo de reporte enviado
    			archivoSalida.append(st);
			archivoSalida.flush();
			archivoSalida.close();
      	} catch (Exception e) {
    		LogHandler.error(uid, getClass(),
    				"FALLO LA CREACION DEL CSV. EL DOCUMENTO YA EXISTE, CERRARLO Y ELIMINARLO: " + e.getMessage(), e);
    		e.printStackTrace();
    		resultado = false;
    	}
   		return resultado;
	}


	public synchronized boolean agregaRegistrosReporteCSVCarteraActiva(String uid, String path,
			String fileName, Date fechaCierre, List<CarteraActivaOV> listaCarteraActiva,
			Integer conteoRegistros, SqlSession sessionNTx )
		{
		boolean resultado  = true;
		try {
			fileName = path + fileName;
    		final File archivo = new File( fileName );
    			if ( archivo.exists() )
    				{
    				final FileWriter archivoSalida = new FileWriter( archivo,  true );

    				//final java.text.NumberFormat numberFormat  = new DecimalFormat(",###.00");

    				//Contador de registros
    				java.lang.Integer contador = 0;

    				//se agrega contenido de las celdas
    				for ( CarteraActivaOV carteraActivaOV : listaCarteraActiva )
    					{
    					try	{ //Podria fallar al procesar un registro, aun as� debe grabarse en el archivo
	    					//Tasa
	    					//carteraActivaOV.setTasa( Double.parseDouble( numberFormat.format( carteraActivaOV.getTasa() ) ) );

	    					//Asesores
	    					final AsesorOV
	    							asesor = AsesorData.obtenAsesor(uid, carteraActivaOV.getAsesor() );

	    					carteraActivaOV.setNombreAsesor( asesor != null
	    							? asesor.getNombreCompleto() : "ASESOR NO ENCONTRADO ");
	    					carteraActivaOV.setNoGrupo(carteraActivaOV.getClaveT24());
	    					archivoSalida.append( carteraActivaOV.toStringCSV( fechaCierre, uid, sessionNTx ) );
	    					//por cada OV se agregan sus campos separados por comas
    						}
    					catch ( java.lang.Exception exception )
    						{
    						archivoSalida.append( carteraActivaOV.toStringCSV( fechaCierre, uid, sessionNTx ) );
    						//por cada OV se agregan sus campos separados por comas
    						LogHandler.error(uid, getClass(), "Registro erroneo - "
    						+ carteraActivaOV.getNoContrato(), exception );
    						}
    					//Se muestra el porcentaje de avance
    					if ( ++contador % conteoRegistros == 0 )
    						{
    						LogHandler.info(uid , getClass(),"Procesados: " + ( contador )
    								+ " de: " + listaCarteraActiva.size() +" -- "
    								+  Math.round( ( ( contador ) * 100) / listaCarteraActiva.size() ) + " %");
    						}
    		    		}
    				archivoSalida.flush();
    				archivoSalida.close();
    				}
    			else
    				{
    				resultado = false;
    				}
    		} catch ( java.lang.Exception exception )
    			{
        		LogHandler.error(uid, getClass(),
        				"FALLO EL AGREGADO DE DATOS DEL CSV PARA CARTERA ACTIVA: " + exception.getMessage(), exception );
    			resultado = false;
    			}
		return resultado;
		} //fin de generarReporteCSVCarteraActiva



	public synchronized boolean agregaRegistrosReporteCSVContratosActivosSaldoAFavor(
			String uid, String path, String fileName, Date fechaCierre,
			List<ContratosActivosSaldoFavorOV> listaSaldoFavor ) {
		boolean resultado  = true;
		try {
			fileName = path + fileName;
    		File archivo = new File( fileName );
    			if ( archivo.exists() ) {
    				FileWriter archivoSalida = new FileWriter( archivo,  true );

    		    	//se agrega contenido de las celdas
    				for ( ContratosActivosSaldoFavorOV obj : listaSaldoFavor ) {
    					obj.setNumGrupo(obj.getClaveT24());
    					archivoSalida.append( obj.toStringCSV() ); //por cada OV se agregan sus campos separados por comas
    		    	}
    				archivoSalida.flush();
    				archivoSalida.close();

    			} else {
    				resultado = false;
    			}
    		} catch (Exception e) {
    			LogHandler.error(uid, getClass(),
    					"FALLO EL AGREGADO DE DATOS DEL CSV PARA CONTRATOS CON SALDO A FAVOR: " + e.getMessage(), e);
    			resultado = false;
    		}
		return resultado;
	}



	public synchronized boolean agregaRegistrosReporteCSVContratosActivosConMora(String uid,
			String path, String fileName, Date fechaCierre,
			List<ContratosActivosMoraOV> listaContratosActivosMora, Integer conteoRegistros ) {
 		boolean resultado  = true;
		try {
			fileName = path + fileName;
    		File archivo = new File( fileName );
    			if ( archivo.exists() ) {
    				FileWriter archivoSalida = new FileWriter( archivo,  true );

    				//Contador de registros
    				java.lang.Integer contador = 0;

   				   	//se agrega contenido de las celdas
    				for ( ContratosActivosMoraOV obj : listaContratosActivosMora )
    					{
    					try {
	    					//Tasa redondeada
	    					final java.text.NumberFormat numberFormat  = new DecimalFormat(",###.00");
	    					obj.setTasa( Double.parseDouble( numberFormat.format( obj.getTasa() ) ) );

	    					//Se obtiene el nombre del asesor
	    					AsesorOV asesor = AsesorData.obtenAsesor(uid,  obj.getAsesor() );
	    					obj.setNombreAsesor( asesor != null
	    							? asesor.getNombreCompleto() : " ASESOR NO ENCONTRADO ");
	    					obj.setNumGrupo(obj.getClaveT24());
	    					archivoSalida.append( obj.toStringCSV( fechaCierre ) );
	    					//por cada OV se agregan sus campos separados por comas
	    					}
    					catch ( java.lang.Exception exception )
							{
							archivoSalida.append( obj.toStringCSV( fechaCierre ) );
							//por cada OV se agregan sus campos separados por comas
							LogHandler.error(uid, getClass(), "Registro erroneo - " + obj.getContrato(), exception );
							}

    					//Se muestra el porcentaje de avance
    					if ( ++contador % conteoRegistros == 0 )
    						{
    						LogHandler.info(uid , getClass(), "Procesados: " + ( contador ) + " de: "
    						+ listaContratosActivosMora.size() + " -- "
    								+ Math.round( ( ( contador ) * 100) / listaContratosActivosMora.size() ) + " %");
    						}
    					}
    				archivoSalida.flush();
    				archivoSalida.close();

    			} else {
    				resultado = false;
    			}
    		} catch (Exception e) {
       			LogHandler.error(uid, getClass(),
       					"FALLO EL AGREGADO DE DATOS DEL CSV PARA CONTRATOS ACTIVOS CON MORA: " + e.getMessage(), e);
    			resultado = false;
    		}
		return resultado;
	}

	/*
	 * (non-Javadoc)
	 * @see tarea.reportes.cierre.GeneradorReportesCSV#agregaRegistrosReporteCSVDesembolsoOpenContract
	 * (java.lang.String, java.lang.String, java.lang.String, java.util.Date, java.util.List)
	 */

	public synchronized boolean agregaRegistrosReporteCSVDesembolsoOpenContract( String uid, String path,
			String fileName, Date fechaCierre, List<DesembolsoOpenContractOV> listaDesembolsoOpenContract) {

		boolean resultado  = true;
		try {
			fileName = path + fileName;
    		File archivo = new File( fileName );
    			if ( archivo.exists() ) {
    				FileWriter archivoSalida = new FileWriter( archivo,  true );
   				   	//se agrega contenido de las celdas
    				for ( DesembolsoOpenContractOV obj : listaDesembolsoOpenContract ) {
    					AsesorOV asesor = AsesorData.obtenAsesor(uid, obj.getAsesor() );
    					obj.setNombreAsesor( asesor != null ? asesor.getNombreCompleto() : " ASESOR NO ENCONTRADO ");
     					archivoSalida.append( obj.toStringCSV() ); //por cada OV se agregan sus campos separados por comas
    		    	}
    				archivoSalida.flush();
    				archivoSalida.close();

    			} else {
    				resultado = false;
    			}
    		} catch (Exception e) {
      			LogHandler.error(uid, getClass(),
      					"FALLO EL AGREGADO DE DATOS DEL CSV PARA DESEMBOLSO OPEN CONTRACT: " + e.getMessage(), e);
    			resultado = false;
    		}
		return resultado;
	}


	public synchronized boolean agregaRegistrosReporteCSVDesembolsoRepayment(String uid, String path,
			String fileName, Date fechaCierre, List<DesembolsoRepaymentsOV> listaDesembolsoRepayment) {

		boolean resultado  = true;
		try {
			fileName = path + fileName;
    		File archivo = new File( fileName );
    			if ( archivo.exists() ) {
    				FileWriter archivoSalida = new FileWriter( archivo,  true );
   				   	//se agrega contenido de las celdas
    				for ( DesembolsoRepaymentsOV obj : listaDesembolsoRepayment ) {
    					archivoSalida.append( obj.toStringCSV( fechaCierre ) );
    					//por cada OV se agregan sus campos separados por comas
    		    	}
    				archivoSalida.flush();
    				archivoSalida.close();

    			} else {
    				resultado = false;
    			}
    		} catch (Exception e) {
      			LogHandler.error(uid, getClass(),
      					"FALLO EL AGREGADO DE DATOS DEL CSV PARA DESEMBOLSO REPAYMENT: " + e.getMessage(), e);
    			resultado = false;
    		}
		return resultado;
	}



	public synchronized boolean agregaRegistrosReporteCSVDesembolsoSEFinsol1(String uid, String path, String fileName,
			Date fechaCierre, List<DesembolsoSEFinsol1OV> listaDesembolsoSEFinsol1, HashMap<String, Object> mapPagosCapital
			, HashMap<String, Object> mapPagosInteres, List<String> listContratosInvalidos) {
 		boolean resultado  = true;
		try {
			fileName = path + fileName;
    		File archivo = new File( fileName);
    			if ( archivo.exists() ) {
    				FileWriter archivoSalida = new FileWriter( archivo,  true );
   				   	//se agrega contenido de las celdas
    				for ( DesembolsoSEFinsol1OV obj : listaDesembolsoSEFinsol1 )
    					{
    					try {
    						if ( !listContratosInvalidos.contains( obj.getContrato() ))
	    						{
	    						obj.setPagadoCapital( mapPagosCapital.get( obj.getContrato() ) != null
	    								? Double.parseDouble( mapPagosCapital.get( obj.getContrato() ).toString() ) : 0 );
		    					obj.setPagadoInteres( mapPagosInteres.get( obj.getContrato() ) != null
		    							? Double.parseDouble( mapPagosInteres.get( obj.getContrato() ).toString() ) : 0 );
		    					obj.setNumGrupo(obj.getClaveT24());
		    					if ( obj.getPagadoCapital() != 0 ||  obj.getPagadoInteres() != 0 )
		    						{
		    						archivoSalida.append( obj.toStringCSV( fechaCierre ) );
		    						//por cada OV se agregan sus campos separados por comas
		    						}
	    						}
	    					}
    					catch ( Exception exception )
    						{
    						LogHandler.error(uid, getClass(), "FALLO AL SALVAR EL OBJETO : " + obj, exception);
    						}
    					}
    				archivoSalida.flush();
    				archivoSalida.close();

    			} else {
    				resultado = false;
    			}
    		} catch (IOException e) {
      			LogHandler.error(uid, getClass(), "FALLO EL AGREGADO DE DATOS DEL CSV PARA DESEMBOLSO SE_FINSOL1.", e);
    			resultado = false;
    		}
		return resultado;
	}



	public synchronized boolean agregaRegistrosReporteCSVDesembolsoSEFinsol2( String uid, String path, String fileName,
			Date fechaCierre, List<DesembolsoSEFinsol2OV> listaDesembolsoSEFinsol2, HashMap<String,Object> capitalMap,
			HashMap<String,Object> interesMap, HashMap<String,Object> moraMap ) {
		boolean resultado  = true;
		try {
			fileName = path + fileName;
    		File archivo = new File( fileName);
    			if ( archivo.exists() ) {
    				FileWriter archivoSalida = new FileWriter( archivo,  true );
   				   	//se agrega contenido de las celdas
    				for ( DesembolsoSEFinsol2OV obj : listaDesembolsoSEFinsol2 )
    					{
    					obj.setPagadoCapital(capitalMap.get( obj.getContrato() ) != null
    							? Double.parseDouble( capitalMap.get( obj.getContrato() ).toString() ) : 0 );
    					obj.setPagadoInteres(interesMap.get( obj.getContrato() ) != null
    							? Double.parseDouble( interesMap.get( obj.getContrato() ).toString() ) : 0 );
    					obj.setPagadoRecargos(moraMap.get( obj.getContrato() ) != null
    							? Double.parseDouble( moraMap.get( obj.getContrato() ).toString() ) : 0 );
    					obj.setNumGrupo(obj.getClaveT24());
    					archivoSalida.append( obj.toStringCSV( fechaCierre ) );
    					//por cada OV se agregan sus campos separados por comas
    					}
    				archivoSalida.flush();
    				archivoSalida.close();
    			} else {
    				resultado = false;
    			}
    		} catch (Exception e) {
      			LogHandler.error(uid, getClass(),
      					"FALLO EL AGREGADO DE DATOS DEL CSV PARA DESEMBOLSO SE_FINSOL2: " + e.getMessage(), e);
    			resultado = false;
    		}
		return resultado;
	}


}
