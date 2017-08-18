package utilitario.mensajes.administracion.contrato;

import java.io.Serializable;
import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AjusteDiaReunionRespuesta.
 */
public class AjusteDiaReunionRespuesta extends ObjetoValor implements Serializable {

	/**
	 * Instancia una nueva ajuste dia reunion respuesta.
	 */
	public AjusteDiaReunionRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -90888161479098812L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The resumen recaudacion ov. */
	private List<ResumenRecaudacionOV> resumenRecaudacionOV;

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
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
	 * Establece resumen recaudacion ov.
	 *
	 * @param resumenRecaudacionOV a resumen recaudacion ov
	 */
	public void setResumenRecaudacionOV(List<ResumenRecaudacionOV> resumenRecaudacionOV) {
		this.resumenRecaudacionOV = resumenRecaudacionOV;
	}

	/**
	 * Obtiene resumen recaudacion ov.
	 *
	 * @return resumen recaudacion ov
	 */
	public List<ResumenRecaudacionOV> getResumenRecaudacionOV() {
		return resumenRecaudacionOV;
	}

}
