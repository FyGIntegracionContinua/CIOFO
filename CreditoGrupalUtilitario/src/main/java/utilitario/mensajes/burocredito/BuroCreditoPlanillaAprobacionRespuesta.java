package utilitario.mensajes.burocredito;

import java.util.Date;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

public class BuroCreditoPlanillaAprobacionRespuesta extends ObjetoValor {


	/**
	 * serial
	 */
	private static final long serialVersionUID = -2178846567524795366L;
	/** The header. */
	private EncabezadoRespuesta header;
	/** The dFechaConsulta. */
	private Date dFechaConsulta;
	/** The saldoVencido. */
	private double saldoVencido;
	/** The saldoActual. */
	private double saldoActual;
	/** The cuotaSemanal. */
	private double cuotaSemanal;
	/** The mopMaximoAbierto. */
	private int mopMaximoAbierto;
	/** The mopMaximoCerrado. */
	private int mopMaximoCerrado;
	/** The mopAutoHipo. */
	private int mopAutoHipo;
	/** The saldoAutoHipo. */
	private double saldoAutoHipo;
	/** The vigenciaConsultaBuro. */
	private String vigenciaConsultaBuro;
	/** The folioConsulta. */
	private String folioConsulta;
	/** The clavesObserv. */
	private String clavesObserv;

	/**
	 * BuroCreditoPlanillaAprobacionRespuesta
	 */
	public BuroCreditoPlanillaAprobacionRespuesta() {

	}
	/**
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}
	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}
	/**
	 * @return the dFechaConsulta
	 */
	public Date getdFechaConsulta() {
		return dFechaConsulta;
	}
	/**
	 * @param dFechaConsulta the dFechaConsulta to set
	 */
	public void setdFechaConsulta(Date dFechaConsulta) {
		this.dFechaConsulta = dFechaConsulta;
	}
	/**
	 * @return the saldoVencido
	 */
	public double getSaldoVencido() {
		return saldoVencido;
	}
	/**
	 * @param saldoVencido the saldoVencido to set
	 */
	public void setSaldoVencido(double saldoVencido) {
		this.saldoVencido = saldoVencido;
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
	 * @return the cuotaSemanal
	 */
	public double getCuotaSemanal() {
		return cuotaSemanal;
	}
	/**
	 * @param cuotaSemanal the cuotaSemanal to set
	 */
	public void setCuotaSemanal(double cuotaSemanal) {
		this.cuotaSemanal = cuotaSemanal;
	}
	/**
	 * @return the mopMaximoAbierto
	 */
	public int getMopMaximoAbierto() {
		return mopMaximoAbierto;
	}
	/**
	 * @param mopMaximoAbierto the mopMaximoAbierto to set
	 */
	public void setMopMaximoAbierto(int mopMaximoAbierto) {
		this.mopMaximoAbierto = mopMaximoAbierto;
	}
	/**
	 * @return the mopMaximoCerrado
	 */
	public int getMopMaximoCerrado() {
		return mopMaximoCerrado;
	}
	/**
	 * @param mopMaximoCerrado the mopMaximoCerrado to set
	 */
	public void setMopMaximoCerrado(int mopMaximoCerrado) {
		this.mopMaximoCerrado = mopMaximoCerrado;
	}
	/**
	 * @return the mopAutoHipo
	 */
	public int getMopAutoHipo() {
		return mopAutoHipo;
	}
	/**
	 * @param mopAutoHipo the mopAutoHipo to set
	 */
	public void setMopAutoHipo(int mopAutoHipo) {
		this.mopAutoHipo = mopAutoHipo;
	}
	/**
	 * @return the saldoAutoHipo
	 */
	public double getSaldoAutoHipo() {
		return saldoAutoHipo;
	}
	/**
	 * @param saldoAutoHipo the saldoAutoHipo to set
	 */
	public void setSaldoAutoHipo(double saldoAutoHipo) {
		this.saldoAutoHipo = saldoAutoHipo;
	}
	/**
	 * @return the vigenciaConsultaBuro
	 */
	public String getVigenciaConsultaBuro() {
		return vigenciaConsultaBuro;
	}
	/**
	 * @param vigenciaConsultaBuro the vigenciaConsultaBuro to set
	 */
	public void setVigenciaConsultaBuro(String vigenciaConsultaBuro) {
		this.vigenciaConsultaBuro = vigenciaConsultaBuro;
	}
	/**
	 * @return the folioConsulta
	 */
	public String getFolioConsulta() {
		return folioConsulta;
	}
	/**
	 * @param folioConsulta the folioConsulta to set
	 */
	public void setFolioConsulta(String folioConsulta) {
		this.folioConsulta = folioConsulta;
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
