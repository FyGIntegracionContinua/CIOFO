
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
 *         &lt;element name="cadenaXML" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>

 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cadenaXML"
})
@XmlRootElement(name = "AplicarVentaCarteraMasiva")
public class AplicarVentaCarteraMasiva {

    /**
	 * AplicarVentaCarteraMasiva
	 */
	public AplicarVentaCarteraMasiva() {
		super();
	}

	/**
     * cadenaXML String
     */
    protected String cadenaXML;

    /**
     * Gets the value of the cadenaXML property.
     * @return
     *     possible object is
     *     {@link String }
     */
    public String getCadenaXML() {
        return cadenaXML;
    }

    /**
     * Sets the value of the cadenaXML property.
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setCadenaXML(String value) {
        this.cadenaXML = value;
    }

}
