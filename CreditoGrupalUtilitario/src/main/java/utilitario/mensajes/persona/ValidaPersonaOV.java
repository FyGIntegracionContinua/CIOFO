package utilitario.mensajes.persona;

import java.util.List;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * Este objeto esta en relacion directa con la tabla PERSONAS.
 *
 * @author out_mreyes@independencia.com.mx
 */
public 	class 	ValidaPersonaOV extends ObjetoValor {

	/** UID para serializacion. */
	private static final long serialVersionUID = -2621323062230990134L;

	/** The numero persona. */
	private String						numeroPersona;

	/** The tipo captura. */
	private String						tipoCaptura;

	/** The monto pago semanal. */
	private Double						montoPagoSemanal;

	/** The nombre. */
	private String						nombre;

	/** The apellido paterno. */
	private String 						apellidoPaterno;

	/** The apellido materno. */
	private String 						apellidoMaterno;

	/** The sobrenombre. */
	private String						sobrenombre;

	/** The fecha nacimiento. */
	private String						fechaNacimiento;

	/** The curp. */
	private String						curp;

	/** The rfc. */
	private String						rfc;

	/** The tipo identificacion. */
	private String						tipoIdentificacion;

	/** The numero identificacion. */
	private String						numeroIdentificacion;

	/** The sexo. */
	private String						sexo;

	/** The entidad lugar nacimiento. */
	private String						entidadLugarNacimiento;

	/** The pais nacimiento. */
	private String						paisNacimiento;

	/** The nacionalidad. */
	private String						nacionalidad;

	/** The estado civil. */
	private String						estadoCivil;

	/** The ocupacion. */
	private String						ocupacion;

	/** The posicion hogar. */
	private String						posicionHogar;

	/** The numero dependientes. */
	private Integer						numeroDependientes;

	/** The correo. */
	private String 						correo;

	/** The experiencia credito grupal. */
	private String						experienciaCreditoGrupal;

	/** The funcionario publico. */
	private String 					funcionarioPublico;

	/** The relacion funcionario. */
	private String 					relacionFuncionarioPublico;

	//informacion Conyuge
	/** The nombre conyuge. */
	private String						nombreConyuge;

	/** The ap pat conyuge. */
	private String						apPatConyuge;

	/** The ap mat conyuge. */
	private String						apMatConyuge;

	/** The inicia negocio. */
	private String		iniciaNegocio;

	/** The tipo actividad. */
	private String		tipoActividad;

	/** The tipo establecimiento. */
	private String		tipoEstablecimiento;

	/** The actividad empresarial. */
	private String		actividadEmpresarial;

	/** The num empleados. */
	private Integer		numEmpleados;

	/** The exp rubro. */
	private Integer		expRubro;

	/** The exp negocio. */
	private Integer		expNegocio;

	/** The monto ventas. */
	private Double		montoVentas;

	/** The ganancia neta. */
	private Double		gananciaNeta;

	/** The otros ingresos. */
	private Double		otrosIngresos;

	/** The ganancia act sec. */
	private Double		gananciaActSec;

	/** The gastos familiares. */
	private Double		gastosFamiliares;

	/** The tipo vivienda. */
	private String tipoVivienda;


	//Objetos y tablas relacionadas
	//Domicilios
	/** The domicilio persona. */
	private DomicilioOV					domicilioPersona;

	//Socioeconomicos
	/** The detalle socioeconomico. */
	private DetalleSocioeconomicoOV		detalleSocioeconomico;

	//Referencias
	/** The relaciones persona. */
	private List<RelacionPersonaOV>		relacionesPersona;


	/**
	 * Instancia una nueva persona ov.
	 */
	public ValidaPersonaOV() {

	}


	/**
	 * Obtiene numero persona.
	 *
	 * @return the numeroPersona
	 */
	public String getNumeroPersona() {
		return numeroPersona;
	}


	/**
	 * Establece numero persona.
	 *
	 * @param numeroPersona the numeroPersona to set
	 */
	public void setNumeroPersona(String numeroPersona) {
		this.numeroPersona = numeroPersona;
	}


	/**
	 * Obtiene nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * Establece nombre.
	 *
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * Obtiene apellido paterno.
	 *
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}


	/**
	 * Establece apellido paterno.
	 *
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}


	/**
	 * Obtiene apellido materno.
	 *
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}


	/**
	 * Establece apellido materno.
	 *
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}


	/**
	 * Obtiene sobrenombre.
	 *
	 * @return the sobrenombre
	 */
	public String getSobrenombre() {
		return sobrenombre;
	}


	/**
	 * Establece sobrenombre.
	 *
	 * @param sobrenombre the sobrenombre to set
	 */
	public void setSobrenombre(String sobrenombre) {
		this.sobrenombre = sobrenombre;
	}


	/**
	 * Obtiene rfc.
	 *
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}


	/**
	 * Establece rfc.
	 *
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}


	/**
	 * Obtiene curp.
	 *
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}


	/**
	 * Establece curp.
	 *
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}


	/**
	 * Obtiene tipo identificacion.
	 *
	 * @return the tipoIdentificacion
	 */
	public String getTipoIdentificacion() {
		return tipoIdentificacion;
	}


	/**
	 * Establece tipo identificacion.
	 *
	 * @param tipoIdentificacion the tipoIdentificacion to set
	 */
	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}


	/**
	 * Obtiene numero identificacion.
	 *
	 * @return the numeroIdentificacion
	 */
	public String getNumeroIdentificacion() {
		return numeroIdentificacion;
	}


	/**
	 * Establece numero identificacion.
	 *
	 * @param numeroIdentificacion the numeroIdentificacion to set
	 */
	public void setNumeroIdentificacion(String numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}


	/**
	 * Obtiene fecha nacimiento.
	 *
	 * @return the fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	/**
	 * Establece fecha nacimiento.
	 *
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	/**
	 * Obtiene sexo.
	 *
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}


	/**
	 * Establece sexo.
	 *
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	/**
	 * Obtiene entidad lugar nacimiento.
	 *
	 * @return the entidadLugarNacimiento
	 */
	public String getEntidadLugarNacimiento() {
		return entidadLugarNacimiento;
	}


	/**
	 * Establece entidad lugar nacimiento.
	 *
	 * @param entidadLugarNacimiento the entidadLugarNacimiento to set
	 */
	public void setEntidadLugarNacimiento(String entidadLugarNacimiento) {
		this.entidadLugarNacimiento = entidadLugarNacimiento;
	}


	/**
	 * Obtiene pais nacimiento.
	 *
	 * @return the paisNacimiento
	 */
	public String getPaisNacimiento() {
		return paisNacimiento;
	}


	/**
	 * Establece pais nacimiento.
	 *
	 * @param paisNacimiento the paisNacimiento to set
	 */
	public void setPaisNacimiento(String paisNacimiento) {
		this.paisNacimiento = paisNacimiento;
	}


	/**
	 * Obtiene nacionalidad.
	 *
	 * @return the nacionalidad
	 */
	public String getNacionalidad() {
		return nacionalidad;
	}


	/**
	 * Establece nacionalidad.
	 *
	 * @param nacionalidad the nacionalidad to set
	 */
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	/**
	 * Obtiene estado civil.
	 *
	 * @return the estadoCivil
	 */
	public String getEstadoCivil() {
		return estadoCivil;
	}


	/**
	 * Establece estado civil.
	 *
	 * @param estadoCivil the estadoCivil to set
	 */
	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	/**
	 * Obtiene ocupacion.
	 *
	 * @return the ocupacion
	 */
	public String getOcupacion() {
		return ocupacion;
	}


	/**
	 * Establece ocupacion.
	 *
	 * @param ocupacion the ocupacion to set
	 */
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}


	/**
	 * Obtiene posicion hogar.
	 *
	 * @return the posicionHogar
	 */
	public String getPosicionHogar() {
		return posicionHogar;
	}


	/**
	 * Establece posicion hogar.
	 *
	 * @param posicionHogar the posicionHogar to set
	 */
	public void setPosicionHogar(String posicionHogar) {
		this.posicionHogar = posicionHogar;
	}


	/**
	 * Obtiene numero dependientes.
	 *
	 * @return the numeroDependientes
	 */
	public Integer getNumeroDependientes() {
		return numeroDependientes;
	}


	/**
	 * Establece numero dependientes.
	 *
	 * @param numeroDependientes the numeroDependientes to set
	 */
	public void setNumeroDependientes(Integer numeroDependientes) {
		this.numeroDependientes = numeroDependientes;
	}


	/**
	 * Obtiene experiencia credito grupal.
	 *
	 * @return the experienciaCreditoGrupal
	 */
	public String getExperienciaCreditoGrupal() {
		return experienciaCreditoGrupal;
	}


	/**
	 * Establece experiencia credito grupal.
	 *
	 * @param experienciaCreditoGrupal the experienciaCreditoGrupal to set
	 */
	public void setExperienciaCreditoGrupal(
			String experienciaCreditoGrupal) {
		this.experienciaCreditoGrupal = experienciaCreditoGrupal;
	}


	/**
	 * Obtiene funcionario publico.
	 *
	 * @return the funcionarioPublico
	 */
	public String getFuncionarioPublico() {
		return funcionarioPublico;
	}


	/**
	 * Establece funcionario publico.
	 *
	 * @param funcionarioPublico the funcionarioPublico to set
	 */
	public void setFuncionarioPublico(String funcionarioPublico) {
		this.funcionarioPublico = funcionarioPublico;
	}


	/**
	 * Gets the tipo captura.
	 *
	 * @return the tipo captura
	 */
	public String getTipoCaptura() {
		return tipoCaptura;
	}


	/**
	 * Sets the tipo captura.
	 *
	 * @param tipoCaptura the new tipo captura
	 */
	public void setTipoCaptura(String tipoCaptura) {
		this.tipoCaptura = tipoCaptura;
	}


	/**
	 * Gets the monto pago semanal.
	 *
	 * @return the monto pago semanal
	 */
	public Double getMontoPagoSemanal() {
		return montoPagoSemanal;
	}


	/**
	 * Sets the monto pago semanal.
	 *
	 * @param montoPagoSemanal the new monto pago semanal
	 */
	public void setMontoPagoSemanal(Double montoPagoSemanal) {
		this.montoPagoSemanal = montoPagoSemanal;
	}


	/**
	 * Gets the correo.
	 *
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}


	/**
	 * Sets the correo.
	 *
	 * @param correo the new correo
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}


	/**
	 * Gets the relacion funcionario publico.
	 *
	 * @return the relacion funcionario publico
	 */
	public String getRelacionFuncionarioPublico() {
		return relacionFuncionarioPublico;
	}


	/**
	 * Sets the relacion funcionario publico.
	 *
	 * @param relacionFuncionarioPublico the new relacion funcionario publico
	 */
	public void setRelacionFuncionarioPublico(String relacionFuncionarioPublico) {
		this.relacionFuncionarioPublico = relacionFuncionarioPublico;
	}


	/**
	 * Gets the nombre conyuge.
	 *
	 * @return the nombre conyuge
	 */
	public String getNombreConyuge() {
		return nombreConyuge;
	}


	/**
	 * Sets the nombre conyuge.
	 *
	 * @param nombreConyuge the new nombre conyuge
	 */
	public void setNombreConyuge(String nombreConyuge) {
		this.nombreConyuge = nombreConyuge;
	}


	/**
	 * Gets the ap pat conyuge.
	 *
	 * @return the ap pat conyuge
	 */
	public String getApPatConyuge() {
		return apPatConyuge;
	}


	/**
	 * Sets the ap pat conyuge.
	 *
	 * @param apPatConyuge the new ap pat conyuge
	 */
	public void setApPatConyuge(String apPatConyuge) {
		this.apPatConyuge = apPatConyuge;
	}


	/**
	 * Gets the ap mat conyuge.
	 *
	 * @return the ap mat conyuge
	 */
	public String getApMatConyuge() {
		return apMatConyuge;
	}


	/**
	 * Sets the ap mat conyuge.
	 *
	 * @param apMatConyuge the new ap mat conyuge
	 */
	public void setApMatConyuge(String apMatConyuge) {
		this.apMatConyuge = apMatConyuge;
	}


	/**
	 * Gets the domicilio persona.
	 *
	 * @return the domicilio persona
	 */
	public DomicilioOV getDomicilioPersona() {
		return domicilioPersona;
	}


	/**
	 * Sets the domicilio persona.
	 *
	 * @param domicilioPersona the new domicilio persona
	 */
	public void setDomicilioPersona(DomicilioOV domicilioPersona) {
		this.domicilioPersona = domicilioPersona;
	}


	/**
	 * Gets the detalle socioeconomico.
	 *
	 * @return the detalle socioeconomico
	 */
	public DetalleSocioeconomicoOV getDetalleSocioeconomico() {
		return detalleSocioeconomico;
	}


	/**
	 * Sets the detalle socioeconomico.
	 *
	 * @param detalleSocioeconomico the new detalle socioeconomico
	 */
	public void setDetalleSocioeconomico(
			DetalleSocioeconomicoOV detalleSocioeconomico) {
		this.detalleSocioeconomico = detalleSocioeconomico;
	}


	/**
	 * Gets the relaciones persona.
	 *
	 * @return the relaciones persona
	 */
	public List<RelacionPersonaOV> getRelacionesPersona() {
		return relacionesPersona;
	}


	/**
	 * Sets the relaciones persona.
	 *
	 * @param relacionesPersona the new relaciones persona
	 */
	public void setRelacionesPersona(List<RelacionPersonaOV> relacionesPersona) {
		this.relacionesPersona = relacionesPersona;
	}


	/**
	 * Gets the inicia negocio.
	 *
	 * @return the inicia negocio
	 */
	public String getIniciaNegocio() {
		return iniciaNegocio;
	}


	/**
	 * Sets the inicia negocio.
	 *
	 * @param iniciaNegocio the new inicia negocio
	 */
	public void setIniciaNegocio(String iniciaNegocio) {
		this.iniciaNegocio = iniciaNegocio;
	}


	/**
	 * Gets the tipo actividad.
	 *
	 * @return the tipo actividad
	 */
	public String getTipoActividad() {
		return tipoActividad;
	}


	/**
	 * Sets the tipo actividad.
	 *
	 * @param tipoActividad the new tipo actividad
	 */
	public void setTipoActividad(String tipoActividad) {
		this.tipoActividad = tipoActividad;
	}


	/**
	 * Gets the tipo establecimiento.
	 *
	 * @return the tipo establecimiento
	 */
	public String getTipoEstablecimiento() {
		return tipoEstablecimiento;
	}


	/**
	 * Sets the tipo establecimiento.
	 *
	 * @param tipoEstablecimiento the new tipo establecimiento
	 */
	public void setTipoEstablecimiento(String tipoEstablecimiento) {
		this.tipoEstablecimiento = tipoEstablecimiento;
	}


	/**
	 * Gets the actividad empresarial.
	 *
	 * @return the actividad empresarial
	 */
	public String getActividadEmpresarial() {
		return actividadEmpresarial;
	}


	/**
	 * Sets the actividad empresarial.
	 *
	 * @param actividadEmpresarial the new actividad empresarial
	 */
	public void setActividadEmpresarial(String actividadEmpresarial) {
		this.actividadEmpresarial = actividadEmpresarial;
	}


	/**
	 * Gets the num empleados.
	 *
	 * @return the num empleados
	 */
	public Integer getNumEmpleados() {
		return numEmpleados;
	}


	/**
	 * Sets the num empleados.
	 *
	 * @param numEmpleados the new num empleados
	 */
	public void setNumEmpleados(Integer numEmpleados) {
		this.numEmpleados = numEmpleados;
	}


	/**
	 * Gets the exp rubro.
	 *
	 * @return the exp rubro
	 */
	public Integer getExpRubro() {
		return expRubro;
	}


	/**
	 * Sets the exp rubro.
	 *
	 * @param expRubro the new exp rubro
	 */
	public void setExpRubro(Integer expRubro) {
		this.expRubro = expRubro;
	}


	/**
	 * Gets the exp negocio.
	 *
	 * @return the exp negocio
	 */
	public Integer getExpNegocio() {
		return expNegocio;
	}


	/**
	 * Sets the exp negocio.
	 *
	 * @param expNegocio the new exp negocio
	 */
	public void setExpNegocio(Integer expNegocio) {
		this.expNegocio = expNegocio;
	}


	/**
	 * Gets the monto ventas.
	 *
	 * @return the monto ventas
	 */
	public Double getMontoVentas() {
		return montoVentas;
	}


	/**
	 * Sets the monto ventas.
	 *
	 * @param montoVentas the new monto ventas
	 */
	public void setMontoVentas(Double montoVentas) {
		this.montoVentas = montoVentas;
	}


	/**
	 * Gets the ganancia neta.
	 *
	 * @return the ganancia neta
	 */
	public Double getGananciaNeta() {
		return gananciaNeta;
	}


	/**
	 * Sets the ganancia neta.
	 *
	 * @param gananciaNeta the new ganancia neta
	 */
	public void setGananciaNeta(Double gananciaNeta) {
		this.gananciaNeta = gananciaNeta;
	}


	/**
	 * Gets the otros ingresos.
	 *
	 * @return the otros ingresos
	 */
	public Double getOtrosIngresos() {
		return otrosIngresos;
	}


	/**
	 * Sets the otros ingresos.
	 *
	 * @param otrosIngresos the new otros ingresos
	 */
	public void setOtrosIngresos(Double otrosIngresos) {
		this.otrosIngresos = otrosIngresos;
	}


	/**
	 * Gets the ganancia act sec.
	 *
	 * @return the ganancia act sec
	 */
	public Double getGananciaActSec() {
		return gananciaActSec;
	}


	/**
	 * Sets the ganancia act sec.
	 *
	 * @param gananciaActSec the new ganancia act sec
	 */
	public void setGananciaActSec(Double gananciaActSec) {
		this.gananciaActSec = gananciaActSec;
	}


	/**
	 * Gets the gastos familiares.
	 *
	 * @return the gastos familiares
	 */
	public Double getGastosFamiliares() {
		return gastosFamiliares;
	}


	/**
	 * Sets the gastos familiares.
	 *
	 * @param gastosFamiliares the new gastos familiares
	 */
	public void setGastosFamiliares(Double gastosFamiliares) {
		this.gastosFamiliares = gastosFamiliares;
	}


	/**
	 * Gets the tipo vivienda.
	 *
	 * @return the tipo vivienda
	 */
	public String getTipoVivienda() {
		return tipoVivienda;
	}


	/**
	 * Sets the tipo vivienda.
	 *
	 * @param tipoVivienda the new tipo vivienda
	 */
	public void setTipoVivienda(String tipoVivienda) {
		this.tipoVivienda = tipoVivienda;
	}


}
