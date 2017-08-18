package utilitario.mensajes.seguros;

import java.util.List;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class PeticionConsulta.
 *
 * @author rguadarramac
 *
 */
public class PeticionConsulta extends ObjetoValor {

	/**
	 * Instancia una nueva peticion consulta.
	 */
	public PeticionConsulta() {
	}
	/** Se genero clave de objeto. */
	private static final long serialVersionUID = 6133922144221534178L;


	/** The beneficiarios clientes. */
	private List<BeneficiariosClienteOV> beneficiariosClientes;


	/**
	 * Establece beneficiarios clientes.
	 *
	 * @param beneficiariosClientes a beneficiarios clientes
	 */
	public void setBeneficiariosClientes(List<BeneficiariosClienteOV> beneficiariosClientes) {
		this.beneficiariosClientes = beneficiariosClientes;
	}


	/**
	 * Obtiene beneficiarios clientes.
	 *
	 * @return beneficiarios clientes
	 */
	public List<BeneficiariosClienteOV> getBeneficiariosClientes() {
		return beneficiariosClientes;
	}


}
