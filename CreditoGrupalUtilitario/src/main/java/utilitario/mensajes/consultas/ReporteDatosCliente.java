package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class ReporteDatosCliente.
 */
public 	class 		ReporteDatosCliente
		extends		ObjetoValor
		implements	java.io.Serializable {

	/**
	 * ReporteDatosCliente.
	 */
	public ReporteDatosCliente() {

	}

	/** UID para la serializacion. */
	private static final long serialVersionUID = 8894628822268863908L;
	/**
	 * cliente java.lang.String
	 */
	private java.lang.String	cliente;
	/**
	 * apellidoPat java.lang.String
	 */
	private java.lang.String    apellidoPat;
	/**
	 * apellidoMat java.lang.String
	 */
	private java.lang.String    apellidoMat;
	/**
	 * nombre java.lang.String
	 */
	private java.lang.String    nombre;
	/**
	 * fechanacimiento java.util.Date
	 */
	private java.util.Date		fechanacimiento;
	/**
	 * sexo java.lang.String
	 */
	private java.lang.String	sexo;
	/**
	 * calle java.lang.String
	 */
	private java.lang.String	calle;
	/**
	 * colonia java.lang.String
	 */
	private java.lang.String	colonia;
	/**
	 * municipio java.lang.String
	 */
	private java.lang.String	municipio;
	/**
	 * estado java.lang.String
	 */
	private java.lang.String	estado;
	/**
	 * cp java.lang.String
	 */
	private java.lang.String	cp;
	/**
	 * telefono java.lang.String
	 */
	private java.lang.String	telefono;
	/**
	 * estatus java.lang.String
	 */
	private java.lang.String	estatus;
	/**
	 * edad java.lang.Integer
	 */
	private java.lang.Integer   edad;
	/**
	 * rfc java.lang.String
	 */
	private java.lang.String	rfc;
	/**
	 * sucursal java.lang.String
	 */
	private java.lang.String	sucursal;
	/**
	 * nombreSucursal java.lang.String
	 */
	private java.lang.String	nombreSucursal;
	/**
	 * codigoGrupo java.lang.String
	 */
	private java.lang.String	codigoGrupo;
	/**
	 * nombreGrupo java.lang.String
	 */
	private java.lang.String	nombreGrupo;			//Cadena que puede contener el nombre de grupos
	/**
	 * ultimoLD java.lang.String
	 */
	private java.lang.String	ultimoLD;
	/**
	 * ciclo java.lang.String
	 */
	private java.lang.String	ciclo;
	/**
	 * montoOtorgado java.lang.Double
	 */
	private java.lang.Double	montoOtorgado;
	/**
	 * referenciabanamex java.lang.String
	 */
	private java.lang.String	referenciabanamex;
	/**
	 * referenciabancomer java.lang.String
	 */
	private java.lang.String	referenciabancomer;
	/**
	 * tipoIdentificacion java.lang.String
	 */
	private java.lang.String	tipoIdentificacion;
	/**
	 * numeroIdentificacion java.lang.String
	 */
	private java.lang.String	numeroIdentificacion;
	/**
	 * claveT24 java.lang.String
	 */
	private java.lang.String    claveT24;
	/**
	 * tipoTelefono java.lang.String
	 */
	private java.lang.String	tipoTelefono;
	/**
	 * contratoLD java.lang.String
	 */
	private java.lang.String	contratoLD;
	/**
	 * contrato java.lang.String
	 */
	private java.lang.String	contrato;

	/**
	 * Obtiene cliente.
	 *
	 * @return the cliente
	 */
	public java.lang.String getCliente() {
		return cliente;
	}

	/**
	 * Establece cliente.
	 *
	 * @param cliente the cliente to set
	 */
	public void setCliente(java.lang.String cliente) {
		this.cliente = cliente;
	}

	/**
	 * Obtiene apellido pat.
	 *
	 * @return the apellidoPat
	 */
	public java.lang.String getApellidoPat() {
		return apellidoPat;
	}

	/**
	 * Establece apellido pat.
	 *
	 * @param apellidoPat the apellidoPat to set
	 */
	public void setApellidoPat(java.lang.String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}

	/**
	 * Obtiene apellido mat.
	 *
	 * @return the apellidoMat
	 */
	public java.lang.String getApellidoMat() {
		return apellidoMat;
	}

	/**
	 * Establece apellido mat.
	 *
	 * @param apellidoMat the apellidoMat to set
	 */
	public void setApellidoMat(java.lang.String apellidoMat) {
		this.apellidoMat = apellidoMat;
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
	 * Obtiene fechanacimiento.
	 *
	 * @return the fechanacimiento
	 */
	public java.util.Date getFechanacimiento() {
		return fechanacimiento;
	}

	/**
	 * Establece fechanacimiento.
	 *
	 * @param fechanacimiento the fechanacimiento to set
	 */
	public void setFechanacimiento(java.util.Date fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
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
	 * Obtiene telefono.
	 *
	 * @return the telefono
	 */
	public java.lang.String getTelefono() {
		return telefono;
	}

	/**
	 * Establece telefono.
	 *
	 * @param telefono the telefono to set
	 */
	public void setTelefono(java.lang.String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Obtiene estatus.
	 *
	 * @return the estatus
	 */
	public java.lang.String getEstatus() {
		return estatus;
	}

	/**
	 * Establece estatus.
	 *
	 * @param estatus the estatus to set
	 */
	public void setEstatus(java.lang.String estatus) {
		this.estatus = estatus;
	}

	/**
	 * Obtiene edad.
	 *
	 * @return the edad
	 */
	public java.lang.Integer getEdad() {
		return edad;
	}

	/**
	 * Establece edad.
	 *
	 * @param edad the edad to set
	 */
	public void setEdad(java.lang.Integer edad) {
		this.edad = edad;
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
	 * Obtiene sucursal.
	 *
	 * @return the sucursal
	 */
	public java.lang.String getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(java.lang.String sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene nombre sucursal.
	 *
	 * @return the nombreSucursal
	 */
	public java.lang.String getNombreSucursal() {
		return nombreSucursal;
	}

	/**
	 * Establece nombre sucursal.
	 *
	 * @param nombreSucursal the nombreSucursal to set
	 */
	public void setNombreSucursal(java.lang.String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	/**
	 * Obtiene codigo grupo.
	 *
	 * @return the codigoGrupo
	 */
	public java.lang.String getCodigoGrupo() {
		return codigoGrupo;
	}

	/**
	 * Establece codigo grupo.
	 *
	 * @param codigoGrupo the codigoGrupo to set
	 */
	public void setCodigoGrupo(java.lang.String codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}

	/**
	 * Obtiene nombre grupo.
	 *
	 * @return the nombreGrupo
	 */
	public java.lang.String getNombreGrupo() {
		return nombreGrupo;
	}

	/**
	 * Establece nombre grupo.
	 *
	 * @param nombreGrupo the nombreGrupo to set
	 */
	public void setNombreGrupo(java.lang.String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	/**
	 * Obtiene ultimo ld.
	 *
	 * @return the ultimoLD
	 */
	public java.lang.String getUltimoLD() {
		return ultimoLD;
	}

	/**
	 * Establece ultimo ld.
	 *
	 * @param ultimoLD the ultimoLD to set
	 */
	public void setUltimoLD(java.lang.String ultimoLD) {
		this.ultimoLD = ultimoLD;
	}

	/**
	 * Obtiene ciclo.
	 *
	 * @return the ciclo
	 */
	public java.lang.String getCiclo() {
		return ciclo;
	}

	/**
	 * Establece ciclo.
	 *
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(java.lang.String ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * Obtiene monto otorgado.
	 *
	 * @return the montoOtorgado
	 */
	public java.lang.Double getMontoOtorgado() {
		return montoOtorgado;
	}

	/**
	 * Establece monto otorgado.
	 *
	 * @param montoOtorgado the montoOtorgado to set
	 */
	public void setMontoOtorgado(java.lang.Double montoOtorgado) {
		this.montoOtorgado = montoOtorgado;
	}

	/**
	 * Obtiene referenciabanamex.
	 *
	 * @return the referenciabanamex
	 */
	public java.lang.String getReferenciabanamex() {
		return referenciabanamex;
	}

	/**
	 * Establece referenciabanamex.
	 *
	 * @param referenciabanamex the referenciabanamex to set
	 */
	public void setReferenciabanamex(java.lang.String referenciabanamex) {
		this.referenciabanamex = referenciabanamex;
	}

	/**
	 * Obtiene referenciabancomer.
	 *
	 * @return the referenciabancomer
	 */
	public java.lang.String getReferenciabancomer() {
		return referenciabancomer;
	}

	/**
	 * Establece referenciabancomer.
	 *
	 * @param referenciabancomer the referenciabancomer to set
	 */
	public void setReferenciabancomer(java.lang.String referenciabancomer) {
		this.referenciabancomer = referenciabancomer;
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
	 * Obtiene clave t24.
	 *
	 * @return the claveT24
	 */
	public java.lang.String getClaveT24() {
		return claveT24;
	}

	/**
	 * Establece clave t24.
	 *
	 * @param claveT24 the claveT24 to set
	 */
	public void setClaveT24(java.lang.String claveT24) {
		this.claveT24 = claveT24;
	}

	/**
	 * Obtiene tipo telefono.
	 *
	 * @return the tipoTelefono
	 */
	public java.lang.String getTipoTelefono() {
		return tipoTelefono;
	}

	/**
	 * Establece tipo telefono.
	 *
	 * @param tipoTelefono the tipoTelefono to set
	 */
	public void setTipoTelefono(java.lang.String tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}

	/**
	 * Obtiene contrato ld.
	 *
	 * @return the contratoLD
	 */
	public java.lang.String getContratoLD() {
		return contratoLD;
	}

	/**
	 * Establece contrato ld.
	 *
	 * @param contratoLD the contratoLD to set
	 */
	public void setContratoLD(java.lang.String contratoLD) {
		this.contratoLD = contratoLD;
	}

	/**
	 * @return the contrato
	 */
	public java.lang.String getContrato() {
		return contrato;
	}

	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(java.lang.String contrato) {
		this.contrato = contrato;
	}

}
