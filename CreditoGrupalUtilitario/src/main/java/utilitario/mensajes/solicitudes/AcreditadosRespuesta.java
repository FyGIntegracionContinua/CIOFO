package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AcreditadosRespuesta.
 */
public class AcreditadosRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva acreditados respuesta.
	 */
	public AcreditadosRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6451899559144662886L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The acreditados. */
	private List<Acreditados> acreditados;

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
	 * Obtiene acreditados.
	 *
	 * @return acreditados
	 */
	public List<Acreditados> getAcreditados() {
		return acreditados;
	}

	/**
	 * Establece acreditados.
	 *
	 * @param acreditados a acreditados
	 */
	public void setAcreditados(List<Acreditados> acreditados) {
		this.acreditados = acreditados;
	}

}
