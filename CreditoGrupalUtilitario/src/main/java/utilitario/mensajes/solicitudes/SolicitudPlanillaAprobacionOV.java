package utilitario.mensajes.solicitudes;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SolicitudesOV.
 *
 * @author rguadarramac
 * @version 1.0
 */
public class SolicitudPlanillaAprobacionOV extends ObjetoValor {

	/**
	 * Instancia una nueva solicitudes ov.
	 */
	public SolicitudPlanillaAprobacionOV() {
	}
	/** Se genero serial. */
	private static final long serialVersionUID = 9096745766154723290L;

	/** The id planilla. */
	private String idPlanilla;

	/** The solicitud. */
	private String solicitud;

	/** The sucursal. */
	private String sucursal;

	/** The nombre sucursal. */
	private String nombreSucursal;

	/** The plazo. */
	private Integer plazo;

	/** The frecuencia. */
	private String frecuencia;

	/** The desc frecuencia. */
	private String descFrecuencia;

	/** The monto solicitado. */
	private Double montoSolicitado;

	/** The tasa. */
	private Double tasa;

	/** The ciclo grupo. */
	private Integer ciclo;

	/** The codigo producto. */
	private String codigoProducto;

	/** The desc producto. */
	private String descProducto;

	/** The campana. */
	private String campana;

	/** The nivel restriccion. */
	private String nivelRestriccion;

	/** The desc nivel restriccion. */
	private String descNivelRestriccion;

	/** The tipo sucursal. */
	private String tipoSucursal;

	/** The desc tipo sucursal. */
	private String descTipoSucursal;

	/** The verificacion telefonica. */
	private String verificacionTelefonica;

	/** The verificacion buro credito. */
	private String verificacionBuroCredito;

	/** The usuario buro credito. */
	private String usuarioBuroCredito;

	/** The json planilla. */
	private String jsonPlanilla;

	/** The id atomo. */
	private Integer idAtomo;

	/** The fecha hora. */
	private Date fechaHora;

	/** The status. */
	private String status;

	//Para la consulta de las solicitudes
	/** The atomo. */
	private String atomo;

	/** The link planilla. */
	private String linkPlanilla;

	/**
	 * Gets the id planilla.
	 *
	 * @return the idPlanilla
	 */
	public String getIdPlanilla() {
		return idPlanilla;
	}

	/**
	 * Sets the id planilla.
	 *
	 * @param idPlanilla the idPlanilla to set
	 */
	public void setIdPlanilla(String idPlanilla) {
		this.idPlanilla = idPlanilla;
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
	 * @param solicitud the solicitud to set
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	/**
	 * Gets the sucursal.
	 *
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * Sets the sucursal.
	 *
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Gets the nombre sucursal.
	 *
	 * @return the nombreSucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}

	/**
	 * Sets the nombre sucursal.
	 *
	 * @param nombreSucursal the nombreSucursal to set
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	/**
	 * Gets the plazo.
	 *
	 * @return the plazo
	 */
	public Integer getPlazo() {
		return plazo;
	}

	/**
	 * Sets the plazo.
	 *
	 * @param plazo the plazo to set
	 */
	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}

	/**
	 * Gets the frecuencia.
	 *
	 * @return the frecuencia
	 */
	public String getFrecuencia() {
		return frecuencia;
	}

	/**
	 * Sets the frecuencia.
	 *
	 * @param frecuencia the frecuencia to set
	 */
	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}

	/**
	 * Gets the desc frecuencia.
	 *
	 * @return the descFrecuencia
	 */
	public String getDescFrecuencia() {
		return descFrecuencia;
	}

	/**
	 * Sets the desc frecuencia.
	 *
	 * @param descFrecuencia the descFrecuencia to set
	 */
	public void setDescFrecuencia(String descFrecuencia) {
		this.descFrecuencia = descFrecuencia;
	}

	/**
	 * Gets the monto solicitado.
	 *
	 * @return the montoSolicitado
	 */
	public Double getMontoSolicitado() {
		return montoSolicitado;
	}

	/**
	 * Sets the monto solicitado.
	 *
	 * @param montoSolicitado the montoSolicitado to set
	 */
	public void setMontoSolicitado(Double montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
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
	 * @param tasa the tasa to set
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
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * Gets the codigo producto.
	 *
	 * @return the codigoProducto
	 */
	public String getCodigoProducto() {
		return codigoProducto;
	}

	/**
	 * Sets the codigo producto.
	 *
	 * @param codigoProducto the codigoProducto to set
	 */
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	/**
	 * Gets the desc producto.
	 *
	 * @return the descProducto
	 */
	public String getDescProducto() {
		return descProducto;
	}

	/**
	 * Sets the desc producto.
	 *
	 * @param descProducto the descProducto to set
	 */
	public void setDescProducto(String descProducto) {
		this.descProducto = descProducto;
	}

	/**
	 * Gets the campana.
	 *
	 * @return the campana
	 */
	public String getCampana() {
		return campana;
	}

	/**
	 * Sets the campana.
	 *
	 * @param campana the campana to set
	 */
	public void setCampana(String campana) {
		this.campana = campana;
	}

	/**
	 * Gets the nivel restriccion.
	 *
	 * @return the nivelRestriccion
	 */
	public String getNivelRestriccion() {
		return nivelRestriccion;
	}

	/**
	 * Sets the nivel restriccion.
	 *
	 * @param nivelRestriccion the nivelRestriccion to set
	 */
	public void setNivelRestriccion(String nivelRestriccion) {
		this.nivelRestriccion = nivelRestriccion;
	}

	/**
	 * Gets the desc nivel restriccion.
	 *
	 * @return the descNivelRestriccion
	 */
	public String getDescNivelRestriccion() {
		return descNivelRestriccion;
	}

	/**
	 * Sets the desc nivel restriccion.
	 *
	 * @param descNivelRestriccion the descNivelRestriccion to set
	 */
	public void setDescNivelRestriccion(String descNivelRestriccion) {
		this.descNivelRestriccion = descNivelRestriccion;
	}

	/**
	 * Gets the tipo sucursal.
	 *
	 * @return the tipoSucursal
	 */
	public String getTipoSucursal() {
		return tipoSucursal;
	}

	/**
	 * Sets the tipo sucursal.
	 *
	 * @param tipoSucursal the tipoSucursal to set
	 */
	public void setTipoSucursal(String tipoSucursal) {
		this.tipoSucursal = tipoSucursal;
	}

	/**
	 * Gets the desc tipo sucursal.
	 *
	 * @return the descTipoSucursal
	 */
	public String getDescTipoSucursal() {
		return descTipoSucursal;
	}

	/**
	 * Sets the desc tipo sucursal.
	 *
	 * @param descTipoSucursal the descTipoSucursal to set
	 */
	public void setDescTipoSucursal(String descTipoSucursal) {
		this.descTipoSucursal = descTipoSucursal;
	}

	/**
	 * Gets the verificacion telefonica.
	 *
	 * @return the verificacionTelefonica
	 */
	public String getVerificacionTelefonica() {
		return verificacionTelefonica;
	}

	/**
	 * Sets the verificacion telefonica.
	 *
	 * @param verificacionTelefonica the verificacionTelefonica to set
	 */
	public void setVerificacionTelefonica(String verificacionTelefonica) {
		this.verificacionTelefonica = verificacionTelefonica;
	}

	/**
	 * Gets the verificacion buro credito.
	 *
	 * @return the verificacionBuroCredito
	 */
	public String getVerificacionBuroCredito() {
		return verificacionBuroCredito;
	}

	/**
	 * Sets the verificacion buro credito.
	 *
	 * @param verificacionBuroCredito the verificacionBuroCredito to set
	 */
	public void setVerificacionBuroCredito(String verificacionBuroCredito) {
		this.verificacionBuroCredito = verificacionBuroCredito;
	}

	/**
	 * Gets the usuario buro credito.
	 *
	 * @return the usuarioBuroCredito
	 */
	public String getUsuarioBuroCredito() {
		return usuarioBuroCredito;
	}

	/**
	 * Sets the usuario buro credito.
	 *
	 * @param usuarioBuroCredito the usuarioBuroCredito to set
	 */
	public void setUsuarioBuroCredito(String usuarioBuroCredito) {
		this.usuarioBuroCredito = usuarioBuroCredito;
	}

	/**
	 * Gets the json planilla.
	 *
	 * @return the jsonPlanilla
	 */
	public String getJsonPlanilla() {
		return jsonPlanilla;
	}

	/**
	 * Sets the json planilla.
	 *
	 * @param jsonPlanilla the jsonPlanilla to set
	 */
	public void setJsonPlanilla(String jsonPlanilla) {
		this.jsonPlanilla = jsonPlanilla;
	}

	/**
	 * Gets the fecha hora.
	 *
	 * @return the fechaHora
	 */
	public Date getFechaHora() {
		return fechaHora;
	}

	/**
	 * Sets the fecha hora.
	 *
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the id atomo.
	 *
	 * @return the idAtomo
	 */
	public Integer getIdAtomo() {
		return idAtomo;
	}

	/**
	 * Sets the id atomo.
	 *
	 * @param idAtomo the idAtomo to set
	 */
	public void setIdAtomo(Integer idAtomo) {
		this.idAtomo = idAtomo;
	}

	/**
	 * Gets the atomo.
	 *
	 * @return the atomo
	 */
	public String getAtomo() {
		return atomo;
	}

	/**
	 * Sets the atomo.
	 *
	 * @param atomo the new atomo
	 */
	public void setAtomo(String atomo) {
		this.atomo = atomo;
	}

	/**
	 * Gets the link planilla.
	 *
	 * @return the link planilla
	 */
	public String getLinkPlanilla() {
		return linkPlanilla;
	}

	/**
	 * Sets the link planilla.
	 *
	 * @param linkPlanilla the new link planilla
	 */
	public void setLinkPlanilla(String linkPlanilla) {
		this.linkPlanilla = linkPlanilla;
	}

}
