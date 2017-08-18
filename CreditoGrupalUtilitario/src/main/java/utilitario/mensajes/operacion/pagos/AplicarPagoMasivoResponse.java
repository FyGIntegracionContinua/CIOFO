
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
 *         &lt;element name="AplicarPagoMasivoResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "aplicarPagoMasivoResult"
})
@XmlRootElement(name = "AplicarPagoMasivoResponse")
public class AplicarPagoMasivoResponse {


    /**
	 * AplicarPagoMasivoResponse
	 */
	public AplicarPagoMasivoResponse() {
		super();
	}

	/**
     * aplicarPagoMasivoResult String
     */
    @XmlElement(name = "AplicarPagoMasivoResult")
    protected String aplicarPagoMasivoResult;

    /**
     * Gets the value of the aplicarPagoMasivoResult property.
     * @return
     *     possible object is
     *     {@link String }
     */
    public String getAplicarPagoMasivoResult() {
        return aplicarPagoMasivoResult;
    }

    /**
     * Sets the value of the aplicarPagoMasivoResult property.
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setAplicarPagoMasivoResult(String value) {
        this.aplicarPagoMasivoResult = value;
    }

}
