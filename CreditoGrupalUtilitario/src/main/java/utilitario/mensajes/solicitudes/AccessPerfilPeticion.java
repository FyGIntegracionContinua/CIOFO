/**
 *
 */
package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AccessPerfilPeticion.
 *
 * @author out_ltorres
 */
public class AccessPerfilPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva access perfil peticion.
	 */
	public AccessPerfilPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 9021649374573872470L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The id usuario. */
	private Integer idUsuario;

	/** The id aplicacion. */
	private Integer idAplicacion;

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}

	/**
	 * Obtiene id usuario.
	 *
	 * @return id usuario
	 */
	public Integer getIdUsuario() {
		return idUsuario;
	}

	/**
	 * Establece id usuario.
	 *
	 * @param idUsuario a id usuario
	 */
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	/**
	 * Obtiene id aplicacion.
	 *
	 * @return id aplicacion
	 */
	public Integer getIdAplicacion() {
		return idAplicacion;
	}

	/**
	 * Establece id aplicacion.
	 *
	 * @param idAplicacion a id aplicacion
	 */
	public void setIdAplicacion(Integer idAplicacion) {
		this.idAplicacion = idAplicacion;
	}

}
