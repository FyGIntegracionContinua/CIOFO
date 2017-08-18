/**
 *
 */
package utilitario.mensajes.reportes.garantias;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author lsotos
 *
 */
public class ReporteSolicitudesGarantiaOV extends ObjetoValor {

	/**
	 *
	 */
	private static final long serialVersionUID = 2857727232902881876L;

	/**
	 * número de contrato
	 */
	private String contrato;

	/**
	 * número de grupo
	 */
	private String grupo;

	/**
	 * nombre del grupo
	 */
	private String nombreGrupo;

	/**
	 * clico del grupo
	 */
	private Integer ciclo;

	/**
	 * número de sucursal
	 */
	private Integer sucursal;

	/**
	 * nombre de sucursal
	 */
	private String nombreSucursal;

	/**
	 * número de región
	 */
	private Integer region;

	/**
	 * nombre de la región
	 */
	private String nombreRegion;

	/**
	 * número de división
	 */
	private Integer division;

	/**
	 * nombre de la división
	 */
	private String nombreDivision;

	/**
	 * % de garantía a depositar
	 */
	private String garantiaRequeridaPct;

	/**
	 * monto requerido de garantía
	 */
	private String garantiaRequeridaMonto;

	/**
	 * garantía depositada
	 */
	private String garantiaDeposito;

	/**
	 * garantía recibida de otro crédito
	 */
	private String garantiaTraspaso;

	/**
	 * (Garantía requerida - (Depósito de garantía +Traspaso de garantía)
	 */
	private String garantiaDiferencia;

	/**
	 * devoluciones de la garantía
	 */
	private String garantiaDevoluciones;

	/**
	 *  (Garantía requerida - (Depósito de garantía +Traspaso de garantía+Devoluciones)= Total de garantía)
	 */
	private String garantiaTotal;

	/**
	 * usuario que autorizó la excepción
	 */
	private String autorizacionExcepcion;

	/**
	 * fecha de desembolso
	 */
	private String fechaDesembolsoGarantia;

	/**
	 * última fecha en que se depósito una garantía
	 */
	private String fechaDeposito;

	/**
	 * última fecha en que se recibión un traspaso
	 */
	private String fechaTraspaso;

	/**
	 *
	 */
	private String banco;

	/**
	 * días transcurridos entre el desembolso y la fecha de depósito de la garantía
	 */
	private String diasPago;


	/**
	 * identificar los contratos LD que tengan alguno de los estatus:
	 * Cancelados, Dispuestos o Liquidados
	 */
	private String estatus;

	/**
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * @return the grupo
	 */
	public String getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	/**
	 * @return the nombreGrupo
	 */
	public String getNombreGrupo() {
		return nombreGrupo;
	}

	/**
	 * @param nombreGrupo the nombreGrupo to set
	 */
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	/**
	 * @return the ciclo
	 */
	public Integer getCiclo() {
		return ciclo;
	}

	/**
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * @return the sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * @return the nombreSucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}

	/**
	 * @param nombreSucursal the nombreSucursal to set
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	/**
	 * @return the region
	 */
	public Integer getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(Integer region) {
		this.region = region;
	}

	/**
	 * @return the nombreRegion
	 */
	public String getNombreRegion() {
		return nombreRegion;
	}

	/**
	 * @param nombreRegion the nombreRegion to set
	 */
	public void setNombreRegion(String nombreRegion) {
		this.nombreRegion = nombreRegion;
	}

	/**
	 * @return the division
	 */
	public Integer getDivision() {
		return division;
	}

	/**
	 * @param division the division to set
	 */
	public void setDivision(Integer division) {
		this.division = division;
	}

	/**
	 * @return the nombreDivision
	 */
	public String getNombreDivision() {
		return nombreDivision;
	}

	/**
	 * @param nombreDivision the nombreDivision to set
	 */
	public void setNombreDivision(String nombreDivision) {
		this.nombreDivision = nombreDivision;
	}

	/**
	 * @return the garantiaRequeridaPct
	 */
	public String getGarantiaRequeridaPct() {
		return garantiaRequeridaPct;
	}

	/**
	 * @param garantiaRequeridaPct the garantiaRequeridaPct to set
	 */
	public void setGarantiaRequeridaPct(String garantiaRequeridaPct) {
		this.garantiaRequeridaPct = garantiaRequeridaPct;
	}

	/**
	 * @return the garantiaRequeridaMonto
	 */
	public String getGarantiaRequeridaMonto() {
		return garantiaRequeridaMonto;
	}

	/**
	 * @param garantiaRequeridaMonto the garantiaRequeridaMonto to set
	 */
	public void setGarantiaRequeridaMonto(String garantiaRequeridaMonto) {
		this.garantiaRequeridaMonto = garantiaRequeridaMonto;
	}

	/**
	 * @return the garantiaDeposito
	 */
	public String getGarantiaDeposito() {
		return garantiaDeposito;
	}

	/**
	 * @param garantiaDeposito the garantiaDeposito to set
	 */
	public void setGarantiaDeposito(String garantiaDeposito) {
		this.garantiaDeposito = garantiaDeposito;
	}

	/**
	 * @return the garantiaTraspaso
	 */
	public String getGarantiaTraspaso() {
		return garantiaTraspaso;
	}

	/**
	 * @param garantiaTraspaso the garantiaTraspaso to set
	 */
	public void setGarantiaTraspaso(String garantiaTraspaso) {
		this.garantiaTraspaso = garantiaTraspaso;
	}

	/**
	 * @return the garantiaDiferencia
	 */
	public String getGarantiaDiferencia() {
		return garantiaDiferencia;
	}

	/**
	 * @param garantiaDiferencia the garantiaDiferencia to set
	 */
	public void setGarantiaDiferencia(String garantiaDiferencia) {
		this.garantiaDiferencia = garantiaDiferencia;
	}

	/**
	 * @return the garantiaDevoluciones
	 */
	public String getGarantiaDevoluciones() {
		return garantiaDevoluciones;
	}

	/**
	 * @param garantiaDevoluciones the garantiaDevoluciones to set
	 */
	public void setGarantiaDevoluciones(String garantiaDevoluciones) {
		this.garantiaDevoluciones = garantiaDevoluciones;
	}

	/**
	 * @return the garantiaTotal
	 */
	public String getGarantiaTotal() {
		return garantiaTotal;
	}

	/**
	 * @param garantiaTotal the garantiaTotal to set
	 */
	public void setGarantiaTotal(String garantiaTotal) {
		this.garantiaTotal = garantiaTotal;
	}

	/**
	 * @return the autorizacionExcepcion
	 */
	public String getAutorizacionExcepcion() {
		return autorizacionExcepcion;
	}

	/**
	 * @param autorizacionExcepcion the autorizacionExcepcion to set
	 */
	public void setAutorizacionExcepcion(String autorizacionExcepcion) {
		this.autorizacionExcepcion = autorizacionExcepcion;
	}

	/**
	 * @return the fechaDesembolsoGarantia
	 */
	public String getFechaDesembolsoGarantia() {
		return fechaDesembolsoGarantia;
	}

	/**
	 * @param fechaDesembolsoGarantia the fechaDesembolsoGarantia to set
	 */
	public void setFechaDesembolsoGarantia(String fechaDesembolsoGarantia) {
		this.fechaDesembolsoGarantia = fechaDesembolsoGarantia;
	}

	/**
	 * @return the fechaDeposito
	 */
	public String getFechaDeposito() {
		return fechaDeposito;
	}

	/**
	 * @param fechaDeposito the fechaDeposito to set
	 */
	public void setFechaDeposito(String fechaDeposito) {
		this.fechaDeposito = fechaDeposito;
	}

	/**
	 * @return the fechaTraspaso
	 */
	public String getFechaTraspaso() {
		return fechaTraspaso;
	}

	/**
	 * @param fechaTraspaso the fechaTraspaso to set
	 */
	public void setFechaTraspaso(String fechaTraspaso) {
		this.fechaTraspaso = fechaTraspaso;
	}

	/**
	 * @return the banco
	 */
	public String getBanco() {
		return banco;
	}

	/**
	 * @param banco the banco to set
	 */
	public void setBanco(String banco) {
		this.banco = banco;
	}

	/**
	 * @return the diasPago
	 */
	public String getDiasPago() {
		return diasPago;
	}

	/**
	 * @param diasPago the diasPago to set
	 */
	public void setDiasPago(String diasPago) {
		this.diasPago = diasPago;
	}

	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

}
