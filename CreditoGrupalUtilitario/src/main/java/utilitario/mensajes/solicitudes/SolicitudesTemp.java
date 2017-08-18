package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SolicitudesTemp.
 *
 * @author out_ltorres
 * @version 1.0
 */
public class SolicitudesTemp extends ObjetoValor {

	/**
	 * Instancia una nueva solicitudes temp.
	 */
	public SolicitudesTemp() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2456584970701424861L;

	/** The id solicitud. */
	private String idSolicitud;

	/** The cve sucursal. */
	private Integer cveSucursal;

	/** The sucursal. */
	private String sucursal;

	/** The cdg asesor. */
	private String cdgAsesor;

	/** The producto. */
	private String producto;

	/** The codigo grupo. */
	private String codigoGrupo;

	/** The nombre grupo. */
	private String nombreGrupo;

	/** The monto solicitado. */
	private Double montoSolicitado;

	/** The fecha solicitud. */
	private String fechaSolicitud;

	/** The fecha desembolso. */
	private String fechaDesembolso;

	/** The contrato previo. */
	private String contratoPrevio;

	/** The nombre asesor. */
	private String nombreAsesor;

	/**
	 * Obtiene id solicitud.
	 *
	 * @return id solicitud
	 */
	public String getIdSolicitud() {
		return idSolicitud;
	}

	/**
	 * Establece id solicitud.
	 *
	 * @param idSolicitud a id solicitud
	 */
	public void setIdSolicitud(String idSolicitud) {
		this.idSolicitud = idSolicitud.trim();
	}

	/**
	 * Obtiene cve sucursal.
	 *
	 * @return cve sucursal
	 */
	public Integer getCveSucursal() {
		return cveSucursal;
	}

	/**
	 * Establece cve sucursal.
	 *
	 * @param cveSucursal a cve sucursal
	 */
	public void setCveSucursal(Integer cveSucursal) {
		this.cveSucursal = cveSucursal;
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
	 * Obtiene codigo grupo.
	 *
	 * @return codigo grupo
	 */
	public String getCodigoGrupo() {
		return codigoGrupo;
	}

	/**
	 * Establece codigo grupo.
	 *
	 * @param codigoGrupo a codigo grupo
	 */
	public void setCodigoGrupo(String codigoGrupo) {
		this.codigoGrupo = codigoGrupo.trim();
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
	 * Obtiene fecha desembolso.
	 *
	 * @return fecha desembolso
	 */
	public String getFechaDesembolso() {
		return fechaDesembolso;
	}

	/**
	 * Establece fecha desembolso.
	 *
	 * @param fechaDesembolso a fecha desembolso
	 */
	public void setFechaDesembolso(String fechaDesembolso) {
		this.fechaDesembolso = fechaDesembolso;
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
	 * @return the nombreAsesor
	 */
	public String getNombreAsesor() {
		return nombreAsesor;
	}

	/**
	 * @param nombreAsesor the nombreAsesor to set
	 */
	public void setNombreAsesor(String nombreAsesor) {
		this.nombreAsesor = nombreAsesor;
	}

}
