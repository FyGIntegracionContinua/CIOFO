package tarea.buro;

import utilitario.mensajes.buro.BuroInternoKitRespuesta;
import utilitario.mensajes.buro.BuroPeticionKit;

/**
 * Interfaz para buro interno
 * @author rguadarramac
 * @version 1.0
 */
public interface BuroInternoTarea {

	/**
	 * Metodo de consulta del historial crediticio para buro interno
	 * @param uid :
	 * @param contratoPeticion :
	 * @return respuesta
	 */
	BuroInternoKitRespuesta generaConsultaBuroInterno(String uid, BuroPeticionKit contratoPeticion);

}
