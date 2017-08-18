package utilitario.mensajes.comun;

/**
 * The Class AmortizacionOV.
 */
public class AmortizacionOV extends ObjetoValor {

	/**
	 * Instancia una nueva amortizacion ov.
	 */
	public AmortizacionOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3446483033252490776L;

	/** The tipo amort. */
	private String tipoAmort;

	/** The integrante. */
	private String integrante;

	/** The no pago. */
	private Integer noPago;
//	private Date fechaPago;
	/** The fecha pago. */
	private String fechaPago;

	/** The monto pago. */
	private Double montoPago;

	/** The monto pago red. */
	private Double montoPagoRed;

	/** The abono capital. */
	private Double abonoCapital;

	/** The interes periodo. */
	private Double interesPeriodo;

	/** The saldo capital. */
	private Double saldoCapital;

	/**
	 * Obtiene tipo amort.
	 *
	 * @return tipo amort
	 */
	public String getTipoAmort() {
		return tipoAmort;
	}

	/**
	 * Establece tipo amort.
	 *
	 * @param tipo a tipo amort
	 */
	public void setTipoAmort(String tipo) {
		this.tipoAmort = tipo;
	}

	/**
	 * Obtiene no pago.
	 *
	 * @return no pago
	 */
	public Integer getNoPago() {
		return noPago;
	}

	/**
	 * Establece no pago.
	 *
	 * @param noPago a no pago
	 */
	public void setNoPago(Integer noPago) {
		this.noPago = noPago;
	}

//	public Date getFechaPago() {
//		return fechaPago;
//	}
//
//	public void setFechaPago(Date fechaPago) {
//		this.fechaPago = fechaPago;
//	}

	/**
 * Obtiene monto pago.
 *
 * @return monto pago
 */
public Double getMontoPago() {
		return montoPago;
	}

	/**
	 * Establece monto pago.
	 *
	 * @param montoPago a monto pago
	 */
	public void setMontoPago(Double montoPago) {
		this.montoPago = montoPago;
	}

	/**
	 * Obtiene monto pago red.
	 *
	 * @return monto pago red
	 */
	public Double getMontoPagoRed() {
		return montoPagoRed;
	}

	/**
	 * Establece monto pago red.
	 *
	 * @param montoPagoRed a monto pago red
	 */
	public void setMontoPagoRed(Double montoPagoRed) {
		this.montoPagoRed = montoPagoRed;
	}

	/**
	 * Obtiene abono capital.
	 *
	 * @return abono capital
	 */
	public Double getAbonoCapital() {
		return abonoCapital;
	}

	/**
	 * Establece abono capital.
	 *
	 * @param abonoCapital a abono capital
	 */
	public void setAbonoCapital(Double abonoCapital) {
		this.abonoCapital = abonoCapital;
	}

	/**
	 * Obtiene interes periodo.
	 *
	 * @return interes periodo
	 */
	public Double getInteresPeriodo() {
		return interesPeriodo;
	}

	/**
	 * Establece interes periodo.
	 *
	 * @param interesPeriodo a interes periodo
	 */
	public void setInteresPeriodo(Double interesPeriodo) {
		this.interesPeriodo = interesPeriodo;
	}

	/**
	 * Obtiene saldo capital.
	 *
	 * @return saldo capital
	 */
	public Double getSaldoCapital() {
		return saldoCapital;
	}

	/**
	 * Establece saldo capital.
	 *
	 * @param saldoCapital a saldo capital
	 */
	public void setSaldoCapital(Double saldoCapital) {
		this.saldoCapital = saldoCapital;
	}

	/**
	 * Obtiene integrante.
	 *
	 * @return integrante
	 */
	public String getIntegrante() {
		return integrante;
	}

	/**
	 * Establece integrante.
	 *
	 * @param integrante a integrante
	 */
	public void setIntegrante(String integrante) {
		this.integrante = integrante;
	}

	/**
	 * Obtiene fecha pago.
	 *
	 * @return fecha pago
	 */
	public String getFechaPago() {
		return fechaPago;
	}

	/**
	 * Establece fecha pago.
	 *
	 * @param fechaPago a fecha pago
	 */
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}


}
