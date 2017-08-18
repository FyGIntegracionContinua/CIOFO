package tarea.reportes;

import java.util.List;

import org.osoa.sca.annotations.Reference;
import org.osoa.sca.annotations.Scope;

import tarea.comun.ComunTarea;
import tarea.comun.ReadProperties;
import utilitario.log.LogHandler;
import utilitario.mensajes.comun.AmortizacionOV;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.reportes.amortizacion.AmortizacionPeticion;
import utilitario.mensajes.reportes.amortizacion.AmortizacionRespuesta;
import utilitario.mensajes.reportes.comun.ObtenerEstadoCuenta;

@Scope("COMPOSITE")
public class AmortizacionImpl implements Amortizacion {
	private ComunTarea comun;


	public AmortizacionImpl(@Reference(name = "comun") ComunTarea comun) {
		this.comun = comun;
	}
	public AmortizacionRespuesta obtenerAmortizacionGrupo(String uid, AmortizacionPeticion cuenta) {
		LogHandler.debug( uid, getClass(), "Entrando a AmortizacionImpl ==> obtenerAmortizacionGrupo, cuentaPeticion = " + cuenta);
		AmortizacionRespuesta respuesta  = new AmortizacionRespuesta();
		respuesta.setRespuesta( new EncabezadoRespuesta() );
		List<AmortizacionOV> pagos = null;
		try {
			//Se realiza la validacion para la relacion de sucursal-contrato
			if(cuenta.getNumeroCuenta() !=null && cuenta.getSucursal() !=null && cuenta.getSucursal() != 0 && cuenta.getSucursal() != 120)
				{
				final java.util.HashMap<String, Object>
								parametros = new java.util.HashMap<String, Object>();
								parametros.put("contrato" , cuenta.getNumeroCuenta() );
								parametros.put( "sucursal", cuenta.getSucursal() 	 );

				if ( !comun.comprobarContratoSucursal( uid, parametros ) )
					{
					throw new Exception( ReadProperties.mensajes.getProp( "reportes.obtenerestadocuenta.errorcontratosucursal" ) );
					}
				}
			pagos = amortizacionGrupo(uid, cuenta.getNumeroCuenta());
			if(pagos != null && !pagos.isEmpty())
				respuesta.setTablaAmortizacion(pagos.toArray(new AmortizacionOV[pagos.size()]));
		} catch(Exception e ) {
			LogHandler.error(uid, getClass(), "Existio un error dentro de obtenerAmortizacionGrupo :" + e.getMessage(), e);

			respuesta.getRespuesta().setUID(uid);
			respuesta.getRespuesta().setMensaje( e.getMessage() );
			respuesta.getRespuesta().setEstatus( false );
		}
		return respuesta;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	List<AmortizacionOV> amortizacionGrupo(String uid, String cuenta) {
		LogHandler.debug( uid, getClass(),"Entrando a AmortizacionImpl ==> amortizacionGrupo, cuenta = " + cuenta);
		List pagos = null;
		try {
			pagos = comun.storeEstadoCuenta(uid, cuenta, ObtenerEstadoCuenta.AMORTIZACION_GRUPAL);
		} catch(Exception e ) {
			LogHandler.error(uid, getClass(), "Existio un error dentro de amortizacionGrupo", e);
		}
		return (pagos != null	&& !pagos.isEmpty() && pagos.get(0) instanceof AmortizacionOV) ? pagos : null;
	}

	@SuppressWarnings("unchecked")
	public AmortizacionRespuesta obtenerAmortizacionIndividual(String uid, AmortizacionPeticion cuenta) {
		AmortizacionRespuesta respuesta  = new AmortizacionRespuesta();
		respuesta.setRespuesta( new EncabezadoRespuesta() );
		List<AmortizacionOV> pagos = null;
		try {
			//Se realiza la validacion para la relacion de sucursal-contrato
			if(cuenta.getNumeroCuenta() !=null && cuenta.getSucursal() !=null && cuenta.getSucursal() != 0 && cuenta.getSucursal() != 120)
				{
				final java.util.HashMap<String, Object>
								parametros = new java.util.HashMap<String, Object>();
								parametros.put("contrato" , cuenta.getNumeroCuenta() );
								parametros.put( "sucursal", cuenta.getSucursal() 	 );

				if ( !comun.comprobarContratoSucursal( uid, parametros ) )
					{
					throw new Exception( ReadProperties.mensajes.getProp( "reportes.obtenerestadocuenta.errorcontratosucursal" ) );
					}
				}
			pagos = (List<AmortizacionOV>)comun.storeEstadoCuenta(uid,
				cuenta.getNumeroCuenta(), ObtenerEstadoCuenta.AMORTIZACION_INDIVIDUAL);
			if(pagos != null && !pagos.isEmpty() && pagos.get(0) instanceof AmortizacionOV)
				respuesta.setTablaAmortizacion(pagos.toArray(new AmortizacionOV[pagos.size()]));
		} catch(Exception e ) {
			LogHandler.error(uid, getClass(), "Existio un error dentro de obtenerAmortizacionIndividual : " + e.getMessage(), e);

			respuesta.getRespuesta().setUID( uid );
			respuesta.getRespuesta().setMensaje( e.getMessage() );
			respuesta.getRespuesta().setEstatus( false );
		}
		return respuesta;
	}
}
