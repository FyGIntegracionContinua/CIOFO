
package negocio.originacion;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.oasisopen.sca.annotation.Remotable;

import utilitario.mensajes.impresiondocs.ImpresionDocsConsultaPeticion;
import utilitario.mensajes.impresiondocs.ImpresionDocsConsultaRespuesta;
import utilitario.mensajes.impresiondocs.comun.PreSolicitudRespuesta;
import utilitario.mensajes.impresiondocs.contratocomunal.KitImpresionPagareRespuesta;
import utilitario.mensajes.originacion.aprobacion.PlanillaAprobacionPeticion;
import utilitario.mensajes.originacion.aprobacion.PlanillaAprobacionRespuesta;
import utilitario.mensajes.originacion.cheques.ClientesChequesRespuesta;
import utilitario.mensajes.originacion.cheques.ContratoChequesPeticion;
import utilitario.mensajes.originacion.cheques.ContratoChequesRespuesta;
import utilitario.mensajes.originacion.cliente.ActualizarChequeClientePeticion;
import utilitario.mensajes.originacion.cliente.ClientePeticion;
import utilitario.mensajes.originacion.cliente.ClienteRespuesta;
import utilitario.mensajes.originacion.consulta.ConfirmarCreditoRespuesta;
import utilitario.mensajes.originacion.consulta.ConsultaPeticion;
import utilitario.mensajes.originacion.consulta.ConsultaRespuesta;
import utilitario.mensajes.originacion.consulta.PagoDocumentoPeticion;
import utilitario.mensajes.originacion.contrato.ContratoPeticion;
import utilitario.mensajes.originacion.contrato.ContratoRespuesta;
import utilitario.mensajes.originacion.desembolso.DesembolsoPeticion;
import utilitario.mensajes.originacion.desembolso.DesembolsoRespuesta;
import utilitario.mensajes.originacion.grupo.GrupoPeticion;
import utilitario.mensajes.originacion.grupo.GrupoRespuesta;

 /**
 * @version 1.0.0
 * @author Juan Moreno
 * Encapsula las operaciones del componente de OriginacionCreditoGrupal de credito Grupal.
 * <ul>
 * 	<li>Registro de Persona</li>
 * 	<li>Registro de OriginacionGrupo</li>
 * 	<li></li>
 * </ul>
 */

@Remotable
@WebService(name = "OriginacionCreditoGrupal", targetNamespace = "http://fisa.com.mx/CIOF/OriginacionCreditoGrupal/V1.0")
public interface OriginacionCreditoGrupal {

	/**
	 * Servicio de Negocio que valida que la fecha de inicio de un Cr�dito Grupal en CREDPROD sea valida.
	 * @param ConsultaPeticion
	 * @param request :
	 * @return ConsultaRespuesta
	 */
	public ConsultaRespuesta validarFechaInicioContrato(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/OriginacionCreditoGrupal/V1.0")
			ConsultaPeticion request );
	/**
	 * Servicio de Negocio que calcula la fecha final de un Cr�dito Grupal en CREDPROD.
	 * @param ConsultaPeticion
	 * @param request :
	 * @return ConsultaRespuesta
	 */
	public ConsultaRespuesta calcularFechaFinContrato(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/OriginacionCreditoGrupal/V1.0")
			ConsultaPeticion request );
	/**
	 * Servicio de Negocio que obtiene la fecha del sistema CREDPROD.
	 * @param ConsultaPeticion
	 * @param request :
	 * @return ConsultaRespuesta
	 */
	public ConsultaRespuesta obtenFecha(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/OriginacionCreditoGrupal/V1.0")
			ConsultaPeticion request  );

	/**
	 * Servicio de Negocio que encapsula la l�gica para registrar un cliente en CREDPROD.
	 * @param ChequesPeticion
	 * @param request :
	 * @return ContratoChequesRespuesta
	 */
	public ClienteRespuesta registrarCliente(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/OriginacionCreditoGrupal/V1.0")
			ClientePeticion request );
	/**
	 * Servicio de Negocio que encapsula la l�gica para registrar un cliente en CREDPROD.
	 * @param  ChequesPeticion
	 * @param request :
	 * @return ContratoChequesRespuesta
	 */
	public ClienteRespuesta actualizarCliente(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/OriginacionCreditoGrupal/V1.0")
			ClientePeticion request);
	/**
	 * Servicio de Negocio que encapsula la l�gica para registrar un grupo en CREDPROD.
	 * @param GrupoPeticion
	 * @param request :
	 * @return GrupoRespuesta
	 */
	public GrupoRespuesta registrarGrupo(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/OriginacionCreditoGrupal/V1.0")
			GrupoPeticion request );

	/**
	 * Servicio de Negocio que encapsula la l�gica para registrar un grupo en CREDPROD.
	 * @param GrupoPeticion
	 * @param request :
	 * @return GrupoRespuesta
	 */
	public GrupoRespuesta actualizarGrupo(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/OriginacionCreditoGrupal/V1.0")
			GrupoPeticion request);

	/**
	 * Servicio de Negocio que encapsula la l�gica para registrar un grupo Cr�dito Grupal en CREDPROD.
	 * @param ContratoPeticion
	 * @param request :
	 * @return ContratoRespuesta
	 */
	public ContratoRespuesta registrarContrato(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/OriginacionCreditoGrupal/V1.0")
			ContratoPeticion request );
	/**
	 * Servicio de Negocio que realiza el desembolso de un cr�dito, se lanza en automatico cuando coincide la fecha
	 * de desembolso con la fecha
	 * contable se realiza de inmediato.
	 * @param DesembolsoPeticion
	 * @param peticion :
	 * @return DesembolsoRespuesta
	 */
 	public DesembolsoRespuesta	realizarDesembolso(
 			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/OriginacionCreditoGrupal/V1.0")
 			DesembolsoPeticion peticion );
 	/**
 	 * Genera un documento del Kit de Impresion, basado en la peticion.
 	 * @param peticion
 	 * @param peticion :
 	 * @return ImpresionDocsConsultaRespuesta
 	 */
	public ImpresionDocsConsultaRespuesta  generaDocumentoKitImpresion(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/OriginacionCreditoGrupal/V1.0")
			ImpresionDocsConsultaPeticion peticion);

	/**
	 * Genera la cadena OFS correspondente a la Planilla de aprobacion del contrato proporcionado
	 * @param peticion datos necesarios para la generacion de la planilla [numeroContrato] [encabezado]
	 * @return cadena OFS
	 */
	public PlanillaAprobacionRespuesta obtenerPlantillaAprobacionOFS(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/OriginacionCreditoGrupal/V1.0")
			PlanillaAprobacionPeticion peticion);

	/**
	 * Recibe el objeto correspondente a la consulta de contrato para la generacion de cheques SIC
	 * @param peticion :
	 * @return ContratoChequesRespuesta
	 */
	public ContratoChequesRespuesta consultarContratoChequesSIC(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/OriginacionCreditoGrupal/V1.0")
			ContratoChequesPeticion peticion);

	/**
	 * Recibe el obejto correspondente a la consulta de los clientes para la generacion de cheques SIC
	 * @param peticion :
	 * @return ClientesChequesRespuesta
	 */
	public  ClientesChequesRespuesta consultarClientesChequesSIC(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/OriginacionCreditoGrupal/V1.0")
			ContratoChequesPeticion peticion);


	/**
	 * @param peticion :
	 * @return GrupoRespuesta
	 */
	public GrupoRespuesta existeGrupo(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/OriginacionCreditoGrupal/V1.0")
			GrupoPeticion peticion);

	/**
	 * Metodo para actualizar el numero de cheque de algun integrante
	 * @param peticion :
	 * @return ClienteRespuesta
	 */
	public ClienteRespuesta actualizarNumeroCheque(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/OriginacionCreditoGrupal/V1.0")
			ActualizarChequeClientePeticion peticion);

	/**
	 *
	 * @param request :
	 * @return ContratoRespuesta
	 */
	public ContratoRespuesta registrarContratoRestructura(ContratoPeticion request );

	/**
	 *
	 * @param peticion :
	 * @return ContratoRespuesta
	 */
	public String generaContratoComunalDepositoGarantia(String peticion );

	/**
	 *
	 * @param peticion :
	 * @return ContratoRespuesta
	 */
	public String generaPagareComunalDepositoGarantia(String peticion );

	/**
	 *
	 * @param peticion :
	 * @return ContratoRespuesta
	 */
	public String generaConvenioReestructura(String peticion );

	/**
	 *
	 * @param peticion :
	 * @return ContratoRespuesta
	 */
	public String generaPagareReestructura(String peticion );

	/**
	 * @param peticion :
	 * @return respuesta
	 */
	public String consultarSimuladorReestructuras(String peticion);

	/**
	 * @param peticion :
	 * @return respuesta
	 */
	public String insertarSimuladorReestructuras(String peticion);

	/**
	 * @param request :
	 * @return ContratoRespuesta
	 */
	public ContratoRespuesta registrarContratoVentaCartera(ContratoPeticion request);

	/**
	 * Valida pago garantia.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String validaPagoGarantia(String peticion);

	/**
	 * Confirmar credito.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String confirmarCredito(String peticion);

	/**
	 * @param peticion :
	 * @return String
	 */
	public String generaFichaEspecialPago(String peticion);

	/**
	 * @param peticion :
	 * @return String
	 */
	public String guardarOpcionGarantia(String peticion);


	/**
	 * Generar ficha pago.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String generarFichaPago(String peticion);

	/**
	 * Generar kit impresion pagare.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String generarKitImpresionPagare(String peticion);

	/**
	 * Generar kit impresion pagare.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public KitImpresionPagareRespuesta generarKitImpresionPagareObjetos(String peticion);

	/**
	 * Generar kit impresion pre solicitud.
	 *
	 * @param peticion the peticion
	 * @return the string
	 */
	public String generarKitImpresionPreSolicitud(String peticion);

	/**
	 * Verifica si la solicitud ya tiene confirmacion de verificacion telefonica
	 * @param peticion the peticion
	 * @return the string
	 */
	public String confirmarSolicitudVerificacionTelefonica(String peticion);

	/**
	 * Genera el nuevo contrato
	 * @param peticion the peticion
	 * @return the String
	 */
	public String generaContratoFinsol(String peticion);
	
	public ConfirmarCreditoRespuesta aplicarPagoDocumento(PagoDocumentoPeticion peticion);
}

