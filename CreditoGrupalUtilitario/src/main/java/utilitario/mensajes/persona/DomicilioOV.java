/**
 *
 */
package utilitario.mensajes.persona;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class DomicilioOV.
 *
 * @author out_mreyes@independencia.com.mx
 */
public 	class 	DomicilioOV extends ObjetoValor {

	/** UID para el proceso de serializacion. */
	private static final long serialVersionUID = 2915578701256513078L;

	// Atributos  -----------------------------------------------------------------------
	/** The numero persona. */
	private java.lang.String			numeroPersona;

	/** The tipo domicilio. */
	private java.lang.String			tipoDomicilio;

	/** The consecutivo. */
	private java.lang.Integer			consecutivo;

	/** The status. */
	private java.lang.String			status;

	/** The pais. */
	private java.lang.String			pais;

	/** The codigo estado. */
	private java.lang.String			codigoEstado;

	/** The estado. */
	private String						estado;

	/** The municipio. */
	private java.lang.String			municipio;

	/** The ciudad. */
	private java.lang.String			ciudad;

	/** The colonia. */
	private java.lang.String			colonia;

	/** The cp. */
	private java.lang.String			cp;

	/** The calle. */
	private java.lang.String			calle;

	/** The tipo localidad. */
	private java.lang.String			tipoLocalidad;

	/** The entre calles. */
	private java.lang.String			entreCalles;

	/** The otras indicaciones. */
	private java.lang.String			otrasIndicaciones;

	/** The numero exterior. */
	private java.lang.String			numeroExterior;

	/** The numero interior. */
	private java.lang.String			numeroInterior;

	/** The direccion completa. */
	private java.lang.String			direccionCompleta;

	/** The fecha domicilio. */
	private java.util.Date				fechaDomicilio;

	/** The dias localiza. */
	private java.lang.String			diasLocaliza;

	/** The hora localiza inicial. */
	private java.lang.String			horaLocalizaInicial;

	/** The hora localiza final. */
	private java.lang.String			horaLocalizaFinal;

	/** The tipo vivienda. */
	private java.lang.String			tipoVivienda;

	/** The fecha ultima modificacion. */
	private java.util.Date				fechaUltimaModificacion;

	/** The origen. */
	private java.lang.String			origen;

	/** The id relacion. */
	private java.lang.Integer			idRelacion;

	/** The operador. */
	private java.lang.String			operador;

	/** The operador. */
	private int			aniosDomicilio;


	// Constructor  ---------------------------------------------------------------------
	/**
	 * Instancia una nueva domicilio ov.
	 */
	public DomicilioOV() {

		}



	/**
	 * Obtiene numero persona.
	 *
	 * @return the numeroPersona
	 */
	public java.lang.String getNumeroPersona() {
		return numeroPersona;
	}



	/**
	 * Establece numero persona.
	 *
	 * @param numeroPersona the numeroPersona to set
	 */
	public void setNumeroPersona(java.lang.String numeroPersona) {
		this.numeroPersona = numeroPersona;
	}



	/**
	 * Obtiene tipo domicilio.
	 *
	 * @return the tipoDomicilio
	 */
	public java.lang.String getTipoDomicilio() {
		return tipoDomicilio;
	}



	/**
	 * Establece tipo domicilio.
	 *
	 * @param tipoDomicilio the tipoDomicilio to set
	 */
	public void setTipoDomicilio(java.lang.String tipoDomicilio) {
		this.tipoDomicilio = tipoDomicilio;
	}



	/**
	 * Obtiene consecutivo.
	 *
	 * @return the consecutivo
	 */
	public java.lang.Integer getConsecutivo() {
		return consecutivo;
	}



	/**
	 * Establece consecutivo.
	 *
	 * @param consecutivo the consecutivo to set
	 */
	public void setConsecutivo(java.lang.Integer consecutivo) {
		this.consecutivo = consecutivo;
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
	 * Obtiene codigo estado.
	 *
	 * @return the codigoEstado
	 */
	public java.lang.String getCodigoEstado() {
		return codigoEstado;
	}



	/**
	 * Establece codigo estado.
	 *
	 * @param codigoEstado the codigoEstado to set
	 */
	public void setCodigoEstado(java.lang.String codigoEstado) {
		this.codigoEstado = codigoEstado;
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
	 * Obtiene ciudad.
	 *
	 * @return the ciudad
	 */
	public java.lang.String getCiudad() {
		return ciudad;
	}



	/**
	 * Establece ciudad.
	 *
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(java.lang.String ciudad) {
		this.ciudad = ciudad;
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
	 * Obtiene cp.
	 *
	 * @return the cp
	 */
	public java.lang.String getCp() {
		return cp;
	}



	/**
	 * Establece cp.
	 *
	 * @param cp the cp to set
	 */
	public void setCp(java.lang.String cp) {
		this.cp = cp;
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
	 * Obtiene entre calles.
	 *
	 * @return the entreCalles
	 */
	public java.lang.String getEntreCalles() {
		return entreCalles;
	}



	/**
	 * Establece entre calles.
	 *
	 * @param entreCalles the entreCalles to set
	 */
	public void setEntreCalles(java.lang.String entreCalles) {
		this.entreCalles = entreCalles;
	}



	/**
	 * Obtiene otras indicaciones.
	 *
	 * @return the otrasIndicaciones
	 */
	public java.lang.String getOtrasIndicaciones() {
		return otrasIndicaciones;
	}



	/**
	 * Establece otras indicaciones.
	 *
	 * @param otrasIndicaciones the otrasIndicaciones to set
	 */
	public void setOtrasIndicaciones(java.lang.String otrasIndicaciones) {
		this.otrasIndicaciones = otrasIndicaciones;
	}



	/**
	 * Obtiene numero exterior.
	 *
	 * @return the numeroExterior
	 */
	public java.lang.String getNumeroExterior() {
		return numeroExterior;
	}



	/**
	 * Establece numero exterior.
	 *
	 * @param numeroExterior the numeroExterior to set
	 */
	public void setNumeroExterior(java.lang.String numeroExterior) {
		this.numeroExterior = numeroExterior;
	}



	/**
	 * Obtiene numero interior.
	 *
	 * @return the numeroInterior
	 */
	public java.lang.String getNumeroInterior() {
		return numeroInterior;
	}



	/**
	 * Establece numero interior.
	 *
	 * @param numeroInterior the numeroInterior to set
	 */
	public void setNumeroInterior(java.lang.String numeroInterior) {
		this.numeroInterior = numeroInterior;
	}



	/**
	 * Obtiene direccion completa.
	 *
	 * @return the direccionCompleta
	 */
	public java.lang.String getDireccionCompleta() {
		return direccionCompleta;
	}



	/**
	 * Establece direccion completa.
	 *
	 * @param direccionCompleta the direccionCompleta to set
	 */
	public void setDireccionCompleta(java.lang.String direccionCompleta) {
		this.direccionCompleta = direccionCompleta;
	}



	/**
	 * Obtiene fecha domicilio.
	 *
	 * @return the fechaDomicilio
	 */
	public java.util.Date getFechaDomicilio() {
		return fechaDomicilio;
	}



	/**
	 * Establece fecha domicilio.
	 *
	 * @param fechaDomicilio the fechaDomicilio to set
	 */
	public void setFechaDomicilio(java.util.Date fechaDomicilio) {
		this.fechaDomicilio = fechaDomicilio;
	}



	/**
	 * Obtiene dias localiza.
	 *
	 * @return the diasLocaliza
	 */
	public java.lang.String getDiasLocaliza() {
		return diasLocaliza;
	}



	/**
	 * Establece dias localiza.
	 *
	 * @param diasLocaliza the diasLocaliza to set
	 */
	public void setDiasLocaliza(java.lang.String diasLocaliza) {
		this.diasLocaliza = diasLocaliza;
	}



	/**
	 * Obtiene hora localiza inicial.
	 *
	 * @return the horaLocalizaInicial
	 */
	public java.lang.String getHoraLocalizaInicial() {
		return horaLocalizaInicial;
	}



	/**
	 * Establece hora localiza inicial.
	 *
	 * @param horaLocalizaInicial the horaLocalizaInicial to set
	 */
	public void setHoraLocalizaInicial(java.lang.String horaLocalizaInicial) {
		this.horaLocalizaInicial = horaLocalizaInicial;
	}



	/**
	 * Obtiene hora localiza final.
	 *
	 * @return the horaLocalizaFinal
	 */
	public java.lang.String getHoraLocalizaFinal() {
		return horaLocalizaFinal;
	}



	/**
	 * Establece hora localiza final.
	 *
	 * @param horaLocalizaFinal the horaLocalizaFinal to set
	 */
	public void setHoraLocalizaFinal(java.lang.String horaLocalizaFinal) {
		this.horaLocalizaFinal = horaLocalizaFinal;
	}



	/**
	 * Obtiene tipo vivienda.
	 *
	 * @return the tipoVivienda
	 */
	public java.lang.String getTipoVivienda() {
		return tipoVivienda;
	}



	/**
	 * Establece tipo vivienda.
	 *
	 * @param tipoVivienda the tipoVivienda to set
	 */
	public void setTipoVivienda(java.lang.String tipoVivienda) {
		this.tipoVivienda = tipoVivienda;
	}



	/**
	 * Obtiene fecha ultima modificacion.
	 *
	 * @return the fechaUltimaModificacion
	 */
	public java.util.Date getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}



	/**
	 * Establece fecha ultima modificacion.
	 *
	 * @param fechaUltimaModificacion the fechaUltimaModificacion to set
	 */
	public void setFechaUltimaModificacion(java.util.Date fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}



	/**
	 * Obtiene origen.
	 *
	 * @return the origen
	 */
	public java.lang.String getOrigen() {
		return origen;
	}



	/**
	 * Establece origen.
	 *
	 * @param origen the origen to set
	 */
	public void setOrigen(java.lang.String origen) {
		this.origen = origen;
	}



	/**
	 * Obtiene id relacion.
	 *
	 * @return the idRelacion
	 */
	public java.lang.Integer getIdRelacion() {
		return idRelacion;
	}



	/**
	 * Establece id relacion.
	 *
	 * @param idRelacion the idRelacion to set
	 */
	public void setIdRelacion(java.lang.Integer idRelacion) {
		this.idRelacion = idRelacion;
	}



	/**
	 * Obtiene operador.
	 *
	 * @return the operador
	 */
	public java.lang.String getOperador() {
		return operador;
	}



	/**
	 * Establece operador.
	 *
	 * @param operador the operador to set
	 */
	public void setOperador(java.lang.String operador) {
		this.operador = operador;
	}



	/**
	 * Establece estado.
	 *
	 * @param estado a estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}



	/**
	 * Obtiene estado.
	 *
	 * @return estado
	 */
	public String getEstado() {
		return estado;
	}


	/**
	 * @return the aniosDomicilio
	 */
	public int getAniosDomicilio() {
		return aniosDomicilio;
	}


	/**
	 * @param aniosDomicilio the aniosDomicilio to set
	 */
	public void setAniosDomicilio(int aniosDomicilio) {
		this.aniosDomicilio = aniosDomicilio;
	}

}
