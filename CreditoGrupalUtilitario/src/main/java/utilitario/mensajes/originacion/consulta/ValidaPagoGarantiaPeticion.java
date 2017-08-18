package utilitario.mensajes.originacion.consulta;

import utilitario.mensajes.comun.ObjetoValor;

public class ValidaPagoGarantiaPeticion extends ObjetoValor {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 2481624307041105116L;

	/**
	 * solicitud
	 */
	private String solicitud;

	/**
	 * contrato
	 */
	private String contrato;

	/**
	 * @return the solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}
	/**
	 * @param solicitud the solicitud to set
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}
	/**
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}
	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

}
