/**
 * Nueva clase RECU-174
 */
package utilitario.mensajes.comun;

/**
 * @author hsamano
 *
 */
public class AmortizacionActualOV extends ObjetoValor {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = -2678114916542836830L;

	/** Numero de pago */
	private String noPago;

	/** Fecha pago */
	private String fechaPago;

	/** Abono a capital */
	private Double abonoCapital;

	/** Prima del Seguro */
	private Double primaSeguro;

	/** Comisiones */
	private Double comisiones;

	/** Interes del periodo */
	private Double interesPeriodo;

	/** Iva del interes periodo */
	private Double ivaInteresPeriodo;

	/** Moratorios */
	private Double moratorios;

	/** Iva Moratorios */
	private Double ivaMoratorios;

	/** Gastos de cobranza */
	private Double gastosCobranza;

	/** Iva de los Gastos de cobranza */
	private Double ivaGastosCobranza;

	/** Monto pago */
	private Double montoPago;

	/** Saldo capital */
	private Double saldoCapital;

	/**
	 * @return the noPago
	 */
	public String getNoPago() {
		return noPago;
	}

	/**
	 * @param noPago the noPago to set
	 */
	public void setNoPago(String noPago) {
		this.noPago = noPago;
	}

	/**
	 * @return the fechaPago
	 */
	public String getFechaPago() {
		return fechaPago;
	}

	/**
	 * @param fechaPago the fechaPago to set
	 */
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	/**
	 * @return the abonoCapital
	 */
	public Double getAbonoCapital() {
		return abonoCapital;
	}

	/**
	 * @param abonoCapital the abonoCapital to set
	 */
	public void setAbonoCapital(Double abonoCapital) {
		this.abonoCapital = abonoCapital;
	}

	/**
	 * @return the primaSeguro
	 */
	public Double getPrimaSeguro() {
		return primaSeguro;
	}

	/**
	 * @param primaSeguro the primaSeguro to set
	 */
	public void setPrimaSeguro(Double primaSeguro) {
		this.primaSeguro = primaSeguro;
	}

	/**
	 * @return the comisiones
	 */
	public Double getComisiones() {
		return comisiones;
	}

	/**
	 * @param comisiones the comisiones to set
	 */
	public void setComisiones(Double comisiones) {
		this.comisiones = comisiones;
	}

	/**
	 * @return the interesPeriodo
	 */
	public Double getInteresPeriodo() {
		return interesPeriodo;
	}

	/**
	 * @param interesPeriodo the interesPeriodo to set
	 */
	public void setInteresPeriodo(Double interesPeriodo) {
		this.interesPeriodo = interesPeriodo;
	}

	/**
	 * @return the ivaInteresPeriodo
	 */
	public Double getIvaInteresPeriodo() {
		return ivaInteresPeriodo;
	}

	/**
	 * @param ivaInteresPeriodo the ivaInteresPeriodo to set
	 */
	public void setIvaInteresPeriodo(Double ivaInteresPeriodo) {
		this.ivaInteresPeriodo = ivaInteresPeriodo;
	}

	/**
	 * @return the moratorios
	 */
	public Double getMoratorios() {
		return moratorios;
	}

	/**
	 * @param moratorios the moratorios to set
	 */
	public void setMoratorios(Double moratorios) {
		this.moratorios = moratorios;
	}

	/**
	 * @return the ivaMoratorios
	 */
	public Double getIvaMoratorios() {
		return ivaMoratorios;
	}

	/**
	 * @param ivaMoratorios the ivaMoratorios to set
	 */
	public void setIvaMoratorios(Double ivaMoratorios) {
		this.ivaMoratorios = ivaMoratorios;
	}

	/**
	 * @return the ivaGastosCobranza
	 */
	public Double getIvaGastosCobranza() {
		return ivaGastosCobranza;
	}

	/**
	 * @param ivaGastosCobranza the ivaGastosCobranza to set
	 */
	public void setIvaGastosCobranza(Double ivaGastosCobranza) {
		this.ivaGastosCobranza = ivaGastosCobranza;
	}

	/**
	 * @return the montoPago
	 */
	public Double getMontoPago() {
		return montoPago;
	}

	/**
	 * @param montoPago the montoPago to set
	 */
	public void setMontoPago(Double montoPago) {
		this.montoPago = montoPago;
	}

	/**
	 * @return the saldoCapital
	 */
	public Double getSaldoCapital() {
		return saldoCapital;
	}

	/**
	 * @param saldoCapital the saldoCapital to set
	 */
	public void setSaldoCapital(Double saldoCapital) {
		this.saldoCapital = saldoCapital;
	}

	/**
	 * @return the gastosCobranza
	 */
	public Double getGastosCobranza() {
		return gastosCobranza;
	}

	/**
	 * @param gastosCobranza the gastosCobranza to set
	 */
	public void setGastosCobranza(Double gastosCobranza) {
		this.gastosCobranza = gastosCobranza;
	}
}
