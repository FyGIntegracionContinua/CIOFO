
package negocio.burocredito;

import org.osoa.sca.annotations.Reference;
import org.osoa.sca.annotations.Service;

import tarea.burocredito.BuroCreditoTarea;
import transformador.Transformador;
import utilitario.comun.GUIDGenerator;
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
import utilitario.mensajes.burocredito.ValidaSolicitudPeticion;
import utilitario.mensajes.burocredito.ValidaSolicitudRespuesta;
import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.solicitudes.ConsultaSolicitudBuroRespuesta;
import utilitario.mensajes.solicitudes.SolicitudBuroClienteOV;
import utilitario.reglas.solicitudes.RespuestaReglaIncremento;

/**
 * @author out_ltorres
 *
 */
@Service(value = BuroCredito.class)
public class BuroCreditoImpl implements BuroCredito {

	/**
	 * Transformador SCA
	 */
	private Transformador transformador;
	/**
	 * BuroCreditoTarea SCA
	 */
	private BuroCreditoTarea buroCreditoTarea;

	/**
	 * @param transformador :
	 * @param buroCreditoTarea Constructor
	 */
	public BuroCreditoImpl(	@Reference(name = "transformador") Transformador transformador,
							@Reference(name = "buroCreditoTarea") BuroCreditoTarea buroCreditoTarea
									) {
		this.transformador = transformador;
		this.buroCreditoTarea = buroCreditoTarea;
	}

	/**
	 * @param peticionXML :
	 * @return String
	 */
	public String getInformacionCliente(String peticionXML) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "getInformacionCliente: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {BuroCreditoClientePeticion.class,
									BuroCreditoClienteRespuesta.class,
									BuroCreditoCliente.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final BuroCreditoClientePeticion   buroCreditoClientePeticion
		                       = (BuroCreditoClientePeticion) transformador.transformaXMLAObjeto(uid, peticionXML, clases);
		LogHandler.info(uid, getClass(), "getInformacionCliente: - Datos de entrada: " + buroCreditoClientePeticion);

		//Llamado a funcion principal
		final BuroCreditoClienteRespuesta respuesta
				= buroCreditoTarea.getInformacionClienteTarea(uid, buroCreditoClientePeticion);
		LogHandler.info(uid, getClass(), "getInformacionCliente: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "getInformacionCliente: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticionXML :
	 * @return String
	 */
	public String prGetInformacionCliente(String peticionXML) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "prGetInformacionCliente: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {BuroCreditoClientePeticion.class,
									BuroCreditoClienteRespuesta.class,
									BuroCreditoCliente.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final BuroCreditoClientePeticion   buroCreditoClientePeticion
		                       = (BuroCreditoClientePeticion) transformador.transformaXMLAObjeto(uid, peticionXML, clases);
		LogHandler.info(uid, getClass(), "prGetInformacionCliente: - Datos de entrada: " + buroCreditoClientePeticion);

		//Llamado a funcion principal
		final BuroCreditoClienteRespuesta respuesta
					= buroCreditoTarea.prGetInformacionClienteTarea(uid, buroCreditoClientePeticion);
		LogHandler.info(uid, getClass(), "prGetInformacionCliente: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "prGetInformacionCliente: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticionXML :
	 * @return String
	 */
	public String prGetFecha(String peticionXML) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "prGetFecha: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {BuroCreditoClientePeticion.class,
									BuroCreditoFechaRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final BuroCreditoClientePeticion   buroCreditoClientePeticion
		                       = (BuroCreditoClientePeticion) transformador.transformaXMLAObjeto(uid, peticionXML, clases);
		LogHandler.info(uid, getClass(), "prGetFecha: - Datos de entrada: " + buroCreditoClientePeticion);

		//Llamado a funcion principal
		final BuroCreditoFechaRespuesta respuesta = buroCreditoTarea.prGetFechaTarea(uid, buroCreditoClientePeticion);
		LogHandler.info(uid, getClass(), "prGetFecha: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "prGetFecha: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticionXML :
	 * @return String
	 */
	public String prGetHistoriaC(String peticionXML) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "prGetHistoriaC: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {BuroCreditoClienteGrupoPeticion.class,
									BuroCreditoClienteGrupoRespuesta.class,
									BuroCreditoClienteGrupo.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final BuroCreditoClienteGrupoPeticion   buroCreditoClienteGrupoPeticion
		                       = (BuroCreditoClienteGrupoPeticion) transformador.transformaXMLAObjeto(uid, peticionXML, clases);
		LogHandler.info(uid, getClass(), "prGetHistoriaC: - Datos de entrada: " + buroCreditoClienteGrupoPeticion);

		//Llamado a funcion principal
		final BuroCreditoClienteGrupoRespuesta respuesta
				= buroCreditoTarea.prGetHistoriaCTarea(uid, buroCreditoClienteGrupoPeticion);
		LogHandler.info(uid, getClass(), "prGetHistoriaC: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "prGetHistoriaC: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticionXML :
	 * @return String
	 */
	public String prGetDetalleGrupo(String peticionXML) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "prGetDetalleGrupo: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {BuroCreditoClienteDetalleGrupoPeticion.class,
									BuroCreditoClienteDetalleGrupoRespuesta.class,
									BuroCreditoClienteDetalleGrupo.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final BuroCreditoClienteDetalleGrupoPeticion   buroCreditoClienteDetalleGrupoPeticion
		               = (BuroCreditoClienteDetalleGrupoPeticion) transformador.transformaXMLAObjeto(uid, peticionXML, clases);
		LogHandler.info(uid, getClass(), "prGetDetalleGrupo: - Datos de entrada: " + buroCreditoClienteDetalleGrupoPeticion);

		//Llamado a funcion principal
		final BuroCreditoClienteDetalleGrupoRespuesta respuesta
				= buroCreditoTarea.prGetDetalleGrupoTarea(uid, buroCreditoClienteDetalleGrupoPeticion);
		LogHandler.info(uid, getClass(), "prGetDetalleGrupo: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "prGetDetalleGrupo: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticionXML :
	 * @return String
	 */
	public String FindCredComunal(String peticionXML) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "FindCredComunal: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {BuroCreditoComunalPeticion.class,
									BuroCreditoComunalRespuesta.class,
									BuroCreditoComunal.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final BuroCreditoComunalPeticion   buroCreditoComunalPeticion
		                       = (BuroCreditoComunalPeticion) transformador.transformaXMLAObjeto(uid, peticionXML, clases);
		LogHandler.info(uid, getClass(), "FindCredComunal: - Datos de entrada: " + buroCreditoComunalPeticion);

		//Llamado a funcion principal
		final BuroCreditoComunalRespuesta respuesta = buroCreditoTarea.findCredComunalTarea(uid, buroCreditoComunalPeticion);
		LogHandler.info(uid, getClass(), "FindCredComunal: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "FindCredComunal: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticionXML :
	 * @return String
	 */
	public String prGetDetalleHistoriaC(String peticionXML) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "prGetDetalleHistoriaC: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {BuroCreditoClienteGrupoPeticion.class,
									BuroCreditoClienteGrupoRespuesta.class,
									BuroCreditoClienteGrupo.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final BuroCreditoClienteGrupoPeticion   buroCreditoClienteGrupoPeticion
		                       = (BuroCreditoClienteGrupoPeticion) transformador.transformaXMLAObjeto(uid, peticionXML, clases);
		LogHandler.info(uid, getClass(), "prGetDetalleHistoriaC: - Datos de entrada: " + buroCreditoClienteGrupoPeticion);

		//Llamado a funcion principal
		final BuroCreditoClienteGrupoRespuesta respuesta
				= buroCreditoTarea.prGetDetalleHistoriaCTarea(uid, buroCreditoClienteGrupoPeticion);

		LogHandler.info(uid, getClass(), "prGetDetalleHistoriaC: - Datos de salida GetDetalleHistoriaCTarea: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		return respuestaXML;
	}

	/**
	 * @param peticionXML :
	 * @return String
	 */
	public String prGetCountMora(String peticionXML) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "prGetCountMora: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {BuroCreditoContratoPeticion.class,
									BuroCreditoContratoRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final BuroCreditoContratoPeticion   buroCreditoContratoPeticion
		                       = (BuroCreditoContratoPeticion) transformador.transformaXMLAObjeto(uid, peticionXML, clases);
		LogHandler.info(uid, getClass(), "prGetCountMora: - Datos de entrada: " + buroCreditoContratoPeticion);

		//Llamado a funcion principal
		final BuroCreditoContratoRespuesta respuesta = buroCreditoTarea.prGetCountMoraTarea(uid, buroCreditoContratoPeticion);
		LogHandler.info(uid, getClass(), "prGetCountMora: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "prGetCountMora: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticionXML :
	 * @return String
	 */
	public String getRFCCliente(String peticionXML) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "getRFCCliente: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {BuroCreditoRFCPeticion.class,
									BuroCreditoRFCRespuesta.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final BuroCreditoRFCPeticion   buroCreditoRFCPeticion
		                       = (BuroCreditoRFCPeticion) transformador.transformaXMLAObjeto(uid, peticionXML, clases);
		LogHandler.info(uid, getClass(), "getRFCCliente: - Datos de entrada: " + buroCreditoRFCPeticion);

		//Llamado a funcion principal
		final BuroCreditoRFCRespuesta respuesta = buroCreditoTarea.getRFCClienteTarea(uid, buroCreditoRFCPeticion);
		LogHandler.info(uid, getClass(), "getRFCCliente: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "getRFCCliente: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticionXML :
	 * @return String
	 */
	public String getClientbyRFC(String peticionXML) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "getClientbyRFC: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {BuroCreditoRFCPeticion.class,
									BuroCreditoRFCRespuesta.class,
									BuroCreditoRFC.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final BuroCreditoRFCPeticion   buroCreditoRFCPeticion
		                       = (BuroCreditoRFCPeticion) transformador.transformaXMLAObjeto(uid, peticionXML, clases);
		LogHandler.info(uid, getClass(), "getClientbyRFC: - Datos de entrada: " + buroCreditoRFCPeticion);

		//Llamado a funcion principal
		final BuroCreditoRFCRespuesta respuesta = buroCreditoTarea.getClientbyRFCTarea(uid, buroCreditoRFCPeticion);
		LogHandler.info(uid, getClass(), "getClientbyRFC: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "getClientbyRFC: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticionXML :
	 * @return String
	 */
	public String getClientBCE(String peticionXML) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "getClientBCE: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {BuroCreditoRFCPeticion.class,
									BuroCreditoRFCRespuesta.class,
									BuroCreditoBCE.class,
									EncabezadoPeticion.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final BuroCreditoRFCPeticion   buroCreditoRFCPeticion
		                       = (BuroCreditoRFCPeticion) transformador.transformaXMLAObjeto(uid, peticionXML, clases);
		LogHandler.info(uid, getClass(), "getClientBCE: - Datos de entrada: " + buroCreditoRFCPeticion);

		//Llamado a funcion principal
		final BuroCreditoRFCRespuesta respuesta = buroCreditoTarea.getClientBCETarea(uid, buroCreditoRFCPeticion);
		LogHandler.info(uid, getClass(), "getClientBCE: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "getClientBCE: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}


	/**
	 * @param peticion :
	 * @return String
	 */
	public ConsultaBuroRespuesta consultaBuroCredito(ConsultaBuroPeticion peticion) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );

		//Llamado a funcion principal
		final ConsultaBuroRespuesta respuesta = buroCreditoTarea.consultaBuroCredito(uid, peticion);

		return respuesta;
	}

	/**
	 * @param peticion :
	 * @return String
	 */
	public ConsultaBuroRespuesta validaConsultaVigente(ConsultaBuroPeticion peticion) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		//Parametros de entrada
		LogHandler.info(uid, getClass(), "validaConsultaVigente: - Datos de entrada: " + peticion);

		//Llamado a funcion principal
		final ConsultaBuroRespuesta respuesta = buroCreditoTarea.validaConsultaVigente(uid, peticion);
		LogHandler.info(uid, getClass(), "validaConsultaVigente: - Datos de salida: " + respuesta);

		return respuesta;
	}

	/**
	 * @param peticion :
	 * @return String
	 */
	public ConsultaBuroRespuesta obtenerUltimaConsulta(ConsultaBuroPeticion peticion) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		//Parametros de entrada
		LogHandler.info(uid, getClass(), "obtenerConsultaMasNomina: - Datos de entrada: " + peticion);
		//Llamado a funcion principal
		final ConsultaBuroRespuesta respuesta = buroCreditoTarea.obtenerUltimaConsulta(uid, peticion);
		return respuesta;
	}

	/**
	 * @param peticion :
	 * @return String
	 */
	public ConsultaBuroRespuesta obtenerConsultaPorFolio(ConsultaBuroPeticion peticion) {

		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		//Parametros de entrada
		LogHandler.info(uid, getClass(), "obtenerConsultaPorFolio: - Datos de entrada: " + peticion);

		//Llamado a funcion principal
		final ConsultaBuroRespuesta respuesta = buroCreditoTarea.obtenerConsultaPorFolio(uid, peticion);
		LogHandler.info(uid, getClass(), "obtenerConsultaPorFolio: - Datos de salida: " + respuesta);

		return respuesta;
	}

	/**
	 * @param peticionXML de consulta
	 * @return ConsultaBuroRespuesta
	 */
	public String validacionSolicitudBuro(String peticionXML) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "validacionSolicitudBuro: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {ValidaSolicitudPeticion.class,
									ValidaSolicitudRespuesta.class,
									RespuestaReglaIncremento.class,
									IntegranteSolicitud.class};

		//Conversion de XML a Object
		final ValidaSolicitudPeticion   peticion
		                       = (ValidaSolicitudPeticion) transformador.transformaXMLAObjeto(uid, peticionXML, clases);

		//Parametros de entrada
		LogHandler.info(uid, getClass(), "validacionSolicitudBuro: - Datos de entrada: " + peticion);

		//Llamado a funcion principal
		final ValidaSolicitudRespuesta respuesta = buroCreditoTarea.validacionSolicitudBuro(uid, peticion);
		LogHandler.info(uid, getClass(), "validacionSolicitudBuro: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "validacionSolicitudBuro: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticionXML de consulta
	 * @return ConsultaBuroRespuesta
	 */
	public String validacionIDSolicitudBuro(String peticionXML) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "validacionIDSolicitudBuro: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {ValidaSolicitudPeticion.class,
									ValidaSolicitudRespuesta.class,
									SolicitudBuroClienteOV.class,
									ConsultaSolicitudBuroRespuesta.class,
									IntegranteSolicitud.class};

		//Conversion de XML a Object
		final ValidaSolicitudPeticion   peticion
		                       = (ValidaSolicitudPeticion) transformador.transformaXMLAObjeto(uid, peticionXML, clases);

		//Parametros de entrada
		LogHandler.info(uid, getClass(), "validacionIDSolicitudBuro: - Datos de entrada: " + peticion);

		//Llamado a funcion principal
		final ConsultaSolicitudBuroRespuesta respuesta = buroCreditoTarea.validacionIDSolicitudBuro(uid, peticion);
		LogHandler.info(uid, getClass(), "validacionIDSolicitudBuro: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "validacionIDSolicitudBuro: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticionXML de consulta
	 * @return ConsultaBuroRespuesta
	 */
	public String validacionIDSolicitudBuroAnalistaDocumentalBC(String peticionXML) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "validacionIDSolicitudBuro: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {ValidaSolicitudPeticion.class,
									ValidaSolicitudRespuesta.class,
									SolicitudBuroClienteOV.class,
									ConsultaSolicitudBuroRespuesta.class,
									IntegranteSolicitud.class};

		//Conversion de XML a Object
		final ValidaSolicitudPeticion   peticion
		                       = (ValidaSolicitudPeticion) transformador.transformaXMLAObjeto(uid, peticionXML, clases);

		//Parametros de entrada
		LogHandler.info(uid, getClass(), "validacionIDSolicitudBuro: - Datos de entrada: " + peticion);

		//Llamado a funcion principal
		final ConsultaSolicitudBuroRespuesta respuesta
			= buroCreditoTarea.validacionIDSolicitudBuroAnalistaDocumentalBC(uid, peticion);
		LogHandler.info(uid, getClass(), "validacionIDSolicitudBuroAnalistaDocumentalBC: - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "validacionIDSolicitudBuroAnalistaDocumentalBC: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

	/**
	 * @param peticionXML de consulta
	 * @return ConsultaBuroRespuesta
	 */
	public ConsultaSolicitudBuroRespuesta validacionIDSolicitudBuroAnalistaDocumentalBCObjeto(String peticionXML) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "validacionIDSolicitudBuro: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {ValidaSolicitudPeticion.class,
									ValidaSolicitudRespuesta.class,
									SolicitudBuroClienteOV.class,
									ConsultaSolicitudBuroRespuesta.class,
									IntegranteSolicitud.class};

		//Conversion de XML a Object
		final ValidaSolicitudPeticion   peticion
		                       = (ValidaSolicitudPeticion) transformador.transformaXMLAObjeto(uid, peticionXML, clases);

		//Parametros de entrada
		LogHandler.info(uid, getClass(), "validacionIDSolicitudBuro: - Datos de entrada: " + peticion);

		//Llamado a funcion principal
		final ConsultaSolicitudBuroRespuesta respuesta
			= buroCreditoTarea.validacionIDSolicitudBuroAnalistaDocumentalBC(uid, peticion);
		LogHandler.info(uid, getClass(), "validacionIDSolicitudBuroAnalistaDocumentalBC: - Datos de salida: " + respuesta);
		return respuesta;
	}

	/**
	 * metodo que se encarga de la validacion de buro para parte de originacion de credito.
	 * @param peticionXML de consulta
	 * @return ConsultaBuroRespuesta
	 */
	public String validacionSolicitudBuroOriginacion(String peticionXML) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticionXML );
		LogHandler.info(uid, getClass(), "validacionSolicitudBurOriginacion: - peticionXML: " + peticionXML);

		//Parametros de entrada
		final Class<?>[] clases = {ValidaSolicitudPeticion.class,
									ValidaSolicitudRespuesta.class,
									RespuestaReglaIncremento.class,
									IntegranteSolicitud.class};

		//Conversion de XML a Object
		final ValidaSolicitudPeticion   peticion
		                       = (ValidaSolicitudPeticion) transformador.transformaXMLAObjeto(uid, peticionXML, clases);

		//Parametros de entrada
		LogHandler.info(uid, getClass(), "validacionSolicitudBurOriginacion: - Datos de entrada: " + peticion);

		//Llamado a funcion principal
		final ValidaSolicitudRespuesta respuesta = buroCreditoTarea.validacionSolicitudBuroOriginacion(uid, peticion);
		LogHandler.info(uid, getClass(), "validacionSolicitudBurOriginacion: - Datos de salida: " + respuesta);

		//Se genera la salida
		 String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		if (respuestaXML != null) {
			respuestaXML = respuestaXML.replace("utilitario.mensajes.solicitudes.SolicitudBuroClienteOV",
					"SolicitudBuroClienteOV");
		}
		LogHandler.info(uid, getClass(), "validacionSolicitudBurOriginacion: - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}
}
