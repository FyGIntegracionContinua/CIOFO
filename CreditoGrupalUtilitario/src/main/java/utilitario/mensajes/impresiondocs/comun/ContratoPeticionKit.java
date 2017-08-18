package utilitario.mensajes.impresiondocs.comun;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author mi.mejorada
 *
 */
public class ContratoPeticionKit extends ObjetoValor {

	/**
	 * ContratoPeticionKit
	 */
	public ContratoPeticionKit() {

	}
	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = -5296436412179929248L;
	/**
	 * header EncabezadoPeticion
	 */
	private EncabezadoPeticion	header;
	/**
	 * contrato String
	 */
	private String contrato;

	/** The anterior. */
	private boolean anterior;

	/** The reca. */
	private String reca;

	/**
	 * @return .
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}
	/**
	 * @param header .
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}
	/**
	 * @return .
	 */
	public String getContrato() {
		return contrato;
	}
	/**
	 * @param contrato .
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	/**
	 * @return the anterior
	 */
	public boolean getAnterior() {
		return anterior;
	}
	/**
	 * @param anterior the anterior to set
	 */
	public void setAnterior(boolean anterior) {
		this.anterior = anterior;
	}
	/**
	 * @return the reca
	 */
	public String getReca() {
		return reca;
	}
	/**
	 * @param reca the reca to set
	 */
	public void setReca(String reca) {
		this.reca = reca;
	}
}
