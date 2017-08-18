/**
 * 
 */
package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author lsotos
 *
 */
public class ExcepcionMontoCupoRespuesta extends ObjetoValor{

	public ExcepcionMontoCupoRespuesta() {
	}
 
	/**
	 * 
	 */
	private static final long serialVersionUID = -7363428270499456539L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The Excepciones. */
	private ExcepcionMontoCupoOV solicitudExcepciones;

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
	 * @return the solicitudExcepciones
	 */
	public ExcepcionMontoCupoOV getSolicitudExcepciones() {
		return solicitudExcepciones;
	}

	/**
	 * @param solicitudExcepciones the solicitudExcepciones to set
	 */
	public void setSolicitudExcepciones(ExcepcionMontoCupoOV solicitudExcepciones) {
		this.solicitudExcepciones = solicitudExcepciones;
	}

	
}
