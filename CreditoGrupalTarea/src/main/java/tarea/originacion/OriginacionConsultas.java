/**
 * Tensegrity - 2011
 */
package tarea.originacion;

import utilitario.mensajes.originacion.aprobacion.PlanillaAprobacionRespuestaOV;
import utilitario.mensajes.originacion.consulta.ConsultaFechaOV;
import utilitario.mensajes.originacion.consulta.ConsultaRespuesta;
import utilitario.mensajes.originacion.consulta.ConsultarSimulacionesReestructurasRespuesta;
import utilitario.mensajes.originacion.consulta.InsertarSimulacionesReestructurasPeticion;
import utilitario.mensajes.originacion.consulta.InsertarSimulacionesReestructurasRespuesta;
import utilitario.mensajes.originacion.consulta.SimulacionReestructuraOV;
  

/**
 * @author Juan Moreno
 * Encapsula las operaciones sobre una entidad persona.
 * <ul>
 *  <li></li>
 *  <li></li>
 * </ul>
 */
public interface OriginacionConsultas {
 
	static final String OPER_VERIFICA_DIANOHABDOM 		= "verificaDiaNoHabDom";
 	static final String OPER_VER_VALOR_HISTORICO 		= "verValorHistorico";
 	static final String OPER_CAL_FECHA_PROX_VENCIMIENTO	= "calculaFechaProxVencimiento";
 	
	static final String FECHA							= "fecha";
	static final String SUCURSAL						= "sucursal";
	static final String CODIGO							= "codigo";
	static final String FRECUENCIA_PAGO					= "frecuencia_pago";
	static final String FECHA_ACTUAL					= "fecha_actual";
	static final String FECHA_ANCLA						= "fecha_ancla_pago";
	static final String FECHA_ULT_VENCIMIENTO			= "fecha_ult_venc";
	static final String FECHA_PROXIMO_VENCIMINENTO		= "fecha_prox_venc";
	static final String FECHA_PROXIMO_PAGO				= "fecha_prox_pago";
	
	static final String CODIGO_FECHA_CONTABLE			= "CDES";
	static final String CODIGO_IVA 						= "IVIN";
	
	static final String	IDENTIFICADOR_OK				= "1";
	static final String	IDENTIFICADOR_FAIL				= "0";	
  	static final String	MENSAJE_ERROR					= "ERROR: ";
	static final String	MENSAJE_TIMEOUT 				= "FSERROR_TIMEOUT, FECHA INICIO CONTRATO NO VALIDA. ";

	/**
	 * Realiza la valiadación de la Fecha de operacion / inicio del contrato
	 * @param ConsultaFechaOV fecha de operacion
	 * @return ConsultaRespuesta con el identificador de éxito o falla.
	 */
	ConsultaRespuesta validarFechaInicioContrato( String uid, ConsultaFechaOV fecha );
	
	/**
	 * Sigue el procedimiento para obtener la fecha de  fin de contro en base a la fecuecncia de pago y los plazos
	 * @param ConsultaFechaOV que incluye la fecha inicial, el plazo y frecuencia
	 * @return ConsultaRespuesta con la fechafinal de fin de contrato.
	 */
	ConsultaRespuesta calcularFechaFinContrato( String uid,  ConsultaFechaOV fecha );

	/**
	 * Regresa la fecha contable que tiene el sistema.
	 * @param fecha  con la fecha de hoy
	 * @return  ConsultaRespuesta con la fecha contable solicitada.
	 */
	ConsultaRespuesta obtenFecha( String uid, ConsultaFechaOV fecha );

	/**
	 * Obtiene los datos correspondientes a la planilla de aprovacion del contrato proporcionado
	 * @param numContrato tipo String
	 * @return planilla Aprobacion
	 */
	PlanillaAprobacionRespuestaOV obtenerPlantillaAprobacion( String uid, String numContrato);


	/**
	 * Consultar simulador reestructuras tarea.
	 *
	 * @param uid the uid
	 * @param peticion the peticion
	 * @return the consultar simulaciones reestructuras respuesta
	 */
	ConsultarSimulacionesReestructurasRespuesta consultarSimuladorReestructurasTarea(
			String uid, SimulacionReestructuraOV peticion);

	/**
	 * Insertar simulador reestructuras tarea.
	 *
	 * @param uid the uid
	 * @param peticion the peticion
	 * @return the insertar simulaciones reestructuras respuesta
	 */
	InsertarSimulacionesReestructurasRespuesta insertarSimuladorReestructurasTarea(
			String uid, InsertarSimulacionesReestructurasPeticion peticion);


}
