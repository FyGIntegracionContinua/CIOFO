/**
 * Tensegrity - 2011
 */
package tarea.cheques;

import utilitario.mensajes.originacion.cheques.ChequesPeticion;
import utilitario.mensajes.originacion.cheques.ClientesChequesRespuesta;
import utilitario.mensajes.originacion.cheques.ContratoChequesSICOV;




/**
 * @author Juan Moreno
 * @version 1.0.0
 * Encapsula las operaciones sobre una entidad persona.
 * <ul>
 *  <li>Validar que exista una persona</li>
 *  <li>Registrar una persona grupal.</li>
 *  <li>Actualizar una persona grupal.</li>
 *  <li></li>
 *  <li></li>
 * </ul>
 */
public interface ChequesSIC {

	 //Definicion de llamadas a operacion de la capa de entidad ibatis
	 /**
	 * OPER_CONSULTA_CONTRATO_CHEQUES_SIC
	 */
	static final String OPER_CONSULTA_CONTRATO_CHEQUES_SIC 		= "consultaContratoChequesSIC";
	 /**
	 * OPER_CONSULTA_CLIENTES_CHEQUES_SIC
	 */
	static final String OPER_CONSULTA_CLIENTES_CHEQUES_SIC 		= "consultaClientesChequesSIC";

	 /**
	 * CONTRATO_LD
	 */
	static final String	CONTRATO_LD					= "contratoLD";
 	 /**
 	 * MENSAJE_OK
 	 */
 	static final String	MENSAJE_OK					= "CHEQUES SIC ";
	 /**
	 * MENSAJE_ERROR
	 */
	static final String	MENSAJE_ERROR				= "CHEQUES SIC NO ";
	 /**
	 * MENSAJE_TIMEOUT
	 */
	static final String	MENSAJE_TIMEOUT				= "FSERROR_TIMEOUT, CHEQUES SIC NO ";



	/**
	 * Consulta la informacion de un credito para dar de alta un cheque.
	 * @param contrato Datos a guardar.
	 * @param uid Identificador unico de la peticion
	 * @return Resultado de la operacion
	 */
	public ContratoChequesSICOV consultaContratoChequesSIC( String uid, ChequesPeticion contrato );

	/**
	 * Consulta la informacion de de los integrantes de un credito en especifico.
	 * @param contrato Datos a consultar.
	 * @param uid Identificador unico de la peticion
	 * @return Coleccion de los clientes de contrato ClienteChequesSICOV[]
	 */
	public ClientesChequesRespuesta  consultaClientesChequesSIC( String uid, ChequesPeticion contrato );

}
