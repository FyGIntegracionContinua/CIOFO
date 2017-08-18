/**
 *
 */
package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultarPersonaRespuesta.
 *
 * @author rguadarrama
 */
public 	class 	ActualizarDesertorPeticion extends ObjetoValor {

	/**
	 * Instantiates a new validar solicitud peticion.
	 */
	public ActualizarDesertorPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5677000937229085332L;


	/** The numero solicitud. */
	private String solicitud;

	/** Thecliente. */
	private String cliente;

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


}
