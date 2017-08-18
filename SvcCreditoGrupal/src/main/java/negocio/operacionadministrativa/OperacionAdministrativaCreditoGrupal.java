/**
 *
 */
package negocio.operacionadministrativa;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.oasisopen.sca.annotation.Remotable;

import utilitario.log.LogHandler;
import utilitario.mensajes.operacion.CargaInformacionPeticion;
import utilitario.mensajes.operacion.CargaInformacionRespuesta;
import utilitario.mensajes.operacion.ConsultaInicioOperacionPeticion;
import utilitario.mensajes.operacion.ConsultaInicioOperacionRespuesta;
import utilitario.mensajes.operacion.RegistroInicioOperacionPeticion;
import utilitario.mensajes.operacion.RegistroInicioOperacionRespuesta;
import utilitario.mensajes.operacion.administracion.CandadoPeticion;
import utilitario.mensajes.operacion.administracion.DiasPeticion;
import utilitario.mensajes.operacion.administracion.MonitorCIOFRespuesta;
import utilitario.mensajes.operacion.administracion.OperacionAdministrativaRespuesta;
import utilitario.mensajes.operacion.administracion.SucursalCambiosPeticion;
import utilitario.mensajes.operacion.administracion.SucursalPeticion;
import utilitario.mensajes.operacion.cierre.OperacionCierrePeticion;
import utilitario.mensajes.operacion.cierre.OperacionCierreRespuesta;

/**
 * @version 1.0.0
 * @author out_mreyes
 *
 */
@Remotable
@WebService(name = "OperacionAdministrativaCreditoGrupal",
		    targetNamespace = "http://fisa.com.mx/CIOF/OperacionAdministrativaCreditoGrupal/V1.0")
public interface OperacionAdministrativaCreditoGrupal {
	/**
	 * Metodo que sirve para modificar el nombre de un gerente en la entidad sucursal de credprod, ademas de la direccion
	 * de la sucursal y el nombre de su apoderado
	 * @param peticion :
	 * @return OperacionAdministrativaRespuesta
	 */
	public OperacionAdministrativaRespuesta modificarSucursal(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/OperacionAdministrativaCreditoGrupal/V1.0")
			SucursalCambiosPeticion peticion);

	/**
	 *
	 * @param peticion :
	 * @return OperacionAdministrativaRespuesta
	 */
	public OperacionAdministrativaRespuesta candadoDesembolsos(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/OperacionAdministrativaCreditoGrupal/V1.0")
			CandadoPeticion peticion);
	/**
	 *
	 * @param peticion :
	 * @return OperacionAdministrativaRespuesta
	 */
	public OperacionAdministrativaRespuesta altaSucursal(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/OperacionAdministrativaCreditoGrupal/V1.0")
			SucursalPeticion peticion);

	/**
	 *
	 * @param peticion :
	 * @return OperacionAdministrativaRespuesta
	 */
	public OperacionAdministrativaRespuesta asignarDiaFestivo(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/OperacionAdministrativaCreditoGrupal/V1.0")
			DiasPeticion peticion);

	/**
     * Operacion para validar la fecha de cierre, realizar el cierre y las importacion de pagos
     * @param fechaCierre :
     * @return OperacionCierreRespuesta
     */
    public OperacionCierreRespuesta ejecutarCierreFinsol(
    	@WebParam(name = "fechaCierre", targetNamespace = "http://fisa.com.mx/CIOF/OperacionAdministrativaCreditoGrupal/V1.0")
    	java.util.Date fechaCierre );

    /**
     *
     * @param peticion Sincronizado
     * @return OperacionCierreRespuesta
     */
    public OperacionCierreRespuesta ejecutarCierreFinsolSinc(
        	@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/OperacionAdministrativaCreditoGrupal/V1.0")
        	OperacionCierrePeticion peticion );

    /**
     * Funcion utilizada para monitorear el estado del CIOF
     * @return MonitorCIOFRespuesta
     */
    public MonitorCIOFRespuesta monitorearCIOF();

    /**
     * Funcion utilizada para monitorear el estado del CIOF
     * @return OperacionCierreRespuesta
     */
    public OperacionCierreRespuesta ajusteSaldosAFavor();

    /**
     * @param peticion :
     * @return RegistroInicioOperacionRespuesta
     */
    public RegistroInicioOperacionRespuesta registraInicioOperacion(RegistroInicioOperacionPeticion peticion );

    /**
     * @param peticion :
     * @return ConsultaInicioOperacionRespuesta
     */
    public ConsultaInicioOperacionRespuesta consultaInicioOperacion(ConsultaInicioOperacionPeticion peticion );

    /**
	 * Activar Log Completo CIOF
	 * @return resultado operacion
	 */
    public boolean activarLog();

    /**
	 * Desactivar Log Completo CIOF
	 * @return resultado operacion
	 */
	public boolean desactivarLog();

	/**
	 * Activar Log Completo de consultas a la BD
	 * @return resultado operacion
	 */
    public boolean activarLogSQL();

    /**
	 * Desactivar Log Completo de consultas a la BD
	 * @return resultado operacion
	 */
	public boolean desactivarLogSQL();

	/**
	 * Metodo para cargar la informacion de los contratos en la nube
	 * @param peticion del cierre
	 * @return Respuesta de la carga
	 */
	public CargaInformacionRespuesta cargarContratosPagosEnLinea(CargaInformacionPeticion peticion);
}
