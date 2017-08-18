/**
 *
 */
package negocio.consultas;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import utilitario.mensajes.administracion.contrato.ConcentradoActasRecaudacionPeticion;
import utilitario.mensajes.administracion.contrato.ConcentradoActasRecaudacionRespuesta;
import utilitario.mensajes.comun.ConsultaCatalogoRespuestaCIOF;
import utilitario.mensajes.condonaciones.ConsultaDatosPeticion;
import utilitario.mensajes.condonaciones.ConsultaDatosRespuesta;
import utilitario.mensajes.consultas.AsentamientoOV;
import utilitario.mensajes.consultas.ClienteHistoricoRespuesta;
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
import utilitario.mensajes.consultas.DatosClienteRespuesta;
import utilitario.mensajes.consultas.DatosCreditoIntegrantesRespuesta;
import utilitario.mensajes.consultas.DatosCreditoRespuesta;
import utilitario.mensajes.consultas.DesembolsoOpenContractRespuesta;
import utilitario.mensajes.consultas.GeneraActaRecaudacionRespuesta;
import utilitario.mensajes.consultas.GrupoHistoricoRespuesta;
import utilitario.mensajes.consultas.PeticionRFCOV;
import utilitario.mensajes.consultas.ReferenciasPeticion;
import utilitario.mensajes.consultas.ReferenciasRespuestaPaybin;
import utilitario.mensajes.consultas.ReporteAsistencias;
import utilitario.mensajes.consultas.ReporteDatosClientePeticion;
import utilitario.mensajes.consultas.ReporteReasignacionesPeticion;
import utilitario.mensajes.consultas.RespuestaRFCOV;
import utilitario.mensajes.operacion.RegistrOperacionesPeticion;
import utilitario.mensajes.operacion.RegistrOperacionesRespuesta;
import utilitario.mensajes.operacion.pagos.oxxo.PeticionEnLineaOxxo;
import utilitario.mensajes.operacion.pagos.oxxo.RespuestaConsultaEnLineaOxxo;
import utilitario.mensajes.originacion.consulta.ConsultaDiaHabilPeticion;
import utilitario.mensajes.originacion.consulta.ConsultaDiaHabilRespuesta;
import utilitario.mensajes.originacion.consulta.ConsultaDiasInhabilesPeticion;
import utilitario.mensajes.originacion.consulta.ObtenerDiasInhabilesRespuesta;
import utilitario.mensajes.reportes.cierre.ReporteDesembolsoPeticion;

/**
 * @version 1.0.0
 * @author oarias
 *
 */
@WebService(name = "ConsultasCreditoGrupal", targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0")
public interface ConsultasCreditoGrupal {

	/**
	 * Presenta los datos basicos de un contrato
	 * @param peticion :
	 * @return datos del contrato
	 */
	public DatosCreditoRespuesta obtenerDatosCredito(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/obtenerDatosCredito")
			ConsultaCreditoPeticion peticion);

	/**
	 * Presenta los datos basicos de un contrato junto con datos basicos de sus integrantes
	 * @param peticion :
	 * @return datos del contrato e integrantes
	 */
	public DatosCreditoIntegrantesRespuesta obtenerDatosCreditoIntegrantes(
 			@WebParam(name = "peticion",
 			targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/obtenerDatosCreditoIntegrantes")
 			ConsultaCreditoPeticion peticion);

	/**
	 *
	 * @param peticion :
	 * @return ConsultaDatosRespuesta
	 */
	public ConsultaDatosRespuesta consultaDatosSaldoVencido(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/consultaDatosSaldoVencido")
			ConsultaDatosPeticion peticion);

	/**
	 * Obtiene la infoamci�n basica de un cliente unico con un credito asignado.
	 * @param peticion :
	 * @return ConsultaDatosClienteRespuesta
	 */
	public ConsultaDatosClienteRespuesta consultaDatosCliente(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/consultaDatosCliente")
			ConsultaDatosClientePeticion peticion);

	/**
	 * Obtiene la informacion historica de la relacion contrato-cliente
	 * @param peticion :
	 * @return ClienteHistoricoRespuesta
	 */
	public ClienteHistoricoRespuesta consultaHistorialCliente(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/consultaHistorialCliente")
			ConsultaDatosClientePeticion peticion);


	/**
	 * Obtiene la informacion basica de los clientes realizando una busqueda por parametros especificos.
	 * @param peticion :
	 * @return DatosClienteRespuesta
	 */
	public DatosClienteRespuesta consultaClientes(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/consultaClientes")
			ReporteDatosClientePeticion peticion);

	/**
	 * El reporte de desembolso OpenContrat modificado para ser una consulta
	 * @param peticion :
	 * @return DesembolsoOpenContractRespuesta
	 */
	public DesembolsoOpenContractRespuesta consultaDesembolso(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/consultaDesembolsoOpenContract")
			ReporteDesembolsoPeticion peticion );

	/**
	 * Realiza la consulta por LD para saber si es tipo oportunidad
	 * @param peticion :
	 * @return ConsultaOportunidadRespuesta
	 */
	public ConsultaOportunidadRespuesta consultaContratoOportunidad(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/consultaContratoOportunidad")
			ConsultaOportunidadPeticion peticion);

	/**
	 *
	 * @param peticion :
	 * @return GrupoHistoricoRespuesta
	 */
	public GrupoHistoricoRespuesta consultaHistorialGrupo(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/consultaHistorialGrupo")
			ConsultaDatosClientePeticion peticion);

	/**
	 * Consulta para obtener datos para SISEFIN
	 * @param peticion :
	 * @return ConsultaSISEFINRespuesta
	 */
	public ConsultaSISEFINRespuesta consultaSISEFIN(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/consultaSISEFIN")
			ConsultaSISEFINPeticion peticion);

	/**
	 * Consulta para obtener la lista de contratos con saldos a favor de
	 * una sucursal determinada
	 * @param peticion :
	 * @return ConsultaSaldosAFavorRespuesta
	 */
	public ConsultaSaldosAFavorRespuesta consultaSaldosAFavor(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/consultaSaldosAFavor")
			ConsultaSaldosAFavorPeticion peticion);

	/**
	 * Funcion para validar si un fecha ingresada es un dia habil
	 * @param peticion :
	 * @return ConsultaDiaHabilRespuesta
	 */
	public ConsultaDiaHabilRespuesta verificarDiaHabil(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/verificarDiaHabil")
			ConsultaDiaHabilPeticion peticion);

	/**
	 * M�todo que obtiene la lista de los dias habiles marcados para una sucursal y
	 * a partir de una fecha dadas
	 * @param peticion :
	 * @return ObtenerDiasInhabilesRespuesta
	 */
	public ObtenerDiasInhabilesRespuesta obtenerDiasInhabiles(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/obtenerDiasInhabiles")
			ConsultaDiasInhabilesPeticion peticion);

	/**
	 * M�todo para obtener el CAT, en base a la formula dada por BANXICO
	 * @param peticion :
	 * @return ConsultaCATRespuesta
	 */
	public ConsultaCATRespuesta consultarCAT(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/consultarCAT")
			ConsultaCATPeticion peticion );

	/**
	 * M�todo para realizar la consulta de los movimentos de un contrato dado
	 * @param peticion :
	 * @return ConsultarMovimientosRespuesta
	 */
	public ConsultarMovimientosRespuesta consultarMovimientos(
			@WebParam(name = "peticion",
				targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/consultarMovimientos")
			ConsultarMovimientosPeticion peticion );

	/**
	 * M�todo que realiza la Consulta de los Cr&eacute;ditos Asignados.
	 * @param peticion {@link ConsultarCreditosAsignadosPeticion}
	 * @return {@link ConsultarCreditosAsignadosRespuesta}
	 */
	public ConsultarCreditosAsignadosRespuesta consultarCreditosAsignados(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/consultarCreditosAsignados")
			ConsultarCreditosAsignadosPeticion peticion);

	/**
	 * M�todo que realiza la Consulta de los Cr&eacute;ditos Asignados, con acceso XML.
	 * @param peticion {@link java.lang.String}
	 * @return {@link java.lang.String}
	 */
	public java.lang.String consultarCreditosAsignadosXML(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/consultarCreditosAsignadosXML")
			java.lang.String peticion);

	/**
	 * M�todo que realiza la Consulta del Consolidado de Cr&eacute;ditos Asignados.
	 * @param peticion {@link ConsolidadoCreditosAsignadosPeticion}
	 * @return {@link ConsolidadoCreditosAsignadosRespuesta}
	 */
	public ConsolidadoCreditosAsignadosRespuesta consolidadoCreditosAsignados(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/consolidadoCreditosAsignados")
			ConsolidadoCreditosAsignadosPeticion peticion);

	/**
	 * M�todo que realiza la Consulta del Consolidado de Cr&eacute;ditos Asignados mediante XML.
	 * @param peticion {@link java.lang.String}
	 * @return {@link java.lang.String}
	 */
	public java.lang.String consolidadoCreditosAsignadosXML(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/consolidadoCreditosAsignadosXML")
			java.lang.String peticion);

	/**
	 * M�todo para consultar las reacciones de cartera realizadas
	 * @param peticion :
	 * @return ConsultarReasignacionesRespuesta
	 */
	public ConsultarReasignacionesRespuesta consultarReasignaciones(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/consultarReasignaciones")
			ConsultarReasignacionesPeticion peticion );

	/**
	 * M�todo para consultar el historial de un contrato dado
	 * @param peticion :
	 * @return GeneraActaRecaudacionRespuesta
	 */
	public ConsultarReasignacionesContratoRespuesta consultarReasignacionesContrato(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/consultarReasignacionesContrato")
			ConsultarReasignacionesContratoPeticion peticion );

	/**
	 * M�todo que genera las actas de recaudacion por contrato
	 * @param peticion :
	 * @return GeneraActaRecaudacionRespuesta
	 */
	public GeneraActaRecaudacionRespuesta generaActasRecaudacion(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/generaActasRecaudacion")
			ConsultaCreditoPeticion peticion );

	/**
	 * M�todo que genera las actas de recaudacion por contrato
	 * @param peticion :
	 * @return String
	 */
	public java.lang.String generaActasRecaudacionXML(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/generaActasRecaudacionXML")
			java.lang.String peticion );


	/**
	 * M�todo que genera el conentrado de las actas de recaudacion por contrato
	 * @param peticion :
	 * @return ConcentradoActasRecaudacionRespuesta
	 */
	public ConcentradoActasRecaudacionRespuesta concentradoActasRecaudacion(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/AdministracionCreditoGrupal/V1.0/concentradoActasRecaudacion")
			ConcentradoActasRecaudacionPeticion peticion);

	/**
	 * M�todo que genera el conentrado de las actas de recaudacion por contrato
	 * @param peticion :
	 * @return String
	 */
	public java.lang.String concentradoActasRecaudacionXML(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/AdministracionCreditoGrupal/V1.0/concentradoActasRecaudacionXML")
			java.lang.String peticion);

	/**
	 * M�todo para consultar el reporte de los contratos reasignados multiples ocaciones
	 * @param peticion {@link ConsultarReasignacionesMultiplesPeticion}
	 * @return {@link ConsultarReasignacionesMultiplesRespuesta}
	 */
	public ConsultarReasignacionesMultiplesRespuesta consultarReasignacionesMultiples(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/consultarReasignacionesMultiples")
			ReporteReasignacionesPeticion peticion );

	/**
	 * M�todo para consultar el reporte de las solicitudes, para las reasignaciones
	 * @param peticion {@link ConsultarSolicitudesRespuesta}
	 * @return {@link ReporteReasignacionesPeticion}
	 */
	public ConsultarSolicitudesRespuesta consultarSolicitudesReasignacion(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCreditoGrupal/V1.0/consultarSolicitudesReasignacion")
			ReporteReasignacionesPeticion peticion );

	/**
	 * M�todo que genera el Reporte de creditos sin asignar
	 * @param peticion :
	 * @return ConsultaCreditosSinAsignarRespuesta
	 */
	public ConsultaCreditosSinAsignarRespuesta consultaCreditosSinAsignar(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/AdministracionCreditoGrupal/V1.0/contratosSinAsignar")
			ReporteReasignacionesPeticion peticion);

	/**
	 * M�todo para realizar la consulta de todos los contratos de saldo a favor
	 * @param peticion :
	 * @return ConsultaSaldosAFavorCreditosVigentesRespuesta
	 */
	public 	ConsultaSaldosAFavorCreditosVigentesRespuesta consultaSaldosAFavorCreditosVigentes(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/AdministracionCreditoGrupal/V1.0/consultaSaldosAFavorCreditosVigentes")
			ConsultaSaldosAFavorCreditosVigentesPeticion peticion );

	/**
	 * M�todo para realizar la consulta de todos los saldos a favor ajustados.
	 * @param peticion :
	 * @return ConsultaSaldosAFavorAjustadosRespuesta
	 */
	public ConsultaSaldosAFavorAjustadosRespuesta consultaSaldosAFavorAjustados(
			@WebParam(name = "peticion",
			targetNamespace = "http://fisa.com.mx/CIOF/AdministracionCreditoGrupal/V1.0/consultaSaldosAFavorAjustados")
			ConsultaSaldosAFavorAjustadosPeticion peticion);


	/**
	 * @param peticion :
	 * @return ConsultaReferenciasPagoRespuesta
	 */
	public ConsultaReferenciasPagoRespuesta consultaReferenciasPago(ConsultaReferenciasPagoPeticion peticion);
	/*
	public ConsultaAsentamientoRespuesta consultaAsentamientosEstados();

	public ConsultaAsentamientoRespuesta consultaAsentamientosMunicipios(AsentamientoOV peticion);

	public ConsultaAsentamientoRespuesta consultaAsentamientosLocalidades(AsentamientoOV peticion);

	public RegistroAsentamientoRespuesta registroAsentamiento(AsentamientoOV peticion);
	*/

	/**
	 * @param peticion :
	 * @return ConsultaReferenciasPagoRespuesta
	 */
	public ConsultaAsentamientoRespuesta consultaAsentamientos(AsentamientoOV peticion);


	//Asignacion Agendas

	/**
	 * @param peticion :
	 * @return String
	 */
	public String asignacionConsolidadoSucursal(String peticion );

	/**
	 * @param peticion :
	 * @return String
	 */
	public String asignacionDetalleSucursal(String peticion );
	/**
	 * @param peticion :
	 * @return String
	 */
	public String asignacionDetalleAsesor(String peticion );
	/**
	 * @param peticion :
	 * @return String
	 */
	public String validaAsignacion(String peticion );
	/**
	 * @param peticion :
	 * @return String
	 */
	public String modificaAsignacion(String peticion );

	/**
	 * @param peticion :
	 * @return String
	 */
	public String consultaBuzonTareas(String peticion );

	/**
	 * @param peticion :
	 * @return String
	 */
	public String asignaTareaPropietario(String peticion );

	/**
	 * @param peticion :
	 * @return String
	 */
	public String autorizaReasignacion(String peticion);

	/**
	 * @param peticion :
	 * @return String
	 */
	public DatosCreditoIntegrantesRespuesta obtenerDatosCreditoIntegrantesCompleto(ConsultaCreditoPeticion peticion);

	/**
	 * @param peticion :
	 * @return String
	 */
	public String consultaBuzonTareaPerfil(String peticion);

	/**
	 * @param peticion :
	 * @return String
	 */
	public String terminarBuzonTarea(String peticion);

	/**
	 * Genera rfc.
	 *
	 * @param peticion the peticion
	 * @return the respuesta rfcov
	 */
	public RespuestaRFCOV generaRFC(PeticionRFCOV peticion);

	/**
	 * Consulta Datos Imagenes Monitor.
	 *
	 * @param peticion String
	 * @return respuesta tipo String
	 */
	public String consultaDatosImagenesMonitor(String peticion);
	/**
	 * Consulta Datos Promedios Monitor.
	 *
	 * @param peticion String
	 * @return respuesta tipo String
	 */
	public String consultaDatosPromediosMonitor(String peticion);

	/**
	 * Validar Relacion Persona Contrato.
	 *
	 * @param peticion the peticion
	 * @return the Validar Relacion Persona Contrato respuesta
	 */
	public String validaRelacionPersonaContrato(String peticion);

	/**
	 * @param peticion :
	 * @return String
	 */
	public DatosCreditoIntegrantesRespuesta obtenerSaldosFinanciadosIntegrantes(ConsultaCreditoPeticion peticion);


	/**
	 * @param contrato contrato de la peticion para calcular el CAT
	 * @return CAT
	 */
	public ConsultaCATRespuesta calcularCATContrato(String contrato );

	/**
	 * Esta operaci&oacute;n permite obtener la informaci&oacute;n del cliente
	 * a trav&eacute;s del ID que lo identifica que en este caso es el contrato.
	 * @param uid identificador &uacute;nico de transacci&oacute;n.
	 * @param peticion datos de la consulta
	 * @return RespuestaConsultaEnLineaOxxo respuesta de la consulta.
	 */
	public RespuestaConsultaEnLineaOxxo consultaEnLineaOxxo(String uid, PeticionEnLineaOxxo peticion);

		/**
	 * Metodo para obtener catalogo de Analistas
	 * @param uid para el log
	 * @param peticion codigo
	 * @return catalogo de analistas
	 */
	public ConsultaCatalogoRespuestaCIOF consultaCatalogoAnalistas(String uid, String peticion);

	/**
	 * Metodo que permite obtener la consulta del reporte de Asistencia para el CEC
	 *
	 * @param uid Identificador Unico de Transaccion
	 * @param fechaPeticion de la consulta
	 * @return ReporteAsistencias de respuesta de la consulta.
	 */
	public ReporteAsistencias consultaReporteAsistencia(String uid, String fechaPeticion);

	/**
	 * Metodo donde se registra la operacion  de inicio y fin de seciones
	 * @param uid id unico de transaccion
	 * @param peticion peticion
	 * @return RegistrOperacionesRespuesta respuesta
	 */
	public RegistrOperacionesRespuesta registrarOperacion(String uid, RegistrOperacionesPeticion peticion);

	/**
	 * Obtener cadena PayBin.
	 *
	 * @param peticion The ReferenciasPeticion
	 * @return the string Cadena de PayBin
	 */
	public ReferenciasRespuestaPaybin obtenerCadenaPaybinSACG(ReferenciasPeticion peticion);
	
	/**
	 * Metodo de consutla de analista de sucursal
	 * @param uid : id unico de transaccion 
	 * @param sucursal : numero de la sucursal
	 * @return List<ConsultaAnalista> : lista de los analistas de esa sucursal.
	 */
	public List<ConsultaAnalista> consultaAnalistasPorSucursal( String uid, Integer sucursal);
}
