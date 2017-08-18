/**
 *
 */
package utilitario.mensajes.burocredito;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class BuroCreditoRFCPeticion.
 *
 * @author out_ltorres
 */
public class BuroCreditoRFCPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva buro credito rfc peticion.
	 */
	public BuroCreditoRFCPeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1791112756865893482L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The cliente id. */
	private String clienteID;

	/** The tipo c. */
	private String tipoC;

	/** The rfc. */
	private String rfc;

	/** The persona. */
	private String persona;

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
	 * Obtiene cliente id.
	 *
	 * @return cliente id
	 */
	public String getClienteID() {
		return clienteID;
	}

	/**
	 * Establece cliente id.
	 *
	 * @param clienteID a cliente id
	 */
	public void setClienteID(String clienteID) {
		this.clienteID = clienteID;
	}

	/**
	 * Obtiene tipo c.
	 *
	 * @return tipo c
	 */
	public String getTipoC() {
		return tipoC;
	}

	/**
	 * Establece tipo c.
	 *
	 * @param tipoC a tipo c
	 */
	public void setTipoC(String tipoC) {
		this.tipoC = tipoC;
	}

	/**
	 * Obtiene rfc.
	 *
	 * @return rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * Establece rfc.
	 *
	 * @param rfc a rfc
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	/**
	 * @return the persona
	 */
	public String getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(String persona) {
		this.persona = persona;
	}

}
