package tarea.comun;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.joda.time.DateTimeConstants;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.Minutes;
import org.oasisopen.sca.annotation.Scope;

import utilitario.log.LogHandler;
import utilitario.mensajes.chequescreditogrupal.ChequeOV;
import utilitario.mensajes.comun.FechaContableOV;
import utilitario.mensajes.comun.InteresOV;
import utilitario.mensajes.comun.ResultadoOV;
import utilitario.mensajes.originacion.consulta.ParGeneralOV;
import utilitario.mensajes.reportes.comun.CreditoGrupalOV;
import utilitario.mensajes.reportes.comun.ObtenerEstadoCuenta;
import utilitario.mensajes.solicitudes.DiasInhabilesOV;
import utilitario.mensajes.solicitudes.ReporteSolicitudesPeticion;
import utilitario.mensajes.solicitudes.SabadosLaboralesOV;
import entidad.conexiones.FabricaConexiones;

/**
 * @author out_jcmoreno
 *
 */
@Scope("COMPOSITE")
public class ComunTareaImpl implements ComunTarea {

	/** OPER_OBTENER_FECHACONTABLE */
	private static final String OPER_OBTENER_FECHACONTABLE 				= "obtenerFechaContable";
	/** OPER_OBTENER_FECHACONTABLE_SUCURSAL */
	private static final String OPER_OBTENER_FECHACONTABLE_SUCURSAL		= "obtenerFechaContablePorSucursal";
	/** FECHA */
	private static final String FECHA 									= "fecha";
	/** SUCURSAL */
	private static final String SUCURSAL 								= "sucursal";
	/**  Lista de objetos de par_general	 */
	private static ArrayList<ParGeneralOV> listaOVsParGen	= new ArrayList<ParGeneralOV>();
	/**  Mapa para los valores de cc_parametro par_general	 */
	private static Map<String, String> mapClavesParGen	= new LinkedHashMap<String, String>();
	/** formato de hora */
	private static final String FORMATO_ENTRADA_HORA = "HH:mm";
	static {
		//Valores par_general
 		recuperaValoresParGeneral();
 	}
	//private static final String CODIGO_IVA 								= "IVIN";

 	/**
 	 * Constructor simple
 	 */
 	public ComunTareaImpl(  ) {
	}

 	/**
 	 * Obetenemos la fecha contable sin sucursal
 	 * @param uid identificador unico
 	 * @return Fecha contable de la sucursal default 0
 	 */
	@SuppressWarnings("unchecked")
	public FechaContableOV obtenerFechaContable(String uid ) {
		SqlSession 		sesionNTx					= null;
		FechaContableOV	fechaContable				= new FechaContableOV();
		try	{
			sesionNTx 	= FabricaConexiones.obtenerSesionNTx( );
			LogHandler.trace(uid, getClass(), "==> obtenerFechaContable - " + OPER_OBTENER_FECHACONTABLE );
			final HashMap<String, Object> datosFechaContable
				= (HashMap<String, Object>) sesionNTx.selectOne(OPER_OBTENER_FECHACONTABLE, new Date( ) );
			String estatusCierre = datosFechaContable.get("EstatusCierre").toString();
			fechaContable.setEstatusCierre( estatusCierre != null && estatusCierre.length() > 0
					? Boolean.valueOf( estatusCierre ) : false );
			fechaContable.setFecha( (Date) datosFechaContable.get("FechaHoy"));
			LogHandler.debug( uid, getClass(), "datosFechaContable: " + datosFechaContable );
			}
		catch ( java.lang.Exception exception )	{
			LogHandler.error(uid, getClass(), "Ocurrio un error al obetener la fecha contable: "
					+ exception.getMessage(), exception);
			fechaContable = null;
			}
		finally
			{
			FabricaConexiones.close( sesionNTx );
			}
		return fechaContable;
	}

	/**
	 * Obtenemos la fecha contable de la sucursal enviada
	 * @param uid identificador unico
	 * @param sucursal de la peticion
	 * @return Fecha contable de la sucursal enviada
	 */
	@SuppressWarnings("unchecked")
	public FechaContableOV obtenerFechaContablePorSucursal( String uid, Integer sucursal ) {

		SqlSession 	sesionNTx						= null;
		FechaContableOV	fechaContable				= null;

		//Par�metros para la ejecucion del stores
		final java.util.HashMap<String, Object>
						params	= new HashMap<String, Object>();
						params.put(FECHA, new Date( ) );
						params.put(SUCURSAL, sucursal);

		try {
			sesionNTx 	= FabricaConexiones.obtenerSesionNTx( );
			LogHandler.trace(uid, getClass(), "==> obtenerFechaContablePorSucursal - " + OPER_OBTENER_FECHACONTABLE_SUCURSAL );
			final HashMap<String, Object> datosFechaContable
				= (HashMap<String, Object>) sesionNTx.selectOne( OPER_OBTENER_FECHACONTABLE_SUCURSAL, params );
			fechaContable = new FechaContableOV();
			fechaContable.setEstatusCierre(Boolean.valueOf(datosFechaContable.get("EstatusCierre").toString()) );
			fechaContable.setFecha( (Date) datosFechaContable.get("FechaHoy"));
			LogHandler.debug(uid, getClass(), "datosFechaContable: " + fechaContable );

		} catch ( Exception e ) {
			LogHandler.error(uid, getClass(), "ERROR AL obtenerFechaContablePorSucursal sucursal: " + sucursal , e);
			fechaContable = null;
		} finally {
			FabricaConexiones.close( sesionNTx );
		}
		return fechaContable;
	}

	/**
	 * @param uid identificador unico
	 * @param numeroCredito numero contrato
	 * @return numero de contrato
	 */
	public String obtenerNumeroContrato(String uid, String numeroCredito) {
		SqlSession sesion = null;
		String contrato = null;
		try {
			//Se abre la session en mybatis
			sesion = FabricaConexiones.obtenerSesionNTx();

			//Se ejecuta la consulta
			LogHandler.trace(uid, getClass(), "==> obtenerNumeroContrato - obtenerRelacionContrato");
			contrato = (String) sesion.selectOne("obtenerRelacionContrato", numeroCredito);
			}
		catch (java.lang.Exception exception) {
			LogHandler.error(uid, getClass(), "ERROR AL obtenerNumeroContrato numeroCredito: " + numeroCredito, exception);
			contrato = null;
		}
		finally {
			FabricaConexiones.close(sesion);
		}
		return contrato;
	}

	/**
	 * @param uid identificador unico
	 * @param numeroCredito numero contrato
	 * @return numero de contratoLD
	 */
	public String obtenerNumeroContratoLD(String uid, String numeroCredito) {
		SqlSession sesion = null;
		String contrato = null;
		try {
			//Se abre la session en mybatis
			sesion = FabricaConexiones.obtenerSesionNTx();

			//Se ejecuta la consulta
			LogHandler.trace(uid, getClass(), "==> obtenerNumeroContratoLD - obtenerRelacionContratoLD");
			contrato = (String) sesion.selectOne("obtenerRelacionContratoLD", numeroCredito);
			}
		catch (java.lang.Exception exception) {
			LogHandler.error(uid, getClass(), "ERROR AL obtenerNumeroContratoLD numeroCredito: " + numeroCredito, exception);
			contrato = null;
		}
		finally {
			FabricaConexiones.close(sesion);
		}
		return contrato;
	}

	/**
	 * @param uid identificador unico
	 * @param numeroCuenta numero de contrato
	 * @param seccion del estado de cuenta
	 * @return datos del estado de cuenta
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List storeEstadoCuenta(String uid, String numeroCuenta, ObtenerEstadoCuenta seccion) {

		LogHandler.debug(uid, this.getClass(), "124 Entrando a ComunTarea ==> storeEstadoCuenta, numeroCuenta = "
				+ numeroCuenta	+ ", Seccion (def. en la Enumeracion)= " + seccion.getSeccion());

		SqlSession sesionNTx 	= null; //consultas a la DB
		List movimientos 		= null;
 		String unidadEspecializada = null;
 		if (numeroCuenta == null) {
 			return null; //Valida que el numero de cuenta sea nulo
 		}
		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			if (!seccion.getSeccion().equals( ObtenerEstadoCuenta.UNIDAD_ESPECIALIZADA.getSeccion() ) ) {
					numeroCuenta = obtenerNumeroContrato(uid, numeroCuenta); //regresa num contrato
					LogHandler.debug(uid, this.getClass(), "contiene LD, numeroCuenta = " + numeroCuenta);
				if (numeroCuenta == null) {
					throw new Exception("El numero de cuenta es invalido.");
				}
				LogHandler.debug(uid, getClass(), "ComunTarea movimientos: " + seccion.getSeccion() + " " + numeroCuenta );
				LogHandler.trace(uid, getClass(), "==> storeEstadoCuenta - " + seccion.getSeccion());
				movimientos = (List<CreditoGrupalOV>) sesionNTx.selectList( seccion.getSeccion(), numeroCuenta );
			 	LogHandler.debug(uid, getClass(), "ComunTarea movimientos: " + movimientos );
			}
			else {
				LogHandler.debug(uid, getClass(), "Entrando a ComunTarea ==> storeEstadoCuenta, numeroCuenta = "
						+ numeroCuenta);
				unidadEspecializada = (String) sesionNTx.selectOne(seccion.getSeccion(), Integer.parseInt(numeroCuenta));
				if (unidadEspecializada != null) {
					movimientos = new java.util.ArrayList<String>();
					movimientos.add((String) unidadEspecializada);
				}
			}

			LogHandler.debug( uid, getClass(), "Obtiene info, movimientos = " + movimientos);
		} catch (Exception e) {
			LogHandler.error(uid, getClass(), "Error dentro de storeEstadoCuenta: " + e.getMessage(), e);
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return validaSeccion(uid, movimientos) ? movimientos : null;
	}

	/**
	 * @param uid identificador unico
	 * @param numeroCuenta numero de contrato
	 * @param seccion del estado de cuenta
	 * @return datos del estado de cuenta
	 * @throws Exception .
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List storeEstadoCuentaEx(String uid, String numeroCuenta, ObtenerEstadoCuenta seccion) throws Exception {

		LogHandler.debug(uid, this.getClass(), "124 Entrando a ComunTarea ==> storeEstadoCuenta, numeroCuenta = "
				+ numeroCuenta	+ ", Seccion (def. en la Enumeracion)= " + seccion.getSeccion());

		SqlSession sesionNTx 	= null; //consultas a la DB
		List movimientos 		= null;
 		String unidadEspecializada = null;
 		if (numeroCuenta == null) {
 			return null; //Valida que el numero de cuenta sea nulo
 		}
		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			if (!seccion.getSeccion().equals( ObtenerEstadoCuenta.UNIDAD_ESPECIALIZADA.getSeccion() ) ) {
					numeroCuenta = obtenerNumeroContrato(uid, numeroCuenta); //regresa num contrato
					LogHandler.debug(uid, this.getClass(), "contiene LD, numeroCuenta = " + numeroCuenta);
				if (numeroCuenta == null) {
					throw new Exception("El numero de cuenta es invalido.");
				}
				LogHandler.debug(uid, getClass(), "ComunTarea movimientos: " + seccion.getSeccion() + " " + numeroCuenta );
				LogHandler.trace(uid, getClass(), "==> storeEstadoCuenta - " + seccion.getSeccion());
				movimientos = (List<CreditoGrupalOV>) sesionNTx.selectList( seccion.getSeccion(), numeroCuenta );
			 	LogHandler.debug(uid, getClass(), "ComunTarea movimientos: " + movimientos );
			}
			else {
				LogHandler.debug(uid, getClass(), "Entrando a ComunTarea ==> storeEstadoCuenta, numeroCuenta = "
						+ numeroCuenta);
				unidadEspecializada = (String) sesionNTx.selectOne(seccion.getSeccion(), Integer.parseInt(numeroCuenta));
				if (unidadEspecializada != null) {
					movimientos = new java.util.ArrayList<String>();
					movimientos.add((String) unidadEspecializada);
				}
			}

			LogHandler.debug( uid, getClass(), "Obtiene info, movimientos = " + movimientos);
		} catch (Exception e) {
			LogHandler.error(uid, getClass(), "Error dentro de storeEstadoCuenta: " + e.getMessage(), e);
			throw new Exception("No fue posible obtener stEstadoCuenta debido a :  " + e.getMessage());
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return validaSeccion(uid, movimientos) ? movimientos : null;
	}
	/**
	 * @param uid identificador unico
	 * @param numeroCuenta  numero de contrato
	 * @param seccion del estado de cuenta
	 * @param muestraCancelaciones del estado de cuenta
	 * @return datos del estado de cuenta
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List storeEstadoCuentaDetalle(String uid, String numeroCuenta,
			String muestraCancelaciones, ObtenerEstadoCuenta seccion) {

		SqlSession sesionNTx 	= null; //consultas a la DB
		List movimientos 		= null;
 		String unidadEspecializada = null;
 		if (numeroCuenta == null) {
 			return null; //Valida que el numero de cuenta sea nulo
 		}
		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();

			if (!seccion.getSeccion().equals( ObtenerEstadoCuenta.UNIDAD_ESPECIALIZADA.getSeccion() ) ) {

					numeroCuenta = obtenerNumeroContrato(uid, numeroCuenta); //regresa num contrato
					LogHandler.debug(uid, this.getClass(), "contiene LD, numeroCuenta = " + numeroCuenta);


				if (numeroCuenta == null || muestraCancelaciones == null) {
					throw new Exception("El numero de cuenta es invalido.");
				}
				final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
				parametros.put( "numeroCuenta" , numeroCuenta );
				parametros.put( "muestraCancelaciones" , muestraCancelaciones );
				LogHandler.debug(uid, getClass(), "ComunTarea movimientos: " + seccion.getSeccion() + " " + numeroCuenta );
				LogHandler.trace(uid, getClass(), "==> storeEstadoCuenta - " + seccion.getSeccion());
				movimientos = (List<CreditoGrupalOV>) sesionNTx.selectList( seccion.getSeccion(), parametros );
			 	LogHandler.debug(uid, getClass(), "ComunTarea movimientos: " + movimientos );
			}
			else
				{
				final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
				parametros.put( "numeroCuenta" , numeroCuenta );
				parametros.put( "muestraCancelaciones" , muestraCancelaciones );

				LogHandler.debug(uid, getClass(), "Entrando a ComunTarea ==> storeEstadoCuenta, numeroCuenta = " + numeroCuenta);
				unidadEspecializada = (String) sesionNTx.selectOne(seccion.getSeccion(), parametros);
				if (unidadEspecializada != null)
					{
					movimientos = new java.util.ArrayList<String>();
					movimientos.add((String) unidadEspecializada );
					}
				}
//			movimientos = sesion.selectList(seccion.getSeccion(), numeroCuenta);
			LogHandler.debug( uid, getClass(), "Obtiene info, movimientos = " + movimientos);
		} catch (Exception e) {
			LogHandler.error(uid, getClass(), "Error dentro de storeEstadoCuenta: " + e.getMessage(), e);
		} finally {
			FabricaConexiones.close(sesionNTx);
		}
		return validaSeccion(uid, movimientos) ? movimientos : null;
	}

	/**
	 * @param uid identificador unico
	 * @param informacion lista de movimientos
	 * @return valida que la lista no sea vacia
	 */
	@SuppressWarnings("rawtypes")
	private boolean validaSeccion(String  uid, List informacion) {
		boolean correcto = false;
		if (informacion != null && !informacion.isEmpty()) {
			LogHandler.debug(uid, this.getClass(), "validaSeccion" + informacion.size());
			if (informacion.get(0) == null) {
					LogHandler.debug(uid, this.getClass(), "==>movs.get(0) = null " );
			}
			else {
				LogHandler.debug(uid, this.getClass(), "validaSeccion" + informacion.get(0).getClass( ));
				correcto = true;
			}
		}
		return correcto;
	}

	/**
	 * Ejecuta el store que abre la caja para realizar la operacion necesaria
	 * @param uid identificador unico
	 * @param sucursal  de la peticion
	 * @param fechaContable del core
	 * @return resultado de abrir la caja
	 */
	public ResultadoOV aperturaCaja(String uid, int sucursal, Date fechaContable) {
		SqlSession sesion = null;
		ResultadoOV apertura = null;
		try {
			sesion = FabricaConexiones.obtenerSesionNTx();
			final HashMap<String, Object> map = new HashMap<String, Object>();
			final java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
			map.put("sucursal", sucursal);
			map.put("fechaContable", formatter.format( fechaContable));
			LogHandler.debug(uid, getClass(), "sucursal: " + sucursal);
			LogHandler.debug(uid, getClass(), "fechaContable:" + formatter.format( fechaContable));

			LogHandler.trace(uid, getClass(), "==> aperturaCaja - aperturaCaja");
			apertura = (ResultadoOV) sesion.selectOne("aperturaCaja", map);
			LogHandler.debug(uid, getClass(), "apertura: " + apertura);
		} catch (Exception e) {
			apertura = new ResultadoOV();
			apertura.setCodigoRetorno( -1 );
 			LogHandler.error(uid, getClass(), "ERROR en aperturaCaja sucursal: " + sucursal
 					+ " fechaContable: " + fechaContable + " - " + e.getMessage(), e);
		} finally {
			FabricaConexiones.close( sesion );
		}
		return apertura;
	}

	/**
	 * @param uid identificador unico
	 * @param sucursal  de la peticion
	 * @param fechaContable del core
	 * @return id de la transaccion de la caja
	 */
	public Integer obtenerIdTransaccion(String uid, int sucursal, Date fechaContable) {
		Integer 	res		=	null;
		SqlSession sesion 	= 	null;
		try {
			sesion = FabricaConexiones.obtenerSesionNTx();
			final HashMap<String, Object> map = new HashMap<String, Object>();
			final java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
			map.put("sucursal", sucursal);
			map.put("fechaContable", formatter.format( fechaContable));
			LogHandler.debug(uid, getClass(), "sucursal " + sucursal);
			LogHandler.debug(uid, getClass(), "fechaContable " + formatter.format( fechaContable));
			LogHandler.trace(uid, getClass(), "==> obtenerIdTransaccion - obtenerIdTransaccion ");
			res = (Integer) sesion.selectOne("obtenerIdTransaccion", map);
		} catch (Exception e) {
 			LogHandler.error(uid, getClass(), "ERROR en obtenerIdTransaccion sucursal: " + sucursal
 					+ " fechaContable: " + fechaContable, e);
		} finally {
			FabricaConexiones.close( sesion );
		}

		return res;
	}

	/**
	 * Obtiene los datos de la tasa del contrato como son:
	 * @param contrato FISA
	 * @param uid identificador unico
	 * @return HashMap con los valores de loscampos antes mencionados.
	 */
	@SuppressWarnings({ "unchecked" })
	public HashMap<String, Object> obtenerDatosGeneralesContrato(String uid, String contrato)
		{
		SqlSession sesionNTx = null;
		HashMap<String, Object> datosContrato = null;
		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx( );
			// 	Obtener info del contrato
			// los datos que se obtienen son: fecha_prim_venc, sucursal, monto, tasa,
			// no_pagos, frecuencia_pago, monto_pago
			LogHandler.trace(uid, getClass(), " ==> obtenerDatosGeneralesContrato  - obtenerDatosGeneralesContrato");
			datosContrato = (HashMap<String, Object>) sesionNTx.selectOne("obtenerDatosGeneralesContrato", contrato);
		} catch (Exception e) {
 			LogHandler.error(uid, getClass(), "ERROR en obtenerDatosGeneralesContrato contrato: " + contrato, e);
		} finally {
			FabricaConexiones.close( sesionNTx );
		}
		return datosContrato;
		}

	/**
	 * Obtiene los datos de la tasa del contrato como son:
	 * @param contrato FISA
	 * @param uid identificador unico
	 * @return HashMap con los valores de loscampos antes mencionados.
	 */
	@SuppressWarnings({ "unchecked" })
	public HashMap<String, Object> obtenerDatosGeneralesContratoSimple(String uid, String contrato)
		{
		SqlSession sesionNTx = null;
		HashMap<String, Object> datosContrato = null;
		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx( );
			// 	Obtener info del contrato
			// los datos que se obtienen son: fecha_prim_venc, sucursal, monto, tasa,
			// no_pagos, frecuencia_pago, monto_pago
			LogHandler.trace(uid, getClass(), " ==> obtenerDatosGeneralesContrato  - obtenerDatosGeneralesContrato");
			datosContrato = (HashMap<String, Object>) sesionNTx.selectOne("obtenerDatosGeneralesContratoSimple", contrato);
		} catch (Exception e) {
 			LogHandler.error(uid, getClass(), "ERROR en obtenerDatosGeneralesContrato contrato: " + contrato, e);
		} finally {
			FabricaConexiones.close( sesionNTx );
		}
		return datosContrato;
		}
	/**
	 * Obtiene datos del contrato, con una session dada, sea transaccional o no
	 * @param uid identificador unico
	 * @param contrato FISA
	 * @param sessionTx de la base de datos
	 * @return la coleccion de los datos del contrato
	 */
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> obtenerDatosGeneralesContrato(String uid, String contrato, SqlSession sessionTx)
		{
		HashMap<String, Object> datosContrato = null;
		try {
			// 	Obtener info del contrato
			LogHandler.trace(uid, getClass(), " ==> obtenerDatosGeneralesContrato  - obtenerDatosGeneralesContrato");
			datosContrato = (HashMap<String, Object>) sessionTx.selectOne("obtenerDatosGeneralesContrato", contrato);
		} catch (Exception e) {
 			LogHandler.error(uid, getClass(), "ERROR en obtenerDatosGeneralesContrato contrato: " + contrato, e);
			}
		return datosContrato;
		}

	/**
	 * Obtiene datos del contrato, con una session dada, sea transaccional o no
	 * @param uid identificador unico
	 * @param contrato FISA
	 * @param sessionTx de la base de datos
	 * @return la coleccion de los datos del contrato
	 */
	@SuppressWarnings("unchecked")
	public HashMap<String, Object> obtenerDatosGeneralesContratoSimple(String uid, String contrato, SqlSession sessionTx)
		{
		HashMap<String, Object> datosContrato = null;
		try {
			// 	Obtener info del contrato
			LogHandler.trace(uid, getClass(), " ==> obtenerDatosGeneralesContrato  - obtenerDatosGeneralesContrato");
			datosContrato = (HashMap<String, Object>) sessionTx.selectOne("obtenerDatosGeneralesContratoSimple", contrato);
		} catch (Exception e) {
 			LogHandler.error(uid, getClass(), "ERROR en obtenerDatosGeneralesContrato contrato: " + contrato, e);
			}
		return datosContrato;
		}

	/**
	 * Regresa la categoria del producto solicitado
	 * @param uid identificador unico
	 * @param producto del contrato
	 * @return Descripcion de la categoria del producto
	 */
	public String obtenerCategoria(String uid, String producto) {
		String categoria = null;
		SqlSession sesionNTx = null;
		try {
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(), " ==> obtenerCategoria - obtenerCategoriaProducto" );
			categoria  = (String) sesionNTx.selectOne( "obtenerCategoriaProducto", producto );
			if ( categoria == null ) {
				throw new Exception(" NO SE PUDO OBTENER LA CATEGORIA DEL PRODUCTO: " + producto );
			}
		} catch ( Exception e ) {
 			categoria = null;
 			LogHandler.error(uid, getClass(), "ERROR en obtenerCategoria producto: " + producto + " - " + e.getMessage(), e);
		}
		finally {
			FabricaConexiones.close( sesionNTx );
		}
		return categoria;
	}

	/**
	 * Calcula El interes total que se pagar� por un credito
	 * @param uid identificador unico
	 * @param numeroContrato FISA
	 * @return el interes total
	 */
	public Double calcularInteresTotalCredito(String uid, String numeroContrato) throws Exception {
		//Double interesesPeriodo = null;
		Double interesTotalCredito =  0D;
		//Valdia datos de entrada
		if (numeroContrato == null ) {
			throw new Exception( ReadProperties.mensajes.getProp( "ciof.contratoinvalido" ));
		}
		try {
			final HashMap<String, Object> datosCredito = obtenerDatosGeneralesContrato( uid, numeroContrato );

			interesTotalCredito = Double.valueOf( datosCredito.get( "interes_total" ).toString() )
					+ Double.valueOf( datosCredito.get( "iva_interes_total" ).toString() );

			LogHandler.debug(uid, this.getClass(), "----------interesTotalCredito=" + interesTotalCredito);
		} catch ( java.lang.Exception exception ) {
 			LogHandler.error(uid, getClass(), "ERROR en calcularInteresTotalCredito numeroContrato: "
 					+ numeroContrato + " - " + exception.getMessage(), exception);
			throw exception;
		}

		return interesTotalCredito;
		}

	/**
 	 * Obtenemos la fecha actual de la BD
 	 * @param uid identificador unico
 	 * @return Fecha actual
 	 */
	public Date obtenerFechaActual(String uid) {
		SqlSession 	sesionNTx 	= null;
		Date		fechaActual	= null;
		try {
			sesionNTx 	= FabricaConexiones.obtenerSesionNTx( );
			LogHandler.trace(uid , getClass(), " ==> obtenerFechaActual - obtenerFechaActual" );
			fechaActual = (Date) sesionNTx.selectOne( "obtenerFechaActual" );
		} catch ( java.lang.Exception exception ) {
			LogHandler.error(uid, getClass(), "Ocurrio un error al obetener la fecha actual de la BD", exception);
			fechaActual = null;
		} finally {
			FabricaConexiones.close( sesionNTx );
		}
		return fechaActual;
	}

	/**
	 * A partir de un n�mero de contrato se obtiene el estatus del mismo
	 * @param uid identificador unico
	 * @param contrato numero de contrato para comprobar
	 * @return estatus del credito
	 */
	public String obtenerEstatusCredito(String uid, String contrato) {
		SqlSession 	sesionNTx 	= null;
		String statusContrato   = null;
		try {
			sesionNTx 	= FabricaConexiones.obtenerSesionNTx( );

			LogHandler.trace(uid, getClass(), "==> obtenerEstatusCredito - obtenerEstatusContrato" );
			statusContrato = (String) sesionNTx.selectOne( "obtenerEstatusContrato", contrato );
			}
		catch ( java.lang.Exception exception ) {
			LogHandler.error(uid, getClass(), "Ocurrio un error al obtener el estatus de contrato de la BD..."
					+ exception.getMessage(), exception);
			}
		finally
			{
			FabricaConexiones.close( sesionNTx );
			}
		return statusContrato;

		}

	/**
	 * Obtiene la relacion entre el numero de persona o el numero t24
	 * @param uid identificador unico
	 * @param cliente numero
	 * @return numero de cliente de la persona
	 */
	public String obtenerPersonaCliente(String uid, String cliente) {
		SqlSession 	sesionNTx 	= null;
		String 	persona = "";
		try {
			sesionNTx 	= FabricaConexiones.obtenerSesionNTx( );
			LogHandler.trace(uid, getClass(), "==> obtenerPersonaCliente - obtenerContratoCliente" );
			final Object personaList = sesionNTx.selectOne( "obtenerContratoCliente",  cliente );

			//Cambio, si no trae clave persona de la consulta, quiere decir que ya teniamos la clave persona
			persona =  personaList != null ? personaList.toString() : "";
			}
		catch ( java.lang.Exception exception) {
			LogHandler.error(uid, getClass(), "No se pudo verificar la clave del cliente:" + exception.getMessage(), exception);
			persona = "";
			}
		finally {
			FabricaConexiones.close( sesionNTx );
			}

		return persona;
	}

	/**
	 * Obtiene la relacion entre el numero de persona o el numero t24
	 * @param uid identificador unico
	 * @param cliente numero
	 * @param sesionExterna tipo {@link SqlSession}
	 * @return numero de cliente de la persona
	 */
	public String obtenerPersonaCliente(String uid, String cliente, SqlSession sesionExterna) {
		SqlSession 	sesionNTx 	= null;
		String 	persona = "";
		try {
			if (sesionExterna == null) {
				sesionNTx 	= FabricaConexiones.obtenerSesionNTx( );
			} else {
				sesionNTx = sesionExterna;
			}
			LogHandler.trace(uid, getClass(), "==> obtenerPersonaCliente - obtenerContratoCliente" );
			final Object personaList = sesionNTx.selectOne( "obtenerContratoCliente",  cliente );

			//Cambio, si no trae clave persona de la consulta, quiere decir que ya teniamos la clave persona
			persona =  personaList != null ? personaList.toString() : "";
			}
		catch ( java.lang.Exception exception) {
			LogHandler.error(uid, getClass(), "No se pudo verificar la clave del cliente:" + exception.getMessage(), exception);
			persona = "";
			}
		finally {
			if (sesionExterna == null) {
				FabricaConexiones.close( sesionNTx );
			}
		}

		return persona;
	}

	/**
	 * Funcion para verificar si el cotnrato y sucursal coinciden
	 * @param uid identificador unico
	 * @param params parametros de busqueda
	 * @return si el contrato pertenece a la sucursal
	 */
	public Boolean comprobarContratoSucursal(java.lang.String uid, HashMap<String, Object> params) {
		SqlSession sessionNTx = null;
		try {
			if ( params.get( "contrato" ) == null || params.get( "sucursal" ) == null) {
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.datos.incompletos" ) );
			}
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			LogHandler.trace(uid, getClass(), "comprobarContratoSucursal - comprobarSucursalContrato");
			final String respuesta = (String) sessionNTx.selectOne( "comprobarSucursalContrato", params );

			//Se valida que el resultado de la consulta no sea nulo ni vacio
			if ( respuesta == null || respuesta.trim().equals( "" )) {
				throw new Exception( ReadProperties.mensajes.getProp( "reportes.obtenerestadocuenta.errorcontratosucursal" ));
			}
			return true;
		}
		catch ( java.lang.Exception exception ) {
			LogHandler.error(uid, getClass(), exception.getMessage(), exception);
			return false;
		}
		finally {
			FabricaConexiones.close( sessionNTx );
			}
		}

	/**
	 * Funcion general para el calculo de intereses totales de un contrato, llamando un store
	 * @param uid identificador unico
	 * @param interesOV recibe el interes
	 * @return el calculo del interes total
	 */
	@SuppressWarnings("unchecked")
	public InteresOV calcularInteresTotal(String uid, InteresOV interesOV) {
		//Objeto para la conexion
		SqlSession sessionNTx = null;

		try {
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			LogHandler.trace(uid, getClass(), "==> calcularInteresTotal - calcularInteresIvaTotal ");
			final HashMap<String, Object> intereses
				= (HashMap<String, Object>) sessionNTx.selectOne( "calcularInteresIvaTotal", interesOV );

			//Se valida la ejecucion correcta del store
			if ( intereses.get( "interes_total" ) == null && intereses.get( "iva_interes_total" ) == null ) {
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.proceso.error.calculointeres" ) );
			}

			//Asignacion de la respuesta
			interesOV.setInteresTotal( intereses.get( "interes_total" ) == null
					? 0D : Double.valueOf( intereses.get( "interes_total" ).toString().trim() ));
			interesOV.setIvaInteresTotal( intereses.get( "iva_interes_total" ) == null
					? 0D : Double.valueOf( intereses.get( "iva_interes_total" ).toString().trim() ) );
			interesOV.getHeader().setEstatus( true );
			}
		catch ( java.lang.Exception exception )
			{
			LogHandler.error(uid, getClass(), exception.getMessage(), exception);
			interesOV.getHeader().setEstatus( false );
			interesOV.getHeader().setMensaje( exception.getMessage() );
			}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return interesOV;
		}

	/**
	 * Recalcula el porcentaje de participacion de los integrantes del contrato
	 * en caso de haber tenido algun cambio en los montos, esto es en integrante_grupo
	 * @param uid identificador unico
	 * @param contrato FISA
	 * @param sessionTx de la base de datos
	 * @return el resultado de la actualizacion del porcentaje de particiapacion
	 */
	@SuppressWarnings("unchecked")
	public Boolean actualizarPorcentajeParticipacionIntegrante(String uid, SqlSession sessionTx, String contrato) {
		//Respuesta
		java.lang.Boolean operacionExitosa = true;

		try {
			LogHandler.trace(uid, getClass(),
					"==> actualizarPorcentajeParticipacionIntegrante - calcularPorcentajeParcipacionIntegrantes ");
			final HashMap<String, Object> resultado
				= (HashMap<String, Object>) sessionTx.selectOne( "calcularPorcentajeParcipacionIntegrantes", contrato );

			if ( resultado.get( "resultado" ) == null || !resultado.get( "resultado" ).toString().trim().equals( "0" ) )
				{	operacionExitosa = false;			}
			}
		catch ( java.lang.Exception exception ) {
			LogHandler.error(uid, getClass(), exception.getMessage(), exception);
			operacionExitosa = false;
			}
		return operacionExitosa;
		}

	/**
	 * Verifica si una persona existe
	 * @param uid identificador unico
	 * @param clavePersona el numero o clave de persona
	 * @return si existe el cliente
	 */
	public Boolean existeCliente(String uid, String clavePersona) {
		//Respuesta
		java.lang.Boolean operacionExitosa = true;

		//Session Mybatis
		SqlSession sessionTx = null;
		try {
			//Obtenemos la session
			sessionTx = FabricaConexiones.obtenerSesionNTx();

			LogHandler.trace(uid, getClass(), "==> existeCliente - existeCliente");
			final java.lang.Integer resultado = (Integer) sessionTx.selectOne( "existeCliente", clavePersona );

			if ( resultado == null || resultado != 1 )
				{	operacionExitosa = false;			}
			}
		catch ( java.lang.Exception exception )
			{
			LogHandler.error(uid, getClass(), exception.getMessage(), exception);
			operacionExitosa = false;
			}
		finally {
			FabricaConexiones.close(sessionTx);
		}
		return operacionExitosa;
		}

	/**
	 * @param fecha para calcular la edad de alguien
	 * @return edad
	 */
	public  int calcularEdad(Date fecha) {
		try {
		Calendar birth = new GregorianCalendar();
		Calendar today = new GregorianCalendar();
		int age = 0;
		int factor = 0;
		Date birthDate = fecha;
		Date currentDate = new Date(); //current date
		birth.setTime(birthDate);
		today.setTime(currentDate);
		if (today.get(Calendar.MONTH) <= birth.get(Calendar.MONTH)) {
		if (today.get(Calendar.MONTH) == birth.get(Calendar.MONTH)) {
		if (today.get(Calendar.DATE) < birth.get(Calendar.DATE)) {
		factor = -1; //Aun no celebra su cumpleaÃ±os
		}
		} else {
		factor = -1; //Aun no celebra su cumpleaÃ±os
		}
		}
		age = (today.get(Calendar.YEAR) - birth.get(Calendar.YEAR)) + factor;
		return age;
		} catch (Exception e) {
		return -1;
		}

	}

	/**
	 * Verifica si una persona existe
	 * @param uid identificador unico
	 * @param clave de la tabla par_general
	 * @return si existe el cliente
	 * @throws Exception propaha la excepcion del error para las capas superiores.
	 */
	public String obtenerParGeneral(String uid, String clave) throws Exception {

		String valorParGral 	= null;
		String claveParGral 	= null;

			try {

				//Si no hay datos cargados se cargan
				if ( mapClavesParGen.size() == 0 ) {

					recuperaValoresParGeneral();

				} else {

					Iterator<String> keys	= mapClavesParGen.keySet( ).iterator( );
					while ( keys.hasNext( ) ) {
						claveParGral = keys.next();
						//LogHandler.trace(uid, getClass(), "claveParGral >> " + claveParGral);
						if (clave.equals(claveParGral) ) {
							valorParGral = mapClavesParGen.get( claveParGral );
							LogHandler.trace(uid, getClass(), "valorParGral >> " + valorParGral);
							break;
						}
					}

				}

			} catch ( java.lang.Exception exception ) {
	 			LogHandler.error(null, ComunTarea.class, "Error al momento de cargar lista valores par_general", exception );
	 		}

			return valorParGral;
	}

	/**
	 * @param uid identificador unico
	 * @param clave de la tabla par_general
	 * @return OV de par_general
	 * @throws Exception propaga la excepcion del error para las capas superiores.
	 */
	public ParGeneralOV obtenerParGeneralOV(String uid, String clave) throws Exception {

		ParGeneralOV valorParGral = new ParGeneralOV();
		ParGeneralOV claveParGral = new ParGeneralOV();
		boolean existe = false;
			try {

				//Si no hay datos cargados se cargan
				if ( listaOVsParGen.size() == 0 ) {
					LogHandler.info(uid, getClass(), "La lista esta vacia recuperaValoresParGeneral " + clave);
					recuperaValoresParGeneral();

				}

				Iterator<ParGeneralOV> parGeneralOv	= listaOVsParGen.iterator( );
				while ( parGeneralOv.hasNext( ) ) {
					claveParGral = parGeneralOv.next();
					//LogHandler.trace(uid, getClass(), "claveParGral >> " + claveParGral);
					if (clave.equals(claveParGral.getCcParametro()) ) {
						valorParGral = claveParGral;
						LogHandler.trace(uid, getClass(), "clave[" + clave + "] Valor[" + valorParGral.getCgValor() + "]");
						existe = true;
						break;
					}
				}

				if (!existe) {
					throw new Exception("No se encontro el valor para la variable [" + clave + "]");
				}

			} catch ( java.lang.Exception exception ) {
	 			LogHandler.error(uid, ComunTarea.class, "Error al momento de cargar lista OVs par_general", exception );
	 			throw exception;
	 		}

			return valorParGral;
	}

 	/**
 	 * Metodo para recuperar lista de valores par_general
 	 *  en un mapa (cg_valor para cc_parametro)
 	 */
	private static void recuperaValoresParGeneral() {

		SqlSession 	sesionNTx = null;

		try	{

			//Recuperamos los valores
		  	sesionNTx	 = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace("MAPPER", ComunTarea.class, "==> recuperaValoresParGeneral - obtenerParGeneralValor");

			@SuppressWarnings("unchecked")
			final ArrayList<ParGeneralOV>	lstParGeneral
				= (ArrayList<ParGeneralOV>) sesionNTx.selectList( "obtenerParGeneralValor" );

			if ( lstParGeneral == null || lstParGeneral.size() <= 0 ) {
				throw new Exception("No se pudo recuperar la lista de valores par general: " );
			}

			// lista de valores par_general OV
			listaOVsParGen = lstParGeneral;
			//Se recupera una lista, con valores de codigos y nombres,
			//se deben iterar y crear un mapa para su manipulacion
			for (ParGeneralOV parGeneral : lstParGeneral ) {
					mapClavesParGen.put( parGeneral.getCcParametro(),
							parGeneral.getCgValor());
					LogHandler.trace("MAPPER", ComunTarea.class, "==> obtenerClavesParGeneral - cc_parametro: "
								+ parGeneral.getCcParametro() + " cg_valor: "
								+ parGeneral.getCgValor());
				}


		} catch ( java.lang.Exception exception ) {
 			LogHandler.error(null, ComunTarea.class, "Error al momento de cargar los valores par_general", exception );
 			}
 		finally
			{
			FabricaConexiones.close( sesionNTx);
			}
	}

	/**
	 * Funcion para obtener el contrato por medio de una solicitud
	 * @param uid identificador unico
	 * @param solicitud tipo String
 	 * @return el contrato
	 */
	public String obtenerContratoPorSolicitud(String uid, String solicitud) {

		SqlSession sessionNTx = null;

		try {
			if ( solicitud == null) {
				throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.datos.incompletos" ) );
			}
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			LogHandler.trace(uid, getClass(), "ObtenerContratoPorSolicitud - ObtenerContratoPorSolicitud");
			final String respuesta = (String) sessionNTx.selectOne( "ObtenerContratoPorSolicitud", solicitud );

			//Se valida que el resultado de la consulta no sea nulo ni vacio
			if ( respuesta == null || respuesta.trim().equals( "" )) {
				throw new Exception( ReadProperties.mensajes.getProp( "reportes.obtenerestadocuenta.errorcontratosucursal" ));
			}
			return respuesta;
		}
		catch ( java.lang.Exception exception ) {
			LogHandler.error(uid, getClass(), exception.getMessage(), exception);
			return null;
		}
		finally {
			FabricaConexiones.close( sessionNTx );
			}
		}
	/**
 	 * Metodo para recuperar la lista de dias Inhabiles
 	 *  @param uid Identificador
 	 *  @param sucursal # para obtener el calendario de la sucursal
 	 *  @return ArrayList<DiasInhabilesOV> lista de posibles dias inhabiles
 	 */
	public ArrayList<DiasInhabilesOV> obtenerDiasInhabiles(final String uid, final int sucursal) {

		SqlSession 	sesionNTx = null;

		try	{

			//Recuperamos los valores
		  	sesionNTx	 = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace("MAPPER", ComunTarea.class, "==> obtenerDiasInhabiles - obtenerDiasInhabiles");

			@SuppressWarnings("unchecked")
			final ArrayList<DiasInhabilesOV>	fechas
				= (ArrayList<DiasInhabilesOV>) sesionNTx.selectList( "obtenerDiasInhabiles", sucursal );

			if ( fechas == null || fechas.size() <= 0 ) {
				throw new Exception("No se pudo obtener los dias no laborales: " );
			}

			return fechas;

		} catch ( java.lang.Exception exception ) {
 			LogHandler.error(uid, ComunTarea.class, "Error al momento de cargar los valores obtenerDiasInhabiles", exception );
 			return null;
 		} finally {
			FabricaConexiones.close( sesionNTx);
		}

	}
	/**
 	 * Metodo para recuperar la lista de sabados habiles
 	 * @param uid Identificador
 	 * @param fechaComparacion fechaComparacion de entrada
 	 * @return ArrayList<SabadosLaboralesOV> lista de posibles sabados laborables
 	 */
	public ArrayList<SabadosLaboralesOV> obtenerSabadosLaborables(final String uid,
			final ReporteSolicitudesPeticion fechaComparacion) {

		SqlSession 	sesionNTx = null;

		try	{

			//Recuperamos los valores
		  	sesionNTx	 = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace("MAPPER", ComunTarea.class, "==> obtenerSabadosLaborables - obtenerSabadosHabiles");

			@SuppressWarnings("unchecked")
			final ArrayList<SabadosLaboralesOV>	fechas
				= (ArrayList<SabadosLaboralesOV>) sesionNTx.selectList( "obtenerSabadosHabiles", fechaComparacion);

//			if ( fechas == null || fechas.size() <= 0 ) {
//				throw new Exception("No se pudo obtener los dias sabados laborales: " );
//			}

			return fechas;

		} catch ( java.lang.Exception exception ) {
 			LogHandler.error(uid, ComunTarea.class, "Error al momento de cargar los"
 					+ " valores obtenerSabadosLaborables", exception );
 			return null;
 		} finally {
			FabricaConexiones.close( sesionNTx);
		}

	}
	/**
 	 * Metodo para obtener la  FechaMaximaRespuestaCEC
	 * @param uid identificador unico
	 * @param sabadosHabiles ArrayList<SabadosLaboralesOV> sabados Habiles
	 * @param fechaAsignacionObj fecha de asignacion que viene en el objeto Date
	 * @param diasInhabiles ArrayList<DiasInhabilesOV> dias no laborables
	 * @param valorMinutos los minutos que se contaran apartir de la fecha asignacion
	 * @param horaEntradaSEM Hora de entrada dias entre semana
	 * @param horaSalidaSEM Hora de salida dias entre semana
	 * @param horaEntradaSAB Hora de entrada sabados habiles
	 * @param horaSalidaSAB Hora de salida sabados habiles
	 * @return long fechaMaximaRespuesta
	 * @throws Exception propaga la excepcion del error para las capas superiores.
	 */
	public Date getFechaMaximaRespuestaCEC(final String uid, final ArrayList<SabadosLaboralesOV> sabadosHabiles,
			final Date fechaAsignacionObj, final ArrayList<DiasInhabilesOV> diasInhabiles, final String valorMinutos,
			final String horaEntradaSEM, final String horaSalidaSEM, final String horaEntradaSAB,
			final String horaSalidaSAB) throws Exception {
		LogHandler.debug(uid, getClass(), "getFechaMaximaRespuestaCEC: - getFechaMaximaRespuestaCEC");
		LogHandler.debug(uid, ComunTarea.class, "==> getFechaMaximaRespuestaCEC - fecha -> " + fechaAsignacionObj);
		SimpleDateFormat formatoTime = new SimpleDateFormat(FORMATO_ENTRADA_HORA);
		LocalDateTime fechaEntrada = new LocalDateTime(fechaAsignacionObj.getTime()); //Fecha de entrada
		LogHandler.debug(uid, ComunTarea.class, "==> getFechaMaximaRespuestaCEC - fechaEntrada: " + fechaEntrada.toDate());

//		ParGeneralOV valorMinutosRespuesta = this.obtenerParGeneralOV(uid, "MINRESSOL");
//		if (valorMinutosRespuesta == null || valorMinutosRespuesta.getCgValor().trim().isEmpty()) {
//				throw new Exception("No fue posible obtener el tiempo de respuesta.");
//		}

		int minutosMaxRespuesta = Integer.parseInt(valorMinutos);
		String horaFin;

		//ArrayList<DiasInhabilesOV> diasInhabiles = obtenerDiasInhabiles(0); //Sucursal 0 Central
		LogHandler.debug(uid, ComunTarea.class, "==> getFechaMaximaRespuestaCEC - diasInhabiles: " + diasInhabiles);
		//Todos los sabados laborables
		//ArrayList<SabadosLaboralesOV> sabadosHabiles = obtenerSabadosLaborables(fechaAsignacionObj);
		LogHandler.debug(uid, ComunTarea.class, "==> getFechaMaximaRespuestaCEC - sabadosHabiles: " + sabadosHabiles);

		if (diasInhabiles == null || diasInhabiles.isEmpty()) {
				throw new Exception("No fue posible obtener los dias inhabiles.");
		}
		if (diasInhabiles == null || diasInhabiles.isEmpty()) {
				throw new Exception("No fue posible obtener los sabados habiles.");
		}

		LocalTime horaInicioLabores;
		LocalTime fechaIni = new LocalTime(formatoTime.parse(fechaEntrada.getHourOfDay() + ":" + fechaEntrada.getMinuteOfHour()));

		LocalTime fechafin;

	    int i = minutosMaxRespuesta;

	    //DateFormat dfg = SimpleDateFormat.getDateInstance(DateFormat.DATE_FIELD);

	    //String fechaPoolStr = dfg.format(fechaAsignacionPool.getTime());
        //String fechaObjtStr = dfg.format(fechaAsignacionObj.getTime());
        //LogHandler.debug(uid, ComunTarea.class, "==> getFechaMaximaRespuestaCEC -  " + fechaPoolStr + " <=>" + fechaObjtStr);

	    do {

	    	//Se obtiene el valor de la fecha final
	    	if (fechaEntrada.getDayOfWeek() == DateTimeConstants.SATURDAY) {
	    		horaFin = horaSalidaSAB;
	    		LogHandler.debug(uid, ComunTarea.class, "==> getFechaMaximaRespuestaCEC - SABADO - horaFin: " + horaFin);
	    		fechafin = new LocalTime(formatoTime.parse(horaFin));
	    		horaInicioLabores = new LocalTime(formatoTime.parse(horaEntradaSAB));
	    	} else {
	    		horaFin = horaSalidaSEM;
	    		LogHandler.debug(uid, ComunTarea.class, "==> getFechaMaximaRespuestaCEC - SEMANA - horaFin: " + horaFin);
	    		fechafin = new LocalTime(formatoTime.parse(horaFin));
	    		horaInicioLabores = new LocalTime(formatoTime.parse(horaEntradaSEM));
	    	}

	    	//Comparacion entre la fechaAsignacionPool (tareas_evaluacion_credito) y la fechaAsignacion (objeto que ya se tiene)
	    	//se omite la parte del tiempo.
	    	//if (fechaPoolStr.equals(fechaObjtStr)) {
	    		//compara si es dia no habil
	    		if (!fechaNoHabil(diasInhabiles, fechaEntrada.toDate().getTime())) {
	    			LogHandler.debug(uid, ComunTarea.class, "==> fechaEntrada - >>>>>> " + fechaEntrada);
 				    LogHandler.debug(uid, ComunTarea.class, "==> fechaEntrada - >>> getHourOfDay >>> "
 				    		+ fechaEntrada.getHourOfDay());
 				    LogHandler.debug(uid, ComunTarea.class, "==> fechaEntrada - >>> getMinuteOfHour >>> "
 				    		+ fechaEntrada.getMinuteOfHour());
	    			//Verifica que el dia sea sabado
		    		if (fechaEntrada.getDayOfWeek() == DateTimeConstants.SATURDAY) {
	    				//Se compara si el sabado es laboral
	    				if (sabadoLaboral(sabadosHabiles, fechaEntrada.toDate().getTime())) {
	    					if (Minutes.minutesBetween(fechaIni, fechafin).getMinutes() <= 0) {
	    						fechaEntrada = fechaEntrada.plusDays(1);
		    				    fechaIni = horaInicioLabores;
		    				    fechaEntrada = new LocalDateTime(fechaEntrada.getYear(), fechaEntrada.getMonthOfYear(),
		    					fechaEntrada.getDayOfMonth(), horaInicioLabores.getHourOfDay(),
		    						horaInicioLabores.getMinuteOfHour());
	    					} else {
	    						i--;
	    						fechaIni = fechaIni.plusMinutes(1);
	    						fechaEntrada = fechaEntrada.plusMinutes(1);
	    					}
	    				} else { //No es sabado laboral
	    					fechaEntrada = fechaEntrada.plusDays(2);
	    				    fechaIni = horaInicioLabores;
	    				    fechaEntrada = new LocalDateTime(fechaEntrada.getYear(), fechaEntrada.getMonthOfYear(),
	    					fechaEntrada.getDayOfMonth(), horaInicioLabores.getHourOfDay(), horaInicioLabores.getMinuteOfHour());
	    				}
		    		} else if (fechaEntrada.getDayOfWeek() == DateTimeConstants.SUNDAY) { //Es domingo
		    			fechaEntrada = fechaEntrada.plusDays(1);
		    			fechaIni = horaInicioLabores;
		    			fechaEntrada = new LocalDateTime(fechaEntrada.getYear(), fechaEntrada.getMonthOfYear(),
	    				fechaEntrada.getDayOfMonth(), horaInicioLabores.getHourOfDay(), horaInicioLabores.getMinuteOfHour());
		    		} else { //No es sabado ni domingo
		    			if (Minutes.minutesBetween(fechaIni, fechafin).getMinutes() <= 0) {
    						fechaEntrada = fechaEntrada.plusDays(1);
	    				    fechaIni = horaInicioLabores;
	    				    fechaEntrada = new LocalDateTime(fechaEntrada.getYear(), fechaEntrada.getMonthOfYear(),
	    					fechaEntrada.getDayOfMonth(), horaInicioLabores.getHourOfDay(), horaInicioLabores.getMinuteOfHour());
    					} else {
    						i--;
    						fechaIni = fechaIni.plusMinutes(1);
    						fechaEntrada = fechaEntrada.plusMinutes(1);
    					}
		    		}
	    		} else {
	    			fechaEntrada = fechaEntrada.plusDays(1);
				    fechaIni = horaInicioLabores;
				    fechaEntrada = new LocalDateTime(fechaEntrada.getYear(), fechaEntrada.getMonthOfYear(),
					fechaEntrada.getDayOfMonth(), horaInicioLabores.getHourOfDay(), horaInicioLabores.getMinuteOfHour());
	    		}
		    //} else {
		    //}
	    } while ( i != 0);
	    return fechaEntrada.toDate();
	}
	/**
	 * Metodo que compara el dia que se manda para validar con el arreglo
	 * de dias inhabiles si hay una coincidencia retorna boolean
	 * @param diasInhabiles arreglo de dias inhabiles
	 * @param diaLong dia a validar en el arreglo
	 * @return boolean true existen coincidencias y false no existen coincidencias
	 */
	private static boolean fechaNoHabil(ArrayList<DiasInhabilesOV> diasInhabiles, long diaLong) {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		 Date diaValidar = new Date(diaLong);
		 for (DiasInhabilesOV temp : diasInhabiles) {
			 if (temp != null) {
				 if (sdf.format(diaValidar).equals(sdf.format(temp.getFecha()))) {
					 return true;
				 }
			 }
		 }
		return false;

	 }
	 /**
	 * Metodo que compara el dia que se manda para validar con el arreglo
	 * de dias inhabiles si hay una coincidencia retorna boolean
	 * @param sabadoLaboral arreglo de dias inhabiles
	 * @param diaLong dia a validar en el arreglo
	 * @return boolean true existen coincidencias y false no existen coincidencias
	 */
	private static boolean sabadoLaboral(ArrayList<SabadosLaboralesOV> sabadoLaboral, long diaLong) {
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		 Date diaValidar = new Date(diaLong);
		 if (sabadoLaboral != null) {
			 for (SabadosLaboralesOV temp : sabadoLaboral) {
				 if (temp != null) {
					 if (sdf.format(diaValidar).equals(sdf.format(temp.getFecha()))) {
						 return true;
					 }
				 }
			 }
		 }
		return false;

	 }

	@SuppressWarnings("unchecked")
	public List<ChequeOV> obtenerCheques(String uid, List<ChequeOV> listaCheques) throws Exception {

		if (listaCheques.size() == 0) {
			throw new Exception("No es posible obtener los cheques, la lista esta vacia");
		}

		SqlSession sessionNTx = FabricaConexiones.obtenerSesionNTx();
		final java.util.HashMap<String, Object> params	= new HashMap<String, Object>();
		params.put("list", listaCheques );
		LogHandler.trace(uid, getClass(), "obtenerCheques - obtenerDatosCheques");
		final List<ChequeOV> respuesta = (List<ChequeOV>) sessionNTx.selectOne( "obtenerDatosCheques", params );
		FabricaConexiones.close( sessionNTx );
		return respuesta;
	}
	/**
	 * Metodo para buscar un numero por un seprador
	 * @param cadena en la que se buscara el valor
	 * @param separador de la cadena
	 * @param busco numero que deseo buscar
	 * @return si existe
	 */
	public boolean encontrarNumeroCadena(String cadena, String separador, int busco) {
		String[] valores = cadena.split(separador);
		boolean existe = false;
		for ( int i = 0; i < valores.length; i++) {
			if ( busco	== Integer.parseInt(valores[i])) {
				existe = true;
			}
		}
		return existe;
	}
	
	/**
	 * regresa una coleccion de string.
	 * @param uid identificador &uacute;nico de transacci&oacute;n.
	 * @param valorJdni valor de la jdni
	 * @return una lista de strings.
	 */
	public  List<String> obtenerListaDeParametros(String uid, String valorJdni) {
		LogHandler.info(uid, getClass(), "obtenerListaDeParametros -ENTRANDO A RECUPERAR EL JDNI DE PUESTOS:: " + valorJdni);
		String puestos = null;
		String[] arrayPuesto = null;
		List<String> listaPuestos = null;
		 try {
				puestos = obtenerParGeneral(uid, valorJdni);
				LogHandler.info(uid, getClass(), "obtenerListaDeParametros puestos " + puestos);
				if (null == puestos) {
					throw new Exception("Error la " + valorJdni + " viene nula.");
				} else if (puestos.length() > 0) {
					arrayPuesto = puestos.split(";");
					listaPuestos = new ArrayList<String>();
					for (String puesto : arrayPuesto) {
						listaPuestos.add(puesto);
					}
				}
		 } catch (Exception ex) {
			 LogHandler.error(uid, getClass(), "No se pudo obtener la lista de puestos", ex);

		 }
		 LogHandler.info(uid, getClass(), "obtenerListaDeParametros listaPuestos " + listaPuestos);
		 return listaPuestos;
	}
	
	
}	
