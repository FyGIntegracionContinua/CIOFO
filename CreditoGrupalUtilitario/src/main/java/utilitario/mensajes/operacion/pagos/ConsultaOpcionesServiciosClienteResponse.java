
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
 *         &lt;element name="ConsultaOpcionesServiciosClienteResult" minOccurs="0">
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
    "consultaOpcionesServiciosClienteResult"
})
@XmlRootElement(name = "ConsultaOpcionesServiciosClienteResponse")
public class ConsultaOpcionesServiciosClienteResponse {

	/**
	 * Instancia una nueva consulta opciones servicios cliente response.
	 */
	public ConsultaOpcionesServiciosClienteResponse() { }
    /** The consulta opciones servicios cliente result. */
    @XmlElement(name = "ConsultaOpcionesServiciosClienteResult")
    protected ConsultaOpcionesServiciosClienteResponse.ConsultaOpcionesServiciosClienteResult
    	consultaOpcionesServiciosClienteResult;

    /**
     * Gets the value of the consultaOpcionesServiciosClienteResult property.
     *
     * @return
     *     possible object is
     *     {@link ConsultaOpcionesServiciosClienteResponse.ConsultaOpcionesServiciosClienteResult }
     *
     */
    public ConsultaOpcionesServiciosClienteResponse.ConsultaOpcionesServiciosClienteResult
    	getConsultaOpcionesServiciosClienteResult() {
        return consultaOpcionesServiciosClienteResult;
    }

    /**
     * Sets the value of the consultaOpcionesServiciosClienteResult property.
     *
     * @param value
     *     allowed object is
     *     {@link ConsultaOpcionesServiciosClienteResponse.ConsultaOpcionesServiciosClienteResult }
     *
     */
    public void setConsultaOpcionesServiciosClienteResult(
    	ConsultaOpcionesServiciosClienteResponse.ConsultaOpcionesServiciosClienteResult value) {
        this.consultaOpcionesServiciosClienteResult = value;
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
    public static class ConsultaOpcionesServiciosClienteResult {

    	/**
	     * Instancia una nueva consulta opciones servicios cliente result.
	     */
	    public ConsultaOpcionesServiciosClienteResult() { }
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
