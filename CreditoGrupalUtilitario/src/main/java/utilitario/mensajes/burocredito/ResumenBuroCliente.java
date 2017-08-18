package utilitario.mensajes.burocredito;

import java.util.List;

import utilitario.mensajes.comun.ObjetoValor;

public class ResumenBuroCliente extends ObjetoValor {

	/**id unico de transaccion*/
	private static final long serialVersionUID = 3103609398823575173L;

	/**numero de cliente*/
	private int indice;

	/**numero de persona*/
	private String numeroPersona;

	/**nombre del cliente*/
	private String nombreCompleto;

	/**lista de mops del cliente*/
	private List<ResumenBuroMop> mops;

	/**tamaño de la lista de mops*/
	private int sizeMops;

	/**numero de solicitudes en los ultimos 6 meses*/
	private int historicoFinsol;

	//por cuestiones de mostrar datos se agrgan los siguientes datos
	//-------------------------cuentas abiertas ---------------------------------
		/**indice de mops*/
		private int index;

		/**mops del credito*/
		private String mop;

		/**numero de ceuntas abiertas CA*/
		private int cuentasAbiertas;

		/**saldo actual de cuentas abiertas SAA*/
		private double saldoActualAbiertas;

		/**saldo actual de cuentas abiertas SAA con formato de moneda*/
		private String formatoSaldoActualAbiertas;

		/**saldo vencido de cuentas abiertas SVA*/
		private double saldoVencidoAbiertas;

		/**saldo vencido de cuentas abiertas SVA con formato de moneda*/
		private String formatoSaldoVencidoAbiertas;

		//-------------------------cuentas cerradas ---------------------------------
		/**cuentas cerradas  CC*/
		private int cuentasCerradas;

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

		/**color de fondo de mops*/
		private String styleBackground;

		/**color de fondo del renglon de la tabla*/
		private String backgroundFila;

		/**The montoCicloAnterior. */
		private String montoCicloAnterior;

		/**The montoSolicitadoAproElec. */
		private String montoSolicitadoAproElec;

		/**The buroHistorico. */
		private String buroHistorico;

		/**The urlIconoPdf. */
		private String urlIconoPdf;

	/**
	 * @return the indice
	 */
	public int getIndice() {
		return indice;
	}

	/**
	 * @param indice the indice to set
	 */
	public void setIndice(int indice) {
		this.indice = indice;
	}

	/**
	 * @return the numeroPersona
	 */
	public String getNumeroPersona() {
		return numeroPersona;
	}

	/**
	 * @param numeroPersona the numeroPersona to set
	 */
	public void setNumeroPersona(String numeroPersona) {
		this.numeroPersona = numeroPersona;
	}

	/**
	 * @return the nombreCompleto
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	/**
	 * @param nombreCompleto the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	/**
	 * @return the mops
	 */
	public List<ResumenBuroMop> getMops() {
		return mops;
	}

	/**
	 * @param mops the mops to set
	 */
	public void setMops(List<ResumenBuroMop> mops) {
		this.mops = mops;
	}

	/**
	 * @return the sizeMops
	 */
	public int getSizeMops() {
		return sizeMops;
	}

	/**
	 * @param sizeMops the sizeMops to set
	 */
	public void setSizeMops(int sizeMops) {
		this.sizeMops = sizeMops;
	}

	/**
	 * @return the historicoFinsol
	 */
	public int getHistoricoFinsol() {
		return historicoFinsol;
	}

	/**
	 * @param historicoFinsol the historicoFinsol to set
	 */
	public void setHistoricoFinsol(int historicoFinsol) {
		this.historicoFinsol = historicoFinsol;
	}

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
	 * @return the backgroundFila
	 */
	public String getBackgroundFila() {
		return backgroundFila;
	}

	/**
	 * @param backgroundFila the backgroundFila to set
	 */
	public void setBackgroundFila(String backgroundFila) {
		this.backgroundFila = backgroundFila;
	}

	/**
	 * @return the montoCicloAnterior
	 */
	public String getMontoCicloAnterior() {
		return montoCicloAnterior;
	}

	/**
	 * @param montoCicloAnterior the montoCicloAnterior to set
	 */
	public void setMontoCicloAnterior(String montoCicloAnterior) {
		this.montoCicloAnterior = montoCicloAnterior;
	}

	/**
	 * @return the montoSolicitadoAproElec
	 */
	public String getMontoSolicitadoAproElec() {
		return montoSolicitadoAproElec;
	}

	/**
	 * @param montoSolicitadoAproElec the montoSolicitadoAproElec to set
	 */
	public void setMontoSolicitadoAproElec(String montoSolicitadoAproElec) {
		this.montoSolicitadoAproElec = montoSolicitadoAproElec;
	}

	/**
	 * @return the buroHistorico
	 */
	public String getBuroHistorico() {
		return buroHistorico;
	}

	/**
	 * @param buroHistorico the buroHistorico to set
	 */
	public void setBuroHistorico(String buroHistorico) {
		this.buroHistorico = buroHistorico;
	}

	/**
	 * @return the urlIconoPdf
	 */
	public String getUrlIconoPdf() {
		return urlIconoPdf;
	}

	/**
	 * @param urlIconoPdf the urlIconoPdf to set
	 */
	public void setUrlIconoPdf(String urlIconoPdf) {
		this.urlIconoPdf = urlIconoPdf;
	}

	/* (non-Javadoc)
	 * @see utilitario.mensajes.comun.ObjetoValor#toString()
	 */
	@Override
	public String toString() {
		return "indice:" + indice + "\tnumeroPersona:" + numeroPersona + "\tnombreCompleto:" + nombreCompleto
			 + "\tmops:" + mops + "\thistoricoFinsol:" + historicoFinsol + "\tindex:" + index + "\tmop:" + mop
			 + "\tcuentasAbiertas:" + cuentasAbiertas + "\tsaldoActualAbiertas:" + saldoActualAbiertas
			 + "\tsaldoVencidoAbiertas:" + saldoVencidoAbiertas + "\tcuentasCerradas:" + cuentasCerradas
			 + "\tsaldoActualCerradas:" + saldoActualCerradas + "\tmontoCerradas:" + montoCerradas
			 + "\tclaveObservacion:" + claveObservacion + "\thipotecario:" + hipotecario + "\tautomotriz:"
			 + automotriz + "\tsizeMops:" + sizeMops + "\tstyleBackground:" + styleBackground + "\tbackgroundFila:"
			 + backgroundFila;
	}

}
