package mapper;
/**
 * @author Juan Carlos Moreno
 *
 */
import org.oasisopen.sca.annotation.Scope;

import parser.Parser;
import utilitario.log.LogHandler;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ErrorTransformacion;
import utilitario.mensajes.comun.ObjetoValor;
import utilitario.mensajes.comun.ResultadoOV;
import utilitario.mensajes.condonaciones.AplicarCondonacionTotalRespuesta;
import utilitario.mensajes.condonaciones.ConsultaDatosRespuesta;
import utilitario.mensajes.impresiondocs.ImpresionDocsConsultaRespuesta;
import utilitario.mensajes.operacion.pagos.PagoGrupalResponse;
import utilitario.mensajes.originacion.cheques.ClienteChequesSICOV;
import utilitario.mensajes.originacion.cheques.ClientesChequesRespuesta;
import utilitario.mensajes.originacion.cheques.ContratoChequesSICOV;
import utilitario.mensajes.originacion.consulta.ConsultaRespuesta;
import utilitario.mensajes.originacion.contrato.ContratoRespuesta;
import datamapper.DataMapper;

/**
 * @author out_mmejorada
 *
 */
/**
 * @author out_mmejorada
 *
 */
@Scope("COMPOSITE")
public class MapperSalidaImpl implements MapperSalida {

	/**
	 *  Constructor
	 */
	public MapperSalidaImpl(  ) {
	}

	/**
	 * Normaliza los mensajes recibidos de CREDPROD
	 * @param desnormalizada :
	 * @return String
	 */
	private String normalizaMensaje( String desnormalizada ) {
		String
		normalizada  = desnormalizada.replace(",", " ");
		normalizada  = desnormalizada.replace("/", " ");
		normalizada  = desnormalizada.replace("//", " ");
		normalizada  = desnormalizada.replace(":", ".");
		return normalizada;
	}
	/**
	 * Normaliza los valores de obtenidos de la base de datos
	 * @param desnormalizada :
	 * @return String
	 */
	private String normalizaCaracetresEspeciales( String desnormalizada ) {
		String
		normalizada  = desnormalizada.replace("À", "//01");
		normalizada  = normalizada.replace("È", "//02");
		normalizada  = normalizada.replace("Ì", "//03");
		normalizada  = normalizada.replace("Ò", "//04");
		normalizada  = normalizada.replace("Ù", "//05");
		normalizada  = normalizada.replace("Á", "//06");
		normalizada  = normalizada.replace("É", "//07");
		normalizada  = normalizada.replace("Í", "//08");
		normalizada  = normalizada.replace("Ó", "//09");
		normalizada  = normalizada.replace("Ú", "//10");
		normalizada  = normalizada.replace("Â", "//11");
		normalizada  = normalizada.replace("Ê", "//12");
		normalizada  = normalizada.replace("Î", "//13");
		normalizada  = normalizada.replace("Ô", "//14");
		normalizada  = normalizada.replace("Û", "//15");
		normalizada  = normalizada.replace("Ä", "//16");
		normalizada  = normalizada.replace("Ë", "//17");
		normalizada  = normalizada.replace("Ï", "//18");
		normalizada  = normalizada.replace("Ö", "//19");
		normalizada  = normalizada.replace("Ü", "//20");
		normalizada  = normalizada.replace("à", "//21");
		normalizada  = normalizada.replace("è", "//22");
		normalizada  = normalizada.replace("ì", "//23");
		normalizada  = normalizada.replace("ò", "//24");
		normalizada  = normalizada.replace("ù", "//25");
		normalizada  = normalizada.replace("á", "//26");
		normalizada  = normalizada.replace("é", "//27");
		normalizada  = normalizada.replace("í", "//28");
		normalizada  = normalizada.replace("ó", "//29");
		normalizada  = normalizada.replace("ú", "//30");
		normalizada  = normalizada.replace("â", "//31");
		normalizada  = normalizada.replace("ê", "//32");
		normalizada  = normalizada.replace("î", "//33");
		normalizada  = normalizada.replace("ô", "//34");
		normalizada  = normalizada.replace("û", "//35");
		normalizada  = normalizada.replace("ä", "//36");
		normalizada  = normalizada.replace("ë", "//37");
		normalizada  = normalizada.replace("ï", "//38");
		normalizada  = normalizada.replace("ö", "//39");
		normalizada  = normalizada.replace("ü", "//40");
		normalizada  = normalizada.replace("Ñ", "//41");
		normalizada  = normalizada.replace("ñ", "//42");
		normalizada  = normalizada.replace(",", "//43");
		normalizada  = normalizada.replace("'", "//44");
		normalizada  = normalizada.replace("\"", "//45");

		return normalizada;
	}



	/**
	 * @param respuestaOV :
	 * @param uid :
	 * @return String
	 */
	public  String generaRespuesta( String uid, ObjetoValor respuestaOV ) {
		boolean salidaOFSOriginacion = 			true;
		EncabezadoRespuesta encabezado  = null;
		String identificador			= null;
		String fechaFin					= null;
		String respuesta				= null;
		String respuestaOFS				= null;
		ResultadoOV clienteResp			= null;
		ResultadoOV grupoResp			= null;
		ContratoRespuesta contratoResp	= null;
		ConsultaRespuesta consultaResp	= null;
		if ( respuestaOV == null ) {
			respuesta = generaRespuestaOFSErrorApp() + Parser.REGEX_OFS + "ERROR"
		                     + Parser.SUFFIX_CAMPO + Parser.REGEX_SUBOFS;
			return respuesta;
		}
		int tipo = respuestaOV.getTipo();
		LogHandler.debug(uid, getClass(), "Tipo para cadena de respuesta: " + tipo  );
		switch (  tipo ) {
			case Parser.ALTA_CLIENTE  :
				clienteResp 	= (ResultadoOV) respuestaOV;
				identificador 	= clienteResp.getIdentificador();
				respuestaOFS	= clienteResp.getPeticion_Ofs();
				encabezado 		= new EncabezadoRespuesta();
				encabezado.setEstatus( clienteResp.isEstatus() );
				encabezado.setMensaje( clienteResp.getMensaje() );
				break;
			case Parser.MODIFICACION_CLIENTE:
				clienteResp 	= (ResultadoOV) respuestaOV;
				identificador 	= clienteResp.getIdentificador();
				respuestaOFS	= clienteResp.getPeticion_Ofs();
				encabezado 		= new EncabezadoRespuesta();
				encabezado.setEstatus( clienteResp.isEstatus() );
				encabezado.setMensaje( clienteResp.getMensaje() );
				break;
			case Parser.ALTA_GRUPO:
				grupoResp 		= (ResultadoOV) respuestaOV;
				identificador 	= grupoResp.getIdentificador();
				respuestaOFS	= grupoResp.getPeticion_Ofs();
				encabezado 		= new EncabezadoRespuesta();
				encabezado.setEstatus( grupoResp.isEstatus() );
				encabezado.setMensaje( grupoResp.getMensaje() );
				break;
			case Parser.MODIFICACION_GRUPO:
				grupoResp 		= (ResultadoOV) respuestaOV;
				identificador 	= grupoResp.getIdentificador();
				respuestaOFS	= grupoResp.getPeticion_Ofs();
				encabezado 		= new EncabezadoRespuesta();
				encabezado.setEstatus( grupoResp.isEstatus() );
				encabezado.setMensaje( grupoResp.getMensaje() );
				break;
			case Parser.ALTA_CREDITO:
				contratoResp 	= (ContratoRespuesta) respuestaOV;
				identificador 	= contratoResp.getContrato();
				respuestaOFS	= contratoResp.getPeticion_ofs();
				encabezado = contratoResp.getHeader();
				break;
			case Parser.VALIDA_FECHA_INICIO:
				consultaResp 	= (ConsultaRespuesta) respuestaOV;
				encabezado		= consultaResp.getHeader();
				identificador 	= consultaResp.getIdentificador();
				respuestaOFS	= consultaResp.getPeticion_ofs();
				salidaOFSOriginacion 		= false;
				respuesta 		= RESP_ENQUIRY + RESP_VALIDA_FECHA_INICIO;
				respuesta 		+= encabezado.isEstatus( ) ? RESP_VALIDA_FECHA_INICIO_PASS
						: ( "\"1~" + encabezado.getMensaje() + "\"" ); //RESP_VALIDA_FECHA_INICIO_FAIL;
				break;
			case Parser.CALCULA_FECHA_FIN:
				consultaResp 	= (ConsultaRespuesta) respuestaOV;
				encabezado		= consultaResp.getHeader();
				fechaFin 		= consultaResp.getFechaFin() != null ? SDF.format( consultaResp.getFechaFin() ) : null;
				identificador 	= fechaFin != null ? fechaFin : consultaResp.getIdentificador();
				respuestaOFS	= consultaResp.getPeticion_ofs();
				salidaOFSOriginacion 		= false;
				respuesta		= RESP_ENQUIRY + RESP_CALCULA_FECHA_FIN + RESP_QUOTE + fechaFin + RESP_QUOTE;
				break;
			case Parser.OBTEN_FECHA:
				consultaResp 	= (ConsultaRespuesta) respuestaOV;
				encabezado		= consultaResp.getHeader();
				fechaFin 		= consultaResp.getFechaFin() != null ? SDF_OBTEN_FECHA.format( consultaResp.getFechaFin() ) : "";
				identificador 	= fechaFin != null ? fechaFin : consultaResp.getIdentificador();
				respuestaOFS	= consultaResp.getPeticion_ofs();
				salidaOFSOriginacion 		= false;
				respuesta		= RESP_ENQUIRY + RESP_OBTEN_FECHA + RESP_QUOTE + fechaFin + RESP_OBTEN_FECHA_MSG + RESP_QUOTE;
				break;
			case Parser.CONSULTA_PD:
				respuesta = generaRespuestaConsultaDatos(uid, (ConsultaDatosRespuesta) respuestaOV );
				salidaOFSOriginacion 		= false;
				break;
			case Parser.ALTA_CLIENTE_UNICO   :
				clienteResp 	= (ResultadoOV) respuestaOV;
				encabezado		= new EncabezadoRespuesta();
				encabezado.setEstatus( clienteResp.isEstatus() );
				encabezado.setUID( clienteResp.getUid() );
				encabezado.setMensaje( clienteResp.getMensaje() );
				identificador 	= clienteResp.getIdentificador();
				respuestaOFS	= clienteResp.getPeticion_Ofs();
				salidaOFSOriginacion 		= true;
				break;
			case Parser.APLICA_PAGO:
				respuesta = generaRespuestaAplicaPago( uid, (PagoGrupalResponse) respuestaOV);
				salidaOFSOriginacion 		= false;
				break;
			case Parser.CONDONACION_PARCIAL:
				respuesta =  generaRespuestaCondonacionParcial( uid, (AplicarCondonacionTotalRespuesta) respuestaOV );
				salidaOFSOriginacion 		= false;
				break;
			case Parser.INFO_CHEQUES_GRAL:
				salidaOFSOriginacion 		= false;
				respuesta =  generaRespuestaChequesGeneral( uid, (ContratoChequesSICOV) respuestaOV );
				break;
			case Parser.WEB_CHEQUES_GRAL:
				salidaOFSOriginacion 		= false;
				respuesta =  generaRespuestaChequesWebGeneral( uid, (ContratoChequesSICOV) respuestaOV );
				break;
			case Parser.INFO_CHEQUES_CLIENTES:
				respuesta =  generaRespuestaChequesClientes( uid, (ClientesChequesRespuesta) respuestaOV );
				salidaOFSOriginacion 		= false;
				break;
			case Parser.WEB_CHEQUES_CLIENTES:
				respuesta =  generaRespuestaChequesWebClientes( uid, (ClientesChequesRespuesta) respuestaOV );
				salidaOFSOriginacion 		= false;
				break;
			case Parser.KIT_FIN_CONTRACT:
				respuesta = generaRespuestaKitImpresion( uid, (ImpresionDocsConsultaRespuesta) respuestaOV );
				salidaOFSOriginacion 		= false;
				break;
			case Parser.KIT_FIN_PROMISE_NOTE:
				respuesta = generaRespuestaKitImpresion( uid, (ImpresionDocsConsultaRespuesta) respuestaOV );
				salidaOFSOriginacion 		= false;
				break;
			case Parser.KIT_FIN_PAYMENT:
				respuesta = generaRespuestaKitImpresion( uid, (ImpresionDocsConsultaRespuesta) respuestaOV );
				salidaOFSOriginacion 		= false;
				break;
			case Parser.KIT_FIN_SLIP_REC_MAT:
				respuesta = generaRespuestaKitImpresion( uid,  (ImpresionDocsConsultaRespuesta) respuestaOV );
				salidaOFSOriginacion 		= false;
				break;
			default:
				salidaOFSOriginacion 		= false;
				break;
		}
		if ( salidaOFSOriginacion ) {
			if ( encabezado.isEstatus() ) {
				respuesta = ( identificador != null ? identificador : "" ) + Parser.SEPARATOR_OFS
					+ RESPUESTA_OFS_PASS + Parser.REGEX_OFS + ( respuestaOFS != null  ? respuestaOFS : ""  );
			}
			else {
				respuesta = generaRespuestaFail(encabezado.getUID(), tipo, normalizaMensaje( encabezado.getMensaje( ) ));
			}
		}
		return respuesta;
	}

	/**
	 * @param uid :
	 * @param tipo :
	 * @param message :
	 * @return String
	 */
	private String generaRespuestaFail( String uid, int tipo, String message ) {
		return RESPUESTA_OFS_FAIL + Parser.REGEX_OFS + "[" + ( uid != null ? uid : "" )  + "]" + Parser.SUFFIX_CAMPO
				+ Parser.REGEX_SUBOFS + (message != null ?  message : "");
	}

	/**
	 * @return OFS Error
	 */
	public String generaRespuestaOFSErrorApp( ) {
		return   RESPUESTA_OFS_FAIL +  Parser.REGEX_OFS +  ERROR_APPLICATION;
	}

	/**
	 * @param uid :
	 * @param message :
	 * @return OFS Error
	 */
	public String generaRespuestaOFSErrorApp( String uid, String message ) {
		return   RESPUESTA_OFS_FAIL + Parser.REGEX_OFS + "[" + uid + "] " + "ERROR "
						+ ( message != null ? normalizaMensaje(message) : "");
	}

	/**
	 * @param uid :
	 * @return OFS Error
	 */
	public String generaRespuestaOFSErrorField( String uid ) {
		return RESPUESTA_OFS_FAIL +  Parser.REGEX_OFS + "[" + uid + "] " +  ERROR_FIELD;
	}

	/**
	 * @param uid :
	 * @param respuesta :
	 * @return OFS Error
	 */
	public String generaRespuestaAplicaPago(String uid, PagoGrupalResponse respuesta) {
		int estatusSalida = -1;
		String mensajeSalida = "";

		if ( respuesta.getHeader() != null ) {
			if ( respuesta.getHeader().isEstatus()) {
				estatusSalida = 1;
			}
			mensajeSalida = respuesta.getHeader().getMensaje();
		}
		return "" + (respuesta.getIdTransaccion() != null ? respuesta.getIdTransaccion() : "ERROR") + "//" + estatusSalida
				+	(estatusSalida == 1 ? "," : ("/" + APLICA_PAGO_ERROR + " [" + uid + "] ")) + mensajeSalida;
	}

	/**
	 * @param uid :
	 * @param respuesta :
	 * @return OFS Error
	 */
	public String generaRespuestaConsultaDatos(String uid, ConsultaDatosRespuesta respuesta) {
		if (respuesta == null || respuesta.getResultado().equals("0")) {
			return CONSULTA_DATOS_ERROR_PREFIX + respuesta.getMensaje() + "\" ";
		} else {
			String ofsresult = new String(CONSULTA_DATOS_RESPUESTA).replace("capResult",
					respuesta.getCapitalPD()).replace("intResult",
					respuesta.getInteresPD()).replace("morResult", respuesta.getRecargos());
			return ofsresult;
		}
	}

	/**
	 * @param uid :
	 * @param respuesta :
	 * @return OFS Error
	 */
	public String generaRespuestaCondonacionParcial(String uid, AplicarCondonacionTotalRespuesta respuesta) {
		return CONDONACION_RESP_PREFIX + (respuesta.getHeader().isEstatus() ? "1~" : "-1~") + respuesta.getDetalle() + "\"";
	}

	/**
	 * @param uid :
	 * @param error :
	 * @return OFS Error
	 */
	public String generaRespuestaError(String uid, ErrorTransformacion error) {
		return this.generaRespuestaOFSErrorApp(uid,  error.getMensaje() );
	}


	/**
	 * @param uid :
	 * @param respuesta :
	 * @return OFS Error
	 */
	public String generaRespuestaChequesGeneral(String uid, ContratoChequesSICOV respuesta) {
		if ( respuesta == null || !respuesta.isStatus() ) { //Respuesta error
			return RESP_ENQUIRY + RESP_QUOTE + RESP_ENQUIRY_FAIL + CHEQUES_CREDITO_ENCABEZADO + RESP_QUOTE;
		}
		return RESP_ENQUIRY + RESP_QUOTE + RESP_ENQUIRY_OK + CHEQUES_CREDITO_ENCABEZADO + RESP_QUOTE + RESP_COMMA
				+  RESP_QUOTE + armaRespuestaChequesGeneral( respuesta ) + RESP_QUOTE;
 	}

	/**
	 * @param uid :
	 * @param respuesta :
	 * @return OFS Error
	 */
	public String generaRespuestaChequesWebGeneral(String uid, ContratoChequesSICOV respuesta) {
		if ( respuesta == null || !respuesta.isStatus() ) { //Respuesta error
			return CHEQUES_WEB_CREDITO_ENCABEZADO + "\"EXISTIO UN ERROR AL GENERAR EL CHEQUE WEB\"";
		}
		return CHEQUES_WEB_CREDITO_ENCABEZADO + armaRespuestaChequesWebGeneral( respuesta );
 	}

	/**
	 * @param respuesta :
	 * @return String
	 */
	private String armaRespuestaChequesGeneral( ContratoChequesSICOV respuesta ) {

		StringBuffer buffer = new StringBuffer();
		buffer.append( DataMapper.mapProductoFsol( respuesta.getProductoId() ) );
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( respuesta.getProducto() );
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( respuesta.getFechaInicio() != null ? SDF.format( respuesta.getFechaInicio() ) : "");
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( respuesta.getFechaTermino() != null ? SDF.format( respuesta.getFechaTermino() ) : "" );
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( respuesta.getSucursalId() != null ? respuesta.getSucursalId().toString() : "");
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( respuesta.getSucursal() );
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( respuesta.getAsesor() != null ? normalizaCaracetresEspeciales( respuesta.getAsesor() ) : "");
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( respuesta.getNomAsesor() != null ? normalizaCaracetresEspeciales( respuesta.getNomAsesor() ) : "");
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( respuesta.getCuentaSucursalId()  );
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( respuesta.getCuentaSucursal()  );
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( respuesta.getGrupoId() );
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( respuesta.getGrupo() );
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( "CUENTA" ); //respuesta.getCuentaGrupoId() );
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( respuesta.getFecha() != null ? SDF.format(respuesta.getFecha()) : "" );
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( respuesta.getNumMiembros() != null ? respuesta.getNumMiembros().toString() : "" );
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( respuesta.getFecha1erPago() != null ? SDF.format(respuesta.getFecha1erPago()) : "" );
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( respuesta.getStatusMora() );
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( respuesta.getMontoAprobado() != null ? respuesta.getMontoAprobado() : "0" );
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( respuesta.getRenovacion() );
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append(  respuesta.getGerente() != null ? normalizaCaracetresEspeciales( respuesta.getGerente() ) : "" );
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( "" ); //respuesta.getSucursalDir() );
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( "" ); //respuesta.getFechaLugar());
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( "" ); //respuesta.getSucursalEdo());
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( "" ); //respuesta.getSucursalCd());
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( respuesta.getEmpresa() != null ? normalizaCaracetresEspeciales( respuesta.getEmpresa() ) : "" );
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( "" ); //respuesta.getSucursalDirSinAcento());
		buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
		buffer.append( respuesta.getComision()  );
		return buffer.toString( );
	}

	/**
	 * @param respuesta :
	 * @return String
	 */
	private String armaRespuestaChequesWebGeneral( ContratoChequesSICOV respuesta ) {

		final StringBuffer buffer = new StringBuffer();
			buffer.append( "\"" + DataMapper.mapProductoFsol( respuesta.getProductoId() ) + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + respuesta.getProducto() + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + ( respuesta.getFechaInicio() != null ? SDF.format( respuesta.getFechaInicio() ) : "" ) + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + ( respuesta.getFechaTermino() != null ? SDF.format( respuesta.getFechaTermino() ) : "" )
					     + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + ( respuesta.getSucursalId() != null ? respuesta.getSucursalId().toString() : "" ) + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + respuesta.getSucursal() + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + ( respuesta.getAsesor() != null ? normalizaCaracetresEspeciales( respuesta.getAsesor() ) : "" )
					+ "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + ( respuesta.getNomAsesor() != null ? normalizaCaracetresEspeciales( respuesta.getNomAsesor() )
					: "" )	+ "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + respuesta.getCuentaSucursalId() + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + respuesta.getCuentaSucursal() + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + respuesta.getGrupoId() + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + respuesta.getGrupo() + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + respuesta.getCuentaGrupoId() + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + ( respuesta.getFecha() != null ? SDF.format(respuesta.getFecha()) : "" ) + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + ( respuesta.getNumMiembros() != null ? respuesta.getNumMiembros().toString() : "" ) + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + ( respuesta.getFecha1erPago() != null ? SDF.format(respuesta.getFecha1erPago()) : "" ) + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + respuesta.getStatusMora() + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + ( respuesta.getMontoAprobado() != null ? respuesta.getMontoAprobado() : "0" ) + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + respuesta.getRenovacion() + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + ( respuesta.getGerente() != null ? normalizaCaracetresEspeciales( respuesta.getGerente() )
					: "" ) + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + respuesta.getSucursalDir() + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + respuesta.getFechaLugar() + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + respuesta.getSucursalEdo() + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + respuesta.getSucursalCd() + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + ( respuesta.getEmpresa() != null ? normalizaCaracetresEspeciales( respuesta.getEmpresa() )
					: "" ) + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + respuesta.getSucursalDirSinAcento() + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + respuesta.getComision() + "\"" );
		return buffer.toString( );
	}

	/**
	 * @param uid :
	 * @param respuesta :
	 * @return OFS Error
	 */
	public String generaRespuestaChequesWebClientes( String uid, ClientesChequesRespuesta respuesta) {
		if (  respuesta == null || !respuesta.getHeader().isEstatus() || respuesta.getBody() == null
				||  respuesta.getBody().length == 0 ) { //Respuesta error
			return CHEQUES_WEB_CLIENTES_ENCABEZADO + ",\"ERROR Al GENERAR El CHEQUE\"";
		}
		return CHEQUES_WEB_CLIENTES_ENCABEZADO + armaRespuestaChequesWebClientes( respuesta.getBody() );
	}

	/**
	 * @param uid :
	 * @param respuesta :
	 * @return OFS Error
	 */
	public String generaRespuestaChequesClientes( String uid, ClientesChequesRespuesta respuesta) {
		if (  respuesta == null || !respuesta.getHeader().isEstatus() || respuesta.getBody() == null
				||  respuesta.getBody().length == 0 ) { //Respuesta error
			return RESP_ENQUIRY + RESP_QUOTE + RESP_ENQUIRY_FAIL + CHEQUES_CLIENTES_ENCABEZADO + RESP_QUOTE;
		}
		return RESP_ENQUIRY + RESP_QUOTE +  respuesta.getBody().length + CHEQUES_CLIENTES_ENCABEZADO
				+ RESP_QUOTE + armaRespuestaChequesClientes( respuesta.getBody() );
	}

	/**
	 * @param uid :
	 * @param respuesta :
	 * @return OFS Error
	 */
	public String generaRespuestaKitImpresion(String uid, ImpresionDocsConsultaRespuesta respuesta) {
		if (respuesta.getOfs_result() == null || respuesta.getOfs_result().isEmpty()) {
			respuesta.setMsjError(ERROR_KIT_IMPRESION);
			return respuesta.getMsjError();
		}
		return respuesta.getOfs_result();
	}

	/**
	 * @param clientes :
	 * @return String
	 */
	private String armaRespuestaChequesClientes( ClienteChequesSICOV[] clientes) {
		StringBuffer buffer = new StringBuffer();
		for ( int i = 0; i < clientes.length; i++) {
			buffer.append( RESP_COMMA );
			buffer.append( RESP_QUOTE );
			buffer.append( clientes[i].getClienteId() );
			buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
			buffer.append( clientes[i].getCliente() != null ?  normalizaCaracetresEspeciales( clientes[i].getCliente() ) : "");
			buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
			buffer.append( clientes[i].getMonto() != null ? clientes[i].getMonto().toString() : "0" );
			buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
			buffer.append( clientes[i].getSaldoVigente() != null ? clientes[i].getSaldoVigente().toString() : "0" );
			buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
			buffer.append( clientes[i].getRenovacion() );
			buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
			buffer.append( clientes[i].getCiclo() != null ? clientes[i].getCiclo().toString() : "0" );
			buffer.append( RESP_SEPARADOR_FIELD_ENQUIRY );
			buffer.append( " ");
			buffer.append( RESP_QUOTE );
		}
		return buffer.toString( );
 	}

	/**
	 * @param clientes :
	 * @return String
	 */
	private String armaRespuestaChequesWebClientes( ClienteChequesSICOV[] clientes) {
		StringBuffer buffer = new StringBuffer();
		for ( int i = 0; i < clientes.length; i++) {
			buffer.append( RESP_COMMA );
			buffer.append( "\"" + clientes[i].getClienteId() + "\"");
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + ( clientes[i].getCliente() != null ?  normalizaCaracetresEspeciales( clientes[i].getCliente() )
					: "" ) + "\"");
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + ( clientes[i].getMonto() != null ? clientes[i].getMonto().toString() : "0" ) + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + ( clientes[i].getSaldoVigente() != null ? clientes[i].getSaldoVigente().toString() : "0" )
					+ "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + clientes[i].getRenovacion() + "\"");
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"" + ( clientes[i].getCiclo() != null ? clientes[i].getCiclo().toString() : "0" ) + "\"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"  \"" );
			buffer.append( RESP_SEPARADOR_ENQUIRY_CW );
			buffer.append( "\"0\"" );
		}
		return buffer.toString( );
 	}
}

