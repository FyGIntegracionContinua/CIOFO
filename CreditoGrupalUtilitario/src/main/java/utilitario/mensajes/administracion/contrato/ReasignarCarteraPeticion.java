package utilitario.mensajes.administracion.contrato;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ReasignarCarteraPeticion.
 *
 * @author out_mreyes
 */
public	class 	ReasignarCarteraPeticion
		extends ObjetoValor	{

	/** UID para la serializacion del objeto. */
	private static final long serialVersionUID = -3865081461038783371L;

	// Atributos de la clase  ---------------------------------------------------------------
	/** The header. */
	private EncabezadoPeticion					header;

	/** The folio solicitud. */
	private java.lang.Integer					folioSolicitud;

	/** The cve red operativa nvo. */
	private java.lang.String					cveRedOperativaNvo;

	/** The usuario. */
	private java.lang.String					usuario;

	/** The sucursal nueva. */
	private java.lang.Integer					sucursalNueva;

	/** The contratos. */
	private java.util.List<ReasignarCarteraOV>  contratos;

	// Constructor  -------------------------------------------------------------------------
	/**
	 * Instancia una nueva reasignar cartera peticion.
	 */
	public ReasignarCarteraPeticion() {
		header = new EncabezadoPeticion();
		}

	// Metodos  -----------------------------------------------------------------------------
	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}

	/**
	 * Obtiene cve red operativa nvo.
	 *
	 * @return the cveRedOperativaNvo
	 */
	public java.lang.String getCveRedOperativaNvo() {
		return cveRedOperativaNvo;
	}

	/**
	 * Establece cve red operativa nvo.
	 *
	 * @param cveRedOperativaNvo the cveRedOperativaNvo to set
	 */
	public void setCveRedOperativaNvo(java.lang.String cveRedOperativaNvo) {
		this.cveRedOperativaNvo = cveRedOperativaNvo;
	}

	/**
	 * Obtiene usuario.
	 *
	 * @return the usuario
	 */
	public java.lang.String getUsuario() {
		return usuario;
	}

	/**
	 * Establece usuario.
	 *
	 * @param usuario the usuario to set
	 */
	public void setUsuario(java.lang.String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Obtiene contratos.
	 *
	 * @return the contratos
	 */
	public java.util.List<ReasignarCarteraOV> getContratos() {
		return contratos;
	}

	/**
	 * Establece contratos.
	 *
	 * @param contratos the contratos to set
	 */
	public void setContratos(java.util.List<ReasignarCarteraOV> contratos) {
		this.contratos = contratos;
	}

	/**
	 * Obtiene sucursal nueva.
	 *
	 * @return the sucursalNueva
	 */
	public java.lang.Integer getSucursalNueva() {
		return sucursalNueva;
	}

	/**
	 * Establece sucursal nueva.
	 *
	 * @param sucursalNueva the sucursalNueva to set
	 */
	public void setSucursalNueva(java.lang.Integer sucursalNueva) {
		this.sucursalNueva = sucursalNueva;
	}

	/**
	 * Obtiene folio solicitud.
	 *
	 * @return the folioSolicitud
	 */
	public java.lang.Integer getFolioSolicitud() {
		return folioSolicitud;
	}

	/**
	 * Establece folio solicitud.
	 *
	 * @param folioSolicitud the folioSolicitud to set
	 */
	public void setFolioSolicitud(java.lang.Integer folioSolicitud) {
		this.folioSolicitud = folioSolicitud;
	}

}
