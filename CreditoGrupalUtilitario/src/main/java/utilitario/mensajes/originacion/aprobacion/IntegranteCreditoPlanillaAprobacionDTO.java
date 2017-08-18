package utilitario.mensajes.originacion.aprobacion;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;

public class IntegranteCreditoPlanillaAprobacionDTO extends ObjetoValor {

	/**
	 * LONG
	 */
	private static final long serialVersionUID = -4364615300765005056L;
	/**
	 * contratoLD
	 */
	private String contratoLD;
	/**
	 * contrato
	 */
	private String contrato;
	/**
	 * producto
	 */
	private String producto;
	/**
	 * diasMora
	 */
	private int diasMora;
	/**
	 * estatusCredito
	 */
	private String estatusCredito;
	/**
	 * montoOtorgado
	 */
	private double montoOtorgado;
	/**
	 * maximoRetraso
	 */
	private Integer maximoRetraso;
	/**
	 * fechaEsperadaLiquidacion
	 */
	private Date fechaEsperadaLiquidacion;
	/**
	 * fechaLiquidacion
	 */
	private Date fechaLiquidacion;
	/**
	 * diasFechaFin
	 */
	private Integer diasFechaFin;
	/**
	 * montoFinanciado
	 */
	private double montoFinanciado;

	/**
	 * @return the contratoLD
	 */
	public String getContratoLD() {
		return contratoLD;
	}
	/**
	 * @param contratoLD the contratoLD to set
	 */
	public void setContratoLD(String contratoLD) {
		this.contratoLD = contratoLD;
	}
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
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}
	/**
	 * @return the diasMora
	 */
	public int getDiasMora() {
		return diasMora;
	}
	/**
	 * @param diasMora the diasMora to set
	 */
	public void setDiasMora(int diasMora) {
		this.diasMora = diasMora;
	}
	/**
	 * @return the estatusCredito
	 */
	public String getEstatusCredito() {
		return estatusCredito;
	}
	/**
	 * @param estatusCredito the estatusCredito to set
	 */
	public void setEstatusCredito(String estatusCredito) {
		this.estatusCredito = estatusCredito;
	}
	/**
	 * @return the montoOtorgado
	 */
	public double getMontoOtorgado() {
		return montoOtorgado;
	}
	/**
	 * @param montoOtorgado the montoOtorgado to set
	 */
	public void setMontoOtorgado(double montoOtorgado) {
		this.montoOtorgado = montoOtorgado;
	}
	/**
	 * @return the maximoRetraso
	 */
	public Integer getMaximoRetraso() {
		return maximoRetraso;
	}
	/**
	 * @param maximoRetraso the maximoRetraso to set
	 */
	public void setMaximoRetraso(Integer maximoRetraso) {
		this.maximoRetraso = maximoRetraso;
	}
	/**
	 * @return the fechaEsperadaLiquidacion
	 */
	public Date getFechaEsperadaLiquidacion() {
		return fechaEsperadaLiquidacion;
	}
	/**
	 * @param fechaEsperadaLiquidacion the fechaEsperadaLiquidacion to set
	 */
	public void setFechaEsperadaLiquidacion(Date fechaEsperadaLiquidacion) {
		this.fechaEsperadaLiquidacion = fechaEsperadaLiquidacion;
	}
	/**
	 * @return the fechaLiquidacion
	 */
	public Date getFechaLiquidacion() {
		return fechaLiquidacion;
	}
	/**
	 * @param fechaLiquidacion the fechaLiquidacion to set
	 */
	public void setFechaLiquidacion(Date fechaLiquidacion) {
		this.fechaLiquidacion = fechaLiquidacion;
	}
	/**
	 * @return the diasFechaFin
	 */
	public Integer getDiasFechaFin() {
		return diasFechaFin;
	}
	/**
	 * @param diasFechaFin the diasFechaFin to set
	 */
	public void setDiasFechaFin(Integer diasFechaFin) {
		this.diasFechaFin = diasFechaFin;
	}
	/**
	 * @return the montoFinanciado
	 */
	public double getMontoFinanciado() {
		return montoFinanciado;
	}
	/**
	 * @param montoFinanciado the montoFinanciado to set
	 */
	public void setMontoFinanciado(double montoFinanciado) {
		this.montoFinanciado = montoFinanciado;
	}
}
