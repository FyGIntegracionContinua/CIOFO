
package utilitario.mensajes.operacion.pagos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="PagoGrupalResponseObject" type="{http://fisa.com.mx/v2}PagoGrupalResponse"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pagoGrupalResponseObject"
})
@XmlRootElement(name = "AplicarPagoGrupalResponse")
public class AplicarPagoGrupalResponse {

	/**
	 * AplicarPagoGrupalResponse
	 */
	AplicarPagoGrupalResponse() {

	}
    /**
     * pagoGrupalResponseObject PagoGrupalResponse
     */
    @XmlElement(name = "PagoGrupalResponseObject", required = true)
    protected PagoGrupalResponse pagoGrupalResponseObject;

    /**
     * Gets the value of the pagoGrupalResponseObject property.
     * @return
     *     possible object is
     *     {@link PagoGrupalResponse }
     */
    public PagoGrupalResponse getPagoGrupalResponseObject() {
        return pagoGrupalResponseObject;
    }

    /**
     * Sets the value of the pagoGrupalResponseObject property.
     * @param value
     *     allowed object is
     *     {@link PagoGrupalResponse }
     */
    public void setPagoGrupalResponseObject(PagoGrupalResponse value) {
        this.pagoGrupalResponseObject = value;
    }

}
