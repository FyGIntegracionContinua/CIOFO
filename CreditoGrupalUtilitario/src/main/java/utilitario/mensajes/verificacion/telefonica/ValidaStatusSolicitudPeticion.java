package utilitario.mensajes.verificacion.telefonica;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ValidaStatusSolicitudPeticion.
 *
 * @author rguadarramac
 */
public class ValidaStatusSolicitudPeticion extends ObjetoValor {

	/**
	 * ValidaStatusSolicitudPeticion
	 */
	public ValidaStatusSolicitudPeticion() {

	}

	/**
	 *
	 */
	private static final long serialVersionUID = 8403535644682378684L;

	/**
	 * EncabezadoPeticion header
	 */
	private EncabezadoPeticion	header;
	/**
	 * String idSolicitud
	 */
	private String idSolicitud;


	/**
	 * @return getHeader :
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}
	/**
	 * @param header setHeader :
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}
	/**
	 * @return getIdSolicitud :
	 */
	public String getIdSolicitud() {
		return idSolicitud;
	}
	/**
	 * @param idSolicitud setIdSolicitud :
	 */
	public void setIdSolicitud(String idSolicitud) {
		this.idSolicitud = idSolicitud;
	}


}
