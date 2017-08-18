
package utilitario.mensajes.operacion.pagos;

import java.util.Date;


/**
 * The Class ConsultaPagoServicios.
 */
public class ConsultaPagoServicios {

	/**
	 * Instancia una nueva consulta pago servicios.
	 */
	public ConsultaPagoServicios() { }
    /** The referencia. */
    protected String referencia;

    /** The sucursal. */
    protected int sucursal;

    /** The fecha contable. */
    protected Date fechaContable;

    /**
     * Gets the value of the referencia property.
     *
     * @return
     *     possible object is
     *
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * Sets the value of the referencia property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setReferencia(String value) {
        this.referencia = value;
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

    /**
     * Gets the value of the fechaContable property.
     *
     * @return
     *     possible object is
     *
     */
    public Date getFechaContable() {
        return fechaContable;
    }

    /**
     * Sets the value of the fechaContable property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setFechaContable(Date value) {
        this.fechaContable = value;
    }

}
