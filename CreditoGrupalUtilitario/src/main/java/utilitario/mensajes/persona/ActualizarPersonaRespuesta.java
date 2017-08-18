/**
 *
 */
package utilitario.mensajes.persona;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author out_mreyes@independencia.com.mx
 *
 */
public 	class 	ActualizarPersonaRespuesta extends ObjetoValor {
	/**
	 * UID Para serializacion
	 */
	private static final long serialVersionUID = 1L;

	// Atributos  -----------------------------------------------------------------------
	/** The header. */
	private EncabezadoRespuesta header;

	// Constructor  ---------------------------------------------------------------------
	/**
	 * Instancia una nueva actualizar persona respuesta.
	 *
	 * @param uid the uid
	 */
	public ActualizarPersonaRespuesta( java.lang.String uid ) {
		header = new EncabezadoRespuesta( uid );
		}

	// M&eacute;todos de acceso  ---------------------------------------------------------------
	/**
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

}
