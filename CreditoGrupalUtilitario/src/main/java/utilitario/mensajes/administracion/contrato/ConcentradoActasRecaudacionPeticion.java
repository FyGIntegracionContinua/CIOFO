package utilitario.mensajes.administracion.contrato;

import java.io.Serializable;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConcentradoActasRecaudacionPeticion.
 */
public class ConcentradoActasRecaudacionPeticion extends ObjetoValor implements Serializable {

	/**
	 * Instancia una nueva concentrado actas recaudacion peticion.
	 */
	public ConcentradoActasRecaudacionPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4746370599137668826L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The contrato. */
	private String contrato;

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Establece contrato.
	 *
	 * @param contrato a contrato
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * Obtiene contrato.
	 *
	 * @return contrato
	 */
	public String getContrato() {
		return contrato;
	}


}
