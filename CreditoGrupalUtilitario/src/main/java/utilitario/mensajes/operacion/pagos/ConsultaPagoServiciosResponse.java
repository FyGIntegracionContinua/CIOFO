
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
 *         &lt;element name="ConsultaPagoServiciosResult" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "consultaPagoServiciosResult"
})
@XmlRootElement(name = "ConsultaPagoServiciosResponse")
public class ConsultaPagoServiciosResponse {

	/**
	 * Instancia una nueva consulta pago servicios response.
	 */
	public ConsultaPagoServiciosResponse() { }
    /** The consulta pago servicios result. */
    @XmlElement(name = "ConsultaPagoServiciosResult")
    protected String consultaPagoServiciosResult;

    /**
     * Gets the value of the consultaPagoServiciosResult property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getConsultaPagoServiciosResult() {
        return consultaPagoServiciosResult;
    }

    /**
     * Sets the value of the consultaPagoServiciosResult property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setConsultaPagoServiciosResult(String value) {
        this.consultaPagoServiciosResult = value;
    }

}
