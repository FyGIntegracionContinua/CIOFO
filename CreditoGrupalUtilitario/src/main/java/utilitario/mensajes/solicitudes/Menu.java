package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class Menu.
 *
 * @author out_ltorres
 * @version 1.0
 */
public class Menu extends ObjetoValor {

	/**
	 * Instancia una nueva menu.
	 */
	public Menu() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 7338706926659028625L;

	/** The id menu. */
	private Integer idMenu;

	/** The menu. */
	private String menu;

	/** The page to open. */
	private String pageToOpen;

	/** The descripcion. */
	private String descripcion;

	/** The sub menus. */
	private Integer subMenus;

	/**
	 * Obtiene id menu.
	 *
	 * @return id menu
	 */
	public Integer getIdMenu() {
		return idMenu;
	}

	/**
	 * Establece id menu.
	 *
	 * @param idMenu a id menu
	 */
	public void setIdMenu(Integer idMenu) {
		this.idMenu = idMenu;
	}

	/**
	 * Obtiene menu.
	 *
	 * @return menu
	 */
	public String getMenu() {
		return menu;
	}

	/**
	 * Establece menu.
	 *
	 * @param menu a menu
	 */
	public void setMenu(String menu) {
		this.menu = menu;
	}

	/**
	 * Obtiene page to open.
	 *
	 * @return page to open
	 */
	public String getPageToOpen() {
		return pageToOpen;
	}

	/**
	 * Establece page to open.
	 *
	 * @param pageToOpen a page to open
	 */
	public void setPageToOpen(String pageToOpen) {
		this.pageToOpen = pageToOpen;
	}

	/**
	 * Obtiene descripcion.
	 *
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece descripcion.
	 *
	 * @param descripcion a descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene sub menus.
	 *
	 * @return sub menus
	 */
	public Integer getSubMenus() {
		return subMenus;
	}

	/**
	 * Establece sub menus.
	 *
	 * @param subMenus a sub menus
	 */
	public void setSubMenus(Integer subMenus) {
		this.subMenus = subMenus;
	}

}
