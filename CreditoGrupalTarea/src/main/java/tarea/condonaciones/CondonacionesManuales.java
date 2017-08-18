package tarea.condonaciones;

import utilitario.mensajes.condonaciones.AplicarCondonacionParcialPeticion;
import utilitario.mensajes.condonaciones.AplicarCondonacionParcialRespuesta;
import utilitario.mensajes.condonaciones.AplicarCondonacionTotalPeticion;
import utilitario.mensajes.condonaciones.AplicarCondonacionTotalRespuesta;


/**
 * @author out_mmejorada
 * @version 1.0.0
 */
public interface CondonacionesManuales {
	/**
	 * Realiza la condonaci�n parcial de un cr�dito
	 * @param uid identificador unico de la transaccion
	 * @param peticion
	 *             Incluye los datos necesarios para la condonacion en un arreglo de cadenas
	 *            [cr�dito],[capital],[inter�s],[recargo],[motivo]
	 *            y una cadena que se usaba como referencia para recibir el detalle de la operacion
	 * @return Resultado de la operacion
	 */
	AplicarCondonacionParcialRespuesta aplicarCondonacionParcial(String uid, AplicarCondonacionParcialPeticion peticion);


	/**
	 * Realiza la condonaci�n parcial de un cr�dito
	 * @param uid identificador unico de la transaccion
	 * @param peticion
	 *             Incluye los datos necesarios para la condonacion en un arreglo de cadenas
	 *            [cr�dito],[capital],[inter�s],[recargo],[motivo]
	 *            y una cadena que se usaba como referencia para recibir el detalle de la operacion
	 * @return Resultado de la operacion
	 */
	AplicarCondonacionTotalRespuesta aplicarCondonacionTotal(String uid, AplicarCondonacionTotalPeticion peticion);


}
