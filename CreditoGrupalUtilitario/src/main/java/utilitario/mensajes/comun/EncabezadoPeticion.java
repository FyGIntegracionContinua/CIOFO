
package utilitario.mensajes.comun;


/**
 * The Class EncabezadoPeticion.
 *
 * @author Juan Moreno.
 * Encapsula los datos del header de peticion de la ejecucion de una operacion.
 * <ul>
 * 	<li>consumer</li>
 * 	<li>correlationId</li>
 *  <li>numSucursal</li>
 * </ul>
 */
public final class EncabezadoPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva encabezado peticion.
	 */
	public EncabezadoPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The consumer. */
	private String consumer;

	/** The correlation id. */
	private String correlationId;

	/** The num sucursal. */
	private int numSucursal;


	/**
	 * Obtiene num sucursal.
	 *
	 * @return the numSucursal
	 */
	public int getNumSucursal() {
		return numSucursal;
	}

	/**
	 * Establece num sucursal.
	 *
	 * @param numSucursal the numSucursal to set
	 */
	public void setNumSucursal(int numSucursal) {
		this.numSucursal = numSucursal;
	}

	/**
	 * Obtiene consumer.
	 *
	 * @return the consumer
	 */
	public String getConsumer() {
		return consumer;
	}

	/**
	 * Establece consumer.
	 *
	 * @param consumer the consumer to set
	 */
	public void setConsumer(String consumer) {
		this.consumer = consumer;
	}

	/**
	 * Obtiene correlation id.
	 *
	 * @return the correlationId
	 */
	public String getCorrelationId() {
		return correlationId;
	}

	/**
	 * Establece correlation id.
	 *
	 * @param correlationId the correlationId to set
	 */
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}
}
