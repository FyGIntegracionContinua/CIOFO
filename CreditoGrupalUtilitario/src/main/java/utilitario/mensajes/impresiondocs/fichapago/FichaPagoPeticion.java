package utilitario.mensajes.impresiondocs.fichapago;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class FichaPagoEspecialPeticion.
 */
public class FichaPagoPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva ficha pago especial peticion.
	 */
	public FichaPagoPeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/** The header. */
	private EncabezadoPeticion 	header;

	/** The contrato. */
	private String contrato;

	/** Numero de contrato*/
	private String numContrato;

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
	 * Gets the contrato.
	 *
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * Sets the contrato.
	 *
	 * @param contrato the new contrato
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * @return the numContrato
	 */
	public String getNumContrato() {
		return numContrato;
	}

	/**
	 * @param numContrato the numContrato to set
	 */
	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}


}
