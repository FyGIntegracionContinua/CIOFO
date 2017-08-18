package utilitario.mensajes.burocredito;

import java.util.Date;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class BuroCreditoFechaRespuesta.
 */
public class BuroCreditoFechaRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva buro credito fecha respuesta.
	 */
	public BuroCreditoFechaRespuesta() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8521103259775089467L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The fecha. */
	private Date fecha;

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene fecha.
	 *
	 * @return fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Establece fecha.
	 *
	 * @param fecha a fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
