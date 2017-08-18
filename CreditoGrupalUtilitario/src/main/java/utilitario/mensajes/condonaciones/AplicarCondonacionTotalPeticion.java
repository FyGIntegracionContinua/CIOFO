package utilitario.mensajes.condonaciones;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;
import utilitario.mensajes.condonaciones.comun.CondonacionOV;

/**
 * The Class AplicarCondonacionTotalPeticion.
 */
public class AplicarCondonacionTotalPeticion  extends ObjetoValor {

	/**
	 * Instancia una nueva aplicar condonacion total peticion.
	 */
	public AplicarCondonacionTotalPeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoPeticion 	header;

	/** The condonacion. */
	private CondonacionOV condonacion;


	/**
	 * Obtiene condonacion.
	 *
	 * @return the condonacion
	 */
	public CondonacionOV getCondonacion() {
		return condonacion;
	}


	/**
	 * Establece condonacion.
	 *
	 * @param condonacion the condonacion to set
	 */
	public void setCondonacion(CondonacionOV condonacion) {
		this.condonacion = condonacion;
	}


	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}


	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}


}
