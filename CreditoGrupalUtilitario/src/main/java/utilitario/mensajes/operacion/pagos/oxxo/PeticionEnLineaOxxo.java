package utilitario.mensajes.operacion.pagos.oxxo;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * clase que contiene todos los par&aacute;metros de entrada de la petici&oacute;n
 * de Oxxo
 * @author out_rmontellanom
 * @version 1.0
 */
public class PeticionEnLineaOxxo extends ObjetoValor {

	/**
	 * serialVersionUID identificador de transacci&oacute;n.
	 */
	private static final long serialVersionUID = 6945328328549474537L;
	/**
	 * requerido: N&oacute;mero de cuenta del cliente, es proporcionado por la entidad externa
	 * durante la consulta, longtud 30, puede contener caracteres alfanum&eacute;ricos,
	 * num&eacute;ricos y especiales. que deben cumplir las siguientes reglas:
	 * Las reglas que deben cumplir los campos alfanum&eacute;ricos son los siguientes:
	 *
	 * Se aceptan las letras del abecedario: a-z, A-Z
	 * No se aceptan las letras &ntilde; y &Ntilde;
	 * No se aceptan los acentos &aacute; &eacute; &iacute; &oacute; &uacute;
	 * Se aceptan los n&uacute;meros
	 * S&oacute;lo se aceptan los siguientes caracteres especiales: $  %  /  (  )  =  -
	 *  :  ;  *  +  ^  [  }  ]  {  .  �  ?  !  #  @  |
	 */
	private String account;
	/**
	 * Requerido: Fecha administrativa de la tienda Formato: YYYYMMDD longitud 8
	 */
	private Long adminDate;
	/**
	 * requerido: Total a pagar en centavos Ej.: $130  = 13000 longitud 12
	 */
	private Long amount;
	/**
	 * No requerido: Identificador de la transacci&oacute;n a cancelar, este dato debe
	 * ser el mismo que se proporcion&oacute; en el servicio de Pago, longitud 10
	 */
	private long auth;
	/**
	 * NoRequerido: Caja de venta donde se realiz&oacute; la transacci&oacute;n,
	 * longitud de 2
	 */
	private Integer cashMachine;
	/**
	 * Requerido Identificador del cliente (Tel&eacute;fono, cuenta, contrato,
	 * c&oacute;digo de barras, etc.) puede contener caracteres alfanum&eacute;ricos,
	 * num&eacute;ricos y especiales. que deben cumplir las siguientes reglas:
	 * Las reglas que deben cumplir los campos alfanum&eacute;ricos son los siguientes:
	 *
	 * Se aceptan las letras del abecedario: a-z, A-Z
	 * No se aceptan las letras &ntilde; y &Ntilde;
	 * No se aceptan los acentos &aacute; &eacute; &iacute; &oacute; &uacute;
	 * Se aceptan los n&uacute;meros
	 * S&oacute;lo se aceptan los siguientes caracteres especiales: $  %  /  (  )  =  -
	 *  :  ;  *  +  ^  [  }  ]  {  .  �  ?  !  #  @  |
	 */
	private String client;
	/**
	 * no requerido para la consulta, pago: Modo de Ingreso de Informaci�n (Banda Magn�tica, Scanner,
	 * digitado, etc.) longitud 3
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
	 */
	private String entryMode;
	/**
	 * Requerido: Identificador de la transacci&oacute;n de FEMSA, longitud 10.
	 */
	private Long folio;
	/**
	 * Requerido: Bandera que indica si el pago acepta parcial o total. (T = Total, P
	 * = Parcial)
	 */
	private String partial;
	/**
	 * Requerido: Identificador de la tienda donde se efect&uacute;la la
	 * transacci&oacute;ln, longitud  10, puede contener caracteres alfanum&eacute;
	 * ricos, num&eacute;ricos y especiales. que deben cumplir las siguientes reglas:
	 *
	 * Las reglas que deben cumplir los campos alfanum&eacute;ricos son los siguientes:
	 *
	 * Se aceptan las letras del abecedario: a-z, A-Z
	 * No se aceptan las letras &ntilde; y &Ntilde;
	 * No se aceptan los acentos &aacute; &eacute; &iacute; &oacute; &uacute;
	 * Se aceptan los n&uacute;meros
	 * S&oacute;lo se aceptan los siguientes caracteres especiales: $  %  /  (  )  =  -
	 *  :  ;  *  +  ^  [  }  ]  {  .  �  ?  !  #  @  |
	 */
	private String store;
	/**
	 * Requerido: Ticket de venta, longitud 10
	 */
	private long ticket;
	/**
	 * Requerido, Identificador de sesi&oacute;n proporcionado por el Proveedor, el
	 * cual estar&aacute; formado de la siguiente manera: OXXO_XXXXXXXXXX con una
	 * longitud de 15,
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
	 */
	private String token;
	/**
	 * Requerido: Fecha de la transacci&oacute;n Formato: YYYYMMDDHHMiSS, longitud de
	 * 14; puede contener caracteres alfanum&eacute;ricos, num&eacute;ricos y
	 * especiales. que deben cumplir las siguientes reglas:
	 * Las reglas que deben cumplir los campos alfanum&eacute;ricos son los siguientes:
	 *
	 * Se aceptan las letras del abecedario: a-z, A-Z
	 * No se aceptan las letras &ntilde; y &Ntilde;
	 * No se aceptan los acentos &aacute; &eacute; &iacute; &oacute; &uacute;
	 * Se aceptan los n&uacute;meros
	 * S&oacute;lo se aceptan los siguientes caracteres especiales: $  %  /  (  )  =  -
	 *  :  ;  *  +  ^  [  }  ]  {  .  �  ?  !  #  @  |
	 */
	private String tranDate;

	/**
	 * constructor sin parametros.
	 */
	public PeticionEnLineaOxxo() {
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
	 * @return the adminDate
	 */
	public Long getAdminDate() {
		return adminDate;
	}

	/**
	 * @param adminDate the adminDate to set
	 */
	public void setAdminDate(Long adminDate) {
		this.adminDate = adminDate;
	}

	/**
	 * @return the amount
	 */
	public Long getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Long amount) {
		this.amount = amount;
	}

	/**
	 * @return the auth
	 */
	public long getAuth() {
		return auth;
	}

	/**
	 * @param auth the auth to set
	 */
	public void setAuth(long auth) {
		this.auth = auth;
	}

	/**
	 * @return the cashMachine
	 */
	public Integer getCashMachine() {
		return cashMachine;
	}

	/**
	 * @param cashMachine the cashMachine to set
	 */
	public void setCashMachine(Integer cashMachine) {
		this.cashMachine = cashMachine;
	}

	/**
	 * @return the client
	 */
	public String getClient() {
		return client;
	}

	/**
	 * @param client the client to set
	 */
	public void setClient(String client) {
		this.client = client;
	}

	/**
	 * @return the entryMode
	 */
	public String getEntryMode() {
		return entryMode;
	}

	/**
	 * @param entryMode the entryMode to set
	 */
	public void setEntryMode(String entryMode) {
		this.entryMode = entryMode;
	}

	/**
	 * @return the folio
	 */
	public Long getFolio() {
		return folio;
	}

	/**
	 * @param folio the folio to set
	 */
	public void setFolio(Long folio) {
		this.folio = folio;
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
	 * @return the store
	 */
	public String getStore() {
		return store;
	}

	/**
	 * @param store the store to set
	 */
	public void setStore(String store) {
		this.store = store;
	}

	/**
	 * @return the ticketDeVenta
	 */
	public long getTicket() {
		return ticket;
	}

	/**
	 * @param ticketDeVenta the ticketDeVenta to set
	 */
	public void setTicket(long ticketDeVenta) {
		this.ticket = ticketDeVenta;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the tranDate
	 */
	public String getTranDate() {
		return tranDate;
	}

	/**
	 * @param tranDate the tranDate to set
	 */
	public void setTranDate(String tranDate) {
		this.tranDate = tranDate;
	}

} //end PeticionEnLineaOxxo
