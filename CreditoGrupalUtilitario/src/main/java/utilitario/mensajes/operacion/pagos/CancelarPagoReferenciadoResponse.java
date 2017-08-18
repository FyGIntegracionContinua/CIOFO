
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
 *         &lt;element name="CancelarPagoReferenciadoResult" type="{http://fisa.com.mx/v2}Resultado" minOccurs="0"/>
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
    "cancelarPagoReferenciadoResult"
})
@XmlRootElement(name = "CancelarPagoReferenciadoResponse")
public class CancelarPagoReferenciadoResponse {

	/**
	 * Instancia una nueva cancelar pago referenciado response.
	 */
	public CancelarPagoReferenciadoResponse() { }
    /** The cancelar pago referenciado result. */
    @XmlElement(name = "CancelarPagoReferenciadoResult")
    protected Resultado cancelarPagoReferenciadoResult;

    /**
     * Gets the value of the cancelarPagoReferenciadoResult property.
     *
     * @return
     *     possible object is
     *     {@link Resultado }
     *
     */
    public Resultado getCancelarPagoReferenciadoResult() {
        return cancelarPagoReferenciadoResult;
    }

    /**
     * Sets the value of the cancelarPagoReferenciadoResult property.
     *
     * @param value
     *     allowed object is
     *     {@link Resultado }
     *
     */
    public void setCancelarPagoReferenciadoResult(Resultado value) {
        this.cancelarPagoReferenciadoResult = value;
    }

}
