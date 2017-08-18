package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class SolicitudSACGIntegrante.
 *
 * @author out_ltorres
 * @version 1.0
 */
public class SolicitudSACGIntegrante extends ObjetoValor {

	/**
	 * Instancia una nueva solicitud sacg integrante.
	 */
	public SolicitudSACGIntegrante() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8482710699339632124L;

	/** The id credito. */
	private String idCredito;

	/** The codigo cliente. */
	private String codigoCliente;

	/** The codigo t24. */
	private String codigoT24;

	/** The codigo pocg. */
	private String codigoPocg;

	/** The nombre completo. */
	private String nombreCompleto;

	/** The ultimo credito aprobado. */
	private Double ultimoCreditoAprobado;

	/** The nuevo credito solicitado. */
	private Double nuevoCreditoSolicitado;

	/** The ahorro. */
	private Double ahorro;

	/** The proposito prestamo. */
	private String propositoPrestamo;

	/** The experiencia. */
	private String experiencia;

	/** The aprobado. */
	private String aprobado;

	/** The edad. */
	private Integer edad;

	/** The contrato previo. */
	private String contratoPrevio;

	/** The saldo actual. */
	private Double saldoActual;

	/** The tipo localidad. */
	private String tipoLocalidad;

	/** The status. */
	private String status;

	/** The consulta buro. */
	private String consultaBuro;

	/** The seguro. */
	private String seguro;

	/** The ciclo. */
	private Integer ciclo;

	/** The curp. */
	private String curp;

	/** The iguala. */
	private String iguala;

	/** The plazoSeguro. */
	private String plazoSeguro;

	/** The seguro Enfermedad. */
	private String seguroEnfermedad;

	/** Descripcion del proposito del prestamo. */
	private String propositoPrestamoDesc;

	/** Define si tiene beneficiarios para seguro de vida. */
	private boolean existenBeneficiarios;

	/** The pertenece Credito a renovar*/
	private String perteneceCreditoRenovar;

	/** The desertor. */
	private String desertor;

	/** The motivo de saldoGarantia. */
	private double saldoGarantia;

	/** The motivo de saldoGarantia. */
	private double pctParticipacion;

	/** The garantiaAplicada. */
	private double garantiaAplicada;

	/** The diferenciaPago. */
	private double diferenciaPago;

	/** The valida desertor garantia aplicar. */
	private Double validaDesertorGarantiaAplicar;

	/** The nuevos. */
	private int nuevos;

	/** The empresaOrigen. */
	private String empresaOrigen;

	/**
	 * Obtiene id credito.
	 *
	 * @return id credito
	 */
	public String getIdCredito() {
		return idCredito;
	}

	/**
	 * Establece id credito.
	 *
	 * @param idCredito a id credito
	 */
	public void setIdCredito(String idCredito) {
		this.idCredito = idCredito.trim();
	}

	/**
	 * Obtiene codigo cliente.
	 *
	 * @return codigo cliente
	 */
	public String getCodigoCliente() {
		return codigoCliente;
	}

	/**
	 * Establece codigo cliente.
	 *
	 * @param codigoCliente a codigo cliente
	 */
	public void setCodigoCliente(String codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	/**
	 * Obtiene codigo t24.
	 *
	 * @return codigo t24
	 */
	public String getCodigoT24() {
		return codigoT24;
	}

	/**
	 * Establece codigo t24.
	 *
	 * @param codigoT24 a codigo t24
	 */
	public void setCodigoT24(String codigoT24) {
		this.codigoT24 = codigoT24;
	}

	/**
	 * Obtiene codigo pocg.
	 *
	 * @return codigo pocg
	 */
	public String getCodigoPocg() {
		return codigoPocg;
	}

	/**
	 * Establece codigo pocg.
	 *
	 * @param codigoPocg a codigo pocg
	 */
	public void setCodigoPocg(String codigoPocg) {
		this.codigoPocg = codigoPocg.trim();
	}

	/**
	 * Obtiene nombre completo.
	 *
	 * @return nombre completo
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	/**
	 * Establece nombre completo.
	 *
	 * @param nombreCompleto a nombre completo
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	/**
	 * Obtiene ultimo credito aprobado.
	 *
	 * @return ultimo credito aprobado
	 */
	public Double getUltimoCreditoAprobado() {
		return ultimoCreditoAprobado;
	}

	/**
	 * Establece ultimo credito aprobado.
	 *
	 * @param ultimoCreditoAprobado a ultimo credito aprobado
	 */
	public void setUltimoCreditoAprobado(Double ultimoCreditoAprobado) {
		this.ultimoCreditoAprobado = ultimoCreditoAprobado;
	}

	/**
	 * Obtiene nuevo credito solicitado.
	 *
	 * @return nuevo credito solicitado
	 */
	public Double getNuevoCreditoSolicitado() {
		return nuevoCreditoSolicitado;
	}

	/**
	 * Establece nuevo credito solicitado.
	 *
	 * @param nuevoCreditoSolicitado a nuevo credito solicitado
	 */
	public void setNuevoCreditoSolicitado(Double nuevoCreditoSolicitado) {
		this.nuevoCreditoSolicitado = nuevoCreditoSolicitado;
	}

	/**
	 * Obtiene ahorro.
	 *
	 * @return ahorro
	 */
	public Double getAhorro() {
		return ahorro;
	}

	/**
	 * Establece ahorro.
	 *
	 * @param ahorro a ahorro
	 */
	public void setAhorro(Double ahorro) {
		this.ahorro = ahorro;
	}

	/**
	 * Obtiene proposito prestamo.
	 *
	 * @return proposito prestamo
	 */
	public String getPropositoPrestamo() {
		return propositoPrestamo;
	}

	/**
	 * Establece proposito prestamo.
	 *
	 * @param propositoPrestamo a proposito prestamo
	 */
	public void setPropositoPrestamo(String propositoPrestamo) {
		this.propositoPrestamo = propositoPrestamo;
	}

	/**
	 * Obtiene experiencia.
	 *
	 * @return experiencia
	 */
	public String getExperiencia() {
		return experiencia;
	}

	/**
	 * Establece experiencia.
	 *
	 * @param experiencia a experiencia
	 */
	public void setExperiencia(String experiencia) {
		this.experiencia = experiencia.trim();
	}

	/**
	 * Obtiene aprobado.
	 *
	 * @return aprobado
	 */
	public String getAprobado() {
		return aprobado;
	}

	/**
	 * Establece aprobado.
	 *
	 * @param aprobado a aprobado
	 */
	public void setAprobado(String aprobado) {
		this.aprobado = aprobado;
	}

	/**
	 * Obtiene edad.
	 *
	 * @return edad
	 */
	public Integer getEdad() {
		return edad;
	}

	/**
	 * Establece edad.
	 *
	 * @param edad a edad
	 */
	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	/**
	 * Obtiene contrato previo.
	 *
	 * @return contrato previo
	 */
	public String getContratoPrevio() {
		return contratoPrevio;
	}

	/**
	 * Establece contrato previo.
	 *
	 * @param contratoPrevio a contrato previo
	 */
	public void setContratoPrevio(String contratoPrevio) {
		this.contratoPrevio = contratoPrevio.trim();
	}

	/**
	 * Obtiene saldo actual.
	 *
	 * @return saldo actual
	 */
	public Double getSaldoActual() {
		return saldoActual;
	}

	/**
	 * Establece saldo actual.
	 *
	 * @param saldoActual a saldo actual
	 */
	public void setSaldoActual(Double saldoActual) {
		this.saldoActual = saldoActual;
	}

	/**
	 * Obtiene tipo localidad.
	 *
	 * @return tipo localidad
	 */
	public String getTipoLocalidad() {
		return tipoLocalidad;
	}

	/**
	 * Establece tipo localidad.
	 *
	 * @param tipoLocalidad a tipo localidad
	 */
	public void setTipoLocalidad(String tipoLocalidad) {
		this.tipoLocalidad = tipoLocalidad.trim();
	}

	/**
	 * Obtiene status.
	 *
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Establece status.
	 *
	 * @param status a status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Obtiene consulta buro.
	 *
	 * @return consulta buro
	 */
	public String getConsultaBuro() {
		return consultaBuro;
	}

	/**
	 * Establece consulta buro.
	 *
	 * @param consultaBuro a consulta buro
	 */
	public void setConsultaBuro(String consultaBuro) {
		this.consultaBuro = consultaBuro;
	}

	/**
	 * Establece seguro.
	 *
	 * @param seguro a seguro
	 */
	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}

	/**
	 * Obtiene seguro.
	 *
	 * @return seguro
	 */
	public String getSeguro() {
		return seguro;
	}

	/**
	 * @return the ciclo
	 */
	public Integer getCiclo() {
		return ciclo;
	}

	/**
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
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
	 * @return the iguala
	 */
	public String getIguala() {
		return iguala;
	}

	/**
	 * @param iguala the iguala to set
	 */
	public void setIguala(String iguala) {
		this.iguala = iguala;
	}

	/**
	 * @return the plazoSeguro
	 */
	public String getPlazoSeguro() {
		return plazoSeguro;
	}

	/**
	 * @param plazoSeguro the plazoSeguro to set
	 */
	public void setPlazoSeguro(String plazoSeguro) {
		this.plazoSeguro = plazoSeguro;
	}

	/**
	 * @return the seguroEnfermedad
	 */
	public String getSeguroEnfermedad() {
		return seguroEnfermedad;
	}

	/**
	 * @param seguroEnfermedad the seguroEnfermedad to set
	 */
	public void setSeguroEnfermedad(String seguroEnfermedad) {
		this.seguroEnfermedad = seguroEnfermedad;
	}

	/**
	 * @return the propositoPrestamoDesc
	 */
	public String getPropositoPrestamoDesc() {
		return propositoPrestamoDesc;
	}

	/**
	 * @param propositoPrestamoDesc the propositoPrestamoDesc to set
	 */
	public void setPropositoPrestamoDesc(String propositoPrestamoDesc) {
		this.propositoPrestamoDesc = propositoPrestamoDesc;
	}

	/**
	 * @return the existenBeneficiarios
	 */
	public boolean isExistenBeneficiarios() {
		return existenBeneficiarios;
	}

	/**
	 * @param existenBeneficiarios the existenBeneficiarios to set
	 */
	public void setExistenBeneficiarios(boolean existenBeneficiarios) {
		this.existenBeneficiarios = existenBeneficiarios;
	}

	/**
	 * @return the perteneceCreditoRenovar
	 */
	public String getPerteneceCreditoRenovar() {
		return perteneceCreditoRenovar;
	}

	/**
	 * @param perteneceCreditoRenovar the perteneceCreditoRenovar to set
	 */
	public void setPerteneceCreditoRenovar(String perteneceCreditoRenovar) {
		this.perteneceCreditoRenovar = perteneceCreditoRenovar;
	}

	/**
	 * @return the desertor
	 */
	public String getDesertor() {
		return desertor;
	}

	/**
	 * @param desertor the desertor to set
	 */
	public void setDesertor(String desertor) {
		this.desertor = desertor;
	}

	/**
	 * @return the saldoGarantia
	 */
	public double getSaldoGarantia() {
		return saldoGarantia;
	}

	/**
	 * @param saldoGarantia the saldoGarantia to set
	 */
	public void setSaldoGarantia(double saldoGarantia) {
		this.saldoGarantia = saldoGarantia;
	}

	/**
	 * @return the pctParticipacion
	 */
	public double getPctParticipacion() {
		return pctParticipacion;
	}

	/**
	 * @param pctParticipacion the pctParticipacion to set
	 */
	public void setPctParticipacion(double pctParticipacion) {
		this.pctParticipacion = pctParticipacion;
	}

	/**
	 * @return the garantiaAplicada
	 */
	public double getGarantiaAplicada() {
		return garantiaAplicada;
	}

	/**
	 * @param garantiaAplicada the garantiaAplicada to set
	 */
	public void setGarantiaAplicada(double garantiaAplicada) {
		this.garantiaAplicada = garantiaAplicada;
	}

	/**
	 * @return the diferenciaPago
	 */
	public double getDiferenciaPago() {
		return diferenciaPago;
	}

	/**
	 * @param diferenciaPago the diferenciaPago to set
	 */
	public void setDiferenciaPago(double diferenciaPago) {
		this.diferenciaPago = diferenciaPago;
	}

	/**
	 * @return the validaDesertorGarantiaAplicar
	 */
	public Double getValidaDesertorGarantiaAplicar() {
		return validaDesertorGarantiaAplicar;
	}

	/**
	 * @param validaDesertorGarantiaAplicar the validaDesertorGarantiaAplicar to set
	 */
	public void setValidaDesertorGarantiaAplicar(
			Double validaDesertorGarantiaAplicar) {
		this.validaDesertorGarantiaAplicar = validaDesertorGarantiaAplicar;
	}

	/**
	 * @return the nuevos
	 */
	public int getNuevos() {
		return nuevos;
	}

	/**
	 * @param nuevos the nuevos to set
	 */
	public void setNuevos(int nuevos) {
		this.nuevos = nuevos;
	}

	/**
	 * @return the empresaOrigen
	 */
	public String getEmpresaOrigen() {
		return empresaOrigen;
	}

	/**
	 * @param empresaOrigen the empresaOrigen to set
	 */
	public void setEmpresaOrigen(String empresaOrigen) {
		this.empresaOrigen = empresaOrigen;
	}


}
