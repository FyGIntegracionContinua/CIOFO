
package transformador;

/**
 * @author Juan Carlos Moreno
 *
 */
public class TransformadorException extends RuntimeException {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -3543652017834169466L;

	/**
	 * String causa
	 */
	private String causa;

	/**
	 * @param cause Constructor
	 */
	public TransformadorException(String cause) {
		super();
		this.causa = cause;
	}

	/**
	 * @return the cause
	 */
	public String getCausa() {
		return causa;
	}

}
