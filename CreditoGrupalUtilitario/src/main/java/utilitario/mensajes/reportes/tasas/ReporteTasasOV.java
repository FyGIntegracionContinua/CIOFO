package utilitario.mensajes.reportes.tasas;

import utilitario.mensajes.comun.ObjetoValor;

public class ReporteTasasOV  extends ObjetoValor {

	/**
	 * The Constant serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Tasa actual
	 */
	private Double tasaActual;

	/**
	 * Tasa Interes
	 */
	private Double tasaAnterior;

	/**
	 * Tasa Anual
	 */
	private Double tasaAnual;

	/**
	 * Tasa Interes Anual
	 */
	private Double tasaAnteriorAnual;

	/**
	 * ContratoLD
	 */
	private String contratoLD;

	/**
	 * grupo
	 */
	private String grupo;

	/**
	 * numSucursal
	 */
	private String numSucursal;

	/**
	 * sucursal
	 */
	private String sucursal;

	/**
	 * nombre de division
	 */
	private String division;

	/**
	 * zona
	 */
	private String zona;

	/**
	 * fechaReestructura
	 */
	private String fechaReestructura;

	/**
	 * contrato
	 */
	private String contrato;

	/**
	 * cliente
	 */
	private String cliente;

	/**
	 * fechaContrato
	 */
	private String fechaContrato;

	/**
	 * frecuenciaPago
	 */
	private String frecuenciaPago;

	/**
	 * producto
	 */
	private String producto;

	/**
	 * ciclo
	 */
	private String ciclo;

	/**
	 * usuarioReestructura
	 */
	private String usuarioReestructura;

	/**
	 *@return the tasaActual
	 */
	public Double getTasaActual() {
		return tasaActual;
	}

	/**
	 * @param tasaActual = tasaActual
	 */
	public void setTasaActual(Double tasaActual) {
		this.tasaActual = tasaActual;
	}

	/**
	 *@return the tasaActual
	 */
	public Double getTasaAnterior() {
		return tasaAnterior;
	}

	/**
	 *
	 * @param tasaAnterior the tasaAnterior to set
	 */
	public void setTasaAnterior(Double tasaAnterior) {
		this.tasaAnterior = tasaAnterior;
	}

	/**
	 *@return the tasaActual
	 */
	public Double getTasaAnual() {
		return tasaAnual;
	}

	/**
	 *
	 * @param tasaAnual the tasaAnual to set
	 */
	public void setTasaAnual(Double tasaAnual) {
		this.tasaAnual = tasaAnual;
	}

	/**
	 *@return the tasaAnteriorAnual
	 */
	public Double getTasaAnteriorAnual() {
		return tasaAnteriorAnual;
	}

	/**
	 *
	 * @param tasaAnteriorAnual the tasaAnteriorAnual to set
	 */
	public void setTasaAnteriorAnual(Double tasaAnteriorAnual) {
		this.tasaAnteriorAnual = tasaAnteriorAnual;
	}

	/**
	 *@return the contratoLD
	 */
	public String getContratoLD() {
		return contratoLD;
	}

	/**
	 *
	 * @param contratoLD the contratoLD to set
	 */
	public void setContratoLD(String contratoLD) {
		this.contratoLD = contratoLD;
	}

	/**
	 *@return the grupo
	 */
	public String getGrupo() {
		return grupo;
	}

	/**
	 *
	 * @param grupo the grupo to set
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	/**
	 *@return the numSucursal
	 */
	public String getNumSucursal() {
		return numSucursal;
	}

	/**
	 *
	 * @param numSucursal the numSucursal to set
	 */
	public void setNumSucursal(String numSucursal) {
		this.numSucursal = numSucursal;
	}

	/**
	 *@return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 *
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 *@return the division
	 */
	public String getDivision() {
		return division;
	}

	/**
	 *
	 * @param division the division to set
	 */
	public void setDivision(String division) {
		this.division = division;
	}

	/**
	 *@return the zona
	 */
	public String getZona() {
		return zona;
	}

	/**
	 *
	 * @param zona the zona to set
	 */
	public void setZona(String zona) {
		this.zona = zona;
	}

	/**
	 *@return the fechaReestructura
	 */
	public String getFechaReestructura() {
		return fechaReestructura;
	}

	/**
	 *
	 * @param fechaReestructura the fechaReestructura to set
	 */
	public void setFechaReestructura(String fechaReestructura) {
		this.fechaReestructura = fechaReestructura;
	}

	/**
	 *@return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 *
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 *@return the cliente
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 *
	 * @param cliente the cliente to set
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	/**
	 *@return the fechaContrato
	 */
	public String getFechaContrato() {
		return fechaContrato;
	}

	/**
	 *
	 * @param fechaContrato the fechaContrato to set
	 */
	public void setFechaContrato(String fechaContrato) {
		this.fechaContrato = fechaContrato;
	}

	/**
	 *@return the frecuenciaPago
	 */
	public String getFrecuenciaPago() {
		return frecuenciaPago;
	}

	/**
	 *
	 * @param frecuenciaPago the frecuenciaPago to set
	 */
	public void setFrecuenciaPago(String frecuenciaPago) {
		this.frecuenciaPago = frecuenciaPago;
	}

	/**
	 *@return the producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 *
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

	/**
	 *@return the ciclo
	 */
	public String getCiclo() {
		return ciclo;
	}

	/**
	 *
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 *@return the usuarioReestructura
	 */
	public String getUsuarioReestructura() {
		return usuarioReestructura;
	}

	/**
	 *
	 * @param usuarioReestructura the usuarioReestructura to set
	 */
	public void setUsuarioReestructura(String usuarioReestructura) {
		this.usuarioReestructura = usuarioReestructura;
	}




}
