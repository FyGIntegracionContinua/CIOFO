package utilitario.mensajes.solicitudes;

import java.text.Normalizer;
import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * @author out_ltorres
 * @version 1.0
 */
public class ReporteSolicitudOV extends ObjetoValor {

	/**
	 * long serialVersionUID ReporteSolicitudOV.java
	 */
	private static final long serialVersionUID = -1588252257651094089L;

	/**
	 * String solicitud ReporteSolicitudOV.java
	 */
	private String solicitud;

	/**
	 * String grupoPersona ReporteSolicitudOV.java
	 */
	private String grupoPersona;

	/**
	 * String grupo ReporteSolicitudOV.java
	 */
	private String grupo;

	/**
	 * String nombreGrupo ReporteSolicitudOV.java
	 */
	private String nombreGrupo;

	/**
	 * Integer ciclo ReporteSolicitudOV.java
	 */
	private Integer ciclo;

	/**
	 * Integer integrantes ReporteSolicitudOV.java
	 */
	private Integer integrantes;

	/**
	 * String sucursal ReporteSolicitudOV.java
	 */
	private String sucursal;

	/**
	 * String producto ReporteSolicitudOV.java
	 */
	private String producto;

	/**
	 * String campanaEspecial ReporteSolicitudOV.java
	 */
	private String campanaEspecial;

	/**
	 * String contratoLD ReporteSolicitudOV.java
	 */
	private String contratoLD;

	/**
	 * String fechaCaptura ReporteSolicitudOV.java
	 */
	private String fechaCaptura;

	/**
	 * Double montoSolicitado ReporteSolicitudOV.java
	 */
	private Double montoSolicitado;

	/**
	 * Double montoAprobado ReporteSolicitudOV.java
	 */
	private Double montoAprobado;

	/**
	 * String status ReporteSolicitudOV.java
	 */
	private String estatus;

	/**
	 * String subEstatus ReporteSolicitudOV.java
	 */
	private String subEstatus;

	/**
	 * String analistaCECAsigno ReporteSolicitudOV.java
	 */
	private String analistaCECAsignado;

	/**
	 * String personaAnaCECAsig ReporteSolicitudOV.java
	 */
	private String personaAnaCECAsig;

	/**
	 * String analistaCECAutorizo ReporteSolicitudOV.java
	 */
	private String analistaCECAutorizo;

	/**
	 * String fechaAsignacion ReporteSolicitudOV.java
	 */
	private String fechaAsignacion;

	/**
	 * String tipoSucursal ReporteSolicitudOV.java
	 */
	private String tipoSucursal;

	/**
	 * String zona ReporteSolicitudOV.java
	 */
	private String zona;

	/**
	 * String division ReporteSolicitudOV.java
	 */
	private String division;

	/**
	 * String fechaAprobacion ReporteSolicitudOV.java
	 */
	private String fechaAprobacion;

	/**
	 * String fechaObservaciones ReporteSolicitudOV.java
	 */
	private String fechaObservaciones;

	/**
	 * String marcaEspecialCEC ReporteSolicitudOV.java
	 */
	private String marcaEspecialCEC;

	/**
	 * String analista ReporteSolicitudOV.java
	 */
	private String analista;

	/**
	 * String renovacion ReporteSolicitudOV.java
	 */
	private String renovacion;

	/**
	 * String ponderacion ReporteSolicitudOV.java
	 */
	private String ponderacion;

	/**
	 * String fechaReasignacion ReporteSolicitudOV.java
	 */
	private String fechaReasignacion;

	/**
	 * String analistaReasigno ReporteSolicitudOV.java
	 */
	private String analistaReasigno;

	/**
	 * String fechaUltObserv ReporteSolicitudOV.java
	 */
	private String fechaUltObserv;

	/**
	 * String renoFinanciada ReporteSolicitudOV.java
	 */
	private String renoFinanciada;

	/**
	 * String estatusReal ReporteSolicitudOV.java
	 */
	private String estatusReal;

	/**
	 * String estatusRealCod ReporteSolicitudOV.java
	 */
	private String estatusRealCod;

	/**
	 * String fechaRespuestaMaxima ReporteSolicitudOV.java
	 */
	private String fechaRespuestaMaxima;

	/**
	 * String estatusRevision ReporteSolicitudOV.java
	 */
	private String estatusRevision;

	/**
	 * String tiempoAnalisis ReporteSolicitudOV.java
	 */
	private String tiempoAnalisis;

	/**
	 * String numeroVueltas ReporteSolicitudOV.java
	 */
	private String numeroVueltas;

	/**
	 * String renovacionExpress ReporteSolicitudOV.java
	 */
	private String renovacionExpress;

	/**
	 * String fechaInicioGestion ReporteSolicitudOV.java
	 */
	private Date fechaInicioGestion;

	/**
	 * String fechaTermino ReporteSolicitudOV.java
	 */
	private Date fechaTermino;

	/**
	 * String motivoRechazo
	 */
	private String motivoRechazo;

	/**
	 * String usuarioOperacion
	 */
	private String usuarioOperacion;

	/**
	 * String fecha de operacion
	 */
	private String fechaOperacion;

	/**
	 * String hora de operación
	 */
	private String horaOperacion;

	/**
	 * String fecha de Autorizacion
	 */
	private String fechaAutorizacion;

	/**
	 * String horaAutorizacion
	 */
	private String horaAutorizacion;

	/**
	 * String fechaEnvioReg ReporteSolicitudOV.java
	 */
	private String fechaEnvioReg;

	/**
	 * String fechaRespuestaReg ReporteSolicitudOV.java
	 */
	private String fechaRespuestaReg;

	/**
	 * String fechaEnvioDiv ReporteSolicitudOV.java
	 */
	private String fechaEnvioDiv;

	/**
	 * String fechaRespuestaDiv ReporteSolicitudOV.java
	 */
	private String fechaRespuestaDiv;

	/**
	 * String fechaEnvioSubComercial ReporteSolicitudOV.java
	 */
	private String fechaEnvioSubComercial;

	/**
	 * String fechaRespuestaSubComercial ReporteSolicitudOV.java
	 */
	private String fechaRespuestaSubComercial;

	/**
	 * @return the fechaTermino
	 */
	public Date getFechaTermino() {
		return fechaTermino;
	}

	/**
	 * @param fechaTermino the fechaTermino to set
	 */
	public void setFechaTermino(Date fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	/**
	 * @return the fechaInicioGestion
	 */
	public Date getFechaInicioGestion() {
		return fechaInicioGestion;
	}

	/**
	 * @param fechaInicioGestion the fechaInicioGestion to set
	 */
	public void setFechaInicioGestion(Date fechaInicioGestion) {
		this.fechaInicioGestion = fechaInicioGestion;
	}


	/**
	 * @return the estatusRealCod
	 */
	public String getEstatusRealCod() {
		return estatusRealCod;
	}


	/**
	 * @param estatusRealCod the estatusRealCod to set
	 */
	public void setEstatusRealCod(String estatusRealCod) {
		this.estatusRealCod = estatusRealCod;
	}


	/**
	 * @return the estatusReal
	 */
	public String getEstatusReal() {
		return estatusReal;
	}


	/**
	 * @param estatusReal the estatusReal to set
	 */
	public void setEstatusReal(String estatusReal) {
		this.estatusReal = estatusReal;
	}


	/**
	 * @return the fechaRespuestaMaxima
	 */
	public String getFechaRespuestaMaxima() {
		return fechaRespuestaMaxima;
	}


	/**
	 * @param fechaRespuestaMaxima the fechaRespuestaMaxima to set
	 */
	public void setFechaRespuestaMaxima(String fechaRespuestaMaxima) {
		this.fechaRespuestaMaxima = fechaRespuestaMaxima;
	}


	/**
	 * @return the estatusRevision
	 */
	public String getEstatusRevision() {
		return estatusRevision;
	}


	/**
	 * @param estatusRevision the estatusRevision to set
	 */
	public void setEstatusRevision(String estatusRevision) {
		this.estatusRevision = estatusRevision;
	}


	/**
	 * @return the tiempoAnalisis
	 */
	public String getTiempoAnalisis() {
		return tiempoAnalisis;
	}


	/**
	 * @param tiempoAnalisis the tiempoAnalisis to set
	 */
	public void setTiempoAnalisis(String tiempoAnalisis) {
		this.tiempoAnalisis = tiempoAnalisis;
	}


	/**
	 * @return the numeroVueltas
	 */
	public String getNumeroVueltas() {
		return numeroVueltas;
	}


	/**
	 * @param numeroVueltas the numeroVueltas to set
	 */
	public void setNumeroVueltas(String numeroVueltas) {
		this.numeroVueltas = numeroVueltas;
	}


	/**
	 * @return the renovacionExpress
	 */
	public String getRenovacionExpress() {
		return renovacionExpress;
	}


	/**
	 * @param renovacionExpress the renovacionExpress to set
	 */
	public void setRenovacionExpress(String renovacionExpress) {
		this.renovacionExpress = renovacionExpress;
	}


	/**
	 * @return the ponderacion
	 */
	public String getPonderacion() {
		return ponderacion;
	}


	/**
	 * @param ponderacion the ponderacion to set
	 */
	public void setPonderacion(String ponderacion) {
		this.ponderacion = ponderacion;
	}


	/**
	 * @return the fechaReasignacion
	 */
	public String getFechaReasignacion() {
		return fechaReasignacion;
	}


	/**
	 * @param fechaReasignacion the fechaReasignacion to set
	 */
	public void setFechaReasignacion(String fechaReasignacion) {
		this.fechaReasignacion = fechaReasignacion;
	}


	/**
	 * @return the analistaReasigno
	 */
	public String getAnalistaReasigno() {
		return analistaReasigno;
	}


	/**
	 * @param analistaReasigno the analistaReasigno to set
	 */
	public void setAnalistaReasigno(String analistaReasigno) {
		this.analistaReasigno = analistaReasigno;
	}


	/**
	 * @return the fechaUltObserv
	 */
	public String getFechaUltObserv() {
		return fechaUltObserv;
	}


	/**
	 * @param fechaUltObserv the fechaUltObserv to set
	 */
	public void setFechaUltObserv(String fechaUltObserv) {
		this.fechaUltObserv = fechaUltObserv;
	}


	/**
	 * @return the renoFinanciada
	 */
	public String getRenoFinanciada() {
		return renoFinanciada;
	}


	/**
	 * @param renoFinanciada the renoFinanciada to set
	 */
	public void setRenoFinanciada(String renoFinanciada) {
		this.renoFinanciada = renoFinanciada;
	}

	/**
	 * Obtiene analista.
	 *
	 * @return the analista
	 */
	public String getSubEstatus() {
		return subEstatus;
	}


	/**
	 * @param subEstatus the subEstatus to set
	 */
	public void setSubEstatus(String subEstatus) {
		this.subEstatus = subEstatus;
	}

	/**
	 * Obtiene analista.
	 *
	 * @return the analista
	 */
	public String getAnalista() {
		return analista;
	}

	/**
	 * @param analista the analista to set
	 */
	public void setAnalista(String analista) {
		this.analista = analista;
	}

	/**
	 * Obtiene renovacion.
	 *
	 * @return the renovacion
	 */
	public String getRenovacion() {
		return renovacion;
	}

	/**
	 * @param renovacion the renovacion to set
	 */
	public void setRenovacion(String renovacion) {
		this.renovacion = renovacion;
	}

	/**
	 * Obtiene solicitud.
	 *
	 * @return the solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}

	/**
	 * Establece solicitud.
	 *
	 * @param solicitud the solicitud to set
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud.trim();
	}

	/**
	 * @return the grupoPersona
	 */
	public String getGrupoPersona() {
		return grupoPersona;
	}

	/**
	 * @param grupoPersona the grupoPersona to set
	 */
	public void setGrupoPersona(String grupoPersona) {
		this.grupoPersona = grupoPersona.trim();
	}

	/**
	 * Obtiene grupo.
	 *
	 * @return the grupo
	 */
	public String getGrupo() {
		return grupo;
	}

	/**
	 * Establece grupo.
	 *
	 * @param grupo the grupo to set
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	/**
	 * Obtiene nombreGrupo.
	 *
	 * @return the nombreGrupo
	 */
	public String getNombreGrupo() {
		nombreGrupo = Normalizer.normalize(nombreGrupo, Normalizer.Form.NFD);
		nombreGrupo = nombreGrupo.replaceAll("[^\\p{ASCII}]", "");
		return nombreGrupo;
	}

	/**
	 * Establece nombreGrupo.
	 *
	 * @param nombreGrupo the nombreGrupo to set
	 */
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	/**
	 * Obtiene ciclo.
	 *
	 * @return the ciclo
	 */
	public Integer getCiclo() {
		return ciclo;
	}

	/**
	 * Establece ciclo.
	 *
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * Obtiene integrantes.
	 *
	 * @return the integrantes
	 */
	public Integer getIntegrantes() {
		return integrantes;
	}

	/**
	 * Establece integrantes.
	 *
	 * @param integrantes the integrantes to set
	 */
	public void setIntegrantes(Integer integrantes) {
		this.integrantes = integrantes;
	}

	/**
	 * Obtiene sucursal.
	 *
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal.trim();
	}

	/**
	 * Obtiene producto.
	 *
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * Establece producto.
	 *
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

	/**
	 * Obtiene campanaEspecial.
	 *
	 * @return the campanaEspecial
	 */
	public String getCampanaEspecial() {
		return campanaEspecial;
	}

	/**
	 * Establece campanaEspecial.
	 *
	 * @param campanaEspecial the campanaEspecial to set
	 */
	public void setCampanaEspecial(String campanaEspecial) {
		this.campanaEspecial = campanaEspecial.trim();
	}

	/**
	 * Obtiene contratoLD.
	 *
	 * @return the contratoLD
	 */
	public String getContratoLD() {
		return contratoLD;
	}

	/**
	 * Establece contratoLD.
	 *
	 * @param contratoLD the contratoLD to set
	 */
	public void setContratoLD(String contratoLD) {
		this.contratoLD = contratoLD.trim();
	}

	/**
	 * Obtiene fechaCaptura.
	 *
	 * @return the fechaCaptura
	 */
	public String getFechaCaptura() {
		return fechaCaptura;
	}

	/**
	 * Establece fechaCaptura.
	 *
	 * @param fechaCaptura the fechaCaptura to set
	 */
	public void setFechaCaptura(String fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}

	/**
	 * Obtiene montoSolicitado.
	 *
	 * @return the montoSolicitado
	 */
	public Double getMontoSolicitado() {
		return montoSolicitado;
	}

	/**
	 * Establece montoSolicitado.
	 *
	 * @param montoSolicitado the montoSolicitado to set
	 */
	public void setMontoSolicitado(Double montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}

	/**
	 * Obtiene montoAprobado.
	 *
	 * @return the montoAprobado
	 */
	public Double getMontoAprobado() {
		return montoAprobado;
	}

	/**
	 * Establece montoAprobado.
	 *
	 * @param montoAprobado the montoAprobado to set
	 */
	public void setMontoAprobado(Double montoAprobado) {
		this.montoAprobado = montoAprobado;
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
	 * @return the analistaCECAsignado
	 */
	public String getAnalistaCECAsignado() {
		return analistaCECAsignado;
	}

	/**
	 * @param analistaCECAsignado the analistaCECAsignado to set
	 */
	public void setAnalistaCECAsignado(String analistaCECAsignado) {
		this.analistaCECAsignado = analistaCECAsignado.trim();
	}

	/**
	 * Obtiene analistaCECAutorizo.
	 *
	 * @return the analistaCECAutorizo
	 */
	public String getAnalistaCECAutorizo() {
		return analistaCECAutorizo;
	}

	/**
	 * Establece analistaCECAutorizo.
	 *
	 * @param analistaCECAutorizo the analistaCECAutorizo to set
	 */
	public void setAnalistaCECAutorizo(String analistaCECAutorizo) {
		this.analistaCECAutorizo = analistaCECAutorizo.trim();
	}

	/**
	 * Obtiene fechaAsignacion.
	 *
	 * @return the fechaAsignacion
	 */
	public String getFechaAsignacion() {
		return fechaAsignacion;
	}

	/**
	 * Establece fechaAsignacion.
	 *
	 * @param fechaAsignacion the fechaAsignacion to set
	 */
	public void setFechaAsignacion(String fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion.trim();
	}

	/**
	 * Obtiene tipoSucursal.
	 *
	 * @return the tipoSucursal
	 */
	public String getTipoSucursal() {
		return tipoSucursal;
	}

	/**
	 * Establece tipoSucursal.
	 *
	 * @param tipoSucursal the tipoSucursal to set
	 */
	public void setTipoSucursal(String tipoSucursal) {
		this.tipoSucursal = tipoSucursal;
	}

	/**
	 * Obtiene zona.
	 *
	 * @return the zona
	 */
	public String getZona() {
		return zona;
	}

	/**
	 * Establece zona.
	 *
	 * @param zona the zona to set
	 */
	public void setZona(String zona) {
		this.zona = zona.trim();
	}

	/**
	 * Obtiene division.
	 *
	 * @return the division
	 */
	public String getDivision() {
		return division;
	}

	/**
	 * Establece division.
	 *
	 * @param division the division to set
	 */
	public void setDivision(String division) {
		this.division = division.trim();
	}

	/**
	 * Obtiene fechaAprobacion.
	 *
	 * @return the fechaAprobacion
	 */
	public String getFechaAprobacion() {
		return fechaAprobacion;
	}

	/**
	 * Establece fechaAprobacion.
	 *
	 * @param fechaAprobacion the fechaAprobacion to set
	 */
	public void setFechaAprobacion(String fechaAprobacion) {
		this.fechaAprobacion = fechaAprobacion.trim();
	}

	/**
	 * Obtiene fechaObservaciones.
	 *
	 * @return the fechaObservaciones
	 */
	public String getFechaObservaciones() {
		return fechaObservaciones;
	}

	/**
	 * Establece fechaObservaciones.
	 *
	 * @param fechaObservaciones the fechaObservaciones to set
	 */
	public void setFechaObservaciones(String fechaObservaciones) {
		this.fechaObservaciones = fechaObservaciones.trim();
	}

	/**
	 * Obtiene marcaEspecialCEC.
	 *
	 * @return the marcaEspecialCEC
	 */
	public String getMarcaEspecialCEC() {
		return marcaEspecialCEC;
	}

	/**
	 * Establece marcaEspecialCEC.
	 *
	 * @param marcaEspecialCEC the marcaEspecialCEC to set
	 */
	public void setMarcaEspecialCEC(String marcaEspecialCEC) {
		this.marcaEspecialCEC = marcaEspecialCEC;
	}

	/**
	 * @return the personaAnaCECAsig
	 */
	public String getPersonaAnaCECAsig() {
		return personaAnaCECAsig;
	}

	/**
	 * @param personaAnaCECAsig the personaAnaCECAsig to set
	 */
	public void setPersonaAnaCECAsig(String personaAnaCECAsig) {
		this.personaAnaCECAsig = personaAnaCECAsig.trim();
	}

	/**
	 * @return the motivoRechazo
	 */
	public String getMotivoRechazo() {
		return motivoRechazo;
	}

	/**
	 * @param motivoRechazo the motivoRechazo to set
	 */
	public void setMotivoRechazo(String motivoRechazo) {
		this.motivoRechazo = motivoRechazo;
	}

	/**
	 * @return the usuarioOperacion
	 */
	public String getUsuarioOperacion() {
		return usuarioOperacion;
	}

	/**
	 * @param usuarioOperacion the usuarioOperacion to set
	 */
	public void setUsuarioOperacion(String usuarioOperacion) {
		this.usuarioOperacion = usuarioOperacion;
	}

	/**
	 * @return the fechaOperacion
	 */
	public String getFechaOperacion() {
		return fechaOperacion;
	}

	/**
	 * @param fechaOperacion the fechaOperacion to set
	 */
	public void setFechaOperacion(String fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}

	/**
	 * @return the horaOperacion
	 */
	public String getHoraOperacion() {
		return horaOperacion;
	}

	/**
	 * @param horaOperacion the horaOperacion to set
	 */
	public void setHoraOperacion(String horaOperacion) {
		this.horaOperacion = horaOperacion;
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
	 * @return the horaAutorizacion
	 */
	public String getHoraAutorizacion() {
		return horaAutorizacion;
	}

	/**
	 * @param horaAutorizacion the horaAutorizacion to set
	 */
	public void setHoraAutorizacion(String horaAutorizacion) {
		this.horaAutorizacion = horaAutorizacion;
	}

	/**
	 * @return the fechaEnvioReg
	 */
	public String getFechaEnvioReg() {
		return fechaEnvioReg;
	}

	/**
	 * @param fechaEnvioReg the fechaEnvioReg to set
	 */
	public void setFechaEnvioReg(String fechaEnvioReg) {
		this.fechaEnvioReg = fechaEnvioReg;
	}

	/**
	 * @return the fechaRespuestaReg
	 */
	public String getFechaRespuestaReg() {
		return fechaRespuestaReg;
	}

	/**
	 * @param fechaRespuestaReg the fechaRespuestaReg to set
	 */
	public void setFechaRespuestaReg(String fechaRespuestaReg) {
		this.fechaRespuestaReg = fechaRespuestaReg;
	}

	/**
	 * @return the fechaEnvioDiv
	 */
	public String getFechaEnvioDiv() {
		return fechaEnvioDiv;
	}

	/**
	 * @param fechaEnvioDiv the fechaEnvioDiv to set
	 */
	public void setFechaEnvioDiv(String fechaEnvioDiv) {
		this.fechaEnvioDiv = fechaEnvioDiv;
	}

	/**
	 * @return the fechaRespuestaDiv
	 */
	public String getFechaRespuestaDiv() {
		return fechaRespuestaDiv;
	}

	/**
	 * @param fechaRespuestaDiv the fechaRespuestaDiv to set
	 */
	public void setFechaRespuestaDiv(String fechaRespuestaDiv) {
		this.fechaRespuestaDiv = fechaRespuestaDiv;
	}

	/**
	 * @return the fechaEnvioSubComercial
	 */
	public String getFechaEnvioSubComercial() {
		return fechaEnvioSubComercial;
	}

	/**
	 * @param fechaEnvioSubComercial the fechaEnvioSubComercial to set
	 */
	public void setFechaEnvioSubComercial(String fechaEnvioSubComercial) {
		this.fechaEnvioSubComercial = fechaEnvioSubComercial;
	}

	/**
	 * @return the fechaRespuestaSubComercial
	 */
	public String getFechaRespuestaSubComercial() {
		return fechaRespuestaSubComercial;
	}

	/**
	 * @param fechaRespuestaSubComercial the fechaRespuestaSubComercial to set
	 */
	public void setFechaRespuestaSubComercial(String fechaRespuestaSubComercial) {
		this.fechaRespuestaSubComercial = fechaRespuestaSubComercial;
	}
}
