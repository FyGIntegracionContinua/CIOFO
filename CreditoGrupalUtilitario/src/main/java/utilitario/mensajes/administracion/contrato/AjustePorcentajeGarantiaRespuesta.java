package utilitario.mensajes.administracion.contrato;

import utilitario.mensajes.comun.EncabezadoRespuesta;

public class AjustePorcentajeGarantiaRespuesta {
	/**
	 * AjustePorcentajeGarantia.
	 */
	public AjustePorcentajeGarantiaRespuesta() {

	}

	/** String contrato. */
	private String contrato;

	/** String usuario. */
	private String usuario;

	/** String porcentajeGarantia */
	private String porcentajeGarantia;

	/** EncabezadoRespuesta header. */
	private EncabezadoRespuesta 	header;

	/**
	 * Obtiene contrato.
	 *
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * Obtiene usuario.
	 *
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Obtiene porcentaje Garantia
	 *
	 * @return the porcentajeGarantia
	 */
	public String getPorcentajeGarantia() {
		return porcentajeGarantia;
	}

	/**
	 * Obtiene header.
	 *
	 * @return getHeader :
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece contrato.
	 *
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * Establece porcentajeGarantia
	 *
	 * @param porcentajeGarantia the porcentajeGarantia to set
	 */
	public void setPorcentajeGarantia(String porcentajeGarantia) {
		this.porcentajeGarantia = porcentajeGarantia;
	}

	/**
	 * Establece usuario.
	 *
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Establece header.
	 *
	 * @param header setHeader :
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}
}
