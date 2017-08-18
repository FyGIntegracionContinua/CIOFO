package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SemaforoSolicitudesRespuesta.
 * @author out_gcorzo
 */
public class SemaforoSolicitudesRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva codigos respuesta.
	 */
	public SemaforoSolicitudesRespuesta() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6035371579190210677L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The listaSolSemaforos. */
	private List<SemaforoSolicitudesOV> listaSolSemaforos;

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
	 * @return the listaSolSemaforos
	 */
	public List<SemaforoSolicitudesOV> getListaSolSemaforos() {
		return listaSolSemaforos;
	}

	/**
	 * @param listaSolSemaforos the listaSolSemaforos to set
	 */
	public void setListaSolSemaforos(List<SemaforoSolicitudesOV> listaSolSemaforos) {
		this.listaSolSemaforos = listaSolSemaforos;
	}

}
