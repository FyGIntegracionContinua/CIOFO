package transformador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TimeZone;

import mapper.MapperEntrada;
import mapper.MapperSalida;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.osoa.sca.annotations.Reference;

import parser.Parser;
import utilitario.log.LogHandler;
import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ErrorTransformacion;
import utilitario.mensajes.comun.ObjetoValor;
import utilitario.mensajes.condonaciones.AplicarCondonacionTotalPeticion;
import utilitario.mensajes.condonaciones.ConsultaDatosPeticion;
import utilitario.mensajes.impresiondocs.ImpresionDocsConsulta;
import utilitario.mensajes.operacion.pagos.PagoGrupal;
import utilitario.mensajes.originacion.cheques.ChequesPeticion;
import utilitario.mensajes.originacion.cliente.ClienteOV;
import utilitario.mensajes.originacion.consulta.ConsultaFechaOV;
import utilitario.mensajes.originacion.contrato.ContratoOV;
import utilitario.mensajes.originacion.grupo.GrupoOV;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.converters.basic.DateConverter;
import com.thoughtworks.xstream.io.xml.DomDriver;
/**
 * @author Juan Carlos Moreno
 *
 */

public class TransformadorImpl implements Transformador {


	/**
	 * Parser SCA
	 */
	private Parser parser;
	/**
	 * MapperEntrada SCA
	 */
	private MapperEntrada mapperEntrada;
	/**
	 * MapperSalida SCA
	 */
	private MapperSalida mapperSalida;
	
	/**
	 * @param parser :
	 * @param mapper :
	 * @param mapperSalida Constructor
	 */
	public TransformadorImpl(@Reference (name = "parser") Parser  parser,
 							 @Reference (name = "mapperEntrada") MapperEntrada  mapper,
 							 @Reference (name = "mapperSalida") MapperSalida  mapperSalida) {
 		this.parser = parser;
 		this.mapperEntrada = mapper;
 		this.mapperSalida = mapperSalida;

	}

	/**
	 * @param uid identificador unico
	 * @param peticion de transformacion
	 * @return ObjetoValor
	 */
	@SuppressWarnings("unchecked")
	public ObjetoValor transformaStringAObjetoValor( String uid, String peticion ) {
		Map<String, ?>  peticionMap = null;
		int tipo;

		try {
			tipo = parser.obtenTipoVersionFuncion( uid, peticion );
			LogHandler.debug(uid, getClass(), "Tipo: " + tipo );
	 	}
	 	catch ( Exception e ) {
	 		LogHandler.error(uid, getClass(), "Existio un error al obtenTipoVersionFuncion", e);
	 		return new ErrorTransformacion( ERROR_APP, "Existio un error al obtenTipoVersionFuncion" );
	 	}

	 	if ( tipo == Parser.NO_VERSION_FUNCION ) {
	 		LogHandler.info(uid, getClass(), "NO_VERSION_FUNCION:  " + peticion );
	 		return new ErrorTransformacion( ERROR_APP, "" );
	 	}

	 	try {
	 		peticionMap = parser.parsearPeticion( peticion, tipo );
	 		LogHandler.debug(uid, getClass(), "peticionMap: " + peticionMap );
	 	}
	 	catch ( Exception e ) {
	 		LogHandler.error(uid, getClass(), "Existio un error al parsear la peticion", e);
	 		return new ErrorTransformacion( ERROR_APP, "Existio un error al parsear la peticion" );
	 	}
	 	//Identifica el tipo de cadena y genera el OV correspondiente
	 	switch ( tipo ) {
	 		case Parser.ALTA_CLIENTE :
	 			return generaClientePeticion( uid, (Map<String, String>) peticionMap, Parser.ALTA_CLIENTE  );
	 		case Parser.MODIFICACION_CLIENTE :
		 		return generaClientePeticion( uid, (Map<String, String>) peticionMap, Parser.MODIFICACION_CLIENTE );
	 		case Parser.ALTA_GRUPO :
			 	return generaGrupoPeticion( uid, (Map<String, String>) peticionMap, Parser.ALTA_GRUPO );
	 		case Parser.MODIFICACION_GRUPO:
			 	return generaGrupoPeticion( uid, (Map<String, String>) peticionMap, Parser.MODIFICACION_GRUPO );

			/**
			 * Se retira esta seccion
			 */
	 		case Parser.ALTA_CREDITO:
			 	return generaContratoPeticion( uid, (Map<String, String>) peticionMap, Parser.ALTA_CREDITO );
			/**
			 * Fin
			 */

	 		case Parser.VALIDA_FECHA_INICIO:
	 			return generaConsultaValidaFechaInicio( uid,  (Map<String, String>) peticionMap, Parser.VALIDA_FECHA_INICIO );
	 		case Parser.CALCULA_FECHA_FIN:
	 			return generaConsultaCalculoFechaFin( uid, (Map<String, String>) peticionMap, Parser.CALCULA_FECHA_FIN );
	 		case Parser.OBTEN_FECHA:
	 			return generaObtenFecha( uid, (Map<String, String>) peticionMap, Parser.OBTEN_FECHA );
	 		case Parser.CONSULTA_PD:
	 			return generaConsultaDatosSaldoVencido( uid, (Map<String, String>) peticionMap,  Parser.CONSULTA_PD );
	 		case Parser.CONDONACION_PARCIAL:
	 			return generaCondonacionParcial( uid, (Map<String, String>) peticionMap, Parser.CONDONACION_PARCIAL );
	 		case Parser.APLICA_PAGO:
	 			return generaAplicaPago( uid, (Map<String, String>) peticionMap, Parser.APLICA_PAGO );
	 		case Parser.ALTA_CLIENTE_UNICO:
	 			return generaClientePeticion( uid, (Map<String, String>) peticionMap, Parser.ALTA_CLIENTE_UNICO );
	 		case Parser.INFO_CHEQUES_GRAL:
	 			return generaChequesSICPeticion( uid, (Map<String, String>) peticionMap, Parser.INFO_CHEQUES_GRAL );
	 		case Parser.WEB_CHEQUES_GRAL:
	 			return generaChequesSICPeticion( uid, (Map<String, String>) peticionMap, Parser.WEB_CHEQUES_GRAL );
	 		case Parser.INFO_CHEQUES_CLIENTES:
	 			return generaChequesSICPeticion( uid, (Map<String, String>) peticionMap, Parser.INFO_CHEQUES_CLIENTES );
	 		case Parser.WEB_CHEQUES_CLIENTES:
	 			return generaChequesSICPeticion( uid, (Map<String, String>) peticionMap, Parser.WEB_CHEQUES_CLIENTES );
	 		case Parser.KIT_FIN_CONTRACT :
	 			return generaKitImpresionPeticion( uid, (Map<String, String>) peticionMap, Parser.KIT_FIN_CONTRACT );
	 		case Parser.KIT_FIN_PROMISE_NOTE:
	 			return generaKitImpresionPeticion( uid, (Map<String, String>) peticionMap, Parser.KIT_FIN_PROMISE_NOTE );
	 		case Parser.KIT_FIN_PAYMENT:
	 			return generaKitImpresionPeticion( uid, (Map<String, String>) peticionMap, Parser.KIT_FIN_PAYMENT );
	 		case Parser.KIT_FIN_SLIP_REC_MAT:
	 			return generaKitImpresionPeticion( uid, (Map<String, String>) peticionMap, Parser.KIT_FIN_SLIP_REC_MAT );
			default:
				return new ErrorTransformacion( ERROR_APP, "" );
	 	}
	}



	/**
	 * @param uid :
	 * @param peticionMap :
	 * @param tipo :
	 * @return ClienteOV
	 */
	private ClienteOV generaClientePeticion(String uid, Map<String, String> peticionMap, int tipo ) {
		ClienteOV peticion = null;
		try {
			peticion = mapperEntrada.mapearCliente( uid, (Map<String, String>) peticionMap);
			if ( peticion == null ) {
				throw new Exception("Error al generaClientePeticion.");
			}
			peticion.setTipo( tipo );
		} catch ( Exception e ) {
			peticion = null;
			LogHandler.error(uid, getClass(), e.getMessage(), e);
		}
		return peticion;
	}


	/**
	 * @param uid :
	 * @param peticionMap :
	 * @param tipo :
	 * @return GrupoOV
	 */
	private GrupoOV generaGrupoPeticion(String uid, Map<String, ?> peticionMap, int tipo) {
		GrupoOV peticion = null;
		try {
			peticion =   mapperEntrada.mapearGrupo( uid, peticionMap );
			if ( peticion == null ) {
				throw new Exception("Error al generaGrupoPeticion.");
			}
			peticion.setTipo(tipo);
		} catch ( Exception e ) {
			peticion = null;
			LogHandler.error(uid, getClass(), e.getMessage(), e);
		}
		return peticion;
	}

	/**
	 * @param uid :
	 * @param peticionMap :
	 * @param tipo :
	 * @return ContratoOV
	 */
	private ContratoOV generaContratoPeticion(String uid, Map<String, String> peticionMap, int tipo ) {
		ContratoOV peticion = null;
		try {
			peticion =   mapperEntrada.mapearContrato( uid, peticionMap );
			if ( peticion == null ) {
				throw new Exception("Error al generaContratoPeticion.");
			}
			peticion.setTipo(tipo);
		} catch ( Exception e ) {
			peticion = null;
			LogHandler.error(uid, getClass(), e.getMessage(), e);
		}
		return peticion;
	}

	/**
	 * @param uid :
	 * @param peticionMap :
	 * @param tipo :
	 * @return ConsultaFechaOV
	 */
	private ConsultaFechaOV generaConsultaValidaFechaInicio(String uid, Map<String, String> peticionMap, int tipo ) {
		ConsultaFechaOV peticion = null;
		try {
			peticion =   mapperEntrada.mapearValidaFechaInicio( uid, peticionMap );
			if ( peticion == null ) {
				throw new Exception("Error al generaConsultaValidaFechaInicio.");
			}
			peticion.setTipo(tipo);
		} catch ( Exception e ) {
			peticion = null;
			LogHandler.error(uid, getClass(), e.getMessage(), e);
		}
		return peticion;
	}


	/**
	 * @param uid :
	 * @param peticionMap :
	 * @param tipo :
	 * @return ConsultaFechaOV
	 */
	private ConsultaFechaOV generaConsultaCalculoFechaFin( String uid, Map<String, String> peticionMap, int tipo ) {
		ConsultaFechaOV peticion = null;
		try {
			peticion = mapperEntrada.mapearCalculaFechaFin( uid, peticionMap );
			if ( peticion == null ) {
				throw new Exception("Error al generaConsultaCalculoFechaFin.");
			}
			peticion.setTipo( tipo );
		} catch ( Exception e ) {
			peticion = null;
			LogHandler.error(uid, getClass(), e.getMessage(), e);
		}
		return peticion;
	}



	/**
	 * @param uid :
	 * @param peticionMap :
	 * @param tipo :
	 * @return ConsultaDatosPeticion
	 */
	private ConsultaDatosPeticion generaConsultaDatosSaldoVencido(String uid, Map<String, String> peticionMap, int tipo ) {
		ConsultaDatosPeticion peticion = new ConsultaDatosPeticion();
		try {
			peticion.setLd( mapperEntrada.mapearConsultaDatos(uid, peticionMap ) );
			peticion.setTipo(tipo);
			peticion.setHeader( new EncabezadoPeticion( ) );
		} catch ( Exception e ) {
			LogHandler.error(uid, getClass(), e.getMessage(), e);
			peticion = null;
		}
		return peticion;
	}


	/**
	 * @param uid :
	 * @param peticionMap :
	 * @param tipo :
	 * @return ConsultaFechaOV
	 */
	private ConsultaFechaOV generaObtenFecha(String uid, Map<String, String> peticionMap, int tipo ) {
		ConsultaFechaOV peticion = null;
		try {
			peticion = mapperEntrada.mapearObtenerFecha(uid, peticionMap );
			if ( peticion == null ) {
				throw new Exception("Error al generaObtenFecha.");
			}
			peticion.setTipo(tipo);
		} catch ( Exception e ) {
			peticion = null;
			LogHandler.error(uid, getClass(), e.getMessage(), e);
		}
		return peticion;
	}

	/**
	 * @param uid :
	 * @param peticionMap :
	 * @param tipo :
	 * @return AplicarCondonacionTotalPeticion
	 */
	private AplicarCondonacionTotalPeticion generaCondonacionParcial(String uid, Map<String, String> peticionMap, int tipo ) {
		AplicarCondonacionTotalPeticion peticion = new AplicarCondonacionTotalPeticion();
		try {
			peticion.setCondonacion( mapperEntrada.mapearCondonacionParcial( uid, peticionMap ) );
			/*if ( peticion == null ) {
				throw new Exception("Error al generaCondonacionParcial.");
			}*/
			peticion.setTipo(tipo);
		} catch (Exception e ) {
			LogHandler.error(uid, getClass(), e.getMessage(), e);
			peticion = null;
		}
		return peticion;
	}

	/**
	 * @param uid :
	 * @param peticionMap :
	 * @param tipo :
	 * @return PagoGrupal
	 */
	private PagoGrupal generaAplicaPago(String uid, Map<String, String> peticionMap, int tipo ) {
		PagoGrupal peticion = null;
		try {
			peticion = mapperEntrada.mapearAplicaPago( uid, peticionMap );
			if ( peticion == null ) {
				throw new Exception("Error al generaAplicaPago.");
			}
			peticion.setTipo(tipo);
		} catch ( Exception e ) {
			LogHandler.error(uid, getClass(), e.getMessage(), e);
			peticion = null;
		}
		return peticion;
	}

	/**
	 * @param uid :
	 * @param peticionMap :
	 * @param tipo :
	 * @return ChequesPeticion
	 */
	private ChequesPeticion generaChequesSICPeticion(String uid,  Map<String, String> peticionMap, int tipo ) {
		ChequesPeticion peticion = null;
		try {
			peticion  = mapperEntrada.mapearChequesSICPeticion( uid, peticionMap );
			if ( peticion == null ) {
				throw new Exception("Error al generaChequesSICPeticion.");
			}
			peticion.setTipo(tipo);
		} catch ( Exception e ) {
			//e.printStackTrace();
			LogHandler.error(uid, getClass(), e.getMessage(), e);
			peticion = null;
		}
		return peticion;
	}

	/**
	 * @param uid :
	 * @param peticionMap :
	 * @param tipo :
	 * @return ImpresionDocsConsulta
	 */
	private ImpresionDocsConsulta generaKitImpresionPeticion( String uid, Map<String, String> peticionMap, int tipo ) {
		ImpresionDocsConsulta peticion = new ImpresionDocsConsulta();
		try {
			peticion.setTipo( tipo );
			String[] params = mapperEntrada.mapearKitImpresionPeticion(uid, peticionMap);
			if ( params == null || params[1] == null ) {
				throw new Exception("Contrato LD incorrecto");
			}
		    peticion.setTipoDato(params[0]);
		    peticion.setNumeroCredito(params[1]);
		    peticion.setFechaPeticion( params[2] );
			return peticion;
		} catch ( Exception e ) {
			LogHandler.error(uid, getClass(), "Error al generar generaKitImpresionPeticion", e);
			peticion = null;
		}
		return peticion;
	}


	/**
	 * @param uid identificador unico
	 * @param respuesta de transformacion
	 * @return Regresa OFS de salida
	 */
	public String transformaObjetoValorAString(String uid, ObjetoValor respuesta) {
		if ( respuesta != null && respuesta instanceof ErrorTransformacion ) {
			return mapperSalida.generaRespuestaError(uid, (ErrorTransformacion) respuesta );
		} else if (respuesta == null) {
			return mapperSalida.generaRespuestaError(uid, new ErrorTransformacion(0, "Error al procesar la OFS peticion")  );
		}
		LogHandler.debug(uid,  getClass(), "transformaObjetoValorAString tipo: "  + respuesta.getTipo());
		return mapperSalida.generaRespuesta( uid, respuesta);
	}


	/**
	 * @param uid identificador unico
	 * @param objeto valor para la transformacion a XML
	 * @param clases arreglo de Classes para el mapeo con xstream
	 * @return el XML de regreso
	 */
	public String transformaObjetoAXML(String uid, ObjetoValor objeto, Class<?>[] clases) {
		String xml = null;
		try {
			final XStream xstream = new XStream(new DomDriver( "ISO-8859-1" ));
			xstream.setMode(XStream.NO_REFERENCES);
			final DateConverter dateConverter = new DateConverter("dd-MM-yyyy HH:mm:ss.SSS",
		            new String [] {"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyy/MM/dd", "dd-MM-yyyy"},
		            TimeZone.getTimeZone( TimeZone.getDefault().inDaylightTime( new Date() ) ? "GMT-5" : "GMT-6"  ) );

			/*final DateConverter dateConverter = new DateConverter("dd-MM-yyyy HH:mm:ss.SSS",
		            new String [] {"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyy/MM/dd", "dd-MM-yyyy"},
		            TimeZone.getTimeZone("GMT-6") );*/
			/*
			final DateConverter dateConverter = new DateConverter("dd-MM-yyyy HH:mm:ss.SSS",
		            new String [] { "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyy/MM/dd", "dd-MM-yyyy" });
		    */
			xstream.registerConverter(dateConverter);

			xstream.omitField( ObjetoValor.class, "tipo");
			/** Registramos las Clases para Xstream. */
			for (Class<?> clase : clases) {
				xstream.alias(clase.getSimpleName(), clase);
			}

			xml = objeto != null ?  xstream.toXML(objeto) : "No es posible transformar un Objeto nulo";
			}
		catch ( java.lang.Exception exception ) {
			LogHandler.error(uid, getClass(), "No es posible transformar un Objeto nulo", exception );
			xml = "No es posible transformar un Objeto nulo";
			}

		return xml;
	}

	/**
	 * @param uid identificador unico
	 * @param xml valor para la transformacion a XML
	 * @param clases arreglo de Classes para el mapeo con xstream
	 * @return el ObjetoValor de regreso
	 */
	public ObjetoValor transformaXMLAObjeto(String uid, String xml, Class<?>[] clases) {
		ObjetoValor objeto = null;
		try {
			final XStream xstream = new XStream(new DomDriver( "ISO-8859-1" ));

			final DateConverter dateConverter = new DateConverter("dd-MM-yyyy HH:mm:ss.SSS",
		             new String [] {"yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd", "yyyy/MM/dd", "dd-MM-yyyy",
					"dd/MM/yyyy" }, TimeZone.getTimeZone("GMT-6"));

			xstream.registerConverter(dateConverter);

			xstream.omitField( ObjetoValor.class, "tipo");

			/** Registramos las Clases para Xstream. */
			for (Class<?> clase : clases) {
				xstream.alias(clase.getSimpleName(), clase);
			}

			objeto = xml != null && !xml.isEmpty() ? (ObjetoValor) xstream.fromXML(xml) : null;
			}
		catch ( java.lang.Exception exception ) {
			LogHandler.error(uid, getClass(), "No es posible transformar el XML", exception );
			objeto = null;
			}

		return objeto;
	}

	/**
	 * @param uid Identificador unico
	 * @param objeto Objeto a convertir a JSon
	 * @return String con formato de Json
	 */
	public String transformaObjetoAJSON(String uid, Object objeto) {


		String json = "";
		try {

		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ObjectMapper mapper = new ObjectMapper();
		mapper.setDateFormat(df);
		ObjectWriter ow = mapper.writer();
        json += ow.writeValueAsString(objeto);
		}
        catch ( java.lang.Exception exception ) {
			LogHandler.error(uid, getClass(), "No es posible transformar a JSON", exception );
        }
		return json;

	}
	
	/*
	public static void main(String args[]) throws JsonParseException, JsonMappingException, IOException {
		TransformadorImpl t = new TransformadorImpl();
		
		RespuestaReporteExcepcionGarantia res = new RespuestaReporteExcepcionGarantia();
		res.setHeader(new EncabezadoRespuesta());
		res.getHeader().setEstatus(true);
		res.getHeader().setMensaje("sss");
		ReporteExcepcionGarantiaOV reg1 = new ReporteExcepcionGarantiaOV();
		reg1.setCiclo(1);
		List<ReporteExcepcionGarantiaOV> regs = new ArrayList<ReporteExcepcionGarantiaOV>();
		regs.add(reg1);
		res.setRegistros(regs);
		
		String respuestaX  = t.transformaObjetoAJSON("x", res); 
		
		System.out.println(respuestaX);
		 
		
		String json = "{\"RespuestaReporteExcepcionGarantia\":{\"registros\":{\"ReporteExcepcionGarantiaOV\":[{\"sucursal\":12152,\"region\":13,\"contratoRenovacion\":95264060,\"contratoNuevo\":95278649,\"fechaAltaExcepcion\":\"2015-07-10 10:48:31.793\",\"producto\":\"CREDITO COMUNAL\",\"observaciones\":\"RECHAZADO\",\"nombreSucursal\":\"CUAUTLA\",\"nombreRegion\":\"ZONA 13\",\"estatusExcepcion\":\"RECHAZADA\",\"ciclo\":21,\"solicitud\":126209},{\"sucursal\":12193,\"region\":15,\"contratoRenovacion\":\"\",\"contratoNuevo\":95268294,\"fechaAltaExcepcion\":\"2015-07-10 10:55:30.416\",\"producto\":\"CREDITO COMUNAL\",\"observaciones\":\"\",\"nombreSucursal\":\"TIERRA BLANCA\",\"nombreRegion\":\"ZONA 15\",\"estatusExcepcion\":\"\",\"ciclo\":0,\"solicitud\":114236},{\"sucursal\":12193,\"region\":15,\"contratoRenovacion\":\"\",\"contratoNuevo\":95268294,\"fechaAltaExcepcion\":\"2015-07-10 17:29:44.32\",\"producto\":\"CREDITO COMUNAL\",\"observaciones\":\"GERARDI CX JHDKFJSKDFSDFSD\",\"nombreSucursal\":\"TIERRA BLANCA\",\"nombreRegion\":\"ZONA 15\",\"estatusExcepcion\":\"APROBADA\",\"ciclo\":0,\"solicitud\":114236}]},\"header\":{\"UID\":\"8db53a410a0132950183f5e165cff120\",\"numSucursal\":0,\"estatus\":true}}}";
		
		json = " { " +	
		
				
		"		\"registros\":   							 " +	
		"         [			 " +	
		"            {										 " +	
		"               \"sucursal\":12152,					 " +	
		"               \"region\":13,						 " +	
		"               \"contratoRenovacion\":95264060,		 " +	
		"               \"contratoNuevo\":95278649,				 " +	
		"               \"fechaAltaExcepcion\":\"2015-07-10 10:48:31.793\",		 " +	
		"               \"producto\":\"CREDITO COMUNAL\",			 " +	
		"               \"observaciones\":\"RECHAZADO\",			 " +	
		"               \"nombreSucursal\":\"CUAUTLA\",			 " +	
		"               \"nombreRegion\":\"ZONA 13\",		 " +	
		"               \"estatusExcepcion\":\"RECHAZADA\",		 " +	
		"               \"ciclo\":21,		 " +	
		"               \"solicitud\":126209		 " +	
		"            }		 " +	
		" ]  " + 		
		" , " +  				       
			"	      \"header\":{  " +
				"         \"uid\":\"8db53a410a0132950183f5e165cff120\",  " +
				 "        \"numSucursal\":0, " +
				  "       \"estatus\":true " +
				  "    } " +				 
			"	}";
		
		json = "{\"RespuestaReporteExcepcionGarantia\":{\"registros\":{\"ReporteExcepcionGarantiaOV\":[{\"sucursal\":12152,\"region\":13,\"contratoRenovacion\":95264060,\"contratoNuevo\":95278649,\"fechaAltaExcepcion\":\"2015-07-10 10:48:31.793\",\"producto\":\"CREDITO COMUNAL\",\"observaciones\":\"RECHAZADO\",\"nombreSucursal\":\"CUAUTLA\",\"nombreRegion\":\"ZONA 13\",\"estatusExcepcion\":\"RECHAZADA\",\"ciclo\":21,\"solicitud\":126209},{\"sucursal\":12193,\"region\":15,\"contratoRenovacion\":\"\",\"contratoNuevo\":95268294,\"fechaAltaExcepcion\":\"2015-07-10 10:55:30.416\",\"producto\":\"CREDITO COMUNAL\",\"observaciones\":\"\",\"nombreSucursal\":\"TIERRA BLANCA\",\"nombreRegion\":\"ZONA 15\",\"estatusExcepcion\":\"\",\"ciclo\":0,\"solicitud\":114236},{\"sucursal\":12193,\"region\":15,\"contratoRenovacion\":\"\",\"contratoNuevo\":95268294,\"fechaAltaExcepcion\":\"2015-07-10 17:29:44.32\",\"producto\":\"CREDITO COMUNAL\",\"observaciones\":\"GERARDI CX JHDKFJSKDFSDFSD\",\"nombreSucursal\":\"TIERRA BLANCA\",\"nombreRegion\":\"ZONA 15\",\"estatusExcepcion\":\"APROBADA\",\"ciclo\":0,\"solicitud\":114236}]},\"header\":{\"UID\":\"8db53a410a0132950183f5e165cff120\",\"numSucursal\":0,\"estatus\":true}}}";
		System.out.println(json);
				
		ObjectMapper mapper = new ObjectMapper().setVisibility(JsonMethod.FIELD, Visibility.ANY);
	    mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		//RespuestaReporteExcepcionGarantia respuesta = mapper.readValue(respuestaX, RespuestaReporteExcepcionGarantia.class);
		
		RespuestaReporteExcepcionGarantia respuesta2 = mapper.readValue(json, RespuestaReporteExcepcionGarantia.class);
		
		System.out.println("*****" + respuesta2);
		
	}
*/
}
