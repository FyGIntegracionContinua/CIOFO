package utilitario.mensajes.impresiondocs.comun;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ValesVO.
 */
public class KitSolicitudOV extends ObjetoValor {

	/**
	 * ValesVO
	 */
	public KitSolicitudOV() {

	}
	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = -6281834598639715666L;
	
	private String contratoActual;
	
	private String renovacionFinanciada;
	
	private String renovacion;
	
	private String traspasoGarantia;
	
	private Integer pctGarantia;

	/**
	 * @return the contratoActual
	 */
	public String getContratoActual() {
		return contratoActual;
	}

	/**
	 * @param contratoActual the contratoActual to set
	 */
	public void setContratoActual(String contratoActual) {
		this.contratoActual = contratoActual;
	}

	/**
	 * @return the renovacionFinanciada
	 */
	public String getRenovacionFinanciada() {
		return renovacionFinanciada;
	}

	/**
	 * @param renovacionFinanciada the renovacionFinanciada to set
	 */
	public void setRenovacionFinanciada(String renovacionFinanciada) {
		this.renovacionFinanciada = renovacionFinanciada;
	}

	/**
	 * @return the renovacion
	 */
	public String getRenovacion() {
		return renovacion;
	}

	/**
	 * @param renovacion the renovacion to set
	 */
	public void setRenovacion(String renovacion) {
		this.renovacion = renovacion;
	}

	/**
	 * @return the traspasoGarantia
	 */
	public String getTraspasoGarantia() {
		return traspasoGarantia;
	}

	/**
	 * @param traspasoGarantia the traspasoGarantia to set
	 */
	public void setTraspasoGarantia(String traspasoGarantia) {
		this.traspasoGarantia = traspasoGarantia;
	}

	/**
	 * @return the pctGarantia
	 */
	public Integer getPctGarantia() {
		return pctGarantia;
	}

	/**
	 * @param pctGarantia the pctGarantia to set
	 */
	public void setPctGarantia(Integer pctGarantia) {
		this.pctGarantia = pctGarantia;
	}
	
}
