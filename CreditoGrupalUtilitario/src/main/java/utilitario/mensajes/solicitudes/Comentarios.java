package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

public class Comentarios  extends ObjetoValor {

	/**
	 * Se genero serial.
	 */
	private static final long serialVersionUID = -7888994987120662386L;

	/**
	  * Instancia una nueva Comentarios.
	  */
	public Comentarios() {
	}

	/** The solicitud. */
	private String solicitud;

	/** The cliente. */
	private String cliente;

	/** The status. */
	private String status;

	/** The origenElimina. */
	private String origenElimina;

	/** The usuarioElimina. */
	private String usuarioElimina;

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

	/**
	 * @return the origenElimina
	 */
	public String getOrigenElimina() {
		return origenElimina;
	}

	/**
	 * @param origenElimina the origenElimina to set
	 */
	public void setOrigenElimina(String origenElimina) {
		this.origenElimina = origenElimina;
	}

	/**
	 * @return the usuarioElimina
	 */
	public String getUsuarioElimina() {
		return usuarioElimina;
	}

	/**
	 * @param usuarioElimina the usuarioElimina to set
	 */
	public void setUsuarioElimina(String usuarioElimina) {
		this.usuarioElimina = usuarioElimina;
	}

}

