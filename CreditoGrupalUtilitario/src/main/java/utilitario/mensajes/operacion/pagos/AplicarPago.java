
package utilitario.mensajes.operacion.pagos;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The Class AplicarPago.
 */
public class AplicarPago {


    /**
	 * AplicarPago
	 */
	public AplicarPago() {
		super();
	}

	/**
     * contrato String
     */
    protected String contrato;
    /**
     * montoRecibido BigDecimal
     */
    protected BigDecimal montoRecibido;
    /**
     * caja int
     */
    protected int caja;
    /**
     * operador String
     */
    protected String operador;
    /**
     * tipoOperacion String
     */
    protected String tipoOperacion;
    /**
     * numeroCuenta String
     */
    protected String numeroCuenta;
    /**
     * numeroReferencia String
     */
    protected String numeroReferencia;
    /**
     * numeroOperacion BigDecimal
     */
    protected BigDecimal numeroOperacion;
    /**
     * sucursalOrigen int
     */
    protected int sucursalOrigen;
    /**
     * ubicacion int
     */
    protected int ubicacion;
    /**
     * fechaValor Date
     */
    protected Date  fechaValor;
    /**
     * medioPago String
     */
    protected String medioPago;
    /**
     * codigoServicio String
     */
    protected String codigoServicio;
    /**
     * referenciaTC String
     */
    protected String referenciaTC;

    /**
     * Gets the value of the contrato property.
     * @return
     *     possible object is
     */
    public String getContrato() {
        return contrato;
    }

    /**
     * Sets the value of the contrato property.
     * @param value
     *     allowed object is
     */
    public void setContrato(String value) {
        this.contrato = value;
    }

    /**
     * Gets the value of the montoRecibido property.
     * @return
     *     possible object is
     */
    public BigDecimal getMontoRecibido() {
        return montoRecibido;
    }

    /**
     * Sets the value of the montoRecibido property.
     * @param value
     *     allowed object is
     */
    public void setMontoRecibido(BigDecimal value) {
        this.montoRecibido = value;
    }


    /**
     * @return .
     */
    public int getCaja() {
        return caja;
    }


    /**
     * @param value .
     */
    public void setCaja(int value) {
        this.caja = value;
    }

    /**
     * Gets the value of the operador property.
     * @return
     *     possible object is
     */
    public String getOperador() {
        return operador;
    }

    /**
     * Sets the value of the operador property.
     * @param value
     *     allowed object is
     */
    public void setOperador(String value) {
        this.operador = value;
    }

    /**
     * Gets the value of the tipoOperacion property.
     * @return
     *     possible object is
     */
    public String getTipoOperacion() {
        return tipoOperacion;
    }

    /**
     * Sets the value of the tipoOperacion property.
     * @param value
     *     allowed object is
     */
    public void setTipoOperacion(String value) {
        this.tipoOperacion = value;
    }

    /**
     * Gets the value of the numeroCuenta property.
     * @return
     *     possible object is
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * Sets the value of the numeroCuenta property.
     * @param value
     *     allowed object is
     */
    public void setNumeroCuenta(String value) {
        this.numeroCuenta = value;
    }

    /**
     * Gets the value of the numeroReferencia property.
     * @return
     *     possible object is
     */
    public String getNumeroReferencia() {
        return numeroReferencia;
    }

    /**
     * Sets the value of the numeroReferencia property.
     * @param value
     *     allowed object is
     */
    public void setNumeroReferencia(String value) {
        this.numeroReferencia = value;
    }

    /**
     * Gets the value of the numeroOperacion property.
     * @return
     *     possible object is
     */
    public BigDecimal getNumeroOperacion() {
        return numeroOperacion;
    }

    /**
     * Sets the value of the numeroOperacion property.
     * @param value
     *     allowed object is
     */
    public void setNumeroOperacion(BigDecimal value) {
        this.numeroOperacion = value;
    }


    /**
     * @return .
     */
    public int getSucursalOrigen() {
        return sucursalOrigen;
    }


    /**
     * @param value .
     */
    public void setSucursalOrigen(int value) {
        this.sucursalOrigen = value;
    }


    /**
     * @return .
     */
    public int getUbicacion() {
        return ubicacion;
    }


    /**
     * @param value .
     */
    public void setUbicacion(int value) {
        this.ubicacion = value;
    }

    /**
     * Gets the value of the fechaValor property.
     * @return
     *     possible object is
     */
    public Date getFechaValor() {
        return fechaValor;
    }

    /**
     * Sets the value of the fechaValor property.
     * @param value
     *     allowed object is
     */
    public void setFechaValor(Date value) {
        this.fechaValor = value;
    }

    /**
     * Gets the value of the medioPago property.
     * @return
     *     possible object is
     */
    public String getMedioPago() {
        return medioPago;
    }

    /**
     * Sets the value of the medioPago property.
     * @param value
     *     allowed object is
     */
    public void setMedioPago(String value) {
        this.medioPago = value;
    }

    /**
     * Gets the value of the codigoServicio property.
     * @return
     *     possible object is
     */
    public String getCodigoServicio() {
        return codigoServicio;
    }

    /**
     * Sets the value of the codigoServicio property.
     * @param value
     *     allowed object is
     */
    public void setCodigoServicio(String value) {
        this.codigoServicio = value;
    }

    /**
     * Gets the value of the referenciaTC property.
     * @return
     *     possible object is
     */
    public String getReferenciaTC() {
        return referenciaTC;
    }

    /**
     * Sets the value of the referenciaTC property.
     * @param value
     *     allowed object is
     */
    public void setReferenciaTC(String value) {
        this.referenciaTC = value;
    }

}
