package negocio.chequescreditogrupal;

import org.osoa.sca.annotations.Reference;
import org.osoa.sca.annotations.Service;

import tarea.chequescreditogrupal.ChequesCreditoGrupalTarea;
import transformador.Transformador;
import utilitario.comun.GUIDGenerator;
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
import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.impresiondocs.comun.ContratoPeticionKit;

/**
 * @author out_ltorres
 *
 */
@Service(value = ChequesCreditoGrupal.class)
public class ChequesCreditoGrupalImpl implements ChequesCreditoGrupal {

	/**
	 * Transformador SCA
	 */
	private Transformador transformador;
	/**
	 * ChequesCreditoGrupalTarea SCA
	 */
	private ChequesCreditoGrupalTarea chequesCreditoGrupalTarea;

	/**
	 * @param transformador :
	 * @param chequesCreditoGrupalTarea Constructor
	 */
	public ChequesCreditoGrupalImpl(	@Reference(name = "transformador") Transformador transformador,
								@Reference(name = "chequesCreditoGrupalTarea") ChequesCreditoGrupalTarea chequesCreditoGrupalTarea
									) {
		this.transformador = transformador;
		this.chequesCreditoGrupalTarea = chequesCreditoGrupalTarea;
	}

	/**
	 * @param peticionXML :
	 * @return String XML respuesta
	 */
	public String getUniversoPrimerPago(String peticionXML) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "getUniversoPrimerPago: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {UniversoPrimerPagoPeticion.class,
									UniversoPrimerPagoRespuesta.class,
									ChequesPrimerPago.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final UniversoPrimerPagoPeticion   universoPrimerPagoPeticion
		                       = (UniversoPrimerPagoPeticion) transformador.transformaXMLAObjeto(uid, peticionXML, clases);
		LogHandler.info(uid, getClass(), "getUniversoPrimerPago: - Datos de entrada: " + universoPrimerPagoPeticion);

		//Llamado a funci�n principal
		final UniversoPrimerPagoRespuesta respuesta
				= chequesCreditoGrupalTarea.getUniversoPrimerPagoTarea(uid, universoPrimerPagoPeticion);
		LogHandler.info(uid, getClass(), "getUniversoPrimerPago: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "getUniversoPrimerPago: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticionXML :
	 * @return String XML respuesta
	 */
	public String proc_get_folios(String peticionXML) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "proc_get_folios: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {ContratoPeticionKit.class,
									FoliosRespuesta.class,
									ChequesFolio.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ContratoPeticionKit   contratoPeticionKit
		                       = (ContratoPeticionKit) transformador.transformaXMLAObjeto(uid, peticionXML, clases);
		LogHandler.info(uid, getClass(), "proc_get_folios: - Datos de entrada: " + contratoPeticionKit);

		//Llamado a funci�n principal
		final FoliosRespuesta respuesta = chequesCreditoGrupalTarea.proc_get_foliosTarea(uid, contratoPeticionKit);
		LogHandler.info(uid, getClass(), "proc_get_folios: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		return respuestaXML;
	}

	/**
	 * @param peticionXML :
	 * @return String XML respuesta
	 */
	public String proc_save_clientes(String peticionXML) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "proc_save_clientes: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {ChequesClientePeticion.class,
									ChequesClienteRespuesta.class,
									ChequesCliente.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ChequesClientePeticion   chequesClientePeticion
		                       = (ChequesClientePeticion) transformador.transformaXMLAObjeto(uid, peticionXML, clases);
		LogHandler.info(uid, getClass(), "proc_save_clientes: - Datos de entrada: " + chequesClientePeticion);

		//Llamado a funci�n principal
		final ChequesClienteRespuesta respuesta = chequesCreditoGrupalTarea.proc_save_clientesTarea(uid, chequesClientePeticion);
		LogHandler.info(uid, getClass(), "proc_save_clientes: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "proc_save_clientes: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticionXML :
	 * @return String XML respuesta
	 */
	public String proc_regenera_folio(String peticionXML) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "proc_regenera_folio: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {ChequesRegeneraFolioPeticion.class,
									ChequesRegeneraFolioRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ChequesRegeneraFolioPeticion   chequesRegeneraFolioPeticion
		                       = (ChequesRegeneraFolioPeticion) transformador.transformaXMLAObjeto(uid, peticionXML, clases);
		LogHandler.info(uid, getClass(), "proc_regenera_folio: - Datos de entrada: " + chequesRegeneraFolioPeticion);

		//Llamado a funci�n principal
		final ChequesRegeneraFolioRespuesta respuesta
				= chequesCreditoGrupalTarea.proc_regenera_folioTarea(uid, chequesRegeneraFolioPeticion);
		LogHandler.info(uid, getClass(), "proc_regenera_folio: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "proc_regenera_folio: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticionXML :
	 * @return String XML respuesta
	 */
	public String proc_get_folios_imp(String peticionXML) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "proc_get_folios_imp: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {ContratoPeticionKit.class,
									FolioImp.class,
									FoliosImpRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ContratoPeticionKit   contratoPeticionKit
		                       = (ContratoPeticionKit) transformador.transformaXMLAObjeto(uid, peticionXML, clases);
		LogHandler.info(uid, getClass(), "proc_get_folios_imp: - Datos de entrada: " + contratoPeticionKit);

		//Llamado a funci�n principal
		final FoliosImpRespuesta respuesta = chequesCreditoGrupalTarea.proc_get_folios_impTarea(uid, contratoPeticionKit);
		LogHandler.info(uid, getClass(), "proc_get_folios_imp: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "proc_get_folios_imp: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticionXML :
	 * @return String XML respuesta
	 */
	public String getvaleRenovado(String peticionXML) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "getvaleRenovado: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {ContratoPeticionKit.class,
									ValeRenovado.class,
									ValesRenovadosRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ContratoPeticionKit   contratoPeticionKit
		                       = (ContratoPeticionKit) transformador.transformaXMLAObjeto(uid, peticionXML, clases);
		LogHandler.info(uid, getClass(), "getvaleRenovado: - Datos de entrada: " + contratoPeticionKit);

		//Llamado a funci�n principal
		final ValesRenovadosRespuesta respuesta = chequesCreditoGrupalTarea.getvaleRenovadoTarea(uid, contratoPeticionKit);
		LogHandler.info(uid, getClass(), "getvaleRenovado: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "getvaleRenovado: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}


	/**
	 * @param peticionXML :
	 * @return String XML respuesta
	 */
	public String insertalogvale(String peticionXML) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "insertalogvale: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {ValeCreditoPeticion.class,
									ValesRenovadosRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ValeCreditoPeticion   valeCreditoPeticion
		                       = (ValeCreditoPeticion) transformador.transformaXMLAObjeto(uid, peticionXML, clases);
		LogHandler.info(uid, getClass(), "insertalogvale: - Datos de entrada: " + valeCreditoPeticion);

		//Llamado a funci�n principal
		final ValesRenovadosRespuesta respuesta = chequesCreditoGrupalTarea.insertalogvaleTarea(uid, valeCreditoPeticion);
		LogHandler.info(uid, getClass(), "insertalogvale: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "insertalogvale: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}


	/**
	 * @param peticionXML :
	 * @return String XML respuesta
	 */
	public String proc_get_universo_primer_pago(String peticionXML) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "proc_get_universo_primer_pago: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {UniversoPrimerPagoPeticion.class,
									ChequesOV.class,
									ProcUniversoPrimerPagoRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final UniversoPrimerPagoPeticion   universoPrimerPagoPeticion
		                       = (UniversoPrimerPagoPeticion) transformador.transformaXMLAObjeto(uid, peticionXML, clases);
		LogHandler.info(uid, getClass(), "proc_get_universo_primer_pago: - Datos de entrada: " + universoPrimerPagoPeticion);

		//Llamado a funci�n principal
		final ProcUniversoPrimerPagoRespuesta respuesta =
				chequesCreditoGrupalTarea.proc_get_universo_primer_pagoTarea(uid, universoPrimerPagoPeticion);
		LogHandler.info(uid, getClass(), "proc_get_universo_primer_pago: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "proc_get_universo_primer_pago: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}
	/**
	 * @param peticionXML :
	 * @return String XML respuesta
	 */
	public String getChequesDesembolsados(String peticionXML) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "getChequesDesembolsados: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {ChequesDesembolsadosPeticion.class,
									ChequesDesembolsadosRespuesta.class,
									ChequesDesembolsados.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ChequesDesembolsadosPeticion   chequesDesembolsadosPeticion
		                       = (ChequesDesembolsadosPeticion) transformador.transformaXMLAObjeto(uid, peticionXML, clases);
		LogHandler.info(uid, getClass(), "getChequesDesembolsados: - Datos de entrada: " + chequesDesembolsadosPeticion);

		//Llamado a funci�n principal
		final ChequesDesembolsadosRespuesta respuesta
				= chequesCreditoGrupalTarea.getChequesDesembolsadosTarea(uid, chequesDesembolsadosPeticion);
		LogHandler.info(uid, getClass(), "getChequesDesembolsados: - Datos de salida: " + respuesta.getHeader().isEstatus());

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		//LogHandler.info(uid, getClass(), "getChequesDesembolsados: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}
}
