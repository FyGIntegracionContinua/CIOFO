package utilitario.mensajes.operacion.pagos.oxxo;
/**
 * variabes que se ocupan en los test.
 * @author out_rmontellanom
 * @version 4.2
 */
public enum VariablesTestOxxo {
	/**
	 * dato de prueba.
	 */
	TRANDATE(20110110091520L),
	/**
	 * dato de prueba.
	 */
	AMOUNT(130.00),
	/**
	 * dato de prueba.
	 */
	AUTH(123244),
	/**
	 * dato de prueba.
	 */
	MONTO(150.00),
	/**
	 * dato de prueba.
	 */
	FOLIO(123455L),
	/**
	 * dato de prueba.
	 */
	AUT2(14L),
	/**
	 * dato de prueba.
	 */
	REVERSE(1234D),
	/**
	 * dato de prueba.
	 */
	AMOUNT2(13000L),
	/**
	 * dato de prueba.
	 */
	REVERSE2(437587458748571234L),
	/**
	 * ticket
	 */
	TICKET(1234567890L);
	/**
	 * dato de prueba.
	 */
	private Long fecha;
	/**
	 * dato de prueba.
	 */
	private Double am;
	/**
	 * dato de prueba.
	 */
	private Integer aut;

	/**
	 * contrictor que recibe un long
	 * @param date tipo long
	 */
	private VariablesTestOxxo(Long date) {
		fecha = date;
	}
	/**
	 * contrictor que recibe un double
	 * @param amount tipo double
	 */
	private VariablesTestOxxo(Double amount) {
		am = amount;
	}
	/**
	 * contructor que recibe un integer
	 * @param auth tipo integer
	 */
	private VariablesTestOxxo(Integer auth) {
		aut = auth;
	}

	/**
	 * @return the fecha
	 */
	public Long getFecha() {
		return fecha;
	}

	/**
	 * @return the am
	 */
	public Double getAm() {
		return am;
	}

	/**
	 * @return the aut
	 */
	public Integer getAut() {
		return aut;
	}

}
