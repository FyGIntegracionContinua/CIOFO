/**
 * utilitario.mensajes.operacion.ActaRecaudacionParcialidadOV.java
 */
package utilitario.mensajes.operacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ActaRecaudacionParcialidadOV.
 *
 * @author ISC Omar Cruz Carrillo (ocruzc) 21/09/2012
 * @version 1.0
 */
public class ActaRecaudacionParcialidadOV extends ObjetoValor {

	/** serialVersionUID. */
	private static final long serialVersionUID = -2536555246173388848L;

	/** N&uacute;mero de Pago. */
	private Integer noPago;
	/** Fecha de Pago Pactada. */
	private Date fechaPactadaPago;
	/** Persona (asesor) que Recauda. */
	private String personaRecauda;
	/** Observaciones de la Reuni&oacute;n. */
	private String observaciones;
	/** Fecha de Captura. */
	private Date fechaCaptura;
	/** Usuario de Captura. */
	private String usuarioCaptura;
	/** N&uacute;mero de Actualizaci&oacute;n. */
	private Integer numeroActualizacion;
	/** Fecha de Actualizaci&oacute;n. */
	private Date fechaUltAct;
	/** Estatus de Capturas. */
	private Boolean estatus;
	/** Lista de Clientes {@link ActaRecaudacionClienteOV}. */
	private List<ActaRecaudacionClienteOV> clientes;

	/**
	 * Instancia una nueva acta recaudacion parcialidad ov.
	 */
	public ActaRecaudacionParcialidadOV() {
		clientes = new ArrayList<ActaRecaudacionClienteOV>();
		}
	/**
	 * M&eacute;todo que regresa el valor del miembro dato noPago.
	 * @return the noPago
	 */
	public Integer getNoPago() {
		return noPago;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato noPago.
	 * @param noPago the noPago to set
	 */
	public void setNoPago(Integer noPago) {
		this.noPago = noPago;
	}
	/**
	 * M&eacute;todo que regresa el valor del miembro dato fechaPactadaPago.
	 * @return the fechaPactadaPago
	 */
	public Date getFechaPactadaPago() {
		return fechaPactadaPago;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato fechaPactadaPago.
	 * @param fechaPactadaPago the fechaPactadaPago to set
	 */
	public void setFechaPactadaPago(Date fechaPactadaPago) {
		this.fechaPactadaPago = fechaPactadaPago;
	}
	/**
	 * M&eacute;todo que regresa el valor del miembro dato personaRecauda.
	 * @return the personaRecauda
	 */
	public String getPersonaRecauda() {
		return personaRecauda;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato personaRecauda.
	 * @param personaRecauda the personaRecauda to set
	 */
	public void setPersonaRecauda(String personaRecauda) {
		this.personaRecauda = personaRecauda;
	}
	/**
	 * M&eacute;todo que regresa el valor del miembro dato observaciones.
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato observaciones.
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	/**
	 * M&eacute;todo que regresa el valor del miembro dato fechaCaptura.
	 * @return the fechaCaptura
	 */
	public Date getFechaCaptura() {
		return fechaCaptura;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato fechaCaptura.
	 * @param fechaCaptura the fechaCaptura to set
	 */
	public void setFechaCaptura(Date fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}
	/**
	 * M&eacute;todo que regresa el valor del miembro dato usuarioCaptura.
	 * @return the usuarioCaptura
	 */
	public String getUsuarioCaptura() {
		return usuarioCaptura;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato usuarioCaptura.
	 * @param usuarioCaptura the usuarioCaptura to set
	 */
	public void setUsuarioCaptura(String usuarioCaptura) {
		this.usuarioCaptura = usuarioCaptura;
	}
	/**
	 * M&eacute;todo que regresa el valor del miembro dato numeroActualizacion.
	 * @return the numeroActualizacion
	 */
	public Integer getNumeroActualizacion() {
		return numeroActualizacion;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato numeroActualizacion.
	 * @param numeroActualizacion the numeroActualizacion to set
	 */
	public void setNumeroActualizacion(Integer numeroActualizacion) {
		this.numeroActualizacion = numeroActualizacion;
	}
	/**
	 * M&eacute;todo que regresa el valor del miembro dato fechaUltAct.
	 * @return the fechaUltAct
	 */
	public Date getFechaUltAct() {
		return fechaUltAct;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato fechaUltAct.
	 * @param fechaUltAct the fechaUltAct to set
	 */
	public void setFechaUltAct(Date fechaUltAct) {
		this.fechaUltAct = fechaUltAct;
	}
	/**
	 * M&eacute;todo que regresa el valor del miembro dato estatus.
	 * @return the estatus
	 */
	public Boolean getEstatus() {
		return estatus;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato estatus.
	 * @param estatus the estatus to set
	 */
	public void setEstatus(Boolean estatus) {
		this.estatus = estatus;
	}
	/**
	 * M&eacute;todo que regresa el valor del miembro dato clientes.
	 * @return the clientes
	 */
	public List<ActaRecaudacionClienteOV> getClientes() {
		return clientes;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato clientes.
	 * @param clientes the clientes to set
	 */
	public void setClientes(List<ActaRecaudacionClienteOV> clientes) {
		this.clientes = clientes;
	}
}
