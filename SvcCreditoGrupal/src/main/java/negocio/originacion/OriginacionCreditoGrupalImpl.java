/**
 * Tensegrity - 2011
 */
package negocio.originacion;

import java.util.HashMap;

import org.osoa.sca.annotations.Reference;
import org.osoa.sca.annotations.Service;

import tarea.cheques.ChequesSIC;
import tarea.comun.OFSResultAssembler;
import tarea.comun.OFSResultAssemblerImpl;
import tarea.impresiondocs.ImpresionDocsInformacion;
import tarea.originacion.OriginacionCliente;
import tarea.originacion.OriginacionConsultas;
import tarea.originacion.OriginacionCredito;
import tarea.originacion.OriginacionGrupo;
import transformador.Transformador;
import utilitario.comun.GUIDGenerator;
import utilitario.log.LogHandler;
import utilitario.mensajes.comun.AmortizacionActualOV;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ResultadoOV;
import utilitario.mensajes.consultas.ConsultaReferenciasPagoRespuesta;
import utilitario.mensajes.consultas.DatosCreditoIntegrantesRespuesta;
import utilitario.mensajes.consultas.DatosCreditoOV;
import utilitario.mensajes.consultas.DatosIntegranteResumenOV;
import utilitario.mensajes.impresiondocs.ImpresionDocsConsultaPeticion;
import utilitario.mensajes.impresiondocs.ImpresionDocsConsultaRespuesta;
import utilitario.mensajes.impresiondocs.comun.AvalGrupo;
import utilitario.mensajes.impresiondocs.comun.CartaInstruccionOV;
import utilitario.mensajes.impresiondocs.comun.ContratoFinsolOV;
import utilitario.mensajes.impresiondocs.comun.ContratoFinsolRespuesta;
import utilitario.mensajes.impresiondocs.comun.ContratoPeticionKit;
import utilitario.mensajes.impresiondocs.comun.ContratoRestructuraVO;
import utilitario.mensajes.impresiondocs.comun.ContratoVO;
import utilitario.mensajes.impresiondocs.comun.ContratoVigenteVO;
import utilitario.mensajes.impresiondocs.comun.CreditoGrupalCSOV;
import utilitario.mensajes.impresiondocs.comun.CreditoOportunidadOV;
import utilitario.mensajes.impresiondocs.comun.FichaEspecialPeticion;
import utilitario.mensajes.impresiondocs.comun.FichaEspecialRespuesta;
import utilitario.mensajes.impresiondocs.comun.MiembroGrupoKitPagare;
import utilitario.mensajes.impresiondocs.comun.MiembroGrupoPagare;
import utilitario.mensajes.impresiondocs.comun.MiembroGrupoVO;
import utilitario.mensajes.impresiondocs.comun.MiembroGrupoVigenteVO;
import utilitario.mensajes.impresiondocs.comun.ObjetosImpresionDocumentos;
import utilitario.mensajes.impresiondocs.comun.PagoGrupo;
import utilitario.mensajes.impresiondocs.comun.PreSolicitudPeticion;
import utilitario.mensajes.impresiondocs.comun.PreSolicitudRespuesta;
import utilitario.mensajes.impresiondocs.comun.ValesVO;
import utilitario.mensajes.impresiondocs.contratocomunal.ContratoComunalKitRespuesta;
import utilitario.mensajes.impresiondocs.contratocomunal.ContratoPagareKitRespuesta;
import utilitario.mensajes.impresiondocs.contratocomunal.ConvenioReestructuraKitRespuesta;
import utilitario.mensajes.impresiondocs.contratocomunal.KitImpresionPagareRespuesta;
import utilitario.mensajes.impresiondocs.contratocomunal.PagareReestructuraKitRespuesta;
import utilitario.mensajes.impresiondocs.fichapago.FichaPagoPeticion;
import utilitario.mensajes.impresiondocs.fichapago.FichaPagoRespuesta;
import utilitario.mensajes.impresiondocs.oportunidadcontrato.OportunidadContratoOV;
import utilitario.mensajes.originacion.aprobacion.PlanillaAprobacionOV;
import utilitario.mensajes.originacion.aprobacion.PlanillaAprobacionPeticion;
import utilitario.mensajes.originacion.aprobacion.PlanillaAprobacionRespuesta;
import utilitario.mensajes.originacion.aprobacion.PlanillaAprobacionRespuestaOV;
import utilitario.mensajes.originacion.cheques.ClientesChequesRespuesta;
import utilitario.mensajes.originacion.cheques.ContratoChequesPeticion;
import utilitario.mensajes.originacion.cheques.ContratoChequesRespuesta;
import utilitario.mensajes.originacion.cheques.ContratoChequesSICOV;
import utilitario.mensajes.originacion.cliente.ActualizarChequeClientePeticion;
import utilitario.mensajes.originacion.cliente.ClientePeticion;
import utilitario.mensajes.originacion.cliente.ClienteRespuesta;
import utilitario.mensajes.originacion.consulta.ConfirmarCreditoPeticion;
import utilitario.mensajes.originacion.consulta.ConfirmarCreditoRespuesta;
import utilitario.mensajes.originacion.consulta.ConsultaPeticion;
import utilitario.mensajes.originacion.consulta.ConsultaRespuesta;
import utilitario.mensajes.originacion.consulta.ConsultarSimulacionesReestructurasRespuesta;
import utilitario.mensajes.originacion.consulta.GuardarOpcionGarantiaPeticion;
import utilitario.mensajes.originacion.consulta.GuardarOpcionGarantiaRespuesta;
import utilitario.mensajes.originacion.consulta.InsertarSimulacionesReestructurasPeticion;
import utilitario.mensajes.originacion.consulta.InsertarSimulacionesReestructurasRespuesta;
import utilitario.mensajes.originacion.consulta.PagoDocumentoPeticion;
import utilitario.mensajes.originacion.consulta.ParGeneralOV;
import utilitario.mensajes.originacion.consulta.SaldosSimulacionOV;
import utilitario.mensajes.originacion.consulta.SimulacionReestructuraIntOV;
import utilitario.mensajes.originacion.consulta.SimulacionReestructuraOV;
import utilitario.mensajes.originacion.consulta.ValidaPagoGarantiaPeticion;
import utilitario.mensajes.originacion.consulta.ValidaPagoGarantiaRespuesta;
import utilitario.mensajes.originacion.contrato.ContratoPeticion;
import utilitario.mensajes.originacion.contrato.ContratoRespuesta;
import utilitario.mensajes.originacion.desembolso.DesembolsoPeticion;
import utilitario.mensajes.originacion.desembolso.DesembolsoRespuesta;
import utilitario.mensajes.originacion.grupo.GrupoPeticion;
import utilitario.mensajes.originacion.grupo.GrupoRespuesta;
import datamapper.DataMapper;

/**
 * @author Juan Moreno
 * Implementa las operaciones de la interface OriginacionCreditoGrupal
 */
@Service(value = OriginacionCreditoGrupal.class)
public final class OriginacionCreditoGrupalImpl implements OriginacionCreditoGrupal {

	/**
	 * Declaracion statica de mensaje de error
	 */
	private static final String MSG_ERROR_ACTUALIZA_CLIENTE = "SE DEBE ENVIAR EL IDENTIFICADOR DEL CLIENTE A ACTUALIZAR.";
	/**
	 * Declaracion statica de mensaje de error
	 */
	private static final String MSG_ERROR_NO_EXISTE_CLIENTE = "EL CLIENTE QUE SE PRETENDE ACTUALIZAR NO EXISTE.";
	/**
	 * Declaracion statica de mensaje de error
	 */
	private static final String MSG_ERROR_NO_EXISTE_GRUPO 	= "EL GRUPO QUE SE PRETENDE ACTUALIZAR NO EXISTE.";
	/**
	 * Declaracion statica de mensaje de error
	 */
	private static final String MSG_ERROR_ID_CLIENTE = "NO SE PUDO OBTENER EL ID PARA EL CLIENTE, REVISELO CON EL ADMINISTRADOR.";
	/**
	 * Declaracion statica de mensaje de error
	 */
	private static final String MSG_ERROR_ID_GRUPO = "NO SE PUDO OBTENER EL ID PARA EL GRUPO, REVISELO CON EL ADMINISTRADOR.";


	/**
	 * SCA Componente Fabric
	 */
	private OriginacionCliente cliente;
	/**
	 * SCA Componente Fabric
	 */
	private OriginacionGrupo	grupo;
	/**
	 * SCA Componente Fabric
	 */
	private OriginacionCredito	credito;
	/**
	 * SCA Componente Fabric
	 */
	private OriginacionConsultas consultas;
	//private OFSResultAssembler ofsAssembler;
	/**
	 * SCA Componente Fabric
	 */
	private ChequesSIC chequesSIC;
	/**
	 * SCA Componente Fabric
	 */
	private ImpresionDocsInformacion kitImpresion;
	/**
	 * SCA Componente Fabric
	 */
	private Transformador transformador;

	/**
	 * @param cliente :
	 * @param grupo :
	 * @param credito :
	 * @param consultas :
	 * @param kitImpresion :
	 * @param chequesSIC :
	 * @param transformador :
	 */

	public OriginacionCreditoGrupalImpl(@Reference(name = "cliente") OriginacionCliente cliente,
										@Reference(name = "grupo") OriginacionGrupo grupo,
										@Reference(name = "credito") OriginacionCredito credito,
										@Reference(name = "consultas") OriginacionConsultas consultas,
										@Reference(name = "kitImpresion") ImpresionDocsInformacion kitImpresion,
										@Reference(name = "chequesSIC") ChequesSIC chequesSIC,
										@Reference(name = "transformador") Transformador transformador
										) {
 		this.cliente 		= cliente;
		this.grupo			= grupo;
		this.credito		= credito;
		this.consultas 		= consultas;
		this.kitImpresion 	= kitImpresion;
		this.chequesSIC 	= chequesSIC;
		this.transformador = transformador;
	}




	/**
	 * @param request :
	 * @return ClienteRespuesta
	 */
	public ClienteRespuesta registrarCliente(ClientePeticion request ) {
		//Se genera el idenificador unico para rastrear la operacion.
		final String uid = GUIDGenerator.generateGUID(request );
		LogHandler.info(uid, getClass(), "registrarCliente - Datos de entrada : " + request);
		final ClienteRespuesta regreso = new ClienteRespuesta();
		regreso.setHeader(new EncabezadoRespuesta());
		regreso.getHeader().setUID(uid);

		//Se valida si se env�a la clave de persona o t24, si no se generan las claves necesarias
		final HashMap<String, String> id = cliente.obtenerIdentificador(uid, request.getBody().getClienteT24(),
																	request.getBody().getPersona());
		//Genera un valor secuencial correspondiente al potencial neuvo cliente en el formato 0000099 para credprod
 		LogHandler.debug(uid, getClass(), "OriginacionCreditoGrupal 61 identificador: " + id );
		if (id.get("credprod") != null && id.get("t24" ) != null  ) {
			request.getBody().setPersona(id.get("credprod") );
			request.getBody().setClienteT24(id.get("t24"));

			//Se manda a registrar
			final ResultadoOV resultado = cliente.registrar(uid, request );

			regreso.getHeader().setEstatus(resultado.isSuccess());
			regreso.getHeader().setCodigo(resultado.getCodigo());
			regreso.getHeader().setMensaje(resultado.getMensaje());
			regreso.setPeticion_ofs(request.getBody().getOfs_peticion());
			if (resultado.isSuccess()) {
				regreso.setIdentificador(resultado.getIdentificador());	}
			}
		else {
			regreso.getHeader().setEstatus(false );
			regreso.getHeader().setMensaje(MSG_ERROR_ID_CLIENTE );
			}

		LogHandler.info(uid, getClass(), "registrarCliente - Datos de salida : " + regreso);
		return regreso;
		}

	/**
	 * @param request :
	 * @return ClienteRespuesta
	 */
	public ClienteRespuesta actualizarCliente(ClientePeticion request) {
		//Se genera el idenificador unico para rastrear la operacion.
		final String uid = GUIDGenerator.generateGUID(request);
		LogHandler.info(uid, getClass(), "actualizarCliente - Datos de entrada : " + request);
		final ClienteRespuesta regreso = new ClienteRespuesta();
		regreso.setHeader(new EncabezadoRespuesta());
		regreso.getHeader().setUID(uid);

		if (request.getBody().getPersona() == null ) {
			regreso.getHeader().setEstatus(false);
			regreso.getHeader().setMensaje(MSG_ERROR_ACTUALIZA_CLIENTE);
			}
		else {
			ResultadoOV resultado;
			if (cliente.existe(uid, request.getBody().getPersona())) {
				resultado = cliente.actualizar(uid, request);
				regreso.getHeader().setEstatus(resultado.isSuccess());
				regreso.getHeader().setCodigo(resultado.getCodigo());
				regreso.getHeader().setMensaje(resultado.getMensaje());
				regreso.getHeader().setCorrelationId(resultado.getUid());
				regreso.setPeticion_ofs(request.getBody().getOfs_peticion());
				if (resultado.isSuccess()) {
					regreso.setIdentificador(request.getBody().getPersona());
				}
			}
			else {
				regreso.getHeader().setEstatus(false);
 				regreso.getHeader().setMensaje(MSG_ERROR_NO_EXISTE_CLIENTE);
				}
			}

		LogHandler.info(uid, getClass(), "actualizarCliente - Datos de salida : " + regreso);
		return regreso;
	}


	/**
	 * @param request :
	 * @return GrupoRespuesta
	 */
	public GrupoRespuesta registrarGrupo(GrupoPeticion request) {
		//Se genera el idenificador unico para rastrear la operacion.
		final String uid = GUIDGenerator.generateGUID(request );
		LogHandler.info(uid, getClass(), "registrarGrupo - Datos de entrada : " + request);
		final GrupoRespuesta regreso	= new GrupoRespuesta();
		regreso.setHeader(new EncabezadoRespuesta());
		regreso.getHeader().setUID(uid );

		final HashMap<String, String> id = grupo.obtenerIdentificador(uid);
		if (id.get("credprod") != null && id.get("t24" ) != null) {
 			request.getBody().setIdentificador(id.get("credprod"));
 			request.getBody().setClienteT24(id.get("t24"));
			ResultadoOV resultado;
			resultado = grupo.registrar(uid, request.getBody());
			regreso.getHeader().setEstatus(resultado.isSuccess());
			regreso.getHeader().setCodigo(resultado.getCodigo());
			regreso.getHeader().setMensaje(resultado.getMensaje());
			regreso.getHeader().setCorrelationId(resultado.getUid());
			//regreso.getHeader().setNumSucursal( request.getBody().getSucursal());
			regreso.setPeticion_ofs(request.getBody().getPeticion_ofs());
			if (resultado.isEstatus()) {
				regreso.setIdentificador(id.get("t24"));
			}
		} else {
			regreso.getHeader().setEstatus(false );
			regreso.getHeader().setMensaje(MSG_ERROR_ID_GRUPO );
		}

		LogHandler.info(uid, getClass(), "registrarGrupo - Datos de salida : " + regreso);
		return regreso;
	}

	/**
	 * @param request :
	 * @return GrupoRespuesta
	 */
	public GrupoRespuesta actualizarGrupo(GrupoPeticion request) {
		//Se genera el idenificador unico para rastrear la operacion.
		final String uid = GUIDGenerator.generateGUID(request);
		LogHandler.info(uid, getClass(), "actualizarGrupo - Datos de entrada : " + request);
		final GrupoRespuesta regreso = new GrupoRespuesta();
		regreso.setHeader(new EncabezadoRespuesta());
		regreso.getHeader().setUID(uid);

		ResultadoOV resultado;
		regreso.setHeader(new EncabezadoRespuesta());
		if (grupo.existe(uid, request.getBody().getIdentificador())) {
			resultado = grupo.actualizar(uid, request.getBody());
			regreso.getHeader().setEstatus(resultado.isSuccess());
			regreso.getHeader().setCodigo(resultado.getCodigo());
			regreso.getHeader().setMensaje(resultado.getMensaje());
			regreso.getHeader().setCorrelationId(resultado.getUid());
			regreso.setPeticion_ofs(request.getBody().getPeticion_ofs());
			if (resultado.isSuccess()) {
				regreso.setIdentificador(request.getBody().getIdentificador());
			}
		}
		else {
			regreso.getHeader().setEstatus(false );
			regreso.getHeader().setMensaje(MSG_ERROR_NO_EXISTE_GRUPO );
		}

		LogHandler.info(uid, getClass(), "actualizarGrupo - Datos de saldia : " + regreso);
		return regreso;
	}


	/**
	 * @param request :
	 * @return ContratoRespuesta
	 */
	public ContratoRespuesta registrarContrato(ContratoPeticion request) {
		//Se genera el idenificador unico para rastrear la operacion.
		final String uid = GUIDGenerator.generateGUID(request);
		LogHandler.info(uid, getClass(), "registrarContrato - Datos de entrada : " + request);

		//Salida
		final ContratoRespuesta contratoRespuesta = credito.registrar(uid, null, request.getBody());
		LogHandler.info(uid, getClass(), "registrarContrato - Datos de salida : " + contratoRespuesta);
		return contratoRespuesta;
	}


	/**
	 * @param request peticion de solicitud
	 * @return respuesta
	 */
	public ConsultaRespuesta validarFechaInicioContrato(ConsultaPeticion request) {
		//Se genera el idenificador unico para rastrear la operacion.
		final String uid = GUIDGenerator.generateGUID(request );
		LogHandler.info(uid, getClass(), "validarFechaInicioContrato - Datos de entrada : " + request);

		//Salida
		final ConsultaRespuesta consultaRespuesta = consultas.validarFechaInicioContrato(uid, request.getBody());
		LogHandler.info(uid, getClass(), "validarFechaInicioContrato - Datos de salida : " + consultaRespuesta);
		return consultaRespuesta;
	}

	/**
	 * @param request peticion de solicitud
	 * @return respuesta
	 */
	public ConsultaRespuesta calcularFechaFinContrato(ConsultaPeticion request) {
		//Se genera el idenificador unico para rastrear la operacion.
		final String uid = GUIDGenerator.generateGUID(request);
		LogHandler.info(uid, getClass(), "calcularFechaFinContrato - Datos de entrada : " + request);

		//Salida
		final ConsultaRespuesta consultaRespuesta = consultas.calcularFechaFinContrato(uid, request.getBody());
		LogHandler.info(uid, getClass(), "calcularFechaFinContrato - Datos de salida : " + consultaRespuesta);
		return consultaRespuesta;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return respuesta
	 */
	public DesembolsoRespuesta realizarDesembolso(DesembolsoPeticion peticion) {
		//Se genera el idenificador unico para rastrear la operacion.
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "realizarDesembolso - Datos de entrada : " + peticion);

		//Salida
		final DesembolsoRespuesta desembolsoRespuesta = credito.desembolsar(uid, peticion.getBody());
		LogHandler.info(uid, getClass(), "realizarDesembolso - Datos de salida : " + desembolsoRespuesta);
		return desembolsoRespuesta;
	}


	/**
	 * @param request peticion de solicitud
	 * @return respuesta
	 */
	public ConsultaRespuesta obtenFecha(ConsultaPeticion request) {
		//Se genera el idenificador unico para rastrear la operacion.
		final String uid = GUIDGenerator.generateGUID(request);
		LogHandler.info(uid, getClass(), "obtenFecha - Datos de entrada : " + request);

		//Salida
		final ConsultaRespuesta consultaRespuesta = consultas.obtenFecha(uid, request.getBody());
		LogHandler.info(uid, getClass(), "obtenFecha - Datos de salida : " + consultaRespuesta);
		return consultaRespuesta;
	}


	/**
	 * @param peticion peticion de solicitud
	 * @return respuesta
	 */
	public ImpresionDocsConsultaRespuesta generaDocumentoKitImpresion(ImpresionDocsConsultaPeticion peticion)
		{
 		//Se genera el idenificador unico para rastrear la operacion.
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "generaDocumentoKitImpresion - Datos de entrada : " + peticion);

		//Salida
		final ImpresionDocsConsultaRespuesta impresionDocsConsultaRespuesta
								= kitImpresion.generaDocumentoKitImpresion(uid, peticion.getBody());
		LogHandler.info(uid, getClass(), "generaDocumentoKitImpresion - Datos de salida : " + impresionDocsConsultaRespuesta);
		return impresionDocsConsultaRespuesta;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return respuesta
	 */
	public PlanillaAprobacionRespuesta obtenerPlantillaAprobacionOFS(PlanillaAprobacionPeticion peticion) {
		final PlanillaAprobacionRespuesta resp = new PlanillaAprobacionRespuesta();
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "obtenerPlantillaAprobacionOFS - Datos de entrada : " + peticion);

		final PlanillaAprobacionRespuestaOV planillas = consultas.obtenerPlantillaAprobacion(uid, peticion.getNumeroContrato());

		if (planillas != null) {
			resp.setEncabezado(planillas.getHeader());

			if (planillas.getPlanilla() != null) {

				OFSResultAssembler  ofsAssembler = new OFSResultAssemblerImpl();

				ofsAssembler.inicializaResultAssembler(planillas.getPlanilla().size());
				ofsAssembler.setTypeReturn(ObjetosImpresionDocumentos.PLANILLA_APROBACION);
				for (int i = 0; i < planillas.getPlanilla().size(); i++) {
					PlanillaAprobacionOV planillaIntegrante = planillas.getPlanilla().get(i);
					if (planillaIntegrante.getProducto() !=  null) {
						//se hace un split para separar la clave del producto de la descripcion: claveFisa-Descripcion
						String prodCveFisa = planillaIntegrante.getProducto().split("-")[0];
						//la claveFisa [0] se mapea a su clave Finsol y se concatena nuevamente
						//con su descripcion [1]
						planillaIntegrante.setProducto(DataMapper.mapProductoFsol(prodCveFisa)
								+ "-" + planillaIntegrante.getProducto().split("-")[1]);
					}
					ofsAssembler.addObject(planillaIntegrante, ObjetosImpresionDocumentos.PLANILLA_APROBACION);
				}

				resp.setOfs(ofsAssembler.getOFS());
			}

		} else {
			EncabezadoRespuesta header = new EncabezadoRespuesta();
			header.setCodigo("");
			header.setMensaje("Error al ejecutar el servicio");
			header.setCorrelationId(GUIDGenerator.generateGUID(this));
			header.setEstatus(false);
		}
		resp.getEncabezado().setUID(uid);

		LogHandler.info(uid, getClass(), "obtenerPlantillaAprobacionOFS - Datos de salida : " + resp);
		return resp;

	}


	/**
	 * @param peticion peticion de solicitud
	 * @return respuesta
	 */
	public ContratoChequesRespuesta consultarContratoChequesSIC(ContratoChequesPeticion peticion) {
		final ContratoChequesRespuesta respuesta = new ContratoChequesRespuesta();
		final String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "consultarContratoChequesSIC - Datos de entrada : " + peticion);
		final EncabezadoRespuesta header = new EncabezadoRespuesta();
		final ContratoChequesSICOV respuestaOv = chequesSIC.consultaContratoChequesSIC(uid, peticion.getBody());
		header.setUID(uid);
		header.setMensaje(respuestaOv.getMensaje());
		header.setEstatus(respuestaOv.isStatus());
		respuesta.setBody(respuestaOv);
		respuesta.setHeader(header);

		LogHandler.info(uid, getClass(), "consultarContratoChequesSIC - Datos de salida : " + respuesta);
 		return  respuesta;
	}


	/**
	 * @param peticion peticion de solicitud
	 * @return respuesta
	 */
	public ClientesChequesRespuesta consultarClientesChequesSIC(ContratoChequesPeticion peticion) {
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "consultarClientesChequesSIC - Datos de entrada : " + peticion);

		//Salida
		final ClientesChequesRespuesta clientesChequesRespuesta = chequesSIC.consultaClientesChequesSIC(uid, peticion.getBody());
		LogHandler.info(uid, getClass(), "consultarClientesChequesSIC - Datos de salida : " + clientesChequesRespuesta);
		return clientesChequesRespuesta;
	}

	/**
	 * @param peticion peticion de solicitud
	 * @return respuesta
	 */
	public GrupoRespuesta existeGrupo(GrupoPeticion peticion) {
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, this.getClass(), "Entrando en existeGrupo .. OK ");
		LogHandler.info(uid, this.getClass(), "Datos de entrada : " + peticion.getBody() );
		final GrupoRespuesta regreso = new GrupoRespuesta();
		regreso.setHeader(new EncabezadoRespuesta());
		regreso.getHeader().setUID(uid);

		final ResultadoOV resultado = grupo.existeGrupo(uid, peticion.getBody());
		regreso.setIdentificador(resultado.getIdentificador());

		LogHandler.info(uid, this.getClass(), "Datos de salida : " + regreso);
		return regreso;
		}


	/**
	 * @param peticion :
	 * @return ClienteRespuesta
	 */
	public ClienteRespuesta actualizarNumeroCheque(ActualizarChequeClientePeticion peticion )
		{
		final String uid = GUIDGenerator.generateGUID(peticion.getContrato() );
		LogHandler.info(uid, getClass(), "actualizarNumeroCheque - Datos de entrada : " + peticion);

		//Objeto de salida
		final 	ClienteRespuesta
				clienteRespuesta = credito.actualizarNumeroCheque(uid, peticion);
		LogHandler.info(uid, getClass(), "actualizarNumeroCheque - Datos de salida : " + clienteRespuesta);
		return clienteRespuesta;
		}

	/**
	 * @param request :
	 * @return ContratoRespuesta
	 */
	public ContratoRespuesta registrarContratoRestructura(ContratoPeticion request ) {
		//Se genera el idenificador unico para rastrear la operacion.
		final String uid = GUIDGenerator.generateGUID(request );
		LogHandler.info(uid, getClass(), "registrarContratoRestructura - Datos de entrada : " + request);

		//Salida
		final ContratoRespuesta contratoRespuesta = credito.registrarContratoRestructura(uid, request.getBody());
		LogHandler.info(uid, getClass(), "registrarContratoRestructura - Datos de salida : " + contratoRespuesta);
		return contratoRespuesta;
	}

	/**
	 * @param peticion :
	 * @return String
	 */
	public String generaContratoComunalDepositoGarantia(String peticion ) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "generaContratoComunalDepositoGarantia - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ContratoPeticionKit.class,
								   ContratoComunalKitRespuesta.class,
								   MiembroGrupoVO.class,
								   PagoGrupo.class,
								   EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ContratoPeticionKit   contratoPeticion
				= (ContratoPeticionKit) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "generaContratoComunalDepositoGarantia - Datos de entrada : " + contratoPeticion);

		//Llamado a funci�n principal
		final ContratoComunalKitRespuesta respuesta = kitImpresion.generaContratoComunalDepositoGarantia(uid, contratoPeticion);
		LogHandler.info(uid, getClass(), "generaContratoComunalDepositoGarantia - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "generaContratoComunalDepositoGarantia - Datos de salida XML: " + respuestaXML);
		return respuestaXML;


	}

	/**
	 * @param peticion :
	 * @return String
	 */
	public String generaPagareComunalDepositoGarantia(String peticion ) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "generaPagareComunalDepositoGarantia - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ContratoPeticionKit.class,
								   AvalGrupo.class,
								   MiembroGrupoPagare.class,
								   ContratoPagareKitRespuesta.class,
								   PagoGrupo.class,
								   EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ContratoPeticionKit   contratoPeticion
		                       = (ContratoPeticionKit) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "generaPagareComunalDepositoGarantia - Datos de entrada : " + contratoPeticion);

		//Llamado a funci�n principal
		final ContratoPagareKitRespuesta respuesta = kitImpresion.generaPagareComunalDepositoGarantia(uid, contratoPeticion);
		LogHandler.info(uid, getClass(), "generaPagareComunalDepositoGarantia - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "generaPagareComunalDepositoGarantia - Datos de salida XML: " + respuestaXML);
		return respuestaXML;


	}

	/**
	 * @param peticion :
	 * @return String
	 */
	public String generaConvenioReestructura(String peticion ) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "generaConvenioReestructura - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ContratoPeticionKit.class,
									ConvenioReestructuraKitRespuesta.class,
									ContratoRestructuraVO.class,
									ContratoVigenteVO.class,
									MiembroGrupoVO.class,
									PagoGrupo.class,
									MiembroGrupoVigenteVO.class,
									EncabezadoRespuesta.class,
									ValesVO.class};

		//Conversion de XML a Object
		final ContratoPeticionKit   contratoPeticion
					= (ContratoPeticionKit) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "generaConvenioReestructura - Datos de entrada : " + contratoPeticion);

		//Llamado a funci�n principal
		final ConvenioReestructuraKitRespuesta respuesta = kitImpresion.generaConvenioReestructura(uid, contratoPeticion);
		LogHandler.info(uid, getClass(), "generaConvenioReestructura - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "generaConvenioReestructura - Datos de salida XML: " + respuestaXML);
		return respuestaXML;


	}

	/**
	 * @param peticion peticion de solicitud
	 * @return respuesta XML
	 */
public String generaPagareReestructura(String peticion) {
	final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
	LogHandler.info(uid, getClass(), "generaPagareReestructura - Datos de entrada : " + peticion);

	//Parametros de entrada
	final Class<?>[] clases = {ContratoPeticionKit.class,
								AvalGrupo.class,
								MiembroGrupoPagare.class,
								PagareReestructuraKitRespuesta.class,
								PagoGrupo.class,
								EncabezadoRespuesta.class};

	//Conversion de XML a Object
	final ContratoPeticionKit   contratoPeticion
						= (ContratoPeticionKit) transformador.transformaXMLAObjeto(uid, peticion, clases);
	LogHandler.info(uid, getClass(), "generaPagareReestructura - Datos de entrada : " + contratoPeticion);

	//Llamado a funci�n principal
	final PagareReestructuraKitRespuesta respuesta = kitImpresion.generaPagareReestructura(uid, contratoPeticion);
	LogHandler.info(uid, getClass(), "generaPagareReestructura - Datos de salida: " + respuesta);

	//Se genera la salida
	final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
	LogHandler.info(uid, getClass(), "generaPagareReestructura - Datos de salida XML: " + respuestaXML);
	return respuestaXML;
}

/**
 * @param peticion peticion de solicitud
 * @return respuesta XML
 */
public String consultarSimuladorReestructuras(String peticion) {
	final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
	LogHandler.info(uid, getClass(), "consultarSimuladorReestructuras - Datos de entrada : " + peticion);

	//Parametros de entrada
	final Class<?>[] clases = {SimulacionReestructuraOV.class,
								SimulacionReestructuraIntOV.class,
								SaldosSimulacionOV.class,
								ParGeneralOV.class,
								ConsultarSimulacionesReestructurasRespuesta.class,
								EncabezadoRespuesta.class};

	//Conversion de XML a Object
	final SimulacionReestructuraOV consultarPeticion =
		(SimulacionReestructuraOV) transformador.transformaXMLAObjeto(uid, peticion, clases);
	LogHandler.info(uid, getClass(),
			"consultarSimuladorReestructuras - Datos de entrada : " + consultarPeticion);

	//Llamado a funci�n principal
	final ConsultarSimulacionesReestructurasRespuesta  respuesta =
			consultas.consultarSimuladorReestructurasTarea(uid, consultarPeticion);
	LogHandler.info(uid, getClass(), "consultarSimuladorReestructuras - Datos de salida: " + respuesta);

	//Se genera la salida
	final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
	LogHandler.info(uid, getClass(), "consultarSimuladorReestructuras - Datos de salida XML: " + respuestaXML);
	return respuestaXML;
	}


/**
 * @param peticion peticion de solicitud
 * @return respuesta XML
 */
public String insertarSimuladorReestructuras(String peticion) {
	final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
	LogHandler.info(uid, getClass(), "insertarSimuladorReestructuras - Datos de entrada XML: " + peticion);

	//Parametros de entrada
	final Class<?>[] clases = {SimulacionReestructuraOV.class,
								SimulacionReestructuraIntOV.class,
								InsertarSimulacionesReestructurasPeticion.class,
								InsertarSimulacionesReestructurasRespuesta.class,
								EncabezadoRespuesta.class};

	//Conversion de XML a Object
	final InsertarSimulacionesReestructurasPeticion insertarPeticion =
		(InsertarSimulacionesReestructurasPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
	LogHandler.info(uid, getClass(),
			"insertarSimuladorReestructuras - Objeto de entrada : " + insertarPeticion);

	//Llamado a funci�n principal
	final InsertarSimulacionesReestructurasRespuesta  respuesta =
			consultas.insertarSimuladorReestructurasTarea(uid, insertarPeticion);
	LogHandler.info(uid, getClass(), "insertarSimuladorReestructuras - Objeto de salida: " + respuesta);

	//Se genera la salida
	final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
	LogHandler.info(uid, getClass(), "insertarSimuladorReestructuras - Datos de salida XML: " + respuestaXML);
	return respuestaXML;
}

/**
 * @param request :
 * @return ContratoRespuesta
 */
public ContratoRespuesta registrarContratoVentaCartera(ContratoPeticion request) {
	//Se genera el idenificador unico para rastrear la operacion.
	final String uid = GUIDGenerator.generateGUID(request);
	LogHandler.info(uid, getClass(), "registrarContrato - Datos de entrada : " + request);

	//Salida
	final ContratoRespuesta contratoRespuesta = credito.registrarContratoVentaCartera(uid, request.getBody());
	LogHandler.info(uid, getClass(), "registrarContrato - Datos de salida : " + contratoRespuesta);
	return contratoRespuesta;
}
/**
 * Valida pago garantia.
 *
 * @param peticion the peticion
 * @return the string
 */
public String validaPagoGarantia(String peticion) {
	final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
	LogHandler.info(uid, getClass(), "validaPagoGarantia - Datos de entrada : " + peticion);

	//Parametros de entrada
	final Class<?>[] clases = {ValidaPagoGarantiaPeticion.class,
								ValidaPagoGarantiaRespuesta.class,
								EncabezadoRespuesta.class};

	//Conversion de XML a Object
	final ValidaPagoGarantiaPeticion validaPagoGarantiaPeticion =
		(ValidaPagoGarantiaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
	LogHandler.info(uid, getClass(), "validaPagoGarantia - Datos de entrada : " + validaPagoGarantiaPeticion);

	//Llamado a funci�n principal
	final ValidaPagoGarantiaRespuesta respuesta =
			credito.validaPagoGarantiaTarea(uid, validaPagoGarantiaPeticion);
	LogHandler.info(uid, getClass(), "validaPagoGarantia - Datos de salida: " + respuesta);

	//Se genera la salida
	final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
	LogHandler.info(uid, getClass(), "validaPagoGarantia - Datos de salida XML: " + respuestaXML);
	return respuestaXML;
}



/**
 * Confirmar contrato.
 *
 * @param peticion the peticion
 * @return the string
 */
public String confirmarCredito(String peticion) {
	final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
	LogHandler.info(uid, getClass(), "validaPagoGarantia - Datos de entrada : " + peticion);

	//Parametros de entrada
	final Class<?>[] clases = {ConfirmarCreditoPeticion.class,
								ConfirmarCreditoRespuesta.class,
								EncabezadoRespuesta.class};

	//Conversion de XML a Object
	final ConfirmarCreditoPeticion confirmarCreditoPeticion =
		(ConfirmarCreditoPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
	LogHandler.info(uid, getClass(), "validaPagoGarantia - Datos de entrada : " + confirmarCreditoPeticion);

	//Llamado a funci�n principal
	final ConfirmarCreditoRespuesta respuesta =
			credito.confirmarCreditoTarea(uid, confirmarCreditoPeticion);
	LogHandler.info(uid, getClass(), "validaPagoGarantia - Datos de salida: " + respuesta);

	//Se genera la salida
	final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
	LogHandler.info(uid, getClass(), "validaPagoGarantia - Datos de salida XML: " + respuestaXML);
	return respuestaXML;
}

	/**
	 * @param peticion :
	 * @return String
	 */
	public String generaFichaEspecialPago(String peticion ) {

	final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
	LogHandler.info(uid, getClass(), "generaFichaEspecialPago - Datos de entrada : " + peticion);

	//Parametros de entrada
	final Class<?>[] clases = {FichaEspecialPeticion.class,
							   EncabezadoRespuesta.class,
							   FichaEspecialRespuesta.class};

	//Conversion de XML a Object
	final FichaEspecialPeticion   contratoPeticion
				= (FichaEspecialPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
	LogHandler.info(uid, getClass(), "generaFichaEspecialPago - Datos de entrada : " + contratoPeticion);

	//Llamado a funci�n principal
	final FichaEspecialRespuesta respuesta = kitImpresion.generaFichaEspecialPago(uid, contratoPeticion);
	LogHandler.info(uid, getClass(), "generaFichaEspecialPago - Datos de salida: " + respuesta);

	//Se genera la salida
	final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
	LogHandler.info(uid, getClass(), "generaFichaEspecialPago - Datos de salida XML: " + respuestaXML);
	return respuestaXML;


}

	/**
	 * Metodo individual para actualizar la opcion de la garantia para productos de garantia.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String guardarOpcionGarantia(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "guardarOpcionGarantia - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {GuardarOpcionGarantiaPeticion.class,
								   EncabezadoRespuesta.class,
								   GuardarOpcionGarantiaRespuesta.class};

		//Conversion de XML a Object
		final GuardarOpcionGarantiaPeticion   objetoPeticion
					= (GuardarOpcionGarantiaPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "guardarOpcionGarantia - Datos de entrada : " + objetoPeticion);

		//Llamado a funci�n principal
		final GuardarOpcionGarantiaRespuesta respuesta = credito.guardarOpcionGarantiaTarea(uid, objetoPeticion);
		LogHandler.info(uid, getClass(), "guardarOpcionGarantia - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "guardarOpcionGarantia - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Generar ficha pago.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String generarFichaPago(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "generaFichaPago - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {FichaPagoPeticion.class,
								   EncabezadoRespuesta.class,
								   FichaPagoRespuesta.class,
								   PagoGrupo.class};

		//Conversion de XML a Object
		final FichaPagoPeticion   contratoPeticion
					= (FichaPagoPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "generaFichaPago - Datos de entrada : " + contratoPeticion);

		//Llamado a funci�n principal
		final FichaPagoRespuesta respuesta = kitImpresion.generaFichaPagoTarea(uid, contratoPeticion);
		LogHandler.info(uid, getClass(), "generaFichaPago - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "generaFichaPago - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}




	public String generarKitImpresionPagare(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "generaPagareComunalDepositoGarantia - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ContratoPeticionKit.class,
								   AvalGrupo.class,
								   MiembroGrupoKitPagare.class,
								   KitImpresionPagareRespuesta.class,
								   PagoGrupo.class,
								   EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ContratoPeticionKit   contratoPeticion
		                       = (ContratoPeticionKit) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "generaPagareComunalDepositoGarantia - Datos de entrada : " + contratoPeticion);

		//Llamado a funci�n principal
		final KitImpresionPagareRespuesta respuesta = kitImpresion.generarKitImpresionPagareTarea(uid, contratoPeticion);
		LogHandler.info(uid, getClass(), "generaPagareComunalDepositoGarantia - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "generaPagareComunalDepositoGarantia - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}
	
	
	public KitImpresionPagareRespuesta generarKitImpresionPagareObjetos(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "generaPagareComunalDepositoGarantia - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ContratoPeticionKit.class,
								   AvalGrupo.class,
								   MiembroGrupoKitPagare.class,
								   KitImpresionPagareRespuesta.class,
								   PagoGrupo.class,
								   EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ContratoPeticionKit   contratoPeticion
		                       = (ContratoPeticionKit) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "generaPagareComunalDepositoGarantia - Datos de entrada : " + contratoPeticion);

		//Llamado a funci�n principal
		final KitImpresionPagareRespuesta respuesta = kitImpresion.generarKitImpresionPagareTarea(uid, contratoPeticion);
		LogHandler.info(uid, getClass(), "generaPagareComunalDepositoGarantia - Datos de salida: " + respuesta);

		return respuesta;
	}


	/**
	 * Generar kit impresion pre solicitud.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String generarKitImpresionPreSolicitud(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "generaPagareComunalDepositoGarantia - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {PreSolicitudPeticion.class,
									ContratoVO.class,
									MiembroGrupoVO.class,
									OportunidadContratoOV.class,
								   PreSolicitudRespuesta.class,
								   DatosCreditoIntegrantesRespuesta.class,
								   DatosCreditoOV.class,
								   DatosIntegranteResumenOV.class,
								   EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final PreSolicitudPeticion   metodoPeticion
		                       = (PreSolicitudPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "generaPagareComunalDepositoGarantia - Datos de entrada : " + metodoPeticion);

		//Llamado a función principal
		final PreSolicitudRespuesta respuesta = kitImpresion.generarPreSolicitudCreditoTarea(uid, metodoPeticion);
		LogHandler.info(uid, getClass(), "generaPagareComunalDepositoGarantia - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "generaPagareComunalDepositoGarantia - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Verifica si la solicitud ya tiene confirmacion de verificacion telefonica
	 * @param peticion the peticion
	 * @return the string
	 */
	public String confirmarSolicitudVerificacionTelefonica(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "confirmaSolicitudVerificacionTelefonica - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ConfirmarCreditoPeticion.class,
								   ConfirmarCreditoRespuesta.class,
								   EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ConfirmarCreditoPeticion   metodoPeticion
		                       = (ConfirmarCreditoPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "confirmaSolicitudVerificacionTelefonica - Datos de entrada : " + metodoPeticion);

		//Llamado a función principal
		final ConfirmarCreditoRespuesta respuesta = credito.confirmaSolicitudVerificacionTelefonica(uid, metodoPeticion);
		LogHandler.info(uid, getClass(), "confirmaSolicitudVerificacionTelefonica - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "confirmaSolicitudVerificacionTelefonica - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * Genera el nuevo contrato
	 * @param peticion the peticion
	 * @return the String
	 */
	public String generaContratoFinsol(String peticion) {
		// TODO Auto-generated method stub
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "generaContratoFinsol - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ContratoPeticionKit.class,
								   ContratoFinsolOV.class,
								   MiembroGrupoVO.class,
								   AmortizacionActualOV.class,
								   EncabezadoRespuesta.class,
								   CreditoGrupalCSOV.class,
								   CreditoOportunidadOV.class,
								   CartaInstruccionOV.class,
								   ContratoFinsolRespuesta.class};
		//Conversion de XML a Object
		final ContratoPeticionKit   contratoPeticion
		                       = (ContratoPeticionKit) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "generaContratoFinsol - Datos de entrada : " + contratoPeticion);

		//Llamado a funcion principal
		final ContratoFinsolRespuesta respuesta = kitImpresion.generaContratoFinsol(uid, contratoPeticion);
		LogHandler.info(uid, getClass(), "generaContratoFinsol - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "generaContratoFinsol - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	public ConfirmarCreditoRespuesta aplicarPagoDocumento(PagoDocumentoPeticion peticion) {
		//Se genera el idenificador unico para rastrear la operacion.
		final String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "aplicarPagoDocumento - Datos de entrada : " + peticion);

		//Salida
		final ConfirmarCreditoRespuesta respuesta = credito.aplicarPagoDocumento(uid, peticion);
		LogHandler.info(uid, getClass(), "aplicarPagoDocumento - Datos de salida : " + respuesta);
		return respuesta;
	}
}
