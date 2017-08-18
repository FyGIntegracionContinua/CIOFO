package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;
import utilitario.reglas.solicitudes.RespuestaReglaIncremento;

/**
 * The Class ConsultaSolicitudBuroRespuesta.
 *
 * @author rguadarramac
 *
 */
public class ConsultaSolicitudBuroRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva consulta solicitud buro respuesta.
	 */
	public ConsultaSolicitudBuroRespuesta() {
	}
	/** Se genero nuevo serial. */
	private static final long serialVersionUID = 4771230139176220692L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The solicitudes buro. */
	private SolicitudBuroOV solicitudesBuro;

	/**
	 * incrementos
	 */
	private List<RespuestaReglaIncremento> incrementos;

	/**
	 * incrementos
	 */
	private RespuestaReglaIncremento respuestaIncremento;

	/** The integrantes a descartar y a eleminar. */
	private List<SolicitudBuroClienteOV> integrantes;

	/**validacion  de buro*/
	private boolean validacionBC;

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
	 * Obtiene solicitudes buro.
	 *
	 * @return the solicitudesBuro
	 */
	public SolicitudBuroOV getSolicitudesBuro() {
		return solicitudesBuro;
	}

	/**
	 * Establece solicitudes buro.
	 *
	 * @param solicitudesBuro the solicitudesBuro to set
	 */
	public void setSolicitudesBuro(SolicitudBuroOV solicitudesBuro) {
		this.solicitudesBuro = solicitudesBuro;
	}

	/**
	 * @return the incrementos
	 */
	public List<RespuestaReglaIncremento> getIncrementos() {
		return incrementos;
	}

	/**
	 * @param incrementos the incrementos to set
	 */
	public void setIncrementos(List<RespuestaReglaIncremento> incrementos) {
		this.incrementos = incrementos;
	}

	/**
	 * @return the respuestaIncremento
	 */
	public RespuestaReglaIncremento getRespuestaIncremento() {
		return respuestaIncremento;
	}

	/**
	 * @param respuestaIncremento the respuestaIncremento to set
	 */
	public void setRespuestaIncremento(RespuestaReglaIncremento respuestaIncremento) {
		this.respuestaIncremento = respuestaIncremento;
	}

	/**
	 * @return the validacionBC
	 */
	public boolean isValidacionBC() {
		return validacionBC;
	}

	/**
	 * @param validacionBC the validacionBC to set
	 */
	public void setValidacionBC(boolean validacionBC) {
		this.validacionBC = validacionBC;
	}

	/**
	 * @return the integrantes
	 */
	public List<SolicitudBuroClienteOV> getIntegrantes() {
		return integrantes;
	}

	/**
	 * @param integrantes the integrantes to set
	 */
	public void setIntegrantes(List<SolicitudBuroClienteOV> integrantes) {
		this.integrantes = integrantes;
	}

}
