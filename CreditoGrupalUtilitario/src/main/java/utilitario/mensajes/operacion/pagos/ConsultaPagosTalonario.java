
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
 *         &lt;element name="prefijo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cliente" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ip" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sucursalOrigen" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
    "prefijo",
    "cliente",
    "ip",
    "sucursalOrigen",
    "usuario"
})
@XmlRootElement(name = "ConsultaPagosTalonario")
public class ConsultaPagosTalonario {

	/**
	 * Instancia una nueva consulta pagos talonario.
	 */
	public ConsultaPagosTalonario() { }
    /** The contrato. */
    protected String contrato;

    /** The prefijo. */
    protected String prefijo;

    /** The cliente. */
    protected int cliente;

    /** The ip. */
    protected String ip;

    /** The sucursal origen. */
    protected int sucursalOrigen;

    /** The usuario. */
    protected String usuario;

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
     * Gets the value of the prefijo property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPrefijo() {
        return prefijo;
    }

    /**
     * Sets the value of the prefijo property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPrefijo(String value) {
        this.prefijo = value;
    }

    /**
     * Gets the value of the cliente property.
     *
     * @return cliente
     */
    public int getCliente() {
        return cliente;
    }

    /**
     * Sets the value of the cliente property.
     *
     * @param value a cliente
     */
    public void setCliente(int value) {
        this.cliente = value;
    }

    /**
     * Gets the value of the ip property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getIp() {
        return ip;
    }

    /**
     * Sets the value of the ip property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setIp(String value) {
        this.ip = value;
    }

    /**
     * Gets the value of the sucursalOrigen property.
     *
     * @return sucursal origen
     */
    public int getSucursalOrigen() {
        return sucursalOrigen;
    }

    /**
     * Sets the value of the sucursalOrigen property.
     *
     * @param value a sucursal origen
     */
    public void setSucursalOrigen(int value) {
        this.sucursalOrigen = value;
    }

    /**
     * Gets the value of the usuario property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Sets the value of the usuario property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

}
