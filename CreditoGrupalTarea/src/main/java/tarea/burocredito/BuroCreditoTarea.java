/**
 *
 */
package tarea.burocredito;

import java.util.List;

import utilitario.comun.Constantes;
import utilitario.mensajes.burocredito.BuroCreditoClienteDetalleGrupoPeticion;
import utilitario.mensajes.burocredito.BuroCreditoClienteDetalleGrupoRespuesta;
import utilitario.mensajes.burocredito.BuroCreditoClienteGrupoPeticion;
import utilitario.mensajes.burocredito.BuroCreditoClienteGrupoRespuesta;
import utilitario.mensajes.burocredito.BuroCreditoClientePeticion;
import utilitario.mensajes.burocredito.BuroCreditoClienteRespuesta;
import utilitario.mensajes.burocredito.BuroCreditoComunalPeticion;
import utilitario.mensajes.burocredito.BuroCreditoComunalRespuesta;
import utilitario.mensajes.burocredito.BuroCreditoContratoPeticion;
import utilitario.mensajes.burocredito.BuroCreditoContratoRespuesta;
import utilitario.mensajes.burocredito.BuroCreditoFechaRespuesta;
import utilitario.mensajes.burocredito.BuroCreditoRFCPeticion;
import utilitario.mensajes.burocredito.BuroCreditoRFCRespuesta;
import utilitario.mensajes.burocredito.ConsultaBuroPeticion;
import utilitario.mensajes.burocredito.ConsultaBuroRespuesta;
import utilitario.mensajes.burocredito.ResumenBuroCliente;
import utilitario.mensajes.burocredito.ResumenBuroPeticion;
import utilitario.mensajes.burocredito.ValidaSolicitudPeticion;
import utilitario.mensajes.burocredito.ValidaSolicitudRespuesta;
import utilitario.mensajes.solicitudes.ConsultaSolicitudBuroRespuesta;

/**
 * @author out_ltorres
 * @version 1.0.0
 */
public interface BuroCreditoTarea extends Constantes {

	/**
	 * EMPRESA
	 */
	static final String EMPRESA = "100000003";
	/**
	 * ORIGEN
	 */
	static final String ORIGEN = "FINS";
	/**
	 * SOLICITUD_CONSTANTE
	 */
	static final String SOLICITUD_CONSTANTE = "00000000";
	/**
	 * GRUPO_CONSTANTE
	 */
	static final int GRUPO_CONSTANTE = 0;
	/**
	 * ATOMO_CONSTANTE
	 */
	static final String ATOMO_CONSTANTE = "000000";
	/**
	 * MENSAJE_APROBACION
	 */
	static final String MENSAJE_APROBACION = "CUMPLE REQUISITOS BURO";

	/**
	 * MENSAJE_RECHAZO
	 */
	static final String MENSAJE_RECHAZO = "RECHAZADO";

	/**
	 * MOP99
	 */
	static final int MOP99 = 99;

	/**
	 * DIAS_ANIO
	 */
	static final int DIAS_ANIO = 365;
	/**
	 * DIAS_ANIO_BI
	 */
	static final int DIAS_ANIO_BI = 366;
	/**
	 * DIAS_SEMANA
	 */
	static final int DIAS_SEMANA = 7;
	/**
	 * DIAS_CATORCENA
	 */
	static final int DIAS_CATORCENA = 14;
	/**
	 * DIAS_QUINCENA
	 */
	static final int DIAS_QUINCENA = 15;
	/**
	 * IGUAL_PCT_CTA_ABIERTA
	 */
	static final double IGUAL_PCT_CTA_ABIERTA = 0.5;
	/**
	 * IGUAL_CTA_SEMANAS
	 */
	static final int IGUAL_CTA_SEMANAS = 26;
	/**
	 * IGUAL_CTA_CATORCENAS
	 */
	static final int IGUAL_CTA_CATORCENAS = 13;
	/**
	 * IGUAL_DIAS_CTA_CERRADA
	 */
	static final int IGUAL_DIAS_CTA_CERRADA = 180;
	/**
	 * @param uid :
	 * @param buroCreditoPeticion :
	 * @return BuroCreditoClienteRespuesta
	 */
	BuroCreditoClienteRespuesta getInformacionClienteTarea(String uid, BuroCreditoClientePeticion buroCreditoPeticion);
	/**
	 * @param uid :
	 * @param buroCreditoClientePeticion :
	 * @return BuroCreditoFechaRespuesta
	 */
	BuroCreditoFechaRespuesta prGetFechaTarea(String uid, BuroCreditoClientePeticion buroCreditoClientePeticion);
	/**
	 * @param uid :
	 * @param buroCreditoClienteGrupoPeticion :
	 * @return BuroCreditoClienteGrupoRespuesta
	 */
	BuroCreditoClienteGrupoRespuesta prGetHistoriaCTarea(String uid,
			BuroCreditoClienteGrupoPeticion buroCreditoClienteGrupoPeticion);
	/**
	 * @param uid :
	 * @param buroCreditoClienteDetalleGrupoPeticion :
	 * @return BuroCreditoClienteDetalleGrupoRespuesta
	 */
	BuroCreditoClienteDetalleGrupoRespuesta prGetDetalleGrupoTarea(String uid,
			BuroCreditoClienteDetalleGrupoPeticion buroCreditoClienteDetalleGrupoPeticion);
	/**
	 * @param uid :
	 * @param buroCreditoClientePeticion :
	 * @return BuroCreditoClienteRespuesta
	 */
	BuroCreditoClienteRespuesta prGetInformacionClienteTarea(String uid, BuroCreditoClientePeticion buroCreditoClientePeticion);
	/**
	 * @param uid :
	 * @param buroCreditoClienteGrupoPeticion :
	 * @return BuroCreditoClienteGrupoRespuesta
	 */
	BuroCreditoClienteGrupoRespuesta prGetDetalleHistoriaCTarea(String uid,
			BuroCreditoClienteGrupoPeticion buroCreditoClienteGrupoPeticion);
	/**
	 * @param uid :
	 * @param buroCreditoComunalPeticion :
	 * @return BuroCreditoComunalRespuesta
	 */
	BuroCreditoComunalRespuesta findCredComunalTarea(String uid, BuroCreditoComunalPeticion buroCreditoComunalPeticion);
	/**
	 * @param uid :
	 * @param buroCreditoContratoPeticion  :
	 * @return BuroCreditoContratoRespuesta
	 */
	BuroCreditoContratoRespuesta prGetCountMoraTarea(String uid, BuroCreditoContratoPeticion buroCreditoContratoPeticion);
	/**
	 * @param uid :
	 * @param buroCreditoRFCPeticion :
	 * @return BuroCreditoRFCRespuesta
	 */
	BuroCreditoRFCRespuesta getRFCClienteTarea(String uid, BuroCreditoRFCPeticion buroCreditoRFCPeticion);
	/**
	 * @param uid :
	 * @param buroCreditoRFCPeticion :
	 * @return BuroCreditoRFCRespuesta
	 */
	BuroCreditoRFCRespuesta getClientbyRFCTarea(String uid, BuroCreditoRFCPeticion buroCreditoRFCPeticion);
	/**
	 * @param uid :
	 * @param buroCreditoRFCPeticion :
	 * @return BuroCreditoRFCRespuesta
	 */
	BuroCreditoRFCRespuesta getClientBCETarea(String uid, BuroCreditoRFCPeticion buroCreditoRFCPeticion);

	/**
	 * @param uid Identificador de Transaccion
	 * @param peticion de consulta
	 * @return ConsultaBuroRespuesta
	 */
	public ConsultaBuroRespuesta consultaBuroCredito(String uid, ConsultaBuroPeticion peticion);

	/**
	 * @param uid Identificador de Transaccion
	 * @param peticion de consulta
	 * @return ConsultaBuroRespuesta
	 */
	public ConsultaBuroRespuesta validaConsultaVigente(String uid, ConsultaBuroPeticion peticion);

	/**
	 * @param uid Identificador de Transaccion
	 * @param peticion de consulta
	 * @return ConsultaBuroRespuesta
	 */
	public ConsultaBuroRespuesta obtenerUltimaConsulta(String uid, ConsultaBuroPeticion peticion);

	/**
	 * @param uid Identificador de Transaccion
	 * @param peticion de consulta
	 * @return ConsultaBuroRespuesta
	 */
	public ConsultaBuroRespuesta obtenerConsultaPorFolio(String uid, ConsultaBuroPeticion peticion);

	/**
	 * @param uid Identificador de Transaccion
	 * @param peticion de consulta
	 * @return ConsultaBuroRespuesta
	 */
	public ValidaSolicitudRespuesta validacionSolicitudBuro(String uid, ValidaSolicitudPeticion peticion);

	/**
	 * @param uid Identificador de Transaccion
	 * @param peticion de consulta
	 * @return ConsultaBuroRespuesta
	 */
	public ConsultaSolicitudBuroRespuesta validacionIDSolicitudBuro(String uid, ValidaSolicitudPeticion peticion);

	/**
	 * @param uid Identificador de Transaccion
	 * @param peticion de consulta
	 * @return ConsultaBuroRespuesta
	 */
	public ConsultaSolicitudBuroRespuesta validacionIDSolicitudBuroAnalistaDocumentalBC(String uid,
			ValidaSolicitudPeticion peticion);

	/**
	 * @param uid Identificador unico
	 * @param peticion Validacion
	 * @return ConsultaSolicitudBuroRespuesta
	 */
	public ConsultaSolicitudBuroRespuesta validacionBuroClienteSolicitudExpress(String uid, ValidaSolicitudPeticion peticion);

	/**
	 * @param uid Identificador unico
	 * @param peticion Validacion
	 * @return ConsultaSolicitudBuroRespuesta
	 */
	public ConsultaSolicitudBuroRespuesta
		validacionBuroClienteSolicitudExpressIguala(String uid, ValidaSolicitudPeticion peticion);

	/**
	 * metodo que se encarga de la validacion de buro de la parte de originacion
	 * @param uid Identificador de Transaccion
	 * @param peticion de consulta
	 * @return ConsultaBuroRespuesta
	 */
	public ValidaSolicitudRespuesta validacionSolicitudBuroOriginacion(String uid, ValidaSolicitudPeticion peticion);

	 /**
     * M&eacute;todo que regresa el resumen de buro de cada integrante
     * @param uid identificador &uacute;nico de transacci&oacute;n
     * @param peticion datos como la solicitud, perfil, usuarioAut
     * @return List<ResumenBuroCliente> lista de clientes
     */
	public List<ResumenBuroCliente> resumenBuroSolicitud(String uid, ResumenBuroPeticion peticion);
	
	 /**
	  * metodo que consulta el buro y lo checa de acuerdo a las reglas de buro
	  * @param uid id unico de transaccion
	  * @param peticion peticion 
	  * @return ConsultaSolicitudBuroRespuesta respuesta del estatus de buro de credito.
	  */
	 public ConsultaSolicitudBuroRespuesta obtenerBuroProspectoCaravanas(String uid, ConsultaBuroPeticion peticion);


}
