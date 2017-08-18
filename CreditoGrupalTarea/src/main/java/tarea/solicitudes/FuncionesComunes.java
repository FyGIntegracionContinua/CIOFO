package tarea.solicitudes;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mi.mejorada
 *
 */
public class FuncionesComunes {

	/**
	 * Instantiates a new funciones comunes.
	 */
	public FuncionesComunes() {
	}
	/**
	 * @param producto codigo de producto
	 * @param financiada si es financiada
	 * @param express si es express
	 * @return tipificacion
	 */
	public static String tipificacionProductos( String producto, boolean financiada, boolean express) {
		String tipificacion = "";

		Map<String, String> mapCategoriaProductos		= new HashMap<String, String>();
		mapCategoriaProductos.put("GCS1", "C");
		mapCategoriaProductos.put("GCC1", "C");
		mapCategoriaProductos.put("GCM1", "C");
		mapCategoriaProductos.put("GES1", "C");
		mapCategoriaProductos.put("GIC1", "C");
		mapCategoriaProductos.put("GICN", "C");
		mapCategoriaProductos.put("GIS1", "C");
		mapCategoriaProductos.put("GCDG", "C");
		mapCategoriaProductos.put("GCDC", "C");
		mapCategoriaProductos.put("GSS1", "S");
		mapCategoriaProductos.put("GSC1", "S");
		mapCategoriaProductos.put("GOS1", "O");
		mapCategoriaProductos.put("GRES", "RS");

		if (mapCategoriaProductos.get(producto) == null) {
			tipificacion = producto;
		} else {
			tipificacion = mapCategoriaProductos.get(producto);
		}

		if (financiada) {
			tipificacion += "_F";
		}

		if (express) {
			tipificacion += "_X";
		}
		return tipificacion;
	}


	/**
	 * Validar fecha.
	 *
	 * @param valor the valor
	 * @return true, if successful
	 */
	public boolean validarFecha(Date valor) {
		Boolean res = true;
		Date valorFecha = valor;
		try {
			if (valorFecha == null) {
				res = false;
			}
		} catch (Exception e) {
			res = false;
		}
		return res;
	}

	/**
	 * Validar entero.
	 *
	 * @param valor the valor
	 * @return true, if successful
	 */
	public boolean validarEntero(Integer valor) {
		Boolean res = true;
		Integer valorEntero = valor;
		try {
			if (valorEntero == null || valorEntero < 0 ) {
				res = false;
			}
		} catch (Exception e) {
			res = false;
		}
		return res;
	}



	/**
	 * Validar string.
	 *
	 * @param miString the mi string
	 * @return the boolean
	 */
	public Boolean validarString(String miString) {
		Boolean res = true;
		String valorString = miString;
		try {
			if (valorString.trim().isEmpty() || valorString == null || valorString.equals(" ")) {
				res = false;
			}
		} catch (Exception e) {
			res = false;
		}
		return res;
	}

	/**
	 * Validar doble.
	 *
	 * @param valor the valor
	 * @return the boolean
	 */
	public Boolean validarDoble(Double valor) {
		Boolean res = true;
		Double valorDoble = valor;
		try {
			if (valorDoble == null || valorDoble.isInfinite() || valorDoble.isNaN() || valorDoble < 0) {
				res = false;
			}
		} catch (Exception e) {
			res = false;
		}
		return res;
	}

	/**
	 * Validar doble.
	 *
	 * @param valor the valor
	 * @return the boolean
	 */
	public Boolean validarDobleMayorCero(Double valor) {
		Boolean res = true;
		Double valorDoble = valor;
		try {
			if (valorDoble > 0) {
				res = true;
			} else {
				res = false;
			}
		} catch (Exception e) {
			res = false;
		}
		return res;
	}

	/**
	 * Validar entero mayor a cero.
	 *
	 * @param valor the valor
	 * @return true, if successful
	 */
	public boolean validarEnteroMayorCero(Integer valor) {
		Boolean res = true;
		Integer valorEntero = valor;
		try {
			if (valorEntero > 0) {
				res = true;
			}
			else {
				res = false;
			}
		} catch (Exception e) {
			res = false;
		}
		return res;
	}


}
