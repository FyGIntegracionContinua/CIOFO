package utilitario.mensajes.burocredito;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

public class ConsultaBuroRespuesta extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2838848722408087399L;

	/** The header. */
	private EncabezadoRespuesta header;

	/**
	 * buroCreditoXML
	 */
	private String buroCreditoXML;
	/**
	 * diasConsulta
	 */
	private int diasConsulta;
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
	 * @return the buroCreditoXML
	 */
	public String getBuroCreditoXML() {
		return buroCreditoXML;
	}

	/**
	 * @param buroCreditoXML the buroCreditoXML to set
	 */
	public void setBuroCreditoXML(String buroCreditoXML) {
		this.buroCreditoXML = buroCreditoXML;
	}

	/**
	 * @return the diasConsulta
	 */
	public int getDiasConsulta() {
		return diasConsulta;
	}

	/**
	 * @param diasConsulta the diasConsulta to set
	 */
	public void setDiasConsulta(int diasConsulta) {
		this.diasConsulta = diasConsulta;
	}

}
