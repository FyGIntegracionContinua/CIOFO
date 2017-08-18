package utilitario.mensajes.impresiondocs.oportunidapagare;

import utilitario.mensajes.comun.EncabezadoPeticion;

/**
 * The Class OportunidadPagarePeticion.
 */
public class OportunidadPagarePeticion {

	/**
	 * Instancia una nueva oportunidad pagare peticion.
	 */
	public OportunidadPagarePeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoPeticion 	header;

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

	/** The s contrato. */
	private String sContrato;
}
