package utilitario.comun;

import java.util.HashMap;
import java.util.Map;

/**
 * The Class DataMapperAdministracion.
 *
 * @author Juan Carlos Moreno
 */

public class DataMapperAdministracion {

	/** The map productos finsol. */
	public static Map<String, String> mapProductosFinsol = new HashMap<String, String>();

 	static {

		//Productos T24 -- CREDPROD
		mapProductosFinsol.put("GCS1", "21050" ); 	//CREDITO COMUNAL
		mapProductosFinsol.put("GCC1", "21057" ); 	//CREDITO COMUNAL FORTNIGHT
		mapProductosFinsol.put("GCM1", "21056"); 	//CREDITO COMUNAL MONTHLY
		mapProductosFinsol.put("GSS1", "21051"); 	//CREDITO GRUPO SOLIDARIO
		mapProductosFinsol.put("GSC1", "21059"); 	//CREDITO GRUPO SOLIDARIO FORNIGHT
		mapProductosFinsol.put("GOS1", "21060" ); 	//CREDITO OPORTUNIDAD
	}
}
