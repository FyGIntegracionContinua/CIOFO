/**
 * 
 */
package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author lsotos
 *
 */
public class ExcepcionMontoCupoOV extends ObjetoValor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6636807097612112351L;
	
	/**
	 * nombre del grupo
	 */	
	private String nombreGrupo;
	
	/**
	 * número de la solictud
	 */
	private String solicitud;
	
	/**
	 * número de la tarea
	 */
	private Integer idExcepcion;
	
	/**
	 *  grupos permitidos con campaña
	 */
	private Integer cuposPermitidos;
	
	/**
	 *  monto de los grupos con campaña
	 */
	private Double montoPermitido;
	
	/**
	 * nombre de la sucursal
	 */
	private String nombreSucursal;
	
	/**
	 *  ciclo del grupo
	 */
	private Integer ciclo;
	
	/**
	 *  nombre de la region
	 */
	private String nombreRegion;
	
	/**
	 * monto solicitado del grupo
	 */
	private Double montoSolicitado;
	
	/**
	 * número de integrantes en la solicitud
	 */
	private Integer integrantes;
	
	/**
	 * tasa de la solicitud
	 */
	private Double tasa;
	
	/**
	 * asesor
	 */
	private String asesor;
	
	/**
	 * justificación para generar la excepción
	 */
	private String justificacionExcepcion;
	
	/**
	 * 
	 */
	private String observaciones;
	
	/**
	 * grupos que van en el mes con campaña
	 */
	private Integer cupoMes;
	
	/**
	 * monto que va en el mes de grupos con campaña
	 */
	private Double montoMes;

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
	 * @return the idExcepcion
	 */
	public Integer getIdExcepcion() {
		return idExcepcion;
	}

	/**
	 * @param idExcepcion the idExcepcion to set
	 */
	public void setIdExcepcion(Integer idExcepcion) {
		this.idExcepcion = idExcepcion;
	}

	/**
	 * @return the cuposPermitidos
	 */
	public Integer getCuposPermitidos() {
		return cuposPermitidos;
	}

	/**
	 * @param cuposPermitidos the cuposPermitidos to set
	 */
	public void setCuposPermitidos(Integer cuposPermitidos) {
		this.cuposPermitidos = cuposPermitidos;
	}

	/**
	 * @return the montoPermitido
	 */
	public Double getMontoPermitido() {
		return montoPermitido;
	}

	/**
	 * @param montoPermitido the montoPermitido to set
	 */
	public void setMontoPermitido(Double montoPermitido) {
		this.montoPermitido = montoPermitido;
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
	 * @return the nombreRegion
	 */
	public String getNombreRegion() {
		return nombreRegion;
	}

	/**
	 * @param nombreRegion the nombreRegion to set
	 */
	public void setNombreRegion(String nombreRegion) {
		this.nombreRegion = nombreRegion;
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
	 * @return the integrantes
	 */
	public Integer getIntegrantes() {
		return integrantes;
	}

	/**
	 * @param integrantes the integrantes to set
	 */
	public void setIntegrantes(Integer integrantes) {
		this.integrantes = integrantes;
	}

	/**
	 * @return the tasa
	 */
	public Double getTasa() {
		return tasa;
	}

	/**
	 * @param tasa the tasa to set
	 */
	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}

	/**
	 * @return the asesor
	 */
	public String getAsesor() {
		return asesor;
	}

	/**
	 * @param asesor the asesor to set
	 */
	public void setAsesor(String asesor) {
		this.asesor = asesor;
	}

	/**
	 * @return the justificacionExcepcion
	 */
	public String getJustificacionExcepcion() {
		return justificacionExcepcion;
	}

	/**
	 * @param justificacionExcepcion the justificacionExcepcion to set
	 */
	public void setJustificacionExcepcion(String justificacionExcepcion) {
		this.justificacionExcepcion = justificacionExcepcion;
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
	 * @return the cupoMes
	 */
	public Integer getCupoMes() {
		return cupoMes;
	}

	/**
	 * @param cupoMes the cupoMes to set
	 */
	public void setCupoMes(Integer cupoMes) {
		this.cupoMes = cupoMes;
	}

	/**
	 * @return the montoMes
	 */
	public Double getMontoMes() {
		return montoMes;
	}

	/**
	 * @param montoMes the montoMes to set
	 */
	public void setMontoMes(Double montoMes) {
		this.montoMes = montoMes;
	}

}
