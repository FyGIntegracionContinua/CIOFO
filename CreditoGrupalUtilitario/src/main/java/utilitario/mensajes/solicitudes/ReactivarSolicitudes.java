/**
 *
 */
package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ca.ocampo
 *
 */
public class ReactivarSolicitudes  extends ObjetoValor {

	/**
	 * Instantiates ReactivarSolicitudes
	 */
	public ReactivarSolicitudes() {
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3116370789963890514L;

	/** The solicitud. */
	private String solicitud;

	/** The grupo. */
	private String grupo;

	/** The producto. */
	private String producto;

	/** The fechaCancelacion. */
	private String fechaCancelacion;

	/** The analistaCEC. */
	private String analistaCEC;

	/** The observacion. */
	private String observacion;

	/** The comentario. */
	private String comentario;

	/** The cliente. */
	private String cliente;

	/** The motivoCancelacion. */
	private String motivoCancelacion;

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

	/**
	 * @return the grupo
	 */
	public String getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
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

	/**
	 * @return the fechaCancelacion
	 */
	public String getFechaCancelacion() {
		return fechaCancelacion;
	}

	/**
	 * @param fechaCancelacion the fechaCancelacion to set
	 */
	public void setFechaCancelacion(String fechaCancelacion) {
		this.fechaCancelacion = fechaCancelacion;
	}

	/**
	 * @return the analistaCEC
	 */
	public String getAnalistaCEC() {
		return analistaCEC;
	}

	/**
	 * @param analistaCEC the analistaCEC to set
	 */
	public void setAnalistaCEC(String analistaCEC) {
		this.analistaCEC = analistaCEC;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	/**
	 * @return the comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * @param comentario the comentario to set
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
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

}
