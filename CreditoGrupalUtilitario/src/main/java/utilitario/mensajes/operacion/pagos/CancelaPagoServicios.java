
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
 *         &lt;element name="folioTransaccion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="certificacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="medioRecepcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="autoriza" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="caja" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sucursalOrigen" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "folioTransaccion",
    "certificacion",
    "medioRecepcion",
    "operador",
    "autoriza",
    "caja",
    "sucursalOrigen"
})
@XmlRootElement(name = "CancelaPagoServicios")
public class CancelaPagoServicios {

	/**
	 * Instancia una nueva cancela pago servicios.
	 */
	public CancelaPagoServicios() { }
    /** The folio transaccion. */
    protected String folioTransaccion;

    /** The certificacion. */
    protected String certificacion;

    /** The medio recepcion. */
    protected String medioRecepcion;

    /** The operador. */
    protected String operador;

    /** The autoriza. */
    protected String autoriza;

    /** The caja. */
    protected int caja;

    /** The sucursal origen. */
    protected int sucursalOrigen;

    /**
     * Gets the value of the folioTransaccion property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFolioTransaccion() {
        return folioTransaccion;
    }

    /**
     * Sets the value of the folioTransaccion property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFolioTransaccion(String value) {
        this.folioTransaccion = value;
    }

    /**
     * Gets the value of the certificacion property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCertificacion() {
        return certificacion;
    }

    /**
     * Sets the value of the certificacion property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCertificacion(String value) {
        this.certificacion = value;
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

    /**
     * Gets the value of the autoriza property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getAutoriza() {
        return autoriza;
    }

    /**
     * Sets the value of the autoriza property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setAutoriza(String value) {
        this.autoriza = value;
    }

    /**
     * Gets the value of the caja property.
     *
     * @return caja
     */
    public int getCaja() {
        return caja;
    }

    /**
     * Sets the value of the caja property.
     *
     * @param value a caja
     */
    public void setCaja(int value) {
        this.caja = value;
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

}
