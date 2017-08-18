/**
 *
 */
package utilitario.mensajes.consultas;

import java.util.List;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ca.ocampo
 *
 */
public class AsistenciaOV extends ObjetoValor {

	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = -5418529628169576138L;

	/**
	 * AsistenciaOV
	 */
	public AsistenciaOV() {

	}

	/** the numero de persona. */
	private String persona;

	/** the nombre de persona. */
	private String nombre;

	/** the apellido paterno de persona. */
	private String apellidoPaterno;

	/** apellido materno de persona. */
	private String apellidoMaterno;

	/** the estatus. */
	private String estatus;

	/** the asistenciaTotal.*/
	private String asistenciaTotal;

	/** the retardoTotal.*/
	private String retardoTotal;

	/** the faltaTotal.*/
	private String faltaTotal;

	/** the feriadoTotal.*/
	private String feriadoTotal;

	/** the vacacionesTotal.*/
	private String vacacionesTotal;

	/** the permisosTotal.*/
	private String permisoTotal;

	/** the contingenciaTotal.*/
	private String contingenciaTotal;

	/** the descansoTotal.*/
	private String descansoTotal;

	/** the otrasActividadesTotal.*/
	private String otrasActividadesTotal;

	/** The DetalleAsistencia. */
	private List<DetalleAsistencia> detalle;

	/**
	 * @return the persona
	 */
	public String getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(String persona) {
		this.persona = persona;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
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
	 * @return the asistenciaTotal
	 */
	public String getAsistenciaTotal() {
		return asistenciaTotal;
	}

	/**
	 * @param asistenciaTotal the asistenciaTotal to set
	 */
	public void setAsistenciaTotal(String asistenciaTotal) {
		this.asistenciaTotal = asistenciaTotal;
	}

	/**
	 * @return the retardoTotal
	 */
	public String getRetardoTotal() {
		return retardoTotal;
	}

	/**
	 * @param retardoTotal the retardoTotal to set
	 */
	public void setRetardoTotal(String retardoTotal) {
		this.retardoTotal = retardoTotal;
	}

	/**
	 * @return the faltaTotal
	 */
	public String getFaltaTotal() {
		return faltaTotal;
	}

	/**
	 * @param faltaTotal the faltaTotal to set
	 */
	public void setFaltaTotal(String faltaTotal) {
		this.faltaTotal = faltaTotal;
	}

	/**
	 * @return the feriadoTotal
	 */
	public String getFeriadoTotal() {
		return feriadoTotal;
	}

	/**
	 * @param feriadoTotal the feriadoTotal to set
	 */
	public void setFeriadoTotal(String feriadoTotal) {
		this.feriadoTotal = feriadoTotal;
	}

	/**
	 * @return the vacacionesTotal
	 */
	public String getVacacionesTotal() {
		return vacacionesTotal;
	}

	/**
	 * @param vacacionesTotal the vacacionesTotal to set
	 */
	public void setVacacionesTotal(String vacacionesTotal) {
		this.vacacionesTotal = vacacionesTotal;
	}

	/**
	 * @return the permisoTotal
	 */
	public String getPermisoTotal() {
		return permisoTotal;
	}

	/**
	 * @param permisoTotal the permisoTotal to set
	 */
	public void setPermisoTotal(String permisoTotal) {
		this.permisoTotal = permisoTotal;
	}

	/**
	 * @return the contingenciaTotal
	 */
	public String getContingenciaTotal() {
		return contingenciaTotal;
	}

	/**
	 * @param contingenciaTotal the contingenciaTotal to set
	 */
	public void setContingenciaTotal(String contingenciaTotal) {
		this.contingenciaTotal = contingenciaTotal;
	}

	/**
	 * @return the descansoTotal
	 */
	public String getDescansoTotal() {
		return descansoTotal;
	}

	/**
	 * @param descansoTotal the descansoTotal to set
	 */
	public void setDescansoTotal(String descansoTotal) {
		this.descansoTotal = descansoTotal;
	}

	/**
	 * @return the otrasActividadesTotal
	 */
	public String getOtrasActividadesTotal() {
		return otrasActividadesTotal;
	}

	/**
	 * @param otrasActividadesTotal the otrasActividadesTotal to set
	 */
	public void setOtrasActividadesTotal(String otrasActividadesTotal) {
		this.otrasActividadesTotal = otrasActividadesTotal;
	}

	/**
	 * @return the detalle
	 */
	public List<DetalleAsistencia> getDetalle() {
		return detalle;
	}

	/**
	 * @param detalle the detalle to set
	 */
	public void setDetalle(List<DetalleAsistencia> detalle) {
		this.detalle = detalle;
	}



}
