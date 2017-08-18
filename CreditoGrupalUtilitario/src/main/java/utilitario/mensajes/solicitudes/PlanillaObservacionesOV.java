package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class PlanillaObservacionesOV.
 *
 * @author rguadarramac
 * @version 1.0
 */
public class PlanillaObservacionesOV extends ObjetoValor {

	/**
	 * Instancia una nueva planilla observaciones ov.
	 */
	public PlanillaObservacionesOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5545559313223431089L;

	/** The solicitud. */
	private String solicitud;

	/** The campo id. */
	private Integer campoId;

	/** The seccion. */
	private String seccion;

	/** The desc seccion. */
	private String descSeccion;

	/** The descripcion. */
	private String descripcion;

	/** The producto. */
	private String producto;

	/** The binario. */
	private String binario;

	/** The comentarios. */
	private String comentarios;

	/** The valor binario. */
	private String valorBinario;

	/** The valor comentario. */
	private String valorComentario;

	/** The nuevo campo id. */
	private Integer nuevoCampoID;

	/** The nuevo campo consultaCanceladas. */
	private boolean consultaCanceladas;

	/** The nuevo campo consultaMarcadas. */
	private boolean consultaMarcadas;

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
		this.solicitud = solicitud;
	}

	/**
	 * Obtiene campo id.
	 *
	 * @return campo id
	 */
	public Integer getCampoId() {
		return campoId;
	}

	/**
	 * Establece campo id.
	 *
	 * @param campoId a campo id
	 */
	public void setCampoId(Integer campoId) {
		this.campoId = campoId;
	}

	/**
	 * Obtiene seccion.
	 *
	 * @return seccion
	 */
	public String getSeccion() {
		return seccion;
	}

	/**
	 * Establece seccion.
	 *
	 * @param seccion a seccion
	 */
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}

	/**
	 * Obtiene desc seccion.
	 *
	 * @return desc seccion
	 */
	public String getDescSeccion() {
		return descSeccion;
	}

	/**
	 * Establece desc seccion.
	 *
	 * @param descSeccion a desc seccion
	 */
	public void setDescSeccion(String descSeccion) {
		this.descSeccion = descSeccion;
	}

	/**
	 * Obtiene descripcion.
	 *
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece descripcion.
	 *
	 * @param descripcion a descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	 * Obtiene binario.
	 *
	 * @return binario
	 */
	public String getBinario() {
		return binario;
	}

	/**
	 * Establece binario.
	 *
	 * @param binario a binario
	 */
	public void setBinario(String binario) {
		this.binario = binario;
	}

	/**
	 * Obtiene comentarios.
	 *
	 * @return comentarios
	 */
	public String getComentarios() {
		return comentarios;
	}

	/**
	 * Establece comentarios.
	 *
	 * @param comentarios a comentarios
	 */
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	/**
	 * Obtiene valor binario.
	 *
	 * @return valor binario
	 */
	public String getValorBinario() {
		return valorBinario;
	}

	/**
	 * Establece valor binario.
	 *
	 * @param valorBinario a valor binario
	 */
	public void setValorBinario(String valorBinario) {
		this.valorBinario = valorBinario;
	}

	/**
	 * Obtiene valor comentario.
	 *
	 * @return valor comentario
	 */
	public String getValorComentario() {
		return valorComentario;
	}

	/**
	 * Establece valor comentario.
	 *
	 * @param valorComentario a valor comentario
	 */
	public void setValorComentario(String valorComentario) {
		this.valorComentario = valorComentario;
	}

	/**
	 * Establece nuevo campo id.
	 *
	 * @param nuevoCampoID a nuevo campo id
	 */
	public void setNuevoCampoID(Integer nuevoCampoID) {
		this.nuevoCampoID = nuevoCampoID;
	}

	/**
	 * Obtiene nuevo campo id.
	 *
	 * @return nuevo campo id
	 */
	public Integer getNuevoCampoID() {
		return nuevoCampoID;
	}

	/**
	 * @return the consultaCanceladas
	 */
	public boolean isConsultaCanceladas() {
		return consultaCanceladas;
	}

	/**
	 * @param consultaCanceladas the consultaCanceladas to set
	 */
	public void setConsultaCanceladas(boolean consultaCanceladas) {
		this.consultaCanceladas = consultaCanceladas;
	}

	/**
	 * @return the consultaMarcadas
	 */
	public boolean isConsultaMarcadas() {
		return consultaMarcadas;
	}

	/**
	 * @param consultaMarcadas the consultaMarcadas to set
	 */
	public void setConsultaMarcadas(boolean consultaMarcadas) {
		this.consultaMarcadas = consultaMarcadas;
	}


}
