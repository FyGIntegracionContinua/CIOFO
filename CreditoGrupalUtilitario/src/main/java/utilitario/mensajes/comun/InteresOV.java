/**
 * Tensegrity - 2011
 */
package utilitario.mensajes.comun;


/**
 * The Class InteresOV.
 */
public class 	InteresOV 	   extends 	ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	// Atributos privados de la clase  ---------------------------------------------------------------------------------
	//Entradas
	/** The producto. */
	private java.lang.String		producto;

	/** The monto credito. */
	private java.lang.Double		montoCredito;

	/** The tasa. */
	private java.lang.Double		tasa;

	/** The no pagos. */
	private java.lang.Integer		noPagos;

	/** The frecuencia pago. */
	private java.lang.String		frecuenciaPago;

	/** The fecha inicio. */
	private java.util.Date			fechaInicio;

	/** The fecha final. */
	private java.util.Date			fechaFinal;

	/** The sucursal. */
	private java.lang.Integer		sucursal;

	/** The monto pago. */
	private java.lang.Double		montoPago;

	//Salidas
	/** The header. */
	private EncabezadoRespuesta		header;

	/** The interes total. */
	private java.lang.Double		interesTotal;

	/** The iva interes total. */
	private java.lang.Double		ivaInteresTotal;

	// Constructor  ----------------------------------------------------------------------------------------------------
	/**
	 * Instancia una nueva interes ov.
	 */
	public InteresOV() {
		header = new EncabezadoRespuesta();
		}

	/**
	 * Obtiene producto.
	 *
	 * @return the producto
	 */
	public java.lang.String getProducto() {
		return producto;
	}

	/**
	 * Establece producto.
	 *
	 * @param producto the producto to set
	 */
	public void setProducto(java.lang.String producto) {
		this.producto = producto;
	}

	/**
	 * Obtiene monto credito.
	 *
	 * @return the montoCredito
	 */
	public java.lang.Double getMontoCredito() {
		return montoCredito;
	}

	/**
	 * Establece monto credito.
	 *
	 * @param montoCredito the montoCredito to set
	 */
	public void setMontoCredito(java.lang.Double montoCredito) {
		this.montoCredito = montoCredito;
	}

	/**
	 * Obtiene tasa.
	 *
	 * @return the tasa
	 */
	public java.lang.Double getTasa() {
		return tasa;
	}

	/**
	 * Establece tasa.
	 *
	 * @param tasa the tasa to set
	 */
	public void setTasa(java.lang.Double tasa) {
		this.tasa = tasa;
	}

	/**
	 * Obtiene no pagos.
	 *
	 * @return the noPagos
	 */
	public java.lang.Integer getNoPagos() {
		return noPagos;
	}

	/**
	 * Establece no pagos.
	 *
	 * @param noPagos the noPagos to set
	 */
	public void setNoPagos(java.lang.Integer noPagos) {
		this.noPagos = noPagos;
	}

	/**
	 * Obtiene frecuencia pago.
	 *
	 * @return the frecuenciaPago
	 */
	public java.lang.String getFrecuenciaPago() {
		return frecuenciaPago;
	}

	/**
	 * Establece frecuencia pago.
	 *
	 * @param frecuenciaPago the frecuenciaPago to set
	 */
	public void setFrecuenciaPago(java.lang.String frecuenciaPago) {
		this.frecuenciaPago = frecuenciaPago;
	}

	/**
	 * Obtiene fecha inicio.
	 *
	 * @return the fechaInicio
	 */
	public java.util.Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Establece fecha inicio.
	 *
	 * @param fechaInicio a fecha inicio
	 */
	public void setFechaInicio(java.util.Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Obtiene fecha final.
	 *
	 * @return the fechaFinal
	 */
	public java.util.Date getFechaFinal() {
		return fechaFinal;
	}

	/**
	 * Establece fecha final.
	 *
	 * @param fechaFinal the fechaFinal to set
	 */
	public void setFechaFinal(java.util.Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}

	/**
	 * Obtiene sucursal.
	 *
	 * @return the sucursal
	 */
	public java.lang.Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(java.lang.Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene monto pago.
	 *
	 * @return the montoPago
	 */
	public java.lang.Double getMontoPago() {
		return montoPago;
	}

	/**
	 * Establece monto pago.
	 *
	 * @param montoPago the montoPago to set
	 */
	public void setMontoPago(java.lang.Double montoPago) {
		this.montoPago = montoPago;
	}

	/**
	 * Obtiene interes total.
	 *
	 * @return the interesTotal
	 */
	public java.lang.Double getInteresTotal() {
		return interesTotal;
	}

	/**
	 * Establece interes total.
	 *
	 * @param interesTotal the interesTotal to set
	 */
	public void setInteresTotal(java.lang.Double interesTotal) {
		this.interesTotal = interesTotal;
	}

	/**
	 * Obtiene iva interes total.
	 *
	 * @return the ivaInteresTotal
	 */
	public java.lang.Double getIvaInteresTotal() {
		return ivaInteresTotal;
	}

	/**
	 * Establece iva interes total.
	 *
	 * @param ivaInteresTotal the ivaInteresTotal to set
	 */
	public void setIvaInteresTotal(java.lang.Double ivaInteresTotal) {
		this.ivaInteresTotal = ivaInteresTotal;
	}

	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

}
