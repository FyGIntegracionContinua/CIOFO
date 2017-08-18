package utilitario.mensajes.impresiondocs.comun;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class DatosMiembrosVO.
 */
public class DatosMiembrosVO extends ObjetoValor {

	/**
	 * DatosMiembrosVO.
	 */
	public DatosMiembrosVO() {

	}

	/** serialVersionUID long. */
	private static final long serialVersionUID = -4406279487903925226L;

	/** nombre String. */
	private String nombre;

	/** apPaterno String. */
	private String apPaterno;

	/** apMaterno String. */
	private String apMaterno;

	/**
	 * Obtiene nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece nombre.
	 *
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene ap paterno.
	 *
	 * @return the apPaterno
	 */
	public String getApPaterno() {
		return apPaterno;
	}

	/**
	 * Establece ap paterno.
	 *
	 * @param apPaterno the apPaterno to set
	 */
	public void setApPaterno(String apPaterno) {
		this.apPaterno = apPaterno;
	}

	/**
	 * Obtiene ap materno.
	 *
	 * @return the apMaterno
	 */
	public String getApMaterno() {
		return apMaterno;
	}

	/**
	 * Establece ap materno.
	 *
	 * @param apMaterno the apMaterno to set
	 */
	public void setApMaterno(String apMaterno) {
		this.apMaterno = apMaterno;
	}
}
