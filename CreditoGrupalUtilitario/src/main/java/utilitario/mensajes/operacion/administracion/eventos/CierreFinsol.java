package utilitario.mensajes.operacion.administracion.eventos;

import utilitario.mensajes.reportes.cierre.eventos.EventoReporteCierre;

/**
 * @author out_mreyes
 * @version 1.0.0
 */

public interface CierreFinsol {
	/**
	 * @param evento .
	 */
	public void ejecutarCierre( EventoReporteCierre evento );
}
