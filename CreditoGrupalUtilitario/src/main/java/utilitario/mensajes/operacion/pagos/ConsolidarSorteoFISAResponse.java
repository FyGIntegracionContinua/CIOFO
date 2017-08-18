
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
 *         &lt;element name="ConsolidarSorteoFISAResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "consolidarSorteoFISAResult"
})
@XmlRootElement(name = "ConsolidarSorteoFISAResponse")
public class ConsolidarSorteoFISAResponse {

	/**
	 * Instancia una nueva consolidar sorteo fisa response.
	 */
	public ConsolidarSorteoFISAResponse() { }
    /** The consolidar sorteo fisa result. */
    @XmlElement(name = "ConsolidarSorteoFISAResult")
    protected String consolidarSorteoFISAResult;

    /**
     * Gets the value of the consolidarSorteoFISAResult property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getConsolidarSorteoFISAResult() {
        return consolidarSorteoFISAResult;
    }

    /**
     * Sets the value of the consolidarSorteoFISAResult property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setConsolidarSorteoFISAResult(String value) {
        this.consolidarSorteoFISAResult = value;
    }

}
