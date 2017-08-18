package utilitario.mensajes.impresiondocs.comunalpagare;

import utilitario.mensajes.comun.EncabezadoPeticion;

/**
 * The Class ComunalPagarePeticion.
 */
public class ComunalPagarePeticion {

	/**
	 * Instancia una nueva comunal pagare peticion.
	 */
	public ComunalPagarePeticion() { }
	/** The s contrato. */
	private String sContrato;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Obtiene s contrato.
	 *
	 * @return the sContrato
	 */
	public String getsContrato() {
		return sContrato;
	}

	/**
	 * Establece s contrato.
	 *
	 * @param sContrato the sContrato to set
	 */
	public void setsContrato(String sContrato) {
		this.sContrato = sContrato;
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
	 * Obtiene serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/** The header. */
	private EncabezadoPeticion 	header;
}
