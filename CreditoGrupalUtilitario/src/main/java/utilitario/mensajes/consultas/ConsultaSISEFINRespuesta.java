package utilitario.mensajes.consultas;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaSISEFINRespuesta.
 *
 * @author out_mreyes
 */
public 	class 	ConsultaSISEFINRespuesta
		extends	ObjetoValor	{

	/**
	 * Instancia una nueva consulta sisefin respuesta.
	 */
	public ConsultaSISEFINRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -451912413479961085L;

	/** The header. */
	private EncabezadoRespuesta	header;

	/** The resultado. */
	private List<ConsultaSISEFINVO> resultado;

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
	 * Obtiene resultado.
	 *
	 * @return the resultado
	 */
	public List<ConsultaSISEFINVO> getResultado() {
		return resultado;
	}

	/**
	 * Establece resultado.
	 *
	 * @param resultado the resultado to set
	 */
	public void setResultado(List<ConsultaSISEFINVO> resultado) {
		this.resultado = resultado;
	}

}
