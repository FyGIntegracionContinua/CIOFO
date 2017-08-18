	/**
 *
 */
package negocio.operacionadministrativa;

import java.util.Date;

import org.oasisopen.sca.annotation.Reference;

import tarea.operacion.PagosCredito;
import tarea.operacionadministrativa.OperacionAdministrativa;
import utilitario.comun.GUIDGenerator;
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
public 	class 		OperacionAdministrativaCreditoGrupalImpl
		implements	OperacionAdministrativaCreditoGrupal {

	//Atributos privados  ----------------------------------------------------------------------------

	/**
	 * SAC Component Fabric
	 */
	PagosCredito		 	pagos;
	/**
	 * SAC Component Fabric
	 */
	OperacionAdministrativa operacionAdministrativa;

	/**
	 * @param pagos :
	 * @param operacionAdministrativa :
	 * SAC Component Fabric Inyeccion
	 */
	public OperacionAdministrativaCreditoGrupalImpl(
						@Reference(name = "pagos") PagosCredito pagos,
						@Reference(name = "operacionAdministrativa") OperacionAdministrativa operacionAdministrativa)
		{
		this.pagos = pagos;
		this.operacionAdministrativa = operacionAdministrativa;
		}

	/**
	 * @param peticion de solicitud
	 * @return respuesta
	 */
	public OperacionAdministrativaRespuesta modificarSucursal(SucursalCambiosPeticion peticion)
		{
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "modificarSucursal - Datos de entrada : " + peticion);

		//Salida
		final OperacionAdministrativaRespuesta operacionAdministrativaRespuesta
							= operacionAdministrativa.modificarSucursal(peticion, uid );
		LogHandler.info(uid, getClass(), "modificarSucursal - Datos de salida : " + operacionAdministrativaRespuesta);
		return operacionAdministrativaRespuesta;
		}

	/**
	 * @param peticion de solicitud
	 * @return respuesta
	 */
	public OperacionAdministrativaRespuesta candadoDesembolsos(CandadoPeticion peticion)
		{
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "candadoDesembolsos - Datos de entrada : " + peticion);

		//Salida
		final OperacionAdministrativaRespuesta operacionAdministrativaRespuesta
							= operacionAdministrativa.candadoDesembolsos(peticion, uid);
		LogHandler.info(uid, getClass(), "candadoDesembolsos - Datos de salida : " + operacionAdministrativaRespuesta);
		return operacionAdministrativaRespuesta;
		}

	/**
	 * @param peticion :
	 * @return OperacionAdministrativaRespuesta
	 */
	public OperacionAdministrativaRespuesta altaSucursal(SucursalPeticion peticion)
		{
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "altaSucursal - Datos de entrada : " + peticion);

		//Salida
		final OperacionAdministrativaRespuesta operacionAdministrativaRespuesta
													= operacionAdministrativa.altaSucursal(peticion, uid);
		LogHandler.info(uid, getClass(), "altaSucursal - Datos de salida : " + operacionAdministrativaRespuesta);
		return operacionAdministrativaRespuesta;
		}

	/**
	 * @param peticion peticion de solicitud
	 * @return respuesta
	 */
	public OperacionAdministrativaRespuesta asignarDiaFestivo(DiasPeticion peticion)
		{
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "asignarDiaFestivo - Datos de entrada : " + peticion);

		//Se recibe la salida
		final OperacionAdministrativaRespuesta operacionAdministrativaRespuesta
							= operacionAdministrativa.asignarDiaFestivo(peticion, uid);
		LogHandler.info(uid, getClass(), "asignarDiaFestivo - Datos de salida : " + operacionAdministrativaRespuesta);
		return operacionAdministrativaRespuesta;
		}

	/**
	 * @param fechaCierre peticion de solicitud
	 * @return respuesta
	 */
	public OperacionCierreRespuesta ejecutarCierreFinsol(Date fechaCierre) {
		final java.lang.String uid = GUIDGenerator.generateGUID(fechaCierre );
		LogHandler.info(uid, getClass(), "ejecutarCierreFinsol - Datos de entrada : fechaCierre = " + fechaCierre);

		//Se genera la salida
		final OperacionCierreRespuesta operacionCierreRespuesta = operacionAdministrativa.ejecutarCierreFinsol(uid, fechaCierre );
		LogHandler.info(uid, getClass(), "ejecutarCierreFinsol - Datos de entrada : salida = " + operacionCierreRespuesta);
		return operacionCierreRespuesta;
		}


	/**
	 * @param peticion de solicitud
	 * @return respuesta
	 */
	public OperacionCierreRespuesta ejecutarCierreFinsolSinc( OperacionCierrePeticion peticion) {
		final java.lang.String uid = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "ejecutarCierreFinsolSinc - Datos de entrada : peticion = " + peticion);

		//Se genera la salida
		final OperacionCierreRespuesta operacionCierreRespuesta
								= operacionAdministrativa.ejecutarCierreFinsolSinc(uid, peticion );
		LogHandler.info(uid, getClass(), "ejecutarCierreFinsolSinc - Datos de salida : " + operacionCierreRespuesta);
		return operacionCierreRespuesta;
		}

	/**
	 * @return respuesta
	 */
	public MonitorCIOFRespuesta monitorearCIOF() {
		final java.lang.String uid = GUIDGenerator.generateGUID(new Object() );
		LogHandler.info(uid, getClass(), "monitorearCIOF - Entrada : OK" );

		//Se genera la salida
		final MonitorCIOFRespuesta monitorCIOFRespuesta = operacionAdministrativa.monitorearCIOF(uid );
		LogHandler.info(uid, getClass(), "monitorearCIOF - Salida : " + monitorCIOFRespuesta);
		return monitorCIOFRespuesta;
		}

	/**
	 * @return OperacionCierreRespuesta
	 */
	public OperacionCierreRespuesta ajusteSaldosAFavor() {
		String cadena = "ajusteSaldosAFavor";
		final java.lang.String uid = GUIDGenerator.generateGUID(cadena );
		LogHandler.info(uid, getClass(), "ajusteSaldosAFavor - Datos de entrada :");

		//Se genera la salida
		final OperacionCierreRespuesta operacionCierreRespuesta = operacionAdministrativa.ajusteSaldosAFavor(uid);
		LogHandler.info(uid, getClass(), "ajusteSaldosAFavor - Datos de salida : " + operacionCierreRespuesta);
		return operacionCierreRespuesta;
	}

	/**
	 * @param peticion :
	 * @return RegistroInicioOperacionRespuesta
	 */
	public RegistroInicioOperacionRespuesta registraInicioOperacion(RegistroInicioOperacionPeticion peticion ) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "registraInicioOperacion - Datos de entrada : " + peticion);

		final RegistroInicioOperacionRespuesta respuesta = operacionAdministrativa.registraInicioOperacion(uid, peticion);
		LogHandler.info(uid, getClass(), "registraInicioOperacion - Datos de salida : " + respuesta);
		return respuesta;

	}

	/**
	 * @param peticion :
	 * @return ConsultaInicioOperacionRespuesta
	 */
	public ConsultaInicioOperacionRespuesta consultaInicioOperacion(ConsultaInicioOperacionPeticion peticion ) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "consultaInicioOperacion - Datos de entrada : " + peticion);

		final ConsultaInicioOperacionRespuesta respuesta = operacionAdministrativa.consultaInicioOperacion(uid, peticion);
		LogHandler.info(uid, getClass(), "consultaInicioOperacion - Datos de salida : " + respuesta);
		return respuesta;

	}

    /**
	 * Activar Log Completo CIOF
	 * @return resultado operacion
	 */
    public boolean activarLog() {
    	return operacionAdministrativa.activarLog();
    }

    /**
	 * Desactivar Log Completo CIOF
	 * @return resultado operacion
	 */
	public boolean desactivarLog() {
		return operacionAdministrativa.desactivarLog();
	}

	/**
	 * Activar Log Completo de consultas a la BD
	 * @return resultado operacion
	 */
    public boolean activarLogSQL() {
    	return operacionAdministrativa.activarLogSQL();
    }

    /**
	 * Desactivar Log Completo de consultas a la BD
	 * @return resultado operacion
	 */
	public boolean desactivarLogSQL() {
		return operacionAdministrativa.desactivarLogSQL();
	}

	/**
	 * Metodo para cargar la informacion de los contratos en la nube
	 * @param peticion del cierre
	 * @return Respuesta de la carga
	 */
	public CargaInformacionRespuesta cargarContratosPagosEnLinea(CargaInformacionPeticion peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion );
		LogHandler.info(uid, getClass(), "cargarContratosPagosEnLinea - Datos de entrada : " + peticion);

		final CargaInformacionRespuesta respuesta = operacionAdministrativa.cargarContratosPagosEnLinea(uid, peticion);
		LogHandler.info(uid, getClass(), "cargarContratosPagosEnLinea - Datos de salida : " + respuesta);
		return respuesta;
	}
}
