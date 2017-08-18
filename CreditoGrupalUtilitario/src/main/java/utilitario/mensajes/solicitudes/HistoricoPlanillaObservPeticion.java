package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class HistoricoPlanillaObservPeticion.
 *
 * @author out_gcorzo
 * @version 1.0
 */
public class HistoricoPlanillaObservPeticion extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1405684620632002394L;

	/**
	 * Instancia una nueva historico planilla observaciones peticion
	 */
	public HistoricoPlanillaObservPeticion() {
	}

	/** The idSolicitud. */
	private String idSolicitud;

	/**
	 * @return the idSolicitud
	 */
	public String getIdSolicitud() {
		return idSolicitud;
	}


	/**
	 * @param idSolicitud the idSolicitud to set
	 */
	public void setIdSolicitud(String idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

}
