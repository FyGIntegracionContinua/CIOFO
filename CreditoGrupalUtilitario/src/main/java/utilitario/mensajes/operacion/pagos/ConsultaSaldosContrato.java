
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
 *         &lt;element name="sucursalCartera" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "sucursalCartera"
})
@XmlRootElement(name = "ConsultaSaldosContrato")
public class ConsultaSaldosContrato {

	/**
	 * Instancia una nueva consulta saldos contrato.
	 */
	public ConsultaSaldosContrato() { }
    /** The contrato. */
    protected String contrato;

    /** The sucursal cartera. */
    protected int sucursalCartera;

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
     * Gets the value of the sucursalCartera property.
     *
     * @return sucursal cartera
     */
    public int getSucursalCartera() {
        return sucursalCartera;
    }

    /**
     * Sets the value of the sucursalCartera property.
     *
     * @param value a sucursal cartera
     */
    public void setSucursalCartera(int value) {
        this.sucursalCartera = value;
    }

}
