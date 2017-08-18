/**
 * Tensegrity - 2011
 */
package utilitario.mensajes.originacion.consulta;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaDiaHabilRespuesta.
 *
 * @author Juan Moreno
 * Encapsula los datos de la respuesta de la operacion RegistrarCliente...
 * <ul>
 *  <li>Header con el resultado de la operacion</li>
 *  <li>Identificador del ConsultaFechaOV Nuevo.</li>
 * </ul>
 */
public final class ConsultaDiaHabilRespuesta extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoRespuesta 	header;

	/** The identificador. */
	private java.lang.String		identificador;

	/**
	 * Instancia una nueva consulta dia habil respuesta.
	 */
	public ConsultaDiaHabilRespuesta() {
	  header = new EncabezadoRespuesta();
	}

	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public final EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public final void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene identificador.
	 *
	 * @return the identificador
	 */
	public final String getIdentificador() {
		return identificador;
	}

	/**
	 * Establece identificador.
	 *
	 * @param identificador the identificador to set
	 */
	public final void setIdentificador(String identificador) {
		this.identificador = identificador;
	}


}
