/**
 *
 */
package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class EliminacionCreditoPeticion.
 *
 * @author out_ltorres
 */
public class EliminacionCreditoPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva eliminacion credito peticion.
	 */
	public EliminacionCreditoPeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2491383714880519654L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The p contrato. */
	private String pContrato;

	/** The p usuario. */
	private String pUsuario;

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
	 * Obtiene p contrato.
	 *
	 * @return p contrato
	 */
	public String getpContrato() {
		return pContrato;
	}

	/**
	 * Establece p contrato.
	 *
	 * @param pContrato a p contrato
	 */
	public void setpContrato(String pContrato) {
		this.pContrato = pContrato;
	}

	/**
	 * Obtiene p usuario.
	 *
	 * @return p usuario
	 */
	public String getpUsuario() {
		return pUsuario;
	}

	/**
	 * Establece p usuario.
	 *
	 * @param pUsuario a p usuario
	 */
	public void setpUsuario(String pUsuario) {
		this.pUsuario = pUsuario;
	}

}
