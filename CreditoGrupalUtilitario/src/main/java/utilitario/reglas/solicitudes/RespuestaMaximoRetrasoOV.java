/**
 *
 */
package utilitario.reglas.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultarPersonaRespuesta.
 *
 * @author rguadarrama
 */
public class RespuestaMaximoRetrasoOV extends ObjetoValor {

	/**
	 * Instantiates a new validar solicitud peticion.
	 */
	public RespuestaMaximoRetrasoOV() {
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5677000937229085332L;


	/** The contrato. */
	private String contrato;

	/** The maximo retraso. */
	private Integer maximoRetraso;

	/** The dias no renovado. */
	private Integer diasNoRenovado;

	/** The tasa. */
	private Double tasa;

	/** The numero sucursal. */
	private Integer numeroSucursal;

	/** The ciclo. */
	private Integer ciclo;

	/**
	 * Gets the contrato.
	 *
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * Sets the contrato.
	 *
	 * @param contrato the new contrato
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * Gets the maximo retraso.
	 *
	 * @return the maximo retraso
	 */
	public Integer getMaximoRetraso() {
		return maximoRetraso;
	}

	/**
	 * Sets the maximo retraso.
	 *
	 * @param maximoRetraso the new maximo retraso
	 */
	public void setMaximoRetraso(Integer maximoRetraso) {
		this.maximoRetraso = maximoRetraso;
	}

	/**
	 * Gets the dias no renovado.
	 *
	 * @return the dias no renovado
	 */
	public Integer getDiasNoRenovado() {
		return diasNoRenovado;
	}

	/**
	 * Sets the dias no renovado.
	 *
	 * @param diasNoRenovado the new dias no renovado
	 */
	public void setDiasNoRenovado(Integer diasNoRenovado) {
		this.diasNoRenovado = diasNoRenovado;
	}

	/**
	 * Gets the tasa.
	 *
	 * @return the tasa
	 */
	public Double getTasa() {
		return tasa;
	}

	/**
	 * Sets the tasa.
	 *
	 * @param tasa the new tasa
	 */
	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}

	/**
	 * Gets the numero sucursal.
	 *
	 * @return the numero sucursal
	 */
	public Integer getNumeroSucursal() {
		return numeroSucursal;
	}

	/**
	 * Sets the numero sucursal.
	 *
	 * @param numeroSucursal the new numero sucursal
	 */
	public void setNumeroSucursal(Integer numeroSucursal) {
		this.numeroSucursal = numeroSucursal;
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
