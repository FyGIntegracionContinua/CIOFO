
package utilitario.mensajes.comun;


/**
 * The Class ResultadoOV.
 *
 * @author Juan Moreno
 * Encapsula los datos de la respuesta de la ejecucion de un stored procedure...
 * <ul>
 *  <li>Codigo de respuesta</li>
 *  <li>Mensaje de respuesta</li>
 * </ul>
 */
public class ResultadoOV extends ObjetoValor {

	/**
	 * Instancia una nueva resultado ov.
	 */
	public ResultadoOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= 1L;

	/** The identificador. */
	private String identificador;

	/** The uid. */
	private String uid;

	/** The estatus. */
	private boolean estatus;

	/** The codigo. */
	private String codigo;

	/** The mensaje. */
	private String mensaje;

	/** The excepcion. */
	private String excepcion;

	/** The codigo retorno. */
	private Integer codigoRetorno;

	/** The peticion_ ofs. */
	private String peticion_Ofs;

	/**
	 * Obtiene peticion_ ofs.
	 *
	 * @return the peticion_Ofs
	 */
	public String getPeticion_Ofs() {
		return peticion_Ofs;
	}

	/**
	 * Establece peticion_ ofs.
	 *
	 * @param peticion_Ofs the peticion_Ofs to set
	 */
	public void setPeticion_Ofs(String peticion_Ofs) {
		this.peticion_Ofs = peticion_Ofs;
	}

	/**
	 * Obtiene identificador.
	 *
	 * @return the identificador
	 */
	public String getIdentificador() {
		return identificador;
	}

	/**
	 * Establece identificador.
	 *
	 * @param identificador the identificador to set
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	/**
	 * Obtiene codigo retorno.
	 *
	 * @return the codigoRetorno
	 */
	public Integer getCodigoRetorno() {
		return codigoRetorno;
	}

	/**
	 * Establece codigo retorno.
	 *
	 * @param codigoRetorno the codigoRetorno to set
	 */
	public void setCodigoRetorno(Integer codigoRetorno) {
		this.codigoRetorno = codigoRetorno;
	}

	/**
	 * Obtiene uid.
	 *
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * Establece uid.
	 *
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * Obtiene excepcion.
	 *
	 * @return the excepcion
	 */
	public String getExcepcion() {
		return excepcion;
	}

	/**
	 * Establece excepcion.
	 *
	 * @param excepcion the excepcion to set
	 */
	public void setExcepcion(String excepcion) {
		this.excepcion = excepcion;
	}

	/**
	 * Obtiene codigo.
	 *
	 * @return the codigo
	 */
	public final String getCodigo( ) {
		return codigo;
	}

	/**
	 * Establece codigo.
	 *
	 * @param codigo the codigo to set
	 */
	public final void setCodigo( String codigo ) {
		this.codigo = codigo;
		this.setEstatus( );
	}

	/**
	 * Obtiene mensaje.
	 *
	 * @return the mensaje
	 */
	public final String getMensaje( ) {
		return mensaje;
	}

	/**
	 * Establece mensaje.
	 *
	 * @param mensaje the mensaje to set
	 */
	public final void setMensaje( String mensaje ) {
		this.mensaje = mensaje;
	}

	/**
	 * Determiona el resultado de la ejecucion...
	 */
	public final void setEstatus( ) {
			try {
				if ( Integer.parseInt( this.codigo ) == 0 ) {
					this.estatus = true;
				}
			}
			catch ( NumberFormatException ignored ) {
				ignored.getMessage();
			}
	}

	/**
	 * Checks if is success.
	 *
	 * @return the estatus
	 */
	public final boolean isSuccess( ) {
		return estatus;
	}

	/**
	 * Establece estatus.
	 *
	 * @param estatus the estatus to set
	 */
	public final void setEstatus( boolean estatus ) {
		this.estatus = estatus;
	}

	/**
	 * Checks if is estatus.
	 *
	 * @return the estatus
	 */
	public boolean isEstatus() {
		return estatus;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		ResultadoOV that = null;
		try {
			that = (ResultadoOV) obj;
		} catch ( Exception e) {
			return false;
		}
		if ( that.getCodigo() != null  ) {
			return that.isEstatus() == this.isEstatus() &&  that.getCodigo().equals( this.getCodigo());
		}
		else {
			return that.isEstatus() == this.isEstatus();
		}
	}

	@Override
	  public int hashCode() {
		Integer anyInt = 0;
	    return anyInt;
	  }

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ResultadoOV [uid=" + uid + ", estatus=" + estatus + ", codigo="
				+ codigo + ", codigoRetorno= " + codigoRetorno + ", mensaje="
				+ mensaje + ", excepcion=" + excepcion + "]";
	}

}
