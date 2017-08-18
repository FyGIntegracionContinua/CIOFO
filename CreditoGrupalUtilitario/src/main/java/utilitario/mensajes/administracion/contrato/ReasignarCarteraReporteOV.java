package utilitario.mensajes.administracion.contrato;

/**
 * The Class ReasignarCarteraReporteOV.
 *
 * @author out_mreyes
 */
public	class 	ReasignarCarteraReporteOV
		extends ReasignarCarteraOV {

	/** UID para la serializacion del objeto. */
	private static final long serialVersionUID = -3421754879122683711L;

	// Atributos de la clase  ---------------------------------------------------------------
	/** The status. */
	private java.lang.String		status;

	/** The codigo. */
	private java.lang.Integer		codigo;

	// Constructor  -------------------------------------------------------------------------
	/**
	 * Instancia una nueva reasignar cartera reporte ov.
	 */
	public ReasignarCarteraReporteOV() {
		}

	// Metodos  -----------------------------------------------------------------------------
	/**
	 * Obtiene status.
	 *
	 * @return the status
	 */
	public java.lang.String getStatus() {
		return status;
	}

	/**
	 * Establece status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(java.lang.String status) {
		this.status = status;
	}

	/**
	 * Obtiene codigo.
	 *
	 * @return the codigo
	 */
	public java.lang.Integer getCodigo() {
		return codigo;
	}

	/**
	 * Establece codigo.
	 *
	 * @param codigo the codigo to set
	 */
	public void setCodigo(java.lang.Integer codigo) {
		this.codigo = codigo;
	}

}
