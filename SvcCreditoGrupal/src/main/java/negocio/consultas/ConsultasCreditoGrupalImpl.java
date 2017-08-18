package negocio.consultas;

import java.util.List;

import org.oasisopen.sca.annotation.Reference;

import tarea.consultas.Consultas;
import transformador.Transformador;
import utilitario.buzon.AsignaTareaPropietarioPeticion;
import utilitario.buzon.AsignaTareaPropietarioRespuesta;
import utilitario.buzon.BuzonOV;
import utilitario.buzon.ConsultaBuzonPeticion;
import utilitario.buzon.TareaOV;
import utilitario.comun.GUIDGenerator;
import utilitario.log.LogHandler;
import utilitario.mensajes.administracion.contrato.ConcentradoActasRecaudacionPeticion;
import utilitario.mensajes.administracion.contrato.ConcentradoActasRecaudacionRespuesta;
import utilitario.mensajes.administracion.contrato.ResumenRecaudacionOV;
import utilitario.mensajes.comun.ConsultaCatalogoRespuestaCIOF;
import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.condonaciones.ConsultaDatosPeticion;
import utilitario.mensajes.condonaciones.ConsultaDatosRespuesta;
import utilitario.mensajes.consultas.AsentamientoOV;
import utilitario.mensajes.consultas.AsignacionDetalleOV;
import utilitario.mensajes.consultas.AsignacionDetalleRespuesta;
import utilitario.mensajes.consultas.AsignacionOV;
import utilitario.mensajes.consultas.AsignacionSucursalRespuesta;
import utilitario.mensajes.consultas.AutorizaReasignacionRespuesta;
import utilitario.mensajes.consultas.ClienteHistoricoRespuesta;
import utilitario.mensajes.consultas.ConsolidadoCreditosAsignadosOV;
import utilitario.mensajes.consultas.ConsolidadoCreditosAsignadosPeticion;
import utilitario.mensajes.consultas.ConsolidadoCreditosAsignadosRespuesta;
import utilitario.mensajes.consultas.ConsultaAnalista;
import utilitario.mensajes.consultas.ConsultaAsentamientoRespuesta;
import utilitario.mensajes.consultas.ConsultaCATPeticion;
import utilitario.mensajes.consultas.ConsultaCATRespuesta;
import utilitario.mensajes.consultas.ConsultaCreditoPeticion;
import utilitario.mensajes.consultas.ConsultaCreditosSinAsignarRespuesta;
import utilitario.mensajes.consultas.ConsultaDatosClientePeticion;
import utilitario.mensajes.consultas.ConsultaDatosClienteRespuesta;
import utilitario.mensajes.consultas.ConsultaDatosImagenesMonitorPeticion;
import utilitario.mensajes.consultas.ConsultaDatosImagenesMonitorRespuesta;
import utilitario.mensajes.consultas.ConsultaDatosPromediosMonitorPeticion;
import utilitario.mensajes.consultas.ConsultaDatosPromediosMonitorRespuesta;
import utilitario.mensajes.consultas.ConsultaOportunidadPeticion;
import utilitario.mensajes.consultas.ConsultaOportunidadRespuesta;
import utilitario.mensajes.consultas.ConsultaReferenciasPagoPeticion;
import utilitario.mensajes.consultas.ConsultaReferenciasPagoRespuesta;
import utilitario.mensajes.consultas.ConsultaSISEFINPeticion;
import utilitario.mensajes.consultas.ConsultaSISEFINRespuesta;
import utilitario.mensajes.consultas.ConsultaSaldosAFavorAjustadosPeticion;
import utilitario.mensajes.consultas.ConsultaSaldosAFavorAjustadosRespuesta;
import utilitario.mensajes.consultas.ConsultaSaldosAFavorCreditosVigentesPeticion;
import utilitario.mensajes.consultas.ConsultaSaldosAFavorCreditosVigentesRespuesta;
import utilitario.mensajes.consultas.ConsultaSaldosAFavorPeticion;
import utilitario.mensajes.consultas.ConsultaSaldosAFavorRespuesta;
import utilitario.mensajes.consultas.ConsultarCreditosAsignadosPeticion;
import utilitario.mensajes.consultas.ConsultarCreditosAsignadosRespuesta;
import utilitario.mensajes.consultas.ConsultarMovimientosPeticion;
import utilitario.mensajes.consultas.ConsultarMovimientosRespuesta;
import utilitario.mensajes.consultas.ConsultarReasignacionesContratoPeticion;
import utilitario.mensajes.consultas.ConsultarReasignacionesContratoRespuesta;
import utilitario.mensajes.consultas.ConsultarReasignacionesMultiplesRespuesta;
import utilitario.mensajes.consultas.ConsultarReasignacionesPeticion;
import utilitario.mensajes.consultas.ConsultarReasignacionesRespuesta;
import utilitario.mensajes.consultas.ConsultarSolicitudesRespuesta;
import utilitario.mensajes.consultas.CreditosAsignadosOV;
import utilitario.mensajes.consultas.DatosClienteRespuesta;
import utilitario.mensajes.consultas.DatosCreditoIntegrantesRespuesta;
import utilitario.mensajes.consultas.DatosCreditoRespuesta;
import utilitario.mensajes.consultas.DatosImagenesMonitorOV;
import utilitario.mensajes.consultas.DatosPromediosMonitorOV;
import utilitario.mensajes.consultas.DesembolsoOpenContractRespuesta;
import utilitario.mensajes.consultas.DetallesAgendaOV;
import utilitario.mensajes.consultas.GeneraActaRecaudacionRespuesta;
import utilitario.mensajes.consultas.GrupoHistoricoRespuesta;
import utilitario.mensajes.consultas.PeticionRFCOV;
import utilitario.mensajes.consultas.ReferenciasPeticion;
import utilitario.mensajes.consultas.ReferenciasRespuestaPaybin;
import utilitario.mensajes.consultas.ReporteAsistencias;
import utilitario.mensajes.consultas.ReporteDatosClientePeticion;
import utilitario.mensajes.consultas.ReporteReasignacionesPeticion;
import utilitario.mensajes.consultas.RespuestaRFCOV;
import utilitario.mensajes.consultas.ValidarRelacionPersonaContratoPeticion;
import utilitario.mensajes.consultas.ValidarRelacionPersonaContratoRespuesta;
import utilitario.mensajes.consultas.VerificaAsignacionRespuesta;
import utilitario.mensajes.operacion.ActaRecaudacionClienteOV;
import utilitario.mensajes.operacion.ActaRecaudacionOV;
import utilitario.mensajes.operacion.ActaRecaudacionParcialidadOV;
import utilitario.mensajes.operacion.RegistrOperacionesPeticion;
import utilitario.mensajes.operacion.RegistrOperacionesRespuesta;
import utilitario.mensajes.operacion.pagos.oxxo.PeticionEnLineaOxxo;
import utilitario.mensajes.operacion.pagos.oxxo.RespuestaConsultaEnLineaOxxo;
import utilitario.mensajes.originacion.consulta.ConsultaDiaHabilPeticion;
import utilitario.mensajes.originacion.consulta.ConsultaDiaHabilRespuesta;
import utilitario.mensajes.originacion.consulta.ConsultaDiasInhabilesPeticion;
import utilitario.mensajes.originacion.consulta.ObtenerDiasInhabilesRespuesta;
import utilitario.mensajes.reportes.cierre.ReporteDesembolsoPeticion;


public class ConsultasCreditoGrupalImpl implements ConsultasCreditoGrupal {
	/**
	 * SCA Component Fabric
	 */
	private Consultas consultas;
	/**
	 * SCA Component Fabric
	 */
	private Transformador transformador;

	/**
	 * SCA Component Fabric
	 * @param consultas :
	 * @param transformador :
	 */
	public ConsultasCreditoGrupalImpl(
			@Reference(name = "consultas") Consultas consultas,
			@Reference(name = "transformador") Transformador transformador) {
		this.consultas = consultas;
		this.transformador = transformador;
 		}

	/**
	 * @param peticion de solicitud
	 * @return respuesta
	 */
	public DatosCreditoRespuesta obtenerDatosCredito(ConsultaCreditoPeticion peticion) {
		final String uid = GUIDGenerator.generateGUID(peticion.getContrato() );
		LogHandler.info(uid, getClass(), "obtenerDatosCredito - Datos de entrada : " + peticion);

		//Se genera la salida
		final DatosCreditoRespuesta datosCreditoRespuesta = consultas.obtenerDatosCredito(uid, peticion);
		LogHandler.info(uid, getClass(), "obtenerDatosCredito - Datos de salida : " + datosCreditoRespuesta);
		return datosCreditoRespuesta;
	}

	/**
	 * @param peticion de solicitud
	 * @return respuesta
	 */
	public DatosCreditoIntegrantesRespuesta obtenerDatosCreditoIntegrantes(ConsultaCreditoPeticion peticion) {
		final String uid = GUIDGenerator.generateGUID(peticion.getContrato() );
		LogHandler.info(uid, getClass(), "obtenerDatosCreditoIntegrantes - Datos de entrada : " + peticion);

		//Objeto de salida
		final 	DatosCreditoIntegrantesRespuesta
				datosCreditoIntegrantesRespuesta = consultas.obtenerDatosCreditoIntegrantes(uid, peticion);
		return datosCreditoIntegrantesRespuesta;
	}

	/**
	 * @param peticion :
	 * @return ConsultaDatosRespuesta
	 */
	public ConsultaDatosRespuesta consultaDatosSaldoVencido(ConsultaDatosPeticion peticion) {
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "consultaDatosSaldoVencido - Datos de entrada : " + peticion);

		//Se genera la salida
		final ConsultaDatosRespuesta consultaDatosRespuesta = consultas.consultarDatosSaldoVencido(uid, peticion);
		LogHandler.info(uid, getClass(), "consultaDatosSaldoVencido - Datos de salida : " + consultaDatosRespuesta);
		return consultaDatosRespuesta;
	}

	/**
	 * @param peticion :
	 * @return ConsultaOportunidadRespuesta
	 */
	public ConsultaOportunidadRespuesta consultaContratoOportunidad(ConsultaOportunidadPeticion peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "consultaContratoOportunidad - Datos de entrada : " + peticion);

		//Salida
		final	ConsultaOportunidadRespuesta
				consultaOportunidadRespuesta = consultas.consultaContratoOportunidad(peticion, uid);
		LogHandler.info(uid, getClass(), "consultaContratoOportunidad - Datos de salida : " + consultaOportunidadRespuesta);
		return consultaOportunidadRespuesta;
	}

	/**
	 * @param peticion :
	 * @return ConsultaDatosClienteRespuesta
	 */
	public ConsultaDatosClienteRespuesta consultaDatosCliente(ConsultaDatosClientePeticion peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "consultaDatosCliente - Datos de entrada : " + peticion);

		//Salida
		final 	ConsultaDatosClienteRespuesta
				consultaDatosClienteRespuesta = consultas.consultaDatosCliente(peticion, uid);
		LogHandler.info(uid, getClass(), "consultaDatosCliente - Datos de salida : " + consultaDatosClienteRespuesta);
		return consultaDatosClienteRespuesta;
	}

	/**
	 * @param peticion de solicitud
	 * @return respuesta
	 */
	public DatosClienteRespuesta consultaClientes(ReporteDatosClientePeticion peticion)
		{
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "consultaClientes - Datos de entrada : " + peticion);

		//Salida
		final DatosClienteRespuesta datosClienteRespuesta = consultas.consultaClientes(peticion, uid);
		LogHandler.info(uid, getClass(), "consultaClientes - Datos de salida : " + datosClienteRespuesta);
		return datosClienteRespuesta;
		}

	/**
	 * @param peticion :
	 * @return DesembolsoOpenContractRespuesta
	 */
	public DesembolsoOpenContractRespuesta consultaDesembolso(ReporteDesembolsoPeticion peticion)
		{
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "consultaDesembolso - Datos de entrada : " + peticion);

		//Salida
		final DesembolsoOpenContractRespuesta	desembolsoOpenContractRespuesta = consultas.consultaDesembolso(peticion, uid);
		LogHandler.info(uid, getClass(), "consultaDesembolso - Datos de salida : " + desembolsoOpenContractRespuesta );
		return desembolsoOpenContractRespuesta;
		}

	/**
	 * @param peticion :
	 * @return ClienteHistoricoRespuesta
	 */
	public ClienteHistoricoRespuesta consultaHistorialCliente(ConsultaDatosClientePeticion peticion)
		{
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "consultaDatosGrupo - Datos de entrada : " + peticion);

		//Salida
		final ClienteHistoricoRespuesta clienteHistoricoRespuesta = consultas.consultaHistorialCliente(peticion, uid);
		LogHandler.info(uid, getClass(), "consultaDatosGrupo - Datos de salida : " + clienteHistoricoRespuesta);
		return clienteHistoricoRespuesta;
	}

	/**
	 * @param peticion :
	 * @return GrupoHistoricoRespuesta
	 */
	public GrupoHistoricoRespuesta consultaHistorialGrupo(ConsultaDatosClientePeticion peticion)
	{
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "consultaDatosGrupo - Datos de entrada : " + peticion);

		//Salida
		final GrupoHistoricoRespuesta grupoHistoricoRespuesta = consultas.consultaHistorialGrupo(peticion, uid);
		LogHandler.info(uid, getClass(), "consultaDatosGrupo - Datos de salida : " + grupoHistoricoRespuesta);
		return grupoHistoricoRespuesta;
	}

	/**
	 * @param peticion de solicitud
	 * @return respuesta
	 */
	public ConsultaSISEFINRespuesta consultaSISEFIN(ConsultaSISEFINPeticion peticion)
		{
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "consultaSISEFIN - Datos de entrada : " + peticion);

		//Se genera la salida
		final ConsultaSISEFINRespuesta consultaSISEFINRespuesta = consultas.consultaSISEFIN(peticion, uid);
		LogHandler.info(uid, getClass(), "consultaSISEFIN - Datos de salida : " + consultaSISEFINRespuesta);
		return consultaSISEFINRespuesta;
		}

	/**
	 * @param peticion :
	 * @return ConsultaSaldosAFavorRespuesta
	 */
	public ConsultaSaldosAFavorRespuesta consultaSaldosAFavor(ConsultaSaldosAFavorPeticion peticion)
		{
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "consultaSaldosAFavor - Datos de entrada : " + peticion);

		//Se genera la salida
		final ConsultaSaldosAFavorRespuesta consultaSaldosAFavorRespuesta = consultas.consultaSaldosAFavor(peticion, uid);
		LogHandler.info(uid, getClass(), "consultaSaldosAFavor - Datos de salida : " + consultaSaldosAFavorRespuesta);
		return consultaSaldosAFavorRespuesta;
		}

	/**
	 * @param peticion de solicitud
	 * @return respuesta
	 */
	public ConsultaDiaHabilRespuesta verificarDiaHabil(ConsultaDiaHabilPeticion peticion)
		{
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "verificarDiaHabil - Datos de entrada : " + peticion);

		//Se genera la salida
		final ConsultaDiaHabilRespuesta consultaDiaHabilRespuesta = consultas.verificarDiaHabil(peticion, uid);
		LogHandler.info(uid, getClass(), "verificarDiaHabil - Datos de salida : " + consultaDiaHabilRespuesta);
		return consultaDiaHabilRespuesta;
		}

	/**
	 * @param peticion :
	 * @return ObtenerDiasInhabilesRespuesta
	 */
	public ObtenerDiasInhabilesRespuesta obtenerDiasInhabiles(ConsultaDiasInhabilesPeticion peticion)
		{
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "obtenerDiasHabiles - Datos de entrada : " + peticion);

		//Se genera la salida
		final ObtenerDiasInhabilesRespuesta obtenerDiasInhabilesRespuesta = consultas.obtenerDiasInhabiles(peticion, uid);
		LogHandler.info(uid, getClass(), "obtenerDiasHabiles - Datos de salida : " + obtenerDiasInhabilesRespuesta);
		return obtenerDiasInhabilesRespuesta;
		}

	/**
	 * @param peticion de solicitud
	 * @return respuesta
	 */
	public ConsultaCATRespuesta consultarCAT(ConsultaCATPeticion peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "consultarCAT - Datos de entrada : " + peticion);

		//Se genera la salida
		final ConsultaCATRespuesta consultaCATRespuesta = consultas.consultarCAT(peticion, uid);
		LogHandler.info(uid, getClass(), "consultarCAT - Datos de salida : " + consultaCATRespuesta);
		return consultaCATRespuesta;
		}

	/**
	 * @param peticion :
	 * @return ConsultarMovimientosRespuesta
	 */
	public ConsultarMovimientosRespuesta consultarMovimientos(ConsultarMovimientosPeticion peticion)
		{
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "consultarMovimientos - Datos de entrada : " + peticion);

		//Se genera la salida
		final ConsultarMovimientosRespuesta consultarMovimientosRespuesta = consultas.consultarMovimientos(peticion, uid );
		LogHandler.info(uid, getClass(), "consultarMovimientos - Datos de salida : " + consultarMovimientosRespuesta);
		return consultarMovimientosRespuesta;
		}

	/**
	 * @param peticion :
	 * @return ConsultarCreditosAsignadosRespuesta
	 */
	public ConsultarCreditosAsignadosRespuesta consultarCreditosAsignados(ConsultarCreditosAsignadosPeticion peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "consultarCreditosAsignados - Datos de entrada : " + peticion);

		// Se genera la Salida.
		final ConsultarCreditosAsignadosRespuesta consultarCreditosAsignadosRespuesta
								= consultas.consultarCreditosAsignados(peticion, uid);
		LogHandler.info(uid, getClass(), "consultarCreditosAsignados - Datos de salida : " + consultarCreditosAsignadosRespuesta);
		return consultarCreditosAsignadosRespuesta;
	}

	/**
	 * @param peticion de solicitud
	 * @return respuesta
	 */
	public String consultarCreditosAsignadosXML(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "consultarCreditosAsignadosXML - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ConsultarCreditosAsignadosRespuesta.class,
								   ConsultarCreditosAsignadosPeticion.class,
								   CreditosAsignadosOV.class};

		//Conversion de XML a Object
		final ConsultarCreditosAsignadosPeticion
					consultarCreditosAsignadosPeticion =
						(ConsultarCreditosAsignadosPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultarCreditosAsignadosXML - Datos de entrada : "
										 + consultarCreditosAsignadosPeticion);

		//Llamado a funci�n principal
		final ConsultarCreditosAsignadosRespuesta respuesta =
				consultas.consultarCreditosAsignados(consultarCreditosAsignadosPeticion, uid);
		LogHandler.info(uid, getClass(), "consultarCreditosAsignadosXML - Datos de salida : " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "consultarCreditosAsignadosXML - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion :
	 * @return ConsolidadoCreditosAsignadosRespuesta
	 */
	public ConsolidadoCreditosAsignadosRespuesta consolidadoCreditosAsignados(
			ConsolidadoCreditosAsignadosPeticion peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "consolidadoCreditosAsignados - Datos de entrada : " + peticion);

		// Se genera la Salida.
		final ConsolidadoCreditosAsignadosRespuesta consolidadoCreditosAsignadosRespuesta =
							consultas.consolidadoCreditosAsignados(peticion, uid);
		LogHandler.info(uid, getClass(), "consolidadoCreditosAsignados - Datos de salida : "
										+ consolidadoCreditosAsignadosRespuesta);
		return consolidadoCreditosAsignadosRespuesta;
		}

	/**
	 * @param peticion de solicitud
	 * @return respuesta
	 */
	public String consolidadoCreditosAsignadosXML(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "consolidadoCreditosAsignadosXML - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ConsolidadoCreditosAsignadosPeticion.class,
								   ConsolidadoCreditosAsignadosOV.class};

		//Conversion de XML a Object
		final ConsolidadoCreditosAsignadosPeticion
					consolidadoCreditosAsignadosPeticion =
					(ConsolidadoCreditosAsignadosPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consolidadoCreditosAsignadosXML - Datos de entrada : "
										+ consolidadoCreditosAsignadosPeticion);

		//Llamado a funci�n principal
		final ConsolidadoCreditosAsignadosRespuesta respuesta =
						consultas.consolidadoCreditosAsignados(consolidadoCreditosAsignadosPeticion, uid);
		LogHandler.info(uid, getClass(), "consolidadoCreditosAsignadosXML - Datos de salida : " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "consolidadoCreditosAsignadosXML - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
		}

	/**
	 * @param peticion :
	 * @return ConsultarReasignacionesRespuesta
	 */
	public ConsultarReasignacionesRespuesta consultarReasignaciones(ConsultarReasignacionesPeticion peticion)
		{
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "consultarReasignaciones - Datos de entrada : " + peticion);

		//Se genera la salida
		final ConsultarReasignacionesRespuesta consultarReasignacionesRespuesta =
								consultas.consultarReasignaciones(peticion, uid );
		LogHandler.info(uid, getClass(), "consultarReasignaciones - Datos de salida : " + consultarReasignacionesRespuesta);
		return consultarReasignacionesRespuesta;
		}

	/**
	 * @param peticion :
	 * @return ConsultarReasignacionesContratoRespuesta
	 */
	public ConsultarReasignacionesContratoRespuesta
			consultarReasignacionesContrato(ConsultarReasignacionesContratoPeticion peticion)
		{
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "consultarReasignacionesContrato - Datos de entrada : " + peticion);

		//Se genera la salida
		final ConsultarReasignacionesContratoRespuesta consultarReasignacionesContratoRespuesta =
							consultas.consultarReasignacionesContrato(peticion, uid );
		LogHandler.info(uid, getClass(), "consultarReasignacionesContrato - Datos de salida : "
							+ consultarReasignacionesContratoRespuesta);
		return consultarReasignacionesContratoRespuesta;
		}

	/**
	 * @param peticion de solicitud
	 * @return respuesta
	 */
	public String generaActasRecaudacionXML(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "generaActasRecaudacionXML - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ConsultaCreditoPeticion.class,
								   ActaRecaudacionOV.class,
                				   ActaRecaudacionParcialidadOV.class,
                				   ActaRecaudacionClienteOV.class,
                				   GeneraActaRecaudacionRespuesta.class};

		//Conversion de XML a Object
		final ConsultaCreditoPeticion
					consultaCreditoPeticion = (ConsultaCreditoPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "generaActasRecaudacionXML - Datos de entrada : " + consultaCreditoPeticion);

		//Llamado a funci�n principal
		final GeneraActaRecaudacionRespuesta respuesta = consultas.generaActasRecaudacion(consultaCreditoPeticion, uid );
		LogHandler.info(uid, getClass(), "generaActasRecaudacionXML - Datos de salida : " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "generaActasRecaudacionXML - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
		}

	/**
	 * @param peticion de solicitud
	 * @return respuesta
	 */
	public GeneraActaRecaudacionRespuesta generaActasRecaudacion(ConsultaCreditoPeticion peticion)
		{
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "generaActasRecaudacion - Datos de entrada : " + peticion);

		//Se genera la salida
		final GeneraActaRecaudacionRespuesta respuesta = consultas.generaActasRecaudacion(peticion, uid );
		LogHandler.info(uid, getClass(), "generaActasRecaudacion - Datos de salida : " + respuesta);
		return respuesta;
		}

	/**
	 * @param peticion :
	 * @return ConcentradoActasRecaudacionRespuesta
	 */
	public ConcentradoActasRecaudacionRespuesta concentradoActasRecaudacion(
			ConcentradoActasRecaudacionPeticion peticion) {
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "concentradoActasRecaudacion - Datos de entrada : " + peticion);

		//salida
		final ConcentradoActasRecaudacionRespuesta respuesta =
			consultas.concentradoActasRecaudacion(peticion, uid);
		LogHandler.info(uid, getClass(), "concentradoActasRecaudacion - Datos de salida : " + respuesta);
		return respuesta;
		}

	/**
	 * @param peticion de solicitud
	 * @return respuesta
	 */
	public java.lang.String concentradoActasRecaudacionXML(java.lang.String peticion)
		{
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "concentradoActasRecaudacion - Datos de entrada (XML): " + peticion);

		final Class<?> [] clases = {ConcentradoActasRecaudacionPeticion.class,
									ResumenRecaudacionOV.class,
									ConcentradoActasRecaudacionRespuesta.class};

		final ConcentradoActasRecaudacionPeticion concentradoActasRecaudacionPeticion =
							(ConcentradoActasRecaudacionPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "concentradoActasRecaudacion - Datos de entrada : "
										+ concentradoActasRecaudacionPeticion );

		final ConcentradoActasRecaudacionRespuesta respuesta =
							consultas.concentradoActasRecaudacion(concentradoActasRecaudacionPeticion, uid);
		LogHandler.info(uid, getClass(), "concentradoActasRecaudacion - Datos de saida : " + respuesta);

		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "concentradoActasRecaudacion - Datos de saida : " + respuestaXML);

		return respuestaXML;
		}

	/**
	 * @param peticion :
	 * @return ConsultarReasignacionesMultiplesRespuesta
	 */
	public ConsultarReasignacionesMultiplesRespuesta consultarReasignacionesMultiples(ReporteReasignacionesPeticion peticion)
		{
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "consultarReasignacionesMultiples - Datos de entrada : " + peticion);

		//Se genera la salida
		final ConsultarReasignacionesMultiplesRespuesta respuesta = consultas.consultarReasignacionesMultiples(peticion, uid);
		LogHandler.info(uid, getClass(), "consultarReasignacionesMultiples - Datos de salida : " + respuesta);
		return respuesta;
		}

	/**
	 * @param peticion :
	 * @return ConsultarSolicitudesRespuesta
	 */
	public ConsultarSolicitudesRespuesta consultarSolicitudesReasignacion(ReporteReasignacionesPeticion peticion)
		{
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "consultarSolicitudesReasignacion - Datos de entrada : " + peticion);

		//Se genera la salida
		final ConsultarSolicitudesRespuesta respuesta = consultas.consultarSolicitudesReasignacion(peticion, uid);
		LogHandler.info(uid, getClass(), "consultarSolicitudesReasignacion - Datos de salida : " + respuesta);
		return respuesta;
		}

	/**
	 * @param peticion :
	 * @return ConsultaCreditosSinAsignarRespuesta
	 */
	public ConsultaCreditosSinAsignarRespuesta consultaCreditosSinAsignar(
			ReporteReasignacionesPeticion peticion) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "consultarCreditosSinAsignar - Datos de entrada : " + peticion);

		//Se genera la salida
		final ConsultaCreditosSinAsignarRespuesta respuesta = consultas.consultaCreditosSinAsignar(peticion, uid);
		LogHandler.info(uid, getClass(), "consultarCreditosSinAsignar - Datos de salida : " + respuesta);
		return respuesta;
	}

	/**
	 * @param peticion :
	 * @return ConsultaCreditosSinAsignarRespuesta
	 */
	public ConsultaSaldosAFavorCreditosVigentesRespuesta
		consultaSaldosAFavorCreditosVigentes(ConsultaSaldosAFavorCreditosVigentesPeticion peticion)
		{
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "consultaSaldosAFavorCreditosVigentes - Datos de entrada : " + peticion);

		//Se genera la salida
		final ConsultaSaldosAFavorCreditosVigentesRespuesta respuesta =
							consultas.consultaSaldosAFavorCreditosVigentes(peticion, uid );
		LogHandler.info(uid, getClass(), "consultaSaldosAFavorCreditosVigentes - Datos de salida : " + respuesta);
		return respuesta;
		}


	/* Consulta RING Ajuste Saldo a Favor */
	/**
	 * @param peticion de solicitud
	 * @return respuesta
	 */
	public ConsultaSaldosAFavorAjustadosRespuesta consultaSaldosAFavorAjustados(ConsultaSaldosAFavorAjustadosPeticion peticion)
	{
	final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
	LogHandler.info(uid, getClass(), "consultaSaldosAFavorCreditosVigentes - Datos de entrada : " + peticion);

	//Se genera la salida
	final ConsultaSaldosAFavorAjustadosRespuesta respuesta = consultas.consultaSaldosAFavorAjustados(peticion, uid );
	LogHandler.info(uid, getClass(), "consultaSaldosAFavorCreditosVigentes - Datos de salida : " + respuesta);
	return respuesta;
	}


	/**
	 * @param peticion :
	 * @return ConsultaReferenciasPagoRespuesta
	 */
	public ConsultaReferenciasPagoRespuesta consultaReferenciasPago(ConsultaReferenciasPagoPeticion peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "consultaReferenciasPago - Datos de entrada : " + peticion);

		//Se genera la salida
		final ConsultaReferenciasPagoRespuesta respuesta = consultas.consultaReferenciasPago(peticion, uid );
		LogHandler.info(uid, getClass(), "consultaReferenciasPago - Datos de salida : " + respuesta);
		return respuesta;
	}

	/*
	public RegistroAsentamientoRespuesta registroAsentamiento(AsentamientoOV peticion){

		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "consultaSaldosAFavorCreditosVigentes - Datos de entrada : " + peticion);
		RegistroAsentamientoRespuesta respuesta = new RegistroAsentamientoRespuesta();

		return respuesta;

	}

	public ConsultaAsentamientoRespuesta consultaAsentamientosEstados(){

		final java.lang.String uid  = GUIDGenerator.generateGUID( null );
		LogHandler.info(uid, getClass(), "consultaEstadosAsentamientos - Datos de entrada : " );
		final ConsultaAsentamientoRespuesta respuesta = consultas.consultaEstadosAsentamientos( uid );
		LogHandler.info(uid, getClass(), "consultaEstadosAsentamientos - Datos de salida : " + respuesta);
		return respuesta;
	}
	*/

	/**
	 * @param peticion :
	 * @return ConsultaAsentamientoRespuesta
	 */
	public ConsultaAsentamientoRespuesta consultaAsentamientos(AsentamientoOV peticion) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(null);
		//LogHandler.info(uid, getClass(), "consultaAsentamientos - Datos de entrada : " );
		final ConsultaAsentamientoRespuesta respuesta = consultas.consultaAsentamientos(uid, peticion );
		//LogHandler.info(uid, getClass(), "consultaAsentamientos - Datos de salida : " + respuesta);
		return respuesta;
	}


	//AGENDDAS

	/**
	 * Obtiene el consolidado por sucursal, con horarios correctos e incorrectos.
	 * @param peticion :
	 * @return ConsultaAsentamientoRespuesta
	 */
	public String asignacionConsolidadoSucursal(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "asignacionConsolidadoSucursal - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {AsignacionOV.class,
									AsignacionSucursalRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final AsignacionOV   peticionAdignacion	=
			(AsignacionOV) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "asignacionConsolidadoSucursal - Datos de entrada : " + peticionAdignacion);

		//Llamado a funci�n principal
		final AsignacionSucursalRespuesta respuesta = consultas.asignacionConsolidadoSucursal(uid, peticionAdignacion);
		LogHandler.info(uid, getClass(), "asignacionConsolidadoSucursal - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "asignacionConsolidadoSucursal - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}


	/**
	 * @param peticion de solicitud
	 * @return respuesta XML
	 */
	public String asignacionDetalleSucursal(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "asignacionDetalleSucursal - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {AsignacionDetalleOV.class,
									AsignacionDetalleRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final AsignacionDetalleOV   peticionAsignacionDetalle =
			(AsignacionDetalleOV) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "asignacionDetalleSucursal - Datos de entrada : " + peticionAsignacionDetalle);

		//Llamado a funci�n principal
		final AsignacionDetalleRespuesta respuesta =
			consultas.asignacionDetalleSucursalTarea(uid, peticionAsignacionDetalle);
		LogHandler.info(uid, getClass(), "asignacionDetalleSucursal - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "asignacionDetalleSucursal - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}


	/**
	 * @param peticion de solicitud
	 * @return respuesta XML
	 */
	public String asignacionDetalleAsesor(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "asignacionDetalleAsesor - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {AsignacionDetalleOV.class,
									DetallesAgendaOV.class,
									AsignacionDetalleRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final AsignacionDetalleOV   peticionAsignacionDetalle =
			(AsignacionDetalleOV) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "asignacionDetalleAsesor - Datos de entrada : " + peticionAsignacionDetalle);

		//Llamado a funci�n principal
		final AsignacionDetalleRespuesta respuesta =
			consultas.asignacionDetalleAsesorTarea(uid, peticionAsignacionDetalle);
		LogHandler.info(uid, getClass(), "asignacionDetalleAsesor - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		return respuestaXML;
	}

	/**
	 * @param peticion de solicitud
	 * @return respuesta XML
	 */
	public String validaAsignacion(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "validaAsignacion - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {AsignacionDetalleOV.class,
							VerificaAsignacionRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final AsignacionDetalleOV   peticionVerificaAsignacion =
			(AsignacionDetalleOV) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "validaAsignacion - Datos de entrada : " + peticionVerificaAsignacion);

		//Llamado a funci�n principal
		final VerificaAsignacionRespuesta respuesta = consultas.validaAsignacionTarea(uid, peticionVerificaAsignacion);
		LogHandler.info(uid, getClass(), "validaAsignacion - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "validaAsignacion - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion de solicitud
	 * @return respuesta XML
	 */
	public String modificaAsignacion(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "modificaAsignacion - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {AsignacionDetalleOV.class,
							VerificaAsignacionRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final AsignacionDetalleOV   peticionActualizaAsignacion =
			(AsignacionDetalleOV) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "modificaAsignacion - Datos de entrada : " + peticionActualizaAsignacion);

		//Llamado a funci�n principal
		final VerificaAsignacionRespuesta respuesta =
			consultas.modificaAsignacionTarea(uid, peticionActualizaAsignacion);
		LogHandler.info(uid, getClass(), "modificaAsignacion - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		return respuestaXML;

	}

	/**
	 * Metodo para consultar las tareas del buzon.
	 * @param peticion :
	 * @return String
	 */
	public String consultaBuzonTareas(String peticion ) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "consultaBuzonTareas - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ConsultaBuzonPeticion.class,
								   BuzonOV.class,
								   TareaOV.class,
								   EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ConsultaBuzonPeticion   peticionBuzon =
			(ConsultaBuzonPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultaBuzonTareas - Datos de entrada : " + peticionBuzon);

		//Para solo mostrar reasignacion de cartera en el actual buzon.
		peticionBuzon.setTipoTarea("TREC");

		//Llamado a funci�n principal
		final BuzonOV respuesta =
			consultas.consultaBuzonTareas(uid, peticionBuzon);
		LogHandler.info(uid, getClass(), "consultaBuzonTareas - Datos de salida: ");

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);		
		return respuestaXML;
	}


	/**
	 * Asigna la tarea pendiente a un usuario.
	 * @param peticion :
	 * @return String
	 */
	public String asignaTareaPropietario(String peticion ) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "asignaTareaPropietario - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {AsignaTareaPropietarioPeticion.class,
								   AsignaTareaPropietarioRespuesta.class,
								   EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final AsignaTareaPropietarioPeticion   peticionAsignaPropietario =
			(AsignaTareaPropietarioPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "asignaTareaPropietario - Datos de entrada : " + peticionAsignaPropietario);

		//Llamado a funci�n principal
		final AsignaTareaPropietarioRespuesta respuesta =
			consultas.asignaTareaPropietario(uid, peticionAsignaPropietario);
		LogHandler.info(uid, getClass(), "asignaTareaPropietario - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "asignaTareaPropietario - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion de solicitud
	 * @return respuesta XML
	 */
	public String autorizaReasignacion(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "autorizaReasignacion - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {AsignacionDetalleOV.class,
									AutorizaReasignacionRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final AsignacionDetalleOV   peticionAutorizaReasignacion =
			(AsignacionDetalleOV) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "autorizaReasignacion - Datos de entrada : " + peticionAutorizaReasignacion);

		//Llamado a funci�n principal
		final AutorizaReasignacionRespuesta respuesta =
			consultas.autorizaReasignacionTarea(uid, peticionAutorizaReasignacion);
		LogHandler.info(uid, getClass(), "autorizaReasignacion - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "asignacionDetalleSucursal - Datos de salida XML: " + respuestaXML);
		return respuestaXML;

	}

	//OPERFIN-128 2014-01-21

	/**
	 * @param peticion de solicitud
	 * @return respuesta
	 */
	public DatosCreditoIntegrantesRespuesta obtenerDatosCreditoIntegrantesCompleto(ConsultaCreditoPeticion peticion) {
		final String uid = GUIDGenerator.generateGUID(peticion.getContrato() );
		LogHandler.info(uid, getClass(), "obtenerDatosCreditoIntegrantesCompleto - Datos de entrada : " + peticion);

		//Objeto de salida
		final 	DatosCreditoIntegrantesRespuesta
				datosCreditoIntegrantesRespuesta = consultas.obtenerDatosCreditoIntegrantesCompleto(uid, peticion);
		LogHandler.info(uid, getClass(), "obtenerDatosCreditoIntegrantesCompleto - Datos de salida : "
				+ datosCreditoIntegrantesRespuesta);
		return datosCreditoIntegrantesRespuesta;
	}

	/**
	 * @param peticion de solicitud
	 * @return respuesta XML
	 */
	public String consultaBuzonTareaPerfil(String peticion) {
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "consultaBuzonTareaPerfil - Datos de entrada : " + peticion);

		//Objeto de salida
		final 	String
				respuesta = consultas.consultaBuzonTareaPerfilTarea(uid, peticion);
		LogHandler.info(uid, getClass(), "consultaBuzonTareaPerfil - Datos de salida : " + respuesta);
		return respuesta;
	}

	/**
	 * @param peticion de solicitud
	 * @return respuesta XML
	 */
	public String terminarBuzonTarea(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "terminarBuzonTarea - Datos de entrada XML: " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {TareaOV.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final TareaOV   peticionOV =
			(TareaOV) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "terminarBuzonTarea - Datos de entrada : " + peticionOV);

		//Llamado a funci�n principal
		final EncabezadoRespuesta respuesta =
			consultas.terminarBuzonTarea(uid, null, peticionOV);
		LogHandler.info(uid, getClass(), "terminarBuzonTarea - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "terminarBuzonTarea - Datos de salida XML: " + respuestaXML);
		return respuestaXML;

	}

	/**
	 * @param peticion :
	 * @return respuesta :
	 */
	public RespuestaRFCOV generaRFC(PeticionRFCOV peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "generaRFC - Datos de entrada : " + peticion);

		//Se genera la salida
		final RespuestaRFCOV respuesta = consultas.generaRFCTarea(uid, peticion);
		LogHandler.info(uid, getClass(), "generaRFC - Datos de salida : " + respuesta);
		return respuesta;
	}

	/**
	 * @param peticion de solicitud
	 * @return respuesta XML
	 */
	public String consultaDatosImagenesMonitor(String peticion) {

		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "consultaDatosImagenesMonitor - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ConsultaDatosImagenesMonitorPeticion.class,
									ConsultaDatosImagenesMonitorRespuesta.class,
									DatosImagenesMonitorOV.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ConsultaDatosImagenesMonitorPeticion consultaDatosImagenesMonitorPeticion =
			(ConsultaDatosImagenesMonitorPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultaDatosImagenesMonitor - Datos de entrada : "
			+ consultaDatosImagenesMonitorPeticion);

		//Llamado a funci�n principal
		final ConsultaDatosImagenesMonitorRespuesta respuesta
		= consultas.consultaDatosImagenesMonitorTarea(uid, consultaDatosImagenesMonitorPeticion);
		LogHandler.info(uid, getClass(), "consultaDatosImagenesMonitor - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "consultaDatosImagenesMonitor - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion de solicitud
	 * @return respuesta XML
	 */
	public String consultaDatosPromediosMonitor(String peticion) {

		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "consultaDatosPromediosMonitor - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ConsultaDatosPromediosMonitorPeticion.class,
									ConsultaDatosPromediosMonitorRespuesta.class,
									DatosPromediosMonitorOV.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ConsultaDatosPromediosMonitorPeticion consultaDatosPromediosMonitorPeticion =
			(ConsultaDatosPromediosMonitorPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultaDatosImagenesMonitor - Datos de entrada : "
			+ consultaDatosPromediosMonitorPeticion);

		//Llamado a funci�n principal
		final ConsultaDatosPromediosMonitorRespuesta respuesta
		= consultas.consultaDatosPromediosMonitorTarea(uid, consultaDatosPromediosMonitorPeticion);
		LogHandler.info(uid, getClass(), "consultaDatosPromediosMonitor - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "consultaDatosPromediosMonitor - Datos de salida XML: " + respuestaXML);
		return respuestaXML;

	}

	/**
	 * @param peticion de solicitud
	 * @return respuesta XML
	 */
	public String validaRelacionPersonaContrato(
			String peticion) {


		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "validaRelacionPersonaContratoTarea - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ValidarRelacionPersonaContratoPeticion.class,
									ValidarRelacionPersonaContratoRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ValidarRelacionPersonaContratoPeticion validarRelacionPersonaContratoPeticion =
			(ValidarRelacionPersonaContratoPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "validaRelacionPersonaContratoTarea - Datos de entrada : "
			+ validarRelacionPersonaContratoPeticion);

		//Llamado a funci�n principal
		final ValidarRelacionPersonaContratoRespuesta respuesta
		= consultas.validaRelacionPersonaContratoTarea(uid, validarRelacionPersonaContratoPeticion);
		LogHandler.info(uid, getClass(), "validaRelacionPersonaContratoTarea - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "validaRelacionPersonaContratoTarea - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticion de solicitud
	 * @return respuesta
	 */
	public DatosCreditoIntegrantesRespuesta obtenerSaldosFinanciadosIntegrantes(ConsultaCreditoPeticion peticion) {
		final String uid = GUIDGenerator.generateGUID(peticion.getContrato() );
		LogHandler.info(uid, getClass(), "obtenerSaldosFinanciadosIntegrantes - Datos de entrada : " + peticion);

		//Objeto de salida
		final 	DatosCreditoIntegrantesRespuesta
				datosCreditoIntegrantesRespuesta = consultas.obtenerSaldosFinanciadosIntegrantesTarea(uid, peticion);
		LogHandler.info(uid, getClass(), "obtenerSaldosFinanciadosIntegrantes - Datos de salida : "
				+ datosCreditoIntegrantesRespuesta);
		return datosCreditoIntegrantesRespuesta;
	}

	/**
	 * @param contrato contrato de la peticion para calcular el CAT
	 * @return CAT
	 */
	public ConsultaCATRespuesta calcularCATContrato(String contrato ) {
		final String uid = GUIDGenerator.generateGUID(contrato );
		LogHandler.info(uid, getClass(), "calcularCATContrato - Datos de entrada : " + contrato);

		//Objeto de salida
		final 	ConsultaCATRespuesta
				respuesta = consultas.calcularCATContrato(uid, contrato);
		LogHandler.info(uid, getClass(), "calcularCATContrato - Datos de salida : "
				+ respuesta);
		return respuesta;

	}

	/**
	 * Esta operaci&oacute;n permite obtener la informaci&oacute;n del cliente
	 * a trav&eacute;s del ID que lo identifica que en este caso es el contrato.
	 * @param uid identificador &uacute;nico de transacci&oacute;n.
	 * @param peticion datos de la consulta
	 * @return RespuestaConsultaEnLineaOxxo respuesta de la consulta.
	 */
	public RespuestaConsultaEnLineaOxxo consultaEnLineaOxxo(String uid, PeticionEnLineaOxxo peticion) {
		LogHandler.info(uid, getClass(), "consultaEnLineaOxxo - Datos de entrada : " + peticion);

		//Objeto de salida
		final RespuestaConsultaEnLineaOxxo
			respuesta = consultas.consultaEnLineaOxxoTarea(uid, peticion);
		LogHandler.info(uid, getClass(), "consultaEnLineaOxxo - Datos de salida : "
				+ respuesta);
		return respuesta;
	}

	/**
	 * Metodo para obtener el catalog de analistas
	 * @param uid log
	 * @param peticion codigo
	 * @return lista de analistas
	 */
	public ConsultaCatalogoRespuestaCIOF consultaCatalogoAnalistas(String uid,
			String peticion) {
		LogHandler.info(uid, getClass(), "consultaCatalogoAnalistas - Datos de entrada : " + peticion);
		final ConsultaCatalogoRespuestaCIOF
			respuesta = consultas.consultaCatalogoAnalistas(uid, peticion);
		LogHandler.info(uid, getClass(), "consultaCatalogoAnalistas - Datos de salida : "
				+ respuesta);
		return respuesta;
	}

	/**
	 * Metodo que permite obtener la consulta del reporte de Asistencia para el CEC
	 *
	 * @param uid Identificador Unico de Transaccion
	 * @param fechaPeticion de la consulta
	 * @return ReporteAsistencias respuesta de la consulta.
	 */
	public ReporteAsistencias consultaReporteAsistencia(String uid,  String fechaPeticion) {

		//Objeto de salida
		final ReporteAsistencias respuesta = consultas.consultaReporteAsistenciaTarea(uid, fechaPeticion);

		LogHandler.info(uid, getClass(), "consultaReporteAsistencia - Datos de salida : " + respuesta);
		return respuesta;
	}

	/**
	 * Metodo donde se registra la operacion  de inicio y fin de seciones
	 * @param uid id unico de transaccion
	 * @param peticion peticion
	 * @return RegistrOperacionesRespuesta respuesta
	 */
	public RegistrOperacionesRespuesta registrarOperacion(String uid, RegistrOperacionesPeticion peticion) {
		LogHandler.info(uid, getClass(), "registrarOperacion - Datos de entrada : " + peticion);

		final RegistrOperacionesRespuesta respuesta = consultas.registrarOperacion(uid, peticion);

		LogHandler.info(uid, getClass(), "registrarOperacion - Datos de salida : " + respuesta);

		return respuesta;
	}

	/**
	 * Obtener cadena PayBin.
	 *
	 * @param peticion The ReferenciasPeticion
	 * @return the string Cadena de PayBin
	 */
	public ReferenciasRespuestaPaybin obtenerCadenaPaybinSACG(ReferenciasPeticion peticion) {
		final String uid = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "obtenerCadenaPaybinSACG - Datos de entrada : " + peticion);

		final ReferenciasRespuestaPaybin respuesta = consultas.obtenerCadenaPaybin(uid, peticion);

		LogHandler.info(uid, getClass(), "obtenerCadenaPaybinSACG - Datos de salida : " + respuesta);

		return respuesta;
	}
	
	/**
	 * Metodo de consutla de analista de sucursal
	 * @param uid : id unico de transaccion 
	 * @param sucursal : numero de la sucursal
	 * @return List<ConsultaAnalista> : lista de los analistas de esa sucursal.
	 */
	public List<ConsultaAnalista> consultaAnalistasPorSucursal( String uid, Integer sucursal) {
		if (uid == null) {
			uid  = GUIDGenerator.generateGUID(uid);
		}
		final List<ConsultaAnalista> respuesta = consultas.consultaAnalistasPorSucursal(uid, sucursal);
		return respuesta;
	}
}
