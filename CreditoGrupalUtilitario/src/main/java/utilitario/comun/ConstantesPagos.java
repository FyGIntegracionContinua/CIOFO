package utilitario.comun;

/**
 * The Enum ConstantesPagos.
 */
public enum ConstantesPagos {

	/** The usuario pago. */
	USUARIO_PAGO ("000000043"),

	/** The pago bonificacion. */
	PAGO_BONIFICACION("BOGE"),

	/** The pago oficina central. */
	PAGO_OFICINA_CENTRAL("PAOC"),

	/** The pago referenciado. */
	PAGO_REFERENCIADO("PREF"),

	/** The medio recepcion fsol. */
	MEDIO_RECEPCION_FSOL("FSOL"),

	/** The BONIFICACIO n_ referenci a1. */
	BONIFICACION_REFERENCIA1(" "),

	/** The BONIFICACIO n_ referenci a2. */
	BONIFICACION_REFERENCIA2(" "),

	/** The tipo pago normal. */
	TIPO_PAGO_NORMAL("NORM"),

	/** The tipo pago abono. */
	TIPO_PAGO_ABONO("ABO"),

	/**The tipo Empresa para Diestel */
	EMPRESA("2"),

	/**The tipo producto para Diestel */
	PRODUCTO("01");

	/** The value. */
	String value;

	/**
	 * Obtiene value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Instancia una nueva constantes pagos.
	 *
	 * @param a the a
	 */
	private ConstantesPagos(String a) {
	value = a;
	}


}
