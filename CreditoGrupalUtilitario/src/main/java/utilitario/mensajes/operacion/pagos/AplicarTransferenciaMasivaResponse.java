
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
 *         &lt;element name="AplicarTransferenciaMasivaResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "aplicarTransferenciaMasivaResult"
})
@XmlRootElement(name = "AplicarTransferenciaMasivaResponse")
public class AplicarTransferenciaMasivaResponse {


    /**
	 * AplicarTransferenciaMasivaResponse
	 */
	public AplicarTransferenciaMasivaResponse() {
		super();
	}

	/**
     * aplicarTransferenciaMasivaResult String
     */
    @XmlElement(name = "AplicarTransferenciaMasivaResult")
    protected String aplicarTransferenciaMasivaResult;

    /**
     * Gets the value of the aplicarTransferenciaMasivaResult property.
     * @return
     *     possible object is
     *     {@link String }
     */
    public String getAplicarTransferenciaMasivaResult() {
        return aplicarTransferenciaMasivaResult;
    }

    /**
     * Sets the value of the aplicarTransferenciaMasivaResult property.
     * @param value
     *     allowed object is
     *     {@link String }
     */
    public void setAplicarTransferenciaMasivaResult(String value) {
        this.aplicarTransferenciaMasivaResult = value;
    }

}
