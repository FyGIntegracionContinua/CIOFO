
package utilitario.mensajes.operacion.pagos;


/**
 * The Class BloqueaTarjetaResponseReturn.
 */
public class BloqueaTarjetaResponseReturn {

    /**
	 * BloqueaTarjetaResponseReturn
	 */
	public BloqueaTarjetaResponseReturn() {
		super();
	}

	/**
     * code int
     */
    protected int code;
    /**
     * description String
     */
    protected String description;
    /**
     * authorization String
     */
    protected String authorization;

    /**
     * Gets the value of the code property.
     * @return .
     */
    public int getCode() {
        return code;
    }

    /**
     * @param value Sets the value of the code property.
     */
    public void setCode(int value) {
        this.code = value;
    }

    /**
     * Gets the value of the description property.
     * @return
     *     possible object is
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * @param value
     *     allowed object is
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the authorization property.
     * @return
     *     possible object is
     */
    public String getAuthorization() {
        return authorization;
    }

    /**
     * Sets the value of the authorization property.
     * @param value
     *     allowed object is
     */
    public void setAuthorization(String value) {
        this.authorization = value;
    }

}
