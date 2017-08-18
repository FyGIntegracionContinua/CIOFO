package utilitario.mensajes.comun;

/**
 * The Class ErrorTransformacion.
 *
 * @author out_jcmoreno
 */
public class ErrorTransformacion extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The mensaje. */
	private String mensaje;

	/** The tipo. */
	private int tipo;

	/**
	 * Instancia una nueva error transformacion.
	 */
	public ErrorTransformacion() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instancia una nueva error transformacion.
	 *
	 * @param tipo the tipo
	 * @param mensaje the mensaje
	 */
	public ErrorTransformacion( int tipo, String mensaje ) {
		super();
		this.mensaje = mensaje;
		this.tipo = tipo;
	}

	/**
	 * Obtiene mensaje.
	 *
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * Establece mensaje.
	 *
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * Obtiene tipo.
	 *
	 * @return the tipo
	 */
	public int getTipo() {
		return tipo;
	}

	/**
	 * Establece tipo.
	 *
	 * @param tipo the tipo to set
	 */
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
