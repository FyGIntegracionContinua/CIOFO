package utilitario.mensajes.consultas;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class DatosClienteOV.
 *
 * @author out_oarias
 */
public class DatosClienteOV extends ObjetoValor {

	/**
	 * Instancia una nueva datos cliente ov.
	 */
	public DatosClienteOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The ultimo ld. */
	private String 				ultimoLD;

	/** The fecha liquidacion. */
	private Date 				fechaLiquidacion;

	/** The fecha vencimiento. */
	private Date 				fechaVencimiento;

	/** The monto otorgado. */
	private Double 				montoOtorgado;

	/** The fecha mora. */
	private int 				fechaMora;

	/** The ciclo cliente. */
	private Integer 			cicloCliente;

	/** The nombre completo. */
	private String  			nombreCompleto;

	/** The fecha nacimiento. */
	private Date 				fechaNacimiento;

	/** The rfc. */
	private String  			rfc;

	/** The curp. */
	private String  			curp;

	/** The fecha proximo pago. */
	private Date 				fechaProximoPago;

	/** The estatus. */
	private String      		estatus;

	/** The mora. */
	private int	        		mora;

	/** The codigo grupo. */
	private String				codigoGrupo;

	/** The nombre grupo. */
	private String 				nombreGrupo;

	/** The calle. */
	private java.lang.String	calle;

	/** The colonia. */
	private java.lang.String	colonia;

	/** The localidad. */
	private java.lang.String	localidad;

	/** The estado. */
	private java.lang.String	estado;

	/** The cp. */
	private java.lang.String	cp;

	/** The municipio. */
	private java.lang.String	municipio;

	/** The pais. */
	private java.lang.String	pais;

	/** The actividademp. */
	private java.lang.String	actividademp;

	/** The saldo. */
	private java.lang.String	saldo;

	/** The persona. */
	private java.lang.String	persona;

	/** The estatusDesc. */
	private java.lang.String	estatusDesc;

	/** The tipoLocalidad. */
	private java.lang.String	tipoLocalidad;

	/** The experiencia. */
	private java.lang.String	experiencia;

	/** The edad */
	private int	        		edad;

	/** The estatusCliente. */
	private java.lang.String	estatusRenovacionCliente;

	/**
	 * Obtiene nombre completo.
	 *
	 * @return the nombreCompleto
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	/**
	 * Establece nombre completo.
	 *
	 * @param nombreCompleto the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	/**
	 * Obtiene fecha mora.
	 *
	 * @return the fechaMora
	 */
	public int getFechaMora() {
		return fechaMora;
	}

	/**
	 * Establece fecha mora.
	 *
	 * @param fechaMora the fechaMora to set
	 */
	public void setFechaMora(int fechaMora) {
		this.fechaMora = fechaMora;
	}

	/**
	 * Obtiene ultimo ld.
	 *
	 * @return the ultimoLD
	 */
	public String getUltimoLD() {
		return ultimoLD;
	}

	/**
	 * Establece ultimo ld.
	 *
	 * @param ultimoLD the ultimoLD to set
	 */
	public void setUltimoLD(String ultimoLD) {
		this.ultimoLD = ultimoLD;
	}

	/**
	 * Obtiene fecha liquidacion.
	 *
	 * @return the fechaLiquidacion
	 */
	public Date getFechaLiquidacion() {
		return fechaLiquidacion;
	}

	/**
	 * Establece fecha liquidacion.
	 *
	 * @param fechaLiquidacion the fechaLiquidacion to set
	 */
	public void setFechaLiquidacion(Date fechaLiquidacion) {
		this.fechaLiquidacion = fechaLiquidacion;
	}

	/**
	 * Obtiene fecha vencimiento.
	 *
	 * @return the fechaVencimiento
	 */
	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	/**
	 * Establece fecha vencimiento.
	 *
	 * @param fechaVencimiento the fechaVencimiento to set
	 */
	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	/**
	 * Obtiene monto otorgado.
	 *
	 * @return the montoOtorgado
	 */
	public Double getMontoOtorgado() {
		return montoOtorgado;
	}

	/**
	 * Establece monto otorgado.
	 *
	 * @param montoOtorgado the montoOtorgado to set
	 */
	public void setMontoOtorgado(Double montoOtorgado) {
		this.montoOtorgado = montoOtorgado;
	}

	/**
	 * Obtiene ciclo cliente.
	 *
	 * @return the cicloCliente
	 */
	public Integer getCicloCliente() {
		return cicloCliente;
	}

	/**
	 * Establece ciclo cliente.
	 *
	 * @param cicloCliente the cicloCliente to set
	 */
	public void setCicloCliente(Integer cicloCliente) {
		this.cicloCliente = cicloCliente;
	}

	/**
	 * Obtiene fecha nacimiento.
	 *
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Establece fecha nacimiento.
	 *
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * Obtiene fecha proximo pago.
	 *
	 * @return the fechaProximoPago
	 */
	public Date getFechaProximoPago() {
		return fechaProximoPago;
	}

	/**
	 * Establece fecha proximo pago.
	 *
	 * @param fechaProximoPago the fechaProximoPago to set
	 */
	public void setFechaProximoPago(Date fechaProximoPago) {
		this.fechaProximoPago = fechaProximoPago;
	}

	/**
	 * Obtiene estatus.
	 *
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * Establece estatus.
	 *
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * Obtiene mora.
	 *
	 * @return the mora
	 */
	public int getMora() {
		return mora;
	}

	/**
	 * Establece mora.
	 *
	 * @param mora the mora to set
	 */
	public void setMora(int mora) {
		this.mora = mora;
	}

	/**
	 * Obtiene codigo grupo.
	 *
	 * @return codigo grupo
	 */
	public String getCodigoGrupo() {
		return codigoGrupo;
	}

	/**
	 * Establece codigo grupo.
	 *
	 * @param codigoGrupo a codigo grupo
	 */
	public void setCodigoGrupo(String codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}

	/**
	 * Obtiene nombre grupo.
	 *
	 * @return nombre grupo
	 */
	public String getNombreGrupo() {
		return nombreGrupo;
	}

	/**
	 * Establece nombre grupo.
	 *
	 * @param nombreGrupo a nombre grupo
	 */
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	/**
	 * Establece calle.
	 *
	 * @param calle a calle
	 */
	public void setCalle(java.lang.String calle) {
		this.calle = calle;
	}

	/**
	 * Obtiene calle.
	 *
	 * @return calle
	 */
	public java.lang.String getCalle() {
		return calle;
	}

	/**
	 * Establece colonia.
	 *
	 * @param colonia a colonia
	 */
	public void setColonia(java.lang.String colonia) {
		this.colonia = colonia;
	}

	/**
	 * Obtiene colonia.
	 *
	 * @return colonia
	 */
	public java.lang.String getColonia() {
		return colonia;
	}

	/**
	 * Establece estado.
	 *
	 * @param estado a estado
	 */
	public void setEstado(java.lang.String estado) {
		this.estado = estado;
	}

	/**
	 * Obtiene estado.
	 *
	 * @return estado
	 */
	public java.lang.String getEstado() {
		return estado;
	}

	/**
	 * Establece cp.
	 *
	 * @param cp a cp
	 */
	public void setCp(java.lang.String cp) {
		this.cp = cp;
	}

	/**
	 * Obtiene cp.
	 *
	 * @return cp
	 */
	public java.lang.String getCp() {
		return cp;
	}

	/**
	 * Establece municipio.
	 *
	 * @param municipio a municipio
	 */
	public void setMunicipio(java.lang.String municipio) {
		this.municipio = municipio;
	}

	/**
	 * Obtiene municipio.
	 *
	 * @return municipio
	 */
	public java.lang.String getMunicipio() {
		return municipio;
	}

	/**
	 * Establece pais.
	 *
	 * @param pais a pais
	 */
	public void setPais(java.lang.String pais) {
		this.pais = pais;
	}

	/**
	 * Obtiene pais.
	 *
	 * @return pais
	 */
	public java.lang.String getPais() {
		return pais;
	}

	/**
	 * Establece actividademp.
	 *
	 * @param actividademp a actividademp
	 */
	public void setActividademp(java.lang.String actividademp) {
		this.actividademp = actividademp;
	}

	/**
	 * Obtiene actividademp.
	 *
	 * @return actividademp
	 */
	public java.lang.String getActividademp() {
		return actividademp;
	}

	/**
	 * Obtiene saldo.
	 *
	 * @return the saldo
	 */
	public java.lang.String getSaldo() {
		return saldo;
	}

	/**
	 * Establece saldo.
	 *
	 * @param saldo the saldo to set
	 */
	public void setSaldo(java.lang.String saldo) {
		this.saldo = saldo;
	}

	/**
	 * Obtiene persona.
	 *
	 * @return the persona
	 */
	public java.lang.String getPersona() {
		return persona;
	}

	/**
	 * Establece persona.
	 *
	 * @param persona the persona to set
	 */
	public void setPersona(java.lang.String persona) {
		this.persona = persona;
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
	 * @return the estatusDesc
	 */
	public java.lang.String getEstatusDesc() {
		return estatusDesc;
	}

	/**
	 * @param estatusDesc the estatusDesc to set
	 */
	public void setEstatusDesc(java.lang.String estatusDesc) {
		this.estatusDesc = estatusDesc;
	}

	/**
	 * @return the tipoLocalidad
	 */
	public java.lang.String getTipoLocalidad() {
		return tipoLocalidad;
	}

	/**
	 * @param tipoLocalidad the tipoLocalidad to set
	 */
	public void setTipoLocalidad(java.lang.String tipoLocalidad) {
		this.tipoLocalidad = tipoLocalidad;
	}

	/**
	 * @return the experiencia
	 */
	public java.lang.String getExperiencia() {
		return experiencia;
	}

	/**
	 * @param experiencia the experiencia to set
	 */
	public void setExperiencia(java.lang.String experiencia) {
		this.experiencia = experiencia;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the estatusRenovacionCliente
	 */
	public java.lang.String getEstatusRenovacionCliente() {
		return estatusRenovacionCliente;
	}

	/**
	 * @param estatusRenovacionCliente the estatusRenovacionCliente to set
	 */
	public void setEstatusRenovacionCliente(
			java.lang.String estatusRenovacionCliente) {
		this.estatusRenovacionCliente = estatusRenovacionCliente;
	}

 }
