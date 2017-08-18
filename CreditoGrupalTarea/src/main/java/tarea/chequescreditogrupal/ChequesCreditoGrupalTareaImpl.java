/**
 *
 */
package tarea.chequescreditogrupal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.osoa.sca.annotations.Scope;
import entidad.conexiones.FabricaConexiones;
import utilitario.comun.Funciones;
import utilitario.comun.Validaciones;
import utilitario.log.LogHandler;
import utilitario.mensajes.chequescreditogrupal.ChequesCliente;
import utilitario.mensajes.chequescreditogrupal.ChequesClientePeticion;
import utilitario.mensajes.chequescreditogrupal.ChequesClienteRespuesta;
import utilitario.mensajes.chequescreditogrupal.ChequesDesembolsados;
import utilitario.mensajes.chequescreditogrupal.ChequesDesembolsadosPeticion;
import utilitario.mensajes.chequescreditogrupal.ChequesDesembolsadosRespuesta;
import utilitario.mensajes.chequescreditogrupal.ChequesFolio;
import utilitario.mensajes.chequescreditogrupal.ChequesOV;
import utilitario.mensajes.chequescreditogrupal.ChequesPrimerPago;
import utilitario.mensajes.chequescreditogrupal.ChequesRegeneraFolioPeticion;
import utilitario.mensajes.chequescreditogrupal.ChequesRegeneraFolioRespuesta;
import utilitario.mensajes.chequescreditogrupal.FolioImp;
import utilitario.mensajes.chequescreditogrupal.FoliosImpRespuesta;
import utilitario.mensajes.chequescreditogrupal.FoliosRespuesta;
import utilitario.mensajes.chequescreditogrupal.ProcUniversoPrimerPagoRespuesta;
import utilitario.mensajes.chequescreditogrupal.UniversoPrimerPagoPeticion;
import utilitario.mensajes.chequescreditogrupal.UniversoPrimerPagoRespuesta;
import utilitario.mensajes.chequescreditogrupal.ValeCreditoPeticion;
import utilitario.mensajes.chequescreditogrupal.ValeRenovado;
import utilitario.mensajes.chequescreditogrupal.ValesRenovadosRespuesta;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.impresiondocs.comun.ContratoPeticionKit;


/**
 * The Class ChequesCreditoGrupalTareaImpl.
 *
 * @author out_ltorres
 */
@Scope("COMPOSITE")
public class ChequesCreditoGrupalTareaImpl implements ChequesCreditoGrupalTarea {

	/**
	 * Instancia una nueva cheques credito grupal tarea impl.
	 */
	public ChequesCreditoGrupalTareaImpl() {
	}

	/**
	 * Obtiene universo primer pago tarea.
	 *
	 * @param uid the uid
	 * @param universoPrimerPagoPeticion the universo primer pago peticion
	 * @return universo primer pago tarea
	 * @see tarea.chequescreditogrupal.ChequesCreditoGrupalTarea#getUniversoPrimerPagoTarea(
	 * java.lang.String, utilitario.mensajes.chequescreditogrupal.UniversoPrimerPagoPeticion)
	 */
	@SuppressWarnings("unchecked")
	public UniversoPrimerPagoRespuesta getUniversoPrimerPagoTarea(
			String uid, UniversoPrimerPagoPeticion universoPrimerPagoPeticion) {
		UniversoPrimerPagoRespuesta universoPrimerPagoRespuesta = new UniversoPrimerPagoRespuesta();
		universoPrimerPagoRespuesta.setHeader(new EncabezadoRespuesta());
		universoPrimerPagoRespuesta.getHeader().setUID(uid);
		universoPrimerPagoRespuesta.getHeader().setEstatus(true);

		String fechaProcesoSemanal			= null;
		String fechaProcesoCatorcenal		= null;
		HashMap<String, Object> paramsQuery	= new HashMap<String, Object>();
		SqlSession sessionNTx				= null;

		try {
			fechaProcesoSemanal    = universoPrimerPagoPeticion.getFechaProcesoSemanal();
			fechaProcesoCatorcenal = universoPrimerPagoPeticion.getFechaProcesoCatorcenal();

			if (!Validaciones.fechaValida(fechaProcesoSemanal)) {
				LogHandler.info(uid, getClass(),
				"getUniversoPrimerPagoTarea: - " + FECHA_INVALIDA + " :: Fecha Semanal: " + fechaProcesoSemanal);
				throw new Exception(FECHA_INVALIDA);
			}
			if (!Validaciones.fechaValida(fechaProcesoCatorcenal)) {
				LogHandler.info(uid, getClass(),
				"getUniversoPrimerPagoTarea: - " + FECHA_INVALIDA + " :: Fecha Catorcenal: "
				+ fechaProcesoCatorcenal);
				throw new Exception(FECHA_INVALIDA);
			}
			//Se abre la session No transaccional sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			String dbEntorno = sessionNTx.getConfiguration().getVariables().getProperty("db.entorno");
			LogHandler.info(uid, getClass(), "getUniversoPrimerPagoTarea: - dbEntorno: " + dbEntorno);
			paramsQuery.put("dbEntorno", 				dbEntorno);
			paramsQuery.put("fechaProcesoSemanal",    	fechaProcesoSemanal);
			paramsQuery.put("fechaProcesoCatorcenal", 	fechaProcesoCatorcenal);
			LogHandler.trace(uid, getClass(), "getUniversoPrimerPagoTarea: - consultaGetUniversoPrimerPago");
			LogHandler.info(uid, getClass(), "getUniversoPrimerPagoTarea: - consultaGetUniversoPrimerPago");
			List<ChequesPrimerPago> chequesPrimerPagoQueryResult =
					sessionNTx.selectList("consultaGetUniversoPrimerPago", paramsQuery);

			if (chequesPrimerPagoQueryResult.isEmpty()) {
				throw new Exception(CONSULTA_SINREGISTROS);
			}

			universoPrimerPagoRespuesta.setCheques(chequesPrimerPagoQueryResult);
		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "getUniversoPrimerPagoTarea: " + ex.getMessage(), ex);
			universoPrimerPagoRespuesta.getHeader().setEstatus(false);
			universoPrimerPagoRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			universoPrimerPagoRespuesta.getHeader().setCodigo(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return universoPrimerPagoRespuesta;
	}

	/**
	 * Proc_get_folios tarea.
	 *
	 * @param uid the uid
	 * @param contratoPeticionKit the contrato peticion kit
	 * @return the folios respuesta
	 * @see tarea.chequescreditogrupal.ChequesCreditoGrupalTarea#proc_get_foliosTarea(
	 * java.lang.String, utilitario.mensajes.impresiondocs.comun.ContratoPeticionKit)
	 */
	@SuppressWarnings("unchecked")
	public FoliosRespuesta proc_get_foliosTarea(String uid, ContratoPeticionKit contratoPeticionKit) {
		FoliosRespuesta foliosRespuesta = new FoliosRespuesta();
		foliosRespuesta.setHeader(new EncabezadoRespuesta());
		foliosRespuesta.getHeader().setUID(uid);
		foliosRespuesta.getHeader().setEstatus(true);

		SqlSession sessionNTx				= null;
		String contrato = null;

		try {
			contrato = contratoPeticionKit.getContrato();
			if (contrato == null || contrato.isEmpty( )) {
				throw new Exception(CONTRATO_INVALIDO);
			}

			//Se abre la session No transaccional sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(), "proc_get_foliosTarea: - consultaProc_get_folios");
			LogHandler.info(uid, getClass(), "proc_get_foliosTarea: - consultaProc_get_folios");
			List<ChequesFolio> chequesFolioQueryResult = sessionNTx.selectList("consultaProc_get_folios", contrato);
			if (chequesFolioQueryResult.isEmpty()) {
				throw new Exception(CONSULTA_SINREGISTROS);
			}

			foliosRespuesta.setFolios(chequesFolioQueryResult);
		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "proc_get_foliosTarea: " + ex.getMessage(), ex);
			foliosRespuesta.getHeader().setEstatus(false);
			foliosRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			foliosRespuesta.getHeader().setCodigo(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return foliosRespuesta;
	}


	/**
	 * Proc_save_clientes tarea.
	 *
	 * @param uid the uid
	 * @param chequesClientePeticion the cheques cliente peticion
	 * @return the cheques cliente respuesta
	 * @see tarea.chequescreditogrupal.ChequesCreditoGrupalTarea#proc_save_clientesTarea(
	 * java.lang.String, utilitario.mensajes.chequescreditogrupal.ChequesClientePeticion)
	 */
	public ChequesClienteRespuesta proc_save_clientesTarea(String uid, ChequesClientePeticion chequesClientePeticion) {
		ChequesClienteRespuesta chequesClienteRespuesta = new ChequesClienteRespuesta();
		chequesClienteRespuesta.setHeader(new EncabezadoRespuesta());
		chequesClienteRespuesta.getHeader().setUID(uid);
		chequesClienteRespuesta.getHeader().setEstatus(true);
		SqlSession sessionTx				= null;

		HashMap<String, Object> paramsQuery	= new HashMap<String, Object>();
		String validaStr = "";

		try {
			List <ChequesCliente> chequesClienteList = new ArrayList<ChequesCliente>();
			chequesClienteList = chequesClientePeticion.getCheques();
			//Se abre la session Transaccional sybase
			sessionTx = FabricaConexiones.obtenerSesionTx();
			String dbEntorno = sessionTx.getConfiguration().getVariables().getProperty("db.entorno");
			LogHandler.info(uid, getClass(), "getUniversoPrimerPagoTarea: - dbEntorno: " + dbEntorno);
			// Verificar que la peticion tenga los datos requeridos.
			for (int i = 0; i < chequesClienteList.size(); i++) {
				validaStr = Validaciones.datosRequeridos(chequesClienteList.get(i));
				if (!validaStr.equalsIgnoreCase("")) {
					throw new Exception(DATOS_REQUERIDOS + validaStr);
				}
			}

			for (int i = 0; i < chequesClienteList.size(); i++) {
				paramsQuery	= new HashMap<String, Object>();
				paramsQuery = Funciones.objectToHashMapUpdate(chequesClienteList.get(i));
				paramsQuery.put("dbEntorno", dbEntorno);
				LogHandler.trace(uid, getClass(), "proc_save_clientesTarea: - actualizarProc_save_clientes");
				LogHandler.info(uid, getClass(), "proc_save_clientesTarea: - actualizarProc_save_clientes");
				int registrosAfectados = sessionTx.update( "actualizarProc_save_clientes", paramsQuery);
				LogHandler.info(uid, getClass(),
						"proc_save_clientesTarea: - registrosAfectados: " + registrosAfectados);
				if (registrosAfectados == 0) {
					throw new Exception(ERROR_ACTUALIZACION);
				}
			}
			sessionTx.commit(true);
			chequesClienteRespuesta.getHeader().setMensaje("CHEQUES SE ACTUALIZARON CORRECTAMENTE");
		}
		catch (Exception ex) {
			FabricaConexiones.rollBack(sessionTx);
			LogHandler.error(uid, getClass(), "proc_save_clientesTarea: " + ex.getMessage(), ex);
			chequesClienteRespuesta.getHeader().setEstatus(false);
			chequesClienteRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			chequesClienteRespuesta.getHeader().setCodigo(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionTx);
		}
		return chequesClienteRespuesta;
	}


	/**
	 * Proc_regenera_folio tarea.
	 *
	 * @param uid String
	 * @param chequesRegeneraFolioPeticion the cheques regenera folio peticion
	 * @return the cheques regenera folio respuesta
	 * @see tarea.chequescreditogrupal.ChequesCreditoGrupalTarea#proc_regenera_folioTarea(
	 * java.lang.String, utilitario.mensajes.chequescreditogrupal.ChequesRegeneraFolioPeticion)
	 */
	public ChequesRegeneraFolioRespuesta proc_regenera_folioTarea(
			String uid, ChequesRegeneraFolioPeticion chequesRegeneraFolioPeticion) {
		ChequesRegeneraFolioRespuesta chequesRegeneraFolioRespuesta = new ChequesRegeneraFolioRespuesta();
		chequesRegeneraFolioRespuesta.setHeader(new EncabezadoRespuesta());
		chequesRegeneraFolioRespuesta.getHeader().setUID(uid);
		chequesRegeneraFolioRespuesta.getHeader().setEstatus(true);

		SqlSession sessionTx				= null;
		String validaStr = "";
		try {
			String[] camposValidar = {"folioAnterior", "folioNuevo"};

			validaStr = Validaciones.datosRequeridos(chequesRegeneraFolioPeticion, camposValidar);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			//Se abre la session No transaccional sybase
			sessionTx = FabricaConexiones.obtenerSesionTx();

			HashMap<String, Object> paramsQuery = Funciones.objectToHashMapUpdate(chequesRegeneraFolioPeticion);
			String dbEntorno = sessionTx.getConfiguration().getVariables().getProperty("db.entorno");
			LogHandler.info(uid, getClass(), "getUniversoPrimerPagoTarea: - dbEntorno: " + dbEntorno);
			paramsQuery.put("dbEntorno", dbEntorno);
			LogHandler.info(uid, getClass(), "proc_regenera_folioTarea: - \n\nparamsQuery: " + paramsQuery + "\n\n");

			LogHandler.trace(uid, getClass(), "proc_regenera_folioTarea: - actualizarProc_regenera_folio");
			LogHandler.info(uid, getClass(), "proc_regenera_folioTarea: - actualizarProc_regenera_folio");
			int registrosAfectados = sessionTx.update( "actualizarProc_regenera_folio", paramsQuery);

			LogHandler.info(uid, getClass(), "proc_regenera_folioTarea: - registrosAfectados: " + registrosAfectados);
			if (registrosAfectados == 0) {
				throw new Exception(ERROR_ACTUALIZACION);
			}

			chequesRegeneraFolioRespuesta.setFolioNuevo(chequesRegeneraFolioPeticion.getFolioNuevo());
			sessionTx.commit(true);
			chequesRegeneraFolioRespuesta.getHeader().setMensaje("REGENERACION DE FOLIO SE REALIZO CORRECTAMENTE");
		}
		catch (Exception ex) {
			FabricaConexiones.rollBack(sessionTx);
			LogHandler.error(uid, getClass(), "proc_regenera_folioTarea: " + ex.getMessage(), ex);
			chequesRegeneraFolioRespuesta.getHeader().setEstatus(false);
			chequesRegeneraFolioRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			chequesRegeneraFolioRespuesta.getHeader().setCodigo(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionTx);
		}
		return chequesRegeneraFolioRespuesta;
	}


	/**
	 * Proc_get_folios_imp tarea.
	 *
	 * @param uid the uid
	 * @param contratoPeticionKit the contrato peticion kit
	 * @return the folios imp respuesta
	 * @see tarea.chequescreditogrupal.ChequesCreditoGrupalTarea#proc_get_folios_impTarea(
	 * java.lang.String, utilitario.mensajes.impresiondocs.comun.ContratoPeticionKit)
	 */
	@SuppressWarnings("unchecked")
	public FoliosImpRespuesta proc_get_folios_impTarea(String uid, ContratoPeticionKit contratoPeticionKit) {
		FoliosImpRespuesta procGetFoliosImpRespuesta = new FoliosImpRespuesta();
		procGetFoliosImpRespuesta.setHeader(new EncabezadoRespuesta());
		procGetFoliosImpRespuesta.getHeader().setUID(uid);
		procGetFoliosImpRespuesta.getHeader().setEstatus(true);
		List<FolioImp> procGetFoliosImpList	= null;
		SqlSession sesionNTx				= null;
		String validaStr = "";
		try {
			String[] validaContrato = {"contrato"};

			validaStr = Validaciones.datosRequeridos(contratoPeticionKit, validaContrato);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}
			// Se abre la session No transaccional sybase
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(), "proc_get_folios_impTarea: - consultaProc_get_folios_imp");
			LogHandler.info(uid, getClass(), "proc_get_folios_impTarea: - consultaProc_get_folios_imp");
			procGetFoliosImpList = sesionNTx.selectList(
					"consultaProc_get_folios_imp", contratoPeticionKit.getContrato());

			if (procGetFoliosImpList.isEmpty()) {
				throw new Exception(CONSULTA_SIN_REGISTROS);
			}
			procGetFoliosImpRespuesta.setFolios(procGetFoliosImpList);
		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "proc_get_folios_impTarea: " + ex.getMessage(), ex);
			procGetFoliosImpRespuesta.getHeader().setEstatus(false);
			procGetFoliosImpRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			procGetFoliosImpRespuesta.getHeader().setCodigo(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sesionNTx);
		}
		return procGetFoliosImpRespuesta;
	}


	/**
	 * Obtiene vale renovado tarea.
	 *
	 * @param uid the uid
	 * @param contratoPeticionKit the contrato peticion kit
	 * @return vale renovado tarea
	 * @see tarea.chequescreditogrupal.ChequesCreditoGrupalTarea#getvaleRenovadoTarea(
	 * java.lang.String, utilitario.mensajes.impresiondocs.comun.ContratoPeticionKit)
	 */
	@SuppressWarnings("unchecked")
	public ValesRenovadosRespuesta getvaleRenovadoTarea(String uid, ContratoPeticionKit contratoPeticionKit) {
		ValesRenovadosRespuesta valesRenovadosRespuesta = new ValesRenovadosRespuesta();
		valesRenovadosRespuesta.setHeader(new EncabezadoRespuesta());
		valesRenovadosRespuesta.getHeader().setUID(uid);
		valesRenovadosRespuesta.getHeader().setEstatus(true);
		List<ValeRenovado> valeRenovadoList	= null;
		SqlSession sesionNTx				= null;
		String validaStr 					= "";
		try {
			String[] validaContrato = {"contrato"};
			validaStr = Validaciones.datosRequeridos(contratoPeticionKit, validaContrato);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			// Se abre la sesion No transaccional sybase
			sesionNTx = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(), "getvaleRenovadoTarea: - consultaGetvaleRenovado");
			LogHandler.info(uid, getClass(), "getvaleRenovadoTarea: - consultaGetvaleRenovado");
			valeRenovadoList = sesionNTx.selectList("consultaGetvaleRenovado", contratoPeticionKit.getContrato());

			if (valeRenovadoList.isEmpty()) {
				throw new Exception(CONSULTA_SIN_REGISTROS);
			}
			valesRenovadosRespuesta.setVales(valeRenovadoList);
		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "getvaleRenovadoTarea: " + ex.getMessage(), ex);
			valesRenovadosRespuesta.getHeader().setEstatus(false);
			valesRenovadosRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			valesRenovadosRespuesta.getHeader().setCodigo(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sesionNTx);
		}
		return valesRenovadosRespuesta;
	}


	/**
	 * Insertalogvale tarea.
	 *
	 * @param uid the uid
	 * @param valeCreditoPeticion the vale credito peticion
	 * @return the vales renovados respuesta
	 * @see tarea.chequescreditogrupal.ChequesCreditoGrupalTarea#insertalogvaleTarea(
	 * java.lang.String, utilitario.mensajes.chequescreditogrupal.ValeCreditoPeticion)
	 */
	public ValesRenovadosRespuesta insertalogvaleTarea(String uid, ValeCreditoPeticion valeCreditoPeticion) {
		ValesRenovadosRespuesta valesRenovadosRespuesta = new ValesRenovadosRespuesta();
		valesRenovadosRespuesta.setHeader(new EncabezadoRespuesta());
		valesRenovadosRespuesta.getHeader().setUID(uid);
		valesRenovadosRespuesta.getHeader().setEstatus(true);
		SqlSession sesionTx				= null;
		String validaStr				= "";
		try {
			java.util.HashMap<String, Object> valeParametros =  new java.util.HashMap<String, Object>();
			String[] validaContrato = {"ldConsul", "customerId", "amount", "noVale"};

			validaStr = Validaciones.datosRequeridos(valeCreditoPeticion, validaContrato);
			if (!validaStr.equalsIgnoreCase("")) {
				throw new Exception(DATOS_REQUERIDOS + validaStr);
			}

			// Se abre la sesion No transaccional sybase
			sesionTx = FabricaConexiones.obtenerSesionTx();

			valeParametros =  new java.util.HashMap<String, Object>();
			valeParametros = Funciones.objectToHashMapInsert(valeCreditoPeticion);

			LogHandler.trace(uid, getClass(), "insertalogvaleTarea: - insertaInsertalogvale");
			LogHandler.info(uid, getClass(), "insertalogvaleTarea: - insertaInsertalogvale");
			int registrosAfectados = sesionTx.insert("insertaInsertalogvale", valeParametros);
			LogHandler.info(uid, getClass(), "insertalogvaleTarea: - registrosAfectados: " + registrosAfectados);
			if (registrosAfectados == 0) {
				throw new Exception(INSERCION_SINREGISTROS);
			}
			valesRenovadosRespuesta.getHeader().setMensaje(OK_INSERCION);
			sesionTx.commit(true);
		}
		catch (Exception ex) {
			FabricaConexiones.rollBack(sesionTx);
			LogHandler.error(uid, getClass(), "insertalogvaleTarea: " + ex.getMessage(), ex);
			valesRenovadosRespuesta.getHeader().setEstatus(false);
			valesRenovadosRespuesta.getHeader().setMensaje(ERROR_INSERCION);
			valesRenovadosRespuesta.getHeader().setCodigo(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sesionTx);
		}
		return valesRenovadosRespuesta;
	}


	/**
	 * Metodo retorna universo de cheques
	 * @param uid String
	 * @param universoPrimerPagoPeticion UniversoPrimerPagoPeticion
	 * @return respuesta
	 */
	@SuppressWarnings("unchecked")
	public ProcUniversoPrimerPagoRespuesta proc_get_universo_primer_pagoTarea(
			String uid, UniversoPrimerPagoPeticion universoPrimerPagoPeticion) {
		ProcUniversoPrimerPagoRespuesta procUniversoPrimerPagoRespuesta = new ProcUniversoPrimerPagoRespuesta();
		procUniversoPrimerPagoRespuesta.setHeader(new EncabezadoRespuesta());
		procUniversoPrimerPagoRespuesta.getHeader().setUID(uid);
		procUniversoPrimerPagoRespuesta.getHeader().setEstatus(true);

		String fechaProcesoSemanal			= null;
		String fechaProcesoCatorcenal		= null;
		HashMap<String, Object> paramsQuery	= new HashMap<String, Object>();
		SqlSession sessionNTx				= null;

		try {
			fechaProcesoSemanal    = universoPrimerPagoPeticion.getFechaProcesoSemanal();
			fechaProcesoCatorcenal = universoPrimerPagoPeticion.getFechaProcesoCatorcenal();

			if (!Validaciones.fechaValida(fechaProcesoSemanal)) {
				LogHandler.info(uid, getClass(),
						"proc_get_universo_primer_pago: - " + FECHA_INVALIDA + " :: Fecha Semanal: " + fechaProcesoSemanal);
				throw new Exception(FECHA_INVALIDA);
			}
			if (!Validaciones.fechaValida(fechaProcesoCatorcenal)) {
				LogHandler.info(uid, getClass(),
						"proc_get_universo_primer_pago: - " + FECHA_INVALIDA + " :: Fecha Catorcenal: " + fechaProcesoCatorcenal);
				throw new Exception(FECHA_INVALIDA);
			}
			//Se abre la session No transaccional sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();
			paramsQuery.put("fechaProcesoSemanal",    	fechaProcesoSemanal);
			paramsQuery.put("fechaProcesoCatorcenal", 	fechaProcesoCatorcenal);
			LogHandler.trace(uid, getClass(), "proc_get_universo_primer_pago: - consultaprocGetUniversoPrimerPago");
			LogHandler.info(uid, getClass(), "proc_get_universo_primer_pago: - consultaprocGetUniversoPrimerPago");
			List<ChequesOV> chequesPrimerPagoQueryResult =
					sessionNTx.selectList("consultaprocGetUniversoPrimerPago", paramsQuery);

			if (chequesPrimerPagoQueryResult.isEmpty()) {
				throw new Exception(CONSULTA_SINREGISTROS);
			}
			procUniversoPrimerPagoRespuesta.setCheques(chequesPrimerPagoQueryResult);
		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "proc_get_universo_primer_pago: " + ex.getMessage(), ex);
			procUniversoPrimerPagoRespuesta.getHeader().setEstatus(false);
			procUniversoPrimerPagoRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			procUniversoPrimerPagoRespuesta.getHeader().setCodigo(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return procUniversoPrimerPagoRespuesta;
	}

	/**
	 * Obtiene cheques desembolsados tarea.
	 *
	 * @param uid the uid
	 * @param chequesDesembolsadosPeticion the cheques desembolsados peticion
	 * @return cheques desembolsados tarea
	 * @see tarea.chequescreditogrupal.ChequesCreditoGrupalTarea#getChequesDesembolsadosTarea(
	 * java.lang.String, utilitario.mensajes.chequescreditogrupal.ChequesDesembolsadosPeticion)
	 */
	@SuppressWarnings("unchecked")
	public ChequesDesembolsadosRespuesta getChequesDesembolsadosTarea(
			String uid, ChequesDesembolsadosPeticion chequesDesembolsadosPeticion) {
		ChequesDesembolsadosRespuesta chequesDesembolsadosRespuesta = new ChequesDesembolsadosRespuesta();
		chequesDesembolsadosRespuesta.setHeader(new EncabezadoRespuesta());
		chequesDesembolsadosRespuesta.getHeader().setUID(uid);
		chequesDesembolsadosRespuesta.getHeader().setEstatus(true);
		chequesDesembolsadosRespuesta.getHeader().setMensaje("");

		String fechaInicial			= null;
		String fechaFinal		= null;
		HashMap<String, Object> paramsQuery	= new HashMap<String, Object>();
		SqlSession sessionNTx				= null;

		try {
			fechaInicial    = chequesDesembolsadosPeticion.getFechaInicial();
			fechaFinal = chequesDesembolsadosPeticion.getFechaFinal();

			if (!Validaciones.fechaValida(fechaInicial)) {
				LogHandler.info(uid, getClass(),
				"getChequesDesembolsadosTarea: - " + FECHA_INVALIDA + " :: Fecha Inicial: " + fechaInicial);
				throw new Exception(FECHA_INVALIDA);
			}
			if (!Validaciones.fechaValida(fechaFinal)) {
				LogHandler.info(uid, getClass(),
				"getChequesDesembolsadosTarea: - " + FECHA_INVALIDA + " :: Fecha Final: "
				+ fechaFinal);
				throw new Exception(FECHA_INVALIDA);
			}
			//Se abre la session No transaccional sybase
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			String dbEntorno = sessionNTx.getConfiguration().getVariables().getProperty("db.entorno");
			LogHandler.info(uid, getClass(), "getChequesDesembolsadosTarea: - dbEntorno: " + dbEntorno);
			paramsQuery.put("dbEntorno", 				dbEntorno);
			paramsQuery.put("fechaInicial",    	fechaInicial);
			paramsQuery.put("fechaFinal", 	fechaFinal);
			LogHandler.trace(uid, getClass(), "getChequesDesembolsadosTarea: - consultaChequesDesembolsados");
			LogHandler.info(uid, getClass(), "getChequesDesembolsadosTarea: - consultaChequesDesembolsados");
			List<ChequesDesembolsados> chequesDesembolsadosQueryResult =
					sessionNTx.selectList("consultaChequesDesembolsados", paramsQuery);

			if (chequesDesembolsadosQueryResult.isEmpty()) {
				throw new Exception(CONSULTA_SINREGISTROS);
			}

			chequesDesembolsadosRespuesta.setCheques(chequesDesembolsadosQueryResult);
		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "getChequesDesembolsadosTarea: " + ex.getMessage(), ex);
			chequesDesembolsadosRespuesta.getHeader().setEstatus(false);
			chequesDesembolsadosRespuesta.getHeader().setMensaje(ERROR_CONSULTA);
			chequesDesembolsadosRespuesta.getHeader().setCodigo(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return chequesDesembolsadosRespuesta;
	}

}
