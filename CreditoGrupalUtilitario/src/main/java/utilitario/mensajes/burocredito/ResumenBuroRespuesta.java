package utilitario.mensajes.burocredito;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;
import utilitario.mensajes.solicitudes.InformacionContratosAnteriores;
/**
 * Clase que contiene el resumen de buro.
 * @author rmontellano
 * @versio 4.17
 */
public class ResumenBuroRespuesta extends ObjetoValor {

	/**id unico de transaccion*/
	private static final long serialVersionUID = 6071382951250269939L;

	/**cabecera*/
	private EncabezadoRespuesta header;

	/**lista de clientes*/
	private List<ResumenBuroCliente> resumenCliente;

	/**lista de contratos anreriores*/
	private List<InformacionContratosAnteriores> informacionContratosAnteriores;

	/**nombre del grupo*/
	private String nombreGrupo;

	/**nombre de la sucursal*/
	private String nombreSucursal;

	/**tipificacion de la sucursal*/
	private String tipificacionSucursal;

	/**motivo de excepcion por el que se manda el correo*/
	private String motivoExcepcion;

	/**titulo del encabezado*/
	private String tituloEncabezado;

	/**url para que realice la consulta de las solicitud en caso de no visualizarce bien*/
	private String urlConsultaDatosSolicitud;

	/**url para registrar operacion de acptar o rechazo*/
	private String urlRealiazarOperacionSolicitud;

	/**The motivoCEC*/
	private String motivoCEC;

	/**The montoCicloAnterior. */
	private String montoCicloAnterior;

	/**The montoSolicitadoAproElec. */
	private String montoSolicitadoAproElec;

	/**The buroHistorico.  */
	private String buroHistorico;

	/**The estadoCuenta.  */
	private String estadoCuenta;

	/**The urlEstadoCuenta. */
	private String urlEstadoCuenta;

	/**The urlBuroHistorico. */
	private String urlBuroHistorico;

	/**The urlIconoPdf */
	private String urlIconoPdf;

	/**The personaAutoriza. */
	private String personaAutoriza;

	/**
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}
	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}
	/**
	 * @return the resumenCliente
	 */
	public List<ResumenBuroCliente> getResumenCliente() {
		return resumenCliente;
	}
	/**
	 * @param resumenCliente the resumenCliente to set
	 */
	public void setResumenCliente(List<ResumenBuroCliente> resumenCliente) {
		this.resumenCliente = resumenCliente;
	}
	/**
	 * @return the informacionContratosAnteriores
	 */
	public List<InformacionContratosAnteriores> getInformacionContratosAnteriores() {
		return informacionContratosAnteriores;
	}
	/**
	 * @param informacionContratosAnteriores the informacionContratosAnteriores to set
	 */
	public void setInformacionContratosAnteriores(List<InformacionContratosAnteriores> informacionContratosAnteriores) {
		this.informacionContratosAnteriores = informacionContratosAnteriores;
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
	 * @return the nombreSucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}
	/**
	 * @param nombreSucursal the nombreSucursal to set
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}
	/**
	 * @return the tipificacionSucursal
	 */
	public String getTipificacionSucursal() {
		return tipificacionSucursal;
	}
	/**
	 * @param tipificacionSucursal the tipificacionSucursal to set
	 */
	public void setTipificacionSucursal(String tipificacionSucursal) {
		this.tipificacionSucursal = tipificacionSucursal;
	}
	/**
	 * @return the motivoExcepcion
	 */
	public String getMotivoExcepcion() {
		return motivoExcepcion;
	}
	/**
	 * @param motivoExcepcion the motivoExcepcion to set
	 */
	public void setMotivoExcepcion(String motivoExcepcion) {
		this.motivoExcepcion = motivoExcepcion;
	}
	/**
	 * @return the tituloEncabezado
	 */
	public String getTituloEncabezado() {
		return tituloEncabezado;
	}
	/**
	 * @param tituloEncabezado the tituloEncabezado to set
	 */
	public void setTituloEncabezado(String tituloEncabezado) {
		this.tituloEncabezado = tituloEncabezado;
	}
	/**
	 * @return the urlConsultaDatosSolicitud
	 */
	public String getUrlConsultaDatosSolicitud() {
		return urlConsultaDatosSolicitud;
	}
	/**
	 * @param urlConsultaDatosSolicitud the urlConsultaDatosSolicitud to set
	 */
	public void setUrlConsultaDatosSolicitud(String urlConsultaDatosSolicitud) {
		this.urlConsultaDatosSolicitud = urlConsultaDatosSolicitud;
	}
	/**
	 * @return the urlRealiazarOperacionSolicitud
	 */
	public String getUrlRealiazarOperacionSolicitud() {
		return urlRealiazarOperacionSolicitud;
	}
	/**
	 * @param urlRealiazarOperacionSolicitud the urlRealiazarOperacionSolicitud to set
	 */
	public void setUrlRealiazarOperacionSolicitud(String urlRealiazarOperacionSolicitud) {
		this.urlRealiazarOperacionSolicitud = urlRealiazarOperacionSolicitud;
	}
	/**
	 * @return the motivoCEC
	 */
	public String getMotivoCEC() {
		return motivoCEC;
	}
	/**
	 * @param motivoCEC the motivoCEC to set
	 */
	public void setMotivoCEC(String motivoCEC) {
		this.motivoCEC = motivoCEC;
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
	/**
	 * @return the buroHistorico
	 */
	public String getBuroHistorico() {
		return buroHistorico;
	}
	/**
	 * @param buroHistorico the buroHistorico to set
	 */
	public void setBuroHistorico(String buroHistorico) {
		this.buroHistorico = buroHistorico;
	}
	/**
	 * @return the estadoCuenta
	 */
	public String getEstadoCuenta() {
		return estadoCuenta;
	}
	/**
	 * @param estadoCuenta the estadoCuenta to set
	 */
	public void setEstadoCuenta(String estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}
	/**
	 * @return the urlEstadoCuenta
	 */
	public String getUrlEstadoCuenta() {
		return urlEstadoCuenta;
	}
	/**
	 * @param urlEstadoCuenta the urlEstadoCuenta to set
	 */
	public void setUrlEstadoCuenta(String urlEstadoCuenta) {
		this.urlEstadoCuenta = urlEstadoCuenta;
	}
	/**
	 * @return the urlBuroHistorico
	 */
	public String getUrlBuroHistorico() {
		return urlBuroHistorico;
	}
	/**
	 * @param urlBuroHistorico the urlBuroHistorico to set
	 */
	public void setUrlBuroHistorico(String urlBuroHistorico) {
		this.urlBuroHistorico = urlBuroHistorico;
	}
	/**
	 * @return the urlIconoPdf
	 */
	public String getUrlIconoPdf() {
		return urlIconoPdf;
	}
	/**
	 * @param urlIconoPdf the urlIconoPdf to set
	 */
	public void setUrlIconoPdf(String urlIconoPdf) {
		this.urlIconoPdf = urlIconoPdf;
	}
	/**
	 * @return the personaAutoriza
	 */
	public String getPersonaAutoriza() {
		return personaAutoriza;
	}
	/**
	 * @param personaAutoriza the personaAutoriza to set
	 */
	public void setPersonaAutoriza(String personaAutoriza) {
		this.personaAutoriza = personaAutoriza;
	}
}
