package utilitario.mensajes.burocredito;

import java.util.List;

import utilitario.mensajes.comun.ObjetoValor;

public class ValidaSolicitudPeticion  extends ObjetoValor {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 1254683688875287252L;

	/**
	 * solicitud
	 */
	private String solicitud;
	/**
	 * integrante
	 */
	private String integrante;
	/**
	 * antiguo
	 */
	private boolean antiguo;
	/**
	 * financiada
	 */
	private boolean ordinaria;
	/**
	 * montoSolicitado
	 */
	private double montoSolicitado;

	/**
	 * Renovacion financiada
	 */
	private boolean financiada;

	/**
	 * integrantes solicitud
	 */
	private List<IntegranteSolicitud> integrantes;
	/**
	 * integrantes descartados de la  solicitud
	 */
	private List<IntegranteSolicitud> integrantesDescarte;

	/** si es una renovacion cuantos integrantes son los mismos*/
	private int mismosIntegrantes;

	/** integrantes nuevos*/
	private int integrantesNuevos;

	/**dias mora*/
	private int diasMora;

	/**regersar respuesta*/
	private boolean regresaRespuesta;

	/**
	 * @return the solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}
	/**
	 * @param solicitud the solicitud to set
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}
	/**
	 * @return the integrantes
	 */
	public List<IntegranteSolicitud> getIntegrantes() {
		return integrantes;
	}
	/**
	 * @param integrantes the integrantes to set
	 */
	public void setIntegrantes(List<IntegranteSolicitud> integrantes) {
		this.integrantes = integrantes;
	}
	/**
	 * @return the integrantesDescarte
	 */
	public List<IntegranteSolicitud> getIntegrantesDescarte() {
		return integrantesDescarte;
	}
	/**
	 * @param integrantesDescarte the integrantesDescarte to set
	 */
	public void setIntegrantesDescarte(List<IntegranteSolicitud> integrantesDescarte) {
		this.integrantesDescarte = integrantesDescarte;
	}
	/**
	 * @return the integrante
	 */
	public String getIntegrante() {
		return integrante;
	}
	/**
	 * @param integrante the integrante to set
	 */
	public void setIntegrante(String integrante) {
		this.integrante = integrante;
	}
	/**
	 * @return the antiguo
	 */
	public boolean isAntiguo() {
		return antiguo;
	}
	/**
	 * @param antiguo the antiguo to set
	 */
	public void setAntiguo(boolean antiguo) {
		this.antiguo = antiguo;
	}
	/**
	 * @return the ordinaria
	 */
	public boolean isOrdinaria() {
		return ordinaria;
	}
	/**
	 * @param ordinaria the ordinaria to set
	 */
	public void setOrdinaria(boolean ordinaria) {
		this.ordinaria = ordinaria;
	}
	/**
	 * @return the montoSolicitado
	 */
	public double getMontoSolicitado() {
		return montoSolicitado;
	}
	/**
	 * @param montoSolicitado the montoSolicitado to set
	 */
	public void setMontoSolicitado(double montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}
	/**
	 * @return the financiada
	 */
	public boolean isFinanciada() {
		return financiada;
	}
	/**
	 * @param financiada the financiada to set
	 */
	public void setFinanciada(boolean financiada) {
		this.financiada = financiada;
	}
	/**
	 * @return the mismosIntegrantes
	 */
	public int getMismosIntegrantes() {
		return mismosIntegrantes;
	}
	/**
	 * @param mismosIntegrantes the mismosIntegrantes to set
	 */
	public void setMismosIntegrantes(int mismosIntegrantes) {
		this.mismosIntegrantes = mismosIntegrantes;
	}
	/**
	 * @return the integrantesNuevos
	 */
	public int getIntegrantesNuevos() {
		return integrantesNuevos;
	}
	/**
	 * @param integrantesNuevos the integrantesNuevos to set
	 */
	public void setIntegrantesNuevos(int integrantesNuevos) {
		this.integrantesNuevos = integrantesNuevos;
	}
	/**
	 * @return the diasMora
	 */
	public int getDiasMora() {
		return diasMora;
	}
	/**
	 * @param diasMora the diasMora to set
	 */
	public void setDiasMora(int diasMora) {
		this.diasMora = diasMora;
	}
	/**
	 * @return the regresaRespuesta
	 */
	public boolean isRegresaRespuesta() {
		return regresaRespuesta;
	}
	/**
	 * @param regresaRespuesta the regresaRespuesta to set
	 */
	public void setRegresaRespuesta(boolean regresaRespuesta) {
		this.regresaRespuesta = regresaRespuesta;
	}

}
