
package utilitario.mensajes.operacion.pagos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for EntCupon complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="EntCupon">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Folio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CodigoSeguridad" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Contrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Monto" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FechaAlta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="Vigencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="EsVigente" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="Status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "EntCupon", propOrder = {
    "folio",
    "codigoSeguridad",
    "contrato",
    "monto",
    "fechaAlta",
    "vigencia",
    "esVigente",
    "status"
})
public class EntCupon {

	/**
	 * Instancia una nueva ent cupon.
	 */
	public EntCupon() { }
    /** The folio. */
    @XmlElement(name = "Folio")
    protected String folio;

    /** The codigo seguridad. */
    @XmlElement(name = "CodigoSeguridad")
    protected String codigoSeguridad;

    /** The contrato. */
    @XmlElement(name = "Contrato")
    protected String contrato;

    /** The monto. */
    @XmlElement(name = "Monto")
    protected String monto;

    /** The fecha alta. */
    @XmlElement(name = "FechaAlta")
    protected String fechaAlta;

    /** The vigencia. */
    @XmlElement(name = "Vigencia")
    protected String vigencia;

    /** The es vigente. */
    @XmlElement(name = "EsVigente")
    protected boolean esVigente;

    /** The status. */
    @XmlElement(name = "Status")
    protected String status;

    /**
     * Gets the value of the folio property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFolio() {
        return folio;
    }

    /**
     * Sets the value of the folio property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFolio(String value) {
        this.folio = value;
    }

    /**
     * Gets the value of the codigoSeguridad property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getCodigoSeguridad() {
        return codigoSeguridad;
    }

    /**
     * Sets the value of the codigoSeguridad property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setCodigoSeguridad(String value) {
        this.codigoSeguridad = value;
    }

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
     * Gets the value of the monto property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMonto() {
        return monto;
    }

    /**
     * Sets the value of the monto property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMonto(String value) {
        this.monto = value;
    }

    /**
     * Gets the value of the fechaAlta property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFechaAlta() {
        return fechaAlta;
    }

    /**
     * Sets the value of the fechaAlta property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFechaAlta(String value) {
        this.fechaAlta = value;
    }

    /**
     * Gets the value of the vigencia property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getVigencia() {
        return vigencia;
    }

    /**
     * Sets the value of the vigencia property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setVigencia(String value) {
        this.vigencia = value;
    }

    /**
     * Gets the value of the esVigente property.
     *
     * @return true, if is es vigente
     */
    public boolean isEsVigente() {
        return esVigente;
    }

    /**
     * Sets the value of the esVigente property.
     *
     * @param value a es vigente
     */
    public void setEsVigente(boolean value) {
        this.esVigente = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
