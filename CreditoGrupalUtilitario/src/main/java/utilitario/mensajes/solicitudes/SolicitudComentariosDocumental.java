package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.ObjetoValor;

public class SolicitudComentariosDocumental extends ObjetoValor {

	/**
	 * Se genero serial.
	 */
	private static final long serialVersionUID = -567208755672147223L;

	 /**
	  * Instancia una nueva SolicitudComentariosDocumental.
	  */
	public SolicitudComentariosDocumental() {
	}

	/** The Comentarios. */
	private	List<Comentarios> comentarios;

	/**
	 * @return the comentarios
	 */
	public List<Comentarios> getComentarios() {
		return comentarios;
	}

	/**
	 * @param comentarios the comentarios to set
	 */
	public void setComentarios(List<Comentarios> comentarios) {
		this.comentarios = comentarios;
	}

}
