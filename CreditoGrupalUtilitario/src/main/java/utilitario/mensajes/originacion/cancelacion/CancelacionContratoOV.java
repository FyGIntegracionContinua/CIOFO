/**
 * Tensegrity - 2011
 */
package utilitario.mensajes.originacion.cancelacion;

import utilitario.mensajes.comun.ObjetoValor;



/**
 * The Class CancelacionContratoOV.
 *
 * @author Juan Moreno
 *
 * <ul>
 * 	<li>Numero de Solicitud</li>
 * </ul>
 */
public final class CancelacionContratoOV extends ObjetoValor {

	/**
	 * Instancia una nueva cancelacion contrato ov.
	 */
	public CancelacionContratoOV() { }
  	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6981071483618064945L;

	/** The contrato ld. */
	private String contratoLD;

	  /** The operador. */
	  private String operador;

	/**
	 * Obtiene contrato ld.
	 *
	 * @return the contratoLD
	 */
	public String getContratoLD() {
		return contratoLD;
	}

	/**
	 * Establece contrato ld.
	 *
	 * @param contratoLD the contratoLD to set
	 */
	public void setContratoLD(String contratoLD) {
		this.contratoLD = contratoLD;
	}

	/**
	 * Obtiene operador.
	 *
	 * @return the operador
	 */
	public String getOperador() {
		return operador;
	}

	/**
	 * Establece operador.
	 *
	 * @param operador the operador to set
	 */
	public void setOperador(String operador) {
		this.operador = operador;
	}

}
