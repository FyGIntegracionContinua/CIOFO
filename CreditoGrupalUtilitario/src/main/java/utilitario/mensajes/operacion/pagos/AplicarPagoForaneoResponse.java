
package utilitario.mensajes.operacion.pagos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
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
 *         &lt;element name="AplicarPagoForaneoResult" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;any/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
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
/**
 * @author mi.mejorada
 *
 */
/**
 * @author mi.mejorada
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "aplicarPagoForaneoResult",
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
@XmlRootElement(name = "AplicarPagoForaneoResponse")
public class AplicarPagoForaneoResponse {


    /**
	 * AplicarPagoForaneoResponse
	 */
	public AplicarPagoForaneoResponse() {
		super();
	}


	/**
     * aplicarPagoForaneoResult AplicarPagoForaneoResponse.AplicarPagoForaneoResult
     */
    @XmlElement(name = "AplicarPagoForaneoResult")
    protected AplicarPagoForaneoResponse.AplicarPagoForaneoResult aplicarPagoForaneoResult;
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
     * Gets the value of the aplicarPagoForaneoResult property.
     * @return
     *     possible object is
     *     {@link AplicarPagoForaneoResponse.AplicarPagoForaneoResult }
     */
    public AplicarPagoForaneoResponse.AplicarPagoForaneoResult getAplicarPagoForaneoResult() {
        return aplicarPagoForaneoResult;
    }

    /**
     * Sets the value of the aplicarPagoForaneoResult property.
     * @param value
     *     allowed object is
     *     {@link AplicarPagoForaneoResponse.AplicarPagoForaneoResult }
     */
    public void setAplicarPagoForaneoResult(AplicarPagoForaneoResponse.AplicarPagoForaneoResult value) {
        this.aplicarPagoForaneoResult = value;
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
     * Gets the value of the montoComision property.
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


    /**
     * <p>Java class for anonymous complex type.
     * <p>The following schema fragment specifies the expected content contained within this class.
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;any/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>

     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class AplicarPagoForaneoResult {


    	/**
    	 * AplicarPagoForaneoResult
    	 */
    	AplicarPagoForaneoResult() {

    	}
        /**
         * any Object
         */
        @XmlAnyElement(lax = true)
        protected Object any;

        /**
         * Gets the value of the any property.
         * @return
         *     possible object is
         *     {@link Object }
         */
        public Object getAny() {
            return any;
        }

        /**
         * Sets the value of the any property.
         * @param value
         *     allowed object is
         *     {@link Object }
         */
        public void setAny(Object value) {
            this.any = value;
        }

    }

}
