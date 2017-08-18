package utilitario.mensajes.administracion.contrato;

public class AjustePorcentajeGarantiaPeticion {
	/**
	 * AjustePorcentajeGarantiaPeticion.
	 */
	public AjustePorcentajeGarantiaPeticion() {

	}

	/** String contrato. */
	private String contrato;

	/** String usuario. */
	private String usuario;

	/** String porcentajeGarantia */
	private Integer porcentajeGarantia;

	/**
	 * Obtiene contrato.
	 *
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * Obtiene usuario.
	 *
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Obtiene porcentaje Garantia
	 *
	 * @return the porcentajeGarantia
	 */
	public Integer getPorcentajeGarantia() {
		return porcentajeGarantia;
	}

	/**
	 * Establece contrato.
	 *
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * Establece porcentajeGarantia
	 *
	 * @param porcentajeGarantia the porcentajeGarantia to set
	 */
	public void setPorcentajeGarantia(Integer porcentajeGarantia) {
		this.porcentajeGarantia = porcentajeGarantia;
	}

	/**
	 * Establece usuario.
	 *
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
