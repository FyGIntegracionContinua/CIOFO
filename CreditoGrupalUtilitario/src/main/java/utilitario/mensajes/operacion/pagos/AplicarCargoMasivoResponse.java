
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
 *         &lt;element name="AplicarCargoMasivoResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "aplicarCargoMasivoResult"
})
@XmlRootElement(name = "AplicarCargoMasivoResponse")
public class AplicarCargoMasivoResponse {

	/**
	 * AplicarCargoMasivoResponse
	 */
	public AplicarCargoMasivoResponse() {

	}

    /**
     * aplicarCargoMasivoResult String
     */
    @XmlElement(name = "AplicarCargoMasivoResult")
    protected String aplicarCargoMasivoResult;

    /**
     * Gets the value of the aplicarCargoMasivoResult property.
     * @return
     *     possible object is
     *     {@link String }
     */
    public String getAplicarCargoMasivoResult() {
        return aplicarCargoMasivoResult;
    }

    /**
     * Sets the value of the aplicarCargoMasivoResult property.
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setAplicarCargoMasivoResult(String value) {
        this.aplicarCargoMasivoResult = value;
    }

}
