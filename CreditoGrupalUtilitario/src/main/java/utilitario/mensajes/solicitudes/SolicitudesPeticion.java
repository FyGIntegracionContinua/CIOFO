package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SolicitudesPeticion.
 *
 * @author out_ltorres
 */
public class SolicitudesPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva solicitudes peticion.
	 */
	public SolicitudesPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7986724622719864751L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The solicitud id. */
	private String solicitudId;

	/** The usuario id. */
	private String usuarioId;

	/** The motivo. */
	private String motivo;

	/** The motivoCancelacion. */
	private String motivoCancelacion;

	/** The solicitud. */
	private SolicitudesOV solicitud;

	/** The integrantes. */
	private List<SolicitudIntegrantesOV> integrantes;

	/** The sucursal. */
	private Integer sucursal;

	/** The producto. */
	private String producto;

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
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
	 * Obtiene solicitud id.
	 *
	 * @return solicitud id
	 */
	public String getSolicitudId() {
		return solicitudId;
	}

	/**
	 * Establece solicitud id.
	 *
	 * @param solicitudId a solicitud id
	 */
	public void setSolicitudId(String solicitudId) {
		this.solicitudId = solicitudId;
	}

	/**
	 * Obtiene usuario id.
	 *
	 * @return usuario id
	 */
	public String getUsuarioId() {
		return usuarioId;
	}

	/**
	 * Establece usuario id.
	 *
	 * @param usuarioId a usuario id
	 */
	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	/**
	 * Obtiene solicitud.
	 *
	 * @return solicitud
	 */
	public SolicitudesOV getSolicitud() {
		return solicitud;
	}

	/**
	 * Establece solicitud.
	 *
	 * @param solicitud a solicitud
	 */
	public void setSolicitud(SolicitudesOV solicitud) {
		this.solicitud = solicitud;
	}

	/**
	 * Obtiene integrantes.
	 *
	 * @return integrantes
	 */
	public List<SolicitudIntegrantesOV> getIntegrantes() {
		return integrantes;
	}

	/**
	 * Establece integrantes.
	 *
	 * @param integrantes a integrantes
	 */
	public void setIntegrantes(List<SolicitudIntegrantesOV> integrantes) {
		this.integrantes = integrantes;
	}

	/**
	 * Obtiene motivo.
	 *
	 * @return motivo
	 */
	public String getMotivo() {
		return motivo;
	}

	/**
	 * Establece motivo.
	 *
	 * @param motivo a motivo
	 */
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	/**
	 * @return the sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

}
