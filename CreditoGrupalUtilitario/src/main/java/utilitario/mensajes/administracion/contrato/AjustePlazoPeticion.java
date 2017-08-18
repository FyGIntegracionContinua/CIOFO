package utilitario.mensajes.administracion.contrato;


/**
 * The Class AjustePlazoPeticion.
 */
public class AjustePlazoPeticion {

	/**
	 * AjustePlazoPeticion.
	 */
	public AjustePlazoPeticion() {

	}

	/** String contrato. */
	private String contrato;

	/** Integer numeroPagos. */
	private Integer numeroPagos;

	/** String usuario. */
	private String usuario;


	/**
	 * Obtiene contrato.
	 *
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
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
	 * Obtiene numero pagos.
	 *
	 * @return the numeroPagos
	 */
	public Integer getNumeroPagos() {
		return numeroPagos;
	}


	/**
	 * Establece numero pagos.
	 *
	 * @param numeroPagos the numeroPagos to set
	 */
	public void setNumeroPagos(Integer numeroPagos) {
		this.numeroPagos = numeroPagos;
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
	 * Establece usuario.
	 *
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	/**
	 * toString.
	 *
	 * @return the toString
	 */
	public String toString() {
		return "[ contrato = " 		+ contrato
				+ ", numeroPagos = "	+ numeroPagos
				+ ", usuario = "  		+ usuario  		+ "]";
		}
}
