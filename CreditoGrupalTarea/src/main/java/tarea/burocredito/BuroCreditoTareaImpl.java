/**
 *
 */
package tarea.burocredito;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.oasisopen.sca.annotation.Reference;
import org.osoa.sca.annotations.Scope;

import tarea.comun.ComunTarea;
import tarea.comun.ReadProperties;
import tarea.solicitudes.SolicitudesCreditoTarea;
import utilitario.comun.Constantes;
import utilitario.comun.Validaciones;
import utilitario.log.LogHandler;
import utilitario.mensajes.burocredito.BuroCreditoBCE;
import utilitario.mensajes.burocredito.BuroCreditoCliente;
import utilitario.mensajes.burocredito.BuroCreditoClienteDetalleGrupo;
import utilitario.mensajes.burocredito.BuroCreditoClienteDetalleGrupoPeticion;
import utilitario.mensajes.burocredito.BuroCreditoClienteDetalleGrupoRespuesta;
import utilitario.mensajes.burocredito.BuroCreditoClienteGrupo;
import utilitario.mensajes.burocredito.BuroCreditoClienteGrupoPeticion;
import utilitario.mensajes.burocredito.BuroCreditoClienteGrupoRespuesta;
import utilitario.mensajes.burocredito.BuroCreditoClientePeticion;
import utilitario.mensajes.burocredito.BuroCreditoClienteRespuesta;
import utilitario.mensajes.burocredito.BuroCreditoComunal;
import utilitario.mensajes.burocredito.BuroCreditoComunalPeticion;
import utilitario.mensajes.burocredito.BuroCreditoComunalRespuesta;
import utilitario.mensajes.burocredito.BuroCreditoContratoPeticion;
import utilitario.mensajes.burocredito.BuroCreditoContratoRespuesta;
import utilitario.mensajes.burocredito.BuroCreditoFechaRespuesta;
import utilitario.mensajes.burocredito.BuroCreditoRFC;
import utilitario.mensajes.burocredito.BuroCreditoRFCPeticion;
import utilitario.mensajes.burocredito.BuroCreditoRFCRespuesta;
import utilitario.mensajes.burocredito.ConsultaBuroPeticion;
import utilitario.mensajes.burocredito.ConsultaBuroRespuesta;
import utilitario.mensajes.burocredito.IntegranteSolicitud;
import utilitario.mensajes.burocredito.ResumenBuroCliente;
import utilitario.mensajes.burocredito.ResumenBuroMop;
import utilitario.mensajes.burocredito.ResumenBuroPeticion;
import utilitario.mensajes.burocredito.ValidaBuroDTO;
import utilitario.mensajes.burocredito.ValidaSolicitudPeticion;
import utilitario.mensajes.burocredito.ValidaSolicitudRespuesta;
import utilitario.mensajes.comun.ConsultaCatalogoPeticionCIOF;
import utilitario.mensajes.comun.ConsultaCatalogoRespuestaCIOF;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.originacion.consulta.ParGeneralOV;
import utilitario.mensajes.reportes.comun.ResumenSaldoOV;
import utilitario.mensajes.solicitudes.ConsultaSolicitudBuroRespuesta;
import utilitario.mensajes.solicitudes.EncabezadoSolicitudRespuesta;
import utilitario.mensajes.solicitudes.SolicitudBuroClienteOV;
import utilitario.mensajes.solicitudes.SolicitudBuroGeneralOV;
import utilitario.mensajes.solicitudes.SolicitudBuroOV;
import utilitario.mensajes.solicitudes.SolicitudBuroRespuesta;
import utilitario.mensajes.solicitudes.SolicitudSACGIntegrante;
import utilitario.mensajes.solicitudes.SolicitudesRespuesta;
import utilitario.reglas.solicitudes.PeticionReglaIncremento;
import utilitario.reglas.solicitudes.RespuestaReglaIncremento;

import com.findep.buro.dto.ReporteCredito;
import com.findep.buro.dto.SegmentoConsulta;
import com.findep.buro.dto.SegmentoCuenta;
import com.findep.buro.dto.SegmentoDireccion;
import com.findep.buro.dto.SegmentoEmpleo;
import com.findep.buro.dto.SegmentoEncabezado;
import com.findep.buro.dto.SegmentoFin;
import com.findep.buro.dto.SegmentoNombre;
import com.findep.buro.dto.SegmentoResumenReporte;
import com.findep.buro.dto.SegmentoScore;
import com.findep.credito.buro.bnc.modelo_comun.BncException;
import com.findep.credito.buro.bnc.schema.ConsultarBuroXMLRequest;
import com.findep.credito.buro.bnc.schema.ConsultarBuroXMLResponse;
import com.findep.credito.buro.bnc.schema.ControlInterno;
import com.findep.credito.buro.bnc.schema.DatosBnc;
import com.findep.credito.buro.bnc.schema.DatosCredito;
import com.findep.credito.buro.bnc.schema.ObtenerXMLReporteCreditoPorFolioRequest;
import com.findep.credito.buro.bnc.schema.ObtenerXMLReporteCreditoPorFolioResponse;
import com.findep.credito.buro.dto.ObtenerXMLReporteCreditoRequest;
import com.findep.credito.buro.dto.ObtenerXMLReporteCreditoResponse;
import com.findep.credito.buro.ws.ServicioBuroCredito.ServicioBuroCreditoProxy;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import entidad.conexiones.FabricaConexiones;

/**
 * @author out_ltorres
 *
 */
@Scope("COMPOSITE")
public class BuroCreditoTareaImpl implements BuroCreditoTarea {

	/**
	 * Variable SolicitudesCreditoTarea
	 */
	private SolicitudesCreditoTarea solicitudesCredito;

	/** LONGITUD_FOLIO_BURO int	 */
	private static final int  LONGITUD_FOLIO_BURO			= 4;
	/** MOP_4 int	 */
	private static final int  MOP_4							= 4;
	/** MOP_5 int	 */
	private static final int  MOP_5							= 5;
	/** MOP_6 int	 */
	private static final int  MOP_6							= 6;
	/** MOP_7 int	 */
	private static final int  MOP_7							= 7;
	/** MOP_96 int	 */
	private static final int  MOP_96						= 96;
	/** MOP_97 int	 */
	private static final int  MOP_97						= 97;
	/** MOP_99 int	 */
	private static final int  MOP_99						= 99;
	/** DIAS_MORA_ACUMULADOS int	 */
	private static final int  DIAS_MORA_ACUMULADOS			= 7;

	/** MOP_99_SALDO_VENCIDO double	 */
	private static final double  MOP_99_SALDO_VENCIDO		= 5000;

	/** PCT_RENUEVA double	 */
	private static final double  PCT_RENUEVA		= 0.5;
	/** PCT_NUEVOS double	 */
	private static final double  PCT_NUEVOS		= 0.3;

	/**
	 * comun ComunTarea
	 */
	private ComunTarea comun;


	/**
	 * @param solicitudesCredito fabric
	 * @param comun fabric
	 * @return
	 */
	public BuroCreditoTareaImpl(@Reference(name = "solicitudesCredito") SolicitudesCreditoTarea solicitudesCredito,
			@Reference(name = "comun") ComunTarea comun) {
		this.solicitudesCredito = solicitudesCredito;
		this.comun = comun;
	}

	/**
	 *@param buroCreditoClientePeticion :
	 *@param uid :
	 *@return BuroCreditoClienteRespuesta
	 */
	public BuroCreditoClienteRespuesta getInformacionClienteTarea(String uid,
									BuroCreditoClientePeticion buroCreditoClientePeticion) {
		BuroCreditoClienteRespuesta buroCreditoClienteRespuesta = new BuroCreditoClienteRespuesta();
		buroCreditoClienteRespuesta.setHeader(new EncabezadoRespuesta());
		buroCreditoClienteRespuesta.getHeader().setUID(uid);
		buroCreditoClienteRespuesta.getHeader().setEstatus(true);
		SqlSession sessionNTx				= null;
		String validaStr					= "";
		try {
			String[] datosRequeridos = {"claveCliente"};
			validaStr = Validaciones.datosRequeridos(buroCreditoClientePeticion, datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}
			//Se abre la session No transaccional sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(), "getInformacionClienteTarea: - obtenerPersonaMin");
			LogHandler.info(uid, getClass(), "getInformacionClienteTarea: - obtenerPersonaMin");
			String persona = (String) sessionNTx.selectOne("obtenerPersonaMin", buroCreditoClientePeticion.getClaveCliente());
			if (persona == null) {
				throw new Exception(CONSULTA_SINREGISTROS);
			}
			buroCreditoClientePeticion.setClaveCliente(persona);
			LogHandler.trace(uid, getClass(), "getInformacionClienteTarea: - consultaGetInformacionCliente");
			LogHandler.info(uid, getClass(), "getInformacionClienteTarea: - consultaGetInformacionCliente");
			BuroCreditoCliente buroCreditoClienteQueryResult = (BuroCreditoCliente)
					sessionNTx.selectOne("consultaGetInformacionCliente", buroCreditoClientePeticion.getClaveCliente());
			if (buroCreditoClienteQueryResult == null) {
				throw new Exception(CONSULTA_SINREGISTROS);
			}
			buroCreditoClienteRespuesta.setCliente(buroCreditoClienteQueryResult);
		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "getInformacionClienteTarea: " + ex.getMessage(), ex);
			buroCreditoClienteRespuesta.getHeader().setEstatus(false);
			buroCreditoClienteRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			buroCreditoClienteRespuesta.getHeader().setCodigo(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return buroCreditoClienteRespuesta;
	}

	/**
	 *@param buroCreditoClientePeticion :
	 *@param uid :
	 *@return BuroCreditoClienteRespuesta
	 */
	public BuroCreditoClienteRespuesta prGetInformacionClienteTarea(String uid,
			BuroCreditoClientePeticion buroCreditoClientePeticion) {
		BuroCreditoClienteRespuesta buroCreditoClienteRespuesta = new BuroCreditoClienteRespuesta();
		buroCreditoClienteRespuesta.setHeader(new EncabezadoRespuesta());
		buroCreditoClienteRespuesta.getHeader().setUID(uid);
		buroCreditoClienteRespuesta.getHeader().setEstatus(true);
		SqlSession sessionNTx				= null;
		String validaStr					= "";
		try {
			String[] datosRequeridos = {"claveCliente"};
			validaStr = Validaciones.datosRequeridos(buroCreditoClientePeticion, datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}
			//Se abre la session No transaccional sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(), "prGetInformacionClienteTarea: - consultaPrGetInformacionCliente");
			LogHandler.info(uid, getClass(), "prGetInformacionClienteTarea: - consultaPrGetInformacionCliente");
			BuroCreditoCliente buroCreditoClienteQueryResult = (BuroCreditoCliente)
					sessionNTx.selectOne("consultaPrGetInformacionCliente", buroCreditoClientePeticion.getClaveCliente());
			if (buroCreditoClienteQueryResult == null) {
				throw new Exception(CONSULTA_SINREGISTROS);
			}
			buroCreditoClienteRespuesta.setCliente(buroCreditoClienteQueryResult);
		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "prGetInformacionClienteTarea: " + ex.getMessage(), ex);
			buroCreditoClienteRespuesta.getHeader().setEstatus(false);
			buroCreditoClienteRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			buroCreditoClienteRespuesta.getHeader().setCodigo(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return buroCreditoClienteRespuesta;
	}

	/**
	 *@param buroCreditoClientePeticion :
	 *@param uid :
	 *@return BuroCreditoClienteRespuesta
	 */
	public BuroCreditoFechaRespuesta prGetFechaTarea(String uid, BuroCreditoClientePeticion buroCreditoClientePeticion) {
		BuroCreditoFechaRespuesta buroCreditoFechaRespuesta = new BuroCreditoFechaRespuesta();
		buroCreditoFechaRespuesta.setHeader(new EncabezadoRespuesta());
		buroCreditoFechaRespuesta.getHeader().setUID(uid);
		buroCreditoFechaRespuesta.getHeader().setEstatus(true);
		SqlSession sessionNTx				= null;
		try {
			//Se abre la session No transaccional sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			LogHandler.trace(uid, getClass(), "prGetFechaTarea: - consultaPrGetFecha");
			LogHandler.info(uid, getClass(), "prGetFechaTarea: - consultaPrGetFecha");
			Date fechaContable = (Date) sessionNTx.selectOne("consultaPrGetFecha");
			if (fechaContable == null) {
				throw new Exception(CONSULTA_SINREGISTROS);
			}

			buroCreditoFechaRespuesta.setFecha(fechaContable);
		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "prGetFechaTarea: " + ex.getMessage(), ex);
			buroCreditoFechaRespuesta.getHeader().setEstatus(false);
			buroCreditoFechaRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			buroCreditoFechaRespuesta.getHeader().setCodigo(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return buroCreditoFechaRespuesta;
	}

	/**
	 *@param buroCreditoClienteGrupoPeticion :
	 *@param uid :
	 *@return BuroCreditoClienteRespuesta
	 */
	@SuppressWarnings("unchecked")
	public BuroCreditoClienteGrupoRespuesta prGetHistoriaCTarea(String uid,
			BuroCreditoClienteGrupoPeticion buroCreditoClienteGrupoPeticion) {
		BuroCreditoClienteGrupoRespuesta buroCreditoClienteGrupoRespuesta = new BuroCreditoClienteGrupoRespuesta();
		buroCreditoClienteGrupoRespuesta.setHeader(new EncabezadoRespuesta());
		buroCreditoClienteGrupoRespuesta.getHeader().setUID(uid);
		buroCreditoClienteGrupoRespuesta.getHeader().setEstatus(true);
		SqlSession sessionNTx	= null;
		String validaStr 		= "";
		try {
			String[] datosRequeridos = {"persona"};
			validaStr = Validaciones.datosRequeridos(buroCreditoClienteGrupoPeticion, datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			//Se abre la session Transaccional sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			if (buroCreditoClienteGrupoPeticion.getFecha() == null) {

				LogHandler.trace(uid, getClass(), "prGetHistoriaCTarea: - consultaPrGetFecha");
				LogHandler.info(uid, getClass(), "prGetHistoriaCTarea: - consultaPrGetFecha");
				Date fechaContable = (Date) sessionNTx.selectOne("consultaPrGetFecha");
				if (fechaContable == null) {
					throw new Exception(CONSULTA_SINREGISTROS);
				}

				buroCreditoClienteGrupoPeticion.setFecha(fechaContable);
			}

			// RFC a persona.
			LogHandler.trace(uid, getClass(), "prGetHistoriaCTarea: - obtenerPersona");
			LogHandler.info(uid, getClass(), "prGetHistoriaCTarea: - obtenerPersona");
			String persona = (String) sessionNTx.selectOne("obtenerPersona", buroCreditoClienteGrupoPeticion.getPersona());
			if (persona == null) {
				throw new Exception(CONSULTA_SINREGISTROS);
			}

			buroCreditoClienteGrupoPeticion.setPersona(persona);

			LogHandler.trace(uid, getClass(), "prGetHistoriaCTarea: - consultaPrGetHistoriaC");
			LogHandler.info(uid, getClass(), "prGetHistoriaCTarea: - consultaPrGetHistoriaC");
			List<BuroCreditoClienteGrupo> buroCreditoClienteGrupoQueryResult = (List<BuroCreditoClienteGrupo>)
					sessionNTx.selectList("consultaPrGetHistoriaC", buroCreditoClienteGrupoPeticion);
			if (buroCreditoClienteGrupoQueryResult.isEmpty()) {
				throw new Exception(CONSULTA_SINREGISTROS);
			}
			buroCreditoClienteGrupoRespuesta.setGrupos(buroCreditoClienteGrupoQueryResult);
		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "prGetHistoriaCTarea: " + ex.getMessage(), ex);
			buroCreditoClienteGrupoRespuesta.getHeader().setEstatus(false);
			buroCreditoClienteGrupoRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			buroCreditoClienteGrupoRespuesta.getHeader().setCodigo(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return buroCreditoClienteGrupoRespuesta;
	}

	/**
	 *@param buroCreditoClienteDetalleGrupoPeticion :
	 *@param uid :
	 *@return BuroCreditoClienteRespuesta
	 */
	@SuppressWarnings("unchecked")
	public BuroCreditoClienteDetalleGrupoRespuesta prGetDetalleGrupoTarea(String uid,
			BuroCreditoClienteDetalleGrupoPeticion buroCreditoClienteDetalleGrupoPeticion) {
		BuroCreditoClienteDetalleGrupoRespuesta buroCreditoClienteDetalleGrupoRespuesta
			= new BuroCreditoClienteDetalleGrupoRespuesta();
		buroCreditoClienteDetalleGrupoRespuesta.setHeader(new EncabezadoRespuesta());
		buroCreditoClienteDetalleGrupoRespuesta.getHeader().setUID(uid);
		buroCreditoClienteDetalleGrupoRespuesta.getHeader().setEstatus(true);
		SqlSession sessionNTx	= null;
		String validaStr 		= "";
		try {
			String[] datosRequeridos = {"prmGrupo"};
			validaStr = Validaciones.datosRequeridos(buroCreditoClienteDetalleGrupoPeticion, datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			//Se abre la session Transaccional sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(), "prGetDetalleGrupoTarea: - consultaPrGetFecha");
			LogHandler.info(uid, getClass(), "prGetDetalleGrupoTarea: - consultaPrGetFecha");
			Date fechaContable = (Date) sessionNTx.selectOne("consultaPrGetFecha");
			if (fechaContable == null) {
				throw new Exception(CONSULTA_SINREGISTROS);
			}

			// Obtener persona a partir de la clave_finsol.
			LogHandler.trace(uid, getClass(), "prGetDetalleGrupoTarea: - obtenerContratoCliente");
			LogHandler.info(uid, getClass(), "prGetDetalleGrupoTarea: - obtenerContratoCliente");
			String personaQueryResult = (String) sessionNTx.selectOne("obtenerContratoCliente",
					buroCreditoClienteDetalleGrupoPeticion.getPrmGrupo());
			if ( personaQueryResult == null) {
				throw new Exception(CONSULTA_SINREGISTROS);
			}

			HashMap<String, Object> parametrosGrupo = new HashMap<String, Object>();
			parametrosGrupo.put("fecha", fechaContable);
			parametrosGrupo.put("personaGrupo", personaQueryResult);

			LogHandler.trace(uid, getClass(), "prGetDetalleGrupoTarea: - consultaPrGetDetalleGrupo");
			LogHandler.info(uid, getClass(), "prGetDetalleGrupoTarea: - consultaPrGetDetalleGrupo");
			List<BuroCreditoClienteDetalleGrupo> contratos =
					(List<BuroCreditoClienteDetalleGrupo>) sessionNTx.selectList("consultaPrGetDetalleGrupo", parametrosGrupo);

			if (contratos.isEmpty()) {
				throw new Exception(CONSULTA_SINREGISTROS);
			}

			for (int i = 0; i < contratos.size(); i++ ) {
				if (contratos.get(i).getStatus() != null) {
					if (!contratos.get(i).getStatus().equalsIgnoreCase("P")) {
						HashMap<String, Object> parametrosSaldos = new HashMap<String, Object>();
						parametrosSaldos.put("contrato", contratos.get(i).getContrato());
						parametrosSaldos.put("fechaActual", fechaContable);

						LogHandler.trace(uid, getClass(), "prGetDetalleGrupoTarea: - obtenerSaldoV");
						LogHandler.info(uid, getClass(), "prGetDetalleGrupoTarea: - obtenerSaldoV");
						HashMap<String, Object> saldos = (HashMap<String, Object>)
								sessionNTx.selectOne( "obtenerSaldoV", parametrosSaldos);
						contratos.get(i).setMePrincipalBalance(Double.valueOf(saldos.get("Capital Insoluto").toString()));

						LogHandler.trace(uid, getClass(), "prGetDetalleGrupoTarea: - obtenerFinalEstadoDeCuenta");
						LogHandler.info(uid, getClass(), "prGetDetalleGrupoTarea: - obtenerFinalEstadoDeCuenta");
						ResumenSaldoOV movimientos = (ResumenSaldoOV)
								sessionNTx.selectOne( "obtenerFinalEstadoDeCuenta", contratos.get(i).getContrato());
						contratos.get(i).setMeInterestBalance(
								contratos.get(i).getMeTotalInterest()
								- (Double.valueOf(movimientos.getInteres()) + Double.valueOf(movimientos.getIvaInteres()))
								);
						contratos.get(i).setMePenaltyBalance(Double.valueOf(saldos.get("Moratorio").toString()));
						contratos.get(i).setMeTotalBalance(
								contratos.get(i).getMePenaltyBalance() + contratos.get(i).getMeInterestBalance()
								+ contratos.get(i).getMePrincipalBalance());
						contratos.get(i).setMePrincipalPastDue(Double.valueOf(saldos.get("Capital Vencido").toString()));
						contratos.get(i).setMeInterestPastDue(
								Double.valueOf(saldos.get("Interes Vencido").toString())
								+ Double.valueOf(saldos.get("Iva Interes Vencido").toString())
								);
						contratos.get(i).setMePenalty(
								Double.valueOf(saldos.get("Moratorio").toString())
								+ Double.valueOf(saldos.get("Iva Moratorio").toString())
								);
						contratos.get(i).setMeTotalPastDue(
								contratos.get(i).getMePrincipalPastDue() +	contratos.get(i).getMeInterestPastDue()
								+ contratos.get(i).getMePenalty()
								);
					}
				}
			}

			buroCreditoClienteDetalleGrupoRespuesta.setPrmFecha(fechaContable);
			buroCreditoClienteDetalleGrupoRespuesta.setContratos(contratos);
		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "prGetDetalleGrupoTarea: " + ex.getMessage(), ex);
			buroCreditoClienteDetalleGrupoRespuesta.getHeader().setEstatus(false);
			buroCreditoClienteDetalleGrupoRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			buroCreditoClienteDetalleGrupoRespuesta.getHeader().setCodigo(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return buroCreditoClienteDetalleGrupoRespuesta;
	}

	/**
	 *@param buroCreditoComunalPeticion :
	 *@param uid :
	 *@return BuroCreditoClienteRespuesta
	 */
	@SuppressWarnings("unchecked")
	public BuroCreditoComunalRespuesta findCredComunalTarea(String uid, BuroCreditoComunalPeticion buroCreditoComunalPeticion) {
		BuroCreditoComunalRespuesta buroCreditoComunalRespuesta = new BuroCreditoComunalRespuesta();
		buroCreditoComunalRespuesta.setHeader(new EncabezadoRespuesta());
		buroCreditoComunalRespuesta.getHeader().setUID(uid);
		buroCreditoComunalRespuesta.getHeader().setEstatus(true);
		SqlSession sessionNTx	= null;
		String validaStr 		= "";
		try {
			String[] datosRequeridos = {"idIN"};
			validaStr = Validaciones.datosRequeridos(buroCreditoComunalPeticion, datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			//Se abre la session Transaccional sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(), "findCredComunalTarea: - consultaFindCredComunal");
			LogHandler.info(uid, getClass(), "findCredComunalTarea: - consultaFindCredComunal");
			List<BuroCreditoComunal> buroCreditoComunalQueryResult = (List<BuroCreditoComunal>)
					sessionNTx.selectList("consultaFindCredComunal", buroCreditoComunalPeticion.getIdIN());
			if (buroCreditoComunalQueryResult.isEmpty()) {
				throw new Exception(CONSULTA_SINREGISTROS);
			}
			buroCreditoComunalRespuesta.setClientes(buroCreditoComunalQueryResult);
		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "findCredComunalTarea: " + ex.getMessage(), ex);
			buroCreditoComunalRespuesta.getHeader().setEstatus(false);
			buroCreditoComunalRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			buroCreditoComunalRespuesta.getHeader().setCodigo(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return buroCreditoComunalRespuesta;
	}


	/**
	 *@param buroCreditoClienteGrupoPeticion :
	 *@param uid :
	 *@return BuroCreditoClienteRespuesta
	 */
	@SuppressWarnings("unchecked")
	public BuroCreditoClienteGrupoRespuesta prGetDetalleHistoriaCTarea(String uid,
			BuroCreditoClienteGrupoPeticion buroCreditoClienteGrupoPeticion) {

		BuroCreditoClienteGrupoRespuesta buroCreditoClienteGrupoRespuesta = new BuroCreditoClienteGrupoRespuesta();
		buroCreditoClienteGrupoRespuesta.setHeader(new EncabezadoRespuesta());
		buroCreditoClienteGrupoRespuesta.getHeader().setUID(uid);
		buroCreditoClienteGrupoRespuesta.getHeader().setEstatus(true);
		SqlSession sessionNTx	= null;
		String validaStr 		= "";
		try {
			String[] datosRequeridos = {"persona"};
			validaStr = Validaciones.datosRequeridos(buroCreditoClienteGrupoPeticion, datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			//Se abre la session No transaccional sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(), "prGetDetalleHistoriaCTarea: - consultaPrGetFecha");
			LogHandler.info(uid, getClass(), "prGetDetalleHistoriaCTarea: - consultaPrGetFecha");
			Date fechaContable = (Date) sessionNTx.selectOne("consultaPrGetFecha");
			if (fechaContable == null) {
				throw new Exception(CONSULTA_SINREGISTROS);
			}
			buroCreditoClienteGrupoPeticion.setFecha(fechaContable);

			LogHandler.trace(uid, getClass(), "prGetDetalleHistoriaCTarea: - obtenerPersonaMin");
			LogHandler.info(uid, getClass(), "prGetDetalleHistoriaCTarea: - obtenerPersonaMin");
			String persona = (String) sessionNTx.selectOne("obtenerPersonaMin", buroCreditoClienteGrupoPeticion.getPersona());
			if (persona == null) {
				throw new Exception(CONSULTA_SINREGISTROS);
			}
			buroCreditoClienteGrupoPeticion.setPersona(persona);

			LogHandler.trace(uid, getClass(), "prGetDetalleHistoriaCTarea: - consultaPrGetDetalleHistoriaC");
			LogHandler.info(uid, getClass(), "prGetDetalleHistoriaCTarea: - consultaPrGetDetalleHistoriaC");

			List<BuroCreditoClienteGrupo> buroCreditoClienteGrupoQueryResult = (List<BuroCreditoClienteGrupo>)
					sessionNTx.selectList("consultaPrGetDetalleHistoriaC", buroCreditoClienteGrupoPeticion);
			if (buroCreditoClienteGrupoQueryResult.isEmpty()) {
				throw new Exception(CONSULTA_SINREGISTROS);
			}

			for (int i = 0; i < buroCreditoClienteGrupoQueryResult.size(); i++ ) {
				HashMap<String, Object> parametrosSaldos = new HashMap<String, Object>();
				parametrosSaldos.put("contrato", buroCreditoClienteGrupoQueryResult.get(i).getContrato());
				parametrosSaldos.put("fechaActual", fechaContable);

				LogHandler.trace(uid, getClass(), "prGetDetalleHistoriaCTarea: - obtenerSaldoV");
				LogHandler.info(uid, getClass(), "prGetDetalleHistoriaCTarea: - obtenerSaldoV");
				HashMap<String, Object> saldos = (HashMap<String, Object>)
						sessionNTx.selectOne( "obtenerSaldoV", parametrosSaldos);
				buroCreditoClienteGrupoQueryResult.get(i).setMePrincipalBalance(
						Double.valueOf(saldos.get("Capital Insoluto").toString()));

				LogHandler.trace(uid, getClass(), "prGetDetalleHistoriaCTarea: - obtenerFinalEstadoDeCuenta");
				LogHandler.info(uid, getClass(), "prGetDetalleHistoriaCTarea: - obtenerFinalEstadoDeCuenta");
				ResumenSaldoOV movimientos = (ResumenSaldoOV)
					sessionNTx.selectOne( "obtenerFinalEstadoDeCuenta", buroCreditoClienteGrupoQueryResult.get(i).getContrato());
				buroCreditoClienteGrupoQueryResult.get(i).setMeInterestBalance(
						buroCreditoClienteGrupoQueryResult.get(i).gettI()
						- (Double.valueOf(movimientos.getInteres()) + Double.valueOf(movimientos.getIvaInteres())));
				buroCreditoClienteGrupoQueryResult.get(i).setMePenaltyBalance(Double.valueOf(saldos.get("Moratorio").toString()));
				buroCreditoClienteGrupoQueryResult.get(i).setMeTotalBalance(
						buroCreditoClienteGrupoQueryResult.get(i).getMePenaltyBalance()
						+ buroCreditoClienteGrupoQueryResult.get(i).getMeInterestBalance()
						+ buroCreditoClienteGrupoQueryResult.get(i).getMePrincipalBalance());
				buroCreditoClienteGrupoQueryResult.get(i).setMePrincipalPastDue(
						Double.valueOf(saldos.get("Capital Vencido").toString()));
				buroCreditoClienteGrupoQueryResult.get(i).setMeInterestPastDue(
						Double.valueOf(saldos.get("Interes Vencido").toString())
						+ Double.valueOf(saldos.get("Iva Interes Vencido").toString())
						);
				buroCreditoClienteGrupoQueryResult.get(i).setMePenalty(
						Double.valueOf(saldos.get("Moratorio").toString())
						+ Double.valueOf(saldos.get("Iva Moratorio").toString())
						);
				buroCreditoClienteGrupoQueryResult.get(i).setMeTotalPastDue(
						buroCreditoClienteGrupoQueryResult.get(i).getMePrincipalPastDue()
						+ buroCreditoClienteGrupoQueryResult.get(i).getMeInterestPastDue()
						+ buroCreditoClienteGrupoQueryResult.get(i).getMePenalty()
						);
			}
			buroCreditoClienteGrupoRespuesta.setGrupos(buroCreditoClienteGrupoQueryResult);
		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "prGetDetalleHistoriaCTarea: " + ex.getMessage(), ex);
			buroCreditoClienteGrupoRespuesta.getHeader().setEstatus(false);
			buroCreditoClienteGrupoRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			buroCreditoClienteGrupoRespuesta.getHeader().setCodigo(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return buroCreditoClienteGrupoRespuesta;
	}

	/**
	 *@param buroCreditoContratoPeticion :
	 *@param uid :
	 *@return BuroCreditoClienteRespuesta
	 */
	public BuroCreditoContratoRespuesta prGetCountMoraTarea(String uid, BuroCreditoContratoPeticion buroCreditoContratoPeticion) {

		BuroCreditoContratoRespuesta buroCreditoContratoRespuesta = new BuroCreditoContratoRespuesta();
		buroCreditoContratoRespuesta.setHeader(new EncabezadoRespuesta());
		buroCreditoContratoRespuesta.getHeader().setUID(uid);
		buroCreditoContratoRespuesta.getHeader().setEstatus(true);
		SqlSession sessionNTx	= null;
		String validaStr 		= "";

		try {
			String[] datosRequeridos = {"prmContract"};
			validaStr = Validaciones.datosRequeridos(buroCreditoContratoPeticion, datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			//Se abre la session No transaccional sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			LogHandler.trace(uid, getClass(), "prGetCountMoraTarea: - cuentaMora");
			LogHandler.info(uid, getClass(), "prGetCountMoraTarea: - cuentaMora");
			Integer countMora = (Integer) sessionNTx.selectOne("cuentaMora", buroCreditoContratoPeticion.getPrmContract());
			if (null == countMora) {
				throw new Exception(CONSULTA_SINREGISTROS);
			}
			buroCreditoContratoRespuesta.setMaxRetraso(countMora.intValue());

		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "prGetCountMoraTarea: " + ex.getMessage(), ex);
			buroCreditoContratoRespuesta.getHeader().setEstatus(false);
			buroCreditoContratoRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			buroCreditoContratoRespuesta.getHeader().setCodigo(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return buroCreditoContratoRespuesta;
	}

	/**
	 *@param buroCreditoRFCPeticion :
	 *@param uid :
	 *@return BuroCreditoClienteRespuesta
	 */
	public BuroCreditoRFCRespuesta getRFCClienteTarea(String uid, BuroCreditoRFCPeticion buroCreditoRFCPeticion) {
		BuroCreditoRFCRespuesta buroCreditoRFCRespuesta = new BuroCreditoRFCRespuesta();
		buroCreditoRFCRespuesta.setHeader(new EncabezadoRespuesta());
		buroCreditoRFCRespuesta.getHeader().setUID(uid);
		buroCreditoRFCRespuesta.getHeader().setEstatus(true);
		SqlSession sessionNTx				= null;
		String validaStr					= "";
		try {
			if (buroCreditoRFCPeticion == null) {
				throw new Exception(DATOS_INCORRECTOS);
			}

			String[] datosRequeridos = {"clienteID"};
			validaStr = Validaciones.datosRequeridos(buroCreditoRFCPeticion, datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			//Se abre la session No transaccional sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			LogHandler.trace(uid, getClass(), "getRFCClienteTarea: - consultaGetRFCCliente");
			LogHandler.info(uid, getClass(), "getRFCClienteTarea: - consultaGetRFCCliente");
			BuroCreditoRFCRespuesta buroCreditoRFCRespuestaTmp = (BuroCreditoRFCRespuesta)
					sessionNTx.selectOne("consultaGetRFCCliente",  buroCreditoRFCPeticion.getClienteID());
			if (buroCreditoRFCRespuestaTmp == null) {
				throw new Exception(CONSULTA_SINREGISTROS);
			}
			buroCreditoRFCRespuesta.setRfc(buroCreditoRFCRespuestaTmp.getRfc());
			buroCreditoRFCRespuesta.setPersona(buroCreditoRFCRespuestaTmp.getPersona());
		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "getRFCClienteTarea: " + ex.getMessage(), ex);
			buroCreditoRFCRespuesta.getHeader().setEstatus(false);
			buroCreditoRFCRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			buroCreditoRFCRespuesta.getHeader().setCodigo(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return buroCreditoRFCRespuesta;
	}

	/**
	 *@param buroCreditoRFCPeticion :
	 *@param uid :
	 *@return BuroCreditoClienteRespuesta
	 */
	@SuppressWarnings("unchecked")
	public BuroCreditoRFCRespuesta getClientbyRFCTarea(String uid, BuroCreditoRFCPeticion buroCreditoRFCPeticion) {
		BuroCreditoRFCRespuesta buroCreditoRFCRespuesta = new BuroCreditoRFCRespuesta();
		buroCreditoRFCRespuesta.setHeader(new EncabezadoRespuesta());
		buroCreditoRFCRespuesta.getHeader().setUID(uid);
		buroCreditoRFCRespuesta.getHeader().setEstatus(true);
		SqlSession sessionNTx				= null;
		String validaStr					= "";
		try {
			if (buroCreditoRFCPeticion == null) {
				throw new Exception(DATOS_INCORRECTOS);
			}

			String[] datosRequeridos = {"rfc"};
			validaStr = Validaciones.datosRequeridos(buroCreditoRFCPeticion, datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			//Se abre la session No transaccional sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			LogHandler.trace(uid, getClass(), "getClientbyRFCTarea: - consultaGetClientbyRFC");
			LogHandler.info(uid, getClass(), "getClientbyRFCTarea: - consultaGetClientbyRFC");
			List<BuroCreditoRFC> clientes = (List<BuroCreditoRFC>)
					sessionNTx.selectList("consultaGetClientbyRFC", buroCreditoRFCPeticion.getRfc());
			if (clientes.isEmpty()) {
				throw new Exception(CONSULTA_SINREGISTROS);
			}
			buroCreditoRFCRespuesta.setClientes(clientes);
		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "getClientbyRFCTarea: " + ex.getMessage(), ex);
			buroCreditoRFCRespuesta.getHeader().setEstatus(false);
			buroCreditoRFCRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			buroCreditoRFCRespuesta.getHeader().setCodigo(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return buroCreditoRFCRespuesta;
	}

	/**
	 *@param buroCreditoRFCPeticion :
	 *@param uid :
	 *@return BuroCreditoClienteRespuesta
	 */
	@SuppressWarnings("unchecked")
	public BuroCreditoRFCRespuesta getClientBCETarea(String uid, BuroCreditoRFCPeticion buroCreditoRFCPeticion) {
		BuroCreditoRFCRespuesta buroCreditoRFCRespuesta = new BuroCreditoRFCRespuesta();
		buroCreditoRFCRespuesta.setHeader(new EncabezadoRespuesta());
		buroCreditoRFCRespuesta.getHeader().setUID(uid);
		buroCreditoRFCRespuesta.getHeader().setEstatus(true);
		SqlSession sessionNTx	= null;
		String validaStr		= "";
		try {
			if (buroCreditoRFCPeticion == null || buroCreditoRFCPeticion.getPersona() == null
					|| buroCreditoRFCPeticion.getPersona().trim().isEmpty()) {
				throw new Exception(DATOS_INCORRECTOS);
			}

			String[] datosRequeridos = {"persona"};
			validaStr = Validaciones.datosRequeridos(buroCreditoRFCPeticion, datosRequeridos);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			//Se abre la session No transaccional sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			/*
			LogHandler.trace(uid, getClass(), "getClientBCETarea: - consultaGetClientBCEPersonas");
			LogHandler.info(uid, getClass(), "getClientBCETarea: - consultaGetClientBCEPersonas");
			List<String> personas = (List<String>)
					sessionNTx.selectList("consultaGetClientBCEPersonas", buroCreditoRFCPeticion.getPersona().trim());
			if (personas.isEmpty()) {
				throw new Exception(CONSULTA_SINREGISTROS);
			}
			LogHandler.info(uid, getClass(), "getClientBCETarea: - personas.size(): " + personas.size());
			*/

			LogHandler.trace(uid, getClass(), "getClientBCETarea: - consultaGetClientBCE");
			LogHandler.info(uid, getClass(), "getClientBCETarea: - consultaGetClientBCE");
			List<BuroCreditoBCE> clientes = (List<BuroCreditoBCE>) sessionNTx.selectList("consultaGetClientBCE",
					buroCreditoRFCPeticion.getPersona() );
			if (clientes.isEmpty()) {
				throw new Exception(CONSULTA_SINREGISTROS);
			}
			buroCreditoRFCRespuesta.setClientesBCE(clientes);
		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "getClientBCETarea: " + ex.getMessage(), ex);
			buroCreditoRFCRespuesta.getHeader().setEstatus(false);
			buroCreditoRFCRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			buroCreditoRFCRespuesta.getHeader().setCodigo(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return buroCreditoRFCRespuesta;
	}


	/**
	 * @param uid Identificador de Transaccion
	 * @param peticion de consulta
	 * @return ConsultaBuroRespuesta
	 */
	public ConsultaBuroRespuesta consultaBuroCredito(String uid, ConsultaBuroPeticion peticion) {

		ConsultaBuroRespuesta respuesta = new ConsultaBuroRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sessionNTx	= null;
		 try {
			 if (peticion == null || peticion.getPersona() == null || peticion.getPersona().trim().isEmpty()) {
	             throw new Exception("La clave del cliente en la peticion es necesaria.");
			 }
	         if (peticion.getImporte() <= 0) {
	             throw new Exception("El monto debe ser mayor a cero en la peticion.");
	         }

	         if (peticion.getUsuario() == null || peticion.getUsuario().trim().isEmpty()) {
	             throw new Exception("El usuario en la peticion es necesaria.");
	         }

	         if (peticion.getSucursal() < 0) {
	             throw new Exception("La sucursal en la peticion es necesaria.");
	         }

	         BuroCreditoRFCPeticion consultaClientePeticion = new BuroCreditoRFCPeticion();
	         consultaClientePeticion.setPersona(peticion.getPersona());
	         BuroCreditoRFCRespuesta consultaCliente = getClientBCETarea(uid, consultaClientePeticion);

	         if (consultaCliente.getHeader().isEstatus()) {
		        	//Se abre la session No transaccional sybase
		     		sessionNTx = FabricaConexiones.obtenerSesionNTx();

		     		LogHandler.trace(uid, getClass(), "obtenerDatosPlanillaAprobacion: - obtenerParGeneral");
		     		ParGeneralOV urlBuro = comun.obtenerParGeneralOV(uid, "BURO_URL");
		     				//(ParGeneralOV) sessionNTx.selectOne("obtenerParGeneral", "BURO_URL");
		     		if (urlBuro == null || urlBuro.getCgValor().trim().isEmpty()) {
		     				throw new Exception("No fue posible obtener la URL del servicio de buro.");
		     		}
		     		ServicioBuroCreditoProxy ws = new ServicioBuroCreditoProxy();
		     		ws.setEndpoint(urlBuro.getCgValor().trim());

	        	 	ConsultarBuroXMLRequest request = new ConsultarBuroXMLRequest();
	        	 	ConsultarBuroXMLResponse response = new ConsultarBuroXMLResponse();
	        	 	request.setControl(new ControlInterno());
	        	 	request.getControl().setEmpresa(EMPRESA);
	        	 	request.getControl().setOrigen(ORIGEN);
	        	 	request.getControl().setNumeroSolicitud(SOLICITUD_CONSTANTE);
	        	 	request.getControl().setSucursal(peticion.getSucursal() + "");
	        	 	request.getControl().setNumeroEmpleado(peticion.getUsuario());
	        	 	request.getControl().setNumeroPersona(peticion.getPersona().trim());
	        	 	request.getControl().setGrupo(GRUPO_CONSTANTE);
	        	 	request.getControl().setAsincrono(false);
	        	 	request.getControl().setIdAtomo(ATOMO_CONSTANTE);
	        	 	request.getControl().setEobjXMLDatos("");
	        	 	request.getControl().setPrioridad("3");
	        	 	request.setCredito(new DatosCredito());
	        	 	request.getCredito().setImporte(String.valueOf(peticion.getImporte()));
	        	 	request.getCredito().setCategoria("COMN");
	        	 	request.getCredito().setSegmento("INFO");
	        	 	request.getCredito().setTipoProducto("GRUP");

	        		BuroCreditoBCE  clienteBuro = consultaCliente.getClientesBCE().get(0);
	        		request.setBnc(new DatosBnc());
	        	 	request.getBnc().setPrimerNombre(clienteBuro.getNombres().split( " " )[0]);
	        	 	request.getBnc().setSegundoNombre(clienteBuro.getNombres().substring(
	        	 			request.getBnc().getPrimerNombre().toString().length() ).trim());
	        	 	request.getBnc().setApPaterno(clienteBuro.getApellidoPaterno() != null
	        	 				? clienteBuro.getApellidoPaterno() : "");
	        	 	request.getBnc().setApMaterno(clienteBuro.getApellidoMaterno() != null
	        	 				? clienteBuro.getApellidoMaterno() : "");
	        	 	request.getBnc().setFechaNacimiento(clienteBuro.getFechaNacimiento().replace("/", ""));
	        	 	request.getBnc().setRfc(clienteBuro.getRfc());
	        	 	request.getBnc().setEstadoCivil(clienteBuro.getEstadoCivil());
	        	 	request.getBnc().setSexo(clienteBuro.getSexo());
	        	 	request.getBnc().setNacionalidad(clienteBuro.getNacionalidad());
	        	 	request.getBnc().setCalle( clienteBuro.getDireccion() + " " + clienteBuro.getNumeroExterior());
	        	 	request.getBnc().setCalle(request.getBnc().getCalle().trim());
	        	 	request.getBnc().setColonia(clienteBuro.getColoniaPoblacion());
	        	 	request.getBnc().setMunicipio(clienteBuro.getDelegacionMunicipio());
	        	 	request.getBnc().setCiudad(clienteBuro.getCiudad());
	        	 	request.getBnc().setEntidad(clienteBuro.getCodigoEstadoburo());
	        	 	request.getBnc().setCp(clienteBuro.getCp());
	        	 	request.getBnc().setTelefono(clienteBuro.getTelefono());
	        	 	LogHandler.info(uid, getClass(), "consultaBuroCredito: getFechaNacimiento()"
	        	 			+ request.getBnc().getFechaNacimiento() );


	        	 	String respuestaXMLServicio = "";
	        	 	try  {
	        	 		response = ws.consultarBuroXML(request);
	        	 		LogHandler.info(uid, getClass(), "consultaBuroCredito: " );
	        	 		LogHandler.info(uid, getClass(), "consultaBuroCredito: " + request);
	        	 		respuestaXMLServicio = response.getRespuestaBuroXML();
	        	 		LogHandler.info(uid, getClass(), "consultaBuroCredito: " + respuestaXMLServicio);
	        	 	} catch (BncException exBuroSrv) {
	        	 		throw new Exception("Error en la llamada al servicio de buro [BncException]. "
	        	 				+ exBuroSrv.getRespuestaClave());
	        	 	}
	        	 	catch (Exception exBuro) {
	        	 		throw new Exception("Error en la llamada al servicio de buro. " + exBuro.getMessage());
	        	 	}


        			String resultado = obtenerValorTag(respuestaXMLServicio, "resultado");
        			if ( Integer.parseInt(resultado) == 0 ) {
        				respuesta.setBuroCreditoXML(obtenerValorTag(respuestaXMLServicio, "XMLDatosBuro"));
        			} else {
        				throw new Exception(obtenerValorTag(respuestaXMLServicio, "mensaje"));
        			}


	         } else {
	        	 throw new Exception("No fue posible obtener los datos del cliente. " + consultaCliente.getHeader().getMensaje());
	         }

		 }
		 catch (Exception ex) {
			LogHandler.error(uid, getClass(), "consultaBuroCredito: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}
		 finally {
				FabricaConexiones.close(sessionNTx);
		 }

		return respuesta;

	}


	/**
	 * @param uid Identificador de Transaccion
	 * @param peticion de consulta
	 * @return ConsultaBuroRespuesta
	 */
	public ConsultaBuroRespuesta validaConsultaVigente(String uid, ConsultaBuroPeticion peticion) {

		ConsultaBuroRespuesta respuesta = new ConsultaBuroRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensaje("Consulta vigente.");
		SqlSession sessionNTx	= null;
		 try {
			 if (peticion == null || peticion.getPersona() == null || peticion.getPersona().trim().isEmpty()) {
	             throw new Exception("La clave del cliente en la peticion es necesaria.");
			 }

	         BuroCreditoRFCPeticion consultaClientePeticion = new BuroCreditoRFCPeticion();
	         consultaClientePeticion.setPersona(peticion.getPersona());
	         BuroCreditoRFCRespuesta consultaCliente = getClientBCETarea(uid, consultaClientePeticion);

	         if (consultaCliente.getHeader().isEstatus()) {

	        	//Se abre la session No transaccional sybase
		    	sessionNTx = FabricaConexiones.obtenerSesionNTx();

	        	LogHandler.trace(uid, getClass(), "obtenerDatosPlanillaAprobacion: - obtenerParGeneral");
	     		ParGeneralOV urlBuro = comun.obtenerParGeneralOV(uid, "BURO_URL");
	     				//(ParGeneralOV)	sessionNTx.selectOne("obtenerParGeneral", "BURO_URL");
	     		if (urlBuro == null || urlBuro.getCgValor().trim().isEmpty()) {
	     				throw new Exception("No fue posible obtener la URL del servicio de buro.");
	     		}
	     		ServicioBuroCreditoProxy ws = new ServicioBuroCreditoProxy();
	     		ws.setEndpoint(urlBuro.getCgValor().trim());
	     		ObtenerXMLReporteCreditoRequest request = new ObtenerXMLReporteCreditoRequest();
	     		ObtenerXMLReporteCreditoResponse response = new ObtenerXMLReporteCreditoResponse();
	     		request.setPersona(peticion.getPersona().trim());
	     		response = ws.obtenerXMLReporteCredito(request);

	     		if ( response == null || response.getXMLReporteCredito().isEmpty()) {
	     			throw new Exception("El cliente " + peticion.getPersona() + " no tiene consulta al buro.");
	     		}
	     		LogHandler.info(uid, getClass(), "obtenerDatosPlanillaAprobacion:" + "BURO" + response.getXMLReporteCredito());
	    		ReporteCredito reporteCredito = obtenerObjetoBCN(response.getXMLReporteCredito());
	    		String fechaConsulta = "";
	    		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
	    		Date dFechaConsulta = null;
	    		if ( reporteCredito.getConsultas().size() == 0 ) {
	    			throw new Exception("No es posible obtener la fecha de consulta del buro");
	    		} else {
	    			fechaConsulta = reporteCredito.getConsultas().get(0).getFechaConsulta();
	    			dFechaConsulta = formatter.parse(fechaConsulta);
	    		}
	    		int diasDiferencia = diferenciaEnDias(new Date(), dFechaConsulta);

	    		respuesta.setDiasConsulta(diasDiferencia);

	    		//Obtenemos valor de dias consulta vigente
	    		//Se obtiene el usuario que atiende las tareas de reasignacion de cartera
	    		LogHandler.trace(uid, getClass(), "obtenerDatosPlanillaAprobacion: - obtenerParGeneral");
	    		ParGeneralOV diasParametro = comun.obtenerParGeneralOV(uid, "BURO_DIASV");
	    				//(ParGeneralOV) sessionNTx.selectOne("obtenerParGeneral", "BURO_DIASV");

	    		if (diasParametro == null || diasParametro.getCgValor().trim().isEmpty() ) {
	    			throw new Exception("No fue posible obtener el valor de dias minimo consulta buro vigente.");
	    		}

	    		if (diasDiferencia > Integer.parseInt(diasParametro.getCgValor().trim())) {
	    			throw new Exception("El cliente " + peticion.getPersona()
	    					+ " no tiene consulta vigente al buro, ultima consulta hace " + diasDiferencia + " dias.");
	    		}

	         } else {
	        	 throw new Exception("No fue posible obtener los datos del cliente. " + consultaCliente.getHeader().getMensaje());
	         }

		 }
		 catch (BncException exBuroSrv) {
				exBuroSrv.printStackTrace();
				respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensaje("Error en la llamada al servicio de buro [BncException]. "
						+ exBuroSrv.getRespuestaClave());
	 	 }
		 catch (Exception ex) {
			LogHandler.error(uid, getClass(), "consultaBuroCredito: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}
		finally {
				FabricaConexiones.close(sessionNTx);
		}

		return respuesta;

	}

	/**
	 * @param uid Identificador de Transaccion
	 * @param peticion de consulta
	 * @return ConsultaBuroRespuesta
	 */
	public ConsultaBuroRespuesta obtenerUltimaConsulta(String uid, ConsultaBuroPeticion peticion) {

		ConsultaBuroRespuesta respuesta = new ConsultaBuroRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensaje("Consulta vigente.");
		SqlSession sessionNTx	= null;
		 try {
			 if (peticion == null || peticion.getPersona() == null || peticion.getPersona().trim().isEmpty()) {
	             throw new Exception("La clave del cliente en la peticion es necesaria.");
			 }

			//Se abre la session No transaccional sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			LogHandler.trace(uid, getClass(), "obtenerUltimaConsulta: - obtenerParGeneral");
			ParGeneralOV urlBuro = comun.obtenerParGeneralOV(uid, "BURO_URL");
					//(ParGeneralOV)	sessionNTx.selectOne("obtenerParGeneral", "BURO_URL");
			if (urlBuro == null || urlBuro.getCgValor().trim().isEmpty()) {
					throw new Exception("No fue posible obtener la URL del servicio de buro.");
			}
			ServicioBuroCreditoProxy ws = new ServicioBuroCreditoProxy();
			ws.setEndpoint(urlBuro.getCgValor().trim());
     		ObtenerXMLReporteCreditoRequest request = new ObtenerXMLReporteCreditoRequest();
     		ObtenerXMLReporteCreditoResponse response = new ObtenerXMLReporteCreditoResponse();
     		request.setPersona(peticion.getPersona().trim());
     		response = ws.obtenerXMLReporteCredito(request);

     		if ( response == null || response.getXMLReporteCredito().trim().isEmpty()) {
     			throw new Exception("El cliente " + peticion.getPersona() + " no tiene consulta al buro.");
     		}

     		LogHandler.info(uid, getClass(), "validacionSolicitudBuro:" + peticion.getPersona()
     				+ response.getXMLReporteCredito().length());

     		respuesta.setBuroCreditoXML(response.getXMLReporteCredito());
		 }
		 catch (BncException exBuroSrv) {
				exBuroSrv.printStackTrace();
				respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensaje("Error en la llamada al servicio de buro [BncException]. "
						+ exBuroSrv.getRespuestaClave());
	 	  }
		 catch (Exception ex) {
			LogHandler.error(uid, getClass(), "consultaBuroCredito: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}
		finally {
				FabricaConexiones.close(sessionNTx);
		}

		return respuesta;

	}

	/**
	 * @param uid Identificador de Transaccion
	 * @param peticion de consulta
	 * @return ConsultaBuroRespuesta
	 */
	public ConsultaBuroRespuesta obtenerConsultaPorFolio(String uid, ConsultaBuroPeticion peticion) {

		ConsultaBuroRespuesta respuesta = new ConsultaBuroRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensaje("Consulta vigente.");
		SqlSession sessionNTx	= null;
		 try {
			 if (peticion == null || peticion.getFolio() == null || peticion.getFolio().trim().isEmpty()) {
	             throw new Exception("El folio en la peticion es necesaria.");
			 }

			//Se abre la session No transaccional sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			LogHandler.trace(uid, getClass(), "obtenerUltimaConsulta: - obtenerParGeneral");
			ParGeneralOV urlBuro = comun.obtenerParGeneralOV(uid, "BURO_URL");
					//(ParGeneralOV)	sessionNTx.selectOne("obtenerParGeneral", "BURO_URL");
			if (urlBuro == null || urlBuro.getCgValor().trim().isEmpty()) {
					throw new Exception("No fue posible obtener la URL del servicio de buro.");
			}
			ServicioBuroCreditoProxy ws = new ServicioBuroCreditoProxy();
			ws.setEndpoint(urlBuro.getCgValor().trim());
			ObtenerXMLReporteCreditoPorFolioRequest request = new ObtenerXMLReporteCreditoPorFolioRequest();
     		ObtenerXMLReporteCreditoPorFolioResponse response = new ObtenerXMLReporteCreditoPorFolioResponse();
     		request.setFolio(peticion.getFolio().trim());
     		response = ws.obtenerXMLReporteCreditoPorFolio(request);

     		if ( response == null || response.getXMLReporteCredito().trim().isEmpty()) {
     			throw new Exception("El folio " + peticion.getFolio() + " no tiene consulta al buro.");
     		}

     		LogHandler.info(uid, getClass(), "validacionSolicitudBuro:" + peticion.getPersona()
     				+ response.getXMLReporteCredito().length());

     		respuesta.setBuroCreditoXML(response.getXMLReporteCredito());
		 }
		 catch (BncException exBuroSrv) {
				exBuroSrv.printStackTrace();
				respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensaje("Error en la llamada al servicio de buro [BncException]. "
						+ exBuroSrv.getRespuestaClave());
	 	  }
		 catch (Exception ex) {
			LogHandler.error(uid, getClass(), "consultaBuroCredito: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}
		finally {
				FabricaConexiones.close(sessionNTx);
		}

		return respuesta;

	}

	/*Validacion solicitud buro desde SACG*/

	/**
	 * @param uid Identificador de Transaccion
	 * @param peticion de consulta
	 * @return ConsultaBuroRespuesta
	 */
	@SuppressWarnings("unchecked")
	public ValidaSolicitudRespuesta validacionSolicitudBuro(String uid, ValidaSolicitudPeticion peticion) {
		ValidaSolicitudRespuesta respuesta = new ValidaSolicitudRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensaje("");
		SqlSession sessionNTx	= null;
		try {
			if (peticion == null || peticion.getSolicitud() == null
					|| peticion.getSolicitud().trim().isEmpty()) {
				throw new Exception("El ID de la solicitud en la peticion es necesaria.");
			}
			if (peticion.getIntegrantes() == null ) {
				throw new Exception("La peticion debe de tener al menos un integrante.");
			}
			if (peticion.getIntegrantes().isEmpty()) {
				throw new Exception("La peticion debe de tener al menos un integrante.");
			}

			//Se abre la session No transaccional sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(), "validacionSolicitudBuro: - obtenerParGeneral");
			ParGeneralOV urlBuro = comun.obtenerParGeneralOV(uid, "BURO_URL");
					//(ParGeneralOV)	sessionNTx.selectOne("obtenerParGeneral", "BURO_URL");
			if (urlBuro == null || urlBuro.getCgValor().trim().isEmpty()) {
					throw new Exception("No fue posible obtener la URL del servicio de buro.");
			}
			ServicioBuroCreditoProxy ws = new ServicioBuroCreditoProxy();
			ws.setEndpoint(urlBuro.getCgValor().trim());

			//Obtenemos datos de la solicitud
			List<HashMap<String, Object>> datosSolicitud
				= (List<HashMap<String, Object>>) sessionNTx.selectList("obtieneExpressSolicitud", peticion.getSolicitud());

			if (datosSolicitud == null || datosSolicitud.isEmpty()) {
					throw new Exception("No fue posible obtener los datos de la solicitud.");
			}

			SolicitudBuroOV peticionRegistoBuro = new SolicitudBuroOV();
			peticionRegistoBuro.setSolicitud(peticion.getSolicitud());

			List<SolicitudBuroClienteOV> integrantes = new ArrayList<SolicitudBuroClienteOV>();

			//SE valida que todos los clientes tengan consulta al buro.
			for ( IntegranteSolicitud integrante : peticion.getIntegrantes()) {
				SolicitudBuroClienteOV buroCliente = new SolicitudBuroClienteOV();
				if ( integrante.getPersona() == null || integrante.getPersona().trim().isEmpty() ) {
					throw new Exception("Un intengrante de la peticion no tiene numero de persona, es obligatorio.");
				}

	     		ObtenerXMLReporteCreditoRequest request = new ObtenerXMLReporteCreditoRequest();
	     		ObtenerXMLReporteCreditoResponse response = new ObtenerXMLReporteCreditoResponse();
	     		request.setPersona(integrante.getPersona().trim());
	     		//Obtenemos la ultima consulta al buro (sin costo)
	     		//LogHandler.info(uid, getClass(), "*********" + integrante.getPersona());
	     		response = ws.obtenerXMLReporteCredito(request);
	     		if ( response == null || response.getXMLReporteCredito().trim().isEmpty()) {
	     			throw new Exception("El cliente " + integrante.getPersona() + " no tiene consulta al buro.");
	     		}
	     		//LogHandler.info(uid, getClass(), "*********" + response.getXMLReporteCredito());

	    		ReporteCredito reporteCredito = obtenerObjetoBCN(response.getXMLReporteCredito());

	    		buroCliente.setSolicitud(peticion.getSolicitud());
	    		buroCliente.setPersona(integrante.getPersona().trim());
	    		//Obtenemos el folio de la consulta al buro
	    		String folioBuro = reporteCredito.getSegmentoFin().getNumeroControlConsulta();
	    		if (folioBuro.startsWith("0009")) {
	    			folioBuro = folioBuro.substring(LONGITUD_FOLIO_BURO);
	    		}
	    		buroCliente.setFolioConsultaBuro(folioBuro);
	    		integrantes.add(buroCliente);
			}

    		peticionRegistoBuro.setIntegrantes(integrantes);
    		//Almacenamos en BD la relacion entre solicitud, integrante y folio consulta buro en credprod_finsol.solicitud_buro
			SolicitudBuroRespuesta respuestaRegistroBuro
			 = solicitudesCredito.registrarSolicitudBuroTarea(uid, peticionRegistoBuro);
			//Verificamos que sea correcto el almacenado
			if (!respuestaRegistroBuro.getHeader().isEstatus()) {
				 throw new Exception(respuestaRegistroBuro.getHeader().getMensaje());
			}
			LogHandler.info(uid, getClass(), "validacionSolicitudBuro: registrarSolicitudBuroTarea correcta");

			//Verificamos si la solicitud es express
			if ( datosSolicitud.get(0).get("express").toString().trim().equals("S") ) {
				LogHandler.info(uid, getClass(), "validacionSolicitudBuro: EXPRESS");
				//Es una solicitud express
				//ConsultaSolicitudBuroRespuesta respuestaValidacion = validacionSolicitudExpress(uid, peticion);

				//RENOVACIONES EXPRESS MEJORA (nueva version)
				//La version en que ya se quitaron las reglas de buro segunda fase.
				ConsultaSolicitudBuroRespuesta respuestaValidacion = validacionSolicitudExpressMejora(uid, peticion);

				if (!respuestaValidacion.getHeader().isEstatus()) {
					respuesta.getHeader().setCodigo(respuestaValidacion.getHeader().getCodigo());
					 throw new Exception(respuestaValidacion.getHeader().getMensaje());
				}
				respuesta.setIncrementos(respuestaValidacion.getIncrementos());
			}
			else {
				//La solicitud NO es express
				ConsultaSolicitudBuroRespuesta respuestaValidacion = validacionIDSolicitudBuro(uid, peticion);

				if (!respuestaValidacion.getHeader().isEstatus()) {
					 throw new Exception(respuestaValidacion.getHeader().getMensaje());
				}

				String mensajeAprobacion = "CUMPLE REQUISITOS BURO";
				String mensajeRechazo = "RECHAZADO";

				boolean valdiacionIndividual = true;

				for ( SolicitudBuroClienteOV cliente : respuestaValidacion.getSolicitudesBuro().getIntegrantes()) {
					if (!cliente.getCausaRechazo().trim().isEmpty()) {
						valdiacionIndividual = false;
						respuesta.getHeader().setEstatus(false);
						respuesta.getHeader().setMensaje( respuesta.getHeader().getMensaje()
								+ "El integrante de la solicitud  ["  + cliente.getPersona() + "-"
								+ cliente.getNombreCompleto() + "] no cumple con las politicas, causa de rechazo ["
								+ cliente.getCausaRechazo() + "].");
					}
				}
				if ( valdiacionIndividual ) {
					if (respuestaValidacion.getSolicitudesBuro().getAprobacion().equals(mensajeAprobacion)) {
						respuesta.getHeader().setEstatus(true);
						respuesta.getHeader().setMensaje(mensajeAprobacion);
					} else if (respuestaValidacion.getSolicitudesBuro().getAprobacion().equals(mensajeRechazo)) {
						respuesta.getHeader().setEstatus(false);
						respuesta.getHeader().setMensaje(mensajeRechazo);
					}
				}
			}
		}
		catch (BncException exBuroSrv) {
			exBuroSrv.printStackTrace();
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje("Error en la llamada al servicio de buro [BncException]. "
					+ exBuroSrv.getRespuestaClave());
 	    }
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "validacionSolicitudBuro: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return respuesta;
	}


	/**
	 * @param uid identificador unico de la transaccion
	 * @param peticion para validar la solicitud
	 * @return ConsultaSolicitudBuroRespuesta resultado de la validacion de la solicitud
	 */
	@SuppressWarnings("unchecked")
	public ConsultaSolicitudBuroRespuesta validacionSolicitudExpress(String uid, ValidaSolicitudPeticion peticion) {
		ConsultaSolicitudBuroRespuesta respuesta = new ConsultaSolicitudBuroRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesion = null;
		SimpleDateFormat dtFormateador = new SimpleDateFormat("ddMMyyyy");

		try {
			LogHandler.info(uid, getClass(), "==> validacionSolicitudExpress - ENTRA");
			sesion = FabricaConexiones.obtenerSesionNTx();

			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put( "solicitud" , peticion.getSolicitud().trim());
			parametros.put( "status" , "A");
			//Se obtiene la consulta a solicitud_buro
			LogHandler.trace(uid, getClass(), "==> validacionSolicitudExpress - obtenerSolicitudBuro");
			List<SolicitudBuroClienteOV> solicitudes
				= (List<SolicitudBuroClienteOV>) sesion.selectList("obtenerSolicitudBuro", parametros);

			if (solicitudes.isEmpty()) {
				throw new Exception(ReadProperties.mensajes.getProp("solicitudes.consulta.solicitud.buro.inexistente"));
			}

			//Obtenemos datos de la solicitud
			List<HashMap<String, Object>> datosSolicitud
				= (List<HashMap<String, Object>>) sesion.selectList("obtieneExpressSolicitud", peticion.getSolicitud());

			if (datosSolicitud == null || datosSolicitud.isEmpty()) {
					throw new Exception("No fue posible obtener los datos de la solicitud.");
			}

			//Obtenemos url del servicio de par_general
			LogHandler.trace(uid, getClass(), "validacionSolicitudExpress: - obtenerParGeneral");
			ParGeneralOV urlBuro = comun.obtenerParGeneralOV(uid, "BURO_URL");
					//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "BURO_URL");
			if (urlBuro == null || urlBuro.getCgValor().trim().isEmpty()) {
					throw new Exception("No fue posible obtener la URL del servicio de buro.");
			}
			ServicioBuroCreditoProxy ws = new ServicioBuroCreditoProxy();
			ws.setEndpoint(urlBuro.getCgValor().trim());

			//Obtenemos valores para las reglas de validacion
			LogHandler.trace(uid, getClass(), "validacionSolicitudExpress: - obtenerParGeneral");
			ParGeneralOV mopHipotecario = comun.obtenerParGeneralOV(uid, "VABU_MOPHI");
					//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "VABU_MOPHI");

			LogHandler.trace(uid, getClass(), "validacionSolicitudExpress: - obtenerParGeneral");
			ParGeneralOV mopAutomotriz = comun.obtenerParGeneralOV(uid, "VABU_MOPAU");
					//(ParGeneralOV)	sesion.selectOne("obtenerParGeneral", "VABU_MOPAU");

			if ( mopHipotecario == null || mopHipotecario.getCgValor().trim().isEmpty()
				|| mopAutomotriz == null || mopAutomotriz.getCgValor().trim().isEmpty()) {
				throw new Exception("No fue posible obtener los parametros para la validacion de buro.");
			}

			List<RespuestaReglaIncremento> respuestaIncrementos = new ArrayList<RespuestaReglaIncremento>();

			int nuevosGrupo = 0;
			int antiguosGrupo = 0;
			for ( SolicitudBuroClienteOV integranteSolicitud : solicitudes) {

				ObtenerXMLReporteCreditoPorFolioRequest request = new ObtenerXMLReporteCreditoPorFolioRequest();
				ObtenerXMLReporteCreditoPorFolioResponse response = new ObtenerXMLReporteCreditoPorFolioResponse();
				request.setFolio(integranteSolicitud.getFolioConsultaBuro().trim());
				response = ws.obtenerXMLReporteCreditoPorFolio(request);

				if (response == null ||  response.getXMLReporteCredito() == null ||  response.getXMLReporteCredito().isEmpty()) {
					throw new Exception("No se pudo obtener la consulta Buro del cliente " + integranteSolicitud.getPersona()
							+ " " + integranteSolicitud.getNombreCompleto());
				}

				ReporteCredito reporteCredito = obtenerObjetoBCN(response.getXMLReporteCredito());

				//Obtenemos si el integrante es nuevo o antiguo en el grupo
				boolean antiguo = false;

				if (datosSolicitud.get(0).get("contratoAnterior").toString().trim().isEmpty()) {
					throw new Exception("La informacion de la solicitud es incorrecta no tiene contrato anterior.");
				}
				for ( int i = 0; i < datosSolicitud.size(); i++) {
				if (datosSolicitud.get(i).get("integrante").toString().trim().equals(integranteSolicitud.getPersona().trim())) {
						antiguo = true;
				 }
				}

				LogHandler.info(uid, getClass(), "validacionSolicitudExpress: - El integrante es antiguo [" + antiguo + "]");

				String mensajeError = "** El Cliente " + integranteSolicitud.getPersona() + "-"
						+ integranteSolicitud.getNombreCompleto() + " Presenta los siguientes casos: ";

				if ( antiguo ) {
					mensajeError += " [Antiguo] ";
					antiguosGrupo++;
					if (  reporteCredito.getCuentas() != null ) {
					for (  SegmentoCuenta cuenta : reporteCredito.getCuentas() ) {
						cuenta.setFormaPagoActual(cuenta.getFormaPagoActual() == null ? "" : cuenta.getFormaPagoActual());
						cuenta.setFormaPagoActual(cuenta.getFormaPagoActual().isEmpty() ? "00" : cuenta.getFormaPagoActual());
						cuenta.setFormaPagoActual(cuenta.getFormaPagoActual().equals("UR")
								? "00" : cuenta.getFormaPagoActual().trim());
						int mopCuenta = Integer.parseInt(cuenta.getFormaPagoActual());
						cuenta.setSaldoVencido(cuenta.getSaldoVencido() == null ? "" : cuenta.getSaldoVencido());
						cuenta.setSaldoVencido(cuenta.getSaldoVencido().isEmpty() ? "0" : cuenta.getSaldoVencido());
						cuenta.setSaldoVencido(cuenta.getSaldoVencido().trim().replace("+", "").replace("-", ""));

						double saldoVencido =  Double.parseDouble(cuenta.getSaldoVencido());
						//Cuenta con mop 99
						if ( mopCuenta == MOP_99) {
							//Validacion saldo vencido
							if (saldoVencido > MOP_99_SALDO_VENCIDO) {
								throw new Exception(mensajeError + " cuenta con mop 99 y saldo vencido [" + saldoVencido + "].");
							}
							BuroCreditoClienteGrupoPeticion peticionHistorial = new BuroCreditoClienteGrupoPeticion();
							peticionHistorial.setPersona(integranteSolicitud.getPersona());
							BuroCreditoClienteGrupoRespuesta respuestaHistorial
								= prGetDetalleHistoriaCTarea( uid, peticionHistorial);
							if (!respuestaHistorial.getHeader().isEstatus()) {
								 throw new Exception(respuestaHistorial.getHeader().getMensaje());
							}
							//Validacion al menos 2 ciclos
							if (respuestaHistorial.getGrupos().size() < 2) {
								throw new Exception(mensajeError + " cuenta con mop 99 y no tiene al menos 2 ciclos continuos.");
							}
							//Ultimo credito Fecha Liquidacion contra Fecha Fin Pactada
							if (respuestaHistorial.getGrupos().get(0).getDiasAtra() > 0 ) {
								throw new Exception(mensajeError
										+ " cuenta con mop 99 y el ultimo ciclo con mal historial, liquido con "
										+ respuestaHistorial.getGrupos().get(0).getDiasAtra()
										+ " dias de atraso despues de su fecha liquidacion pactada.");
							}
							//Penultimo credito Fecha Liquidacion contra Fecha Fin Pactada
							if (respuestaHistorial.getGrupos().get(1).getDiasAtra() > 0 ) {
								throw new Exception(mensajeError
										+ " cuenta con mop 99 y el penultimo ciclo con mal historial, liquido con "
										+ respuestaHistorial.getGrupos().get(1).getDiasAtra()
										+ " dias de atraso despues de su fecha liquidacion pactada.");
							}
							//Ultimo credito Dias Mora Acumulado
							if (respuestaHistorial.getGrupos().get(0).getDiasMoraAcumulados() > DIAS_MORA_ACUMULADOS ) {
								throw new Exception(mensajeError
										+ " cuenta con mop 99 y el ultimo ciclo con mal historial, tiene  "
										+ respuestaHistorial.getGrupos().get(0).getDiasMoraAcumulados()
										+ " dias mora acumulados.");
							}
							//Ultimo credito Dias Mora Acumulado
							if (respuestaHistorial.getGrupos().get(1).getDiasMoraAcumulados() > DIAS_MORA_ACUMULADOS ) {
								throw new Exception(mensajeError
										+ " cuenta con mop 99 y el ultimo ciclo con mal historial, tiene  "
										+ respuestaHistorial.getGrupos().get(1).getDiasMoraAcumulados()
										+ " dias mora acumulados.");
							}
						}
					}
					}
					//Cliente Antiguo correcto se procede a calcular su incremento
					//Todos los cliente son correctos
					PeticionReglaIncremento peticionReglaIncremento = new PeticionReglaIncremento();
					peticionReglaIncremento.setNumeroContrato(datosSolicitud.get(0).get("contratoAnterior").toString().trim());
					peticionReglaIncremento.setNumeroPersona(integranteSolicitud.getPersona().trim());
					RespuestaReglaIncremento respuestaReglaIncremento
						= solicitudesCredito.calculaIncrementoMontoTarea(uid, peticionReglaIncremento);
					//Validacion calculoIncremento
					if (!respuestaReglaIncremento.getHeader().isEstatus()) {
						 throw new Exception(respuestaReglaIncremento.getHeader().getMensaje());
					}
					//Agregar respuesta
					respuestaIncrementos.add(respuestaReglaIncremento);
				} else {
					//El cliente es nuevo en el grupo
					 //Barrido de cuentas TL
					mensajeError += " [Nuevo] ";
					nuevosGrupo++;
					if (  reporteCredito.getCuentas() != null ) {
					for (  SegmentoCuenta cuenta : reporteCredito.getCuentas() ) {
						cuenta.setFormaPagoActual(cuenta.getFormaPagoActual() == null ? "" : cuenta.getFormaPagoActual());
						cuenta.setFormaPagoActual(cuenta.getFormaPagoActual().isEmpty() ? "00" : cuenta.getFormaPagoActual());
						cuenta.setFormaPagoActual(cuenta.getFormaPagoActual().equals("UR")
								? "00" : cuenta.getFormaPagoActual().trim());
						cuenta.setClaveObservacion(cuenta.getClaveObservacion() == null ? "" : cuenta.getClaveObservacion());
						int mopCuenta = Integer.parseInt(cuenta.getFormaPagoActual());

						//Validacion clave de Observacion
						if ( cuenta.getClaveObservacion().equals("FD")
							|| cuenta.getClaveObservacion().equals("SG")
							|| cuenta.getClaveObservacion().equals("IM")
							|| cuenta.getClaveObservacion().equals("LO")
							|| cuenta.getClaveObservacion().equals("FR")) {
							throw new Exception(mensajeError + " Clave de Observacion [" + cuenta.getClaveObservacion() + "].");
						}
						//Validacion mop 99
						if ( mopCuenta == MOP_99 ) {
							throw new Exception(mensajeError + " Cuenta con mop 99.");
						}
						//Validacion cuentas Hipotercario y Bienes Raices
						if ( cuenta.getTipoCuenta().trim().equals("M") || cuenta.getTipoContrato().trim().equals("RE")
								|| cuenta.getNombreOrtogante().trim().equals("BIENES RAICES")) {
							if ( mopCuenta >  Integer.parseInt(mopHipotecario.getCgValor())) {
								throw new Exception(mensajeError + " Cuenta Hipotecario o Bienes Racices con mop ["
											+ mopCuenta + "] mayor a "
											+ mopHipotecario.getCgValor() + ".");
							}
						}
						//Validacion cuentas Automotriz
						if (cuenta.getTipoContrato().trim().equals("AU")
							|| cuenta.getNombreOrtogante().trim().equals("AUTOMOTRIZ") ) {
							if ( mopCuenta >  Integer.parseInt(mopAutomotriz.getCgValor())) {
								throw new Exception(mensajeError + " Cuenta Automotriz con mop ["
											+ mopCuenta + "] mayor a "
										    + mopAutomotriz.getCgValor() + ".");
							}
						}
						//Validacion mop cuentas
						if (mopCuenta == MOP_4 || mopCuenta == MOP_5 || mopCuenta == MOP_6 || mopCuenta == MOP_7) {
							throw new Exception(mensajeError + " Cuenta con mop " + mopCuenta);
						}
						//Validacion mop cuentas 96 y 07
						if (mopCuenta == MOP_96 || mopCuenta == MOP_97) {
							boolean aprobacion = false;
							if (  reporteCredito.getCuentas() != null ) {
								for (  SegmentoCuenta cuentaAux : reporteCredito.getCuentas() ) {
									if (cuentaAux.getFormaPagoActual().trim().equals("01")) {
										Date fechaApertura = dtFormateador.parse(cuenta.getFechaAperturaCuenta());
										if ( diferenciaEnDias(new Date(), fechaApertura) >= Constantes.DIAS_ANIO) {
											aprobacion = true;
										}
									}
								}
							}
							if (!aprobacion) {
								throw new Exception(mensajeError + " Cuenta con mop " + mopCuenta
										+ ", sin tener cuenta al corriente en el perido de un a�o.");
							}
                        }
					}
					}
				} //fin nuevos

			}
			LogHandler.info(uid, getClass(), "validacionSolicitudExpress: - antiguos[" + antiguosGrupo + "] - nuevos["
			+ nuevosGrupo  + "] - total[" + solicitudes.size() + "]");
			//Validacion antiguos - nuevos

			if ( antiguosGrupo < (solicitudes.size()  * PCT_RENUEVA)) {
				throw new Exception("El n�mero de Clientes que renuevan no puede ser menor al 50%");
			}
			if (nuevosGrupo > (solicitudes.size() * PCT_NUEVOS)) {
				throw new Exception("El n�mero de Clientes nuevos no puede ser mayor al 30%");
            }

			respuesta.setIncrementos(respuestaIncrementos);

		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "validacionSolicitudExpress: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sesion);
		}
		return respuesta;
	}

	/**
	 * Metodo para validacion de solicitudes express
	 * @param uid identificador unico
	 * @param peticion para validacion de solicitud
	 * @return resultado de la validacion de la solicitud
	 */
	@SuppressWarnings("unchecked")
	public ConsultaSolicitudBuroRespuesta validacionSolicitudExpressMejora(String uid, ValidaSolicitudPeticion peticion) {
		ConsultaSolicitudBuroRespuesta respuesta = new ConsultaSolicitudBuroRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setCodigo("0");
		SqlSession sesion = null;

		try {
			LogHandler.info(uid, getClass(), "==> validacionSolicitudExpress - ENTRA");
			sesion = FabricaConexiones.obtenerSesionNTx();

			//Obtenemos datos de la solicitud
			List<HashMap<String, Object>> datosSolicitud
				= (List<HashMap<String, Object>>) sesion.selectList("obtieneExpressSolicitud", peticion.getSolicitud());

			if (datosSolicitud == null || datosSolicitud.isEmpty()) {
					throw new Exception("No fue posible obtener los datos de la solicitud.");
			}

			//Obtenemos valores para las reglas de validacion
			LogHandler.trace(uid, getClass(), "validacionSolicitudExpress: - obtenerParGeneral");
			ParGeneralOV pctAntiguos = comun.obtenerParGeneralOV(uid, "RE_PCTANTI");
					//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "RE_PCTANTI");

			LogHandler.trace(uid, getClass(), "validacionSolicitudExpress: - obtenerParGeneral");
			ParGeneralOV pctNuevos = comun.obtenerParGeneralOV(uid, "RE_PCTNUEV");
					//(ParGeneralOV)	sesion.selectOne("obtenerParGeneral", "RE_PCTNUEV");

			if ( pctAntiguos == null || pctAntiguos.getCgValor().trim().isEmpty()
				|| pctNuevos == null || pctNuevos.getCgValor().trim().isEmpty()) {
				throw new Exception("No fue posible obtener los parametros para validacion grupal RE_PCTANTI,RE_PCTNUEV.");
			}

			int nuevosGrupo = 0;
			int antiguosGrupo = 0;
			double pctAntiguosMinimo = Double.parseDouble(pctAntiguos.getCgValor().trim()) / Constantes.CENTENA_DOUBLE;
			double pctNuevosMaximo = Double.parseDouble(pctNuevos.getCgValor().trim()) / Constantes.CENTENA_DOUBLE;

			for ( IntegranteSolicitud integranteSolicitud : peticion.getIntegrantes()) {

				//Obtenemos si el integrante es nuevo o antiguo en el grupo
				boolean antiguo = false;

				if (datosSolicitud.get(0).get("contratoAnterior").toString().trim().isEmpty()) {
					throw new Exception("La informacion de la solicitud es incorrecta no tiene contrato anterior.");
				}
				for ( int i = 0; i < datosSolicitud.size(); i++) {
				if (datosSolicitud.get(i).get("integrante").toString().trim().equals(integranteSolicitud.getPersona().trim())) {
						antiguo = true;
				 }
				}

				if ( antiguo ) {
					antiguosGrupo++;
				} else {
					nuevosGrupo++;
				} //fin nuevos
			}

			LogHandler.info(uid, getClass(), "validacionSolicitudExpress: - antiguos[" + antiguosGrupo + "] - nuevos["
			+ nuevosGrupo  + "] - total[" + peticion.getIntegrantes().size() + "]");
			//Validacion antiguos - nuevos

			if ( antiguosGrupo < (peticion.getIntegrantes().size()  * pctAntiguosMinimo)) {
				respuesta.getHeader().setCodigo("1");
				throw new Exception("El número de Clientes que renuevan no puede ser menor al "
						+ pctAntiguos.getCgValor().trim() + "%");
			}
			if (nuevosGrupo > (peticion.getIntegrantes().size() * pctNuevosMaximo)) {
				respuesta.getHeader().setCodigo("1");
				throw new Exception("El número de Clientes nuevos no puede ser mayor al " + pctNuevos.getCgValor().trim() + "%");
            }

		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "validacionSolicitudExpress: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sesion);
		}
		return respuesta;
	}

	/**
	 * @param uid Identificador de Transaccion
	 * @param peticion de consulta
	 * @return ConsultaBuroRespuesta
	 */
	@SuppressWarnings("unchecked")
	public ConsultaSolicitudBuroRespuesta validacionIDSolicitudBuro(String uid, ValidaSolicitudPeticion peticion) {
		ConsultaSolicitudBuroRespuesta respuesta = new ConsultaSolicitudBuroRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		String mensajeAprobacion = "CUMPLE REQUISITOS BURO";
		String mensajeRechazo = "RECHAZADO";
		SqlSession sesion = null;

		try {
			if (peticion == null || peticion.getSolicitud() == null
					|| peticion.getSolicitud().trim().isEmpty()) {
				throw new Exception("El ID de la solicitud en la peticion es necesaria.");
			}

			SolicitudBuroOV peticionEncabezado = new SolicitudBuroOV();
			peticionEncabezado.setSolicitud(peticion.getSolicitud().trim());
			EncabezadoSolicitudRespuesta respuestaEncabezado
				= solicitudesCredito.obtenerDatosSolicitudEncabezadoTarea(uid, peticionEncabezado);
			if (!respuestaEncabezado.getHeader().isEstatus()) {
				 throw new Exception(respuestaEncabezado.getHeader().getMensaje());
			}

			SolicitudBuroOV solicitudEncabezado = new SolicitudBuroOV();
			solicitudEncabezado.setSolicitud(peticion.getSolicitud());
			solicitudEncabezado.setCiclo(respuestaEncabezado.getSolicitudEncabezado().getCiclo());
			solicitudEncabezado.setNombreSucursal(respuestaEncabezado.getSolicitudEncabezado().getNombreSucursal().trim());
			solicitudEncabezado.setNombre(respuestaEncabezado.getSolicitudEncabezado().getNombre());
			solicitudEncabezado.setValorTipificacion(respuestaEncabezado.getSolicitudEncabezado().getValorTipificacion());
			solicitudEncabezado.setTipificacionSucursal(respuestaEncabezado.getSolicitudEncabezado().getTipificacionSucursal());
			solicitudEncabezado.setEstatus(respuestaEncabezado.getSolicitudEncabezado().getEstatus());
			solicitudEncabezado.setMotivoCancelacion(respuestaEncabezado.getSolicitudEncabezado().getMotivoCancelacion());
			LogHandler.info(uid, getClass(), "validacionIDSolicitudBuro: respuestaFolioBuro correcta");

			sesion = FabricaConexiones.obtenerSesionNTx();

			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put( "solicitud" , peticion.getSolicitud().trim());
			parametros.put( "status" , "A");
			//Se obtiene la consulta a solicitud_buro
			LogHandler.trace(uid, getClass(), "==> validacionIDSolicitudBuro - obtenerSolicitudBuro");
			List<SolicitudBuroClienteOV> solicitudes
				= (List<SolicitudBuroClienteOV>) sesion.selectList("obtenerSolicitudBuro", parametros);

			if (solicitudes.isEmpty()) {
				throw new Exception(ReadProperties.mensajes.getProp("solicitudes.consulta.solicitud.buro.inexistente"));
			}

			LogHandler.trace(uid, getClass(), "validacionIDSolicitudBuro: - obtenerParGeneral");
			ParGeneralOV urlBuro = comun.obtenerParGeneralOV(uid, "BURO_URL");
					//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "BURO_URL");
			if (urlBuro == null || urlBuro.getCgValor().trim().isEmpty()) {
					throw new Exception("No fue posible obtener la URL del servicio de buro.");
			}
			ServicioBuroCreditoProxy ws = new ServicioBuroCreditoProxy();
			ws.setEndpoint(urlBuro.getCgValor().trim());

			//Obtenemos valores para las reglas de validacion
			LogHandler.trace(uid, getClass(), "validacionIDSolicitudBuro: - obtenerParGeneral");
			ParGeneralOV porcentajeAprobacionMedio = comun.obtenerParGeneralOV(uid, "VABU_POAME");
					//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "VABU_POAME");

			LogHandler.trace(uid, getClass(), "validacionIDSolicitudBuro: - obtenerParGeneral");
			ParGeneralOV porcentajeAprobacionAlto = comun.obtenerParGeneralOV(uid, "VABU_POAAL");
					//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "VABU_POAAL");

			LogHandler.trace(uid, getClass(), "validacionIDSolicitudBuro: - obtenerParGeneral");
			ParGeneralOV promedioEdad = comun.obtenerParGeneralOV(uid, "VABU_PEDAD");
					//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "VABU_PEDAD");

			LogHandler.trace(uid, getClass(), "validacionIDSolicitudBuro: - obtenerParGeneral");
			ParGeneralOV mopHipotecario = comun.obtenerParGeneralOV(uid, "VABU_MOPHI");
					//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "VABU_MOPHI");

			LogHandler.trace(uid, getClass(), "validacionIDSolicitudBuro: - obtenerParGeneral");
			ParGeneralOV mopAutomotriz = comun.obtenerParGeneralOV(uid, "VABU_MOPAU");
					//(ParGeneralOV)	sesion.selectOne("obtenerParGeneral", "VABU_MOPAU");

			if (porcentajeAprobacionMedio == null || porcentajeAprobacionMedio.getCgValor().trim().isEmpty()
				|| porcentajeAprobacionAlto == null || porcentajeAprobacionAlto.getCgValor().trim().isEmpty()
				|| promedioEdad == null || promedioEdad.getCgValor().trim().isEmpty()
				|| mopHipotecario == null || mopHipotecario.getCgValor().trim().isEmpty()
				|| mopAutomotriz == null || mopAutomotriz.getCgValor().trim().isEmpty()) {
				throw new Exception("No fue posible obtener los parametros para la validacion de buro.");
			}

			for ( SolicitudBuroClienteOV integranteSolicitud : solicitudes) {

				ObtenerXMLReporteCreditoPorFolioRequest request = new ObtenerXMLReporteCreditoPorFolioRequest();
				ObtenerXMLReporteCreditoPorFolioResponse response = new ObtenerXMLReporteCreditoPorFolioResponse();
				request.setFolio(integranteSolicitud.getFolioConsultaBuro().trim());
				response = ws.obtenerXMLReporteCreditoPorFolio(request);

				if (response == null ||  response.getXMLReporteCredito() == null ||  response.getXMLReporteCredito().isEmpty()) {
					throw new Exception("No se pudo obtener la consulta Buro del cliente " + integranteSolicitud.getPersona()
							+ " " + integranteSolicitud.getNombreCompleto());
				}

				ReporteCredito reporteCredito = obtenerObjetoBCN(response.getXMLReporteCredito());
				LogHandler.info(uid, getClass(), "obtenerDatosValidacion - " + integranteSolicitud.getPersona());
				ValidaBuroDTO respuestaValidaBuro = obtenerDatosValidacion(reporteCredito);
				integranteSolicitud.setCuentas(respuestaValidaBuro);
			}
			//Totales y reglas
			int sumaEdad = 0;
			int clientesActivos = 0;
			String rol = "";
			String contratoAnterior = "";
			for ( SolicitudBuroClienteOV integranteSolicitud : solicitudes) {
				if (!descartarIntegrante(integranteSolicitud.getPersona().trim(), peticion.getIntegrantesDescarte())) {
					solicitudEncabezado.setTotalMOP01(solicitudEncabezado.getTotalMOP01()
							+ integranteSolicitud.getCuentas().getMop01().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalMOP02(solicitudEncabezado.getTotalMOP02()
							+ integranteSolicitud.getCuentas().getMop02().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalMOP03(solicitudEncabezado.getTotalMOP03()
							+ integranteSolicitud.getCuentas().getMop03().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalMOP04(solicitudEncabezado.getTotalMOP04()
							+ integranteSolicitud.getCuentas().getMop04().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalMOP05(solicitudEncabezado.getTotalMOP05()
							+ integranteSolicitud.getCuentas().getMop05().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalMOP06(solicitudEncabezado.getTotalMOP06()
							+ integranteSolicitud.getCuentas().getMop06().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalMOP07(solicitudEncabezado.getTotalMOP07()
							+ integranteSolicitud.getCuentas().getMop07().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalMOP96(solicitudEncabezado.getTotalMOP96()
							+ integranteSolicitud.getCuentas().getMop96().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalMOP97(solicitudEncabezado.getTotalMOP97()
							+ integranteSolicitud.getCuentas().getMop97().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalMOP99(solicitudEncabezado.getTotalMOP99()
							+ integranteSolicitud.getCuentas().getMop99().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalMOPUR(solicitudEncabezado.getTotalMOPUR()
							+ integranteSolicitud.getCuentas().getMopUR().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalCuentas(solicitudEncabezado.getTotalCuentas()
							+ integranteSolicitud.getCuentas().getTotal().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalDesde03(solicitudEncabezado.getTotalDesde03()
							+ integranteSolicitud.getCuentas().getTotalDesde03());
					solicitudEncabezado.setTotalDesde04(solicitudEncabezado.getTotalDesde04()
							+ integranteSolicitud.getCuentas().getTotalDesde04());
					sumaEdad += integranteSolicitud.getEdad();
					rol += integranteSolicitud.getRol();
					contratoAnterior += integranteSolicitud.getContratoAnterior();
					clientesActivos++;

		             // claves observacion
		             integranteSolicitud.setClaveObservacion(integranteSolicitud.getCuentas().getClavesObserv());

					if (!solicitudEncabezado.getValorTipificacion().trim().equals("NRBA")) {
			             if (integranteSolicitud.getCuentas().isHipotecario()) {
			            	 if (integranteSolicitud.getCuentas().getHipMop() > Integer.parseInt(mopHipotecario.getCgValor())) {
			            		 integranteSolicitud.setCausaRechazo("Hipotecario con Mop "
			            				 + integranteSolicitud.getCuentas().getHipMop() + " - "
			            				 + integranteSolicitud.getCuentas().getHipDescripcion());
			            	 }
			             }
			             if (integranteSolicitud.getCuentas().isAutomotriz()) {
			            	 if (integranteSolicitud.getCuentas().getAutoMop() > Integer.parseInt(mopAutomotriz.getCgValor())) {
			            		 integranteSolicitud.setCausaRechazo("Automotriz con Mop "
			            				 + integranteSolicitud.getCuentas().getAutoMop() + " - "
			            				 + integranteSolicitud.getCuentas().getAutoDescripcion());
			            	 }
			             }
			        }
				} else {
					integranteSolicitud.setDescartado("X");
					integranteSolicitud.getCuentas().getTotal().setNumeroCuentasAbiertas(0);
					integranteSolicitud.getCuentas().setTotalDesde03(0);
					integranteSolicitud.getCuentas().setTotalDesde04(0);
					integranteSolicitud.setCausaRechazo(" ");
				}
			}

			if (clientesActivos > 0) {
				solicitudEncabezado.setPromedioEdad( sumaEdad / clientesActivos );
			} else {
				solicitudEncabezado.setPromedioEdad(0);
			}

			Float factorDesde03 = 0f;
			Float factorDesde04 = 0f;
			Double dfactorDesde03 = 0d;
			Double dfactorDesde04 = 0d;

			float totalDesde03 = solicitudEncabezado.getTotalDesde03();
			float totalDesde04 = solicitudEncabezado.getTotalDesde04();
			float totalCuentas = solicitudEncabezado.getTotalCuentas();
			if (solicitudEncabezado.getTotalCuentas() > 0) {
				factorDesde03 =  ( totalDesde03 / totalCuentas) * Constantes.CENTENA;
				dfactorDesde03 = redondeo(new Double(factorDesde03));
				factorDesde04 = ( totalDesde04 / totalCuentas) * Constantes.CENTENA;
				dfactorDesde04 = redondeo(new Double(factorDesde04));

			}

			solicitudEncabezado.setFactorDesde03(dfactorDesde03);
			solicitudEncabezado.setFactorDesde04(dfactorDesde04);
			solicitudEncabezado.setIntegrantes(solicitudes);
			solicitudEncabezado.setLeyendaNivelMedio("MOP>=4 no exceda " + porcentajeAprobacionMedio.getCgValor()
					+ "% total de cuentas. Si excede promedio de edad > " + promedioEdad.getCgValor() + " años.");
			solicitudEncabezado.setLeyendaNivelAlto("MOP>=3 no exceda " + porcentajeAprobacionAlto.getCgValor()
					+ "% total de cuentas.");
			Integer iPromedioEdad = Integer.parseInt(promedioEdad.getCgValor());
			Double dPorcetajeAprobacionMedio = Double.parseDouble(porcentajeAprobacionMedio.getCgValor());
			Double dPorcetajeAprobacionAlto = Double.parseDouble(porcentajeAprobacionAlto.getCgValor());
			//Reglas de negocio para conocer el resultado final.
            String resultadoAprobacion = "";
            //Tipificacion Bajo
            LogHandler.info(uid, getClass(), "==> tipificacion -> " +  solicitudEncabezado.getValorTipificacion());
            LogHandler.info(uid, getClass(), "==> factorDesde04 -> " +  factorDesde04);
            LogHandler.info(uid, getClass(), "==> factorDesde03 -> " +  factorDesde03);
            LogHandler.info(uid, getClass(), "==> dPorcetajeAprobacionMedio -> " +  dPorcetajeAprobacionMedio);
            LogHandler.info(uid, getClass(), "==> dPorcetajeAprobacionAlto -> " +  dPorcetajeAprobacionAlto);
            if (solicitudEncabezado.getValorTipificacion().trim().equals("NRBA"))
            {
                resultadoAprobacion = mensajeAprobacion;
            }
            //Tipificacion Medio
            else if (solicitudEncabezado.getValorTipificacion().trim().equals("NRME"))
            {
                if (factorDesde04.doubleValue() <= dPorcetajeAprobacionMedio ) {
                    resultadoAprobacion = mensajeAprobacion;
                }
                else if ((factorDesde04.doubleValue() > dPorcetajeAprobacionMedio)
                		&& (solicitudEncabezado.getPromedioEdad() >  iPromedioEdad) ) {
                    resultadoAprobacion = mensajeAprobacion;
                }
                else {
                    resultadoAprobacion = mensajeRechazo;
                }

            }
            //Tipificacion Alto y Muy Alto
            else  {
                if (factorDesde03.doubleValue() <= dPorcetajeAprobacionAlto) {
                    resultadoAprobacion = mensajeAprobacion;
                }
                else {
                    resultadoAprobacion = mensajeRechazo;
                }
            }
            solicitudEncabezado.setAprobacion(resultadoAprobacion);

            SolicitudBuroGeneralOV peticionResultadoFinal = new SolicitudBuroGeneralOV();
            peticionResultadoFinal.setSolicitud(peticion.getSolicitud().trim());
            peticionResultadoFinal.setValorTipificacion(solicitudEncabezado.getValorTipificacion().trim());
            peticionResultadoFinal.setPromedioEdad(solicitudEncabezado.getPromedioEdad());
            peticionResultadoFinal.setPorcentajeCuentas1(dfactorDesde03);
            peticionResultadoFinal.setPorcentajeCuentas2(dfactorDesde04);
            peticionResultadoFinal.setResultado(resultadoAprobacion);
            SolicitudesRespuesta respuestaResultadoFinal
            	= solicitudesCredito.registrarSolicitudBuroGeneral(uid, peticionResultadoFinal);

            if (!respuestaResultadoFinal.getHeader().isEstatus()) {
				 throw new Exception(respuestaResultadoFinal.getHeader().getMensaje());
			}

			respuesta.setSolicitudesBuro(solicitudEncabezado);
		}
		catch (BncException exBuroSrv) {
			exBuroSrv.printStackTrace();
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje("Error en la llamada al servicio de buro [BncException]. "
					+ exBuroSrv.getRespuestaClave());
 	    }
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "validacionIDSolicitudBuro: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}
		return respuesta;
	}

//*******COMUNES

	/**
	 * @param xml de entrada
	 * @param tag tag a buscar
	 * @return valor tag
	 */
	public String obtenerValorTag(String xml, String tag) {
		String value = "";
		String tagBuscar = "<" + tag + ">";
		String tagFinBuscar = "</" + tag + ">";
		value = xml.substring(xml.indexOf(tagBuscar) + tagBuscar.length(), xml.indexOf(tagFinBuscar));
		return value;
	}
	/**
	 * @param xml Reporte Buro Credito
	 * @return Objeto
	 * @throws Exception
	 */
	public ReporteCredito obtenerObjetoBCN(String xml) throws Exception {
		ReporteCredito reporteCredito = null;
		try {
			reporteCredito = new ReporteCredito();
			XStream xstream = new XStream(new DomDriver());
			xstream.alias("ReporteCredito", ReporteCredito.class);
			xstream.alias("SegmentoConsulta", SegmentoConsulta.class);
			xstream.alias("SegmentoCuenta", SegmentoCuenta.class);
			xstream.alias("SegmentoDireccion", SegmentoDireccion.class);
			xstream.alias("SegmentoEmpleo", SegmentoEmpleo.class);
			xstream.alias("SegmentoEncabezado", SegmentoEncabezado.class);
			xstream.alias("SegmentoFin", SegmentoFin.class);
			xstream.alias("SegmentoNombre", SegmentoNombre.class);
			xstream.alias("SegmentoScore", SegmentoScore.class);
			xstream.alias("SegmentoResumenReporte", SegmentoResumenReporte.class);
			reporteCredito = (ReporteCredito) xstream.fromXML(xml);

		}
		catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
		return reporteCredito;
	}
	/**
		 * @param reporteCredito reporte del buro
		 * @return ValidaBuroDTO
		 * @throws ParseException
	 */
	public  ValidaBuroDTO obtenerDatosValidacion( ReporteCredito reporteCredito ) throws ParseException {

		DecimalFormat formateador = new DecimalFormat("$###,###,###.##");
        SimpleDateFormat dtFormateador = new SimpleDateFormat("ddMMyyyy");
        SimpleDateFormat dtFormateadorString = new SimpleDateFormat("dd/MM/yyyy");

		ValidaBuroDTO  buro = new ValidaBuroDTO();
		boolean hipotecario = false;
        int hipMop = 0;
        double hipSaldoVencido = 0;
        boolean automotriz = false;
        int autoMop = 0;
        double autoSaldoVencido = 0;
        String clavesObserv = "";

        double maximo00 = 0;
        double maximo01 = 0;
        double maximo02 = 0;
        double maximo03 = 0;
        double maximo04 = 0;
        double maximo05 = 0;
        double maximo06 = 0;
        double maximo07 = 0;
        double maximo96 = 0;
        double maximo97 = 0;
        double maximo99 = 0;
        double maximoTodas = 0;
        Date fechaMaxima00 = dtFormateador.parse("01011900");
        Date fechaMaxima01 = dtFormateador.parse("01011900");
        Date fechaMaxima02 = dtFormateador.parse("01011900");
        Date fechaMaxima03 = dtFormateador.parse("01011900");
        Date fechaMaxima04 = dtFormateador.parse("01011900");
        Date fechaMaxima05 = dtFormateador.parse("01011900");
        Date fechaMaxima06 = dtFormateador.parse("01011900");
        Date fechaMaxima07 = dtFormateador.parse("01011900");
        Date fechaMaxima96 = dtFormateador.parse("01011900");
        Date fechaMaxima97 = dtFormateador.parse("01011900");
        Date fechaMaxima99 = dtFormateador.parse("01011900");
        Date fechaMaximaTodas = dtFormateador.parse("01011900");

        //Barrido de cuentas TL
        if (  reporteCredito.getCuentas() != null ) {
		for (  SegmentoCuenta cuenta : reporteCredito.getCuentas() ) {
			//Formato cuentas
			cuenta.setFechaCierreCuenta(cuenta.getFechaCierreCuenta() == null ? "" : cuenta.getFechaCierreCuenta());
			cuenta.setFormaPagoActual(cuenta.getFormaPagoActual() == null ? "" : cuenta.getFormaPagoActual());
			cuenta.setFormaPagoActual(cuenta.getFormaPagoActual().isEmpty() ? "0" : cuenta.getFormaPagoActual());
			cuenta.setFormaPagoActual(cuenta.getFormaPagoActual().trim());
			cuenta.setFormaPagoActual(cuenta.getFormaPagoActual().equals("UR")
					? "00" : cuenta.getFormaPagoActual().trim());
			cuenta.setSaldoVencido(cuenta.getSaldoVencido() == null ? "" : cuenta.getSaldoVencido());
			cuenta.setSaldoVencido(cuenta.getSaldoVencido().isEmpty() ? "0" : cuenta.getSaldoVencido());
			cuenta.setSaldoVencido(cuenta.getSaldoVencido().trim().replace("+", "").replace("-", ""));
			cuenta.setSaldoActual(cuenta.getSaldoActual() == null ? "0" : cuenta.getSaldoActual());
	    	cuenta.setSaldoActual(cuenta.getSaldoActual().isEmpty() ? "0" : cuenta.getSaldoActual());
	    	cuenta.setSaldoActual(cuenta.getSaldoActual().replace("+", "").replace("-", ""));
	    	cuenta.setCreditoMaximo(cuenta.getCreditoMaximo() == null ? "0" : cuenta.getCreditoMaximo());
	    	cuenta.setCreditoMaximo(cuenta.getCreditoMaximo().isEmpty() ? "0" : cuenta.getCreditoMaximo());
	    	cuenta.setCreditoMaximo(cuenta.getCreditoMaximo().replace("+", "").replace("-", ""));
	    	cuenta.setNombreOrtogante(cuenta.getNombreOrtogante() == null ? "" : cuenta.getNombreOrtogante());
	    	Date fechaApertura = dtFormateador.parse(cuenta.getFechaAperturaCuenta());

	    	cuenta.setClaveObservacion(cuenta.getClaveObservacion() == null ? "" : cuenta.getClaveObservacion());

			double saldoVencido =  Double.parseDouble(cuenta.getSaldoVencido());
			double saldoActual =  Double.parseDouble(cuenta.getSaldoActual());
			double maximoCuenta = Double.parseDouble(cuenta.getCreditoMaximo());
			//Obtencion de cuentas agrupando por MOP
			if ( cuenta.getFormaPagoActual().equals("00")) {
				if (cuenta.getFechaCierreCuenta().isEmpty()) {
					buro.getMopUR().setNumeroCuentasAbiertas(buro.getMopUR().getNumeroCuentasAbiertas() + 1);
					buro.getMopUR().setSaldoVencidoAbiertas(buro.getMopUR().getSaldoVencidoAbiertas() + saldoVencido);
					buro.getMopUR().setSaldoActual(buro.getMopUR().getSaldoActual() + saldoActual);
					if ( maximoCuenta > maximo00) {
						maximo00 = maximoCuenta;
					}
					buro.getMopUR().setMaximoAbiertas(maximo00);
					if (fechaApertura.compareTo(fechaMaxima00) > 0) {
						fechaMaxima00 = fechaApertura;
			        }
					buro.getMopUR().setFechaApertura(dtFormateadorString.format(fechaMaxima00));
				}
			} else if ( cuenta.getFormaPagoActual().equals("01")) {
				if (cuenta.getFechaCierreCuenta().isEmpty()) {
					buro.getMop01().setNumeroCuentasAbiertas(buro.getMop01().getNumeroCuentasAbiertas() + 1);
					buro.getMop01().setSaldoVencidoAbiertas(buro.getMop01().getSaldoVencidoAbiertas() + saldoVencido);
					buro.getMop01().setSaldoActual(buro.getMop01().getSaldoActual() + saldoActual);
					if ( maximoCuenta > maximo01) {
						maximo01 = maximoCuenta;
					}
					buro.getMop01().setMaximoAbiertas(maximo01);
					if (fechaApertura.compareTo(fechaMaxima01) > 0) {
						fechaMaxima01 = fechaApertura;
			        }
					buro.getMop01().setFechaApertura(dtFormateadorString.format(fechaMaxima01));
				}
			} else if ( cuenta.getFormaPagoActual().equals("02")) {
				if (cuenta.getFechaCierreCuenta().isEmpty()) {
					buro.getMop02().setNumeroCuentasAbiertas(buro.getMop02().getNumeroCuentasAbiertas() + 1);
					buro.getMop02().setSaldoVencidoAbiertas(buro.getMop02().getSaldoVencidoAbiertas() + saldoVencido);
					buro.getMop02().setSaldoActual(buro.getMop02().getSaldoActual() + saldoActual);
					if ( maximoCuenta > maximo02) {
						maximo02 = maximoCuenta;
					}
					buro.getMop02().setMaximoAbiertas(maximo02);
					if (fechaApertura.compareTo(fechaMaxima02) > 0) {
						fechaMaxima02 = fechaApertura;
			        }
					buro.getMop02().setFechaApertura(dtFormateadorString.format(fechaMaxima02));
				}
			} else if ( cuenta.getFormaPagoActual().equals("03")) {
				if (cuenta.getFechaCierreCuenta().isEmpty()) {
					buro.getMop03().setNumeroCuentasAbiertas(buro.getMop03().getNumeroCuentasAbiertas() + 1);
					buro.getMop03().setSaldoVencidoAbiertas(buro.getMop03().getSaldoVencidoAbiertas() + saldoVencido);
					buro.getMop03().setSaldoActual(buro.getMop03().getSaldoActual() + saldoActual);
					buro.setTotalDesde03(buro.getTotalDesde03() + 1);
					if ( maximoCuenta > maximo03) {
						maximo03 = maximoCuenta;
					}
					buro.getMop03().setMaximoAbiertas(maximo03);
					if (fechaApertura.compareTo(fechaMaxima03) > 0) {
						fechaMaxima03 = fechaApertura;
			        }
					buro.getMop03().setFechaApertura(dtFormateadorString.format(fechaMaxima03));
				}
			} else if ( cuenta.getFormaPagoActual().equals("04")) {
				if (cuenta.getFechaCierreCuenta().isEmpty()) {
					buro.getMop04().setNumeroCuentasAbiertas(buro.getMop04().getNumeroCuentasAbiertas() + 1);
					buro.getMop04().setSaldoVencidoAbiertas(buro.getMop04().getSaldoVencidoAbiertas() + saldoVencido);
					buro.getMop04().setSaldoActual(buro.getMop04().getSaldoActual() + saldoActual);
					buro.setTotalDesde03(buro.getTotalDesde03() + 1);
					buro.setTotalDesde04(buro.getTotalDesde04() + 1);
					if ( maximoCuenta > maximo04) {
						maximo04 = maximoCuenta;
					}
					buro.getMop04().setMaximoAbiertas(maximo04);
					if (fechaApertura.compareTo(fechaMaxima04) > 0) {
						fechaMaxima04 = fechaApertura;
			        }
					buro.getMop04().setFechaApertura(dtFormateadorString.format(fechaMaxima04));
				}
			} else if ( cuenta.getFormaPagoActual().equals("05")) {
				if (cuenta.getFechaCierreCuenta().isEmpty()) {
					buro.getMop05().setNumeroCuentasAbiertas(buro.getMop05().getNumeroCuentasAbiertas() + 1);
					buro.getMop05().setSaldoVencidoAbiertas(buro.getMop05().getSaldoVencidoAbiertas() + saldoVencido);
					buro.getMop05().setSaldoActual(buro.getMop05().getSaldoActual() + saldoActual);
					buro.setTotalDesde03(buro.getTotalDesde03() + 1);
					buro.setTotalDesde04(buro.getTotalDesde04() + 1);
					if ( maximoCuenta > maximo05) {
						maximo05 = maximoCuenta;
					}
					buro.getMop05().setMaximoAbiertas(maximo05);
					if (fechaApertura.compareTo(fechaMaxima05) > 0) {
						fechaMaxima05 = fechaApertura;
			        }
					buro.getMop05().setFechaApertura(dtFormateadorString.format(fechaMaxima05));
				}
			} else if ( cuenta.getFormaPagoActual().equals("06")) {
				if (cuenta.getFechaCierreCuenta().isEmpty()) {
					buro.getMop06().setNumeroCuentasAbiertas(buro.getMop06().getNumeroCuentasAbiertas() + 1);
					buro.getMop06().setSaldoVencidoAbiertas(buro.getMop06().getSaldoVencidoAbiertas() + saldoVencido);
					buro.getMop06().setSaldoActual(buro.getMop06().getSaldoActual() + saldoActual);
					buro.setTotalDesde03(buro.getTotalDesde03() + 1);
					buro.setTotalDesde04(buro.getTotalDesde04() + 1);
					if ( maximoCuenta > maximo06) {
						maximo06 = maximoCuenta;
					}
					buro.getMop06().setMaximoAbiertas(maximo06);
					if (fechaApertura.compareTo(fechaMaxima06) > 0) {
						fechaMaxima06 = fechaApertura;
			        }
					buro.getMop06().setFechaApertura(dtFormateadorString.format(fechaMaxima06));
				}
			} else if ( cuenta.getFormaPagoActual().equals("07")) {
				if (cuenta.getFechaCierreCuenta().isEmpty()) {
					buro.getMop07().setNumeroCuentasAbiertas(buro.getMop07().getNumeroCuentasAbiertas() + 1);
					buro.getMop07().setSaldoVencidoAbiertas(buro.getMop07().getSaldoVencidoAbiertas() + saldoVencido);
					buro.getMop07().setSaldoActual(buro.getMop07().getSaldoActual() + saldoActual);
					buro.setTotalDesde03(buro.getTotalDesde03() + 1);
					buro.setTotalDesde04(buro.getTotalDesde04() + 1);
					if ( maximoCuenta > maximo07) {
						maximo07 = maximoCuenta;
					}
					buro.getMop07().setMaximoAbiertas(maximo07);
					if (fechaApertura.compareTo(fechaMaxima07) > 0) {
						fechaMaxima07 = fechaApertura;
			        }
					buro.getMop07().setFechaApertura(dtFormateadorString.format(fechaMaxima07));
				}
			} else if ( cuenta.getFormaPagoActual().equals("96")) {
				if (cuenta.getFechaCierreCuenta().isEmpty()) {
					buro.getMop96().setNumeroCuentasAbiertas(buro.getMop96().getNumeroCuentasAbiertas() + 1);
					buro.getMop96().setSaldoVencidoAbiertas(buro.getMop96().getSaldoVencidoAbiertas() + saldoVencido);
					buro.getMop96().setSaldoActual(buro.getMop96().getSaldoActual() + saldoActual);
					buro.setTotalDesde03(buro.getTotalDesde03() + 1);
					buro.setTotalDesde04(buro.getTotalDesde04() + 1);
					if ( maximoCuenta > maximo96) {
						maximo96 = maximoCuenta;
					}
					buro.getMop96().setMaximoAbiertas(maximo96);
					if (fechaApertura.compareTo(fechaMaxima96) > 0) {
						fechaMaxima96 = fechaApertura;
			        }
					buro.getMop96().setFechaApertura(dtFormateadorString.format(fechaMaxima96));
				}
			} else if ( cuenta.getFormaPagoActual().equals("97")) {
				if (cuenta.getFechaCierreCuenta().isEmpty()) {
					buro.getMop97().setNumeroCuentasAbiertas(buro.getMop97().getNumeroCuentasAbiertas() + 1);
					buro.getMop97().setSaldoVencidoAbiertas(buro.getMop97().getSaldoVencidoAbiertas() + saldoVencido);
					buro.getMop97().setSaldoActual(buro.getMop97().getSaldoActual() + saldoActual);
					buro.setTotalDesde03(buro.getTotalDesde03() + 1);
					buro.setTotalDesde04(buro.getTotalDesde04() + 1);
					if ( maximoCuenta > maximo97) {
						maximo97 = maximoCuenta;
					}
					buro.getMop97().setMaximoAbiertas(maximo97);
					if (fechaApertura.compareTo(fechaMaxima97) > 0) {
						fechaMaxima97 = fechaApertura;
			        }
					buro.getMop99().setFechaApertura(dtFormateadorString.format(fechaMaxima97));
				}
			} else if ( cuenta.getFormaPagoActual().equals("99")) {
				if (cuenta.getFechaCierreCuenta().isEmpty()) {
					buro.getMop99().setNumeroCuentasAbiertas(buro.getMop99().getNumeroCuentasAbiertas() + 1);
					buro.getMop99().setSaldoVencidoAbiertas(buro.getMop99().getSaldoVencidoAbiertas() + saldoVencido);
					buro.getMop99().setSaldoActual(buro.getMop99().getSaldoActual() + saldoActual);
					buro.setTotalDesde03(buro.getTotalDesde03() + 1);
					buro.setTotalDesde04(buro.getTotalDesde04() + 1);
					if ( maximoCuenta > maximo99) {
						maximo99 = maximoCuenta;
					}
					buro.getMop99().setMaximoAbiertas(maximo99);
					if (fechaApertura.compareTo(fechaMaxima99) > 0) {
						fechaMaxima99 = fechaApertura;
			        }
					buro.getMop99().setFechaApertura(dtFormateadorString.format(fechaMaxima99));
				}
			}
			//Totales
			if (cuenta.getFechaCierreCuenta().isEmpty()) {
				buro.getTotal().setNumeroCuentasAbiertas(buro.getTotal().getNumeroCuentasAbiertas() + 1);
				buro.getTotal().setSaldoVencidoAbiertas(buro.getTotal().getSaldoVencidoAbiertas() + saldoVencido);
				buro.getTotal().setSaldoActual(buro.getTotal().getSaldoActual() + saldoActual);
				if ( maximoCuenta > maximoTodas) {
					maximoTodas = maximoCuenta;
				}
				buro.getTotal().setMaximoAbiertas(maximoTodas);
				if (fechaApertura.compareTo(fechaMaximaTodas) > 0) {
					fechaMaximaTodas = fechaApertura;
		        }
				buro.getTotal().setFechaApertura(dtFormateadorString.format(fechaMaximaTodas));
			}

			//Se verifica si trae una  cuenta hipotecario o automotriz
			//Automotriz Hipotecario
			//M - Hipoteca RE(Bienes Raices)
			//AU(Compra Automovil)
			int mopCuenta = Integer.parseInt(cuenta.getFormaPagoActual());
			if ( cuenta.getTipoCuenta().trim().equals("M") || cuenta.getTipoContrato().trim().equals("RE")) {
				hipotecario = true;
				if ( mopCuenta > hipMop) {
					hipMop = mopCuenta;
					hipSaldoVencido += saldoVencido;
				}
			}

			if (cuenta.getTipoContrato().trim().equals("AU") || cuenta.getNombreOrtogante().trim().equals("AUTOMOTRIZ") ) {
				automotriz = true;
				if ( mopCuenta > autoMop) {
					autoSaldoVencido += saldoVencido;
					autoMop = mopCuenta;
				}
			}
			// claves observacion

			String claves;
			try {
				claves = comun.obtenerParGeneral("", "LISTA_CVE_OBS");

			String[] clavesObs = claves.split(";");
			List<String> listaClavesObs = new ArrayList<String>();

			if (clavesObs.length > 0) {
				listaClavesObs = new ArrayList<String>();
					for (int j = 0; j < clavesObs.length; j++) {
						listaClavesObs.add(clavesObs[j]);
				}
			}

			if (listaClavesObs.contains(cuenta.getClaveObservacion())) {

				clavesObserv = clavesObserv.equals("") ? "" + cuenta.getClaveObservacion()
						: clavesObserv + ";" + cuenta.getClaveObservacion();

			}
			} catch (Exception e) {
				LogHandler.info("", getClass(), "No se encontro el JNDI : LISTA_CVE_OBS " );
			}

		 }

        }
		//for cuentas

		buro.setHipotecario(hipotecario);
		buro.setHipMop(hipMop);
		buro.setHipSaldoVencido(hipSaldoVencido);
		buro.setHipDescripcion("Saldo Vencido " + formateador.format(buro.getHipSaldoVencido()));

		// claves observacion
		buro.setClavesObserv(clavesObserv.equals("") ? " " : clavesObserv );

		buro.setAutomotriz(automotriz);
		buro.setAutoMop(autoMop);
		buro.setAutoSaldoVencido(autoSaldoVencido);
		buro.setAutoDescripcion("Saldo Vencido " + formateador.format(buro.getAutoSaldoVencido()));

		//Manipulacion para el front
		buro.setFrontTitulos("<div>CUENTAS ABIERTAS</div>"
						+	 "<div>SALDO VENCIDO ABIERTAS</div>"
						+	 "<div>SALDO ACTUAL</div>"
						+	 "<div>MAXIMO ABIERTAS</div>"
						+	 "<div>FECHA APERTURA</div>"
							);
		buro.setFrontMopUR( "<div>" +  buro.getMopUR().getNumeroCuentasAbiertas() + "</div>"
						+	"<div>" +  formateador.format(buro.getMopUR().getSaldoVencidoAbiertas()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMopUR().getSaldoActual()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMopUR().getMaximoAbiertas()) + "</div>"
						+	"<div>" +  buro.getMopUR().getFechaApertura() + "</div>");
		buro.setFrontMop01( "<div>" +  buro.getMop01().getNumeroCuentasAbiertas() + "</div>"
						+	"<div>" +  formateador.format(buro.getMop01().getSaldoVencidoAbiertas()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop01().getSaldoActual()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop01().getMaximoAbiertas()) + "</div>"
						+	"<div>" +  buro.getMop01().getFechaApertura() + "</div>");
		buro.setFrontMop02( "<div>" +  buro.getMop02().getNumeroCuentasAbiertas() + "</div>"
						+	"<div>" +  formateador.format( buro.getMop02().getSaldoVencidoAbiertas()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop02().getSaldoActual()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop02().getMaximoAbiertas()) + "</div>"
						+	"<div>" +  buro.getMop02().getFechaApertura() + "</div>");
		buro.setFrontMop03( "<div>" +  buro.getMop03().getNumeroCuentasAbiertas() + "</div>"
						+	"<div>" +  formateador.format(buro.getMop03().getSaldoVencidoAbiertas()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop03().getSaldoActual()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop03().getMaximoAbiertas()) + "</div>"
						+	"<div>" +  buro.getMop03().getFechaApertura() + "</div>");
		buro.setFrontMop04( "<div>" +  buro.getMop04().getNumeroCuentasAbiertas() + "</div>"
						+	"<div>" +  formateador.format(buro.getMop04().getSaldoVencidoAbiertas()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop04().getSaldoActual()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop04().getMaximoAbiertas()) + "</div>"
						+	"<div>" +  buro.getMop04().getFechaApertura() + "</div>");
		buro.setFrontMop05( "<div>" +  buro.getMop05().getNumeroCuentasAbiertas() + "</div>"
						+	"<div>" +  formateador.format(buro.getMop05().getSaldoVencidoAbiertas()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop05().getSaldoActual()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop05().getMaximoAbiertas()) + "</div>"
						+	"<div>" +  buro.getMop05().getFechaApertura() + "</div>");
		buro.setFrontMop06( "<div>" +  buro.getMop06().getNumeroCuentasAbiertas() + "</div>"
						+	"<div>" +  formateador.format(buro.getMop06().getSaldoVencidoAbiertas()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop06().getSaldoActual()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop06().getMaximoAbiertas()) + "</div>"
						+	"<div>" +  buro.getMop06().getFechaApertura() + "</div>");
		buro.setFrontMop07( "<div>" +  buro.getMop07().getNumeroCuentasAbiertas() + "</div>"
						+	"<div>" +  formateador.format(buro.getMop07().getSaldoVencidoAbiertas()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop07().getSaldoActual()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop07().getMaximoAbiertas()) + "</div>"
						+	"<div>" +  buro.getMop07().getFechaApertura() + "</div>");
		buro.setFrontMop96( "<div>" +  buro.getMop96().getNumeroCuentasAbiertas() + "</div>"
						+	"<div>" +  formateador.format(buro.getMop96().getSaldoVencidoAbiertas()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop96().getSaldoActual()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop96().getMaximoAbiertas()) + "</div>"
						+	"<div>" +  buro.getMop96().getFechaApertura() + "</div>");
		buro.setFrontMop97( "<div>" +  buro.getMop97().getNumeroCuentasAbiertas() + "</div>"
						+	"<div>" +  formateador.format(buro.getMop97().getSaldoVencidoAbiertas()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop97().getSaldoActual()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop97().getMaximoAbiertas()) + "</div>"
						+	"<div>" +  buro.getMop97().getFechaApertura() + "</div>");
		buro.setFrontMop99( "<div>" +  buro.getMop99().getNumeroCuentasAbiertas() + "</div>"
						+	"<div>" +  formateador.format(buro.getMop99().getSaldoVencidoAbiertas()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop99().getSaldoActual()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop99().getMaximoAbiertas()) + "</div>"
						+	"<div>" +  buro.getMop99().getFechaApertura() + "</div>");
		buro.setFrontTotal( "<div>" +  buro.getTotal().getNumeroCuentasAbiertas() + "</div>"
						+	"<div>" +  formateador.format(buro.getTotal().getSaldoVencidoAbiertas()) + "</div>"
						+	"<div>" +  formateador.format(buro.getTotal().getSaldoActual()) + "</div>"
						+	"<div>" +  formateador.format(buro.getTotal().getMaximoAbiertas()) + "</div>"
						+	"<div>" +  buro.getTotal().getFechaApertura() + "</div>");

		return buro;
	}

	/**
	 * @param persona a buscar
	 * @param listaDescartados lista de personas descartadas
	 * @return si se encontro la persona
	 */
	public boolean descartarIntegrante( String persona, List<IntegranteSolicitud> listaDescartados) {

		boolean resultado = false;
		if (listaDescartados == null || listaDescartados.isEmpty()) {
			return resultado;
		}
		for ( IntegranteSolicitud itemDescartado : listaDescartados) {
			if (itemDescartado.getPersona().trim().equals(persona)) {
				resultado = true;
			}
		}
		return resultado;
	}

	/**
	 * @param numero a redondear
	 * @return numero redondeado
	 */
	public static java.lang.Double redondeo( Double numero ) {
		return Math.rint(numero * Constantes.CENTENA) / Constantes.CENTENA;
	}



	/**
	 * @param uid Identificador unico
	 * @param peticion Validacion
	 * @return ConsultaSolicitudBuroRespuesta
	 */
	public ConsultaSolicitudBuroRespuesta validacionBuroClienteSolicitudExpress(String uid, ValidaSolicitudPeticion peticion) {
		ConsultaSolicitudBuroRespuesta respuesta = new ConsultaSolicitudBuroRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesion = null;
		SimpleDateFormat dtFormateador = new SimpleDateFormat("ddMMyyyy");

		try {
			LogHandler.info(uid, getClass(), "==> validacionBuroClienteSolicitudExpress - ENTRA");
			sesion = FabricaConexiones.obtenerSesionNTx();

			//Obtenemos url del servicio de par_general
			LogHandler.trace(uid, getClass(), "validacionSolicitudExpress: - obtenerParGeneral");
			ParGeneralOV urlBuro = comun.obtenerParGeneralOV(uid, "BURO_URL");
					//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "BURO_URL");
			if (urlBuro == null || urlBuro.getCgValor().trim().isEmpty()) {
					throw new Exception("No fue posible obtener la URL del servicio de buro.");
			}
			ServicioBuroCreditoProxy ws = new ServicioBuroCreditoProxy();
			ws.setEndpoint(urlBuro.getCgValor().trim());

			//Obtenemos valores para las reglas de validacion
			//MOP Hipotecario
			LogHandler.trace(uid, getClass(), "validacionSolicitudExpress: - obtenerParGeneral");
			ParGeneralOV mopHipotecario = comun.obtenerParGeneralOV(uid, "VABU_MOPHI");
					//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "VABU_MOPHI");
			//MOP Automotriz
			LogHandler.trace(uid, getClass(), "validacionSolicitudExpress: - obtenerParGeneral");
			ParGeneralOV mopAutomotriz = comun.obtenerParGeneralOV(uid, "VABU_MOPAU");
					//(ParGeneralOV)	sesion.selectOne("obtenerParGeneral", "VABU_MOPAU");
			//MOP99 Saldo Vencido
			LogHandler.trace(uid, getClass(), "validacionSolicitudExpress: - obtenerParGeneral");
			ParGeneralOV mop99SaldoVencido = comun.obtenerParGeneralOV(uid, "VABU_M99SV");
					//(ParGeneralOV)	sesion.selectOne("obtenerParGeneral", "VABU_M99SV");

			if ( mopHipotecario == null || mopHipotecario.getCgValor().trim().isEmpty()
				|| mopAutomotriz == null || mopAutomotriz.getCgValor().trim().isEmpty()
				|| mop99SaldoVencido == null || mop99SaldoVencido.getCgValor().trim().isEmpty()) {
				throw new Exception("No fue posible obtener los parametros para la validacion de buro VABU_MOPHI o VABU_MOPAU.");
			}

			RespuestaReglaIncremento respuestaIncremento = new RespuestaReglaIncremento();
			respuestaIncremento.setMop99(false);
			respuestaIncremento.setHipotecarioAutomotriz(false);
     		ObtenerXMLReporteCreditoRequest request = new ObtenerXMLReporteCreditoRequest();
     		ObtenerXMLReporteCreditoResponse response = new ObtenerXMLReporteCreditoResponse();
     		request.setPersona(peticion.getIntegrante().trim());
     		response = ws.obtenerXMLReporteCredito(request);

     		if (response == null ||  response.getXMLReporteCredito() == null ||  response.getXMLReporteCredito().isEmpty()) {
				throw new Exception("El cliente no tiene consulta al Buro [" + peticion.getIntegrante() + "].");
			}

     		ReporteCredito reporteCredito = obtenerObjetoBCN(response.getXMLReporteCredito());

     		LogHandler.info(uid, getClass(),
     				"validacionSolicitudExpress: - El integrante tiene consulta al buro.");
     		LogHandler.info(uid, getClass(),
     				"validacionSolicitudExpress: - El integrante es antiguo (ciclo > 0) [" + peticion.isAntiguo() + "]");

			String mensajeError = "** El Cliente [" +  peticion.getIntegrante()
					+ "] no cumple con las reglas de bur�, para ser sujeto de Renovacion Express: ";

			if ( peticion.isAntiguo() ) {
					mensajeError += " [Antiguo] ";
					if (  reporteCredito.getCuentas() != null ) {
					for (  SegmentoCuenta cuenta : reporteCredito.getCuentas() ) {
						cuenta.setFormaPagoActual(cuenta.getFormaPagoActual() == null ? "" : cuenta.getFormaPagoActual());
						cuenta.setFormaPagoActual(cuenta.getFormaPagoActual().isEmpty() ? "00" : cuenta.getFormaPagoActual());
						cuenta.setFormaPagoActual(cuenta.getFormaPagoActual().equals("UR")
								? "00" : cuenta.getFormaPagoActual().trim());
						int mopCuenta = Integer.parseInt(cuenta.getFormaPagoActual());
						cuenta.setSaldoVencido(cuenta.getSaldoVencido() == null ? "" : cuenta.getSaldoVencido());
						cuenta.setSaldoVencido(cuenta.getSaldoVencido().isEmpty() ? "0" : cuenta.getSaldoVencido());
						cuenta.setSaldoVencido(cuenta.getSaldoVencido().trim().replace("+", "").replace("-", ""));

						double saldoVencido =  Double.parseDouble(cuenta.getSaldoVencido());
						//Cuenta con mop 99
						if ( mopCuenta == MOP99) {

							respuestaIncremento.setMop99(true);

							double mop99SaldoVencidod = Double.parseDouble(mop99SaldoVencido.getCgValor().trim());
							//Validacion saldo vencido
							if (saldoVencido > mop99SaldoVencidod) {
								respuesta.getHeader().setCodigo("1");
								throw new Exception(mensajeError + " Cuenta con mop 99 y saldo vencido [" + saldoVencido + "].");
							}
							BuroCreditoClienteGrupoPeticion peticionHistorial = new BuroCreditoClienteGrupoPeticion();
							peticionHistorial.setPersona(peticion.getIntegrante());
							BuroCreditoClienteGrupoRespuesta respuestaHistorial
								= prGetDetalleHistoriaCTarea( uid, peticionHistorial);
							if (!respuestaHistorial.getHeader().isEstatus()) {
								 throw new Exception(respuestaHistorial.getHeader().getMensaje());
							}
							//Validacion al menos 2 ciclos
							if (respuestaHistorial.getGrupos().size() < 2) {
								respuesta.getHeader().setCodigo("1");
								throw new Exception(mensajeError + " Cuenta con mop 99 y no tiene al menos 2 ciclos continuos.");
							}
							//Ultimo credito Fecha Liquidacion contra Fecha Fin Pactada
							if (peticion.isOrdinaria() && respuestaHistorial.getGrupos().get(0).getDiasAtra() > 0 ) {
								respuesta.getHeader().setCodigo("1");
								throw new Exception(mensajeError
										+ " Cuenta con mop 99 y el ultimo ciclo con mal historial, liquido con "
										+ respuestaHistorial.getGrupos().get(0).getDiasAtra()
										+ " dias de atraso despues de su fecha liquidacion pactada.");
							}
							//Penultimo credito Fecha Liquidacion contra Fecha Fin Pactada
							if (peticion.isOrdinaria() && respuestaHistorial.getGrupos().get(1).getDiasAtra() > 0 ) {
								respuesta.getHeader().setCodigo("1");
								throw new Exception(mensajeError
										+ " Cuenta con mop 99 y el penultimo ciclo con mal historial, liquido con "
										+ respuestaHistorial.getGrupos().get(1).getDiasAtra()
										+ " dias de atraso despues de su fecha liquidacion pactada.");
							}
						} //Fin MOP 99

						//Validacion cuentas Hipotercario y Bienes Raices
						if ( cuenta.getTipoCuenta().trim().equals("M") || cuenta.getTipoContrato().trim().equals("RE")
								|| cuenta.getNombreOrtogante().trim().equals("BIENES RAICES")) {
							if ( mopCuenta >  Integer.parseInt(mopHipotecario.getCgValor())) {
								respuesta.getHeader().setCodigo("1");
								mensajeError = mensajeError + " Cuenta Hipotecario o Bienes Racices con mop ["
											+ mopCuenta + "] mayor a "
											+ mopHipotecario.getCgValor() + ".";
								LogHandler.info(uid, getClass(), "validacionSolicitudExpress: " + mensajeError);
								respuestaIncremento.setHipotecarioAutomotriz(true);
							}
						}
						//Validacion cuentas Automotriz
						if (cuenta.getTipoContrato().trim().equals("AU")
							|| cuenta.getNombreOrtogante().trim().equals("AUTOMOTRIZ") ) {
							if ( mopCuenta >  Integer.parseInt(mopAutomotriz.getCgValor())) {
								respuesta.getHeader().setCodigo("1");
								mensajeError = mensajeError + " Cuenta Automotriz con mop ["
											+ mopCuenta + "] mayor a "
										    + mopAutomotriz.getCgValor() + ".";
								LogHandler.info(uid, getClass(), "validacionSolicitudExpress: " + mensajeError);
								respuestaIncremento.setHipotecarioAutomotriz(true);
							}
						}
					}
					}
				} else {
					//El cliente es nuevo en el grupo
					 //Barrido de cuentas TL
					mensajeError += " [Nuevo] ";
					if (  reporteCredito.getCuentas() != null ) {
					for (  SegmentoCuenta cuenta : reporteCredito.getCuentas() ) {
						cuenta.setFormaPagoActual(cuenta.getFormaPagoActual() == null ? "" : cuenta.getFormaPagoActual());
						cuenta.setFormaPagoActual(cuenta.getFormaPagoActual().isEmpty() ? "00" : cuenta.getFormaPagoActual());
						cuenta.setFormaPagoActual(cuenta.getFormaPagoActual().equals("UR")
								? "00" : cuenta.getFormaPagoActual().trim());
						cuenta.setClaveObservacion(cuenta.getClaveObservacion() == null ? "" : cuenta.getClaveObservacion());
						int mopCuenta = Integer.parseInt(cuenta.getFormaPagoActual());

						//Validacion clave de Observacion
						if ( cuenta.getClaveObservacion().equals("FD")
							|| cuenta.getClaveObservacion().equals("SG")
							|| cuenta.getClaveObservacion().equals("IM")
							|| cuenta.getClaveObservacion().equals("LO")
							|| cuenta.getClaveObservacion().equals("FR")) {
							respuesta.getHeader().setCodigo("1");
							throw new Exception(mensajeError + " Clave de Observacion [" + cuenta.getClaveObservacion() + "].");
						}
						//Validacion mop 99
						if ( mopCuenta == MOP99 ) {
							respuesta.getHeader().setCodigo("1");
							throw new Exception(mensajeError + " Cuenta con mop 99.");
						}
						//Validacion cuentas Hipotercario y Bienes Raices
						if ( cuenta.getTipoCuenta().trim().equals("M") || cuenta.getTipoContrato().trim().equals("RE")
								|| cuenta.getNombreOrtogante().trim().equals("BIENES RAICES")) {
							if ( mopCuenta >  Integer.parseInt(mopHipotecario.getCgValor())) {
								respuesta.getHeader().setCodigo("1");
								throw new Exception(mensajeError + " Cuenta Hipotecario o Bienes Racices con mop ["
											+ mopCuenta + "] mayor a "
											+ mopHipotecario.getCgValor() + ".");
							}
						}
						//Validacion cuentas Automotriz
						if (cuenta.getTipoContrato().trim().equals("AU")
							|| cuenta.getNombreOrtogante().trim().equals("AUTOMOTRIZ") ) {
							if ( mopCuenta >  Integer.parseInt(mopAutomotriz.getCgValor())) {
								respuesta.getHeader().setCodigo("1");
								throw new Exception(mensajeError + " Cuenta Automotriz con mop ["
											+ mopCuenta + "] mayor a "
										    + mopAutomotriz.getCgValor() + ".");
							}
						}
						//Validacion mop cuentas
						if (mopCuenta == MOP_4 || mopCuenta == MOP_5 || mopCuenta == MOP_6 || mopCuenta == MOP_7) {
							respuesta.getHeader().setCodigo("1");
							throw new Exception(mensajeError + " Cuenta con mop " + mopCuenta);
						}
						//Validacion mop cuentas 96 y 07
						if (mopCuenta == MOP_96 || mopCuenta == MOP_97) {
							boolean aprobacion = false;
							if (  reporteCredito.getCuentas() != null ) {
								for (  SegmentoCuenta cuentaAux : reporteCredito.getCuentas() ) {
									if (cuentaAux.getFormaPagoActual().trim().equals("01")) {
										Date fechaApertura = dtFormateador.parse(cuenta.getFechaAperturaCuenta());
										if ( diferenciaEnDias(new Date(), fechaApertura) >= DIAS_ANIO) {
											aprobacion = true;
										}
									}
								}
							}
							if (!aprobacion) {
								respuesta.getHeader().setCodigo("1");
								throw new Exception(mensajeError + " Cuenta con mop " + mopCuenta
										+ ", sin tener cuenta al corriente en el perido de un a�o.");
							}
                        }
					}
					}
			} //fin nuevos

			respuesta.setRespuestaIncremento(respuestaIncremento);


		}
		catch (BncException exBuroSrv) {
			exBuroSrv.printStackTrace();
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje("Error en la llamada al servicio de buro [BncException]. "
					+ exBuroSrv.getRespuestaClave());
 	    }
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "validacionSolicitudExpress: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sesion);
		}
		return respuesta;
	}

	/**
	 * @param uid Identificador unico
	 * @param peticion Validacion
	 * @return ConsultaSolicitudBuroRespuesta
	 */
	public ConsultaSolicitudBuroRespuesta validacionBuroClienteSolicitudExpressIguala(
			String uid, ValidaSolicitudPeticion peticion) {
		ConsultaSolicitudBuroRespuesta respuesta = new ConsultaSolicitudBuroRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesion = null;

		try {
			LogHandler.info(uid, getClass(), "==> validacionBuroClienteSolicitudExpressIguala - ENTRA");
			sesion = FabricaConexiones.obtenerSesionNTx();

			//Obtenemos url del servicio de par_general
			LogHandler.trace(uid, getClass(), "validacionBuroClienteSolicitudExpressIguala: - obtenerParGeneral");
			ParGeneralOV urlBuro = comun.obtenerParGeneralOV(uid, "BURO_URL");
					//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "BURO_URL");
			if (urlBuro == null || urlBuro.getCgValor().trim().isEmpty()) {
					throw new Exception("No fue posible obtener la URL del servicio de buro.");
			}
			ServicioBuroCreditoProxy ws = new ServicioBuroCreditoProxy();
			ws.setEndpoint(urlBuro.getCgValor().trim());
			ObtenerXMLReporteCreditoRequest request = new ObtenerXMLReporteCreditoRequest();
     		ObtenerXMLReporteCreditoResponse response = new ObtenerXMLReporteCreditoResponse();
     		request.setPersona(peticion.getIntegrante().trim());
     		response = ws.obtenerXMLReporteCredito(request);

     		if (response == null ||  response.getXMLReporteCredito() == null ||  response.getXMLReporteCredito().isEmpty()) {
				throw new Exception("El cliente no tiene consulta al Buro [" + peticion.getIntegrante() + "].");
			}

     		ReporteCredito reporteCredito = obtenerObjetoBCN(response.getXMLReporteCredito());

     		LogHandler.info(uid, getClass(),
     				"validacionBuroClienteSolicitudExpressIguala: - El integrante tiene consulta al buro.");

			SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");

			String fechaConsulta = "";
			Date dFechaConsulta = null;
			if ( reporteCredito.getConsultas().size() == 0 ) {
				throw new Exception("No es posible obtener la fecha de consulta del buro");
			} else {
				fechaConsulta = reporteCredito.getConsultas().get(0).getFechaConsulta();
				dFechaConsulta = formatter.parse(fechaConsulta);
			}
			//Se valida que tenga una cuenta con las condiciones

			boolean cumpleReglas = false;

			if (  reporteCredito.getCuentas() != null ) {
			for ( SegmentoCuenta cuenta : reporteCredito.getCuentas() ) {
				cuenta.setFormaPagoActual(cuenta.getFormaPagoActual() == null ? "" : cuenta.getFormaPagoActual());
				cuenta.setSaldoVencido(cuenta.getSaldoVencido() == null ? "" : cuenta.getSaldoVencido());
				cuenta.setSaldoVencido(cuenta.getSaldoVencido().isEmpty() ? "0" : cuenta.getSaldoVencido());
				cuenta.setSaldoVencido(cuenta.getSaldoVencido().trim().replace("+", "").replace("-", ""));

				double saldoVencido =  Double.parseDouble(cuenta.getSaldoVencido());

				cuenta.setCreditoMaximo(cuenta.getCreditoMaximo() == null ? "" : cuenta.getCreditoMaximo());
				cuenta.setCreditoMaximo(cuenta.getCreditoMaximo().isEmpty() ? "0" : cuenta.getCreditoMaximo());
				cuenta.setCreditoMaximo(cuenta.getCreditoMaximo().trim().replace("+", "").replace("-", ""));

				double creditoMaximo =  Double.parseDouble(cuenta.getCreditoMaximo());

				cuenta.setFrecuenciaPago(cuenta.getFrecuenciaPago() == null ? "" : cuenta.getFrecuenciaPago());

				if (!cuenta.getNombreOrtogante().trim().equals("FINSOL")) {
					if (cuenta.getTipoContrato().trim().equals("PL") && cuenta.getTipoCuenta().trim().equals("I")
						&& cuenta.getIndicadorTipoRespCuenta().trim().equals("I")) {
						if ( cuenta.getNombreOrtogante().trim().equals("BANCO")
								|| cuenta.getNombreOrtogante().trim().equals("FINANCIERA")
								|| cuenta.getNombreOrtogante().trim().equals("MICROFINANCIERA")
								|| cuenta.getNombreOrtogante().trim().equals("COOPERATIVA")) {
							if (cuenta.getFormaPagoActual().trim().equals("01") && saldoVencido == 0 ) {
									if (creditoMaximo >= peticion.getMontoSolicitado()) {

										cuenta.setFrecuenciaPago(cuenta.getFrecuenciaPago().trim());
										cuenta.setNumeroPagos(cuenta.getNumeroPagos() == null ? "" : cuenta.getNumeroPagos());
										cuenta.setNumeroPagos(cuenta.getNumeroPagos().isEmpty()
												? "0" : cuenta.getNumeroPagos().trim());
										int noPagos = Integer.valueOf(cuenta.getNumeroPagos());

										if (
												//Semanal
												(cuenta.getFrecuenciaPago().equals("W") && noPagos <= IGUAL_CTA_SEMANAS)
												//Quincenal
												|| (cuenta.getFrecuenciaPago().equals("S") && noPagos <= IGUAL_CTA_CATORCENAS)
												//Catorcenal
												|| (cuenta.getFrecuenciaPago().equals("K") && noPagos <= IGUAL_CTA_CATORCENAS)
											) {
											if (cuenta.getFechaCierreCuenta().isEmpty()) {
												//Validacion Fecha Apertura
												Date dFechaApertura = formatter.parse(cuenta.getFechaAperturaCuenta());
												int diasTranscurridos = diferenciaEnDias(dFechaConsulta, dFechaApertura);
												double diasTotales = 0;
												if (cuenta.getFrecuenciaPago().equals("W")) {
													diasTotales = noPagos * DIAS_SEMANA;
												} else if (cuenta.getFrecuenciaPago().equals("S")) {
													diasTotales = noPagos * DIAS_QUINCENA;
												} else if (cuenta.getFrecuenciaPago().equals("K")) {
													diasTotales = noPagos * DIAS_QUINCENA;
												}
												double porcentajeTranscurrido =  diasTranscurridos / diasTotales;

												if ( porcentajeTranscurrido > IGUAL_PCT_CTA_ABIERTA) {
													LogHandler.info(uid, getClass(), "==> validacionExpressIguala - CUENTAOK");
													cumpleReglas = true;
													break;
												}
											} else {
												Date dFechaCierre = formatter.parse(cuenta.getFechaCierreCuenta());
												int diasCerrada = diferenciaEnDias(dFechaConsulta, dFechaCierre);
												if ( diasCerrada <= IGUAL_DIAS_CTA_CERRADA) {
													LogHandler.info(uid, getClass(), "==> validacionExpressIguala - CUENTAOK");
													cumpleReglas = true;
													break;
												}
											}
									}
								}
							}
						}
					}
				}
			}
				if (!cumpleReglas) {
				  throw new Exception("No contiene una cuenta en el reporte de Buro de credito con las condiciones solicitadas");
				}
			}


		}
		catch (BncException exBuroSrv) {
			exBuroSrv.printStackTrace();
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje("Error en la llamada al servicio de buro [BncException]. "
					+ exBuroSrv.getRespuestaClave());
 	    }
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "validacionSolicitudExpress: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sesion);
		}
		return respuesta;
	}

	/**
	 * @param fechaMayor fecha Actual
	 * @param fechaMenor fecha Menor
	 * @return diferencia de dias
	 */
	public  int diferenciaEnDias(Date fechaMayor, Date fechaMenor) {
		/* CREAMOS LOS OBJETOS GREGORIAN CALENDAR PARA EFECTUAR LA RESTA */
		GregorianCalendar date1 = new GregorianCalendar();
		date1.setTime(fechaMenor); //dateIni es el objeto Date
		GregorianCalendar date2 = new GregorianCalendar();
		date2.setTime(fechaMayor); //dateFin es el objeto Date
		int rango = 0;
		/* COMPROBAMOS SI ESTAMOS EN EL MISMO A�O */
		if (date1.get(Calendar.YEAR) == date2.get(Calendar.YEAR)) {
		rango = date2.get(Calendar.DAY_OF_YEAR) - date1.get(Calendar.DAY_OF_YEAR);
		} else {
		/* SI ESTAMOS EN DISTINTO A�O COMPROBAMOS QUE EL A�O DEL DATEINI NO SEA BISIESTO
		* SI ES BISIESTO SON 366 DIAS EL A�O
		* SINO SON 365
		*/
		int diasAnyo = date1.isLeapYear(date1.get(Calendar.YEAR)) ? DIAS_ANIO_BI : DIAS_ANIO;
		/* CALCULAMOS EL RANGO DE A�OS */
		int rangoAnyos = date2.get(Calendar.YEAR) - date1.get(Calendar.YEAR);
		/* CALCULAMOS EL RANGO DE DIAS QUE HAY */
		rango = (rangoAnyos * diasAnyo) + (date2.get(Calendar.DAY_OF_YEAR) - date1.get(Calendar.DAY_OF_YEAR));
		}
		return rango;
		}

	/**
	 * @param uid Identificador de Transaccion
	 * @param peticion de consulta
	 * @return ConsultaBuroRespuesta
	 */
	@SuppressWarnings("unchecked")
	public ConsultaSolicitudBuroRespuesta validacionIDSolicitudBuroAnalistaDocumentalBC(String uid,
			ValidaSolicitudPeticion peticion) {
		ConsultaSolicitudBuroRespuesta respuesta = new ConsultaSolicitudBuroRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		String mensajeAprobacion = "CUMPLE REQUISITOS BURO";
		String mensajeRechazo = "RECHAZADO";
		SqlSession sesion = null;
		//List<SolicitudSACGIntegrante> solicitudSACGIntegrante = new List<SolicitudSACGIntegrante>()

		try {
			if (peticion == null || peticion.getSolicitud() == null
					|| peticion.getSolicitud().trim().isEmpty()) {
				throw new Exception("El ID de la solicitud en la peticion es necesaria.");
			}

			SolicitudBuroOV peticionEncabezado = new SolicitudBuroOV();
			peticionEncabezado.setSolicitud(peticion.getSolicitud().trim());
			EncabezadoSolicitudRespuesta respuestaEncabezado
				= solicitudesCredito.obtenerDatosSolicitudEncabezadoAnalistaDocumentalBCTarea(uid, peticionEncabezado);
			if (!respuestaEncabezado.getHeader().isEstatus()) {
				 throw new Exception(respuestaEncabezado.getHeader().getMensaje());
			}

			SolicitudBuroOV solicitudEncabezado = new SolicitudBuroOV();
			solicitudEncabezado.setSolicitud(peticion.getSolicitud());
			solicitudEncabezado.setCiclo(respuestaEncabezado.getSolicitudEncabezado().getCiclo());
			solicitudEncabezado.setNombreSucursal(respuestaEncabezado.getSolicitudEncabezado().getNombreSucursal().trim());
			solicitudEncabezado.setNombre(respuestaEncabezado.getSolicitudEncabezado().getNombre());
			solicitudEncabezado.setValorTipificacion(respuestaEncabezado.getSolicitudEncabezado().getValorTipificacion());
			solicitudEncabezado.setTipificacionSucursal(respuestaEncabezado.getSolicitudEncabezado().getTipificacionSucursal());
			solicitudEncabezado.setEstatus(respuestaEncabezado.getSolicitudEncabezado().getEstatus());
			solicitudEncabezado.setIntegrantesOrigenCampana(
					respuestaEncabezado.getSolicitudEncabezado().getIntegrantesOrigenCampana());
			solicitudEncabezado.setMotivoCancelacion(respuestaEncabezado.getSolicitudEncabezado().getMotivoCancelacion());
			solicitudEncabezado.setClientesCicloAnterior(respuestaEncabezado.getSolicitudEncabezado().getClientesCicloAnterior());
			solicitudEncabezado.setTipoSucursal(respuestaEncabezado.getSolicitudEncabezado().getTipoSucursal());
			solicitudEncabezado.setMotivoJustificacion(respuestaEncabezado.getSolicitudEncabezado().getMotivoJustificacion());
			solicitudEncabezado.setCampana(respuestaEncabezado.getSolicitudEncabezado().getCampana());
			solicitudEncabezado.setPorcentajeGarantia(respuestaEncabezado.getSolicitudEncabezado().getPorcentajeGarantia());
			solicitudEncabezado.setGarantiaJustificacion(respuestaEncabezado.getSolicitudEncabezado().getGarantiaJustificacion());
			solicitudEncabezado.setSucursal(respuestaEncabezado.getSolicitudEncabezado().getSucursal());
			solicitudEncabezado.setContratoAnteriorGrupo(respuestaEncabezado.getSolicitudEncabezado().getContratoAnteriorGrupo());

			LogHandler.info(uid, getClass(), "validacionIDSolicitudBuro: respuestaFolioBuro correcta");

			sesion = FabricaConexiones.obtenerSesionNTx();

			//Se obtiene el numero de integrantes nuevos en el grupo
			/*
			final java.util.HashMap<String, Object> param = new HashMap<String, Object>();
			param.put( "solicitud" , peticion.getSolicitud().trim());
			param.put( "numeroClienteGrupo" , respuestaEncabezado.getSolicitudEncabezado().getNumeroClienteGrupo());
			LogHandler.trace(uid, getClass(), "==> - consultaClienteNuevoGrupo");
			solicitudSACGIntegrante
				= (List<SolicitudSACGIntegrante>) sesion.selectList("consultaClienteNuevoGrupo", param);

			if (solicitudSACGIntegrante.size() > 0) {
				int integrantesNuevos = 0;
				for ( SolicitudSACGIntegrante integrante : solicitudSACGIntegrante ) {
					if (integrante.getCodigoPocg() == null) {
						integrantesNuevos++;
					}
				}
				solicitudEncabezado.setClientesNuevoGrupo(String.valueOf(integrantesNuevos));
			} else {
				solicitudEncabezado.setClientesNuevoGrupo("0");
			}

			*/

			//Se obtiene el numero de integrantes de empresaOrigen
			/*
			LogHandler.trace(uid, getClass(), "==> - obtieneIntegrantesOrigenCampana" );
			final java.lang.Integer integOrigenCampana = (Integer)
					sesion.selectOne( "obtieneIntegrantesOrigenCampana", peticion.getSolicitud().trim());

			if (integOrigenCampana > 0 ) {
				solicitudEncabezado.setIntegrantesOrigenCampana(String.valueOf(integOrigenCampana));
			} else {
				solicitudEncabezado.setIntegrantesOrigenCampana("0");
			}
			 */

			LogHandler.trace(uid, getClass(), "==> - obtieneIntegrantesOrigenCampana" );
			 List<SolicitudSACGIntegrante> solicitudSACGIntegrante	= (List<SolicitudSACGIntegrante>)
					sesion.selectList( "obtieneIntegrantesOrigenCampana", peticion.getSolicitud().trim());

//			if (solicitudSACGIntegrante.size() == 0) {
//				solicitudEncabezado.setIntegrantesOrigenCampana("0");
//				solicitudEncabezado.setClientesNuevoGrupo(9);
//			}

			if (solicitudSACGIntegrante.size() > 0 ) {
				int integrantesNuevos = 0;
				for (int i = 0;  i < solicitudSACGIntegrante.size(); i++ ) {

					if (solicitudSACGIntegrante.get(i).getEmpresaOrigen().equals(" ")) {
						solicitudEncabezado.setIntegrantesOrigenCampana(String.valueOf(
								solicitudSACGIntegrante.get(0).getEmpresaOrigen().equals(" ") ? "0"
										: solicitudSACGIntegrante.get(0).getNuevos()));
						integrantesNuevos += solicitudSACGIntegrante.get(i).getNuevos();
					}
				}
				solicitudEncabezado.setClientesNuevoGrupo(String.valueOf(integrantesNuevos));
			} else {
				solicitudEncabezado.setIntegrantesOrigenCampana("0");
			}

//			if (solicitudSACGIntegrante.size() > 0 ) {
//				int integrantesNuevos = 0;
//				for (int i = 0;  i < solicitudSACGIntegrante.size(); i++ ) {
//					if (i > 0) {
//						integrantesNuevos++;
//					}
//					solicitudEncabezado.setIntegrantesOrigenCampana(solicitudSACGIntegrante.get(0).toString());
//				}
//				solicitudEncabezado.setClientesNuevoGrupo(String.valueOf(integrantesNuevos));
//			} else {
//				solicitudEncabezado.setIntegrantesOrigenCampana("0");
//			}

			//Se obtiene la consulta a solicitud_buro
			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put( "solicitud" , peticion.getSolicitud().trim());
			parametros.put( "status" , "A");
			LogHandler.trace(uid, getClass(), "==> validacionIDSolicitudBuro - obtenerSolicitudBuro");
			List<SolicitudBuroClienteOV> solicitudes
				= (List<SolicitudBuroClienteOV>) sesion.selectList("obtenerSolicitudBuro", parametros);

			if (solicitudes.isEmpty()) {
				throw new Exception(ReadProperties.mensajes.getProp("solicitudes.consulta.solicitud.buro.inexistente"));
			}

			LogHandler.trace(uid, getClass(), "validacionIDSolicitudBuro: - obtenerParGeneral");
			ParGeneralOV urlBuro = comun.obtenerParGeneralOV(uid, "BURO_URL");
					//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "BURO_URL");
			if (urlBuro == null || urlBuro.getCgValor().trim().isEmpty()) {
					throw new Exception("No fue posible obtener la URL del servicio de buro.");
			}
			ServicioBuroCreditoProxy ws = new ServicioBuroCreditoProxy();
			ws.setEndpoint(urlBuro.getCgValor().trim());

			//Obtenemos valores para las reglas de validacion
			LogHandler.trace(uid, getClass(), "validacionIDSolicitudBuro: - obtenerParGeneral");
			ParGeneralOV porcentajeAprobacionMedio = comun.obtenerParGeneralOV(uid, "VABU_POAME");

			LogHandler.trace(uid, getClass(), "validacionIDSolicitudBuro: - obtenerParGeneral");
			ParGeneralOV porcentajeAprobacionAlto = comun.obtenerParGeneralOV(uid, "VABU_POAAL");

			LogHandler.trace(uid, getClass(), "validacionIDSolicitudBuro: - obtenerParGeneral");
			ParGeneralOV promedioEdad = comun.obtenerParGeneralOV(uid, "VABU_PEDAD");


			LogHandler.trace(uid, getClass(), "validacionIDSolicitudBuro: - obtenerParGeneral");
			ParGeneralOV mopHipotecario = comun.obtenerParGeneralOV(uid, "VABU_MOPHI");

			LogHandler.trace(uid, getClass(), "validacionIDSolicitudBuro: - obtenerParGeneral");
			ParGeneralOV mopAutomotriz = comun.obtenerParGeneralOV(uid, "VABU_MOPAU");

			if (porcentajeAprobacionMedio == null || porcentajeAprobacionMedio.getCgValor().trim().isEmpty()
				|| porcentajeAprobacionAlto == null || porcentajeAprobacionAlto.getCgValor().trim().isEmpty()
				|| promedioEdad == null || promedioEdad.getCgValor().trim().isEmpty()
				|| mopHipotecario == null || mopHipotecario.getCgValor().trim().isEmpty()
				|| mopAutomotriz == null || mopAutomotriz.getCgValor().trim().isEmpty()) {
				throw new Exception("No fue posible obtener los parametros para la validacion de buro.");
			}

			for ( SolicitudBuroClienteOV integranteSolicitud : solicitudes) {

				ObtenerXMLReporteCreditoPorFolioRequest request = new ObtenerXMLReporteCreditoPorFolioRequest();
				ObtenerXMLReporteCreditoPorFolioResponse response = new ObtenerXMLReporteCreditoPorFolioResponse();
				request.setFolio(integranteSolicitud.getFolioConsultaBuro().trim());
				response = ws.obtenerXMLReporteCreditoPorFolio(request);

				if (response == null ||  response.getXMLReporteCredito() == null ||  response.getXMLReporteCredito().isEmpty()) {
					throw new Exception("No se pudo obtener la consulta Buro del cliente " + integranteSolicitud.getPersona()
							+ " " + integranteSolicitud.getNombreCompleto());
				}

				ReporteCredito reporteCredito = obtenerObjetoBCN(response.getXMLReporteCredito());
				LogHandler.info(uid, getClass(), "obtenerDatosValidacion - " + integranteSolicitud.getPersona());
				ValidaBuroDTO respuestaValidaBuro = obtenerDatosValidacionAnalistaDocumentalBC(reporteCredito);
				integranteSolicitud.setCuentas(respuestaValidaBuro);
			}
			//Totales y reglas
			int sumaEdad = 0;
			int clientesActivos = 0;
			String rol = "";
			String contratoAnterior = "";
			for ( SolicitudBuroClienteOV integranteSolicitud : solicitudes) {
				if (!descartarIntegrante(integranteSolicitud.getPersona().trim(), peticion.getIntegrantesDescarte())) {
					solicitudEncabezado.setTotalMOP01(solicitudEncabezado.getTotalMOP01()
							+ integranteSolicitud.getCuentas().getMop01().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalMOP02(solicitudEncabezado.getTotalMOP02()
							+ integranteSolicitud.getCuentas().getMop02().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalMOP03(solicitudEncabezado.getTotalMOP03()
							+ integranteSolicitud.getCuentas().getMop03().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalMOP04(solicitudEncabezado.getTotalMOP04()
							+ integranteSolicitud.getCuentas().getMop04().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalMOP05(solicitudEncabezado.getTotalMOP05()
							+ integranteSolicitud.getCuentas().getMop05().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalMOP06(solicitudEncabezado.getTotalMOP06()
							+ integranteSolicitud.getCuentas().getMop06().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalMOP07(solicitudEncabezado.getTotalMOP07()
							+ integranteSolicitud.getCuentas().getMop07().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalMOP96(solicitudEncabezado.getTotalMOP96()
							+ integranteSolicitud.getCuentas().getMop96().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalMOP97(solicitudEncabezado.getTotalMOP97()
							+ integranteSolicitud.getCuentas().getMop97().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalMOP99(solicitudEncabezado.getTotalMOP99()
							+ integranteSolicitud.getCuentas().getMop99().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalMOPUR(solicitudEncabezado.getTotalMOPUR()
							+ integranteSolicitud.getCuentas().getMopUR().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalCuentas(solicitudEncabezado.getTotalCuentas()
							+ integranteSolicitud.getCuentas().getTotal().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalDesde03(solicitudEncabezado.getTotalDesde03()
							+ integranteSolicitud.getCuentas().getTotalDesde03());
					solicitudEncabezado.setTotalDesde04(solicitudEncabezado.getTotalDesde04()
							+ integranteSolicitud.getCuentas().getTotalDesde04());
					sumaEdad += integranteSolicitud.getEdad();
					rol += integranteSolicitud.getRol();
					contratoAnterior += integranteSolicitud.getContratoAnterior();
					clientesActivos++;

		             // claves observacion
		             integranteSolicitud.setClaveObservacion(integranteSolicitud.getCuentas().getClavesObserv());

					if (!solicitudEncabezado.getValorTipificacion().trim().equals("NRBA")) {
			             if (integranteSolicitud.getCuentas().isHipotecario()) {
			            	 if (integranteSolicitud.getCuentas().getHipMop() > Integer.parseInt(mopHipotecario.getCgValor())) {
			            		 integranteSolicitud.setCausaRechazo("Hipotecario con Mop "
			            				 + integranteSolicitud.getCuentas().getHipMop() + " - "
			            				 + integranteSolicitud.getCuentas().getHipDescripcion());
			            	 }
			             }
			             if (integranteSolicitud.getCuentas().isAutomotriz()) {
			            	 if (integranteSolicitud.getCuentas().getAutoMop() > Integer.parseInt(mopAutomotriz.getCgValor())) {
			            		 integranteSolicitud.setCausaRechazo("Automotriz con Mop "
			            				 + integranteSolicitud.getCuentas().getAutoMop() + " - "
			            				 + integranteSolicitud.getCuentas().getAutoDescripcion());
			            	 }
			             }
			        }
				} else {
					integranteSolicitud.setDescartado("X");
					integranteSolicitud.getCuentas().getTotal().setNumeroCuentasAbiertas(0);
					integranteSolicitud.getCuentas().setTotalDesde03(0);
					integranteSolicitud.getCuentas().setTotalDesde04(0);
					integranteSolicitud.setCausaRechazo(" ");
				}
			}

			if (clientesActivos > 0) {
				solicitudEncabezado.setPromedioEdad( sumaEdad / clientesActivos );
			} else {
				solicitudEncabezado.setPromedioEdad(0);
			}

			Float factorDesde03 = 0f;
			Float factorDesde04 = 0f;
			Double dfactorDesde03 = 0d;
			Double dfactorDesde04 = 0d;

			float totalDesde03 = solicitudEncabezado.getTotalDesde03();
			float totalDesde04 = solicitudEncabezado.getTotalDesde04();
			float totalCuentas = solicitudEncabezado.getTotalCuentas();
			if (solicitudEncabezado.getTotalCuentas() > 0) {
				factorDesde03 =  ( totalDesde03 / totalCuentas) * Constantes.CENTENA;
				dfactorDesde03 = redondeo(new Double(factorDesde03));
				factorDesde04 = ( totalDesde04 / totalCuentas) * Constantes.CENTENA;
				dfactorDesde04 = redondeo(new Double(factorDesde04));

			}

			solicitudEncabezado.setFactorDesde03(dfactorDesde03);
			solicitudEncabezado.setFactorDesde04(dfactorDesde04);
			solicitudEncabezado.setIntegrantes(solicitudes);
			solicitudEncabezado.setLeyendaNivelMedio("MOP>=4 no exceda " + porcentajeAprobacionMedio.getCgValor()
					+ "% total de cuentas. Si excede promedio de edad > " + promedioEdad.getCgValor() + " años.");
			solicitudEncabezado.setLeyendaNivelAlto("MOP>=3 no exceda " + porcentajeAprobacionAlto.getCgValor()
					+ "% total de cuentas.");
			Integer iPromedioEdad = Integer.parseInt(promedioEdad.getCgValor());
			Double dPorcetajeAprobacionMedio = Double.parseDouble(porcentajeAprobacionMedio.getCgValor());
			Double dPorcetajeAprobacionAlto = Double.parseDouble(porcentajeAprobacionAlto.getCgValor());
			//Reglas de negocio para conocer el resultado final.
            String resultadoAprobacion = "";
            //Tipificacion Bajo
            LogHandler.info(uid, getClass(), "==> tipificacion -> " +  solicitudEncabezado.getValorTipificacion());
            LogHandler.info(uid, getClass(), "==> factorDesde04 -> " +  factorDesde04);
            LogHandler.info(uid, getClass(), "==> factorDesde03 -> " +  factorDesde03);
            LogHandler.info(uid, getClass(), "==> dPorcetajeAprobacionMedio -> " +  dPorcetajeAprobacionMedio);
            LogHandler.info(uid, getClass(), "==> dPorcetajeAprobacionAlto -> " +  dPorcetajeAprobacionAlto);
            if (solicitudEncabezado.getValorTipificacion().trim().equals("NRBA"))
            {
                resultadoAprobacion = mensajeAprobacion;
            }
            //Tipificacion Medio
            else if (solicitudEncabezado.getValorTipificacion().trim().equals("NRME"))
            {
                if (factorDesde04.doubleValue() <= dPorcetajeAprobacionMedio ) {
                    resultadoAprobacion = mensajeAprobacion;
                }
                else if ((factorDesde04.doubleValue() > dPorcetajeAprobacionMedio)
                		&& (solicitudEncabezado.getPromedioEdad() >  iPromedioEdad) ) {
                    resultadoAprobacion = mensajeAprobacion;
                }
                else {
                    resultadoAprobacion = mensajeRechazo;
                }

            }
            //Tipificacion Alto y Muy Alto
            else  {
                if (factorDesde03.doubleValue() <= dPorcetajeAprobacionAlto) {
                    resultadoAprobacion = mensajeAprobacion;
                }
                else {
                    resultadoAprobacion = mensajeRechazo;
                }
            }
            solicitudEncabezado.setAprobacion(resultadoAprobacion);

            SolicitudBuroGeneralOV peticionResultadoFinal = new SolicitudBuroGeneralOV();
            peticionResultadoFinal.setSolicitud(peticion.getSolicitud().trim());
            peticionResultadoFinal.setValorTipificacion(solicitudEncabezado.getValorTipificacion().trim());
            peticionResultadoFinal.setPromedioEdad(solicitudEncabezado.getPromedioEdad());
            peticionResultadoFinal.setPorcentajeCuentas1(dfactorDesde03);
            peticionResultadoFinal.setPorcentajeCuentas2(dfactorDesde04);
            peticionResultadoFinal.setResultado(resultadoAprobacion);
            SolicitudesRespuesta respuestaResultadoFinal
            	= solicitudesCredito.registrarSolicitudBuroGeneral(uid, peticionResultadoFinal);

            if (!respuestaResultadoFinal.getHeader().isEstatus()) {
				 throw new Exception(respuestaResultadoFinal.getHeader().getMensaje());
			}

			respuesta.setSolicitudesBuro(solicitudEncabezado);
		}
		catch (BncException exBuroSrv) {
			exBuroSrv.printStackTrace();
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje("Error en la llamada al servicio de buro [BncException]. "
					+ exBuroSrv.getRespuestaClave());
 	    }
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "validacionIDSolicitudBuro: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		} finally {
			FabricaConexiones.close(sesion);
		}
		return respuesta;
	}

	/**
	 * @param reporteCredito reporte del buro
	 * @return ValidaBuroDTO
	 * @throws ParseException
	 */
	public  ValidaBuroDTO obtenerDatosValidacionAnalistaDocumentalBC( ReporteCredito reporteCredito ) throws ParseException {

		DecimalFormat formateador = new DecimalFormat("$###,###,###.##");
	    SimpleDateFormat dtFormateador = new SimpleDateFormat("ddMMyyyy");
	    SimpleDateFormat dtFormateadorString = new SimpleDateFormat("dd/MM/yyyy");

		ValidaBuroDTO  buro = new ValidaBuroDTO();
		boolean hipotecario = false;
	    int hipMop = 0;
	    double hipSaldoVencido = 0;
	    boolean automotriz = false;
	    int autoMop = 0;
	    double autoSaldoVencido = 0;
	    String clavesObserv = "";

	    double maximo00 = 0;
	    double maximo01 = 0;
	    double maximo02 = 0;
	    double maximo03 = 0;
	    double maximo04 = 0;
	    double maximo05 = 0;
	    double maximo06 = 0;
	    double maximo07 = 0;
	    double maximo96 = 0;
	    double maximo97 = 0;
	    double maximo99 = 0;
	    double maximoTodas = 0;
	    Date fechaMaxima00 = dtFormateador.parse("01011900");
	    Date fechaMaxima01 = dtFormateador.parse("01011900");
	    Date fechaMaxima02 = dtFormateador.parse("01011900");
	    Date fechaMaxima03 = dtFormateador.parse("01011900");
	    Date fechaMaxima04 = dtFormateador.parse("01011900");
	    Date fechaMaxima05 = dtFormateador.parse("01011900");
	    Date fechaMaxima06 = dtFormateador.parse("01011900");
	    Date fechaMaxima07 = dtFormateador.parse("01011900");
	    Date fechaMaxima96 = dtFormateador.parse("01011900");
	    Date fechaMaxima97 = dtFormateador.parse("01011900");
	    Date fechaMaxima99 = dtFormateador.parse("01011900");
	    Date fechaMaximaTodas = dtFormateador.parse("01011900");

	    //Barrido de cuentas TL
	    if (  reporteCredito.getCuentas() != null ) {
		for (  SegmentoCuenta cuenta : reporteCredito.getCuentas() ) {
			//Formato cuentas
			cuenta.setFechaCierreCuenta(cuenta.getFechaCierreCuenta() == null ? "" : cuenta.getFechaCierreCuenta());
			cuenta.setFormaPagoActual(cuenta.getFormaPagoActual() == null ? "" : cuenta.getFormaPagoActual());
			cuenta.setFormaPagoActual(cuenta.getFormaPagoActual().isEmpty() ? "0" : cuenta.getFormaPagoActual());
			cuenta.setFormaPagoActual(cuenta.getFormaPagoActual().trim());
			cuenta.setFormaPagoActual(cuenta.getFormaPagoActual().equals("UR")
					? "00" : cuenta.getFormaPagoActual().trim());
			cuenta.setSaldoVencido(cuenta.getSaldoVencido() == null ? "" : cuenta.getSaldoVencido());
			cuenta.setSaldoVencido(cuenta.getSaldoVencido().isEmpty() ? "0" : cuenta.getSaldoVencido());
			cuenta.setSaldoVencido(cuenta.getSaldoVencido().trim().replace("+", "").replace("-", ""));
			cuenta.setSaldoActual(cuenta.getSaldoActual() == null ? "0" : cuenta.getSaldoActual());
	    	cuenta.setSaldoActual(cuenta.getSaldoActual().isEmpty() ? "0" : cuenta.getSaldoActual());
	    	cuenta.setSaldoActual(cuenta.getSaldoActual().replace("+", "").replace("-", ""));
	    	cuenta.setCreditoMaximo(cuenta.getCreditoMaximo() == null ? "0" : cuenta.getCreditoMaximo());
	    	cuenta.setCreditoMaximo(cuenta.getCreditoMaximo().isEmpty() ? "0" : cuenta.getCreditoMaximo());
	    	cuenta.setCreditoMaximo(cuenta.getCreditoMaximo().replace("+", "").replace("-", ""));
	    	cuenta.setNombreOrtogante(cuenta.getNombreOrtogante() == null ? "" : cuenta.getNombreOrtogante());
	    	Date fechaApertura = dtFormateador.parse(cuenta.getFechaAperturaCuenta());

	    	cuenta.setClaveObservacion(cuenta.getClaveObservacion() == null ? "" : cuenta.getClaveObservacion());

			double saldoVencido =  Double.parseDouble(cuenta.getSaldoVencido());
			double saldoActual =  Double.parseDouble(cuenta.getSaldoActual());
			double maximoCuenta = Double.parseDouble(cuenta.getCreditoMaximo());
			//Obtencion de cuentas agrupando por MOP
			if ( cuenta.getFormaPagoActual().equals("00")) {
				if (cuenta.getFechaCierreCuenta().isEmpty()) {
					buro.getMopUR().setNumeroCuentasAbiertas(buro.getMopUR().getNumeroCuentasAbiertas() + 1);
					buro.getMopUR().setSaldoVencidoAbiertas(buro.getMopUR().getSaldoVencidoAbiertas() + saldoVencido);
					buro.getMopUR().setSaldoActual(buro.getMopUR().getSaldoActual() + saldoActual);
					if ( maximoCuenta > maximo00) {
						maximo00 = maximoCuenta;
					}
					buro.getMopUR().setMaximoAbiertas(maximo00);
					if (fechaApertura.compareTo(fechaMaxima00) > 0) {
						fechaMaxima00 = fechaApertura;
			        }
					buro.getMopUR().setFechaApertura(dtFormateadorString.format(fechaMaxima00));
				}
			} else if ( cuenta.getFormaPagoActual().equals("01")) {
				if (cuenta.getFechaCierreCuenta().isEmpty()) {
					buro.getMop01().setNumeroCuentasAbiertas(buro.getMop01().getNumeroCuentasAbiertas() + 1);
					buro.getMop01().setSaldoVencidoAbiertas(buro.getMop01().getSaldoVencidoAbiertas() + saldoVencido);
					buro.getMop01().setSaldoActual(buro.getMop01().getSaldoActual() + saldoActual);
					if ( maximoCuenta > maximo01) {
						maximo01 = maximoCuenta;
					}
					buro.getMop01().setMaximoAbiertas(maximo01);
					if (fechaApertura.compareTo(fechaMaxima01) > 0) {
						fechaMaxima01 = fechaApertura;
			        }
					buro.getMop01().setFechaApertura(dtFormateadorString.format(fechaMaxima01));
				}
			} else if ( cuenta.getFormaPagoActual().equals("02")) {
				if (cuenta.getFechaCierreCuenta().isEmpty()) {
					buro.getMop02().setNumeroCuentasAbiertas(buro.getMop02().getNumeroCuentasAbiertas() + 1);
					buro.getMop02().setSaldoVencidoAbiertas(buro.getMop02().getSaldoVencidoAbiertas() + saldoVencido);
					buro.getMop02().setSaldoActual(buro.getMop02().getSaldoActual() + saldoActual);
					if ( maximoCuenta > maximo02) {
						maximo02 = maximoCuenta;
					}
					buro.getMop02().setMaximoAbiertas(maximo02);
					if (fechaApertura.compareTo(fechaMaxima02) > 0) {
						fechaMaxima02 = fechaApertura;
			        }
					buro.getMop02().setFechaApertura(dtFormateadorString.format(fechaMaxima02));
				}
			} else if ( cuenta.getFormaPagoActual().equals("03")) {
				if (cuenta.getFechaCierreCuenta().isEmpty()) {
					buro.getMop03().setNumeroCuentasAbiertas(buro.getMop03().getNumeroCuentasAbiertas() + 1);
					buro.getMop03().setSaldoVencidoAbiertas(buro.getMop03().getSaldoVencidoAbiertas() + saldoVencido);
					buro.getMop03().setSaldoActual(buro.getMop03().getSaldoActual() + saldoActual);
					buro.setTotalDesde03(buro.getTotalDesde03() + 1);
					if ( maximoCuenta > maximo03) {
						maximo03 = maximoCuenta;
					}
					buro.getMop03().setMaximoAbiertas(maximo03);
					if (fechaApertura.compareTo(fechaMaxima03) > 0) {
						fechaMaxima03 = fechaApertura;
			        }
					buro.getMop03().setFechaApertura(dtFormateadorString.format(fechaMaxima03));
				}
			} else if ( cuenta.getFormaPagoActual().equals("04")) {
				if (cuenta.getFechaCierreCuenta().isEmpty()) {
					buro.getMop04().setNumeroCuentasAbiertas(buro.getMop04().getNumeroCuentasAbiertas() + 1);
					buro.getMop04().setSaldoVencidoAbiertas(buro.getMop04().getSaldoVencidoAbiertas() + saldoVencido);
					buro.getMop04().setSaldoActual(buro.getMop04().getSaldoActual() + saldoActual);
					buro.setTotalDesde03(buro.getTotalDesde03() + 1);
					buro.setTotalDesde04(buro.getTotalDesde04() + 1);
					if ( maximoCuenta > maximo04) {
						maximo04 = maximoCuenta;
					}
					buro.getMop04().setMaximoAbiertas(maximo04);
					if (fechaApertura.compareTo(fechaMaxima04) > 0) {
						fechaMaxima04 = fechaApertura;
			        }
					buro.getMop04().setFechaApertura(dtFormateadorString.format(fechaMaxima04));
				}
			} else if ( cuenta.getFormaPagoActual().equals("05")) {
				if (cuenta.getFechaCierreCuenta().isEmpty()) {
					buro.getMop05().setNumeroCuentasAbiertas(buro.getMop05().getNumeroCuentasAbiertas() + 1);
					buro.getMop05().setSaldoVencidoAbiertas(buro.getMop05().getSaldoVencidoAbiertas() + saldoVencido);
					buro.getMop05().setSaldoActual(buro.getMop05().getSaldoActual() + saldoActual);
					buro.setTotalDesde03(buro.getTotalDesde03() + 1);
					buro.setTotalDesde04(buro.getTotalDesde04() + 1);
					if ( maximoCuenta > maximo05) {
						maximo05 = maximoCuenta;
					}
					buro.getMop05().setMaximoAbiertas(maximo05);
					if (fechaApertura.compareTo(fechaMaxima05) > 0) {
						fechaMaxima05 = fechaApertura;
			        }
					buro.getMop05().setFechaApertura(dtFormateadorString.format(fechaMaxima05));
				}
			} else if ( cuenta.getFormaPagoActual().equals("06")) {
				if (cuenta.getFechaCierreCuenta().isEmpty()) {
					buro.getMop06().setNumeroCuentasAbiertas(buro.getMop06().getNumeroCuentasAbiertas() + 1);
					buro.getMop06().setSaldoVencidoAbiertas(buro.getMop06().getSaldoVencidoAbiertas() + saldoVencido);
					buro.getMop06().setSaldoActual(buro.getMop06().getSaldoActual() + saldoActual);
					buro.setTotalDesde03(buro.getTotalDesde03() + 1);
					buro.setTotalDesde04(buro.getTotalDesde04() + 1);
					if ( maximoCuenta > maximo06) {
						maximo06 = maximoCuenta;
					}
					buro.getMop06().setMaximoAbiertas(maximo06);
					if (fechaApertura.compareTo(fechaMaxima06) > 0) {
						fechaMaxima06 = fechaApertura;
			        }
					buro.getMop06().setFechaApertura(dtFormateadorString.format(fechaMaxima06));
				}
			} else if ( cuenta.getFormaPagoActual().equals("07")) {
				if (cuenta.getFechaCierreCuenta().isEmpty()) {
					buro.getMop07().setNumeroCuentasAbiertas(buro.getMop07().getNumeroCuentasAbiertas() + 1);
					buro.getMop07().setSaldoVencidoAbiertas(buro.getMop07().getSaldoVencidoAbiertas() + saldoVencido);
					buro.getMop07().setSaldoActual(buro.getMop07().getSaldoActual() + saldoActual);
					buro.setTotalDesde03(buro.getTotalDesde03() + 1);
					buro.setTotalDesde04(buro.getTotalDesde04() + 1);
					if ( maximoCuenta > maximo07) {
						maximo07 = maximoCuenta;
					}
					buro.getMop07().setMaximoAbiertas(maximo07);
					if (fechaApertura.compareTo(fechaMaxima07) > 0) {
						fechaMaxima07 = fechaApertura;
			        }
					buro.getMop07().setFechaApertura(dtFormateadorString.format(fechaMaxima07));
				}
			} else if ( cuenta.getFormaPagoActual().equals("96")) {
				if (cuenta.getFechaCierreCuenta().isEmpty()) {
					buro.getMop96().setNumeroCuentasAbiertas(buro.getMop96().getNumeroCuentasAbiertas() + 1);
					buro.getMop96().setSaldoVencidoAbiertas(buro.getMop96().getSaldoVencidoAbiertas() + saldoVencido);
					buro.getMop96().setSaldoActual(buro.getMop96().getSaldoActual() + saldoActual);
					buro.setTotalDesde03(buro.getTotalDesde03() + 1);
					buro.setTotalDesde04(buro.getTotalDesde04() + 1);
					if ( maximoCuenta > maximo96) {
						maximo96 = maximoCuenta;
					}
					buro.getMop96().setMaximoAbiertas(maximo96);
					if (fechaApertura.compareTo(fechaMaxima96) > 0) {
						fechaMaxima96 = fechaApertura;
			        }
					buro.getMop96().setFechaApertura(dtFormateadorString.format(fechaMaxima96));
				}
			} else if ( cuenta.getFormaPagoActual().equals("97")) {
				if (cuenta.getFechaCierreCuenta().isEmpty()) {
					buro.getMop97().setNumeroCuentasAbiertas(buro.getMop97().getNumeroCuentasAbiertas() + 1);
					buro.getMop97().setSaldoVencidoAbiertas(buro.getMop97().getSaldoVencidoAbiertas() + saldoVencido);
					buro.getMop97().setSaldoActual(buro.getMop97().getSaldoActual() + saldoActual);
					buro.setTotalDesde03(buro.getTotalDesde03() + 1);
					buro.setTotalDesde04(buro.getTotalDesde04() + 1);
					if ( maximoCuenta > maximo97) {
						maximo97 = maximoCuenta;
					}
					buro.getMop97().setMaximoAbiertas(maximo97);
					if (fechaApertura.compareTo(fechaMaxima97) > 0) {
						fechaMaxima97 = fechaApertura;
			        }
					buro.getMop99().setFechaApertura(dtFormateadorString.format(fechaMaxima97));
				}
			} else if ( cuenta.getFormaPagoActual().equals("99")) {
				if (cuenta.getFechaCierreCuenta().isEmpty()) {
					buro.getMop99().setNumeroCuentasAbiertas(buro.getMop99().getNumeroCuentasAbiertas() + 1);
					buro.getMop99().setSaldoVencidoAbiertas(buro.getMop99().getSaldoVencidoAbiertas() + saldoVencido);
					buro.getMop99().setSaldoActual(buro.getMop99().getSaldoActual() + saldoActual);
					buro.setTotalDesde03(buro.getTotalDesde03() + 1);
					buro.setTotalDesde04(buro.getTotalDesde04() + 1);
					if ( maximoCuenta > maximo99) {
						maximo99 = maximoCuenta;
					}
					buro.getMop99().setMaximoAbiertas(maximo99);
					if (fechaApertura.compareTo(fechaMaxima99) > 0) {
						fechaMaxima99 = fechaApertura;
			        }
					buro.getMop99().setFechaApertura(dtFormateadorString.format(fechaMaxima99));
				}
			}
			//Totales
			if (cuenta.getFechaCierreCuenta().isEmpty()) {
				buro.getTotal().setNumeroCuentasAbiertas(buro.getTotal().getNumeroCuentasAbiertas() + 1);
				buro.getTotal().setSaldoVencidoAbiertas(buro.getTotal().getSaldoVencidoAbiertas() + saldoVencido);
				buro.getTotal().setSaldoActual(buro.getTotal().getSaldoActual() + saldoActual);
				if ( maximoCuenta > maximoTodas) {
					maximoTodas = maximoCuenta;
				}
				buro.getTotal().setMaximoAbiertas(maximoTodas);
				if (fechaApertura.compareTo(fechaMaximaTodas) > 0) {
					fechaMaximaTodas = fechaApertura;
		        }
				buro.getTotal().setFechaApertura(dtFormateadorString.format(fechaMaximaTodas));
			}

			//Se verifica si trae una  cuenta hipotecario o automotriz
			//Automotriz Hipotecario
			//M - Hipoteca RE(Bienes Raices)
			//AU(Compra Automovil)
			int mopCuenta = Integer.parseInt(cuenta.getFormaPagoActual());
			if ( cuenta.getTipoCuenta().trim().equals("M") || cuenta.getTipoContrato().trim().equals("RE")
					|| cuenta.getNombreOrtogante().trim().equals("BIENES RAICES")) {
				hipotecario = true;
				if ( mopCuenta > hipMop) {
					hipMop = mopCuenta;
					hipSaldoVencido += saldoVencido;
				}
			}

			if (cuenta.getTipoContrato().trim().equals("AU") || cuenta.getNombreOrtogante().trim().equals("AUTOMOTRIZ") ) {
				automotriz = true;
				if ( mopCuenta > autoMop) {
					autoSaldoVencido += saldoVencido;
					autoMop = mopCuenta;
				}
			}
			// claves observacion

			String claves;
			try {
				claves = comun.obtenerParGeneral("", "LISTA_CVE_OBS");

			String[] clavesObs = claves.split(";");
			List<String> listaClavesObs = new ArrayList<String>();

			if (clavesObs.length > 0) {
				listaClavesObs = new ArrayList<String>();
					for (int j = 0; j < clavesObs.length; j++) {
						listaClavesObs.add(clavesObs[j]);
				}
			}

			if (listaClavesObs.contains(cuenta.getClaveObservacion())) {

				clavesObserv = clavesObserv.equals("") ? "" + cuenta.getClaveObservacion()
						: clavesObserv + ";" + cuenta.getClaveObservacion();

			}
			} catch (Exception e) {
				LogHandler.info("", getClass(), "No se encontro el JNDI : LISTA_CVE_OBS " );
			}

		 }

	    }
		//for cuentas

		buro.setHipotecario(hipotecario);
		buro.setHipMop(hipMop);
		buro.setHipSaldoVencido(hipSaldoVencido);
		buro.setHipDescripcion("Saldo Vencido " + formateador.format(buro.getHipSaldoVencido()));

		// claves observacion
		buro.setClavesObserv(clavesObserv.equals("") ? " " : clavesObserv );

		buro.setAutomotriz(automotriz);
		buro.setAutoMop(autoMop);
		buro.setAutoSaldoVencido(autoSaldoVencido);
		buro.setAutoDescripcion("Saldo Vencido " + formateador.format(buro.getAutoSaldoVencido()));

		//Manipulacion para el front
		buro.setFrontTitulos("<div>CA</div>"
						+	 "<div>SVA</div>"
						+	 "<div>SA</div>"
						+	 "<div>SAMA</div>"
						+	 "<div>FA</div>"
							);
		buro.setFrontMopUR( "<div>" +  buro.getMopUR().getNumeroCuentasAbiertas() +  "</div>"
						+   "<div>" +  formateador.format(buro.getMopUR().getSaldoVencidoAbiertas()) +  "</div>"
						+   "<div>" +  formateador.format(buro.getMopUR().getSaldoActual()) +  "</div>"
						+   "<div>" +  formateador.format(buro.getMopUR().getMaximoAbiertas()) +  "</div>"
						+   "<div>" +  buro.getMopUR().getFechaApertura() + "</div>");
		buro.setFrontMop01( "<div>" +  buro.getMop01().getNumeroCuentasAbiertas() +  "</div>"
						+   "<div>" +  formateador.format(buro.getMop01().getSaldoVencidoAbiertas()) +  "</div>"
						+   "<div>" +  formateador.format(buro.getMop01().getSaldoActual()) +  "</div>"
						+   "<div>" +  formateador.format(buro.getMop01().getMaximoAbiertas()) +  "</div>"
						+   "<div>" +  buro.getMop01().getFechaApertura() + "</div>");
		buro.setFrontMop02( "<div>" +  buro.getMop02().getNumeroCuentasAbiertas()  +  "</div>"
						+   "<div>" +  formateador.format( buro.getMop02().getSaldoVencidoAbiertas()) +  "</div>"
						+   "<div>" +  formateador.format(buro.getMop02().getSaldoActual()) +  "</div>"
						+   "<div>" +  formateador.format(buro.getMop02().getMaximoAbiertas()) +  "</div>"
						+   "<div>" +  buro.getMop02().getFechaApertura() + "</div>");
		buro.setFrontMop03( "<div>" +  buro.getMop03().getNumeroCuentasAbiertas() + "</div>"
						+	"<div>" +  formateador.format(buro.getMop03().getSaldoVencidoAbiertas()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop03().getSaldoActual()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop03().getMaximoAbiertas()) + "</div>"
						+	"<div>" +  buro.getMop03().getFechaApertura() + "</div>");
		buro.setFrontMop04( "<div>" +  buro.getMop04().getNumeroCuentasAbiertas() + "</div>"
						+	"<div>" +  formateador.format(buro.getMop04().getSaldoVencidoAbiertas()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop04().getSaldoActual()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop04().getMaximoAbiertas()) + "</div>"
						+	"<div>" +  buro.getMop04().getFechaApertura() + "</div>");
		buro.setFrontMop05( "<div>" +  buro.getMop05().getNumeroCuentasAbiertas() + "</div>"
						+	"<div>" +  formateador.format(buro.getMop05().getSaldoVencidoAbiertas()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop05().getSaldoActual()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop05().getMaximoAbiertas()) + "</div>"
						+	"<div>" +  buro.getMop05().getFechaApertura() + "</div>");
		buro.setFrontMop06( "<div>" +  buro.getMop06().getNumeroCuentasAbiertas() + "</div>"
						+	"<div>" +  formateador.format(buro.getMop06().getSaldoVencidoAbiertas()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop06().getSaldoActual()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop06().getMaximoAbiertas()) + "</div>"
						+	"<div>" +  buro.getMop06().getFechaApertura() + "</div>");
		buro.setFrontMop07( "<div>" +  buro.getMop07().getNumeroCuentasAbiertas() + "</div>"
						+	"<div>" +  formateador.format(buro.getMop07().getSaldoVencidoAbiertas()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop07().getSaldoActual()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop07().getMaximoAbiertas()) + "</div>"
						+	"<div>" +  buro.getMop07().getFechaApertura() + "</div>");
		buro.setFrontMop96( "<div>" +  buro.getMop96().getNumeroCuentasAbiertas() + "</div>"
						+	"<div>" +  formateador.format(buro.getMop96().getSaldoVencidoAbiertas()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop96().getSaldoActual()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop96().getMaximoAbiertas()) + "</div>"
						+	"<div>" +  buro.getMop96().getFechaApertura() + "</div>");
		buro.setFrontMop97( "<div>" +  buro.getMop97().getNumeroCuentasAbiertas() + "</div>"
						+	"<div>" +  formateador.format(buro.getMop97().getSaldoVencidoAbiertas()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop97().getSaldoActual()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop97().getMaximoAbiertas()) + "</div>"
						+	"<div>" +  buro.getMop97().getFechaApertura() + "</div>");
		buro.setFrontMop99( "<div>" +  buro.getMop99().getNumeroCuentasAbiertas() + "</div>"
						+	"<div>" +  formateador.format(buro.getMop99().getSaldoVencidoAbiertas()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop99().getSaldoActual()) + "</div>"
						+	"<div>" +  formateador.format(buro.getMop99().getMaximoAbiertas()) + "</div>"
						+	"<div>" +  buro.getMop99().getFechaApertura() + "</div>");
		buro.setFrontTotal( "<div>" +  buro.getTotal().getNumeroCuentasAbiertas() + "</div>"
						+	"<div>" +  formateador.format(buro.getTotal().getSaldoVencidoAbiertas()) + "</div>"
						+	"<div>" +  formateador.format(buro.getTotal().getSaldoActual()) + "</div>"
						+	"<div>" +  formateador.format(buro.getTotal().getMaximoAbiertas()) + "</div>"
						+	"<div>" +  buro.getTotal().getFechaApertura() + "</div>");


		//Manipulacion para el front para Exportar
				buro.setFrontTitulosExportar(	 "CA¬"
											+	 "SVA¬"
											+	 "SA¬"
											+	 "SAMA¬"
											+	 "FA");
				buro.setFrontMopURExportar( buro.getMopUR().getNumeroCuentasAbiertas() +  "¬"
											+  buro.getMopUR().getSaldoVencidoAbiertas() +  "¬"
											+  buro.getMopUR().getSaldoActual() +  "¬"
											+  buro.getMopUR().getMaximoAbiertas() +  "¬"
											+  buro.getMopUR().getFechaApertura());
				buro.setFrontMop01Exportar( buro.getMop01().getNumeroCuentasAbiertas() +  "¬"
											+   buro.getMop01().getSaldoVencidoAbiertas() +  "¬"
											+   buro.getMop01().getSaldoActual() +  "¬"
											+   buro.getMop01().getMaximoAbiertas() +  "¬"
											+   buro.getMop01().getFechaApertura());
				buro.setFrontMop02Exportar( buro.getMop02().getNumeroCuentasAbiertas()  +  "¬"
											+   buro.getMop02().getSaldoVencidoAbiertas() +  "¬"
											+   buro.getMop02().getSaldoActual() +  "¬"
											+   buro.getMop02().getMaximoAbiertas() +  "¬"
											+   buro.getMop02().getFechaApertura());
				buro.setFrontMop03Exportar( buro.getMop03().getNumeroCuentasAbiertas() + "¬"
											+	buro.getMop03().getSaldoVencidoAbiertas() + "¬"
											+	buro.getMop03().getSaldoActual() + "¬"
											+	buro.getMop03().getMaximoAbiertas() + "¬"
											+	buro.getMop03().getFechaApertura());
				buro.setFrontMop04Exportar( buro.getMop04().getNumeroCuentasAbiertas() + "¬"
											+	buro.getMop04().getSaldoVencidoAbiertas() + "¬"
											+	buro.getMop04().getSaldoActual() + "¬"
											+	buro.getMop04().getMaximoAbiertas() + "¬"
											+	buro.getMop04().getFechaApertura());
				buro.setFrontMop05Exportar( buro.getMop05().getNumeroCuentasAbiertas() + "¬"
											+	buro.getMop05().getSaldoVencidoAbiertas() + "¬"
											+	buro.getMop05().getSaldoActual() + "¬"
											+	buro.getMop05().getMaximoAbiertas() + "¬"
											+	buro.getMop05().getFechaApertura());
				buro.setFrontMop06Exportar( buro.getMop06().getNumeroCuentasAbiertas() + "¬"
											+	buro.getMop06().getSaldoVencidoAbiertas() + "¬"
											+	buro.getMop06().getSaldoActual() + "¬"
											+	buro.getMop06().getMaximoAbiertas() + "¬"
											+	buro.getMop06().getFechaApertura());
				buro.setFrontMop07Exportar( buro.getMop07().getNumeroCuentasAbiertas() + "¬"
											+ buro.getMop07().getSaldoVencidoAbiertas() + "¬"
											+ buro.getMop07().getSaldoActual() + "¬"
											+ buro.getMop07().getMaximoAbiertas() + "¬"
											+ buro.getMop07().getFechaApertura());
				buro.setFrontMop96Exportar( buro.getMop96().getNumeroCuentasAbiertas() + "¬"
											+	buro.getMop96().getSaldoVencidoAbiertas() + "¬"
											+	buro.getMop96().getSaldoActual() + "¬"
											+	buro.getMop96().getMaximoAbiertas() + "¬"
											+	buro.getMop96().getFechaApertura());
				buro.setFrontMop97Exportar( buro.getMop97().getNumeroCuentasAbiertas() + "¬"
											+	buro.getMop97().getSaldoVencidoAbiertas() + "¬"
											+	buro.getMop97().getSaldoActual() + "¬"
											+	buro.getMop97().getMaximoAbiertas() + "¬"
											+	buro.getMop97().getFechaApertura());
				buro.setFrontMop99Exportar( buro.getMop99().getNumeroCuentasAbiertas() + "¬"
											+	buro.getMop99().getSaldoVencidoAbiertas() + "¬"
											+	buro.getMop99().getSaldoActual() + "¬"
											+	buro.getMop99().getMaximoAbiertas() + "¬"
											+	buro.getMop99().getFechaApertura());
				buro.setFrontTotalExportar( buro.getTotal().getNumeroCuentasAbiertas() + "¬"
											+	buro.getTotal().getSaldoVencidoAbiertas() + "¬"
											+	buro.getTotal().getSaldoActual() + "¬"
											+	buro.getTotal().getMaximoAbiertas() + "¬"
											+	buro.getTotal().getFechaApertura());
		return buro;
	}

	/***********************************Esta parte es para originacion ********************************/
	/**
	 * metodo que se encarga de la validacion de buro de la parte de originacion
	 * @param uid Identificador de Transaccion
	 * @param peticion de consulta
	 * @return ConsultaBuroRespuesta
	 */
	@SuppressWarnings("unchecked")
	public ValidaSolicitudRespuesta validacionSolicitudBuroOriginacion(String uid, ValidaSolicitudPeticion peticion) {
		ValidaSolicitudRespuesta respuesta = new ValidaSolicitudRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensaje("CUMPLE REQUISITOS BURO");
		List<String> integrantesNuevos = null;
		SqlSession sessionNTx	= null;
		int cicloGrupal = 0;
		int diasAtraso = 0;
		int numIntegrantesNuevos = 0;
		int integranteSiNuevos = 0;
		try {
			if (peticion == null || peticion.getSolicitud() == null
					|| peticion.getSolicitud().trim().isEmpty()) {
				throw new Exception("El ID de la solicitud en la peticion es necesaria.");
			}
			if (peticion.getIntegrantes() == null ) {
				throw new Exception("La peticion debe de tener al menos un integrante.");
			}
			if (peticion.getIntegrantes().isEmpty()) {
				throw new Exception("La peticion debe de tener al menos un integrante.");
			}

			//Se abre la session No transaccional sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(), "validacionSolicitudBuroOriginacion: - obtenerParGeneral");
			ParGeneralOV urlBuro = comun.obtenerParGeneralOV(uid, "BURO_URL");
					//(ParGeneralOV)	sessionNTx.selectOne("obtenerParGeneral", "BURO_URL");
			if (urlBuro == null || urlBuro.getCgValor().trim().isEmpty()) {
					throw new Exception("No fue posible obtener la URL del servicio de buro.");
			}
			ServicioBuroCreditoProxy ws = new ServicioBuroCreditoProxy();
			ws.setEndpoint(urlBuro.getCgValor().trim());

			//Obtenemos datos de la solicitud anterior: ciclo grupal, express, contrato anterior,
			//numero de persona de cada integrante, maximo atraso y atraso fecha fin
			List<HashMap<String, Object>> datosSolicitud
				= (List<HashMap<String, Object>>) sessionNTx.selectList("obtieneExpressSolicitud", peticion.getSolicitud());

			if (datosSolicitud == null || datosSolicitud.isEmpty() || datosSolicitud.size() == 0 ) {
					throw new Exception("No fue posible obtener los datos de la solicitud.");
			}

			cicloGrupal = Integer.parseInt(datosSolicitud.get(0).get("cicloGrupal").toString());
			LogHandler.info(uid, getClass(), "validacionSolicitudBuroOriginacion: - cicloGrupal: " + cicloGrupal);

			//validaciones para renovacion
			if (cicloGrupal > 0) {
				//obtenemos los dias de atraso del contrato anterior si es una renovacion

				LogHandler.info(uid, getClass(), "validacionSolicitudBuroOriginacion: - cotrato anterior : "
				+ datosSolicitud.get(0).get("contratoAnterior").toString());

				// esto es para los dias mora
			      diasAtraso = (Integer) sessionNTx
			    		  .selectOne("diasMoraBuroCredito", datosSolicitud.get(0).get("contratoAnterior").toString());

				LogHandler.info(uid, getClass(), "validacionSolicitudBuroOriginacion: - diasAtraso: " + diasAtraso);

				List<String> integranteAnteriores = new ArrayList<String>();
				for (HashMap<String, Object> persona: datosSolicitud) {
					integranteAnteriores.add(persona.get("integrante").toString().trim());
				}

				//obtenemos a los integernates de la solicitud  nueva
				List<String> integrantesActuales = (List<String>)
						sessionNTx.selectList("obtenerIntegrantesSolicitudActual", peticion.getSolicitud());

				if (integrantesActuales == null || integrantesActuales.isEmpty() || integrantesActuales.size() == 0 ) {
					throw new Exception("No fue posible obtener los integrantes de la solicitud actual.");
			    }

				integrantesNuevos = new ArrayList<String>();
				//Llenar lista con integrantes nuevos
				for (String persona: integrantesActuales) {
					 LogHandler.info(uid, getClass(), "validacionSolicitudBuroOriginacion: - persona: " + persona);
					if (!integranteAnteriores.contains(persona.trim())) {
						integrantesNuevos.add(persona.trim());
					} else {
						integranteSiNuevos++;
					}
				}
				peticion.setMismosIntegrantes(integranteSiNuevos);
				LogHandler.info(uid, getClass(), "validacionSolicitudBuroOriginacion: - integrantesNuevos: " + integrantesNuevos);

				if (integrantesNuevos.size() > 0) {
					numIntegrantesNuevos = integrantesNuevos.size();
				}
				LogHandler.info(uid, getClass(), "validacionSolicitudBuroOriginacion: - numIntegrantesNuevos: "
				+ numIntegrantesNuevos);

			}


			SolicitudBuroOV peticionRegistoBuro = new SolicitudBuroOV();
			peticionRegistoBuro.setSolicitud(peticion.getSolicitud());

			List<SolicitudBuroClienteOV> integrantes = new ArrayList<SolicitudBuroClienteOV>();

			//SE valida que todos los clientes tengan consulta al buro.
			for ( IntegranteSolicitud integrante : peticion.getIntegrantes()) {
				SolicitudBuroClienteOV buroCliente = new SolicitudBuroClienteOV();
				if ( integrante.getPersona() == null || integrante.getPersona().trim().isEmpty() ) {
					throw new Exception("Un intengrante de la peticion no tiene numero de persona, es obligatorio.");
				}

	     		ObtenerXMLReporteCreditoRequest request = new ObtenerXMLReporteCreditoRequest();
	     		ObtenerXMLReporteCreditoResponse response = new ObtenerXMLReporteCreditoResponse();
	     		request.setPersona(integrante.getPersona().trim());
	     		//Obtenemos la ultima consulta al buro (sin costo)
	     		//LogHandler.info(uid, getClass(), "*********" + integrante.getPersona());
	     		response = ws.obtenerXMLReporteCredito(request);
	     		if ( response == null || response.getXMLReporteCredito().trim().isEmpty()) {
	     			throw new Exception("El cliente " + integrante.getPersona() + " no tiene consulta al buro.");
	     		}
	     		//LogHandler.info(uid, getClass(), "*********" + response.getXMLReporteCredito());

	    		ReporteCredito reporteCredito = obtenerObjetoBCN(response.getXMLReporteCredito());

	    		buroCliente.setSolicitud(peticion.getSolicitud());
	    		buroCliente.setPersona(integrante.getPersona().trim());
	    		//Obtenemos el folio de la consulta al buro
	    		String folioBuro = reporteCredito.getSegmentoFin().getNumeroControlConsulta();
	    		if (folioBuro.startsWith("0009")) {
	    			folioBuro = folioBuro.substring(LONGITUD_FOLIO_BURO);
	    		}
	    		buroCliente.setFolioConsultaBuro(folioBuro);
	    		integrantes.add(buroCliente);
			}

    		peticionRegistoBuro.setIntegrantes(integrantes);

    		//Almacenamos en BD la relacion entre solicitud, integrante y folio consulta buro en credprod_finsol.solicitud_buro
			SolicitudBuroRespuesta respuestaRegistroBuro
			 = solicitudesCredito.registrarSolicitudBuroTarea(uid, peticionRegistoBuro);
			//Verificamos que sea correcto el almacenado
			if (!respuestaRegistroBuro.getHeader().isEstatus()) {
				 throw new Exception(respuestaRegistroBuro.getHeader().getMensaje());
			}
			LogHandler.info(uid, getClass(), "validacionSolicitudBurOriginacion: registrarSolicitudBuroTarea correcta");

			//Verificamos si la solicitud es express
			if ( datosSolicitud.get(0).get("express").toString().trim().equals("S") ) {
				LogHandler.info(uid, getClass(), "validacionSolicitudBurOriginacion: EXPRESS");
				//Es una solicitud express
				//ConsultaSolicitudBuroRespuesta respuestaValidacion = validacionSolicitudExpress(uid, peticion);

				//RENOVACIONES EXPRESS MEJORA (nueva version)
				//La version en que ya se quitaron las reglas de buro segunda fase.
				ConsultaSolicitudBuroRespuesta respuestaValidacion = validacionSolicitudExpressMejora(uid, peticion);

				if (!respuestaValidacion.getHeader().isEstatus()) {
					respuesta.getHeader().setCodigo(respuestaValidacion.getHeader().getCodigo());
					 throw new Exception(respuestaValidacion.getHeader().getMensaje());
				}
				respuesta.setIncrementos(respuestaValidacion.getIncrementos());
			}
			else {
				//La solicitud NO es express
				//validaciones que se agrega, para ciclos mayores a cero
				ConsultaSolicitudBuroRespuesta respuestaValidacion = null;
				if (cicloGrupal == 0) {
					respuestaValidacion = validacionIDSolicitudBurOriginacion(uid, peticion, null);
				} else {
					peticion.setIntegrantesNuevos(numIntegrantesNuevos);
					peticion.setDiasMora(diasAtraso);
					if (numIntegrantesNuevos == 0) {
						if (diasAtraso <= Constantes.DIAS_MORA_BURO) {
							 peticion.setRegresaRespuesta(true);
							 respuestaValidacion = validacionIDSolicitudBurOriginacion(uid, peticion, null);
						} else {
							respuestaValidacion = validacionIDSolicitudBurOriginacion(uid, peticion, null);
						}
					} else {
						// en esta parte hay que dar priordad al descarte de los nuevos
						if (diasAtraso <= Constantes.DIAS_MORA_BURO) {
							respuestaValidacion = validacionIDSolicitudBurOriginacion(uid, peticion, integrantesNuevos);
						} else {
							respuestaValidacion = validacionIDSolicitudBurOriginacion(uid, peticion, null);
						}
					}
				}

				if (!respuestaValidacion.getHeader().isEstatus()) {
                     respuesta.setValidacionBC(respuestaValidacion.isValidacionBC());
                     respuesta.getHeader().setEstatus(false);
					 respuesta.getHeader().setMensaje(respuestaValidacion.getHeader().getMensaje());
					 respuesta.setIntegrantes(respuestaValidacion.getIntegrantes());
					 return respuesta;
				}
			}
		}
		catch (BncException exBuroSrv) {
			exBuroSrv.printStackTrace();
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje("Error en la llamada al servicio de buro [BncException]. "
					+ exBuroSrv.getRespuestaClave());
 	    }
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "validacionSolicitudBurOriginacion: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return respuesta;
	}

	/**
	 * @param uid Identificador de Transaccion
	 * @param peticion de consulta
	 * @param integrantesNuevos integrantes nuevos
	 * @return ConsultaBuroRespuesta
	 */
	@SuppressWarnings("unchecked")
	public ConsultaSolicitudBuroRespuesta validacionIDSolicitudBurOriginacion(String uid, ValidaSolicitudPeticion peticion,
			List<String> integrantesNuevos) {
		ConsultaSolicitudBuroRespuesta respuesta = new ConsultaSolicitudBuroRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		respuesta.setValidacionBC(false);  // no se prende el boton de validacion BC
		String mensajeAprobacion = "CUMPLE REQUISITOS BURO";
		respuesta.getHeader().setMensaje(mensajeAprobacion);
		List<SolicitudBuroClienteOV> integrantesNuevosBuro = null;
		int integrantesAnteriores = 0;
		SqlSession sesion = null;

		try {
			if (peticion == null || peticion.getSolicitud() == null
					|| peticion.getSolicitud().trim().isEmpty()) {
				throw new Exception("El ID de la solicitud en la peticion es necesaria.");
			}

			ParGeneralOV parGeneral =  comun.obtenerParGeneralOV(uid, "COMESINMIN");
			int minIntTres = Integer.parseInt(parGeneral.getCgValor()); //3
			LogHandler.info(uid, getClass(), "validacionIDSolicitudBurOriginacion: minIntTres " + minIntTres);

			SolicitudBuroOV solicitudEncabezado = new SolicitudBuroOV();
			solicitudEncabezado.setSolicitud(peticion.getSolicitud().trim());
			//este metodo nos regresa la sucursal, ciclo, nombre del grupo, fechaSolicitud, fechaDesembolso,
			//estatus , descripcionEstatus, nombresucursall, valorTipificacion, tipificacionSucursal y motivoCancelacion
			EncabezadoSolicitudRespuesta respuestaEncabezado
				= solicitudesCredito.obtenerDatosSolicitudEncabezadoTarea(uid, solicitudEncabezado);
			if (!respuestaEncabezado.getHeader().isEstatus()) {
				 throw new Exception(respuestaEncabezado.getHeader().getMensaje());
			}

			solicitudEncabezado.setCiclo(respuestaEncabezado.getSolicitudEncabezado().getCiclo());
			solicitudEncabezado.setNombreSucursal(respuestaEncabezado.getSolicitudEncabezado().getNombreSucursal().trim());
			solicitudEncabezado.setNombre(respuestaEncabezado.getSolicitudEncabezado().getNombre());
			solicitudEncabezado.setValorTipificacion(respuestaEncabezado.getSolicitudEncabezado().getValorTipificacion());
			solicitudEncabezado.setTipificacionSucursal(respuestaEncabezado.getSolicitudEncabezado().getTipificacionSucursal());
			solicitudEncabezado.setEstatus(respuestaEncabezado.getSolicitudEncabezado().getEstatus());
			solicitudEncabezado.setIntegrantesOrigenCampana(
					respuestaEncabezado.getSolicitudEncabezado().getIntegrantesOrigenCampana());
			solicitudEncabezado.setMotivoCancelacion(respuestaEncabezado.getSolicitudEncabezado().getMotivoCancelacion());
			solicitudEncabezado.setClientesNuevoGrupo(respuestaEncabezado.getSolicitudEncabezado().getClientesNuevoGrupo());
			solicitudEncabezado.setClientesCicloAnterior(respuestaEncabezado.getSolicitudEncabezado().getClientesCicloAnterior());
			solicitudEncabezado.setTipoSucursal(respuestaEncabezado.getSolicitudEncabezado().getTipoSucursal());
			solicitudEncabezado.setMotivoJustificacion(respuestaEncabezado.getSolicitudEncabezado().getMotivoJustificacion());

			solicitudEncabezado.setIntegrantesNuevos(peticion.getIntegrantesNuevos());
			solicitudEncabezado.setIntegrantesOriginales(peticion.getMismosIntegrantes());
			solicitudEncabezado.setCampana(respuestaEncabezado.getSolicitudEncabezado().getCampana());

			int ciclo = Integer.parseInt(solicitudEncabezado.getCiclo());
			String campana = solicitudEncabezado.getCampana() == null ? "" : solicitudEncabezado.getCampana().trim();

//caso especial cuando no hay nuevos y es una renovacion
			if (peticion.isRegresaRespuesta() && peticion.getIntegrantesNuevos() == 0) {
				// validar el numero de integrantes segun el ciclo si no cumple se rechaza al grupo
	             if (ciclo > 0 && peticion.getMismosIntegrantes() < Constantes.INTEGRANTE_CICLO_DOS
	            		 && !campana.equals(Constantes.CAMPANA_CINCO)) {
	            	respuesta.getHeader().setEstatus(false);
	            	respuesta.getHeader().setMensaje("El grupo no cumple con el mínimo de integrantes solicitados."
	            			+ " Deben ser por lo menos 7 integrantes.");
	            	return respuesta;
	            }  else if (ciclo > 0 && peticion.getMismosIntegrantes() < minIntTres
	            		 && campana.equals(Constantes.CAMPANA_CINCO)) {
	            	respuesta.getHeader().setEstatus(false);
	            	respuesta.getHeader().setMensaje("El grupo no cumple con el mínimo de integrantes solicitados."
	            			+ " Deben ser por lo menos 3 integrantes.");
	            }
				return respuesta;
			}
// fin del caso especial

			if (integrantesNuevos == null) {
			   solicitudEncabezado.setListaNuevos(true);
			} else {
				solicitudEncabezado.setListaNuevos(false);
			}

			LogHandler.info(uid, getClass(), "validacionIDSolicitudBurOriginacion: respuestaFolioBuro correcta");

			sesion = FabricaConexiones.obtenerSesionNTx();

			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put( "solicitud" , peticion.getSolicitud().trim());
			parametros.put( "status" , "A");
			//Se obtiene la consulta a solicitud_buro donde obtenemos solicitud actual, no.persona, folioBuro, status,
			//nombre completo, fecha nacimiento, ciclo, edad, rol, motivocancelacion, contrato anterior de cada integrante
			LogHandler.trace(uid, getClass(), "==> validacionIDSolicitudBurOriginacion - obtenerSolicitudBuro");
			List<SolicitudBuroClienteOV> integranteSolicitudActual
				= (List<SolicitudBuroClienteOV>) sesion.selectList("obtenerSolicitudBuro", parametros);

			if (integranteSolicitudActual.isEmpty()) {
				throw new Exception(ReadProperties.mensajes.getProp("solicitudes.consulta.solicitud.buro.inexistente"));
			}

			LogHandler.trace(uid, getClass(), "validacionIDSolicitudBurOriginacion: - obtenerParGeneral");
			ParGeneralOV urlBuro = comun.obtenerParGeneralOV(uid, "BURO_URL");

			if (urlBuro == null || urlBuro.getCgValor().trim().isEmpty()) {
					throw new Exception("No fue posible obtener la URL del servicio de buro.");
			}
			ServicioBuroCreditoProxy ws = new ServicioBuroCreditoProxy();
			ws.setEndpoint(urlBuro.getCgValor().trim());

			integrantesNuevosBuro = new ArrayList<SolicitudBuroClienteOV>();

			for ( SolicitudBuroClienteOV integranteSolicitud : integranteSolicitudActual) {

				ObtenerXMLReporteCreditoPorFolioRequest request = new ObtenerXMLReporteCreditoPorFolioRequest();
				ObtenerXMLReporteCreditoPorFolioResponse response = new ObtenerXMLReporteCreditoPorFolioResponse();
				request.setFolio(integranteSolicitud.getFolioConsultaBuro().trim());
				response = ws.obtenerXMLReporteCreditoPorFolio(request);

				if (response == null ||  response.getXMLReporteCredito() == null ||  response.getXMLReporteCredito().isEmpty()) {
					throw new Exception("No se pudo obtener la consulta Buro del cliente " + integranteSolicitud.getPersona()
							+ " " + integranteSolicitud.getNombreCompleto());
				}

				ReporteCredito reporteCredito = obtenerObjetoBCN(response.getXMLReporteCredito());
				LogHandler.info(uid, getClass(), "Numero de persona a checar buro - " + integranteSolicitud.getPersona());
				LogHandler.info(uid, getClass(), "Datos Buro: " + reporteCredito);
				LogHandler.info(uid, getClass(), "--------------------- Fin Reporte Buro ---------------------- ");
				ValidaBuroDTO respuestaValidaBuro = obtenerDatosValidacionOriginacion(reporteCredito);
				integranteSolicitud.setCuentas(respuestaValidaBuro);

				//esta validacion es para renovaciones
				if (integrantesNuevos != null && integrantesNuevos.size() > 0
						&& integrantesNuevos.contains(integranteSolicitud.getPersona())) {
					integrantesNuevosBuro.add(integranteSolicitud);
				}
			}

			if (ciclo > 0) {
				integrantesAnteriores = integranteSolicitudActual.size() - integrantesNuevosBuro.size();
				LogHandler.info(uid, getClass(), "validacionIDSolicitudBuroOriginacioNuevos:"
						+ " - integrantesAnteriores: " + integrantesAnteriores);
				solicitudEncabezado.setIntegrantesOriginales(integrantesAnteriores);

				if (integrantesNuevosBuro.size() > 0) {
					integranteSolicitudActual = integrantesNuevosBuro;
				}

				LogHandler.info(uid, getClass(), "validacionIDSolicitudBuroOriginacioNuevos:"
						+ " - integrantesNuevosBuro: " + integranteSolicitudActual);
			}

			//Totales y reglas
			List<SolicitudBuroClienteOV> solicitudeSinDescartados = new ArrayList<SolicitudBuroClienteOV>();
			for ( SolicitudBuroClienteOV integranteSolicitud : integranteSolicitudActual) {
				if (!descartarIntegrante(integranteSolicitud.getPersona().trim(), peticion.getIntegrantesDescarte())) {
					solicitudEncabezado.setTotalCuentas(solicitudEncabezado.getTotalCuentas()
							+ integranteSolicitud.getCuentas().getTotal().getNumeroCuentasAbiertas());
					solicitudEncabezado.setTotalDesde03(solicitudEncabezado.getTotalDesde03()
							+ integranteSolicitud.getCuentas().getTotalDesde03());
					solicitudEncabezado.setTotalDesde04(solicitudEncabezado.getTotalDesde04()
							+ integranteSolicitud.getCuentas().getTotalDesde04());
					solicitudeSinDescartados.add(integranteSolicitud);
				}
			}

			//obtenemos nuestra lista de integrantes sin descartados
			integranteSolicitudActual = solicitudeSinDescartados;
			int numeroIntegrantes = integranteSolicitudActual.size();
			if (ciclo > 0) {
				if (integrantesNuevos != null && integrantesNuevosBuro.size() > 0) {
				   numeroIntegrantes = integranteSolicitudActual.size() +  peticion.getMismosIntegrantes();
				}
			}

			LogHandler.info(uid, getClass(), "antes del descarte numeroIntegrantes" + numeroIntegrantes);

			// validar el numero de integrantes segun el ciclo si no cumple se rechaza al grupo
	if (!campana.equals(Constantes.CAMPANA_CINCO)) {
            if (ciclo == 0 && numeroIntegrantes < Constantes.INTEGRANTE_CICLO_UNO) {
            	respuesta.getHeader().setEstatus(false);
            	respuesta.getHeader().setMensaje("El grupo queda con: " + numeroIntegrantes
                        + " no cumple regla de mínimo 8 para el ciclo 1");
            	return respuesta;
            } else if (ciclo > 0 && numeroIntegrantes < Constantes.INTEGRANTE_CICLO_DOS) {
            	respuesta.getHeader().setEstatus(false);
            	respuesta.getHeader().setMensaje("El grupo queda con: " + numeroIntegrantes
                        + " no cumple regla de mínimo 7 para ciclos iguales o mayores a 2");
            	return respuesta;
            }
	} else {
		if (numeroIntegrantes < minIntTres) {
        	respuesta.getHeader().setEstatus(false);
        	respuesta.getHeader().setMensaje("El grupo queda con: " + numeroIntegrantes
                    + " no cumple regla de mínimo 3 para la campaña 5");
        	return respuesta;
        }
	}


			//metodo que realiza las validaciones correspondientes a la automatizacion de buro
			solicitudEncabezado = descartarIntegrantes(uid, integranteSolicitudActual, solicitudEncabezado);


			int descarteObligatorio = solicitudEncabezado.getIntegrantesDescarteObligatorio().size();
			int descarteSugerido = solicitudEncabezado.getIntegrantesDescarteSugerido().size();
			int descartados = descarteObligatorio + descarteSugerido;
            numeroIntegrantes = integranteSolicitudActual.size();

            if (ciclo > 0) {
            	if (peticion.getIntegrantesNuevos() > 0  && !solicitudEncabezado.isListaNuevos()) {
            		numeroIntegrantes = integranteSolicitudActual.size() +  integrantesAnteriores;
				}
			}

            LogHandler.info(uid, getClass(), "despues del descarte numeroIntegrantes" + numeroIntegrantes);

            LogHandler.info(uid, getClass(), "------------integrantes de descarte obligatorio -----------");
            LogHandler.info(uid, getClass(), "" + solicitudEncabezado.getIntegrantesDescarteObligatorio());

            LogHandler.info(uid, getClass(), "------------integrantes de descarte sugerido -----------");
            LogHandler.info(uid, getClass(), "" + solicitudEncabezado.getIntegrantesDescarteSugerido());

            LogHandler.info(uid, getClass(), "------------integrantes que quedan-----------");
            LogHandler.info(uid, getClass(), "" + integranteSolicitudActual);

			if (descarteObligatorio > 0 || descarteSugerido > 0 ) {
				respuesta.setIntegrantes(new ArrayList<SolicitudBuroClienteOV>());
				respuesta.getIntegrantes().addAll(solicitudEncabezado.getIntegrantesDescarteObligatorio());
				respuesta.getIntegrantes().addAll(solicitudEncabezado.getIntegrantesDescarteSugerido());

				// validacion para el ciclo 1
				if (ciclo == 0) {
					//validacion campaña cinco
					if (campana.equals(Constantes.CAMPANA_CINCO)) {
						if (descarteObligatorio > 0 && descarteSugerido == 0) {
							respuesta.setValidacionBC(false);
						} else {
							respuesta.setValidacionBC(true);
						}
						respuesta.getHeader().setEstatus(false);
		            	respuesta.getHeader().setMensaje("El grupo no cumple con la validación de Buró de crédito"
								+ ". Se requiere mandar a Validación BC,  ya que para campañas 5 no se admiten integrantes"
								+ " nuevos.");
		            	return respuesta;
					} else if (numeroIntegrantes < Constantes.INTEGRANTE_CICLO_UNO) {
						if (descarteObligatorio > 0 && descarteSugerido == 0) {
							respuesta.setValidacionBC(false);
						} else {
							respuesta.setValidacionBC(true);
						}
						respuesta.getHeader().setEstatus(false);
		            	respuesta.getHeader().setMensaje("El grupo no cumple con la validación de Buró de crédito"
								+ ". Se sugiere cambiar a : " + descartados
								+ " integrantes del grupo,  "
								+ "ya que sin ellos no cumplirá el mínimo de integrantes.");
		            	return respuesta;
				    } else {
				    	if (descarteObligatorio > 0 && descarteSugerido == 0) {
							respuesta.setValidacionBC(false);
						} else {
							respuesta.setValidacionBC(true);
						}
				    	respuesta.getHeader().setEstatus(false);
		            	respuesta.getHeader().setMensaje("El grupo no cumple con la validación de Buró de crédito"
								+ ". Se sugiere eliminar a : " + descartados
								+ " integrantes del grupo ");
		            	return respuesta;
				    }
				} else if (ciclo > 0) {
					if (campana.equals(Constantes.CAMPANA_CINCO)) {
						if (descarteObligatorio > 0 && descarteSugerido == 0) {
							respuesta.setValidacionBC(false);
						} else {
							respuesta.setValidacionBC(true);
						}
						respuesta.getHeader().setEstatus(false);
		            	respuesta.getHeader().setMensaje("El grupo no cumple con la validación de Buró de crédito"
								+ ". Se requiere mandar a Validación BC,  ya que para campañas 5 no se admiten integrantes"
								+ " nuevos.");
		            	return respuesta;

					} else if (numeroIntegrantes < Constantes.INTEGRANTE_CICLO_DOS) {
						if (descarteObligatorio > 0 && descarteSugerido == 0) {
							respuesta.setValidacionBC(false);
						} else {
							respuesta.setValidacionBC(true);
						}
						respuesta.getHeader().setEstatus(false);
		            	respuesta.getHeader().setMensaje("El grupo no cumple con la validación de Buró de crédito"
								+ ". Se sugiere cambiar a : " + descartados
								+ " integrantes del grupo, "
								+ "ya que sin ellos no cumplirá el mínimo de integrantes.");
		            	return respuesta;
				    } else {
				    	if (descarteObligatorio > 0 && descarteSugerido == 0) {
							respuesta.setValidacionBC(false);
						} else {
							respuesta.setValidacionBC(true);
						}
				    	respuesta.getHeader().setEstatus(false);
		            	respuesta.getHeader().setMensaje("El grupo no cumple con la validación de Buró de crédito"
								+ ". Se sugiere eliminar a : " + descartados
								+ " integrantes del grupo.");
		            	return respuesta;
				    }
				}
			}

            SolicitudBuroGeneralOV peticionResultadoFinal = new SolicitudBuroGeneralOV();
            peticionResultadoFinal.setSolicitud(peticion.getSolicitud().trim());
            peticionResultadoFinal.setValorTipificacion(solicitudEncabezado.getValorTipificacion().trim());
            peticionResultadoFinal.setPromedioEdad(solicitudEncabezado.getPromedioEdad());
            peticionResultadoFinal.setPorcentajeCuentas1(solicitudEncabezado.getFactorDesde03());
            peticionResultadoFinal.setPorcentajeCuentas2(solicitudEncabezado.getFactorDesde04());
            peticionResultadoFinal.setResultado(solicitudEncabezado.getAprobacion());
            SolicitudesRespuesta respuestaResultadoFinal
            	= solicitudesCredito.registrarSolicitudBuroGeneral(uid, peticionResultadoFinal);

            if (!respuestaResultadoFinal.getHeader().isEstatus()) {
				 throw new Exception(respuestaResultadoFinal.getHeader().getMensaje());
			}

			respuesta.setSolicitudesBuro(solicitudEncabezado);
		}
		catch (BncException exBuroSrv) {
			exBuroSrv.printStackTrace();
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje("Error en la llamada al servicio de buro [BncException]. "
					+ exBuroSrv.getRespuestaClave());
 	    }
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "validacionIDSolicitudBurOriginacion: " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sesion);
		}
		return respuesta;
	}

    /**
     * metodo para la parte de validacion de buro y sus mops
	 * @param reporteCredito reporte del buro
	 * @return ValidaBuroDTO
	 * @throws Exceptio
	 */
public  ValidaBuroDTO obtenerDatosValidacionOriginacion(ReporteCredito reporteCredito ) throws Exception {

	DecimalFormat formateador = new DecimalFormat("$###,###,###.##");
    SimpleDateFormat dtFormateador = new SimpleDateFormat("ddMMyyyy");
    SimpleDateFormat dtFormateadorString = new SimpleDateFormat("dd/MM/yyyy");

	ValidaBuroDTO  buro = new ValidaBuroDTO();
	boolean hipotecario = false;
    int hipMop = 0;
    double hipSaldoVencido = 0;
    boolean automotriz = false;
    int autoMop = 0;
    double autoSaldoVencido = 0;
    String clavesObserv = "";

    double maximo00 = 0;
    double maximo01 = 0;
    double maximo02 = 0;
    double maximo03 = 0;
    double maximo04 = 0;
    double maximo05 = 0;
    double maximo06 = 0;
    double maximo07 = 0;
    double maximo96 = 0;
    double maximo97 = 0;
    double maximo99 = 0;
    double maximoTodas = 0;
    Date fechaMaxima00 = dtFormateador.parse("01011900");
    Date fechaMaxima01 = dtFormateador.parse("01011900");
    Date fechaMaxima02 = dtFormateador.parse("01011900");
    Date fechaMaxima03 = dtFormateador.parse("01011900");
    Date fechaMaxima04 = dtFormateador.parse("01011900");
    Date fechaMaxima05 = dtFormateador.parse("01011900");
    Date fechaMaxima06 = dtFormateador.parse("01011900");
    Date fechaMaxima07 = dtFormateador.parse("01011900");
    Date fechaMaxima96 = dtFormateador.parse("01011900");
    Date fechaMaxima97 = dtFormateador.parse("01011900");
    Date fechaMaxima99 = dtFormateador.parse("01011900");
    Date fechaMaximaTodas = dtFormateador.parse("01011900");

 // claves observacion para el mop 99
		String claves;
		double montoSaldosVencidos = 0;
		List<String> listaClavesObs = new ArrayList<String>();
		try {
			claves = comun.obtenerParGeneral("", "LISTA_CVE_OBS");
			montoSaldosVencidos = Double.parseDouble(comun.obtenerParGeneralOV("", "VABU_SAVE").getCgValor());
			LogHandler.info("", getClass(), "obtenerDatosValidacionOriginacion: - "
								+ "claves:  " + claves + "\tmontoSaldosVencidos: " + montoSaldosVencidos);

			String[] clavesObs = claves.split(";");

			if (clavesObs.length > 0) {
				for (int j = 0; j < clavesObs.length; j++) {
					listaClavesObs.add(clavesObs[j]);
				}
			}
			LogHandler.info("", getClass(), "obtenerDatosValidacionOriginacion: - "
					+ "claves:  " + listaClavesObs);
		} catch (Exception e) {
			LogHandler.error("", getClass(), "No se encontro el JNDI : LISTA_CVE_OBS O VABU_SAVE ", e);
			throw new Exception("No se encontro el JNDI : LISTA_CVE_OBS O VABU_SAVE");
		}

    //Barrido de cuentas TL
    if ( reporteCredito.getCuentas() != null ) {
	for (  SegmentoCuenta cuenta : reporteCredito.getCuentas() ) {
		//Formato cuentas
		cuenta.setFechaCierreCuenta(cuenta.getFechaCierreCuenta() == null ? "" : cuenta.getFechaCierreCuenta());
		cuenta.setFormaPagoActual(cuenta.getFormaPagoActual() == null ? "" : cuenta.getFormaPagoActual());
		cuenta.setFormaPagoActual(cuenta.getFormaPagoActual().isEmpty() ? "0" : cuenta.getFormaPagoActual());
		cuenta.setFormaPagoActual(cuenta.getFormaPagoActual().trim());
		cuenta.setFormaPagoActual(cuenta.getFormaPagoActual().equals("UR")
				? "00" : cuenta.getFormaPagoActual().trim());
		cuenta.setSaldoVencido(cuenta.getSaldoVencido() == null ? "" : cuenta.getSaldoVencido());
		cuenta.setSaldoVencido(cuenta.getSaldoVencido().isEmpty() ? "0" : cuenta.getSaldoVencido());
		cuenta.setSaldoVencido(cuenta.getSaldoVencido().trim().replace("+", "").replace("-", ""));
		cuenta.setSaldoActual(cuenta.getSaldoActual() == null ? "0" : cuenta.getSaldoActual());
    	cuenta.setSaldoActual(cuenta.getSaldoActual().isEmpty() ? "0" : cuenta.getSaldoActual());
    	cuenta.setSaldoActual(cuenta.getSaldoActual().replace("+", "").replace("-", ""));
    	cuenta.setCreditoMaximo(cuenta.getCreditoMaximo() == null ? "0" : cuenta.getCreditoMaximo());
    	cuenta.setCreditoMaximo(cuenta.getCreditoMaximo().isEmpty() ? "0" : cuenta.getCreditoMaximo());
    	cuenta.setCreditoMaximo(cuenta.getCreditoMaximo().replace("+", "").replace("-", ""));
    	cuenta.setNombreOrtogante(cuenta.getNombreOrtogante() == null ? "" : cuenta.getNombreOrtogante());
    	Date fechaApertura = dtFormateador.parse(cuenta.getFechaAperturaCuenta());

    	cuenta.setClaveObservacion(cuenta.getClaveObservacion() == null ? "" : cuenta.getClaveObservacion());

		double saldoVencido =  Double.parseDouble(cuenta.getSaldoVencido());
		double saldoActual =  Double.parseDouble(cuenta.getSaldoActual());
		double maximoCuenta = Double.parseDouble(cuenta.getCreditoMaximo());

 if (saldoVencido >= montoSaldosVencidos) {
		//Obtencion de cuentas agrupando por MOP
		if ( cuenta.getFormaPagoActual().equals("00")) {
			if (cuenta.getFechaCierreCuenta().isEmpty()) {
				buro.getMopUR().setNumeroCuentasAbiertas(buro.getMopUR().getNumeroCuentasAbiertas() + 1);
				buro.getMopUR().setSaldoVencidoAbiertas(buro.getMopUR().getSaldoVencidoAbiertas() + saldoVencido);
				buro.getMopUR().setSaldoActual(buro.getMopUR().getSaldoActual() + saldoActual);
				if ( maximoCuenta > maximo00) {
					maximo00 = maximoCuenta;
				}
				buro.getMopUR().setMaximoAbiertas(maximo00);
				if (fechaApertura.compareTo(fechaMaxima00) > 0) {
					fechaMaxima00 = fechaApertura;
		        }
				buro.getMopUR().setFechaApertura(dtFormateadorString.format(fechaMaxima00));
			}
		} else if ( cuenta.getFormaPagoActual().equals("01")) {
			if (cuenta.getFechaCierreCuenta().isEmpty()) {
				buro.getMop01().setNumeroCuentasAbiertas(buro.getMop01().getNumeroCuentasAbiertas() + 1);
				buro.getMop01().setSaldoVencidoAbiertas(buro.getMop01().getSaldoVencidoAbiertas() + saldoVencido);
				buro.getMop01().setSaldoActual(buro.getMop01().getSaldoActual() + saldoActual);
				if ( maximoCuenta > maximo01) {
					maximo01 = maximoCuenta;
				}
				buro.getMop01().setMaximoAbiertas(maximo01);
				if (fechaApertura.compareTo(fechaMaxima01) > 0) {
					fechaMaxima01 = fechaApertura;
		        }
				buro.getMop01().setFechaApertura(dtFormateadorString.format(fechaMaxima01));
			}
		} else if ( cuenta.getFormaPagoActual().equals("02")) {
			if (cuenta.getFechaCierreCuenta().isEmpty()) {
				buro.getMop02().setNumeroCuentasAbiertas(buro.getMop02().getNumeroCuentasAbiertas() + 1);
				buro.getMop02().setSaldoVencidoAbiertas(buro.getMop02().getSaldoVencidoAbiertas() + saldoVencido);
				buro.getMop02().setSaldoActual(buro.getMop02().getSaldoActual() + saldoActual);
				//validamos si existen creditos hipotecarios mayor al mop 01
				if (cuenta.getTipoContrato().equals(Constantes.HIPOTECARIO)) {
					buro.setTotalHipotecarioMop01(buro.getTotalHipotecarioMop01() + 1);
				 }
				if ( maximoCuenta > maximo02) {
					maximo02 = maximoCuenta;
				}
				buro.getMop02().setMaximoAbiertas(maximo02);
				if (fechaApertura.compareTo(fechaMaxima02) > 0) {
					fechaMaxima02 = fechaApertura;
		        }
				buro.getMop02().setFechaApertura(dtFormateadorString.format(fechaMaxima02));
			}
		} else if ( cuenta.getFormaPagoActual().equals("03")) {
			if (cuenta.getFechaCierreCuenta().isEmpty()) {
				buro.getMop03().setNumeroCuentasAbiertas(buro.getMop03().getNumeroCuentasAbiertas() + 1);
				buro.getMop03().setSaldoVencidoAbiertas(buro.getMop03().getSaldoVencidoAbiertas() + saldoVencido);
				buro.getMop03().setSaldoActual(buro.getMop03().getSaldoActual() + saldoActual);
				buro.setTotalDesde03(buro.getTotalDesde03() + 1);
				//validamos si existen creditos hipotecarios mayor al mop01 y creditos automotrices mayores al mop02
				if (cuenta.getTipoContrato().equals(Constantes.HIPOTECARIO)) {
					buro.setTotalHipotecarioMop01(buro.getTotalHipotecarioMop01() + 1);
				 } else if (cuenta.getTipoContrato().equals(Constantes.AUTOMOTRIZ)) {
					buro.setTotalAutomotrizMop02(buro.getTotalAutomotrizMop02() + 1);
				 }

				if ( maximoCuenta > maximo03) {
					maximo03 = maximoCuenta;
				}
				buro.getMop03().setMaximoAbiertas(maximo03);
				if (fechaApertura.compareTo(fechaMaxima03) > 0) {
					fechaMaxima03 = fechaApertura;
		        }
				buro.getMop03().setFechaApertura(dtFormateadorString.format(fechaMaxima03));
			}
		} else if ( cuenta.getFormaPagoActual().equals("04")) {
			if (cuenta.getFechaCierreCuenta().isEmpty()) {
				buro.getMop04().setNumeroCuentasAbiertas(buro.getMop04().getNumeroCuentasAbiertas() + 1);
				buro.getMop04().setSaldoVencidoAbiertas(buro.getMop04().getSaldoVencidoAbiertas() + saldoVencido);
				buro.getMop04().setSaldoActual(buro.getMop04().getSaldoActual() + saldoActual);
				buro.setTotalDesde03(buro.getTotalDesde03() + 1);
				buro.setTotalDesde04(buro.getTotalDesde04() + 1);
				//validamos si existen creditos hipotecarios mayor al mop01 y creditos automotrices mayores al mop02
				if (cuenta.getTipoContrato().equals(Constantes.HIPOTECARIO)) {
					buro.setTotalHipotecarioMop01(buro.getTotalHipotecarioMop01() + 1);
				 } else if (cuenta.getTipoContrato().equals(Constantes.AUTOMOTRIZ)) {
					buro.setTotalAutomotrizMop02(buro.getTotalAutomotrizMop02() + 1);
				 }

				if ( maximoCuenta > maximo04) {
					maximo04 = maximoCuenta;
				}
				buro.getMop04().setMaximoAbiertas(maximo04);
				if (fechaApertura.compareTo(fechaMaxima04) > 0) {
					fechaMaxima04 = fechaApertura;
		        }
				buro.getMop04().setFechaApertura(dtFormateadorString.format(fechaMaxima04));
			}
		} else if ( cuenta.getFormaPagoActual().equals("05")) {
			if (cuenta.getFechaCierreCuenta().isEmpty()) {
				buro.getMop05().setNumeroCuentasAbiertas(buro.getMop05().getNumeroCuentasAbiertas() + 1);
				buro.getMop05().setSaldoVencidoAbiertas(buro.getMop05().getSaldoVencidoAbiertas() + saldoVencido);
				buro.getMop05().setSaldoActual(buro.getMop05().getSaldoActual() + saldoActual);
				buro.setTotalDesde03(buro.getTotalDesde03() + 1);
				buro.setTotalDesde04(buro.getTotalDesde04() + 1);
				//validamos si existen creditos hipotecarios mayor al mop01 y creditos automotrices mayores al mop02
				if (cuenta.getTipoContrato().equals(Constantes.HIPOTECARIO)) {
					buro.setTotalHipotecarioMop01(buro.getTotalHipotecarioMop01() + 1);
				 } else if (cuenta.getTipoContrato().equals(Constantes.AUTOMOTRIZ)) {
					buro.setTotalAutomotrizMop02(buro.getTotalAutomotrizMop02() + 1);
				 }

				if ( maximoCuenta > maximo05) {
					maximo05 = maximoCuenta;
				}
				buro.getMop05().setMaximoAbiertas(maximo05);
				if (fechaApertura.compareTo(fechaMaxima05) > 0) {
					fechaMaxima05 = fechaApertura;
		        }
				buro.getMop05().setFechaApertura(dtFormateadorString.format(fechaMaxima05));
			}
		} else if ( cuenta.getFormaPagoActual().equals("06")) {
			if (cuenta.getFechaCierreCuenta().isEmpty()) {
				buro.getMop06().setNumeroCuentasAbiertas(buro.getMop06().getNumeroCuentasAbiertas() + 1);
				buro.getMop06().setSaldoVencidoAbiertas(buro.getMop06().getSaldoVencidoAbiertas() + saldoVencido);
				buro.getMop06().setSaldoActual(buro.getMop06().getSaldoActual() + saldoActual);
				buro.setTotalDesde03(buro.getTotalDesde03() + 1);
				buro.setTotalDesde04(buro.getTotalDesde04() + 1);
				//validamos si existen creditos hipotecarios mayor al mop01 y creditos automotrices mayores al mop02
				if (cuenta.getTipoContrato().equals(Constantes.HIPOTECARIO)) {
					buro.setTotalHipotecarioMop01(buro.getTotalHipotecarioMop01() + 1);
				 } else if (cuenta.getTipoContrato().equals(Constantes.AUTOMOTRIZ)) {
					buro.setTotalAutomotrizMop02(buro.getTotalAutomotrizMop02() + 1);
				 }

				if ( maximoCuenta > maximo06) {
					maximo06 = maximoCuenta;
				}
				buro.getMop06().setMaximoAbiertas(maximo06);
				if (fechaApertura.compareTo(fechaMaxima06) > 0) {
					fechaMaxima06 = fechaApertura;
		        }
				buro.getMop06().setFechaApertura(dtFormateadorString.format(fechaMaxima06));
			}
		} else if ( cuenta.getFormaPagoActual().equals("07")) {
			if (cuenta.getFechaCierreCuenta().isEmpty()) {
				buro.getMop07().setNumeroCuentasAbiertas(buro.getMop07().getNumeroCuentasAbiertas() + 1);
				buro.getMop07().setSaldoVencidoAbiertas(buro.getMop07().getSaldoVencidoAbiertas() + saldoVencido);
				buro.getMop07().setSaldoActual(buro.getMop07().getSaldoActual() + saldoActual);
				buro.setTotalDesde03(buro.getTotalDesde03() + 1);
				buro.setTotalDesde04(buro.getTotalDesde04() + 1);
				//validamos si existen creditos hipotecarios mayor al mop01 y creditos automotrices mayores al mop02
				if (cuenta.getTipoContrato().equals(Constantes.HIPOTECARIO)) {
					buro.setTotalHipotecarioMop01(buro.getTotalHipotecarioMop01() + 1);
				 } else if (cuenta.getTipoContrato().equals(Constantes.AUTOMOTRIZ)) {
					buro.setTotalAutomotrizMop02(buro.getTotalAutomotrizMop02() + 1);
				 }

				if ( maximoCuenta > maximo07) {
					maximo07 = maximoCuenta;
				}
				buro.getMop07().setMaximoAbiertas(maximo07);
				if (fechaApertura.compareTo(fechaMaxima07) > 0) {
					fechaMaxima07 = fechaApertura;
		        }
				buro.getMop07().setFechaApertura(dtFormateadorString.format(fechaMaxima07));
			}
		} else if ( cuenta.getFormaPagoActual().equals("96")) {
			if (cuenta.getFechaCierreCuenta().isEmpty()) {
				buro.getMop96().setNumeroCuentasAbiertas(buro.getMop96().getNumeroCuentasAbiertas() + 1);
				buro.getMop96().setSaldoVencidoAbiertas(buro.getMop96().getSaldoVencidoAbiertas() + saldoVencido);
				buro.getMop96().setSaldoActual(buro.getMop96().getSaldoActual() + saldoActual);
				buro.setTotalDesde03(buro.getTotalDesde03() + 1);
				buro.setTotalDesde04(buro.getTotalDesde04() + 1);
				//validamos si existen creditos hipotecarios mayor al mop01 y creditos automotrices mayores al mop02
				if (cuenta.getTipoContrato().equals(Constantes.HIPOTECARIO)) {
					buro.setTotalHipotecarioMop01(buro.getTotalHipotecarioMop01() + 1);
				 } else if (cuenta.getTipoContrato().equals(Constantes.AUTOMOTRIZ)) {
					buro.setTotalAutomotrizMop02(buro.getTotalAutomotrizMop02() + 1);
				 }

				if ( maximoCuenta > maximo96) {
					maximo96 = maximoCuenta;
				}
				buro.getMop96().setMaximoAbiertas(maximo96);
				if (fechaApertura.compareTo(fechaMaxima96) > 0) {
					fechaMaxima96 = fechaApertura;
		        }
				buro.getMop96().setFechaApertura(dtFormateadorString.format(fechaMaxima96));
			}
		} else if ( cuenta.getFormaPagoActual().equals("97")) {
			if (cuenta.getFechaCierreCuenta().isEmpty()) {
				buro.getMop97().setNumeroCuentasAbiertas(buro.getMop97().getNumeroCuentasAbiertas() + 1);
				buro.getMop97().setSaldoVencidoAbiertas(buro.getMop97().getSaldoVencidoAbiertas() + saldoVencido);
				buro.getMop97().setSaldoActual(buro.getMop97().getSaldoActual() + saldoActual);
				buro.setTotalDesde03(buro.getTotalDesde03() + 1);
				buro.setTotalDesde04(buro.getTotalDesde04() + 1);
				//validamos si existen creditos hipotecarios mayor al mop01 y creditos automotrices mayores al mop02
				if (cuenta.getTipoContrato().equals(Constantes.HIPOTECARIO)) {
					buro.setTotalHipotecarioMop01(buro.getTotalHipotecarioMop01() + 1);
				 } else if (cuenta.getTipoContrato().equals(Constantes.AUTOMOTRIZ)) {
					buro.setTotalAutomotrizMop02(buro.getTotalAutomotrizMop02() + 1);
				 }

				if ( maximoCuenta > maximo97) {
					maximo97 = maximoCuenta;
				}
				buro.getMop97().setMaximoAbiertas(maximo97);
				if (fechaApertura.compareTo(fechaMaxima97) > 0) {
					fechaMaxima97 = fechaApertura;
		        }
				buro.getMop99().setFechaApertura(dtFormateadorString.format(fechaMaxima97));
			}
		} else if ( cuenta.getFormaPagoActual().equals("99")) {
			if (cuenta.getFechaCierreCuenta().isEmpty()) {
				buro.getMop99().setNumeroCuentasAbiertas(buro.getMop99().getNumeroCuentasAbiertas() + 1);
				buro.getMop99().setSaldoVencidoAbiertas(buro.getMop99().getSaldoVencidoAbiertas() + saldoVencido);
				buro.getMop99().setSaldoActual(buro.getMop99().getSaldoActual() + saldoActual);
				buro.setTotalDesde03(buro.getTotalDesde03() + 1);
				buro.setTotalDesde04(buro.getTotalDesde04() + 1);
				buro.setTotalMop99(buro.getTotalDesde04() + 1);
				//validamos si existen creditos hipotecarios mayor al mop01 y creditos automotrices mayores al mop02
				if (cuenta.getTipoContrato().equals(Constantes.HIPOTECARIO)) {
					buro.setTotalHipotecarioMop01(buro.getTotalHipotecarioMop01() + 1);
				 } else if (cuenta.getTipoContrato().equals(Constantes.AUTOMOTRIZ)) {
					buro.setTotalAutomotrizMop02(buro.getTotalAutomotrizMop02() + 1);
				 }

				if ( maximoCuenta > maximo99) {
					maximo99 = maximoCuenta;
				}
				buro.getMop99().setMaximoAbiertas(maximo99);
				if (fechaApertura.compareTo(fechaMaxima99) > 0) {
					fechaMaxima99 = fechaApertura;
		        }
				buro.getMop99().setFechaApertura(dtFormateadorString.format(fechaMaxima99));
			}
		  }
        } // validacion de que el saldo no sea menor a 1000 etc...
		//Totales
		if (cuenta.getFechaCierreCuenta().isEmpty()) {
			buro.getTotal().setNumeroCuentasAbiertas(buro.getTotal().getNumeroCuentasAbiertas() + 1);
			buro.getTotal().setSaldoVencidoAbiertas(buro.getTotal().getSaldoVencidoAbiertas() + saldoVencido);
			buro.getTotal().setSaldoActual(buro.getTotal().getSaldoActual() + saldoActual);
			if ( maximoCuenta > maximoTodas) {
				maximoTodas = maximoCuenta;
			}
			buro.getTotal().setMaximoAbiertas(maximoTodas);
			if (fechaApertura.compareTo(fechaMaximaTodas) > 0) {
				fechaMaximaTodas = fechaApertura;
	        }
			buro.getTotal().setFechaApertura(dtFormateadorString.format(fechaMaximaTodas));
		}

		// se sacan las claves de observacion
		if (listaClavesObs.contains(cuenta.getClaveObservacion())) {

			clavesObserv = clavesObserv.equals("") ? "" + cuenta.getClaveObservacion()
					: clavesObserv + ";" + cuenta.getClaveObservacion();

		   }
		buro.getMop99().setClavesObserv(clavesObserv.trim());
		LogHandler.info("", getClass(), "Mop: " + cuenta.getFormaPagoActual()
				+ "\tClaveObservacion: " + clavesObserv);

		//Se verifica si trae una  cuenta hipotecario o automotriz
		//Automotriz Hipotecario
		//M - Hipoteca RE(Bienes Raices)
		//AU(Compra Automovil)
		int mopCuenta = Integer.parseInt(cuenta.getFormaPagoActual());
		if ( cuenta.getTipoCuenta().trim().equals("M") || cuenta.getTipoContrato().trim().equals(Constantes.HIPOTECARIO)) {
			hipotecario = true;
			if ( mopCuenta > hipMop) {
				hipMop = mopCuenta;
				hipSaldoVencido += saldoVencido;
			}
		}

		if (cuenta.getTipoContrato().trim().equals(Constantes.AUTOMOTRIZ)
				|| cuenta.getNombreOrtogante().trim().equals("AUTOMOTRIZ") ) {
			automotriz = true;
			if ( mopCuenta > autoMop) {
				autoSaldoVencido += saldoVencido;
				autoMop = mopCuenta;
			}
		}
	 }

    }
	//for cuentas

	buro.setHipotecario(hipotecario);
	buro.setHipMop(hipMop);
	buro.setHipSaldoVencido(hipSaldoVencido);
	buro.setHipDescripcion("Saldo Vencido " + formateador.format(buro.getHipSaldoVencido()));

	// claves observacion
	buro.setClavesObserv(clavesObserv.equals("") ? " " : clavesObserv );

	buro.setAutomotriz(automotriz);
	buro.setAutoMop(autoMop);
	buro.setAutoSaldoVencido(autoSaldoVencido);
	buro.setAutoDescripcion("Saldo Vencido " + formateador.format(buro.getAutoSaldoVencido()));

	return buro;
  }

/**
 * metodo que contiene la validacion de automatizacion de buro.
 * @param uid id de transacion
 * @param solicitudes  integrantes de la solicitud
 * @param solicitud  datos de la solicitud
 * @return SolicitudBuroOV datos actualizados de la salicitud
 */
@SuppressWarnings("unchecked")
public SolicitudBuroOV descartarIntegrantes(String uid, List<SolicitudBuroClienteOV> solicitudes,
		SolicitudBuroOV solicitud) throws Exception {
	SqlSession sesion = null;

	String mensajeAprobacion = "CUMPLE REQUISITOS BURO";
	Float factorDesde03 = 0f;
   	Double dfactorDesde03 = 0d;
    Double dfactorDesde04 = 0d;
	Float factorDesde04 = 0f;
	float totalDesde04 = 0F;
	float totalDesde03 = 0F;
	float totalCuentas = 0F;
	Double dPorcetajeAprobacionMedio = null;
	Double dPorcetajeAprobacionAlto = null;

		sesion = FabricaConexiones.obtenerSesionNTx();

		//VALIDACION BURO - PORCENTAJE APROBACION MEDIO - 37.0
		LogHandler.trace(uid, getClass(), "descartarIntegrantes: - obtenerParGeneral");
		ParGeneralOV porcentajeAprobacionMedio = comun.obtenerParGeneralOV(uid, "VABU_POAME");

		//VALIDACION BURO - PORCENTAJE APROBACION ALTO - 20.0
		LogHandler.trace(uid, getClass(), "descartarIntegrantes: - obtenerParGeneral");
		ParGeneralOV porcentajeAprobacionAlto = comun.obtenerParGeneralOV(uid, "VABU_POAAL");

		ParGeneralOV integranteCampanaCinco =  comun.obtenerParGeneralOV(uid, "COMESINMIN");

		if (porcentajeAprobacionMedio == null || porcentajeAprobacionMedio.getCgValor().trim().isEmpty()
				|| porcentajeAprobacionAlto == null || porcentajeAprobacionAlto.getCgValor().trim().isEmpty()
				|| integranteCampanaCinco == null || integranteCampanaCinco.getCgValor().trim().isEmpty()) {
				throw new Exception("No fue posible obtener las JDNI: VABU_POAME, VABU_POAAL, COMESINMIN"
						+ "  para la validacion de buro.");
			}

		dPorcetajeAprobacionMedio = Double.parseDouble(porcentajeAprobacionMedio.getCgValor());
		dPorcetajeAprobacionAlto = Double.parseDouble(porcentajeAprobacionAlto.getCgValor());
		int minIntTres = Integer.parseInt(integranteCampanaCinco.getCgValor()); //3

//llenar la lista de descarte automatico
if (!solicitud.getValorTipificacion().trim().equals("NRBA")) {
	try {
		for (SolicitudBuroClienteOV integranteSolicitud : solicitudes) {
			LogHandler.trace(uid, getClass(), "persona:" + integranteSolicitud.getPersona()
			+ "\tClaves de observacion:" + integranteSolicitud.getCuentas().getMop99().getClavesObserv()
			+ "\tHipotecario:" + integranteSolicitud.getCuentas().getTotalHipotecarioMop01()
			+ "\tAutomotriz:" + integranteSolicitud.getCuentas().getTotalAutomotrizMop02()
			+ "\tMop99:" + integranteSolicitud.getCuentas().getTotalMop99());

			if (integranteSolicitud.getCuentas().getTotalHipotecarioMop01() > 0
					|| integranteSolicitud.getCuentas().getTotalAutomotrizMop02() > 0
					|| integranteSolicitud.getCuentas().getTotalMop99() > 0
					|| !integranteSolicitud.getCuentas().getMop99().getClavesObserv().trim().isEmpty()) {
				// checar si tiene contrato en finsol
				List<String> contrato = (List<String>) sesion.selectList("obtenerContratoIntegrante",
						integranteSolicitud.getPersona());

				if (contrato.size() == 0) {
					integranteSolicitud.setEstatusBC("O");
					solicitud.getIntegrantesDescarteObligatorio().add(integranteSolicitud);
				}
			}
		  }
		} catch (Exception e) {
			LogHandler.error(uid, getClass(), "Ocurrio un error a la hora de consultar el contrato del integrante. ", e);
			throw new Exception("Ocurrio un error a la hora de consultar el contrato del integrante ");
		} finally {
			FabricaConexiones.close(sesion);
		}
		LogHandler.info(uid, getClass(), "-------------Integrantes descarte automatica ------------ ");
		LogHandler.info(uid, getClass(), "Tamaño: " + solicitud.getIntegrantesDescarteObligatorio().size()
				+ "\nIntegrantes:\n" + solicitud.getIntegrantesDescarteObligatorio());

		if (solicitud.getIntegrantesDescarteObligatorio().size() > 0) {

			for (SolicitudBuroClienteOV integranteSolicitud : solicitud.getIntegrantesDescarteObligatorio()) {
			    solicitudes = eliminarIntegranteDeLaLista(uid, solicitudes, integranteSolicitud);
			 }
		}
  }
		int ciclo = Integer.parseInt(solicitud.getCiclo());
		String campana = solicitud.getCampana();
		int numeroIntegrantes = solicitudes.size();
		if (ciclo > 0) {
			if (solicitud.getIntegrantesNuevos() > 0 && !solicitud.isListaNuevos()) {
			    numeroIntegrantes = solicitud.getIntegrantesOriginales() + solicitudes.size();
			}
		}

	// validar el numero de integrantes segun el ciclo si no cumple
	// se rechaza al grupo
		// se rechaza al grupo
	if (campana.equals(Constantes.CAMPANA_CINCO) && numeroIntegrantes < minIntTres) {
			return solicitud;
	} else if (!campana.equals(Constantes.CAMPANA_CINCO) && ciclo == 0 && numeroIntegrantes < Constantes.INTEGRANTE_CICLO_UNO) {
		return solicitud;
	} else if (!campana.equals(Constantes.CAMPANA_CINCO) && ciclo > 0 && numeroIntegrantes < Constantes.INTEGRANTE_CICLO_DOS) {
		return solicitud;
	}

//termina de llenar la lista de descarte automatico
//PASO 2: calcular el numero de integrantes sugerido a eliminar

	// validacion segun la calificacion de la sucursal si es bajo se
	// manda el grupo al cec
	if (solicitud.getValorTipificacion().trim().equals("NRBA")) {
		solicitud.setAprobacion(mensajeAprobacion);
		return solicitud;
		// si la validacion es media se calcula el % de las cuentas
		// con mop >= 4
	} else if (solicitud.getValorTipificacion().trim().equals("NRME")) {
		// se valida si el % de cuentas abiertas es < 37 se manda al
		// cec
		calculoTotalCuentas(uid, solicitudes, solicitud);  // esta parte se agrga
		totalDesde04 = solicitud.getTotalDesde04();
		totalCuentas = solicitud.getTotalCuentas();

		if (totalCuentas > 0) {
			factorDesde04 = (totalDesde04 / totalCuentas) * Constantes.CENTENA;
		}
		dfactorDesde04 = redondeo(new Double(factorDesde04));
		solicitud.setFactorDesde04(dfactorDesde04);

		LogHandler.info(uid, getClass(), "MEDIO:----porcentaje de cuentas---" + dfactorDesde04);

		if (dfactorDesde04 < dPorcetajeAprobacionMedio) {
			solicitud.setAprobacion(mensajeAprobacion);
			return solicitud;
		} else {
			// realizar descarte sugerido de las personas
			do {
				calculoTotalCuentas(uid, solicitudes, solicitud);
				totalDesde04 = solicitud.getTotalDesde04();
				totalCuentas = solicitud.getTotalCuentas();

				if (totalCuentas > 0) {
					factorDesde04 = (totalDesde04 / totalCuentas) * Constantes.CENTENA;
				}
				dfactorDesde04 = redondeo(new Double(factorDesde04));
				solicitud.setFactorDesde04(dfactorDesde04);
				LogHandler.info(uid, getClass(), "MEDIO:----porcentaje de cuentas---" + dfactorDesde04);

				solicitudes = descartarIntegranteSugerido(uid, solicitudes, solicitud);

			} while (solicitud.getFactorDesde04() >= dPorcetajeAprobacionMedio);
			solicitud.setAprobacion(mensajeAprobacion);
			return solicitud;
		}

		// si la validacion es alta o muy alta se calcula el % de las
		// cuentas con mop >= 3
	} else {
		// si el % es menor al 20% se manda al cec
		calculoTotalCuentas(uid, solicitudes, solicitud);  // esta parte se agrega
		totalDesde03 = solicitud.getTotalDesde03();
		totalCuentas = solicitud.getTotalCuentas();

		if (totalCuentas > 0) {
			factorDesde03 = (totalDesde03 / totalCuentas) * Constantes.CENTENA;
		}
		dfactorDesde03 = redondeo(new Double(factorDesde03));
		solicitud.setFactorDesde03(dfactorDesde03);

		LogHandler.info(uid, getClass(), "ALTO:----porcentaje de cuentas---" + dfactorDesde03);

		if (dfactorDesde03 < dPorcetajeAprobacionAlto) {
			solicitud.setAprobacion(mensajeAprobacion);
			return solicitud;
		} else {
			do {
			// realizar descarte sugerido de las personas
				calculoTotalCuentas(uid, solicitudes, solicitud);  // esta parte se agrega
				totalDesde03 = solicitud.getTotalDesde03();
				totalCuentas = solicitud.getTotalCuentas();

				if (totalCuentas > 0) {
					factorDesde03 = (totalDesde03 / totalCuentas) * Constantes.CENTENA;
				}
				dfactorDesde03 = redondeo(new Double(factorDesde03));
				solicitud.setFactorDesde03(dfactorDesde03);

				LogHandler.info(uid, getClass(), "ALTO:----porcentaje de cuentas---" + dfactorDesde03);

			solicitudes = descartarIntegranteSugerido(uid, solicitudes, solicitud);
			} while (solicitud.getFactorDesde03() >= dPorcetajeAprobacionAlto);
			return solicitud;
		}
	}
}

	/**
	 * metodo para eliminar integrantes de la lista
	 *
	 * @param solicitudes
	 *            solicitud de la cual se va a eleimnar el integrante
	 * @param uid
	 *            id uinico de transaccion
	 * @param eliminar
	 *            integrante a eliminar
	 * @return List<SolicitudBuroClienteOV> lista sin los integrantes eliminados
	 */
	public List<SolicitudBuroClienteOV> eliminarIntegranteDeLaLista(String uid,
			List<SolicitudBuroClienteOV> solicitudes, SolicitudBuroClienteOV eliminar) {
		Iterator<SolicitudBuroClienteOV> it = solicitudes.iterator();
		String numeroPersonaEliminar = eliminar.getPersona();
		while (it.hasNext()) {
			String numPersona = it.next().getPersona();
			if (numeroPersonaEliminar.equals(numPersona)) {
				it.remove();
			}
		}
		return solicitudes;
	}

	/**
	 * metodo que calcula los montos
	 * @param uid id de la transaccion
	 * @param solicitudes integrantes
	 * @param solicitud datos de sal solicitud
	 */
	public void calculoTotalCuentas(String uid, List<SolicitudBuroClienteOV> solicitudes, SolicitudBuroOV solicitud) {
		LogHandler.info(uid, getClass(), "----recalcular totales tamañano de la lista:-- " + solicitudes.size());
		double totalDesde03 = 0;
		double totalCuentas = 0;
		double factorDesde03  = 0;
		double dfactorDesde03 = 0;
		double totalDesde04  = 0;
		double factorDesde04 = 0;
		double dfactorDesde04 = 0;

		//inicializar valores de los totales de solicitud
		 solicitud.setTotalCuentas(0);
		 solicitud.setTotalDesde03(0);
		 solicitud.setTotalDesde04(0);
		 solicitud.setTotalCuentasMalasAceptables(0);

		  for (SolicitudBuroClienteOV integranteSolicitud : solicitudes) {
			  if (!descartarIntegrante(integranteSolicitud.getPersona().trim(), null)) {
				  solicitud.setTotalCuentas(solicitud.getTotalCuentas()
							+ integranteSolicitud.getCuentas().getTotal().getNumeroCuentasAbiertas());
				  solicitud.setTotalDesde03(solicitud.getTotalDesde03()
						+ integranteSolicitud.getCuentas().getTotalDesde03());
				  solicitud.setTotalDesde04(solicitud.getTotalDesde04()
						+ integranteSolicitud.getCuentas().getTotalDesde04());
			  }
		  }
			if (solicitud.getValorTipificacion().equals("NRME")) {
				solicitud.setTotalCuentasMalasAceptables(
						solicitud.getTotalCuentas() + solicitud.getTotalDesde04());

				totalDesde04 = solicitud.getTotalDesde04();
				totalCuentas = solicitud.getTotalCuentas();

				if (totalCuentas > 0) {
					factorDesde04 = (totalDesde04 / totalCuentas) * Constantes.CENTENA;
				}
				dfactorDesde04 = redondeo(new Double(factorDesde04));
				solicitud.setFactorDesde04(dfactorDesde04);
			} else {
				solicitud.setTotalCuentasMalasAceptables(
						solicitud.getTotalCuentas() + solicitud.getTotalDesde03());

				totalDesde03 = solicitud.getTotalDesde03();
				totalCuentas = solicitud.getTotalCuentas();

				if (totalCuentas > 0) {
					factorDesde03 = (totalDesde03 / totalCuentas) * Constantes.CENTENA;
				}
				dfactorDesde03 = redondeo(new Double(factorDesde03));
				solicitud.setFactorDesde03(dfactorDesde03);
			}

			LogHandler.info(uid, getClass(), "TotalCuentasAceptables(SA)\t TotalMalas(SM4)\t TotalMalas(SM3) \t total(SAM) ");
			LogHandler.info(uid, getClass(), solicitud.getTotalCuentas() + "\t\t" + solicitud.getTotalDesde04()
			+ "\t\t" + solicitud.getTotalDesde03() +  "\t\t" + solicitud.getTotalCuentasMalasAceptables());
	}

	 /**
     * metodo que regresa el integrante sugerido a eliminar.
     * @param uid  id de la transaccion
     * @param solicitudes integrantes de la lista
     * @param solicitud datos de la solicitud
     * @return List<SolicitudBuroClienteOV> lista de integrantes
     */
	public List<SolicitudBuroClienteOV> descartarIntegranteSugerido(String uid,
			List<SolicitudBuroClienteOV> solicitudes, SolicitudBuroOV solicitud) {
		boolean tipificacionMedia = solicitud.getValorTipificacion().trim().equals("NRME");
		//recalcular saldos de los totales de cuentas
		calculoTotalCuentas(uid, solicitudes, solicitud);
		//suma total de cuentas malas sm de acuerdo a nivel de tipificacion sucursal
		int sm  = tipificacionMedia ? solicitud.getTotalDesde04() : solicitud.getTotalDesde03();
		//suma de las cuentas aceptables y malas
		int sam = solicitud.getTotalCuentasMalasAceptables();
		int mayorIndicador = 0;

		if (solicitud.getIntegrantes() == null) {
			solicitud.setIntegrantes(new ArrayList<SolicitudBuroClienteOV>());
		}

		LogHandler.info(uid, getClass(), "Persona\tTotalCuentasAceptables\tTotalCuentasMalas\t"
				+ "total(SAMI)\tContribucionesCuentasMalas\tContribucionesTotalCuentas\tIndicadorSalida" );

		for (SolicitudBuroClienteOV integrante : solicitudes) {
			// obtenemos la suma se cuentas malas y aceptables por integrante (sami)
			int totalCuentasMalas = tipificacionMedia ? integrante.getCuentas().getTotalDesde04()
					                : integrante.getCuentas().getTotalDesde03();
			integrante.getCuentas().setSami(integrante.getCuentas().getTotal().getNumeroCuentasAbiertas()
					+ totalCuentasMalas);
			//sacar la contribucion a las cuentas malas
			integrante.getCuentas().setContCuentasMalas(
					     redondeo((double) totalCuentasMalas / sm * Constantes.CENTENA));
			//sacar la contribucion total de cuentas
			integrante.getCuentas().setContTotalCuentas(
					     redondeo((double) integrante.getCuentas().getSami() / sam * Constantes.CENTENA));
			//sacar el indicador de salida
			integrante.getCuentas().setIndicadorSalida(redondeo(integrante.getCuentas().getContCuentasMalas()
					- integrante.getCuentas().getContTotalCuentas()));

			LogHandler.info(uid, getClass(), integrante.getPersona() + "\t"
					           + integrante.getCuentas().getTotal().getNumeroCuentasAbiertas() + "\t\t\t"
					           + totalCuentasMalas + "\t\t\t"
					           + integrante.getCuentas().getSami() + "\t\t\t"
					           + integrante.getCuentas().getContCuentasMalas() + "\t\t\t"
					           + integrante.getCuentas().getContTotalCuentas() + "\t\t\t"
					           + integrante.getCuentas().getIndicadorSalida());
		}

		// determinar que integrante tiene el mayor indicador de salida
		for (int i = 1; i < solicitudes.size(); i++) {
			  if (solicitudes.get(i).getCuentas().getIndicadorSalida()
					  >= solicitudes.get(mayorIndicador).getCuentas().getIndicadorSalida()) {
				  mayorIndicador = i;
				}
			}
		LogHandler.info(uid, getClass(), "Integrante con el indicador mas alto" + solicitudes.get(mayorIndicador));

		// checar si no hay ningun empate con el indicador de salida
		double indicadorMax = (double) solicitudes.get(mayorIndicador).getCuentas().getIndicadorSalida();
		int contador = 0;
		List<Integer> integrantesConEmpate = new ArrayList<Integer>();

		for (int i = 0; i < solicitudes.size(); i++) {
			  if (solicitudes.get(i).getCuentas().getIndicadorSalida() == indicadorMax) {
				  integrantesConEmpate.add(i);
				  contador++;
				}
			}
		LogHandler.info(uid, getClass(), "contador: " + contador + " IntegrantesConEmpate: " + integrantesConEmpate);

		//en caso de haber empate se checa el que tenga menor numero de cuentas abiertas y ese se descarta
		int menorCuentasAbiertas = 0;
		if (contador > 1) {
			for (int i = 1; i < integrantesConEmpate.size(); i++) {
				System.out.println(solicitudes.get(integrantesConEmpate.get(menorCuentasAbiertas)).getPersona() + ":  "
						+ solicitudes.get(integrantesConEmpate.get(menorCuentasAbiertas))
						.getCuentas().getTotal().getNumeroCuentasAbiertas());
				System.out.println(solicitudes.get(integrantesConEmpate.get(i)).getPersona() + ":  "
						+ solicitudes.get(integrantesConEmpate.get(i)).getCuentas().getTotal().getNumeroCuentasAbiertas());
				  if (solicitudes.get(integrantesConEmpate.get(i)).getCuentas().getTotal().getNumeroCuentasAbiertas()
						  < solicitudes.get(integrantesConEmpate.get(menorCuentasAbiertas)).getCuentas()
						  .getTotal().getNumeroCuentasAbiertas()) {
					  menorCuentasAbiertas = i;
					}
				}
			solicitudes.get(integrantesConEmpate.get(menorCuentasAbiertas)).setEstatusBC("S");
			LogHandler.info(uid, getClass(), "Integrante sujerido "
			         + solicitudes.get(integrantesConEmpate.get(menorCuentasAbiertas)));

			solicitud.getIntegrantesDescarteSugerido().add(solicitudes.get(integrantesConEmpate.get(menorCuentasAbiertas)));
			solicitudes = eliminarIntegranteDeLaLista(uid, solicitudes,
					solicitudes.get(integrantesConEmpate.get(menorCuentasAbiertas)));
		} else {
			solicitudes.get(mayorIndicador).setEstatusBC("S");
			solicitud.getIntegrantesDescarteSugerido().add(solicitudes.get(mayorIndicador));
			solicitudes = eliminarIntegranteDeLaLista(uid, solicitudes, solicitudes.get(mayorIndicador));
		}

		LogHandler.info(uid, getClass(), "--------------------integrantes sugeridos a descartar---------------------");
		LogHandler.info(uid, getClass(), " " + solicitud.getIntegrantesDescarteSugerido());

		//recalcular saldos de los totales de cuentas
		calculoTotalCuentas(uid, solicitudes, solicitud);

	    return solicitudes;
	}

	 /**
     * M&eacute;todo que regresa el resumen de buro de cada integrante
     * @param uid identificador &uacute;nico de transacci&oacute;n
     * @param peticion datos como la solicitud, perfil, usuarioAut
     * @return List<ResumenBuroCliente> lista de clientes
     */
	@SuppressWarnings("unchecked")
	public List<ResumenBuroCliente> resumenBuroSolicitud(String uid, ResumenBuroPeticion peticion) {
		 LogHandler.info(uid, getClass(), "resumenBuroSolicitud :::: Init  peticion:" + peticion);
		 List<ResumenBuroCliente> resumenClientes = null;
		 SqlSession sesionNTx = null;

		 try {
			 if (peticion == null || peticion.getSolicitud() == null || peticion.getSolicitud().isEmpty()) {
					throw new Exception("Es necesario que la peticion contenga la solicitud");
				}

			 	//Se agregan variables para la consulta de las URL's por medio de par_general
				ParGeneralOV urlImagen = comun.obtenerParGeneralOV(uid, "URL_ICONO_PDF");
				ParGeneralOV urlBuroHistorico = comun.obtenerParGeneralOV(uid, "URL_BURO_HISTORICO");

				if (urlImagen == null || urlImagen.getCgValor().trim().isEmpty()
					    || urlBuroHistorico == null || urlBuroHistorico.getCgValor().trim().isEmpty()) {
					    throw new Exception("No se encontraron las JDNI: URL_ICONO_PDF, URL_BURO_HISTORICO" );
					}

			    sesionNTx = FabricaConexiones.obtenerSesionNTx();
			    List<SolicitudBuroClienteOV> integrantes
				= (List<SolicitudBuroClienteOV>) sesionNTx.selectList("obtenerIntegrantesSolicitud",
						peticion.getSolicitud().trim());

			    if (integrantes.isEmpty()) {
					throw new Exception("La solicitud: " + peticion.getSolicitud().trim() +  " no contiene integrantes");
				}
			    LogHandler.info(uid, getClass(), "resumenBuroSolicitud ::integrantes a consultar buro" + integrantes);

			    if (integrantes.size() > 0) {
			    	 resumenClientes = new ArrayList<ResumenBuroCliente>();
			    	 int indice = 1;
			    	  for (SolicitudBuroClienteOV solicitudBuroClienteOV : integrantes) {
			              LogHandler.info(uid, getClass(), "--------resumenBuroSolicitud ::numero persona BURO:"
			    	                    + solicitudBuroClienteOV.getPersona() + "------------------");
			              solicitudBuroClienteOV.setUrlBuroHistorico(urlBuroHistorico.getCgValor());
			    		  solicitudBuroClienteOV.setPersonaAutoriza(peticion.getUsuarioAutoriza());
			    		  solicitudBuroClienteOV.setUrlIconoPdf(urlImagen.getCgValor());
			    		  ResumenBuroCliente cliente = obtenerResumenBuroPorCliente( uid, solicitudBuroClienteOV);
			    		  if (cliente != null) {
			    			  cliente.setIndice(indice);
			    			  if (indice % 2 == 0) {
			    			      cliente.setBackgroundFila("background:rgb(201,217,253)");
			    			  }
			    			  indice++;
			    		  }
			    		  resumenClientes.add(cliente);
					}
			       LogHandler.info(uid, getClass(), "resumenBuroSolicitud ::integrantes con resumen"
					                + resumenClientes.size());
			    }
		 } catch (Exception ex) {
				LogHandler.error(uid, getClass(), "resumenBuroSolicitud: " + ex.getMessage(), ex);
		 } finally {
				FabricaConexiones.close(sesionNTx);
		 }
		 return resumenClientes;
	}

	/**
	 * M&eacute;todo que regresa el resumen de buro de cada integrante
     * @param uid identificador &uacute;nico de transacci&oacute;n
	 * @param persona datos de buro del cliente
	 * @return ResumenBuroCliente regresa un resumen del cliente
	 * @throws Exception puede arrojar una excepcion
	 */
	public ResumenBuroCliente obtenerResumenBuroPorCliente(String uid, SolicitudBuroClienteOV persona) throws Exception {
		 LogHandler.info(uid, getClass(), "obtenerResumenBuroPorCliente :::: Init  peticion:" + persona);
		 ResumenBuroCliente resumenCliente = new ResumenBuroCliente();

		 if (persona == null || persona.getPersona() == null || persona.getPersona().isEmpty()) {
				throw new Exception("Es necesario el numeroPersona para consultar el resumen de buro");
			}
		 resumenCliente.setNumeroPersona(persona.getPersona()); // se agrega el numero de persona
		 resumenCliente.setNombreCompleto(persona.getNombreCompleto()); // se agrega el nombre completo

//1.- hacer la conexion al buro de credito
		 ParGeneralOV urlBuro = comun.obtenerParGeneralOV(uid, "BURO_URL");
	     if (urlBuro == null || urlBuro.getCgValor().trim().isEmpty()) {
			throw new Exception("No fue posible obtener la URL del servicio de buro.");
	     }
	     LogHandler.info(uid, getClass(), "BURO_URL ::::" + urlBuro.getCgValor().trim());
	     ServicioBuroCreditoProxy ws = new ServicioBuroCreditoProxy();
		 ws.setEndpoint(urlBuro.getCgValor().trim());

		 ObtenerXMLReporteCreditoRequest request = new ObtenerXMLReporteCreditoRequest();
 		 ObtenerXMLReporteCreditoResponse response = new ObtenerXMLReporteCreditoResponse();
 		 request.setPersona(persona.getPersona());
 		 response = ws.obtenerXMLReporteCredito(request);

		if (response == null ||  response.getXMLReporteCredito() == null ||  response.getXMLReporteCredito().isEmpty()) {
				throw new Exception("No se pudo obtener la consulta Buro del cliente " + persona.getPersona());
			}
		ReporteCredito reporteCredito = obtenerObjetoBCN(response.getXMLReporteCredito());

		 if (reporteCredito != null && reporteCredito.getCuentas() != null) {
			//2.- ordenar las cuentas
			 LogHandler.info(uid, getClass(), "obtenerResumenBuroPorCliente :::: Se ordenan Consultas por MOP");
            Collections.sort(reporteCredito.getCuentas(), new Comparator<SegmentoCuenta>() {
				public int compare(SegmentoCuenta o1, SegmentoCuenta o2) {
					return o1.getFormaPagoActual().compareTo(o2.getFormaPagoActual());
				}
			 });
		     // 3. cargar cuentas resumen
			resumenCliente.setMops(cargarCuentaResumen(uid, reporteCredito));

			if (resumenCliente.getMops() != null && resumenCliente.getMops().size() > 0) {
				resumenCliente.setSizeMops(resumenCliente.getMops().size());
				resumenCliente.setIndex(resumenCliente.getMops().get(0).getIndex());
				resumenCliente.setMop(resumenCliente.getMops().get(0).getMop());
				resumenCliente.setCuentasAbiertas(resumenCliente.getMops().get(0).getCuentasAbiertas()); //CA
				resumenCliente.setSaldoActualAbiertas(resumenCliente.getMops().get(0).getSaldoActualAbiertas()); //SAA
				resumenCliente.setFormatoSaldoActualAbiertas(resumenCliente.getMops().get(0).getFormatoSaldoActualAbiertas());

				resumenCliente.setSaldoVencidoAbiertas(resumenCliente.getMops().get(0).getSaldoVencidoAbiertas()); //SVA
				resumenCliente.setFormatoSaldoVencidoAbiertas(resumenCliente.getMops().get(0).getFormatoSaldoVencidoAbiertas());

				resumenCliente.setCuentasCerradas(resumenCliente.getMops().get(0).getCuentasCerradas()); //CC
				resumenCliente.setSaldoActualCerradas(resumenCliente.getMops().get(0).getSaldoActualCerradas()); //SAC
				resumenCliente.setFormatoSaldoActualCerradas(resumenCliente.getMops().get(0).getFormatoSaldoActualCerradas());

				resumenCliente.setMontoCerradas(resumenCliente.getMops().get(0).getMontoCerradas()); //MC
				resumenCliente.setFormatoMontoCerradas(resumenCliente.getMops().get(0).getFormatoMontoCerradas());
				resumenCliente.setStyleBackground(resumenCliente.getMops().get(0).getStyleBackground());

				double monto = 0;
				if (persona.getMontoSolicitadoAproElec() == 0) {
					monto = 1;
				} else {
					monto = persona.getMontoSolicitadoAproElec();
				}
				resumenCliente.setMontoCicloAnterior(
						"$" + Validaciones.formatoMoneda(uid, persona.getMontoCicloAnterior()));
				resumenCliente.setMontoSolicitadoAproElec(
						"$" + Validaciones.formatoMoneda(uid, persona.getMontoSolicitadoAproElec()));
				resumenCliente.setBuroHistorico(
						persona.getUrlBuroHistorico() + "usuario=" + persona.getPersonaAutoriza().trim()
						+ "&importe=" + monto  + "&persona=" + persona.getPersona().trim() + "&sucursal=0");
				resumenCliente.setUrlIconoPdf(persona.getUrlIconoPdf());
				if (resumenCliente.getMops().size() > 1) {
				   resumenCliente.setMops(resumenCliente.getMops().subList(1, resumenCliente.getMops().size()));
				}
			}
			// 4. obtener el numero de solicitudes afectadas en los ultimos 6 meses
           if (reporteCredito.getSegmentoResumenReporte() != null
           		&& reporteCredito.getSegmentoResumenReporte().getNumeroSolAfectadasUlt6Meses() != null) {
           	resumenCliente.setHistoricoFinsol(Integer.parseInt(reporteCredito.getSegmentoResumenReporte()
           			.getNumeroSolAfectadasUlt6Meses().trim()));
           } else {
           	resumenCliente.setHistoricoFinsol(0);
           }
           LogHandler.info(uid, getClass(), "resumenCliente::" + resumenCliente);

        } else if (reporteCredito != null && reporteCredito.getCuentas() == null) {
			   resumenCliente.setSizeMops(1);
				resumenCliente.setIndex(0);
				resumenCliente.setMop("T");
				resumenCliente.setCuentasAbiertas(0); //CA
				resumenCliente.setSaldoActualAbiertas(0); //SAA
				resumenCliente.setFormatoSaldoActualAbiertas("$0.00");

				resumenCliente.setSaldoVencidoAbiertas(0); //SVA
				resumenCliente.setFormatoSaldoVencidoAbiertas("$0.00");

				resumenCliente.setCuentasCerradas(0); //CC
				resumenCliente.setSaldoActualCerradas(0); //SAC
				resumenCliente.setFormatoSaldoActualCerradas("$0.00");

				resumenCliente.setMontoCerradas(0); //MC
				resumenCliente.setFormatoMontoCerradas("$0.00");
				resumenCliente.setStyleBackground("background:rgb(255,255,255)");

				double monto = 0;
				if (persona.getMontoSolicitadoAproElec() == 0) {
					monto = 1;
				} else {
					monto = persona.getMontoSolicitadoAproElec();
				}
				resumenCliente.setMontoCicloAnterior(
						"$" + Validaciones.formatoMoneda(uid, persona.getMontoCicloAnterior()));
				resumenCliente.setMontoSolicitadoAproElec(
						"$" + Validaciones.formatoMoneda(uid, persona.getMontoSolicitadoAproElec()));
				resumenCliente.setBuroHistorico(
						persona.getUrlBuroHistorico() + "usuario=" + persona.getPersonaAutoriza().trim()
						+ "&importe=" + monto  + "&persona=" + persona.getPersona().trim() + "&sucursal=0");
				resumenCliente.setUrlIconoPdf(persona.getUrlIconoPdf());

			// 4. obtener el numero de solicitudes afectadas en los ultimos 6 meses
	           if (reporteCredito.getSegmentoResumenReporte() != null
	           		&& reporteCredito.getSegmentoResumenReporte().getNumeroSolAfectadasUlt6Meses() != null) {
	           	resumenCliente.setHistoricoFinsol(Integer.parseInt(reporteCredito.getSegmentoResumenReporte()
	           			.getNumeroSolAfectadasUlt6Meses().trim()));
	           } else {
	           	resumenCliente.setHistoricoFinsol(0);
	           }
	           LogHandler.info(uid, getClass(), "resumenCliente::" + resumenCliente);

			 LogHandler.info(uid, getClass(), "obtenerResumenBuroPorCliente :::: no hay cuentas:" + resumenCliente);

		} else {
			throw new Exception("No se pudieron obtener las cuentas de " + persona.getPersona());
		}
     return resumenCliente;
  }
	/**
	 * M&eacute;todo que carga cuenta y totales del resumen de buro d ecada cliente
     * @param uid identificador &uacute;nico de transacci&oacute;n
	 * @param reporteCredito reporte de buro del cliene
	 * @return List<ResumenBuroMop> regres auna lista de mops
	 */
	private List<ResumenBuroMop> cargarCuentaResumen(String uid, ReporteCredito reporteCredito) {
		 LogHandler.info(uid, getClass(), "cargarCuentaResumen :::: Init");
		 List<ResumenBuroMop> listaResumen = null;
		 int index = 0;
          listaResumen = resumenCuenta(uid, reporteCredito);
          LogHandler.info(uid, getClass(), "cargarCuentaResumen :::: orden.");
          //Ordenamos
          Collections.sort(listaResumen);
          LogHandler.info(uid, getClass(), "cargarCuentaResumen :::: antes totales listaResumen." + listaResumen);
       //AgregamosTotales
       agregarTotales(uid, listaResumen);

       //se le agrega el indice
       for (ResumenBuroMop resumenBuroMop : listaResumen) {
       	resumenBuroMop.setIndex(index++);
       	resumenBuroMop.setFormatoSaldoActualAbiertas("$"
       	             + Validaciones.formatoMoneda(uid, resumenBuroMop.getSaldoActualAbiertas()));
       	resumenBuroMop.setFormatoSaldoVencidoAbiertas("$"
       	             + Validaciones.formatoMoneda(uid, resumenBuroMop.getSaldoVencidoAbiertas()));
       	resumenBuroMop.setFormatoSaldoActualCerradas("$"
       	             + Validaciones.formatoMoneda(uid, resumenBuroMop.getSaldoActualCerradas()));
       	resumenBuroMop.setFormatoMontoCerradas("$" + Validaciones.formatoMoneda(uid, resumenBuroMop.getMontoCerradas()));
		}
       LogHandler.info(uid, getClass(), "cargarCuentaResumen :::: despues totales listaResumen:" + listaResumen);
       return listaResumen;
   }

	/**
	 * M&eacute;todo que carga los mop apartir del reporte de credito
     * @param uid identificador &uacute;nico de transacci&oacute;n
	 * @param reporteCredito reporte del buro
	 * @return List<ResumenBuroMop> lista de mops
	 */
	private List<ResumenBuroMop> resumenCuenta(String uid,  ReporteCredito reporteCredito ) {
	 LogHandler.info(uid, getClass(), "-----------resumenCuenta: Cuentas ---------------------------------------");
	 LogHandler.info(uid, getClass(), "ResumenBuro: " +  reporteCredito.getCuentas());

	    List<ResumenBuroMop> listaResumen = new ArrayList<ResumenBuroMop>();
	    String clavesObserv = "";
	    String claves;
	    List<String> listaClavesObs = null;
	    try {
			claves = comun.obtenerParGeneral("", "LISTA_CVE_OBS");
			LogHandler.info(uid, getClass(), "LISTA_CVE_OBS: " + claves);
			String[] clavesObs = claves.split(";");
			listaClavesObs = new ArrayList<String>();

			if (clavesObs.length > 0) {
				listaClavesObs = new ArrayList<String>();
					for (int j = 0; j < clavesObs.length; j++) {
						listaClavesObs.add(clavesObs[j]);
				}
			}
			 LogHandler.info(uid, getClass(), "listaClavesObs: " + listaClavesObs);
	    } catch (Exception e) {
			LogHandler.info(uid, getClass(), "No se encontro el JNDI : LISTA_CVE_OBS " );
		}

	    //Barrido de cuentas TL
	  if (reporteCredito.getCuentas() != null ) {
		  LogHandler.info(uid, getClass(), "resumenCuenta :::: reporteCredito.getCuentas().size: "
	                                   + reporteCredito.getCuentas().size());
		for (SegmentoCuenta cuenta : reporteCredito.getCuentas() ) {
			//buscamos si existe el mop
			 boolean existe = false;

			 cuenta.setFechaCierreCuenta(cuenta.getFechaCierreCuenta() == null ? "" : cuenta.getFechaCierreCuenta());
             cuenta.setLimiteCredito(cuenta.getLimiteCredito() == null ? "0" : cuenta.getLimiteCredito());
             cuenta.setLimiteCredito(cuenta.getLimiteCredito().isEmpty() ? "0" : cuenta.getLimiteCredito());
             cuenta.setCreditoMaximo(cuenta.getCreditoMaximo() == null ? "0" : cuenta.getCreditoMaximo());
             cuenta.setCreditoMaximo(cuenta.getCreditoMaximo().isEmpty() ? "0" : cuenta.getCreditoMaximo());
             cuenta.setSaldoActual(cuenta.getSaldoActual() == null ? "0" : cuenta.getSaldoActual());
             cuenta.setSaldoActual(cuenta.getSaldoActual().isEmpty() ? "0" : cuenta.getSaldoActual());
             cuenta.setSaldoActual(cuenta.getSaldoActual().replace("+", "").replace("-", ""));
             cuenta.setSaldoVencido(cuenta.getSaldoVencido() == null ? "0" : cuenta.getSaldoVencido());
             cuenta.setSaldoVencido(cuenta.getSaldoVencido().isEmpty() ? "0" : cuenta.getSaldoVencido());
             cuenta.setSaldoVencido(cuenta.getSaldoVencido().replace("+", "").replace("-", ""));
             cuenta.setNumPagosVencidos(cuenta.getNumPagosVencidos() == null ? "0" : cuenta.getNumPagosVencidos());
             cuenta.setNumPagosVencidos(cuenta.getNumPagosVencidos().isEmpty() ? "0" : cuenta.getNumPagosVencidos());
             cuenta.setMontoPago(cuenta.getMontoPago() == null ? "0" : cuenta.getMontoPago());
             cuenta.setMontoPago(cuenta.getMontoPago().isEmpty() ? "0" : cuenta.getMontoPago());
             cuenta.setMontoPago(cuenta.getMontoPago().replace("+", "").replace("-", ""));

             cuenta.setClaveObservacion(cuenta.getClaveObservacion() == null ? "" : cuenta.getClaveObservacion());
             cuenta.setNombreOrtogante(cuenta.getNombreOrtogante() == null ? "" : cuenta.getNombreOrtogante());

             LogHandler.info(uid, getClass(), "resumenCuenta :::: for listaResumen.");
             LogHandler.info(uid, getClass(), "resumenCuenta :::: listaResumen.size: " + listaResumen.size());

             for (ResumenBuroMop item : listaResumen) {
            	 LogHandler.info(uid, getClass(), "mop  " + item.getMop());

                 if (item.getMop().equals(cuenta.getFormaPagoActual())) {
                     existe = true;
                     if (cuenta.getFechaCierreCuenta().isEmpty()) {
                         item.setCuentasAbiertas(item.getCuentasAbiertas() + 1);
                         item.setLimiteAbiertas(item.getLimiteAbiertas()
                                 + Double.parseDouble(cuenta.getLimiteCredito()));
                         item.setMaximoAbiertas(item.getMaximoAbiertas()
                                 + Double.parseDouble(cuenta.getCreditoMaximo()));
                         item.setSaldoActualAbiertas(item.getSaldoActualAbiertas()
                                 + Double.parseDouble(cuenta.getSaldoActual()));
                         item.setSaldoVencidoAbiertas(item.getSaldoVencidoAbiertas()
                                 + Double.parseDouble(cuenta.getSaldoVencido()));
                         item.setPagoARealizar(item.getPagoARealizar() + Double.parseDouble(cuenta.getMontoPago()));
                     } else {
                         item.setCuentasCerradas(item.getCuentasCerradas() + 1);
                         item.setLimiteCerradas(item.getLimiteCerradas()
                                 + Double.parseDouble(cuenta.getLimiteCredito()));
                         item.setMaximoCerradas(item.getMaximoCerradas()
                                 + Double.parseDouble(cuenta.getCreditoMaximo()));
                         item.setSaldoActualCerradas(item.getSaldoActualCerradas()
                                 + Double.parseDouble(cuenta.getSaldoActual()));
                         item.setMontoCerradas(item.getMontoCerradas() + Double.parseDouble(cuenta.getSaldoVencido()));
                     }
                 }
             }

             if (!existe) {
            	 LogHandler.info(uid, getClass(), "resumenCuenta :::: !existe");
            	 ResumenBuroMop resumen = new ResumenBuroMop();
                 resumen.setMop(cuenta.getFormaPagoActual());
                 LogHandler.info(uid, getClass(), "resumenCuenta :::: getFechaCierreCuenta");
                 if (cuenta.getFechaCierreCuenta().isEmpty()) {
                     resumen.setCuentasAbiertas(resumen.getCuentasAbiertas() + 1);
                     resumen.setLimiteAbiertas(resumen.getLimiteAbiertas()
                             + Double.parseDouble(cuenta.getLimiteCredito()));
                     resumen.setMaximoAbiertas(resumen.getMaximoAbiertas()
                             + Double.parseDouble(cuenta.getCreditoMaximo()));
                     resumen.setSaldoActualAbiertas(resumen.getSaldoActualAbiertas()
                             + Double.parseDouble(cuenta.getSaldoActual()));
                     resumen.setSaldoVencidoAbiertas(resumen.getSaldoVencidoAbiertas()
                             + Double.parseDouble(cuenta.getSaldoVencido()));
                     resumen.setPagoARealizar(resumen.getPagoARealizar() + Double.parseDouble(cuenta.getMontoPago()));
                     LogHandler.info(uid, getClass(), "resumenCuenta :::: getFechaCierreCuenta.isEmpty.fin");
                 } else {
                	 LogHandler.info(uid, getClass(), "resumenCuenta :::: getFechaCierreCuenta is not empty.");
                     resumen.setCuentasCerradas(resumen.getCuentasCerradas() + 1);
                     resumen.setLimiteCerradas(resumen.getLimiteCerradas()
                             + Double.parseDouble(cuenta.getLimiteCredito()));
                     resumen.setMaximoCerradas(resumen.getMaximoCerradas()
                             + Double.parseDouble(cuenta.getCreditoMaximo()));
                     resumen.setSaldoActualCerradas(resumen.getSaldoActualCerradas()
                             + Double.parseDouble(cuenta.getSaldoActual()));
                     resumen.setMontoCerradas(resumen.getMontoCerradas()
                             + Double.parseDouble(cuenta.getSaldoVencido()));
                     LogHandler.info(uid, getClass(), "resumenCuenta :::: getFechaCierreCuenta is not empty fin.");
                 }

               //Se verifica si trae una  cuenta hipotecario o automotriz
     			//Automotriz Hipotecario
     			//M - Hipoteca RE(Bienes Raices)
     			//AU(Compra Automovil)
     			if ( cuenta.getTipoCuenta().trim().equals("M") || cuenta.getTipoContrato().trim().equals("RE")) {
     				resumen.setHipotecario("X");
     			}

     			if (cuenta.getTipoContrato().trim().equals("AU") || cuenta.getNombreOrtogante().trim().equals("AUTOMOTRIZ") ) {
     				resumen.setAutomotriz("X");
     			}

     			//claves de observacion
    			if (listaClavesObs.contains(cuenta.getClaveObservacion())) {
    				clavesObserv = clavesObserv.equals("") ? "" + cuenta.getClaveObservacion()
    						: clavesObserv + ";" + cuenta.getClaveObservacion();
    				resumen.setClaveObservacion(clavesObserv);

    			}
    			// metodo de llena el color de fondo del mop en la vista
    			resumen.setStyleBackground(Validaciones.colorFondo(uid, cuenta.getFormaPagoActual()));
               listaResumen.add(resumen);
             }
	       }
	     }
	  LogHandler.info(uid, getClass(), "agregarCuentaResumen :::: Fin");
      return listaResumen;
	}

	 /**
	  * M&eacute;todo que carga los totales de los mop
      * @param uid identificador &uacute;nico de transacci&oacute;n
	  * @param listaResumen lista de mops
	  */
	 private void agregarTotales(String uid, List<ResumenBuroMop> listaResumen) {
		  LogHandler.info(uid, getClass(), "agregarTotales :::: inicio");
		  ResumenBuroMop totales = new ResumenBuroMop();
	        totales.setMop("T");
	        totales.setStyleBackground("background:rgb(255,255,255)");
	       
	        for (ResumenBuroMop item : listaResumen) {
	            totales.setCuentasAbiertas(totales.getCuentasAbiertas() + item.getCuentasAbiertas());
	            totales.setLimiteAbiertas(totales.getLimiteAbiertas() + item.getLimiteAbiertas());
	            totales.setMaximoAbiertas(totales.getMaximoAbiertas() + item.getMaximoAbiertas());
	            totales.setSaldoActualAbiertas(totales.getSaldoActualAbiertas() + item.getSaldoActualAbiertas());
	            totales.setSaldoVencidoAbiertas(totales.getSaldoVencidoAbiertas() + item.getSaldoVencidoAbiertas());
	            totales.setPagoARealizar(totales.getPagoARealizar() +  item.getPagoARealizar());

	            totales.setCuentasCerradas(totales.getCuentasCerradas() + item.getCuentasCerradas());
	            totales.setLimiteCerradas(totales.getLimiteCerradas() + item.getLimiteCerradas());
	            totales.setMaximoCerradas(totales.getMaximoCerradas() + item.getMaximoCerradas());
	            totales.setSaldoActualCerradas(totales.getSaldoActualCerradas() + item.getSaldoActualCerradas());
	            totales.setMontoCerradas(totales.getMontoCerradas() +  item.getMontoCerradas());
	        }

	        listaResumen.add(totales);
	        LogHandler.info(uid, getClass(), "agregarTotales :::: fin");
	    }
	 
	 /**
	  * metodo que consulta el buro y lo checa de acuerdo a las reglas de buro
	  * @param uid id unico de transaccion
	  * @param peticion peticion 
	  * @return ConsultaSolicitudBuroRespuesta respuesta del estatus de buro de credito.
	  */
	 public ConsultaSolicitudBuroRespuesta obtenerBuroProspectoCaravanas(String uid, ConsultaBuroPeticion peticion) {
		 LogHandler.info(uid, getClass(), "obtenerBuroProspectoCaravanas :::: inicio");
		 ConsultaSolicitudBuroRespuesta respuesta = new ConsultaSolicitudBuroRespuesta();
		 respuesta.setHeader(new EncabezadoRespuesta());
		 ConsultaBuroRespuesta respuestaBuro = null;
		 ValidaBuroDTO buro = null;
		 try {
				 if (peticion == null || peticion.getPersona() == null || peticion.getPersona().trim().isEmpty()
				     || peticion.getUsuario() == null  || peticion.getUsuario().trim().isEmpty() ) {
					 throw new Exception("La peticion de obtenerBuroProspectoCaravanas no es valida....");
				 }
				//sacamos la consulta del buro que nos arroja un xml
				 respuestaBuro = consultaBuroCredito(uid, peticion);
				 
				 if (respuestaBuro == null) {
					 respuesta.getHeader().setEstatus(false);
					 respuesta.getHeader().setMensaje("no se recupero la consulta de buro de credito para la persona: " + peticion.getPersona());
		             throw new Exception("no se recupero la consulta de buro de credito para la persona: " + peticion.getPersona()); 
				 }
				 
				 if ( !respuestaBuro.getHeader().isEstatus()) {
					 respuesta.getHeader().setEstatus(false);
					 respuesta.getHeader().setMensaje(respuestaBuro.getHeader().getMensaje());
		             throw new Exception(respuestaBuro.getHeader().getMensaje());
		         }
				 
				 if (respuestaBuro.getBuroCreditoXML() == null) {
					 respuesta.getHeader().setEstatus(false);
					 respuesta.getHeader().setMensaje("No se encontraron datos de buro para la persona:" + peticion.getPersona());
		             throw new Exception("No se encontraron datos de buro para la persona:" + peticion.getPersona());
		         }
				 LogHandler.info(uid, getClass(), "obtenerBuroProspectoCaravanas ::::xml de buro de la personas:" + peticion.getPersona());
				 LogHandler.info(uid, getClass(), "obtenerBuroProspectoCaravanas :::: xml de buro:" + respuestaBuro.getBuroCreditoXML());
				 
				 //convertimos el xml de buro a un objeto
				 ReporteCredito reporteCredito = obtenerObjetoBCN(respuestaBuro.getBuroCreditoXML());
				 
				 LogHandler.info(uid, getClass(), "obtenerBuroProspectoCaravanas ::::objeto de buro de la personas:" + peticion.getPersona());
				 LogHandler.info(uid, getClass(), "obtenerBuroProspectoCaravanas :::: objeto de buro:" + reporteCredito);
				 
				 if (reporteCredito != null && reporteCredito.getCuentas() != null && reporteCredito.getCuentas().size() > 0) {
					 //validacion de reglas de buro encaso de contar
					 buro = obtenerDatosValidacionOriginacion(reporteCredito);
					 
					 if (buro != null) {
						 if (buro.getTotalHipotecarioMop01() > 0) {
							 respuesta.getHeader().setEstatus(false);
							 respuesta.getHeader().setMensaje("El Buró de crédito de " + peticion.getPersona()
							 + " no es bueno, contiene mop hipotecario mayor a 1 ");
						 } else if (buro.getTotalAutomotrizMop02() > 0) {
							 respuesta.getHeader().setEstatus(false);
							 respuesta.getHeader().setMensaje("El Buró de crédito de " + peticion.getPersona()
							 + " no es bueno, contiene mops automotiz mayor a 2 ");
						 } else if (buro.getTotalMop99() > 0) {
							 respuesta.getHeader().setEstatus(false);
							 respuesta.getHeader().setMensaje("El Buró de crédito de " + peticion.getPersona()
							 + " no es bueno, contiene mops 99 ");
						 } else if (!buro.getMop99().getClavesObserv().trim().isEmpty()) {
							 respuesta.getHeader().setEstatus(false);
							 respuesta.getHeader().setMensaje("El Buró de crédito de " + peticion.getPersona()
							 + " no es bueno, contiene las siguientes claves de observacion: " + buro.getMop99().getClavesObserv().trim());
						 } else {
							 respuesta.getHeader().setEstatus(true);
							 respuesta.getHeader().setMensaje("El Buró de crédito de " + peticion.getPersona() + " es bueno.");
						 }
					 } else {
						 respuesta.getHeader().setEstatus(true);
						 respuesta.getHeader().setMensaje("El Buró de crédito de " + peticion.getPersona() + " es bueno.");
					 }
					 
				 } else {
					 respuesta.getHeader().setEstatus(true);
					 respuesta.getHeader().setMensaje("El Buró de crédito de " + peticion.getPersona() + " es bueno.");
					 LogHandler.info(uid, getClass(), "obtenerBuroProspectoCaravanas :::no hay cuentas que mostar..." );
				 }
		 } catch (Exception ex) {
			 respuesta.getHeader().setEstatus(false);
			 respuesta.getHeader().setMensaje(ex.getMessage());
			 LogHandler.error(uid, getClass(), ex.getMessage(), ex );
		 }
		 	 
		 LogHandler.info(uid, getClass(), "obtenerBuroProspectoCaravanas :::: Fin");
		 return respuesta; 
	 }
}


