package tarea.seguros;

import utilitario.mensajes.seguros.BeneficiariosClienteOV;
import utilitario.mensajes.seguros.PeticionConsulta;
import utilitario.mensajes.seguros.SegurosRespuesta;
import utilitario.mensajes.seguros.SegurosRespuestaConsulta;

/**
 * Interfaz para buro interno
 * @author rguadarramac
 * @version 1.0
 */
public interface SegurosTarea {


	/**
	 * Metodo de insercion de datos de Seguros
	 * @param uid tipo String
	 * @param peticion BeneficiariosClienteOV
	 * @return respuesta
	 */
	SegurosRespuesta modificaSegurosBeneficiariosTarea(String uid, BeneficiariosClienteOV peticion);

	/**
	 * Metodo de consulta de datos de Seguros
	 * @param uid String
	 * @param peticion PeticionConsulta
	 * @return respuesta
	 */
	SegurosRespuestaConsulta consultaSegurosBeneficiariosTarea(String uid, PeticionConsulta peticion);


	SegurosRespuestaConsulta consultaPersonaBeneficiarios(String uid, PeticionConsulta peticion);

}
