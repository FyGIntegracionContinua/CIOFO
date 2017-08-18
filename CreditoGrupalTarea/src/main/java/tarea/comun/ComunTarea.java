package tarea.comun;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import utilitario.mensajes.comun.FechaContableOV;
import utilitario.mensajes.comun.InteresOV;
import utilitario.mensajes.comun.ResultadoOV;
import utilitario.mensajes.consultas.ConsultaAnalista;
import utilitario.mensajes.originacion.consulta.ParGeneralOV;
import utilitario.mensajes.reportes.comun.ObtenerEstadoCuenta;
import utilitario.mensajes.solicitudes.DiasInhabilesOV;
import utilitario.mensajes.solicitudes.ReporteSolicitudesPeticion;
import utilitario.mensajes.solicitudes.SabadosLaboralesOV;


/**
 * @author out_jcmoreno
 * @version 1.0.0
 */
public interface ComunTarea {

 	/**
 	 * Obetenemos la fecha contable sin sucursal
 	 * @param uid identificador unico
 	 * @return Fecha contable de la sucursal default 0
 	 */
	public FechaContableOV obtenerFechaContable( String uid );


	/**
	 * Obtenemos la fecha contable de la sucursal enviada
	 * @param uid identificador unico
	 * @param sucursal de la peticion
	 * @return Fecha contable de la sucursal enviada
	 */
	public FechaContableOV obtenerFechaContablePorSucursal( String uid, Integer sucursal);

	/**
	 * @param uid identificador unico
	 * @param numeroCredito numero contrato
	 * @return numero de contrato
	 */
	public String obtenerNumeroContrato(String uid, String numeroCredito);

	/**
	 * @param uid identificador unico
	 * @param numeroCredito numero contrato
	 * @return numero de contratoLD
	 */
	public String obtenerNumeroContratoLD(String uid, String numeroCredito);

	/**
	 * @param uid identificador unico
	 * @param numeroCuenta numero de contrato
	 * @param seccion del estado de cuenta
	 * @return datos del estado de cuenta
	 */
	@SuppressWarnings("rawtypes")
	public List storeEstadoCuenta( String uid, String numeroCuenta, ObtenerEstadoCuenta seccion);

	/**
	 * @param uid identificador unico
	 * @param numeroCuenta numero de contrato
	 * @param seccion del estado de cuenta
	 * @return datos del estado de cuenta
	 */
	@SuppressWarnings("rawtypes")
	public List storeEstadoCuentaEx( String uid, String numeroCuenta, ObtenerEstadoCuenta seccion) throws Exception;

	/**
	 * @param uid identificador unico
	 * @param numeroCuenta  numero de contrato
	 * @param seccion del estado de cuenta
	 * @param muestraCancelaciones del estado de cuenta
	 * @return datos del estado de cuenta
	 */
	@SuppressWarnings("rawtypes")
	public List storeEstadoCuentaDetalle( String uid, String numeroCuenta, String muestraCancelaciones,
			ObtenerEstadoCuenta seccion);


	/**
	 * Ejecuta el store que abre la caja para realizar la operacion necesaria
	 * @param uid identificador unico
	 * @param sucursal  de la peticion
	 * @param fechaContable del core
	 * @return resultado de abrir la caja
	 */
	ResultadoOV aperturaCaja( String uid, int sucursal, Date fechaContable);

	/**
	 * @param uid identificador unico
	 * @param sucursal  de la peticion
	 * @param fechaContable del core
	 * @return id de la transaccion de la caja
	 */
	Integer obtenerIdTransaccion( String uid, int sucursal, Date fechaContable);

	/**
	 * Obtiene los datos de la tasa del contrato como son:
	 * <ul>
	 * 	<li>fecha_prim_venc</li>
	 * 	<li>sucursal</li>
	 *  <li>monto</li>
	 *  <li>tasa</li>
	 *  <li>no_pagos</li>
	 *  <li>frecuencia_pago</li>
	 *  <li>monto_pago</li>
	 * </ul>
	 * @param contrato FISA
	 * @param uid identificador unico
	 * @return HashMap con los valores de loscampos antes mencionados.
	 */
	public HashMap<String, Object> obtenerDatosGeneralesContrato( String uid, String contrato );

	/**
	 * Obtiene los datos de la tasa del contrato como son:
	 * @param contrato FISA
	 * @param uid identificador unico
	 * @return HashMap con los valores de loscampos antes mencionados.
	 */
	public HashMap<String, Object> obtenerDatosGeneralesContratoSimple(String uid, String contrato);

	/**
	 * Obtiene datos del contrato, con una session dada, sea transaccional o no
	 * @param uid identificador unico
	 * @param contrato FISA
	 * @param sessionTx de la base de datos
	 * @return la coleccion de los datos del contrato
	 */
	public HashMap<String, Object> obtenerDatosGeneralesContrato( String uid, String contrato, SqlSession sessionTx );

	/**
	 * Obtiene datos del contrato, con una session dada, sea transaccional o no
	 * @param uid identificador unico
	 * @param contrato FISA
	 * @param sessionTx de la base de datos
	 * @return la coleccion de los datos del contrato
	 */
	public HashMap<String, Object> obtenerDatosGeneralesContratoSimple(String uid, String contrato, SqlSession sessionTx);

	/**
	 * Regresa la categoria del producto solicitado
	 * @param uid identificador unico
	 * @param producto del contrato
	 * @return Descripcion de la categoria del producto
	 */
	public String obtenerCategoria(String uid, String producto);

	/**
	 * Calcula El interes total que se pagar� por un credito
	 * @param uid identificador unico
	 * @param numeroContrato FISA
	 * @return el interes total
	 */
	public Double calcularInteresTotalCredito( String uid, String numeroContrato) throws Exception;

 	/**
 	 * Obtenemos la fecha actual de la BD
 	 * @param uid identificador unico
 	 * @return Fecha actual
 	 */
	public Date obtenerFechaActual( java.lang.String uid );

	/**
	 * A partir de un n�mero de contrato se obtiene el estatus del mismo
	 * @param uid identificador unico
	 * @param contrato numero de contrato para comprobar
	 * @return estatus del credito
	 */
	public java.lang.String obtenerEstatusCredito( java.lang.String uid, java.lang.String contrato );

	/**
	 * Obtiene la relacion entre el numero de persona o el numero t24
	 * @param uid identificador unico
	 * @param cliente numero
	 * @return numero de cliente de la persona
	 */
	public java.lang.String obtenerPersonaCliente( java.lang.String uid, java.lang.String cliente );

	/**
	 * Funcion para verificar si el cotnrato y sucursal coinciden
	 * @param uid identificador unico
	 * @param params parametros de busqueda
	 * @return si el contrato pertenece a la sucursal
	 */
	public java.lang.Boolean comprobarContratoSucursal( java.lang.String uid, java.util.HashMap<String, Object> params );

	/**
	 * Funcion general para el calculo de intereses totales de un contrato, llamando un store
	 * @param uid identificador unico
	 * @param interesOV recibe el interes
	 * @return el calculo del interes total
	 */
	public InteresOV calcularInteresTotal( java.lang.String uid, InteresOV interesOV );

	/**
	 * Recalcula el porcentaje de participacion de los integrantes del contrato
	 * en caso de haber tenido algun cambio en los montos, esto es en integrante_grupo
	 * @param uid identificador unico
	 * @param contrato FISA
	 * @param sessionTx de la base de datos
	 * @return el resultado de la actualizacion del porcentaje de particiapacion
	 */
	public java.lang.Boolean actualizarPorcentajeParticipacionIntegrante(
			java.lang.String uid, SqlSession sessionTx, java.lang.String contrato );

	/**
	 * Verifica si una persona existe
	 * @param uid identificador unico
	 * @param clavePersona el numero o clave de persona
	 * @return si existe el cliente
	 */
	public java.lang.Boolean existeCliente( java.lang.String uid, java.lang.String clavePersona );
	/**
	 * @param fecha para calcular la edad de alguien
	 * @return edad
	 */
	public  int calcularEdad(java.util.Date fecha);
	/**
	 * Verifica si una persona existe
	 * @param uid identificador unico
	 * @param clave de la tabla par_general
	 * @return si existe el cliente
	 * @throws Exception propaha la excepcion del error para las capas superiores.
	 */
	public String obtenerParGeneral(String uid, String clave) throws Exception;

	/**
	 * Funcion para obtener el contrato por medio de una solicitud
	 * @param uid identificador unico
	 * @param solicitud para obtener el contrato
	 * @return el contrato
	 */
	public String obtenerContratoPorSolicitud( String uid, String solicitud );

	/**
	 * @param uid identificador unico
	 * @param clave de la tabla par_general
	 * @return OV de par_general
	 * @throws Exception propaga la excepcion del error para las capas superiores.
	 */
	public ParGeneralOV obtenerParGeneralOV(String uid, String clave) throws Exception;

	/**
 	 * Metodo para obtener la  FechaMaximaRespuestaCEC
	 * @param uid identificador unico
	 * @param sabadosHabiles ArrayList<SabadosLaboralesOV> sabados Habiles
	 * @param fechaAsignacionObj fecha de asignacion que viene en el objeto
	 * @param diasInhabiles ArrayList<DiasInhabilesOV> dias Inhabiles
	 * @param valorMinutosRespuesta los minutos que se contaran apartir de la fecha asignacion
	 * @param horaEntradaSEM Hora de entrada dias entre semana
	 * @param horaSalidaSEM Hora de salida dias entre semana
	 * @param horaEntradaSAB Hora de entrada sabados habiles
	 * @param horaSalidaSAB Hora de salida sabados habiles
	 * @return long fechaMaximaRespuesta
	 * @throws Exception propaga la excepcion del error para las capas superiores.
	 */
	public Date getFechaMaximaRespuestaCEC(final String uid, final ArrayList<SabadosLaboralesOV> sabadosHabiles,
			final Date fechaAsignacionObj, final ArrayList<DiasInhabilesOV> diasInhabiles, final String valorMinutosRespuesta,
			final String horaEntradaSEM, final String horaSalidaSEM, final String horaEntradaSAB,
			final String horaSalidaSAB) throws Exception;

	/**
	 * @param uid identificador unico
	 * @param fechaComparacion ReporteSolicitudPeticion para ontener fechas inicio y fin
	 * @return ArrayList<SabadosLaboralesOV>  sabados habiles
	 */
	public ArrayList<SabadosLaboralesOV> obtenerSabadosLaborables(final String uid,
			final ReporteSolicitudesPeticion fechaComparacion);

	/**
	 * @param uid identificador unico
	 * @param sucursal int
	 * @return ArrayList<DiasInhabilesOV> dias Inhabiles
	 */
	public ArrayList<DiasInhabilesOV> obtenerDiasInhabiles(final String uid, final int sucursal);

	/**
	 * Metodo para buscar un numero por un seprador
	 * @param cadena en la que se buscara el valor
	 * @param separador de la cadena
	 * @param busco numero que deseo buscar
	 * @return si existe
	 */
	public boolean encontrarNumeroCadena(String cadena, String separador, int busco);
	
	/**
	 * regresa una coleccion de string.
	 * @param uid identificador &uacute;nico de transacci&oacute;n.
	 * @param valorJdni valor de la jdni
	 * @return una lista de strings.
	 */
	public  List<String> obtenerListaDeParametros(String uid, String valorJdni);
}
