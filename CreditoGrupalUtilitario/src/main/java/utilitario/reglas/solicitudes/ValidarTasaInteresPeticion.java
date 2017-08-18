/**
 *
 */
package utilitario.reglas.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultarPersonaRespuesta.
 *
 * @author rguadarrama
 */
public 	class 	ValidarTasaInteresPeticion extends ObjetoValor {

	/**
	 * Instantiates a new validar solicitud peticion.
	 */
	public ValidarTasaInteresPeticion() {
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5677000937229085332L;

	/** The renovacion. */
	private Boolean renovacion;

	/** The campana. */
	private Boolean campana;

	/** The central cec. */
	private Boolean centralCec;

	/** The contrato anterior. */
	private String contratoAnterior;

	/** The solicitud. */
	private String solicitud;

	/** The tasa. */
	private Double tasa;

	/** The integrantes. */
	private int integrantes;
	
	/** monto grupal del credito */
	private Double montoGrupal;

	/**tasa anual de la empresa origen*/
	private Double tasaEmpresaOrigen;
	
	/**ciclo del grupo*/
	private int ciclo;
	/**codigo de la campaña*/
	private String codigoCampana;

	/**
	 * Checks if is renovacion.
	 *
	 * @return true, if is renovacion
	 */
	public Boolean getRenovacion() {
		return renovacion;
	}

	/**
	 * Sets the renovacion.
	 *
	 * @param renovacion the new renovacion
	 */
	public void setRenovacion(Boolean renovacion) {
		this.renovacion = renovacion;
	}

	/**
	 * Checks if is campana.
	 *
	 * @return true, if is campana
	 */
	public Boolean getCampana() {
		return campana;
	}

	/**
	 * Sets the campana.
	 *
	 * @param campana the new campana
	 */
	public void setCampana(Boolean campana) {
		this.campana = campana;
	}

	/**
	 * Checks if is central cec.
	 *
	 * @return true, if is central cec
	 */
	public Boolean getCentralCec() {
		return centralCec;
	}

	/**
	 * Sets the central cec.
	 *
	 * @param centralCec the new central cec
	 */
	public void setCentralCec(Boolean centralCec) {
		this.centralCec = centralCec;
	}

	/**
	 * Gets the contrato anterior.
	 *
	 * @return the contrato anterior
	 */
	public String getContratoAnterior() {
		return contratoAnterior;
	}

	/**
	 * Sets the contrato anterior.
	 *
	 * @param contratoAnterior the new contrato anterior
	 */
	public void setContratoAnterior(String contratoAnterior) {
		this.contratoAnterior = contratoAnterior;
	}

	/**
	 * Gets the solicitud.
	 *
	 * @return the solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}

	/**
	 * Sets the solicitud.
	 *
	 * @param solicitud the new solicitud
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	/**
	 * Gets the tasa.
	 *
	 * @return the tasa
	 */
	public Double getTasa() {
		return tasa;
	}

	/**
	 * Sets the tasa.
	 *
	 * @param tasa the new tasa
	 */
	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}

	/**
	 * @return the integrantes
	 */
	public int getIntegrantes() {
		return integrantes;
	}

	/**
	 * @param integrantes the integrantes to set
	 */
	public void setIntegrantes(int integrantes) {
		this.integrantes = integrantes;
	}
	
	/**
	 * @return the montoGrupal
	 */
	public Double getMontoGrupal() {
		return montoGrupal;
	}

	/**
	 * @param montoGrupal the montoGrupal to set
	 */
	public void setMontoGrupal(Double montoGrupal) {
		this.montoGrupal = montoGrupal;
	}

	/**
	 * @return the tasaEmpresaOrigen
	 */
	public Double getTasaEmpresaOrigen() {
		return tasaEmpresaOrigen;
	}

	/**
	 * @param tasaEmpresaOrigen the tasaEmpresaOrigen to set
	 */
	public void setTasaEmpresaOrigen(Double tasaEmpresaOrigen) {
		this.tasaEmpresaOrigen = tasaEmpresaOrigen;
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
	 * @return the codigoCampana
	 */
	public String getCodigoCampana() {
		return codigoCampana;
	}

	/**
	 * @param codigoCampana the codigoCampana to set
	 */
	public void setCodigoCampana(String codigoCampana) {
		this.codigoCampana = codigoCampana;
	}

}
