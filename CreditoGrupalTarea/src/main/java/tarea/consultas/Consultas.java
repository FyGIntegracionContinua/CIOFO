package tarea.consultas;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import utilitario.buzon.AsignaTareaPropietarioPeticion;
import utilitario.buzon.AsignaTareaPropietarioRespuesta;
import utilitario.buzon.BuzonOV;
import utilitario.buzon.ConsultaBuzonPeticion;
import utilitario.buzon.TareaOV;
import utilitario.mensajes.administracion.contrato.ConcentradoActasRecaudacionPeticion;
import utilitario.mensajes.administracion.contrato.ConcentradoActasRecaudacionRespuesta;
import utilitario.mensajes.comun.ConsultaCatalogoRespuestaCIOF;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.condonaciones.ConsultaDatosPeticion;
import utilitario.mensajes.condonaciones.ConsultaDatosRespuesta;
import utilitario.mensajes.condonaciones.comun.CreditoSaldo;
import utilitario.mensajes.consultas.AsentamientoOV;
import utilitario.mensajes.consultas.AsignacionDetalleOV;
import utilitario.mensajes.consultas.AsignacionDetalleRespuesta;
import utilitario.mensajes.consultas.AsignacionOV;
import utilitario.mensajes.consultas.AsignacionSucursalRespuesta;
import utilitario.mensajes.consultas.AutorizaReasignacionRespuesta;
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
import utilitario.mensajes.consultas.DatosClienteRespuesta;
import utilitario.mensajes.consultas.DatosCreditoIntegrantesRespuesta;
import utilitario.mensajes.consultas.DatosCreditoRespuesta;
import utilitario.mensajes.consultas.DesembolsoOpenContractRespuesta;
import utilitario.mensajes.consultas.GeneraActaRecaudacionRespuesta;
import utilitario.mensajes.consultas.GrupoHistoricoRespuesta;
import utilitario.mensajes.consultas.ObtenerReferenciasPagoPeticion;
import utilitario.mensajes.consultas.ObtenerReferenciasPagoRespuesta;
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
 * @author out_oarias
 * @version 1.0.0
 */

public interface Consultas {

	/**
	 * String Consultas.java
	 */
	static String SUCURSAL_INVALIDA 					= "NO SE HAN ENCONTRADO DATOS PARA ESTE NUMERO DE SUCURSAL";

	/**
	 * Obtiene los datos Generales del credito
	 * @param peticion :
	 * @param uid String
	 * @return datos generales del credito
	 */
	public DatosCreditoRespuesta obtenerDatosCredito(String uid, ConsultaCreditoPeticion peticion);

	/**
	 * Obtiene los datos Generales del credito e integrantes
	 * @param peticion :
	 * @param uid String
	 * @return datos generales del credito e integrantes
	 */
	public DatosCreditoIntegrantesRespuesta obtenerDatosCreditoIntegrantes(String uid, ConsultaCreditoPeticion peticion);

	/**
	 * Envuelve la llamada al stored procedure consulta_saldo_fv
	 * @param numeroContrato .
	 * @param fechaValor .
	 * @param uid .
	 * @return saldo del credito
	 */
	public CreditoSaldo consultaSaldoCredito( String uid, String numeroContrato, Date fechaValor);

	/**
	 * Envuelve la llamada al stored procedure consulta_saldo_fv
	 * @param uid tipo string
	 * @param numeroContrato tipo string
	 * @param fechaValor tipo date
	 * @param sesionExterna tipo SqlSession
	 * @return saldo del credito
	 */
	public CreditoSaldo consultaSaldoCredito( String uid, String numeroContrato, Date fechaValor, SqlSession sesionExterna);

	/**
	 * Consulta el saldo correspondiente al contrato proporcionado
	 *
	 * @param peticion que incluye el numero de contrato
	 * @param uid tipo string
	 *
	 * @return Resultado de la operacion
	 */
	public ConsultaDatosRespuesta consultarDatosSaldoVencido(String uid, ConsultaDatosPeticion peticion);


	/**
	 * TODO
	 * @param peticion .
	 * @param uid .
	 * @return Resultado de la operacion
	 */
	public ConsultaDatosClienteRespuesta consultaDatosCliente(ConsultaDatosClientePeticion peticion, String uid);

	/**
	 *
	 * @param peticion .
	 * @param uid .
	 * @return Resultado de la operacion
	 */
	public DatosClienteRespuesta consultaClientes(ReporteDatosClientePeticion peticion, String uid);

	/**
	 * Reporte de desembolso open contrat presentado en formato de consulta
	 * @param peticion .
	 * @param uid .
	 * @return Resultado de la operacion
	 */
	public DesembolsoOpenContractRespuesta consultaDesembolso( ReporteDesembolsoPeticion peticion, String uid);

	/**
	 * Reporte
	 * @param peticion .
	 * @param uid .
	 * @return Resultado de la operacion
	 */

	public ConsultaOportunidadRespuesta consultaContratoOportunidad(ConsultaOportunidadPeticion peticion, String uid);

	/**
	 *  Obtiene la informacion historica de la relacion contrato-cliente
	 * @param peticion .
	 * @param uid .
	 * @return Resultado de la operacion
	 */
	public ClienteHistoricoRespuesta consultaHistorialCliente(ConsultaDatosClientePeticion peticion, String uid);

	/**
	 *
	 * @param peticion .
	 * @param uid .
	 * @return Resultado de la operacion
	 */
	public GrupoHistoricoRespuesta consultaHistorialGrupo(ConsultaDatosClientePeticion peticion, String uid);

	/**
	 * Funcion para obtencion de datos para SISEFIN
	 * @param peticion .
	 * @param uid .
	 * @return Resultado de la operacion
	 */
	public ConsultaSISEFINRespuesta consultaSISEFIN( ConsultaSISEFINPeticion peticion, String uid );

	/**
	 * Consulta para obtener la lista de contratos con saldos a favor de
	 * una sucursal determinada
	 * @param peticion .
	 * @param uid .
	 * @return Resultado de la operacion
	 */
	public ConsultaSaldosAFavorRespuesta consultaSaldosAFavor(ConsultaSaldosAFavorPeticion peticion, String uid );

	/**
	 * Funcion para validar si un fecha ingresada es un dia habil
	 * @param peticion .
	 * @param uid .
	 * @return Resultado de la operacion
	 */
	public ConsultaDiaHabilRespuesta verificarDiaHabil( ConsultaDiaHabilPeticion peticion, String uid );

	/**
	 * M�todo que obtiene la lista de los dias habiles marcados para una sucursal y
	 * a partir de una fecha dadas
	 * @param peticion .
	 * @param uid .
	 * @return Resultado de la operacion
	 */
	public ObtenerDiasInhabilesRespuesta obtenerDiasInhabiles( ConsultaDiasInhabilesPeticion peticion, java.lang.String uid );

	/**
	 * M�todo para obtener el CAT, en base a la formula dada por BANXICO
	 * @param peticion .
	 * @param uid .
	 * @return Resultado de la operacion
	 */
	public ConsultaCATRespuesta consultarCAT( ConsultaCATPeticion peticion, java.lang.String uid );

	/**
	 * M�todo para realizar la consulta de los movimentos de un contrato dado
	 * @param peticion consultaMovimientosPeticion
	 *  @param uid .
	 * @return Resultado de la operacion
	 */
	public ConsultarMovimientosRespuesta consultarMovimientos(ConsultarMovimientosPeticion peticion, java.lang.String uid );

	/**
	 * M�todo que realiza la Consulta de los Cr&eacute;ditos Asignados.
	 * @param peticion {@link ConsultarCreditosAsignadosPeticion}
	 * @param uid {@link String}
	 * @return {@link ConsultarCreditosAsignadosRespuesta}
	 */
	public ConsultarCreditosAsignadosRespuesta consultarCreditosAsignados(
			ConsultarCreditosAsignadosPeticion peticion, java.lang.String uid);

	/**
	 * M�todo que realiza la Consulta del Consolidado de Cr&eacute;ditos Asignados.
	 * @param peticion {@link ConsolidadoCreditosAsignadosPeticion}
	 * @param uid {@link String}
	 * @return {@link ConsolidadoCreditosAsignadosRespuesta}
	 */
	public ConsolidadoCreditosAsignadosRespuesta consolidadoCreditosAsignados(
			ConsolidadoCreditosAsignadosPeticion peticion, java.lang.String uid);

	/**
	 * M�todo para consultar las reacciones de cartera realizadas
	 * @param peticion .
	 * @param uid .
	 * @return Resultado de la operacion
	 */
	public ConsultarReasignacionesRespuesta consultarReasignaciones(
			ConsultarReasignacionesPeticion peticion, java.lang.String uid );

	/**
	 * M�todo para consultar el historial de un contrato dado
	 * @param peticion .
	 * @param uid .
	 * @return Resultado de la operacion
	 */
	public ConsultarReasignacionesContratoRespuesta consultarReasignacionesContrato(
			ConsultarReasignacionesContratoPeticion peticion, java.lang.String uid );

	/**
	 * M�todo que genera las actas de recaudacion por contrato
	 * @param peticion .
	 *  @param uid .
	 * @return Resultado de la operacion
	 */
	public GeneraActaRecaudacionRespuesta generaActasRecaudacion( ConsultaCreditoPeticion peticion, java.lang.String uid );

	/**
	 * Funcion para generar el concentrado de actas de recaudacion
	 * @param peticion .
	 * @param uid .
	 * @return Resultado de la operacion
	 */
	public ConcentradoActasRecaudacionRespuesta concentradoActasRecaudacion(
			ConcentradoActasRecaudacionPeticion peticion, String uid);

	/**
	 * M�todo para consultar el reporte de los contratos reasignados multiples ocaciones
	 * @param peticion {@link ConsultarReasignacionesMultiplesPeticion}
	 * @param uid identificador �nico de la acci�n
	 * @return {@link ConsultarReasignacionesMultiplesRespuesta}
	 */
	public ConsultarReasignacionesMultiplesRespuesta consultarReasignacionesMultiples(
			ReporteReasignacionesPeticion peticion, java.lang.String uid );

	/**
	 * M�todo para consultar el reporte de las solicitudes, para las reasignaciones
	 * @param peticion .
	 * @param uid .
	 * @return Resultado de la operacion
	 */
	public ConsultarSolicitudesRespuesta consultarSolicitudesReasignacion(
			ReporteReasignacionesPeticion peticion, java.lang.String uid );

	/**
	 * Funcion para generar el reporte de creditos sin asignar
	 * @param peticion :
	 * @param uid :
	 * @return ConsultaCreditosSinAsignarRespuesta
	 */
	public ConsultaCreditosSinAsignarRespuesta consultaCreditosSinAsignar(ReporteReasignacionesPeticion peticion, String uid);

	/**
	 * M�todo para realizar la consulta de todos los contratos de saldo a favor
	 * @param peticion :
	 * @param uid :
	 * @return ConsultaSaldosAFavorCreditosVigentesRespuesta
	 */
	public 	ConsultaSaldosAFavorCreditosVigentesRespuesta
	consultaSaldosAFavorCreditosVigentes(ConsultaSaldosAFavorCreditosVigentesPeticion peticion, String uid );

	/**
	 * @param peticion :
	 * @param uid :
	 * @return consultaSaldosAFavorAjustados :
	 */
	public ConsultaSaldosAFavorAjustadosRespuesta
	consultaSaldosAFavorAjustados(ConsultaSaldosAFavorAjustadosPeticion peticion, String uid);

	/**
	 * @param peticion :
	 * @param uid :
	 * @return consultaReferenciasPago :
	 */
	public ConsultaReferenciasPagoRespuesta consultaReferenciasPago(ConsultaReferenciasPagoPeticion peticion, String uid);

	/**
	 * Obtener cadena PayBin.
	 *
	 * @param uid the Identificador unico
	 * @param peticion The ReferenciasPeticion
	 * @return ReferenciasRespuestaPaybin the string
	 */
	public ReferenciasRespuestaPaybin obtenerCadenaPaybin(String uid, ReferenciasPeticion peticion);

	/**
	 * @param uid :
	 * @param peticion :
	 * @return consultaAsentamientos :
	 */
	public ConsultaAsentamientoRespuesta consultaAsentamientos( String uid, AsentamientoOV peticion);

	/**
	 * @param uid String
	 * @param peticion tipo AsignacionOV
	 * @return respuesta
	 */
	public AsignacionSucursalRespuesta asignacionConsolidadoSucursal(String uid, AsignacionOV peticion);

	/**
	 * @param uid String
	 * @param peticion tipo AsignacionDetalleOV
	 * @return respuesta
	 */
	public AsignacionDetalleRespuesta asignacionDetalleSucursalTarea(String uid, AsignacionDetalleOV peticion);

	/**
	 * @param uid String
	 * @param peticion tipo AsignacionDetalleOV
	 * @return respuesta
	 */
	public AsignacionDetalleRespuesta asignacionDetalleAsesorTarea(String uid, AsignacionDetalleOV peticion);

	/**
	 * @param uid String
	 * @param peticion tipo AsignacionDetalleOV
	 * @return respuesta
	 */
	public VerificaAsignacionRespuesta validaAsignacionTarea(String uid, AsignacionDetalleOV peticion);

	/**
	 * @param uid String
	 * @param peticion tipo AsignacionDetalleOV
	 * @return respuesta
	 */
	public VerificaAsignacionRespuesta modificaAsignacionTarea(String uid, AsignacionDetalleOV peticion);

	/**
	 * @param uid String
	 * @param peticion ConsultaBuzonPeticion
	 * @return BuzonOV
	 */
	public BuzonOV consultaBuzonTareas(String uid, ConsultaBuzonPeticion peticion);

	/**
	 * @param uid String
	 * @param peticion peticionAsignaPropietario
	 * @return asignaTareaPropietario :
	 */
	public AsignaTareaPropietarioRespuesta
		asignaTareaPropietario(String uid, AsignaTareaPropietarioPeticion peticion);

	/**
	 * @param uid String
	 * @param peticion AsignacionDetalleOV
	 * @return respuesta
	 */
	public AutorizaReasignacionRespuesta autorizaReasignacionTarea(String uid, AsignacionDetalleOV peticion);

	public DatosCreditoIntegrantesRespuesta obtenerDatosCreditoIntegrantesCompleto(	String uid, ConsultaCreditoPeticion peticion);


	public String consultaBuzonTareaPerfilTarea(String uid, String peticion);


	public EncabezadoRespuesta terminarBuzonTarea(String uid, SqlSession  sesion, TareaOV peticion);

	public RespuestaRFCOV generaRFCTarea(String uid, PeticionRFCOV peticion);

	/**
	 * Obtener referencias pago seguros.
	 *
	 * @param peticion the peticion
	 * @param uid the uid
	 * @return the obtener referencias pago respuesta
	 */
	public ObtenerReferenciasPagoRespuesta obtenerReferenciasPagoSeguros(ObtenerReferenciasPagoPeticion peticion, String uid);

	/**
	 * Consulta Datos Imagenes Monitor.
	 *
	 * @param consultaDatosImagenesMonitorPeticion .
	 * @param uid the uid
	 * @return the Consulta Datos Imagenes Monitor respuesta
	 */
	public ConsultaDatosImagenesMonitorRespuesta consultaDatosImagenesMonitorTarea(
			String uid, ConsultaDatosImagenesMonitorPeticion consultaDatosImagenesMonitorPeticion);

	/**
	 * Consulta Datos Promedios Monitor.
	 *
	 * @param consultaDatosPromediosMonitorPeticion .
	 * @param uid the uid .
	 * @return the Consulta Datos promedios Monitor respuesta
	 */
	public ConsultaDatosPromediosMonitorRespuesta consultaDatosPromediosMonitorTarea(
			String uid, ConsultaDatosPromediosMonitorPeticion consultaDatosPromediosMonitorPeticion);

	/**
	 * Validar Relacion Persona Contrato.
	 *
	 * @param validarRelacionPersonaContratoPeticion .
	 * @param uid the uid .
	 * @return the Validar Relacion Persona Contrato respuesta
	 */
	public ValidarRelacionPersonaContratoRespuesta validaRelacionPersonaContratoTarea(
			String uid, ValidarRelacionPersonaContratoPeticion validarRelacionPersonaContratoPeticion);

	/**
	 * Obtener saldos financiados integrantes tarea.
	 *
	 * @param uid the uid
	 * @param peticion the peticion
	 * @return the datos credito integrantes respuesta
	 */
	public DatosCreditoIntegrantesRespuesta obtenerSaldosFinanciadosIntegrantesTarea(
			String uid, ConsultaCreditoPeticion peticion);
/**
 *
 * @param uid tansacion de id
 * @param contrato contrato.
 * @return ConsultaCATRespuesta respuesta
 */
	public ConsultaCATRespuesta calcularCATContrato(String uid, String contrato );

	/**
	 * Esta operaci&oacute;n permite obtener la informaci&oacute;n del cliente
	 * a trav&eacute;s del ID que lo identifica que en este caso es el contrato.
	 * @param uid identificador &uacute;nico de transacci&oacute;n.
	 * @param peticion datos de la consulta
	 * @return RespuestaConsultaEnLineaOxxo respuesta de la consulta.
	 */
	public RespuestaConsultaEnLineaOxxo consultaEnLineaOxxoTarea(String uid, PeticionEnLineaOxxo peticion);

	/**
	 * @param uid String
	 * @param peticion ConsultaBuzonPeticion
	 * @return BuzonOV
	 */
	public BuzonOV consultaBuzonAnalistaDocumental(String uid, ConsultaBuzonPeticion peticion);

	/**
	 * Metodo donde se registra la operacion  de inicio y fin de seciones
	 * @param uid id unico de transaccion
	 * @param peticion peticion
	 * @return RegistrOperacionesRespuesta respuesta
	 */
	public RegistrOperacionesRespuesta registrarOperacion(String uid, RegistrOperacionesPeticion peticion);

		/**
	 * Metodo para obtener los catalogos de analistas
	 * @param uid log
	 * @param peticion codigo
	 * @return lista de analistas
	 */
	public ConsultaCatalogoRespuestaCIOF consultaCatalogoAnalistas (String uid, String peticion);

	/**
	 * Metodo que permite obtener la consulta del reporte de Asistencia para el CEC
	 *
	 * @param uid Identificador Unico de Transaccion
	 * @param fechaPeticion fecha de la peticion
	 * @return ReporteAsistencias respuesta de la consulta.
	 */
	public ReporteAsistencias consultaReporteAsistenciaTarea(String uid, String fechaPeticion);
	
	/**
	 * Metodo de consutla de analista de sucursal
	 * @param uid : id unico de transaccion 
	 * @param sucursal : numero de la sucursal
	 * @return List<ConsultaAnalista> : lista de los analistas de esa sucursal.
	 */
	public List<ConsultaAnalista> consultaAnalistasPorSucursal( String uid, Integer sucursal);
}

