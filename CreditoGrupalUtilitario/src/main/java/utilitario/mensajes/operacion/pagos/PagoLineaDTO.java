package utilitario.mensajes.operacion.pagos;

import utilitario.mensajes.comun.ObjetoValor;

public class PagoLineaDTO extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 6477677016313380439L;

	/** contrato */
	private String contrato;
	/** contratoLD */
	private String contratoLD;
	/** folio */
	private String folio;
	/** monto */
	private double monto;
	/** fechaPeticion */
	private String fechaPeticion;
	/** horaPeticion */
	private String horaPeticion;
	/** estadoCuenta */
	private String estadoCuenta;
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
	 * @return the folio
	 */
	public String getFolio() {
		return folio;
	}

	/**
	 * @param folio the folio to set
	 */
	public void setFolio(String folio) {
		this.folio = folio;
	}

	/**
	 * @return the monto
	 */
	public double getMonto() {
		return monto;
	}

	/**
	 * @param monto the monto to set
	 */
	public void setMonto(double monto) {
		this.monto = monto;
	}

	/**
	 * @return the fechaPeticion
	 */
	public String getFechaPeticion() {
		return fechaPeticion;
	}

	/**
	 * @param fechaPeticion the fechaPeticion to set
	 */
	public void setFechaPeticion(String fechaPeticion) {
		this.fechaPeticion = fechaPeticion;
	}

	/**
	 * @return the horaPeticion
	 */
	public String getHoraPeticion() {
		return horaPeticion;
	}

	/**
	 * @param horaPeticion the horaPeticion to set
	 */
	public void setHoraPeticion(String horaPeticion) {
		this.horaPeticion = horaPeticion;
	}
	/**
	 * @return the estadoCuenta
	 */
	public String getEstadoCuenta() {
		return estadoCuenta;
	}
	/**
	 * @param estadoCuenta the estadoCuenta to set
	 */
	public void setEstadoCuenta(String estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}
}
