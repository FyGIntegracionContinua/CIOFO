package utilitario.mensajes.verificacion.telefonica;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author equipo desarrollo
 *
 */
public class ConsultaInformacionTelefonicaRespuesta extends ObjetoValor  {

	/**
	 * ConsultaInformacionTelefonicaRespuesta
	 */
	public ConsultaInformacionTelefonicaRespuesta() {

	}
	/**
	 *
	 */
	private static final long serialVersionUID = 6225051143833382030L;

	/**
	 * EncabezadoRespuesta header
	 */
	private EncabezadoRespuesta header;

	/**
	 * String cadenaSIMACC
	 */
	private String cadenaSIMACC;
	/**
	 * String idSolicitudCC
	 */
	private String idSolicitudCC;

	/**
	 * @return getHeader :
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * @param header setHeader :
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * @return getCadenaSIMACC :
	 */
	public String getCadenaSIMACC() {
		return cadenaSIMACC;
	}

	/**
	 * @param cadenaSIMACC setCadenaSIMACC :
	 */
	public void setCadenaSIMACC(String cadenaSIMACC) {
		this.cadenaSIMACC = cadenaSIMACC;
	}

	/**
	 * @return getIdSolicitudCC :
	 */
	public String getIdSolicitudCC() {
		return idSolicitudCC;
	}
	/**
	 * @param idSolicitudCC setIdSolicitudCC :
	 */
	public void setIdSolicitudCC(String idSolicitudCC) {
		this.idSolicitudCC = idSolicitudCC;
	}

}
