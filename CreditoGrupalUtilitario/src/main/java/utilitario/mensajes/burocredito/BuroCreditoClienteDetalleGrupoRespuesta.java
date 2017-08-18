package utilitario.mensajes.burocredito;

import java.util.Date;
import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class BuroCreditoClienteDetalleGrupoRespuesta.
 */
public class BuroCreditoClienteDetalleGrupoRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva buro credito cliente detalle grupo respuesta.
	 */
	public BuroCreditoClienteDetalleGrupoRespuesta() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7634806602141172176L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The prm fecha. */
	private Date prmFecha;

	/** The contratos. */
	private List<BuroCreditoClienteDetalleGrupo> contratos;

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
	 * Obtiene prm fecha.
	 *
	 * @return prm fecha
	 */
	public Date getPrmFecha() {
		return prmFecha;
	}

	/**
	 * Establece prm fecha.
	 *
	 * @param prmFecha a prm fecha
	 */
	public void setPrmFecha(Date prmFecha) {
		this.prmFecha = prmFecha;
	}

	/**
	 * Obtiene contratos.
	 *
	 * @return contratos
	 */
	public List<BuroCreditoClienteDetalleGrupo> getContratos() {
		return contratos;
	}

	/**
	 * Establece contratos.
	 *
	 * @param contratos a contratos
	 */
	public void setContratos(List<BuroCreditoClienteDetalleGrupo> contratos) {
		this.contratos = contratos;
	}

}
