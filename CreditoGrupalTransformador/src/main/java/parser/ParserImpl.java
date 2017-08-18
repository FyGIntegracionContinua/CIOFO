package parser;
/**
 * @author Juan Carlos Moreno
 *
 */
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import transformador.TransformadorException;
import utilitario.log.LogHandler;

public class ParserImpl implements Parser {

	/**
	 *  Constructor
	 */
	public ParserImpl(   ) {

	}


	/**
	 * @param uid :
	 * @param OFS :
	 * @return valor entero
	 * @throws TransformadorException
	 */
	public int obtenTipoVersionFuncion(String uid, String OFS)  {
		try {
			String[] tokenOFS = OFS.split( REGEX_OFS );
			if ( tokenOFS[ POS_OFS_UNICO ].equals( OFS_ALTA_I ) && tokenOFS[POS_OFS_ID].isEmpty() ) {
				return ALTA_CLIENTE;
			}
			else if ( tokenOFS[ POS_OFS_UNICO ].equals( OFS_CAMBIO_I ) && !tokenOFS[ POS_OFS_ID ].isEmpty() ) {
				return MODIFICACION_CLIENTE;
			}
			else if ( tokenOFS[ POS_OFS_UNICO ].equals( OFS_ALTA_GRUPO_I ) ) {
				return ALTA_GRUPO;
			}
			else if ( tokenOFS[ POS_OFS_UNICO ].equals( OFS_CAMBIO_GRUPO_I ) && !tokenOFS[ POS_OFS_ID ].isEmpty() ) {
				return MODIFICACION_GRUPO;
			}
			else if ( tokenOFS[ POS_OFS_UNICO ].equals( OFS_CAPTURA_I ) ) {
				return ALTA_CREDITO;
			}
			else if ( tokenOFS[ POS_OFS_UNICO ].equals( OFS_APLICA_PAGO ) ) {
				return APLICA_PAGO;
			}
			else if ( tokenOFS[ POS_OFS_UNICO ].equals( OFS_I ) ) {
				return ALTA_CLIENTE_UNICO;
			}
			else if ( tokenOFS[ POS_ENQ_UNICO ].endsWith( E_VALIDA_VALUE_DATE ) ) {
				return VALIDA_FECHA_INICIO;
			}
			else if ( tokenOFS[ POS_ENQ_UNICO ].endsWith( E_CAL_FIN_MATE_DATE ) ) {
				return CALCULA_FECHA_FIN;
			}
			else if ( tokenOFS[ POS_ENQ_UNICO ].endsWith( E_GET_FECHAT ) ) {
				return OBTEN_FECHA;
			}
			else if ( tokenOFS[ POS_ENQ_UNICO ].endsWith( E_CONSULTA_PD ) ) {
				return CONSULTA_PD;
			}
			else if ( tokenOFS[ POS_ENQ_UNICO ].endsWith( E_CONDONACION_PARCIAL  ) ) {
				return CONDONACION_PARCIAL;
			}
			else if ( tokenOFS[ POS_ENQ_UNICO ].endsWith( E_INFO_CHEQUES_GRAL ) ) {
				return INFO_CHEQUES_GRAL;
			}
			else if ( tokenOFS[ POS_ENQ_UNICO ].endsWith( E_INFO_CHEQUES_CLIENTES ) ) {
				return INFO_CHEQUES_CLIENTES;
			}
			else if ( tokenOFS[ POS_ENQ_UNICO ].contains( E_FIN_CONTRACT  ) ) {
				return KIT_FIN_CONTRACT;
			}
			else if ( tokenOFS[ POS_ENQ_UNICO ].contains( E_FIN_PROMISE_NOTE ) ) {
				return KIT_FIN_PROMISE_NOTE;
			}
			else if ( tokenOFS[ POS_ENQ_UNICO ].contains( E_FIN_PAYMENT  ) ) {
				return KIT_FIN_PAYMENT;
			}
			else if ( tokenOFS[ POS_OFS_ID ].contains( E_WEB_CHEQUES_GRAL ) ) {
				return WEB_CHEQUES_GRAL;
			}
			else if ( tokenOFS[ POS_OFS_ID ].contains( E_WEB_CHEQUES_INFO ) ) {
				return WEB_CHEQUES_CLIENTES;
			}
			return NO_VERSION_FUNCION;
		} catch ( Exception e ) {
			LogHandler.error(uid, this.getClass(), "Existio un erorr en obtenTipoVersionFuncion: " + e.getMessage(), e);
			throw new TransformadorException( e.getCause( ) != null ? e.getCause( ) + " " + e.getMessage()
											: e.getMessage() );
		}
	}

	/**
	 * @param peticion :
	 * @param tipoVersionFuncion :
	 * @return Map
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<String, ?> parsearPeticion(String peticion, int tipoVersionFuncion )	{
		String[] tokensPeticion;
		String index;
		String respPeticion						= null;
		String[] metaMultiValor					= null;
		String[] multiValorFin					= null;
		Map peticionMap 						= new HashMap();
		String suffix							= tipoVersionFuncion < MAX_OPERACIONES_OFS ? SUFFIX_CAMPO : SUFFIX_EQ_CAMPO;
		Map<String, Map<String, String> > listaMultivalor	= new HashMap<String, Map<String, String> >();
		try	{
	 		if ( peticion.contains( SEPARATOR_OFS ) ) {
	 			peticion = peticion.substring( 0, peticion.lastIndexOf( SEPARATOR_OFS ) );
	 			tokensPeticion = peticion.split( REGEX_OFS );
	 		}
	 		else {
	 			tokensPeticion = peticion.split( REGEX_OFS );
	 		}

	 		//Se iniciliza el Map de regreso con los 4 valores inicialies del OFS, identificadores de la operacion
	 		peticionMap.put(TABLA, tokensPeticion[0]);
	 		peticionMap.put(VERSION_FUNC, tokensPeticion[1]);
	 		peticionMap.put(USUARIO_PASSWORD, tokensPeticion[2]);
	 		peticionMap.put(ID, tokensPeticion[3]);

			//Colocamos la cadena con datos de respuesta.
			respPeticion = peticion.substring( tokensPeticion[0].length() + 1 + tokensPeticion[1].length()
					+ 1 + tokensPeticion[2].length() + 1 + tokensPeticion[3].length() + 1, peticion.length() );

			switch ( tipoVersionFuncion ) {
				case ALTA_GRUPO			: metaMultiValor =  Parser.grupoMultivalor;   break;
				case MODIFICACION_GRUPO : metaMultiValor =  Parser.grupoMultivalor;	 break;
				case ALTA_CREDITO 		: metaMultiValor =  Parser.creditoMultiValor;
										  multiValorFin  =  Parser.creditoFMultivalor; break;
			}
	 		//Se iteran los campos para obtener su llave( nombre del campo), con su valor
			for (int i = 4; i < tokensPeticion.length; i++) {
				if ( tokensPeticion[i].length() > 3) {
					/* se valida que el campo siguiente este correcto, esto es que
					*  si el campo valor actual tiene comas, el siguiente campo, sigue
					*  siendo parte de el actual, y en el parseo se perdio el formato  */
					if ( i + 1 < tokensPeticion.length ) {
						if ( !tokensPeticion[i + 1].contains( REGEX_SUBOFS ) ) {
							tokensPeticion[i] += "," + tokensPeticion[i + 1];
							tokensPeticion[i + 1] = "";
							}
						}
					//Ojeto para parsear los parametros
					String[] subTokenPeticion = tokensPeticion[i].split( REGEX_SUBOFS );

					//Se valida si es un multivalor o no
					if ( subTokenPeticion[0].endsWith( suffix ) ) {
	 					peticionMap.put( subTokenPeticion[0].substring( 0, subTokenPeticion[0].indexOf( SUFFIX_VALOR ) ),
	 							       ( subTokenPeticion.length > 1 ) ? subTokenPeticion[1] : "");
					}
					else {
						if ( metaMultiValor != null && metaMultiValor.length > 0
								   && !tokensPeticion[i].equals( "" ) ) { //Campo multivalor
							index = subTokenPeticion[0].substring(subTokenPeticion[0].indexOf( SUFFIX_VALOR ) + 1,
									subTokenPeticion[0].lastIndexOf( SUFFIX_VALOR ));

							//Checamos en caso de ser una cadena de renovacion financiada
							if ( listaMultivalor.get( index ) != null ) {
								//se actualiza con los nuevos valores
								final Map<String, String> multivalorFin = listaMultivalor.get( index );
								multivalorFin.put(multiValorFin[0], ( subTokenPeticion.length > 1 ) ? subTokenPeticion[1] : "" );
								i++;
								//Se iteran los multivadores extras para renovaciones financiadas
								for (int j = 1; j < multiValorFin.length && i < tokensPeticion.length; i++, j++) {
									if ( tokensPeticion[i].length() > 3 ) {
										/* se valida que el campo siguiente este correcto, esto es que
										*  si el campo valor actual tiene comas, el siguiente campo, sigue
										*  siendo parte de el actual, y en el parseo se perdio el formato  */
										if ( i + 1 < tokensPeticion.length ) {
											if ( !tokensPeticion[i + 1].contains( REGEX_SUBOFS ) ) {
												tokensPeticion[i] += "," + tokensPeticion[i + 1];
												tokensPeticion[i + 1] = "";
												}
											}

										subTokenPeticion = tokensPeticion[i].split( REGEX_SUBOFS );
										multivalorFin.put( multiValorFin[j], ( subTokenPeticion.length > 1 )
																			? subTokenPeticion[1] : "" );
										}
									else {
										//Esto se hace para no saltar indices en el multivalor
										j--;
										}
									}
								listaMultivalor.put(index, multivalorFin );
								}
							else {
								Map<String, String> multivalor = new LinkedHashMap<String, String>();
								multivalor.put( metaMultiValor[0], ( subTokenPeticion.length > 1 ) ? subTokenPeticion[1] : "" );
								i++;
								for (int j = 1; j < metaMultiValor.length && i < tokensPeticion.length; i++, j++)
									{
									if ( tokensPeticion[i].length() > 3 ) {
										/* se valida que el campo siguiente este correcto, esto es que
										*  si el campo valor actual tiene comas, el siguiente campo, sigue
										*  siendo parte de el actual, y en el parseo se perdio el formato  */
										if ( i + 1 < tokensPeticion.length )	{
											if ( !tokensPeticion[i + 1].contains( REGEX_SUBOFS ) ) {
												tokensPeticion[i] += "," + tokensPeticion[i + 1];
												tokensPeticion[i + 1] = "";
												}
											}

										subTokenPeticion = tokensPeticion[i].split( REGEX_SUBOFS );
										multivalor.put( metaMultiValor[j], ( subTokenPeticion.length > 1 )
												? subTokenPeticion[1] : "" );
										}
									else {
										//Esto se hace para no saltar indices en el multivalor
										j--;
										}
									}
								listaMultivalor.put(index, multivalor );
								}
							i--;
							}
						else {
							//Ocurrio un error, el formato multivalor no es reconocido
							throw new TransformadorException("Existen Campos Multivalor que no fueron indicados.");
							}
						}
					} //Fin if campo valido
				} //fin for para iteracion de las conceptos mapeados
			if (listaMultivalor.size() > 0 ) {
				peticionMap.put("MULTIVALOR", listaMultivalor);
			}

			peticionMap.put(PETICION_OFS, respPeticion);
			}
		catch ( Exception e ) {
			throw new TransformadorException( e.getCause() + " " + e.getMessage() );
			}
		//log.info("parsearPeticion: " + peticionMap);
		return peticionMap;

	}

	/**
	 * @param parametros :
	 * @return Map
	 */
	public Map<String, String> parsearPeticionParamsEnquiry( String parametros ) {
		Map<String, String> parametrosMap = new HashMap<String, String>();
		String[] tokensPeticion = null;
		try {
			if ( parametros.contains( SUFFIX_PARAMETROS  ) ) {
				parametros = parametros.replace( SUFFIX_PARAMETROS, REGEX_ENQUIRY );
			}
			tokensPeticion = parametros.split( REGEX_ENQUIRY );
			for ( int i = 0; i < tokensPeticion.length; i++ ) {
				parametrosMap.put( tokensPeticion[ i ], ( tokensPeticion[ ++i ].length( ) > 0 ) ? tokensPeticion[ i ] : "");
			}
		}
		catch ( Exception e ) {
			throw new TransformadorException( e.getCause() + " " + e.getMessage() );
		}
		return parametrosMap;
	}

}

