
package utilitario.mensajes.operacion.pagos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="CancelaPagoServiciosResult" type="{http://fisa.com.mx/v2}Resultado" minOccurs="0"/>
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
    "cancelaPagoServiciosResult"
})
@XmlRootElement(name = "CancelaPagoServiciosResponse")
public class CancelaPagoServiciosResponse {

	/**
	 * Instancia una nueva cancela pago servicios response.
	 */
	public CancelaPagoServiciosResponse() { }
    /** The cancela pago servicios result. */
    @XmlElement(name = "CancelaPagoServiciosResult")
    protected Resultado cancelaPagoServiciosResult;

    /**
     * Gets the value of the cancelaPagoServiciosResult property.
     *
     * @return
     *     possible object is
     *     {@link Resultado }
     *
     */
    public Resultado getCancelaPagoServiciosResult() {
        return cancelaPagoServiciosResult;
    }

    /**
     * Sets the value of the cancelaPagoServiciosResult property.
     *
     * @param value
     *     allowed object is
     *     {@link Resultado }
     *
     */
    public void setCancelaPagoServiciosResult(Resultado value) {
        this.cancelaPagoServiciosResult = value;
    }

}
