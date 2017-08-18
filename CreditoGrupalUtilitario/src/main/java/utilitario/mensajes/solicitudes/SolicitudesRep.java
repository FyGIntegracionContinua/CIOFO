package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SolicitudesRep.
 *
 * @author out_ltorres
 * @version 1.0
 */
public class SolicitudesRep extends ObjetoValor {

	/**
	 * Instancia una nueva solicitudes rep.
	 */
	public SolicitudesRep() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4320280692278932110L;

	/** The solicitud. */
	private String solicitud;

	/** The no grupo. */
	private String noGrupo;

	/** The nombre grupo. */
	private String nombreGrupo;

	/** The ciclo. */
	private Integer ciclo;

	/** The no integrantes. */
	private Integer noIntegrantes;

	/** The sucursal. */
	private String sucursal;

	/** The producto. */
	private String producto;

	/** The ld. */
	private String LD;

	/** The fecha solicitud. */
	private String fechaSolicitud;

	/** The monto solicitado. */
	private Double montoSolicitado;

	/** The monto aprobado. */
	private Double montoAprobado;

	/** The estatus. */
	private String estatus;

	/** The sistema. */
	private String sistema;

	/** The contrato. */
	private String contrato;

	/**
	 * Obtiene solicitud.
	 *
	 * @return solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}

	/**
	 * Establece solicitud.
	 *
	 * @param solicitud a solicitud
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud.trim();
	}

	/**
	 * Obtiene no grupo.
	 *
	 * @return no grupo
	 */
	public String getNoGrupo() {
		return noGrupo;
	}

	/**
	 * Establece no grupo.
	 *
	 * @param noGrupo a no grupo
	 */
	public void setNoGrupo(String noGrupo) {
		this.noGrupo = noGrupo.trim();
	}

	/**
	 * Obtiene nombre grupo.
	 *
	 * @return nombre grupo
	 */
	public String getNombreGrupo() {
		return nombreGrupo;
	}

	/**
	 * Establece nombre grupo.
	 *
	 * @param nombreGrupo a nombre grupo
	 */
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
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
	 * Obtiene no integrantes.
	 *
	 * @return no integrantes
	 */
	public Integer getNoIntegrantes() {
		return noIntegrantes;
	}

	/**
	 * Establece no integrantes.
	 *
	 * @param noIntegrantes a no integrantes
	 */
	public void setNoIntegrantes(Integer noIntegrantes) {
		this.noIntegrantes = noIntegrantes;
	}

	/**
	 * Obtiene sucursal.
	 *
	 * @return sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal a sucursal
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal.trim();
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
	 * Obtiene ld.
	 *
	 * @return ld
	 */
	public String getLD() {
		return LD;
	}

	/**
	 * Establece ld.
	 *
	 * @param lD a ld
	 */
	public void setLD(String lD) {
		LD = lD.trim();
	}

	/**
	 * Obtiene fecha solicitud.
	 *
	 * @return fecha solicitud
	 */
	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	/**
	 * Establece fecha solicitud.
	 *
	 * @param fechaSolicitud a fecha solicitud
	 */
	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	/**
	 * Obtiene monto solicitado.
	 *
	 * @return monto solicitado
	 */
	public Double getMontoSolicitado() {
		return montoSolicitado;
	}

	/**
	 * Establece monto solicitado.
	 *
	 * @param montoSolicitado a monto solicitado
	 */
	public void setMontoSolicitado(Double montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}

	/**
	 * Obtiene monto aprobado.
	 *
	 * @return monto aprobado
	 */
	public Double getMontoAprobado() {
		return montoAprobado;
	}

	/**
	 * Establece monto aprobado.
	 *
	 * @param montoAprobado a monto aprobado
	 */
	public void setMontoAprobado(Double montoAprobado) {
		this.montoAprobado = montoAprobado;
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
	 * Obtiene sistema.
	 *
	 * @return sistema
	 */
	public String getSistema() {
		return sistema;
	}

	/**
	 * Establece sistema.
	 *
	 * @param sistema a sistema
	 */
	public void setSistema(String sistema) {
		this.sistema = sistema;
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

}
