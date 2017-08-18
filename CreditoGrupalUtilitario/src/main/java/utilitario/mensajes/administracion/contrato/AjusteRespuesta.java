package utilitario.mensajes.administracion.contrato;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AjusteRespuesta.
 */
public class AjusteRespuesta extends ObjetoValor {

	/**
	 * AjusteRespuesta.
	 */
	public AjusteRespuesta() {

	}

	/** long serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** EncabezadoRespuesta header. */
	private EncabezadoRespuesta 	header;

	/** Double nuevoMonto. */
	private Double					nuevoMonto;

	/**
	 * Obtiene header.
	 *
	 * @return getHeader :
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header setHeader :
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene nuevo monto.
	 *
	 * @return getNuevoMonto :
	 */
	public Double getNuevoMonto() {
		return nuevoMonto;
	}

	/**
	 * Establece nuevo monto.
	 *
	 * @param nuevoMonto setNuevoMonto :
	 */
	public void setNuevoMonto(Double nuevoMonto) {
		this.nuevoMonto = nuevoMonto;
	}

}
