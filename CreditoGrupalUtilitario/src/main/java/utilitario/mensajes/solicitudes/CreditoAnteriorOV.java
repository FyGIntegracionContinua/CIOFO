package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class BuzonExcepcionOV.
 *
 * @author out_gcorzo
 * @version 1.0
 */
public class CreditoAnteriorOV extends ObjetoValor {

	/**
	 * Instancia una nueva buzon excepcion ov.
	 */
	public CreditoAnteriorOV() {
	}
	/** Se genero serial. */
	private static final long serialVersionUID = 9096745766154723290L;

	/** The contratoLD. */
	private String contratoLD;

	/** The ciclo. */
	private Integer ciclo;

	/**
	 * @return the contratoLD
	 */
	public String getContratoLD() {
		return contratoLD;
	}

	/**
	 * @param contratoLD the contratoLD to set
	 */
	public void setContratoLD(String contratoLD) {
		this.contratoLD = contratoLD;
	}

	/**
	 * @return the ciclo
	 */
	public Integer getCiclo() {
		return ciclo;
	}

	/**
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}


}
