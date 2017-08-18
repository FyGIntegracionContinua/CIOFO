
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
 *         &lt;element name="PagoGrupalObject" type="{http://fisa.com.mx/v2}PagoGrupal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "pagoGrupalObject"
})
@XmlRootElement(name = "AplicarPagoGrupal")
public class AplicarPagoGrupal {

    /**
	 * AplicarPagoGrupal
	 */
	public AplicarPagoGrupal() {
		super();
	}

	/**
     * pagoGrupalObject PagoGrupal
     */
    @XmlElement(name = "PagoGrupalObject", required = true)
    protected PagoGrupal pagoGrupalObject;

    /**
     * Gets the value of the pagoGrupalObject property.
     * @return
     *     possible object is
     *     {@link PagoGrupal }
     */
    public PagoGrupal getPagoGrupalObject() {
        return pagoGrupalObject;
    }

    /**
     * Sets the value of the pagoGrupalObject property.
     * @param value
     *     allowed object is
     *     {@link PagoGrupal }
     */
    public void setPagoGrupalObject(PagoGrupal value) {
        this.pagoGrupalObject = value;
    }

}
