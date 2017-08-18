package utilitario.mensajes.burocredito;

import utilitario.mensajes.comun.ObjetoValor;

public class ResumenBuroMop extends ObjetoValor implements Comparable<ResumenBuroMop> {
	
	/**id de transaccion*/
	private static final long serialVersionUID = -1243541805791854889L;

//-------------------------cuentas abiertas ---------------------------------	
	/**indice de mops*/
	private int index;

	/**mops del credito*/
	private String mop;
	
	/**numero de ceuntas abiertas CA*/
	private int cuentasAbiertas;
	
	/**limite de cuentas abiertas*/
	private double limiteAbiertas;
	
	/**maximo de cuentas abiertas*/
	private double maximoAbiertas;
	
	/**saldo actual de cuentas abiertas SAA*/
	private double saldoActualAbiertas;
	
	/**saldo actual de cuentas abiertas SAA con formato de moneda*/
	private String formatoSaldoActualAbiertas;
	
	/**saldo vencido de cuentas abiertas SVA*/
	private double saldoVencidoAbiertas;
	
	/**saldo vencido de cuentas abiertas SVA con formato de moneda*/
	private String formatoSaldoVencidoAbiertas;
	
	/**pagos realizados*/
	private double pagoARealizar;

	//-------------------------cuentas cerradas ---------------------------------	
	/**cuentas cerradas  CC*/
	private int cuentasCerradas;
	
	/**limite de cuentas cerradas*/
	private double limiteCerradas;
	
	/**maximo de cuentas cerradas*/
	private double maximoCerradas;
	
	/**saldo actual cerradas SAC*/
	private double saldoActualCerradas;
	
	/**saldo actual cerradas SAC con formato de moneda*/
	private String formatoSaldoActualCerradas;
	
	/**monto cerrados MC*/
	private double montoCerradas;
	
	/**monto cerrados MC con formato de moneda*/
	private String formatoMontoCerradas;
	
	// ------------------------claves de observacion, solicitudes hipotecarios y automotrices------------
	/**claves de observacion*/
	private String claveObservacion;
	
	/**creditos hipotecarios*/
	private String hipotecario;
	
	/**credito automotriz*/
	private String automotriz;
	
	/**color de fondo*/
	private String styleBackground;

	/**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}



	/**
	 * @param index the index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}



	/**
	 * @return the mop
	 */
	public String getMop() {
		return mop;
	}



	/**
	 * @param mop the mop to set
	 */
	public void setMop(String mop) {
		this.mop = mop;
	}



	/**
	 * @return the cuentasAbiertas
	 */
	public int getCuentasAbiertas() {
		return cuentasAbiertas;
	}



	/**
	 * @param cuentasAbiertas the cuentasAbiertas to set
	 */
	public void setCuentasAbiertas(int cuentasAbiertas) {
		this.cuentasAbiertas = cuentasAbiertas;
	}



	/**
	 * @return the limiteAbiertas
	 */
	public double getLimiteAbiertas() {
		return limiteAbiertas;
	}



	/**
	 * @param limiteAbiertas the limiteAbiertas to set
	 */
	public void setLimiteAbiertas(double limiteAbiertas) {
		this.limiteAbiertas = limiteAbiertas;
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
	 * @return the saldoActualAbiertas
	 */
	public double getSaldoActualAbiertas() {
		return saldoActualAbiertas;
	}



	/**
	 * @param saldoActualAbiertas the saldoActualAbiertas to set
	 */
	public void setSaldoActualAbiertas(double saldoActualAbiertas) {
		this.saldoActualAbiertas = saldoActualAbiertas;
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
	 * @return the pagoARealizar
	 */
	public double getPagoARealizar() {
		return pagoARealizar;
	}



	/**
	 * @param pagoARealizar the pagoARealizar to set
	 */
	public void setPagoARealizar(double pagoARealizar) {
		this.pagoARealizar = pagoARealizar;
	}



	/**
	 * @return the cuentasCerradas
	 */
	public int getCuentasCerradas() {
		return cuentasCerradas;
	}



	/**
	 * @param cuentasCerradas the cuentasCerradas to set
	 */
	public void setCuentasCerradas(int cuentasCerradas) {
		this.cuentasCerradas = cuentasCerradas;
	}



	/**
	 * @return the limiteCerradas
	 */
	public double getLimiteCerradas() {
		return limiteCerradas;
	}



	/**
	 * @param limiteCerradas the limiteCerradas to set
	 */
	public void setLimiteCerradas(double limiteCerradas) {
		this.limiteCerradas = limiteCerradas;
	}



	/**
	 * @return the maximoCerradas
	 */
	public double getMaximoCerradas() {
		return maximoCerradas;
	}



	/**
	 * @param maximoCerradas the maximoCerradas to set
	 */
	public void setMaximoCerradas(double maximoCerradas) {
		this.maximoCerradas = maximoCerradas;
	}



	/**
	 * @return the saldoActualCerradas
	 */
	public double getSaldoActualCerradas() {
		return saldoActualCerradas;
	}



	/**
	 * @param saldoActualCerradas the saldoActualCerradas to set
	 */
	public void setSaldoActualCerradas(double saldoActualCerradas) {
		this.saldoActualCerradas = saldoActualCerradas;
	}



	/**
	 * @return the montoCerradas
	 */
	public double getMontoCerradas() {
		return montoCerradas;
	}



	/**
	 * @param montoCerradas the montoCerradas to set
	 */
	public void setMontoCerradas(double montoCerradas) {
		this.montoCerradas = montoCerradas;
	}
	

    /**
	 * @return the claveObservacion
	 */
	public String getClaveObservacion() {
		return claveObservacion;
	}



	/**
	 * @param claveObservacion the claveObservacion to set
	 */
	public void setClaveObservacion(String claveObservacion) {
		this.claveObservacion = claveObservacion;
	}


	/**
	 * @return the hipotecario
	 */
	public String getHipotecario() {
		return hipotecario;
	}



	/**
	 * @param hipotecario the hipotecario to set
	 */
	public void setHipotecario(String hipotecario) {
		this.hipotecario = hipotecario;
	}



	/**
	 * @return the automotriz
	 */
	public String getAutomotriz() {
		return automotriz;
	}



	/**
	 * @param automotriz the automotriz to set
	 */
	public void setAutomotriz(String automotriz) {
		this.automotriz = automotriz;
	}

	/**
	 * @return the styleBackground
	 */
	public String getStyleBackground() {
		return styleBackground;
	}



	/**
	 * @param styleBackground the styleBackground to set
	 */
	public void setStyleBackground(String styleBackground) {
		this.styleBackground = styleBackground;
	}

	/**
	 * @return the formatoSaldoActualAbiertas
	 */
	public String getFormatoSaldoActualAbiertas() {
		return formatoSaldoActualAbiertas;
	}



	/**
	 * @param formatoSaldoActualAbiertas the formatoSaldoActualAbiertas to set
	 */
	public void setFormatoSaldoActualAbiertas(String formatoSaldoActualAbiertas) {
		this.formatoSaldoActualAbiertas = formatoSaldoActualAbiertas;
	}



	/**
	 * @return the formatoSaldoVencidoAbiertas
	 */
	public String getFormatoSaldoVencidoAbiertas() {
		return formatoSaldoVencidoAbiertas;
	}



	/**
	 * @param formatoSaldoVencidoAbiertas the formatoSaldoVencidoAbiertas to set
	 */
	public void setFormatoSaldoVencidoAbiertas(String formatoSaldoVencidoAbiertas) {
		this.formatoSaldoVencidoAbiertas = formatoSaldoVencidoAbiertas;
	}



	/**
	 * @return the formatoSaldoActualCerradas
	 */
	public String getFormatoSaldoActualCerradas() {
		return formatoSaldoActualCerradas;
	}



	/**
	 * @param formatoSaldoActualCerradas the formatoSaldoActualCerradas to set
	 */
	public void setFormatoSaldoActualCerradas(String formatoSaldoActualCerradas) {
		this.formatoSaldoActualCerradas = formatoSaldoActualCerradas;
	}



	/**
	 * @return the fromatoMontoCerradas
	 */
	public String getFormatoMontoCerradas() {
		return formatoMontoCerradas;
	}



	/**
	 * @param fromatoMontoCerradas the fromatoMontoCerradas to set
	 */
	public void setFormatoMontoCerradas(String formatoMontoCerradas) {
		this.formatoMontoCerradas = formatoMontoCerradas;
	}
	
	/**
     * metodo comparador
     * @param compare objeto a comparar
     * @return int entero
     */
	public int compareTo(ResumenBuroMop compare) {

		return compare.getMop().compareTo(this.getMop());

	}

	/* (non-Javadoc)
	 * @see utilitario.mensajes.comun.ObjetoValor#toString()
	 */
	@Override
	public String toString() {
		return "mop:" + mop + "\tcuentasAbiertas:" + cuentasAbiertas + "\tsaldoActualAbiertas:" + saldoActualAbiertas
			 + "\tsaldoVencidoAbiertas:" + saldoVencidoAbiertas + "\tcuentasCerradas:" + cuentasCerradas + "\tsaldoActualCerradas:"
			 + saldoActualCerradas + "\tmontoCerradas:" + montoCerradas + "\tclaveObservacion:" + claveObservacion
			 + "\thipotecario:" + hipotecario + "\tautomotriz:" + automotriz + "\tindex:" + index + "\tstyleBackground:"
			 + styleBackground;	
	}
	
	
}
