package utilitario.comun;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import utilitario.mensajes.consultas.ObtenerReferenciasPagoPeticion;

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

public final class ReferenciasBancarias {

	/**
	 * Se crea un constructor privado para evitar, que se creen objetos de
	 * la clase.
	 */
	private ReferenciasBancarias() {

		}


	/** The Constant CADENA_FIJA_BANCOMER. */
	static final String CADENA_FIJA_BANCOMER 		= "212121212";

	/** The Constant MAXIMO_DECENAS. */
	static final int    MAXIMO_DECENAS 			    = 11;

	/** The Constant YBANAMEX_SUC. */
	static final String YBANAMEX_SUC 				= "0165";

	/** The Constant YBANAMEX_CTA. */
	static final String YBANAMEX_CTA 				= "7840897";

	/** The Constant FISA_CTA. */
	static final String FISA_CTA 					= "7881763";

	/** The Constant YPONDERADOR2. */
	static final int 	YPONDERADOR2 				= 97;

	/** The Constant YPONDERADOR3. */
	static final int 	YPONDERADOR3 				= 99;

	/** The Constant YPONDERADORES1. */
	static final int[]  YPONDERADORES1 = {23, 29, 31, 37, 13, 17, 19, 23, 29, 31, 37, 19, 23,
		29, 31, 37, 1, 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37};

	//Se agregan constantes para referenciasSeguros
	/** The Constant convenioHsbc. */
	static final String CONVENIO_HSBC = "80";
	/** The Constant idSegurosHsbc. */
	static final String ID_SEGUROS_HSBC = "04";
	/** The Constant idSegurosBanamex. */
	static final String ID_SEGUROS_BANAMEX = "43D";
	/** The Constant idSegurosHsbc. */
	static final String ID_SEGUROS_ENFERMEDAD_HSBC = "05";
	/** The Constant idSegurosBanamex. */
	static final String ID_SEGUROS_ENFERMEDAD_BANAMEX = "43E";
	/** The Constant LONGITUD_MINIMA_PESONA. */
	static final int LONGITUD_MINIMA_PESONA	= 11;
	/** The Constant Empresa*/
	static final String EMPRESA = "2";
	/** The Constant producto vida*/
	static final String PRODUCTO_VIDA = "02";
	/** The Constant PRODUCTO_ENFERMEDAD */
	static final String PRODUCTO_ENFERMEDAD = "04";
	/** The Constant LIBRE*/
	static final String LIBRE = "0000";
	/**
	* Obtener cadena obtenerCadenaHsbc.
	*
	* @param peticion tipo ObtenerReferenciasPagoPeticion
	* @return the string
	*/
	public static String obtenerCadenaHsbc(ObtenerReferenciasPagoPeticion peticion) {
			String referenciaHsbc = "";
			String numPersonaHsbc = peticion.getNumPersona();
			Calendar miFecha = Calendar.getInstance();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyMMdd" );
			DecimalFormat formateador = new DecimalFormat("0000000");

			double montoHsbc = peticion.getMonto().intValue();

			for (int i = 0; i < numPersonaHsbc.length(); i++) {
				if (numPersonaHsbc.length() <= LONGITUD_MINIMA_PESONA) {
					numPersonaHsbc = "0" + numPersonaHsbc;
				}
			}

			referenciaHsbc = CONVENIO_HSBC + ID_SEGUROS_HSBC + numPersonaHsbc
					+ simpleDateFormat.format(miFecha.getTime()) + formateador.format(montoHsbc);

			return referenciaHsbc;
	}

	/**
	* Obtener cadena obtenerCadenaHsbc.
	*
	* @param peticion tipo ObtenerReferenciasPagoPeticion
	* @return the string
	*/
	public static String obtenerCadenaHsbcSegurosEnfermedad(ObtenerReferenciasPagoPeticion peticion) {
			String referenciaHsbc = "";
			String numPersonaHsbc = peticion.getNumPersona();
			Calendar miFecha = Calendar.getInstance();
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyMMdd" );
			DecimalFormat formateador = new DecimalFormat("0000000");

			double montoHsbc = peticion.getMonto().intValue();

			for (int i = 0; i < numPersonaHsbc.length(); i++) {
				if (numPersonaHsbc.length() <= LONGITUD_MINIMA_PESONA) {
					numPersonaHsbc = "0" + numPersonaHsbc;
				}
			}

			referenciaHsbc = CONVENIO_HSBC + ID_SEGUROS_ENFERMEDAD_HSBC + numPersonaHsbc
					+ simpleDateFormat.format(miFecha.getTime()) + formateador.format(montoHsbc);

			return referenciaHsbc;
		}

	/**
	 * Obtener referencia banamex.
	 * @param peticion the peticion
	 * @return the string
	 */
	public static String obtenerReferenciaBanamex(ObtenerReferenciasPagoPeticion peticion) {
		String referenciaBancaria = "";
		String numPersonaIndep = peticion.getNumPersona();
		String numPersonaIndep2 = numPersonaIndep;
		String numSucursalIndep = peticion.getNumSucursal();
		String idSegIndep = ID_SEGUROS_BANAMEX;

		numPersonaIndep = verificaCadenaPonderadorAlfabetico97(numPersonaIndep);
		for (int i = 0; i < numPersonaIndep2.length(); i++) {
			if (numPersonaIndep2.length() <= LONGITUD_MINIMA_PESONA) {
				numPersonaIndep2 = "0" + numPersonaIndep2;
			}
		}

		referenciaBancaria = numSucursalIndep + idSegIndep + numPersonaIndep2;
		String referenciaCalculada = calcularReferenciaBancaria(YBANAMEX_SUC, YBANAMEX_CTA, referenciaBancaria);
		if (referenciaCalculada != null) {
			return referenciaCalculada;
		} else {
			return "ERROR AL CALCULAR LA CUENTA BANCOMER, LOS DATOS NO COINCIDEN";
		}
	}

	/**
	 * Obtener referencia banamex.
	 * @param peticion the peticion
	 * @return the string
	 */
	public static String obtenerReferenciaBanamexSegurosEnfermedad(ObtenerReferenciasPagoPeticion peticion) {
		String referenciaBancaria = "";
		String numPersonaIndep = peticion.getNumPersona();
		String numPersonaIndep2 = numPersonaIndep;
		String numSucursalIndep = peticion.getNumSucursal();
		String idSegIndep = ID_SEGUROS_ENFERMEDAD_BANAMEX;
		numPersonaIndep = verificaCadenaPonderadorAlfabetico97(numPersonaIndep);
		for (int i = 0; i < numPersonaIndep2.length(); i++) {
			if (numPersonaIndep2.length() <= LONGITUD_MINIMA_PESONA) {
				numPersonaIndep2 = "0" + numPersonaIndep2;
			}
		}
		referenciaBancaria = numSucursalIndep + idSegIndep + numPersonaIndep2;
		String referenciaCalculada = calcularReferenciaBancaria(YBANAMEX_SUC, YBANAMEX_CTA, referenciaBancaria);
		if (referenciaCalculada != null) {
			return referenciaCalculada;
		} else {
			return "ERROR AL CALCULAR LA CUENTA BANCOMER, LOS DATOS NO COINCIDEN";
		}
	}


	/**
	 * Obtener referencia bancomer.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public static String obtenerReferenciaBancomer(ObtenerReferenciasPagoPeticion peticion) {
		String referenciaBancaria = "";
		String numPersonaIndep = peticion.getNumPersona();
		String numPersonaIndep2 = numPersonaIndep;
		String numSucursalIndep = peticion.getNumSucursal();
		String idSegIndep = ID_SEGUROS_BANAMEX;
		for (int i = 0; i < numPersonaIndep2.length(); i++) {
			if (numPersonaIndep2.length() <= LONGITUD_MINIMA_PESONA) {
				numPersonaIndep2 = "0" + numPersonaIndep2;
			}
		}
		referenciaBancaria = numSucursalIndep + idSegIndep + numPersonaIndep2 + "0";

		if (referenciaBancaria.equals("")) {
			return "";
		} else {
			return referenciaBancaria;
		}
	}

	/**
	 * Obtener referencia bancomer.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public static String obtenerReferenciaBancomerSegurosEnfermedad(ObtenerReferenciasPagoPeticion peticion) {
		String referenciaBancaria = "";
		String numPersonaIndep = peticion.getNumPersona();
		String numPersonaIndep2 = numPersonaIndep;
		String numSucursalIndep = peticion.getNumSucursal();
		String idSegIndep = ID_SEGUROS_ENFERMEDAD_BANAMEX;
		for (int i = 0; i < numPersonaIndep2.length(); i++) {
			if (numPersonaIndep2.length() <= LONGITUD_MINIMA_PESONA) {
				numPersonaIndep2 = "0" + numPersonaIndep2;
			}
		}
		referenciaBancaria = numSucursalIndep + idSegIndep + numPersonaIndep2 + "0";

		if (referenciaBancaria.equals("")) {
			return "";
		} else {
			return referenciaBancaria;
		}
	}

	/**
	 * Obtener referencia banamex.
	 * @param peticion the peticion
	 * @return the string
	 */
	public static String obtenerReferenciaFisa(ObtenerReferenciasPagoPeticion peticion) {
			String referenciaBancaria = "";
			String numPersonaIndep = peticion.getNumPersona();
			String numPersonaIndep2 = numPersonaIndep;
			String numSucursalIndep = peticion.getNumSucursal();
			String idSegIndep = ID_SEGUROS_BANAMEX;

			numPersonaIndep = verificaCadenaPonderadorAlfabetico97(numPersonaIndep);

			for (int i = 0; i < numPersonaIndep2.length(); i++) {
				if (numPersonaIndep2.length() <= LONGITUD_MINIMA_PESONA) {
					numPersonaIndep2 = "0" + numPersonaIndep2;
				}
			}

			referenciaBancaria = numSucursalIndep + idSegIndep + numPersonaIndep2;
			String referenciaCalculada = calcularReferenciaBancaria(YBANAMEX_SUC, FISA_CTA, referenciaBancaria);

			if (referenciaCalculada != null) {
				return referenciaCalculada;
			} else {
				return "ERROR AL CALCULAR LA CUENTA BANCOMER, LOS DATOS NO COINCIDEN";
			}
	}

	/**
	 * Obtener referencia banamex.
	 * @param peticion the peticion
	 * @return the string
	 */
	public static String obtenerReferenciaFisaSegurosEnfermedad(ObtenerReferenciasPagoPeticion peticion) {
			String referenciaBancaria = "";
			String numPersonaIndep = peticion.getNumPersona();
			String numPersonaIndep2 = numPersonaIndep;
			String numSucursalIndep = peticion.getNumSucursal();
			String idSegIndep = ID_SEGUROS_ENFERMEDAD_BANAMEX;

			numPersonaIndep = verificaCadenaPonderadorAlfabetico97(numPersonaIndep);

			for (int i = 0; i < numPersonaIndep2.length(); i++) {
				if (numPersonaIndep2.length() <= LONGITUD_MINIMA_PESONA) {
					numPersonaIndep2 = "0" + numPersonaIndep2;
				}
			}

			referenciaBancaria = numSucursalIndep + idSegIndep + numPersonaIndep2;
			String referenciaCalculada = calcularReferenciaBancaria(YBANAMEX_SUC, FISA_CTA, referenciaBancaria);

			if (referenciaCalculada != null) {
				return referenciaCalculada;
			} else {
				return "ERROR AL CALCULAR LA CUENTA BANCOMER, LOS DATOS NO COINCIDEN";
			}
	}

	/**
	 * Obtener referencia de Diestel para Seguro de Vida.
	 * @param peticion the peticion
	 * @return the string
	 */
	public static String obtenerReferenciaFisaSegurosVidaDiestel(ObtenerReferenciasPagoPeticion peticion) {

		String cadenaDiestelVida = null;

		//Se agregan los ceros a la izquierda del numero de contrato AOC
		for (int i = peticion.getNumPersona().length(); i < 12; i++) {
			peticion.setNumPersona("0" + peticion.getNumPersona());
		}

		cadenaDiestelVida =  EMPRESA + PRODUCTO_VIDA + LIBRE + peticion.getNumPersona();

		return cadenaDiestelVida;

	}

	/**
	 * Obtener referencia de Diestel para Seguro de Enfermedad.
	 * @param peticion the peticion
	 * @return the string
	 */
	public static String obtenerReferenciaFisaSegurosEnfermedadDiestel(ObtenerReferenciasPagoPeticion peticion) {

		String cadenaDiestelEnfermedad = null;

		//Se agregan los ceros a la izquierda del numero de contrato AOC
		for (int i = peticion.getNumPersona().length(); i < 12; i++) {
			peticion.setNumPersona("0" + peticion.getNumPersona());
		}

		cadenaDiestelEnfermedad =  EMPRESA + PRODUCTO_ENFERMEDAD + LIBRE + peticion.getNumPersona();

		return cadenaDiestelEnfermedad;

	}
	/**
	 * Calcular referencia bancaria.
	 * @param sucursalBancaria the sucursal bancaria
	 * @param cuentaBancaria the cuenta bancaria
	 * @param referenciaBancaria the referencia bancaria
	 * @return the string
	 */
	public static String calcularReferenciaBancaria( String sucursalBancaria, String cuentaBancaria, String referenciaBancaria) {
		int ySumatoria = 0;
		int yResultado2 = 0;
		int yResultado3 = 0;
		int yVerDigit	= 0;
		String youtRefNum = "";
		String referenciaTotal;


		if (referenciaBancaria.length() == 18) {

			String numReferenciaBancaria = sucursalBancaria + cuentaBancaria +  referenciaBancaria;


			String numReferenciaBancariaVerificado = verificaCadenaPonderadorAlfabetico97(numReferenciaBancaria);


			if (numReferenciaBancariaVerificado.length() < 28) {
				for (int i = 0; i < numReferenciaBancariaVerificado.length(); i++) {
					if (numReferenciaBancariaVerificado.length() <= 28) {
						numReferenciaBancariaVerificado = "0" + numReferenciaBancariaVerificado;
					}
				}
			}


				if (numReferenciaBancariaVerificado.length() == YPONDERADORES1.length) {
					for (int i = 0; i < YPONDERADORES1.length; i++) {
						ySumatoria = ySumatoria + (Integer.parseInt(String.valueOf(numReferenciaBancariaVerificado.charAt(i)))
								* YPONDERADORES1[i]);
					}

					yResultado2 = ySumatoria / YPONDERADOR2;
					yResultado3 = ySumatoria - (yResultado2 * YPONDERADOR2);					

					yVerDigit   = YPONDERADOR3 - yResultado3;
					youtRefNum = yVerDigit + "";
					if (youtRefNum.length() == 1) {
						youtRefNum = "0" + youtRefNum;
					}

					referenciaTotal = referenciaBancaria + youtRefNum;

					return referenciaTotal;
				} else {
					return "ERROR AL CALCULAR LA REFERENCIA, LOS DATOS NO COINCIDEN 1";
				}
		} else {

		String numReferenciaBancaria = referenciaBancaria;
		String numSucursalBancaria = sucursalBancaria;
		String numCuentaBancaria = cuentaBancaria;


			if (numReferenciaBancaria.length() < 17) {
				for (int i = 0; i < numReferenciaBancaria.length(); i++) {
					if (numReferenciaBancaria.length() <= 17) {
						numReferenciaBancaria = "0" + numReferenciaBancaria;
					}
				}
			}

			String numReferenciaBancaria2 = numSucursalBancaria + numCuentaBancaria + numReferenciaBancaria;

			String numReferenciaBancariaVerificado = verificaCadenaPonderadorAlfabetico97(numReferenciaBancaria2);

				if (numReferenciaBancariaVerificado.length() == YPONDERADORES1.length) {
					for (int i = 0; i < YPONDERADORES1.length; i++) {
						ySumatoria = ySumatoria + (Integer.parseInt(String.valueOf(numReferenciaBancariaVerificado.charAt(i)))
								* YPONDERADORES1[i]);
					}



					yResultado2 = ySumatoria / YPONDERADOR2;
					yResultado3 = ySumatoria - (yResultado2 * YPONDERADOR2);
					yVerDigit   = YPONDERADOR3 - yResultado3;
					youtRefNum = yVerDigit + "";
					if (youtRefNum.length() == 1) {
						youtRefNum = "0" + youtRefNum + "";
					}

					referenciaTotal = numReferenciaBancaria + youtRefNum;

					return referenciaTotal;
				} else {
					return "ERROR AL CALCULAR LA REFERENCIA, LOS DATOS NO COINCIDEN 2";
				}
		   }

		}


		/**
		 * Verifica cadena ponderador alfabetico.
		 *
		 * @param cadena the cadena
		 * @return the string
		 */
		public static String verificaCadenaPonderadorAlfabetico(String cadena) {
			// compilamos el patron
			Pattern patron1 = Pattern.compile("A|J");
			// creamos el Matcher a partir del patron, la cadena como parametro
			Matcher encaja = patron1.matcher(cadena);
			// invocamos el metodo replaceAll
			String resultado = encaja.replaceAll("1");

			Pattern patron2 = Pattern.compile("B|K|S");
			Matcher encaja2 = patron2.matcher(resultado);
			resultado = encaja2.replaceAll("2");


			Pattern patron3 = Pattern.compile("C|L|T");
			Matcher encaja3 = patron3.matcher(resultado);
			resultado = encaja3.replaceAll("3");


			Pattern patron4 = Pattern.compile("D|M|U");
			Matcher encaja4 = patron4.matcher(resultado);
			resultado = encaja4.replaceAll("4");

			Pattern patron5 = Pattern.compile("E|N|V");
			Matcher encaja5 = patron5.matcher(resultado);
			resultado = encaja5.replaceAll("5");

			Pattern patron6 = Pattern.compile("F|O|W");
			Matcher encaja6 = patron6.matcher(resultado);
			resultado = encaja6.replaceAll("6");

			Pattern patron7 = Pattern.compile("G|P|X");
			Matcher encaja7 = patron7.matcher(resultado);
			resultado = encaja7.replaceAll("7");

			Pattern patron8 = Pattern.compile("H|Q|Y");
			Matcher encaja8 = patron8.matcher(resultado);
			resultado = encaja8.replaceAll("8");

			Pattern patron9 = Pattern.compile("I|R|Z");
			Matcher encaja9 = patron9.matcher(resultado);
			resultado = encaja9.replaceAll("9");

			return resultado;
		}

		/**
		 * Verifica cadena ponderador alfabetico97.
		 *
		 * @param cadena the cadena
		 * @return the string
		 */
		public static String verificaCadenaPonderadorAlfabetico97(String cadena) {
			// compilamos el patron
			Pattern patron1 = Pattern.compile("A|B|C");
			// creamos el Matcher a partir del patron, la cadena como parametro
			Matcher encaja = patron1.matcher(cadena);
			// invocamos el metodo replaceAll
			String resultado = encaja.replaceAll("2");

			Pattern patron2 = Pattern.compile("D|E|F");
			Matcher encaja2 = patron2.matcher(resultado);
			resultado = encaja2.replaceAll("3");


			Pattern patron3 = Pattern.compile("G|H|I");
			Matcher encaja3 = patron3.matcher(resultado);
			resultado = encaja3.replaceAll("4");


			Pattern patron4 = Pattern.compile("J|K|L");
			Matcher encaja4 = patron4.matcher(resultado);
			resultado = encaja4.replaceAll("5");

			Pattern patron5 = Pattern.compile("M|N|O");
			Matcher encaja5 = patron5.matcher(resultado);
			resultado = encaja5.replaceAll("6");

			Pattern patron6 = Pattern.compile("P|Q|R");
			Matcher encaja6 = patron6.matcher(resultado);
			resultado = encaja6.replaceAll("7");

			Pattern patron7 = Pattern.compile("S|T|U");
			Matcher encaja7 = patron7.matcher(resultado);
			resultado = encaja7.replaceAll("8");

			Pattern patron8 = Pattern.compile("V|W|X");
			Matcher encaja8 = patron8.matcher(resultado);
			resultado = encaja8.replaceAll("9");

			Pattern patron9 = Pattern.compile("Z|Y|�");
			Matcher encaja9 = patron9.matcher(resultado);
			resultado = encaja9.replaceAll("0");

			return resultado;
		}


	/**
	 * main
	 * @param strings parametros main
	 */
	public static void main(String ...strings )	{
		ObtenerReferenciasPagoPeticion peticion = new ObtenerReferenciasPagoPeticion();
		peticion.setNumPersona("980296893");
		peticion.setNumSucursal("128");
		peticion.setMonto(365.00);

		//String resultado = obtenerCadenaHsbc(peticion);
		String res1 = obtenerReferenciaFisa(peticion);

	}

}



