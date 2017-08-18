package utilitario.mensajes.burocredito;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class BuroCreditoClienteGrupo.
 *
 * @author out_ltorres
 * @version 1.0
 */
public class BuroCreditoClienteGrupo extends ObjetoValor {

	/**
	 * Instancia una nueva buro credito cliente grupo.
	 */
	public BuroCreditoClienteGrupo() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 259515190219098758L;

	/** The contrato. */
	private String contrato;

	/** The bk contract. */
	private String bkContract;

	/** The bk group. */
	private Integer bkGroup;

	/** The bc group. */
	private String bcGroup;

	/** The bc branch. */
	private String bcBranch;

	/** The bc product type. */
	private String bcProductType;

	/** The bc account officer. */
	private String bcAccountOfficer;

	/** The at cycle. */
	private Integer atCycle;

	/** The at term. */
	private Integer atTerm;

	/** The at int rate. */
	private Double atIntRate;

	/** The at installment. */
	private Double atInstallment;

	/** The me amount aproved. */
	private Double meAmountAproved;

	/** The dt value. */
	private Date dtValue;

	/** The bc emp. */
	private String bcEmp;

	/** The bc system. */
	private String bcSystem;

	//out_jcubias
	/** The at cycle customer. */
	private Integer atCycleCustomer;

	/** The m t. */
	private Double mT;

	/** The me aproved. */
	private Double meAproved;

	/** The at pct in participation. */
	private Double atPctInParticipation;

	/** The inicio. */
	private String fInicio;

	/** The fin. */
	private String fFin;

	/** The t i. */
	private Double tI;

	/** The t a. */
	private Double tA;

	/** The liquidation. */
	private String liquidation;

	/** The bs status. */
	private String bsStatus;

	/** The dias atra. */
	private Integer diasAtra;

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

	/** The bk status. */
	private Integer bkStatus;

	/** The dias mora acumulados. */
	private Integer diasMoraAcumulados;

	/** The at regularity. */
	private String atRegularity;

	/** The maxdm. */
	private Integer maxdm;

	/** The calf. */
	private Integer calf;

	/** The no retraso. */
	private Integer noRetraso;

	/** The numero grupo. */
	private String numeroGrupo;

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
	 * Obtiene bk group.
	 *
	 * @return bk group
	 */
	public Integer getBkGroup() {
		return bkGroup;
	}

	/**
	 * Establece bk group.
	 *
	 * @param bkGroup a bk group
	 */
	public void setBkGroup(Integer bkGroup) {
		this.bkGroup = bkGroup;
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
		this.bcProductType = bcProductType.trim();
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
	 * Obtiene at installment.
	 *
	 * @return at installment
	 */
	public Double getAtInstallment() {
		return atInstallment;
	}

	/**
	 * Establece at installment.
	 *
	 * @param atInstallment a at installment
	 */
	public void setAtInstallment(Double atInstallment) {
		this.atInstallment = atInstallment;
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
	 * Obtiene dt value.
	 *
	 * @return dt value
	 */
	public Date getDtValue() {
		return dtValue;
	}

	/**
	 * Establece dt value.
	 *
	 * @param dtValue a dt value
	 */
	public void setDtValue(Date dtValue) {
		this.dtValue = dtValue;
	}

	/**
	 * Obtiene bc emp.
	 *
	 * @return bc emp
	 */
	public String getBcEmp() {
		return bcEmp;
	}

	/**
	 * Establece bc emp.
	 *
	 * @param bcEmp a bc emp
	 */
	public void setBcEmp(String bcEmp) {
		this.bcEmp = bcEmp;
	}

	/**
	 * Obtiene bc system.
	 *
	 * @return bc system
	 */
	public String getBcSystem() {
		return bcSystem;
	}

	/**
	 * Establece bc system.
	 *
	 * @param bcSystem a bc system
	 */
	public void setBcSystem(String bcSystem) {
		this.bcSystem = bcSystem;
	}

	/**
	 * Obtiene at cycle customer.
	 *
	 * @return at cycle customer
	 */
	public Integer getAtCycleCustomer() {
		return atCycleCustomer;
	}

	/**
	 * Establece at cycle customer.
	 *
	 * @param atCycleCustomer a at cycle customer
	 */
	public void setAtCycleCustomer(Integer atCycleCustomer) {
		this.atCycleCustomer = atCycleCustomer;
	}

	/**
	 * Obtiene m t.
	 *
	 * @return m t
	 */
	public Double getmT() {
		return mT;
	}

	/**
	 * Establece m t.
	 *
	 * @param mT a m t
	 */
	public void setmT(Double mT) {
		this.mT = mT;
	}

	/**
	 * Obtiene me aproved.
	 *
	 * @return me aproved
	 */
	public Double getMeAproved() {
		return meAproved;
	}

	/**
	 * Establece me aproved.
	 *
	 * @param meAproved a me aproved
	 */
	public void setMeAproved(Double meAproved) {
		this.meAproved = meAproved;
	}

	/**
	 * Obtiene at pct in participation.
	 *
	 * @return at pct in participation
	 */
	public Double getAtPctInParticipation() {
		return atPctInParticipation;
	}

	/**
	 * Establece at pct in participation.
	 *
	 * @param atPctInParticipation a at pct in participation
	 */
	public void setAtPctInParticipation(Double atPctInParticipation) {
		this.atPctInParticipation = atPctInParticipation;
	}

	/**
	 * Obtiene f inicio.
	 *
	 * @return f inicio
	 */
	public String getfInicio() {
		return fInicio;
	}

	/**
	 * Establece f inicio.
	 *
	 * @param fInicio a f inicio
	 */
	public void setfInicio(String fInicio) {
		this.fInicio = fInicio;
	}

	/**
	 * Obtiene f fin.
	 *
	 * @return f fin
	 */
	public String getfFin() {
		return fFin;
	}

	/**
	 * Establece f fin.
	 *
	 * @param fFin a f fin
	 */
	public void setfFin(String fFin) {
		this.fFin = fFin;
	}

	/**
	 * Obtiene t i.
	 *
	 * @return t i
	 */
	public Double gettI() {
		return tI;
	}

	/**
	 * Establece t i.
	 *
	 * @param tI a t i
	 */
	public void settI(Double tI) {
		this.tI = tI;
	}

	/**
	 * Obtiene t a.
	 *
	 * @return t a
	 */
	public Double gettA() {
		return tA;
	}

	/**
	 * Establece t a.
	 *
	 * @param tA a t a
	 */
	public void settA(Double tA) {
		this.tA = tA;
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
	 * Obtiene bs status.
	 *
	 * @return bs status
	 */
	public String getBsStatus() {
		return bsStatus;
	}

	/**
	 * Establece bs status.
	 *
	 * @param bsStatus a bs status
	 */
	public void setBsStatus(String bsStatus) {
		this.bsStatus = bsStatus;
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
	 * Obtiene bk status.
	 *
	 * @return bk status
	 */
	public Integer getBkStatus() {
		return bkStatus;
	}

	/**
	 * Establece bk status.
	 *
	 * @param bkStatus a bk status
	 */
	public void setBkStatus(Integer bkStatus) {
		this.bkStatus = bkStatus;
	}

	/**
	 * Obtiene dias mora acumulados.
	 *
	 * @return dias mora acumulados
	 */
	public Integer getDiasMoraAcumulados() {
		return diasMoraAcumulados;
	}

	/**
	 * Establece dias mora acumulados.
	 *
	 * @param diasMoraAcumulados a dias mora acumulados
	 */
	public void setDiasMoraAcumulados(Integer diasMoraAcumulados) {
		this.diasMoraAcumulados = diasMoraAcumulados;
	}

	/**
	 * Obtiene at regularity.
	 *
	 * @return at regularity
	 */
	public String getAtRegularity() {
		return atRegularity;
	}

	/**
	 * Establece at regularity.
	 *
	 * @param atRegularity a at regularity
	 */
	public void setAtRegularity(String atRegularity) {
		this.atRegularity = atRegularity;
	}

	/**
	 * Obtiene maxdm.
	 *
	 * @return maxdm
	 */
	public Integer getMaxdm() {
		return maxdm;
	}

	/**
	 * Establece maxdm.
	 *
	 * @param maxdm a maxdm
	 */
	public void setMaxdm(Integer maxdm) {
		this.maxdm = maxdm;
	}

	/**
	 * Obtiene calf.
	 *
	 * @return calf
	 */
	public Integer getCalf() {
		return calf;
	}

	/**
	 * Establece calf.
	 *
	 * @param calf a calf
	 */
	public void setCalf(Integer calf) {
		this.calf = calf;
	}

	/**
	 * Obtiene no retraso.
	 *
	 * @return no retraso
	 */
	public Integer getNoRetraso() {
		return noRetraso;
	}

	/**
	 * Establece no retraso.
	 *
	 * @param noRetraso a no retraso
	 */
	public void setNoRetraso(Integer noRetraso) {
		this.noRetraso = noRetraso;
	}

	/**
	 * Obtiene numero grupo.
	 *
	 * @return the numeroGrupo
	 */
	public String getNumeroGrupo() {
		return numeroGrupo;
	}

	/**
	 * Establece numero grupo.
	 *
	 * @param numeroGrupo the numeroGrupo to set
	 */
	public void setNumeroGrupo(String numeroGrupo) {
		this.numeroGrupo = numeroGrupo;
	}



}


