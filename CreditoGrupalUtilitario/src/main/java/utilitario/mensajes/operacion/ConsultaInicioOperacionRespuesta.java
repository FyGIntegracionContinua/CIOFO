package utilitario.mensajes.operacion;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaInicioOperacionRespuesta.
 */
public class ConsultaInicioOperacionRespuesta extends ObjetoValor {

	/**
	 * ConsultaInicioOperacionRespuesta.
	 */
	public ConsultaInicioOperacionRespuesta() {
		super();
	}

	/** serialVersionUID long. */
	private static final long serialVersionUID = -961551529158242414L;

	/** header EncabezadoRespuesta. */
	private EncabezadoRespuesta	header;

	/** registros List<RegistroInicioOperacionRespuesta>. */
	private List<RegistroInicioOperacionRespuesta> registros;

	/**
	 * Obtiene header.
	 *
	 * @return .
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header .
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene registros.
	 *
	 * @return .
	 */
	public List<RegistroInicioOperacionRespuesta> getRegistros() {
		return registros;
	}

	/**
	 * Establece registros.
	 *
	 * @param registros .
	 */
	public void setRegistros(List<RegistroInicioOperacionRespuesta> registros) {
		this.registros = registros;
	}

}
