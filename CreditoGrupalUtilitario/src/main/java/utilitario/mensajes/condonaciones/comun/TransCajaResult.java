package utilitario.mensajes.condonaciones.comun;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class TransCajaResult.
 */
public class TransCajaResult extends ObjetoValor {

	/**
	 * Instancia una nueva trans caja result.
	 */
	public TransCajaResult() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id transaccion. */
	private  String  idTransaccion;

	/**
	 * Obtiene id transaccion.
	 *
	 * @return the idTransaccion
	 */
	public String getIdTransaccion() {
		return idTransaccion;
	}

	/**
	 * Establece id transaccion.
	 *
	 * @param idTransaccion the idTransaccion to set
	 */
	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}


	/**
	 * To string.
	 *
	 * @param a the a
	 * @return the string
	 */
	public String toString(String a) {
		return super.toString();
	}

}
