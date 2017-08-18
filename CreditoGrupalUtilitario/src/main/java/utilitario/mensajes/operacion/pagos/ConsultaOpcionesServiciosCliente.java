
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
 *         &lt;element name="claveCliente" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="claveServicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="medioRecepcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "claveCliente",
    "claveServicio",
    "medioRecepcion",
    "operador"
})
@XmlRootElement(name = "ConsultaOpcionesServiciosCliente")
public class ConsultaOpcionesServiciosCliente {

	/**
	 * Instancia una nueva consulta opciones servicios cliente.
	 */
	public ConsultaOpcionesServiciosCliente() { }
    /** The clave cliente. */
    protected int claveCliente;

    /** The clave servicio. */
    protected String claveServicio;

    /** The medio recepcion. */
    protected String medioRecepcion;

    /** The operador. */
    protected String operador;

    /**
     * Gets the value of the claveCliente property.
     *
     * @return clave cliente
     */
    public int getClaveCliente() {
        return claveCliente;
    }

    /**
     * Sets the value of the claveCliente property.
     *
     * @param value a clave cliente
     */
    public void setClaveCliente(int value) {
        this.claveCliente = value;
    }

    /**
     * Gets the value of the claveServicio property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getClaveServicio() {
        return claveServicio;
    }

    /**
     * Sets the value of the claveServicio property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setClaveServicio(String value) {
        this.claveServicio = value;
    }

    /**
     * Gets the value of the medioRecepcion property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMedioRecepcion() {
        return medioRecepcion;
    }

    /**
     * Sets the value of the medioRecepcion property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMedioRecepcion(String value) {
        this.medioRecepcion = value;
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
