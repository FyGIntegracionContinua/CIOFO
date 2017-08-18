package utilitario.reglas.solicitudes;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

public class ValidaIntegranteRespuesta extends ObjetoValor {

	/**
	 * constructor
	 */
	public ValidaIntegranteRespuesta() {

	}
	/**
	 * serial
	 */
	private static final long serialVersionUID = -3379234138814783034L;

	/**
	 * EncabezadoRespuesta header
	 */
	private EncabezadoRespuesta header;

	/**
	 * reglaError
	 */
	private String reglaError;

	/**
	 * montoMinimo
	 */
	private double montoMinimo;

	/**
	 * montoMaximo
	 */
	private double montoMaximo;

	/**
	 * datosIntegrante
	 */
	private ValidaIntegranteDTO datosIntegrante;
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
	 * @return the reglaError
	 */
	public String getReglaError() {
		return reglaError;
	}

	/**
	 * @param reglaError the reglaError to set
	 */
	public void setReglaError(String reglaError) {
		this.reglaError = reglaError;
	}

	/**
	 * @return the montoMinimo
	 */
	public double getMontoMinimo() {
		return montoMinimo;
	}

	/**
	 * @param montoMinimo the montoMinimo to set
	 */
	public void setMontoMinimo(double montoMinimo) {
		this.montoMinimo = montoMinimo;
	}

	/**
	 * @return the montoMaximo
	 */
	public double getMontoMaximo() {
		return montoMaximo;
	}

	/**
	 * @param montoMaximo the montoMaximo to set
	 */
	public void setMontoMaximo(double montoMaximo) {
		this.montoMaximo = montoMaximo;
	}

	/**
	 * @return the datosIntegrante
	 */
	public ValidaIntegranteDTO getDatosIntegrante() {
		return datosIntegrante;
	}

	/**
	 * @param datosIntegrante the datosIntegrante to set
	 */
	public void setDatosIntegrante(ValidaIntegranteDTO datosIntegrante) {
		this.datosIntegrante = datosIntegrante;
	}

}
