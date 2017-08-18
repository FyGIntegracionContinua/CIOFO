/**
 *
 */
package negocio.procesarOFS;

import java.util.HashMap;

import org.osoa.sca.annotations.Reference;

import parser.Parser;
import tarea.administracion.AdministracionCredito;
import tarea.cheques.ChequesSIC;
import tarea.comun.ReadProperties;
import tarea.condonaciones.CondonacionesManuales;
import tarea.consultas.Consultas;
import tarea.impresiondocs.ImpresionDocsInformacion;
import tarea.operacion.PagosCredito;
import tarea.originacion.OriginacionCliente;
import tarea.originacion.OriginacionConsultas;
import tarea.originacion.OriginacionCredito;
import tarea.originacion.OriginacionGrupo;
import transformador.Transformador;
import utilitario.comun.GUIDGenerator;
import utilitario.log.LogHandler;
import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ErrorTransformacion;
import utilitario.mensajes.comun.ObjetoValor;
import utilitario.mensajes.condonaciones.AplicarCondonacionTotalPeticion;
import utilitario.mensajes.condonaciones.ConsultaDatosPeticion;
import utilitario.mensajes.impresiondocs.ImpresionDocsConsulta;
import utilitario.mensajes.operacion.pagos.PagoGrupal;
import utilitario.mensajes.originacion.cheques.ChequesPeticion;
import utilitario.mensajes.originacion.cliente.ClienteOV;
import utilitario.mensajes.originacion.cliente.ClientePeticion;
import utilitario.mensajes.originacion.consulta.ConsultaFechaOV;
import utilitario.mensajes.originacion.grupo.GrupoOV;

/**
 * @author out_jcmoreno
 *
 */
public class ProcesaOFSCreditoGrupalImpl implements ProcesaOFSCreditoGrupal {

	/**
	 * SCA Componente Fabric
	 */
 	private Transformador transformador;
 	/**
	 * SCA Componente Fabric
	 */
	private OriginacionCliente cliente;
	/**
	 * SCA Componente Fabric
	 */
	private OriginacionGrupo grupo;
	//private OriginacionCredito credito;
	/**
	 * SCA Componente Fabric
	 */
	private OriginacionConsultas originacionConsultas;
	/**
	 * SCA Componente Fabric
	 */
	private ChequesSIC cheques;
	/**
	 * SCA Componente Fabric
	 */
	private ImpresionDocsInformacion kitImpresion;
	/**
	 * SCA Componente Fabric
	 */
	private PagosCredito pagos;
	/**
	 * SCA Componente Fabric
	 */
	private Consultas consultas;
	/**
	 * SCA Componente Fabric
	 */
	private CondonacionesManuales condonaciones;

	/**
	 * Metodo para procesar OFS
	 * @param transformador SCA
	 * @param cliente SCA
	 * @param grupo SCA
	 * @param originacionConsultas SCA
	 * @param credito SCA
	 * @param cheques SCA
	 * @param kitImpresion SCA
	 * @param pagos SCA
	 * @param administracion SCA
	 * @param consultas SCA
	 * @param condonaciones SCA
	 */
	public ProcesaOFSCreditoGrupalImpl(@Reference(name = "transformador") Transformador transformador,
			@Reference(name = "cliente")  OriginacionCliente cliente,
			@Reference(name = "grupo")  OriginacionGrupo grupo,
			@Reference(name = "originacionConsultas") OriginacionConsultas originacionConsultas,
			@Reference(name = "credito")  OriginacionCredito credito,
			@Reference(name = "cheques")  ChequesSIC cheques,
			@Reference(name = "kitImpresion")  ImpresionDocsInformacion kitImpresion,
			@Reference(name = "pagos")  PagosCredito pagos,
			@Reference(name = "administracion")  AdministracionCredito administracion,
			@Reference(name = "consultas")  Consultas consultas,
			@Reference(name = "condonaciones")  CondonacionesManuales condonaciones) {


		this.cliente = cliente;
		this.grupo  = grupo;
		//this.credito = credito;
		this.cheques = cheques;
		this.transformador = transformador;
		this.pagos = pagos;
		this.kitImpresion = kitImpresion;
		this.consultas = consultas;
		this.originacionConsultas = originacionConsultas;
		this.condonaciones = condonaciones;
	}


	/**
	 * @param peticion procesar OFS
	 * @return OFS Response
	 */
	public String procesarOFSCreditoGrupal(String peticion) {
		ObjetoValor ovRespuesta = null;
		String uid = GUIDGenerator.generateGUID(peticion);
		try {
			LogHandler.info(uid, getClass(), "Valor de entrada, cadena OFS = " + peticion);
			final ObjetoValor ovPeticion = transformador.transformaStringAObjetoValor(uid, peticion);

			if (ovPeticion == null || ovPeticion instanceof ErrorTransformacion) {
				return transformador.transformaObjetoValorAString(uid, ovPeticion);
			}
			int tipo = ovPeticion.getTipo();
			LogHandler.debug(uid, this.getClass(), "procesarOFSCreditoGrupal tipo: " + tipo + "  Objeto: "
							 + ovPeticion.getClass().getCanonicalName());
 		 	switch (tipo) {
	 			case Parser.ALTA_CLIENTE :
	 				ovRespuesta = altaCliente(uid, ovPeticion);	break;
	 			case Parser.MODIFICACION_CLIENTE :
	 				ovRespuesta = modificaCliente(uid, ovPeticion); break;
	 			case Parser.ALTA_GRUPO :
	 				ovRespuesta = altaGrupo(uid, ovPeticion); break;
	 			case Parser.MODIFICACION_GRUPO:
	 				ovRespuesta = modificaGrupo(uid, (GrupoOV) ovPeticion); break;

	 			/**
	 			 * Esta parte debe ser removida, para retirar el soporte de alta de credito, a traves de OFS
	 			 */
	 			case Parser.ALTA_CREDITO:
	 				ovRespuesta = null/*credito.registrar( uid, ( ContratoOV ) ovPeticion )*/; break;
	 			/**
	 			 * Parte a modificar
	 			 */

	 			case Parser.ALTA_CLIENTE_UNICO:
	 				ovRespuesta = altaCliente(uid, ovPeticion); break;
		 		case Parser.VALIDA_FECHA_INICIO:
		 			ovRespuesta = null /*originacionConsultas.validarFechaInicioContrato(uid,(ConsultaFechaOV ) ovPeticion ) */;
		 			break;
		 		case Parser.CALCULA_FECHA_FIN:
		 			ovRespuesta =  null; /*originacionConsultas.calcularFechaFinContrato(uid,(ConsultaFechaOV ) ovPeticion ) ;*/
		 			break;
		 		case Parser.OBTEN_FECHA:
		 			ovRespuesta =  originacionConsultas.obtenFecha(uid, (ConsultaFechaOV) ovPeticion); break;
		 		case Parser.APLICA_PAGO:
		 			ovRespuesta =  pagos.aplicarPagoGrupal(uid, (PagoGrupal) ovPeticion); break;
		 		case Parser.CONSULTA_PD:
		 			ovRespuesta =  consultas.consultarDatosSaldoVencido(uid, (ConsultaDatosPeticion) ovPeticion);	break;
		 		case Parser.CONDONACION_PARCIAL:
		 			ovRespuesta =  condonaciones.aplicarCondonacionTotal(uid, (AplicarCondonacionTotalPeticion) ovPeticion);
		 			break;
		 		case Parser.INFO_CHEQUES_GRAL:
	 				ovRespuesta =  cheques.consultaContratoChequesSIC(uid, (ChequesPeticion) ovPeticion);	break;
		 		case Parser.WEB_CHEQUES_GRAL://Método para generar los cheques web
		 			ovRespuesta =  cheques.consultaContratoChequesSIC(uid, (ChequesPeticion) ovPeticion);	break;
		 		case Parser.INFO_CHEQUES_CLIENTES:
	 				ovRespuesta =  cheques.consultaClientesChequesSIC(uid, (ChequesPeticion) ovPeticion);	break;
		 		case Parser.WEB_CHEQUES_CLIENTES://Metodo para generar la info de clientes en cheques web
	 				ovRespuesta =  cheques.consultaClientesChequesSIC(uid, (ChequesPeticion) ovPeticion);	break;
		 		case Parser.KIT_FIN_CONTRACT:
		 			ovRespuesta  =  kitImpresion.generaDocumentoKitImpresion(uid, (ImpresionDocsConsulta) ovPeticion);	break;
 		 		case Parser.KIT_FIN_PROMISE_NOTE:
 		 			ovRespuesta  =  kitImpresion.generaDocumentoKitImpresion(uid, (ImpresionDocsConsulta) ovPeticion);	break;
		 		case Parser.KIT_FIN_PAYMENT:
		 			ovRespuesta  =  kitImpresion.generaDocumentoKitImpresion(uid, (ImpresionDocsConsulta) ovPeticion);	break;
	 			default:
	 				ovRespuesta = null;
		 	}
		 	if (ovRespuesta != null) {
		 		LogHandler.debug(uid,  getClass(), "Tipo para transformaObjetoValorAString: " + tipo);
		 		ovRespuesta.setTipo(tipo);
		 	}
		} catch (Exception e) {
			LogHandler.error(uid,  getClass(), "Existio un error dentro de ProcesaOFSCreditoGrupal", e);
			ovRespuesta = null;
		}
		//Se recupera la cadena de salida
		final java.lang.String
						oFSSalida = transformador.transformaObjetoValorAString(uid, ovRespuesta);
		LogHandler.info(uid, getClass(), "Valor de salida, cadena OFS = " + oFSSalida);

		return oFSSalida;
	}

	/**
	 * @param uid :
	 * @param ovPeticion :
	 * @return ObjetoValor :
	 */
	private ObjetoValor altaCliente(String uid, ObjetoValor ovPeticion) {
		ObjetoValor ovRespuesta;
		//Genera un valor secuencial correspondiente al potencial neuvo cliente en el formato 0000099
		HashMap<String, String> id = cliente.obtenerIdentificador(uid, null, null);
		LogHandler.debug(uid, getClass(), "procesarOFSCreditoGrupal altaCliente 152 identificador: " + id);
		if (id != null ) {
			ClienteOV clienteOv = (ClienteOV) ovPeticion;
			clienteOv.setPersona(id.get("credprod"));
			clienteOv.setClienteT24(id.get("t24"));
			ClientePeticion peticion = new ClientePeticion();
			peticion.setHeader(new EncabezadoPeticion());
			peticion.getHeader().setConsumer("CTEU");
			peticion.getHeader().setCorrelationId("");
			peticion.setBody(clienteOv);

			ovRespuesta =   cliente.registrar(uid, peticion);
		} else {
			ovRespuesta  = new ErrorTransformacion(0, "No se pudo Obtener el identificador unico de la Persona");
		}
		return ovRespuesta;
	}

	/**
	 *
	 * @param uid :
	 * @param ovPeticion :
	 * @return ObjetoValor :
	 */
	private ObjetoValor modificaCliente(String uid, ObjetoValor ovPeticion) {
		ObjetoValor ovRespuesta;
		ClienteOV clienteOv = (ClienteOV) ovPeticion;
		if (clienteOv.getPersona() ==  null) {
			LogHandler.info(uid, getClass(), "No Se Envio el identificador unico de la Persona, no se puede Actualizar.");
			ovRespuesta  = new ErrorTransformacion(0,
							"No Se Envio el identificador unico de la Persona  no se puede Actualizar.");
			return ovRespuesta;
		}
		LogHandler.debug(uid, getClass(), "procesarOFSCreditoGrupal 165 modificaCliente identificador: "
						+ clienteOv.getPersona() );

		clienteOv.setClienteT24(clienteOv.getPersona() );
		clienteOv.setPersona(cliente.obtenerClaveCredprod(uid, clienteOv.getPersona() ));

		if (cliente.existe(uid, clienteOv.getPersona() ) ) {

			ClientePeticion peticion = new ClientePeticion();
			peticion.setHeader(new EncabezadoPeticion());
			peticion.getHeader().setConsumer("CTEU");
			peticion.getHeader().setCorrelationId("");
			peticion.setBody(clienteOv);

			ovRespuesta = cliente.actualizar(uid, peticion );
			LogHandler.debug(uid, getClass(), "procesarOFSCreditoGrupal 165 modificaCliente  HECHO: " );
			clienteOv.setPersona(clienteOv.getClienteT24() );
		}
		else {
			LogHandler.info(uid, getClass(), "No Existe la Persona " + clienteOv.getPersona() + "  No se puede Actualizar.");
			ovRespuesta  = new ErrorTransformacion(0, "No Existe la Persona " + clienteOv.getPersona()
													+ "  No se puede Actualizar.");
		}
		return ovRespuesta;
	}

	/**
	 *
	 * @param uid :
	 * @param ovPeticion :
	 * @return ObjetoValor :
	 */
	private ObjetoValor altaGrupo(String uid, ObjetoValor ovPeticion ) {
		ObjetoValor ovRespuesta;
		//Genera un valor secuencial correspondiente al potencial neuvo cliente en el formato 0000099
		HashMap<String, String> id = grupo.obtenerIdentificador(uid );
		LogHandler.debug(uid, getClass(), "procesarOFSCreditoGrupal altaGrupo 197 identificador: " + id );
		if (id != null  ) {
			GrupoOV grupoOv = (GrupoOV) ovPeticion;
			grupoOv.setIdentificador(id.get("credprod" ) );
			grupoOv.setClienteT24(id.get("t24"));
			ovRespuesta =  grupo.registrar(uid, grupoOv);
		} else {
			ovRespuesta  = new ErrorTransformacion(0, "No Se pudo Obtener el identificador unico del Grupo");
		}
		return ovRespuesta;
	}

	/**
	 *
	 * @param uid :
	 * @param ovPeticion :
	 * @return ObjetoValor :
	 */
	private ObjetoValor modificaGrupo(String uid, ObjetoValor ovPeticion) {
		ObjetoValor ovRespuesta;
		GrupoOV grupoOv = (GrupoOV) ovPeticion;
		if (grupoOv.getIdentificador() ==  null) {
			LogHandler.info(uid, getClass(), "No Se Envio el identificador unico del Grupo no se puede Actualizar.");
			ovRespuesta  = new ErrorTransformacion(0, "No Se Envio el identificador unico del Grupo  no se puede Actualizar.");
			return ovRespuesta;
		}
		LogHandler.debug(uid, getClass(), "procesarOFSCreditoGrupal 165 modificaCliente identificador: "
		+ grupoOv.getIdentificador());
		grupoOv.setClienteT24(grupoOv.getIdentificador());

		//Se recupera la relacion
		grupoOv.setIdentificador(cliente.obtenerClaveCredprod(uid, grupoOv.getIdentificador()));

		//Si no trae algo, genera excepcion
		if (grupoOv.getIdentificador() == null || grupoOv.getIdentificador().trim().equals(""))
			{
			LogHandler.error(uid, getClass(),
					ReadProperties.mensajes.getProp("reportes.obtenerestadocuenta.errorgrupoinexistente" ),
					new Exception(ReadProperties.mensajes.getProp("reportes.obtenerestadocuenta.errorgrupoinexistente")));
			return new ErrorTransformacion(0, "No Existe la Persona " + grupoOv.getIdentificador() + "  No se puede Actualizar.");
			}

		if (grupo.existe(uid, grupoOv.getIdentificador())) {
			ovRespuesta = grupo.actualizar(uid, grupoOv);
			LogHandler.debug(uid, getClass(), "procesarOFSCreditoGrupal 165 modificaCliente  HECHO: ");
			grupoOv.setIdentificador(grupoOv.getClienteT24());
		}
		else {
			LogHandler.info(uid, getClass(), "No Existe el Grupo " + grupoOv.getIdentificador() + "  No se puede Actualizar.");
			ovRespuesta  = new ErrorTransformacion(0, "No Existe la Persona " + grupoOv.getIdentificador()
					+ "  No se puede Actualizar.");
		}
		return ovRespuesta;
	}
}
