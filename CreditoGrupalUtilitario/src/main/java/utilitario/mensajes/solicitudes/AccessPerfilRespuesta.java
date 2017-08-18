package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AccessPerfilRespuesta.
 */
public class AccessPerfilRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva access perfil respuesta.
	 */
	public AccessPerfilRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5934434544636929774L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The menus. */
	private List<Menu> menus;

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene menus.
	 *
	 * @return menus
	 */
	public List<Menu> getMenus() {
		return menus;
	}

	/**
	 * Establece menus.
	 *
	 * @param menus a menus
	 */
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
}
