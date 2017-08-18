package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaOportunidadRespuesta.
 */
public class ConsultaOportunidadRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva consulta oportunidad respuesta.
	 */
	public ConsultaOportunidadRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5082709112138876166L;

	/** The header. */
	private EncabezadoRespuesta 	header;

	/** The is oportunidad. */
	private Boolean					isOportunidad;

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
	 * Establece checks if is oportunidad.
	 *
	 * @param isOportunidad a checks if is oportunidad
	 */
	public void setIsOportunidad(Boolean isOportunidad) {
		this.isOportunidad = isOportunidad;
	}

	/**
	 * Obtiene checks if is oportunidad.
	 *
	 * @return checks if is oportunidad
	 */
	public Boolean getIsOportunidad() {
		return isOportunidad;
	}

}
