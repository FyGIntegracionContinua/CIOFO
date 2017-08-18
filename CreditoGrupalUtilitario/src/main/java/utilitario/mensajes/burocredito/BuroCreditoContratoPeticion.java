/**
 *
 */
package utilitario.mensajes.burocredito;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class BuroCreditoContratoPeticion.
 *
 * @author out_jcubias
 */
public class BuroCreditoContratoPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva buro credito contrato peticion.
	 */
	public BuroCreditoContratoPeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7665070584183185017L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The prm contract. */
	private String prmContract;

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}

	/**
	 * Obtiene prm contract.
	 *
	 * @return prm contract
	 */
	public String getPrmContract() {
		return prmContract;
	}

	/**
	 * Establece prm contract.
	 *
	 * @param prmContract a prm contract
	 */
	public void setPrmContract(String prmContract) {
		this.prmContract = prmContract;
	}

}
