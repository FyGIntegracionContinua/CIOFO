package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class CodigoOV.
 *
 * @author out_gcorzo
 * @version 1.0
 */
public class CodigoOV extends ObjetoValor {

	/**
	 * Instancia un nuevo codigo ov.
	 */
	public CodigoOV() {
	}
	/** Se genero serial. */
	private static final long serialVersionUID = 31905069059425868L;

	/** The tipoCodigo. */
	private String tipoCodigo;

	/** The codigo. */
	private String codigo;

	/** The descripcion. */
	private String descripcion;

	/** The status. */
	private String status;

	/**
	 * @return the tipoCodigo
	 */
	public String getTipoCodigo() {
		return tipoCodigo;
	}

	/**
	 * @param tipoCodigo the tipoCodigo to set
	 */
	public void setTipoCodigo(String tipoCodigo) {
		this.tipoCodigo = tipoCodigo;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}
