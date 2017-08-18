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
public class RespuestaSolicitudTasasOV extends ObjetoValor {

	/**
	 * Instantiates a new validar solicitud peticion.
	 */
	public RespuestaSolicitudTasasOV() {
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5677000937229085332L;

	/** The solicitud. */
	private String solicitud;

	/** The contrato. */
	private String contrato;

	/** The campana. */
	private boolean campana;

	/** The renovacion. */
	private boolean renovacion;

	/** The tasa. */
	private Double tasa;

	/** The ciclo. */
	private Integer ciclo;

	/** The numero integrantes. */
	private Integer numeroIntegrantes;
	
	/**descripcion de campañas*/
	private String campanaDescripcion;

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
	 * Gets the campana.
	 *
	 * @return the campana
	 */
	public boolean getCampana() {
		return campana;
	}

	/**
	 * Sets the campana.
	 *
	 * @param campana the new campana
	 */
	public void setCampana(boolean campana) {
		this.campana = campana;
	}

	/**
	 * Gets the renovacion.
	 *
	 * @return the renovacion
	 */
	public boolean getRenovacion() {
		return renovacion;
	}

	/**
	 * Sets the renovacion.
	 *
	 * @param renovacion the new renovacion
	 */
	public void setRenovacion(boolean renovacion) {
		this.renovacion = renovacion;
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
	 * Gets the ciclo.
	 *
	 * @return the ciclo
	 */
	public Integer getCiclo() {
		return ciclo;
	}

	/**
	 * Sets the ciclo.
	 *
	 * @param ciclo the new ciclo
	 */
	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * Gets the contrato.
	 *
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * Sets the contrato.
	 *
	 * @param contrato the new contrato
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * Gets the numero integrantes.
	 *
	 * @return the numero integrantes
	 */
	public Integer getNumeroIntegrantes() {
		return numeroIntegrantes;
	}

	/**
	 * Sets the numero integrantes.
	 *
	 * @param numeroIntegrantes the new numero integrantes
	 */
	public void setNumeroIntegrantes(Integer numeroIntegrantes) {
		this.numeroIntegrantes = numeroIntegrantes;
	}

	/**
	 * @return the campanaDescripcion
	 */
	public String getCampanaDescripcion() {
		return campanaDescripcion;
	}

	/**
	 * @param campanaDescripcion the campanaDescripcion to set
	 */
	public void setCampanaDescripcion(String campanaDescripcion) {
		this.campanaDescripcion = campanaDescripcion;
	}

}
