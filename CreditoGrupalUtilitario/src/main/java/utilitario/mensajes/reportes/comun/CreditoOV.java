package utilitario.mensajes.reportes.comun;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class CreditoOV.
 */
public class CreditoOV extends ObjetoValor {

	/**
	 * CreditoOV
	 */
	public CreditoOV() {

	}
	/**
	 * long serialVersionUID
	 */
	private static final long serialVersionUID = 692239848901696894L;

	/**
	 * Integer codigo
	 */
	private Integer codigo;
	/**
	 * Integer ciclo
	 */
	private Integer ciclo;
	/**
	 * String mensaje
	 */
	private String mensaje;
	/**
	 * String cliente
	 */
	private String cliente;
	/**
	 * Date fechaContrato
	 */
	private Date fechaContrato;
	/**
	 * Date fechaHoy
	 */
	private Date fechaHoy;
	/**
	 * Double montoTotal
	 */
	private Double montoTotal;
	/**
	 * Double montoPago
	 */
	private Double montoPago;
	/**
	 * Integer numeroPagos
	 */
	private Integer numeroPagos;
	/**
	 * String frecuenciaPago
	 */
	private String frecuenciaPago;
	/**
	 * Double tasa
	 */
	private Double tasa;
	/**
	 * String producto
	 */
	private String producto;
	/**
	 * Integer retrasoMaximo
	 */
	private Integer retrasoMaximo;
	/**
	 * Double saldo
	 */
	private Double saldo;
	/**
	 * Date fechaUltimoCorte
	 */
	private Date fechaUltimoCorte;
	/**
	 * Date fechaProximoPago
	 */
	private Date fechaProximoPago;
	/**
	 * Integer numeroUltimoPago
	 */
	private Integer numeroUltimoPago;
	/**
	 * String estado
	 */
	private String estado;
	/**
	 * Double limiteCredito
	 */
	private Double limiteCredito;
	/**
	 * Double montoDisponible
	 */
	private Double montoDisponible;
	/**
	 * Double tasaMoratoriaAnual
	 */
	private Double tasaMoratoriaAnual;
	/**
	 * Integer pagosPendientes
	 */
	private Integer pagosPendientes;
	/**
	 * Date fechaTresMesesAtras
	 */
	private Date fechaTresMesesAtras;
	/**
	 * String descripcionProducto
	 */
	private String descripcionProducto;
	/**
	 * String calculoInteres
	 */
	private String calculoInteres;
	/**
	 * Double costoAnualTotal
	 */
	private Double costoAnualTotal;
	/**
	 * String tipoProducto
	 */
	private String tipoProducto;
	/**
	 * Integer sucursal
	 */
	private Integer sucursal;
	/**
	 * Double montoDevuelto
	 */
	private Double montoDevuelto;
	/**
	 * Double montoReal
	 */
	private Double montoReal;
	/**
	 * Date fechaFin
	 */
	private Date fechaFin;
	/**
	 * Integer diaPago
	 */
	private Integer diaPago;
	/**
	 * Double comision
	 */
	private Double comision;
	/**
	 * Double tasa ordinaria mensual
	 */
	private Double tasaOrdinariaMensual;
	/**
	 * Double interes ordinario
	 */
	private Double interesOrdinario;
	/**
	 * Integer Numero de devoluciones
	 */
	private Integer numeroDevoluciones;
	/**
	 * Double nuevo interes ordinario
	 */
	private Double nuevoInteresOrdinario;
	/**
	 * Double Ajuste interes
	 */
	private Double ajusteInteres;
	/**
	 * Double nuevo total a pagar
	 */
	private Double nuevoTotalPagar;
	/**
	 * Double total a pagar
	 */
	private Double totalPagar;
	/**
	 * Double deposito garantia
	 */
	private Double depositoGarantia;
	/**
	 * @return the codigo
	 */
	public Integer getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the ciclo
	 */
	public Integer getCiclo() {
		return ciclo;
	}
	/**
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
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
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return the fechaContrato
	 */
	public Date getFechaContrato() {
		return fechaContrato;
	}
	/**
	 * @param fechaContrato the fechaContrato to set
	 */
	public void setFechaContrato(Date fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
	/**
	 * @return the fechaHoy
	 */
	public Date getFechaHoy() {
		return fechaHoy;
	}
	/**
	 * @param fechaHoy the fechaHoy to set
	 */
	public void setFechaHoy(Date fechaHoy) {
		this.fechaHoy = fechaHoy;
	}
	/**
	 * @return the montoTotal
	 */
	public Double getMontoTotal() {
		return montoTotal;
	}
	/**
	 * @param montoTotal the montoTotal to set
	 */
	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}
	/**
	 * @return the montoPago
	 */
	public Double getMontoPago() {
		return montoPago;
	}
	/**
	 * @param montoPago the montoPago to set
	 */
	public void setMontoPago(Double montoPago) {
		this.montoPago = montoPago;
	}
	/**
	 * @return the numeroPagos
	 */
	public Integer getNumeroPagos() {
		return numeroPagos;
	}
	/**
	 * @param numeroPagos the numeroPagos to set
	 */
	public void setNumeroPagos(Integer numeroPagos) {
		this.numeroPagos = numeroPagos;
	}
	/**
	 * @return the frecuenciaPago
	 */
	public String getFrecuenciaPago() {
		return frecuenciaPago;
	}
	/**
	 * @param frecuenciaPago the frecuenciaPago to set
	 */
	public void setFrecuenciaPago(String frecuenciaPago) {
		this.frecuenciaPago = frecuenciaPago;
	}
	/**
	 * @return the tasa
	 */
	public Double getTasa() {
		return tasa;
	}
	/**
	 * @param tasa the tasa to set
	 */
	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}
	/**
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}
	/**
	 * @return the retrasoMaximo
	 */
	public Integer getRetrasoMaximo() {
		return retrasoMaximo;
	}
	/**
	 * @param retrasoMaximo the retrasoMaximo to set
	 */
	public void setRetrasoMaximo(Integer retrasoMaximo) {
		this.retrasoMaximo = retrasoMaximo;
	}
	/**
	 * @return the saldo
	 */
	public Double getSaldo() {
		return saldo;
	}
	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}
	/**
	 * @return the fechaUltimoCorte
	 */
	public Date getFechaUltimoCorte() {
		return fechaUltimoCorte;
	}
	/**
	 * @param fechaUltimoCorte the fechaUltimoCorte to set
	 */
	public void setFechaUltimoCorte(Date fechaUltimoCorte) {
		this.fechaUltimoCorte = fechaUltimoCorte;
	}
	/**
	 * @return the fechaProximoPago
	 */
	public Date getFechaProximoPago() {
		return fechaProximoPago;
	}
	/**
	 * @param fechaProximoPago the fechaProximoPago to set
	 */
	public void setFechaProximoPago(Date fechaProximoPago) {
		this.fechaProximoPago = fechaProximoPago;
	}
	/**
	 * @return the numeroUltimoPago
	 */
	public Integer getNumeroUltimoPago() {
		return numeroUltimoPago;
	}
	/**
	 * @param numeroUltimoPago the numeroUltimoPago to set
	 */
	public void setNumeroUltimoPago(Integer numeroUltimoPago) {
		this.numeroUltimoPago = numeroUltimoPago;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return the limiteCredito
	 */
	public Double getLimiteCredito() {
		return limiteCredito;
	}
	/**
	 * @param limiteCredito the limiteCredito to set
	 */
	public void setLimiteCredito(Double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}
	/**
	 * @return the montoDisponible
	 */
	public Double getMontoDisponible() {
		return montoDisponible;
	}
	/**
	 * @param montoDisponible the montoDisponible to set
	 */
	public void setMontoDisponible(Double montoDisponible) {
		this.montoDisponible = montoDisponible;
	}
	/**
	 * @return the tasaMoratoriaAnual
	 */
	public Double getTasaMoratoriaAnual() {
		return tasaMoratoriaAnual;
	}
	/**
	 * @param tasaMoratoriaAnual the tasaMoratoriaAnual to set
	 */
	public void setTasaMoratoriaAnual(Double tasaMoratoriaAnual) {
		this.tasaMoratoriaAnual = tasaMoratoriaAnual;
	}
	/**
	 * @return the pagosPendientes
	 */
	public Integer getPagosPendientes() {
		return pagosPendientes;
	}
	/**
	 * @param pagosPendientes the pagosPendientes to set
	 */
	public void setPagosPendientes(Integer pagosPendientes) {
		this.pagosPendientes = pagosPendientes;
	}
	/**
	 * @return the fechaTresMesesAtras
	 */
	public Date getFechaTresMesesAtras() {
		return fechaTresMesesAtras;
	}
	/**
	 * @param fechaTresMesesAtras the fechaTresMesesAtras to set
	 */
	public void setFechaTresMesesAtras(Date fechaTresMesesAtras) {
		this.fechaTresMesesAtras = fechaTresMesesAtras;
	}
	/**
	 * @return the descripcionProducto
	 */
	public String getDescripcionProducto() {
		return descripcionProducto;
	}
	/**
	 * @param descripcionProducto the descripcionProducto to set
	 */
	public void setDescripcionProducto(String descripcionProducto) {
		this.descripcionProducto = descripcionProducto;
	}
	/**
	 * @return the calculoInteres
	 */
	public String getCalculoInteres() {
		return calculoInteres;
	}
	/**
	 * @param calculoInteres the calculoInteres to set
	 */
	public void setCalculoInteres(String calculoInteres) {
		this.calculoInteres = calculoInteres;
	}
	/**
	 * @return the costoAnualTotal
	 */
	public Double getCostoAnualTotal() {
		return costoAnualTotal;
	}
	/**
	 * @param costoAnualTotal the costoAnualTotal to set
	 */
	public void setCostoAnualTotal(Double costoAnualTotal) {
		this.costoAnualTotal = costoAnualTotal;
	}
	/**
	 * @return the tipoProducto
	 */
	public String getTipoProducto() {
		return tipoProducto;
	}
	/**
	 * @param tipoProducto the tipoProducto to set
	 */
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	/**
	 * @return the sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}
	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}
	/**
	 * @return the montoDevuelto
	 */
	public Double getMontoDevuelto() {
		return montoDevuelto;
	}
	/**
	 * @param montoDevuelto the montoDevuelto to set
	 */
	public void setMontoDevuelto(Double montoDevuelto) {
		this.montoDevuelto = montoDevuelto;
	}
	/**
	 * @return the montoReal
	 */
	public Double getMontoReal() {
		return montoReal;
	}
	/**
	 * @param montoReal the montoReal to set
	 */
	public void setMontoReal(Double montoReal) {
		this.montoReal = montoReal;
	}
	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}
	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	/**
	 * @return the diaPago
	 */
	public Integer getDiaPago() {
		return diaPago;
	}
	/**
	 * @param diaPago the diaPago to set
	 */
	public void setDiaPago(Integer diaPago) {
		this.diaPago = diaPago;
	}
	/**
	 * @return the comision
	 */
	public Double getComision() {
		return comision;
	}
	/**
	 * @param comision the comision to set
	 */
	public void setComision(Double comision) {
		this.comision = comision;
	}
	/**
	 * @return the tasaOrdinariaMensual
	 */
	public Double getTasaOrdinariaMensual() {
		return tasaOrdinariaMensual;
	}
	/**
	 * @param tasaOrdinariaMensual the tasaOrdinariaMensual to set
	 */
	public void setTasaOrdinariaMensual(Double tasaOrdinariaMensual) {
		this.tasaOrdinariaMensual = tasaOrdinariaMensual;
	}
	/**
	 * @return the interesOrdinario
	 */
	public Double getInteresOrdinario() {
		return interesOrdinario;
	}
	/**
	 * @param interesOrdinario the interesOrdinario to set
	 */
	public void setInteresOrdinario(Double interesOrdinario) {
		this.interesOrdinario = interesOrdinario;
	}
	/**
	 * @return the nuevoInteresOrdinario
	 */
	public Double getNuevoInteresOrdinario() {
		return nuevoInteresOrdinario;
	}
	/**
	 * @param nuevoInteresOrdinario the nuevoInteresOrdinario to set
	 */
	public void setNuevoInteresOrdinario(Double nuevoInteresOrdinario) {
		this.nuevoInteresOrdinario = nuevoInteresOrdinario;
	}
	/**
	 * @return the nuevoTotalPagar
	 */
	public Double getNuevoTotalPagar() {
		return nuevoTotalPagar;
	}
	/**
	 * @param nuevoTotalPagar the nuevoTotalPagar to set
	 */
	public void setNuevoTotalPagar(Double nuevoTotalPagar) {
		this.nuevoTotalPagar = nuevoTotalPagar;
	}
	/**
	 * @return the depositoGarantia
	 */
	public Double getDepositoGarantia() {
		return depositoGarantia;
	}
	/**
	 * @param depositoGarantia the depositoGarantia to set
	 */
	public void setDepositoGarantia(Double depositoGarantia) {
		this.depositoGarantia = depositoGarantia;
	}
	/**
	 * @return the numeroDevoluciones
	 */
	public Integer getNumeroDevoluciones() {
		return numeroDevoluciones;
	}
	/**
	 * @param numeroDevoluciones the numeroDevoluciones to set
	 */
	public void setNumeroDevoluciones(Integer numeroDevoluciones) {
		this.numeroDevoluciones = numeroDevoluciones;
	}
	/**
	 * @return the totalPagar
	 */
	public Double getTotalPagar() {
		return totalPagar;
	}
	/**
	 * @param totalPagar the totalPagar to set
	 */
	public void setTotalPagar(Double totalPagar) {
		this.totalPagar = totalPagar;
	}
	/**
	 * @return the ajusteInteres
	 */
	public Double getAjusteInteres() {
		return ajusteInteres;
	}
	/**
	 * @param ajusteInteres the ajusteInteres to set
	 */
	public void setAjusteInteres(Double ajusteInteres) {
		this.ajusteInteres = ajusteInteres;
	}


}
