/**
 *
 */
package utilitario.mensajes.operacion;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * clase para que nos ayuda al registro de la soperaciones de entrada y salida.
 * @author rmontellano
 *
 */
public class RegistrOperacionesPeticion extends ObjetoValor {
	/** identificador unico */
	private static final long serialVersionUID = 6807974678066366959L;
	/** numero de persona*/
	private String numeroPersona;
	/** tipo de operacion  a realizar inicia, termina*/
	private String tipOperacion;
	/**
	 * @return the numeroPersona
	 */
	public String getNumeroPersona() {
		return numeroPersona;
	}
	/**
	 * @param numeroPersona the numeroPersona to set
	 */
	public void setNumeroPersona(String numeroPersona) {
		this.numeroPersona = numeroPersona;
	}
	/**
	 * @return the tipOperacion
	 */
	public String getTipOperacion() {
		return tipOperacion;
	}
	/**
	 * @param tipOperacion the tipOperacion to set
	 */
	public void setTipOperacion(String tipOperacion) {
		this.tipOperacion = tipOperacion;
	}

}
