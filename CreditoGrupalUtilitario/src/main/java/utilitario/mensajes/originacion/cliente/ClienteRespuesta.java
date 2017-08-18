/**
 * Tensegrity - 2011
 */
package utilitario.mensajes.originacion.cliente;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ClienteRespuesta.
 *
 * @author Juan Moreno
 * Encapsula los datos de la respuesta de la operacion RegistrarCliente...
 * <ul>
 *  <li>Header con el resultado de la operacion</li>
 *  <li>Identificador del ConsultaFechaOV Nuevo.</li>
 * </ul>
 */
public final class ClienteRespuesta extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoRespuesta 	header;

	/** The peticion_ofs. */
	private String 	peticion_ofs;

	/** The identificador. */
	private String 	identificador;

	/**
	 * Instancia una nueva cliente respuesta.
	 */
	public ClienteRespuesta() {
		header = new EncabezadoRespuesta();
		}

	/**
	 * Obtiene peticion_ofs.
	 *
	 * @return the peticion_ofs
	 */
	public String getPeticion_ofs() {
		return peticion_ofs;
	}

	/**
	 * Establece peticion_ofs.
	 *
	 * @param peticion_ofs the peticion_ofs to set
	 */
	public void setPeticion_ofs(String peticion_ofs) {
		this.peticion_ofs = peticion_ofs;
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
