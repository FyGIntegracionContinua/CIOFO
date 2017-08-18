package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaPoolPersonasRespuesta.
 *
 * @author rguadarramac
 *
 */
public class ConsultaPoolPersonasRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva consulta pool personas respuesta.
	 */
	public ConsultaPoolPersonasRespuesta() {
	}
	/** Se genero nuevo serial. */
	private static final long serialVersionUID = 4771230139176220692L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The pool personas. */
	private List<PoolPersonasOV> poolPersonas;

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
	 * Establece pool personas.
	 *
	 * @param poolPersonas a pool personas
	 */
	public void setPoolPersonas(List<PoolPersonasOV> poolPersonas) {
		this.poolPersonas = poolPersonas;
	}

	/**
	 * Obtiene pool personas.
	 *
	 * @return pool personas
	 */
	public List<PoolPersonasOV> getPoolPersonas() {
		return poolPersonas;
	}

}
