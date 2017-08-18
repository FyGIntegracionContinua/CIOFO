
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
 *         &lt;element name="PagoServiciosResult" minOccurs="0">
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
    "pagoServiciosResult"
})
@XmlRootElement(name = "PagoServiciosResponse")
public class PagoServiciosResponse {

	/**
	 * Instancia una nueva pago servicios response.
	 */
	public PagoServiciosResponse() {
	}
    /** The pago servicios result. */
    @XmlElement(name = "PagoServiciosResult")
    protected PagoServiciosResponse.PagoServiciosResult pagoServiciosResult;

    /**
     * Gets the value of the pagoServiciosResult property.
     *
     * @return
     *     possible object is
     *     {@link PagoServiciosResponse.PagoServiciosResult }
     *
     */
    public PagoServiciosResponse.PagoServiciosResult getPagoServiciosResult() {
        return pagoServiciosResult;
    }

    /**
     * Sets the value of the pagoServiciosResult property.
     *
     * @param value
     *     allowed object is
     *     {@link PagoServiciosResponse.PagoServiciosResult }
     *
     */
    public void setPagoServiciosResult(PagoServiciosResponse.PagoServiciosResult value) {
        this.pagoServiciosResult = value;
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
    public static class PagoServiciosResult {

    	/**
	     * Instancia una nueva pago servicios result.
	     */
	    public PagoServiciosResult() {
			// TODO Auto-generated constructor stub
		}
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
