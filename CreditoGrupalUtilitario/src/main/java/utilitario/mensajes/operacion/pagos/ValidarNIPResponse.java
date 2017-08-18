
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
 *         &lt;element name="validarNIPResult" type="{http://fisa.endpoint.ws.syc.com/}BasicResponse" minOccurs="0"/>
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
    "validarNIPResult"
})
@XmlRootElement(name = "validarNIPResponse")
public class ValidarNIPResponse {

	/**
	 * Instancia una nueva validar nip response.
	 */
	public ValidarNIPResponse() {
	}
    /** The validar nip result. */
    protected BasicResponse validarNIPResult;

    /**
     * Gets the value of the validarNIPResult property.
     *
     * @return
     *     possible object is
     *     {@link BasicResponse }
     *
     */
    public BasicResponse getValidarNIPResult() {
        return validarNIPResult;
    }

    /**
     * Sets the value of the validarNIPResult property.
     *
     * @param value
     *     allowed object is
     *     {@link BasicResponse }
     *
     */
    public void setValidarNIPResult(BasicResponse value) {
        this.validarNIPResult = value;
    }

}
