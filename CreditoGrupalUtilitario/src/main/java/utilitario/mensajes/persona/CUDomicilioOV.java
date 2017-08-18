/**
 *
 */
package utilitario.mensajes.persona;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class CUDomicilioOV.
 *
 * @author out_mreyes@independencia.com.mx
 */
public 	class 	CUDomicilioOV extends ObjetoValor {

	/** UID para serializacion. */
	private static final long serialVersionUID = -9017406985603714367L;

	// Atributos  -----------------------------------------------------------------------
	/** The domicilio id. */
	private java.lang.Long				domicilioID;

	/** The customer id. */
	private java.lang.String			customerID;

	/** The calle. */
	private java.lang.String			calle;

	/** The codigo postal. */
	private java.lang.String			codigoPostal;

	/** The colonia. */
	private java.lang.String			colonia;

	/** The municipio. */
	private java.lang.String			municipio;

	/** The estado. */
	private java.lang.String			estado;

	/** The pais. */
	private java.lang.String			pais;

	/** The referencia ubicacion. */
	private java.lang.String			referenciaUbicacion;

	/** The tipo propiedad. */
	private java.lang.Integer			tipoPropiedad;

	/** The domicilio actual. */
	private java.lang.Integer			domicilioActual;

	/** The localidad. */
	private java.lang.String			localidad;

	/** The date insercion. */
	private java.lang.String			dateInsercion;

	/** The tiempo residencia. */
	private java.lang.Integer			tiempoResidencia;

	/** The tipo localidad. */
	private java.lang.String			tipoLocalidad;

	/** The ID neighbourhood. */
	private java.lang.String			IDNeighbourhood;

	/** The tipo propiedad otro. */
	private java.lang.String			tipoPropiedadOtro;

	// Constructor  ---------------------------------------------------------------------
	/**
	 * Instancia una nueva CU domicilio ov.
	 */
	public CUDomicilioOV() {

		}

	// M&eacute;todos de acceso  ---------------------------------------------------------------
	/**
	 * Obtiene domicilio id.
	 *
	 * @return the domicilioID
	 */
	public java.lang.Long getDomicilioID() {
		return domicilioID;
	}

	/**
	 * Establece domicilio id.
	 *
	 * @param domicilioID the domicilioID to set
	 */
	public void setDomicilioID(java.lang.Long domicilioID) {
		this.domicilioID = domicilioID;
	}

	/**
	 * Obtiene customer id.
	 *
	 * @return the customerID
	 */
	public java.lang.String getCustomerID() {
		return customerID;
	}

	/**
	 * Establece customer id.
	 *
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(java.lang.String customerID) {
		this.customerID = customerID;
	}

	/**
	 * Obtiene calle.
	 *
	 * @return the calle
	 */
	public java.lang.String getCalle() {
		return calle;
	}

	/**
	 * Establece calle.
	 *
	 * @param calle the calle to set
	 */
	public void setCalle(java.lang.String calle) {
		this.calle = calle;
	}

	/**
	 * Obtiene codigo postal.
	 *
	 * @return the codigoPostal
	 */
	public java.lang.String getCodigoPostal() {
		return codigoPostal;
	}

	/**
	 * Establece codigo postal.
	 *
	 * @param codigoPostal the codigoPostal to set
	 */
	public void setCodigoPostal(java.lang.String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	/**
	 * Obtiene colonia.
	 *
	 * @return the colonia
	 */
	public java.lang.String getColonia() {
		return colonia;
	}

	/**
	 * Establece colonia.
	 *
	 * @param colonia the colonia to set
	 */
	public void setColonia(java.lang.String colonia) {
		this.colonia = colonia;
	}

	/**
	 * Obtiene municipio.
	 *
	 * @return the municipio
	 */
	public java.lang.String getMunicipio() {
		return municipio;
	}

	/**
	 * Establece municipio.
	 *
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(java.lang.String municipio) {
		this.municipio = municipio;
	}

	/**
	 * Obtiene estado.
	 *
	 * @return the estado
	 */
	public java.lang.String getEstado() {
		return estado;
	}

	/**
	 * Establece estado.
	 *
	 * @param estado the estado to set
	 */
	public void setEstado(java.lang.String estado) {
		this.estado = estado;
	}

	/**
	 * Obtiene pais.
	 *
	 * @return the pais
	 */
	public java.lang.String getPais() {
		return pais;
	}

	/**
	 * Establece pais.
	 *
	 * @param pais the pais to set
	 */
	public void setPais(java.lang.String pais) {
		this.pais = pais;
	}

	/**
	 * Obtiene referencia ubicacion.
	 *
	 * @return the referenciaUbicacion
	 */
	public java.lang.String getReferenciaUbicacion() {
		return referenciaUbicacion;
	}

	/**
	 * Establece referencia ubicacion.
	 *
	 * @param referenciaUbicacion the referenciaUbicacion to set
	 */
	public void setReferenciaUbicacion(java.lang.String referenciaUbicacion) {
		this.referenciaUbicacion = referenciaUbicacion;
	}

	/**
	 * Obtiene tipo propiedad.
	 *
	 * @return the tipoPropiedad
	 */
	public java.lang.Integer getTipoPropiedad() {
		return tipoPropiedad;
	}

	/**
	 * Establece tipo propiedad.
	 *
	 * @param tipoPropiedad the tipoPropiedad to set
	 */
	public void setTipoPropiedad(java.lang.Integer tipoPropiedad) {
		this.tipoPropiedad = tipoPropiedad;
	}

	/**
	 * Obtiene domicilio actual.
	 *
	 * @return the domicilioActual
	 */
	public java.lang.Integer getDomicilioActual() {
		return domicilioActual;
	}

	/**
	 * Establece domicilio actual.
	 *
	 * @param domicilioActual the domicilioActual to set
	 */
	public void setDomicilioActual(java.lang.Integer domicilioActual) {
		this.domicilioActual = domicilioActual;
	}

	/**
	 * Obtiene localidad.
	 *
	 * @return the localidad
	 */
	public java.lang.String getLocalidad() {
		return localidad;
	}

	/**
	 * Establece localidad.
	 *
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(java.lang.String localidad) {
		this.localidad = localidad;
	}

	/**
	 * Obtiene date insercion.
	 *
	 * @return the dateInsercion
	 */
	public java.lang.String getDateInsercion() {
		return dateInsercion;
	}

	/**
	 * Establece date insercion.
	 *
	 * @param dateInsercion the dateInsercion to set
	 */
	public void setDateInsercion(java.lang.String dateInsercion) {
		this.dateInsercion = dateInsercion;
	}

	/**
	 * Obtiene tiempo residencia.
	 *
	 * @return the tiempoResidencia
	 */
	public java.lang.Integer getTiempoResidencia() {
		return tiempoResidencia;
	}

	/**
	 * Establece tiempo residencia.
	 *
	 * @param tiempoResidencia the tiempoResidencia to set
	 */
	public void setTiempoResidencia(java.lang.Integer tiempoResidencia) {
		this.tiempoResidencia = tiempoResidencia;
	}

	/**
	 * Obtiene tipo localidad.
	 *
	 * @return the tipoLocalidad
	 */
	public java.lang.String getTipoLocalidad() {
		return tipoLocalidad;
	}

	/**
	 * Establece tipo localidad.
	 *
	 * @param tipoLocalidad the tipoLocalidad to set
	 */
	public void setTipoLocalidad(java.lang.String tipoLocalidad) {
		this.tipoLocalidad = tipoLocalidad;
	}

	/**
	 * Obtiene ID neighbourhood.
	 *
	 * @return the iDNeighbourhood
	 */
	public java.lang.String getIDNeighbourhood() {
		return IDNeighbourhood;
	}

	/**
	 * Establece ID neighbourhood.
	 *
	 * @param iDNeighbourhood the iDNeighbourhood to set
	 */
	public void setIDNeighbourhood(java.lang.String iDNeighbourhood) {
		IDNeighbourhood = iDNeighbourhood;
	}

	/**
	 * Obtiene tipo propiedad otro.
	 *
	 * @return the tipoPropiedadOtro
	 */
	public java.lang.String getTipoPropiedadOtro() {
		return tipoPropiedadOtro;
	}

	/**
	 * Establece tipo propiedad otro.
	 *
	 * @param tipoPropiedadOtro the tipoPropiedadOtro to set
	 */
	public void setTipoPropiedadOtro(java.lang.String tipoPropiedadOtro) {
		this.tipoPropiedadOtro = tipoPropiedadOtro;
	}

}
