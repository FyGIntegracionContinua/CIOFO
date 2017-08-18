/**
 *
 */
package negocio.administracion;

import javax.jws.WebParam;
import javax.jws.WebService;

import utilitario.comun.GUIDGenerator;
import utilitario.log.LogHandler;
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
import utilitario.mensajes.administracion.contrato.ReasignarCarteraPeticion;
import utilitario.mensajes.administracion.contrato.ReasignarCarteraRespuesta;
import utilitario.mensajes.administracion.contrato.RegistrarSolicitudReasignarCarteraPeticion;
import utilitario.mensajes.administracion.contrato.RegistrarSolicitudReasignarCarteraRespuesta;
import utilitario.mensajes.administracion.contrato.RevertirSaldoAFavorPeticion;
import utilitario.mensajes.administracion.contrato.RevertirSaldoAFavorRespuesta;
import utilitario.mensajes.administracion.contrato.TransferirSaldosAFavorCreditosVigentesRespuesta;
import utilitario.mensajes.administracion.contrato.TrasferirSaldosAFavorCreditosVigentesPeticion;
import utilitario.mensajes.condonaciones.AplicarCondonacionParcialPeticion;
import utilitario.mensajes.condonaciones.AplicarCondonacionParcialRespuesta;
import utilitario.mensajes.condonaciones.AplicarCondonacionTotalPeticion;
import utilitario.mensajes.condonaciones.AplicarCondonacionTotalRespuesta;
import utilitario.mensajes.consultas.RespuestaSucursalOV;
import utilitario.mensajes.grupos.gps.GruposGPSPeticion;
import utilitario.mensajes.grupos.gps.GruposGPSRespuesta;
import utilitario.mensajes.operacion.administracion.SucursalPeticion;
import utilitario.mensajes.originacion.cancelacion.CancelacionContratoPeticion;
import utilitario.mensajes.originacion.cancelacion.CancelacionContratoRespuesta;
import utilitario.mensajes.originacion.cliente.ClienteRespuesta;
import utilitario.mensajes.originacion.cliente.RegistrarTelefonoPeticion;

/**
 * @version 1.0.0
 * @author out_oarias
 *
 */

@WebService(name = "AdministracionCreditoGrupal", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionCreditoGrupal/V1.0")
public interface AdministracionCreditoGrupal {
	/**
	 * Realiza el Ajuste de la tasa del contrato
	 * @param  peticion contiene los datos necesarios para realizar el ajuste [contrato] [tasa] [usuario]
	 * @return Resultado de la operacion
	 */
	public AjusteRespuesta ajustarTasa(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionCreditoGrupal/V1.0")
			AjusteTasaPeticion peticion);

	/**
	 * Realiza el Ajuste del plazo del contrato
	 * @param peticion contiene los datos necesarios para realizar el ajuste [contrato] [plazo] [usuario]
	 * @return Resultado de la operacion
	 */
	public AjusteRespuesta ajustarPlazo(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionCreditoGrupal/V1.0")
			AjustePlazoPeticion peticion);

	/**
	 * Realiza el Ajuste del Dia de Pago.
	 * @param peticion contiene lso datos necesarios para realizar el ajuste [contrato] [dia] [usuario]
	 * @return Resultado de la operacion
	 */
	public AjusteRespuesta ajustarDiaPago(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionCreditoGrupal/V1.0")
			AjusteDiaPagoPeticion peticion);

	/**
	 * Realiza el Ajuste del contrato por la devolucion del cheque de 1 integrante del grupo
	 *
	 * @param peticion	peticion para ajuste de cheque
	 * @return Resultado de la operacion
	 */
	public AjusteChequeDevueltoRespuesta ajustarPorChequeDevuelto(
			@WebParam(name = "peticion", 	targetNamespace = "http://fisa.com.mx/CIOF/AdministracionCreditoGrupal/V1.0")
			AjusteChequeDevueltoPeticion peticion);

	/**
	 * Realiza la condonacion parcial de un credito
	 *
	 * @param peticion
	 *             Incluye los datos necesarios para la condonacion en un arreglo de cadenas
	 *            [credito],[capital],[interes],[recargo],[motivo]
	 *            y una cadena que se usaba como referencia para recibir el detalle de la operacion
	 * @return Resultado de la operacion
	 */
	public AplicarCondonacionParcialRespuesta aplicarCondonacionParcial(AplicarCondonacionParcialPeticion peticion);


	/**
	 * Realiza la condonacion parcial de un credito
	 *
	 * @param peticion
	 *             Incluye los datos necesarios para la condonacion en un arreglo de cadenas
	 *            [credito],[capital],[interes],[recargo],[motivo]
	 *            y una cadena que se usaba como referencia para recibir el detalle de la operacion
	 * @return Resultado de la operacion
	 */
	public AplicarCondonacionTotalRespuesta aplicarCondonacionTotal(AplicarCondonacionTotalPeticion peticion);

	/**
	 * Funcion de Negocio que cancela un credito grupal seg�n sus reglas de operaci�n
	 * @param peticion :
	 * @return CancelacionContratoRespuesta
	 */
	public CancelacionContratoRespuesta cancelarContrato(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionCreditoGrupal/V1.0")
			CancelacionContratoPeticion peticion );

	/**
	 * Funcion para realizar la transferencia de un saldo a favor de algun contrato
	 * que tenga estatus de pagado a un contrato con estatus de disponible
	 * @param peticion :
	 * @return AjusteSaldoAFavorRespuesta
	 */
	public AjusteSaldoAFavorRespuesta transferirSaldoAFavor(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionCreditoGrupal/V1.0")
			AjusteSaldoAFavorPeticion peticion);

	/**
	 * Funcion para quitar el saldo a favor de un contrato en estatus de pagado
	 * @param peticion :
	 * @return EliminarSaldoAFavorRespuesta
	 */
	public EliminarSaldoAFavorRespuesta eliminarSaldoAFavor(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionCreditoGrupal/V1.0")
			EliminarSaldoAFavorPeticion peticion);

	/**
	 * Funcion para cancelar la eliminacion de saldo a favor
	 * @param peticion :
	 * @return RevertirSaldoAFavorRespuesta
	 */
	public RevertirSaldoAFavorRespuesta revertirSaldoAFavor(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionCreditoGrupal/V1.0")
			RevertirSaldoAFavorPeticion peticion);

	/**
	 * Metodo principal para realizar la reaccion de cartera entre sucursales y asesores
	 * @param peticion :
	 * @return ReasignarCarteraRespuesta
	 */
	public ReasignarCarteraRespuesta reasignarCartera(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/reasignarCartera/V1.0")
			ReasignarCarteraPeticion peticion );

	/**
	 * Metodo principal para realizar la reaccion de cartera entre sucursales y asesores, mediante XMLs
	 * @param peticion :
	 * @return String
	 */
	public java.lang.String reasignarCarteraXML(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/reasignarCartera/V1.0")
			java.lang.String peticion );

	/**
	 * Funcion para actualizar el dia de reunion de un grupo
	 * @param peticion :
	 * @return AjusteDiaReunionRespuesta
	 */
	public AjusteDiaReunionRespuesta ajustarDiaReunion(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionCreditoGrupal/V1.0")
			AjusteDiaReunionPeticion peticion);

	/**
	 * Metodo utilizado para registrar las solicitudes de reasignacion
	 * @param peticion :
	 * @return {@link RegistrarSolicitudReasignarCarteraRespuesta}
	 */
	public RegistrarSolicitudReasignarCarteraRespuesta registrarSolicitudReasignarCartera(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionCreditoGrupal/V1.0")
			RegistrarSolicitudReasignarCarteraPeticion peticion);

	/**
	 * Metodo utilizado para registrar las solicitudes de reasignacion, mediante XML
	 * @param peticion {@link java.lang.String}
	 * @return {@link java.lang.String}
	 */
	public java.lang.String registrarSolicitudReasignarCarteraXML(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionCreditoGrupal/V1.0")
			java.lang.String peticion);

	/**
	 * Metodo utilizado para actualizar las solicitudes de reasignacion
	 * @param peticion :
	 * @return {@link ActualizarSolicitudReasignarCarteraRespuesta}
	 */
	public ActualizarSolicitudReasignarCarteraRespuesta actualizarSolicitudReasignarCartera(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionCreditoGrupal/V1.0")
			ActualizarSolicitudReasignarCarteraPeticion peticion);

	/**
	 * Metodo utilizado para actualizar las solicitudes de reasignacion
	 * @param peticion {@link java.lang.String}
	 * @return {@link java.lang.String}
	 */
	public java.lang.String actualizarSolicitudReasignarCarteraXML(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionCreditoGrupal/V1.0")
			java.lang.String peticion);

	/**
	 * Metodo para realizarla transferencia de saldo a favor de forma masiva
	 * @param peticion {@link TrasferirSaldosAFavorCreditosVigentesPeticion}
	 * @return {@link TransferirSaldosAFavorCreditosVigentesRespuesta}
	 */
	public TransferirSaldosAFavorCreditosVigentesRespuesta trasferirSaldosAFavorCreditosVigentes(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionCreditoGrupal/V1.0")
			TrasferirSaldosAFavorCreditosVigentesPeticion peticion);

	/**
	 * Metodo para registrar los telefonos
	 * @param peticion {@link RegistrarTelefonoPeticion}
	 * @return {@link ClienteRespuesta}
	 */
	public ClienteRespuesta registrarTelefono(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionCreditoGrupal/V1.0")
			RegistrarTelefonoPeticion peticion);

	/**
	 * @param peticion :
	 * @return ajustarPersonaDomicilio :
	 */
	public AjusteRespuesta ajustarPersonaDomicilio(AjustarPersonaDomicilioPeticion peticion);

	/**
	 * @param peticion :
	 * @return EliminarSaldoAFavorRespuesta :
	 */
	public EliminarSaldoAFavorRespuesta eliminarSaldoAFavorRING(EliminarSaldoAFavorPeticion peticion);

	/**
	 * Metodo para validar el nombre y fecha de nacimiento de una persona
	 * @param peticion del registro persona
	 * @return XML respuesta
	 */
	public String validaExistePersona(String peticion);

	/**
	 * Se ajusta el porcentaje de Garantia
	 *
	 * @param peticion datos de peticion de cambio de porcentaje de Garantia
	 * @return AjusteRespuesta: resultado del ajuste al porcentaje de Garantia
	 */
	public AjustePorcentajeGarantiaRespuesta modificarGarantia(AjustePorcentajeGarantiaPeticion peticion);

	/**
	 * Metodo para guardar la informacion de Administracion
	 * de nalistas
	 * @param peticion datos de captura
	 * @return AdministracionAnalistasRespuesta
	 */
	public AdministracionAnalistasRespuesta guardarAnalistas(AdministracionAnalistasPeticion peticion);

	/**
	 * Metodo para buscar informacion del Analista
	 * @param peticion numero de persona del analista
	 * @return AdministracionAnalistasRespuesta con
	 * informacion del analista buscado
	 */
	public AdministracionAnalistasRespuesta buscarAnalistas(AdministracionAnalistasPeticion peticion);

	/**
	 * Metodo para guardar la notificacion de contingencia
	 * @param peticion p
	 * @return AdministracionAnalistasRespuesta
	 */
	public AdministracionAnalistasRespuesta guardarContingenciaAnalistas(AdministracionAnalistasPeticion peticion);

	/**
	 * Metodo que se utiliza para la pantalla de clasificacion de sucursales
	 *
	 * @param peticion SucursalPeticion de la consulta
	 * @return xml de respuesta
	 */
	public String obtieneInfoSucursal(SucursalPeticion peticion);

	/**
	 * Metodo que se utiliza para actualizar la informacion de la sucursal
	 *
	 * @param peticion RespuestaSucursalOV
	 * @return respuestaXML clase de respuesta
	 */
	public String actualizaInfoSucursal(RespuestaSucursalOV peticion);

	/**
	 * Metodo para consultar los contratos actuales de la sucursal con coordenadas
	 * @param peticion sucursal y usuario
	 * @return lista de contratos
	 */
	public GruposGPSRespuesta consultaContratosCoordenadas(GruposGPSPeticion peticion);

	/**
	 * Metodo para actualizar las coordenadas de un contratos
	 * @param peticion contrato y coordenadas
	 * @return resultado actualizacionk
	 */
	public GruposGPSRespuesta actualizarContratoCoordenadas(GruposGPSPeticion peticion);
}
