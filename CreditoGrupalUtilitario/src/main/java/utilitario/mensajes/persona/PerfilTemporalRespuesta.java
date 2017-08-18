package utilitario.mensajes.persona;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

public class PerfilTemporalRespuesta extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5506094017816869329L;
	/** The header. */
	private EncabezadoRespuesta	header;
	/** The perfilTemporal. */
	private PerfilTemporal perfilTemporal;
	/**
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}
	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}
	/**
	 * @return the perfilTemporal
	 */
	public PerfilTemporal getPerfilTemporal() {
		return perfilTemporal;
	}
	/**
	 * @param perfilTemporal the perfilTemporal to set
	 */
	public void setPerfilTemporal(PerfilTemporal perfilTemporal) {
		this.perfilTemporal = perfilTemporal;
	}

}
