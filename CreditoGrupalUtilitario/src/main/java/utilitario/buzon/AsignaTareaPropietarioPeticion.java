package utilitario.buzon;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author rguadarramac
 *
 */
public class AsignaTareaPropietarioPeticion  extends ObjetoValor {

	/**
	 * AsignaTareaPropietarioPeticion
	 */
	public AsignaTareaPropietarioPeticion() {

	}
	/**
	 * long AsignaTareaPropietarioPeticion.java
	 */
	private static final long serialVersionUID = 573630904505626641L;
	/**
	 * Integer AsignaTareaPropietarioPeticion.java
	 */
	private Integer idTarea;
	/**
	 * String AsignaTareaPropietarioPeticion.java
	 */
	private String  propietario;
	/**
	 * boolean AsignaTareaPropietarioPeticion.java
	 */
	private boolean reasigna;
	/**
	 * @return the idTarea
	 */
	public Integer getIdTarea() {
		return idTarea;
	}
	/**
	 * @param idTarea the idTarea to set
	 */
	public void setIdTarea(Integer idTarea) {
		this.idTarea = idTarea;
	}
	/**
	 * @return the propietario
	 */
	public String getPropietario() {
		return propietario;
	}
	/**
	 * @param propietario the propietario to set
	 */
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	/**
	 * @return the reasigna
	 */
	public boolean isReasigna() {
		return reasigna;
	}
	/**
	 * @param reasigna the reasigna to set
	 */
	public void setReasigna(boolean reasigna) {
		this.reasigna = reasigna;
	}

}
