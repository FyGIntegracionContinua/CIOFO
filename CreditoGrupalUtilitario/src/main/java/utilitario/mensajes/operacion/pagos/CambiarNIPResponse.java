
package utilitario.mensajes.operacion.pagos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="cambiarNIPResult" type="{http://fisa.endpoint.ws.syc.com/}BasicResponse" minOccurs="0"/>
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
    "cambiarNIPResult"
})
@XmlRootElement(name = "cambiarNIPResponse")
public class CambiarNIPResponse {

	/**
	 * Instancia una nueva cambiar nip response.
	 */
	public CambiarNIPResponse() { }
    /** The cambiar nip result. */
    protected BasicResponse cambiarNIPResult;

    /**
     * Gets the value of the cambiarNIPResult property.
     *
     * @return
     *     possible object is
     *     {@link BasicResponse }
     *
     */
    public BasicResponse getCambiarNIPResult() {
        return cambiarNIPResult;
    }

    /**
     * Sets the value of the cambiarNIPResult property.
     *
     * @param value
     *     allowed object is
     *     {@link BasicResponse }
     *
     */
    public void setCambiarNIPResult(BasicResponse value) {
        this.cambiarNIPResult = value;
    }

}
