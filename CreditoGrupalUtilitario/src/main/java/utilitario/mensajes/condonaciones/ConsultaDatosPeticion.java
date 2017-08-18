package utilitario.mensajes.condonaciones;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaDatosPeticion.
 */
public class ConsultaDatosPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva consulta datos peticion.
	 */
	public ConsultaDatosPeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoPeticion 	header;

	/** The ld. */
	private String  	ld;

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
	 * Obtiene ld.
	 *
	 * @return the ld
	 */
	public String getLd() {
		return ld;
	}

	/**
	 * Establece ld.
	 *
	 * @param ld the ld to set
	 */
	public void setLd(String ld) {
		this.ld = ld;
	}

	/**
	 * Obtiene serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
