
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
 *         &lt;element name="numeroTransaccion" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="tipoOperacion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="operador" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sucursalOrigen" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="caja" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
    "numeroTransaccion",
    "tipoOperacion",
    "operador",
    "sucursalOrigen",
    "caja"
})
@XmlRootElement(name = "CancelarPago")
public class CancelarPago {

	/**
	 * Instancia una nueva cancelar pago.
	 */
	public CancelarPago() { }
    /** The contrato. */
    protected String contrato;

    /** The numero transaccion. */
    @XmlElement(required = true)
    protected BigDecimal numeroTransaccion;

    /** The tipo operacion. */
    protected String tipoOperacion;

    /** The operador. */
    protected String operador;

    /** The sucursal origen. */
    protected int sucursalOrigen;

    /** The caja. */
    protected int caja;

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
     * Gets the value of the numeroTransaccion property.
     *
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *
     */
    public BigDecimal getNumeroTransaccion() {
        return numeroTransaccion;
    }

    /**
     * Sets the value of the numeroTransaccion property.
     *
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *
     */
    public void setNumeroTransaccion(BigDecimal value) {
        this.numeroTransaccion = value;
    }

    /**
     * Gets the value of the tipoOperacion property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTipoOperacion() {
        return tipoOperacion;
    }

    /**
     * Sets the value of the tipoOperacion property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTipoOperacion(String value) {
        this.tipoOperacion = value;
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

}
