/**
 * utilitario.mensajes.operacion.ActaRecaudacionPeticion.java
 */
package utilitario.mensajes.operacion;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ActaRecaudacionPeticion.
 *
 * @author ISC Omar Cruz Carrillo (ocruzc) 24/09/2012
 * @version 1.0
 */
public class ActaRecaudacionPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva acta recaudacion peticion.
	 */
	public ActaRecaudacionPeticion() {
	}
	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -6408270878515941037L;

	/** Acta de Recaudaci&oacute;n. */
	private ActaRecaudacionOV actaRecaudacion;

	/**
	 * M&eacute;todo que regresa el valor del miembro dato actaRecaudacion.
	 * @return the actaRecaudacion
	 */
	public ActaRecaudacionOV getActaRecaudacion() {
		return actaRecaudacion;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato actaRecaudacion.
	 * @param actaRecaudacion the actaRecaudacion to set
	 */
	public void setActaRecaudacion(ActaRecaudacionOV actaRecaudacion) {
		this.actaRecaudacion = actaRecaudacion;
	}
}
