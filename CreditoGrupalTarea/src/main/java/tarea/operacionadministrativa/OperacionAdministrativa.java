/**
 * 
 */
package tarea.operacionadministrativa;

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
 * @author out_mreyes
 *
 */
public interface OperacionAdministrativa 
	{
	/**
	 * Funcion para modificar los datos de la sucursal
	 * @param peticion
	 * @return
	 */
	public OperacionAdministrativaRespuesta modificarSucursal( SucursalCambiosPeticion peticion, java.lang.String uid );
	
	/**
	 * Funcion para colocar el candado de desembolso
	 * @param peticion
	 * @return
	 */
	public OperacionAdministrativaRespuesta candadoDesembolsos( CandadoPeticion peticion, String uid );
	
	/**
	 * Funcion para registrar una nueva sucursal
	 * @param peticion
	 * @return
	 */
	public OperacionAdministrativaRespuesta altaSucursal( SucursalPeticion peticion,java.lang.String uid );
	
	/**
	 * Funcion para asignar un nuevo dia festivo
	 * @param peticion
	 * @return
	 */
	public OperacionAdministrativaRespuesta asignarDiaFestivo(DiasPeticion peticion,String uid);
	
	/**
	 * Se realiza el proceso de cierre Finsol
	 * @param fechaCierre
	 * @return
	 */
	public OperacionCierreRespuesta ejecutarCierreFinsol( java.lang.String uid, java.util.Date fechaCierre);
	
	/**
	 * Se realiza el proceso de cierre Finsol de forma sincrona
	 * @param uid
	 * @param peticion
	 * @return
	 */
	public OperacionCierreRespuesta ejecutarCierreFinsolSinc( java.lang.String uid, OperacionCierrePeticion peticion);

	/**
     * Funcion utilizada para monitorear el estado del CIOF ( conexiones y catalogos )
     * @return
     */
    public MonitorCIOFRespuesta monitorearCIOF( java.lang.String uid );

    public OperacionCierreRespuesta ajusteSaldosAFavor(String uid);

    public RegistroInicioOperacionRespuesta registraInicioOperacion(String uid, RegistroInicioOperacionPeticion peticion );

    public ConsultaInicioOperacionRespuesta consultaInicioOperacion(String uid,ConsultaInicioOperacionPeticion peticion );

	/**
	 * Activar Log Completo CIOF
	 * @return resultado operacion
	*/
	public boolean activarLog();

	/**
	 * Desctivar Log Completo CIOF
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
	 * @param uid Identificador unico de la transaccion
	 * @param peticion del cierre
	 * @return Respuesta de la carga
	 */
	public CargaInformacionRespuesta cargarContratosPagosEnLinea(String uid, CargaInformacionPeticion peticion);
}

