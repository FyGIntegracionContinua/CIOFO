/**
 *
 */
package utilitario.mensajes.persona;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author out_mreyes@independencia.com.mx
 *
 */
public 	class 	TelefonoOV extends ObjetoValor {
	/**
	 * UID para la serializacion
	 */
	private static final long serialVersionUID = -5904533115607696386L;

	// Atributos  -----------------------------------------------------------------------
	/**
	 * numeroPersona java.lang.String
	 */
	private java.lang.String			numeroPersona;
	/**
	 * tipoTelefono java.lang.String
	 */
	private java.lang.String			tipoTelefono;
	/**
	 * status java.lang.String
	 */
	private java.lang.String			status;
	/**
	 * lada java.lang.String
	 */
	private java.lang.String			lada;
	/**
	 * telefono java.lang.String
	 */
	private java.lang.String			telefono;
	/**
	 * codigoResolucion java.lang.String
	 */
	private java.lang.String			codigoResolucion;
	/**
	 * fechaAlta java.util.Date
	 */
	private java.util.Date				fechaAlta;
	/**
	 * usuarioAlta java.lang.String
	 */
	private java.lang.String			usuarioAlta;
	/**
	 * fechaUltimaModificacion java.util.Date
	 */
	private java.util.Date				fechaUltimaModificacion;
	/**
	 * usuarioModificacion java.lang.String
	 */
	private java.lang.String			usuarioModificacion;
	/**
	 * fechaUltimaVerificacion java.util.Date
	 */
	private java.util.Date				fechaUltimaVerificacion;
	/**
	 * lugar java.lang.String
	 */
	private java.lang.String			lugar;
	/**
	 * origen java.lang.String
	 */
	private java.lang.String			origen;
	/**
	 * fechaStatus java.util.Date
	 */
	private java.util.Date				fechaStatus;
	/**
	 * fechaContacto java.util.Date
	 */
	private java.util.Date				fechaContacto;
	/**
	 * consecutivo java.lang.Integer
	 */
	private java.lang.Integer 			consecutivo;
	/**
	 * tipoPlan java.lang.String
	 */
	private java.lang.String			tipoPlan;
	/**
	 * proveedorServicio java.lang.String
	 */
	private java.lang.String			proveedorServicio;
	/**
	 * idRelacion java.lang.Integer
	 */
	private java.lang.Integer 			idRelacion;


	/**
	 * actualizar Boolean
	 */
	private Boolean actualizar;

	// Constructor  ---------------------------------------------------------------------
	/**
	 * TelefonoOV
	 */
	public TelefonoOV() {

	}



	/**
	 * @return the numeroPersona
	 */
	public java.lang.String getNumeroPersona() {
		return numeroPersona;
	}



	/**
	 * @param numeroPersona the numeroPersona to set
	 */
	public void setNumeroPersona(java.lang.String numeroPersona) {
		this.numeroPersona = numeroPersona;
	}



	/**
	 * @return the tipoTelefono
	 */
	public java.lang.String getTipoTelefono() {
		return tipoTelefono;
	}

	/**
	 * @param tipoTelefono the tipoTelefono to set
	 */
	public void setTipoTelefono(java.lang.String tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}

	/**
	 * @return the status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * @return the lada
	 */
	public java.lang.String getLada() {
		return lada;
	}

	/**
	 * @param lada the lada to set
	 */
	public void setLada(java.lang.String lada) {
		this.lada = lada;
	}

	/**
	 * @return the telefono
	 */
	public java.lang.String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(java.lang.String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the codigoResolucion
	 */
	public java.lang.String getCodigoResolucion() {
		return codigoResolucion;
	}

	/**
	 * @param codigoResolucion the codigoResolucion to set
	 */
	public void setCodigoResolucion(java.lang.String codigoResolucion) {
		this.codigoResolucion = codigoResolucion;
	}

	/**
	 * @return the fechaAlta
	 */
	public java.util.Date getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(java.util.Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * @return the usuarioAlta
	 */
	public java.lang.String getUsuarioAlta() {
		return usuarioAlta;
	}

	/**
	 * @param usuarioAlta the usuarioAlta to set
	 */
	public void setUsuarioAlta(java.lang.String usuarioAlta) {
		this.usuarioAlta = usuarioAlta;
	}

	/**
	 * @return the fechaUltimaModificacion
	 */
	public java.util.Date getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	/**
	 * @param fechaUltimaModificacion the fechaUltimaModificacion to set
	 */
	public void setFechaUltimaModificacion(java.util.Date fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

	/**
	 * @return the usuarioModificacion
	 */
	public java.lang.String getUsuarioModificacion() {
		return usuarioModificacion;
	}

	/**
	 * @param usuarioModificacion the usuarioModificacion to set
	 */
	public void setUsuarioModificacion(java.lang.String usuarioModificacion) {
		this.usuarioModificacion = usuarioModificacion;
	}

	/**
	 * @return the fechaUltimaVerificacion
	 */
	public java.util.Date getFechaUltimaVerificacion() {
		return fechaUltimaVerificacion;
	}

	/**
	 * @param fechaUltimaVerificacion the fechaUltimaVerificacion to set
	 */
	public void setFechaUltimaVerificacion(java.util.Date fechaUltimaVerificacion) {
		this.fechaUltimaVerificacion = fechaUltimaVerificacion;
	}

	/**
	 * @return the lugar
	 */
	public java.lang.String getLugar() {
		return lugar;
	}

	/**
	 * @param lugar the lugar to set
	 */
	public void setLugar(java.lang.String lugar) {
		this.lugar = lugar;
	}

	/**
	 * @return the origen
	 */
	public java.lang.String getOrigen() {
		return origen;
	}

	/**
	 * @param origen the origen to set
	 */
	public void setOrigen(java.lang.String origen) {
		this.origen = origen;
	}

	/**
	 * @return the fechaStatus
	 */
	public java.util.Date getFechaStatus() {
		return fechaStatus;
	}

	/**
	 * @param fechaStatus the fechaStatus to set
	 */
	public void setFechaStatus(java.util.Date fechaStatus) {
		this.fechaStatus = fechaStatus;
	}

	/**
	 * @return the fechaContacto
	 */
	public java.util.Date getFechaContacto() {
		return fechaContacto;
	}

	/**
	 * @param fechaContacto the fechaContacto to set
	 */
	public void setFechaContacto(java.util.Date fechaContacto) {
		this.fechaContacto = fechaContacto;
	}

	/**
	 * @return the consecutivo
	 */
	public java.lang.Integer getConsecutivo() {
		return consecutivo;
	}

	/**
	 * @param consecutivo the consecutivo to set
	 */
	public void setConsecutivo(java.lang.Integer consecutivo) {
		this.consecutivo = consecutivo;
	}

	/**
	 * @return the tipoPlan
	 */
	public java.lang.String getTipoPlan() {
		return tipoPlan;
	}

	/**
	 * @param tipoPlan the tipoPlan to set
	 */
	public void setTipoPlan(java.lang.String tipoPlan) {
		this.tipoPlan = tipoPlan;
	}

	/**
	 * @return the proveedorServicio
	 */
	public java.lang.String getProveedorServicio() {
		return proveedorServicio;
	}

	/**
	 * @param proveedorServicio the proveedorServicio to set
	 */
	public void setProveedorServicio(java.lang.String proveedorServicio) {
		this.proveedorServicio = proveedorServicio;
	}

	/**
	 * @return the idRelacion
	 */
	public java.lang.Integer getIdRelacion() {
		return idRelacion;
	}

	/**
	 * @param idRelacion the idRelacion to set
	 */
	public void setIdRelacion(java.lang.Integer idRelacion) {
		this.idRelacion = idRelacion;
	}



	/**
	 * @return the actualizar
	 */
	public Boolean getActualizar() {
		return actualizar;
	}



	/**
	 * @param actualizar the actualizar to set
	 */
	public void setActualizar(Boolean actualizar) {
		this.actualizar = actualizar;
	}


}
