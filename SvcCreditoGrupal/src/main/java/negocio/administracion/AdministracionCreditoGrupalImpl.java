package negocio.administracion;

import org.fabric3.api.annotation.monitor.Monitor;
import org.oasisopen.sca.annotation.Reference;

import tarea.administracion.AdministracionCredito;
import tarea.administracion.AdministracionPersona;
import tarea.condonaciones.CondonacionesManuales;
import transformador.Transformador;
import utilitario.comun.GUIDGenerator;
import utilitario.log.LogHandler;
import utilitario.log.LogMonitor;
import utilitario.mensajes.administracion.contrato.ActualizarSolicitudReasignarCarteraPeticion;
import utilitario.mensajes.administracion.contrato.ActualizarSolicitudReasignarCarteraRespuesta;
import utilitario.mensajes.administracion.contrato.AdministracionAnalistasPeticion;
import utilitario.mensajes.administracion.contrato.AdministracionAnalistasRespuesta;
import utilitario.mensajes.administracion.contrato.AjustarPersonaDomicilioPeticion;
import utilitario.mensajes.administracion.contrato.AjusteChequeDevueltoPeticion;
import utilitario.mensajes.administracion.contrato.AjusteChequeDevueltoRespuesta;
import utilitario.mensajes.administracion.contrato.AjusteDiaPagoPeticion;
import utilitario.mensajes.administracion.contrato.AjusteDiaReunionPeticion;
import utilitario.mensajes.administracion.contrato.AjusteDiaReunionRespuesta;
import utilitario.mensajes.administracion.contrato.AjustePlazoPeticion;
import utilitario.mensajes.administracion.contrato.AjustePorcentajeGarantiaPeticion;
import utilitario.mensajes.administracion.contrato.AjustePorcentajeGarantiaRespuesta;
import utilitario.mensajes.administracion.contrato.AjusteRespuesta;
import utilitario.mensajes.administracion.contrato.AjusteSaldoAFavorPeticion;
import utilitario.mensajes.administracion.contrato.AjusteSaldoAFavorRespuesta;
import utilitario.mensajes.administracion.contrato.AjusteTasaPeticion;
import utilitario.mensajes.administracion.contrato.EliminarSaldoAFavorPeticion;
import utilitario.mensajes.administracion.contrato.EliminarSaldoAFavorRespuesta;
import utilitario.mensajes.administracion.contrato.ReasignarCarteraOV;
import utilitario.mensajes.administracion.contrato.ReasignarCarteraPeticion;
import utilitario.mensajes.administracion.contrato.ReasignarCarteraReporteOV;
import utilitario.mensajes.administracion.contrato.ReasignarCarteraRespuesta;
import utilitario.mensajes.administracion.contrato.RegistrarSolicitudReasignarCarteraPeticion;
import utilitario.mensajes.administracion.contrato.RegistrarSolicitudReasignarCarteraRespuesta;
import utilitario.mensajes.administracion.contrato.RevertirSaldoAFavorPeticion;
import utilitario.mensajes.administracion.contrato.RevertirSaldoAFavorRespuesta;
import utilitario.mensajes.administracion.contrato.TransferirSaldosAFavorCreditosVigentesRespuesta;
import utilitario.mensajes.administracion.contrato.TrasferirSaldosAFavorCreditosVigentesPeticion;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.condonaciones.AplicarCondonacionParcialPeticion;
import utilitario.mensajes.condonaciones.AplicarCondonacionParcialRespuesta;
import utilitario.mensajes.condonaciones.AplicarCondonacionTotalPeticion;
import utilitario.mensajes.condonaciones.AplicarCondonacionTotalRespuesta;
import utilitario.mensajes.consultas.AsesoresOV;
import utilitario.mensajes.consultas.RespuestaSucursalOV;
import utilitario.mensajes.consultas.SucursalOV;
import utilitario.mensajes.grupos.gps.GruposGPSPeticion;
import utilitario.mensajes.grupos.gps.GruposGPSRespuesta;
import utilitario.mensajes.operacion.administracion.SucursalPeticion;
import utilitario.mensajes.originacion.cancelacion.CancelacionContratoPeticion;
import utilitario.mensajes.originacion.cancelacion.CancelacionContratoRespuesta;
import utilitario.mensajes.originacion.cliente.ClienteRespuesta;
import utilitario.mensajes.originacion.cliente.RegistrarTelefonoPeticion;
import utilitario.mensajes.persona.ValidaExistePersonaPeticion;
import utilitario.mensajes.persona.ValidaExistePersonaRespuesta;


/**
 * @author oarias
 * @param log de tipo LogMonitor
 *
 */
/**
 * @author mi.mejorada
 *
 */
/**
 * @author mi.mejorada
 *
 */
public 	class 		AdministracionCreditoGrupalImpl
		implements	AdministracionCreditoGrupal {
	/**
	 * SCA Component Fabric
	 */
	private AdministracionCredito administracion;
	/**
	 * SCA Component Fabric
	 */
	private CondonacionesManuales condonaciones;

	/** The administracion persona. */
	private AdministracionPersona administracionPersona;

	/**
	 * SCA Component Fabric
	 */
	private Transformador transformador;

	/**
	 * SCA Component Fabric
	 */
	 LogMonitor log;

	 /**
	 * SCA Component Fabric
	 * @param administracion :
	 * @param condonaciones :
	 * @param transformador :
	 * @param administracionPersona :
	 * @param log :
	 */
	public AdministracionCreditoGrupalImpl(@Monitor("Log" ) LogMonitor log,
											@Reference(name = "administracion") AdministracionCredito administracion ,
										  @Reference(name = "condonaciones") CondonacionesManuales condonaciones,
										  @Reference(name = "transformador") Transformador transformador,
							@Reference(name = "administracionPersona") AdministracionPersona administracionPersona) {
 		this.administracion = administracion;
		this.condonaciones = condonaciones;
		this.transformador = transformador;
		this.administracionPersona = administracionPersona;
 		this.log = log;
	}

	/**
	 * @param peticion :
	 * @return AjusteRespuesta
	 */
	public AjusteRespuesta ajustarTasa(AjusteTasaPeticion peticion) {
		String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "ajustarTasa - Datos de entrada : " + peticion );

		//Se recibe la salida
		final AjusteRespuesta ajusteRespuesta = administracion.ajustarTasa(uid, peticion );
		LogHandler.info(uid, getClass(), "ajustarTasa - Datos de salida : " + ajusteRespuesta );
		return ajusteRespuesta;
	}

	/**
	 * @param peticion :
	 * @return AjusteRespuesta
	 */
	public AjusteRespuesta ajustarPlazo(AjustePlazoPeticion peticion) {
		String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "ajustarPlazo - Datos de entrada : " + peticion);

		//Se recibe la salida
		final AjusteRespuesta ajusteRespuesta =  administracion.ajustarPlazo(uid, peticion);
		LogHandler.info(uid, getClass(), "ajustarPlazo - Datos de salida : " + ajusteRespuesta);
		return ajusteRespuesta;
	}

	/**
	 * @param peticion :
	 * @return AjusteRespuesta
	 */
	public AjusteRespuesta ajustarDiaPago(AjusteDiaPagoPeticion peticion) {
		String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "ajustarDiaPago - Datos de entrada : " + peticion );

		//Se recibe la salida
		final AjusteRespuesta ajusteRespuesta = administracion.ajustarDiaPago(uid, peticion);
		LogHandler.info(uid, getClass(), "ajustarDiaPago - Datos de salida : " + ajusteRespuesta );
		return ajusteRespuesta;
	}

	/**
	 * @param peticion :
	 * @return AplicarCondonacionParcialRespuesta
	 */
	public AplicarCondonacionParcialRespuesta aplicarCondonacionParcial(AplicarCondonacionParcialPeticion peticion) {
		String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "aplicarCondonacionParcial - Datos de entrada : " + peticion);

		//Salida
		final 	AplicarCondonacionParcialRespuesta
				aplicarCondonacionParcialRespuesta = condonaciones.aplicarCondonacionParcial(uid, peticion);
		LogHandler.info(uid, getClass(), "aplicarCondonacionParcial - Datos de salida : " + aplicarCondonacionParcialRespuesta);
		return aplicarCondonacionParcialRespuesta;
	}

	/**
	 * @param peticion :
	 * @return AplicarCondonacionTotalRespuesta
	 */
	public AplicarCondonacionTotalRespuesta aplicarCondonacionTotal(AplicarCondonacionTotalPeticion peticion) {
		String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "aplicarCondonacionTotal - Datos de entrada : " + peticion);

		//Objeto salida
		final 	AplicarCondonacionTotalRespuesta
				aplicarCondonacionTotalRespuesta =  condonaciones.aplicarCondonacionTotal(uid, peticion);
		LogHandler.info(uid, getClass(), "aplicarCondonacionTotal - Datos de salida : " + aplicarCondonacionTotalRespuesta);
		return aplicarCondonacionTotalRespuesta;
	}

	/**
	 * @param peticion :
	 * @return AjusteChequeDevueltoRespuesta
	 */
	public AjusteChequeDevueltoRespuesta ajustarPorChequeDevuelto(AjusteChequeDevueltoPeticion peticion) {
		String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "ajustarPorChequeDevuelto - Datos de entrada : " + peticion);

		//Salida
		final AjusteChequeDevueltoRespuesta ajusteChequeDevueltoRespuesta
					= administracion.ajustarPorChequeDevuelto(uid, peticion);
		LogHandler.info(uid, getClass(), "ajustarPorChequeDevuelto - Datos de salida : " + ajusteChequeDevueltoRespuesta);
		return ajusteChequeDevueltoRespuesta;
	}

	/**
	 * @param peticion :
	 * @return CancelacionContratoRespuesta
	 */
	public CancelacionContratoRespuesta cancelarContrato(CancelacionContratoPeticion peticion)
		{
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "cancelarContrato - Datos de entrada : " + peticion);

		//Salida
		final 	CancelacionContratoRespuesta
				cancelacionContratoRespuesta = administracion.cancelarContrato(peticion.getBody(), uid , null);
		LogHandler.info(uid, getClass(), "cancelarContrato - Datos de salida : " + cancelacionContratoRespuesta);
		return cancelacionContratoRespuesta;
		}

	/**
	 * @param peticion :
	 * @return AjusteSaldoAFavorRespuesta
	 */
	public AjusteSaldoAFavorRespuesta transferirSaldoAFavor(AjusteSaldoAFavorPeticion peticion)
		{
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "transferirSaldoAFavor - Datos de entrada : " + peticion);

		//Salida
		final 	AjusteSaldoAFavorRespuesta
				ajusteSaldoAFavorRespuesta = administracion.transferirSaldoAFavor(peticion, uid);
		LogHandler.info(uid, getClass(), "transferirSaldoAFavor - Datos de salida : " + ajusteSaldoAFavorRespuesta);
		return ajusteSaldoAFavorRespuesta;
		}

	/**
	 * @param peticion :
	 * @return EliminarSaldoAFavorRespuesta
	 */
	public EliminarSaldoAFavorRespuesta eliminarSaldoAFavor(EliminarSaldoAFavorPeticion peticion)
		{
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "eliminarSaldoAFavor - Datos de entrada : " + peticion);

		//Salida
		final 	EliminarSaldoAFavorRespuesta
				eliminarSaldoAFavorRespuesta = administracion.eliminarSaldoAFavor(peticion, uid);
		LogHandler.info(uid, getClass(), "eliminarSaldoAFavor - Datos de salida : " + eliminarSaldoAFavorRespuesta);
		return eliminarSaldoAFavorRespuesta;
		}

	/**
	 * @param peticion :
	 * @return RevertirSaldoAFavorRespuesta
	 */
	public RevertirSaldoAFavorRespuesta revertirSaldoAFavor(RevertirSaldoAFavorPeticion peticion)
		{
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "revertirSaldoAFavor - Datos de entrada : " + peticion);

		//Salida
		final 	RevertirSaldoAFavorRespuesta
				revertirSaldoAFavorRespuesta = administracion.revertirSaldoAFavor(peticion, uid);
		LogHandler.info(uid, getClass(), "revertirSaldoAFavor - Datos de salida : " + revertirSaldoAFavorRespuesta);
		return revertirSaldoAFavorRespuesta;
		}

	/**
	 * @param peticion :
	 * @return ReasignarCarteraRespuesta
	 */
	public ReasignarCarteraRespuesta reasignarCartera(ReasignarCarteraPeticion peticion)
		{
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "reasignarCartera - Datos de entrada : " + peticion);

		//Salida
		final 	ReasignarCarteraRespuesta
				reasignarCarteraRespuesta = administracion.reasignarCartera(peticion, uid);
		LogHandler.info(uid, getClass(), "reasignarCartera - Datos de salida : " + reasignarCarteraRespuesta);
		return reasignarCarteraRespuesta;
		}

	/**
	 * @param peticion :
	 * @return AjusteDiaReunionRespuesta
	 */
	public AjusteDiaReunionRespuesta ajustarDiaReunion(AjusteDiaReunionPeticion peticion)
		{
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "ajustarDiaReunion - Datos de entrada : " + peticion);

		//salida
		final  	AjusteDiaReunionRespuesta
				ajusteDiaReunionRespuesta = administracion.ajustarDiaReunion(peticion, uid);
		LogHandler.info(uid, getClass(), "ajustarDiaReunion - Datos de salida : " + ajusteDiaReunionRespuesta);
		return ajusteDiaReunionRespuesta;
		}

	/**
	 * @param peticion :
	 * @return RegistrarSolicitudReasignarCarteraRespuesta
	 */
	public RegistrarSolicitudReasignarCarteraRespuesta
			registrarSolicitudReasignarCartera(RegistrarSolicitudReasignarCarteraPeticion peticion)
		{
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "registrarSolicitudReasignarCartera - Datos de entrada : " + peticion);

		//Salida
		final 	RegistrarSolicitudReasignarCarteraRespuesta
				registrarSolicitudReasignarCarteraRespuesta = administracion.registrarSolicitudReasignarCartera(peticion, uid);
		LogHandler.info(uid, getClass(), "registrarSolicitudReasignarCartera - Datos de salida : "
					+ registrarSolicitudReasignarCarteraRespuesta);
		return registrarSolicitudReasignarCarteraRespuesta;
		}

	/**
	 * @param peticion :
	 * @return ActualizarSolicitudReasignarCarteraRespuesta
	 */
	public ActualizarSolicitudReasignarCarteraRespuesta
		actualizarSolicitudReasignarCartera(ActualizarSolicitudReasignarCarteraPeticion peticion)
		{
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "registrarSolicitudReasignarCartera - Datos de entrada : " + peticion);

		//Salida
		final 	ActualizarSolicitudReasignarCarteraRespuesta
				actualizarSolicitudReasignarCarteraRespuesta = administracion.actualizarSolicitudReasignarCartera(peticion, uid);
		LogHandler.info(uid, getClass(), "registrarSolicitudReasignarCartera - Datos de salida : "
				+ actualizarSolicitudReasignarCarteraRespuesta);
		return actualizarSolicitudReasignarCarteraRespuesta;
		}

	/**
	 * @param peticion :
	 * @return respuesta XML
	 */
	public String reasignarCarteraXML(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "reasignarCarteraXML - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ReasignarCarteraPeticion.class,
								   ReasignarCarteraRespuesta.class,
								   ReasignarCarteraOV.class,
								   ReasignarCarteraReporteOV.class};

		//Conversion de XML a Object
		final ReasignarCarteraPeticion
				reasignarCarteraPeticion = (ReasignarCarteraPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "reasignarCarteraXML - Datos de entrada : " + reasignarCarteraPeticion);

		//Llamado a funcion principal
		final ReasignarCarteraRespuesta respuesta = administracion.reasignarCartera(reasignarCarteraPeticion, uid );
		LogHandler.info(uid, getClass(), "reasignarCarteraXML - Datos de salida : " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "reasignarCarteraXML - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
		}

	/**
	 * @param peticion :
	 * @return respuesta XML
	 */
	public String registrarSolicitudReasignarCarteraXML(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "registrarSolicitudReasignarCarteraXML - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {RegistrarSolicitudReasignarCarteraPeticion.class,
								   RegistrarSolicitudReasignarCarteraRespuesta.class};

		//Conversion de XML a Object
		final RegistrarSolicitudReasignarCarteraPeticion registrarSolicitudReasignarCarteraPeticion =
				(RegistrarSolicitudReasignarCarteraPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "registrarSolicitudReasignarCarteraXML - Datos de entrada : "
					+ registrarSolicitudReasignarCarteraPeticion);

		//Llamado a funcion principal
		final  RegistrarSolicitudReasignarCarteraRespuesta respuesta =
				administracion.registrarSolicitudReasignarCartera(registrarSolicitudReasignarCarteraPeticion, uid );
		LogHandler.info(uid, getClass(), "registrarSolicitudReasignarCarteraXML - Datos de salida : " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "registrarSolicitudReasignarCarteraXML - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
		}

	/**
	 * @param peticion :
	 * @return respuesta XML
	 */
	public String actualizarSolicitudReasignarCarteraXML(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "actualizarSolicitudReasignarCarteraXML - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ActualizarSolicitudReasignarCarteraPeticion.class,
								   ActualizarSolicitudReasignarCarteraRespuesta.class};

		//Conversion de XML a Object
		final ActualizarSolicitudReasignarCarteraPeticion actualizarSolicitudReasignarCarteraPeticion =
				(ActualizarSolicitudReasignarCarteraPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "actualizarSolicitudReasignarCarteraXML - Datos de entrada : "
					+ actualizarSolicitudReasignarCarteraPeticion);

		//Llamado a funcion principal
		final   ActualizarSolicitudReasignarCarteraRespuesta respuesta =
				administracion.actualizarSolicitudReasignarCartera(actualizarSolicitudReasignarCarteraPeticion, uid );
		LogHandler.info(uid, getClass(), "actualizarSolicitudReasignarCarteraXML - Datos de salida : " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "actualizarSolicitudReasignarCarteraXML - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
		}

	/**
	 * @param peticion :
	 * @return respuesta
	 */
	public TransferirSaldosAFavorCreditosVigentesRespuesta
		trasferirSaldosAFavorCreditosVigentes(TrasferirSaldosAFavorCreditosVigentesPeticion peticion)
		{
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "trasferirSaldosAFavorCreditosVigentes - Datos de entrada : " + peticion);

		//Salida
		final 	TransferirSaldosAFavorCreditosVigentesRespuesta
				transferirSaldosAFavorCreditosVigentesRespuesta =
				administracion.trasferirSaldosAFavorCreditosVigentes(peticion, uid);
		LogHandler.info(uid, getClass(), "trasferirSaldosAFavorCreditosVigentes - Datos de salida : "
				+ transferirSaldosAFavorCreditosVigentesRespuesta);
		return transferirSaldosAFavorCreditosVigentesRespuesta;
		}

	/**
	 * @param peticion :
	 * @return ClienteRespuesta
	 */
	public ClienteRespuesta registrarTelefono(RegistrarTelefonoPeticion peticion) {
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "registrarTelefono - Datos de entrada : " + peticion);

		//Salida
		final 	ClienteRespuesta
				clienteRespuesta = administracion.registrarTelefono(peticion, uid);
		LogHandler.info(uid, getClass(), "registrarTelefono - Datos de salida : " + clienteRespuesta);
		return clienteRespuesta;
		}


	/**
	 * @param peticion :
	 * @return ajustarPersonaDomicilio :
	 */
	public AjusteRespuesta ajustarPersonaDomicilio(AjustarPersonaDomicilioPeticion peticion) {
		String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "ajustarPersonaDomicilio - Datos de entrada : " + peticion);

		//Se recibe la salida
		final AjusteRespuesta ajusteRespuesta =  administracion.ajustarPersonaDomicilio(uid, peticion);
		LogHandler.info(uid, getClass(), "ajustarPersonaDomicilio - Datos de salida : " + ajusteRespuesta);
		return ajusteRespuesta;
	}


	/**
	 * @param peticion EliminarSaldoAFavorPeticion :
	 * @return EliminarSaldoAFavorRespuesta
	 */
	public EliminarSaldoAFavorRespuesta eliminarSaldoAFavorRING(EliminarSaldoAFavorPeticion peticion)
	{
	final java.lang.String uid = GUIDGenerator.generateGUID(peticion);
	LogHandler.info(uid, getClass(), "eliminarSaldoAFavorRING - Datos de entrada : " + peticion);

	//Salida
	final 	EliminarSaldoAFavorRespuesta
			eliminarSaldoAFavorRespuesta = administracion.eliminarSaldoAFavorRING(peticion, uid);
	LogHandler.info(uid, getClass(), "eliminarSaldoAFavorRING - Datos de salida : " + eliminarSaldoAFavorRespuesta);
	return eliminarSaldoAFavorRespuesta;
	}


	/**
	 * Metodo para validar el nombre y fecha de nacimiento de una persona
	 * @param peticion del registro persona
	 * @return XML respuesta
	 */
	public String validaExistePersona(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "validaExistePersona - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ValidaExistePersonaPeticion.class,
									ValidaExistePersonaRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ValidaExistePersonaPeticion validaExistePersonaPeticion =
				(ValidaExistePersonaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "validaExistePersona - Datos de entrada : " + validaExistePersonaPeticion);

		//Llamado a funcion principal
		final ValidaExistePersonaRespuesta respuesta =
				administracionPersona.validaExistePersona(uid, validaExistePersonaPeticion);
		LogHandler.info(uid, getClass(), "validaExistePersona - Datos de salida : " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "validaExistePersona - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}
	/**
	 * Se ajusta el porcentaje de Garantia
	 *
	 * @param peticion datos de peticion de cambio de porcentaje de Garantia
	 * @return AjusteRespuesta: resultado del ajuste al porcentaje de Garantia
	 */
	public AjustePorcentajeGarantiaRespuesta modificarGarantia(AjustePorcentajeGarantiaPeticion peticion) {
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "modificarGarantia - Datos de entrada : " + peticion);

		//Salida
		final AjustePorcentajeGarantiaRespuesta respuesta = administracion.modificarGarantia(uid, peticion);
		LogHandler.info(uid, getClass(), "modificarGarantia - Datos de salida : " +  respuesta);
		return respuesta;
	}

		/**
	 * Metodo para guardar informacion del Analista
	 * @param peticion AdministracionAnalistasPeticion
	 * @return AdministracionAnalistasRespuesta
	 */
	public AdministracionAnalistasRespuesta guardarAnalistas(AdministracionAnalistasPeticion peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "guardarAnalistas:  " + peticion);
		final AdministracionAnalistasRespuesta respuesta = administracion.guardarAnalista(uid, peticion);
		LogHandler.info(uid, getClass(), "guardarAnalistas: - Datos de salida: " + respuesta.toString());
		return respuesta;
	}

	/**
	 * Metodo para buscar informacion del Analista
	 * @param peticion AdministracionAnalistasPeticion
	 * @return AdministracionAnalistasRespuesta
	 */
	public AdministracionAnalistasRespuesta buscarAnalistas(AdministracionAnalistasPeticion peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "buscarAnalistas:  " + peticion);
		final AdministracionAnalistasRespuesta respuesta = administracion.buscarAnalista(uid, peticion);
		LogHandler.info(uid, getClass(), "buscarAnalistas: - Datos de salida: " + respuesta.toString());
		return respuesta;
	}

	/**
	 * Metodo para guardar la contingencia de los Analistas
	 * @param peticion AdministracionAnalistasPeticion
	 * @return AdministracionAnalistasRespuesta
	 */
	public AdministracionAnalistasRespuesta guardarContingenciaAnalistas(
			AdministracionAnalistasPeticion peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "guardarContingenciaAnalistas:  " + peticion);
		final AdministracionAnalistasRespuesta respuesta =
				administracion.guardarContingenciaAnalistas(uid, peticion);
		LogHandler.info(uid, getClass(), "guardarContingenciaAnalistas - salida: " + respuesta.toString());
		return respuesta;
	}

	/**
	 * Metodo que se utiliza para la pantalla de clasificacion de sucursales
	 *
	 * @param peticion SucursalPeticion de la consulta
	 * @return respuestaXML clase de respuesta
	 */
	public String obtieneInfoSucursal(SucursalPeticion peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);

		//Parametros de entrada
		LogHandler.info(uid, getClass(), "obtieneInfoSucursal: - peticionL: " + peticion.getSucursal());

		//Llamado a funcion principal
		final RespuestaSucursalOV respuesta = administracion.obtieneInfoSucursalTarea(uid, peticion);
		LogHandler.info(uid, getClass(), "obtieneInfoSucursal: - Datos de salida: " + respuesta);

		//Parametros de entrada
		final Class<?>[] clases = {RespuestaSucursalOV.class,
									SucursalOV.class,
									AsesoresOV.class};

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "obtieneInfoSucursal - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Metodo que se utiliza para actualizar la informacion de la sucursal
	 *
	 * @param peticion RespuestaSucursalOV
	 * @return respuestaXML clase de respuesta
	 */
	public String actualizaInfoSucursal(RespuestaSucursalOV peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);

		//Llamado a funcion principal
		final RespuestaSucursalOV respuesta = administracion.actualizaInfoSucursalTarea(uid, peticion);
		LogHandler.info(uid, getClass(), "actualizaInfoSucursal: - Datos de salida: " + respuesta);

		//Parametros de entrada
		final Class<?>[] clases = {RespuestaSucursalOV.class,
									SucursalOV.class,
									AsesoresOV.class};

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "actualizaInfoSucursal - Datos de salida XML: " + respuestaXML);
		return respuestaXML;

	}

	/**
	 * Metodo para consultar los contratos actuales de la sucursal con coordenadas
	 * @param peticion sucursal y usuario
	 * @return lista de contratos
	 */
	public GruposGPSRespuesta consultaContratosCoordenadas(GruposGPSPeticion peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);

		LogHandler.info(uid, getClass(), "consultaContratosCoordenadas: - Datos de entrada: " + peticion);
		//Llamado a funcion principal
		final GruposGPSRespuesta respuesta = administracion.consultaContratosCoordenadas(uid, peticion);
		LogHandler.info(uid, getClass(), "consultaContratosCoordenadas: - Datos de salida: " + respuesta);

		return respuesta;
	}

	/**
	 * Metodo para actualizar las coordenadas de un contratos
	 * @param peticion contrato y coordenadas
	 * @return resultado actualizacionk
	 */
	public GruposGPSRespuesta actualizarContratoCoordenadas(GruposGPSPeticion peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);

		LogHandler.info(uid, getClass(), "actualizarContratoCoordenadas: - Datos de entrada: " + peticion);
		//Llamado a funcion principal
		final GruposGPSRespuesta respuesta = administracion.actualizarContratoCoordenadas(uid, peticion);
		LogHandler.info(uid, getClass(), "actualizarContratoCoordenadas: - Datos de salida: " + respuesta);

		return respuesta;
	}

}
