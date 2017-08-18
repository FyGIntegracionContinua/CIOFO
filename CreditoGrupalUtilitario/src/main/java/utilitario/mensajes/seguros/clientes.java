package utilitario.mensajes.seguros;

import java.util.List;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class BeneficiarioOV.
 *
 * @author rguadarramac
 */
public class clientes extends ObjetoValor {

	/**
	 * Instancia una nueva beneficiario ov.
	 */
	public clientes() {
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 534839698349227187L;

	/** The clientes. */
	private List<cliente> clientes;

	/**
	 * Gets the clientes.
	 *
	 * @return the clientes
	 */
	public List<cliente> getClientes() {
		return clientes;
	}

	/**
	 * Sets the clientes.
	 *
	 * @param clientes the new clientes
	 */
	public void setClientes(List<cliente> clientes) {
		this.clientes = clientes;
	}
}
