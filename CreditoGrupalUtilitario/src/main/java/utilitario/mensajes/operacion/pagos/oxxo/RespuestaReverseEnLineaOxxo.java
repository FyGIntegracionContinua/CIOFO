package utilitario.mensajes.operacion.pagos.oxxo;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * Clase que contiene la respuesta del reverse de una pago.
 * @author out_rmontellanom
 * @version 1.0
 */
public class RespuestaReverseEnLineaOxxo extends ObjetoValor {

	/**
	 * serialVersionUID  uid.
	 */
	private static final long serialVersionUID = -4550013086556549403L;
	/**
	 * No requerido: N&uacute;mero de cuenta del cliente a imprimir en el recibo como
	 * referencia para el cliente. longitud 30
	 */
	private String account;
	/**
	 * No requerido: Monto Cancelado en centavos., longitud 12
	 */
	private String amount;
	/**
	 * Requerido: Numero de autorizaci�n �nico de la reversa de la transacci�n,
	 * longitud 10
	 */
	private Long auth;
	/**
	 * Requerido: 0 = Ning�n error, en caso contrario existe un error y el mensaje
	 * viene en el campo Mensaje. Longitud 3
	 */
	private String code;
	/**
	 * Requerido:Identificador �nico de la reversa, longitud 10
	 */
	private Long idReverse;
	/**
	 * Requerido: Mensaje del web-service o error detectado en la consulta. Longitud
	 * 100
	 */
	private String errorDesc;
	/**
	 * No requerido: Mensaje para el operador o a imprimir en el ticket., longitud 120
	 */
	private String messageTicket;

	/**
	 * Constructor RespuestaReverseEnLineaOxxo.
	 */
	public RespuestaReverseEnLineaOxxo() {
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
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	/**
	 * @return the auth
	 */
	public Long getAuth() {
		return auth;
	}

	/**
	 * @param auth the auth to set
	 */
	public void setAuth(Long auth) {
		this.auth = auth;
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
	 * @return the dReverse
	 */
	public Long getIdReverse() {
		return idReverse;
	}

	/**
	 * @param dReverse the dReverse to set
	 */
	public void setIdReverse(Long dReverse) {
		this.idReverse = dReverse;
	}

	/**
	 * @return the errorDesc
	 */
	public String getErrorDesc() {
		return errorDesc;
	}

	/**
	 * @param errorDesc the errorDesc to set
	 */
	public void setErrorDesc(String errorDesc) {
		this.errorDesc = errorDesc;
	}

	/**
	 * @return the messageTicket
	 */
	public String getMessageTicket() {
		return messageTicket;
	}

	/**
	 * @param messageTicket the messageTicket to set
	 */
	public void setMessageTicket(String messageTicket) {
		this.messageTicket = messageTicket;
	}

} //end RespuestaReverseEnLineaOxxo
