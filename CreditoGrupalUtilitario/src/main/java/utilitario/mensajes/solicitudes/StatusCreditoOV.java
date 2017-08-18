package utilitario.mensajes.solicitudes;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class StatusCreditoOV.
 *
 * @author rguadarramac
 * @version 1.0
 */
public class StatusCreditoOV extends ObjetoValor {

	/**
	 * Instantiates a new status credito ov.
	 */
	public StatusCreditoOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -810147433747092963L;

	/** The estatus. */
	private String estatus;

	/** The nombre grupo. */
	private String nombreGrupo;

	/** The contrato ld. */
	private String contratoLD;

	/** The contrato ld. */
	private String contrato;

	/** The codigo producto. */
	private String codigoProducto;

	/** The descripcion. */
	private String descripcion;

	/** The asesor. */
	private String asesor;

	/** The nombre asesor. */
	private String nombreAsesor;

	/** The solicitud. */
	private String solicitud;

	/** The sucursal. */
	private Integer sucursal;

	/** The fecha captura. */
	private Date fechaCaptura;

	/** The fecha fin. */
	private Date fechaFin;

	/** The region. */
	private Integer region;

	/** The division. */
	private Integer division;

	/** The subEstatus. */
	private String subEstatus;

	/** The express. */
	private String express;

	/** The categoría. */
	private String categoria;

	/** The tipificacionProducto. */
	private String tipificacionProducto;

	/**Motivo de cancelación de la solicitud. */
	private String motivoCancelacion;

	/**motivoJustificacion de la solicitud. */
	private String motivoJustificacion;

	/**campana de la solicitud. */
	private String campana;


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
	 * Gets the nombre grupo.
	 *
	 * @return the nombre grupo
	 */
	public String getNombreGrupo() {
		return nombreGrupo;
	}

	/**
	 * Sets the nombre grupo.
	 *
	 * @param nombreGrupo the new nombre grupo
	 */
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	/**
	 * Gets the solicitud.
	 *
	 * @return the solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}

	/**
	 * Sets the solicitud.
	 *
	 * @param solicitud the new solicitud
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	/**
	 * Gets the codigo producto.
	 *
	 * @return the codigo producto
	 */
	public String getCodigoProducto() {
		return codigoProducto;
	}

	/**
	 * Sets the codigo producto.
	 *
	 * @param codigoProducto the new codigo producto
	 */
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	/**
	 * Gets the descripcion.
	 *
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Sets the descripcion.
	 *
	 * @param descripcion the new descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Gets the asesor.
	 *
	 * @return the asesor
	 */
	public String getAsesor() {
		return asesor;
	}

	/**
	 * Sets the asesor.
	 *
	 * @param asesor the new asesor
	 */
	public void setAsesor(String asesor) {
		this.asesor = asesor;
	}

	/**
	 * Gets the sucursal.
	 *
	 * @return the sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Sets the sucursal.
	 *
	 * @param sucursal the new sucursal
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Sets the nombre asesor.
	 *
	 * @param nombreAsesor the new nombre asesor
	 */
	public void setNombreAsesor(String nombreAsesor) {
		this.nombreAsesor = nombreAsesor;
	}

	/**
	 * Gets the nombre asesor.
	 *
	 * @return the nombre asesor
	 */
	public String getNombreAsesor() {
		return nombreAsesor;
	}

	/**
	 * Sets the contrato ld.
	 *
	 * @param contratoLD the new contrato ld
	 */
	public void setContratoLD(String contratoLD) {
		this.contratoLD = contratoLD;
	}

	/**
	 * Gets the contrato ld.
	 *
	 * @return the contrato ld
	 */
	public String getContratoLD() {
		return contratoLD;
	}

	/**
	 * Sets the region.
	 *
	 * @param region the new region
	 */
	public void setRegion(Integer region) {
		this.region = region;
	}

	/**
	 * Gets the region.
	 *
	 * @return the region
	 */
	public Integer getRegion() {
		return region;
	}

	/**
	 * Sets the division.
	 *
	 * @param division the new division
	 */
	public void setDivision(Integer division) {
		this.division = division;
	}

	/**
	 * Gets the division.
	 *
	 * @return the division
	 */
	public Integer getDivision() {
		return division;
	}

	/**
	 * Gets the fecha captura.
	 *
	 * @return the fecha captura
	 */
	public Date getFechaCaptura() {
		return fechaCaptura;
	}

	/**
	 * Sets the fecha captura.
	 *
	 * @param fechaCaptura the new fecha captura
	 */
	public void setFechaCaptura(Date fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}

	/**
	 * Gets the fecha fin.
	 *
	 * @return the fecha fin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * Sets the fecha fin.
	 *
	 * @param fechaFin the new fecha fin
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the subEstatus
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
	 * @return the express
	 */
	public String getExpress() {
		return express;
	}

	/**
	 * @param express the express to set
	 */
	public void setExpress(String express) {
		this.express = express;
	}

	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the tipificacionProducto
	 */
	public String getTipificacionProducto() {
		return tipificacionProducto;
	}

	/**
	 * @param tipificacionProducto the tipificacionProducto to set
	 */
	public void setTipificacionProducto(String tipificacionProducto) {
		this.tipificacionProducto = tipificacionProducto;
	}

	/**
	 * @return the motivoCancelacion
	 */
	public String getMotivoCancelacion() {
		return motivoCancelacion;
	}

	/**
	 * @param motivoCancelacion the motivoCancelacion to set
	 */
	public void setMotivoCancelacion(String motivoCancelacion) {
		this.motivoCancelacion = motivoCancelacion;
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
	
	/**
	 * @return the motivoJustificacion
	 */
	public String getMotivoJustificacion() {
		return motivoJustificacion;
	}

	/**
	 * @param motivoJustificacion the motivoJustificacion to set
	 */
	public void setMotivoJustificacion(String motivoJustificacion) {
		this.motivoJustificacion = motivoJustificacion;
	}

	/**
	 * @return the campana
	 */
	public String getCampana() {
		return campana;
	}

	/**
	 * @param campana the campana to set
	 */
	public void setCampana(String campana) {
		this.campana = campana;
	}
}
