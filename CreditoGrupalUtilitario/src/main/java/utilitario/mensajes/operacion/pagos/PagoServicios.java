
package utilitario.mensajes.operacion.pagos;

import java.math.BigDecimal;
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
 *         &lt;element name="contrato" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="formaPago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="montoServicio" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="montoIvaServicio" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="claveCliente" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="claveServicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="montoComision" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="montoIvaComision" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="lineaCaptura" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="referencia1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="referencia2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="referencia3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="referencia4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="referencia5" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="medioRecepcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idOperacion" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="idCorte" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="caja" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="sucursal" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "formaPago",
    "montoServicio",
    "montoIvaServicio",
    "claveCliente",
    "claveServicio",
    "montoComision",
    "montoIvaComision",
    "lineaCaptura",
    "referencia1",
    "referencia2",
    "referencia3",
    "referencia4",
    "referencia5",
    "medioRecepcion",
    "operador",
    "idOperacion",
    "idCorte",
    "caja",
    "sucursal"
})
@XmlRootElement(name = "PagoServicios")
public class PagoServicios {

	/**
	 * Instancia una nueva pago servicios.
	 */
	public PagoServicios() {
	}
    /** The contrato. */
    protected String contrato;

    /** The forma pago. */
    protected String formaPago;

    /** The monto servicio. */
    @XmlElement(required = true)
    protected BigDecimal montoServicio;

    /** The monto iva servicio. */
    @XmlElement(required = true)
    protected BigDecimal montoIvaServicio;

    /** The clave cliente. */
    protected int claveCliente;

    /** The clave servicio. */
    protected String claveServicio;

    /** The monto comision. */
    @XmlElement(required = true)
    protected BigDecimal montoComision;

    /** The monto iva comision. */
    @XmlElement(required = true)
    protected BigDecimal montoIvaComision;

    /** The linea captura. */
    protected String lineaCaptura;

    /** The referencia1. */
    protected String referencia1;

    /** The referencia2. */
    protected String referencia2;

    /** The referencia3. */
    protected String referencia3;

    /** The referencia4. */
    protected String referencia4;

    /** The referencia5. */
    protected String referencia5;

    /** The medio recepcion. */
    protected String medioRecepcion;

    /** The operador. */
    protected String operador;

    /** The id operacion. */
    @XmlElement(required = true)
    protected BigDecimal idOperacion;

    /** The id corte. */
    @XmlElement(required = true)
    protected BigDecimal idCorte;

    /** The caja. */
    protected int caja;

    /** The sucursal. */
    protected int sucursal;

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
     * Gets the value of the formaPago property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getFormaPago() {
        return formaPago;
    }

    /**
     * Sets the value of the formaPago property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setFormaPago(String value) {
        this.formaPago = value;
    }

    /**
     * Gets the value of the montoServicio property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getMontoServicio() {
        return montoServicio;
    }

    /**
     * Sets the value of the montoServicio property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setMontoServicio(BigDecimal value) {
        this.montoServicio = value;
    }

    /**
     * Gets the value of the montoIvaServicio property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getMontoIvaServicio() {
        return montoIvaServicio;
    }

    /**
     * Sets the value of the montoIvaServicio property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setMontoIvaServicio(BigDecimal value) {
        this.montoIvaServicio = value;
    }

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
     * Gets the value of the montoComision property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getMontoComision() {
        return montoComision;
    }

    /**
     * Sets the value of the montoComision property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setMontoComision(BigDecimal value) {
        this.montoComision = value;
    }

    /**
     * Gets the value of the montoIvaComision property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getMontoIvaComision() {
        return montoIvaComision;
    }

    /**
     * Sets the value of the montoIvaComision property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setMontoIvaComision(BigDecimal value) {
        this.montoIvaComision = value;
    }

    /**
     * Gets the value of the lineaCaptura property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getLineaCaptura() {
        return lineaCaptura;
    }

    /**
     * Sets the value of the lineaCaptura property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setLineaCaptura(String value) {
        this.lineaCaptura = value;
    }

    /**
     * Gets the value of the referencia1 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReferencia1() {
        return referencia1;
    }

    /**
     * Sets the value of the referencia1 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReferencia1(String value) {
        this.referencia1 = value;
    }

    /**
     * Gets the value of the referencia2 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReferencia2() {
        return referencia2;
    }

    /**
     * Sets the value of the referencia2 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReferencia2(String value) {
        this.referencia2 = value;
    }

    /**
     * Gets the value of the referencia3 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReferencia3() {
        return referencia3;
    }

    /**
     * Sets the value of the referencia3 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReferencia3(String value) {
        this.referencia3 = value;
    }

    /**
     * Gets the value of the referencia4 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReferencia4() {
        return referencia4;
    }

    /**
     * Sets the value of the referencia4 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReferencia4(String value) {
        this.referencia4 = value;
    }

    /**
     * Gets the value of the referencia5 property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getReferencia5() {
        return referencia5;
    }

    /**
     * Sets the value of the referencia5 property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setReferencia5(String value) {
        this.referencia5 = value;
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
     * Gets the value of the idOperacion property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getIdOperacion() {
        return idOperacion;
    }

    /**
     * Sets the value of the idOperacion property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setIdOperacion(BigDecimal value) {
        this.idOperacion = value;
    }

    /**
     * Gets the value of the idCorte property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getIdCorte() {
        return idCorte;
    }

    /**
     * Sets the value of the idCorte property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setIdCorte(BigDecimal value) {
        this.idCorte = value;
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
     * Gets the value of the sucursal property.
     *
     * @return sucursal
     */
    public int getSucursal() {
        return sucursal;
    }

    /**
     * Sets the value of the sucursal property.
     *
     * @param value a sucursal
     */
    public void setSucursal(int value) {
        this.sucursal = value;
    }

}
