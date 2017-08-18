package utilitario.mensajes.operacion;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;

public class ContratoPagosLineaOV extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1993489093016713183L;
	/** contrato */
	private String contrato;
	/** contratoLd */
	private String contratoLd;
	/** nombreGrupo */
	private String nombreGrupo;
	/** montoCorriente */
	private double montoCorriente;
	/** MontoToal */
	private double montoTotal;
	/** parcialidad */
	private double parcialidad;
	/** noPagos */
	private int noPagos;
	/** noPago */
	private int noPago;
	/** fechaProxPago */
	private Date fechaProxPago;
	/** estatus */
	private String estatus;
	/** saldoLiquidar */
	private double saldoLiquidar;
	/** capitalInsoluto */
	private double capitalInsoluto;
	/** montoPagoAtrasado */
	private double montoPagoAtrasado;
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
	 * @return the contratoLd
	 */
	public String getContratoLd() {
		return contratoLd;
	}
	/**
	 * @param contratoLd the contratoLd to set
	 */
	public void setContratoLd(String contratoLd) {
		this.contratoLd = contratoLd;
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
	 * @return the montoCorriente
	 */
	public double getMontoCorriente() {
		return montoCorriente;
	}
	/**
	 * @param montoCorriente the montoCorriente to set
	 */
	public void setMontoCorriente(double montoCorriente) {
		this.montoCorriente = montoCorriente;
	}
	/**
	 * @return the montoToal
	 */
	public double getMontoTotal() {
		return montoTotal;
	}
	/**
	 * @param montoTotal the montoToal to set
	 */
	public void setMontoTotal(double montoTotal) {
		this.montoTotal = montoTotal;
	}
	/**
	 * @return the parcialidad
	 */
	public double getParcialidad() {
		return parcialidad;
	}
	/**
	 * @param parcialidad the parcialidad to set
	 */
	public void setParcialidad(double parcialidad) {
		this.parcialidad = parcialidad;
	}
	/**
	 * @return the noPagos
	 */
	public int getNoPagos() {
		return noPagos;
	}
	/**
	 * @param noPagos the noPagos to set
	 */
	public void setNoPagos(int noPagos) {
		this.noPagos = noPagos;
	}
	/**
	 * @return the noPago
	 */
	public int getNoPago() {
		return noPago;
	}
	/**
	 * @param noPago the noPago to set
	 */
	public void setNoPago(int noPago) {
		this.noPago = noPago;
	}
	/**
	 * @return the fechaProxPago
	 */
	public Date getFechaProxPago() {
		return fechaProxPago;
	}
	/**
	 * @param fechaProxPago the fechaProxPago to set
	 */
	public void setFechaProxPago(Date fechaProxPago) {
		this.fechaProxPago = fechaProxPago;
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
	/**
	 * @return the saldoLiquidar
	 */
	public double getSaldoLiquidar() {
		return saldoLiquidar;
	}
	/**
	 * @param saldoLiquidar the saldoLiquidar to set
	 */
	public void setSaldoLiquidar(double saldoLiquidar) {
		this.saldoLiquidar = saldoLiquidar;
	}
	/**
	 * @return the capitalInsoluto
	 */
	public double getCapitalInsoluto() {
		return capitalInsoluto;
	}
	/**
	 * @param capitalInsoluto the capitalInsoluto to set
	 */
	public void setCapitalInsoluto(double capitalInsoluto) {
		this.capitalInsoluto = capitalInsoluto;
	}
	/**
	 * @return the montoPagoAtrasado
	 */
	public double getMontoPagoAtrasado() {
		return montoPagoAtrasado;
	}
	/**
	 * @param montoPagoAtrasado the montoPagoAtrasado to set
	 */
	public void setMontoPagoAtrasado(double montoPagoAtrasado) {
		this.montoPagoAtrasado = montoPagoAtrasado;
	}
}
