package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class DatosImagenesMonitorOV.
 *
 * @author gcorzo
 */
public class DatosImagenesMonitorOV extends ObjetoValor {

	/**
	 * Instancia una nueva datos imagenes monitor ov.
	 */
	public DatosImagenesMonitorOV() {
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2420073756128515569L;

	/** The idImagen. */
	private String idImagen;

	/** The solicitud. */
	private String solicitud;

	/** The imagen. */
	private String imagen;

	/** The fechaAlta. */
	private String fechaAlta;

	/** The diferencia. */
	private String diferencia;

	/** The sucursal. */
	private String sucursal;

	/** The nombreSucursal. */
	private String nombreSucursal;

	/** The asignacionCec. */
	private String asignacionCec;

	/** The fechaUltimoIntento. */
	private String fechaUltimoIntento;

	/** The descripcionCodigo. */
	private String descripcionCodigo;

	/**
	 * Obtiene sucursal.
	 *
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene idImagen.
	 *
	 * @return the idImagen
	 */
	public String getIdImagen() {
		return idImagen;
	}

	/**
	 * Establece idImagen.
	 *
	 * @param idImagen the idImagen to set
	 */
	public void setIdImagen(String idImagen) {
		this.idImagen = idImagen;
	}

	/**
	 * Obtiene solicitud.
	 *
	 * @return the solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}

	/**
	 * Establece solicitud.
	 *
	 * @param solicitud the solicitud to set
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	/**
	 * Obtiene urlImagen.
	 *
	 * @return the urlImagen
	 */
	public String getImagen() {
		return imagen;
	}

	/**
	 * Establece imagen.
	 *
	 * @param imagen the imagen to set
	 */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/**
	 * Obtiene fechaAlta.
	 *
	 * @return the fechaAlta
	 */
	public String getFechaAlta() {
		return fechaAlta;
	}

	/**
	 * Establece fechaAlta.
	 *
	 * @param fechaAlta the fechaAlta to set
	 */
	public void setFechaAlta(String fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	/**
	 * Obtiene diferencia.
	 *
	 * @return the diferencia
	 */
	public String getDiferencia() {
		return diferencia;
	}

	/**
	 * Establece diferencia.
	 *
	 * @param diferencia the diferencia to set
	 */
	public void setDiferencia(String diferencia) {
		this.diferencia = diferencia;
	}

	/**
	 * Obtiene nombreSucursal.
	 *
	 * @return the nombreSucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}

	/**
	 * Establece nombreSucursal.
	 *
	 * @param nombreSucursal the nombreSucursal to set
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	/**
	 * Obtiene asignacionCec.
	 *
	 * @return the asignacionCec
	 */
	public String getAsignacionCec() {
		return asignacionCec;
	}

	/**
	 * Establece asignacionCec.
	 *
	 * @param asignacionCec the asignacionCec to set
	 */
	public void setAsignacionCec(String asignacionCec) {
		this.asignacionCec = asignacionCec;
	}

	/**
	 * Obtiene fechaUltimoIntento.
	 *
	 * @return the fechaUltimoIntento
	 */
	public String getFechaUltimoIntento() {
		return fechaUltimoIntento;
	}

	/**
	 * Establece fechaUltimoIntento.
	 *
	 * @param fechaUltimoIntento the fechaUltimoIntento to set
	 */
	public void setFechaUltimoIntento(String fechaUltimoIntento) {
		this.fechaUltimoIntento = fechaUltimoIntento;
	}

	/**
	 * Obtiene descripcionCodigo.
	 *
	 * @return the descripcionCodigo
	 */
	public String getDescripcionCodigo() {
		return descripcionCodigo;
	}

	/**
	 * Establece descripcionCodigo.
	 *
	 * @param descripcionCodigo the descripcionCodigo to set
	 */
	public void setDescripcionCodigo(String descripcionCodigo) {
		this.descripcionCodigo = descripcionCodigo;
	}

}
