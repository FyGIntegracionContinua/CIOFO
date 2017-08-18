package utilitario.mensajes.burocredito;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class BuroCreditoClienteDetalleGrupo.
 *
 * @author out_ltorres
 * @version 1.0
 */
public class BuroCreditoClienteDetalleGrupo extends ObjetoValor {

	/**
	 * Instancia una nueva buro credito cliente detalle grupo.
	 */
	public BuroCreditoClienteDetalleGrupo() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6110581413617653600L;

	/** The contrato. */
	private String contrato;

	/** The status. */
	private String status;

	/** The bk contract. */
	private String bkContract;

	/** The bc group. */
	private String bcGroup;

	/** The bc branch. */
	private String bcBranch;

	/** The bc product type. */
	private String bcProductType;

	/** The bc account officer. */
	private String bcAccountOfficer;

	/** The dt value. */
	private String dtValue;

	/** The dt matuarity. */
	private String dtMatuarity;

	/** The at term. */
	private Integer atTerm;

	/** The at cycle. */
	private Integer atCycle;

	/** The at int rate. */
	private Double atIntRate;

	/** The me amount aproved. */
	private Double meAmountAproved;

	/** The me total interest. */
	private Double meTotalInterest;

	/** The me total to pay. */
	private Double meTotalToPay;

	/** The dt liquidation. */
	private Date dtLiquidation;

	/** The bk status recovery. */
	private Integer bkStatusRecovery;

	/** The me principal balance. */
	private Double mePrincipalBalance;

	/** The me interest balance. */
	private Double meInterestBalance;

	/** The me penalty balance. */
	private Double mePenaltyBalance;

	/** The me total balance. */
	private Double meTotalBalance;

	/** The me principal past due. */
	private Double mePrincipalPastDue;

	/** The me interest past due. */
	private Double meInterestPastDue;

	/** The me penalty. */
	private Double mePenalty;

	/** The me total past due. */
	private Double meTotalPastDue;

	/** The me days loan past due. */
	private Integer meDaysLoanPastDue;

	/** The me days past due real. */
	private Integer meDaysPastDueReal;

	/** The bc status. */
	private String bcStatus;

	/** The dias atra. */
	private Integer diasAtra;

	/**
	 * Obtiene contrato.
	 *
	 * @return contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * Establece contrato.
	 *
	 * @param contrato a contrato
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
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
	 * Obtiene bk contract.
	 *
	 * @return bk contract
	 */
	public String getBkContract() {
		return bkContract;
	}

	/**
	 * Establece bk contract.
	 *
	 * @param bkContract a bk contract
	 */
	public void setBkContract(String bkContract) {
		this.bkContract = bkContract.trim();
	}

	/**
	 * Obtiene bc group.
	 *
	 * @return bc group
	 */
	public String getBcGroup() {
		return bcGroup;
	}

	/**
	 * Establece bc group.
	 *
	 * @param bcGroup a bc group
	 */
	public void setBcGroup(String bcGroup) {
		this.bcGroup = bcGroup;
	}

	/**
	 * Obtiene bc branch.
	 *
	 * @return bc branch
	 */
	public String getBcBranch() {
		return bcBranch;
	}

	/**
	 * Establece bc branch.
	 *
	 * @param bcBranch a bc branch
	 */
	public void setBcBranch(String bcBranch) {
		this.bcBranch = bcBranch.trim();
	}

	/**
	 * Obtiene bc product type.
	 *
	 * @return bc product type
	 */
	public String getBcProductType() {
		return bcProductType;
	}

	/**
	 * Establece bc product type.
	 *
	 * @param bcProductType a bc product type
	 */
	public void setBcProductType(String bcProductType) {
		this.bcProductType = bcProductType;
	}

	/**
	 * Obtiene bc account officer.
	 *
	 * @return bc account officer
	 */
	public String getBcAccountOfficer() {
		return bcAccountOfficer;
	}

	/**
	 * Establece bc account officer.
	 *
	 * @param bcAccountOfficer a bc account officer
	 */
	public void setBcAccountOfficer(String bcAccountOfficer) {
		this.bcAccountOfficer = bcAccountOfficer;
	}

	/**
	 * Obtiene dt value.
	 *
	 * @return dt value
	 */
	public String getDtValue() {
		return dtValue;
	}

	/**
	 * Establece dt value.
	 *
	 * @param dtValue a dt value
	 */
	public void setDtValue(String dtValue) {
		this.dtValue = dtValue;
	}

	/**
	 * Obtiene dt matuarity.
	 *
	 * @return dt matuarity
	 */
	public String getDtMatuarity() {
		return dtMatuarity;
	}

	/**
	 * Establece dt matuarity.
	 *
	 * @param dtMatuarity a dt matuarity
	 */
	public void setDtMatuarity(String dtMatuarity) {
		this.dtMatuarity = dtMatuarity;
	}

	/**
	 * Obtiene at term.
	 *
	 * @return at term
	 */
	public Integer getAtTerm() {
		return atTerm;
	}

	/**
	 * Establece at term.
	 *
	 * @param atTerm a at term
	 */
	public void setAtTerm(Integer atTerm) {
		this.atTerm = atTerm;
	}

	/**
	 * Obtiene at cycle.
	 *
	 * @return at cycle
	 */
	public Integer getAtCycle() {
		return atCycle;
	}

	/**
	 * Establece at cycle.
	 *
	 * @param atCycle a at cycle
	 */
	public void setAtCycle(Integer atCycle) {
		this.atCycle = atCycle;
	}

	/**
	 * Obtiene at int rate.
	 *
	 * @return at int rate
	 */
	public Double getAtIntRate() {
		return atIntRate;
	}

	/**
	 * Establece at int rate.
	 *
	 * @param atIntRate a at int rate
	 */
	public void setAtIntRate(Double atIntRate) {
		this.atIntRate = atIntRate;
	}

	/**
	 * Obtiene me amount aproved.
	 *
	 * @return me amount aproved
	 */
	public Double getMeAmountAproved() {
		return meAmountAproved;
	}

	/**
	 * Establece me amount aproved.
	 *
	 * @param meAmountAproved a me amount aproved
	 */
	public void setMeAmountAproved(Double meAmountAproved) {
		this.meAmountAproved = meAmountAproved;
	}


	/**
	 * Obtiene me total interest.
	 *
	 * @return me total interest
	 */
	public Double getMeTotalInterest() {
		return meTotalInterest;
	}

	/**
	 * Establece me total interest.
	 *
	 * @param meTotalInterest a me total interest
	 */
	public void setMeTotalInterest(Double meTotalInterest) {
		this.meTotalInterest = meTotalInterest;
	}

	/**
	 * Obtiene me total to pay.
	 *
	 * @return me total to pay
	 */
	public Double getMeTotalToPay() {
		return meTotalToPay;
	}

	/**
	 * Establece me total to pay.
	 *
	 * @param meTotalToPay a me total to pay
	 */
	public void setMeTotalToPay(Double meTotalToPay) {
		this.meTotalToPay = meTotalToPay;
	}

	/**
	 * Obtiene dt liquidation.
	 *
	 * @return dt liquidation
	 */
	public Date getDtLiquidation() {
		return dtLiquidation;
	}

	/**
	 * Establece dt liquidation.
	 *
	 * @param dtLiquidation a dt liquidation
	 */
	public void setDtLiquidation(Date dtLiquidation) {
		this.dtLiquidation = dtLiquidation;
	}

	/**
	 * Obtiene bk status recovery.
	 *
	 * @return bk status recovery
	 */
	public Integer getBkStatusRecovery() {
		return bkStatusRecovery;
	}

	/**
	 * Establece bk status recovery.
	 *
	 * @param bkStatusRecovery a bk status recovery
	 */
	public void setBkStatusRecovery(Integer bkStatusRecovery) {
		this.bkStatusRecovery = bkStatusRecovery;
	}

	/**
	 * Obtiene me principal balance.
	 *
	 * @return me principal balance
	 */
	public Double getMePrincipalBalance() {
		return mePrincipalBalance;
	}

	/**
	 * Establece me principal balance.
	 *
	 * @param mePrincipalBalance a me principal balance
	 */
	public void setMePrincipalBalance(Double mePrincipalBalance) {
		this.mePrincipalBalance = mePrincipalBalance;
	}

	/**
	 * Obtiene me interest balance.
	 *
	 * @return me interest balance
	 */
	public Double getMeInterestBalance() {
		return meInterestBalance;
	}

	/**
	 * Establece me interest balance.
	 *
	 * @param meInterestBalance a me interest balance
	 */
	public void setMeInterestBalance(Double meInterestBalance) {
		this.meInterestBalance = meInterestBalance;
	}

	/**
	 * Obtiene me penalty balance.
	 *
	 * @return me penalty balance
	 */
	public Double getMePenaltyBalance() {
		return mePenaltyBalance;
	}

	/**
	 * Establece me penalty balance.
	 *
	 * @param mePenaltyBalance a me penalty balance
	 */
	public void setMePenaltyBalance(Double mePenaltyBalance) {
		this.mePenaltyBalance = mePenaltyBalance;
	}

	/**
	 * Obtiene me total balance.
	 *
	 * @return me total balance
	 */
	public Double getMeTotalBalance() {
		return meTotalBalance;
	}

	/**
	 * Establece me total balance.
	 *
	 * @param meTotalBalance a me total balance
	 */
	public void setMeTotalBalance(Double meTotalBalance) {
		this.meTotalBalance = meTotalBalance;
	}

	/**
	 * Obtiene me principal past due.
	 *
	 * @return me principal past due
	 */
	public Double getMePrincipalPastDue() {
		return mePrincipalPastDue;
	}

	/**
	 * Establece me principal past due.
	 *
	 * @param mePrincipalPastDue a me principal past due
	 */
	public void setMePrincipalPastDue(Double mePrincipalPastDue) {
		this.mePrincipalPastDue = mePrincipalPastDue;
	}

	/**
	 * Obtiene me interest past due.
	 *
	 * @return me interest past due
	 */
	public Double getMeInterestPastDue() {
		return meInterestPastDue;
	}

	/**
	 * Establece me interest past due.
	 *
	 * @param meInterestPastDue a me interest past due
	 */
	public void setMeInterestPastDue(Double meInterestPastDue) {
		this.meInterestPastDue = meInterestPastDue;
	}

	/**
	 * Obtiene me penalty.
	 *
	 * @return me penalty
	 */
	public Double getMePenalty() {
		return mePenalty;
	}

	/**
	 * Establece me penalty.
	 *
	 * @param mePenalty a me penalty
	 */
	public void setMePenalty(Double mePenalty) {
		this.mePenalty = mePenalty;
	}

	/**
	 * Obtiene me total past due.
	 *
	 * @return me total past due
	 */
	public Double getMeTotalPastDue() {
		return meTotalPastDue;
	}

	/**
	 * Establece me total past due.
	 *
	 * @param meTotalPastDue a me total past due
	 */
	public void setMeTotalPastDue(Double meTotalPastDue) {
		this.meTotalPastDue = meTotalPastDue;
	}

	/**
	 * Obtiene me days loan past due.
	 *
	 * @return me days loan past due
	 */
	public Integer getMeDaysLoanPastDue() {
		return meDaysLoanPastDue;
	}

	/**
	 * Establece me days loan past due.
	 *
	 * @param meDaysLoanPastDue a me days loan past due
	 */
	public void setMeDaysLoanPastDue(Integer meDaysLoanPastDue) {
		this.meDaysLoanPastDue = meDaysLoanPastDue;
	}

	/**
	 * Obtiene me days past due real.
	 *
	 * @return me days past due real
	 */
	public Integer getMeDaysPastDueReal() {
		return meDaysPastDueReal;
	}

	/**
	 * Establece me days past due real.
	 *
	 * @param meDaysPastDueReal a me days past due real
	 */
	public void setMeDaysPastDueReal(Integer meDaysPastDueReal) {
		this.meDaysPastDueReal = meDaysPastDueReal;
	}

	/**
	 * Obtiene dias atra.
	 *
	 * @return dias atra
	 */
	public Integer getDiasAtra() {
		return diasAtra;
	}

	/**
	 * Establece dias atra.
	 *
	 * @param diasAtra a dias atra
	 */
	public void setDiasAtra(Integer diasAtra) {
		this.diasAtra = diasAtra;
	}

	/**
	 * Obtiene bc status.
	 *
	 * @return bc status
	 */
	public String getBcStatus() {
		return bcStatus;
	}

	/**
	 * Establece bc status.
	 *
	 * @param bcStatus a bc status
	 */
	public void setBcStatus(String bcStatus) {
		this.bcStatus = bcStatus;
	}

}


