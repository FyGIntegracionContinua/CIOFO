package utilitario.mensajes.burocredito;

import utilitario.mensajes.comun.ObjetoValor;
/**
 * clase que contiene la peticion de buro
 * @author rmontellano
 *
 */
public class ResumenBuroPeticion extends ObjetoValor {

	/**id unico de transaccion*/
	private static final long serialVersionUID = 1344932037487611861L;

	/**uid unico de transaccion*/
	private String uid;

	/**n&uacute;mero de la solicitud*/
	private String solicitud;

	/**perfil del usuario que autoriza*/
	private String perfil;

	/**n&uacute;mero de persona de quien autoriza*/
	private String usuarioAutoriza;

	/**id de la tarea que se revisa*/
	private Long idTarea;

	/**motivo de excepcion por el que se manda el correo*/
	private String motivoExcepcion;

	/**observacion de quien aprueba o rechaza el correo*/
	private String observacion;

	/**correo al que se envia la infomacion*/
	private String correo;

	/**operacion a  realizar*/
	private String operacion;

	/**descripcion de los motivos*/
	private String motivosDescripcion;

	/**The MotivoCEC.*/
	private String motivoCEC;

	/**The montoCicloAnterior. */
	private String montoCicloAnterior;

	/**The montoSolicitadoAproElec. */
	private String montoSolicitadoAproElec;

	/**The urlEstadoCuenta. */
	private String urlEstadoCuenta;

	/**The urlBuroHistorico. */
	private String urlBuroHistorico;

	/**The urlIconoPdf. */
	private String urlIconoPdf;

	/**The personaAutoriza. */
	 private String personaAutoriza;
	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
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
	/**
	 * @return the usuarioAutoriza
	 */
	public String getUsuarioAutoriza() {
		return usuarioAutoriza;
	}
	/**
	 * @param usuarioAutoriza the usuarioAutoriza to set
	 */
	public void setUsuarioAutoriza(String usuarioAutoriza) {
		this.usuarioAutoriza = usuarioAutoriza;
	}
	/**
	 * @return the idTarea
	 */
	public Long getIdTarea() {
		return idTarea;
	}
	/**
	 * @param idTarea the idTarea to set
	 */
	public void setIdTarea(Long idTarea) {
		this.idTarea = idTarea;
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
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}
	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/**
	 * @return the operacion
	 */
	public String getOperacion() {
		return operacion;
	}
	/**
	 * @param operacion the operacion to set
	 */
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}
	/**
	 * @return the motivosDescripcion
	 */
	public String getMotivosDescripcion() {
		return motivosDescripcion;
	}
	/**
	 * @param motivosDescripcion the motivosDescripcion to set
	 */
	public void setMotivosDescripcion(String motivosDescripcion) {
		this.motivosDescripcion = motivosDescripcion;
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
	/* (non-Javadoc)
	 * @see utilitario.mensajes.comun.ObjetoValor#toString()
	 */
	@Override
	public String toString() {
		return "uid: " + uid + "\tsolicitud: " + solicitud + "\tperfil: " + perfil + "\tusuarioAutoriza: "
			 + usuarioAutoriza + "\tidTarea: " + idTarea + "\tmotivoExcepcion:" + motivoExcepcion
			 + "\tobservacion:" + observacion + "\tcorreo:" + correo + "\t operacion:" + operacion
			 + "\tmotivosDescripcion:" + motivosDescripcion
			 + "\tmotivoCEC" + motivoCEC;
	}
}
