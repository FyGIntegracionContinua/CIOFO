package tarea.administracion;

import org.apache.ibatis.session.SqlSession;

import utilitario.mensajes.verificacion.telefonica.ConsultaInformacionTelefonicaPeticion;
import utilitario.mensajes.verificacion.telefonica.ConsultaInformacionTelefonicaRespuesta;
import utilitario.mensajes.verificacion.telefonica.ConsultaSolicitudesVerificacionPeticion;
import utilitario.mensajes.verificacion.telefonica.ConsultaSolicitudesVerificacionRespuesta;
import utilitario.mensajes.verificacion.telefonica.RegistraBitacoraPeticion;
import utilitario.mensajes.verificacion.telefonica.RegistraBitacoraRespuesta;
import utilitario.mensajes.verificacion.telefonica.RespuestainformacionVerificacion;
import utilitario.mensajes.verificacion.telefonica.ValidaStatusSolicitudPeticion;
import utilitario.mensajes.verificacion.telefonica.ValidaStatusSolicitudRespuesta;


/**
 * @author mi.mejorada
 * @version 1.0.0
 */
public interface AdministracionTelefonica {


	/**
	 * @param uid :
	 * @param peticion :
	 * @return ConsultaInformacionTelefonicaRespuesta
	 */
	public ConsultaInformacionTelefonicaRespuesta
			consultaInformacionVerificacion(String uid, ConsultaInformacionTelefonicaPeticion peticion);

	/**
	 * Bitacora verificacion telefonica.
	 *
	 * @param uid :
	 * @param peticion :
	 * @param sesion the sesion
	 * @return RegistraBitacoraRespuesta
	 */
	public RegistraBitacoraRespuesta
			bitacoraVerificacionTelefonica(String uid,  RegistraBitacoraPeticion peticion, SqlSession sesion);

	/**
	 * @param uid :
	 * @param peticion :
	 * @return RespuestainformacionVerificacion
	 */
	public RespuestainformacionVerificacion respuestainformacionVerificacion(String uid, String peticion);

	/**
	 * @param uid :
	 * @param peticion :
	 * @return ValidaStatusSolicitudRespuesta
	 */
	public ValidaStatusSolicitudRespuesta
		validaEstadoSolicitud(String uid, ValidaStatusSolicitudPeticion peticion);

	/**
	 * @param uid :
	 * @param peticion :
	 * @return ConsultaSolicitudesVerificacionRespuesta
	 */
	public ConsultaSolicitudesVerificacionRespuesta
		consultaSolicitudVerificaciones(String uid, ConsultaSolicitudesVerificacionPeticion peticion);

}
