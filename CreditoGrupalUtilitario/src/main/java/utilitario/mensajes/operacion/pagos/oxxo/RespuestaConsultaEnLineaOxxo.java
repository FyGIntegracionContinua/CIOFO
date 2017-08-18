package utilitario.mensajes.operacion.pagos.oxxo;

import java.util.List;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * Clase que contiene la respuesta de la consulta realizada.
 * Nota:  Todos los tipos de dato String deben de cumplir con lo siguiente:
 * puede contener caracteres alfanum&eacute;ricos, num&eacute;ricos y especiales.
 * que deben cumplir las siguientes reglas:
 * Las reglas que deben cumplir los campos alfanum&eacute;ricos son los siguientes:
 *
 * Se aceptan las letras del abecedario: a-z, A-Z
 * No se aceptan las letras &ntilde; y &Ntilde;
 * No se aceptan los acentos &aacute; &eacute; &iacute; &oacute; &uacute;
 * Se aceptan los n&uacute;meros
 * S&oacute;lo se aceptan los siguientes caracteres especiales: $  %  /  (  )  =  -
 *  :  ;  *  +  ^  [  }  ]  {  .  �  ?  !  #  @  |
 * @author out_rmontellanom
 * @version 1.0
 */
public class RespuestaConsultaEnLineaOxxo extends ObjetoValor {

	/**
	 * serialVersionUID serial.
	 */
	private static final long serialVersionUID = -2053645480632829584L;
	/**
	 * Requerido: N&eacute;mero de cuenta del cliente, longitud 37
	 */
	private String account;
	/**
	 * No requerido: Direcci&oacute;n del cliente, longitud 100
	 */
	private String address;
	/**
	 * Requerido: 0 = Ning&uacute;n error, en caso contrario existe un error y el mensaje
	 * viene en el campo Mensaje.Longitud 3
	 */
	private String code;
	/**
	 * Requerido: Detalle de los conceptos de la cuenta a imprimir en el ticket.
	 *
	 * Las cantidades deben ser expresadas en centavos por ejemplo 10050 centavos
	 * equivalen a $100.50 pesos.
	 */
	private List<Concept> concepts;
	/**
	 * Requerido: Descripci&oacute;n del c&oacute;digo de respuesta del servicio, longitus 100
	 */
	private String  message;
	/**
	 * Requerido: Nombre del cliente, longitud 150
	 */
	private String name;
	/**
	 * Requerido: Bandera que indica si el pago acepta parcial o total. (T = Total, P
	 * = Parcial), si acepta Pago parcial, se indica los montos m&aacute;ximos y m&iacute;nimos para
	 * Longitud 1
	 */
	private String partial;
	/**
	 * No requerido: Descripci&oacute;n de la cuenta, longitud 40
	 */
	private String reference;
	/**
	 * No requerido: Estatus de la cuenta, longitud 20
	 */
	private String status;

	/**
	 * constructor de RespuestaConsultaEnLineaOxxo.
	 */
	public RespuestaConsultaEnLineaOxxo() {
         super();
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @param account the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the concepts
	 */
	public List<Concept> getConcepts() {
		return concepts;
	}

	/**
	 * @param concepts the concepts to set
	 */
	public void setConcepts(List<Concept> concepts) {
		this.concepts = concepts;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the partial
	 */
	public String getPartial() {
		return partial;
	}

	/**
	 * @param partial the partial to set
	 */
	public void setPartial(String partial) {
		this.partial = partial;
	}

	/**
	 * @return the reference
	 */
	public String getReference() {
		return reference;
	}

	/**
	 * @param reference the reference to set
	 */
	public void setReference(String reference) {
		this.reference = reference;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

} //end RespuestaConsultaEnLineaOxxo
