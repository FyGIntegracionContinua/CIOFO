package utilitario.mensajes.administracion.contrato;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ReasignarCarteraOV.
 *
 * @author out_mreyes
 */
public	class 	ReasignarCarteraOV
		extends ObjetoValor	{

	/** UID para la serializacion del objeto. */
	private static final long serialVersionUID = -3421754879122683711L;

	// Atributos de la clase  ---------------------------------------------------------------
	/** The contrato. */
	private java.lang.String	contrato;

	/** The motivo reasignacion. */
	private java.lang.String	motivoReasignacion;

	// Constructor  -------------------------------------------------------------------------
	/**
	 * Instancia una nueva reasignar cartera ov.
	 */
	public ReasignarCarteraOV()	{
		}

	// Metodos  -----------------------------------------------------------------------------
	/**
	 * Obtiene contrato.
	 *
	 * @return the contrato
	 */
	public java.lang.String getContrato() {
		return contrato;
	}

	/**
	 * Establece contrato.
	 *
	 * @param contrato the contrato to set
	 */
	public void setContrato(java.lang.String contrato) {
		this.contrato = contrato;
	}

	/**
	 * Obtiene motivo reasignacion.
	 *
	 * @return the motivoReasignacion
	 */
	public java.lang.String getMotivoReasignacion() {
		return motivoReasignacion;
	}

	/**
	 * Establece motivo reasignacion.
	 *
	 * @param motivoReasignacion the motivoReasignacion to set
	 */
	public void setMotivoReasignacion(java.lang.String motivoReasignacion) {
		this.motivoReasignacion = motivoReasignacion;
	}

}
