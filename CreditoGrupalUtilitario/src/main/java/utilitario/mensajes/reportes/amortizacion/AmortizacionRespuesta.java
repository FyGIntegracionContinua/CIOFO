package utilitario.mensajes.reportes.amortizacion;

import utilitario.mensajes.comun.AmortizacionOV;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AmortizacionRespuesta.
 */
public class AmortizacionRespuesta  extends ObjetoValor {

	/**
	 * Instancia una nueva amortizacion respuesta.
	 */
	public AmortizacionRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3804398603392462816L;

	/** The tabla amortizacion. */
	private AmortizacionOV[] tablaAmortizacion;

	/** The respuesta. */
	private EncabezadoRespuesta respuesta;

	/**
	 * Obtiene tabla amortizacion.
	 *
	 * @return tabla amortizacion
	 */
	public AmortizacionOV[] getTablaAmortizacion() {
		return tablaAmortizacion;
	}

	/**
	 * Establece tabla amortizacion.
	 *
	 * @param tablaAmortizacion a tabla amortizacion
	 */
	public void setTablaAmortizacion(AmortizacionOV[] tablaAmortizacion) {
		this.tablaAmortizacion = tablaAmortizacion;
	}

	/**
	 * Obtiene respuesta.
	 *
	 * @return the respuesta
	 */
	public EncabezadoRespuesta getRespuesta() {
		return respuesta;
	}

	/**
	 * Establece respuesta.
	 *
	 * @param respuesta the respuesta to set
	 */
	public void setRespuesta(EncabezadoRespuesta respuesta) {
		this.respuesta = respuesta;
	}

}
