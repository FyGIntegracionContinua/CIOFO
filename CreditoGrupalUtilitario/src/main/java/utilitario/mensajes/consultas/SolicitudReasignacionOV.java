
package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author out_oarias
 *
 */
public 	class 	SolicitudReasignacionOV	extends ObjetoValor {
	/**
	 * UID para la serializacion
	 */
	private static final long serialVersionUID = 5339094097640348053L;
	// Atributos privados  -------------------------------------------------------------------------------
	/**
	 * fechaEnvio java.util.Date
	 */
	private java.util.Date		fechaEnvio;
	/**
	 * folioSolicitud java.lang.Integer
	 */
	private java.lang.Integer	folioSolicitud;
	/**
	 * sucursal java.lang.String
	 */
	private java.lang.String	sucursal;
	/**
	 * zona java.lang.Integer
	 */
	private java.lang.Integer	zona;
	/**
	 * usuarioAutoriza java.lang.String
	 */
	private java.lang.String	usuarioAutoriza;
	/**
	 * tiempoTranscurrido java.lang.String
	 */
	private java.lang.String	tiempoTranscurrido;
	/**
	 * estatus java.lang.String
	 */
	private java.lang.String 	estatus;

	// Constructor  --------------------------------------------------------------------------------------
	/**
	 * SolicitudReasignacionOV
	 */
	public SolicitudReasignacionOV() {
		}

	// Set y Get  ----------------------------------------------------------------------------------------
	/**
	 * @return the fechaEnvio
	 */
	public java.util.Date getFechaEnvio() {
		return fechaEnvio;
	}

	/**
	 * @param fechaEnvio the fechaEnvio to set
	 */
	public void setFechaEnvio(java.util.Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}

	/**
	 * @return the folioSolicitud
	 */
	public java.lang.Integer getFolioSolicitud() {
		return folioSolicitud;
	}

	/**
	 * @param folioSolicitud the folioSolicitud to set
	 */
	public void setFolioSolicitud(java.lang.Integer folioSolicitud) {
		this.folioSolicitud = folioSolicitud;
	}

	/**
	 * @return the sucursal
	 */
	public java.lang.String getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(java.lang.String sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * @return the zona
	 */
	public java.lang.Integer getZona() {
		return zona;
	}

	/**
	 * @param zona the zona to set
	 */
	public void setZona(java.lang.Integer zona) {
		this.zona = zona;
	}

	/**
	 * @return the usuarioAutoriza
	 */
	public java.lang.String getUsuarioAutoriza() {
		return usuarioAutoriza;
	}

	/**
	 * @param usuarioAutoriza the usuarioAutoriza to set
	 */
	public void setUsuarioAutoriza(java.lang.String usuarioAutoriza) {
		this.usuarioAutoriza = usuarioAutoriza;
	}

	/**
	 * @return the diasTranscurridos
	 */
	public java.lang.String getTiempoTranscurrido() {
		return tiempoTranscurrido;
	}

	/**
	 * @param tiempoTranscurrido the diasTranscurridos to set
	 */
	public void setTiempoTranscurrido(java.lang.String tiempoTranscurrido) {
		this.tiempoTranscurrido = tiempoTranscurrido;
	}

	/**
	 * @return the estatus
	 */
	public java.lang.String getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(java.lang.String estatus) {
		this.estatus = estatus;
	}

}
