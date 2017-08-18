package utilitario.mensajes.originacion.consulta;

import utilitario.mensajes.comun.ObjetoValor;

public class PagoDocumentoPeticion extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1762411375659411043L;
	private String contratoNuevo;
	private String contratoAnterior;
	private double montoFinanciado;
	private int sucursal;
	
	/**
	 * @return the contratoNuevo
	 */
	public String getContratoNuevo() {
		return contratoNuevo;
	}
	/**
	 * @param contratoNuevo the contratoNuevo to set
	 */
	public void setContratoNuevo(String contratoNuevo) {
		this.contratoNuevo = contratoNuevo;
	}
	/**
	 * @return the contratoAnterior
	 */
	public String getContratoAnterior() {
		return contratoAnterior;
	}
	/**
	 * @param contratoAnterior the contratoAnterior to set
	 */
	public void setContratoAnterior(String contratoAnterior) {
		this.contratoAnterior = contratoAnterior;
	}
	/**
	 * @return the montoFinanciado
	 */
	public double getMontoFinanciado() {
		return montoFinanciado;
	}
	/**
	 * @param montoFinanciado the montoFinanciado to set
	 */
	public void setMontoFinanciado(double montoFinanciado) {
		this.montoFinanciado = montoFinanciado;
	}
	/**
	 * @return the sucursal
	 */
	public int getSucursal() {
		return sucursal;
	}
	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}

}
