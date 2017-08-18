/**
 * utilitario.mensajes.operacion.ActaRecaudacionOV.java
 */
package utilitario.mensajes.operacion;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ISC Omar Cruz Carrillo (ocruzc) 21/09/2012
 * @version 1.0
 */
public class ActaRecaudacionOV extends ObjetoValor {

	/** serialVersionUID. */
	private static final long serialVersionUID = 8431522496395580744L;

	/** Clave de Finsol. */
	private java.lang.String contratoLD;
	/** N&uacute;mero de Contrato. */
	private java.lang.String  contrato;
	/** N&uacute;mero de Sucursal. */
	private java.lang.Integer sucursal;
	/** Usuario de Impresi&oacute;n. */
	private java.lang.String usuarioImprime;
	/** N&uacute;mero de Impresiones. */
	private java.lang.Integer numImprime;
	/** Fecha de Impresi&oacute;n. */
	private java.util.Date fechaImprime;
	/** Nombre del Presidente de Grupo. */
	private java.lang.String presidenteNombre;
	/** Direcci&oacute;n del Presidente. */
	private java.lang.String presidenteDireccion;
	/** Nombre del Tesorero. */
	private java.lang.String tesoreroNombre;
	/** Direcci&oacute;n del Tesorero. */
	private java.lang.String tesoreroDireccion;
	/** Nombre del Asesor. */
	private java.lang.String asesorNombre;
	/** Lista de Parcialidades {@link ActaRecaudacionParcialidadOV}. */
	private java.util.List<ActaRecaudacionParcialidadOV> parcialidades;

	//Constructor
	/**
	 * ActaRecaudacionOV
	 */
	public ActaRecaudacionOV() {
		parcialidades = new ArrayList<ActaRecaudacionParcialidadOV>();
		}

	/**
	 * M&eacute;todo que regresa el valor del miembro dato contratoLD.
	 * @return the contratoLD
	 */
	public String getContratoLD() {
		return contratoLD;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato contratoLD.
	 * @param contratoLD the contratoLD to set
	 */
	public void setContratoLD(String contratoLD) {
		this.contratoLD = contratoLD;
	}
	/**
	 * M&eacute;todo que regresa el valor del miembro dato contrato.
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato contrato.
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	/**
	 * M&eacute;todo que regresa el valor del miembro dato sucursal.
	 * @return the sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato sucursal.
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}
	/**
	 * M&eacute;todo que regresa el valor del miembro dato usuarioImprime.
	 * @return the usuarioImprime
	 */
	public String getUsuarioImprime() {
		return usuarioImprime;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato usuarioImprime.
	 * @param usuarioImprime the usuarioImprime to set
	 */
	public void setUsuarioImprime(String usuarioImprime) {
		this.usuarioImprime = usuarioImprime;
	}
	/**
	 * M&eacute;todo que regresa el valor del miembro dato numImprime.
	 * @return the numImprime
	 */
	public Integer getNumImprime() {
		return numImprime;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato numImprime.
	 * @param numImprime the numImprime to set
	 */
	public void setNumImprime(Integer numImprime) {
		this.numImprime = numImprime;
	}
	/**
	 * M&eacute;todo que regresa el valor del miembro dato fechaImprime.
	 * @return the fechaImprime
	 */
	public Date getFechaImprime() {
		return fechaImprime;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato fechaImprime.
	 * @param fechaImprime the fechaImprime to set
	 */
	public void setFechaImprime(Date fechaImprime) {
		this.fechaImprime = fechaImprime;
	}
	/**
	 * M&eacute;todo que regresa el valor del miembro dato presidenteNombre.
	 * @return the presidenteNombre
	 */
	public String getPresidenteNombre() {
		return presidenteNombre;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato presidenteNombre.
	 * @param presidenteNombre the presidenteNombre to set
	 */
	public void setPresidenteNombre(String presidenteNombre) {
		this.presidenteNombre = presidenteNombre;
	}
	/**
	 * M&eacute;todo que regresa el valor del miembro dato presidenteDireccion.
	 * @return the presidenteDireccion
	 */
	public String getPresidenteDireccion() {
		return presidenteDireccion;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato presidenteDireccion.
	 * @param presidenteDireccion the presidenteDireccion to set
	 */
	public void setPresidenteDireccion(String presidenteDireccion) {
		this.presidenteDireccion = presidenteDireccion;
	}
	/**
	 * M&eacute;todo que regresa el valor del miembro dato tesoreroNombre.
	 * @return the tesoreroNombre
	 */
	public String getTesoreroNombre() {
		return tesoreroNombre;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato tesoreroNombre.
	 * @param tesoreroNombre the tesoreroNombre to set
	 */
	public void setTesoreroNombre(String tesoreroNombre) {
		this.tesoreroNombre = tesoreroNombre;
	}
	/**
	 * M&eacute;todo que regresa el valor del miembro dato tesoreroDireccion.
	 * @return the tesoreroDireccion
	 */
	public String getTesoreroDireccion() {
		return tesoreroDireccion;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato tesoreroDireccion.
	 * @param tesoreroDireccion the tesoreroDireccion to set
	 */
	public void setTesoreroDireccion(String tesoreroDireccion) {
		this.tesoreroDireccion = tesoreroDireccion;
	}
	/**
	 * M&eacute;todo que regresa el valor del miembro dato asesorNombre.
	 * @return the asesorNombre
	 */
	public String getAsesorNombre() {
		return asesorNombre;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato asesorNombre.
	 * @param asesorNombre the asesorNombre to set
	 */
	public void setAsesorNombre(String asesorNombre) {
		this.asesorNombre = asesorNombre;
	}
	/**
	 * M&eacute;todo que regresa el valor del miembro dato parcialidades.
	 * @return the parcialidades
	 */
	public List<ActaRecaudacionParcialidadOV> getParcialidades() {
		return parcialidades;
	}
	/**
	 * M&eacute;todo que establece el valor para el miembro dato parcialidades.
	 * @param parcialidades the parcialidades to set
	 */
	public void setParcialidades(List<ActaRecaudacionParcialidadOV> parcialidades) {
		this.parcialidades = parcialidades;
	}
}
