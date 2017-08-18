package utilitario.mensajes.convenio;

import java.util.List;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author mi.mejorada
 *
 */
public class ConvenioOV extends ObjetoValor {

	/**
	 * ConvenioOV
	 */
	public ConvenioOV() {

	}

	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = -6466732264132410826L;
	/**
	 * numeroContrato String
	 */
	private String 				numeroContrato;
	/**
	 * numeroPersona String
	 */
	private String 				numeroPersona;
	/**
	 * nombrePersona String
	 */
	private String 				nombrePersona;
	/**
	 * numeroConvenio Integer
	 */
	private Integer 			numeroConvenio;
	/**
	 * numeroGestor String
	 */
	private String 				numeroGestor;
	/**
	 * nombreGestor String
	 */
	private String 				nombreGestor;
	/**
	 * nombreGrupo String
	 */
	private String 				nombreGrupo;
	/**
	 * montoSolicitado Double
	 */
	private Double 				montoSolicitado;
	/**
	 * saldoCapital Double
	 */
	private Double 				saldoCapital;
	/**
	 * saldoInteres Double
	 */
	private Double				saldoInteres;
	/**
	 * saldoMoratorios Double
	 */
	private Double				saldoMoratorios;
	/**
	 * usuarioCaptura String
	 */
	private String				usuarioCaptura;
	/**
	 * montoPagoConvenio Double
	 */
	private Double				montoPagoConvenio;
	/**
	 * montoBonificaConvenio Double
	 */
	private Double				montoBonificaConvenio;
	/**
	 * montoTotalConvenio Double
	 */
	private Double				montoTotalConvenio;
	/**
	 * plazoConvenio Integer
	 */
	private Integer				plazoConvenio;
	/**
	 * frecuenciaConvenio String
	 */
	private String				frecuenciaConvenio;
	/**
	 * fechaInicioConvenio java.util.Date
	 */
	private java.util.Date		fechaInicioConvenio;
	/**
	 * fechaFinConvenio java.util.Date
	 */
	private java.util.Date		fechaFinConvenio;
	/**
	 * status String
	 */
	private String				status;
	/**
	 * pagosConvenio List<PagosConvenioOV>
	 */
	private List<PagosConvenioOV> pagosConvenio;
	/**
	 * @return the numeroContrato
	 */
	public String getNumeroContrato() {
		return numeroContrato;
	}
	/**
	 * @param numeroContrato the numeroContrato to set
	 */
	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}
	/**
	 * @return the numeroPersona
	 */
	public String getNumeroPersona() {
		return numeroPersona;
	}
	/**
	 * @param numeroPersona the numeroPersona to set
	 */
	public void setNumeroPersona(String numeroPersona) {
		this.numeroPersona = numeroPersona;
	}
	/**
	 * @return the nombrePersona
	 */
	public String getNombrePersona() {
		return nombrePersona;
	}
	/**
	 * @param nombrePersona the nombrePersona to set
	 */
	public void setNombrePersona(String nombrePersona) {
		this.nombrePersona = nombrePersona;
	}
	/**
	 * @return the numeroConvenio
	 */
	public Integer getNumeroConvenio() {
		return numeroConvenio;
	}
	/**
	 * @param numeroConvenio the numeroConvenio to set
	 */
	public void setNumeroConvenio(Integer numeroConvenio) {
		this.numeroConvenio = numeroConvenio;
	}
	/**
	 * @return the numeroGestor
	 */
	public String getNumeroGestor() {
		return numeroGestor;
	}
	/**
	 * @param numeroGestor the numeroGestor to set
	 */
	public void setNumeroGestor(String numeroGestor) {
		this.numeroGestor = numeroGestor;
	}
	/**
	 * @return the nombreGestor
	 */
	public String getNombreGestor() {
		return nombreGestor;
	}
	/**
	 * @param nombreGestor the nombreGestor to set
	 */
	public void setNombreGestor(String nombreGestor) {
		this.nombreGestor = nombreGestor;
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
	 * @return the saldoCapital
	 */
	public Double getSaldoCapital() {
		return saldoCapital;
	}
	/**
	 * @param saldoCapital the saldoCapital to set
	 */
	public void setSaldoCapital(Double saldoCapital) {
		this.saldoCapital = saldoCapital;
	}
	/**
	 * @return the saldoInteres
	 */
	public Double getSaldoInteres() {
		return saldoInteres;
	}
	/**
	 * @param saldoInteres the saldoInteres to set
	 */
	public void setSaldoInteres(Double saldoInteres) {
		this.saldoInteres = saldoInteres;
	}
	/**
	 * @return the saldoMoratorios
	 */
	public Double getSaldoMoratorios() {
		return saldoMoratorios;
	}
	/**
	 * @param saldoMoratorios the saldoMoratorios to set
	 */
	public void setSaldoMoratorios(Double saldoMoratorios) {
		this.saldoMoratorios = saldoMoratorios;
	}
	/**
	 * @return the usuarioCaptura
	 */
	public String getUsuarioCaptura() {
		return usuarioCaptura;
	}
	/**
	 * @param usuarioCaptura the usuarioCaptura to set
	 */
	public void setUsuarioCaptura(String usuarioCaptura) {
		this.usuarioCaptura = usuarioCaptura;
	}
	/**
	 * @return the montoPagoConvenio
	 */
	public Double getMontoPagoConvenio() {
		return montoPagoConvenio;
	}
	/**
	 * @param montoPagoConvenio the montoPagoConvenio to set
	 */
	public void setMontoPagoConvenio(Double montoPagoConvenio) {
		this.montoPagoConvenio = montoPagoConvenio;
	}
	/**
	 * @return the montoBonificaConvenio
	 */
	public Double getMontoBonificaConvenio() {
		return montoBonificaConvenio;
	}
	/**
	 * @param montoBonificaConvenio the montoBonificaConvenio to set
	 */
	public void setMontoBonificaConvenio(Double montoBonificaConvenio) {
		this.montoBonificaConvenio = montoBonificaConvenio;
	}
	/**
	 * @return the montoTotalConvenio
	 */
	public Double getMontoTotalConvenio() {
		return montoTotalConvenio;
	}
	/**
	 * @param montoTotalConvenio the montoTotalConvenio to set
	 */
	public void setMontoTotalConvenio(Double montoTotalConvenio) {
		this.montoTotalConvenio = montoTotalConvenio;
	}
	/**
	 * @return the plazoConvenio
	 */
	public Integer getPlazoConvenio() {
		return plazoConvenio;
	}
	/**
	 * @param plazoConvenio the plazoConvenio to set
	 */
	public void setPlazoConvenio(Integer plazoConvenio) {
		this.plazoConvenio = plazoConvenio;
	}
	/**
	 * @return the frecuenciaConvenio
	 */
	public String getFrecuenciaConvenio() {
		return frecuenciaConvenio;
	}
	/**
	 * @param frecuenciaConvenio the frecuenciaConvenio to set
	 */
	public void setFrecuenciaConvenio(String frecuenciaConvenio) {
		this.frecuenciaConvenio = frecuenciaConvenio;
	}
	/**
	 * @return the fechaInicioConvenio
	 */
	public java.util.Date getFechaInicioConvenio() {
		return fechaInicioConvenio;
	}
	/**
	 * @param fechaInicioConvenio the fechaInicioConvenio to set
	 */
	public void setFechaInicioConvenio(java.util.Date fechaInicioConvenio) {
		this.fechaInicioConvenio = fechaInicioConvenio;
	}
	/**
	 * @return the fechaFinConvenio
	 */
	public java.util.Date getFechaFinConvenio() {
		return fechaFinConvenio;
	}
	/**
	 * @param fechaFinConvenio the fechaFinConvenio to set
	 */
	public void setFechaFinConvenio(java.util.Date fechaFinConvenio) {
		this.fechaFinConvenio = fechaFinConvenio;
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
	 * @return the pagosConvenio
	 */
	public List<PagosConvenioOV> getPagosConvenio() {
		return pagosConvenio;
	}
	/**
	 * @param pagosConvenio the pagosConvenio to set
	 */
	public void setPagosConvenio(List<PagosConvenioOV> pagosConvenio) {
		this.pagosConvenio = pagosConvenio;
	}
}
