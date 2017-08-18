
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
 *         &lt;element name="numeroNIPActual" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numeroNIPNuevo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "numeroTarjeta",
    "numeroNIPActual",
    "numeroNIPNuevo"
})
@XmlRootElement(name = "cambiarNIP")

public class CambiarNIP {

	/**
	 * Instancia una nueva cambiar nip.
	 */
	public CambiarNIP() { }
    /** The numero tarjeta. */
    protected String numeroTarjeta;

    /** The numero nip actual. */
    protected String numeroNIPActual;

    /** The numero nip nuevo. */
    protected String numeroNIPNuevo;

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

    /**
     * Gets the value of the numeroNIPActual property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNumeroNIPActual() {
        return numeroNIPActual;
    }

    /**
     * Sets the value of the numeroNIPActual property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNumeroNIPActual(String value) {
        this.numeroNIPActual = value;
    }

    /**
     * Gets the value of the numeroNIPNuevo property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getNumeroNIPNuevo() {
        return numeroNIPNuevo;
    }

    /**
     * Sets the value of the numeroNIPNuevo property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setNumeroNIPNuevo(String value) {
        this.numeroNIPNuevo = value;
    }

}
