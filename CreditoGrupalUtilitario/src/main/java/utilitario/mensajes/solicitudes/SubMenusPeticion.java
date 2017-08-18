package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SubMenusPeticion.
 *
 * @author out_ltorres
 */
public class SubMenusPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva sub menus peticion.
	 */
	public SubMenusPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7226693537074706283L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The id padre. */
	private Integer idPadre;

	/** The id perfil. */
	private Integer idPerfil;

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
	 * Obtiene id padre.
	 *
	 * @return id padre
	 */
	public Integer getIdPadre() {
		return idPadre;
	}

	/**
	 * Establece id padre.
	 *
	 * @param idPadre a id padre
	 */
	public void setIdPadre(Integer idPadre) {
		this.idPadre = idPadre;
	}

	/**
	 * Obtiene id perfil.
	 *
	 * @return id perfil
	 */
	public Integer getIdPerfil() {
		return idPerfil;
	}

	/**
	 * Establece id perfil.
	 *
	 * @param idPerfil a id perfil
	 */
	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
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
