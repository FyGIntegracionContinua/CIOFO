package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class CodigosRespuesta.
 * @author out_gcorzo
 */
public class CodigosRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva codigos respuesta.
	 */
	public CodigosRespuesta() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6035371579190210677L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The codigos. */
	private List<CodigoOV> codigos;

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
	 * @return the codigos
	 */
	public List<CodigoOV> getCodigos() {
		return codigos;
	}

	/**
	 * @param codigos the codigos to set
	 */
	public void setCodigos(List<CodigoOV> codigos) {
		this.codigos = codigos;
	}

}
