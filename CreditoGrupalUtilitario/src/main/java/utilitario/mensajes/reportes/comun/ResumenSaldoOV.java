package utilitario.mensajes.reportes.comun;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ResumenSaldoOV.
 */
public class ResumenSaldoOV extends ObjetoValor {

	/**
	 * ResumenSaldoOV.
	 */
	public ResumenSaldoOV() {

	}

	/** long serialVersionUID. */
	private static final long serialVersionUID = 8193666644349852725L;

	/** Integer codigo. */
	private Integer codigo;

	/** String mensaje. */
	private String mensaje;

	/** Date fechaHoy. */
	private Date fechaHoy;

	/** Double vencido. */
	private Double vencido;

	/** Double insoluto. */
	private Double insoluto;

	/** Double interes. */
	private Double interes;

	/** Double total. */
	private Double total;

	/** Double pagos. */
	private Double pagos;

	/** Double disposiciones. */
	private Double disposiciones;

	/** Double comiciones. */
	private Double comiciones;

	/** Double bonificaciones. */
	private Double bonificaciones;

	/** Double ivaInteres. */
	private Double ivaInteres;

	/** Double capitalPagado. */
	private Double capitalPagado;

	/** Double interesPagado. */
	private Double interesPagado;

	/** Double moraPagado. */
	private Double moraPagado;

	//suma de interes + ivaInteres
	/** Double interesTotalPago. */
	@SuppressWarnings("unused")
	private Double interesTotalPago;

	/** Double disponible punto 9c */
	private Double disponible;

	/** Double impuestos Retenidos punto 11d */
	private Double impuestosRetenidos;

	/** Double monto de interes*/
	private Double montoInteres;

	/** Double Total a liquidar descontando garantia*/
	private Double totalDescGarantia;

	/**
	 * Obtiene interes total pago.
	 *
	 * @return getInteresTotalPago :
	 */
	public Double getInteresTotalPago() {

		//interes = interes == null ? 0.0 : interes;
		//ivaInteres = ivaInteres == null ? 0.0 : ivaInteres;

		return interes + ivaInteres;
	}
	/**/

	/**
	 * Obtiene codigo.
	 *
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}

	/**
	 * Establece codigo.
	 *
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtiene mensaje.
	 *
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * Establece mensaje.
	 *
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * Obtiene fecha hoy.
	 *
	 * @return the fechaHoy
	 */
	public Date getFechaHoy() {
		return fechaHoy;
	}

	/**
	 * Establece fecha hoy.
	 *
	 * @param fechaHoy the fechaHoy to set
	 */
	public void setFechaHoy(Date fechaHoy) {
		this.fechaHoy = fechaHoy;
	}

	/**
	 * Obtiene vencido.
	 *
	 * @return the vencido
	 */
	public Double getVencido() {
		return vencido;
	}

	/**
	 * Establece vencido.
	 *
	 * @param vencido the vencido to set
	 */
	public void setVencido(Double vencido) {
		this.vencido = vencido;
	}

	/**
	 * Obtiene insoluto.
	 *
	 * @return the insoluto
	 */
	public Double getInsoluto() {
		return insoluto;
	}

	/**
	 * Establece insoluto.
	 *
	 * @param insoluto the insoluto to set
	 */
	public void setInsoluto(Double insoluto) {
		this.insoluto = insoluto;
	}

	/**
	 * Obtiene interes.
	 *
	 * @return the interes
	 */
	public Double getInteres() {
		return interes;
	}

	/**
	 * Establece interes.
	 *
	 * @param interes the interes to set
	 */
	public void setInteres(Double interes) {
		this.interes = interes;
	}

	/**
	 * Obtiene total.
	 *
	 * @return the total
	 */
	public Double getTotal() {
		return total;
	}

	/**
	 * Establece total.
	 *
	 * @param total the total to set
	 */
	public void setTotal(Double total) {
		this.total = total;
	}

	/**
	 * Obtiene pagos.
	 *
	 * @return the pagos
	 */
	public Double getPagos() {
		return pagos;
	}

	/**
	 * Establece pagos.
	 *
	 * @param pagos the pagos to set
	 */
	public void setPagos(Double pagos) {
		this.pagos = pagos;
	}

	/**
	 * Obtiene disposiciones.
	 *
	 * @return the disposiciones
	 */
	public Double getDisposiciones() {
		return disposiciones;
	}

	/**
	 * Establece disposiciones.
	 *
	 * @param disposiciones the disposiciones to set
	 */
	public void setDisposiciones(Double disposiciones) {
		this.disposiciones = disposiciones;
	}

	/**
	 * Obtiene comiciones.
	 *
	 * @return the comiciones
	 */
	public Double getComiciones() {
		return comiciones;
	}

	/**
	 * Establece comiciones.
	 *
	 * @param comiciones the comiciones to set
	 */
	public void setComiciones(Double comiciones) {
		this.comiciones = comiciones;
	}

	/**
	 * Obtiene bonificaciones.
	 *
	 * @return the bonificaciones
	 */
	public Double getBonificaciones() {
		return bonificaciones;
	}

	/**
	 * Establece bonificaciones.
	 *
	 * @param bonificaciones the bonificaciones to set
	 */
	public void setBonificaciones(Double bonificaciones) {
		this.bonificaciones = bonificaciones;
	}

	/**
	 * Obtiene iva interes.
	 *
	 * @return the ivaInteres
	 */
	public Double getIvaInteres() {
		return ivaInteres;
	}

	/**
	 * Establece iva interes.
	 *
	 * @param ivaInteres the ivaInteres to set
	 */
	public void setIvaInteres(Double ivaInteres) {
		this.ivaInteres = ivaInteres;
	}

	/**
	 * Obtiene capital pagado.
	 *
	 * @return the capitalPagado
	 */
	public Double getCapitalPagado() {
		return capitalPagado;
	}

	/**
	 * Establece capital pagado.
	 *
	 * @param capitalPagado the capitalPagado to set
	 */
	public void setCapitalPagado(Double capitalPagado) {
		this.capitalPagado = capitalPagado;
	}

	/**
	 * Obtiene interes pagado.
	 *
	 * @return the interesPagado
	 */
	public Double getInteresPagado() {
		return interesPagado;
	}

	/**
	 * Establece interes pagado.
	 *
	 * @param interesPagado the interesPagado to set
	 */
	public void setInteresPagado(Double interesPagado) {
		this.interesPagado = interesPagado;
	}

	/**
	 * Obtiene mora pagado.
	 *
	 * @return the moraPagado
	 */
	public Double getMoraPagado() {
		return moraPagado;
	}

	/**
	 * Establece mora pagado.
	 *
	 * @param moraPagado the moraPagado to set
	 */
	public void setMoraPagado(Double moraPagado) {
		this.moraPagado = moraPagado;
	}

	/**
	 * Establece interes total pago.
	 *
	 * @param interesTotalPago the interesTotalPago to set
	 */
	public void setInteresTotalPago(Double interesTotalPago) {
		this.interesTotalPago = interesTotalPago;
	}

	/**
	 * @return the disponible
	 */
	public Double getDisponible() {
		return disponible;
	}

	/**
	 * @param disponible the disponible to set
	 */
	public void setDisponible(Double disponible) {
		this.disponible = disponible;
	}

	/**
	 * @return the impuestosRetenidos
	 */
	public Double getImpuestosRetenidos() {
		return impuestosRetenidos;
	}

	/**
	 * @param impuestosRetenidos the impuestosRetenidos to set
	 */
	public void setImpuestosRetenidos(Double impuestosRetenidos) {
		this.impuestosRetenidos = impuestosRetenidos;
	}

	/**
	 * @return the montoInteres
	 */
	public Double getMontoInteres() {
		return montoInteres;
	}

	/**
	 * @param montoInteres the montoInteres to set
	 */
	public void setMontoInteres(Double montoInteres) {
		this.montoInteres = montoInteres;
	}

	/**
	 * @return the totalDescGarantia
	 */
	public Double getTotalDescGarantia() {
		return totalDescGarantia;
	}

	/**
	 * @param totalDescGarantia the totalDescGarantia to set
	 */
	public void setTotalDescGarantia(Double totalDescGarantia) {
		this.totalDescGarantia = totalDescGarantia;
	}

}
