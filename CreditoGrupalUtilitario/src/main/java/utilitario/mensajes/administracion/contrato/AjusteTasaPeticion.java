package utilitario.mensajes.administracion.contrato;


/**
 * The Class AjusteTasaPeticion.
 */
public class AjusteTasaPeticion {

	/**
	 * Instancia una nueva ajuste tasa peticion.
	 */
	public AjusteTasaPeticion() {
	}
	/** The contrato. */
	private String contrato;

	/** The tasa. */
	private Double tasa;

	/** The usuario. */
	private String usuario;

	/**
	 * Obtiene contrato.
	 *
	 * @return contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * Establece contrato.
	 *
	 * @param contrato a contrato
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * Obtiene tasa.
	 *
	 * @return tasa
	 */
	public Double getTasa() {
		return tasa;
	}

	/**
	 * Establece tasa.
	 *
	 * @param tasa a tasa
	 */
	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}

	/**
	 * Obtiene usuario.
	 *
	 * @return usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Establece usuario.
	 *
	 * @param usuario a usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	/**
	 * Metodo toString
	 *
	 * @return String
	 */
	public String toString() {
		return "[ contrato = " + contrato
				+ ", tasa = "	   + tasa
				+ ", usuario = "  + usuario  + "]";
		}
}
