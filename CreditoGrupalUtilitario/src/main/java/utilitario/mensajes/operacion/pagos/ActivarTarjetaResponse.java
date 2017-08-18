
package utilitario.mensajes.operacion.pagos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="activarTarjetaResult" type="{http://fisa.endpoint.ws.syc.com/}activaTarjetaResponseReturn"
 *         minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>

 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "activarTarjetaResult"
})
@XmlRootElement(name = "activarTarjetaResponse")
public class ActivarTarjetaResponse {

	/**
	 * ActivarTarjetaResponse
	 */
	ActivarTarjetaResponse() {

	}

	/**
	 * activarTarjetaResult ActivaTarjetaResponseReturn
	 */
	protected ActivaTarjetaResponseReturn activarTarjetaResult;

    /**
     * Gets the value of the activarTarjetaResult property.
     * @return
     *     possible object is
     *     {@link ActivaTarjetaResponseReturn }
     */
    public ActivaTarjetaResponseReturn getActivarTarjetaResult() {
        return activarTarjetaResult;
    }

    /**
     * Sets the value of the activarTarjetaResult property.
     * @param value
     *     allowed object is
     *     {@link ActivaTarjetaResponseReturn }
     */
    public void setActivarTarjetaResult(ActivaTarjetaResponseReturn value) {
        this.activarTarjetaResult = value;
    }

}
