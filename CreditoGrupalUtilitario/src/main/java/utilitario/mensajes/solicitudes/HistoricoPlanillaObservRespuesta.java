package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class HistoricoPlanillaObservRespuesta.
 *
 * @author out_gcorzo
 */
public class HistoricoPlanillaObservRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva historico planilla observaciones respuesta.
	 */
	public HistoricoPlanillaObservRespuesta() {
	}
	/** Se genero nuevo serial. */
	private static final long serialVersionUID = 4771230139176220692L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The listaExcepciones. */
	private List<HistoricoPlanillaObservOV> listaHistoricoPlanObserv;

	/**
	 * @return the listaHistoricoPlanObserv
	 */
	public List<HistoricoPlanillaObservOV> getListaHistoricoPlanObserv() {
		return listaHistoricoPlanObserv;
	}

	/**
	 * @param listaHistoricoPlanObserv the listaHistoricoPlanObserv to set
	 */
	public void setListaHistoricoPlanObserv(
			List<HistoricoPlanillaObservOV> listaHistoricoPlanObserv) {
		this.listaHistoricoPlanObserv = listaHistoricoPlanObserv;
	}

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

}
