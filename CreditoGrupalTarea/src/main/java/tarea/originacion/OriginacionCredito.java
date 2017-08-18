/**
 * Tensegrity - 2011
 */
package tarea.originacion;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import org.apache.ibatis.session.SqlSession;

import utilitario.mensajes.originacion.cliente.ActualizarChequeClientePeticion;
import utilitario.mensajes.originacion.cliente.ClienteRespuesta;
import utilitario.mensajes.originacion.consulta.ConfirmarCreditoPeticion;
import utilitario.mensajes.originacion.consulta.ConfirmarCreditoRespuesta;
import utilitario.mensajes.originacion.consulta.GuardarOpcionGarantiaPeticion;
import utilitario.mensajes.originacion.consulta.GuardarOpcionGarantiaRespuesta;
import utilitario.mensajes.originacion.consulta.PagoDocumentoPeticion;
import utilitario.mensajes.originacion.consulta.ValidaPagoGarantiaPeticion;
import utilitario.mensajes.originacion.consulta.ValidaPagoGarantiaRespuesta;
import utilitario.mensajes.originacion.contrato.ContratoOV;
import utilitario.mensajes.originacion.contrato.ContratoRespuesta;
import utilitario.mensajes.originacion.desembolso.DesembolsoOV;
import utilitario.mensajes.originacion.desembolso.DesembolsoRespuesta;

 
/**
 * @author Juan Moreno
 * Encapsula las operaciones sobre la entidad credito
 * <ul>
 *  <li>Registro</li>
 * </ul>
 */
public interface OriginacionCredito {
	
  	 static final String  OPER_OBTENER_CICLO_GRUPO				= "obtenerCicloGrupo";
	 static final String  OPER_OBTENER_CONSECUTIVO_LD_CONTRATO	= "obtenerConsecutivoLdContrado";
	 static final String  OPER_REGISTRAR_CONTRATO_GRUPO			= "registrarContratoGrupo";
	 static final String  OPER_REGISTRAR_CONTRATO				= "registrarContrato";
	 static final String  OPER_REGISTRAR_CONTRATO_RESTRUCTURA	= "registrarContratoRestructura";
 	 static final String  OPER_VER_VALOR_HISTORICO 				= "verValorHistorico";
	 static final String  OPER_REGISTRAR_INTEGRANTE_GRUPO		= "registrarIntegranteGrupo";
	 //static final String  OPER_REGISTRA_CONTRATO_CLAVE_FINSOL	= "registrarContratoClaveFinsol";
	 static final String  OPER_ACTUALIZAR_CICLO_GRUPO			= "actualizarCicloGrupo";
	 static final String  OPER_ACTUALIZAR_CICLO_INTEGRANTE		= "actualizarCicloIntegrante";
	 static final String  OPER_CALCULA_MONTO_PAGO				= "calculaMontoPago";
	 
	
 	 static final String CICLO_GRUPO							= "ciclo_grupo";
 	 static final String CICLO 									= "ciclo";
	 static final String GRUPO									= "grupo";
	 static final String SUCURSAL								= "sucursal";
	 static final String MENSAJE_ERROR_INTEGRANTES				= "OCURRIO UN ERROR AL GUARDAR LOS INTEGRANTES DEL GRUPO...";
	 static final String MENSAJE_ERROR_NO_INTEGRANTES			= "OCURRIO UN ERROR AL GUARDAR LOS INTEGRANTES DEL GRUPO...";
	 static final String MENSAJE_ALTA_CONTRATO					= "CREDITO REGISTRADO.";
	 static final String MENSAJE_DISPOSICION_CONTRATO			= "DISPOSICION CREDITO REALIZADA.";
	 static final String MENSAJE_ERROR_GENERAR_ID				= "NO SE PUDO GENERAR EL IDENTIFICADOR DEL CONTRATO, NOTIFIQUELO AL ADMINITRADOR.";
	 static final String SOLICITUD								= "solicitud";
 	 static final String ASESOR									= "asesor";
	 static final String CONTRATO								= "contrato";
	 static final String CONTRATO_LD							= "contrato_LD";	
 	 static final String TASA									= "tasa";
	 static final String FRECUENCIA								= "frecuencia";
 	 static final String PLAZO									= "plazo";
 	 static final String FECHA_DESEMBOLSO						= "fecha_desembolso";
 	 static final String FECHA_DIA_PAGO							= "fechaDiaPago";
	 static final String PRODUCTO								= "producto";
	 static final String MONTO									= "monto";
	 static final String MONTO_PAGO								= "monto_pago";
	 static final String MONTO_OTORGADO							= "monto_otorgado";
 	 static final String VALOR_RENOVACION_SI					= "S";
	 static final String VALOR_RENOVACION_NO					= "N";
	 static final String RENOVACION								= "renovacion";
	 static final String FECHA_TERMINO							= "fecha_termino";
 	 static final String FECHA									= "fecha";
 	 static final String INTEGRANTE 							= "integrante"; 
	 static final String HORA_REUNION 							= "hora_reunion";
	 static final String DIA_REUNION							= "dia_reunion";
	 static final String ROL									= "rol";
	 static final String CODIGO									= "codigo";
	 static final String DESTINO_CREDITO						= "destino_credito";
	 static final String CICLO_INTEGRANTE 						= "ciclo_integrante";
	 static final String CAPITAL_INSOLUTO 						= "capital_insoluto";
	 static final String PERSONA		 						= "persona";
	 static final String CONSECUTIVO							= "consecutivo"; 
	 static final String FECHA_DISPOSICION						= "fecha_disposicion";
	 static final String MONTO_AHORRO							= "monto_ahorro";
	 static final String ROL_PRES								= "PRES";
	 static final String ROL_SECR								= "SECR";
	 static final String ROL_SUPE								= "SUPE";
	 static final String ROL_TESO								= "TESO";
	 static final String ROL_INTE								= "INTE";
	 //static final String PREF_OPORTUNIDAD						= "OPO";
	 static final String CODIGO_CREDITO_OK						= "COOK";
	 static final String CODIGO_IVA								= "IVIN";
 	 static final String OPERADOR								= "operador";
	 static final String FECHA_HORA_MOVIMIENTO					= "fecha_hora_movimiento";
	 static final String IDX_TRX_CAJA							= "idx_trx_caja";
	 static final String TIPO_LOCALIDAD							= "tipo_localidad";
	 static final String PORCENTAJE_PARTICIPACION				= "pct_participacion";
	 static final String CODIGO_PAGO_CANCELACION_RENO			= "CADO";
	 static final String CODIGO_PAGO_CANCELACION_DISP			= "CADI";
	 static final String CODIGO_PAGO_DISP						= "DISP";
	 static final String CODIGO_CANC_PAGODOC					= "PADA";
	 static final String CODIGO_CREDITO_PAGO					= "PREF";	
	 static final String CODIGO_CANCELACION_PAGO				= "FSOL";
	 static final String FECHA_CONTABLE 						= "fechaContable";
	 static final String IDXTRXCAJA								= "idTrxCaja";
	 static final SimpleDateFormat formatter 					= new SimpleDateFormat("yyyyMMdd");
	 static final String FECHA_PRIM_VENC						= "fecha_prim_venc";
	 static final String FECHA_ACTUAL							= "fechaActual";
	 static final String USUARIO  								= "usuario";
	 static final String MEDIO_RECEPCION							= "medioRecepcion";
	 static final String CLAVE									= "clave";
	 static final String CLAVE_PRODUCCION 						= "clave_produccion";
	 static final String REFERENCIA1							= "referencia1";
	 static final String REFERENCIA2							= "referencia2";
	 static final String REFERENCIA3							= "referencia3";
	 static final String FECHA_CANCELACION						= "fecha_cancelacion";
	 static final String DISPOSICION							= "disposicion";
	 static final String PREF_OPORTUNIDAD						= "OPO";
	 //static final String MENSAJE_TIMEOUT						= "FSERROR_TIMEOUT, CREDITO NO ";
	 //static final String MENSAJE_ERROR							= "CREDITO NO ";
		
	 static final String  NO_PAGOS								= "no_pagos";
	 static final String  FRECUENCIA_PAGO						= "frecuencia_pago";
	 static final String  OPERADOR_DEF							= "000000043";					
  	 static final String  MENSAJE_ERROR							= "CREDITO NO ";
	 static final String  MENSAJE_TIMEOUT						= "FSERROR_TIMEOUT, CREDITO NO ";
	 static final DecimalFormat 	DF			 				= new DecimalFormat("##.######");
	 static final String  PRODUCTO_RESTRUCTURA					= "GRES";
	 
	 static final String  PRODUCTO_DG_SEMANAL					= "GCDG";
	 static final String  PRODUCTO_DG_CATORCENAL				= "GCDC";

	 static final String  MONTO_SEGURO							= "seguro";
	 static final String  PCT_IVA_SEGURO						= "pct_iva_seguro";

	 static final String  SEGURO_VIDA							= "SEGURO_VIDA";
	 static final String  SEGURO_ENFERMEDAD						= "SEGURO_ENFERMEDAD";

	 static final String  PCT_DEP_GAR		= "PCT_DEP_GARANTIA";
	 static final String  OPC_DEP_GAR		= "OPCION_DEP_GARANTIA";
	 /**  Codigo para aplicar la garantia	*/
	 static final String CODIGO_APLICA_GARANTIA_CHEQUE = "DGAC";
	 /**  Codigo para aplicar la garantia como parcialidad	*/
	 static final String CODIGO_APLICA_GARANTIA_PARCIALIDAD = "DGAP";
	 /**  Codigo para aplicar la garantia desertores	*/
	 static final String CODIGO_APLICA_GARANTIA_DESERTOR = "DGAD";

	/**
	 * Registra un credito.
	 * Registra una solicitud de credito grupal, actualiza el grupo, registra los integrantes del grupo,
	 * registra el contrato grupal, registra el contrato y actualiza el contrato en la solicitud
	 * @param contrato Datos a guardar.
	 * @return Resultado de la operacion
	 */
	public ContratoRespuesta registrar(  String uid, SqlSession sesion, ContratoOV contrato );

	/**
	 * Realiza la operaci�n de desembolso del credito, es decir se ejecuta la operacion que saca el dinero de la
	 * caja para los integrates del grupo
	 * @param DesembolsoOV ov
	 * @return DesembolsoRespuesta
	 */
	public DesembolsoRespuesta desembolsar(  String uid, DesembolsoOV desembolso );


	/**
	 * Actualizar numero cheque.
	 *
	 * @param uid the uid
	 * @param peticion the peticion
	 * @return the cliente respuesta
	 */
	public ClienteRespuesta actualizarNumeroCheque(java.lang.String uid, ActualizarChequeClientePeticion peticion );

	/**
	 * Registrar contrato restructura.
	 *
	 * @param uid the uid
	 * @param contrato the contrato
	 * @return the contrato respuesta
	 */
	public ContratoRespuesta registrarContratoRestructura( String uid, ContratoOV contrato );

	/**
	 * Registra un credito.
	 * Registra una solicitud de credito grupal, actualiza el grupo, registra los integrantes del grupo,
	 * registra el contrato grupal, registra el contrato y actualiza el contrato en la solicitud
	 * @param uid Datos a guardar.
	 * @param contrato ContratoOV a guardar.
	 * @return Resultado de la operacion
	 */
	public ContratoRespuesta registrarContratoVentaCartera(  String uid, ContratoOV contrato );

	/**
	 * Valida pago garantia tarea.
	 *
	 * @param uid the uid
	 * @param peticion the peticion
	 * @return the valida pago garantia respuesta
	 */
	public ValidaPagoGarantiaRespuesta validaPagoGarantiaTarea(String uid,
			ValidaPagoGarantiaPeticion peticion);


	/**
	 * Confirmar credito tarea.
	 *
	 * @param uid the uid
	 * @param peticion the peticion
	 * @return the confirmar credito respuesta
	 */
	public ConfirmarCreditoRespuesta confirmarCreditoTarea(String uid,
			ConfirmarCreditoPeticion peticion);

	/**
	 * Guardar opcion garantia tarea.
	 *
	 * @param uid the uid
	 * @param peticion the contrato peticion
	 * @return the guardar opcion garantia respuesta
	 */
	public GuardarOpcionGarantiaRespuesta guardarOpcionGarantiaTarea(
			String uid, GuardarOpcionGarantiaPeticion peticion);

	/**
	 * Guardar opcion garantia tarea.
	 *
	 * @param uid the uid
	 * @param peticion the GuardarOpcionGarantiaPeticion
	 * @return the guardar opcion garantia respuesta
	 */
	public ConfirmarCreditoRespuesta confirmaSolicitudVerificacionTelefonica(
			String uid, ConfirmarCreditoPeticion peticion);

	public ConfirmarCreditoRespuesta aplicarPagoDocumento(String uid, PagoDocumentoPeticion peticion);
}
