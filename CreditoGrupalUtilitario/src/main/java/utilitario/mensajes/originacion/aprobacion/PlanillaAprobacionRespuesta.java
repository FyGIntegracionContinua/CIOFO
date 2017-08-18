/**
 *
 */
package utilitario.mensajes.originacion.aprobacion;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class PlanillaAprobacionRespuesta.
 *
 * @author out_oarias
 */
public class PlanillaAprobacionRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva planilla aprobacion respuesta.
	 */
	public PlanillaAprobacionRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The encabezado. */
	private EncabezadoRespuesta encabezado;

	/** The ofs. */
	private String ofs;

	/**
	 * Obtiene encabezado.
	 *
	 * @return the encabezado
	 */
	public EncabezadoRespuesta getEncabezado() {
		return encabezado;
	}

	/**
	 * Establece encabezado.
	 *
	 * @param encabezado the encabezado to set
	 */
	public void setEncabezado(EncabezadoRespuesta encabezado) {
		this.encabezado = encabezado;
	}

	/**
	 * Obtiene ofs.
	 *
	 * @return the ofs
	 */
	public String getOfs() {
		return ofs;
	}

	/**
	 * Establece ofs.
	 *
	 * @param ofs the ofs to set
	 */
	public void setOfs(String ofs) {
		this.ofs = ofs;
	}

}
