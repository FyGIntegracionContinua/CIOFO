package utilitario.mensajes.persona;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaDatosGeneralesPeticion.
 */
public class ConsultaDatosGeneralesPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva consulta datos generales peticion.
	 */
	public ConsultaDatosGeneralesPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6732944924084273711L;

	/** The header. */
	private EncabezadoPeticion	header;

	/** The numero persona. */
	private String numeroPersona;

	/** The clave t24. */
	private String claveT24;

	/** The clave cu. */
	private String claveCU;

	/** The rfc. */
	private String rfc;

	/**
	 * Obtiene numero persona.
	 *
	 * @return the numeroPersona
	 */
	public String getNumeroPersona() {
		return numeroPersona;
	}

	/**
	 * Establece numero persona.
	 *
	 * @param numeroPersona the numeroPersona to set
	 */
	public void setNumeroPersona(String numeroPersona) {
		this.numeroPersona = numeroPersona;
	}

	/**
	 * Obtiene clave t24.
	 *
	 * @return the claveT24
	 */
	public String getClaveT24() {
		return claveT24;
	}

	/**
	 * Establece clave t24.
	 *
	 * @param claveT24 the claveT24 to set
	 */
	public void setClaveT24(String claveT24) {
		this.claveT24 = claveT24;
	}

	/**
	 * Obtiene clave cu.
	 *
	 * @return the claveCU
	 */
	public String getClaveCU() {
		return claveCU;
	}

	/**
	 * Establece clave cu.
	 *
	 * @param claveCU the claveCU to set
	 */
	public void setClaveCU(String claveCU) {
		this.claveCU = claveCU;
	}

	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
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


}
