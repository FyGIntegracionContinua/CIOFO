package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaDatosClienteRespuesta.
 *
 * @author out_oarias
 */
public class ConsultaDatosClienteRespuesta extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5082709112138876166L;

	/** The header. */
	private EncabezadoRespuesta 	header;

	/** The datos. */
	private DatosClienteOV	datos;

	/**
	 * Instancia una nueva consulta datos cliente respuesta.
	 */
	public ConsultaDatosClienteRespuesta() {
		header = new EncabezadoRespuesta();
		}

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
	 * Obtiene datos.
	 *
	 * @return the datos
	 */
	public DatosClienteOV getDatos() {
		return datos;
	}

	/**
	 * Establece datos.
	 *
	 * @param datos the datos to set
	 */
	public void setDatos(DatosClienteOV datos) {
		this.datos = datos;
	}

}
