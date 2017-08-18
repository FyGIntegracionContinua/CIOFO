package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ClaveCliente.
 *
 * @author out_ltorres
 * @version 1.0
 */
public class ClaveCliente extends ObjetoValor {

	/**
	 * Instancia una nueva clave cliente.
	 */
	public ClaveCliente() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 493478648131479710L;

	/** The customer id. */
	private String customerId;

	/** The codigo. */
	private String codigo;

	/** The tipo localidad. */
	private String tipoLocalidad;

	/** The marca cliente. */
	private String marcaCliente;

	/** The experiencia. */
	private String experiencia;

	/**
	 * Obtiene customer id.
	 *
	 * @return customer id
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * Establece customer id.
	 *
	 * @param customerId a customer id
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * Obtiene codigo.
	 *
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Establece codigo.
	 *
	 * @param codigo a codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtiene tipo localidad.
	 *
	 * @return tipo localidad
	 */
	public String getTipoLocalidad() {
		return tipoLocalidad;
	}

	/**
	 * Establece tipo localidad.
	 *
	 * @param tipoLocalidad a tipo localidad
	 */
	public void setTipoLocalidad(String tipoLocalidad) {
		this.tipoLocalidad = tipoLocalidad;
	}

	/**
	 * Obtiene marca cliente.
	 *
	 * @return marca cliente
	 */
	public String getMarcaCliente() {
		return marcaCliente;
	}

	/**
	 * Establece marca cliente.
	 *
	 * @param marcaCliente a marca cliente
	 */
	public void setMarcaCliente(String marcaCliente) {
		this.marcaCliente = marcaCliente;
	}

	/**
	 * Obtiene experiencia.
	 *
	 * @return experiencia
	 */
	public String getExperiencia() {
		return experiencia;
	}

	/**
	 * Establece experiencia.
	 *
	 * @param experiencia a experiencia
	 */
	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia;
	}

}
