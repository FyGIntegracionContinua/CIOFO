package utilitario.mensajes.administracion.contrato;


/**
 * The Class AjusteDiaPagoPeticion.
 */
public class AjusteDiaPagoPeticion {

	/**
	 * AjustePlazoPeticion.
	 */
	public AjusteDiaPagoPeticion() {

	}

	/** String contrato. */
	private String contrato;

	/** String numeroPagos. */
	private String fechaAnclaPago;

	/** String operador. */
	private String operador;

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
	 * Obtiene fecha Ancla Pago.
	 *
	 * @return the contrato
	 */
	public String getFechaAnclaPago() {
		return fechaAnclaPago;
	}

	/**
	 * Establece fechaAnclaPago.
	 *
	 * @param fechaAnclaPago the fechaAnclaPago to set
	 */
	public void setFechaAnclaPago(String fechaAnclaPago) {
		this.fechaAnclaPago = fechaAnclaPago;
	}

	/**
	 * Obtiene operador.
	 *
	 * @return the operador
	 */
	public String getOperador() {
		return operador;
	}

	/**
	 * Establece operador.
	 *
	 * @param operador the operador to set
	 */
	public void setOperador(String operador) {
		this.operador = operador;
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
				+ ", fechaAnclaPago = "	+ fechaAnclaPago
				+ ", operador = "	+ operador
				+ ", usuario = "  		+ usuario  		+ "]";
		}
}
