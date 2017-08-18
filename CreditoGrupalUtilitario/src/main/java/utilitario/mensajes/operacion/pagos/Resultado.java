
package utilitario.mensajes.operacion.pagos;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Resultado complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="Resultado">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MensajeRespuesta" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="NumeroTransaccion" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Resultado", propOrder = {
    "mensajeRespuesta",
    "numeroTransaccion"
})
public class Resultado {

	/**
	 * Instancia una nueva resultado.
	 */
	public Resultado() {
	}
    /** The mensaje respuesta. */
    @XmlElement(name = "MensajeRespuesta")
    protected String mensajeRespuesta;

    /** The numero transaccion. */
    @XmlElement(name = "NumeroTransaccion", required = true)
    protected BigDecimal numeroTransaccion;

    /**
     * Gets the value of the mensajeRespuesta property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getMensajeRespuesta() {
        return mensajeRespuesta;
    }

    /**
     * Sets the value of the mensajeRespuesta property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setMensajeRespuesta(String value) {
        this.mensajeRespuesta = value;
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

}
