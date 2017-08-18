/**
 * Tensegrity - 2011
 */
package utilitario.mensajes.originacion.grupo;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class GrupoRespuesta.
 *
 * @author Juan Moreno
 * Encapsula los datos de la respuesta de la operacion RegistrarCliente...
 * <ul>
 *  <li>Header con el resultado de la operacion</li>
 *  <li>Identificador del nuevo grupo.</li>
 *  <li>Ciclo del nuevo grupo.</li>
 * </ul>
 */
public final class GrupoRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva grupo respuesta.
	 */
	public GrupoRespuesta() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoRespuesta 	header;

	/** The peticion_ofs. */
	private String 	peticion_ofs;

	/** The identificador. */
	private String 	identificador;

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

}
