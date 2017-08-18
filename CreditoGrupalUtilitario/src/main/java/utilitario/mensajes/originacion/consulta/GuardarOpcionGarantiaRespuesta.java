package utilitario.mensajes.originacion.consulta;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class GuardarOpcionGarantiaPeticion.
 */
public class GuardarOpcionGarantiaRespuesta extends ObjetoValor {

	/**
	 * Instantiates a new guardar opcion garantia peticion.
	 */
	public GuardarOpcionGarantiaRespuesta() {
	}

	/** serial. */
	private static final long serialVersionUID = 2481624307041105116L;

	/**
	 * EncabezadoRespuesta header
	 */
	private EncabezadoRespuesta header;

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
