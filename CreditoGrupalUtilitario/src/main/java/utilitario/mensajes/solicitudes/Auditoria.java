package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class Auditoria.
 *
 * @author out_ltorres
 * @version 1.0
 */
public class Auditoria extends ObjetoValor {

	/**
	 * Instancia una nueva auditoria.
	 */
	public Auditoria() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1251092539345373753L;

	/** The usuario. */
	private String usuario;

	/** The sucursal. */
	private String sucursal;

	/** The operacion. */
	private String operacion;

	/** The fecha. */
	private String fecha;

	/**
	 * Obtiene usuario.
	 *
	 * @return usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Establece usuario.
	 *
	 * @param usuario a usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario.trim();
	}

	/**
	 * Obtiene sucursal.
	 *
	 * @return sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal a sucursal
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal.trim();
	}

	/**
	 * Obtiene operacion.
	 *
	 * @return operacion
	 */
	public String getOperacion() {
		return operacion;
	}

	/**
	 * Establece operacion.
	 *
	 * @param operacion a operacion
	 */
	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	/**
	 * Obtiene fecha.
	 *
	 * @return fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Establece fecha.
	 *
	 * @param fecha a fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
