/**
 *
 */
package utilitario.mensajes.burocredito;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class BuroCreditoClienteDetalleGrupoPeticion.
 *
 * @author out_ltorres
 */
public class BuroCreditoClienteDetalleGrupoPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva buro credito cliente detalle grupo peticion.
	 */
	public BuroCreditoClienteDetalleGrupoPeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1040217632297231472L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The prm grupo. */
	private String prmGrupo;

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}

	/**
	 * Obtiene prm grupo.
	 *
	 * @return prm grupo
	 */
	public String getPrmGrupo() {
		return prmGrupo;
	}

	/**
	 * Establece prm grupo.
	 *
	 * @param prmGrupo a prm grupo
	 */
	public void setPrmGrupo(String prmGrupo) {
		this.prmGrupo = prmGrupo;
	}

}
