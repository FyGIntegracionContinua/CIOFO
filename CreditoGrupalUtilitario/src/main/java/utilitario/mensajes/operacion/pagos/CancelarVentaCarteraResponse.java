
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
 *         &lt;element name="CancelarVentaCarteraResult" type="{http://fisa.com.mx/v2}Resultado" minOccurs="0"/>
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
    "cancelarVentaCarteraResult"
})
@XmlRootElement(name = "CancelarVentaCarteraResponse")
public class CancelarVentaCarteraResponse {

	/**
	 * Instancia una nueva cancelar venta cartera response.
	 */
	public CancelarVentaCarteraResponse() { }
    /** The cancelar venta cartera result. */
    @XmlElement(name = "CancelarVentaCarteraResult")
    protected Resultado cancelarVentaCarteraResult;

    /**
     * Gets the value of the cancelarVentaCarteraResult property.
     *
     * @return
     *     possible object is
     *     {@link Resultado }
     *
     */
    public Resultado getCancelarVentaCarteraResult() {
        return cancelarVentaCarteraResult;
    }

    /**
     * Sets the value of the cancelarVentaCarteraResult property.
     *
     * @param value
     *     allowed object is
     *     {@link Resultado }
     *
     */
    public void setCancelarVentaCarteraResult(Resultado value) {
        this.cancelarVentaCarteraResult = value;
    }

}
