package utilitario.mensajes.solicitudes;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SolicitudSACGGet.
 *
 * @author out_ltorres
 * @version 1.0
 */
public class SolicitudSACGGet extends ObjetoValor {

	/**
	 * Instancia una nueva solicitud sacg get.
	 */
	public SolicitudSACGGet() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1774175818202533572L;

	/** The id. */
	private String id; // Char

	/** The sucursal. */
	private Integer sucursal;

	/** The grupo. */
	private String grupo;

	/** The producto. */
	private String producto;

	/** The asesor. */
	private String asesor;

	/** The fecha solicitud. */
	private Date fechaSolicitud;

	/** The estatus. */
	private String estatus;

	/** The contrato. */
	private String contrato; // Char
	
	/** The numeroContrato. */
	private String numeroContrato; // Char

	/**
	 * Obtiene id.
	 *
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece id.
	 *
	 * @param id a id
	 */
	public void setId(String id) {
		this.id = id.trim();
	}

	/**
	 * Obtiene sucursal.
	 *
	 * @return sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal a sucursal
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene grupo.
	 *
	 * @return grupo
	 */
	public String getGrupo() {
		return grupo;
	}

	/**
	 * Establece grupo.
	 *
	 * @param grupo a grupo
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
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
	 * Obtiene asesor.
	 *
	 * @return asesor
	 */
	public String getAsesor() {
		return asesor;
	}

	/**
	 * Establece asesor.
	 *
	 * @param asesor a asesor
	 */
	public void setAsesor(String asesor) {
		this.asesor = asesor;
	}

	/**
	 * Obtiene fecha solicitud.
	 *
	 * @return fecha solicitud
	 */
	public Date getFechaSolicitud() {
		return fechaSolicitud;
	}

	/**
	 * Establece fecha solicitud.
	 *
	 * @param fechaSolicitud a fecha solicitud
	 */
	public void setFechaSolicitud(Date fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
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
	 * Obtiene contrato.
	 *
	 * @return contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * Establece contrato.
	 *
	 * @param contrato a contrato
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato.trim();
	}

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


}
