package utilitario.mensajes.persona;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

public class ValidarCurpPersonaRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva datos imagenes monitor respuesta.
	 */
	public ValidarCurpPersonaRespuesta() {
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5861028477916952896L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The curp. */
	private String curp;

	/**
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

}

