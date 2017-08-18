package mapper;
/**
 * @author Juan Carlos Moreno
 *
 */
import java.text.DecimalFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.osoa.sca.annotations.Reference;

import parser.Parser;
import transformador.TransformadorException;
import utilitario.log.LogHandler;
import utilitario.mensajes.comun.DomicilioOV;
import utilitario.mensajes.condonaciones.comun.CondonacionOV;
import utilitario.mensajes.operacion.pagos.PagoGrupal;
import utilitario.mensajes.originacion.cheques.ChequesPeticion;
import utilitario.mensajes.originacion.cliente.ClienteOV;
import utilitario.mensajes.originacion.consulta.ConsultaFechaOV;
import utilitario.mensajes.originacion.contrato.ContratoOV;
import utilitario.mensajes.originacion.contrato.IntegranteOV;
import utilitario.mensajes.originacion.grupo.GrupoOV;
import datamapper.DataMapper;

public class MapperEntradaImpl implements MapperEntrada {

	/**
	 * parser Parser
	 */
	private Parser  parser;

	/**
	 * @param parser Constructor
	 */
	public MapperEntradaImpl( @Reference (name = "parser") Parser  parser ) {
		 this.parser = parser;
	}

	/**
	 * LONGITUD_TELEFONO int
	 */
	private static final  int LONGITUD_TELEFONO					= 10;

	/**
	 * @param uid :
	 * @param mapClienteOV :
	 * @return ClienteOV
	 */
	public ClienteOV mapearCliente(String uid, Map<String, String> mapClienteOV) {
		ClienteOV clienteActual = null;
		Date fechaNacimiento 	= null;					//BIRTH.INCORP.DATE
 		if ( mapClienteOV != null && mapClienteOV.size() > 0 ) {
			clienteActual = new ClienteOV();
			clienteActual.setTipo( Parser.ALTA_CLIENTE );
			clienteActual.setPersona( mapClienteOV.get( PERSONA ) );
			clienteActual.setPaterno( mapClienteOV.get( PATERNO ) );
			clienteActual.setNombre( mapClienteOV.get( NOMBRE ) );
			clienteActual.setMaterno( mapClienteOV.get( MATERNO ) );
			clienteActual.setRfc( mapClienteOV.get( RFC ) );
			clienteActual.setCurp( mapClienteOV.get( "CURP" ) );
			clienteActual.setActividadEconomica( mapClienteOV.get(ACTIVIDADECONOMICA) );
			String strDate =  mapClienteOV.get( FECHA_NACIMIENTO );
			try {
				fechaNacimiento =  strDate != null ? SDF.parse(strDate) : null;
			}
			catch ( Exception e) {
				LogHandler.error(uid, getClass(), "Error al Mapear al cliente", e);
				throw new TransformadorException("Parse Exception : " + e);
			}
			clienteActual.setFechaNacimiento(fechaNacimiento);
			clienteActual.setCorreo( mapClienteOV.get( CORREO ));
			clienteActual.setIfe( mapClienteOV.get( IFE ) );
			clienteActual.setGenero( mapClienteOV.get( GENERO ) );
			clienteActual.setEstadoCivil( DataMapper.mapEstadoCivil( mapClienteOV.get( ESTADO_CIVIL ) ) );
			String telHome = mapClienteOV.get( TEL_HOME );

			if (telHome != null && telHome.length() >= LONGITUD_TELEFONO) {
				clienteActual.setLada( telHome != null ? telHome.substring(0, 2) : null );
				clienteActual.setTelefono( telHome != null ? telHome.substring(2, telHome.length() ) : null );
			} else {
				clienteActual.setTelefono( telHome );
			}

			clienteActual.setAnalista( mapClienteOV.get( ANALISTA ) );

			DomicilioOV domicilio = new DomicilioOV();
			domicilio.setPais( mapClienteOV.get( PAIS ) );
			domicilio.setCalle( mapClienteOV.get( CALLE ) );
			domicilio.setMunicipio( mapClienteOV.get( MUNICIPIO ) );
//			domicilio.setCodigoColonia(  mapClienteOV.get( CODIGO_COLONIA ) );
			domicilio.setColonia(  mapClienteOV.get( COLONIA ) );
			domicilio.setCp( mapCP( mapClienteOV.get( CP ) ) );
//			log.info("mapClienteOV.get( ENTIDAD ): " + mapClienteOV.get( ENTIDAD ) );
 			domicilio.setEntidad( DataMapper.mapClaveEntidad( mapClienteOV.get( ENTIDAD ) ) );
 			domicilio.setLocalidad( mapClienteOV.get( LOCALIDAD ) );

			clienteActual.setDomicilio(domicilio);
 			clienteActual.setOfs_peticion( mapClienteOV.get( Parser.PETICION_OFS ) );

 			String telCelular = mapClienteOV.get( TEL_CELU );
 			clienteActual.setTelefonoCelular( telCelular != null ? telCelular.trim() : null );
 			String telEmpleo = mapClienteOV.get( TEL_EMPL );
 			clienteActual.setTelefonoEmpleo( telEmpleo != null ? telEmpleo.trim() : null );
		}
//		log.info("clienteActual: " + clienteActual);
		return clienteActual;
	}

	/**
	 * @param uid :
	 * @param mapGrupoOV :
	 * @return GrupoOV
	 */
	public GrupoOV mapearGrupo(String uid, Map<String, ?> mapGrupoOV) {
		GrupoOV grupoActual 	= null;
		Date fechaConformacion = null;	 			//BIRTH.INCORP.DATE
		if ( mapGrupoOV != null && mapGrupoOV.size() > 0 ) {
			grupoActual = new GrupoOV();
			grupoActual.setIdentificador( (String) mapGrupoOV.get( IDENTIFICADOR ) );
			grupoActual.setNombre( (String) mapGrupoOV.get( NOMBRE_GRUPO ) );
			grupoActual.setAnalista( (String) mapGrupoOV.get( ANALISTA ) );
			grupoActual.setPresidente( (String) mapGrupoOV.get( PRESIDENTE ) );
			grupoActual.setTesorero( (String) mapGrupoOV.get( TESORERO ) );
			grupoActual.setSecretario( (String) mapGrupoOV.get( SECRETARIO ) );
			grupoActual.setSupervisor( (String) mapGrupoOV.get( SUPERVISOR ) );
			String strDate =  (String) mapGrupoOV.get( FECHA_CONFORMACION );
			try {
				fechaConformacion = strDate != null ? SDF.parse(strDate) : null;
			}
			catch ( Exception e) {
				LogHandler.error(uid, getClass(), "Error al Mapear al cliente", e);
				throw new TransformadorException("Parse Exception : " + e);
			}
			grupoActual.setFecha_conformacion(fechaConformacion);

			DomicilioOV domicilio = new DomicilioOV();
			domicilio.setPais( (String) mapGrupoOV.get( PAIS ) );
			domicilio.setCalle( (String) mapGrupoOV.get( CALLE ) );
			domicilio.setMunicipio( (String) mapGrupoOV.get( MUNICIPIO ) );
			//domicilio.setCodigoColonia(  ( String ) mapGrupoOV.get( CODIGO_COLONIA ) );
			domicilio.setColonia(  (String) mapGrupoOV.get( COLONIA ) );
			domicilio.setCp( mapCP( (String) mapGrupoOV.get( CP ) ) );
			domicilio.setEntidad( DataMapper.mapClaveEntidad( (String) mapGrupoOV.get( ENTIDAD ) ) );
			domicilio.setLocalidad( (String) mapGrupoOV.get( LOCALIDAD ) );

			grupoActual.setDomicilio( domicilio );

			grupoActual.setPeticion_ofs( (String) mapGrupoOV.get( Parser.PETICION_OFS ) );
		}
		return grupoActual;
	}

	/**
	 * @param uid :
	 * @param mapContratoOV :
	 * @return GrupoOV
	 */
	public ContratoOV mapearContrato(String uid, Map<String, ?> mapContratoOV) {
		ContratoOV contratoActual 		= new ContratoOV();
		IntegranteOV[] integrantes 		= null;
		GrupoOV grupoActual 			= null;
		DomicilioOV domicilio			= null;

		try {
			String strSucursal = (String) mapContratoOV.get( ASESOR );
			contratoActual.setSucursal( Integer.valueOf( ( strSucursal != null && strSucursal.length() >  3 )
					? PREFIJO_SUCURSAL + strSucursal.substring(0, 3) : null ) );
			contratoActual.setAsesor( (String) mapContratoOV.get( ASESOR ) );
 			contratoActual.setProducto( DataMapper.mapProducto( (String) mapContratoOV.get( PRODUCTO ) ) );
			String strMonto = (String) mapContratoOV.get( MONTO );
			contratoActual.setMonto_otorgado( strMonto != null && strMonto.length() > 0 ? Double.valueOf(strMonto) : 0 );
			String strTasa = (String) mapContratoOV.get( TASA );
			contratoActual.setTasa(  strTasa != null && strTasa.length() > 0 ? Double.valueOf( strTasa ) : 0 );
			contratoActual.setFrecuencia( DataMapper.mapFrecuencia( (String) mapContratoOV.get( FRECUENCIA ) ) );
			String strPlazo = (String) mapContratoOV.get( PLAZO );
			contratoActual.setPlazo( strPlazo != null && strPlazo.length() > 0 ? Integer.valueOf( strPlazo ) : 0 );
 			contratoActual.setHora_reunion( (String) mapContratoOV.get( HORA_REUNION ) );
			String strDiaReunion = (String) mapContratoOV.get( DIA_REUNION );
			contratoActual.setDia_reunion( strDiaReunion != null && strDiaReunion.length() > 0
					? Integer.valueOf( strDiaReunion ) : 0 );
			contratoActual.setRenovacion( DataMapper.mapRenovacion( (String) mapContratoOV.get( RENOVACION ) ) );
			//Si es una renovacion extrae el contrato anterior
			contratoActual.setContratoActual( (String) mapContratoOV.get( CONTRATO_ANTERIOR )  );
			String strDate = (String) mapContratoOV.get( FECHA_LIQUIDACION );
		 	try {
		 		contratoActual.setFecha_esp_liquidacion( ( strDate != null && strDate.length() > 0 )
		 				? SDF.parse(strDate) : null );
			}
			catch ( Exception e) {
				LogHandler.error(uid, getClass(), "Error al mapearContrato", e);
				throw new TransformadorException("Parse Exception : " + strDate);
			}

			strDate = (String) mapContratoOV.get( FECHA_CONTRATO );
			try {
				contratoActual.setFecha_contrato( ( strDate != null && strDate.length() > 0 ) ? SDF.parse(strDate) : null );
			}
			catch ( Exception e) {
				LogHandler.error(uid, getClass(), "Error al mapearContrato", e);
				throw new TransformadorException("Parse Exception : " + strDate);
			}
	 		strDate = (String) mapContratoOV.get( FECHA_DESEMBOLSO );
			try {
				contratoActual.setFecha_desembolso( ( strDate != null && strDate.length() > 0 ) ? SDF.parse(strDate) : null );
			}
			catch ( Exception e) {
				LogHandler.error(uid, getClass(), "Error al mapearContrato", e);
				throw new TransformadorException("Parse Exception : " + strDate);
			}
 			grupoActual = new GrupoOV( );
 			grupoActual.setIdentificador(  (String) mapContratoOV.get( ID_GRUPO ) );
 			//log.info("grupoActual: "+ grupoActual.getIdentificador() );
 			grupoActual.setPresidente( (String) mapContratoOV.get( PRESIDENTE ) );
 			grupoActual.setTesorero( (String) mapContratoOV.get( TESORERO ) );
 			grupoActual.setSecretario( (String) mapContratoOV.get( SECRETARIO ) );
 			grupoActual.setSupervisor( (String) mapContratoOV.get( SUPERVISOR ) );
 			domicilio = new DomicilioOV( );
 			domicilio.setCalle( (String) mapContratoOV.get( CALLE_DOMICILIO ) );
 			domicilio.setMunicipio( (String) mapContratoOV.get( MUNICIPIO_DOMICILIO ) );
 			domicilio.setColonia( (String) mapContratoOV.get(COLONIA_DOMICILIO) );
 			domicilio.setCp( mapCP( (String) mapContratoOV.get( CP_DOMICILIO ) ) );
			domicilio.setEntidad( DataMapper.mapClaveEntidad( (String) mapContratoOV.get( ENTIDAD_DOMICILIO ) ) );
 			grupoActual.setDomicilio( domicilio );

 			contratoActual.setGrupo( grupoActual );
 			@SuppressWarnings("rawtypes")
			Map listaMultivalor = (Map) mapContratoOV.get("MULTIVALOR");

 			//Se arman los integrantes
 			if (listaMultivalor != null && listaMultivalor.size() > 0 ) {
 				integrantes = new IntegranteOV[ listaMultivalor.size() ];
 				for (int i = 1; i <= listaMultivalor.size(); i++ ) {
 					@SuppressWarnings("unchecked")
					final Map<String, String> multivalor = (Map<String, String>) listaMultivalor.get( String.valueOf( i ) );
 					IntegranteOV integrante = new IntegranteOV();
 					integrante.setCliente( multivalor.get( INTEGRANTE_CLIENTE ) );
 					String strMontoInt = multivalor.get( MONTO_INTEGRANTE );
 					integrante.setMonto( ( strMontoInt != null && strMontoInt.length() > 0)
 							? Double.valueOf( strMontoInt ) : null );
 					integrante.setObjetivo( multivalor.get( OBJETIVO_PRESTAMO ) );
 					integrante.setTipoLocalidad(multivalor.get( TIPO_LOCALIDAD));
 					final String strMontoIntFinanciado = contratoActual.isRenovacion()
 							                     ? multivalor.get( MONTO_FINANCIADO ) : null;
 					integrante.setMontoFinanciado( ( strMontoIntFinanciado != null && strMontoIntFinanciado.length() > 0)
 							? Double.valueOf( strMontoIntFinanciado ) : 0D );
 					integrantes[i - 1] =  integrante;
 					}
 				}
 			contratoActual.setIntegrantes(integrantes);
			contratoActual.setPeticion_ofs( (String) mapContratoOV.get( Parser.PETICION_OFS )  );

		} catch ( Exception e ) {
 			//e.printStackTrace();
			domicilio 		= null;
			grupoActual 	= null;
			integrantes 	= null;
			contratoActual 	= null;
			LogHandler.error(uid, getClass(), "Error dentro del mapeo del objeto ContratoOV : " + e.getMessage() , e);
			throw new TransformadorException( e.getMessage() );
		}
		return contratoActual;

	}

	/**
	 * @param uid :
	 * @param mapPeticion :
	 * @return ConsultaFechaOV
	 */
	public ConsultaFechaOV mapearValidaFechaInicio(String uid, Map<String, String> mapPeticion) {
		ConsultaFechaOV consultaFecha 		= new ConsultaFechaOV();
		Map<String, String> parametrosMap 	= new HashMap<String, String>();
		try {
			String parametros 	= mapPeticion.get( PARAMETROS );
			parametrosMap		= parser.parsearPeticionParamsEnquiry( parametros );
	 		String strDate = (String) parametrosMap.get( FECHA );
	 		consultaFecha.setFecha( ( strDate != null && strDate.length() > 0 ) ? SDF.parse(strDate) : null );
	 		consultaFecha.setSucursal( SUCURSAL_DEFAULT );
	 		consultaFecha.setOfs_peticion( mapPeticion.get( Parser.PETICION_OFS ) );
		} catch ( Exception e ) {
 			consultaFecha 	= null;
 			LogHandler.error(uid, getClass(), "Error en la validacion de la fecha de inicio", e);
			throw new TransformadorException( e.getMessage() );
		}
		return consultaFecha;
	}
	/**
	 * @param sCp :
	 * @return Integer
	 */
	private Integer mapCP( String sCp ) {
		Integer cp  = new Integer( 0 );
		try {
			cp  = Integer.parseInt( sCp );
		}
		catch  ( Exception e ) {
			cp = 0;
		}
		return cp;
	}

	/**
	 * @param uid :
	 * @param mapPeticion :
	 * @return ConsultaFechaOV
	 */
	public ConsultaFechaOV mapearCalculaFechaFin(String uid, Map<String, String> mapPeticion ) {
		ConsultaFechaOV calculaFecha 		= new ConsultaFechaOV();
		Map<String, String> parametrosMap 	= new HashMap<String, String>();
		try {
			parametrosMap		= parser.parsearPeticionParamsEnquiry( mapPeticion.get( PARAMETROS ) );
	 		String strDate = (String) parametrosMap.get( FECHA );
	 		calculaFecha.setFecha( ( strDate != null && strDate.length() > 0 ) ? SDF.parse(strDate) : null );
	 		calculaFecha.setSucursal( SUCURSAL_DEFAULT );
	 		calculaFecha.setPerido( DataMapper.mapFrecuencia( (String) parametrosMap.get( FRECUENCIA_PARAM ) ) );
	 		calculaFecha.setPlazo( Integer.valueOf( parametrosMap.get( PLAZO_PARAM ) ) );
	 		calculaFecha.setOfs_peticion( mapPeticion.get( Parser.PETICION_OFS ) );
		} catch ( Exception e ) {
			calculaFecha 	= null;
 			LogHandler.error(uid, getClass(), "Error en mapearCalculaFechaFin", e);
			throw new TransformadorException( e.getMessage() );
		}
		return calculaFecha;
	}


	/**
	 * @param uid :
	 * @param mapPeticion :
	 * @return ConsultaFechaOV
	 */
	public String mapearConsultaDatos(String uid, Map<String, String> mapPeticion ) {
		Map<String, String> parametrosMap 	= new HashMap<String, String>();
		try {
			parametrosMap		= parser.parsearPeticionParamsEnquiry( mapPeticion.get( PARAMETROS ) );
			return (String) parametrosMap.get( LD_ID );

		} catch ( Exception e ) {
			LogHandler.error(uid, getClass(), "Error en mapearConsultaDatos", e);
			throw new TransformadorException( e.getMessage() );
		}
	}

	/**
	 * @param uid :
	 * @param mapPeticion :
	 * @return ConsultaFechaOV
	 */
	public ConsultaFechaOV mapearObtenerFecha(String uid, Map<String, String> mapPeticion) {
		ConsultaFechaOV obtenFecha 		= new ConsultaFechaOV();
		try {
			obtenFecha.setOfs_peticion( mapPeticion.get( Parser.PETICION_OFS ) );
		} catch ( Exception e ) {
			obtenFecha 	= null;
			LogHandler.error(uid, getClass(), "Error en mapearObtenerFecha", e);
			throw new TransformadorException( e.getMessage() );
		}
		return obtenFecha;
	}


	/**
	 * @param uid :
	 * @param mapPeticion :
	 * @return ConsultaFechaOV
	 */
	public CondonacionOV mapearCondonacionParcial(String uid, Map<String, String> mapPeticion ) {
		CondonacionOV condonacion = new CondonacionOV();
		double importe = 0;
		Map<String, String> parametrosMap 	= new HashMap<String, String>();
		try {
			parametrosMap		= parser.parsearPeticionParamsEnquiry( mapPeticion.get( PARAMETROS ) );

			if ((String) parametrosMap.get( INTERES) != null ) {
				importe += Double.parseDouble((String) parametrosMap.get( INTERES));
			}
			if ((String) parametrosMap.get( RECARGO) != null ) {
				importe += Double.parseDouble((String) parametrosMap.get( RECARGO));
			}
			if ((String) parametrosMap.get(CAPITAL) != null ) {
				importe += Double.parseDouble((String) parametrosMap.get( CAPITAL));
			}
			condonacion.setCredito((String) parametrosMap.get(LD_ID ));
			condonacion.setImporte(	importe + "");
			condonacion.setMotivo((String) parametrosMap.get( MOTIVO));
			//(String)parametrosMap.get( LD_ID );
		} catch ( Exception e ) {
			LogHandler.error(uid, getClass(), "Error en mapearCondonacionParcial", e);
			throw new TransformadorException( e.getMessage() );
		}
		return condonacion;
	}

	/**
	 * @param uid :
	 * @param mapPeticion :
	 * @return ConsultaFechaOV
	 */
	public PagoGrupal mapearAplicaPago(String uid, Map<String, String> mapPeticion ) {
		final DecimalFormat decimalFormat = new DecimalFormat("#,###.0000");
		PagoGrupal resp = new PagoGrupal();
		String fechaPago = mapPeticion.get(FECHA_PAGO);
		LogHandler.info(uid, getClass(), "FECHA PAGO=" + fechaPago);

		try	{
			if ( fechaPago != null) { resp.setFechaValor( SDF.parse(fechaPago)); }
			}
		catch ( Exception e ) {
			LogHandler.error(uid, getClass(), "Error en mapearAplicaPago" + e.toString(), e);
			throw new TransformadorException( e.getMessage() );
			}

		//Se colocan los parametros
		resp.setMedioPago(DataMapper.mapMedioPago.get( mapPeticion.get(MEDIO_PAGO) != null
				&& mapPeticion.get(MEDIO_PAGO).toString().length() > 0 ? mapPeticion.get(MEDIO_PAGO).toString().trim() : ""));
		resp.setIdPago(0);
		resp.setMonto(Double.parseDouble(mapPeticion.get(PAGO_MONTO)));
		resp.setNumeroContrato(mapPeticion.get(PAGO_CONTRATO));
		//La referencia se coloca, con el texto, el medio de pago y monto del pago
		resp.setReferencia( "Pago Referenciado " + resp.getMedioPago() + " " + decimalFormat.format(resp.getMonto()));
		return resp;
	}


	/**
	 * @param uid :
	 * @param mapPeticion :
	 * @return ConsultaFechaOV
	 */
	public ChequesPeticion mapearChequesSICPeticion(String uid, Map<String, String> mapPeticion) {
 		Map<String, String> parametrosMap 	= new HashMap<String, String>();
 		ChequesPeticion peticion = new ChequesPeticion();

 		if ( mapPeticion.get( PARAMETROS ) == null ) {
 			peticion.setContrato( (String) mapPeticion.get( LD_ID ) );
 		}
 		else {
	 		peticion.setContrato( (String) parametrosMap.get( LD_ID ) );
			try	{
				parametrosMap	= parser.parsearPeticionParamsEnquiry( mapPeticion.get( PARAMETROS ) );
				peticion.setContrato( (String) parametrosMap.get( LD_ID ) );
				}
			catch ( Exception e ) {
				LogHandler.error(uid, getClass(), "Error en mapearChequesSICPeticion", e);
				throw new TransformadorException( e.getMessage() );
				}
 		}
		return peticion;
	}

	/**
	 * @param uid :
	 * @param mapPeticion :
	 * @return ConsultaFechaOV
	 */
	public String[] mapearKitImpresionPeticion(String uid, Map<String, String> mapPeticion) {
		String[] kitimpresionPeticion = new String[3];
		Map<String, String> parametrosMap 	= new HashMap<String, String>();
		try {
			String tipoEnq =   mapPeticion.get( ENQUIRY );
			LogHandler.debug(uid, getClass(), "ENquiry " + tipoEnq);
			if ( tipoEnq.endsWith( SUFFIX_KIT_COM_CON  )  ) {
				kitimpresionPeticion[0] =  "0";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_COM_MEM  )  ) {
				kitimpresionPeticion[0] =  "1";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_COM_SCH  )  ) {
				kitimpresionPeticion[0] =  "2";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_OPO_CON  )  ) {
				kitimpresionPeticion[0] =  "3";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_OPO_MEM  )  ) {
				kitimpresionPeticion[0] =  "4";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_OPO_SCH  )  ) {
				kitimpresionPeticion[0] =  "5";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_OPO_AVA  )  ) {
				kitimpresionPeticion[0] =  "6";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_SOL_CON  )  ) {
				kitimpresionPeticion[0] =  "7";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_SOL_MEM  )  ) {
				kitimpresionPeticion[0] =  "8";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_SOL_SCH  )  ) {
				kitimpresionPeticion[0] =  "9";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_SLIP_REC  )  ) {
				kitimpresionPeticion[0] =  "10";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_SLIP_REC_MAT  )  ) {
				kitimpresionPeticion[0] =  "11";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_NOTE_COM_AVA  )  ) {
				kitimpresionPeticion[0] =  "12";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_NOTE_COM_MEM  )  ) {
				kitimpresionPeticion[0] =  "13";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_NOTE_COM_SCH  )  ) {
				kitimpresionPeticion[0] =  "14";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_NOTE_OPO_AVA  )  ) {
				kitimpresionPeticion[0] =  "15";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_NOTE_OPO_MEM  )  ) {
				kitimpresionPeticion[0] =  "16";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_NOTE_OPO_SCH  )  ) {
				kitimpresionPeticion[0] =  "17";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_NOTE_SOL_AVA  )  ) {
				kitimpresionPeticion[0] =  "18";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_NOTE_SOL_MEM  )  ) {
				kitimpresionPeticion[0] =  "19";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_NOTE_SOL_SCH  )  ) {
				kitimpresionPeticion[0] =  "20";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_COM_REN_CON   )  ) {
				kitimpresionPeticion[0] =  "21";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_COM_REN_MEM   )  ) {
				kitimpresionPeticion[0] =  "22";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_COM_REN_SCH   )  ) {
				kitimpresionPeticion[0] =  "2";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_COM_REN_MEM_ANT) ) {
				kitimpresionPeticion[0] =  "23";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_SOL_REN_CON	  )  ) {
				kitimpresionPeticion[0] =  "21";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_SOL_REN_MEM	  )  ) {
				kitimpresionPeticion[0] =  "22";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_SOL_REN_SCH	  )  ) {
				kitimpresionPeticion[0] =  "9";
			}
			else if (  tipoEnq.endsWith( SUFFIX_KIT_SOL_REN_MEM_ANT) ) {
				kitimpresionPeticion[0] =  "23";
			}
			LogHandler.debug(uid, getClass(), "Enquiry kitimpresionPeticion[0] " + kitimpresionPeticion[0]);
			parametrosMap = parser.parsearPeticionParamsEnquiry( mapPeticion.get( PARAMETROS ) );
			kitimpresionPeticion[1] = (String) parametrosMap.get( LD_ID );
			kitimpresionPeticion[2] = (String) ( parametrosMap.get( FECHA_DESEMBOLSO )
					!= null ? parametrosMap.get( FECHA_DESEMBOLSO ) : "" );
			return kitimpresionPeticion;
		} catch ( Exception e ) {
			LogHandler.error(uid, getClass(), "Error en mapearKitImpresionPeticion", e);
			throw new TransformadorException( e.getMessage() );
		}
	}
}
