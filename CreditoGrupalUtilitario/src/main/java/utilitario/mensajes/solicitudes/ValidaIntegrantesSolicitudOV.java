package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class SolicitudesOV.
 *
 * @author rguadarramac
 * @version 1.0
 */
public class ValidaIntegrantesSolicitudOV extends ObjetoValor {

	/**
	 * Instancia una nueva solicitudes ov.
	 */
	public ValidaIntegrantesSolicitudOV() {
	}
	/** Se genero serial. */
	private static final long serialVersionUID = 9096745766154723290L;

	/** The efectivo solicitado. */
	private Double efectivoSolicitado;

	/** The codigo destino credito. */
	private String codigoDestinoCredito;

	/** The seguro. */
	private String seguro;

	/** The status. */
	private String status;


	/**
	 * Gets the efectivo solicitado.
	 *
	 * @return the efectivo solicitado
	 */
	public Double getEfectivoSolicitado() {
		return efectivoSolicitado;
	}

	/**
	 * Sets the efectivo solicitado.
	 *
	 * @param efectivoSolicitado the new efectivo solicitado
	 */
	public void setEfectivoSolicitado(Double efectivoSolicitado) {
		this.efectivoSolicitado = efectivoSolicitado;
	}

	/**
	 * Gets the codigo destino credito.
	 *
	 * @return the codigo destino credito
	 */
	public String getCodigoDestinoCredito() {
		return codigoDestinoCredito;
	}

	/**
	 * Sets the codigo destino credito.
	 *
	 * @param codigoDestinoCredito the new codigo destino credito
	 */
	public void setCodigoDestinoCredito(String codigoDestinoCredito) {
		this.codigoDestinoCredito = codigoDestinoCredito;
	}

	/**
	 * Gets the seguro.
	 *
	 * @return the seguro
	 */
	public String getSeguro() {
		return seguro;
	}

	/**
	 * Sets the seguro.
	 *
	 * @param seguro the new seguro
	 */
	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}


}
