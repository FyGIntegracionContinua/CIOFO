/**
 *
 */
package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ca.ocampo
 *
 */
public class ReactivarSolicitudesPeticion extends ObjetoValor {

	/**
	 * Instantiates a new validar solicitud peticion.
	 */
	public ReactivarSolicitudesPeticion() {
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -9147554141416148985L;

	/** The sucursal. */
	private String sucursal;

	/** The usuario. */
	private String usuario;

	/** the accion.  */
	private String accion;

	/** the solicitud. */
	private String solicitud;

	/**
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the accion
	 */
	public String getAccion() {
		return accion;
	}

	/**
	 * @param accion the accion to set
	 */
	public void setAccion(String accion) {
		this.accion = accion;
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


}

