/**
 *
 */
package utilitario.mensajes.persona;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class RegistrarPersonaRespuesta.
 *
 * @author out_mreyes@independencia.com.mx
 */
public 	class 	RegistrarPersonaRespuesta extends ObjetoValor {

	/** UID Para serializacion. */
	private static final long serialVersionUID = 1L;

	// Atributos  -----------------------------------------------------------------------
	/** The header. */
	private EncabezadoRespuesta header;

	/** The relacion clave finsol. */
	private RelacionClaveFinsolOV relacionClaveFinsol;
	
	// atributo que se agraga para el requerimeinto ORIG-522_26122016_Sucursal móvil (Caravanas)
	/**estatus del buro de credito*/
	private boolean validacionBuro;
	/**mensaje del buro de credito*/
	private String mensajeBuro;

	/**
	 * Instancia una nueva registrar persona respuesta.
	 */
	public RegistrarPersonaRespuesta() {
		header = new EncabezadoRespuesta(  );
	}

	// Constructor  ---------------------------------------------------------------------
	/**
	 * Instancia una nueva registrar persona respuesta.
	 *
	 * @param uid the uid
	 */
	public RegistrarPersonaRespuesta( java.lang.String uid ) {
		header = new EncabezadoRespuesta( uid );
		}

	// M&eacute;todos de acceso  ---------------------------------------------------------------
	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene relacion clave finsol.
	 *
	 * @return the relacionClaveFinsol
	 */
	public RelacionClaveFinsolOV getRelacionClaveFinsol() {
		return relacionClaveFinsol;
	}

	/**
	 * Establece relacion clave finsol.
	 *
	 * @param relacionClaveFinsol the relacionClaveFinsol to set
	 */
	public void setRelacionClaveFinsol(RelacionClaveFinsolOV relacionClaveFinsol) {
		this.relacionClaveFinsol = relacionClaveFinsol;
	}

	/**
	 * @return the validacionBuro
	 */
	public boolean getValidacionBuro() {
		return validacionBuro;
	}

	/**
	 * @param validacionBuro the validacionBuro to set
	 */
	public void setValidacionBuro(boolean validacionBuro) {
		this.validacionBuro = validacionBuro;
	}

	/**
	 * @return the mensajeBuro
	 */
	public String getMensajeBuro() {
		return mensajeBuro;
	}

	/**
	 * @param mensajeBuro the mensajeBuro to set
	 */
	public void setMensajeBuro(String mensajeBuro) {
		this.mensajeBuro = mensajeBuro;
	}

}
