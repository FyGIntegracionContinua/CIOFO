
package utilitario.mensajes.operacion.pagos;

import java.util.Date;


/**
 * The Class EntContrato.
 */
public class EntContrato {

	/**
	 * Instancia una nueva ent contrato.
	 */
	public EntContrato() { }
    /** The nombre cliente. */
    protected String nombreCliente;

    /** The monto capital insoluto. */
    protected double montoCapitalInsoluto;

    /** The monto disponible. */
    protected double montoDisponible;

    /** The cantidad pagos atrasados. */
    protected int cantidadPagosAtrasados;

    /** The numero ultimo pago. */
    protected int numeroUltimoPago;

    /** The es pagado parcialmente. */
    protected boolean esPagadoParcialmente;

    /** The monto a cubrir. */
    protected double montoACubrir;

    /** The monto pagos atrasados. */
    protected double montoPagosAtrasados;

    /** The monto pagos al corriente. */
    protected double montoPagosAlCorriente;

    /** The monto liquidacion. */
    protected double montoLiquidacion;

    /** The fecha proximo pago. */
    protected Date fechaProximoPago;

    /** The status. */
    protected String status;

    /** The monto descuento por pago puntual. */
    protected double montoDescuentoPorPagoPuntual;

    /** The numero contrato. */
    protected String numeroContrato;

    /** The numero cliente. */
    protected String numeroCliente;

    /** The antiguedad dias contrato. */
    protected int antiguedadDiasContrato;

    /** The es contrato al corriente. */
    protected boolean esContratoAlCorriente;

    /** The es revolvente. */
    protected boolean esRevolvente;

    /** The tipo producto. */
    protected String tipoProducto;

    /** The tipo disposicion. */
    protected String tipoDisposicion;

    /** The categoria. */
    protected String categoria;

    /** The es finca. */
    protected boolean esFinca;

    /** The es entrega con vale. */
    protected boolean esEntregaConVale;

    /** The es lcr. */
    protected boolean esLcr;

    /** The frecuencia pago. */
    protected String frecuenciaPago;

    /** The tipo devengado. */
    protected String tipoDevengado;

    /** The devolucion. */
    protected String devolucion;

    /** The codigo verificacion cambio fecha proximo pago. */
    protected int codigoVerificacionCambioFechaProximoPago;

    /** The mensaje cambio fecha proximo pago. */
    protected String mensajeCambioFechaProximoPago;

    /** The es debe comision anual. */
    protected boolean esDebeComisionAnual;

    /** The monto comision anual. */
    protected double montoComisionAnual;

    /** The periodos comision anual. */
    protected int periodosComisionAnual;

    /** The fecha proximo aniversario. */
    protected Date fechaProximoAniversario;

    /** The producto. */
    protected String producto;

    /** The maximo retraso. */
    protected int maximoRetraso;

    /** The es proteccion desempleo. */
    protected boolean esProteccionDesempleo;

    /** The es tiene autorizacion conexia. */
    protected boolean esTieneAutorizacionConexia;

    /** The monto minimo autorizacion conexia. */
    protected double montoMinimoAutorizacionConexia;

    /** The fecha autorizacion conexia. */
    protected Date fechaAutorizacionConexia;

    /** The consecutivo autorizacion conexia. */
    protected int consecutivoAutorizacionConexia;

    /** The hora autorizacion conexia. */
    protected Date horaAutorizacionConexia;

    /** The rfc. */
    protected String rfc;

    /** The segmento producto. */
    protected String segmentoProducto;

    /** The genero cliente. */
    protected String generoCliente;

    /** The monto credito. */
    protected double montoCredito;

    /** The efectivo. */
    protected double efectivo;

    /** The sucursal cartera. */
    protected int sucursalCartera;

    /** The es foraneo. */
    protected boolean esForaneo;

    /** The monto bonificacion autorizacion conexia. */
    protected double montoBonificacionAutorizacionConexia;

    /** The contrato recomienda. */
    protected String contratoRecomienda;

    /** The origen credito. */
    protected String origenCredito;

    /** The es recoleccion. */
    protected boolean esRecoleccion;

    /** The monto pago. */
    protected double montoPago;

    /** The descripcion tipo producto. */
    protected String descripcionTipoProducto;

    /** The es mi comercio. */
    protected boolean esMiComercio;

    /** The clave empresa. */
    protected String claveEmpresa;

    /**
     * Gets the value of the nombreCliente property.
     *
     * @return
     *     possible object is
     *
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * Sets the value of the nombreCliente property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setNombreCliente(String value) {
        this.nombreCliente = value;
    }

    /**
     * Gets the value of the montoCapitalInsoluto property.
     *
     * @return monto capital insoluto
     */
    public double getMontoCapitalInsoluto() {
        return montoCapitalInsoluto;
    }

    /**
     * Sets the value of the montoCapitalInsoluto property.
     *
     * @param value a monto capital insoluto
     */
    public void setMontoCapitalInsoluto(double value) {
        this.montoCapitalInsoluto = value;
    }

    /**
     * Gets the value of the montoDisponible property.
     *
     * @return monto disponible
     */
    public double getMontoDisponible() {
        return montoDisponible;
    }

    /**
     * Sets the value of the montoDisponible property.
     *
     * @param value a monto disponible
     */
    public void setMontoDisponible(double value) {
        this.montoDisponible = value;
    }

    /**
     * Gets the value of the cantidadPagosAtrasados property.
     *
     * @return cantidad pagos atrasados
     */
    public int getCantidadPagosAtrasados() {
        return cantidadPagosAtrasados;
    }

    /**
     * Sets the value of the cantidadPagosAtrasados property.
     *
     * @param value a cantidad pagos atrasados
     */
    public void setCantidadPagosAtrasados(int value) {
        this.cantidadPagosAtrasados = value;
    }

    /**
     * Gets the value of the numeroUltimoPago property.
     *
     * @return numero ultimo pago
     */
    public int getNumeroUltimoPago() {
        return numeroUltimoPago;
    }

    /**
     * Sets the value of the numeroUltimoPago property.
     *
     * @param value a numero ultimo pago
     */
    public void setNumeroUltimoPago(int value) {
        this.numeroUltimoPago = value;
    }

    /**
     * Gets the value of the esPagadoParcialmente property.
     *
     * @return true, if is es pagado parcialmente
     */
    public boolean isEsPagadoParcialmente() {
        return esPagadoParcialmente;
    }

    /**
     * Sets the value of the esPagadoParcialmente property.
     *
     * @param value a es pagado parcialmente
     */
    public void setEsPagadoParcialmente(boolean value) {
        this.esPagadoParcialmente = value;
    }

    /**
     * Gets the value of the montoACubrir property.
     *
     * @return monto a cubrir
     */
    public double getMontoACubrir() {
        return montoACubrir;
    }

    /**
     * Sets the value of the montoACubrir property.
     *
     * @param value a monto a cubrir
     */
    public void setMontoACubrir(double value) {
        this.montoACubrir = value;
    }

    /**
     * Gets the value of the montoPagosAtrasados property.
     *
     * @return monto pagos atrasados
     */
    public double getMontoPagosAtrasados() {
        return montoPagosAtrasados;
    }

    /**
     * Sets the value of the montoPagosAtrasados property.
     *
     * @param value a monto pagos atrasados
     */
    public void setMontoPagosAtrasados(double value) {
        this.montoPagosAtrasados = value;
    }

    /**
     * Gets the value of the montoPagosAlCorriente property.
     *
     * @return monto pagos al corriente
     */
    public double getMontoPagosAlCorriente() {
        return montoPagosAlCorriente;
    }

    /**
     * Sets the value of the montoPagosAlCorriente property.
     *
     * @param value a monto pagos al corriente
     */
    public void setMontoPagosAlCorriente(double value) {
        this.montoPagosAlCorriente = value;
    }

    /**
     * Gets the value of the montoLiquidacion property.
     *
     * @return monto liquidacion
     */
    public double getMontoLiquidacion() {
        return montoLiquidacion;
    }

    /**
     * Sets the value of the montoLiquidacion property.
     *
     * @param value a monto liquidacion
     */
    public void setMontoLiquidacion(double value) {
        this.montoLiquidacion = value;
    }

    /**
     * Gets the value of the fechaProximoPago property.
     *
     * @return
     *     possible object is
     *
     */
    public Date getFechaProximoPago() {
        return fechaProximoPago;
    }

    /**
     * Sets the value of the fechaProximoPago property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setFechaProximoPago(Date value) {
        this.fechaProximoPago = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return
     *     possible object is
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the montoDescuentoPorPagoPuntual property.
     *
     * @return monto descuento por pago puntual
     */
    public double getMontoDescuentoPorPagoPuntual() {
        return montoDescuentoPorPagoPuntual;
    }

    /**
     * Sets the value of the montoDescuentoPorPagoPuntual property.
     *
     * @param value a monto descuento por pago puntual
     */
    public void setMontoDescuentoPorPagoPuntual(double value) {
        this.montoDescuentoPorPagoPuntual = value;
    }

    /**
     * Gets the value of the numeroContrato property.
     *
     * @return
     *     possible object is
     *
     */
    public String getNumeroContrato() {
        return numeroContrato;
    }

    /**
     * Sets the value of the numeroContrato property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setNumeroContrato(String value) {
        this.numeroContrato = value;
    }

    /**
     * Gets the value of the numeroCliente property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNumeroCliente() {
        return numeroCliente;
    }

    /**
     * Sets the value of the numeroCliente property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setNumeroCliente(String value) {
        this.numeroCliente = value;
    }

    /**
     * Gets the value of the antiguedadDiasContrato property.
     *
     * @return antiguedad dias contrato
     */
    public int getAntiguedadDiasContrato() {
        return antiguedadDiasContrato;
    }

    /**
     * Sets the value of the antiguedadDiasContrato property.
     *
     * @param value a antiguedad dias contrato
     */
    public void setAntiguedadDiasContrato(int value) {
        this.antiguedadDiasContrato = value;
    }

    /**
     * Gets the value of the esContratoAlCorriente property.
     *
     * @return true, if is es contrato al corriente
     */
    public boolean isEsContratoAlCorriente() {
        return esContratoAlCorriente;
    }

    /**
     * Sets the value of the esContratoAlCorriente property.
     *
     * @param value a es contrato al corriente
     */
    public void setEsContratoAlCorriente(boolean value) {
        this.esContratoAlCorriente = value;
    }

    /**
     * Gets the value of the esRevolvente property.
     *
     * @return true, if is es revolvente
     */
    public boolean isEsRevolvente() {
        return esRevolvente;
    }

    /**
     * Sets the value of the esRevolvente property.
     *
     * @param value a es revolvente
     */
    public void setEsRevolvente(boolean value) {
        this.esRevolvente = value;
    }

    /**
     * Gets the value of the tipoProducto property.
     *
     * @return
     *     possible object is
     *
     */
    public String getTipoProducto() {
        return tipoProducto;
    }

    /**
     * Sets the value of the tipoProducto property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setTipoProducto(String value) {
        this.tipoProducto = value;
    }

    /**
     * Gets the value of the tipoDisposicion property.
     *
     * @return
     *     possible object is
     *
     */
    public String getTipoDisposicion() {
        return tipoDisposicion;
    }

    /**
     * Sets the value of the tipoDisposicion property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setTipoDisposicion(String value) {
        this.tipoDisposicion = value;
    }

    /**
     * Gets the value of the categoria property.
     *
     * @return
     *     possible object is
     *
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Sets the value of the categoria property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setCategoria(String value) {
        this.categoria = value;
    }

    /**
     * Gets the value of the esFinca property.
     *
     * @return true, if is es finca
     */
    public boolean isEsFinca() {
        return esFinca;
    }

    /**
     * Sets the value of the esFinca property.
     *
     * @param value a es finca
     */
    public void setEsFinca(boolean value) {
        this.esFinca = value;
    }

    /**
     * Gets the value of the esEntregaConVale property.
     *
     * @return true, if is es entrega con vale
     */
    public boolean isEsEntregaConVale() {
        return esEntregaConVale;
    }

    /**
     * Sets the value of the esEntregaConVale property.
     *
     * @param value a es entrega con vale
     */
    public void setEsEntregaConVale(boolean value) {
        this.esEntregaConVale = value;
    }

    /**
     * Gets the value of the esLcr property.
     *
     * @return true, if is es lcr
     */
    public boolean isEsLcr() {
        return esLcr;
    }

    /**
     * Sets the value of the esLcr property.
     *
     * @param value a es lcr
     */
    public void setEsLcr(boolean value) {
        this.esLcr = value;
    }

    /**
     * Gets the value of the frecuenciaPago property.
     *
     * @return
     *     possible object is
     *
     */
    public String getFrecuenciaPago() {
        return frecuenciaPago;
    }

    /**
     * Sets the value of the frecuenciaPago property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setFrecuenciaPago(String value) {
        this.frecuenciaPago = value;
    }

    /**
     * Gets the value of the tipoDevengado property.
     *
     * @return
     *     possible object is
     *
     */
    public String getTipoDevengado() {
        return tipoDevengado;
    }

    /**
     * Sets the value of the tipoDevengado property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setTipoDevengado(String value) {
        this.tipoDevengado = value;
    }

    /**
     * Gets the value of the devolucion property.
     *
     * @return
     *     possible object is
     *
     */
    public String getDevolucion() {
        return devolucion;
    }

    /**
     * Sets the value of the devolucion property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setDevolucion(String value) {
        this.devolucion = value;
    }

    /**
     * Gets the value of the codigoVerificacionCambioFechaProximoPago property.
     *
     * @return codigo verificacion cambio fecha proximo pago
     */
    public int getCodigoVerificacionCambioFechaProximoPago() {
        return codigoVerificacionCambioFechaProximoPago;
    }

    /**
     * Sets the value of the codigoVerificacionCambioFechaProximoPago property.
     *
     * @param value a codigo verificacion cambio fecha proximo pago
     */
    public void setCodigoVerificacionCambioFechaProximoPago(int value) {
        this.codigoVerificacionCambioFechaProximoPago = value;
    }

    /**
     * Gets the value of the mensajeCambioFechaProximoPago property.
     *
     * @return
     *     possible object is
     *
     */
    public String getMensajeCambioFechaProximoPago() {
        return mensajeCambioFechaProximoPago;
    }

    /**
     * Sets the value of the mensajeCambioFechaProximoPago property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setMensajeCambioFechaProximoPago(String value) {
        this.mensajeCambioFechaProximoPago = value;
    }

    /**
     * Gets the value of the esDebeComisionAnual property.
     *
     * @return true, if is es debe comision anual
     */
    public boolean isEsDebeComisionAnual() {
        return esDebeComisionAnual;
    }

    /**
     * Sets the value of the esDebeComisionAnual property.
     *
     * @param value a es debe comision anual
     */
    public void setEsDebeComisionAnual(boolean value) {
        this.esDebeComisionAnual = value;
    }

    /**
     * Gets the value of the montoComisionAnual property.
     *
     * @return monto comision anual
     */
    public double getMontoComisionAnual() {
        return montoComisionAnual;
    }

    /**
     * Sets the value of the montoComisionAnual property.
     *
     * @param value a monto comision anual
     */
    public void setMontoComisionAnual(double value) {
        this.montoComisionAnual = value;
    }

    /**
     * Gets the value of the periodosComisionAnual property.
     *
     * @return periodos comision anual
     */
    public int getPeriodosComisionAnual() {
        return periodosComisionAnual;
    }

    /**
     * Sets the value of the periodosComisionAnual property.
     *
     * @param value a periodos comision anual
     */
    public void setPeriodosComisionAnual(int value) {
        this.periodosComisionAnual = value;
    }

    /**
     * Gets the value of the fechaProximoAniversario property.
     *
     * @return
     *     possible object is
     *
     */
    public Date getFechaProximoAniversario() {
        return fechaProximoAniversario;
    }

    /**
     * Sets the value of the fechaProximoAniversario property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setFechaProximoAniversario(Date value) {
        this.fechaProximoAniversario = value;
    }

    /**
     * Gets the value of the producto property.
     *
     * @return
     *     possible object is
     *
     */
    public String getProducto() {
        return producto;
    }

    /**
     * Sets the value of the producto property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setProducto(String value) {
        this.producto = value;
    }

    /**
     * Gets the value of the maximoRetraso property.
     *
     * @return maximo retraso
     */
    public int getMaximoRetraso() {
        return maximoRetraso;
    }

    /**
     * Sets the value of the maximoRetraso property.
     *
     * @param value a maximo retraso
     */
    public void setMaximoRetraso(int value) {
        this.maximoRetraso = value;
    }

    /**
     * Gets the value of the esProteccionDesempleo property.
     *
     * @return true, if is es proteccion desempleo
     */
    public boolean isEsProteccionDesempleo() {
        return esProteccionDesempleo;
    }

    /**
     * Sets the value of the esProteccionDesempleo property.
     *
     * @param value a es proteccion desempleo
     */
    public void setEsProteccionDesempleo(boolean value) {
        this.esProteccionDesempleo = value;
    }

    /**
     * Gets the value of the esTieneAutorizacionConexia property.
     *
     * @return true, if is es tiene autorizacion conexia
     */
    public boolean isEsTieneAutorizacionConexia() {
        return esTieneAutorizacionConexia;
    }

    /**
     * Sets the value of the esTieneAutorizacionConexia property.
     *
     * @param value a es tiene autorizacion conexia
     */
    public void setEsTieneAutorizacionConexia(boolean value) {
        this.esTieneAutorizacionConexia = value;
    }

    /**
     * Gets the value of the montoMinimoAutorizacionConexia property.
     *
     * @return monto minimo autorizacion conexia
     */
    public double getMontoMinimoAutorizacionConexia() {
        return montoMinimoAutorizacionConexia;
    }

    /**
     * Sets the value of the montoMinimoAutorizacionConexia property.
     *
     * @param value a monto minimo autorizacion conexia
     */
    public void setMontoMinimoAutorizacionConexia(double value) {
        this.montoMinimoAutorizacionConexia = value;
    }

    /**
     * Gets the value of the fechaAutorizacionConexia property.
     *
     * @return
     *     possible object is
     *
     */
    public Date getFechaAutorizacionConexia() {
        return fechaAutorizacionConexia;
    }

    /**
     * Sets the value of the fechaAutorizacionConexia property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setFechaAutorizacionConexia(Date value) {
        this.fechaAutorizacionConexia = value;
    }

    /**
     * Gets the value of the consecutivoAutorizacionConexia property.
     *
     * @return consecutivo autorizacion conexia
     */
    public int getConsecutivoAutorizacionConexia() {
        return consecutivoAutorizacionConexia;
    }

    /**
     * Sets the value of the consecutivoAutorizacionConexia property.
     *
     * @param value a consecutivo autorizacion conexia
     */
    public void setConsecutivoAutorizacionConexia(int value) {
        this.consecutivoAutorizacionConexia = value;
    }

    /**
     * Gets the value of the horaAutorizacionConexia property.
     *
     * @return
     *     possible object is
     *
     */
    public Date getHoraAutorizacionConexia() {
        return horaAutorizacionConexia;
    }

    /**
     * Sets the value of the horaAutorizacionConexia property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setHoraAutorizacionConexia(Date value) {
        this.horaAutorizacionConexia = value;
    }

    /**
     * Gets the value of the rfc property.
     *
     * @return
     *     possible object is
     *
     */
    public String getRFC() {
        return rfc;
    }

    /**
     * Sets the value of the rfc property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setRFC(String value) {
        this.rfc = value;
    }

    /**
     * Gets the value of the segmentoProducto property.
     *
     * @return
     *     possible object is
     *
     */
    public String getSegmentoProducto() {
        return segmentoProducto;
    }

    /**
     * Sets the value of the segmentoProducto property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSegmentoProducto(String value) {
        this.segmentoProducto = value;
    }

    /**
     * Gets the value of the generoCliente property.
     *
     * @return
     *     possible object is
     *
     */
    public String getGeneroCliente() {
        return generoCliente;
    }

    /**
     * Sets the value of the generoCliente property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setGeneroCliente(String value) {
        this.generoCliente = value;
    }

    /**
     * Gets the value of the montoCredito property.
     *
     * @return monto credito
     */
    public double getMontoCredito() {
        return montoCredito;
    }

    /**
     * Sets the value of the montoCredito property.
     *
     * @param value a monto credito
     */
    public void setMontoCredito(double value) {
        this.montoCredito = value;
    }

    /**
     * Gets the value of the efectivo property.
     *
     * @return efectivo
     */
    public double getEfectivo() {
        return efectivo;
    }

    /**
     * Sets the value of the efectivo property.
     *
     * @param value a efectivo
     */
    public void setEfectivo(double value) {
        this.efectivo = value;
    }

    /**
     * Gets the value of the sucursalCartera property.
     *
     * @return sucursal cartera
     */
    public int getSucursalCartera() {
        return sucursalCartera;
    }

    /**
     * Sets the value of the sucursalCartera property.
     *
     * @param value a sucursal cartera
     */
    public void setSucursalCartera(int value) {
        this.sucursalCartera = value;
    }

    /**
     * Gets the value of the esForaneo property.
     *
     * @return true, if is es foraneo
     */
    public boolean isEsForaneo() {
        return esForaneo;
    }

    /**
     * Sets the value of the esForaneo property.
     *
     * @param value a es foraneo
     */
    public void setEsForaneo(boolean value) {
        this.esForaneo = value;
    }

    /**
     * Gets the value of the montoBonificacionAutorizacionConexia property.
     *
     * @return monto bonificacion autorizacion conexia
     */
    public double getMontoBonificacionAutorizacionConexia() {
        return montoBonificacionAutorizacionConexia;
    }

    /**
     * Sets the value of the montoBonificacionAutorizacionConexia property.
     *
     * @param value a monto bonificacion autorizacion conexia
     */
    public void setMontoBonificacionAutorizacionConexia(double value) {
        this.montoBonificacionAutorizacionConexia = value;
    }

    /**
     * Gets the value of the contratoRecomienda property.
     *
     * @return
     *     possible object is
     *
     */
    public String getContratoRecomienda() {
        return contratoRecomienda;
    }

    /**
     * Sets the value of the contratoRecomienda property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setContratoRecomienda(String value) {
        this.contratoRecomienda = value;
    }

    /**
     * Gets the value of the origenCredito property.
     *
     * @return
     *     possible object is
     *
     */
    public String getOrigenCredito() {
        return origenCredito;
    }

    /**
     * Sets the value of the origenCredito property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setOrigenCredito(String value) {
        this.origenCredito = value;
    }

    /**
     * Gets the value of the esRecoleccion property.
     *
     * @return true, if is es recoleccion
     */
    public boolean isEsRecoleccion() {
        return esRecoleccion;
    }

    /**
     * Sets the value of the esRecoleccion property.
     *
     * @param value a es recoleccion
     */
    public void setEsRecoleccion(boolean value) {
        this.esRecoleccion = value;
    }

    /**
     * Gets the value of the montoPago property.
     *
     * @return monto pago
     */
    public double getMontoPago() {
        return montoPago;
    }

    /**
     * Sets the value of the montoPago property.
     *
     * @param value a monto pago
     */
    public void setMontoPago(double value) {
        this.montoPago = value;
    }

    /**
     * Gets the value of the descripcionTipoProducto property.
     *
     * @return
     *     possible object is
     *
     */
    public String getDescripcionTipoProducto() {
        return descripcionTipoProducto;
    }

    /**
     * Sets the value of the descripcionTipoProducto property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setDescripcionTipoProducto(String value) {
        this.descripcionTipoProducto = value;
    }

    /**
     * Gets the value of the esMiComercio property.
     *
     * @return true, if is es mi comercio
     */
    public boolean isEsMiComercio() {
        return esMiComercio;
    }

    /**
     * Sets the value of the esMiComercio property.
     *
     * @param value a es mi comercio
     */
    public void setEsMiComercio(boolean value) {
        this.esMiComercio = value;
    }

    /**
     * Gets the value of the claveEmpresa property.
     *
     * @return
     *     possible object is
     *
     */
    public String getClaveEmpresa() {
        return claveEmpresa;
    }

    /**
     * Sets the value of the claveEmpresa property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setClaveEmpresa(String value) {
        this.claveEmpresa = value;
    }

}
