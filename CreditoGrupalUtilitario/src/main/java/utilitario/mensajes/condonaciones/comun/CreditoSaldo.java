package utilitario.mensajes.condonaciones.comun;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class CreditoSaldo.
 */
public class CreditoSaldo extends ObjetoValor {

	/**
	 * Instancia una nueva credito saldo.
	 */
	public CreditoSaldo() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2547908714677504729L;

	/** The contrato. */
	private String contrato;

	/** The nombre. */
	private String nombre;

	/** The estatus. */
	private String estatus;

	/** The tipo credito. */
	private String tipoCredito;
	/* money */
	/** The monto pago. */
	private Double montoPago;
	/* money */
	/** The disponible. */
	private Double disponible;
	/* money */
	/** The monto pago atrasado. */
	private Double montoPagoAtrasado;
	/* money */
	/** The monto corriente. */
	private Double montoCorriente;
	/* money */
	/** The saldo liquidar. */
	private Double saldoLiquidar;
	/* money */
	/** The monto vigente. */
	private Double montoVigente;

	/** The fecha proximo pago. */
	private String fechaProximoPago;

	/** The dias atraso. */
	private Integer diasAtraso;

	/** The fecha ultimo pago. */
	private String fechaUltimoPago;

	/** The fecha ultima disposicion. */
	private String fechaUltimaDisposicion;
	/* money */
	/** The monto disposicion. */
	private Double montoDisposicion;

	/** The pagos atrasados. */
	private Integer pagosAtrasados;

	/** The cliente. */
	private String cliente;

	/** The sucursal. */
	private Integer sucursal;

	/** The frecuencia pago. */
	private String frecuenciaPago;

	/** The descripcion frecuencia. */
	private String descripcionFrecuencia;

	/** The direccion. */
	private String direccion;

	/** The direccion empleo. */
	private String direccionEmpleo;

	/** The tipo producto. */
	private String tipoProducto;

	/** The afiliacion servicio. */
	private String afiliacionServicio;

	/** The producto. */
	private String producto;

	/** The descripcion producto. */
	private String descripcionProducto;

	/** The categoria producto. */
	private String categoriaProducto;

	/** The tasa. */
	private String tasa;

	/** The nombre sucursal. */
	private String nombreSucursal;

	/** The plazo. */
	private String plazo;

	/** The monto prestamo. */
	private String montoPrestamo;
	
	/** The numPagoActual. */
	private String numPagoActual;


	/**
	 * Obtiene monto prestamo.
	 *
	 * @return the montoPrestamo
	 */
	public String getMontoPrestamo() {
		return montoPrestamo;
	}

	/**
	 * Establece monto prestamo.
	 *
	 * @param montoPrestamo the montoPrestamo to set
	 */
	public void setMontoPrestamo(String montoPrestamo) {		
		this.montoPrestamo = montoPrestamo;
	}

	/**
	 * Obtiene tasa.
	 *
	 * @return the tasa
	 */
	public String getTasa() {
		return tasa;
	}

	/**
	 * Establece tasa.
	 *
	 * @param tasa the tasa to set
	 */
	public void setTasa(String tasa) {
		this.tasa = tasa;
	}

	/**
	 * Obtiene nombre sucursal.
	 *
	 * @return the nombreSucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}

	/**
	 * Establece nombre sucursal.
	 *
	 * @param nombreSucursal the nombreSucursal to set
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	/**
	 * Obtiene plazo.
	 *
	 * @return the plazo
	 */
	public String getPlazo() {
		return plazo;
	}

	/**
	 * Establece plazo.
	 *
	 * @param plazo the plazo to set
	 */
	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}

	/* money */
	/** The insoluto. */
	private Double insoluto;

	/** The cobranza. */
	private String cobranza;

	/**
	 * Obtiene contrato.
	 *
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * Establece contrato.
	 *
	 * @param contrato            the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * Obtiene nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece nombre.
	 *
	 * @param nombre            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene estatus.
	 *
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * Establece estatus.
	 *
	 * @param estatus            the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * Obtiene tipo credito.
	 *
	 * @return the tipo
	 */
	public String getTipoCredito() {
		return tipoCredito;
	}

	/**
	 * Establece tipo credito.
	 *
	 * @param tipoCredito a tipo credito
	 */
	public void setTipoCredito(String tipoCredito) {
		this.tipoCredito = tipoCredito;
	}

	/**
	 * Obtiene monto pago.
	 *
	 * @return the montoPago
	 */
	public Double getMontoPago() {
		return montoPago;
	}

	/**
	 * Establece monto pago.
	 *
	 * @param montoPago            the montoPago to set
	 */
	public void setMontoPago(Double montoPago) {
		this.montoPago = montoPago;
	}

	/**
	 * Obtiene disponible.
	 *
	 * @return the disponible
	 */
	public Double getDisponible() {
		return disponible;
	}

	/**
	 * Establece disponible.
	 *
	 * @param disponible            the disponible to set
	 */
	public void setDisponible(Double disponible) {
		this.disponible = disponible;
	}

	/**
	 * Obtiene monto pago atrasado.
	 *
	 * @return the montoPagoAtrasado
	 */
	public Double getMontoPagoAtrasado() {
		return montoPagoAtrasado;
	}

	/**
	 * Establece monto pago atrasado.
	 *
	 * @param montoPagoAtrasado            the montoPagoAtrasado to set
	 */
	public void setMontoPagoAtrasado(Double montoPagoAtrasado) {
		this.montoPagoAtrasado = montoPagoAtrasado;
	}

	/**
	 * Obtiene monto corriente.
	 *
	 * @return the montoCorriente
	 */
	public Double getMontoCorriente() {
		return montoCorriente;
	}

	/**
	 * Establece monto corriente.
	 *
	 * @param montoCorriente            the montoCorriente to set
	 */
	public void setMontoCorriente(Double montoCorriente) {
		this.montoCorriente = montoCorriente;
	}

	/**
	 * Obtiene saldo liquidar.
	 *
	 * @return the saldoLiquidar
	 */
	public Double getSaldoLiquidar() {
		return saldoLiquidar;
	}

	/**
	 * Establece saldo liquidar.
	 *
	 * @param saldoLiquidar            the saldoLiquidar to set
	 */
	public void setSaldoLiquidar(Double saldoLiquidar) {
		this.saldoLiquidar = saldoLiquidar;
	}

	/**
	 * Obtiene monto vigente.
	 *
	 * @return the montoVigente
	 */
	public Double getMontoVigente() {
		return montoVigente;
	}

	/**
	 * Establece monto vigente.
	 *
	 * @param montoVigente            the montoVigente to set
	 */
	public void setMontoVigente(Double montoVigente) {
		this.montoVigente = montoVigente;
	}

	/**
	 * Obtiene fecha proximo pago.
	 *
	 * @return the fechaProximoPago
	 */
	public String getFechaProximoPago() {
		return fechaProximoPago;
	}

	/**
	 * Establece fecha proximo pago.
	 *
	 * @param fechaProximoPago            the fechaProximoPago to set
	 */
	public void setFechaProximoPago(String fechaProximoPago) {
		this.fechaProximoPago = fechaProximoPago;
	}

	/**
	 * Obtiene fecha ultimo pago.
	 *
	 * @return the fechaUltimoPago
	 */
	public String getFechaUltimoPago() {
		return fechaUltimoPago;
	}

	/**
	 * Establece fecha ultimo pago.
	 *
	 * @param fechaUltimoPago            the fechaUltimoPago to set
	 */
	public void setFechaUltimoPago(String fechaUltimoPago) {
		this.fechaUltimoPago = fechaUltimoPago;
	}

	/**
	 * Obtiene fecha ultima disposicion.
	 *
	 * @return the fechaUltimaDisposicion
	 */
	public String getFechaUltimaDisposicion() {
		return fechaUltimaDisposicion;
	}

	/**
	 * Establece fecha ultima disposicion.
	 *
	 * @param fechaUltimaDisposicion            the fechaUltimaDisposicion to set
	 */
	public void setFechaUltimaDisposicion(String fechaUltimaDisposicion) {
		this.fechaUltimaDisposicion = fechaUltimaDisposicion;
	}

	/**
	 * Obtiene monto disposicion.
	 *
	 * @return the montoDisposicion
	 */
	public Double getMontoDisposicion() {
		return montoDisposicion;
	}

	/**
	 * Establece monto disposicion.
	 *
	 * @param montoDisposicion            the montoDisposicion to set
	 */
	public void setMontoDisposicion(Double montoDisposicion) {
		this.montoDisposicion = montoDisposicion;
	}

	/**
	 * Obtiene pagos atrasados.
	 *
	 * @return the pagosAtrasados
	 */
	public Integer getPagosAtrasados() {
		return pagosAtrasados;
	}

	/**
	 * Establece pagos atrasados.
	 *
	 * @param pagosAtrasados            the pagosAtrasados to set
	 */
	public void setPagosAtrasados(Integer pagosAtrasados) {
		this.pagosAtrasados = pagosAtrasados;
	}

	/**
	 * Obtiene cliente.
	 *
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * Establece cliente.
	 *
	 * @param cliente            the cliente to set
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	/**
	 * Obtiene sucursal.
	 *
	 * @return the sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal            the sucursal to set
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene frecuencia pago.
	 *
	 * @return the frecuenciaPago
	 */
	public String getFrecuenciaPago() {
		return frecuenciaPago;
	}

	/**
	 * Establece frecuencia pago.
	 *
	 * @param frecuenciaPago            the frecuenciaPago to set
	 */
	public void setFrecuenciaPago(String frecuenciaPago) {
		this.frecuenciaPago = frecuenciaPago;
	}

	/**
	 * Obtiene descripcion frecuencia.
	 *
	 * @return the descripcionFrecuencia
	 */
	public String getDescripcionFrecuencia() {
		return descripcionFrecuencia;
	}

	/**
	 * Establece descripcion frecuencia.
	 *
	 * @param descripcionFrecuencia            the descripcionFrecuencia to set
	 */
	public void setDescripcionFrecuencia(String descripcionFrecuencia) {
		this.descripcionFrecuencia = descripcionFrecuencia;
	}

	/**
	 * Obtiene direccion.
	 *
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * Establece direccion.
	 *
	 * @param direccion            the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * Obtiene direccion empleo.
	 *
	 * @return the direccionEmpleo
	 */
	public String getDireccionEmpleo() {
		return direccionEmpleo;
	}

	/**
	 * Establece direccion empleo.
	 *
	 * @param direccionEmpleo            the direccionEmpleo to set
	 */
	public void setDireccionEmpleo(String direccionEmpleo) {
		this.direccionEmpleo = direccionEmpleo;
	}

	/**
	 * Obtiene dias atraso.
	 *
	 * @return the diasAtraso
	 */
	public Integer getDiasAtraso() {
		return diasAtraso;
	}

	/**
	 * Establece dias atraso.
	 *
	 * @param diasAtraso            the diasAtraso to set
	 */
	public void setDiasAtraso(Integer diasAtraso) {
		this.diasAtraso = diasAtraso;
	}

	/**
	 * Obtiene tipo producto.
	 *
	 * @return the tipoProducto
	 */
	public String getTipoProducto() {
		return tipoProducto;
	}

	/**
	 * Establece tipo producto.
	 *
	 * @param tipoProducto            the tipoProducto to set
	 */
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	/**
	 * Obtiene afiliacion servicio.
	 *
	 * @return the afiliacionServicio
	 */
	public String getAfiliacionServicio() {
		return afiliacionServicio;
	}

	/**
	 * Establece afiliacion servicio.
	 *
	 * @param afiliacionServicio            the afiliacionServicio to set
	 */
	public void setAfiliacionServicio(String afiliacionServicio) {
		this.afiliacionServicio = afiliacionServicio;
	}

	/**
	 * Obtiene producto.
	 *
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * Establece producto.
	 *
	 * @param producto            the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

	/**
	 * Obtiene descripcion producto.
	 *
	 * @return the descripcionProducto
	 */
	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	/**
	 * Establece descripcion producto.
	 *
	 * @param descripcionProducto            the descripcionProducto to set
	 */
	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}

	/**
	 * Obtiene categoria producto.
	 *
	 * @return the categoriaProducto
	 */
	public String getCategoriaProducto() {
		return categoriaProducto;
	}

	/**
	 * Establece categoria producto.
	 *
	 * @param categoriaProducto            the categoriaProducto to set
	 */
	public void setCategoriaProducto(String categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
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
	 * @param insoluto            the insoluto to set
	 */
	public void setInsoluto(Double insoluto) {
		this.insoluto = insoluto;
	}

	/**
	 * Obtiene cobranza.
	 *
	 * @return the cobranza
	 */
	public String getCobranza() {
		return cobranza;
	}

	/**
	 * Establece cobranza.
	 *
	 * @param cobranza            the cobranza to set
	 */
	public void setCobranza(String cobranza) {
		this.cobranza = cobranza;
	}
	
	/**
	 * @return the numPagoActual
	 */
	public String getNumPagoActual() {
		return numPagoActual;
	}

	/**
	 * @param numPagoActual the numPagoActual to set
	 */
	public void setNumPagoActual(String numPagoActual) {
		this.numPagoActual = numPagoActual;
	}

}
