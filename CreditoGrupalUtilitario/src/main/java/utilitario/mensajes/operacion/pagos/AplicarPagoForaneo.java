
package utilitario.mensajes.operacion.pagos;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idtrxcaja" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="contrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="montoAPagar" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="montoRecibido" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="montoCupones" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="montoCambio" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="formaPago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tipoDePago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="esReportarCNBV" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="operacionCupones" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cuentaBancaria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="referenciaBancaria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operacionBancaria" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="pagosAdelantados" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="medioRecepcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sucursalOrigen" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="caja" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="operador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cuponAImprimir" type="{http://fisa.com.mx/v2}EntCupon" minOccurs="0"/>
 *         &lt;element name="montoComision" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="montoDisponibleComision" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="fechaProximoPago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="esImprimirCupon" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="capitalPago" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="interesesPago" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="moratoriosPago" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="cobranzaPagos" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="saldoPagos" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="esRecalculoSaldo" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="saldoActualPago" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="esImprimirAbono" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idtrxcaja",
    "contrato",
    "montoAPagar",
    "montoRecibido",
    "montoCupones",
    "montoCambio",
    "formaPago",
    "tipoDePago",
    "esReportarCNBV",
    "operacionCupones",
    "cuentaBancaria",
    "referenciaBancaria",
    "operacionBancaria",
    "pagosAdelantados",
    "medioRecepcion",
    "sucursalOrigen",
    "caja",
    "operador",
    "cuponAImprimir",
    "montoComision",
    "montoDisponibleComision",
    "fechaProximoPago",
    "esImprimirCupon",
    "capitalPago",
    "interesesPago",
    "moratoriosPago",
    "cobranzaPagos",
    "saldoPagos",
    "esRecalculoSaldo",
    "saldoActualPago",
    "esImprimirAbono"
})
@XmlRootElement(name = "AplicarPagoForaneo")
public class AplicarPagoForaneo {


    /**
	 * AplicarPagoForaneo
	 */
	public AplicarPagoForaneo() {
		super();
	}


	/**
     * idtrxcaja BigDecimal
     */
    @XmlElement(required = true)
    protected BigDecimal idtrxcaja;
    /**
     * contrato String
     */
    protected String contrato;
    /**
     * montoAPagar BigDecimal
     */
    @XmlElement(required = true)
    protected BigDecimal montoAPagar;
    /**
     * montoRecibido BigDecimal
     */
    @XmlElement(required = true)
    protected BigDecimal montoRecibido;
    /**
     * montoCupones BigDecimal
     */
    @XmlElement(required = true)
    protected BigDecimal montoCupones;
    /**
     * montoCambio BigDecimal
     */
    @XmlElement(required = true)
    protected BigDecimal montoCambio;
    /**
     * formaPago String
     */
    protected String formaPago;
    /**
     * tipoDePago String
     */
    protected String tipoDePago;
    /**
     * esReportarCNBV boolean
     */
    protected boolean esReportarCNBV;
    /**
     * operacionCupones String
     */
    protected String operacionCupones;
    /**
     * cuentaBancaria String
     */
    protected String cuentaBancaria;
    /**
     * referenciaBancaria String
     */
    protected String referenciaBancaria;
    /**
     * operacionBancaria int
     */
    protected int operacionBancaria;
    /**
     * pagosAdelantados int
     */
    protected int pagosAdelantados;
    /**
     * medioRecepcion String
     */
    protected String medioRecepcion;
    /**
     * sucursalOrigen int
     */
    protected int sucursalOrigen;
    /**
     * caja int
     */
    protected int caja;
    /**
     * operador String
     */
    protected String operador;
    /**
     * cuponAImprimir EntCupon
     */
    protected EntCupon cuponAImprimir;
    /**
     * montoComision double
     */
    protected double montoComision;
    /**
     * montoDisponibleComision double
     */
    protected double montoDisponibleComision;
    /**
     * fechaProximoPago String
     */
    protected String fechaProximoPago;
    /**
     * esImprimirCupon boolean
     */
    protected boolean esImprimirCupon;
    /**
     * capitalPago double
     */
    protected double capitalPago;
    /**
     * interesesPago double
     */
    protected double interesesPago;
    /**
     * moratoriosPago double
     */
    protected double moratoriosPago;
    /**
     * cobranzaPagos double
     */
    protected double cobranzaPagos;
    /**
     * saldoPagos double
     */
    protected double saldoPagos;
    /**
     * esRecalculoSaldo boolean
     */
    protected boolean esRecalculoSaldo;
    /**
     * saldoActualPago double
     */
    protected double saldoActualPago;
    /**
     * esImprimirAbono boolean
     */
    protected boolean esImprimirAbono;

    /**
     * Gets the value of the idtrxcaja property.
     * @return
     *     possible object is
     *     {@link BigDecimal }
     */
    public BigDecimal getIdtrxcaja() {
        return idtrxcaja;
    }

    /**
     * Sets the value of the idtrxcaja property.
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     */
    public void setIdtrxcaja(BigDecimal value) {
        this.idtrxcaja = value;
    }

    /**
     * Gets the value of the contrato property.
     * @return
     *     possible object is
     *     {@link String }
     */
    public String getContrato() {
        return contrato;
    }

    /**
     * Sets the value of the contrato property.
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setContrato(String value) {
        this.contrato = value;
    }

    /**
     * Gets the value of the montoAPagar property.
     * @return
     *     possible object is
     *     {@link BigDecimal }
     */
    public BigDecimal getMontoAPagar() {
        return montoAPagar;
    }

    /**
     * Sets the value of the montoAPagar property.
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     */
    public void setMontoAPagar(BigDecimal value) {
        this.montoAPagar = value;
    }

    /**
     * Gets the value of the montoRecibido property.
     * @return
     *     possible object is
     *     {@link BigDecimal }
     */
    public BigDecimal getMontoRecibido() {
        return montoRecibido;
    }

    /**
     * Sets the value of the montoRecibido property.
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     */
    public void setMontoRecibido(BigDecimal value) {
        this.montoRecibido = value;
    }

    /**
     * Gets the value of the montoCupones property.
     * @return
     *     possible object is
     *     {@link BigDecimal }
     */
    public BigDecimal getMontoCupones() {
        return montoCupones;
    }

    /**
     * Sets the value of the montoCupones property.
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     */
    public void setMontoCupones(BigDecimal value) {
        this.montoCupones = value;
    }

    /**
     * Gets the value of the montoCambio property.
     * @return
     *     possible object is
     *     {@link BigDecimal }
     */
    public BigDecimal getMontoCambio() {
        return montoCambio;
    }

    /**
     * Sets the value of the montoCambio property.
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     */
    public void setMontoCambio(BigDecimal value) {
        this.montoCambio = value;
    }

    /**
     * Gets the value of the formaPago property.
     * @return
     *     possible object is
     *     {@link String }
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * Sets the value of the formaPago property.
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setFormaPago(String value) {
        this.formaPago = value;
    }

    /**
     * Gets the value of the tipoDePago property.
     * @return
     *     possible object is
     *     {@link String }
     */
    public String getTipoDePago() {
        return tipoDePago;
    }

    /**
     * Sets the value of the tipoDePago property.
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setTipoDePago(String value) {
        this.tipoDePago = value;
    }


    /**
     * @return .
     */
    public boolean isEsReportarCNBV() {
        return esReportarCNBV;
    }


    /**
     * @param value .
     */
    public void setEsReportarCNBV(boolean value) {
        this.esReportarCNBV = value;
    }

    /**
     * Gets the value of the operacionCupones property.
     * @return
     *     possible object is
     *     {@link String }
     */
    public String getOperacionCupones() {
        return operacionCupones;
    }

    /**
     * Sets the value of the operacionCupones property.
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setOperacionCupones(String value) {
        this.operacionCupones = value;
    }

    /**
     * Gets the value of the cuentaBancaria property.
     * @return
     *     possible object is
     *     {@link String }
     */
    public String getCuentaBancaria() {
        return cuentaBancaria;
    }

    /**
     * Sets the value of the cuentaBancaria property.
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setCuentaBancaria(String value) {
        this.cuentaBancaria = value;
    }

    /**
     * Gets the value of the referenciaBancaria property.
     * @return
     *     possible object is
     *     {@link String }
     */
    public String getReferenciaBancaria() {
        return referenciaBancaria;
    }

    /**
     * Sets the value of the referenciaBancaria property.
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setReferenciaBancaria(String value) {
        this.referenciaBancaria = value;
    }


    /**
     * @return .
     */
    public int getOperacionBancaria() {
        return operacionBancaria;
    }


    /**
     * @param value .
     */
    public void setOperacionBancaria(int value) {
        this.operacionBancaria = value;
    }


    /**
     * @return .
     */
    public int getPagosAdelantados() {
        return pagosAdelantados;
    }


    /**
     * @param value .
     */
    public void setPagosAdelantados(int value) {
        this.pagosAdelantados = value;
    }

    /**
     * Gets the value of the medioRecepcion property.
     * @return
     *     possible object is
     *     {@link String }
     */
    public String getMedioRecepcion() {
        return medioRecepcion;
    }

    /**
     * Sets the value of the medioRecepcion property.
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setMedioRecepcion(String value) {
        this.medioRecepcion = value;
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
     *     {@link String }
     */
    public String getOperador() {
        return operador;
    }

    /**
     * Sets the value of the operador property.
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setOperador(String value) {
        this.operador = value;
    }

    /**
     * Gets the value of the cuponAImprimir property.
     * @return
     *     possible object is
     *     {@link EntCupon }
     */
    public EntCupon getCuponAImprimir() {
        return cuponAImprimir;
    }

    /**
     * Sets the value of the cuponAImprimir property.
     * @param value
     *     allowed object is
     *     {@link EntCupon }
     */
    public void setCuponAImprimir(EntCupon value) {
        this.cuponAImprimir = value;
    }

    /**
     * @return .
     */
    public double getMontoComision() {
        return montoComision;
    }


    /**
     * @param value .
     */
    public void setMontoComision(double value) {
        this.montoComision = value;
    }

    /**
     * @return .
     */
    public double getMontoDisponibleComision() {
        return montoDisponibleComision;
    }

    /**
     * @param value .
     */
    public void setMontoDisponibleComision(double value) {
        this.montoDisponibleComision = value;
    }

    /**
     * Gets the value of the fechaProximoPago property.
     * @return
     *     possible object is
     *     {@link String }
     */
    public String getFechaProximoPago() {
        return fechaProximoPago;
    }

    /**
     * Sets the value of the fechaProximoPago property.
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setFechaProximoPago(String value) {
        this.fechaProximoPago = value;
    }


    /**
     * @return .
     */
    public boolean isEsImprimirCupon() {
        return esImprimirCupon;
    }


    /**
     * @param value .
     */
    public void setEsImprimirCupon(boolean value) {
        this.esImprimirCupon = value;
    }


    /**
     * @return .
     */
    public double getCapitalPago() {
        return capitalPago;
    }


    /**
     * @param value .
     */
    public void setCapitalPago(double value) {
        this.capitalPago = value;
    }


    /**
     * @return .
     */
    public double getInteresesPago() {
        return interesesPago;
    }


    /**
     * @param value .
     */
    public void setInteresesPago(double value) {
        this.interesesPago = value;
    }


    /**
     * @return .
     */
    public double getMoratoriosPago() {
        return moratoriosPago;
    }


    /**
     * @param value .
     */
    public void setMoratoriosPago(double value) {
        this.moratoriosPago = value;
    }


    /**
     * @return .
     */
    public double getCobranzaPagos() {
        return cobranzaPagos;
    }


    /**
     * @param value .
     */
    public void setCobranzaPagos(double value) {
        this.cobranzaPagos = value;
    }


    /**
     * @return .
     */
    public double getSaldoPagos() {
        return saldoPagos;
    }


    /**
     * @param value .
     */
    public void setSaldoPagos(double value) {
        this.saldoPagos = value;
    }


    /**
     * @return .
     */
    public boolean isEsRecalculoSaldo() {
        return esRecalculoSaldo;
    }


    /**
     * @param value .
     */
    public void setEsRecalculoSaldo(boolean value) {
        this.esRecalculoSaldo = value;
    }


    /**
     * @return .
     */
    public double getSaldoActualPago() {
        return saldoActualPago;
    }


    /**
     * @param value .
     */
    public void setSaldoActualPago(double value) {
        this.saldoActualPago = value;
    }


    /**
     * @return .
     */
    public boolean isEsImprimirAbono() {
        return esImprimirAbono;
    }


    /**
     * @param value .
     */
    public void setEsImprimirAbono(boolean value) {
        this.esImprimirAbono = value;
    }

}
