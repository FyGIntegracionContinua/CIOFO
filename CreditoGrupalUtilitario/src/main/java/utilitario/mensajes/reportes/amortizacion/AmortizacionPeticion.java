package utilitario.mensajes.reportes.amortizacion;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AmortizacionPeticion.
 */
public class AmortizacionPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva amortizacion peticion.
	 */
	public AmortizacionPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8424620239791148436L;

	/** The numero cuenta. */
	private String numeroCuenta;

	/** The sucursal. */
	private Integer sucursal;

	/**
	 * Obtiene numero cuenta.
	 *
	 * @return numero cuenta
	 */
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	/**
	 * Establece numero cuenta.
	 *
	 * @param numeroCuenta a numero cuenta
	 */
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal a sucursal
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene sucursal.
	 *
	 * @return sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}
}
