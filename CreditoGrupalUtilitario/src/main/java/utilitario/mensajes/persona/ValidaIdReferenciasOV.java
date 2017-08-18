/**
 *
 */
package utilitario.mensajes.persona;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultarPersonaRespuesta.
 *
 * @author rguadarrama
 */
public 	class 	ValidaIdReferenciasOV extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The id referencia. */
	private Double idRelacion;

	/** The count id relacion. */
	private Integer countIdRelacion;

	/**
	 * Instantiates a new id referencias ov.
	 */
	public ValidaIdReferenciasOV() { }


	/**
	 * Gets the id relacion.
	 *
	 * @return the id relacion
	 */
	public Double getIdRelacion() {
		return idRelacion;
	}

	/**
	 * Sets the id relacion.
	 *
	 * @param idRelacion the new id relacion
	 */
	public void setIdRelacion(Double idRelacion) {
		this.idRelacion = idRelacion;
	}

	/**
	 * Gets the count id relacion.
	 *
	 * @return the count id relacion
	 */
	public Integer getCountIdRelacion() {
		return countIdRelacion;
	}


	/**
	 * Sets the count id relacion.
	 *
	 * @param countIdRelacion the new count id relacion
	 */
	public void setCountIdRelacion(Integer countIdRelacion) {
		this.countIdRelacion = countIdRelacion;
	}




}
