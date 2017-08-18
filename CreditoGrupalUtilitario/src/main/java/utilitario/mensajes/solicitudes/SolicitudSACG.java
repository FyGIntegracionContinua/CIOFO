package utilitario.mensajes.solicitudes;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class SolicitudSACG.
 *
 * @author out_ltorres
 * @version 1.0
 */
public class SolicitudSACG extends ObjetoValor {

	/**
	 * Instancia una nueva solicitud sacg.
	 */
	public SolicitudSACG() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7892844047003308650L;

	/** The id. */
	private String id; // Char

	/** The sucursal. */
	private Integer sucursal;

	/** The sucursal. */
	private Integer region;

	/** The sucursal. */
	private Integer division;

	/** The nom sucursal. */
	private String nomSucursal;

	/** The cdg asesor. */
	private String cdgAsesor; // Char

	/** The nombre asesor. */
	private String nombreAsesor;

	/** The producto. */
	private String producto;

	/** The des producto. */
	private String desProducto;

	/** The tasa. */
	private Double tasa;

	/** The plazo. */
	private Integer plazo;

	/** The frecuencia pago. */
	private String frecuenciaPago; // Char(1)

	/** The dia reunion. */
	private Integer diaReunion;

	/** The hora reunion. */
	private String horaReunion;

	/** The domicilio reunion. */
	private String domicilioReunion;

	/** The ultimo credito aprobado. */
	private Double ultimoCreditoAprobado;

	/** The nuevo credito solicitado. */
	private Double nuevoCreditoSolicitado;

	/** The fecha solicitud. */
	private Date fechaSolicitud;

	/** The fecha desembolso. */
	private Date fechaDesembolso;

	/** The fecha fin. */
	private java.sql.Date fechaFin;

	/** The estatus pocg. */
	private Integer estatusPocg;

	/** The renovacion. */
	private Boolean renovacion;

	/** The contrato ld. */
	private String contratoLD;

	/** The ciclo. */
	private Integer ciclo;

	/** The visualiza cec. */
	private String visualizaCec;

	/** The contrato previo. */
	private String contratoPrevio; // char

	/** The dia pago. */
	private Integer diaPago;

	/** The renovacion financiada. */
	private Boolean renovacionFinanciada;

	/** The hora reunion fin. */
	private String horaReunionFin;

	/** The persona dom reunion. */
	private String personaDomReunion; // char

	/** The usuario registra solicitud. */
	private String usuarioRegistraSolicitud;

	/** The excepcion garantia. */
	private String excepcionGarantia;

	/** The autorizacion garantia. */
	private String autorizacionGarantia;

	/** The usuario autorizacion. */
	private String usuarioAutorizacion;

	/** The fecha autorizacion. */
	private Date fechaAutorizacion;

	/** The seguro. */
	private String seguro;

	/** The estatus. */
	private String estatus;

	/** The des estatus. */
	private String desEstatus;

	/** The express. */
	private String express;

	/** The campana. */
	private String campana;

	/** The senalamientoExcepcion. */
	private String senalamientoExcepcion;

	/** The categoriaProducto. */
	private String categoriaProducto;

	/** The status. */
	private String status;

	/** The opcion garantia. */
	private String traspasoGarantia;

	/** The pct garantia. */
	private Integer pctGarantia;

	/** The motivo de cancelación. */
	private String motivoCancelacion;

	/** The motivo de saldoGarantia. */
	private double saldoGarantia;

	/** The justificacionExc. */
	private String justificacionExc;

	/** The aplicarGarantia. */
	private String aplicarGarantia;

	/** The aplicarGarantia. */
	private String aplicarGarantiaDesertor;

	/** The numContrato. */
	private String numContrato;

	/** The numContratoPrevio. */
	private String numContratoPrevio;

	/**
	 * variable que se utilizara para madar a buzon o no.
	 */
	private String entrarBuzon;

	/** Fecha en que se asigna al documental. */
	private Date fechaAsignacionDocumental;

	/** tareas que tiene el documental como pendientes*/
	private int tareaDocumentalPendiente;

	/** The justificacionValidacionDocumental. */
	private String justificacionValidacionDocumental;
	/**dias mora del contrato anterior*/
	private int diasMora;

	/**analista documental que autoriza la solicitud*/
	private String analistaDocAutoriza;

	/** The enviarDocumental. */
	private boolean enviarDocumental;

	/*****************************Parametros que se agregan para la fase 2 y 3***************************/
	/** tipo de excepcion que puede ser de cupo o monto*/
	private String tipoExcepcion;

	/**Estatus RestriccionCupoMonto*/
	private String estatusRestriccionCupoMonto;

	/**mensaje que se envia cuando surja una excepcion para monto o cupo por deafaul va vacio*/
	private String justificacionMontoYCupo;

	/**tareas pendientes que se tengan de cupo o monto*/
	private int tareaCupoMontoPendiente;
	
	/**perfil con el que se loguea PSEC, PSUC, etc*/
	private String perfil; 


	/**
	 * @return the motivoCancelacion
	 */
	public String getMotivoCancelacion() {
		return motivoCancelacion;
	}

	/**
	 * @param motivoCancelacion the motivoCancelacion to set
	 */
	public void setMotivoCancelacion(String motivoCancelacion) {
		this.motivoCancelacion = motivoCancelacion;
	}

	/**
	 * Obtiene id.
	 *
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece id.
	 *
	 * @param id a id
	 */
	public void setId(String id) {
		this.id = id.trim();
	}

	/**
	 * Obtiene sucursal.
	 *
	 * @return sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal a sucursal
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene cdg asesor.
	 *
	 * @return cdg asesor
	 */
	public String getCdgAsesor() {
		return cdgAsesor;
	}

	/**
	 * Establece cdg asesor.
	 *
	 * @param cdgAsesor a cdg asesor
	 */
	public void setCdgAsesor(String cdgAsesor) {
		this.cdgAsesor = cdgAsesor.trim();
	}

	/**
	 * Obtiene nombre asesor.
	 *
	 * @return nombre asesor
	 */
	public String getNombreAsesor() {
		return nombreAsesor;
	}

	/**
	 * Establece nombre asesor.
	 *
	 * @param nombreAsesor a nombre asesor
	 */
	public void setNombreAsesor(String nombreAsesor) {
		this.nombreAsesor = nombreAsesor;
	}

	/**
	 * Obtiene producto.
	 *
	 * @return producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * Establece producto.
	 *
	 * @param producto a producto
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

	/**
	 * Obtiene tasa.
	 *
	 * @return tasa
	 */
	public Double getTasa() {
		return tasa;
	}

	/**
	 * Establece tasa.
	 *
	 * @param tasa a tasa
	 */
	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}

	/**
	 * Obtiene plazo.
	 *
	 * @return plazo
	 */
	public Integer getPlazo() {
		return plazo;
	}

	/**
	 * Establece plazo.
	 *
	 * @param plazo a plazo
	 */
	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}

	/**
	 * Obtiene frecuencia pago.
	 *
	 * @return frecuencia pago
	 */
	public String getFrecuenciaPago() {
		return frecuenciaPago;
	}

	/**
	 * Establece frecuencia pago.
	 *
	 * @param frecuenciaPago a frecuencia pago
	 */
	public void setFrecuenciaPago(String frecuenciaPago) {
		this.frecuenciaPago = frecuenciaPago.trim();
	}

	/**
	 * Obtiene dia reunion.
	 *
	 * @return dia reunion
	 */
	public Integer getDiaReunion() {
		return diaReunion;
	}

	/**
	 * Establece dia reunion.
	 *
	 * @param diaReunion a dia reunion
	 */
	public void setDiaReunion(Integer diaReunion) {
		this.diaReunion = diaReunion;
	}

	/**
	 * Obtiene hora reunion.
	 *
	 * @return hora reunion
	 */
	public String getHoraReunion() {
		return horaReunion;
	}

	/**
	 * Establece hora reunion.
	 *
	 * @param horaReunion a hora reunion
	 */
	public void setHoraReunion(String horaReunion) {
		this.horaReunion = horaReunion;
	}

	/**
	 * Obtiene domicilio reunion.
	 *
	 * @return domicilio reunion
	 */
	public String getDomicilioReunion() {
		return domicilioReunion;
	}

	/**
	 * Establece domicilio reunion.
	 *
	 * @param domicilioReunion a domicilio reunion
	 */
	public void setDomicilioReunion(String domicilioReunion) {
		this.domicilioReunion = domicilioReunion;
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
	 * Obtiene fecha solicitud.
	 *
	 * @return fecha solicitud
	 */
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	/**
	 * Establece fecha solicitud.
	 *
	 * @param fechaSolicitud a fecha solicitud
	 */
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	/**
	 * Obtiene fecha desembolso.
	 *
	 * @return fecha desembolso
	 */
	public Date getFechaDesembolso() {
		return fechaDesembolso;
	}

	/**
	 * Establece fecha desembolso.
	 *
	 * @param fechaDesembolso a fecha desembolso
	 */
	public void setFechaDesembolso(Date fechaDesembolso) {
		this.fechaDesembolso = fechaDesembolso;
	}

	/**
	 * Obtiene fecha fin.
	 *
	 * @return fecha fin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * Establece fecha fin.
	 *
	 * @param fechaFin a fecha fin
	 */
	public void setFechaFin(java.sql.Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Obtiene estatus pocg.
	 *
	 * @return estatus pocg
	 */
	public Integer getEstatusPocg() {
		return estatusPocg;
	}

	/**
	 * Establece estatus pocg.
	 *
	 * @param estatusPocg a estatus pocg
	 */
	public void setEstatusPocg(Integer estatusPocg) {
		this.estatusPocg = estatusPocg;
	}

	/**
	 * Obtiene renovacion.
	 *
	 * @return renovacion
	 */
	public Boolean getRenovacion() {
		return renovacion;
	}

	/**
	 * Establece renovacion.
	 *
	 * @param renovacion a renovacion
	 */
	public void setRenovacion(Boolean renovacion) {
		this.renovacion = renovacion;
	}

	/**
	 * Obtiene contrato ld.
	 *
	 * @return contrato ld
	 */
	public String getContratoLD() {
		return contratoLD;
	}

	/**
	 * Establece contrato ld.
	 *
	 * @param contratoLD a contrato ld
	 */
	public void setContratoLD(String contratoLD) {
		this.contratoLD = contratoLD;
	}

	/**
	 * Obtiene ciclo.
	 *
	 * @return ciclo
	 */
	public Integer getCiclo() {
		return ciclo;
	}

	/**
	 * Establece ciclo.
	 *
	 * @param ciclo a ciclo
	 */
	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * Obtiene visualiza cec.
	 *
	 * @return visualiza cec
	 */
	public String getVisualizaCec() {
		return visualizaCec;
	}

	/**
	 * Establece visualiza cec.
	 *
	 * @param visualizaCec a visualiza cec
	 */
	public void setVisualizaCec(String visualizaCec) {
		this.visualizaCec = visualizaCec;
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
	 * Obtiene dia pago.
	 *
	 * @return dia pago
	 */
	public Integer getDiaPago() {
		return diaPago;
	}

	/**
	 * Establece dia pago.
	 *
	 * @param diaPago a dia pago
	 */
	public void setDiaPago(Integer diaPago) {
		this.diaPago = diaPago;
	}

	/**
	 * Obtiene renovacion financiada.
	 *
	 * @return renovacion financiada
	 */
	public Boolean getRenovacionFinanciada() {
		return renovacionFinanciada;
	}

	/**
	 * Establece renovacion financiada.
	 *
	 * @param renovacionFinanciada a renovacion financiada
	 */
	public void setRenovacionFinanciada(Boolean renovacionFinanciada) {
		this.renovacionFinanciada = renovacionFinanciada;
	}

	/**
	 * Obtiene hora reunion fin.
	 *
	 * @return hora reunion fin
	 */
	public String getHoraReunionFin() {
		return horaReunionFin;
	}

	/**
	 * Establece hora reunion fin.
	 *
	 * @param horaReunionFin a hora reunion fin
	 */
	public void setHoraReunionFin(String horaReunionFin) {
		this.horaReunionFin = horaReunionFin;
	}

	/**
	 * Obtiene persona dom reunion.
	 *
	 * @return persona dom reunion
	 */
	public String getPersonaDomReunion() {
		return personaDomReunion;
	}

	/**
	 * Establece persona dom reunion.
	 *
	 * @param personaDomReunion a persona dom reunion
	 */
	public void setPersonaDomReunion(String personaDomReunion) {
		this.personaDomReunion = personaDomReunion.trim();
	}

	/**
	 * Obtiene usuario registra solicitud.
	 *
	 * @return usuario registra solicitud
	 */
	public String getUsuarioRegistraSolicitud() {
		return usuarioRegistraSolicitud;
	}

	/**
	 * Establece usuario registra solicitud.
	 *
	 * @param usuarioRegistraSolicitud a usuario registra solicitud
	 */
	public void setUsuarioRegistraSolicitud(String usuarioRegistraSolicitud) {
		this.usuarioRegistraSolicitud = usuarioRegistraSolicitud;
	}

	/**
	 * Obtiene excepcion garantia.
	 *
	 * @return excepcion garantia
	 */
	public String getExcepcionGarantia() {
		return excepcionGarantia;
	}

	/**
	 * Establece excepcion garantia.
	 *
	 * @param excepcionGarantia a excepcion garantia
	 */
	public void setExcepcionGarantia(String excepcionGarantia) {
		this.excepcionGarantia = excepcionGarantia;
	}

	/**
	 * Obtiene autorizacion garantia.
	 *
	 * @return autorizacion garantia
	 */
	public String getAutorizacionGarantia() {
		return autorizacionGarantia;
	}

	/**
	 * Establece autorizacion garantia.
	 *
	 * @param autorizacionGarantia a autorizacion garantia
	 */
	public void setAutorizacionGarantia(String autorizacionGarantia) {
		this.autorizacionGarantia = autorizacionGarantia;
	}

	/**
	 * Obtiene usuario autorizacion.
	 *
	 * @return usuario autorizacion
	 */
	public String getUsuarioAutorizacion() {
		return usuarioAutorizacion;
	}

	/**
	 * Establece usuario autorizacion.
	 *
	 * @param usuarioAutorizacion a usuario autorizacion
	 */
	public void setUsuarioAutorizacion(String usuarioAutorizacion) {
		this.usuarioAutorizacion = usuarioAutorizacion;
	}

	/**
	 * Obtiene fecha autorizacion.
	 *
	 * @return fecha autorizacion
	 */
	public Date getFechaAutorizacion() {
		return fechaAutorizacion;
	}

	/**
	 * Establece fecha autorizacion.
	 *
	 * @param fechaAutorizacion a fecha autorizacion
	 */
	public void setFechaAutorizacion(Date fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
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
	 * Establece seguro.
	 *
	 * @param seguro a seguro
	 */
	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}

	/**
	 * Obtiene estatus.
	 *
	 * @return estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * Establece estatus.
	 *
	 * @param estatus a estatus
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * Obtiene des estatus.
	 *
	 * @return des estatus
	 */
	public String getDesEstatus() {
		return desEstatus;
	}

	/**
	 * Establece des estatus.
	 *
	 * @param desEstatus a des estatus
	 */
	public void setDesEstatus(String desEstatus) {
		this.desEstatus = desEstatus;
	}

	/**
	 * Obtiene express.
	 *
	 * @return express
	 */
	public String getExpress() {
		return express;
	}

	/**
	 * Establece express.
	 *
	 * @param express a express
	 */
	public void setExpress(String express) {
		this.express = express;
	}

	/**
	 * Establece des producto.
	 *
	 * @param desProducto a des producto
	 */
	public void setDesProducto(String desProducto) {
		this.desProducto = desProducto;
	}

	/**
	 * Obtiene des producto.
	 *
	 * @return des producto
	 */
	public String getDesProducto() {
		return desProducto;
	}

	/**
	 * Obtiene nom sucursal.
	 *
	 * @return nom sucursal
	 */
	public String getNomSucursal() {
		return nomSucursal;
	}

	/**
	 * Establece nom sucursal.
	 *
	 * @param nomSucursal a nom sucursal
	 */
	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
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
	 * @return the senalamientoExcepcion
	 */
	public String getSenalamientoExcepcion() {
		return senalamientoExcepcion;
	}

	/**
	 * @param senalamientoExcepcion the senalamientoExcepcion to set
	 */
	public void setSenalamientoExcepcion(String senalamientoExcepcion) {
		this.senalamientoExcepcion = senalamientoExcepcion;
	}

	/**
	 * @return the categoriaProducto
	 */
	public String getCategoriaProducto() {
		return categoriaProducto;
	}

	/**
	 * @param categoriaProducto the categoriaProducto to set
	 */
	public void setCategoriaProducto(String categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the traspasoGarantia
	 */
	public String getTraspasoGarantia() {
		return traspasoGarantia;
	}

	/**
	 * @param traspasoGarantia the traspasoGarantia to set
	 */
	public void setTraspasoGarantia(String traspasoGarantia) {
		this.traspasoGarantia = traspasoGarantia;
	}

	/**
	 * Gets the pct garantia.
	 *
	 * @return the pct garantia
	 */
	public Integer getPctGarantia() {
		return pctGarantia;
	}

	/**
	 * Sets the pct garantia.
	 *
	 * @param pctGarantia the new pct garantia
	 */
	public void setPctGarantia(Integer pctGarantia) {
		this.pctGarantia = pctGarantia;
	}

	/**
	 * @return the region
	 */
	public Integer getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(Integer region) {
		this.region = region;
	}

	/**
	 * @return the division
	 */
	public Integer getDivision() {
		return division;
	}

	/**
	 * @param division the division to set
	 */
	public void setDivision(Integer division) {
		this.division = division;
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
		 * @return the justificacionExc
		 */
		public String getJustificacionExc() {
			return justificacionExc;
		}

		/**
		 * @param justificacionExc the justificacionExc to set
		 */
		public void setJustificacionExc(String justificacionExc) {
			this.justificacionExc = justificacionExc;
		}

		/**
		 * @return the aplicarGarantia
		 */
		public String getAplicarGarantia() {
			return aplicarGarantia;
		}

		/**
		 * @param aplicarGarantia the aplicarGarantia to set
		 */
		public void setAplicarGarantia(String aplicarGarantia) {
			this.aplicarGarantia = aplicarGarantia;
		}

		/**
		 * @return the aplicarGarantiaDesertor
		 */
		public String getAplicarGarantiaDesertor() {
			return aplicarGarantiaDesertor;
		}

		/**
		 * @param aplicarGarantiaDesertor the aplicarGarantiaDesertor to set
		 */
		public void setAplicarGarantiaDesertor(String aplicarGarantiaDesertor) {
			this.aplicarGarantiaDesertor = aplicarGarantiaDesertor;
		}

		/**
		 * @return the numContrato
		 */
		public String getNumContrato() {
			return numContrato;
		}

		/**
		 * @param numContrato the numContrato to set
		 */
		public void setNumContrato(String numContrato) {
			this.numContrato = numContrato;
		}

		/**
		 * @return the numContratoPrevio
		 */
		public String getNumContratoPrevio() {
			return numContratoPrevio;
		}

		/**
		 * @param numContratoPrevio the numContratoPrevio to set
		 */
		public void setNumContratoPrevio(String numContratoPrevio) {
			this.numContratoPrevio = numContratoPrevio;
		}

		/**
		 * @return entrarBuzon
		 */
		public String getEntrarBuzon() {
			return entrarBuzon;
		}
		/**
		 * @param entrarBuzon the entrarBuzon
		 */
		public void setEntrarBuzon(String entrarBuzon) {
			this.entrarBuzon = entrarBuzon;
		}

		/**
		 * @return the fechaAsignacionDocumental
		 */
		public Date getFechaAsignacionDocumental() {
			return fechaAsignacionDocumental;
		}

		/**
		 * @param fechaAsignacionDocumental the fechaAsignacionDocumental to set
		 */
		public void setFechaAsignacionDocumental(Date fechaAsignacionDocumental) {
			this.fechaAsignacionDocumental = fechaAsignacionDocumental;
		}

		/**
		 * @return the diasMora
		 */
		public int getDiasMora() {
			return diasMora;
		}

		/**
		 * @param diasMora the diasMora to set
		 */
		public void setDiasMora(int diasMora) {
			this.diasMora = diasMora;
		}

		/**
		 * @return the analistaDocAutoriza
		 */
		public String getAnalistaDocAutoriza() {
			return analistaDocAutoriza;
		}

		/**
		 * @param analistaDocAutoriza the analistaDocAutoriza to set
		 */
		public void setAnalistaDocAutoriza(String analistaDocAutoriza) {
			this.analistaDocAutoriza = analistaDocAutoriza;
		}

		/**
		 * @return the tareaDocumentalPendiente
		 */
		public int getTareaDocumentalPendiente() {
			return tareaDocumentalPendiente;
		}

		/**
		 * @param tareaDocumentalPendiente the tareaDocumentalPendiente to set
		 */
		public void setTareaDocumentalPendiente(int tareaDocumentalPendiente) {
			this.tareaDocumentalPendiente = tareaDocumentalPendiente;
		}
		/**
		 * @return the justificacionValidacionDocumental
		 */
		public String getJustificacionValidacionDocumental() {
			return justificacionValidacionDocumental;
		}

		/**
		 * @param justificacionValidacionDocumental the justificacionValidacionDocumental to set
		 */
		public void setJustificacionValidacionDocumental(
				String justificacionValidacionDocumental) {
			this.justificacionValidacionDocumental = justificacionValidacionDocumental;
		}
		/**
		 * @return the enviarDocumental
		 */
		public boolean isEnviarDocumental() {
			return enviarDocumental;
		}

		/**
		 * @param enviarDocumental the enviarDocumental to set
		 */
		public void setEnviarDocumental(boolean enviarDocumental) {
			this.enviarDocumental = enviarDocumental;
		}

		/**
		 * @return the tipoExcepcion
		 */
		public String getTipoExcepcion() {
			return tipoExcepcion;
		}

		/**
		 * @param tipoExcepcion the tipoExcepcion to set
		 */
		public void setTipoExcepcion(String tipoExcepcion) {
			this.tipoExcepcion = tipoExcepcion;
		}

		/**
		 * @return the estatusRestriccionCupoMonto
		 */
		public String getEstatusRestriccionCupoMonto() {
			return estatusRestriccionCupoMonto;
		}

		/**
		 * @param estatusRestriccionCupoMonto the estatusRestriccionCupoMonto to set
		 */
		public void setEstatusRestriccionCupoMonto(String estatusRestriccionCupoMonto) {
			this.estatusRestriccionCupoMonto = estatusRestriccionCupoMonto;
		}

		/**
		 * @return the justificacionMontoYCupo
		 */
		public String getJustificacionMontoYCupo() {
			return justificacionMontoYCupo;
		}

		/**
		 * @param justificacionMontoYCupo the justificacionMontoYCupo to set
		 */
		public void setJustificacionMontoYCupo(String justificacionMontoYCupo) {
			this.justificacionMontoYCupo = justificacionMontoYCupo;
		}

		/**
		 * @return the tareaCupoMontoPendiente
		 */
		public int getTareaCupoMontoPendiente() {
			return tareaCupoMontoPendiente;
		}

		/**
		 * @param tareaCupoMontoPendiente the tareaCupoMontoPendiente to set
		 */
		public void setTareaCupoMontoPendiente(int tareaCupoMontoPendiente) {
			this.tareaCupoMontoPendiente = tareaCupoMontoPendiente;
		}

		/**
		 * @return the perfil
		 */
		public String getPerfil() {
			return perfil;
		}

		/**
		 * @param perfil the perfil to set
		 */
		public void setPerfil(String perfil) {
			this.perfil = perfil;
		}

}
