package utilitario.mensajes.administracion.contrato;

import java.io.Serializable;
import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConcentradoActasRecaudacionRespuesta.
 */
public class ConcentradoActasRecaudacionRespuesta extends ObjetoValor implements Serializable {

	/**
	 * Instancia una nueva concentrado actas recaudacion respuesta.
	 */
	public ConcentradoActasRecaudacionRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5912389132030697258L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The resumen. */
	private List<ResumenRecaudacionOV> resumen;

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
	 * Establece resumen.
	 *
	 * @param resumen a resumen
	 */
	public void setResumen(List<ResumenRecaudacionOV> resumen) {
		this.resumen = resumen;
	}

	/**
	 * Obtiene resumen.
	 *
	 * @return resumen
	 */
	public List<ResumenRecaudacionOV> getResumen() {
		return resumen;
	}


}
