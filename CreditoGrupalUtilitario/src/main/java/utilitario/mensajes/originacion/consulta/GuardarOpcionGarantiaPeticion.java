package utilitario.mensajes.originacion.consulta;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class GuardarOpcionGarantiaPeticion.
 */
public class GuardarOpcionGarantiaPeticion extends ObjetoValor {

	/**
	 * Instantiates a new guardar opcion garantia peticion.
	 */
	public GuardarOpcionGarantiaPeticion() {
	}

	/** serial. */
	private static final long serialVersionUID = 2481624307041105116L;

	/** solicitud. */
	private String contrato;

	/** The opcion garantia. */
	private String opcionGarantia;

	/** The usuario. */
	private String usuario;

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
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * Gets the opcion garantia.
	 *
	 * @return the opcionGarantia
	 */
	public String getOpcionGarantia() {
		return opcionGarantia;
	}

	/**
	 * Sets the opcion garantia.
	 *
	 * @param opcionGarantia the opcionGarantia to set
	 */
	public void setOpcionGarantia(String opcionGarantia) {
		this.opcionGarantia = opcionGarantia;
	}

	/**
	 * Gets the usuario.
	 *
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Sets the usuario.
	 *
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
