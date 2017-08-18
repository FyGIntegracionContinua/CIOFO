package utilitario.mensajes.persona;

import java.util.List;

import utilitario.mensajes.comun.ObjetoValor;

public class PersonaSimplificacionOV extends ObjetoValor {


	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4768082588913519523L;
	// Atributos ------------------------------------------------------------------------------------------------
	/** The numero persona. */
	private java.lang.String						numeroPersona;
	/** The montoSolicitado. */
	private double									montoSolicitado;
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
	private java.lang.String						fechaNacimiento;

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

	/** The asesor credito. */
	private java.lang.String						email;
	/** The asesor credito. */
	private java.lang.String 						telefonoFijo;
	/** The asesor credito. */
	private java.lang.String 						telefonoCelular;
	/** The asesor credito. */
	private java.lang.String 						telefonoEmpleo;
	/** The asesor credito. */
	private java.lang.String 						telefonoRecados;
	/** The asesor credito. */
	private java.lang.String 						nombreRecadero;
	/** The nombre. */
	private java.lang.String						nombrePareja;

	/** The apellido paterno. */
	private java.lang.String 						apellidoPaternoPareja;

	/** The apellido materno. */
	private java.lang.String 						apellidoMaternoPareja;
	/** The ocupacion pareja. */
	private java.lang.String						ocupacionPareja;

	/** The lugar trabajo pareja. */
	private java.lang.String						lugarTrabajoPareja;

	/** The lugar trabajo pareja. */
	private java.lang.String						telefonoCelularPareja;

	/** The lugar trabajo pareja. */
	private java.lang.String						telefonoTrabajoPareja;
	
	/** The nombre Gerente Sucursal. */
	private java.lang.String						nombreGerenteSucursal;
	
	/** The nombre Asesor. */
	private java.lang.String						nombreAsesor;	

	//Objetos y tablas relacionadas
	//Domicilios
	/** The domicilio persona. */
	private DomicilioOV								domicilioPersona;

	/** The detalleSocioeconomico. */
	private DetalleSocioeconomicoOV					detalleSocioeconomico;

	/** The domicilioNegocio. */
	private DomicilioOV								domicilioNegocio;

	/** The referencias. */
	private List<ReferenciaOV>						referencias;
	
	/** The numero hijos. */
	private java.lang.Integer						numeroHijos;
	
	/** The destino Crédito. */
	private java.lang.String						destinoCredito;	
	
	/** The firma Electronica. */
	private java.lang.String						firmaElectronica;	

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
	 * @return the montoSolicitado
	 */
	public double getMontoSolicitado() {
		return montoSolicitado;
	}

	/**
	 * @param montoSolicitado the montoSolicitado to set
	 */
	public void setMontoSolicitado(double montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}

	/**
	 * @return the nombre
	 */
	public java.lang.String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(java.lang.String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public java.lang.String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(java.lang.String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public java.lang.String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(java.lang.String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * @return the sobrenombre
	 */
	public java.lang.String getSobrenombre() {
		return sobrenombre;
	}

	/**
	 * @param sobrenombre the sobrenombre to set
	 */
	public void setSobrenombre(java.lang.String sobrenombre) {
		this.sobrenombre = sobrenombre;
	}

	/**
	 * @return the rfc
	 */
	public java.lang.String getRfc() {
		return rfc;
	}

	/**
	 * @param rfc the rfc to set
	 */
	public void setRfc(java.lang.String rfc) {
		this.rfc = rfc;
	}

	/**
	 * @return the curp
	 */
	public java.lang.String getCurp() {
		return curp;
	}

	/**
	 * @param curp the curp to set
	 */
	public void setCurp(java.lang.String curp) {
		this.curp = curp;
	}

	/**
	 * @return the tipoIdentificacion
	 */
	public java.lang.String getTipoIdentificacion() {
		return tipoIdentificacion;
	}

	/**
	 * @param tipoIdentificacion the tipoIdentificacion to set
	 */
	public void setTipoIdentificacion(java.lang.String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	/**
	 * @return the numeroIdentificacion
	 */
	public java.lang.String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}

	/**
	 * @param numeroIdentificacion the numeroIdentificacion to set
	 */
	public void setNumeroIdentificacion(java.lang.String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public java.lang.String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(java.lang.String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the sexo
	 */
	public java.lang.String getSexo() {
		return sexo;
	}

	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(java.lang.String sexo) {
		this.sexo = sexo;
	}

	/**
	 * @return the entidadLugarNacimiento
	 */
	public java.lang.String getEntidadLugarNacimiento() {
		return entidadLugarNacimiento;
	}

	/**
	 * @param entidadLugarNacimiento the entidadLugarNacimiento to set
	 */
	public void setEntidadLugarNacimiento(java.lang.String entidadLugarNacimiento) {
		this.entidadLugarNacimiento = entidadLugarNacimiento;
	}

	/**
	 * @return the paisNacimiento
	 */
	public java.lang.String getPaisNacimiento() {
		return paisNacimiento;
	}

	/**
	 * @param paisNacimiento the paisNacimiento to set
	 */
	public void setPaisNacimiento(java.lang.String paisNacimiento) {
		this.paisNacimiento = paisNacimiento;
	}

	/**
	 * @return the nacionalidad
	 */
	public java.lang.String getNacionalidad() {
		return nacionalidad;
	}

	/**
	 * @param nacionalidad the nacionalidad to set
	 */
	public void setNacionalidad(java.lang.String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	/**
	 * @return the estadoCivil
	 */
	public java.lang.String getEstadoCivil() {
		return estadoCivil;
	}

	/**
	 * @param estadoCivil the estadoCivil to set
	 */
	public void setEstadoCivil(java.lang.String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	/**
	 * @return the ocupacion
	 */
	public java.lang.String getOcupacion() {
		return ocupacion;
	}

	/**
	 * @param ocupacion the ocupacion to set
	 */
	public void setOcupacion(java.lang.String ocupacion) {
		this.ocupacion = ocupacion;
	}

	/**
	 * @return the posicionHogar
	 */
	public java.lang.String getPosicionHogar() {
		return posicionHogar;
	}

	/**
	 * @param posicionHogar the posicionHogar to set
	 */
	public void setPosicionHogar(java.lang.String posicionHogar) {
		this.posicionHogar = posicionHogar;
	}

	/**
	 * @return the numeroDependientes
	 */
	public java.lang.Integer getNumeroDependientes() {
		return numeroDependientes;
	}

	/**
	 * @param numeroDependientes the numeroDependientes to set
	 */
	public void setNumeroDependientes(java.lang.Integer numeroDependientes) {
		this.numeroDependientes = numeroDependientes;
	}

	/**
	 * @return the experienciaCreditoGrupal
	 */
	public java.lang.Boolean getExperienciaCreditoGrupal() {
		return experienciaCreditoGrupal;
	}

	/**
	 * @param experienciaCreditoGrupal the experienciaCreditoGrupal to set
	 */
	public void setExperienciaCreditoGrupal(
			java.lang.Boolean experienciaCreditoGrupal) {
		this.experienciaCreditoGrupal = experienciaCreditoGrupal;
	}

	/**
	 * @return the funcionarioPublico
	 */
	public java.lang.Boolean getFuncionarioPublico() {
		return funcionarioPublico;
	}

	/**
	 * @param funcionarioPublico the funcionarioPublico to set
	 */
	public void setFuncionarioPublico(java.lang.Boolean funcionarioPublico) {
		this.funcionarioPublico = funcionarioPublico;
	}

	/**
	 * @return the relacionFuncionario
	 */
	public java.lang.Boolean getRelacionFuncionario() {
		return relacionFuncionario;
	}

	/**
	 * @param relacionFuncionario the relacionFuncionario to set
	 */
	public void setRelacionFuncionario(java.lang.Boolean relacionFuncionario) {
		this.relacionFuncionario = relacionFuncionario;
	}

	/**
	 * @return the personalidad
	 */
	public java.lang.String getPersonalidad() {
		return personalidad;
	}

	/**
	 * @param personalidad the personalidad to set
	 */
	public void setPersonalidad(java.lang.String personalidad) {
		this.personalidad = personalidad;
	}

	/**
	 * @return the calificacion
	 */
	public java.lang.Integer getCalificacion() {
		return calificacion;
	}

	/**
	 * @param calificacion the calificacion to set
	 */
	public void setCalificacion(java.lang.Integer calificacion) {
		this.calificacion = calificacion;
	}

	/**
	 * @return the ciclo
	 */
	public java.lang.Integer getCiclo() {
		return ciclo;
	}

	/**
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(java.lang.Integer ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * @return the prospecto
	 */
	public java.lang.Boolean getProspecto() {
		return prospecto;
	}

	/**
	 * @param prospecto the prospecto to set
	 */
	public void setProspecto(java.lang.Boolean prospecto) {
		this.prospecto = prospecto;
	}

	/**
	 * @return the operador
	 */
	public java.lang.String getOperador() {
		return operador;
	}

	/**
	 * @param operador the operador to set
	 */
	public void setOperador(java.lang.String operador) {
		this.operador = operador;
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
	 * @return the bloqueo
	 */
	public java.lang.String getBloqueo() {
		return bloqueo;
	}

	/**
	 * @param bloqueo the bloqueo to set
	 */
	public void setBloqueo(java.lang.String bloqueo) {
		this.bloqueo = bloqueo;
	}

	/**
	 * @return the fechaBloqueo
	 */
	public java.util.Date getFechaBloqueo() {
		return fechaBloqueo;
	}

	/**
	 * @param fechaBloqueo the fechaBloqueo to set
	 */
	public void setFechaBloqueo(java.util.Date fechaBloqueo) {
		this.fechaBloqueo = fechaBloqueo;
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
	 * @return the asesorCredito
	 */
	public java.lang.String getAsesorCredito() {
		return asesorCredito;
	}

	/**
	 * @param asesorCredito the asesorCredito to set
	 */
	public void setAsesorCredito(java.lang.String asesorCredito) {
		this.asesorCredito = asesorCredito;
	}

	/**
	 * @return the sucursal
	 */
	public java.lang.Integer getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(java.lang.Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * @return the email
	 */
	public java.lang.String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	/**
	 * @return the telefonoFijo
	 */
	public java.lang.String getTelefonoFijo() {
		return telefonoFijo;
	}

	/**
	 * @param telefonoFijo the telefonoFijo to set
	 */
	public void setTelefonoFijo(java.lang.String telefonoFijo) {
		this.telefonoFijo = telefonoFijo;
	}

	/**
	 * @return the telefonoCelular
	 */
	public java.lang.String getTelefonoCelular() {
		return telefonoCelular;
	}

	/**
	 * @param telefonoCelular the telefonoCelular to set
	 */
	public void setTelefonoCelular(java.lang.String telefonoCelular) {
		this.telefonoCelular = telefonoCelular;
	}

	/**
	 * @return the telefonoEmpleo
	 */
	public java.lang.String getTelefonoEmpleo() {
		return telefonoEmpleo;
	}

	/**
	 * @param telefonoEmpleo the telefonoEmpleo to set
	 */
	public void setTelefonoEmpleo(java.lang.String telefonoEmpleo) {
		this.telefonoEmpleo = telefonoEmpleo;
	}

	/**
	 * @return the telefonoRecados
	 */
	public java.lang.String getTelefonoRecados() {
		return telefonoRecados;
	}

	/**
	 * @param telefonoRecados the telefonoRecados to set
	 */
	public void setTelefonoRecados(java.lang.String telefonoRecados) {
		this.telefonoRecados = telefonoRecados;
	}

	/**
	 * @return the nombreRecadero
	 */
	public java.lang.String getNombreRecadero() {
		return nombreRecadero;
	}

	/**
	 * @param nombreRecadero the nombreRecadero to set
	 */
	public void setNombreRecadero(java.lang.String nombreRecadero) {
		this.nombreRecadero = nombreRecadero;
	}

	/**
	 * @return the nombrePareja
	 */
	public java.lang.String getNombrePareja() {
		return nombrePareja;
	}

	/**
	 * @param nombrePareja the nombrePareja to set
	 */
	public void setNombrePareja(java.lang.String nombrePareja) {
		this.nombrePareja = nombrePareja;
	}

	/**
	 * @return the apellidoPaternoPareja
	 */
	public java.lang.String getApellidoPaternoPareja() {
		return apellidoPaternoPareja;
	}

	/**
	 * @param apellidoPaternoPareja the apellidoPaternoPareja to set
	 */
	public void setApellidoPaternoPareja(java.lang.String apellidoPaternoPareja) {
		this.apellidoPaternoPareja = apellidoPaternoPareja;
	}

	/**
	 * @return the apellidoMaternoPareja
	 */
	public java.lang.String getApellidoMaternoPareja() {
		return apellidoMaternoPareja;
	}

	/**
	 * @param apellidoMaternoPareja the apellidoMaternoPareja to set
	 */
	public void setApellidoMaternoPareja(java.lang.String apellidoMaternoPareja) {
		this.apellidoMaternoPareja = apellidoMaternoPareja;
	}

	/**
	 * @return the ocupacionPareja
	 */
	public java.lang.String getOcupacionPareja() {
		return ocupacionPareja;
	}

	/**
	 * @param ocupacionPareja the ocupacionPareja to set
	 */
	public void setOcupacionPareja(java.lang.String ocupacionPareja) {
		this.ocupacionPareja = ocupacionPareja;
	}

	/**
	 * @return the lugarTrabajoPareja
	 */
	public java.lang.String getLugarTrabajoPareja() {
		return lugarTrabajoPareja;
	}

	/**
	 * @param lugarTrabajoPareja the lugarTrabajoPareja to set
	 */
	public void setLugarTrabajoPareja(java.lang.String lugarTrabajoPareja) {
		this.lugarTrabajoPareja = lugarTrabajoPareja;
	}

	/**
	 * @return the telefonoCelularPareja
	 */
	public java.lang.String getTelefonoCelularPareja() {
		return telefonoCelularPareja;
	}

	/**
	 * @param telefonoCelularPareja the telefonoCelularPareja to set
	 */
	public void setTelefonoCelularPareja(java.lang.String telefonoCelularPareja) {
		this.telefonoCelularPareja = telefonoCelularPareja;
	}

	/**
	 * @return the telefonoTrabajoPareja
	 */
	public java.lang.String getTelefonoTrabajoPareja() {
		return telefonoTrabajoPareja;
	}

	/**
	 * @param telefonoTrabajoPareja the telefonoTrabajoPareja to set
	 */
	public void setTelefonoTrabajoPareja(java.lang.String telefonoTrabajoPareja) {
		this.telefonoTrabajoPareja = telefonoTrabajoPareja;
	}

	/**
	 * @return the domicilioPersona
	 */
	public DomicilioOV getDomicilioPersona() {
		return domicilioPersona;
	}

	/**
	 * @param domicilioPersona the domicilioPersona to set
	 */
	public void setDomicilioPersona(DomicilioOV domicilioPersona) {
		this.domicilioPersona = domicilioPersona;
	}

	/**
	 * @return the detalleSocioeconomico
	 */
	public DetalleSocioeconomicoOV getDetalleSocioeconomico() {
		return detalleSocioeconomico;
	}

	/**
	 * @param detalleSocioeconomico the detalleSocioeconomico to set
	 */
	public void setDetalleSocioeconomico(
			DetalleSocioeconomicoOV detalleSocioeconomico) {
		this.detalleSocioeconomico = detalleSocioeconomico;
	}

	/**
	 * @return the domicilioNegocio
	 */
	public DomicilioOV getDomicilioNegocio() {
		return domicilioNegocio;
	}

	/**
	 * @param domicilioNegocio the domicilioNegocio to set
	 */
	public void setDomicilioNegocio(DomicilioOV domicilioNegocio) {
		this.domicilioNegocio = domicilioNegocio;
	}

	/**
	 * @return the referencias
	 */
	public List<ReferenciaOV> getReferencias() {
		return referencias;
	}

	/**
	 * @param referencias the referencias to set
	 */
	public void setReferencias(List<ReferenciaOV> referencias) {
		this.referencias = referencias;
	}

	/**
	 * @return the nombreGerenteSucursal
	 */
	public java.lang.String getNombreGerenteSucursal() {
		return nombreGerenteSucursal;
	}

	/**
	 * @param nombreGerenteSucursal the nombreGerenteSucursal to set
	 */
	public void setNombreGerenteSucursal(java.lang.String nombreGerenteSucursal) {
		this.nombreGerenteSucursal = nombreGerenteSucursal;
	}

	/**
	 * @return the nombreAsesor
	 */
	public java.lang.String getNombreAsesor() {
		return nombreAsesor;
	}

	/**
	 * @param nombreAsesor the nombreAsesor to set
	 */
	public void setNombreAsesor(java.lang.String nombreAsesor) {
		this.nombreAsesor = nombreAsesor;
	}

	/**
	 * @return the numeroHijos
	 */
	public java.lang.Integer getNumeroHijos() {
		return numeroHijos;
	}

	/**
	 * @param numeroHijos the numeroHijos to set
	 */
	public void setNumeroHijos(java.lang.Integer numeroHijos) {
		this.numeroHijos = numeroHijos;
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
	 * @return the firmaElectronica
	 */
	public java.lang.String getFirmaElectronica() {
		return firmaElectronica;
	}

	/**
	 * @param firmaElectronica the firmaElectronica to set
	 */
	public void setFirmaElectronica(java.lang.String firmaElectronica) {
		this.firmaElectronica = firmaElectronica;
	}

}
