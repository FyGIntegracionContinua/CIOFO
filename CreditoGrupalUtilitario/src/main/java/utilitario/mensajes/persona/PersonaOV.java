package utilitario.mensajes.persona;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * Este objeto esta en relacion directa con la tabla PERSONAS.
 *
 * @author out_mreyes@independencia.com.mx
 */
public 	class 	PersonaOV extends ObjetoValor {

	/** UID para serializacion. */
	private static final long serialVersionUID = -2621323062230990134L;

	// Atributos ------------------------------------------------------------------------------------------------
	/** The numero persona. */
	private java.lang.String						numeroPersona;
	//Ficha de Datos
	/** The nombre. */
	private java.lang.String						nombre;

	/** The apellido paterno. */
	private java.lang.String 						apellidoPaterno;

	/** The apellido materno. */
	private java.lang.String 						apellidoMaterno;

	/** The sobrenombre. */
	private java.lang.String						sobrenombre;

	/** The rfc. */
	private java.lang.String						rfc;

	/** The curp. */
	private java.lang.String						curp;

	/** The tipo identificacion. */
	private java.lang.String						tipoIdentificacion;

	/** The numero identificacion. */
	private java.lang.String						numeroIdentificacion;

	/** The fecha nacimiento. */
	private java.util.Date							fechaNacimiento;

	/** The sexo. */
	private java.lang.String						sexo;

	/** The entidad lugar nacimiento. */
	private java.lang.String						entidadLugarNacimiento;

	/** The pais nacimiento. */
	private java.lang.String						paisNacimiento;

	/** The nacionalidad. */
	private java.lang.String						nacionalidad;

	/** The estado civil. */
	private java.lang.String						estadoCivil;

	/** The ocupacion. */
	private java.lang.String						ocupacion;
	//private java.lang.String						nivelEstudios;
	/** The posicion hogar. */
	private java.lang.String						posicionHogar;

	/** The numero dependientes. */
	private java.lang.Integer						numeroDependientes;

	/** The experiencia credito grupal. */
	private java.lang.Boolean						experienciaCreditoGrupal;

	/** The funcionario publico. */
	private java.lang.Boolean 						funcionarioPublico;

	/** The relacion funcionario. */
	private java.lang.Boolean 						relacionFuncionario;

	/** The ocupacion pareja. */
	private java.lang.String						ocupacionPareja;

	/** The lugar trabajo pareja. */
	private java.lang.String						lugarTrabajoPareja;

	//credprod_finsol
	/** The personalidad. */
	private java.lang.String						personalidad;

	/** The calificacion. */
	private java.lang.Integer						calificacion;

	/** The ciclo. */
	private java.lang.Integer						ciclo;

	/** The prospecto. */
	private java.lang.Boolean						prospecto;

	/** The operador. */
	private java.lang.String						operador;

	/** The fecha alta. */
	private java.util.Date							fechaAlta;

	/** The fecha ultima modificacion. */
	private java.util.Date							fechaUltimaModificacion;

	/** The bloqueo. */
	private java.lang.String						bloqueo;

	/** The fecha bloqueo. */
	private java.util.Date							fechaBloqueo;

	/** The origen. */
	private java.lang.String						origen;

	/** The asesor credito. */
	private java.lang.String						asesorCredito;

	/** The sucursal. */
	private java.lang.Integer						sucursal;

	/** The montoSolicitado. */
	private java.lang.Double						montoSolicitado;

	/** The numHijos. */
	private java.lang.Integer						numHijos;

	/** The noFirmaElectronica.*/
	private java.lang.String						noFirmaElectronica;

	/** The destinoCredito.*/
	private java.lang.String						destinoCredito;

	//Objetos y tablas relacionadas
	//Domicilios
	/** The domicilio persona. */
	private DomicilioOV								domicilioPersona;

	//Telefonos
	/** The telefonos persona. */
	private java.util.List<TelefonoOV>				telefonosPersona;

	//Socioeconomicos
	/** The detalle socioeconomico. */
	private DetalleSocioeconomicoOV					detalleSocioeconomico;

	//Mails
	/** The direcciones electonicas. */
	private java.util.List<DireccionElectronicaOV>	direccionesElectonicas;

	//Referencias
	/** The relaciones persona. */
	private java.util.List<RelacionPersonaOV>		relacionesPersona;


	//Relacion de claves
	/** The relacion clave finsol. */
	private RelacionClaveFinsolOV					relacionClaveFinsol;
	
	// se agragan los siguientes atributos para el requerimiento ORIG-522_26122016_Sucursal móvil (Caravanas)
	/** codigo de la campaña seleccionada por el usuario*/
	private String campana;

	/**estatus de la persona*/
	private String estatus;

	/** The fecha de contacto de cauerdo al estatus. */
	private java.util.Date fechaContacto;

	// Constructor  ---------------------------------------------------------------------
	/**
	 * Instancia una nueva persona ov.
	 */
	public PersonaOV() {

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
	 * Obtiene nombre.
	 *
	 * @return the nombre
	 */
	public java.lang.String getNombre() {
		return nombre;
	}


	/**
	 * Establece nombre.
	 *
	 * @param nombre the nombre to set
	 */
	public void setNombre(java.lang.String nombre) {
		this.nombre = nombre;
	}


	/**
	 * Obtiene apellido paterno.
	 *
	 * @return the apellidoPaterno
	 */
	public java.lang.String getApellidoPaterno() {
		return apellidoPaterno;
	}


	/**
	 * Establece apellido paterno.
	 *
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(java.lang.String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}


	/**
	 * Obtiene apellido materno.
	 *
	 * @return the apellidoMaterno
	 */
	public java.lang.String getApellidoMaterno() {
		return apellidoMaterno;
	}


	/**
	 * Establece apellido materno.
	 *
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(java.lang.String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}


	/**
	 * Obtiene sobrenombre.
	 *
	 * @return the sobrenombre
	 */
	public java.lang.String getSobrenombre() {
		return sobrenombre;
	}


	/**
	 * Establece sobrenombre.
	 *
	 * @param sobrenombre the sobrenombre to set
	 */
	public void setSobrenombre(java.lang.String sobrenombre) {
		this.sobrenombre = sobrenombre;
	}


	/**
	 * Obtiene rfc.
	 *
	 * @return the rfc
	 */
	public java.lang.String getRfc() {
		return rfc;
	}


	/**
	 * Establece rfc.
	 *
	 * @param rfc the rfc to set
	 */
	public void setRfc(java.lang.String rfc) {
		this.rfc = rfc;
	}


	/**
	 * Obtiene curp.
	 *
	 * @return the curp
	 */
	public java.lang.String getCurp() {
		return curp;
	}


	/**
	 * Establece curp.
	 *
	 * @param curp the curp to set
	 */
	public void setCurp(java.lang.String curp) {
		this.curp = curp;
	}


	/**
	 * Obtiene tipo identificacion.
	 *
	 * @return the tipoIdentificacion
	 */
	public java.lang.String getTipoIdentificacion() {
		return tipoIdentificacion;
	}


	/**
	 * Establece tipo identificacion.
	 *
	 * @param tipoIdentificacion the tipoIdentificacion to set
	 */
	public void setTipoIdentificacion(java.lang.String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}


	/**
	 * Obtiene numero identificacion.
	 *
	 * @return the numeroIdentificacion
	 */
	public java.lang.String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}


	/**
	 * Establece numero identificacion.
	 *
	 * @param numeroIdentificacion the numeroIdentificacion to set
	 */
	public void setNumeroIdentificacion(java.lang.String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}


	/**
	 * Obtiene fecha nacimiento.
	 *
	 * @return the fechaNacimiento
	 */
	public java.util.Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	/**
	 * Establece fecha nacimiento.
	 *
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(java.util.Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	/**
	 * Obtiene sexo.
	 *
	 * @return the sexo
	 */
	public java.lang.String getSexo() {
		return sexo;
	}


	/**
	 * Establece sexo.
	 *
	 * @param sexo the sexo to set
	 */
	public void setSexo(java.lang.String sexo) {
		this.sexo = sexo;
	}


	/**
	 * Obtiene entidad lugar nacimiento.
	 *
	 * @return the entidadLugarNacimiento
	 */
	public java.lang.String getEntidadLugarNacimiento() {
		return entidadLugarNacimiento;
	}


	/**
	 * Establece entidad lugar nacimiento.
	 *
	 * @param entidadLugarNacimiento the entidadLugarNacimiento to set
	 */
	public void setEntidadLugarNacimiento(java.lang.String entidadLugarNacimiento) {
		this.entidadLugarNacimiento = entidadLugarNacimiento;
	}


	/**
	 * Obtiene pais nacimiento.
	 *
	 * @return the paisNacimiento
	 */
	public java.lang.String getPaisNacimiento() {
		return paisNacimiento;
	}


	/**
	 * Establece pais nacimiento.
	 *
	 * @param paisNacimiento the paisNacimiento to set
	 */
	public void setPaisNacimiento(java.lang.String paisNacimiento) {
		this.paisNacimiento = paisNacimiento;
	}


	/**
	 * Obtiene nacionalidad.
	 *
	 * @return the nacionalidad
	 */
	public java.lang.String getNacionalidad() {
		return nacionalidad;
	}


	/**
	 * Establece nacionalidad.
	 *
	 * @param nacionalidad the nacionalidad to set
	 */
	public void setNacionalidad(java.lang.String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	/**
	 * Obtiene estado civil.
	 *
	 * @return the estadoCivil
	 */
	public java.lang.String getEstadoCivil() {
		return estadoCivil;
	}


	/**
	 * Establece estado civil.
	 *
	 * @param estadoCivil the estadoCivil to set
	 */
	public void setEstadoCivil(java.lang.String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	/**
	 * Obtiene ocupacion.
	 *
	 * @return the ocupacion
	 */
	public java.lang.String getOcupacion() {
		return ocupacion;
	}


	/**
	 * Establece ocupacion.
	 *
	 * @param ocupacion the ocupacion to set
	 */
	public void setOcupacion(java.lang.String ocupacion) {
		this.ocupacion = ocupacion;
	}


	/**
	 * Obtiene posicion hogar.
	 *
	 * @return the posicionHogar
	 */
	public java.lang.String getPosicionHogar() {
		return posicionHogar;
	}


	/**
	 * Establece posicion hogar.
	 *
	 * @param posicionHogar the posicionHogar to set
	 */
	public void setPosicionHogar(java.lang.String posicionHogar) {
		this.posicionHogar = posicionHogar;
	}


	/**
	 * Obtiene numero dependientes.
	 *
	 * @return the numeroDependientes
	 */
	public java.lang.Integer getNumeroDependientes() {
		return numeroDependientes;
	}


	/**
	 * Establece numero dependientes.
	 *
	 * @param numeroDependientes the numeroDependientes to set
	 */
	public void setNumeroDependientes(java.lang.Integer numeroDependientes) {
		this.numeroDependientes = numeroDependientes;
	}


	/**
	 * Obtiene experiencia credito grupal.
	 *
	 * @return the experienciaCreditoGrupal
	 */
	public java.lang.Boolean getExperienciaCreditoGrupal() {
		return experienciaCreditoGrupal;
	}


	/**
	 * Establece experiencia credito grupal.
	 *
	 * @param experienciaCreditoGrupal the experienciaCreditoGrupal to set
	 */
	public void setExperienciaCreditoGrupal(
			java.lang.Boolean experienciaCreditoGrupal) {
		this.experienciaCreditoGrupal = experienciaCreditoGrupal;
	}


	/**
	 * Obtiene funcionario publico.
	 *
	 * @return the funcionarioPublico
	 */
	public java.lang.Boolean getFuncionarioPublico() {
		return funcionarioPublico;
	}


	/**
	 * Establece funcionario publico.
	 *
	 * @param funcionarioPublico the funcionarioPublico to set
	 */
	public void setFuncionarioPublico(java.lang.Boolean funcionarioPublico) {
		this.funcionarioPublico = funcionarioPublico;
	}


	/**
	 * Obtiene relacion funcionario.
	 *
	 * @return the relacionFuncionario
	 */
	public java.lang.Boolean getRelacionFuncionario() {
		return relacionFuncionario;
	}


	/**
	 * Establece relacion funcionario.
	 *
	 * @param relacionFuncionario the relacionFuncionario to set
	 */
	public void setRelacionFuncionario(java.lang.Boolean relacionFuncionario) {
		this.relacionFuncionario = relacionFuncionario;
	}


	/**
	 * Obtiene ocupacion pareja.
	 *
	 * @return the ocupacionPareja
	 */
	public java.lang.String getOcupacionPareja() {
		return ocupacionPareja;
	}


	/**
	 * Establece ocupacion pareja.
	 *
	 * @param ocupacionPareja the ocupacionPareja to set
	 */
	public void setOcupacionPareja(java.lang.String ocupacionPareja) {
		this.ocupacionPareja = ocupacionPareja;
	}


	/**
	 * Obtiene lugar trabajo pareja.
	 *
	 * @return the lugarTrabajoPareja
	 */
	public java.lang.String getLugarTrabajoPareja() {
		return lugarTrabajoPareja;
	}


	/**
	 * Establece lugar trabajo pareja.
	 *
	 * @param lugarTrabajoPareja the lugarTrabajoPareja to set
	 */
	public void setLugarTrabajoPareja(java.lang.String lugarTrabajoPareja) {
		this.lugarTrabajoPareja = lugarTrabajoPareja;
	}


	/**
	 * Obtiene personalidad.
	 *
	 * @return the personalidad
	 */
	public java.lang.String getPersonalidad() {
		return personalidad;
	}


	/**
	 * Establece personalidad.
	 *
	 * @param personalidad the personalidad to set
	 */
	public void setPersonalidad(java.lang.String personalidad) {
		this.personalidad = personalidad;
	}


	/**
	 * Obtiene calificacion.
	 *
	 * @return the calificacion
	 */
	public java.lang.Integer getCalificacion() {
		return calificacion;
	}


	/**
	 * Establece calificacion.
	 *
	 * @param calificacion the calificacion to set
	 */
	public void setCalificacion(java.lang.Integer calificacion) {
		this.calificacion = calificacion;
	}


	/**
	 * Obtiene ciclo.
	 *
	 * @return the ciclo
	 */
	public java.lang.Integer getCiclo() {
		return ciclo;
	}


	/**
	 * Establece ciclo.
	 *
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(java.lang.Integer ciclo) {
		this.ciclo = ciclo;
	}


	/**
	 * Obtiene prospecto.
	 *
	 * @return the prospecto
	 */
	public java.lang.Boolean getProspecto() {
		return prospecto;
	}


	/**
	 * Establece prospecto.
	 *
	 * @param prospecto the prospecto to set
	 */
	public void setProspecto(java.lang.Boolean prospecto) {
		this.prospecto = prospecto;
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
	 * Obtiene fecha alta.
	 *
	 * @return the fechaAlta
	 */
	public java.util.Date getFechaAlta() {
		return fechaAlta;
	}


	/**
	 * Establece fecha alta.
	 *
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(java.util.Date fechaAlta) {
		this.fechaAlta = fechaAlta;
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
	 * Obtiene bloqueo.
	 *
	 * @return the bloqueo
	 */
	public java.lang.String getBloqueo() {
		return bloqueo;
	}


	/**
	 * Establece bloqueo.
	 *
	 * @param bloqueo the bloqueo to set
	 */
	public void setBloqueo(java.lang.String bloqueo) {
		this.bloqueo = bloqueo;
	}


	/**
	 * Obtiene fecha bloqueo.
	 *
	 * @return the fechaBloqueo
	 */
	public java.util.Date getFechaBloqueo() {
		return fechaBloqueo;
	}


	/**
	 * Establece fecha bloqueo.
	 *
	 * @param fechaBloqueo the fechaBloqueo to set
	 */
	public void setFechaBloqueo(java.util.Date fechaBloqueo) {
		this.fechaBloqueo = fechaBloqueo;
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
	 * Obtiene asesor credito.
	 *
	 * @return the asesorCredito
	 */
	public java.lang.String getAsesorCredito() {
		return asesorCredito;
	}


	/**
	 * Establece asesor credito.
	 *
	 * @param asesorCredito the asesorCredito to set
	 */
	public void setAsesorCredito(java.lang.String asesorCredito) {
		this.asesorCredito = asesorCredito;
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
	 * @return the montoSolicitado
	 */
	public java.lang.Double getMontoSolicitado() {
		return montoSolicitado;
	}


	/**
	 * @param montoSolicitado the montoSolicitado to set
	 */
	public void setMontoSolicitado(java.lang.Double montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}


	/**
	 * @return the numHijos
	 */
	public java.lang.Integer getNumHijos() {
		return numHijos;
	}


	/**
	 * @param numHijos the numHijos to set
	 */
	public void setNumHijos(java.lang.Integer numHijos) {
		this.numHijos = numHijos;
	}


	/**
	 * @return the noFirmaElectronica
	 */
	public java.lang.String getNoFirmaElectronica() {
		return noFirmaElectronica;
	}


	/**
	 * @param noFirmaElectronica the noFirmaElectronica to set
	 */
	public void setNoFirmaElectronica(java.lang.String noFirmaElectronica) {
		this.noFirmaElectronica = noFirmaElectronica;
	}


	/**
	 * @return the destinoCredito
	 */
	public java.lang.String getDestinoCredito() {
		return destinoCredito;
	}


	/**
	 * @param destinoCredito the destinoCredito to set
	 */
	public void setDestinoCredito(java.lang.String destinoCredito) {
		this.destinoCredito = destinoCredito;
	}

	/**
	 * Obtiene domicilio persona.
	 *
	 * @return the domicilioPersona
	 */
	public DomicilioOV getDomicilioPersona() {
		return domicilioPersona;
	}


	/**
	 * Establece domicilio persona.
	 *
	 * @param domicilioPersona the domicilioPersona to set
	 */
	public void setDomicilioPersona(DomicilioOV domicilioPersona) {
		this.domicilioPersona = domicilioPersona;
	}


	/**
	 * Obtiene telefonos persona.
	 *
	 * @return the telefonosPersona
	 */
	public java.util.List<TelefonoOV> getTelefonosPersona() {
		return telefonosPersona;
	}


	/**
	 * Establece telefonos persona.
	 *
	 * @param telefonosPersona the telefonosPersona to set
	 */
	public void setTelefonosPersona(java.util.List<TelefonoOV> telefonosPersona) {
		this.telefonosPersona = telefonosPersona;
	}


	/**
	 * Obtiene detalle socioeconomico.
	 *
	 * @return the detalleSocioeconomico
	 */
	public DetalleSocioeconomicoOV getDetalleSocioeconomico() {
		return detalleSocioeconomico;
	}


	/**
	 * Establece detalle socioeconomico.
	 *
	 * @param detalleSocioeconomico the detalleSocioeconomico to set
	 */
	public void setDetalleSocioeconomico(
			DetalleSocioeconomicoOV detalleSocioeconomico) {
		this.detalleSocioeconomico = detalleSocioeconomico;
	}


	/**
	 * Obtiene direcciones electonicas.
	 *
	 * @return the direccionesElectonicas
	 */
	public java.util.List<DireccionElectronicaOV> getDireccionesElectonicas() {
		return direccionesElectonicas;
	}


	/**
	 * Establece direcciones electonicas.
	 *
	 * @param direccionesElectonicas the direccionesElectonicas to set
	 */
	public void setDireccionesElectonicas(
			java.util.List<DireccionElectronicaOV> direccionesElectonicas) {
		this.direccionesElectonicas = direccionesElectonicas;
	}


	/**
	 * Obtiene relaciones persona.
	 *
	 * @return the relacionesPersona
	 */
	public java.util.List<RelacionPersonaOV> getRelacionesPersona() {
		return relacionesPersona;
	}


	/**
	 * Establece relaciones persona.
	 *
	 * @param relacionesPersona the relacionesPersona to set
	 */
	public void setRelacionesPersona(
			java.util.List<RelacionPersonaOV> relacionesPersona) {
		this.relacionesPersona = relacionesPersona;
	}


	/**
	 * Obtiene relacion clave finsol.
	 *
	 * @return the relacionClaveFinsol
	 */
	public RelacionClaveFinsolOV getRelacionClaveFinsol() {
		return relacionClaveFinsol;
	}


	/**
	 * Establece relacion clave finsol.
	 *
	 * @param relacionClaveFinsol the relacionClaveFinsol to set
	 */
	public void setRelacionClaveFinsol(RelacionClaveFinsolOV relacionClaveFinsol) {
		this.relacionClaveFinsol = relacionClaveFinsol;
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
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}


	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
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

}
