
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
 *         &lt;element name="ConsultaClienteTalonarioResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "consultaClienteTalonarioResult"
})
@XmlRootElement(name = "ConsultaClienteTalonarioResponse")
public class ConsultaClienteTalonarioResponse {

	/**
	 * Instancia una nueva consulta cliente talonario response.
	 */
	public ConsultaClienteTalonarioResponse() { }
    /** The consulta cliente talonario result. */
    @XmlElement(name = "ConsultaClienteTalonarioResult")
    protected String consultaClienteTalonarioResult;

    /**
     * Gets the value of the consultaClienteTalonarioResult property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getConsultaClienteTalonarioResult() {
        return consultaClienteTalonarioResult;
    }

    /**
     * Sets the value of the consultaClienteTalonarioResult property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setConsultaClienteTalonarioResult(String value) {
        this.consultaClienteTalonarioResult = value;
    }

}
