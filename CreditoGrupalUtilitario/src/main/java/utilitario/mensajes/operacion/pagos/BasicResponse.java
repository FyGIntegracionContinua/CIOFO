
package utilitario.mensajes.operacion.pagos;



/**
 * The Class BasicResponse.
 */
public class BasicResponse {

    /**
	 * BasicResponse
	 */
	public BasicResponse() {
		super();
	}

	/**
     * codigo int
     */
    protected int codigo;
    /**
     * descripcion String
     */
    protected String descripcion;

    /**
     * Gets the value of the codigo property.
     * @return .
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param value Sets the value of the codigo property.
     */
    public void setCodigo(int value) {
        this.codigo = value;
    }

    /**
     * Gets the value of the descripcion property.
     * @return
     *     possible object is
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the value of the descripcion property.
     * @param value
     *     allowed object is
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

}
