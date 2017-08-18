package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SolicitudesTempPeticion.
 *
 * @author out_ltorres
 */
public class SolicitudesTempPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva solicitudes temp peticion.
	 */
	public SolicitudesTempPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2886990801913653116L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The p sucursal. */
	private String pSucursal;

	/** The p nombre grupo. */
	private String pNombreGrupo;

	/** The solicitud. */
	private String solicitud;

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
	 * Obtiene p sucursal.
	 *
	 * @return p sucursal
	 */
	public String getpSucursal() {
		return pSucursal;
	}

	/**
	 * Establece p sucursal.
	 *
	 * @param pSucursal a p sucursal
	 */
	public void setpSucursal(String pSucursal) {
		this.pSucursal = pSucursal;
	}

	/**
	 * Obtiene p nombre grupo.
	 *
	 * @return p nombre grupo
	 */
	public String getpNombreGrupo() {
		return pNombreGrupo;
	}

	/**
	 * Establece p nombre grupo.
	 *
	 * @param pNombreGrupo a p nombre grupo
	 */
	public void setpNombreGrupo(String pNombreGrupo) {
		this.pNombreGrupo = pNombreGrupo;
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

}
