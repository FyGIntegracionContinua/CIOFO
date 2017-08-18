package tarea.burocredito;

import utilitario.comun.Constantes;
import utilitario.mensajes.burocredito.BuroCreditoPlanillaAprobacionPeticion;
import utilitario.mensajes.burocredito.BuroCreditoPlanillaAprobacionRespuesta;


/**
 * @author out_mmejorada
 * @version 1.0.0
 */
public interface PlanillaAprobacion extends Constantes {

	/**
	 * @param uid identificador unico
	 * @param peticion  para generar planilla de aprobacion
	 * @return BuroCreditoClienteRespuesta
	 */
	BuroCreditoPlanillaAprobacionRespuesta obtenerDatosPlanillaAprobacion(
			String uid,  BuroCreditoPlanillaAprobacionPeticion peticion);


}
