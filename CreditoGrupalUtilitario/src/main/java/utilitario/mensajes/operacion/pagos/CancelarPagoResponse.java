
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
 *         &lt;element name="CancelarPagoResult" type="{http://fisa.com.mx/v2}Resultado" minOccurs="0"/>
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
    "cancelarPagoResult"
})
@XmlRootElement(name = "CancelarPagoResponse")
public class CancelarPagoResponse {

	/**
	 * Instancia una nueva cancelar pago response.
	 */
	public CancelarPagoResponse() { }
    /** The cancelar pago result. */
    @XmlElement(name = "CancelarPagoResult")
    protected Resultado cancelarPagoResult;

    /**
     * Gets the value of the cancelarPagoResult property.
     *
     * @return
     *     possible object is
     *     {@link Resultado }
     *
     */
    public Resultado getCancelarPagoResult() {
        return cancelarPagoResult;
    }

    /**
     * Sets the value of the cancelarPagoResult property.
     *
     * @param value
     *     allowed object is
     *     {@link Resultado }
     *
     */
    public void setCancelarPagoResult(Resultado value) {
        this.cancelarPagoResult = value;
    }

}
