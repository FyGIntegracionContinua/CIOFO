
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
 *         &lt;element name="ConsultaServiciosClienteResult" minOccurs="0">
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
    "consultaServiciosClienteResult"
})
@XmlRootElement(name = "ConsultaServiciosClienteResponse")
public class ConsultaServiciosClienteResponse {

	/**
	 * Instancia una nueva consulta servicios cliente response.
	 */
	public ConsultaServiciosClienteResponse() { }
    /** The consulta servicios cliente result. */
    @XmlElement(name = "ConsultaServiciosClienteResult")
    protected ConsultaServiciosClienteResponse.ConsultaServiciosClienteResult consultaServiciosClienteResult;

    /**
     * Gets the value of the consultaServiciosClienteResult property.
     *
     * @return
     *     possible object is
     *     {@link ConsultaServiciosClienteResponse.ConsultaServiciosClienteResult }
     *
     */
    public ConsultaServiciosClienteResponse.ConsultaServiciosClienteResult getConsultaServiciosClienteResult() {
        return consultaServiciosClienteResult;
    }

    /**
     * Sets the value of the consultaServiciosClienteResult property.
     *
     * @param value
     *     allowed object is
     *     {@link ConsultaServiciosClienteResponse.ConsultaServiciosClienteResult }
     *
     */
    public void setConsultaServiciosClienteResult(ConsultaServiciosClienteResponse.ConsultaServiciosClienteResult value) {
        this.consultaServiciosClienteResult = value;
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
    public static class ConsultaServiciosClienteResult {

    	/**
	     * Instancia una nueva consulta servicios cliente result.
	     */
	    public ConsultaServiciosClienteResult() { }
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
