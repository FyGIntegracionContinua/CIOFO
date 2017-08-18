
package negocio.burocredito;

import javax.jws.WebService;

import org.oasisopen.sca.annotation.Remotable;

import utilitario.mensajes.burocredito.ConsultaBuroPeticion;
import utilitario.mensajes.burocredito.ConsultaBuroRespuesta;
import utilitario.mensajes.solicitudes.ConsultaSolicitudBuroRespuesta;

/**
 * @author out_ltorres
 * @version 1.0.0
 */
@Remotable
@WebService(name = "BuroCredito", targetNamespace = "http://fisa.com.mx/CIOF/BuroCredito/V1.0")
public interface BuroCredito {

	/**
	 * @param peticionXML :
	 * @return String
	 */
	String getInformacionCliente(String peticionXML);
	/**
	 * @param peticionXML :
	 * @return String
	 */
	String prGetDetalleGrupo(String peticionXML);
	/**
	 * @param peticionXML :
	 * @return String
	 */
	String prGetInformacionCliente(String peticionXML);
	/**
	 * @param peticionXML :
	 * @return String
	 */
	String prGetFecha(String peticionXML);
	/**
	 * @param peticionXML :
	 * @return String
	 */
	String prGetHistoriaC(String peticionXML);
	/**
	 * @param peticionXML :
	 * @return String
	 */
	String FindCredComunal(String peticionXML);
	/**
	 * @param peticionXML :
	 * @return String
	 */
	String prGetDetalleHistoriaC(String peticionXML);
	/**
	 * @param peticionXML :
	 * @return String
	 */
	String prGetCountMora(String peticionXML);
	/**
	 * @param peticionXML :
	 * @return String
	 */
	String getRFCCliente(String peticionXML);
	/**
	 * @param peticionXML :
	 * @return String
	 */
	String getClientbyRFC(String peticionXML);
	/**
	 * @param peticionXML :
	 * @return String
	 */
	String getClientBCE(String peticionXML);

	/**
	 * @param peticion :
	 * @return String
	 */
	ConsultaBuroRespuesta consultaBuroCredito(ConsultaBuroPeticion peticion);

	/**
	 * @param peticion :
	 * @return String
	 */
	ConsultaBuroRespuesta validaConsultaVigente(ConsultaBuroPeticion peticion);

	/**
	 * @param peticion :
	 * @return String
	 */
	ConsultaBuroRespuesta obtenerUltimaConsulta(ConsultaBuroPeticion peticion);

	/**
	 * @param peticion :
	 * @return String
	 */
	ConsultaBuroRespuesta obtenerConsultaPorFolio(ConsultaBuroPeticion peticion);

	/**
	 * @param peticionXML de consulta
	 * @return ConsultaBuroRespuesta
	 */
	String validacionSolicitudBuro(String peticionXML);

	/**
	 * @param peticionXML de consulta
	 * @return ConsultaBuroRespuesta
	 */
	String validacionIDSolicitudBuro(String peticionXML);

	/**
	 * @param peticionXML de consulta
	 * @return ConsultaBuroRespuesta
	 */
	String validacionIDSolicitudBuroAnalistaDocumentalBC(String peticionXML);

	/**
	 * @param peticionXML de consulta
	 * @return ConsultaBuroRespuesta
	 */
	ConsultaSolicitudBuroRespuesta validacionIDSolicitudBuroAnalistaDocumentalBCObjeto(String peticionXML);

	/**
	 * metodo que se encarga de la validacion de buro para parte de originacion de credito.
	 * @param peticionXML de consulta
	 * @return ConsultaBuroRespuesta
	 */
	public String validacionSolicitudBuroOriginacion(String peticionXML);
}
