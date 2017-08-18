package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class PlanillaObservacionesOV.
 *
 * @author rguadarramac
 * @version 1.0
 */
public class CabeceraPlanillaAprobacionOV extends ObjetoValor {

	/**
	 * Instancia una nueva planilla observaciones ov.
	 */
	public CabeceraPlanillaAprobacionOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5545559313223431089L;

	/** The solicitud. */
	private String solicitud;

	/** The sucursal. */
	private String sucursal;

	/** The nombre sucursal. */
	private String nombreSucursal;

	/** The nombre grupo. */
	private String nombreGrupo;

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

	/** The cod campana. */
	private String codigoCampana;

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

	/** The status. */
	private String status;

	/** The usuario cec. */
	private String usuarioCec;

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
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * @return the nombreSucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}

	/**
	 * @param nombreSucursal the nombreSucursal to set
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
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
	 * @return the descFrecuencia
	 */
	public String getDescFrecuencia() {
		return descFrecuencia;
	}

	/**
	 * @param descFrecuencia the descFrecuencia to set
	 */
	public void setDescFrecuencia(String descFrecuencia) {
		this.descFrecuencia = descFrecuencia;
	}

	/**
	 * @return the montoSolicitado
	 */
	public Double getMontoSolicitado() {
		return montoSolicitado;
	}

	/**
	 * @param montoSolicitado the montoSolicitado to set
	 */
	public void setMontoSolicitado(Double montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}

	/**
	 * @return the tasa
	 */
	public Double getTasa() {
		return tasa;
	}

	/**
	 * @param tasa the tasa to set
	 */
	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}

	/**
	 * @return the ciclo
	 */
	public Integer getCiclo() {
		return ciclo;
	}

	/**
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * @return the codigoProducto
	 */
	public String getCodigoProducto() {
		return codigoProducto;
	}

	/**
	 * @param codigoProducto the codigoProducto to set
	 */
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	/**
	 * @return the descProducto
	 */
	public String getDescProducto() {
		return descProducto;
	}

	/**
	 * @param descProducto the descProducto to set
	 */
	public void setDescProducto(String descProducto) {
		this.descProducto = descProducto;
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

	/**
	 * @return the nivelRestriccion
	 */
	public String getNivelRestriccion() {
		return nivelRestriccion;
	}

	/**
	 * @param nivelRestriccion the nivelRestriccion to set
	 */
	public void setNivelRestriccion(String nivelRestriccion) {
		this.nivelRestriccion = nivelRestriccion;
	}

	/**
	 * @return the descNivelRestriccion
	 */
	public String getDescNivelRestriccion() {
		return descNivelRestriccion;
	}

	/**
	 * @param descNivelRestriccion the descNivelRestriccion to set
	 */
	public void setDescNivelRestriccion(String descNivelRestriccion) {
		this.descNivelRestriccion = descNivelRestriccion;
	}

	/**
	 * @return the tipoSucursal
	 */
	public String getTipoSucursal() {
		return tipoSucursal;
	}

	/**
	 * @param tipoSucursal the tipoSucursal to set
	 */
	public void setTipoSucursal(String tipoSucursal) {
		this.tipoSucursal = tipoSucursal;
	}

	/**
	 * @return the descTipoSucursal
	 */
	public String getDescTipoSucursal() {
		return descTipoSucursal;
	}

	/**
	 * @param descTipoSucursal the descTipoSucursal to set
	 */
	public void setDescTipoSucursal(String descTipoSucursal) {
		this.descTipoSucursal = descTipoSucursal;
	}

	/**
	 * @return the verificacionTelefonica
	 */
	public String getVerificacionTelefonica() {
		return verificacionTelefonica;
	}

	/**
	 * @param verificacionTelefonica the verificacionTelefonica to set
	 */
	public void setVerificacionTelefonica(String verificacionTelefonica) {
		this.verificacionTelefonica = verificacionTelefonica;
	}

	/**
	 * @return the verificacionBuroCredito
	 */
	public String getVerificacionBuroCredito() {
		return verificacionBuroCredito;
	}

	/**
	 * @param verificacionBuroCredito the verificacionBuroCredito to set
	 */
	public void setVerificacionBuroCredito(String verificacionBuroCredito) {
		this.verificacionBuroCredito = verificacionBuroCredito;
	}

	/**
	 * @return the nombreGrupo
	 */
	public String getNombreGrupo() {
		return nombreGrupo;
	}

	/**
	 * @param nombreGrupo the nombreGrupo to set
	 */
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	/**
	 * @return the plazo
	 */
	public Integer getPlazo() {
		return plazo;
	}

	/**
	 * @param plazo the plazo to set
	 */
	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
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

	/**
	 * @return the usuarioCec
	 */
	public String getUsuarioCec() {
		return usuarioCec;
	}

	/**
	 * @param usuarioCec the usuarioCec to set
	 */
	public void setUsuarioCec(String usuarioCec) {
		this.usuarioCec = usuarioCec;
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
