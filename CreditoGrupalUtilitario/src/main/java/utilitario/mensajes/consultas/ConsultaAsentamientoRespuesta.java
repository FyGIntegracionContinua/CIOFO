package utilitario.mensajes.consultas;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaAsentamientoRespuesta.
 */
public class ConsultaAsentamientoRespuesta  extends ObjetoValor {

	/**
	 * Instancia una nueva consulta asentamiento respuesta.
	 */
	public ConsultaAsentamientoRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4310525986198359327L;

	/** The header. */
	private EncabezadoRespuesta 	header;

	/** The asentamientos. */
	private List<AsentamientoOV> asentamientos;

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
	 * Obtiene asentamientos.
	 *
	 * @return asentamientos
	 */
	public List<AsentamientoOV> getAsentamientos() {
		return asentamientos;
	}

	/**
	 * Establece asentamientos.
	 *
	 * @param asentamientos a asentamientos
	 */
	public void setAsentamientos(List<AsentamientoOV> asentamientos) {
		this.asentamientos = asentamientos;
	}


}
