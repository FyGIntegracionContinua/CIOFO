/**
 *
 */
package utilitario.comun;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

import utilitario.log.LogHandler;
import utilitario.mensajes.originacion.consulta.ClientesGrupo;

/**
 * The Class Validaciones.
 *
 * @author out_ltorres
 */
public final class Validaciones {


	 /**
 	 * Fecha valida.
 	 *
 	 * @param fechaStr the fecha str
 	 * @return true, if successful
 	 */
 	public static boolean fechaValida(String fechaStr) {
	    if (fechaStr == null) {
	      return false;
	    }

	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

	    if (fechaStr.trim().length() != dateFormat.toPattern().length()) {
	      return false;
	    }

	    dateFormat.setLenient(false);

	    try {
	      dateFormat.parse(fechaStr.trim());
	    }
	    catch (ParseException pe) {
	      return false;
	    }
	    return true;
	 }


	 /**
	 * rfc v�lido.
	 *
	 * @param rfc the rfc str
	 * @return true, if successful
	 */
	public static boolean rfcValido(String rfc) {
	    if (rfc == null) {
	      return false;
	    }
	    if (rfc.trim().length() < Constantes.DIEZ ) {
	      return false;
	    }
	    return true;
	 }

	 /**
 	 * Datos requeridos.
 	 *
 	 * @param objeto the objeto
 	 * @return the string
 	 */
 	public static String datosRequeridos(Object objeto) {
	        try {
	            BeanInfo info;
	            info = Introspector.getBeanInfo(objeto.getClass());
	            for ( PropertyDescriptor pd : info.getPropertyDescriptors() ) {
	            	if (pd.getPropertyType().toString().equals("class java.lang.String")) {
            			if (pd.getReadMethod().invoke(objeto) == null || pd.getReadMethod().invoke(objeto).equals("")) {
            				return pd.getName().toString();
		            	}
            		}
            		else {
		            	if (pd.getReadMethod().invoke(objeto) == null) {
		            		return pd.getName().toString();
		            	}
            		}
	            }
	        } catch (IntrospectionException ex) {
	        	 return "";
	        } catch (IllegalAccessException ex) {
	        	 return "";
	        } catch (IllegalArgumentException ex) {
	        	 return "";
	        } catch (InvocationTargetException ex) {
	        	 return "";
	        }
	        return "";
	 }


	 /**
 	 * Datos requeridos.
 	 *
 	 * @param objeto the objeto
 	 * @param camposValidar the campos validar
 	 * @return the string
 	 */
 	public static String datosRequeridos(Object objeto, String[] camposValidar) {
	        try {
	        	Arrays.sort(camposValidar);
	            BeanInfo info;
	            info = Introspector.getBeanInfo(objeto.getClass());
	            for ( PropertyDescriptor pd : info.getPropertyDescriptors() ) {
	            	if (Arrays.binarySearch(camposValidar, pd.getName()) >= 0) {

	            		if (pd.getReadMethod().invoke(objeto) == null) {
		            		return pd.getName().toString();
		            	}
	            		else if (pd.getPropertyType().toString().equals("class java.lang.String")) {
	            			if (pd.getReadMethod().invoke(objeto).equals("")) {
			            		return pd.getName().toString();
			            	}
	            		}
	            	}
	            }
	        } catch (IntrospectionException ex) {
	        	 return "";
	        } catch (IllegalAccessException ex) {
	        	 return "";
	        } catch (IllegalArgumentException ex) {
	        	 return "";
	        } catch (InvocationTargetException ex) {
	        	 return "";
	        }
	        return "";
	 }

	 /**
	 * curp v�lido.
	 *
	 * @param curp the curp str
	 * @return true, if successful
	 */
 	public static boolean validarCURP(String curp) {
 		String regex =
 	    "[A-Z]{1}[A-Z]{1}[A-Z]{2}[0-9]{2}"
 	    + "(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])"
 	    + "[HM]{1}"
 		+ "(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)"
 	    + "[B-DF-HJ-NP-TV-Z]{3}"
 		+ "[0-9A-Z]{1}[0-9]{1}$";

 	    Pattern patron = Pattern.compile(regex);
 	    if (!patron.matcher(curp).matches()) {
 	    	return false;
 	    }
 	    	return true;
 	  }

	 /**
	 * codigo estado renapo.
	 *
	 * @param estado the estado str
	 * @return true, if successful
	 */
	public static String getCodigoRenapoEstado(String estado) {
		String codigo = "";
		estado = estado.toUpperCase();
		if (estado.equals("AGS")) {
			codigo = "AS";
		} else if (estado.equals("BC")) {
			codigo = "BC";
		} else if (estado.equals("BCS")) {
			codigo = "BS";
		} else if (estado.equals("CAM")) {
			codigo = "CC";
		} else if (estado.equals("COA")) {
			codigo = "CL";
		} else if (estado.equals("COL")) {
			codigo = "CM";
		} else if (estado.equals("CHS")) {
			codigo = "CS";
		} else if (estado.equals("CHI")) {
			codigo = "CH";
		} else if (estado.equals("DF")) {
			codigo = "DF";
		} else if (estado.equals("DGO")) {
			codigo = "DG";
		} else if (estado.equals("GTO")) {
			codigo = "GT";
		} else if (estado.equals("GRO")) {
			codigo = "GR";
		} else if (estado.equals("HGO")) {
			codigo = "HG";
		} else if (estado.equals("JAL")) {
			codigo = "JC";
		} else if (estado.equals("MEX")) {
			codigo = "MC";
		} else if (estado.equals("MIC")) {
			codigo = "MN";
		} else if (estado.equals("MOR")) {
			codigo = "MS";
		} else if (estado.equals("NAY")) {
			codigo = "NT";
		} else if (estado.equals("NL")) {
			codigo = "NL";
		} else if (estado.equals("OAX")) {
			codigo = "OC";
		} else if (estado.equals("PUE")) {
			codigo = "PL";
		} else if (estado.equals("QRO")) {
			codigo = "QT";
		} else if (estado.equals("QR")) {
			codigo = "QR";
		} else if (estado.equals("SLP")) {
			codigo = "SP";
		} else if (estado.equals("SIN")) {
			codigo = "SL";
		} else if (estado.equals("SON")) {
			codigo = "SR";
		} else if (estado.equals("TAB")) {
			codigo = "TC";
		} else if (estado.equals("TAM")) {
			codigo = "TS";
		} else if (estado.equals("TLA")) {
			codigo = "TL";
		} else if (estado.equals("VER")) {
			codigo = "VZ";
		} else if (estado.equals("YUC")) {
			codigo = "YN";
		} else if (estado.equals("ZAC")) {
			codigo = "ZS";
		} else {
			codigo = "NE";
		}
		return codigo;

	  }

	 /**
	 * estado v�lido.
	 *
	 * @param estado the estado str
	 * @return true, if successful
	 */
	public static boolean validarEstado(String estado) {
		estado = estado.toUpperCase();
		String regex =
		"(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)";
	    Pattern patron = Pattern.compile(regex);
	    if (!patron.matcher(estado).matches()) {
	    	return false;
	    }
	    	return true;
	  }

	 /**
	 * sexo v�lido.
	 *
	 * @param sexo the sexo str
	 * @return M|H, if successful
	 */
	public static String getSexoRenapo(String sexo) {
		sexo = sexo.toUpperCase();
		if (sexo.equals("F")) {
			sexo = "M";
		} else if (sexo.equals("M")) {
			sexo = "H";
		}
		return sexo;
	  }

	 /**
	 * sexo v�lido.
	 *
	 * @param sexo the sexo str
	 * @return true, if successful
	 */
	public static boolean validarSexo(String sexo) {
		String regex =
		"[HM]{1}";
	    Pattern patron = Pattern.compile(regex);
	    if (!patron.matcher(sexo).matches()) {
	    	return false;
	    }
	    	return true;
	  }
	/**
	 * Convertir la fecha de un fromato yyyy-MM-dd HH:mm:ss.SSSSSS aun.
	 * formato dd/MM/yyyy
	 * @param uid id de la transaccion
	 * @param fecha a convertir
	 * @param actual indica si se toma la fecha actual o la que viene en fecha
	 * @return Strin facha con fomato nuevo
	 */
	public static String convertirStringFecha(String uid, String fecha, boolean actual) {
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSSSS");
		SimpleDateFormat formatoNuevo = new SimpleDateFormat("dd/MM/yyyy");
		LogHandler.info(uid, Validaciones.class , "FechaActal: " + fecha);

		 String fechaNueva = null;
		 Date date = null;

		 if (actual) {
			    SimpleDateFormat formatoActual = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				date = new Date();
				fechaNueva = formatoActual.format(date);
			} else {
				try {
					 date = formato.parse(fecha);
					 fechaNueva = formatoNuevo.format(date);
				} catch (ParseException e) {
					 LogHandler.error(uid,  Validaciones.class, "ocurrio un error al parsear la fecha al nuevo formato", e);
				}
			}
		    LogHandler.info(uid,  Validaciones.class, "FechaNueva: " + fechaNueva);

		return fechaNueva;
	}
	/**
	 * Le da formato a la moneda.
	 * @param uid id d ela transaccion
	 * @param monto monto a fromatear
	 * @return String moneda formateada
	 */
	public static String formatoMoneda(String uid, double monto) {
		LogHandler.info(uid,  Validaciones.class, "Monto a fromatear: " + monto);
		Locale locale = new Locale("es", "MX");
		NumberFormat format = NumberFormat.getInstance(locale);
		String monedaFromateada = null;
		String resultado = null;
		format.setMaximumFractionDigits(2);
		monedaFromateada = format.format(monto);
		LogHandler.info(uid,  Validaciones.class, "Monto fromateado: " + monedaFromateada);

		if (monedaFromateada.contains(".")) {
			 String decimal = monedaFromateada.substring(monedaFromateada.indexOf("."), monedaFromateada.length());
			     if (decimal.length() == 2) {
			    	 resultado = monedaFromateada + "0";
			     } else {
			    	 resultado =  monedaFromateada;
			     }
			 } else {
				 resultado = monedaFromateada + ".00";
			 }
		return resultado;
	}
	/**
	 * metodo para eliminar elemntos de una lista por el numero de persona
	 * @param uid id de la transaccion
	 * @param lista lista de la cual se eliminaran datos
	 * @param numeroPersona que se eliminara d ela lista anterios
	 * @return List<ClientesGrupo> regresa la lista nueva despues de eliminar
	 */
	public static List<ClientesGrupo> eliminarIntegrantes(String uid, List<ClientesGrupo> lista, String numeroPersona) {
		if (lista != null) {
		LogHandler.info(uid,  Validaciones.class, "lista: " + lista.size() + "  numeroPersona: " + numeroPersona);
		for (int i = 0; i < lista.size(); i++) {
			  if (lista.get(i).getNumPersonaClienteGrupo().equals(numeroPersona)) {
				  lista.remove(lista.get(i));
				  break;
			  }
		   }
		LogHandler.info(uid,  Validaciones.class, "lista: " + lista.size());
		} else {
			LogHandler.info(uid,  Validaciones.class, "la lista es nula");
		}
		return lista;
	}

	/**
	 * Metodo que regresa una lista de codigos separandolos por el ;
	 * @param cadena a separar
	 * @param uid id de tansaccion.
	 * @return List<String> regersa la lista separada por ;
	 * @throws Exception puede lanzar una exception
	 */
	public static List<String> obtenerListaCodigos(String uid, String cadena) throws Exception {
		List<String> listCodigos = new ArrayList<String>();
		String[] codigos = null;

		if (cadena == null || cadena.isEmpty()) {
			throw new Exception("la cadena de codigos es null o vacia: " + cadena);
		}
		 codigos = cadena.split(";");

		 if (codigos == null) {
			 throw new Exception("el arreglo de codigos obtenido no tiene elementos: " + codigos);
		 } else {
			 listCodigos = Arrays.asList(codigos);
		 }
		 LogHandler.info(uid,  Validaciones.class, "obtenerListaCodigos: Lista de codigos: " + listCodigos );

		return listCodigos;
	}

	/**
	 * M&eacute;todo que nos devuelve el nivel de estrellas de un asesor
	 * @param estrellas estrellas
	 * @return String nivel de estrellas
	 */
	public static String nivelEstrellas (int estrellas) {
		String nivel = "";

        switch (estrellas) {
			case 1:
				nivel = "Nivel 1";
				break;
			case 2:
				nivel = "Nivel 2";
				break;
			case 3:
				nivel = "Nivel 3";
				break;
			case 4:
				nivel = "1";
				break;
			case 5:
				nivel = "2";
				break;
			case 6:
				nivel = "3";
				break;
			case 7:
				nivel = "4";
				break;
			case 8:
				nivel = "5";
				break;
			default:
				nivel = "-";
				break;
		}
        return nivel;
	}

	/**
	 * M&eacute;todo que carga el color de fondo de cada mop
     * @param uid identificador &uacute;nico de transacci&oacute;n
	 * @param mop mop a validar
	 * @return String color de fondo del mop
	 */
	public static String colorFondo(String uid, String mop) {
		String fondo = "background:rgb(255,255,255)";  // default es blanco
		if (mop.equals("96") || mop.equals("97") || mop.equals("99")) {
			fondo = "background:rgb(238,15,15)";  // color rojo
		} else if (mop.equals("04") || mop.equals("05") || mop.equals("06") || mop.equals("07")) {
			fondo = "background:rgb(255,116,1)";  //color es naranja
		} else if (mop.equals("02") || mop.equals("03")) {
			fondo = "background:rgb(253,255,0)";  //color es amarillo
		}
		return fondo;
	}
}
