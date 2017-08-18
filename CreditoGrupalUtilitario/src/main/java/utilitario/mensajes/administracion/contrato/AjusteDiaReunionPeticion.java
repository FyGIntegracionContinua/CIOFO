package utilitario.mensajes.administracion.contrato;

import java.io.Serializable;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AjusteDiaReunionPeticion.
 */
public 	class 	AjusteDiaReunionPeticion extends ObjetoValor implements Serializable {

	/**
	 * Instancia una nueva ajuste dia reunion peticion.
	 */
	public AjusteDiaReunionPeticion() {
	}
	/** UID para serializacion. */
	private static final long serialVersionUID = -8706067394582127925L;

	/** The header. */
	private EncabezadoPeticion 	header;

	/** The contrato. */
	private java.lang.String	contrato;

	/** The dia reunion. */
	private java.lang.Integer 	diaReunion;

	/** The hora reunion. */
	private java.lang.String 	horaReunion;

	/** The usuario. */
	private java.lang.String 	usuario;


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

	/**
	 * Establece dia reunion.
	 *
	 * @param diaReunion a dia reunion
	 */
	public void setDiaReunion(Integer diaReunion) {
		this.diaReunion = diaReunion;
	}

	/**
	 * Obtiene dia reunion.
	 *
	 * @return dia reunion
	 */
	public Integer getDiaReunion() {
		return diaReunion;
	}

	/**
	 * Establece usuario.
	 *
	 * @param usuario a usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Obtiene usuario.
	 *
	 * @return usuario
	 */
	public String getUsuario() {
		return usuario;
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
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Obtiene hora reunion.
	 *
	 * @return the horaReunion
	 */
	public java.lang.String getHoraReunion() {
		return horaReunion;
	}

	/**
	 * Establece hora reunion.
	 *
	 * @param horaReunion the horaReunion to set
	 */
	public void setHoraReunion(java.lang.String horaReunion) {
		this.horaReunion = horaReunion;
	}

}
