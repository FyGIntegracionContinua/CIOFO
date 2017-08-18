/**
 * Tensegrity - 2011
 */
package tarea.cheques;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import org.apache.ibatis.session.SqlSession;
import org.oasisopen.sca.annotation.Reference;

import tarea.comun.ComunTarea;
import utilitario.comun.asesores.AsesorOV;
import utilitario.log.LogHandler;
import utilitario.mensajes.comun.FechaContableOV;
import utilitario.mensajes.originacion.cheques.ChequesPeticion;
import utilitario.mensajes.originacion.cheques.ClienteChequesSICOV;
import utilitario.mensajes.originacion.cheques.ClientesChequesRespuesta;
import utilitario.mensajes.originacion.cheques.ContratoChequesSICOV;
import entidad.asesores.data.AsesorData;
import entidad.conexiones.FabricaConexiones;

/**
 * @author Juan Moreno
 * Implementacion del componenete Entity ChequesSIC.
 * <ul>
 *  <li></li>
 * </ul>
 */
public final class ChequesSICImpl implements ChequesSIC {


	/**
	 * Componente comun
	 */
	private ComunTarea comun;

	/** TRES */
	public static final Integer TRES	 		=	3;

	/**
	 * @param comun Fabric
	 */
	public ChequesSICImpl(@Reference(name = "comun") ComunTarea comun) {
		this.comun = comun;
	}

	/**
	 * @param uid identificador unico de transaccion
	 * @param peticion de consulta cheques contrato
	 * @return ContratoChequesSICOV
	 */
	public ContratoChequesSICOV consultaContratoChequesSIC( String uid, ChequesPeticion peticion) {
		String msg = "CONSULTA CONTRATO CHEQUES SIC.";
		SqlSession 				sesionNTx			= null;
		ContratoChequesSICOV	resultado			= null;
  		try {
  			sesionNTx 	= FabricaConexiones.obtenerSesionNTx();
  			//formateo de la fecha
  			//final SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );

  			LogHandler.trace(uid, getClass(), "==> consultaContratoChequesSIC - " + OPER_CONSULTA_CONTRATO_CHEQUES_SIC);
		 	resultado 	= (ContratoChequesSICOV)
		 			sesionNTx.selectOne( OPER_CONSULTA_CONTRATO_CHEQUES_SIC, peticion.getContrato() );

			if ( resultado == null  ) {
				throw new Exception( "Error al obtener los datos del contrato" );
			}

			FechaContableOV fechaContable = comun.obtenerFechaContable( uid );
			if ( fechaContable == null )
				{	throw new Exception( );				}

			resultado.setFecha( fechaContable.getFecha( ) );

			//Formato para la fecha
			String formDate7 =
					(new SimpleDateFormat("EEEE.dd.MMMM.yyyy", new Locale("es", "ES"))).format( fechaContable.getFecha() );
			resultado.setFechaLugar( (formDate7.split("[.]")[1] )
					+ ( Integer.parseInt( formDate7.split("[.]")[1]  )  == 1 ? " DIA" : " DIAS" )
					+  " DEL MES DE " + formDate7.toUpperCase().split("[.]")[2] + " DEL " + formDate7.split("[.]")[TRES] );
			resultado.setFechaLugar( resultado.getFechaLugar().toUpperCase() );

			final DecimalFormat  decimalFormat = new DecimalFormat( "0.00" );

			resultado.setMontoAprobado( new BigDecimal( decimalFormat.format( resultado.getMontoAprobado()) ));
			resultado.setMontoLiqCTrant( new BigDecimal( decimalFormat.format( resultado.getMontoLiqCTrant()) ));

			//Se recupera el nombre del asesor
			final AsesorOV asesorOV = AsesorData.obtenAsesor(uid, resultado.getAsesor().toString().trim() );
			if ( asesorOV != null) {
				resultado.setNomAsesor( asesorOV.getNombreCompleto() );
			}

			//Dirección de la sucursal sin caracteres especiales
			resultado.setSucursalDir(
					resultado.getSucursalDir()
					.replace( "//01" , "À" ).replace( "//02" , "È" ).replace( "//03" , "Ì" ).replace( "//04" , "Ò" )
					.replace( "//05" , "Ù" ).replace( "//06" , "Á" ).replace( "//07" , "É" ).replace( "//08" , "Í" )
					.replace( "//09" , "Ó" ).replace( "//10" , "Ú" ).replace( "//11" , "Â" ).replace( "//12" , "Ê" )
					.replace( "//13" , "Î" ).replace( "//14" , "Ô" ).replace( "//15" , "Û" ).replace( "//16" , "Ä" )
					.replace( "//17" , "Ë" ).replace( "//18" , "Ï" ).replace( "//19" , "Ö" ).replace( "//20" , "Ü" )
					.replace( "//21" , "à" ).replace( "//22" , "è" ).replace( "//23" , "ì" ).replace( "//24" , "ò" )
					.replace( "//25" , "ù" ).replace( "//26" , "á" ).replace( "//27" , "é" ).replace( "//28" , "í" )
					.replace( "//29" , "ó" ).replace( "//30" , "ú" ).replace( "//31" , "â" ).replace( "//32" , "ê" )
					.replace( "//33" , "î" ).replace( "//34" , "ô" ).replace( "//35" , "û" ).replace( "//36" , "ä" )
					.replace( "//37" , "ë" ).replace( "//38" , "ï" ).replace( "//39" , "ö" ).replace( "//40" , "ü" )
					.replace( "//41" , "Ñ" ).replace( "//42" , "ñ" ).replace( "//43" , "," ).replace( "//44" , "'" ) );

			//Sucursal si acento
			resultado.setSucursalDirSinAcento( resultado.getSucursalDir() );

			resultado.setMensaje( MENSAJE_OK  );
			resultado.setStatus( true );
  			}
  		catch ( Exception e ) {
 			if ( resultado == null ) {
 				resultado = new ContratoChequesSICOV();
 			}

			resultado.setMensaje( e.getCause() instanceof java.sql.SQLTimeoutException
						? MENSAJE_TIMEOUT + msg : MENSAJE_ERROR + msg );
			resultado.setStatus( false );
			LogHandler.error(uid, this.getClass(), "Existio un error en consultaContratoChequesSIC : " + e.getMessage(), e);
  			}
  		finally
  			{
			FabricaConexiones.close( sesionNTx );
			LogHandler.info(uid, this.getClass(), "ChequesSIC OK: " + resultado);
  			}

		return resultado;
	}


	/**
	 * @param uid identificador unico de la transaccion
	 * @param peticion de consulta cliente cheques
	 * @return ClientesChequesRespuesta consulta de los clientes para generar cheques
	 */
	@SuppressWarnings("unchecked")
	public ClientesChequesRespuesta consultaClientesChequesSIC( String uid, ChequesPeticion peticion) {
		String msg = "CONSULTA CLIENTES CHEQUES SIC.";
		SqlSession 	sesionNTx			= null;
		ClientesChequesRespuesta	resultado	= new ClientesChequesRespuesta();

	 	LogHandler.debug(uid, getClass(), "consultaContratoChequesSic contrato:" + peticion.getContrato() );
	 	resultado.getHeader().setUID(uid);
		try {
			sesionNTx 	= FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(), "==> consultaClientesChequesSIC - " + OPER_CONSULTA_CLIENTES_CHEQUES_SIC);
			List<ClienteChequesSICOV> lstResultado
			  = (List<ClienteChequesSICOV>) sesionNTx.selectList(  OPER_CONSULTA_CLIENTES_CHEQUES_SIC, peticion.getContrato() );
			if ( lstResultado == null  ) {
				throw new Exception( "Error la obtener la lista de clientes" );
			}

			//Formateo de monto
			final DecimalFormat decimalFormat = new DecimalFormat( "0.00" );
			for ( ClienteChequesSICOV clienteChequesSICOV : lstResultado ) {
				clienteChequesSICOV.setMonto( new BigDecimal(
						decimalFormat.format( clienteChequesSICOV.getMonto().doubleValue() ) ) );
				clienteChequesSICOV.setSaldoVigente( new BigDecimal( decimalFormat.format(
						clienteChequesSICOV.getSaldoVigente().doubleValue() ) ) );
			}

			resultado.setBody( (ClienteChequesSICOV[]) lstResultado.toArray( new ClienteChequesSICOV[0] ) );
			resultado.getHeader().setMensaje(msg);
			resultado.getHeader().setEstatus(true);

		} catch ( Exception e ) {
			FabricaConexiones.rollBack( sesionNTx );
			resultado.getHeader().setMensaje( e.getCause() instanceof java.sql.SQLTimeoutException
					? MENSAJE_TIMEOUT + msg : MENSAJE_ERROR + msg );
			resultado.getHeader().setEstatus(false);
			LogHandler.error(uid, this.getClass(), "Existio un error en consultaClientesChequesSIC: " + e.getMessage(), e);

		} finally {
			FabricaConexiones.close( sesionNTx );
			LogHandler.info(uid, getClass(), "consultaClientesChequesSIC Respuesta: " + resultado);
		}
		return resultado;
	}

 }

