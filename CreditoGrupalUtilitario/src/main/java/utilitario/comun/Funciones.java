/**
 * Tensegrity - 2011
 */
package utilitario.comun;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * The Class Funciones.
 *
 * @author Juan Moreno
 * Funciones
 * <ul>
 *  <li>Obtener una cadena con consecutivo del ld contrato</li>
 *  <li>Obtener el fortmato el prefijo del numero ld_contrato</li>
 *  <li></li>
 * </ul>
 */

public final class Funciones {

	/** The Constant FORMATO_LD. */
	private static final String FORMATO_LD 				= "'LD'yyDDD";

	/** The Constant FORMATO_CONSECUTIVO_LD. */
	private static final String FORMATO_CONSECUTIVO_LD 	= "%05d";

	/**
	 * Se crea un constructor privado para evitar, que se creen objetos de
	 * la clase.
	 */
	private Funciones() {

	}

	/**
	 * Obtiene el prefijo para el campo ld_contrato.
	 * LD mas a�o en 2 digitos mas el dia del a�o en 3 digitos
	 *
	 * @param fecha the fecha
	 * @return prefijo ld_contrato
	 */
	public static final String obtenerPrefijoLD( java.util.Date fecha ) {
		SimpleDateFormat	formateador	= new SimpleDateFormat( FORMATO_LD );
		return formateador.format( fecha );
	}

	/**
	 * Obtene el consecutivo del numero ld_contrato (5 digitos).
	 *
	 * @param consecutivo the consecutivo
	 * @return the string
	 */
	public static final String formatoConsecutivoLDContrato( Integer consecutivo ) {
		return String.format(FORMATO_CONSECUTIVO_LD, consecutivo );
	}

	/**
	 * Formatea una cadena agregandole ceros a la derecha.
	 *
	 * @param s the s
	 * @param n the n
	 * @return the string
	 * @SuppressWarnings("static-access") 	public static String padRightZeros(String s, int n) {
	 * 		final java.text.MessageFormat messageFormat = new MessageFormat(  );
	 * 		return decimalFormat.format( Double.parseDouble( s ) );
	 * 		return  ( "".format("%1$-" + n + "s", s).replaceAll(" ", "0") );
	 * 	}
	 */

	/**
	 * Formatea una cadena agregandole ceros a la izquierda
	 * @param s String
	 * @param n int
	 * @return s String
	 */
	public static String padLeftZeros(String s, int n) {
		final DecimalFormat decimalFormat = new DecimalFormat( "00000000" );
		return decimalFormat.format( Double.parseDouble( s ) );
		//Se cambio porq la jvm de produccion no soporto la mascara para formatear la cadena
		//return  ( "".format("%1$#" + n + "s", s).replaceAll(" ", "0") );
		}

	/**
	 * Redondeo.
	 *
	 * @param numero the numero
	 * @return the java.lang. double
	 */
	public static java.lang.Double redondeo( Double numero ) {
		return Math.rint(numero * Constantes.CENTENA) / Constantes.CENTENA;
	}

	/** The Constant CADENA_FIJA_BANCOMER. */
	static final String CADENA_FIJA_BANCOMER 		= "212121212";

	/** The Constant MAXIMO_DECENAS. */
	static final int    MAXIMO_DECENAS 			    = 11;

	/** The Constant YBANAMEX_SUC. */
	static final String YBANAMEX_SUC 				= "0165";

	/** The Constant YBANAMEX_CTA. */
	static final String YBANAMEX_CTA 				= "7840897";

	/** The Constant YBANAMEX_SUC_DG. */
	static final String YBANAMEX_SUC_DG 				= "4337";

	/** The Constant YBANAMEX_CTA_DG. */
	static final String YBANAMEX_CTA_DG 				= "0165581";

	/** The Constant YCONST_REF_BANAMEX. */
	static final String YCONST_REF_BANAMEX 		    = "000000008";

	/** The Constant YALFANUMERICA_BANAMEX. */
	static final String YALFANUMERICA_BANAMEX  	    = "T";

	/** The Constant YPONDERADOR2. */
	static final int 	YPONDERADOR2 				= 97;

	/** The Constant YPONDERADOR3. */
	static final int 	YPONDERADOR3 				= 99;

	/** The Constant YPONDERADORES1. */
	static final int[]  YPONDERADORES1 = {23, 29, 31, 37, 13, 17, 19, 23, 29, 31, 37, 19, 23,
		29, 31, 37, 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};

	//Se agregan constantes para referenciasSeguros

	/**
	 * CONVENIOHSBC
	 */
	static final String CONVENIOHSBC = "80";

	/**
	 * CONVENIOHSBC
	 */
	static final String IDSEGUROHSBC = "04";

	/**
	 * CONVENIOHSBC
	 */
	static final String IDSEGUROBANAMEX = "43D";


	/**
	 * Obtener cadena banamex.
	 *
	 * @param contratoLD the contrato ld
	 * @return the string
	 */
	public static String obtenerCadenaBanamex(String contratoLD) {
		String yReferencia = "";
		String contratoArmado = "";
		int ySumatoria = 0;
		int yResultado2 = 0;
		int yResultado3 = 0;
		int yVerDigit	= 0;
		String youtRefNum = "";
		for (int i = contratoLD.length() - 1; i >= 3; i--) {
			contratoArmado = contratoArmado + contratoLD.charAt(i) + "";
		}
		StringBuilder contrato = new StringBuilder(contratoArmado);
		contrato.reverse().toString();

		yReferencia = YBANAMEX_SUC + YBANAMEX_CTA + YCONST_REF_BANAMEX + contrato;
		if (yReferencia.length() == YPONDERADORES1.length) {
			for (int i = 0; i < YPONDERADORES1.length; i++) {
				ySumatoria = ySumatoria + (Integer.parseInt(String.valueOf(yReferencia.charAt(i)))
						* YPONDERADORES1[i]);
			}
			yResultado2 = ySumatoria / YPONDERADOR2;
			yResultado3 = ySumatoria - (yResultado2 * YPONDERADOR2);
			yVerDigit   = YPONDERADOR3 - yResultado3;
			youtRefNum = yVerDigit + "";
			if (youtRefNum.length() == 1) {
				youtRefNum = "0" + youtRefNum + "";
			}

			return YALFANUMERICA_BANAMEX + contrato + youtRefNum;
		} else {
			return "ERROR AL CALCULAR LA CUENTA BANAMEX, LOS DATOS NO COINCIDEN";
		}
	}

	/**
	 * Obtener cadena banamex deposito garantia.
	 *
	 * @param contratoLD the contrato ld
	 * @return the string
	 */
	public static String obtenerCadenaBanamexDepositoGarantia(String contratoLD) {
		String yReferencia = "";
		String contratoArmado = "";
		int ySumatoria = 0;
		int yResultado2 = 0;
		int yResultado3 = 0;
		int yVerDigit	= 0;
		String youtRefNum = "";
		for (int i = contratoLD.length() - 1; i >= 3; i--) {
			contratoArmado = contratoArmado + contratoLD.charAt(i) + "";
		}
		StringBuilder contrato = new StringBuilder(contratoArmado);
		contrato.reverse().toString();
		yReferencia = YBANAMEX_SUC_DG + YBANAMEX_CTA_DG + YCONST_REF_BANAMEX + contrato;

		if (yReferencia.length() == YPONDERADORES1.length) {
			for (int i = 0; i < YPONDERADORES1.length; i++) {
				ySumatoria = ySumatoria + (Integer.parseInt(String.valueOf(yReferencia.charAt(i)))
						* YPONDERADORES1[i]);
			}


			yResultado2 = ySumatoria / YPONDERADOR2;
			yResultado3 = ySumatoria - (yResultado2 * YPONDERADOR2);
			yVerDigit   = YPONDERADOR3 - yResultado3;
			youtRefNum = yVerDigit + "";
			if (youtRefNum.length() == 1) {
				youtRefNum = "0" + youtRefNum + "";
			}

			return YALFANUMERICA_BANAMEX + contrato + youtRefNum;
		} else {
			return "ERROR AL CALCULAR LA CUENTA BANAMEX, LOS DATOS NO COINCIDEN";
		}
	}

	/**
	 * Obtener cadena bancomer.
	 *
	 * @param contratoLD the contrato ld
	 * @return the string
	 */
	public static String obtenerCadenaBancomer(String contratoLD) {
		int digitoVerificador = 0;
		int resultadoAux = 0;
		float aux = 0.0f;
		String contratoArmado = "";
		String cadena = "";
		int aux2 = 0;
		for (int i = contratoLD.length() - 1; i >= 3; i--) {
			contratoArmado = contratoArmado + contratoLD.charAt(i) + "";
		}
		StringBuilder contrato = new StringBuilder(contratoArmado);
		contrato.reverse();
		if (CADENA_FIJA_BANCOMER.length() == contrato.length()) {
			for (int i = 0; i < CADENA_FIJA_BANCOMER.length(); i++) {
				digitoVerificador = Integer.parseInt(String.valueOf(CADENA_FIJA_BANCOMER.charAt(i)))
						* Integer.parseInt(String.valueOf(contrato.charAt(i)));
				cadena = cadena + digitoVerificador + "";
			  }
			digitoVerificador = 0;
			aux2 = cadena.length();

			for (int i = 0; i < aux2; i++) {

				digitoVerificador = digitoVerificador + (Integer.parseInt(String.valueOf(cadena.charAt(i))));
			}
			resultadoAux = digitoVerificador;
			for (int i = 1; i < MAXIMO_DECENAS; i++) {
				resultadoAux = resultadoAux + 1;
				aux = resultadoAux % 10;
				if (aux == 0.0) {
					int dVerificador = resultadoAux - digitoVerificador;
					digitoVerificador = dVerificador;
					if ( digitoVerificador == 10 ) {	digitoVerificador = 0;	}
				}
			}

		String cuentaBancomer = contrato.toString() + digitoVerificador;
		return cuentaBancomer;
		} else {
			return "ERROR AL CALCULAR LA CUENTA BANCOMER, LOS DATOS NO COINCIDEN";
		}
	}


	 /**
 	 * Es entero.
 	 *
 	 * @param cad the cad
 	 * @return true, if successful
 	 */
 	public static boolean esEntero(String cad) {
		 for (int i = 0; i < cad.length(); i++) {
			 if ( !Character.isDigit(cad.charAt(i)) ) {
				 return false;
			 }
		 }
		 return true;
	 }

	 /**
 	 * Calculo anios.
 	 *
 	 * @param fecha the fecha
 	 * @return the integer
 	 */
 	public static Integer calculoAnios( java.util.Date fecha) {
		 	java.util.Date fechaActual = new java.util.Date();
		    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		    String hoy = formato.format(fechaActual);
		    String fechaNac = formato.format(fecha);
		    String[] dat1 = fechaNac.split("/");
		    String[] dat2 = hoy.split("/");
		    int anos = Integer.parseInt(dat2[2]) - Integer.parseInt(dat1[2]);
		    int mes = Integer.parseInt(dat2[1]) - Integer.parseInt(dat1[1]);
		    if (mes < 0) {
		      anos = anos - 1;
		    } else if (mes == 0) {
		      int dia = Integer.parseInt(dat2[0]) - Integer.parseInt(dat1[0]);
		      if (dia > 0) {
		        anos = anos - 1;
		      }
		    }
		    return anos;

	 }



	 /**
 	 * Object to hash map insert.
 	 *
 	 * @param objeto the objeto
 	 * @return the java.util. hash map
 	 */
 	public static java.util.HashMap<String, Object> objectToHashMapInsert(Object objeto)
	    {
	        java.util.HashMap<String, Object> hashMapReturn = new java.util.HashMap<String, Object>();
	        Calendar fechaInicio = Calendar.getInstance();
	        fechaInicio.set(1900, 1, 1, 0, 0, 0);
	        try {
	            BeanInfo info;
	            info = Introspector.getBeanInfo(objeto.getClass());
	            for ( PropertyDescriptor pd : info.getPropertyDescriptors() ) {

	                if (pd.getPropertyType().toString().equals("class java.lang.String")) {
	                    hashMapReturn.put(pd.getName(), pd.getReadMethod().invoke(objeto) != null
	                    		? pd.getReadMethod().invoke(objeto) : "");
	                }
	                else if (pd.getPropertyType().toString().equals("class java.lang.Byte")
	                		|| pd.getPropertyType().toString().equals("class java.lang.Short")
	                		|| pd.getPropertyType().toString().equals("class java.lang.Integer")
	                		|| pd.getPropertyType().toString().equals("class java.lang.Long")) {
	                    hashMapReturn.put(pd.getName(), pd.getReadMethod().invoke(objeto) != null
	                    		? pd.getReadMethod().invoke(objeto) : 0);
	                }
	                else if (pd.getPropertyType().toString().equals("class java.util.Date")) {
	                    hashMapReturn.put(pd.getName(), pd.getReadMethod().invoke(objeto) != null
	                    		? pd.getReadMethod().invoke(objeto) : fechaInicio.getTime());
	                }
	                else if (pd.getPropertyType().toString().equals("class java.lang.Float")
	                		|| pd.getPropertyType().toString().equals("class java.lang.Double")) {
	                    hashMapReturn.put(pd.getName(), pd.getReadMethod().invoke(objeto) != null
	                    		? pd.getReadMethod().invoke(objeto) : 0.0);
	                }
	                else {
	                	hashMapReturn.put(pd.getName(),  pd.getReadMethod().invoke(objeto));
	                }


	            //if(pd.getReadMethod().invoke(objeto) instanceof String)
	            //hashMapReturn.put(pd.getName(), pd.getReadMethod().invoke(objeto) != null
	                //? pd.getReadMethod().invoke(objeto) : "");

	            }
	        } catch (IntrospectionException ex) {
	        	return null;
	        } catch (IllegalAccessException ex) {
	        	return null;
	        } catch (IllegalArgumentException ex) {
	        	return null;
	        } catch (InvocationTargetException ex) {
	        	return null;
	        }
	        return hashMapReturn;
	    }



		/**
		 * Object to hash map update.
		 *
		 * @param objeto the objeto
		 * @return the java.util. hash map
		 */
		public static java.util.HashMap<String, Object> objectToHashMapUpdate(Object objeto)
	    {
	        java.util.HashMap<String, Object> hashMapReturn = new java.util.HashMap<String, Object>();
	        try {
	            BeanInfo info;
	            info = Introspector.getBeanInfo(objeto.getClass());
	            for ( PropertyDescriptor pd : info.getPropertyDescriptors() ) {
	            	if (pd.getReadMethod().invoke(objeto) != null) {
	            		hashMapReturn.put(pd.getName(),  pd.getReadMethod().invoke(objeto));
	            	}
	            }
	        } catch (IntrospectionException ex) {
	        	return null;
	        } catch (IllegalAccessException ex) {
	        	return null;
	        } catch (IllegalArgumentException ex) {
	        	return null;
	        } catch (InvocationTargetException ex) {
	        	return null;
	        }
	        return hashMapReturn;
	    }


		/**
		 * Validar fecha.
		 *
		 * @param valor the valor
		 * @return true, if successful
		 */
		public static Boolean validarFecha(Date valor) {
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
		public static Boolean validarEntero(Integer valor) {
			Boolean res = true;
			Integer valorEntero = valor;
			try {
				if (valorEntero == null || valorEntero < 0) {
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
		public static Boolean validarString(String miString) {
			Boolean res = true;
			String valorString = miString;
			try {
				if (valorString.trim().isEmpty() || valorString == null || valorString.equals(" ")
						|| valorString.trim().equals("")) {
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
		public static Boolean validarDoble(Double valor) {
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
}



