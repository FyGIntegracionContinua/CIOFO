/**
 *
 */
package tarea.administracion;

import org.apache.ibatis.session.SqlSession;

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
import utilitario.mensajes.consultas.RespuestaSucursalOV;
import utilitario.mensajes.grupos.gps.GruposGPSPeticion;
import utilitario.mensajes.grupos.gps.GruposGPSRespuesta;
import utilitario.mensajes.operacion.administracion.SucursalPeticion;
import utilitario.mensajes.originacion.cancelacion.CancelacionContratoOV;
import utilitario.mensajes.originacion.cancelacion.CancelacionContratoRespuesta;
import utilitario.mensajes.originacion.cliente.ClienteRespuesta;
import utilitario.mensajes.originacion.cliente.RegistrarTelefonoPeticion;

/**
 * The Interface AdministracionCredito.
 *
 * @author oarias
 * @version 1.0
 */
public interface AdministracionCredito {

	/**
	 * Se ajusta la tasa de un credito,
	 * Se valida que la fecha actual sea anterior o igual del primer pago
	 * @param peticion datos de peticion de cambio de tasa
	 * @param uid String
	 * @return AjusteRespuesta: resultado del ajuste al contrato
	 */
	public AjusteRespuesta ajustarTasa( String uid, AjusteTasaPeticion peticion);

	/**
	 * Se ajusta el plazo de un credito,
	 * Se valida que la fecha actual sea anterior o igual del primer pago.
	 *
	 * @param uid the uid
	 * @param peticion datos de peticion de cambio de plazo
	 * @return AjusteRespuesta: resultado del ajuste al contrato
	 */

	public AjusteRespuesta ajustarPlazo(String uid, AjustePlazoPeticion peticion);

	/**
	 * Se ajusta el dia de pago de un credito,
	 * @param uid String
	 * @param peticion datos de peticion de cambio de dia pago
	 * @return AjusteRespuesta: resultado del ajuste al contrato
	 */
	public AjusteRespuesta ajustarDiaPago(String uid, AjusteDiaPagoPeticion peticion);

	/**
	 * Se ajusta un contrato por la devolucion de un cheque.
	 *
	 * @param uid the uid
	 * @param peticion the peticion
	 * @return AjusteChequeDevueltoRespuesta: resultado del ajuste al contrato
	 */
	public AjusteChequeDevueltoRespuesta ajustarPorChequeDevuelto(
			java.lang.String uid, AjusteChequeDevueltoPeticion peticion );

	/**
	 *
	 * @param peticion the peticion
	 * @param uid the uid
	 * @param sesion the sesionExterna
	 * @return the cancelacion contrato respuesta
	 */
	public CancelacionContratoRespuesta cancelarContrato( CancelacionContratoOV peticion, java.lang.String uid
			, SqlSession sesion);

	/**
	 * Funcion para realizar la transferencia de un saldo a favor de algun contrato
	 * que tenga estatus de pagado a un contrato con estatus de disponible
	 * @param peticion Contiene los dos contratos el origen y el destino del capital excedente
	 * @param uid :
	 * @return AjusteSaldoAFavorRespuesta
	 */
	public AjusteSaldoAFavorRespuesta transferirSaldoAFavor( AjusteSaldoAFavorPeticion peticion, String uid );

	/**
	 * Funcion para quitar el saldo a favor de un contrato en estatus de pagado
	 * @param peticion :
	 * @param uid :
	 * @return EliminarSaldoAFavorRespuesta
	 */
	public EliminarSaldoAFavorRespuesta eliminarSaldoAFavor( EliminarSaldoAFavorPeticion peticion, String uid );

	/**
	 * Funcion para cancelar la eliminacion de saldo a favor
	 * @param peticion :
	 * @param uid :
	 * @return RevertirSaldoAFavorRespuesta
	 */
	public RevertirSaldoAFavorRespuesta revertirSaldoAFavor( RevertirSaldoAFavorPeticion peticion, String uid );

	/**
	 * M�todo principal para realizar la reacci�n de cartera entre sucursales y asesores
	 * @param peticion :
	 * @param uid :
	 * @return ReasignarCarteraRespuesta
	 */
	public ReasignarCarteraRespuesta reasignarCartera( ReasignarCarteraPeticion peticion, String uid );

	/**
	 * Funcion para actualizar el dia de reunion de un grupo
	 * @param peticion :
	 * @param uid :
	 * @return AjusteDiaReunionRespuesta
	 */
	public AjusteDiaReunionRespuesta ajustarDiaReunion(AjusteDiaReunionPeticion peticion, String uid);

	/**
	 * M�todo utilizado para registrar las solicitudes de reasignaci�n
	 * @param peticion :
	 * @param uid :
	 * @return {@link RegistrarSolicitudReasignarCarteraRespuesta}
	 */
	public RegistrarSolicitudReasignarCarteraRespuesta
		registrarSolicitudReasignarCartera( RegistrarSolicitudReasignarCarteraPeticion peticion, String uid );

	/**
	 * M�todo utilizado para actualizar las solicitudes de reasignaci�n
	 * @param peticion :
	 * @param uid :
	 * @return {@link ActualizarSolicitudReasignarCarteraRespuesta}
	 */
	public ActualizarSolicitudReasignarCarteraRespuesta
		actualizarSolicitudReasignarCartera( ActualizarSolicitudReasignarCarteraPeticion peticion, String uid);

	/**
	 * M�todo para realizarla transferencia de saldo a favor de forma masiva
	 * @param peticion {@link TrasferirSaldosAFavorCreditosVigentesPeticion}
	 * @param uid {@java.lang.String}
	 * @return {@link TransferirSaldosAFavorCreditosVigentesRespuesta}
	 */
	public TransferirSaldosAFavorCreditosVigentesRespuesta
		trasferirSaldosAFavorCreditosVigentes(TrasferirSaldosAFavorCreditosVigentesPeticion peticion, String uid);
	/**
	 * M�todo para registrar los tel�fonos
	 * @param peticion {@link RegistrarTelefonoPeticion}
	 * @param uid identificador unico para cada petici�n recibida
	 * @return {@link ClienteRespuesta}
	 */
	public ClienteRespuesta registrarTelefono(RegistrarTelefonoPeticion peticion, String uid);

	/**
	 * @param uid :
	 * @param peticion :
	 * @return ajustarPersonaDomicilio :
	 */
	public AjusteRespuesta ajustarPersonaDomicilio(String uid, AjustarPersonaDomicilioPeticion peticion);

	/**
	 * @param peticion :
	 * @param uid :
	 * @return EliminarSaldoAFavorRespuesta
	 */
	public EliminarSaldoAFavorRespuesta
		eliminarSaldoAFavorRING( EliminarSaldoAFavorPeticion peticion, String uid );

	/**
	 * Se ajusta el porcentaje de Garantia
	 *
	 * @param uid the uid
	 * @param peticion datos de peticion de cambio de porcentaje de Garantia
	 * @return AjusteRespuesta: resultado del ajuste al porcentaje de Garantia
	 */
	public AjustePorcentajeGarantiaRespuesta modificarGarantia(String uid, AjustePorcentajeGarantiaPeticion peticion);
	/**
	 * Metodo para guaradar la informacion del Analista
	 * @param uid para el log
	 * @param peticion informaciond del Analista
	 * @return AdministracionAnalistasRespuesta mensaje
	 */
	public AdministracionAnalistasRespuesta guardarAnalista(String uid,
			AdministracionAnalistasPeticion peticion);

	/**
	 * Metodo para buscar la informacion del Analista
	 * @param uid para el log
	 * @param peticion num del Analista
	 * @return AdministracionAnalistasRespuesta informacion del
	 * Analista
	 */
	public AdministracionAnalistasRespuesta buscarAnalista(String uid,
			AdministracionAnalistasPeticion peticion);

	/**
	 * Metodo para guardar la contingencia de los
	 * Analistas
	 * @param uid para el log
	 * @param peticion p
	 * @return AdministracionAnalistasRespuesta mensaje
	 */
	public AdministracionAnalistasRespuesta guardarContingenciaAnalistas(String uid,
			AdministracionAnalistasPeticion peticion);

	/**
	 * Metodo que se utiliza para obtener informacion de las sucursales
	 *
	 * @param uid the uid
	 * @param peticion datos de peticion de cambio de porcentaje de Garantia
	 * @return AjusteRespuesta: resultado del ajuste al porcentaje de Garantia
	 */
	public RespuestaSucursalOV obtieneInfoSucursalTarea(String uid, SucursalPeticion peticion);

	/**
	 * Metodo que se utiliza para actualizar la informacion de la sucursal
	 *
	 * @param uid the uid
	 * @param peticion RespuestaSucursalOV
	 * @return respuestaXML clase de respuesta
	 */
	public RespuestaSucursalOV actualizaInfoSucursalTarea(String uid, RespuestaSucursalOV peticion);

	/**
	 * Metodo para consultar los contratos actuales de la sucursal con coordenadas
	 * @param uid the uid
	 * @param peticion sucursal y usuario
	 * @return lista de contratos
	 */
	public GruposGPSRespuesta consultaContratosCoordenadas(String uid, GruposGPSPeticion peticion);

	/**
	 * Metodo para actualizar las coordenadas de un contratos
	 * @param uid the uid
	 * @param peticion contrato y coordenadas
	 * @return resultado actualizacionk
	 */
	public GruposGPSRespuesta actualizarContratoCoordenadas(String uid, GruposGPSPeticion peticion);
}

