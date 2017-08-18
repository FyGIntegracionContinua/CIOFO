
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
 *         &lt;element name="bloquearTarjetaResult"
 *         type="{http://fisa.endpoint.ws.syc.com/}bloqueaTarjetaResponseReturn"
 *         minOccurs="0"/>
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
    "bloquearTarjetaResult"
})
@XmlRootElement(name = "bloquearTarjetaResponse")


public class BloquearTarjetaResponse {

	/**
	 * Instancia una nueva bloquear tarjeta response.
	 */
	public BloquearTarjetaResponse() {
	}

    /** The bloquear tarjeta result. */
    protected BloqueaTarjetaResponseReturn bloquearTarjetaResult;

    /**
     * Gets the value of the bloquearTarjetaResult property.
     *
     * @return
     *     possible object is
     *     {@link BloqueaTarjetaResponseReturn }
     *
     */
    public BloqueaTarjetaResponseReturn getBloquearTarjetaResult() {
        return bloquearTarjetaResult;
    }

    /**
     * Sets the value of the bloquearTarjetaResult property.
     *
     * @param value
     *     allowed object is
     *     {@link BloqueaTarjetaResponseReturn }
     *
     */
    public void setBloquearTarjetaResult(BloqueaTarjetaResponseReturn value) {
        this.bloquearTarjetaResult = value;
    }

}
