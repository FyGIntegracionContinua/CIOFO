package utilitario.mensajes.burocredito;

import utilitario.mensajes.comun.ObjetoValor;

public class CuentaTLDTO  extends ObjetoValor {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 515245651858288658L;
	/**
	 * numeroCuentasAbiertas
	 */
	private int numeroCuentasAbiertas;
	/**
	 * numero de cuentas abiertas con saldos vencidos >= 1000
	 */
	private int numeroCuentasSaldoVencidoAbiertas;
	/**
	 * saldoVencidoAbiertas
	 */
	private double saldoVencidoAbiertas;
	/**
	 * saldoActual
	 */
	private double saldoActual;
	/**
	 * maximoAbiertas
	 */
	private double maximoAbiertas;
	/**
	 * fechaApertura
	 */
	private String fechaApertura;
	/**
	 * claves de observacion que contiene cada mop
	 */
	private String clavesObserv;

	/**
	 * Constructor
	 */
	public CuentaTLDTO() {
		numeroCuentasAbiertas = 0;
		saldoVencidoAbiertas = 0;
		saldoActual = 0;
		maximoAbiertas = 0;
		fechaApertura = "-";
		clavesObserv = " ";
	}

	/**
	 * @return the numeroCuentasAbiertas
	 */
	public int getNumeroCuentasAbiertas() {
		return numeroCuentasAbiertas;
	}

	/**
	 * @param numeroCuentasAbiertas the numeroCuentasAbiertas to set
	 */
	public void setNumeroCuentasAbiertas(int numeroCuentasAbiertas) {
		this.numeroCuentasAbiertas = numeroCuentasAbiertas;
	}

	/**
	 * @return the saldoVencidoAbiertas
	 */
	public double getSaldoVencidoAbiertas() {
		return saldoVencidoAbiertas;
	}

	/**
	 * @param saldoVencidoAbiertas the saldoVencidoAbiertas to set
	 */
	public void setSaldoVencidoAbiertas(double saldoVencidoAbiertas) {
		this.saldoVencidoAbiertas = saldoVencidoAbiertas;
	}

	/**
	 * @return the saldoActual
	 */
	public double getSaldoActual() {
		return saldoActual;
	}

	/**
	 * @param saldoActual the saldoActual to set
	 */
	public void setSaldoActual(double saldoActual) {
		this.saldoActual = saldoActual;
	}

	/**
	 * @return the maximoAbiertas
	 */
	public double getMaximoAbiertas() {
		return maximoAbiertas;
	}

	/**
	 * @param maximoAbiertas the maximoAbiertas to set
	 */
	public void setMaximoAbiertas(double maximoAbiertas) {
		this.maximoAbiertas = maximoAbiertas;
	}

	/**
	 * @return the fechaApertura
	 */
	public String getFechaApertura() {
		return fechaApertura;
	}

	/**
	 * @param fechaApertura the fechaApertura to set
	 */
	public void setFechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
	}

	/**
	 * @return the numeroCuentasSaldoVencidoAbiertas
	 */
	public int getNumeroCuentasSaldoVencidoAbiertas() {
		return numeroCuentasSaldoVencidoAbiertas;
	}

	/**
	 * @param numeroCuentasSaldoVencidoAbiertas the numeroCuentasSaldoVencidoAbiertas to set
	 */
	public void setNumeroCuentasSaldoVencidoAbiertas(int numeroCuentasSaldoVencidoAbiertas) {
		this.numeroCuentasSaldoVencidoAbiertas = numeroCuentasSaldoVencidoAbiertas;
	}

	/**
	 * @return the clavesObserv
	 */
	public String getClavesObserv() {
		return clavesObserv;
	}

	/**
	 * @param clavesObserv the clavesObserv to set
	 */
	public void setClavesObserv(String clavesObserv) {
		this.clavesObserv = clavesObserv;
	}

}
