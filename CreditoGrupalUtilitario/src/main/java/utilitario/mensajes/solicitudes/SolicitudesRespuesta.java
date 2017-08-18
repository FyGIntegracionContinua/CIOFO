package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SolicitudesRespuesta.
 */
public class SolicitudesRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva solicitudes respuesta.
	 */
	public SolicitudesRespuesta() {
	}
	/** Se genero nuevo serial. */
	private static final long serialVersionUID = 4771230139176220692L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The solicitud. */
	private SolicitudesOV solicitud;

	/** The integrantes. */
	private List<SolicitudIntegrantesOV> integrantes;

	/** The id. */
	private String id;
	
	/** activar pop up si se lanza una excepcion de cupos o montos.*/
	private boolean excepcionCupoMonto;

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene solicitud.
	 *
	 * @return solicitud
	 */
	public SolicitudesOV getSolicitud() {
		return solicitud;
	}

	/**
	 * Establece solicitud.
	 *
	 * @param solicitud a solicitud
	 */
	public void setSolicitud(SolicitudesOV solicitud) {
		this.solicitud = solicitud;
	}

	/**
	 * Obtiene integrantes.
	 *
	 * @return integrantes
	 */
	public List<SolicitudIntegrantesOV> getIntegrantes() {
		return integrantes;
	}

	/**
	 * Establece integrantes.
	 *
	 * @param integrantes a integrantes
	 */
	public void setIntegrantes(List<SolicitudIntegrantesOV> integrantes) {
		this.integrantes = integrantes;
	}

	/**
	 * Obtiene id.
	 *
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Establece id.
	 *
	 * @param id a id
	 */
	public void setId(String id) {
		this.id = id.trim();
	}
	
	/**
	 * @return the excepcionCupoMonto
	 */
	public boolean isExcepcionCupoMonto() {
		return excepcionCupoMonto;
	}

	/**
	 * @param excepcionCupoMonto the excepcionCupoMonto to set
	 */
	public void setExcepcionCupoMonto(boolean excepcionCupoMonto) {
		this.excepcionCupoMonto = excepcionCupoMonto;
	}

}
