
package utilitario.mensajes.operacion.pagos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ConsultaContratoDeTarjetaResult" minOccurs="0">
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
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "consultaContratoDeTarjetaResult"
})
@XmlRootElement(name = "ConsultaContratoDeTarjetaResponse")
public class ConsultaContratoDeTarjetaResponse {

	/**
	 * Instancia una nueva consulta contrato de tarjeta response.
	 */
	public ConsultaContratoDeTarjetaResponse() { }
    /** The consulta contrato de tarjeta result. */
    @XmlElement(name = "ConsultaContratoDeTarjetaResult")
    protected ConsultaContratoDeTarjetaResponse.ConsultaContratoDeTarjetaResult consultaContratoDeTarjetaResult;

    /**
     * Gets the value of the consultaContratoDeTarjetaResult property.
     *
     * @return
     *     possible object is
     *     {@link ConsultaContratoDeTarjetaResponse.ConsultaContratoDeTarjetaResult }
     *
     */
    public ConsultaContratoDeTarjetaResponse.ConsultaContratoDeTarjetaResult getConsultaContratoDeTarjetaResult() {
        return consultaContratoDeTarjetaResult;
    }

    /**
     * Sets the value of the consultaContratoDeTarjetaResult property.
     *
     * @param value
     *     allowed object is
     *     {@link ConsultaContratoDeTarjetaResponse.ConsultaContratoDeTarjetaResult }
     *
     */
    public void setConsultaContratoDeTarjetaResult(ConsultaContratoDeTarjetaResponse.ConsultaContratoDeTarjetaResult value) {
        this.consultaContratoDeTarjetaResult = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     *
     * <p>The following schema fragment specifies the expected content contained within this class.
     *
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
     *
     *
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "any"
    })
    public static class ConsultaContratoDeTarjetaResult {

    	/**
	     * Instancia una nueva consulta contrato de tarjeta result.
	     */
	    public ConsultaContratoDeTarjetaResult() { }
        /** The any. */
        @XmlAnyElement(lax = true)
        protected Object any;

        /**
         * Gets the value of the any property.
         *
         * @return
         *     possible object is
         *     {@link Object }
         *
         */
        public Object getAny() {
            return any;
        }

        /**
         * Sets the value of the any property.
         *
         * @param value
         *     allowed object is
         *     {@link Object }
         *
         */
        public void setAny(Object value) {
            this.any = value;
        }

    }

}
