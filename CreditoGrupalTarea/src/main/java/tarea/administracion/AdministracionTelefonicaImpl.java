package tarea.administracion;

import java.io.ByteArrayInputStream;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import mx.com.fisa.parser.Cliente;
import mx.com.fisa.parser.ParserSIMAC;
import mx.com.fisa.parser.Solicitud;
import mx.com.fisa.parser.Telefono;

import org.apache.ibatis.session.SqlSession;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import tarea.comun.ReadProperties;
import utilitario.log.LogHandler;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.persona.TelefonoOV;
import utilitario.mensajes.verificacion.telefonica.BitacoraVerificacionFinsolOV;
import utilitario.mensajes.verificacion.telefonica.ConsultaInformacionTelefonicaPeticion;
import utilitario.mensajes.verificacion.telefonica.ConsultaInformacionTelefonicaRespuesta;
import utilitario.mensajes.verificacion.telefonica.ConsultaSolicitudesVerificacionPeticion;
import utilitario.mensajes.verificacion.telefonica.ConsultaSolicitudesVerificacionRespuesta;
import utilitario.mensajes.verificacion.telefonica.EstadoSolicitudOV;
import utilitario.mensajes.verificacion.telefonica.IntegrantesOV;
import utilitario.mensajes.verificacion.telefonica.RegistraBitacoraPeticion;
import utilitario.mensajes.verificacion.telefonica.RegistraBitacoraRespuesta;
import utilitario.mensajes.verificacion.telefonica.RespuestainformacionVerificacion;
import utilitario.mensajes.verificacion.telefonica.SolicitudOV;
import utilitario.mensajes.verificacion.telefonica.ValidaStatusSolicitudPeticion;
import utilitario.mensajes.verificacion.telefonica.ValidaStatusSolicitudRespuesta;
import entidad.conexiones.FabricaConexiones;

public class AdministracionTelefonicaImpl implements AdministracionTelefonica {

	/**
	 * CAMPANA String
	 */
	public static final String CAMPANA 						= 	"VERIFICACION_FINSOL";
	/**
	 * CLIENTE String
	 */
	public static final String CLIENTE 						= 	"FINSOL";
	/**
	 * NUMERO_TELEFONOS String
	 */
	public static final String NUMERO_TELEFONOS 			= 	"9";
	/**
	 * CODIGO_ENVIO String
	 */
	public static final String CODIGO_ENVIO 				=	"SOLICITUD_ENVIADA";
	/**
	 * CATALOGOS_VT_TIPO_CODIGO String
	 */
	public static final String CATALOGOS_VT_TIPO_CODIGO 	=	"VTIT";
	/**
	 * CATALOGOS_VT_ESTATUS String
	 */
	public static final String CATALOGOS_VT_ESTATUS	 		=	"A";
	/**
	 * INUMERO_TELEFONOS Integer
	 */
	public static final Integer INUMERO_TELEFONOS	 		=	9;
	/** TRES */
	public static final Integer TRES	 		=	3;
	/** CUATRO */
	public static final Integer CUATRO	 		=	4;
	/** CINCO */
	public static final Integer CINCO	 		=	5;
	/** SEIS */
	public static final Integer SEIS	 		=	6;
	/** SIETE */
	public static final Integer SIETE	 		=	7;
	/** OCHO */
	public static final Integer OCHO	 		=	8;


	/**
	 * @param uid :
	 * @param peticion :
	 * @return ConsultaInformacionTelefonicaRespuesta
	 */
	public ConsultaInformacionTelefonicaRespuesta
		consultaInformacionVerificacion(String uid, ConsultaInformacionTelefonicaPeticion peticion) {
		ConsultaInformacionTelefonicaRespuesta respuesta = new ConsultaInformacionTelefonicaRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyyMMdd");

		SqlSession  		sessionNTx	  		= null;


		Solicitud			solicitud			= null;
		Cliente 			clienteParser 		= null;
		List<Cliente> 		listClientesParser	= null;
		Telefono 			telefonoParser  	= null;
		List<Telefono> 		listTelefonosParser = null;
		String 				cadenaSIMACC		= "";

		try {

			//Se abre la session No transaccional sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			//Objeto que contendra todos los datos de la Solicitud
			solicitud		 = new Solicitud();

			if (peticion.getIdSolicitud() == null || peticion.getIdSolicitud().trim().isEmpty()) {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.verificacion.telefonica.consultainformacionverificacion.peticion" ) );
			}

			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put( "idSolicitud"		 , peticion.getIdSolicitud() );

			//se realiza la consulta en Oracle
			LogHandler.trace(uid, getClass(), "==> consultaInformacionVerificacion - consultaInformacionVerificacion" );
			@SuppressWarnings("unchecked")
			final java.util.ArrayList<HashMap<String, Object>> coincidencias
				= (java.util.ArrayList<HashMap<String, Object>>) sessionNTx.selectList(
															"consultaInformacionVerificacion", parametros );

			if (coincidencias.size() == 0 ) {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.verificacion.telefonica.consultainformacionverificacion.solicitud" ) );
			}

			//Datos de la Solicitud
			solicitud.setCampanaCliente(CAMPANA);
			solicitud.setClaveCliente(CLIENTE);
			LogHandler.trace(uid, getClass(), "==> TIPO PRODUCTO"  + coincidencias.get(0).get( "TIPO_PRODUCTO").toString());
			solicitud.setTipoProducto(coincidencias.get(0).get( "TIPO_PRODUCTO").toString());
			SimpleDateFormat formatoFechaSolicitud = new SimpleDateFormat("yyMMddHHmm");

			//Solicitud CALL CENTER
			String idSolciitudCallCenter = peticion.getIdSolicitud() + "_"
										 + formatoFechaSolicitud.format( new java.util.Date() );

			solicitud.setIdEnvio(idSolciitudCallCenter);


			listClientesParser 	= new ArrayList<Cliente>();

			//Se obtienen el campo de clave_Finsol
			for ( HashMap<String, Object> clientes : coincidencias ) {

				//Obteniendo claveFinsol de Oracle
				final HashMap<String, Object> parametrosCveFinsolOracle = new HashMap<String, Object>();
				parametrosCveFinsolOracle.put("claveFinsolOracle", clientes.get( "CLAVE_FINSOL").toString());
				LogHandler.trace(uid, getClass(), "==> consultaInformacionVerificacion - obtenerClaveFinsolSybase" );

				//Obteniendo clave_finsol de Sybase
				@SuppressWarnings("unchecked")
				final java.util.HashMap<String, Object>	claveFinsolSybase
					= (java.util.HashMap<String, Object>) sessionNTx.selectOne("obtenerClaveFinsolSybase",
																	parametrosCveFinsolOracle);

				if (claveFinsolSybase == null ) {
					throw new Exception( ReadProperties.mensajes.getProp(
					"administracion.verificacion.telefonica.consultainformacionverificacion.clavefinsolsybase"));
				}

				//enviando clave_finsol de Sybase
				final HashMap<String, Object> parametrosCveFinsolSybase = new HashMap<String, Object>();
				parametrosCveFinsolSybase.put("claveFinsolSybase", claveFinsolSybase.get( "PERSONA").toString());
				LogHandler.trace(uid, getClass(), "==> consultaInformacionVerificacion - consultaTelefonosPersonas" );

				//obteniendo array telefonos
				@SuppressWarnings("unchecked")
				final java.util.ArrayList<HashMap<String, Object>> telefonosPersona
					= (java.util.ArrayList<HashMap<String, Object>>) sessionNTx.selectList(
										"consultaTelefonosPersonas", parametrosCveFinsolSybase );

				//telefonosPersona.size() == 0
				if (telefonosPersona.size() == 0 ) {
					throw new Exception(  "El cliente No. " + claveFinsolSybase.get( "PERSONA" ).toString()
						+ " " + ReadProperties.mensajes.getProp(
						"administracion.verificacion.telefonica.consultainformacionverificacion.sintelefonos"));
				}
				//Excepcion

				//Obteniendo datos del Cliente
				clienteParser = new Cliente();
				clienteParser.setHorarioLocalizacion(clientes.get( "HORA_REUNION") != null
												? clientes.get( "HORA_REUNION").toString() : "");
				clienteParser.setIdSucursal(clientes.get( "SUCURSAL") != null
												? clientes.get( "SUCURSAL").toString() : "");
				clienteParser.setMarcar(true);
				clienteParser.setMontoSolicitado( clientes.get( "MONTO_SOLICITADO_CLIENTE") != null
											? clientes.get( "MONTO_SOLICITADO_CLIENTE").toString() : "");
				clienteParser.setNombreGrupo(clientes.get( "NOMBRE_GRUPO") != null
											? clientes.get( "NOMBRE_GRUPO").toString() : "");
				clienteParser.setNombreIntegrante(clientes.get( "NOMBRE_CLIENTE") != null
											? clientes.get( "NOMBRE_CLIENTE").toString() : "");
				//Nombre Recadero
				clienteParser.setNombreRecadero("");
				clienteParser.setNombreSucursal(clientes.get( "NOMBRE_SUCURSAL") != null
											? clientes.get( "NOMBRE_SUCURSAL").toString() : "");
				clienteParser.setNumeroPersona(claveFinsolSybase.get( "PERSONA") != null
											? claveFinsolSybase.get( "PERSONA").toString() : "");
				clienteParser.setPrioridadMarcacion("1");
				clienteParser.setReferenciaInterna(claveFinsolSybase.get( "PERSONA") != null
											? claveFinsolSybase.get( "PERSONA").toString() : "");
				clienteParser.setSolicitudGrupo(peticion.getIdSolicitud());

				String presidente = clientes.get( "PRESIDENTE") != null
									? clientes.get( "PRESIDENTE").toString().trim() : "";
				String secretario = clientes.get( "SECRETARIO") != null
									? clientes.get( "SECRETARIO").toString().trim() : "";
				String tesorero = clientes.get( "TESORERO") != null
									? clientes.get( "TESORERO").toString().trim() : "";
				String coordinador = clientes.get( "COORDINADOR") != null
						? clientes.get( "COORDINADOR").toString().trim() : "";

				if (presidente.equals( clientes.get( "NUMERO_PERSONA").toString() )) {
					clienteParser.setPuesto("PRESIDENTE");
					clienteParser.setServicio("MESA_DIRECTIVA");
				} else if (secretario.equals( clientes.get( "NUMERO_PERSONA").toString() )) {
					clienteParser.setPuesto("SECRETARIO");
					clienteParser.setServicio("MESA_DIRECTIVA");
				} else if (tesorero.equals( clientes.get( "NUMERO_PERSONA").toString() )) {
					clienteParser.setPuesto("TESORERO");
					clienteParser.setServicio("MESA_DIRECTIVA");
				} else if (coordinador.equals( clientes.get( "NUMERO_PERSONA").toString() )) {
					clienteParser.setPuesto("COORDINADOR");
					clienteParser.setServicio("MESA_DIRECTIVA");
				} else {
					clienteParser.setPuesto("");
					clienteParser.setServicio("INTEGRANTE");
				}

				clienteParser.setNumeroIntegrantesGrupo(String.valueOf(coincidencias.size()) );
				listTelefonosParser = new ArrayList<Telefono>(INUMERO_TELEFONOS);

				//Inicializamos Telefonos
				for (int i = 1; i <= INUMERO_TELEFONOS; i++) {
					listTelefonosParser.add( new Telefono( "XXXX", "", "", "19000101" , ""));
				}
				boolean telDIRE = false;
				boolean telCELU = false;
				boolean telEMPL = false;
				boolean telRECA = false;

				for ( HashMap<String, Object> telefonos : telefonosPersona )	{
					//enviando informacion de telefonos
					//1 DIRE
					//2 CELU
					//3 EMPL
					//4 RECA

					if ( telefonos.get( "TIPO_TELEFONO").equals("DIRE") && !telDIRE) {
						telefonoParser = new Telefono(
							telefonos.get( "TIPO_TELEFONO") != null ? telefonos.get( "TIPO_TELEFONO").toString() : "",
							telefonos.get( "TELEFONO") != null ? telefonos.get( "TELEFONO").toString() : "",
							telefonos.get( "STATUS") != null ? telefonos.get( "STATUS").toString() : "",
							telefonos.get( "FECHA_ULT_VERIF") == null ? "19000101"
											: formatoDelTexto.format( telefonos.get( "FECHA_ULT_VERIF")),
							 telefonos.get( "CONSECUTIVO") != null ? telefonos.get( "CONSECUTIVO").toString() : "");
						listTelefonosParser.set(0, telefonoParser);
						telDIRE = true;
					}

					if ( telefonos.get( "TIPO_TELEFONO").equals("CELU") && !telCELU) {
						telefonoParser = new Telefono(
							telefonos.get("TIPO_TELEFONO") != null ? telefonos.get( "TIPO_TELEFONO").toString() : "",
							telefonos.get( "TELEFONO") != null ? telefonos.get( "TELEFONO").toString() : "",
							telefonos.get( "STATUS") != null ? telefonos.get( "STATUS").toString() : "",
							telefonos.get( "FECHA_ULT_VERIF") == null ? "19000101"
											: formatoDelTexto.format( telefonos.get( "FECHA_ULT_VERIF")),
							telefonos.get( "CONSECUTIVO") != null ? telefonos.get( "CONSECUTIVO").toString() : "");
						listTelefonosParser.set(1, telefonoParser);
						telCELU = true;
					}

					if ( telefonos.get( "TIPO_TELEFONO").equals("EMPL") && !telEMPL) {
						telefonoParser = new Telefono(
								telefonos.get("TIPO_TELEFONO") != null ? telefonos.get( "TIPO_TELEFONO").toString() : "",
								telefonos.get( "TELEFONO") != null ? telefonos.get( "TELEFONO").toString() : "",
								telefonos.get( "STATUS") != null ? telefonos.get( "STATUS").toString() : "",
								telefonos.get( "FECHA_ULT_VERIF") == null ? "19000101"
												: formatoDelTexto.format( telefonos.get( "FECHA_ULT_VERIF")),
								telefonos.get( "CONSECUTIVO") != null ? telefonos.get( "CONSECUTIVO").toString() : "");
						listTelefonosParser.set(2, telefonoParser);
						telEMPL = true;
					}

					if ( telefonos.get( "TIPO_TELEFONO").equals("RECA") && !telRECA) {
						telefonoParser = new Telefono(
								telefonos.get("TIPO_TELEFONO") != null ? telefonos.get( "TIPO_TELEFONO").toString() : "",
								telefonos.get( "TELEFONO") != null ? telefonos.get( "TELEFONO").toString() : "",
								telefonos.get( "STATUS") != null ? telefonos.get( "STATUS").toString() : "",
								telefonos.get( "FECHA_ULT_VERIF") == null ? "19000101"
												: formatoDelTexto.format( telefonos.get( "FECHA_ULT_VERIF")),
								telefonos.get( "CONSECUTIVO") != null ? telefonos.get( "CONSECUTIVO").toString() : "");
						listTelefonosParser.set(TRES, telefonoParser);

						clienteParser.setNombreRecadero(
								 (telefonos.get( "NOMBRE") != null ? telefonos.get( "NOMBRE").toString() : "") + " "
								+ (telefonos.get( "APELLIDO_PAT") != null ? telefonos.get( "APELLIDO_PAT").toString() : "") + " "
								+ (telefonos.get( "APELLIDO_MAT") != null ? telefonos.get( "APELLIDO_MAT").toString() : ""));
						telRECA = true;
					}

//					//Recadero
//		if(telefonoParser.getTipoTelefono().equals("RECA")){
//
//		clienteParser.setNombreRecadero( (telefonos.get( "NOMBRE") != null ? telefonos.get( "NOMBRE").toString() : "") + " " +
//							 (telefonos.get( "APELLIDO_PAT") != null ? telefonos.get( "APELLIDO_PAT").toString() : "") + " " +
//							 (telefonos.get( "APELLIDO_MAT") != null ? telefonos.get( "APELLIDO_MAT").toString() : "")
//							);
//					}

				}

				//Agregar telefonos faltantes al cliente

				if (!telDIRE) {
					telefonoParser = new Telefono( "DIRE", "", "", "19000101" , "");
					listTelefonosParser.set(0, telefonoParser);
				}
				if (!telCELU) {
					telefonoParser = new Telefono( "CELU", "", "", "19000101" , "");
					listTelefonosParser.set(1, telefonoParser);
				}
				if (!telEMPL) {
					telefonoParser = new Telefono( "EMPL", "", "", "19000101" , "");
					listTelefonosParser.set(2, telefonoParser);
				}
				if (!telRECA) {
					telefonoParser = new Telefono( "RECA", "", "", "19000101" , "");
					listTelefonosParser.set(TRES, telefonoParser);
				}



				//5 RE1D
				//6 RE1C
				//7 RE2D
				//8 RE2C
				//9 CONC O COND
				//Agregar telefonos faltantes DEFAULT cliente

				telefonoParser = new Telefono( "RE1D", "", "", "19000101" , "");
				listTelefonosParser.set(CUATRO, telefonoParser);
				telefonoParser = new Telefono( "RE1C", "", "", "19000101" , "");
				listTelefonosParser.set(CINCO, telefonoParser);
				telefonoParser = new Telefono( "RE2D", "", "", "19000101" , "");
				listTelefonosParser.set(SEIS, telefonoParser);
				telefonoParser = new Telefono( "RE2C", "", "", "19000101" , "");
				listTelefonosParser.set(SIETE, telefonoParser);
				telefonoParser = new Telefono( "CONC", "", "", "19000101" , "");
				listTelefonosParser.set(OCHO, telefonoParser);



				//enviando lista de telefonos
				clienteParser.setTelefonos(listTelefonosParser);


				listClientesParser.add(clienteParser);


			}
			//enviando lista de clientes
			//Jon ??? no hay set, por que es fijo 9????
			//solicitud.setTotalNumerosTelefonicosRegistro(NUMERO_TELEFONOS);
			solicitud.setClientes(listClientesParser);
			cadenaSIMACC = ParserSIMAC.parse(solicitud);
			respuesta.setCadenaSIMACC(cadenaSIMACC);
			respuesta.setIdSolicitudCC(idSolciitudCallCenter);

		}
		catch ( java.lang.Exception exception ) {
		LogHandler.error(uid, getClass(), "consultaInformacionVerificacion() => ", exception);
		respuesta.getHeader().setUID( uid );
		respuesta.getHeader().setEstatus( false );
		respuesta.getHeader().setMensaje( exception.getMessage() );
		}
	finally {
		FabricaConexiones.close( sessionNTx );
//		FabricaConexiones.close( sessionOracleNTx );	MO
		}
		return respuesta;
	}


	/**
	 * Bitacora verificacion telefonica.
	 *
	 * @param uid :
	 * @param peticion :
	 * @param sesion the sesion
	 * @return RegistraBitacoraRespuesta
	 */
	public RegistraBitacoraRespuesta bitacoraVerificacionTelefonica(String uid,  RegistraBitacoraPeticion peticion,
			SqlSession sesion) {

		RegistraBitacoraRespuesta respuesta = new RegistraBitacoraRespuesta();

		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession  sessionNTx	  	= null;
		SqlSession  sessionTx	  	= null;
		boolean sesionExterna = false;

		try {

			if (sesion == null) {
				sessionTx = FabricaConexiones.obtenerSesionTx();
			} else {
				sessionTx = sesion;
				sesionExterna = true;
			}

			LogHandler.trace(uid, getClass(), "==> bitacoraVerificacionTelefonica - peticion:" + peticion );

			if (peticion.getIdSolicitud() == null || peticion.getIdSolicitud().trim().isEmpty()) {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.verificacion.telefonica.bitacora.peticion" ));
			}

			//Se abre la session No transaccional sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put( "idSolicitud"		 , peticion.getIdSolicitud() );

			//se realiza la consulta
			LogHandler.trace(uid, getClass(), "==> bitacoraVerificacionTelefonica - existeBitacoraSolicitud" );
			final Integer 	registros = (Integer) sessionNTx.selectOne( "existeBitacoraSolicitud", parametros );

			if (registros.intValue() == 0) {

				//Inserta solicitud

				if (peticion.getUsuarioEnvioVerificacion() == null || peticion.getUsuarioEnvioVerificacion().trim().isEmpty()) {
					throw new Exception( ReadProperties.mensajes.getProp(
							"administracion.verificacion.telefonica.bitacora.usuaerioenvio" ) );
				}

				parametros.put( "estatusVerificacion"		  , peticion.getEstatusVerificacion() != null
														?   peticion.getEstatusVerificacion() : CODIGO_ENVIO );
				parametros.put( "fechaEnvioVerificacion"      , new java.util.Date() );
				parametros.put( "usuarioEnvioVerificacion"	  , peticion.getUsuarioEnvioVerificacion() != null
														? peticion.getUsuarioEnvioVerificacion() : "000000043"  );
				parametros.put( "solicitudCC"	  , peticion.getIdSolicitudCC() != null ? peticion.getIdSolicitudCC() : ""  );

				//2013-08-23 Se agrega sucursal y nombre Grupo
				parametros.put( "sucursal"	  , peticion.getSucursal() != null ?  peticion.getSucursal() : 0  );
				parametros.put( "nombreGrupo"	  , peticion.getNombreGrupo() != null ? peticion.getNombreGrupo().trim() : ""  );


				//se realiza la consulta
				LogHandler.trace(uid, getClass(), "==> bitacoraVerificacionTelefonica - registroBitacoraSolicitud" );
				sessionTx.insert( "registroBitacoraSolicitud", parametros );

				if ( peticion.isRespuestaCC() ) {
					parametros.put( "fechaRespuestaVerificacion"  , new java.util.Date() );
					parametros.put( "comentariosEnvioVerificacion", peticion.getComentariosEnvioVerificacion() != null
															?  peticion.getComentariosEnvioVerificacion() : "" );

					//se realiza la actualizacion
					LogHandler.trace(uid, getClass(), "==> bitacoraVerificacionTelefonica - actualizarBitacoraSolicitud" );
					Integer actualizados = sessionTx.update( "actualizarBitacoraSolicitud", parametros );
					LogHandler.info(uid, getClass(),
						"==> bitacoraVerificacionTelefonica - actualizarBitacoraSolicitud - actualizados = " + actualizados );
				}

			}
			else {
				//Actualiza solicitud

				if (peticion.isEnvioVerificacion() )	{
					parametros.put( "estatusVerificacion"		  , CODIGO_ENVIO  );
					parametros.put( "fechaEnvioVerificacion"	  , new java.util.Date()  );
					parametros.put( "usuarioEnvioVerificacion"	  ,
							peticion.getUsuarioEnvioVerificacion() != null ? peticion.getUsuarioEnvioVerificacion() : ""  );
					parametros.put( "solicitudCC"	  			  ,
							peticion.getIdSolicitudCC() != null ? peticion.getIdSolicitudCC() : ""  );
				}
				else if (peticion.isAprobacion() )	{
					parametros.put( "estatusAprobacion"		 	  ,
							peticion.getEstatusAprobacion() != null ? peticion.getEstatusAprobacion() : "" );
					parametros.put( "fechaAprobacion"		 	  , new java.util.Date()  );
					parametros.put( "usuarioAprobacion"		      ,
							peticion.getUsuarioAprobacion() != null ? peticion.getUsuarioAprobacion() : "000000043" );
				} else if (peticion.isRespuestaCC() ) {
					parametros.put( "fechaRespuestaVerificacion"  , new java.util.Date() );
					parametros.put( "estatusVerificacion"		  ,
							peticion.getEstatusVerificacion() != null ?  peticion.getEstatusVerificacion() : "" );
					parametros.put( "comentariosEnvioVerificacion",
							peticion.getComentariosEnvioVerificacion() != null
									 ?  peticion.getComentariosEnvioVerificacion() : "" );
					parametros.put( "solicitudCC"	  			  ,
							peticion.getIdSolicitudCC() != null ? peticion.getIdSolicitudCC() : ""  );
				}

				//se realiza la actualizacion
				LogHandler.trace(uid, getClass(), "==> bitacoraVerificacionTelefonica - actualizarBitacoraSolicitud" );
				Integer actualizados = sessionTx.update( "actualizarBitacoraSolicitud", parametros );
				LogHandler.info(uid, getClass(),
						"==> bitacoraVerificacionTelefonica - actualizarBitacoraSolicitud - actualizados = " + actualizados );

			}

			if (!sesionExterna) {
				sessionTx.commit(true);
			}
		}
		catch ( java.lang.Exception exception ) {
		LogHandler.error(uid, getClass(), "bitacoraVerificacionTelefonica() ", exception);
		respuesta.getHeader().setUID( uid );
		respuesta.getHeader().setEstatus( false );
		respuesta.getHeader().setMensaje( "bitacoraVerificacionTelefonica() " + exception.getMessage() );

		if (!sesionExterna) {
			FabricaConexiones.rollBack(sessionTx);
		}

		}
	finally {
		FabricaConexiones.close( sessionNTx );

		if (!sesionExterna) {
			FabricaConexiones.close( sessionTx );
		}

	  }
		return respuesta;
	}

	/**
	 * @param uid :
	 * @param peticion :
	 * @return RespuestainformacionVerificacion
	 */
	public RespuestainformacionVerificacion respuestainformacionVerificacion(String uid, String peticion) {
		RespuestainformacionVerificacion respuesta  = new RespuestainformacionVerificacion();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession  sessionNTx	  	= null;
		SqlSession  sessionTx	  	= null;

		try {
			if (peticion == null || peticion.trim().isEmpty()) {
				throw new Exception(ReadProperties.mensajes.getProp(
						"administracion.verificacion.telefonica.respuestainformacionVerificacion.peticion" ) );
			}

			//Se abre la session Transaccional sybase
		      sessionTx = FabricaConexiones.obtenerSesionTx();

			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse( new ByteArrayInputStream(peticion.getBytes()) );
			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName( "Solicitud" );

			for (int iSolicitudes = 0; iSolicitudes < nList.getLength(); iSolicitudes++) {
				 Node nodeSolicitud = nList.item(iSolicitudes);

				 if (nodeSolicitud.getNodeType() == Node.ELEMENT_NODE) {
	   			      Element elementSolicitud = (Element) nodeSolicitud;
	   			      String numeroSolicitudCC = elementSolicitud.getAttribute("Numero_solicitud").trim();
	   			      String numeroSolicitud = numeroSolicitudCC.split("_")[0].trim();
	   			      String fechaHoraGestion = elementSolicitud.getAttribute("Fecha_hora_gestion").trim();
				      String comentarios = elementSolicitud.getAttribute("Comentarios").trim();
				      String agente = elementSolicitud.getAttribute("Agente").trim();
				      String codigo1 = elementSolicitud.getAttribute("Codigo1").trim();
				      String codigo2 = elementSolicitud.getAttribute("Codigo2").trim();

				      LogHandler.info(uid, getClass(), 	"numeroSolicitud=" + numeroSolicitud
				    		  						 + "fechaHoraGestion=" + fechaHoraGestion
				    		  						 + "Comentarios=" + comentarios
				    		  						 + "agente=" + agente
				    		  						 + "codigo1=" + codigo1
				    		  						 + "codigo2=" + codigo2   );

				      RegistraBitacoraPeticion peicionActualizaBitacora = new RegistraBitacoraPeticion();
				      peicionActualizaBitacora.setIdSolicitud(numeroSolicitud);
				      peicionActualizaBitacora.setEstatusVerificacion(codigo1);
				      peicionActualizaBitacora.setComentariosEnvioVerificacion(comentarios);
				      peicionActualizaBitacora.setEnvioVerificacion(false);
				      peicionActualizaBitacora.setAprobacion(false);
				      peicionActualizaBitacora.setRespuestaCC(true);
				      peicionActualizaBitacora.setUsuarioEnvioVerificacion("000000043");
				      peicionActualizaBitacora.setIdSolicitudCC(numeroSolicitudCC);

				      RegistraBitacoraRespuesta respuestaActualizaBitacora
				      = bitacoraVerificacionTelefonica(uid,  peicionActualizaBitacora, sessionTx);

				      if (!respuestaActualizaBitacora.getHeader().isEstatus()) {
				    	  LogHandler.error(uid, getClass(),
				    			  "respuestainformacionVerificacion() => bitacoraVerificacionTelefonica "
				    			  + respuestaActualizaBitacora.getHeader().getMensaje(), null);
				      }

				      //Se abre la session No transaccional sybase
				      sessionNTx = FabricaConexiones.obtenerSesionNTx();


				      //Obtener el - valor de solicitud no Valida
				      final java.util.HashMap<String, Object> params = new HashMap<String, Object>();
				      params.put( "tipoCalculoInteres"	, "VTSV" );
					  params.put( "sucursal"  			, 0 );
					  params.put( "fechaContrato"	    , new Date() );

					  LogHandler.trace(uid, this.getClass(), "==> respuestainformacionVerificacion - ver_valor_hist_datos");
					  final java.lang.String  solicitudValidaCallCenter
					        = (java.lang.String) sessionNTx.selectOne( "obtenerValorTipoCalculoInteres", params );


					  LogHandler.info(uid, getClass(), "Valor Historico de VTSV =" + solicitudValidaCallCenter);

				      if (peicionActualizaBitacora.getEstatusVerificacion().trim().equals(solicitudValidaCallCenter.trim())) {
				    	  final java.util.HashMap<String, Object> paramsSolicitudOracle = new HashMap<String, Object>();
				    	  paramsSolicitudOracle.put("id", numeroSolicitud.trim());
				    	  paramsSolicitudOracle.put("visualiza_cec", "false");
				    	  LogHandler.trace(uid, this.getClass(),
				    			  "==> respuestainformacionVerificacion - actualizacionSolicitudMO");
				    	  sessionTx.update("actualizacionSolicitudMO", paramsSolicitudOracle);
				      }

				      //SELECT codigo,descripcion FROM codigos WHERE tipo_codigo = 'VTIT' and status = 'A'
				      final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
				      parametros.put( "tipoCodigo"		 , CATALOGOS_VT_TIPO_CODIGO );
					  parametros.put( "status"		 	 , CATALOGOS_VT_ESTATUS);
					  LogHandler.trace(uid, getClass(),
							  "==> respuestainformacionVerificacion - consultaCatalogosVerificacionTelefonica" );

					  //obteniendo array codigos
					  @SuppressWarnings("unchecked")
					  final java.util.ArrayList<HashMap<String, Object>> codigosValidacionTelefonica
					    = (java.util.ArrayList<HashMap<String, Object>>) sessionNTx.selectList(
					    					"consultaCatalogosVerificacionTelefonica", parametros );


					  if (codigosValidacionTelefonica == null ) {
							throw new Exception( ReadProperties.mensajes.getProp(
								"administracion.verificacion.telefonica.respuestainformacionVerificacion.catalogos" ) );
					  }

					  Map<String, String> mapCodigos		= new HashMap<String, String>();
					  for ( HashMap<String, Object> codigo : codigosValidacionTelefonica ) {
						  mapCodigos.put( codigo.get( "DESCRIPCION").toString().trim(),
								  codigo.get( "CODIGO").toString().trim() );
					  }

				      NodeList nListIntegrantes  = elementSolicitud.getElementsByTagName("Integrante");

				      for (int iIntegrantes = 0; iIntegrantes < nListIntegrantes.getLength(); iIntegrantes++) {
				    	  Node  integrante = nListIntegrantes.item(iIntegrantes);

				    	  if (integrante.getNodeType() == Node.ELEMENT_NODE) {
			   			      Element elementIntegrante = (Element) integrante;
			   			      String numeroPersona = elementIntegrante.getAttribute("Numero_Persona").trim();
			   			      NodeList nListTelefonos  = elementIntegrante.getElementsByTagName("Telefono");
			   			      for (int iTelefonos = 0; iTelefonos < nListTelefonos.getLength(); iTelefonos++) {
						    	  Node  telefono = nListTelefonos.item(iTelefonos);
						    	  Element elementTelefono = (Element) telefono;
						    	  String sTelefono = elementTelefono.getAttribute("Tel").trim();
				   			      String tipoTelefono = elementTelefono.getAttribute("Tipo_telefono").trim();
				   			      String fechaHoraGestionTelefono = elementTelefono.getAttribute("Fecha_hora_gestion").trim();				   			      
				   			      String codigo1Telefono = elementTelefono.getAttribute("Codigo1").trim();				   			      
				   			      String codigo2Telefono = elementTelefono.getAttribute("Codigo1").trim();				   			      
				   			      String consecutivo = elementTelefono.getAttribute("Consecutivo").trim();				   			      
				   			      String tipoTelCallCenter = elementTelefono.getAttribute("Tipo_tel_callcenter").trim();				   			      
				   			      String carrier = elementTelefono.getAttribute("Carrier").trim();				   			      
				   			      String modalidad = elementTelefono.getAttribute("Modalidad").trim();				   			      

				   			      //2013-08-15 Se agrega el tipo telefono correcto de Call Center.
				   			      String tipoTelCorrecto = elementTelefono.getAttribute("Tipo_tel_correcto").trim();

				   			      final java.util.HashMap<String, Object> parametrosUpdate = new HashMap<String, Object>();

				   			      String codigoResolucion = mapCodigos.get(codigo1Telefono.trim());

				   			      codigoResolucion = codigoResolucion == null ? codigo1Telefono.trim() : codigoResolucion.trim();

					   			   if (codigoResolucion.equals("TEVA")) {
					   				   	//Estatus valido A con tipo telefono correcto
			   			    			parametrosUpdate.put( "status"		   , "A");
			   			    			parametrosUpdate.put( "motivo"		   , "VALI");
			   			    			parametrosUpdate.put( "fechaUltVer"		   ,
			   			    							fechaHoraGestionTelefono != null ? fechaHoraGestionTelefono : "");
			   			    			parametrosUpdate.put( "fechaContacto"	   ,
			   			    							fechaHoraGestionTelefono != null ? fechaHoraGestionTelefono : "");

			   			    		} else if (codigoResolucion.equals("TEVC")) {
					   			   		//Estatus valido A con tipo telefono incorrecto

			   			    			if (tipoTelCorrecto.isEmpty() || tipoTelCorrecto.length() != CUATRO ) {
			   			    				throw new Exception(
			   			    					"El tipo de telefono correcto de la respuesta de verificaci�n es incorrecto.");
			   			    			}

			   			    			parametrosUpdate.put( "status"		   , "A");
			   			    			parametrosUpdate.put( "motivo"		   , "VALI");
			   			    			parametrosUpdate.put( "fechaUltVer"		   ,
			   			    							fechaHoraGestionTelefono != null ? fechaHoraGestionTelefono : "");
			   			    			parametrosUpdate.put( "fechaContacto"	   ,
			   			    							fechaHoraGestionTelefono != null ? fechaHoraGestionTelefono : "");
			   			    			parametrosUpdate.put( "tipoTelefonoCorrecto" , tipoTelCorrecto );


			   			    			//Se obtiene el consecutivo del tipo Telefono recibido

			   			    			final java.util.HashMap<String, Object> parametrosObtenerConsecutivo
			   			    					= new HashMap<String, Object>();
			   			    			parametrosObtenerConsecutivo.put("persona", numeroPersona != null ? numeroPersona : "");
			   			    			parametrosObtenerConsecutivo.put("tipoTelefono", tipoTelCorrecto);

			   			    			Integer iConsecutivo = (Integer) sessionTx.selectOne(
			   			    							"obtenerConseutivoTelefonos", parametrosObtenerConsecutivo );
			   			    			iConsecutivo++;
			   			    			String consecutivoNuevo = iConsecutivo.toString();
			   			    			parametrosUpdate.put( "consecutivoNuevo" , consecutivoNuevo );

			   			    		} else if (codigoResolucion.equals("NDIN") || codigoResolucion.equals("NRIN")) {
					   			   		//Estatus invalido pero no se debe marcar con I
			   			    			parametrosUpdate.put( "status"		   , "V");
			   			    			parametrosUpdate.put( "motivo"		   , "");
			   			    			parametrosUpdate.put( "fechaUltVer"		   ,
			   			    					fechaHoraGestionTelefono != null ? fechaHoraGestionTelefono : "");
			   			    			parametrosUpdate.put( "fechaContacto"	   , "");
			   			    		}
			   			    		else {
			   			    			//Estatus invalido I
			   			    			parametrosUpdate.put( "status"		   , "I" );
			   			    			parametrosUpdate.put( "motivo"		   , "INVA");
			   			    			parametrosUpdate.put( "fechaUltVer"		   ,
			   			    					fechaHoraGestionTelefono != null ? fechaHoraGestionTelefono : "");
			   			    			parametrosUpdate.put( "fechaContacto"	   ,
			   			    					fechaHoraGestionTelefono != null ? fechaHoraGestionTelefono : "");
			   			    		}

			   			    		parametrosUpdate.put( "tipoPlan"		   , modalidad != null ? modalidad : "");
			   			    		parametrosUpdate.put( "cveProveeServicios" , carrier != null ? carrier : "");
			   			    		parametrosUpdate.put( "persona"		 	   , numeroPersona != null ? numeroPersona : "");
			   			    		parametrosUpdate.put( "tipoTelefono"	   , tipoTelefono != null ? tipoTelefono : "");
			   			    		parametrosUpdate.put( "telefono"		   , sTelefono != null ? sTelefono : "");
			   			    		parametrosUpdate.put( "consecutivo"		   , consecutivo != null ? consecutivo : "");
			   			    		parametrosUpdate.put( "codigoResolucion"   ,
			   			    				 	codigoResolucion != null ? codigoResolucion : "");

			   			    		LogHandler.trace(uid, getClass(),
			   			    				"==> respuestainformacionVerificacion - actualizarPersonaTelefono" );
			   			    		Integer actualizados = sessionTx.update( "actualizarPersonaTelefono", parametrosUpdate );
			   						LogHandler.info(uid, getClass(),
			   								"==> respuestainformacionVerificacion - actualizarPersonaTelefono - actualizados = "
			   								+ actualizados );
			   						sessionTx.commit(true);

				   			      //Valido TEVA  = 'A' los demas 'I'

				   			      /*
				   			      	status  = 'I'
				   					fecha_status = getdate(),
				   					fecha_ult_mod = getdate(),
				   					fecha_ult_ver = Fecha_hora_gestion,
				   					motivo = 'INVA'
				   					codigo_resolucion = $CATALOGO

				   					***

				   					status  = 'A'
				   					fecha_status = getdate(),
				   					fecha_ult_mod = getdate(),
				   					fecha_ult_ver = Fecha_hora_gestion,
				   					fecha_contacto = Fecha_hora_gestion
				   					motivo = 'VALI'
				   					tipo_plan = Modalidad,
				   					cve_provee_servicios = Carrier
				   					codigo_resolucion = 'TEVA'

				   					WHERE
				   					persona
				   					tipo_telefono
				   					telefono
				   					consecutivo
				   				 */

			   			      }
						 }
				      }
				 }

			}
		}
		catch ( java.lang.Exception exception )	{
			LogHandler.error(uid, getClass(), "respuestainformacionVerificacion() ", exception);
			FabricaConexiones.rollBack( sessionTx );
			respuesta.getHeader().setUID( uid );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setMensaje( "respuestainformacionVerificacion() " + exception.getMessage() );
		}
		finally {
			FabricaConexiones.close( sessionNTx );
			FabricaConexiones.close( sessionTx );
		}

		return respuesta;
	}



	/**
	 * @param uid :
	 * @param peticion :
	 * @return ValidaStatusSolicitudRespuesta
	 */
	public ValidaStatusSolicitudRespuesta validaEstadoSolicitud(String uid,	ValidaStatusSolicitudPeticion peticion) {
		ValidaStatusSolicitudRespuesta	respuesta = new ValidaStatusSolicitudRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession  					sessionNTx	  					= null;


		BitacoraVerificacionFinsolOV	bitacoraVerificacionFinsolOV	= null;
		IntegrantesOV 					integrante 						= null;
		List<IntegrantesOV> 			listIntegrantes					= null;
		TelefonoOV 						telefonoOV  					= null;
		List<TelefonoOV> 				listTelefonos 					= null;
		SolicitudOV						solicitud						= null;
		EstadoSolicitudOV				estadoSolicitudOV				= null;
		DateFormat 						df 		  						= null;
		int								counter							= 0;

		try {
			if (peticion.getIdSolicitud() == null || peticion.getIdSolicitud().trim().isEmpty()) {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.verificacion.telefonica.validaestadosolicitud.peticion" ) );
			}
			//Se abre la session No transaccional Sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();


			//Objeto que contendra todos los datos del Estado Solicitud
			estadoSolicitudOV = new EstadoSolicitudOV();

			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put( "idSolicitud"		 , peticion.getIdSolicitud() );
			//se realiza la consulta
			LogHandler.trace(uid, getClass(), "==> validaEstadoSolicitud - consultaBitacoraVerificacionFinsol" );
			@SuppressWarnings("unchecked")
			final java.util.HashMap<String, Object>	coincidencias
				= (java.util.HashMap<String, Object>) sessionNTx.selectOne( "consultaBitacoraVerificacionFinsol", parametros );

			//Obteniendo Datos de la Bitacora
			bitacoraVerificacionFinsolOV 	= new BitacoraVerificacionFinsolOV();
			df 		   						= new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat dfCompleta  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

			if (coincidencias == null ) {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.verificacion.telefonica.validaestadosolicitud.bitacora" ) );
			}


			bitacoraVerificacionFinsolOV.setEstatusAprobacion(
					coincidencias.get( "ESTATUS_APROBACION") != null
					? coincidencias.get( "ESTATUS_APROBACION").toString().trim() : "");
			bitacoraVerificacionFinsolOV.setEstatusVerificacion(
					coincidencias.get( "ESTATUS_VERIFICACION") != null
					? coincidencias.get( "ESTATUS_VERIFICACION").toString().trim() : "");
			bitacoraVerificacionFinsolOV.setFechaAprobacion(
					coincidencias.get( "FECHA_APROBACION") == null
					? df.parse("1900-01-01") : dfCompleta.parse(coincidencias.get( "FECHA_APROBACION").toString()));
			bitacoraVerificacionFinsolOV.setFechaEnvioVerificacion(
					coincidencias.get( "FECHA_ENVIO_VERIFICACION") == null
					? df.parse("1900-01-01") : dfCompleta.parse(coincidencias.get( "FECHA_ENVIO_VERIFICACION").toString()));
			bitacoraVerificacionFinsolOV.setFechaRespuestaVerificacion(
					coincidencias.get( "FECHA_RESPUESTA_VERIFICACION") == null
					? df.parse("1900-01-01") : dfCompleta.parse(coincidencias.get( "FECHA_RESPUESTA_VERIFICACION").toString()));
			bitacoraVerificacionFinsolOV.setSolicitud(
					coincidencias.get( "SOLICITUD") != null
					? coincidencias.get( "SOLICITUD").toString() : "");
			bitacoraVerificacionFinsolOV.setUsuarioAprobacion(
					coincidencias.get( "USUARIO_APROBACION") != null
					? coincidencias.get( "USUARIO_APROBACION").toString() : "");
			bitacoraVerificacionFinsolOV.setUsuarioEnvioVerificacion(
					coincidencias.get( "USUARIO_ENVIO_VERIFICACION") != null
					? coincidencias.get( "USUARIO_ENVIO_VERIFICACION").toString() : "");
			bitacoraVerificacionFinsolOV.setComentariosEnvioVerificacion(
					coincidencias.get( "COMENTARIOS_ENVIO_VERIFICACION") != null
					? coincidencias.get( "COMENTARIOS_ENVIO_VERIFICACION").toString() : "");


			estadoSolicitudOV.setBitacoraVerificacionFinsolOV(bitacoraVerificacionFinsolOV);

			//se realiza la consulta en Oracle
			LogHandler.trace(uid, getClass(), "==> validaEstadoSolicitud - consultaInformacionVerificacion" );
			@SuppressWarnings("unchecked")
			final java.util.ArrayList<HashMap<String, Object>> coincidenciasSolicitud
				= (java.util.ArrayList<HashMap<String, Object>>) sessionNTx.selectList( "consultaInformacionVerificacion",
																					  parametros );

			if (coincidenciasSolicitud == null || coincidenciasSolicitud.size() == 0) {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.verificacion.telefonica.validaestadosolicitud.solicitud" ) );
			}

			listIntegrantes	= new ArrayList<IntegrantesOV>();
			solicitud		= new SolicitudOV();
			//Se obtienen el campo de clave_Finsol

			 final java.util.HashMap<String, Object> parametrosCodigos = new HashMap<String, Object>();
			 parametrosCodigos.put( "tipoCodigo"		 , CATALOGOS_VT_TIPO_CODIGO );
			 parametrosCodigos.put( "status"		 	 , CATALOGOS_VT_ESTATUS);
			  LogHandler.trace(uid, getClass(),
					  "==> respuestainformacionVerificacion - consultaCatalogosVerificacionTelefonica" );

			 //obteniendo array codigos
			  @SuppressWarnings("unchecked")
			  final java.util.ArrayList<HashMap<String, Object>> codigosValidacionTelefonica
			      = (java.util.ArrayList<HashMap<String, Object>>) sessionNTx.selectList(
			    		  											"consultaCatalogosVerificacionTelefonica",
			    		  																parametrosCodigos );


			  if (codigosValidacionTelefonica == null ) {
					throw new Exception( ReadProperties.mensajes.getProp(
							"administracion.verificacion.telefonica.respuestainformacionVerificacion.catalogos" ) );
			  }

			  Map<String, String> mapCodigos		= new HashMap<String, String>();
			  for ( HashMap<String, Object> codigo : codigosValidacionTelefonica ) {
				  mapCodigos.put( codigo.get( "CODIGO").toString().trim() , codigo.get( "DESCRIPCION").toString().trim() );
			  }

			for ( HashMap<String, Object> integrantes : coincidenciasSolicitud )	{

				if (counter == 0) {
					//Datos de la Solicitud
					solicitud.setSucursal(integrantes.get( "SUCURSAL") != null
							? integrantes.get( "SUCURSAL").toString() : "");
					solicitud.setCdgAsesor(integrantes.get( "CDG_ASESOR") != null
							? integrantes.get( "CDG_ASESOR").toString() : "");
					solicitud.setProducto(integrantes.get( "PRODUCTO") != null
							? integrantes.get( "PRODUCTO").toString() : "");
					solicitud.setTasa(integrantes.get( "TASA") != null
							? integrantes.get( "TASA").toString() : "");
					solicitud.setPlazo(integrantes.get( "PLAZO") != null
							? integrantes.get( "PLAZO").toString() : "");
					solicitud.setFrecuenciaPago(integrantes.get( "FRECUENCIA_PAGO") != null
							? integrantes.get( "FRECUENCIA_PAGO").toString() : "");
					solicitud.setDiaReunion(integrantes.get( "DIA_REUNION") != null
							? integrantes.get( "DIA_REUNION").toString() : "");
					solicitud.setHoraReunion(integrantes.get( "HORA_REUNION") != null
							? integrantes.get( "HORA_REUNION").toString() : "");
					solicitud.setNuevoCreditoSolicitado(integrantes.get( "NUEVO_CREDITO_SOLICITADO") != null
							? (BigDecimal) integrantes.get( "NUEVO_CREDITO_SOLICITADO") : new BigDecimal(0));
					solicitud.setFechaDesembolso(integrantes.get( "FECHA_DESEMBOLSO") == null
							? null : df.parse(integrantes.get( "FECHA_DESEMBOLSO").toString()));
					solicitud.setFechaFin(integrantes.get( "FECHA_FIN") == null
							? null : df.parse(integrantes.get( "FECHA_FIN").toString()));
					solicitud.setCiclo(integrantes.get( "CICLO") != null
							? integrantes.get( "CICLO").toString() : "");
					solicitud.setCodigoGrupo(integrantes.get( "CODIGO_GRUPO") != null
							? integrantes.get( "CODIGO_GRUPO").toString() : "");
					solicitud.setNombreGrupo(integrantes.get( "NOMBRE_GRUPO") != null
							? integrantes.get( "NOMBRE_GRUPO").toString() : "");
					solicitud.setPresidente(integrantes.get( "PRESIDENTE") != null
							? integrantes.get( "PRESIDENTE").toString() : "");
					solicitud.setTesorero(integrantes.get( "TESORERO") != null
							? integrantes.get( "TESORERO").toString() : "");
					solicitud.setSecretario(integrantes.get( "SECRETARIO") != null
							? integrantes.get( "SECRETARIO").toString() : "");
				}

				//Obteniendo claveFinsol de Oracle
				final HashMap<String, Object> parametrosCveFinsolOracle = new HashMap<String, Object>();
				parametrosCveFinsolOracle.put("claveFinsolOracle", integrantes.get( "CLAVE_FINSOL").toString());
				LogHandler.trace(uid, getClass(), "==> validaEstadoSolicitud - obtenerClaveFinsolSybase" );

				//Obteniendo clave_finsol de Sybase
				@SuppressWarnings("unchecked")
				final java.util.HashMap<String, Object> claveFinsolSybase
					= (java.util.HashMap<String, Object>) sessionNTx.selectOne("obtenerClaveFinsolSybase",
																		parametrosCveFinsolOracle);

				if (claveFinsolSybase == null ) {
					throw new Exception( ReadProperties.mensajes.getProp(
							"administracion.verificacion.telefonica.validaestadosolicitud.clavefinsolsybase" ) );
				}

				//enviando clave_finsol de Sybase
				final HashMap<String, Object> parametrosCveFinsolSybase = new HashMap<String, Object>();
				parametrosCveFinsolSybase.put("claveFinsolSybase", claveFinsolSybase.get( "PERSONA").toString());
				LogHandler.trace(uid, getClass(), "==> validaEstadoSolicitud - consultaTelefonosPersonasSolicitud" );

				//obteniendo array telefonos
				@SuppressWarnings("unchecked")
				final java.util.ArrayList<HashMap<String, Object>> 	telefonosPersona
						= (java.util.ArrayList<HashMap<String, Object>>)
						sessionNTx.selectList( "consultaTelefonosPersonasSolicitud", parametrosCveFinsolSybase );

				//Obteniendo datos del Cliente
				integrante	= new IntegrantesOV();
				integrante.setCodigoCliente(claveFinsolSybase.get( "PERSONA").toString() != null
						? claveFinsolSybase.get( "PERSONA").toString() : "");
				integrante.setNombreCompleto(integrantes.get( "NOMBRE_CLIENTE") != null
						? integrantes.get( "NOMBRE_CLIENTE").toString() : "");
				integrante.setNuevoCreditoSolicitado( integrantes.get( "MONTO_SOLICITADO_CLIENTE") != null
						? (BigDecimal) integrantes.get( "MONTO_SOLICITADO_CLIENTE") : new BigDecimal(0));
				integrante.setCodigoPOCG(integrantes.get( "NUMERO_PERSONA") != null
						? integrantes.get( "NUMERO_PERSONA").toString() : "");
				integrante.setCodigoT24(integrantes.get( "CLAVE_FINSOL") != null
						? integrantes.get( "CLAVE_FINSOL").toString() : "");

				listTelefonos = new ArrayList<TelefonoOV>();
				for ( HashMap<String, Object> telefonos : telefonosPersona )	{
					//enviando informacion de telefonos
					telefonoOV = new TelefonoOV();

					String codigoResolucion = telefonos.get( "CODIGO_RESOLUCION") != null
							? telefonos.get( "CODIGO_RESOLUCION").toString() : "";
					codigoResolucion = mapCodigos.get(codigoResolucion) == null
							? codigoResolucion :  mapCodigos.get(codigoResolucion);

					telefonoOV.setCodigoResolucion(codigoResolucion);
					telefonoOV.setConsecutivo(telefonos.get( "CONSECUTIVO") != null
							? Integer.valueOf(telefonos.get( "CONSECUTIVO").toString()) : 0);
					telefonoOV.setFechaAlta(telefonos.get( "FECHA_ALTA") == null
							? null : df.parse(telefonos.get( "FECHA_ALTA").toString()));
					telefonoOV.setFechaContacto(df.parse(telefonos.get( "FECHA_CONTACTO").toString()));
					telefonoOV.setFechaStatus(telefonos.get( "FECHA_CONTACTO") == null
							? null : df.parse(telefonos.get( "FECHA_STATUS").toString()));
					telefonoOV.setFechaUltimaModificacion(telefonos.get( "FECHA_ULT_MOD") == null
							? null : df.parse(telefonos.get( "FECHA_ULT_MOD").toString()));
					telefonoOV.setFechaUltimaVerificacion(telefonos.get( "FECHA_ULT_VERIF") == null
							? null : df.parse(telefonos.get( "FECHA_ULT_VERIF").toString()));
					telefonoOV.setIdRelacion(telefonos.get("RELACION") != null
							? Integer.valueOf(  telefonos.get("RELACION").toString().trim().isEmpty()
												? "0" :  telefonos.get("RELACION").toString().trim()) : 0 );
					telefonoOV.setLada(telefonos.get( "LADA") != null
							? telefonos.get( "LADA").toString() : "");
					telefonoOV.setLugar(telefonos.get( "LUGAR") != null
							? telefonos.get( "LUGAR").toString() : "");
					telefonoOV.setNumeroPersona(telefonos.get( "PERSONA") != null
							? telefonos.get( "PERSONA").toString() : "");
					telefonoOV.setOrigen(telefonos.get( "ORIGEN") != null
							? telefonos.get( "ORIGEN").toString() : "");
					telefonoOV.setProveedorServicio(telefonos.get( "cve_provee_servicios") != null
							? telefonos.get( "cve_provee_servicios").toString() : "");
					telefonoOV.setStatus(telefonos.get( "STATUS") != null
							? telefonos.get( "STATUS").toString() : "");
					telefonoOV.setTelefono(telefonos.get( "TELEFONO") != null
							? telefonos.get( "TELEFONO").toString() : "");
					telefonoOV.setTipoPlan(telefonos.get( "TIPO_PLAN") != null
							? telefonos.get( "TIPO_PLAN").toString() : "");
					telefonoOV.setTipoTelefono(telefonos.get( "TIPO_TELEFONO") != null
							? telefonos.get( "TIPO_TELEFONO").toString() : "");
					telefonoOV.setUsuarioAlta(telefonos.get( "USUARIO_ALTA") != null
							? telefonos.get( "USUARIO_ALTA").toString() : "");
					telefonoOV.setUsuarioModificacion(telefonos.get( "USUARIO_MOD") != null
							? telefonos.get( "USUARIO_MOD").toString() : "");

					listTelefonos.add(telefonoOV);
				}
				//enviando lista de telefonos
				integrante.setListaTelefonoOVs(listTelefonos);


				listIntegrantes.add(integrante);
				counter++;

			}
			solicitud.setListaIntegrantesOVs(listIntegrantes);
			estadoSolicitudOV.setSolicitudOV(solicitud);
			respuesta.setEstadoSolicitudOV(estadoSolicitudOV);

		}
		catch ( java.lang.Exception exception ) {
		LogHandler.error(uid, getClass(), "validaEstadoSolicitud() Mensaje: ", exception);
		respuesta.getHeader().setUID( uid );
		respuesta.getHeader().setEstatus( false );
		respuesta.getHeader().setMensaje( "validaEstadoSolicitud() Mensaje: " + exception.getMessage() );
		}
		finally {
		FabricaConexiones.close( sessionNTx );

		}
		return respuesta;
	}


	/**
	 * @param args void
	 */
	public static void main( String ... args ) {
		try {
			AdministracionTelefonicaImpl administracionTelefonicaImpl = new AdministracionTelefonicaImpl();
/*
	  		ConsultaInformacionTelefonicaPeticion consultaInformacionTelefonicaPeticion
	  		= new ConsultaInformacionTelefonicaPeticion();
			consultaInformacionTelefonicaPeticion.setIdSolicitud("52535");
			administracionTelefonicaImpl.consultaInformacionVerificacion("s", consultaInformacionTelefonicaPeticion);
*/

/*
			ValidaStatusSolicitudPeticion vp = new ValidaStatusSolicitudPeticion();
			vp.setIdSolicitud("52535");
			administracionTelefonicaImpl.validaEstadoSolicitud("s", vp);

*/

			String peticion = "<Verificacion> "
			+
		"	  <Cliente Cliente=\"FINSOL\" Campania=\"VERIFICACION_FINSOL\">"
			+
		"	    <Solicitudes>"
			+
		"	      <Solicitud Numero_solicitud=\"52535_1307111843\" Fecha_hora_gestion=\"2013-07-08 10:40\""
			+
		"Comentarios=\"SOLICITUD APROBADA\" Agente=\"FINSOL\" Codigo1=\"SOLICITUD_VALIDA\" Codigo2=\"VALIDADO\">"
			+
		"	        <Integrantes>"
			+
		"	          <Integrante Numero_Persona=\"980201732\" Servicio=\"MESA_DIRECTIVA\">"
			+
		"	            <Telefono Tel=\"1234567890\" Tipo_telefono=\"CELU\" callcenter=\"COL\" Fecha_hora_gestion=\""
			+
		"2013-07-08 10:40\" Comentarios=\"\" Agente=\"SISTEMAS\" Codigo1=\"TEL_VALIDO_CAMBIAR\" Codigo2=\"VALIDADO\""
			+
		"Nombre_interlocutor=\"SERGIO SERVIN MARTINEZ\" Parentesco=\"HERMANO(A)\" Tipo_tel_callcenter=\"FIJO\" Carrier=\"1\""
			+
		"Modalidad=\"CPP\" Consecutivo=\"1\" Tipo_tel_correcto=\"DIRE\" />"
			+
		"	          </Integrante>"
			+
		"	        </Integrantes>"
			+
		"	      </Solicitud>"
			+
		"	    </Solicitudes>"
			+
		"	  </Cliente>"
			+
		"	</Verificacion>";

			administracionTelefonicaImpl.respuestainformacionVerificacion("###", peticion);
		} catch (Exception e) {

		}
	}

	/**
	 * @param uid identificador unico de la transaccion
	 * @param peticion para verificacion de la solicitud
	 * @return ConsultaSolicitudesVerificacionRespuesta resultado de la verificacion de la solicitud
	 */
	public ConsultaSolicitudesVerificacionRespuesta consultaSolicitudVerificaciones(
			String uid, ConsultaSolicitudesVerificacionPeticion peticion) {
		ConsultaSolicitudesVerificacionRespuesta	respuesta = new ConsultaSolicitudesVerificacionRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession  					sessionNTx	  					= null;


		try {
			if (peticion.getSucursal() == null) {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.verificacion.telefonica.validaestadosolicitud.peticion" ) );
			}
			//Se abre la session No transaccional Sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			if (peticion.getEstatus() != null) {
				if ( peticion.getEstatus().trim().isEmpty() ) {
					peticion.setEstatus( null );
				}
			}

			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put( "sucursal"		 , peticion.getSucursal() == null ? 0 : peticion.getSucursal() );
			parametros.put( "estatus"		 , peticion.getEstatus() == null ? null : peticion.getEstatus().trim() );
			parametros.put( "horas"		 	 , peticion.getHoras() == null ? 0 : peticion.getHoras() );

			//se realiza la consulta en base a la sucursal
			LogHandler.trace(uid, getClass(),
					"==> consultaSolicitudVerificaciones - consultaBitacoraVerificacionFinsolSucursal" );
			@SuppressWarnings("unchecked")

			List<BitacoraVerificacionFinsolOV> coincidencias
				= sessionNTx.selectList("consultaBitacoraVerificacionFinsolSucursal", parametros );

			//Obteniendo Datos de la Bitacora
			List<BitacoraVerificacionFinsolOV> arrayBitacoraVerificacionFinsolOV  = new ArrayList<BitacoraVerificacionFinsolOV>();

			@SuppressWarnings("deprecation")
			Date miFecha = new Date("01/01/1900");

			if (coincidencias == null ) {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.verificacion.telefonica.validaestadosolicitud.bitacora" ) );
			}

			if (coincidencias.size() == 0) {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.verificacion.telefonica.validaestadosolicitud.bitacora" ) );
			}

			for (int i = 0; i < coincidencias.size(); i++) {
				BitacoraVerificacionFinsolOV bitacoraVerificacionFinsolOV = new BitacoraVerificacionFinsolOV();
				bitacoraVerificacionFinsolOV.setSolicitud(coincidencias.get(i).getSolicitud().trim());
				bitacoraVerificacionFinsolOV.setSucursal(coincidencias.get(i).getSucursal());
				bitacoraVerificacionFinsolOV.setGrupo(
						coincidencias.get(i).getGrupo() != null ? coincidencias.get(i).getGrupo().trim() : "");
				bitacoraVerificacionFinsolOV.setFechaEnvioVerificacion(coincidencias.get(i).getFechaEnvioVerificacion());
				bitacoraVerificacionFinsolOV.setFechaRespuestaVerificacion(
						coincidencias.get(i).getFechaRespuestaVerificacion() != null
								? coincidencias.get(i).getFechaRespuestaVerificacion() : miFecha);
				bitacoraVerificacionFinsolOV.setEstatusVerificacion(
						coincidencias.get(i).getEstatusVerificacion() != null
								? coincidencias.get(i).getEstatusVerificacion().trim() : "");
				bitacoraVerificacionFinsolOV.setComentariosEnvioVerificacion(
						coincidencias.get(i).getComentariosEnvioVerificacion() != null
								? coincidencias.get(i).getComentariosEnvioVerificacion().trim() : "");
				arrayBitacoraVerificacionFinsolOV.add(bitacoraVerificacionFinsolOV);
			}

			respuesta.setSolicitudes(arrayBitacoraVerificacionFinsolOV);

		}
		catch ( java.lang.Exception exception ) {
			LogHandler.error(uid, getClass(), "validaEstadoSolicitud() ", exception);
			respuesta.getHeader().setUID( uid );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setMensaje( "validaEstadoSolicitud() " + exception.getMessage() );
		}
		finally	{
			FabricaConexiones.close( sessionNTx );
		}
		return respuesta;
	}

}
