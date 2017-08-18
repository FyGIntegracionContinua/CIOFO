package negocio.administracion;

import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * @version 1.0.0
 * @author mi.mejorada
 *
 */
@WebService(name = "AdministracionTelefonicaCreditoGrupal",
			targetNamespace = "http://fisa.com.mx/CIOF/AdministracionTelefonicaCreditoGrupal/V1.0")
public interface AdministracionTelefonicaCreditoGrupal {


	/**
	 * consultaInformacionVerificacion :
	 * @param peticion :
	 * @return String
	 */
	public String consultaInformacionVerificacion(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionTelefonicaCreditoGrupal/V1.0")
			String peticion);

	/**
	 * bitacoraVerificacionTelefonica :
	 * @param peticion :
	 * @return String
	 */
	public String bitacoraVerificacionTelefonica(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionTelefonicaCreditoGrupal/V1.0")
			String peticion);

	/**
	 * respuestaInformacionVerificacion :
	 * @param peticion :
	 * @return String
	 */
	public String respuestaInformacionVerificacion(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionTelefonicaCreditoGrupal/V1.0")
			String peticion);

	/**
	 * consultaEstadoVerificacion :
	 * @param peticion :
	 * @return String
	 */
	public String consultaEstadoVerificacion(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionTelefonicaCreditoGrupal/V1.0")
			String peticion);
	/**
	 * consultaSolicitudesVerificacion :
	 * @param peticion :
	 * @return String
	 */
	public String consultaSolicitudesVerificacion(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/AdministracionTelefonicaCreditoGrupal/V1.0")
			String peticion);

}
