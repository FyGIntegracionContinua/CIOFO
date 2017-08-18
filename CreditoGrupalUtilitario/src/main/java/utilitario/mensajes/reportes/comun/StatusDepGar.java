/**
 * Estado de la respuesta
 */
package utilitario.mensajes.reportes.comun;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author hsamano
 *
 */
public class StatusDepGar extends ObjetoValor {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 8798033482296925830L;

	/** Valor de la respuesta boolean */
	private boolean valor;

	/** Mensaje de la respuesta */
	private String mensaje;
	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}
	/**
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	/**
	 * @return the valor
	 */
	public boolean isValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(boolean valor) {
		this.valor = valor;
	}
}
