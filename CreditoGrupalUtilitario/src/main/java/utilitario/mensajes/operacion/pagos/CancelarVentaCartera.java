
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
 *         &lt;element name="contrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "contrato",
    "operador"
})
@XmlRootElement(name = "CancelarVentaCartera")
public class CancelarVentaCartera {

	/**
	 * Instancia una nueva cancelar venta cartera.
	 */
	public CancelarVentaCartera() { }
    /** The contrato. */
    protected String contrato;

    /** The operador. */
    protected String operador;

    /**
     * Gets the value of the contrato property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getContrato() {
        return contrato;
    }

    /**
     * Sets the value of the contrato property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setContrato(String value) {
        this.contrato = value;
    }

    /**
     * Gets the value of the operador property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getOperador() {
        return operador;
    }

    /**
     * Sets the value of the operador property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setOperador(String value) {
        this.operador = value;
    }

}
