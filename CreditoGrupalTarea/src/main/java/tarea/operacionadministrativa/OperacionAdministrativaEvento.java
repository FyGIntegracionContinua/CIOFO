/**
 * 
 */
package tarea.operacionadministrativa;

import utilitario.mensajes.reportes.cierre.eventos.EventoReporteCierre;


/**
 * @author out_mreyes
 *
 */
public interface OperacionAdministrativaEvento 
	{
	/**
	 * Funcion para ejecutar el cierre, de forma asincrona
	 * @param uid
	 * @param fechaCierre
	 */
	public void ejecutarCierre( EventoReporteCierre evento );
	}
