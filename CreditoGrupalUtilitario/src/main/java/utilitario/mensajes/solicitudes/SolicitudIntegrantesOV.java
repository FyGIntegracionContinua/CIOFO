package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class SolicitudIntegrantesOV.
 *
 * @author rguadarramac
 * @version 1.0
 */
public class SolicitudIntegrantesOV extends ObjetoValor {

	/**
	 * Instancia una nueva solicitud integrantes ov.
	 */
	public SolicitudIntegrantesOV() {
	}
	/** Se genero serial. */
	private static final long serialVersionUID = 31905069059425868L;

	/** The solicitud. */
	private String solicitud;

	/** The cliente. */
	private String cliente;

	/** The monto ahorro. */
	private Double montoAhorro;

	/** The efectivo solicitado. */
	private Double efectivoSolicitado;

	/** The monto solicitado. */
	private Double montoSolicitado;

	/** The monto financiado cont ant. */
	private Double montoFinanciadoContAnt;

	/** The monto pago. */
	private Double montoPago;

	/** The efectivo otorgado. */
	private Double efectivoOtorgado;

	/** The monto otorgado. */
	private Double montoOtorgado;

	/** The ingresos. */
	private Double ingresos;

	/** The otros ingresos. */
	private Double otrosIngresos;

	/** The egresos. */
	private Double egresos;

	/** The medio contacto. */
	private String medioContacto;

	/** The findep score. */
	private Integer findepScore;

	/** The tabla score. */
	private Integer tablaScore;

	/** The bc score. */
	private Integer bcScore;

	/** The codigo destino credito. */
	private String codigoDestinoCredito;

	/** The autorizo consulta imss. */
	private String autorizoConsultaImss;

	/** The clave imss. */
	private String claveImss;

	/** The clave reso infonavit. */
	private String claveResoInfonavit;

	/** The clave reso imss. */
	private String claveResoImss;

	/** The cheque para. */
	private String chequePara;

	/** The monto seguro. */
	private Double montoSeguro;

	/** The tipo disposicion. */
	private String tipoDisposicion;

	/** The cargo mesa directiva. */
	private String cargoMesaDirectiva;

	/** The contrato anterior. */
	private String contratoAnterior;

	/** The monto contrato anterior. */
	private Double montoContratoAnterior;

	/** The hit bc. */
	private String hitBc;

	/** The numero cuentas bc. */
	private Integer numeroCuentasBc;

	/** The clasificacion fira. */
	private String clasificacionFira;

	/** The pct participacion. */
	private Double pctParticipacion;

	/** The etapa anterior. */
	private String etapaAnterior;

	/** The motivo status. */
	private String motivoStatus;

	/** The status. */
	private String status;

	/** The etapa. */
	private String etapa;

	/** The numero integrante. */
	private Integer numeroIntegrante;

	/** The referencia. */
	private String referencia;

	/** The aprobado. */
	private String aprobado;

	/** The saldo actual. */
	private Double saldoActual;

	/** The seguro. */
	private String seguro;

	/** The ciclo. */
	private Integer ciclo;

	/** The iguala. */
	private String iguala;

	/** The plazoSeguro. */
	private String plazoSeguro;

	/** The seguro Enfermedad. */
	private String seguroEnfermedad;

	/** The pertenece credito renovar. */
	private String perteneceCreditoRenovar;

	/** The desertor. */
	private String desertor;

	/** The garantiaAplicada. */
	private double garantiaAplicada;

	/** The diferenciaPago. */
	private double diferenciaPago;

	/** The empresaOrigen. */
	private String empresaOrigen;

	/**
	 * Obtiene solicitud.
	 *
	 * @return solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}

	/**
	 * Establece solicitud.
	 *
	 * @param solicitud a solicitud
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud.trim();
	}

	/**
	 * Obtiene cliente.
	 *
	 * @return cliente
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * Establece cliente.
	 *
	 * @param cliente a cliente
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente.trim();
	}

	/**
	 * Obtiene monto ahorro.
	 *
	 * @return monto ahorro
	 */
	public Double getMontoAhorro() {
		return montoAhorro;
	}

	/**
	 * Establece monto ahorro.
	 *
	 * @param montoAhorro a monto ahorro
	 */
	public void setMontoAhorro(Double montoAhorro) {
		this.montoAhorro = montoAhorro;
	}

	/**
	 * Obtiene efectivo solicitado.
	 *
	 * @return efectivo solicitado
	 */
	public Double getEfectivoSolicitado() {
		return efectivoSolicitado;
	}

	/**
	 * Establece efectivo solicitado.
	 *
	 * @param efectivoSolicitado a efectivo solicitado
	 */
	public void setEfectivoSolicitado(Double efectivoSolicitado) {
		this.efectivoSolicitado = efectivoSolicitado;
	}

	/**
	 * Obtiene monto solicitado.
	 *
	 * @return monto solicitado
	 */
	public Double getMontoSolicitado() {
		return montoSolicitado;
	}

	/**
	 * Establece monto solicitado.
	 *
	 * @param montoSolicitado a monto solicitado
	 */
	public void setMontoSolicitado(Double montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}

	/**
	 * Obtiene monto financiado cont ant.
	 *
	 * @return monto financiado cont ant
	 */
	public Double getMontoFinanciadoContAnt() {
		return montoFinanciadoContAnt;
	}

	/**
	 * Establece monto financiado cont ant.
	 *
	 * @param montoFinanciadoContAnt a monto financiado cont ant
	 */
	public void setMontoFinanciadoContAnt(Double montoFinanciadoContAnt) {
		this.montoFinanciadoContAnt = montoFinanciadoContAnt;
	}

	/**
	 * Obtiene monto pago.
	 *
	 * @return monto pago
	 */
	public Double getMontoPago() {
		return montoPago;
	}

	/**
	 * Establece monto pago.
	 *
	 * @param montoPago a monto pago
	 */
	public void setMontoPago(Double montoPago) {
		this.montoPago = montoPago;
	}

	/**
	 * Obtiene efectivo otorgado.
	 *
	 * @return efectivo otorgado
	 */
	public Double getEfectivoOtorgado() {
		return efectivoOtorgado;
	}

	/**
	 * Establece efectivo otorgado.
	 *
	 * @param efectivoOtorgado a efectivo otorgado
	 */
	public void setEfectivoOtorgado(Double efectivoOtorgado) {
		this.efectivoOtorgado = efectivoOtorgado;
	}

	/**
	 * Obtiene monto otorgado.
	 *
	 * @return monto otorgado
	 */
	public Double getMontoOtorgado() {
		return montoOtorgado;
	}

	/**
	 * Establece monto otorgado.
	 *
	 * @param montoOtorgado a monto otorgado
	 */
	public void setMontoOtorgado(Double montoOtorgado) {
		this.montoOtorgado = montoOtorgado;
	}

	/**
	 * Obtiene ingresos.
	 *
	 * @return ingresos
	 */
	public Double getIngresos() {
		return ingresos;
	}

	/**
	 * Establece ingresos.
	 *
	 * @param ingresos a ingresos
	 */
	public void setIngresos(Double ingresos) {
		this.ingresos = ingresos;
	}

	/**
	 * Obtiene otros ingresos.
	 *
	 * @return otros ingresos
	 */
	public Double getOtrosIngresos() {
		return otrosIngresos;
	}

	/**
	 * Establece otros ingresos.
	 *
	 * @param otrosIngresos a otros ingresos
	 */
	public void setOtrosIngresos(Double otrosIngresos) {
		this.otrosIngresos = otrosIngresos;
	}

	/**
	 * Obtiene egresos.
	 *
	 * @return egresos
	 */
	public Double getEgresos() {
		return egresos;
	}

	/**
	 * Establece egresos.
	 *
	 * @param egresos a egresos
	 */
	public void setEgresos(Double egresos) {
		this.egresos = egresos;
	}

	/**
	 * Obtiene medio contacto.
	 *
	 * @return medio contacto
	 */
	public String getMedioContacto() {
		return medioContacto;
	}

	/**
	 * Establece medio contacto.
	 *
	 * @param medioContacto a medio contacto
	 */
	public void setMedioContacto(String medioContacto) {
		this.medioContacto = medioContacto.trim();
	}

	/**
	 * Obtiene findep score.
	 *
	 * @return findep score
	 */
	public Integer getFindepScore() {
		return findepScore;
	}

	/**
	 * Establece findep score.
	 *
	 * @param findepScore a findep score
	 */
	public void setFindepScore(Integer findepScore) {
		this.findepScore = findepScore;
	}

	/**
	 * Obtiene tabla score.
	 *
	 * @return tabla score
	 */
	public Integer getTablaScore() {
		return tablaScore;
	}

	/**
	 * Establece tabla score.
	 *
	 * @param tablaScore a tabla score
	 */
	public void setTablaScore(Integer tablaScore) {
		this.tablaScore = tablaScore;
	}

	/**
	 * Obtiene bc score.
	 *
	 * @return bc score
	 */
	public Integer getBcScore() {
		return bcScore;
	}

	/**
	 * Establece bc score.
	 *
	 * @param bcScore a bc score
	 */
	public void setBcScore(Integer bcScore) {
		this.bcScore = bcScore;
	}

	/**
	 * Obtiene codigo destino credito.
	 *
	 * @return codigo destino credito
	 */
	public String getCodigoDestinoCredito() {
		return codigoDestinoCredito;
	}

	/**
	 * Establece codigo destino credito.
	 *
	 * @param codigoDestinoCredito a codigo destino credito
	 */
	public void setCodigoDestinoCredito(String codigoDestinoCredito) {
		this.codigoDestinoCredito = codigoDestinoCredito.trim();
	}

	/**
	 * Obtiene autorizo consulta imss.
	 *
	 * @return autorizo consulta imss
	 */
	public String getAutorizoConsultaImss() {
		return autorizoConsultaImss;
	}

	/**
	 * Establece autorizo consulta imss.
	 *
	 * @param autorizoConsultaImss a autorizo consulta imss
	 */
	public void setAutorizoConsultaImss(String autorizoConsultaImss) {
		this.autorizoConsultaImss = autorizoConsultaImss.trim();
	}

	/**
	 * Obtiene clave imss.
	 *
	 * @return clave imss
	 */
	public String getClaveImss() {
		return claveImss;
	}

	/**
	 * Establece clave imss.
	 *
	 * @param claveImss a clave imss
	 */
	public void setClaveImss(String claveImss) {
		this.claveImss = claveImss.trim();
	}

	/**
	 * Obtiene clave reso infonavit.
	 *
	 * @return clave reso infonavit
	 */
	public String getClaveResoInfonavit() {
		return claveResoInfonavit;
	}

	/**
	 * Establece clave reso infonavit.
	 *
	 * @param claveResoInfonavit a clave reso infonavit
	 */
	public void setClaveResoInfonavit(String claveResoInfonavit) {
		this.claveResoInfonavit = claveResoInfonavit.trim();
	}

	/**
	 * Obtiene clave reso imss.
	 *
	 * @return clave reso imss
	 */
	public String getClaveResoImss() {
		return claveResoImss;
	}

	/**
	 * Establece clave reso imss.
	 *
	 * @param claveResoImss a clave reso imss
	 */
	public void setClaveResoImss(String claveResoImss) {
		this.claveResoImss = claveResoImss.trim();
	}

	/**
	 * Obtiene cheque para.
	 *
	 * @return cheque para
	 */
	public String getChequePara() {
		return chequePara;
	}

	/**
	 * Establece cheque para.
	 *
	 * @param chequePara a cheque para
	 */
	public void setChequePara(String chequePara) {
		this.chequePara = chequePara.trim();
	}

	/**
	 * Obtiene monto seguro.
	 *
	 * @return monto seguro
	 */
	public Double getMontoSeguro() {
		return montoSeguro;
	}

	/**
	 * Establece monto seguro.
	 *
	 * @param montoSeguro a monto seguro
	 */
	public void setMontoSeguro(Double montoSeguro) {
		this.montoSeguro = montoSeguro;
	}

	/**
	 * Obtiene tipo disposicion.
	 *
	 * @return tipo disposicion
	 */
	public String getTipoDisposicion() {
		return tipoDisposicion;
	}

	/**
	 * Establece tipo disposicion.
	 *
	 * @param tipoDisposicion a tipo disposicion
	 */
	public void setTipoDisposicion(String tipoDisposicion) {
		this.tipoDisposicion = tipoDisposicion.trim();
	}

	/**
	 * Obtiene cargo mesa directiva.
	 *
	 * @return cargo mesa directiva
	 */
	public String getCargoMesaDirectiva() {
		return cargoMesaDirectiva;
	}

	/**
	 * Establece cargo mesa directiva.
	 *
	 * @param cargoMesaDirectiva a cargo mesa directiva
	 */
	public void setCargoMesaDirectiva(String cargoMesaDirectiva) {
		this.cargoMesaDirectiva = cargoMesaDirectiva.trim();
	}

	/**
	 * Obtiene contrato anterior.
	 *
	 * @return contrato anterior
	 */
	public String getContratoAnterior() {
		return contratoAnterior;
	}

	/**
	 * Establece contrato anterior.
	 *
	 * @param contratoAnterior a contrato anterior
	 */
	public void setContratoAnterior(String contratoAnterior) {
		this.contratoAnterior = contratoAnterior.trim();
	}

	/**
	 * Obtiene monto contrato anterior.
	 *
	 * @return monto contrato anterior
	 */
	public Double getMontoContratoAnterior() {
		return montoContratoAnterior;
	}

	/**
	 * Establece monto contrato anterior.
	 *
	 * @param montoContratoAnterior a monto contrato anterior
	 */
	public void setMontoContratoAnterior(Double montoContratoAnterior) {
		this.montoContratoAnterior = montoContratoAnterior;
	}

	/**
	 * Obtiene hit bc.
	 *
	 * @return hit bc
	 */
	public String getHitBc() {
		return hitBc;
	}

	/**
	 * Establece hit bc.
	 *
	 * @param hitBc a hit bc
	 */
	public void setHitBc(String hitBc) {
		this.hitBc = hitBc.trim();
	}

	/**
	 * Obtiene numero cuentas bc.
	 *
	 * @return numero cuentas bc
	 */
	public Integer getNumeroCuentasBc() {
		return numeroCuentasBc;
	}

	/**
	 * Establece numero cuentas bc.
	 *
	 * @param numeroCuentasBc a numero cuentas bc
	 */
	public void setNumeroCuentasBc(Integer numeroCuentasBc) {
		this.numeroCuentasBc = numeroCuentasBc;
	}

	/**
	 * Obtiene clasificacion fira.
	 *
	 * @return clasificacion fira
	 */
	public String getClasificacionFira() {
		return clasificacionFira;
	}

	/**
	 * Establece clasificacion fira.
	 *
	 * @param clasificacionFira a clasificacion fira
	 */
	public void setClasificacionFira(String clasificacionFira) {
		this.clasificacionFira = clasificacionFira.trim();
	}

	/**
	 * Obtiene pct participacion.
	 *
	 * @return pct participacion
	 */
	public Double getPctParticipacion() {
		return pctParticipacion;
	}

	/**
	 * Establece pct participacion.
	 *
	 * @param pctParticipacion a pct participacion
	 */
	public void setPctParticipacion(Double pctParticipacion) {
		this.pctParticipacion = pctParticipacion;
	}

	/**
	 * Obtiene etapa anterior.
	 *
	 * @return etapa anterior
	 */
	public String getEtapaAnterior() {
		return etapaAnterior;
	}

	/**
	 * Establece etapa anterior.
	 *
	 * @param etapaAnterior a etapa anterior
	 */
	public void setEtapaAnterior(String etapaAnterior) {
		this.etapaAnterior = etapaAnterior.trim();
	}

	/**
	 * Obtiene motivo status.
	 *
	 * @return motivo status
	 */
	public String getMotivoStatus() {
		return motivoStatus;
	}

	/**
	 * Establece motivo status.
	 *
	 * @param motivoStatus a motivo status
	 */
	public void setMotivoStatus(String motivoStatus) {
		this.motivoStatus = motivoStatus.trim();
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
		this.status = status.trim();
	}

	/**
	 * Obtiene etapa.
	 *
	 * @return etapa
	 */
	public String getEtapa() {
		return etapa;
	}

	/**
	 * Establece etapa.
	 *
	 * @param etapa a etapa
	 */
	public void setEtapa(String etapa) {
		this.etapa = etapa.trim();
	}

	/**
	 * Obtiene numero integrante.
	 *
	 * @return numero integrante
	 */
	public Integer getNumeroIntegrante() {
		return numeroIntegrante;
	}

	/**
	 * Establece numero integrante.
	 *
	 * @param numeroIntegrante a numero integrante
	 */
	public void setNumeroIntegrante(Integer numeroIntegrante) {
		this.numeroIntegrante = numeroIntegrante;
	}

	/**
	 * Obtiene referencia.
	 *
	 * @return referencia
	 */
	public String getReferencia() {
		return referencia;
	}

	/**
	 * Establece referencia.
	 *
	 * @param referencia a referencia
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia.trim();
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
