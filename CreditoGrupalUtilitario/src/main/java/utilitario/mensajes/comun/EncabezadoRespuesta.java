/**
 * Tensegrity - Enero 2011
 */
package utilitario.mensajes.comun;


/**
 * The Class EncabezadoRespuesta.
 *
 * @author Juan Moreno.
 * Encapsula los datos del header de Response de la ejecucion de una operacion.
 * <ul>
 * 	<li>estatus</li>
 * 	<li>mensaje</li>
 * 	<li>codigo</li>
 * 	<li>correlationId</li>
 *  <li>numSucursal</li>
 * </ul>
 */
public final class EncabezadoRespuesta extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The estatus. */
	private boolean estatus;

	/** The mensaje. */
	private String  mensaje;

	/** The codigo.  Bloqueante */
	private String  codigo;

	/** The uid. */
	private String  UID;

	/** The correlation id. */
	private String  correlationId;

	/** The num sucursal. */
	private int numSucursal;

	/**
	 * Instancia una nueva encabezado respuesta.
	 */
	public EncabezadoRespuesta( ) {
		this.estatus = true;
	}

	/**
	 * Instancia una nueva encabezado respuesta.
	 *
	 * @param UID the uid
	 */
	public EncabezadoRespuesta( String UID) {
		this.estatus = true;
		this.UID = UID;
	}

	/**
	 * Checks if is estatus.
	 *
	 * @return the estatus
	 */
	public boolean isEstatus() {
		return estatus;
	}

	/**
	 * Establece estatus.
	 *
	 * @param estatus the estatus to set
	 */
	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	/**
	 * Obtiene mensaje.
	 *
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * Establece mensaje.
	 *
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * Obtiene codigo.
	 *
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Establece codigo.
	 *
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	/**
	 * Obtiene uid.
	 *
	 * @return the uID
	 */
	public String getUID() {
		return UID;
	}

	/**
	 * Establece uid.
	 *
	 * @param uID the uID to set
	 */
	public void setUID(String uID) {
		UID = uID;
	}

	/**
	 * Obtiene num sucursal.
	 *
	 * @return the numSucursal
	 */
	public int getNumSucursal() {
		return numSucursal;
	}

	/**
	 * Establece num sucursal.
	 *
	 * @param numSucursal the numSucursal to set
	 */
	public void setNumSucursal(int numSucursal) {
		this.numSucursal = numSucursal;
	}

	/**
	 * Obtiene correlation id.
	 *
	 * @return the correlationId
	 */
	public String getCorrelationId() {
		return correlationId;
	}

	/**
	 * Establece correlation id.
	 *
	 * @param correlationId the correlationId to set
	 */
	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

}
