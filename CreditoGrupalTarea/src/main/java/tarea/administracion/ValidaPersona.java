package tarea.administracion;

import datamapper.DataMapper;
import tarea.comun.DataEstado;
import tarea.comun.ReadProperties;
import utilitario.comun.Funciones;
import utilitario.mensajes.persona.DetalleSocioeconomicoOV;
import utilitario.mensajes.persona.DomicilioOV;
import utilitario.mensajes.persona.PersonaOV;
import utilitario.mensajes.persona.RelacionPersonaOV;
import utilitario.mensajes.persona.TelefonoOV;

public final class ValidaPersona {

	/**
	 * MODULO_PERSONA
	 */
	public static final String MODULO_PERSONA = "PERSONA";
	/**
	 * MODULO_DOMICILIO
	 */
	public static final String MODULO_DOMICILIO = "DOMICILIO";
	/**
	 * MODULO_REFERENCIA
	 */
	public static final String MODULO_REFERENCIA = "REFERENCIA";
	/**
	 * MODULO_TELEFONO
	 */
	public static final String MODULO_TELEFONO = "TELEFONO";
	/**
	 * MODULO_DETALLESOCIOECONOMICO
	 */
	public static final String MODULO_DETALLESOCIOECONOMICO = "DETALLE SOCIOECONOMICO";
	/**
	 * TIPO_CONYUGE
	 */
	public static final String TIPO_CONYUGE = "CONY";
	/**
	 * TIPO_RECADO
	 */
	public static final String TIPO_RECADO = "RECA";
	/**
	 * LONGITUD_CODIGO
	 */
	public static final Integer LONGITUD_CODIGO = 4;
	/**
	 * LONGITUD_HORARIO
	 */
	public static final Integer LONGITUD_HORARIO = 5;
	/**
	 * LONGITUD_DIAS
	 */
	public static final Integer LONGITUD_DIAS = 13;
	/**
	 * LONGITUD_TELEFONO
	 */
	public static final Integer LONGITUD_TELEFONO = 10;
	/**
	 * NUMERO_DIAS
	 */
	public static final Integer NUMERO_DIAS = 7;

	/**
	 * Constructor privado
	 */
	private ValidaPersona() {
	      //not called
	   }

	/**
	 * @param persona :
	 * @param modulo :
	 * @throws java.lang.Exception
	 */
	public static void validaPersona(PersonaOV persona, String modulo) throws java.lang.Exception {

		// Valida  entidad
		 if ( persona.getEntidadLugarNacimiento() == null
			  || !DataEstado.validaClaveEntidad(persona.getEntidadLugarNacimiento().trim())) {
			   throw new Exception( ReadProperties.mensajes.getProp(
					  "administracion.persona.domicilio.error.entidad" ) + "[" + modulo + "]" );
		   }

		 if ( persona.getRfc() == null || persona.getRfc().trim().isEmpty()) {
				throw new Exception( ReadProperties.mensajes.getProp("administracion.persona.error.rfc" ) + "[" + modulo + "]" );
			}


		 if ( persona.getOperador() == null || persona.getOperador().trim().isEmpty()) {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.persona.error.operador" ) + "[" + modulo + "]" );
			}

		 if ( persona.getOrigen() == null || persona.getOrigen().length() != LONGITUD_CODIGO ) {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.persona.error.origen" ) + "[" + modulo + "]" );
			}

		 if (persona.getDomicilioPersona() == null) {
			 throw new Exception( ReadProperties.mensajes.getProp(
					 "administracion.persona.error.domicilio" ) + "[" + modulo + "]" );
		 }

		 if ( persona.getSucursal() == null ) {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.persona.error.sucursal" ) + "[" + modulo + "]" );
			}


	}

	/**
	 * @param persona :
	 * @param modulo :
	 * @throws java.lang.Exception
	 */
	public static void validaPersonaProspecto(PersonaOV persona, String modulo) throws java.lang.Exception {

		if ( persona.getOperador() == null || persona.getOperador().trim().isEmpty()) {
			throw new Exception( ReadProperties.mensajes.getProp(
					"administracion.persona.error.operador" ) + "[" + modulo + "]" );
		}
		if ( persona.getOrigen() == null || persona.getOrigen().length() != LONGITUD_CODIGO ) {
			throw new Exception( ReadProperties.mensajes.getProp( "administracion.persona.error.origen" ) + "[" + modulo + "]" );
		}

		if ( persona.getSucursal() == null ) {
			throw new Exception( ReadProperties.mensajes.getProp(
					"administracion.persona.error.sucursal" ) + "[" + modulo + "]" );
		}

	}

	/**
	 * @param domicilio :
	 * @param modulo :
	 * @throws java.lang.Exception
	 */
	public static void validaDomicilio(DomicilioOV domicilio, String modulo) throws java.lang.Exception {

		// Valida Tipo Vivienda
		if (domicilio.getTipoDomicilio() == null || domicilio.getTipoDomicilio().trim().length() != LONGITUD_CODIGO) {
			throw new Exception( ReadProperties.mensajes.getProp(
				"administracion.persona.domicilio.error.tipodomicilio" ) + "[" + modulo + "]" );
		}


		// Valida  entidad
		if ( domicilio != null && domicilio.getCodigoEstado() != null && !domicilio.getCodigoEstado().trim().equals( "" ) ) {
			   if (!DataEstado.validaClaveEntidad(domicilio.getCodigoEstado().trim())) {
				   throw new Exception( ReadProperties.mensajes.getProp(
						 "administracion.persona.domicilio.error.entidad" ) + "[" + modulo + "]" );
			   }
			}
		else {
			throw new Exception( ReadProperties.mensajes.getProp(
					"administracion.persona.errordomicilioentidad" ) + "[" + modulo + "]" );
		}

		// Valida Tipo Vivienda
		if (domicilio.getTipoVivienda() == null || domicilio.getTipoVivienda().trim().length() != 1) {
			throw new Exception( ReadProperties.mensajes.getProp(
					"administracion.persona.domicilio.error.tipovivienda" ) + "[" + modulo + "]" );
		}
		// Valida Dias Lozaliza
		if (domicilio.getDiasLocaliza() == null || domicilio.getDiasLocaliza().trim().length() != LONGITUD_DIAS
				|| domicilio.getDiasLocaliza().split(",").length != NUMERO_DIAS ) {
			throw new Exception(  ReadProperties.mensajes.getProp(
					"administracion.persona.domicilio.error.diaslocalizacion") + "[" + modulo + "]" );
		}
		//Valida HoraLocalizaInicial
		if (domicilio.getHoraLocalizaInicial() != null ) {
			if (domicilio.getHoraLocalizaInicial().trim().length() != LONGITUD_HORARIO) {
				throw new Exception(  ReadProperties.mensajes.getProp(
					"administracion.persona.domicilio.error.horainicial") + "[" + modulo + "]" );
			}
		}
		//Valida HoraLocalizaFinal
		if (domicilio.getHoraLocalizaFinal() != null ) {
			if (domicilio.getHoraLocalizaFinal().trim().length() != LONGITUD_HORARIO) {
				throw new Exception(  ReadProperties.mensajes.getProp(
					"administracion.persona.domicilio.error.horafinal") + "[" + modulo + "]" );
			}
		}

	}


/**
 * @param domicilio :
 * @param modulo :
 * @throws java.lang.Exception
 */
	public static void validaDomicilioProspecto(DomicilioOV domicilio, String modulo) throws java.lang.Exception {

		// Valida  entidad
		if ( domicilio != null && domicilio.getCodigoEstado() != null && !domicilio.getCodigoEstado().trim().equals( "" ) ) {
			   if (!DataEstado.validaClaveEntidad(domicilio.getCodigoEstado().trim())) {
				   throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.persona.domicilio.error.entidad" ) + "[" + modulo + "]" );
			   }
			}
		else {
				throw new Exception( ReadProperties.mensajes.getProp(
						"administracion.persona.domicilio.error.entidad" ) + "[" + modulo + "]" );
		}

		// Valida Tipo Vivienda
		if (domicilio.getTipoVivienda() != null && domicilio.getTipoVivienda().trim().length() != 1) {
			throw new Exception( ReadProperties.mensajes.getProp(
					"administracion.persona.domicilio.error.tipovivienda" ) + "[" + modulo + "]" );
		}
	}

	/**
	 * @param telefono :
	 * @param modulo :
	 * @throws java.lang.Exception
	 */
	public static void validaTelefono(TelefonoOV telefono, String modulo) throws java.lang.Exception {

		if ( telefono.getTipoTelefono() == null || telefono.getTipoTelefono().length() != LONGITUD_CODIGO ) {
			throw new Exception(  ReadProperties.mensajes.getProp(
					"administracion.persona.error.telefono.tipo") + "[" + modulo + "]" );
		}
		if ( telefono.getTelefono() == null || telefono.getTelefono().trim().length() != LONGITUD_TELEFONO ) {
			throw new Exception(  ReadProperties.mensajes.getProp(
					"administracion.persona.error.telefono")  + "[" + modulo + "]" );
		}
		if ( !Funciones.esEntero( telefono.getTelefono() ) ) {
			throw new Exception(  ReadProperties.mensajes.getProp(
					"administracion.persona.error.telefono")  + "[" + modulo + "]" );
		}
		if ( telefono.getOrigen() == null || telefono.getOrigen().length() != LONGITUD_CODIGO ) {
			throw new Exception(  ReadProperties.mensajes.getProp(
					"administracion.persona.error.telefono.origen") + "[" + modulo + "]" );
		}
		if (modulo.equals( MODULO_REFERENCIA )) {
			if ( !( telefono.getTipoTelefono().equals("DIRE") ||  telefono.getTipoTelefono().equals("CELU") ) ) {
				throw new Exception(  ReadProperties.mensajes.getProp(
					"administracion.persona.error.telefono.tipo") + "[" + modulo + "]" );
			}
		}
		if (modulo.equals( TIPO_CONYUGE )) {
			if ( !( telefono.getTipoTelefono().equals("CONC") ||  telefono.getTipoTelefono().equals("COND") ) ) {
				throw new Exception(  ReadProperties.mensajes.getProp(
					"administracion.persona.error.telefono.tipo") + "[" + modulo + "]" );
			}
		}

		if (modulo.equals( TIPO_RECADO )) {
			if ( !( telefono.getTipoTelefono().equals("RECA")) ) {
				throw new Exception(  ReadProperties.mensajes.getProp(
					"administracion.persona.error.telefono.tipo") + "[" + modulo + "]" );
			}
		}

		if (modulo.equals( MODULO_PERSONA )) {
			if ( !( telefono.getTipoTelefono().equals("DIRE") ||  telefono.getTipoTelefono().equals("CELU")
					||  telefono.getTipoTelefono().equals("EMPL") ) ) {
				throw new Exception(  ReadProperties.mensajes.getProp(
					"administracion.persona.error.telefono.tipo") + "[" + modulo + "]" );
			}
		}
	}

	/**
	 * @param referencia :
	 * @param modulo :
	 * @throws java.lang.Exception
	 */
	public static void validaReferencia(RelacionPersonaOV referencia, String modulo) throws java.lang.Exception {

		if (referencia == null || referencia.getDomicilioRelacion() == null) {
			throw new Exception(  ReadProperties.mensajes.getProp(
					"administracion.persona.error.referencia.domicilio") + "[" + modulo + "]" );
		}

		if (DataMapper.mapRelacionOracle.get(referencia.getClaveParentesco().trim()) == null) {
			throw new Exception(  ReadProperties.mensajes.getProp(
					"administracion.persona.error.referencia.relacion") + "[" + modulo + "]" );
		}

	}

	/**
	 * @param socioeconomico :
	 * @param modulo :
	 * @throws java.lang.Exception
	 */
	public static void validaEstudioSocioeconomico(DetalleSocioeconomicoOV socioeconomico,
			String modulo) throws java.lang.Exception {

		if ( socioeconomico.getTipoActividad() == null ) {
			throw new Exception(  ReadProperties.mensajes.getProp(
					"administracion.persona.error.socioeconomico.tipoactividad") + "[" + modulo + "]" );
		}
		if ( socioeconomico.getTipoNegocio() == null || socioeconomico.getTipoNegocio().length() != 1 ) {
			throw new Exception(  ReadProperties.mensajes.getProp(
					"administracion.persona.error.socioeconomico.tiponegocio") + "[" + modulo + "]" );
		}
		if ( socioeconomico.getGiroNegocio() == null  ) {
			throw new Exception(  ReadProperties.mensajes.getProp(
					"administracion.persona.error.socioeconomico.gironegocio") + "[" + modulo + "]" );
		}
		if ( socioeconomico.getExperienciaRubro() == null  ) {
			throw new Exception(  ReadProperties.mensajes.getProp(
					"administracion.persona.error.socioeconomico.experienciarubro") + "[" + modulo + "]" );
		}
		if ( socioeconomico.getExperienciaNegocio() == null ) {
			throw new Exception(  ReadProperties.mensajes.getProp(
					"administracion.persona.error.socioeconomico.experiencianegocio") + "[" + modulo + "]" );
		}
	}



}
