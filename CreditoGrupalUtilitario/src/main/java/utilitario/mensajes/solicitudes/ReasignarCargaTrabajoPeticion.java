package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ReasignarCargaTrabajoPeticion.
 *
 * @author rguadarramac
 */
public class ReasignarCargaTrabajoPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva reasignar carga trabajo peticion.
	 */
	public ReasignarCargaTrabajoPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3710886787916191888L;

	/** The reasignaciones. */
	private List<ReasignarCargaTrabajoOV> reasignaciones;

	/**
	 * Establece reasignaciones.
	 *
	 * @param reasignaciones a reasignaciones
	 */
	public void setReasignaciones(List<ReasignarCargaTrabajoOV> reasignaciones) {
		this.reasignaciones = reasignaciones;
	}

	/**
	 * Obtiene reasignaciones.
	 *
	 * @return reasignaciones
	 */
	public List<ReasignarCargaTrabajoOV> getReasignaciones() {
		return reasignaciones;
	}

}
