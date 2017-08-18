package utilitario.mensajes.administracion.contrato;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class RegistrarSolicitudReasignarCarteraPeticion.
 *
 * @author out_mreyes
 */
public 	class 	RegistrarSolicitudReasignarCarteraPeticion
		extends ObjetoValor {

	/** Es parte de la serializacion de la clase. */
	private static final long serialVersionUID = -6588843127501673608L;

	//Atributos de la clase  --------------------------------------------------------------------------------
	/** The folio solicitud. */
	private java.lang.Integer	folioSolicitud;

	/** The sucursal. */
	private java.lang.Integer	sucursal;

	/** The numero persona solicitud. */
	private java.lang.String	numeroPersonaSolicitud;

	/** The fecha solicitud. */
	private java.util.Date		fechaSolicitud;

	/** The fecha envio. */
	private java.util.Date		fechaEnvio;

	/** The observaciones. */
	private java.lang.String	observaciones;

	//Constructor  ------------------------------------------------------------------------------------------
	/**
	 * Instancia una nueva registrar solicitud reasignar cartera peticion.
	 */
	public RegistrarSolicitudReasignarCarteraPeticion()	{

		}

	//Getter and Setters ------------------------------------------------------------------------------------
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
	 * Obtiene fecha solicitud.
	 *
	 * @return the fechaSolicitud
	 */
	public java.util.Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	/**
	 * Establece fecha solicitud.
	 *
	 * @param fechaSolicitud the fechaSolicitud to set
	 */
	public void setFechaSolicitud(java.util.Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	/**
	 * Obtiene fecha envio.
	 *
	 * @return the fechaEnvio
	 */
	public java.util.Date getFechaEnvio() {
		return fechaEnvio;
	}

	/**
	 * Establece fecha envio.
	 *
	 * @param fechaEnvio the fechaEnvio to set
	 */
	public void setFechaEnvio(java.util.Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
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
