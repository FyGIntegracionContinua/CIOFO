package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class BuzonExcepcionOV.
 *
 * @author out_gcorzo
 * @version 1.0
 */
public class BuzonExcepcionOV extends ObjetoValor {

	/**
	 * Instancia una nueva buzon excepcion ov.
	 */
	public BuzonExcepcionOV() {
	}
	/** Se genero serial. */
	private static final long serialVersionUID = 9096745766154723290L;

	/** The idTarea. */
	private Integer idTarea;

	/** The contrato. */
	private String contrato;

	/** The montoSolicitado. */
	private Double montoSolicitado;

	/** The solicitud. */
	private String solicitud;

	/** The producto. */
	private String producto;

	/** The nombreGrupo. */
	private String nombreGrupo;

	/** The nombreDiv. */
	private String nombreDiv;

	/** The cliente. */
	private String cliente;

	/** The sucursal. */
	private String sucursal;

	/** The numeroSucursal. */
	private String numeroSucursal;

	/** The division. */
	private String division;

	/** The numeroDivision. */
	private String numeroDivision;

	/** The ciclo. */
	private Integer ciclo;

	/** The campana. */
	private String campana;

	/** The tipoTarea. */
	private String tipoTarea;

	/** The justificacion. */
	private String justificacion;

	/** The fechaAlta. */
	private String fechaAlta;

	/** The fechaCaptura. */
	private String fechaCaptura;

	/** The fechaAutorizacion. */
	private String fechaAutorizacion;

	/** The fechaIngreso. */
	private String fechaIngreso;

	/** The region. */
	private String region;

	/** The numeroRegion. */
	private String numeroRegion;

	/** The observaciones. */
	private String observaciones;

	/** The espera. */
	private Integer espera;

	/** The pctGarantia. */
	private String pctGarantia;

	/** The montoCreditoAnterior. */
	private String montoCreditoAnterior;

	/** The garantiaCreditoAnterior. */
	private String garantiaCreditoAnterior;

	/** The express. */
	private String express;

		/** The express. */
	private String autorizaRegional;

	/** The express. */
	private String autorizaDivisional;

	/** The montoCicloAnterior. */
	private String montoCicloAnterior;

	/** The montoSolicitadoAproElec. */
	private String montoSolicitadoAproElec;

	/**
	 * @return the nombreDiv
	 */
	public String getNombreDiv() {
		return nombreDiv;
	}

	/**
	 * @param nombreDiv the nombreDiv to set
	 */
	public void setNombreDiv(String nombreDiv) {
		this.nombreDiv = nombreDiv;
	}

	/**
	 * @return the numeroSucursal
	 */
	public String getNumeroSucursal() {
		return numeroSucursal;
	}

	/**
	 * @param numeroSucursal the numeroSucursal to set
	 */
	public void setNumeroSucursal(String numeroSucursal) {
		this.numeroSucursal = numeroSucursal;
	}

	/**
	 * @return the numeroDivision
	 */
	public String getNumeroDivision() {
		return numeroDivision;
	}

	/**
	 * @param numeroDivision the numeroDivision to set
	 */
	public void setNumeroDivision(String numeroDivision) {
		this.numeroDivision = numeroDivision;
	}

	/**
	 * @return the numeroRegion
	 */
	public String getNumeroRegion() {
		return numeroRegion;
	}

	/**
	 * @param numeroRegion the numeroRegion to set
	 */
	public void setNumeroRegion(String numeroRegion) {
		this.numeroRegion = numeroRegion;
	}

	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
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
	 * @return the fechaIngreso
	 */
	public String getFechaIngreso() {
		return fechaIngreso;
	}

	/**
	 * @param fechaIngreso the fechaIngreso to set
	 */
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	/**
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * @return the division
	 */
	public String getDivision() {
		return division;
	}

	/**
	 * @param division the division to set
	 */
	public void setDivision(String division) {
		this.division = division;
	}

	/**
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * @return the montoSolicitado
	 */
	public Double getMontoSolicitado() {
		return montoSolicitado;
	}

	/**
	 * @param montoSolicitado the montoSolicitado to set
	 */
	public void setMontoSolicitado(Double montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}

	/**
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the justificacion
	 */
	public String getJustificacion() {
		return justificacion;
	}

	/**
	 * @param justificacion the justificacion to set
	 */
	public void setJustificacion(String justificacion) {
		this.justificacion = justificacion;
	}

	/**
	 * @return the fechaCaptura
	 */
	public String getFechaCaptura() {
		return fechaCaptura;
	}

	/**
	 * @param fechaCaptura the fechaCaptura to set
	 */
	public void setFechaCaptura(String fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}

	/**
	 * @return the fechaAutorizacion
	 */
	public String getFechaAutorizacion() {
		return fechaAutorizacion;
	}

	/**
	 * @param fechaAutorizacion the fechaAutorizacion to set
	 */
	public void setFechaAutorizacion(String fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}

	/**
	 * @return the idTarea
	 */
	public Integer getIdTarea() {
		return idTarea;
	}

	/**
	 * @param idTarea the idTarea to set
	 */
	public void setIdTarea(Integer idTarea) {
		this.idTarea = idTarea;
	}

	/**
	 * @return the solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}

	/**
	 * @param solicitud the solicitud to set
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	/**
	 * @return the nombreGrupo
	 */
	public String getNombreGrupo() {
		return nombreGrupo;
	}

	/**
	 * @param nombreGrupo the nombreGrupo to set
	 */
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	/**
	 * @return the tipoTarea
	 */
	public String getTipoTarea() {
		return tipoTarea;
	}

	/**
	 * @param tipoTarea the tipoTarea to set
	 */
	public void setTipoTarea(String tipoTarea) {
		this.tipoTarea = tipoTarea;
	}

	/**
	 * @return the fechaAlta
	 */
	public String getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * @return the espera
	 */
	public Integer getEspera() {
		return espera;
	}

	/**
	 * @param espera the espera to set
	 */
	public void setEspera(Integer espera) {
		this.espera = espera;
	}

	/**
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

	/**
	 * @return the pctGarantia
	 */
	public String getPctGarantia() {
		return pctGarantia;
	}

	/**
	 * @param pctGarantia the pctGarantia to set
	 */
	public void setPctGarantia(String pctGarantia) {
		this.pctGarantia = pctGarantia;
	}

	/**
	 * @return the montoCreditoAnterior
	 */
	public String getMontoCreditoAnterior() {
		return montoCreditoAnterior;
	}

	/**
	 * @param montoCreditoAnterior the montoCreditoAnterior to set
	 */
	public void setMontoCreditoAnterior(String montoCreditoAnterior) {
		this.montoCreditoAnterior = montoCreditoAnterior;
	}

	/**
	 * @return the garantiaCreditoAnterior
	 */
	public String getGarantiaCreditoAnterior() {
		return garantiaCreditoAnterior;
	}

	/**
	 * @param garantiaCreditoAnterior the garantiaCreditoAnterior to set
	 */
	public void setGarantiaCreditoAnterior(String garantiaCreditoAnterior) {
		this.garantiaCreditoAnterior = garantiaCreditoAnterior;
	}

	/**
	 * @return the express
	 */
	public String getExpress() {
		return express;
	}

	/**
	 * @param express the express to set
	 */
	public void setExpress(String express) {
		this.express = express;
	}

	/**
	 * @return the autorizaRegional
	 */
	public String getAutorizaRegional() {
		return autorizaRegional;
	}

	/**
	 * @param autorizaRegional the autorizaRegional to set
	 */
	public void setAutorizaRegional(String autorizaRegional) {
		this.autorizaRegional = autorizaRegional;
	}

	/**
	 * @return the autorizaDivisional
	 */
	public String getAutorizaDivisional() {
		return autorizaDivisional;
	}

	/**
	 * @param autorizaDivisional the autorizaDivisional to set
	 */
	public void setAutorizaDivisional(String autorizaDivisional) {
		this.autorizaDivisional = autorizaDivisional;
	}

	/**
	 * @return the montoCicloAnterior
	 */
	public String getMontoCicloAnterior() {
		return montoCicloAnterior;
	}

	/**
	 * @param montoCicloAnterior the montoCicloAnterior to set
	 */
	public void setMontoCicloAnterior(String montoCicloAnterior) {
		this.montoCicloAnterior = montoCicloAnterior;
	}

	/**
	 * @return the montoSolicitadoAproElec
	 */
	public String getMontoSolicitadoAproElec() {
		return montoSolicitadoAproElec;
	}

	/**
	 * @param montoSolicitadoAproElec the montoSolicitadoAproElec to set
	 */
	public void setMontoSolicitadoAproElec(String montoSolicitadoAproElec) {
		this.montoSolicitadoAproElec = montoSolicitadoAproElec;
	}
	
	

}

