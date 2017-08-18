package tarea.reportes;

import utilitario.mensajes.reportes.amortizacion.AmortizacionPeticion;
import utilitario.mensajes.reportes.amortizacion.AmortizacionRespuesta;

public interface Amortizacion {

	/**
	 * TODO
	 * @param uid
	 * @param cuenta
	 * @return
	 */
	public AmortizacionRespuesta obtenerAmortizacionGrupo(	String uid, AmortizacionPeticion cuenta );

	/**
	 * TODO
	 * @param uid
	 * @param cuenta
	 * @return
	 */
	public AmortizacionRespuesta obtenerAmortizacionIndividual( String uid,	AmortizacionPeticion cuenta);
}
