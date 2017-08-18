package utilitario.mensajes.operacion.pagos.oxxo;
/**
 * El cat&aacute;logo de estados de las operaciones engloba los c&oacute;digos de la Entidad Externa
 * y los c&oacute;digos de la plataforma central de integraci&oacute;n OXXO.
 * los codigos de error van de 00 -99
 * @author out_rmontellanom
 * @version 4.2
 */
public enum CatalogoDeEstados {

	/**
	 * c&oacute;digo para transacci&oacute;n exitosa
	 */
	CODIGO_00("00", "Transaccion Exitosa"),
	/**
	 * c&oacute;digo de error para xml mal formado
	 */
	CODIGO_01("01", "XML mal formado, verificar los siguientes campos: account, amount, folio"),
	/**
	 * c&oacute;digo para Contrato no v&aacute;lido
	 */
	CODIGO_02("02", "Contrato Inexistente"),
	/**
	 * c&oacute;digo de error para los datos requeridos
	 */
	CODIGO_04("04", "Folio Requerido"),
	/**
	 * c&oacute;digo de error para recuperar la fecha contable
	 */
	CODIGO_05("05", "No fue posible recuperar la fecha contable"),
	/**
	 * c&oacute;digo de error de que no existe el pago
	 */
	CODIGO_06("06", "No existe pago"),
	/**
	 * c&oacute;digo de error de que no existe el pago
	 */
	CODIGO_07("07", "No existe Folio para la operacion solicitada "),
	/**
	 * c&oacute;digo de error
	 */
	CODIGO_10("10", "Cliente con saldo en $0"),
	/**
	 * c&oacute;digo de error
	 */
	CODIGO_12("12", "Ocurrio un error al momento de la consulta"),
	/**
	 * c&oacute;digo de error de reversa
	 */
	CODIGO_13("13", "Ocurrio un error al momento de realizar la reversa"),
	/***
	 * c&oacute;digo de error de cliente en la peticion de consulta
	 */
	CODIGO_14("14", "Es necesario el numero de cliente"),
	/**
	 * c&oacute;digo de error El cliente excedio la longitud max 15 carateres
	 */
	CODIGO_15("15", "El cliente excedio la longitud max 15 carateres"),
	/**
	 * c&oacute;digo de error del total a pagar en la peticion
	 */
	CODIGO_18("18", "Es necesario el total a pagar en la peticion del servicio"),
	/**
	 * c&oacute;digo de pago realizado
	 */
	CODIGO_22("22", "Ocurrio un error al momento de realizar el pago"),
	/**
	 *  c&oacute;digo del formato de cliente
	 */
	CODIGO_23("23", "El formato del numero de cliente es incorrecto");

	/** codigo del mensaje
	 */
	private String codigo;
	/**
	 * descripcion del mensaje.
	 */
	private String titulo;

	/**
	 * constructor de la clase CatalogoDeEstados.
	 * @param cod c&oacute;digo de error
	 * @param tit descripci&oacute;n del mensaje
	 */
	private CatalogoDeEstados(String cod, String tit)
	{
		codigo = cod;
		titulo = tit;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

}
