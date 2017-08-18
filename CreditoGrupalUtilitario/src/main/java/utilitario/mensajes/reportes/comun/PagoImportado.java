package utilitario.mensajes.reportes.comun;

import utilitario.mensajes.comun.ObjetoValor;

public class PagoImportado extends ObjetoValor {

	/** serialVersionUID */
	private static final long serialVersionUID = -5587445984903899898L;
	/** Fecha del proceso  */
	private String fechaProceso;
	/** Fecha valor  */
	private String fechaValor;
	/** Referencia del pago  */
	private String referencia;
	/** Monto del pago  */
	private double monto;
	/** Medio del pago  */
	private String medioPago;
	/** Estatus del pago  */
	private String estatus;
	/** Contrato  */
	private String contrato;
	/** Contrato  LD */
	private String contratoLD;
	/** Nombre sucursal del contrato  */
	private String nombreSucursal;
	/** Observaciones del pago  */
	private String observaciones;
	/** Tipo de pago  */
	private String grupoPago;

	/** The origen. */
	private String origen;

	/**
	 * @return the fechaProceso
	 */
	public String getFechaProceso() {
		return fechaProceso;
	}
	/**
	 * @param fechaProceso the fechaProceso to set
	 */
	public void setFechaProceso(String fechaProceso) {
		this.fechaProceso = fechaProceso;
	}
	/**
	 * @return the fechaValor
	 */
	public String getFechaValor() {
		return fechaValor;
	}
	/**
	 * @param fechaValor the fechaValor to set
	 */
	public void setFechaValor(String fechaValor) {
		this.fechaValor = fechaValor;
	}
	/**
	 * @return the referecia
	 */
	public String getReferencia() {
		return referencia;
	}
	/**
	 * @param referencia the referecia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
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
	 * @return the medioPago
	 */
	public String getMedioPago() {
		return medioPago;
	}
	/**
	 * @param medioPago the medioPago to set
	 */
	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
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
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}
	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	/**
	 * @return the grupoPago
	 */
	public String getGrupoPago() {
		return grupoPago;
	}
	/**
	 * @param grupoPago the grupoPago to set
	 */
	public void setGrupoPago(String grupoPago) {
		this.grupoPago = grupoPago;
	}
	/**
	 * @return the origen
	 */
	public String getOrigen() {
		return origen;
	}
	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(String origen) {
		this.origen = origen;
	}

}
