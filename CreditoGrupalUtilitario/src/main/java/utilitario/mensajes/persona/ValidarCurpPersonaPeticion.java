package utilitario.mensajes.persona;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

public class ValidarCurpPersonaPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva datos imagenes monitor peticion.
	 */
	public ValidarCurpPersonaPeticion() {
	}

	/**
	 *
	 */
	private static final long serialVersionUID = -8823719270745238950L;


	/** The header. */
	private EncabezadoPeticion header;

	/** The rfc. */
	private String rfc;

	/** The curp. */
	private String curp;

	/** The sexo. */
	private String sexo;

	/** The estado. */
	private String estado;

	/**
	 * @return the header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}

	/**
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
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

	/**
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

}
