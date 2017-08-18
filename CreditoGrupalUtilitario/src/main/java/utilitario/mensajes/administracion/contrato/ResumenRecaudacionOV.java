package utilitario.mensajes.administracion.contrato;

import java.io.Serializable;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ResumenRecaudacionOV.
 */
public class ResumenRecaudacionOV extends ObjetoValor implements Serializable {

	/**
	 * Instancia una nueva resumen recaudacion ov.
	 */
	public ResumenRecaudacionOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1816582888175118591L;

	/** The integrante. */
	private String 	integrante;

	/** The clave t24. */
	private String 	claveT24;

	/** The nombre completo. */
	private String	nombreCompleto;

	/** The pago pactado. */
	private Double 	pagoPactado;

	/** The monto total. */
	private Double 	montoTotal;

	/** The pago recibido. */
	private Double 	pagoRecibido;

	/** The saldo total acta. */
	private Double 	saldoTotalActa;

	/** The saldo total sistema. */
	private Double 	saldoTotalSistema;

	/** The monto solidario. */
	private Double 	montoSolidario;

	/** The puntual. */
	private Integer puntual;

	/** The inpuntual. */
	private Integer inpuntual;

	/** The no asistio. */
	private Integer noAsistio;

	/** The envio. */
	private Integer envio;

	/** The saldo ahorro. */
	private java.lang.Double saldoAhorro;


	/**
	 * Establece integrante.
	 *
	 * @param integrante a integrante
	 */
	public void setIntegrante(String integrante) {
		this.integrante = integrante;
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
	 * Establece clave t24.
	 *
	 * @param claveT24 a clave t24
	 */
	public void setClaveT24(String claveT24) {
		this.claveT24 = claveT24;
	}

	/**
	 * Obtiene clave t24.
	 *
	 * @return clave t24
	 */
	public String getClaveT24() {
		return claveT24;
	}

	/**
	 * Establece nombre completo.
	 *
	 * @param nombreCompleto a nombre completo
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	/**
	 * Obtiene nombre completo.
	 *
	 * @return nombre completo
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	/**
	 * Establece pago pactado.
	 *
	 * @param pagoPactado a pago pactado
	 */
	public void setPagoPactado(Double pagoPactado) {
		this.pagoPactado = pagoPactado;
	}

	/**
	 * Obtiene pago pactado.
	 *
	 * @return pago pactado
	 */
	public Double getPagoPactado() {
		return pagoPactado;
	}

	/**
	 * Establece monto total.
	 *
	 * @param montoTotal a monto total
	 */
	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}

	/**
	 * Obtiene monto total.
	 *
	 * @return monto total
	 */
	public Double getMontoTotal() {
		return montoTotal;
	}

	/**
	 * Establece pago recibido.
	 *
	 * @param pagoRecibido a pago recibido
	 */
	public void setPagoRecibido(Double pagoRecibido) {
		this.pagoRecibido = pagoRecibido;
	}

	/**
	 * Obtiene pago recibido.
	 *
	 * @return pago recibido
	 */
	public Double getPagoRecibido() {
		return pagoRecibido;
	}

	/**
	 * Establece saldo total acta.
	 *
	 * @param saldoTotalActa a saldo total acta
	 */
	public void setSaldoTotalActa(Double saldoTotalActa) {
		this.saldoTotalActa = saldoTotalActa;
	}

	/**
	 * Obtiene saldo total acta.
	 *
	 * @return saldo total acta
	 */
	public Double getSaldoTotalActa() {
		return saldoTotalActa;
	}

	/**
	 * Establece saldo total sistema.
	 *
	 * @param saldoTotalSistema a saldo total sistema
	 */
	public void setSaldoTotalSistema(Double saldoTotalSistema) {
		this.saldoTotalSistema = saldoTotalSistema;
	}

	/**
	 * Obtiene saldo total sistema.
	 *
	 * @return saldo total sistema
	 */
	public Double getSaldoTotalSistema() {
		return saldoTotalSistema;
	}

	/**
	 * Establece monto solidario.
	 *
	 * @param montoSolidario a monto solidario
	 */
	public void setMontoSolidario(Double montoSolidario) {
		this.montoSolidario = montoSolidario;
	}

	/**
	 * Obtiene monto solidario.
	 *
	 * @return monto solidario
	 */
	public Double getMontoSolidario() {
		return montoSolidario;
	}

	/**
	 * Establece puntual.
	 *
	 * @param puntual a puntual
	 */
	public void setPuntual(Integer puntual) {
		this.puntual = puntual;
	}

	/**
	 * Obtiene puntual.
	 *
	 * @return puntual
	 */
	public Integer getPuntual() {
		return puntual;
	}

	/**
	 * Establece inpuntual.
	 *
	 * @param inpuntual a inpuntual
	 */
	public void setInpuntual(Integer inpuntual) {
		this.inpuntual = inpuntual;
	}

	/**
	 * Obtiene inpuntual.
	 *
	 * @return inpuntual
	 */
	public Integer getInpuntual() {
		return inpuntual;
	}

	/**
	 * Establece envio.
	 *
	 * @param envio a envio
	 */
	public void setEnvio(Integer envio) {
		this.envio = envio;
	}

	/**
	 * Obtiene envio.
	 *
	 * @return envio
	 */
	public Integer getEnvio() {
		return envio;
	}

	/**
	 * Establece no asistio.
	 *
	 * @param noAsistio a no asistio
	 */
	public void setNoAsistio(Integer noAsistio) {
		this.noAsistio = noAsistio;
	}

	/**
	 * Obtiene no asistio.
	 *
	 * @return no asistio
	 */
	public Integer getNoAsistio() {
		return noAsistio;
	}

	/**
	 * Obtiene saldo ahorro.
	 *
	 * @return the saldoAhorro
	 */
	public java.lang.Double getSaldoAhorro() {
		return saldoAhorro;
	}

	/**
	 * Establece saldo ahorro.
	 *
	 * @param saldoAhorro the saldoAhorro to set
	 */
	public void setSaldoAhorro(java.lang.Double saldoAhorro) {
		this.saldoAhorro = saldoAhorro;
	}

}
