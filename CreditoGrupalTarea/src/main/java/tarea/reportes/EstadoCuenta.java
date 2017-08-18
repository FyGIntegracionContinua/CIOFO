package tarea.reportes;

import utilitario.mensajes.reportes.estadocuenta.EstadoCuentaPeticion;
import utilitario.mensajes.reportes.estadocuenta.EstadoCuentaRespuesta;

public interface EstadoCuenta {
	
	/**
	 * 
	 * @param uid
	 * @param cuenta
	 * @return
	 */
	public EstadoCuentaRespuesta obtenerEstadoCuenta(  String uid, EstadoCuentaPeticion cuenta );
	
}
