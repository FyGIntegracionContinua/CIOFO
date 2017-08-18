package utilitario.reglas.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

public class ValidarIntegranteSolicitudPeticion extends ObjetoValor {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -1848743620433057703L;

	/** Numero persona **/
	private String persona;
	/** fecha desembolso de la solicitud **/
	private java.util.Date fechaDesembolso;
	/** producto de la frecuencia **/
	private String frecuencia;
	/** plazo de la solicitud **/
	private int plazoSolicitud;
	/** Si desea seguro Vida **/
	private boolean seguroVida;
	/** Si desea seguro Enfermedad **/
	private boolean seguroEnfermedad;
	/** Monto Solicitada **/
	private double montoSolicitado;
	/** usuario **/
	private String usuario;
	/** plazoSeguro **/
	private String plazoSeguro;
	/** sucursal **/
	private int sucursal;
	/** ciclo del grupo*/
	private int ciclo;
	/**capaña de la solicitud*/
	private String campana;
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
	 * @return the fechaDesembolso
	 */
	public java.util.Date getFechaDesembolso() {
		return fechaDesembolso;
	}
	/**
	 * @param fechaDesembolso the fechaDesembolso to set
	 */
	public void setFechaDesembolso(java.util.Date fechaDesembolso) {
		this.fechaDesembolso = fechaDesembolso;
	}
	/**
	 * @return the plazoSolicitud
	 */
	public int getPlazoSolicitud() {
		return plazoSolicitud;
	}
	/**
	 * @param plazoSolicitud the plazoSolicitud to set
	 */
	public void setPlazoSolicitud(int plazoSolicitud) {
		this.plazoSolicitud = plazoSolicitud;
	}
	/**
	 * @return the seguroVida
	 */
	public boolean isSeguroVida() {
		return seguroVida;
	}
	/**
	 * @param seguroVida the seguroVida to set
	 */
	public void setSeguroVida(boolean seguroVida) {
		this.seguroVida = seguroVida;
	}
	/**
	 * @return the seguroEnfermedad
	 */
	public boolean isSeguroEnfermedad() {
		return seguroEnfermedad;
	}
	/**
	 * @param seguroEnfermedad the seguroEnfermedad to set
	 */
	public void setSeguroEnfermedad(boolean seguroEnfermedad) {
		this.seguroEnfermedad = seguroEnfermedad;
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
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the plazoSeguro
	 */
	public String getPlazoSeguro() {
		return plazoSeguro;
	}
	/**
	 * @param plazoSeguro the plazoSeguro to set
	 */
	public void setPlazoSeguro(String plazoSeguro) {
		this.plazoSeguro = plazoSeguro;
	}
	/**
	 * @return the sucursal
	 */
	public int getSucursal() {
		return sucursal;
	}
	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}
	/**
	 * @return the frecuencia
	 */
	public String getFrecuencia() {
		return frecuencia;
	}
	/**
	 * @param frecuencia the frecuencia to set
	 */
	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}

	/**
	 * @return the ciclo
	 */
	public int getCiclo() {
		return ciclo;
	}
	/**
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}
	/**
	 * @return the campana
	 */
	public String getCampana() {
		return campana;
	}
	/**
	 * @param campana the campana to set
	 */
	public void setCampana(String campana) {
		this.campana = campana;
	}
}
