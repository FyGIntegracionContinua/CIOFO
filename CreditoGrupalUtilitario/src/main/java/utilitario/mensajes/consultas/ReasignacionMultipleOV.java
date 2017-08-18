package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author out_oarias
 *
 */
public 	class 	ReasignacionMultipleOV extends ObjetoValor {
	/**
	 * UID para la serializacion
	 */
	private static final long serialVersionUID = 5339094097640348053L;
	// Atributos privados  -------------------------------------------------------------------------------
	/**
	 * nombreGrupo java.lang.String
	 */
	private java.lang.String	nombreGrupo;
	/**
	 * contratoLD java.lang.String
	 */
	private java.lang.String	contratoLD;
	/**
	 * contrato java.lang.String
	 */
	private java.lang.String	contrato;
	/**
	 * numeroReasignaciones java.lang.Integer
	 */
	private java.lang.Integer	numeroReasignaciones;

	// Constructor  --------------------------------------------------------------------------------------
	/**
	 * ReasignacionMultipleOV
	 */
	public ReasignacionMultipleOV() {
		}

	// Set y Get  ----------------------------------------------------------------------------------------
	/**
	 * @return the grupo
	 */
	public java.lang.String getNombreGrupo() {
		return nombreGrupo;
	}

	/**
	 * @param nombreGrupo the grupo to set
	 */
	public void setNombreGrupo(java.lang.String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	/**
	 * @return the contratoLD
	 */
	public java.lang.String getContratoLD() {
		return contratoLD;
	}

	/**
	 * @param contratoLD the contratoLD to set
	 */
	public void setContratoLD(java.lang.String contratoLD) {
		this.contratoLD = contratoLD;
	}

	/**
	 * @return the numeroReasignaciones
	 */
	public java.lang.Integer getNumeroReasignaciones() {
		return numeroReasignaciones;
	}

	/**
	 * @param numeroReasignaciones the numeroReasignaciones to set
	 */
	public void setNumeroReasignaciones(java.lang.Integer numeroReasignaciones) {
		this.numeroReasignaciones = numeroReasignaciones;
	}

	/**
	 * @return the contrato
	 */
	public java.lang.String getContrato() {
		return contrato;
	}

	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(java.lang.String contrato) {
		this.contrato = contrato;
	}

}
