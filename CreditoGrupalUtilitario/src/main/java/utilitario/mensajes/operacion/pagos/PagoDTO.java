package utilitario.mensajes.operacion.pagos;

import utilitario.mensajes.comun.ObjetoValor;

public class PagoDTO extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4016571982005219898L;
	/** fechaProceso */
	private String fechaProceso;
	/** fechaValor */
	private String fechaValor;
	/** referencia */
	private String referencia;
	/** monto */
	private double monto;
	/** medioPago */
	private String medioPago;
	/** contrato */
	private String contrato;
	/** contratoLD */
	private String contratoLD;
	/** nombreSucursal */
	private String nombreSucursal;
	/** observaciones */
	private String observaciones;
	/** grupoPago */
	private String grupoPago;
	/** procesoArchivo */
	private String procesoArchivo;
	/** idRegistro */
	private String idRegistro;

	/** cuentaAplicar */
	private String cuentaAplicar;
	/** cuentaAplicar */
	private String contratoAplicar;
	/** estatus */
	private boolean estatus;
	/** mensaje */
	private String mensaje;
	/** usuario */
	private String usuario;
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
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}
	/**
	 * @param referencia the referencia to set
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
	 * @return the procesoArchivo
	 */
	public String getProcesoArchivo() {
		return procesoArchivo;
	}
	/**
	 * @param procesoArchivo the procesoArchivo to set
	 */
	public void setProcesoArchivo(String procesoArchivo) {
		this.procesoArchivo = procesoArchivo;
	}
	/**
	 * @return the idRegistro
	 */
	public String getIdRegistro() {
		return idRegistro;
	}
	/**
	 * @param idRegistro the idRegistro to set
	 */
	public void setIdRegistro(String idRegistro) {
		this.idRegistro = idRegistro;
	}
	/**
	 * @return the cuentaAplicar
	 */
	public String getCuentaAplicar() {
		return cuentaAplicar;
	}
	/**
	 * @param cuentaAplicar the cuentaAplicar to set
	 */
	public void setCuentaAplicar(String cuentaAplicar) {
		this.cuentaAplicar = cuentaAplicar;
	}
	/**
	 * @return the contratoAplicar
	 */
	public String getContratoAplicar() {
		return contratoAplicar;
	}
	/**
	 * @param contratoAplicar the contratoAplicar to set
	 */
	public void setContratoAplicar(String contratoAplicar) {
		this.contratoAplicar = contratoAplicar;
	}
	/**
	 * @return the estatus
	 */
	public boolean isEstatus() {
		return estatus;
	}
	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}
	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
