package utilitario.reglas.solicitudes;

import java.util.HashMap;

public class Response {

	/**
	 * Coloeccion.
	 */
	@SuppressWarnings("rawtypes")
	HashMap map = new HashMap();
	/**
	 * Resultado Coloeccion.
	 */
	private String result;
	/**
	 *  Constructor.	 */
	public Response()	{
	}
	/**
	 *  Obetener dato de la coleccion.
	 *  @return  dato de la coleccion.
	 *  */
	public String getResult()	{
		return result;
	}
	/**
	 *  Colocar dato de la coleeccion.	 */
	/**
	 * @param s resultado
	 */
	public void setResult(String s)	{
		result = s;
	}
	/**
	 *  Obtener coleeccion.
	 *  @return coleccion.
	 *  */
	@SuppressWarnings("rawtypes")
	public HashMap getMap()	{
		return map;
	}

}
