
package utilitario.mensajes.operacion.pagos;

import java.util.Date;


/**
 * The Class ConsultaContratosRecoleccion.
 */
public class ConsultaContratosRecoleccion {

	/**
	 * Instancia una nueva consulta contratos recoleccion.
	 */
	public ConsultaContratosRecoleccion() { }
    /** The fecha consulta. */
    protected Date fechaConsulta;

    /** The sucursal. */
    protected int sucursal;

    /**
     * Gets the value of the fechaConsulta property.
     *
     * @return
     *     possible object is
     *
     */
    public Date getFechaConsulta() {
        return fechaConsulta;
    }

    /**
     * Sets the value of the fechaConsulta property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setFechaConsulta(Date value) {
        this.fechaConsulta = value;
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
