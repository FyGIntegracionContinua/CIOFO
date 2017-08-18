package tarea.administracion;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.oasisopen.sca.annotation.Reference;

import tarea.burocredito.BuroCreditoTarea;
import tarea.comun.ReadProperties;
import tarea.solicitudes.SolicitudesCreditoTarea;
import utilitario.comun.Constantes;
import utilitario.comun.Funciones;
import utilitario.comun.Validaciones;
import utilitario.log.LogHandler;
import utilitario.mensajes.burocredito.ConsultaBuroPeticion;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ResultadoOV;
import utilitario.mensajes.originacion.consulta.ContratoRenovacionPeticion;
import utilitario.mensajes.persona.ActualizarPersonaRespuesta;
import utilitario.mensajes.persona.ConsultaDatosGeneralesPeticion;
import utilitario.mensajes.persona.ConsultaDatosGeneralesRespuesta;
import utilitario.mensajes.persona.ConsultarClienteUnicoPeticion;
import utilitario.mensajes.persona.ConsultarClienteUnicoRespuesta;
import utilitario.mensajes.persona.ConsultarPersonaPeticion;
import utilitario.mensajes.persona.ConsultarPersonaRespuesta;
import utilitario.mensajes.persona.ConsultarPersonaRespuestaOV;
import utilitario.mensajes.persona.DetalleSocioeconomicoOV;
import utilitario.mensajes.persona.DireccionElectronicaOV;
import utilitario.mensajes.persona.DomicilioOV;
import utilitario.mensajes.persona.PerfilTemporal;
import utilitario.mensajes.persona.PerfilTemporalRespuesta;
import utilitario.mensajes.persona.PersonaOV;
import utilitario.mensajes.persona.PersonaRelacion;
import utilitario.mensajes.persona.PersonaSimplificacionOV;
import utilitario.mensajes.persona.ReferenciaOV;
import utilitario.mensajes.persona.RegistrarPersonaPeticion;
import utilitario.mensajes.persona.RegistrarPersonaRespuesta;
import utilitario.mensajes.persona.RelacionClaveFinsolOV;
import utilitario.mensajes.persona.RelacionPersonaOV;
import utilitario.mensajes.persona.TelefonoOV;
import utilitario.mensajes.persona.ValidaExistePersonaPeticion;
import utilitario.mensajes.persona.ValidaExistePersonaRespuesta;
import utilitario.mensajes.persona.ValidaIdReferenciasOV;
import utilitario.mensajes.persona.ValidaPersonaOV;
import utilitario.mensajes.persona.ValidarCurpPersonaPeticion;
import utilitario.mensajes.persona.ValidarCurpPersonaRespuesta;
import utilitario.mensajes.persona.ValidarDatosPersonaPeticion;
import utilitario.mensajes.persona.ValidarDatosPersonaRespuesta;
import utilitario.mensajes.solicitudes.ConsultaSolicitudBuroRespuesta;
import utilitario.reglas.solicitudes.ValidaIntegrantePeticion;
import utilitario.reglas.solicitudes.ValidaIntegranteRespuesta;
import datamapper.DataMapper;
import entidad.conexiones.FabricaConexiones;

/**
 * The Class AdministracionPersonaImpl.
 *
 * @author out_mreyes@independencia.com.mx
 */
public 	class 		AdministracionPersonaImpl
		implements	AdministracionPersona {

	/**
	 * Variable SolicitudesCreditoTarea
	 */
	private SolicitudesCreditoTarea solicitudesCredito;

	/**
	 * BuroCreditoTarea SCA
	 */
	private BuroCreditoTarea buroCreditoTarea;

	/**
	 * Instantiates a new administracion persona impl.
	 */
	public AdministracionPersonaImpl(@Reference(name = "solicitudesCredito") SolicitudesCreditoTarea solicitudesCredito,
			@Reference(name = "buroCreditoTarea") BuroCreditoTarea buroCreditoTarea) {
		this.solicitudesCredito = solicitudesCredito;
		this.buroCreditoTarea    = buroCreditoTarea;
	}

	/** String MODULO_PERSONA. */
	public static final String MODULO_PERSONA = "PERSONA";

	/** String MODULO_DOMICILIO. */
	public static final String MODULO_DOMICILIO = "DOMICILIO";

	/** String MODULO_REFERENCIA. */
	public static final String MODULO_REFERENCIA = "REFERENCIA";

	/** String MODULO_TELEFONO. */
	public static final String MODULO_TELEFONO = "TELEFONO";

	/** String MODULO_DETALLESOCIOECONOMICO. */
	public static final String MODULO_DETALLESOCIOECONOMICO = "DETALLE SOCIOECONOMICO";

	/** String MODULO_RELACIONES. */
	public static final String MODULO_RELACIONES = "RELACION";

	/** String TIPO_DIRECTO. */
	public static final String TIPO_DIRECTO = "DIRE";

	/** String TIPO_CELULAR. */
	public static final String TIPO_CELULAR = "CELU";

	/** String TIPO_REFERENCIA. */
	public static final String TIPO_REFERENCIA = "REFE";

	/** String TIPO_EMPLEO. */
	public static final String TIPO_EMPLEO = "EMPL";

	/** String TIPO_CONYUGE_DIRECTO. */
	public static final String TIPO_CONYUGE_DIRECTO = "COND";

	/** String TIPO_CONYUGE_CELULAR. */
	public static final String TIPO_CONYUGE_CELULAR = "CONC";

	/** String TIPO_CONYUGE. */
	public static final String TIPO_CONYUGE = "CONY";

	/** String TIPO_RECADO. */
	public static final String TIPO_RECADO = "RECA";

	/** String RELACION_CONYUGE. */
	public static final String RELACION_CONYUGE = "08";

	/** Integer LONG_PERSONA. */
	public static final Integer LONG_PERSONA = 9;

	/** Integer POSICION_LUNES. */
	public static final Integer POSICION_LUNES = 0;

	/** Integer POSICION_MARTES. */
	public static final Integer POSICION_MARTES = 1;

	/** Integer POSICION_MIERCOLES. */
	public static final Integer POSICION_MIERCOLES = 2;

	/** Integer POSICION_JUEVES. */
	public static final Integer POSICION_JUEVES = 3;

	/** Integer POSICION_VIERNES. */
	public static final Integer POSICION_VIERNES = 4;

	/** Integer POSICION_SABADO. */
	public static final Integer POSICION_SABADO = 5;

	/** Integer POSICION_DOMINGO. */
	public static final Integer POSICION_DOMINGO = 6;

	/** Integer CLAVE_PARENTESCO. */
	public static final Integer CLAVE_PARENTESCO = 9;

	/** Integer DEFAULT_GIRO_EMPRESA. */
	public static final Integer DEFAULT_GIRO_EMPRESA = 36;

	/** Integer DEFAULT_TIPO_ACTIVIDAD. */
	public static final Integer DEFAULT_TIPO_ACTIVIDAD = 4;

	/** Integer DEFAULT_TIPO_NEGOCIO. */
	public static final Integer DEFAULT_TIPO_NEGOCIO = 9;

	/** Integer DIEZ. */
	public static final Integer DIEZ = 10;
	/** Integer ONCE. */
	public static final Integer ONCE = 11;
	/** Integer TRECE. */
	public static final Integer TRECE = 13;


	/**
	 * @param uid identificador unico de la transaccion
	 * @param peticion de registro de persona
	 * @return  RegistrarPersonaRespuesta resultado del registro de la persona
	 */
	@SuppressWarnings("unchecked")
	public RegistrarPersonaRespuesta registrarPersona(String uid, RegistrarPersonaPeticion peticion) {
		//Objeto para la respuestas
		final RegistrarPersonaRespuesta respuesta = new RegistrarPersonaRespuesta( uid );

		//Objetos para manejo de la sesiones
		SqlSession 	sessionSybaseTx = null;
		SqlSession  sessionNTx	  	= null;

		try {

			//Validacion de la peticion
			if (peticion.getPersona().getNumeroPersona() != null && !peticion.getPersona().getNumeroPersona().trim().isEmpty()) {
				throw new Exception( ReadProperties.mensajes.getProp( "administracion.persona.errorpersonayaregistrada" ) );
			}

			if (peticion.getPersona() == null || peticion.getPersona().getProspecto() == null
					|| peticion.getPersona().getProspecto()) {
					throw new Exception( ReadProperties.mensajes.getProp( "administracion.persona.error.rfc.prospecto" ) );
			}


			//Se valida si hay registros con datos iguales
			final ConsultarPersonaPeticion	consultarPersonaPeticion = new ConsultarPersonaPeticion();
			consultarPersonaPeticion.setPersona( peticion.getPersona() );
			final ConsultarPersonaRespuesta	consultarPersonaRespuesta = consultarPersona(uid, consultarPersonaPeticion);
			if ( consultarPersonaRespuesta.getPersona() != null && consultarPersonaRespuesta.getPersona().size() > 0 ) {
				throw new Exception( ReadProperties.mensajes.getProp( "administracion.persona.errorpersonayaregistrada" ) );
			}

			//Se abre la session No transaccional sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			//Se abre la session transaccional sybase
			sessionSybaseTx = FabricaConexiones.obtenerSesionTx();

			//Generacion de secuencias
			LogHandler.trace(uid, getClass(), "==> registrarPersona - obtenerValorSequenciasPersona" );
			final java.util.ArrayList<HashMap<String, Object>>	clavesActuales
			= (ArrayList<HashMap<String, Object>>) sessionSybaseTx.selectList( "obtenerValorSequenciasPersona" );

			//Se generan las secuencias
			final java.util.HashMap<String, Long> clavesActualizadas = new HashMap<String, Long>();

			//Se incrementa al siguiente consecutivo
			for ( HashMap<String, Object> secuencia : clavesActuales ) {
				clavesActualizadas.put( secuencia.get( "tipo").toString(),  Long.valueOf( secuencia.get( "actual" ).toString() )
																+ Long.valueOf( secuencia.get( "incremento" ).toString() ) );
			}

			//Se actualizan las secuencias al nuevo valor
			LogHandler.trace(uid, getClass(), "==> registrarPersona - actualizarSequenciasPersona" );
			sessionSybaseTx.update( "actualizarSequenciasPersona" );

			LogHandler.info(uid, getClass(), "Clave de persona : " + clavesActualizadas.get( "PER" ) );
			LogHandler.info(uid, getClass(), "Clave de t24 : " + clavesActualizadas.get( "T24" ) );

			//Se asignan las claves al objeto principal para las personas
			final RelacionClaveFinsolOV	relacionClaveFinsolOV = new RelacionClaveFinsolOV();
			relacionClaveFinsolOV.setNumeroPersona( clavesActualizadas.get( "PER" ).toString() );
			//relacionClaveFinsolOV.setClaveFinsol( clavesActualizadas.get( "T24" ).toString() );
			relacionClaveFinsolOV.setClaveFinsol(  clavesActualizadas.get( "PER" ).toString() );
			//relacionClaveFinsolOV.setClaveCU    ( peticion.getPersona().getRfc() );
			relacionClaveFinsolOV.setClaveCU( clavesActualizadas.get( "PER" ).toString() );

			//Se asignan claves a la peticion
			peticion.getPersona().setRelacionClaveFinsol( relacionClaveFinsolOV );
			peticion.getPersona().setNumeroPersona( clavesActualizadas.get( "PER" ).toString() );
			respuesta.setRelacionClaveFinsol(relacionClaveFinsolOV);

			//Se busca que las claves no esten registradas
			LogHandler.trace(uid, getClass(), "==> registrarPersona - buscarClavePersona" );
			final java.util.ArrayList<String>	clavesRegistradas = (ArrayList<String>)
					sessionSybaseTx.selectList( "buscarClavePersona", relacionClaveFinsolOV );

			//Se valida que no existan
			if ( clavesRegistradas != null &&  clavesRegistradas.size() > 0 ) {
				throw new Exception( ReadProperties.mensajes.getProp( "administracion.persona.errorclaveexistente" ) );
			}
			//Validacion de la persona
			ValidaPersona.validaPersona(peticion.getPersona(), MODULO_PERSONA);

			//Valida apellido materno de la persona
			peticion.getPersona().setApellidoMaterno(
					peticion.getPersona().getApellidoMaterno( ) != null ? peticion.getPersona().getApellidoMaterno( ).trim() : ""
					);

			//Validacion del domicilio de la persona
			peticion.getPersona().getDomicilioPersona().setTipoDomicilio( TIPO_DIRECTO );
			peticion.getPersona().getDomicilioPersona().setNumeroPersona( peticion.getPersona().getNumeroPersona() );
			peticion.getPersona().getDomicilioPersona().setPais(  peticion.getPersona().getDomicilioPersona().getPais()
					!= null ? peticion.getPersona().getDomicilioPersona().getPais() : "MX" );
			ValidaPersona.validaDomicilio(peticion.getPersona().getDomicilioPersona(), MODULO_PERSONA);

			//Se lleva a cabo el registro de la persona en sybase
			LogHandler.trace(uid, getClass(), "==> registrarPersona - registrarPersonaSybase" );
			sessionSybaseTx.insert( "registrarPersonaSybase", peticion.getPersona() );

			//Calle modelo anterior
			peticion.getPersona().getDomicilioPersona().setNumeroExterior(
					peticion.getPersona().getDomicilioPersona().getNumeroExterior( ) != null
					? peticion.getPersona().getDomicilioPersona().getNumeroExterior( ) : ""
					);

			peticion.getPersona().getDomicilioPersona().setNumeroInterior(
					peticion.getPersona().getDomicilioPersona().getNumeroInterior( ) != null
					? peticion.getPersona().getDomicilioPersona().getNumeroInterior( ) : ""
					);


			//Registro Domicilio DIRE
			insertaDomicilio( uid, sessionSybaseTx, peticion.getPersona().getDomicilioPersona(), peticion.getPersona() , null );

			//Domicilios
			LogHandler.trace(uid, getClass(), "==> registrarPersona - actualizarDomicilioPersona" );
			sessionSybaseTx.update( "actualizarDomicilioPersona", peticion.getPersona().getDomicilioPersona() );

			//Relaciones

			for (  RelacionPersonaOV relacion : peticion.getPersona().getRelacionesPersona() ) {

					//Se valida el tipo de relacion sea correcto

					if ( !(relacion.getTipoRelacion().equals( TIPO_REFERENCIA )
						|| relacion.getTipoRelacion().equals( TIPO_CONYUGE )
						|| relacion.getTipoRelacion().equals( TIPO_RECADO ) )) {
					  throw new Exception( ReadProperties.mensajes.getProp(
							  "administracion.persona.error.relacion.tiporelacion" ) );
					}

					if ( relacion.getTipoRelacion().equals( TIPO_REFERENCIA ) ) {
						//Validacion de Referencia
						ValidaPersona.validaReferencia(relacion, MODULO_REFERENCIA);
						ValidaPersona.validaDomicilio(relacion.getDomicilioRelacion(), MODULO_REFERENCIA );
					}

					//Registrar persona-relacion
					PersonaRelacion personaRelacion = new PersonaRelacion();
					personaRelacion.setPersona(peticion.getPersona().getNumeroPersona());
					personaRelacion.setNombre(relacion.getNombre() != null ? relacion.getNombre() : "");
					personaRelacion.setApellidoPaterno(relacion.getApellidoPaterno() != null
														? relacion.getApellidoPaterno() : "");
					personaRelacion.setApellidoMaterno(relacion.getApellidoMaterno() != null
														? relacion.getApellidoMaterno() : "" );

					if ( relacion.getTipoRelacion().equals( TIPO_CONYUGE ) ) {
						personaRelacion.setCodigoRelacion( RELACION_CONYUGE );
					} else {
						personaRelacion.setCodigoRelacion(relacion.getClaveParentesco() != null
														? relacion.getClaveParentesco() : "");
					}

					Integer idRelacion =  insertaRelacion( uid, sessionSybaseTx, personaRelacion );
					relacion.setIdRelacion(idRelacion);

					//Registro Domicilio Relacion

					if ( relacion.getDomicilioRelacion() != null  && relacion.getTipoRelacion().equals( TIPO_REFERENCIA )) {
						relacion.getDomicilioRelacion().setTipoDomicilio( TIPO_REFERENCIA );
						relacion.getDomicilioRelacion().setOrigen(
								peticion.getPersona().getDomicilioPersona().getOrigen() != null
								? peticion.getPersona().getDomicilioPersona().getOrigen() : "");
						insertaDomicilio( uid, sessionSybaseTx, relacion.getDomicilioRelacion(),
										peticion.getPersona(), relacion );
					}

					for ( TelefonoOV telefono : relacion.getTelefonosRelacion() ) {
						//Si es referencia
						if ( relacion.getTipoRelacion().equals( TIPO_REFERENCIA ) ) {
							ValidaPersona.validaTelefono(telefono, MODULO_REFERENCIA );
						}
						if ( relacion.getTipoRelacion().equals( TIPO_CONYUGE ) ) {
							ValidaPersona.validaTelefono(telefono, TIPO_CONYUGE );
						}
						if ( relacion.getTipoRelacion().equals( TIPO_RECADO ) ) {
							ValidaPersona.validaTelefono(telefono, TIPO_RECADO );
						}

						String tipoPlan = "";
						if ( telefono.getTipoTelefono().equals(TIPO_DIRECTO)
							|| telefono.getTipoTelefono().equals(TIPO_CONYUGE_DIRECTO)
							|| telefono.getTipoTelefono().equals(TIPO_RECADO)) {
							tipoPlan = "FIJO";
						}
						else {
							tipoPlan = "C";
						}
						if ( relacion.getTipoRelacion().equals( TIPO_REFERENCIA )) {
							telefono.setTipoTelefono( TIPO_REFERENCIA );
						}
						final HashMap<String, Object> 	parametros = new HashMap<String, Object>();
						parametros.put( "usuario"	 	 , peticion.getPersona().getOperador() != null
														? peticion.getPersona().getOperador() : "000000043"  );
						parametros.put( "integrante"	 , peticion.getPersona().getNumeroPersona() );
						parametros.put( "tipo"			 , telefono.getTipoTelefono() );
						parametros.put( "lada"			 , "" );
						parametros.put( "telefono"		 , telefono.getTelefono()           != null
														? telefono.getTelefono()        : "" );
						parametros.put( "relacion"		 , relacion.getClaveParentesco()    != null
														? relacion.getClaveParentesco()        : "" );
						parametros.put( "nombre"		 , relacion.getNombre()   		    != null
														? relacion.getNombre()   		  : "" );
						parametros.put( "apellidoPaterno", relacion.getApellidoPaterno()    != null
														? relacion.getApellidoPaterno() : "" );
						parametros.put( "apellidoMaterno", relacion.getApellidoMaterno()    != null
														? relacion.getApellidoMaterno() : "" );
						parametros.put( "fechaAlta"		 , new Date() );
						parametros.put( "origen"		 , telefono.getOrigen()  );
						parametros.put( "idRelacion"     , relacion.getIdRelacion()  );
						parametros.put( "tipo_plan"      , tipoPlan  );

						LogHandler.debug(uid, getClass(), "registrarPersona - telefono.getTipoTelefono() "
														+ telefono.getTipoTelefono());

						LogHandler.trace(uid, getClass(), "==> registrarPersona - registrarTelefonoIntegrante");
						final ResultadoOV resultado = (ResultadoOV) sessionSybaseTx.selectOne(
														"registrarTelefonoIntegrante", parametros );

						LogHandler.debug(uid, getClass(), "registrarPersona - registrarTelefonoIntegrante resultado ="
														+ resultado.toString());

						if ( Integer.valueOf(resultado.getCodigo()).intValue() < 0 ) {
							throw new Exception( resultado.getMensaje() + " " + telefono.getTelefono() );
						}
					}
				}

			//Telefonos
			for ( TelefonoOV telefonoOV : peticion.getPersona().getTelefonosPersona() ) {
				//Validacion telefono
				ValidaPersona.validaTelefono(telefonoOV, MODULO_PERSONA);

				final HashMap<String, Object> 	parametros = new HashMap<String, Object>();
				parametros.clear();
				parametros.put( "usuario"	 	 , peticion.getPersona().getOperador() != null
												? peticion.getPersona().getOperador() : "000000043"  );
				parametros.put( "integrante"	 , peticion.getPersona().getNumeroPersona() );
				parametros.put( "tipo"			 , telefonoOV.getTipoTelefono() );
				parametros.put( "lada"			 , "" );
				parametros.put( "telefono"		 , telefonoOV.getTelefono() != null ? telefonoOV.getTelefono() : "" );
				parametros.put( "relacion"		 , "" );
				parametros.put( "nombre"		 , "" );
				parametros.put( "apellidoPaterno", "" );
				parametros.put( "apellidoMaterno", "" );
				parametros.put( "fechaAlta"		 , new Date() );
				parametros.put( "origen"		 , telefonoOV.getOrigen()  );
				Integer idRelacion = 0;
				parametros.put( "idRelacion"     , idRelacion  );

				String tipoPlan = "";
				if ( telefonoOV.getTipoTelefono().equals(TIPO_DIRECTO)
					||	telefonoOV.getTipoTelefono().equals(TIPO_EMPLEO)) {
					tipoPlan = "FIJO";
				}
				else {
					tipoPlan = "C";
				}
				parametros.put( "tipo_plan"      , tipoPlan );

				LogHandler.trace(uid, getClass(), "==> registrarPersona - registrarTelefonoIntegrante");
				final ResultadoOV resultado = (ResultadoOV)
												sessionSybaseTx.selectOne( "registrarTelefonoIntegrante", parametros );

				LogHandler.debug(uid, getClass(), "registrarPersona - registrarTelefonoIntegrante resultado ="
													+ resultado.toString());

				if ( Integer.valueOf(resultado.getCodigo()).intValue() < 0 ) {
					throw new Exception( resultado.getMensaje() + " " + telefonoOV.getTelefono() );
				}
			}

			//Detalle socioeconomico

			//Par�metros para dar de alta el estudio socioeconomico
			final HashMap<String, Object> 	parametrosSocioeconomico = new HashMap<String, Object>();
			DetalleSocioeconomicoOV detalleSocioEconomico = peticion.getPersona().getDetalleSocioeconomico();

			ValidaPersona.validaEstudioSocioeconomico(detalleSocioEconomico, MODULO_DETALLESOCIOECONOMICO);
			ValidaPersona.validaDomicilio(detalleSocioEconomico.getDomicilioNegocio(), MODULO_DETALLESOCIOECONOMICO);

			//Registro Domicilio EMPL
			detalleSocioEconomico.getDomicilioNegocio().setTipoDomicilio( TIPO_EMPLEO );
			detalleSocioEconomico.getDomicilioNegocio().setOrigen(
					peticion.getPersona().getOrigen() != null
					? peticion.getPersona().getOrigen() : "");
			insertaDomicilio( uid, sessionSybaseTx, detalleSocioEconomico.getDomicilioNegocio() , peticion.getPersona() , null );


			parametrosSocioeconomico.put("persona", peticion.getPersona().getNumeroPersona() );
			parametrosSocioeconomico.put("ingreso_cp", detalleSocioEconomico.getMontoSemanaPago() != null
									?  detalleSocioEconomico.getMontoSemanaPago() : 0.0);
			parametrosSocioeconomico.put("nombre_emp", detalleSocioEconomico.getNombreNegocio() != null
									?  detalleSocioEconomico.getNombreNegocio() : "");
			parametrosSocioeconomico.put("tipo_establecimiento", detalleSocioEconomico.getTipoNegocio() != null
									?  detalleSocioEconomico.getTipoNegocio() : "");
			parametrosSocioeconomico.put("actividad_emp", detalleSocioEconomico.getGiroNegocio() != null
									?  detalleSocioEconomico.getGiroNegocio() : "");
			parametrosSocioeconomico.put("entidad_emp", detalleSocioEconomico.getDomicilioNegocio().getCodigoEstado() != null
									?  detalleSocioEconomico.getDomicilioNegocio().getCodigoEstado() : "");
			parametrosSocioeconomico.put("municipio_emp", detalleSocioEconomico.getDomicilioNegocio().getMunicipio() != null
									?  detalleSocioEconomico.getDomicilioNegocio().getMunicipio() : "");
			parametrosSocioeconomico.put("ciudad_emp", detalleSocioEconomico.getDomicilioNegocio().getCiudad() != null
									?  detalleSocioEconomico.getDomicilioNegocio().getCiudad() : "");
			parametrosSocioeconomico.put("colonia_emp", detalleSocioEconomico.getDomicilioNegocio().getColonia() != null
									?  detalleSocioEconomico.getDomicilioNegocio().getColonia() : "");
			parametrosSocioeconomico.put("cp_emp", detalleSocioEconomico.getDomicilioNegocio().getCp() != null
									?  detalleSocioEconomico.getDomicilioNegocio().getCp() : null);
			parametrosSocioeconomico.put("calle_emp", detalleSocioEconomico.getDomicilioNegocio().getCalle() != null
									?  detalleSocioEconomico.getDomicilioNegocio().getCalle() : "");
			parametrosSocioeconomico.put("entre_calle_emp", detalleSocioEconomico.getDomicilioNegocio().getEntreCalles() != null
									?  detalleSocioEconomico.getDomicilioNegocio().getEntreCalles() : "");

			LogHandler.trace(uid, getClass(), "==> registrarPersona - actualizarSocioeconomicoPersonaSybase" );
			sessionSybaseTx.update( "actualizarSocioeconomicoPersonaSybase", parametrosSocioeconomico );

			//Direcci�n electr�nica
			for ( DireccionElectronicaOV direccionElectronicaOV: peticion.getPersona().getDireccionesElectonicas()) {
				direccionElectronicaOV.setNumeroPersona(peticion.getPersona().getNumeroPersona());
				LogHandler.trace(uid, getClass(), "==> registrarPersona - actualizarCorreoPersona" );
				sessionSybaseTx.update( "actualizarCorreoPersona", direccionElectronicaOV );
			}

			//Persona Complemento

			final HashMap<String, Object> 	parametrosComplemento = new HashMap<String, Object>();

			parametrosComplemento.put("persona", peticion.getPersona().getNumeroPersona() );

			parametrosComplemento.put("apodo", peticion.getPersona().getSobrenombre() != null
						? peticion.getPersona().getSobrenombre() : "");
			parametrosComplemento.put("pais_nacimiento", peticion.getPersona().getPaisNacimiento() != null
						? peticion.getPersona().getPaisNacimiento() : "MX");
			parametrosComplemento.put("ocupacion", peticion.getPersona().getOcupacion() != null
						? peticion.getPersona().getOcupacion() : "");
			parametrosComplemento.put("posicion_hogar", peticion.getPersona().getPosicionHogar() != null
						? peticion.getPersona().getPosicionHogar() : "");
			parametrosComplemento.put("experiencia_credito_grupal", peticion.getPersona().getExperienciaCreditoGrupal() != null
						? (peticion.getPersona().getExperienciaCreditoGrupal() ? "S" : "N" ) : "N");
			parametrosComplemento.put("ocupacion_pareja", peticion.getPersona().getOcupacionPareja() != null
						? peticion.getPersona().getOcupacionPareja() : "");
			parametrosComplemento.put("direccion_ocupacion_pareja", peticion.getPersona().getLugarTrabajoPareja() != null
						? peticion.getPersona().getLugarTrabajoPareja() : "");
			parametrosComplemento.put("horario_loc_dom",
							peticion.getPersona().getDomicilioPersona().getHoraLocalizaInicial() != null
						?  peticion.getPersona().getDomicilioPersona().getHoraLocalizaInicial() + "-"
									+ peticion.getPersona().getDomicilioPersona().getHoraLocalizaFinal() : "");

			//Se insertan los nuevos parametros de clienteUnico ORIG-406  2da Fase Simplificación de la Renovación
			parametrosComplemento.put("monto_solicitado", peticion.getPersona().getMontoSolicitado() != null
					? peticion.getPersona().getMontoSolicitado() : 0.0);
			parametrosComplemento.put("num_hijos", peticion.getPersona().getNumHijos() != null
					? peticion.getPersona().getNumHijos() : 0);
			parametrosComplemento.put("no_firma_electronica", peticion.getPersona().getNoFirmaElectronica() != null
					? peticion.getPersona().getNoFirmaElectronica() : "");
			parametrosComplemento.put("destino_credito", peticion.getPersona().getDestinoCredito() != null
					? peticion.getPersona().getDestinoCredito() : "");
			// termina

			parametrosComplemento.put("inicia_negocio", detalleSocioEconomico.getIniciaNegocio() != null
						? (detalleSocioEconomico.getIniciaNegocio() ? "S" : "N" ) : "N");
			parametrosComplemento.put("tipo_actividad", detalleSocioEconomico.getTipoActividad() != null
						? detalleSocioEconomico.getTipoActividad() : "");
			parametrosComplemento.put("num_empleados", detalleSocioEconomico.getNumeroEmpleados() != null
						? detalleSocioEconomico.getNumeroEmpleados() : 0 );
			parametrosComplemento.put("exp_rubro", detalleSocioEconomico.getExperienciaRubro() != null
						? detalleSocioEconomico.getExperienciaRubro() : 0 );
			parametrosComplemento.put("exp_negocio", detalleSocioEconomico.getExperienciaNegocio() != null
						? detalleSocioEconomico.getExperienciaNegocio() : 0 );
			parametrosComplemento.put("ingresos", detalleSocioEconomico.getIngresos() != null
						? detalleSocioEconomico.getIngresos() : 0 );
			parametrosComplemento.put("monto_ventas", detalleSocioEconomico.getIngresos() != null
						? detalleSocioEconomico.getIngresos() : 0 );
			parametrosComplemento.put("ganancia_neta", detalleSocioEconomico.getGananciaNeta() != null
						? detalleSocioEconomico.getGananciaNeta() : 0 );
			parametrosComplemento.put("otros_ingresos", detalleSocioEconomico.getOtrosIngresos() != null
						? detalleSocioEconomico.getOtrosIngresos() : 0 );
			parametrosComplemento.put("ganancia_act_sec", detalleSocioEconomico.getGananciaActSec() != null
						? detalleSocioEconomico.getGananciaActSec() : 0 );
			parametrosComplemento.put("gastos_familiares", detalleSocioEconomico.getGastosFamiliares() != null
						? detalleSocioEconomico.getGastosFamiliares() : 0 );
			parametrosComplemento.put("monto_superavit", detalleSocioEconomico.getMontoSuperavit() != null
						? detalleSocioEconomico.getMontoSuperavit() : 0 );
			parametrosComplemento.put("monto_inventario", detalleSocioEconomico.getMontoInventario() != null
						? detalleSocioEconomico.getMontoInventario() : 0 );
			parametrosComplemento.put("monto_mobiliario_equipo", detalleSocioEconomico.getMontoMobiliarioEquipo() != null
						? detalleSocioEconomico.getMontoMobiliarioEquipo() : 0 );
			parametrosComplemento.put("observaciones_socioeconomico", " " );
			parametrosComplemento.put("asesor", peticion.getPersona().getAsesorCredito() != null
						? peticion.getPersona().getAsesorCredito() : "");
			parametrosComplemento.put("sucursal", peticion.getPersona().getSucursal() != null
						? peticion.getPersona().getSucursal() : 0);

			//Se lleva a cabo el registro del complemento de la persona en sybase
			LogHandler.trace(uid, getClass(), "==> registrarPersona - registrarComplementoPersonaSybase" );
			sessionSybaseTx.insert( "registrarComplementoPersonaSybase", parametrosComplemento );

			//Relacion de claves para interoperatividad entre bases
			LogHandler.trace(uid, getClass(), "==> registrarPersona - insertarClavesPersona" );
			sessionSybaseTx.insert( "insertarClavesPersona", relacionClaveFinsolOV );

			//Se ejecuta el commit para SYBASE
			sessionSybaseTx.commit( true );

			LogHandler.debug(uid, getClass(), "COMMIT APLICADO!");
			}
		catch ( java.lang.Exception exception ) {
			//Rollback
			LogHandler.debug(uid, getClass(), "ROLLBACK APLICADO!");
			FabricaConexiones.rollBack( sessionSybaseTx );
			LogHandler.error(uid, getClass(), ReadProperties.mensajes.getProp(
					"administracion.persona.errorregistrarpersona" ), exception);
			respuesta.getHeader().setUID( uid );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setMensaje( ReadProperties.mensajes.getProp(
					"administracion.persona.errorregistrarpersona" ) + " : " + exception.getMessage() );
			}
		finally {
			FabricaConexiones.close( sessionSybaseTx );
			FabricaConexiones.close( sessionNTx      );
			//FabricaConexiones.close( sessionOracleTx );
			}
		return respuesta;
		}



	/**
	 * @param uid identificador unico de la transaccion
	 * @param peticion de actualizacion de persona
	 * @return  RegistrarPersonaRespuesta resultado de la actualizacion de la persona
	 */
	public ActualizarPersonaRespuesta actualizarPersona(String uid, RegistrarPersonaPeticion peticion) {
		//Objeto para la respuestas
		final ActualizarPersonaRespuesta respuesta = new ActualizarPersonaRespuesta( uid );
		//Objetos para manejo de la sesiones
		SqlSession 	sessionSybaseTx = null;
		SqlSession  sessionNTx	  	= null;

		try {
			//Validaciones de peticion incompleta
			if ( peticion == null || peticion.getPersona() == null || peticion.getPersona().getNumeroPersona() == null
				||	peticion.getPersona().getNumeroPersona().trim().isEmpty() )	{
				throw new Exception( ReadProperties.mensajes.getProp( "administracion.persona.error.actualizar.persona" ) );
				}

			if ( peticion.getPersona().getRelacionClaveFinsol() == null
				|| peticion.getPersona().getRelacionClaveFinsol().getClaveCU() == null
				|| peticion.getPersona().getRelacionClaveFinsol().getClaveCU().trim().isEmpty()) {
				throw new Exception( ReadProperties.mensajes.getProp( "administracion.persona.error.actualizar.claves" ) );
				}

			  //Sybase

				sessionNTx = FabricaConexiones.obtenerSesionNTx();

				final HashMap<String, Object> parametros = new HashMap<String, Object>();
				parametros.put("persona", peticion.getPersona().getNumeroPersona());
				LogHandler.trace(uid, getClass(), "==> actualizarPersona - consultarDatosPersona" );
				PersonaOV personaConsulta = (PersonaOV) sessionNTx.selectOne( "consultarDatosPersona", parametros );

				if (personaConsulta == null) {
					throw new Exception( ReadProperties.mensajes.getProp( "administracion.persona.error.consultapersona" ) );
				}

				//Se abre la session
				sessionSybaseTx = FabricaConexiones.obtenerSesionTx();

				//Actualizar personas
				LogHandler.trace(uid, getClass(), "==> actualizarPersona - actualizarDatosPersona" );
				sessionSybaseTx.update( "actualizarDatosPersona", peticion.getPersona() );

				if (peticion.getPersona().getDomicilioPersona() != null) {

					LogHandler.info(uid, getClass(), "==> actualizarPersona - DomicilioPersona" );

					peticion.getPersona().getDomicilioPersona().setNumeroPersona(  peticion.getPersona().getNumeroPersona() );
					peticion.getPersona().getDomicilioPersona().setPais(
							peticion.getPersona().getDomicilioPersona().getPais() == null
							? "MX" : peticion.getPersona().getDomicilioPersona().getPais() );
					peticion.getPersona().getDomicilioPersona().setTipoDomicilio(TIPO_DIRECTO);
					peticion.getPersona().getDomicilioPersona().setOperador(peticion.getPersona().getOperador() );

					//Calle modelo anterior
					peticion.getPersona().getDomicilioPersona().setNumeroExterior(
							peticion.getPersona().getDomicilioPersona().getNumeroExterior( ) != null
							? peticion.getPersona().getDomicilioPersona().getNumeroExterior( ) : "");

					peticion.getPersona().getDomicilioPersona().setNumeroInterior(
							peticion.getPersona().getDomicilioPersona().getNumeroInterior( ) != null
							? peticion.getPersona().getDomicilioPersona().getNumeroInterior( ) : "");

					ValidaPersona.validaDomicilio(peticion.getPersona().getDomicilioPersona(), MODULO_PERSONA);
					//Actualizar Domicilio
					LogHandler.trace(uid, getClass(), "==> actualizarPersona - actualizarDomicilioPersona" );
					sessionSybaseTx.update( "actualizarDomicilioPersona", peticion.getPersona().getDomicilioPersona() );

					//Existe Domicilio Nuevo Modelo
					parametros.put("tipo_domicilio", TIPO_DIRECTO);
					LogHandler.trace(uid, getClass(), "==> actualizarPersona - existePersonaDomicilio" );
					Integer numeroDomicilios = (Integer) sessionSybaseTx.selectOne( "existePersonaDomicilio", parametros );

					if (numeroDomicilios > 0) {

						peticion.getPersona().getDomicilioPersona().setHoraLocalizaInicial(
								peticion.getPersona().getDomicilioPersona().getHoraLocalizaInicial() != null
								?  peticion.getPersona().getDomicilioPersona().getHoraLocalizaInicial() : "");
						peticion.getPersona().getDomicilioPersona().setHoraLocalizaFinal(
								peticion.getPersona().getDomicilioPersona().getHoraLocalizaFinal() != null
								?  peticion.getPersona().getDomicilioPersona().getHoraLocalizaFinal() : "");

						LogHandler.trace(uid, getClass(), "==> actualizarPersona - actualizaPersonaDomicilio" );
						sessionSybaseTx.update( "actualizaPersonaDomicilio", peticion.getPersona().getDomicilioPersona() );
					} else {
						LogHandler.trace(uid, getClass(), "==> actualizarPersona - insertaDomicilio getDomicilioPersona()" );
						insertaDomicilio( uid, sessionSybaseTx, peticion.getPersona().getDomicilioPersona(),
								peticion.getPersona(), null );
					}

				}
				//Telefonos
				for ( TelefonoOV telefonoOV : peticion.getPersona().getTelefonosPersona() ) {
					if (telefonoOV.getActualizar()) {
						//Validacion telefono
						ValidaPersona.validaTelefono(telefonoOV, MODULO_PERSONA);

						final HashMap<String, Object> 	parametrosTelefono = new HashMap<String, Object>();

						parametrosTelefono.put( "usuario"	 	 , peticion.getPersona().getOperador() != null
								? peticion.getPersona().getOperador() : "000000043"  );
						parametrosTelefono.put( "integrante"	 , peticion.getPersona().getNumeroPersona() );
						parametrosTelefono.put( "tipo"			 , telefonoOV.getTipoTelefono() );
						parametrosTelefono.put( "lada"			 , "" );
						parametrosTelefono.put( "telefono"		 , telefonoOV.getTelefono()           != null
								? telefonoOV.getTelefono()        : "" );
						parametrosTelefono.put( "relacion"		 , "" );
						parametrosTelefono.put( "nombre"		 , "" );
						parametrosTelefono.put( "apellidoPaterno", "" );
						parametrosTelefono.put( "apellidoMaterno", "" );
						parametrosTelefono.put( "fechaAlta"		 , new Date() );
						parametrosTelefono.put( "origen"		 , telefonoOV.getOrigen()  );
						Integer idRelacion = 0;
						parametrosTelefono.put( "idRelacion"     , idRelacion  );

						String tipoPlan = "";
						if ( telefonoOV.getTipoTelefono().equals(TIPO_DIRECTO)
							||	telefonoOV.getTipoTelefono().equals(TIPO_EMPLEO) ) {
							tipoPlan = "FIJO";
						}
						else {
							tipoPlan = "C";
						}
						parametrosTelefono.put( "tipo_plan"      , tipoPlan );

						//Validamos si existe el telefono
						LogHandler.trace(uid, getClass(), "==> actualizarPersona - existeTelefonoIntegrante");
						Integer numeroTelefonos = (Integer) sessionSybaseTx.selectOne(
								"existeTelefonoIntegrante", parametrosTelefono );

						if (numeroTelefonos == 0) {
							LogHandler.trace(uid, getClass(), "==> actualizarPersona - registrarTelefonoIntegrante");
							final ResultadoOV resultado = (ResultadoOV) sessionSybaseTx.selectOne(
									"registrarTelefonoIntegrante", parametrosTelefono );

							LogHandler.debug(uid, getClass(), "actualizarPersona - registrarTelefonoIntegrante resultado ="
							+ resultado.toString());

							if ( Integer.valueOf(resultado.getCodigo()).intValue() < 0 ) {
								throw new Exception( resultado.getMensaje() + " " + telefonoOV.getTelefono() );
							}
						}
					}
				}
				//Relaciones

				LogHandler.info(uid, getClass(), "==> actualizarPersona - Relaciones Persona" );

				for (  RelacionPersonaOV relacion : peticion.getPersona().getRelacionesPersona() ) {
					if (relacion.getNumeroPersona() != null ) {
						//Se valida el tipo de relacion sea correcto

						if ( !(relacion.getTipoRelacion().equals( TIPO_REFERENCIA )
							|| relacion.getTipoRelacion().equals( TIPO_CONYUGE )
							|| relacion.getTipoRelacion().equals( TIPO_RECADO ) )) {
						  throw new Exception( ReadProperties.mensajes.getProp(
								  "administracion.persona.error.relacion.tiporelacion" ) );
						}
						if ( relacion.getTipoRelacion().equals( TIPO_REFERENCIA ) ) {
							//Validacion de Referencia
							ValidaPersona.validaReferencia(relacion, MODULO_REFERENCIA);
							ValidaPersona.validaDomicilio(relacion.getDomicilioRelacion(), MODULO_REFERENCIA );
						}

						if (relacion.getIdRelacion() > 0 ) {
							//Relacion existente
							//Valida que la relacion exista
							final HashMap<String, Object> 	parametrosVerificaRelacion = new HashMap<String, Object>();
							parametrosVerificaRelacion.put("persona", peticion.getPersona().getNumeroPersona());
							parametrosVerificaRelacion.put("idRelacion", relacion.getIdRelacion());
							LogHandler.trace(uid, getClass(), "==> actualizarPersona - existePersonaRelacion" );
							Integer numeroRelaciones = (Integer) sessionSybaseTx.selectOne( "existePersonaRelacion",
									parametrosVerificaRelacion );
							LogHandler.debug(uid, getClass(), "==> actualizarPersona - existePersonaRelacion"
									+ numeroRelaciones);
							if (numeroRelaciones == 0) {
								//Error
								throw new Exception( ReadProperties.mensajes.getProp(
										"administracion.persona.error.actualizacion.idrelacion" ) );
							}

							//Actualizacion de datos

							PersonaRelacion personaRelacion = new PersonaRelacion();
							personaRelacion.setPersona(peticion.getPersona().getNumeroPersona());
							personaRelacion.setNombre(relacion.getNombre() != null ? relacion.getNombre() : "");
							personaRelacion.setApellidoPaterno(relacion.getApellidoPaterno() != null
									? relacion.getApellidoPaterno() : "");
							personaRelacion.setApellidoMaterno(relacion.getApellidoMaterno() != null
									? relacion.getApellidoMaterno() : "" );
							personaRelacion.setIdRelacion( relacion.getIdRelacion().longValue());

							if ( relacion.getTipoRelacion().equals( TIPO_CONYUGE ) ) {
								personaRelacion.setCodigoRelacion( RELACION_CONYUGE );
							} else {
								personaRelacion.setCodigoRelacion(relacion.getClaveParentesco() != null
										? relacion.getClaveParentesco() : "");
							}

							LogHandler.info(uid, getClass(), "==> actualizarPersona - actualizamos la relacion de la Persona" );
							actualizaRelacion( uid, sessionSybaseTx, personaRelacion );

							//Actualizar Domicilio Relacion

							if ( relacion.getDomicilioRelacion() != null
									&& relacion.getTipoRelacion().equals( TIPO_REFERENCIA )) {
								relacion.getDomicilioRelacion().setTipoDomicilio( TIPO_REFERENCIA );
								relacion.getDomicilioRelacion().setIdRelacion( relacion.getIdRelacion() );
								relacion.getDomicilioRelacion().setOrigen(
										peticion.getPersona().getDomicilioPersona().getOrigen() != null
										? peticion.getPersona().getDomicilioPersona().getOrigen() : "");
								//Existe Domicilio Nuevo Modelo
								parametros.put("tipo_domicilio", TIPO_REFERENCIA);
								parametros.put("id_relacion", relacion.getIdRelacion().longValue());
								LogHandler.trace(uid, getClass(), "==> actualizarPersona - existePersonaDomicilio" );
								Integer numeroDomiciliosReferencia = (Integer) sessionSybaseTx.selectOne(
										"existePersonaDomicilio", parametros );

								if (numeroDomiciliosReferencia > 0) {
									LogHandler.trace(uid, getClass(), "==> actualizarPersona - actualizaPersonaDomicilio" );
									sessionSybaseTx.update( "actualizaPersonaDomicilio", relacion.getDomicilioRelacion() );
								} else {
									LogHandler.trace(uid, getClass(),
											"==> actualizarPersona - insertaDomicilio getDomicilioPersona()");
									insertaDomicilio( uid, sessionSybaseTx, relacion.getDomicilioRelacion(),
											peticion.getPersona() , relacion );
								}
							}


							//Actualiza telefonos
							if ( relacion.getTelefonosRelacion() != null ) {
								for ( TelefonoOV telefono : relacion.getTelefonosRelacion() ) {

									if (telefono.getActualizar()) {
										//Validacion telefonos
										//Si es referencia
										if ( relacion.getTipoRelacion().equals( TIPO_REFERENCIA ) ) {
											ValidaPersona.validaTelefono(telefono, MODULO_REFERENCIA );
										}
										if ( relacion.getTipoRelacion().equals( TIPO_CONYUGE ) ) {
											ValidaPersona.validaTelefono(telefono, TIPO_CONYUGE );
										}
										if ( relacion.getTipoRelacion().equals( TIPO_RECADO ) ) {
											ValidaPersona.validaTelefono(telefono, TIPO_RECADO );
										}

										String tipoPlan = "";
										if ( telefono.getTipoTelefono().equals(TIPO_DIRECTO)
											|| telefono.getTipoTelefono().equals(TIPO_CONYUGE_DIRECTO)
											|| telefono.getTipoTelefono().equals(TIPO_RECADO)) {
											tipoPlan = "FIJO";
										}
										else {
											tipoPlan = "C";
										}
										if ( relacion.getTipoRelacion().equals( TIPO_REFERENCIA )) {
											telefono.setTipoTelefono( TIPO_REFERENCIA );
										}
										final HashMap<String, Object> 	parametrosAltaTelefono = new HashMap<String, Object>();
										parametrosAltaTelefono.put( "usuario"	 	 , peticion.getPersona().getOperador() != null
												? peticion.getPersona().getOperador() : "000000043"  );
										parametrosAltaTelefono.put( "integrante"	 , peticion.getPersona().getNumeroPersona() );
										parametrosAltaTelefono.put( "tipo"			 , telefono.getTipoTelefono() );
										parametrosAltaTelefono.put( "lada"			 , "" );
										parametrosAltaTelefono.put( "telefono"		 , telefono.getTelefono()           != null
												? telefono.getTelefono()        : "" );
										parametrosAltaTelefono.put( "relacion"		 , relacion.getClaveParentesco()    != null
												? relacion.getClaveParentesco()        : "" );
										parametrosAltaTelefono.put( "nombre"		 , relacion.getNombre()   		    != null
												? relacion.getNombre()   		  : "" );
										parametrosAltaTelefono.put( "apellidoPaterno", relacion.getApellidoPaterno()    != null
												? relacion.getApellidoPaterno() : "" );
										parametrosAltaTelefono.put( "apellidoMaterno", relacion.getApellidoMaterno()    != null
												? relacion.getApellidoMaterno() : "" );
										parametrosAltaTelefono.put( "fechaAlta"		 , new Date() );
										parametrosAltaTelefono.put( "origen"		 , telefono.getOrigen()  );
										parametrosAltaTelefono.put( "idRelacion"     , relacion.getIdRelacion()  );
										parametrosAltaTelefono.put( "tipo_plan"      , tipoPlan  );

										//Validamos si existe el telefono
										LogHandler.trace(uid, getClass(), "==> actualizarPersona - existeTelefonoIntegrante");
										Integer numeroTelefonos = (Integer) sessionSybaseTx.selectOne(
												"existeTelefonoIntegrante", parametrosAltaTelefono );

										if (numeroTelefonos == 0) {
											LogHandler.trace(uid, getClass(),
													"==> actualizarPersona - registrarTelefonoIntegrante");
											final ResultadoOV resultado = (ResultadoOV)
											sessionSybaseTx.selectOne( "registrarTelefonoIntegrante", parametrosAltaTelefono );

											LogHandler.debug(uid, getClass(),
													"actualizarPersona - registrarTelefonoIntegrante resultado ="
													+ resultado.toString());

											if ( Integer.valueOf(resultado.getCodigo()).intValue() < 0 ) {
												throw new Exception( resultado.getMensaje() + " " + telefono.getTelefono() );
											}
										}
									}
								}
							}
						} else {
							//Nueva relacion
							//Registrar persona-relacion
							PersonaRelacion personaRelacion = new PersonaRelacion();
							personaRelacion.setPersona(peticion.getPersona().getNumeroPersona());
							personaRelacion.setNombre(relacion.getNombre() != null ? relacion.getNombre() : "");
							personaRelacion.setApellidoPaterno(relacion.getApellidoPaterno() != null
									? relacion.getApellidoPaterno() : "");
							personaRelacion.setApellidoMaterno(relacion.getApellidoMaterno() != null
									? relacion.getApellidoMaterno() : "" );

							if ( relacion.getTipoRelacion().equals( TIPO_CONYUGE ) ) {
								personaRelacion.setCodigoRelacion( RELACION_CONYUGE );
							} else {
								personaRelacion.setCodigoRelacion(relacion.getClaveParentesco() != null
										? relacion.getClaveParentesco() : "");
							}

							Integer idRelacion =  insertaRelacion( uid, sessionSybaseTx, personaRelacion );
							relacion.setIdRelacion(idRelacion);

							//Registro Domicilio Relacion

							if ( relacion.getDomicilioRelacion() != null
								&& relacion.getTipoRelacion().equals( TIPO_REFERENCIA )) {
								relacion.getDomicilioRelacion().setTipoDomicilio( TIPO_REFERENCIA );
								relacion.getDomicilioRelacion().setOrigen(
										peticion.getPersona().getDomicilioPersona().getOrigen() != null
										? peticion.getPersona().getDomicilioPersona().getOrigen() : "");
								insertaDomicilio( uid, sessionSybaseTx, relacion.getDomicilioRelacion(), peticion.getPersona(),
										relacion );
							}

							if ( relacion.getTelefonosRelacion() != null ) {
							for ( TelefonoOV telefono : relacion.getTelefonosRelacion() ) {

								//Validacion telefonos

								//Si es referencia
								if ( relacion.getTipoRelacion().equals( TIPO_REFERENCIA ) ) {
									ValidaPersona.validaTelefono(telefono, MODULO_REFERENCIA );
								}
								if ( relacion.getTipoRelacion().equals( TIPO_CONYUGE ) ) {
									ValidaPersona.validaTelefono(telefono, TIPO_CONYUGE );
								}
								if ( relacion.getTipoRelacion().equals( TIPO_RECADO ) ) {
									ValidaPersona.validaTelefono(telefono, TIPO_RECADO );
								}

								String tipoPlan = "";
								if ( telefono.getTipoTelefono().equals(TIPO_DIRECTO)
									|| telefono.getTipoTelefono().equals(TIPO_CONYUGE_DIRECTO)
									|| telefono.getTipoTelefono().equals(TIPO_RECADO)
								  ) {
									tipoPlan = "FIJO";
								}
								else {
									tipoPlan = "C";
								}
								if ( relacion.getTipoRelacion().equals( TIPO_REFERENCIA )) {
									telefono.setTipoTelefono( TIPO_REFERENCIA );
								}
								final HashMap<String, Object> 	parametrosAltaTelefono = new HashMap<String, Object>();
								parametrosAltaTelefono.put( "usuario"	 	 , peticion.getPersona().getOperador() != null
										? peticion.getPersona().getOperador() : "000000043"  );
								parametrosAltaTelefono.put( "integrante"	 , peticion.getPersona().getNumeroPersona() );
								parametrosAltaTelefono.put( "tipo"			 , telefono.getTipoTelefono() );
								parametrosAltaTelefono.put( "lada"			 , "" );
								parametrosAltaTelefono.put( "telefono"		 , telefono.getTelefono()           != null
										? telefono.getTelefono()        : "" );
								parametrosAltaTelefono.put( "relacion"		 , relacion.getClaveParentesco()    != null
										? relacion.getClaveParentesco()        : "" );
								parametrosAltaTelefono.put( "nombre"		 , relacion.getNombre()   		    != null
										? relacion.getNombre()   		  : "" );
								parametrosAltaTelefono.put( "apellidoPaterno", relacion.getApellidoPaterno()    != null
										? relacion.getApellidoPaterno() : "" );
								parametrosAltaTelefono.put( "apellidoMaterno", relacion.getApellidoMaterno()    != null
										? relacion.getApellidoMaterno() : "" );
								parametrosAltaTelefono.put( "fechaAlta"		 , new Date() );
								parametrosAltaTelefono.put( "origen"		 , telefono.getOrigen()  );
								parametrosAltaTelefono.put( "idRelacion"     , relacion.getIdRelacion()  );
								parametrosAltaTelefono.put( "tipo_plan"      , tipoPlan  );

								LogHandler.debug(uid, getClass(), "actualizarPersona - telefono.getTipoTelefono() "
										+ telefono.getTipoTelefono());

								LogHandler.trace(uid, getClass(), "==> actualizarPersona - registrarTelefonoIntegrante");
								final ResultadoOV resultado = (ResultadoOV) sessionSybaseTx.selectOne(
										"registrarTelefonoIntegrante", parametrosAltaTelefono );

								LogHandler.debug(uid, getClass(), "actualizarPersona - registrarTelefonoIntegrante resultado ="
										+ resultado.toString());

								if ( Integer.valueOf(resultado.getCodigo()).intValue() < 0 ) {
									throw new Exception( resultado.getMensaje() + " " + telefono.getTelefono() );
								}
							  }
							}
						}
					}

					}
				//Detalle socioeconomico
				if (  peticion.getPersona().getDetalleSocioeconomico() != null ) {
					//Par�metros estudio socioeconomico
					final HashMap<String, Object> 	parametrosSocioeconomico = new HashMap<String, Object>();
					DetalleSocioeconomicoOV detalleSocioEconomico = peticion.getPersona().getDetalleSocioeconomico();

					ValidaPersona.validaEstudioSocioeconomico(detalleSocioEconomico, MODULO_DETALLESOCIOECONOMICO);
					ValidaPersona.validaDomicilio(detalleSocioEconomico.getDomicilioNegocio(), MODULO_DETALLESOCIOECONOMICO);

					parametrosSocioeconomico.put("persona", peticion.getPersona().getNumeroPersona() );
					parametrosSocioeconomico.put("ingreso_cp", detalleSocioEconomico.getMontoSemanaPago() );
					parametrosSocioeconomico.put("nombre_emp", detalleSocioEconomico.getNombreNegocio());
					parametrosSocioeconomico.put("tipo_establecimiento", detalleSocioEconomico.getTipoNegocio());
					parametrosSocioeconomico.put("actividad_emp", detalleSocioEconomico.getGiroNegocio());
					parametrosSocioeconomico.put("entidad_emp", detalleSocioEconomico.getDomicilioNegocio().getCodigoEstado());
					parametrosSocioeconomico.put("municipio_emp", detalleSocioEconomico.getDomicilioNegocio().getMunicipio());
					parametrosSocioeconomico.put("ciudad_emp", detalleSocioEconomico.getDomicilioNegocio().getCiudad());
					parametrosSocioeconomico.put("colonia_emp", detalleSocioEconomico.getDomicilioNegocio().getColonia());
					parametrosSocioeconomico.put("cp_emp", detalleSocioEconomico.getDomicilioNegocio().getCp());
					parametrosSocioeconomico.put("calle_emp", detalleSocioEconomico.getDomicilioNegocio().getCalle());
					parametrosSocioeconomico.put("entre_calle_emp", detalleSocioEconomico.getDomicilioNegocio().getEntreCalles());

					LogHandler.trace(uid, getClass(), "==> actualizarPersona - actualizarSocioeconomicoPersonaSybase" );
					sessionSybaseTx.update( "actualizarSocioeconomicoPersonaSybase", parametrosSocioeconomico );
					//Existe Domicilio Nuevo Modelo
					parametrosSocioeconomico.put("tipo_domicilio", TIPO_EMPLEO);
					LogHandler.trace(uid, getClass(), "==> actualizarPersona - existePersonaDomicilio" );
					Integer numeroDomicilios = (Integer) sessionSybaseTx.selectOne(
							"existePersonaDomicilio", parametrosSocioeconomico );

					if (numeroDomicilios > 0) {
						detalleSocioEconomico.getDomicilioNegocio().setHoraLocalizaInicial(
								detalleSocioEconomico.getDomicilioNegocio().getHoraLocalizaInicial() != null
								?  detalleSocioEconomico.getDomicilioNegocio().getHoraLocalizaInicial() : "");
						detalleSocioEconomico.getDomicilioNegocio().setHoraLocalizaFinal(
								detalleSocioEconomico.getDomicilioNegocio().getHoraLocalizaFinal() != null
								?  detalleSocioEconomico.getDomicilioNegocio().getHoraLocalizaFinal() : "");

						LogHandler.trace(uid, getClass(), "==> actualizarPersona - actualizaPersonaDomicilio" );
						sessionSybaseTx.update( "actualizaPersonaDomicilio", detalleSocioEconomico.getDomicilioNegocio() );
					} else {
						LogHandler.trace(uid, getClass(), "==> actualizarPersona - insertaDomicilio getDomicilioPersona()" );
						insertaDomicilio( uid, sessionSybaseTx, detalleSocioEconomico.getDomicilioNegocio(),
								peticion.getPersona() , null );
					}
				}
				//Direcci�n electronica
				if (  peticion.getPersona().getDireccionesElectonicas() != null ) {
					for ( DireccionElectronicaOV direccionElectronicaOV: peticion.getPersona().getDireccionesElectonicas() ) {
						direccionElectronicaOV.setNumeroPersona(peticion.getPersona().getNumeroPersona());
						LogHandler.trace(uid, getClass(), "==> actualizarPersona - actualizarCorreoPersona" );
						sessionSybaseTx.update( "actualizarCorreoPersona", direccionElectronicaOV );
					}
				}
				//Persona Complemento
				final HashMap<String, Object> 	parametrosComplemento = new HashMap<String, Object>();
				parametrosComplemento.put("persona", peticion.getPersona().getNumeroPersona() );

				//Se valida si existe la persona complemento
				LogHandler.trace(uid, getClass(), "==> actualizarPersona - existePersonaComplemento" );
				Integer numeroPersonaComplemento = (Integer) sessionSybaseTx.selectOne(
						"existePersonaComplemento", parametrosComplemento );

				if (numeroPersonaComplemento > 0 ) {

					parametrosComplemento.put("apodo", peticion.getPersona().getSobrenombre());
					parametrosComplemento.put("pais_nacimiento", peticion.getPersona().getPaisNacimiento() != null
							? peticion.getPersona().getPaisNacimiento() : "MX");
					parametrosComplemento.put("ocupacion", peticion.getPersona().getOcupacion());
					parametrosComplemento.put("posicion_hogar", peticion.getPersona().getPosicionHogar());
					parametrosComplemento.put("experiencia_credito_grupal",
							peticion.getPersona().getExperienciaCreditoGrupal() != null
							? (peticion.getPersona().getExperienciaCreditoGrupal() ? "S" : "N" ) : null);
					parametrosComplemento.put("ocupacion_pareja", peticion.getPersona().getOcupacionPareja() != null
							? peticion.getPersona().getOcupacionPareja() : " ");
					parametrosComplemento.put("direccion_ocupacion_pareja", peticion.getPersona().getLugarTrabajoPareja());

					parametrosComplemento.put("horario_loc_dom", peticion.getPersona().getDomicilioPersona() != null
							? peticion.getPersona().getDomicilioPersona().getHoraLocalizaInicial() != null
							   ?  peticion.getPersona().getDomicilioPersona().getHoraLocalizaInicial() + "-"
									+  peticion.getPersona().getDomicilioPersona().getHoraLocalizaFinal() : null : null );

					//Se insertan los nuevos parametros de clienteUnico ORIG-406  2da Fase Simplificación de la Renovación
					parametrosComplemento.put("monto_solicitado", peticion.getPersona().getMontoSolicitado() != null
							? peticion.getPersona().getMontoSolicitado() : 0.0);
					parametrosComplemento.put("num_hijos", peticion.getPersona().getNumHijos() != null
							? peticion.getPersona().getNumHijos() : 0);
					parametrosComplemento.put("no_firma_electronica", peticion.getPersona().getNoFirmaElectronica() != null
							? peticion.getPersona().getNoFirmaElectronica() : "");
					parametrosComplemento.put("destino_credito", peticion.getPersona().getDestinoCredito() != null
							? peticion.getPersona().getDestinoCredito() : "");
					// termina

					if ( peticion.getPersona().getDetalleSocioeconomico() != null ) {
						DetalleSocioeconomicoOV detalleSocioEconomico = peticion.getPersona().getDetalleSocioeconomico();

						parametrosComplemento.put("inicia_negocio", detalleSocioEconomico.getIniciaNegocio() != null
								? (detalleSocioEconomico.getIniciaNegocio() ? "S" : "N" ) : null);
						parametrosComplemento.put("tipo_actividad", detalleSocioEconomico.getTipoActividad());
						parametrosComplemento.put("num_empleados", detalleSocioEconomico.getNumeroEmpleados());
						parametrosComplemento.put("exp_rubro", detalleSocioEconomico.getExperienciaRubro());
						parametrosComplemento.put("exp_negocio", detalleSocioEconomico.getExperienciaNegocio());
						parametrosComplemento.put("ingresos", detalleSocioEconomico.getIngresos());
						parametrosComplemento.put("monto_ventas", detalleSocioEconomico.getIngresos());
						parametrosComplemento.put("ganancia_neta", detalleSocioEconomico.getGananciaNeta());
						parametrosComplemento.put("otros_ingresos", detalleSocioEconomico.getOtrosIngresos());
						parametrosComplemento.put("ganancia_act_sec", detalleSocioEconomico.getGananciaActSec());
						parametrosComplemento.put("gastos_familiares", detalleSocioEconomico.getGastosFamiliares());
						parametrosComplemento.put("monto_superavit", detalleSocioEconomico.getMontoSuperavit());
						parametrosComplemento.put("monto_inventario", detalleSocioEconomico.getMontoInventario());
						parametrosComplemento.put("monto_mobiliario_equipo", detalleSocioEconomico.getMontoMobiliarioEquipo());
						parametrosComplemento.put("observaciones_socioeconomico", "");

					}

					parametrosComplemento.put("asesor", peticion.getPersona().getAsesorCredito() != null
							? peticion.getPersona().getAsesorCredito() : "");
					parametrosComplemento.put("sucursal", peticion.getPersona().getSucursal());

					//Se lleva a cabo la actualizacion del complemento de la persona en sybase
					LogHandler.trace(uid, getClass(), "==> actualizarPersona - actualizarComplementoPersonaSybase" );
					sessionSybaseTx.update( "actualizarComplementoPersonaSybase", parametrosComplemento );
				} else {

					DetalleSocioeconomicoOV detalleSocioEconomico = peticion.getPersona().getDetalleSocioeconomico();
					parametrosComplemento.put("apodo", peticion.getPersona().getSobrenombre() != null
							? peticion.getPersona().getSobrenombre() : "");
					parametrosComplemento.put("pais_nacimiento", peticion.getPersona().getPaisNacimiento() != null
							? peticion.getPersona().getPaisNacimiento() : "MX");
					parametrosComplemento.put("ocupacion", peticion.getPersona().getOcupacion() != null
							? peticion.getPersona().getOcupacion() : "");
					parametrosComplemento.put("posicion_hogar", peticion.getPersona().getPosicionHogar() != null
							? peticion.getPersona().getPosicionHogar() : "");
					parametrosComplemento.put("experiencia_credito_grupal",
							peticion.getPersona().getExperienciaCreditoGrupal() != null
							? (peticion.getPersona().getExperienciaCreditoGrupal() ? "S" : "N" ) : "N");
					parametrosComplemento.put("ocupacion_pareja", peticion.getPersona().getOcupacionPareja() != null
							? peticion.getPersona().getOcupacionPareja() : "");
					parametrosComplemento.put("direccion_ocupacion_pareja", peticion.getPersona().getLugarTrabajoPareja() != null
							? peticion.getPersona().getLugarTrabajoPareja() : "");

					parametrosComplemento.put("horario_loc_dom",
							peticion.getPersona().getDomicilioPersona().getHoraLocalizaInicial() != null
							?  peticion.getPersona().getDomicilioPersona().getHoraLocalizaInicial() + "-"
									+  peticion.getPersona().getDomicilioPersona().getHoraLocalizaFinal() : "");

					//Se insertan los nuevos parametros de clienteUnico ORIG-406  2da Fase Simplificación de la Renovación
					parametrosComplemento.put("monto_solicitado", peticion.getPersona().getMontoSolicitado() != null
							? peticion.getPersona().getMontoSolicitado() : 0.0);
					parametrosComplemento.put("num_hijos", peticion.getPersona().getNumHijos() != null
							? peticion.getPersona().getNumHijos() : 0);
					parametrosComplemento.put("no_firma_electronica", peticion.getPersona().getNoFirmaElectronica() != null
							? peticion.getPersona().getNoFirmaElectronica() : "");
					parametrosComplemento.put("destino_credito", peticion.getPersona().getDestinoCredito() != null
							? peticion.getPersona().getDestinoCredito() : "");
					// termina

					parametrosComplemento.put("inicia_negocio", detalleSocioEconomico.getIniciaNegocio() != null
							? (detalleSocioEconomico.getIniciaNegocio() ? "S" : "N" ) : "N");
					parametrosComplemento.put("tipo_actividad", detalleSocioEconomico.getTipoActividad() != null
							? detalleSocioEconomico.getTipoActividad() : "");
					parametrosComplemento.put("num_empleados", detalleSocioEconomico.getNumeroEmpleados() != null
							? detalleSocioEconomico.getNumeroEmpleados() : 0 );
					parametrosComplemento.put("exp_rubro", detalleSocioEconomico.getExperienciaRubro() != null
							? detalleSocioEconomico.getExperienciaRubro() : 0 );
					parametrosComplemento.put("exp_negocio", detalleSocioEconomico.getExperienciaNegocio() != null
							? detalleSocioEconomico.getExperienciaNegocio() : 0 );
					parametrosComplemento.put("ingresos", detalleSocioEconomico.getIngresos() != null
							? detalleSocioEconomico.getIngresos() : 0 );
					parametrosComplemento.put("monto_ventas", detalleSocioEconomico.getIngresos() != null
							? detalleSocioEconomico.getIngresos() : 0 );
					parametrosComplemento.put("ganancia_neta", detalleSocioEconomico.getGananciaNeta() != null
							? detalleSocioEconomico.getGananciaNeta() : 0 );
					parametrosComplemento.put("otros_ingresos", detalleSocioEconomico.getOtrosIngresos() != null
							? detalleSocioEconomico.getOtrosIngresos() : 0 );
					parametrosComplemento.put("ganancia_act_sec", detalleSocioEconomico.getGananciaActSec() != null
							? detalleSocioEconomico.getGananciaActSec() : 0 );
					parametrosComplemento.put("gastos_familiares", detalleSocioEconomico.getGastosFamiliares() != null
							? detalleSocioEconomico.getGastosFamiliares() : 0 );
					parametrosComplemento.put("monto_superavit", detalleSocioEconomico.getMontoSuperavit() != null
							? detalleSocioEconomico.getMontoSuperavit() : 0 );
					parametrosComplemento.put("monto_inventario", detalleSocioEconomico.getMontoInventario() != null
							? detalleSocioEconomico.getMontoInventario() : 0 );
					parametrosComplemento.put("monto_mobiliario_equipo", detalleSocioEconomico.getMontoMobiliarioEquipo() != null
							? detalleSocioEconomico.getMontoMobiliarioEquipo() : 0 );
					parametrosComplemento.put("observaciones_socioeconomico", " " );

					parametrosComplemento.put("asesor", peticion.getPersona().getAsesorCredito() != null
							? peticion.getPersona().getAsesorCredito() : "");
					parametrosComplemento.put("sucursal", peticion.getPersona().getSucursal() != null
							? peticion.getPersona().getSucursal() : 0);
					//Se lleva a cabo el registro del complemento de la persona en sybase
					LogHandler.trace(uid, getClass(), "==> registrarPersona - registrarComplementoPersonaSybase" );
					sessionSybaseTx.insert( "registrarComplementoPersonaSybase", parametrosComplemento );

				 }

				//Se verifica si hubo cambio en nombre, apellido paterno y apellido materno

				if (!peticion.getPersona().getNombre().replace(" ", "").equalsIgnoreCase(
						personaConsulta.getNombre().replace(" ", ""))
					|| !peticion.getPersona().getApellidoPaterno().replace(" ", "").equalsIgnoreCase(
							personaConsulta.getApellidoPaterno().replace(" ", ""))
					|| !peticion.getPersona().getApellidoMaterno().replace(" ", "").equalsIgnoreCase(
							personaConsulta.getApellidoMaterno().replace(" ", ""))
				   ) {

					String nombreModificacion = "";

					//parametros Hist
					final HashMap<String, Object> 	parametrosHist = new HashMap<String, Object>();
					parametrosHist.put("persona", peticion.getPersona().getNumeroPersona() );

					if (!peticion.getPersona().getNombre().trim().equals(personaConsulta.getNombre().trim())) {

						nombreModificacion = nombreModificacion + personaConsulta.getNombre().trim() + ",";
					}

					if (!peticion.getPersona().getApellidoPaterno().trim().equals(personaConsulta.getApellidoPaterno().trim())) {

						nombreModificacion = nombreModificacion + personaConsulta.getApellidoPaterno().trim() + ",";
					}

					if (!peticion.getPersona().getApellidoMaterno().trim().equals(personaConsulta.getApellidoMaterno().trim())) {

						nombreModificacion = nombreModificacion + personaConsulta.getApellidoMaterno().trim();
					}

						parametrosHist.put("nombreModificacion", nombreModificacion );
						LogHandler.info(uid, getClass(), "==> actualizarPersona - nombreModificacion: " + nombreModificacion );
						parametrosHist.put("usuario_mod", peticion.getPersona().getOperador() != null
								? peticion.getPersona().getOperador() : "000000043" );

						sessionSybaseTx.insert("insertaNuevoPersonaHist", parametrosHist);


					LogHandler.info(uid, getClass(), "==> actualizarPersona - cliente cambio datos nombre" );
					parametrosComplemento.put("usuario_mod", peticion.getPersona().getOperador() != null
							? peticion.getPersona().getOperador() : "000000043" );

					sessionSybaseTx.update( "actualizaUsuarioCambioNombre", parametrosComplemento );

				}

				sessionSybaseTx.commit( true );

			}
		catch ( java.lang.Exception exception ) {
			FabricaConexiones.rollBack( sessionSybaseTx );

			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setMensaje( ReadProperties.mensajes.getProp(
					"administracion.persona.erroractualizarpersona" ) + " : " + exception.getMessage() );
			LogHandler.debug(uid, getClass(), "Rollback aplicado ... " );
			LogHandler.error(uid, getClass(), "Fallo la actualizacion : " + exception.getMessage(), exception );
			}
		finally {
			FabricaConexiones.close( sessionSybaseTx );
			FabricaConexiones.close( sessionNTx );
			//FabricaConexiones.close( sessionOracleTx );
			}

		return respuesta;
		}

	/**
	 * Consultar datos persona.
	 *
	 * @param uid :
	 * @param peticion :
	 * @return ConsultarPersonaRespuesta
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ConsultarPersonaRespuesta consultarDatosPersona(java.lang.String uid, ConsultarPersonaPeticion peticion) {
		ConsultarPersonaRespuesta respuesta = new ConsultarPersonaRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus( true );
		respuesta.getHeader().setUID( uid );
		SqlSession sessionNTx = null;

		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

		try {

			if (peticion.getPersona().getNumeroPersona() == null
				|| peticion.getPersona().getNumeroPersona().trim().length() != LONG_PERSONA) {
				throw new Exception( ReadProperties.mensajes.getProp( "administracion.persona.error.idpersona" ) );
			}
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			final HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("persona", peticion.getPersona().getNumeroPersona());

			LogHandler.trace(uid, getClass(), "==> consultarDatosPersona - consultarDatosPersona" );
			PersonaOV personaConsulta = (PersonaOV) sessionNTx.selectOne( "consultarDatosPersona", parametros );

			if (personaConsulta == null) {
				throw new Exception( ReadProperties.mensajes.getProp( "administracion.persona.error.consultapersona" ) );
			}

			//Se valida el monto de pago si es ciclo > 0
			//ORIG-406  2da Fase Simplificación de la Renovación
			if (personaConsulta.getCiclo() > 0) {
				ValidaIntegranteRespuesta respuestaValidaMonto = new ValidaIntegranteRespuesta();
				ValidaIntegrantePeticion peticionValidaMonto = new ValidaIntegrantePeticion();
				peticionValidaMonto.setPersona(personaConsulta.getNumeroPersona());

				respuestaValidaMonto = solicitudesCredito.calcularMontoPreAprobadoPersona(uid, peticionValidaMonto, sessionNTx);

				if (respuestaValidaMonto == null) {
					LogHandler.trace(uid, getClass(), "Error al momento de llamar el metodo: calcularMontoPreAprobadoPersona ");
					personaConsulta.setMontoSolicitado(5000.0);
				}

				if (respuestaValidaMonto.getHeader().isEstatus())
				{
					personaConsulta.setMontoSolicitado(respuestaValidaMonto.getMontoMaximo());
				}
				else if (!respuestaValidaMonto.getHeader().isEstatus()) {
					LogHandler.trace(uid, getClass(), "Error al momento de llamar el metodo: calcularMontoPreAprobadoPersona ===>"
								+ respuestaValidaMonto.getHeader().getMensaje());
					personaConsulta.setMontoSolicitado(5000.0);
				}
			}

			personaConsulta.setEntidadLugarNacimiento(personaConsulta.getEntidadLugarNacimiento() != null
					? personaConsulta.getEntidadLugarNacimiento().trim() : "");

			HashMap<String, Object> datosExtraPersona = new HashMap<String, Object>();
			LogHandler.trace(uid, getClass(), "==> consultarDatosPersona - consultarDatosExtraPersona" );
			datosExtraPersona = (HashMap<String, Object>) sessionNTx.selectOne( "consultarDatosExtraPersona", parametros );

			//Persona.DomicilioOV

			//Se obtiene informacion persona.domicilio
			parametros.clear();
			parametros.put("persona", peticion.getPersona().getNumeroPersona());
			parametros.put("tipo_domicilio", TIPO_DIRECTO);

			//Se busca en persona_domicilios
			LogHandler.trace(uid, getClass(), "==> consultarDatosPersona - consultaDomicilio" );
			DomicilioOV domicilioPersonaTabla = (DomicilioOV) sessionNTx.selectOne( "consultaDomicilio", parametros );

			if (domicilioPersonaTabla == null) {

				DomicilioOV domicilioPersona = new DomicilioOV();
				domicilioPersona.setTipoDomicilio( TIPO_DIRECTO);
				domicilioPersona.setStatus("A");
				domicilioPersona.setPais(datosExtraPersona.get("pais") != null ? datosExtraPersona.get("pais").toString() : "");
				domicilioPersona.setCodigoEstado(datosExtraPersona.get("entidad") != null
						? datosExtraPersona.get("entidad").toString() : "");
				domicilioPersona.setMunicipio(datosExtraPersona.get("municipio") != null
						? datosExtraPersona.get("municipio").toString() : "");
				domicilioPersona.setCiudad(datosExtraPersona.get("ciudad") != null
						? datosExtraPersona.get("ciudad").toString() : "");
				domicilioPersona.setColonia(datosExtraPersona.get("colonia") != null
						? datosExtraPersona.get("colonia").toString() : "");
				domicilioPersona.setCp(datosExtraPersona.get("cp") != null ? datosExtraPersona.get("cp").toString() : "");
				domicilioPersona.setCalle(datosExtraPersona.get("calle") != null
						? datosExtraPersona.get("calle").toString() : "");
				domicilioPersona.setEntreCalles(datosExtraPersona.get("entre_calles") != null
						? datosExtraPersona.get("entre_calles").toString() : "");
				domicilioPersona.setOtrasIndicaciones(datosExtraPersona.get("otras_indicaciones") != null
						? datosExtraPersona.get("otras_indicaciones").toString() : "");
				domicilioPersona.setFechaDomicilio(datosExtraPersona.get("fecha_domicilio") != null
						? formatoDelTexto.parse(datosExtraPersona.get("fecha_domicilio").toString()) : null);
				domicilioPersona.setDiasLocaliza(datosExtraPersona.get("dias_emp") != null
						? datosExtraPersona.get("dias_emp").toString() : "");
				String horarioLocalizacion = datosExtraPersona.get("horario_loc_dom") != null
						? datosExtraPersona.get("horario_loc_dom").toString() : "";

				if (horarioLocalizacion.indexOf("-") > -1) {
					domicilioPersona.setHoraLocalizaInicial(horarioLocalizacion.split("-")[0]);
					domicilioPersona.setHoraLocalizaFinal(horarioLocalizacion.split("-")[1]);
				}
				else {
					domicilioPersona.setHoraLocalizaInicial("");
					domicilioPersona.setHoraLocalizaFinal("");
				}

				domicilioPersona.setTipoVivienda(datosExtraPersona.get("tipo_vivienda") != null
						? datosExtraPersona.get("tipo_vivienda").toString() : "");
				domicilioPersona.setFechaUltimaModificacion(datosExtraPersona.get("fecha_ult_mod_dom") != null
						? formatoDelTexto.parse(datosExtraPersona.get("fecha_ult_mod_dom").toString()) : null);

				personaConsulta.setDomicilioPersona(domicilioPersona);
			} else {

				String horarioLocalizacion = domicilioPersonaTabla.getHoraLocalizaInicial() != null
						? domicilioPersonaTabla.getHoraLocalizaInicial() : "";

				if (horarioLocalizacion.indexOf("-") > -1) {
					domicilioPersonaTabla.setHoraLocalizaInicial(horarioLocalizacion.split("-")[0]);
					domicilioPersonaTabla.setHoraLocalizaFinal(horarioLocalizacion.split("-")[1]);
				}
				else {
					domicilioPersonaTabla.setHoraLocalizaInicial("");
					domicilioPersonaTabla.setHoraLocalizaFinal("");
				}
				personaConsulta.setDomicilioPersona(domicilioPersonaTabla);

			}

			//DetalleSocioeconomicoOV
			DetalleSocioeconomicoOV detalle = new DetalleSocioeconomicoOV();
			detalle.setMontoSemanaPago(datosExtraPersona.get("ingreso_cp") != null
					? Double.parseDouble(datosExtraPersona.get("ingreso_cp").toString()) : 0.0);
			detalle.setIniciaNegocio(datosExtraPersona.get("inicia_negocio") != null
					? (datosExtraPersona.get("inicia_negocio").toString().equals("S") ? true : false ) : false);
			detalle.setNombreNegocio(datosExtraPersona.get("nombre_emp") != null
					? datosExtraPersona.get("nombre_emp").toString() : "");
			detalle.setTipoActividad(datosExtraPersona.get("tipo_actividad") != null
					? datosExtraPersona.get("tipo_actividad").toString() : "");
			detalle.setTipoNegocio(datosExtraPersona.get("tipo_establecimiento") != null
					? datosExtraPersona.get("tipo_establecimiento").toString() : "");
			detalle.setGiroNegocio(datosExtraPersona.get("actividad_emp") != null
					? datosExtraPersona.get("actividad_emp").toString() : "");
			detalle.setNumeroEmpleados(datosExtraPersona.get("num_empleados") != null
					? Integer.parseInt(datosExtraPersona.get("num_empleados").toString()) : 0);
			detalle.setExperienciaRubro(datosExtraPersona.get("exp_rubro") != null
					? Integer.parseInt(datosExtraPersona.get("exp_rubro").toString()) : 0);
			detalle.setExperienciaNegocio(datosExtraPersona.get("exp_negocio") != null
					? Integer.parseInt(datosExtraPersona.get("exp_negocio").toString()) : 0);
			detalle.setIngresos(datosExtraPersona.get("monto_ventas") != null
					? Double.parseDouble(datosExtraPersona.get("monto_ventas").toString()) : 0.0);
			detalle.setGananciaNeta(datosExtraPersona.get("ganancia_neta") != null
					? Double.parseDouble(datosExtraPersona.get("ganancia_neta").toString()) : 0.0);
			detalle.setOtrosIngresos(datosExtraPersona.get("otros_ingresos") != null
					? Double.parseDouble(datosExtraPersona.get("otros_ingresos").toString()) : 0.0);
			detalle.setGananciaActSec(datosExtraPersona.get("ganancia_act_sec") != null
					? Double.parseDouble(datosExtraPersona.get("ganancia_act_sec").toString()) : 0.0);
			detalle.setGastosFamiliares(datosExtraPersona.get("gastos_familiares") != null
					? Double.parseDouble(datosExtraPersona.get("gastos_familiares").toString()) : 0.0);
			detalle.setMontoSuperavit(datosExtraPersona.get("monto_superavit") != null
					? Double.parseDouble(datosExtraPersona.get("monto_superavit").toString()) : 0.0);
			detalle.setMontoInventario(datosExtraPersona.get("monto_inventario") != null
					? Double.parseDouble(datosExtraPersona.get("monto_inventario").toString()) : 0.0);
			detalle.setMontoMobiliarioEquipo(datosExtraPersona.get("monto_mobiliario_equipo") != null
					? Double.parseDouble(datosExtraPersona.get("monto_mobiliario_equipo").toString()) : 0.0);

			//DetalleSocioeconomicoOV.DomicilioOV

			//Se obtiene informacion persona.domicilio
			parametros.clear();
			parametros.put("persona", peticion.getPersona().getNumeroPersona());
			parametros.put("tipo_domicilio", TIPO_EMPLEO);

			//Se busca en persona_domicilios
			LogHandler.trace(uid, getClass(), "==> consultarDatosPersona - consultaDomicilio" );
			DomicilioOV domicilioEmpleoTabla = (DomicilioOV) sessionNTx.selectOne( "consultaDomicilio", parametros );

			if (domicilioEmpleoTabla == null) {

				DomicilioOV domicilioNegocio = new DomicilioOV();
				domicilioNegocio.setTipoDomicilio(TIPO_EMPLEO);
				domicilioNegocio.setStatus("A");
				domicilioNegocio.setPais("MX");
				domicilioNegocio.setCodigoEstado(datosExtraPersona.get("entidad_emp") != null
						? datosExtraPersona.get("entidad_emp").toString() : "");
				domicilioNegocio.setMunicipio(datosExtraPersona.get("municipio_emp") != null
						? datosExtraPersona.get("municipio_emp").toString() : "");
				domicilioNegocio.setCiudad(datosExtraPersona.get("ciudad_emp") != null
						? datosExtraPersona.get("ciudad_emp").toString() : "");
				domicilioNegocio.setColonia(datosExtraPersona.get("colonia_emp") != null
						? datosExtraPersona.get("colonia_emp").toString() : "");
				domicilioNegocio.setCp(datosExtraPersona.get("cp_emp") != null ? datosExtraPersona.get("cp_emp").toString() : "");
				domicilioNegocio.setCalle(datosExtraPersona.get("calle_emp") != null
						? datosExtraPersona.get("calle_emp").toString() : "");
				domicilioNegocio.setEntreCalles(datosExtraPersona.get("entre_calles") != null
						? datosExtraPersona.get("entre_calles").toString() : "");
				detalle.setDomicilioNegocio(domicilioNegocio);
			} else {
				detalle.setDomicilioNegocio(domicilioEmpleoTabla);
			}

			personaConsulta.setDetalleSocioeconomico(detalle);
			//TelefonoOV
			List<String> tipoTelefonos = Arrays.asList(TIPO_DIRECTO , TIPO_CELULAR , TIPO_EMPLEO);
			parametros.put("tipoTelefono", tipoTelefonos);
			LogHandler.trace(uid, getClass(), "==> consultarDatosPersona - consultarTelefonosPersona" );
			final java.util.ArrayList<TelefonoOV> telefonos = (ArrayList<TelefonoOV>)
					sessionNTx.selectList( "consultarTelefonosPersona", parametros );

			//actualizar
			for (int i = 0;  i < telefonos.size(); i++ ) {
				telefonos.get(i).setActualizar(false);
			}

			personaConsulta.setTelefonosPersona(telefonos);
			//TelefonoOV
			List<String> tipoTelefonosRelaciones = Arrays.asList(TIPO_REFERENCIA , TIPO_CONYUGE_CELULAR,
					TIPO_CONYUGE_DIRECTO, TIPO_RECADO);
			parametros.put("tipoTelefono", tipoTelefonosRelaciones);
			//Relaciones
			LogHandler.trace(uid, getClass(), "==> consultarDatosPersona - consultarReferenciasPersona" );
			final java.util.ArrayList<HashMap<String, Object>> relaciones = (ArrayList<HashMap<String, Object>>)
					sessionNTx.selectList( "consultarReferenciasPersona", parametros );
			/*
			//Se obtiene informacion conyuge en caso de existie
			parametros.put("codigoRelacion", RELACION_CONYUGE);
			PersonaRelacion conyuge = (PersonaRelacion)sessionNTx.selectOne( "consultarRelacion", parametros );
			if(conyuge != null){

				personaConsulta.setIdRelacionConyugue( conyuge.getIdRelacion().intValue());
				personaConsulta.setNombreConyugue( conyuge.getNombre() );
				personaConsulta.setApellidoPaternoConyugue( conyuge.getApellidoPaterno() );
				personaConsulta.setApellidoMaternoConyugue( conyuge.getApellidoMaterno() );

			}

			*/

			final java.util.ArrayList<RelacionPersonaOV> listaRelacionesPersona = new java.util.ArrayList();

			Integer idRelacionReferencia = 0;
			RelacionPersonaOV relacionPersona = null;
			java.util.ArrayList<TelefonoOV> telefonosRelacion = null;
			Boolean primero = true;
			for (HashMap<String, Object> relacion :  relaciones ) {

				Integer id = Integer.valueOf(relacion.get("idRelacion") != null ? relacion.get("idRelacion").toString() : "-1");

				LogHandler.debug(uid, getClass(), "relacion ID " + id + "-" + idRelacionReferencia);

				if ( id.intValue() != idRelacionReferencia.intValue() ) {
					//Nueva referencia
					LogHandler.debug(uid, getClass(), "Entra nueva referencia " + id);
					if (primero) {
						primero = false;
					} else {
						listaRelacionesPersona.add(relacionPersona);
					}
					relacionPersona = new RelacionPersonaOV();
					telefonosRelacion = new java.util.ArrayList();
					idRelacionReferencia = id;
					relacionPersona.setIdRelacion(idRelacionReferencia);

					relacionPersona.setNombre( relacion.get("nombre") != null ? relacion.get("nombre").toString() : "");
					relacionPersona.setApellidoPaterno(relacion.get("apellidoPaterno") != null
							? relacion.get("apellidoPaterno").toString() : "");
					relacionPersona.setApellidoMaterno(relacion.get("apellidoMaterno") != null
							? relacion.get("apellidoMaterno").toString() : "");
					relacionPersona.setClaveParentesco(relacion.get("relacion") != null
							? relacion.get("relacion").toString() : "");

					DomicilioOV domicilioReLacion = new DomicilioOV();
					domicilioReLacion.setPais("MX");
					domicilioReLacion.setConsecutivo(relacion.get("consecutivoDomicilio") != null
							? Integer.valueOf(relacion.get("consecutivoDomicilio").toString()) : 0);
					domicilioReLacion.setTipoDomicilio(relacion.get("tipo_domicilio") != null
							? relacion.get("tipo_domicilio").toString() : "");
					domicilioReLacion.setCalle(relacion.get("calle") != null ? relacion.get("calle").toString() : "");
					domicilioReLacion.setNumeroExterior(relacion.get("no_exterior") != null
							? relacion.get("no_exterior").toString() : "");
					domicilioReLacion.setNumeroInterior(relacion.get("no_interior") != null
							? relacion.get("no_interior").toString() : "");
					domicilioReLacion.setColonia(relacion.get("colonia") != null ? relacion.get("colonia").toString() : "");
					domicilioReLacion.setCodigoEstado(relacion.get("codigo_estado") != null
							? relacion.get("codigo_estado").toString() : "");
					domicilioReLacion.setMunicipio(relacion.get("municipio_delegacion") != null
							? relacion.get("municipio_delegacion").toString() : "");
					domicilioReLacion.setCiudad(relacion.get("ciudad") != null ? relacion.get("ciudad").toString() : "");
					domicilioReLacion.setCp(relacion.get("cp") != null ? relacion.get("cp").toString() : "");
					domicilioReLacion.setTipoVivienda(relacion.get("tipo_vivienda") != null
							? relacion.get("tipo_vivienda").toString() : "");
					domicilioReLacion.setIdRelacion(idRelacionReferencia);
					String horarioLocalizacion = relacion.get("horario_localizacion1") != null
							? relacion.get("horario_localizacion1").toString() : "";

					try {
						if (horarioLocalizacion.indexOf("-") > -1) {
							domicilioReLacion.setHoraLocalizaInicial(horarioLocalizacion.split("-")[0]);
							domicilioReLacion.setHoraLocalizaFinal(horarioLocalizacion.split("-")[1]);
						}
						else {
							domicilioReLacion.setHoraLocalizaInicial("");
							domicilioReLacion.setHoraLocalizaFinal("");
						}
					}
					catch (Exception ex) {
						domicilioReLacion.setHoraLocalizaInicial("");
						domicilioReLacion.setHoraLocalizaFinal("");
					}

					domicilioReLacion.setDiasLocaliza(relacion.get("dias_localizacion") != null
							? relacion.get("dias_localizacion").toString() : "0,0,0,0,0,0,0");
					relacionPersona.setDomicilioRelacion(domicilioReLacion);

				}

				TelefonoOV telefonoRelacion = new TelefonoOV();
				String tipoPlan = relacion.get("tipo_plan") != null ? relacion.get("tipo_plan").toString() : "";

				String tipoTelefono = relacion.get("tipoTelefono") != null ? relacion.get("tipoTelefono").toString().trim() : "";

				if ( tipoTelefono.equals( TIPO_REFERENCIA )) {
					relacionPersona.setTipoRelacion( TIPO_REFERENCIA );
					if (	tipoPlan.startsWith("F") ) {
						telefonoRelacion.setTipoTelefono(TIPO_DIRECTO);
					}
					else {
						telefonoRelacion.setTipoTelefono(TIPO_CELULAR);
					}
				} else if ( tipoTelefono.equals( TIPO_RECADO )) {
					relacionPersona.setTipoRelacion( tipoTelefono );
					telefonoRelacion.setTipoTelefono(tipoTelefono);
				} else if ( tipoTelefono.equals( TIPO_CONYUGE_CELULAR ) || tipoTelefono.equals( TIPO_CONYUGE_DIRECTO )) {
					relacionPersona.setTipoRelacion( TIPO_CONYUGE );
					telefonoRelacion.setTipoTelefono( tipoTelefono);
				} else if ( relacionPersona.getClaveParentesco().equals( RELACION_CONYUGE )  ) {
					relacionPersona.setTipoRelacion( TIPO_CONYUGE );
					telefonoRelacion.setTipoTelefono( tipoTelefono);
				}

				if (tipoTelefono.equals("")) {
					//2013-08-05
					//LogHandler.debug(uid, getClass(), "Entro " );
					relacionPersona.setTipoRelacion( relacionPersona.getDomicilioRelacion().getTipoDomicilio() );
				}

				if ( relacionPersona.getTipoRelacion().trim().isEmpty()
						&& relacionPersona.getClaveParentesco().equals(RELACION_CONYUGE) ) {
					relacionPersona.setTipoRelacion( TIPO_CONYUGE );
				}

				if (relacionPersona.getDomicilioRelacion().getTipoDomicilio().trim().isEmpty()) {
					relacionPersona.getDomicilioRelacion().setTipoDomicilio( relacionPersona.getTipoRelacion() );
				}

				telefonoRelacion.setStatus(relacion.get("statusTelefono") != null
						? relacion.get("statusTelefono").toString() : "");
				telefonoRelacion.setTelefono(relacion.get("telefono") != null ? relacion.get("telefono").toString() : "");
				telefonoRelacion.setIdRelacion(idRelacionReferencia);
				telefonoRelacion.setTipoPlan(tipoPlan);
				telefonoRelacion.setCodigoResolucion(relacion.get("codigoResolucion") != null
						? relacion.get("codigoResolucion").toString() : "");
				telefonoRelacion.setFechaAlta(relacion.get("fechaAlta") != null
						? formatoDelTexto.parse(relacion.get("fechaAlta").toString()) : null);
				telefonoRelacion.setUsuarioAlta(relacion.get("usuarioAlta") != null
						? relacion.get("usuarioAlta").toString() : "");
				telefonoRelacion.setFechaUltimaModificacion(relacion.get("fechaUltimaModificacion") != null
						? formatoDelTexto.parse(relacion.get("fechaUltimaModificacion").toString()) : null);
				telefonoRelacion.setUsuarioModificacion(relacion.get("usuarioModificacion") != null
						? relacion.get("usuarioModificacion").toString() : "");
				telefonoRelacion.setFechaUltimaVerificacion(relacion.get("fechaUltimaVerificacion") != null
						? formatoDelTexto.parse(relacion.get("fechaUltimaVerificacion").toString()) : null);
				telefonoRelacion.setLugar(relacion.get("lugar") != null ? relacion.get("lugar").toString() : "");
				telefonoRelacion.setOrigen(relacion.get("origen") != null ? relacion.get("origen").toString() : "");
				telefonoRelacion.setFechaStatus(relacion.get("fechaStatus") != null
						? formatoDelTexto.parse(relacion.get("fechaStatus").toString()) : null);
				telefonoRelacion.setFechaContacto(relacion.get("fechaContacto") != null
						? formatoDelTexto.parse(relacion.get("fechaContacto").toString()) : null);

				//2013-09-30 Se agrega un estatus para la validacion
				telefonoRelacion.setActualizar(false);

				//2013-09-25 Se regresan todos los telefonos
				if ( !(telefonoRelacion.getStatus().isEmpty()) ) {
					telefonosRelacion.add(telefonoRelacion);
				}
				relacionPersona.setTelefonosRelacion(telefonosRelacion);

			}

			if ( relaciones != null && !primero) {
				listaRelacionesPersona.add(relacionPersona);
			}
			personaConsulta.setRelacionesPersona(listaRelacionesPersona);
			//DireccionElectronicaOV
			java.util.ArrayList<DireccionElectronicaOV> direccionesElectonicas =  new java.util.ArrayList();
			DireccionElectronicaOV direccionElectronica = new DireccionElectronicaOV();
			direccionElectronica.setDireccionElectronica(datosExtraPersona.get("correo") != null
					? datosExtraPersona.get("correo").toString() : "");
			direccionesElectonicas.add(direccionElectronica);
			personaConsulta.setDireccionesElectonicas(direccionesElectonicas);

			//RelacionClaveFinsolOV
			RelacionClaveFinsolOV relacionClaves = new RelacionClaveFinsolOV();
			relacionClaves.setNumeroPersona(peticion.getPersona().getNumeroPersona());
			relacionClaves.setClaveCU(datosExtraPersona.get("clave_cu") != null
					? datosExtraPersona.get("clave_cu").toString() : "");
			relacionClaves.setClaveFinsol(datosExtraPersona.get("clave_finsol") != null
					? datosExtraPersona.get("clave_finsol").toString() : "");
			personaConsulta.setRelacionClaveFinsol(relacionClaves);

			final java.util.ArrayList<PersonaOV> lista = new java.util.ArrayList();
			lista.add(personaConsulta);
			respuesta.setPersona(lista);

		}
		catch (Exception exception) {
			LogHandler.error(uid, getClass(), ReadProperties.mensajes.getProp(
					"administracion.persona.error.consultar.persona" ), exception);
			respuesta.getHeader().setUID( uid );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setMensaje( ReadProperties.mensajes.getProp(
					"administracion.persona.error.consultar.persona" ) + " : " + exception.getMessage() );
		}
		finally {
			FabricaConexiones.close( sessionNTx );
		}

		return respuesta;
	}


	/**
	 * Consulta datos generales persona.
	 *
	 * @param uid :
	 * @param peticion :
	 * @return ConsultaDatosGeneralesRespuesta
	 */
	@SuppressWarnings("unchecked")
	public ConsultaDatosGeneralesRespuesta consultaDatosGeneralesPersona(String uid, ConsultaDatosGeneralesPeticion peticion) {

		ConsultaDatosGeneralesRespuesta respuesta = new ConsultaDatosGeneralesRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID( uid );
		respuesta.getHeader().setEstatus( true );
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		SqlSession sessionNTx = null;

		try {

			if ( peticion == null) {
				throw new Exception( ReadProperties.mensajes.getProp( "administracion.persona.consulta.error.peticion" ) );
			}

			peticion.setNumeroPersona( peticion.getNumeroPersona() != null
					? ( peticion.getNumeroPersona().trim().isEmpty() ? null : peticion.getNumeroPersona().trim() ) : null);
			peticion.setClaveT24( peticion.getClaveT24() != null
					? ( peticion.getClaveT24().trim().isEmpty() ? null : peticion.getClaveT24().trim() ) : null);
			peticion.setClaveCU( peticion.getClaveCU() != null ? ( peticion.getClaveCU().trim().isEmpty()
					? null : peticion.getClaveCU().trim() ) : null);
			peticion.setRfc( peticion.getRfc() != null ? ( peticion.getRfc().trim().isEmpty()
					? null : peticion.getRfc().trim() ) : null);

			if ( peticion.getNumeroPersona() == null && peticion.getClaveT24() == null && peticion.getClaveCU() == null
					&& peticion.getRfc() == null) {
				throw new Exception( ReadProperties.mensajes.getProp( "administracion.persona.consulta.error.peticion" ) );
			}
			int contador = 0;

			if ( peticion.getNumeroPersona() != null ) { contador++; }
			if ( peticion.getClaveT24() != null ) { contador++; }
			if ( peticion.getClaveCU() != null ) { contador++; }
			if ( peticion.getRfc() != null ) { contador++; }

			if (contador > 1) {
				throw new Exception( ReadProperties.mensajes.getProp( "administracion.persona.consulta.error.peticion.claves" ) );
			}

			LogHandler.debug(uid, getClass(), "consultaDatosGeneralesPersona - Realizar busqueda " );

			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			final HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("persona", peticion.getNumeroPersona() );
			parametros.put("clave_finsol", peticion.getClaveT24() );
			parametros.put("clave_cu", peticion.getClaveCU() );
			parametros.put("rfc", peticion.getRfc() );

			HashMap<String, Object> personaConsulta = (HashMap<String, Object>) sessionNTx.selectOne(
					"consultaDatosGeneralesPersonaNuevoModelo", parametros );

			if (personaConsulta == null) {
				personaConsulta = (HashMap<String, Object>) sessionNTx.selectOne( "consultaDatosGeneralesPersona", parametros );
			}
			if (personaConsulta == null) {
				throw new Exception( ReadProperties.mensajes.getProp( "administracion.persona.consulta.error.resultado" ) );
			}

			PersonaOV persona = new PersonaOV();

			persona.setNumeroPersona( personaConsulta.get("persona") != null ? personaConsulta.get("persona").toString() : null );
			persona.setNombre( personaConsulta.get("nombre") != null ? personaConsulta.get("nombre").toString() : null );
			persona.setApellidoPaterno( personaConsulta.get("apellidoPaterno") != null
					? personaConsulta.get("apellidoPaterno").toString() : null );
			persona.setApellidoMaterno( personaConsulta.get("apellidoMaterno") != null
					? personaConsulta.get("apellidoMaterno").toString() : null );
			persona.setRfc( personaConsulta.get("rfc") != null ? personaConsulta.get("rfc").toString() : null );
			persona.setFechaNacimiento( personaConsulta.get("fechaNacimiento") != null
					? formatoDelTexto.parse( personaConsulta.get("fechaNacimiento").toString() ) : null );
			persona.setSexo( personaConsulta.get("sexo") != null ? personaConsulta.get("sexo").toString() : null );

			persona.setDomicilioPersona(new DomicilioOV());
			persona.getDomicilioPersona().setNumeroPersona( persona.getNumeroPersona() );
			persona.getDomicilioPersona().setPais(personaConsulta.get("pais") != null
					? personaConsulta.get("pais").toString() : null);
			persona.getDomicilioPersona().setCodigoEstado(personaConsulta.get("entidad") != null
					? personaConsulta.get("entidad").toString().trim() : null);
			persona.getDomicilioPersona().setMunicipio(personaConsulta.get("municipio") != null
					? personaConsulta.get("municipio").toString() : null);
			persona.getDomicilioPersona().setCiudad(personaConsulta.get("ciudad") != null
					? personaConsulta.get("ciudad").toString() : null);
			persona.getDomicilioPersona().setColonia(personaConsulta.get("colonia") != null
					? personaConsulta.get("colonia").toString() : null);
			persona.getDomicilioPersona().setCp(personaConsulta.get("cp") != null ? personaConsulta.get("cp").toString() : null);
			persona.getDomicilioPersona().setCalle(personaConsulta.get("calle") != null
					? personaConsulta.get("calle").toString() : null);
			persona.getDomicilioPersona().setEntreCalles(personaConsulta.get("entre_calles") != null
					? personaConsulta.get("entre_calles").toString() : null);
			persona.getDomicilioPersona().setNumeroExterior(personaConsulta.get("no_exterior") != null
					? personaConsulta.get("no_exterior").toString() : null);
			persona.getDomicilioPersona().setNumeroInterior(personaConsulta.get("no_interior") != null
					? personaConsulta.get("no_interior").toString() : null);

			respuesta.setPersona(persona);

		}
		catch (Exception ex) {
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setMensaje( ex.getMessage() );
		}
		finally {
			FabricaConexiones.close( sessionNTx );
		}
		return respuesta;
	}


	/**
	 * @param uid identificador unico de la transaccion
	 * @param peticion para consultar personas
	 * @return ConsultarPersonaRespuesta resultado de la consulta de personas
	 */
	@SuppressWarnings("unchecked")
	public ConsultarPersonaRespuesta consultarPersona(String uid, ConsultarPersonaPeticion peticion)	{
		//Objeto para almacenar la respuesta del m�todo
		final ConsultarPersonaRespuesta respuesta = new ConsultarPersonaRespuesta();

		//Objeto para abrir la session a BD
		SqlSession sessionNTx = null;

		try {
			//Validaciones
			/*if ( ( peticion.getPersona().getNombre() == null || peticion.getPersona().getNombre().trim().isEmpty())
				&&	( peticion.getPersona().getApellidoPaterno() == null
				||  peticion.getPersona().getApellidoPaterno().trim().isEmpty() )
				&&  ( peticion.getPersona().getApellidoMaterno() == null
				||  peticion.getPersona().getApellidoMaterno().trim().isEmpty() )
				&&	peticion.getPersona().getFechaNacimiento() == null ) {
				 throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.datos.incompletos" ) );
				}
			*/

			if ( peticion.getPersona().getRfc() == null || peticion.getPersona().getRfc().trim().isEmpty()) {
				 throw new Exception( ReadProperties.mensajes.getProp( "ciof.error.datos.incompletos" ) );
			}

			//Se vuelven nulas las cadenas vacias
			/*
			if ( peticion.getPersona().getNombre() != null && peticion.getPersona().getNombre().trim().equals( "" ) ) {
				peticion.getPersona().setNombre( null );
			}
			if ( peticion.getPersona().getApellidoPaterno() != null
					&&  peticion.getPersona().getApellidoPaterno().trim().equals( "" ) ) {
				peticion.getPersona().setApellidoPaterno( null );
				}
			if ( peticion.getPersona().getApellidoMaterno() != null
					&&  peticion.getPersona().getApellidoMaterno().trim().equals( "" ) ) {
				peticion.getPersona().setApellidoMaterno( null );
			}
			*/
			//Se cargan los par�metros para los filtros en la busqueda
			final java.util.HashMap<String, Object>
							parametros = new HashMap<String, Object>();
			/*parametros.put( "nombre"		 , peticion.getPersona().getNombre() != null
					? peticion.getPersona().getNombre().trim() : null );
			parametros.put( "apellidoPaterno", peticion.getPersona().getApellidoPaterno() != null
					? peticion.getPersona().getApellidoPaterno().trim() : null);
			parametros.put( "apellidoMaterno", peticion.getPersona().getApellidoMaterno() != null
					? peticion.getPersona().getApellidoMaterno().trim() : null);
			parametros.put( "fechaNacimiento", peticion.getPersona().getFechaNacimiento() );
			*/
			parametros.put("rfc", peticion.getPersona().getRfc().trim());
			//Se abre la conexi�n
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			//se realiza la consulta
			LogHandler.trace(uid, getClass(), "==> consultarPersona - buscarDisponibilidad" );
			final java.util.ArrayList<PersonaOV> coincidencias = (ArrayList<PersonaOV>)
						sessionNTx.selectList( "buscarDisponibilidad", parametros );

			//Se asigna el resultado a las respuestas
			respuesta.setPersona( coincidencias );
			}
		catch ( java.lang.Exception exception ) {
			LogHandler.error(uid, getClass(), "Error al ejecutar la consulta + " + exception.getMessage() , exception );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setMensaje( "Error al ejecutar la consulta + " + exception.getMessage() );
			respuesta.getHeader().setUID( uid );
			}
		finally {
			FabricaConexiones.close( sessionNTx );
			}

		return respuesta;
		}

	/**
	 * Consultar cliente unico.
	 *
	 * @param uid :
	 * @param peticion :
	 * @return ConsultarClienteUnicoRespuesta
	 */
	@SuppressWarnings("unchecked")
	public ConsultarClienteUnicoRespuesta consultarClienteUnico(String uid,	ConsultarClienteUnicoPeticion peticion) {
		//Objeto para almacenar la respuesta del m�todo
		final ConsultarClienteUnicoRespuesta respuesta = new ConsultarClienteUnicoRespuesta();

		//Objeto para abrir la session a BD
		SqlSession sessionOracleNTx = null;

		try {
			//Se vuelven nulas las cadenas vacias
			if ( peticion.getPersona().getNombre() != null && peticion.getPersona().getNombre().trim().equals( "" ) )
					{		peticion.getPersona().setNombre( null );				}
			if ( peticion.getPersona().getApellidoPaterno() != null
					&&  peticion.getPersona().getApellidoPaterno().trim().equals( "" ) ) {
				peticion.getPersona().setApellidoPaterno( null );
			}
			if ( peticion.getPersona().getApellidoMaterno() != null
					&&  peticion.getPersona().getApellidoMaterno().trim().equals( "" ) ) {
				peticion.getPersona().setApellidoMaterno( null );
			}
			if ( peticion.getPersona().getRfc() == null &&  peticion.getPersona().getRfc().trim().equals( "" ) )
					{		peticion.getPersona().setRfc( null );					}

			//Se cargan los par�metros para los filtros en la busqueda
			final java.util.HashMap<String, Object>
							parametros = new HashMap<String, Object>();
							parametros.put( "nombre"		 , peticion.getPersona().getNombre() );
							parametros.put( "apellidoPaterno", peticion.getPersona().getApellidoPaterno() );
							parametros.put( "apellidoMaterno", peticion.getPersona().getApellidoMaterno() );
							parametros.put( "fechaNacimiento", peticion.getPersona().getFechaNacimiento() );
							parametros.put( "rfc"			 , peticion.getPersona().getRfc() );

			//Obtenemos la sesion
			sessionOracleNTx = FabricaConexiones.obtenerSesionOrclCUNTx();

			//se realiza la consulta
			LogHandler.trace(uid, getClass(), "==> consultarClienteUnico - buscarSimilitudesClienteUnico" );
			final java.util.ArrayList<PersonaOV> coincidencias = (ArrayList<PersonaOV>)
					sessionOracleNTx.selectList( "buscarSimilitudesClienteUnico", parametros );

			//Se asigna el resultado a las respuestas
			respuesta.setPersona( coincidencias );

			}
		catch ( java.lang.Exception exception ) {
			LogHandler.error(uid, getClass(), "Error al ejecutar la consulta + " + exception.getMessage() , exception );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setMensaje( "Error al ejecutar la consulta + " + exception.getMessage() );
			respuesta.getHeader().setUID( uid );
			}
		finally {
			FabricaConexiones.close( sessionOracleNTx );
			}

		return respuesta;
		}

	// Funciones privadas  --------------------------------------------------------------------------------------------
	//SYBASE

	/**
	 * Inserta domicilio.
	 *
	 * @param uid :
	 * @param sessionTx :
	 * @param domicilio :
	 * @param persona :
	 * @param relacion :
	 * @throws Exception the exception
	 */
	private void insertaDomicilio(String uid, SqlSession sessionTx, DomicilioOV domicilio, PersonaOV persona,
			RelacionPersonaOV relacion   ) throws java.lang.Exception {

		LogHandler.debug(uid, getClass(), "insertaDomicilio" );
		final java.util.HashMap<String, Object>	parametros = new HashMap<String, Object>();
		parametros.put("persona" , persona.getNumeroPersona()  );
		parametros.put("tipo_domicilio" , domicilio.getTipoDomicilio() );
		parametros.put("consecutivo" , null );

		if ( domicilio.getTipoDomicilio() != TIPO_REFERENCIA ) {
			parametros.put("id_relacion" , null );
		}
		else {

			if (relacion.getIdRelacion() == null || relacion.getIdRelacion() <= 0) {
				throw new Exception(" ES NECESARIO EL ID RELACION PARA DOMICILIOS DE REFERENCIAS ");
			}

			parametros.put("id_relacion" , relacion.getIdRelacion()  );
		}

		parametros.put("calle" ,  domicilio.getCalle() != null ? domicilio.getCalle() : "" );
		parametros.put("no_exterior" , domicilio.getNumeroExterior()  != null ? domicilio.getNumeroExterior() : "" );
		parametros.put("no_interior" , domicilio.getNumeroInterior()  != null ? domicilio.getNumeroInterior() : ""  );
		parametros.put("colonia" , domicilio.getColonia()  != null ? domicilio.getColonia() : ""  );
		parametros.put("ciudad" , domicilio.getCiudad()  != null ? domicilio.getCiudad() : ""  );
		parametros.put("municipio_delegacion" , domicilio.getMunicipio()  != null ? domicilio.getMunicipio() : "" );
		parametros.put("codigo_estado" , domicilio.getCodigoEstado() != null ? domicilio.getCodigoEstado() : "" );
		parametros.put("cp" , domicilio.getCp() != null ? domicilio.getCp() : "" );
		parametros.put("entre_calles" , domicilio.getEntreCalles() != null ? domicilio.getEntreCalles() : "" );
		parametros.put("tipo_vivienda" , domicilio.getTipoVivienda() != null ? domicilio.getTipoVivienda() : ""  );
		parametros.put("latitud" , 0d );
		parametros.put("longitud" , 0d );
		parametros.put("horario_localizacion1" , domicilio.getHoraLocalizaInicial() != null
				? domicilio.getHoraLocalizaInicial() + "-" + domicilio.getHoraLocalizaFinal() : "" );
		parametros.put("horario_localizacion2" , "" );
		parametros.put("dias_localizacion" , domicilio.getDiasLocaliza() != null ? domicilio.getDiasLocaliza() : ""  );
		parametros.put("fecha_antiguedad_domiciliio" , domicilio.getFechaDomicilio() != null
				? domicilio.getFechaDomicilio() : new Date());
		parametros.put("origen" , domicilio.getOrigen() != null ? domicilio.getOrigen() : ""  );
		parametros.put("status" , "A"  );
		parametros.put("fecha_status" , new Date()  );
		parametros.put("fecha_alta" , new Date()  );
		parametros.put("usuario_alta" , persona.getOperador() != null ? persona.getOperador() : ""  );
		parametros.put("fecha_ult_mod" , new Date()  );
		parametros.put("usuario_ult_mod" , persona.getOperador() != null ? persona.getOperador() : ""  );


		LogHandler.trace(uid, getClass(), "==> insertaDomicilio - obtieneConsecutivoDomicilio" );
		Integer consecutivo =  (Integer) sessionTx.selectOne( "obtieneConsecutivoDomicilio", parametros );
		parametros.put("consecutivo" , consecutivo  );

		LogHandler.trace(uid, getClass(), "==> insertaDomicilio - registrarDomicilioCredprod" );
		sessionTx.insert( "registrarDomicilioCredprod", parametros );
	}

	/**
	 * Inserta relacion.
	 *
	 * @param uid :
	 * @param sessionTx :
	 * @param relacion :
	 * @return Integer
	 * @throws Exception the exception
	 */
	private Integer insertaRelacion(String uid, SqlSession sessionTx, PersonaRelacion relacion   ) throws java.lang.Exception {

		LogHandler.debug(uid, getClass(), "insertaRelacion" );

		LogHandler.trace(uid, getClass(), "==> insertaRelacion - registrarRelacionCredprod" );
		Integer idRelacion = sessionTx.insert( "registrarRelacionCredprod", relacion );

		LogHandler.debug(uid, getClass(), "#registros =" + idRelacion );
		LogHandler.debug(uid, getClass(), "id_relacion=" + relacion.getIdRelacion() );

		return  relacion.getIdRelacion().intValue();

	}


	/**
	 * Actualiza relacion.
	 *
	 * @param uid :
	 * @param sessionTx :
	 * @param relacion :
	 * @throws Exception the exception
	 */
	private void actualizaRelacion(String uid, SqlSession sessionTx, PersonaRelacion relacion   ) throws java.lang.Exception {

		LogHandler.debug(uid, getClass(), "actualizaRelacion" );

		LogHandler.trace(uid, getClass(), "==> actualizaRelacion - actualizarRelacionCredprod" );
		Integer idRelacion = sessionTx.insert( "actualizarRelacionCredprod", relacion );

		LogHandler.debug(uid, getClass(), "#registros =" + idRelacion );
		LogHandler.debug(uid, getClass(), "id_relacion=" + relacion.getIdRelacion() );

	}

	/**
	 * Usada para configurar los datos a clienteunico y registrarlo.
	 *
	 * @param uid :
	 * @param sessionOracleTx :
	 * @param persona :
	 * @return SqlSession
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unused")
	private SqlSession registrarClienteUnico( String uid, SqlSession sessionOracleTx,
			PersonaOV persona ) throws java.lang.Exception {
		//Objeto que servira para la persistencia
		final java.util.HashMap<String, Object>
		parametros = new HashMap<String, Object>();
		parametros.put("custumerID"	, persona.getRelacionClaveFinsol().getClaveCU() );
		parametros.put("firstName" 	, persona.getNombre().split( " " )[0] );
		parametros.put("otherName" 	, persona.getNombre().substring(
				parametros.get("firstName" ).toString().length() ).trim() );
		parametros.put("secondName"	, persona.getApellidoPaterno() );
		parametros.put("lastName"  	, persona.getApellidoMaterno() != null ?  persona.getApellidoMaterno() : "");
		parametros.put("gender"	   	, persona.getSexo() );
		parametros.put("birthday"  	, persona.getFechaNacimiento() );
		parametros.put("edoCivil"  	, persona.getEstadoCivil() );
		parametros.put("rfc"	   	, persona.getRfc() );
		parametros.put("curp"  	   	, persona.getCurp() );
		parametros.put("escolaridad", "" );
		parametros.put("titulo"		, "" );
		parametros.put("apodo"		, persona.getSobrenombre() );

		//Telefonos
		if ( persona.getTelefonosPersona() != null) {
			for ( TelefonoOV telefonoOV : persona.getTelefonosPersona() ) {
				if ( telefonoOV.getTipoTelefono().equals( "CELU" )) {
					parametros.put("telefonoCel", telefonoOV.getTelefono() );
					}
				if ( telefonoOV.getTipoTelefono().equals( "DIRE" )) {
					parametros.put("telefonoFijo", telefonoOV.getTelefono() );
					}
				if ( telefonoOV.getTipoTelefono().equals( "COND" )) {
					parametros.put("telParejaCel", telefonoOV.getTelefono() );
					}
				if ( telefonoOV.getTipoTelefono().equals( "CONC" )) {
					parametros.put("telParejaFijo", telefonoOV.getTelefono() );
					}
			}
		}

		if ( parametros.get("telefonoCel") == null) {
			 parametros.put("telefonoCel", "");
		}
		if ( parametros.get("telefonoFijo") == null) {
			 parametros.put("telefonoFijo", "");
		}
		if ( parametros.get("telParejaCel") == null) {
			parametros.put("telParejaCel"	, "" );
		}
		if ( parametros.get("telParejaFijo") == null) {
			parametros.put("telParejaFijo"	, "" );
		}

		parametros.put("alertasObs"		, "" );
		parametros.put("iniciaNegocio"	, persona.getDetalleSocioeconomico().getIniciaNegocio() != null
				?  persona.getDetalleSocioeconomico().getIniciaNegocio() ? "S" : "N"  : "N");
		parametros.put("monotPagSem"	, persona.getDetalleSocioeconomico().getMontoSemanaPago() != null
				? persona.getDetalleSocioeconomico().getMontoSemanaPago() : 0.0);
		parametros.put("nombrePareja"	, " " );
		parametros.put("ocupacionPareja", persona.getOcupacionPareja() != null
				? persona.getOcupacionPareja() : "" );
		parametros.put("direccionOcupacionPareja", persona.getLugarTrabajoPareja() != null
				? persona.getLugarTrabajoPareja() : "" );

		parametros.put("noHijosDep"		, 0 );
		parametros.put("noDependientes"	, persona.getNumeroDependientes() != null ? persona.getNumeroDependientes() : 0  );
		parametros.put("userID"			, persona.getOperador() != null ? persona.getOperador() : "000000043"  );
		parametros.put("userName"		, persona.getOperador() != null ? persona.getOperador() : "000000043"  );
		parametros.put("ife"			,  persona.getNumeroIdentificacion() != null ? persona.getNumeroIdentificacion() : ""  );

		parametros.put("correo"			, persona.getDireccionesElectonicas() != null
										&& persona.getDireccionesElectonicas().size() > 0
										 ?	persona.getDireccionesElectonicas().get( 0 ).getDireccionElectronica() : "" );

		parametros.put("diasLocalizacion"		, persona.getDomicilioPersona() != null
				? persona.getDomicilioPersona().getDiasLocaliza() != null
				? persona.getDomicilioPersona().getDiasLocaliza() : ""  : "");
		parametros.put("horarioLocalizacion"	, persona.getDomicilioPersona() != null
				? persona.getDomicilioPersona().getHoraLocalizaInicial() != null
				?  persona.getDomicilioPersona().getHoraLocalizaInicial() + "-"
						+  persona.getDomicilioPersona().getHoraLocalizaFinal() : ""  : "");
		LogHandler.trace(uid, getClass(), "==> registrarClienteUnico - registrarClienteUnico" );
		sessionOracleTx.insert( "registrarClienteUnico", parametros );

		//Se regresa la session con la nueva consulta
		return sessionOracleTx;
		}

	/**
	 * M�todo para registrar el domicilio en cliente unico.
	 *
	 * @param uid :
	 * @param sessionOracleTx :
	 * @param persona :
	 * @return SqlSession
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unused")
	private SqlSession registrarCUReferencias( java.lang.String uid, SqlSession sessionOracleTx,
			PersonaOV persona ) throws java.lang.Exception {
		//parametros
		final java.util.HashMap<String, Object>	parametros = new HashMap<String, Object>();

		int contador = 0;
		for ( RelacionPersonaOV referencia : persona.getRelacionesPersona()) {

				if (referencia.getTipoRelacion().equals(TIPO_REFERENCIA)) {
					contador++;
					parametros.put( "customerID" 			, persona.getRelacionClaveFinsol().getClaveCU() );
					parametros.put( "nombreCompleto" 	   	, 	(referencia.getNombre() != null
							? referencia.getNombre() : "") + " "
							+	(referencia.getApellidoMaterno() != null ? referencia.getApellidoMaterno() : "")
							+ " " +	(referencia.getApellidoPaterno() != null ? referencia.getApellidoPaterno() : "") );

					parametros.put( "relacionCliente" 	   	, referencia.getClaveParentesco() != null
							? DataMapper.mapRelacionOracle.get(referencia.getClaveParentesco().trim()) : CLAVE_PARENTESCO );
					parametros.put( "referenciaID"    		, contador );

					parametros.put( "direccion" 	   		, referencia.getDomicilioRelacion().getDireccionCompleta() != null
							? referencia.getDomicilioRelacion().getDireccionCompleta() : "" );
					parametros.put( "horaLocalizaDesde"		, referencia.getDomicilioRelacion().getHoraLocalizaInicial() != null
							?  referencia.getDomicilioRelacion().getHoraLocalizaInicial() : "" );
					parametros.put( "horaLocalizaHasta" 	, referencia.getDomicilioRelacion().getHoraLocalizaFinal() != null
							?  referencia.getDomicilioRelacion().getHoraLocalizaFinal() : "");

					//Ejemplo  0,1,0,1,1,1,1

					String []dias = referencia.getDomicilioRelacion().getDiasLocaliza().trim().split(",");

					parametros.put( "localizaLunes"			, dias[POSICION_LUNES].trim());
					parametros.put( "localizaMartes"		, dias[POSICION_MARTES].trim());
					parametros.put( "localizaMiercoles"		, dias[POSICION_MIERCOLES].trim());
					parametros.put( "localizaJueves"		, dias[POSICION_JUEVES].trim());
					parametros.put( "localizaViernes"		, dias[POSICION_VIERNES].trim());
					parametros.put( "localizaSabado"		, dias[POSICION_SABADO].trim());
					parametros.put( "localizaDomingo"		, dias[POSICION_DOMINGO].trim());

					//Telefonos
					for ( TelefonoOV telefonoOV : referencia.getTelefonosRelacion() ) {
						if ( parametros.get("telefono") == null) {
								parametros.put("telefono", telefonoOV.getTelefono() );
						} else {
							parametros.put("telefonoCel", telefonoOV.getTelefono() );
						}
					}

					if ( parametros.get("telefonoCel") == null) {
						 parametros.put("telefonoCel", "");
					}
					if ( parametros.get("telefono") == null) {
						 parametros.put("telefono", "");
					}
					LogHandler.trace(uid, getClass(), "==> registrarReferencias - registrarCUReferencia" );
					sessionOracleTx.insert( "registrarCUReferencia", parametros );
				}

		}
		//Se regresa la session con la nueva consulta
		return sessionOracleTx;
		}

	/**
	 * M�todo para registrar las referenecias en cliente unico.
	 *
	 * @param uid :
	 * @param sessionOracleTx :
	 * @param persona :
	 * @param domicilio :
	 * @param tipo :
	 * @return SqlSession
	 * @throws Exception the exception
	 */
	private SqlSession registrarCUDomicilio( String uid, SqlSession sessionOracleTx, PersonaOV persona, DomicilioOV domicilio,
			int tipo ) throws java.lang.Exception {
		//parametros
		final java.util.HashMap<String, Object>
					parametros = new HashMap<String, Object>();

					parametros.put( "customerID" , persona.getRelacionClaveFinsol().getClaveCU() );
					parametros.put( "calle" 	   , domicilio.getCalle() != null ?  domicilio.getCalle() + " "
							+ domicilio.getNumeroExterior() + " " + domicilio.getNumeroInterior() : "");
					parametros.put( "codPostal"    , domicilio.getCp() != null ?  domicilio.getCp() : "");
					parametros.put( "colonia" 	   , domicilio.getColonia() != null ?  domicilio.getColonia() : "");
					parametros.put( "municipio"    , domicilio.getMunicipio() != null ?  domicilio.getMunicipio() : "");
					parametros.put( "localidad"    , domicilio.getCiudad() != null ?  domicilio.getCiudad() : "");
					parametros.put( "estado" 	   , domicilio.getCodigoEstado() != null
							? DataMapper.mapEntidadesOracle.get(domicilio.getCodigoEstado().trim()) : "");
					parametros.put( "pais"		   , "MEXICO" );
					parametros.put( "refUbicacion" , domicilio.getEntreCalles() != null ?  domicilio.getEntreCalles() : "");
					parametros.put( "tipoPropiedad", domicilio.getTipoVivienda() != null
							? DataMapper.mapTipoViviendaOracle.get( domicilio.getTipoVivienda() ) : 0);
					parametros.put( "domicilioActual"  , tipo );
					parametros.put( "tiempoResid" 	   , domicilio.getFechaDomicilio() != null
							? Funciones.calculoAnios(domicilio.getFechaDomicilio()) : 0);
					parametros.put( "tipoLocalidad"    , domicilio.getTipoLocalidad() != null
							? domicilio.getTipoLocalidad() : "");
					parametros.put( "IDNeighbourhood"  , "");
					parametros.put( "tipoPropiedadOtro", "" );
					LogHandler.debug(uid, getClass(), "Parametros registrarCUDomicilio" + parametros);

		LogHandler.trace(uid, getClass(), "==> registrarCUDomicilio - registrarCUDomicilio" );
		sessionOracleTx.insert( "registrarCUDomicilio", parametros );

		//Se regresa la session con la nueva consulta
		return sessionOracleTx;
		}

	/**
	 * M�todo para el registro de datos en la tabla CU_SOCIOECONOMICOS.
	 *
	 * @param uid :
	 * @param sessionOracleTx :
	 * @param persona :
	 * @param socioeconomico :
	 * @return SqlSession
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unused")
	private SqlSession registrarCUSocioeconomico( java.lang.String uid, SqlSession sessionOracleTx, PersonaOV persona,
			DetalleSocioeconomicoOV socioeconomico )throws java.lang.Exception {

		//parametros
		final java.util.HashMap<String, Object>
					parametros = new HashMap<String, Object>();

					parametros.put( "customerID", persona.getRelacionClaveFinsol().getClaveCU() );
					parametros.put( "empresa",  socioeconomico.getNombreNegocio() != null
							? socioeconomico.getNombreNegocio() : "");

					for ( TelefonoOV telefonoOV : persona.getTelefonosPersona() ) {
						if ( telefonoOV.getTipoTelefono().equals( "EMPL" )) {
							parametros.put("telefono", telefonoOV.getTelefono() );
							}
					}

					if ( parametros.get("telefono") == null) {
						parametros.put( "telefono", "" );
					}

					try {
						parametros.put( "giroEmpresa",  socioeconomico.getGiroNegocio() != null
								? DataMapper.mapGiroNegocioOracle.get(socioeconomico.getGiroNegocio().trim()) : 0 );
					} catch (Exception ex) {
						parametros.put( "giroEmpresa",  DEFAULT_GIRO_EMPRESA );
					}

					parametros.put( "tipoActividad", socioeconomico.getTipoActividad() != null
							? DataMapper.mapTipoActividadOracle.get(socioeconomico.getTipoActividad()) : DEFAULT_TIPO_ACTIVIDAD);
					parametros.put( "tipoNegocio", socioeconomico.getTipoNegocio() != null
							? DataMapper.mapTipoNegocioOracle.get(socioeconomico.getTipoNegocio()) : DEFAULT_TIPO_NEGOCIO );
					parametros.put( "expRubro", socioeconomico.getExperienciaRubro() != null
							? socioeconomico.getExperienciaRubro() : 0  );
					parametros.put( "expNegocio", socioeconomico.getExperienciaNegocio() != null
							? socioeconomico.getExperienciaNegocio() : 0 );
					parametros.put( "ventas", socioeconomico.getIngresos() != null ? socioeconomico.getIngresos() : 0.0 );
					parametros.put( "gananciaNeta", socioeconomico.getGananciaNeta() != null
							? socioeconomico.getGananciaNeta() : 0.0 );
					parametros.put( "ingresosOtros", socioeconomico.getOtrosIngresos() != null
							? socioeconomico.getOtrosIngresos() : 0.0 );
					parametros.put( "gananciaActSec", socioeconomico.getGananciaActSec() != null
							? socioeconomico.getGananciaActSec() : 0.0 );
					parametros.put( "gastosFamiliares", socioeconomico.getGastosFamiliares() != null
							? socioeconomico.getGastosFamiliares() : 0.0 );
					parametros.put( "inventario", socioeconomico.getMontoInventario() != null
							? socioeconomico.getMontoInventario() : 0.0 );
					parametros.put( "mobiliarioEquipo", socioeconomico.getMontoMobiliarioEquipo() != null
							? socioeconomico.getMontoMobiliarioEquipo() : 0.0 );
					parametros.put( "superavit", socioeconomico.getMontoSuperavit() != null
							? socioeconomico.getMontoSuperavit() : 0.0 );
					parametros.put( "diasVendeTianguis", "" );

					LogHandler.debug(uid, getClass(), "Parametros Socioeconomicos" + parametros);

		LogHandler.trace(uid, getClass(), "==> registrarCUSocioeconomico - registrarCUSocioeconomico" );
		sessionOracleTx.insert( "registrarCUSocioeconomico", parametros );

		return sessionOracleTx;
		}

	/**
	 * M�todo para el registro de datos en la tabla CU_INFO_FINSOL.
	 *
	 * @param uid :
	 * @param sessionOracleTx :
	 * @param persona :
	 * @return SqlSession
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unused")
	private SqlSession registrarCUInfoFinsol( java.lang.String uid, SqlSession sessionOracleTx,
			PersonaOV persona ) throws java.lang.Exception {

		//parametros
		final java.util.HashMap<String, Object>
					parametros = new HashMap<String, Object>();
					parametros.put( "customerID", persona.getRelacionClaveFinsol().getClaveCU() );
					parametros.put( "branchCode", persona.getSucursal() != null ? persona.getSucursal() : 0);
					parametros.put( "daoAsesor" , persona.getAsesorCredito() != null ? persona.getAsesorCredito() : "" );

					/*parametros.put( "nombreAsesor", );
					parametros.put( "nombreGrupo",  );

					parametros.put( "flagReg", "");
					*/

		LogHandler.debug(uid, getClass(), "Parametros registrarCUInfoFinsol" + parametros);

		LogHandler.trace(uid, getClass(), "==> registrarCUInfoFinsol - registrarCUInfoFinsol" );
		sessionOracleTx.insert( "registrarCUInfoFinsol", parametros );

		return sessionOracleTx;
		}

	/**
	 * M�todo para el registro de datos en la tabla CU_CLIENTE_COMPLEMENTO.
	 *
	 * @param uid :
	 * @param sessionOracleTx :
	 * @param persona :
	 * @return SqlSession
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unused")
	private SqlSession registrarCUClienteComplemento( java.lang.String uid, SqlSession sessionOracleTx,
			PersonaOV persona ) throws java.lang.Exception {

		//parametros
		final java.util.HashMap<String, Object>
					parametros = new HashMap<String, Object>();

					parametros.put( "customerID", persona.getRelacionClaveFinsol().getClaveCU() );
					parametros.put( "IDTipoTelefono", 0);
					parametros.put( "experienciaCreditoGrupal",  persona.getExperienciaCreditoGrupal() != null
										? (persona.getExperienciaCreditoGrupal() ? "1" : "0") : "0" );
					//Ejemplo  0,1,0,1,1,1,1

					String []dias = persona.getDomicilioPersona().getDiasLocaliza().trim().split(",");

					parametros.put( "localizaLunes"			, dias[POSICION_LUNES]);
					parametros.put( "localizaMartes"		, dias[POSICION_MARTES]);
					parametros.put( "localizaMiercoles"		, dias[POSICION_MIERCOLES]);
					parametros.put( "localizaJueves"		, dias[POSICION_JUEVES]);
					parametros.put( "localizaViernes"		, dias[POSICION_VIERNES]);
					parametros.put( "localizaSabado"		, dias[POSICION_SABADO]);
					parametros.put( "localizaDomingo"		, dias[POSICION_DOMINGO]);
					parametros.put( "horaLocalizaDesde"		, persona.getDomicilioPersona().getHoraLocalizaInicial() != null
							?  persona.getDomicilioPersona().getHoraLocalizaInicial() : "" );
					parametros.put( "horaLocalizaHasta" 	, persona.getDomicilioPersona().getHoraLocalizaFinal() != null
							?  persona.getDomicilioPersona().getHoraLocalizaFinal() : "");

					LogHandler.debug(uid, getClass(), "Parametros registrarCUClienteComplemento" + parametros);
		LogHandler.trace(uid, getClass(), "==> registrarCUClienteComplemento - registrarCUClienteComplemento" );
		sessionOracleTx.insert( "registrarCUClienteComplemento", parametros );

		return sessionOracleTx;
		}

	/**
	 * M�todo para actualizar la tabla de CU_CLIENTE, perteneciente a cliente �nico.
	 *
	 * @param uid :
	 * @param sessionOracleTx :
	 * @param persona :
	 * @return SqlSession
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unused")
	private SqlSession actualizarClienteUnico( String uid, SqlSession sessionOracleTx,
			PersonaOV persona ) throws java.lang.Exception {

				final java.util.HashMap<String, Object>
				parametros = new HashMap<String, Object>();
				parametros.put("sucursal"	, persona.getSucursal() );
				parametros.put("custumerID"	, persona.getRelacionClaveFinsol().getClaveCU() );
				parametros.put("firstName" 	, persona.getNombre().split( " " )[0] );
				parametros.put("otherName" 	, persona.getNombre().substring(
						parametros.get("firstName" ).toString().length() ).trim() );
				parametros.put("secondName"	, persona.getApellidoPaterno() );
				parametros.put("lastName"  	, persona.getApellidoMaterno() );
				parametros.put("gender"	   	, persona.getSexo() );
				parametros.put("birthday"  	, persona.getFechaNacimiento() );
				parametros.put("edoCivil"  	, persona.getEstadoCivil() );
				parametros.put("rfc"	   	, persona.getRfc() );
				parametros.put("curp"  	   	, persona.getCurp() );
				parametros.put("escolaridad", null );
				parametros.put("titulo"		, null );
				parametros.put("apodo"		, persona.getSobrenombre() );

				//Telefonos
				if ( persona.getTelefonosPersona() != null) {
					for ( TelefonoOV telefonoOV : persona.getTelefonosPersona() ) {
						if ( telefonoOV.getTipoTelefono().equals( "CELU" )) {
							parametros.put("telefonoCel", telefonoOV.getTelefono() );
							}
						if ( telefonoOV.getTipoTelefono().equals( "DIRE" )) {
							parametros.put("telefonoFijo", telefonoOV.getTelefono() );
							}
						if ( telefonoOV.getTipoTelefono().equals( "COND" )) {
							parametros.put("telParejaCel", telefonoOV.getTelefono() );
							}
						if ( telefonoOV.getTipoTelefono().equals( "CONC" )) {
							parametros.put("telParejaFijo", telefonoOV.getTelefono() );
							}
					}
				}

				parametros.put("alertasObs"		, null );
				parametros.put("iniciaNegocio"	, persona.getDetalleSocioeconomico().getIniciaNegocio() != null
						?  persona.getDetalleSocioeconomico().getIniciaNegocio() ? "S" : "N"  : null);
				parametros.put("monotPagSem"	, persona.getDetalleSocioeconomico().getMontoSemanaPago());
				parametros.put("nombrePareja"	, "");
				parametros.put("ocupacionPareja", persona.getOcupacionPareja());
				parametros.put("direccionOcupacionPareja", persona.getLugarTrabajoPareja());
				parametros.put("noHijosDep"		, null );
				parametros.put("noDependientes"	, persona.getNumeroDependientes());
				parametros.put("userID"			, persona.getOperador());
				parametros.put("userName"		, persona.getOperador());
				parametros.put("ife"			,  persona.getNumeroIdentificacion());
				parametros.put("correo"			, persona.getDireccionesElectonicas() != null
							&& persona.getDireccionesElectonicas().size() > 0
							? persona.getDireccionesElectonicas().get( 0 ).getDireccionElectronica() : null );
				parametros.put("diasLocalizacion"		, persona.getDomicilioPersona() != null
						? persona.getDomicilioPersona().getDiasLocaliza() != null
						? persona.getDomicilioPersona().getDiasLocaliza() : null  : null);
				parametros.put("horarioLocalizacion"	, persona.getDomicilioPersona() != null
						? persona.getDomicilioPersona().getHoraLocalizaInicial() != null
						? persona.getDomicilioPersona().getHoraLocalizaInicial() + "-"
						+  persona.getDomicilioPersona().getHoraLocalizaFinal() : null  : null);

				LogHandler.trace(uid, getClass(), "==> actualizarClienteUnico - actualizarClienteUnico" );
				int registrosActualizados = 0;
				registrosActualizados = sessionOracleTx.update( "actualizarClienteUnico", parametros );
				LogHandler.info(uid, getClass(), "==> actualizarClienteUnico - registrosActualizados " + registrosActualizados );
				if (registrosActualizados == 0) {
					throw new Exception( ReadProperties.mensajes.getProp( "administracion.persona.error.actualizar" ) );
				}

				//Se regresa la session con la nueva consulta

				return sessionOracleTx;
		}


	/**
	 * M�todo para actualizar los domicilios dentro de CU_DOMICILIOS.
	 *
	 * @param uid :
	 * @param sessionOracleTx :
	 * @param persona :
	 * @param domicilio :
	 * @param tipo :
	 * @return SqlSession
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unused")
	private SqlSession actualizarCUDomicilio( java.lang.String uid, SqlSession sessionOracleTx, PersonaOV persona,
			DomicilioOV domicilio, int tipo ) throws java.lang.Exception {
				//parametros
				final java.util.HashMap<String, Object>
				parametros = new HashMap<String, Object>();

				parametros.put( "customerID" , persona.getRelacionClaveFinsol().getClaveCU() );
				parametros.put( "calle" 	   , domicilio.getCalle() != null ?  domicilio.getCalle() + " "
						+ domicilio.getNumeroExterior() + " " + domicilio.getNumeroInterior() : "");
				parametros.put( "codPostal"    , domicilio.getCp());
				parametros.put( "colonia" 	   , domicilio.getColonia());
				parametros.put( "municipio"    , domicilio.getMunicipio());
				parametros.put( "localidad"    , domicilio.getCiudad());
				parametros.put( "estado" 	   , domicilio.getCodigoEstado() != null
						? DataMapper.mapEntidadesOracle.get(domicilio.getCodigoEstado().trim()) : null );
				parametros.put( "pais"		   , "MEXICO" );
				parametros.put( "refUbicacion" , domicilio.getEntreCalles());
				parametros.put( "tipoPropiedad", domicilio.getTipoVivienda() != null
						? DataMapper.mapTipoViviendaOracle.get( domicilio.getTipoVivienda() ) : null);
				parametros.put( "domicilioActual"  , tipo );
				parametros.put( "tiempoResid" 	   , domicilio.getFechaDomicilio() != null
						? Funciones.calculoAnios(domicilio.getFechaDomicilio()) : null);
				parametros.put( "tipoLocalidad"    , domicilio.getTipoLocalidad() );
				parametros.put( "IDNeighbourhood"  , null);
				parametros.put( "tipoPropiedadOtro", null );

				SqlSession sessionOracleNTx = FabricaConexiones.obtenerSesionOrclCUNTx();

				//existe domicilio
				LogHandler.trace(uid, getClass(), "==> actualizarCUDomicilio - existeCUDomicilio" );
				Integer numeroDomicilios = (Integer) sessionOracleNTx.selectOne( "existeCUDomicilio", parametros );

				if (numeroDomicilios > 0) {
					LogHandler.debug(uid, getClass(), "Parametros actualizarCUDomicilio" + parametros);
					LogHandler.trace(uid, getClass(), "==> actualizarCUDomicilio - actualizarCUDomicilio" );
					sessionOracleTx.update( "actualizarCUDomicilio", parametros );
				} else {

					sessionOracleTx = registrarCUDomicilio( uid, sessionOracleTx, persona , domicilio , tipo);

				}

				sessionOracleNTx.close();

		//Se regresa la session con la nueva consulta

		return sessionOracleTx;
		}

	/**
	 * M�todo para actualizar los domicilios dentro de CU_CLIENTE_SOCIOECONOMICO.
	 *
	 * @param uid :
	 * @param sessionOracleTx :
	 * @param persona :
	 * @param socioeconomico :
	 * @return SqlSession
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unused")
	private SqlSession actualizarCUSocioeconomico( String uid, SqlSession sessionOracleTx, PersonaOV persona,
			DetalleSocioeconomicoOV socioeconomico ) throws java.lang.Exception {
			//parametros
			final java.util.HashMap<String, Object> 	parametros = new HashMap<String, Object>();

			parametros.put( "customerID", persona.getRelacionClaveFinsol().getClaveCU() );
			parametros.put( "empresa",  socioeconomico.getNombreNegocio());
			for ( TelefonoOV telefonoOV : persona.getTelefonosPersona() ) {
				if ( telefonoOV.getTipoTelefono().equals( "EMPL" )) {
					parametros.put("telefono", telefonoOV.getTelefono() );
					}
			}

			try {
				parametros.put( "giroEmpresa",  socioeconomico.getGiroNegocio() != null
						? DataMapper.mapGiroNegocioOracle.get(socioeconomico.getGiroNegocio().trim()) : 0 );
				} catch (Exception ex) {
					parametros.put( "giroEmpresa",  DEFAULT_GIRO_EMPRESA );
				}

			parametros.put( "tipoActividad", socioeconomico.getTipoActividad() != null
					? DataMapper.mapTipoActividadOracle.get(socioeconomico.getTipoActividad()) : null );
			parametros.put( "tipoNegocio", socioeconomico.getTipoNegocio() != null
					? DataMapper.mapTipoNegocioOracle.get(socioeconomico.getTipoNegocio()) : null );
			parametros.put( "expRubro", socioeconomico.getExperienciaRubro());
			parametros.put( "expNegocio", socioeconomico.getExperienciaNegocio());

			parametros.put( "ventas", socioeconomico.getIngresos());
			parametros.put( "gananciaNeta", socioeconomico.getGananciaNeta());
			parametros.put( "ingresosOtros", socioeconomico.getOtrosIngresos());
			parametros.put( "gananciaActSec", socioeconomico.getGananciaActSec());
			parametros.put( "gastosFamiliares", socioeconomico.getGastosFamiliares());
			parametros.put( "inventario", socioeconomico.getMontoInventario());
			parametros.put( "mobiliarioEquipo", socioeconomico.getMontoMobiliarioEquipo());
			parametros.put( "superavit", socioeconomico.getMontoSuperavit());
			parametros.put( "diasVendeTianguis", null );

			LogHandler.debug(uid, getClass(), "Parametros Socioeconomicos" + parametros);

			LogHandler.trace(uid, getClass(), "==> actualizarCUSocioeconomico - actualizarCUSocioEconomico" );
			sessionOracleTx.update( "actualizarCUSocioEconomico", parametros );

			return sessionOracleTx;

	}


	/**
	 * M�todo para actualizar CU_CLIENTE_COMPLEMENTO.
	 *
	 * @param uid :
	 * @param sessionOracleTx :
	 * @param persona :
	 * @return SqlSession
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unused")
	private SqlSession actualizarCUClienteComplemento( java.lang.String uid, SqlSession sessionOracleTx,
			PersonaOV persona ) throws java.lang.Exception {

			//parametros
			final java.util.HashMap<String, Object>
			parametros = new HashMap<String, Object>();

			parametros.put( "customerID", persona.getRelacionClaveFinsol().getClaveCU() );
			parametros.put( "IDTipoTelefono", 0);
			parametros.put( "experienciaCreditoGrupal",  persona.getExperienciaCreditoGrupal() != null
					?	(persona.getExperienciaCreditoGrupal()  ? "1" : "0") : null);
			//Ejemplo  0,1,0,1,1,1,1
			if ( persona.getDomicilioPersona() != null && persona.getDomicilioPersona().getDiasLocaliza() != null) {
				String []dias = persona.getDomicilioPersona().getDiasLocaliza().replace(" ", "").split(",");

				parametros.put( "localizaLunes"			, dias[POSICION_LUNES]);
				parametros.put( "localizaMartes"		, dias[POSICION_MARTES]);
				parametros.put( "localizaMiercoles"		, dias[POSICION_MIERCOLES]);
				parametros.put( "localizaJueves"		, dias[POSICION_JUEVES]);
				parametros.put( "localizaViernes"		, dias[POSICION_VIERNES]);
				parametros.put( "localizaSabado"		, dias[POSICION_SABADO]);
				parametros.put( "localizaDomingo"		, dias[POSICION_DOMINGO]);
				parametros.put( "horaLocalizaDesde"		, persona.getDomicilioPersona().getHoraLocalizaInicial());
				parametros.put( "horaLocalizaHasta" 	, persona.getDomicilioPersona().getHoraLocalizaFinal());
			}

			LogHandler.debug(uid, getClass(), "Parametros actualizarCUClienteComplemento" + parametros);
			LogHandler.trace(uid, getClass(), "==> actualizarCUClienteComplemento - actualizarCUClienteComplemento" );
			sessionOracleTx.update( "actualizarCUClienteComplemento", parametros );

			return sessionOracleTx;

		}

	/**
	 * Registrar prospecto.
	 *
	 * @param uid :
	 * @param peticion :
	 * @return RegistrarPersonaRespuesta
	 */
	@SuppressWarnings("unchecked")
	public RegistrarPersonaRespuesta registrarProspecto(java.lang.String uid, RegistrarPersonaPeticion peticion) {
		final RegistrarPersonaRespuesta respuesta = new RegistrarPersonaRespuesta( uid );
		//Objetos para manejo de la sesiones
			SqlSession 	sessionSybaseTx = null;
			//SqlSession  sessionNTx	  	= null;
			//SqlSession 	sessionOracleTx = null;
			//Boolean replicaOracle = false;

			try {
				 // Validaciones - Buscamos si existen registros previos
				LogHandler.info(uid, getClass(), "No persona :" + peticion.getPersona().getNumeroPersona().trim() + "**");
				if (peticion.getPersona().getNumeroPersona() != null
					&& !peticion.getPersona().getNumeroPersona().trim().isEmpty()) {
					throw new Exception( ReadProperties.mensajes.getProp( "administracion.persona.errorpersonayaregistrada" ) );
				}
				if (peticion.getPersona() == null || peticion.getPersona().getProspecto() == null
					|| !peticion.getPersona().getProspecto()) {
					throw new Exception( ReadProperties.mensajes.getProp( "administracion.prospecto.errorprospecto" ) );
				}
				final ConsultarPersonaPeticion 	consultarPersonaPeticion = new ConsultarPersonaPeticion();
				consultarPersonaPeticion.setPersona( peticion.getPersona() );
				final ConsultarPersonaRespuesta	consultarPersonaRespuesta = consultarPersona(uid, consultarPersonaPeticion);

				//Se valida si hay registros con datos iguales
				if ( consultarPersonaRespuesta.getPersona() != null && consultarPersonaRespuesta.getPersona().size() > 0 ) {
					throw new Exception( ReadProperties.mensajes.getProp( "administracion.persona.errorpersonayaregistrada" ) );
				}

				//Se abre la session No transaccional sybase
				//sessionNTx = FabricaConexiones.obtenerSesionNTx();

				//Se abre la session transaccional sybase
				sessionSybaseTx = FabricaConexiones.obtenerSesionTx();

				/**
				 * Generacion de secuencias
				 */
				//Secuencias para codigo-persona-credprod_finsol
				LogHandler.trace(uid, getClass(), "==> registrarProspecto - obtenerValorSequenciasPersona" );
				final java.util.ArrayList<HashMap<String, Object>> 	clavesActuales
					= (ArrayList<HashMap<String, Object>>) sessionSybaseTx.selectList( "obtenerValorSequenciasPersona" );

				//Se generan las secuencias
				final java.util.HashMap<String, Long> clavesActualizadas = new HashMap<String, Long>();
				//Se incrementa al siguiente consecutivo
				for ( HashMap<String, Object> secuencia : clavesActuales ) {
					clavesActualizadas.put( secuencia.get( "tipo").toString(),
							Long.valueOf( secuencia.get( "actual" ).toString() )
							+ Long.valueOf( secuencia.get( "incremento" ).toString() ) );
				}
				if ( peticion.getPersona().getDetalleSocioeconomico() == null) {
					peticion.getPersona().setDetalleSocioeconomico(new DetalleSocioeconomicoOV());
				}

				//Se actualizan las secuencias al nuevo valor
				LogHandler.trace(uid, getClass(), "==> registrarProspecto - actualizarSequenciasPersona" );
				sessionSybaseTx.update( "actualizarSequenciasPersona" );

				LogHandler.info(uid, getClass(), "Clave de persona : " + clavesActualizadas.get( "PER" ) );
				LogHandler.info(uid, getClass(), "Clave de t24 : " + clavesActualizadas.get( "T24" ) );

				//Se asignan las claves al objeto principal para las personas
				final RelacionClaveFinsolOV relacionClaveFinsolOV = new RelacionClaveFinsolOV();
				relacionClaveFinsolOV.setNumeroPersona( clavesActualizadas.get( "PER" ).toString() );
				//relacionClaveFinsolOV.setClaveFinsol( clavesActualizadas.get( "T24" ).toString() );
				relacionClaveFinsolOV.setClaveFinsol(  clavesActualizadas.get( "PER" ).toString() );
				//relacionClaveFinsolOV.setClaveCU    ( peticion.getPersona().getRfc() );
				relacionClaveFinsolOV.setClaveCU( clavesActualizadas.get( "PER" ).toString() );

				//Se asignan claves a la peticion
				peticion.getPersona().setRelacionClaveFinsol( relacionClaveFinsolOV );
				peticion.getPersona().setNumeroPersona( clavesActualizadas.get( "PER" ).toString() );
				respuesta.setRelacionClaveFinsol(relacionClaveFinsolOV);

				//Se busca que las claves no esten registradas
				LogHandler.trace(uid, getClass(), "==> registrarProspecto - buscarClavePersona" );
				final java.util.ArrayList<String>	clavesRegistradas = (ArrayList<String>)
						sessionSybaseTx.selectList( "buscarClavePersona", relacionClaveFinsolOV );

				//Se valida que no existan
				if ( clavesRegistradas != null &&  clavesRegistradas.size() > 0 ) {
					throw new Exception( ReadProperties.mensajes.getProp( "administracion.persona.errorclaveexistente" ) );
				}

				ValidaPersona.validaPersonaProspecto(peticion.getPersona(), MODULO_PERSONA);

				peticion.setPersona( (PersonaOV) limpiaObjeto(peticion.getPersona()) );

				//Se lleva a cabo el registro de la persona en sybase
				LogHandler.trace(uid, getClass(), "==> registrarProspecto - registrarProspectoSybase" );
				sessionSybaseTx.insert( "registrarProspectoSybase", peticion.getPersona() );
				//Persona Complemento

				final HashMap<String, Object> 	parametrosComplemento = new HashMap<String, Object>();

				parametrosComplemento.put("persona", peticion.getPersona().getNumeroPersona() );
				parametrosComplemento.put("asesor", peticion.getPersona().getAsesorCredito() != null
						? peticion.getPersona().getAsesorCredito() : "");
				parametrosComplemento.put("sucursal", peticion.getPersona().getSucursal() != null
						? peticion.getPersona().getSucursal() : 0);

				//Se lleva a cabo el registro del complemento de la persona en sybase
				LogHandler.trace(uid, getClass(), "==> registrarPersona - registrarComplementoProspectoSybase" );
				sessionSybaseTx.insert( "registrarComplementoProspectoSybase", parametrosComplemento );

				if (peticion.getPersona().getDomicilioPersona() != null ) {
					DomicilioOV domicilioOV = peticion.getPersona().getDomicilioPersona();
					ValidaPersona.validaDomicilioProspecto(domicilioOV, MODULO_PERSONA);
					peticion.getPersona().getDomicilioPersona().setNumeroPersona(  peticion.getPersona().getNumeroPersona() );
					peticion.getPersona().getDomicilioPersona().setTipoDomicilio( TIPO_DIRECTO );
					peticion.getPersona().getDomicilioPersona().setPais(
							peticion.getPersona().getDomicilioPersona().getPais() == null
							? "MX" : peticion.getPersona().getDomicilioPersona().getPais() );
					//Domicilios
					LogHandler.trace(uid, getClass(), "==> registrarProspecto - actualizarDomicilioPersona" );
					sessionSybaseTx.update( "actualizarDomicilioPersona", domicilioOV );

					//Registro Domicilio DIRE
					insertaDomicilio( uid, sessionSybaseTx, peticion.getPersona().getDomicilioPersona(),
									peticion.getPersona() , null );
				}
				//Relacion de claves para interoperatividad entre bases
				LogHandler.trace(uid, getClass(), "==> registrarProspecto - insertarClavesPersona" );
				sessionSybaseTx.insert( "insertarClavesPersona", relacionClaveFinsolOV );

				sessionSybaseTx.commit( true );

				LogHandler.debug(uid, getClass(), "COMMIT APLICADO!");

			}
			catch ( java.lang.Exception exception ) {
				//Rollback a ambas conexiones transaccionales
				FabricaConexiones.rollBack( sessionSybaseTx );
				/*if ( replicaOracle ) {
					FabricaConexiones.rollBack( sessionOracleTx );
				}*/
				LogHandler.debug(uid, getClass(), "ROLLBACK APLICADO!");
				LogHandler.error(uid, getClass(), ReadProperties.mensajes.getProp(
						"administracion.persona.errorregistrarpersona" ), exception);
				respuesta.getHeader().setUID( uid );
				respuesta.getHeader().setEstatus( false );
				respuesta.getHeader().setMensaje( ReadProperties.mensajes.getProp(
						"administracion.persona.errorregistrarpersona" ) + " : " + exception.getMessage() );
				}
			finally {
				FabricaConexiones.close( sessionSybaseTx );
		}
		return respuesta;
	}



	/**
	 * @param uid identificador unico de la transaccion
	 * @param peticion para validar los datos de la persona
	 * @return ValidarDatosPersonaRespuesta resultado de la validacion de la persona
	 */
	public ValidarDatosPersonaRespuesta validarDatosPersonaTarea(String uid,
			ValidarDatosPersonaPeticion peticion) {
		ValidarDatosPersonaRespuesta respuesta = new ValidarDatosPersonaRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);

		SqlSession sesion = null;
		String mensajes = "";
		Boolean estatus = true;
		Boolean estatusEdoCivil = true;

		try	{
			sesion = FabricaConexiones.obtenerSesionNTx();

			if (	peticion == null || peticion.getNumeroPersona() == null || peticion.getNumeroPersona().trim().isEmpty()) {
				throw new Exception("LOS DATOS DE LA PETICION SON INCORRECTOS");
			}

			LogHandler.trace(uid, getClass(), "validarDatosPersonaTarea: - obtenerValidarDatosPersona");
			LogHandler.info(uid, getClass(), "validarDatosPersonaTarea: - obtenerValidarDatosPersona");

			ValidaPersonaOV datosPersona =
					(ValidaPersonaOV) sesion.selectOne("obtenerValidarDatosPersona",	peticion.getNumeroPersona());

			if (datosPersona == null) {
				throw new Exception("No existe informacion para el numero de persona de la peticion");
			}

			//Validaciones datosPersona
			mensajes = "El cliente [" + peticion.getNumeroPersona()  + "] no tiene captura completa, falta: <br>";

			if (!validarString(datosPersona.getTipoCaptura())) {
				mensajes = mensajes + "Tipo de Captura <br>";
				estatus = false;
			}
			if (!validarDoble(datosPersona.getMontoPagoSemanal())) {
				mensajes = mensajes + "Monto Pago Semanal <br>";
				estatus = false;
			}
			if (!validarString(datosPersona.getNombre())) {
				mensajes = mensajes + "Nombre <br>";
				estatus = false;
			}
			if (!validarString(datosPersona.getApellidoPaterno())) {
				mensajes = mensajes + "Apellido Paterno <br>";
				estatus = false;
			}
			if (!validarString(datosPersona.getFechaNacimiento())) {
				mensajes = mensajes + "Fecha de Nacimiento <br>";
				estatus = false;
			}
			if (!validarString(datosPersona.getRfc())) {
				mensajes = mensajes + "Rfc <br>";
				estatus = false;
			}
			if (!validarString(datosPersona.getTipoIdentificacion())) {
				mensajes = mensajes + "Tipo de Identificacion <br>";
				estatus = false;
			}
			if (!validarString(datosPersona.getNumeroIdentificacion())) {
				mensajes = mensajes + "Numero de Identificacion <br>";
				estatus = false;
			}
			if (!validarString(datosPersona.getSexo())) {
				mensajes = mensajes + "Sexo <br>";
				estatus = false;
			}
			if (!validarString(datosPersona.getPaisNacimiento())) {
				mensajes = mensajes + "Pais de Nacimiento <br>";
				estatus = false;
			}
			if (!validarString(datosPersona.getEntidadLugarNacimiento())) {
				mensajes = mensajes + "Entidad de Nacimiento <br>";
				estatus = false;
			}
			if (!validarString(datosPersona.getNacionalidad())) {
				mensajes = mensajes + "Nacionalidad <br>";
				estatus = false;
			}
			if (!validarString(datosPersona.getEstadoCivil())) {
				mensajes = mensajes + "Estado Civil <br>";
				estatus = false;
				estatusEdoCivil = false;
			}
			if (!validarString(datosPersona.getOcupacion())) {
				mensajes = mensajes + "Ocupacion <br>";
				estatus = false;
			}
			if (!validarString(datosPersona.getPosicionHogar())) {
				mensajes = mensajes + "Posicion en el Hogar <br>";
				estatus = false;
			}
			if (!validarEntero(datosPersona.getNumeroDependientes())) {
				mensajes = mensajes + "Numero de Dependientes <br>";
				estatus = false;
			}

			if (!validarString(datosPersona.getExperienciaCreditoGrupal())) {
				mensajes = mensajes + "Experiencia Credito Grupal <br>";
				estatus = false;
			}
			if (!validarString(datosPersona.getFuncionarioPublico())) {
				mensajes = mensajes + "Funcionario Publico <br>";
				estatus = false;
			}
			if (!validarString(datosPersona.getRelacionFuncionarioPublico())) {
				mensajes = mensajes + "Relacion Funcionario Publico <br>";
				estatus = false;
			}

			//Seccion de negocios
			if (!validarString(datosPersona.getIniciaNegocio())) {
				mensajes = mensajes + "Inicia Negocio <br>";
				estatus = false;
			}
			if (!validarString(datosPersona.getTipoActividad())) {
				mensajes = mensajes + "Tipo de Actividad <br>";
				estatus = false;
			}
			if (!validarString(datosPersona.getTipoEstablecimiento())) {
				mensajes = mensajes + "Tipo de Establecimiento <br>";
				estatus = false;
			}
			if (!validarString(datosPersona.getActividadEmpresarial())) {
				mensajes = mensajes + "Actividad Empresarial <br>";
				estatus = false;
			}
			if (!validarEntero(datosPersona.getNumEmpleados())) {
				mensajes = mensajes + "Numero de Empleados <br>";
				estatus = false;
			}
			if (!validarEntero(datosPersona.getExpRubro())) {
				mensajes = mensajes + "Experiencia en el Rubro <br>";
				estatus = false;
			}
			if (!validarEntero(datosPersona.getExpNegocio())) {
				mensajes = mensajes + "Experiencia en el Negocio <br>";
				estatus = false;
			}
			if (!validarDoble(datosPersona.getMontoVentas())) {
				mensajes = mensajes + "Monto Ventas <br>";
				estatus = false;
			}
			if (!validarDoble(datosPersona.getGananciaNeta())) {
				mensajes = mensajes + "Ganancia Neta <br>";
				estatus = false;
			}
			if (!validarDoble(datosPersona.getOtrosIngresos())) {
				mensajes = mensajes + "Otros Ingresos <br>";
				estatus = false;
			}
			if (!validarDoble(datosPersona.getGananciaActSec())) {
				mensajes = mensajes + "Ganancia Actividad Secundaria <br>";
				estatus = false;
			}
			if (!validarDoble(datosPersona.getGastosFamiliares())) {
				mensajes = mensajes + "Gastos Familiares <br>";
				estatus = false;
			}
			if (!validarString(datosPersona.getTipoVivienda())) {
				mensajes = mensajes + "Tipo de Vivienda <br>";
				estatus = false;
			}

		//Validar p.edo_civil
			if (estatusEdoCivil) {
			  if (datosPersona.getEstadoCivil().equals("C") || datosPersona.getEstadoCivil().equals("U")) {
				if (!validarString(datosPersona.getNombreConyuge()) || !validarString(datosPersona.getApPatConyuge())) {
					throw new Exception("El cliente no tiene un conyuge capturado ");
				}
			  }
			}

		//Validar domicilio Persona
			//parametros de consulta
			final java.util.HashMap<String, Object> parametrosDomicilio = new HashMap<String, Object>();
			parametrosDomicilio.put( "tipo_domicilio" , "DIRE");
			parametrosDomicilio.put( "persona" , peticion.getNumeroPersona());

			//Se obtiene la consulta consultaDomicilio
			LogHandler.info(uid, getClass(), "==> validarDatosPersonaTarea - consultaDomicilio");
			LogHandler.trace(uid, getClass(), "==> validarDatosPersonaTarea - consultaDomicilio");

			DomicilioOV domicilioPersona	= (DomicilioOV) sesion.selectOne("consultaDomicilio", parametrosDomicilio);

			if (domicilioPersona == null) {
				throw new Exception(mensajes + "El cliente no tiene una direccion capturada ");
			}

		//Validaciones de domicilioPersona
			if (!validarString(domicilioPersona.getCalle())) {
				mensajes = mensajes + "Direccion Calle <br>";
				estatus = false;
			}
			if (!validarString(domicilioPersona.getNumeroExterior())) {
				mensajes = mensajes + "Direccion Numero Exterior <br>";
				estatus = false;
			}
			if (!validarString(domicilioPersona.getCp())) {
				mensajes = mensajes + "Direccion cp <br>";
				estatus = false;
			}
			if (!validarString(domicilioPersona.getColonia())) {
				mensajes = mensajes + "Direccion Colonia <br>";
				estatus = false;
			}
			if (!validarFecha(domicilioPersona.getFechaDomicilio())) {
				mensajes = mensajes + "Direccion Tiempo de Habitar Domicilio <br>";
				estatus = false;
			}
			if (!validarString(domicilioPersona.getDiasLocaliza())) {
				mensajes = mensajes + "Direccion Dias de Localizacion <br>";
				estatus = false;
			}
			if (!validarString(domicilioPersona.getHoraLocalizaInicial())) {
				mensajes = mensajes + "Direccion Horario de Localizacion <br>";
				estatus = false;
			}
			if (!validarString(domicilioPersona.getEntreCalles())) {
				mensajes = mensajes + "Direccion Entre las Calles <br>";
				estatus = false;
			}


			//Validar Telefono
			LogHandler.info(uid, getClass(), "==> validarDatosPersonaTarea - validarTelefonoPersona");
			LogHandler.trace(uid, getClass(), "==> validarDatosPersonaTarea - validarTelefonoPersona");

			Integer existeTelefono = (Integer) sesion.selectOne("validarTelefonoPersona", peticion.getNumeroPersona());

			if (existeTelefono == null || existeTelefono == 0) {
				throw new Exception(mensajes + "El cliente no tiene un telefono capturado ");
			}


			//Validar idRelaciones
			LogHandler.info(uid, getClass(), "==> validarDatosPersonaTarea - obtenerIdRelacionValidarPersona");
			LogHandler.trace(uid, getClass(), "==> validarDatosPersonaTarea - obtenerIdRelacionValidarPersona");

			@SuppressWarnings("unchecked")
			List<ValidaIdReferenciasOV> idReferenciasPersona = (List<ValidaIdReferenciasOV>)
				sesion.selectList("obtenerIdRelacionValidarPersona", peticion.getNumeroPersona());

			if (idReferenciasPersona == null || idReferenciasPersona.size() == 0) {
				throw new Exception("El cliente no cuenta con 2 referencias capturadas");
			} else {
				Integer countReferencias = 0;
				for (int i = 0; i < idReferenciasPersona.size(); i++) {
				countReferencias = countReferencias + idReferenciasPersona.get(i).getCountIdRelacion();
				LogHandler.info(uid, getClass(), "==> countReferencias" + countReferencias);
				}
				if (countReferencias < 2) {
					throw new Exception("El cliente no cuenta con 2 referencias capturadas");
				}


				//Validar nombres, telefonos y domicilios de referencias
				List<RelacionPersonaOV> listaRelacionPersonaOV = new ArrayList<RelacionPersonaOV>();
				int countReferenciasAprobadas = 0;
				for (int i = 0; i < idReferenciasPersona.size(); i++) {
					Boolean estatusRef = true;

					//parametros de consulta
					final java.util.HashMap<String, Object> parametrosReferencia = new HashMap<String, Object>();

					parametrosReferencia.put( "idRelacion" , idReferenciasPersona.get(i).getIdRelacion());
					parametrosReferencia.put( "persona" , peticion.getNumeroPersona());

					//Se obtiene la consulta para Relaciones
					LogHandler.info(uid, getClass(), "==> validarDatosPersonaTarea - obtenerDatosRelacionValidarPersona");
					LogHandler.trace(uid, getClass(), "==> validarDatosPersonaTarea - obtenerDatosRelacionValidarPersona");

					RelacionPersonaOV personasRelaciones = (RelacionPersonaOV)
							sesion.selectOne("obtenerDatosRelacionValidarPersona", parametrosReferencia);

					if (personasRelaciones == null) {
						mensajes = mensajes + "No existe informacion de la referencia <br>";
						estatusRef = false;
					} else {
						//VALIDAMOS INFORMACION DE REFERENCIAS
							if (!validarString(personasRelaciones.getNombre())) {
								mensajes = mensajes + "Referencia Nombre <br>";
								estatusRef = false;
							}
							if (!validarString(personasRelaciones.getApellidoPaterno())) {
								mensajes = mensajes + "Referencia ApellidoPaterno <br>";
								estatusRef = false;
							}
							if (!validarString(personasRelaciones.getClaveParentesco())) {
								mensajes = mensajes + "Referencia ClaveParentesco <br>";
								estatusRef = false;
							}
							listaRelacionPersonaOV.add(personasRelaciones);

						//Validar Domicilios
							LogHandler.info(uid, getClass(), "==> validarDatosPersonaTarea - validarDomicilioRelacionPersona");
							LogHandler.trace(uid, getClass(), "==> validarDatosPersonaTarea - validarDomicilioRelacionPersona");

							Integer existeDomicilioReferencia = (Integer)
									sesion.selectOne("validarDomicilioRelacionPersona", parametrosReferencia);

							if (existeDomicilioReferencia == null || existeDomicilioReferencia == 0) {
								mensajes = mensajes + "La referencia no cuenta con una direccion capturada "
										+ personasRelaciones.getNombre() +	" "
										+ personasRelaciones.getApellidoPaterno()  + "<br>";
								estatusRef = false;
							} else {

							//Se obtiene la consulta domicilios
							LogHandler.info(uid, getClass(), "==> validarDatosPersonaTarea - obtenerDomicilioReferenciaPersona");
							LogHandler.trace(uid, getClass(), "==> validarDatosPersonaTarea - obtenerDomicilioReferenciaPersona");

								DomicilioOV domicilioReferencia	=
										(DomicilioOV) sesion.selectOne("obtenerDomicilioReferenciaPersona", parametrosReferencia);

									if (domicilioReferencia == null) {
										mensajes = mensajes + "La referencia no cuenta con una direccion capturada "
												+ personasRelaciones.getNombre() +	" "
												+ personasRelaciones.getApellidoPaterno() + "<br>";
										estatusRef = false;
									} else {
										//validamos nuestros datos requeridos
										if (!validarString(domicilioReferencia.getCalle())) {
											mensajes = mensajes + "Direccion Referencia Calle <br>";
											estatusRef = false;
										}
										if (!validarString(domicilioReferencia.getNumeroExterior())) {
											mensajes = mensajes + "Direccion Referencia Numero Exterior <br>";
											estatusRef = false;
										}
										if (!validarString(domicilioReferencia.getCp())) {
											mensajes = mensajes + "Direccion Referencia Cp <br>";
											estatusRef = false;
										}
										if (!validarString(domicilioReferencia.getColonia())) {
											mensajes = mensajes + "Direccion Referencia Colonia <br>";
											estatusRef = false;
										}
										if (!validarString(domicilioReferencia.getDiasLocaliza())) {
											mensajes = mensajes + "Direccion Referencia Dias de Localizacion <br>";
											estatusRef = false;
										}
										if (!validarString(domicilioReferencia.getHoraLocalizaInicial())) {
											mensajes = mensajes + "Direccion Referencia Horario de Localizacion <br>";
											estatusRef = false;
										}

									}

							//Validar Telefono
							LogHandler.info(uid, getClass(), "==> validarDatosPersonaTarea - validarTelefonoRelacionPersona");
							LogHandler.trace(uid, getClass(), "==> validarDatosPersonaTarea - validarTelefonoRelacionPersona");

									Integer existeTelefonoReferencia = (Integer)
											sesion.selectOne("validarTelefonoRelacionPersona", parametrosReferencia);

									if (existeTelefonoReferencia == null || existeTelefonoReferencia == 0) {
										mensajes = mensajes + "La referencia del cliente no cuenta con telefono capturado "
												+ personasRelaciones.getNombre() +	" "
												+ personasRelaciones.getApellidoPaterno() + "<br>";
										estatusRef = false;
									}
						} //fin else 2

					} //fin else 1

					if (estatusRef) {
					countReferenciasAprobadas = countReferenciasAprobadas + 1;
					}

				} //FIN FOR

				//Se valida que sean por lo menos 2 referencias aprobadas
				LogHandler.info(uid, getClass(), "==> countReferenciasAprobadas: " + countReferenciasAprobadas);
				if (countReferenciasAprobadas < 2) {
					throw new Exception("El cliente no cuenta con el minimo de 2 referencias capturadas correctamente");
				}

//				respuesta.setRelacionesPersona(listaRelacionPersonaOV);
			} //FIN ELSE

	//Validar Domicilio Negocio
		//parametros de consulta
			final java.util.HashMap<String, Object> parametrosDomicilioNegocio = new HashMap<String, Object>();
			parametrosDomicilioNegocio.put( "tipo_domicilio" , "EMPL");
			parametrosDomicilioNegocio.put( "persona" , peticion.getNumeroPersona());

			LogHandler.info(uid, getClass(), "==> validarDatosPersonaTarea - validarDomicilioNegocioPersona");
			LogHandler.trace(uid, getClass(), "==> validarDatosPersonaTarea - validarDomicilioNegocioPersona");

			Integer existeDomicilioNegocio = (Integer)
					sesion.selectOne("validarDomicilioNegocioPersona", parametrosDomicilioNegocio);

			if (existeDomicilioNegocio > 0) {
				//Se obtiene la consulta domicilios
				LogHandler.info(uid, getClass(), "==> validarDatosPersonaTarea - consultaDomicilio");
				LogHandler.trace(uid, getClass(), "==> validarDatosPersonaTarea - consultaDomicilio");

				DomicilioOV domicilioNegocioPersona	=
						(DomicilioOV) sesion.selectOne("consultaDomicilio", parametrosDomicilioNegocio);

				if (domicilioNegocioPersona == null) {
					throw new Exception("El cliente no cuenta con una direccion de empleo capturada ");
				}

			//validamos nuestros datos requeridos
				if (!validarString(domicilioNegocioPersona.getCalle())) {
					mensajes = mensajes + "Direccion Empleo Calle <br>";
					estatus = false;
				}
				if (!validarString(domicilioNegocioPersona.getNumeroExterior())) {
					mensajes = mensajes + "Direccion Empleo Numero Exterior <br>";
					estatus = false;
				}
				if (!validarString(domicilioNegocioPersona.getCp())) {
					mensajes = mensajes + "Direccion Empleo Cp <br>";
					estatus = false;
				}
				if (!validarString(domicilioNegocioPersona.getColonia())) {
					mensajes = mensajes + "Direccion Empleo Colonia <br>";
					estatus = false;
				}
			}

			if (!estatus) {
				respuesta.getHeader().setMensaje(mensajes);
				respuesta.getHeader().setEstatus(estatus);
			} else {
				respuesta.getHeader().setEstatus(estatus);
			}

		} catch (Exception exception ) {
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(mensajes + exception.getMessage());
			respuesta.getHeader().setEstatus(false);
			LogHandler.error( uid, this.getClass(), "Error en validarDatosPersonaTarea : "
					+ exception.getMessage(), exception );
		}
		finally {
			FabricaConexiones.close(sesion);
		}

		return respuesta;
	}


	/**
	 * Validar fecha.
	 *
	 * @param valor the valor
	 * @return true, if successful
	 */
	private boolean validarFecha(Date valor) {
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
	private boolean validarEntero(Integer valor) {
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
	 * Limpia objeto.
	 *
	 * @param obj :
	 * @return Object
	 */
	private  Object limpiaObjeto( Object obj) {

		for ( Method method : obj.getClass().getMethods() ) {
			if ( method.getName().startsWith( "get" ) ) {

					try {
							if (method.getGenericReturnType() ==  String.class ) {
								if (method.invoke(obj) == null || method.invoke(obj).toString().isEmpty()) {

									final java.lang.reflect.Method
									methodSet = obj.getClass().getMethod( "set"
									+ method.getName().replace( "get" , "").toUpperCase().charAt( 0 )
									+ method.getName().replace( "get" , "").substring( 1 ), String.class );
									methodSet.invoke( obj, new Object[] {""});
								}
							}

							if (method.getGenericReturnType() ==  Boolean.class ) {
								if (method.invoke(obj) == null ) {

									final java.lang.reflect.Method
									methodSet = obj.getClass().getMethod( "set"
									+ method.getName().replace( "get" , "").toUpperCase().charAt( 0 )
									+ method.getName().replace( "get" , "").substring( 1 ), Boolean.class );
									methodSet.invoke( obj, new Object[] {false});
								}

							}

							if (method.getGenericReturnType() ==  Integer.class ) {

								if (method.invoke(obj) == null || method.invoke(obj).toString().isEmpty()) {

									final java.lang.reflect.Method
									methodSet = obj.getClass().getMethod( "set"
									+ method.getName().replace( "get" , "").toUpperCase().charAt( 0 )
									+ method.getName().replace( "get" , "").substring( 1 ), Integer.class );

									methodSet.invoke( obj, new Object[] {0});
								}
							}
						}
						catch ( java.lang.Exception exception ) {
							exception.printStackTrace();
						}
			}
		}
		return obj;

	}


	/**
	 * The main method.
	 *
	 * @param args :
	 */
	public static void main( String ... args ) {
		final PersonaOV
				personaOV = new PersonaOV();
				personaOV.setNombre( "mario" );
				personaOV.setRfc( "rfc" );
				personaOV.setExperienciaCreditoGrupal(true);

		for ( Method method : personaOV.getClass().getMethods() ) {
			if ( method.getName().startsWith( "get" ) ) {

				try {
				if (method.getGenericReturnType() ==  String.class ) {

					if (method.invoke(personaOV) == null || method.invoke(personaOV).toString().isEmpty()) {

						final java.lang.reflect.Method
						methodSet = personaOV.getClass().getMethod( "set"
									+ method.getName().replace( "get" , "").toUpperCase().charAt( 0 )
									+ method.getName().replace( "get" , "").substring( 1 ), String.class );


						Object result = methodSet.invoke( personaOV, new Object[] {""});

					}

				}

				if (method.getGenericReturnType() ==  Boolean.class ) {

					if (method.invoke(personaOV) == null ) {

						final java.lang.reflect.Method
						methodSet = personaOV.getClass().getMethod( "set"
									+ method.getName().replace( "get" , "").toUpperCase().charAt( 0 )
									+ method.getName().replace( "get" , "").substring( 1 ), Boolean.class );


						Object result = methodSet.invoke( personaOV, new Object[] {false});

					}

				}

				}
				catch ( java.lang.Exception exception ) {
					exception.printStackTrace();
				}
				}
			}
		}

	/**
	 * Consultar cliente unico.
	 *
	 * @param uid :
	 * @param peticion :
	 * @return ConsultarClienteUnicoRespuesta
	 */
	public ValidarCurpPersonaRespuesta validarCurpPersonaTarea(String uid,	ValidarCurpPersonaPeticion peticion) {
		//Objeto para almacenar la respuesta del m�todo
		final ValidarCurpPersonaRespuesta respuesta = new ValidarCurpPersonaRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		String validaStr = "";
		try {

			String[] datosRequeridos = {"rfc", "curp"};
			validaStr = Validaciones.datosRequeridos(peticion, datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(Constantes.DATOS_REQUERIDOS + validaStr);
			}

			//Se valida longitud del rfc
			if (!Validaciones.rfcValido(peticion.getRfc())) {
				throw new Exception(Constantes.RFC_INVALIDO);
			}

			String rfcTemp =  peticion.getRfc().substring(0, DIEZ);
			String curpTemp = peticion.getCurp().substring(0, DIEZ);
			//Se valida rfc vs curp
			if (!rfcTemp.equals(curpTemp)) {
				throw new Exception(Constantes.RFC_CURP_DISTINTOS );
			}

			//Se valida exp reg del curp
			if (!Validaciones.validarCURP(peticion.getCurp()) ) {
				throw new Exception(Constantes.CURP_INVALIDO);
			}

			if (peticion.getSexo() != null && !peticion.getSexo().equals("")) {
			// SE VALIDA SEXO F O M
				if (!Validaciones.validarSexo(Validaciones.getSexoRenapo(peticion.getSexo()))) {
					throw new Exception(Constantes.CURP_INVALIDO_SEXO);
				}
				// SE VALIDA SEXO EN EL CURP
				if (!peticion.getCurp().substring(DIEZ, ONCE).equals(Validaciones.getSexoRenapo(peticion.getSexo()))) {
					throw new Exception(Constantes.CURP_INVALIDO_SEXO_NO_COINCIDE);
				}
			}

			if (peticion.getEstado() != null && !peticion.getEstado().equals("")) {
				// SE VALIDA ESTADO 32
				if (!Validaciones.validarEstado(Validaciones.getCodigoRenapoEstado(peticion.getEstado()))) {
					throw new Exception(Constantes.CURP_INVALIDO_ESTADO);
				}
				// SE VALIDA ESTADO EN EL CURP
				if (!peticion.getCurp().substring(ONCE, TRECE).equals(Validaciones.getCodigoRenapoEstado(peticion.getEstado()))) {
					throw new Exception(Constantes.CURP_INVALIDO_ESTADO_NO_COINCIDE);
				}
			}
			respuesta.setCurp(peticion.getCurp());

			}
		catch ( java.lang.Exception exception ) {
			LogHandler.error(uid, getClass(), exception.getMessage() , exception );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setMensaje( exception.getMessage() );
			respuesta.getHeader().setUID( uid );
			}
		finally {
			LogHandler.info(uid, getClass(), "validarCurpPersonaTarea." );
			}

		return respuesta;
		}

	/**
	 * Metodo para registrar un permiso temporal para el login
	 * @param uid identificador unico de la transaccion
	 * @param peticion del registro persona
	 * @return XML respuesta
	 */
	public PerfilTemporalRespuesta registrarPermisoTemporalTarea(String uid, PerfilTemporal peticion) {
		PerfilTemporalRespuesta respuesta = new PerfilTemporalRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensaje("El registro del permiso fue exitoso");

		SqlSession 	sessionTx = null;

		try {

			if (peticion == null) {
				throw new Exception("La peticion no puede ser nula.");
			}
			if (peticion.getClaveUsuario() == null || peticion.getClaveUsuario().trim().isEmpty()) {
				throw new Exception("La clave del usuario es obligatoria en la peticion.");
			}
			if (peticion.getIdPerfil() <= 0) {
				throw new Exception("La clave del perfil actual es obligatorio en la peticion.");
			}
			if (peticion.getIdPerfilTemporal() <= 0) {
				throw new Exception("La clave del perfil nuevo es obligatorio en la peticion.");
			}
			if (peticion.getIdSucursal() <= 0) {
				throw new Exception("La clave de la sucursal nueva es obligatoria en la peticion.");
			}
			if (peticion.getUsuario() == null || peticion.getUsuario().trim().isEmpty()) {
				throw new Exception("El usuario de la transaccion es obligatorio en la peticion.");
			}
			if (peticion.getPeriodo() <= 0) {
				throw new Exception("El periodo es obligatorio en la peticion.");
			}
			//Validar que no tenga un permiso activo
			PerfilTemporalRespuesta respuestaConsulta
				= consultarPermisoTemporalTarea(uid, peticion);
			if (!respuestaConsulta.getHeader().isEstatus()) {
				throw new Exception(respuestaConsulta.getHeader().getMensaje());
			}
			if (respuestaConsulta.getPerfilTemporal() != null) {
				throw new Exception("El usuario tiene un permiso temporal vigente.");
			}

			sessionTx = FabricaConexiones.obtenerSesionTx();
			peticion.setEstatus("A");
			sessionTx.delete("borrarPermisoTemporal", peticion);
			sessionTx.insert("registrarPermisoTemporal", peticion);
			sessionTx.insert("registrarPermisoTemporalHis", peticion);

			sessionTx.commit(true);
		}
		catch (Exception exception) {
			FabricaConexiones.rollBack( sessionTx );
			LogHandler.error(uid, getClass(), exception.getMessage() , exception );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setMensaje( exception.getMessage() );
		}
		finally {
			FabricaConexiones.close( sessionTx );
		}
		return respuesta;
	}

	/**
	 * Metodo para consultar un permiso temporal para el login
	 * @param uid identificador unico de la transaccion
	 * @param peticion del registro persona
	 * @return XML respuesta
	 */
	public PerfilTemporalRespuesta consultarPermisoTemporalTarea(String uid, PerfilTemporal peticion) {
		PerfilTemporalRespuesta respuesta = new PerfilTemporalRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensaje("El consulta de los permisos fue exitoso");

		SqlSession 	sessionNTx = null;

		try {

			if (peticion == null) {
				throw new Exception("La peticion no puede ser nula.");
			}
			if (peticion.getClaveUsuario() == null || peticion.getClaveUsuario().trim().isEmpty()) {
				throw new Exception("La clave del usuario es obligatoria en la peticion.");
			}

			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			peticion.setEstatus("A");
			PerfilTemporal perfilTemporal = (PerfilTemporal) sessionNTx.selectOne("consultarPermisoTemporal", peticion);

			respuesta.setPerfilTemporal(perfilTemporal);
		}
		catch (Exception exception) {
			FabricaConexiones.rollBack( sessionNTx );
			LogHandler.error(uid, getClass(), exception.getMessage() , exception );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setMensaje( exception.getMessage() );
		}
		finally {
			FabricaConexiones.close( sessionNTx );
		}
		return respuesta;
	}

	/**
	 * Metodo para dar por concluido un permiso temporal para el login
	 * @param uid identificador unico de la transaccion
	 * @param peticion del registro persona
	 * @return XML respuesta
	 */
	public PerfilTemporalRespuesta terminarPermisoTemporalTarea(String uid, PerfilTemporal peticion) {
		PerfilTemporalRespuesta respuesta = new PerfilTemporalRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensaje("El permiso fue concluido.");

		SqlSession 	sessionTx = null;

		try {

			if (peticion == null) {
				throw new Exception("La peticion no puede ser nula.");
			}
			if (peticion.getClaveUsuario() == null || peticion.getClaveUsuario().trim().isEmpty()) {
				throw new Exception("La clave del usuario es obligatoria en la peticion.");
			}
			if (peticion.getUsuario() == null || peticion.getUsuario().trim().isEmpty()) {
				throw new Exception("El usuario de la transaccion es obligatorio en la peticion.");
			}
			//Validar que no tenga un permiso activo
			PerfilTemporalRespuesta respuestaConsulta
				= consultarPermisoTemporalTarea(uid, peticion);
			if (!respuestaConsulta.getHeader().isEstatus()) {
				throw new Exception(respuestaConsulta.getHeader().getMensaje());
			}
			if (respuestaConsulta.getPerfilTemporal() == null) {
				throw new Exception("El usuario NO tiene un permiso temporal vigente, para dar por concluido.");
			} else {
				sessionTx = FabricaConexiones.obtenerSesionTx();
				peticion.setEstatus("I");
				sessionTx.update("terminarPermisoTemporal", peticion);
				sessionTx.insert("registrarPermisoTemporalHis", peticion);
				sessionTx.commit(true);
			}
		}
		catch (Exception exception) {
			FabricaConexiones.rollBack( sessionTx );
			LogHandler.error(uid, getClass(), exception.getMessage() , exception );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setMensaje( exception.getMessage() );
		}
		finally {
			FabricaConexiones.close( sessionTx );
		}
		return respuesta;
	}


	/**
	 * Metodo para validar la existencia de una persona en la base de datos
	 * @param uid identificador unico de la transaccion
	 * @param peticion de la busqueda de persona
	 * @return respuesta
	 */
	public ValidaExistePersonaRespuesta validaExistePersona(String uid, ValidaExistePersonaPeticion peticion) {
		ValidaExistePersonaRespuesta respuesta = new ValidaExistePersonaRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sessionNTx = null;

		try {

			if (peticion == null) {
				throw new Exception("La peticion no puede ser nula.");
			}
			if (peticion.getNombre() == null || peticion.getNombre().trim().isEmpty()) {
				throw new Exception("El nombre es obligatorio en la peticion.");
			}
			if (peticion.getApellidoPaterno() == null || peticion.getApellidoPaterno().trim().isEmpty()) {
				throw new Exception("El apellido paterno es obligatorio en la peticion.");
			}
//			if (peticion.getApellidoMaterno() == null || peticion.getApellidoMaterno().trim().isEmpty()) {
//				throw new Exception("El apellido materno es obligatorio en la peticion.");
//			}
			if (peticion.getFechaNacimiento() == null || peticion.getFechaNacimiento().trim().isEmpty()) {
				throw new Exception("La fecha de nacimiento es obligatoria en la peticion.");
			}

			if (!(peticion.getFechaNacimiento().indexOf("-", 2) == 2)) {
				throw new Exception("El formato de la fecha no corresponde a dd-mm-yyyy");
			}

			//Se pide una conexion
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			final java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();

			parametros.put("nombre" , peticion.getNombre());
			parametros.put("apellidoPaterno" , peticion.getApellidoPaterno());
			if ( peticion.getApellidoMaterno() != null) {
				parametros.put("apellidoMaterno" , peticion.getApellidoMaterno());
			}
			parametros.put("fechaNacimiento" , peticion.getFechaNacimiento());

			@SuppressWarnings("unchecked")
			List<PersonaOV> datosPersona = sessionNTx.selectList("validaExistePersona", parametros);

			if (datosPersona == null) {
				throw new Exception("El resultado de la consulta es nulo");
			}

			if (datosPersona.size() > 0) {
				respuesta.setNumeroPersona(datosPersona.get(0).getNumeroPersona());

				throw new Exception("La persona ya existe en la base de datos.");
			}

			respuesta.getHeader().setMensaje("El numero de persona es valido.");

		}
		catch (Exception e) {
			LogHandler.error(uid, getClass(), "Error en validaExistePersona: " + e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje("Error en validaExistePersona: " + e.getMessage());
		}
		finally {
			FabricaConexiones.close( sessionNTx );
		}
		return respuesta;
	}

	/**
	 * Consultar la informacion de solicitante para varias personas.
	 *
	 * @param uid :
	 * @param personas :
	 * @return consultarInformacionSolicitante
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ConsultarPersonaRespuestaOV consultarInformacionSolicitante(java.lang.String uid, ContratoRenovacionPeticion peticion) {
		ConsultarPersonaRespuestaOV respuesta = new ConsultarPersonaRespuestaOV();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus( true );
		respuesta.getHeader().setUID( uid );
		SqlSession sessionNTx = null;
		final java.util.ArrayList<PersonaSimplificacionOV> lista = new java.util.ArrayList();
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		try {

			if (peticion.getArrayPersonas().length == 0) {
				throw new Exception("La petición debe traer al menos un elemento.");
			}

			for (String pesona : peticion.getArrayPersonas()) {

				if (pesona == null
					|| pesona.trim().length() != LONG_PERSONA) {
					throw new Exception( "Uno de los elementos de la peticion es erroneo." );
				}
			}

			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			for (String persona : peticion.getArrayPersonas()) {
				final HashMap<String, Object> parametros = new HashMap<String, Object>();
				parametros.put("persona", persona);

				LogHandler.trace(uid, getClass(), "==> consultarDatosPersona - consultarDatosPersona" );
				PersonaSimplificacionOV personaConsulta
					= (PersonaSimplificacionOV) sessionNTx.selectOne( "consultarDatosPersonaSimplificacion", parametros );

				if (personaConsulta == null) {
					throw new Exception( "No existe informacion para la persona " + persona );
				}
				
				if (peticion.getNombreAsesor() == null || peticion.getNombreAsesor().equals("")
						|| peticion.getNombreAsesor().equals("SIN ASESOR")) {
        			LogHandler.info(uid, this.getClass(), "NombreAsesor vacio o nulo.");
        			personaConsulta.setNombreAsesor("");
        		} else {
        			LogHandler.info(uid, this.getClass(), "Se cambia NombreAsesor: "
        					+ peticion.getNombreAsesor());
        			personaConsulta.setNombreAsesor(peticion.getNombreAsesor());
        		}
				
				if (peticion.getNombreGerenteSucursal() == null || peticion.getNombreGerenteSucursal().equals("")
						|| peticion.getNombreGerenteSucursal().equals("SIN GERENTE SUCURSAL")) {
        			LogHandler.info(uid, this.getClass(), "NombreGerenteSucursal vacio o nulo.");
        			personaConsulta.setNombreGerenteSucursal("");
        		} else {
        			LogHandler.info(uid, this.getClass(), "Se cambia NombreGerenteSucursal: "
        					+ peticion.getNombreGerenteSucursal());
        			personaConsulta.setNombreGerenteSucursal(peticion.getNombreGerenteSucursal());
        		}
				
				personaConsulta.setNumeroPersona(persona);
				//personaConsulta.setMontoSolicitado(100.00);
				personaConsulta.setEntidadLugarNacimiento(personaConsulta.getEntidadLugarNacimiento() != null
						? personaConsulta.getEntidadLugarNacimiento().trim() : "");

				HashMap<String, Object> datosExtraPersona = new HashMap<String, Object>();
				LogHandler.trace(uid, getClass(), "==> consultarDatosPersona - consultarDatosExtraPersona" );
				datosExtraPersona = (HashMap<String, Object>)
						sessionNTx.selectOne( "consultarDatosExtraPersonaSimplificacion", parametros );

				personaConsulta.setEmail(datosExtraPersona.get("correo") != null
						? datosExtraPersona.get("correo").toString() : " ");

				//Persona.DomicilioOV
				//Se obtiene informacion persona.domicilio
				parametros.clear();
				parametros.put("persona", persona);
				parametros.put("tipo_domicilio", TIPO_DIRECTO);

				//Se busca en persona_domicilios
				LogHandler.trace(uid, getClass(), "==> consultarDatosPersona - consultaDomicilio" );
				DomicilioOV domicilioPersonaTabla
					= (DomicilioOV) sessionNTx.selectOne( "consultaDomicilioSimplificacion", parametros );

				if (domicilioPersonaTabla == null) {
					DomicilioOV domicilioPersona = new DomicilioOV();
					domicilioPersona.setTipoDomicilio( TIPO_DIRECTO);
					domicilioPersona.setPais(datosExtraPersona.get("pais") != null
							? datosExtraPersona.get("pais").toString() : "");
					domicilioPersona.setCodigoEstado(datosExtraPersona.get("entidad") != null
							? datosExtraPersona.get("entidad").toString() : "");
					domicilioPersona.setMunicipio(datosExtraPersona.get("municipio") != null
							? datosExtraPersona.get("municipio").toString() : "");
					domicilioPersona.setCiudad(datosExtraPersona.get("ciudad") != null
							? datosExtraPersona.get("ciudad").toString() : "");
					domicilioPersona.setColonia(datosExtraPersona.get("colonia") != null
							? datosExtraPersona.get("colonia").toString() : "");
					domicilioPersona.setCp(datosExtraPersona.get("cp") != null ? datosExtraPersona.get("cp").toString() : "");
					domicilioPersona.setCalle(datosExtraPersona.get("calle") != null
							? datosExtraPersona.get("calle").toString() : "");
					domicilioPersona.setEntreCalles(datosExtraPersona.get("entre_calles") != null
							? datosExtraPersona.get("entre_calles").toString() : "");
					domicilioPersona.setOtrasIndicaciones(datosExtraPersona.get("otras_indicaciones") != null
							? datosExtraPersona.get("otras_indicaciones").toString() : "");
					domicilioPersona.setFechaDomicilio(datosExtraPersona.get("fecha_domicilio") != null
							? formatoDelTexto.parse(datosExtraPersona.get("fecha_domicilio").toString()) : null);
					domicilioPersona.setDiasLocaliza(datosExtraPersona.get("dias_emp") != null
							? datosExtraPersona.get("dias_emp").toString() : "");
					String horarioLocalizacion = datosExtraPersona.get("horario_loc_dom") != null
							? datosExtraPersona.get("horario_loc_dom").toString() : "";

					if (horarioLocalizacion.indexOf("-") > -1) {
						domicilioPersona.setHoraLocalizaInicial(horarioLocalizacion.split("-")[0]);
						domicilioPersona.setHoraLocalizaFinal(horarioLocalizacion.split("-")[1]);
					}
					else {
						domicilioPersona.setHoraLocalizaInicial("");
						domicilioPersona.setHoraLocalizaFinal("");
					}

					domicilioPersona.setTipoVivienda(datosExtraPersona.get("tipo_vivienda") != null
							? datosExtraPersona.get("tipo_vivienda").toString() : "");
					domicilioPersona.setFechaUltimaModificacion(datosExtraPersona.get("fecha_ult_mod_dom") != null
							? formatoDelTexto.parse(datosExtraPersona.get("fecha_ult_mod_dom").toString()) : null);

					personaConsulta.setDomicilioPersona(domicilioPersona);
				} else {
					String horarioLocalizacion = domicilioPersonaTabla.getHoraLocalizaInicial() != null
							? domicilioPersonaTabla.getHoraLocalizaInicial() : "";
					if (horarioLocalizacion.indexOf("-") > -1) {
						domicilioPersonaTabla.setHoraLocalizaInicial(horarioLocalizacion.split("-")[0]);
						domicilioPersonaTabla.setHoraLocalizaFinal(horarioLocalizacion.split("-")[1]);
					}
					else {
						domicilioPersonaTabla.setHoraLocalizaInicial("");
						domicilioPersonaTabla.setHoraLocalizaFinal("");
					}
					personaConsulta.setDomicilioPersona(domicilioPersonaTabla);
				}


			//DetalleSocioeconomicoOV
			DetalleSocioeconomicoOV detalle = new DetalleSocioeconomicoOV();
			detalle.setMontoSemanaPago(datosExtraPersona.get("ingreso_cp") != null
					? Double.parseDouble(datosExtraPersona.get("ingreso_cp").toString()) : 0.0);
			detalle.setIniciaNegocio(datosExtraPersona.get("inicia_negocio") != null
					? (datosExtraPersona.get("inicia_negocio").toString().equals("S") ? true : false ) : false);
			detalle.setNombreNegocio(datosExtraPersona.get("nombre_emp") != null
					? datosExtraPersona.get("nombre_emp").toString() : "");
			detalle.setTipoActividad(datosExtraPersona.get("tipo_actividad") != null
					? datosExtraPersona.get("tipo_actividad").toString() : "");
			detalle.setTipoNegocio(datosExtraPersona.get("tipo_establecimiento") != null
					? datosExtraPersona.get("tipo_establecimiento").toString() : "");
			detalle.setGiroNegocio(datosExtraPersona.get("actividad_emp") != null
					? datosExtraPersona.get("actividad_emp").toString() : "");
			detalle.setNumeroEmpleados(datosExtraPersona.get("num_empleados") != null
					? Integer.parseInt(datosExtraPersona.get("num_empleados").toString()) : 0);
			detalle.setExperienciaRubro(datosExtraPersona.get("exp_rubro") != null
					? Integer.parseInt(datosExtraPersona.get("exp_rubro").toString()) : 0);
			detalle.setExperienciaNegocio(datosExtraPersona.get("exp_negocio") != null
					? Integer.parseInt(datosExtraPersona.get("exp_negocio").toString()) : 0);
			detalle.setIngresos(datosExtraPersona.get("monto_ventas") != null
					? Double.parseDouble(datosExtraPersona.get("monto_ventas").toString()) : 0.0);
			detalle.setGananciaNeta(datosExtraPersona.get("ganancia_neta") != null
					? Double.parseDouble(datosExtraPersona.get("ganancia_neta").toString()) : 0.0);
			detalle.setOtrosIngresos(datosExtraPersona.get("otros_ingresos") != null
					? Double.parseDouble(datosExtraPersona.get("otros_ingresos").toString()) : 0.0);
			detalle.setGananciaActSec(datosExtraPersona.get("ganancia_act_sec") != null
					? Double.parseDouble(datosExtraPersona.get("ganancia_act_sec").toString()) : 0.0);
			detalle.setGastosFamiliares(datosExtraPersona.get("gastos_familiares") != null
					? Double.parseDouble(datosExtraPersona.get("gastos_familiares").toString()) : 0.0);
			detalle.setMontoSuperavit(datosExtraPersona.get("monto_superavit") != null
					? Double.parseDouble(datosExtraPersona.get("monto_superavit").toString()) : 0.0);
			detalle.setMontoInventario(datosExtraPersona.get("monto_inventario") != null
					? Double.parseDouble(datosExtraPersona.get("monto_inventario").toString()) : 0.0);
			detalle.setMontoMobiliarioEquipo(datosExtraPersona.get("monto_mobiliario_equipo") != null
					? Double.parseDouble(datosExtraPersona.get("monto_mobiliario_equipo").toString()) : 0.0);

			personaConsulta.setDetalleSocioeconomico(detalle);

			//Se obtiene informacion persona.domicilio
			parametros.clear();
			parametros.put("persona", persona);
			parametros.put("tipo_domicilio", TIPO_EMPLEO);

			//Se busca en persona_domicilios
			LogHandler.trace(uid, getClass(), "==> consultarDatosPersona - consultaDomicilio" );
			DomicilioOV domicilioEmpleoTabla
				= (DomicilioOV) sessionNTx.selectOne( "consultaDomicilioSimplificacion", parametros );

			if (domicilioEmpleoTabla == null) {

				DomicilioOV domicilioNegocio = new DomicilioOV();
				domicilioNegocio.setTipoDomicilio(TIPO_EMPLEO);
				domicilioNegocio.setStatus("A");
				domicilioNegocio.setPais("MX");
				domicilioNegocio.setCodigoEstado(datosExtraPersona.get("entidad_emp") != null
						? datosExtraPersona.get("entidad_emp").toString() : "");
				domicilioNegocio.setMunicipio(datosExtraPersona.get("municipio_emp") != null
						? datosExtraPersona.get("municipio_emp").toString() : "");
				domicilioNegocio.setCiudad(datosExtraPersona.get("ciudad_emp") != null
						? datosExtraPersona.get("ciudad_emp").toString() : "");
				domicilioNegocio.setColonia(datosExtraPersona.get("colonia_emp") != null
						? datosExtraPersona.get("colonia_emp").toString() : "");
				domicilioNegocio.setCp(datosExtraPersona.get("cp_emp") != null ? datosExtraPersona.get("cp_emp").toString() : "");
				domicilioNegocio.setCalle(datosExtraPersona.get("calle_emp") != null
						? datosExtraPersona.get("calle_emp").toString() : "");
				domicilioNegocio.setEntreCalles(datosExtraPersona.get("entre_calles") != null
						? datosExtraPersona.get("entre_calles").toString() : "");
				personaConsulta.setDomicilioNegocio(domicilioNegocio);
			} else {
				personaConsulta.setDomicilioNegocio(domicilioEmpleoTabla);
			}

			HashMap<String, Object> telefono = new HashMap<String, Object>();
			parametros.clear();
			parametros.put("persona", persona);
			parametros.put("tipo_telefono", TIPO_DIRECTO);
			LogHandler.trace(uid, getClass(), "==> consultarDatosPersona - consultarTelefonosPersona" );
			telefono = (HashMap<String, Object>)
					sessionNTx.selectOne( "consultarTelefonosPersonaSimplificacion", parametros );

			if (telefono != null) {
				personaConsulta.setTelefonoFijo(telefono.get("telefono") != null
						? telefono.get("telefono").toString() : " ");
			}  else {
				personaConsulta.setTelefonoFijo(" ");
			}

			parametros.clear();
			parametros.put("persona", persona);
			parametros.put("tipo_telefono", TIPO_CELULAR);
			LogHandler.trace(uid, getClass(), "==> consultarDatosPersona - consultarTelefonosPersona" );
			telefono = (HashMap<String, Object>)
					sessionNTx.selectOne( "consultarTelefonosPersonaSimplificacion", parametros );

			if (telefono != null) {
				personaConsulta.setTelefonoCelular(telefono.get("telefono") != null
						? telefono.get("telefono").toString() : " ");
			}  else {
				personaConsulta.setTelefonoCelular(" ");
			}

			parametros.clear();
			parametros.put("persona", persona);
			parametros.put("tipo_telefono", TIPO_EMPLEO);
			LogHandler.trace(uid, getClass(), "==> consultarDatosPersona - consultarTelefonosPersona" );
			telefono = (HashMap<String, Object>)
					sessionNTx.selectOne( "consultarTelefonosPersonaSimplificacion", parametros );

			if (telefono != null) {
				personaConsulta.setTelefonoEmpleo(telefono.get("telefono") != null
						? telefono.get("telefono").toString() : " ");
			} else {
				personaConsulta.setTelefonoEmpleo(" ");
			}

			parametros.clear();
			parametros.put("persona", persona);
			parametros.put("tipo_telefono", TIPO_RECADO);
			LogHandler.trace(uid, getClass(), "==> consultarDatosPersona - consultarTelefonosPersona" );
			telefono = (HashMap<String, Object>)
					sessionNTx.selectOne( "consultarTelefonosPersonaSimplificacion", parametros );

			if (telefono != null) {
				personaConsulta.setTelefonoRecados(telefono.get("telefono") != null
						? telefono.get("telefono").toString() : " ");
				personaConsulta.setNombreRecadero(telefono.get("nombreCompleto") != null
						? telefono.get("nombreCompleto").toString() : " ");
			} else {
				personaConsulta.setTelefonoRecados(" ");
				personaConsulta.setNombreRecadero(" ");
			}

			HashMap<String, Object> conyuge = new HashMap<String, Object>();
			parametros.clear();
			parametros.put("persona", persona);
			parametros.put("directo", TIPO_CONYUGE_DIRECTO);
			parametros.put("celular", TIPO_CONYUGE_CELULAR);
			parametros.put("relacion", RELACION_CONYUGE);

			LogHandler.trace(uid, getClass(), "==> consultarDatosPersona - consultarInfoConyugeSimplificacion" );
			conyuge = (HashMap<String, Object>)
					sessionNTx.selectOne( "consultarInfoConyugeSimplificacion", parametros );

			if (conyuge != null) {
				personaConsulta.setNombrePareja(conyuge.get("nombre") != null
						? conyuge.get("nombre").toString() : " ");
				personaConsulta.setApellidoPaternoPareja(conyuge.get("apellido_pat") != null
						? conyuge.get("apellido_pat").toString() : " ");
				personaConsulta.setApellidoMaternoPareja(conyuge.get("apellido_mat") != null
						? conyuge.get("apellido_mat").toString() : " ");
				personaConsulta.setTelefonoCelularPareja(conyuge.get("telefono_celu") != null
						? conyuge.get("telefono_celu").toString() : " ");
				personaConsulta.setTelefonoTrabajoPareja(conyuge.get("telefono_dire") != null
						? conyuge.get("telefono_dire").toString() : " ");
				personaConsulta.setLugarTrabajoPareja(datosExtraPersona.get("direccion_ocupacion_pareja") != null
						? datosExtraPersona.get("direccion_ocupacion_pareja").toString() : " ");
			} else {
				personaConsulta.setNombrePareja(" ");
				personaConsulta.setApellidoPaternoPareja(" ");
				personaConsulta.setApellidoMaternoPareja(" ");
				personaConsulta.setTelefonoCelularPareja(" ");
				personaConsulta.setTelefonoTrabajoPareja(" ");
				personaConsulta.setLugarTrabajoPareja(" ");
			}

			//REFRENCIAS
			List<ReferenciaOV> referencias = new java.util.ArrayList();
			parametros.clear();
			parametros.put("persona", persona);
			parametros.put("referencia", TIPO_REFERENCIA);
			final List<HashMap<String, Object>>	relaciones
				= (List<HashMap<String, Object>>) sessionNTx.selectList("consultarRelacionesSimplificacion", parametros );

			for ( HashMap<String, Object> relacion  : relaciones) {
				LogHandler.debug(uid, getClass(), "==> relacion " + relacion.get("id_relacion") );
				parametros.clear();
				parametros.put("persona", persona);
				parametros.put("idRelacion", relacion.get("id_relacion"));

				ReferenciaOV referencia = (ReferenciaOV) sessionNTx.selectOne("consultarReferenciaSimplificacion", parametros );

				String horarioLocalizacion = referencia.getDomicilio().getHoraLocalizaInicial() == null ? ""
						: referencia.getDomicilio().getHoraLocalizaInicial();
				
//				String horarioLocalizacion = referencia.getDomicilio().getHoraLocalizaInicial() != null
//						? referencia.getDomicilio().getHoraLocalizaInicial() : "";
				
				if (horarioLocalizacion.indexOf("-") > -1) {
					referencia.getDomicilio().setHoraLocalizaInicial(horarioLocalizacion.split("-")[0]);
					referencia.getDomicilio().setHoraLocalizaFinal(horarioLocalizacion.split("-")[1]);
				}
				else {
					referencia.getDomicilio().setHoraLocalizaInicial(" ");
					referencia.getDomicilio().setHoraLocalizaFinal(" ");
				}

				//TELEFONOS
				parametros.put("tipo_plan", "");
				final HashMap<String, Object> telefonoCelular = (HashMap<String, Object>)
						sessionNTx.selectOne("consultarTelefonoReferenciaSimplificacion", parametros );

				if (telefonoCelular == null) {
					referencia.setTelefonoCelular(" ");
				} else {
					referencia.setTelefonoCelular(telefonoCelular.get("telefono") == null ? " "
											: telefonoCelular.get("telefono").toString());
				}

				parametros.put("tipo_plan", "FIJO");
				final HashMap<String, Object> telefonoDirecto = (HashMap<String, Object>)
						sessionNTx.selectOne("consultarTelefonoReferenciaSimplificacion", parametros );

				if (telefonoDirecto == null) {
					referencia.setTelefonoDirecto(" ");
				} else {
					referencia.setTelefonoDirecto(telefonoDirecto.get("telefono") == null ? " "
							: telefonoDirecto.get("telefono").toString());
				}

				referencias.add(referencia);
			}

			personaConsulta.setReferencias(referencias);
			//Agregamos persona a la lista
			lista.add(personaConsulta);
		}

			respuesta.setPersona(lista);
		}
		catch (Exception exception) {
			LogHandler.error(uid, getClass(), ReadProperties.mensajes.getProp(
					"administracion.persona.error.consultar.persona" ), exception);
			respuesta.getHeader().setUID( uid );
			respuesta.getHeader().setEstatus( false );
			respuesta.getHeader().setMensaje( ReadProperties.mensajes.getProp(
					"administracion.persona.error.consultar.persona" ) + " : " + exception.getMessage() );
		}
		finally {
			FabricaConexiones.close( sessionNTx );
		}

		return respuesta;
	}
	
	/**
	 * Registrar y checar buro de credito del prospecto del aplicativo de caravanas.
	 *
	 * @param uid :
	 * @param peticion :
	 * @param consultaBuro consulta de buro de credito.
	 * @return RegistrarPersonaRespuesta
	 */
	@SuppressWarnings("unchecked")
	public RegistrarPersonaRespuesta registrarProspectoCaravana(String uid, RegistrarPersonaPeticion peticion, boolean consultaBuro) {
		LogHandler.info(uid, getClass(), "Entrando al metodo de registrarProspectoCaravana ************");
		final RegistrarPersonaRespuesta respuesta = new RegistrarPersonaRespuesta( uid );
		RelacionClaveFinsolOV relacionClaveFinsol = new RelacionClaveFinsolOV();
		//Objetos para manejo de la sesiones
			SqlSession 	sessionSybaseTx = null;

			try {
				 // Validaciones - Buscamos si existen registros previos
				LogHandler.info(uid, getClass(), "No persona :" + peticion.getPersona().getNumeroPersona().trim() + "**");
				if (peticion.getPersona() == null || peticion.getPersona().getProspecto() == null
						|| !peticion.getPersona().getProspecto()) {
						respuesta.getHeader().setEstatus(false);
						respuesta.getHeader().setMensaje(ReadProperties.mensajes.getProp( "administracion.prospecto.errorprospecto" ));
						throw new Exception( ReadProperties.mensajes.getProp( "administracion.prospecto.errorprospecto" ) );
					}
				if (peticion.getPersona().getNumeroPersona() != null
					&& !peticion.getPersona().getNumeroPersona().trim().isEmpty()) {
					respuesta.getHeader().setEstatus(false);
					respuesta.getHeader().setMensaje(ReadProperties.mensajes.getProp( "administracion.persona.errorpersonayaregistrada" )
							+ " CON EL NÚMERO DE PERSONA:  ["+ peticion.getPersona().getNumeroPersona() + "]");
					throw new Exception( ReadProperties.mensajes.getProp( "administracion.persona.errorpersonayaregistrada" )
							+ " CON EL NÚMERO DE PERSONA: ["+ peticion.getPersona().getNumeroPersona() + "]");
				}
				
				final ConsultarPersonaPeticion 	consultarPersonaPeticion = new ConsultarPersonaPeticion();
				consultarPersonaPeticion.setPersona( peticion.getPersona() );
				final ConsultarPersonaRespuesta	consultarPersonaRespuesta = consultarPersona(uid, consultarPersonaPeticion);

				//Se valida si hay registros con datos iguales
				if ( consultarPersonaRespuesta.getPersona() != null && consultarPersonaRespuesta.getPersona().size() > 0 ) {
					respuesta.getHeader().setEstatus(false);
					respuesta.getHeader().setMensaje(ReadProperties.mensajes.getProp( "administracion.persona.errorpersonayaregistrada" )
							+ " CON EL NÚMERO DE PERSONA:  ["+ consultarPersonaRespuesta.getPersona().get(0).getNumeroPersona() + "]");
					relacionClaveFinsol.setNumeroPersona(consultarPersonaRespuesta.getPersona().get(0).getNumeroPersona());
					respuesta.setRelacionClaveFinsol(relacionClaveFinsol);
					throw new Exception( ReadProperties.mensajes.getProp( "administracion.persona.errorpersonayaregistrada" )
							+ " CON EL NÚMERO DE PERSONA:  ["+ consultarPersonaRespuesta.getPersona().get(0).getNumeroPersona() + "]");
				}

				//Se abre la session transaccional sybase
				sessionSybaseTx = FabricaConexiones.obtenerSesionTx();

				// Generacion de secuencias para codigo-persona-credprod_finsol
				LogHandler.trace(uid, getClass(), "==> registrarProspectoCaravana - obtenerValorSequenciasPersona" );
				final java.util.ArrayList<HashMap<String, Object>> 	clavesActuales
					= (ArrayList<HashMap<String, Object>>) sessionSybaseTx.selectList( "obtenerValorSequenciasPersona" );

				//Se generan las secuencias
				final java.util.HashMap<String, Long> clavesActualizadas = new HashMap<String, Long>();
				//Se incrementa al siguiente consecutivo
				for ( HashMap<String, Object> secuencia : clavesActuales ) {
					clavesActualizadas.put( secuencia.get( "tipo").toString(),
							Long.valueOf( secuencia.get( "actual" ).toString() )
							+ Long.valueOf( secuencia.get( "incremento" ).toString() ) );
				}
				if ( peticion.getPersona().getDetalleSocioeconomico() == null) {
					peticion.getPersona().setDetalleSocioeconomico(new DetalleSocioeconomicoOV());
				}

				//Se actualizan las secuencias al nuevo valor
				LogHandler.trace(uid, getClass(), "==> registrarProspectoCaravana - actualizarSequenciasPersona" );
				sessionSybaseTx.update( "actualizarSequenciasPersona" );

				LogHandler.info(uid, getClass(), "Clave de persona : " + clavesActualizadas.get( "PER" ) );
				LogHandler.info(uid, getClass(), "Clave de t24 : " + clavesActualizadas.get( "T24" ) );

				//Se asignan las claves al objeto principal para las personas
				final RelacionClaveFinsolOV relacionClaveFinsolOV = new RelacionClaveFinsolOV();
				relacionClaveFinsolOV.setNumeroPersona( clavesActualizadas.get( "PER" ).toString() );
				relacionClaveFinsolOV.setClaveFinsol(  clavesActualizadas.get( "PER" ).toString() );
				relacionClaveFinsolOV.setClaveCU( clavesActualizadas.get( "PER" ).toString() );

				//Se asignan claves a la peticion
				peticion.getPersona().setRelacionClaveFinsol( relacionClaveFinsolOV );
				peticion.getPersona().setNumeroPersona( clavesActualizadas.get( "PER" ).toString() );
				respuesta.setRelacionClaveFinsol(relacionClaveFinsolOV);

				//Se busca que las claves no esten registradas
				LogHandler.trace(uid, getClass(), "==> registrarProspecto - buscarClavePersona" );
				final java.util.ArrayList<String>	clavesRegistradas = (ArrayList<String>)
						sessionSybaseTx.selectList( "buscarClavePersona", relacionClaveFinsolOV );

				//Se valida que no existan
				if ( clavesRegistradas != null &&  clavesRegistradas.size() > 0 ) {
					respuesta.getHeader().setEstatus(false);
					respuesta.getHeader().setMensaje(ReadProperties.mensajes.getProp( "administracion.persona.errorclaveexistente" )
							+ " CON EL NÚMERO DE PERSONA:  ["+ clavesRegistradas.get(0) + "]");
					relacionClaveFinsol.setNumeroPersona(clavesRegistradas.get(0));
					respuesta.setRelacionClaveFinsol(relacionClaveFinsol);
					throw new Exception( ReadProperties.mensajes.getProp( "administracion.persona.errorclaveexistente" )
							+ " CON EL NÚMERO DE PERSONA:  ["+ clavesRegistradas.get(0) + "]");
				}

				ValidaPersona.validaPersonaProspecto(peticion.getPersona(), MODULO_PERSONA);

				peticion.setPersona( (PersonaOV) limpiaObjeto(peticion.getPersona()) );

				//Se lleva a cabo el registro de la persona en sybase
				LogHandler.trace(uid, getClass(), "==> registrarProspectoCaravana - registrarProspectoSybase" );
				sessionSybaseTx.insert( "registrarProspectoSybase", peticion.getPersona() );
				//Persona Complemento

				final HashMap<String, Object> 	parametrosComplemento = new HashMap<String, Object>();

				parametrosComplemento.put("persona", peticion.getPersona().getNumeroPersona() );
				parametrosComplemento.put("asesor", peticion.getPersona().getAsesorCredito() != null
						? peticion.getPersona().getAsesorCredito() : "");
				parametrosComplemento.put("sucursal", peticion.getPersona().getSucursal() != null
						? peticion.getPersona().getSucursal() : 0);
				parametrosComplemento.put("experiencia", (peticion.getPersona().getExperienciaCreditoGrupal() != null
						&& peticion.getPersona().getExperienciaCreditoGrupal()) ? "S" : "N");
				parametrosComplemento.put("campana", peticion.getPersona().getCampana() != null
						? peticion.getPersona().getCampana() : "");
				parametrosComplemento.put("estatus", peticion.getPersona().getEstatus() != null
						? peticion.getPersona().getEstatus() :"");
				parametrosComplemento.put("fechaContacto", peticion.getPersona().getFechaContacto() != null
						? peticion.getPersona().getFechaContacto() : "");
				

				//Se lleva a cabo el registro del complemento de la persona en sybase
				LogHandler.trace(uid, getClass(), "==> registrarProspectoCaravana - registrarComplementoProspectoSybase" );
				sessionSybaseTx.insert( "registrarComplementoProspectoCaravana", parametrosComplemento );

				if (peticion.getPersona().getDomicilioPersona() != null ) {
					DomicilioOV domicilioOV = peticion.getPersona().getDomicilioPersona();
					ValidaPersona.validaDomicilioProspecto(domicilioOV, MODULO_PERSONA);
					peticion.getPersona().getDomicilioPersona().setNumeroPersona(  peticion.getPersona().getNumeroPersona() );
					peticion.getPersona().getDomicilioPersona().setTipoDomicilio( TIPO_DIRECTO );
					peticion.getPersona().getDomicilioPersona().setPais(
							peticion.getPersona().getDomicilioPersona().getPais() == null
							? "MX" : peticion.getPersona().getDomicilioPersona().getPais() );
					//Calle modelo anterior
					peticion.getPersona().getDomicilioPersona().setNumeroExterior(
							peticion.getPersona().getDomicilioPersona().getNumeroExterior( ) != null
							? peticion.getPersona().getDomicilioPersona().getNumeroExterior( ) : "");

					peticion.getPersona().getDomicilioPersona().setNumeroInterior(
							peticion.getPersona().getDomicilioPersona().getNumeroInterior( ) != null
							? peticion.getPersona().getDomicilioPersona().getNumeroInterior( ) : "");
					
					//Registro Domicilio DIRE
					insertaDomicilio( uid, sessionSybaseTx, peticion.getPersona().getDomicilioPersona(),
									peticion.getPersona() , null );
					
					//Domicilios
					LogHandler.trace(uid, getClass(), "==> registrarProspectoCaravana - actualizarDomicilioPersona" );
					sessionSybaseTx.update( "actualizarDomicilioPersona", domicilioOV );

				}
				
				//Telefonos
				for ( TelefonoOV telefonoOV : peticion.getPersona().getTelefonosPersona() ) {
					//Validacion telefono
					ValidaPersona.validaTelefono(telefonoOV, MODULO_PERSONA);

					final HashMap<String, Object> 	parametros = new HashMap<String, Object>();
					parametros.clear();
					parametros.put( "usuario"	 	 , peticion.getPersona().getOperador() != null
													? peticion.getPersona().getOperador() : "000000043"  );
					parametros.put( "integrante"	 , peticion.getPersona().getNumeroPersona() );
					parametros.put( "tipo"			 , telefonoOV.getTipoTelefono() );
					parametros.put( "lada"			 , "" );
					parametros.put( "telefono"		 , telefonoOV.getTelefono() != null ? telefonoOV.getTelefono() : "" );
					parametros.put( "relacion"		 , "" );
					parametros.put( "nombre"		 , "" );
					parametros.put( "apellidoPaterno", "" );
					parametros.put( "apellidoMaterno", "" );
					parametros.put( "fechaAlta"		 , new Date() );
					parametros.put( "origen"		 , telefonoOV.getOrigen()  );
					Integer idRelacion = 0;
					parametros.put( "idRelacion"     , idRelacion  );

					String tipoPlan = "";
					if ( telefonoOV.getTipoTelefono().equals(TIPO_DIRECTO)
						||	telefonoOV.getTipoTelefono().equals(TIPO_EMPLEO)) {
						tipoPlan = "FIJO";
					}
					else {
						tipoPlan = "C";
					}
					parametros.put( "tipo_plan"      , tipoPlan );

					LogHandler.trace(uid, getClass(), "==> registrarProspectoCaravana - registrarTelefonoIntegrante");
					final ResultadoOV resultado = (ResultadoOV)
													sessionSybaseTx.selectOne( "registrarTelefonoIntegrante", parametros );

					LogHandler.debug(uid, getClass(), "registrarPersona - registrarTelefonoIntegrante resultado ="
														+ resultado.toString());

					if ( Integer.valueOf(resultado.getCodigo()).intValue() < 0 ) {
						respuesta.getHeader().setEstatus(false);
						respuesta.getHeader().setMensaje(resultado.getMensaje() + " " + telefonoOV.getTelefono());
						throw new Exception( resultado.getMensaje() + " " + telefonoOV.getTelefono() );
					}
				}
				
				//Direccion electronica
				for ( DireccionElectronicaOV direccionElectronicaOV: peticion.getPersona().getDireccionesElectonicas()) {
					direccionElectronicaOV.setNumeroPersona(peticion.getPersona().getNumeroPersona());
					LogHandler.trace(uid, getClass(), "==> registrarProspectoCaravana - actualizarCorreoPersona" );
					sessionSybaseTx.update( "actualizarCorreoPersona", direccionElectronicaOV );
				}

				//Relacion de claves para interoperatividad entre bases
				LogHandler.trace(uid, getClass(), "==> registrarProspectoCaravana - insertarClavesPersona" );
				sessionSybaseTx.insert( "insertarClavesPersona", relacionClaveFinsolOV );
				sessionSybaseTx.commit( true ); // se hace commit para guaradar en numero de persona antes por auditoria de buro en caso de falla
				LogHandler.info(uid, getClass(), "******* inicia consulta de buro de credito **********");
				
				   if (consultaBuro) {
						ConsultaBuroPeticion peticionBuro = new ConsultaBuroPeticion();
						peticionBuro.setImporte(1);
						peticionBuro.setPersona(peticion.getPersona().getNumeroPersona());
						peticionBuro.setUsuario(peticion.getPersona().getOperador());
						peticionBuro.setSucursal(peticion.getPersona().getSucursal());
						
						ConsultaSolicitudBuroRespuesta respuestaBuro = buroCreditoTarea.obtenerBuroProspectoCaravanas(uid, peticionBuro);
						
						if (respuestaBuro != null && respuestaBuro.getHeader() != null) {
						    respuesta.setValidacionBuro(respuestaBuro.getHeader().isEstatus());
						    respuesta.setMensajeBuro(respuestaBuro.getHeader().getMensaje());
						    final HashMap<String, Object> 	parametros = new HashMap<String, Object>();
						    if (respuestaBuro.getHeader().isEstatus()) {
						    	parametros.put( "estatusBuro", "BIEN" );
						    } else {
						    	parametros.put( "estatusBuro", "MALO" );
						    } 
							parametros.put( "numeroPersona", peticion.getPersona().getNumeroPersona());
						    
						    LogHandler.trace(uid, getClass(), "==> registrarProspectoCaravana - actualizarEstatusBuroPersona:" + parametros );
							sessionSybaseTx.update( "actualizarEstatusBuroPersona", parametros );
						}
						
						LogHandler.info(uid, getClass(), "******* termina consulta de buro de credito **********");
				   } else {
					   respuesta.setValidacionBuro(false);
					   respuesta.setMensajeBuro("No se consulto buro crédito.");
				   }

				sessionSybaseTx.commit( true );

				LogHandler.debug(uid, getClass(), "COMMIT APLICADO!");	
			}
			catch ( java.lang.Exception exception ) {
				//Rollback a ambas conexiones transaccionales
				FabricaConexiones.rollBack( sessionSybaseTx );
				LogHandler.debug(uid, getClass(), "ROLLBACK APLICADO!");
				
				if(respuesta.getHeader().getMensaje() == null) {
					LogHandler.error(uid, getClass(), ReadProperties.mensajes.getProp(
							"administracion.persona.errorregistrarpersona" ), exception);
					respuesta.getHeader().setUID( uid );
					respuesta.getHeader().setEstatus( false );
					respuesta.getHeader().setMensaje( ReadProperties.mensajes.getProp(
							"administracion.persona.errorregistrarpersona" ) + " : " + exception.getMessage() );
				} else {
					LogHandler.error(uid, getClass(), respuesta.getHeader().getMensaje(), exception);
				}
				
			}
			finally {
				FabricaConexiones.close( sessionSybaseTx );
		}
		return respuesta;
	}
}
