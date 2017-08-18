
package utilitario.mensajes.operacion.pagos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="numeroTarjeta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "numeroTarjeta"
})
@XmlRootElement(name = "ConsultaContratoDeTarjeta")
public class ConsultaContratoDeTarjeta {

	/**
	 * Instancia una nueva consulta contrato de tarjeta.
	 */
	public ConsultaContratoDeTarjeta() { }
    /** The numero tarjeta. */
    protected String numeroTarjeta;

    /**
     * Gets the value of the numeroTarjeta property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Sets the value of the numeroTarjeta property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNumeroTarjeta(String value) {
        this.numeroTarjeta = value;
    }

}
