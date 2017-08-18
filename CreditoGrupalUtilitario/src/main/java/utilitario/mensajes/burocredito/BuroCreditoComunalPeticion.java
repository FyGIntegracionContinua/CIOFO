/**
 *
 */
package utilitario.mensajes.burocredito;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class BuroCreditoComunalPeticion.
 *
 * @author out_ltorres
 */
public class BuroCreditoComunalPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva buro credito comunal peticion.
	 */
	public BuroCreditoComunalPeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4379477217430263828L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The id in. */
	private String idIN;

	/** The sistema in. */
	private String sistemaIN;

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
	 * Obtiene id in.
	 *
	 * @return id in
	 */
	public String getIdIN() {
		return idIN;
	}

	/**
	 * Establece id in.
	 *
	 * @param idIN a id in
	 */
	public void setIdIN(String idIN) {
		this.idIN = idIN;
	}

	/**
	 * Obtiene sistema in.
	 *
	 * @return sistema in
	 */
	public String getSistemaIN() {
		return sistemaIN;
	}

	/**
	 * Establece sistema in.
	 *
	 * @param sistemaIN a sistema in
	 */
	public void setSistemaIN(String sistemaIN) {
		this.sistemaIN = sistemaIN;
	}

}
