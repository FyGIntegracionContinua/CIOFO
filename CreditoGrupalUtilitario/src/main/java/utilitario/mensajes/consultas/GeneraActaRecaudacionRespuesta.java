package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;
import utilitario.mensajes.operacion.ActaRecaudacionOV;

/**
 * The Class GeneraActaRecaudacionRespuesta.
 *
 * @author out_oarias
 */
public 	class GeneraActaRecaudacionRespuesta
		extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2293976357086104356L;

	/** The header. */
	private EncabezadoRespuesta 	header;

	/** The acta recaudacion. */
	private ActaRecaudacionOV		actaRecaudacion;

	/**
	 * Instancia una nueva genera acta recaudacion respuesta.
	 */
	public GeneraActaRecaudacionRespuesta()	{
		header = new EncabezadoRespuesta();
		actaRecaudacion = new ActaRecaudacionOV();
		}

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
	 * Obtiene acta recaudacion.
	 *
	 * @return the actaRecaudacion
	 */
	public ActaRecaudacionOV getActaRecaudacion() {
		return actaRecaudacion;
	}

	/**
	 * Establece acta recaudacion.
	 *
	 * @param actaRecaudacion the actaRecaudacion to set
	 */
	public void setActaRecaudacion(ActaRecaudacionOV actaRecaudacion) {
		this.actaRecaudacion = actaRecaudacion;
	}

}
