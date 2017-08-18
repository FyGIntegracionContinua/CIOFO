package utilitario.mensajes.buro;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class BuroInternoOV.
 *
 * @author rguadarramac
 */
public class BuroInternoOV extends ObjetoValor {

	/**
	 * Instancia una nueva buro interno ov.
	 */
	public BuroInternoOV() {
	}
	/** Se genero un id unico. */
	private static final long serialVersionUID = -3746267642355281420L;

	/** The contrato. */
	private String contrato;

	/** The numero contrato ld. */
	private String numeroContratoLD;

	/** The ciclo cliente. */
	private String cicloCliente;				//at_cycle_customer

	/** The monto total. */
	private String montoTotal;

	/** The monto aprovado. */
	private String montoAprovado;

	/** The porcentaje participacion. */
	private String porcentajeParticipacion;		//at_pct_in_participation

	/** The fecha inicio. */
	private String fechaInicio;

	/** The fecha fin. */
	private String fechaFin;

	/** The interes total. */
	private String interesTotal;   				//me_total_interest

	/** The totala pagar. */
	private String totalaPagar;   				//me_total_to_pay

	/** The liquidation. */
	private String liquidation;

	/** The status. */
	private String status;     					//bd_status

	/** The dias atraso. */
	private String diasAtraso;

	/** The numero retrasos. */
	private String numeroRetrasos;

	/** The maximo retraso. */
	private String maximoRetraso;

	/** The recuperacion status. */
	private String recuperacionStatus;			//bk_status_recovery

	/** The balance principal. */
	private String balancePrincipal;

	/** The balance interes. */
	private String balanceInteres;

	/** The balance penalizacion. */
	private String balancePenalizacion;

	/** The balance total. */
	private String balanceTotal;

	/** The interes mora. */
	private String interesMora;					//me_interest_past_due

	/** The principal vencido. */
	private String principalVencido;   			//me_principal_past_due

	/** The penalizacion. */
	private String penalizacion;

	/** The total vencido. */
	private String totalVencido;     			//me_total_past_due

	/** The dias vencidos morosos. */
	private String diasVencidosMorosos;   		//me_days_loan_past_due

	/** The dias verdaderos mora. */
	private String diasVerdaderosMora;   		//me_days_past_due_real

	/** The entrega. */
	private String entrega;     				//at_installment

	/** The bk status. */
	private String bkStatus;     				//bk_status

	/** The regularidad. */
	private String regularidad;

	/** The calf. */
	private String calf;

	/**
	 * Establece contrato.
	 *
	 * @param contrato a contrato
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * Obtiene contrato.
	 *
	 * @return contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * Obtiene numero contrato ld.
	 *
	 * @return numero contrato ld
	 */
	public String getNumeroContratoLD() {
		return numeroContratoLD;
	}

	/**
	 * Establece numero contrato ld.
	 *
	 * @param numeroContratoLD a numero contrato ld
	 */
	public void setNumeroContratoLD(String numeroContratoLD) {
		this.numeroContratoLD = numeroContratoLD;
	}

	/**
	 * Obtiene ciclo cliente.
	 *
	 * @return ciclo cliente
	 */
	public String getCicloCliente() {
		return cicloCliente;
	}

	/**
	 * Establece ciclo cliente.
	 *
	 * @param cicloCliente a ciclo cliente
	 */
	public void setCicloCliente(String cicloCliente) {
		this.cicloCliente = cicloCliente;
	}

	/**
	 * Obtiene monto total.
	 *
	 * @return monto total
	 */
	public String getMontoTotal() {
		return montoTotal;
	}

	/**
	 * Establece monto total.
	 *
	 * @param montoTotal a monto total
	 */
	public void setMontoTotal(String montoTotal) {
		this.montoTotal = montoTotal;
	}

	/**
	 * Obtiene monto aprovado.
	 *
	 * @return monto aprovado
	 */
	public String getMontoAprovado() {
		return montoAprovado;
	}

	/**
	 * Establece monto aprovado.
	 *
	 * @param montoAprovado a monto aprovado
	 */
	public void setMontoAprovado(String montoAprovado) {
		this.montoAprovado = montoAprovado;
	}

	/**
	 * Obtiene porcentaje participacion.
	 *
	 * @return porcentaje participacion
	 */
	public String getPorcentajeParticipacion() {
		return porcentajeParticipacion;
	}

	/**
	 * Establece porcentaje participacion.
	 *
	 * @param porcentajeParticipacion a porcentaje participacion
	 */
	public void setPorcentajeParticipacion(String porcentajeParticipacion) {
		this.porcentajeParticipacion = porcentajeParticipacion;
	}

	/**
	 * Obtiene fecha inicio.
	 *
	 * @return fecha inicio
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Establece fecha inicio.
	 *
	 * @param fechaInicio a fecha inicio
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Obtiene fecha fin.
	 *
	 * @return fecha fin
	 */
	public String getFechaFin() {
		return fechaFin;
	}

	/**
	 * Establece fecha fin.
	 *
	 * @param fechaFin a fecha fin
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Obtiene interes total.
	 *
	 * @return interes total
	 */
	public String getInteresTotal() {
		return interesTotal;
	}

	/**
	 * Establece interes total.
	 *
	 * @param interesTotal a interes total
	 */
	public void setInteresTotal(String interesTotal) {
		this.interesTotal = interesTotal;
	}

	/**
	 * Obtiene totala pagar.
	 *
	 * @return totala pagar
	 */
	public String getTotalaPagar() {
		return totalaPagar;
	}

	/**
	 * Establece totala pagar.
	 *
	 * @param totalaPagar a totala pagar
	 */
	public void setTotalaPagar(String totalaPagar) {
		this.totalaPagar = totalaPagar;
	}

	/**
	 * Obtiene liquidation.
	 *
	 * @return liquidation
	 */
	public String getLiquidation() {
		return liquidation;
	}

	/**
	 * Establece liquidation.
	 *
	 * @param liquidation a liquidation
	 */
	public void setLiquidation(String liquidation) {
		this.liquidation = liquidation;
	}

	/**
	 * Obtiene status.
	 *
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Establece status.
	 *
	 * @param status a status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Obtiene dias atraso.
	 *
	 * @return dias atraso
	 */
	public String getDiasAtraso() {
		return diasAtraso;
	}

	/**
	 * Establece dias atraso.
	 *
	 * @param diasAtraso a dias atraso
	 */
	public void setDiasAtraso(String diasAtraso) {
		this.diasAtraso = diasAtraso;
	}

	/**
	 * Obtiene numero retrasos.
	 *
	 * @return numero retrasos
	 */
	public String getNumeroRetrasos() {
		return numeroRetrasos;
	}

	/**
	 * Establece numero retrasos.
	 *
	 * @param numeroRetrasos a numero retrasos
	 */
	public void setNumeroRetrasos(String numeroRetrasos) {
		this.numeroRetrasos = numeroRetrasos;
	}

	/**
	 * Obtiene maximo retraso.
	 *
	 * @return maximo retraso
	 */
	public String getMaximoRetraso() {
		return maximoRetraso;
	}

	/**
	 * Establece maximo retraso.
	 *
	 * @param maximoRetraso a maximo retraso
	 */
	public void setMaximoRetraso(String maximoRetraso) {
		this.maximoRetraso = maximoRetraso;
	}

	/**
	 * Obtiene recuperacion status.
	 *
	 * @return recuperacion status
	 */
	public String getRecuperacionStatus() {
		return recuperacionStatus;
	}

	/**
	 * Establece recuperacion status.
	 *
	 * @param recuperacionStatus a recuperacion status
	 */
	public void setRecuperacionStatus(String recuperacionStatus) {
		this.recuperacionStatus = recuperacionStatus;
	}

	/**
	 * Obtiene balance principal.
	 *
	 * @return balance principal
	 */
	public String getBalancePrincipal() {
		return balancePrincipal;
	}

	/**
	 * Establece balance principal.
	 *
	 * @param balancePrincipal a balance principal
	 */
	public void setBalancePrincipal(String balancePrincipal) {
		this.balancePrincipal = balancePrincipal;
	}

	/**
	 * Obtiene balance interes.
	 *
	 * @return balance interes
	 */
	public String getBalanceInteres() {
		return balanceInteres;
	}

	/**
	 * Establece balance interes.
	 *
	 * @param balanceInteres a balance interes
	 */
	public void setBalanceInteres(String balanceInteres) {
		this.balanceInteres = balanceInteres;
	}

	/**
	 * Obtiene balance penalizacion.
	 *
	 * @return balance penalizacion
	 */
	public String getBalancePenalizacion() {
		return balancePenalizacion;
	}

	/**
	 * Establece balance penalizacion.
	 *
	 * @param balancePenalizacion a balance penalizacion
	 */
	public void setBalancePenalizacion(String balancePenalizacion) {
		this.balancePenalizacion = balancePenalizacion;
	}

	/**
	 * Obtiene balance total.
	 *
	 * @return balance total
	 */
	public String getBalanceTotal() {
		return balanceTotal;
	}

	/**
	 * Establece balance total.
	 *
	 * @param balanceTotal a balance total
	 */
	public void setBalanceTotal(String balanceTotal) {
		this.balanceTotal = balanceTotal;
	}

	/**
	 * Obtiene interes mora.
	 *
	 * @return interes mora
	 */
	public String getInteresMora() {
		return interesMora;
	}

	/**
	 * Establece interes mora.
	 *
	 * @param interesMora a interes mora
	 */
	public void setInteresMora(String interesMora) {
		this.interesMora = interesMora;
	}

	/**
	 * Obtiene principal vencido.
	 *
	 * @return principal vencido
	 */
	public String getPrincipalVencido() {
		return principalVencido;
	}

	/**
	 * Establece principal vencido.
	 *
	 * @param principalVencido a principal vencido
	 */
	public void setPrincipalVencido(String principalVencido) {
		this.principalVencido = principalVencido;
	}

	/**
	 * Obtiene penalizacion.
	 *
	 * @return penalizacion
	 */
	public String getPenalizacion() {
		return penalizacion;
	}

	/**
	 * Establece penalizacion.
	 *
	 * @param penalizacion a penalizacion
	 */
	public void setPenalizacion(String penalizacion) {
		this.penalizacion = penalizacion;
	}

	/**
	 * Obtiene total vencido.
	 *
	 * @return total vencido
	 */
	public String getTotalVencido() {
		return totalVencido;
	}

	/**
	 * Establece total vencido.
	 *
	 * @param totalVencido a total vencido
	 */
	public void setTotalVencido(String totalVencido) {
		this.totalVencido = totalVencido;
	}

	/**
	 * Obtiene dias vencidos morosos.
	 *
	 * @return dias vencidos morosos
	 */
	public String getDiasVencidosMorosos() {
		return diasVencidosMorosos;
	}

	/**
	 * Establece dias vencidos morosos.
	 *
	 * @param diasVencidosMorosos a dias vencidos morosos
	 */
	public void setDiasVencidosMorosos(String diasVencidosMorosos) {
		this.diasVencidosMorosos = diasVencidosMorosos;
	}

	/**
	 * Obtiene dias verdaderos mora.
	 *
	 * @return dias verdaderos mora
	 */
	public String getDiasVerdaderosMora() {
		return diasVerdaderosMora;
	}

	/**
	 * Establece dias verdaderos mora.
	 *
	 * @param diasVerdaderosMora a dias verdaderos mora
	 */
	public void setDiasVerdaderosMora(String diasVerdaderosMora) {
		this.diasVerdaderosMora = diasVerdaderosMora;
	}

	/**
	 * Obtiene entrega.
	 *
	 * @return entrega
	 */
	public String getEntrega() {
		return entrega;
	}

	/**
	 * Establece entrega.
	 *
	 * @param entrega a entrega
	 */
	public void setEntrega(String entrega) {
		this.entrega = entrega;
	}

	/**
	 * Obtiene bk status.
	 *
	 * @return bk status
	 */
	public String getBkStatus() {
		return bkStatus;
	}

	/**
	 * Establece bk status.
	 *
	 * @param bkStatus a bk status
	 */
	public void setBkStatus(String bkStatus) {
		this.bkStatus = bkStatus;
	}

	/**
	 * Obtiene regularidad.
	 *
	 * @return regularidad
	 */
	public String getRegularidad() {
		return regularidad;
	}

	/**
	 * Establece regularidad.
	 *
	 * @param regularidad a regularidad
	 */
	public void setRegularidad(String regularidad) {
		this.regularidad = regularidad;
	}

	/**
	 * Obtiene calf.
	 *
	 * @return calf
	 */
	public String getCalf() {
		return calf;
	}

	/**
	 * Establece calf.
	 *
	 * @param calf a calf
	 */
	public void setCalf(String calf) {
		this.calf = calf;
	}


}
