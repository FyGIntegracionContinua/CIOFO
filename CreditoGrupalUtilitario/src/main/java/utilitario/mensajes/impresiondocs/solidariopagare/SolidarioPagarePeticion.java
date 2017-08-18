package utilitario.mensajes.impresiondocs.solidariopagare;

import utilitario.mensajes.comun.EncabezadoPeticion;

/**
 * The Class SolidarioPagarePeticion.
 */
public class SolidarioPagarePeticion {

	/**
	 * Instancia una nueva solidario pagare peticion.
	 */
	public SolidarioPagarePeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

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
	 * Obtiene serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/** The header. */
	private EncabezadoPeticion 	header;

	/** The s contrato. */
	private String sContrato;
}
