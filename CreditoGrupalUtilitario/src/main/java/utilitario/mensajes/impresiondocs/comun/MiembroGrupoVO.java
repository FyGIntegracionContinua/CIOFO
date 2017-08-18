package utilitario.mensajes.impresiondocs.comun;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class MiembroGrupoVO.
 *
 * @author mi.mejorada
 */
/**
 * @author mi.mejorada
 *
 */
public class MiembroGrupoVO extends ObjetoValor {

	/**
	 * MiembroGrupoVO.
	 */
	public MiembroGrupoVO() {

	}

	/** serialVersionUID long. */
	private static final long serialVersionUID = -5058724951846560040L;

	/** ejecutivo String. */
	private String ejecutivo; 	//agregado Angel

	/**  Id del grupo. */
	private String grupo;

	/** N�mero de miembros del grupo? Consecutivo de 1 a N integrantes. */
	private String montoOtorgado;

	/** montoLetra String. */
	private String montoLetra;

	/** nummiembro String. */
	private String nummiembro;

	/** Nombre del integrante? SI. */
	private String cliente;

	/** persona String. */
	private String persona;

	/** clienteId String. */
	private String clienteId;

	/** Domicilio cliente (calle). */
	private String callecte;

	/**  Domicilio cliente (colonia). */
	private String coloniacte;

	/** Domicilio cliente (ciudad). */
	private String ciudadcte;

	/** Domicilio cliente (estado). */
	private String estadocte;

	/**  Domicilio cliente (cp). */
	private String cpcte;

	/** ?? Tipo de Identificacion oficial. */
	private String tipoid;

	/** ?? Numero Identificacion oficial. */
	private String idnum;

	/** Estado civil del cliente. */
	private String edocivil;
	/**
	 * Ocupaci�n del cliente.. ??? SI
	 */
	private String ocupacion;

	/** ?? Monto Pedido por el cliente. */
	private String capitalcte;

	/** ?? Parcialidad Cliente. */
	private String imptecte;

	/** N�mero de cheque asociado al cliente. */
	private String numcheque;

	/** ?? Para cr�ditos Renovaciones Financiadas Monto para liquidar contrato anterior. */
	private String montofin;
	/**
	 * ?? Para cr�ditos Renovaciones Financiadas. Monto entregado en cheque
	 */
	private String montoreal;

	/** ?? Por apellidos. */
	private String nombrec;

	/** tipoTelefono String. */
	private String tipoTelefono;

	/** RFC del cliente. */
	private String rfc;
	/**
	 * Tel�fono del cliente.. Del domicilio? SI
	 */
	private String tel;

	/** Fecha nacimiento del cliente. */
	private String fnacimiento;
	/**
	 * Sexo. F y M? SI
	 */
	private String sexo;

	/** Id del cliente? SI. */
	private String codigocte;

	/**
	 * The no pagos.
	 */
	private String noPagos;

	/** montoFinanciado String. */
	private String montoFinanciado;

	/**
	 * montofinletra java.lang.String
	 */
	private java.lang.String montofinletra; 	//El monto financiado en letra

	/**
	 * fecha java.lang.String
	 */
	private java.lang.String fecha;				//Fecha

	/**
	 * numvale java.lang.String
	 */
	private java.lang.String numvale;			//Este valor siempre va vacio

	/**
	 * nocliente java.lang.String
	 */
	private java.lang.String nocliente;			//Este valor siempre va vacio

	/** montoGarantia String. */
	private String montoGarantia;

	/** montoGarantiaLetras String. */
	private String montoGarantiaLetras;

	/** porcentajeParticipacion String. */
	private String porcentajeParticipacion;

	/** The vale credito. */
	private String valeCredito;

	/** The importe vale credito. */
	private String importeValeCredito;

	/** The importe vale credito letra. */
	private String importeValeCreditoLetra;

	/** The tiene seguro vida. */
	private String tieneSeguroVida;

	/** The tiene seguro enfermedad. */
	private String tieneSeguroEnfermedad;

	/** The monto seguro vida. */
	private String montoSeguroVida;

	/** The monto seguro enfermedad. */
	private String montoSeguroEnfermedad;

	/** The plazo seguro vida. */
	private String plazoSeguroVida;

	/** The plazo seguro enfermedad. */
	private String plazoSeguroEnfermedad;

	/** The reca. */
	private String reca;

	/** monto cheque */
	private String montoCheque;

	// Get - Set  -------------------------------------------------------
	/**
	 * Gets the cliente id.
	 *
	 * @return the clienteId
	 */
	public String getClienteId() {
		return clienteId;
	}

	/**
	 * Sets the cliente id.
	 *
	 * @param clienteId the clienteId to set
	 */
	public void setClienteId(String clienteId) {
		this.clienteId = clienteId;
	}

	/**
	 * Gets the persona.
	 *
	 * @return the persona
	 */
	public String getPersona() {
		return persona == null ? "" : persona;
	}

	/**
	 * Sets the persona.
	 *
	 * @param persona the persona to set
	 */
	public void setPersona(String persona) {
		this.persona = persona;
	}

	/**
	 * Gets the monto financiado.
	 *
	 * @return the montoFinanciado
	 */
	public String getMontoFinanciado() {
		return montoFinanciado;
	}

	/**
	 * Sets the monto financiado.
	 *
	 * @param montoFinanciado the montoFinanciado to set
	 */
	public void setMontoFinanciado(String montoFinanciado) {
		this.montoFinanciado = montoFinanciado;
	}

	/**
	 * Gets the no pagos.
	 *
	 * @return the noPagos
	 */
	public String getNoPagos() {
		return noPagos;
	}

	/**
	 * Sets the no pagos.
	 *
	 * @param noPagos the noPagos to set
	 */
	public void setNoPagos(String noPagos) {
		this.noPagos = noPagos;
	}

	/**
	 * Gets the grupo.
	 *
	 * @return .
	 */
	public String getGrupo() {
		return grupo;
	}

	/**
	 * Sets the grupo.
	 *
	 * @param grupo the grupo to set
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	/**
	 * Gets the nummiembro.
	 *
	 * @return the nummiembro
	 */
	public String getNummiembro() {
		return nummiembro;
	}

	/**
	 * Sets the nummiembro.
	 *
	 * @param nummiembro the nummiembro to set
	 */
	public void setNummiembro(String nummiembro) {
		this.nummiembro = nummiembro;
	}

	/**
	 * Gets the cliente.
	 *
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * Sets the cliente.
	 *
	 * @param cliente the cliente to set
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	/**
	 * Gets the callecte.
	 *
	 * @return the callecte
	 */
	public String getCallecte() {
		return callecte;
	}

	/**
	 * Sets the callecte.
	 *
	 * @param callecte the callecte to set
	 */
	public void setCallecte(String callecte) {
		this.callecte = callecte;
	}

	/**
	 * Gets the coloniacte.
	 *
	 * @return the coloniacte
	 */
	public String getColoniacte() {
		return coloniacte;
	}

	/**
	 * Sets the coloniacte.
	 *
	 * @param coloniacte the coloniacte to set
	 */
	public void setColoniacte(String coloniacte) {
		this.coloniacte = coloniacte;
	}

	/**
	 * Gets the ciudadcte.
	 *
	 * @return the ciudadcte
	 */
	public String getCiudadcte() {
		return ciudadcte;
	}

	/**
	 * Sets the ciudadcte.
	 *
	 * @param ciudadcte the ciudadcte to set
	 */
	public void setCiudadcte(String ciudadcte) {
		this.ciudadcte = ciudadcte;
	}

	/**
	 * Gets the estadocte.
	 *
	 * @return the estadocte
	 */
	public String getEstadocte() {
		return estadocte;
	}

	/**
	 * Sets the estadocte.
	 *
	 * @param estadocte the estadocte to set
	 */
	public void setEstadocte(String estadocte) {
		this.estadocte = estadocte;
	}

	/**
	 * Gets the cpcte.
	 *
	 * @return the cpcte
	 */
	public String getCpcte() {
		return cpcte;
	}

	/**
	 * Sets the cpcte.
	 *
	 * @param cpcte the cpcte to set
	 */
	public void setCpcte(String cpcte) {
		this.cpcte = cpcte;
	}

	/**
	 * Gets the tipoid.
	 *
	 * @return the tipoid
	 */
	public String getTipoid() {
		return tipoid;
	}

	/**
	 * Sets the tipoid.
	 *
	 * @param tipoid the tipoid to set
	 */
	public void setTipoid(String tipoid) {
		this.tipoid = tipoid;
	}

	/**
	 * Gets the idnum.
	 *
	 * @return the idnum
	 */
	public String getIdnum() {
		return idnum;
	}

	/**
	 * Sets the idnum.
	 *
	 * @param idnum the idnum to set
	 */
	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}

	/**
	 * Gets the edocivil.
	 *
	 * @return the edocivil
	 */
	public String getEdocivil() {
		return edocivil;
	}

	/**
	 * Sets the edocivil.
	 *
	 * @param edocivil the edocivil to set
	 */
	public void setEdocivil(String edocivil) {
		this.edocivil = edocivil;
	}

	/**
	 * Gets the ocupacion.
	 *
	 * @return the ocupacion
	 */
	public String getOcupacion() {
		return ocupacion;
	}

	/**
	 * Sets the ocupacion.
	 *
	 * @param ocupacion the ocupacion to set
	 */
	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	/**
	 * Gets the capitalcte.
	 *
	 * @return the capitalcte
	 */
	public String getCapitalcte() {
		return capitalcte;
	}

	/**
	 * Sets the capitalcte.
	 *
	 * @param capitalcte the capitalcte to set
	 */
	public void setCapitalcte(String capitalcte) {
		this.capitalcte = capitalcte;
	}

	/**
	 * Gets the imptecte.
	 *
	 * @return the imptecte
	 */
	public String getImptecte() {
		return imptecte;
	}

	/**
	 * Sets the imptecte.
	 *
	 * @param imptecte the imptecte to set
	 */
	public void setImptecte(String imptecte) {
		this.imptecte = imptecte;
	}

	/**
	 * Gets the numcheque.
	 *
	 * @return the numcheque
	 */
	public String getNumcheque() {
		return numcheque;
	}

	/**
	 * Sets the numcheque.
	 *
	 * @param numcheque the numcheque to set
	 */
	public void setNumcheque(String numcheque) {
		this.numcheque = numcheque;
	}

	/**
	 * Gets the montofin.
	 *
	 * @return the montofin
	 */
	public String getMontofin() {
		return montofin;
	}

	/**
	 * Sets the montofin.
	 *
	 * @param montofin the montofin to set
	 */
	public void setMontofin(String montofin) {
		this.montofin = montofin;
	}

	/**
	 * Gets the montoreal.
	 *
	 * @return the montoreal
	 */
	public String getMontoreal() {
		return montoreal;
	}

	/**
	 * Sets the montoreal.
	 *
	 * @param montoreal the montoreal to set
	 */
	public void setMontoreal(String montoreal) {
		this.montoreal = montoreal;
	}

	/**
	 * Gets the nombrec.
	 *
	 * @return the nombrec
	 */
	public String getNombrec() {
		return nombrec;
	}

	/**
	 * Sets the nombrec.
	 *
	 * @param nombrec the nombrec to set
	 */
	public void setNombrec(String nombrec) {
		this.nombrec = nombrec;
	}

	/**
	 * Gets the rfc.
	 *
	 * @return the rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * Sets the rfc.
	 *
	 * @param rfc the rfc to set
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	/**
	 * Gets the tel.
	 *
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * Sets the tel.
	 *
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * Gets the fnacimiento.
	 *
	 * @return the fnacimiento
	 */
	public String getFnacimiento() {
		return fnacimiento;
	}

	/**
	 * Sets the fnacimiento.
	 *
	 * @param fnacimiento the fnacimiento to set
	 */
	public void setFnacimiento(String fnacimiento) {
		this.fnacimiento = fnacimiento;
	}

	/**
	 * Gets the sexo.
	 *
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}

	/**
	 * Gets the rol.
	 *
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * Sets the rol.
	 *
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * Sets the sexo.
	 *
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	/**
	 * Gets the codigocte.
	 *
	 * @return the codigocte
	 */
	public String getCodigocte() {
		return codigocte;
	}

	/**
	 * Sets the codigocte.
	 *
	 * @param codigocte the codigocte to set
	 */
	public void setCodigocte(String codigocte) {
		this.codigocte = codigocte;
	}

	/** Nombre del integrante? SI. */
	private String rol;

	/**
	 * Gets the ejecutivo.
	 *
	 * @return the ejecutivo
	 */
	public String getEjecutivo() {
		return ejecutivo;
	}

	/**
	 * Sets the ejecutivo.
	 *
	 * @param ejecutivo the ejecutivo to set
	 */
	public void setEjecutivo(String ejecutivo) {
		this.ejecutivo = ejecutivo;
	}

	/**
	 * Gets the monto otorgado.
	 *
	 * @return the montoOtorgado
	 */
	public String getMontoOtorgado() {
		return montoOtorgado;
	}

	/**
	 * Sets the monto otorgado.
	 *
	 * @param montoOtorgado the montoOtorgado to set
	 */
	public void setMontoOtorgado(String montoOtorgado) {
		this.montoOtorgado = montoOtorgado;
	}

	/**
	 * Gets the monto letra.
	 *
	 * @return .
	 */
	public String getMontoLetra() {
		return montoLetra;
	}

	/**
	 * Sets the monto letra.
	 *
	 * @param montoLetra .
	 */
	public void setMontoLetra(String montoLetra) {
		this.montoLetra = montoLetra;
	}

	/**
	 * Gets the tipo telefono.
	 *
	 * @return the tipoTelefono
	 */
	public String getTipoTelefono() {
		return tipoTelefono;
	}

	/**
	 * Sets the tipo telefono.
	 *
	 * @param tipoTelefono the tipoTelefono to set
	 */
	public void setTipoTelefono(String tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}

	/**
	 * Gets the montofinletra.
	 *
	 * @return the montofinletra
	 */
	public java.lang.String getMontofinletra() {
		return montofinletra;
	}

	/**
	 * Sets the montofinletra.
	 *
	 * @param montofinletra the montofinletra to set
	 */
	public void setMontofinletra(java.lang.String montofinletra) {
		this.montofinletra = montofinletra;
	}

	/**
	 * Gets the fecha.
	 *
	 * @return the fecha
	 */
	public java.lang.String getFecha() {
		return fecha;
	}

	/**
	 * Sets the fecha.
	 *
	 * @param fecha the fecha to set
	 */
	public void setFecha(java.lang.String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Gets the numvale.
	 *
	 * @return the numvale
	 */
	public java.lang.String getNumvale() {
		return numvale;
	}

	/**
	 * Sets the numvale.
	 *
	 * @param numvale the numvale to set
	 */
	public void setNumvale(java.lang.String numvale) {
		this.numvale = numvale;
	}

	/**
	 * Gets the nocliente.
	 *
	 * @return the nocliente
	 */
	public java.lang.String getNocliente() {
		return nocliente;
	}

	/**
	 * Sets the nocliente.
	 *
	 * @param nocliente the nocliente to set
	 */
	public void setNocliente(java.lang.String nocliente) {
		this.nocliente = nocliente;
	}

	/**
	 * Sets the monto garantia.
	 *
	 * @param montoGarantia .
	 */
	public void setMontoGarantia(String montoGarantia) {
		this.montoGarantia = montoGarantia;
	}

	/**
	 * Gets the monto garantia.
	 *
	 * @return .
	 */
	public String getMontoGarantia() {
		return montoGarantia;
	}

	/**
	 * Sets the monto garantia letras.
	 *
	 * @param montoGarantiaLetras .
	 */
	public void setMontoGarantiaLetras(String montoGarantiaLetras) {
		this.montoGarantiaLetras = montoGarantiaLetras;
	}

	/**
	 * Gets the monto garantia letras.
	 *
	 * @return .
	 */
	public String getMontoGarantiaLetras() {
		return montoGarantiaLetras;
	}

	/**
	 * Gets the porcentaje participacion.
	 *
	 * @return .
	 */
	public String getPorcentajeParticipacion() {
		return porcentajeParticipacion;
	}

	/**
	 * Sets the porcentaje participacion.
	 *
	 * @param porcentajeParticipacion .
	 */
	public void setPorcentajeParticipacion(String porcentajeParticipacion) {
		this.porcentajeParticipacion = porcentajeParticipacion;
	}

	/**
	 * Gets the vale credito.
	 *
	 * @return the valeCredito
	 */
	public String getValeCredito() {
		return valeCredito;
	}

	/**
	 * Sets the vale credito.
	 *
	 * @param valeCredito the valeCredito to set
	 */
	public void setValeCredito(String valeCredito) {
		this.valeCredito = valeCredito;
	}

	/**
	 * Gets the importe vale credito.
	 *
	 * @return the importeValeCredito
	 */
	public String getImporteValeCredito() {
		return importeValeCredito;
	}

	/**
	 * Sets the importe vale credito.
	 *
	 * @param importeValeCredito the importeValeCredito to set
	 */
	public void setImporteValeCredito(String importeValeCredito) {
		this.importeValeCredito = importeValeCredito;
	}

	/**
	 * Gets the tiene seguro vida.
	 *
	 * @return the tieneSeguroVida
	 */
	public String getTieneSeguroVida() {
		return tieneSeguroVida;
	}

	/**
	 * Sets the tiene seguro vida.
	 *
	 * @param tieneSeguroVida the tieneSeguroVida to set
	 */
	public void setTieneSeguroVida(String tieneSeguroVida) {
		this.tieneSeguroVida = tieneSeguroVida;
	}

	/**
	 * Gets the tiene seguro enfermedad.
	 *
	 * @return the tieneSeguroEnfermedad
	 */
	public String getTieneSeguroEnfermedad() {
		return tieneSeguroEnfermedad;
	}

	/**
	 * Sets the tiene seguro enfermedad.
	 *
	 * @param tieneSeguroEnfermedad the tieneSeguroEnfermedad to set
	 */
	public void setTieneSeguroEnfermedad(String tieneSeguroEnfermedad) {
		this.tieneSeguroEnfermedad = tieneSeguroEnfermedad;
	}

	/**
	 * Gets the monto seguro vida.
	 *
	 * @return the montoSeguroVida
	 */
	public String getMontoSeguroVida() {
		return montoSeguroVida;
	}

	/**
	 * Sets the monto seguro vida.
	 *
	 * @param montoSeguroVida the montoSeguroVida to set
	 */
	public void setMontoSeguroVida(String montoSeguroVida) {
		this.montoSeguroVida = montoSeguroVida;
	}

	/**
	 * Gets the monto seguro enfermedad.
	 *
	 * @return the montoSeguroEnfermedad
	 */
	public String getMontoSeguroEnfermedad() {
		return montoSeguroEnfermedad;
	}

	/**
	 * Sets the monto seguro enfermedad.
	 *
	 * @param montoSeguroEnfermedad the montoSeguroEnfermedad to set
	 */
	public void setMontoSeguroEnfermedad(String montoSeguroEnfermedad) {
		this.montoSeguroEnfermedad = montoSeguroEnfermedad;
	}

	/**
	 * Gets the plazo seguro vida.
	 *
	 * @return the plazoSeguroVida
	 */
	public String getPlazoSeguroVida() {
		return plazoSeguroVida;
	}

	/**
	 * Sets the plazo seguro vida.
	 *
	 * @param plazoSeguroVida the plazoSeguroVida to set
	 */
	public void setPlazoSeguroVida(String plazoSeguroVida) {
		this.plazoSeguroVida = plazoSeguroVida;
	}

	/**
	 * Gets the plazo seguro enfermedad.
	 *
	 * @return the plazoSeguroEnfermedad
	 */
	public String getPlazoSeguroEnfermedad() {
		return plazoSeguroEnfermedad;
	}

	/**
	 * Sets the plazo seguro enfermedad.
	 *
	 * @param plazoSeguroEnfermedad the plazoSeguroEnfermedad to set
	 */
	public void setPlazoSeguroEnfermedad(String plazoSeguroEnfermedad) {
		this.plazoSeguroEnfermedad = plazoSeguroEnfermedad;
	}

	/**
	 * @return the importeValeCreditoLetra
	 */
	public String getImporteValeCreditoLetra() {
		return importeValeCreditoLetra;
	}

	/**
	 * @param importeValeCreditoLetra the importeValeCreditoLetra to set
	 */
	public void setImporteValeCreditoLetra(String importeValeCreditoLetra) {
		this.importeValeCreditoLetra = importeValeCreditoLetra;
	}

	/**
	 * @return the reca
	 */
	public String getReca() {
		return reca;
	}

	/**
	 * @param reca the reca to set
	 */
	public void setReca(String reca) {
		this.reca = reca;
	}

	/**
	 * @return the montoCheque
	 */
	public String getMontoCheque() {
		return montoCheque;
	}

	/**
	 * @param montoCheque the montoCheque to set
	 */
	public void setMontoCheque(String montoCheque) {
		this.montoCheque = montoCheque;
	}
}
