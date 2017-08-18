package utilitario.mensajes.reportes.comun;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class PagoOV.
 */
public class PagoOV extends ObjetoValor {

	/**
	 * PagoOV.
	 */
	public PagoOV() {

	}

	/** long serialVersionUID. */
	private static final long serialVersionUID = 1169484644837892030L;

	/** Date fechaContable. */
	private Date fechaContable;

	/** Funje como fecha esperada y fecha de pago. */
	private Date fechaEsperada;

	/** Double capital. */
	private Double capital;

	/** Double interes. */
	private Double interes;

	/** Double moratorio. */
	private Double moratorio;

	/** Double cobranza. */
	private Double cobranza;

	/** solo para pagos vencidos. */
	private Double iva;

	/** Double total. */
	private Double total;

	/** Integer atraso. */
	private Integer atraso;

	/** Integer numeroPago. */
	private Integer numeroPago;

	/** String referenciaPago. */
	private String referenciaPago;

	/** Double otros. */
	private Double otros;

	/** Double saldo. */
	private Double saldo;

	/** String fechaPago. */
	private String fechaPago;

	/**
	 * Obtiene fecha contable.
	 *
	 * @return the fechaContable
	 */
	public Date getFechaContable() {
		return fechaContable;
	}

	/**
	 * Establece fecha contable.
	 *
	 * @param fechaContable the fechaContable to set
	 */
	public void setFechaContable(Date fechaContable) {
		this.fechaContable = fechaContable;
	}

	/**
	 * Obtiene fecha esperada.
	 *
	 * @return the fechaEsperada
	 */
	public Date getFechaEsperada() {
		return fechaEsperada;
	}

	/**
	 * Establece fecha esperada.
	 *
	 * @param fechaEsperada the fechaEsperada to set
	 */
	public void setFechaEsperada(Date fechaEsperada) {
		this.fechaEsperada = fechaEsperada;
	}

	/**
	 * Obtiene capital.
	 *
	 * @return the capital
	 */
	public Double getCapital() {
		return capital;
	}

	/**
	 * Establece capital.
	 *
	 * @param capital the capital to set
	 */
	public void setCapital(Double capital) {
		this.capital = capital;
	}

	/**
	 * Obtiene interes.
	 *
	 * @return the interes
	 */
	public Double getInteres() {
		return interes;
	}

	/**
	 * Establece interes.
	 *
	 * @param interes the interes to set
	 */
	public void setInteres(Double interes) {
		this.interes = interes;
	}

	/**
	 * Obtiene moratorio.
	 *
	 * @return the moratorio
	 */
	public Double getMoratorio() {
		return moratorio;
	}

	/**
	 * Establece moratorio.
	 *
	 * @param moratorio the moratorio to set
	 */
	public void setMoratorio(Double moratorio) {
		this.moratorio = moratorio;
	}

	/**
	 * Obtiene cobranza.
	 *
	 * @return the cobranza
	 */
	public Double getCobranza() {
		return cobranza;
	}

	/**
	 * Establece cobranza.
	 *
	 * @param cobranza the cobranza to set
	 */
	public void setCobranza(Double cobranza) {
		this.cobranza = cobranza;
	}

	/**
	 * Obtiene iva.
	 *
	 * @return the iva
	 */
	public Double getIva() {
		return iva;
	}

	/**
	 * Establece iva.
	 *
	 * @param iva the iva to set
	 */
	public void setIva(Double iva) {
		this.iva = iva;
	}

	/**
	 * Obtiene total.
	 *
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}

	/**
	 * Establece total.
	 *
	 * @param total the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}

	/**
	 * Obtiene atraso.
	 *
	 * @return the atraso
	 */
	public Integer getAtraso() {
		return atraso;
	}

	/**
	 * Establece atraso.
	 *
	 * @param atraso the atraso to set
	 */
	public void setAtraso(Integer atraso) {
		this.atraso = atraso;
	}

	/**
	 * Obtiene numero pago.
	 *
	 * @return the numeroPago
	 */
	public Integer getNumeroPago() {
		return numeroPago;
	}

	/**
	 * Establece numero pago.
	 *
	 * @param numeroPago the numeroPago to set
	 */
	public void setNumeroPago(Integer numeroPago) {
		this.numeroPago = numeroPago;
	}

	/**
	 * Obtiene referencia pago.
	 *
	 * @return the referenciaPago
	 */
	public String getReferenciaPago() {
		return referenciaPago;
	}

	/**
	 * Establece referencia pago.
	 *
	 * @param referenciaPago the referenciaPago to set
	 */
	public void setReferenciaPago(String referenciaPago) {
		this.referenciaPago = referenciaPago;
	}

	/**
	 * Obtiene otros.
	 *
	 * @return the otros
	 */
	public Double getOtros() {
		return otros;
	}

	/**
	 * Establece otros.
	 *
	 * @param otros the otros to set
	 */
	public void setOtros(Double otros) {
		this.otros = otros;
	}

	/**
	 * Obtiene saldo.
	 *
	 * @return the saldo
	 */
	public Double getSaldo() {
		return saldo;
	}

	/**
	 * Establece saldo.
	 *
	 * @param saldo the saldo to set
	 */
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	/**
	 * Obtiene fecha pago.
	 *
	 * @return the fechaPago
	 */
	public String getFechaPago() {
		return fechaPago;
	}

	/**
	 * Establece fecha pago.
	 *
	 * @param fechaPago the fechaPago to set
	 */
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

}
