/**
 *
 */
package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ca.ocampo
 *
 */
public class Referencias extends ObjetoValor {

	/**
	 * long serialVersionUID Referencias.java
	 */
	private static final long serialVersionUID = -4996411421890647574L;

	/**
	 * String contrato
	 */
	private String contrato;

	/**
	 * String persona
	 */
	private String persona;

	/**
	 * String tipoProducto
	 */
	private String tipoProducto;

	/**
	 * String cliente
	 */
	private String claveCliente;

	/**
	 * String referencia
	 */
	private String referencia;

	/**
	 * String fechaHora
	 */
	private String fechaHora;

	/**
	 * String status
	 */
	private String status;

	/**
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * @return the persona
	 */
	public String getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(String persona) {
		this.persona = persona;
	}

	/**
	 * @return the tipoProducto
	 */
	public String getTipoProducto() {
		return tipoProducto;
	}

	/**
	 * @param tipoProducto the tipoProducto to set
	 */
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}

	/**
	 * @return the claveCliente
	 */
	public String getClaveCliente() {
		return claveCliente;
	}

	/**
	 * @param claveCliente the claveCliente to set
	 */
	public void setClaveCliente(String claveCliente) {
		this.claveCliente = claveCliente;
	}

	/**
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}

	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	/**
	 * @return the fechaHora
	 */
	public String getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}
