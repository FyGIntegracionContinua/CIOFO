package utilitario.mensajes.administracion.contrato;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ActualizarSolicitudReasignarCarteraPeticion.
 *
 * @author out_mreyes
 */
public 	class 	ActualizarSolicitudReasignarCarteraPeticion extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2281839409260707426L;

	//Atributos privados  -----------------------------------------------------------------------------
	/** The folio solicitud. */
	private java.lang.Integer	folioSolicitud;

	/** The sucursal. */
	private java.lang.Integer	sucursal;

	/** The numero persona solicitud. */
	private java.lang.String	numeroPersonaSolicitud;

	/** The fecha reenvio. */
	private java.util.Date		fechaReenvio;

	/** The observaciones. */
	private java.lang.String	observaciones;

	/** The fecha resolucion. */
	private java.util.Date		fechaResolucion;

	/** The status. */
	private java.lang.String	status;

	//Cosntructor  ------------------------------------------------------------------------------------
	/**
	 * Instancia una nueva actualizar solicitud reasignar cartera peticion.
	 */
	public ActualizarSolicitudReasignarCarteraPeticion() {

		}

	//Atributos set - get
	/**
	 * Obtiene fecha resolucion.
	 *
	 * @return the fechaResolucion
	 */
	public java.util.Date getFechaResolucion() {
		return fechaResolucion;
	}

	/**
	 * Establece fecha resolucion.
	 *
	 * @param fechaResolucion the fechaResolucion to set
	 */
	public void setFechaResolucion(java.util.Date fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	/**
	 * Obtiene status.
	 *
	 * @return the status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Establece status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Obtiene folio solicitud.
	 *
	 * @return the folioSolicitud
	 */
	public java.lang.Integer getFolioSolicitud() {
		return folioSolicitud;
	}

	/**
	 * Establece folio solicitud.
	 *
	 * @param folioSolicitud the folioSolicitud to set
	 */
	public void setFolioSolicitud(java.lang.Integer folioSolicitud) {
		this.folioSolicitud = folioSolicitud;
	}

	/**
	 * Obtiene sucursal.
	 *
	 * @return the sucursal
	 */
	public java.lang.Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(java.lang.Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene numero persona solicitud.
	 *
	 * @return the numeroPersonaSolicitud
	 */
	public java.lang.String getNumeroPersonaSolicitud() {
		return numeroPersonaSolicitud;
	}

	/**
	 * Establece numero persona solicitud.
	 *
	 * @param numeroPersonaSolicitud the numeroPersonaSolicitud to set
	 */
	public void setNumeroPersonaSolicitud(java.lang.String numeroPersonaSolicitud) {
		this.numeroPersonaSolicitud = numeroPersonaSolicitud;
	}

	/**
	 * Obtiene fecha reenvio.
	 *
	 * @return the fechaRenvio
	 */
	public java.util.Date getFechaReenvio() {
		return fechaReenvio;
	}

	/**
	 * Establece fecha reenvio.
	 *
	 * @param fechaReenvio a fecha reenvio
	 */
	public void setFechaReenvio(java.util.Date fechaReenvio) {
		this.fechaReenvio = fechaReenvio;
	}

	/**
	 * Obtiene observaciones.
	 *
	 * @return the observaciones
	 */
	public java.lang.String getObservaciones() {
		return observaciones;
	}

	/**
	 * Establece observaciones.
	 *
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(java.lang.String observaciones) {
		this.observaciones = observaciones;
	}

}
