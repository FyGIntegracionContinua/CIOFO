package utilitario.mensajes.burocredito;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class BuroCreditoClienteGrupoRespuesta.
 */
public class BuroCreditoClienteGrupoRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva buro credito cliente grupo respuesta.
	 */
	public BuroCreditoClienteGrupoRespuesta() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -18130609485575612L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The grupos. */
	private List<BuroCreditoClienteGrupo> grupos;

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
	 * Obtiene grupos.
	 *
	 * @return grupos
	 */
	public List<BuroCreditoClienteGrupo> getGrupos() {
		return grupos;
	}

	/**
	 * Establece grupos.
	 *
	 * @param grupos a grupos
	 */
	public void setGrupos(List<BuroCreditoClienteGrupo> grupos) {
		this.grupos = grupos;
	}

}
