package utilitario.mensajes.consultas;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class DatosCreditoOV.
 *
 * @author out_oarias
 */
public class DatosCreditoOV extends ObjetoValor {

	/**
	 * DatosCreditoOV.
	 */
	public DatosCreditoOV() {

	}

	/** long serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** String numeroCredito. */
	private String numeroCredito;

	/** String numContrato. */
	private String	numContrato;

	/** String nombreGrupo. */
	private String nombreGrupo;

	/** String numeroGrupo. */
	private String numeroGrupo;

	/** String nombreSucursal. */
	private String nombreSucursal;

	/** Integer numeroSucursal. */
	private Integer numeroSucursal;

	/** Double montoCredito. */
	private Double montoCredito;

	/** Date fechaInicio. */
	private Date fechaInicio;

	/** Date fechaFin. */
	private Date fechaFin;
	/**
	 * java.util.Date fechaAncla
	 */
	private java.util.Date 		fechaAncla; //Fecha para el calcular el dia de pago
	/**
	 * java.lang.Integer diaPago
	 */
	private java.lang.Integer	diaPago;   //Dia de pago del 1 - 5

	/** Integer plazo. */
	private Integer plazo; //numero total de parcialidades

	/** Double tasa. */
	private Double tasa;

	/** String status. */
	private String status;

	/** Integer ultimoPago. */
	private Integer ultimoPago;
	/**
	 * java.lang.Integer asesor
	 */
	private java.lang.Integer 	asesor;			//Clave del asesor asignado
	/**
	 * java.lang.String diaReunion
	 */
	private java.lang.String 	diaReunion;		//Dias para la reunion
	/**
	 * java.lang.String horaReunion
	 */
	private java.lang.String 	horaReunion;	//
	/**
	 * java.util.Date fechaProxPago
	 */
	private java.util.Date 		fechaProxPago;	//Fecha del proximo pago
	/**
	 * java.lang.Long diasMora
	 */
	private java.lang.Long	 	diasMora;		//Dias que llevan de atraso
	/**
	 * java.lang.String frecuenciaPago
	 */
	private java.lang.String 	frecuenciaPago;	//Periodo de pago
	/**
	 * java.lang.Double saldoMora
	 */
	private java.lang.Double 	saldoMora;		//Cuanto debe de mora
	/**
	 * java.lang.String saldoTotal
	 */
	private java.lang.String 	saldoTotal;		//Saldo para terminar
	/**
	 * java.lang.String saldoCorriente
	 */
	private java.lang.String 	saldoCorriente;	//Saldo para ponerse al dia
	/**
	 * java.lang.Double montoPagoAtrasado
	 */
	private java.lang.Double	montoPagoAtrasado;	//
	/**
	 * java.lang.Double montoCorriente
	 */
	private java.lang.Double	montoCorriente;		//
	/**
	 * java.lang.Double saldoLiquidar
	 */
	private java.lang.Double	saldoLiquidar;		//
	/**
	 * java.lang.String nombreAsesor
	 */
	private java.lang.String	nombreAsesor;	//Nombre del asesor, la fuente del dato es oracle
	/**
	 * java.lang.Integer cicloGrupo
	 */
	private java.lang.Integer	cicloGrupo;		//Cantidad de ciclos en el grupo
	/**
	 * java.lang.String producto
	 */
	private java.lang.String    producto;		//Clave del producto
	/**
	 * java.lang.Double montoFinanciado
	 */
	private java.lang.Double	montoFinanciado;
	//se coloca el monto que se financio en caso de ser una renovacion financiada
	/**
	 * java.lang.Double parcialidad
	 */
	private java.lang.Double	parcialidad;
	/**
	 * java.lang.Integer pagosVencidos
	 */
	private java.lang.Integer 	pagosVencidos; //Numero de pagos vencidos, sale de la tabla de contratos

	/** String montoGarantia. */
	private String montoGarantia;

	/** String horaReunionFin. */
	private String horaReunionFin;

	/** String numeroClienteReunion. */
	private String numeroClienteReunion;

	/** String nombreClienteReunion. */
	private String nombreClienteReunion;

	/**
	 * java.lang.Double montoSeguro
	 */
	private java.lang.Double montoSeguro;

	/**
	 * java.lang.Double montoSeguro
	 */
	private java.lang.Double montoSeguroEnfermedad;

	/** The fecha prim venc. */
	private Date fechaPrimVenc;

	/** The pct dep gar. */
	private Double pctGarantia;

	/** The opc dep gar. */
	private String traspasoGarantia;

	/** The saldo garantia. */
	private String saldoGarantia;

	/** String montoGarantiaLetra. */
	private String saldoGarLet;

	/** String montoGarantiaLetra. */
	private String productoDesc;

	/** String montoGarantiaLetra. */
	private String statusDesc;

	/** The opcion garantia. */
	private String opcionGarantia;

	/** The garabtia traspasada. */
	private Double garantiaTraspasada;

	/** The garantia a depositar. */
	private Double garantiaADepositar;

	/** The solicitud. */
	private String solicitud;

	/** The monto credito formato. */
	private String montoCreditoFormato;

	/** The parcialidad formato. */
	private String parcialidadFormato;

	/** The fecha inicio formato. */
	private String fechaInicioFormato;
	/**campana de la solictud*/
	private String campana;
	/** The  montoSinSeguro */
	private Double montoSinSeguro;

	/**
	 * Obtiene status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Establece status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Obtiene numero credito.
	 *
	 * @return the numeroCredito
	 */
	public String getNumeroCredito() {
		return numeroCredito;
	}

	/**
	 * Establece numero credito.
	 *
	 * @param numeroCredito the numeroCredito to set
	 */
	public void setNumeroCredito(String numeroCredito) {
		this.numeroCredito = numeroCredito;
	}

	/**
	 * Obtiene nombre grupo.
	 *
	 * @return the nombreGrupo
	 */
	public String getNombreGrupo() {
		return nombreGrupo;
	}

	/**
	 * Establece nombre grupo.
	 *
	 * @param nombreGrupo the nombreGrupo to set
	 */
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	/**
	 * Obtiene numero grupo.
	 *
	 * @return the numeroGrupo
	 */
	public String getNumeroGrupo() {
		return numeroGrupo;
	}

	/**
	 * Establece numero grupo.
	 *
	 * @param numeroGrupo the numeroGrupo to set
	 */
	public void setNumeroGrupo(String numeroGrupo) {
		this.numeroGrupo = numeroGrupo;
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
	 * Obtiene numero sucursal.
	 *
	 * @return the numeroSucursal
	 */
	public Integer getNumeroSucursal() {
		return numeroSucursal;
	}

	/**
	 * Establece numero sucursal.
	 *
	 * @param numeroSucursal the numeroSucursal to set
	 */
	public void setNumeroSucursal(Integer numeroSucursal) {
		this.numeroSucursal = numeroSucursal;
	}

	/**
	 * Obtiene monto credito.
	 *
	 * @return the montoCredito
	 */
	public Double getMontoCredito() {
		return montoCredito;
	}

	/**
	 * Establece monto credito.
	 *
	 * @param montoCredito the montoCredito to set
	 */
	public void setMontoCredito(Double montoCredito) {
		this.montoCredito = montoCredito;
	}

	/**
	 * Obtiene fecha inicio.
	 *
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Establece fecha inicio.
	 *
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Obtiene fecha fin.
	 *
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * Establece fecha fin.
	 *
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Obtiene fecha ancla.
	 *
	 * @return the fechaAncla
	 */
	public java.util.Date getFechaAncla() {
		return fechaAncla;
	}

	/**
	 * Establece fecha ancla.
	 *
	 * @param fechaAncla the fechaAncla to set
	 */
	public void setFechaAncla(java.util.Date fechaAncla) {
		this.fechaAncla = fechaAncla;
	}

	/**
	 * Obtiene dia pago.
	 *
	 * @return the diaPago
	 */
	public java.lang.Integer getDiaPago() {
		return diaPago;
	}

	/**
	 * Establece dia pago.
	 *
	 * @param diaPago the diaPago to set
	 */
	public void setDiaPago(java.lang.Integer diaPago) {
		this.diaPago = diaPago;
	}

	/**
	 * Obtiene plazo.
	 *
	 * @return the plazo
	 */
	public Integer getPlazo() {
		return plazo;
	}

	/**
	 * Establece plazo.
	 *
	 * @param plazo the plazo to set
	 */
	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}

	/**
	 * Obtiene tasa.
	 *
	 * @return the tasa
	 */
	public Double getTasa() {
		return tasa;
	}

	/**
	 * Establece tasa.
	 *
	 * @param tasa the tasa to set
	 */
	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}

	/**
	 * Obtiene ultimo pago.
	 *
	 * @return the ultimoPago
	 */
	public Integer getUltimoPago() {
		return ultimoPago;
	}

	/**
	 * Establece ultimo pago.
	 *
	 * @param ultimoPago the ultimoPago to set
	 */
	public void setUltimoPago(Integer ultimoPago) {
		this.ultimoPago = ultimoPago;
	}

	/**
	 * Obtiene asesor.
	 *
	 * @return the asesor
	 */
	public java.lang.Integer getAsesor() {
		return asesor;
	}

	/**
	 * Establece asesor.
	 *
	 * @param asesor the asesor to set
	 */
	public void setAsesor(java.lang.Integer asesor) {
		this.asesor = asesor;
	}

	/**
	 * Obtiene dia reunion.
	 *
	 * @return the diaReunion
	 */
	public java.lang.String getDiaReunion() {
		return diaReunion;
	}

	/**
	 * Establece dia reunion.
	 *
	 * @param diaReunion the diaReunion to set
	 */
	public void setDiaReunion(java.lang.String diaReunion) {
		this.diaReunion = diaReunion;
	}

	/**
	 * Obtiene hora reunion.
	 *
	 * @return the horaReunion
	 */
	public java.lang.String getHoraReunion() {
		return horaReunion;
	}

	/**
	 * Establece hora reunion.
	 *
	 * @param horaReunion the horaReunion to set
	 */
	public void setHoraReunion(java.lang.String horaReunion) {
		this.horaReunion = horaReunion;
	}

	/**
	 * Obtiene fecha prox pago.
	 *
	 * @return the fechaProxPago
	 */
	public java.util.Date getFechaProxPago() {
		return fechaProxPago;
	}

	/**
	 * Establece fecha prox pago.
	 *
	 * @param fechaProxPago the fechaProxPago to set
	 */
	public void setFechaProxPago(java.util.Date fechaProxPago) {
		this.fechaProxPago = fechaProxPago;
	}

	/**
	 * Obtiene dias mora.
	 *
	 * @return the diasMora
	 */
	public java.lang.Long getDiasMora() {
		return diasMora;
	}

	/**
	 * Establece dias mora.
	 *
	 * @param diasMora the diasMora to set
	 */
	public void setDiasMora(java.lang.Long diasMora) {
		this.diasMora = diasMora;
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
	 * Obtiene saldo mora.
	 *
	 * @return the saldoMora
	 */
	public java.lang.Double getSaldoMora() {
		return saldoMora;
	}

	/**
	 * Establece saldo mora.
	 *
	 * @param saldoMora the saldoMora to set
	 */
	public void setSaldoMora(java.lang.Double saldoMora) {
		this.saldoMora = saldoMora;
	}

	/**
	 * Obtiene saldo total.
	 *
	 * @return the saldoTotal
	 */
	public java.lang.String getSaldoTotal() {
		return saldoTotal;
	}

	/**
	 * Establece saldo total.
	 *
	 * @param saldoTotal the saldoTotal to set
	 */
	public void setSaldoTotal(java.lang.String saldoTotal) {
		this.saldoTotal = saldoTotal;
	}

	/**
	 * Obtiene saldo corriente.
	 *
	 * @return the saldoCorriente
	 */
	public java.lang.String getSaldoCorriente() {
		return saldoCorriente;
	}

	/**
	 * Establece saldo corriente.
	 *
	 * @param saldoCorriente the saldoCorriente to set
	 */
	public void setSaldoCorriente(java.lang.String saldoCorriente) {
		this.saldoCorriente = saldoCorriente;
	}

	/**
	 * Obtiene monto pago atrasado.
	 *
	 * @return the montoPagoAtrasado
	 */
	public java.lang.Double getMontoPagoAtrasado() {
		return montoPagoAtrasado;
	}

	/**
	 * Establece monto pago atrasado.
	 *
	 * @param montoPagoAtrasado the montoPagoAtrasado to set
	 */
	public void setMontoPagoAtrasado(java.lang.Double montoPagoAtrasado) {
		this.montoPagoAtrasado = montoPagoAtrasado;
	}

	/**
	 * Obtiene monto corriente.
	 *
	 * @return the montoCorriente
	 */
	public java.lang.Double getMontoCorriente() {
		return montoCorriente;
	}

	/**
	 * Establece monto corriente.
	 *
	 * @param montoCorriente the montoCorriente to set
	 */
	public void setMontoCorriente(java.lang.Double montoCorriente) {
		this.montoCorriente = montoCorriente;
	}

	/**
	 * Obtiene saldo liquidar.
	 *
	 * @return the saldoLiquidar
	 */
	public java.lang.Double getSaldoLiquidar() {
		return saldoLiquidar;
	}

	/**
	 * Establece saldo liquidar.
	 *
	 * @param saldoLiquidar the saldoLiquidar to set
	 */
	public void setSaldoLiquidar(java.lang.Double saldoLiquidar) {
		this.saldoLiquidar = saldoLiquidar;
	}

	/**
	 * Obtiene nombre asesor.
	 *
	 * @return the nombreAsesor
	 */
	public java.lang.String getNombreAsesor() {
		return nombreAsesor;
	}

	/**
	 * Establece nombre asesor.
	 *
	 * @param nombreAsesor the nombreAsesor to set
	 */
	public void setNombreAsesor(java.lang.String nombreAsesor) {
		this.nombreAsesor = nombreAsesor;
	}

	/**
	 * Obtiene ciclo grupo.
	 *
	 * @return the cicloGrupo
	 */
	public java.lang.Integer getCicloGrupo() {
		return cicloGrupo;
	}

	/**
	 * Establece ciclo grupo.
	 *
	 * @param cicloGrupo the cicloGrupo to set
	 */
	public void setCicloGrupo(java.lang.Integer cicloGrupo) {
		this.cicloGrupo = cicloGrupo;
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
	 * Obtiene monto financiado.
	 *
	 * @return the montoFinanciado
	 */
	public java.lang.Double getMontoFinanciado() {
		return montoFinanciado;
	}

	/**
	 * Establece monto financiado.
	 *
	 * @param montoFinanciado the montoFinanciado to set
	 */
	public void setMontoFinanciado(java.lang.Double montoFinanciado) {
		this.montoFinanciado = montoFinanciado;
	}

	/**
	 * Obtiene parcialidad.
	 *
	 * @return the parcialidad
	 */
	public java.lang.Double getParcialidad() {
		return parcialidad;
	}

	/**
	 * Establece parcialidad.
	 *
	 * @param parcialidad the parcialidad to set
	 */
	public void setParcialidad(java.lang.Double parcialidad) {
		this.parcialidad = parcialidad;
	}

	/**
	 * Obtiene pagos vencidos.
	 *
	 * @return the pagosVencidos
	 */
	public java.lang.Integer getPagosVencidos() {
		return pagosVencidos;
	}

	/**
	 * Establece pagos vencidos.
	 *
	 * @param pagosVencidos the pagosVencidos to set
	 */
	public void setPagosVencidos(java.lang.Integer pagosVencidos) {
		this.pagosVencidos = pagosVencidos;
	}

	/**
	 * Obtiene monto garantia.
	 *
	 * @return the montoGarantia
	 */
	public String getMontoGarantia() {
		return montoGarantia;
	}

	/**
	 * Establece monto garantia.
	 *
	 * @param montoGarantia the montoGarantia to set
	 */
	public void setMontoGarantia(String montoGarantia) {
		this.montoGarantia = montoGarantia;
	}

	/**
	 * Obtiene hora reunion fin.
	 *
	 * @return the horaReunionFin
	 */
	public String getHoraReunionFin() {
		return horaReunionFin;
	}

	/**
	 * Establece hora reunion fin.
	 *
	 * @param horaReunionFin the horaReunionFin to set
	 */
	public void setHoraReunionFin(String horaReunionFin) {
		this.horaReunionFin = horaReunionFin;
	}

	/**
	 * Obtiene numero cliente reunion.
	 *
	 * @return the numeroClienteReunion
	 */
	public String getNumeroClienteReunion() {
		return numeroClienteReunion;
	}

	/**
	 * Establece numero cliente reunion.
	 *
	 * @param numeroClienteReunion the numeroClienteReunion to set
	 */
	public void setNumeroClienteReunion(String numeroClienteReunion) {
		this.numeroClienteReunion = numeroClienteReunion;
	}

	/**
	 * Obtiene nombre cliente reunion.
	 *
	 * @return the nombreClienteReunion
	 */
	public String getNombreClienteReunion() {
		return nombreClienteReunion;
	}

	/**
	 * Establece nombre cliente reunion.
	 *
	 * @param nombreClienteReunion the nombreClienteReunion to set
	 */
	public void setNombreClienteReunion(String nombreClienteReunion) {
		this.nombreClienteReunion = nombreClienteReunion;
	}


	/**
	 * Establece num contrato.
	 *
	 * @param numContrato a num contrato
	 */
	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}

	/**
	 * Obtiene num contrato.
	 *
	 * @return num contrato
	 */
	public String getNumContrato() {
		return numContrato;
	}

	/**
	 * Obtiene monto seguro.
	 *
	 * @return the montoSeguro
	 */
	public java.lang.Double getMontoSeguro() {
		return montoSeguro;
	}

	/**
	 * Establece monto seguro.
	 *
	 * @param montoSeguro the montoSeguro to set
	 */
	public void setMontoSeguro(java.lang.Double montoSeguro) {
		this.montoSeguro = montoSeguro;
	}

	/**
	 * @return the montoSeguroEnfermedad
	 */
	public java.lang.Double getMontoSeguroEnfermedad() {
		return montoSeguroEnfermedad;
	}

	/**
	 * @param montoSeguroEnfermedad the montoSeguroEnfermedad to set
	 */
	public void setMontoSeguroEnfermedad(java.lang.Double montoSeguroEnfermedad) {
		this.montoSeguroEnfermedad = montoSeguroEnfermedad;
	}

	/**
	 * Gets the fecha prim venc.
	 *
	 * @return the fecha prim venc
	 */
	public Date getFechaPrimVenc() {
		return fechaPrimVenc;
	}

	/**
	 * Sets the fecha prim venc.
	 *
	 * @param fechaPrimVenc the new fecha prim venc
	 */
	public void setFechaPrimVenc(Date fechaPrimVenc) {
		this.fechaPrimVenc = fechaPrimVenc;
	}

	/**
	 * Gets the pct garantia.
	 *
	 * @return the pct garantia
	 */
	public Double getPctGarantia() {
		return pctGarantia;
	}

	/**
	 * Sets the pct garantia.
	 *
	 * @param pctGarantia the new pct garantia
	 */
	public void setPctGarantia(Double pctGarantia) {
		this.pctGarantia = pctGarantia;
	}

	/**
	 * Gets the saldo garantia.
	 *
	 * @return the saldo garantia
	 */
	public String getSaldoGarantia() {
		return saldoGarantia;
	}

	/**
	 * Sets the saldo garantia.
	 *
	 * @param saldoGarantia the new saldo garantia
	 */
	public void setSaldoGarantia(String saldoGarantia) {
		this.saldoGarantia = saldoGarantia;
	}

	/**
	 * Gets the saldo gar let.
	 *
	 * @return the saldo gar let
	 */
	public String getSaldoGarLet() {
		return saldoGarLet;
	}

	/**
	 * Sets the saldo gar let.
	 *
	 * @param saldoGarLet the new saldo gar let
	 */
	public void setSaldoGarLet(String saldoGarLet) {
		this.saldoGarLet = saldoGarLet;
	}

	/**
	 * @return the productoDesc
	 */
	public String getProductoDesc() {
		return productoDesc;
	}

	/**
	 * @param productoDesc the productoDesc to set
	 */
	public void setProductoDesc(String productoDesc) {
		this.productoDesc = productoDesc;
	}

	/**
	 * @return the statusDesc
	 */
	public String getStatusDesc() {
		return statusDesc;
	}

	/**
	 * @param statusDesc the statusDesc to set
	 */
	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	/**
	 * @return the traspasoGarantia
	 */
	public String getTraspasoGarantia() {
		return traspasoGarantia;
	}

	/**
	 * @param traspasoGarantia the traspasoGarantia to set
	 */
	public void setTraspasoGarantia(String traspasoGarantia) {
		this.traspasoGarantia = traspasoGarantia;
	}

	/**
	 * @return the opcionGarantia
	 */
	public String getOpcionGarantia() {
		return opcionGarantia;
	}

	/**
	 * @param opcionGarantia the opcionGarantia to set
	 */
	public void setOpcionGarantia(String opcionGarantia) {
		this.opcionGarantia = opcionGarantia;
	}

	/**
	 * @return the garantiaTraspasada
	 */
	public Double getGarantiaTraspasada() {
		return garantiaTraspasada;
	}

	/**
	 * @param garantiaTraspasada the garantiaTraspasada to set
	 */
	public void setGarantiaTraspasada(Double garantiaTraspasada) {
		this.garantiaTraspasada = garantiaTraspasada;
	}

	/**
	 * @return the garantiaADepositar
	 */
	public Double getGarantiaADepositar() {
		return garantiaADepositar;
	}

	/**
	 * @param garantiaADepositar the garantiaADepositar to set
	 */
	public void setGarantiaADepositar(Double garantiaADepositar) {
		this.garantiaADepositar = garantiaADepositar;
	}

	/**
	 * @return the solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}

	/**
	 * @param solicitud the solicitud to set
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	/**
	 * @return the montoCreditoFormato
	 */
	public String getMontoCreditoFormato() {
		return montoCreditoFormato;
	}

	/**
	 * @param montoCreditoFormato the montoCreditoFormato to set
	 */
	public void setMontoCreditoFormato(String montoCreditoFormato) {
		this.montoCreditoFormato = montoCreditoFormato;
	}

	/**
	 * @return the parcialidadFormato
	 */
	public String getParcialidadFormato() {
		return parcialidadFormato;
	}

	/**
	 * @param parcialidadFormato the parcialidadFormato to set
	 */
	public void setParcialidadFormato(String parcialidadFormato) {
		this.parcialidadFormato = parcialidadFormato;
	}

	/**
	 * @return the fechaInicioFormato
	 */
	public String getFechaInicioFormato() {
		return fechaInicioFormato;
	}

	/**
	 * @param fechaInicioFormato the fechaInicioFormato to set
	 */
	public void setFechaInicioFormato(String fechaInicioFormato) {
		this.fechaInicioFormato = fechaInicioFormato;
	}
	/**
	 * @return the campana
	 */
	public String getCampana() {
		return campana;
	}

	/**
	 * @param campana the campana to set
	 */
	public void setCampana(String campana) {
		this.campana = campana;
	}

	/**
	 * @return the montoSinSeguro
	 */
	public Double getMontoSinSeguro() {
		return montoSinSeguro;
	}

	/**
	 * @param montoSinSeguro the montoSinSeguro to set
	 */
	public void setMontoSinSeguro(Double montoSinSeguro) {
		this.montoSinSeguro = montoSinSeguro;
	}

}
